package com.vivo.push.c;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.e;
import com.vivo.push.util.k;
import com.vivo.push.util.o;
import com.vivo.push.util.p;
import com.vivo.push.util.z;
import java.util.HashMap;

final class s
  implements Runnable
{
  s(r paramr, InsideNotificationItem paramInsideNotificationItem, com.vivo.push.b.q paramq) {}
  
  public final void run()
  {
    if (this.c.b.onNotificationMessageArrived(r.a(this.c), p.a(this.a)))
    {
      localObject1 = new StringBuilder("pkg name : ");
      ((StringBuilder)localObject1).append(r.b(this.c).getPackageName());
      ((StringBuilder)localObject1).append(" 应用主动拦截通知");
      o.b("OnNotificationArrivedTask", ((StringBuilder)localObject1).toString());
      o.b(r.c(this.c), "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("messageID", String.valueOf(this.b.f()));
      localObject2 = z.b(r.d(this.c), r.e(this.c).getPackageName());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((HashMap)localObject1).put("remoteAppId", localObject2);
      }
      e.a(2120L, (HashMap)localObject1);
      return;
    }
    k localk = new k(r.f(this.c), this.a, this.b.f(), this.c.b.isAllowNet(r.g(this.c)), new t(this));
    boolean bool = this.a.isShowBigPicOnMobileNet();
    Object localObject2 = this.a.getPurePicUrl();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.a.getCoverUrl();
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      o.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(bool)));
      if (!bool)
      {
        o.a(r.l(this.c), "mobile net unshow");
        localObject2 = com.vivo.push.util.q.a(r.m(this.c));
        if (localObject2 == null) {}
        while (((NetworkInfo)localObject2).getState() != NetworkInfo.State.CONNECTED)
        {
          i = 0;
          break;
        }
        int i = ((NetworkInfo)localObject2).getType();
        if (i == 1) {
          i = 2;
        } else if (i == 0) {
          i = 1;
        } else {
          i = 3;
        }
        localObject2 = localObject1;
        if (i == 1)
        {
          localObject2 = null;
          this.a.clearCoverUrl();
          this.a.clearPurePicUrl();
        }
      }
      else
      {
        o.a(r.n(this.c), "mobile net show");
        localObject2 = localObject1;
      }
    }
    localk.execute(new String[] { this.a.getIconUrl(), localObject2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.s
 * JD-Core Version:    0.7.0.1
 */