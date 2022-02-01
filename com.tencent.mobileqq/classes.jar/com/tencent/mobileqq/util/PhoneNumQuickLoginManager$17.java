package com.tencent.mobileqq.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;

final class PhoneNumQuickLoginManager$17
  extends URLSpan
{
  PhoneNumQuickLoginManager$17(String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    paramView = getURL();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.17
 * JD-Core Version:    0.7.0.1
 */