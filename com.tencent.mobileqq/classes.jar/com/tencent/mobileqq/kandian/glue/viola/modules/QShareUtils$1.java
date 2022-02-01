package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class QShareUtils$1
  implements Runnable
{
  QShareUtils$1(QShareUtils paramQShareUtils, Map paramMap, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean2, int paramInt, String paramString6, String paramString7) {}
  
  public void run()
  {
    QShareUtils.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.a.remove("image");
    if (this.b)
    {
      WxShareHelperFromReadInjoy.getInstance().shareToMiniProgramWithPathAndId(QShareUtils.a(this.this$0), this.c, (Bitmap)localObject1, this.d, this.e, this.f, this.g);
      return;
    }
    boolean bool = this.h;
    int m = 0;
    if (bool)
    {
      localObject2 = WxShareHelperFromReadInjoy.getInstance();
      str1 = QShareUtils.a(this.this$0);
      str2 = this.c;
      str3 = this.d;
      str4 = this.e;
      if (this.i == 9) {
        m = 0;
      } else {
        m = 1;
      }
      ((WxShareHelperFromReadInjoy)localObject2).shareVideo(str1, str2, (Bitmap)localObject1, str3, str4, m);
      return;
    }
    if (((this.i == 9) && (this.j.contains("wx_friend"))) || ((this.i == 10) && (this.j.contains("wx_line"))))
    {
      localObject1 = WXShareHelper.a();
      localObject2 = this.k;
      if (this.i != 9) {
        m = 1;
      }
      ((WXShareHelper)localObject1).a((String)localObject2, m, QShareUtils.a(this.this$0));
      return;
    }
    Object localObject2 = WXShareHelper.a();
    String str1 = QShareUtils.a(this.this$0);
    String str2 = this.c;
    String str3 = this.d;
    String str4 = this.e;
    if (this.i == 9) {
      m = 0;
    } else {
      m = 1;
    }
    ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils.1
 * JD-Core Version:    0.7.0.1
 */