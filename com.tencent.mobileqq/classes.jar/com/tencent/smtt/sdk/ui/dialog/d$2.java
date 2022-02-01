package com.tencent.smtt.sdk.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

class d$2
  implements View.OnClickListener
{
  d$2(d paramd) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = d.a(this.a).a();
    Object localObject1 = d.a(this.a).a((b)localObject2);
    d.a(this.a, "userClickOnceEvent:");
    this.a.a("");
    if (localObject2 == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((b)localObject2).e()) {
        break label249;
      }
      if (localObject1 != null) {
        break;
      }
      d.a(this.a, (b)localObject2);
      this.a.dismiss();
    }
    localObject2 = d.b(this.a);
    Context localContext = this.a.getContext();
    localObject1 = ((ResolveInfo)localObject1).activityInfo.packageName;
    ((Intent)localObject2).setPackage((String)localObject1);
    if ("com.tencent.mtt".equals(localObject1))
    {
      ((Intent)localObject2).putExtra("ChannelID", localContext.getApplicationContext().getPackageName());
      ((Intent)localObject2).putExtra("PosID", "4");
    }
    if ((localContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
      ((Intent)localObject2).addFlags(1);
    }
    if (!TextUtils.isEmpty(d.c(this.a))) {
      ((Intent)localObject2).putExtra("big_brother_source_key", d.c(this.a));
    }
    for (;;)
    {
      try
      {
        localContext.startActivity((Intent)localObject2);
        if (d.a.get() != null) {
          ((ValueCallback)d.a.get()).onReceiveValue("once");
        }
        this.a.dismiss();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      label249:
      if ((d.d(this.a)) && (d.a.get() != null)) {
        ((ValueCallback)d.a.get()).onReceiveValue("extraMenuEvent:" + ((b)localObject2).g());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.d.2
 * JD-Core Version:    0.7.0.1
 */