package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class TroopGameCardUtil
{
  @Nullable
  public static Bitmap a(String paramString)
  {
    if (FileUtils.b(paramString))
    {
      Object localObject = GlobalImageCache.a.get(paramString);
      if ((localObject != null) && ((localObject instanceof Bitmap))) {
        return (Bitmap)localObject;
      }
      try
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inScaled = false;
        localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        GlobalImageCache.a.put(paramString, localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("TroopGameCardUtil", 1, "getBitmap error " + paramString + localThrowable.getMessage());
        return null;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardUtil", 2, "getImageBitmap fail: " + paramString);
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return null;
    case 2: 
      return HardCodeUtil.a(2131693354);
    case 3: 
      return HardCodeUtil.a(2131693360);
    case 4: 
      return HardCodeUtil.a(2131693357);
    case 5: 
      return HardCodeUtil.a(2131693359);
    case 6: 
      return HardCodeUtil.a(2131693355);
    case 7: 
      return HardCodeUtil.a(2131693361);
    }
    return HardCodeUtil.a(2131693358);
  }
  
  public static String a(boolean paramBoolean)
  {
    String str = TroopGameCardResDownloadManager.a();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (paramBoolean) {
      return str + "member_game_card_bg_night.png";
    }
    return str + "member_game_card_bg.png";
  }
  
  public static void a(String paramString1, String paramString2, TroopGameCardUtil.ICheckShowMsgGameGradeLevelBack paramICheckShowMsgGameGradeLevelBack)
  {
    if (paramICheckShowMsgGameGradeLevelBack == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel invalid args");
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    if (SimpleUIUtil.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel SimpleUI");
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    if (StudyModeManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel StudyMode");
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    Object localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
    if ((localObject == null) || (!((TroopGameCardConfig)localObject).a(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel configData is invalid");
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null)
    {
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    TroopManager localTroopManager = (TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel manager is null");
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    localObject = localTroopManager.b(paramString1);
    if ((localObject == null) || (!((TroopInfo)localObject).isTroopGameCardEnabled()) || (((TroopInfo)localObject).isHomeworkTroop()))
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("checkoutMsgShowGameGradeLevel troopInfo is");
        if (localObject != null) {
          break label278;
        }
      }
      label278:
      for (paramString1 = "null";; paramString1 = ((TroopInfo)localObject).toString())
      {
        QLog.d("TroopGameCardUtil", 2, paramString1);
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
    }
    localTroopManager.a(paramString1, paramString2, new TroopGameCardUtil.1(paramICheckShowMsgGameGradeLevelBack));
  }
  
  @Nullable
  public static String b(int paramInt)
  {
    if (paramInt / 100000 >= 8) {
      return null;
    }
    switch (paramInt % 100000 / 10000)
    {
    default: 
      return null;
    case 5: 
      return HardCodeUtil.a(2131693375);
    case 9: 
      return HardCodeUtil.a(2131693371);
    case 8: 
      return HardCodeUtil.a(2131693372);
    case 7: 
      return HardCodeUtil.a(2131693373);
    }
    return HardCodeUtil.a(2131693374);
  }
  
  @Nullable
  public static String c(int paramInt)
  {
    String str1 = a(paramInt);
    if (!TextUtils.isEmpty(str1))
    {
      if (paramInt / 100000 >= 8)
      {
        if (paramInt >= 860050) {
          return HardCodeUtil.a(2131693356);
        }
        return HardCodeUtil.a(2131693353);
      }
      String str2 = b(paramInt);
      return str1 + str2 + HardCodeUtil.a(2131693362);
    }
    return null;
  }
  
  @Nullable
  public static String d(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str = TroopGameCardResDownloadManager.a();
    if (TextUtils.isEmpty(str)) {
      return localObject2;
    }
    localObject2 = str + "game_grade_";
    switch (paramInt / 100000)
    {
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return (String)localObject1 + ".png";
      localObject1 = (String)localObject2 + "1";
      continue;
      localObject1 = (String)localObject2 + "2";
      continue;
      localObject1 = (String)localObject2 + "3";
      continue;
      localObject1 = (String)localObject2 + "4";
      continue;
      localObject1 = (String)localObject2 + "5";
      continue;
      localObject1 = (String)localObject2 + "6";
      continue;
      if (paramInt % 100000 / 10000 >= 6) {
        localObject1 = (String)localObject2 + "8";
      } else {
        localObject1 = (String)localObject2 + "7";
      }
    }
  }
  
  @Nullable
  public static String e(int paramInt)
  {
    int i = paramInt / 100000;
    Object localObject1 = TroopGameCardResDownloadManager.a();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = (String)localObject1 + "game_grade_star";
    localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (i != 8) {
        localObject2 = (String)localObject1 + String.valueOf(paramInt % 10000);
      }
      return (String)localObject2 + ".png";
      localObject1 = (String)localObject2 + "_3_";
      continue;
      localObject1 = (String)localObject2 + "_4_";
      continue;
      localObject1 = (String)localObject2 + "_5_";
    }
  }
  
  @Nullable
  public static String f(int paramInt)
  {
    int i = paramInt / 100000;
    String str = TroopGameCardResDownloadManager.a();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    str = str + "game_grade_number_";
    switch (i)
    {
    default: 
      str = null;
    }
    while (!TextUtils.isEmpty(str)) {
      switch (paramInt % 100000 / 10000)
      {
      default: 
        return null;
      case 5: 
        return str + "5.png";
        str = str + "1_";
        continue;
        str = str + "2_";
        continue;
        str = str + "3_";
        continue;
        str = str + "4_";
        continue;
        str = str + "5_";
        continue;
        str = str + "6_";
        break;
      case 9: 
        return str + "1.png";
      case 8: 
        return str + "2.png";
      case 7: 
        return str + "3.png";
      case 6: 
        return str + "4.png";
      }
    }
    return str;
  }
  
  @Nullable
  public static String g(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    String str = TroopGameCardResDownloadManager.a();
    str = str + "game_hero_skill_level_";
    if (TextUtils.isEmpty(str)) {
      return localObject2;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      return (String)localObject1 + ".png";
      localObject1 = str + "1";
      continue;
      localObject1 = str + "2";
      continue;
      localObject1 = str + "3";
      continue;
      localObject1 = str + "4";
      continue;
      localObject1 = str + "5";
    }
  }
  
  public static String h(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return HardCodeUtil.a(2131693368);
    case 2: 
      return HardCodeUtil.a(2131693369);
    case 3: 
      return HardCodeUtil.a(2131693364);
    case 4: 
      return HardCodeUtil.a(2131693366);
    case 5: 
      return HardCodeUtil.a(2131693367);
    }
    return HardCodeUtil.a(2131693365);
  }
  
  public static String i(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#66E6F0";
    case 2: 
      return "#66E6F0";
    case 3: 
      return "#C5DCFE";
    case 4: 
      return "#FFD5A6";
    case 5: 
      return "#94CBFB";
    case 6: 
      return "#BBA9F4";
    case 7: 
      return "#E0D4DC";
    }
    return "#FFBBA2";
  }
  
  public static String j(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 2: 
      return "#00D6E7";
    case 3: 
      return "#A1C6FE";
    case 4: 
      return "#FFBA6C";
    case 5: 
      return "#4FAAFA";
    case 6: 
      return "#8E71EE";
    case 7: 
      return "#CCB8C6";
    }
    return "#FF8F65";
  }
  
  public static String k(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#BAFAF6";
    case 2: 
      return "#BAFAF6";
    case 3: 
      return "#DBEAFF";
    case 4: 
      return "#FFF6C7";
    case 5: 
      return "#BBF5FF";
    case 6: 
      return "#DAD4FF";
    case 7: 
      return "#FAECF5";
    }
    return "#FFEED7";
  }
  
  public static String l(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#79F5EE";
    case 2: 
      return "#79F5EE";
    case 3: 
      return "#B8D4FE";
    case 4: 
      return "#FFEF90";
    case 5: 
      return "#7AEEFF";
    case 6: 
      return "#B6AAFF";
    case 7: 
      return "#F7DAED";
    }
    return "#FFDEB1";
  }
  
  public static String m(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 2: 
      return "#00D6E7";
    case 3: 
      return "#A1C6FE";
    case 4: 
      return "#FFBA6C";
    case 5: 
      return "#4FAAFA";
    case 6: 
      return "#8E71EE";
    case 7: 
      return "#CCB8C6";
    }
    return "#FF8F65";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.TroopGameCardUtil
 * JD-Core Version:    0.7.0.1
 */