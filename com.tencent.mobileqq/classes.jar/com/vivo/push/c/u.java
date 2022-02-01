package com.vivo.push.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.vivo.push.b.x;
import com.vivo.push.e;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import com.vivo.push.util.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class u
  extends y
{
  u(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  private static Intent b(Intent paramIntent, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.entrySet() == null) {
        return paramIntent;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((localEntry != null) && (localEntry.getKey() != null)) {
          paramIntent.putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    return paramIntent;
  }
  
  protected final void a(com.vivo.push.o paramo)
  {
    paramo = (com.vivo.push.b.p)paramo;
    Object localObject1 = paramo.f();
    if (localObject1 == null)
    {
      com.vivo.push.util.o.d("OnNotificationClickTask", "current notification item is null");
      return;
    }
    localObject1 = com.vivo.push.util.p.a((InsideNotificationItem)localObject1);
    Object localObject2 = paramo.d();
    boolean bool = this.a.getPackageName().equals(localObject2);
    if (bool) {
      NotifyAdapterUtil.cancelNotify(this.a);
    }
    if (bool)
    {
      localObject2 = new x(1030L);
      Object localObject3 = new HashMap();
      ((HashMap)localObject3).put("type", "2");
      ((HashMap)localObject3).put("messageID", String.valueOf(paramo.e()));
      ((HashMap)localObject3).put("platform", this.a.getPackageName());
      paramo = z.b(this.a, this.a.getPackageName());
      if (!TextUtils.isEmpty(paramo)) {
        ((HashMap)localObject3).put("remoteAppId", paramo);
      }
      ((x)localObject2).a((HashMap)localObject3);
      e.a().a((com.vivo.push.o)localObject2);
      paramo = new StringBuilder("notification is clicked by skip type[");
      paramo.append(((UPSNotificationMessage)localObject1).getSkipType());
      paramo.append("]");
      com.vivo.push.util.o.d("OnNotificationClickTask", paramo.toString());
      int i = ((UPSNotificationMessage)localObject1).getSkipType();
      int j = 1;
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4))
          {
            paramo = new StringBuilder("illegitmacy skip type error : ");
            paramo.append(((UPSNotificationMessage)localObject1).getSkipType());
            com.vivo.push.util.o.a("OnNotificationClickTask", paramo.toString());
            return;
          }
          localObject2 = ((UPSNotificationMessage)localObject1).getSkipContent();
          try
          {
            localObject3 = Intent.parseUri((String)localObject2, 1);
            paramo = ((Intent)localObject3).getPackage();
            bool = TextUtils.isEmpty(paramo);
            if ((!bool) && (!this.a.getPackageName().equals(paramo)))
            {
              paramo = new StringBuilder("open activity error : local pkgName is ");
              paramo.append(this.a.getPackageName());
              paramo.append("; but remote pkgName is ");
              paramo.append(((Intent)localObject3).getPackage());
              com.vivo.push.util.o.a("OnNotificationClickTask", paramo.toString());
              return;
            }
            if (((Intent)localObject3).getComponent() == null) {
              paramo = null;
            } else {
              paramo = ((Intent)localObject3).getComponent().getPackageName();
            }
            if ((!TextUtils.isEmpty(paramo)) && (!this.a.getPackageName().equals(paramo)))
            {
              paramo = new StringBuilder("open activity component error : local pkgName is ");
              paramo.append(this.a.getPackageName());
              paramo.append("; but remote pkgName is ");
              paramo.append(((Intent)localObject3).getPackage());
              com.vivo.push.util.o.a("OnNotificationClickTask", paramo.toString());
              return;
            }
            ((Intent)localObject3).setSelector(null);
            ((Intent)localObject3).setPackage(this.a.getPackageName());
            ((Intent)localObject3).addFlags(335544320);
            b((Intent)localObject3, ((UPSNotificationMessage)localObject1).getParams());
            paramo = ((Intent)localObject3).resolveActivityInfo(this.a.getPackageManager(), 65536);
            if ((paramo != null) && (!paramo.exported))
            {
              localObject1 = new StringBuilder("activity is not exported : ");
              ((StringBuilder)localObject1).append(paramo.toString());
              com.vivo.push.util.o.a("OnNotificationClickTask", ((StringBuilder)localObject1).toString());
              return;
            }
            this.a.startActivity((Intent)localObject3);
            return;
          }
          catch (Exception paramo)
          {
            com.vivo.push.util.o.a("OnNotificationClickTask", "open activity error : ".concat(String.valueOf(localObject2)), paramo);
            return;
          }
        }
        paramo = ((UPSNotificationMessage)localObject1).getSkipContent();
        i = j;
        if (!paramo.startsWith("http://")) {
          if (paramo.startsWith("https://")) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0)
        {
          paramo = Uri.parse(paramo);
          localObject2 = new Intent("android.intent.action.VIEW", paramo);
          ((Intent)localObject2).setFlags(268435456);
          b((Intent)localObject2, ((UPSNotificationMessage)localObject1).getParams());
        }
      }
    }
    try
    {
      this.a.startActivity((Intent)localObject2);
      return;
    }
    catch (Exception localException)
    {
      label674:
      break label674;
    }
    com.vivo.push.util.o.a("OnNotificationClickTask", "startActivity error : ".concat(String.valueOf(paramo)));
    return;
    com.vivo.push.util.o.a("OnNotificationClickTask", "url not legal");
    return;
    new Thread(new v(this, this.a, ((UPSNotificationMessage)localObject1).getParams())).start();
    return;
    paramo = new StringBuilder("notify is ");
    paramo.append(localObject1);
    paramo.append(" ; isMatch is ");
    paramo.append(bool);
    com.vivo.push.util.o.a("OnNotificationClickTask", paramo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.u
 * JD-Core Version:    0.7.0.1
 */