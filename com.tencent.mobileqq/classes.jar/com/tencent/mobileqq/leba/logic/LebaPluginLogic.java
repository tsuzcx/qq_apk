package com.tencent.mobileqq.leba.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.CommPluginHandler;
import com.tencent.mobileqq.leba.core.CommPluginHandlerApi;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginSetting;
import com.tencent.mobileqq.leba.entity.LebaPluginSettingItem;
import com.tencent.mobileqq.leba.entity.LebaShowData;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.GetListRequest;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.GetListResponse;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.SetListRequest;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.SetListResponse;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaPluginLogic
{
  public static LebaSettingObserver a;
  
  public static int a()
  {
    if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
      return 1;
    }
    if (QQTheme.isNowSimpleUI()) {
      return 2;
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == 4032) {
      return 1;
    }
    if (paramInt == 4033) {
      return 2;
    }
    return 0;
  }
  
  public static LebaHelper a(AppRuntime paramAppRuntime, String paramString)
  {
    if (paramAppRuntime == null)
    {
      QLog.i("LebaPluginLogic", 1, "getLebaHelper isEmpty appInterface = null");
      return null;
    }
    paramAppRuntime = ((ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "")).getLebaHelper();
    if (paramAppRuntime == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("getLebaHelper isEmpty method = ");
      paramAppRuntime.append(paramString);
      QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
      return null;
    }
    return (LebaHelper)paramAppRuntime;
  }
  
  public static LebaPluginSetting a(AppRuntime paramAppRuntime, int paramInt)
  {
    LebaPluginSetting localLebaPluginSetting = new LebaPluginSetting();
    StringBuilder localStringBuilder1 = null;
    Object localObject = localStringBuilder1;
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences();
      localObject = localStringBuilder1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject = localStringBuilder1;
      localStringBuilder2.append("sp_key_dynamic_user_set_info");
      localObject = localStringBuilder1;
      localStringBuilder2.append(paramInt);
      localObject = localStringBuilder1;
      paramAppRuntime = paramAppRuntime.getString(localStringBuilder2.toString(), "");
      localObject = paramAppRuntime;
      paramAppRuntime = LebaPluginSetting.a(paramAppRuntime);
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getPluginSettingLocal ");
      localStringBuilder1.append((String)localObject);
      QLog.i("LebaPluginLogic", 1, localStringBuilder1.toString(), paramAppRuntime);
    }
    return localLebaPluginSetting;
  }
  
  protected static LebaShowData a(List<LebaViewItem> paramList, int paramInt)
  {
    LebaShowData localLebaShowData = new LebaShowData();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localLebaShowData.a((LebaViewItem)paramList.next(), paramInt);
    }
    return localLebaShowData;
  }
  
  public static LebaShowData a(List<LebaViewItem> paramList, LebaPluginSetting paramLebaPluginSetting, int paramInt)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((paramLebaPluginSetting != null) && (paramLebaPluginSetting.a != null) && (!paramLebaPluginSetting.a.isEmpty())) {
        return a(paramList, paramLebaPluginSetting.a, paramInt);
      }
      return a(paramList, paramInt);
    }
    return new LebaShowData();
  }
  
  protected static LebaShowData a(List<LebaViewItem> paramList, List<LebaPluginSettingItem> paramList1, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    Object localObject;
    while (paramList1.hasNext())
    {
      localObject = (LebaPluginSettingItem)paramList1.next();
      if ((localObject != null) && (!((LebaPluginSettingItem)localObject).a())) {
        localArrayList.add(Long.valueOf(((LebaPluginSettingItem)localObject).a));
      }
    }
    paramList1 = new LebaShowData();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (LebaViewItem)paramList.next();
      if ((localObject != null) && (((LebaViewItem)localObject).b != null)) {
        if ((localArrayList.contains(Long.valueOf(((LebaViewItem)localObject).b.uiResId))) && (((LebaViewItem)localObject).c())) {
          paramList1.a((LebaViewItem)localObject);
        } else {
          paramList1.a((LebaViewItem)localObject, paramInt);
        }
      }
    }
    return paramList1;
  }
  
  public static LebaShowData a(AppRuntime paramAppRuntime, List<LebaViewItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      try
      {
        int i = a(LebaUtil.e(paramAppRuntime));
        paramAppRuntime = a(paramList, a(paramAppRuntime, i), b(paramAppRuntime, i));
        return paramAppRuntime;
      }
      finally {}
    }
    return new LebaShowData();
  }
  
  static String a(String paramString, long paramLong)
  {
    paramString = LebaPluginSetting.a(paramString);
    paramString.b = paramLong;
    return LebaPluginSetting.a(paramString);
  }
  
  public static void a(LebaSettingObserver paramLebaSettingObserver)
  {
    a = paramLebaSettingObserver;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.i("LebaPluginLogic", 1, "getPluginSettingNet app == null");
      return;
    }
    int i = a();
    LebaPluginSetting localLebaPluginSetting = a(paramAppRuntime, i);
    String str = paramAppRuntime.getCurrentAccountUin();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str, "trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.GetList");
    UserSetDynamicPlugin.GetListRequest localGetListRequest = new UserSetDynamicPlugin.GetListRequest();
    localGetListRequest.platform_type.set(1);
    localGetListRequest.plugin_type.set(b(i));
    localGetListRequest.sequence.set(localLebaPluginSetting.b);
    localToServiceMsg.putWupBuffer(localGetListRequest.toByteArray());
    localToServiceMsg.extraData.putString("uin", str);
    localToServiceMsg.extraData.putInt("key_current_model", i);
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(CommPluginHandlerApi.a)).sendPbReq(localToServiceMsg);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getPluginSettingNet currentModel=");
    paramAppRuntime.append(i);
    paramAppRuntime.append(",sequence=");
    paramAppRuntime.append(localLebaPluginSetting.b);
    QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, LebaPluginSetting paramLebaPluginSetting)
  {
    if (paramAppRuntime == null)
    {
      QLog.i("LebaPluginLogic", 1, "setPluginSettingNet app == null");
      return;
    }
    String str = paramAppRuntime.getCurrentAccountUin();
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", str, "trpc.qq_config.user_dynamic_plugin.UserDynamicPluginService.SetList");
    UserSetDynamicPlugin.SetListRequest localSetListRequest = new UserSetDynamicPlugin.SetListRequest();
    localSetListRequest.platform_type.set(1);
    localSetListRequest.plugin_type.set(b(paramInt));
    localSetListRequest.plugin_data.addAll(LebaPluginSetting.a(paramLebaPluginSetting.a));
    localToServiceMsg.putWupBuffer(localSetListRequest.toByteArray());
    localToServiceMsg.extraData.putString("uin", str);
    localToServiceMsg.extraData.putInt("key_current_model", paramInt);
    paramLebaPluginSetting = LebaPluginSetting.a(paramLebaPluginSetting);
    localToServiceMsg.extraData.putString("key_setting_json", paramLebaPluginSetting);
    localToServiceMsg.setTimeout(5000L);
    ((CommPluginHandler)((AppInterface)paramAppRuntime).getBusinessHandler(CommPluginHandlerApi.a)).sendPbReq(localToServiceMsg);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("setPluginSettingNet currentModel=");
    paramAppRuntime.append(paramInt);
    paramAppRuntime.append(",settingJson=");
    paramAppRuntime.append(paramLebaPluginSetting);
    QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, long paramLong)
  {
    int i = paramToServiceMsg.extraData.getInt("key_current_model", -1);
    paramToServiceMsg = a(paramToServiceMsg.extraData.getString("key_setting_json"), paramLong);
    if ((i != -1) && (!TextUtils.isEmpty(paramToServiceMsg))) {
      a(paramAppRuntime, paramToServiceMsg, i);
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("handleSetPluginSettingSucc model=");
    paramAppRuntime.append(i);
    paramAppRuntime.append(",json=");
    paramAppRuntime.append(paramToServiceMsg);
    paramAppRuntime.append(",sequence=");
    paramAppRuntime.append(paramLong);
    QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, UserSetDynamicPlugin.GetListResponse paramGetListResponse)
  {
    int i = paramToServiceMsg.extraData.getInt("key_current_model", -1);
    if (i == -1)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("handleGetPluginSettingSucc error model=");
      paramAppRuntime.append(i);
      QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
      return;
    }
    if ((paramGetListResponse.sequence.get() != 0L) && (paramGetListResponse.plugin_data.size() > 0)) {
      a(paramAppRuntime, LebaPluginSetting.a(LebaPluginSetting.a(paramGetListResponse.plugin_data.get(), paramGetListResponse.sequence.get())), i);
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("handleGetPluginSettingSucc, model =");
    paramAppRuntime.append(i);
    paramAppRuntime.append(", sequence=");
    paramAppRuntime.append(paramGetListResponse.sequence.get());
    paramAppRuntime.append(", size=");
    paramAppRuntime.append(paramGetListResponse.plugin_data.size());
    QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    UserSetDynamicPlugin.GetListResponse localGetListResponse = new UserSetDynamicPlugin.GetListResponse();
    StringBuilder localStringBuilder = new StringBuilder("handleGetPluginSetting ");
    boolean bool1 = false;
    boolean bool2 = false;
    if ((paramFromServiceMsg != null) && (paramObject != null) && (paramToServiceMsg != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",resultCode=");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append(",RequestSsoSeq=");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        paramFromServiceMsg = localGetListResponse;
      }
      else
      {
        try
        {
          paramFromServiceMsg = (UserSetDynamicPlugin.GetListResponse)localGetListResponse.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.i("LebaPluginLogic", 1, "handleGetPluginSetting", paramFromServiceMsg);
          paramFromServiceMsg = localGetListResponse;
        }
        bool1 = bool2;
        if (paramFromServiceMsg.reson_code.get() == 0)
        {
          bool1 = bool2;
          if (paramFromServiceMsg.sequence.get() != 0L) {
            bool1 = true;
          }
        }
        localStringBuilder.append(",resonCode=");
        localStringBuilder.append(paramFromServiceMsg.reson_code.get());
        localStringBuilder.append(",sequence=");
        localStringBuilder.append(paramFromServiceMsg.sequence.get());
        localStringBuilder.append(",maxDynamicNum=");
        localStringBuilder.append(paramFromServiceMsg.max_dynamic_num.get());
      }
    }
    else
    {
      localStringBuilder.append("res == null || data == null || req == null");
      paramFromServiceMsg = localGetListResponse;
    }
    localStringBuilder.append(",isSuc=");
    localStringBuilder.append(bool1);
    if (bool1) {
      a(paramAppRuntime, paramToServiceMsg, paramFromServiceMsg);
    }
    b(paramAppRuntime, paramToServiceMsg, paramFromServiceMsg);
    LebaShowListManager.a().b(paramAppRuntime);
    paramAppRuntime = a(paramAppRuntime, "handleGetPluginSetting");
    if (paramAppRuntime != null) {
      paramAppRuntime.a(bool1);
    }
    QLog.i("LebaPluginLogic", 1, localStringBuilder.toString());
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_dynamic_user_set_info");
      localStringBuilder.append(paramInt);
      paramAppRuntime.putString(localStringBuilder.toString(), paramString);
      paramAppRuntime.apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("LebaPluginLogic", 1, "setPluginSettingLocal", paramAppRuntime);
    }
  }
  
  public static int b()
  {
    int i = a();
    if (i == 1) {
      return 4032;
    }
    if (i == 2) {
      return 4033;
    }
    return 4034;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 3;
    }
    if (paramInt == 2) {
      return 2;
    }
    return 1;
  }
  
  public static int b(AppRuntime paramAppRuntime, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("getShowNormalPluginMaxSize model=");
    localStringBuilder.append(paramInt);
    if ((paramInt == 2) && (LebaFeedUtil.a()))
    {
      localStringBuilder.append(",isShowQzoneFrame");
      QLog.i("LebaPluginLogic", 1, localStringBuilder.toString());
      return c();
    }
    int i = c(paramAppRuntime, paramInt) - 1;
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramInt = i;
      if (((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQCircleEnter(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()))
      {
        localStringBuilder.append(",isShowQCircleEnter=true");
        paramInt = i - 1;
      }
      localStringBuilder.append(",showPluginSize=");
      localStringBuilder.append(paramInt);
      QLog.i("LebaPluginLogic", 1, localStringBuilder.toString());
      return paramInt;
    }
    localStringBuilder.append(",showPluginSize=");
    localStringBuilder.append(i);
    QLog.i("LebaPluginLogic", 1, localStringBuilder.toString());
    return i;
  }
  
  public static void b(LebaSettingObserver paramLebaSettingObserver)
  {
    a = null;
  }
  
  public static void b(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, UserSetDynamicPlugin.GetListResponse paramGetListResponse)
  {
    int i = paramToServiceMsg.extraData.getInt("key_current_model", -1);
    if (i == -1)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("handleTotalPluginMaxSize model error model=");
      paramAppRuntime.append(i);
      QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
      return;
    }
    int j = paramGetListResponse.max_dynamic_num.get();
    if (j <= 0)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("handleTotalPluginMaxSize maxDynamicNum error model=");
      paramAppRuntime.append(i);
      paramAppRuntime.append(",maxDynamicNum=");
      paramAppRuntime.append(j);
      QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handleTotalPluginMaxSize model=");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(",maxDynamicNum=");
    paramToServiceMsg.append(j);
    QLog.i("LebaPluginLogic", 1, paramToServiceMsg.toString());
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences().edit();
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("sp_key_max_show_plugin_size");
      paramToServiceMsg.append(i);
      paramAppRuntime.putInt(paramToServiceMsg.toString(), j);
      paramAppRuntime.apply();
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("LebaPluginLogic", 1, "saveTotalPluginMaxSize model=", paramAppRuntime);
    }
  }
  
  public static void b(AppRuntime paramAppRuntime, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    UserSetDynamicPlugin.SetListResponse localSetListResponse = new UserSetDynamicPlugin.SetListResponse();
    StringBuilder localStringBuilder = new StringBuilder("handleSetPluginSetting ");
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        localStringBuilder.append(",resultCode=");
        localStringBuilder.append(paramFromServiceMsg.getResultCode());
        localStringBuilder.append(",RequestSsoSeq=");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        paramFromServiceMsg = localSetListResponse;
        bool1 = bool2;
      }
      else
      {
        try
        {
          paramFromServiceMsg = (UserSetDynamicPlugin.SetListResponse)localSetListResponse.mergeFrom((byte[])paramObject);
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.i("LebaPluginLogic", 1, "handleSetPluginSetting", paramFromServiceMsg);
          paramFromServiceMsg = localSetListResponse;
        }
        if (paramFromServiceMsg.reson_code.get() == 0) {
          bool1 = true;
        }
        localStringBuilder.append("rsp.reson_code=");
        localStringBuilder.append(paramFromServiceMsg.reson_code.get());
      }
    }
    else
    {
      localStringBuilder.append("res == null || data == null ");
      bool1 = bool2;
      paramFromServiceMsg = localSetListResponse;
    }
    localStringBuilder.append(",isSuc=");
    localStringBuilder.append(bool1);
    if (bool1) {
      a(paramAppRuntime, paramToServiceMsg, paramFromServiceMsg.sequence.get());
    }
    paramAppRuntime = a;
    if (paramAppRuntime != null) {
      paramAppRuntime.a(bool1, true);
    }
    QLog.i("LebaPluginLogic", 1, localStringBuilder.toString());
  }
  
  public static int c()
  {
    return 4;
  }
  
  public static int c(AppRuntime paramAppRuntime, int paramInt)
  {
    int i;
    try
    {
      paramAppRuntime = paramAppRuntime.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_max_show_plugin_size");
      localStringBuilder.append(paramInt);
      i = paramAppRuntime.getInt(localStringBuilder.toString(), 6);
    }
    catch (Exception paramAppRuntime)
    {
      QLog.i("LebaPluginLogic", 1, "getTotalPluginMaxSize", paramAppRuntime);
      i = 0;
    }
    int j = i;
    if (i <= 0) {
      j = 6;
    }
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("getTotalPluginMaxSize model=");
    paramAppRuntime.append(paramInt);
    paramAppRuntime.append(",totalPluginMaxSize=");
    paramAppRuntime.append(j);
    QLog.i("LebaPluginLogic", 1, paramAppRuntime.toString());
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.logic.LebaPluginLogic
 * JD-Core Version:    0.7.0.1
 */