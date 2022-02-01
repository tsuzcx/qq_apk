package com.tencent.mobileqq.qqgamepub.api;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IGameShareUtil
  extends QRouteApi
{
  public static final String DEFAULT_VALUE_SOURCE_AIO_RIGHT_TXT = "有新动态";
  public static final String DEF_AIO_LEFT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&autodownload=1&autolaunch=1&autosubscribe=1&ADTAG=87006&appid=";
  public static final String DEF_AIO_RIGHT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87006&appid=";
  public static final String DEF_PIC_LEFT_URL = "https://speed.gamecenter.qq.com/pushgame/v1/detail?_wv=2164260896&_wwv=448&ADTAG=87007&appid=";
  public static final int DP_SHARE_LAYOUT_WIDTH = 251;
  public static final String KEY_MSG_FRIEND_UIN = "friend_uin";
  public static final String KEY_MSG_IS_TROOP = "is_troop";
  public static final String KEY_MSG_UNISEQ = "uniseq";
  public static final String KEY_SOURCE_AIO_SUBTYPE = "game_source_subtype_aio";
  public static final String KEY_SOURCE_AIO_TXT = "game_source_aio_txt";
  public static final String KEY_SOURCE_AIO_TYPE = "game_source_type_aio";
  public static final String KEY_SOURCE_AIO_URL = "game_source_aio_url";
  public static final String KEY_SOURCE_PIC_HAS_DATA = "game_source_pic_has_data";
  public static final String KEY_SOURCE_PIC_SUBTYPE = "game_source_subtype_pic";
  public static final String KEY_SOURCE_PIC_TXT = "game_source_pic_txt";
  public static final String KEY_SOURCE_PIC_TYPE = "game_source_type_pic";
  public static final String KEY_SOURCE_PIC_URL = "game_source_pic_url";
  public static final int SCENE_AIO_ARK = 1;
  public static final int SCENE_AIO_PIC = 3;
  public static final int SOURCE_TYPE_AIO_LEFT = 0;
  public static final int SOURCE_TYPE_AIO_RIGHT = 1;
  public static final int SOURCE_TYPE_PIC = 2;
  public static final int TYPE_INVALID = 0;
  public static final int VIEW_TAG_KEY_APPID = -4;
  public static final int VIEW_TAG_KEY_SOURCE_TYPE = -5;
  public static final int VIEW_TAG_KEY_SUBTYPE = -3;
  public static final int VIEW_TAG_KEY_TYPE = -2;
  public static final int VIEW_TAG_KEY_URL = -1;
  public static final Map<Object, Integer> sMsgToReportSubType = new HashMap();
  
  public abstract void convertDataForGallery(Object paramObject1, Object paramObject2);
  
  public abstract IGameShareUtil.GameShareGalleryData getGalleryData(Object paramObject);
  
  public abstract int getIntFromMsg(String paramString, int paramInt, MessageRecord paramMessageRecord);
  
  public abstract TextView getSourceInGallery(Context paramContext, RelativeLayout paramRelativeLayout);
  
  public abstract String getValueFromMsg(String paramString1, String paramString2, MessageRecord paramMessageRecord);
  
  public abstract boolean isGameShare(Object paramObject);
  
  public abstract void releaseCache();
  
  public abstract void saveGalleryDataToMsg(AppRuntime paramAppRuntime, Bundle paramBundle);
  
  public abstract void saveValueToMsg(String paramString1, String paramString2, MessageRecord paramMessageRecord);
  
  public abstract void setPicDataToImageData(Object paramObject1, Object paramObject2, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void tryAdjustThumbSize(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract void tryCompactMaxWidth(Object paramObject1, ImageView paramImageView, Object paramObject2);
  
  public abstract void tryHandleAioSource(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean, Resources paramResources, Context paramContext, Object paramObject);
  
  public abstract void updateSourceInGallery(TextView paramTextView, Context paramContext, Object paramObject1, Object paramObject2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IGameShareUtil
 * JD-Core Version:    0.7.0.1
 */