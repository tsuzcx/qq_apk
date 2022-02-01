package com.tencent.mobileqq.qqexpand.entrance;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandFragmentRouter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "launchExpandEditFragment", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "launchExpandEditFragmentForResult", "requestCode", "", "launchNewEditFragmentForResult", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandFragmentRouter
  extends QRouteApi
{
  public static final IExpandFragmentRouter.Companion Companion = IExpandFragmentRouter.Companion.a;
  public static final int EXPAND_PAGE_SOURCE_OTHER = 7;
  public static final int EXPAND_PAGE_SOURCE_PUSH = 11;
  public static final int EXPAND_PAGE_SOURCE_QQ_BANNER = 10;
  public static final int EXPAND_PAGE_SOURCE_QQ_CARD = 9;
  public static final int FROM_OPT_EXTEND_FRIEND_SQUAR = 0;
  public static final int FROM_OPT_PLUS_PANEL = 1;
  @NotNull
  public static final String FROM_TYPE = "extend_frient_from";
  @NotNull
  public static final String FROM_TYPE_CHAT = "ExtendFriendLimitChatFromeType";
  @NotNull
  public static final String KEY_EXTEND_FRIEND_INFO = "key_extend_friend_info";
  @NotNull
  public static final String KEY_FIRST_POSITION = "key_first_position";
  @NotNull
  public static final String KEY_FROM_TOP = "key_from_top";
  @NotNull
  public static final String KEY_IS_LIVE_OPEN = "key_is_live_open";
  @NotNull
  public static final String KEY_LIVE_QZONE_INDEX = "key_qzone_live_index";
  @NotNull
  public static final String KEY_NUANSHUOSHUO_QZONE_INDEX = "key_qzone_nuanshuoshuo_index";
  @NotNull
  public static final String KEY_QZONE_INDEX = "key_qzone_index";
  @NotNull
  public static final String KEY_RED_TOUCH = "key_red_touch";
  @NotNull
  public static final String KEY_TAB_CLICKED = "key_tab_clicked";
  @NotNull
  public static final String KEY_TAB_IDS = "key_tab_ids";
  @NotNull
  public static final String KEY_TAB_LABLES = "key_tab_lables";
  public static final int MIN_CLOTHES_ID = 10000;
  public static final int REQ_EDIT_FINISH = 4097;
  public static final int RESP_EDIT_FINISH = 8193;
  @NotNull
  public static final String ROUTE_NAME = "/expand/activity";
  public static final int SOURCE_TYPE_ADD_FRIEND = 1;
  public static final int SOURCE_TYPE_DEFAULT = 0;
  public static final int SOURCE_TYPE_FLUTTER_MATCH = 4;
  public static final int SOURCE_TYPE_LEBA = 2;
  public static final int SOURCE_TYPE_PLUS = 6;
  public static final int SOURCE_TYPE_PROFILE = 5;
  public static final int SOURCE_TYPE_QZONE = 3;
  @NotNull
  public static final String TYPE_URL = "extend_frient_type_url";
  
  public abstract void launchExpandEditFragment(@NotNull Activity paramActivity, @Nullable Intent paramIntent);
  
  public abstract void launchExpandEditFragmentForResult(@NotNull Activity paramActivity, @Nullable Intent paramIntent, int paramInt);
  
  public abstract void launchNewEditFragmentForResult(@NotNull Activity paramActivity, @Nullable Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter
 * JD-Core Version:    0.7.0.1
 */