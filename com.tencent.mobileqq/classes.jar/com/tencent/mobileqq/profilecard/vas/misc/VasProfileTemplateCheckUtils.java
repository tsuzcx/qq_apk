package com.tencent.mobileqq.profilecard.vas.misc;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileTemplateException;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
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
  
  private static boolean attrIsNotEmpty(String paramString1, Object paramObject, String paramString2)
  {
    return (paramObject != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  public static void checkCurrentUseTemplate(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    long l5 = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
    long l4 = paramProfileCardInfo.card.lCurrentStyleId;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkCurrentUseTemplate curStyleId=");
    ((StringBuilder)localObject1).append(l4);
    QLog.d("ProfileTemplateCheckUtils", 2, ((StringBuilder)localObject1).toString());
    boolean bool = SimpleUIUtil.e();
    long l2 = 0L;
    Object localObject3 = null;
    Object localObject2 = null;
    long l1;
    long l3;
    if (bool)
    {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkCurrentUseTemplate simple mode");
      l1 = l5;
      l3 = l2;
      localObject1 = localObject3;
    }
    else
    {
      if (checkTemplateValid(l4, paramProfileCardInfo)) {}
      for (paramIComponentCenter = paramProfileCardInfo.currentTemplate;; paramIComponentCenter = localObject2)
      {
        l1 = l4;
        l3 = l2;
        localObject1 = paramIComponentCenter;
        break;
        if (l4 == ProfileCardTemplate.PROFILE_CARD_STYLE_SHOPPING)
        {
          l1 = ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID;
          l3 = l2;
          localObject1 = localObject3;
          break;
        }
        l1 = l5;
        l3 = l2;
        localObject1 = localObject3;
        if (!ProfileTemplateApi.isDiyTemplateStyleID(l4)) {
          break;
        }
        l1 = l5;
        l3 = l2;
        localObject1 = localObject3;
        if (!VasProfileTemplatePreloadHelper.INSTANCE.initDiyData(paramProfileCardInfo)) {
          break;
        }
        l2 = ProfileTemplateApi.getTemplateManager(paramIComponentCenter).getDiyTemplateVersion(paramProfileCardInfo.card);
      }
    }
    paramIComponentCenter = new StringBuilder();
    paramIComponentCenter.append("checkCurrentUseTemplate useStyleId=");
    paramIComponentCenter.append(l1);
    paramIComponentCenter.append(" useTemplateVersion=");
    paramIComponentCenter.append(l3);
    QLog.d("ProfileTemplateCheckUtils", 2, paramIComponentCenter.toString());
    paramProfileCardInfo.curUseStyleId = l1;
    paramProfileCardInfo.curUseTemplateVersion = l3;
    paramProfileCardInfo.currentTemplate = ((ProfileCardTemplate)localObject1);
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
    paramProfileCardInfo = paramProfileCardInfo.currentTemplate.templateAttr;
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.size() > 0))
    {
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
      Iterator localIterator = paramHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        paramHashMap = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        if (!checkVaildAttr(paramHashMap, paramProfileCardInfo.get(paramHashMap), ((String)localObject).split(","), false))
        {
          paramProfileCardInfo = new StringBuilder();
          paramProfileCardInfo.append("template attr ");
          paramProfileCardInfo.append(paramHashMap);
          paramProfileCardInfo.append(" type is not ");
          paramProfileCardInfo.append((String)localObject);
          throw new ProfileTemplateException(paramProfileCardInfo.toString());
        }
      }
      return;
    }
    paramProfileCardInfo = new ProfileTemplateException("template templateAttr is null");
    for (;;)
    {
      throw paramProfileCardInfo;
    }
  }
  
  private static boolean checkTemplateValid(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return (isValidGameTemplate(paramLong, paramProfileCardInfo)) || (isValidPhotoTemplate(paramLong, paramProfileCardInfo)) || (isValidTagTemplate(paramLong, paramProfileCardInfo)) || (isValidSimpleTemplate(paramLong, paramProfileCardInfo)) || (isValidWZRYTemplate(paramLong, paramProfileCardInfo)) || (isValidQVipV5Template(paramLong, paramProfileCardInfo));
  }
  
  private static boolean checkTemplateValidWithResult(ProfileCardInfo paramProfileCardInfo, HashMap<String, String> paramHashMap)
  {
    boolean bool;
    try
    {
      checkTemplateValid(paramProfileCardInfo, paramHashMap);
      bool = true;
    }
    catch (Exception paramProfileCardInfo)
    {
      QLog.e("ProfileTemplateCheckUtils", 1, "checkShopTemplateValid fail.", paramProfileCardInfo);
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkTemplateValidWithResult valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private static boolean checkVaildAttr(String paramString, Object paramObject, String[] paramArrayOfString, boolean paramBoolean)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if ((attrIsNotEmpty(paramString, paramObject, str)) && ((isAttrValidColor(paramObject, str)) || (isAttrValidDrawable(paramObject, str)) || (isAttrValidString(paramObject, str)))) {
        return true;
      }
      i += 1;
    }
    return paramBoolean;
  }
  
  private static boolean checkWZRYTemplateValid(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkWZRYTemplateValid");
    }
    return checkTemplateValidWithResult(paramProfileCardInfo, new HashMap());
  }
  
  private static boolean isAttrValidColor(Object paramObject, String paramString)
  {
    return (paramString.equalsIgnoreCase("color")) && (((paramObject instanceof ColorStateList)) || ((paramObject instanceof String)));
  }
  
  private static boolean isAttrValidDrawable(Object paramObject, String paramString)
  {
    return (paramString.equalsIgnoreCase("drawable")) && ((paramObject instanceof Drawable));
  }
  
  private static boolean isAttrValidString(Object paramObject, String paramString)
  {
    return (paramString.equalsIgnoreCase("string")) && ((paramObject instanceof String)) && (!TextUtils.isEmpty((String)paramObject));
  }
  
  private static boolean isValidGameTemplate(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return ((paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_FRESH) || (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_JANYUE) || (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_GAME)) && (checkGameTemplateValid(paramProfileCardInfo));
  }
  
  private static boolean isValidPhotoTemplate(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_SOCIAL) && (checkPhotoTemplateValid(paramProfileCardInfo));
  }
  
  private static boolean isValidQVipV5Template(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800) && (checkQVipV5TemplateValid(paramProfileCardInfo));
  }
  
  private static boolean isValidSimpleTemplate(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE) && (checkSimpleTemplateValid(paramProfileCardInfo));
  }
  
  private static boolean isValidTagTemplate(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) && (checkTagTemplateValid(paramProfileCardInfo));
  }
  
  private static boolean isValidWZRYTemplate(long paramLong, ProfileCardInfo paramProfileCardInfo)
  {
    return ((paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_STATIC) || (paramLong == ProfileCardTemplate.PROFILE_CARD_STYLE_WZRY_DYNAMIC)) && (checkWZRYTemplateValid(paramProfileCardInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplateCheckUtils
 * JD-Core Version:    0.7.0.1
 */