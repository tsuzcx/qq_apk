package com.tencent.mobileqq.wxapi.api.impl;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import mqq.util.WeakReference;

class WXShareHelperImpl$RealShareListener
  implements WXShareHelper.WXShareListener
{
  WeakReference<IWXShareHelperListener> a;
  
  public WXShareHelperImpl$RealShareListener(IWXShareHelperListener paramIWXShareHelperListener)
  {
    this.a = new WeakReference(paramIWXShareHelperListener);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a != null) && (this.a.get() != null))
    {
      WXShareRsp localWXShareRsp = new WXShareRsp();
      localWXShareRsp.jdField_a_of_type_Int = paramBaseResp.errCode;
      localWXShareRsp.jdField_a_of_type_JavaLangString = paramBaseResp.errStr;
      localWXShareRsp.c = paramBaseResp.openId;
      localWXShareRsp.b = paramBaseResp.transaction;
      ((IWXShareHelperListener)this.a.get()).a(localWXShareRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.api.impl.WXShareHelperImpl.RealShareListener
 * JD-Core Version:    0.7.0.1
 */