package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class XEditTextEx
  extends XEditText
{
  private XEditTextEx.OnPrivateIMECommandListener a;
  public XEditTextEx.SizeChangedCallback a;
  public Object a;
  
  public XEditTextEx(Context paramContext)
  {
    super(paramContext);
  }
  
  public XEditTextEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    String str = TextUtils.d(getText().toString());
    paramAccessibilityNodeInfo.setText(str);
    paramAccessibilityNodeInfo.setContentDescription(str);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XEditTextEx", 1, "onPrivateIMECommand(), action:" + paramString + " data:" + paramBundle);
    }
    if (this.a != null) {
      return this.a.a(paramString, paramBundle);
    }
    return super.onPrivateIMECommand(paramString, paramBundle);
  }
  
  public void setOnPrivateIMECommandListener(XEditTextEx.OnPrivateIMECommandListener paramOnPrivateIMECommandListener)
  {
    this.a = paramOnPrivateIMECommandListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.widget.XEditTextEx
 * JD-Core Version:    0.7.0.1
 */