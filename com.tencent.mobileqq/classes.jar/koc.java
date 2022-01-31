import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.common.util.FileChooserHelper;

public class koc
  implements DialogInterface.OnCancelListener
{
  public koc(FileChooserHelper paramFileChooserHelper) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     koc
 * JD-Core Version:    0.7.0.1
 */