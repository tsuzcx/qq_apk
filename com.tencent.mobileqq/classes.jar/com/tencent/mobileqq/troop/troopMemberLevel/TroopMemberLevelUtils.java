package com.tencent.mobileqq.troop.troopMemberLevel;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.troophonor.VasTroopHonorRichHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopMemberLevelUtils
{
  public static int a(int paramInt)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a(paramInt);
    }
    return 0;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "data error");
      }
    }
    for (;;)
    {
      return 0;
      try
      {
        troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
        localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
        if (localGroupUserCardHonor.level.has())
        {
          int i = localGroupUserCardHonor.level.get();
          return i;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberLevelUtils", 2, "parseRspToNewRealLevel exception");
        }
        paramArrayOfByte.printStackTrace();
      }
    }
    return 0;
  }
  
  public static TroopMemberRankItem a(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, byte paramByte)
  {
    boolean bool2 = false;
    TroopMemberRankItem localTroopMemberRankItem2 = null;
    TroopMemberRankItem localTroopMemberRankItem1 = localTroopMemberRankItem2;
    if (paramTroopInfo != null)
    {
      localTroopMemberRankItem1 = localTroopMemberRankItem2;
      if (!TextUtils.isEmpty(paramString1))
      {
        if (paramInt1 != 0) {
          break label36;
        }
        localTroopMemberRankItem1 = localTroopMemberRankItem2;
      }
    }
    return localTroopMemberRankItem1;
    label36:
    localTroopMemberRankItem2 = new TroopMemberRankItem();
    boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
    boolean bool4 = paramTroopInfo.isTroopAdmin(paramString1);
    if (paramTroopInfo.cNewGroupRankUserFlag == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramTroopInfo.cGroupRankUserFlag == 1) {
        bool2 = true;
      }
      localTroopMemberRankItem2.jdField_b_of_type_Boolean = bool2;
      localTroopMemberRankItem2.jdField_a_of_type_Boolean = bool1;
      if ((!bool1) && (!bool2) && (!bool3))
      {
        localTroopMemberRankItem1 = localTroopMemberRankItem2;
        if (!bool4) {
          break;
        }
      }
      paramString1 = new VasTroopHonorRichHandler();
      if (!paramTroopInfo.isQidianPrivateTroop()) {
        break label164;
      }
      a(localTroopMemberRankItem2, bool4, bool3);
      paramString1.a(localTroopMemberRankItem2.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem2);
      return localTroopMemberRankItem2;
    }
    label164:
    if (paramTroopInfo.isHomeworkTroop())
    {
      a(localTroopMemberRankItem2, paramInt2);
      paramString1.a(localTroopMemberRankItem2.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem2);
      return localTroopMemberRankItem2;
    }
    if (SimpleUIUtil.a())
    {
      a(localTroopMemberRankItem2, bool4, bool3);
      paramString1.a(localTroopMemberRankItem2.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem2);
      return localTroopMemberRankItem2;
    }
    localTroopMemberRankItem2.jdField_a_of_type_Int = paramInt2;
    localTroopMemberRankItem2.jdField_b_of_type_Boolean = bool2;
    localTroopMemberRankItem2.jdField_a_of_type_ArrayOfInt = a(paramInt2);
    localTroopMemberRankItem2.jdField_a_of_type_Boolean = bool1;
    localTroopMemberRankItem2.jdField_b_of_type_ArrayOfInt = a();
    localTroopMemberRankItem2.jdField_b_of_type_Int = paramInt1;
    paramInt1 = a(paramInt1);
    if ((paramInt2 < 10000) && (paramInt2 > 0))
    {
      a(localTroopMemberRankItem2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      if (!bool3) {
        break label355;
      }
      paramInt2 = 300;
      localTroopMemberRankItem2.jdField_b_of_type_Boolean = true;
      localTroopMemberRankItem2.jdField_a_of_type_ArrayOfInt = a(300);
    }
    for (;;)
    {
      paramString1.a(paramInt2, paramByte, localTroopMemberRankItem2);
      return localTroopMemberRankItem2;
      a(localTroopMemberRankItem2, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      break;
      label355:
      if (bool4)
      {
        paramInt2 = 301;
        localTroopMemberRankItem2.jdField_b_of_type_Boolean = true;
        localTroopMemberRankItem2.jdField_a_of_type_ArrayOfInt = a(301);
      }
      else if (!TextUtils.isEmpty(paramString2))
      {
        paramInt2 = 302;
      }
    }
  }
  
  public static TroopMemberRankItem a(TroopInfo paramTroopInfo, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramTroopInfo == null) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    int i = 302;
    TroopMemberRankItem localTroopMemberRankItem = new TroopMemberRankItem();
    localTroopMemberRankItem.jdField_a_of_type_Boolean = false;
    localTroopMemberRankItem.jdField_b_of_type_Int = 0;
    localTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
    localTroopMemberRankItem.jdField_b_of_type_Boolean = true;
    boolean bool1 = paramTroopInfo.isTroopOwner(paramString1);
    boolean bool2 = paramTroopInfo.isTroopAdmin(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      localTroopMemberRankItem.jdField_a_of_type_JavaLangString = paramString2;
      localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(302);
      if (!bool1) {
        break label174;
      }
      i = 300;
      localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(300);
    }
    for (;;)
    {
      new VasTroopHonorRichHandler().a(i, paramByte, localTroopMemberRankItem);
      return localTroopMemberRankItem;
      if (bool1)
      {
        localTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
        break;
      }
      if (bool2)
      {
        localTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
        break;
      }
      localTroopMemberRankItem.jdField_a_of_type_JavaLangString = "";
      break;
      label174:
      if (bool2)
      {
        i = 301;
        localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(301);
      }
    }
  }
  
  public static String a()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a();
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    Object localObject = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localObject != null) {}
    for (localObject = ((TroopMemberLevelMapConfig)localObject).a(paramInt);; localObject = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "getRankTitleByLevelInConfig: level : " + paramInt + ",rankTitle : " + (String)localObject);
      }
      return localObject;
    }
  }
  
  private static void a(TroopMemberRankItem paramTroopMemberRankItem, int paramInt)
  {
    if (paramInt == 332)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 332;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715585);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(332);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
    }
    while (paramInt != 333) {
      return;
    }
    paramTroopMemberRankItem.jdField_a_of_type_Int = 333;
    paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715590);
    paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(333);
    paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
    paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
    paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
  }
  
  private static void a(TroopMemberRankItem paramTroopMemberRankItem, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramTroopInfo == null) || (paramTroopMemberRankItem == null)) {}
    do
    {
      return;
      if (paramInt2 == 302)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = paramString;
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
        return;
        if (paramInt2 == 300)
        {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramInt2 == 301)
        {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
          }
          if (TextUtils.isEmpty(paramTroopMemberRankItem.jdField_a_of_type_JavaLangString)) {
            paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = a(paramInt1);
          }
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
  }
  
  private static void a(TroopMemberRankItem paramTroopMemberRankItem, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if ((paramTroopMemberRankItem == null) || (paramTroopInfo == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = paramString;
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(302);
      }
      while ((paramBoolean1) && (!paramBoolean3))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
        return;
        if (paramBoolean1)
        {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(300);
        }
        else if (paramBoolean2)
        {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(301);
        }
        else
        {
          paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
          if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
            paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
          }
          if (TextUtils.isEmpty(paramTroopMemberRankItem.jdField_a_of_type_JavaLangString)) {
            paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = a(paramInt);
          }
          paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(315);
        }
      }
    } while ((!paramBoolean2) || (paramBoolean3));
    paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
  }
  
  private static void a(TroopMemberRankItem paramTroopMemberRankItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 300;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(300);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
    }
    while (!paramBoolean1) {
      return;
    }
    paramTroopMemberRankItem.jdField_a_of_type_Int = 301;
    paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
    paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = a(301);
    paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
    paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
    paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if ((localTroopMemberLevelMapConfig != null) && (localTroopMemberLevelMapConfig.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "hasNewGroupMemberLevelJumpUrl= true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelUtils", 2, "hasNewGroupMemberLevelJumpUrl= false");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if ((localTroopMemberLevelMapConfig != null) && (localTroopMemberLevelMapConfig.a(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "isNewRealLevelGrayTroop troopUin = " + paramString + ", isGrayTroop = " + bool);
      }
      return bool;
    }
  }
  
  public static int[] a()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a();
    }
    return null;
  }
  
  public static int[] a(int paramInt)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a(paramInt);
    }
    return null;
  }
  
  public static int b(int paramInt)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {}
    for (paramInt = localTroopMemberLevelMapConfig.b(paramInt);; paramInt = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtils", 2, "convertOldLevelToNewLevel : newLevel" + paramInt);
      }
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils
 * JD-Core Version:    0.7.0.1
 */