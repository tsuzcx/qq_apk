package com.tencent.mobileqq.util;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.mobileqq.vip.IGameCardManager.OnResultCallBack;

final class QQSettingUtil$2
  implements IGameCardManager.OnResultCallBack
{
  QQSettingUtil$2(View paramView, IGameCardManager.GameCardInfo paramGameCardInfo) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.a != null)
    {
      paramURLDrawable = new LinearLayout.LayoutParams(ViewUtils.dip2px(47.0F), ViewUtils.dip2px(15.0F));
      paramURLDrawable.rightMargin = ViewUtils.dip2px(5.0F);
      paramURLDrawable.gravity = 16;
      this.a.setLayoutParams(paramURLDrawable);
      this.a.setVisibility(0);
      if (VasUtil.a().getGameCardManager().isSelf(this.b.b)) {
        paramURLDrawable = "owner";
      } else {
        paramURLDrawable = "visitor";
      }
      ((IMobileReportManager)QRoute.api(IMobileReportManager.class)).reportAction(String.valueOf(this.b.f), "4", "platform898", "choutiye", paramURLDrawable, 101, 1, System.currentTimeMillis());
    }
  }
  
  public void b(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
  
  public void c(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.a;
    if (paramURLDrawable != null) {
      paramURLDrawable.setVisibility(8);
    }
  }
  
  public void d(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.restartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil.2
 * JD-Core Version:    0.7.0.1
 */