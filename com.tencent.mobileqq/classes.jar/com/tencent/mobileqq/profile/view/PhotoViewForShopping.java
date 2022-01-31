package com.tencent.mobileqq.profile.view;

import alpk;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import awqt;
import awrm;
import awuz;
import azqs;
import bddf;
import bdeu;
import bdin;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class PhotoViewForShopping
  extends LinearLayout
  implements Handler.Callback
{
  public static float e;
  public float a;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  private awqt jdField_a_of_type_Awqt;
  public QQAppInterface a;
  ProfileShoppingView jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView;
  public VipScaledViewPager a;
  private String jdField_a_of_type_JavaLangString;
  private Reference<Activity> jdField_a_of_type_JavaLangRefReference;
  public List<awrm> a;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  List<awrm> b;
  public float c;
  public int c;
  public float d;
  public int d;
  public int e;
  private float jdField_f_of_type_Float = 1.0F;
  private int jdField_f_of_type_Int;
  private float jdField_g_of_type_Float;
  private int jdField_g_of_type_Int;
  private float h;
  
  static
  {
    jdField_e_of_type_Float = 1.6F;
  }
  
  public PhotoViewForShopping(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Float = 1.666667F;
    this.jdField_b_of_type_Float = 1.775F;
    this.jdField_c_of_type_Float = 2.0F;
    this.jdField_d_of_type_Float = 1.35F;
  }
  
  public PhotoViewForShopping(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_Float = 1.666667F;
    this.jdField_b_of_type_Float = 1.775F;
    this.jdField_c_of_type_Float = 2.0F;
    this.jdField_d_of_type_Float = 1.35F;
  }
  
  private List<awrm> a(List<awrm> paramList)
  {
    new ArrayList();
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updateCoverData photoInfo size=" + paramList.size());
    }
    return paramList;
  }
  
  @TargetApi(9)
  public void a(BaseActivity paramBaseActivity, awqt paramawqt, int paramInt, ProfileShoppingView paramProfileShoppingView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "initView");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_JavaLangRefReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Awqt = paramawqt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaLangString = paramawqt.a.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView = paramProfileShoppingView;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()).inflate(2131561832, this, true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager = ((VipScaledViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131379940));
    paramBaseActivity = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = paramBaseActivity.widthPixels;
    this.jdField_b_of_type_Int = paramBaseActivity.heightPixels;
    this.jdField_g_of_type_Float = paramBaseActivity.density;
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int / this.jdField_d_of_type_Float));
    this.jdField_d_of_type_Int = ((int)(this.jdField_c_of_type_Int / jdField_e_of_type_Float));
    this.jdField_e_of_type_Int = getResources().getDimensionPixelSize(2131298376);
    boolean bool;
    if (paramawqt.a.jdField_a_of_type_Int == 0)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_f_of_type_Float = (this.jdField_g_of_type_Float / this.jdField_c_of_type_Float);
      if (this.jdField_b_of_type_Int / this.jdField_a_of_type_Int <= (this.jdField_a_of_type_Float + this.jdField_b_of_type_Float) / 2.0F) {
        break label374;
      }
      this.jdField_g_of_type_Int = Math.round(this.jdField_b_of_type_Int / (1136.0F * this.jdField_f_of_type_Float) * bddf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15));
    }
    for (this.h = 0.824503F;; this.h = 0.8192771F)
    {
      paramBaseActivity = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getLayoutParams();
      paramBaseActivity.height = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setLayoutParams(paramBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setScale(this.h);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setGap(this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setParentView((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.getParent());
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setOnPageChangeListener(new awuz(this));
      ThreadManager.executeOnFileThread(new PhotoViewForShopping.2(this, paramawqt));
      return;
      bool = false;
      break;
      label374:
      this.jdField_g_of_type_Int = Math.round(this.jdField_b_of_type_Int / (800.0F * this.jdField_f_of_type_Float) * bddf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 15));
    }
  }
  
  public void a(List<awrm> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.i("ProfileCard.ProfileShoppingView", 2, "updatePhotoView photoInfo size=" + paramList.size());
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager != null))
    {
      paramList = new PhotoViewForShopping.StylePagerAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipScaledViewPager.setAdapter(paramList);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, List<awrm> paramList)
  {
    if (!bdeu.a(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    List localList;
    int i;
    if ((paramBoolean) && (paramList != null))
    {
      localList = a(paramList);
      i = 0;
      paramList = null;
      paramString = null;
      label34:
      if (i >= 16) {
        break label227;
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > i))
      {
        paramString = (awrm)this.jdField_a_of_type_JavaUtilList.get(i);
        label77:
        if ((localList == null) || (localList.size() <= i)) {
          break label176;
        }
        paramList = (awrm)localList.get(i);
        label107:
        if (bdeu.a(paramString, paramList)) {
          break label181;
        }
      }
    }
    label176:
    label181:
    label227:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.ProfileShoppingView", 2, "onGetQZoneCover  isNewPhoto=" + String.valueOf(paramBoolean));
      }
      if ((!paramBoolean) && ((paramString != null) || (paramList != null))) {
        break;
      }
      a(localList);
      return;
      paramString = null;
      break label77;
      paramList = null;
      break label107;
      i += 1;
      break label34;
      if ((!bdin.a(BaseApplication.getContext())) || (this.jdField_f_of_type_Int >= 3)) {
        break;
      }
      paramString = Message.obtain();
      paramString.what = 100;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileCard.ProfileShoppingView", 2, "handleMessage() MSG_REQ_ALBUM");
        }
        paramMessage = (alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        if (paramMessage != null)
        {
          paramMessage.a(this.jdField_a_of_type_JavaLangString, 2);
          this.jdField_f_of_type_Int += 1;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        return false;
        paramMessage = (ProfileShoppingPhotoInfo)paramMessage.obj;
        new ArrayList();
      } while ((paramMessage == null) || (this.jdField_a_of_type_JavaLangRefReference.get() == null));
      String str = paramMessage.shopName;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).jdField_f_of_type_Int = paramMessage.accountFlag;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).jdField_g_of_type_Int = paramMessage.followType;
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).d = paramMessage.shopName;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView.b(str, paramMessage.certifiedGrade);
      }
      paramMessage = paramMessage.getPhotoFromRawData();
    } while (paramMessage == null);
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList = paramMessage;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileShoppingView != null) && (paramMessage.size() > 0) && ((this.jdField_a_of_type_JavaLangRefReference.get() instanceof FriendProfileCardActivity))) {
      ((FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefReference.get()).v();
    }
    if ((paramMessage.size() > 0) && (this.jdField_a_of_type_Awqt != null) && (this.jdField_a_of_type_Awqt.a != null))
    {
      if (!this.jdField_a_of_type_Awqt.a.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label366;
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "PhotoView", "", "Shop_Mtemplatewindow", "0X8005B95", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      a(paramMessage);
      return false;
      label366:
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "PhotoView", "", "Shop_Ftemplatewindow", "0X8005B99", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.PhotoViewForShopping
 * JD-Core Version:    0.7.0.1
 */