import android.os.Bundle;
import android.widget.CompoundButton;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class pyy
  implements BusinessObserver
{
  public pyy(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    int i = 1;
    boolean bool1 = false;
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    if (!paramBoolean)
    {
      paramBundle = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
      paramBoolean = bool1;
      if (!this.a.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {
        paramBoolean = true;
      }
      paramBundle.setChecked(paramBoolean);
      ToastUtil.a().a(this.a.getString(2131427806));
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      ToastUtil.a().a(this.a.getString(2131427804));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0) {
          break label280;
        }
        int j = ((Integer)this.a.jdField_a_of_type_AndroidWidgetCompoundButton.getTag()).intValue();
        paramBundle = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!paramBundle.hasNext()) {
          break;
        }
        localObject = (pyz)paramBundle.next();
        if (((pyz)localObject).a == j) {
          if (this.a.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked())
          {
            paramInt = 1;
            ((pyz)localObject).b = paramInt;
          }
          else
          {
            paramInt = 0;
          }
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    paramBundle = this.a.app;
    long l = Long.parseLong(this.a.c);
    paramInt = i;
    if (this.a.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {
      paramInt = 2;
    }
    SmartDeviceReport.a(paramBundle, l, "Usr_MsgMgr_Setting", paramInt, 0, Integer.parseInt(this.a.b));
    return;
    label280:
    Object localObject = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
    if (!this.a.jdField_a_of_type_AndroidWidgetCompoundButton.isChecked()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      LogUtility.a("DeviceMsgSettingActivity", "msg:" + paramBundle.optString("msg"));
      ToastUtil.a().a(this.a.getString(2131427806));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pyy
 * JD-Core Version:    0.7.0.1
 */