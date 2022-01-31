import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;

class jfx
  implements DialogInterface.OnClickListener
{
  jfx(jfw paramjfw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a().c == null) {
      this.a.a.a().c = this.a.a.a().a.c;
    }
    this.a.a.a("AnyChatReqTimeoutRunnable", 2131230741, 1, this.a.a.b);
    this.a.a.a().a("AnyChatReqTimeoutRunnable", 6);
    this.a.a.a.a(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.a.a.a().c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jfx
 * JD-Core Version:    0.7.0.1
 */