package com.tencent.mobileqq.kandian.biz.comment;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import mqq.os.MqqHandler;

class ReadInJoyCommentComponentFragment$10
  implements TextWatcher
{
  ReadInJoyCommentComponentFragment$10(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = RIJEmotionUtil.a(paramEditable);
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
      if (this.a.c - i < -99) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("-99");
      } else {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c - i));
      }
    }
    if (i - this.a.c > 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF4222"));
      this.a.d = true;
    }
    else
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.a.getResources().getColor(2131165600));
      this.a.d = false;
    }
    ReadInJoyCommentComponentFragment.a(this.a);
    ZhituManager localZhituManager = ReadInJoyCommentComponentFragment.a(this.a);
    if (localZhituManager != null)
    {
      i = paramEditable.toString().trim().length();
      if (i <= 0) {
        this.a.f.setVisibility(8);
      } else {
        this.a.f.setVisibility(0);
      }
      if ((i > 0) && (paramEditable.length() <= 24) && (localZhituManager.a(paramEditable)))
      {
        if (ReadInJoyCommentComponentFragment.a(this.a))
        {
          localZhituManager.a(ReadInJoyCommentComponentFragment.a(this.a).app, paramEditable, null, 7220, false);
          this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
          this.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
        }
        this.a.f.setImageResource(2130842929);
        return;
      }
      localZhituManager.c();
      ReadInJoyCommentComponentFragment.b(this.a, false);
      this.a.f.setSelected(false);
      this.a.f.setImageResource(2130843340);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.10
 * JD-Core Version:    0.7.0.1
 */