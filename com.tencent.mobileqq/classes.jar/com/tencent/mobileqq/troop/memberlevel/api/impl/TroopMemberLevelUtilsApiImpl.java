package com.tencent.mobileqq.troop.memberlevel.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlevel.TroopMemberLevelMapConfig;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class TroopMemberLevelUtilsApiImpl
  implements ITroopMemberLevelUtilsApi
{
  public static final String TAG = "TroopMemberLevelUtilsApiImpl";
  
  private void getDefaultRankItem(TroopMemberRankItem paramTroopMemberRankItem, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString)
  {
    if (paramTroopMemberRankItem != null)
    {
      if (paramTroopInfo == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = paramString;
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(302);
      }
      else if (paramBoolean1)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(300);
      }
      else if (paramBoolean2)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(301);
      }
      else
      {
        paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
        if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt)));
        }
        if (TextUtils.isEmpty(paramTroopMemberRankItem.jdField_a_of_type_JavaLangString)) {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTitleByLevelInConfig(paramInt);
        }
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(315);
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
        return;
      }
      if ((paramBoolean2) && (!paramBoolean3)) {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
      }
    }
  }
  
  private void getHomeWorkTroopShowRank(TroopMemberRankItem paramTroopMemberRankItem, int paramInt)
  {
    if (paramInt == 332)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 332;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715509);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(332);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
      return;
    }
    if (paramInt == 333)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 333;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715514);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(333);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void getOnlyShowOwnerAndAdminRank(TroopMemberRankItem paramTroopMemberRankItem, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 300;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(300);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
      return;
    }
    if (paramBoolean1)
    {
      paramTroopMemberRankItem.jdField_a_of_type_Int = 301;
      paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
      paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(301);
      paramTroopMemberRankItem.jdField_b_of_type_Boolean = true;
      paramTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = null;
      paramTroopMemberRankItem.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void getSelfSelectRankItem(TroopMemberRankItem paramTroopMemberRankItem, TroopInfo paramTroopInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, String paramString)
  {
    if (paramTroopInfo != null)
    {
      if (paramTroopMemberRankItem == null) {
        return;
      }
      if (paramInt2 == 302)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = paramString;
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(302);
      }
      else if (paramInt2 == 300)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(300);
      }
      else if (paramInt2 == 301)
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(301);
      }
      else
      {
        paramTroopInfo = paramTroopInfo.getNewTroopLevelMap();
        if ((paramTroopInfo != null) && (paramTroopInfo.size() > 0)) {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((String)paramTroopInfo.get(Integer.valueOf(paramInt1)));
        }
        if (TextUtils.isEmpty(paramTroopMemberRankItem.jdField_a_of_type_JavaLangString)) {
          paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTitleByLevelInConfig(paramInt1);
        }
        paramTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(315);
      }
      if ((paramBoolean1) && (!paramBoolean3))
      {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
        return;
      }
      if ((paramBoolean2) && (!paramBoolean3)) {
        paramTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
      }
    }
  }
  
  public int convertOldLevelToNewLevel(int paramInt)
  {
    Object localObject = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localObject != null) {
      paramInt = ((TroopMemberLevelMapConfig)localObject).b(paramInt);
    } else {
      paramInt = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("convertOldLevelToNewLevel : newLevel");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopMemberLevelUtilsApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return paramInt;
  }
  
  public int convertRealLevelToMapLevel(int paramInt)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a(paramInt);
    }
    return 0;
  }
  
  public String getNewGroupMemberLevelJumpUrl()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a();
    }
    return "";
  }
  
  public int[] getOnlyLevelColor()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a();
    }
    return null;
  }
  
  public int[] getRankGradientColorByRankId(int paramInt)
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localTroopMemberLevelMapConfig != null) {
      return localTroopMemberLevelMapConfig.a(paramInt);
    }
    return null;
  }
  
  public String getRankTitleByLevelInConfig(int paramInt)
  {
    Object localObject = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if (localObject != null) {
      localObject = ((TroopMemberLevelMapConfig)localObject).a(paramInt);
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRankTitleByLevelInConfig: level : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",rankTitle : ");
      localStringBuilder.append((String)localObject);
      QLog.d("TroopMemberLevelUtilsApiImpl", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public TroopMemberRankItem getTroopMemberRankItem(TroopInfo paramTroopInfo, String paramString1, int paramInt1, int paramInt2, String paramString2, byte paramByte)
  {
    if ((paramTroopInfo != null) && (!TextUtils.isEmpty(paramString1)) && (paramInt1 != 0))
    {
      TroopMemberRankItem localTroopMemberRankItem = new TroopMemberRankItem();
      boolean bool3 = paramTroopInfo.isTroopOwner(paramString1);
      boolean bool4 = paramTroopInfo.isTroopAdmin(paramString1);
      boolean bool1;
      if (paramTroopInfo.cNewGroupRankUserFlag == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramTroopInfo.cGroupRankUserFlag == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      localTroopMemberRankItem.jdField_b_of_type_Boolean = bool2;
      localTroopMemberRankItem.jdField_a_of_type_Boolean = bool1;
      if ((!bool1) && (!bool2) && (!bool3) && (!bool4)) {
        return localTroopMemberRankItem;
      }
      paramString1 = (ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class);
      if (paramTroopInfo.isQidianPrivateTroop())
      {
        getOnlyShowOwnerAndAdminRank(localTroopMemberRankItem, bool4, bool3);
        paramString1.handleRichLevel(localTroopMemberRankItem.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem);
        return localTroopMemberRankItem;
      }
      if (paramTroopInfo.isHomeworkTroop())
      {
        getHomeWorkTroopShowRank(localTroopMemberRankItem, paramInt2);
        paramString1.handleRichLevel(localTroopMemberRankItem.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem);
        return localTroopMemberRankItem;
      }
      if (SimpleUIUtil.a())
      {
        getOnlyShowOwnerAndAdminRank(localTroopMemberRankItem, bool4, bool3);
        paramString1.handleRichLevel(localTroopMemberRankItem.jdField_a_of_type_Int, paramByte, localTroopMemberRankItem);
        return localTroopMemberRankItem;
      }
      localTroopMemberRankItem.jdField_a_of_type_Int = paramInt2;
      localTroopMemberRankItem.jdField_b_of_type_Boolean = bool2;
      localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramInt2);
      localTroopMemberRankItem.jdField_a_of_type_Boolean = bool1;
      localTroopMemberRankItem.jdField_b_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getOnlyLevelColor();
      localTroopMemberRankItem.jdField_b_of_type_Int = paramInt1;
      paramInt1 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertRealLevelToMapLevel(paramInt1);
      if ((paramInt2 < 10000) && (paramInt2 > 0)) {
        getSelfSelectRankItem(localTroopMemberRankItem, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramInt2, paramString2);
      } else {
        getDefaultRankItem(localTroopMemberRankItem, paramTroopInfo, bool3, bool4, bool2, paramInt1, paramString2);
      }
      if (bool3)
      {
        paramInt1 = 300;
        localTroopMemberRankItem.jdField_b_of_type_Boolean = true;
        localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(300);
      }
      for (;;)
      {
        break;
        if (bool4)
        {
          paramInt1 = 301;
          localTroopMemberRankItem.jdField_b_of_type_Boolean = true;
          localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(301);
        }
        else if (!TextUtils.isEmpty(paramString2))
        {
          paramInt1 = 302;
        }
        else
        {
          paramInt1 = paramInt2;
        }
      }
      paramString1.handleRichLevel(paramInt1, paramByte, localTroopMemberRankItem);
      return localTroopMemberRankItem;
    }
    return null;
  }
  
  public TroopMemberRankItem getTroopMemberRankItem_Unique(TroopInfo paramTroopInfo, String paramString1, String paramString2, byte paramByte)
  {
    if (paramTroopInfo != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
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
        localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(302);
      }
      else if (bool1)
      {
        localTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
      }
      else if (bool2)
      {
        localTroopMemberRankItem.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
      }
      else
      {
        localTroopMemberRankItem.jdField_a_of_type_JavaLangString = "";
      }
      if (bool1)
      {
        i = 300;
        localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(300);
      }
      else if (bool2)
      {
        i = 301;
        localTroopMemberRankItem.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(301);
      }
      ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).handleRichLevel(i, paramByte, localTroopMemberRankItem);
      return localTroopMemberRankItem;
    }
    return null;
  }
  
  public boolean hasNewGroupMemberLevelJumpUrl()
  {
    TroopMemberLevelMapConfig localTroopMemberLevelMapConfig = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    if ((localTroopMemberLevelMapConfig != null) && (localTroopMemberLevelMapConfig.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberLevelUtilsApiImpl", 2, "hasNewGroupMemberLevelJumpUrl= true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelUtilsApiImpl", 2, "hasNewGroupMemberLevelJumpUrl= false");
    }
    return false;
  }
  
  public boolean isNewRealLevelGrayTroop(String paramString)
  {
    Object localObject = (TroopMemberLevelMapConfig)QConfigManager.a().a(659);
    boolean bool;
    if ((localObject != null) && (((TroopMemberLevelMapConfig)localObject).a(paramString))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNewRealLevelGrayTroop troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isGrayTroop = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopMemberLevelUtilsApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlevel.api.impl.TroopMemberLevelUtilsApiImpl
 * JD-Core Version:    0.7.0.1
 */