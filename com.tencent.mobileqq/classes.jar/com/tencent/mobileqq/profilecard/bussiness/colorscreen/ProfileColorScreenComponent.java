package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.floatscr.ColorScreenManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class ProfileColorScreenComponent
  extends AbsProfileComponent<FrameLayout>
{
  private static final String TAG = "ProfileColorScreenComponent";
  private ProfileColorScreenComponent.ColorScreenLoader mColorScreenLoader;
  private DiniFlyAnimationView mColorScreenView;
  private boolean mHaveLoadedOnce;
  private int mLastColorScreen;
  private Handler mUIHandler;
  private boolean mValidate = false;
  
  public ProfileColorScreenComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void destroyColorScreenView()
  {
    if (this.mColorScreenView != null)
    {
      this.mColorScreenView.cancelAnimation();
      ((FrameLayout)this.mViewContainer).removeView((View)this.mViewContainer);
    }
  }
  
  private void initColorScreenView()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = new DiniFlyAnimationView(this.mActivity);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    ((FrameLayout)this.mViewContainer).addView(localDiniFlyAnimationView, localLayoutParams);
    this.mColorScreenView = localDiniFlyAnimationView;
    this.mColorScreenView.forbiddenLayer();
    this.mColorScreenView.setFitFullScreenXY();
  }
  
  private boolean isValidate()
  {
    return this.mValidate;
  }
  
  private void loadColorScreenInner()
  {
    if ((this.mApp == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a))) {}
    int i;
    do
    {
      return;
      if (!ColorScreenManager.a)
      {
        QLog.i("ColorScreenManager", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      if (SimpleUIUtil.a())
      {
        QLog.i("ColorScreenManager", 1, "loadColorScreen, SimpleUIMode is open now");
        return;
      }
      this.mHaveLoadedOnce = true;
      i = ((SVIPHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenManager", 2, "loadColorScreen " + i + " mLastColorScreen " + this.mLastColorScreen);
      }
      if ((i > 0) && (i != this.mLastColorScreen)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ColorScreenManager", 2, "loadColorScreen early return");
    return;
    this.mColorScreenView.cancelAnimation();
    this.mLastColorScreen = i;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(this.mApp.getCurrentAccountUin())) {}
    for (Object localObject = "1";; localObject = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i), null);
      localObject = ((VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      this.mColorScreenLoader = new ProfileColorScreenComponent.ColorScreenLoader(this, i);
      ((ColorScreenManager)localObject).a(i, VasManager.a(this.mColorScreenLoader));
      return;
    }
  }
  
  private void tryLoadColorScreenOnResume()
  {
    if (this.mHaveLoadedOnce)
    {
      Object localObject = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
      if (localObject == null) {
        break label65;
      }
      localObject = ((AbsProfileHeaderComponent)localObject).getHeaderView();
      if ((!(localObject instanceof VasProfileTagView)) || (!((VasProfileTagView)localObject).isFullScreen)) {
        break label65;
      }
    }
    label65:
    for (int i = 0;; i = 1)
    {
      this.mLastColorScreen = 0;
      if (i != 0) {
        loadColorScreenInner();
      }
      return;
    }
  }
  
  public String getComponentName()
  {
    return "ProfileColorScreenComponent";
  }
  
  public int getComponentType()
  {
    return 1004;
  }
  
  public void loadColorScreen()
  {
    loadColorScreenInner();
  }
  
  public void onCreate(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    initColorScreenView();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mValidate = true;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard != null) && ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != ProfileCardTemplate.f) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f == 1))) {
      loadColorScreenInner();
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.mValidate = false;
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    destroyColorScreenView();
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    tryLoadColorScreenOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent
 * JD-Core Version:    0.7.0.1
 */