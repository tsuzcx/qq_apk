import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class qrr
  implements Runnable
{
  public qrr(GdtVideoCommonView paramGdtVideoCommonView) {}
  
  public void run()
  {
    long l1 = 0L;
    long l2;
    int i;
    if (GdtVideoCommonView.b(this.a))
    {
      l2 = GdtVideoCommonView.a(this.a).getCurrentPostion();
      if (l2 != 0L)
      {
        i = (int)(GdtVideoCommonView.a(this.a) * l2 / GdtVideoCommonView.a(this.a) + 0.5D);
        if (l2 >= 0L) {
          break label117;
        }
      }
    }
    for (;;)
    {
      if (!GdtVideoCommonView.c(this.a))
      {
        GdtVideoCommonView.a(this.a).setProgress(i);
        GdtVideoCommonView.c(this.a).setText(GdtUIUtils.a(l1));
      }
      GdtVideoCommonView.a(this.a).postDelayed(this, 50L);
      return;
      label117:
      l1 = l2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qrr
 * JD-Core Version:    0.7.0.1
 */