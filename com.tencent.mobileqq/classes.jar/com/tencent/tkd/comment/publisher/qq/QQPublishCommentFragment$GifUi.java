package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;

class QQPublishCommentFragment$GifUi
  implements View.OnClickListener
{
  private final View vDelete;
  private final ImageView vGifButton;
  private final RelativeLayout vGifImageContainer;
  private final ImageView vGifImageView;
  private View vGifPanel;
  
  QQPublishCommentFragment$GifUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vGifButton = ((ImageView)paramDialog.findViewById(R.id.i));
    this.vGifButton.setOnClickListener(this);
    this.vGifImageContainer = ((RelativeLayout)paramDialog.findViewById(R.id.k));
    this.vGifImageView = ((ImageView)paramDialog.findViewById(R.id.l));
    this.vDelete = paramDialog.findViewById(R.id.m);
    this.vDelete.setOnClickListener(this);
  }
  
  private void onGifAdd(Drawable paramDrawable)
  {
    this.vGifImageView.setImageDrawable(paramDrawable);
    this.vGifImageContainer.setVisibility(0);
    QQPublishCommentFragment.access$800(this.this$0);
  }
  
  private void onGifDelete()
  {
    this.vGifImageContainer.setVisibility(8);
    if (this.this$0.viewBridge.hasGif()) {
      this.this$0.reportBridge.reportDeleteGif();
    }
    this.this$0.viewBridge.deleteGif();
    QQPublishCommentFragment.access$800(this.this$0);
  }
  
  private void switchPanel()
  {
    if ((QQPublishCommentFragment.access$1900(this.this$0) == 2) && (QQPublishCommentFragment.access$1400(this.this$0) == 2))
    {
      QQPublishCommentFragment.access$2000(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1402(this.this$0, 2);
    QQPublishCommentFragment.access$2100(this.this$0, 2);
    this.this$0.reportBridge.reportOpenGifPanel();
  }
  
  public View getGifPanel()
  {
    if (this.vGifPanel == null) {
      this.vGifPanel = this.this$0.viewBridge.getGifPanel(QQPublishCommentFragment.access$1800(this.this$0));
    }
    return this.vGifPanel;
  }
  
  void initData()
  {
    ImageView localImageView = this.vGifButton;
    int i;
    if (QQPublishCommentFragment.access$1200(this.this$0).showGif) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vGifButton)
    {
      switchPanel();
      return;
    }
    if (paramView == this.vDelete) {
      onGifDelete();
    }
  }
  
  void onStatusChanged()
  {
    ImageView localImageView = this.vGifButton;
    int i;
    if ((QQPublishCommentFragment.access$2200(this.this$0) == 2) && (QQPublishCommentFragment.access$1400(this.this$0) == 2)) {
      i = R.drawable.c;
    } else {
      i = R.drawable.b;
    }
    localImageView.setImageResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.GifUi
 * JD-Core Version:    0.7.0.1
 */