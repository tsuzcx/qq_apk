import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class mjf
  implements DialogInterface.OnClickListener
{
  public mjf(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface arg1, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {}
    long l;
    do
    {
      do
      {
        return;
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
        if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g != null)) {
          bcst.b(null, "CliOper", "", "", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g, 0, 0, "", "", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h, "");
        }
        mue.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.x != 2) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.x != 1));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      l = Long.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
    } while (paramInt == -1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().c.remove(paramInt);
    synchronized (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().d)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().b(l, 1);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().d.remove(paramInt);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */