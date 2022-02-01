package com.tencent.mobileqq.profilecard.vas.component.header;

import android.content.Intent;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.component.background.VasProfileSimpleBackgroundComponent;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileSimpleView;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VasProfileHeaderSimpleComponent
  extends AbsVasProfileHeaderComponent
{
  private static final String TAG = "VasProfileHeaderSimpleComponent";
  
  public VasProfileHeaderSimpleComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void handleDiyCardClick(DataTag paramDataTag)
  {
    if ((paramDataTag.jdField_a_of_type_JavaLangObject instanceof View)) {
      ((View)paramDataTag.jdField_a_of_type_JavaLangObject).setVisibility(8);
    }
    goToDiyCardEditPage();
    VasWebviewUtil.a("", "card_mall", "0X8008119", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  public String getComponentName()
  {
    return "VasProfileHeaderSimpleComponent";
  }
  
  void goToDiyCardEditPage()
  {
    Object localObject2 = new PointF();
    IComponent localIComponent = this.mComponentCenter.getComponent(1003);
    Object localObject1 = localObject2;
    if (localIComponent != null)
    {
      localObject1 = localObject2;
      if ((localIComponent instanceof VasProfileSimpleBackgroundComponent)) {
        localObject1 = ((VasProfileSimpleBackgroundComponent)localIComponent).getDiyTextCenterPoint();
      }
    }
    localObject2 = new Intent(this.mActivity, VipProfileCardDiyActivity.class);
    ((Intent)localObject2).putExtra("extra_from", 1);
    ((Intent)localObject2).putExtra("extra_card_id", ((ProfileCardInfo)this.mData).card.lCurrentBgId);
    ((Intent)localObject2).putExtra("extra_card_url", ((ProfileCardInfo)this.mData).card.backgroundUrl);
    ((Intent)localObject2).putExtra("extra_card_default_text", ((ProfileCardInfo)this.mData).card.diyDefaultText);
    if ((!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.diyText)) && (((ProfileCardInfo)this.mData).card.diyTextFontId > 0))
    {
      ((Intent)localObject2).putExtra("extra_card_text", ((ProfileCardInfo)this.mData).card.diyText);
      ((Intent)localObject2).putExtra("extra_card_font", ((ProfileCardInfo)this.mData).card.diyTextFontId);
      ((Intent)localObject2).putExtra("extra_card_x", ((PointF)localObject1).x);
      ((Intent)localObject2).putExtra("extra_card_y", ((PointF)localObject1).y);
      ((Intent)localObject2).putExtra("extra_card_scale", ((ProfileCardInfo)this.mData).card.diyTextScale);
      ((Intent)localObject2).putExtra("extra_card_rotation", ((ProfileCardInfo)this.mData).card.diyTextDegree);
      ((Intent)localObject2).putExtra("extra_card_transparency", ((ProfileCardInfo)this.mData).card.diyTextTransparency);
    }
    this.mActivity.startActivityForResult((Intent)localObject2, 201);
  }
  
  public boolean hasPhotoWall()
  {
    return true;
  }
  
  protected void initHeaderView()
  {
    if (this.mHeaderView == null)
    {
      boolean bool = this.mActivity.getIntent().getBooleanExtra("key_from_extends_friend", false);
      VasProfileSimpleView localVasProfileSimpleView = new VasProfileSimpleView(this.mActivity, (ProfileCardInfo)this.mData);
      localVasProfileSimpleView.setFromExtendFriend(bool);
      localVasProfileSimpleView.setClickListener(this);
      localVasProfileSimpleView.onInit(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
      this.mHeaderView = localVasProfileSimpleView;
      ((FrameLayout)this.mViewContainer).removeAllViews();
      ((FrameLayout)this.mViewContainer).addView(this.mHeaderView);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      if (localDataTag.jdField_a_of_type_Int == 73) {
        handleDiyCardClick(localDataTag);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.VasProfileHeaderSimpleComponent
 * JD-Core Version:    0.7.0.1
 */