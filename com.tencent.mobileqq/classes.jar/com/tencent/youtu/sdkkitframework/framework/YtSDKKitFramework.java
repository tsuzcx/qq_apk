package com.tencent.youtu.sdkkitframework.framework;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG = "YtSDKKitFramework";
  private static YtSDKKitFramework instance;
  private static final String version = "1.1.18.11";
  private long defaultUpdateTimeoutMS = 8000L;
  private Rect detectRect = new Rect(10, 110, 470, 530);
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private int networkRequestTimeoutMS = 60000;
  private Rect previewRect = new Rect(0, 0, 480, 640);
  
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
      Object localObject = (YtFSMBaseState)Class.forName(paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      try
      {
        ((YtFSMBaseState)localObject).loadStateWith(paramString, paramJSONObject);
        return localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramJSONObject = (JSONObject)localObject;
        localObject = localThrowable2;
      }
      localThrowable1.printStackTrace();
    }
    catch (Throwable localThrowable1)
    {
      paramJSONObject = null;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Parse state ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("failed:");
    localStringBuilder.append(localThrowable1.getMessage());
    YtLogger.e(str, localStringBuilder.toString());
    return paramJSONObject;
  }
  
  public int deInit()
  {
    YtLogger.i(TAG, "sdkkit framework 1.1.18.11 deinit");
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
    YtLogger.i(TAG, "sdkkit framework 1.1.18.11 init");
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
    int i;
    if (paramJSONObject.has("thread_priority")) {
      try
      {
        i = paramJSONObject.getInt("thread_priority");
      }
      catch (JSONException paramYtSDKPlatformContext)
      {
        paramIYtSDKKitFrameworkEventListener = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("failed to get priority ");
        localStringBuilder.append(paramYtSDKPlatformContext.getLocalizedMessage());
        YtLogger.e(paramIYtSDKKitFrameworkEventListener, localStringBuilder.toString());
      }
    } else {
      i = -8;
    }
    long l = paramJSONObject.optLong("frame_update_timeout_ms", this.defaultUpdateTimeoutMS);
    YtFSM.getInstance().start((String)paramArrayList.get(0), paramYtSDKKitFrameworkWorkMode, i, l);
    return 0;
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
    return "1.1.18.11";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */