package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class RedTouchManager
  extends Observable
  implements Manager
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  public int a;
  protected long a;
  protected AppInterface a;
  private RedTouchLifeTimeManager jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager;
  private BusinessInfoCheckUpdate.TimeRspBody jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody;
  protected String a;
  public boolean a;
  public int b;
  private volatile long jdField_b_of_type_Long;
  
  public RedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager = RedTouchLifeTimeManager.a();
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      a("input path is empty");
    }
    do
    {
      return -1;
      if (!paramString.contains(".")) {
        break;
      }
      paramString = paramString.split("\\.");
    } while ((paramString == null) || (paramString.length <= 0));
    int i;
    try
    {
      i = Integer.parseInt(paramString[(paramString.length - 1)]);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      return -1;
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private BusinessInfoCheckUpdate.NumRedInfo a(int paramInt)
  {
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        Object localObject1 = a();
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.has()))
        {
          localObject1 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgNumRedInfo.get();
          if (localObject1 == null)
          {
            a("getNumRedShowNumByAppSet : numRedBusiList is null");
            return null;
          }
          Iterator localIterator = ((List)localObject1).iterator();
          if (localIterator.hasNext())
          {
            localObject1 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator.next();
            if (paramInt != ((BusinessInfoCheckUpdate.NumRedInfo)localObject1).appid.get()) {
              continue;
            }
            if (localObject1 == null)
            {
              a("getNumRedBusiInfoByAppId : cannot find the info by appid");
              return null;
            }
            return localObject1;
          }
        }
      }
      Object localObject3 = null;
    }
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramString);
  }
  
  public static String a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = AIOUtils.a().append(paramAppInfo.path.get()).append(":");
    paramAppInfo = RedTouchTextView.a(paramAppInfo);
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.iterator();
      while (paramAppInfo.hasNext()) {
        localStringBuilder.append(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next()).red_type.get()).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private List<String> a(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    if (paramList3.size() < 1) {
      localObject = paramList1;
    }
    int i;
    do
    {
      return localObject;
      i = 0;
      localObject = paramList2;
    } while (i >= paramList1.size());
    Object localObject = (String)paramList1.get(i);
    if (!paramList4.contains(localObject))
    {
      paramList2.add(localObject);
      return paramList2;
    }
    int j = 0;
    label72:
    if (j < paramList3.size()) {
      if (!((String)localObject).equals((String)paramList3.get(j))) {}
    }
    for (j = 1;; j = 0)
    {
      if (j != 0) {
        paramList2.add(localObject);
      }
      i += 1;
      break;
      j += 1;
      break label72;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label221;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null)
        {
          a("getNumFromFileByPathAndType : numRedBusiList is null");
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next();
          if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
            continue;
          }
          localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
          if (localObject4 == null) {
            continue;
          }
          j = 0;
          if (j < ((List)localObject4).size())
          {
            if (((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint64_msgid.get() != paramInt2) {
              break label212;
            }
            ((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint32_msg_status.set(paramInt3);
            i = 1;
            break label209;
          }
        }
        else
        {
          if (j != 0) {
            b(localTimeRspBody);
          }
          return;
        }
      }
      label209:
      continue;
      label212:
      j += 1;
      continue;
      label221:
      int j = 0;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramInt == 6) {
      MobileReportManager.getInstance().reportRedpoint(paramAppInfo, 102);
    }
    while (paramInt != 1) {
      return;
    }
    MobileReportManager.getInstance().reportRedpoint(paramAppInfo, 101);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      localObject2 = a(paramAppInfo.uiAppId.get());
      if (localObject2 == null) {
        return;
      }
      localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      if (localObject3 == null)
      {
        a("onReportShowMsgs : NumRedPaths is null");
        return;
      }
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
      ((List)localObject2).add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
      if (paramBoolean) {
        a(paramAppInfo.uiAppId.get(), (int)localNumRedPath.uint64_msgid.get(), paramInt2);
      }
    }
    a(paramAppInfo, paramInt1, false, null, (List)localObject2, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, String paramString1, boolean paramBoolean, List<Long> paramList, List<String> paramList1, String paramString2)
  {
    QLog.i("RedPointLog.RedTouchManager", 1, String.format("onReportSync id = %s type = %d", new Object[] { paramAppInfo.path.get(), Integer.valueOf(paramInt) }));
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.5.5.5105");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo.extend.has()) {
      localReportReqBody.extend.set(paramAppInfo.extend.get());
    }
    if (paramList != null) {
      localReportReqBody.msgids.set(paramList);
    }
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).mIsShowNewLeba) {
        localReportReqBody.bHebaFlag.set(true);
      }
    }
    else if (paramBoolean)
    {
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break label501;
      }
      localReportReqBody.missionid.set(paramList1);
    }
    for (;;)
    {
      paramList = new ArrayList();
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramList1 = new JSONObject(paramString2);
          if (paramList1 != null)
          {
            paramString2 = paramList1.keys();
            while (paramString2.hasNext())
            {
              String str = (String)paramString2.next();
              BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
              localReportStaticsData.key.set(str);
              localReportStaticsData.value.set(paramList1.getString(str));
              paramList.add(localReportStaticsData);
            }
          }
        }
        localReportReqBody.bHebaFlag.set(false);
      }
      catch (JSONException paramList1)
      {
        QLog.e("RedPointLog.RedTouchManager", 2, "onReportSync parse json exception ", paramList1);
        paramList1 = new BusinessInfoCheckUpdate.ReportStaticsData();
        paramList1.key.set("qimei");
        paramList1.value.set(String.valueOf(UserAction.getQIMEI()));
        paramList.add(paramList1);
        if (!TextUtils.isEmpty(paramString1)) {
          localReportReqBody.buffer.set(paramString1);
        }
        localReportReqBody.reportdata.set(paramList);
        paramString1 = a("RedTouchSvc.ClientReport");
        paramString1.putWupBuffer(localReportReqBody.toByteArray());
        a(paramString1);
        a(paramAppInfo, paramInt);
        if ((paramInt == 6) || (paramInt == 31)) {
          TianShuManager.setLastClickAdTraceInfo(RedTouchUtils.a(paramAppInfo), paramAppInfo.extend.get());
        }
        return;
      }
      break;
      label501:
      if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, null, paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString)
  {
    a(paramAppInfo, paramInt, paramBoolean, paramList, paramList1, paramString, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List<String> paramList, List<Long> paramList1, String paramString1, String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new RedTouchManager.5(this, paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1), 2, null, true);
      return;
    }
    a(paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "onRedTouchItemClick path = " + paramString1);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (paramAppInfo.iNewFlag.get() == 1) {
      localSharedPreferences.edit().putString("lastClickPath", paramString1).commit();
    }
    for (;;)
    {
      if (!paramString1.contains("."))
      {
        this.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      e(paramAppInfo, paramString2);
      a(paramString1, false);
      setChanged();
      if (i != 0) {
        ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      return;
      localSharedPreferences.edit().putString("lastClickPath", "").commit();
      i = 0;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody1, BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody2)
  {
    HashMap localHashMap = new HashMap();
    paramTimeRspBody1 = paramTimeRspBody1.rptMsgNumRedInfo.get().iterator();
    Object localObject1;
    Iterator localIterator1;
    Object localObject2;
    while (paramTimeRspBody1.hasNext())
    {
      localObject1 = (BusinessInfoCheckUpdate.NumRedInfo)paramTimeRspBody1.next();
      localIterator1 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject1).num_red_path.get().iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (BusinessInfoCheckUpdate.NumRedPath)localIterator1.next();
        if ((((BusinessInfoCheckUpdate.NumRedPath)localObject2).push_to.get() == 109) || (((BusinessInfoCheckUpdate.NumRedPath)localObject2).push_to.get() == 109110)) {
          localHashMap.put(localObject2, localObject1);
        }
      }
    }
    if (paramTimeRspBody2 != null)
    {
      paramTimeRspBody1 = localHashMap.keySet().iterator();
      if (paramTimeRspBody1.hasNext())
      {
        localObject1 = (BusinessInfoCheckUpdate.NumRedPath)paramTimeRspBody1.next();
        localIterator1 = paramTimeRspBody2.rptMsgNumRedInfo.get().iterator();
        int k;
        for (int i = 0;; i = k)
        {
          int j = i;
          if (localIterator1.hasNext())
          {
            localObject2 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator1.next();
            k = i;
            if (localHashMap.get(localObject1) != null)
            {
              k = i;
              if (((BusinessInfoCheckUpdate.NumRedInfo)localObject2).appid.get() == ((BusinessInfoCheckUpdate.NumRedInfo)localHashMap.get(localObject1)).appid.get())
              {
                Iterator localIterator2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get().iterator();
                BusinessInfoCheckUpdate.NumRedPath localNumRedPath;
                do
                {
                  j = i;
                  if (!localIterator2.hasNext()) {
                    break;
                  }
                  localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)localIterator2.next();
                } while (localNumRedPath.uint64_msgid.get() != ((BusinessInfoCheckUpdate.NumRedPath)localObject1).uint64_msgid.get());
                localNumRedPath.set((MessageMicro)localObject1);
                j = 1;
                k = j;
                if (j == 0)
                {
                  ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.add((MessageMicro)localObject1);
                  j = 1;
                }
              }
            }
          }
          else
          {
            if (j != 0) {
              break;
            }
            paramTimeRspBody2.rptMsgNumRedInfo.add((MessageMicro)localHashMap.get(localObject1));
            break;
          }
        }
      }
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg == null) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      return;
    }
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).sendToService(paramToServiceMsg);
  }
  
  public static void a(String paramString)
  {
    QLog.d("RedPointLog.RedTouchManager", 1, paramString);
  }
  
  private void a(String paramString, List<String> paramList1, List<String> paramList2)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString != null)
          {
            Iterator localIterator = paramString.keys();
            if (localIterator.hasNext())
            {
              new JSONObject();
              String str = (String)localIterator.next();
              JSONObject localJSONObject = paramString.getJSONObject(str);
              if (!localJSONObject.has("stat")) {
                break label141;
              }
              i = localJSONObject.getInt("stat");
              paramList2.add(str);
              if (i != 1) {
                continue;
              }
              paramList1.add(str);
              continue;
            }
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      paramString = null;
      continue;
      label141:
      int i = -1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "setNewStatusByID,path = " + paramString);
    }
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointLog.RedTouchManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            Object localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get())) {
              break label254;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag;
            if (paramBoolean) {
              j = 1;
            }
            localPBInt32Field.set(j);
            localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject);
            localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (localObject != null) {
              ((GameCenterManagerImp)localObject).a(paramString);
            }
          }
        }
        b(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointLog.RedTouchManager", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label254:
      i += 1;
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("redTouchPref", 4);
    } while (paramContext == null);
    paramContext.edit().putBoolean("isCacheChange", paramBoolean).apply();
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    a("handler after push");
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localQQAppInterface = null)
    {
      if (localQQAppInterface == null) {
        return;
      }
      for (;;)
      {
        try
        {
          BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
          localTimeRspBody.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = a();
          b(localTimeRspBody, paramArrayOfByte);
          a(localTimeRspBody, paramArrayOfByte);
          int j;
          if ((localTimeRspBody.rptMsgAppInfo.get() == null) || (localTimeRspBody.rptMsgAppInfo.get().size() <= 0))
          {
            if (localTimeRspBody.rptMsgNumRedInfo.get() != null)
            {
              i = localTimeRspBody.rptMsgNumRedInfo.get().size();
              if (i <= 0) {}
            }
          }
          else
          {
            i = 1;
            j = i;
            if (paramArrayOfByte == null) {}
          }
          int i = 0;
        }
        catch (Exception paramArrayOfByte)
        {
          try
          {
            b(paramArrayOfByte);
            j = i;
            if (j == 0) {
              continue;
            }
            QLog.d("RedPointLog.RedTouchManager", 1, "has push data ");
            ((IRedTouchServer)localQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(localQQAppInterface);
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            continue;
          }
          paramArrayOfByte = paramArrayOfByte;
          i = 0;
          QLog.e("RedPointLog.RedTouchManager", 1, "TimeRspBody handle push exception " + paramArrayOfByte);
          j = i;
          continue;
          if (BaseActivity.mAppForground)
          {
            ((IRedTouchServer)localQQAppInterface.getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, true, paramInt);
            return;
          }
          paramArrayOfByte = localQQAppInterface.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
          paramArrayOfByte.putBoolean("redtouch_force", true);
          paramArrayOfByte.apply();
          return;
        }
      }
    }
  }
  
  private boolean a(int paramInt, List<BusinessInfoCheckUpdate.AppSetting> paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((999999 == paramAppInfo.uiAppId.get()) || (paramAppInfo.path.get().contains(".")))
    {
      bool1 = true;
      return bool1;
    }
    if (paramAppInfo.iNewFlag.get() != 1) {
      return true;
    }
    if (((paramInt == 0) || (paramInt == 1) || (paramInt == 11) || (paramInt == 10)) && (paramAppInfo.exposure_max.get() <= 0)) {
      return true;
    }
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= paramList.size()) || (paramAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)paramList.get(paramInt)).appid.get()))
      {
        bool1 = bool2;
        if (paramInt >= paramList.size()) {
          break;
        }
        bool1 = bool2;
        if (((BusinessInfoCheckUpdate.AppSetting)paramList.get(paramInt)).setting.get()) {
          break;
        }
        return true;
      }
      paramInt += 1;
    }
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {}
    while ((paramNumRedBusiInfo.uint32_plat_id.get() != 109) && (paramNumRedBusiInfo.uint32_plat_id.get() != 109110)) {
      return false;
    }
    return true;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j = 0;
    label226:
    label232:
    label237:
    label243:
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        Object localObject2 = a();
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              a("getNumFromFileByPathAndType : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label243;
            }
            Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1) {
              continue;
            }
            localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
            if (localObject4 == null) {
              continue;
            }
            localObject4 = ((List)localObject4).iterator();
            j = i;
            i = j;
            if (!((Iterator)localObject4).hasNext()) {
              continue;
            }
            BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject4).next();
            if (100 == paramInt2)
            {
              if (localNumRedPath.uint32_msg_status.get() == 0) {
                break label232;
              }
              if (1 != localNumRedPath.uint32_msg_status.get()) {
                break label226;
              }
              break label232;
            }
            if (localNumRedPath.uint32_msg_status.get() != paramInt2) {
              break label226;
            }
            i = j + 1;
            break label237;
          }
        }
        return i;
      }
      int i = j;
      break label237;
      i = j + 1;
      j = i;
    }
  }
  
  private int b(String paramString, int paramInt)
  {
    int j = 0;
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (TextUtils.isEmpty(paramString)) {
        return 0;
      }
      localObject2 = a();
      i = j;
      if (localObject2 == null) {
        break label230;
      }
      i = j;
      if (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has()) {
        break label230;
      }
      localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
      if (localObject2 == null)
      {
        a("getNumFromFileByPathAndType : numRedBusiList is null");
        return 0;
      }
    }
    Object localObject2 = ((List)localObject2).iterator();
    int i = 0;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next()).num_red_path.get();
        if (localObject3 != null)
        {
          localObject3 = ((List)localObject3).iterator();
          j = i;
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath;
          do
          {
            i = j;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
          } while (!localNumRedPath.str_path.get().equals(paramString));
          if (100 == paramInt)
          {
            if (localNumRedPath.uint32_msg_status.get() == 0) {
              break label241;
            }
            if (1 == localNumRedPath.uint32_msg_status.get()) {
              break label241;
            }
          }
          else if (localNumRedPath.uint32_msg_status.get() == paramInt)
          {
            i = j + 1;
            break label246;
          }
        }
      }
    }
    for (;;)
    {
      label230:
      return i;
      i = j;
      break label246;
      label241:
      i = j + 1;
      label246:
      j = i;
      break;
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("getRedTouchAppInfoByPath: input path is Empty");
      return null;
    }
    Object localObject2 = a();
    if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
    {
      a("TimeRspBody is Empty or msgAppInfo is Empty path = " + paramString);
      return c(paramString);
    }
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
        if (localAppInfo.path.get().equals(paramString))
        {
          a("getRedTouchAppInfoByPath path = " + paramString + "inewflag = " + localAppInfo.iNewFlag.get());
          return localAppInfo;
        }
      }
    }
    return c(paramString);
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    ThreadManagerV2.excute(new RedTouchManager.3(this, paramTimeRspBody), 64, null, true);
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody1, BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody2)
  {
    HashMap localHashMap = new HashMap();
    paramTimeRspBody1 = paramTimeRspBody1.rptMsgAppInfo.get().iterator();
    Object localObject;
    while (paramTimeRspBody1.hasNext())
    {
      localObject = (BusinessInfoCheckUpdate.AppInfo)paramTimeRspBody1.next();
      if ((localObject != null) && ((((BusinessInfoCheckUpdate.AppInfo)localObject).push_to.get() == 109) || (((BusinessInfoCheckUpdate.AppInfo)localObject).push_to.get() == 109110))) {
        localHashMap.put(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get(), localObject);
      }
    }
    if (paramTimeRspBody2 != null) {
      paramTimeRspBody1 = localHashMap.keySet().iterator();
    }
    label225:
    for (;;)
    {
      if (paramTimeRspBody1.hasNext())
      {
        localObject = (String)paramTimeRspBody1.next();
        Iterator localIterator = paramTimeRspBody2.rptMsgAppInfo.get().iterator();
        while (localIterator.hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
          if (localAppInfo.path.get().equals(localObject)) {
            localAppInfo.set((MessageMicro)localHashMap.get(localObject));
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label225;
        }
        paramTimeRspBody2.rptMsgAppInfo.add((MessageMicro)localHashMap.get(localObject));
        break;
        return;
      }
    }
  }
  
  private BusinessInfoCheckUpdate.AppInfo c(String paramString)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    localAppInfo.path.set(paramString);
    localAppInfo.num.set(0);
    localAppInfo.type.set(-1);
    localAppInfo.iNewFlag.set(0);
    return localAppInfo;
  }
  
  private void c()
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (!localFile.exists()) {
      a("BusinessInfoCheckUpdateItem pb file does not exist");
    }
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = FileUtils.a(localFile);
          if (arrayOfByte != null) {
            break;
          }
          a("Can not translate BusinessInfoCheckUpdateItem pb file to byte");
          return;
        }
        finally {}
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
    try
    {
      localTimeRspBody.mergeFrom(localIOException);
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody = localTimeRspBody;
        a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      a("mergeFrom error " + localException);
    }
  }
  
  private void c(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody = paramTimeRspBody;
      return;
    }
  }
  
  private void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {}
    while (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    a(paramAppInfo, 1, true, null, paramString);
  }
  
  private void d(String paramString)
  {
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointLog.RedTouchManager", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
      }
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody != null) && (localTimeRspBody.rptMsgAppInfo.has()))
        {
          i = 0;
          if (i < localTimeRspBody.rptMsgAppInfo.size())
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(localAppInfo.path.get())) {
              break label229;
            }
            localAppInfo.exposure_max.set(localAppInfo.exposure_max.get() - 1);
            QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxExposeTimes" + paramString + "，max = " + localAppInfo.exposure_max.get());
            if (localAppInfo.exposure_max.get() < 0)
            {
              localAppInfo.iNewFlag.set(0);
              QLog.i("RedPointLog.RedTouchManager", 1, "updateMaxExposeTimes less than 0 " + paramString);
            }
          }
        }
        b(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("RedPointLog.RedTouchManager", 1, "updateNewFlagByPath: " + paramString, localException);
        return;
      }
      label229:
      i += 1;
    }
  }
  
  private void e(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0)
    {
      a(paramAppInfo, 6, false, null, paramString);
      return;
    }
    a(paramAppInfo, 6, true, null, paramString);
  }
  
  public int a(int paramInt)
  {
    a("getExtraNumRedTotalNum appId = " + paramInt);
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
      if (localNumRedInfo == null)
      {
        a("getNumFromFileByAppid : cannot find the info by appid");
        return 0;
      }
      paramInt = localNumRedInfo.red_total_num.get();
      return paramInt;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    a("getExtraNumRedTotalNum appId = " + paramInt1);
    return b(paramInt1, paramInt2);
  }
  
  public int a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
        localAppSetting.appid.set(paramInt);
        localAppSetting.setting.set(paramBoolean1);
        localAppSetting.modify_ts.set(paramLong);
        localTimeRspBody = a();
        if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
        {
          List localList = localTimeRspBody.rptSetting.get();
          int j = localList.size();
          i = 0;
          if (i < j)
          {
            if (paramInt != ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(i)).get()).appid.get()) {
              break label237;
            }
            localList.set(i, localAppSetting);
          }
          if (i == j) {
            localList.add(localAppSetting);
          }
          if (paramBoolean2)
          {
            a(localTimeRspBody);
            return 0;
          }
          b(localTimeRspBody);
        }
      }
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
      localTimeRspBody.rptSetting.add(localMessageMicro);
      if (paramBoolean2)
      {
        a(localTimeRspBody);
      }
      else
      {
        b(localTimeRspBody);
        continue;
        label237:
        i += 1;
      }
    }
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    Object localObject = jdField_b_of_type_JavaLangObject;
    if (paramAppInfo != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!paramAppInfo.path.has())
        {
          a("updateAppInfo failed , appInfo is empty or appInfo path is null");
          return -3;
        }
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if (localTimeRspBody == null)
        {
          a("updateAppInfo failed,TimeRspBody is Empty");
          return -3;
        }
        List localList = localTimeRspBody.rptMsgAppInfo.get();
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(i)).path.get()))
          {
            a("path is same = " + paramAppInfo.path);
            localList.set(i, paramAppInfo);
          }
        }
        else
        {
          if (i == j)
          {
            if (paramBoolean) {
              localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
            }
          }
          else
          {
            b(localTimeRspBody);
            return 0;
          }
          return -3;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true, "");
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString1, int paramInt3, boolean paramBoolean, String paramString2)
  {
    paramString1 = c(paramString1);
    paramString1.uiAppId.set(paramInt2);
    paramString1.type.set(5);
    paramString1.iNewFlag.set(1);
    paramString1.appset.set(paramInt1);
    paramString1.mission_level.set(0);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.extend.set(paramString2);
    }
    paramString2 = new BusinessInfoCheckUpdate.RedDisplayInfo();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(9);
    localRedTypeInfo.red_content.set("-1");
    localRedTypeInfo.red_desc.set("");
    paramString2.red_type_info.add(localRedTypeInfo);
    localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(5);
    localRedTypeInfo.red_content.set(paramInt3 + "");
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    paramString2.tab_display_info.set(localRedTypeInfo);
    paramString2.red_type_info.add(localRedTypeInfo);
    paramString1.red_display_info.set(paramString2);
    if (paramBoolean)
    {
      a(paramString1, true);
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return paramString1;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    a("getAppInfoByPath path = " + paramString);
    int i = b(paramString, 100);
    if (i > 0)
    {
      int j = Integer.parseInt(paramString.split("\\.")[0]);
      BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
      String str = "";
      if (localNumRedInfo != null) {
        str = localNumRedInfo.extend.get();
      }
      return a(paramInt, j, paramString, i, false, str);
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    long l;
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramString2);
        paramString1 = a(paramInt, paramString1);
        if ((paramString1 != null) && (l != -1L)) {
          break;
        }
        return paramString1;
      }
      catch (NumberFormatException paramString2)
      {
        QLog.e("RedPointLog.RedTouchManager", 1, paramString2, new Object[0]);
      }
      l = -1L;
    }
    if (paramString1.id_list.get().contains(Long.valueOf(l))) {
      return paramString1;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, null);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt, String paramString, List<String> paramList)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = null;
    Object localObject1 = null;
    List localList1 = b(paramInt);
    Object localObject2 = localObject1;
    if (localList1 != null)
    {
      if (localList1.size() == 0) {
        localObject2 = localObject1;
      }
    }
    else {
      return localObject2;
    }
    a(localList1, paramList);
    List localList2 = a();
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoByAppSet:redpoint path List:");
    int i = 0;
    localObject1 = null;
    paramList = localRedTypeInfo;
    label81:
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (i < localList1.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      if (localAppInfo.mission_level.get() == 0) {}
    }
    for (;;)
    {
      i += 1;
      break label81;
      if ((!a(paramInt, localList2, localAppInfo)) && ((TextUtils.isEmpty(paramString)) || (localAppInfo.id_list.get().contains(Long.valueOf(paramString)))))
      {
        localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localAppInfo.red_display_info.tab_display_info.get();
        if ((localRedTypeInfo != null) && ((localAppInfo.uiAppId.get() != 100510) || (localRedTypeInfo.red_type.get() != 5)))
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
          }
          else
          {
            localObject2 = localRedTypeInfo;
          }
          localStringBuilder.append(localAppInfo.path.get()).append(",");
          if (localRedTypeInfo.red_type.get() == 5)
          {
            paramList = a(paramList, localAppInfo, localRedTypeInfo, "getRedTouchInfoByAppSet, content=");
            localObject1 = localObject2;
          }
          else
          {
            if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() < localRedTypeInfo.red_priority.get())
            {
              localObject1 = localRedTypeInfo;
              continue;
              localObject2 = paramList;
              if (paramList != null) {
                break;
              }
              if (QLog.isColorLevel())
              {
                if (localObject1 == null) {
                  break label396;
                }
                QLog.e("RedPointLog.RedTouchManager", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result != nullpathList = " + localStringBuilder.toString());
              }
              for (;;)
              {
                return localObject1;
                label396:
                QLog.e("RedPointLog.RedTouchManager", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result = null");
              }
            }
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.AppInfo paramAppInfo, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, String paramString)
  {
    if (paramRedTypeInfo1 == null) {
      return paramRedTypeInfo2;
    }
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("RedPointLog.RedTouchManager", 4, paramString + paramRedTypeInfo1.red_content.get() + ", path=" + paramAppInfo.path.get() + ",redTypeInfoContent=" + paramRedTypeInfo2.red_content.get());
      }
      paramRedTypeInfo1.red_content.set(Integer.parseInt(paramRedTypeInfo1.red_content.get()) + Integer.parseInt(paramRedTypeInfo2.red_content.get()) + "");
      return paramRedTypeInfo1;
    }
    catch (NumberFormatException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
    return paramRedTypeInfo1;
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody != null))
        {
          BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody;
          return localTimeRspBody;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.post(new RedTouchManager.2(this), 5, null, true);
          QLog.e("RedPointLog.RedTouchManager", 1, "cache not ready ");
          return null;
        }
      }
      c();
    }
  }
  
  public String a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("lastClickPath", "");
  }
  
  public String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAppInfo == null))
    {
      a("url is empty or appInfo is Empty");
      return paramString;
    }
    int j = -1;
    int i = j;
    if (paramAppInfo != null)
    {
      i = j;
      if (paramAppInfo.iNewFlag.get() != 0)
      {
        new ArrayList();
        i = j;
        if (paramAppInfo.red_display_info != null)
        {
          i = j;
          if (paramAppInfo.red_display_info.red_type_info != null)
          {
            List localList = paramAppInfo.red_display_info.red_type_info.get();
            i = j;
            if (localList != null)
            {
              i = j;
              if (localList.size() >= 2) {
                i = ((BusinessInfoCheckUpdate.RedTypeInfo)localList.get(1)).red_type.get();
              }
            }
          }
        }
      }
    }
    paramString = new StringBuilder(paramString);
    paramString.append("&status=").append(i).append("&number=").append(paramAppInfo.num.get()).append("&path=").append(paramAppInfo.path.get());
    return paramString.toString();
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject4;
    Object localObject1;
    int i;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("msg"))
      {
        paramString2 = paramString2.getJSONObject("msg");
        if (paramString2 == null) {
          break label228;
        }
        localObject4 = paramString2.keys();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label228;
          }
          new JSONObject();
          String str = (String)((Iterator)localObject4).next();
          localObject1 = paramString2.getJSONObject(str);
          if (!((JSONObject)localObject1).has("stat")) {
            break;
          }
          i = ((JSONObject)localObject1).getInt("stat");
          label131:
          if (i == 2)
          {
            ((List)localObject3).add(str);
            if (!((JSONObject)localObject1).has("content")) {
              break label220;
            }
            localObject1 = ((JSONObject)localObject1).getString("content");
            label167:
            ((Map)localObject2).put(str, localObject1);
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      paramString2 = null;
      localObject1 = null;
      for (;;)
      {
        if ((paramString2 != null) && (paramString2.size() >= 1)) {
          break label238;
        }
        return "";
        paramString2 = null;
        break;
        i = -1;
        break label131;
        label220:
        localObject1 = "";
        break label167;
        label228:
        localObject1 = localObject3;
        paramString2 = (String)localObject2;
      }
      label238:
      localObject2 = new ArrayList();
      paramString1 = a(paramString1);
      if (paramString1 == null) {}
    }
    for (paramString1 = paramString1.buffer.get();; paramString1 = null)
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      a(paramString1, (List)localObject3, (List)localObject4);
      paramString1 = a((List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4);
      if (paramString1.size() > 0) {
        try
        {
          localObject1 = new JSONArray();
          i = 0;
          while (i < paramString1.size())
          {
            localObject2 = new JSONObject();
            localObject3 = (String)paramString1.get(i);
            ((JSONObject)localObject2).put((String)localObject3, (String)paramString2.get(localObject3));
            ((JSONArray)localObject1).put(localObject2);
            i += 1;
          }
          paramString1 = ((JSONArray)localObject1).toString();
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return "";
        }
      }
      return "";
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> a()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = a();
      if ((localObject3 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.has())) {
        return localArrayList;
      }
      localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.get();
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      return localArrayList;
    }
  }
  
  public List<BusinessInfoCheckUpdate.NumRedPath> a(int paramInt)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramInt);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      return localObject2;
    }
  }
  
  public JSONObject a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramAppInfo.buffer.has())
        {
          JSONObject localJSONObject = new JSONObject(paramAppInfo.buffer.get());
          paramAppInfo = localJSONObject.optString("_show_mission");
          if (!TextUtils.isEmpty(paramAppInfo))
          {
            localJSONObject = localJSONObject.optJSONObject("param");
            if (localJSONObject != null)
            {
              paramAppInfo = localJSONObject.optJSONObject(paramAppInfo);
              return paramAppInfo;
            }
          }
        }
      }
      catch (Throwable paramAppInfo)
      {
        QLog.e("RedPointLog.RedTouchManager", 1, "getBufferExtParamAppInfo() JSONException ", paramAppInfo);
      }
    }
    return null;
  }
  
  public void a()
  {
    label192:
    label197:
    label206:
    for (;;)
    {
      int k;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
        if ((localTimeRspBody == null) || (!localTimeRspBody.rptMsgNumRedInfo.has())) {
          break label192;
        }
        Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
        if (localObject3 == null) {
          return;
        }
        localObject3 = ((List)localObject3).iterator();
        i = 0;
        if (!((Iterator)localObject3).hasNext()) {
          break label206;
        }
        List localList = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next()).num_red_path.get();
        if (localList == null) {
          continue;
        }
        k = 0;
        j = i;
        i = j;
        if (k >= localList.size()) {
          continue;
        }
        BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)localList.get(k);
        if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() < (int)(System.currentTimeMillis() / 1000L))
        {
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label197;
          if (i != 0) {
            b(localTimeRspBody);
          }
          return;
        }
      }
      int i = j;
      break label197;
      i = 0;
      continue;
      k += 1;
      int j = i;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(paramInt1 + "", paramInt2);
  }
  
  public void a(int paramInt, String paramString)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      int i = b(paramString, 100);
      if (i > 0)
      {
        BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(paramInt);
        if (localNumRedInfo != null)
        {
          String str = localNumRedInfo.extend.get();
          a(a(localNumRedInfo.appset.get(), paramInt, paramString, i, false, str), 9, "", true, 3);
        }
      }
      return;
    }
  }
  
  public void a(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.5.5.5105");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(paramInt2);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt1);
    if (paramArrayList != null) {
      localReportReqBody.missionid.set(paramArrayList);
    }
    paramInt1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("check_update_sp_key", 0).getInt("businessinfo_last_check_update_timestamp_" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString3))
        {
          paramArrayList = new JSONObject();
          paramString3 = paramArrayList;
        }
      }
      catch (Exception paramArrayList)
      {
        paramString3 = null;
      }
      try
      {
        paramArrayList.put("msg", "");
        paramString3 = paramArrayList;
        paramArrayList.put("red", paramString1);
        paramString3 = paramArrayList;
        paramArrayList.put("ret", paramString2);
        paramString3 = paramArrayList;
        paramArrayList.put("lastTime", paramInt1);
        paramString3 = paramArrayList;
        paramArrayList.put("callback", paramString5);
        paramString3 = paramArrayList;
        paramArrayList.put("waterid", paramString4);
        paramString1 = paramArrayList;
        if (paramString1 != null) {
          localReportReqBody.buffer.set(paramString1.toString());
        }
        paramArrayList = a("RedTouchSvc.ClientReport");
        paramArrayList.putWupBuffer(localReportReqBody.toByteArray());
        a(paramArrayList);
        return;
      }
      catch (Exception paramArrayList)
      {
        break label308;
      }
      paramArrayList = new JSONObject(paramString3);
      continue;
      label308:
      paramString1 = paramString3;
      if (QLog.isColorLevel())
      {
        QLog.e("RedPointLog.RedTouchManager", 2, "getAndSetAppInfoJsReport buffer json is empty", paramArrayList);
        paramString1 = paramString3;
      }
    }
  }
  
  public void a(long paramLong)
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangString.contains("."))) {}
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      return;
      localAppInfo = a(this.jdField_a_of_type_JavaLangString);
    } while ((localAppInfo == null) || (paramLong < 0L));
    paramLong = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.e("residenceReport", 2, "residenceReport time = " + paramLong + ";path = " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = null;
    ThreadManager.post(new RedTouchManager.4(this, localAppInfo, paramLong), 2, null, true);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    d(paramAppInfo, null);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    String str = paramAppInfo.path.get();
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager.a(paramAppInfo.buffer.get());
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 9, paramString, true, 3);
      return;
    }
    a(paramAppInfo, str, paramString);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    a(paramAppInfo, paramJSONObject, paramInt, null);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.5.5.5105");
    localReportReqBody.platid.set(109);
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    if (paramJSONObject != null) {
      localReportReqBody.buffer.set(paramJSONObject.toString());
    }
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo != null)
    {
      localReportReqBody.appid.set(a(paramAppInfo.path.get()));
      if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
    paramAppInfo = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramJSONObject = new JSONObject(paramString);
        if (paramJSONObject != null)
        {
          paramString = paramJSONObject.keys();
          while (paramString.hasNext())
          {
            String str = (String)paramString.next();
            BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
            localReportStaticsData.key.set(str);
            localReportStaticsData.value.set(paramJSONObject.getString(str));
            paramAppInfo.add(localReportStaticsData);
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("RedPointLog.RedTouchManager", 2, "reportStatistic parse json exception ", paramJSONObject);
      localReportReqBody.reportdata.set(paramAppInfo);
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "onReportRedPointClickWithMissions");
    }
    if (paramAppInfo == null)
    {
      QLog.e("RedPointLog.RedTouchManager", 1, "onReportRedPointClickWithMissions appinfo = null");
      return;
    }
    a(paramAppInfo, 6, paramBoolean, paramList, null);
  }
  
  public void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    if ((paramTimeRspBody == null) || (!paramTimeRspBody.rptMsgAppInfo.has())) {
      return;
    }
    Object localObject = paramTimeRspBody.rptMsgAppInfo.get();
    paramTimeRspBody = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localAppInfo.path.get()))
      {
        a(localAppInfo, null, 32, null);
        paramTimeRspBody.add(localAppInfo.uiAppId.get() + "");
      }
    }
    a("level zero arrived, reportAppIdList:" + paramTimeRspBody);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.iNewFlag.get() != 0)) {}
    switch (paramInt)
    {
    default: 
    case 30: 
      do
      {
        return;
        d(paramString.path.get());
      } while (paramString.exposure_max.get() < 0);
      a(paramString, paramInt, true, null, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager.a(paramString.buffer.get());
    a(paramString.path.get(), false);
    a(paramString, paramInt, true, null, null);
    ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  protected void a(List<BusinessInfoCheckUpdate.AppInfo> paramList, List<String> paramList1)
  {
    if (paramList1 != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)paramList.next();
        int i = 0;
        while ((i < paramList1.size()) && (!String.valueOf(localAppInfo.uiAppId.get()).equals(paramList1.get(i))))
        {
          if (i == paramList1.size() - 1) {
            paramList.remove();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        Object localObject = new Submsgtype0x89.MsgBody();
        ((Submsgtype0x89.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localObject = ((Submsgtype0x89.MsgBody)localObject).rpt_msg_num_red.get();
        if (localObject == null) {
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Submsgtype0x89.NumRedBusiInfo localNumRedBusiInfo = (Submsgtype0x89.NumRedBusiInfo)((Iterator)localObject).next();
          if ((a(localNumRedBusiInfo)) && (RedTouchUtils.a(localNumRedBusiInfo))) {
            a(a(localNumRedBusiInfo.int32_appset.get(), localNumRedBusiInfo.uint32_app_id.get(), String.valueOf(localNumRedBusiInfo.uint64_msgid.get()), 1), 1, "", false, -1);
          }
        }
        a(paramArrayOfByte, 4);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback)
  {
    ((NumRedMsgManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.NUMREDMSG_MANAGER)).a(paramArrayOfLong, paramString, paramNumRedGetMsgCallback);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("isCacheChange", true);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (a(paramInt, 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 149	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7: astore 5
    //   9: getstatic 33	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   12: astore 4
    //   14: aload 4
    //   16: monitorenter
    //   17: aload_1
    //   18: invokevirtual 1138	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:toByteArray	()[B
    //   21: astore 6
    //   23: aload 4
    //   25: monitorexit
    //   26: getstatic 31	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   29: astore 4
    //   31: aload 4
    //   33: monitorenter
    //   34: getstatic 26	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   37: invokevirtual 1141	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   40: istore_2
    //   41: new 761	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: getfield 44	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   49: invokevirtual 765	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   52: invokevirtual 771	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   55: new 172	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 773
    //   65: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload 5
    //   70: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 776	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   79: invokevirtual 1144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   82: aload 6
    //   84: iconst_0
    //   85: invokestatic 1147	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   88: istore_3
    //   89: iload_3
    //   90: ifeq +90 -> 180
    //   93: getstatic 1150	com/tencent/mobileqq/servlet/GameCenterManagerImp:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   96: aload 5
    //   98: iconst_0
    //   99: invokestatic 1155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   102: invokevirtual 1158	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: aload 4
    //   108: monitorexit
    //   109: getstatic 33	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   112: astore 4
    //   114: aload 4
    //   116: monitorenter
    //   117: iload_3
    //   118: ifeq +18 -> 136
    //   121: iload_2
    //   122: getstatic 26	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   125: invokevirtual 1159	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   128: if_icmpne +8 -> 136
    //   131: aload_0
    //   132: aload_1
    //   133: invokespecial 1161	com/tencent/mobileqq/redtouch/RedTouchManager:c	(Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody;)V
    //   136: aload 4
    //   138: monitorexit
    //   139: iload_3
    //   140: ireturn
    //   141: astore_1
    //   142: ldc_w 291
    //   145: iconst_1
    //   146: ldc_w 1163
    //   149: aload_1
    //   150: invokestatic 408	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload 4
    //   155: monitorexit
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_1
    //   159: aload 4
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: ldc_w 291
    //   168: iconst_1
    //   169: ldc_w 1165
    //   172: invokestatic 487	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 4
    //   177: monitorexit
    //   178: iconst_0
    //   179: ireturn
    //   180: ldc_w 291
    //   183: iconst_1
    //   184: ldc_w 1167
    //   187: invokestatic 487	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: goto -84 -> 106
    //   193: astore_1
    //   194: aload 4
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: aload 4
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	RedTouchManager
    //   0	205	1	paramTimeRspBody	BusinessInfoCheckUpdate.TimeRspBody
    //   40	89	2	i	int
    //   88	52	3	bool	boolean
    //   7	90	5	str	String
    //   21	62	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	23	141	java/lang/Exception
    //   17	23	158	finally
    //   23	26	158	finally
    //   142	156	158	finally
    //   159	162	158	finally
    //   165	178	158	finally
    //   17	23	164	java/lang/OutOfMemoryError
    //   34	89	193	finally
    //   93	106	193	finally
    //   106	109	193	finally
    //   180	190	193	finally
    //   194	197	193	finally
    //   121	136	199	finally
    //   136	139	199	finally
    //   200	203	199	finally
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo start");
    }
    try
    {
      a(paramArrayOfByte, 3);
      if (QLog.isColorLevel()) {
        QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo end");
      }
      return false;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.e("RedPointLog.RedTouchManager", 1, "push parse error : e = " + paramArrayOfByte.getMessage());
      }
    }
  }
  
  public int b(int paramInt)
  {
    int j = 0;
    label168:
    label171:
    label174:
    for (;;)
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        Object localObject2 = a();
        int i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
          {
            localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
            if (localObject2 == null)
            {
              a("getNumRedShowNumByAppSet : numRedBusiList is null");
              return 0;
            }
            localObject2 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject2).hasNext()) {
              break label174;
            }
            BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if (paramInt != localNumRedInfo.appset.get()) {
              break label168;
            }
            if (localNumRedInfo.appid.get() == 7719) {
              continue;
            }
            if (!a(localNumRedInfo.appid.get())) {
              break label168;
            }
            i = a(localNumRedInfo.appid.get(), 100) + i;
            break label171;
          }
        }
        return i;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      a("input path is Empty");
    }
    int i;
    do
    {
      return null;
      a("getAppInfoByPath path = " + paramString);
      i = a(paramString, 100);
    } while (i <= 0);
    int j = Integer.parseInt(paramString.split("\\.")[0]);
    BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = a(j);
    String str = "";
    if (localNumRedInfo != null) {
      str = localNumRedInfo.extend.get();
    }
    return a(paramInt, j, paramString, i, false, str);
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> b(int paramInt)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
      {
        localObject2 = new ArrayList();
        return localObject2;
      }
      Object localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject3).next();
        if (localAppInfo.appset.get() == paramInt) {
          ((List)localObject2).add(localAppInfo);
        }
      }
    }
    return localList;
  }
  
  public void b()
  {
    QLog.d("RedPointLog.RedTouchManager", 2, "getNewFlagOp:send redInfo start");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("check_update_sp_key", 0);
    long l1 = ((SharedPreferences)localObject).getLong("conversation_remain_last_report", -1L);
    long l2 = QzoneConfig.getInstance().getConfig("WNSSettting", "conversation_remain_report_control", 60);
    long l3 = System.currentTimeMillis() / 1000L;
    if (l1 > l3 - l2) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("conversation_remain_last_report", l3);
    ((SharedPreferences.Editor)localObject).apply();
    a(null, null, 50);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 30) && ((this.jdField_a_of_type_Int & 1 << paramInt1) != 0))
    {
      a("red touch in appSet:" + paramInt1 + " had reported expose once,and expose switch is:" + this.jdField_a_of_type_Int);
      return;
    }
    if ((paramInt2 == 31) && ((this.jdField_b_of_type_Int & 1 << paramInt1) != 0))
    {
      a("red touch in appSet:" + paramInt1 + " had reported click once,and click switch is:" + this.jdField_b_of_type_Int);
      return;
    }
    if (paramInt2 == 30)
    {
      this.jdField_a_of_type_Int |= 1 << paramInt1;
      a("expose switch changed:" + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new RedTouchManager.6(this, paramInt1, paramInt2), 5000L);
      return;
      if (paramInt2 == 31)
      {
        this.jdField_b_of_type_Int |= 1 << paramInt1;
        a("click switch changed:" + this.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo.type.get() == 5)
    {
      a(paramAppInfo, 8, paramString, false, -1);
      return;
    }
    d(paramAppInfo, paramString);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    a(a(paramString), paramString, null);
  }
  
  /* Error */
  public boolean b(int paramInt)
  {
    // Byte code:
    //   0: getstatic 33	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: iload_1
    //   7: ifne +7 -> 14
    //   10: aload_3
    //   11: monitorexit
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: invokevirtual 89	com/tencent/mobileqq/redtouch/RedTouchManager:a	()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +7 -> 29
    //   25: aload_3
    //   26: monitorexit
    //   27: iconst_1
    //   28: ireturn
    //   29: aload 4
    //   31: getfield 95	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   34: invokevirtual 105	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +66 -> 107
    //   44: aload 4
    //   46: invokeinterface 113 1 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 118 1 0
    //   60: ifeq +47 -> 107
    //   63: aload 4
    //   65: invokeinterface 122 1 0
    //   70: checkcast 124	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo
    //   73: astore 5
    //   75: aload 5
    //   77: getfield 128	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   83: iload_1
    //   84: if_icmpne -31 -> 53
    //   87: aload 5
    //   89: getfield 1247	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo:flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   92: invokevirtual 715	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   95: istore_2
    //   96: aload_3
    //   97: monitorexit
    //   98: iload_2
    //   99: ireturn
    //   100: astore 4
    //   102: aload_3
    //   103: monitorexit
    //   104: aload 4
    //   106: athrow
    //   107: aload_3
    //   108: monitorexit
    //   109: iconst_1
    //   110: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	RedTouchManager
    //   0	111	1	paramInt	int
    //   95	4	2	bool	boolean
    //   3	105	3	localObject1	Object
    //   100	5	4	localObject3	Object
    //   73	15	5	localNumRedInfo	BusinessInfoCheckUpdate.NumRedInfo
    // Exception table:
    //   from	to	target	type
    //   10	12	100	finally
    //   14	20	100	finally
    //   25	27	100	finally
    //   29	39	100	finally
    //   44	53	100	finally
    //   53	98	100	finally
    //   102	104	100	finally
    //   107	109	100	finally
  }
  
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if ((paramAppInfo == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    d(paramAppInfo.path.get());
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.5.5.5105");
    localReportReqBody.platid.set(109);
    localReportReqBody.missionid.set(paramAppInfo.missions.get());
    localReportReqBody.appid.set(paramAppInfo.uiAppId.get());
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(5);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramAppInfo = new JSONObject();
      if (paramAppInfo != null) {}
      try
      {
        paramAppInfo.put("cmd", 5);
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = paramAppInfo;
        if (localJSONObject == null) {
          break label265;
        }
        Iterator localIterator = localJSONObject.keys();
        for (;;)
        {
          paramString = paramAppInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          BusinessInfoCheckUpdate.ReportStaticsData localReportStaticsData = new BusinessInfoCheckUpdate.ReportStaticsData();
          localReportStaticsData.key.set(paramString);
          localReportStaticsData.value.set(localJSONObject.getString(paramString));
          localArrayList.add(localReportStaticsData);
        }
        paramString.printStackTrace();
      }
      catch (JSONException paramString) {}
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        label265:
        paramAppInfo = null;
      }
    }
    paramString = paramAppInfo;
    if (paramString != null) {
      localReportReqBody.buffer.set(paramString.toString());
    }
    localReportReqBody.reportdata.set(localArrayList);
    paramAppInfo = a("RedTouchSvc.ClientReport");
    paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
    a(paramAppInfo);
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localObject != null)
    {
      if (a(paramString).iNewFlag.get() == 1) {
        ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString).commit();
      }
    }
    else
    {
      localObject = a(paramString);
      if (localObject != null)
      {
        if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0) {
          break label161;
        }
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, false, null, null);
      }
    }
    for (;;)
    {
      a(paramString, false);
      setChanged();
      ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      break;
      label161:
      a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, true, null, null);
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager
 * JD-Core Version:    0.7.0.1
 */