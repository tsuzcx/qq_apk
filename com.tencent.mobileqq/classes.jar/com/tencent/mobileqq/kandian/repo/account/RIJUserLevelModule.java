package com.tencent.mobileqq.kandian.repo.account;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.account.RIJUserLevelDenyCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.account.api.IRIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;

public class RIJUserLevelModule
  implements IRIJUserLevelModule
{
  public static final String NEED_INTERCEPT = "need_intercept";
  private static final String TAG = "RIJUserLevelModel";
  private static final String USER_LEVEL_INFO_SP = "user_info_level_sp";
  private static volatile RIJUserLevelModule instance;
  private boolean hasPreRequest = false;
  private List<RIJUserLevelModule.UserLevelInfoUpdateListener> levelInfoUpdateListeners = new ArrayList();
  private RIJUserLevelModule.UserLevelDenyCallback userLevelDenyCallback = null;
  private Map<Long, UserLevelInfo> userLevelInfoCache = new HashMap();
  
  private RIJUserLevelModule()
  {
    RIJUserLevelModule.1 local1 = new RIJUserLevelModule.1(this);
    ReadInJoyLogicEngineEventDispatcher.a().a(local1);
    loadUserInfoFromSP();
    setUserLevelDenyCallback(new RIJUserLevelDenyCallback());
  }
  
  private void addData2Cache(Object paramObject)
  {
    Gson localGson = new Gson();
    if ((paramObject instanceof String))
    {
      paramObject = (UserLevelInfo)localGson.fromJson(paramObject.toString(), UserLevelInfo.class);
      if (paramObject != null) {
        this.userLevelInfoCache.put(Long.valueOf(paramObject.uin), paramObject);
      }
    }
  }
  
  private void doCallBack(UserLevelInfo paramUserLevelInfo, IUserLevelCallBack paramIUserLevelCallBack)
  {
    if (paramIUserLevelCallBack != null) {
      paramIUserLevelCallBack.a(paramUserLevelInfo);
    }
  }
  
  public static RIJUserLevelModule getInstance()
  {
    try
    {
      if (instance == null) {
        try
        {
          if (instance == null) {
            instance = new RIJUserLevelModule();
          }
        }
        finally {}
      }
      RIJUserLevelModule localRIJUserLevelModule = instance;
      return localRIJUserLevelModule;
    }
    finally {}
  }
  
  private UserLevelInfo getUserLevelInfo(long paramLong)
  {
    UserLevelInfo localUserLevelInfo2 = (UserLevelInfo)this.userLevelInfoCache.get(Long.valueOf(paramLong));
    UserLevelInfo localUserLevelInfo1 = localUserLevelInfo2;
    if (localUserLevelInfo2 == null)
    {
      localUserLevelInfo1 = new UserLevelInfo();
      localUserLevelInfo1.uin = paramLong;
      this.userLevelInfoCache.put(Long.valueOf(paramLong), localUserLevelInfo1);
    }
    return localUserLevelInfo1;
  }
  
  public static boolean isSwitchOpen()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(389);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("ugc_privilege_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void loadUserInfoFromSP()
  {
    String str = (String)RIJSPUtils.b("user_info_level_sp", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(str);
        int i = 0;
        while (i < localJSONArray.length())
        {
          addData2Cache(localJSONArray.get(i));
          i += 1;
        }
        StringBuilder localStringBuilder2;
        localStringBuilder1 = new StringBuilder();
      }
      catch (Exception localException)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("loadUserInfoFromSP error! msg=");
        localStringBuilder2.append(localException);
        QLog.d("RIJUserLevelModel", 1, localStringBuilder2.toString());
      }
    }
    StringBuilder localStringBuilder1;
    localStringBuilder1.append("loadUserInfoFromSP ,data=");
    localStringBuilder1.append(str);
    QLog.d("RIJUserLevelModel", 1, localStringBuilder1.toString());
  }
  
  private void notifyUserLevelInfoUpdate(UserLevelInfo paramUserLevelInfo)
  {
    ThreadManagerV2.getUIHandlerV2().post(new RIJUserLevelModule.2(this, paramUserLevelInfo));
  }
  
  private void requestUserLevel(long paramLong, int paramInt)
  {
    RIJUserLevelRequestModule localRIJUserLevelRequestModule = ReadInJoyLogicEngine.a().af();
    if (localRIJUserLevelRequestModule != null) {
      localRIJUserLevelRequestModule.a(paramLong, paramInt);
    }
  }
  
  private void save2Local()
  {
    Object localObject = new Gson();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.userLevelInfoCache.entrySet().iterator();
    while (localIterator.hasNext())
    {
      String str = ((Gson)localObject).toJson((UserLevelInfo)((Map.Entry)localIterator.next()).getValue());
      if (!TextUtils.isEmpty(str)) {
        localJSONArray.put(str);
      }
    }
    if (localJSONArray.length() > 0) {
      RIJSPUtils.a("user_info_level_sp", localJSONArray.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("save2Local ,datas=");
    ((StringBuilder)localObject).append(localJSONArray);
    QLog.d("RIJUserLevelModel", 1, ((StringBuilder)localObject).toString());
  }
  
  private void saveUserLevelInfo(UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo == null) {
      return;
    }
    this.userLevelInfoCache.put(Long.valueOf(paramUserLevelInfo.uin), paramUserLevelInfo);
    save2Local();
  }
  
  private void updateAllowMap(UserLevelInfo paramUserLevelInfo, long paramLong, int paramInt1, int paramInt2)
  {
    paramUserLevelInfo = paramUserLevelInfo.opesAllowedMap;
    boolean bool;
    if ((paramLong & paramInt1) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    paramUserLevelInfo.put(Integer.valueOf(paramInt2), Boolean.valueOf(bool));
  }
  
  private void updateAllowMap(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, UserLevelInfo paramUserLevelInfo)
  {
    long l = paramPrivilegeRspBody.allow_bits.get();
    updateAllowMap(paramUserLevelInfo, l, 1, 1);
    updateAllowMap(paramUserLevelInfo, l, 2, 2);
    updateAllowMap(paramUserLevelInfo, l, 4, 3);
    updateAllowMap(paramUserLevelInfo, l, 8, 4);
    updateAllowMap(paramUserLevelInfo, l, 16, 5);
    updateAllowMap(paramUserLevelInfo, l, 32, 6);
    updateAllowMap(paramUserLevelInfo, l, 64, 7);
    updateAllowMap(paramUserLevelInfo, l, 128, 8);
    updateAllowMap(paramUserLevelInfo, l, 256, 9);
    updateAllowMap(paramUserLevelInfo, l, 512, 10);
    updateAllowMap(paramUserLevelInfo, l, 1024, 11);
  }
  
  private void updateUserLevelInfo(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt)
  {
    QLog.d("RIJUserLevelModel", 1, "updateUserLevelInfo!");
    if (paramPrivilegeRspBody == null) {
      return;
    }
    UserLevelInfo localUserLevelInfo = getUserLevelInfo(paramLong);
    localUserLevelInfo.jumpUrl = RIJPBFieldUtils.a(paramPrivilegeRspBody.jump_url);
    localUserLevelInfo.level = RIJPBFieldUtils.a(paramPrivilegeRspBody.level);
    localUserLevelInfo.opesAllowedMap.put(Integer.valueOf(paramInt), Boolean.valueOf(RIJPBFieldUtils.a(paramPrivilegeRspBody.is_allowed)));
    updateAllowMap(paramPrivilegeRspBody, localUserLevelInfo);
    localUserLevelInfo.dailyTopicNum = RIJPBFieldUtils.a(paramPrivilegeRspBody.daily_topic_num);
    localUserLevelInfo.operFobidWording.put(Integer.valueOf(paramInt), RIJPBFieldUtils.a(paramPrivilegeRspBody.forbid_wording, ""));
    localUserLevelInfo.isInLevelGrayList = RIJPBFieldUtils.a(paramPrivilegeRspBody.is_experience);
    saveUserLevelInfo(localUserLevelInfo);
    notifyUserLevelInfoUpdate(localUserLevelInfo);
    paramPrivilegeRspBody = new StringBuilder();
    paramPrivilegeRspBody.append("updateUserLevelInfo! cacheUserLevelInfo=");
    paramPrivilegeRspBody.append(localUserLevelInfo);
    QLog.d("RIJUserLevelModel", 1, paramPrivilegeRspBody.toString());
  }
  
  public void addUserLevelInfoUpdateListener(RIJUserLevelModule.UserLevelInfoUpdateListener paramUserLevelInfoUpdateListener)
  {
    this.levelInfoUpdateListeners.add(paramUserLevelInfoUpdateListener);
  }
  
  public boolean doActionsByUserLevel(Context paramContext, int paramInt, @Nullable IUserLevelCallBack paramIUserLevelCallBack)
  {
    UserLevelInfo localUserLevelInfo = getCurrentUserLevelInfo(paramInt);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      boolean bool = isSwitchOpen();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doActionsByUserLevel ,switchOpen=");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" operType=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("RIJUserLevelModel", 1, ((StringBuilder)localObject).toString());
      if (!bool)
      {
        doCallBack(localUserLevelInfo, paramIUserLevelCallBack);
        return true;
      }
      localObject = (Boolean)localUserLevelInfo.opesAllowedMap.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
        bool = false;
      } else {
        bool = true;
      }
      if (bool)
      {
        doCallBack(localUserLevelInfo, paramIUserLevelCallBack);
      }
      else
      {
        paramIUserLevelCallBack = this.userLevelDenyCallback;
        if ((paramIUserLevelCallBack != null) && (paramContext != null) && (localUserLevelInfo != null)) {
          paramIUserLevelCallBack.a(paramContext, localUserLevelInfo);
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("doActionsByUserLevel ,isAllow=");
      paramContext.append(localObject);
      QLog.d("RIJUserLevelModel", 1, paramContext.toString());
      requestUserLevel(localUserLevelInfo.uin, paramInt);
      return bool;
    }
    doCallBack(localUserLevelInfo, paramIUserLevelCallBack);
    return true;
  }
  
  public boolean getCacheUserLevel(int paramInt)
  {
    return getCacheUserLevel(paramInt, true);
  }
  
  public boolean getCacheUserLevel(int paramInt, boolean paramBoolean)
  {
    boolean bool = isSwitchOpen();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCacheUserLevel ,switchOpen=");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" operType=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RIJUserLevelModel", 2, ((StringBuilder)localObject).toString());
    if (!bool) {
      return paramBoolean;
    }
    localObject = (Boolean)getCurrentUserLevelInfo(paramInt).opesAllowedMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCacheUserLevel ,isAllow=");
    localStringBuilder.append(localObject);
    QLog.d("RIJUserLevelModel", 2, localStringBuilder.toString());
    return (localObject == null) || (((Boolean)localObject).booleanValue());
  }
  
  public boolean getCacheUserLevelWithoutUgcSwitch(int paramInt)
  {
    Boolean localBoolean = (Boolean)getCurrentUserLevelInfo(paramInt).opesAllowedMap.get(Integer.valueOf(paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCacheUserLevelWithoutUgcSwitch ,isAllow=");
    localStringBuilder.append(localBoolean);
    QLog.d("RIJUserLevelModel", 2, localStringBuilder.toString());
    return (localBoolean == null) || (localBoolean.booleanValue());
  }
  
  public UserLevelInfo getCurrentUserLevelInfo(int paramInt)
  {
    UserLevelInfo localUserLevelInfo = getUserLevelInfo(RIJQQAppInterfaceUtil.c());
    localUserLevelInfo.currentOpType = paramInt;
    return localUserLevelInfo;
  }
  
  public UserLevelInfo getUserLevelInfoOrNull(long paramLong)
  {
    return (UserLevelInfo)this.userLevelInfoCache.get(Long.valueOf(paramLong));
  }
  
  public void preRequestUserLevel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("preRequestUserLevel! hasPreRequest=");
    localStringBuilder.append(this.hasPreRequest);
    QLog.d("RIJUserLevelModel", 1, localStringBuilder.toString());
    long l = RIJQQAppInterfaceUtil.c();
    requestUserLevel(l, 5);
    if (this.hasPreRequest) {
      return;
    }
    requestUserLevel(l, 7);
    requestUserLevel(l, 6);
    requestUserLevel(l, 11);
    this.hasPreRequest = true;
  }
  
  public void removeUserLevelInfoUpdateListener(RIJUserLevelModule.UserLevelInfoUpdateListener paramUserLevelInfoUpdateListener)
  {
    this.levelInfoUpdateListeners.remove(paramUserLevelInfoUpdateListener);
  }
  
  @Deprecated
  public void requestUserLevel(int paramInt, IUserLevelCallBack paramIUserLevelCallBack)
  {
    UserLevelInfo localUserLevelInfo = getCurrentUserLevelInfo(paramInt);
    doCallBack(localUserLevelInfo, paramIUserLevelCallBack);
    requestUserLevel(localUserLevelInfo.uin, paramInt);
  }
  
  public void setUserLevelDenyCallback(RIJUserLevelModule.UserLevelDenyCallback paramUserLevelDenyCallback)
  {
    this.userLevelDenyCallback = paramUserLevelDenyCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule
 * JD-Core Version:    0.7.0.1
 */