package com.tencent.qqmini.sdk.launcher.model;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.util.HashMap;

public class ShareState
{
  public static final String KEY_TAP_INDEX_FAVORITE = "tapIndexFavorite";
  public static final String KEY_TAP_INDEX_QQ = "tapIndexQQ";
  public static final String KEY_TAP_INDEX_QZONE = "tapIndexQZONE";
  public static final String KEY_TAP_INDEX_WX = "tapIndexWX";
  public static final String KEY_TAP_INDEX_WX_MOMENTS = "tapIndexWXMoments";
  public static final int MINI_APP_INNER_SHARE_BUTTON = 1;
  public static final int MINI_APP_MORE_BUTTON = 0;
  public int fromShareMenuBtn = -1;
  public boolean isGettingScreenShot;
  public boolean isOrientationLandscape;
  public boolean isShareInMiniProcess;
  public int launchFrom = -1;
  public RequestEvent requestEvent;
  public String shareAppid;
  public int shareCallbackId = -1;
  public ShareChatModel shareChatModel;
  public String shareEvent;
  public String shareJson;
  public String shareOpenid;
  public boolean showDebug;
  public boolean showFavorites = true;
  public boolean showMonitor;
  public boolean showRestart = true;
  public String stagingJsonParams;
  public HashMap<String, Integer> tapIndexMap;
  public boolean withShareOthers = false;
  public boolean withShareQQ = false;
  public boolean withShareQzone = false;
  public boolean withShareTicket = false;
  public boolean withShareWeChatFriend = false;
  public boolean withShareWeChatMoment = false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ShareState
 * JD-Core Version:    0.7.0.1
 */