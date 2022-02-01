package com.tencent.qzonehub.api.contentbox;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import java.util.ArrayList;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQzoneMsgApi
  extends QRouteApi
{
  public static final String ACTION = "action";
  public static final String ACTION_SYNC_QZONE_COMMENT_LIKE = "com.qzone.sync_comment_like";
  public static final int CLICK_TYPE_COMMENT = 2;
  public static final int CLICK_TYPE_DETAIL = 0;
  public static final int CLICK_TYPE_FRIENDFEED = 5;
  public static final int CLICK_TYPE_LIKE = 1;
  public static final int CLICK_TYPE_SHAREQQ = 3;
  public static final int CLICK_TYPE_SHAREQZONE = 4;
  public static final String FEED = "feed";
  public static final String LIKE_KEY = "like_key";
  public static final String SYNC_QZONE_COMMENT_COMMENT_NUM = "sync_comment_commentnum";
  public static final String SYNC_QZONE_COMMENT_HASLIKE = "sync_comment_haslike";
  public static final String SYNC_QZONE_COMMENT_LIKE_KEY = "sync_comment_likekey";
  public static final String SYNC_QZONE_COMMENT_LIKE_NUM = "sync_comment_likenum";
  
  public abstract void likeFeed(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, long paramLong);
  
  public abstract ArrayList<QZoneMsgEntityNew> loadMsgFromDB(AppRuntime paramAppRuntime);
  
  public abstract boolean open(Context paramContext, AppRuntime paramAppRuntime);
  
  public abstract boolean openContentBox(Context paramContext);
  
  public abstract void preloadData(AppRuntime paramAppRuntime);
  
  public abstract void refreshQzoneMsg(AppRuntime paramAppRuntime);
  
  public abstract void saveMsgToDB(AppRuntime paramAppRuntime, IMQMsg paramIMQMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.IQzoneMsgApi
 * JD-Core Version:    0.7.0.1
 */