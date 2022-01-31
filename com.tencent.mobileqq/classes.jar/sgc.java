import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.Conversation;

public class sgc
  implements DialogInterface.OnDismissListener
{
  public sgc(Conversation paramConversation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
    this.a.a(1134057, 50L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgc
 * JD-Core Version:    0.7.0.1
 */