package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQReport;
import com.tencent.tkd.comment.publisher.qq.util.TkdQQView;

class QQPublishCommentFragment$GifUi
  implements View.OnClickListener
{
  private boolean isSelectedBeforeImage;
  private QQPublishCommentFragment.OnGifChangeListener onGifChangeListener;
  private final View vDelete;
  private final ImageView vGifButton;
  private final RelativeLayout vGifImageContainer;
  private final ImageView vGifImageView;
  private View vGifPanel;
  
  QQPublishCommentFragment$GifUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vGifButton = ((ImageView)paramDialog.findViewById(2131367913));
    this.vGifButton.setOnClickListener(this);
    this.vGifImageContainer = ((RelativeLayout)paramDialog.findViewById(2131368801));
    this.vGifImageView = ((ImageView)paramDialog.findViewById(2131368802));
    this.vDelete = paramDialog.findViewById(2131368805);
    this.vDelete.setOnClickListener(this);
  }
  
  private void onGifAdd(Drawable paramDrawable)
  {
    this.vGifImageView.setImageDrawable(paramDrawable);
    this.vGifImageContainer.setVisibility(0);
    QQPublishCommentFragment.access$800(this.this$0);
    if ((this.onGifChangeListener != null) && (this.onGifChangeListener.onGifSelected())) {
      this.isSelectedBeforeImage = true;
    }
  }
  
  private void onGifBtn()
  {
    if ((QQPublishCommentFragment.access$2100(this.this$0) == 2) && (QQPublishCommentFragment.access$1500(this.this$0) == 2))
    {
      QQPublishCommentFragment.access$2200(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1502(this.this$0, 2);
    QQPublishCommentFragment.access$2300(this.this$0, 2);
    reportOpenGifPanel();
  }
  
  private void onGifDelete()
  {
    this.vGifImageContainer.setVisibility(8);
    if (TkdQQView.hasGif()) {
      reportDeleteGif();
    }
    TkdQQView.deleteGif();
    QQPublishCommentFragment.access$800(this.this$0);
    if (this.onGifChangeListener != null) {
      this.onGifChangeListener.onGifDelete(this.isSelectedBeforeImage);
    }
    this.isSelectedBeforeImage = false;
  }
  
  private void reportDeleteGif()
  {
    TkdQQReport.publicAccountReportClickEvent("", "0X800844D", "0X800844D", "", "", "", QQPublishCommentFragment.access$1800(this.this$0, false));
  }
  
  private void reportOpenGifPanel()
  {
    TkdQQReport.publicAccountReportClickEvent("", "0X800844C", "0X800844C", "", "", "", QQPublishCommentFragment.access$1800(this.this$0, false));
  }
  
  public View getGifPanel()
  {
    if (this.vGifPanel == null) {
      this.vGifPanel = TkdQQView.getGifPanel(QQPublishCommentFragment.access$2000(this.this$0));
    }
    return this.vGifPanel;
  }
  
  void initData()
  {
    ImageView localImageView = this.vGifButton;
    if (QQPublishCommentFragment.access$1200(this.this$0).showGif) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vGifButton) {
      onGifBtn();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.vDelete) {
        onGifDelete();
      }
    }
  }
  
  void onStatusChanged()
  {
    ImageView localImageView = this.vGifButton;
    if ((QQPublishCommentFragment.access$2400(this.this$0) == 2) && (QQPublishCommentFragment.access$1500(this.this$0) == 2)) {}
    for (int i = 2130851091;; i = 2130851089)
    {
      localImageView.setImageResource(i);
      return;
    }
  }
  
  public void setOnGifChangeListener(QQPublishCommentFragment.OnGifChangeListener paramOnGifChangeListener)
  {
    this.onGifChangeListener = paramOnGifChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.GifUi
 * JD-Core Version:    0.7.0.1
 */