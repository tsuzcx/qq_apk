import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class kcn
  implements DialogInterface.OnClickListener
{
  public kcn(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.o) {
      ReportController.b(null, "CliOper", "", "", this.a.g, this.a.g, 0, 0, "", "", this.a.h, "");
    }
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference != null) {
      UITools.a((AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get());
    }
    if ((this.a.w == 2) || (this.a.w == 1))
    {
      this.a.b.update(null, new Object[] { Integer.valueOf(106) });
      long l = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
      if (paramInt != -1) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.remove(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kcn
 * JD-Core Version:    0.7.0.1
 */