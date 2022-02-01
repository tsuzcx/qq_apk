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
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgConfigProcessor;
import com.tencent.mobileqq.gamecenter.share.GameShareConfProcessor;
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
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGamePAConfProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigProcessor;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor.C2CPanelConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.pluspanel.AIOPlusPanelStudyModeAppInfoOrderConfigProcessor;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfigProcessor;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerProcessor;
import com.tencent.mobileqq.qqexpand.manager.config.LimitChatOnPlusConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.GameCenterEnterConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGameConfProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreDownloadConfigProcessor;
import com.tencent.mobileqq.qqgamepub.config.QQGamePreloadConfProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qrscan.config.ScannerQQCodeConfProcessor;
import com.tencent.mobileqq.qwallet.config.PreloadConfProcessor;
import com.tencent.mobileqq.relationx.friendclue.FriendClueConfigProcessor;
import com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor;
import com.tencent.mobileqq.screendetect.ScreenShotConfigProcessor;
import com.tencent.mobileqq.search.config.SearchConfigProcessor;
import com.tencent.mobileqq.search.config.SearchFunctionModuleProcessor;
import com.tencent.mobileqq.settings.config.AllSettingConfigProcessor;
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
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfigProcessor;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationConfigProcessor;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfigProcessor;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
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
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_old_servlet.yml", version=3)
  public static ArrayList<Class<? extends IOldServletInjector>> a;
  @ConfigInject(configPath="/Foundation/QQCommon/src/main/resources/Inject_config_processor_map.yml", version=13)
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
    for (;;)
    {
      Object[] arrayOfObject = jdField_a_of_type_ArrayOfJavaLangObject;
      if (i >= arrayOfObject.length) {
        break;
      }
      arrayOfObject[i] = new Object();
      i += 1;
    }
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("743", QQSettingMeMenuConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("745", AlbumConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("744", RecentOptPopBarSwitchProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("742", ExpMgrListProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("741", MiniGamePAConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("740", TencentDocDrawerConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("739", QQGamePreDownloadConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("738", StepConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("737", FloatingPermissionConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("736", ExternalDirOperationConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("735", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("734", QVipHippyProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("732", QSafeConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("730", CommonFunctionPublishConfigProcessor.class);
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
    jdField_a_of_type_JavaUtilHashMap.put("671", HealthConfigProcessor.class);
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
    jdField_a_of_type_JavaUtilHashMap.put("583", ExpandBannerProcessor.class);
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
    jdField_a_of_type_JavaUtilHashMap.put("380", ArkPlatformConfProcessor.class);
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
    jdField_a_of_type_JavaUtilHashMap.put("267", HealthTimerConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("263", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("261", TencentDocConvertConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("255", QConfigAPMProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("252", RedBagVideoResProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("251", PicCommonConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("250", ArkAIKeyWordSDKShareConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("249", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("216", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("207", WVWhiteListConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("192", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("190", SearchFunctionModuleProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("189", QVipStickerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("186", ArkAIKeyWordConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("176", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("172", QAVConfig.class);
    jdField_a_of_type_JavaUtilHashMap.put("170", ArkAIDictConfigProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("168", FlashChatConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("164", HotPicConfProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("159", ArkMsgAIDisableConfProcessor.class);
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
    jdField_a_of_type_JavaUtilHashMap.put("50", SearchConfigProcessor.class);
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
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QConfigManager constructor, rootPath=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
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
  
  private int a(File paramFile)
  {
    try
    {
      int i = Integer.parseInt(paramFile.getName());
      return i;
    }
    catch (NumberFormatException paramFile)
    {
      label10:
      break label10;
    }
    return -1024;
  }
  
  private long a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      long l = Long.parseLong(paramString);
      return l;
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
    Object localObject1 = (SharedPreferences)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong));
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
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0) {
      try
      {
        IOldServletInjector localIOldServletInjector = (IOldServletInjector)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
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
  
  private IQConfigProcessor a(String paramString)
  {
    Object localObject = (Class)jdField_a_of_type_JavaUtilHashMap.get(paramString);
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
  
  public static QConfigManager a()
  {
    return QConfigManager.Holder.a;
  }
  
  private File a(String paramString1, String paramString2)
  {
    if (a(paramString1)) {
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
    Object localObject2 = a(paramIQConfigProcessor.type());
    Object localObject1;
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
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
    //   7: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: ldc_w 1401
    //   16: iconst_2
    //   17: ldc_w 1611
    //   20: invokestatic 1404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_1
    //   26: invokevirtual 1614	java/io/File:exists	()Z
    //   29: ifeq +510 -> 539
    //   32: aload_1
    //   33: invokevirtual 1617	java/io/File:isFile	()Z
    //   36: ifne +44 -> 80
    //   39: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +36 -> 78
    //   45: new 1371	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: ldc_w 1619
    //   57: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_3
    //   62: aload_1
    //   63: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc_w 1401
    //   70: iconst_2
    //   71: aload_3
    //   72: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 1404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aconst_null
    //   79: areturn
    //   80: aload_1
    //   81: invokevirtual 1622	java/io/File:canRead	()Z
    //   84: ifne +44 -> 128
    //   87: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +36 -> 126
    //   93: new 1371	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   100: astore_3
    //   101: aload_3
    //   102: ldc_w 1624
    //   105: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc_w 1401
    //   118: iconst_2
    //   119: aload_3
    //   120: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 1404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aconst_null
    //   127: areturn
    //   128: new 1626	java/io/FileInputStream
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 1629	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: astore_3
    //   137: new 1631	java/io/InputStreamReader
    //   140: dup
    //   141: aload_3
    //   142: ldc_w 1633
    //   145: invokespecial 1636	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore 7
    //   150: aload_3
    //   151: astore 4
    //   153: aload 7
    //   155: astore 5
    //   157: aload_1
    //   158: invokevirtual 1640	java/io/File:length	()J
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
    //   191: new 1371	java/lang/StringBuilder
    //   194: dup
    //   195: sipush 12288
    //   198: invokespecial 1642	java/lang/StringBuilder:<init>	(I)V
    //   201: astore 9
    //   203: aload_3
    //   204: astore 4
    //   206: aload 7
    //   208: astore 5
    //   210: aload 7
    //   212: aload 6
    //   214: invokevirtual 1646	java/io/InputStreamReader:read	([C)I
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
    //   236: invokevirtual 1649	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: goto -37 -> 203
    //   243: aload_3
    //   244: astore 4
    //   246: aload 7
    //   248: astore 5
    //   250: aload 9
    //   252: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   282: new 1412	java/lang/String
    //   285: dup
    //   286: aload 6
    //   288: iconst_0
    //   289: aload 7
    //   291: aload 6
    //   293: invokevirtual 1646	java/io/InputStreamReader:read	([C)I
    //   296: invokespecial 1652	java/lang/String:<init>	([CII)V
    //   299: astore 6
    //   301: aload 6
    //   303: astore_1
    //   304: aload_3
    //   305: invokevirtual 1657	java/io/InputStream:close	()V
    //   308: goto +8 -> 316
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 1525	java/lang/Exception:printStackTrace	()V
    //   316: aload_1
    //   317: astore 4
    //   319: aload 7
    //   321: invokevirtual 1658	java/io/InputStreamReader:close	()V
    //   324: aload_1
    //   325: areturn
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 1525	java/lang/Exception:printStackTrace	()V
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
    //   394: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +70 -> 467
    //   400: aload 6
    //   402: astore 4
    //   404: aload_3
    //   405: astore 5
    //   407: new 1371	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   414: astore 9
    //   416: aload 6
    //   418: astore 4
    //   420: aload_3
    //   421: astore 5
    //   423: aload 9
    //   425: ldc_w 1660
    //   428: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 6
    //   434: astore 4
    //   436: aload_3
    //   437: astore 5
    //   439: aload 9
    //   441: aload_1
    //   442: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 6
    //   448: astore 4
    //   450: aload_3
    //   451: astore 5
    //   453: ldc_w 1401
    //   456: iconst_2
    //   457: aload 9
    //   459: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: aload 7
    //   464: invokestatic 1663	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   467: aload 6
    //   469: ifnull +16 -> 485
    //   472: aload 6
    //   474: invokevirtual 1657	java/io/InputStream:close	()V
    //   477: goto +8 -> 485
    //   480: astore_1
    //   481: aload_1
    //   482: invokevirtual 1525	java/lang/Exception:printStackTrace	()V
    //   485: aload_3
    //   486: ifnull +11 -> 497
    //   489: aload 8
    //   491: astore 4
    //   493: aload_3
    //   494: invokevirtual 1658	java/io/InputStreamReader:close	()V
    //   497: aconst_null
    //   498: areturn
    //   499: astore_1
    //   500: aload 4
    //   502: astore_3
    //   503: aload_3
    //   504: ifnull +15 -> 519
    //   507: aload_3
    //   508: invokevirtual 1657	java/io/InputStream:close	()V
    //   511: goto +8 -> 519
    //   514: astore_3
    //   515: aload_3
    //   516: invokevirtual 1525	java/lang/Exception:printStackTrace	()V
    //   519: aload 5
    //   521: ifnull +16 -> 537
    //   524: aload 5
    //   526: invokevirtual 1658	java/io/InputStreamReader:close	()V
    //   529: goto +8 -> 537
    //   532: astore_3
    //   533: aload_3
    //   534: invokevirtual 1525	java/lang/Exception:printStackTrace	()V
    //   537: aload_1
    //   538: athrow
    //   539: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +36 -> 578
    //   545: new 1371	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   552: astore_3
    //   553: aload_3
    //   554: ldc_w 1665
    //   557: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_3
    //   562: aload_1
    //   563: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: ldc_w 1401
    //   570: iconst_2
    //   571: aload_3
    //   572: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 1404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: aconst_null
    //   579: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	QConfigManager
    //   0	580	1	paramFile	File
    //   162	109	2	i	int
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
    paramString = new StringBuilder();
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append(File.separator);
    paramString.append(str);
    paramString.append(File.separator);
    paramString.append("conf");
    paramString.append(File.separator);
    paramString.append("cookie_new");
    return paramString.toString();
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt)
  {
    int j = paramConfig.msg_content_list.size();
    if (j == 0) {}
    for (paramConfig = paramIQConfigProcessor.migrateOldOrDefaultContent(1);; paramConfig = a(paramIQConfigProcessor, paramLong, paramInt))
    {
      break;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(i);
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
        i += 1;
      }
      Object localObject = new QConfItem[localArrayList.size()];
      localArrayList.toArray((Object[])localObject);
      paramConfig = a(paramIQConfigProcessor, (QConfItem[])localObject, paramInt);
      if (paramConfig != null)
      {
        a(paramIQConfigProcessor, (QConfItem[])localObject, paramLong, paramString);
        this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, paramConfig));
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
    if (j == 0) {
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
        this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, paramObject));
      }
      paramIQConfigProcessor.onUpdate(paramObject);
    }
  }
  
  private void a(IQConfigProcessor paramIQConfigProcessor, QConfItem[] paramArrayOfQConfItem, long paramLong, String paramString)
  {
    boolean bool = paramIQConfigProcessor.isNeedStoreLargeFile();
    int j = 0;
    int i = 0;
    if (bool)
    {
      a(new File(paramString));
      j = paramArrayOfQConfItem.length;
      while (i < j)
      {
        paramIQConfigProcessor = paramArrayOfQConfItem[i];
        localObject1 = a(paramString, String.valueOf(paramIQConfigProcessor.jdField_a_of_type_Int));
        if (localObject1 != null) {
          a(paramIQConfigProcessor.jdField_a_of_type_JavaLangString, (File)localObject1);
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
    Object localObject1 = new HashSet();
    int k = paramArrayOfQConfItem.length;
    i = j;
    while (i < k)
    {
      localObject2 = paramArrayOfQConfItem[i];
      ((Set)localObject1).add(String.valueOf(((QConfItem)localObject2).jdField_a_of_type_Int));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIQConfigProcessor.type());
      localStringBuilder.append("_");
      localStringBuilder.append(((QConfItem)localObject2).jdField_a_of_type_Int);
      paramString.putString(localStringBuilder.toString(), ((QConfItem)localObject2).jdField_a_of_type_JavaLangString);
      i += 1;
    }
    paramArrayOfQConfItem = a(paramLong).edit();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramIQConfigProcessor.type());
    ((StringBuilder)localObject2).append("_ids");
    paramArrayOfQConfItem.putStringSet(((StringBuilder)localObject2).toString(), (Set)localObject1).apply();
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAllConfigs: uin=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QConfigManager", 2, ((StringBuilder)localObject).toString());
        localObject = paramString;
      }
    }
    QConfigServlet.jdField_a_of_type_JavaLangString = (String)localObject;
    paramString = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    paramString.putParcelableArrayListExtra("k_cmd_type", QConfigHelper.a(a()));
    paramString.putExtra("key_uin", (String)localObject);
    paramString.putExtra("k_req_occasion", 0);
    paramString.putExtra("key_is_all_config", true);
    MobileQQ.sMobileQQ.waitAppRuntime(null).startServlet(paramString);
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
        if ((a().a(localQConReqExtraInfo.jdField_a_of_type_Int)) && (a().a(localQConReqExtraInfo.jdField_a_of_type_Int).isAccountRelated()))
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
    QConfigServlet.jdField_a_of_type_JavaLangString = (String)localObject;
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
    //   0: aload_2
    //   1: invokevirtual 1614	java/io/File:exists	()Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iload_3
    //   9: ifne +59 -> 68
    //   12: aload_2
    //   13: invokevirtual 1969	java/io/File:createNewFile	()Z
    //   16: pop
    //   17: goto +51 -> 68
    //   20: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +40 -> 63
    //   26: new 1371	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: ldc_w 1971
    //   40: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 5
    //   46: aload_2
    //   47: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc_w 1401
    //   54: iconst_2
    //   55: aload 5
    //   57: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 1404	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: iconst_0
    //   64: istore_3
    //   65: goto +5 -> 70
    //   68: iconst_1
    //   69: istore_3
    //   70: new 1973	java/io/FileOutputStream
    //   73: dup
    //   74: aload_2
    //   75: iconst_0
    //   76: invokespecial 1976	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
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
    //   97: invokevirtual 1979	java/lang/String:getBytes	()[B
    //   100: invokevirtual 1983	java/io/FileOutputStream:write	([B)V
    //   103: aload 5
    //   105: invokevirtual 1986	java/io/FileOutputStream:flush	()V
    //   108: goto +79 -> 187
    //   111: astore_1
    //   112: goto +63 -> 175
    //   115: astore_1
    //   116: invokestatic 1397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +41 -> 160
    //   122: new 1371	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 1372	java/lang/StringBuilder:<init>	()V
    //   129: astore 6
    //   131: aload 6
    //   133: ldc_w 1988
    //   136: invokevirtual 1379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 6
    //   142: aload_2
    //   143: invokevirtual 1593	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc_w 1401
    //   150: iconst_2
    //   151: aload 6
    //   153: invokevirtual 1387	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aload_1
    //   157: invokestatic 1663	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: iload 4
    //   162: istore_3
    //   163: aload 5
    //   165: ifnull +32 -> 197
    //   168: aload 5
    //   170: invokevirtual 1989	java/io/FileOutputStream:close	()V
    //   173: iconst_0
    //   174: ireturn
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 1989	java/io/FileOutputStream:close	()V
    //   185: aload_1
    //   186: athrow
    //   187: aload 5
    //   189: ifnull +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 1989	java/io/FileOutputStream:close	()V
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
    if (b(paramInt) == null) {
      return null;
    }
    Object localObject = new File(a(paramInt, paramLong, i));
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
        localObject[paramInt] = new QConfItem(a(localFile), a(localFile));
        paramInt += 1;
      }
      return localObject;
    }
    return null;
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
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("conf_");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("_upgrade_pref");
          localObject1 = ((StringBuilder)localObject1).toString();
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
    return a(paramInt);
  }
  
  private void b(IQConfigProcessor paramIQConfigProcessor, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt)
  {
    if (paramConfig.content_list.isEmpty()) {}
    for (paramString = paramIQConfigProcessor.migrateOldOrDefaultContent(1);; paramString = a(paramIQConfigProcessor, paramLong, paramInt))
    {
      break;
      int j = paramConfig.content_list.size();
      QConfItem[] arrayOfQConfItem = new QConfItem[j];
      int i = 0;
      while (i < j)
      {
        arrayOfQConfItem[i] = new QConfItem(i, (String)paramConfig.content_list.get(i));
        i += 1;
      }
      Object localObject = a(paramIQConfigProcessor, arrayOfQConfItem, paramInt);
      if (localObject != null)
      {
        a(paramIQConfigProcessor, arrayOfQConfItem, paramLong, paramString);
        this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramIQConfigProcessor.type()), new QConfigManager.CacheItem(paramLong, paramInt, localObject));
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("handleOldConfig, parse success, size=");
          paramString.append(j);
          QLog.d("QConfigManager", 2, paramString.toString());
        }
        paramString = localObject;
        break;
      }
    }
    a(paramIQConfigProcessor, paramString, paramInt, paramLong, paramConfig.content_list.isEmpty());
  }
  
  private QConfItem[] b(int paramInt, long paramLong)
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
      int i = 0;
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        int j = Integer.parseInt(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("_");
        localStringBuilder.append(str);
        localObject2[i] = new QConfItem(j, ((SharedPreferences)localObject1).getString(localStringBuilder.toString(), null));
        i += 1;
      }
      return localObject2;
    }
    return null;
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
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("conf_");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append("_content_sharepref");
          localObject1 = ((StringBuilder)localObject1).toString();
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
    IQConfigProcessor localIQConfigProcessor3 = (IQConfigProcessor)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    IQConfigProcessor localIQConfigProcessor1 = localIQConfigProcessor3;
    if (localIQConfigProcessor3 == null) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localIQConfigProcessor3 = (IQConfigProcessor)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
        localIQConfigProcessor1 = localIQConfigProcessor3;
        if (localIQConfigProcessor3 == null)
        {
          localIQConfigProcessor3 = a(String.valueOf(paramInt));
          localIQConfigProcessor1 = localIQConfigProcessor3;
          if (localIQConfigProcessor3 != null)
          {
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localIQConfigProcessor3);
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
  
  public <T> T a(int paramInt)
  {
    IQConfigProcessor localIQConfigProcessor = b(paramInt);
    if (localIQConfigProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, new Object[] { "loadConObj: processor=null, type=", Integer.valueOf(paramInt) });
      }
      return null;
    }
    long l;
    if (localIQConfigProcessor.isAccountRelated())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 != null)
      {
        l = a(((SimpleAccount)localObject1).getUin(), localIQConfigProcessor.isAccountRelated());
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
      l = 0L;
    }
    Object localObject1 = a(l);
    int i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
    if (i == -1) {
      return a(localIQConfigProcessor, 0);
    }
    Object localObject3 = (QConfigManager.CacheItem)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if ((localObject3 != null) && (((QConfigManager.CacheItem)localObject3).jdField_a_of_type_Int == i) && (((QConfigManager.CacheItem)localObject3).jdField_a_of_type_Long == l) && (((QConfigManager.CacheItem)localObject3).jdField_a_of_type_JavaLangObject != null)) {
      return ((QConfigManager.CacheItem)localObject3).jdField_a_of_type_JavaLangObject;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localIQConfigProcessor.type());
    ((StringBuilder)localObject3).append("_");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append("_defualt");
    if (((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject3).toString(), false)) {
      return a(localIQConfigProcessor, 0);
    }
    localObject1 = jdField_a_of_type_ArrayOfJavaLangObject;
    for (;;)
    {
      synchronized (localObject1[(paramInt % localObject1.length)])
      {
        if (localIQConfigProcessor.isNeedStoreLargeFile()) {
          localObject1 = a(paramInt, l);
        } else {
          localObject1 = b(paramInt, l);
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
                localObject3 = localObject1[0].jdField_a_of_type_JavaLangString;
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
            this.jdField_c_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new QConfigManager.CacheItem(l, i, localObject3));
            return localObject3;
          }
        }
        catch (Exception localException)
        {
          QConfigWatchDog.a().a(localIQConfigProcessor, (QConfItem[])localObject1, i, localException);
          localObject1 = QConfigHelper.a(localIQConfigProcessor.clazz());
          return localObject1;
        }
      }
      String str = "null";
    }
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
        l = a(((AppRuntime)localObject2).getAccount(), ((IQConfigProcessor)localObject1).isAccountRelated());
        break label56;
      }
    }
    long l = 0L;
    label56:
    localObject1 = a(l);
    int i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt1), -1);
    if ((i != -1) && (i != paramInt2))
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
    int i = b(paramInt1, Long.parseLong(paramString));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[OnReceive] t=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" old=");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", new=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.d("QConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (i == paramInt2) {
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
    Object localObject1 = b(paramInt1);
    if (localObject1 == null)
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
      ((StringBuilder)???).append(i);
      ((StringBuilder)???).append(" to nv=");
      ((StringBuilder)???).append(paramInt2);
      ((StringBuilder)???).append(", type=");
      ((StringBuilder)???).append(paramInt1);
      QLog.d("QConfigManager", 2, ((StringBuilder)???).toString());
    }
    long l = a(paramString, ((IQConfigProcessor)localObject1).isAccountRelated());
    paramString = a(paramInt1, l, paramInt2);
    ??? = jdField_a_of_type_ArrayOfJavaLangObject;
    synchronized (???[(paramInt1 % ???.length)])
    {
      if ((((IQConfigProcessor)localObject1).isNeedStoreLargeFile()) && (!a(paramString)))
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
      if (((IQConfigProcessor)localObject1).isNeedCompressed()) {
        a((IQConfigProcessor)localObject1, paramConfig, l, paramString, paramInt2);
      } else {
        b((IQConfigProcessor)localObject1, paramConfig, l, paramString, paramInt2);
      }
      QConfigJourney.a().a(paramInt1, l, ((IQConfigProcessor)localObject1).isNeedStoreLargeFile());
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = b(paramInt);
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
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("noReceive config, type=");
      paramString.append(paramInt);
      QLog.d("QConfigManager", 2, paramString.toString());
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!a(k))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QConfigManager has not support the config yet, type=");
        ((StringBuilder)localObject).append(k);
        QConfigHelper.a(new IllegalStateException(((StringBuilder)localObject).toString()));
      }
      i += 1;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = ((AppRuntime)localObject).getAccount();
    QConfigServlet.jdField_a_of_type_JavaLangString = str;
    NewIntent localNewIntent = new NewIntent(MobileQQ.sMobileQQ, QConfigServlet.class);
    localNewIntent.putParcelableArrayListExtra("k_cmd_type", QConfigHelper.a(paramArrayOfInt));
    localNewIntent.putExtra("key_uin", str);
    ((AppRuntime)localObject).startServlet(localNewIntent);
  }
  
  public boolean a(int paramInt)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(String.valueOf(paramInt));
  }
  
  public boolean a(String paramString, byte[] paramArrayOfByte)
  {
    return FileUtils.writeFile(paramArrayOfByte, a(paramString));
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
      return TextUtils.equals(AppSetting.g(), paramAppRuntime) ^ true;
    }
    return false;
  }
  
  public byte[] a(String paramString)
  {
    return FileUtils.readFile(a(paramString));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QConfigManager
 * JD-Core Version:    0.7.0.1
 */