package com.tencent.tkd.comment.publisher.qq;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;

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
    this.vGifButton = ((ImageView)paramDialog.findViewById(R.id.r));
    this.vGifButton.setOnClickListener(this);
    this.vGifImageContainer = ((RelativeLayout)paramDialog.findViewById(R.id.t));
    this.vGifImageView = ((ImageView)paramDialog.findViewById(R.id.u));
    this.vDelete = paramDialog.findViewById(R.id.v);
    this.vDelete.setOnClickListener(this);
  }
  
  private void onGifAdd(Drawable paramDrawable)
  {
    this.vGifImageView.setImageDrawable(paramDrawable);
    this.vGifImageContainer.setVisibility(0);
    QQPublishCommentFragment.access$800(this.this$0);
    paramDrawable = this.onGifChangeListener;
    if ((paramDrawable != null) && (paramDrawable.onGifSelected())) {
      this.isSelectedBeforeImage = true;
    }
  }
  
  private void onGifBtn()
  {
    if ((QQPublishCommentFragment.access$2200(this.this$0) == 2) && (QQPublishCommentFragment.access$1600(this.this$0) == 2))
    {
      QQPublishCommentFragment.access$2300(this.this$0, 1);
      return;
    }
    QQPublishCommentFragment.access$1602(this.this$0, 2);
    QQPublishCommentFragment.access$2400(this.this$0, 2);
    reportOpenGifPanel();
  }
  
  private void onGifDelete()
  {
    this.vGifImageContainer.setVisibility(8);
    if (this.this$0.viewBridge.hasGif()) {
      reportDeleteGif();
    }
    this.this$0.viewBridge.deleteGif();
    QQPublishCommentFragment.access$800(this.this$0);
    QQPublishCommentFragment.OnGifChangeListener localOnGifChangeListener = this.onGifChangeListener;
    if (localOnGifChangeListener != null) {
      localOnGifChangeListener.onGifDelete(this.isSelectedBeforeImage);
    }
    this.isSelectedBeforeImage = false;
  }
  
  private void reportDeleteGif()
  {
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, "", "0X800844D", "0X800844D", "", "", "", QQPublishCommentFragment.access$1900(localQQPublishCommentFragment, false));
  }
  
  private void reportOpenGifPanel()
  {
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, "", "0X800844C", "0X800844C", "", "", "", QQPublishCommentFragment.access$1900(localQQPublishCommentFragment, false));
  }
  
  public View getGifPanel()
  {
    if (this.vGifPanel == null) {
      this.vGifPanel = this.this$0.viewBridge.getGifPanel(QQPublishCommentFragment.access$2100(this.this$0));
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
      onGifBtn();
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
    if ((QQPublishCommentFragment.access$2500(this.this$0) == 2) && (QQPublishCommentFragment.access$1600(this.this$0) == 2)) {
      i = R.drawable.e;
    } else {
      i = R.drawable.d;
    }
    localImageView.setImageResource(i);
  }
  
  public void setOnGifChangeListener(QQPublishCommentFragment.OnGifChangeListener paramOnGifChangeListener)
  {
    this.onGifChangeListener = paramOnGifChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.GifUi
 * JD-Core Version:    0.7.0.1
 */