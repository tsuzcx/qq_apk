import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.GVideoGrayConfig;

public final class kfu
  implements DialogInterface.OnClickListener
{
  public kfu(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    GVideoGrayConfig.a(this.a);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kfu
 * JD-Core Version:    0.7.0.1
 */