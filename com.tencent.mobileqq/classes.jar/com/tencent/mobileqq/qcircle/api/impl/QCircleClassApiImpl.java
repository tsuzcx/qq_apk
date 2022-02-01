package com.tencent.mobileqq.qcircle.api.impl;

import com.qflutter.vistaimage.IVistaImage;
import com.tencent.biz.qcircleshadow.delegateimpl.QCircleApplicationImpl;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.qcircleshadow.lib.QCircleSchemeHandler;
import com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransFragment;
import com.tencent.biz.qcircleshadow.local.fragment.QCirclePluginLoadingFragment;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.requests.QQCircleGetGroupCountRequest;

public class QCircleClassApiImpl
  implements IQCircleClassApi
{
  public boolean checkIsQCirclePluginLoadingActivity(QBaseActivity paramQBaseActivity)
  {
    if ((paramQBaseActivity instanceof QPublicTransFragmentActivity))
    {
      paramQBaseActivity = (QPublicTransFragmentActivity)paramQBaseActivity;
      if ((paramQBaseActivity.getFragment().getClass().getCanonicalName() != null) && (paramQBaseActivity.getFragment().getClass().getCanonicalName().equals(QCirclePluginLoadingFragment.class.getCanonicalName()))) {
        return true;
      }
    }
    return false;
  }
  
  public Class<? extends IApplicationDelegate> getQCircleApplicationDelegateClass()
  {
    return QCircleApplicationImpl.class;
  }
  
  public Class getQCircleHandlerClass()
  {
    return QCircleHandler.class;
  }
  
  public Class getQCircleHostTransFragmentClass()
  {
    return QCircleHostTransFragment.class;
  }
  
  public IVistaImage getQCircleVistaImageInstance()
  {
    return QCircleSchemeHandler.getInstance();
  }
  
  public BaseRequest getQQCircleGetGroupCountRequest(long paramLong)
  {
    return new QQCircleGetGroupCountRequest(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleClassApiImpl
 * JD-Core Version:    0.7.0.1
 */