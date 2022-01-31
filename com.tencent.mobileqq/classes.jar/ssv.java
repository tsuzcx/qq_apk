import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class ssv
  implements View.OnClickListener
{
  public ssv(ForwardRecentActivity paramForwardRecentActivity, Resources paramResources, DeviceInfo paramDeviceInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity, "目前没有网络，请稍后再试!", 1000).b(this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131558448));
      return;
    }
    paramView = new Bundle();
    paramView.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din));
    paramView.putInt("uintype", 9501);
    paramView.putString("uinname", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.a(ForwardAbility.ForwardAbilityType.j.intValue(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ssv
 * JD-Core Version:    0.7.0.1
 */