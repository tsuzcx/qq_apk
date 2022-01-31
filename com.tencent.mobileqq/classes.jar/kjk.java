import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.TraeHelper.SoundOutputRes.IconAndName;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import mqq.util.WeakReference;

public class kjk
  implements AdapterView.OnItemClickListener
{
  public kjk(TraeHelper paramTraeHelper, Button paramButton, ActionSheet paramActionSheet) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (TraeHelper.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper) != null)
    {
      paramAdapterView = (TraeHelper.SoundOutputRes.IconAndName)TraeHelper.a(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper).getItem(paramInt);
      if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null))
      {
        if (!"DEVICE_BLUETOOTHHEADSET".equals(paramAdapterView.jdField_a_of_type_JavaLangString)) {
          break label224;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d != null)
        {
          paramView = (TipsManager)this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d.get();
          if ((paramView != null) && (paramView.b != 1002))
          {
            paramView.a(1005);
            paramView.b();
            if (this.jdField_a_of_type_AndroidWidgetButton != null) {
              this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_JavaLangString, 2, "Trae_DRP 0X8008D20 at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D20", "0X8008D20", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(TraeHelper.a());
      this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramAdapterView.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label224:
      if ("DEVICE_SPEAKERPHONE".equals(paramAdapterView.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_JavaLangString, 2, "Trae_DRP 0X8008D1F at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D1F", "0X8008D1F", 0, 0, "", "", "", "");
      }
      else if ("DEVICE_EARPHONE".equals(paramAdapterView.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_JavaLangString, 2, "Trae_DRP 0X8008D21-1 at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 1, 0, "", "", "", "");
      }
      else if ("DEVICE_WIREDHEADSET".equals(paramAdapterView.jdField_a_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsTraeHelper.jdField_a_of_type_JavaLangString, 2, "Trae_DRP 0X8008D21-2 at: " + System.currentTimeMillis());
        }
        ReportController.b(null, "CliOper", "", "", "0X8008D21", "0X8008D21", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kjk
 * JD-Core Version:    0.7.0.1
 */