package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import arks;
import asvi;
import aswi;
import aswj;
import aswk;
import aswn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private aswi jdField_a_of_type_Aswi;
  private aswk jdField_a_of_type_Aswk;
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
  
  private void a(aswn paramaswn)
  {
    if (this.jdField_a_of_type_Aswk == null) {
      this.jdField_a_of_type_Aswk = new aswk(this, paramaswn);
    }
    this.jdField_a_of_type_Aswk.a(this.jdField_a_of_type_Aswi, 0);
  }
  
  private void b()
  {
    label130:
    arks localarks;
    aswj localaswj;
    if (this.jdField_a_of_type_Aswi == null)
    {
      this.jdField_a_of_type_Aswi = new aswi();
      this.jdField_a_of_type_Aswi.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new aswj();
      ((aswj)localObject).jdField_a_of_type_Int = 0;
      ((aswj)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698034);
      ((aswj)localObject).jdField_b_of_type_Int = -20771;
      ((aswj)localObject).jdField_c_of_type_Int = -31578;
      ((aswj)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Aswi.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((asvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localarks = (arks)((Iterator)localObject).next();
      localaswj = new aswj();
      if (!"0".equals(localarks.f)) {
        break label286;
      }
      localaswj.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localaswj.jdField_a_of_type_JavaLangString = localarks.jdField_c_of_type_JavaLangString;
      localaswj.jdField_a_of_type_Long = localarks.jdField_a_of_type_Long;
      localaswj.jdField_b_of_type_JavaLangString = localarks.d;
      localaswj.d = localarks.g;
      localaswj.jdField_c_of_type_JavaLangString = localarks.e;
      localaswj.jdField_a_of_type_OrgJsonJSONObject = localarks.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localarks.jdField_a_of_type_JavaLangString != null) {
          localaswj.jdField_b_of_type_Int = Color.parseColor(localarks.jdField_a_of_type_JavaLangString);
        }
        if (localarks.jdField_b_of_type_JavaLangString != null) {
          localaswj.jdField_c_of_type_Int = Color.parseColor(localarks.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Aswi.jdField_a_of_type_JavaUtilArrayList.add(localaswj);
      break label130;
      this.jdField_a_of_type_Aswi.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localarks.f)) {
        localaswj.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localarks.f)) {
        localaswj.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localarks.f)) {
        localaswj.jdField_a_of_type_Int = 3;
      } else {
        localaswj.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aswk != null) {
      this.jdField_a_of_type_Aswk.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    aswj localaswj = new aswj();
    localaswj.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131698057));
    localaswj.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Aswk.a(localaswj);
  }
  
  public void a(QQAppInterface paramQQAppInterface, aswn paramaswn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramaswn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */