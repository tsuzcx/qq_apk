package com.tencent.mobileqq.nearby.redtouch;

import afqb;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
  public static Map a;
  @Deprecated
  public static final int[] a;
  afqb jdField_a_of_type_Afqb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RedPointNode jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getFileThreadLooper(), this);
  boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap b = new ConcurrentHashMap();
  private ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(5);
    jdField_a_of_type_ArrayOfInt = new int[] { 10001 };
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10001), Integer.valueOf(100460));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10005), Integer.valueOf(100601));
  }
  
  public LocalRedTouchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Afqb = new DefaultRedPointPreHandler(paramQQAppInterface);
    e();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    }
    return 3;
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
      QLog.i("LocalRedTouchManager", 2, "handleRedPoint, taskId=" + paramRedTouchItem.taskId + ", saveToFile=" + paramBoolean);
    }
    if ((QLog.isColorLevel()) && (paramRedTouchItem != null)) {
      QLog.d("LocalRedTouchManager", 2, "handleRedPoint, item.taskId=" + paramRedTouchItem.taskId + "seq=" + paramRedTouchItem.curSeq + ", count=" + paramRedTouchItem.count);
    }
    RedPointConfig localRedPointConfig1;
    RedTouchItem localRedTouchItem;
    int i;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramRedTouchItem.taskId)))
    {
      localRedPointConfig1 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
      this.jdField_a_of_type_Afqb.a(paramRedTouchItem, localRedPointConfig1.redPointId);
      localRedTouchItem = a(localRedPointConfig1.redPointId);
      if (localRedTouchItem == null) {
        break label244;
      }
      RedPointConfig localRedPointConfig2 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localRedTouchItem.taskId));
      if ((localRedPointConfig2 == null) || (localRedPointConfig2.priority <= localRedPointConfig1.priority) || (!localRedTouchItem.unReadFlag)) {
        break label239;
      }
      if (!QLog.isColorLevel()) {
        break label401;
      }
      QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {}
      label239:
      label244:
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
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
      label401:
      i = 0;
    }
  }
  
  private void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject2 = null;
    Object localObject3 = paramList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = localObject2;
      if (((RedTouchItem)((Iterator)localObject3).next()).taskId == 10005) {
        localObject1 = "0X800761B";
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        localObject2 = localObject1;
      }
    }
    localObject3 = a(10015);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (paramList.contains(localObject3))
      {
        localObject1 = "0X8007391";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007391", "0X8007391", 0, 0, "", "", "", "");
        ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).b();
      }
    }
    localObject2 = a(10016);
    if ((localObject2 != null) && (paramList.contains(localObject2)) && (((RedTouchItem)localObject2).bytes != null) && (((RedTouchItem)localObject2).bytes.length > 0)) {}
    for (;;)
    {
      try
      {
        int i = new JSONObject(new String(((RedTouchItem)localObject2).bytes, "utf-8")).optInt("type", 1);
        switch (i)
        {
        default: 
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("LocalRedTouchManager", 2, localException, new Object[0]);
        localObject2 = localObject1;
        continue;
        paramList.a((RedTouchItem)localObject1);
      }
      if (localObject2 != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localObject1 = a(10018);
      if ((localObject1 == null) || (!paramList.contains(localObject1)) || (((RedTouchItem)localObject1).extMsgs == null) || (((RedTouchItem)localObject1).extMsgs.size() <= 0) || (!((RedTouchItem)localObject1).unReadFlag)) {
        break;
      }
      paramList = (ConfessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(268);
      localObject2 = paramList.a();
      if ((localObject2 != null) && (((ConfessConfig)localObject2).b())) {
        continue;
      }
      ((RedTouchItem)localObject1).unReadFlag = false;
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("LocalRedTouchManager", 2, "onPostDealReachedRedPoints frdRecMsgSwitch is off");
      return;
      localObject2 = "0X8007396";
      continue;
      localObject2 = "0X80073B5";
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
  
  private boolean b(RedTouchItem paramRedTouchItem)
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
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramRedTouchItem.taskId))) {
        e(((RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId))).redPointId);
      }
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
    return true;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = new RedPointNode();
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int = -1;
    this.b.put(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode);
    RedPointNode localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 10018;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    RedPointNode localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = -3;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = 100500;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode1);
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList = Collections.singletonList(localRedPointNode1);
    localRedPointNode1.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10015;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10016;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10012;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 100601;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    this.b.put(Integer.valueOf(100601), localObject1);
    localRedPointNode1 = new RedPointNode();
    localRedPointNode1.jdField_a_of_type_Int = -2;
    localRedPointNode1.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), localRedPointNode2);
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList = Arrays.asList(new RedPointNode[] { localRedPointNode2, localRedPointNode1 });
    localRedPointNode1.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 100510;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = 10011;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = ((RedPointNode)localObject1);
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    Object localObject2 = new ArrayList();
    ((List)localObject2).add(localRedPointNode2);
    ((RedPointNode)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    localObject1 = new ArrayList();
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 100523;
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((List)localObject1).add(localObject2);
    localObject2 = new RedPointNode();
    ((RedPointNode)localObject2).jdField_a_of_type_Int = 100517;
    ((RedPointNode)localObject2).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject2).jdField_a_of_type_Int), localObject2);
    ((List)localObject1).add(localObject2);
    localRedPointNode2.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = -5;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localRedPointNode2);
    localRedPointNode2.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10017;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localObject1);
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 103421;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = -4;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localRedPointNode2);
    localRedPointNode2.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
    localObject1 = new RedPointNode();
    ((RedPointNode)localObject1).jdField_a_of_type_Int = 10014;
    ((RedPointNode)localObject1).jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode2;
    localRedPointNode2.jdField_a_of_type_JavaUtilList.add(localObject1);
    this.b.put(Integer.valueOf(((RedPointNode)localObject1).jdField_a_of_type_Int), localObject1);
    localRedPointNode2 = new RedPointNode();
    localRedPointNode2.jdField_a_of_type_Int = 10013;
    localRedPointNode2.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = localRedPointNode1;
    localRedPointNode1.jdField_a_of_type_JavaUtilList.add(localRedPointNode2);
    this.b.put(Integer.valueOf(localRedPointNode2.jdField_a_of_type_Int), localRedPointNode2);
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = ((ConcurrentHashMap)FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    this.c = ((ConcurrentHashMap)FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (this.c == null) {
      this.c = new ConcurrentHashMap();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(0);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  private void g()
  {
    FileUtils.a("red_point_info_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.c);
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
    QLog.d("LocalRedTouchManager", 2, "getRedPointInfo: " + localRedTouchItem.toString());
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
      g();
      a(this.jdField_a_of_type_JavaUtilVector);
      this.jdField_a_of_type_JavaUtilVector.clear();
      c();
      RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false, 0L, false);
  }
  
  public void a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointClick, redPointId=" + paramInt + ", useCustom=" + paramBoolean1 + ", customSeq=" + paramLong + ", customReadFlag=" + paramBoolean2);
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
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(2)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      localObject = new cmd0x6ce.ReadRedpointReq();
      ((cmd0x6ce.ReadRedpointReq)localObject).uint32_appid.set(paramInt);
      if (paramBoolean1) {
        ((cmd0x6ce.ReadRedpointReq)localObject).uint64_read_seq.set(paramLong);
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a(localArrayList);
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
  
  public void a(List paramList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetRedPointInfo, list size=");
      if (paramList == null)
      {
        localObject = "null";
        QLog.i("LocalRedTouchManager", 2, localObject + ", hasMore=" + paramBoolean);
      }
    }
    else
    {
      if ((paramList != null) && (paramList.size() != 0)) {
        break label84;
      }
    }
    label84:
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
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).b();
  }
  
  public void a(cmd0x6f5.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramRspBody != null) && (paramRspBody.rpt_task_info != null) && (paramRspBody.rpt_task_info.has()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localRedPointConfig.taskId), localRedPointConfig);
        if (QLog.isColorLevel()) {
          localStringBuilder.append("\n").append(localRedPointConfig.toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "saveRedPointConfigs, config size = " + paramRspBody.size() + " " + localStringBuilder.toString());
      }
      FileUtils.a("red_point_configs_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
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
      a(10012);
      b(10016);
      b(10015);
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    if (localRedTouchManager == null) {
      return;
    }
    localRedTouchManager.c("100510");
    localRedTouchManager.c("100460");
    a(100510);
    a(100500);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onLinePush");
    }
    if (!a()) {
      f();
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
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "onLinePush, taskId=" + paramArrayOfByte.taskId);
      }
      if (localRedpointInfo.str_config_version.get().equals(this.jdField_a_of_type_JavaLangString))
      {
        a(paramArrayOfByte, true);
        if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramArrayOfByte.taskId))) {
          c();
        }
        RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a(Collections.singletonList(paramArrayOfByte));
        return;
      }
      this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).b();
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    return a(a(paramInt), paramBoolean);
  }
  
  public boolean a(RedTouchItem paramRedTouchItem)
  {
    return (paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!b(paramRedTouchItem));
  }
  
  public boolean a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    if ((paramRedTouchItem != null) && (paramRedTouchItem.unReadFlag) && (!paramRedTouchItem.isClosed))
    {
      if (paramBoolean) {}
      while (!b(paramRedTouchItem)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (!a()) {
      f();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0))
    {
      QLog.d("LocalRedTouchManager", 1, "pullRedPointInfo using config");
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        RedTouchItem localRedTouchItem = a(((RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localInteger)).redPointId);
        cmd0x6cd.PullRedpointReq localPullRedpointReq = new cmd0x6cd.PullRedpointReq();
        localPullRedpointReq.uint32_taskid.set(localInteger.intValue());
        if (localRedTouchItem != null) {
          localPullRedpointReq.uint64_last_pull_seq.set(localRedTouchItem.curSeq);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "pullRedPointInfo. addPull, taskId=:" + localInteger + ", seq=" + localPullRedpointReq.uint64_last_pull_seq.get());
          }
          localArrayList.add(localPullRedpointReq);
          break;
          localPullRedpointReq.uint64_last_pull_seq.set(0L);
        }
      }
      if (localArrayList.size() > 0)
      {
        ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).a(localArrayList, false);
        long l = SystemClock.elapsedRealtime();
        NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_red_touch_time2", Long.valueOf(l));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "pull config on null");
    }
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(91)).b();
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
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "buildAppinfos");
    }
    if (!a()) {
      f();
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    Object localObject1;
    Object localObject2;
    int i;
    RedTouchItem localRedTouchItem;
    boolean bool3;
    label193:
    int j;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localObject2 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((Map.Entry)localObject1).getKey());
      if (localObject2 != null)
      {
        if (((Integer)((Map.Entry)localObject1).getKey()).intValue() == 10001) {}
        for (i = 100460;; i = ((Integer)((Map.Entry)localObject1).getValue()).intValue())
        {
          localRedTouchItem = a(((RedPointConfig)localObject2).redPointId);
          bool3 = a(localRedTouchItem, false);
          if ((localRedTouchItem != null) && (bool3)) {
            break label193;
          }
          ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35)).d(i + "");
          break;
        }
        j = RedTouchUtil.a(localRedTouchItem.redtouchType);
        localObject1 = "";
        localObject2 = localObject1;
        if (!bool3) {
          break label450;
        }
        switch (j)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          bool1 = true;
          label258:
          if (QLog.isColorLevel()) {
            QLog.i("LocalRedTouchManager", 2, "buildAppinfos, id:" + localRedTouchItem.taskId + " type:" + j + " content:" + (String)localObject1);
          }
          localObject2 = localObject1;
          if (!bool1) {
            break label450;
          }
        }
      }
    }
    for (boolean bool1 = false;; bool1 = bool3)
    {
      RedTouchUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, i, String.valueOf(i), (String)localObject1, true, "", a(localRedTouchItem.taskId), bool1);
      break;
      if (localRedTouchItem.count <= 0) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        if (bool2) {
          break;
        }
        localObject1 = localRedTouchItem.count + "";
        bool1 = bool2;
        break;
      }
      bool2 = TextUtils.isEmpty(localRedTouchItem.tips);
      bool1 = bool2;
      if (bool2) {
        break label258;
      }
      localObject1 = localRedTouchItem.tips;
      bool1 = bool2;
      break label258;
      bool1 = false;
      break label258;
      return;
      label450:
      localObject1 = localObject2;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onResumeOrPause:" + paramInt);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(0, 500L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LocalRedTouchManager", 2, "onRedPointChanged redPointId:" + paramInt);
    }
    e(paramInt);
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(2)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
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
      c();
      return false;
    case 1: 
      g();
      return false;
    }
    RedpointHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(0)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager
 * JD-Core Version:    0.7.0.1
 */