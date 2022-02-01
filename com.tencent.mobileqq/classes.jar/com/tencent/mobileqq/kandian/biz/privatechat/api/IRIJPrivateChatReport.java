package com.tencent.mobileqq.kandian.biz.privatechat.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/api/IRIJPrivateChatReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportData", "", "actionName", "", "r5", "Companion", "R5Builder", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJPrivateChatReport
  extends QRouteApi
{
  public static final IRIJPrivateChatReport.Companion Companion = IRIJPrivateChatReport.Companion.a;
  @NotNull
  public static final String PRIVATE_CHAT_ADD_FRIEND_CLICK_ACTION = "0X800BD0F";
  public static final int PRIVATE_CHAT_FEEDS_TYPE = 15;
  @NotNull
  public static final String PRIVATE_CHAT_ITEM_CLICK_ACTION = "0X800BD0D";
  @NotNull
  public static final String PRIVATE_CHAT_ITEM_EXPOSURE_ACTION = "0X800BD0C";
  @NotNull
  public static final String PRIVATE_CHAT_SHIELD_FRIEND_CLICK_ACTION = "0X800BD10";
  
  public abstract void reportData(@NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport
 * JD-Core Version:    0.7.0.1
 */