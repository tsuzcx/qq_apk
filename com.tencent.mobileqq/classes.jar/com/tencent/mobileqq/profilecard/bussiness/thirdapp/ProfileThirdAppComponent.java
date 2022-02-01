package com.tencent.mobileqq.profilecard.bussiness.thirdapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.photo.SDKAvatarSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

public class ProfileThirdAppComponent
  extends AbsQQProfileComponent<View>
{
  private static final String TAG = "ProfileThirdAppComponent";
  private SDKAvatarSettingManager sdkAvatarSettingManager;
  private ShareAioResultDialog shareResultDlg = null;
  
  public ProfileThirdAppComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void initAvatarManager(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getBundleExtra("profile_extra");
      if ((localBundle != null) && (localBundle.getBoolean("key_from_sdk_set_avatar", false)))
      {
        this.sdkAvatarSettingManager = new SDKAvatarSettingManager(this.mActivity);
        this.sdkAvatarSettingManager.a(paramIntent);
        this.sdkAvatarSettingManager.a();
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileThirdAppComponent";
  }
  
  public int getComponentType()
  {
    return 1031;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1035)
    {
      SDKAvatarSettingManager localSDKAvatarSettingManager = this.sdkAvatarSettingManager;
      if (localSDKAvatarSettingManager != null) {
        localSDKAvatarSettingManager.a(paramInt2, paramIntent);
      }
    }
  }
  
  public boolean onBackPressed()
  {
    SDKAvatarSettingManager localSDKAvatarSettingManager = this.sdkAvatarSettingManager;
    if (localSDKAvatarSettingManager != null) {
      localSDKAvatarSettingManager.c();
    }
    return super.onBackPressed();
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    initAvatarManager(paramQBaseActivity.getIntent());
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    paramProfileCardInfo = this.shareResultDlg;
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.isShowing()) && (((ProfileCardInfo)this.mData).card != null))
    {
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.strReMark))
      {
        paramProfileCardInfo = this.shareResultDlg;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ProfileCardInfo)this.mData).card.strReMark);
        localStringBuilder.append(this.mActivity.getString(2131698641));
        paramProfileCardInfo.a(localStringBuilder.toString());
        return bool;
      }
      if (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).card.strNick))
      {
        paramProfileCardInfo = this.shareResultDlg;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ProfileCardInfo)this.mData).card.strNick);
        localStringBuilder.append(this.mActivity.getString(2131698641));
        paramProfileCardInfo.a(localStringBuilder.toString());
      }
    }
    return bool;
  }
  
  public void onDestroy()
  {
    Object localObject = this.sdkAvatarSettingManager;
    if (localObject != null) {
      ((SDKAvatarSettingManager)localObject).f();
    }
    localObject = this.shareResultDlg;
    if (localObject != null)
    {
      ((ShareAioResultDialog)localObject).dismiss();
      this.shareResultDlg = null;
    }
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (paramIntent != null)
    {
      localObject = (AllInOne)paramIntent.getParcelableExtra("AllInOne");
      if ((localObject != null) && (((AllInOne)localObject).profileEntryType == 115))
      {
        ((ProfileCardInfo)this.mData).allInOne = ((AllInOne)localObject);
        if (this.mDelegate != null) {
          this.mDelegate.requestUpdateCard();
        }
      }
    }
    Object localObject = this.sdkAvatarSettingManager;
    if (localObject == null)
    {
      initAvatarManager(paramIntent);
      return;
    }
    ((SDKAvatarSettingManager)localObject).b(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    if ((((ProfileCardInfo)this.mData).allInOne.profileEntryType == 115) && (AddFriendLogicActivity.b)) {
      qbShowShareResultDialog(this.mActivity.getIntent().getStringExtra("src_name"));
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ShareAioResultDialog localShareAioResultDialog = this.shareResultDlg;
    if ((localShareAioResultDialog != null) && (localShareAioResultDialog.isShowing()))
    {
      this.shareResultDlg.dismiss();
      this.shareResultDlg = null;
    }
  }
  
  void qbShowShareResultDialog(String paramString)
  {
    Object localObject = this.shareResultDlg;
    if ((localObject != null) && (!((ShareAioResultDialog)localObject).isShowing()))
    {
      this.shareResultDlg.show();
      return;
    }
    this.shareResultDlg = new ShareAioResultDialog(this.mActivity);
    this.shareResultDlg.a(this.mActivity.getString(2131698641));
    String str = this.mActivity.getString(2131718866);
    localObject = str;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new ProfileThirdAppComponent.1(this);
    this.shareResultDlg.a((String)localObject, paramString);
    this.shareResultDlg.a(paramString);
    this.shareResultDlg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.thirdapp.ProfileThirdAppComponent
 * JD-Core Version:    0.7.0.1
 */