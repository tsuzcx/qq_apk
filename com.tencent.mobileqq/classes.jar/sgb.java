import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import java.lang.ref.WeakReference;

public class sgb
  implements DialogInterface.OnCancelListener
{
  private final WeakReference a;
  
  public sgb(ChatHistoryForC2C paramChatHistoryForC2C)
  {
    this.a = new WeakReference(paramChatHistoryForC2C);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (ChatHistoryForC2C)this.a.get();
    if ((paramDialogInterface != null) && (paramDialogInterface.a != null)) {
      paramDialogInterface.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgb
 * JD-Core Version:    0.7.0.1
 */