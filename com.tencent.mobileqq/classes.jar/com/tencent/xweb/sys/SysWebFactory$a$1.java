package com.tencent.xweb.sys;

import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

final class SysWebFactory$a$1
  implements Runnable
{
  SysWebFactory$a$1(WebView.PreInitCallback paramPreInitCallback) {}
  
  public void run()
  {
    try
    {
      SysWebFactory.a.d();
      SysWebFactory.a.b(true);
      if (this.a != null)
      {
        this.a.a();
        return;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        String str = g.a("org.chromium.base.PathUtils", "getDataDirectory").toString();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("PathUtils.getDataDirectory = ");
        localStringBuilder2.append(str);
        Log.e("SysWebFactory.preIniter", localStringBuilder2.toString());
      }
      catch (Exception localException2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("try reflect to PathUtils failed ");
        localStringBuilder2.append(localException2.getMessage());
        Log.e("SysWebFactory.preIniter", localStringBuilder2.toString());
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("ensureSystemWebViewGlobalLooper failed ");
      localStringBuilder1.append(localException1.getMessage());
      Log.e("SysWebFactory.preIniter", localStringBuilder1.toString());
      h.a(577L, 233L, 1L);
      return;
      Log.e("SysWebFactory.preIniter", "link error, may be abi not match, try xweb core");
      WebView._initWebviewCore(XWalkEnvironment.getApplicationContext(), WebView.c.b, this.a, true);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label148:
      break label148;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.SysWebFactory.a.1
 * JD-Core Version:    0.7.0.1
 */