package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQView;

class QQPublishCommentFragment$EmotionUi
  implements View.OnClickListener
{
  private final ImageView vEmoButton;
  private View vEmotionPanel;
  
  QQPublishCommentFragment$EmotionUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vEmoButton = ((ImageView)paramDialog.findViewById(2131366225));
    this.vEmoButton.setOnClickListener(this);
  }
  
  private void onEmotionBtn()
  {
    if ((QQPublishCommentFragment.access$1400(this.this$0) == 2) && (QQPublishCommentFragment.access$1500(this.this$0) == 1))
    {
      QQPublishCommentFragment.access$1600(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1502(this.this$0, 1);
    QQPublishCommentFragment.access$1700(this.this$0, 2);
    reportOpenEmotionPanel();
  }
  
  private void reportOpenEmotionPanel()
  {
    TkdQQReport.publicAccountReportClickEvent("", "0X800844B", "0X800844B", "", "", "", QQPublishCommentFragment.access$1800(this.this$0, false));
  }
  
  View getEmotionPanel()
  {
    if (this.vEmotionPanel == null) {
      this.vEmotionPanel = TkdQQView.getEmotionPanel(QQPublishCommentFragment.access$2000(this.this$0));
    }
    return this.vEmotionPanel;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vEmoButton) {
      onEmotionBtn();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  void onStatusChanged()
  {
    ImageView localImageView = this.vEmoButton;
    if ((QQPublishCommentFragment.access$1900(this.this$0) == 2) && (QQPublishCommentFragment.access$1500(this.this$0) == 1)) {}
    for (int i = 2130851091;; i = 2130851087)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.EmotionUi
 * JD-Core Version:    0.7.0.1
 */