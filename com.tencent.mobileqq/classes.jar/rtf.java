import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.widget.share.ShareActionSheet;

class rtf
  implements DialogInterface.OnShowListener
{
  rtf(rsx paramrsx) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    rsx.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a().getWindow().getDecorView().setSystemUiVisibility(rsx.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
    this.a.a.a().getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtf
 * JD-Core Version:    0.7.0.1
 */