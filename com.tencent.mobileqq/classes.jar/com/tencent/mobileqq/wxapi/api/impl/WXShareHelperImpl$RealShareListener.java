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
      ((WXShareRsp)localObject).errCode = paramBaseResp.errCode;
      ((WXShareRsp)localObject).errStr = paramBaseResp.errStr;
      ((WXShareRsp)localObject).openId = paramBaseResp.openId;
      ((WXShareRsp)localObject).transaction = paramBaseResp.transaction;
      ((IWXShareHelperListener)this.a.get()).onWXShareResp((WXShareRsp)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.api.impl.WXShareHelperImpl.RealShareListener
 * JD-Core Version:    0.7.0.1
 */