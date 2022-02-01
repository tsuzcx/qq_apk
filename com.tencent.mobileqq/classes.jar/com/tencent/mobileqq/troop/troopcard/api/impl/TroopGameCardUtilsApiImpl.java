package com.tencent.mobileqq.troop.troopcard.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopGameCardUtilsApiImpl
  implements ITroopGameCardUtilsApi
{
  public static final String TAG = "TroopGameCardUtil";
  
  public void ansyCheckShowMsgGameGradeLevel(String paramString1, String paramString2, ITroopGameCardUtilsApi.ICheckShowMsgGameGradeLevelBack paramICheckShowMsgGameGradeLevelBack)
  {
    if (paramICheckShowMsgGameGradeLevelBack == null) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (SimpleUIUtil.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel SimpleUI");
        }
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel StudyMode");
        }
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
      if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isGrayTroopForTroopGameCard(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel configData is invalid");
        }
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localAppRuntime == null)
      {
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
      Object localObject = (ITroopInfoService)localAppRuntime.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel manager is null");
        }
        paramICheckShowMsgGameGradeLevelBack.a(false);
        return;
      }
      localObject = ((ITroopInfoService)localObject).findTroopInfo(paramString1);
      if ((localObject != null) && (((TroopInfo)localObject).isTroopGameCardEnabled()) && (!((TroopInfo)localObject).isHomeworkTroop()))
      {
        ((ITroopMemberInfoService)localAppRuntime.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMemberInfo(paramString1, paramString2, new TroopGameCardUtilsApiImpl.1(this, paramICheckShowMsgGameGradeLevelBack));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("checkoutMsgShowGameGradeLevel troopInfo is");
        if (localObject == null) {
          paramString1 = "null";
        } else {
          paramString1 = ((TroopInfo)localObject).toString();
        }
        paramString2.append(paramString1);
        QLog.d("TroopGameCardUtil", 2, paramString2.toString());
      }
      paramICheckShowMsgGameGradeLevelBack.a(false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardUtil", 2, "checkoutMsgShowGameGradeLevel invalid args");
    }
    paramICheckShowMsgGameGradeLevelBack.a(false);
  }
  
  @Nullable
  public String getGameGradeIconPathById(int paramInt)
  {
    Object localObject2 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("game_grade_");
    localObject2 = localStringBuilder.toString();
    switch (paramInt / 100000)
    {
    default: 
      break;
    case 8: 
      if (paramInt % 100000 / 10000 >= 6)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("8");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("7");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      break;
    case 7: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("6");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 6: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("5");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 5: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("4");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 4: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("3");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("2");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 2: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("1");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".png");
      return ((StringBuilder)localObject2).toString();
    }
    return localObject1;
  }
  
  @Nullable
  public String getGameGradeNumberIconPathById(int paramInt)
  {
    int i = paramInt / 100000;
    String str = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("game_grade_number_");
    str = localStringBuilder.toString();
    switch (i)
    {
    default: 
      str = null;
      break;
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("6_");
      str = localStringBuilder.toString();
      break;
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("5_");
      str = localStringBuilder.toString();
      break;
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("4_");
      str = localStringBuilder.toString();
      break;
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("3_");
      str = localStringBuilder.toString();
      break;
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("2_");
      str = localStringBuilder.toString();
      break;
    case 2: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("1_");
      str = localStringBuilder.toString();
    }
    if (!TextUtils.isEmpty(str))
    {
      switch (paramInt % 100000 / 10000)
      {
      default: 
        return null;
      case 9: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("1.png");
        return localStringBuilder.toString();
      case 8: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("2.png");
        return localStringBuilder.toString();
      case 7: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("3.png");
        return localStringBuilder.toString();
      case 6: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("4.png");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("5.png");
      return localStringBuilder.toString();
    }
    return str;
  }
  
  @Nullable
  public String getGameGradeStarImagePathById(int paramInt)
  {
    int i = paramInt / 100000;
    Object localObject1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("game_grade_star");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
      break;
    case 6: 
    case 7: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_5_");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 4: 
    case 5: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_4_");
      localObject1 = ((StringBuilder)localObject1).toString();
      break;
    case 2: 
    case 3: 
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_3_");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (i != 8)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(String.valueOf(paramInt % 10000));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(".png");
      return ((StringBuilder)localObject1).toString();
    }
    return null;
  }
  
  @Nullable
  public String getGameSkilledLevelIconPath(int paramInt)
  {
    Object localObject1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("game_hero_skill_level_");
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    localObject1 = null;
    if (bool) {
      return null;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject2);
              ((StringBuilder)localObject1).append("5");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("4");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append("3");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("2");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("1");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".png");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  @Nullable
  public String getGradeDescById(int paramInt)
  {
    String str1 = getMajorGradeTagById(paramInt);
    if (!TextUtils.isEmpty(str1))
    {
      if (paramInt / 100000 >= 8)
      {
        if (paramInt >= 860050) {
          return HardCodeUtil.a(2131693311);
        }
        return HardCodeUtil.a(2131693308);
      }
      String str2 = getSecondaryGradeById(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(HardCodeUtil.a(2131693317));
      return localStringBuilder.toString();
    }
    return null;
  }
  
  @Nullable
  public Bitmap getImageBitmap(String paramString)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
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
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("getBitmap error ");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append(localThrowable.getMessage());
        QLog.i("TroopGameCardUtil", 1, localStringBuilder2.toString());
        return null;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getImageBitmap fail: ");
      localStringBuilder1.append(paramString);
      QLog.d("TroopGameCardUtil", 2, localStringBuilder1.toString());
    }
    return null;
  }
  
  public String getMajorGradeTagById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return null;
    case 8: 
      return HardCodeUtil.a(2131693313);
    case 7: 
      return HardCodeUtil.a(2131693316);
    case 6: 
      return HardCodeUtil.a(2131693310);
    case 5: 
      return HardCodeUtil.a(2131693314);
    case 4: 
      return HardCodeUtil.a(2131693312);
    case 3: 
      return HardCodeUtil.a(2131693315);
    }
    return HardCodeUtil.a(2131693309);
  }
  
  public String getMemberGameCardBgImagePath(boolean paramBoolean)
  {
    String str = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getTroopGameCardResDownloadPath();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("member_game_card_bg_night.png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("member_game_card_bg.png");
    return localStringBuilder.toString();
  }
  
  public String getOccupationTypeText(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return HardCodeUtil.a(2131693320);
    case 5: 
      return HardCodeUtil.a(2131693322);
    case 4: 
      return HardCodeUtil.a(2131693321);
    case 3: 
      return HardCodeUtil.a(2131693319);
    case 2: 
      return HardCodeUtil.a(2131693324);
    }
    return HardCodeUtil.a(2131693323);
  }
  
  public String getSecondaryGradeById(int paramInt)
  {
    if (paramInt / 100000 >= 8) {
      return null;
    }
    switch (paramInt % 100000 / 10000)
    {
    default: 
      return null;
    case 9: 
      return HardCodeUtil.a(2131693326);
    case 8: 
      return HardCodeUtil.a(2131693327);
    case 7: 
      return HardCodeUtil.a(2131693328);
    case 6: 
      return HardCodeUtil.a(2131693329);
    }
    return HardCodeUtil.a(2131693330);
  }
  
  public String getSelectedEndColorById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#79F5EE";
    case 8: 
      return "#FFDEB1";
    case 7: 
      return "#F7DAED";
    case 6: 
      return "#B6AAFF";
    case 5: 
      return "#7AEEFF";
    case 4: 
      return "#FFEF90";
    case 3: 
      return "#B8D4FE";
    }
    return "#79F5EE";
  }
  
  public String getSelectedStartColorById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#BAFAF6";
    case 8: 
      return "#FFEED7";
    case 7: 
      return "#FAECF5";
    case 6: 
      return "#DAD4FF";
    case 5: 
      return "#BBF5FF";
    case 4: 
      return "#FFF6C7";
    case 3: 
      return "#DBEAFF";
    }
    return "#BAFAF6";
  }
  
  public String getSelectedTextColorById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 8: 
      return "#FF8F65";
    case 7: 
      return "#CCB8C6";
    case 6: 
      return "#8E71EE";
    case 5: 
      return "#4FAAFA";
    case 4: 
      return "#FFBA6C";
    case 3: 
      return "#A1C6FE";
    }
    return "#00D6E7";
  }
  
  public String getUnselectedEndColorById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#00D6E7";
    case 8: 
      return "#FF8F65";
    case 7: 
      return "#CCB8C6";
    case 6: 
      return "#8E71EE";
    case 5: 
      return "#4FAAFA";
    case 4: 
      return "#FFBA6C";
    case 3: 
      return "#A1C6FE";
    }
    return "#00D6E7";
  }
  
  public String getUnselectedStartColorById(int paramInt)
  {
    switch (paramInt / 100000)
    {
    default: 
      return "#66E6F0";
    case 8: 
      return "#FFBBA2";
    case 7: 
      return "#E0D4DC";
    case 6: 
      return "#BBA9F4";
    case 5: 
      return "#94CBFB";
    case 4: 
      return "#FFD5A6";
    case 3: 
      return "#C5DCFE";
    }
    return "#66E6F0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.impl.TroopGameCardUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */