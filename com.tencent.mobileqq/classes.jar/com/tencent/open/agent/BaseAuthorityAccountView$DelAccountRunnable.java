package com.tencent.open.agent;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.open.agent.util.SSOLog;
import java.util.ArrayList;

public class BaseAuthorityAccountView$DelAccountRunnable
  implements Runnable
{
  private String a;
  
  public BaseAuthorityAccountView$DelAccountRunnable(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    BaseAuthorityAccountView.a(this.this$0, this.a);
    Object localObject1 = this.this$0.n.findViewById(2131427488);
    if (localObject1 == null)
    {
      SSOLog.b("BaseAuthorityAccountView", new Object[] { "--> DelAccountRunnable null == currUinView" });
      return;
    }
    localObject1 = ((TextView)localObject1).getText();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      SSOLog.b("BaseAuthorityAccountView", new Object[] { "--> DelAccountRunnable text isEmpty" });
      return;
    }
    if (((CharSequence)localObject1).toString().equals(this.a))
    {
      int i = this.this$0.f.size();
      Object localObject2 = null;
      if (i == 1)
      {
        if ((!this.this$0.b()) && (this.this$0.c != null) && ((this.this$0.c instanceof QuickLoginAuthorityActivity)))
        {
          ((QuickLoginAuthorityActivity)this.this$0.c).b = null;
          ((QuickLoginAuthorityActivity)this.this$0.c).a(null);
        }
      }
      else
      {
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= this.this$0.f.size()) {
            break;
          }
          localObject1 = (String)this.this$0.f.get(i);
          if (!this.a.equals(localObject1)) {
            break;
          }
          i += 1;
        }
        ((Activity)this.this$0.c).runOnUiThread(new BaseAuthorityAccountView.DelAccountRunnable.1(this, (String)localObject1));
      }
    }
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "--> after delete account" });
    this.this$0.h();
    ((Activity)this.this$0.c).runOnUiThread(new BaseAuthorityAccountView.DelAccountRunnable.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.DelAccountRunnable
 * JD-Core Version:    0.7.0.1
 */