package com.tencent.mobileqq.kandian.biz.framework.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/framework/api/IRIJAppSetting;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getKanDianMode", "", "getVideoAutoPlaySetting", "", "isAppOnForeground", "", "context", "Landroid/content/Context;", "isInReadInJoyTabFrame", "updateNewKandianDeleteFlag", "", "isDelete", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJAppSetting
  extends QRouteApi
{
  public static final IRIJAppSetting.Companion Companion = IRIJAppSetting.Companion.a;
  public static final int KANDIAN_MODE_LEBA = 2;
  public static final int KANDIAN_MODE_LOCKSCREEN = 7;
  public static final int KANDIAN_MODE_OTHER = 5;
  public static final int KANDIAN_MODE_RECENT = 1;
  public static final int KANDIAN_MODE_SEARCH = 4;
  public static final int KANDIAN_MODE_TAB = 3;
  public static final int KANDIAN_MODE_UNKNOWN = -1;
  public static final int KANDIAN_MODE_VIDEO_TAB = 6;
  @NotNull
  public static final String VIDEO_AUTO_PLAY_SETTING_ITEM_CLOSE = "2";
  @NotNull
  public static final String VIDEO_AUTO_PLAY_SETTING_ITEM_MOBILE_AND_WIFI = "0";
  @NotNull
  public static final String VIDEO_AUTO_PLAY_SETTING_ITEM_WIFI = "1";
  
  public abstract int getKanDianMode();
  
  @Nullable
  public abstract String getVideoAutoPlaySetting();
  
  public abstract boolean isAppOnForeground(@Nullable Context paramContext);
  
  public abstract boolean isInReadInJoyTabFrame();
  
  public abstract void updateNewKandianDeleteFlag(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.api.IRIJAppSetting
 * JD-Core Version:    0.7.0.1
 */