package com.tencent.mobileqq.kandian.repo.share;

import com.tencent.biz.pubaccount.readinjoy.common.ReportR5BuilderExtensionsKt;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static int jdField_a_of_type_Int;
  @Nullable
  private static AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  public static final ShareReport a;
  @NotNull
  private static String jdField_a_of_type_JavaLangString;
  @NotNull
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  @Nullable
  private static String jdField_b_of_type_JavaLangString;
  private static int c;
  private static int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoShareShareReport = new ShareReport();
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
  }
  
  @Nullable
  public final AbsBaseArticleInfo a()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  @NotNull
  public final String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  @NotNull
  public final ArrayList<String> a()
  {
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    jdField_b_of_type_Int = paramInt1;
    c = paramInt2;
    d = paramInt3;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "";
    Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(jdField_a_of_type_Int));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(paramInt2));
    ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(paramInt3));
    localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
    a("0X800AD76", (String)localObject);
  }
  
  public final void a(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    jdField_b_of_type_JavaLangString = paramString;
    jdField_a_of_type_Int = paramInt1;
    paramString = new RIJTransMergeKanDianReport.ReportR5Builder();
    ReportR5BuilderExtensionsKt.a(paramString, "from", Integer.valueOf(paramInt1));
    ReportR5BuilderExtensionsKt.a(paramString, "kandian_mode_new", Integer.valueOf(paramInt2));
    paramString = paramString.build();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "r5.build()");
    a("0X800AD75", paramString);
  }
  
  public final void a(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    jdField_a_of_type_JavaLangString = paramString;
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
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent((AppInterface)localObject, "", paramString1, paramString1, 0, 0, "", jdField_b_of_type_JavaLangString, "", paramString2, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      Object localObject = new RIJTransMergeKanDianReport.ReportR5Builder();
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "from", Integer.valueOf(jdField_a_of_type_Int));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "share_unit", Integer.valueOf(d));
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "kandian_mode_new", Integer.valueOf(c));
      int i = jdField_b_of_type_Int;
      if ((i == 72) || (i == 2)) {
        ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "is_group", jdField_a_of_type_JavaLangString);
      }
      ReportR5BuilderExtensionsKt.a((RIJTransMergeKanDianReport.ReportR5Builder)localObject, "result", Integer.valueOf(paramBoolean ^ true));
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5.build()");
      a("0X800AD77", (String)localObject);
    }
  }
  
  public final boolean a()
  {
    String str = String.valueOf(RIJQQAppInterfaceUtil.a());
    if (!jdField_a_of_type_JavaUtilArrayList.contains(str))
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      jdField_a_of_type_JavaUtilArrayList.add(str);
    }
    if (CollectionsKt.contains((Iterable)jdField_a_of_type_JavaUtilArrayList, jdField_b_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131719009);
      QLog.d("ShareReport", 1, "sharing is stroked!");
      return true;
    }
    return false;
  }
  
  @Nullable
  public final String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.share.ShareReport
 * JD-Core Version:    0.7.0.1
 */