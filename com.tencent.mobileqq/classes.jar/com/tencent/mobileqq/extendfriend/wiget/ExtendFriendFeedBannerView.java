package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import aosx;
import aqbg;
import aqby;
import aqbz;
import aqca;
import aqcd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private aqby jdField_a_of_type_Aqby;
  private aqca jdField_a_of_type_Aqca;
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
  
  private void a(aqcd paramaqcd)
  {
    if (this.jdField_a_of_type_Aqca == null) {
      this.jdField_a_of_type_Aqca = new aqca(this, paramaqcd);
    }
    this.jdField_a_of_type_Aqca.a(this.jdField_a_of_type_Aqby, 0);
  }
  
  private void b()
  {
    label130:
    aosx localaosx;
    aqbz localaqbz;
    if (this.jdField_a_of_type_Aqby == null)
    {
      this.jdField_a_of_type_Aqby = new aqby();
      this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      Object localObject = new aqbz();
      ((aqbz)localObject).jdField_a_of_type_Int = 0;
      ((aqbz)localObject).jdField_a_of_type_JavaLangString = getResources().getString(2131699315);
      ((aqbz)localObject).jdField_b_of_type_Int = -20771;
      ((aqbz)localObject).jdField_c_of_type_Int = -31578;
      ((aqbz)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      localObject = ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).a();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      localaosx = (aosx)((Iterator)localObject).next();
      localaqbz = new aqbz();
      if (!"0".equals(localaosx.f)) {
        break label286;
      }
      localaqbz.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localaqbz.jdField_a_of_type_JavaLangString = localaosx.jdField_c_of_type_JavaLangString;
      localaqbz.jdField_a_of_type_Long = localaosx.jdField_a_of_type_Long;
      localaqbz.jdField_b_of_type_JavaLangString = localaosx.d;
      localaqbz.d = localaosx.g;
      localaqbz.jdField_c_of_type_JavaLangString = localaosx.e;
      localaqbz.jdField_a_of_type_OrgJsonJSONObject = localaosx.jdField_a_of_type_OrgJsonJSONObject;
      try
      {
        if (localaosx.jdField_a_of_type_JavaLangString != null) {
          localaqbz.jdField_b_of_type_Int = Color.parseColor(localaosx.jdField_a_of_type_JavaLangString);
        }
        if (localaosx.jdField_b_of_type_JavaLangString != null) {
          localaqbz.jdField_c_of_type_Int = Color.parseColor(localaosx.jdField_b_of_type_JavaLangString);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList.add(localaqbz);
      break label130;
      this.jdField_a_of_type_Aqby.jdField_a_of_type_JavaUtilArrayList.clear();
      break;
      label286:
      if ("1".equals(localaosx.f)) {
        localaqbz.jdField_a_of_type_Int = 1;
      } else if ("2".equals(localaosx.f)) {
        localaqbz.jdField_a_of_type_Int = 2;
      } else if ("3".equals(localaosx.f)) {
        localaqbz.jdField_a_of_type_Int = 3;
      } else {
        localaqbz.jdField_a_of_type_Int = -1;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqca != null) {
      this.jdField_a_of_type_Aqca.a();
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    aqbz localaqbz = new aqbz();
    localaqbz.jdField_b_of_type_JavaLangString = (paramInt + getResources().getString(2131699338));
    localaqbz.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Aqca.a(localaqbz);
  }
  
  public void a(QQAppInterface paramQQAppInterface, aqcd paramaqcd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
    a(paramaqcd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */