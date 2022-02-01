package com.tencent.mobileqq.kandian.repo.share;

import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJBaseArticleInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf34.oidb_cmd0xf34.ReqBody;
import tencent.im.oidb.cmd0xf34.oidb_cmd0xf34.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/share/RIJShareConfigHandler;", "Lcom/tencent/mobileqq/kandian/repo/handler/RIJBaseArticleInfoHandler;", "articleInfoModule", "Lcom/tencent/mobileqq/kandian/repo/feeds/ArticleInfoModule;", "mMainThreadHandler", "Landroid/os/Handler;", "mApp", "Lcom/tencent/common/app/AppInterface;", "mEntityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "mMSFService", "Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "(Lcom/tencent/mobileqq/kandian/repo/feeds/ArticleInfoModule;Landroid/os/Handler;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Lcom/tencent/mobileqq/kandian/base/msf/ReadInJoyMSFService;Ljava/util/concurrent/ExecutorService;)V", "getArticle", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getRespBody", "Ltencent/im/oidb/cmd0xf34/oidb_cmd0xf34$RspBody;", "getStrikedArticles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "handle0xf34GetShareConfig", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "refreshShareCount", "article", "request0xf34ConfigShare", "uin", "", "articleId", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJShareConfigHandler
  extends RIJBaseArticleInfoHandler
{
  public static final RIJShareConfigHandler.Companion g = new RIJShareConfigHandler.Companion(null);
  
  public RIJShareConfigHandler(@Nullable ArticleInfoModule paramArticleInfoModule, @Nullable Handler paramHandler, @Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ReadInJoyMSFService paramReadInJoyMSFService, @Nullable ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  @VisibleForTesting
  @NotNull
  public final oidb_cmd0xf34.RspBody a()
  {
    return new oidb_cmd0xf34.RspBody();
  }
  
  public final void a(long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "articleId");
    Object localObject = new oidb_cmd0xf34.ReqBody();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
    ((oidb_cmd0xf34.ReqBody)localObject).bytes_rowkey.set(localByteStringMicro);
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_uin.set(paramLong);
    ((oidb_cmd0xf34.ReqBody)localObject).uint64_op.set(1L);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xf34", 3892, 0, ((oidb_cmd0xf34.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("articleId", paramString);
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    this.a.sendPbReqWithAutoRetry((ToServiceMsg)localObject);
  }
  
  @VisibleForTesting
  public final void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "article");
    ThreadManager.getUIHandler().post((Runnable)new RIJShareConfigHandler.refreshShareCount.1(paramAbsBaseArticleInfo));
  }
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    oidb_cmd0xf34.RspBody localRspBody = a();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localRspBody);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0xf34GetShareConfig | retCode ");
      paramFromServiceMsg.append(i);
      QLog.d("ReadInJoyShareConfigUtil", 1, paramFromServiceMsg.toString());
    }
    paramObject = b();
    paramFromServiceMsg = paramToServiceMsg.getAttribute("articleId");
    paramToServiceMsg = paramFromServiceMsg;
    if (!(paramFromServiceMsg instanceof String)) {
      paramToServiceMsg = null;
    }
    paramToServiceMsg = (String)paramToServiceMsg;
    if (i == 0)
    {
      boolean bool = localRspBody.uint32_share_status.has();
      int j = 0;
      if (bool) {
        i = localRspBody.uint32_share_status.get();
      } else {
        i = 0;
      }
      if (localRspBody.uint64_num.has()) {
        j = (int)localRspBody.uint64_num.get();
      }
      if ((i == 1) && (paramToServiceMsg != null)) {
        c().add(paramToServiceMsg);
      } else if ((i == 2) && (QLog.isColorLevel())) {
        QLog.d("ReadInJoyShareConfigUtil", 2, "allow share but don't calculate!");
      }
      if (((paramObject instanceof AbsBaseArticleInfo)) && (j != 0))
      {
        paramObject.mShareCount = j;
        a(paramObject);
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handle0xf34GetShareConfig | shareStatus ");
        paramToServiceMsg.append(i);
        paramToServiceMsg.append(" | shareCount ");
        paramToServiceMsg.append(j);
        QLog.d("ReadInJoyShareConfigUtil", 2, paramToServiceMsg.toString());
      }
    }
  }
  
  @VisibleForTesting
  @Nullable
  public final AbsBaseArticleInfo b()
  {
    return ShareReport.a.b();
  }
  
  @VisibleForTesting
  @NotNull
  public final ArrayList<String> c()
  {
    return ShareReport.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.share.RIJShareConfigHandler
 * JD-Core Version:    0.7.0.1
 */