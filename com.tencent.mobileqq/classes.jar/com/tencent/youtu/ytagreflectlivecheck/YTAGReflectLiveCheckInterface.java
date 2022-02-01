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
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckInterface
{
  private static int ERRCODE_GET_ACTREFLECTDATA_FAILED = 0;
  private static int ERRCODE_JNI_DETECT_FAILED = 0;
  private static int ERRCODE_JSON_DECODE_FAILED = 0;
  private static int ERRCODE_NET_RETURN_PARSE_NULL = 0;
  private static int ERRCODE_UPLOAD_VIDEO_FAILED = 1;
  private static final String TAG = "YoutuLightLiveCheck";
  public static final String VERSION = "3.6.2";
  private static YTAGReflectLiveCheckInterface.GetLiveStyleResult getLiveStyleResultHandler = null;
  private static Lock initLock;
  public static YTAGReflectSettings mAGSettings;
  public static String mAppId;
  private static Camera mCamera;
  private static int mCameraRotated;
  private static YTAGReflectLiveCheckInterface.LightLiveCheckResult mCheckResult;
  private static String mColorSeq;
  private static TimerWorker mGetValueTimer;
  private static int mInitModel;
  private static int mOnGetValueCount;
  private static YTAGReflectLiveCheckInterface.IYTReflectListener mReflectListener;
  public static YTReflectNotice mReflectNotice;
  private static int mState;
  
  static
  {
    ERRCODE_JSON_DECODE_FAILED = 2;
    ERRCODE_JNI_DETECT_FAILED = 3;
    ERRCODE_GET_ACTREFLECTDATA_FAILED = 4;
    mAppId = "";
    mAGSettings = new YTAGReflectSettings();
    mInitModel = 0;
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
    int i = 1;
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- start");
    if (paramGetLiveStyleResult == null) {}
    for (;;)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.getLiveCheckType] --- finish. ret: " + i);
      return i;
      if (paramContext == null)
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
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(-1.0F, mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else if (i != 0)
        {
          if (getLiveStyleResultHandler != null)
          {
            getLiveStyleResultHandler.onSuccess(new LiveStyleRequester.YTLiveStyleReq(SensorManagerWorker.getInstance().getLux(), mAppId), new LiveStyleResponse());
            getLiveStyleResultHandler = null;
          }
          i = 0;
        }
        else
        {
          mGetValueTimer = new YTAGReflectLiveCheckInterface.2(3000L, 3000L);
          mGetValueTimer.start();
          i = 0;
        }
      }
    }
  }
  
  public static RawYuvData[] getRawYuvDatas()
  {
    return YTAGReflectLiveCheckJNIInterface.getInstance().FRGetRawYuvDatas();
  }
  
  public static YTAGReflectLiveCheckInterface.IYTReflectListener getReflectListener()
  {
    return mReflectListener;
  }
  
  public static int initModel(String paramString)
  {
    i = 0;
    for (;;)
    {
      try
      {
        initLock.lock();
        if (mInitModel > 0)
        {
          YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "initModel repeated calls.");
          mInitModel += 1;
        }
      }
      catch (Exception paramString)
      {
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "initModel failed. message: " + paramString.getMessage());
        i = -1;
        initLock.unlock();
        continue;
      }
      finally
      {
        initLock.unlock();
      }
      try
      {
        initLock.unlock();
        return i;
      }
      finally {}
      mAppId = paramString;
      if (paramString == null) {
        mAppId = "";
      }
    }
  }
  
  public static void onCameraChanged(int paramInt)
  {
    Log.d("YoutuLightLiveCheck", "on Camera changed " + paramInt);
    try
    {
      Camera.Parameters localParameters = mCamera.getParameters();
      localParameters.setExposureCompensation(paramInt);
      mCamera.setParameters(localParameters);
      return;
    }
    catch (Exception localException)
    {
      Log.e("YoutuLightLiveCheck", "on camera changed failed:" + localException.getLocalizedMessage());
    }
  }
  
  public static int[] onFetchCameraInfo()
  {
    for (;;)
    {
      try
      {
        localParameters = mCamera.getParameters();
        i = localParameters.getExposureCompensation();
        try
        {
          j = Integer.parseInt(localParameters.get("iso"));
          i = j;
        }
        catch (Exception localException4)
        {
          try
          {
            k = localParameters.getMinExposureCompensation();
            j = k;
          }
          catch (Exception localException1)
          {
            i = 0;
          }
          try
          {
            k = localParameters.getMaxExposureCompensation();
            m = i;
            i = j;
            Log.d("YoutuLightLiveCheck", "on fetch camera exp:" + m + " min:" + i + " max:" + k);
            return new int[] { m, i, k };
          }
          catch (Exception localException3)
          {
            k = i;
            i = j;
            j = k;
            continue;
          }
          localException4 = localException4;
          j = i;
          Log.e("YoutuLightLiveCheck", "on fectch camera compoensation failed:" + localException4.getLocalizedMessage());
          continue;
        }
        j = i;
      }
      catch (Exception localException2)
      {
        Camera.Parameters localParameters;
        int m;
        j = 0;
        i = 0;
        continue;
      }
      Log.e("YoutuLightLiveCheck", "on fectch camera info failed:" + localException1.getLocalizedMessage());
      k = 0;
      m = j;
    }
  }
  
  public static void onFinish()
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "on finished");
    int i = YTCameraSetting.getRotateTag(mCameraRotated, 1);
    i = YTAGReflectLiveCheckJNIInterface.getInstance().FRDoDetectionYuvs(false, i);
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "on finished " + i);
    if (i == 0)
    {
      FullPack localFullPack = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetAGin();
      mCheckResult.onSuccess(localFullPack);
      return;
    }
    mCheckResult.onFailed(-1, "JNI return failed.[" + i + "]", "Please make sure you have called the YTAGReflectLiveCheckInterface.onPreviewFrame during the hole reflecting process. Check log for more information. code: " + i);
  }
  
  public static void onScreenChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    ColorMatrixColorFilter localColorMatrixColorFilter = new ColorMatrixColorFilter(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, paramInt2, 0.0F, 0.0F, 0.0F, 0.0F, paramInt3, 0.0F, 0.0F, 0.0F, 0.0F, paramInt4, 0.0F, 0.0F, 0.0F, 0.0F, paramInt1 });
    if (mReflectListener == null)
    {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection screen change failed:mReflectListener is null");
      return;
    }
    mReflectListener.onReflectEvent(localColorMatrixColorFilter, paramFloat);
  }
  
  public static void onStateChanged(int paramInt)
  {
    mState = paramInt;
    Log.d("YoutuLightLiveCheck", "on state changed call " + mState);
    if (paramInt == 0) {}
    try
    {
      Camera.Parameters localParameters1 = mCamera.getParameters();
      localParameters1.setAutoWhiteBalanceLock(true);
      mCamera.setParameters(localParameters1);
      return;
    }
    catch (Exception localException)
    {
      Log.e("YoutuLightLiveCheck", "on state changed failed:" + localException.getLocalizedMessage());
      return;
    }
    if (paramInt == 1)
    {
      if (mReflectNotice != null) {
        mReflectNotice.onDelayCalc();
      }
    }
    else if (paramInt == 2)
    {
      Camera.Parameters localParameters2 = mCamera.getParameters();
      localParameters2.setAutoWhiteBalanceLock(false);
      mCamera.setParameters(localParameters2);
      onFinish();
    }
  }
  
  public static void pushImageData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (mState == 0)
    {
      i = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin() - 2;
      j = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd() + 2;
      k = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetTriggerTime();
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "onPreviewFrameReceived. beginFrame: " + i + " endFrame: " + j + " currentFrame: " + k);
      if ((k > i) && (k < j))
      {
        System.currentTimeMillis();
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "onPreviewFrameReceived. insertYuv and time");
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(paramArrayOfByte, paramInt1, paramInt2, paramLong, paramInt3, paramArrayOfFloat);
        YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval(paramLong));
      }
    }
    while (mState != 1)
    {
      int i;
      int j;
      int k;
      return;
    }
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[ReflectController.onPreviewFrameReceived] record ios");
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(paramArrayOfByte, paramInt1, paramInt2);
    YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval(paramLong));
  }
  
  /* Error */
  public static void releaseModel()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 70	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   6: invokeinterface 199 1 0
    //   11: getstatic 65	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   14: iconst_1
    //   15: isub
    //   16: putstatic 65	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   19: getstatic 65	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   22: ifgt +35 -> 57
    //   25: iconst_0
    //   26: putstatic 65	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mInitModel	I
    //   29: aconst_null
    //   30: putstatic 337	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectNotice	Lcom/tencent/youtu/ytagreflectlivecheck/notice/YTReflectNotice;
    //   33: aconst_null
    //   34: putstatic 190	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mReflectListener	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$IYTReflectListener;
    //   37: getstatic 83	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   40: ifnull +13 -> 53
    //   43: getstatic 83	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   46: invokevirtual 397	com/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker:cancel	()V
    //   49: aconst_null
    //   50: putstatic 83	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:mGetValueTimer	Lcom/tencent/youtu/ytagreflectlivecheck/worker/TimerWorker;
    //   53: aconst_null
    //   54: putstatic 72	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:getLiveStyleResultHandler	Lcom/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface$GetLiveStyleResult;
    //   57: getstatic 70	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   60: invokeinterface 204 1 0
    //   65: invokestatic 400	com/tencent/youtu/ytagreflectlivecheck/jni/YTAGReflectLiveCheckJNIInterface:clearInstance	()V
    //   68: ldc 2
    //   70: monitorexit
    //   71: return
    //   72: astore_0
    //   73: getstatic 70	com/tencent/youtu/ytagreflectlivecheck/YTAGReflectLiveCheckInterface:initLock	Ljava/util/concurrent/locks/Lock;
    //   76: invokeinterface 204 1 0
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   72	10	0	localObject1	Object
    //   83	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	53	72	finally
    //   53	57	72	finally
    //   57	68	83	finally
    //   73	83	83	finally
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
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.setSafetyLevel] --- level: " + paramInt);
    mAGSettings.safetylevel = paramInt;
  }
  
  public static void start(Context paramContext, Camera paramCamera, int paramInt, String paramString, YTAGReflectLiveCheckInterface.LightLiveCheckResult paramLightLiveCheckResult)
  {
    YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "[YTAGReflectLiveCheckInterface.start] ---");
    if (paramLightLiveCheckResult == null) {
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:checkResult is null");
    }
    do
    {
      return;
      mCheckResult = paramLightLiveCheckResult;
      if (mInitModel <= 0)
      {
        mCheckResult.onFailed(2, "Not init model.", "Call YTAGReflectLiveCheckInterface.initModel() before.");
        return;
      }
      mCameraRotated = YTCameraSetting.getVideoRotate(paramContext, paramInt);
      mColorSeq = paramString;
      mCamera = paramCamera;
      paramContext = new long[2];
      float f = -1.0F;
      if (mReflectListener == null) {
        YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "On reflection start failed:mReflectListener is null");
      }
      if (mReflectListener != null) {
        f = mReflectListener.onGetAppBrightness();
      }
      YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(false, paramString, mAGSettings.safetylevel, paramContext, f);
      YTAGReflectLiveCheckJNIInterface.nativeLog("YoutuLightLiveCheck", "output duration ms" + paramContext[0] + " " + paramContext[1]);
    } while (mReflectListener == null);
    mReflectListener.onReflectStart(paramContext[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface
 * JD-Core Version:    0.7.0.1
 */