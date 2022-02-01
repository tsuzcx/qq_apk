package com.tencent.mobileqq.kandian.repo.common;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManagerFactory;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.AccountLevelInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoReq;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.GetUserInfoRsp;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadDecoration;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.HeadInfo;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.LiveStatus;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.ReqBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.RspBody;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserIdentityIcon;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoItem;
import tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.UserInfoOption;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyUserInfoModule
  extends ReadInJoyEngineModule
{
  private static Map<Long, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  private IFindRemovedEntity<ReadInJoyUserInfo> jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity = new ReadInJoyUserInfoModule.1(this);
  private ReadInJoyUserInfoRepository jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository;
  private ConcurrentHashMap<String, List<IReadInJoyUserInfoModule.RefreshUserInfoCallBack>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap();
  
  public ReadInJoyUserInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(ReadInJoyUserInfo.class, this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository = new ReadInJoyUserInfoRepository(paramExecutorService, this, paramEntityManager);
  }
  
  public static IReadInJoyLogicEngine a()
  {
    IReadInJoyLogicManager localIReadInJoyLogicManager = a();
    if (localIReadInJoyLogicManager != null) {
      return localIReadInJoyLogicManager.getReadInJoyLogicEngine();
    }
    return null;
  }
  
  private static IReadInJoyLogicManager a()
  {
    try
    {
      Object localObject = RIJQQAppInterfaceUtil.a();
      if ((localObject instanceof QQAppInterface)) {
        return (IReadInJoyLogicManager)((AppRuntime)localObject).getRuntimeService(IReadInJoyLogicManager.class, "");
      }
      localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (!(localObject instanceof BrowserAppInterface)) {
        break label71;
      }
      localObject = ((IReadInJoyLogicManagerFactory)QRoute.api(IReadInJoyLogicManagerFactory.class)).createReadInJoyLogicManager((AppInterface)localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      label63:
      label71:
      break label63;
    }
    QLog.d("ReadInJoyUserInfoModule", 1, "getLogicManager error! msg = ${e}");
    return null;
  }
  
  @Nullable
  private static ReadInJoyUserInfoModule a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((IReadInJoyLogicEngine)localObject).a();
      if ((localObject instanceof ReadInJoyUserInfoModule)) {
        return (ReadInJoyUserInfoModule)localObject;
      }
    }
    return null;
  }
  
  public static ReadInJoyUserInfo a(long paramLong, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    return a(paramLong, paramRefreshUserInfoCallBack, false);
  }
  
  public static ReadInJoyUserInfo a(long paramLong, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    if (paramLong != 0L)
    {
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = a();
      if (localReadInJoyUserInfoModule != null) {
        return localReadInJoyUserInfoModule.a(String.valueOf(paramLong), paramRefreshUserInfoCallBack, paramBoolean);
      }
    }
    return null;
  }
  
  private ToServiceMsg a(ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params)
  {
    if (paramRequest0xb81Params == null)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "make0x81bRequestUserInfosPkg failed, params is null.");
      return null;
    }
    oidb_cmd0xb81.ReqBody localReqBody = new oidb_cmd0xb81.ReqBody();
    localReqBody.uint32_client_type.set(ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params));
    oidb_cmd0xb81.GetUserInfoReq localGetUserInfoReq = new oidb_cmd0xb81.GetUserInfoReq();
    localGetUserInfoReq.uint32_info_priority.set(ReadInJoyUserInfoModule.Request0xb81Params.b(paramRequest0xb81Params));
    Object localObject = new oidb_cmd0xb81.UserInfoOption();
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_nick.set(ReadInJoyUserInfoModule.Request0xb81Params.c(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_disable_comment_recommed.set(ReadInJoyUserInfoModule.Request0xb81Params.d(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_head_url.set(ReadInJoyUserInfoModule.Request0xb81Params.e(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_qq_head.set(ReadInJoyUserInfoModule.Request0xb81Params.f(paramRequest0xb81Params));
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_account_cc_level.set(2);
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_live_status.set(1);
    ((oidb_cmd0xb81.UserInfoOption)localObject).uint32_user_identity_icon.set(1);
    localGetUserInfoReq.msg_user_option.set((MessageMicro)localObject);
    localObject = new ArrayList();
    if ((ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params) != null) && (ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size() > 0))
    {
      int i = 0;
      while (i < ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).size())
      {
        oidb_cmd0xb81.AccountInfo localAccountInfo = new oidb_cmd0xb81.AccountInfo();
        localAccountInfo.uint32_account_type.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$1100((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        localAccountInfo.uint64_uin.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        localAccountInfo.uint64_friend_status.set(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$1200((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params).get(i)));
        ((List)localObject).add(localAccountInfo);
        i += 1;
      }
    }
    localGetUserInfoReq.msg_account_info.set((List)localObject);
    localReqBody.msg_get_user_info_req.set(localGetUserInfoReq);
    return a("OidbSvc.0xb81", 2945, 1, localReqBody.toByteArray());
  }
  
  private ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = ReadInJoyOidbHelper.a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
  
  public static String a()
  {
    return HardCodeUtil.a(2131713011);
  }
  
  public static String a(long paramLong)
  {
    String str2 = a();
    if (paramLong <= 0L) {
      return str2;
    }
    Map localMap = jdField_a_of_type_JavaUtilMap;
    String str1 = str2;
    if (localMap != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty((CharSequence)localMap.get(Long.valueOf(paramLong)))) {
        str1 = (String)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
      }
    }
    return str1;
  }
  
  public static String a(long paramLong, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, String paramString)
  {
    paramRefreshUserInfoCallBack = a(paramLong, paramRefreshUserInfoCallBack);
    if (paramRefreshUserInfoCallBack == null) {
      return paramString;
    }
    return paramRefreshUserInfoCallBack.nick;
  }
  
  public static String a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return "";
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x8) != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramReadInJoyUserInfo.faceUrl);
      localStringBuilder.append("140");
      return localStringBuilder.toString();
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x4) != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramReadInJoyUserInfo.faceUrl);
      localStringBuilder.append("100");
      return localStringBuilder.toString();
    }
    if ((paramReadInJoyUserInfo.faceFlag & 0x10) != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramReadInJoyUserInfo.faceUrl);
      localStringBuilder.append("0");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramReadInJoyUserInfo.faceUrl);
    localStringBuilder.append("40");
    return localStringBuilder.toString();
  }
  
  private String a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    String str = paramString;
    if (paramUserInfoItem.msg_account_info.has())
    {
      str = paramString;
      if (paramUserInfoItem.msg_account_info.get() != null)
      {
        paramReadInJoyUserInfo.accountType = ((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint32_account_type.get();
        paramReadInJoyUserInfo.uin = String.valueOf(((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint64_uin.get());
        str = String.valueOf(((oidb_cmd0xb81.AccountInfo)paramUserInfoItem.msg_account_info.get()).uint64_uin.get());
      }
    }
    if (paramUserInfoItem.bytes_nick.has()) {
      paramString = paramUserInfoItem.bytes_nick.get().toStringUtf8();
    } else {
      paramString = "";
    }
    paramReadInJoyUserInfo.nick = paramString;
    return str;
  }
  
  public static List<ReadInJoyUserInfo> a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return null;
      }
      ReadInJoyUserInfoModule localReadInJoyUserInfoModule = a();
      if (localReadInJoyUserInfoModule != null) {
        return localReadInJoyUserInfoModule.a(paramList, 1, 1, 0, 0, true, null);
      }
    }
    return null;
  }
  
  private void a(int paramInt, String paramString, List<IReadInJoyUserInfoModule.RefreshUserInfoCallBack> paramList1, List<IReadInJoyUserInfoModule.RefreshUserInfoCallBack> paramList2)
  {
    Iterator localIterator = paramList2.iterator();
    while (localIterator.hasNext())
    {
      IReadInJoyUserInfoModule.RefreshUserInfoCallBack localRefreshUserInfoCallBack = (IReadInJoyUserInfoModule.RefreshUserInfoCallBack)localIterator.next();
      if (localRefreshUserInfoCallBack != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("request0xb81UserInfo result = ");
        localStringBuilder.append(paramInt);
        localRefreshUserInfoCallBack.onLoadUserInfoFailed(paramString, localStringBuilder.toString());
        paramList1.add(localRefreshUserInfoCallBack);
      }
    }
    if (paramList1.size() > 0)
    {
      paramList2.removeAll(paramList1);
      return;
    }
    QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, tempList is null.");
  }
  
  private void a(int paramInt, List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        a(paramInt, paramList, i);
        i += 1;
      }
    }
  }
  
  private void a(int paramInt1, List<ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq> paramList, int paramInt2)
  {
    paramList = String.valueOf(ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.access$400((ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq)paramList.get(paramInt2)));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramList);
      if (localList != null) {
        a(paramInt1, paramList, localArrayList, localList);
      } else {
        QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, uin callback list is null.");
      }
    }
    else
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "handle0xb81UserInfo failed, callback list is null.");
    }
    this.b.remove(paramList);
  }
  
  public static void a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return;
    }
    if (jdField_a_of_type_JavaUtilMap == null) {
      jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), paramString);
  }
  
  private void a(ReadInJoyUserInfoModule.Request0xb81Params paramRequest0xb81Params)
  {
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "request0xb81UserInfo, params = \n", paramRequest0xb81Params });
    ToServiceMsg localToServiceMsg = a(paramRequest0xb81Params);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.addAttribute("user_info_uin_list_key", ReadInJoyUserInfoModule.Request0xb81Params.a(paramRequest0xb81Params));
      localToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(0));
      localToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
      sendPbReq(localToServiceMsg);
    }
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.HeadDecoration paramHeadDecoration)
  {
    if ((paramHeadDecoration != null) && (paramHeadDecoration.has()))
    {
      paramReadInJoyUserInfo.decorationName = RIJPBFieldUtils.a(paramHeadDecoration.name);
      paramReadInJoyUserInfo.decorationIcon = RIJPBFieldUtils.a(paramHeadDecoration.icon);
      paramReadInJoyUserInfo.decorationId = RIJPBFieldUtils.a(paramHeadDecoration.id);
    }
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem.live_status.has()) {
      paramReadInJoyUserInfo.liveStatus = ((oidb_cmd0xb81.LiveStatus)paramUserInfoItem.live_status.get());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttributes().get("retry_request_count_key");
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry_count = ", localInteger, "handle0xb81UserInfo failed." });
    List localList = (List)paramToServiceMsg.getAttributes().get("user_info_uin_list_key");
    if (localList != null)
    {
      QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "accountInfoReqList size = ", Integer.valueOf(localList.size()) });
      if (localList.size() > 0) {
        QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "retry accountInfoReqList [0] = ", localList.get(0) });
      }
    }
    if (localInteger.intValue() < 1)
    {
      paramToServiceMsg.addAttribute("retry_request_count_key", Integer.valueOf(localInteger.intValue() + 1));
      paramToServiceMsg.addAttribute("request_begin_time", Long.valueOf(System.currentTimeMillis()));
      RIJThreadHandler.a("handle0xb81UserInfo", new ReadInJoyUserInfoModule.5(this, paramToServiceMsg), this.mExecutorService);
      return;
    }
    a(paramInt, localList);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xb81.RspBody localRspBody = new oidb_cmd0xb81.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("request_begin_time")).longValue();
    boolean bool = false;
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo result = ", Integer.valueOf(i), ", cost = ", Long.valueOf(l) });
    paramFromServiceMsg = RIJQQAppInterfaceUtil.a();
    if (i == 0) {
      bool = true;
    }
    RIJStatisticCollectorReport.b(paramFromServiceMsg, bool, l, i);
    if (i == 0)
    {
      a(localRspBody);
      return;
    }
    a(paramToServiceMsg, i);
  }
  
  public static void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[clearCallbackList], uin = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ReadInJoyUserInfoModule", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = a();
      if ((localObject != null) && (((ReadInJoyUserInfoModule)localObject).a() != null))
      {
        ((ReadInJoyUserInfoModule)localObject).a().remove(paramString);
        QLog.i("ReadInJoyUserInfoModule", 1, "[clearCallbackList] finished.");
      }
    }
  }
  
  private void a(String paramString, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem.uint32_disable_comment_recommed.has())
    {
      boolean bool;
      if (paramUserInfoItem.uint32_disable_comment_recommed.get() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      a(paramString, bool);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(RIJQQAppInterfaceUtil.a())))
    {
      RIJSPUtils.a("rij_comment_recommend_key", Boolean.valueOf(paramBoolean));
      paramString = new StringBuilder();
      paramString.append("updateCommentRecommendStatus, flag=");
      paramString.append(paramBoolean);
      QLog.d("ReadInJoyUserInfoModule", 1, paramString.toString());
    }
  }
  
  public static void a(List<String> paramList)
  {
    ReadInJoyUserInfoModule localReadInJoyUserInfoModule = a();
    if (localReadInJoyUserInfoModule != null) {
      localReadInJoyUserInfoModule.a(paramList, 1, 1, 0);
    }
  }
  
  private void a(List<oidb_cmd0xb81.UserInfoItem> paramList, int paramInt)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = new ReadInJoyUserInfo();
    paramList = (oidb_cmd0xb81.UserInfoItem)paramList.get(paramInt);
    String str = a("", localReadInJoyUserInfo, paramList);
    e(localReadInJoyUserInfo, paramList);
    c(localReadInJoyUserInfo, paramList);
    d(localReadInJoyUserInfo, paramList);
    a(str, paramList);
    b(localReadInJoyUserInfo, paramList);
    a(localReadInJoyUserInfo, paramList);
    a(localReadInJoyUserInfo, (oidb_cmd0xb81.HeadDecoration)paramList.head_decoration.get());
    localReadInJoyUserInfo.requestFlag = true;
    localReadInJoyUserInfo.lastUpdateTimeMilliSecond = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository.a(str, localReadInJoyUserInfo, true, true);
    QLog.d("ReadInJoyUserInfoModule", 1, new Object[] { "handle0xb81UserInfo succeed, userInfo = ", localReadInJoyUserInfo });
  }
  
  private void a(oidb_cmd0xb81.RspBody paramRspBody)
  {
    if ((paramRspBody.msg_get_user_info_rsp.has()) && (paramRspBody.msg_get_user_info_rsp.get() != null))
    {
      paramRspBody = (oidb_cmd0xb81.GetUserInfoRsp)paramRspBody.msg_get_user_info_rsp.get();
      if (a(paramRspBody))
      {
        paramRspBody = paramRspBody.rpt_msg_user_info.get();
        int i = 0;
        while (i < paramRspBody.size())
        {
          a(paramRspBody, i);
          i += 1;
        }
      }
    }
  }
  
  private boolean a(oidb_cmd0xb81.GetUserInfoRsp paramGetUserInfoRsp)
  {
    return (paramGetUserInfoRsp.rpt_msg_user_info.has()) && (paramGetUserInfoRsp.rpt_msg_user_info.get() != null) && (paramGetUserInfoRsp.rpt_msg_user_info.get().size() > 0);
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if (paramUserInfoItem.uint32_rt_read.has())
    {
      int i = paramUserInfoItem.uint32_rt_read.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramReadInJoyUserInfo.readlTimeRead = bool;
    }
  }
  
  private void b(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams.");
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.a();
      long l = 0L;
      if ((localAppRuntime instanceof QQAppInterface)) {
        if (((FriendsManager)localAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(str)) {
          l = 1L;
        } else {
          l = 2L;
        }
      }
      try
      {
        localArrayList.add(new ReadInJoyUserInfoModule.Request0xb81Params.AccountInfoReq.AccountInfoBuilder().a(Long.valueOf(str).longValue()).b(l).a());
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label128:
        break label128;
      }
      QLog.d("ReadInJoyUserInfoModule", 2, "uin is not a long type.");
    }
    if (localArrayList.size() <= 0)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "requestReadInJoyUserInfoWithParams failed, the uinList is empty.");
      return;
    }
    a(new ReadInJoyUserInfoModule.Request0xb81Params.Builder().a(paramInt1).b(paramInt2).c(paramInt3).d(paramInt4).a(localArrayList).e(paramInt5).a());
  }
  
  private void c(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if ((paramUserInfoItem.account_level_info.has()) && (paramUserInfoItem.account_level_info.get() != null))
    {
      oidb_cmd0xb81.AccountLevelInfo localAccountLevelInfo = (oidb_cmd0xb81.AccountLevelInfo)paramUserInfoItem.account_level_info.get();
      paramReadInJoyUserInfo.accountLevel = localAccountLevelInfo.uint32_account_cc_level.get();
      boolean bool = localAccountLevelInfo.account_cc_level_icon_s.has();
      String str = "";
      if (bool) {
        paramUserInfoItem = localAccountLevelInfo.account_cc_level_icon_s.get();
      } else {
        paramUserInfoItem = "";
      }
      paramReadInJoyUserInfo.smallIconUrl = paramUserInfoItem;
      if (localAccountLevelInfo.account_cc_level_icon_l.has()) {
        paramUserInfoItem = localAccountLevelInfo.account_cc_level_icon_l.get();
      } else {
        paramUserInfoItem = "";
      }
      paramReadInJoyUserInfo.largeIconUrl = paramUserInfoItem;
      paramUserInfoItem = str;
      if (localAccountLevelInfo.authorize_desc.has()) {
        paramUserInfoItem = localAccountLevelInfo.authorize_desc.get();
      }
      paramReadInJoyUserInfo.authorizeDesc = paramUserInfoItem;
      paramUserInfoItem = new StringBuilder();
      paramUserInfoItem.append("[handle0xb81UserInfo], accountLevel = ");
      paramUserInfoItem.append(paramReadInJoyUserInfo.accountLevel);
      paramUserInfoItem.append(", smallIconUrl = ");
      paramUserInfoItem.append(paramReadInJoyUserInfo.smallIconUrl);
      paramUserInfoItem.append(", largeIconUrl = ");
      paramUserInfoItem.append(paramReadInJoyUserInfo.largeIconUrl);
      QLog.d("ReadInJoyUserInfoModule", 2, paramUserInfoItem.toString());
      return;
    }
    QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], accountLevelInfo is null.");
  }
  
  private void d(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    if ((paramUserInfoItem.user_identity_icon.has()) && (paramUserInfoItem.user_identity_icon.get() != null))
    {
      oidb_cmd0xb81.UserIdentityIcon localUserIdentityIcon = (oidb_cmd0xb81.UserIdentityIcon)paramUserInfoItem.user_identity_icon.get();
      if (localUserIdentityIcon.icon_url.has()) {
        paramUserInfoItem = localUserIdentityIcon.icon_url.get();
      } else {
        paramUserInfoItem = "";
      }
      paramReadInJoyUserInfo.upIconUrl = paramUserInfoItem;
      paramReadInJoyUserInfo = new StringBuilder();
      paramReadInJoyUserInfo.append("[handle0xb81UserInfo], userIdentityIcon = ");
      paramReadInJoyUserInfo.append(localUserIdentityIcon.icon_url);
      QLog.d("ReadInJoyUserInfoModule", 2, paramReadInJoyUserInfo.toString());
      return;
    }
    QLog.d("ReadInJoyUserInfoModule", 2, "[handle0xb81UserInfo], UserIdentityIcon is null.");
  }
  
  private void e(ReadInJoyUserInfo paramReadInJoyUserInfo, oidb_cmd0xb81.UserInfoItem paramUserInfoItem)
  {
    boolean bool = paramUserInfoItem.msg_head_info.has();
    String str = "";
    Object localObject;
    if ((bool) && (paramUserInfoItem.msg_head_info.get() != null))
    {
      localObject = (oidb_cmd0xb81.HeadInfo)paramUserInfoItem.msg_head_info.get();
      paramReadInJoyUserInfo.faceType = ((oidb_cmd0xb81.HeadInfo)localObject).uint32_face_type.get();
      paramReadInJoyUserInfo.timestamp = ((oidb_cmd0xb81.HeadInfo)localObject).uint64_timestamp.get();
      paramReadInJoyUserInfo.faceFlag = ((oidb_cmd0xb81.HeadInfo)localObject).uint32_face_flag.get();
      paramReadInJoyUserInfo.systemID = ((oidb_cmd0xb81.HeadInfo)localObject).uint32_sysid.get();
      if (((oidb_cmd0xb81.HeadInfo)localObject).str_url.has()) {
        localObject = ((oidb_cmd0xb81.HeadInfo)localObject).str_url.get();
      } else {
        localObject = "";
      }
      paramReadInJoyUserInfo.faceUrl = ((String)localObject);
    }
    if ((paramUserInfoItem.msg_qq_head.has()) && (paramUserInfoItem.msg_qq_head.get() != null))
    {
      localObject = (oidb_cmd0xb81.HeadInfo)paramUserInfoItem.msg_qq_head.get();
      paramUserInfoItem = str;
      if (((oidb_cmd0xb81.HeadInfo)localObject).str_url.has()) {
        paramUserInfoItem = ((oidb_cmd0xb81.HeadInfo)localObject).str_url.get();
      }
      paramReadInJoyUserInfo.qqHeadUrl = paramUserInfoItem;
    }
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    return a(paramString, paramInt1, paramInt2, paramInt3, paramRefreshUserInfoCallBack, paramBoolean, false);
  }
  
  public ReadInJoyUserInfo a(String paramString, int paramInt1, int paramInt2, int paramInt3, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfoWithParams uin is null or empty.");
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("load data from 0xb81 userinfo uin");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("ReadInJoyUserInfoModule", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean1) || (paramBoolean2)) {
      a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository;
    if (localObject != null)
    {
      localObject = ((ReadInJoyUserInfoRepository)localObject).a(paramString);
      if ((localObject != null) && ((!paramBoolean1) || (!((ReadInJoyUserInfo)localObject).isReadlTimeRead())) && (!paramBoolean2))
      {
        if (TextUtils.isEmpty(((ReadInJoyUserInfo)localObject).nick)) {
          ((ReadInJoyUserInfo)localObject).nick = a();
        }
        if (paramRefreshUserInfoCallBack != null) {
          paramRefreshUserInfoCallBack.onLoadUserInfoSucceed(paramString, (ReadInJoyUserInfo)localObject);
        }
        return localObject;
      }
    }
    if (paramRefreshUserInfoCallBack != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject != null)
      {
        if (((ConcurrentHashMap)localObject).get(paramString) == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, new CopyOnWriteArrayList());
        }
        ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(paramRefreshUserInfoCallBack);
      }
    }
    RIJThreadHandler.a("getSingleReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.2(this, paramString, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3), this.mExecutorService);
    return null;
  }
  
  public ReadInJoyUserInfo a(String paramString, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyUserInfoModule", 1, "getSingleReadInJoyUserInfo uin is null or empty.");
      return null;
    }
    return a(paramString, 1, 1, 0, paramRefreshUserInfoCallBack, paramBoolean);
  }
  
  public List<ReadInJoyUserInfo> a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return null;
      }
      if (!paramBoolean)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2) == null) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, new CopyOnWriteArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject2)).add(paramRefreshUserInfoCallBack);
          }
        }
        a(paramList, paramInt1, paramInt2, paramInt3, paramInt4, 0);
        return null;
      }
      Object localObject1 = new ArrayList();
      Object localObject2 = new ArrayList();
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!TextUtils.isEmpty(str))
          {
            ReadInJoyUserInfo localReadInJoyUserInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository.a(str);
            if (localReadInJoyUserInfo != null) {
              ((List)localObject1).add(localReadInJoyUserInfo);
            } else {
              ((List)localObject2).add(str);
            }
          }
        }
      }
      if ((paramRefreshUserInfoCallBack != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (((List)localObject2).size() > 0))
      {
        paramList = ((List)localObject2).iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          if (!TextUtils.isEmpty(str))
          {
            if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) == null) {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new CopyOnWriteArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).add(paramRefreshUserInfoCallBack);
          }
        }
      }
      if (((List)localObject2).size() > 0) {
        RIJThreadHandler.a("getBatchReadInJoyUserInfoWithParams", new ReadInJoyUserInfoModule.3(this, (List)localObject2, paramInt1, paramInt2, paramInt3, paramInt4), this.mExecutorService);
      }
      if (((List)localObject1).size() > 0)
      {
        if (paramRefreshUserInfoCallBack != null)
        {
          paramList = ((List)localObject1).iterator();
          while (paramList.hasNext())
          {
            localObject2 = (ReadInJoyUserInfo)paramList.next();
            paramRefreshUserInfoCallBack.onLoadUserInfoSucceed(((ReadInJoyUserInfo)localObject2).uin, (ReadInJoyUserInfo)localObject2);
          }
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public List<ReadInJoyUserInfo> a(List<String> paramList, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      return a(paramList, 1, 1, 0, 0, true, paramRefreshUserInfoCallBack);
    }
    return null;
  }
  
  public ConcurrentHashMap<String, List<IReadInJoyUserInfoModule.RefreshUserInfoCallBack>> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    ReadInJoyUserInfoRepository localReadInJoyUserInfoRepository = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository;
    if (localReadInJoyUserInfoRepository != null) {
      localReadInJoyUserInfoRepository.a();
    }
  }
  
  public void a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramList, paramInt1, paramInt2, 0, paramInt3, 0);
  }
  
  public void a(List<String> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (RIJThreadHandler.a())
    {
      RIJThreadHandler.a("requestReadInJoyUserInfoWithParamsInSubThread", new ReadInJoyUserInfoModule.4(this, paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5), this.mExecutorService);
      return;
    }
    b(paramList, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public ConcurrentHashMap<String, Boolean> b()
  {
    return this.b;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb81")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonReadInJoyUserInfoRepository.b();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    Map localMap = jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule
 * JD-Core Version:    0.7.0.1
 */