package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class BaseMomentItemBuilder$4$1
  implements DeleteFeedCallback
{
  BaseMomentItemBuilder$4$1(BaseMomentItemBuilder.4 param4) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      INowVideoReporter localINowVideoReporter = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("data_card").opName("feed_delete_suc");
      String str = "2";
      localINowVideoReporter = localINowVideoReporter.source("2").timelong(this.a.c.h(this.a.b)).feedid(paramString).feed_type(String.valueOf(this.a.c.g(this.a.b)));
      paramString = str;
      if (this.a.c.b) {
        paramString = "1";
      }
      localINowVideoReporter.d1(paramString).report(this.a.c.c);
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131899263), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.4.1
 * JD-Core Version:    0.7.0.1
 */