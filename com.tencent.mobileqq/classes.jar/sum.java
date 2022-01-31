import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

public class sum
  implements DialogInterface.OnDismissListener
{
  public sum(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.b(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sum
 * JD-Core Version:    0.7.0.1
 */