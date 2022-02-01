package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.RedInfo;
import tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "handle0xfa4", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "notifyMessageBoardUI", "redInfo", "Lcom/tencent/mobileqq/kandian/biz/xtab/msgboard/RIJXTabMessageBoardRedUtil$MessageBoardRedInfo;", "onReceive", "requestMessageBoardRedDotInfo", "unInitialize", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabMessageBoardModule
  extends ReadInJoyEngineModule
{
  public static final RIJXTabMessageBoardModule.Companion a = new RIJXTabMessageBoardModule.Companion(null);
  
  public RIJXTabMessageBoardModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private final void a(RIJXTabMessageBoardRedUtil.MessageBoardRedInfo paramMessageBoardRedInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[notifyMessageBoardUI] redInfo = ");
    localStringBuilder.append(paramMessageBoardRedInfo);
    QLog.i("RIJXTabMessageBoardModule", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post((Runnable)new RIJXTabMessageBoardModule.notifyMessageBoardUI.1(paramMessageBoardRedInfo));
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xfa4.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("[handle0xfa4] retCode = ");
    paramFromServiceMsg.append(i);
    QLog.i("RIJXTabMessageBoardModule", 1, paramFromServiceMsg.toString());
    if (i != 0) {
      return;
    }
    paramFromServiceMsg = new RIJXTabMessageBoardRedUtil.MessageBoardRedInfo();
    if ((paramToServiceMsg.red_info.has()) && (paramToServiceMsg.red_info.get() != null))
    {
      paramFromServiceMsg.a(paramToServiceMsg.red_info.is_red.get());
      paramFromServiceMsg.a(paramToServiceMsg.red_info.time_stamp.get());
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("[handle0xfa4] redInfo = ");
      paramToServiceMsg.append(paramFromServiceMsg);
      QLog.i("RIJXTabMessageBoardModule", 1, paramToServiceMsg.toString());
    }
    else
    {
      QLog.i("RIJXTabMessageBoardModule", 1, "[handle0xfa4] redInfo is empty.");
    }
    RIJXTabMessageBoardRedUtil.a.a(paramFromServiceMsg);
    a(paramFromServiceMsg);
  }
  
  public final void a()
  {
    ThreadManager.getSubThreadHandler().post((Runnable)new RIJXTabMessageBoardModule.requestMessageBoardRedDotInfo.1(this));
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramFromServiceMsg != null) {
      str = paramFromServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (Intrinsics.areEqual(str, "OidbSvc.0xfa4")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardModule
 * JD-Core Version:    0.7.0.1
 */