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
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstCommentForHippy.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createFirstCommentForHippy.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubCommentForHippy.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.createSubCommentForHippy.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.sinkComment.2;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.updateCommentStickyStatus.1;
import com.tencent.biz.pubaccount.readinjoy.comment.helper.RIJCommentNetworkHelper.updateCommentStickyStatus.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper;", "", "()V", "BUNDLE_KEY_CREATE_COMMENT_DATA", "", "BUNDLE_KEY_JS_OBJ", "TAG", "seqFactory", "Ljava/util/concurrent/atomic/AtomicLong;", "authorDeleteComment", "", "contentSrc", "", "commentViewItem", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/CommentViewItem;", "feedsType", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/comment/ReadInJoyCommentObserver;", "checkErrorCode", "errorCode", "createFirstComment", "", "requestData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentObserver;", "commentJsonStr", "isFeeds", "", "needBiuAfterComment", "createFirstCommentForHippy", "Lcom/tencent/biz/pubaccount/readinjoy/comment/helper/RIJCommentNetworkHelper$RIJCreateCommentForHippyObserver;", "extraParam", "createSubComment", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "createSubCommentForHippy", "doCreateCommentReport", "consumeTime", "sendIsCopyMessageTo0xdc8", "commentContent", "rowKey", "parentCommentId", "subCommentId", "commentId", "sinkComment", "commentSinkData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentSinkData;", "updateCommentStickyStatus", "commentStickyData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "RIJCreateCommentForHippyObserver", "RIJCreateCommentObserver", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgv
{
  private static final AtomicLong a;
  public static final pgv a;
  
  static
  {
    jdField_a_of_type_Pgv = new pgv();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  @JvmStatic
  public static final void a(int paramInt)
  {
    if (paramInt == -4096)
    {
      QQToast localQQToast = QQToast.a((Context)BaseApplicationImpl.sApplication, (CharSequence)anvx.a(2131717645), 1);
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
    olh.a(null, "", "0X8009A35", "0X8009A35", 0, 0, "", "", "", localJSONObject.toString(), false);
    uvs.a(paramInt, 7, paramLong, null);
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (pbq.a((Context)BaseApplicationImpl.getContext(), paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJCommentNetworkHelper", 2, "commentSink commentContent: " + paramString1 + ", rowKey: " + paramString2 + ", parentCommentId: " + paramString3 + ", subCommentId: " + paramString4 + ", commentId: " + paramString5);
      }
      paramString1 = pnn.a();
      if (paramString1 != null) {}
      for (paramString1 = paramString1.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER); paramString1 == null; paramString1 = null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager");
      }
      paramString1 = ((pvp)paramString1).a();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "logicManager.readInJoyLogicEngine");
      paramString1 = paramString1.a();
      if (paramString1 != null) {
        paramString1.a(paramString2, paramString3, paramString4, paramString5);
      }
    }
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull pgx parampgx, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgx, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramFirstCommentCreateData, parampgx, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull pgx parampgx, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgx, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "firstCommentCreateData: " + paramFirstCommentCreateData);
    }
    pga localpga = new pga(paramFirstCommentCreateData);
    localpga.a((Function1)new RIJCommentNetworkHelper.createFirstComment.1(paramBoolean2, parampgx, l1, paramString, paramInt, paramBoolean1, paramFirstCommentCreateData, l2));
    localpga.a((Function2)new RIJCommentNetworkHelper.createFirstComment.2(parampgx, l1, paramString, paramInt, paramBoolean1, l2));
    localpga.a();
    return l1;
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull pgx parampgx, @NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgx, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    return a(paramSubCommentCreateData, parampgx, paramString, paramInt, paramBoolean, false);
  }
  
  public final long a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull pgx parampgx, @NotNull String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgx, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "commentJsonStr");
    long l1 = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "subCommentCreateData: " + paramSubCommentCreateData);
    }
    pge localpge = new pge(paramSubCommentCreateData);
    localpge.a((Function1)new RIJCommentNetworkHelper.createSubComment.1(paramBoolean2, parampgx, l1, paramString, paramInt, paramBoolean1, paramSubCommentCreateData, l2));
    localpge.a((Function2)new RIJCommentNetworkHelper.createSubComment.2(parampgx, l1, paramString, paramInt, paramBoolean1, l2));
    localpge.a();
    return l1;
  }
  
  public final void a(int paramInt1, @NotNull pdp parampdp, int paramInt2, @NotNull pbm parampbm)
  {
    Intrinsics.checkParameterIsNotNull(parampdp, "commentViewItem");
    Intrinsics.checkParameterIsNotNull(parampbm, "callback");
    BaseCommentData localBaseCommentData = parampdp.a;
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
      localObject = new pfx(new pgo(localSimpleCommentData, localBaseCommentData.getCommentLevel(), str, (String)localObject));
      ((pfx)localObject).a((Function1)new RIJCommentNetworkHelper.authorDeleteComment.1(parampbm, parampdp, paramInt2));
      ((pfx)localObject).b((Function1)new RIJCommentNetworkHelper.authorDeleteComment.2(parampbm, parampdp, paramInt2));
      ((pfx)localObject).a();
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
  
  public final void a(@NotNull FirstCommentCreateData paramFirstCommentCreateData, @NotNull pgw parampgw, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgw, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "firstCommentCreateData: " + paramFirstCommentCreateData + ' ' + paramString);
    }
    paramString = new pgc(paramFirstCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.1(paramBoolean, parampgw, paramFirstCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createFirstCommentForHippy.2(parampgw, l));
    paramString.a();
  }
  
  public final void a(@NotNull FirstCommentSinkData paramFirstCommentSinkData, @NotNull pbm parampbm)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentSinkData, "commentSinkData");
    Intrinsics.checkParameterIsNotNull(parampbm, "callback");
    pgi localpgi = new pgi(paramFirstCommentSinkData);
    localpgi.a((Function1)new RIJCommentNetworkHelper.sinkComment.1(parampbm, paramFirstCommentSinkData));
    localpgi.a((Function0)new RIJCommentNetworkHelper.sinkComment.2(parampbm, paramFirstCommentSinkData));
    localpgi.a();
    QLog.d("RIJCommentNetworkHelper", 1, "sink comment, detail : " + paramFirstCommentSinkData);
  }
  
  public final void a(@NotNull FirstCommentStickyData paramFirstCommentStickyData, @NotNull pbm parampbm)
  {
    Intrinsics.checkParameterIsNotNull(paramFirstCommentStickyData, "commentStickyData");
    Intrinsics.checkParameterIsNotNull(parampbm, "callback");
    pgl localpgl = new pgl(paramFirstCommentStickyData);
    localpgl.a((Function1)new RIJCommentNetworkHelper.updateCommentStickyStatus.1(parampbm, paramFirstCommentStickyData));
    localpgl.a((Function0)new RIJCommentNetworkHelper.updateCommentStickyStatus.2(parampbm, paramFirstCommentStickyData));
    localpgl.a();
    QLog.d("RIJCommentNetworkHelper", 1, "update comment setTop status, detail : " + paramFirstCommentStickyData);
  }
  
  public final void a(@NotNull SubCommentCreateData paramSubCommentCreateData, @NotNull pgw parampgw, boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramSubCommentCreateData, "requestData");
    Intrinsics.checkParameterIsNotNull(parampgw, "callback");
    Intrinsics.checkParameterIsNotNull(paramString, "extraParam");
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("RIJCommentNetworkHelper", 2, "subCommentCreateData: " + paramSubCommentCreateData + ' ' + paramString);
    }
    paramString = new pgg(paramSubCommentCreateData, paramString);
    paramString.a((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.1(paramBoolean, parampgw, paramSubCommentCreateData, l));
    paramString.b((Function2)new RIJCommentNetworkHelper.createSubCommentForHippy.2(parampgw, l));
    paramString.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgv
 * JD-Core Version:    0.7.0.1
 */