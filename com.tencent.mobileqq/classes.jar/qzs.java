import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.network.PTSGeneralRequestModule.handleReceivePtsData.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/network/PTSGeneralRequestModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "ptsComposerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/pts/core/PTSComposer;", "addRequestAttributes", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "ptsComposer", "handleReceivePtsData", "req", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "onReceive", "requestPtsBusinessData", "businessType", "requestParamsJson", "", "extendInfoJson", "unInitialize", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qzs
  extends qhj
{
  public static final qzt a;
  private final ConcurrentHashMap<Integer, PTSComposer> a;
  
  static
  {
    jdField_a_of_type_Qzt = new qzt(null);
  }
  
  public qzs(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable qxn paramqxn, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, PTSComposer paramPTSComposer)
  {
    PTSAppInstance localPTSAppInstance = paramPTSComposer.getPtsAppInstance();
    if (localPTSAppInstance != null) {}
    for (int i = localPTSAppInstance.getUniqueID();; i = -1)
    {
      paramToServiceMsg = paramToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.attributes");
      ((Map)paramToServiceMsg).put("key_pts_app_instance_id", Integer.valueOf(i));
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(i), paramPTSComposer);
      QLog.i("PTSGeneralRequestModule", 1, "[addRequestAttributes] uniqueId = " + i);
      return;
    }
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = -1;
    oidb_cmd0xebf.RspBody localRspBody = new oidb_cmd0xebf.RspBody();
    int k = qxp.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    int i;
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("key_pts_app_instance_id");
      if (paramToServiceMsg != null) {
        if ((paramToServiceMsg instanceof Integer))
        {
          i = ((Number)paramToServiceMsg).intValue();
          paramToServiceMsg = Integer.valueOf(i);
          label61:
          paramFromServiceMsg = (PTSComposer)((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).get(paramToServiceMsg);
          QLog.i("PTSGeneralRequestModule", 1, "[handleReceivePtsData], result = " + k);
          if (k == 0)
          {
            paramToServiceMsg = localRspBody.business_type;
            if (paramToServiceMsg == null) {
              break label236;
            }
            i = paramToServiceMsg.get();
            label125:
            paramToServiceMsg = localRspBody.ret_code;
            if (paramToServiceMsg != null) {
              j = paramToServiceMsg.get();
            }
            paramToServiceMsg = localRspBody.result_json;
            if (paramToServiceMsg == null) {
              break label242;
            }
            paramToServiceMsg = paramToServiceMsg.get();
            if (paramToServiceMsg == null) {
              break label242;
            }
          }
        }
      }
    }
    for (;;)
    {
      QLog.i("PTSGeneralRequestModule", 1, "[handleReceivePtsData], businessType = " + i + ", retCode = " + j + ", resultJson = " + paramToServiceMsg);
      ThreadManager.getUIHandler().post((Runnable)new PTSGeneralRequestModule.handleReceivePtsData.1(paramFromServiceMsg, paramToServiceMsg));
      return;
      i = -1;
      break;
      paramToServiceMsg = null;
      break label61;
      label236:
      i = -1;
      break label125;
      label242:
      paramToServiceMsg = "";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
    localObject = qxp.a("OidbSvc.0xebf", 3775, 0, ((oidb_cmd0xebf.ReqBody)localObject).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…T, reqBody.toByteArray())");
    a((ToServiceMsg)localObject, paramPTSComposer);
    a((ToServiceMsg)localObject);
    QLog.i("PTSGeneralRequestModule", 1, "[requestPtsBusinessData], businessType = " + paramInt + ", requestParamsJson = " + paramString1 + ", extendInfoJson = " + paramString2);
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xebf")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzs
 * JD-Core Version:    0.7.0.1
 */