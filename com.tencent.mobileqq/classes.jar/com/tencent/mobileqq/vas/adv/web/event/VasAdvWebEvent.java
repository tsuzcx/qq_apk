package com.tencent.mobileqq.vas.adv.web.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent;", "", "Callback", "Companion", "Publisher", "Subscriber", "vas-adv-api_release"}, k=1, mv={1, 1, 16})
public abstract interface VasAdvWebEvent
{
  public static final int CLICK_AREA_AVATAR = 1;
  public static final int CLICK_AREA_BUTTON = 4;
  public static final int CLICK_AREA_FEEDBACK = 5;
  public static final int CLICK_AREA_NICKNAME = 2;
  public static final int CLICK_AREA_TEXT = 3;
  public static final int CLICK_AREA_VIDEO = 0;
  public static final VasAdvWebEvent.Companion Companion = VasAdvWebEvent.Companion.$$INSTANCE;
  @NotNull
  public static final String GET_GDT_AD_DATA = "get_gdt_ad_data";
  @NotNull
  public static final String HANDLE_WEB_CLICK = "handle_web_click";
  @NotNull
  public static final String NOTIFY_WEB_STATUS = "notify_web_status";
  public static final int WEB_STATUS_INIT = 0;
  public static final int WEB_STATUS_LOAD_AD = 1;
  public static final int WEB_STATUS_READY = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent
 * JD-Core Version:    0.7.0.1
 */