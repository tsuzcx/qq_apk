package com.tencent.mobileqq.webview.swift;

import android.text.TextUtils;
import com.tencent.biz.coupon.CouponInterface;
import com.tencent.biz.eqq.EqqWebviewPlugin;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.lebasearch.LebaPlugin;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.pubaccount.PublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoyWebviewPlugin;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.troop.TroopMemberApiPlugin;
import com.tencent.biz.webviewplugin.ARJsApiPlugin;
import com.tencent.biz.webviewplugin.ARMapPlugin;
import com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.biz.webviewplugin.GamePartyPlugin;
import com.tencent.biz.webviewplugin.HbEventPlugin;
import com.tencent.biz.webviewplugin.HotchatPlugin;
import com.tencent.biz.webviewplugin.NearbyTroopsPlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
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
import com.tencent.biz.webviewplugin.ShareApiPlugin;
import com.tencent.biz.webviewplugin.TroopMemberLevelJSAPI;
import com.tencent.biz.webviewplugin.UrlCheckPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;
import com.tencent.device.utils.QQConnectPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.gdtad.jsbridge.GdtAdWebPlugin;
import com.tencent.mobileqq.activity.specialcare.VipSpecialSoundWebViewPlugin;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceJsPlugin;
import com.tencent.mobileqq.campuscircle.CampusCirclePlugin;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.now.NowWebViewPlugin;
import com.tencent.mobileqq.intervideo.od.ODAppJSPlugin;
import com.tencent.mobileqq.jsp.DataApiPlugin;
import com.tencent.mobileqq.jsp.DeviceApiPlugin;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.jsp.MedalApiPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.PlatoApiPlugin;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.jsp.QQStoryApiPlugin;
import com.tencent.mobileqq.jsp.SmsApiPlugin;
import com.tencent.mobileqq.jsp.TroopApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.UniteSearchApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.jsp.X5ApiPlugin;
import com.tencent.mobileqq.msgforward.MsgforwardWXWebViewPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import com.tencent.mobileqq.mybusiness.MyBusinessWebViewPlugin;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.profile.HistoryHeadWebViewPlugin;
import com.tencent.mobileqq.profile.PersonalityLabel.BroadCastPlugin;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.mobileqq.profile.ProfileThirdWebviewPlugin;
import com.tencent.mobileqq.qcall.RecentCallPluginInfo;
import com.tencent.mobileqq.realname.GetAreaCodeWebviewPlugin;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.remind.RemindJavascriptInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoJsApiPlugin;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.mobileqq.troop.browser.VipTroopUpgradePlugin;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vashealth.HealthPathTracePlugin;
import com.tencent.mobileqq.vashealth.HealthStepCounterPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
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
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQWiFiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.video.VipVideoApiPlugin;
import com.tencent.mobileqq.vipgift.VipGiftPlugin;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webviewplugin.SocialWeeklyWebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.mobileqq.wholepeople.WholePeoplePlugin;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import cooperation.comic.emoticon.VipComicEmoticonJsPlugin;
import cooperation.comic.jsp.QQComicJsPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.webviewplugin.GDTReportPlugin;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.famous.QZoneFamousUserHomeJsPlugin;
import cooperation.qzone.webviewplugin.mood.QzoneSelectMoodPictureJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizePlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.weiyun.WeiyunJsPlugin;
import java.util.HashMap;

public class WebViewPluginFactory
{
  public static final HashMap a = new HashMap();
  
  static
  {
    a.put("qbizApi", Integer.valueOf(3));
    a.put("coupon", Integer.valueOf(1));
    a.put("eqq", Integer.valueOf(2));
    a.put("lebaPlugin", Integer.valueOf(4));
    a.put("PublicAccountJs", Integer.valueOf(6));
    a.put("publicAccountNew", Integer.valueOf(7));
    a.put("TroopMemberApiPlugin", Integer.valueOf(8));
    a.put("gameTeam", Integer.valueOf(10));
    a.put("redEnvelope", Integer.valueOf(12));
    a.put("hotchat", Integer.valueOf(13));
    a.put("NearbyTroopsPlugin", Integer.valueOf(14));
    a.put("newerguide", Integer.valueOf(15));
    a.put("offline", Integer.valueOf(16));
    a.put("openToAppDetail", Integer.valueOf(17));
    a.put(PtloginPlugin.class.getSimpleName(), Integer.valueOf(20));
    a.put("mail", Integer.valueOf(21));
    a.put(QzonePlugin.a, Integer.valueOf(22));
    a.put("qztodayinhistory", Integer.valueOf(23));
    a.put("QzoneData", Integer.valueOf(24));
    a.put(ReportPlugin.a, Integer.valueOf(25));
    a.put("share", Integer.valueOf(26));
    a.put("UrlSaveVerify", Integer.valueOf(27));
    a.put("troop_member_level_JS_API", Integer.valueOf(30));
    a.put("URL_CHECK", Integer.valueOf(31));
    a.put("WebSo", Integer.valueOf(32));
    a.put("QQConnect", Integer.valueOf(33));
    a.put("GCApi", Integer.valueOf(34));
    a.put("specialRing", Integer.valueOf(35));
    a.put("InputClickEvent", Integer.valueOf(36));
    a.put("data", Integer.valueOf(38));
    a.put("x5", Integer.valueOf(166));
    a.put("device", Integer.valueOf(39));
    a.put("event", Integer.valueOf(40));
    a.put("media", Integer.valueOf(41));
    a.put("QQApi", Integer.valueOf(42));
    a.put("sms", Integer.valueOf(43));
    a.put("troopApi", Integer.valueOf(44));
    a.put("ui", Integer.valueOf(45));
    a.put("docx", Integer.valueOf(134));
    a.put("webRecord", Integer.valueOf(46));
    a.put("qqmusic", Integer.valueOf(47));
    a.put("mybusiness", Integer.valueOf(48));
    a.put("odapp", Integer.valueOf(49));
    a.put("huayang", Integer.valueOf(128));
    a.put("card", Integer.valueOf(50));
    a.put("usersummary", Integer.valueOf(131));
    a.put("signIn", Integer.valueOf(138));
    a.put("RealName", Integer.valueOf(95));
    a.put("RecentCall", Integer.valueOf(51));
    a.put("redpoint", Integer.valueOf(52));
    a.put("REMIND", Integer.valueOf(53));
    a.put("calendar", Integer.valueOf(53));
    a.put("ptv", Integer.valueOf(54));
    a.put("troopAssistantFeeds", Integer.valueOf(57));
    a.put("troopNotice", Integer.valueOf(58));
    a.put("healthSport", Integer.valueOf(59));
    a.put("healthkit", Integer.valueOf(60));
    a.put("healthpathtrace", Integer.valueOf(127));
    a.put("apollo", Integer.valueOf(61));
    a.put("faceAddon", Integer.valueOf(62));
    a.put("bubble", Integer.valueOf(64));
    a.put("colorScreen", Integer.valueOf(154));
    a.put("face", Integer.valueOf(159));
    a.put("praise", Integer.valueOf(141));
    a.put("diycard", Integer.valueOf(148));
    a.put("chatBg", Integer.valueOf(66));
    a.put("font", Integer.valueOf(68));
    a.put("colorRing", Integer.valueOf(70));
    a.put("emoji", Integer.valueOf(73));
    a.put("qutu", Integer.valueOf(77));
    a.put("individualRedPacket", Integer.valueOf(79));
    a.put("individuation", Integer.valueOf(80));
    a.put("msgRoam", Integer.valueOf(82));
    a.put("SetPwdJsInterface", Integer.valueOf(83));
    a.put("EquipLockManager", Integer.valueOf(83));
    a.put("CAPTCHA", Integer.valueOf(83));
    a.put("qqcard", Integer.valueOf(85));
    a.put("qw_qqwifi", Integer.valueOf(86));
    a.put("qqwifi", Integer.valueOf(87));
    a.put("qw_bluetooth", Integer.valueOf(156));
    a.put("qw_charge", Integer.valueOf(88));
    a.put("qw.pay", Integer.valueOf(89));
    a.put("starclub", Integer.valueOf(90));
    a.put("common", Integer.valueOf(92));
    a.put("theme", Integer.valueOf(93));
    a.put("qw_debug", Integer.valueOf(96));
    a.put("qw_data", Integer.valueOf(96));
    a.put("friendData", Integer.valueOf(96));
    a.put("debug", Integer.valueOf(97));
    a.put("ppreloader", Integer.valueOf(100));
    a.put("funCall", Integer.valueOf(101));
    a.put("QQVIPFunction", Integer.valueOf(102));
    a.put("video", Integer.valueOf(103));
    a.put("gift", Integer.valueOf(104));
    a.put(WebViewJumpPlugin.a, Integer.valueOf(106));
    a.put("comicFavor", Integer.valueOf(108));
    a.put("QzMusic", Integer.valueOf(111));
    a.put("Qzone", Integer.valueOf(112));
    a.put("qzDynamicAlbum", Integer.valueOf(112));
    a.put("QZImagePicker", Integer.valueOf(112));
    a.put("qzlive", Integer.valueOf(112));
    a.put("qzui", Integer.valueOf(112));
    a.put("QzoneUpload", Integer.valueOf(112));
    a.put("QzoneAudio", Integer.valueOf(112));
    a.put(QZoneFamousUserHomeJsPlugin.a, Integer.valueOf(113));
    a.put("QzMoodSelectPicture", Integer.valueOf(114));
    a.put("QzCover", Integer.valueOf(115));
    a.put("qzcardstorre", Integer.valueOf(116));
    a.put("QzAvatar", Integer.valueOf(116));
    a.put("QzFloat", Integer.valueOf(116));
    a.put("story", Integer.valueOf(121));
    a.put("homework", Integer.valueOf(117));
    a.put("publicAccount", Integer.valueOf(5));
    a.put("pay", Integer.valueOf(19));
    a.put("qw", Integer.valueOf(157));
    a.put(String.valueOf(2L), Integer.valueOf(72));
    a.put(String.valueOf(8L), Integer.valueOf(75));
    a.put(String.valueOf(512L), Integer.valueOf(63));
    a.put(String.valueOf(4096L), Integer.valueOf(69));
    a.put(String.valueOf(1048576L), Integer.valueOf(81));
    a.put(String.valueOf(65536L), Integer.valueOf(78));
    a.put(String.valueOf(262144L), Integer.valueOf(91));
    a.put(String.valueOf(33554432L), Integer.valueOf(67));
    a.put(String.valueOf(64L), Integer.valueOf(65));
    a.put(String.valueOf(32L), Integer.valueOf(94));
    a.put(String.valueOf(4L), Integer.valueOf(74));
    a.put(String.valueOf(4194304L), Integer.valueOf(71));
    a.put("Troop", Integer.valueOf(55));
    a.put("deviceapp", Integer.valueOf(118));
    a.put("qqreader", Integer.valueOf(119));
    a.put("sso", Integer.valueOf(29));
    a.put("nfc", Integer.valueOf(120));
    a.put("gdtReportPlugin", Integer.valueOf(122));
    a.put("pubAccountPreload", Integer.valueOf(125));
    a.put("medalwall", Integer.valueOf(124));
    a.put("pubAccountUI", Integer.valueOf(129));
    a.put("nearby", Integer.valueOf(126));
    a.put("armap", Integer.valueOf(130));
    a.put("sensor", Integer.valueOf(150));
    a.put("arcard", Integer.valueOf(164));
    a.put("sonic", Integer.valueOf(132));
    a.put("SwiftHttp", Integer.valueOf(132));
    a.put("Weiyun", Integer.valueOf(135));
    a.put("JD_REPORT", Integer.valueOf(133));
    a.put("readinjoy", Integer.valueOf(136));
    a.put("babyQ", Integer.valueOf(137));
    a.put("historyhead", Integer.valueOf(139));
    a.put("wadl_download", Integer.valueOf(140));
    a.put("comic", Integer.valueOf(142));
    a.put("campus_circle", Integer.valueOf(143));
    a.put("groupVideo", Integer.valueOf(144));
    a.put("qq_gdt_ad", Integer.valueOf(145));
    a.put("SocialWeekly", Integer.valueOf(146));
    a.put("msgForward", Integer.valueOf(147));
    a.put("profileJS", Integer.valueOf(149));
    a.put("nowlive", Integer.valueOf(152));
    a.put("sign", Integer.valueOf(151));
    a.put("localData", Integer.valueOf(153));
    a.put("qidian", Integer.valueOf(155));
    a.put("allpeoplevote", Integer.valueOf(158));
    a.put("ftssearch", Integer.valueOf(160));
    a.put("qlbq", Integer.valueOf(161));
    a.put("sayHonest", Integer.valueOf(162));
    a.put("readInJoyWebRender", Integer.valueOf(163));
    a.put("tribeVideoPlayer", Integer.valueOf(165));
    a.put("plato", Integer.valueOf(168));
    a.put("apolloGame", Integer.valueOf(167));
  }
  
  public static WebViewPlugin a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 11: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 25: 
    case 27: 
    case 28: 
    case 36: 
    case 37: 
    case 40: 
    case 76: 
    case 84: 
    case 97: 
    case 98: 
    case 99: 
    case 105: 
    case 107: 
    case 109: 
    case 110: 
    case 118: 
    case 123: 
    default: 
      return null;
    case 61: 
      return new ApolloJsPlugin();
    case 62: 
      return new AvatarPendantJsPlugin();
    case 63: 
      return new AvatarPendantUiPlugin();
    case 64: 
      return new BubbleJsPlugin();
    case 154: 
      return new ColorScreenJsPlugin();
    case 159: 
      return new VasFaceJsPlugin();
    case 65: 
      return new BubbleUiPlugin();
    case 141: 
      return new PraiseJsPlugin();
    case 66: 
      return new ChatBackgroundJsPlugin();
    case 67: 
      return new ChatBackgroundUiPlugin();
    case 68: 
      return new ChatFontJsPlugin();
    case 69: 
      return new ChatFontUiPlugin();
    case 70: 
      return new ColorRingJsPlugin();
    case 71: 
      return new ColorRingUIPlugin();
    case 1: 
      return new CouponInterface();
    case 38: 
      return new DataApiPlugin();
    case 166: 
      return new X5ApiPlugin();
    case 121: 
      return new QQStoryApiPlugin();
    case 39: 
      return new DeviceApiPlugin();
    case 72: 
      return new EmojiHomeUiPlugin();
    case 73: 
      return new EmojiJsPlugin();
    case 74: 
      return new EmojiSubHomeUiPlugin();
    case 75: 
      return new EmojiSubPageUiPlugin();
    case 2: 
      return new EqqWebviewPlugin();
    case 77: 
      return new FunnyPicJsPlugin();
    case 34: 
      return new GameCenterAPIJavaScript();
    case 10: 
      return new GamePartyPlugin();
    case 12: 
      return new HbEventPlugin();
    case 59: 
      return new HealthBusinessPlugin();
    case 60: 
      return new HealthStepCounterPlugin();
    case 127: 
      return new HealthPathTracePlugin();
    case 78: 
      return new HealthUiPlugin();
    case 13: 
      return new HotchatPlugin();
    case 79: 
      return new IndividualRedPacketJsPlugin();
    case 80: 
      return new IndividuationPlugin();
    case 81: 
      return new IndividuationUIPlugin();
    case 4: 
      return new LebaPlugin();
    case 83: 
      return new MQPSecJsPlugin();
    case 41: 
      return new MediaApiPlugin();
    case 82: 
      return new MessageRoamJsPlugin();
    case 47: 
      return new MusicGeneWebViewPlugin();
    case 135: 
      return new WeiyunJsPlugin();
    case 48: 
      return new MyBusinessWebViewPlugin();
    case 14: 
      return new NearbyTroopsPlugin();
    case 15: 
      return new NewerGuidePlugin();
    case 49: 
      return new ODAppJSPlugin();
    case 128: 
      return new HuayangJsPlugin();
    case 95: 
      return new GetAreaCodeWebviewPlugin();
    case 17: 
      return new OpenAppDetailPlugin();
    case 19: 
      return new PayJsPlugin();
    case 157: 
      return new WeizhengquanJsPlugin();
    case 50: 
      return new ProfileCardWebviewPlugin();
    case 131: 
      return new ProfileThirdWebviewPlugin();
    case 138: 
      return new DailySignInWebviewPlugin();
    case 21: 
      return new PubAccountMailJsPlugin();
    case 7: 
      return new PublicAccountH5AbilityPlugin();
    case 5: 
      return new PublicAccountJavascriptInterface();
    case 6: 
      return new PublicAccountWebviewPlugin();
    case 42: 
      return new QQApiPlugin();
    case 85: 
      return new QQCardJsPlugin();
    case 33: 
      return new QQConnectPlugin();
    case 87: 
      return new QQWIFIPlugin();
    case 86: 
      return new QQWiFiJsPlugin();
    case 156: 
      return new QWalletBluetoothJsPlugin();
    case 88: 
      return new QWalletCommonJsPlugin();
    case 89: 
      return new QWalletPayJsPlugin();
    case 115: 
      return new QZoneCoverStoreJsPlugin();
    case 113: 
      return new QZoneFamousUserHomeJsPlugin();
    case 116: 
      return new QZonePersonalizePlugin();
    case 23: 
      return new QZoneTihSettingWebPlugin();
    case 112: 
      return new QZoneWebViewPlugin();
    case 114: 
      return new QzoneSelectMoodPictureJsPlugin();
    case 111: 
      return new QzoneWebMusicJsPlugin();
    case 24: 
      return new QzoneWebViewOfflinePlugin();
    case 51: 
      return new RecentCallPluginInfo();
    case 52: 
      return new RedTouchWebviewHandler();
    case 53: 
      return new RemindJavascriptInterface();
    case 29: 
      return new SSOWebviewPlugin();
    case 3: 
      return new SensorAPIJavaScript();
    case 26: 
      return new ShareApiPlugin();
    case 54: 
      return new ShortVideoJsApiPlugin();
    case 43: 
      return new SmsApiPlugin();
    case 90: 
      return new StarJsPlugin();
    case 91: 
      return new SuitUIPlugin();
    case 92: 
      return new ThemeAndBubbleCommonJsPlugin();
    case 93: 
      return new ThemeJsPlugin();
    case 94: 
      return new ThemeUiPlugin();
    case 44: 
      return new TroopApiPlugin();
    case 57: 
      return new TroopAssistantFeedsJsHandler();
    case 117: 
      return new TroopHWJsPlugin();
    case 8: 
      return new TroopMemberApiPlugin();
    case 30: 
      return new TroopMemberLevelJSAPI();
    case 58: 
      return new TroopNoticeJsHandler();
    case 55: 
      return new TroopWebviewPlugin();
    case 45: 
      return new UiApiPlugin();
    case 134: 
      return new DocxApiPlugin();
    case 31: 
      return new UrlCheckPlugin();
    case 96: 
      return new VasCommonJsPlugin();
    case 108: 
      return new VipComicEmoticonJsPlugin();
    case 100: 
      return new VipComicJsPlugin();
    case 101: 
      return new VipFunCallJsPlugin();
    case 102: 
      return new VipFunctionJsPlugin();
    case 104: 
      return new VipGiftPlugin();
    case 35: 
      return new VipSpecialSoundWebViewPlugin();
    case 56: 
      return new VipTroopUpgradePlugin();
    case 103: 
      return new VipVideoApiPlugin();
    case 46: 
      return new WebRecordApiPlugin();
    case 32: 
      return new WebSoPlugin();
    case 106: 
      return new WebViewJumpPlugin();
    case 119: 
      return new QQReaderJsPlugin();
    case 120: 
      return new BuscardJsPlugin();
    case 122: 
      return new GDTReportPlugin();
    case 124: 
      return new MedalApiPlugin();
    case 125: 
      return new PubAccountPreloadPlugin();
    case 129: 
      return new PubAccountUIPlugin();
    case 126: 
      return new NearbyJsInterface();
    case 130: 
      return new ARMapPlugin();
    case 150: 
      return new ARTransparentWebviewPlugin();
    case 164: 
      return new ARJsApiPlugin();
    case 132: 
      return new SonicJsPlugin();
    case 133: 
      return new BusinessReportPlugin();
    case 136: 
      return new ReadInJoyWebviewPlugin();
    case 137: 
      return new BabyQFriendStatusWebViewPlugin();
    case 139: 
      return new HistoryHeadWebViewPlugin();
    case 140: 
      return new WadlWebViewJsPlugin();
    case 142: 
      return new QQComicJsPlugin();
    case 143: 
      return new CampusCirclePlugin();
    case 144: 
      return new GVideoWebPlugin();
    case 145: 
      return new GdtAdWebPlugin();
    case 146: 
      return new SocialWeeklyWebViewPlugin();
    case 147: 
      return new MsgforwardWXWebViewPlugin();
    case 149: 
      return new BroadCastPlugin();
    case 148: 
      return new ProfileDiyJsPlugin();
    case 152: 
      return new NowWebViewPlugin();
    case 151: 
      return new SignJsPlugin();
    case 153: 
      return new LocalDataJsPlugin();
    case 155: 
      return new QidianWpaWebviewPlugin();
    case 158: 
      return new WholePeoplePlugin();
    case 160: 
      return new UniteSearchApiPlugin();
    case 161: 
      return new QLBQJsPlugin();
    case 162: 
      return new ConfessPlugin();
    case 163: 
      return new ReadInJoyWebRenderPlugin();
    case 165: 
      return new TribeVideoPlugin();
    case 168: 
      return new PlatoApiPlugin();
    }
    return new ApolloGamePlugin();
  }
  
  public static WebViewPlugin a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString))) {
      return a(((Integer)a.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginFactory
 * JD-Core Version:    0.7.0.1
 */