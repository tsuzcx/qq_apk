package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import anuk;
import auec;
import azfe;
import azfl;
import azkq;
import azks;
import azlw;
import bcnj;
import bgzk;
import bgzp;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class ProfileColorScreenComponent
  extends azkq<FrameLayout>
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ProfileColorScreenComponent.ColorScreenLoader jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public ProfileColorScreenComponent(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  private void i()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(localDiniFlyAnimationView, localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = localDiniFlyAnimationView;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.forbiddenLayer();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeView((View)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = (azks)this.jdField_a_of_type_Azlw.a(1002);
      if (localObject == null) {
        break label65;
      }
      localObject = ((azks)localObject).a();
      if ((!(localObject instanceof VasProfileTagView)) || (!((VasProfileTagView)localObject).jdField_b_of_type_Boolean)) {
        break label65;
      }
    }
    label65:
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_Int = 0;
      if (i != 0) {
        l();
      }
      return;
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))) {}
    int i;
    do
    {
      return;
      if (!auec.jdField_a_of_type_Boolean)
      {
        QLog.i("ColorScreenManager", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      if (bcnj.b())
      {
        QLog.i("ColorScreenManager", 1, "loadColorScreen, SimpleUIMode is open now");
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      i = ((anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenManager", 2, "loadColorScreen " + i + " mLastColorScreen " + this.jdField_a_of_type_Int);
      }
      if ((i > 0) && (i != this.jdField_a_of_type_Int)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ColorScreenManager", 2, "loadColorScreen early return");
    return;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_Int = i;
    if (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
    for (Object localObject = "1";; localObject = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i), null);
      localObject = ((bgzk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a;
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader = new ProfileColorScreenComponent.ColorScreenLoader(this, i);
      ((auec)localObject).a(i, bgzp.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessColorscreenProfileColorScreenComponent$ColorScreenLoader));
      return;
    }
  }
  
  public int a()
  {
    return 1004;
  }
  
  public String a()
  {
    return "ProfileColorScreenComponent";
  }
  
  public void a()
  {
    l();
  }
  
  public void a(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.a(paramBaseActivity, paramBundle);
    i();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a(azfe paramazfe)
  {
    boolean bool = super.a(paramazfe);
    if ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != azfl.f) || (((azfe)this.jdField_b_of_type_JavaLangObject).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f == 1))) {
      l();
    }
    return bool;
  }
  
  public void c()
  {
    super.c();
    k();
  }
  
  public void f()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    j();
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent
 * JD-Core Version:    0.7.0.1
 */