import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.guild.GuildMultiActivity;

public class jiv
  implements DialogInterface.OnClickListener
{
  public jiv(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jiv
 * JD-Core Version:    0.7.0.1
 */