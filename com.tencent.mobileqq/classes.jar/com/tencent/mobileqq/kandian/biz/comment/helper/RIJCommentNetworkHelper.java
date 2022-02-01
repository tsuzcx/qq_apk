package com.tencent.mobileqq.kandian.biz.comment.helper;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentBubbleObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentPBModule;
import com.tencent.mobileqq.kandian.biz.comment.entity.AuthorCommentDeleteData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BlockUserCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentSinkData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentStickyData;
import com.tencent.mobileqq.kandian.biz.comment.entity.PatrolArbitrationData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.handler.AuthorDeleteCommentHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.BlockUserCommentHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.CreateFirstCommentHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.CreateFirstCommentHandlerForHippy;
import com.tencent.mobileqq.kandian.biz.comment.handler.CreateSubCommentHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.CreateSubCommentHandlerForHippy;
import com.tencent.mobileqq.kandian.biz.comment.handler.FirstCommentSinkHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.FirstCommentStickyHandler;
import com.tencent.mobileqq.kandian.biz.comment.handler.PatrolArbitrationHandler;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper;", "", "()V", "TAG", "", "seqFactory", "Ljava/util/concurrent/atomic/AtomicLong;", "authorDeleteComment", "", "contentSrc", "", "commentViewItem", "Lcom/tencent/mobileqq/kandian/biz/comment/data/CommentViewItem;", "feedsType", "callback", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentObserver;", "blockUserComment", "Lcom/tencent/mobileqq/kandian/biz/comment/ReadInJoyCommentBubbleObserver;", "checkErrorCode", "errorCode", "createFirstComment", "", "requestData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentCreateData;", "Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "isFeeds", "", "needBiuAfterComment", "createFirstCommentForHippy", "Lcom/tencent/mobileqq/kandian/biz/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "extraParam", "createSubComment", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/SubCommentCreateData;", "createSubCommentForHippy", "doCreateCommentReport", "consumeTime", "getCommentIds", "Lkotlin/Pair;", "commentData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/BaseCommentData;", "getCurrentUin", "patrolArbitration", "sendIsCopyMessageTo0xdc8", "commentContent", "rowKey", "parentCommentId", "subCommentId", "commentId", "sinkComment", "commentSinkData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentSinkData;", "updateCommentStickyStatus", "commentStickyData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/FirstCommentStickyData;", "RIJCreateCommentForHippyObserver", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentNetworkHelper
{
  public static final RIJCommentNetworkHelper a;
  private static final AtomicLong a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizCommentHelperRIJCommentNetworkHelper = new RIJCommentNetworkHelper();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  private final String a()
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentUin();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  private final Pair<String, String> a(BaseCommentData paramBaseCommentData)
  {
    String str;
    if (paramBaseCommentData.getCommentLevel() == 1)
    {
      str = paramBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "commentData.commentId");
      paramBaseCommentData = "";
    }
    else
    {
      if (paramBaseCommentData == null) {
        break label64;
      }
      str = ((SubCommentData)paramBaseCommentData).parentCommentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "(commentData as SubCommentData).parentCommentId");
      paramBaseCommentData = paramBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(paramBaseCommentData, "commentData.commentId");
    }
    return new Pair(str, paramBaseCommentData);
    label64:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData");
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    if (paramInt == -4096)
    {
      QQToast localQQToast = QQToast.a((Context)BaseApplicationImpl.sApplication, (CharSequence)HardCodeUtil.a(2131717807), 1);
      Intrinsics.checkExpressionValueIsNotNull(localQQToast, "QQToast.makeText(\n      …     QQToast.LENGTH_LONG)");
      localQQToast.b(1);
      localQQToast.a(QQToast.a(1));
      localQQToast.a();
    }
  }
  
  private final void a(int paramInt, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("retCode", paramInt);
    localJSONObject.put("os", 1);
    localJSONObject.put("consume_time", paramLong);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", localJSONObject.toString(), false);
    ReadinjoyReportUtils.a(paramInt, 7, paramLong, null);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (ReadInJoyCommentUtils.a((Context)BaseApplicationImpl.getContext(), paramString1))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("commentSink commentContent: ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", rowKey: ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", parentCommentId: ");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(", subCommentId: ");
        localStringBuilder.append(paramString4);
        localStringBuilder.append(", commentId: ");
        localStringBuilder.append(paramString5);
        QLog.d("RIJCommentNetworkHelper", 2, localStringBuilder.toString());
      }
      paramString1 = RIJQQAppInterfaceUtil.a();
      StringBuilder localStringBuilder = null;
      if (paramString1 != null) {
        paramString1 = paramString1.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      } else {
        paramString1 = null;
      }
      if (paramString1 != null)
      {
        ReadInJoyLogicEngine localReadInJoyLogicEngine = ((ReadInJoyLogicManager)paramString1).getReadInJoyLogicEngine();
        paramString1 = localStringBuilder;
        if (localReadInJoyLogicEngine != null) {
          paramString1 = localReadInJoyLogicEngine.a();
        }
        if (paramString1 != null) {
          paramString1.a(paramString2, paramString3, paramString4, paramString5);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager");
      }
    }
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstCommentCreateData: ");
      ((StringBuilder)localObject).append(paramFirstCommentCreateData);
      QLog.d("RIJCommentNetworkHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CreateFirstCommentHandler(paramFirstCommentCreateData);
    ((CreateFirstCommentHandler)localObject).a((Function2)new RIJCommentNetworkHelper.createFirstComment.1(paramBoolean2, paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, paramFirstCommentCreateData, l2));
    ((CreateFirstCommentHandler)localObject).a((Function3)new RIJCommentNetworkHelper.createFirstComment.2(paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, l2));
    ((CreateFirstCommentHandler)localObject).a();
    return l1;
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @Nullable IRIJCommentNetworkHelper.RIJCreateCommentObserver paramRIJCreateCommentObserver, @Nullable String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("subCommentCreateData: ");
      ((StringBuilder)localObject).append(paramSubCommentCreateData);
      QLog.d("RIJCommentNetworkHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new CreateSubCommentHandler(paramSubCommentCreateData);
    ((CreateSubCommentHandler)localObject).a((Function2)new RIJCommentNetworkHelper.createSubComment.1(paramBoolean2, paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, paramSubCommentCreateData, l2));
    ((CreateSubCommentHandler)localObject).a((Function3)new RIJCommentNetworkHelper.createSubComment.2(paramRIJCreateCommentObserver, l1, paramString, paramInt, paramBoolean1, l2));
    ((CreateSubCommentHandler)localObject).a();
    return l1;
  }
  
  public final void a(int paramInt1, @NotNull CommentViewItem paramCommentViewItem, int paramInt2, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    Object localObject1 = paramCommentViewItem.a;
    if (localObject1 != null)
    {
      SimpleCommentData localSimpleCommentData = new SimpleCommentData(paramInt1, "");
      Object localObject2 = ((BaseCommentData)localObject1).rowKey;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "commentData.rowKey");
      localSimpleCommentData.c((String)localObject2);
      localObject2 = a((BaseCommentData)localObject1);
      localObject1 = new AuthorDeleteCommentHandler(new AuthorCommentDeleteData(localSimpleCommentData, ((BaseCommentData)localObject1).getCommentLevel(), (String)((Pair)localObject2).getFirst(), (String)((Pair)localObject2).getSecond()));
      ((AuthorDeleteCommentHandler)localObject1).a((Function1)new RIJCommentNetworkHelper.authorDeleteComment.1(paramReadInJoyCommentObserver, paramCommentViewItem, paramInt2));
      ((AuthorDeleteCommentHandler)localObject1).b((Function1)new RIJCommentNetworkHelper.authorDeleteComment.2(paramReadInJoyCommentObserver, paramCommentViewItem, paramInt2));
      ((AuthorDeleteCommentHandler)localObject1).a();
    }
  }
  
  public final void a(@NotNull CommentViewItem paramCommentViewItem, @NotNull ReadInJoyCommentBubbleObserver paramReadInJoyCommentBubbleObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentBubbleObserver, "callback");
    Object localObject = paramCommentViewItem.a;
    if (localObject != null)
    {
      localObject = a((BaseCommentData)localObject);
      int i = ((CharSequence)((Pair)localObject).getSecond()).length();
      int j = 1;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        j = 2;
      }
      localObject = new BlockUserCommentHandler(new BlockUserCommentData((String)((Pair)localObject).getFirst(), (String)((Pair)localObject).getSecond(), j));
      ((BlockUserCommentHandler)localObject).a((Function1)new RIJCommentNetworkHelper.blockUserComment..inlined.apply.lambda.1(paramReadInJoyCommentBubbleObserver, paramCommentViewItem));
      ((BlockUserCommentHandler)localObject).a((Function2)new RIJCommentNetworkHelper.blockUserComment..inlined.apply.lambda.2(paramReadInJoyCommentBubbleObserver, paramCommentViewItem));
      ((BlockUserCommentHandler)localObject).a();
    }
  }
  
  public final void a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("firstCommentCreateData: ");
      localStringBuilder.append(paramFirstCommentCreateData);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramString);
      QLog.d("RIJCommentNetworkHelper", 2, localStringBuilder.toString());
    }
    paramString = new CreateFirstCommentHandlerForHippy(paramFirstCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.1(paramBoolean, paramRIJCreateCommentForHippyObserver, paramFirstCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.2(paramRIJCreateCommentForHippyObserver, l));
    paramString.a();
  }
  
  public final void a(@NotNull FirstCommentSinkData paramFirstCommentSinkData, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentSinkData, "commentSinkData");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    FirstCommentSinkHandler localFirstCommentSinkHandler = new FirstCommentSinkHandler(paramFirstCommentSinkData);
    localFirstCommentSinkHandler.a((Function1)new RIJCommentNetworkHelper.sinkComment.1(paramReadInJoyCommentObserver, paramFirstCommentSinkData));
    localFirstCommentSinkHandler.a((Function0)new RIJCommentNetworkHelper.sinkComment.2(paramReadInJoyCommentObserver, paramFirstCommentSinkData));
    localFirstCommentSinkHandler.a();
    paramReadInJoyCommentObserver = new StringBuilder();
    paramReadInJoyCommentObserver.append("sink comment, detail : ");
    paramReadInJoyCommentObserver.append(paramFirstCommentSinkData);
    QLog.d("RIJCommentNetworkHelper", 1, paramReadInJoyCommentObserver.toString());
  }
  
  public final void a(@NotNull FirstCommentStickyData paramFirstCommentStickyData, @NotNull ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentStickyData, "commentStickyData");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentObserver, "callback");
    FirstCommentStickyHandler localFirstCommentStickyHandler = new FirstCommentStickyHandler(paramFirstCommentStickyData);
    localFirstCommentStickyHandler.a((Function1)new RIJCommentNetworkHelper.updateCommentStickyStatus.1(paramReadInJoyCommentObserver, paramFirstCommentStickyData));
    localFirstCommentStickyHandler.a((Function0)new RIJCommentNetworkHelper.updateCommentStickyStatus.2(paramReadInJoyCommentObserver, paramFirstCommentStickyData));
    localFirstCommentStickyHandler.a();
    paramReadInJoyCommentObserver = new StringBuilder();
    paramReadInJoyCommentObserver.append("update comment setTop status, detail : ");
    paramReadInJoyCommentObserver.append(paramFirstCommentStickyData);
    QLog.d("RIJCommentNetworkHelper", 1, paramReadInJoyCommentObserver.toString());
  }
  
  public final void a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull RIJCommentNetworkHelper.RIJCreateCommentForHippyObserver paramRIJCreateCommentForHippyObserver, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramRIJCreateCommentForHippyObserver, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("subCommentCreateData: ");
      localStringBuilder.append(paramSubCommentCreateData);
      localStringBuilder.append(' ');
      localStringBuilder.append(paramString);
      QLog.d("RIJCommentNetworkHelper", 2, localStringBuilder.toString());
    }
    paramString = new CreateSubCommentHandlerForHippy(paramSubCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.1(paramBoolean, paramRIJCreateCommentForHippyObserver, paramSubCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.2(paramRIJCreateCommentForHippyObserver, l));
    paramString.a();
  }
  
  public final void b(@NotNull CommentViewItem paramCommentViewItem, @NotNull ReadInJoyCommentBubbleObserver paramReadInJoyCommentBubbleObserver)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentViewItem, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyCommentBubbleObserver, "callback");
    Object localObject1 = paramCommentViewItem.a;
    if (localObject1 != null)
    {
      Object localObject2 = a((BaseCommentData)localObject1);
      paramCommentViewItem = a();
      String str = (String)((Pair)localObject2).getFirst();
      localObject2 = (String)((Pair)localObject2).getSecond();
      localObject1 = ((BaseCommentData)localObject1).rowKey;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "commentData.rowKey");
      paramCommentViewItem = new PatrolArbitrationHandler(new PatrolArbitrationData(paramCommentViewItem, str, (String)localObject2, (String)localObject1));
      paramCommentViewItem.a((Function1)new RIJCommentNetworkHelper.patrolArbitration..inlined.apply.lambda.1(paramReadInJoyCommentBubbleObserver));
      paramCommentViewItem.b((Function1)new RIJCommentNetworkHelper.patrolArbitration..inlined.apply.lambda.2(paramReadInJoyCommentBubbleObserver));
      paramCommentViewItem.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.helper.RIJCommentNetworkHelper
 * JD-Core Version:    0.7.0.1
 */