package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import fw;
import fx;
import ga;
import wsv;
import xmh;
import xod;

public class ETTextViewPlus
  extends ETTextView
  implements ga
{
  private int jdField_a_of_type_Int = -1;
  private final fx jdField_a_of_type_Fx;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Fx = ((fx)localQQAppInterface.getManager(42));
    this.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
    super.setSingleLine(true);
    setMaxWidth(xod.a(getContext()) - xod.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Fx = ((fx)paramAttributeSet.getManager(42));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.c();
    super.setSingleLine(true);
    setMaxWidth(xod.a(getContext()) - xod.a(paramContext, 24.0F));
  }
  
  public void a()
  {
    wsv.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    fw localfw = this.jdField_a_of_type_Fx.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if ((localfw != null) && (localfw.a != null))
    {
      wsv.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.jdField_a_of_type_Int + "] download completed");
      setFont(localfw.a, System.currentTimeMillis());
      setText(getText());
      this.jdField_a_of_type_Fx.b(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    wsv.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.jdField_a_of_type_Fx.b(this);
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
      xmh.a("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1, new Object[0]);
      wsv.e("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1);
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    fw localfw = this.jdField_a_of_type_Fx.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if (localfw != null)
    {
      wsv.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] success");
      setFont(localfw.a, System.currentTimeMillis());
      return;
    }
    wsv.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] need download");
    this.jdField_a_of_type_Fx.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */