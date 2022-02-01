package com.tencent.tkd.comment.publisher.qq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.tkd.comment.publisher.qq.R.drawable;
import com.tencent.tkd.comment.publisher.qq.R.id;
import com.tencent.tkd.comment.publisher.qq.R.layout;
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
    this.vRoot = View.inflate(paramTkdCommentLinkView.getContext(), R.layout.a, null);
    paramTkdCommentLinkView.addView(this.vRoot, paramTkdCommentLinkView.getChildCount());
    this.vDelete = this.vRoot.findViewById(R.id.m);
    this.vIcon = ((TkdQQUrlImageView)this.vRoot.findViewById(R.id.s));
    this.vDescription = ((TextView)this.vRoot.findViewById(R.id.o));
    this.vDelete.setOnClickListener(this);
    this.vDescription.setText(paramTkdCommentLinkData.wording);
    int i = paramTkdCommentLinkData.type;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              i = 0;
            } else {
              i = R.drawable.j;
            }
          }
          else {
            i = R.drawable.i;
          }
        }
        else {
          i = R.drawable.g;
        }
      }
      else {
        i = R.drawable.f;
      }
    }
    else {
      i = R.drawable.h;
    }
    this.vIcon.urlImageBridge = paramTkdCommentLinkView.urlImageBridge;
    this.vIcon.setImageResource(i);
    this.vIcon.setUrl(paramTkdCommentLinkData.iconUrl, 100, 100);
  }
  
  public void onClick(View paramView)
  {
    this.this$0.removeView(this.vRoot);
    TkdCommentLinkView.access$000(this.this$0).remove(this.linkData);
    if (TkdCommentLinkView.access$100(this.this$0) != null) {
      TkdCommentLinkView.access$100(this.this$0).onDeleteLink();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.widget.TkdCommentLinkView.Holder
 * JD-Core Version:    0.7.0.1
 */