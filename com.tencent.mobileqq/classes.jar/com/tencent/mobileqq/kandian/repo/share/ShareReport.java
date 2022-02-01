package com.tencent.mobileqq.kandian.repo.share;

import com.tencent.biz.pubaccount.readinjoy.common.ReportR5BuilderExtensionsKt;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/share/ShareReport;", "", "()V", "TAG", "", "action", "", "actionToShareUnit", "articleStriked", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getArticleStriked", "()Ljava/util/ArrayList;", "setArticleStriked", "(Ljava/util/ArrayList;)V", "from", "isSharing", "", "modelNew", "shareArticleId", "getShareArticleId", "()Ljava/lang/String;", "setShareArticleId", "(Ljava/lang/String;)V", "shareArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "getShareArticleInfo", "()Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "setShareArticleInfo", "(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)V", "uinType", "getUinType", "setUinType", "checkPermissionToShareArticle", "doReport", "", "r5", "reportClick", "kanDianMode", "reportExp", "articleId", "reportResult", "success", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ShareReport
{
  public static final ShareReport a = new ShareReport();
  private static int b;
  private static int c;
  private static boolean d;
  @NotNull
  private static String e = "";
  private static int f;
  private static int g;
  @Nullable
  private static AbsBaseArticleInfo h;
  @Nullable
  private static String i = "";
  @NotNull
  private static ArrayList<String> j = new ArrayList();
  
  @NotNull
  public final String a()
  {
    return e;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    c = paramInt1;
    f = paramInt2;
    g = paramInt3;
    d = true;
    e = "";
    Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(b));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(paramInt2));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(paramInt3));
    localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
    a("0X800AD76", (String)localObject);
  }
  
  public final void a(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    i = paramString;
    b = paramInt1;
    paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
    ReportR5BuilderExtensionsKt.a(paramString, "from", Integer.valueOf(paramInt1));
    ReportR5BuilderExtensionsKt.a(paramString, "kandian_mode_new", Integer.valueOf(paramInt2));
    paramString = paramString.build();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "r5.build()");
    a("0X800AD75", paramString);
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    h = paramAbsBaseArticleInfo;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    e = paramString;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "action");
    Intrinsics.checkParameterIsNotNull(paramString2, "r5");
    Object localObject = (QQAppInterface)null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localBaseApplicationImpl, "BaseApplicationImpl.sApplication");
    if ((localBaseApplicationImpl.getRuntime() instanceof QQAppInterface))
    {
      localObject = BaseApplicationImpl.sApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.sApplication");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject != null) {
        localObject = (QQAppInterface)localObject;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
      }
    }
    PublicAccountReportUtils.a((AppInterface)localObject, "", paramString1, paramString1, 0, 0, "", i, "", paramString2, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (d)
    {
      d = false;
      Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(b));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(g));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(f));
      int k = c;
      if ((k == 72) || (k == 2)) {
        ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "is_group", e);
      }
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "result", Integer.valueOf(paramBoolean ^ true));
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
      a("0X800AD77", (String)localObject);
    }
  }
  
  @Nullable
  public final AbsBaseArticleInfo b()
  {
    return h;
  }
  
  @Nullable
  public final String c()
  {
    return i;
  }
  
  @NotNull
  public final ArrayList<String> d()
  {
    return j;
  }
  
  public final boolean e()
  {
    String str = String.valueOf(RIJQQAppInterfaceUtil.c());
    if (!j.contains(str))
    {
      j.clear();
      j.add(str);
    }
    if (CollectionsKt.contains((Iterable)j, i))
    {
      QRUtils.a(1, 2131916544);
      QLog.d("ShareReport", 1, "sharing is stroked!");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.share.ShareReport
 * JD-Core Version:    0.7.0.1
 */