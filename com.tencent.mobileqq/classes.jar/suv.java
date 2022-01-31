import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;

public class suv
  implements DialogInterface.OnDismissListener
{
  public suv(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GroupManagerActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suv
 * JD-Core Version:    0.7.0.1
 */