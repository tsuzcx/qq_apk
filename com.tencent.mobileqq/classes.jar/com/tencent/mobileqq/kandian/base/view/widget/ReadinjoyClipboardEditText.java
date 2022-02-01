package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class ReadinjoyClipboardEditText
  extends EditText
{
  private ReadinjoyClipboardEditText.IClipboardCallBack a;
  
  public ReadinjoyClipboardEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadinjoyClipboardEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    ReadinjoyClipboardEditText.IClipboardCallBack localIClipboardCallBack;
    switch (paramInt)
    {
    default: 
      break;
    case 16908322: 
      localIClipboardCallBack = this.a;
      if (localIClipboardCallBack != null) {
        localIClipboardCallBack.b();
      }
      break;
    case 16908321: 
      localIClipboardCallBack = this.a;
      if (localIClipboardCallBack != null) {
        localIClipboardCallBack.a();
      }
      break;
    case 16908320: 
      localIClipboardCallBack = this.a;
      if (localIClipboardCallBack != null) {
        localIClipboardCallBack.c();
      }
      break;
    }
    return super.onTextContextMenuItem(paramInt);
  }
  
  public void setClipboardCallBack(ReadinjoyClipboardEditText.IClipboardCallBack paramIClipboardCallBack)
  {
    this.a = paramIClipboardCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadinjoyClipboardEditText
 * JD-Core Version:    0.7.0.1
 */