import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.ui.GAudioMemberListCtrl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

public class jue
  implements View.OnClickListener
{
  public jue(GAudioMemberListCtrl paramGAudioMemberListCtrl) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    paramView = (juf)paramView.getTag();
    if (paramView.c) {
      if (this.a.jdField_a_of_type_Int == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
      }
    }
    VideoController localVideoController;
    long l;
    do
    {
      if ((paramView.c) && (paramView.d))
      {
        QQToast.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131429602, 1).a();
        if (this.a.jdField_a_of_type_Int == 1) {}
        for (paramView = "0x8007CB5";; paramView = "0x8007CB6")
        {
          DoodleUtils.a(paramView);
          return;
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
          break;
          if (this.a.jdField_a_of_type_Int == 1)
          {
            ReportController.b(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
            break;
          }
          if (this.a.jdField_a_of_type_Int != 2) {
            break;
          }
          ReportController.b(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
          break;
        }
      }
      localVideoController = this.a.jdField_a_of_type_ComTencentAvVideoController;
      l = paramView.a;
      if (!paramView.c) {
        bool = true;
      }
    } while (!localVideoController.a(l, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jue
 * JD-Core Version:    0.7.0.1
 */