import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.AnyChatReqTimeoutRunnable;
import com.tencent.av.app.VideoAppInterface;

public class lcn
  implements DialogInterface.OnClickListener
{
  public lcn(VideoController.AnyChatReqTimeoutRunnable paramAnyChatReqTimeoutRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.this$0.a().d == null) {
      this.a.this$0.a().d = this.a.this$0.a().a.c;
    }
    this.a.this$0.a(this.a.a, 2131230741, 1, this.a.this$0.b);
    this.a.this$0.a().a("AnyChatReqTimeoutRunnable", 6);
    this.a.this$0.a.a(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.a.this$0.a().d, Long.valueOf(this.a.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcn
 * JD-Core Version:    0.7.0.1
 */