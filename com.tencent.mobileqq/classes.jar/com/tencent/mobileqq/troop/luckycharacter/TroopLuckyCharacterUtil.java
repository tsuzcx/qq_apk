package com.tencent.mobileqq.troop.luckycharacter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

public class TroopLuckyCharacterUtil
{
  public static final HashSet<Long> a = new TroopLuckyCharacterUtil.1();
  
  public static String a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    if ((paramQQAppInterface == null) || (paramTroopInfo == null) || (paramTroopInfo.mTroopInfoExtObj == null) || (TextUtils.isEmpty(paramTroopInfo.troopuin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LuckyCharacterUtil", 2, "getLuckyCharacterPicUrl args err");
      }
      return "";
    }
    if (!a(paramQQAppInterface, paramTroopInfo)) {
      return "";
    }
    long l = paramTroopInfo.mTroopInfoExtObj.luckyWordId;
    if (l == 0L) {
      return "";
    }
    int i = paramTroopInfo.mTroopInfoExtObj.lightCharNum;
    return "https://gxh.vip.qq.com/xydata/groupluckyword/item/" + l + "/tinypic-" + i + ".png";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (a(str) != paramBoolean)
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(str, 0).edit();
      localEditor.putBoolean(str + "self_troop_lucky_character_switch", paramBoolean);
      localEditor.apply();
      ((TroopLuckyCharacterManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_LUCKY_CHARACTER_MANAGER)).a(paramBoolean);
      ((TroopListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).notifyUI(TroopNotificationConstants.aC, true, null);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 & 0x8000) == 0)
    {
      paramInt2 = 1;
      if ((paramInt1 & 0x8000) != 0) {
        break label30;
      }
    }
    label30:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt2 == paramInt1) {
        break label35;
      }
      return true;
      paramInt2 = 0;
      break;
    }
    label35:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    if (!((TroopLuckyCharacterManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_LUCKY_CHARACTER_MANAGER)).a(paramTroopInfo)) {
      return false;
    }
    if ((paramTroopInfo.groupFlagExt4 & 0x8000) == 0) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {
      return false;
    }
    paramObject = ((MessageForUniteGrayTip)paramObject).getExtInfoFromExtStr("uint64_busi_id");
    try
    {
      boolean bool = a.contains(Long.valueOf(paramObject));
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
    return BaseApplication.getContext().getSharedPreferences(paramString, 0).getBoolean(paramString + "self_troop_lucky_character_switch", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterUtil
 * JD-Core Version:    0.7.0.1
 */