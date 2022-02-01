import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.widget.share.ShareActionSheet;

class saj
  implements DialogInterface.OnShowListener
{
  saj(sab paramsab) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    sab.a(this.a, "mShareActionSheet onShow()");
    this.a.a.a().getWindow().getDecorView().setSystemUiVisibility(sab.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
    this.a.a.a().getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     saj
 * JD-Core Version:    0.7.0.1
 */