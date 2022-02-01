package com.tencent.tkd.comment.publisher.qq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tkd.comment.publisher.qq.model.TkdCommentLinkData;
import java.util.List;

class TkdCommentLinkView$Holder
  implements View.OnClickListener
{
  final TkdCommentLinkData linkData;
  final View vDelete;
  final TextView vDescription;
  final TkdQQUrlImageView vIcon;
  final View vRoot;
  
  TkdCommentLinkView$Holder(TkdCommentLinkView paramTkdCommentLinkView, TkdCommentLinkData paramTkdCommentLinkData)
  {
    this.linkData = paramTkdCommentLinkData;
    this.vRoot = View.inflate(paramTkdCommentLinkView.getContext(), 2131563105, null);
    paramTkdCommentLinkView.addView(this.vRoot, paramTkdCommentLinkView.getChildCount());
    this.vDelete = this.vRoot.findViewById(2131365650);
    this.vIcon = ((TkdQQUrlImageView)this.vRoot.findViewById(2131368603));
    this.vDescription = ((TextView)this.vRoot.findViewById(2131365699));
    this.vDelete.setOnClickListener(this);
    this.vDescription.setText(paramTkdCommentLinkData.wording);
    int i = 0;
    switch (paramTkdCommentLinkData.type)
    {
    }
    for (;;)
    {
      this.vIcon.setImageResource(i);
      this.vIcon.setUrl(paramTkdCommentLinkData.iconUrl, 100, 100);
      return;
      i = 2130851093;
      continue;
      i = 2130851095;
      continue;
      i = 2130851097;
      continue;
      i = 2130851099;
    }
  }
  
  public void onClick(View paramView)
  {
    this.this$0.removeView(this.vRoot);
    TkdCommentLinkView.access$000(this.this$0).remove(this.linkData);
    if (TkdCommentLinkView.access$100(this.this$0) != null) {
      TkdCommentLinkView.access$100(this.this$0).onDeleteLink();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView.Holder
 * JD-Core Version:    0.7.0.1
 */