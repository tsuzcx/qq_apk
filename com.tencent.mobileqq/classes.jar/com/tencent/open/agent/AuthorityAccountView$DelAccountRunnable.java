package com.tencent.open.agent;

import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.Login;
import java.util.ArrayList;

public class AuthorityAccountView$DelAccountRunnable
  implements Runnable
{
  private String a;
  
  public AuthorityAccountView$DelAccountRunnable(AuthorityAccountView paramAuthorityAccountView, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    this.this$0.c(this.a);
    Object localObject = ((TextView)AuthorityAccountView.a(this.this$0).findViewById(2131361881)).getText().toString();
    if ((localObject != null) && (((String)localObject).equals(this.a)))
    {
      if (this.this$0.a.size() != 1) {
        break label246;
      }
      if ((AuthorityAccountView.a(this.this$0) == null) || (!(AuthorityAccountView.a(this.this$0) instanceof AuthorityActivity))) {
        break label192;
      }
      localObject = new Intent(AuthorityAccountView.a(this.this$0), Login.class);
      ((Intent)localObject).putExtra("key_req_src", 1);
      ((Intent)localObject).putExtra("is_first_login", true);
      ((AuthorityActivity)AuthorityAccountView.a(this.this$0)).a = null;
      ((AuthorityActivity)AuthorityAccountView.a(this.this$0)).startActivityForResult((Intent)localObject, 1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityAccountView", 2, "--> after delete account");
      }
      this.this$0.c();
      ((BaseActivity)AuthorityAccountView.a(this.this$0)).runOnUiThread(new AuthorityAccountView.DelAccountRunnable.2(this));
      return;
      label192:
      if ((AuthorityAccountView.a(this.this$0) != null) && ((AuthorityAccountView.a(this.this$0) instanceof QuickLoginAuthorityActivity)))
      {
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.this$0)).a = null;
        ((QuickLoginAuthorityActivity)AuthorityAccountView.a(this.this$0)).a(null);
      }
    }
    label246:
    int i = 0;
    label248:
    if (i < this.this$0.a.size())
    {
      localObject = (String)this.this$0.a.get(i);
      if (this.a.equals(localObject)) {}
    }
    for (;;)
    {
      ((BaseActivity)AuthorityAccountView.a(this.this$0)).runOnUiThread(new AuthorityAccountView.DelAccountRunnable.1(this, (String)localObject));
      break;
      i += 1;
      break label248;
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView.DelAccountRunnable
 * JD-Core Version:    0.7.0.1
 */