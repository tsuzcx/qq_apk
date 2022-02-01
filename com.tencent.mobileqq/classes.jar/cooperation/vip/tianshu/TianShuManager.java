package cooperation.vip.tianshu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class TianShuManager
{
  private static final String SP_NAME = "tianshu_manager";
  private static final String SP_TIME_DELAY_KEY = "time_delay";
  private static final String TAG = "TianShuManager";
  private static TianShuManager mInstance = null;
  private final AtomicBoolean mLockFlag = new AtomicBoolean(false);
  private final ArrayList<TianShuReportData> mReportList = new ArrayList();
  private final ConcurrentHashMap<String, String> mTianshuTraceInfoCache = new ConcurrentHashMap();
  private long mTimeDelay = BaseApplicationImpl.getApplication().getSharedPreferences("tianshu_manager", 4).getLong("time_delay", 3000L);
  private HashMap<Long, WeakReference<TianShuGetAdvCallback>> mWeakCallbackHashMap = new HashMap();
  
  private void cacheNecessaryDataForReport(List<TianShuAccess.RspEntry> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
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
    if (paramAdItem == null) {}
    String str;
    do
    {
      return;
      str = String.valueOf(paramAdItem.iAdId.get());
      paramAdItem = paramAdItem.traceinfo.get();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramAdItem)));
    this.mTianshuTraceInfoCache.put(str, paramAdItem);
    QLog.i("TianShuManager", 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + str + "---" + paramAdItem);
  }
  
  private static TianShuAccess.AdPosItem convertAdItemToPb(TianShuAdPosItemData paramTianShuAdPosItemData)
  {
    TianShuAccess.AdPosItem localAdPosItem = new TianShuAccess.AdPosItem();
    localAdPosItem.posId.set(paramTianShuAdPosItemData.jdField_a_of_type_Int);
    localAdPosItem.nNeedCnt.set(paramTianShuAdPosItemData.b);
    if (paramTianShuAdPosItemData.jdField_a_of_type_JavaUtilHashMap != null)
    {
      paramTianShuAdPosItemData = paramTianShuAdPosItemData.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
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
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
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
    localCommInfo.strDeviceInfo.set(String.valueOf(Tools.b()));
    localCommInfo.strVersion.set(AppSetting.f());
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    localCommInfo.strCityCode.set(String.valueOf(str));
    localCommInfo.strQimei.set(String.valueOf(Tools.a()));
    localCommInfo.strQua.set(String.valueOf(QUA.getQUA3()));
    return localCommInfo;
  }
  
  public static TianShuManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new TianShuManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  private static void setLastClickAdId(TianShuReportData paramTianShuReportData)
  {
    if (paramTianShuReportData == null) {}
    while ((paramTianShuReportData.d != 102) && (paramTianShuReportData.d != 118) && (paramTianShuReportData.d != 123) && (paramTianShuReportData.d != 124) && (paramTianShuReportData.d != 125) && (paramTianShuReportData.d != 134) && (paramTianShuReportData.d != 138) && (paramTianShuReportData.d != 140) && (paramTianShuReportData.d != 142)) {
      return;
    }
    String str2 = paramTianShuReportData.l;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = getInstance().getTraceInfoFromCache(paramTianShuReportData.g);
    }
    setLastClickAdTraceInfo(paramTianShuReportData.g, str1);
  }
  
  public static void setLastClickAdTraceInfo(String paramString1, String paramString2)
  {
    String str = "{}";
    if (QLog.isColorLevel()) {
      QLog.i("TianShuManager", 1, "adId:" + paramString1 + " traceInfo:" + paramString2);
    }
    localObject = str;
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
      for (;;)
      {
        QLog.e("TianShuManager", 1, "setLastClickAdTraceInfo error," + paramString1);
        localObject = "{}";
      }
    }
    ((IVasService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getTianshuWebManager().a((String)localObject);
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
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      str = PublicAccountEventReport.a(paramString);
    } while (TextUtils.isEmpty(str));
    this.mTianshuTraceInfoCache.put(str, paramString);
    QLog.i("TianShuManager", 1, "cacheTraceInfo mTianshuTraceInfoCache done:" + str + "---" + paramString);
  }
  
  public void clearNecessaryDataCacheForReport()
  {
    this.mTianshuTraceInfoCache.clear();
    VasC2SReporter.a().a();
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
    byte[] arrayOfByte = null;
    if (paramIntent != null)
    {
      long l = paramIntent.getLongExtra("requestKey", -1L);
      if (this.mWeakCallbackHashMap.get(Long.valueOf(l)) != null)
      {
        paramIntent = (TianShuGetAdvCallback)((WeakReference)this.mWeakCallbackHashMap.get(Long.valueOf(l))).get();
        if (paramIntent != null) {
          this.mWeakCallbackHashMap.remove(Long.valueOf(l));
        }
      }
    }
    for (;;)
    {
      if (paramFromServiceMsg.isSuccess())
      {
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        arrayOfByte = new byte[i];
        PkgTools.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      TianShuAccess.GetAdsRsp localGetAdsRsp = new TianShuAccess.GetAdsRsp();
      int i = paramFromServiceMsg.getResultCode();
      if (i == 1000)
      {
        try
        {
          localGetAdsRsp.mergeFrom(arrayOfByte);
          i = localGetAdsRsp.code.get();
          if (i != 0) {
            break label269;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TianShuManager", 2, "onReceive success " + i);
          }
          if (paramIntent != null) {
            paramIntent.onGetAdvs(true, localGetAdsRsp);
          }
          while (!localGetAdsRsp.mapAds.isEmpty())
          {
            cacheNecessaryDataForReport(localGetAdsRsp.mapAds.get());
            return;
            QLog.e("TianShuManager", 1, "callback == null");
          }
          paramIntent.onGetAdvs(false, localGetAdsRsp);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.e("TianShuManager", 2, "onReceive exception " + paramFromServiceMsg);
          if (paramIntent == null) {
            return;
          }
        }
        return;
        label269:
        QLog.d("TianShuManager", 2, "onReceive ret " + i);
        if (paramIntent == null) {
          return;
        }
        paramIntent.onGetAdvs(false, localGetAdsRsp);
        return;
      }
      QLog.e("TianShuManager", 2, "onReceive result fail with result " + i);
      if (paramIntent == null) {
        return;
      }
      paramIntent.onGetAdvs(false, localGetAdsRsp);
      return;
      paramIntent = null;
      break;
      paramIntent = null;
    }
  }
  
  void onTianShuReport(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    paramIntent = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
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
          if (QLog.isColorLevel()) {
            QLog.d("TianShuManager", 2, "onReceive ret " + i);
          }
          updateReportDelayTime(localUserActionMultiReportRsp.multi_duration.get());
          return;
        }
        QLog.d("TianShuManager", 2, "onReceive ret " + i);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("TianShuManager", 2, "onReceive exception " + paramIntent);
        return;
      }
    }
    QLog.e("TianShuManager", 2, "onReceive result fail with result " + i);
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
    if ((paramList == null) || (paramList.size() <= 0) || (paramTianShuGetAdvCallback == null)) {
      return;
    }
    long l = System.currentTimeMillis();
    this.mWeakCallbackHashMap.put(Long.valueOf(l), new WeakReference(paramTianShuGetAdvCallback));
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
    paramList.putExtra("requestKey", l);
    paramTianShuGetAdvCallback.startServlet(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.tianshu.TianShuManager
 * JD-Core Version:    0.7.0.1
 */