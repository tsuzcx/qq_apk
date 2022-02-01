package com.tencent.mobileqq.qqlive.push;

import android.os.Handler;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo.MsgSpeed;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter;
import com.tencent.mobileqq.qqlive.utils.ThreadCenter.HandlerKeyable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.common.roomMsg.nano.MsgInfo;
import com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.ExtInfo;
import com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.PullMsgReq;
import com.tencent.trpcprotocol.ilive.roomMsgReadSvr.roomMsgReadSvr.nano.PullMsgRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveRoomPushManager
  implements ThreadCenter.HandlerKeyable
{
  private static volatile long g = 1000L;
  private IQQLiveSDK a;
  private CopyOnWriteArraySet<PushReceiver> b = new CopyOnWriteArraySet();
  private long c = 0L;
  private long d = 0L;
  private volatile long e;
  private volatile long f;
  private volatile long h = 0L;
  private long i = 0L;
  private Handler j = ThreadCenter.a("RoomPush");
  private ArrayList<String> k = new ArrayList();
  private ArrayList<String> l = new ArrayList();
  private long m;
  private JSONArray n;
  private byte[] o = null;
  private final Runnable p = new LiveRoomPushManager.1(this);
  private final LiveRoomPushManager.PushNotifyRunnable[] q = new LiveRoomPushManager.PushNotifyRunnable[15];
  private int r = -1;
  
  private LiveRoomPushManager.PushNotifyRunnable a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong, LiveMsgExtInfo.MsgSpeed paramMsgSpeed)
  {
    int i1 = this.r;
    if (i1 == -1) {
      return new LiveRoomPushManager.PushNotifyRunnable(this, paramInt1, paramArrayOfByte, paramInt2, paramLong, paramMsgSpeed);
    }
    LiveRoomPushManager.PushNotifyRunnable[] arrayOfPushNotifyRunnable = this.q;
    LiveRoomPushManager.PushNotifyRunnable localPushNotifyRunnable = arrayOfPushNotifyRunnable[i1];
    arrayOfPushNotifyRunnable[i1] = null;
    this.r = (i1 - 1);
    localPushNotifyRunnable.a = paramInt1;
    localPushNotifyRunnable.b = paramArrayOfByte;
    localPushNotifyRunnable.c = paramInt2;
    localPushNotifyRunnable.d = paramLong;
    localPushNotifyRunnable.e = paramMsgSpeed;
    return localPushNotifyRunnable;
  }
  
  private JSONObject a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", paramString1);
      localJSONObject.put("value", paramString2);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("getHeatBeatInfoObj error:");
      paramString2.append(paramString1.getMessage());
      QLog.e("LiveRoomPushManager", 1, paramString2.toString());
    }
    return localJSONObject;
  }
  
  private void a(long paramLong)
  {
    try
    {
      PullMsgReq localPullMsgReq = new PullMsgReq();
      localPullMsgReq.a = paramLong;
      localPullMsgReq.d = this.f;
      if (this.o != null) {
        localPullMsgReq.b = this.o;
      }
      if (this.n != null)
      {
        localObject = new ExtInfo();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("gap", g);
        localJSONObject.put("infos", this.n);
        ((ExtInfo)localObject).a = new HashMap();
        ((ExtInfo)localObject).a.put("heart_beat", localJSONObject.toString().getBytes());
        localPullMsgReq.c = ((ExtInfo)localObject);
      }
      ((IQQLiveSsoModule)this.a.getExtModule("sso_module")).a("trpc.qlive.room_msg_read_proxy_svr.RoomMsgReadProxySvr", "PullMsgProxy", MessageNano.toByteArray(localPullMsgReq), new LiveRoomPushManager.2(this));
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pushToPull onError at ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("LiveRoomPushManager", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(PullMsgRsp paramPullMsgRsp)
  {
    StringBuilder localStringBuilder;
    if (paramPullMsgRsp.a != this.d)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Push: Drop message with stale roomId. Stale roomId = ");
      localStringBuilder.append(paramPullMsgRsp.a);
      QLog.e("LiveRoomPushManager", 4, localStringBuilder.toString());
      return;
    }
    g = Math.max(paramPullMsgRsp.d, 500L);
    long l1 = paramPullMsgRsp.g;
    if (l1 > this.f)
    {
      this.f = l1;
      this.o = paramPullMsgRsp.e;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("error receive msg getMsgReqNum=");
      localStringBuilder.append(l1);
      localStringBuilder.append(";mMaxMsgNum=");
      localStringBuilder.append(this.f);
      QLog.e("LiveRoomPushManager", 4, localStringBuilder.toString());
    }
    b(paramPullMsgRsp);
    c(paramPullMsgRsp);
  }
  
  private boolean a(LiveRoomPushManager.PushNotifyRunnable paramPushNotifyRunnable)
  {
    int i1 = this.r;
    if (i1 == 14) {
      return false;
    }
    paramPushNotifyRunnable.a = 0;
    paramPushNotifyRunnable.b = null;
    this.r = (i1 + 1);
    this.q[this.r] = paramPushNotifyRunnable;
    return true;
  }
  
  private void b(PullMsgRsp paramPullMsgRsp)
  {
    int i2 = paramPullMsgRsp.c.length;
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramPullMsgRsp.c[i1].b;
        long l1 = paramPullMsgRsp.c[i1].a;
        Object localObject1 = paramPullMsgRsp.c[i1].c;
        int i4 = paramPullMsgRsp.c[i1].e;
        long l2 = paramPullMsgRsp.c[i1].f;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Receive nonconst msg push: ");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(" seq:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append("cmd: ");
          ((StringBuilder)localObject2).append(i3);
          QLog.d("LiveRoomPushManager", 4, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(l1);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (this.l.contains(localObject2))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Push: Drop message.Repeat or wrong msgInfo = ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.d("LiveRoomPushManager", 4, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          this.l.add(localObject2);
          if (this.l.size() > 200) {
            this.l.remove(0);
          }
          ThreadCenter.a(this, a(i3, (byte[])localObject1, i4, l2, LiveMsgExtInfo.MsgSpeed.NON_CONST), i1 * 20);
        }
        i1 += 1;
      }
    }
  }
  
  private void c()
  {
    if (this.d != 0L)
    {
      this.j.removeCallbacks(this.p);
      d();
    }
  }
  
  private void c(PullMsgRsp paramPullMsgRsp)
  {
    int i2 = paramPullMsgRsp.b.length;
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = paramPullMsgRsp.b[i1].b;
        long l1 = paramPullMsgRsp.b[i1].a;
        Object localObject1 = paramPullMsgRsp.b[i1].c;
        int i4 = paramPullMsgRsp.b[i1].e;
        long l2 = paramPullMsgRsp.b[i1].f;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Receive const msg push: ");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(" seq:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append("cmd: ");
          ((StringBuilder)localObject2).append(i3);
          QLog.d("LiveRoomPushManager", 4, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i3);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(l1);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (this.k.contains(localObject2))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Push: Drop message.Repeat or wrong msgInfo = ");
            ((StringBuilder)localObject1).append((String)localObject2);
            QLog.d("LiveRoomPushManager", 4, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          this.k.add(localObject2);
          if (this.k.size() > 200) {
            this.k.remove(0);
          }
          ThreadCenter.a(this, a(i3, (byte[])localObject1, i4, l2, LiveMsgExtInfo.MsgSpeed.CONST), i1 * 20);
        }
        i1 += 1;
      }
    }
  }
  
  private void d()
  {
    long l1 = this.d;
    if (l1 != 0L) {
      a(l1);
    }
    if (this.j != null)
    {
      long l2 = g;
      l1 = l2;
      if (this.h > 0L)
      {
        l1 = l2;
        if (this.i > 0L)
        {
          l1 = this.h;
          this.i -= 1L;
        }
      }
      this.j.postDelayed(this.p, l1);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("LiveRoomPushManager", 4, "LiveRoomPushManager inInit");
    }
    ThreadCenter.a(this);
    this.j.removeCallbacks(this.p);
    this.b.clear();
    this.e = 0L;
    this.f = 0L;
    this.d = 0L;
    this.o = null;
    this.m = 0L;
    this.n = null;
    this.k.clear();
    this.l.clear();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.m = System.currentTimeMillis();
    try
    {
      AppInterface localAppInterface = QQLiveCaptureContext.a();
      if (localAppInterface == null)
      {
        QLog.e("LiveRoomPushManager", 1, "[runWithNewRoom] getAppInterface is null!");
      }
      else
      {
        this.n = new JSONArray();
        if ((this.a != null) && (this.a.getConfigModule().getConfigData() != null))
        {
          localObject = this.a.getConfigModule().getConfigData();
          this.n.put(a("client_type", String.valueOf(((ConfigData)localObject).getLiveClientType())));
          this.n.put(a("uid", String.valueOf(localAppInterface.getCurrentAccountUin())));
          this.n.put(a("room_id", String.valueOf(paramLong2)));
          this.n.put(a("enterts", String.valueOf(this.m)));
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runWithNewRoom error:");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("LiveRoomPushManager", 1, ((StringBuilder)localObject).toString());
    }
    c();
  }
  
  public void a(IQQLiveSDK paramIQQLiveSDK)
  {
    this.a = paramIQQLiveSDK;
  }
  
  public void a(PushReceiver paramPushReceiver)
  {
    if (this.b.contains(paramPushReceiver)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("register push: ");
      localStringBuilder.append(paramPushReceiver);
      localStringBuilder.append(",this: ");
      localStringBuilder.append(this);
      QLog.i("LiveRoomPushManager", 4, localStringBuilder.toString());
    }
    this.b.add(paramPushReceiver);
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(PushReceiver paramPushReceiver)
  {
    if (!this.b.contains(paramPushReceiver)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unregister push: ");
      localStringBuilder.append(paramPushReceiver);
      localStringBuilder.append(",this: ");
      localStringBuilder.append(this);
      QLog.i("LiveRoomPushManager", 4, localStringBuilder.toString());
    }
    this.b.remove(paramPushReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.push.LiveRoomPushManager
 * JD-Core Version:    0.7.0.1
 */