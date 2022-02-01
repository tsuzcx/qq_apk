import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.gaudio.GaInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class lnh
  implements DialogInterface.OnClickListener
{
  public lnh(GaInviteActivity paramGaInviteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.a, true, new lni(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */