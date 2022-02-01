package com.tencent.mobileqq.emoticonview.relateemo;

import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class RelatedEmotionPanel$1
  implements RelatedEmoSlideBottomPanel.Callback
{
  RelatedEmotionPanel$1(RelatedEmotionPanel paramRelatedEmotionPanel) {}
  
  public void onDismiss(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismiss type: ");
      localStringBuilder.append(paramInt);
      QLog.d("RelatedEmotionPanel", 4, localStringBuilder.toString());
    }
    if (paramInt > -1) {
      ReportController.b(RelatedEmotionPanel.access$100(this.this$0), "dc00898", "", this.this$0.mCurFriendUin, "0X800B11A", "0X800B11A", paramInt, 0, "", "", "", "");
    }
    this.this$0.dismissEmotionSearchWinow();
    if (paramInt == 2) {
      AbstractGifImage.resumeAll();
    }
  }
  
  public void onPanelEndDrag() {}
  
  public void onPanelStartDrag() {}
  
  public void updatePanelDistance(float paramFloat)
  {
    if (RelatedEmotionPanel.access$000(this.this$0) != null) {
      RelatedEmotionPanel.access$000(this.this$0).updatePanelDistance(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel.1
 * JD-Core Version:    0.7.0.1
 */