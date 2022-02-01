package com.tencent.mobileqq.qipc;

import abju;
import abjw;
import abqa;
import acjq;
import aevd;
import ajjg;
import akbx;
import amod;
import ampl;
import amrl;
import amsv;
import anbb;
import anxt;
import aori;
import aoxw;
import apjw;
import apks;
import appe;
import aqzu;
import arax;
import aten;
import atjw;
import atxx;
import auax;
import aujr;
import auke;
import aurl;
import auwx;
import avaj;
import aydu;
import ayjq;
import aztr;
import bbwn;
import bcfy;
import bcvi;
import bcvs;
import bdbh;
import bfif;
import bgfw;
import bggl;
import bgse;
import bhpb;
import bici;
import bkfy;
import bkkj;
import bkqd;
import bktw;
import bldy;
import blvs;
import bmba;
import bmez;
import bnau;
import com.tencent.hippy.qq.ipc.HippyIpcModule;
import com.tencent.mobileqq.app.soso.SosoInterfaceModule;
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
import las;
import mqq.app.SecurityFileModule;
import ngg;
import ogp;
import pst;
import rxn;
import ybn;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return ampl.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.getInstance();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bici.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bkkj.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return ayjq.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return ybn.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return rxn.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bggl.a();
    }
    if ("SignInModule".equals(paramString)) {
      return anbb.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bkfy.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return akbx.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bldy.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return apjw.a();
    }
    if ("soso_interface".equals(paramString)) {
      return SosoInterfaceModule.getInterface();
    }
    if ("REAL_NAME".equals(paramString)) {
      return aztr.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.getInstance();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.getInstance();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return bbwn.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return abqa.a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return abjw.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return abju.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gk.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return arax.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return amod.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return VasApngIPCModule.getInstance();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return bdbh.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return acjq.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return bcvi.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return aoxw.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return aori.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return auke.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return ajjg.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return apks.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return auwx.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("AEEditorEffectIpcModule".equals(paramString)) {
      return bmez.a();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return anxt.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return aten.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return bcvs.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return bcfy.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return blvs.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bgfw.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return avaj.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return aqzu.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bfif.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bnau.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bmba.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return amsv.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return amrl.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bhpb.a();
    }
    if ("weibo_qipc_module".equals(paramString)) {
      return bgse.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return aydu.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return pst.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return appe.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return las.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return auax.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return aurl.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bktw.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return atjw.a();
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return aujr.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return MiniGamePublicAccountIPCModule.getInstance();
    }
    if ("QfavMainQIPCModule".equals(paramString)) {
      return bkqd.a();
    }
    if ("module_game_buddy".equals(paramString)) {
      return atxx.a();
    }
    if ("VasLiveIPCModule".equals(paramString)) {
      return VasLiveIPCModule.getInstance();
    }
    if ("EcshopIPCModule".equals(paramString)) {
      return ogp.a();
    }
    if ("AVGameServerIPCModule".equals(paramString)) {
      return ngg.a();
    }
    if ("QQNotifyIPCModule".equals(paramString)) {
      return aevd.a();
    }
    if ("module_hippy".equals(paramString)) {
      return HippyIpcModule.getInstance();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */