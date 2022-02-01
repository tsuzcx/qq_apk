package com.tencent.mobileqq.troop.announcement.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ITroopAnnouncementHelperApi
  extends QRouteApi
{
  public static final String CONTROL_INFO = "controlInfo";
  public static final String CONTROL_INFO_COMPRESS = "compress";
  public static final String CONTROL_INFO_FILTER_ID = "filterID";
  public static final String CONTROL_INFO_SRC = "src";
  public static final String CONTROL_INFO_VAILD_TIME = "validTime";
  public static final String CONTROL_TYPE = "controlType";
  public static final int CONTROL_TYPE_VAILD_TIME_AND_FILTER = 1;
  public static final int IS_COMPRESSED = 1;
  
  public abstract ITroopAnnouncementHelperApi.FeedItem decodeToFeedItem(String paramString, byte[] paramArrayOfByte, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi
 * JD-Core Version:    0.7.0.1
 */