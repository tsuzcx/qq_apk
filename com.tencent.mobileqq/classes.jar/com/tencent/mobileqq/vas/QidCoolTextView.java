package com.tencent.mobileqq.vas;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import arlb;
import arlc;
import azrb;
import bhmw;
import bhnz;
import bhqa;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
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
  
  private bhmw a(Card paramCard)
  {
    int i = 1;
    int k = 18;
    bhmw localbhmw;
    if (bhnz.a(paramCard) == 1)
    {
      localbhmw = new bhmw();
      localbhmw.jdField_a_of_type_JavaLangString = paramCard.qidColor;
      localbhmw.jdField_b_of_type_JavaLangString = paramCard.qidLogoUrl;
      localbhmw.jdField_c_of_type_JavaLangString = paramCard.qidBgUrl;
      if (TextUtils.isEmpty(paramCard.qid)) {
        break label299;
      }
      localbhmw.jdField_d_of_type_JavaLangString = paramCard.qid;
      if (!a(localbhmw.jdField_b_of_type_JavaLangString, localbhmw.jdField_c_of_type_JavaLangString)) {
        break label213;
      }
      localbhmw.jdField_d_of_type_JavaLangString = paramCard.qid;
      localbhmw.jdField_a_of_type_Int = 21;
      localbhmw.jdField_b_of_type_Int = 18;
      localbhmw.jdField_c_of_type_Int = 18;
      localbhmw.jdField_d_of_type_Int = 11;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CoolTextView", 2, "QID_LOG,qid_cool," + paramCard.uin + "," + TextUtils.isEmpty(localbhmw.jdField_d_of_type_JavaLangString) + "," + TextUtils.isEmpty(localbhmw.jdField_b_of_type_JavaLangString) + "," + TextUtils.isEmpty(localbhmw.jdField_c_of_type_JavaLangString));
      }
      return localbhmw;
      i = 0;
      break;
      label213:
      localbhmw.jdField_d_of_type_JavaLangString = ("(ID：" + paramCard.qid + ")");
      localbhmw.jdField_a_of_type_Int = 0;
      int j;
      if (i != 0)
      {
        j = 18;
        label258:
        localbhmw.jdField_b_of_type_Int = j;
        if (i == 0) {
          break label293;
        }
      }
      label293:
      for (i = k;; i = 14)
      {
        localbhmw.jdField_c_of_type_Int = i;
        localbhmw.jdField_d_of_type_Int = 12;
        break;
        j = 14;
        break label258;
      }
      label299:
      localbhmw.jdField_a_of_type_Int = 24;
      localbhmw.jdField_b_of_type_Int = 12;
      localbhmw.jdField_c_of_type_Int = 12;
    }
  }
  
  private boolean a()
  {
    return arlc.c().a;
  }
  
  private boolean b(azrb paramazrb)
  {
    boolean bool = true;
    if ((paramazrb == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      bool = false;
    }
    return bool;
  }
  
  public int a(azrb paramazrb)
  {
    int j = 1;
    if ((paramazrb == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {}
    int i;
    do
    {
      return 0;
      if (bhnz.a(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard) == 1) {
        i = 1;
      }
      while (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qidBgUrl)) {
        if (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl))
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
    } while (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl));
    if (i != 0) {
      j = 2;
    }
    return j;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(ScreenUtil.dip2px(5.0F), 0, ScreenUtil.dip2px(paramFloat1), ScreenUtil.dip2px(paramFloat2));
  }
  
  public void a(QQAppInterface paramQQAppInterface, azrb paramazrb)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      if (b(paramazrb)) {
        break;
      }
      setVisibility(8);
    } while (!QLog.isColorLevel());
    paramQQAppInterface = new StringBuilder().append("QID_LOG,data_check_state:");
    if (!b(paramazrb)) {
      bool = true;
    }
    QLog.d("CoolTextView", 2, bool);
    return;
    if ((TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qid)) && (!a()))
    {
      setVisibility(8);
      return;
    }
    if ((TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qid)) && (!paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      setVisibility(8);
      return;
    }
    a(-1);
    setCoolBuilder(a(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard));
    setVisibility(0);
    bhqa.a("0X800B60C", paramazrb);
  }
  
  public boolean a(azrb paramazrb)
  {
    if ((paramazrb == null) || (paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return false;
    }
    return a(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qidLogoUrl, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.qidBgUrl);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.QidCoolTextView
 * JD-Core Version:    0.7.0.1
 */