import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.ThreadManager;

public class ryq
  implements DialogInterface.OnClickListener
{
  public ryq(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.post(new ryr(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryq
 * JD-Core Version:    0.7.0.1
 */