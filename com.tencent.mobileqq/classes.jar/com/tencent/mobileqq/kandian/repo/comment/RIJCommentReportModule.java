package com.tencent.mobileqq.kandian.repo.comment;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xef5.oidb_cmd0xef5.ReqBody;
import tencent.im.oidb.cmd0xef5.oidb_cmd0xef5.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/comment/RIJCommentReportModule;", "Lcom/tencent/mobileqq/kandian/repo/common/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Landroid/os/Handler;)V", "onReceive", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestCommentReport", "commentReportInfo", "Lcom/tencent/mobileqq/kandian/repo/comment/CommentReportInfo;", "unInitialize", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentReportModule
  extends ReadInJoyEngineModule
{
  public static final RIJCommentReportModule.Companion a = new RIJCommentReportModule.Companion(null);
  
  public RIJCommentReportModule(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public final void a(@Nullable CommentReportInfo paramCommentReportInfo)
  {
    for (;;)
    {
      try
      {
        oidb_cmd0xef5.ReqBody localReqBody = new oidb_cmd0xef5.ReqBody();
        PBStringField localPBStringField = localReqBody.rowkey;
        Object localObject2 = null;
        if (paramCommentReportInfo != null)
        {
          localObject1 = paramCommentReportInfo.a();
          localPBStringField.set((String)localObject1);
          localPBStringField = localReqBody.first_comment_id;
          if (paramCommentReportInfo == null) {
            break label261;
          }
          localObject1 = paramCommentReportInfo.b();
          localPBStringField.set((String)localObject1);
          localPBStringField = localReqBody.sub_comment_id;
          if (paramCommentReportInfo == null) {
            break label266;
          }
          localObject1 = paramCommentReportInfo.c();
          localPBStringField.set((String)localObject1);
          localObject1 = localReqBody.report_type;
          if (paramCommentReportInfo == null) {
            break label271;
          }
          i = paramCommentReportInfo.a();
          ((PBUInt32Field)localObject1).set(i);
          localPBStringField = localReqBody.report_reason;
          localObject1 = localObject2;
          if (paramCommentReportInfo != null) {
            localObject1 = paramCommentReportInfo.d();
          }
          localPBStringField.set((String)localObject1);
          localObject1 = localReqBody.toByteArray();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("requestCommentReport(): CommentReportInfo:");
            ((StringBuilder)localObject2).append(paramCommentReportInfo);
            ((StringBuilder)localObject2).append(", byteArray.length:");
            ((StringBuilder)localObject2).append(localObject1.length);
            QLog.d("RIJCommentReportModule", 2, ((StringBuilder)localObject2).toString());
          }
          localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xef5", 3829, 1, (byte[])localObject1);
          if (localObject1 != null)
          {
            localObject2 = ((ToServiceMsg)localObject1).getAttributes();
            if (localObject2 != null) {
              ((HashMap)localObject2).put("requestCommentReportInfo", paramCommentReportInfo);
            }
          }
          sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Throwable paramCommentReportInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RIJCommentReportModule", 2, "requestCommentReport() failed.", paramCommentReportInfo);
        }
        return;
      }
      Object localObject1 = null;
      continue;
      label261:
      localObject1 = null;
      continue;
      label266:
      localObject1 = null;
      continue;
      label271:
      int i = 0;
    }
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive(): FromServiceMsg:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg);
      ((StringBuilder)localObject1).append(", ToServiceMsg:");
      ((StringBuilder)localObject1).append(paramToServiceMsg);
      QLog.d("RIJCommentReportModule", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    if (paramFromServiceMsg != null) {
      localObject1 = paramFromServiceMsg.getServiceCmd();
    } else {
      localObject1 = null;
    }
    if (Intrinsics.areEqual(localObject1, "OidbSvc.0xef5"))
    {
      localObject1 = new oidb_cmd0xef5.RspBody();
      int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
      int j = ((oidb_cmd0xef5.RspBody)localObject1).ret.get();
      paramObject = ((oidb_cmd0xef5.RspBody)localObject1).err_message.get();
      paramFromServiceMsg = localObject2;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg = paramToServiceMsg.getAttributes();
        paramFromServiceMsg = localObject2;
        if (paramToServiceMsg != null) {
          paramFromServiceMsg = paramToServiceMsg.get("requestCommentReportInfo");
        }
      }
      paramToServiceMsg = (CommentReportInfo)paramFromServiceMsg;
      boolean bool;
      if ((i == 0) && (j == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive(): result:");
        paramFromServiceMsg.append(i);
        paramFromServiceMsg.append(", retCode:");
        paramFromServiceMsg.append(j);
        paramFromServiceMsg.append(", errMsg:");
        paramFromServiceMsg.append(paramObject);
        paramFromServiceMsg.append(", commentReportInfo:");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("RIJCommentReportModule", 2, paramFromServiceMsg.toString());
      }
      ThreadManager.c((Runnable)new RIJCommentReportModule.onReceive.1(bool, j, paramObject, paramToServiceMsg));
    }
  }
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJCommentReportModule
 * JD-Core Version:    0.7.0.1
 */