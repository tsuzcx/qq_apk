package com.tencent.pts.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;

public class PTSComposer
{
  private static final String TAG = "PTSComposer";
  private Application.ActivityLifecycleCallbacks activityLifecycleCallback;
  private float containerWidth;
  private String frameTreeString;
  private boolean hasDestroyed = false;
  private String jsonData;
  private String pageName;
  private PTSAppInstance ptsAppInstance;
  private PTSComposer.IPTSUpdateDataListener updateDataListener;
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, float paramFloat, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    Object localObject = new PTSItemData.Builder().withPageName(paramString1).withFrameTreeJson(paramString2).withJsonData(paramString3).build();
    paramIPTSLiteEventListener = new PTSAppInstance.Builder().withRootNodeType(1).withItemData((PTSItemData)localObject).withContainerWidth(paramFloat).withLiteEventListener(paramIPTSLiteEventListener).build();
    localObject = new PTSComposer();
    ((PTSComposer)localObject).ptsAppInstance = paramIPTSLiteEventListener;
    ((PTSComposer)localObject).pageName = paramString1;
    ((PTSComposer)localObject).frameTreeString = paramString2;
    ((PTSComposer)localObject).jsonData = paramString3;
    ((PTSComposer)localObject).containerWidth = paramFloat;
    paramIPTSLiteEventListener.setPtsComposer((PTSComposer)localObject);
    return localObject;
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    return buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener, PTSComposer.IPTSUpdateDataListener paramIPTSUpdateDataListener)
  {
    paramString1 = buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
    paramString1.updateDataListener = paramIPTSUpdateDataListener;
    return paramString1;
  }
  
  private boolean rebuildPtsAppInstance(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!paramBoolean)
    {
      PTSLog.i("PTSComposer", "[rebuildPtsAppInstance] shouldRebuild = false.");
      return false;
    }
    StringBuilder localStringBuilder2;
    try
    {
      PTSItemData localPTSItemData = new PTSItemData.Builder().withPageName(this.pageName).withFrameTreeJson(this.frameTreeString).withJsonData(this.jsonData).build();
      this.ptsAppInstance = new PTSAppInstance.Builder().withRootNodeType(1).withItemData(localPTSItemData).withContainerWidth(this.containerWidth).withLiteEventListener(null).build();
      this.ptsAppInstance.setPtsComposer(this);
      try
      {
        this.hasDestroyed = false;
        paramBoolean = true;
      }
      catch (Exception localException1)
      {
        paramBoolean = true;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        paramBoolean = true;
      }
      localStringBuilder2 = new StringBuilder();
    }
    catch (Exception localException2)
    {
      paramBoolean = bool1;
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[rebuildPtsAppInstance] pageName = ");
      localStringBuilder2.append(this.pageName);
      localStringBuilder2.append(", e = ");
      localStringBuilder2.append(localException2);
      PTSLog.e("PTSComposer", localStringBuilder2.toString());
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      paramBoolean = bool2;
    }
    localStringBuilder2.append("[rebuildPtsAppInstance] pageName = ");
    localStringBuilder2.append(this.pageName);
    localStringBuilder2.append(", e = ");
    localStringBuilder2.append(localIllegalArgumentException2);
    PTSLog.e("PTSComposer", localStringBuilder2.toString());
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[rebuildPtsAppInstance], rebuildRes = ");
    localStringBuilder1.append(paramBoolean);
    localStringBuilder1.append(", pageName = ");
    localStringBuilder1.append(this.pageName);
    PTSLog.i("PTSComposer", localStringBuilder1.toString());
    return paramBoolean;
  }
  
  private void registerActivityLifecycleCallbacks(Context paramContext)
  {
    if (((paramContext instanceof Activity)) && (this.activityLifecycleCallback == null))
    {
      paramContext = ((Activity)paramContext).getApplication();
      this.activityLifecycleCallback = new PTSComposer.1(this, paramContext);
      if (paramContext != null)
      {
        paramContext.registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
        paramContext = new StringBuilder();
        paramContext.append("[registerActivityLifecycleCallbacks] finished, appInstance = ");
        paramContext.append(this.ptsAppInstance);
        PTSLog.i("PTSComposer", paramContext.toString());
      }
    }
  }
  
  private void unregisterLifecycleCallbacks(Context paramContext)
  {
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getApplication();
      if (paramContext != null)
      {
        paramContext.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallback);
        PTSLog.i("PTSComposer", "[unregisterLifecycleCallbacks] finished");
      }
    }
  }
  
  public void destroy()
  {
    if (!this.hasDestroyed)
    {
      unregisterLifecycleCallbacks(this.ptsAppInstance.getContext());
      this.updateDataListener = null;
      this.ptsAppInstance.onDestroy();
      this.hasDestroyed = true;
      PTSLog.i("PTSComposer", "[destroy] PTSComposer.");
      return;
    }
    PTSLog.i("PTSComposer", "[destroy] hasDestroyed, no need to call.");
  }
  
  public String getJsonData()
  {
    return this.jsonData;
  }
  
  public String getPageName()
  {
    return this.pageName;
  }
  
  public PTSAppInstance getPtsAppInstance()
  {
    return this.ptsAppInstance;
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    Object localObject = paramPTSItemView.getContext();
    if (localObject == null)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, context is null.");
      return paramPTSItemView;
    }
    this.ptsAppInstance.setContext((Context)localObject);
    localObject = this.ptsAppInstance.getRootNode();
    if (localObject != null) {
      ((PTSRootNode)localObject).setRootView(paramPTSItemView);
    } else {
      PTSLog.e("PTSComposer", "[layoutTopView] ptsRootNode is null.");
    }
    paramPTSItemView.bindData(this.ptsAppInstance);
    registerActivityLifecycleCallbacks(paramPTSItemView.getContext());
    return paramPTSItemView;
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    paramPTSItemView = layoutToView(paramPTSItemView);
    this.ptsAppInstance.setPtsLiteEventListener(paramIPTSLiteEventListener);
    return paramPTSItemView;
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView, IPTSLiteEventListener paramIPTSLiteEventListener, boolean paramBoolean)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    if ((this.hasDestroyed) && (!rebuildPtsAppInstance(paramBoolean)))
    {
      PTSLog.i("PTSComposer", "[layoutToView] failed, PTSComposer has been destroyed.");
      return paramPTSItemView;
    }
    paramPTSItemView = layoutToView(paramPTSItemView);
    this.ptsAppInstance.setPtsLiteEventListener(paramIPTSLiteEventListener);
    return paramPTSItemView;
  }
  
  public void setData(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[setData] failed, PTSComposer has been destroyed.");
      return;
    }
    paramString = this.ptsAppInstance.getItemData();
    paramString = new PTSItemData.Builder().withPageName(paramString.getPageName()).withFrameTreeJson(paramString.getFrameTreeJson()).withJsonData(str).build();
    this.ptsAppInstance.setItemData(paramString);
    this.jsonData = str;
  }
  
  public void triggerExposureEvent()
  {
    this.ptsAppInstance.triggerExposureEvent();
  }
  
  public String updateData(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[setData] failed, PTSComposer has been destroyed.");
      return this.jsonData;
    }
    this.jsonData = this.ptsAppInstance.updateData(str);
    paramString = this.updateDataListener;
    if (paramString != null) {
      paramString.onDataUpdated(this.jsonData);
    }
    return this.jsonData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSComposer
 * JD-Core Version:    0.7.0.1
 */