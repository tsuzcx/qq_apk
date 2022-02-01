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

class ReadInJoyCommentComponentFragment$11
  implements TextWatcher
{
  ReadInJoyCommentComponentFragment$11(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = RIJEmotionUtil.a(paramEditable);
    if (this.a.i != null) {
      if (this.a.G - i < -99) {
        this.a.i.setText("-99");
      } else {
        this.a.i.setText(String.valueOf(this.a.G - i));
      }
    }
    if (i - this.a.G > 0)
    {
      this.a.i.setTextColor(Color.parseColor("#FF4222"));
      this.a.K = true;
    }
    else
    {
      this.a.i.setTextColor(this.a.getResources().getColor(2131165949));
      this.a.K = false;
    }
    ReadInJoyCommentComponentFragment.g(this.a);
    ZhituManager localZhituManager = ReadInJoyCommentComponentFragment.i(this.a);
    if (localZhituManager != null)
    {
      i = paramEditable.toString().trim().length();
      if (i <= 0) {
        this.a.k.setVisibility(8);
      } else {
        this.a.k.setVisibility(0);
      }
      if ((i > 0) && (paramEditable.length() <= 24) && (localZhituManager.a(paramEditable)))
      {
        if (ReadInJoyCommentComponentFragment.j(this.a))
        {
          localZhituManager.a(ReadInJoyCommentComponentFragment.b(this.a).app, paramEditable, null, 7220, false);
          this.a.R.removeMessages(84);
          this.a.R.sendEmptyMessageDelayed(84, 10000L);
        }
        this.a.k.setImageResource(2130843885);
        return;
      }
      localZhituManager.o();
      ReadInJoyCommentComponentFragment.c(this.a, false);
      this.a.k.setSelected(false);
      this.a.k.setImageResource(2130844294);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.11
 * JD-Core Version:    0.7.0.1
 */