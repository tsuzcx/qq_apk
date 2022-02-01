import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.beauty.BeautyView;

public class mlt
  implements DialogInterface.OnClickListener
{
  public mlt(BeautyView paramBeautyView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */