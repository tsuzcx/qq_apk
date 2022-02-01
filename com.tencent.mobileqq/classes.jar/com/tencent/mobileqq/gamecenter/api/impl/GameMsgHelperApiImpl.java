package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Dialog;
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
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.ui.ProfileGuideDialog;
import com.tencent.mobileqq.gamecenter.utils.GameMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

public class GameMsgHelperApiImpl
  implements IGameMsgHelperApi
{
  public boolean checkMesssageIsValid(MessageRecord paramMessageRecord)
  {
    return GameMsgUtil.a(paramMessageRecord);
  }
  
  public Dialog createProfileGuideDailg(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    return new ProfileGuideDialog(paramContext).a(paramString);
  }
  
  public void delGameSession(String paramString)
  {
    GameMsgUtil.d(paramString);
  }
  
  public void enterGameMsgChatPie(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    GameMsgUtil.a(paramContext, paramString1, paramString2, paramString3, paramInt);
  }
  
  public void enterGameMsgChatPie(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    GameMsgUtil.a(paramAppInterface, paramContext, paramString);
  }
  
  public void enterGameMsgChatPie(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    GameMsgUtil.a(paramAppInterface, paramContext, paramString, paramInt);
  }
  
  public boolean getAIOGameEntryShown(String paramString)
  {
    return GameMsgUtil.c(paramString);
  }
  
  public Drawable getGameMsgAvatarDrawable(AppInterface paramAppInterface, String paramString)
  {
    return GameMsgUtil.b(paramAppInterface, paramString);
  }
  
  public Bitmap getGameRoleBitmap(Message paramMessage, AppInterface paramAppInterface)
  {
    return GameMsgUtil.a(paramMessage, paramAppInterface);
  }
  
  public String getGameRoleNickName(MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    return GameMsgUtil.a(paramMessageRecord, paramAppInterface);
  }
  
  public String getGameRoleNickName(String paramString, AppInterface paramAppInterface)
  {
    return GameMsgUtil.a(paramString, paramAppInterface);
  }
  
  public boolean getGameSessionShown(String paramString)
  {
    return GameMsgUtil.a(paramString);
  }
  
  public URLDrawable getGameUsrDrawable(Context paramContext, AppInterface paramAppInterface, String paramString)
  {
    return GameMsgUtil.a(paramContext, paramAppInterface, paramString);
  }
  
  public Intent getIntentFromMsg(Context paramContext, Message paramMessage, AppInterface paramAppInterface)
  {
    return ((ITempApi)QRoute.api(ITempApi.class)).getIntentFromMsg(paramContext, paramMessage, paramAppInterface);
  }
  
  public MessageRecord getLastGameMsg(AppRuntime paramAppRuntime, String paramString)
  {
    return GameMsgUtil.a(paramAppRuntime, paramString);
  }
  
  public long getLastGameSessionClicked(String paramString)
  {
    return GameMsgUtil.b(paramString);
  }
  
  public long getLastTopReqMsgTime(AppInterface paramAppInterface)
  {
    return GameMsgUtil.c(paramAppInterface);
  }
  
  public CharSequence getMsgDescp(AppInterface paramAppInterface, RecentBaseData paramRecentBaseData, CharSequence paramCharSequence)
  {
    return GameMsgUtil.a(paramAppInterface, paramRecentBaseData, paramCharSequence);
  }
  
  public String getMsgDescp(AppInterface paramAppInterface, MessageRecord paramMessageRecord, CharSequence paramCharSequence)
  {
    return GameMsgUtil.a(paramAppInterface, paramMessageRecord, paramCharSequence);
  }
  
  public Drawable getRecentGameMsgDrawable(AppInterface paramAppInterface, String paramString)
  {
    return GameMsgUtil.a(paramAppInterface, paramString);
  }
  
  public String getTimeString(long paramLong)
  {
    return GameMsgUtil.b(paramLong);
  }
  
  public String getUnreadStr(int paramInt)
  {
    return GameMsgUtil.a(paramInt);
  }
  
  public boolean handleGameMsgRecentUserSummery(AppInterface paramAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary)
  {
    return GameMsgUtil.a(paramAppInterface, paramMessage, paramInt, paramMsgSummary);
  }
  
  public boolean isIgnoreGameMsg(AppInterface paramAppInterface, int paramInt)
  {
    return GameMsgUtil.a(paramAppInterface, paramInt);
  }
  
  public boolean isPubAccountReceiveMsg(AppInterface paramAppInterface)
  {
    return GameMsgUtil.a(paramAppInterface);
  }
  
  public boolean isShowMsg(AppInterface paramAppInterface, String paramString)
  {
    return GameMsgUtil.c(paramAppInterface, paramString);
  }
  
  public boolean isToday(long paramLong)
  {
    return GameMsgUtil.a(paramLong);
  }
  
  public void openGameMsgSessionPage(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString)
  {
    GameMsgUtil.a(paramContext, paramGameCenterSessionInfo, paramString);
  }
  
  public void openGameMsgSessionPageFromToolProcess(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo, String paramString1, String paramString2)
  {
    GameMsgUtil.a(paramContext, paramGameCenterSessionInfo, paramString1, paramString2);
  }
  
  public void openGameMsgSettingPage(Context paramContext, String paramString)
  {
    GameMsgUtil.a(paramContext, paramString);
  }
  
  public void report(int paramInt1, int paramInt2)
  {
    GameMsgUtil.a(paramInt1, paramInt2);
  }
  
  public void report(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    GameMsgUtil.a(paramAppInterface, paramString, paramInt1, paramInt2);
  }
  
  public void reportClickItemInGameMsgBox883(AppInterface paramAppInterface, String paramString)
  {
    GameMsgUtil.d(paramAppInterface, paramString);
  }
  
  public void reportClickMsgBoxEntry883(AppInterface paramAppInterface)
  {
    GameMsgUtil.d(paramAppInterface);
  }
  
  public void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    GameMsgUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
  }
  
  public void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    GameMsgUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
  }
  
  public void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    GameMsgUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public void reportForGameMsg(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    GameMsgUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13, paramString14);
  }
  
  public void reportForGameMsg850(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    GameMsgUtil.b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10);
  }
  
  public void reportForGameMsg865WithTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    GameMsgUtil.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11);
  }
  
  public void reportForGameMsg865WithTianJi(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    GameMsgUtil.b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public void reportGameMsgBoxExplosure883(AppInterface paramAppInterface, int paramInt, Message paramMessage)
  {
    GameMsgUtil.a(paramAppInterface, paramInt, paramMessage);
  }
  
  public void setAIOGameEntryShown(String paramString, boolean paramBoolean)
  {
    GameMsgUtil.b(paramString, paramBoolean);
  }
  
  public void setGameSessionShown(String paramString, boolean paramBoolean)
  {
    GameMsgUtil.a(paramString, paramBoolean);
  }
  
  public void setLastCleanReqMsgTime(String paramString, long paramLong)
  {
    GameMsgUtil.a(paramString, paramLong);
  }
  
  public void setLastGameSessionClicked(String paramString, long paramLong)
  {
    GameMsgUtil.b(paramString, paramLong);
  }
  
  public void startGame(Context paramContext, GameDetailInfo paramGameDetailInfo)
  {
    GameMsgUtil.a(paramContext, paramGameDetailInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgHelperApiImpl
 * JD-Core Version:    0.7.0.1
 */