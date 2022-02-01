package com.tencent.mobileqq.nearby.redtouch;

import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
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
  public static Map<Integer, Integer> a;
  @Deprecated
  public static final int[] a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RedPointNode jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
  RedPointPrePostHandleObserver jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString = null;
  private Vector<RedTouchItem> jdField_a_of_type_JavaUtilVector = new Vector();
  private ConcurrentHashMap<Integer, RedPointConfig> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getFileThreadLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap<Integer, RedPointNode> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, RedTouchItem> c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
    jdField_a_of_type_ArrayOfInt = new int[] { 10001 };
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10005), Integer.valueOf(100601));
  }
  
  public LocalRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver = new DefaultRedPointPrePostHandler(paramQQAppInterface, this);
    d();
  }
  
  private void a(RedTouchItem paramRedTouchItem, int paramInt)
  {
    int j = 0;
    int i = 0;
    RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if (localRedTouchItem == null)
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      if (paramRedTouchItem.passThroughLevel - 1 >= 0)
      {
        i = paramRedTouchItem.passThroughLevel - 1;
        localRedTouchItem.passThroughLevel = i;
        this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
      }
    }
    int k;
    do
    {
      return;
      i = 0;
      break;
      if (!localRedTouchItem.unReadFlag) {
        break label200;
      }
      j = RedTouchUtil.a(localRedTouchItem.redtouchType);
      k = RedTouchUtil.a(paramRedTouchItem.redtouchType);
      if (k > j)
      {
        localRedTouchItem = new RedTouchItem();
        RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
        if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
          i = paramRedTouchItem.passThroughLevel - 1;
        }
        localRedTouchItem.passThroughLevel = i;
        this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
        return;
      }
    } while ((k != j) || (paramRedTouchItem.redtouchType != 2));
    localRedTouchItem.count += paramRedTouchItem.count;
    return;
    label200:
    localRedTouchItem = new RedTouchItem();
    RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
    i = j;
    if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
      i = paramRedTouchItem.passThroughLevel - 1;
    }
    localRedTouchItem.passThroughLevel = i;
    this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
  }
  
  private void a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, String.format(Locale.getDefault(), "handleRedPoint item=%s saveToFile=%s", new Object[] { paramRedTouchItem, Boolean.valueOf(paramBoolean) }));
    }
    RedPointConfig localRedPointConfig1 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
    RedTouchItem localRedTouchItem;
    int i;
    if (localRedPointConfig1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver.a(paramRedTouchItem, localRedPointConfig1.redPointId);
      localRedTouchItem = a(localRedPointConfig1.redPointId);
      if (localRedTouchItem == null) {
        break label162;
      }
      RedPointConfig localRedPointConfig2 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localRedTouchItem.taskId));
      if ((localRedPointConfig2 == null) || (localRedPointConfig2.priority <= localRedPointConfig1.priority) || (!localRedTouchItem.unReadFlag)) {
        break label157;
      }
      if (!QLog.isColorLevel()) {
        break label295;
      }
      QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {}
      label157:
      label162:
      do
      {
        do
        {
          return;
          i = 1;
          break;
          i = 1;
          break;
        } while (!this.b.containsKey(Integer.valueOf(localRedPointConfig1.redPointId)));
        localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(localRedPointConfig1.redPointId));
        if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.redtouchType == 2) && (paramRedTouchItem.redtouchType == 2))
        {
          i = paramRedTouchItem.count;
          localRedTouchItem.count += i;
        }
        paramRedTouchItem.passThroughLevel = localRedPointConfig1.passThroughLevel;
        this.c.put(Integer.valueOf(localRedPointConfig1.redPointId), paramRedTouchItem);
        e(localRedPointConfig1.redPointId);
      } while (!paramBoolean);
      c();
      return;
      label295:
      i = 0;
    }
  }
  
  private boolean a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      return bool;
    }
  }
  
  private boolean c(RedTouchItem paramRedTouchItem)
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    if ((paramRedTouchItem == null) || (!paramRedTouchItem.unReadFlag) || (paramRedTouchItem.isClosed)) {
      bool = true;
    }
    int i;
    do
    {
      do
      {
        return bool;
        if (paramRedTouchItem.validTimeRemained >= 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LocalRedTouchManager", 2, "validTimeRemained < 0");
      return false;
      i = (int)((l - paramRedTouchItem.receiveTime) / 1000L);
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "isOutOfDate,remain:" + paramRedTouchItem.validTimeRemained + " consume:" + i);
      }
    } while (i < paramRedTouchItem.validTimeRemained);
    if (paramRedTouchItem.unReadFlag)
    {
      paramRedTouchItem.unReadFlag = false;
      paramRedTouchItem = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
      if (paramRedTouchItem != null) {
        e(paramRedTouchItem.redPointId);
      }
      c();
    }
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = new RedPointNode();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int = -1;
    this.b.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode);
    RedPointNode localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 10018;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = -3;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = -7;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
    RedPointNode localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = -4;
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localRedPointNode2);
    localRedPointNode2.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 10015;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 10016;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 100601;
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = ((RedPointNode)localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
    this.b.put(Integer.valueOf(100601), localObject2);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10019;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10020;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10022;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10021;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10023;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10024;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10025;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10026;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10027;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10028;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = -2;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList = Arrays.asList(new RedPointNode[] { localRedPointNode1, localRedPointNode2 });
    localRedPointNode2.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 100510;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 10011;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = ((RedPointNode)localObject1);
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localRedPointNode1);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    localObject1 = new ArrayList();
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 100523;
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((List)localObject1).add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 100517;
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((List)localObject1).add(localObject2);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = -5;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localRedPointNode1);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = -6;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localRedPointNode1);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10014;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 10013;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localRedPointNode1);
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    ??? = (ConcurrentHashMap)FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (??? != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll((Map)???);
    }
    try
    {
      ??? = (ConcurrentHashMap)FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (??? != null)
      {
        this.c.clear();
        this.c.putAll((Map)???);
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("LocalRedTouchManager", 1, localThrowable.getMessage(), localThrowable);
        Object localObject2 = null;
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "updateParents:" + paramInt);
    }
    RedTouchItem localRedTouchItem1 = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if ((localRedTouchItem1 != null) && (localRedTouchItem1.passThroughLevel > 0))
    {
      int j = 0;
      int i = paramInt;
      paramInt = j;
      while (paramInt < localRedTouchItem1.passThroughLevel)
      {
        RedPointNode localRedPointNode = (RedPointNode)this.b.get(Integer.valueOf(i));
        if ((localRedPointNode == null) || (localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode == null)) {
          break;
        }
        RedTouchItem localRedTouchItem2 = (RedTouchItem)this.c.get(Integer.valueOf(localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int));
        if (localRedTouchItem2 != null) {
          localRedTouchItem2.unReadFlag = false;
        }
        if (localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList != null)
        {
          i = 0;
          while (i < localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList.size())
          {
            j = ((RedPointNode)localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
            localRedTouchItem2 = (RedTouchItem)this.c.get(Integer.valueOf(j));
            if ((localRedTouchItem2 != null) && (localRedTouchItem2.unReadFlag) && (!localRedTouchItem2.isClosed) && (localRedTouchItem2.passThroughLevel > 0)) {
              a(localRedTouchItem2, localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int);
            }
            i += 1;
          }
        }
        i = localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int;
        paramInt += 1;
      }
    }
  }
  
  private void f()
  {
    FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.c);
  }
  
  private void g()
  {
    if (!a()) {
      e();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0))
    {
      QLog.d("LocalRedTouchManager", 1, "pullRedPointInfo using config");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        RedPointConfig localRedPointConfig = (RedPointConfig)localConcurrentHashMap.get(localInteger);
        RedTouchItem localRedTouchItem = a(localRedPointConfig.redPointId);
        cmd0x6cd.PullRedpointReq localPullRedpointReq = new cmd0x6cd.PullRedpointReq();
        localPullRedpointReq.uint32_taskid.set(localInteger.intValue());
        if (localRedTouchItem != null) {
          localPullRedpointReq.uint64_last_pull_seq.set(localRedTouchItem.curSeq);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, String.format("pullRedPointInfo. addPull, taskId=%d seq=%d redpointId=%d pLevel=%d bLevel=%d", new Object[] { localInteger, Long.valueOf(localPullRedpointReq.uint64_last_pull_seq.get()), Integer.valueOf(localRedPointConfig.redPointId), Integer.valueOf(localRedPointConfig.passThroughLevel), Integer.valueOf(localRedPointConfig.bindLevel) }));
          }
          localArrayList.add(localPullRedpointReq);
          break;
          localPullRedpointReq.uint64_last_pull_seq.set(0L);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a(localArrayList, false);
        long l = SystemClock.elapsedRealtime();
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_red_touch_time2", Long.valueOf(l));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "pull config on null");
    }
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
  }
  
  public int a()
  {
    Object localObject1 = a(10016);
    RedTouchItem localRedTouchItem = a(10015);
    if ((localObject1 != null) && (localRedTouchItem != null)) {
      if (((RedTouchItem)localObject1).curSeq <= localRedTouchItem.curSeq) {}
    }
    for (int i = 4;; i = 1)
    {
      for (;;)
      {
        int j = i;
        if (localObject1 != null)
        {
          j = i;
          if (((RedTouchItem)localObject1).bytes != null)
          {
            j = i;
            if (((RedTouchItem)localObject1).bytes.length <= 0) {}
          }
        }
        try
        {
          j = new JSONObject(new String(((RedTouchItem)localObject1).bytes, "utf-8")).optInt("type", 1);
          return j;
          i = 3;
          localObject1 = localRedTouchItem;
          continue;
          if (localObject1 != null)
          {
            i = 4;
          }
          else if (localRedTouchItem != null)
          {
            i = 3;
            localObject1 = localRedTouchItem;
          }
        }
        catch (Exception localException)
        {
          do
          {
            j = i;
          } while (!QLog.isColorLevel());
          QLog.e("LocalRedTouchManager", 2, localException, new Object[0]);
          return i;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public RedTouchItem a(int paramInt)
  {
    RedTouchItem localRedTouchItem = null;
    if (this.c != null) {
      localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    }
    if (QLog.isColorLevel())
    {
      if (localRedTouchItem != null) {
        break label68;
      }
      QLog.d("LocalRedTouchManager", 2, "getRedPointInfo: " + paramInt + ", not found");
    }
    label68:
    while (!QLog.isColorLevel()) {
      return localRedTouchItem;
    }
    QLog.d("LocalRedTouchManager", 2, "getRedPointInfo id=" + paramInt + " info=" + localRedTouchItem.toString());
    return localRedTouchItem;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = ((String)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", ""));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "getRedPointConfigVersion, version = " + this.jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      while (localIterator.hasNext()) {
        a((RedTouchItem)localIterator.next(), false);
      }
      f();
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver.a(this.jdField_a_of_type_JavaUtilVector);
      this.jdField_a_of_type_JavaUtilVector.clear();
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false, 0L, false, true);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, false, 0L, false, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointClick, redPointId=" + paramInt + ", bCustom=" + paramBoolean1 + ", customSeq=" + paramLong + ", customReadFlag=" + paramBoolean2 + ", bReport=" + paramBoolean3);
    }
    if (this.c == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    } while ((localObject == null) || (!((RedTouchItem)localObject).unReadFlag));
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, "rt=" + ((RedTouchItem)localObject).toString());
    }
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((RedTouchItem)localObject).unReadFlag = paramBoolean2;
      if (QLog.isColorLevel()) {
        QLog.d("LocalRedTouchManager", 2, "rt.unReadFlag set to " + ((RedTouchItem)localObject).unReadFlag);
      }
      e(paramInt);
      c();
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if (!paramBoolean3) {
        break;
      }
      localObject = new cmd0x6ce.ReadRedpointReq();
      ((cmd0x6ce.ReadRedpointReq)localObject).uint32_appid.set(paramInt);
      if (paramBoolean1) {
        ((cmd0x6ce.ReadRedpointReq)localObject).uint64_read_seq.set(paramLong);
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a(localArrayList);
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "setRedPointConfigVersion, version = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", paramString);
    }
  }
  
  public void a(List<RedTouchItem> paramList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetRedPointInfo, list size=");
    Object localObject;
    if (paramList == null)
    {
      localObject = "null";
      QLog.i("LocalRedTouchManager", 1, localObject + ", hasMore=" + paramBoolean);
      if ((paramList != null) && (paramList.size() != 0)) {
        break label78;
      }
    }
    label78:
    do
    {
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
      this.jdField_a_of_type_JavaUtilVector.addAll(paramList);
    } while (paramBoolean);
    int i = this.jdField_a_of_type_JavaUtilVector.size() - 1;
    while (i >= 0)
    {
      if (((RedTouchItem)this.jdField_a_of_type_JavaUtilVector.get(i)).taskId == 10001) {
        this.jdField_a_of_type_JavaUtilVector.remove(i);
      }
      i -= 1;
    }
    if (((RedTouchItem)paramList.get(0)).configVersion.equals(this.jdField_a_of_type_JavaLangString))
    {
      a();
      return;
    }
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
  }
  
  public void a(cmd0x6f5.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs");
    }
    if (!a()) {
      e();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramRspBody != null) && (paramRspBody.rpt_task_info != null) && (paramRspBody.rpt_task_info.has()))
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      paramRspBody = paramRspBody.rpt_task_info.get();
      Iterator localIterator = paramRspBody.iterator();
      while (localIterator.hasNext())
      {
        cmd0x6f5.TaskInfo localTaskInfo = (cmd0x6f5.TaskInfo)localIterator.next();
        RedPointConfig localRedPointConfig = new RedPointConfig();
        localRedPointConfig.taskId = localTaskInfo.uint32_task_id.get();
        localRedPointConfig.redPointId = localTaskInfo.uint32_appid.get();
        localRedPointConfig.passThroughLevel = localTaskInfo.uint32_passthrough_level.get();
        localRedPointConfig.bindLevel = localTaskInfo.uint32_show_level.get();
        localRedPointConfig.priority = localTaskInfo.uint32_priority.get();
        localConcurrentHashMap.put(Integer.valueOf(localRedPointConfig.taskId), localRedPointConfig);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("\n").append(localRedPointConfig.toString());
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs, config size = " + paramRspBody.size() + " " + localStringBuilder.toString());
      }
      FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localConcurrentHashMap);
    }
  }
  
  public void a(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onGetUnreadRedTouchFlag: " + paramShort);
    }
    long l1 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_red_touch_time2", Long.valueOf(0L))).longValue();
    long l2 = SystemClock.elapsedRealtime();
    if ((paramShort > 0) || (l2 - l1 > 43200000L)) {
      b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onProfileRedTouchClick, isFromFriendElseNearby:" + paramBoolean);
    }
    a(100601);
    if (paramBoolean)
    {
      b(10016);
      b(10015);
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (localRedTouchManager == null) {
      return;
    }
    localRedTouchManager.c("100510");
    localRedTouchManager.c("100460");
    a(100510);
    a(-7);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    QLog.i("LocalRedTouchManager", 1, "onLinePush");
    if (!a()) {
      e();
    }
    cmd0x6cd.RedpointInfo localRedpointInfo = new cmd0x6cd.RedpointInfo();
    try
    {
      localRedpointInfo.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = RedTouchItem.getRedTouchItem(localRedpointInfo);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
      RedPointConfig localRedPointConfig;
      if (QLog.isColorLevel())
      {
        localRedPointConfig = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramArrayOfByte.taskId));
        if (localRedPointConfig != null) {
          break label180;
        }
      }
      label180:
      for (int i = 0;; i = localRedPointConfig.redPointId)
      {
        QLog.i("LocalRedTouchManager", 2, String.format("onLinePush item:%s appid=%d version=%s", new Object[] { paramArrayOfByte, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString }));
        if (!localRedpointInfo.str_config_version.get().equals(this.jdField_a_of_type_JavaLangString)) {
          break;
        }
        a(paramArrayOfByte, true);
        ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver.a(Collections.singletonList(paramArrayOfByte));
        return;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return a(a(paramInt), paramBoolean);
  }
  
  public boolean a(RedTouchItem paramRedTouchItem)
  {
    return (paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!c(paramRedTouchItem));
  }
  
  public boolean a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if ((paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!paramRedTouchItem.isClosed)) {
      if (paramBoolean) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if ((paramRedTouchItem != null) && (paramRedTouchItem.redtouchType == 2))
      {
        if ((paramBoolean) && (paramRedTouchItem.count > 0))
        {
          return true;
          if (!c(paramRedTouchItem)) {
            break;
          }
          paramBoolean = false;
          continue;
        }
        return false;
      }
    }
    return paramBoolean;
  }
  
  public void b()
  {
    ThreadManager.excute(new LocalRedTouchManager.1(this), 64, null, true);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "clearParentsButSelf, redPointId=" + paramInt);
    }
    if (this.c == null) {}
    RedTouchItem localRedTouchItem;
    do
    {
      return;
      localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    } while ((localRedTouchItem == null) || (!localRedTouchItem.unReadFlag) || (localRedTouchItem.passThroughLevel <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("LocalRedTouchManager", 2, "rt=" + localRedTouchItem.toString());
    }
    localRedTouchItem.unReadFlag = false;
    e(paramInt);
    localRedTouchItem.passThroughLevel = 0;
    localRedTouchItem.unReadFlag = true;
    c();
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public boolean b(RedTouchItem paramRedTouchItem)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (paramRedTouchItem != null)
    {
      bool1 = bool3;
      if (paramRedTouchItem.unReadFlag)
      {
        if (paramRedTouchItem.validTimeRemained >= 0) {
          break label54;
        }
        bool1 = true;
        if (paramRedTouchItem.redtouchType != 2) {
          return bool1;
        }
        if ((!bool1) || (paramRedTouchItem.count <= 0)) {
          break label129;
        }
      }
    }
    label129:
    for (bool1 = bool2;; bool1 = false)
    {
      return bool1;
      label54:
      if ((int)((System.currentTimeMillis() - paramRedTouchItem.receiveTime) / 1000L) >= paramRedTouchItem.validTimeRemained)
      {
        paramRedTouchItem.unReadFlag = false;
        RedPointConfig localRedPointConfig = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
        if (localRedPointConfig != null) {
          e(localRedPointConfig.redPointId);
        }
        c();
        bool1 = false;
        break;
      }
      bool1 = true;
      break;
    }
    return bool1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 1) {}
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointChanged redPointId:" + paramInt);
    }
    e(paramInt);
    c();
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      f();
      return false;
    }
    ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager
 * JD-Core Version:    0.7.0.1
 */