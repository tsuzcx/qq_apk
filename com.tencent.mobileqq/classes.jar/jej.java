import android.content.Context;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.PopupDialog;
import com.tencent.qphone.base.util.QLog;

public class jej
  implements Runnable
{
  public jej(VideoController paramVideoController) {}
  
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
        PopupDialog.b(localContext, 230, null, localContext.getString(2131428681), 0, 2131428668, new jek(this), null);
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jej
 * JD-Core Version:    0.7.0.1
 */