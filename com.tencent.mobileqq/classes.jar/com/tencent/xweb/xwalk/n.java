package com.tencent.xweb.xwalk;

import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.k;
import org.xwalk.core.Log;

public class n
  implements f
{
  private boolean a;
  
  public k a()
  {
    return s.b();
  }
  
  public void b()
  {
    String str;
    int k;
    int i;
    if (!this.a)
    {
      str = a.f(WebView.getCurStrModule());
      k = a.e(WebView.getCurStrModule());
      localObject = a.a("enableWindowPerformanceSampleRatio", WebView.getCurStrModule());
      i = 0;
    }
    try
    {
      int j = Integer.parseInt((String)localObject);
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label42:
      StringBuilder localStringBuilder;
      break label42;
    }
    Object localObject = s.b();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setProfileConfig with enabledTraceCategory: ");
    localStringBuilder.append(str);
    localStringBuilder.append(" traceSampleRatio: ");
    localStringBuilder.append(k);
    localStringBuilder.append(" enableWindowPerformanceSampleRatio: ");
    localStringBuilder.append(i);
    Log.d("XWalkExtensionInternal", localStringBuilder.toString());
    ((s)localObject).a(str, k, i);
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.n
 * JD-Core Version:    0.7.0.1
 */