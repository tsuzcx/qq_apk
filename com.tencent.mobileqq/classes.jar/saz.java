import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class saz
  extends Handler
{
  public saz(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.c(2131434483);
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     saz
 * JD-Core Version:    0.7.0.1
 */