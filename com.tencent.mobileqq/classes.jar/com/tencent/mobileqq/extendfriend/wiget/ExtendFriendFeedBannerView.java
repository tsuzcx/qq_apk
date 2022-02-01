package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import arhw;
import aslo;
import asmr;
import asms;
import asmt;
import asmw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private asmr jdField_a_of_type_Asmr;
  private asmt jdField_a_of_type_Asmt;
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
  
  private void a(asmw paramasmw)
  {
    if (this.jdField_a_of_type_Asmt == null) {
      this.jdField_a_of_type_Asmt = new asmt(this, paramasmw);
    }
    this.jdField_a_of_type_Asmt.a(this.jdField_a_of_type_Asmr, 0);
  }
  
  private void b()
  {
    label130:
    arhw localarhw;
    asms localasms;
    if (this.jdField_a_of_type_Asmr == null)
    {
      this.jdField_a_of_type_Asmr = new asmr();
      this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new asms();
      ((asms)localObject).jdField_a_of_type_Int = 0;
      ((asms)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698484);
      ((asms)localObject).jdField_b_of_type_Int = -20771;
      ((asms)localObject).jdField_c_of_type_Int = -31578;
      ((asms)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localarhw = (arhw)((Iterator)localObject).next();
      localasms = new asms();
      if (!"0".equals(localarhw.f)) {
        break label286;
      }
      localasms.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localasms.jdField_a_of_type_JavaLangString = localarhw.jdField_c_of_type_JavaLangString;
      localasms.jdField_a_of_type_Long = localarhw.jdField_a_of_type_Long;
      localasms.jdField_b_of_type_JavaLangString = localarhw.d;
      localasms.d = localarhw.g;
      localasms.jdField_c_of_type_JavaLangString = localarhw.e;
      localasms.jdField_a_of_type_OrgJsonJSONObject = localarhw.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localarhw.jdField_a_of_type_JavaLangString != null) {
          localasms.jdField_b_of_type_Int = Color.parseColor(localarhw.jdField_a_of_type_JavaLangString);
        }
        if (localarhw.jdField_b_of_type_JavaLangString != null) {
          localasms.jdField_c_of_type_Int = Color.parseColor(localarhw.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList.add(localasms);
      break label130;
      this.jdField_a_of_type_Asmr.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localarhw.f)) {
        localasms.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localarhw.f)) {
        localasms.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localarhw.f)) {
        localasms.jdField_a_of_type_Int = 3;
      } else {
        localasms.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asmt != null) {
      this.jdField_a_of_type_Asmt.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    asms localasms = new asms();
    localasms.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131698507));
    localasms.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Asmt.a(localasms);
  }
  
  public void a(QQAppInterface paramQQAppInterface, asmw paramasmw)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramasmw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */