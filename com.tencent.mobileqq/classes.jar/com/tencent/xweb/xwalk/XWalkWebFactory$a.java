package com.tencent.xweb.xwalk;

import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.ad;
import com.tencent.xweb.b;
import com.tencent.xweb.p.a;
import com.tencent.xweb.q;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

class XWalkWebFactory$a
  implements p.a
{
  public void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!ad.c()) {
        return;
      }
      paramInt = XWalkEnvironment.getAvailableVersion();
      int i = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
      if ((paramInt <= 0) && (i > 0) && (!"true".equalsIgnoreCase(a.g("dis_reinit_web_core")))) {
        WebView.reinitToXWeb();
      }
    }
  }
  
  public void b()
  {
    if (!"true".equalsIgnoreCase(a.a("dis_refresh_main_cmd", "tools")))
    {
      a.b();
      q.a();
      return;
    }
    Log.i("XWalkWebFactory", "dis_refresh_main_cmd");
  }
  
  public void b(int paramInt) {}
  
  public void c()
  {
    if (!"true".equalsIgnoreCase(a.a("dis_refresh_plugin_cmd", "tools")))
    {
      b.m();
      return;
    }
    Log.i("XWalkWebFactory", "dis_refresh_plugin_cmd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory.a
 * JD-Core Version:    0.7.0.1
 */