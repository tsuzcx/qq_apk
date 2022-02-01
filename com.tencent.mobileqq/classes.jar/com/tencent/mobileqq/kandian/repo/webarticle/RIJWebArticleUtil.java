package com.tencent.mobileqq.kandian.repo.webarticle;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/RIJWebArticleUtil;", "", "()V", "SP_KEY_WEBVIEW_REUSE", "", "SP_KEY_WEBVIEW_TRANS_ANIMATION", "SP_KEY_WEBVIEW_VAS_SONIC", "SP_KEY_WEBVIEW_WARMUP_TEMPLATE", "SP_KEY_WEB_ARTICLE_PRELOAD", "SP_KEY_WEB_ARTICLE_SWITCH", "SP_KEY_WEB_DATA_PRELOAD", "SP_KEY_WEB_LOAD_URL_OPTIMIZE", "SP_KEY_WEB_PROCESS_FOREGROUND_PRELOAD", "TAG", "init", "", "isSupportWebArticle", "", "isSupportWebArticlePreload", "isSupportWebDataPreload", "isSupportWebLoadUrlOptimize", "isSupportWebProcessForegroundPreload", "isSupportWebViewAnimation", "isSupportWebViewReuse", "isSupportWebViewVasSonic", "isSupportWebViewWarmUpTemplate", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleUtil
{
  public static final RIJWebArticleUtil a = new RIJWebArticleUtil();
  
  public final void a()
  {
    RIJMaybeInitializedAladdinConfig.a();
    Object localObject = Aladdin.getConfig(378);
    boolean bool9 = false;
    int i;
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("web_article_switch", 0);
    } else {
      i = 0;
    }
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("webview_reuse", 0);
    } else {
      i = 0;
    }
    boolean bool2;
    if (i == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("webview_vas_sonic", 0);
    } else {
      i = 0;
    }
    boolean bool3;
    if (i == 1) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("webview_transition_animation", 0);
    } else {
      i = 0;
    }
    boolean bool4;
    if (i == 1) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("web_article_preload", 0);
    } else {
      i = 0;
    }
    boolean bool5;
    if (i == 1) {
      bool5 = true;
    } else {
      bool5 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("webview_warmup_template", 0);
    } else {
      i = 0;
    }
    boolean bool6;
    if (i == 1) {
      bool6 = true;
    } else {
      bool6 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("web_data_preload", 0);
    } else {
      i = 0;
    }
    boolean bool7;
    if (i == 1) {
      bool7 = true;
    } else {
      bool7 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("web_process_foreground_preload", 0);
    } else {
      i = 0;
    }
    boolean bool8;
    if (i == 1) {
      bool8 = true;
    } else {
      bool8 = false;
    }
    if (localObject != null) {
      i = ((AladdinConfig)localObject).getIntegerFromString("web_load_url_optimize", 1);
    } else {
      i = 1;
    }
    if (i == 1) {
      bool9 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init] webArticleConfig = { ");
    ((StringBuilder)localObject).append("webArticleSwitch = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webViewReuse = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webViewVasSonic = ");
    ((StringBuilder)localObject).append(bool3);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webViewTransitionAnimation = ");
    ((StringBuilder)localObject).append(bool4);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webArticlePreload = ");
    ((StringBuilder)localObject).append(bool5);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webViewWarmUpTemplate = ");
    ((StringBuilder)localObject).append(bool6);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webDataPreload = ");
    ((StringBuilder)localObject).append(bool7);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("webProcessForegroundPreload = ");
    ((StringBuilder)localObject).append(bool8);
    ((StringBuilder)localObject).append("webLoadUrlOptimize = ");
    ((StringBuilder)localObject).append(bool9);
    ((StringBuilder)localObject).append(" }");
    QLog.i("RIJWebArticleUtil", 1, ((StringBuilder)localObject).toString());
    RIJSPUtils.a("sp_key_web_article_switch", Boolean.valueOf(bool1));
    RIJSPUtils.a("sp_key_webview_reuse", Boolean.valueOf(bool2));
    RIJSPUtils.a("sp_key_webview_sonic", Boolean.valueOf(bool3));
    RIJSPUtils.a("sp_key_webview_trans_animation", Boolean.valueOf(bool4));
    RIJSPUtils.a("sp_key_web_article_preload", Boolean.valueOf(bool5));
    RIJSPUtils.a("sp_key_webview_warmup_template", Boolean.valueOf(bool6));
    RIJSPUtils.a("sp_key_web_data_preload", Boolean.valueOf(bool7));
    RIJSPUtils.a("sp_key_web_process_foreground_preload", Boolean.valueOf(bool8));
    RIJSPUtils.a("sp_key_load_url_optimize", Boolean.valueOf(bool9));
  }
  
  public final boolean a()
  {
    Object localObject = RIJSPUtils.a("sp_key_web_article_switch", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…EB_ARTICLE_SWITCH, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean b()
  {
    Object localObject = RIJSPUtils.a("sp_key_webview_reuse", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…KEY_WEBVIEW_REUSE, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean c()
  {
    Object localObject = RIJSPUtils.a("sp_key_webview_sonic", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…WEBVIEW_VAS_SONIC, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean d()
  {
    Object localObject = RIJSPUtils.a("sp_key_webview_trans_animation", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…W_TRANS_ANIMATION, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean e()
  {
    Object localObject = RIJSPUtils.a("sp_key_web_article_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…B_ARTICLE_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean f()
  {
    Object localObject = RIJSPUtils.a("sp_key_webview_warmup_template", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…W_WARMUP_TEMPLATE, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean g()
  {
    Object localObject = RIJSPUtils.a("sp_key_web_data_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…_WEB_DATA_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean h()
  {
    Object localObject = RIJSPUtils.a("sp_key_web_process_foreground_preload", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…OREGROUND_PRELOAD, false)");
    return ((Boolean)localObject).booleanValue();
  }
  
  public final boolean i()
  {
    Object localObject = RIJSPUtils.a("sp_key_load_url_optimize", Boolean.valueOf(true));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…_LOAD_URL_OPTIMIZE, true)");
    return ((Boolean)localObject).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleUtil
 * JD-Core Version:    0.7.0.1
 */