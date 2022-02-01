package com.tencent.mobileqq.profilecard.bussiness.guide;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QBaseActivity;
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
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/ProfileGuideComponent;", "Lcom/tencent/mobileqq/profilecard/base/component/AbsProfileContentComponent;", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/view/ProfileGuideClickListener;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "guideAction", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/action/ProfileGuideAction;", "guideObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideObserver;", "profileGuide", "Lcom/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide;", "dismissProfileGuide", "", "getComponentName", "", "getComponentType", "", "getProfileContentKey", "getProfileGuide", "getProfileGuideHandler", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "handleGetProfileGuide", "makeOrRefresh", "", "onCloseClick", "onCreate", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDataUpdate", "profileCardInfo", "onDestroy", "onFillClick", "onUpdateClick", "reportProfileGuideRead", "operation", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileGuideComponent
  extends AbsProfileContentComponent
  implements ProfileGuideClickListener
{
  public static final ProfileGuideComponent.Companion Companion = new ProfileGuideComponent.Companion(null);
  private static final String TAG = "ProfileGuideComponent";
  private ProfileGuideAction guideAction;
  private final ProfileGuideObserver guideObserver = (ProfileGuideObserver)new ProfileGuideComponent.guideObserver.1(this);
  private ProfileGuide profileGuide;
  
  public ProfileGuideComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private final void dismissProfileGuide()
  {
    this.profileGuide = ((ProfileGuide)null);
    IProfileActivityDelegate localIProfileActivityDelegate = this.mDelegate;
    if (localIProfileActivityDelegate != null) {
      localIProfileActivityDelegate.notifyCardUpdate();
    }
  }
  
  private final void getProfileGuide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileGuideComponent", 2, "getProfileGuide");
    }
    int i;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    BusinessHandler localBusinessHandler = getProfileGuideHandler(this.mApp);
    if ((i != 0) && ((localBusinessHandler instanceof ProfileGuideHandler))) {
      ((ProfileGuideHandler)localBusinessHandler).getProfileGuide();
    }
  }
  
  private final BusinessHandler getProfileGuideHandler(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null) {
      return paramAppInterface.getBusinessHandler(ProfileGuideHandler.class.getName());
    }
    return null;
  }
  
  private final void handleGetProfileGuide(ProfileGuide paramProfileGuide)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramProfileGuide != null) && (!paramProfileGuide.isValid())) {
      localObject1 = (ProfileGuide)null;
    } else {
      localObject1 = paramProfileGuide;
    }
    if ((Intrinsics.areEqual(this.profileGuide, localObject1) ^ true))
    {
      this.profileGuide = ((ProfileGuide)localObject1);
      localObject1 = this.mDelegate;
      if (localObject1 != null) {
        ((IProfileActivityDelegate)localObject1).notifyCardUpdate();
      }
      localObject1 = localObject2;
      if (paramProfileGuide != null) {
        localObject1 = Integer.valueOf(paramProfileGuide.getGuideType());
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == 1))
      {
        ProfileGuideReporter.Companion.reportProfileGuideFill(paramProfileGuide.getGuideId(), 1);
        return;
      }
      if (localObject1 == null) {
        return;
      }
      if (((Integer)localObject1).intValue() == 2) {
        ProfileGuideReporter.Companion.reportProfileGuideUpdate(paramProfileGuide.getGuideId(), 1);
      }
    }
  }
  
  private final boolean makeOrRefresh(ProfileGuide paramProfileGuide)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((paramProfileGuide != null) && (paramProfileGuide.isValid()))
    {
      if (this.mViewContainer == null)
      {
        localObject = this.mActivity;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity");
        localObject = new ProfileGuideView((Context)localObject);
        ((ProfileGuideView)localObject).setClickListener((ProfileGuideClickListener)this);
        this.mViewContainer = localObject;
      }
      else
      {
        bool1 = false;
      }
      Object localObject = (View)this.mViewContainer;
      bool2 = bool1;
      if ((localObject instanceof ProfileGuideView))
      {
        ((ProfileGuideView)localObject).updateProfileGuide(paramProfileGuide);
        return bool1;
      }
    }
    else
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
      bool2 = false;
    }
    return bool2;
  }
  
  private final void reportProfileGuideRead(ProfileGuide paramProfileGuide, int paramInt)
  {
    BusinessHandler localBusinessHandler = getProfileGuideHandler(this.mApp);
    if ((localBusinessHandler instanceof ProfileGuideHandler))
    {
      int i = paramProfileGuide.getGuideId();
      int j = paramProfileGuide.getGuideType();
      ((ProfileGuideHandler)localBusinessHandler).reportProfileGuideRead(i, j, paramInt);
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
    ProfileGuide localProfileGuide = this.profileGuide;
    if (localProfileGuide != null)
    {
      reportProfileGuideRead(localProfileGuide, 1);
      dismissProfileGuide();
    }
  }
  
  public void onCreate(@NotNull QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mApp;
    Intrinsics.checkExpressionValueIsNotNull(paramQBaseActivity, "mApp");
    paramBundle = this.mActivity;
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "mActivity");
    paramBundle = (Activity)paramBundle;
    Object localObject = this.mData;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mData");
    localObject = (ProfileCardInfo)localObject;
    IComponentCenter localIComponentCenter = this.mComponentCenter;
    Intrinsics.checkExpressionValueIsNotNull(localIComponentCenter, "mComponentCenter");
    this.guideAction = new ProfileGuideAction(paramQBaseActivity, paramBundle, (ProfileCardInfo)localObject, localIComponentCenter);
    paramQBaseActivity = this.mApp;
    if (paramQBaseActivity != null) {
      paramQBaseActivity.addObserver((BusinessObserver)this.guideObserver);
    }
    getProfileGuide();
  }
  
  public boolean onDataUpdate(@NotNull ProfileCardInfo paramProfileCardInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileCardInfo, "profileCardInfo");
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefresh(this.profileGuide);
  }
  
  public void onDestroy()
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface != null) {
      localAppInterface.removeObserver((BusinessObserver)this.guideObserver);
    }
    super.onDestroy();
  }
  
  public void onFillClick()
  {
    ProfileGuide localProfileGuide = this.profileGuide;
    if (localProfileGuide != null)
    {
      ProfileGuideAction localProfileGuideAction = this.guideAction;
      if (localProfileGuideAction == null) {
        Intrinsics.throwUninitializedPropertyAccessException("guideAction");
      }
      localProfileGuideAction.onAction(localProfileGuide.getGuideId(), localProfileGuide.getGuideType());
      reportProfileGuideRead(localProfileGuide, 0);
      dismissProfileGuide();
      ProfileGuideReporter.Companion.reportProfileGuideFill(localProfileGuide.getGuideId(), 2);
    }
  }
  
  public void onUpdateClick()
  {
    ProfileGuide localProfileGuide = this.profileGuide;
    if (localProfileGuide != null)
    {
      ProfileGuideAction localProfileGuideAction = this.guideAction;
      if (localProfileGuideAction == null) {
        Intrinsics.throwUninitializedPropertyAccessException("guideAction");
      }
      localProfileGuideAction.onAction(localProfileGuide.getGuideId(), localProfileGuide.getGuideType());
      reportProfileGuideRead(localProfileGuide, 0);
      dismissProfileGuide();
      ProfileGuideReporter.Companion.reportProfileGuideUpdate(localProfileGuide.getGuideId(), 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.ProfileGuideComponent
 * JD-Core Version:    0.7.0.1
 */