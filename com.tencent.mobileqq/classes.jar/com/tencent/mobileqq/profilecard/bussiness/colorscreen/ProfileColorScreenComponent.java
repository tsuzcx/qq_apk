package com.tencent.mobileqq.profilecard.bussiness.colorscreen;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.floatscr.ColorScreenConstants;
import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class ProfileColorScreenComponent
  extends AbsQQProfileComponent<FrameLayout>
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
    DiniFlyAnimationView localDiniFlyAnimationView = this.mColorScreenView;
    if (localDiniFlyAnimationView != null)
    {
      localDiniFlyAnimationView.cancelAnimation();
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
    if ((this.mApp != null) && (((ProfileCardInfo)this.mData).allInOne != null))
    {
      if (TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)) {
        return;
      }
      if (!ColorScreenConstants.a)
      {
        QLog.i("ProfileColorScreenComponent", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      if (SimpleUIUtil.a())
      {
        QLog.i("ProfileColorScreenComponent", 1, "loadColorScreen, SimpleUIMode is open now");
        return;
      }
      this.mHaveLoadedOnce = true;
      int i = ((ISVIPHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(((ProfileCardInfo)this.mData).allInOne.uin);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadColorScreen ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" mLastColorScreen ");
        ((StringBuilder)localObject).append(this.mLastColorScreen);
        QLog.i("ProfileColorScreenComponent", 2, ((StringBuilder)localObject).toString());
      }
      if ((i > 0) && (i != this.mLastColorScreen))
      {
        this.mColorScreenView.cancelAnimation();
        this.mLastColorScreen = i;
        if (((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin())) {
          localObject = "1";
        } else {
          localObject = "2";
        }
        VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i), null);
        this.mColorScreenLoader = new ProfileColorScreenComponent.ColorScreenLoader(this, i);
        VasUtil.a(this.mApp).getColorScreen().a(i, VasManager.a(this.mColorScreenLoader));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileColorScreenComponent", 2, "loadColorScreen early return");
      }
    }
  }
  
  private void tryLoadColorScreenOnResume()
  {
    if (this.mHaveLoadedOnce)
    {
      int j = 1;
      Object localObject = (AbsProfileHeaderComponent)this.mComponentCenter.getComponent(1002);
      int i = j;
      if (localObject != null)
      {
        localObject = ((AbsProfileHeaderComponent)localObject).getHeaderView();
        i = j;
        if ((localObject instanceof VasProfileTagView))
        {
          i = j;
          if (((VasProfileTagView)localObject).isFullScreen) {
            i = 0;
          }
        }
      }
      this.mLastColorScreen = 0;
      if (i != 0) {
        loadColorScreenInner();
      }
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
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initColorScreenView();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mValidate = true;
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    if ((((ProfileCardInfo)this.mData).card != null) && ((((ProfileCardInfo)this.mData).card.lCurrentStyleId != ProfileCardTemplate.PROFILE_CARD_STYLE_TAG) || (((ProfileCardInfo)this.mData).allInOne.colorScreen == 1))) {
      loadColorScreenInner();
    }
    return bool;
  }
  
  public void onDestroy()
  {
    this.mValidate = false;
    Handler localHandler = this.mUIHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent
 * JD-Core Version:    0.7.0.1
 */