package com.tencent.mobileqq.vas.qid;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.ui.CoolTextView;
import com.tencent.mobileqq.vas.ui.CoolTextView.CoolBuilder;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

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
    int j = PrettyAccountUtil.a(paramCard);
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    CoolTextView.CoolBuilder localCoolBuilder = new CoolTextView.CoolBuilder();
    localCoolBuilder.jdField_a_of_type_JavaLangString = paramCard.qidColor;
    localCoolBuilder.jdField_b_of_type_JavaLangString = paramCard.qidLogoUrl;
    localCoolBuilder.jdField_c_of_type_JavaLangString = paramCard.qidBgUrl;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramCard.qid))
    {
      localCoolBuilder.jdField_d_of_type_JavaLangString = paramCard.qid;
      if (a(localCoolBuilder.jdField_b_of_type_JavaLangString, localCoolBuilder.jdField_c_of_type_JavaLangString))
      {
        localCoolBuilder.jdField_d_of_type_JavaLangString = paramCard.qid;
        localCoolBuilder.jdField_a_of_type_Int = 21;
        localCoolBuilder.jdField_b_of_type_Int = 18;
        localCoolBuilder.jdField_c_of_type_Int = 18;
        localCoolBuilder.jdField_d_of_type_Int = 11;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("(ID：");
        localStringBuilder.append(paramCard.qid);
        localStringBuilder.append(")");
        localCoolBuilder.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
        localCoolBuilder.jdField_a_of_type_Int = 0;
        int k = 14;
        if (i != 0) {
          j = 18;
        } else {
          j = 14;
        }
        localCoolBuilder.jdField_b_of_type_Int = j;
        j = k;
        if (i != 0) {
          j = 18;
        }
        localCoolBuilder.jdField_c_of_type_Int = j;
        localCoolBuilder.jdField_d_of_type_Int = 12;
      }
    }
    else
    {
      localCoolBuilder.jdField_a_of_type_Int = 24;
      localCoolBuilder.jdField_b_of_type_Int = 12;
      localCoolBuilder.jdField_c_of_type_Int = 12;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID_LOG,qid_cool,");
      localStringBuilder.append(paramCard.uin);
      localStringBuilder.append(",");
      localStringBuilder.append(TextUtils.isEmpty(localCoolBuilder.jdField_d_of_type_JavaLangString));
      localStringBuilder.append(",");
      localStringBuilder.append(TextUtils.isEmpty(localCoolBuilder.jdField_b_of_type_JavaLangString));
      localStringBuilder.append(",");
      localStringBuilder.append(TextUtils.isEmpty(localCoolBuilder.jdField_c_of_type_JavaLangString));
      QLog.d("CoolTextView", 2, localStringBuilder.toString());
    }
    return localCoolBuilder;
  }
  
  private boolean a()
  {
    return QVipQidProcessor.c().a;
  }
  
  private boolean b(ProfileCardInfo paramProfileCardInfo)
  {
    return (paramProfileCardInfo != null) && (paramProfileCardInfo.card != null) && (paramProfileCardInfo.allInOne != null) && (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.uin));
  }
  
  public int a(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo != null)
    {
      if (paramProfileCardInfo.card == null) {
        return 0;
      }
      int i = PrettyAccountUtil.a(paramProfileCardInfo.card);
      int j = 1;
      if (i == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (TextUtils.isEmpty(paramProfileCardInfo.card.qidBgUrl))
      {
        boolean bool = TextUtils.isEmpty(paramProfileCardInfo.card.qidLogoUrl);
        j = 3;
        if (bool) {
          return 3;
        }
        if (i != 0) {
          j = 4;
        }
        return j;
      }
      if (!TextUtils.isEmpty(paramProfileCardInfo.card.qidLogoUrl))
      {
        if (i != 0) {
          j = 2;
        }
        return j;
      }
    }
    return 0;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(ScreenUtil.dip2px(5.0F), 0, ScreenUtil.dip2px(paramFloat1), ScreenUtil.dip2px(paramFloat2));
  }
  
  public void a(AppRuntime paramAppRuntime, ProfileCardInfo paramProfileCardInfo)
  {
    if (paramAppRuntime == null) {
      return;
    }
    if (!b(paramProfileCardInfo))
    {
      setVisibility(8);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("QID_LOG,data_check_state:");
        paramAppRuntime.append(b(paramProfileCardInfo) ^ true);
        QLog.d("CoolTextView", 2, paramAppRuntime.toString());
      }
      return;
    }
    if ((TextUtils.isEmpty(paramProfileCardInfo.card.qid)) && (!a()))
    {
      setVisibility(8);
      return;
    }
    if ((TextUtils.isEmpty(paramProfileCardInfo.card.qid)) && (!paramProfileCardInfo.allInOne.uin.equals(paramAppRuntime.getCurrentAccountUin())))
    {
      setVisibility(8);
      return;
    }
    a(-1);
    setCoolBuilder(a(paramProfileCardInfo.card));
    setVisibility(0);
    VipQidHelper.a("0X800B60C", paramProfileCardInfo);
  }
  
  public boolean a(ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.card != null)) {
      return a(paramProfileCardInfo.card.qidLogoUrl, paramProfileCardInfo.card.qidBgUrl);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qid.QidCoolTextView
 * JD-Core Version:    0.7.0.1
 */