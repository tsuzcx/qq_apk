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
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Field jdField_a_of_type_JavaLangReflectField;
  private boolean jdField_a_of_type_Boolean = true;
  private Field b;
  private Field c;
  
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
      this.jdField_a_of_type_JavaLangReflectField = TextView.class.getDeclaredField("mMaxMode");
      this.b = TextView.class.getDeclaredField("mMaximum");
      this.c = TextView.class.getDeclaredField("LINES");
      this.jdField_a_of_type_JavaLangReflectField.setAccessible(true);
      this.b.setAccessible(true);
      this.c.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  @TargetApi(16)
  public int getMaxLines()
  {
    int i = -1;
    if (Build.VERSION.SDK_INT >= 16) {
      i = super.getMaxLines();
    }
    do
    {
      return i;
      if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_JavaLangReflectField == null) || (this.b == null) || (this.c == null))) {
        a();
      }
    } while (!this.jdField_a_of_type_Boolean);
    try
    {
      int j = this.jdField_a_of_type_JavaLangReflectField.getInt(this);
      i = this.b.getInt(this);
      int k = this.c.getInt(this);
      if (j == k) {}
      for (;;)
      {
        return i;
        i = -1;
      }
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException) {}
  }
  
  @SuppressLint({"NewApi"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMaxLines();
    Object localObject;
    String str;
    if ((paramInt1 > 0) && (super.getLineCount() > paramInt1))
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(paramInt1 - 1);
      this.jdField_a_of_type_JavaLangCharSequence = getText();
      localObject = this.jdField_a_of_type_JavaLangCharSequence.toString();
      paramInt2 = ((String)localObject).codePointAt(paramInt1 - 2);
      paramInt3 = ((String)localObject).codePointAt(paramInt1 - 1);
      if (((paramInt2 != 20) || (paramInt3 < 0) || (paramInt3 >= EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)) && (paramInt2 <= 65535)) {
        break label164;
      }
      str = this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, paramInt1 - 2) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取的是系统表情或者emoji表情------------");
        localObject = str;
      }
    }
    for (;;)
    {
      setText((CharSequence)localObject);
      return;
      label164:
      str = this.jdField_a_of_type_JavaLangCharSequence.subSequence(0, paramInt1 - 1) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取正常文本------------");
        localObject = str;
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(new QQText(paramCharSequence, 13, 32, 1), TextView.BufferType.SPANNABLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LimitTextView
 * JD-Core Version:    0.7.0.1
 */