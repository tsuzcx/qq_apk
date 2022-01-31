import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

class rhn
  implements DialogInterface.OnShowListener
{
  rhn(rhf paramrhf) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rhf.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a.getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rhn
 * JD-Core Version:    0.7.0.1
 */