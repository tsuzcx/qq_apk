package com.tencent.mobileqq.kandian.biz.hippy.tuwen.app;

import android.app.Activity;
import android.content.ContextWrapper;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleDispatcher;
import com.tencent.hippy.qq.fragment.HippyActivityLifecycleOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.provider.NSHippyProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngine.ModuleLoadParams;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TKDTuWenHippyEngine
  extends HippyQQEngine
  implements HippyActivityLifecycleOwner, ITKDHippyEventDispatcherOwner
{
  private static final String HIPPY_COMMENT_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private static final String HIPPY_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private static final int MIN_MODULE_VERSION = 52;
  private static final String TAG = "TKDTuWenHippyEngine";
  private final ITKDHippyEventDispatcher eventDispatcher = new TKDHippyEventDispatcher();
  private final HippyActivityLifecycleDispatcher hippyActivityLifecycleDispatcher = new HippyActivityLifecycleDispatcher();
  private HippyInstanceContext hippyContext;
  
  public TKDTuWenHippyEngine(Activity paramActivity)
  {
    super(paramActivity, getModuleNameInner(), "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react");
    this.hippyContext = new HippyInstanceContext(paramActivity);
    this.providers.add(new NSHippyProvider());
    this.viewCreator = new TuWenHippyViewCreator();
    setHippyActivityLifecycleOwner(this);
  }
  
  private static String getModuleNameInner()
  {
    return Uri.parse("https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react").getQueryParameter("v_bundleName");
  }
  
  protected void fillLoadParams(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    super.fillLoadParams(paramModuleLoadParams);
    this.hippyContext.setModuleParams(paramModuleLoadParams);
    paramModuleLoadParams.context = BaseApplication.getContext();
    paramModuleLoadParams.hippyContext = this.hippyContext;
  }
  
  @NotNull
  public HippyActivityLifecycleDispatcher getActivityLifecycleDispatcher()
  {
    return this.hippyActivityLifecycleDispatcher;
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    return this.eventDispatcher;
  }
  
  protected void initJsBundleTypeFromUrl()
  {
    super.initJsBundleTypeFromUrl();
    try
    {
      String str = Uri.parse(this.mUrl).getQueryParameter("component");
      if (!TextUtils.isEmpty(str))
      {
        this.componentName = str;
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error : ");
      localStringBuilder.append(localException.getMessage());
      QLog.d("TKDTuWenHippyEngine", 2, localStringBuilder.toString());
    }
  }
  
  protected void loadModule()
  {
    if (((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName()) < 52)
    {
      checkPackageUpdate();
      return;
    }
    super.loadModule();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eventDispatcher.clear();
  }
  
  public void setActivity(Activity paramActivity)
  {
    super.setActivity(paramActivity);
    QLog.d("TKDTuWenHippyEngine", 1, "change hippyInstanceContext by reflecting");
    try
    {
      Field localField = ContextWrapper.class.getDeclaredField("mBase");
      localField.setAccessible(true);
      HippyInstanceContext localHippyInstanceContext = this.hippyContext;
      localObject = paramActivity;
      if (paramActivity == null) {
        localObject = BaseApplication.getContext();
      }
      localField.set(localHippyInstanceContext, localObject);
      return;
    }
    catch (Exception paramActivity)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error: ");
        ((StringBuilder)localObject).append(paramActivity.getMessage());
        QLog.d("TKDTuWenHippyEngine", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine
 * JD-Core Version:    0.7.0.1
 */