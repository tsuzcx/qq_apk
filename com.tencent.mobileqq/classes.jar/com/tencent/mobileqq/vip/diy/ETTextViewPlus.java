package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import fu;
import fv;
import fy;
import urk;
import vkw;
import vms;

public class ETTextViewPlus
  extends ETTextView
  implements fy
{
  private final fv jdField_a_of_type_Fv;
  private String jdField_a_of_type_JavaLangString;
  private int f = -1;
  private int g = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Fv = ((fv)localQQAppInterface.getManager(42));
    this.jdField_a_of_type_JavaLangString = localQQAppInterface.c();
    super.setSingleLine(true);
    setMaxWidth(vms.a(getContext()) - vms.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Fv = ((fv)paramAttributeSet.getManager(42));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.c();
    super.setSingleLine(true);
    setMaxWidth(vms.a(getContext()) - vms.a(paramContext, 24.0F));
  }
  
  public void aX_()
  {
    urk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    fu localfu = this.jdField_a_of_type_Fv.a(this.f, this.g, false, this.jdField_a_of_type_JavaLangString, 0);
    if ((localfu != null) && (localfu.a != null))
    {
      urk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.f + "] download completed");
      setFont(localfu.a, System.currentTimeMillis());
      setText(getText());
      this.jdField_a_of_type_Fv.b(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    urk.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.jdField_a_of_type_Fv.b(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void setFontAsync(int paramInt1, int paramInt2)
  {
    if (this.f > 0)
    {
      vkw.a("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.f + " set " + paramInt1, new Object[0]);
      urk.e("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.f + " set " + paramInt1);
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    fu localfu = this.jdField_a_of_type_Fv.a(this.f, this.g, false, this.jdField_a_of_type_JavaLangString, 0);
    if (localfu != null)
    {
      urk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] success");
      setFont(localfu.a, System.currentTimeMillis());
      return;
    }
    urk.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] need download");
    this.jdField_a_of_type_Fv.a(this);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = paramCharSequence.toString();
    float f1 = getPaint().measureText(str);
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < f1))
    {
      int i = (int)((f1 - this.jdField_a_of_type_Int) / (f1 / str.length()));
      super.setText(str.substring(0, str.length() - i - 2) + "...", paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */