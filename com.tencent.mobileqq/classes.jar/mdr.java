import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mdr
  implements View.OnClickListener
{
  public mdr(AVActivity paramAVActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.isDestroyed()) {}
    for (;;)
    {
      return;
      paramView = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (!paramView.x)
      {
        int i = paramView.d;
        long l = AudioHelper.b();
        QLog.w(this.a.b, 1, "onMsgClick, sessionType[" + i + "], state[" + paramView.jdField_g_of_type_Int + "], seq[" + l + "]");
        if ((i == 1) || (i == 2))
        {
          if (!paramView.n()) {
            this.a.a(l, this.a.c, this.a.d, this.a.k);
          }
        }
        else {
          while (AVActivity.a(this.a) != null)
          {
            AVActivity.a(this.a).a();
            return;
            if ((i == 3) || (i == 4))
            {
              paramView = String.valueOf(paramView.jdField_g_of_type_Long);
              String str = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(this.a.d, paramView, null);
              this.a.a(l, paramView, this.a.d, str);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdr
 * JD-Core Version:    0.7.0.1
 */