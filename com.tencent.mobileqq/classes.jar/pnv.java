import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class pnv
  extends pnq
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private boolean jdField_a_of_type_Boolean;
  
  public pnv(@NotNull pnr parampnr, Activity paramActivity)
  {
    super(parampnr, "RIJLockScreenPopupStep");
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      if ((localIntent != null) && (localIntent.hasExtra("launch_from")) && (localIntent.hasExtra("kan_dian_lock_screen_flag")) && (localIntent.getIntExtra("launch_from", 0) == 9))
      {
        ReadInJoyLockScreenJumpDelegate.a(this.jdField_a_of_type_AndroidAppActivity, localIntent);
        localIntent.removeExtra("kan_dian_lock_screen_flag");
        QLog.i("RIJDailyPopupStep", 1, "RIJLockScreenPopupStep handleLockScreenJump!");
        return true;
      }
    }
    return false;
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_Boolean);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_Boolean = c();
    a(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnv
 * JD-Core Version:    0.7.0.1
 */