package com.tencent.mobileqq.qwallet.hb;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket;

@QAPI(process={"all"})
public abstract interface IRedPacketProxy
  extends QRouteApi, IRedPacket
{
  public static final String KEY_POP_AD_BG_JUMP_URL = "pop_ad_bg_jump_url";
  public static final String KEY_POP_AD_ICON = "pop_ad_icon";
  public static final String KEY_POP_AD_TIPS = "pop_ad_tips";
  public static final String KEY_POP_AD_URL = "pop_ad_url";
  public static final String KEY_POP_AD_URL_TYPE = "pop_ad_url_type";
  
  @Deprecated
  public abstract IRedPacket getRedPacket();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.IRedPacketProxy
 * JD-Core Version:    0.7.0.1
 */