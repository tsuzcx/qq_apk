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
  private final IFontManagerService a;
  private String b;
  private int c = -1;
  private int d = -1;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.a = ((IFontManagerService)localQQAppInterface.getRuntimeService(IFontManagerService.class, ""));
    this.b = localQQAppInterface.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.b(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.a = ((IFontManagerService)paramAttributeSet.getRuntimeService(IFontManagerService.class, ""));
    this.b = paramAttributeSet.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(UIUtils.b(getContext()) - UIUtils.a(paramContext, 24.0F));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.a.removeFontLoadCallback(this);
  }
  
  public void onFontLoaded()
  {
    SLog.d("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    FontInfo localFontInfo = this.a.getFontInfo(this.c, this.d, false, this.b, 0);
    if ((localFontInfo != null) && (localFontInfo.f != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAsync [");
      localStringBuilder.append(this.c);
      localStringBuilder.append("] download completed");
      SLog.d("DIYProfileTemplate.ETTextViewPlus", localStringBuilder.toString());
      setFont(localFontInfo.f, System.currentTimeMillis());
      if (Looper.myLooper() == Looper.getMainLooper()) {
        setText(getText());
      } else {
        ThreadManager.getUIHandler().post(new ETTextViewPlus.1(this));
      }
      this.a.removeFontLoadCallback(this);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mMsgId = System.currentTimeMillis();
  }
  
  public void setFontAsync(int paramInt1, int paramInt2)
  {
    if (this.c > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" set ");
      ((StringBuilder)localObject).append(paramInt1);
      AssertUtils.fail(((StringBuilder)localObject).toString(), new Object[0]);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error: it is not allow set font id multiple time! orig=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" set ");
      ((StringBuilder)localObject).append(paramInt1);
      SLog.e("DIYProfileTemplate.ETTextViewPlus", ((StringBuilder)localObject).toString());
      return;
    }
    this.c = paramInt1;
    this.d = paramInt2;
    Object localObject = this.a.getFontInfo(this.c, this.d, false, this.b, 0);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontAsync [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("] success");
      SLog.d("DIYProfileTemplate.ETTextViewPlus", localStringBuilder.toString());
      setFont(((FontInfo)localObject).f, System.currentTimeMillis());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setFontAsync [");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] need download");
    SLog.d("DIYProfileTemplate.ETTextViewPlus", ((StringBuilder)localObject).toString());
    this.a.addFontLoadCallback(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */