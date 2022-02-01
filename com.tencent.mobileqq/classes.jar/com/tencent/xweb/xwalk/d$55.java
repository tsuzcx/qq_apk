package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.res.Resources;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.v;
import org.xwalk.core.Log;

class d$55
  implements RadioGroup.OnCheckedChangeListener
{
  d$55(d paramd) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (!d.f(this.a))
    {
      WebView.c localc = WebView.c.a;
      if (paramInt == 2131427363) {
        localc = WebView.c.a;
      } else if (paramInt == 2131427366) {
        localc = WebView.c.b;
      } else if (paramInt == 2131427365) {
        localc = WebView.c.c;
      } else if (paramInt == 2131427364) {
        localc = WebView.c.d;
      }
      Object localObject;
      if (!this.a.f.equals("all"))
      {
        v.a().a(this.a.f, localc);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("webview change to=");
        ((StringBuilder)localObject).append(localc);
        Log.d("WebDebugPage", ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = this.a.b().getResources().getStringArray(2130968689);
        int i = 0;
        while (i < localObject.length)
        {
          v.a().a(localObject[i], localc);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("webview ");
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(" change to=");
          localStringBuilder.append(localc);
          Log.d("WebDebugPage", localStringBuilder.toString());
          i += 1;
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.55
 * JD-Core Version:    0.7.0.1
 */