package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.NotNull;

public class RIJDailyFloatingPopupStep
  extends BasePopupStep
{
  private Activity a;
  private boolean b = false;
  
  public RIJDailyFloatingPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJDailyPopupStep");
    this.a = paramActivity;
  }
  
  private boolean l()
  {
    Object localObject = this.a.getIntent();
    int j = 5;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((Intent)localObject).hasExtra("launch_from")) {
        i = ((Intent)localObject).getIntExtra("launch_from", 5);
      }
    }
    boolean bool;
    if (i == 15) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isOpenFloatingWindow = ");
    localStringBuilder.append(bool);
    ((IRIJAdLogService)localObject).d("RIJDailyFloatingPopupStep", localStringBuilder.toString());
    return bool;
  }
  
  protected void h() {}
  
  protected void i() {}
  
  public void j()
  {
    this.b = l();
    a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyFloatingPopupStep
 * JD-Core Version:    0.7.0.1
 */