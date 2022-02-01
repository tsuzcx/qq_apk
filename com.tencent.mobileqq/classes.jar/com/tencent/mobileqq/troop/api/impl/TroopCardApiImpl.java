package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.association.data.AssociatedTroopItem;
import com.tencent.mobileqq.troop.associations.TroopAssociationsUtil;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardResDownloadManager;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.ColorUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wifi.Base64;
import cooperation.zebra.ZebraPluginProxy;
import java.net.URL;
import mqq.app.AppRuntime;

public class TroopCardApiImpl
  implements ITroopCardApi
{
  public void ForwardSdkShareOption_startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ForwardSdkShareOption.a(paramActivity, paramBoolean, paramString1, paramLong, paramInt, paramString2);
  }
  
  public void FreezedLiangGroup(Activity paramActivity, Object paramObject)
  {
    Object localObject = (TroopInfoData)paramObject;
    boolean bool = TroopManager.LiangGroupHelper.c(((TroopInfoData)localObject).groupFreezeReason);
    int i;
    if (bool) {
      i = 15;
    } else {
      i = 8;
    }
    paramObject = VipUtils.a(0, i);
    if (((TroopInfoData)localObject).bOwner)
    {
      String str1 = ((TroopInfoData)localObject).troopUin;
      if (paramObject != null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = "";
      }
      String str2 = HardCodeUtil.a(2131715438);
      TroopCardApiImpl.1 local1 = new TroopCardApiImpl.1(this, bool);
      if (bool) {
        localObject = "0X800A57F";
      } else {
        localObject = "0X8009E38";
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(paramActivity, str1, paramObject, str2, local1, (String)localObject, i, bool);
      return;
    }
    VipUtils.a(paramActivity, bool);
  }
  
  public void JoinTroopSecurityTipsHelper_showTips(AppInterface paramAppInterface, int paramInt, long paramLong, Activity paramActivity)
  {
    JoinTroopSecurityTipsHelper.a((QQAppInterface)paramAppInterface, paramInt, paramLong, paramActivity);
  }
  
  public Intent addFriendLogicActivity_startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return AddFriendLogicActivity.a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public Intent addFriendLogicActivity_startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    return AddFriendLogicActivity.a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9);
  }
  
  public void addRecentTroopItemIntoRecentMsgList(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong)
  {
    ((TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, paramString2, paramLong);
  }
  
  public void addRecentTroopItemIntoRecentMsgList(AppRuntime paramAppRuntime, Object paramObject)
  {
    ((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).e((TroopInfo)paramObject);
  }
  
  public byte[] base64Decode(String paramString)
  {
    return Base64.a(paramString, 0);
  }
  
  public void bnrReport(AppInterface paramAppInterface, int paramInt)
  {
    BnrReport.a(paramAppInterface, paramInt);
  }
  
  public int[] buildCustomClipDecoderParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return URLDrawableDecodeHandler.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public Dialog createQuestionDialog(Activity paramActivity)
  {
    return ProfileGuideDialogUtils.a(paramActivity);
  }
  
  public void doReportTroop(Activity paramActivity, Object paramObject, AppInterface paramAppInterface)
  {
    TroopUtils.a((QBaseActivity)paramActivity, (TroopInfoData)paramObject, (QQAppInterface)paramAppInterface);
  }
  
  public Bitmap exifBitmapCreator_createBitmap(Bitmap paramBitmap, String paramString)
  {
    return ((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(paramString, paramBitmap);
  }
  
  public Intent getChatActivityIntent(Activity paramActivity, int paramInt)
  {
    if (paramInt == 30) {
      return new Intent(paramActivity, ChatActivity.class);
    }
    return new Intent(paramActivity, SplashActivity.class);
  }
  
  public String getFriendDisplayName(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.d((QQAppInterface)paramAppInterface, paramString);
  }
  
  public void getFriendInfo(AppInterface paramAppInterface, String paramString)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString);
  }
  
  public Object getHighwayConfig()
  {
    return FMTSrvAddrProvider.getInstance().getHighwayConfig();
  }
  
  public void getOpenID(AppInterface paramAppInterface, String paramString)
  {
    GetOpenID.a(((QQAppInterface)paramAppInterface).getMsgHandler(), paramString);
  }
  
  public Object getOpenIDFromCacheAndDB(AppInterface paramAppInterface, String paramString)
  {
    return ((QQAppInterface)paramAppInterface).getMsgHandler().a(paramString);
  }
  
  public Class<?> getTroopAdminListClass()
  {
    return TroopAdminList.class;
  }
  
  public Class<?> getTroopAvatarWallEditActivityClass()
  {
    return TroopAvatarWallEditActivity.class;
  }
  
  public String getTroopCardTipsContent(Context paramContext)
  {
    paramContext = paramContext.getString(2131719875);
    TroopGameCardConfig localTroopGameCardConfig = (TroopGameCardConfig)QConfigManager.a().a(695);
    if (localTroopGameCardConfig != null) {
      paramContext = localTroopGameCardConfig.c();
    }
    return paramContext;
  }
  
  public Class<?> getTroopClassChoiceActivtiyClass()
  {
    return TroopClassChoiceActivity.class;
  }
  
  public String getTroopGameCardResDownloadPath()
  {
    return TroopGameCardResDownloadManager.a();
  }
  
  public Class<?> getTroopTagViewActivityClass()
  {
    return TroopTagViewActivity.class;
  }
  
  public Object get_CUSTOM_CLIP_DECODER()
  {
    return URLDrawableDecodeHandler.w;
  }
  
  public void goToMsgList(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    paramActivity.startActivity(localIntent);
  }
  
  public void handleAppShareAction(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a(localIntent);
    ForwardUtils.a((QQAppInterface)paramAppRuntime, paramActivity, paramIntent, localIntent);
  }
  
  public void handleEditClosed(boolean paramBoolean, ImageView paramImageView, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      paramImageView = AnimationUtils.a(paramImageView);
      if (paramImageView != null) {
        paramBundle.putParcelable("KEY_THUMBNAL_BOUND", paramImageView);
      }
    }
  }
  
  public void handleGotoBigPic(Object paramObject, Context paramContext)
  {
    paramObject = (TroopInfoData)paramObject;
    boolean bool = TroopManager.LiangGroupHelper.c(paramObject.groupFreezeReason);
    if (paramObject.bOwner)
    {
      String str1 = paramObject.troopUin;
      int i;
      if (bool) {
        i = 15;
      } else {
        i = 8;
      }
      String str2 = VipUtils.a(0, i).toString();
      String str3 = HardCodeUtil.a(2131715438);
      TroopCardApiImpl.4 local4 = new TroopCardApiImpl.4(this, bool);
      if (bool) {
        paramObject = "0X800A57F";
      } else {
        paramObject = "0X8009E38";
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(paramContext, str1, str2, str3, local4, paramObject, i, bool);
      return;
    }
    VipUtils.a(paramContext, bool);
  }
  
  public void handleModiftyTroopHeadFreezed(Object paramObject, Context paramContext)
  {
    paramObject = (TroopInfoData)paramObject;
    boolean bool = TroopManager.LiangGroupHelper.c(paramObject.groupFreezeReason);
    if (paramObject.bOwner)
    {
      String str1 = paramObject.troopUin;
      int i;
      if (bool) {
        i = 15;
      } else {
        i = 8;
      }
      String str2 = VipUtils.a(0, i).toString();
      String str3 = HardCodeUtil.a(2131715234);
      TroopCardApiImpl.3 local3 = new TroopCardApiImpl.3(this, bool);
      if (bool) {
        paramObject = "0X800A57F";
      } else {
        paramObject = "0X8009E38";
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(paramContext, str1, str2, str3, local3, paramObject, i, bool);
      return;
    }
    VipUtils.a(paramContext, bool);
  }
  
  public void handleModifyNameFreezed(Object paramObject, Context paramContext)
  {
    paramObject = (TroopInfoData)paramObject;
    boolean bool = TroopManager.LiangGroupHelper.c(paramObject.groupFreezeReason);
    if (paramObject.bOwner)
    {
      String str1 = paramObject.troopUin;
      int i;
      if (bool) {
        i = 15;
      } else {
        i = 8;
      }
      String str2 = VipUtils.a(0, i).toString();
      String str3 = HardCodeUtil.a(2131701933);
      TroopCardApiImpl.2 local2 = new TroopCardApiImpl.2(this, bool);
      if (bool) {
        paramObject = "0X800A57F";
      } else {
        paramObject = "0X8009E38";
      }
      if (bool) {
        i = 1;
      } else {
        i = 2;
      }
      VipUtils.a(paramContext, str1, str2, str3, local2, paramObject, i, bool);
      return;
    }
    VipUtils.a(paramContext, bool);
  }
  
  public boolean isFastDoubleClick()
  {
    return UIUtils.b();
  }
  
  public boolean isGrayTroopForTroopGameCard(String paramString)
  {
    TroopGameCardConfig localTroopGameCardConfig = (TroopGameCardConfig)QConfigManager.a().a(695);
    return (localTroopGameCardConfig != null) && (localTroopGameCardConfig.a(paramString));
  }
  
  public boolean isInstanceOfTroopAvatarWallEditActivity(Activity paramActivity)
  {
    return paramActivity instanceof TroopAvatarWallEditActivity;
  }
  
  public void jionTroopFromTroopAssociation(Context paramContext, Object paramObject)
  {
    TroopAssociationsUtil.a(paramContext, (AssociatedTroopItem)paramObject);
  }
  
  public URL nearbyImgDownloader_convertURL(String paramString)
  {
    return NearbyImgDownloader.convertURL(paramString);
  }
  
  public boolean needAnswerQuestion(String paramString)
  {
    return ((IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(paramString);
  }
  
  public void openAddTroopWebInfo(Activity paramActivity, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("?_wv=1031&troopUin=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&isVerify=");
    localStringBuilder.append(0);
    paramString1 = localStringBuilder.toString();
    paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString2.putExtra("url", paramString1);
    paramString2.putExtra("hide_left_button", true);
    paramString2.putExtra("show_right_close_button", true);
    paramString2.putExtra("finish_animation_up_down", true);
    paramActivity.startActivity(paramString2);
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public void openTroopAssociationWebPage(Context paramContext, String paramString)
  {
    TroopAssociationsUtil.a(paramContext, paramString);
  }
  
  public void openTroopInfoFromTroopAssociation(Context paramContext, Object paramObject)
  {
    TroopAssociationsUtil.b(paramContext, (AssociatedTroopItem)paramObject);
  }
  
  public int parseColor(String paramString)
  {
    return ColorUtils.a(paramString);
  }
  
  public Uri profileCardUtils_enterSnapshot(Activity paramActivity, int paramInt)
  {
    return ProfileCardUtils.enterSnapshot(paramActivity, paramInt);
  }
  
  public void refreshTroopFace(AppInterface paramAppInterface, String paramString)
  {
    ((QQAppInterface)paramAppInterface).refreshTroopFace(paramString);
  }
  
  public void reportTask(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    new ReportTask((QQAppInterface)paramAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { paramString, String.valueOf(paramInt) }).a();
  }
  
  public void secRecognize(boolean paramBoolean, View paramView)
  {
    TroopUtils.a(paramBoolean, paramView);
  }
  
  public void setNightModeFilterForDrawable(AppInterface paramAppInterface, Drawable paramDrawable)
  {
    ProfileCardUtils.setNightModeFilterForDrawable(paramAppInterface, paramDrawable);
  }
  
  public void startModifyHomeworkTroopNickname(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HWTroopUtils.a(paramContext, paramString1, paramString2, paramString3);
  }
  
  public void startModifyLocationActivityForResultEx(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    TroopLocationModifyActivity.b(paramActivity, paramString1, paramString2, paramInt);
  }
  
  public void startPhotoEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    PhotoUtils.startPhotoEdit(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, paramString3);
  }
  
  public void startPhotoList(Activity paramActivity, Bundle paramBundle)
  {
    ZebraPluginProxy.startPhotoList(paramActivity, paramBundle);
  }
  
  public void startPhotoListEdit(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    PhotoUtils.startPhotoListEdit(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2);
  }
  
  public void storyReportor(Activity paramActivity)
  {
    int i = paramActivity.getIntent().getIntExtra("extra_share_group_from", 0);
    if (i != 0) {
      StoryReportor.a("story_grp", "clk_msg", i, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopCardApiImpl
 * JD-Core Version:    0.7.0.1
 */