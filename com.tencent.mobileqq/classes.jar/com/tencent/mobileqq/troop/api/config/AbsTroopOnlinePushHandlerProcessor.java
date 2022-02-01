package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;

public class AbsTroopOnlinePushHandlerProcessor
{
  protected void a(@NonNull AppInterface paramAppInterface, TroopEnterEffectData paramTroopEnterEffectData) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, String paramString) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString1, @NonNull String paramString2, TroopInfo paramTroopInfo) {}
  
  protected void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull TroopInfo paramTroopInfo, @NonNull ArrayList<String> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.AbsTroopOnlinePushHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */