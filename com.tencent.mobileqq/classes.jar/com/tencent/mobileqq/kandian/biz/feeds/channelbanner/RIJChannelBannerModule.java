package com.tencent.mobileqq.kandian.biz.feeds.channelbanner;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.DynamicBannerItem;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.ReqBody;
import tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/channelbanner/RIJChannelBannerModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "bannerInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelBannerInfo;", "requestTimeMap", "", "getChannelBannerInfoList", "channelId", "getPageName", "", "dynamicJson", "handleReceiveChannelBannerInfo", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "onReceive", "requestChannelBannerInfo", "serviceType", "unInitialize", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelBannerModule
  extends ReadInJoyEngineModule
{
  public static final RIJChannelBannerModule.Companion a;
  private final ConcurrentHashMap<Integer, List<ChannelBannerInfo>> a;
  private final ConcurrentHashMap<Integer, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsChannelbannerRIJChannelBannerModule$Companion = new RIJChannelBannerModule.Companion(null);
  }
  
  public RIJChannelBannerModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("pts_page_name");
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonObject.optString(PTS_LITE_PAGE_NAME)");
      return paramString;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getPageName] failed, e = ");
      localStringBuilder.append(paramString);
      QLog.e("RIJChannelBannerModule", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xea0.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("[handleReceiveChannelBannerInfo], result = ");
    paramFromServiceMsg.append(i);
    QLog.i("RIJChannelBannerModule", 1, paramFromServiceMsg.toString());
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.channel_id;
      int j = 0;
      if (paramFromServiceMsg != null) {
        i = (int)paramFromServiceMsg.get();
      } else {
        i = 0;
      }
      paramFromServiceMsg = new ArrayList();
      paramObject = paramToServiceMsg.dynamic_banner_list;
      if ((paramObject.has()) && (paramObject.size() > 0))
      {
        int k = paramObject.size();
        while (j < k)
        {
          paramToServiceMsg = paramObject.get(j);
          Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "dynamicBannerList[i]");
          oidb_cmd0xea0.DynamicBannerItem localDynamicBannerItem = (oidb_cmd0xea0.DynamicBannerItem)paramToServiceMsg;
          ChannelBannerInfo localChannelBannerInfo = new ChannelBannerInfo();
          localChannelBannerInfo.a(i);
          paramToServiceMsg = localDynamicBannerItem.unique_id;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.get();
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg = paramToServiceMsg.toString();
              if (paramToServiceMsg != null) {
                break label190;
              }
            }
          }
          paramToServiceMsg = "";
          label190:
          localChannelBannerInfo.a(paramToServiceMsg);
          paramToServiceMsg = localDynamicBannerItem.dynamic_json;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.get();
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg = paramToServiceMsg.toString();
              if (paramToServiceMsg != null) {
                break label230;
              }
            }
          }
          paramToServiceMsg = "";
          label230:
          localChannelBannerInfo.c(paramToServiceMsg);
          paramToServiceMsg = localDynamicBannerItem.card_report_json;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg = paramToServiceMsg.get();
            if (paramToServiceMsg != null)
            {
              paramToServiceMsg = paramToServiceMsg.toString();
              if (paramToServiceMsg != null) {
                break label270;
              }
            }
          }
          paramToServiceMsg = "";
          label270:
          localChannelBannerInfo.d(paramToServiceMsg);
          localChannelBannerInfo.b(a(localChannelBannerInfo.c()));
          paramFromServiceMsg.add(localChannelBannerInfo);
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("[handleReceiveChannelBannerInfo], channelBannerInfo: ");
          paramToServiceMsg.append(localChannelBannerInfo);
          QLog.i("RIJChannelBannerModule", 1, paramToServiceMsg.toString());
          j += 1;
        }
      }
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(i), paramFromServiceMsg);
      ReadInJoyLogicEngineEventDispatcher.a().d(i, (List)paramFromServiceMsg);
    }
  }
  
  @Nullable
  public final List<ChannelBannerInfo> a(int paramInt)
  {
    return (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (!RIJChannelBannerUtil.a.a(paramInt1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[requestChannelBannerInfo] do not request, channelId = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.i("RIJChannelBannerModule", 1, ((StringBuilder)localObject).toString());
      return;
    }
    RIJChannelBannerUtil localRIJChannelBannerUtil = RIJChannelBannerUtil.a;
    Object localObject = (Long)this.b.get(Integer.valueOf(paramInt1));
    if (localObject == null) {
      localObject = Long.valueOf(0L);
    }
    if (!localRIJChannelBannerUtil.a(((Long)localObject).longValue()))
    {
      QLog.i("RIJChannelBannerModule", 1, "[requestChannelBannerInfo] do not request, limit request frequency.");
      return;
    }
    localObject = new oidb_cmd0xea0.ReqBody();
    ((oidb_cmd0xea0.ReqBody)localObject).req_client_type.set(1);
    ((oidb_cmd0xea0.ReqBody)localObject).version.set("8.7.0");
    ((oidb_cmd0xea0.ReqBody)localObject).channel_id.set(paramInt1);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xea0", 3744, paramInt2, ((oidb_cmd0xea0.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…e, reqBody.toByteArray())");
    sendPbReq((ToServiceMsg)localObject);
    long l = System.currentTimeMillis();
    ((Map)this.b).put(Integer.valueOf(paramInt1), Long.valueOf(l));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[requestChannelBannerInfo], channelId = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", serviceType = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", timeStamp = ");
    ((StringBuilder)localObject).append(l);
    QLog.i("RIJChannelBannerModule", 1, ((StringBuilder)localObject).toString());
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xea0")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelBannerModule
 * JD-Core Version:    0.7.0.1
 */