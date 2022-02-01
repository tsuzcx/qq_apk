package com.tencent.youtu.sdkkitframework.framework;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG = YtSDKKitFramework.class.getSimpleName();
  private static YtSDKKitFramework instance;
  private static final String version = "1.0.8.42";
  private Rect detectRect = new Rect(20, 270, 700, 1200);
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private int networkRequestTimeoutMS = 60000;
  private Rect previewRect = new Rect(0, 0, 720, 1280);
  
  public static void clearInstance()
  {
    try
    {
      instance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static YtSDKKitFramework getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new YtSDKKitFramework();
      }
      YtSDKKitFramework localYtSDKKitFramework = instance;
      return localYtSDKKitFramework;
    }
    finally {}
  }
  
  private YtFSMBaseState parseStateFrom(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      YtFSMBaseState localYtFSMBaseState = (YtFSMBaseState)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      YtLogger.e(TAG, "Parse state " + paramString + "failed:" + localThrowable1.getMessage());
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        localYtFSMBaseState.loadStateWith(paramString, paramJSONObject);
        return localYtFSMBaseState;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          paramJSONObject = localThrowable1;
          Object localObject = localThrowable2;
        }
      }
      localThrowable1 = localThrowable1;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  public int deInit()
  {
    YTLogger.i(TAG, "sdkkit framework 1.0.8.42 deinit");
    YtSDKKitNetHelper.clearInstance();
    YtFSM.getInstance().stop();
    YtFSM.clearInstance();
    YtSDKStats.getInstance().exitState();
    YtSDKStats.clearInstance();
    return 0;
  }
  
  public void doPause()
  {
    YtFSM.getInstance().handlePauseEvent();
  }
  
  public void doResume()
  {
    YtFSM.getInstance().handleResumeEvent();
  }
  
  public void fireEvent(YtSDKKitFramework.YtFrameworkFireEventType paramYtFrameworkFireEventType, Object paramObject)
  {
    YtFSM.getInstance().handleEvent(paramYtFrameworkFireEventType, paramObject);
  }
  
  public Rect getDetectRect()
  {
    return this.detectRect;
  }
  
  public int getNetworkRequestTimeoutMS()
  {
    return this.networkRequestTimeoutMS;
  }
  
  public YtSDKKitFramework.YtSDKPlatformContext getPlatformContext()
  {
    return YtFSM.getInstance().getContext();
  }
  
  public Rect getPreviewRect()
  {
    return this.previewRect;
  }
  
  public int init(YtSDKKitFramework.YtSDKPlatformContext paramYtSDKPlatformContext, JSONObject paramJSONObject, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, ArrayList<String> paramArrayList, YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    YTLogger.i(TAG, "sdkkit framework 1.0.8.42 init");
    if (paramYtSDKPlatformContext == null)
    {
      YtLogger.e(TAG, "Context cannot be null");
      return -1;
    }
    if (paramArrayList.isEmpty())
    {
      YtLogger.e(TAG, "Pipeline state name cannot be empty");
      return -1;
    }
    if (paramIYtSDKKitFrameworkEventListener == null)
    {
      YtLogger.e(TAG, "Event listener cannot be null");
      return -1;
    }
    YtFSM.getInstance().stop();
    YtFSM.getInstance().setEventListener(paramIYtSDKKitFrameworkEventListener);
    YtFSM.getInstance().setContext(paramYtSDKPlatformContext);
    paramYtSDKPlatformContext = paramArrayList.iterator();
    while (paramYtSDKPlatformContext.hasNext())
    {
      paramIYtSDKKitFrameworkEventListener = parseStateFrom((String)paramYtSDKPlatformContext.next(), paramJSONObject);
      YtFSM.getInstance().registerState(paramIYtSDKKitFrameworkEventListener);
    }
    if (paramJSONObject.has("thread_priority")) {}
    for (;;)
    {
      try
      {
        i = paramJSONObject.getInt("thread_priority");
        YtFSM.getInstance().start((String)paramArrayList.get(0), paramYtSDKKitFrameworkWorkMode, i);
        return 0;
      }
      catch (JSONException paramYtSDKPlatformContext)
      {
        YtLogger.e(TAG, "failed to get priority " + paramYtSDKPlatformContext.getLocalizedMessage());
      }
      int i = -8;
    }
  }
  
  public void reset()
  {
    new Handler(Looper.getMainLooper()).post(new YtSDKKitFramework.1(this));
  }
  
  public void setDetectRect(Rect paramRect)
  {
    this.detectRect = paramRect;
  }
  
  public void setNetworkRequestTimeoutMS(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    this.networkRequestTimeoutMS = i;
  }
  
  public void setPreviewRect(Rect paramRect)
  {
    this.previewRect = paramRect;
  }
  
  public void updateSDKSetting(JSONObject paramJSONObject)
  {
    YtFSM.getInstance().updateSDKSetting(paramJSONObject);
  }
  
  public int updateWithFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    if (l <= 946684800000L) {
      return 3145731;
    }
    YtFSM.getInstance().update(paramArrayOfByte, paramInt1, paramInt2, paramInt3, l);
    return 0;
  }
  
  public String version()
  {
    return "1.0.8.42";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */