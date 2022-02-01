import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.authorDeleteComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.authorDeleteComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.updateCommentStickyStatus.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.updateCommentStickyStatus.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper;", "", "()V", "BUNDLE_KEY_CREATE_COMMENT_DATA", "", "BUNDLE_KEY_JS_OBJ", "TAG", "seqFactory", "Ljava/util/concurrent/atomic/AtomicLong;", "authorDeleteComment", "", "contentSrc", "", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "feedsType", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentObserver;", "createFirstComment", "", "requestData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "isFeeds", "", "needBiuAfterComment", "createSubComment", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "doCreateCommentReport", "errorCode", "consumeTime", "sendIsCopyMessageTo0xdc8", "commentContent", "rowKey", "parentCommentId", "subCommentId", "commentId", "sinkComment", "commentSinkData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentSinkData;", "updateCommentStickyStatus", "commentStickyData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "RIJCreateCommentObserver", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class owr
{
  private static final AtomicLong a;
  public static final owr a;
  
  static
  {
    jdField_a_of_type_Owr = new owr();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("retCode", paramInt);
    localJSONObject.put("os", 1);
    localJSONObject.put("consume_time", paramLong);
    ocd.a(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", localJSONObject.toString(), false);
    ubg.a(paramInt, 7, paramLong, null);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (osp.a((Context)BaseApplicationImpl.getContext(), paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJCommentNetworkHelper", 2, "commentSink commentContent: " + paramString1 + ", rowKey: " + paramString2 + ", parentCommentId: " + paramString3 + ", subCommentId: " + paramString4 + ", commentId: " + paramString5);
      }
      paramString1 = ozs.a();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getManager(163); paramString1 == null; paramString1 = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager");
      }
      paramString1 = ((pfg)paramString1).a();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "logicManager.readInJoyLogicEngine");
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, paramString4, paramString5);
      }
    }
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull ows paramows, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramows, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramFirstCommentCreateData, paramows, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull ows paramows, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramows, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "firstCommentCreateData: " + paramFirstCommentCreateData);
    }
    owa localowa = new owa(paramFirstCommentCreateData);
    localowa.a((Function1)new RIJCommentNetworkHelper.createFirstComment.1(paramBoolean2, paramows, l1, paramString, paramInt, paramBoolean1, paramFirstCommentCreateData, l2));
    localowa.a((Function2)new RIJCommentNetworkHelper.createFirstComment.2(paramows, l1, paramString, paramInt, paramBoolean1, l2));
    localowa.a();
    return l1;
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull ows paramows, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramows, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramSubCommentCreateData, paramows, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull ows paramows, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(paramows, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "subCommentCreateData: " + paramSubCommentCreateData);
    }
    owc localowc = new owc(paramSubCommentCreateData);
    localowc.a((Function1)new RIJCommentNetworkHelper.createSubComment.1(paramBoolean2, paramows, l1, paramString, paramInt, paramBoolean1, paramSubCommentCreateData, l2));
    localowc.a((Function2)new RIJCommentNetworkHelper.createSubComment.2(paramows, l1, paramString, paramInt, paramBoolean1, l2));
    localowc.a();
    return l1;
  }
  
  public final void a(int paramInt1, @NotNull otp paramotp, int paramInt2, @NotNull osl paramosl)
  {
    Intrinsics.checkParameterIsNotNull(paramotp, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(paramosl, "callback");
    BaseCommentData localBaseCommentData = paramotp.a;
    SimpleCommentData localSimpleCommentData;
    Object localObject;
    String str;
    if (localBaseCommentData != null)
    {
      localSimpleCommentData = new SimpleCommentData(paramInt1, "");
      localObject = localBaseCommentData.rowKey;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentData.rowKey");
      localSimpleCommentData.c((String)localObject);
      localObject = "";
      if (localBaseCommentData.getCommentLevel() != 1) {
        break label158;
      }
      str = localBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "commentData.commentId");
    }
    for (;;)
    {
      localObject = new ovx(new owk(localSimpleCommentData, localBaseCommentData.getCommentLevel(), str, (String)localObject));
      ((ovx)localObject).a((Function1)new RIJCommentNetworkHelper.authorDeleteComment.1(paramosl, paramotp, paramInt2));
      ((ovx)localObject).b((Function1)new RIJCommentNetworkHelper.authorDeleteComment.2(paramosl, paramotp, paramInt2));
      ((ovx)localObject).a();
      return;
      label158:
      if (localBaseCommentData == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData");
      }
      str = ((SubCommentData)localBaseCommentData).parentCommentId;
      Intrinsics.checkExpressionValueIsNotNull(str, "(commentData as SubCommentData).parentCommentId");
      localObject = localBaseCommentData.commentId;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "commentData.commentId");
    }
  }
  
  public final void a(@NotNull FirstCommentSinkData paramFirstCommentSinkData, @NotNull osl paramosl)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentSinkData, "commentSinkData");
    Intrinsics.checkParameterIsNotNull(paramosl, "callback");
    owe localowe = new owe(paramFirstCommentSinkData);
    localowe.a((Function1)new RIJCommentNetworkHelper.sinkComment.1(paramosl, paramFirstCommentSinkData));
    localowe.a((Function0)new RIJCommentNetworkHelper.sinkComment.2(paramosl, paramFirstCommentSinkData));
    localowe.a();
    QLog.d("RIJCommentNetworkHelper", 1, "sink comment, detail : " + paramFirstCommentSinkData);
  }
  
  public final void a(@NotNull FirstCommentStickyData paramFirstCommentStickyData, @NotNull osl paramosl)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentStickyData, "commentStickyData");
    Intrinsics.checkParameterIsNotNull(paramosl, "callback");
    owh localowh = new owh(paramFirstCommentStickyData);
    localowh.a((Function1)new RIJCommentNetworkHelper.updateCommentStickyStatus.1(paramosl, paramFirstCommentStickyData));
    localowh.a((Function0)new RIJCommentNetworkHelper.updateCommentStickyStatus.2(paramosl, paramFirstCommentStickyData));
    localowh.a();
    QLog.d("RIJCommentNetworkHelper", 1, "update comment setTop status, detail : " + paramFirstCommentStickyData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owr
 * JD-Core Version:    0.7.0.1
 */