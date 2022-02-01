package com.tencent.mobileqq.nearby;

import android.util.Base64;
import com.tencent.biz.TroopRedpoint.TroopRedTouchConfigure;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.NearbyOfficalReportHelper;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.servlet.GameCenterServlet;
import com.tencent.mobileqq.statistics.ReportTask;
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
  private static NearbyNewRedDotManager jdField_a_of_type_ComTencentMobileqqNearbyNearbyNewRedDotManager = new NearbyNewRedDotManager();
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new NearbyNewRedDotManager.1(this);
  
  public static NearbyNewRedDotManager a()
  {
    return jdField_a_of_type_ComTencentMobileqqNearbyNearbyNewRedDotManager;
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
    if ((paramList == null) || (paramList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfo: numRedPaths is null.");
      }
      return;
    }
    ((NumRedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.NUMREDMSG_MANAGER)).a(paramList, "nearby_num_red_dot", new NearbyNewRedDotManager.2(this, paramQQAppInterface));
  }
  
  public List<Submsgtype0x89.NumRedBusiInfo> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = ((RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a(7719);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfo: numRedPaths is null.");
      }
      return null;
    }
    paramQQAppInterface = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject).next();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "queryNearbyMsgInfo:  numRedPath=" + localNumRedPath.str_path.get() + " msgStatus=" + localNumRedPath.uint32_msg_status.get());
      }
      if (localNumRedPath.uint32_msg_status.get() <= 1)
      {
        Submsgtype0x89.NumRedBusiInfo localNumRedBusiInfo = new Submsgtype0x89.NumRedBusiInfo();
        localNumRedBusiInfo.uint64_msgid.set(localNumRedPath.uint64_msgid.get());
        localNumRedBusiInfo.uint32_android_app_id.set(7719);
        localNumRedBusiInfo.str_android_path.set(localNumRedPath.str_path.get());
        paramQQAppInterface.add(localNumRedBusiInfo);
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
            QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "numRedPath = " + localNumRedPath.str_path.get() + "msg_id = " + localNumRedPath.uint64_msgid.get());
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
    Object localObject1 = null;
    long l1 = 0L;
    HashMap localHashMap1 = new HashMap();
    TroopRedTouchManager localTroopRedTouchManager = (TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
    HashMap localHashMap2 = new HashMap();
    Object localObject3 = paramList.iterator();
    paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
    while (((Iterator)localObject3).hasNext())
    {
      NumRedMsg.NumMsgBusi localNumMsgBusi = (NumRedMsg.NumMsgBusi)((Iterator)localObject3).next();
      i = localNumMsgBusi.ui_appid.get();
      long l2 = localNumMsgBusi.ui64_msgid.get();
      String str2 = localNumMsgBusi.str_path.get();
      localObject1 = localNumMsgBusi.str_ext.get();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: appid = " + i + ", path = " + str2 + ", content = " + (String)localObject1);
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0) && (str2 != null) && (str2.length() > 0)) {}
      try
      {
        Object localObject4 = Base64.decode(new JSONObject((String)localObject1).getString("_red_ext_0x69"), 0);
        localObject1 = new oidb_0x791.RedDotInfo();
        ((oidb_0x791.RedDotInfo)localObject1).mergeFrom((byte[])localObject4);
        localObject4 = (RedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
        if ((!str2.equals("7719.771901")) && (!str2.equals("7719.771903")) && (!str2.equals("7719.771904"))) {
          break label1155;
        }
        i = ((RedTouchManager)localObject4).a(str2, 0);
        i = ((RedTouchManager)localObject4).a(str2, 1) + i;
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          continue;
          continue;
          continue;
          i = 0;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: num = " + i);
      }
      ((oidb_0x791.RedDotInfo)localObject1).uint32_number.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: str_custom_buffer = " + ((oidb_0x791.RedDotInfo)localObject1).str_custom_buffer.get());
      }
      if ((((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() == 38) || (TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()))) {
        localHashMap1.put(Long.valueOf(l2), localObject1);
      }
      if ((((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 38) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 42) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 59) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 60) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 54) && (((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get() != 53) && (!TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()))) {
        break label1152;
      }
      if (localNumMsgBusi.ui64_msgid.get() <= l1) {
        break label1149;
      }
      l2 = localNumMsgBusi.ui64_msgid.get();
      l1 = l2;
      try
      {
        localHashMap2.put(Integer.valueOf(((oidb_0x791.RedDotInfo)localObject1).uint32_appid.get()), localObject1);
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
      }
      catch (Exception localException4)
      {
        try
        {
          NearbyOfficalReportHelper.a().a(paramQQAppInterface, (oidb_0x791.RedDotInfo)localObject1);
        }
        catch (Exception localException2)
        {
          Object localObject2;
          break label578;
        }
        localException4 = localException4;
        paramList = (List<NumRedMsg.NumMsgBusi>)localObject1;
        localObject1 = localException4;
      }
      label578:
      ((Exception)localObject1).printStackTrace();
    }
    localObject1 = localHashMap2.keySet().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      localObject3 = localTroopRedTouchManager.a(((Integer)localObject2).intValue());
      if ((localObject3 != null) && (TroopRedTouchConfigure.h(((oidb_0x791.RedDotInfo)localObject3).uint32_appid.get()))) {
        i = 1;
      }
      for (;;)
      {
        break;
        if ((localObject3 != null) && (((oidb_0x791.RedDotInfo)localObject3).uint32_number.get() == ((oidb_0x791.RedDotInfo)localHashMap2.get(localObject2)).uint32_number.get()))
        {
          QLog.d("NearbyNewRedDotManager", 2, "this appid not has new reddot: appid  = " + localObject2 + " num =  " + ((oidb_0x791.RedDotInfo)localHashMap2.get(localObject2)).uint32_number.get());
        }
        else
        {
          localTroopRedTouchManager.a((oidb_0x791.RedDotInfo)localHashMap2.get(localObject2));
          i = 1;
        }
      }
    }
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "parsePushRedPointInfo: unread num not change, just return");
      }
    }
    label945:
    do
    {
      for (;;)
      {
        return;
        localTroopRedTouchManager.a(true);
        try
        {
          localTroopRedTouchManager.a(localHashMap1);
          localObject2 = new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("nearby_push_red_tmp");
          if (paramList != null)
          {
            localObject1 = Integer.valueOf(paramList.uint32_appid.get());
            ((ReportTask)localObject2).a(new String[] { String.valueOf(localObject1) }).a();
            if (paramList != null) {
              break label945;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "setAllRedDotMsgInfo(): latestrRedDotInfo is null.");
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e("NearbyNewRedDotManagerQ.qqstory.redPoint", 2, "setAllRedDotMsgInfo exp: e = " + localException1.getMessage());
              continue;
              String str1 = "";
            }
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
        }
      }
    } while (paramList.uint32_appid.get() != 61);
    new ReportTask(paramQQAppInterface).a("dc00899").b("grp_lbs").c("entry").d("paried_exp_red").a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyNewRedDotManager
 * JD-Core Version:    0.7.0.1
 */