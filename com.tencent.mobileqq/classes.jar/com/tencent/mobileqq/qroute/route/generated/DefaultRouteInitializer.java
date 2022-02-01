package com.tencent.mobileqq.qroute.route.generated;

import com.tencent.mobileqq.qroute.route.BaseRouteInitializer;

public class DefaultRouteInitializer
  extends BaseRouteInitializer
{
  public void init()
  {
    register("com.tencent.mobileqq.activity.AboutActivity$RouteInit");
    register("/base/subAccount/bind", "com.tencent.mobileqq.activity.SubAccountBindActivity");
    register("/pubaccount/browser", "com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl");
    register("/base/gesturePwdUnlock", "com.tencent.mobileqq.activity.GesturePWDUnlockActivity");
    register("/base/safe/loginInfo", "com.tencent.mobileqq.activity.LoginInfoActivity");
    register("/base/payBridge", "com.tencent.mobileqq.activity.PayBridgeActivity");
    register("/base/face2faceDiscussion", "com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity");
    register("/vas/h5pay", "com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity");
    register("/base/connectface/legacy", "com.tencent.mobileqq.activity.QQIdentiferLegacyActivity");
    register("/qwallet/tenpay/full", "com.qwallet.temp.impl.QWalletFullWindowActivity");
    register("/business/shortvideoplay", "com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity");
    register("/base/activity/AddFriendActivity", "com.tencent.mobileqq.activity.AddFriendActivity");
    register("/base/subAccount/ug", "com.tencent.mobileqq.activity.SubAccountUgActivity");
    register("/base/safe/devRenameActivity", "com.tencent.mobileqq.activity.AuthDevRenameActivity");
    register("/base/browser", "com.tencent.mobileqq.activity.QQBrowserActivity");
    register("/gvideo/plugin/installer", "cooperation.groupvideo.GVideoPluginInstallerActivity");
    register("/expand/activity", "com.tencent.mobileqq.qqexpand.fragment.ExpandPublicFragmentActivity");
    register("/base/safe/authDevActivity", "com.tencent.mobileqq.activity.AuthDevActivity");
    register("/nearby/guide", "com.tencent.mobileqq.nearby.guide.NearbyGuideActivity");
    register("/base/safe/registerByNickAndPwd", "com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity");
    register("/base/album/photopreview", "com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity");
    register("/base/register/registerPhoneNumber", "com.tencent.mobileqq.activity.RegisterPhoneNumActivity");
    register("/base/activity/FavEmosmManageActivity", "com.tencent.mobileqq.activity.FavEmosmManageActivity");
    register("/base/selectMember", "com.tencent.mobileqq.selectmember.SelectMemberActivity");
    register("/base/activity/ScanTorchActivity", "com.tencent.mobileqq.olympic.activity.ScanTorchActivity");
    register("/nearby/msgbox/list", "com.tencent.mobileqq.dating.MsgBoxListActivity");
    register("/nearby/choose/interesttag", "com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity");
    register("/base/activity/QQGamePubAccountActivity", "com.tencent.mobileqq.activity.QQGamePubAccountActivity");
    register("/base/activity/associatedAccountManage", "com.tencent.mobileqq.activity.AssociatedAccountManageActivity");
    register("/base/notification", "com.tencent.mobileqq.activity.NotificationActivity");
    register("/gvideo/translucent/browser", "cooperation.groupvideo.GVideoTranslucentBrowerActivity");
    register("/base/start/splash", "com.tencent.mobileqq.activity.SplashActivity");
    register("/base/install", "com.tencent.mobileqq.activity.InstallActivity");
    register("/qwallet/redpacket/sendhb", "com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity");
    register("/base/activity/GameCenterActivity", "com.tencent.gamecenter.activities.GameCenterActivity");
    register("/share/toqq/activity", "com.tencent.mobileqq.intervideo.now.ShareToQQActivity");
    register("/qwallet/transaction", "com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity");
    register("/base/login/authDevVerifyCode", "com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity");
    register("/base/connectface/identity", "com.tencent.mobileqq.activity.QQIdentiferActivity");
    register("/nearby/gameroom/invite", "com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity");
    register("/business/dov/editPic", "com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity");
    register("/base/activity/ChatActivity", "com.tencent.mobileqq.activity.ChatActivity");
    register("/qrscan/scanner", "com.tencent.mobileqq.qrscan.activity.ScannerActivity");
    register("/base/login", "com.tencent.mobileqq.activity.LoginActivity");
    register("/base/switchAccount", "com.tencent.open.agent.SwitchAccountActivity");
    register("/nearby/profile/pic/browser", "com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity");
    register("/base/qqmap", "com.tencent.mobileqq.activity.QQMapActivity");
    register("/base/activity/editInfoActivity", "com.tencent.mobileqq.troop.activity.editinfo.EditInfoActivity");
    register("/base/login/authDevVerifyCodeOpenSdk", "com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2");
    register("/base/troop/activity/TroopAvatarWallPreviewActivity", "com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity");
    register("/base/verifyCode", "com.tencent.mobileqq.activity.VerifyCodeActivity");
    register("/troop/memberlist/TroopMemberList", "com.tencent.mobileqq.activity.TroopMemberListActivity");
    register("/base/jump", "com.tencent.mobileqq.activity.JumpActivity");
    register("/base/activity/EmosmActivity", "com.tencent.mobileqq.activity.EmosmActivity");
    register("/nearby/gameroom/trans", "com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity");
    register("/qwallet/redpacket/QrcodeHbGuider", "com.tencent.mobileqq.qwallet.hb.send.impl.QrcodeHbGuiderActivity");
    register("/cmshow/store/floatActivity", "com.tencent.mobileqq.apollo.store.ApolloFloatActivity");
    register("/business/avgame/avgameactivity", "com.tencent.avgame.ui.AVGameActivity");
    register("/nearby/activity", "com.tencent.mobileqq.activity.NearbyActivity");
    register("/pubaccount/detail", "com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl");
    register("/base/activity/associatedAccount", "com.tencent.mobileqq.activity.AssociatedAccountActivity");
    register("/base/forwardRecent", "com.tencent.mobileqq.activity.ForwardRecentActivity");
    register("/cmshow/store/guestStateActivity", "com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity");
    register("/qwallet/tenpay/jump", "com.tencent.mobileqq.qwallet.impl.TenpayJumpActivity");
    register("/base/safe/loginPhoneNumActivity", "com.tencent.mobileqq.activity.LoginPhoneNumActivity");
    register("/base/forwardRecentTrans", "com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity");
    register("/base/album/photolist", "com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity");
    register("/base/addAccount", "com.tencent.mobileqq.activity.AddAccountActivity");
    register("/base/album/shortvideopreview", "com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity");
    register("/base/connectAgent", "com.tencent.open.agent.AgentActivity");
    register("/base/safe/authDevOpenActivity", "com.tencent.mobileqq.activity.AuthDevOpenUgActivity");
    register("/base/vipcomic", "com.tencent.comic.VipComicJumpActivity");
    register("/base/openSdkLogin", "com.tencent.qqconnect.wtlogin.Login");
    register("/nearby/people/profile", "com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity");
    register("/base/phoneUnityBindInfo", "com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.generated.DefaultRouteInitializer
 * JD-Core Version:    0.7.0.1
 */