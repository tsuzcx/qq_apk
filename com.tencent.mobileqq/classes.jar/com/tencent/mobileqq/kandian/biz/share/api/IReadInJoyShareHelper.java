package com.tencent.mobileqq.kandian.biz.share.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IReadInJoyShareHelper
  extends QRouteApi
{
  public static final int ACTION_OPEN_WEISHI_ACCOUNT = 22;
  public static final int ADD_FAVOURITE = 12;
  public static final int ADD_FRIEND = 17;
  public static final int ADD_TO_COLUMN = 37;
  public static final int COLOR_NOTE = 32;
  public static final int COLOR_NOTE_DELETE = 33;
  public static final int COPY_LINK = 14;
  public static final int CREATE_SHARED_CARD = 30;
  public static final int DELETE = 25;
  public static final int DELETE_COLUMN = 36;
  public static final int DIS_LIKE = 15;
  public static final int EDIT = 35;
  public static final int EXPORT_TENCENT_DOCS = 28;
  public static final int FAN_GROUP = 29;
  public static final int FAV_MOVE_GROUP = 39;
  public static final int KAN_DIAN = 1;
  public static final int NOT_CARE = 19;
  public static final int OPEN_AIO = 16;
  public static final int OPEN_MORE_INFO = 21;
  public static final int ORDER_LIST = 27;
  public static final int PERSONAL_C2C = 22;
  public static final int QQ_BROWSER = 7;
  public static final int QQ_FRIEND = 2;
  public static final int QZONE = 3;
  public static final int REMOVE_FANS = 18;
  public static final int REMOVE_FROM_COLUMN = 38;
  public static final int REPORT = 20;
  public static final int SAVE_PIC = 11;
  public static final int SAVE_SHARED_CARD = 31;
  public static final int SCREEN_SHOT = 9;
  public static final int SEND_COMPUTER = 13;
  public static final int SET_FONT = 10;
  public static final int SHOP_APPLY = 26;
  public static final int SYNCHRONIZE_QZONE_STATUS = 34;
  public static final int SYS_BROWSER = 8;
  public static final int UNFOLLOW = 23;
  public static final int VIDEO_ACCOUNT_ICON = 24;
  public static final int VIDEO_FEEDBACK = 121;
  public static final int VIDEO_PLAY_FEEDBACK = 122;
  public static final int WE_BO = 6;
  public static final int WE_CHAT = 4;
  public static final int WE_CHAT_CIRCLE = 5;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IReadInJoyShareHelper
 * JD-Core Version:    0.7.0.1
 */