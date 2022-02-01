package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;

class QQPublishCommentFragment$EmotionUi
  implements View.OnClickListener
{
  private final ImageView vEmoButton;
  private View vEmotionPanel;
  
  QQPublishCommentFragment$EmotionUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vEmoButton = ((ImageView)paramDialog.findViewById(R.id.g));
    this.vEmoButton.setOnClickListener(this);
  }
  
  View getEmotionPanel()
  {
    if (this.vEmotionPanel == null) {
      this.vEmotionPanel = this.this$0.viewBridge.getEmotionPanel(QQPublishCommentFragment.access$1800(this.this$0));
    }
    return this.vEmotionPanel;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vEmoButton) {
      switchPanel();
    }
  }
  
  void onStatusChanged()
  {
    ImageView localImageView = this.vEmoButton;
    int i;
    if ((QQPublishCommentFragment.access$1700(this.this$0) == 2) && (QQPublishCommentFragment.access$1400(this.this$0) == 1)) {
      i = R.drawable.c;
    } else {
      i = R.drawable.a;
    }
    localImageView.setImageResource(i);
  }
  
  void switchPanel()
  {
    if ((QQPublishCommentFragment.access$1300(this.this$0) == 2) && (QQPublishCommentFragment.access$1400(this.this$0) == 1))
    {
      QQPublishCommentFragment.access$1500(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1402(this.this$0, 1);
    QQPublishCommentFragment.access$1600(this.this$0, 2);
    this.this$0.reportBridge.reportOpenEmotionPanel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.EmotionUi
 * JD-Core Version:    0.7.0.1
 */