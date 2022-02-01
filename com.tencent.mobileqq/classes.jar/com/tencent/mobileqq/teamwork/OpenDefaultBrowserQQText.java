package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;

public class OpenDefaultBrowserQQText
  extends QQText
{
  public OpenDefaultBrowserQQText(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public void addSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof LinkSpan)) {
      localObject = new OpenDefaultBrowserQQText.DefaultBrowserLinkSpan(this, ((LinkSpan)paramObject).a);
    }
    super.addSpan(localObject, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.OpenDefaultBrowserQQText
 * JD-Core Version:    0.7.0.1
 */