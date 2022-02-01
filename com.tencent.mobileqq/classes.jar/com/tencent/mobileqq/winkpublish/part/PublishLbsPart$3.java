package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.widget.PublishBubblePopupView;

class PublishLbsPart$3
  implements Runnable
{
  PublishLbsPart$3(PublishLbsPart paramPublishLbsPart) {}
  
  public void run()
  {
    PublishLbsPart.e(this.this$0).a(this.this$0.c().getResources().getString(2131895779));
    PublishLbsPart.e(this.this$0).b(5);
    PublishLbsPart.e(this.this$0).setWidth(-2);
    PublishLbsPart.e(this.this$0).setHeight(-2);
    PublishLbsPart.e(this.this$0).a(PublishLbsPart.f(this.this$0), 1, 0, 0, 0);
    this.this$0.G().postDelayed(PublishLbsPart.g(this.this$0), 4000L);
    LocalConfig.a("key_sp_bubble_view_show", false, LoginData.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLbsPart.3
 * JD-Core Version:    0.7.0.1
 */