package com.tencent.open.agent;

import android.widget.LinearLayout;
import android.widget.TextView;
import bbya;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OpenAuthorityAccountView$DelAccountRunnable
  implements Runnable
{
  private String a;
  
  public OpenAuthorityAccountView$DelAccountRunnable(OpenAuthorityAccountView paramOpenAuthorityAccountView, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    this.this$0.c(this.a);
    String str = ((TextView)OpenAuthorityAccountView.a(this.this$0).findViewById(2131296345)).getText().toString();
    if ((str != null) && (str.equals(this.a)))
    {
      if (this.this$0.a.size() != 1) {
        break label206;
      }
      if ((OpenAuthorityAccountView.a(this.this$0) == null) || (!(OpenAuthorityAccountView.a(this.this$0) instanceof PublicFragmentActivityForOpenSDK))) {
        break label152;
      }
      if (OpenAuthorityAccountView.a(this.this$0) != null) {
        OpenAuthorityAccountView.a(this.this$0).a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityAccountView", 2, "--> after delete account");
      }
      this.this$0.c();
      ((BaseActivity)OpenAuthorityAccountView.a(this.this$0)).runOnUiThread(new OpenAuthorityAccountView.DelAccountRunnable.2(this));
      return;
      label152:
      if ((OpenAuthorityAccountView.a(this.this$0) != null) && ((OpenAuthorityAccountView.a(this.this$0) instanceof QuickLoginAuthorityActivity)))
      {
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.this$0)).a = null;
        ((QuickLoginAuthorityActivity)OpenAuthorityAccountView.a(this.this$0)).a(null);
      }
    }
    label206:
    int i = 0;
    label208:
    if (i < this.this$0.a.size())
    {
      str = (String)this.this$0.a.get(i);
      if (this.a.equals(str)) {}
    }
    for (;;)
    {
      ((BaseActivity)OpenAuthorityAccountView.a(this.this$0)).runOnUiThread(new OpenAuthorityAccountView.DelAccountRunnable.1(this, str));
      break;
      i += 1;
      break label208;
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.DelAccountRunnable
 * JD-Core Version:    0.7.0.1
 */