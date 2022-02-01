package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.ThreadManager;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/FluencyOptUtils;", "", "()V", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "urlStrToObjMap", "", "", "Ljava/net/URL;", "addUrlObjToCache", "", "url", "addUrlStrToCache", "getUrlObjFromCache", "isEnableCardCreateCostReport", "", "isEnableGestureDataReport", "isEnablePreloadProteusView", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class FluencyOptUtils
{
  public static final FluencyOptUtils a = new FluencyOptUtils();
  private static final Map<String, URL> b = (Map)new LinkedHashMap();
  private static final AladdinConfig c;
  
  static
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(330);
    Intrinsics.checkExpressionValueIsNotNull(localAladdinConfig, "Aladdin.getConfig(QQAlad…ONFIG_FLUENCY_OPT_SWITCH)");
    c = localAladdinConfig;
  }
  
  public final void a(@Nullable String paramString)
  {
    if ((paramString != null) && (!b.containsKey(paramString))) {
      ThreadManager.executeOnSubThread((Runnable)new FluencyOptUtils.addUrlStrToCache.1(paramString));
    }
  }
  
  public final void a(@NotNull URL paramURL)
  {
    Intrinsics.checkParameterIsNotNull(paramURL, "url");
    Map localMap = b;
    String str = paramURL.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "url.toString()");
    localMap.put(str, paramURL);
  }
  
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = c;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("card_create_cost_report_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  @Nullable
  public final URL b(@Nullable String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (URL)b.get(paramString);
  }
  
  public final boolean b()
  {
    AladdinConfig localAladdinConfig = c;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("asynce_create_view_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean c()
  {
    AladdinConfig localAladdinConfig = c;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("gesture_data_switch", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils
 * JD-Core Version:    0.7.0.1
 */