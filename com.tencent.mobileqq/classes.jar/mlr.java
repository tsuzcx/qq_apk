import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;

class mlr
  implements DialogInterface.OnClickListener
{
  mlr(mlp parammlp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    msa.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a.a != null) && (this.a.a.a.a != null)) {
        this.a.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mlr
 * JD-Core Version:    0.7.0.1
 */