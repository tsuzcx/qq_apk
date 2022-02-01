package com.tencent.mobileqq.qipc;

import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.aelight.camera.entry.api.IAECameraLaunchServer;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.aelight.camera.qipc.api.IAEEditorEffectIpc;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcModuleServer;
import com.tencent.aiosharemusic.AioShareMusicIPCMainClient;
import com.tencent.avbiz.AVBizServerQIPCModule;
import com.tencent.avgame.ipc.AVGameServerIPCModule;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.common.app.QRouteIPCModule;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCAsyncModule;
import com.tencent.gdtad.adapter.GdtIPCAdapter.ClientToServerIPCSyncModule;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.mm.hardcoder.HardCoderManager.HardCoderIPCModule;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyIPCModule;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCServer;
import com.tencent.mobileqq.activity.springfestival.entry.SpringHbIPCModule;
import com.tencent.mobileqq.apollo.utils.api.IApolloIPCHelper;
import com.tencent.mobileqq.app.BabyQIPCModule;
import com.tencent.mobileqq.app.CommonModule;
import com.tencent.mobileqq.app.ExtendFriendQIPCModule;
import com.tencent.mobileqq.app.FriendQIPCModule;
import com.tencent.mobileqq.app.SignInModule;
import com.tencent.mobileqq.applets.PublicAccountModule;
import com.tencent.mobileqq.ark.api.IArkIPCService;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.avatar.ipc.AvatarServerIPCModule;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcServer;
import com.tencent.mobileqq.colornote.ColorNoteIPCServer;
import com.tencent.mobileqq.download.unite.util.UniteDownloadIPCModule;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer;
import com.tencent.mobileqq.flutter.ipc.FlutterMainQIPCModule;
import com.tencent.mobileqq.gamecenter.gameBuddy.GameBuddyModule;
import com.tencent.mobileqq.identification.DeviceProtectQIPCModule;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessIPCModule;
import com.tencent.mobileqq.intimate.IntimateQIPCModule;
import com.tencent.mobileqq.jubao.JubaoIPCServer;
import com.tencent.mobileqq.kandian.biz.common.ipc.api.IReadInJoyIPCModuleFactory;
import com.tencent.mobileqq.kandian.biz.video.constants.VideoFeedsIPCServer;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer;
import com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pic.PicSTWXQIPCModule;
import com.tencent.mobileqq.pluginsdk.QIPCServerModulePlugin;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.realname.RealNameModule;
import com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer;
import com.tencent.mobileqq.soload.biz.SoLoadIPCModule;
import com.tencent.mobileqq.soso.location.SosoInterfaceModule;
import com.tencent.mobileqq.teamwork.TeamWorkModule;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troopcheckin.CheckInServer;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.VasCommonIPCModule;
import com.tencent.mobileqq.vas.VasMonitorIPCModule;
import com.tencent.mobileqq.vas.api.VasIPCModule;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.mobileqq.vas.theme.ThemeIPCModule;
import com.tencent.mobileqq.wbapi.WBQIPCModule;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.open.OpenSdkQIPCModule;
import com.tencent.open.downloadnew.DownloaderGetCodeServer;
import com.tencent.qqperf.monitor.network.NetworkMonitorIPCModule;
import cooperation.photoplus.PhotoPlusModule;
import cooperation.qqfav.ipc.QfavMainQIPCModule;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import mqq.app.SecurityFileModule;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return CommonModule.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.getInstance();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return DownloaderGetCodeServer.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return PhotoPlusModule.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return VideoFeedsIPCServer.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return VasMonitorIPCModule.a();
    }
    if ("SignInModule".equals(paramString)) {
      return SignInModule.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return ((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getIpcModule();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return ((IQWalletApi)QRoute.api(IQWalletApi.class)).getQWalletIPCModule();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return WadlQIPCModule.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return CampusCircleIpcServer.a();
    }
    if ("soso_interface".equals(paramString)) {
      return SosoInterfaceModule.getInterface();
    }
    if ("REAL_NAME".equals(paramString)) {
      return RealNameModule.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QZoneHelper.getQzoneVideoSoDownloadModule();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.getInstance();
    }
    if ("SpringHbIPCModule".equals(paramString)) {
      return SpringHbIPCModule.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return VideoPlayIPCServer.a().a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return GdtIPCAdapter.ClientToServerIPCSyncModule.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return GdtIPCAdapter.ClientToServerIPCAsyncModule.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return VasFontIPCModule.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return ((IEmoticonPanelIpcService)QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(paramString);
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return BabyQIPCModule.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return VasApngIPCModule.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return ThemeIPCModule.a();
    }
    if ("VasIPCModule".equals(paramString)) {
      return VasIPCModule.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.getInstance();
    }
    if ("HardCoderModule".equals(paramString)) {
      return HardCoderManager.HardCoderIPCModule.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return TeamWorkModule.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return ChooseImageIPCModule.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return ((IArkIPCService)QRoute.api(IArkIPCService.class)).getModule();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return ((IIdentificationApi)QRoute.api(IIdentificationApi.class)).getIdentityIpcServer();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppTransferModule();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return MiniMsgIPCServer.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return ColorNoteIPCServer.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return JubaoIPCServer.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("AEEditorEffectIpcModule".equals(paramString)) {
      return ((IAEEditorEffectIpc)QRoute.api(IAEEditorEffectIpc.class)).getAEEditorEffectQIPCModule();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return PublicAccountModule.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).getIPCModule();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getTDIPCModule();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return NetworkMonitorIPCModule.a();
    }
    if ("MiniAppBannerIPCModule".equals(paramString)) {
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppBannerIPCModule();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return ((IAECameraLaunchServer)QRoute.api(IAECameraLaunchServer.class)).getAECameraLaunchServerQIPCModule();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return VasCommonIPCModule.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return ListenTogetherIPCModuleMainServer.a();
    }
    if ("ZanRankingIpcServer".equals(paramString)) {
      return ZanRankingIpcServer.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return ((IEmoticonPanelIpcService)QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(paramString);
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return CheckInServer.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return ((IPeakIpcModuleServer)QRoute.api(IPeakIpcModuleServer.class)).getPeakIpcModuleServerModule();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return ((IAECameraGetInfoServer)QRoute.api(IAECameraGetInfoServer.class)).getAECameraGetInfoServerQIPCModule();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return FriendQIPCModule.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return ExtendFriendQIPCModule.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return OpenSdkQIPCModule.a();
    }
    if ("weibo_qipc_module".equals(paramString)) {
      return WBQIPCModule.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return PicSTWXQIPCModule.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return ((IReadInJoyIPCModuleFactory)QRoute.api(IReadInJoyIPCModuleFactory.class)).getReadInJoyIPCModule();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return ((IDanmuDataIPCServer)QRoute.api(IDanmuDataIPCServer.class)).getDanmuIPCServer();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return AioShareMusicIPCMainClient.a();
    }
    if (((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getQQGameIPCModuleName().equals(paramString)) {
      return ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).getQQGameIPCModule();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return TogetherBusinessIPCModule.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return FlutterMainQIPCModule.a();
    }
    if ("QRScanMainQIPCModule".equals(paramString)) {
      return ((IQRScanIpcApi)QRoute.api(IQRScanIpcApi.class)).getModule("QRScanMainQIPCModule");
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return DeviceProtectQIPCModule.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniGamePublicAccountIPCModule();
    }
    if ("QfavMainQIPCModule".equals(paramString)) {
      return QfavMainQIPCModule.a();
    }
    if ("module_game_buddy".equals(paramString)) {
      return GameBuddyModule.a();
    }
    if ("VasLiveIPCModule".equals(paramString)) {
      return VasLiveIPCModule.getInstance();
    }
    if ("QRouteIPCModule".equals(paramString)) {
      return QRouteIPCModule.a();
    }
    if ("EcshopIPCModule".equals(paramString)) {
      return ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).getEcshopIPCModule();
    }
    if ("AVGameServerIPCModule".equals(paramString)) {
      return AVGameServerIPCModule.a();
    }
    if ("QQNotifyIPCModule".equals(paramString)) {
      return QQNotifyIPCModule.a();
    }
    if ("module_hippy".equals(paramString)) {
      return ((IHippyIPC)QRoute.api(IHippyIPC.class)).getIPCModule();
    }
    if ("apollo_client_module".equals(paramString)) {
      return ((IApolloIPCHelper)QRoute.api(IApolloIPCHelper.class)).getIPCModule();
    }
    if ("AECMShowQipcModule".equals(paramString)) {
      return ((IAECMSShow)QRoute.api(IAECMSShow.class)).getCMSShowModule();
    }
    if ("UniteDownloadIPCModule".equals(paramString)) {
      return UniteDownloadIPCModule.a();
    }
    if ("ExpandFlutterIPCServer".equals(paramString)) {
      return ((IExpandFlutterIPCServerHelper)QRoute.api(IExpandFlutterIPCServerHelper.class)).getIPCServer();
    }
    if ("LiteSDKServerModuleName".equals(paramString)) {
      return LiteSDKForCrossProcess.a();
    }
    if ("module_emoticon_mainpanel".equals(paramString)) {
      return ((IEmoticonPanelIpcService)QRoute.api(IEmoticonPanelIpcService.class)).onCreateModule(paramString);
    }
    if ("IntimateQIPCModule".equals(paramString)) {
      return IntimateQIPCModule.a();
    }
    if ("AvatarServerIPCModule".equals(paramString)) {
      return AvatarServerIPCModule.a();
    }
    if ("SoLoadIPCModule".equals(paramString)) {
      return SoLoadIPCModule.getInstance();
    }
    if ("qipc_plugin_module".equals(paramString)) {
      return QIPCServerModulePlugin.getInstance();
    }
    if ("AVBizServerQIPCModule".equals(paramString)) {
      return AVBizServerQIPCModule.a();
    }
    if ("WSIPCModule".equals(paramString)) {
      return ((IWSManager)QRoute.api(IWSManager.class)).getIPCModule();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */