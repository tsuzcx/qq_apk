package com.tencent.tkd.comment.publisher.qq;

import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.tkd.comment.publisher.qq.bridge.QQViewBridge;

class QQPublishCommentFragment$MyTextWatcher
  implements TextWatcher
{
  private QQPublishCommentFragment$MyTextWatcher(QQPublishCommentFragment paramQQPublishCommentFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.this$0.viewBridge.getTextLength(paramEditable);
    if (QQPublishCommentFragment.access$500(this.this$0) - i < -99) {
      QQPublishCommentFragment.access$600(this.this$0).setText("-99");
    } else {
      QQPublishCommentFragment.access$600(this.this$0).setText(String.valueOf(QQPublishCommentFragment.access$500(this.this$0) - i));
    }
    if (i - QQPublishCommentFragment.access$500(this.this$0) > 0)
    {
      QQPublishCommentFragment.access$600(this.this$0).setTextColor(Color.parseColor("#FF4222"));
      QQPublishCommentFragment.access$702(this.this$0, true);
    }
    else
    {
      QQPublishCommentFragment.access$600(this.this$0).setTextColor(this.this$0.getResources().getColor(R.color.a));
      QQPublishCommentFragment.access$702(this.this$0, false);
    }
    QQPublishCommentFragment.access$800(this.this$0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.MyTextWatcher
 * JD-Core Version:    0.7.0.1
 */