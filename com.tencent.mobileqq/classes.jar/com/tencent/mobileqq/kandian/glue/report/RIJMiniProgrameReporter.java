package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/RIJMiniProgrameReporter;", "Lcom/tencent/mobileqq/kandian/glue/report/ReadInJoyGlobalReporter;", "()V", "FROM_PAGE_NATIVE_ARTICLE", "", "FROM_PAGE_TL", "REPORT_ACTION_NAME", "", "getREPORT_ACTION_NAME", "()Ljava/lang/String;", "fromPage", "getFromPage", "()I", "setFromPage", "(I)V", "miniAppNotifyListener", "Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "getMiniAppNotifyListener", "()Lcom/tencent/mobileqq/mini/notify/MiniAppNotify$IMiniAppNotifyListener;", "miniProgrameName", "getMiniProgrameName", "setMiniProgrameName", "(Ljava/lang/String;)V", "movieName", "getMovieName", "setMovieName", "rowKey", "getRowKey", "setRowKey", "uin", "getUin", "setUin", "clearMiniProgramInfo", "", "logEnterTimeAndReport", "event", "registerMiniAppListener", "report", "unRegisterMiniAppListener", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJMiniProgrameReporter
  extends ReadInJoyGlobalReporter
{
  public static final RIJMiniProgrameReporter a;
  @NotNull
  private static final MiniAppNotify.IMiniAppNotifyListener a;
  private static int b = 0;
  @NotNull
  private static final String f = "0X800B969";
  @Nullable
  private static String g;
  @Nullable
  private static String h;
  @Nullable
  private static String i;
  @Nullable
  private static String j;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJMiniProgrameReporter = new RIJMiniProgrameReporter();
    f = "0X800B969";
    jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener = (MiniAppNotify.IMiniAppNotifyListener)RIJMiniProgrameReporter.miniAppNotifyListener.1.a;
  }
  
  public void a()
  {
    super.a();
    try
    {
      JSONObject localJSONObject = a();
      Intrinsics.checkExpressionValueIsNotNull(localJSONObject, "getReportR5()");
      localJSONObject.put("from_page", b);
      localJSONObject.put("rowkey", i);
      localJSONObject.put("mini_program_name", g);
      localJSONObject.put("movie_name", h);
      localJSONObject.put("duration", a());
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, j, f, f, 0, 0, a(), "", "", localJSONObject.toString(), false);
      d();
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ReadInJoyGlobalReporter", 1, localException.getMessage());
    }
  }
  
  public final void a(int paramInt)
  {
    b = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    g = paramString;
  }
  
  public final void b()
  {
    MiniAppNotify.g.register(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  public final void b(@Nullable String paramString)
  {
    h = paramString;
  }
  
  public final void c()
  {
    MiniAppNotify.g.remove(jdField_a_of_type_ComTencentMobileqqMiniNotifyMiniAppNotify$IMiniAppNotifyListener);
  }
  
  public final void c(@Nullable String paramString)
  {
    i = paramString;
  }
  
  public final void d()
  {
    String str = (String)null;
    g = str;
    h = str;
    b = 0;
    i = str;
  }
  
  public final void d(@Nullable String paramString)
  {
    j = paramString;
  }
  
  public final void e(@Nullable String paramString)
  {
    if (Intrinsics.areEqual("onResume", paramString))
    {
      int k = RIJAppSetting.a();
      int m = RIJKanDianFolderStatus.reportFolderStatus;
      a(null, NetConnInfoCenter.getServerTimeMillis(), k, m);
      return;
    }
    if ((Intrinsics.areEqual("onPause", paramString)) && (a() > 0L)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter
 * JD-Core Version:    0.7.0.1
 */