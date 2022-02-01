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
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramInt <= 0)) {}
    do
    {
      return;
      i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, getPaint()));
    } while (i <= paramInt);
    int j = (int)Math.floor(getTextSize() * paramInt / i);
    if (QLog.isColorLevel()) {
      QLog.i("StructMsg", 2, "adjustTextSize avail:" + paramInt + " width:" + i + " oldSize:" + getTextSize() + " newSize:" + j);
    }
    int i = j;
    if (j == getTextSize()) {
      i = j - 1;
    }
    setTextSize(0, i);
    a(paramCharSequence, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a = getMeasuredWidth();
    paramInt1 = this.a;
    paramInt2 = getPaddingLeft();
    int i = getPaddingRight();
    a(getText(), paramInt1 - paramInt2 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView
 * JD-Core Version:    0.7.0.1
 */