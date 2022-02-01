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

class d$1
  implements View.OnClickListener
{
  d$1(d paramd) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = d.a(this.a).a();
    Object localObject1 = d.a(this.a).a((b)localObject2);
    d.a(this.a, "userClickAlwaysEvent:");
    if (localObject2 != null)
    {
      if (!((b)localObject2).e()) {
        if (localObject1 == null) {
          d.a(this.a, (b)localObject2);
        }
      }
      for (;;)
      {
        this.a.dismiss();
        break;
        localObject2 = d.b(this.a);
        Object localObject4 = this.a.getContext();
        localObject1 = ((ResolveInfo)localObject1).activityInfo.packageName;
        ((Intent)localObject2).setPackage((String)localObject1);
        if ("com.tencent.mtt".equals(localObject1))
        {
          ((Intent)localObject2).putExtra("ChannelID", ((Context)localObject4).getApplicationContext().getPackageName());
          ((Intent)localObject2).putExtra("PosID", "4");
        }
        if ((localObject4 != null) && (((Context)localObject4).getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
          ((Intent)localObject2).addFlags(1);
        }
        if (!TextUtils.isEmpty(d.c(this.a))) {
          ((Intent)localObject2).putExtra("big_brother_source_key", d.c(this.a));
        }
        try
        {
          ((Context)localObject4).startActivity((Intent)localObject2);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        if (d.a.get() != null) {
          ((ValueCallback)d.a.get()).onReceiveValue("always");
        }
        this.a.a((String)localObject1);
        continue;
        localObject1 = localException.g();
        if (d.a.get() != null)
        {
          localObject3 = (ValueCallback)d.a.get();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("extraMenuEvent:");
          ((StringBuilder)localObject4).append((String)localObject1);
          ((ValueCallback)localObject3).onReceiveValue(((StringBuilder)localObject4).toString());
        }
        Object localObject3 = this.a;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("extraMenuEvent:");
        ((StringBuilder)localObject4).append((String)localObject1);
        ((d)localObject3).a(((StringBuilder)localObject4).toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.d.1
 * JD-Core Version:    0.7.0.1
 */