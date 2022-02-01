package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class RedTouchManagerImpl
  implements IRedTouchManager
{
  static final List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> S_DYNAMIC_RED_POINT_PATH_LIST = new RedTouchManagerImpl.1();
  private static final String TAG = "RedPointLog.RedTouchManagerImpl";
  private RedTouchManager mRedTouchManager;
  
  public String appToString(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return RedTouchManager.a(paramAppInfo);
  }
  
  public void checkMsgExpire()
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a();
    }
  }
  
  public void conversationRemainReport()
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.b();
    }
  }
  
  public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt1, paramInt2, paramString, paramInt3);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt1, paramInt2, paramString, paramInt3, paramBoolean);
    }
    return null;
  }
  
  public void dismissRedTouch(String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.c(paramString);
    }
  }
  
  public void getAndSetAppInfoJsReport(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramInt1, paramArrayList, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt2);
    }
  }
  
  public int getAppIdByPath(String paramString)
  {
    return RedTouchManager.a(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfo(int paramInt, String paramString)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt, paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getAppInfoFilterByID(int paramInt, String paramString1, String paramString2)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt, paramString1, paramString2);
    }
    return null;
  }
  
  public JSONObject getBufferExtParamAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramAppInfo);
    }
    return null;
  }
  
  public int getExtraNumRedTotalNum(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt);
    }
    return 0;
  }
  
  public String getLastClickPath()
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a();
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.TimeRspBody getLocalTimeRspBody()
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a();
    }
    QLog.e("RedPointLog.RedTouchManagerImpl", 1, "warnning redtouch manager null");
    return null;
  }
  
  public void getNumRedMsgByMsgIdArray(long[] paramArrayOfLong, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramArrayOfLong, paramString, paramNumRedGetMsgCallback);
    }
  }
  
  public int getNumRedNumByAppIdAndMsgType(int paramInt1, int paramInt2)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt1, paramInt2);
    }
    return 0;
  }
  
  public int getNumRedNumByPath(String paramString, int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramString, paramInt);
    }
    return 0;
  }
  
  public List<BusinessInfoCheckUpdate.NumRedPath> getNumRedPathListByAppId(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo getNumRedPointInfo(int paramInt, String paramString)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.b(paramInt, paramString);
    }
    return null;
  }
  
  public int getNumRedShowNumByAppSet(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.b(paramInt);
    }
    return 0;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt, paramString);
    }
    return null;
  }
  
  public BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString, List<String> paramList)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt, paramString, paramList);
    }
    return null;
  }
  
  public List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> getRegisterInterfaces()
  {
    return S_DYNAMIC_RED_POINT_PATH_LIST;
  }
  
  public String getSetAppInfoReportMsg(String paramString1, String paramString2)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramString1, paramString2);
    }
    return null;
  }
  
  public boolean isNumRedTouchEnable(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.b(paramInt);
    }
    return false;
  }
  
  public boolean isUnShowMsgByAppId(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt);
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mRedTouchManager = ((RedTouchManager)paramAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH));
    }
  }
  
  public void onDestroy()
  {
    if (this.mRedTouchManager != null)
    {
      this.mRedTouchManager.onDestroy();
      this.mRedTouchManager = null;
    }
  }
  
  public void onRedTouchItemClick(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramAppInfo, paramString);
    }
  }
  
  public void onRedTouchItemClick(String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.b(paramString);
    }
  }
  
  public void onRedTouchItemExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.b(paramAppInfo, paramString);
    }
  }
  
  public void onReportBusinessRedTouch(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.c(paramAppInfo, paramString);
    }
  }
  
  public void onReportNumRedPoint(int paramInt, String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramInt, paramString);
    }
  }
  
  public void onReportRedPointClickWithMissions(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramAppInfo, paramBoolean, paramList);
    }
  }
  
  public void onReportRedPointExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramAppInfo);
    }
  }
  
  public void parseNumRedPushInfo(byte[] paramArrayOfByte)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramArrayOfByte);
    }
  }
  
  public boolean parsePushRedTouchInfo(byte[] paramArrayOfByte)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramArrayOfByte);
    }
    return false;
  }
  
  public void reportLevelOneRedInfo(int paramInt1, int paramInt2)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramInt1, paramInt2);
    }
  }
  
  public void reportLevelOneRedInfo(String paramString, int paramInt)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramString, paramInt);
    }
  }
  
  public void reportLevelZeroRedInfo(int paramInt1, int paramInt2)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.b(paramInt1, paramInt2);
    }
  }
  
  public void reportRedTouchsArrived(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramTimeRspBody);
    }
  }
  
  public void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramAppInfo, paramJSONObject, paramInt);
    }
  }
  
  public void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramAppInfo, paramJSONObject, paramInt, paramString);
    }
  }
  
  public List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet(int paramInt)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.b(paramInt);
    }
    return null;
  }
  
  public List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList()
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a();
    }
    return null;
  }
  
  public void residenceReport(long paramLong)
  {
    if (this.mRedTouchManager != null) {
      this.mRedTouchManager.a(paramLong);
    }
  }
  
  public boolean saveTimeRepBody(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramTimeRspBody);
    }
    return false;
  }
  
  public int updateAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramAppInfo, paramBoolean);
    }
    return 0;
  }
  
  public int updateSettingById(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramInt, paramBoolean1, paramLong, paramBoolean2);
    }
    return 0;
  }
  
  public String wrapperRedTouchUrl(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (this.mRedTouchManager != null) {
      return this.mRedTouchManager.a(paramString, paramAppInfo);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchManagerImpl
 * JD-Core Version:    0.7.0.1
 */