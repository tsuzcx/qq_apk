package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;

final class PhoneNumQuickLoginManager$17
  extends URLSpan
{
  PhoneNumQuickLoginManager$17(String paramString, int paramInt)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    PhoneNumQuickLoginManager.a(this.a);
    Object localObject = paramView.getContext();
    paramView = getURL();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneNumQuickLoginManager", 1, new Object[] { "getHtmlSpannedStr unbind_wording : ", paramView });
    }
    localObject = new ActivityURIRequest((Context)localObject, "/base/browser");
    ((ActivityURIRequest)localObject).extra().putString("url", paramView);
    QRoute.startUri((URIRequest)localObject, null);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (paramTextPaint != null)
    {
      paramTextPaint.setColor(paramTextPaint.linkColor);
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.17
 * JD-Core Version:    0.7.0.1
 */