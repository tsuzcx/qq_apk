package com.tencent.mobileqq.sharehelper.impl;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class ShareActionHelperImpl$2
  implements WXShareHelper.WXShareListener
{
  ShareActionHelperImpl$2(ShareActionHelperImpl paramShareActionHelperImpl, String paramString1, WXShareHelper.WXShareListener[] paramArrayOfWXShareListener, String paramString2, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (paramBaseResp.transaction != null))
    {
      if (!paramBaseResp.transaction.equals(this.a))
      {
        QLog.e("ShareActionHelperImpl", 1, "onWXShareResp: mWXTransaction is wrong");
        return;
      }
      WXShareHelper.a().b(this.b[0]);
      this.b[0] = null;
      int i = paramBaseResp.errCode;
      if (i != -2)
      {
        if (i != 0)
        {
          this.e.dispatchHandleWXLinkRespDenied(this.c, this.d);
          return;
        }
        this.e.dispatchHandleWXLinkRespOK(this.c, this.d);
        return;
      }
      this.e.dispatchHandleWXLinkRespCancel(this.c, this.d);
      return;
    }
    QLog.e("ShareActionHelperImpl", 1, "onWXShareResp: respData is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */