package cooperation.qqcircle.report;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetSessionInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.requests.QCircleHeartbeatSignalReportRequest;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudRead.StGetSessionInfoRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleReportHelper
{
  public static final String MAP_KEY_CIRCLE_INVITE_ID = "circle_invite";
  public static final String MAP_KEY_COMMON_REPORT_INFO = "CommExtReportInfo";
  public static final String MAP_KEY_FEED_REPORT_INFO = "FeedReportInfo";
  public static final String MAP_KEY_MSG_REPORT_INFO = "MsgReportInfo";
  public static final String MAP_KEY_SESSION = "SessionID";
  public static final String MAP_KEY_SUB_SESSION = "SubSessionID";
  private static final int REPORT_HEAER_BEAT_INTERVAL_TIME = 600000;
  public static final int SCENE_MAIN_PAGE = 0;
  public static final int SCENE_PAGE_ID_ALL_PUSH = 3;
  public static final int SCENE_PAGE_ID_BACK_FLOW_SPLASH_PAGE = 94;
  public static final int SCENE_PAGE_ID_COMMENT_PAGE = 61;
  public static final int SCENE_PAGE_ID_CONTENT_PAGE = 57;
  public static final int SCENE_PAGE_ID_DRAFT_PAGE = 33;
  public static final int SCENE_PAGE_ID_FEED_DETAIL_PAGE = 69;
  public static final int SCENE_PAGE_ID_FOLLOW = 1;
  public static final int SCENE_PAGE_ID_FRIEND_PUBLIC_ACCOUNTS_PAGE = 86;
  public static final int SCENE_PAGE_ID_LBS_POLYMERIZATION_PAGE = 73;
  public static final int SCENE_PAGE_ID_MESSAGE_PAGE = 59;
  public static final int SCENE_PAGE_ID_NEARBY = 91;
  public static final int SCENE_PAGE_ID_NEW_FEED_DETAIL_PAGE = 691;
  public static final int SCENE_PAGE_ID_NEW_FRIEND_PAGE = 90;
  public static final int SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_GROUP_PAGE = 831;
  public static final int SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_QZONE_PAGE = 851;
  public static final int SCENE_PAGE_ID_PAT_NAME_POLYMERIZATION_PAGE = 72;
  public static final int SCENE_PAGE_ID_PERSONAL_DETAIL_PAGE = 32;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_PAGE = 89;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_ARK_TOPIC_PAGE = 88;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_FRIEND_PAGE = 84;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_GROUP_PAGE = 83;
  public static final int SCENE_PAGE_ID_POLYMERIZE_DETAIL_QZONE_PAGE = 85;
  public static final int SCENE_PAGE_ID_PUBLISH_PLUS = 36;
  public static final int SCENE_PAGE_ID_SPLASH_PAGE = 82;
  public static final int SCENE_PAGE_ID_TAG_PAGE = 31;
  public static final int SCENE_PAGE_ID_TAG_POLYMERIZATION_PAGE = 71;
  public static final int SCENE_PAGE_ID_TROOP_AGGREGATION_PAGE = 70;
  public static final String TAG = "QCircleReportHelper";
  private static volatile QCircleReportHelper sInstance;
  private boolean mHasLaunchReport = false;
  private final ConcurrentHashMap<Long, String> mInviteIdMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Long, String> mInviteUinMap = new ConcurrentHashMap();
  private boolean mIsActivate = true;
  private boolean mIsForeground = false;
  private long mLastActiveTimestamp;
  private String mLaunchFrom;
  private String mLaunchId;
  private int mLaunchScene;
  private long mLaunchTimestamp;
  private volatile byte[] mOldSession;
  private final ConcurrentHashMap<Integer, Long> mPageLifeMap = new ConcurrentHashMap();
  private final Stack<Integer> mPageStack = new Stack();
  private final ConcurrentHashMap<Integer, byte[]> mSceneSubSessionMap = new ConcurrentHashMap();
  private HashMap<String, String> mSchemeAttrs;
  private volatile byte[] mSession = null;
  private int mSessionLifeCircle;
  private String mToUin;
  
  private QCircleReportHelper()
  {
    QLog.d("QCircleReportHelper", 1, "newInstance");
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
    if (!this.mHasLaunchReport)
    {
      if (TextUtils.isEmpty(this.mLaunchFrom)) {
        return;
      }
      if (this.mSession == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportLaunch launchFrom:");
      ((StringBuilder)localObject1).append(this.mLaunchFrom);
      QLog.w("QCircleReportHelper", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.mSchemeAttrs;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = (String)((HashMap)localObject1).get(QCircleReportFirstLogin.FEED_ID);
        localObject2 = (String)this.mSchemeAttrs.get(QCircleReportFirstLogin.SHARE_ID);
      }
      else
      {
        localObject1 = "";
        localObject2 = localObject1;
      }
      QCircleLpReportDc05493.report(this.mToUin, this.mLaunchFrom, this.mLaunchId, this.mLaunchTimestamp, this.mLaunchScene, (String)localObject1, (String)localObject2);
      this.mHasLaunchReport = true;
    }
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
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleReportHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static String getNetworkType()
  {
    int j = NetworkState.getNetworkType();
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
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          if (2 == paramStGetSessionInfoRsp.sessionType.get()) {
            updateSubSession(36, paramStGetSessionInfoRsp.subSessonID.get().toByteArray());
          }
        }
        else if (1 == paramStGetSessionInfoRsp.sessionType.get())
        {
          this.mSession = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
          this.mSessionLifeCircle = paramStGetSessionInfoRsp.expireTime.get();
          this.mLastActiveTimestamp = System.currentTimeMillis();
          paramStGetSessionInfoRsp = new StringBuilder();
          paramStGetSessionInfoRsp.append("handleReportSessionRsp scene:EXPIRED，Session:");
          paramStGetSessionInfoRsp.append(new String(this.mSession));
          QLog.d("QCircleReportHelper", 1, paramStGetSessionInfoRsp.toString());
        }
      }
      else if (1 == paramStGetSessionInfoRsp.sessionType.get())
      {
        this.mSession = paramStGetSessionInfoRsp.sessonID.get().toByteArray();
        this.mSessionLifeCircle = paramStGetSessionInfoRsp.expireTime.get();
        long l = System.currentTimeMillis();
        this.mLastActiveTimestamp = l;
        this.mLaunchTimestamp = l;
        checkNeedReportLaunch();
        if (this.mSession != null)
        {
          paramStGetSessionInfoRsp = new StringBuilder();
          paramStGetSessionInfoRsp.append("handleReportSessionRsp scene:ENTRY_APP，Session:");
          paramStGetSessionInfoRsp.append(new String(this.mSession));
          QLog.d("QCircleReportHelper", 1, paramStGetSessionInfoRsp.toString());
          QCircleReporter.getInstance().reportCacheDataListToServerWithSession(this.mSession);
        }
      }
    }
  }
  
  private boolean isDeviceInteractive()
  {
    PowerManager localPowerManager = (PowerManager)RFApplication.getApplication().getSystemService("power");
    if (Build.VERSION.SDK_INT < 20) {
      return localPowerManager.isScreenOn();
    }
    return localPowerManager.isInteractive();
  }
  
  public static boolean isQQCircleActive()
  {
    return (getInstance().mPageStack.size() > 0) && (getInstance().mIsActivate);
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
  
  private void printPageStack()
  {
    if (!this.mPageStack.empty())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("printPageStack:");
      localStringBuilder.append(Arrays.toString(this.mPageStack.toArray()));
      QLog.d("QCircleReportHelper", 1, localStringBuilder.toString());
    }
  }
  
  private void reportPageLeakEvent()
  {
    QCircleQualityReporter.reportQualityEvent("page_leak_event", Collections.singletonList(newEntry("attach_info", Arrays.toString(this.mPageStack.toArray()))), false);
  }
  
  private void reportPageStayTime(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.mPageLifeMap;
    if (localObject != null)
    {
      Long localLong = (Long)((ConcurrentHashMap)localObject).get(Integer.valueOf(paramInt));
      if ((localLong != null) && (localLong.longValue() > 0L))
      {
        long l1 = this.mLaunchTimestamp;
        long l2 = System.currentTimeMillis();
        long l3 = localLong.longValue();
        long l4 = paramInt;
        if (paramBoolean) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        QCircleLpReportDc05503.report(l1, l2 - l3, l4, (String)localObject, "", "", "", "", "", paramInt);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("recordPageEndShow:scene:");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",cost:");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - localLong.longValue());
        ((StringBuilder)localObject).append("ms");
        QLog.d("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
        this.mPageLifeMap.remove(Integer.valueOf(paramInt));
      }
    }
  }
  
  private void reportQCircleActiveIntervalTime(int paramInt)
  {
    if (this.mLastActiveTimestamp != 0L)
    {
      long l = System.currentTimeMillis() - this.mLastActiveTimestamp;
      this.mLastActiveTimestamp = 0L;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportQCircleActiveIntervalTime intervalTime:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("ms,signalOptType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.w("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
      if (this.mSession == null) {
        localObject = this.mOldSession;
      } else {
        localObject = this.mSession;
      }
      localObject = new QCircleHeartbeatSignalReportRequest(l, paramInt, (byte[])localObject);
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleReportHelper.2(this));
      printPageStack();
      checkNeedReportLaunch();
      return;
    }
    QLog.d("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime invalid intervalTime,direct return!");
  }
  
  private void requestReportSession(int paramInt)
  {
    QCircleGetSessionInfoRequest localQCircleGetSessionInfoRequest = new QCircleGetSessionInfoRequest(null, paramInt);
    VSNetworkHelper.getInstance().sendRequest(localQCircleGetSessionInfoRequest, new QCircleReportHelper.1(this, paramInt));
  }
  
  private void retireSession()
  {
    QLog.w("QCircleReportHelper", 1, "retireSession");
    this.mOldSession = this.mSession;
    this.mSession = null;
    this.mSceneSubSessionMap.clear();
    this.mIsForeground = false;
    this.mIsActivate = true;
  }
  
  public String getInviteId()
  {
    return (String)this.mInviteIdMap.get(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
  }
  
  public String getInviteUin()
  {
    return (String)this.mInviteUinMap.get(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
  }
  
  @Deprecated
  public int getPageId()
  {
    try
    {
      if (this.mPageStack.size() > 0)
      {
        int i = ((Integer)this.mPageStack.peek()).intValue();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getPageId:");
        localStringBuilder1.append(i);
        QLog.d("QCircleReportHelper", 4, localStringBuilder1.toString());
        return i;
      }
      QLog.e("QCircleReportHelper", 1, "getPageId error!");
      return 0;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getPageId exception:");
      localStringBuilder2.append(localException.toString());
      QLog.e("QCircleReportHelper", 1, localStringBuilder2.toString());
    }
    return -1;
  }
  
  public int getPageStackSize()
  {
    return this.mPageStack.size();
  }
  
  public void getPublishReportSession()
  {
    requestReportSession(3);
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
  
  void handleInActivatedState()
  {
    if (isQQCircleActive())
    {
      QLog.d("QCircleReportHelper", 1, "onQCircle enter activate state!");
      checkSessionRetired();
      QCircleHostStubUtil.setIsUnLockSuccess(true);
      this.mIsForeground = true;
    }
  }
  
  void handleInDeactivatedState()
  {
    if (isQQCircleActive())
    {
      QLog.d("QCircleReportHelper", 1, "onQCircle enter deactivate state!");
      reportQCircleActiveIntervalTime(2);
      QCircleReporter.getInstance().flush();
      this.mIsForeground = false;
    }
  }
  
  boolean hasFolderPageLeak(int paramInt)
  {
    return (this.mPageStack.contains(Integer.valueOf(paramInt))) && ((1 == paramInt) || (3 == paramInt) || (91 == paramInt) || (paramInt == 0));
  }
  
  public boolean hasValidSession()
  {
    return (this.mOldSession != null) || (this.mSession != null);
  }
  
  public void initReportSession()
  {
    QLog.w("QCircleReportHelper", 1, "initReportSession");
    this.mOldSession = null;
    requestReportSession(1);
  }
  
  public boolean isLaunchFromFolderPage()
  {
    int i = this.mPageStack.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 1)
    {
      bool1 = bool2;
      if (((Integer)this.mPageStack.get(0)).intValue() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isPageStackEmpty()
  {
    Stack localStack = this.mPageStack;
    boolean bool = false;
    if (((localStack.contains(Integer.valueOf(0))) && (this.mPageStack.size() == 1)) || (this.mPageStack.size() == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public List<FeedCloudCommon.Entry> newBaseEntries()
  {
    checkNeedReportHeartBeat();
    return new ArrayList(Arrays.asList(new FeedCloudCommon.Entry[] { newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), newEntry("network_type", getNetworkType()), newEntry("app_version", ((IAppSettingApi)QRoute.api(IAppSettingApi.class)).getReportVersionName()), newEntry("qua", QUA.getQUA3()), newEntry("platform", "android"), newEntry("report_from", "1"), newEntry("os_version", Build.VERSION.RELEASE), newEntry("mobile_type", Build.MODEL), newEntry("respond_type", QCircleHostStubUtil.getMobileResolution()), newEntry("device_info", Build.DEVICE), newEntry("imei", QCircleHostStubUtil.getMobileIMei()), newEntry("idfa", ""), newEntry("idfv", "") }));
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries()
  {
    if (this.mSession != null) {
      return new ArrayList(Collections.singletonList(newEntry("SessionID", this.mSession)));
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
    if (this.mSession != null)
    {
      localArrayList.add(newEntry("SessionID", this.mSession));
    }
    else if (this.mOldSession != null)
    {
      localArrayList.add(newEntry("SessionID", this.mOldSession));
      QLog.w("QCircleReportHelper", 1, "newSessionEntries mSession retired!try use oldSession");
    }
    else
    {
      QLog.e("QCircleReportHelper", 1, "newSessionEntries mSession is null!");
    }
    if (getSubSession(paramInt) != null) {
      localArrayList.add(newEntry("SubSessionID", getSubSession(paramInt)));
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public List<FeedCloudCommon.BytesEntry> newSessionEntries(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    paramArrayOfByte2 = newSessionEntries(paramInt, paramArrayOfByte1, paramArrayOfByte2);
    if (paramArrayOfByte2 != null)
    {
      paramArrayOfByte1 = paramArrayOfByte2;
      if (paramArrayOfByte3 != null)
      {
        paramArrayOfByte2.add(newEntry("CommExtReportInfo", paramArrayOfByte3));
        return paramArrayOfByte2;
      }
    }
    else
    {
      paramArrayOfByte1 = paramArrayOfByte2;
      if (paramArrayOfByte3 != null)
      {
        paramArrayOfByte1 = new ArrayList();
        paramArrayOfByte1.add(newEntry("CommExtReportInfo", paramArrayOfByte3));
      }
    }
    return paramArrayOfByte1;
  }
  
  public void onEnterBackground()
  {
    QLog.d("QCircleReportHelper", 1, "onQQEnterBackground!");
    handleInDeactivatedState();
  }
  
  public void onEnterForeground()
  {
    QLog.d("QCircleReportHelper", 1, "onQQEnterForeground!");
    handleInActivatedState();
  }
  
  public void popPageScene(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("popPageScene scene:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleReportHelper", 1, localStringBuilder.toString());
    if (paramInt < 0) {
      return;
    }
    if (this.mPageStack.contains(Integer.valueOf(paramInt))) {
      if (((Integer)this.mPageStack.peek()).intValue() == paramInt)
      {
        this.mPageStack.pop();
        QLog.d("QCircleReportHelper", 1, "popPageScene success");
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("popPageScene error!mismatch scene,current Page:");
        localStringBuilder.append(this.mPageStack);
        QLog.e("QCircleReportHelper", 1, localStringBuilder.toString());
      }
    }
    if (this.mPageStack.size() == 0)
    {
      QLog.w("QCircleReportHelper", 1, "no QQCircle Page Alive,exit QQCircle");
      retireSession();
      this.mPageLifeMap.clear();
      reportQCircleActiveIntervalTime(1);
    }
    printPageStack();
  }
  
  public void pushPageScene(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pushPageScene scene:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleReportHelper", 1, localStringBuilder.toString());
    if (paramInt < 0) {
      return;
    }
    if ((this.mPageStack.size() > 0) && (hasFolderPageLeak(paramInt)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pushPageScene scene:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",PageStack leak:");
      localStringBuilder.append(this.mPageStack);
      localStringBuilder.append(",force clear");
      QLog.e("QCircleReportHelper", 1, localStringBuilder.toString());
      printPageStack();
      reportPageLeakEvent();
      this.mPageStack.clear();
      this.mPageLifeMap.clear();
      reportQCircleActiveIntervalTime(1);
      retireSession();
    }
    this.mPageStack.push(Integer.valueOf(paramInt));
    QCircleReporter.getInstance().flush();
    QLog.d("QCircleReportHelper", 1, "pushPageScene success");
    printPageStack();
  }
  
  public void recordPageEndShow(int paramInt, boolean paramBoolean)
  {
    reportPageStayTime(paramInt, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recordPageEndShow:scene:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",hasActiveAction:");
    localStringBuilder.append(paramBoolean);
    QLog.d("QCircleReportHelper", 1, localStringBuilder.toString());
  }
  
  public void recordPageStartShow(int paramInt)
  {
    this.mPageLifeMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recordPageStartShow:scene:");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleReportHelper", 1, localStringBuilder.toString());
  }
  
  public void setInviteId(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mInviteIdMap.remove(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
      return;
    }
    this.mInviteIdMap.put(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()), paramString);
  }
  
  public void setInviteUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.mInviteUinMap.remove(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()));
      return;
    }
    this.mInviteUinMap.put(Long.valueOf(QCircleHostStubUtil.getCurrentAccountLongUin()), paramString);
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
        QLog.e("QCircleReportHelper", 1, "setLaunchParms invalid launchfrom params");
      }
      initReportSession();
      paramLaunchParam = new StringBuilder();
      paramLaunchParam.append("launchPageScene:");
      paramLaunchParam.append(this.mLaunchScene);
      QLog.w("QCircleReportHelper", 1, paramLaunchParam.toString());
      checkNeedReportLaunch();
    }
  }
  
  public void setQCircleIsActivate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mIsActivate = true;
      handleInActivatedState();
      return;
    }
    handleInDeactivatedState();
    this.mIsActivate = false;
  }
  
  public void updateReportSessionWhenExpired()
  {
    QLog.d("QCircleReportHelper", 1, "updateReportSessionWhenExpired");
    requestReportSession(2);
  }
  
  public void updateSubSession(int paramInt, byte[] paramArrayOfByte)
  {
    this.mSceneSubSessionMap.put(Integer.valueOf(paramInt), paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleReportHelper
 * JD-Core Version:    0.7.0.1
 */