package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.avgame.gamelogic.gameres.CJPreloadConfProcessor;
import com.tencent.biz.pubaccount.conf.PaSubscribeRedDotProcessor;
import com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfProcessor;
import com.tencent.biz.pubaccount.conf.PublicAccountConfProcessor;
import com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfProcessor;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.biz.pubaccount.qqnews.QQNewsConfigProcessor;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceStyleProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceWidgetProcessor;
import com.tencent.biz.videostory.config.processor.VSStickyNoteProcessor;
import com.tencent.biz.videostory.config.processor.VSSubscribeProcessor;
import com.tencent.biz.videostory.config.processor.VSWaterMarkProcessor;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfigProcessor;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConfigProcessor;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigProcessor;
import com.tencent.mobileqq.activity.contacts.mayknow.ReportExposeConfigProcessor;
import com.tencent.mobileqq.activity.miniaio.MiniMsgConfigProcessor;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigProcessor;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPopBannerConfProcessor;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPreloadConfProcessor;
import com.tencent.mobileqq.activity.weather.config.WeatherConfigProcessor;
import com.tencent.mobileqq.activity.weather.webpage.WeatherPreloadWebPageConfigProcessor;
import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarConfProcessor;
import com.tencent.mobileqq.colornote.ColorNoteConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.comment.config.DanmuConfProcessor;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.config.business.AEPituCameraConfigProcessor;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor;
import com.tencent.mobileqq.config.business.AppletNotificationConfProcessor;
import com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIDictConfigProcessor;
import com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIKeyWordConfigProcessor;
import com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIKeyWordSDKShareConfigProcessor;
import com.tencent.mobileqq.config.business.ArkConfProcessor.ArkMsgAIDisableConfProcessor;
import com.tencent.mobileqq.config.business.ArkConfProcessor.ArkPlatformConfProcessor;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
import com.tencent.mobileqq.config.business.AvGameLobbyConfProcessor;
import com.tencent.mobileqq.config.business.BootOptimizeConfProcessor;
import com.tencent.mobileqq.config.business.BroadcastConfProcessor;
import com.tencent.mobileqq.config.business.BrowserOpenConfProcessor;
import com.tencent.mobileqq.config.business.C2CLovePushGrayProcessor;
import com.tencent.mobileqq.config.business.DarkModeConfigProcessor;
import com.tencent.mobileqq.config.business.DeviceManageConfProcessor;
import com.tencent.mobileqq.config.business.DonDisturbProcessor;
import com.tencent.mobileqq.config.business.DtVideoReportConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.config.business.FavLocalEmoticonsProcessor;
import com.tencent.mobileqq.config.business.FlashChatConfProcessor;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.GameCenterEnterConfProcessor;
import com.tencent.mobileqq.config.business.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.config.business.GlobalSearchConfProcessor;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.LocaleConfProcessor;
import com.tencent.mobileqq.config.business.MSFConfigProcessor;
import com.tencent.mobileqq.config.business.MiniAppApiReportProcessor;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor;
import com.tencent.mobileqq.config.business.MultiChannelReportProcessor;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.config.business.NotificationBannerConfProcessor;
import com.tencent.mobileqq.config.business.OnlineAutoStatusConfProcessor;
import com.tencent.mobileqq.config.business.OnlineStatusConfProcessor;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.config.business.OpenSdkD55Processor;
import com.tencent.mobileqq.config.business.OpenSdkFakeMsgProcessor;
import com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor;
import com.tencent.mobileqq.config.business.OpenSdkRandomProcessor;
import com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor;
import com.tencent.mobileqq.config.business.PhotoListPanelConfProcessor;
import com.tencent.mobileqq.config.business.PicCommonConfProcessor;
import com.tencent.mobileqq.config.business.PicPreDownloadConfProcessor;
import com.tencent.mobileqq.config.business.PicShareToWXConfigProcessor;
import com.tencent.mobileqq.config.business.PreloadConfProcessor;
import com.tencent.mobileqq.config.business.PttAutoChangeProcessor;
import com.tencent.mobileqq.config.business.PttWithTextSwitchProcessor;
import com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor;
import com.tencent.mobileqq.config.business.QAssistantConfigProcessor;
import com.tencent.mobileqq.config.business.QConfLogProcessor;
import com.tencent.mobileqq.config.business.QConfPushProcessor;
import com.tencent.mobileqq.config.business.QIMDoodleConfigProcessor;
import com.tencent.mobileqq.config.business.QIMDynamicTextConfigProcessor;
import com.tencent.mobileqq.config.business.QIMFilterConfigProcessor;
import com.tencent.mobileqq.config.business.QIMMusicConfigProcessor;
import com.tencent.mobileqq.config.business.QIMPasterConfigProcessor;
import com.tencent.mobileqq.config.business.QIMTemplateConfigProcessor;
import com.tencent.mobileqq.config.business.QQAssistantConfigProcessor;
import com.tencent.mobileqq.config.business.QQComicConfProcessor;
import com.tencent.mobileqq.config.business.QQGameConfProcessor;
import com.tencent.mobileqq.config.business.QQGamePreloadConfProcessor;
import com.tencent.mobileqq.config.business.QQGameTeamConfProcessor;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QrCodeDisplayConfProcessor;
import com.tencent.mobileqq.config.business.QuickAuthorityConfProcessor;
import com.tencent.mobileqq.config.business.QuickHeartbeatConfigProcessor;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.config.business.ReadinjoyCommonConfProcessor;
import com.tencent.mobileqq.config.business.ReadinjoyResetFunctionConfProcessor;
import com.tencent.mobileqq.config.business.RedBagVideoResProcessor;
import com.tencent.mobileqq.config.business.RelationVipGrayProcessor;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgProcessor;
import com.tencent.mobileqq.config.business.ScannerQQCodeConfProcessor;
import com.tencent.mobileqq.config.business.ScenesEmotionConfigProcessor;
import com.tencent.mobileqq.config.business.SingTogetherConfProcessor;
import com.tencent.mobileqq.config.business.SlideShowStoryConfig;
import com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor;
import com.tencent.mobileqq.config.business.SubAccountConfProcessor;
import com.tencent.mobileqq.config.business.TencentDocsPushProcessor;
import com.tencent.mobileqq.config.business.TogetherBusinessConfProcessor;
import com.tencent.mobileqq.config.business.TogetherEntryConfProcessor;
import com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor;
import com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor;
import com.tencent.mobileqq.config.business.TroopMemRecommendConfProcessor;
import com.tencent.mobileqq.config.business.TroopUrlConfProcessor;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfProcessor;
import com.tencent.mobileqq.config.business.WVSecurityConfProcessor;
import com.tencent.mobileqq.config.business.WVStatisticsConfProcessor;
import com.tencent.mobileqq.config.business.WVWhiteListConfProcessor;
import com.tencent.mobileqq.config.business.WebShareConfigProcessor;
import com.tencent.mobileqq.config.business.WeiYunTipsBarConfigProcessor;
import com.tencent.mobileqq.config.business.WeiyunCheckAlbumConfigProcessor;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigProcessor;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerProcessor;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileApkCheckConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileCommonConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileDownloadConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CUploadConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupUploadConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QFileIPv6ConfigProcessor;
import com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigProcessor;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.config.business.qvip.CustomOnlineStatusProcessor;
import com.tencent.mobileqq.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.config.business.qvip.PushOpenNotificationProcessor;
import com.tencent.mobileqq.config.business.qvip.QQFriendRelation2Processor;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Processor;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipBubbleAnimationProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipColorNickProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipExtendIconProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipFeatureProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipFriendTag2Processor;
import com.tencent.mobileqq.config.business.qvip.QVipFriendTagProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipKeywordsProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPerfLevelProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipPubAccountProocessor;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipRedNameCardProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipResourceProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipSimpleThemeProocessor;
import com.tencent.mobileqq.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipTroopNickProcessor;
import com.tencent.mobileqq.config.business.qvip.QVipWatchWordProcessor;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapProcessor;
import com.tencent.mobileqq.config.business.qvip.VasFontSwitchProcessor;
import com.tencent.mobileqq.config.business.robot.TroopRobotConfProcessor;
import com.tencent.mobileqq.config.business.search.SearchBusinessConfProcessor;
import com.tencent.mobileqq.config.business.search.SearchHotWordConfProcessor;
import com.tencent.mobileqq.config.business.search.SearchRichConfProcessor;
import com.tencent.mobileqq.config.business.search.UinSearchConfProcessor;
import com.tencent.mobileqq.config.business.search.VerticalSearchConfProcessor;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor;
import com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TenDocGroupListEntryConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TenDocHistoryTabEmptyTipsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOPlusPanelEntryConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocDataLineTipsConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocHistoryTabToastProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMiniProgramGrayTipsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreloadConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocSelectAddDocsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocStructMsgGrayTipsConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUrl2DocConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocUserConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.VideoDrawConfProcessor;
import com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderGrayConfigProcessor;
import com.tencent.mobileqq.config.business.troop.SuspiciousTroopConfProcessor;
import com.tencent.mobileqq.config.injectimpl.OldServletInjectorImpl;
import com.tencent.mobileqq.config.safemode.SafeModeProcessor;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.extendfriend.limitchat.LimitChatOnPlusConfProcessor;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor;
import com.tencent.mobileqq.hotpic.HotPicConfProcessor;
import com.tencent.mobileqq.inputstatus.InputStatusConfig;
import com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor;
import com.tencent.mobileqq.leba.config.LebaQzoneStyleProcessor;
import com.tencent.mobileqq.leba.config.LebaRedTouchSwitchProcessor;
import com.tencent.mobileqq.location.config.LocationEasterEggConfProcessor;
import com.tencent.mobileqq.loginwelcome.WelcomeConfigProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor.C2CPanelConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelStudyModeAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfigProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigProcessor;
import com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor;
import com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor;
import com.tencent.mobileqq.settings.config.AllSettingConfigProcessor;
import com.tencent.mobileqq.shortvideo.RedDotConfProcessor;
import com.tencent.mobileqq.soload.config.SoLoaderConfProcessor;
import com.tencent.mobileqq.statistics.MsgReporterSwitchConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModeConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModePushConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialogConfigProcessor;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor;
import com.tencent.mobileqq.transfile.HighwayConfProcessor;
import com.tencent.mobileqq.troop.associations.TroopAssociationsEntryConfigProcessor;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockConfigProcessor;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfigProcessor;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryInCardConfigProcessor;
import com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfigProcessor;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigProcessor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfigProcessor;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfigProcessor;
import com.tencent.mobileqq.troop.luckycharacter.TroopLuckyCharacterConfigProcess;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfigProcessor;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelMapConfigProcessor;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vashealth.VSHealthConfigProcessor;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfProcessor;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfProcessor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.config.QConfigAPMProcessor;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor;
import cooperation.ilive.config.IliveManagerConfProcessor;
import dov.com.qq.im.ae.cmshow.config.AECMShowQConfigProcessor;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigProcessor;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class QConfigManager
{
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=3)
  public static ArrayList<Class<? extends IOldServletInjector>> a;
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_processor_map.yml", version=7)
  public static HashMap<String, Class<? extends IQConfigProcessor>> a;
  private static final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[16];
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString;
  protected final Map<Long, SharedPreferences> a;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private final Map<Integer, IQConfigProcessor> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private final Map<Integer, QConfigManager.CacheItem> jdField_c_of_type_JavaUtilMap = new ConcurrentHashMap();
  private final Object jdField_d_of_type_JavaLangObject = new Object();
  private final Map<Long, SharedPreferences> jdField_d_of_type_JavaUtilMap = new HashMap();
  private final Map<Long, SharedPreferences> e = new HashMap();
  
  static
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangObject.length)
    {
      jdField_a_of_type_ArrayOfJavaLangObject[i] = new Object();
      i += 1;
    }
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("729", QQNewsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("727", QVipBubbleAnimationProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("726", DynamicAvatarConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("724", StructPicLimitConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("722", QVipServiceAccountFolderProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("720", QQGameTeamConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("721", CJPreloadConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("723", SpringFestivalRedpacketPopBannerConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("719", SpringFestivalRedpacketPreloadConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("716", WebShareConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("715", TroopEssenceMsgEntryInCardConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("714", KandianLiveConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("713", AvGameLobbyConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("712", TroopInfoHandlerConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("711", DtVideoReportConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("709", AllSettingConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("708", BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("707", BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("706", QFlutterResConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("704", TempMsgBoxConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("703", QuickHeartbeatConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("702", WeatherConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("701", TroopFansEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("700", AECMShowQConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("699", NewerGuideBannerPreloadWebProcessConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("696", TroopLuckyCharacterConfigProcess.class);
    jdField_a_of_type_JavaUtilHashMap.put("695", TroopGameCardConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("694", QVipQidProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("692", DownloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("691", TroopNotificationEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("690", QVipFeatureProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("689", IliveManagerConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("687", QFileDatalineConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("686", TroopAssociationsEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("685", QQShortVideoQuicNetProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("684", QVipTroopNickProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("683", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("680", WriteTogetherTemplateConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("679", QQAssistantConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("678", DeepCleanConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("677", FriendClueConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("675", OpenSdkIFrameProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("673", TroopBlockConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("672", AIOPicThumbSizeProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("671", VSHealthConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("670", C2CShortcutBarConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("669", JoinTroopSecurityTipsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("668", TroopEssenceMsgEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("667", QVipGiftProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("665", QVipPrettyAccountProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("663", QFileApkCheckConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("662", QVipSimpleThemeProocessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("661", MSFConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("660", GameCenterEnterConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("659", TroopMemberLevelMapConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("657", AdEmoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("655", AIORelatedEmotionConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("654", LiuHaiWhiteListConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("653", WriteTogetherConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("652", OnlineAutoStatusConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("651", QVipPubAccountProocessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("649", VasUpdateConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("648", QVipWatchWordProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("647", RichmediaHttpsConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("645", QFileFileReaderConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("643", AEEditorEffectConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("642", AvGameConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("641", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("640", MultiChannelReportProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("638", WeatherPreloadWebPageConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("637", QDatalineHttpsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("635", TroopFoldMsgConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("634", TroopNotificationConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("633", TroopAnonyRevokeConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("632", OpenSdkFakeMsgProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("631", QQGamePreloadConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("630", QrCodeDisplayConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("628", QVipTroopFileProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("627", BrowserOpenConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("626", QFileAppStorePromoteConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("625", QFileAppStorePromoteDialogConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("623", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("622", EmoticonTabSortConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("621", ScenesEmotionConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("620", EmoticonSearchTagsConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("619", StudyModeSwitchDialogConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("618", QVipPersonalIconProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("617", GameShareConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("616", PicPreDownloadConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("615", StudyModePushConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("614", LebaQzoneStyleProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("613", OpenSdkD55Processor.class);
    jdField_a_of_type_JavaUtilHashMap.put("612", StudyRoomConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("611", AIOPlusPanelStudyModeAppInfoOrderConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("610", StudyModeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("609", TroopDragonKingAnimEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("608", GameCenterMsgConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("607", SubAccountConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("606", QfileFileAssistantTipsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("605", PublishHwkThirdPartyEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("600", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("598", LebaRedTouchSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("597", AppletNotificationConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("595", VSStickyNoteProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("593", EcshopConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("592", ECommerceDataReportConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("591", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("590", TroopShortcutBarConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("589", UinSearchConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("587", PhotoListPanelConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("586", ColorNoteRecentConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("585", WVPreloadPskeyConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("583", ExtendFriendBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("581", LowEndPerfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("580", QVipPerfLevelProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("579", ImmersiveConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("578", OnlineStatusConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("577", MsgReporterSwitchConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("576", DanmuConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("575", LocationEasterEggConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("574", AEPituCameraConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("573", SuspiciousTroopConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("572", NotificationBannerConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("569", TencentDocFormKeyWordsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("568", QAssistantConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("567", BroadcastConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("566", BootOptimizeConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("564", RichTitleConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("563", QVipProfileMusicBoxProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("562", QVipSDKProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("561", FavLocalEmoticonsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("560", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("559", TencentDocUrl2DocConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("557", QFileExcitingC2CUploadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("556", QFileExcitingC2CDownloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("555", QFileExcitingGroupDownloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("554", QFileExcitingGroupUploadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("553", TogetherEntryConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("552", LocaleConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("551", SingTogetherConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("550", TroopMemRecommendConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("549", ColorNoteConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("547", TDCRecomTroopConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("546", QuickAuthorityConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("545", QQSysAndEmojiConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("544", TroopHonorConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("543", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("542", QQLevelIconProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("541", KingCardProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("538", RichmediaIpv6ConifgProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("537", AIOVideoPlayConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("535", TogetherBusinessConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("534", QQComicConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("532", LimitChatOnPlusConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("531", DarkModeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("530", PicShareToWXConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("529", SigTopicConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("528", DeviceManageConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("527", QVIPPrettyTroopProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("526", SoLoaderConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("525", TencentDocLocalCooperationProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("524", MutualMarkConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("522", MsgBackupConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("521", TenDocHistoryTabEmptyTipsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("520", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("519", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("518", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("517", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("516", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("515", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("514", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("513", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("512", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("511", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("510", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("509", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("508", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("507", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("506", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("505", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("504", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("503", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("502", AIOPlusPanelAppInfoConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("501", TdsReaderGrayConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("500", TenDocGroupListEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("498", QVipAutoPttProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("497", WeiYunTipsBarConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("496", AIOPanelIconConfigProcessor.C2CPanelConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("495", AIOPlusPanelAppInfoOrderConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("493", SysSuspiciousConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("492", GroupIntimateRelationshipConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("491", QQFriendRelation2Processor.class);
    jdField_a_of_type_JavaUtilHashMap.put("490", RelationVipGrayProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("489", MsgTabCameraSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("488", PttWithTextSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("487", TencentDocMyFileNameProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("486", TenDocDirectShareConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("485", ScreenShotConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("484", WeiyunCheckAlbumConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("483", TencentDocHistoryTabToastProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("482", TdsReaderConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("479", CustomOnlineStatusProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("478", MultiAIOEntranceConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("477", SSOErrorInfoMapProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("474", VSEntranceWidgetProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("473", VSEntranceStyleProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("470", MiniMsgConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("469", QVipFriendTag2Processor.class);
    jdField_a_of_type_JavaUtilHashMap.put("467", OpenSdkSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("466", OpenSdkRandomProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("465", QVipExtendIconProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("463", VSSubscribeProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("462", VideoDrawConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("460", TroopRobotConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("458", NewFriendContactGuideConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("457", RecommendTroopConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("456", VerticalSearchConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("455", FriendIntimateRelationshipConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("454", WelcomeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("453", DonDisturbProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("452", C2CLovePushGrayProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("451", TencentDocPreviewConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("449", QFileIPv6ConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("447", WeSeeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("446", MiniAppApiReportProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("445", InputStatusConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("444", QVipDiyTemplateProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("442", PttAutoChangeProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("441", QQGameConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("440", TencentDocMiniProgramGrayTipsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("439", PushMsgBtnConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("438", ReportExposeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("437", TencentDocPreloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("436", ScannerQQCodeConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("435", TroopUrlConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("434", SearchBusinessConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("433", SearchHotWordConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("432", SearchRichConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("431", AVTestforEncDecConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("430", ApolloGrayConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("429", TencentDocEditConvertConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("428", QVipBigTroopExpiredProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("427", QVipBigClubSVIP9Processor.class);
    jdField_a_of_type_JavaUtilHashMap.put("426", OpenSdkConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("425", MiniAppConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("424", SafeModeProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("423", QVipRedNameCardProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("419", QConfLogProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("418", TencentDocsPushProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("416", TeleScreenConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("414", GlobalSearchConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("413", QVipProfileFootPrintProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("412", QVipColorNickProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("411", VSEntranceProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("410", StickerRecConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("409", QVipFriendTagProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("406", VSWaterMarkProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("396", QFileCommonConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("390", QConfPushProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("383", TencentDocDataLineTipsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("382", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("380", ArkConfProcessor.ArkPlatformConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("377", TencentDocImportFileInfoProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("370", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("368", ReadinjoyResetFunctionConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("367", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("362", SlideShowStoryConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("361", WVStatisticsConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("359", VasFontSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("348", TencentDocStructMsgGrayTipsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("346", TencentDocTipsConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("344", TencentDocUserConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("342", TencentDocAIOShowGuideDialogProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("338", TencentDocGrayTipsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("335", TencentDocSelectAddDocsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("334", TencentDocAIOPlusPanelEntryConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("325", RedDotConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("310", QIMDoodleConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("309", QIMDynamicTextConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("307", QIMTemplateConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("306", QIMFilterConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("305", QIMMusicConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("304", QIMPasterConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("298", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("294", TencentDocConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("292", ReadInjoySearchJumpurlConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("287", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("276", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("270", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("263", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("261", TencentDocConvertConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("255", QConfigAPMProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("252", RedBagVideoResProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("251", PicCommonConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("250", ArkConfProcessor.ArkAIKeyWordSDKShareConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("249", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("216", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("207", WVWhiteListConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("192", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("189", QVipStickerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("186", ArkConfProcessor.ArkAIKeyWordConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("176", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("172", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("170", ArkConfProcessor.ArkAIDictConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("168", FlashChatConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("164", HotPicConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("159", ArkConfProcessor.ArkMsgAIDisableConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("158", WVSecurityConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("132", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("106", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("95", PushOpenNotificationProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("92", ReadinjoyCommonConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("85", QFileDownloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("81", ServiceAccountFolderConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("76", QVipKeywordsProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("70", PublicAccountCenterUrlConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("68", PreloadConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("67", ApolloConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("35", PaSubscribeRedDotProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("32", PublicAccountConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("26", QVipResourceProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("15", HighwayConfProcessor.class);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
    jdField_a_of_type_JavaUtilArrayList.add(OldServletInjectorImpl.class);
  }
  
  private QConfigManager()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    File localFile = MobileQQ.sMobileQQ.getFilesDir();
    Object localObject = localFile;
    if (localFile == null) {
      localObject = MobileQQ.sMobileQQ.getCacheDir();
    }
    if (localObject != null) {}
    for (localObject = ((File)localObject).getParent();; localObject = File.separator + "data" + File.separator + "data" + File.separator + MobileQQ.sMobileQQ.getPackageName())
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject + File.separator + "qstore");
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "QConfigManager constructor, rootPath=" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  private int a(IQConfigProcessor paramIQConfigProcessor, int paramInt, long paramLong)
  {
    int i = a(paramLong).getInt(String.valueOf(paramInt), -1);
    paramInt = i;
    if (i == -1) {
      paramInt = paramIQConfigProcessor.migrateOldVersion();
    }
    return paramInt;
  }
  
  private int a(File paramFile)
  {
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      return i;
    }
    catch (NumberFormatException paramFile) {}
    return -1024;
  }
  
  private long a(String paramString, boolean paramBoolean)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBoolean) {}
    try
    {
      l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (Exception localException)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "Can not parse uin - " + paramString);
    }
    return 0L;
  }
  
  private SharedPreferences a(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_sharepref";
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  public static IOldServletInjector a()
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0) {}
    for (;;)
    {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
        return localIOldServletInjector;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return new QConfigManager.1();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        continue;
      }
      QLog.i("QConfigManager", 2, "getOldServletInjector. mOldServletInjectors.size() = 0");
    }
  }
  
  /* Error */
  private IQConfigProcessor a(String paramString)
  {
    // Byte code:
    //   0: getstatic 39	com/tencent/mobileqq/config/QConfigManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 1445	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 1421	java/lang/Class
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +38 -> 50
    //   15: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +30 -> 48
    //   21: ldc_w 1330
    //   24: iconst_2
    //   25: new 1307	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 1447
    //   35: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_2
    //   51: iconst_0
    //   52: anewarray 1421	java/lang/Class
    //   55: invokevirtual 1451	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   58: astore_2
    //   59: aload_2
    //   60: iconst_1
    //   61: invokevirtual 1457	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   64: aload_2
    //   65: iconst_0
    //   66: anewarray 4	java/lang/Object
    //   69: invokevirtual 1460	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 1360	com/tencent/mobileqq/config/IQConfigProcessor
    //   75: astore_2
    //   76: aload_2
    //   77: aload_1
    //   78: invokestatic 1376	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   81: invokevirtual 1464	com/tencent/mobileqq/config/IQConfigProcessor:onProcessorConstructed	(I)V
    //   84: aload_2
    //   85: areturn
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 1430	java/lang/IllegalAccessException:printStackTrace	()V
    //   91: aload_2
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_1
    //   97: invokevirtual 1434	java/lang/InstantiationException:printStackTrace	()V
    //   100: aload_2
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_2
    //   105: aload_1
    //   106: invokevirtual 1465	java/lang/NoSuchMethodException:printStackTrace	()V
    //   109: aload_2
    //   110: areturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_2
    //   114: aload_1
    //   115: invokevirtual 1466	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: goto -7 -> 114
    //   124: astore_1
    //   125: goto -20 -> 105
    //   128: astore_1
    //   129: goto -33 -> 96
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_2
    //   135: goto -48 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	QConfigManager
    //   0	138	1	paramString	String
    //   10	125	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   76	84	86	java/lang/IllegalAccessException
    //   50	76	93	java/lang/InstantiationException
    //   50	76	102	java/lang/NoSuchMethodException
    //   50	76	111	java/lang/reflect/InvocationTargetException
    //   76	84	120	java/lang/reflect/InvocationTargetException
    //   76	84	124	java/lang/NoSuchMethodException
    //   76	84	128	java/lang/InstantiationException
    //   50	76	132	java/lang/IllegalAccessException
  }
  
  public static QConfigManager a()
  {
    return QConfigManager.Holder.a;
  }
  
  private File a(String paramString1, String paramString2)
  {
    if (a(paramString1)) {
      return new File(paramString1, paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "mkdir dir failed, dir=" + paramString1);
    }
    return null;
  }
  
  private <T> T a(IQConfigProcessor<T> paramIQConfigProcessor, int paramInt)
  {
    Object localObject2 = paramIQConfigProcessor.migrateOldOrDefaultContent(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a(paramIQConfigProcessor.clazz());
    }
    return localObject1;
  }
  
  private Object a(IQConfigProcessor paramIQConfigProcessor, long paramLong, int paramInt)
  {
    Object localObject2 = a(paramIQConfigProcessor.type());
    if (localObject2 != null)
    {
      int i = paramIQConfigProcessor.type();
      int j = a(paramIQConfigProcessor, i, paramLong);
      localObject1 = localObject2;
      if (paramIQConfigProcessor.isNeedStoreLargeFile())
      {
        String str1 = a(i, paramLong, j);
        String str2 = a(i, paramLong, paramInt);
        localObject1 = localObject2;
        if (!TextUtils.equals(str2, str1)) {
          FileUtils.a(str1, str2, false);
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = paramIQConfigProcessor.migrateOldOrDefaultContent(0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "loadNewConfigFailBackport, version=" + paramInt + ", type" + paramIQConfigProcessor.type() + ", conf=" + localObject1);
      }
      return localObject1;
    }
  }
  
  private Object a(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, int paramInt)
  {
    try
    {
      Object localObject = paramIQConfigProcessor.onParsed(paramArrayOfQConfItem);
      return localObject;
    }
    catch (Exception localException)
    {
      QConfigWatchDog.a().a(paramIQConfigProcessor, paramArrayOfQConfItem, paramInt, localException);
    }
    return null;
  }
  
  public static <T> T a(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      a(paramClass, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "newInstance failed, class=" + paramClass.getSimpleName(), localException);
      }
    }
    return null;
  }
  
  private String a(int paramInt1, long paramLong, int paramInt2)
  {
    return this.jdField_a_of_type_JavaLangString + File.separator + paramLong + File.separator + "conf" + File.separator + paramInt1 + File.separator + paramInt2;
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnonnull +30 -> 34
    //   7: aload 8
    //   9: astore 4
    //   11: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +17 -> 31
    //   17: ldc_w 1330
    //   20: iconst_2
    //   21: ldc_w 1561
    //   24: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload 8
    //   29: astore 4
    //   31: aload 4
    //   33: areturn
    //   34: aload_1
    //   35: invokevirtual 1564	java/io/File:exists	()Z
    //   38: ifeq +95 -> 133
    //   41: aload_1
    //   42: invokevirtual 1567	java/io/File:isFile	()Z
    //   45: ifne +42 -> 87
    //   48: aload 8
    //   50: astore 4
    //   52: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq -24 -> 31
    //   58: ldc_w 1330
    //   61: iconst_2
    //   62: new 1307	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 1569
    //   72: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aconst_null
    //   86: areturn
    //   87: aload_1
    //   88: invokevirtual 1572	java/io/File:canRead	()Z
    //   91: ifne +81 -> 172
    //   94: aload 8
    //   96: astore 4
    //   98: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq -70 -> 31
    //   104: ldc_w 1330
    //   107: iconst_2
    //   108: new 1307	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 1574
    //   118: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_1
    //   122: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aconst_null
    //   132: areturn
    //   133: aload 8
    //   135: astore 4
    //   137: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq -109 -> 31
    //   143: ldc_w 1330
    //   146: iconst_2
    //   147: new 1307	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 1576
    //   157: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aconst_null
    //   171: areturn
    //   172: new 1578	java/io/FileInputStream
    //   175: dup
    //   176: aload_1
    //   177: invokespecial 1581	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   180: astore 4
    //   182: new 1583	java/io/InputStreamReader
    //   185: dup
    //   186: aload 4
    //   188: ldc_w 1585
    //   191: invokespecial 1588	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   194: astore_3
    //   195: aload_3
    //   196: astore 6
    //   198: aload 4
    //   200: astore 5
    //   202: aload_1
    //   203: invokevirtual 1592	java/io/File:length	()J
    //   206: l2i
    //   207: istore_2
    //   208: iload_2
    //   209: sipush 12288
    //   212: if_icmple +196 -> 408
    //   215: aload_3
    //   216: astore 6
    //   218: aload 4
    //   220: astore 5
    //   222: sipush 4096
    //   225: newarray char
    //   227: astore 7
    //   229: aload_3
    //   230: astore 6
    //   232: aload 4
    //   234: astore 5
    //   236: new 1307	java/lang/StringBuilder
    //   239: dup
    //   240: sipush 12288
    //   243: invokespecial 1594	java/lang/StringBuilder:<init>	(I)V
    //   246: astore 9
    //   248: aload_3
    //   249: astore 6
    //   251: aload 4
    //   253: astore 5
    //   255: aload_3
    //   256: aload 7
    //   258: invokevirtual 1598	java/io/InputStreamReader:read	([C)I
    //   261: istore_2
    //   262: iconst_m1
    //   263: iload_2
    //   264: if_icmpeq +101 -> 365
    //   267: aload_3
    //   268: astore 6
    //   270: aload 4
    //   272: astore 5
    //   274: aload 9
    //   276: aload 7
    //   278: iconst_0
    //   279: iload_2
    //   280: invokevirtual 1601	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: goto -36 -> 248
    //   287: astore 7
    //   289: aload_3
    //   290: astore 6
    //   292: aload 4
    //   294: astore 5
    //   296: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +39 -> 338
    //   302: aload_3
    //   303: astore 6
    //   305: aload 4
    //   307: astore 5
    //   309: ldc_w 1330
    //   312: iconst_2
    //   313: new 1307	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 1603
    //   323: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: aload 7
    //   335: invokestatic 1555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   338: aload 4
    //   340: ifnull +8 -> 348
    //   343: aload 4
    //   345: invokevirtual 1608	java/io/InputStream:close	()V
    //   348: aload 8
    //   350: astore 4
    //   352: aload_3
    //   353: ifnull -322 -> 31
    //   356: aload_3
    //   357: invokevirtual 1609	java/io/InputStreamReader:close	()V
    //   360: aconst_null
    //   361: areturn
    //   362: astore_1
    //   363: aconst_null
    //   364: areturn
    //   365: aload_3
    //   366: astore 6
    //   368: aload 4
    //   370: astore 5
    //   372: aload 9
    //   374: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore 7
    //   379: aload 7
    //   381: astore_1
    //   382: aload 4
    //   384: ifnull +8 -> 392
    //   387: aload 4
    //   389: invokevirtual 1608	java/io/InputStream:close	()V
    //   392: aload_1
    //   393: astore 4
    //   395: aload_3
    //   396: ifnull -365 -> 31
    //   399: aload_3
    //   400: invokevirtual 1609	java/io/InputStreamReader:close	()V
    //   403: aload_1
    //   404: areturn
    //   405: astore_3
    //   406: aload_1
    //   407: areturn
    //   408: aload_3
    //   409: astore 6
    //   411: aload 4
    //   413: astore 5
    //   415: iload_2
    //   416: newarray char
    //   418: astore 7
    //   420: aload_3
    //   421: astore 6
    //   423: aload 4
    //   425: astore 5
    //   427: new 1348	java/lang/String
    //   430: dup
    //   431: aload 7
    //   433: iconst_0
    //   434: aload_3
    //   435: aload 7
    //   437: invokevirtual 1598	java/io/InputStreamReader:read	([C)I
    //   440: invokespecial 1612	java/lang/String:<init>	([CII)V
    //   443: astore 7
    //   445: aload 7
    //   447: astore_1
    //   448: goto -66 -> 382
    //   451: astore_1
    //   452: aconst_null
    //   453: astore 6
    //   455: aconst_null
    //   456: astore 4
    //   458: aload 4
    //   460: ifnull +8 -> 468
    //   463: aload 4
    //   465: invokevirtual 1608	java/io/InputStream:close	()V
    //   468: aload 6
    //   470: ifnull +8 -> 478
    //   473: aload 6
    //   475: invokevirtual 1609	java/io/InputStreamReader:close	()V
    //   478: aload_1
    //   479: athrow
    //   480: astore 4
    //   482: goto -90 -> 392
    //   485: astore_1
    //   486: goto -138 -> 348
    //   489: astore_3
    //   490: goto -22 -> 468
    //   493: astore_3
    //   494: goto -16 -> 478
    //   497: astore_1
    //   498: aconst_null
    //   499: astore 6
    //   501: goto -43 -> 458
    //   504: astore_1
    //   505: aload 5
    //   507: astore 4
    //   509: goto -51 -> 458
    //   512: astore 7
    //   514: aconst_null
    //   515: astore_3
    //   516: aconst_null
    //   517: astore 4
    //   519: goto -230 -> 289
    //   522: astore 7
    //   524: aconst_null
    //   525: astore_3
    //   526: goto -237 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	QConfigManager
    //   0	529	1	paramFile	File
    //   207	209	2	i	int
    //   194	206	3	localInputStreamReader	java.io.InputStreamReader
    //   405	30	3	localException1	Exception
    //   489	1	3	localException2	Exception
    //   493	1	3	localException3	Exception
    //   515	11	3	localObject1	Object
    //   9	455	4	localObject2	Object
    //   480	1	4	localException4	Exception
    //   507	11	4	localObject3	Object
    //   200	306	5	localObject4	Object
    //   196	304	6	localObject5	Object
    //   227	50	7	arrayOfChar	char[]
    //   287	47	7	localException5	Exception
    //   377	69	7	localObject6	Object
    //   512	1	7	localException6	Exception
    //   522	1	7	localException7	Exception
    //   1	348	8	localObject7	Object
    //   246	127	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   202	208	287	java/lang/Exception
    //   222	229	287	java/lang/Exception
    //   236	248	287	java/lang/Exception
    //   255	262	287	java/lang/Exception
    //   274	284	287	java/lang/Exception
    //   372	379	287	java/lang/Exception
    //   415	420	287	java/lang/Exception
    //   427	445	287	java/lang/Exception
    //   356	360	362	java/lang/Exception
    //   399	403	405	java/lang/Exception
    //   172	182	451	finally
    //   387	392	480	java/lang/Exception
    //   343	348	485	java/lang/Exception
    //   463	468	489	java/lang/Exception
    //   473	478	493	java/lang/Exception
    //   182	195	497	finally
    //   202	208	504	finally
    //   222	229	504	finally
    //   236	248	504	finally
    //   255	262	504	finally
    //   274	284	504	finally
    //   296	302	504	finally
    //   309	338	504	finally
    //   372	379	504	finally
    //   415	420	504	finally
    //   427	445	504	finally
    //   172	182	512	java/lang/Exception
    //   182	195	522	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QConfigManager", 2, new Object[] { "getCookieNewFileDir, uin: ", paramString });
      }
      str = "9999";
    }
    return this.jdField_a_of_type_JavaLangString + File.separator + str + File.separator + "conf" + File.separator + "cookie_new";
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramConfig.msg_content_list.size();
    if (i == 0) {
      paramConfig = paramIQConfigProcessor.migrateOldOrDefaultContent(1);
    }
    label314:
    for (;;)
    {
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramIQConfigProcessor, paramConfig, paramInt2, paramLong, bool);
        return;
        ArrayList localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1);
          Object localObject1;
          if ((localContent != null) && (localContent.content.has()))
          {
            if (localContent.compress.get() != 1) {
              break label200;
            }
            localObject1 = QConfigUtil.a(localContent.content.get().toByteArray());
            if (localObject1 == null) {
              break label194;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new String((byte[])localObject1, "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localArrayList.add(new QConfItem(localContent.task_id.get(), (String)localObject1));
              }
              paramInt1 += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "decompile faild.");
              }
            }
            label194:
            localObject2 = null;
            continue;
            label200:
            localObject2 = localContent.content.get().toStringUtf8();
          }
        }
        Object localObject2 = new QConfItem[localArrayList.size()];
        localArrayList.toArray((Object[])localObject2);
        paramConfig = a(paramIQConfigProcessor, (QConfItem[])localObject2, paramInt2);
        if (paramConfig != null)
        {
          a(paramIQConfigProcessor, (QConfItem[])localObject2, paramLong, paramString);
          if (!QLog.isColorLevel()) {
            break label314;
          }
          QLog.d("QConfigManager", 2, "handleNewConfig, parse success, size=" + localObject2.length);
          break;
        }
        paramConfig = a(paramIQConfigProcessor, paramLong, paramInt2);
        break;
      }
    }
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, Object paramObject, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      a(paramLong).edit().putInt(String.valueOf(paramIQConfigProcessor.type()), paramInt).putBoolean(paramIQConfigProcessor.type() + "_" + paramInt + "_defualt", paramBoolean).apply();
      this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, paramObject));
      paramIQConfigProcessor.onUpdate(paramObject);
    }
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, long paramLong, String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramIQConfigProcessor.isNeedStoreLargeFile())
    {
      a(new File(paramString));
      j = paramArrayOfQConfItem.length;
      while (i < j)
      {
        paramIQConfigProcessor = paramArrayOfQConfItem[i];
        localObject = a(paramString, String.valueOf(paramIQConfigProcessor.jdField_a_of_type_Int));
        if (localObject != null) {
          a(paramIQConfigProcessor.jdField_a_of_type_JavaLangString, (File)localObject);
        }
        i += 1;
      }
    }
    paramString = c(paramLong);
    if (paramString == null)
    {
      QLog.e("QConfigManager", 1, "getContentSp return null!");
      return;
    }
    paramString = paramString.edit();
    Object localObject = new HashSet();
    int k = paramArrayOfQConfItem.length;
    i = j;
    while (i < k)
    {
      QConfItem localQConfItem = paramArrayOfQConfItem[i];
      ((Set)localObject).add(String.valueOf(localQConfItem.jdField_a_of_type_Int));
      paramString.putString(paramIQConfigProcessor.type() + "_" + localQConfItem.jdField_a_of_type_Int, localQConfItem.jdField_a_of_type_JavaLangString);
      i += 1;
    }
    a(paramLong).edit().putStringSet(paramIQConfigProcessor.type() + "_ids", (Set)localObject).apply();
    paramString.apply();
  }
  
  private void a(File paramFile)
  {
    int j;
    int i;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      if (paramFile.listFiles().length != 0)
      {
        paramFile = paramFile.listFiles();
        j = paramFile.length;
        i = 0;
      }
    }
    else {
      while (i < j)
      {
        a(paramFile[i]);
        i += 1;
        continue;
        a(paramFile);
      }
    }
  }
  
  public static void a(Class paramClass, Object paramObject) {}
  
  private static void a(Exception paramException)
  {
    try
    {
      throw paramException;
    }
    catch (Exception paramException)
    {
      ThreadManager.getSubThreadHandler().post(new QConfigManager.2(paramException));
    }
  }
  
  public static void a(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null) {
        paramString = ((AppRuntime)localObject).getAccount();
      }
      localObject = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("QConfigManager", 2, "getAllConfigs: uin=" + paramString);
        localObject = paramString;
      }
    }
    QConfigServlet.jdField_a_of_type_JavaLangString = (String)localObject;
    paramString = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    paramString.putExtra("k_cmd_type", a());
    paramString.putExtra("key_uin", (String)localObject);
    paramString.putExtra("k_req_occasion", 0);
    paramString.putExtra("key_is_all_config", true);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString);
  }
  
  public static void a(int[] paramArrayOfInt, String paramString)
  {
    a(paramArrayOfInt, paramString, false);
  }
  
  public static void a(int[] paramArrayOfInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int j = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        bool = paramBoolean;
        if (i >= j) {
          break;
        }
        int k = paramArrayOfInt[i];
        bool = paramBoolean;
        if (a().b(k))
        {
          bool = paramBoolean;
          if (a().a(k).isAccountRelated())
          {
            QLog.d("QConfigManager", 2, "getConfig: processor.isAccountRelated, withoutLogin=true");
            bool = false;
          }
        }
        i += 1;
        paramBoolean = bool;
      }
    }
    boolean bool = paramBoolean;
    Object localObject = paramString;
    if (!bool)
    {
      localObject = paramString;
      if (TextUtils.isEmpty(paramString))
      {
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null) {
          paramString = ((AppRuntime)localObject).getAccount();
        }
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          QLog.d("QConfigManager", 2, "getConfig: withoutLogin=false, uin=null");
          localObject = paramString;
        }
      }
    }
    QConfigServlet.jdField_a_of_type_JavaLangString = (String)localObject;
    paramString = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    paramString.putExtra("k_cmd_type", paramArrayOfInt);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.putExtra("key_uin", (String)localObject);
    }
    if (bool) {
      paramString.setWithouLogin(bool);
    }
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString);
  }
  
  protected static void a(int[] paramArrayOfInt, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", paramArrayOfInt);
    localNewIntent.putExtra("key_uin", paramString);
    localNewIntent.putExtra("key_is_page_req", true);
    if (paramArrayOfByte != null) {
      localNewIntent.putExtra("key_cookies", paramArrayOfByte);
    }
    localNewIntent.putExtra("key_is_all_config", true);
    localNewIntent.putExtra("key_page_req_count", paramInt);
    localNewIntent.putExtra("k_req_occasion", 0);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(localNewIntent);
  }
  
  private boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (!a(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  private boolean a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  /* Error */
  private boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 5
    //   11: istore_3
    //   12: aload_2
    //   13: invokevirtual 1564	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 1901	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: iload 5
    //   26: istore_3
    //   27: new 1903	java/io/FileOutputStream
    //   30: dup
    //   31: aload_2
    //   32: iconst_0
    //   33: invokespecial 1906	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +17 -> 61
    //   47: aload 6
    //   49: aload_1
    //   50: invokevirtual 1909	java/lang/String:getBytes	()[B
    //   53: invokevirtual 1913	java/io/FileOutputStream:write	([B)V
    //   56: aload 6
    //   58: invokevirtual 1916	java/io/FileOutputStream:flush	()V
    //   61: aload 6
    //   63: ifnull +130 -> 193
    //   66: aload 6
    //   68: invokevirtual 1917	java/io/FileOutputStream:close	()V
    //   71: iload_3
    //   72: ireturn
    //   73: astore 7
    //   75: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +30 -> 108
    //   81: ldc_w 1330
    //   84: iconst_2
    //   85: new 1307	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   92: ldc_w 1919
    //   95: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_2
    //   99: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 1335	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: iconst_0
    //   109: istore_3
    //   110: goto -83 -> 27
    //   113: astore 7
    //   115: iconst_0
    //   116: istore_3
    //   117: goto -75 -> 42
    //   120: astore_1
    //   121: invokestatic 1328	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +31 -> 155
    //   127: ldc_w 1330
    //   130: iconst_2
    //   131: new 1307	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 1308	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 1921
    //   141: invokevirtual 1312	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_2
    //   145: invokevirtual 1531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 1320	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: aload_1
    //   152: invokestatic 1555	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: iload 4
    //   157: istore_3
    //   158: aload 6
    //   160: ifnull -89 -> 71
    //   163: aload 6
    //   165: invokevirtual 1917	java/io/FileOutputStream:close	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_1
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_1
    //   174: aload 6
    //   176: ifnull +8 -> 184
    //   179: aload 6
    //   181: invokevirtual 1917	java/io/FileOutputStream:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: goto -6 -> 184
    //   193: iload_3
    //   194: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	QConfigManager
    //   0	195	1	paramString	String
    //   0	195	2	paramFile	File
    //   11	183	3	bool1	boolean
    //   1	155	4	bool2	boolean
    //   4	21	5	bool3	boolean
    //   7	173	6	localObject	Object
    //   36	3	7	localFileOutputStream	java.io.FileOutputStream
    //   73	1	7	localIOException	java.io.IOException
    //   113	1	7	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   19	24	73	java/io/IOException
    //   27	38	113	java/io/FileNotFoundException
    //   47	61	120	java/io/IOException
    //   163	168	170	java/io/IOException
    //   47	61	173	finally
    //   121	155	173	finally
    //   66	71	186	java/io/IOException
    //   179	184	189	java/io/IOException
  }
  
  protected static int[] a()
  {
    int[] arrayOfInt = new int[jdField_a_of_type_JavaUtilHashMap.size()];
    Object localObject = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[i] = Integer.parseInt((String)((Iterator)localObject).next());
      i += 1;
    }
    localObject = new int[a().a().length + arrayOfInt.length];
    System.arraycopy(a().a(), 0, localObject, 0, a().a().length);
    System.arraycopy(arrayOfInt, 0, localObject, a().a().length, arrayOfInt.length);
    return localObject;
  }
  
  private QConfItem[] a(int paramInt, long paramLong)
  {
    int i = a(paramInt, paramLong);
    if (b(paramInt) == null) {}
    File[] arrayOfFile;
    do
    {
      return null;
      localObject = new File(a(paramInt, paramLong, i));
      arrayOfFile = ((File)localObject).listFiles();
    } while ((!((File)localObject).exists()) || (arrayOfFile == null) || (arrayOfFile.length == 0));
    Object localObject = new QConfItem[arrayOfFile.length];
    paramInt = 0;
    while (paramInt < arrayOfFile.length)
    {
      File localFile = arrayOfFile[paramInt];
      localObject[paramInt] = new QConfItem(a(localFile), a(localFile));
      paramInt += 1;
    }
    return localObject;
  }
  
  private SharedPreferences b(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.e.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_d_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.e.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_upgrade_pref";
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.e.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private IQConfigProcessor b(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null) {}
    return localIQConfigProcessor;
  }
  
  private void b(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (paramConfig.content_list.isEmpty()) {
      paramString = paramIQConfigProcessor.migrateOldOrDefaultContent(1);
    }
    for (;;)
    {
      a(paramIQConfigProcessor, paramString, paramInt2, paramLong, paramConfig.content_list.isEmpty());
      return;
      int i = paramConfig.content_list.size();
      QConfItem[] arrayOfQConfItem = new QConfItem[i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfQConfItem[paramInt1] = new QConfItem(paramInt1, (String)paramConfig.content_list.get(paramInt1));
        paramInt1 += 1;
      }
      Object localObject = a(paramIQConfigProcessor, arrayOfQConfItem, paramInt2);
      if (localObject != null)
      {
        a(paramIQConfigProcessor, arrayOfQConfItem, paramLong, paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigManager", 2, "handleOldConfig, parse success, size=" + i);
          paramString = localObject;
        }
      }
      else
      {
        paramString = a(paramIQConfigProcessor, paramLong, paramInt2);
        continue;
      }
      paramString = localObject;
    }
  }
  
  private QConfItem[] b(int paramInt, long paramLong)
  {
    if (a(paramInt) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfigFromSp, type is not support, type=" + paramInt);
      }
      return null;
    }
    Object localObject1 = a(paramLong);
    SharedPreferences localSharedPreferences = c(paramLong);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getVersionSp return null!");
      }
      return null;
    }
    if (localSharedPreferences == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getContentSp return null!");
      }
      return null;
    }
    Object localObject2 = ((SharedPreferences)localObject1).getStringSet(paramInt + "_ids", null);
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    localObject1 = new QConfItem[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new QConfItem(Integer.parseInt(str), localSharedPreferences.getString(paramInt + "_" + str, null));
      i += 1;
    }
    return localObject1;
  }
  
  private SharedPreferences c(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jdField_d_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_d_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_content_sharepref";
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jdField_d_of_type_JavaUtilMap.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  public int a(int paramInt, long paramLong)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localIQConfigProcessor, paramInt, paramLong);
  }
  
  public int a(int paramInt, String paramString)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localIQConfigProcessor, paramInt, a(paramString, localIQConfigProcessor.isAccountRelated()));
  }
  
  public IQConfigProcessor a(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor2 = (IQConfigProcessor)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    IQConfigProcessor localIQConfigProcessor1 = localIQConfigProcessor2;
    if (localIQConfigProcessor2 == null) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      localIQConfigProcessor2 = (IQConfigProcessor)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      localIQConfigProcessor1 = localIQConfigProcessor2;
      if (localIQConfigProcessor2 == null)
      {
        localIQConfigProcessor2 = a(String.valueOf(paramInt));
        localIQConfigProcessor1 = localIQConfigProcessor2;
        if (localIQConfigProcessor2 != null)
        {
          this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localIQConfigProcessor2);
          localIQConfigProcessor1 = localIQConfigProcessor2;
        }
      }
      if ((localIQConfigProcessor1 == null) && (QLog.isColorLevel())) {
        QLog.d("QConfigManager", 2, "getConfProcess, processor=null");
      }
      return localIQConfigProcessor1;
    }
  }
  
  public <T> T a(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = b(paramInt);
    if (localIQConfigProcessor == null) {
      return null;
    }
    Object localObject1;
    if (localIQConfigProcessor.isAccountRelated())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 == null) {}
    }
    int i;
    for (long l = a(((SimpleAccount)localObject1).getUin(), localIQConfigProcessor.isAccountRelated());; l = 0L)
    {
      localObject1 = a(l);
      i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
      if (i != -1) {
        break;
      }
      return a(localIQConfigProcessor, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
      }
      return a(localIQConfigProcessor, 1);
    }
    ??? = (QConfigManager.CacheItem)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((??? != null) && (((QConfigManager.CacheItem)???).jdField_a_of_type_Int == i) && (((QConfigManager.CacheItem)???).jdField_a_of_type_Long == l) && (((QConfigManager.CacheItem)???).jdField_a_of_type_JavaLangObject != null)) {
      return ((QConfigManager.CacheItem)???).jdField_a_of_type_JavaLangObject;
    }
    if (((SharedPreferences)localObject1).getBoolean(localIQConfigProcessor.type() + "_" + i + "_defualt", false)) {
      return a(localIQConfigProcessor, 0);
    }
    Object localObject3;
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt % jdField_a_of_type_ArrayOfJavaLangObject.length)])
      {
        if (localIQConfigProcessor.isNeedStoreLargeFile())
        {
          localObject1 = a(paramInt, l);
          if (localObject1 != null) {
            break;
          }
          localObject1 = a(localIQConfigProcessor.clazz());
          return localObject1;
        }
      }
      localObject3 = b(paramInt, l);
    }
    try
    {
      Object localObject5 = localIQConfigProcessor.onParsed((QConfItem[])localObject3);
      this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new QConfigManager.CacheItem(l, i, localObject5));
      return localObject5;
    }
    catch (Exception localException)
    {
      QConfigWatchDog.a().a(localIQConfigProcessor, (QConfItem[])localObject3, i, localException);
      localObject3 = a(localIQConfigProcessor.clazz());
    }
    return localObject3;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (((IQConfigProcessor)localObject).isAccountRelated())
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        l1 = l2;
        if (localAppRuntime != null) {
          l1 = a(localAppRuntime.getAccount(), ((IQConfigProcessor)localObject).isAccountRelated());
        }
      }
    }
    localObject = a(l1);
    int i = ((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), -1);
    if ((i != -1) && (i != paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "setConfVersion t=" + paramInt1 + " v=" + paramInt2);
      }
      ((SharedPreferences)localObject).edit().putInt(String.valueOf(paramInt1), paramInt2).apply();
    }
  }
  
  public void a(int paramInt1, int paramInt2, ConfigurationService.Config paramConfig, String arg4)
  {
    int i = b(paramInt1, Long.parseLong(???));
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "[OnReceive] t=" + paramInt1 + " old=" + i + ", new=" + paramInt2);
    }
    if (i == paramInt2) {}
    IQConfigProcessor localIQConfigProcessor;
    do
    {
      do
      {
        return;
        if (!QConfigJourney.a().a(paramInt1, paramInt2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "conf has been deleted by safemode, type=" + paramInt1 + ", version=" + paramInt2);
      return;
      localIQConfigProcessor = b(paramInt1);
      if (localIQConfigProcessor != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigManager", 2, "Has not define an process," + paramInt1);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "save config, ov=" + i + " to nv=" + paramInt2 + ", type=" + paramInt1);
    }
    long l = a(???, localIQConfigProcessor.isAccountRelated());
    String str = a(paramInt1, l, paramInt2);
    synchronized (jdField_a_of_type_ArrayOfJavaLangObject[(paramInt1 % jdField_a_of_type_ArrayOfJavaLangObject.length)])
    {
      if ((localIQConfigProcessor.isNeedStoreLargeFile()) && (!a(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "create conf dir failed, dir=" + str);
        }
        return;
      }
    }
    if (localIQConfigProcessor.isNeedCompressed()) {
      a(localIQConfigProcessor, paramConfig, l, str, i, paramInt2);
    }
    for (;;)
    {
      QConfigJourney.a().a(paramInt1, l, localIQConfigProcessor.isNeedStoreLargeFile());
      return;
      b(localIQConfigProcessor, paramConfig, l, str, i, paramInt2);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    IQConfigProcessor localIQConfigProcessor = b(paramInt);
    if (localIQConfigProcessor == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "noReceive method has not define an process," + paramInt);
      }
    }
    for (;;)
    {
      return;
      try
      {
        localIQConfigProcessor.onReqNoReceive();
        b(paramInt, Long.parseLong(paramString));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QConfigManager", 2, "noReceive config, type=" + paramInt);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "Handle noReceive operation exception, type=" + paramInt, paramString);
          }
        }
      }
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!b(k)) {
        a(new IllegalStateException("QConfigManager has not support the config yet, type=" + k));
      }
      i += 1;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    QConfigServlet.jdField_a_of_type_JavaLangString = str;
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    localNewIntent.putExtra("k_cmd_type", paramArrayOfInt);
    localNewIntent.putExtra("key_uin", str);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public boolean a(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null) {
      return false;
    }
    return localIQConfigProcessor.isNeedCompressed();
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    return FileUtils.a(paramArrayOfByte, a(paramString));
  }
  
  public boolean a(AppRuntime paramAppRuntime, int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!localIQConfigProcessor.isNeedUpgradeReset());
        paramAppRuntime = b(paramAppRuntime.getLongAccountUin());
      } while (paramAppRuntime == null);
      paramAppRuntime = paramAppRuntime.getString(String.valueOf(paramInt), "");
    } while (TextUtils.equals(AppSetting.g(), paramAppRuntime));
    return true;
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.a(a(paramString));
  }
  
  public int b(int paramInt, long paramLong)
  {
    int i = a().a(paramInt, paramLong);
    Object localObject = a(paramInt);
    if ((localObject != null) && (((IQConfigProcessor)localObject).isNeedUpgradeReset()) && (i == 0))
    {
      localObject = b(paramLong);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString(String.valueOf(paramInt), AppSetting.g()).apply();
      }
    }
    return i;
  }
  
  public boolean b(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (paramInt == Integer.parseInt((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigManager
 * JD-Core Version:    0.7.0.1
 */