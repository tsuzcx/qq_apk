import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mdp
  implements View.OnClickListener
{
  public mdp(AVActivity paramAVActivity, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    mdd.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1044);
    this.jdField_a_of_type_ComTencentAvUiAVActivity.a(2, false);
    ljx.e(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvVideoController.a().d) + "");
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, 1, "qav_double_screen_notify, click[" + this.jdField_a_of_type_JavaLangString + "], seq[" + this.jdField_a_of_type_Long + "]");
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      new mez(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, false, 4).a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdp
 * JD-Core Version:    0.7.0.1
 */