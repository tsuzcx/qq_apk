package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import com.tencent.aiosharemusic.AioShareMusicPlugin;
import com.tencent.av.wtogether.util.WTBusinessForWebPlugin;
import com.tencent.avgame.gameresult.AVGameResultRoomWebViewPlugin;
import com.tencent.biz.coupon.CouponInterface;
import com.tencent.biz.eqq.EqqWebviewPlugin;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.lebasearch.LebaPlugin;
import com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountWebviewPluginImpl;
import com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin;
import com.tencent.biz.pubaccount.readinjoyAd.ad.plugin.ReadinjoyAdWebviewPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.biz.subscribe.SubscribeJsPlugin;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.tribe.TribeWebViewPlugin;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.webviewplugin.ARJsApiPlugin;
import com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin;
import com.tencent.biz.webviewplugin.AccountReleasePlugin;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.biz.webviewplugin.GamePartyPlugin;
import com.tencent.biz.webviewplugin.HbEventPlugin;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.biz.webviewplugin.LocationPlugin;
import com.tencent.biz.webviewplugin.NearbyTroopsPlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenAppDetailPlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.PubAccountMailJsPlugin;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.biz.webviewplugin.PubAccountUIPlugin;
import com.tencent.biz.webviewplugin.QZoneTihSettingWebPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.SSOWebviewPlugin;
import com.tencent.biz.webviewplugin.SecurityVerifyPlugin;
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI;
import com.tencent.biz.webviewplugin.TroopRobotPlugin;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;
import com.tencent.device.utils.QQConnectPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.gdtad.web.GdtWebReportPlugin;
import com.tencent.mobileqq.activity.bless.BlessJsApiPlugin;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactSecCheckWebPlugin;
import com.tencent.mobileqq.activity.contact.addcontact.InvitationWebViewPlugin;
import com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.activity.weather.webpage.WeatherWebViewPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin;
import com.tencent.mobileqq.ark.browser.ArkPlugin;
import com.tencent.mobileqq.ark.security.ArkSecurityWebViewPlugin;
import com.tencent.mobileqq.campuscircle.CampusCirclePlugin;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.emotionintegrate.EmoticonPlugin;
import com.tencent.mobileqq.extendfriend.ExtendFriendWebViewPlugin;
import com.tencent.mobileqq.gamecenter.util.GameCenterInterruptPlugin;
import com.tencent.mobileqq.gamecenter.web.QQGameWebViewJsPlugin;
import com.tencent.mobileqq.imaxad.ImaxAdSharePlugin;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.mobileqq.intervideo.od.ODAppJSPlugin;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessForWebPlugin;
import com.tencent.mobileqq.intimate.IntimatePlugin;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import com.tencent.mobileqq.jsp.AVGameShareJsApiPlugin;
import com.tencent.mobileqq.jsp.AccountsPlugin;
import com.tencent.mobileqq.jsp.ConnectApiPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.jsp.DeviceProtectJsApiPlugin;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.FriendApiPlugin;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin;
import com.tencent.mobileqq.jsp.KdSearchResultApiPlugin;
import com.tencent.mobileqq.jsp.LiveRoomBusinessPlugin;
import com.tencent.mobileqq.jsp.LoginPlugin;
import com.tencent.mobileqq.jsp.MedalApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.MixSearchApiPlugin;
import com.tencent.mobileqq.jsp.PushApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.mobileqq.jsp.RegisterPlugin;
import com.tencent.mobileqq.jsp.SmsApiPlugin;
import com.tencent.mobileqq.jsp.StudyRoomJsPlugin;
import com.tencent.mobileqq.jsp.TeleScreenApiPlugin;
import com.tencent.mobileqq.jsp.TroopApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.UniteSearchApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.jsp.WeiBoSharePlugin;
import com.tencent.mobileqq.jsp.X5ApiPlugin;
import com.tencent.mobileqq.jubao.JubaoApiPlugin;
import com.tencent.mobileqq.listentogether.ListenTogetherPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewJsPlugin;
import com.tencent.mobileqq.msgforward.MsgforwardWXWebViewPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.nearby.MatchMakerPlugin;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.profile.HistoryHeadWebViewPlugin;
import com.tencent.mobileqq.profile.PersonalityLabel.BroadCastPlugin;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.ProfileThirdWebviewPlugin;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qcircle.api.hybird.QCircleJsPlugin;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.realname.GetAreaCodeWebviewPlugin;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.relationx.friendclue.FriendClueApiPlugin;
import com.tencent.mobileqq.remind.RemindJavascriptInterface;
import com.tencent.mobileqq.richstatus.JumpProfilePlugin;
import com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin;
import com.tencent.mobileqq.splashad.SplashADWebPlugin;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin;
import com.tencent.mobileqq.troop.honor.TroopInteractionIconPlugin;
import com.tencent.mobileqq.troop.jsp.TroopAppPanelJsPlugin;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceJsPlugin;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthPathTracePlugin;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubPageUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonHbJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.RegLiangHaoJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.video.VipVideoApiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftPlugin;
import com.tencent.mobileqq.webview.WebForceHttpsPlugin;
import com.tencent.mobileqq.webview.WebSecurityPluginV2;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.mobileqq.wholepeople.WholePeoplePlugin;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPlugin;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.emoticon.VipComicEmoticonJsPlugin;
import cooperation.comic.jsp.QQComicJsPlugin;
import cooperation.qqreader.js.ReaderJsPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.GDTReportPlugin;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.famous.QZoneFamousUserHomeJsPlugin;
import cooperation.qzone.webviewplugin.mood.QzoneSelectMoodPictureJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.vip.web.VasAdvWebPlugin;
import cooperation.weiyun.WeiyunJsPlugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class WebViewPluginFactory
{
  @ConfigInject(configPath="/Business/webview/src/main/resources/Inject_business_webviewplugin_map.yml", version=3)
  public static final HashMap<String, Class<? extends WebViewPlugin>> a = new HashMap();
  static final HashMap<Class<? extends WebViewPlugin>, Integer> b;
  
  static
  {
    a.put("forceHttps", WebForceHttpsPlugin.class);
    a.put("gameCenter", GameCenterInterruptPlugin.class);
    a.put("register", RegisterPlugin.class);
    a.put("lightapp", ArkPlugin.class);
    a.put("ArkSecurity", ArkSecurityWebViewPlugin.class);
    a.put("splashADPlugin", SplashADWebPlugin.class);
    a.put("VipTroopUpgradePlugin", VipTroopUpgradePlugin.class);
    a.put("ShareApiPlugin", ShareApiPlugin.class);
    a.put("ftssearch", UniteSearchApiPlugin.class);
    a.put("JSTypeface", ReaderJsPlugin.class);
    a.put("comic", QQComicJsPlugin.class);
    a.put("RealName", GetAreaCodeWebviewPlugin.class);
    a.put("allpeoplevote", WholePeoplePlugin.class);
    a.put("publicAccountNew", PublicAccountH5AbilityPluginImpl.class);
    a.put("signIn", DailySignInWebviewPlugin.class);
    a.put("vipclub", VipClubJsPlugin.class);
    a.put("funCall", VipFunCallJsPlugin.class);
    a.put("aecamera", AECameraPlugin.class);
    a.put("Troop", TroopWebviewPlugin.class);
    a.put("pubAccountUI", PubAccountUIPlugin.class);
    a.put("debug", VasWebReport.class);
    a.put("gameTeam", GamePartyPlugin.class);
    a.put("CAPTCHA", MQPSecJsPlugin.class);
    a.put("medalwall", MedalApiPlugin.class);
    a.put("QzoneUpload", QZoneWebViewPlugin.class);
    a.put("nowlive", NowWebViewPlugin.class);
    a.put("QzoneAudio", QZoneWebViewPlugin.class);
    a.put("Qzone", QZoneWebViewPlugin.class);
    a.put("qw_debug", VasCommonJsPlugin.class);
    a.put("media", MediaApiPlugin.class);
    a.put("haomaReg", RegLiangHaoJsPlugin.class);
    a.put("SwiftHttp", SonicJsPlugin.class);
    a.put("ppreloader", VipComicJsPlugin.class);
    a.put("aioShareMusic", AioShareMusicPlugin.class);
    a.put("interactionScore", IntimatePlugin.class);
    a.put("ReadinjoyAdJs", ReadinjoyAdWebviewPlugin.class);
    a.put("sensor", ARTransparentWebviewPlugin.class);
    a.put("QzMoodSelectPicture", QzoneSelectMoodPictureJsPlugin.class);
    a.put("background", QQAioBackgroundPlugin.class);
    a.put("tribe", TribeWebViewPlugin.class);
    a.put("newerguide", NewerGuidePlugin.class);
    a.put("GdtWebReportPlugin", GdtWebReportPlugin.class);
    a.put("webRecord", WebRecordApiPlugin.class);
    a.put("babyQ", BabyQFriendStatusWebViewPlugin.class);
    a.put("MixSearchWeb", MixSearchApiPlugin.class);
    a.put("studyroom", StudyRoomJsPlugin.class);
    a.put("avgame_result", AVGameResultRoomWebViewPlugin.class);
    a.put("qlbq", QLBQJsPlugin.class);
    a.put("GCApi", GameCenterAPIJavaScript.class);
    a.put("localData", LocalDataJsPlugin.class);
    a.put("qw.pay", QWalletPayJsPlugin.class);
    a.put("ReportPlugin", ReportPlugin.class);
    a.put("avgame", AVGameShareJsApiPlugin.class);
    a.put("qutu", FunnyPicJsPlugin.class);
    a.put("SocialWeekly", SocialWeeklyWebViewPlugin.class);
    a.put("JSPublicAccount\"", ReaderJsPlugin.class);
    a.put("troop_member_level_JS_API", TroopMemberLevelJSAPI.class);
    a.put("sign", SignJsPlugin.class);
    a.put("JSBookDir", ReaderJsPlugin.class);
    a.put("emoji", EmojiJsPlugin.class);
    a.put("data", DataApiPlugin.class);
    a.put("mail", PubAccountMailJsPlugin.class);
    a.put("EquipLockManager", MQPSecJsPlugin.class);
    a.put("4194304", ColorRingUIPlugin.class);
    a.put("Weiyun", WeiyunJsPlugin.class);
    a.put("qw_bluetooth", QWalletBluetoothJsPlugin.class);
    a.put("redpoint", RedTouchWebviewHandler.class);
    a.put("accounts", AccountsPlugin.class);
    a.put("QQConnect", QQConnectPlugin.class);
    a.put("individualRedPacket", IndividualRedPacketJsPlugin.class);
    a.put("specialRing", VipSpecialSoundWebViewPlugin.class);
    a.put("extendFriend", ExtendFriendWebViewPlugin.class);
    a.put("usersummary", ProfileThirdWebviewPlugin.class);
    a.put("deviceProtect", DeviceProtectJsApiPlugin.class);
    a.put("apolloGame", ApolloGamePlugin.class);
    a.put("historyhead", HistoryHeadWebViewPlugin.class);
    a.put("bless", BlessJsApiPlugin.class);
    a.put("chatBg", ChatBackgroundJsPlugin.class);
    a.put("pubAccountPreload", PubAccountPreloadPlugin.class);
    a.put("WebViewJumpPlugin", WebViewJumpPlugin.class);
    a.put("homework", TroopHWJsPlugin.class);
    a.put("coupon", CouponInterface.class);
    a.put("qbizApi", SensorAPIJavaScript.class);
    a.put("JSToast", ReaderJsPlugin.class);
    a.put("emoticon", EmoticonPlugin.class);
    a.put("qqgame_api", QQGameWebViewJsPlugin.class);
    a.put("wadl_download", WadlWebViewJsPlugin.class);
    a.put("event", EventApiPlugin.class);
    a.put("theme", ThemeJsPlugin.class);
    a.put("share", WeiBoSharePlugin.class);
    a.put("faceAddon", AvatarPendantJsPlugin.class);
    a.put("sms", SmsApiPlugin.class);
    a.put("GroupAppPanel", TroopAppPanelJsPlugin.class);
    a.put("bubble", BubbleJsPlugin.class);
    a.put("qw_mix", QWalletMixJsPlugin.class);
    a.put("QZFamousUserHome", QZoneFamousUserHomeJsPlugin.class);
    a.put("login", LoginPlugin.class);
    a.put("JSContent", ReaderJsPlugin.class);
    a.put("healthkit", HealthStepCounterPlugin.class);
    a.put("eqq", EqqWebviewPlugin.class);
    a.put("QQApi", QQApiPlugin.class);
    a.put("qidian", QidianWpaWebviewPlugin.class);
    a.put("JSTittlebarAction", ReaderJsPlugin.class);
    a.put("JD_REPORT", BusinessReportPlugin.class);
    a.put("card", ProfileCardWebviewPlugin.class);
    a.put("arcard", ARJsApiPlugin.class);
    a.put("miniApp", MiniAppPlugin.class);
    a.put("readInJoyWebRender", ReadInJoyWebRenderPlugin.class);
    a.put("JSRoot", ReaderJsPlugin.class);
    a.put("healthpathtrace", HealthPathTracePlugin.class);
    a.put("push", PushApiPlugin.class);
    a.put("apollo", ApolloJsPluginImpl.class);
    a.put("QQVIPFunction", VipFunctionJsPlugin.class);
    a.put("65536", HealthUiPlugin.class);
    a.put("qzlive", QZoneWebViewPlugin.class);
    a.put("gdtReportPlugin", GDTReportPlugin.class);
    a.put("262144", SuitUIPlugin.class);
    a.put("troopApi", TroopApiPlugin.class);
    a.put("PtloginPlugin", PtloginPlugin.class);
    a.put("weather", WeatherWebViewPlugin.class);
    a.put("healthSport", HealthBusinessPlugin.class);
    a.put("Gdt", TeleScreenApiPlugin.class);
    a.put("512", AvatarPendantUiPlugin.class);
    a.put("userVerify", SecurityVerifyPlugin.class);
    a.put("groupInteractionIcon", TroopInteractionIconPlugin.class);
    a.put("nearby", NearbyJsInterface.class);
    a.put("huayang", HuayangJsPlugin.class);
    a.put("minigame_api", MiniGamePublicAccountWebViewJsPlugin.class);
    a.put("PublicAccountJs", PublicAccountWebviewPluginImpl.class);
    a.put("gift", VipGiftPlugin.class);
    a.put("faceUnblockCamera", FaceUnblockCameraJsApiPlugin.class);
    a.put("location", LocationPlugin.class);
    a.put("comicFavor", VipComicEmoticonJsPlugin.class);
    a.put("qqexplive", QZoneWebViewPlugin.class);
    a.put("c2c_together_business", WTBusinessForWebPlugin.class);
    a.put("qzcardstorre", QZonePersonalizePlugin.class);
    a.put("ptv", ShortVideoJsApiPlugin.class);
    a.put("33554432", ChatBackgroundUiPlugin.class);
    a.put("praise", PraiseJsPlugin.class);
    a.put("jubao", JubaoApiPlugin.class);
    a.put("QzoneData", QzoneWebViewOfflinePlugin.class);
    a.put("qsubscribe", SubscribeJsPlugin.class);
    a.put("1048576", IndividuationUIPlugin.class);
    a.put("lebaPlugin", LebaPlugin.class);
    a.put("QZImagePicker", QZoneWebViewPlugin.class);
    a.put("URL_CHECK", UrlCheckPlugin.class);
    a.put("REMIND", RemindJavascriptInterface.class);
    a.put("common", ThemeAndBubbleCommonJsPlugin.class);
    a.put("accountRelease", AccountReleasePlugin.class);
    a.put("groupVideo", GVideoWebPlugin.class);
    a.put("GiftJsPlugin", GiftJsPlugin.class);
    a.put("video", VipVideoApiPlugin.class);
    a.put("qw_charge", QWalletCommonJsPlugin.class);
    a.put("readonline", ReaderJsPlugin.class);
    a.put("redEnvelope", HbEventPlugin.class);
    a.put("emojiEggSetting", IntimatePlugin.class);
    a.put("JSPopupList", ReaderJsPlugin.class);
    a.put("64", BubbleUiPlugin.class);
    a.put("x5", X5ApiPlugin.class);
    a.put("recallFriend", FriendClueApiPlugin.class);
    a.put("NearbyTroopsPlugin", NearbyTroopsPlugin.class);
    a.put("publicAccount", PublicAccountJavascriptInterfaceImpl.class);
    a.put("qqmusic", MusicGeneWebViewPlugin.class);
    a.put("qq_gdt_ad", GdtAdWebPlugin.class);
    a.put("levelicon", QQLevelJsPlugin.class);
    a.put("qqreader", QQReaderJsPlugin.class);
    a.put("pay", PayJsPlugin.class);
    a.put("JSPay", ReaderJsPlugin.class);
    a.put("together_business", TogetherBusinessForWebPlugin.class);
    a.put("hotchat", HotchatPlugin.class);
    a.put("sayHonest", ConfessPlugin.class);
    a.put("sonic", SonicJsPlugin.class);
    a.put("newLogin", InvitationWebViewPlugin.class);
    a.put("robotsummary", TroopRobotPlugin.class);
    a.put("addContact_SecCheck", AddContactSecCheckWebPlugin.class);
    a.put("JSBookDetailForQQ", ReaderJsPlugin.class);
    a.put("profileJS", BroadCastPlugin.class);
    a.put("UrlSaveVerifyV2", WebSecurityPluginV2.class);
    a.put("readinjoy", ReadInJoyWebviewPlugin.class);
    a.put("ui", UiApiPlugin.class);
    a.put("kdSearchResult", KdSearchResultApiPlugin.class);
    a.put("QzAvatar", QZonePersonalizePlugin.class);
    a.put("QzFloat", QZonePersonalizePlugin.class);
    a.put("vasAdv", VasAdvWebPlugin.class);
    a.put("qw_pay", QWalletCommonHbJsPlugin.class);
    a.put("4096", ChatFontUiPlugin.class);
    a.put("story", QQStoryApiPlugin.class);
    a.put("font", ChatFontJsPlugin.class);
    a.put("starclub", StarJsPlugin.class);
    a.put("SetPwdJsInterface", MQPSecJsPlugin.class);
    a.put("listenTogether", ListenTogetherPlugin.class);
    a.put("msgForward", MsgforwardWXWebViewPlugin.class);
    a.put("campus_circle", CampusCirclePlugin.class);
    a.put("face", VasFaceJsPlugin.class);
    a.put("docx", DocxApiPlugin.class);
    a.put("openToAppDetail", OpenAppDetailPlugin.class);
    a.put("odapp", ODAppJSPlugin.class);
    a.put("calendar", RemindJavascriptInterface.class);
    a.put("32", ThemeUiPlugin.class);
    a.put("connect", ConnectApiPlugin.class);
    a.put("msgRoam", MessageRoamJsPlugin.class);
    a.put("troopAssistantFeeds", TroopAssistantFeedsJsHandler.class);
    a.put("QzonePlugin", QzonePlugin.class);
    a.put("diycard", ProfileDiyJsPlugin.class);
    a.put("individuation", IndividuationPlugin.class);
    a.put("historicalSig", JumpProfilePlugin.class);
    a.put("offline", OfflinePlugin.class);
    a.put("askanonymously", AskAnonymouslyApiPlugin.class);
    a.put("JSRedTouch", ReaderJsPlugin.class);
    a.put("kingCard", KingCardJsPlugin.class);
    a.put("WebSo", WebSoPlugin.class);
    a.put("qzui", QZoneWebViewPlugin.class);
    a.put("qq_imax_ad", ImaxAdSharePlugin.class);
    a.put("device", DeviceApiPlugin.class);
    a.put("nearbyXiangqin", MatchMakerPlugin.class);
    a.put("qw_data", VasCommonJsPlugin.class);
    a.put("vaslive", QQIliveJsPlugin.class);
    a.put("8", EmojiSubPageUiPlugin.class);
    a.put("4", EmojiSubHomeUiPlugin.class);
    a.put("colorScreen", ColorScreenJsPlugin.class);
    a.put("gflivesdk", LiveRoomBusinessPlugin.class);
    a.put("2", EmojiHomeUiPlugin.class);
    a.put("tribeVideoPlayer", TribeVideoPlugin.class);
    a.put("friendData", VasCommonJsPlugin.class);
    a.put("QzMusic", QzoneWebMusicJsPlugin.class);
    a.put("qw", WeizhengquanJsPlugin.class);
    a.put("InputClickEvent", AntiphingHandler.class);
    a.put("colorRing", ColorRingJsPlugin.class);
    a.put("JSTopRightButton", ReaderJsPlugin.class);
    a.put("qzDynamicAlbum", QZoneWebViewPlugin.class);
    a.put("JSbookshelf", ReaderJsPlugin.class);
    a.put("floatingWindow", FloatingScreenPlugin.class);
    a.put("identification", IdentificationApiPlugin.class);
    a.put("checkin", QZoneWebViewPlugin.class);
    a.put("friendApi", FriendApiPlugin.class);
    a.put("qztodayinhistory", QZoneTihSettingWebPlugin.class);
    a.put("sso", SSOWebviewPlugin.class);
    a.put("qcircle", QCircleJsPlugin.class);
    a.put("JSPublicAccountUtil", ReaderJsPlugin.class);
    a.put("qqcard", QQCardJsPlugin.class);
    a.put("TroopMemberApiPlugin", TroopMemberApiPlugin.class);
    a.put("QzCover", QZoneCoverStoreJsPlugin.class);
    a.put("troopNotice", TroopNoticeJsHandler.class);
    b = new HashMap();
    Iterator localIterator = a.entrySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (b.containsKey(((Map.Entry)localObject).getValue())) {
        break label3114;
      }
      HashMap localHashMap = b;
      localObject = ((Map.Entry)localObject).getValue();
      i += 1;
      localHashMap.put(localObject, Integer.valueOf(i));
    }
    label3114:
    for (;;)
    {
      break;
      return;
    }
  }
  
  static WebViewPlugin a(int paramInt)
  {
    Iterator localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Integer)((Map.Entry)localObject).getValue()).intValue() == paramInt) {
        try
        {
          localObject = (WebViewPlugin)((Class)((Map.Entry)localObject).getKey()).newInstance();
          return localObject;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("WebViewPluginFactory", 1, "createWebViewPlugin by index failed", localThrowable);
        }
      }
    }
    return null;
  }
  
  public static WebViewPlugin a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString)))
    {
      paramString = (Class)a.get(paramString);
      try
      {
        paramString = (WebViewPlugin)paramString.newInstance();
        return paramString;
      }
      catch (Throwable paramString)
      {
        QLog.e("WebViewPluginFactory", 1, "createWebViewPlugin By nameSpace Fail,", paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginFactory
 * JD-Core Version:    0.7.0.1
 */