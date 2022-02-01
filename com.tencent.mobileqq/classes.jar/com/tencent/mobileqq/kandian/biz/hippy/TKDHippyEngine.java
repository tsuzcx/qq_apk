package com.tencent.mobileqq.kandian.biz.hippy;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TKDHippyEngine
  extends HippyQQEngine
  implements ITKDHippyEventDispatcherOwner
{
  private final ITKDHippyEventDispatcher eventDispatcher = new TKDHippyEventDispatcher();
  
  public TKDHippyEngine(QBaseFragment paramQBaseFragment, String paramString1, String paramString2)
  {
    super(paramQBaseFragment, paramString1, paramString2);
    this.providers.add(((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getTKDApiProvider());
    this.viewCreator = ((HippyCustomViewCreator)((IRIJAdService)QRoute.api(IRIJAdService.class)).createHippyCustomViewCreator());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.TKDHippyEngine
 * JD-Core Version:    0.7.0.1
 */