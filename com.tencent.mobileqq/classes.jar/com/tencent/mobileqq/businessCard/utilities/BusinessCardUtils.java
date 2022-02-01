package com.tencent.mobileqq.businessCard.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.oidb.cmd0x43c.Oidb_0x43c.CardInfo;

public class BusinessCardUtils
{
  public static BusinessCard a(AppInterface paramAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    BusinessCardManager localBusinessCardManager = (BusinessCardManager)paramAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
    if (paramProfileCardInfo.allInOne.pa == 0)
    {
      paramAppInterface = localBusinessCardManager.c();
    }
    else if (paramProfileCardInfo.card != null)
    {
      paramAppInterface = a(paramProfileCardInfo.card.bCardInfo);
      if ((paramProfileCardInfo.card.bCardInfo != null) && (!TextUtils.isEmpty(paramAppInterface.cardId))) {
        localBusinessCardManager.a(paramProfileCardInfo.allInOne.uin, paramAppInterface);
      } else {
        paramAppInterface = localBusinessCardManager.c(paramProfileCardInfo.allInOne.uin);
      }
    }
    else
    {
      paramAppInterface = null;
    }
    paramProfileCardInfo = paramAppInterface;
    if (paramAppInterface == null) {
      paramProfileCardInfo = new BusinessCard();
    }
    return paramProfileCardInfo;
  }
  
  public static BusinessCard a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (BusinessCardManager)paramQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.c();
    } else {
      paramQQAppInterface = null;
    }
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      localObject = new BusinessCard();
    }
    return localObject;
  }
  
  public static BusinessCard a(byte[] paramArrayOfByte)
  {
    Oidb_0x43c.CardInfo localCardInfo = new Oidb_0x43c.CardInfo();
    BusinessCard localBusinessCard = new BusinessCard();
    if (paramArrayOfByte != null) {
      try
      {
        localCardInfo.mergeFrom(paramArrayOfByte);
        BusinessCardServlet.a(localBusinessCard, localCardInfo);
        return localBusinessCard;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("BusinessCardUtils", 1, "getBusinessCardInfo fail.", paramArrayOfByte);
      }
    }
    return localBusinessCard;
  }
  
  public static void a(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 1000;
      localURLDrawableOptions.mRequestHeight = 600;
      ThreadManager.post(new BusinessCardUtils.2(URLDrawable.getDrawable(paramString, localURLDrawableOptions)), 8, null, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", String.valueOf(paramInt));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(paramString, "ocr_user_edit_action_report", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramURLImageView == null) {
        return;
      }
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = paramURLImageView.getContext().getResources().getDrawable(2130846381);
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
        paramURLImageView.setURLDrawableDownListener(new BusinessCardUtils.1(paramURLImageView));
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramURLImageView = new StringBuilder();
          paramURLImageView.append("error ");
          paramURLImageView.append(paramString.toString());
          QLog.d("BusinessCard", 2, paramURLImageView.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils
 * JD-Core Version:    0.7.0.1
 */