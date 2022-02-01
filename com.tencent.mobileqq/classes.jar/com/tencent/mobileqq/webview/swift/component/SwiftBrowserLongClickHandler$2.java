package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListenerV2;
import cooperation.qqfav.QfavBuilder;
import java.io.File;

class SwiftBrowserLongClickHandler$2
  implements ActionSheet.OnButtonClickListenerV2
{
  SwiftBrowserLongClickHandler$2(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler) {}
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.a.d == null)
      {
        paramView = this.a;
        paramView.d = new QQProgressDialog(paramView.f, this.a.g);
        this.a.d.c(2131891516);
      }
      this.a.d.show();
      if (paramString.equals(this.a.f.getString(2131887620)))
      {
        if (TextUtils.isEmpty(this.a.h))
        {
          this.a.i = 0;
        }
        else
        {
          if ((this.a.d != null) && (this.a.d.isShowing())) {
            this.a.d.dismiss();
          }
          paramView = this.a;
          paramView.b(paramView.h);
        }
      }
      else if (paramString.equals(this.a.f.getString(2131887619)))
      {
        if (TextUtils.isEmpty(this.a.h))
        {
          this.a.i = 1;
        }
        else
        {
          paramView = this.a;
          paramView.a(paramView.h);
        }
      }
      else if (paramString.equals(this.a.f.getString(2131890808)))
      {
        if ((this.a.d != null) && (this.a.d.isShowing())) {
          this.a.d.dismiss();
        }
        paramView = this.a;
        paramView.a(paramView.h, 1);
      }
      else if (paramString.equals(this.a.f.getString(2131890807)))
      {
        if ((this.a.d != null) && (this.a.d.isShowing())) {
          this.a.d.dismiss();
        }
        paramView = this.a;
        paramView.a(paramView.h, 2);
      }
      else if (paramString.equals(this.a.f.getString(2131887621)))
      {
        if (TextUtils.isEmpty(this.a.h))
        {
          this.a.i = 2;
        }
        else
        {
          if ((this.a.d != null) && (this.a.d.isShowing())) {
            this.a.d.dismiss();
          }
          paramView = this.a;
          paramView.c(paramView.h);
        }
      }
      else if (paramString.equals(this.a.f.getString(2131890802)))
      {
        if ((this.a.d != null) && (this.a.d.isShowing())) {
          this.a.d.dismiss();
        }
        if (!TextUtils.isEmpty(this.a.h))
        {
          paramView = new File(this.a.h);
          paramString = ((TeamWorkDocEditBrowserActivity)this.a.f).a.getCurrentAccountUin();
          QfavBuilder.b(paramView.getAbsolutePath()).a(this.a.f, paramString);
        }
      }
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.2
 * JD-Core Version:    0.7.0.1
 */