package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import mqq.util.WeakReference;

public class QQGuildUIUtil$ProgressDialog
{
  private final WeakReference<Context> a;
  private QQProgressDialog b = null;
  
  private QQGuildUIUtil$ProgressDialog(@NonNull Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void a()
  {
    Context localContext = (Context)this.a.get();
    if (!(localContext instanceof Activity)) {
      return;
    }
    if (this.b == null)
    {
      this.b = new QQProgressDialog(localContext, ViewUtils.dpToPx(44.0F));
      this.b.c(2131892360);
      this.b.c(false);
    }
    this.b.b(true);
  }
  
  public void b()
  {
    QQProgressDialog localQQProgressDialog = this.b;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUIUtil.ProgressDialog
 * JD-Core Version:    0.7.0.1
 */