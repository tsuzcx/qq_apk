import android.graphics.Bitmap;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QAVNotification;

public class jdn
  implements Runnable
{
  public jdn(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = this.a.a.getDisplayName(this.a.a().i, this.a.a().q, null);
    Bitmap localBitmap = this.a.a.a(this.a.a().i, this.a.a().q, null, true, true);
    QAVNotification.a(this.a.a).a(this.a.a().b, str, localBitmap, this.a.a().q, 44, this.a.a().i, this.a.a().d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdn
 * JD-Core Version:    0.7.0.1
 */