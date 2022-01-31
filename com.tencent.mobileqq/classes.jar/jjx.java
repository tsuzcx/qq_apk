import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.GuildInfo;
import com.tencent.av.guild.GuildMultiActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class jjx
  implements DialogInterface.OnClickListener
{
  public jjx(GuildMultiActivity paramGuildMultiActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SessionInfo localSessionInfo = SessionMgr.a().a(this.a.e);
    if (localSessionInfo != null)
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", localSessionInfo.a.f);
      this.a.startActivity(localIntent);
      this.a.a(localSessionInfo, 1);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjx
 * JD-Core Version:    0.7.0.1
 */