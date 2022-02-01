package com.tencent.mobileqq.profilecard.vas.misc;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileTemplateException;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VasProfileTemplateCheckUtils
{
  private static final String TAG = "ProfileTemplateCheckUtils";
  
  public static void checkCurrentUseTemplate(ProfileCardInfo paramProfileCardInfo)
  {
    long l5 = ProfileCardTemplate.jdField_a_of_type_Long;
    long l4 = 0L;
    Object localObject2 = null;
    long l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate curStyleId=%s", new Object[] { Long.valueOf(l2) }));
    }
    Object localObject1;
    long l3;
    long l1;
    if (SimpleUIUtil.a())
    {
      localObject1 = localObject2;
      l3 = l4;
      l1 = l5;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTemplateCheckUtils", 2, "checkCurrentUseTemplate simple mode");
        l1 = l5;
        l3 = l4;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate useStyleId=%s useTemplateVersion=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) }));
      }
      paramProfileCardInfo.jdField_a_of_type_Long = l1;
      paramProfileCardInfo.b = l3;
      paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = ((ProfileCardTemplate)localObject1);
      return;
      if ((l2 == ProfileCardTemplate.b) || (l2 == ProfileCardTemplate.c) || (l2 == ProfileCardTemplate.d))
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkGameTemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == ProfileCardTemplate.e)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkPhotoTemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == ProfileCardTemplate.f)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkTagTemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == ProfileCardTemplate.g)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkSimpleTemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == ProfileCardTemplate.h)
      {
        l1 = ProfileCardTemplate.jdField_a_of_type_Long;
        localObject1 = localObject2;
        l3 = l4;
      }
      else if ((l2 == ProfileCardTemplate.i) || (l2 == ProfileCardTemplate.j))
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkWZRYTemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == ProfileCardTemplate.k)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (checkQVipV5TemplateValid(paramProfileCardInfo))
        {
          localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
          l1 = l2;
          l3 = l4;
        }
      }
      else
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (ProfileCardTemplate.a(l2))
        {
          localObject1 = localObject2;
          l3 = l4;
          l1 = l5;
          if (VasProfileTemplatePreloadHelper.INSTANCE.initDiyData(paramProfileCardInfo))
          {
            l3 = ProfileCardTemplate.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            l1 = l2;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private static boolean checkGameTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkGameTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("gameHeadInfoBackground", "color");
    localHashMap.put("gameNickNameColor", "color");
    localHashMap.put("gameAddressColor", "color");
    localHashMap.put("gameSignColor", "color");
    localHashMap.put("gamePlayNowColor", "color");
    localHashMap.put("gameMoreColor", "color");
    localHashMap.put("gameMoreGameDrawableRight", "drawable");
    localHashMap.put("gamePlayTitleColor", "color");
    localHashMap.put("gameIconBorder", "drawable");
    return checkTemplateValidWithResult(paramProfileCardInfo, localHashMap);
  }
  
  private static boolean checkPhotoTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkPhotoTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    return checkTemplateValidWithResult(paramProfileCardInfo, localHashMap);
  }
  
  private static boolean checkQVipV5TemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkQVipV5TemplateValid");
    }
    return checkTemplateValidWithResult(paramProfileCardInfo, new HashMap());
  }
  
  private static boolean checkShopTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkShopTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("shoppingUserInfoBackground", "color");
    localHashMap.put("shoppingInfoMaskBackground", "color");
    localHashMap.put("shoppingShopnameText", "color");
    localHashMap.put("shoppingSignColor", "color");
    return checkTemplateValidWithResult(paramProfileCardInfo, localHashMap);
  }
  
  private static boolean checkSimpleTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkSimpleTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    return checkTemplateValidWithResult(paramProfileCardInfo, localHashMap);
  }
  
  private static boolean checkTagTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkTagTemplateValid");
    }
    return checkTemplateValidWithResult(paramProfileCardInfo, new HashMap());
  }
  
  private static void checkTemplateValid(ProfileCardInfo paramProfileCardInfo, HashMap<String, String> paramHashMap)
  {
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.size() <= 0)) {
      throw new ProfileTemplateException("template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label376:
    label379:
    for (;;)
    {
      Object localObject1;
      String str1;
      Object localObject2;
      int i;
      String str2;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str1 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramProfileCardInfo.get(str1);
        String[] arrayOfString = ((String)localObject1).split(",");
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label376;
        }
        str2 = arrayOfString[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          if ((str2.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label379;
        }
        throw new ProfileTemplateException("template attr " + str1 + " type is not " + (String)localObject1);
        if ((str2.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          i = 1;
        }
        else if ((str2.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          i = 1;
        }
        else
        {
          i += 1;
          break;
          return;
          i = 0;
        }
      }
    }
  }
  
  private static boolean checkTemplateValidWithResult(ProfileCardInfo paramProfileCardInfo, HashMap<String, String> paramHashMap)
  {
    try
    {
      checkTemplateValid(paramProfileCardInfo, paramHashMap);
      bool = true;
    }
    catch (Exception paramProfileCardInfo)
    {
      for (;;)
      {
        QLog.e("ProfileTemplateCheckUtils", 1, "checkShopTemplateValid fail.", paramProfileCardInfo);
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkTemplateValidWithResult valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private static boolean checkWZRYTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkWZRYTemplateValid");
    }
    return checkTemplateValidWithResult(paramProfileCardInfo, new HashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplateCheckUtils
 * JD-Core Version:    0.7.0.1
 */