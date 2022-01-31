import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.widget.AdapterView;

class miv
  implements behi
{
  miv(miu parammiu, Button paramButton, long paramLong, begr parambegr) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (miu.a(this.jdField_a_of_type_Miu) != null)
    {
      paramAdapterView = (mjb)miu.a(this.jdField_a_of_type_Miu).getItem(paramInt);
      if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.a)) && (this.jdField_a_of_type_Miu.a != null))
      {
        if (!"DEVICE_BLUETOOTHHEADSET".equals(paramAdapterView.a)) {
          break label190;
        }
        lqb.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D20 at: " + System.currentTimeMillis());
        }
        awqx.b(null, "CliOper", "", "", "0X8008D20", "0X8008D20", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Miu.a.a(mhr.a());
      this.jdField_a_of_type_Miu.a.a(this.jdField_a_of_type_Long, paramAdapterView.a);
      this.jdField_a_of_type_Begr.dismiss();
      return;
      label190:
      if ("DEVICE_SPEAKERPHONE".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1F at: " + System.currentTimeMillis());
        }
        awqx.b(null, "CliOper", "", "", "0X8008D1F", "0X8008D1F", 0, 0, "", "", "", "");
      }
      else if ("DEVICE_EARPHONE".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-1 at: " + System.currentTimeMillis());
        }
        awqx.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 1, 0, "", "", "", "");
      }
      else if ("DEVICE_WIREDHEADSET".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-2 at: " + System.currentTimeMillis());
        }
        awqx.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     miv
 * JD-Core Version:    0.7.0.1
 */