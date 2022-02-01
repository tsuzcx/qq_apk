package com.tencent.mobileqq.troop.honor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;

final class TroopHonorAIOUtils$3
  implements View.OnTouchListener
{
  long a = 0L;
  
  TroopHonorAIOUtils$3(boolean paramBoolean, QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.b)
    {
      if (!(paramView instanceof ImageView)) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      String str = null;
      paramMotionEvent = str;
      if (paramView.getTag() != null)
      {
        paramMotionEvent = str;
        if ((paramView.getTag() instanceof MutualMarkForDisplayInfo)) {
          paramMotionEvent = (MutualMarkForDisplayInfo)paramView.getTag();
        }
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3) {
            return true;
          }
          if (paramMotionEvent != null)
          {
            paramView.setAlpha(paramMotionEvent.d());
            return true;
          }
          paramView.setAlpha(1.0F);
          return true;
        }
        if (paramMotionEvent != null) {
          paramView.setAlpha(paramMotionEvent.d());
        } else {
          paramView.setAlpha(1.0F);
        }
        if (System.currentTimeMillis() - this.a < 800L) {
          return true;
        }
        this.a = System.currentTimeMillis();
        if (paramMotionEvent != null)
        {
          if (TextUtils.isEmpty(paramMotionEvent.o)) {
            return false;
          }
          if (paramMotionEvent.o.equals(HardCodeUtil.a(2131897530)))
          {
            ReportController.b(this.c, "dc00899", "Grp_AIO", "", "Grp_AIO_display", "AIO_Luckyword_clk", 0, 0, "", "", "", "");
            paramView = new Intent(this.d, QQBrowserActivity.class);
            paramView.putExtra("url", "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.e));
            this.d.startActivity(paramView);
            return true;
          }
          paramView = this.c;
          str = this.e;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(paramMotionEvent.a);
          ReportController.b(paramView, "dc00898", "", str, "0X800A852", "0X800A852", 0, 0, localStringBuilder.toString(), "", "", "");
          paramView = ((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).getTroopMemberHonorUrl(this.e, this.c.getCurrentAccountUin());
          paramMotionEvent = new Intent(this.d, QQBrowserActivity.class);
          paramMotionEvent.putExtra("url", paramView);
          this.d.startActivity(paramMotionEvent);
          return true;
        }
        return false;
      }
      if (paramMotionEvent != null)
      {
        paramView.setAlpha(paramMotionEvent.d() * 0.5F);
        return true;
      }
      paramView.setAlpha(0.5F);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils.3
 * JD-Core Version:    0.7.0.1
 */