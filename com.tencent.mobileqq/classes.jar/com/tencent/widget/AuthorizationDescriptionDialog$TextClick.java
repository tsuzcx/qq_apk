package com.tencent.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import mqq.util.WeakReference;

final class AuthorizationDescriptionDialog$TextClick
  extends ClickableSpan
{
  private WeakReference<Context> a;
  
  private AuthorizationDescriptionDialog$TextClick(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = (Context)this.a.get();
    if (paramView != null)
    {
      Object localObject = new GdtThirdProcessorProxy();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://support.qq.com/product/");
      localStringBuilder.append(((GdtThirdProcessorProxy)localObject).a(paramView));
      localObject = localStringBuilder.toString();
      paramView = new ActivityURIRequest(paramView, "/base/browser");
      paramView.extra().putString("url", (String)localObject);
      QRoute.startUri(paramView, null);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDescriptionDialog.TextClick
 * JD-Core Version:    0.7.0.1
 */