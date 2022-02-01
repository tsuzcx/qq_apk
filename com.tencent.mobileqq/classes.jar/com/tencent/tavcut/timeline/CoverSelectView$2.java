package com.tencent.tavcut.timeline;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.session.TAVCutVideoSession;

class CoverSelectView$2
  implements CoverPreviewBar.OnPreviewBarSlideListener
{
  CoverSelectView$2(CoverSelectView paramCoverSelectView) {}
  
  public void onProgressChanged(CoverPreviewBar paramCoverPreviewBar, float paramFloat, int paramInt)
  {
    if (CoverSelectView.access$400(this.this$0) != null)
    {
      if (CoverSelectView.access$400(this.this$0).getDuration() == null) {
        return;
      }
      float f1 = 1.0F * paramFloat / 100.0F;
      float f2 = CoverSelectView.access$400(this.this$0).getDuration().getTimeSeconds();
      if (CoverSelectView.access$500(this.this$0) != null) {
        CoverSelectView.access$500(this.this$0).seekToTime(new CMTime(f1 * f2));
      }
      if ((CoverSelectView.access$500(this.this$0) != null) && (CoverSelectView.access$500(this.this$0).isPlaying())) {
        CoverSelectView.access$500(this.this$0).pause();
      }
      CoverSelectView.access$302(this.this$0, paramFloat);
    }
  }
  
  public void onStartTouchSlide(CoverPreviewBar paramCoverPreviewBar) {}
  
  public void onStopTouchSlide(CoverPreviewBar paramCoverPreviewBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.CoverSelectView.2
 * JD-Core Version:    0.7.0.1
 */