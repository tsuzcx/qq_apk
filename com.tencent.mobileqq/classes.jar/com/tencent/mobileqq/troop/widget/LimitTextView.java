package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class LimitTextView
  extends AnimationTextView
{
  private Field a;
  private Field b;
  private Field c;
  private boolean d = true;
  private CharSequence e = null;
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    try
    {
      this.a = TextView.class.getDeclaredField("mMaxMode");
      this.b = TextView.class.getDeclaredField("mMaximum");
      this.c = TextView.class.getDeclaredField("LINES");
      this.a.setAccessible(true);
      this.b.setAccessible(true);
      this.c.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label58:
      break label58;
    }
    this.d = false;
  }
  
  @TargetApi(16)
  public int getMaxLines()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return super.getMaxLines();
    }
    if ((this.d) && ((this.a == null) || (this.b == null) || (this.c == null))) {
      a();
    }
    boolean bool = this.d;
    int i = -1;
    if (!bool) {
      return -1;
    }
    try
    {
      int k = this.a.getInt(this);
      int j = this.b.getInt(this);
      int m = this.c.getInt(this);
      if (k == m) {
        i = j;
      }
      return i;
    }
    catch (IllegalAccessException localIllegalAccessException) {}
    return -1;
  }
  
  public CharSequence getOriginalText()
  {
    CharSequence localCharSequence = this.e;
    if (localCharSequence != null) {
      return localCharSequence;
    }
    return super.getText();
  }
  
  @SuppressLint({"NewApi"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMaxLines();
    if ((paramInt1 > 0) && (super.getLineCount() > paramInt1))
    {
      paramInt3 = super.getLayout().getLineVisibleEnd(paramInt1 - 1);
      this.e = getText();
      Object localObject = this.e.toString();
      paramInt1 = paramInt3 - 2;
      paramInt2 = ((String)localObject).codePointAt(paramInt1);
      paramInt3 -= 1;
      paramInt4 = ((String)localObject).codePointAt(paramInt3);
      String str;
      if (((paramInt2 == 20) && (paramInt4 >= 0) && (paramInt4 < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)) || (paramInt2 > 65535))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e.subSequence(0, paramInt1));
        ((StringBuilder)localObject).append("…");
        str = ((StringBuilder)localObject).toString();
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("QQText", 2, "截取的是系统表情或者emoji表情------------");
          localObject = str;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.e.subSequence(0, paramInt3));
        ((StringBuilder)localObject).append("…");
        str = ((StringBuilder)localObject).toString();
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.e("QQText", 2, "截取正常文本------------");
          localObject = str;
        }
      }
      setText((CharSequence)localObject);
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(new QQText(paramCharSequence, 13, 32, 1), TextView.BufferType.SPANNABLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LimitTextView
 * JD-Core Version:    0.7.0.1
 */