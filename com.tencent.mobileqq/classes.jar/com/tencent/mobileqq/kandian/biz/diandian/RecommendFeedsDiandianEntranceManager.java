package com.tencent.mobileqq.kandian.biz.diandian;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.diandian.api.IRecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.reddot.OnEntryIconRefreshListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.mobileqq.kandian.repo.diandian.ExtraInfo;
import com.tencent.mobileqq.kandian.repo.diandian.IEntranceButtonDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.RIJColumnDataSource;
import com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule;
import com.tencent.mobileqq.kandian.repo.diandian.ReadInJoyDianDianEntranceModule.OnIconRefreshCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class RecommendFeedsDiandianEntranceManager
  implements IRecommendFeedsDiandianEntranceManager
{
  public static final String CONFIG_ENTERY_TYPE_KEY = "readinjoy_video_recommend_entrance_direct";
  public static final String CONFIG_REFRESH_INTERVAL_KEY = "diandian_icon_refresh_time_interval";
  public static final int DEFAULT_INTERVAL = 1;
  public static final int ENTRANCE_FEEDS_TYPE_FOLLOW = 3;
  public static final int ENTRANCE_FEEDS_TYPE_NONE = 0;
  public static final int ENTRANCE_FEEDS_TYPE_RECOMMEND = 5;
  public static final int ENTRANCE_FEEDS_TYPE_REFRESH = 6;
  public static final int ENTRANCE_FEEDS_TYPE_TRIBE = 4;
  public static final int ENTRANCE_FEEDS_TYPE_VIDEO = 2;
  public static final int ENTRANCE_FEEDS_TYPE_VIDEO_CHANNEL = 1;
  public static final String ENTRY_CLICK_BIG_T = "0X80094FF";
  public static final String ENTRY_EXPOSURE_BIG_T = "0X80094FE";
  public static final String FOLLOW_DEFAULT_SCHEMA = "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
  public static final String KEY_DAILY_BOTTOM_ENTRY_DATA = "daily_bottom_entry_data";
  public static final String KEY_ENTRANCE_SCHEMA = "KEY_ENTRANCE_SCHEMA";
  public static final String KEY_REDIRECT_FEEDS_TYPE = "redirect_feeds_type";
  public static final String KEY_SP_ICON_INFO = "DianDianEntryIconInfo";
  public static final String KEY_TRIGER_SRC = "daily_bottom_triger_src";
  public static final int SRC_DAILY_FEEDS = 1;
  public static final int SRC_RECOMMEND_FEEDS = 0;
  private static final String TAG = "RecommendFeedsDiandianEntranceManager";
  public static final String TRIBE_DEFAULT_SCHEMA = "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";
  private static EntranceIconInfo mCurIconInfo = null;
  private static RecommendFeedsDiandianEntranceManager mInstance;
  private static int sFeedsType = ;
  private static int sRefreshInterval = 1;
  private int mDailyMode = -1;
  private List<OnEntryIconRefreshListener> mListeners = null;
  private ReadInJoyDianDianEntranceModule.OnIconRefreshCallback onIconRefreshCallback = new RecommendFeedsDiandianEntranceManager.1(this);
  private long sLastExitTime = 0L;
  
  static
  {
    mInstance = null;
  }
  
  private RecommendFeedsDiandianEntranceManager()
  {
    Object localObject = Aladdin.getConfig(216);
    if (localObject != null) {
      sRefreshInterval = (int)(((AladdinConfig)localObject).getFloatFromString("diandian_icon_refresh_time_interval", 1.0F) * 60.0F * 1000.0F);
    }
    this.mListeners = new ArrayList();
    checkAndUpdateIconInfo("init");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("entrance manager init sRefreshInterval : ");
    ((StringBuilder)localObject).append(sRefreshInterval);
    ((StringBuilder)localObject).append("; feedsType : ");
    ((StringBuilder)localObject).append(sFeedsType);
    ((StringBuilder)localObject).append(" ; curIconInfo : ");
    ((StringBuilder)localObject).append(mCurIconInfo);
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject).toString());
  }
  
  private void checkAndUpdateIconInfo(String paramString)
  {
    int i = ReadInJoyHelper.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndUpdateIconInfo | reason ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("; configFeedsType : ");
    localStringBuilder.append(i);
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    paramString = getIconInfoFromSp();
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndUpdateIconInfo | spIconInfo : ");
      localStringBuilder.append(paramString);
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
      if (paramString.jdField_a_of_type_Int != i)
      {
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, "checkAndUpdateIconInfo | spIconInfo updated");
        if (isFollowOrTribeFeedsType(i))
        {
          mCurIconInfo = EntranceIconInfo.a(i, getFeedsDefaultSchema(i));
          saveIconInfo2Sp();
        }
      }
      else
      {
        mCurIconInfo = paramString;
      }
    }
    else if (!isFollowOrTribeFeedsType(i))
    {
      mCurIconInfo = null;
    }
    else
    {
      mCurIconInfo = EntranceIconInfo.a(i, getFeedsDefaultSchema(i));
      paramString = new StringBuilder();
      paramString.append("checkAndUpdateIconInfo | buildIconInfo with configFeedsType : ");
      paramString.append(i);
      paramString.append(" ; curIconInfo : ");
      paramString.append(mCurIconInfo);
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, paramString.toString());
    }
    sFeedsType = i;
  }
  
  private String getColumnDiandianR5(RIJColumnDataSource paramRIJColumnDataSource, int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trigger_src", paramInt2);
      localJSONObject.put("click_area", paramInt1);
      localJSONObject.put("channel_id", paramInt3);
      if (paramRIJColumnDataSource != null)
      {
        localJSONObject.put("column_id", paramRIJColumnDataSource.jdField_a_of_type_Int);
        localJSONObject.put("rowkey", paramRIJColumnDataSource.d);
        localJSONObject.put("video_report_info", paramRIJColumnDataSource.e);
      }
      localJSONObject.put("diandianfeeds_type", 6);
    }
    catch (Exception paramRIJColumnDataSource)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColumnDiandianR5 error! e=");
      localStringBuilder.append(paramRIJColumnDataSource);
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public static int getDefaultFeedsIconSrcId()
  {
    int j = ReadInJoyHelper.e();
    int i = 2130849669;
    if ((j != 1) && (j != 2))
    {
      if (j != 3)
      {
        if (j != 4) {
          return 2130849669;
        }
        return 2130849704;
      }
    }
    else {
      i = 2130843228;
    }
    return i;
  }
  
  public static String getEntranceSchema()
  {
    return (String)RIJSPUtils.a("KEY_ENTRANCE_SCHEMA", "");
  }
  
  public static String getFeedsDefaultSchema(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        if (hasEntranceStorageSchema())
        {
          String str = getEntranceSchema();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hasEntranceStorageSchema: ");
          localStringBuilder.append(str);
          QLog.d("RecommendFeedsDiandianEntranceManager", 1, localStringBuilder.toString());
          return str;
        }
        return "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
      }
      return ReadInJoyHelper.a();
    }
    return "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";
  }
  
  private int getFollowEntryReportOpType()
  {
    EntranceIconInfo localEntranceIconInfo = mCurIconInfo;
    if (localEntranceIconInfo == null) {
      return -1;
    }
    return localEntranceIconInfo.jdField_b_of_type_Int;
  }
  
  private EntranceIconInfo getIconInfoFromSp()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 != null) {
      localObject1 = RIJSPUtils.a((String)localObject1);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      try
      {
        localObject1 = ((SharedPreferences)localObject1).getString("DianDianEntryIconInfo", "");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        Object localObject2 = new JSONObject((String)localObject1);
        if (!isFollowOrTribeFeedsType(((JSONObject)localObject2).optInt("feeds_type", 3))) {
          return null;
        }
        localObject1 = new EntranceIconInfo();
        ((EntranceIconInfo)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("icon_url", "");
        ((EntranceIconInfo)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("feeds_type", 3);
        ((EntranceIconInfo)localObject1).c = ((JSONObject)localObject2).optString("jump_schema", "");
        ((EntranceIconInfo)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).optString("small_icon_url", "");
        ((EntranceIconInfo)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).optBoolean("use_gif", false);
        ExtraInfo localExtraInfo = new ExtraInfo();
        localExtraInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("report_str", "");
        ((EntranceIconInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo = localExtraInfo;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getIconInfoFromSp entryInfo ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "getIconInfoFromSp entryInfo is null");
    return null;
  }
  
  public static RecommendFeedsDiandianEntranceManager getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new RecommendFeedsDiandianEntranceManager();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private String getSpKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Feeds_type_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void handleDianDianIconRefresh(IEntranceButtonDataSource paramIEntranceButtonDataSource)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleDianDianIconRefresh | updateIconInfo : ");
    ((StringBuilder)localObject).append(paramIEntranceButtonDataSource);
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject).toString());
    mCurIconInfo = (EntranceIconInfo)paramIEntranceButtonDataSource;
    paramIEntranceButtonDataSource = mCurIconInfo;
    if (paramIEntranceButtonDataSource != null)
    {
      sFeedsType = paramIEntranceButtonDataSource.jdField_a_of_type_Int;
      paramIEntranceButtonDataSource = new StringBuilder();
      paramIEntranceButtonDataSource.append("handleDianDianIconRefresh | sFeedsType update : ");
      paramIEntranceButtonDataSource.append(sFeedsType);
      QLog.d("RecommendFeedsDiandianEntranceManager", 1, paramIEntranceButtonDataSource.toString());
    }
    saveIconInfo2Sp();
    paramIEntranceButtonDataSource = this.mListeners;
    if (paramIEntranceButtonDataSource != null)
    {
      paramIEntranceButtonDataSource = paramIEntranceButtonDataSource.iterator();
      while (paramIEntranceButtonDataSource.hasNext())
      {
        localObject = (OnEntryIconRefreshListener)paramIEntranceButtonDataSource.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.2(this, (OnEntryIconRefreshListener)localObject));
      }
    }
  }
  
  private static boolean hasEntranceStorageSchema()
  {
    return TextUtils.isEmpty(getEntranceSchema()) ^ true;
  }
  
  public static boolean isColoumnFeedsType(int paramInt)
  {
    return paramInt == 6;
  }
  
  public static boolean isFollowOrTribeFeedsType(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  private void saveIconInfo2Sp()
  {
    Object localObject = mCurIconInfo;
    SharedPreferences localSharedPreferences;
    if (localObject != null)
    {
      if (!isFollowOrTribeFeedsType(((EntranceIconInfo)localObject).jdField_a_of_type_Int)) {
        return;
      }
      localSharedPreferences = RIJSPUtils.a(RIJQQAppInterfaceUtil.a().getCurrentUin());
      if (localSharedPreferences == null) {}
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("feeds_type", mCurIconInfo.jdField_a_of_type_Int);
        localJSONObject.put("icon_url", mCurIconInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("small_icon_url", mCurIconInfo.jdField_b_of_type_JavaLangString);
        localJSONObject.put("jump_schema", mCurIconInfo.c);
        if (mCurIconInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo == null) {
          break label206;
        }
        localObject = mCurIconInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoDiandianExtraInfo.jdField_a_of_type_JavaLangString;
        localJSONObject.put("report_str", localObject);
        localJSONObject.put("use_gif", mCurIconInfo.jdField_a_of_type_Boolean);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveIconInfo2Sp | jsonStr : ");
        ((StringBuilder)localObject).append(localJSONObject.toString());
        QLog.d("RecommendFeedsDiandianEntranceManager", 1, ((StringBuilder)localObject).toString());
        localSharedPreferences.edit().putString("DianDianEntryIconInfo", localJSONObject.toString()).apply();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label206:
      String str = "";
    }
  }
  
  public void addEntryRefreshListener(OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    List localList = this.mListeners;
    if ((localList != null) && (paramOnEntryIconRefreshListener != null) && (!localList.contains(paramOnEntryIconRefreshListener))) {
      this.mListeners.add(paramOnEntryIconRefreshListener);
    }
  }
  
  public void checkAndReqRefreshDianDianIcon()
  {
    long l = System.currentTimeMillis() - this.sLastExitTime;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkAndReqRefreshDianDianIcon | request refresh icon info ,timeinterval : ");
    ((StringBuilder)localObject1).append(l);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" RefreshInterval: ");
    ((StringBuilder)localObject2).append(sRefreshInterval);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" LastExitTime: ");
    localStringBuilder.append(this.sLastExitTime);
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, new Object[] { localObject1, localObject2, localStringBuilder.toString() });
    if (l < sRefreshInterval) {
      return;
    }
    if (!isFollowOrTribeFeedsType(sFeedsType)) {
      return;
    }
    localObject1 = ReadInJoyLogicEngine.a().a();
    if (localObject1 != null)
    {
      this.sLastExitTime = System.currentTimeMillis();
      ((ReadInJoyDianDianEntranceModule)localObject1).a(this.onIconRefreshCallback);
      ReadInJoyLogicEngine.a().a().a(sFeedsType);
      ((ReadInJoyDianDianEntranceModule)localObject1).b(this.onIconRefreshCallback);
    }
  }
  
  public void clearRedIconInfo()
  {
    if (mCurIconInfo != null) {
      mCurIconInfo = null;
    }
  }
  
  public void columnDiandianClickReport(RIJColumnDataSource paramRIJColumnDataSource, int paramInt1, int paramInt2, int paramInt3)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", getColumnDiandianR5(paramRIJColumnDataSource, paramInt1, paramInt2, paramInt3), false);
  }
  
  public int getEntryFeedsType()
  {
    return sFeedsType;
  }
  
  @NotNull
  public String getReportR5Str(int paramInt1, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      int i = sFeedsType;
      String str = String.valueOf(paramInt2);
      paramInt2 = i;
      if (paramInt1 == 1)
      {
        paramInt2 = i;
        if (this.mDailyMode == 3) {
          paramInt2 = 6;
        }
        str = KandianDailyReportUtils.b();
      }
      localJSONObject.put("diandianfeeds_type", paramInt2);
      localJSONObject.put("trigger_src", paramInt1);
      localJSONObject.put("channel_id", str);
      if (paramInt2 == 3) {
        localJSONObject.put("jump_to", getFollowEntryReportOpType());
      }
      str = localJSONObject.toString();
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public boolean isVideoFeedsType()
  {
    int i = ReadInJoyHelper.e();
    boolean bool = true;
    if (i != 1)
    {
      if (i == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void onAccountChange()
  {
    QLog.d("RecommendFeedsDiandianEntranceManager", 1, "onAccountChange");
    checkAndUpdateIconInfo("onAccountChange");
    if ((this.mListeners != null) && (!isVideoFeedsType()))
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        OnEntryIconRefreshListener localOnEntryIconRefreshListener = (OnEntryIconRefreshListener)localIterator.next();
        ThreadManager.getUIHandler().post(new RecommendFeedsDiandianEntranceManager.3(this, localOnEntryIconRefreshListener));
      }
    }
  }
  
  public void removeEntryRefreshListener(OnEntryIconRefreshListener paramOnEntryIconRefreshListener)
  {
    List localList = this.mListeners;
    if ((localList != null) && (paramOnEntryIconRefreshListener != null)) {
      localList.remove(paramOnEntryIconRefreshListener);
    }
  }
  
  public void reportEntryIconClick(int paramInt1, int paramInt2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", getReportR5Str(paramInt1, paramInt2), false);
  }
  
  public void reportEntryIconExposure(int paramInt1, int paramInt2)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", getReportR5Str(paramInt1, paramInt2), false);
  }
  
  public void setDailyMode(int paramInt)
  {
    this.mDailyMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager
 * JD-Core Version:    0.7.0.1
 */