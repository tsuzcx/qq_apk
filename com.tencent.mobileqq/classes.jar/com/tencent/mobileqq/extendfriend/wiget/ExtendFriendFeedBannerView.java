package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import aqep;
import arhi;
import aril;
import arim;
import arin;
import ariq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private aril jdField_a_of_type_Aril;
  private arin jdField_a_of_type_Arin;
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
  
  private void a(ariq paramariq)
  {
    if (this.jdField_a_of_type_Arin == null) {
      this.jdField_a_of_type_Arin = new arin(this, paramariq);
    }
    this.jdField_a_of_type_Arin.a(this.jdField_a_of_type_Aril, 0);
  }
  
  private void b()
  {
    label130:
    aqep localaqep;
    arim localarim;
    if (this.jdField_a_of_type_Aril == null)
    {
      this.jdField_a_of_type_Aril = new aril();
      this.jdField_a_of_type_Aril.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new arim();
      ((arim)localObject).jdField_a_of_type_Int = 0;
      ((arim)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131698198);
      ((arim)localObject).jdField_b_of_type_Int = -20771;
      ((arim)localObject).jdField_c_of_type_Int = -31578;
      ((arim)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Aril.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((arhi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localaqep = (aqep)((Iterator)localObject).next();
      localarim = new arim();
      if (!"0".equals(localaqep.f)) {
        break label286;
      }
      localarim.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localarim.jdField_a_of_type_JavaLangString = localaqep.jdField_c_of_type_JavaLangString;
      localarim.jdField_a_of_type_Long = localaqep.jdField_a_of_type_Long;
      localarim.jdField_b_of_type_JavaLangString = localaqep.d;
      localarim.d = localaqep.g;
      localarim.jdField_c_of_type_JavaLangString = localaqep.e;
      localarim.jdField_a_of_type_OrgJsonJSONObject = localaqep.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localaqep.jdField_a_of_type_JavaLangString != null) {
          localarim.jdField_b_of_type_Int = Color.parseColor(localaqep.jdField_a_of_type_JavaLangString);
        }
        if (localaqep.jdField_b_of_type_JavaLangString != null) {
          localarim.jdField_c_of_type_Int = Color.parseColor(localaqep.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Aril.jdField_a_of_type_JavaUtilArrayList.add(localarim);
      break label130;
      this.jdField_a_of_type_Aril.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localaqep.f)) {
        localarim.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localaqep.f)) {
        localarim.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localaqep.f)) {
        localarim.jdField_a_of_type_Int = 3;
      } else {
        localarim.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Arin != null) {
      this.jdField_a_of_type_Arin.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    arim localarim = new arim();
    localarim.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131698221));
    localarim.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Arin.a(localarim);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ariq paramariq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramariq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */