package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;

class ReadInjoyWebShareHelper$4$1
  implements IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener
{
  ReadInjoyWebShareHelper$4$1(ReadInjoyWebShareHelper.4 param4) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (this.a.this$0.a != null)
    {
      if (!this.a.this$0.a.equals(paramBaseResp.transaction)) {
        return;
      }
      boolean bool2 = false;
      int i = paramBaseResp.errCode;
      boolean bool1 = bool2;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.a(1, 2131719009);
          bool1 = bool2;
        }
        else
        {
          QRUtils.a(2, 2131719027);
          bool1 = true;
        }
      }
      if (this.a.a)
      {
        ReadInjoyWebShareHelper.a(this.a.this$0, "we_chat", bool1);
        return;
      }
      ReadInjoyWebShareHelper.a(this.a.this$0, "we_chat_circle", bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.4.1
 * JD-Core Version:    0.7.0.1
 */