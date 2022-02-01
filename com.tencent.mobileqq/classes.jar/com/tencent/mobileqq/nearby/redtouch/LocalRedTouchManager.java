package com.tencent.mobileqq.nearby.redtouch;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cd.PullRedpointReq;
import tencent.im.oidb.cmd0x6cd.RedpointInfo;
import tencent.im.oidb.cmd0x6ce.ReadRedpointReq;
import tencent.im.oidb.cmd0x6f5.RspBody;
import tencent.im.oidb.cmd0x6f5.TaskInfo;

public class LocalRedTouchManager
  implements Handler.Callback, Manager
{
  public static Map<Integer, Integer> c = new HashMap(5);
  @Deprecated
  public static final int[] d = { 10001 };
  boolean a = false;
  final Object b = new Object();
  RedPointPrePostHandleObserver e;
  private QQAppInterface f;
  private MqqHandler g = new MqqHandler(ThreadManager.getFileThreadLooper(), this);
  private String h = null;
  private ConcurrentHashMap<Integer, RedPointConfig> i = new ConcurrentHashMap();
  private RedPointNode j;
  private ConcurrentHashMap<Integer, RedPointNode> k = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, RedTouchItem> l = new ConcurrentHashMap();
  private Vector<RedTouchItem> m = new Vector();
  
  static
  {
    c.put(Integer.valueOf(10005), Integer.valueOf(100601));
  }
  
  public LocalRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.f = paramQQAppInterface;
    this.e = new DefaultRedPointPrePostHandler(paramQQAppInterface, this);
    f();
  }
  
  private void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    RedTouchItem localRedTouchItem = (RedTouchItem)this.l.get(Integer.valueOf(paramInt));
    int n = 0;
    int i2 = 0;
    int i1 = 0;
    if (localRedTouchItem == null)
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      n = i1;
      if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
        n = paramRedTouchItem.passThroughLevel - 1;
      }
      localRedTouchItem.passThroughLevel = n;
      this.l.put(Integer.valueOf(paramInt), localRedTouchItem);
      return;
    }
    if (localRedTouchItem.unReadFlag)
    {
      i1 = RedTouchUtil.a(localRedTouchItem.redtouchType);
      i2 = RedTouchUtil.a(paramRedTouchItem.redtouchType);
      if (i2 > i1)
      {
        localRedTouchItem = new RedTouchItem();
        RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
        if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
          n = paramRedTouchItem.passThroughLevel - 1;
        }
        localRedTouchItem.passThroughLevel = n;
        this.l.put(Integer.valueOf(paramInt), localRedTouchItem);
        return;
      }
      if ((i2 == i1) && (paramRedTouchItem.redtouchType == 2)) {
        localRedTouchItem.count += paramRedTouchItem.count;
      }
    }
    else
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      n = i2;
      if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
        n = paramRedTouchItem.passThroughLevel - 1;
      }
      localRedTouchItem.passThroughLevel = n;
      this.l.put(Integer.valueOf(paramInt), localRedTouchItem);
    }
  }
  
  private void b(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 1;
    if (bool) {
      QLog.d("LocalRedTouchManager", 2, String.format(Locale.getDefault(), "handleRedPoint item=%s saveToFile=%s", new Object[] { paramRedTouchItem, Boolean.valueOf(paramBoolean) }));
    }
    RedPointConfig localRedPointConfig1 = (RedPointConfig)this.i.get(Integer.valueOf(paramRedTouchItem.taskId));
    if (localRedPointConfig1 != null)
    {
      this.e.a(paramRedTouchItem, localRedPointConfig1.redPointId);
      RedTouchItem localRedTouchItem = a(localRedPointConfig1.redPointId);
      int n = i1;
      if (localRedTouchItem != null)
      {
        RedPointConfig localRedPointConfig2 = (RedPointConfig)this.i.get(Integer.valueOf(localRedTouchItem.taskId));
        n = i1;
        if (localRedPointConfig2 != null)
        {
          n = i1;
          if (localRedPointConfig2.priority > localRedPointConfig1.priority)
          {
            n = i1;
            if (localRedTouchItem.unReadFlag)
            {
              if (QLog.isColorLevel()) {
                QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
              }
              n = 0;
            }
          }
        }
      }
      if (n == 0) {
        return;
      }
      if (this.k.containsKey(Integer.valueOf(localRedPointConfig1.redPointId)))
      {
        localRedTouchItem = (RedTouchItem)this.l.get(Integer.valueOf(localRedPointConfig1.redPointId));
        if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.redtouchType == 2) && (paramRedTouchItem.redtouchType == 2)) {
          paramRedTouchItem.count += localRedTouchItem.count;
        }
        paramRedTouchItem.passThroughLevel = localRedPointConfig1.passThroughLevel;
        this.l.put(Integer.valueOf(localRedPointConfig1.redPointId), paramRedTouchItem);
        f(localRedPointConfig1.redPointId);
        if (paramBoolean) {
          e();
        }
      }
    }
  }
  
  private boolean c(RedTouchItem paramRedTouchItem)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag))
    {
      if (paramRedTouchItem.isClosed) {
        return true;
      }
      if (paramRedTouchItem.validTimeRemained < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LocalRedTouchManager", 2, "validTimeRemained < 0");
        }
        return false;
      }
      int n = (int)((l1 - paramRedTouchItem.receiveTime) / 1000L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isOutOfDate,remain:");
        localStringBuilder.append(paramRedTouchItem.validTimeRemained);
        localStringBuilder.append(" consume:");
        localStringBuilder.append(n);
        QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
      }
      if (n >= paramRedTouchItem.validTimeRemained)
      {
        if (paramRedTouchItem.unReadFlag)
        {
          paramRedTouchItem.unReadFlag = false;
          paramRedTouchItem = (RedPointConfig)this.i.get(Integer.valueOf(paramRedTouchItem.taskId));
          if (paramRedTouchItem != null) {
            f(paramRedTouchItem.redPointId);
          }
          e();
        }
        return true;
      }
      return false;
    }
    return true;
  }
  
  private void f()
  {
    this.j = new RedPointNode();
    RedPointNode localRedPointNode1 = this.j;
    localRedPointNode1.a = -1;
    this.k.put(Integer.valueOf(localRedPointNode1.a), this.j);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = 10018;
    localRedPointNode1.b = this.j;
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = -3;
    localRedPointNode1.b = this.j;
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
    localRedPointNode1.c = new ArrayList();
    Object localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = -7;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode1;
    localRedPointNode1.c.add(localObject1);
    ((RedPointNode)localObject1).c = new ArrayList();
    RedPointNode localRedPointNode2 = new RedPointNode();
    localRedPointNode2.a = -4;
    this.k.put(Integer.valueOf(localRedPointNode2.a), localRedPointNode2);
    localRedPointNode2.b = localRedPointNode1;
    localRedPointNode1.c.add(localRedPointNode2);
    localRedPointNode2.c = new ArrayList();
    Object localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).a = 10015;
    this.k.put(Integer.valueOf(((RedPointNode)localObject2).a), localObject2);
    ((RedPointNode)localObject2).b = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).c.add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).a = 10016;
    this.k.put(Integer.valueOf(((RedPointNode)localObject2).a), localObject2);
    ((RedPointNode)localObject2).b = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).c.add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).a = 100601;
    ((RedPointNode)localObject2).b = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).c.add(localObject2);
    this.k.put(Integer.valueOf(100601), localObject2);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10019;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode2;
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10020;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode2;
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10022;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode2;
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10021;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode2;
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10023;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10024;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10025;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10026;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10027;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10028;
    ((RedPointNode)localObject1).b = localRedPointNode2;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode2.c.add(localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.a = -2;
    localRedPointNode2.b = this.j;
    this.k.put(Integer.valueOf(localRedPointNode2.a), localRedPointNode2);
    this.j.c = Arrays.asList(new RedPointNode[] { localRedPointNode1, localRedPointNode2 });
    localRedPointNode2.c = new ArrayList();
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 100510;
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    ((RedPointNode)localObject1).b = localRedPointNode2;
    localRedPointNode2.c.add(localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = 10011;
    localRedPointNode1.b = ((RedPointNode)localObject1);
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localRedPointNode1);
    ((RedPointNode)localObject1).c = ((List)localObject2);
    localObject1 = new ArrayList();
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).a = 100523;
    ((RedPointNode)localObject2).b = localRedPointNode1;
    this.k.put(Integer.valueOf(((RedPointNode)localObject2).a), localObject2);
    ((List)localObject1).add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).a = 100517;
    ((RedPointNode)localObject2).b = localRedPointNode1;
    this.k.put(Integer.valueOf(((RedPointNode)localObject2).a), localObject2);
    ((List)localObject1).add(localObject2);
    localRedPointNode1.c = ((List)localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = -5;
    localRedPointNode1.b = localRedPointNode2;
    localRedPointNode2.c.add(localRedPointNode1);
    localRedPointNode1.c = new ArrayList();
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = -6;
    localRedPointNode1.b = localRedPointNode2;
    localRedPointNode2.c.add(localRedPointNode1);
    localRedPointNode1.c = new ArrayList();
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).a = 10014;
    ((RedPointNode)localObject1).b = localRedPointNode1;
    localRedPointNode1.c.add(localObject1);
    this.k.put(Integer.valueOf(((RedPointNode)localObject1).a), localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.a = 10013;
    localRedPointNode1.b = localRedPointNode2;
    localRedPointNode2.c.add(localRedPointNode1);
    this.k.put(Integer.valueOf(localRedPointNode1.a), localRedPointNode1);
  }
  
  private void f(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateParents:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RedTouchItem)this.l.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((RedTouchItem)localObject).passThroughLevel > 0))
    {
      int n = paramInt;
      paramInt = 0;
      while (paramInt < ((RedTouchItem)localObject).passThroughLevel)
      {
        RedPointNode localRedPointNode = (RedPointNode)this.k.get(Integer.valueOf(n));
        if ((localRedPointNode == null) || (localRedPointNode.b == null)) {
          break;
        }
        RedTouchItem localRedTouchItem = (RedTouchItem)this.l.get(Integer.valueOf(localRedPointNode.b.a));
        if (localRedTouchItem != null) {
          localRedTouchItem.unReadFlag = false;
        }
        if (localRedPointNode.b.c != null)
        {
          n = 0;
          while (n < localRedPointNode.b.c.size())
          {
            int i1 = ((RedPointNode)localRedPointNode.b.c.get(n)).a;
            localRedTouchItem = (RedTouchItem)this.l.get(Integer.valueOf(i1));
            if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (!localRedTouchItem.isClosed) && (localRedTouchItem.passThroughLevel > 0)) {
              a(localRedTouchItem, localRedPointNode.b.a);
            }
            n += 1;
          }
        }
        n = localRedPointNode.b.a;
        paramInt += 1;
      }
    }
  }
  
  private void g()
  {
    if (this.a) {
      return;
    }
    a();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("red_point_configs_");
    ((StringBuilder)???).append(this.f.getCurrentAccountUin());
    ??? = (ConcurrentHashMap)FileUtils.readObject(((StringBuilder)???).toString());
    if (??? != null)
    {
      this.i.clear();
      this.i.putAll((Map)???);
    }
    ??? = null;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("red_point_info_");
      ((StringBuilder)localObject2).append(this.f.getCurrentAccountUin());
      localObject2 = (ConcurrentHashMap)FileUtils.readObject(((StringBuilder)localObject2).toString());
      ??? = localObject2;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("LocalRedTouchManager", 1, localThrowable.getMessage(), localThrowable);
    }
    if (??? != null)
    {
      this.l.clear();
      this.l.putAll((Map)???);
    }
    synchronized (this.b)
    {
      this.a = true;
      return;
    }
  }
  
  private boolean h()
  {
    synchronized (this.b)
    {
      boolean bool = this.a;
      return bool;
    }
  }
  
  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_point_info_");
    localStringBuilder.append(this.f.getCurrentAccountUin());
    FileUtils.writeObject(localStringBuilder.toString(), this.l);
  }
  
  private void j()
  {
    if (!h()) {
      g();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.i);
    if (localConcurrentHashMap.size() > 0)
    {
      QLog.d("LocalRedTouchManager", 1, "pullRedPointInfo using config");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        RedPointConfig localRedPointConfig = (RedPointConfig)localConcurrentHashMap.get(localInteger);
        RedTouchItem localRedTouchItem = a(localRedPointConfig.redPointId);
        cmd0x6cd.PullRedpointReq localPullRedpointReq = new cmd0x6cd.PullRedpointReq();
        localPullRedpointReq.uint32_taskid.set(localInteger.intValue());
        if (localRedTouchItem != null) {
          localPullRedpointReq.uint64_last_pull_seq.set(localRedTouchItem.curSeq);
        } else {
          localPullRedpointReq.uint64_last_pull_seq.set(0L);
        }
        if (QLog.isColorLevel()) {
          QLog.i("LocalRedTouchManager", 2, String.format("pullRedPointInfo. addPull, taskId=%d seq=%d redpointId=%d pLevel=%d bLevel=%d", new Object[] { localInteger, Long.valueOf(localPullRedpointReq.uint64_last_pull_seq.get()), Integer.valueOf(localRedPointConfig.redPointId), Integer.valueOf(localRedPointConfig.passThroughLevel), Integer.valueOf(localRedPointConfig.bindLevel) }));
        }
        localArrayList.add(localPullRedpointReq);
      }
      if (localArrayList.size() > 0)
      {
        ((RedtouchHandler)this.f.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a(localArrayList, false);
        long l1 = SystemClock.elapsedRealtime();
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.f.getAccount(), "pull_red_touch_time2", Long.valueOf(l1));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "pull config on null");
      }
      ((RedtouchHandler)this.f.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
    }
  }
  
  public RedTouchItem a(int paramInt)
  {
    Object localObject = this.l;
    if (localObject != null) {
      localObject = (RedTouchItem)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
    } else {
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder;
      if (localObject == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRedPointInfo: ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", not found");
        QLog.d("LocalRedTouchManager", 2, localStringBuilder.toString());
        return localObject;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRedPointInfo id=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" info=");
        localStringBuilder.append(((RedTouchItem)localObject).toString());
        QLog.d("LocalRedTouchManager", 2, localStringBuilder.toString());
      }
    }
    return localObject;
  }
  
  public String a()
  {
    if (this.h == null) {
      this.h = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.f.getAccount(), "red_point_config_version", ""));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedPointConfigVersion, version = ");
      localStringBuilder.append(this.h);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
    }
    return this.h;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, false, 0L, false, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRedPointClick, redPointId=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", bCustom=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(", customSeq=");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", customReadFlag=");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(", bReport=");
      ((StringBuilder)localObject1).append(paramBoolean3);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.l;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (RedTouchItem)((ConcurrentHashMap)localObject1).get(Integer.valueOf(paramInt));
    if ((localObject1 != null) && (((RedTouchItem)localObject1).unReadFlag))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("rt=");
        ((StringBuilder)localObject2).append(((RedTouchItem)localObject1).toString());
        QLog.d("LocalRedTouchManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((paramBoolean1) && (paramBoolean2)) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      ((RedTouchItem)localObject1).unReadFlag = paramBoolean2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("rt.unReadFlag set to ");
        ((StringBuilder)localObject2).append(((RedTouchItem)localObject1).unReadFlag);
        QLog.d("LocalRedTouchManager", 2, ((StringBuilder)localObject2).toString());
      }
      f(paramInt);
      e();
      if (this.g.hasMessages(1)) {
        this.g.removeMessages(1);
      }
      this.g.sendEmptyMessage(1);
      if (paramBoolean3)
      {
        localObject1 = new cmd0x6ce.ReadRedpointReq();
        ((cmd0x6ce.ReadRedpointReq)localObject1).uint32_appid.set(paramInt);
        if (paramBoolean1) {
          ((cmd0x6ce.ReadRedpointReq)localObject1).uint64_read_seq.set(paramLong);
        }
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        ((RedtouchHandler)this.f.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a((List)localObject2);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRedPointConfigVersion, version = ");
      localStringBuilder.append(paramString);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.h = paramString;
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.f.getAccount(), "red_point_config_version", paramString);
    }
  }
  
  public void a(List<RedTouchItem> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetRedPointInfo, list size=");
    Object localObject;
    if (paramList == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramList.size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", hasMore=");
    localStringBuilder.append(paramBoolean);
    QLog.i("LocalRedTouchManager", 1, localStringBuilder.toString());
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      this.m.addAll(paramList);
      if (!paramBoolean)
      {
        int n = this.m.size() - 1;
        while (n >= 0)
        {
          if (((RedTouchItem)this.m.get(n)).taskId == 10001) {
            this.m.remove(n);
          }
          n -= 1;
        }
        if (((RedTouchItem)paramList.get(0)).configVersion.equals(this.h))
        {
          b();
          return;
        }
        ((RedtouchHandler)this.f.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
      }
    }
  }
  
  public void a(cmd0x6f5.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs");
    }
    if (!h()) {
      g();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramRspBody != null) && (paramRspBody.rpt_task_info != null) && (paramRspBody.rpt_task_info.has()))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      paramRspBody = paramRspBody.rpt_task_info.get();
      Object localObject = paramRspBody.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmd0x6f5.TaskInfo localTaskInfo = (cmd0x6f5.TaskInfo)((Iterator)localObject).next();
        RedPointConfig localRedPointConfig = new RedPointConfig();
        localRedPointConfig.taskId = localTaskInfo.uint32_task_id.get();
        localRedPointConfig.redPointId = localTaskInfo.uint32_appid.get();
        localRedPointConfig.passThroughLevel = localTaskInfo.uint32_passthrough_level.get();
        localRedPointConfig.bindLevel = localTaskInfo.uint32_show_level.get();
        localRedPointConfig.priority = localTaskInfo.uint32_priority.get();
        localConcurrentHashMap.put(Integer.valueOf(localRedPointConfig.taskId), localRedPointConfig);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("\n");
          localStringBuilder.append(localRedPointConfig.toString());
        }
      }
      this.i.clear();
      this.i.putAll(localConcurrentHashMap);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveRedPointConfigs, config size = ");
        ((StringBuilder)localObject).append(paramRspBody.size());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
        QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
      }
      paramRspBody = new StringBuilder();
      paramRspBody.append("red_point_configs_");
      paramRspBody.append(this.f.getCurrentAccountUin());
      FileUtils.writeObject(paramRspBody.toString(), localConcurrentHashMap);
    }
  }
  
  public void a(short paramShort)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetUnreadRedTouchFlag: ");
      localStringBuilder.append(paramShort);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
    }
    long l1 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.f.getAccount(), "pull_red_touch_time2", Long.valueOf(0L))).longValue();
    long l2 = SystemClock.elapsedRealtime();
    if ((paramShort > 0) || (l2 - l1 > 43200000L)) {
      c();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onProfileRedTouchClick, isFromFriendElseNearby:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    b(100601);
    if (paramBoolean)
    {
      c(10016);
      c(10015);
    }
    Object localObject = (IRedTouchManager)this.f.getRuntimeService(IRedTouchManager.class, "");
    if (localObject == null) {
      return;
    }
    ((IRedTouchManager)localObject).dismissRedTouch("100510");
    ((IRedTouchManager)localObject).dismissRedTouch("100460");
    b(100510);
    b(-7);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.i("LocalRedTouchManager", 1, "onLinePush");
    if (!h()) {
      g();
    }
    cmd0x6cd.RedpointInfo localRedpointInfo = new cmd0x6cd.RedpointInfo();
    try
    {
      localRedpointInfo.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = RedTouchItem.getRedTouchItem(localRedpointInfo);
    if (paramArrayOfByte == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      RedPointConfig localRedPointConfig = (RedPointConfig)this.i.get(Integer.valueOf(paramArrayOfByte.taskId));
      int n;
      if (localRedPointConfig == null) {
        n = 0;
      } else {
        n = localRedPointConfig.redPointId;
      }
      QLog.i("LocalRedTouchManager", 2, String.format("onLinePush item:%s appid=%d version=%s", new Object[] { paramArrayOfByte, Integer.valueOf(n), this.h }));
    }
    if (localRedpointInfo.str_config_version.get().equals(this.h))
    {
      b(paramArrayOfByte, true);
      ((IRedTouchServer)this.f.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f);
      this.e.a(Collections.singletonList(paramArrayOfByte));
      return;
    }
    this.m.add(paramArrayOfByte);
    ((RedtouchHandler)this.f.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
  }
  
  public boolean a(RedTouchItem paramRedTouchItem)
  {
    return (paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!c(paramRedTouchItem));
  }
  
  public boolean a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if ((paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!paramRedTouchItem.isClosed) && ((paramBoolean) || (!c(paramRedTouchItem)))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if ((paramRedTouchItem != null) && (paramRedTouchItem.redtouchType == 2)) {
      return (paramBoolean) && (paramRedTouchItem.count > 0);
    }
    return paramBoolean;
  }
  
  public void b()
  {
    if (this.m.size() > 0)
    {
      Iterator localIterator = this.m.iterator();
      while (localIterator.hasNext()) {
        b((RedTouchItem)localIterator.next(), false);
      }
      i();
      this.e.a(this.m);
      this.m.clear();
      ((IRedTouchServer)this.f.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f);
    }
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false, 0L, false, true);
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    return a(a(paramInt), paramBoolean);
  }
  
  public boolean b(RedTouchItem paramRedTouchItem)
  {
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (paramRedTouchItem != null)
    {
      bool2 = bool3;
      if (paramRedTouchItem.unReadFlag)
      {
        if (paramRedTouchItem.validTimeRemained < 0) {}
        while ((int)((System.currentTimeMillis() - paramRedTouchItem.receiveTime) / 1000L) < paramRedTouchItem.validTimeRemained)
        {
          bool1 = true;
          break;
        }
        paramRedTouchItem.unReadFlag = false;
        RedPointConfig localRedPointConfig = (RedPointConfig)this.i.get(Integer.valueOf(paramRedTouchItem.taskId));
        if (localRedPointConfig != null) {
          f(localRedPointConfig.redPointId);
        }
        e();
        boolean bool1 = false;
        if (paramRedTouchItem.redtouchType == 2)
        {
          bool2 = bool3;
          if (bool1)
          {
            bool2 = bool3;
            if (paramRedTouchItem.count > 0) {
              return true;
            }
          }
        }
        else
        {
          bool2 = bool1;
        }
      }
    }
    return bool2;
  }
  
  public void c()
  {
    ThreadManager.excute(new LocalRedTouchManager.1(this), 64, null, true);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearParentsButSelf, redPointId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    if (localObject == null) {
      return;
    }
    localObject = (RedTouchItem)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((RedTouchItem)localObject).unReadFlag) && (((RedTouchItem)localObject).passThroughLevel > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("rt=");
        localStringBuilder.append(((RedTouchItem)localObject).toString());
        QLog.d("LocalRedTouchManager", 2, localStringBuilder.toString());
      }
      ((RedTouchItem)localObject).unReadFlag = false;
      f(paramInt);
      ((RedTouchItem)localObject).passThroughLevel = 0;
      ((RedTouchItem)localObject).unReadFlag = true;
      e();
      if (this.g.hasMessages(1)) {
        this.g.removeMessages(1);
      }
      this.g.sendEmptyMessage(1);
    }
  }
  
  public int d()
  {
    Object localObject = a(10016);
    RedTouchItem localRedTouchItem = a(10015);
    int n = 3;
    if ((localObject != null) && (localRedTouchItem != null)) {
      if (((RedTouchItem)localObject).curSeq <= localRedTouchItem.curSeq) {
        break label58;
      }
    } else {
      if (localObject == null) {
        break label53;
      }
    }
    n = 4;
    break label68;
    label53:
    if (localRedTouchItem != null)
    {
      label58:
      localObject = localRedTouchItem;
    }
    else
    {
      localObject = null;
      n = 1;
    }
    label68:
    if ((localObject != null) && (((RedTouchItem)localObject).bytes != null) && (((RedTouchItem)localObject).bytes.length > 0)) {
      try
      {
        int i1 = new JSONObject(new String(((RedTouchItem)localObject).bytes, "utf-8")).optInt("type", 1);
        return i1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LocalRedTouchManager", 2, localException, new Object[0]);
        }
      }
    }
    return n;
  }
  
  public void d(int paramInt)
  {
    if (paramInt != 1) {}
  }
  
  public void e()
  {
    if (this.g.hasMessages(0)) {
      this.g.removeMessages(0);
    }
    this.g.sendEmptyMessage(0);
  }
  
  public void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRedPointChanged redPointId:");
      localStringBuilder.append(paramInt);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
    }
    f(paramInt);
    e();
    if (this.g.hasMessages(1)) {
      this.g.removeMessages(1);
    }
    this.g.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int n = paramMessage.what;
    if (n != 0)
    {
      if (n != 1) {
        return false;
      }
      ((IRedTouchServer)this.f.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.f);
      return false;
    }
    i();
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager
 * JD-Core Version:    0.7.0.1
 */