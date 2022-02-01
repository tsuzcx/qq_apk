package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.etrump.mixlayout.FontInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.font.api.FontLoadCallback;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import mqq.os.MqqHandler;

public class ETTextViewPlus
  extends ETTextView
  implements FontLoadCallback
{
  private int jdField_a_of_type_Int = -1;
  private final IFontManagerService jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService = ((IFontManagerService)localQQAppInterface.getRuntimeService(IFontManagerService.class, ""));
    this.jdField_a_of_type_JavaLangString = localQQAppInterface.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.a(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService = ((IFontManagerService)paramAttributeSet.getRuntimeService(IFontManagerService.class, ""));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.a(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.removeFontLoadCallback(this);
  }
  
  public void onFontLoaded()
  {
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    FontInfo localFontInfo = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.getFontInfo(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if ((localFontInfo != null) && (localFontInfo.a != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAsync [");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("] download completed");
      SLog.d("DIYProfileTemplate.ETTextViewPlus", localStringBuilder.toString());
      setFont(localFontInfo.a, System.currentTimeMillis());
      if (Looper.myLooper() == Looper.getMainLooper()) {
        setText(getText());
      } else {
        ThreadManager.getUIHandler().post(new ETTextViewPlus.1(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.removeFontLoadCallback(this);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mMsgId = System.currentTimeMillis();
  }
  
  public void setFontAsync(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" set ");
      ((StringBuilder)localObject).append(paramInt1);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error: it is not allow set font id multiple time! orig=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" set ");
      ((StringBuilder)localObject).append(paramInt1);
      SLog.e("DIYProfileTemplate.ETTextViewPlus", ((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.getFontInfo(this.jdField_a_of_type_Int, this.b, false, this.jdField_a_of_type_JavaLangString, 0);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAsync [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("] success");
      SLog.d("DIYProfileTemplate.ETTextViewPlus", localStringBuilder.toString());
      setFont(((FontInfo)localObject).a, System.currentTimeMillis());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFontAsync [");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] need download");
    SLog.d("DIYProfileTemplate.ETTextViewPlus", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIFontManagerService.addFontLoadCallback(this);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = paramCharSequence.toString();
    float f = getPaint().measureText(str);
    if ((this.mMaxWidth > 0) && (this.mMaxWidth < f))
    {
      int i = (int)((f - this.mMaxWidth) / (f / str.length()));
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(str.substring(0, str.length() - i - 2));
      paramCharSequence.append("...");
      super.setText(paramCharSequence.toString(), paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */