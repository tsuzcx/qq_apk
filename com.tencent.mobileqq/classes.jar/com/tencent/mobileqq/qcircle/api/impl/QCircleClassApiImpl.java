package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qcircleshadow.delegateimpl.QCircleApplicationImpl;
import com.tencent.biz.qcircleshadow.local.fragment.QCircleHostTransFragment;
import com.tencent.biz.richframework.delegate.IApplicationDelegate;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.IQCircleClassApi;
import com.tencent.mobileqq.qcircle.api.requests.QQCircleGetGroupCountRequest;

public class QCircleClassApiImpl
  implements IQCircleClassApi
{
  public Class<? extends IApplicationDelegate> getQCircleApplicationDelegateClass()
  {
    return QCircleApplicationImpl.class;
  }
  
  public Class getQCircleHostTransFragmentClass()
  {
    return QCircleHostTransFragment.class;
  }
  
  public BaseRequest getQQCircleGetGroupCountRequest(long paramLong)
  {
    return new QQCircleGetGroupCountRequest(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleClassApiImpl
 * JD-Core Version:    0.7.0.1
 */