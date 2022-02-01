package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/utils/IExpandReportUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getManageTestPlanParams", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "initReport", "", "onUserActionToTunnel", "event", "isSucc", "", "longElapse", "", "longSize", "params", "", "immediat", "var9", "reportEnterExpandClick", "from", "reportEnterExpandPage", "Companion", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandReportUtils
  extends QRouteApi
{
  public static final IExpandReportUtils.Companion Companion = IExpandReportUtils.Companion.a;
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_ADD_FRIEND = "1";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_CHAT_MEET = "5";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_CHAT_PROFILE = "6";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_LEBA = "2";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_OTHER = "7";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_QZONE_SHUOSHUO = "4";
  @NotNull
  public static final String ENTRY_EXPAND_FROM_PAGE_ID_QZONE_TAIL = "3";
  @NotNull
  public static final String EXPAND_APP_KEY = "0AND0Y11VZ3PFHQD";
  @NotNull
  public static final String REPORT_KEY_MANAGER_TEST_PLAN = "manage_test_plan";
  @NotNull
  public static final String REPORT_VALUE_MANAGE_TEST_PLAN_AIO_NOT_SAVE = "aio_not_save";
  @NotNull
  public static final String REPORT_VALUE_MANAGE_TEST_PLAN_NEW_NORMAL = "new_normal";
  @NotNull
  public static final String REPORT_VALUE_MANAGE_TEST_PLAN_NEW_USER_SPECIAL_ITEM = "new_user_special_item";
  @NotNull
  public static final String REPORT_VALUE_MANAGE_TEST_PLAN_OLD_MEET = "old_meet";
  
  @Nullable
  public abstract String getManageTestPlanParams(@NotNull BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void initReport();
  
  public abstract void onUserActionToTunnel(@NotNull String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, @Nullable Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract void onUserActionToTunnel(@NotNull String paramString, boolean paramBoolean, @Nullable Map<String, String> paramMap);
  
  public abstract void reportEnterExpandClick(@NotNull String paramString);
  
  public abstract void reportEnterExpandPage(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils
 * JD-Core Version:    0.7.0.1
 */