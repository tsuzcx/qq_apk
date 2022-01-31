import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppVideoView;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kxj
  implements Runnable
{
  public kxj(ReadInJoyNativeAdAppVideoView paramReadInJoyNativeAdAppVideoView) {}
  
  public void run()
  {
    if ((ReadInJoyNativeAdAppVideoView.a(this.a) != null) && (ReadInJoyNativeAdAppVideoView.a(this.a).isPlaying()))
    {
      long l = ReadInJoyNativeAdAppVideoView.a(this.a).getCurrentPostion();
      ReadInJoyNativeAdAppVideoView.a(this.a, ReadInJoyNativeAdAppVideoView.a(this.a).getDuration());
      int i = (int)((float)l * 1.0F * ReadInJoyNativeAdAppVideoView.b(this.a) / (float)ReadInJoyNativeAdAppVideoView.a(this.a) + 0.5D);
      ReadInJoyNativeAdAppVideoView.a(this.a).setProgress(i);
      ReadInJoyNativeAdAppVideoView.a(this.a).setText(GdtUIUtils.a(l));
      ReadInJoyNativeAdAppVideoView.b(this.a).setText(GdtUIUtils.a(ReadInJoyNativeAdAppVideoView.a(this.a)));
      if (ReadInJoyNativeAdAppVideoView.a(this.a) - l >= 50L) {
        break label330;
      }
      if (!ReadInJoyNativeAdAppVideoView.a(this.a))
      {
        ReadInJoyNativeAdAppVideoView.a(this.a, (int)(ReadInJoyNativeAdAppVideoView.a(this.a) / 1000L));
        ReadInJoyNativeAdAppVideoView.b(this.a, 1);
        NativeAdUtils.a(ReadInJoyNativeAdAppVideoView.a(this.a), this.a.getContext(), NativeAdUtils.f, 9, ReadInJoyNativeAdAppVideoView.a(this.a), null, 0L, NativeAdUtils.a(ReadInJoyNativeAdAppVideoView.c(this.a), ReadInJoyNativeAdAppVideoView.d(this.a), ReadInJoyNativeAdAppVideoView.e(this.a), ReadInJoyNativeAdAppVideoView.f(this.a), ReadInJoyNativeAdAppVideoView.g(this.a), ReadInJoyNativeAdAppVideoView.h(this.a), (int)(ReadInJoyNativeAdAppVideoView.a(this.a) / 1000L), NativeAdUtils.t));
        ReadInJoyNativeAdAppVideoView.c(this.a, 0);
        ReadInJoyNativeAdAppVideoView.d(this.a, 1);
        ReadInJoyNativeAdAppVideoView.b(this.a, 0);
        ReadInJoyNativeAdAppVideoView.a(this.a, true);
      }
    }
    for (;;)
    {
      ReadInJoyNativeAdAppVideoView.a(this.a).postDelayed(this, 50L);
      return;
      label330:
      ReadInJoyNativeAdAppVideoView.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxj
 * JD-Core Version:    0.7.0.1
 */