package com.tencent.qqmini.sdk.launcher.model;

public class ShareState
{
  public static final int MINI_APP_INNER_SHARE_BUTTON = 1;
  public static final int MINI_APP_MORE_BUTTON = 0;
  public int fromShareMenuBtn = -1;
  public boolean isGettingScreenShot;
  public boolean isOrientationLandscape;
  public boolean isShareInMiniProcess;
  public int launchFrom = -1;
  public String shareAppid;
  public int shareCallbackId = -1;
  public ShareChatModel shareChatModel;
  public String shareEvent;
  public String shareJson;
  public String shareOpenid;
  public boolean showDebug;
  public boolean showMonitor;
  public boolean showRestart = true;
  public String stagingJsonParams;
  public boolean withShareOthers;
  public boolean withShareQQ;
  public boolean withShareQzone;
  public boolean withShareTicket;
  public boolean withShareWeChatFriend;
  public boolean withShareWeChatMoment;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.model.ShareState
 * JD-Core Version:    0.7.0.1
 */