package com.tencent.mobileqq.troop.robot.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IHotChatService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RobotSubscribeCategory;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.UinRange;
import com.tencent.mobileqq.troop.robot.TroopRobotConfBean;
import com.tencent.mobileqq.troop.robot.TroopRobotData;
import com.tencent.mobileqq.troop.robot.TroopRobotInfo;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.Callback;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.OnTalkingChangeListener;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService.UinRange;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x934.cmd0x934.ReqBody;
import tencent.im.oidb.cmd0x934.cmd0x934.RspBody;

public class TroopRobotServiceImpl
  implements ITroopRobotService
{
  private static final String COLUMN_ITEM = "barItem";
  private static final String COLUMN_UIN = "robotUin";
  public static final String TAG = "TroopRobotServiceImpl";
  static Object sLock = new Object();
  public String currentAtRobotUin = null;
  protected ArrayMap<Long, ArrayList<TroopRobotInfo>> mAddedTroopRobots = new ArrayMap(20);
  private HashMap<String, ArrayList<String>> mAioBarConfig = new HashMap();
  protected ArrayMap<Long, ArrayList<TroopRobotInfo>> mAllTroopRobots = new ArrayMap(50);
  protected AppRuntime mApp;
  List<oidb_0x496.RobotSubscribeCategory> mCategories = new ArrayList();
  protected String mCurrentRobotUin = null;
  protected List<String> mEndWords = new ArrayList(5);
  protected boolean mIsTalking = false;
  protected int mKeepOnTime = 60000;
  protected List<String> mKeywords = new ArrayList(5);
  protected WeakReference<ITroopRobotService.OnTalkingChangeListener> mOnTalkingChangeListener;
  protected ArrayList<String> mRobotRedListInShowed = null;
  private boolean mRobotSwitch = false;
  private String mRobotTailFormat = "";
  private String mRobotWarning = null;
  protected List<String> mStartWords = new ArrayList(5);
  HashMap<String, Long> mSubscribeMsgs = new HashMap();
  protected ArrayMap<Long, Integer> mTroopRobotMaxNum = new ArrayMap(50);
  protected Handler mUIHandler = new Handler(Looper.getMainLooper());
  protected List<ITroopRobotService.UinRange> mUinRanges = new ArrayList(5);
  private String mUserTailFormat = "";
  public String talkingNickname = null;
  public String talkingRobotUin = null;
  public String talkingTroopUin = null;
  
  private void initRobotInRedList(AppRuntime paramAppRuntime)
  {
    synchronized (sLock)
    {
      if (this.mRobotRedListInShowed == null)
      {
        QLog.d("TroopRobotServiceImpl", 2, "initRobotRedInRedList ");
        this.mRobotRedListInShowed = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getNewRobotListFromSp(paramAppRuntime);
        if (this.mRobotRedListInShowed == null) {
          this.mRobotRedListInShowed = new ArrayList();
        }
      }
      return;
    }
  }
  
  private void loadConfigFromSP()
  {
    Object localObject1 = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotAioBar(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        this.mAioBarConfig.clear();
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject3 != null)
          {
            String str = ((JSONObject)localObject3).optString("robotUin");
            localObject3 = ((JSONObject)localObject3).optJSONArray("barItem");
            if ((!TextUtils.isEmpty(str)) && (localObject3 != null))
            {
              ArrayList localArrayList = new ArrayList(((JSONArray)localObject3).length());
              int j = 0;
              while (j < ((JSONArray)localObject3).length())
              {
                localArrayList.add(((JSONArray)localObject3).optString(j));
                j += 1;
              }
              this.mAioBarConfig.put(str, localArrayList);
            }
          }
          i += 1;
        }
        localObject2 = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotVoiceTail(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
      }
    }
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        this.mUserTailFormat = ((JSONObject)localObject2).optString("userTail");
        this.mRobotTailFormat = ((JSONObject)localObject2).optString("robotTail");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    TroopRobotConfBean localTroopRobotConfBean = TroopRobotConfBean.a();
    if (localTroopRobotConfBean != null) {
      updateConfig(localTroopRobotConfBean.a(), localTroopRobotConfBean.a());
    }
  }
  
  private void setTalking(boolean paramBoolean)
  {
    this.mIsTalking = paramBoolean;
    this.mUIHandler.post(new TroopRobotServiceImpl.2(this));
  }
  
  private void syncCacheTimestamp(MessageRecord paramMessageRecord, String paramString)
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("robot_subcribmsg_timestamp", 0);
    long l;
    if (!this.mSubscribeMsgs.containsKey(paramString))
    {
      l = localSharedPreferences.getLong(paramString, 0L);
      this.mSubscribeMsgs.put(paramString, Long.valueOf(l));
    }
    else
    {
      l = Math.max(((Long)this.mSubscribeMsgs.get(paramString)).longValue(), localSharedPreferences.getLong(paramString, 0L));
      localSharedPreferences.edit().putLong(paramString, l).commit();
      this.mSubscribeMsgs.put(paramString, Long.valueOf(l));
    }
    if (paramMessageRecord.shmsgseq > ((Long)this.mSubscribeMsgs.get(paramString)).longValue())
    {
      localSharedPreferences.edit().putLong(paramString, paramMessageRecord.shmsgseq).commit();
      this.mSubscribeMsgs.put(paramString, Long.valueOf(paramMessageRecord.shmsgseq));
    }
  }
  
  public boolean checkAndProcessJumpRobotPage(Context paramContext, String paramString, long paramLong)
  {
    if (isRobotUin(paramLong))
    {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(paramContext, paramString, String.valueOf(paramLong));
      return true;
    }
    return false;
  }
  
  public void closeTalking()
  {
    this.talkingRobotUin = null;
    this.talkingNickname = null;
    this.talkingTroopUin = null;
    setTalking(false);
  }
  
  public void configRobotFromServer(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("robot_aio_bar");
    if (localJSONArray != null) {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).updateRobotAioBar(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), localJSONArray.toString());
    }
    paramJSONObject = paramJSONObject.optJSONObject("robot_voice_tail");
    if (paramJSONObject != null) {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).updateRobotVoiceTail(this.mApp.getApp(), this.mApp.getCurrentAccountUin(), paramJSONObject.toString());
    }
    loadConfigFromSP();
  }
  
  public oidb_0x496.RobotSubscribeCategory findSubscribeCategory(int paramInt)
  {
    Iterator localIterator = this.mCategories.iterator();
    while (localIterator.hasNext())
    {
      oidb_0x496.RobotSubscribeCategory localRobotSubscribeCategory = (oidb_0x496.RobotSubscribeCategory)localIterator.next();
      if (localRobotSubscribeCategory.id.get() == paramInt) {
        return localRobotSubscribeCategory;
      }
    }
    return null;
  }
  
  public String generateMoreDetailMsg(MessageRecord paramMessageRecord)
  {
    if (hasRobotNewsClassId(paramMessageRecord))
    {
      Object localObject = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_url");
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_short_link_description");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramMessageRecord)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramMessageRecord);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131715537));
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  public ArrayList<TroopRobotInfo> getAddedTroopRobotsForTroopCard(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    ArrayMap localArrayMap = this.mAddedTroopRobots;
    if (localArrayMap != null) {
      try
      {
        if (this.mAddedTroopRobots.containsKey(Long.valueOf(paramLong))) {
          localArrayList.addAll((Collection)this.mAddedTroopRobots.get(Long.valueOf(paramLong)));
        }
        return localArrayList;
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public ArrayList<TroopRobotInfo> getAllAddedRobots(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    ArrayMap localArrayMap = this.mAllTroopRobots;
    if (localArrayMap != null) {
      try
      {
        if (this.mAllTroopRobots.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.mAllTroopRobots.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            TroopRobotInfo localTroopRobotInfo = (TroopRobotInfo)localIterator.next();
            if (localTroopRobotInfo.a()) {
              localArrayList.add(localTroopRobotInfo);
            }
          }
        }
        return localArrayList;
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public ArrayList<TroopRobotInfo> getAllTroopRobots(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    ArrayMap localArrayMap = this.mAllTroopRobots;
    if (localArrayMap != null) {
      try
      {
        if (this.mAllTroopRobots.containsKey(Long.valueOf(paramLong))) {
          localArrayList.addAll((Collection)this.mAllTroopRobots.get(Long.valueOf(paramLong)));
        }
        return localArrayList;
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public ArrayList<TroopRobotInfo> getAllUnAddedRobots(long paramLong)
  {
    ArrayList localArrayList = new ArrayList(0);
    ArrayMap localArrayMap = this.mAllTroopRobots;
    if (localArrayMap != null) {
      try
      {
        if (this.mAllTroopRobots.containsKey(Long.valueOf(paramLong)))
        {
          Iterator localIterator = ((ArrayList)this.mAllTroopRobots.get(Long.valueOf(paramLong))).iterator();
          while (localIterator.hasNext())
          {
            TroopRobotInfo localTroopRobotInfo = (TroopRobotInfo)localIterator.next();
            if (!localTroopRobotInfo.a()) {
              localArrayList.add(localTroopRobotInfo);
            }
          }
        }
        return localArrayList;
      }
      finally {}
    }
    return localArrayList1;
  }
  
  public ArrayList<String> getCurrentRobotAioConfig()
  {
    return (ArrayList)this.mAioBarConfig.get(this.currentAtRobotUin);
  }
  
  public String getMessageKey(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageRecord.frienduin);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public String getRobotVoiceTail(String paramString)
  {
    return this.mRobotTailFormat.replace(HardCodeUtil.a(2131715524), paramString);
  }
  
  public String getRobotWarning()
  {
    return this.mRobotWarning;
  }
  
  public String getTalkingNickName()
  {
    return this.talkingNickname;
  }
  
  public String getTalkingRobotUin()
  {
    return this.talkingRobotUin;
  }
  
  public TroopRobotData getTroopRobotData(long paramLong)
  {
    TroopRobotData localTroopRobotData = new TroopRobotData();
    localTroopRobotData.jdField_a_of_type_JavaUtilArrayList = getAllAddedRobots(paramLong);
    localTroopRobotData.b = getAllUnAddedRobots(paramLong);
    localTroopRobotData.jdField_a_of_type_Int = getTroopRobotMaxNum(paramLong);
    return localTroopRobotData;
  }
  
  public int getTroopRobotMaxNum(long paramLong)
  {
    ArrayMap localArrayMap = this.mTroopRobotMaxNum;
    int i = 0;
    if (localArrayMap != null) {
      try
      {
        if (this.mTroopRobotMaxNum.containsKey(Long.valueOf(paramLong))) {
          i = ((Integer)this.mTroopRobotMaxNum.get(Long.valueOf(paramLong))).intValue();
        }
        return i;
      }
      finally {}
    }
    return 0;
  }
  
  public String getUserVoiceTail(String paramString)
  {
    return this.mUserTailFormat.replace(HardCodeUtil.a(2131715542), paramString);
  }
  
  public boolean hasNext(MessageRecord paramMessageRecord)
  {
    boolean bool2 = isRobotUin(paramMessageRecord.senderuin);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    String str = getMessageKey(paramMessageRecord);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    syncCacheTimestamp(paramMessageRecord, str);
    if (paramMessageRecord.shmsgseq == ((Long)this.mSubscribeMsgs.get(str)).longValue()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean hasProcessedMoreDetail(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("robot_processed");
    return (!TextUtils.isEmpty(paramMessageRecord)) && (paramMessageRecord.equals("true"));
  }
  
  public boolean hasRobotNewsClassId(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public boolean isEndingMsg(String paramString1, String paramString2, String paramString3)
  {
    if (isTalking())
    {
      if (this.talkingNickname == null) {
        return false;
      }
      paramString2 = new StringBuilder();
      paramString2.append("@");
      paramString2.append(this.talkingNickname);
      paramString2.append(" ");
      paramString1 = paramString1.replace(paramString2.toString(), "");
      paramString2 = new StringBuilder();
      paramString2.append("@");
      paramString2.append(this.talkingNickname);
      paramString1 = paramString1.replace(paramString2.toString(), "");
      int i = 0;
      while (i < this.mEndWords.size())
      {
        if (paramString1.equals(((String)this.mEndWords.get(i)).replace("$ROBOTNICK$", this.talkingNickname))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean isRobotSwichOn()
  {
    return this.mRobotSwitch;
  }
  
  public boolean isRobotTroop(String paramString)
  {
    IHotChatService localIHotChatService = (IHotChatService)this.mApp.getRuntimeService(IHotChatService.class, "");
    if (localIHotChatService.isHotChat(paramString)) {
      return localIHotChatService.isRobotHotChat(paramString);
    }
    paramString = ((ITroopInfoService)this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
    return (paramString != null) && ((paramString.dwAppPrivilegeFlag & 0x10000000) != 0L);
  }
  
  public boolean isRobotUin(long paramLong)
  {
    int i = 0;
    while (i < this.mUinRanges.size())
    {
      ITroopRobotService.UinRange localUinRange = (ITroopRobotService.UinRange)this.mUinRanges.get(i);
      if ((localUinRange != null) && (paramLong >= localUinRange.a) && (paramLong <= localUinRange.b)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isRobotUin(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return isRobotUin(l);
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopRobotServiceImpl", 2, QLog.getStackTraceString(paramString));
      }
    }
    return false;
  }
  
  public boolean isRobotUinNeedShowRed(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    boolean bool1 = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getIfTheRightRoleInTroopShowRobotRedDot(paramAppRuntime, paramString2);
    boolean bool2 = false;
    if (!bool1)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("isRobotUinNeedShowRed RobotRed ：");
      paramAppRuntime.append(paramString1);
      paramAppRuntime.append(" role not show red in troop:");
      paramAppRuntime.append(paramString2);
      QLog.d("TroopRobotServiceImpl", 2, paramAppRuntime.toString());
      return false;
    }
    initRobotInRedList(paramAppRuntime);
    paramAppRuntime = sLock;
    bool1 = bool2;
    try
    {
      if (this.mRobotRedListInShowed != null)
      {
        bool1 = bool2;
        if (this.mRobotRedListInShowed.contains(paramString1)) {
          bool1 = true;
        }
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("isRobotUinNeedShowRed RobotRed ：");
      paramAppRuntime.append(paramString1);
      paramAppRuntime.append(" ");
      paramAppRuntime.append(bool1);
      QLog.d("TroopRobotServiceImpl", 2, paramAppRuntime.toString());
      return bool1;
    }
    finally {}
  }
  
  public boolean isTalking()
  {
    return this.mIsTalking;
  }
  
  public boolean isTalkingMsg(String paramString1, String paramString2, String paramString3)
  {
    ITroopMemberNameService localITroopMemberNameService = (ITroopMemberNameService)this.mApp.getRuntimeService(ITroopMemberNameService.class, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString2);
    paramString2 = localITroopMemberNameService.getTroopMemberName(paramString3, localStringBuilder.toString());
    paramString3 = new StringBuilder();
    paramString3.append("@");
    paramString3.append(paramString2);
    paramString3.append(" ");
    paramString1 = paramString1.replace(paramString3.toString(), "");
    paramString3 = new StringBuilder();
    paramString3.append("@");
    paramString3.append(paramString2);
    paramString1 = paramString1.replace(paramString3.toString(), "");
    int i = 0;
    while (i < this.mStartWords.size())
    {
      if (paramString1.equals(((String)this.mStartWords.get(i)).replace("$ROBOTNICK$", paramString2))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void markStart(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3)
  {
    openTalking(paramMessageRecord.frienduin, paramString1, paramString2);
    reqGrayTips(Long.parseLong(paramMessageRecord.frienduin), Long.parseLong(paramString1), paramString3, new TroopRobotServiceImpl.4(this, paramString3));
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mStartWords.add(HardCodeUtil.a(2131715541));
    this.mEndWords.add(HardCodeUtil.a(2131715527));
    ThreadManager.post(new TroopRobotServiceImpl.1(this), 5, null, true);
  }
  
  public void onDestroy() {}
  
  public void onGetAddedRobot(long paramLong, ArrayList<TroopRobotInfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAddedRobot ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ");
      if (paramArrayList == null) {
        ??? = "null";
      } else {
        ??? = paramArrayList.toString();
      }
      localStringBuilder.append((String)???);
      QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
    }
    if ((paramArrayList != null) && (this.mAllTroopRobots != null)) {
      synchronized (this.mAddedTroopRobots)
      {
        this.mAddedTroopRobots.put(Long.valueOf(paramLong), paramArrayList);
        return;
      }
    }
  }
  
  public void onGetAllRobot(long paramLong, ArrayList<TroopRobotInfo> paramArrayList, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAllRobot ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ");
      if (paramArrayList == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramArrayList.toString();
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null)
    {
      localObject1 = this.mAllTroopRobots;
      if (localObject1 != null) {
        try
        {
          this.mAllTroopRobots.put(Long.valueOf(paramLong), paramArrayList);
        }
        finally {}
      }
    }
    paramArrayList = this.mTroopRobotMaxNum;
    if (paramArrayList != null) {
      try
      {
        this.mTroopRobotMaxNum.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
        return;
      }
      finally {}
    }
  }
  
  public void onGetRobotRedInfo(AppRuntime paramAppRuntime, long paramLong, ArrayList<String> paramArrayList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetRobotRedInfo cacheTime");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("TroopRobotServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    initRobotInRedList(paramAppRuntime);
    int i;
    int j;
    label707:
    label716:
    label725:
    synchronized (sLock)
    {
      Object localObject2 = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getHistoryRobotListFromSp(paramAppRuntime);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      int k = 0;
      if ((paramArrayList != null) && (paramArrayList.size() != 0))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetRobotRedInfo historyList ");
        ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
        ((StringBuilder)localObject2).append(" uinList: ");
        ((StringBuilder)localObject2).append(paramArrayList.size());
        ((StringBuilder)localObject2).append(" red:");
        ((StringBuilder)localObject2).append(this.mRobotRedListInShowed.size());
        QLog.d("TroopRobotServiceImpl", 2, ((StringBuilder)localObject2).toString());
        try
        {
          i = this.mRobotRedListInShowed.size() - 1;
          StringBuilder localStringBuilder;
          if (i >= 0)
          {
            localObject2 = (String)this.mRobotRedListInShowed.get(i);
            if (paramArrayList.contains(localObject2)) {
              break label707;
            }
            this.mRobotRedListInShowed.remove(i);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onGetRobotRedInfo remove red newing ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(" index: ");
            localStringBuilder.append(i);
            QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
            break label707;
          }
          i = paramArrayList.size() - 1;
          j = k;
          if (i >= 0)
          {
            localObject2 = (String)paramArrayList.get(i);
            if (((ArrayList)localObject1).contains(localObject2))
            {
              paramArrayList.remove(i);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onGetRobotRedInfo remove red uinList ");
              localStringBuilder.append((String)localObject2);
              localStringBuilder.append(" index: ");
              localStringBuilder.append(i);
              QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
              break label716;
            }
            ((ArrayList)localObject1).add(localObject2);
            break label716;
          }
          if (j < paramArrayList.size())
          {
            localObject2 = (String)paramArrayList.get(j);
            if (this.mRobotRedListInShowed.contains(localObject2)) {
              break label725;
            }
            this.mRobotRedListInShowed.add(localObject2);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onGetRobotRedInfo add red uinList ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(" index: ");
            localStringBuilder.append(j);
            QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
            break label725;
          }
          ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(paramAppRuntime, this.mRobotRedListInShowed);
          ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setHistoryRobotListToSp(paramAppRuntime, (ArrayList)localObject1);
          if (paramArrayList.size() > 0)
          {
            ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(paramAppRuntime, true);
            ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setNeedShowRobotRedDotAio(paramAppRuntime, true);
          }
        }
        catch (Exception paramAppRuntime)
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("onGetRobotRedInfo REMOVE EXCEPTION");
          paramArrayList.append(paramAppRuntime.toString());
          QLog.e("TroopRobotServiceImpl", 2, paramArrayList.toString());
        }
      }
      else
      {
        this.mRobotRedListInShowed.clear();
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(paramAppRuntime, this.mRobotRedListInShowed);
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(paramAppRuntime, false);
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setNeedShowRobotRedDotAio(paramAppRuntime, false);
        return;
      }
    }
  }
  
  public void onSetTroopRobot(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSetTroopRobot troopuin:");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append(" robotuin:");
      ((StringBuilder)localObject1).append(paramLong2);
      ((StringBuilder)localObject1).append(" status:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("TroopRobotServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayMap localArrayMap = this.mAllTroopRobots;
    if (localArrayMap != null) {
      try
      {
        if (this.mAllTroopRobots.containsKey(Long.valueOf(paramLong1)))
        {
          ArrayList localArrayList = (ArrayList)this.mAllTroopRobots.get(Long.valueOf(paramLong1));
          Object localObject3 = null;
          StringBuilder localStringBuilder = null;
          Iterator localIterator = localArrayList.iterator();
          TroopRobotInfo localTroopRobotInfo;
          do
          {
            localObject1 = localObject3;
            if (!localIterator.hasNext()) {
              break;
            }
            localTroopRobotInfo = (TroopRobotInfo)localIterator.next();
          } while (localTroopRobotInfo.a() != paramLong2);
          localObject1 = localStringBuilder;
          if (!localTroopRobotInfo.a())
          {
            localObject1 = localStringBuilder;
            if (paramInt == 1) {
              localObject1 = localTroopRobotInfo;
            }
          }
          localTroopRobotInfo.a(paramInt);
          if (localObject1 != null)
          {
            localArrayList.remove(localObject1);
            localArrayList.add(0, localObject1);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onSetTroopRobot move position ");
              localStringBuilder.append(((TroopRobotInfo)localObject1).a());
              QLog.d("TroopRobotServiceImpl", 2, localStringBuilder.toString());
            }
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public void openTalking(String paramString1, String paramString2)
  {
    openTalking("1", paramString1, paramString2);
  }
  
  public void openTalking(String paramString1, String paramString2, String paramString3)
  {
    this.talkingRobotUin = paramString2;
    this.talkingNickname = paramString3;
    this.talkingTroopUin = paramString1;
    setTalking(true);
  }
  
  public void preProcessMessageMoreDetail(MessageRecord paramMessageRecord)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.msg))
    {
      Object localObject = Patterns.d.matcher(paramMessageRecord.msg);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group(0);
        int i = paramMessageRecord.msg.indexOf((String)localObject);
        if (i >= 0)
        {
          String str = paramMessageRecord.msg.substring(0, i);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_url", (String)localObject);
          paramMessageRecord.saveExtInfoToExtStr("robot_short_link_description", str);
          paramMessageRecord.saveExtInfoToExtStr("robot_processed", "true");
        }
      }
    }
  }
  
  public byte[] readRobotConfig()
  {
    return FileUtils.fileToBytes(BaseApplication.getContext().getFileStreamPath("troop_robot_config"));
  }
  
  public byte[] readRobotPanelData(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_robot_panel_data_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()));
  }
  
  public void release(String paramString1, String paramString2, String paramString3)
  {
    if ((this.talkingNickname == null) || (!TextUtils.isEmpty(paramString1))) {}
    try
    {
      reqGrayTips(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new TroopRobotServiceImpl.3(this, paramString3));
    }
    catch (Exception paramString3)
    {
      label39:
      break label39;
    }
    paramString3 = new StringBuilder();
    paramString3.append("release exception, troopuin:");
    paramString3.append(paramString1);
    paramString3.append(" robotuin:");
    paramString3.append(paramString2);
    QLog.e("TroopRobotServiceImpl", 2, paramString3.toString());
    closeTalking();
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  public void removeRobotUinInRed(AppRuntime paramAppRuntime, String paramString)
  {
    initRobotInRedList(paramAppRuntime);
    synchronized (sLock)
    {
      if ((this.mRobotRedListInShowed != null) && (this.mRobotRedListInShowed.contains(paramString))) {
        this.mRobotRedListInShowed.remove(paramString);
      }
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setNewRobotListToSp(paramAppRuntime, this.mRobotRedListInShowed);
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("removeRobotRedUinInRed ");
      paramAppRuntime.append(paramString);
      QLog.d("TroopRobotServiceImpl", 2, paramAppRuntime.toString());
      return;
    }
  }
  
  public void report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "Grp_robot", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void reqGrayTips(long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback)
  {
    reqGrayTipsInner(2, paramLong1, paramLong2, paramString, paramCallback);
  }
  
  public void reqGrayTips(long paramLong, String paramString, ITroopRobotService.Callback paramCallback)
  {
    reqGrayTipsInner(2, Long.valueOf("1").longValue(), paramLong, paramString, paramCallback);
  }
  
  public void reqGrayTipsInner(int paramInt, long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    ProtoUtils.a(this.mApp, new TroopRobotServiceImpl.9(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void reqPanelList(long paramLong, int paramInt, ITroopRobotService.Callback paramCallback)
  {
    reqPanelListInner(4, 0L, paramLong, paramInt, paramCallback);
  }
  
  public void reqPanelList(long paramLong1, long paramLong2, int paramInt, ITroopRobotService.Callback paramCallback)
  {
    reqPanelListInner(1, paramLong1, paramLong2, paramInt, paramCallback);
  }
  
  public void reqPanelListInner(int paramInt1, long paramLong1, long paramLong2, int paramInt2, ITroopRobotService.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt1, true);
    localReqBody.version.set(paramInt2, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.robot_uin.set(paramLong2);
    ProtoUtils.a(this.mApp, new TroopRobotServiceImpl.7(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void saveRobotConfig(oidb_0x496.Robot paramRobot)
  {
    ThreadManager.post(new TroopRobotServiceImpl.5(this, paramRobot), 5, null, true);
  }
  
  public void saveRobotPanelData(String paramString1, String paramString2, cmd0x934.RspBody paramRspBody)
  {
    ThreadManager.post(new TroopRobotServiceImpl.6(this, paramString1, paramString2, paramRspBody), 5, null, true);
  }
  
  public void sendContent(long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback)
  {
    sendContentInner(3, paramLong1, paramLong2, paramString, paramCallback);
  }
  
  public void sendContent(long paramLong, String paramString, ITroopRobotService.Callback paramCallback)
  {
    sendContent(Long.valueOf("1").longValue(), paramLong, paramString, paramCallback);
  }
  
  public void sendContentInner(int paramInt, long paramLong1, long paramLong2, String paramString, ITroopRobotService.Callback paramCallback)
  {
    cmd0x934.ReqBody localReqBody = new cmd0x934.ReqBody();
    localReqBody.cmd.set(paramInt, true);
    localReqBody.group_id.set(paramLong1, true);
    localReqBody.keyword.set(paramString, true);
    localReqBody.robot_uin.set(paramLong2);
    ProtoUtils.a(this.mApp, new TroopRobotServiceImpl.8(this, paramCallback), localReqBody.toByteArray(), "OidbSvc.0x934_1", 2356, 1, new Bundle(), 12000L);
  }
  
  public void setCurrentAtRobotUin(String paramString)
  {
    this.currentAtRobotUin = paramString;
  }
  
  public void setOnTalkingChangeListener(ITroopRobotService.OnTalkingChangeListener paramOnTalkingChangeListener)
  {
    if (paramOnTalkingChangeListener == null)
    {
      this.mOnTalkingChangeListener = null;
      return;
    }
    this.mOnTalkingChangeListener = new WeakReference(paramOnTalkingChangeListener);
  }
  
  public void setRobotConfig(oidb_0x496.Robot paramRobot)
  {
    try
    {
      boolean bool = paramRobot.uin_range.has();
      int j = 0;
      int i;
      if (bool)
      {
        this.mUinRanges.clear();
        i = 0;
        while ((i < paramRobot.uin_range.size()) && (i < 5))
        {
          oidb_0x496.UinRange localUinRange = (oidb_0x496.UinRange)paramRobot.uin_range.get(i);
          ITroopRobotService.UinRange localUinRange1 = new ITroopRobotService.UinRange();
          localUinRange1.a = localUinRange.start_uin.get();
          localUinRange1.b = localUinRange.end_uin.get();
          this.mUinRanges.add(localUinRange1);
          i += 1;
        }
      }
      if (paramRobot.fire_keywords.has())
      {
        this.mKeywords.clear();
        i = 0;
        while ((i < paramRobot.fire_keywords.size()) && (i < 5))
        {
          this.mKeywords.add(paramRobot.fire_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.start_keywords.has())
      {
        this.mStartWords.clear();
        i = 0;
        while ((i < paramRobot.start_keywords.size()) && (i < 5))
        {
          this.mStartWords.add(paramRobot.start_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.end_keywords.has())
      {
        this.mEndWords.clear();
        i = j;
        while ((i < paramRobot.end_keywords.size()) && (i < 5))
        {
          this.mEndWords.add(paramRobot.end_keywords.get(i));
          i += 1;
        }
      }
      if (paramRobot.session_timeout.has()) {
        this.mKeepOnTime = paramRobot.session_timeout.get();
      }
      if (paramRobot.subscribe_categories.has())
      {
        this.mCategories.clear();
        this.mCategories.addAll(paramRobot.subscribe_categories.get());
      }
      if (QLog.isColorLevel())
      {
        paramRobot = new StringBuilder();
        paramRobot.append("setRobotConfig ");
        paramRobot.append(this.mUinRanges.toString());
        QLog.i("TroopRobotServiceImpl", 2, paramRobot.toString());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramRobot;
    }
  }
  
  public void updateConfig(boolean paramBoolean, String paramString)
  {
    this.mRobotSwitch = paramBoolean;
    this.mRobotWarning = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.robot.api.impl.TroopRobotServiceImpl
 * JD-Core Version:    0.7.0.1
 */