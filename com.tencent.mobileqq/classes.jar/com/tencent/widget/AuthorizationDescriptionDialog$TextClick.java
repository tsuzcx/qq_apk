package com.tencent.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.raft.component.TxchPage;
import com.tencent.raft.raftframework.RAApplicationContext;
import mqq.util.WeakReference;

final class AuthorizationDescriptionDialog$TextClick
  extends ClickableSpan
{
  private WeakReference<Context> a;
  
  private AuthorizationDescriptionDialog$TextClick(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  private String a(Context paramContext)
  {
    RAApplicationContext localRAApplicationContext = RAApplicationContext.getGlobalContext();
    if (!localRAApplicationContext.hasStartUp()) {
      localRAApplicationContext.startup(paramContext);
    }
    paramContext = (TxchPage)localRAApplicationContext.getService(TxchPage.class);
    if (paramContext != null) {}
    for (paramContext = paramContext.productId;; paramContext = "36028")
    {
      localRAApplicationContext.shutdown();
      return paramContext;
    }
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = (Context)this.a.get();
    if (paramView != null)
    {
      String str = "https://support.qq.com/product/" + a(paramView);
      Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      paramView.startActivity(localIntent);
    }
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.AuthorizationDescriptionDialog.TextClick
 * JD-Core Version:    0.7.0.1
 */