import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;

public class jev
  implements Runnable
{
  public jev(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "networkBrokenRunnable");
    }
    if (this.a.l())
    {
      Context localContext = this.a.a();
      PopupDialog.b(localContext, 230, null, localContext.getString(2131428687), 0, 2131428674, new jew(this), null);
    }
    for (;;)
    {
      VideoController.a(this.a, false);
      return;
      if ((this.a.a().g > 0) && (this.a.a().g <= 4))
      {
        this.a.a(this.a.a().c, 0);
        this.a.b(215);
        this.a.c(this.a.a().c, 9);
      }
      else
      {
        this.a.a(this.a.c, this.a.jdField_a_of_type_Long, 15, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jev
 * JD-Core Version:    0.7.0.1
 */