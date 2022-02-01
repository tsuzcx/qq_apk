package com.tencent.mobileqq.newnearby;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyResDownloader
  extends QRouteApi
{
  public static final String FIND_ICON_NOR = "find_icon_nor.webp";
  public static final String FIND_ICON_SEL = "find_icon_sel.webp";
  public static final String GROUP_ICON_NOR = "group_icon_nor.webp";
  public static final String GROUP_ICON_SEL = "group_icon_sel.webp";
  public static final String LIVE_ICON_NOR = "live_icon_nor.webp";
  public static final String LIVE_ICON_SEL = "live_icon_sel.webp";
  public static final String MATCH_ICON_NOR = "match_icon_nor.webp";
  public static final String MATCH_ICON_SEL = "match_icon_sel.webp";
  public static final String MSG_ICON_NOR = "msg_icon_nor.webp";
  public static final String MSG_ICON_SEL = "msg_icon_sel.webp";
  public static final String NEARBY_BG = "nearby_bg.webp";
  
  public abstract boolean checkRes();
  
  public abstract Drawable downloadImg(int paramInt, boolean paramBoolean);
  
  public abstract Drawable downloadImg(String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyResDownloader
 * JD-Core Version:    0.7.0.1
 */