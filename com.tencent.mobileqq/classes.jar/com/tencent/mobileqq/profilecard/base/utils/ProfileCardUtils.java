package com.tencent.mobileqq.profilecard.base.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMedalWallEntryInfo;
import com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMetalWallUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ProfileCardUtils
{
  private static final String TAG = "ProfileCardUtils";
  
  public static Uri enterSnapshot(Activity paramActivity, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {
      return null;
    }
    if (AudioUtil.a(0))
    {
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131698511), paramActivity.getString(2131698512), new ProfileCardUtils.1(), null).show();
      return null;
    }
    if (QQAudioHelper.a(0))
    {
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131698511), paramActivity.getString(2131698513), new ProfileCardUtils.2(), null).show();
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString()));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("photo/");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(".jpg");
    Object localObject2 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    localObject1 = new Intent();
    localObject2 = FileProvider7Helper.setSystemCapture(paramActivity, new File((String)localObject2), (Intent)localObject1);
    ((Intent)localObject1).putExtra("android.intent.extra.videoQuality", 100);
    paramActivity.startActivityForResult((Intent)localObject1, paramInt);
    return localObject2;
  }
  
  public static String getProfileDetailUrl(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null) && (!TextUtils.isEmpty(paramProfileCardInfo.allInOne.uin))) {
      return getProfileDetailUrl(paramProfileCardInfo.allInOne.uin, paramQQAppInterface.getAppid(), "android-8.7.0", paramProfileCardInfo.troopUin, ProfileMetalWallUtils.getProfileMetalWallEntryInfo(paramQQAppInterface, paramProfileCardInfo));
    }
    return null;
  }
  
  public static String getProfileDetailUrl(String paramString1, int paramInt, String paramString2, String paramString3, ProfileMedalWallEntryInfo paramProfileMedalWallEntryInfo)
  {
    paramString1 = String.format("https://ti.qq.com/qcard/profile?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("&troopUin=");
      paramString2.append(paramString3);
      paramString2 = paramString2.toString();
    }
    paramString1 = paramString2;
    if (ProfileCardUtil.a())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("&intl=1");
      paramString1 = paramString1.toString();
    }
    paramString2 = paramString1;
    if (paramProfileMedalWallEntryInfo != null)
    {
      paramString2 = paramString1;
      if (paramProfileMedalWallEntryInfo.showMetalWall)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&mwentry=1");
        paramString2 = paramString2.toString();
      }
      paramString1 = paramString2;
      if (paramProfileMedalWallEntryInfo.hasRedPoint)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString2);
        paramString1.append("&mwredpoint=1");
        paramString1 = paramString1.toString();
      }
      paramString2 = paramString1;
      if (paramProfileMedalWallEntryInfo.redPointCount > 1)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&mwredpointnum=");
        paramString2.append(paramProfileMedalWallEntryInfo.redPointCount);
        paramString2 = paramString2.toString();
      }
    }
    return paramString2;
  }
  
  public static boolean isDefaultProfile(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramProfileCardInfo != null)
    {
      bool1 = bool2;
      if (paramProfileCardInfo.curUseStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void notifyUser(int paramInt1, int paramInt2)
  {
    notifyUser(paramInt1, BaseApplication.getContext().getString(paramInt2));
  }
  
  public static void notifyUser(int paramInt, String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).a();
  }
  
  public static void openProfileEdit(AppInterface paramAppInterface, Activity paramActivity, ProfileCardInfo paramProfileCardInfo)
  {
    if ((paramAppInterface != null) && (paramActivity != null))
    {
      if (paramProfileCardInfo == null) {
        return;
      }
      BusinessCard localBusinessCard = BusinessCardUtils.a(paramAppInterface, paramProfileCardInfo);
      paramAppInterface = ProfileCardUtil.a(new Intent(paramActivity, FriendProfileMoreInfoActivity.class), paramProfileCardInfo.allInOne.uin, paramAppInterface, paramProfileCardInfo.allInOne, localBusinessCard);
      paramAppInterface.putExtra("profile_entry_type", paramProfileCardInfo.allInOne.profileEntryType);
      paramAppInterface.putExtra("troopUin", paramProfileCardInfo.troopUin);
      paramAppInterface.putExtra("memberUin", paramProfileCardInfo.allInOne.uin);
      paramAppInterface.putExtra("isTroopMemberCard", paramProfileCardInfo.isTroopMemberCard);
      paramActivity.startActivityForResult(paramAppInterface, 1022);
    }
  }
  
  public static void setNightModeFilterForDrawable(AppInterface paramAppInterface, Drawable paramDrawable)
  {
    if ((paramAppInterface != null) && (paramDrawable != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface))
      {
        paramDrawable.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      paramDrawable.clearColorFilter();
    }
  }
  
  public static void setNightModeFilterForImageView(AppInterface paramAppInterface, ImageView paramImageView)
  {
    if ((paramAppInterface != null) && (paramImageView != null))
    {
      if (ThemeUtil.isInNightMode(paramAppInterface))
      {
        paramImageView.setColorFilter(1996488704);
        return;
      }
      paramImageView.setColorFilter(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils
 * JD-Core Version:    0.7.0.1
 */