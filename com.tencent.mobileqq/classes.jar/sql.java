import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.ViolaVideoView;

public class sql
  implements SeekBar.OnSeekBarChangeListener
{
  public sql(ViolaVideoView paramViolaVideoView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!ViolaVideoView.a(this.a).a()) {
      return;
    }
    long l = ViolaVideoView.a(this.a).a();
    double d = paramInt / 100.0D;
    paramInt = (int)(l * d);
    rdm.a(ViolaVideoView.a(this.a), paramInt);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    ViolaVideoView.a(this.a, true);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (!ViolaVideoView.a(this.a).a()) {}
    int i;
    do
    {
      return;
      ViolaVideoView.a(this.a, false);
      i = paramSeekBar.getProgress();
      long l = ViolaVideoView.a(this.a).a();
      i = (int)(i / 100.0D * l);
      ViolaVideoView.a(this.a).d(i);
    } while (ViolaVideoView.a(this.a) == null);
    ViolaVideoView.a(this.a).b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sql
 * JD-Core Version:    0.7.0.1
 */