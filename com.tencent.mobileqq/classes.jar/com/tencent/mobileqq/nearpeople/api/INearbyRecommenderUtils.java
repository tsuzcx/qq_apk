package com.tencent.mobileqq.nearpeople.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface INearbyRecommenderUtils
  extends QRouteApi
{
  public static final String File_SUFFIX_NearbyRecommender = "v5.8.nbr";
  public static final int IEXPIRETIME_DEFAULTVAL = 172800;
  public static final String KEY_EXPIRETIME = "key_expiretime";
  public static final String KEY_LOGIN_PULL_INTERVAL = "key_login_pull_interval";
  public static final String KEY_LOGIN_PULL_TIME = "key_login_pull_time";
  public static final String KEY_MSGBOX_PULL_INTERVAL = "key_msgbox_pull_interval";
  public static final String KEY_MSGBOX_PULL_TIME = "key_msgbox_pull_time";
  public static final String KEY_NEARBYRECOMMENDER_REASONTYPE = "key_nearbyrecommender_reasontype";
  public static final String KEY_NEARBYRECOMMENDER_TITLE = "key_nearbyrecommender_title";
  public static final String KEY_NEARBYRECOMMENDER_UINS = "key_nearbyrecommender_uins";
  public static final int PULL_AGE = 18;
  public static final int PULL_INTERVAL_DEFAULTVAL_FORLOGIN = 86400;
  public static final int PULL_INTERVAL_DEFAULTVAL_FORMSGBOX = 180;
  public static final String SP_NEARBYRECOMMENDER = "sp_nearbyrecommender";
  public static final String TAG = "NearbyRecommenderUtils";
  
  public abstract void addGrayTipsMsg(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void addNearbyRecommenderMsg(Object paramObject, String paramString, long paramLong);
  
  public abstract void checkExpireTime(Object paramObject);
  
  public abstract boolean checkShowNearbyRecommender(Object paramObject);
  
  public abstract boolean checkUnreadMsgForNearbyRecommender(Object paramObject);
  
  public abstract String[] getReasonTypeAndUins(Object paramObject);
  
  public abstract boolean isNeedPullNearbyRecommenderData(Object paramObject, int paramInt);
  
  public abstract void setNearbyRecommenderMsgRead(Object paramObject);
  
  public abstract void storeNearbyRecommenderList(Context paramContext, String paramString, List<Object> paramList);
  
  public abstract void updateConfigs(AppInterface paramAppInterface, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils
 * JD-Core Version:    0.7.0.1
 */