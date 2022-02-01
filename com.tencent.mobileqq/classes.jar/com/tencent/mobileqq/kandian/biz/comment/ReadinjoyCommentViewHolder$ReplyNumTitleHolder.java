package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;

public class ReadinjoyCommentViewHolder$ReplyNumTitleHolder
{
  TextView a;
  View b;
  View c;
  
  public View a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = paramReadinjoyCommentListBaseAdapter.g().inflate(2131626166, paramViewGroup, false);
      this.a = ((TextView)paramView.findViewById(2131448814));
      if (this.a.getPaint() != null) {
        this.a.getPaint().setFakeBoldText(true);
      }
      this.b = paramView.findViewById(2131449828);
      this.b.setVisibility(0);
      this.c = paramView.findViewById(2131449815);
      this.c.setVisibility(0);
    }
    paramView.setTag(this);
    return paramView;
  }
  
  public void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt)
  {
    if (paramReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    Object localObject = (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = HardCodeUtil.a(2131910236);
    if ((((CommentViewItem)localObject).c != null) && (paramReadinjoyCommentListBaseAdapter.f() != null)) {
      paramReadinjoyCommentListBaseAdapter = String.valueOf(paramReadinjoyCommentListBaseAdapter.f().d(((CommentViewItem)localObject).c.commentId));
    } else {
      paramReadinjoyCommentListBaseAdapter = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" ");
    localSpannableStringBuilder.append(((StringBuilder)localObject).toString());
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#262626")), 0, str.length(), 34);
    localSpannableStringBuilder.append(paramReadinjoyCommentListBaseAdapter);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#737373")), str.length(), localSpannableStringBuilder.length(), 34);
    this.a.setText(localSpannableStringBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentViewHolder.ReplyNumTitleHolder
 * JD-Core Version:    0.7.0.1
 */