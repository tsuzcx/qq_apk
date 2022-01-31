import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.ui.AVActivity;

public class jro
  implements View.OnClickListener
{
  public jro(AVActivity paramAVActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity.n();
    AVActivity.a(this.jdField_a_of_type_ComTencentAvUiAVActivity, 2, false);
    MagicDataReport.d(this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.a.a().c) + "");
    AVLog.c(this.jdField_a_of_type_ComTencentAvUiAVActivity.b, "showDoubleScreenTips click: " + this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.a(Integer.valueOf(6100), this.jdField_a_of_type_JavaLangString, Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jro
 * JD-Core Version:    0.7.0.1
 */