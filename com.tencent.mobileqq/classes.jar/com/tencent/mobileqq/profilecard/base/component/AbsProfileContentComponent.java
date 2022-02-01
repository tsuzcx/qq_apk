package com.tencent.mobileqq.profilecard.base.component;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbsProfileContentComponent
  extends AbsProfileComponent<View>
{
  private static final String TAG = "AbsProfileContentComponent";
  protected ProfileConfigHelper mConfigHelper;
  public IProfileActivityDelegate mDelegate;
  protected DiyMoreInfoViewHelper mDiyHelper;
  
  public AbsProfileContentComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void applyDIYTemplateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839577);
    }
    this.mDiyHelper.updateItemTheme(paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  private void applyTemplateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5, ProfileCardTemplate paramProfileCardTemplate)
  {
    ProfileCardTemplate.a(paramView1, "background", paramProfileCardTemplate, "commonItemTopBorderBackground");
    ProfileCardTemplate.a(paramTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
    ProfileCardTemplate.a(paramView2, "color", paramProfileCardTemplate, "commonItemContentColor");
    ProfileCardTemplate.a(paramImageView, "src", paramProfileCardTemplate, "commonItemMoreSrc");
    if (paramImageView != null)
    {
      paramView1 = paramImageView.getLayoutParams();
      paramView1.width = -2;
      paramView1.height = -2;
      paramImageView.setLayoutParams(paramView1);
    }
    if (paramView3 != null)
    {
      paramView3.setBackgroundResource(0);
      paramView3.setVisibility(8);
    }
    if (paramView4 != null) {
      paramView4.setBackgroundResource(0);
    }
    if (paramView5 != null) {
      paramView5.setBackgroundResource(0);
    }
  }
  
  private void updateDefaultItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    Resources localResources = this.mActivity.getResources();
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839577);
    }
    if (paramTextView != null) {
      paramTextView.setTextColor(localResources.getColorStateList(2131167033));
    }
    if ((paramView2 instanceof TextView)) {
      ((TextView)paramView2).setTextColor(localResources.getColorStateList(2131167113));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130839414);
        paramView1 = paramImageView.getLayoutParams();
        paramView1.width = -2;
        paramView1.height = -2;
        paramImageView.setLayoutParams(paramView1);
      }
      if (paramView3 != null)
      {
        paramView3.setBackgroundResource(0);
        paramView3.setVisibility(8);
      }
      if (paramView4 != null) {
        paramView4.setBackgroundResource(0);
      }
      if (paramView5 != null) {
        paramView5.setBackgroundResource(0);
      }
      return;
      if ((paramView2 instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView2).setTextColor(localResources.getColorStateList(2131167113));
      }
    }
  }
  
  public abstract String getProfileContentKey();
  
  public void setCommonDependence(IProfileActivityDelegate paramIProfileActivityDelegate, ProfileConfigHelper paramProfileConfigHelper, DiyMoreInfoViewHelper paramDiyMoreInfoViewHelper)
  {
    this.mDelegate = paramIProfileActivityDelegate;
    this.mConfigHelper = paramProfileConfigHelper;
    this.mDiyHelper = paramDiyMoreInfoViewHelper;
  }
  
  protected void updateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView)
  {
    updateItemTheme(paramView1, paramTextView, paramView2, paramImageView, null, null, null);
  }
  
  protected void updateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    try
    {
      ProfileCardTemplate localProfileCardTemplate = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.a != null) && (!localProfileCardTemplate.a.isEmpty()))
      {
        applyTemplateItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5, localProfileCardTemplate);
        return;
      }
      if (ProfileCardTemplate.a(((ProfileCardInfo)this.mData).jdField_a_of_type_Long))
      {
        applyDIYTemplateItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
        return;
      }
    }
    catch (Exception paramView1)
    {
      QLog.e("AbsProfileContentComponent", 1, "updateItemTheme fail.", paramView1);
      return;
    }
    updateDefaultItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  protected void updateItemTheme(TextView paramTextView, View paramView)
  {
    updateItemTheme(null, paramTextView, paramView, null, null, null, null);
  }
  
  protected void updateItemTheme(TextView paramTextView, View paramView, ImageView paramImageView)
  {
    updateItemTheme(null, paramTextView, paramView, paramImageView, null, null, null);
  }
  
  protected void updateItemTheme(ProfileContentTitleView paramProfileContentTitleView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (FrameLayout localFrameLayout = paramProfileContentTitleView.mContentContainer;; localFrameLayout = null)
    {
      updateItemTheme(paramProfileContentTitleView.mTitleContainer, paramProfileContentTitleView.mTitleText, null, paramProfileContentTitleView.mTitleArrow, paramProfileContentTitleView.mTitleIcon, paramProfileContentTitleView.mTitleTextBg, localFrameLayout);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
 * JD-Core Version:    0.7.0.1
 */