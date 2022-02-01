package com.tencent.mobileqq.profilecard.vas.misc;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase;
import com.tencent.mobileqq.vip.diy.template.QVipProfileTemplateCreator;
import com.tencent.mobileqq.vip.diy.template.Template2;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DiyMoreInfoViewHelper
{
  private static final String TAG = "DiyMoreInfoViewHelper";
  private QQAppInterface mApp;
  private ProfileTemplateBase mBodyCreator;
  private String mCurrentJson = null;
  private HashMap<String, View> mDIYProfileMoreViewMap;
  private ProfileCardInfo mProfileCardInfo;
  private ProfileCardMoreInfoView mProfileMoreView;
  private HashMap<String, View> mProfileMoreViewMap;
  
  public <T extends View> T getDiyView(String paramString)
  {
    if (this.mBodyCreator == null) {
      return null;
    }
    return (View)this.mDIYProfileMoreViewMap.get(paramString);
  }
  
  public void initDiyTemplate(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, Runnable paramRunnable)
  {
    if ((paramBaseActivity == null) || (paramProfileCardInfo == null) || (!ProfileCardTemplate.a(paramProfileCardInfo.jdField_a_of_type_Long)) || (TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo)))
    {
      if ((this.mBodyCreator != null) && (paramRunnable != null)) {
        paramRunnable.run();
      }
      this.mBodyCreator = null;
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(this.mCurrentJson, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo))
      {
        this.mProfileCardInfo = paramProfileCardInfo;
        this.mCurrentJson = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo;
        try
        {
          this.mBodyCreator = QVipProfileTemplateCreator.a(paramBaseActivity, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData.getBodyJson(), paramProfileCardInfo, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardVasVasDiyData.getUrlPrefix());
          if (this.mDIYProfileMoreViewMap != null)
          {
            this.mApp = paramBaseActivity.app;
            this.mBodyCreator.a(this.mDIYProfileMoreViewMap);
            this.mBodyCreator.b(this.mDIYProfileMoreViewMap);
            this.mBodyCreator.a(this.mDIYProfileMoreViewMap, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
            this.mBodyCreator.a(this.mDIYProfileMoreViewMap, this.mApp, paramProfileCardInfo);
            this.mBodyCreator.b(this.mDIYProfileMoreViewMap, this.mApp, paramProfileCardInfo);
            this.mBodyCreator.a(this.mDIYProfileMoreViewMap, this.mApp, paramProfileCardInfo, this.mProfileMoreView.c);
            QLog.i("DiyMoreInfoViewHelper", 1, "initDiyTemplate sucess");
            return;
          }
        }
        catch (Exception paramBaseActivity)
        {
          QLog.e("ProfileCardMoreInfoView", 1, new RuntimeException("diy info is illegal :" + paramBaseActivity), new Object[0]);
          this.mBodyCreator = null;
        }
      }
    }
  }
  
  public boolean isNotNeedAdd(String paramString)
  {
    if (this.mBodyCreator == null) {
      return false;
    }
    return this.mBodyCreator.a(paramString);
  }
  
  public void onDestroy()
  {
    if (this.mProfileMoreViewMap != null) {
      this.mProfileMoreViewMap.clear();
    }
    this.mApp = null;
    this.mBodyCreator = null;
    this.mProfileMoreView = null;
    this.mProfileMoreViewMap = null;
    this.mDIYProfileMoreViewMap = null;
  }
  
  public void setProfileArgs(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.mProfileMoreView = paramProfileCardMoreInfoView;
    this.mProfileMoreViewMap = paramProfileCardMoreInfoView.a();
    this.mDIYProfileMoreViewMap = new HashMap();
  }
  
  public void updateDiyView(String paramString, HashMap<String, View> paramHashMap)
  {
    if (this.mBodyCreator == null) {
      return;
    }
    this.mBodyCreator.a(this.mDIYProfileMoreViewMap, paramString, paramHashMap);
  }
  
  public void updateItemTheme(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    if (this.mBodyCreator != null) {
      if (!(this.mBodyCreator instanceof Template2)) {
        break label33;
      }
    }
    for (;;)
    {
      this.mBodyCreator.a(null, paramTextView, paramView1, paramImageView, paramView3, paramView4);
      return;
      label33:
      paramView3 = paramView2;
    }
  }
  
  public void updateModuleTitleView(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (this.mBodyCreator == null) {
      return;
    }
    this.mBodyCreator.a(paramString, paramTextView, paramView, paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper
 * JD-Core Version:    0.7.0.1
 */