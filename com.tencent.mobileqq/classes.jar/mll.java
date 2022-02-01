import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;

class mll
  implements DialogInterface.OnClickListener
{
  mll(mlj parammlj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    mru.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a.a != null) && (this.a.a.a.a != null)) {
        this.a.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mll
 * JD-Core Version:    0.7.0.1
 */