package cooperation.qqcircle.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.local.requests.QCircleHeartbeatSignalReportRequest;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetSessionInfoRequest;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleReportHelper
{
  public static final String MAP_KEY_CIRCLE_INVITE_ID = "circle_invite";
  public static final String MAP_KEY_COMMON_REPORT_INFO = "CommReportInfo";
  public static final String MAP_KEY_FEED_REPORT_INFO = "FeedReportInfo";
  public static final String MAP_KEY_MSG_REPORT_INFO = "MsgReportInfo";
  public static final String MAP_KEY_SESSION = "SessionID";
  public static final String MAP_KEY_SUB_SESSION = "SubSessionID";
  private static final int REPORT_HEAER_BEAT_INTERVAL_TIME = 600000;
  public static final int SCENE_MAIN_PAGE = 0;
  public static final int SCENE_PAGE_ID_ALL_PUSH = 3;
  public static final int SCENE_PAGE_ID_COMMENT_PAGE = 61;
  public static final int SCENE_PAGE_ID_CONTENT_PAGE = 57;
  public static final int SCENE_PAGE_ID_FEED_DETAIL_PAGE = 69;
  public static final int SCENE_PAGE_ID_FOLLOW = 1;
  public static final int SCENE_PAGE_ID_LBS_POLYMERIZATION_PAGE = 73;
  public static final int SCENE_PAGE_ID_MESSAGE_PAGE = 59;
  public static final int SCENE_PAGE_ID_PAT_NAME_POLYMERIZATION_PAGE = 72;
  public static final int SCENE_PAGE_ID_PERSONAL_DETAIL_PAGE = 32;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_PAGE = 89;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_TOPIC_PAGE = 88;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_FRIEND_PAGE = 84;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_GROUP_PAGE = 83;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_QZONE_PAGE = 85;
  public static final int SCENE_PAGE_ID_PUBLISH_PLUS = 36;
  public static final int SCENE_PAGE_ID_TAG_PAGE = 31;
  public static final int SCENE_PAGE_ID_TAG_POLYMERIZATION_PAGE = 71;
  public static final int SCENE_PAGE_ID_TROOP_AGGREGATION_PAGE = 70;
  public static final String TAG = "QCircleReportHelper";
  private static volatile QCircleReportHelper sInstance;
  private boolean mHasLaunchReport = false;
  private volatile ConcurrentHashMap<Long, String> mInviteIdMap = new ConcurrentHashMap();
  private volatile ConcurrentHashMap<Long, String> mInviteUinMap = new ConcurrentHashMap();
  private boolean mIsForeground = false;
  private long mLastActiveTimestamp;
  private String mLaunchFrom;
  private String mLaunchId;
  private int mLaunchScene;
  private long mLaunchTimestamp;
  private volatile byte[] mOldSession;
  private volatile ConcurrentHashMap<Integer, Long> mPageLifeMap = new ConcurrentHashMap();
  private volatile Stack<Integer> mPageStack = new Stack();
  private volatile ConcurrentHashMap<Integer, byte[]> mSceneSubSessionMap = new ConcurrentHashMap();
  private HashMap<String, String> mSchemeAttrs;
  private volatile byte[] mSession = null;
  private int mSessionLifeCircle;
  private String mToUin;
  
  private QCircleReportHelper()
  {
    RFLog.d("QCircleReportHelper", RFLog.USR, "newInstance");
  }
  
  private void checkNeedReportHeartBeat()
  {
    if ((isQQCircleActive()) && (this.mLastActiveTimestamp > 0L) && (System.currentTimeMillis() - this.mLastActiveTimestamp >= 600000L))
    {
      reportQCircleActiveIntervalTime(3);
      if (this.mIsForeground) {
        this.mLastActiveTimestamp = System.currentTimeMillis();
      }
    }
  }
  
  private void checkNeedReportLaunch()
  {
    if ((this.mHasLaunchReport) || (TextUtils.isEmpty(this.mLaunchFrom))) {}
    while (this.mSession == null) {
      return;
    }
    RFLog.w("QCircleReportHelper", RFLog.USR, "reportLaunch launchFrom:" + this.mLaunchFrom);
    String str1 = "";
    String str2 = "";
    if (this.mSchemeAttrs != null)
    {
      str1 = (String)this.mSchemeAttrs.get(QCircleReportFirstLogin.FEED_ID);
      str2 = (String)this.mSchemeAttrs.get(QCircleReportFirstLogin.SHARE_ID);
    }
    QCircleLpReportDc05493.report(this.mToUin, this.mLaunchFrom, this.mLaunchId, this.mLaunchTimestamp, this.mLaunchScene, str1, str2);
    this.mHasLaunchReport = true;
  }
  
  private void checkSessionRetired()
  {
    if (System.currentTimeMillis() - this.mLastActiveTimestamp >= this.mSessionLifeCircle * 1000)
    {
      updateReportSessionWhenExpired();
      return;
    }
    this.mLastActiveTimestamp = System.currentTimeMillis();
  }
  
  public static List<FeedCloudCommon.Entry> convertEntryList(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMap == null) {
      return localArrayList;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext()) {
      localArrayList.add(newEntry((Map.Entry)paramMap.next()));
    }
    return localArrayList;
  }
  
  public static QCircleReportHelper getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleReportHelper();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static String getNetworkType()
  {
    int j = QCircleServiceImpl.getQZoneService().getNetworkType();
    int i = j;
    if (j == 0) {
      i = 9;
    }
    return String.valueOf(i);
  }
  
  public static int getQQCirclePageStackNum()
  {
    return getInstance().mPageStack.size();
  }
  
  private void handleReportSessionRsp(FeedCloudRead.StGetSessionInfoRsp paramStGetSessionInfoRsp, int paramInt)
  {
    if (paramStGetSessionInfoRsp != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (1 != paramStGetSessionInfoRsp.sessionType.get());
          this.mSession = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
          this.mSessionLifeCircle = paramStGetSessionInfoRsp.expireTime.get();
          long l = System.currentTimeMillis();
          this.mLastActiveTimestamp = l;
          this.mLaunchTimestamp = l;
          checkNeedReportLaunch();
        } while (this.mSession == null);
        RFLog.d("QCircleReportHelper", RFLog.USR, "handleReportSessionRsp scene:ENTRY_APP，Session:" + new String(this.mSession));
        QCircleReporter.getInstance().reportCacheDataListToServerWithSession(this.mSession);
        return;
      } while (1 != paramStGetSessionInfoRsp.sessionType.get());
      this.mSession = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
      this.mSessionLifeCircle = paramStGetSessionInfoRsp.expireTime.get();
      this.mLastActiveTimestamp = System.currentTimeMillis();
      RFLog.d("QCircleReportHelper", RFLog.USR, "handleReportSessionRsp scene:EXPIRED，Session:" + new String(this.mSession));
      return;
    } while (2 != paramStGetSessionInfoRsp.sessionType.get());
    updateSubSession(36, paramStGetSessionInfoRsp.subSessonID.get().toByteArray());
  }
  
  private boolean isAppOnForeground()
  {
    return ((IQQBaseService)QRoute.api(IQQBaseService.class)).isQQForeground();
  }
  
  private boolean isDeviceInteractive()
  {
    PowerManager localPowerManager = (PowerManager)MobileQQ.sMobileQQ.getApplicationContext().getSystemService("power");
    if (Build.VERSION.SDK_INT < 20) {
      return localPowerManager.isScreenOn();
    }
    return localPowerManager.isInteractive();
  }
  
  public static boolean isQQCircleActive()
  {
    return getInstance().mPageStack.size() > 0;
  }
  
  public static boolean isQQCircleRunningForeground()
  {
    return getInstance().isRunningForeground();
  }
  
  public static FeedCloudCommon.BytesEntry newEntry(String paramString, byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    if (paramString != null) {
      localBytesEntry.key.set(paramString);
    }
    if (paramArrayOfByte != null) {
      localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    return localBytesEntry;
  }
  
  public static FeedCloudCommon.Entry newEntry(String paramString1, String paramString2)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  public static FeedCloudCommon.Entry newEntry(Map.Entry<String, String> paramEntry)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramEntry.getKey() != null) {
      localEntry.key.set((String)paramEntry.getKey());
    }
    if (paramEntry.getValue() != null) {
      localEntry.value.set((String)paramEntry.getValue());
    }
    return localEntry;
  }
  
  public static QQCircleReport.SingleDcData newSingleDcData(int paramInt, List<FeedCloudCommon.Entry> paramList1, List<FeedCloudCommon.Entry> paramList2, List<FeedCloudCommon.BytesEntry> paramList)
  {
    QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
    localSingleDcData.dcid.set(paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localSingleDcData.report_data.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localSingleDcData.extinfo.addAll(paramList2);
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      localSingleDcData.byteExtinfo.addAll(paramList);
    }
    return localSingleDcData;
  }
  
  private void releaseQCircleMemory() {}
  
  private void reportPageStayTime(int paramInt, boolean paramBoolean)
  {
    Long localLong;
    long l1;
    long l2;
    long l3;
    long l4;
    if (this.mPageLifeMap != null)
    {
      localLong = (Long)this.mPageLifeMap.get(Integer.valueOf(paramInt));
      if ((localLong != null) && (localLong.longValue() > 0L))
      {
        l1 = this.mLaunchTimestamp;
        l2 = System.currentTimeMillis();
        l3 = localLong.longValue();
        l4 = paramInt;
        if (!paramBoolean) {
          break label157;
        }
      }
    }
    label157:
    for (String str = "1";; str = "0")
    {
      QCircleLpReportDc05503.report(l1, l2 - l3, l4, str, "", "", "", "", "", paramInt);
      RFLog.d("QCircleReportHelper", RFLog.CLR, "recordPageEndShow:scene:" + paramInt + ",cost:" + (System.currentTimeMillis() - localLong.longValue()) + "ms");
      this.mPageLifeMap.remove(Integer.valueOf(paramInt));
      return;
    }
  }
  
  private void reportQCircleActiveIntervalTime(int paramInt)
  {
    if (this.mLastActiveTimestamp != 0L)
    {
      long l = System.currentTimeMillis() - this.mLastActiveTimestamp;
      this.mLastActiveTimestamp = 0L;
      RFLog.w("QCircleReportHelper", RFLog.USR, "reportQCircleActiveIntervalTime intervalTime:" + l + "ms,signalOptType:" + paramInt);
      if (this.mSession == null) {}
      for (Object localObject = this.mOldSession;; localObject = this.mSession)
      {
        localObject = new QCircleHeartbeatSignalReportRequest(l, paramInt, (byte[])localObject);
        VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleReportHelper.2(this));
        checkNeedReportLaunch();
        return;
      }
    }
    RFLog.d("QCircleReportHelper", RFLog.USR, "reportQCircleActiveIntervalTime invalid intervalTime,direct return!");
  }
  
  private void requestReportSession(FeedCloudCommon.StCommonExt paramStCommonExt, int paramInt)
  {
    paramStCommonExt = new QCircleGetSessionInfoRequest(paramStCommonExt, paramInt);
    VSNetworkHelper.getInstance().sendRequest(paramStCommonExt, new QCircleReportHelper.1(this, paramInt));
  }
  
  private void retireSession()
  {
    RFLog.w("QCircleReportHelper", RFLog.USR, "retireSession");
    this.mOldSession = this.mSession;
    this.mSession = null;
    this.mSceneSubSessionMap.clear();
    this.mIsForeground = false;
  }
  
  public String getInviteId()
  {
    return (String)this.mInviteIdMap.get(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()));
  }
  
  public String getInviteUin()
  {
    return (String)this.mInviteUinMap.get(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()));
  }
  
  @Deprecated
  public int getPageId()
  {
    try
    {
      if (this.mPageStack.size() > 0)
      {
        int i = ((Integer)this.mPageStack.peek()).intValue();
        RFLog.d("QCircleReportHelper", RFLog.DEV, "getPageId:" + i);
        return i;
      }
      RFLog.e("QCircleReportHelper", RFLog.USR, "getPageId error!");
      return 0;
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleReportHelper", RFLog.USR, "getPageId exception:" + localException.toString());
    }
    return -1;
  }
  
  public int getPageStackSize()
  {
    return this.mPageStack.size();
  }
  
  public void getPublishReportSession()
  {
    requestReportSession(null, 3);
  }
  
  public byte[] getSession()
  {
    return this.mSession;
  }
  
  public byte[] getSubSession(int paramInt)
  {
    if (this.mSceneSubSessionMap.containsKey(Integer.valueOf(paramInt))) {
      return (byte[])this.mSceneSubSessionMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public List<FeedCloudCommon.BytesEntry> getTransferEntry(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte != null) {
      localArrayList.add(newEntry("FeedReportInfo", paramArrayOfByte));
    }
    return localArrayList;
  }
  
  public boolean hasValidSession()
  {
    return (this.mOldSession != null) || (this.mSession != null);
  }
  
  public void initReportSession()
  {
    RFLog.w("QCircleReportHelper", RFLog.USR, "initReportSession");
    this.mOldSession = null;
    requestReportSession(null, 1);
  }
  
  public boolean isLaunchFromFolderPage()
  {
    return (this.mPageStack.size() > 1) && (((Integer)this.mPageStack.get(0)).intValue() == 0);
  }
  
  public boolean isPageStackEmpty()
  {
    boolean bool = false;
    if (((this.mPageStack.contains(Integer.valueOf(0))) && (this.mPageStack.size() == 1)) || (this.mPageStack.size() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isRunningForeground()
  {
    return this.mIsForeground;
  }
  
  public List<FeedCloudCommon.Entry> newBaseEntries()
  {
    checkNeedReportHeartBeat();
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { newEntry("uin", String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin())), newEntry("network_type", getNetworkType()), newEntry("app_version", ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName()), newEntry("qua", QCircleServiceImpl.getQZoneService().getQUA3()), newEntry("platform", "android"), newEntry("report_from", "1"), newEntry("os_version", Build.VERSION.RELEASE), newEntry("mobile_type", Build.MODEL), newEntry("respond_type", QCircleServiceImpl.getQQService().getResolution()), newEntry("device_info", Build.DEVICE), newEntry("imei", QCircleServiceImpl.getQQService().getImei()), newEntry("idfa", ""), newEntry("idfv", "") }));
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries()
  {
    if (this.mSession != null) {
      return new ArrayList(Arrays.asList(new FeedCloudCommon.BytesEntry[] { newEntry("SessionID", this.mSession) }));
    }
    return null;
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries(int paramInt)
  {
    return newSessionEntries(paramInt, null);
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries(int paramInt, byte[] paramArrayOfByte)
  {
    return newSessionEntries(paramInt, paramArrayOfByte, null);
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfByte1 != null) {
      localArrayList.add(newEntry("FeedReportInfo", paramArrayOfByte1));
    }
    if (paramArrayOfByte2 != null) {
      localArrayList.add(newEntry("MsgReportInfo", paramArrayOfByte2));
    }
    if (this.mSession != null) {
      localArrayList.add(newEntry("SessionID", this.mSession));
    }
    for (;;)
    {
      if (getSubSession(paramInt) != null) {
        localArrayList.add(newEntry("SubSessionID", getSubSession(paramInt)));
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      return localArrayList;
      if (this.mOldSession != null)
      {
        localArrayList.add(newEntry("SessionID", this.mOldSession));
        RFLog.w("QCircleReportHelper", RFLog.USR, "newSessionEntries mSession retired!try use oldSession");
      }
      else
      {
        RFLog.e("QCircleReportHelper", RFLog.USR, "newSessionEntries mSession is null!");
      }
    }
    return null;
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte1 = newSessionEntries(paramInt, paramArrayOfByte1, paramArrayOfByte2);
    if (paramArrayOfByte1 != null) {
      if (paramArrayOfByte3 != null) {
        paramArrayOfByte1.add(newEntry("CommReportInfo", paramArrayOfByte3));
      }
    }
    while (paramArrayOfByte3 == null) {
      return paramArrayOfByte1;
    }
    paramArrayOfByte1 = new ArrayList();
    paramArrayOfByte1.add(newEntry("CommReportInfo", paramArrayOfByte3));
    return paramArrayOfByte1;
  }
  
  public void onEnterBackground()
  {
    RFLog.d("QCircleReportHelper", 2, "onQQEnterBackground!");
    if (isQQCircleActive())
    {
      if (this.mIsForeground)
      {
        reportQCircleActiveIntervalTime(2);
        QCircleReporter.getInstance().flush();
        this.mIsForeground = false;
      }
      RFLog.d("QCircleReportHelper", 2, "onQCircleEnterBackground!");
    }
  }
  
  public void onEnterForeground()
  {
    RFLog.d("QCircleReportHelper", RFLog.CLR, "onQQEnterForeground!");
    if (!this.mIsForeground)
    {
      if (isQQCircleActive())
      {
        RFLog.d("QCircleReportHelper", 2, "onQCircleEnterForeground!");
        checkSessionRetired();
        QBaseActivity.setIsUnLockSuccess(true);
      }
      this.mIsForeground = true;
    }
  }
  
  public void popPageScene(int paramInt)
  {
    RFLog.d("QCircleReportHelper", RFLog.CLR, "popPageScene scene:" + paramInt);
    if (this.mPageStack.contains(Integer.valueOf(paramInt)))
    {
      if (((Integer)this.mPageStack.peek()).intValue() != paramInt) {
        break label116;
      }
      this.mPageStack.pop();
      RFLog.d("QCircleReportHelper", RFLog.CLR, "popPageScene success");
    }
    for (;;)
    {
      if (this.mPageStack.size() == 0)
      {
        RFLog.w("QCircleReportHelper", RFLog.USR, "no QQCircle Page Alive,exit QQCircle");
        retireSession();
        this.mPageLifeMap.clear();
        reportQCircleActiveIntervalTime(1);
      }
      return;
      label116:
      RFLog.e("QCircleReportHelper", RFLog.CLR, "popPageScene error!mismatch scene,current Page:" + this.mPageStack);
    }
  }
  
  public void pushPageScene(int paramInt)
  {
    RFLog.d("QCircleReportHelper", RFLog.CLR, "pushPageScene scene:" + paramInt);
    if ((this.mPageStack.size() > 0) && ((paramInt == 1) || (paramInt == 3) || (paramInt == 0)) && (this.mPageStack.contains(Integer.valueOf(paramInt))))
    {
      RFLog.e("QCircleReportHelper", RFLog.USR, "pushPageScene scene:" + paramInt + ",PageStack leak:" + this.mPageStack + ",force clear");
      this.mPageStack.clear();
      this.mPageLifeMap.clear();
      reportQCircleActiveIntervalTime(1);
      retireSession();
    }
    this.mPageStack.push(Integer.valueOf(paramInt));
    QCircleReporter.getInstance().flush();
    RFLog.d("QCircleReportHelper", RFLog.CLR, "pushPageScene success");
  }
  
  public void recordPageEndShow(int paramInt, boolean paramBoolean)
  {
    reportPageStayTime(paramInt, paramBoolean);
    RFLog.d("QCircleReportHelper", RFLog.CLR, "recordPageEndShow:scene:" + paramInt + ",hasActiveAction:" + paramBoolean);
  }
  
  public void recordPageStartShow(int paramInt)
  {
    this.mPageLifeMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    RFLog.d("QCircleReportHelper", RFLog.CLR, "recordPageStartShow:scene:" + paramInt);
  }
  
  public void setInviteId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mInviteIdMap.remove(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()));
      return;
    }
    this.mInviteIdMap.put(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()), paramString);
  }
  
  public void setInviteUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mInviteUinMap.remove(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()));
      return;
    }
    this.mInviteUinMap.put(Long.valueOf(QCircleCommonUtil.getCurrentAccountLongUin()), paramString);
  }
  
  public void setLaunchParms(QCircleReportHelper.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam != null)
    {
      this.mHasLaunchReport = false;
      this.mLaunchFrom = paramLaunchParam.launchFrom;
      this.mLaunchId = paramLaunchParam.launchId;
      this.mToUin = paramLaunchParam.toUin;
      this.mLaunchScene = paramLaunchParam.launchScene;
      this.mSchemeAttrs = paramLaunchParam.schemeAttrs;
      if (TextUtils.isEmpty(this.mLaunchFrom)) {
        RFLog.e("QCircleReportHelper", RFLog.USR, "setLaunchParms invalid launchfrom params");
      }
      initReportSession();
      RFLog.w("QCircleReportHelper", RFLog.USR, "launchPageScene:" + this.mLaunchScene);
      checkNeedReportLaunch();
    }
  }
  
  public void updateReportSessionWhenExpired()
  {
    RFLog.d("QCircleReportHelper", RFLog.CLR, "updateReportSessionWhenExpired");
    requestReportSession(null, 2);
  }
  
  public void updateSubSession(int paramInt, byte[] paramArrayOfByte)
  {
    this.mSceneSubSessionMap.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper
 * JD-Core Version:    0.7.0.1
 */