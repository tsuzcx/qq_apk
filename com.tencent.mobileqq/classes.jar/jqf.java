import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;

public class jqf
  implements View.OnClickListener
{
  public jqf(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().u) {}
    for (;;)
    {
      return;
      int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
      if ((i == 1) || (i == 2))
      {
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().g()) {
          this.a.a(this.a.c, this.a.d, this.a.j);
        }
      }
      else {
        while (AVActivity.a(this.a) != null)
        {
          AVActivity.a(this.a).a();
          return;
          if ((i == 3) || (i == 4))
          {
            paramView = this.a.jdField_a_of_type_ComTencentAvVideoController.a().q;
            String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.a.d, paramView, null);
            if (QLog.isColorLevel()) {
              QLog.d(this.a.b, 2, "enterChatWin-->uin: " + paramView + ", uintype: " + this.a.d + ", name: " + str);
            }
            this.a.a(paramView, this.a.d, str);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jqf
 * JD-Core Version:    0.7.0.1
 */