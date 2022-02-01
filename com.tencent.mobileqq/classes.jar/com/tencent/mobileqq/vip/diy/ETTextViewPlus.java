package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import gb;
import gc;
import gf;
import yuk;
import znw;
import zps;

public class ETTextViewPlus
  extends ETTextView
  implements gf
{
  private int jdField_a_of_type_Int = -1;
  private final gc jdField_a_of_type_Gc;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Gc = ((gc)localQQAppInterface.getManager(42));
    this.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
    super.setSingleLine(true);
    setMaxWidth(zps.a(getContext()) - zps.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Gc = ((gc)paramAttributeSet.getManager(42));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.c();
    super.setSingleLine(true);
    setMaxWidth(zps.a(getContext()) - zps.a(paramContext, 24.0F));
  }
  
  public void a()
  {
    yuk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    gb localgb = this.jdField_a_of_type_Gc.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if ((localgb != null) && (localgb.a != null))
    {
      yuk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.jdField_a_of_type_Int + "] download completed");
      setFont(localgb.a, System.currentTimeMillis());
      setText(getText());
      this.jdField_a_of_type_Gc.b(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    yuk.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.jdField_a_of_type_Gc.b(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mMsgId = System.currentTimeMillis();
  }
  
  public void setFontAsync(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      znw.a("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1, new Object[0]);
      yuk.e("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1);
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    gb localgb = this.jdField_a_of_type_Gc.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if (localgb != null)
    {
      yuk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] success");
      setFont(localgb.a, System.currentTimeMillis());
      return;
    }
    yuk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] need download");
    this.jdField_a_of_type_Gc.a(this);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = paramCharSequence.toString();
    float f = getPaint().measureText(str);
    if ((this.mMaxWidth > 0) && (this.mMaxWidth < f))
    {
      int i = (int)((f - this.mMaxWidth) / (f / str.length()));
      super.setText(str.substring(0, str.length() - i - 2) + "...", paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */