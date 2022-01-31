import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.common.util.FileChooserHelper;

public class klv
  implements DialogInterface.OnCancelListener
{
  public klv(FileChooserHelper paramFileChooserHelper) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klv
 * JD-Core Version:    0.7.0.1
 */