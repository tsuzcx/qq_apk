package com.tencent.mobileqq.kandian.biz.viola.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaAccessHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getviolaurlfromweb", "", "webUrl", "isKanDianWebHost", "", "isViolaUrlFromWeb", "saveViolaFollowChannel", "", "channelUrl", "startViolaPage", "context", "Landroid/content/Context;", "title", "jsUrl", "bundle", "Landroid/os/Bundle;", "useTransParentfragment", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaAccessHelper
  extends QRouteApi
{
  public static final IViolaAccessHelper.Companion Companion = IViolaAccessHelper.Companion.a;
  @NotNull
  public static final String DEBUG_KEY_HAS_OP_NATIVE_VIOLA_VIDEO_FEEDS_SWITCH = "test_has_op_native_viola_video_feeds_switch";
  @NotNull
  public static final String DEBUG_KEY_NATIVE_VIOLA_VIDEO_FEEDS_SWITCH = "test_native_viola_video_feeds_switch";
  @NotNull
  public static final String DEBUG_KEY_TEST_OPEN_OLD_STYLE_VIOLA_VIOLA_FEEDS_SWITCH = "test_open_old_style_video_feeds";
  @NotNull
  public static final String DEBUG_KEY_TEST_OP_OPEN_OLD_STYLE_VIOLA_VIOLA_FEEDS_SWITCH = "test_op_open_old_style_video_feeds";
  @NotNull
  public static final String DEBUG_KEY_VIOLA_JS_CACHE = "test_viola_js_cache";
  @NotNull
  public static final String FROM_COLOR_NOTE = "from_color_note";
  @NotNull
  public static final String INIT_DATA_PAGE_COLOR_BALL_DATA = "colorBallData";
  @NotNull
  public static final String INIT_DATA_PAGE_PARAM = "param";
  @NotNull
  public static final String INIT_DATA_PAGE_URL = "url";
  @NotNull
  public static final String USE_TRANS_PARENT_FRAGMENT = "useTransParentFragment";
  @NotNull
  public static final String VIOLA_PIC_DETAIL = "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1";
  
  @Nullable
  public abstract String getviolaurlfromweb(@Nullable String paramString);
  
  public abstract boolean isKanDianWebHost(@Nullable String paramString);
  
  public abstract boolean isViolaUrlFromWeb(@Nullable String paramString);
  
  public abstract void saveViolaFollowChannel(@Nullable String paramString);
  
  public abstract void startViolaPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle);
  
  public abstract void startViolaPage(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Bundle paramBundle, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaAccessHelper
 * JD-Core Version:    0.7.0.1
 */