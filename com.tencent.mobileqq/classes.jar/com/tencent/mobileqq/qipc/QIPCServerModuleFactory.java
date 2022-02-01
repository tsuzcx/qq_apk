package com.tencent.mobileqq.qipc;

import acji;
import acjk;
import acpn;
import addz;
import ajzy;
import akss;
import anhs;
import anjg;
import ankq;
import anlg;
import anmv;
import anva;
import aopg;
import aoqr;
import apkf;
import apqv;
import aqbl;
import aqcg;
import aqgs;
import arqi;
import arrl;
import auak;
import aufg;
import ausw;
import auvx;
import avfb;
import avma;
import avrd;
import avuk;
import ayxz;
import azco;
import bagp;
import bcks;
import bcuu;
import bdiw;
import bdjg;
import bdpp;
import bfys;
import bgzd;
import bgzg;
import bgzv;
import biio;
import biwb;
import blay;
import blfa;
import blkt;
import blon;
import bmxm;
import bnqc;
import bnyf;
import bobu;
import bowc;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gm;
import lau;
import mqq.app.SecurityFileModule;
import ndg;
import ods;
import puy;
import rzo;
import ywj;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return anjg.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.getInstance();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return biwb.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return blfa.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return azco.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return ywj.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return rzo.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bgzv.a();
    }
    if ("SignInModule".equals(paramString)) {
      return anva.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return blay.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return akss.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bmxm.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return aqbl.a();
    }
    if ("soso_interface".equals(paramString)) {
      return aopg.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return bagp.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return bcks.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return acpn.a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return acjk.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return acji.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gm.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return arrl.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return anhs.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bgzd.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return bdpp.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return addz.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return bdiw.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return apqv.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return apkf.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return avfb.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return ajzy.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return aqcg.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return avrd.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("AEEditorEffectIpcModule".equals(paramString)) {
      return bobu.a();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return aoqr.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return auak.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return bdjg.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return bcuu.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return bnqc.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bgzg.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return avuk.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return arqi.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bfys.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bowc.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bnyf.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return anmv.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return anlg.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return biio.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return ayxz.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return puy.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aqgs.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return lau.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return auvx.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return avma.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return blon.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return aufg.a();
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return ankq.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return MiniGamePublicAccountIPCModule.getInstance();
    }
    if ("QfavMainQIPCModule".equals(paramString)) {
      return blkt.a();
    }
    if ("module_game_buddy".equals(paramString)) {
      return ausw.a();
    }
    if ("VasLiveIPCModule".equals(paramString)) {
      return VasLiveIPCModule.getInstance();
    }
    if ("EcshopIPCModule".equals(paramString)) {
      return ods.a();
    }
    if ("AVGameServerIPCModule".equals(paramString)) {
      return ndg.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */