import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.DiscussionHandler;

class svt
  implements Runnable
{
  svt(svs paramsvs) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a.a.a(this.a.a.f);
    this.a.a.runOnUiThread(new svu(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svt
 * JD-Core Version:    0.7.0.1
 */