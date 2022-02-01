package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.manager.TicketManager;

class DocxApiPlugin$2
  implements Runnable
{
  DocxApiPlugin$2(DocxApiPlugin paramDocxApiPlugin, Activity paramActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = (TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)((TeamWorkDocEditBrowserActivity)this.a).getCurrentWebViewFragment();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(this.b);
    String str = new File(this.b).getName();
    Object localObject3 = ((TicketManager)((TeamWorkDocEditBrowserActivity)this.a).a.getManager(2)).getSkey(((TeamWorkDocEditBrowserActivity)this.a).a.getAccount());
    localObject1 = ((TeamWorkDocEditBrowserActivity)this.a).a((ArrayList)localObject2, ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject1).p, (String)localObject3, "1", ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject1).q, ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)localObject1).j);
    if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
    {
      localObject1 = (String)((ArrayList)localObject1).get(0);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" url = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" fileName = ");
        ((StringBuilder)localObject2).append(str);
        QLog.i("TeamWorkDocEditBrowserActivity", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.this$0;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("insertImageForNativeJSBridge('");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("','");
      ((StringBuilder)localObject3).append(this.c);
      ((StringBuilder)localObject3).append("','");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append("')");
      ((DocxApiPlugin)localObject2).callJs(((StringBuilder)localObject3).toString());
      return;
    }
    localObject1 = this.this$0;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("insertImageForNativeJSBridge('");
    ((StringBuilder)localObject2).append(null);
    ((StringBuilder)localObject2).append("','");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("','");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("')");
    ((DocxApiPlugin)localObject1).callJs(((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel()) {
      QLog.i("TeamWorkDocEditBrowserActivity", 2, "picture upload fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DocxApiPlugin.2
 * JD-Core Version:    0.7.0.1
 */