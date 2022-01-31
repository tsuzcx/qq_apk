import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.common.util.FileChooserHelper;

public class kmk
  implements DialogInterface.OnCancelListener
{
  public kmk(FileChooserHelper paramFileChooserHelper) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmk
 * JD-Core Version:    0.7.0.1
 */