import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;

class jdv
  implements DialogInterface.OnClickListener
{
  jdv(jdu paramjdu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a().c == null) {
      this.a.a.a().c = this.a.a.a().a.c;
    }
    this.a.a.a("AnyChatReqTimeoutRunnable", 2131230740, 1, this.a.a.b);
    this.a.a.a().a("AnyChatReqTimeoutRunnable", 6);
    this.a.a.a.a(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.a.a.a().c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdv
 * JD-Core Version:    0.7.0.1
 */