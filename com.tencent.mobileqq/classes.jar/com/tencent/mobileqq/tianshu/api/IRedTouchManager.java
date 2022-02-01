package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumRedPath;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(needUin=false, process={""})
public abstract interface IRedTouchManager
  extends IRuntimeService
{
  public abstract String appToString(BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract void checkMsgExpire();
  
  public abstract void conversationRemainReport();
  
  public abstract BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  public abstract BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean);
  
  public abstract void dismissRedTouch(String paramString);
  
  public abstract void getAndSetAppInfoJsReport(int paramInt1, ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2);
  
  public abstract int getAppIdByPath(String paramString);
  
  public abstract BusinessInfoCheckUpdate.AppInfo getAppInfo(int paramInt, String paramString);
  
  public abstract BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString);
  
  public abstract BusinessInfoCheckUpdate.AppInfo getAppInfoFilterByID(int paramInt, String paramString1, String paramString2);
  
  public abstract JSONObject getBufferExtParamAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract int getExtraNumRedTotalNum(int paramInt);
  
  public abstract String getLastClickPath();
  
  public abstract BusinessInfoCheckUpdate.TimeRspBody getLocalTimeRspBody();
  
  public abstract void getNumRedMsgByMsgIdArray(long[] paramArrayOfLong, String paramString, NumRedGetMsgCallback paramNumRedGetMsgCallback);
  
  public abstract int getNumRedNumByAppIdAndMsgType(int paramInt1, int paramInt2);
  
  public abstract int getNumRedNumByPath(String paramString, int paramInt);
  
  public abstract List<BusinessInfoCheckUpdate.NumRedPath> getNumRedPathListByAppId(int paramInt);
  
  public abstract BusinessInfoCheckUpdate.AppInfo getNumRedPointInfo(int paramInt, String paramString);
  
  public abstract int getNumRedShowNumByAppSet(int paramInt);
  
  public abstract BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt);
  
  public abstract BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString);
  
  public abstract BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int paramInt, String paramString, List<String> paramList);
  
  public abstract List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> getRegisterInterfaces();
  
  public abstract String getSetAppInfoReportMsg(String paramString1, String paramString2);
  
  public abstract boolean isNumRedTouchEnable(int paramInt);
  
  public abstract boolean isUnShowMsgByAppId(int paramInt);
  
  public abstract void onRedTouchItemClick(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString);
  
  public abstract void onRedTouchItemClick(String paramString);
  
  public abstract void onRedTouchItemExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString);
  
  public abstract void onReportBusinessRedTouch(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString);
  
  public abstract void onReportNumRedPoint(int paramInt, String paramString);
  
  public abstract void onReportRedPointClickWithMissions(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean, List<String> paramList);
  
  public abstract void onReportRedPointExposure(BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract void parseNumRedPushInfo(byte[] paramArrayOfByte);
  
  public abstract boolean parsePushRedTouchInfo(byte[] paramArrayOfByte);
  
  public abstract void reportLevelOneRedInfo(int paramInt1, int paramInt2);
  
  public abstract void reportLevelOneRedInfo(String paramString, int paramInt);
  
  public abstract void reportLevelZeroRedInfo(int paramInt1, int paramInt2);
  
  public abstract void reportRedTouchsArrived(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody);
  
  public abstract void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt);
  
  public abstract void reportStatistic(BusinessInfoCheckUpdate.AppInfo paramAppInfo, JSONObject paramJSONObject, int paramInt, String paramString);
  
  public abstract List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet(int paramInt);
  
  public abstract List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList();
  
  public abstract void residenceReport(long paramLong);
  
  public abstract boolean saveTimeRepBody(BusinessInfoCheckUpdate.TimeRspBody paramTimeRspBody);
  
  public abstract int updateAppInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean);
  
  public abstract int updateSettingById(int paramInt, boolean paramBoolean1, long paramLong, boolean paramBoolean2);
  
  public abstract String wrapperRedTouchUrl(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IRedTouchManager
 * JD-Core Version:    0.7.0.1
 */