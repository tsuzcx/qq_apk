package com.tencent.youtu.sdkkitframework.framework;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class YtSDKKitFramework
{
  private static final String TAG = YtSDKKitFramework.class.getSimpleName();
  private static YtSDKKitFramework instance;
  private static final String version = "1.0.8.2h";
  private Rect detectRect = new Rect(20, 270, 700, 1130);
  private YtSDKKitFramework.IYtSDKKitFrameworkEventListener eventListener;
  private Rect previewRect = new Rect(0, 0, 720, 1280);
  
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
    YtFSM.getInstance().stop();
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
  
  public YtSDKKitFramework.YtSDKPlatformContex getPlatformContext()
  {
    return YtFSM.getInstance().getContext();
  }
  
  public Rect getPreviewRect()
  {
    return this.previewRect;
  }
  
  public int init(YtSDKKitFramework.YtSDKPlatformContex paramYtSDKPlatformContex, JSONObject paramJSONObject, YtSDKKitFramework.YtSDKKitFrameworkWorkMode paramYtSDKKitFrameworkWorkMode, ArrayList<String> paramArrayList, YtSDKKitFramework.IYtSDKKitFrameworkEventListener paramIYtSDKKitFrameworkEventListener)
  {
    if (paramYtSDKPlatformContex == null)
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
    YtFSM.getInstance().setContext(paramYtSDKPlatformContex);
    paramYtSDKPlatformContex = paramArrayList.iterator();
    while (paramYtSDKPlatformContex.hasNext())
    {
      paramIYtSDKKitFrameworkEventListener = parseStateFrom((String)paramYtSDKPlatformContex.next(), paramJSONObject);
      YtFSM.getInstance().registerState(paramIYtSDKKitFrameworkEventListener);
    }
    YtFSM.getInstance().start((String)paramArrayList.get(0), paramYtSDKKitFrameworkWorkMode);
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
  
  public void setPreviewRect(Rect paramRect)
  {
    this.previewRect = paramRect;
  }
  
  public int updateWithFrameData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    YtFSM.getInstance().update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    return 0;
  }
  
  public String version()
  {
    return "1.0.8.2h";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework
 * JD-Core Version:    0.7.0.1
 */