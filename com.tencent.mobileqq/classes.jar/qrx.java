import android.media.AudioManager;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class qrx
  implements Runnable
{
  qrx(qrw paramqrw) {}
  
  public void run()
  {
    GdtVideoCommonView.a(this.a.a, GdtVideoCommonView.a(this.a.a).getStreamVolume(3), GdtVideoCommonView.e(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */