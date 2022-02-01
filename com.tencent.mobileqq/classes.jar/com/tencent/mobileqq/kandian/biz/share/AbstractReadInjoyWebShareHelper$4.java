package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.graphics.Bitmap;
import java.util.Map;

class AbstractReadInjoyWebShareHelper$4
  implements Runnable
{
  AbstractReadInjoyWebShareHelper$4(AbstractReadInjoyWebShareHelper paramAbstractReadInjoyWebShareHelper, boolean paramBoolean1, Map paramMap, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = this.this$0.b();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      AbstractReadInjoyWebShareHelper.h(this.this$0);
      if (this.this$0.c == null)
      {
        this.this$0.c = new AbstractReadInjoyWebShareHelper.4.1(this);
        WxShareHelperFromReadInjoy.getInstance().addObserver(this.this$0.c);
      }
      this.this$0.b = String.valueOf(System.currentTimeMillis());
      localObject = (Bitmap)this.b.remove("image");
      if ((this.c) && (this.a))
      {
        WxShareHelperFromReadInjoy.getInstance().shareToMiniProgramWithPath(this.this$0.b, this.d, (Bitmap)localObject, this.e, this.f, this.g);
        return;
      }
      this.this$0.a(new AbstractReadInjoyWebShareHelper.4.2(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.4
 * JD-Core Version:    0.7.0.1
 */