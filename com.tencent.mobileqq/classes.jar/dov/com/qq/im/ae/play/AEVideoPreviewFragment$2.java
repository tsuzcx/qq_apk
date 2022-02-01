package dov.com.qq.im.ae.play;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import bodl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;

class AEVideoPreviewFragment$2
  implements SeekBar.OnSeekBarChangeListener
{
  AEVideoPreviewFragment$2(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    float f = paramInt / 1000.0F / 1000.0F;
    if (paramBoolean)
    {
      paramSeekBar = new CMTime(f);
      this.this$0.mMoviePlayer.seekToTime(paramSeekBar);
    }
    paramSeekBar = bodl.a((f * 1000.0F));
    this.this$0.tvCurrentDuration.setText(paramSeekBar);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AEVideoPreviewFragment.access$100(this.this$0);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AEVideoPreviewFragment.access$200(this.this$0);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEVideoPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */