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
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = new WXShareRsp();
      ((WXShareRsp)localObject).jdField_a_of_type_Int = paramBaseResp.errCode;
      ((WXShareRsp)localObject).jdField_a_of_type_JavaLangString = paramBaseResp.errStr;
      ((WXShareRsp)localObject).c = paramBaseResp.openId;
      ((WXShareRsp)localObject).b = paramBaseResp.transaction;
      ((IWXShareHelperListener)this.a.get()).a((WXShareRsp)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.api.impl.WXShareHelperImpl.RealShareListener
 * JD-Core Version:    0.7.0.1
 */