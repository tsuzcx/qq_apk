import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.utils.SignalStrengthReport;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kbf
  implements Runnable
{
  public kbf(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    String str;
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      str = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      if (str == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.a.c, 2, "can not get shape info");
        }
        return;
      }
      if (this.a.k != null)
      {
        if (!AudioHelper.b) {
          break label230;
        }
        localObject = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject == null) || (((AVActivity)localObject).a == null)) {
          break label230;
        }
        localObject = ((AVActivity)localObject).a.a();
        str = str + "\r\n" + (String)localObject;
      }
    }
    label196:
    label230:
    for (;;)
    {
      localObject = str;
      try
      {
        str = str + "\r\n";
        localObject = str;
        str = str + SignalStrengthReport.a(VideoController.a().a()).a();
        localObject = str;
        str = str + "\r\n";
        localObject = str;
      }
      catch (Exception localException)
      {
        break label196;
      }
      this.a.k.setText((CharSequence)localObject);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbf
 * JD-Core Version:    0.7.0.1
 */