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
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
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
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected AppInterface a;
  private RedTouchLifeTimeManager jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager;
  private BusinessInfoCheckUpdate.TimeRspBody jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  
  public RedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager = RedTouchLifeTimeManager.a();
  }
  
  private BusinessInfoCheckUpdate.NumRedInfo a(int paramInt)
  {
    label117:
    Object localObject3;
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
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label117;
          }
          localObject1 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator.next();
          if (paramInt == ((BusinessInfoCheckUpdate.NumRedInfo)localObject1).appid.get()) {
            break;
          }
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
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo1, BusinessInfoCheckUpdate.AppInfo paramAppInfo, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo2, String paramString)
  {
    if (paramRedTypeInfo1 == null) {
      return paramRedTypeInfo2;
    }
    try
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramRedTypeInfo1.red_content.get());
        localStringBuilder.append(", path=");
        localStringBuilder.append(paramAppInfo.path.get());
        localStringBuilder.append(",redTypeInfoContent=");
        localStringBuilder.append(paramRedTypeInfo2.red_content.get());
        QLog.e("RedPointLog.RedTouchManager", 4, localStringBuilder.toString());
      }
      paramAppInfo = paramRedTypeInfo1.red_content;
      paramString = new StringBuilder();
      paramString.append(Integer.parseInt(paramRedTypeInfo1.red_content.get()) + Integer.parseInt(paramRedTypeInfo2.red_content.get()));
      paramString.append("");
      paramAppInfo.set(paramString.toString());
      return paramRedTypeInfo1;
    }
    catch (NumberFormatException paramAppInfo)
    {
      paramRedTypeInfo2 = new StringBuilder();
      paramRedTypeInfo2.append("error getRedTypeInfo ");
      paramRedTypeInfo2.append(paramAppInfo);
      QLog.e("RedPointLog.RedTouchManager", 1, paramRedTypeInfo2.toString());
    }
    return paramRedTypeInfo1;
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
    StringBuilder localStringBuilder = AIOUtils.a();
    localStringBuilder.append(paramAppInfo.path.get());
    localStringBuilder.append(":");
    paramAppInfo = RedTouchTextView.a(paramAppInfo);
    if (paramAppInfo != null)
    {
      paramAppInfo = paramAppInfo.iterator();
      while (paramAppInfo.hasNext())
      {
        localStringBuilder.append(((BusinessInfoCheckUpdate.RedTypeInfo)paramAppInfo.next()).red_type.get());
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private List<String> a(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    if (paramList3.size() < 1) {
      return paramList1;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      String str = (String)paramList1.get(i);
      if (!paramList4.contains(str))
      {
        paramList2.add(str);
        break;
      }
      int j = 0;
      while (j < paramList3.size())
      {
        if (str.equals((String)paramList3.get(j)))
        {
          j = 1;
          break label114;
        }
        j += 1;
      }
      j = 0;
      label114:
      if (j != 0) {
        paramList2.add(str);
      }
      i += 1;
    }
    return paramList2;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j;
    label228:
    label237:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
      j = 0;
      int i = j;
      if (localTimeRspBody != null)
      {
        i = j;
        if (localTimeRspBody.rptMsgNumRedInfo.has())
        {
          Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
          if (localObject3 == null)
          {
            a("getNumFromFileByPathAndType : numRedBusiList is null");
            return;
          }
          localObject3 = ((List)localObject3).iterator();
          i = 0;
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label237;
            }
            Object localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next();
            if (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() == paramInt1)
            {
              localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
              if (localObject4 != null) {
                break;
              }
              if ((goto 77) && (j < ((List)localObject4).size()))
              {
                if (((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint64_msgid.get() != paramInt2) {
                  break label228;
                }
                ((BusinessInfoCheckUpdate.NumRedPath)((List)localObject4).get(j)).uint32_msg_status.set(paramInt3);
                i = 1;
              }
            }
          }
        }
      }
      if (i != 0) {
        b(localTimeRspBody);
      }
      return;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if (paramInt == 6)
    {
      MobileReportManager.getInstance().reportRedpoint(paramAppInfo, 102);
      return;
    }
    if (paramInt == 1) {
      MobileReportManager.getInstance().reportRedpoint(paramAppInfo, 101);
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a(paramAppInfo.uiAppId.get());
      if (localObject2 == null) {
        return;
      }
      Object localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.get();
      if (localObject3 == null)
      {
        a("onReportShowMsgs : NumRedPaths is null");
        return;
      }
      localObject2 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
        ((List)localObject2).add(Long.valueOf(localNumRedPath.uint64_msgid.get()));
        if (paramBoolean) {
          a(paramAppInfo.uiAppId.get(), (int)localNumRedPath.uint64_msgid.get(), paramInt2);
        }
      }
      a(paramAppInfo, paramInt1, false, null, (List)localObject2, paramString);
      return;
    }
    for (;;)
    {
      throw paramAppInfo;
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, String paramString1, boolean paramBoolean, List<Long> paramList, List<String> paramList1, String paramString2)
  {
    QLog.i("RedPointLog.RedTouchManager", 1, String.format("onReportSync id = %s type = %d", new Object[] { paramAppInfo.path.get(), Integer.valueOf(paramInt) }));
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.7.0.5295");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(RedTouchUtil.a(paramAppInfo.path.get()));
    Object localObject1 = localReportReqBody.platver;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append("");
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo.extend.has()) {
      localReportReqBody.extend.set(paramAppInfo.extend.get());
    }
    if (paramList != null) {
      localReportReqBody.msgids.set(paramList);
    }
    paramList = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((paramList instanceof QQAppInterface)) {
      if (((QQAppInterface)paramList).mIsShowNewLeba) {
        localReportReqBody.bHebaFlag.set(true);
      } else {
        localReportReqBody.bHebaFlag.set(false);
      }
    }
    if (paramBoolean) {
      if ((paramList1 != null) && (paramList1.size() > 0)) {
        localReportReqBody.missionid.set(paramList1);
      } else if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
    paramList = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramList1 = new JSONObject(paramString2);
        paramString2 = paramList1.keys();
        while (paramString2.hasNext())
        {
          localObject1 = (String)paramString2.next();
          localObject2 = new BusinessInfoCheckUpdate.ReportStaticsData();
          ((BusinessInfoCheckUpdate.ReportStaticsData)localObject2).key.set((String)localObject1);
          ((BusinessInfoCheckUpdate.ReportStaticsData)localObject2).value.set(paramList1.getString((String)localObject1));
          paramList.add(localObject2);
        }
      }
      return;
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
      ThreadManager.post(new RedTouchManager.4(this, paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1), 2, null, true);
      return;
    }
    a(paramAppInfo, paramInt, paramString2, paramBoolean, paramList1, paramList, paramString1);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRedTouchItemClick path = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.e("RedPointLog.RedTouchManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    int j = paramAppInfo.iNewFlag.get();
    int i = 1;
    if (j == 1)
    {
      ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString1).commit();
    }
    else
    {
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      i = 0;
    }
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
      while (paramTimeRspBody1.hasNext())
      {
        localObject1 = (BusinessInfoCheckUpdate.NumRedPath)paramTimeRspBody1.next();
        int i = 0;
        localIterator1 = paramTimeRspBody2.rptMsgNumRedInfo.get().iterator();
        do
        {
          do
          {
            j = i;
            if (!localIterator1.hasNext()) {
              break;
            }
            localObject2 = (BusinessInfoCheckUpdate.NumRedInfo)localIterator1.next();
          } while ((localHashMap.get(localObject1) == null) || (((BusinessInfoCheckUpdate.NumRedInfo)localObject2).appid.get() != ((BusinessInfoCheckUpdate.NumRedInfo)localHashMap.get(localObject1)).appid.get()));
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
          i = j;
        } while (j != 0);
        ((BusinessInfoCheckUpdate.NumRedInfo)localObject2).num_red_path.add((MessageMicro)localObject1);
        int j = 1;
        if (j == 0) {
          paramTimeRspBody2.rptMsgNumRedInfo.add((MessageMicro)localHashMap.get(localObject1));
        }
      }
    }
  }
  
  private final void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        return;
      }
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).sendToService(paramToServiceMsg);
    }
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
                break label147;
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
      label147:
      int i = -1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setNewStatusByID,path = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("RedPointLog.RedTouchManager", 2, ((StringBuilder)localObject1).toString());
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
        localObject1 = a();
        if ((localObject1 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.has()))
        {
          int j = 0;
          i = 0;
          if (i < ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.size())
          {
            localObject2 = (BusinessInfoCheckUpdate.AppInfo)((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.get(i);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get())) {
              break label248;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag;
            if (paramBoolean) {
              j = 1;
            }
            localPBInt32Field.set(j);
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject1).rptMsgAppInfo.set(i, (MessageMicro)localObject2);
          }
        }
        b((BusinessInfoCheckUpdate.TimeRspBody)localObject1);
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateNewFlagByPath: ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("RedPointLog.RedTouchManager", 1, ((StringBuilder)localObject2).toString(), localException);
        return;
      }
      label248:
      i += 1;
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("redTouchPref", 4);
    if (paramContext == null) {
      return;
    }
    paramContext.edit().putBoolean("isCacheChange", paramBoolean).apply();
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    a("handler after push");
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localObject1 instanceof QQAppInterface)) {
      localObject1 = (QQAppInterface)localObject1;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    int i;
    try
    {
      localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
      ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = a();
      b((BusinessInfoCheckUpdate.TimeRspBody)localObject2, paramArrayOfByte);
      a((BusinessInfoCheckUpdate.TimeRspBody)localObject2, paramArrayOfByte);
      if ((((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get() == null) || (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().size() <= 0))
      {
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get() != null)
        {
          i = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get().size();
          if (i <= 0) {}
        }
      }
      else
      {
        i = 1;
        break label137;
      }
      i = 0;
      label137:
      j = i;
      if (paramArrayOfByte == null) {
        break label201;
      }
      try
      {
        b(paramArrayOfByte);
        j = i;
      }
      catch (Exception paramArrayOfByte) {}
      localObject2 = new StringBuilder();
    }
    catch (Exception paramArrayOfByte)
    {
      i = 0;
    }
    ((StringBuilder)localObject2).append("TimeRspBody handle push exception ");
    ((StringBuilder)localObject2).append(paramArrayOfByte);
    QLog.e("RedPointLog.RedTouchManager", 1, ((StringBuilder)localObject2).toString());
    int j = i;
    label201:
    if (j != 0)
    {
      QLog.d("RedPointLog.RedTouchManager", 1, "has push data ");
      ((IRedTouchServer)((QQAppInterface)localObject1).getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate((AppRuntime)localObject1);
      return;
    }
    if (BaseActivity.mAppForground)
    {
      ((IRedTouchServer)((QQAppInterface)localObject1).getRuntimeService(IRedTouchServer.class, "")).sendRedpointReq(true, true, paramInt);
      return;
    }
    paramArrayOfByte = ((QQAppInterface)localObject1).getApp().getSharedPreferences("check_update_sp_key", 0).edit();
    paramArrayOfByte.putBoolean("redtouch_force", true);
    paramArrayOfByte.apply();
  }
  
  private boolean a(int paramInt, List<BusinessInfoCheckUpdate.AppSetting> paramList, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (999999 != paramAppInfo.uiAppId.get())
    {
      if (paramAppInfo.path.get().contains(".")) {
        return true;
      }
      if (paramAppInfo.iNewFlag.get() != 1) {
        return true;
      }
      if (((paramInt == 0) || (paramInt == 1) || (paramInt == 11) || (paramInt == 10)) && (paramAppInfo.exposure_max.get() <= 0)) {
        return true;
      }
      paramInt = 0;
      while ((paramInt < paramList.size()) && (paramAppInfo.uiAppId.get() != ((BusinessInfoCheckUpdate.AppSetting)paramList.get(paramInt)).appid.get())) {
        paramInt += 1;
      }
      return (paramInt < paramList.size()) && (!((BusinessInfoCheckUpdate.AppSetting)paramList.get(paramInt)).setting.get());
    }
    return true;
  }
  
  private boolean a(Submsgtype0x89.NumRedBusiInfo paramNumRedBusiInfo)
  {
    if (paramNumRedBusiInfo == null) {
      return false;
    }
    return (paramNumRedBusiInfo.uint32_plat_id.get() == 109) || (paramNumRedBusiInfo.uint32_plat_id.get() == 109110);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    int j;
    label201:
    label236:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      int k = 0;
      int i = 0;
      j = k;
      if (localObject2 != null)
      {
        j = k;
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
        {
          localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
          if (localObject2 == null)
          {
            a("getNumFromFileByPathAndType : numRedBusiList is null");
            return 0;
          }
          localObject2 = ((List)localObject2).iterator();
          do
          {
            do
            {
              j = i;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject4 = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            } while (((BusinessInfoCheckUpdate.NumRedInfo)localObject4).appid.get() != paramInt1);
            localObject4 = ((BusinessInfoCheckUpdate.NumRedInfo)localObject4).num_red_path.get();
          } while (localObject4 == null);
          Object localObject4 = ((List)localObject4).iterator();
          j = i;
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath;
          do
          {
            do
            {
              i = j;
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
              localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject4).next();
              if (100 != paramInt2) {
                break label201;
              }
              if (localNumRedPath.uint32_msg_status.get() == 0) {
                break label236;
              }
            } while (1 != localNumRedPath.uint32_msg_status.get());
            break label236;
          } while (localNumRedPath.uint32_msg_status.get() != paramInt2);
          break label236;
        }
      }
      return j;
    }
  }
  
  private int b(String paramString, int paramInt)
  {
    int j;
    label219:
    label252:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      boolean bool = TextUtils.isEmpty(paramString);
      int k = 0;
      int i = 0;
      if (bool) {
        return 0;
      }
      Object localObject2 = a();
      j = k;
      if (localObject2 != null)
      {
        j = k;
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
        {
          localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
          if (localObject2 == null)
          {
            a("getNumFromFileByPathAndType : numRedBusiList is null");
            return 0;
          }
          localObject2 = ((List)localObject2).iterator();
          do
          {
            j = i;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next()).num_red_path.get();
          } while (localObject3 == null);
          Object localObject3 = ((List)localObject3).iterator();
          j = i;
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath;
          do
          {
            do
            {
              do
              {
                i = j;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)((Iterator)localObject3).next();
              } while (!localNumRedPath.str_path.get().equals(paramString));
              if (100 != paramInt) {
                break label219;
              }
              if (localNumRedPath.uint32_msg_status.get() == 0) {
                break label252;
              }
            } while (1 != localNumRedPath.uint32_msg_status.get());
            break label252;
          } while (localNumRedPath.uint32_msg_status.get() != paramInt);
          break label252;
        }
      }
      return j;
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
    if ((localObject2 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has())) {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        Object localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject3).next();
          if (((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get().equals(paramString))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getRedTouchAppInfoByPath path = ");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append("inewflag = ");
            ((StringBuilder)localObject3).append(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
            a(((StringBuilder)localObject3).toString());
            return localObject2;
          }
        }
        return c(paramString);
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("TimeRspBody is Empty or msgAppInfo is Empty path = ");
    ((StringBuilder)???).append(paramString);
    a(((StringBuilder)???).toString());
    return c(paramString);
  }
  
  private void b(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    ThreadManagerV2.excute(new RedTouchManager.2(this, paramTimeRspBody), 64, null, true);
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
    if (paramTimeRspBody2 != null)
    {
      paramTimeRspBody1 = localHashMap.keySet().iterator();
      while (paramTimeRspBody1.hasNext())
      {
        localObject = (String)paramTimeRspBody1.next();
        int j = 0;
        Iterator localIterator = paramTimeRspBody2.rptMsgAppInfo.get().iterator();
        BusinessInfoCheckUpdate.AppInfo localAppInfo;
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        } while (!localAppInfo.path.get().equals(localObject));
        localAppInfo.set((MessageMicro)localHashMap.get(localObject));
        int i = 1;
        if (i == 0) {
          paramTimeRspBody2.rptMsgAppInfo.add((MessageMicro)localHashMap.get(localObject));
        }
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
  
  private void c(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody = paramTimeRspBody;
      return;
    }
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4: invokevirtual 751	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: invokevirtual 757	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   10: astore_1
    //   11: new 111	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc_w 759
    //   23: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_0
    //   29: getfield 41	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   32: invokevirtual 177	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   35: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: new 761	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 764	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 767	java/io/File:exists	()Z
    //   56: ifne +22 -> 78
    //   59: ldc_w 621
    //   62: invokestatic 73	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 770	java/io/File:createNewFile	()Z
    //   69: pop
    //   70: goto +8 -> 78
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual 771	java/io/IOException:printStackTrace	()V
    //   78: aload_0
    //   79: monitorenter
    //   80: aload_1
    //   81: invokestatic 777	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: ifnonnull +10 -> 98
    //   91: ldc_w 779
    //   94: invokestatic 73	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)V
    //   97: return
    //   98: new 54	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody
    //   101: dup
    //   102: invokespecial 660	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:<init>	()V
    //   105: astore_1
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual 664	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: pop
    //   112: getstatic 32	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   115: astore_2
    //   116: aload_2
    //   117: monitorenter
    //   118: aload_0
    //   119: aload_1
    //   120: putfield 745	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody;
    //   123: iconst_0
    //   124: aload_0
    //   125: getfield 41	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   128: invokevirtual 486	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   131: invokestatic 781	com/tencent/mobileqq/redtouch/RedTouchManager:a	(ZLandroid/content/Context;)V
    //   134: aload_2
    //   135: monitorexit
    //   136: return
    //   137: astore_1
    //   138: aload_2
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: new 111	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   150: astore_2
    //   151: aload_2
    //   152: ldc_w 783
    //   155: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_2
    //   160: aload_1
    //   161: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 73	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)V
    //   172: return
    //   173: astore_1
    //   174: aload_0
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	RedTouchManager
    //   10	110	1	localObject1	Object
    //   137	4	1	localObject2	Object
    //   142	19	1	localException	Exception
    //   173	4	1	localObject3	Object
    //   18	27	2	localStringBuilder	StringBuilder
    //   73	2	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	70	73	java/io/IOException
    //   118	136	137	finally
    //   138	140	137	finally
    //   106	112	142	java/lang/Exception
    //   80	87	173	finally
    //   174	176	173	finally
  }
  
  private void d(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0) {
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
            localObject = (BusinessInfoCheckUpdate.AppInfo)localTimeRspBody.rptMsgAppInfo.get(i);
            if (!paramString.equals(((BusinessInfoCheckUpdate.AppInfo)localObject).path.get())) {
              break label264;
            }
            ((BusinessInfoCheckUpdate.AppInfo)localObject).exposure_max.set(((BusinessInfoCheckUpdate.AppInfo)localObject).exposure_max.get() - 1);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateMaxExposeTimes");
            localStringBuilder.append(paramString);
            localStringBuilder.append("，max = ");
            localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject).exposure_max.get());
            QLog.i("RedPointLog.RedTouchManager", 1, localStringBuilder.toString());
            if (((BusinessInfoCheckUpdate.AppInfo)localObject).exposure_max.get() < 0)
            {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.set(0);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("updateMaxExposeTimes less than 0 ");
              ((StringBuilder)localObject).append(paramString);
              QLog.i("RedPointLog.RedTouchManager", 1, ((StringBuilder)localObject).toString());
            }
          }
        }
        b(localTimeRspBody);
        return;
      }
      catch (Exception localException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateNewFlagByPath: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("RedPointLog.RedTouchManager", 1, ((StringBuilder)localObject).toString(), localException);
        return;
      }
      label264:
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
    ??? = new StringBuilder();
    ((StringBuilder)???).append("getExtraNumRedTotalNum appId = ");
    ((StringBuilder)???).append(paramInt);
    a(((StringBuilder)???).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getExtraNumRedTotalNum appId = ");
    localStringBuilder.append(paramInt1);
    a(localStringBuilder.toString());
    return b(paramInt1, paramInt2);
  }
  
  public int a(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    int i;
    label246:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
      localAppSetting.appid.set(paramInt);
      localAppSetting.setting.set(paramBoolean1);
      localAppSetting.modify_ts.set(paramLong);
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
      if ((localTimeRspBody != null) && ((localTimeRspBody.has()) || (localTimeRspBody.rptSetting.has())))
      {
        List localList = localTimeRspBody.rptSetting.get();
        int j = localList.size();
        i = 0;
        if (i < j)
        {
          if (paramInt != ((BusinessInfoCheckUpdate.AppSetting)((BusinessInfoCheckUpdate.AppSetting)localList.get(i)).get()).appid.get()) {
            break label246;
          }
          localList.set(i, localAppSetting);
        }
        if (i == j) {
          localList.add(localAppSetting);
        }
        if (paramBoolean2) {
          a(localTimeRspBody);
        } else {
          b(localTimeRspBody);
        }
      }
      else
      {
        localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
        localTimeRspBody.rptSetting.add(localAppSetting);
        if (paramBoolean2) {
          a(localTimeRspBody);
        } else {
          b(localTimeRspBody);
        }
      }
      return 0;
    }
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    localObject = jdField_b_of_type_JavaLangObject;
    if (paramAppInfo != null) {}
    try
    {
      if (!paramAppInfo.path.has()) {
        break label193;
      }
      localTimeRspBody = a();
      if (localTimeRspBody == null)
      {
        a("updateAppInfo failed,TimeRspBody is Empty");
        return -3;
      }
      localList = localTimeRspBody.rptMsgAppInfo.get();
      j = localList.size();
      i = 0;
    }
    finally
    {
      for (;;)
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody;
        List localList;
        int j;
        int i;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramAppInfo;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      if (!paramAppInfo.path.get().equals(((BusinessInfoCheckUpdate.AppInfo)localList.get(i)).path.get())) {
        break label217;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("path is same = ");
      localStringBuilder.append(paramAppInfo.path);
      a(localStringBuilder.toString());
      localList.set(i, paramAppInfo);
    }
    if (i == j) {
      if (paramBoolean) {
        localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
      } else {
        return -3;
      }
    }
    b(localTimeRspBody);
    return 0;
    label193:
    a("updateAppInfo failed , appInfo is empty or appInfo path is null");
    return -3;
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
    PBStringField localPBStringField = localRedTypeInfo.red_content;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("");
    localPBStringField.set(localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfoByPath path = ");
    ((StringBuilder)localObject).append(paramString);
    a(((StringBuilder)localObject).toString());
    int i = b(paramString, 100);
    if (i > 0)
    {
      int j = Integer.parseInt(paramString.split("\\.")[0]);
      localObject = a(j);
      if (localObject != null) {
        localObject = ((BusinessInfoCheckUpdate.NumRedInfo)localObject).extend.get();
      } else {
        localObject = "";
      }
      return a(paramInt, j, paramString, i, false, (String)localObject);
    }
    return b(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt, String paramString1, String paramString2)
  {
    long l;
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        l = Long.parseLong(paramString2);
      }
      catch (NumberFormatException paramString2)
      {
        QLog.e("RedPointLog.RedTouchManager", 1, paramString2, new Object[0]);
      }
    } else {
      l = -1L;
    }
    paramString2 = a(paramInt, paramString1);
    paramString1 = paramString2;
    if (paramString2 != null)
    {
      if (l == -1L) {
        return paramString2;
      }
      if (paramString2.id_list.get().contains(Long.valueOf(l))) {
        return paramString2;
      }
      paramString1 = null;
    }
    return paramString1;
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
    List localList1 = b(paramInt);
    Object localObject2 = null;
    if (localList1 != null)
    {
      if (localList1.size() == 0) {
        return null;
      }
      a(localList1, paramList);
      List localList2 = a();
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("getRedTouchInfoByAppSet:redpoint path List:");
      int i = 0;
      paramList = null;
      while (i < localList1.size())
      {
        Object localObject3 = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
        if (((BusinessInfoCheckUpdate.AppInfo)localObject3).mission_level.get() != 0)
        {
          localObject3 = localObject2;
        }
        else if (a(paramInt, localList2, (BusinessInfoCheckUpdate.AppInfo)localObject3))
        {
          localObject3 = localObject2;
        }
        else if ((!TextUtils.isEmpty(paramString)) && (!((BusinessInfoCheckUpdate.AppInfo)localObject3).id_list.get().contains(Long.valueOf(paramString))))
        {
          localObject3 = localObject2;
        }
        else
        {
          BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)((BusinessInfoCheckUpdate.AppInfo)localObject3).red_display_info.tab_display_info.get();
          if (localRedTypeInfo == null)
          {
            localObject3 = localObject2;
          }
          else if ((((BusinessInfoCheckUpdate.AppInfo)localObject3).uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5))
          {
            localObject3 = localObject2;
          }
          else
          {
            Object localObject1;
            if (paramList != null)
            {
              localObject1 = paramList;
              if (paramList.red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
            }
            else
            {
              localObject1 = localRedTypeInfo;
            }
            localStringBuilder.append(((BusinessInfoCheckUpdate.AppInfo)localObject3).path.get());
            localStringBuilder.append(",");
            if (localRedTypeInfo.red_type.get() == 5)
            {
              localObject3 = a((BusinessInfoCheckUpdate.RedTypeInfo)localObject2, (BusinessInfoCheckUpdate.AppInfo)localObject3, localRedTypeInfo, "getRedTouchInfoByAppSet, content=");
              paramList = (List<String>)localObject1;
            }
            else
            {
              localObject3 = localObject2;
              paramList = (List<String>)localObject1;
              if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_priority.get() < localRedTypeInfo.red_priority.get())
              {
                paramList = localRedTypeInfo;
                localObject3 = localObject2;
              }
            }
          }
        }
        i += 1;
        localObject2 = localObject3;
      }
      if (localObject2 != null) {
        return localObject2;
      }
      if (QLog.isColorLevel())
      {
        if (paramList != null)
        {
          paramString = new StringBuilder();
          paramString.append("getRedTouchInfoByAppSet appset = ");
          paramString.append(paramInt);
          paramString.append(";result != nullpathList = ");
          paramString.append(localStringBuilder.toString());
          QLog.e("RedPointLog.RedTouchManager", 2, paramString.toString());
          return paramList;
        }
        paramString = new StringBuilder();
        paramString.append("getRedTouchInfoByAppSet appset = ");
        paramString.append(paramInt);
        paramString.append(";result = null");
        QLog.e("RedPointLog.RedTouchManager", 2, paramString.toString());
      }
      return paramList;
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if ((!a()) && (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody != null))
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$TimeRspBody;
        return localTimeRspBody;
      }
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.post(new RedTouchManager.1(this), 5, null, true);
      } else {
        d();
      }
      QLog.e("RedPointLog.RedTouchManager", 1, "cache not ready ");
      return null;
    }
  }
  
  public String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAppInfo != null))
    {
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
      paramString.append("&status=");
      paramString.append(i);
      paramString.append("&number=");
      paramString.append(paramAppInfo.num.get());
      paramString.append("&path=");
      paramString.append(paramAppInfo.path.get());
      return paramString.toString();
    }
    a("url is empty or appInfo is Empty");
    return paramString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    Object localObject4;
    HashMap localHashMap;
    Object localObject3;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      localObject4 = new ArrayList();
      localHashMap = new HashMap();
      localObject3 = null;
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString2.has("msg"))
        {
          localObject2 = paramString2.getJSONObject("msg");
          Object localObject1 = localObject4;
          paramString2 = localHashMap;
          if (localObject2 != null)
          {
            Iterator localIterator = ((JSONObject)localObject2).keys();
            localObject1 = localObject4;
            paramString2 = localHashMap;
            if (localIterator.hasNext())
            {
              new JSONObject();
              localObject1 = (String)localIterator.next();
              paramString2 = ((JSONObject)localObject2).getJSONObject((String)localObject1);
              if (!paramString2.has("stat")) {
                break label412;
              }
              i = paramString2.getInt("stat");
              if (i != 2) {
                continue;
              }
              ((List)localObject4).add(localObject1);
              if (!paramString2.has("content")) {
                break label417;
              }
              paramString2 = paramString2.getString("content");
              localHashMap.put(localObject1, paramString2);
              continue;
            }
          }
          return "";
        }
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        localObject1 = null;
        paramString2 = (String)localObject1;
        if (paramString2 != null)
        {
          if (paramString2.size() < 1) {
            return "";
          }
          localObject2 = new ArrayList();
          localObject4 = a(paramString1);
          paramString1 = (String)localObject3;
          if (localObject4 != null) {
            paramString1 = ((BusinessInfoCheckUpdate.AppInfo)localObject4).buffer.get();
          }
          localObject3 = new ArrayList();
          localObject4 = new ArrayList();
          a(paramString1, (List)localObject3, (List)localObject4);
          paramString1 = a((List)localObject1, (List)localObject2, (List)localObject3, (List)localObject4);
          if (paramString1.size() > 0) {
            try
            {
              localObject1 = new JSONArray();
              i = 0;
              if (i < paramString1.size())
              {
                localObject2 = new JSONObject();
                localObject3 = (String)paramString1.get(i);
                ((JSONObject)localObject2).put((String)localObject3, (String)paramString2.get(localObject3));
                ((JSONArray)localObject1).put(localObject2);
                i += 1;
                continue;
              }
              paramString1 = ((JSONArray)localObject1).toString();
              return paramString1;
            }
            catch (Exception paramString1)
            {
              paramString1.printStackTrace();
            }
          }
        }
      }
      Object localObject2 = null;
      continue;
      label412:
      int i = -1;
      continue;
      label417:
      paramString2 = "";
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> a()
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = a();
      if ((localObject3 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.has()))
      {
        localObject3 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject3).rptSetting.get();
        if (localObject3 != null) {
          localArrayList.addAll((Collection)localObject3);
        }
        return localArrayList;
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
    if (paramAppInfo == null) {
      return null;
    }
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
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("");
    a(localStringBuilder.toString(), paramInt2);
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
    localReportReqBody.clientver.set("8.7.0.5295");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(paramInt2);
    Object localObject = localReportReqBody.platver;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("");
    ((PBStringField)localObject).set(localStringBuilder.toString());
    localReportReqBody.cmd.set(paramInt1);
    if (paramArrayList != null) {
      localReportReqBody.missionid.set(paramArrayList);
    }
    paramArrayList = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("check_update_sp_key", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("businessinfo_last_check_update_timestamp_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    paramInt1 = paramArrayList.getInt(((StringBuilder)localObject).toString(), 0);
    paramArrayList = null;
    localObject = paramArrayList;
    try
    {
      if (TextUtils.isEmpty(paramString3))
      {
        localObject = paramArrayList;
        paramArrayList = new JSONObject();
        try
        {
          paramArrayList.put("msg", "");
        }
        catch (Exception paramString1)
        {
          localObject = paramArrayList;
          paramArrayList = paramString1;
          break label310;
        }
      }
      else
      {
        localObject = paramArrayList;
        paramArrayList = new JSONObject(paramString3);
      }
      localObject = paramArrayList;
      paramArrayList.put("red", paramString1);
      localObject = paramArrayList;
      paramArrayList.put("ret", paramString2);
      localObject = paramArrayList;
      paramArrayList.put("lastTime", paramInt1);
      localObject = paramArrayList;
      paramArrayList.put("callback", paramString5);
      localObject = paramArrayList;
      paramArrayList.put("waterid", paramString4);
      paramString1 = paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      label310:
      paramString1 = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.e("RedPointLog.RedTouchManager", 2, "getAndSetAppInfoJsReport buffer json is empty", paramArrayList);
        paramString1 = (String)localObject;
      }
    }
    if (paramString1 != null) {
      localReportReqBody.buffer.set(paramString1.toString());
    }
    paramArrayList = a("RedTouchSvc.ClientReport");
    paramArrayList.putWupBuffer(localReportReqBody.toByteArray());
    a(paramArrayList);
  }
  
  public void a(long paramLong)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_JavaLangString.contains(".")) {
        return;
      }
      BusinessInfoCheckUpdate.AppInfo localAppInfo = a(this.jdField_a_of_type_JavaLangString);
      if (localAppInfo != null)
      {
        if (paramLong < 0L) {
          return;
        }
        paramLong = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("residenceReport time = ");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(";path = ");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          QLog.e("residenceReport", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaLangString = null;
        ThreadManager.post(new RedTouchManager.3(this, localAppInfo, paramLong), 2, null, true);
      }
    }
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
    localReportReqBody.clientver.set("8.7.0.5295");
    localReportReqBody.platid.set(109);
    Object localObject1 = localReportReqBody.platver;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append("");
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    if (paramJSONObject != null) {
      localReportReqBody.buffer.set(paramJSONObject.toString());
    }
    localReportReqBody.cmd.set(paramInt);
    if (paramAppInfo != null)
    {
      localReportReqBody.appid.set(RedTouchUtil.a(paramAppInfo.path.get()));
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
        paramString = paramJSONObject.keys();
        while (paramString.hasNext())
        {
          localObject1 = (String)paramString.next();
          localObject2 = new BusinessInfoCheckUpdate.ReportStaticsData();
          ((BusinessInfoCheckUpdate.ReportStaticsData)localObject2).key.set((String)localObject1);
          ((BusinessInfoCheckUpdate.ReportStaticsData)localObject2).value.set(paramJSONObject.getString((String)localObject1));
          paramAppInfo.add(localObject2);
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
    if (paramTimeRspBody != null)
    {
      if (!paramTimeRspBody.rptMsgAppInfo.has()) {
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localAppInfo.uiAppId.get());
          localStringBuilder.append("");
          paramTimeRspBody.add(localStringBuilder.toString());
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("level zero arrived, reportAppIdList:");
      ((StringBuilder)localObject).append(paramTimeRspBody);
      a(((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.iNewFlag.get() != 0))
    {
      if (paramInt != 30)
      {
        if (paramInt != 31) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchLifeTimeManager.a(paramString.buffer.get());
        a(paramString.path.get(), false);
        a(paramString, paramInt, true, null, null);
        ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        return;
      }
      d(paramString.path.get());
      if (paramString.exposure_max.get() >= 0) {
        a(paramString, paramInt, true, null, null);
      }
    }
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
          if ((a(localNumRedBusiInfo)) && (RedTouchUtils.a(localNumRedBusiInfo.str_client_ver_begin.get(), localNumRedBusiInfo.str_client_ver_end.get()))) {
            a(a(localNumRedBusiInfo.int32_appset.get(), localNumRedBusiInfo.uint32_app_id.get(), String.valueOf(localNumRedBusiInfo.uint64_msgid.get()), 1), 1, "", false, -1);
          }
        }
        a(paramArrayOfByte, 4);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
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
  
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    try
    {
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        byte[] arrayOfByte = paramTimeRspBody.toByteArray();
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          int i = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          File localFile = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("BusinessInfoCheckUpdateItem_new_1_");
          localStringBuilder.append((String)localObject1);
          boolean bool = FileUtils.pushData2File(new File(localFile, localStringBuilder.toString()).getAbsolutePath(), arrayOfByte, false);
          if (!bool) {
            QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody pushData2File failed");
          }
          localObject1 = jdField_b_of_type_JavaLangObject;
          if (bool) {}
          try
          {
            if (i == jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) {
              c(paramTimeRspBody);
            }
            return bool;
          }
          finally {}
        }
      }
    }
    catch (Exception paramTimeRspBody)
    {
      QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody exception e = ", paramTimeRspBody);
      return false;
      throw paramTimeRspBody;
    }
    catch (OutOfMemoryError paramTimeRspBody)
    {
      label167:
      break label167;
    }
    QLog.e("RedPointLog.RedTouchManager", 1, "saveTimeRepBody oom");
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo start");
    }
    try
    {
      a(paramArrayOfByte, 3);
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("push parse error : e = ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      QLog.e("RedPointLog.RedTouchManager", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.e("RedPointLog.RedTouchManager", 2, "parsePushRedTouchInfo end");
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      int k = 0;
      int i = 0;
      int j = k;
      if (localObject2 != null)
      {
        j = k;
        if (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.has())
        {
          localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgNumRedInfo.get();
          if (localObject2 == null)
          {
            a("getNumRedShowNumByAppSet : numRedBusiList is null");
            return 0;
          }
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            BusinessInfoCheckUpdate.NumRedInfo localNumRedInfo = (BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject2).next();
            if ((paramInt == localNumRedInfo.appset.get()) && (localNumRedInfo.appid.get() != 7719) && (a(localNumRedInfo.appid.get()))) {
              i += a(localNumRedInfo.appid.get(), 100);
            }
          }
        }
      }
      return j;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfoByPath path = ");
    ((StringBuilder)localObject).append(paramString);
    a(((StringBuilder)localObject).toString());
    int i = a(paramString, 100);
    if (i > 0)
    {
      int j = Integer.parseInt(paramString.split("\\.")[0]);
      localObject = a(j);
      if (localObject != null) {
        localObject = ((BusinessInfoCheckUpdate.NumRedInfo)localObject).extend.get();
      } else {
        localObject = "";
      }
      return a(paramInt, j, paramString, i, false, (String)localObject);
    }
    return null;
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> b(int paramInt)
  {
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      Object localObject2 = a();
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
      {
        Object localObject4 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
        localObject2 = new ArrayList();
        localObject4 = ((List)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject4).next();
          if (localAppInfo.appset.get() == paramInt) {
            ((List)localObject2).add(localAppInfo);
          }
        }
        return localObject2;
      }
      localObject2 = new ArrayList();
      return localObject2;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void b()
  {
    int j;
    label196:
    label203:
    label206:
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = a();
      j = 0;
      int i = j;
      if (localTimeRspBody != null)
      {
        i = j;
        if (localTimeRspBody.rptMsgNumRedInfo.has())
        {
          Object localObject3 = localTimeRspBody.rptMsgNumRedInfo.get();
          if (localObject3 == null) {
            return;
          }
          localObject3 = ((List)localObject3).iterator();
          i = 0;
          List localList;
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label206;
            }
            localList = ((BusinessInfoCheckUpdate.NumRedInfo)((Iterator)localObject3).next()).num_red_path.get();
            if (localList != null) {
              break;
            }
          }
          if (j >= localList.size()) {
            break label203;
          }
          BusinessInfoCheckUpdate.NumRedPath localNumRedPath = (BusinessInfoCheckUpdate.NumRedPath)localList.get(j);
          if (localNumRedPath.uint32_push_num_red_ts.get() + localNumRedPath.uint32_expire_time.get() >= (int)(System.currentTimeMillis() / 1000L)) {
            break label196;
          }
          localNumRedPath.uint32_msg_status.set(4);
          i = 1;
          break label196;
        }
      }
      if (i != 0) {
        b(localTimeRspBody);
      }
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder;
    if ((paramInt2 == 30) && ((this.jdField_a_of_type_Int & 1 << paramInt1) != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("red touch in appSet:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" had reported expose once,and expose switch is:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      a(localStringBuilder.toString());
      return;
    }
    if ((paramInt2 == 31) && ((this.jdField_b_of_type_Int & 1 << paramInt1) != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("red touch in appSet:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" had reported click once,and click switch is:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      a(localStringBuilder.toString());
      return;
    }
    if (paramInt2 == 30)
    {
      this.jdField_a_of_type_Int |= 1 << paramInt1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("expose switch changed:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      a(localStringBuilder.toString());
    }
    else if (paramInt2 == 31)
    {
      this.jdField_b_of_type_Int |= 1 << paramInt1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("click switch changed:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      a(localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().postDelayed(new RedTouchManager.5(this, paramInt1, paramInt2), 5000L);
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
    //   0: getstatic 32	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
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
    //   15: invokevirtual 52	com/tencent/mobileqq/redtouch/RedTouchManager:a	()Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +7 -> 29
    //   25: aload_3
    //   26: monitorexit
    //   27: iconst_1
    //   28: ireturn
    //   29: aload 4
    //   31: getfield 58	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   34: invokevirtual 68	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +59 -> 100
    //   44: aload 4
    //   46: invokeinterface 79 1 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 84 1 0
    //   60: ifeq +40 -> 100
    //   63: aload 4
    //   65: invokeinterface 88 1 0
    //   70: checkcast 90	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo
    //   73: astore 5
    //   75: aload 5
    //   77: getfield 94	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   80: invokevirtual 99	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   83: iload_1
    //   84: if_icmpne -31 -> 53
    //   87: aload 5
    //   89: getfield 1198	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$NumRedInfo:flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   92: invokevirtual 700	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   95: istore_2
    //   96: aload_3
    //   97: monitorexit
    //   98: iload_2
    //   99: ireturn
    //   100: aload_3
    //   101: monitorexit
    //   102: iconst_1
    //   103: ireturn
    //   104: astore 4
    //   106: aload_3
    //   107: monitorexit
    //   108: goto +6 -> 114
    //   111: aload 4
    //   113: athrow
    //   114: goto -3 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	RedTouchManager
    //   0	117	1	paramInt	int
    //   95	4	2	bool	boolean
    //   3	104	3	localObject1	Object
    //   104	8	4	localObject3	Object
    //   73	15	5	localNumRedInfo	BusinessInfoCheckUpdate.NumRedInfo
    // Exception table:
    //   from	to	target	type
    //   10	12	104	finally
    //   14	20	104	finally
    //   25	27	104	finally
    //   29	39	104	finally
    //   44	53	104	finally
    //   53	98	104	finally
    //   100	102	104	finally
    //   106	108	104	finally
  }
  
  public void c()
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
  
  /* Error */
  public void c(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +347 -> 348
    //   4: aload_2
    //   5: ifnull +343 -> 348
    //   8: aload_2
    //   9: invokevirtual 1234	java/lang/String:length	()I
    //   12: ifne +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: getfield 134	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   21: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   24: invokespecial 1063	com/tencent/mobileqq/redtouch/RedTouchManager:d	(Ljava/lang/String;)V
    //   27: new 307	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody
    //   30: dup
    //   31: invokespecial 308	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: getfield 311	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   39: aload_0
    //   40: getfield 41	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   43: invokevirtual 177	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 315	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   49: invokevirtual 318	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   52: aload_3
    //   53: getfield 321	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   56: ldc_w 323
    //   59: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   62: aload_3
    //   63: getfield 326	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   66: bipush 109
    //   68: invokevirtual 244	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   71: aload_3
    //   72: getfield 374	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   75: aload_1
    //   76: getfield 377	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   79: invokevirtual 379	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   82: invokevirtual 356	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   85: aload_3
    //   86: getfield 327	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: aload_1
    //   90: getfield 273	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 99	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: invokevirtual 244	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   99: aload_3
    //   100: getfield 334	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   103: astore_1
    //   104: new 111	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   111: astore 4
    //   113: aload 4
    //   115: getstatic 339	android/os/Build$VERSION:SDK_INT	I
    //   118: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 4
    //   124: ldc 156
    //   126: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_1
    //   131: aload 4
    //   133: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   139: aload_3
    //   140: getfield 342	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: iconst_5
    //   144: invokevirtual 244	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   147: new 279	java/util/ArrayList
    //   150: dup
    //   151: invokespecial 280	java/util/ArrayList:<init>	()V
    //   154: astore 4
    //   156: new 387	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 608	org/json/JSONObject:<init>	()V
    //   163: astore_1
    //   164: aload_1
    //   165: ldc_w 1235
    //   168: iconst_5
    //   169: invokevirtual 1018	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   172: pop
    //   173: new 387	org/json/JSONObject
    //   176: dup
    //   177: aload_2
    //   178: invokespecial 389	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   181: astore 5
    //   183: aload 5
    //   185: invokevirtual 392	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   188: astore 6
    //   190: aload_1
    //   191: astore_2
    //   192: aload 6
    //   194: invokeinterface 84 1 0
    //   199: ifeq +104 -> 303
    //   202: aload 6
    //   204: invokeinterface 88 1 0
    //   209: checkcast 209	java/lang/String
    //   212: astore_2
    //   213: new 394	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData
    //   216: dup
    //   217: invokespecial 395	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   220: astore 7
    //   222: aload 7
    //   224: getfield 398	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   227: aload_2
    //   228: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   231: aload 7
    //   233: getfield 401	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   236: aload 5
    //   238: aload_2
    //   239: invokevirtual 405	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   245: aload 4
    //   247: aload 7
    //   249: invokeinterface 216 2 0
    //   254: pop
    //   255: goto -65 -> 190
    //   258: astore_2
    //   259: goto +6 -> 265
    //   262: astore_2
    //   263: aconst_null
    //   264: astore_1
    //   265: new 111	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   272: astore 5
    //   274: aload 5
    //   276: ldc_w 1237
    //   279: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 5
    //   285: aload_2
    //   286: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 138
    //   292: iconst_1
    //   293: aload 5
    //   295: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: astore_2
    //   303: aload_2
    //   304: ifnull +14 -> 318
    //   307: aload_3
    //   308: getfield 423	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   311: aload_2
    //   312: invokevirtual 1025	org/json/JSONObject:toString	()Ljava/lang/String;
    //   315: invokevirtual 159	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   318: aload_3
    //   319: getfield 426	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   322: aload 4
    //   324: invokevirtual 427	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   327: aload_0
    //   328: ldc_w 429
    //   331: invokespecial 168	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   334: astore_1
    //   335: aload_1
    //   336: aload_3
    //   337: invokevirtual 433	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   340: invokevirtual 437	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   343: aload_0
    //   344: aload_1
    //   345: invokespecial 259	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   348: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	RedTouchManager
    //   0	349	1	paramAppInfo	BusinessInfoCheckUpdate.AppInfo
    //   0	349	2	paramString	String
    //   34	303	3	localReportReqBody	BusinessInfoCheckUpdate.ReportReqBody
    //   111	212	4	localObject1	Object
    //   181	113	5	localObject2	Object
    //   188	15	6	localIterator	Iterator
    //   220	28	7	localReportStaticsData	BusinessInfoCheckUpdate.ReportStaticsData
    // Exception table:
    //   from	to	target	type
    //   164	190	258	org/json/JSONException
    //   192	255	258	org/json/JSONException
    //   156	164	262	org/json/JSONException
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localObject != null) {
      if (a(paramString).iNewFlag.get() == 1) {
        ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString).commit();
      } else {
        ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      }
    }
    localObject = a(paramString);
    if (localObject != null) {
      if (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0) {
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, false, null, null);
      } else {
        a((BusinessInfoCheckUpdate.AppInfo)localObject, 14, true, null, null);
      }
    }
    a(paramString, false);
    setChanged();
    ((IRedTouchServer)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager
 * JD-Core Version:    0.7.0.1
 */