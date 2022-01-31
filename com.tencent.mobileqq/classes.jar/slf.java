import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;

public class slf
  implements View.OnClickListener
{
  public slf(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent().getExtras();
    paramView.putString("uin", AppConstants.ay);
    paramView.putInt("uintype", -1);
    paramView.putString("uinname", "QQ空间");
    this.a.a.a(ForwardAbility.ForwardAbilityType.e.intValue(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     slf
 * JD-Core Version:    0.7.0.1
 */