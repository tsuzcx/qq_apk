package com.tencent.qcircle.tavcut.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qcircle.tavcut.bean.Size;

class TAVCutVideoView$1
  implements Runnable
{
  TAVCutVideoView$1(TAVCutVideoView paramTAVCutVideoView, Size paramSize) {}
  
  public void run()
  {
    if (this.val$videoSize.getWidth() * 1.0F / this.val$videoSize.getHeight() < this.this$0.getWidth() * 1.0F / this.this$0.getHeight())
    {
      localLayoutParams = new RelativeLayout.LayoutParams((int)(this.this$0.getHeight() * (this.val$videoSize.getWidth() * 1.0F / this.val$videoSize.getHeight())), this.this$0.getHeight());
      localLayoutParams.addRule(14, -1);
      if (TAVCutVideoView.access$000(this.this$0).getParent() != null) {
        ((ViewGroup)TAVCutVideoView.access$000(this.this$0).getParent()).removeView(TAVCutVideoView.access$000(this.this$0));
      }
      localTAVCutVideoView = this.this$0;
      localTAVCutVideoView.addView(TAVCutVideoView.access$000(localTAVCutVideoView), localLayoutParams);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.this$0.getWidth(), (int)(this.this$0.getWidth() / (this.val$videoSize.getWidth() * 1.0F / this.val$videoSize.getHeight())));
    localLayoutParams.addRule(15, -1);
    if (TAVCutVideoView.access$000(this.this$0).getParent() != null) {
      ((ViewGroup)TAVCutVideoView.access$000(this.this$0).getParent()).removeView(TAVCutVideoView.access$000(this.this$0));
    }
    TAVCutVideoView localTAVCutVideoView = this.this$0;
    localTAVCutVideoView.addView(TAVCutVideoView.access$000(localTAVCutVideoView), localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutVideoView.1
 * JD-Core Version:    0.7.0.1
 */