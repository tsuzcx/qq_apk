import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;

public class jdu
  implements Runnable
{
  public jdu(VideoController paramVideoController) {}
  
  public void run()
  {
    try
    {
      if (!this.a.a().f())
      {
        if (QLog.isColorLevel()) {
          QLog.e(VideoController.a, 2, "AnyChatReqTimeoutRunnable show dialog!");
        }
        Context localContext = this.a.a();
        PopupDialog.b(localContext, 230, null, localContext.getString(2131428687), 0, 2131428674, new jdv(this), null);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdu
 * JD-Core Version:    0.7.0.1
 */