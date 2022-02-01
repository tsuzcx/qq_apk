package com.tencent.mobileqq.kandian.biz.pts.network;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xebf.oidb_cmd0xebf.ReqBody;
import tencent.im.oidb.cmd0xebf.oidb_cmd0xebf.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/network/PTSGeneralRequestModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "ptsComposerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/pts/core/PTSComposer;", "addRequestAttributes", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "ptsComposer", "handleReceivePtsData", "req", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "onReceive", "requestPtsBusinessData", "businessType", "requestParamsJson", "", "extendInfoJson", "unInitialize", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PTSGeneralRequestModule
  extends ReadInJoyEngineModule
{
  public static final PTSGeneralRequestModule.Companion a;
  private final ConcurrentHashMap<Integer, PTSComposer> a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsNetworkPTSGeneralRequestModule$Companion = new PTSGeneralRequestModule.Companion(null);
  }
  
  public PTSGeneralRequestModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, PTSComposer paramPTSComposer)
  {
    PTSAppInstance localPTSAppInstance = paramPTSComposer.getPtsAppInstance();
    int i;
    if (localPTSAppInstance != null) {
      i = localPTSAppInstance.getUniqueID();
    } else {
      i = -1;
    }
    paramToServiceMsg = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.attributes");
    ((Map)paramToServiceMsg).put("key_pts_app_instance_id", Integer.valueOf(i));
    ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(i), paramPTSComposer);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[addRequestAttributes] uniqueId = ");
    paramToServiceMsg.append(i);
    QLog.i("PTSGeneralRequestModule", 1, paramToServiceMsg.toString());
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xebf.RspBody localRspBody = new oidb_cmd0xebf.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    int j = -1;
    int i;
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("key_pts_app_instance_id");
      if (paramToServiceMsg != null)
      {
        if ((paramToServiceMsg instanceof Integer)) {
          i = ((Number)paramToServiceMsg).intValue();
        } else {
          i = -1;
        }
        paramToServiceMsg = Integer.valueOf(i);
        break label72;
      }
    }
    paramToServiceMsg = null;
    label72:
    paramFromServiceMsg = (PTSComposer)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramToServiceMsg);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[handleReceivePtsData], result = ");
    paramToServiceMsg.append(k);
    QLog.i("PTSGeneralRequestModule", 1, paramToServiceMsg.toString());
    if (k == 0)
    {
      paramToServiceMsg = localRspBody.business_type;
      if (paramToServiceMsg != null) {
        i = paramToServiceMsg.get();
      } else {
        i = -1;
      }
      paramToServiceMsg = localRspBody.ret_code;
      if (paramToServiceMsg != null) {
        j = paramToServiceMsg.get();
      }
      paramToServiceMsg = localRspBody.result_json;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg = paramToServiceMsg.get();
        if (paramToServiceMsg != null) {}
      }
      else
      {
        paramToServiceMsg = "";
      }
      paramObject = new StringBuilder();
      paramObject.append("[handleReceivePtsData], businessType = ");
      paramObject.append(i);
      paramObject.append(", retCode = ");
      paramObject.append(j);
      paramObject.append(", resultJson = ");
      paramObject.append(paramToServiceMsg);
      QLog.i("PTSGeneralRequestModule", 1, paramObject.toString());
      ThreadManager.getUIHandler().post((Runnable)new PTSGeneralRequestModule.handleReceivePtsData.1(paramFromServiceMsg, paramToServiceMsg));
    }
  }
  
  public final void a(@NotNull PTSComposer paramPTSComposer, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramPTSComposer, "ptsComposer");
    Intrinsics.checkParameterIsNotNull(paramString1, "requestParamsJson");
    Intrinsics.checkParameterIsNotNull(paramString2, "extendInfoJson");
    Object localObject = new oidb_cmd0xebf.ReqBody();
    ((oidb_cmd0xebf.ReqBody)localObject).business_type.set(paramInt);
    ((oidb_cmd0xebf.ReqBody)localObject).request_params_json.set(paramString1);
    ((oidb_cmd0xebf.ReqBody)localObject).extend_info_json.set(paramString2);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xebf", 3775, 0, ((oidb_cmd0xebf.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…T, reqBody.toByteArray())");
    a((ToServiceMsg)localObject, paramPTSComposer);
    sendPbReq((ToServiceMsg)localObject);
    paramPTSComposer = new StringBuilder();
    paramPTSComposer.append("[requestPtsBusinessData], businessType = ");
    paramPTSComposer.append(paramInt);
    paramPTSComposer.append(", requestParamsJson = ");
    paramPTSComposer.append(paramString1);
    paramPTSComposer.append(", extendInfoJson = ");
    paramPTSComposer.append(paramString2);
    QLog.i("PTSGeneralRequestModule", 1, paramPTSComposer.toString());
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xebf")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.network.PTSGeneralRequestModule
 * JD-Core Version:    0.7.0.1
 */