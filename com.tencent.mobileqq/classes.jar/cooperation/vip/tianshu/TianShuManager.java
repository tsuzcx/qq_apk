package cooperation.vip.tianshu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.vip.VasC2SReporter;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.AdPosItem;
import cooperation.vip.pb.TianShuAccess.CommInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsReq;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.MapEntry;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportReq;
import cooperation.vip.pb.TianShuReport.UserActionMultiReportRsp;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import cooperation.vip.utils.Tools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class TianShuManager
{
  public static final String KEY_VAS_NEXT_REQUEST_TIME = "next_request_time_";
  private static final String SP_NAME = "tianshu_manager";
  private static final String SP_TIME_DELAY_KEY = "time_delay";
  private static final String TAG = "TianShuManager";
  private static TianShuManager mInstance;
  private ConcurrentHashMap<Integer, TianShuGetAdvCallback> mCallbackHashMap = new ConcurrentHashMap();
  private final AtomicBoolean mLockFlag = new AtomicBoolean(false);
  private final ArrayList<TianShuReportData> mReportList = new ArrayList();
  private final ConcurrentHashMap<String, String> mTianshuTraceInfoCache = new ConcurrentHashMap();
  private long mTimeDelay = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).getLong("time_delay", 3000L);
  
  private void cacheNecessaryDataForReport(List<TianShuAccess.RspEntry> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ArrayList)localObject).addAll(((TianShuAccess.AdPlacementInfo)((TianShuAccess.RspEntry)paramList.next()).value.get()).lst.get());
      }
      paramList = ((ArrayList)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (TianShuAccess.AdItem)paramList.next();
        VasC2SReporter.a().a((TianShuAccess.AdItem)localObject);
        cacheTraceInfo((TianShuAccess.AdItem)localObject);
      }
    }
  }
  
  private void cacheTraceInfo(TianShuAccess.AdItem paramAdItem)
  {
    if (paramAdItem == null) {
      return;
    }
    String str = String.valueOf(paramAdItem.iAdId.get());
    paramAdItem = paramAdItem.traceinfo.get();
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramAdItem)))
    {
      this.mTianshuTraceInfoCache.put(str, paramAdItem);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cacheTraceInfo mTianshuTraceInfoCache done:");
      localStringBuilder.append(str);
      localStringBuilder.append("---");
      localStringBuilder.append(paramAdItem);
      QLog.i("TianShuManager", 1, localStringBuilder.toString());
    }
  }
  
  private boolean checkRepEntryHasData(TianShuAccess.RspEntry paramRspEntry)
  {
    return (paramRspEntry == null) || (paramRspEntry.value == null) || (paramRspEntry.value.lst.size() == 0) || (paramRspEntry.value.lst.get(0) == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList == null) || (((TianShuAccess.AdItem)paramRspEntry.value.lst.get(0)).argList.get() == null);
  }
  
  private static TianShuAccess.AdPosItem convertAdItemToPb(TianShuAdPosItemData paramTianShuAdPosItemData)
  {
    TianShuAccess.AdPosItem localAdPosItem = new TianShuAccess.AdPosItem();
    localAdPosItem.posId.set(paramTianShuAdPosItemData.a);
    localAdPosItem.nNeedCnt.set(paramTianShuAdPosItemData.b);
    if (paramTianShuAdPosItemData.c != null)
    {
      paramTianShuAdPosItemData = paramTianShuAdPosItemData.c.entrySet().iterator();
      while (paramTianShuAdPosItemData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramTianShuAdPosItemData.next();
        TianShuAccess.MapEntry localMapEntry = new TianShuAccess.MapEntry();
        localMapEntry.key.set(String.valueOf(localEntry.getKey()));
        localMapEntry.value.set(String.valueOf(localEntry.getValue()));
        localAdPosItem.extra_info.add(localMapEntry);
      }
    }
    return localAdPosItem;
  }
  
  private void doReport(ArrayList<TianShuReportData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      TianShuReport.UserActionMultiReportReq localUserActionMultiReportReq = new TianShuReport.UserActionMultiReportReq();
      NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), TianShuServlet.class);
      localUserActionMultiReportReq.user_comm_report.set(Tools.a());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TianShuReportData localTianShuReportData = (TianShuReportData)paramArrayList.next();
        localUserActionMultiReportReq.report_infos.add(Tools.a(localTianShuReportData));
      }
      localNewIntent.putExtra("data", WupUtil.a(localUserActionMultiReportReq.toByteArray()));
      localNewIntent.putExtra("cmd", "TianShu.UserActionMultiReport");
      localAppRuntime.startServlet(localNewIntent);
    }
  }
  
  private void enqueueReport(TianShuReportData paramTianShuReportData)
  {
    synchronized (this.mReportList)
    {
      this.mReportList.add(paramTianShuReportData);
      if (this.mLockFlag.compareAndSet(false, true)) {
        ThreadManager.getSubThreadHandler().postDelayed(new TianShuManager.1(this), this.mTimeDelay);
      }
      return;
    }
  }
  
  private static TianShuAccess.CommInfo getCommInfo()
  {
    TianShuAccess.CommInfo localCommInfo = new TianShuAccess.CommInfo();
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    localCommInfo.lUin.set(l);
    localCommInfo.strApp.set("sq");
    localCommInfo.strOs.set("and");
    localCommInfo.strDeviceInfo.set(String.valueOf(Tools.c()));
    localCommInfo.strVersion.set(AppSetting.h());
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    localCommInfo.strCityCode.set(String.valueOf(str));
    localCommInfo.strQimei.set(String.valueOf(Tools.b()));
    localCommInfo.strQua.set(String.valueOf(QUA.getQUA3()));
    return localCommInfo;
  }
  
  public static TianShuManager getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new TianShuManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private TianShuAccess.RspEntry getRspEntry(TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    if (!paramGetAdsRsp.mapAds.has()) {
      return null;
    }
    paramGetAdsRsp = paramGetAdsRsp.mapAds.get().iterator();
    while (paramGetAdsRsp.hasNext())
    {
      TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
      if ((localRspEntry != null) && (localRspEntry.key.has()) && (localRspEntry.key.get() == paramInt)) {
        return localRspEntry;
      }
    }
    return null;
  }
  
  public static boolean isRequestEnable(int paramInt)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("next_request_time_");
    localStringBuilder.append(paramInt);
    long l2 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isRequestEnable :");
    boolean bool2 = false;
    if (l1 > l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" appid = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("TianShuManager", 1, ((StringBuilder)localObject).toString());
    boolean bool1 = bool2;
    if (l1 > l2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void saveNextRequestTime(TianShuAccess.RspEntry paramRspEntry)
  {
    if (paramRspEntry != null)
    {
      if (paramRspEntry.value.get() == null) {
        return;
      }
      Object localObject = (TianShuAccess.AdPlacementInfo)paramRspEntry.value.get();
      int i = paramRspEntry.key.get();
      long l2 = ((TianShuAccess.AdPlacementInfo)localObject).next_query_ts.get();
      long l3 = NetConnInfoCenter.getServerTime() + 86400L;
      long l1 = l2;
      if (l2 > l3)
      {
        if (QLog.isDevelopLevel())
        {
          paramRspEntry = new StringBuilder();
          paramRspEntry.append("saveNextRequestTime upper limit 24 :");
          paramRspEntry.append(l3);
          QLog.i("TianShuManager", 4, paramRspEntry.toString());
        }
        l1 = l3;
      }
      paramRspEntry = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("next_request_time_");
      ((StringBuilder)localObject).append(i);
      paramRspEntry.putLong(((StringBuilder)localObject).toString(), l1);
      paramRspEntry.commit();
      if (QLog.isDevelopLevel())
      {
        paramRspEntry = new StringBuilder();
        paramRspEntry.append("saveNextRequestTime appid = ");
        paramRspEntry.append(i);
        paramRspEntry.append(" nextRequestTime =  ");
        paramRspEntry.append(l1);
        QLog.i("TianShuManager", 4, paramRspEntry.toString());
      }
    }
  }
  
  private static void setLastClickAdId(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {
      return;
    }
    if ((paramTianShuReportData.p == 102) || (paramTianShuReportData.p == 118) || (paramTianShuReportData.p == 123) || (paramTianShuReportData.p == 124) || (paramTianShuReportData.p == 125) || (paramTianShuReportData.p == 134) || (paramTianShuReportData.p == 138) || (paramTianShuReportData.p == 140) || (paramTianShuReportData.p == 142))
    {
      String str2 = paramTianShuReportData.s;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getInstance().getTraceInfoFromCache(paramTianShuReportData.h);
      }
      setLastClickAdTraceInfo(paramTianShuReportData.h, str1);
    }
  }
  
  public static void setLastClickAdTraceInfo(String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null)
    {
      QLog.w("TianShuManager", 1, "setLastClickAdTraceInfo error, appRuntime is null");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adId:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" traceInfo:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("TianShuManager", 1, ((StringBuilder)localObject).toString());
    }
    String str = "{}";
    Object localObject = str;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramString1))
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("adId", paramString1);
          ((JSONObject)localObject).put("traceInfo", paramString2);
          localObject = ((JSONObject)localObject).toString();
        }
      }
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("setLastClickAdTraceInfo error,");
      paramString2.append(paramString1);
      QLog.e("TianShuManager", 1, paramString2.toString());
      localObject = str;
    }
    ((IVasService)localAppRuntime.getRuntimeService(IVasService.class, "all")).getTianshuWebManager().setTraceInfoOfLastClick((String)localObject);
  }
  
  private void updateReportDelayTime(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mTimeDelay = (paramInt * 1000);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).edit();
      localEditor.putLong("time_delay", this.mTimeDelay);
      localEditor.apply();
    }
  }
  
  public void cacheTraceInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = PublicAccountEventReport.b(paramString);
    if (!TextUtils.isEmpty(str))
    {
      this.mTianshuTraceInfoCache.put(str, paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cacheTraceInfo mTianshuTraceInfoCache done:");
      localStringBuilder.append(str);
      localStringBuilder.append("---");
      localStringBuilder.append(paramString);
      QLog.i("TianShuManager", 1, localStringBuilder.toString());
    }
  }
  
  public void clearNecessaryDataCacheForReport()
  {
    this.mTianshuTraceInfoCache.clear();
    VasC2SReporter.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("TianShuManager", 1, "do clearNecessaryDataCacheForReport");
    }
  }
  
  public String getTraceInfoFromCache(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mTianshuTraceInfoCache.containsKey(paramString))) {
      return (String)this.mTianshuTraceInfoCache.get(paramString);
    }
    return "";
  }
  
  void onGetTianShuAdvRsp(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("requestKey", -1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onGetTianShuAdvRsp , callbackKey = ");
        paramIntent.append(i);
        paramIntent.append(" map = ");
        paramIntent.append(this.mCallbackHashMap.toString());
        QLog.i("TianShuManager", 1, paramIntent.toString());
      }
      if (this.mCallbackHashMap.get(Integer.valueOf(i)) != null)
      {
        paramIntent = (TianShuGetAdvCallback)this.mCallbackHashMap.get(Integer.valueOf(i));
        if (paramIntent == null) {
          paramIntent = null;
        }
        this.mCallbackHashMap.remove(Integer.valueOf(i));
        break label129;
      }
    }
    paramIntent = null;
    label129:
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    TianShuAccess.GetAdsRsp localGetAdsRsp = new TianShuAccess.GetAdsRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000)
    {
      try
      {
        localGetAdsRsp.mergeFrom((byte[])localObject);
        i = localGetAdsRsp.code.get();
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("onReceive success ");
            paramFromServiceMsg.append(i);
            QLog.d("TianShuManager", 2, paramFromServiceMsg.toString());
          }
          if (paramIntent != null) {
            paramIntent.onGetAdvs(true, localGetAdsRsp);
          } else {
            QLog.e("TianShuManager", 1, "callback == null");
          }
          if (localGetAdsRsp.mapAds.isEmpty()) {
            return;
          }
          cacheNecessaryDataForReport(localGetAdsRsp.mapAds.get());
          return;
        }
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive ret ");
        paramFromServiceMsg.append(i);
        QLog.d("TianShuManager", 2, paramFromServiceMsg.toString());
        if (paramIntent == null) {
          return;
        }
        paramIntent.onGetAdvs(false, localGetAdsRsp);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive exception ");
        ((StringBuilder)localObject).append(paramFromServiceMsg);
        QLog.e("TianShuManager", 2, ((StringBuilder)localObject).toString());
        if (paramIntent == null) {
          return;
        }
      }
      paramIntent.onGetAdvs(false, localGetAdsRsp);
    }
    else
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive result fail with result ");
      paramFromServiceMsg.append(i);
      QLog.e("TianShuManager", 2, paramFromServiceMsg.toString());
      if (paramIntent != null) {
        paramIntent.onGetAdvs(false, localGetAdsRsp);
      }
    }
  }
  
  void onTianShuReport(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    else
    {
      paramIntent = null;
    }
    TianShuReport.UserActionMultiReportRsp localUserActionMultiReportRsp = new TianShuReport.UserActionMultiReportRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000) {
      try
      {
        localUserActionMultiReportRsp.mergeFrom(paramIntent);
        i = localUserActionMultiReportRsp.err_code.get();
        if (i == 0)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onReceive ret ");
            paramIntent.append(i);
            QLog.d("TianShuManager", 2, paramIntent.toString());
          }
          updateReportDelayTime(localUserActionMultiReportRsp.multi_duration.get());
          return;
        }
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive ret ");
        paramIntent.append(i);
        QLog.d("TianShuManager", 2, paramIntent.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive exception ");
        paramFromServiceMsg.append(paramIntent);
        QLog.e("TianShuManager", 2, paramFromServiceMsg.toString());
        return;
      }
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onReceive result fail with result ");
    paramIntent.append(i);
    QLog.e("TianShuManager", 2, paramIntent.toString());
  }
  
  public Map parseGetAdsRsp(TianShuAccess.GetAdsRsp paramGetAdsRsp, int paramInt)
  {
    Object localObject1 = getRspEntry(paramGetAdsRsp, paramInt);
    paramGetAdsRsp = new HashMap();
    if (checkRepEntryHasData((TianShuAccess.RspEntry)localObject1)) {
      return paramGetAdsRsp;
    }
    localObject1 = ((TianShuAccess.AdItem)((TianShuAccess.RspEntry)localObject1).value.lst.get(0)).argList.get().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (TianShuAccess.MapEntry)((Iterator)localObject1).next();
      String str = ((TianShuAccess.MapEntry)localObject2).key.get();
      localObject2 = ((TianShuAccess.MapEntry)localObject2).value.get();
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        paramGetAdsRsp.put(str, localObject2);
      }
    }
    return paramGetAdsRsp;
  }
  
  public void report(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {
      return;
    }
    enqueueReport(paramTianShuReportData);
    setLastClickAdId(paramTianShuReportData);
    VasC2SReporter.a().a(paramTianShuReportData);
  }
  
  public void requestAdv(List<TianShuAdPosItemData> paramList, TianShuGetAdvCallback paramTianShuGetAdvCallback)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramTianShuGetAdvCallback == null) {
        return;
      }
      int i = paramTianShuGetAdvCallback.hashCode();
      this.mCallbackHashMap.put(Integer.valueOf(i), paramTianShuGetAdvCallback);
      if (QLog.isColorLevel())
      {
        paramTianShuGetAdvCallback = new StringBuilder();
        paramTianShuGetAdvCallback.append("requestAdv , adblist = ");
        paramTianShuGetAdvCallback.append(paramList.toString());
        paramTianShuGetAdvCallback.append(" key = ");
        paramTianShuGetAdvCallback.append(i);
        paramTianShuGetAdvCallback.append("\n map =  ");
        paramTianShuGetAdvCallback.append(this.mCallbackHashMap.toString());
        QLog.i("TianShuManager", 1, paramTianShuGetAdvCallback.toString());
      }
      paramTianShuGetAdvCallback = BaseApplicationImpl.getApplication().getRuntime();
      TianShuAccess.GetAdsReq localGetAdsReq = new TianShuAccess.GetAdsReq();
      localGetAdsReq.stComminfo.set(getCommInfo());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TianShuAdPosItemData localTianShuAdPosItemData = (TianShuAdPosItemData)paramList.next();
        localGetAdsReq.lstPos.add(convertAdItemToPb(localTianShuAdPosItemData));
      }
      paramList = new NewIntent(paramTianShuGetAdvCallback.getApplication(), TianShuServlet.class);
      paramList.putExtra("data", WupUtil.a(localGetAdsReq.toByteArray()));
      paramList.putExtra("cmd", "TianShu.GetAds");
      paramList.putExtra("requestKey", i);
      paramTianShuGetAdvCallback.startServlet(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager
 * JD-Core Version:    0.7.0.1
 */