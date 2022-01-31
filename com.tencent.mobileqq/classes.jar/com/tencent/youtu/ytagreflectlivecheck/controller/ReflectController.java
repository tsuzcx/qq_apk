package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.CameraWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import org.json.JSONArray;

public class ReflectController
{
  private static final String CONFIG_ALPHA = "A";
  private static final String CONFIG_BLUE = "B";
  private static final String CONFIG_CONFIGS = "configs";
  private static final String CONFIG_DURATION = "duration";
  private static final String CONFIG_GREEN = "G";
  private static final String CONFIG_RED = "R";
  private static final String CONFIG_UNIT = "unit";
  public static final ColorMatrixColorFilter DEFAULT_MATRIX_COLOR_FILTER = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
  private static final int DELAY_TIME = 400;
  private static int ERRCODE_CONFIG_DECODE_FAILED = 0;
  private static int ERRCODE_FINISH_FAILED = 0;
  private static int ERRCODE_GET_PARAMS_FAILED = 0;
  private static int ERRCODE_START_FAILED = 0;
  private static int ERRCODE_USER_CANCEL = 1;
  private static int ERRCODE_USER_CANCELED = 0;
  private static final int STATE_DETECT_DELAY = 1;
  private static final int STATE_END = 2;
  private static final int STATE_RGB_CHANGE = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  private static final long deltaTimeThreshold = 30L;
  private static long systemTime;
  private float alphabef = 0.0F;
  private float bluebef = 0.0F;
  private float greenbef = 0.0F;
  private ProcessManager.ProcessResult mCheckResult;
  private int mConfigBegin = 0;
  private int mConfigEnd = 0;
  private int mConfigPoint = 0;
  private TimerWorker mCountDownTimer;
  private int mFrame = 0;
  private YTReflectLayout mReflectLayout;
  private int mState;
  private long mTag;
  private int pushYuvCount = 0;
  private float redbef = 0.0F;
  private long time_finish_begin = 0L;
  private long time_finish_end = 0L;
  private long time_now = 0L;
  private long time_pre = 0L;
  private long time_start = 0L;
  
  static
  {
    ERRCODE_GET_PARAMS_FAILED = 2;
    ERRCODE_START_FAILED = 3;
    ERRCODE_FINISH_FAILED = 4;
    ERRCODE_USER_CANCELED = 5;
    systemTime = System.currentTimeMillis();
  }
  
  private boolean cameraStateControl(int paramInt)
  {
    Object localObject = ProcessManager.cameraWorker().mCamera;
    if (paramInt == 0) {}
    Camera.Parameters localParameters;
    try
    {
      this.pushYuvCount = 0;
      localParameters = ((Camera)localObject).getParameters();
      localParameters.setAutoWhiteBalanceLock(true);
      ((Camera)localObject).setParameters(localParameters);
    }
    catch (Exception localException1)
    {
      try
      {
        paramInt = localParameters.getExposureCompensation();
        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISObackup(paramInt);
        localParameters.setExposureCompensation(localParameters.getMinExposureCompensation());
        ((Camera)localObject).setParameters(localParameters);
        long l = System.nanoTime() / 1000L;
        localObject = new Timeval(l / 1000000L, (int)(l % 1000000L));
        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISOchangeTime((Timeval)localObject);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetDoingDelayCalc(true);
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return false;
      }
      localException1 = localException1;
      YTException.report(localException1);
      return false;
    }
    if (paramInt == 1)
    {
      this.pushYuvCount = 0;
      System.currentTimeMillis();
      localParameters = ((Camera)localObject).getParameters();
    }
    if (paramInt == 2)
    {
      localParameters = localException2.getParameters();
      localParameters.setExposureCompensation((int)YTAGReflectLiveCheckJNIInterface.getInstance().FRGetISObackup());
      localParameters.setAutoWhiteBalanceLock(false);
      localException2.setParameters(localParameters);
    }
    return true;
  }
  
  private void changeState(int paramInt)
  {
    this.mState = paramInt;
    YTLogger.i("YoutuLightLiveCheck", "changeState. state: " + paramInt);
    cameraStateControl(paramInt);
    if (paramInt == 0)
    {
      this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
      this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
      this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
      ProcessManager.cameraWorker().setCameraPreviewCallback(new ReflectController.3(this));
    }
    while (paramInt != 2) {
      return;
    }
    YTLogger.i("mCountDownTimer", "cameraStateControl:" + (System.currentTimeMillis() - this.time_finish_begin));
    ProcessManager.cameraWorker().setCameraPreviewCallback(null);
    YTLogger.i("mCountDownTimer", "setCameraPreviewCallback:" + (System.currentTimeMillis() - this.time_finish_begin));
    this.time_finish_end = System.currentTimeMillis();
    YTLogger.i("mCountDownTimer", "onFinish. to finish: " + (this.time_finish_begin - this.time_start) + " to finish_end: " + (this.time_finish_end - this.time_finish_begin));
    this.mCheckResult.onSuccess(this.mTag);
  }
  
  private void innerCancel()
  {
    if (this.mState == 0) {
      setColorMatrixColorFilter(DEFAULT_MATRIX_COLOR_FILTER);
    }
  }
  
  private void onPreviewFrameReceived(byte[] paramArrayOfByte, Camera paramCamera)
  {
    int i = 1;
    int j = ProcessManager.cameraWorker().getDesiredPreviewWidth();
    int k = ProcessManager.cameraWorker().getDesiredPreviewHeight();
    if (this.mState == 0)
    {
      m = this.mConfigBegin - 3;
      n = this.mConfigEnd + 3;
      i1 = this.mFrame;
      YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + m + " endFrame: " + n + " currentFrame: " + i1);
      if ((i1 > m) && (i1 < n))
      {
        l = System.currentTimeMillis();
        YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        systemTime = l;
        if (YTAGReflectLiveCheckInterface.mSafetylevel != 2) {
          break label197;
        }
        if (i == 0) {
          break label269;
        }
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, j, k);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
        this.pushYuvCount += 1;
      }
    }
    label197:
    while (this.mState != 1) {
      for (;;)
      {
        int m;
        int n;
        int i1;
        long l;
        return;
        if (this.pushYuvCount < 2)
        {
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
        }
        else
        {
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
          i = 0;
          continue;
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
        }
      }
    }
    label269:
    YTLogger.d("YoutuLightLiveCheck", "put IOS timeval ");
    if (this.pushYuvCount < 5)
    {
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, j, k);
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
      this.pushYuvCount += 1;
      YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] record ios");
    }
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, j, k);
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval());
  }
  
  private void setColorMatrixColorFilter(ColorMatrixColorFilter paramColorMatrixColorFilter)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.mReflectLayout.setColorMatrixColorFilter(paramColorMatrixColorFilter);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ReflectController.1(this, paramColorMatrixColorFilter));
  }
  
  private void startTimer(int paramInt1, int paramInt2, JSONArray paramJSONArray)
  {
    YTLogger.i("YoutuLightLiveCheck", "start timer.");
    changeState(0);
    this.mFrame = 0;
    YTLogger.i("mCountDownTimer", "duration:" + paramInt1 + " unit: " + paramInt2);
    this.time_pre = System.currentTimeMillis();
    this.time_start = this.time_pre;
    this.mCountDownTimer = new ReflectController.2(this, paramInt1, paramInt2, paramInt2, paramJSONArray);
    this.mCountDownTimer.start();
  }
  
  private void stopTimer()
  {
    if (this.mCountDownTimer != null)
    {
      this.mCountDownTimer.cancel();
      this.mCountDownTimer = null;
    }
  }
  
  public void cancel()
  {
    innerCancel();
    stopTimer();
  }
  
  /* Error */
  public void start(YTReflectLayout paramYTReflectLayout, ProcessManager.ProcessResult paramProcessResult, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 139	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectLayout	Lcom/tencent/youtu/ytagreflectlivecheck/ui/YTReflectLayout;
    //   8: aload_0
    //   9: aload_2
    //   10: putfield 177	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   13: aload_0
    //   14: lload_3
    //   15: putfield 173	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mTag	J
    //   18: aload_0
    //   19: fconst_0
    //   20: putfield 119	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:redbef	F
    //   23: aload_0
    //   24: fconst_0
    //   25: putfield 121	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:greenbef	F
    //   28: aload_0
    //   29: fconst_0
    //   30: putfield 123	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:bluebef	F
    //   33: aload_0
    //   34: fconst_0
    //   35: putfield 125	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:alphabef	F
    //   38: invokestatic 455	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:dataWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/DataWorker;
    //   41: getfield 460	com/tencent/youtu/ytagreflectlivecheck/worker/DataWorker:mRgbConfigCode	Ljava/lang/String;
    //   44: astore_2
    //   45: ldc 46
    //   47: new 284	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 462
    //   57: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 364	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mSafetylevel	I
    //   63: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 304	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: new 464	org/json/JSONObject
    //   75: dup
    //   76: invokestatic 238	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   79: iconst_1
    //   80: aload_2
    //   81: getstatic 364	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mSafetylevel	I
    //   84: invokevirtual 468	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRInit	(ZLjava/lang/String;I)Ljava/lang/String;
    //   87: invokespecial 471	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: aload_1
    //   92: ldc 17
    //   94: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   97: istore 5
    //   99: aload_1
    //   100: ldc 26
    //   102: invokevirtual 475	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   105: istore 7
    //   107: iload 7
    //   109: istore 6
    //   111: aload_1
    //   112: ldc 14
    //   114: invokevirtual 479	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   117: astore_1
    //   118: aload_0
    //   119: iload 5
    //   121: iload 7
    //   123: aload_1
    //   124: invokespecial 481	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:startTimer	(IILorg/json/JSONArray;)V
    //   127: return
    //   128: astore_1
    //   129: aload_1
    //   130: invokestatic 273	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   133: aload_0
    //   134: getfield 177	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   137: getstatic 78	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_CONFIG_DECODE_FAILED	I
    //   140: ldc_w 483
    //   143: new 284	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 485
    //   153: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_2
    //   157: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: lload_3
    //   164: invokeinterface 489 6 0
    //   169: return
    //   170: astore_1
    //   171: iconst_0
    //   172: istore 6
    //   174: iconst_0
    //   175: istore 5
    //   177: aload_1
    //   178: invokestatic 273	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   181: aload_0
    //   182: getfield 177	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   185: getstatic 82	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_GET_PARAMS_FAILED	I
    //   188: ldc_w 491
    //   191: new 284	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 285	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 493
    //   201: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_2
    //   205: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: lload_3
    //   212: invokeinterface 489 6 0
    //   217: aconst_null
    //   218: astore_1
    //   219: iload 6
    //   221: istore 7
    //   223: goto -105 -> 118
    //   226: astore_1
    //   227: aload_1
    //   228: invokestatic 273	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   231: aload_0
    //   232: invokespecial 448	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:innerCancel	()V
    //   235: aload_0
    //   236: getfield 177	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   239: getstatic 84	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_START_FAILED	I
    //   242: ldc_w 495
    //   245: ldc_w 497
    //   248: lload_3
    //   249: invokeinterface 489 6 0
    //   254: return
    //   255: astore_1
    //   256: goto -79 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	ReflectController
    //   0	259	1	paramYTReflectLayout	YTReflectLayout
    //   0	259	2	paramProcessResult	ProcessManager.ProcessResult
    //   0	259	3	paramLong	long
    //   97	79	5	i	int
    //   1	219	6	j	int
    //   105	117	7	k	int
    // Exception table:
    //   from	to	target	type
    //   45	91	128	org/json/JSONException
    //   91	99	170	org/json/JSONException
    //   118	127	226	java/lang/Exception
    //   99	107	255	org/json/JSONException
    //   111	118	255	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController
 * JD-Core Version:    0.7.0.1
 */