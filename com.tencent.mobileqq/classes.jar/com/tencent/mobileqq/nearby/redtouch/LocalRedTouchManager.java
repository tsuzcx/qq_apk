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
    RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    int i = 0;
    int k = 0;
    int j = 0;
    if (localRedTouchItem == null)
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      i = j;
      if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
        i = paramRedTouchItem.passThroughLevel - 1;
      }
      localRedTouchItem.passThroughLevel = i;
      this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
      return;
    }
    if (localRedTouchItem.unReadFlag)
    {
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
      if ((k == j) && (paramRedTouchItem.redtouchType == 2)) {
        localRedTouchItem.count += paramRedTouchItem.count;
      }
    }
    else
    {
      localRedTouchItem = new RedTouchItem();
      RedTouchUtil.a(localRedTouchItem, paramRedTouchItem);
      i = k;
      if (paramRedTouchItem.passThroughLevel - 1 >= 0) {
        i = paramRedTouchItem.passThroughLevel - 1;
      }
      localRedTouchItem.passThroughLevel = i;
      this.c.put(Integer.valueOf(paramInt), localRedTouchItem);
    }
  }
  
  private void a(RedTouchItem paramRedTouchItem, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int j = 1;
    if (bool) {
      QLog.d("LocalRedTouchManager", 2, String.format(Locale.getDefault(), "handleRedPoint item=%s saveToFile=%s", new Object[] { paramRedTouchItem, Boolean.valueOf(paramBoolean) }));
    }
    RedPointConfig localRedPointConfig1 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
    if (localRedPointConfig1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver.a(paramRedTouchItem, localRedPointConfig1.redPointId);
      RedTouchItem localRedTouchItem = a(localRedPointConfig1.redPointId);
      int i = j;
      if (localRedTouchItem != null)
      {
        RedPointConfig localRedPointConfig2 = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(localRedTouchItem.taskId));
        i = j;
        if (localRedPointConfig2 != null)
        {
          i = j;
          if (localRedPointConfig2.priority > localRedPointConfig1.priority)
          {
            i = j;
            if (localRedTouchItem.unReadFlag)
            {
              if (QLog.isColorLevel()) {
                QLog.i("LocalRedTouchManager", 2, "handleRedPoint, ignore lower priority");
              }
              i = 0;
            }
          }
        }
      }
      if (i == 0) {
        return;
      }
      if (this.b.containsKey(Integer.valueOf(localRedPointConfig1.redPointId)))
      {
        localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(localRedPointConfig1.redPointId));
        if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (localRedTouchItem.redtouchType == 2) && (paramRedTouchItem.redtouchType == 2)) {
          paramRedTouchItem.count += localRedTouchItem.count;
        }
        paramRedTouchItem.passThroughLevel = localRedPointConfig1.passThroughLevel;
        this.c.put(Integer.valueOf(localRedPointConfig1.redPointId), paramRedTouchItem);
        e(localRedPointConfig1.redPointId);
        if (paramBoolean) {
          c();
        }
      }
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
    long l = System.currentTimeMillis();
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
      int i = (int)((l - paramRedTouchItem.receiveTime) / 1000L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isOutOfDate,remain:");
        localStringBuilder.append(paramRedTouchItem.validTimeRemained);
        localStringBuilder.append(" consume:");
        localStringBuilder.append(i);
        QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
      }
      if (i >= paramRedTouchItem.validTimeRemained)
      {
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
      return false;
    }
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode = new RedPointNode();
    RedPointNode localRedPointNode1 = this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode;
    localRedPointNode1.jdField_a_of_type_Int = -1;
    this.b.put(Integer.valueOf(localRedPointNode1.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode);
    localRedPointNode1 = new RedPointNode();
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
    ??? = new StringBuilder();
    ((StringBuilder)???).append("red_point_configs_");
    ((StringBuilder)???).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ??? = (ConcurrentHashMap)FileUtils.readObject(((StringBuilder)???).toString());
    if (??? != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll((Map)???);
    }
    ??? = null;
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("red_point_info_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = (ConcurrentHashMap)FileUtils.readObject(((StringBuilder)localObject2).toString());
      ??? = localObject2;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("LocalRedTouchManager", 1, localThrowable.getMessage(), localThrowable);
    }
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
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateParents:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (RedTouchItem)this.c.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((RedTouchItem)localObject).passThroughLevel > 0))
    {
      int i = paramInt;
      paramInt = 0;
      while (paramInt < ((RedTouchItem)localObject).passThroughLevel)
      {
        RedPointNode localRedPointNode = (RedPointNode)this.b.get(Integer.valueOf(i));
        if ((localRedPointNode == null) || (localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode == null)) {
          break;
        }
        RedTouchItem localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int));
        if (localRedTouchItem != null) {
          localRedTouchItem.unReadFlag = false;
        }
        if (localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList != null)
        {
          i = 0;
          while (i < localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList.size())
          {
            int j = ((RedPointNode)localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int;
            localRedTouchItem = (RedTouchItem)this.c.get(Integer.valueOf(j));
            if ((localRedTouchItem != null) && (localRedTouchItem.unReadFlag) && (!localRedTouchItem.isClosed) && (localRedTouchItem.passThroughLevel > 0)) {
              a(localRedTouchItem, localRedPointNode.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointNode.jdField_a_of_type_Int);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("red_point_info_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    FileUtils.writeObject(localStringBuilder.toString(), this.c);
  }
  
  private void g()
  {
    if (!a()) {
      e();
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.putAll(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap);
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
        ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a(localArrayList, false);
        long l = SystemClock.elapsedRealtime();
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_red_touch_time2", Long.valueOf(l));
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("LocalRedTouchManager", 2, "pull config on null");
      }
      ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
    }
  }
  
  public int a()
  {
    Object localObject = a(10016);
    RedTouchItem localRedTouchItem = a(10015);
    int i = 3;
    if ((localObject != null) && (localRedTouchItem != null)) {
      if (((RedTouchItem)localObject).curSeq <= localRedTouchItem.curSeq) {
        break label58;
      }
    } else {
      if (localObject == null) {
        break label53;
      }
    }
    i = 4;
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
      i = 1;
    }
    label68:
    if ((localObject != null) && (((RedTouchItem)localObject).bytes != null) && (((RedTouchItem)localObject).bytes.length > 0)) {
      try
      {
        int j = new JSONObject(new String(((RedTouchItem)localObject).bytes, "utf-8")).optInt("type", 1);
        return j;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LocalRedTouchManager", 2, localException, new Object[0]);
        }
      }
    }
    return i;
  }
  
  public RedTouchItem a(int paramInt)
  {
    Object localObject = this.c;
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
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = ((String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", ""));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedPointConfigVersion, version = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
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
    Object localObject1 = this.c;
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
      e(paramInt);
      c();
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      if (paramBoolean3)
      {
        localObject1 = new cmd0x6ce.ReadRedpointReq();
        ((cmd0x6ce.ReadRedpointReq)localObject1).uint32_appid.set(paramInt);
        if (paramBoolean1) {
          ((cmd0x6ce.ReadRedpointReq)localObject1).uint64_read_seq.set(paramLong);
        }
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localObject1);
        ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a((List)localObject2);
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
      this.jdField_a_of_type_JavaLangString = paramString;
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "red_point_config_version", paramString);
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
      this.jdField_a_of_type_JavaUtilVector.addAll(paramList);
      if (!paramBoolean)
      {
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
    }
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(localConcurrentHashMap);
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
      paramRspBody.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    long l1 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "pull_red_touch_time2", Long.valueOf(0L))).longValue();
    long l2 = SystemClock.elapsedRealtime();
    if ((paramShort > 0) || (l2 - l1 > 43200000L)) {
      b();
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
    a(100601);
    if (paramBoolean)
    {
      b(10016);
      b(10015);
    }
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
    if (localObject == null) {
      return;
    }
    ((IRedTouchManager)localObject).dismissRedTouch("100510");
    ((IRedTouchManager)localObject).dismissRedTouch("100460");
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
      RedPointConfig localRedPointConfig = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramArrayOfByte.taskId));
      int i;
      if (localRedPointConfig == null) {
        i = 0;
      } else {
        i = localRedPointConfig.redPointId;
      }
      QLog.i("LocalRedTouchManager", 2, String.format("onLinePush item:%s appid=%d version=%s", new Object[] { paramArrayOfByte, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString }));
    }
    if (localRedpointInfo.str_config_version.get().equals(this.jdField_a_of_type_JavaLangString))
    {
      a(paramArrayOfByte, true);
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedPointPrePostHandleObserver.a(Collections.singletonList(paramArrayOfByte));
      return;
    }
    this.jdField_a_of_type_JavaUtilVector.add(paramArrayOfByte);
    ((RedtouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REDTOUCH_HANDLER)).a();
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
    ThreadManager.excute(new LocalRedTouchManager.1(this), 64, null, true);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearParentsButSelf, redPointId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LocalRedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
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
      e(paramInt);
      ((RedTouchItem)localObject).passThroughLevel = 0;
      ((RedTouchItem)localObject).unReadFlag = true;
      c();
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(1)) {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    }
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
        RedPointConfig localRedPointConfig = (RedPointConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramRedTouchItem.taskId));
        if (localRedPointConfig != null) {
          e(localRedPointConfig.redPointId);
        }
        c();
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRedPointChanged redPointId:");
      localStringBuilder.append(paramInt);
      QLog.i("LocalRedTouchManager", 2, localStringBuilder.toString());
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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return false;
    }
    f();
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager
 * JD-Core Version:    0.7.0.1
 */