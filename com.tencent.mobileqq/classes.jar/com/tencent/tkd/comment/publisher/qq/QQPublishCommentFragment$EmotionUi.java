package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;

class QQPublishCommentFragment$EmotionUi
  implements View.OnClickListener
{
  private final ImageView vEmoButton;
  private View vEmotionPanel;
  
  QQPublishCommentFragment$EmotionUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vEmoButton = ((ImageView)paramDialog.findViewById(R.id.p));
    this.vEmoButton.setOnClickListener(this);
  }
  
  private void onEmotionBtn()
  {
    if ((QQPublishCommentFragment.access$1500(this.this$0) == 2) && (QQPublishCommentFragment.access$1600(this.this$0) == 1))
    {
      QQPublishCommentFragment.access$1700(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1602(this.this$0, 1);
    QQPublishCommentFragment.access$1800(this.this$0, 2);
    reportOpenEmotionPanel();
  }
  
  private void reportOpenEmotionPanel()
  {
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, "", "0X800844B", "0X800844B", "", "", "", QQPublishCommentFragment.access$1900(localQQPublishCommentFragment, false));
  }
  
  View getEmotionPanel()
  {
    if (this.vEmotionPanel == null) {
      this.vEmotionPanel = this.this$0.viewBridge.getEmotionPanel(QQPublishCommentFragment.access$2100(this.this$0));
    }
    return this.vEmotionPanel;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vEmoButton) {
      onEmotionBtn();
    }
  }
  
  void onStatusChanged()
  {
    ImageView localImageView = this.vEmoButton;
    int i;
    if ((QQPublishCommentFragment.access$2000(this.this$0) == 2) && (QQPublishCommentFragment.access$1600(this.this$0) == 1)) {
      i = R.drawable.e;
    } else {
      i = R.drawable.c;
    }
    localImageView.setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.EmotionUi
 * JD-Core Version:    0.7.0.1
 */