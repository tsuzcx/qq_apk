package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils;
import org.jetbrains.annotations.NotNull;

public class RIJDailyPopupStep
  extends BasePopupStep
{
  private Activity a;
  private boolean b = false;
  
  public RIJDailyPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJDailyPopupStep");
    this.a = paramActivity;
  }
  
  private boolean j()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((Activity)localObject).getIntent();
    } else {
      localObject = null;
    }
    return ReadInJoyDailyJumpToKDTabUtils.a(this.a, (Intent)localObject, 0);
  }
  
  protected void h()
  {
    a(this.b);
  }
  
  protected void i()
  {
    this.b = j();
    a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJDailyPopupStep
 * JD-Core Version:    0.7.0.1
 */