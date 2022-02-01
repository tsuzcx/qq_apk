package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.FontManager.FontLoadCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ETTextViewPlus
  extends ETTextView
  implements FontManager.FontLoadCallback
{
  private int jdField_a_of_type_Int = -1;
  private final FontManager jdField_a_of_type_ComEtrumpMixlayoutFontManager;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)localQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
    this.jdField_a_of_type_JavaLangString = localQQAppInterface.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.a(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager = ((FontManager)paramAttributeSet.getManager(QQManagerFactory.CHAT_FONT_MANAGER));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.a(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  public void a()
  {
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    FontInfo localFontInfo = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if ((localFontInfo != null) && (localFontInfo.a != null))
    {
      SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.jdField_a_of_type_Int + "] download completed");
      setFont(localFontInfo.a, System.currentTimeMillis());
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label109;
      }
      setText(getText());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.b(this);
      return;
      label109:
      ThreadManager.getUIHandler().post(new ETTextViewPlus.1(this));
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.b(this);
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
      AssertUtils.a("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1, new Object[0]);
      SLog.e("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.jdField_a_of_type_Int + " set " + paramInt1);
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    FontInfo localFontInfo = this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if (localFontInfo != null)
    {
      SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] success");
      setFont(localFontInfo.a, System.currentTimeMillis());
      return;
    }
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] need download");
    this.jdField_a_of_type_ComEtrumpMixlayoutFontManager.a(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */