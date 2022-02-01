package com.tencent.mobileqq.profilecard.base.component;

import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ITemplateManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbsProfileComponent<VIEW>
  extends AbsComponent<VIEW, ProfileCardInfo>
{
  private static final String TAG = "AbsProfileComponent";
  protected IProfileConfig mConfigHelper;
  protected IProfileActivityDelegate mDelegate;
  
  public AbsProfileComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void applyDIYTemplateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839624);
    }
    ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).updateItemThemeForDIYTemplate(paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  private void applyTemplateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5, ProfileCardTemplate paramProfileCardTemplate)
  {
    updateViewAttr(paramView1, "background", paramProfileCardTemplate, "commonItemTopBorderBackground");
    updateViewAttr(paramTextView, "color", paramProfileCardTemplate, "commonItemContentColor");
    updateViewAttr(paramView2, "color", paramProfileCardTemplate, "commonItemContentColor");
    updateViewAttr(paramImageView, "src", paramProfileCardTemplate, "commonItemMoreSrc");
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
      paramView1.setBackgroundResource(2130839624);
    }
    if (paramTextView != null) {
      paramTextView.setTextColor(localResources.getColorStateList(2131167993));
    }
    if ((paramView2 instanceof TextView)) {
      ((TextView)paramView2).setTextColor(localResources.getColorStateList(2131168118));
    } else if ((paramView2 instanceof SingleLineTextView)) {
      ((SingleLineTextView)paramView2).setTextColor(localResources.getColorStateList(2131168118));
    }
    if (paramImageView != null)
    {
      paramImageView.setImageResource(2130839446);
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
  
  private void updateViewAttr(View paramView, String paramString1, ProfileCardTemplate paramProfileCardTemplate, String paramString2)
  {
    ProfileTemplateApi.getTemplateManager(this.mComponentCenter).updateViewAttrForTemplate(paramView, paramString1, paramProfileCardTemplate, paramString2);
  }
  
  public void setProfileActivityDelegate(IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    this.mDelegate = paramIProfileActivityDelegate;
    paramIProfileActivityDelegate = this.mDelegate;
    if (paramIProfileActivityDelegate != null) {
      this.mConfigHelper = paramIProfileActivityDelegate.getProfileConfig();
    }
  }
  
  protected void updateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView)
  {
    updateItemTheme(paramView1, paramTextView, paramView2, paramImageView, null, null, null);
  }
  
  protected void updateItemTheme(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    try
    {
      ProfileCardTemplate localProfileCardTemplate = ((ProfileCardInfo)this.mData).currentTemplate;
      if ((localProfileCardTemplate != null) && (localProfileCardTemplate.templateAttr != null) && (!localProfileCardTemplate.templateAttr.isEmpty()))
      {
        applyTemplateItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5, localProfileCardTemplate);
        return;
      }
      if (ProfileTemplateApi.isDiyTemplateStyleID(((ProfileCardInfo)this.mData).curUseStyleId))
      {
        applyDIYTemplateItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
        return;
      }
      updateDefaultItemTheme(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
      return;
    }
    catch (Exception paramView1)
    {
      QLog.e("AbsProfileComponent", 1, "updateItemTheme fail.", paramView1);
    }
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
    FrameLayout localFrameLayout;
    if (paramBoolean) {
      localFrameLayout = paramProfileContentTitleView.mContentContainer;
    } else {
      localFrameLayout = null;
    }
    updateItemTheme(paramProfileContentTitleView.mTitleContainer, paramProfileContentTitleView.mTitleText, null, paramProfileContentTitleView.mTitleArrow, paramProfileContentTitleView.mTitleIcon, paramProfileContentTitleView.mTitleTextBg, localFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent
 * JD-Core Version:    0.7.0.1
 */