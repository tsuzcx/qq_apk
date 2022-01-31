import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.DiscussionHandler;

class ssx
  implements Runnable
{
  ssx(ssw paramssw) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a.a.a(this.a.a.f);
    this.a.a.runOnUiThread(new ssy(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssx
 * JD-Core Version:    0.7.0.1
 */