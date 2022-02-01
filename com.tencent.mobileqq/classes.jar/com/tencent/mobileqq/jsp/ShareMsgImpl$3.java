package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class ShareMsgImpl$3
  implements Runnable
{
  ShareMsgImpl$3(ShareMsgImpl paramShareMsgImpl, String paramString1, String paramString2, int paramInt, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.n;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if (this.this$0.a == null) {
        this.this$0.a((Activity)localObject);
      }
      if ((this.this$0.a != null) && (this.this$0.a.isShowing())) {
        this.this$0.a.dismiss();
      }
      if (this.this$0.c == null)
      {
        this.this$0.c = new ShareMsgImpl.3.1(this);
        WXShareHelper.a().a(this.this$0.c);
      }
      if ((this.c == 1) && (this.this$0.d == null))
      {
        this.this$0.d = new ShareMsgImpl.3.2(this);
        ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).addObserver(this.this$0.d);
      }
      this.this$0.e = String.valueOf(System.currentTimeMillis());
      localObject = (Bitmap)this.d.remove("image");
      if ("audio".equals(this.e))
      {
        WXShareHelper.a().a(this.this$0.e, this.f, (Bitmap)localObject, this.g, this.b, "2".equals(this.a) ^ true, this.h);
        return;
      }
      if (this.c == 1)
      {
        this.this$0.k.d(new ShareMsgImpl.3.3(this, (Bitmap)localObject));
        return;
      }
      WXShareHelper.a().a(this.this$0.e, this.f, (Bitmap)localObject, this.g, this.b, "2".equals(this.a) ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3
 * JD-Core Version:    0.7.0.1
 */