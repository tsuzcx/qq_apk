package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopAvatarUtilApi
  extends QRouteApi
{
  public static final int ARTWORK = 0;
  public static final String AVATAR_ADDRESS = "https://p.qlogo.cn/gh/dir/file/";
  public static final int BIGPHOTO = 640;
  public static final String DEFAULT_TROOP_AVATAR_ADDRESS = "https://s.url.cn/pub/img/qb_group_normal.png";
  public static final int NEW_GROUP_URL = 0;
  public static final String REGEXP_URL_STRING = "https://p.qlogo.cn/gh/";
  public static final int REGULAR_URL = 1;
  public static final int THUMBE = 140;
  
  public abstract String getArtWork(String paramString);
  
  public abstract String getAvatarAddress(String paramString1, String paramString2, int paramInt);
  
  public abstract String getThumbPhoto(String paramString);
  
  public abstract boolean isAvatarUrl(String paramString);
  
  public abstract boolean isNumeric(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi
 * JD-Core Version:    0.7.0.1
 */