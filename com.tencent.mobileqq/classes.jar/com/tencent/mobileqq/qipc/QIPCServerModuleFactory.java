package com.tencent.mobileqq.qipc;

import abzj;
import abzl;
import acfu;
import aczz;
import afmo;
import akeu;
import akxq;
import amlo;
import anqq;
import anry;
import antz;
import anvj;
import aodq;
import apav;
import apuj;
import aqba;
import aqna;
import aqnw;
import aqsi;
import asee;
import asfh;
import auiu;
import auop;
import avdb;
import avgr;
import avpl;
import avpz;
import avxg;
import awcw;
import awgm;
import azkg;
import azol;
import bazz;
import bddi;
import bdmw;
import bech;
import becr;
import beih;
import bgqw;
import bhor;
import bhpf;
import bicu;
import bizv;
import bjnk;
import blrk;
import blvr;
import bmbl;
import bmff;
import bmqp;
import bnis;
import bnlc;
import bnqk;
import bnur;
import boqm;
import com.tencent.hippy.qq.ipc.HippyIpcModule;
import com.tencent.mobileqq.app.soso.SosoInterfaceModule;
import com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gk;
import lav;
import mqq.app.SecurityFileModule;
import nmy;
import ooi;
import qdq;
import sjp;
import yqg;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return anry.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.getInstance();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bjnk.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return blvr.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return azol.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return yqg.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return sjp.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bhpf.a();
    }
    if ("SignInModule".equals(paramString)) {
      return aodq.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return blrk.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return akxq.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bmqp.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return aqna.a();
    }
    if ("soso_interface".equals(paramString)) {
      return SosoInterfaceModule.getInterface();
    }
    if ("REAL_NAME".equals(paramString)) {
      return bazz.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.getInstance();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.getInstance();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return bddi.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return acfu.a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return abzl.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return abzj.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gk.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return asfh.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return anqq.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return VasApngIPCModule.getInstance();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return beih.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return aczz.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return bech.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return aqba.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return apuj.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return avpz.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return akeu.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return aqnw.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return awcw.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("AEEditorEffectIpcModule".equals(paramString)) {
      return bnur.a();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return apav.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return auiu.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return becr.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return bdmw.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return bnlc.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bhor.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return awgm.a();
    }
    if ("ZanRankingIpcServer".equals(paramString)) {
      return ZanRankingIpcServer.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return asee.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bgqw.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return boqm.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bnqk.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return anvj.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return antz.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bizv.a();
    }
    if ("weibo_qipc_module".equals(paramString)) {
      return bicu.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return azkg.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return qdq.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aqsi.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return lav.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return avgr.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return avxg.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bmff.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return auop.a();
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return avpl.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return MiniGamePublicAccountIPCModule.getInstance();
    }
    if ("QfavMainQIPCModule".equals(paramString)) {
      return bmbl.a();
    }
    if ("module_game_buddy".equals(paramString)) {
      return avdb.a();
    }
    if ("VasLiveIPCModule".equals(paramString)) {
      return VasLiveIPCModule.getInstance();
    }
    if ("EcshopIPCModule".equals(paramString)) {
      return ooi.a();
    }
    if ("AVGameServerIPCModule".equals(paramString)) {
      return nmy.a();
    }
    if ("QQNotifyIPCModule".equals(paramString)) {
      return afmo.a();
    }
    if ("module_hippy".equals(paramString)) {
      return HippyIpcModule.getInstance();
    }
    if ("apollo_client_module".equals(paramString)) {
      return amlo.a();
    }
    if ("AECMShowQipcModule".equals(paramString)) {
      return bnis.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */