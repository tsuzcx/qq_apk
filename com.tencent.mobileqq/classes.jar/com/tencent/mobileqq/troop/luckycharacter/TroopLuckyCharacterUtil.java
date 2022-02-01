package com.tencent.mobileqq.troop.luckycharacter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterService;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class TroopLuckyCharacterUtil
{
  public static String a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    if ((paramQQAppInterface != null) && (paramTroopInfo != null) && (paramTroopInfo.mTroopInfoExtObj != null) && (!TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if (!a(paramQQAppInterface, paramTroopInfo)) {
        return "";
      }
      long l = paramTroopInfo.mTroopInfoExtObj.luckyWordId;
      if (l == 0L) {
        return "";
      }
      int i = paramTroopInfo.mTroopInfoExtObj.lightCharNum;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("https://gxh.vip.qq.com/xydata/groupluckyword/item/");
      paramQQAppInterface.append(l);
      paramQQAppInterface.append("/tinypic-");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(".png");
      return paramQQAppInterface.toString();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LuckyCharacterUtil", 2, "getLuckyCharacterPicUrl args err");
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (a(str) != paramBoolean)
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("self_troop_lucky_character_switch");
      localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
      localEditor.apply();
      ((ITroopLuckyCharacterService)paramQQAppInterface.getRuntimeService(ITroopLuckyCharacterService.class, "")).updateSelfSettingSwitch(paramBoolean);
      ((ITroopListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 & 0x8000) == 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt1 & 0x8000) == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    return paramInt2 != paramInt1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    if (!((ITroopLuckyCharacterService)paramQQAppInterface.getRuntimeService(ITroopLuckyCharacterService.class, "")).isSupportLuckyCharacter(paramTroopInfo)) {
      return false;
    }
    int i;
    if ((paramTroopInfo.groupFlagExt4 & 0x8000) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    return i != 0;
  }
  
  public static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {
      return false;
    }
    paramObject = ((MessageForUniteGrayTip)paramObject).getExtInfoFromExtStr("uint64_busi_id");
    try
    {
      boolean bool = TroopLuckyCharacterConstant.a.contains(Long.valueOf(paramObject));
      return bool;
    }
    catch (NumberFormatException paramObject)
    {
      paramObject.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("self_troop_lucky_character_switch");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil
 * JD-Core Version:    0.7.0.1
 */