package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGameMsgHelperApi
  extends QRouteApi
{
  public static final String GAME_BUDDY_APP_DEFALUT_NAME = "\"玩伴\"小程序";
  public static final String HIPPY_SCHEMA_URL = "mqqapi://hippy/open?bundleName%3DQQGameCenter%26url%3Dhttps%253A%252F%252Fstatic.gamecenter.qq.com%252Fxgame-hippy%252Fdist%252Fhome%252Fandroid%252Fmain.js%253Fpage%253Dmsg%2526isPredrawWhenClosed%253Dtrue%2526isAnimated%253Dtrue%2526isTrasparent%253Dfalse%2526isStatusBarDarkFont%253Dtrue%2526version%253D1%2526src_type%253Dweb%2526adtag%253DlockScreen";
  public static final String HIPPY_URL = "https://speed.gamecenter.qq.com/pushgame/v1/home-spa/msg?_wv=18950115&_wwv=393&page=msg&adtag=";
  public static final String PREFIX = "[游戏好友]";
  public static final String SESSION_SETTING_URL = "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
  public static final String SESSION_URL = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
  public static final String SP_KEY_AIO_GAME_ENTRY_SHOWN = "sp_aio_game_entry_shown";
  public static final String SP_KEY_CLEAN_TIME = "sp_top_clean_time";
  public static final String SP_KEY_GAME_SESSION_SHOWN = "sp_game_session_shown";
  public static final String SP_KEY_LAST_GAME_SESSION_CLICKED = "sp_last_game_session_clicked";
  public static final String SP_KEY_TOP_TIME = "sp_top_last_time";
  public static final int[] SYS_EMOTION_ORDER = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64 };
  public static final int TYPE_FROM_CLICK_ENTER_AIO = 1;
  public static final int TYPE_FROM_LS_ARRIVAL = 10006;
  public static final int TYPE_FROM_LS_CLICK = 10004;
  public static final int TYPE_FROM_LS_EXPOSURE = 10005;
  public static final int TYPE_FROM_MSG_TAB_ARRIVAL = 10003;
  public static final int TYPE_FROM_MSG_TAB_CLICK = 10001;
  public static final int TYPE_FROM_MSG_TAB_EXPOSURE = 10002;
  public static final String[] sEmojiList = { "🕹", "🎮", "🔊", "🔉", "🔈", "📢", "✉", "📨", "📧", "📩", "💌", "📪", "📫", "📬", "📮", "🎈", "📍" };
  
  public abstract boolean checkMesssageIsValid(MessageRecord paramMessageRecord);
  
  public abstract void delGameSession(String paramString);
  
  public abstract void enterGameMsgChatPie(Context paramContext, String paramString1, String paramString2, String paramString3);
  
  public abstract void enterGameMsgChatPie(AppInterface paramAppInterface, Context paramContext, String paramString);
  
  public abstract boolean getAIOGameEntryShown(String paramString);
  
  public abstract Bitmap getGameRoleBitmap(Message paramMessage, AppInterface paramAppInterface);
  
  public abstract String getGameRoleNickName(MessageRecord paramMessageRecord, AppInterface paramAppInterface);
  
  public abstract String getGameRoleNickName(String paramString, AppInterface paramAppInterface);
  
  public abstract boolean getGameSessionShown(String paramString);
  
  public abstract URLDrawable getGameUsrDrawable(Context paramContext, AppInterface paramAppInterface, String paramString);
  
  public abstract Intent getIntentFromMsg(Context paramContext, Message paramMessage, AppInterface paramAppInterface);
  
  public abstract MessageRecord getLastGameMsg(AppInterface paramAppInterface, String paramString);
  
  public abstract long getLastGameSessionClicked(String paramString);
  
  public abstract long getLastTopReqMsgTime(AppInterface paramAppInterface);
  
  public abstract CharSequence getMsgDescp(AppInterface paramAppInterface, RecentBaseData paramRecentBaseData, CharSequence paramCharSequence);
  
  public abstract String getMsgDescp(AppInterface paramAppInterface, MessageRecord paramMessageRecord, CharSequence paramCharSequence);
  
  public abstract Drawable getRecentGameMsgDrawable(AppInterface paramAppInterface, String paramString);
  
  public abstract String getTimeString(long paramLong);
  
  public abstract String getUnreadStr(int paramInt);
  
  public abstract boolean handleGameMsgRecentUserSummery(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary);
  
  public abstract boolean isIgnoreGameMsg(AppInterface paramAppInterface, int paramInt);
  
  public abstract boolean isPubAccountReceiveMsg(AppInterface paramAppInterface);
  
  public abstract boolean isShowMsg(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isToday(long paramLong);
  
  public abstract void openGameMsgSessionPage(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString);
  
  public abstract void openGameMsgSessionPageFromToolProcess(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString1, String paramString2);
  
  public abstract void openGameMsgSettingPage(Context paramContext, String paramString);
  
  public abstract void report(int paramInt1, int paramInt2);
  
  public abstract void report(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2);
  
  public abstract void reportClickItemInMsgBox(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString);
  
  public abstract void reportClickMsgBox(AppInterface paramAppInterface);
  
  public abstract void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10);
  
  public abstract void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12);
  
  public abstract void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13);
  
  public abstract void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14);
  
  public abstract void reportForGameMsg850(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10);
  
  public abstract void reportForGameMsg865WithTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11);
  
  public abstract void reportForGameMsg865WithTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13);
  
  public abstract void reportGameMsgExplosureInBox(AppInterface paramAppInterface, int paramInt, String paramString);
  
  public abstract void reportMsgBoxExposure(AppInterface paramAppInterface, Object paramObject);
  
  public abstract void setAIOGameEntryShown(String paramString, boolean paramBoolean);
  
  public abstract void setGameSessionShown(String paramString, boolean paramBoolean);
  
  public abstract void setLastCleanReqMsgTime(String paramString, long paramLong);
  
  public abstract void setLastGameSessionClicked(String paramString, long paramLong);
  
  public abstract void startGame(Context paramContext, GameDetailInfo paramGameDetailInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi
 * JD-Core Version:    0.7.0.1
 */