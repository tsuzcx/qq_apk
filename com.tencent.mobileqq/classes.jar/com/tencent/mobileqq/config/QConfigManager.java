package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowQConfigProcessor;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMDoodleConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMDynamicTextConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMFilterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMMusicConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMPasterConfigProcessor;
import com.tencent.aelight.camera.aioeditor.config.QIMTemplateConfigProcessor;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.avgame.config.AvGameConfProcessor;
import com.tencent.biz.pubaccount.conf.PaSubscribeRedDotProcessor;
import com.tencent.biz.pubaccount.conf.PublicAccountCenterUrlConfProcessor;
import com.tencent.biz.pubaccount.conf.PublicAccountConfProcessor;
import com.tencent.biz.pubaccount.conf.ServiceAccountFolderConfProcessor;
import com.tencent.biz.pubaccount.qqnews.QQNewsConfigProcessor;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceStyleProcessor;
import com.tencent.biz.videostory.config.processor.VSEntranceWidgetProcessor;
import com.tencent.biz.videostory.config.processor.VSStickyNoteProcessor;
import com.tencent.biz.videostory.config.processor.VSSubscribeProcessor;
import com.tencent.biz.videostory.config.processor.VSWaterMarkProcessor;
import com.tencent.comic.config.QQComicConfProcessor;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.config.FloatingPermissionConfProcessor;
import com.tencent.mobileqq.activity.aio.anim.config.TroopDragonKingAnimEntryConfigProcessor;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConfigProcessor;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigProcessor;
import com.tencent.mobileqq.activity.contacts.mayknow.ReportExposeConfigProcessor;
import com.tencent.mobileqq.activity.miniaio.MiniMsgConfigProcessor;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeMenuConfigProcessor;
import com.tencent.mobileqq.activity.recent.config.optpopbar.RecentOptPopBarSwitchProcessor;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerPreloadWebProcessConfigProcessor;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxConfigProcessor;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPopBannerConfProcessor;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPreloadConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloConfProcessor;
import com.tencent.mobileqq.apollo.config.ApolloGrayConfProcessor;
import com.tencent.mobileqq.ark.config.processor.ArkAIDictConfigProcessor;
import com.tencent.mobileqq.ark.config.processor.ArkAIKeyWordConfigProcessor;
import com.tencent.mobileqq.ark.config.processor.ArkAIKeyWordSDKShareConfigProcessor;
import com.tencent.mobileqq.ark.config.processor.ArkMsgAIDisableConfProcessor;
import com.tencent.mobileqq.ark.config.processor.ArkPlatformConfProcessor;
import com.tencent.mobileqq.bigbrother.TeleScreenConfig;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarConfProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.comment.config.DanmuConfProcessor;
import com.tencent.mobileqq.comment.config.ImmersiveConfProcessor;
import com.tencent.mobileqq.config.anisticker.RandomAniStickerConfigProcessor;
import com.tencent.mobileqq.config.business.AEPituCameraConfigProcessor;
import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.config.business.AIORelatedEmotionConfProcessor;
import com.tencent.mobileqq.config.business.AIOVideoPlayConfigProcessor;
import com.tencent.mobileqq.config.business.AlbumConfProcessor;
import com.tencent.mobileqq.config.business.AppletNotificationConfProcessor;
import com.tencent.mobileqq.config.business.AvGameLobbyConfProcessor;
import com.tencent.mobileqq.config.business.BootOptimizeConfProcessor;
import com.tencent.mobileqq.config.business.BroadcastConfProcessor;
import com.tencent.mobileqq.config.business.BrowserOpenConfProcessor;
import com.tencent.mobileqq.config.business.C2CLovePushGrayProcessor;
import com.tencent.mobileqq.config.business.CJPreloadConfProcessor;
import com.tencent.mobileqq.config.business.DarkModeConfigProcessor;
import com.tencent.mobileqq.config.business.DeviceManageConfProcessor;
import com.tencent.mobileqq.config.business.DonDisturbProcessor;
import com.tencent.mobileqq.config.business.DtVideoReportConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonSearchTagsConfProcessor;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.config.business.FavLocalEmoticonsProcessor;
import com.tencent.mobileqq.config.business.FlashChatConfProcessor;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.GlobalSearchConfProcessor;
import com.tencent.mobileqq.config.business.GroupIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.LocaleConfProcessor;
import com.tencent.mobileqq.config.business.MSFConfigProcessor;
import com.tencent.mobileqq.config.business.MiniAppApiReportProcessor;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.config.business.MsfUdpConfigProcessor;
import com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor;
import com.tencent.mobileqq.config.business.MultiChannelReportProcessor;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
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
import com.tencent.mobileqq.config.business.PttAutoChangeProcessor;
import com.tencent.mobileqq.config.business.PttWithTextSwitchProcessor;
import com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor;
import com.tencent.mobileqq.config.business.QAssistantConfigProcessor;
import com.tencent.mobileqq.config.business.QConfLogProcessor;
import com.tencent.mobileqq.config.business.QConfPushProcessor;
import com.tencent.mobileqq.config.business.QQAssistantConfigProcessor;
import com.tencent.mobileqq.config.business.QQGameTeamConfProcessor;
import com.tencent.mobileqq.config.business.QQShortVideoQuicNetProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QrCodeDisplayConfProcessor;
import com.tencent.mobileqq.config.business.QuickAuthorityConfProcessor;
import com.tencent.mobileqq.config.business.QuickHeartbeatConfigProcessor;
import com.tencent.mobileqq.config.business.RedBagVideoResProcessor;
import com.tencent.mobileqq.config.business.RelationVipGrayProcessor;
import com.tencent.mobileqq.config.business.RichTitleConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaIpv6ConifgProcessor;
import com.tencent.mobileqq.config.business.ScenesEmotionConfigProcessor;
import com.tencent.mobileqq.config.business.SingTogetherConfProcessor;
import com.tencent.mobileqq.config.business.SlideShowStoryConfig;
import com.tencent.mobileqq.config.business.StructPicLimitConfigProcessor;
import com.tencent.mobileqq.config.business.SubAccountConfProcessor;
import com.tencent.mobileqq.config.business.TencentDocsPushProcessor;
import com.tencent.mobileqq.config.business.TicketAuthorizeConfProcessor;
import com.tencent.mobileqq.config.business.TogetherBusinessConfProcessor;
import com.tencent.mobileqq.config.business.TogetherEntryConfProcessor;
import com.tencent.mobileqq.config.business.TroopAnonyRevokeConfProcessor;
import com.tencent.mobileqq.config.business.TroopFoldMsgConfProcessor;
import com.tencent.mobileqq.config.business.TroopMemRecommendConfProcessor;
import com.tencent.mobileqq.config.business.WVPreloadPskeyConfProcessor;
import com.tencent.mobileqq.config.business.WVSecurityConfProcessor;
import com.tencent.mobileqq.config.business.WVStatisticsConfProcessor;
import com.tencent.mobileqq.config.business.WVWhiteListConfProcessor;
import com.tencent.mobileqq.config.business.WebShareConfigProcessor;
import com.tencent.mobileqq.config.business.WeiYunTipsBarConfigProcessor;
import com.tencent.mobileqq.config.business.WeiyunCheckAlbumConfigProcessor;
import com.tencent.mobileqq.config.business.avatar.DynamicAvatarConfProcessor;
import com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigProcessor;
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
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.download.unite.config.DownloadConfigProcessor;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.education.config.AnswerSearchConfigProcessor;
import com.tencent.mobileqq.emoticonview.AniStickerLottieProcessor;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor;
import com.tencent.mobileqq.guild.config.QQGuildConfProcessor;
import com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor;
import com.tencent.mobileqq.guild.file.config.GuildFileEntryConfigProcessor;
import com.tencent.mobileqq.guild.gift.config.GuildAIOGiftEntryConfigProcessor;
import com.tencent.mobileqq.guild.pic.config.GuildPicDownloadConfigProcessor;
import com.tencent.mobileqq.hotpic.HotPicConfProcessor;
import com.tencent.mobileqq.inputstatus.InputStatusConfig;
import com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveConfProcessor;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyResetFunctionConfProcessor;
import com.tencent.mobileqq.kandian.biz.config.ReadinjoyCommonConfProcessor;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.leba.config.LebaQzoneStyleProcessor;
import com.tencent.mobileqq.leba.config.LebaRedTouchSwitchProcessor;
import com.tencent.mobileqq.location.config.LocationEasterEggConfProcessor;
import com.tencent.mobileqq.loginwelcome.WelcomeConfigProcessor;
import com.tencent.mobileqq.manager.QSafeConfigProcessor;
import com.tencent.mobileqq.mini.config.AppDetainFreqConfigProcessor;
import com.tencent.mobileqq.mini.config.FileMaterialConfigProcessor;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePASubscribeProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigProcessor;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.perf.rmonitor.config.QQRMonitorCfgProcessor;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.persistence.backup.DBBackupConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor.C2CPanelConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelStudyModeAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfigProcessor;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerProcessor;
import com.tencent.mobileqq.qqexpand.manager.config.LimitChatOnPlusConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.DnFlutterConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.GameCenterEnterConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfProcessor;
import com.tencent.mobileqq.qqgift.config.QQGiftConfigProcessor;
import com.tencent.mobileqq.qqguildsdk.config.GProSdkConfigProcessor;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfProcessor;
import com.tencent.mobileqq.qwallet.config.PreloadConfProcessor;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigProcessor;
import com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor;
import com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor;
import com.tencent.mobileqq.search.config.GroupSearchResultConfigProcessor;
import com.tencent.mobileqq.search.config.SearchConfigProcessor;
import com.tencent.mobileqq.search.config.SearchFunctionModuleProcessor;
import com.tencent.mobileqq.shortvideo.RedDotConfProcessor;
import com.tencent.mobileqq.soload.config.SoLoaderConfProcessor;
import com.tencent.mobileqq.statistics.MsgReporterSwitchConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModeConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModePushConfigProcessor;
import com.tencent.mobileqq.studymode.StudyModeSwitchDialogConfigProcessor;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor;
import com.tencent.mobileqq.teamwork.config.TencentDocDrawerConfigProcessor;
import com.tencent.mobileqq.transfile.HighwayConfProcessor;
import com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfigProcessor;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockConfigProcessor;
import com.tencent.mobileqq.troop.essence.TroopEssenceMsgEntryInCardConfigProcessor;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryConfigProcessor;
import com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfigProcessor;
import com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigProcessor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfigProcessor;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfigProcessor;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfigProcess;
import com.tencent.mobileqq.troop.memberlevel.TroopMemberLevelMapConfigProcessor;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor;
import com.tencent.mobileqq.troop.robot.TroopRobotConfProcessor;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfigProcessor;
import com.tencent.mobileqq.troop.temporaryban.config.TemporarilyBannedTroopTipConfigProcessor;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfigProcessor;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfigProcessor;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.abtest.ExpMgrListProcessor;
import com.tencent.mobileqq.vas.config.business.QVipHippyProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.CustomOnlineStatusProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.PushOpenNotificationProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QQFriendRelation2Processor;
import com.tencent.mobileqq.vas.config.business.qvip.QQLevelIconProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigClubSVIP9Processor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBubbleAnimationProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipColorNickProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipExtendIconProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Processor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTagProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipKeywordsProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPerfLevelProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileFootPrintProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountProocessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipRedNameCardProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipResourceProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipServiceAccountFolderProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSimpleThemeProocessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipTroopNickProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipWatchWordProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.SSOErrorInfoMapProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.TreasureCardProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.VasFontSwitchProcessor;
import com.tencent.mobileqq.vashealth.config.HealthConfigProcessor;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigProcessor;
import com.tencent.mobileqq.vashealth.config.StepConfigProcessor;
import com.tencent.mobileqq.weather.config.WeatherConfigProcessor;
import com.tencent.mobileqq.weather.webpage.WeatherPreloadWebPageConfigProcessor;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfProcessor;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfProcessor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.config.QConfigAPMProcessor;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeProcessor;
import com.tencent.qqperf.monitor.file.ExternalDirOperationConfigProcessor;
import com.tencent.qqperf.opt.suspendthread.LowEndPerfProcessor;
import cooperation.ilive.config.IliveManagerConfProcessor;
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

public class QConfigManager
{
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_processor_map.yml", version=17)
  public static HashMap<String, Class<? extends IQConfigProcessor>> b;
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=3)
  public static ArrayList<Class<? extends IOldServletInjector>> c;
  private static final Object[] d = new Object[16];
  protected final Map<Long, SharedPreferences> a = new HashMap();
  private final String e;
  private final Map<Integer, IQConfigProcessor> f = new ConcurrentHashMap();
  private final Map<Integer, QConfigManager.CacheItem> g = new ConcurrentHashMap();
  private final Map<Long, SharedPreferences> h = new HashMap();
  private final Map<Long, SharedPreferences> i = new HashMap();
  private final Object j = new Object();
  private final Object k = new Object();
  private final Object l = new Object();
  private final Object m = new Object();
  
  static
  {
    int n = 0;
    for (;;)
    {
      Object[] arrayOfObject = d;
      if (n >= arrayOfObject.length) {
        break;
      }
      arrayOfObject[n] = new Object();
      n += 1;
    }
    b = new HashMap();
    b.put("771", GuildFileEntryConfigProcessor.class);
    b.put("776", PackageInstallWhiteListConfigProcessor.class);
    b.put("773", RandomAniStickerConfigProcessor.class);
    b.put("772", GuildPicDownloadConfigProcessor.class);
    b.put("770", QQGuildShareConfigProcessor.class);
    b.put("769", DBBackupConfigProcessor.class);
    b.put("768", QQRMonitorCfgProcessor.class);
    b.put("767", QQLiveConfigProcessor.class);
    b.put("766", OlympicConfProcessor.class);
    b.put("765", QQGiftConfigProcessor.class);
    b.put("764", GuildAIOGiftEntryConfigProcessor.class);
    b.put("763", AppDetainFreqConfigProcessor.class);
    b.put("762", MiniGamePASubscribeProcessor.class);
    b.put("761", AniStickerLottieProcessor.class);
    b.put("759", QAVConfig.class);
    b.put("758", FileMaterialConfigProcessor.class);
    b.put("757", TicketAuthorizeConfProcessor.class);
    b.put("756", BeancurdConfProcessor.class);
    b.put("755", TemporarilyBannedTroopTipConfigProcessor.class);
    b.put("754", MsfUdpConfigProcessor.class);
    b.put("753", DnFlutterConfProcessor.class);
    b.put("752", AnswerSearchConfigProcessor.class);
    b.put("748", GProSdkConfigProcessor.class);
    b.put("751", TreasureCardProcessor.class);
    b.put("750", OneClickJumpConfProcessor.class);
    b.put("749", GroupSearchResultConfigProcessor.class);
    b.put("743", QQSettingMeMenuConfigProcessor.class);
    b.put("745", AlbumConfProcessor.class);
    b.put("744", RecentOptPopBarSwitchProcessor.class);
    b.put("742", ExpMgrListProcessor.class);
    b.put("741", MiniGamePAConfProcessor.class);
    b.put("740", TencentDocDrawerConfigProcessor.class);
    b.put("739", QQGamePreDownloadConfigProcessor.class);
    b.put("738", StepConfigProcessor.class);
    b.put("737", FloatingPermissionConfProcessor.class);
    b.put("736", ExternalDirOperationConfigProcessor.class);
    b.put("735", QAVConfig.class);
    b.put("734", QVipHippyProcessor.class);
    b.put("733", QQGuildConfProcessor.class);
    b.put("732", QSafeConfigProcessor.class);
    b.put("730", CommonFunctionPublishConfigProcessor.class);
    b.put("729", QQNewsConfigProcessor.class);
    b.put("727", QVipBubbleAnimationProcessor.class);
    b.put("726", DynamicAvatarConfProcessor.class);
    b.put("724", StructPicLimitConfigProcessor.class);
    b.put("722", QVipServiceAccountFolderProcessor.class);
    b.put("720", QQGameTeamConfProcessor.class);
    b.put("721", CJPreloadConfProcessor.class);
    b.put("723", SpringFestivalRedpacketPopBannerConfProcessor.class);
    b.put("719", SpringFestivalRedpacketPreloadConfProcessor.class);
    b.put("716", WebShareConfigProcessor.class);
    b.put("715", TroopEssenceMsgEntryInCardConfigProcessor.class);
    b.put("714", KandianLiveConfProcessor.class);
    b.put("713", AvGameLobbyConfProcessor.class);
    b.put("712", TroopInfoHandlerConfigProcessor.class);
    b.put("711", DtVideoReportConfProcessor.class);
    b.put("708", BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.class);
    b.put("707", BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.class);
    b.put("706", QFlutterResConfigProcessor.class);
    b.put("704", TempMsgBoxConfigProcessor.class);
    b.put("703", QuickHeartbeatConfigProcessor.class);
    b.put("702", WeatherConfigProcessor.class);
    b.put("701", TroopFansEntryConfigProcessor.class);
    b.put("700", AECMShowQConfigProcessor.class);
    b.put("699", NewerGuideBannerPreloadWebProcessConfigProcessor.class);
    b.put("696", TroopLuckyCharacterConfigProcess.class);
    b.put("695", TroopGameCardConfigProcessor.class);
    b.put("694", QVipQidProcessor.class);
    b.put("692", DownloadConfigProcessor.class);
    b.put("691", TroopNotificationEntryConfigProcessor.class);
    b.put("690", QVipFeatureProcessor.class);
    b.put("689", IliveManagerConfProcessor.class);
    b.put("687", QFileDatalineConfigProcessor.class);
    b.put("686", TroopAssociationsEntryConfigProcessor.class);
    b.put("685", QQShortVideoQuicNetProcessor.class);
    b.put("684", QVipTroopNickProcessor.class);
    b.put("683", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("680", WriteTogetherTemplateConfProcessor.class);
    b.put("679", QQAssistantConfigProcessor.class);
    b.put("678", DeepCleanConfigProcessor.class);
    b.put("677", FriendClueConfigProcessor.class);
    b.put("675", OpenSdkIFrameProcessor.class);
    b.put("673", TroopBlockConfigProcessor.class);
    b.put("672", AIOPicThumbSizeProcessor.class);
    b.put("671", HealthConfigProcessor.class);
    b.put("670", C2CShortcutBarConfProcessor.class);
    b.put("669", JoinTroopSecurityTipsConfigProcessor.class);
    b.put("668", TroopEssenceMsgEntryConfigProcessor.class);
    b.put("667", QVipGiftProcessor.class);
    b.put("665", QVipPrettyAccountProcessor.class);
    b.put("663", QFileApkCheckConfigProcessor.class);
    b.put("662", QVipSimpleThemeProocessor.class);
    b.put("661", MSFConfigProcessor.class);
    b.put("660", GameCenterEnterConfProcessor.class);
    b.put("659", TroopMemberLevelMapConfigProcessor.class);
    b.put("657", AdEmoConfigProcessor.class);
    b.put("655", AIORelatedEmotionConfProcessor.class);
    b.put("654", LiuHaiWhiteListConfProcessor.class);
    b.put("653", WriteTogetherConfProcessor.class);
    b.put("652", OnlineAutoStatusConfProcessor.class);
    b.put("651", QVipPubAccountProocessor.class);
    b.put("649", VasUpdateConfProcessor.class);
    b.put("648", QVipWatchWordProcessor.class);
    b.put("647", RichmediaHttpsConfProcessor.class);
    b.put("645", QFileFileReaderConfigProcessor.class);
    b.put("643", AEEditorEffectConfigProcessor.class);
    b.put("642", AvGameConfProcessor.class);
    b.put("641", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("640", MultiChannelReportProcessor.class);
    b.put("638", WeatherPreloadWebPageConfigProcessor.class);
    b.put("637", QDatalineHttpsConfigProcessor.class);
    b.put("635", TroopFoldMsgConfProcessor.class);
    b.put("634", TroopNotificationConfigProcessor.class);
    b.put("633", TroopAnonyRevokeConfProcessor.class);
    b.put("632", OpenSdkFakeMsgProcessor.class);
    b.put("631", QQGamePreloadConfProcessor.class);
    b.put("630", QrCodeDisplayConfProcessor.class);
    b.put("628", QVipTroopFileProcessor.class);
    b.put("627", BrowserOpenConfProcessor.class);
    b.put("626", QFileAppStorePromoteConfigProcessor.class);
    b.put("625", QFileAppStorePromoteDialogConfigProcessor.class);
    b.put("623", QAVConfig.class);
    b.put("622", EmoticonTabSortConfProcessor.class);
    b.put("621", ScenesEmotionConfigProcessor.class);
    b.put("620", EmoticonSearchTagsConfProcessor.class);
    b.put("619", StudyModeSwitchDialogConfigProcessor.class);
    b.put("618", QVipPersonalIconProcessor.class);
    b.put("617", GameShareConfProcessor.class);
    b.put("616", PicPreDownloadConfProcessor.class);
    b.put("615", StudyModePushConfigProcessor.class);
    b.put("614", LebaQzoneStyleProcessor.class);
    b.put("613", OpenSdkD55Processor.class);
    b.put("612", StudyRoomConfProcessor.class);
    b.put("611", AIOPlusPanelStudyModeAppInfoOrderConfigProcessor.class);
    b.put("610", StudyModeConfigProcessor.class);
    b.put("609", TroopDragonKingAnimEntryConfigProcessor.class);
    b.put("608", GameCenterMsgConfigProcessor.class);
    b.put("607", SubAccountConfProcessor.class);
    b.put("606", QfileFileAssistantTipsConfigProcessor.class);
    b.put("605", PublishHwkThirdPartyEntryConfigProcessor.class);
    b.put("600", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("598", LebaRedTouchSwitchProcessor.class);
    b.put("597", AppletNotificationConfProcessor.class);
    b.put("595", VSStickyNoteProcessor.class);
    b.put("593", EcshopConfProcessor.class);
    b.put("592", ECommerceDataReportConfigProcessor.class);
    b.put("591", QAVConfig.class);
    b.put("590", TroopShortcutBarConfigProcessor.class);
    b.put("589", UinSearchConfProcessor.class);
    b.put("587", PhotoListPanelConfProcessor.class);
    b.put("586", ColorNoteRecentConfigProcessor.class);
    b.put("585", WVPreloadPskeyConfProcessor.class);
    b.put("583", ExpandBannerProcessor.class);
    b.put("581", LowEndPerfProcessor.class);
    b.put("580", QVipPerfLevelProcessor.class);
    b.put("579", ImmersiveConfProcessor.class);
    b.put("578", OnlineStatusConfProcessor.class);
    b.put("577", MsgReporterSwitchConfigProcessor.class);
    b.put("576", DanmuConfProcessor.class);
    b.put("575", LocationEasterEggConfProcessor.class);
    b.put("574", AEPituCameraConfigProcessor.class);
    b.put("573", SuspiciousTroopConfProcessor.class);
    b.put("572", NotificationBannerConfProcessor.class);
    b.put("569", TencentDocFormKeyWordsProcessor.class);
    b.put("568", QAssistantConfigProcessor.class);
    b.put("567", BroadcastConfProcessor.class);
    b.put("566", BootOptimizeConfProcessor.class);
    b.put("564", RichTitleConfProcessor.class);
    b.put("563", QVipProfileMusicBoxProcessor.class);
    b.put("562", QVipSDKProcessor.class);
    b.put("561", FavLocalEmoticonsProcessor.class);
    b.put("560", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("559", TencentDocUrl2DocConfigProcessor.class);
    b.put("557", QFileExcitingC2CUploadConfigProcessor.class);
    b.put("556", QFileExcitingC2CDownloadConfigProcessor.class);
    b.put("555", QFileExcitingGroupDownloadConfigProcessor.class);
    b.put("554", QFileExcitingGroupUploadConfigProcessor.class);
    b.put("553", TogetherEntryConfProcessor.class);
    b.put("552", LocaleConfProcessor.class);
    b.put("551", SingTogetherConfProcessor.class);
    b.put("550", TroopMemRecommendConfProcessor.class);
    b.put("549", ColorNoteConfigProcessor.class);
    b.put("547", TDCRecomTroopConfigProcessor.class);
    b.put("546", QuickAuthorityConfProcessor.class);
    b.put("545", QQSysAndEmojiConfProcessor.class);
    b.put("544", TroopHonorConfigProcessor.class);
    b.put("542", QQLevelIconProcessor.class);
    b.put("541", KingCardProcessor.class);
    b.put("538", RichmediaIpv6ConifgProcessor.class);
    b.put("537", AIOVideoPlayConfigProcessor.class);
    b.put("535", TogetherBusinessConfProcessor.class);
    b.put("534", QQComicConfProcessor.class);
    b.put("532", LimitChatOnPlusConfProcessor.class);
    b.put("531", DarkModeConfigProcessor.class);
    b.put("530", PicShareToWXConfigProcessor.class);
    b.put("529", SigTopicConfProcessor.class);
    b.put("528", DeviceManageConfProcessor.class);
    b.put("527", QVIPPrettyTroopProcessor.class);
    b.put("526", SoLoaderConfProcessor.class);
    b.put("525", TencentDocLocalCooperationProcessor.class);
    b.put("524", MutualMarkConfProcessor.class);
    b.put("522", MsgBackupConfigProcessor.class);
    b.put("521", TenDocHistoryTabEmptyTipsProcessor.class);
    b.put("520", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("519", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("518", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("517", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("516", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("515", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("514", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("513", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("512", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("511", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("510", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("509", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("508", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("507", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("506", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("505", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("504", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("503", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("502", AIOPlusPanelAppInfoConfigProcessor.class);
    b.put("501", TdsReaderGrayConfigProcessor.class);
    b.put("500", TenDocGroupListEntryConfigProcessor.class);
    b.put("498", QVipAutoPttProcessor.class);
    b.put("497", WeiYunTipsBarConfigProcessor.class);
    b.put("496", AIOPanelIconConfigProcessor.C2CPanelConfigProcessor.class);
    b.put("495", AIOPlusPanelAppInfoOrderConfigProcessor.class);
    b.put("493", SysSuspiciousConfProcessor.class);
    b.put("492", GroupIntimateRelationshipConfProcessor.class);
    b.put("491", QQFriendRelation2Processor.class);
    b.put("490", RelationVipGrayProcessor.class);
    b.put("489", MsgTabCameraSwitchProcessor.class);
    b.put("488", PttWithTextSwitchProcessor.class);
    b.put("487", TencentDocMyFileNameProcessor.class);
    b.put("486", TenDocDirectShareConfigProcessor.class);
    b.put("485", ScreenShotConfigProcessor.class);
    b.put("484", WeiyunCheckAlbumConfigProcessor.class);
    b.put("483", TencentDocHistoryTabToastProcessor.class);
    b.put("482", TdsReaderConfigProcessor.class);
    b.put("479", CustomOnlineStatusProcessor.class);
    b.put("478", MultiAIOEntranceConfigProcessor.class);
    b.put("477", SSOErrorInfoMapProcessor.class);
    b.put("474", VSEntranceWidgetProcessor.class);
    b.put("473", VSEntranceStyleProcessor.class);
    b.put("470", MiniMsgConfigProcessor.class);
    b.put("469", QVipFriendTag2Processor.class);
    b.put("467", OpenSdkSwitchProcessor.class);
    b.put("466", OpenSdkRandomProcessor.class);
    b.put("465", QVipExtendIconProcessor.class);
    b.put("463", VSSubscribeProcessor.class);
    b.put("462", VideoDrawConfProcessor.class);
    b.put("460", TroopRobotConfProcessor.class);
    b.put("458", NewFriendContactGuideConfProcessor.class);
    b.put("457", RecommendTroopConfigProcessor.class);
    b.put("456", VerticalSearchConfProcessor.class);
    b.put("455", FriendIntimateRelationshipConfProcessor.class);
    b.put("454", WelcomeConfigProcessor.class);
    b.put("453", DonDisturbProcessor.class);
    b.put("452", C2CLovePushGrayProcessor.class);
    b.put("451", TencentDocPreviewConfigProcessor.class);
    b.put("449", QFileIPv6ConfigProcessor.class);
    b.put("447", WeSeeConfigProcessor.class);
    b.put("446", MiniAppApiReportProcessor.class);
    b.put("445", InputStatusConfig.class);
    b.put("444", QVipDiyTemplateProcessor.class);
    b.put("442", PttAutoChangeProcessor.class);
    b.put("441", QQGameConfProcessor.class);
    b.put("440", TencentDocMiniProgramGrayTipsProcessor.class);
    b.put("439", PushMsgBtnConfProcessor.class);
    b.put("438", ReportExposeConfigProcessor.class);
    b.put("437", TencentDocPreloadConfigProcessor.class);
    b.put("436", ScannerQQCodeConfProcessor.class);
    b.put("435", TroopUrlConfProcessor.class);
    b.put("434", SearchBusinessConfProcessor.class);
    b.put("433", SearchHotWordConfProcessor.class);
    b.put("432", SearchRichConfProcessor.class);
    b.put("431", AVTestforEncDecConfig.class);
    b.put("430", ApolloGrayConfProcessor.class);
    b.put("429", TencentDocEditConvertConfigProcessor.class);
    b.put("428", QVipBigTroopExpiredProcessor.class);
    b.put("427", QVipBigClubSVIP9Processor.class);
    b.put("426", OpenSdkConfProcessor.class);
    b.put("425", MiniAppConfProcessor.class);
    b.put("424", SafeModeProcessor.class);
    b.put("423", QVipRedNameCardProcessor.class);
    b.put("419", QConfLogProcessor.class);
    b.put("418", TencentDocsPushProcessor.class);
    b.put("416", TeleScreenConfig.class);
    b.put("414", GlobalSearchConfProcessor.class);
    b.put("413", QVipProfileFootPrintProcessor.class);
    b.put("412", QVipColorNickProcessor.class);
    b.put("411", VSEntranceProcessor.class);
    b.put("410", StickerRecConfigProcessor.class);
    b.put("409", QVipFriendTagProcessor.class);
    b.put("406", VSWaterMarkProcessor.class);
    b.put("396", QFileCommonConfigProcessor.class);
    b.put("390", QConfPushProcessor.class);
    b.put("383", TencentDocDataLineTipsConfigProcessor.class);
    b.put("382", QAVConfig.class);
    b.put("380", ArkPlatformConfProcessor.class);
    b.put("377", TencentDocImportFileInfoProcessor.class);
    b.put("370", QAVConfig.class);
    b.put("368", ReadinjoyResetFunctionConfProcessor.class);
    b.put("367", QAVConfig.class);
    b.put("362", SlideShowStoryConfig.class);
    b.put("361", WVStatisticsConfProcessor.class);
    b.put("359", VasFontSwitchProcessor.class);
    b.put("348", TencentDocStructMsgGrayTipsConfigProcessor.class);
    b.put("346", TencentDocTipsConfigProcessor.class);
    b.put("344", TencentDocUserConfigProcessor.class);
    b.put("342", TencentDocAIOShowGuideDialogProcessor.class);
    b.put("338", TencentDocGrayTipsProcessor.class);
    b.put("335", TencentDocSelectAddDocsProcessor.class);
    b.put("334", TencentDocAIOPlusPanelEntryConfigProcessor.class);
    b.put("325", RedDotConfProcessor.class);
    b.put("310", QIMDoodleConfigProcessor.class);
    b.put("309", QIMDynamicTextConfigProcessor.class);
    b.put("307", QIMTemplateConfigProcessor.class);
    b.put("306", QIMFilterConfigProcessor.class);
    b.put("305", QIMMusicConfigProcessor.class);
    b.put("304", QIMPasterConfigProcessor.class);
    b.put("298", QAVConfig.class);
    b.put("294", TencentDocConfigProcessor.class);
    b.put("292", ReadInjoySearchJumpurlConfProcessor.class);
    b.put("287", QAVConfig.class);
    b.put("276", QAVConfig.class);
    b.put("270", QAVConfig.class);
    b.put("267", HealthTimerConfigProcessor.class);
    b.put("263", QAVConfig.class);
    b.put("261", TencentDocConvertConfigProcessor.class);
    b.put("255", QConfigAPMProcessor.class);
    b.put("252", RedBagVideoResProcessor.class);
    b.put("251", PicCommonConfProcessor.class);
    b.put("250", ArkAIKeyWordSDKShareConfigProcessor.class);
    b.put("249", QAVConfig.class);
    b.put("216", QAVConfig.class);
    b.put("207", WVWhiteListConfProcessor.class);
    b.put("192", QAVConfig.class);
    b.put("190", SearchFunctionModuleProcessor.class);
    b.put("189", QVipStickerProcessor.class);
    b.put("186", ArkAIKeyWordConfigProcessor.class);
    b.put("176", QAVConfig.class);
    b.put("172", QAVConfig.class);
    b.put("170", ArkAIDictConfigProcessor.class);
    b.put("168", FlashChatConfProcessor.class);
    b.put("164", HotPicConfProcessor.class);
    b.put("159", ArkMsgAIDisableConfProcessor.class);
    b.put("158", WVSecurityConfProcessor.class);
    b.put("132", QAVConfig.class);
    b.put("106", QAVConfig.class);
    b.put("95", PushOpenNotificationProcessor.class);
    b.put("92", ReadinjoyCommonConfProcessor.class);
    b.put("85", QFileDownloadConfigProcessor.class);
    b.put("81", ServiceAccountFolderConfProcessor.class);
    b.put("76", QVipKeywordsProcessor.class);
    b.put("70", PublicAccountCenterUrlConfProcessor.class);
    b.put("68", PreloadConfProcessor.class);
    b.put("67", ApolloConfProcessor.class);
    b.put("50", SearchConfigProcessor.class);
    b.put("35", PaSubscribeRedDotProcessor.class);
    b.put("32", PublicAccountConfProcessor.class);
    b.put("26", QVipResourceProcessor.class);
    b.put("15", HighwayConfProcessor.class);
    c = new ArrayList();
    c.add(OldServletInjectorImpl.class);
    c.add(OldServletInjectorImpl.class);
  }
  
  private QConfigManager()
  {
    Object localObject2 = MobileQQ.sMobileQQ.getFilesDir();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = MobileQQ.sMobileQQ.getCacheDir();
    }
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).getParent();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("data");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("data");
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(MobileQQ.sMobileQQ.getPackageName());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("qstore");
    this.e = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QConfigManager constructor, rootPath=");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("QConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  private int a(IQConfigProcessor paramIQConfigProcessor, int paramInt, long paramLong)
  {
    paramInt = a(paramLong).getInt(String.valueOf(paramInt), -1);
    if (paramInt == -1) {
      return paramIQConfigProcessor.migrateOldVersion();
    }
    return paramInt;
  }
  
  private long a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      long l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (Exception localException)
    {
      label11:
      StringBuilder localStringBuilder;
      break label11;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not parse uin - ");
      localStringBuilder.append(paramString);
      QLog.d("QConfigManager", 2, localStringBuilder.toString());
    }
    return 0L;
  }
  
  private SharedPreferences a(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.a.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.k)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.a.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("conf_");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("_sharepref");
          localObject1 = ((StringBuilder)localObject1).toString();
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.a.put(Long.valueOf(paramLong), localSharedPreferences2);
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
    if (c.size() != 0) {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)c.get(0)).newInstance();
        return localIOldServletInjector;
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    } else {
      QLog.i("QConfigManager", 2, "getOldServletInjector. mOldServletInjectors.size() = 0");
    }
    return new BaseOldServletInjector();
  }
  
  private File a(String paramString1, String paramString2)
  {
    if (d(paramString1)) {
      return new File(paramString1, paramString2);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("mkdir dir failed, dir=");
      paramString2.append(paramString1);
      QLog.d("QConfigManager", 2, paramString2.toString());
    }
    return null;
  }
  
  private <T> T a(IQConfigProcessor<T> paramIQConfigProcessor, int paramInt)
  {
    Object localObject = paramIQConfigProcessor.migrateOldOrDefaultContent(paramInt);
    if (localObject == null) {
      return QConfigHelper.a(paramIQConfigProcessor.clazz());
    }
    return localObject;
  }
  
  private Object a(IQConfigProcessor paramIQConfigProcessor, long paramLong, int paramInt)
  {
    Object localObject2 = b(paramIQConfigProcessor.type());
    Object localObject1;
    if (localObject2 != null)
    {
      int n = paramIQConfigProcessor.type();
      int i1 = a(paramIQConfigProcessor, n, paramLong);
      localObject1 = localObject2;
      if (paramIQConfigProcessor.isNeedStoreLargeFile())
      {
        String str1 = a(n, paramLong, i1);
        String str2 = a(n, paramLong, paramInt);
        localObject1 = localObject2;
        if (!TextUtils.equals(str2, str1))
        {
          FileUtils.copyDirectory(str1, str2, false);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = paramIQConfigProcessor.migrateOldOrDefaultContent(0);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadNewConfigFailBackport, version=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", type");
      ((StringBuilder)localObject2).append(paramIQConfigProcessor.type());
      ((StringBuilder)localObject2).append(", conf=");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("QConfigManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
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
  
  private String a(int paramInt1, long paramLong, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramLong);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("conf");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnonnull +21 -> 25
    //   7: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: ldc_w 1511
    //   16: iconst_2
    //   17: ldc_w 1680
    //   20: invokestatic 1514	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokevirtual 1683	java/io/File:exists	()Z
    //   29: ifeq +510 -> 539
    //   32: aload_1
    //   33: invokevirtual 1686	java/io/File:isFile	()Z
    //   36: ifne +44 -> 80
    //   39: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +36 -> 78
    //   45: new 1481	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: ldc_w 1688
    //   57: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload_1
    //   63: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc_w 1511
    //   70: iconst_2
    //   71: aload_3
    //   72: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 1514	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_1
    //   81: invokevirtual 1691	java/io/File:canRead	()Z
    //   84: ifne +44 -> 128
    //   87: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +36 -> 126
    //   93: new 1481	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   100: astore_3
    //   101: aload_3
    //   102: ldc_w 1693
    //   105: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc_w 1511
    //   118: iconst_2
    //   119: aload_3
    //   120: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 1514	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aconst_null
    //   127: areturn
    //   128: new 1695	java/io/FileInputStream
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 1698	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: astore_3
    //   137: new 1700	java/io/InputStreamReader
    //   140: dup
    //   141: aload_3
    //   142: ldc_w 1702
    //   145: invokespecial 1705	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore 7
    //   150: aload_3
    //   151: astore 4
    //   153: aload 7
    //   155: astore 5
    //   157: aload_1
    //   158: invokevirtual 1709	java/io/File:length	()J
    //   161: l2i
    //   162: istore_2
    //   163: iload_2
    //   164: sipush 12288
    //   167: if_icmple +96 -> 263
    //   170: aload_3
    //   171: astore 4
    //   173: aload 7
    //   175: astore 5
    //   177: sipush 4096
    //   180: newarray char
    //   182: astore 6
    //   184: aload_3
    //   185: astore 4
    //   187: aload 7
    //   189: astore 5
    //   191: new 1481	java/lang/StringBuilder
    //   194: dup
    //   195: sipush 12288
    //   198: invokespecial 1712	java/lang/StringBuilder:<init>	(I)V
    //   201: astore 9
    //   203: aload_3
    //   204: astore 4
    //   206: aload 7
    //   208: astore 5
    //   210: aload 7
    //   212: aload 6
    //   214: invokevirtual 1716	java/io/InputStreamReader:read	([C)I
    //   217: istore_2
    //   218: iconst_m1
    //   219: iload_2
    //   220: if_icmpeq +23 -> 243
    //   223: aload_3
    //   224: astore 4
    //   226: aload 7
    //   228: astore 5
    //   230: aload 9
    //   232: aload 6
    //   234: iconst_0
    //   235: iload_2
    //   236: invokevirtual 1719	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: goto -37 -> 203
    //   243: aload_3
    //   244: astore 4
    //   246: aload 7
    //   248: astore 5
    //   250: aload 9
    //   252: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: astore 6
    //   257: aload 6
    //   259: astore_1
    //   260: goto +44 -> 304
    //   263: aload_3
    //   264: astore 4
    //   266: aload 7
    //   268: astore 5
    //   270: iload_2
    //   271: newarray char
    //   273: astore 6
    //   275: aload_3
    //   276: astore 4
    //   278: aload 7
    //   280: astore 5
    //   282: new 1522	java/lang/String
    //   285: dup
    //   286: aload 6
    //   288: iconst_0
    //   289: aload 7
    //   291: aload 6
    //   293: invokevirtual 1716	java/io/InputStreamReader:read	([C)I
    //   296: invokespecial 1722	java/lang/String:<init>	([CII)V
    //   299: astore 6
    //   301: aload 6
    //   303: astore_1
    //   304: aload_3
    //   305: invokevirtual 1727	java/io/InputStream:close	()V
    //   308: goto +8 -> 316
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 1728	java/lang/Exception:printStackTrace	()V
    //   316: aload_1
    //   317: astore 4
    //   319: aload 7
    //   321: invokevirtual 1729	java/io/InputStreamReader:close	()V
    //   324: aload_1
    //   325: areturn
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 1728	java/lang/Exception:printStackTrace	()V
    //   331: aload 4
    //   333: areturn
    //   334: astore 4
    //   336: aload_3
    //   337: astore 6
    //   339: aload 7
    //   341: astore_3
    //   342: aload 4
    //   344: astore 7
    //   346: goto +41 -> 387
    //   349: astore_1
    //   350: aconst_null
    //   351: astore 5
    //   353: goto +150 -> 503
    //   356: astore 7
    //   358: aconst_null
    //   359: astore 4
    //   361: aload_3
    //   362: astore 6
    //   364: aload 4
    //   366: astore_3
    //   367: goto +20 -> 387
    //   370: astore_1
    //   371: aconst_null
    //   372: astore_3
    //   373: aload_3
    //   374: astore 5
    //   376: goto +127 -> 503
    //   379: astore 7
    //   381: aconst_null
    //   382: astore 6
    //   384: aload 6
    //   386: astore_3
    //   387: aload 6
    //   389: astore 4
    //   391: aload_3
    //   392: astore 5
    //   394: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +70 -> 467
    //   400: aload 6
    //   402: astore 4
    //   404: aload_3
    //   405: astore 5
    //   407: new 1481	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   414: astore 9
    //   416: aload 6
    //   418: astore 4
    //   420: aload_3
    //   421: astore 5
    //   423: aload 9
    //   425: ldc_w 1731
    //   428: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 6
    //   434: astore 4
    //   436: aload_3
    //   437: astore 5
    //   439: aload 9
    //   441: aload_1
    //   442: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 6
    //   448: astore 4
    //   450: aload_3
    //   451: astore 5
    //   453: ldc_w 1511
    //   456: iconst_2
    //   457: aload 9
    //   459: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: aload 7
    //   464: invokestatic 1734	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   467: aload 6
    //   469: ifnull +16 -> 485
    //   472: aload 6
    //   474: invokevirtual 1727	java/io/InputStream:close	()V
    //   477: goto +8 -> 485
    //   480: astore_1
    //   481: aload_1
    //   482: invokevirtual 1728	java/lang/Exception:printStackTrace	()V
    //   485: aload_3
    //   486: ifnull +11 -> 497
    //   489: aload 8
    //   491: astore 4
    //   493: aload_3
    //   494: invokevirtual 1729	java/io/InputStreamReader:close	()V
    //   497: aconst_null
    //   498: areturn
    //   499: astore_1
    //   500: aload 4
    //   502: astore_3
    //   503: aload_3
    //   504: ifnull +15 -> 519
    //   507: aload_3
    //   508: invokevirtual 1727	java/io/InputStream:close	()V
    //   511: goto +8 -> 519
    //   514: astore_3
    //   515: aload_3
    //   516: invokevirtual 1728	java/lang/Exception:printStackTrace	()V
    //   519: aload 5
    //   521: ifnull +16 -> 537
    //   524: aload 5
    //   526: invokevirtual 1729	java/io/InputStreamReader:close	()V
    //   529: goto +8 -> 537
    //   532: astore_3
    //   533: aload_3
    //   534: invokevirtual 1728	java/lang/Exception:printStackTrace	()V
    //   537: aload_1
    //   538: athrow
    //   539: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +36 -> 578
    //   545: new 1481	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   552: astore_3
    //   553: aload_3
    //   554: ldc_w 1736
    //   557: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_3
    //   562: aload_1
    //   563: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: ldc_w 1511
    //   570: iconst_2
    //   571: aload_3
    //   572: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 1514	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aconst_null
    //   579: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	QConfigManager
    //   0	580	1	paramFile	File
    //   162	109	2	n	int
    //   52	253	3	localObject1	Object
    //   311	26	3	localException1	Exception
    //   341	167	3	localObject2	Object
    //   514	2	3	localException2	Exception
    //   532	2	3	localException3	Exception
    //   552	20	3	localStringBuilder1	StringBuilder
    //   151	181	4	localObject3	Object
    //   334	9	4	localException4	Exception
    //   359	142	4	localObject4	Object
    //   155	370	5	localObject5	Object
    //   182	291	6	localObject6	Object
    //   148	197	7	localObject7	Object
    //   356	1	7	localException5	Exception
    //   379	84	7	localException6	Exception
    //   1	489	8	localObject8	Object
    //   201	257	9	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   304	308	311	java/lang/Exception
    //   319	324	326	java/lang/Exception
    //   493	497	326	java/lang/Exception
    //   157	163	334	java/lang/Exception
    //   177	184	334	java/lang/Exception
    //   191	203	334	java/lang/Exception
    //   210	218	334	java/lang/Exception
    //   230	240	334	java/lang/Exception
    //   250	257	334	java/lang/Exception
    //   270	275	334	java/lang/Exception
    //   282	301	334	java/lang/Exception
    //   137	150	349	finally
    //   137	150	356	java/lang/Exception
    //   128	137	370	finally
    //   128	137	379	java/lang/Exception
    //   472	477	480	java/lang/Exception
    //   157	163	499	finally
    //   177	184	499	finally
    //   191	203	499	finally
    //   210	218	499	finally
    //   230	240	499	finally
    //   250	257	499	finally
    //   270	275	499	finally
    //   282	301	499	finally
    //   394	400	499	finally
    //   407	416	499	finally
    //   423	432	499	finally
    //   439	446	499	finally
    //   453	467	499	finally
    //   507	511	514	java/lang/Exception
    //   524	529	532	java/lang/Exception
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt)
  {
    int i1 = paramConfig.msg_content_list.size();
    if (i1 == 0) {}
    for (paramConfig = paramIQConfigProcessor.migrateOldOrDefaultContent(1);; paramConfig = a(paramIQConfigProcessor, paramLong, paramInt))
    {
      break;
      ArrayList localArrayList = new ArrayList();
      int n = 0;
      while (n < i1)
      {
        ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(n);
        if ((localContent != null) && (localContent.content.has())) {
          if (localContent.compress.get() == 1)
          {
            localObject = QConfigHelper.a(localContent.content.get().toByteArray());
            if (localObject == null) {}
          }
        }
        try
        {
          localObject = new String((byte[])localObject, "UTF-8");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          label122:
          boolean bool;
          break label122;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "decompile faild.");
        }
        localObject = null;
        break label157;
        localObject = localContent.content.get().toStringUtf8();
        label157:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localArrayList.add(new QConfItem(localContent.task_id.get(), (String)localObject));
        }
        n += 1;
      }
      Object localObject = new QConfItem[localArrayList.size()];
      localArrayList.toArray((Object[])localObject);
      paramConfig = a(paramIQConfigProcessor, (QConfItem[])localObject, paramInt);
      if (paramConfig != null)
      {
        a(paramIQConfigProcessor, (QConfItem[])localObject, paramLong, paramString);
        this.g.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, paramConfig));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("handleNewConfig, parse success, size=");
          paramString.append(localObject.length);
          QLog.d("QConfigManager", 2, paramString.toString());
        }
        break;
      }
    }
    if (i1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    a(paramIQConfigProcessor, paramConfig, paramInt, paramLong, bool);
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, Object paramObject, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      SharedPreferences.Editor localEditor = a(paramLong).edit().putInt(String.valueOf(paramIQConfigProcessor.type()), paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIQConfigProcessor.type());
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_defualt");
      localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
      if (!paramIQConfigProcessor.isNeedReloadConf()) {
        this.g.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, paramObject));
      }
      paramIQConfigProcessor.onUpdate(paramObject);
    }
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, long paramLong, String paramString)
  {
    boolean bool = paramIQConfigProcessor.isNeedStoreLargeFile();
    int i1 = 0;
    int n = 0;
    if (bool)
    {
      b(new File(paramString));
      i1 = paramArrayOfQConfItem.length;
      while (n < i1)
      {
        paramIQConfigProcessor = paramArrayOfQConfItem[n];
        localObject1 = a(paramString, String.valueOf(paramIQConfigProcessor.a));
        if (localObject1 != null) {
          a(paramIQConfigProcessor.b, (File)localObject1);
        }
        n += 1;
      }
    }
    paramString = c(paramLong);
    if (paramString == null)
    {
      QLog.e("QConfigManager", 1, "getContentSp return null!");
      return;
    }
    paramString = paramString.edit();
    Object localObject1 = new HashSet();
    int i2 = paramArrayOfQConfItem.length;
    n = i1;
    while (n < i2)
    {
      localObject2 = paramArrayOfQConfItem[n];
      ((Set)localObject1).add(String.valueOf(((QConfItem)localObject2).a));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIQConfigProcessor.type());
      localStringBuilder.append("_");
      localStringBuilder.append(((QConfItem)localObject2).a);
      paramString.putString(localStringBuilder.toString(), ((QConfItem)localObject2).b);
      n += 1;
    }
    paramArrayOfQConfItem = a(paramLong).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramIQConfigProcessor.type());
    ((StringBuilder)localObject2).append("_ids");
    paramArrayOfQConfItem.putStringSet(((StringBuilder)localObject2).toString(), (Set)localObject1).apply();
    paramString.apply();
  }
  
  public static void a(ArrayList<QConReqExtraInfo> paramArrayList)
  {
    a(paramArrayList, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
  }
  
  public static void a(ArrayList<QConReqExtraInfo> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      a(paramArrayList, paramString, false);
    }
  }
  
  public static void a(ArrayList<QConReqExtraInfo> paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      localObject = paramArrayList.iterator();
      for (;;)
      {
        bool = paramBoolean;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        QConReqExtraInfo localQConReqExtraInfo = (QConReqExtraInfo)((Iterator)localObject).next();
        if ((b().c(localQConReqExtraInfo.a)) && (b().a(localQConReqExtraInfo.a).isAccountRelated()))
        {
          QLog.d("QConfigManager", 2, "getConfig: processor.isAccountRelated, withoutLogin=true");
          paramBoolean = false;
        }
      }
    }
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
    QConfigServlet.a = (String)localObject;
    paramString = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    paramString.putParcelableArrayListExtra("k_cmd_type", paramArrayList);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString.putExtra("key_uin", (String)localObject);
    }
    if (bool) {
      paramString.setWithouLogin(bool);
    }
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString);
  }
  
  public static void a(int[] paramArrayOfInt, String paramString)
  {
    a(paramArrayOfInt, paramString, false);
  }
  
  public static void a(int[] paramArrayOfInt, String paramString, boolean paramBoolean)
  {
    a(QConfigHelper.a(paramArrayOfInt), paramString, paramBoolean);
  }
  
  protected static void a(int[] paramArrayOfInt, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    localNewIntent.putParcelableArrayListExtra("k_cmd_type", QConfigHelper.a(paramArrayOfInt));
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
  
  /* Error */
  private boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 1683	java/io/File:exists	()Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iload_3
    //   9: ifne +59 -> 68
    //   12: aload_2
    //   13: invokevirtual 2008	java/io/File:createNewFile	()Z
    //   16: pop
    //   17: goto +51 -> 68
    //   20: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +40 -> 63
    //   26: new 1481	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc_w 2010
    //   40: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 5
    //   46: aload_2
    //   47: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc_w 1511
    //   54: iconst_2
    //   55: aload 5
    //   57: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 1514	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: iconst_0
    //   64: istore_3
    //   65: goto +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: new 2012	java/io/FileOutputStream
    //   73: dup
    //   74: aload_2
    //   75: iconst_0
    //   76: invokespecial 2015	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   79: astore 5
    //   81: goto +8 -> 89
    //   84: aconst_null
    //   85: astore 5
    //   87: iconst_0
    //   88: istore_3
    //   89: aload 5
    //   91: ifnull +96 -> 187
    //   94: aload 5
    //   96: aload_1
    //   97: invokevirtual 2018	java/lang/String:getBytes	()[B
    //   100: invokevirtual 2022	java/io/FileOutputStream:write	([B)V
    //   103: aload 5
    //   105: invokevirtual 2025	java/io/FileOutputStream:flush	()V
    //   108: goto +79 -> 187
    //   111: astore_1
    //   112: goto +63 -> 175
    //   115: astore_1
    //   116: invokestatic 1507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +41 -> 160
    //   122: new 1481	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 1482	java/lang/StringBuilder:<init>	()V
    //   129: astore 6
    //   131: aload 6
    //   133: ldc_w 2027
    //   136: invokevirtual 1489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 6
    //   142: aload_2
    //   143: invokevirtual 1662	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc_w 1511
    //   150: iconst_2
    //   151: aload 6
    //   153: invokevirtual 1497	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aload_1
    //   157: invokestatic 1734	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: iload 4
    //   162: istore_3
    //   163: aload 5
    //   165: ifnull +32 -> 197
    //   168: aload 5
    //   170: invokevirtual 2028	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 2028	java/io/FileOutputStream:close	()V
    //   185: aload_1
    //   186: athrow
    //   187: aload 5
    //   189: ifnull +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 2028	java/io/FileOutputStream:close	()V
    //   197: iload_3
    //   198: ireturn
    //   199: astore 5
    //   201: goto -181 -> 20
    //   204: astore 5
    //   206: goto -122 -> 84
    //   209: astore_1
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_2
    //   213: goto -28 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	QConfigManager
    //   0	216	1	paramString	String
    //   0	216	2	paramFile	File
    //   4	194	3	bool1	boolean
    //   6	155	4	bool2	boolean
    //   33	160	5	localObject	Object
    //   199	1	5	localIOException	java.io.IOException
    //   204	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   129	23	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	108	111	finally
    //   116	160	111	finally
    //   94	108	115	java/io/IOException
    //   12	17	199	java/io/IOException
    //   70	81	204	java/io/FileNotFoundException
    //   168	173	209	java/io/IOException
    //   192	197	209	java/io/IOException
    //   180	185	212	java/io/IOException
  }
  
  private SharedPreferences b(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.i.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.m)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.i.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("conf_");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("_upgrade_pref");
          localObject1 = ((StringBuilder)localObject1).toString();
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.i.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  public static QConfigManager b()
  {
    return QConfigManager.Holder.a;
  }
  
  private void b(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt)
  {
    if (paramConfig.content_list.isEmpty()) {}
    for (paramString = paramIQConfigProcessor.migrateOldOrDefaultContent(1);; paramString = a(paramIQConfigProcessor, paramLong, paramInt))
    {
      break;
      int i1 = paramConfig.content_list.size();
      QConfItem[] arrayOfQConfItem = new QConfItem[i1];
      int n = 0;
      while (n < i1)
      {
        arrayOfQConfItem[n] = new QConfItem(n, (String)paramConfig.content_list.get(n));
        n += 1;
      }
      Object localObject = a(paramIQConfigProcessor, arrayOfQConfItem, paramInt);
      if (localObject != null)
      {
        a(paramIQConfigProcessor, arrayOfQConfItem, paramLong, paramString);
        this.g.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, localObject));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("handleOldConfig, parse success, size=");
          paramString.append(i1);
          QLog.d("QConfigManager", 2, paramString.toString());
        }
        paramString = localObject;
        break;
      }
    }
    a(paramIQConfigProcessor, paramString, paramInt, paramLong, paramConfig.content_list.isEmpty());
  }
  
  private void b(File paramFile)
  {
    int i1;
    int n;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      if (paramFile.listFiles().length != 0)
      {
        paramFile = paramFile.listFiles();
        i1 = paramFile.length;
        n = 0;
      }
    }
    else {
      while (n < i1)
      {
        c(paramFile[n]);
        n += 1;
        continue;
        c(paramFile);
      }
    }
  }
  
  public static void b(String paramString)
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAllConfigs: uin=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject).toString());
        localObject = paramString;
      }
    }
    QConfigServlet.a = (String)localObject;
    paramString = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    paramString.putParcelableArrayListExtra("k_cmd_type", QConfigHelper.a(c()));
    paramString.putExtra("key_uin", (String)localObject);
    paramString.putExtra("k_req_occasion", 0);
    paramString.putExtra("key_is_all_config", true);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString);
  }
  
  private SharedPreferences c(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.h.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.l)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.h.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("conf_");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("_content_sharepref");
          localObject1 = ((StringBuilder)localObject1).toString();
          localSharedPreferences2 = MobileQQ.sMobileQQ.getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.h.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private IQConfigProcessor c(String paramString)
  {
    Object localObject = (Class)b.get(paramString);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("genProcessor, clazz=null, type=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = (IQConfigProcessor)((Constructor)localObject).newInstance(new Object[0]);
      try
      {
        ((IQConfigProcessor)localObject).onProcessorConstructed(Integer.parseInt(paramString));
        return localObject;
      }
      catch (Exception localException2)
      {
        paramString = (String)localObject;
        localObject = localException2;
      }
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      paramString = null;
    }
    return paramString;
  }
  
  private boolean c(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i1 = arrayOfString.length;
        int n = 0;
        while (n < i1)
        {
          if (!c(new File(paramFile, arrayOfString[n]))) {
            return false;
          }
          n += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  protected static int[] c()
  {
    int[] arrayOfInt = new int[b.size()];
    Object localObject = b.keySet().iterator();
    int n = 0;
    while (((Iterator)localObject).hasNext())
    {
      arrayOfInt[n] = Integer.parseInt((String)((Iterator)localObject).next());
      n += 1;
    }
    localObject = new int[a().a().length + arrayOfInt.length];
    System.arraycopy(a().a(), 0, localObject, 0, a().a().length);
    System.arraycopy(arrayOfInt, 0, localObject, a().a().length, arrayOfInt.length);
    return localObject;
  }
  
  private QConfItem[] c(int paramInt, long paramLong)
  {
    int n = a(paramInt, paramLong);
    if (d(paramInt) == null) {
      return null;
    }
    Object localObject = new File(a(paramInt, paramLong, n));
    File[] arrayOfFile = ((File)localObject).listFiles();
    if ((((File)localObject).exists()) && (arrayOfFile != null))
    {
      if (arrayOfFile.length == 0) {
        return null;
      }
      localObject = new QConfItem[arrayOfFile.length];
      paramInt = 0;
      while (paramInt < arrayOfFile.length)
      {
        File localFile = arrayOfFile[paramInt];
        localObject[paramInt] = new QConfItem(d(localFile), a(localFile));
        paramInt += 1;
      }
      return localObject;
    }
    return null;
  }
  
  private int d(File paramFile)
  {
    try
    {
      int n = Integer.parseInt(paramFile.getName());
      return n;
    }
    catch (NumberFormatException paramFile)
    {
      label10:
      break label10;
    }
    return -1024;
  }
  
  private IQConfigProcessor d(int paramInt)
  {
    return a(paramInt);
  }
  
  private boolean d(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  private QConfItem[] d(int paramInt, long paramLong)
  {
    if (a(paramInt) == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getConfigFromSp, type is not support, type=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      return null;
    }
    Object localObject2 = a(paramLong);
    Object localObject1 = c(paramLong);
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getVersionSp return null!");
      }
      return null;
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getContentSp return null!");
      }
      return null;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramInt);
    ((StringBuilder)localObject3).append("_ids");
    localObject3 = ((SharedPreferences)localObject2).getStringSet(((StringBuilder)localObject3).toString(), null);
    if (localObject3 != null)
    {
      if (((Set)localObject3).isEmpty()) {
        return null;
      }
      localObject2 = new QConfItem[((Set)localObject3).size()];
      int n = 0;
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        int i1 = Integer.parseInt(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("_");
        localStringBuilder.append(str);
        localObject2[n] = new QConfItem(i1, ((SharedPreferences)localObject1).getString(localStringBuilder.toString(), null));
        n += 1;
      }
      return localObject2;
    }
    return null;
  }
  
  private String e(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QConfigManager", 2, new Object[] { "getCookieNewFileDir, uin: ", paramString });
      }
      str = "9999";
    }
    paramString = new StringBuilder();
    paramString.append(this.e);
    paramString.append(File.separator);
    paramString.append(str);
    paramString.append(File.separator);
    paramString.append("conf");
    paramString.append(File.separator);
    paramString.append("cookie_new");
    return paramString.toString();
  }
  
  public int a(int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getConfVersion, process is null, type=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject).toString());
      }
      return -1;
    }
    return a((IQConfigProcessor)localObject, paramInt, paramLong);
  }
  
  public int a(int paramInt, String paramString)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("getConfVersion, process is null, type=");
        paramString.append(paramInt);
        QLog.d("QConfigManager", 2, paramString.toString());
      }
      return -1;
    }
    return a(localIQConfigProcessor, paramInt, a(paramString, localIQConfigProcessor.isAccountRelated()));
  }
  
  public IQConfigProcessor a(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor3 = (IQConfigProcessor)this.f.get(Integer.valueOf(paramInt));
    IQConfigProcessor localIQConfigProcessor1 = localIQConfigProcessor3;
    if (localIQConfigProcessor3 == null) {
      synchronized (this.j)
      {
        localIQConfigProcessor3 = (IQConfigProcessor)this.f.get(Integer.valueOf(paramInt));
        localIQConfigProcessor1 = localIQConfigProcessor3;
        if (localIQConfigProcessor3 == null)
        {
          localIQConfigProcessor3 = c(String.valueOf(paramInt));
          localIQConfigProcessor1 = localIQConfigProcessor3;
          if (localIQConfigProcessor3 != null)
          {
            this.f.put(Integer.valueOf(paramInt), localIQConfigProcessor3);
            localIQConfigProcessor1 = localIQConfigProcessor3;
          }
        }
      }
    }
    if ((localIQConfigProcessor2 == null) && (QLog.isColorLevel())) {
      QLog.d("QConfigManager", 2, "getConfProcess, processor=null");
    }
    return localIQConfigProcessor2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = a(paramInt1);
    Object localObject2;
    if ((localObject1 != null) && (((IQConfigProcessor)localObject1).isAccountRelated()))
    {
      localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject2 != null)
      {
        l1 = a(((AppRuntime)localObject2).getAccount(), ((IQConfigProcessor)localObject1).isAccountRelated());
        break label56;
      }
    }
    long l1 = 0L;
    label56:
    localObject1 = a(l1);
    int n = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt1), -1);
    if ((n != -1) && (n != paramInt2))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setConfVersion t=");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(" v=");
        ((StringBuilder)localObject2).append(paramInt2);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject2).toString());
      }
      ((SharedPreferences)localObject1).edit().putInt(String.valueOf(paramInt1), paramInt2).apply();
    }
  }
  
  public void a(int paramInt1, int paramInt2, ConfigurationService.Config paramConfig, String paramString)
  {
    int n = b(paramInt1, Long.parseLong(paramString));
    if (n == paramInt2) {
      return;
    }
    if (QConfigJourney.a().a(paramInt1, paramInt2))
    {
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("conf has been deleted by safemode, type=");
        paramConfig.append(paramInt1);
        paramConfig.append(", version=");
        paramConfig.append(paramInt2);
        QLog.d("QConfigManager", 2, paramConfig.toString());
      }
      return;
    }
    IQConfigProcessor localIQConfigProcessor = d(paramInt1);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel())
      {
        paramConfig = new StringBuilder();
        paramConfig.append("Has not define an process,");
        paramConfig.append(paramInt1);
        QLog.d("QConfigManager", 2, paramConfig.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("save config, ov=");
      ((StringBuilder)???).append(n);
      ((StringBuilder)???).append(" to nv=");
      ((StringBuilder)???).append(paramInt2);
      ((StringBuilder)???).append(", type=");
      ((StringBuilder)???).append(paramInt1);
      QLog.d("QConfigManager", 2, ((StringBuilder)???).toString());
    }
    long l1 = a(paramString, localIQConfigProcessor.isAccountRelated());
    paramString = a(paramInt1, l1, paramInt2);
    ??? = d;
    synchronized (???[(paramInt1 % ???.length)])
    {
      if ((localIQConfigProcessor.isNeedStoreLargeFile()) && (!d(paramString)))
      {
        if (QLog.isColorLevel())
        {
          paramConfig = new StringBuilder();
          paramConfig.append("create conf dir failed, dir=");
          paramConfig.append(paramString);
          QLog.d("QConfigManager", 2, paramConfig.toString());
        }
        return;
      }
      if (localIQConfigProcessor.isNeedCompressed()) {
        a(localIQConfigProcessor, paramConfig, l1, paramString, paramInt2);
      } else {
        b(localIQConfigProcessor, paramConfig, l1, paramString, paramInt2);
      }
      QConfigJourney.a().a(paramInt1, l1, localIQConfigProcessor.isNeedStoreLargeFile());
      return;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      int i2 = paramArrayOfInt[n];
      if (!c(i2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QConfigManager has not support the config yet, type=");
        ((StringBuilder)localObject).append(i2);
        QConfigHelper.a(new IllegalStateException(((StringBuilder)localObject).toString()));
      }
      n += 1;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = ((AppRuntime)localObject).getAccount();
    QConfigServlet.a = str;
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    localNewIntent.putParcelableArrayListExtra("k_cmd_type", QConfigHelper.a(paramArrayOfInt));
    localNewIntent.putExtra("key_uin", str);
    ((AppRuntime)localObject).startServlet(localNewIntent);
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    return FileUtils.writeFile(paramArrayOfByte, e(paramString));
  }
  
  public boolean a(AppRuntime paramAppRuntime, int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = a(paramInt);
    if (localIQConfigProcessor == null) {
      return false;
    }
    if (localIQConfigProcessor.isNeedUpgradeReset())
    {
      paramAppRuntime = b(paramAppRuntime.getLongAccountUin());
      if (paramAppRuntime == null) {
        return false;
      }
      paramAppRuntime = paramAppRuntime.getString(String.valueOf(paramInt), "");
      return TextUtils.equals(AppSetting.i(), paramAppRuntime) ^ true;
    }
    return false;
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.readFile(e(paramString));
  }
  
  public int b(int paramInt, long paramLong)
  {
    int n = b().a(paramInt, paramLong);
    Object localObject = a(paramInt);
    if ((localObject != null) && (((IQConfigProcessor)localObject).isNeedUpgradeReset()) && (n == 0))
    {
      localObject = b(paramLong);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putString(String.valueOf(paramInt), AppSetting.i()).apply();
      }
    }
    return n;
  }
  
  public <T> T b(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = d(paramInt);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, new Object[] { "loadConObj: processor=null, type=", Integer.valueOf(paramInt) });
      }
      return null;
    }
    long l1;
    if (localIQConfigProcessor.isAccountRelated())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 != null)
      {
        l1 = a(((SimpleAccount)localObject1).getUin(), localIQConfigProcessor.isAccountRelated());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
        }
        return a(localIQConfigProcessor, 1);
      }
    }
    else
    {
      l1 = 0L;
    }
    Object localObject1 = a(l1);
    int n = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
    if (n == -1) {
      return a(localIQConfigProcessor, 0);
    }
    Object localObject3 = (QConfigManager.CacheItem)this.g.get(Integer.valueOf(paramInt));
    if ((localObject3 != null) && (((QConfigManager.CacheItem)localObject3).b == n) && (((QConfigManager.CacheItem)localObject3).a == l1) && (((QConfigManager.CacheItem)localObject3).c != null)) {
      return ((QConfigManager.CacheItem)localObject3).c;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localIQConfigProcessor.type());
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(n);
    ((StringBuilder)localObject3).append("_defualt");
    if (((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject3).toString(), false)) {
      return a(localIQConfigProcessor, 0);
    }
    localObject1 = d;
    for (;;)
    {
      synchronized (localObject1[(paramInt % localObject1.length)])
      {
        if (localIQConfigProcessor.isNeedStoreLargeFile()) {
          localObject1 = c(paramInt, l1);
        } else {
          localObject1 = d(paramInt, l1);
        }
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, new Object[] { "loadConObj: type:", Integer.valueOf(paramInt), " --> get data from file or sp return null" });
          }
          localObject1 = QConfigHelper.a(localIQConfigProcessor.clazz());
          return localObject1;
        }
        try
        {
          localObject3 = localIQConfigProcessor.onParsed((QConfItem[])localObject1);
          if (localObject3 == null)
          {
            if (QLog.isColorLevel())
            {
              if ((localObject1.length != 0) && (localObject1[0] != null))
              {
                localObject3 = localObject1[0].b;
                QLog.d("QConfigManager", 2, new Object[] { "loadConObj: onParse return null, type=", Integer.valueOf(paramInt), " confs[0]:", localObject3 });
              }
            }
            else
            {
              localObject3 = QConfigHelper.a(localIQConfigProcessor.clazz());
              return localObject3;
            }
          }
          else
          {
            this.g.put(Integer.valueOf(paramInt), new QConfigManager.CacheItem(l1, n, localObject3));
            return localObject3;
          }
        }
        catch (Exception localException)
        {
          QConfigWatchDog.a().a(localIQConfigProcessor, (QConfItem[])localObject1, n, localException);
          localObject1 = QConfigHelper.a(localIQConfigProcessor.clazz());
          return localObject1;
        }
      }
      String str = "null";
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = d(paramInt);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("noReceive method has not define an process,");
        paramString.append(paramInt);
        QLog.d("QConfigManager", 2, paramString.toString());
      }
      return;
    }
    try
    {
      ((IQConfigProcessor)localObject).onReqNoReceive();
      b(paramInt, Long.parseLong(paramString));
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Handle noReceive operation exception, type=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject).toString(), paramString);
      }
    }
  }
  
  public boolean c(int paramInt)
  {
    return b.containsKey(String.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigManager
 * JD-Core Version:    0.7.0.1
 */