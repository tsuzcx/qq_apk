package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.mini.notify.MiniAppNotify;
import com.tencent.mobileqq.mini.notify.MiniAppNotify.IMiniAppNotifyListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
  public static final RIJMiniProgrameReporter a = new RIJMiniProgrameReporter();
  @NotNull
  private static final String m = "0X800B969";
  @Nullable
  private static String n;
  @Nullable
  private static String o;
  private static int p;
  @Nullable
  private static String q;
  @Nullable
  private static String r;
  @NotNull
  private static final MiniAppNotify.IMiniAppNotifyListener s = (MiniAppNotify.IMiniAppNotifyListener)RIJMiniProgrameReporter.miniAppNotifyListener.1.a;
  
  public void a()
  {
    super.a();
    try
    {
      JSONObject localJSONObject = h();
      Intrinsics.checkExpressionValueIsNotNull(localJSONObject, "getReportR5()");
      localJSONObject.put("from_page", p);
      localJSONObject.put("rowkey", q);
      localJSONObject.put("mini_program_name", n);
      localJSONObject.put("movie_name", o);
      localJSONObject.put("duration", i());
      PublicAccountReportUtils.a(null, r, m, m, 0, 0, i(), "", "", localJSONObject.toString(), false);
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
    p = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    n = paramString;
  }
  
  public final void b()
  {
    MiniAppNotify.g.register(s);
  }
  
  public final void b(@Nullable String paramString)
  {
    o = paramString;
  }
  
  public final void c()
  {
    MiniAppNotify.g.remove(s);
  }
  
  public final void c(@Nullable String paramString)
  {
    q = paramString;
  }
  
  public final void d()
  {
    String str = (String)null;
    n = str;
    o = str;
    p = 0;
    q = str;
  }
  
  public final void d(@Nullable String paramString)
  {
    r = paramString;
  }
  
  public final void e(@Nullable String paramString)
  {
    if (Intrinsics.areEqual("onResume", paramString))
    {
      int i = RIJAppSetting.b();
      int j = RIJKanDianFolderStatus.reportFolderStatus;
      a(null, NetConnInfoCenter.getServerTimeMillis(), i, j);
      return;
    }
    if ((Intrinsics.areEqual("onPause", paramString)) && (g() > 0L)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJMiniProgrameReporter
 * JD-Core Version:    0.7.0.1
 */