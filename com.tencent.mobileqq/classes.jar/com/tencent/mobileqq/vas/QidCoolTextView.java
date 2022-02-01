package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.qphone.base.util.QLog;

public class QidCoolTextView
  extends CoolTextView
{
  public QidCoolTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QidCoolTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private CoolTextView.CoolBuilder a(Card paramCard)
  {
    int i = 1;
    int k = 18;
    CoolTextView.CoolBuilder localCoolBuilder;
    if (PrettyAccountUtil.a(paramCard) == 1)
    {
      localCoolBuilder = new CoolTextView.CoolBuilder();
      localCoolBuilder.jdField_a_of_type_JavaLangString = paramCard.qidColor;
      localCoolBuilder.jdField_b_of_type_JavaLangString = paramCard.qidLogoUrl;
      localCoolBuilder.jdField_c_of_type_JavaLangString = paramCard.qidBgUrl;
      if (TextUtils.isEmpty(paramCard.qid)) {
        break label299;
      }
      localCoolBuilder.jdField_d_of_type_JavaLangString = paramCard.qid;
      if (!a(localCoolBuilder.jdField_b_of_type_JavaLangString, localCoolBuilder.jdField_c_of_type_JavaLangString)) {
        break label213;
      }
      localCoolBuilder.jdField_d_of_type_JavaLangString = paramCard.qid;
      localCoolBuilder.jdField_a_of_type_Int = 21;
      localCoolBuilder.jdField_b_of_type_Int = 18;
      localCoolBuilder.jdField_c_of_type_Int = 18;
      localCoolBuilder.jdField_d_of_type_Int = 11;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CoolTextView", 2, "QID_LOG,qid_cool," + paramCard.uin + "," + TextUtils.isEmpty(localCoolBuilder.jdField_d_of_type_JavaLangString) + "," + TextUtils.isEmpty(localCoolBuilder.jdField_b_of_type_JavaLangString) + "," + TextUtils.isEmpty(localCoolBuilder.jdField_c_of_type_JavaLangString));
      }
      return localCoolBuilder;
      i = 0;
      break;
      label213:
      localCoolBuilder.jdField_d_of_type_JavaLangString = ("(ID：" + paramCard.qid + ")");
      localCoolBuilder.jdField_a_of_type_Int = 0;
      int j;
      if (i != 0)
      {
        j = 18;
        label258:
        localCoolBuilder.jdField_b_of_type_Int = j;
        if (i == 0) {
          break label293;
        }
      }
      label293:
      for (i = k;; i = 14)
      {
        localCoolBuilder.jdField_c_of_type_Int = i;
        localCoolBuilder.jdField_d_of_type_Int = 12;
        break;
        j = 14;
        break label258;
      }
      label299:
      localCoolBuilder.jdField_a_of_type_Int = 24;
      localCoolBuilder.jdField_b_of_type_Int = 12;
      localCoolBuilder.jdField_c_of_type_Int = 12;
    }
  }
  
  private boolean a()
  {
    return QVipQidProcessor.c().a;
  }
  
  private boolean b(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = true;
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      bool = false;
    }
    return bool;
  }
  
  public int a(ProfileCardInfo paramProfileCardInfo)
  {
    int j = 1;
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {}
    int i;
    do
    {
      return 0;
      if (PrettyAccountUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard) == 1) {
        i = 1;
      }
      while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qidBgUrl)) {
        if (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl))
        {
          return 3;
          i = 0;
        }
        else
        {
          if (i != 0) {}
          for (i = 4;; i = 3) {
            return i;
          }
        }
      }
    } while (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl));
    if (i != 0) {
      j = 2;
    }
    return j;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(ScreenUtil.dip2px(5.0F), 0, ScreenUtil.dip2px(paramFloat1), ScreenUtil.dip2px(paramFloat2));
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (b(paramProfileCardInfo)) {
        break;
      }
      setVisibility(8);
    } while (!QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("QID_LOG,data_check_state:");
    if (!b(paramProfileCardInfo)) {
      bool = true;
    }
    QLog.d("CoolTextView", 2, bool);
    return;
    if ((TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qid)) && (!a()))
    {
      setVisibility(8);
      return;
    }
    if ((TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qid)) && (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      setVisibility(8);
      return;
    }
    a(-1);
    setCoolBuilder(a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard));
    setVisibility(0);
    VipQidHelper.a("0X800B60C", paramProfileCardInfo);
  }
  
  public boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return false;
    }
    return a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.qidBgUrl);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QidCoolTextView
 * JD-Core Version:    0.7.0.1
 */