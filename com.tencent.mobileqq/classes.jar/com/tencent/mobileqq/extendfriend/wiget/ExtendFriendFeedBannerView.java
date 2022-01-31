package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import aooo;
import apwx;
import apxp;
import apxq;
import apxr;
import apxu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private apxp jdField_a_of_type_Apxp;
  private apxr jdField_a_of_type_Apxr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ExtendFriendFeedBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(apxu paramapxu)
  {
    if (this.jdField_a_of_type_Apxr == null) {
      this.jdField_a_of_type_Apxr = new apxr(this, paramapxu);
    }
    this.jdField_a_of_type_Apxr.a(this.jdField_a_of_type_Apxp, 0);
  }
  
  private void b()
  {
    label130:
    aooo localaooo;
    apxq localapxq;
    if (this.jdField_a_of_type_Apxp == null)
    {
      this.jdField_a_of_type_Apxp = new apxp();
      this.jdField_a_of_type_Apxp.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new apxq();
      ((apxq)localObject).jdField_a_of_type_Int = 0;
      ((apxq)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131699303);
      ((apxq)localObject).jdField_b_of_type_Int = -20771;
      ((apxq)localObject).jdField_c_of_type_Int = -31578;
      ((apxq)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Apxp.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((apwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localaooo = (aooo)((Iterator)localObject).next();
      localapxq = new apxq();
      if (!"0".equals(localaooo.f)) {
        break label286;
      }
      localapxq.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localapxq.jdField_a_of_type_JavaLangString = localaooo.jdField_c_of_type_JavaLangString;
      localapxq.jdField_a_of_type_Long = localaooo.jdField_a_of_type_Long;
      localapxq.jdField_b_of_type_JavaLangString = localaooo.d;
      localapxq.d = localaooo.g;
      localapxq.jdField_c_of_type_JavaLangString = localaooo.e;
      localapxq.jdField_a_of_type_OrgJsonJSONObject = localaooo.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localaooo.jdField_a_of_type_JavaLangString != null) {
          localapxq.jdField_b_of_type_Int = Color.parseColor(localaooo.jdField_a_of_type_JavaLangString);
        }
        if (localaooo.jdField_b_of_type_JavaLangString != null) {
          localapxq.jdField_c_of_type_Int = Color.parseColor(localaooo.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Apxp.jdField_a_of_type_JavaUtilArrayList.add(localapxq);
      break label130;
      this.jdField_a_of_type_Apxp.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localaooo.f)) {
        localapxq.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localaooo.f)) {
        localapxq.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localaooo.f)) {
        localapxq.jdField_a_of_type_Int = 3;
      } else {
        localapxq.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apxr != null) {
      this.jdField_a_of_type_Apxr.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    apxq localapxq = new apxq();
    localapxq.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131699326));
    localapxq.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Apxr.a(localapxq);
  }
  
  public void a(QQAppInterface paramQQAppInterface, apxu paramapxu)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramapxu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */