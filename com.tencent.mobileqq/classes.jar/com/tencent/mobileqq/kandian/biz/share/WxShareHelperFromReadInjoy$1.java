package com.tencent.mobileqq.kandian.biz.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.qphone.base.util.QLog;

class WxShareHelperFromReadInjoy$1
  implements Runnable
{
  WxShareHelperFromReadInjoy$1(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bitmap paramBitmap, String paramString6) {}
  
  public void run()
  {
    Object localObject1 = new WXMiniProgramObject();
    ((WXMiniProgramObject)localObject1).withShareTicket = true;
    ((WXMiniProgramObject)localObject1).webpageUrl = this.a;
    ((WXMiniProgramObject)localObject1).userName = this.b;
    ((WXMiniProgramObject)localObject1).path = this.c;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = this.d;
    localWXMediaMessage.description = this.e;
    localObject1 = this.f;
    if (localObject1 != null)
    {
      int i = ((Bitmap)localObject1).getWidth();
      int j = this.f.getHeight();
      j = Math.min(i / 5, j / 4);
      i = j * 5;
      j *= 4;
      if (this.c.startsWith("/pages/index/index?share=1&share_type=1")) {
        localObject1 = BitmapUtils.a(BitmapUtils.a(this.f, i, j, false, true), BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842736), true);
      } else {
        localObject1 = BitmapUtils.a(this.f, i, j, false, true);
      }
      if (localObject1 != null)
      {
        j = ((Bitmap)localObject1).getWidth();
        i = ((Bitmap)localObject1).getHeight();
        Object localObject2 = localObject1;
        if (((Bitmap)localObject1).getByteCount() > 128000)
        {
          localObject1 = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
          double d1 = j * i;
          Double.isNaN(d1);
          d1 = Math.sqrt(64000.0D / d1);
          double d2 = j;
          Double.isNaN(d2);
          j = (int)(d2 * d1);
          d2 = i;
          Double.isNaN(d2);
          localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, j, (int)(d2 * d1), true);
        }
        localWXMediaMessage.thumbData = WxShareHelperFromReadInjoy.access$000((Bitmap)localObject2);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shareToMiniProgramWithPathAndId, error icon == null! title");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append(", description = ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(", path = ");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(", webPageUrl = ");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(", id = ");
      ((StringBuilder)localObject1).append(this.b);
      QLog.e("WxShareHelperFromReadInjoy", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new SendMessageToWX.Req();
    ((SendMessageToWX.Req)localObject1).transaction = this.g;
    ((SendMessageToWX.Req)localObject1).message = localWXMediaMessage;
    ((SendMessageToWX.Req)localObject1).scene = 0;
    WxShareHelperFromReadInjoy.access$100(this.this$0, (SendMessageToWX.Req)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy.1
 * JD-Core Version:    0.7.0.1
 */