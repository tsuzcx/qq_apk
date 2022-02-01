import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class lnk
  implements DialogInterface.OnClickListener
{
  public lnk(GaInviteActivity paramGaInviteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.a, true, new lnl(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnk
 * JD-Core Version:    0.7.0.1
 */