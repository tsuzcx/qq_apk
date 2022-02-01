package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class RedTouchManagerImpl
  implements IRedTouchManager
{
  private static final String TAG = "RedPointLog.RedTouchManagerImpl";
  private RedTouchManager mRedTouchManager;
  
  public String appToString(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return RedTouchManager.a(paramAppInfo);
  }
  
  public void checkMsgExpire()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b();
    }
  }
  
  public void conversationRemainReport()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.e();
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt1, paramInt2, paramString, paramInt3);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt1, paramInt2, paramString, paramInt3, paramBoolean);
    }
    return null;
  }
  
  public void dismissRedTouch(String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.d(paramString);
    }
  }
  
  public void getAndSetAppInfoJsReport(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramInt1, paramArrayList, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt2);
    }
  }
  
  public int getAppIdByPath(String paramString)
  {
    return RedTouchUtil.a(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfo(int paramInt, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt, paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.b(paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfoFilterByID(int paramInt, String paramString1, String paramString2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt, paramString1, paramString2);
    }
    return null;
  }
  
  public JSONObject getBufferExtParamAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.c(paramAppInfo);
    }
    return null;
  }
  
  public int getExtraNumRedTotalNum(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.b(paramInt);
    }
    return 0;
  }
  
  public String getLastClickPath(AppInterface paramAppInterface)
  {
    return RedTouchUtil.a(paramAppInterface);
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody getLocalTimeRspBody()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.d();
    }
    QLog.e("RedPointLog.RedTouchManagerImpl", 1, "warnning redtouch manager null");
    return null;
  }
  
  public void getNumRedMsgByMsgIdArray(long[] paramArrayOfLong, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramArrayOfLong, paramString, paramNumRedGetMsgCallback);
    }
  }
  
  public int getNumRedNumByAppIdAndMsgType(int paramInt1, int paramInt2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt1, paramInt2);
    }
    return 0;
  }
  
  public int getNumRedNumByPath(String paramString, int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramString, paramInt);
    }
    return 0;
  }
  
  public List<BusinessInfoCheckUpdate.NumRedPath> getNumRedPathListByAppId(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.c(paramInt);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getNumRedPointInfo(int paramInt, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.b(paramInt, paramString);
    }
    return null;
  }
  
  public int getNumRedShowNumByAppSet(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.e(paramInt);
    }
    return 0;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.g(paramInt);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.d(paramInt, paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString, List<String> paramList)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt, paramString, paramList);
    }
    return null;
  }
  
  public List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> getRegisterInterfaces()
  {
    return RedTouchConfigImpl.a;
  }
  
  public String getSetAppInfoReportMsg(String paramString1, String paramString2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean hasAppInfo(String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localRedTouchManager != null)
    {
      paramString = localRedTouchManager.b(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.iNewFlag.get() != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isNumRedTouchEnable(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.f(paramInt);
    }
    return false;
  }
  
  public boolean isUnShowMsgByAppId(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt);
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.mRedTouchManager = new RedTouchManager((AppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null)
    {
      localRedTouchManager.onDestroy();
      this.mRedTouchManager = null;
    }
  }
  
  public void onRedTouchItemClick(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramAppInfo, paramString);
    }
  }
  
  public void onRedTouchItemClick(String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.c(paramString);
    }
  }
  
  public void onRedTouchItemExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramAppInfo, paramString);
    }
  }
  
  public void onReportBusinessRedTouch(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.c(paramAppInfo, paramString);
    }
  }
  
  public void onReportNumRedPoint(int paramInt, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.c(paramInt, paramString);
    }
  }
  
  public void onReportRedPointClickWithMissions(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramAppInfo, paramBoolean, paramList);
    }
  }
  
  public void onReportRedPointExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramAppInfo);
    }
  }
  
  public void parseNumRedPushInfo(byte[] paramArrayOfByte)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramArrayOfByte);
    }
  }
  
  public boolean parsePushRedTouchInfo(byte[] paramArrayOfByte)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramArrayOfByte);
    }
    return false;
  }
  
  public void reportLevelOneRedInfo(int paramInt1, int paramInt2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramInt1, paramInt2);
    }
  }
  
  public void reportLevelOneRedInfo(String paramString, int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramString, paramInt);
    }
  }
  
  public void reportLevelZeroRedInfo(int paramInt1, int paramInt2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.c(paramInt1, paramInt2);
    }
  }
  
  public void reportRedTouchsArrived(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.b(paramTimeRspBody);
    }
  }
  
  public void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramAppInfo, paramJSONObject, paramInt);
    }
  }
  
  public void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramAppInfo, paramJSONObject, paramInt, paramString);
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet(int paramInt)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.d(paramInt);
    }
    return null;
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.c();
    }
    return null;
  }
  
  public void resetFlag()
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a();
    }
  }
  
  public void residenceReport(long paramLong)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      localRedTouchManager.a(paramLong);
    }
  }
  
  public boolean saveTimeRepBody(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramTimeRspBody);
    }
    return false;
  }
  
  public int updateAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramAppInfo, paramBoolean);
    }
    return 0;
  }
  
  public int updateSettingById(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramInt, paramBoolean1, paramLong, paramBoolean2);
    }
    return 0;
  }
  
  public String wrapperRedTouchUrl(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouchManager localRedTouchManager = this.mRedTouchManager;
    if (localRedTouchManager != null) {
      return localRedTouchManager.a(paramString, paramAppInfo);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchManagerImpl
 * JD-Core Version:    0.7.0.1
 */