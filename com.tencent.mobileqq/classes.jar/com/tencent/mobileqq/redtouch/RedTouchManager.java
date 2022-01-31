package com.tencent.mobileqq.redtouch;

import ahfn;
import ahfo;
import ahfp;
import ahfq;
import ahfr;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.app.RedpointHandler.RedPointHolder;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedDisplayInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedTypeInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.ReportAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.ReportVersion;

public class RedTouchManager
  extends Observable
  implements Manager
{
  protected long a;
  public AppInterface a;
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new ahfr(this);
  protected BusinessInfoCheckUpdate.TimeRspBody a;
  Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  public boolean a;
  
  public RedTouchManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
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
  
  private int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return 0;
    }
    if ((paramString1 != null) && (paramString2 == null)) {
      return 1;
    }
    if ((paramString1 == null) && (paramString2 != null)) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      try
      {
        if ((i < arrayOfString1.length) && (i < arrayOfString2.length))
        {
          j = Integer.parseInt(arrayOfString1[i]);
          k = Integer.parseInt(arrayOfString2[i]);
          if (j < k) {
            return -1;
          }
        }
        else
        {
          if (arrayOfString1.length > i) {
            return 1;
          }
          j = arrayOfString2.length;
          if (j <= i) {
            break;
          }
          return -1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        return paramString1.compareTo(paramString2);
      }
      if (j > k) {
        return 1;
      }
      i += 1;
    }
  }
  
  private BusinessInfoCheckUpdate.RedTypeInfo a(Submsgtype0x71.RedTypeInfo paramRedTypeInfo)
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(paramRedTypeInfo.uint32_red_type.get());
    localRedTypeInfo.red_content.set(paramRedTypeInfo.str_red_content.get());
    localRedTypeInfo.red_desc.set(paramRedTypeInfo.str_red_desc.get());
    localRedTypeInfo.red_priority.set(paramRedTypeInfo.uint32_red_priority.get());
    return localRedTypeInfo;
  }
  
  private ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), paramString);
  }
  
  private void a()
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
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = localTimeRspBody;
        a(false, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List paramList)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("7.6.3.3565");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramAppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(paramInt);
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      if (((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).q) {
        localReportReqBody.bHebaFlag.set(true);
      }
    }
    else if (paramBoolean)
    {
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label200;
      }
      localReportReqBody.missionid.set(paramList);
    }
    for (;;)
    {
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
      return;
      localReportReqBody.bHebaFlag.set(false);
      break;
      label200:
      if (paramAppInfo.missions.has()) {
        localReportReqBody.missionid.set(paramAppInfo.missions.get());
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
      localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
      localReportReqBody.clientver.set("7.6.3.3565");
      localReportReqBody.platid.set(109);
      localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
      localReportReqBody.buffer.set(paramJSONObject.toString());
      localReportReqBody.cmd.set(paramInt);
      if (paramAppInfo != null)
      {
        localReportReqBody.appid.set(a(paramAppInfo.path.get()));
        if (paramAppInfo.missions.has()) {
          localReportReqBody.missionid.set(paramAppInfo.missions.get());
        }
      }
      paramAppInfo = a("RedTouchSvc.ClientReport");
      paramAppInfo.putWupBuffer(localReportReqBody.toByteArray());
      a(paramAppInfo);
    }
  }
  
  private void a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody = paramTimeRspBody;
      return;
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
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, paramString);
    }
  }
  
  private void a(String paramString, List paramList)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("7.6.3.3565");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(a(paramString));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(19);
    if ((paramList != null) && (paramList.size() > 0)) {
      localReportReqBody.missionid.set(paramList);
    }
    paramString = a("RedTouchSvc.ClientReport");
    paramString.putWupBuffer(localReportReqBody.toByteArray());
    a(paramString);
  }
  
  public static void a(boolean paramBoolean, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = paramContext.getSharedPreferences("redTouchPref", 4);
    } while (paramContext == null);
    paramContext.edit().putBoolean("isCacheChange", paramBoolean).commit();
  }
  
  private boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (this.jdField_a_of_type_Boolean) {}
    return true;
  }
  
  private boolean a(String paramString)
  {
    paramString = a(paramString);
    Object localObject = (BusinessInfoCheckUpdate.RedDisplayInfo)paramString.red_display_info.get();
    if (localObject == null) {
      return false;
    }
    localObject = ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject).red_type_info.get();
    if ((localObject == null) || (((List)localObject).size() < 2)) {
      return false;
    }
    localObject = (BusinessInfoCheckUpdate.RedTypeInfo)((List)localObject).get(1);
    if (localObject == null) {
      return false;
    }
    return (((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.get() == 5) && (paramString.iNewFlag.get() != 0);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((a(paramString1, "7.6.3") == 1) && (!paramString1.equals("0"))) {}
    while ((a("7.6.3", paramString2) == -1) && (!paramString2.equals("0"))) {
      return false;
    }
    return true;
  }
  
  private boolean a(List paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if ((paramList != null) && (paramList.size() > 0))
      {
        int j = paramList.size();
        i = 0;
        while (i < j)
        {
          RedpointHandler.RedPointHolder localRedPointHolder = (RedpointHandler.RedPointHolder)paramList.get(i);
          if ((localRedPointHolder != null) && (paramString.equals(localRedPointHolder.jdField_a_of_type_Long + ""))) {
            return true;
          }
          i += 1;
        }
      }
      if ((RedpointHandler.a != null) && (RedpointHandler.a.contains(paramString))) {
        return true;
      }
      int i = 0;
      while (i < BusinessInfoCheckUpdateItem.a.length)
      {
        if (paramString.equals(BusinessInfoCheckUpdateItem.a[i][1])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private boolean a(Submsgtype0x71.ReportVersion paramReportVersion)
  {
    if ((paramReportVersion.int32_plant_id.get() != 109) && (paramReportVersion.int32_plant_id.get() != 109110)) {
      return false;
    }
    if (paramReportVersion.bool_allver.get()) {
      return true;
    }
    if ((paramReportVersion.rpt_str_version == null) || (paramReportVersion.rpt_str_version.get().size() < 1)) {
      return false;
    }
    paramReportVersion = paramReportVersion.rpt_str_version.get().iterator();
    while (paramReportVersion.hasNext())
    {
      String[] arrayOfString = ((String)paramReportVersion.next()).split("\\,");
      if (a(arrayOfString[0], arrayOfString[1])) {
        return true;
      }
    }
    return false;
  }
  
  private void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt, boolean paramBoolean, List paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(new ahfp(this, paramAppInfo, paramInt, paramBoolean, paramList), 2, null, true);
      return;
    }
    a(paramAppInfo, paramInt, paramBoolean, paramList);
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
  
  public int a(int paramInt, boolean paramBoolean, long paramLong)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = new BusinessInfoCheckUpdate.AppSetting();
        localAppSetting.appid.set(paramInt);
        localAppSetting.setting.set(paramBoolean);
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
              break label223;
            }
            localList.set(i, localAppSetting);
          }
          if (i == j) {
            localList.add(localAppSetting);
          }
          if (!a(localTimeRspBody)) {
            return -4;
          }
        }
        else
        {
          localTimeRspBody = new BusinessInfoCheckUpdate.TimeRspBody();
          localTimeRspBody.rptSetting.add(localAppSetting);
          if (!a(localTimeRspBody)) {
            return -4;
          }
        }
        return 0;
      }
      label223:
      i += 1;
    }
  }
  
  public int a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
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
            if (!paramBoolean) {
              break;
            }
            localTimeRspBody.rptMsgAppInfo.add(paramAppInfo);
          }
          if (a(localTimeRspBody)) {
            break label204;
          }
          return -4;
        }
      }
      finally {}
      i += 1;
    }
    return -3;
    label204:
    return 0;
  }
  
  public BusinessObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    return a(paramInt1, paramInt2, paramString, paramInt3, true);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    paramString = c(paramString);
    paramString.uiAppId.set(paramInt2);
    paramString.type.set(5);
    paramString.iNewFlag.set(1);
    paramString.appset.set(paramInt1);
    paramString.mission_level.set(0);
    BusinessInfoCheckUpdate.RedDisplayInfo localRedDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(9);
    localRedTypeInfo.red_content.set("-1");
    localRedTypeInfo.red_desc.set("");
    localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
    localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(5);
    localRedTypeInfo.red_content.set(paramInt3 + "");
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    localRedDisplayInfo.tab_display_info.set(localRedTypeInfo);
    localRedDisplayInfo.red_type_info.add(localRedTypeInfo);
    paramString.red_display_info.set(localRedDisplayInfo);
    if (paramBoolean)
    {
      a(paramString, true);
      RedpointHandler.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    return paramString;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("input path is Empty");
      return null;
    }
    a("getAppInfoByPath path = " + paramString);
    try
    {
      if (!paramString.contains("\\."))
      {
        i = Integer.valueOf(paramString).intValue();
        if ((i != -1) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
          QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        }
        return b(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = -1;
        continue;
        i = -1;
      }
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a()
  {
    return a(0);
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt)
  {
    List localList1 = a(paramInt);
    Object localObject4;
    if ((localList1 == null) || (localList1.size() == 0))
    {
      localObject4 = null;
      return localObject4;
    }
    List localList2 = b();
    Object localObject2 = null;
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append("getRedTouchInfoByAppSet:redpoint path List:");
    int i = 0;
    label62:
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (i < localList1.size())
    {
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localList1.get(i);
      if (localAppInfo.mission_level.get() != 0)
      {
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
      }
    }
    for (;;)
    {
      i += 1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
      break label62;
      Object localObject5 = localObject2;
      if (999999 != localAppInfo.uiAppId.get())
      {
        if (localAppInfo.path.get().contains("."))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localAppInfo.iNewFlag.get() != 1)
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        int j = 0;
        for (;;)
        {
          if ((j >= localList2.size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).appid.get()))
          {
            if ((j >= localList2.size()) || (((BusinessInfoCheckUpdate.AppSetting)localList2.get(j)).setting.get())) {
              break label298;
            }
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            break;
          }
          j += 1;
        }
        label298:
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = (BusinessInfoCheckUpdate.RedTypeInfo)localAppInfo.red_display_info.tab_display_info.get();
        if ((localAppInfo.uiAppId.get() == 100510) && (localRedTypeInfo.red_type.get() == 5) && (!a(localAppInfo)))
        {
          localObject4 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject4;
          continue;
        }
        if (localObject2 != null)
        {
          localObject4 = localObject2;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject4 = localRedTypeInfo;
        }
        localStringBuilder.append(localAppInfo.path.get()).append(",");
        if (localRedTypeInfo.red_type.get() == 5)
        {
          if (localObject1 == null)
          {
            localObject1 = localObject4;
            localObject2 = localRedTypeInfo;
            continue;
          }
          try
          {
            if (QLog.isDevelopLevel()) {
              QLog.e("RedPointManage", 4, "getRedTouchInfoByAppSet, content=" + localObject1.red_content.get() + ", path=" + localAppInfo.path.get() + ",redTypeInfoContent=" + localRedTypeInfo.red_content.get());
            }
            localObject2 = localObject1.red_content;
            localObject5 = new StringBuilder();
            j = Integer.parseInt(localObject1.red_content.get());
            ((PBStringField)localObject2).set(Integer.parseInt(localRedTypeInfo.red_content.get()) + j + "");
            localObject2 = localObject1;
            localObject1 = localObject4;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            localObject3 = localObject1;
            localObject1 = localObject4;
          }
          continue;
        }
        if (localObject4 != null)
        {
          localObject5 = localObject4;
          if (((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_priority.get() >= localRedTypeInfo.red_priority.get()) {}
        }
        else
        {
          localObject3 = localObject1;
          localObject1 = localRedTypeInfo;
          continue;
          localObject4 = localObject1;
          if (localObject1 != null) {
            break;
          }
          if (QLog.isColorLevel())
          {
            if (localObject3 == null) {
              break label710;
            }
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result != nullpathList = " + localStringBuilder.toString());
          }
          for (;;)
          {
            return localObject3;
            label710:
            QLog.e("RedPointManage", 2, "getRedTouchInfoByAppSet appset = " + paramInt + ";result = null");
          }
        }
      }
      Object localObject3 = localObject1;
      localObject1 = localObject5;
    }
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((!a()) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody != null))
      {
        BusinessInfoCheckUpdate.TimeRspBody localTimeRspBody = this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$TimeRspBody;
        return localTimeRspBody;
      }
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new ahfn(this), 5, null, true);
        return null;
      }
    }
    a();
    return null;
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
    int k = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject4;
    Object localObject5;
    Object localObject1;
    int i;
    try
    {
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("msg"))
      {
        paramString2 = paramString2.getJSONObject("msg");
        if (paramString2 == null) {
          break label233;
        }
        localObject4 = paramString2.keys();
        for (;;)
        {
          if (!((Iterator)localObject4).hasNext()) {
            break label233;
          }
          new JSONObject();
          localObject5 = (String)((Iterator)localObject4).next();
          localObject1 = paramString2.getJSONObject((String)localObject5);
          if (!((JSONObject)localObject1).has("stat")) {
            break;
          }
          i = ((JSONObject)localObject1).getInt("stat");
          label134:
          if (i == 2)
          {
            ((List)localObject2).add(localObject5);
            if (!((JSONObject)localObject1).has("content")) {
              break label225;
            }
            localObject1 = ((JSONObject)localObject1).getString("content");
            label170:
            ((Map)localObject3).put(localObject5, localObject1);
          }
        }
      }
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      localObject1 = null;
      for (paramString2 = null;; paramString2 = (String)localObject2)
      {
        if ((localObject1 != null) && (((Map)localObject1).size() >= 1)) {
          break label243;
        }
        return "";
        paramString2 = null;
        break;
        i = -1;
        break label134;
        label225:
        localObject1 = "";
        break label170;
        label233:
        localObject1 = localObject3;
      }
      label243:
      localObject2 = new ArrayList();
      paramString1 = a(paramString1);
      if (paramString1 == null) {}
    }
    label390:
    label530:
    label535:
    label540:
    label676:
    label682:
    for (paramString1 = paramString1.buffer.get();; paramString1 = null)
    {
      localObject3 = new ArrayList();
      localObject4 = new ArrayList();
      if (!TextUtils.isEmpty(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString1);
          if (!paramString1.has("msg")) {
            break label530;
          }
          paramString1 = paramString1.getJSONObject("msg");
          if (paramString1 != null)
          {
            localObject5 = paramString1.keys();
            while (((Iterator)localObject5).hasNext())
            {
              new JSONObject();
              String str = (String)((Iterator)localObject5).next();
              JSONObject localJSONObject = paramString1.getJSONObject(str);
              if (!localJSONObject.has("stat")) {
                break label535;
              }
              i = localJSONObject.getInt("stat");
              ((List)localObject4).add(str);
              if (i == 1) {
                ((List)localObject3).add(str);
              }
            }
          }
          if (localObject3 == null) {
            break label439;
          }
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
        }
      } else {
        if (((List)localObject3).size() >= 1) {
          break label540;
        }
      }
      label439:
      for (paramString1 = paramString2;; paramString1 = (String)localObject2)
      {
        label441:
        if ((paramString1 != null) && (paramString1.size() > 0)) {}
        for (;;)
        {
          try
          {
            paramString2 = new JSONArray();
            i = k;
            if (i < paramString1.size())
            {
              localObject2 = new JSONObject();
              localObject3 = (String)paramString1.get(i);
              ((JSONObject)localObject2).put((String)localObject3, (String)((Map)localObject1).get(localObject3));
              paramString2.put(localObject2);
              i += 1;
              continue;
              paramString1 = null;
              break;
              i = -1;
              break label390;
              i = 0;
              if (i >= paramString2.size()) {
                break label682;
              }
              paramString1 = (String)paramString2.get(i);
              if (!((List)localObject4).contains(paramString1))
              {
                ((List)localObject2).add(paramString1);
                paramString1 = (String)localObject2;
                break label441;
              }
              j = 0;
              if (j >= ((List)localObject3).size()) {
                break label676;
              }
              if (paramString1.equals((String)((List)localObject3).get(j)))
              {
                j = 1;
                if (j != 0) {
                  ((List)localObject2).add(paramString1);
                }
                i += 1;
                continue;
              }
              j += 1;
              continue;
            }
            paramString1 = paramString2.toString();
            return paramString1;
          }
          catch (Exception paramString1)
          {
            paramString1.printStackTrace();
            return "";
          }
          return "";
          int j = 0;
        }
      }
    }
  }
  
  public List a()
  {
    a("getVirtualAppInfoList");
    return a(3);
  }
  
  public List a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
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
  
  public List a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    Object localObject1 = a(paramAppInfo);
    ArrayList localArrayList;
    if ((localObject1 != null) && (((Map)localObject1).size() > 0))
    {
      localArrayList = new ArrayList();
      try
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = (JSONObject)((Map.Entry)localObject2).getValue();
          if ((str != null) && (localObject2 != null) && (((JSONObject)localObject2).has("blue_bar_stat")))
          {
            VipBannerInfo localVipBannerInfo = new VipBannerInfo();
            localVipBannerInfo.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
            localVipBannerInfo.jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("blue_bar_stat");
            localVipBannerInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("blue_content");
            localVipBannerInfo.jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("blue_type");
            localVipBannerInfo.jdField_a_of_type_JavaLangString = str;
            localVipBannerInfo.jdField_a_of_type_Long = (((JSONObject)localObject2).getLong("duration") * 1000L);
            localVipBannerInfo.c = ((JSONObject)localObject2).getString("blue_aid");
            localVipBannerInfo.d = ((JSONObject)localObject2).getString("link");
            localVipBannerInfo.e = ((JSONObject)localObject2).getString("blue_icon_url");
            localVipBannerInfo.f = ((JSONObject)localObject2).getString("blue_button_text");
            localArrayList.add(localVipBannerInfo);
            continue;
            return null;
          }
        }
      }
      catch (Exception paramAppInfo)
      {
        paramAppInfo.printStackTrace();
      }
    }
    return localArrayList;
  }
  
  public Map a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo != null)
    {
      Object localObject = paramAppInfo.buffer.get();
      if (!StringUtil.a((String)localObject)) {
        try
        {
          paramAppInfo = new HashMap();
          localObject = new JSONObject((String)localObject).getJSONObject("msg");
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (!StringUtil.a(str))
            {
              JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject(str);
              if (localJSONObject != null)
              {
                paramAppInfo.put(str, localJSONObject);
                continue;
                return null;
              }
            }
          }
        }
        catch (JSONException paramAppInfo)
        {
          paramAppInfo.printStackTrace();
        }
      }
    }
    return paramAppInfo;
  }
  
  public void a(int paramInt1, ArrayList paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("7.6.3.3565");
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
        break label307;
      }
      paramArrayList = new JSONObject(paramString3);
      continue;
      label307:
      paramString1 = paramString3;
      if (QLog.isColorLevel())
      {
        QLog.e("RedPointManage", 2, "getAndSetAppInfoJsReport buffer json is empty", paramArrayList);
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
    ThreadManager.post(new ahfo(this, localAppInfo, paramLong), 2, null, true);
  }
  
  public void a(RedTouchManager.BannerInfoHandler paramBannerInfoHandler)
  {
    label4:
    Object localObject1;
    if (paramBannerInfoHandler == null) {
      return;
    } else {
      do
      {
        localObject1 = a();
      } while (localObject1 == null);
    }
    Object localObject2;
    label64:
    do
    {
      localObject1 = ((List)localObject1).iterator();
      break label64;
      if (!((Iterator)localObject1).hasNext()) {
        break label4;
      }
      localObject2 = a((BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject1).next());
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
    } while (!paramBannerInfoHandler.a((VipBannerInfo)((Iterator)localObject2).next()));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while (paramAppInfo.iNewFlag.get() == 0) {
      return;
    }
    b(paramAppInfo, 1, true, null);
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject;
    if ((paramAppInfo != null) && (paramString != null))
    {
      localObject = paramAppInfo.buffer.get();
      if (StringUtil.a((String)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("msg").getJSONObject(paramString);
      if ((localJSONObject != null) && (localJSONObject.getInt("blue_bar_stat") == 1))
      {
        localJSONObject.put("blue_bar_stat", 2);
        paramAppInfo.buffer.set(((JSONObject)localObject).toString());
        a(paramAppInfo, false);
        a(paramAppInfo, paramString, 2);
      }
      return;
    }
    catch (Exception paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString, int paramInt)
  {
    JSONObject localJSONObject;
    if (((paramAppInfo != null) && (3 == paramInt)) || (2 == paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "onReportRenewBannerExposure");
      }
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("cmd", paramInt);
      localJSONObject.put("missionid", paramString);
      a(paramAppInfo, localJSONObject, paramInt);
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onReportRedPointClickWithMissions");
    }
    if (paramAppInfo == null)
    {
      QLog.e("RedPointManage", 1, "onReportRedPointClickWithMissions appinfo = null");
      return;
    }
    b(paramAppInfo, 6, paramBoolean, paramList);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "setNewStatusByID,path = " + paramString);
    }
    if (a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "BusinessInfoCheckUpdateItem pb file does not exist");
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
              break label240;
            }
            if ((((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 1) && (!paramBoolean)) {
              ((BusinessInfoCheckUpdate.AppInfo)localObject).modify_ts.set((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            }
            PBInt32Field localPBInt32Field = ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag;
            if (!paramBoolean) {
              break label234;
            }
            localPBInt32Field.set(j);
            localTimeRspBody.rptMsgAppInfo.set(i, (MessageMicro)localObject);
            localObject = (GameCenterManagerImp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(11);
            if (localObject != null) {
              ((GameCenterManagerImp)localObject).a(paramString);
            }
          }
        }
        ThreadManager.post(new ahfq(this, localTimeRspBody), 8, null, true);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label234:
      j = 0;
      continue;
      label240:
      i += 1;
    }
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localSharedPreferences == null) {
      return true;
    }
    return localSharedPreferences.getBoolean("isCacheChange", true);
  }
  
  /* Error */
  public boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mobileqq/redtouch/RedTouchManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: iload_1
    //   8: ifne +7 -> 15
    //   11: aload_3
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: aload_0
    //   16: invokevirtual 513	com/tencent/mobileqq/redtouch/RedTouchManager:a	()Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnonnull +7 -> 30
    //   26: aload_3
    //   27: monitorexit
    //   28: iconst_1
    //   29: ireturn
    //   30: aload 4
    //   32: getfield 886	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgNumRedInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   35: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +66 -> 108
    //   45: aload 4
    //   47: invokeinterface 457 1 0
    //   52: astore 4
    //   54: aload 4
    //   56: invokeinterface 462 1 0
    //   61: ifeq +47 -> 108
    //   64: aload 4
    //   66: invokeinterface 466 1 0
    //   71: checkcast 888	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo
    //   74: astore 5
    //   76: aload 5
    //   78: getfield 889	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   81: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   84: iload_1
    //   85: if_icmpne -31 -> 54
    //   88: aload 5
    //   90: getfield 892	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$NumRedInfo:flag	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   93: invokevirtual 450	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   96: istore_2
    //   97: aload_3
    //   98: monitorexit
    //   99: iload_2
    //   100: ireturn
    //   101: astore 4
    //   103: aload_3
    //   104: monitorexit
    //   105: aload 4
    //   107: athrow
    //   108: aload_3
    //   109: monitorexit
    //   110: iconst_1
    //   111: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	RedTouchManager
    //   0	112	1	paramInt	int
    //   96	4	2	bool	boolean
    //   4	105	3	localObject1	Object
    //   101	5	4	localObject3	Object
    //   74	15	5	localNumRedInfo	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.NumRedInfo
    // Exception table:
    //   from	to	target	type
    //   11	13	101	finally
    //   15	21	101	finally
    //   26	28	101	finally
    //   30	40	101	finally
    //   45	54	101	finally
    //   54	99	101	finally
    //   103	105	101	finally
    //   108	110	101	finally
  }
  
  public boolean a(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        boolean bool = FileUtils.a(new File(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + str).getAbsolutePath(), paramTimeRspBody.toByteArray(), false);
        if (bool) {
          GameCenterManagerImp.a.put(str, Boolean.valueOf(false));
        }
        if (bool) {
          a(paramTimeRspBody);
        }
        return bool;
      }
      catch (Exception paramTimeRspBody)
      {
        QLog.e("RedPointManage", 1, "saveTimeRepBody exception e = ", paramTimeRspBody);
        return false;
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "parsePushRedTouchInfo start");
    }
    if (paramArrayOfByte != null) {}
    label927:
    label937:
    label939:
    for (;;)
    {
      try
      {
        localObject1 = new Submsgtype0x71.MsgBody();
        ((Submsgtype0x71.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        Object localObject3 = ((Submsgtype0x71.MsgBody)localObject1).rpt_msg_app_info.get();
        if (localObject3 == null) {
          break label937;
        }
        if (((List)localObject3).size() < 1) {
          return false;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          break label937;
        }
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label927;
        }
        paramArrayOfByte = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if (paramArrayOfByte == null) {
          break label937;
        }
        paramArrayOfByte.getEntityManagerFactory().createEntityManager();
        if (paramArrayOfByte.q)
        {
          localObject1 = RedpointHandler.b(paramArrayOfByte);
          localObject2 = ((List)localObject3).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Submsgtype0x71.ReportAppInfo)((Iterator)localObject2).next();
            if (3 == ((Submsgtype0x71.ReportAppInfo)localObject4).int32_appset.get()) {
              continue;
            }
            localObject4 = ((Submsgtype0x71.ReportAppInfo)localObject4).str_android_path.get();
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              break label937;
            }
            if (a((List)localObject1, (String)localObject4)) {
              continue;
            }
            return false;
          }
        }
        else
        {
          localObject1 = RedpointHandler.a(paramArrayOfByte);
          continue;
        }
        localObject2 = new StringBuilder(((List)localObject3).size() * 32);
        ((StringBuilder)localObject2).append("push clear red:path = ");
        localObject3 = ((List)localObject3).iterator();
        bool = false;
        try
        {
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          localObject6 = (Submsgtype0x71.ReportAppInfo)((Iterator)localObject3).next();
          if (!a((Submsgtype0x71.ReportVersion)((Submsgtype0x71.ReportAppInfo)localObject6).msg_version_info.get())) {
            continue;
          }
          localObject4 = a(((Submsgtype0x71.ReportAppInfo)localObject6).str_android_path.get());
          if (!a(((Submsgtype0x71.ReportAppInfo)localObject6).str_android_path.get())) {
            continue;
          }
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).missions.add(((Submsgtype0x71.ReportAppInfo)localObject6).str_mission.get());
          a((BusinessInfoCheckUpdate.AppInfo)localObject4, true);
          continue;
          paramArrayOfByte.printStackTrace();
        }
        catch (Exception paramArrayOfByte) {}
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject1;
        Object localObject2;
        Object localObject4;
        Object localObject6;
        int i;
        Object localObject5;
        Submsgtype0x71.RedTypeInfo localRedTypeInfo;
        bool = false;
        continue;
        continue;
      }
      QLog.e("RedPointManage", 1, "push parse error : e = " + paramArrayOfByte.getMessage());
      if (QLog.isColorLevel()) {
        QLog.e("RedPointManage", 2, "parsePushRedTouchInfo end");
      }
      return bool;
      if (localObject4 != null)
      {
        i = ((Submsgtype0x71.ReportAppInfo)localObject6).int32_new_flag.get();
        localObject5 = new ArrayList();
        ((List)localObject5).add(((Submsgtype0x71.ReportAppInfo)localObject6).str_mission.get());
        if (i == 1)
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).uiAppId.set(((Submsgtype0x71.ReportAppInfo)localObject6).uint32_android_app_id.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).appset.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_appset.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_new_flag.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).type.set(((Submsgtype0x71.ReportAppInfo)localObject6).uint32_type.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).buffer.set(((Submsgtype0x71.ReportAppInfo)localObject6).str_buffer.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).missions.set((List)localObject5);
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).num.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_num.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).icon_url.set(((Submsgtype0x71.ReportAppInfo)localObject6).str_icon_url.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).icon_flag.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_icon_flag.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).icon_type.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_icon_type.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).push_red_ts.set(((Submsgtype0x71.ReportAppInfo)localObject6).uint32_push_red_ts.get());
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).mission_level.set(((Submsgtype0x71.ReportAppInfo)localObject6).int32_mission_level.get());
          localObject5 = new BusinessInfoCheckUpdate.RedDisplayInfo();
          if (((Submsgtype0x71.ReportAppInfo)localObject6).msg_display_desc.has())
          {
            ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject5).tab_display_info.set(a((Submsgtype0x71.RedTypeInfo)((Submsgtype0x71.ReportAppInfo)localObject6).msg_display_desc.msg_tab_display_info.get()));
            localObject6 = ((Submsgtype0x71.ReportAppInfo)localObject6).msg_display_desc.rpt_msg_red_type_info.get().iterator();
            if (((Iterator)localObject6).hasNext())
            {
              localRedTypeInfo = (Submsgtype0x71.RedTypeInfo)((Iterator)localObject6).next();
              ((BusinessInfoCheckUpdate.RedDisplayInfo)localObject5).red_type_info.add(a((Submsgtype0x71.RedTypeInfo)localRedTypeInfo.get()));
              continue;
            }
          }
          ((BusinessInfoCheckUpdate.AppInfo)localObject4).red_display_info.set((MessageMicro)localObject5);
          if (!RedpointHandler.a((List)localObject1, (BusinessInfoCheckUpdate.AppInfo)localObject4)) {
            break label937;
          }
          a("redpush path = " + ((BusinessInfoCheckUpdate.AppInfo)localObject4).path.get() + " inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get());
          a((BusinessInfoCheckUpdate.AppInfo)localObject4, true);
          localObject5 = new JSONObject();
          try
          {
            ((JSONObject)localObject5).put("cmd", 1);
            a((BusinessInfoCheckUpdate.AppInfo)localObject4, (JSONObject)localObject5, 1);
            bool = true;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            continue;
          }
        }
        if (i == 0)
        {
          ((RedpointHandler)paramArrayOfByte.a(87)).a(true, true);
          localObject4 = localJSONException.str_android_path.get();
          a((String)localObject4, (List)localObject5);
          try
          {
            ((StringBuilder)localObject2).append((String)localObject4).append(";");
            bool = true;
          }
          catch (Exception paramArrayOfByte)
          {
            bool = true;
          }
          QLog.e("RedPointManage", 1, ((StringBuilder)localObject2).toString());
          continue;
        }
      }
      break label939;
      paramArrayOfByte = null;
      continue;
      boolean bool = false;
      continue;
      return false;
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo b(String paramString)
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
    synchronized (this.jdField_a_of_type_JavaLangObject)
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
  
  public BusinessInfoCheckUpdate.RedTypeInfo b()
  {
    return a(1);
  }
  
  public List b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
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
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {
      return;
    }
    if (paramAppInfo.iNewFlag.get() == 0)
    {
      b(paramAppInfo, 6, false, null);
      return;
    }
    b(paramAppInfo, 6, true, null);
  }
  
  public void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if ((paramAppInfo == null) || (paramString == null) || (paramString.length() == 0)) {
      return;
    }
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    localReportReqBody.clientver.set("7.6.3.3565");
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
          break label253;
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
        label253:
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
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("onRedTouchItemClick path is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RedPointManage", 2, "onRedTouchItemClick path = " + paramString);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramString);
    if (localAppInfo.iNewFlag.get() == 1) {
      localSharedPreferences.edit().putString("lastClickPath", paramString).commit();
    }
    for (;;)
    {
      if (!paramString.contains("."))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      b(localAppInfo);
      a(paramString, false);
      setChanged();
      notifyObservers(localAppInfo);
      return;
      localSharedPreferences.edit().putString("lastClickPath", "").commit();
    }
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo c()
  {
    return a(6);
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
          break label140;
        }
        b((BusinessInfoCheckUpdate.AppInfo)localObject, 14, false, null);
      }
    }
    for (;;)
    {
      a(paramString, false);
      setChanged();
      notifyObservers(localObject);
      return;
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
      break;
      label140:
      b((BusinessInfoCheckUpdate.AppInfo)localObject, 14, true, null);
    }
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      a("dismissRedTouchLocal path is empty");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences("redTouchPref", 4);
    if (localObject != null)
    {
      if (a(paramString).iNewFlag.get() != 1) {
        break label91;
      }
      ((SharedPreferences)localObject).edit().putString("lastClickPath", paramString).commit();
    }
    for (;;)
    {
      localObject = a(paramString);
      a(paramString, false);
      setChanged();
      notifyObservers(localObject);
      return;
      label91:
      ((SharedPreferences)localObject).edit().putString("lastClickPath", "").commit();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager
 * JD-Core Version:    0.7.0.1
 */