package dov.com.qq.im.ae.biz.qcircle.widget;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AECircleVideoPreviewItemView$3
  implements SeekBar.OnSeekBarChangeListener
{
  AECircleVideoPreviewItemView$3(AECircleVideoPreviewItemView paramAECircleVideoPreviewItemView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((AECircleVideoPreviewItemView.a(this.a) == null) || (AECircleVideoPreviewItemView.a(this.a) == null) || (AECircleVideoPreviewItemView.a(this.a) == null)) {}
    while (!paramBoolean) {
      return;
    }
    AECircleVideoPreviewItemView.a(this.a).seekTo((int)(paramInt / paramSeekBar.getMax() * (float)AECircleVideoPreviewItemView.a(this.a).mDuration));
    AECircleVideoPreviewItemView.a(this.a, paramInt);
    AECircleVideoPreviewItemView.a(this.a).setText(AECircleVideoPreviewItemView.a(this.a, (int)(paramInt / paramSeekBar.getMax() * (float)AECircleVideoPreviewItemView.a(this.a).mDuration)));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.AECircleVideoPreviewItemView.3
 * JD-Core Version:    0.7.0.1
 */