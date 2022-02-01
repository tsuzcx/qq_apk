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
    Object localObject1 = d.a(this.a).a();
    Object localObject2 = d.a(this.a).a((b)localObject1);
    d.a(this.a, "userClickOnceEvent:");
    this.a.a("");
    if (localObject1 != null)
    {
      Object localObject3;
      if (!((b)localObject1).e())
      {
        if (localObject2 == null)
        {
          d.a(this.a, (b)localObject1);
        }
        else
        {
          localObject1 = d.b(this.a);
          localObject3 = this.a.getContext();
          localObject2 = ((ResolveInfo)localObject2).activityInfo.packageName;
          ((Intent)localObject1).setPackage((String)localObject2);
          if ("com.tencent.mtt".equals(localObject2))
          {
            ((Intent)localObject1).putExtra("ChannelID", ((Context)localObject3).getApplicationContext().getPackageName());
            ((Intent)localObject1).putExtra("PosID", "4");
          }
          if ((((Context)localObject3).getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
            ((Intent)localObject1).addFlags(1);
          }
          if (!TextUtils.isEmpty(d.c(this.a))) {
            ((Intent)localObject1).putExtra("big_brother_source_key", d.c(this.a));
          }
          try
          {
            ((Context)localObject3).startActivity((Intent)localObject1);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (d.a.get() != null) {
            ((ValueCallback)d.a.get()).onReceiveValue("once");
          }
        }
      }
      else if ((d.d(this.a)) && (d.a.get() != null))
      {
        localObject2 = (ValueCallback)d.a.get();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("extraMenuEvent:");
        ((StringBuilder)localObject3).append(localException.g());
        ((ValueCallback)localObject2).onReceiveValue(((StringBuilder)localObject3).toString());
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.ui.dialog.d.2
 * JD-Core Version:    0.7.0.1
 */