package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class StructMsgItemTitle$TitleTextView
  extends TextView
{
  public int a = 0;
  
  public StructMsgItemTitle$TitleTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (paramInt <= 0) {
        return;
      }
      int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, getPaint()));
      if (i > paramInt)
      {
        int j = (int)Math.floor(getTextSize() * paramInt / i);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("adjustTextSize avail:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" width:");
          localStringBuilder.append(i);
          localStringBuilder.append(" oldSize:");
          localStringBuilder.append(getTextSize());
          localStringBuilder.append(" newSize:");
          localStringBuilder.append(j);
          QLog.i("StructMsg", 2, localStringBuilder.toString());
        }
        i = j;
        if (j == getTextSize()) {
          i = j - 1;
        }
        setTextSize(0, i);
        a(paramCharSequence, paramInt);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = getMeasuredWidth();
    paramInt1 = this.a;
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    a(getText(), paramInt1 - paramInt2 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView
 * JD-Core Version:    0.7.0.1
 */