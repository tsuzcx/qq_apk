import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsPlayManager.VideoPlayParam;

public class mog
  implements SeekBar.OnSeekBarChangeListener
{
  public mog(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((FastWebVideoFeedsPlayManager.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    FastWebVideoFeedsPlayManager.b(this.a, System.currentTimeMillis());
    long l = FastWebVideoFeedsPlayManager.a(this.a).b();
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    VideoFeedsHelper.a(FastWebVideoFeedsPlayManager.a(this.a).a, paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    FastWebVideoFeedsPlayManager.d(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (FastWebVideoFeedsPlayManager.a(this.a) == null) {
      return;
    }
    FastWebVideoFeedsPlayManager.d(this.a, false);
    int i = paramSeekBar.getProgress();
    long l = FastWebVideoFeedsPlayManager.a(this.a).b();
    i = (int)(i / 100.0D * l);
    FastWebVideoFeedsPlayManager.a(this.a).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mog
 * JD-Core Version:    0.7.0.1
 */