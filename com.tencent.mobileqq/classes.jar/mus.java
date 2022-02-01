import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.widget.AdapterView;

class mus
  implements bljm
{
  mus(mur parammur, Button paramButton, long paramLong, blir paramblir) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (mur.a(this.jdField_a_of_type_Mur) != null)
    {
      paramAdapterView = (muy)mur.a(this.jdField_a_of_type_Mur).getItem(paramInt);
      if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.a)) && (this.jdField_a_of_type_Mur.a != null))
      {
        if (!"DEVICE_BLUETOOTHHEADSET".equals(paramAdapterView.a)) {
          break label199;
        }
        mbb.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
        if (this.jdField_a_of_type_AndroidWidgetButton != null) {
          this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D20 at: " + System.currentTimeMillis());
        }
        bdll.b(null, "CliOper", "", "", "0X8008D20", "0X8008D20", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      mur.a(this.jdField_a_of_type_Mur, true);
      this.jdField_a_of_type_Mur.a.a(mtl.a());
      this.jdField_a_of_type_Mur.a.a(this.jdField_a_of_type_Long, paramAdapterView.a);
      this.jdField_a_of_type_Blir.dismiss();
      return;
      label199:
      if ("DEVICE_SPEAKERPHONE".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1F at: " + System.currentTimeMillis());
        }
        bdll.b(null, "CliOper", "", "", "0X8008D1F", "0X8008D1F", 0, 0, "", "", "", "");
      }
      else if ("DEVICE_EARPHONE".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-1 at: " + System.currentTimeMillis());
        }
        bdll.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 1, 0, "", "", "", "");
      }
      else if ("DEVICE_WIREDHEADSET".equals(paramAdapterView.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D21-2 at: " + System.currentTimeMillis());
        }
        bdll.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mus
 * JD-Core Version:    0.7.0.1
 */