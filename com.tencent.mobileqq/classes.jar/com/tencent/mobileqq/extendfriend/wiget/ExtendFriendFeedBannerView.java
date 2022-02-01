package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import aqve;
import asfu;
import asgu;
import asgv;
import asgw;
import asgz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private asgu jdField_a_of_type_Asgu;
  private asgw jdField_a_of_type_Asgw;
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
  
  private void a(asgz paramasgz)
  {
    if (this.jdField_a_of_type_Asgw == null) {
      this.jdField_a_of_type_Asgw = new asgw(this, paramasgz);
    }
    this.jdField_a_of_type_Asgw.a(this.jdField_a_of_type_Asgu, 0);
  }
  
  private void b()
  {
    label130:
    aqve localaqve;
    asgv localasgv;
    if (this.jdField_a_of_type_Asgu == null)
    {
      this.jdField_a_of_type_Asgu = new asgu();
      this.jdField_a_of_type_Asgu.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new asgv();
      ((asgv)localObject).jdField_a_of_type_Int = 0;
      ((asgv)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131697934);
      ((asgv)localObject).jdField_b_of_type_Int = -20771;
      ((asgv)localObject).jdField_c_of_type_Int = -31578;
      ((asgv)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Asgu.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((asfu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localaqve = (aqve)((Iterator)localObject).next();
      localasgv = new asgv();
      if (!"0".equals(localaqve.f)) {
        break label286;
      }
      localasgv.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localasgv.jdField_a_of_type_JavaLangString = localaqve.jdField_c_of_type_JavaLangString;
      localasgv.jdField_a_of_type_Long = localaqve.jdField_a_of_type_Long;
      localasgv.jdField_b_of_type_JavaLangString = localaqve.d;
      localasgv.d = localaqve.g;
      localasgv.jdField_c_of_type_JavaLangString = localaqve.e;
      localasgv.jdField_a_of_type_OrgJsonJSONObject = localaqve.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localaqve.jdField_a_of_type_JavaLangString != null) {
          localasgv.jdField_b_of_type_Int = Color.parseColor(localaqve.jdField_a_of_type_JavaLangString);
        }
        if (localaqve.jdField_b_of_type_JavaLangString != null) {
          localasgv.jdField_c_of_type_Int = Color.parseColor(localaqve.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Asgu.jdField_a_of_type_JavaUtilArrayList.add(localasgv);
      break label130;
      this.jdField_a_of_type_Asgu.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localaqve.f)) {
        localasgv.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localaqve.f)) {
        localasgv.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localaqve.f)) {
        localasgv.jdField_a_of_type_Int = 3;
      } else {
        localasgv.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Asgw != null) {
      this.jdField_a_of_type_Asgw.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    asgv localasgv = new asgv();
    localasgv.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131697957));
    localasgv.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Asgw.a(localasgv);
  }
  
  public void a(QQAppInterface paramQQAppInterface, asgz paramasgz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramasgz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */