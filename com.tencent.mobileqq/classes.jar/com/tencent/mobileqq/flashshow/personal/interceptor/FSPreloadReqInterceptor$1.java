package com.tencent.mobileqq.flashshow.personal.interceptor;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class FSPreloadReqInterceptor$1
  extends BasePreLoadTask<Object>
{
  FSPreloadReqInterceptor$1(FSPreloadReqInterceptor paramFSPreloadReqInterceptor, FSBaseRequest paramFSBaseRequest) {}
  
  public void onRemove()
  {
    String str = this.b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemove key = ");
    localStringBuilder.append(FSPreloadReqInterceptor.a(this.b));
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public void startLoadData(OnPreLoadListener<Object> paramOnPreLoadListener)
  {
    VSNetworkHelper.getInstance().sendRequest(RFApplication.getApplication(), this.a, new FSPreloadReqInterceptor.1.1(this, paramOnPreLoadListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.personal.interceptor.FSPreloadReqInterceptor.1
 * JD-Core Version:    0.7.0.1
 */