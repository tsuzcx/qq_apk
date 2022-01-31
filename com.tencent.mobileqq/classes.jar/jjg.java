import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.qphone.base.util.QLog;

public class jjg
  implements DialogInterface.OnClickListener
{
  public jjg(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GuildMultiActivity.a, 2, "showEnterRoomFailDialog: exitMultiRoom");
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjg
 * JD-Core Version:    0.7.0.1
 */