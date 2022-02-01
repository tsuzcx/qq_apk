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
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View b;
  
  public View a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = paramReadinjoyCommentListBaseAdapter.a().inflate(2131560119, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379930));
      if (this.jdField_a_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380850);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.b = paramView.findViewById(2131380839);
      this.b.setVisibility(0);
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
    String str = HardCodeUtil.a(2131712658);
    if ((((CommentViewItem)localObject).a != null) && (paramReadinjoyCommentListBaseAdapter.a() != null)) {
      paramReadinjoyCommentListBaseAdapter = String.valueOf(paramReadinjoyCommentListBaseAdapter.a().a(((CommentViewItem)localObject).a.commentId));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentViewHolder.ReplyNumTitleHolder
 * JD-Core Version:    0.7.0.1
 */