package com.tencent.mobileqq.qqlive.api.impl.message;

import android.util.SparseIntArray;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.qqlive.data.heart.FloatHeart;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.listener.heart.OnReceiveFloatHeartListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.BroadcastFreeLove;
import com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.SendFreeLoveReq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QQLiveFloatHeartServiceImpl
  implements IQQLiveFloatHeartService
{
  private static final long CLICK_HEART_INTERVAL_MS = 100L;
  private static final int FLOAT_HEART_CMD = 48;
  private static final String FLOAT_HEART_METHOD = "SendFreeLove";
  private static final String FLOAT_HEART_SERVICE = "trpc.qlive.send_free_love.SendFreeLove";
  private static final long SEND_HEART_INTERVAL_MS = 3000L;
  private static final String TAG = "QQLiveFloatHeartService";
  private SparseIntArray clickedHeartList = new SparseIntArray();
  private long lastSendHeartTime = 0L;
  private long lastTouchTime = 0L;
  private Set<OnReceiveFloatHeartListener> listenerSet = new HashSet();
  private IQQLiveSDK liveSDK;
  private PushReceiver pushReceiver;
  private int sentHeartCount = 0;
  
  private void initPush(IQQLiveSDK paramIQQLiveSDK)
  {
    this.pushReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a().a(48, new QQLiveFloatHeartServiceImpl.2(this));
  }
  
  private void onFreeLoveMessageReceive(BroadcastFreeLove paramBroadcastFreeLove)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onFreeLoveMessageReceive] data:");
      ((StringBuilder)localObject1).append(paramBroadcastFreeLove);
      QLog.d("QQLiveFloatHeartService", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new QLBroadCastFreeLove();
    ((QLBroadCastFreeLove)localObject1).roomId = paramBroadcastFreeLove.a;
    ((QLBroadCastFreeLove)localObject1).subRoomId = paramBroadcastFreeLove.b;
    Object localObject2 = new SparseIntArray();
    Object localObject3 = paramBroadcastFreeLove.c;
    int k = localObject3.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      Object localObject4 = localObject3[i];
      int m = this.sentHeartCount;
      if (m > 0) {
        this.sentHeartCount = (m - 1);
      } else {
        ((SparseIntArray)localObject2).put(localObject4.a, localObject4.b + ((SparseIntArray)localObject2).get(localObject4.a, 0));
      }
      i += 1;
    }
    ((QLBroadCastFreeLove)localObject1).freeLoves = new ArrayList();
    i = j;
    while (i < ((SparseIntArray)localObject2).size())
    {
      localObject3 = new com.tencent.mobileqq.qqlive.data.heart.FreeLove();
      ((com.tencent.mobileqq.qqlive.data.heart.FreeLove)localObject3).loveType = ((SparseIntArray)localObject2).keyAt(i);
      ((com.tencent.mobileqq.qqlive.data.heart.FreeLove)localObject3).loveNum = ((SparseIntArray)localObject2).valueAt(i);
      ((QLBroadCastFreeLove)localObject1).freeLoves.add(localObject3);
      i += 1;
    }
    ((QLBroadCastFreeLove)localObject1).totalFreeLoveNum = paramBroadcastFreeLove.d;
    ((QLBroadCastFreeLove)localObject1).programId = paramBroadcastFreeLove.e;
    ((QLBroadCastFreeLove)localObject1).userNick = paramBroadcastFreeLove.f;
    paramBroadcastFreeLove = this.listenerSet.iterator();
    while (paramBroadcastFreeLove.hasNext())
    {
      localObject2 = (OnReceiveFloatHeartListener)paramBroadcastFreeLove.next();
      ((OnReceiveFloatHeartListener)localObject2).a((QLBroadCastFreeLove)localObject1);
      ((OnReceiveFloatHeartListener)localObject2).a(((QLBroadCastFreeLove)localObject1).freeLoves, Boolean.valueOf(true));
    }
  }
  
  private SendFreeLoveReq packSendFreeLoveReq(FloatHeart paramFloatHeart)
  {
    SendFreeLoveReq localSendFreeLoveReq = new SendFreeLoveReq();
    localSendFreeLoveReq.a = paramFloatHeart.anchorUid;
    localSendFreeLoveReq.b = paramFloatHeart.roomId;
    localSendFreeLoveReq.c = paramFloatHeart.programId;
    if (paramFloatHeart.freeLoves == null) {
      paramFloatHeart.freeLoves = new ArrayList();
    }
    com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove[] arrayOfFreeLove = new com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove[this.clickedHeartList.size()];
    int i = 0;
    int j = 0;
    while ((i < this.clickedHeartList.size()) && (i < arrayOfFreeLove.length))
    {
      com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove localFreeLove = new com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove();
      localFreeLove.a = this.clickedHeartList.keyAt(i);
      localFreeLove.b = this.clickedHeartList.get(localFreeLove.a);
      j += localFreeLove.b;
      arrayOfFreeLove[i] = localFreeLove;
      paramFloatHeart.freeLoves.add(new com.tencent.mobileqq.qqlive.data.heart.FreeLove(localFreeLove.a, localFreeLove.b));
      i += 1;
    }
    localSendFreeLoveReq.d = arrayOfFreeLove;
    this.sentHeartCount += j;
    return localSendFreeLoveReq;
  }
  
  public void addOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener)
  {
    if (paramOnReceiveFloatHeartListener != null) {
      this.listenerSet.add(paramOnReceiveFloatHeartListener);
    }
  }
  
  public void destroy()
  {
    this.listenerSet.clear();
    PushReceiver localPushReceiver = this.pushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    initPush(paramIQQLiveSDK);
    this.liveSDK = paramIQQLiveSDK;
  }
  
  public void removeOnReceiveFloatHeartListener(OnReceiveFloatHeartListener paramOnReceiveFloatHeartListener)
  {
    if (paramOnReceiveFloatHeartListener != null) {
      this.listenerSet.remove(paramOnReceiveFloatHeartListener);
    }
  }
  
  public void reset()
  {
    this.listenerSet.clear();
    PushReceiver localPushReceiver = this.pushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
  }
  
  public void sendFloatHeart(FloatHeart paramFloatHeart)
  {
    long l = System.currentTimeMillis();
    if (l - this.lastTouchTime < 100L) {
      return;
    }
    this.lastTouchTime = l;
    Object localObject = new com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove();
    int i = (int)(Math.random() * 8.0D);
    ((com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove)localObject).a = i;
    ((com.tencent.trpcprotocol.ilive.sendFreeLove.sendFreeLove.nano.FreeLove)localObject).b = 1;
    localObject = this.clickedHeartList;
    ((SparseIntArray)localObject).put(i, ((SparseIntArray)localObject).get(i, 0) + 1);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new com.tencent.mobileqq.qqlive.data.heart.FreeLove(i, 1));
    Iterator localIterator = this.listenerSet.iterator();
    while (localIterator.hasNext()) {
      ((OnReceiveFloatHeartListener)localIterator.next()).a((ArrayList)localObject, Boolean.valueOf(false));
    }
    if (l - this.lastSendHeartTime < 3000L) {
      return;
    }
    this.lastSendHeartTime = l;
    if (this.liveSDK == null)
    {
      QLog.e("QQLiveFloatHeartService", 1, "[sendFloatHeart] liveSdk is null!");
      return;
    }
    paramFloatHeart = packSendFreeLoveReq(paramFloatHeart);
    ((IQQLiveSsoModule)this.liveSDK.getExtModule("sso_module")).a("trpc.qlive.send_free_love.SendFreeLove", "SendFreeLove", MessageNano.toByteArray(paramFloatHeart), new QQLiveFloatHeartServiceImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFloatHeartServiceImpl
 * JD-Core Version:    0.7.0.1
 */