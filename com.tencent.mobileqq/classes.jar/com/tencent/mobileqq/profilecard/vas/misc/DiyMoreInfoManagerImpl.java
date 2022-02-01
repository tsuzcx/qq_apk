package com.tencent.mobileqq.profilecard.vas.misc;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.vas.VasDiyData;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase;
import com.tencent.mobileqq.vip.diy.template.QVipProfileTemplateCreator;
import com.tencent.mobileqq.vip.diy.template.Template2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DiyMoreInfoManagerImpl
  implements IDiyMoreInfoManager
{
  private static final String TAG = "DiyMoreInfoViewHelper";
  private QQAppInterface mApp;
  private ProfileTemplateBase mBodyCreator;
  private String mCurrentJson = null;
  private HashMap<String, View> mDIYProfileMoreViewMap;
  private ProfileCardInfo mProfileCardInfo;
  private HashMap<String, View> mProfileMoreViewMap;
  
  public <T extends View> T getPhotoWallDiyView(ProfileCardInfo paramProfileCardInfo)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return null;
    }
    return localProfileTemplateBase.a(this.mApp, paramProfileCardInfo);
  }
  
  public <T extends View> T getQZoneDiyView(String paramString)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return null;
    }
    localProfileTemplateBase.a(this.mDIYProfileMoreViewMap);
    return (View)this.mDIYProfileMoreViewMap.get(paramString);
  }
  
  public void initDiyTemplate(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQBaseActivity != null) && (paramProfileCardInfo != null) && (ProfileTemplateApi.isDiyTemplateStyleID(paramProfileCardInfo.curUseStyleId)) && (!TextUtils.isEmpty(paramProfileCardInfo.card.diyComplicatedInfo)))
    {
      if (TextUtils.equals(this.mCurrentJson, paramProfileCardInfo.card.diyComplicatedInfo)) {
        return;
      }
      this.mProfileCardInfo = paramProfileCardInfo;
      this.mCurrentJson = paramProfileCardInfo.card.diyComplicatedInfo;
      try
      {
        VasDiyData localVasDiyData = (VasDiyData)paramProfileCardInfo.getBusinessInfo(VasDiyData.class);
        this.mBodyCreator = QVipProfileTemplateCreator.a(paramQBaseActivity, localVasDiyData.getBodyJson(), paramProfileCardInfo, localVasDiyData.getUrlPrefix());
        this.mDIYProfileMoreViewMap = new HashMap();
        this.mApp = ((QQAppInterface)paramQBaseActivity.getAppRuntime());
        QLog.i("DiyMoreInfoViewHelper", 1, "initDiyTemplate sucess");
        return;
      }
      catch (Exception paramQBaseActivity)
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append("diy info is illegal :");
        paramProfileCardInfo.append(paramQBaseActivity);
        QLog.e("DiyMoreInfoViewHelper", 1, new RuntimeException(paramProfileCardInfo.toString()), new Object[0]);
        this.mBodyCreator = null;
        this.mCurrentJson = null;
        return;
      }
    }
    this.mBodyCreator = null;
  }
  
  public boolean isDiy()
  {
    return this.mBodyCreator != null;
  }
  
  public void onDestroy()
  {
    HashMap localHashMap = this.mProfileMoreViewMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
    this.mApp = null;
    this.mBodyCreator = null;
    this.mProfileMoreViewMap = null;
    this.mDIYProfileMoreViewMap = null;
  }
  
  public void setProfileArgs()
  {
    this.mDIYProfileMoreViewMap = new HashMap();
  }
  
  public void updateAccountInfoForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.d(paramView);
  }
  
  public void updateBaseInfoForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.c(paramView);
  }
  
  public void updateItemThemeForDIYTemplate(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase != null)
    {
      if ((localProfileTemplateBase instanceof Template2)) {
        paramView2 = paramView3;
      }
      this.mBodyCreator.a(null, paramTextView, paramView1, paramImageView, paramView2, paramView4);
    }
  }
  
  public void updateLevelForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.f(paramView);
  }
  
  public void updateMetalForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.g(paramView);
  }
  
  public void updateModuleTitleView(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  public void updatePhotoWallForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.b(paramView);
  }
  
  public void updateQzoneForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.a(paramView);
  }
  
  public void updateSignForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.e(paramView);
  }
  
  public void updateTroopMemInfoForDeepDiy(View paramView)
  {
    ProfileTemplateBase localProfileTemplateBase = this.mBodyCreator;
    if (localProfileTemplateBase == null) {
      return;
    }
    localProfileTemplateBase.h(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoManagerImpl
 * JD-Core Version:    0.7.0.1
 */