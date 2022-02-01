package com.vivo.push.sdk;

import android.content.Context;
import android.net.NetworkInfo;
import com.vivo.push.PushClient;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.e;
import com.vivo.push.util.o;
import com.vivo.push.util.q;

final class PushServiceReceiver$a
  implements Runnable
{
  private Context a;
  private String b;
  
  public final void run()
  {
    Object localObject = q.a(this.a);
    boolean bool;
    if (localObject != null) {
      bool = ((NetworkInfo)localObject).isConnectedOrConnecting();
    } else {
      bool = false;
    }
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.getPackageName());
      ((StringBuilder)localObject).append(": 无网络  by ");
      ((StringBuilder)localObject).append(this.b);
      o.d("PushServiceReceiver", ((StringBuilder)localObject).toString());
      localObject = this.a;
      localStringBuilder = new StringBuilder("触发静态广播:无网络(");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",");
      localStringBuilder.append(this.a.getPackageName());
      localStringBuilder.append(")");
      o.a((Context)localObject, localStringBuilder.toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getPackageName());
    ((StringBuilder)localObject).append(": 执行开始出发动作: ");
    ((StringBuilder)localObject).append(this.b);
    o.d("PushServiceReceiver", ((StringBuilder)localObject).toString());
    localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder("触发静态广播(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a.getPackageName());
    localStringBuilder.append(")");
    o.a((Context)localObject, localStringBuilder.toString());
    e.a().a(this.a);
    if (!ClientConfigManagerImpl.getInstance(this.a).isCancleBroadcastReceiver()) {
      PushClient.getInstance(this.a).initialize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.PushServiceReceiver.a
 * JD-Core Version:    0.7.0.1
 */