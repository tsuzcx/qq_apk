package com.tencent.mobileqq.profilecard.bussiness.guide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.bussiness.guide.action.ProfileGuideAction;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideHandler;
import com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideObserver;
import com.tencent.mobileqq.profilecard.bussiness.guide.report.ProfileGuideReporter;
import com.tencent.mobileqq.profilecard.bussiness.guide.report.ProfileGuideReporter.Companion;
import com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideClickListener;
import com.tencent.mobileqq.profilecard.bussiness.guide.view.ProfileGuideView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/ProfileGuideComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profile/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profile/ProfileCardInfo;)V", "guideAction", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "guideObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "dismissProfileGuide", "", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "getProfileGuide", "handleGetProfileGuide", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "makeOrRefresh", "", "onCloseClick", "onCreate", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDataUpdate", "profileCardInfo", "onDestroy", "onFillClick", "onUpdateClick", "reportProfileGuideRead", "operation", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideComponent
  extends AbsProfileContentComponent
  implements ProfileGuideClickListener
{
  public static final ProfileGuideComponent.Companion Companion = new ProfileGuideComponent.Companion(null);
  private static final String TAG = "ProfileGuideComponent";
  private ProfileGuideAction guideAction;
  private final ProfileGuideObserver guideObserver = (ProfileGuideObserver)new ProfileGuideComponent.guideObserver.1(this);
  
  public ProfileGuideComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private final void dismissProfileGuide()
  {
    ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide = ((ProfileGuide)null);
    IProfileActivityDelegate localIProfileActivityDelegate = this.mDelegate;
    if (localIProfileActivityDelegate != null) {
      localIProfileActivityDelegate.notifyCardUpdate();
    }
  }
  
  private final void getProfileGuide()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileGuideComponent", 0, "getProfileGuide");
    }
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {
      i = 1;
    }
    Object localObject = this.mApp;
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.PROFILE_GUIDE_HANDLER);; localObject = null)
    {
      if ((i != 0) && ((localObject instanceof ProfileGuideHandler))) {
        ((ProfileGuideHandler)localObject).getProfileGuide();
      }
      return;
    }
  }
  
  private final void handleGetProfileGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject2 = null;
    if ((paramProfileGuide != null) && (!paramProfileGuide.isValid())) {}
    for (Object localObject1 = (ProfileGuide)null;; localObject1 = paramProfileGuide)
    {
      if ((Intrinsics.areEqual(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide, localObject1) ^ true))
      {
        ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide = ((ProfileGuide)localObject1);
        localObject1 = this.mDelegate;
        if (localObject1 != null) {
          ((IProfileActivityDelegate)localObject1).notifyCardUpdate();
        }
        localObject1 = localObject2;
        if (paramProfileGuide != null) {
          localObject1 = Integer.valueOf(paramProfileGuide.getGuideType());
        }
        if (localObject1 != null) {
          break label86;
        }
      }
      label86:
      do
      {
        while (localObject1 == null)
        {
          return;
          if (((Integer)localObject1).intValue() == 1)
          {
            ProfileGuideReporter.Companion.reportProfileGuideFill(paramProfileGuide.getGuideId(), 1);
            return;
          }
        }
      } while (((Integer)localObject1).intValue() != 2);
      ProfileGuideReporter.Companion.reportProfileGuideUpdate(paramProfileGuide.getGuideId(), 1);
      return;
    }
  }
  
  private final boolean makeOrRefresh(ProfileGuide paramProfileGuide)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if ((paramProfileGuide == null) || (!paramProfileGuide.isValid()))
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return bool2;
      }
    }
    else
    {
      Object localObject;
      if (this.mViewContainer == null)
      {
        localObject = this.mActivity;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity");
        localObject = new ProfileGuideView((Context)localObject);
        ((ProfileGuideView)localObject).setClickListener((ProfileGuideClickListener)this);
        this.mViewContainer = localObject;
      }
      for (;;)
      {
        localObject = (View)this.mViewContainer;
        bool2 = bool1;
        if (!(localObject instanceof ProfileGuideView)) {
          break;
        }
        ((ProfileGuideView)localObject).updateProfileGuide(paramProfileGuide);
        return bool1;
        bool1 = false;
      }
    }
    return false;
  }
  
  private final void reportProfileGuideRead(ProfileGuide paramProfileGuide, int paramInt)
  {
    Object localObject = this.mApp;
    if (localObject != null) {}
    for (localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.PROFILE_GUIDE_HANDLER);; localObject = null)
    {
      if ((localObject instanceof ProfileGuideHandler))
      {
        int i = paramProfileGuide.getGuideId();
        int j = paramProfileGuide.getGuideType();
        ((ProfileGuideHandler)localObject).reportProfileGuideRead(i, j, paramInt);
      }
      return;
    }
  }
  
  @NotNull
  public String getComponentName()
  {
    return "ProfileGuideComponent";
  }
  
  public int getComponentType()
  {
    return 1029;
  }
  
  @NotNull
  public String getProfileContentKey()
  {
    return "map_key_guide";
  }
  
  public void onCloseClick()
  {
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide != null)
    {
      ProfileGuide localProfileGuide = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide;
      Intrinsics.checkExpressionValueIsNotNull(localProfileGuide, "mData.profileGuide");
      reportProfileGuideRead(localProfileGuide, 1);
      dismissProfileGuide();
    }
  }
  
  public void onCreate(@NotNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mApp;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseActivity, "mApp");
    paramBundle = this.mActivity;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "mActivity");
    paramBundle = (Activity)paramBundle;
    Object localObject = this.mData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mData");
    localObject = (ProfileCardInfo)localObject;
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    Intrinsics.checkExpressionValueIsNotNull(localIComponentCenter, "mComponentCenter");
    this.guideAction = new ProfileGuideAction(paramBaseActivity, paramBundle, (ProfileCardInfo)localObject, localIComponentCenter);
    paramBaseActivity = this.mApp;
    if (paramBaseActivity != null) {
      paramBaseActivity.addObserver((BusinessObserver)this.guideObserver);
    }
    getProfileGuide();
  }
  
  public boolean onDataUpdate(@NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "profileCardInfo");
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefresh(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide) | bool;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver((BusinessObserver)this.guideObserver);
    }
    super.onDestroy();
  }
  
  public void onFillClick()
  {
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide != null)
    {
      ProfileGuide localProfileGuide = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide;
      ProfileGuideAction localProfileGuideAction = this.guideAction;
      if (localProfileGuideAction == null) {
        Intrinsics.throwUninitializedPropertyAccessException("guideAction");
      }
      localProfileGuideAction.onAction(localProfileGuide.getGuideId(), localProfileGuide.getGuideType());
      Intrinsics.checkExpressionValueIsNotNull(localProfileGuide, "profileGuide");
      reportProfileGuideRead(localProfileGuide, 0);
      dismissProfileGuide();
      ProfileGuideReporter.Companion.reportProfileGuideFill(localProfileGuide.getGuideId(), 2);
    }
  }
  
  public void onUpdateClick()
  {
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide != null)
    {
      ProfileGuide localProfileGuide = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessGuideBeanProfileGuide;
      ProfileGuideAction localProfileGuideAction = this.guideAction;
      if (localProfileGuideAction == null) {
        Intrinsics.throwUninitializedPropertyAccessException("guideAction");
      }
      localProfileGuideAction.onAction(localProfileGuide.getGuideId(), localProfileGuide.getGuideType());
      Intrinsics.checkExpressionValueIsNotNull(localProfileGuide, "profileGuide");
      reportProfileGuideRead(localProfileGuide, 0);
      dismissProfileGuide();
      ProfileGuideReporter.Companion.reportProfileGuideUpdate(localProfileGuide.getGuideId(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent
 * JD-Core Version:    0.7.0.1
 */