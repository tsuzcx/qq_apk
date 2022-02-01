package com.tencent.youtu.ytagreflectlivecheck;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.notice.YTReflectNotice;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleResponse;
import com.tencent.youtu.ytagreflectlivecheck.worker.SensorManagerWorker;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckInterface
{
  private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
  private static int ERRCODE_JNI_DETECT_FAILED = 3;
  private static int ERRCODE_JSON_DECODE_FAILED = 2;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.6.8";
  private static YTAGReflectLiveCheckInterface.GetLiveStyleResult getLiveStyleResultHandler = null;
  private static Lock initLock;
  public static YTAGReflectSettings mAGSettings = new YTAGReflectSettings();
  public static String mAppId = "";
  private static Camera mCamera;
  private static int mCameraRotatedTag;
  private static YTAGReflectLiveCheckInterface.LightLiveCheckResult mCheckResult;
  private static String mColorSeq;
  private static TimerWorker mGetValueTimer;
  private static int mInitModel = 0;
  private static int mOnGetValueCount;
  private static YTAGReflectLiveCheckInterface.IYTReflectListener mReflectListener;
  public static YTReflectNotice mReflectNotice;
  private static int mState;
  
  static
  {
    initLock = new ReentrantLock();
  }
  
  public static void cancel()
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.cancel] --- ");
    YTAGReflectLiveCheckJNIInterface.getInstance().FRRelease();
  }
  
  public static YTAGReflectSettings getAGSettings()
  {
    return mAGSettings;
  }
  
  public static int getLiveCheckType(Context paramContext, YTAGReflectLiveCheckInterface.GetLiveStyleResult paramGetLiveStyleResult)
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
    int j = 0;
    int i;
    if (paramGetLiveStyleResult == null)
    {
      i = 1;
    }
    else if (paramContext == null)
    {
      paramGetLiveStyleResult.onFailed(1, "Input context is null.", "You can try to input getActivity().getApplicationContext() and test again.");
      i = 2;
    }
    else
    {
      if (getLiveStyleResultHandler != null) {
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] repeated calls. this may cause the previous call lost callback.");
      }
      getLiveStyleResultHandler = paramGetLiveStyleResult;
      mOnGetValueCount = 0;
      i = SensorManagerWorker.getInstance().start(paramContext, new YTAGReflectLiveCheckInterface.1());
      if (i == 1)
      {
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] Can't find light sensor.");
        paramContext = getLiveStyleResultHandler;
        i = j;
        if (paramContext != null)
        {
          paramContext.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-1.0F, mAppId), new LiveStyleResponse());
          getLiveStyleResultHandler = null;
          i = j;
        }
      }
      else if (i != 0)
      {
        paramContext = getLiveStyleResultHandler;
        i = j;
        if (paramContext != null)
        {
          paramContext.onSuccess(new LiveStyleRequester.YTLiveStyleReq(SensorManagerWorker.getInstance().getLux(), mAppId), new LiveStyleResponse());
          getLiveStyleResultHandler = null;
          i = j;
        }
      }
      else
      {
        mGetValueTimer = new YTAGReflectLiveCheckInterface.2(3000L, 3000L);
        mGetValueTimer.start();
        i = j;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: ");
    paramContext.append(i);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", paramContext.toString());
    return i;
  }
  
  public static RawYuvData[] getRawYuvDatas()
  {
    return YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
  }
  
  public static YTAGReflectLiveCheckInterface.IYTReflectListener getReflectListener()
  {
    return mReflectListener;
  }
  
  /* Error */
  public static int initModel(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore_1
    //   5: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   8: invokeinterface 193 1 0
    //   13: getstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   16: ifle +13 -> 29
    //   19: ldc 19
    //   21: ldc 195
    //   23: invokestatic 90	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:nativeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: goto +16 -> 42
    //   29: aload_0
    //   30: putstatic 134	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mAppId	Ljava/lang/String;
    //   33: aload_0
    //   34: ifnonnull +8 -> 42
    //   37: ldc 31
    //   39: putstatic 134	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mAppId	Ljava/lang/String;
    //   42: getstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   45: iconst_1
    //   46: iadd
    //   47: putstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   50: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   53: astore_0
    //   54: aload_0
    //   55: invokeinterface 198 1 0
    //   60: goto +50 -> 110
    //   63: astore_0
    //   64: goto +51 -> 115
    //   67: astore_0
    //   68: new 161	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   75: astore_2
    //   76: aload_2
    //   77: ldc 200
    //   79: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_2
    //   84: aload_0
    //   85: invokevirtual 203	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   88: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 19
    //   94: aload_2
    //   95: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 90	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:nativeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iconst_m1
    //   102: istore_1
    //   103: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   106: astore_0
    //   107: goto -53 -> 54
    //   110: ldc 2
    //   112: monitorexit
    //   113: iload_1
    //   114: ireturn
    //   115: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   118: invokeinterface 198 1 0
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: goto +5 -> 134
    //   132: aload_0
    //   133: athrow
    //   134: goto -2 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString	String
    //   4	110	1	i	int
    //   75	20	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	26	63	finally
    //   29	33	63	finally
    //   37	42	63	finally
    //   42	50	63	finally
    //   68	101	63	finally
    //   5	26	67	java/lang/Exception
    //   29	33	67	java/lang/Exception
    //   37	42	67	java/lang/Exception
    //   42	50	67	java/lang/Exception
    //   50	54	125	finally
    //   54	60	125	finally
    //   103	107	125	finally
    //   115	125	125	finally
  }
  
  public static void onCameraChanged(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("on Camera changed ");
    ((StringBuilder)localObject).append(paramInt);
    Log.d("YoutuLightLiveCheck", ((StringBuilder)localObject).toString());
    try
    {
      localObject = mCamera.getParameters();
      ((Camera.Parameters)localObject).setExposureCompensation(paramInt);
      mCamera.setParameters((Camera.Parameters)localObject);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("on camera changed failed:");
      localStringBuilder.append(localException.getLocalizedMessage());
      Log.e("YoutuLightLiveCheck", localStringBuilder.toString());
    }
  }
  
  /* Error */
  public static int[] onFetchCameraInfo()
  {
    // Byte code:
    //   0: getstatic 215	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mCamera	Landroid/hardware/Camera;
    //   3: invokevirtual 221	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   6: astore 4
    //   8: aload 4
    //   10: invokevirtual 243	android/hardware/Camera$Parameters:getExposureCompensation	()I
    //   13: istore_0
    //   14: aload 4
    //   16: ldc 245
    //   18: invokevirtual 249	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   21: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   24: istore_1
    //   25: iload_1
    //   26: istore_0
    //   27: goto +53 -> 80
    //   30: astore 5
    //   32: iload_0
    //   33: istore_1
    //   34: new 161	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   41: astore 6
    //   43: iload_0
    //   44: istore_1
    //   45: aload 6
    //   47: ldc_w 256
    //   50: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: iload_0
    //   55: istore_1
    //   56: aload 6
    //   58: aload 5
    //   60: invokevirtual 235	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   63: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: iload_0
    //   68: istore_1
    //   69: ldc 19
    //   71: aload 6
    //   73: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 238	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   79: pop
    //   80: iload_0
    //   81: istore_1
    //   82: aload 4
    //   84: invokevirtual 259	android/hardware/Camera$Parameters:getMinExposureCompensation	()I
    //   87: istore_2
    //   88: aload 4
    //   90: invokevirtual 262	android/hardware/Camera$Parameters:getMaxExposureCompensation	()I
    //   93: istore_1
    //   94: goto +69 -> 163
    //   97: astore 4
    //   99: iload_2
    //   100: istore_1
    //   101: goto +16 -> 117
    //   104: astore 4
    //   106: iload_1
    //   107: istore_0
    //   108: goto +7 -> 115
    //   111: astore 4
    //   113: iconst_0
    //   114: istore_0
    //   115: iconst_0
    //   116: istore_1
    //   117: new 161	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   124: astore 5
    //   126: aload 5
    //   128: ldc_w 264
    //   131: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 5
    //   137: aload 4
    //   139: invokevirtual 235	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   142: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 19
    //   148: aload 5
    //   150: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 238	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   156: pop
    //   157: iconst_0
    //   158: istore_3
    //   159: iload_1
    //   160: istore_2
    //   161: iload_3
    //   162: istore_1
    //   163: new 161	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   170: astore 4
    //   172: aload 4
    //   174: ldc_w 266
    //   177: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 4
    //   183: iload_0
    //   184: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: ldc_w 268
    //   193: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 4
    //   199: iload_2
    //   200: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: ldc_w 270
    //   209: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: iload_1
    //   216: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: ldc 19
    //   222: aload 4
    //   224: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 213	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: iconst_3
    //   232: newarray int
    //   234: dup
    //   235: iconst_0
    //   236: iload_0
    //   237: iastore
    //   238: dup
    //   239: iconst_1
    //   240: iload_2
    //   241: iastore
    //   242: dup
    //   243: iconst_2
    //   244: iload_1
    //   245: iastore
    //   246: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	224	0	i	int
    //   24	221	1	j	int
    //   87	154	2	k	int
    //   158	4	3	m	int
    //   6	83	4	localParameters	Camera.Parameters
    //   97	1	4	localException1	Exception
    //   104	1	4	localException2	Exception
    //   111	27	4	localException3	Exception
    //   170	53	4	localStringBuilder1	StringBuilder
    //   30	29	5	localException4	Exception
    //   124	25	5	localStringBuilder2	StringBuilder
    //   41	31	6	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	25	30	java/lang/Exception
    //   88	94	97	java/lang/Exception
    //   34	43	104	java/lang/Exception
    //   45	54	104	java/lang/Exception
    //   56	67	104	java/lang/Exception
    //   69	80	104	java/lang/Exception
    //   82	88	104	java/lang/Exception
    //   0	14	111	java/lang/Exception
  }
  
  public static void onFinish()
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "on finished");
    int i = mCameraRotatedTag;
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("on finished ");
    ((StringBuilder)localObject1).append(i);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", ((StringBuilder)localObject1).toString());
    if (i == 0)
    {
      localObject1 = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
      mCheckResult.onSuccess((FullPack)localObject1);
      return;
    }
    localObject1 = mCheckResult;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("JNI return failed.[");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("]");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: ");
    localStringBuilder.append(i);
    ((YTAGReflectLiveCheckInterface.LightLiveCheckResult)localObject1).onFailed(-1, (String)localObject2, localStringBuilder.toString());
  }
  
  public static void onScreenChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    ColorMatrixColorFilter localColorMatrixColorFilter = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, 0.0F, 0.0F, 0.0F, 0.0F, paramInt3, 0.0F, 0.0F, 0.0F, 0.0F, paramInt4, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1 });
    YTAGReflectLiveCheckInterface.IYTReflectListener localIYTReflectListener = mReflectListener;
    if (localIYTReflectListener == null)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection screen change failed:mReflectListener is null");
      return;
    }
    localIYTReflectListener.onReflectEvent(localColorMatrixColorFilter, paramFloat);
  }
  
  public static void onStateChanged(int paramInt)
  {
    mState = paramInt;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("on state changed call ");
    ((StringBuilder)localObject1).append(mState);
    Log.d("YoutuLightLiveCheck", ((StringBuilder)localObject1).toString());
    if (paramInt == 0) {}
    try
    {
      localObject1 = mCamera.getParameters();
      ((Camera.Parameters)localObject1).setAutoWhiteBalanceLock(true);
      mCamera.setParameters((Camera.Parameters)localObject1);
      return;
    }
    catch (Exception localException)
    {
      label110:
      Object localObject2;
      break label110;
    }
    if (paramInt == 1)
    {
      if (mReflectNotice != null) {
        mReflectNotice.onDelayCalc();
      }
    }
    else if (paramInt == 2)
    {
      localObject1 = mCamera.getParameters();
      ((Camera.Parameters)localObject1).setAutoWhiteBalanceLock(false);
      mCamera.setParameters((Camera.Parameters)localObject1);
      onFinish();
      return;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("on state changed failed:");
      ((StringBuilder)localObject1).append(localObject2.getLocalizedMessage());
      Log.e("YoutuLightLiveCheck", ((StringBuilder)localObject1).toString());
    }
  }
  
  public static void pushImageData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = mState;
    if (i == 0)
    {
      i = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
      int j = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 4;
      int k = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPreviewFrameReceived. beginFrame: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" endFrame: ");
      localStringBuilder.append(j);
      localStringBuilder.append(" currentFrame: ");
      localStringBuilder.append(k);
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", localStringBuilder.toString());
      if ((k > i) && (k < j))
      {
        System.currentTimeMillis();
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3, paramArrayOfFloat);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval(paramLong));
      }
    }
    else if (i == 1)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] record ios");
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, paramInt1, paramInt2);
      YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval(paramLong));
    }
  }
  
  /* Error */
  public static void releaseModel()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 193 1 0
    //   11: getstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   14: iconst_1
    //   15: isub
    //   16: putstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   19: getstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   22: ifgt +39 -> 61
    //   25: iconst_0
    //   26: putstatic 57	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   29: aconst_null
    //   30: putstatic 325	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectNotice	Lcom/tencent/youtu/ytagreflectlivecheck/notice/YTReflectNotice;
    //   33: aconst_null
    //   34: putstatic 184	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectListener	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$IYTReflectListener;
    //   37: getstatic 75	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   40: ifnull +13 -> 53
    //   43: getstatic 75	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   46: invokevirtual 385	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:cancel	()V
    //   49: aconst_null
    //   50: putstatic 75	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   53: aconst_null
    //   54: putstatic 64	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getLiveStyleResultHandler	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$GetLiveStyleResult;
    //   57: aconst_null
    //   58: putstatic 215	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mCamera	Landroid/hardware/Camera;
    //   61: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   64: invokeinterface 198 1 0
    //   69: invokestatic 388	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:clearInstance	()V
    //   72: ldc 2
    //   74: monitorexit
    //   75: return
    //   76: astore_0
    //   77: getstatic 62	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   80: invokeinterface 198 1 0
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	10	0	localObject1	Object
    //   87	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	53	76	finally
    //   53	61	76	finally
    //   61	72	87	finally
    //   77	87	87	finally
  }
  
  public static void setAGSettings(YTAGReflectSettings paramYTAGReflectSettings)
  {
    mAGSettings = paramYTAGReflectSettings;
  }
  
  public static void setReflectListener(YTAGReflectLiveCheckInterface.IYTReflectListener paramIYTReflectListener)
  {
    mReflectListener = paramIYTReflectListener;
  }
  
  public static void setReflectNotice(YTReflectNotice paramYTReflectNotice)
  {
    mReflectNotice = paramYTReflectNotice;
  }
  
  public static void setSafetyLevel(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: ");
    localStringBuilder.append(paramInt);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", localStringBuilder.toString());
    mAGSettings.safetylevel = paramInt;
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, String paramString, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    if (paramLightLiveCheckResult == null)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:checkResult is null");
      return;
    }
    mCheckResult = paramLightLiveCheckResult;
    if (mInitModel <= 0)
    {
      mCheckResult.onFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
      return;
    }
    mCameraRotatedTag = paramInt;
    mColorSeq = paramString;
    mCamera = paramCamera;
    paramContext = new long[2];
    if (mReflectListener == null) {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:mReflectListener is null");
    }
    paramCamera = mReflectListener;
    float f;
    if (paramCamera != null) {
      f = paramCamera.onGetAppBrightness();
    } else {
      f = -1.0F;
    }
    YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, paramString, mAGSettings.safetylevel, paramContext, f);
    paramCamera = new StringBuilder();
    paramCamera.append("output duration ms");
    paramCamera.append(paramContext[0]);
    paramCamera.append(" ");
    paramCamera.append(paramContext[1]);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", paramCamera.toString());
    paramCamera = mReflectListener;
    if (paramCamera != null) {
      paramCamera.onReflectStart(paramContext[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */