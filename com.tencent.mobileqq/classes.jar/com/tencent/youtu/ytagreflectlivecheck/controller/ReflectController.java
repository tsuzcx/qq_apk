package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.IYTReflectListener;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectSettings;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
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
  private boolean mIsCanceled = false;
  private YTReflectLayout mReflectLayout;
  private YTAGReflectLiveCheckInterface.IYTReflectListener mReflectListener;
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
    try
    {
      Object localObject = ProcessManager.cameraWorker().mCamera;
      if (paramInt == 0)
      {
        this.pushYuvCount = 0;
        localParameters = ((Camera)localObject).getParameters();
        localParameters.setAutoWhiteBalanceLock(true);
        ((Camera)localObject).setParameters(localParameters);
        break label159;
      }
      if (paramInt == 1)
      {
        if (YTAGReflectLiveCheckInterface.mReflectNotice != null) {
          YTAGReflectLiveCheckInterface.mReflectNotice.onDelayCalc();
        }
        this.pushYuvCount = 0;
        System.currentTimeMillis();
        localParameters = ((Camera)localObject).getParameters();
      }
      if (paramInt != 2) {
        break label159;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        paramInt = localParameters.getExposureCompensation();
        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISObackup(paramInt);
        localParameters.setExposureCompensation(localParameters.getMinExposureCompensation());
        ((Camera)localObject).setParameters(localParameters);
        localObject = JNIUtils.getTimeval();
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
    Camera.Parameters localParameters = localException2.getParameters();
    localParameters.setExposureCompensation((int)YTAGReflectLiveCheckJNIInterface.getInstance().FRGetISObackup());
    localParameters.setAutoWhiteBalanceLock(false);
    localException2.setParameters(localParameters);
    label159:
    return true;
  }
  
  private void changeState(int paramInt)
  {
    if (ProcessManager.cameraWorker() == null) {
      YTLogger.e("YoutuLightLiveCheck", "changeState failed: Camera is released");
    }
    do
    {
      return;
      this.mState = paramInt;
      YTLogger.i("YoutuLightLiveCheck", "changeState. state: " + paramInt);
      cameraStateControl(paramInt);
      if (paramInt == 0)
      {
        this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
        this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
        this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
        ProcessManager.cameraWorker().setCameraPreviewCallback(new ReflectController.3(this));
        return;
      }
    } while (paramInt != 2);
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
    if (ProcessManager.cameraWorker() == null) {}
    int j;
    int k;
    label279:
    do
    {
      int m;
      int n;
      int i1;
      do
      {
        return;
        j = ProcessManager.cameraWorker().getDesiredPreviewWidth();
        k = ProcessManager.cameraWorker().getDesiredPreviewHeight();
        if (this.mState != 0) {
          break;
        }
        m = this.mConfigBegin - 3;
        n = this.mConfigEnd + 3;
        i1 = this.mFrame;
        YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + m + " endFrame: " + n + " currentFrame: " + i1);
      } while ((i1 <= m) || (i1 >= n));
      long l = System.currentTimeMillis();
      YTLogger.d("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
      systemTime = l;
      if (YTAGReflectLiveCheckInterface.getAGSettings().safetylevel == 2)
      {
        if (i == 0) {
          break label279;
        }
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, j, k);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
      }
      for (;;)
      {
        this.pushYuvCount += 1;
        return;
        if (this.pushYuvCount < 2)
        {
          YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert frame: " + this.pushYuvCount);
          break;
        }
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
        i = 0;
        break;
        YTLogger.i("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] rgba insert forbit: " + this.pushYuvCount);
      }
    } while (this.mState != 1);
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
    if (this.mReflectListener != null) {
      this.mReflectListener.onReflectEvent(paramColorMatrixColorFilter);
    }
    while (this.mReflectLayout == null) {
      return;
    }
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
    this.mIsCanceled = true;
  }
  
  /* Error */
  public void start(YTReflectLayout paramYTReflectLayout, YTAGReflectLiveCheckInterface.IYTReflectListener paramIYTReflectListener, ProcessManager.ProcessResult paramProcessResult, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 145	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectLayout	Lcom/tencent/youtu/ytagreflectlivecheck/ui/YTReflectLayout;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 409	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mReflectListener	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$IYTReflectListener;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 185	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   15: aload_0
    //   16: lload 4
    //   18: putfield 181	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mTag	J
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 131	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mIsCanceled	Z
    //   26: aload_0
    //   27: fconst_0
    //   28: putfield 123	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:redbef	F
    //   31: aload_0
    //   32: fconst_0
    //   33: putfield 125	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:greenbef	F
    //   36: aload_0
    //   37: fconst_0
    //   38: putfield 127	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:bluebef	F
    //   41: aload_0
    //   42: fconst_0
    //   43: putfield 129	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:alphabef	F
    //   46: invokestatic 478	com/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager:dataWorker	()Lcom/tencent/youtu/ytagreflectlivecheck/worker/DataWorker;
    //   49: getfield 483	com/tencent/youtu/ytagreflectlivecheck/worker/DataWorker:mRgbConfigCode	Ljava/lang/String;
    //   52: astore_2
    //   53: ldc 46
    //   55: new 305	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 485
    //   65: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokestatic 381	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getAGSettings	()Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings;
    //   71: getfield 386	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings:safetylevel	I
    //   74: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 322	com/tencent/youtu/ytcommon/tools/YTLogger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: new 487	org/json/JSONObject
    //   86: dup
    //   87: invokestatic 257	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:getInstance	()Lcom/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface;
    //   90: iconst_1
    //   91: aload_2
    //   92: invokestatic 381	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getAGSettings	()Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings;
    //   95: getfield 386	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectSettings:safetylevel	I
    //   98: invokevirtual 491	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:FRInit	(ZLjava/lang/String;I)Ljava/lang/String;
    //   101: invokespecial 494	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   104: astore_1
    //   105: aload_1
    //   106: ldc 17
    //   108: invokevirtual 498	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   111: istore 6
    //   113: aload_1
    //   114: ldc 26
    //   116: invokevirtual 498	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   119: istore 7
    //   121: aload_1
    //   122: ldc 14
    //   124: invokevirtual 502	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   127: astore_1
    //   128: aload_0
    //   129: iload 6
    //   131: iload 7
    //   133: aload_1
    //   134: invokespecial 504	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:startTimer	(IILorg/json/JSONArray;)V
    //   137: return
    //   138: astore_1
    //   139: ldc_w 506
    //   142: astore_2
    //   143: aload_1
    //   144: invokestatic 286	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   147: aload_0
    //   148: getfield 185	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   151: getstatic 82	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_CONFIG_DECODE_FAILED	I
    //   154: ldc_w 508
    //   157: new 305	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 510
    //   167: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_2
    //   171: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: lload 4
    //   179: invokeinterface 514 6 0
    //   184: return
    //   185: astore_1
    //   186: iconst_0
    //   187: istore 6
    //   189: iconst_0
    //   190: istore 7
    //   192: aload_1
    //   193: invokestatic 286	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   196: aload_0
    //   197: getfield 185	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   200: getstatic 86	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_GET_PARAMS_FAILED	I
    //   203: ldc_w 516
    //   206: new 305	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 306	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 518
    //   216: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_2
    //   220: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 319	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: lload 4
    //   228: invokeinterface 514 6 0
    //   233: aconst_null
    //   234: astore_1
    //   235: iload 7
    //   237: istore 8
    //   239: iload 6
    //   241: istore 7
    //   243: iload 8
    //   245: istore 6
    //   247: goto -119 -> 128
    //   250: astore_1
    //   251: aload_1
    //   252: invokestatic 286	com/tencent/youtu/ytcommon/tools/YTException:report	(Ljava/lang/Exception;)V
    //   255: aload_0
    //   256: invokespecial 471	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:innerCancel	()V
    //   259: aload_0
    //   260: getfield 185	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:mCheckResult	Lcom/tencent/youtu/ytagreflectlivecheck/manager/ProcessManager$ProcessResult;
    //   263: getstatic 88	com/tencent/youtu/ytagreflectlivecheck/controller/ReflectController:ERRCODE_START_FAILED	I
    //   266: ldc_w 520
    //   269: ldc_w 522
    //   272: lload 4
    //   274: invokeinterface 514 6 0
    //   279: return
    //   280: astore_1
    //   281: iconst_0
    //   282: istore 8
    //   284: iload 6
    //   286: istore 7
    //   288: iload 8
    //   290: istore 6
    //   292: goto -100 -> 192
    //   295: astore_1
    //   296: iload 6
    //   298: istore 8
    //   300: iload 7
    //   302: istore 6
    //   304: iload 8
    //   306: istore 7
    //   308: goto -116 -> 192
    //   311: astore_1
    //   312: goto -169 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ReflectController
    //   0	315	1	paramYTReflectLayout	YTReflectLayout
    //   0	315	2	paramIYTReflectListener	YTAGReflectLiveCheckInterface.IYTReflectListener
    //   0	315	3	paramProcessResult	ProcessManager.ProcessResult
    //   0	315	4	paramLong	long
    //   111	192	6	i	int
    //   119	188	7	j	int
    //   237	68	8	k	int
    // Exception table:
    //   from	to	target	type
    //   46	53	138	org/json/JSONException
    //   105	113	185	org/json/JSONException
    //   128	137	250	java/lang/Exception
    //   113	121	280	org/json/JSONException
    //   121	128	295	org/json/JSONException
    //   53	105	311	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.ReflectController
 * JD-Core Version:    0.7.0.1
 */