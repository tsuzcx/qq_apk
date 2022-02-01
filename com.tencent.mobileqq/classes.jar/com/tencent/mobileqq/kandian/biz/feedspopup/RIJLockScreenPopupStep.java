package com.tencent.mobileqq.kandian.biz.feedspopup;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class RIJLockScreenPopupStep
  extends BasePopupStep
{
  private Activity a;
  private boolean b = false;
  
  public RIJLockScreenPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJLockScreenPopupStep");
    this.a = paramActivity;
  }
  
  private boolean j()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if ((localObject != null) && (((Intent)localObject).hasExtra("launch_from")) && (((Intent)localObject).hasExtra("kan_dian_lock_screen_flag")) && (((Intent)localObject).getIntExtra("launch_from", 0) == 9))
      {
        ReadInJoyLockScreenJumpDelegate.a(this.a, (Intent)localObject);
        ((Intent)localObject).removeExtra("kan_dian_lock_screen_flag");
        QLog.i("RIJDailyPopupStep", 1, "RIJLockScreenPopupStep handleLockScreenJump!");
        return true;
      }
    }
    return false;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feedspopup.RIJLockScreenPopupStep
 * JD-Core Version:    0.7.0.1
 */