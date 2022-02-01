package com.tencent.mobileqq.nearby.api;

import android.util.Base64;
import com.tencent.biz.TroopRedpoint.TroopRedTouchConfigure;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.INearbyOfficalReportHelper;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class NearbyNewRedDotManager
{
  private static NearbyNewRedDotManager jdField_a_of_type_ComTencentMobileqqNearbyApiNearbyNewRedDotManager = new NearbyNewRedDotManager();
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new NearbyNewRedDotManager.1(this);
  
  public static NearbyNewRedDotManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqNearbyApiNearbyNewRedDotManager;
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), GameCenterServlet.class);
    localNewIntent.setAction("gc_refresh_ui");
    localNewIntent.putExtra("gc_notify_type", 6);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private void c(QQAppInterface paramQQAppInterface, List<Submsgtype0x89.NumRedBusiInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((NumRedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.NUMREDMSG_MANAGER)).a(paramList, "nearby_num_red_dot", new NearbyNewRedDotManager.2(this, paramQQAppInterface));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfo: numRedPaths is null.");
    }
  }
  
  public List<Submsgtype0x89.NumRedBusiInfo> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = ((IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "")).getNumRedPathListByAppId(7719);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfo: numRedPaths is null.");
      }
      return null;
    }
    paramQQAppInterface = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject1).next();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryNearbyMsgInfo:  numRedPath=");
        ((StringBuilder)localObject2).append(localNumRedPath.str_path.get());
        ((StringBuilder)localObject2).append(" msgStatus=");
        ((StringBuilder)localObject2).append(localNumRedPath.uint32_msg_status.get());
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, ((StringBuilder)localObject2).toString());
      }
      if (localNumRedPath.uint32_msg_status.get() <= 1)
      {
        localObject2 = new Submsgtype0x89.NumRedBusiInfo();
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint64_msgid.set(localNumRedPath.uint64_msgid.get());
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint32_android_app_id.set(7719);
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).str_android_path.set(localNumRedPath.str_path.get());
        paramQQAppInterface.add(localObject2);
      }
    }
    return paramQQAppInterface;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManager", 2, "init()");
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<BusinessInfoCheckUpdate.NumRedInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfos");
    }
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      paramList = paramList.iterator();
      Object localObject2;
      while (paramList.hasNext())
      {
        localObject2 = (BusinessInfoCheckUpdate.NumRedInfo)paramList.next();
        if ((((BusinessInfoCheckUpdate.NumRedInfo)localObject2).appid.get() == 7719) && (((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().size() > 0))
        {
          localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("numRedPath = ");
            localStringBuilder.append(localNumRedPath.str_path.get());
            localStringBuilder.append("msg_id = ");
            localStringBuilder.append(localNumRedPath.uint64_msgid.get());
            QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, localStringBuilder.toString());
            if (!((Map)localObject1).containsKey(Long.valueOf(localNumRedPath.uint64_msgid.get()))) {
              ((Map)localObject1).put(String.valueOf(localNumRedPath.uint64_msgid.get()), localNumRedPath);
            }
          }
        }
      }
      paramList = ((Map)localObject1).entrySet().iterator();
      while (paramList.hasNext())
      {
        localObject1 = (Map.Entry)paramList.next();
        localObject2 = new Submsgtype0x89.NumRedBusiInfo();
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint64_msgid.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).uint64_msgid.get());
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).uint32_android_app_id.set(7719);
        ((Submsgtype0x89.NumRedBusiInfo)localObject2).str_android_path.set(((BusinessInfoCheckUpdate.NumRedPath)((Map.Entry)localObject1).getValue()).str_path.get());
        localArrayList.add(localObject2);
      }
      ((NumRedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.NUMREDMSG_MANAGER)).a(localArrayList, "nearby_num_red_dot", new NearbyNewRedDotManager.3(this, paramQQAppInterface));
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyNewRedDotManager", 2, "onDestroy()");
    }
    paramQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
  }
  
  public void b(QQAppInterface paramQQAppInterface, List<NumRedMsg.NumMsgBusi> paramList)
  {
    HashMap localHashMap1 = new HashMap();
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    HashMap localHashMap2 = new HashMap();
    Object localObject5 = paramList.iterator();
    long l1 = 0L;
    paramList = null;
    NumRedMsg.NumMsgBusi localNumMsgBusi;
    int i;
    long l3;
    Object localObject3;
    Object localObject4;
    do
    {
      boolean bool = ((Iterator)localObject5).hasNext();
      localObject1 = "";
      if (!bool) {
        break;
      }
      localNumMsgBusi = (NumRedMsg.NumMsgBusi)((Iterator)localObject5).next();
      i = localNumMsgBusi.ui_appid.get();
      l3 = localNumMsgBusi.ui64_msgid.get();
      localObject3 = localNumMsgBusi.str_path.get();
      localObject4 = localNumMsgBusi.str_ext.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parsePushRedPointInfo: appid = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", path = ");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(", content = ");
        ((StringBuilder)localObject1).append((String)localObject4);
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, ((StringBuilder)localObject1).toString());
      }
    } while ((localObject4 == null) || (((String)localObject4).length() <= 0) || (localObject3 == null) || (((String)localObject3).length() <= 0));
    Object localObject1 = paramList;
    long l2 = l1;
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject6 = Base64.decode(new JSONObject((String)localObject4).getString("_red_ext_0x69"), 0);
        localObject1 = paramList;
        l2 = l1;
        localObject4 = new oidb_0x791.RedDotInfo();
        localObject1 = paramList;
        l2 = l1;
        ((oidb_0x791.RedDotInfo)localObject4).mergeFrom((byte[])localObject6);
        localObject1 = paramList;
        l2 = l1;
        localObject6 = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        localObject1 = paramList;
        l2 = l1;
        if (!((String)localObject3).equals("7719.771901"))
        {
          localObject1 = paramList;
          l2 = l1;
          if (!((String)localObject3).equals("7719.771903"))
          {
            localObject1 = paramList;
            l2 = l1;
            if (!((String)localObject3).equals("7719.771904")) {
              break label1470;
            }
          }
        }
        localObject1 = paramList;
        l2 = l1;
        i = ((IRedTouchManager)localObject6).getNumRedNumByPath((String)localObject3, 0) + ((IRedTouchManager)localObject6).getNumRedNumByPath((String)localObject3, 1);
        localObject1 = paramList;
        l2 = l1;
        if (QLog.isColorLevel())
        {
          localObject1 = paramList;
          l2 = l1;
          localObject3 = new StringBuilder();
          localObject1 = paramList;
          l2 = l1;
          ((StringBuilder)localObject3).append("parsePushRedPointInfo: num = ");
          localObject1 = paramList;
          l2 = l1;
          ((StringBuilder)localObject3).append(i);
          localObject1 = paramList;
          l2 = l1;
          QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = paramList;
        l2 = l1;
        ((oidb_0x791.RedDotInfo)localObject4).uint32_number.set(i);
        localObject1 = paramList;
        l2 = l1;
        if (QLog.isColorLevel())
        {
          localObject1 = paramList;
          l2 = l1;
          localObject3 = new StringBuilder();
          localObject1 = paramList;
          l2 = l1;
          ((StringBuilder)localObject3).append("parsePushRedPointInfo: str_custom_buffer = ");
          localObject1 = paramList;
          l2 = l1;
          ((StringBuilder)localObject3).append(((oidb_0x791.RedDotInfo)localObject4).str_custom_buffer.get());
          localObject1 = paramList;
          l2 = l1;
          QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = paramList;
        l2 = l1;
        if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 38)
        {
          localObject1 = paramList;
          l2 = l1;
          if (!TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get())) {}
        }
        else
        {
          localObject1 = paramList;
          l2 = l1;
          localHashMap1.put(Long.valueOf(l3), localObject4);
        }
        localObject1 = paramList;
        l2 = l1;
        if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 38)
        {
          localObject1 = paramList;
          l2 = l1;
          if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 42)
          {
            localObject1 = paramList;
            l2 = l1;
            if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 59)
            {
              localObject1 = paramList;
              l2 = l1;
              if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 60)
              {
                localObject1 = paramList;
                l2 = l1;
                if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 54)
                {
                  localObject1 = paramList;
                  l2 = l1;
                  if (((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get() != 53)
                  {
                    localObject1 = paramList;
                    l2 = l1;
                    if (!TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get())) {
                      break;
                    }
                  }
                }
              }
            }
          }
        }
        localObject3 = paramList;
        l3 = l1;
        localObject1 = paramList;
        l2 = l1;
        if (localNumMsgBusi.ui64_msgid.get() > l1)
        {
          localObject1 = paramList;
          l2 = l1;
          l1 = localNumMsgBusi.ui64_msgid.get();
          try
          {
            localHashMap2.put(Integer.valueOf(((oidb_0x791.RedDotInfo)localObject4).uint32_appid.get()), localObject4);
            localObject3 = localObject4;
            l3 = l1;
          }
          catch (Exception localException1)
          {
            paramList = (List<NumRedMsg.NumMsgBusi>)localObject4;
            continue;
          }
        }
        localObject2 = localObject3;
        l2 = l3;
        ((INearbyOfficalReportHelper)QRoute.api(INearbyOfficalReportHelper.class)).reportRedDotReceive(paramQQAppInterface, localObject4);
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject3;
        l1 = l3;
      }
      catch (Exception localException2)
      {
        l1 = l2;
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject2;
        localObject2 = localException2;
        ((Exception)localObject2).printStackTrace();
      }
      break;
      Iterator localIterator = localHashMap2.keySet().iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        localObject4 = (Integer)localIterator.next();
        localObject5 = localTroopRedTouchManager.a(((Integer)localObject4).intValue());
        if ((localObject5 == null) || (!TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject5).uint32_appid.get())))
        {
          if ((localObject5 != null) && (((oidb_0x791.RedDotInfo)localObject5).uint32_number.get() == ((oidb_0x791.RedDotInfo)localHashMap2.get(localObject4)).uint32_number.get()))
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("this appid not has new reddot: appid  = ");
            ((StringBuilder)localObject5).append(localObject4);
            ((StringBuilder)localObject5).append(" num =  ");
            ((StringBuilder)localObject5).append(((oidb_0x791.RedDotInfo)localHashMap2.get(localObject4)).uint32_number.get());
            QLog.d("NearbyNewRedDotManager", 2, ((StringBuilder)localObject5).toString());
          }
          else
          {
            localTroopRedTouchManager.a((oidb_0x791.RedDotInfo)localHashMap2.get(localObject4));
          }
        }
        else {
          i = 1;
        }
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: unread num not change, just return");
        }
        return;
      }
      localTroopRedTouchManager.a(true);
      try
      {
        localTroopRedTouchManager.a(localHashMap1);
      }
      catch (Exception localException3)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("setAllRedDotMsgInfo exp: e = ");
          ((StringBuilder)localObject4).append(localException3.getMessage());
          QLog.e("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, ((StringBuilder)localObject4).toString());
        }
      }
      ReportTask localReportTask = new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("nearby_push_red_tmp");
      if (paramList != null) {
        localObject2 = Integer.valueOf(paramList.uint32_appid.get());
      }
      localReportTask.a(new String[] { String.valueOf(localObject2) }).a();
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "setAllRedDotMsgInfo(): latestrRedDotInfo is null.");
        }
        return;
      }
      if (paramList.uint32_appid.get() == 59)
      {
        new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("like_exp_red").a();
        return;
      }
      if (paramList.uint32_appid.get() == 60)
      {
        if (paramList.uint64_cmd_uin.get() == 1822701914L)
        {
          new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("assist_exp_red").a();
          return;
        }
        new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("c2c_exp_red").a();
        return;
      }
      if (paramList.uint32_appid.get() == 61) {
        new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_exp_red").a();
      }
      return;
      label1470:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyNewRedDotManager
 * JD-Core Version:    0.7.0.1
 */