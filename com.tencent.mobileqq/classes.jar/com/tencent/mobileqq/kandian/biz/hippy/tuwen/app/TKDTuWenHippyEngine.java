package com.tencent.mobileqq.kandian.biz.hippy.tuwen.app;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TKDTuWenHippyEngine
  extends HippyQQEngine
  implements ITKDHippyEventDispatcherOwner
{
  private static final String HIPPY_COMMENT_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private static final String HIPPY_URL = "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react";
  private final ITKDHippyEventDispatcher eventDispatcher = new TKDHippyEventDispatcher();
  
  public TKDTuWenHippyEngine(Activity paramActivity)
  {
    super(paramActivity, getModuleNameInner(), "https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react");
    this.providers.add(((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getNSHippyProvider());
    this.viewCreator = new TuWenHippyViewCreator();
  }
  
  private static String getModuleNameInner()
  {
    return Uri.parse("https://viola.qq.com/js/TKDCommentArticle.js?_rij_violaUrl=1&v_tid=6&v_bundleName=TKDCommentArticle&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740&framework=react").getQueryParameter("v_bundleName");
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
      QLog.d("HippyQQEngine", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.eventDispatcher.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.app.TKDTuWenHippyEngine
 * JD-Core Version:    0.7.0.1
 */