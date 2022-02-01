package com.tencent.mobileqq.profilecard.vas.component.background;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity.OnMeasuredListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.vas.VasDiyTextData;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileSimpleBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "mDiyTextLayout", "Lcom/tencent/mobileqq/profile/view/SingleTouchLayout;", "mDiyTextMask", "Landroid/view/View;", "mDiyTextView", "Lcom/tencent/mobileqq/profile/diy/DiyTextView;", "getDiyTextCenterPoint", "Landroid/graphics/PointF;", "onCreate", "", "activity", "Lcom/tencent/mobileqq/app/QBaseActivity;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onVasDataUpdate", "", "data", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "updateDiyText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasProfileSimpleBackgroundComponent
  extends VasProfileBackgroundComponent
{
  private SingleTouchLayout mDiyTextLayout;
  private View mDiyTextMask;
  private DiyTextView mDiyTextView;
  
  public VasProfileSimpleBackgroundComponent(@Nullable IComponentCenter paramIComponentCenter, @Nullable ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private final void updateDiyText(VasProfileData paramVasProfileData)
  {
    VasDiyTextData localVasDiyTextData = paramVasProfileData.getDiyTextData();
    Object localObject = (CharSequence)localVasDiyTextData.getDiyText();
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (paramVasProfileData.getMCurUseStyleId() == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE))
    {
      if (this.mDiyTextView == null)
      {
        paramVasProfileData = new DiyTextView(getContainerView().getContext());
        paramVasProfileData.setOnMeasuredListener((VipProfileCardDiyActivity.OnMeasuredListener)new VasProfileSimpleBackgroundComponent.updateDiyText..inlined.apply.lambda.1(this));
        this.mDiyTextView = paramVasProfileData;
      }
      paramVasProfileData = this.mDiyTextView;
      if (paramVasProfileData == null) {
        Intrinsics.throwNpe();
      }
      paramVasProfileData.setMaxSize(getContainerView().getWidth() * 2 / 3);
      paramVasProfileData.setVisibility(0);
      paramVasProfileData.setHiBoom(localVasDiyTextData.getDiyTextFontId(), 1, HiBoomConstants.d);
      paramVasProfileData.setText((CharSequence)localVasDiyTextData.getDiyText());
      paramVasProfileData = this.mDiyTextMask;
      if (paramVasProfileData == null) {
        Intrinsics.throwNpe();
      }
      int j = (int)(localVasDiyTextData.getDiyTextTransparency() * 'ÿ');
      if (j < -77)
      {
        i = -77;
      }
      else
      {
        i = j;
        if (j > 77) {
          i = 77;
        }
      }
      if (i > 0) {
        j = -16777216;
      } else {
        j = -1;
      }
      paramVasProfileData.setBackgroundColor(j);
      paramVasProfileData = paramVasProfileData.getBackground();
      Intrinsics.checkExpressionValueIsNotNull(paramVasProfileData, "background");
      paramVasProfileData.setAlpha(Math.abs(i));
      paramVasProfileData = this.mDiyTextLayout;
      if (paramVasProfileData == null) {
        Intrinsics.throwNpe();
      }
      paramVasProfileData.setVisibility(0);
      paramVasProfileData.b((View)this.mDiyTextView);
      paramVasProfileData.setImageDegree(localVasDiyTextData.getDiyTextDegree());
      paramVasProfileData.setImageScale(localVasDiyTextData.getDiyTextScale());
      localObject = getContainerView().getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context");
      localObject = ((Context)localObject).getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "containerView.context.resources");
      localObject = ((Resources)localObject).getDisplayMetrics();
      paramVasProfileData.setCenterPoint(localVasDiyTextData.getDiyTextLocX() * ((DisplayMetrics)localObject).widthPixels, localVasDiyTextData.getDiyTextLocY() * ((DisplayMetrics)localObject).heightPixels);
      paramVasProfileData.c();
      paramVasProfileData.invalidate();
      return;
    }
    paramVasProfileData = this.mDiyTextMask;
    if (paramVasProfileData != null) {
      paramVasProfileData.setVisibility(8);
    }
    paramVasProfileData = this.mDiyTextLayout;
    if (paramVasProfileData != null) {
      paramVasProfileData.setVisibility(8);
    }
    this.mDiyTextView = ((DiyTextView)null);
  }
  
  @NotNull
  public final PointF getDiyTextCenterPoint()
  {
    Object localObject = this.mDiyTextLayout;
    if (localObject != null)
    {
      localObject = ((SingleTouchLayout)localObject).getCenterPoint();
      if (localObject != null) {
        return localObject;
      }
    }
    return new PointF();
  }
  
  public void onCreate(@NotNull QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramQBaseActivity, "activity");
    super.onCreate(paramQBaseActivity, paramBundle);
    paramBundle = (Context)paramQBaseActivity;
    paramQBaseActivity = new View(paramBundle);
    paramQBaseActivity.setBackgroundColor(-16777216);
    paramQBaseActivity.setVisibility(8);
    paramQBaseActivity.setContentDescription((CharSequence)"qqvip_diy_text_mask");
    getContainerView().addView(paramQBaseActivity);
    this.mDiyTextMask = paramQBaseActivity;
    paramQBaseActivity = new SingleTouchLayout(paramBundle);
    paramQBaseActivity.setVisibility(8);
    paramQBaseActivity.setEditable(false);
    paramQBaseActivity.setMovable(false);
    paramQBaseActivity.setContentDescription((CharSequence)"qqvip_diy_text");
    getContainerView().addView((View)paramQBaseActivity);
    this.mDiyTextLayout = paramQBaseActivity;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getContainerView().removeView(this.mDiyTextMask);
    getContainerView().removeView((View)this.mDiyTextLayout);
  }
  
  public boolean onVasDataUpdate(@NotNull VasProfileData paramVasProfileData)
  {
    Intrinsics.checkParameterIsNotNull(paramVasProfileData, "data");
    super.onVasDataUpdate(paramVasProfileData);
    updateDiyText(paramVasProfileData);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.background.VasProfileSimpleBackgroundComponent
 * JD-Core Version:    0.7.0.1
 */