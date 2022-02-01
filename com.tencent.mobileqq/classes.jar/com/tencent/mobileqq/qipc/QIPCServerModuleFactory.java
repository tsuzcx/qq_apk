package com.tencent.mobileqq.qipc;

import acnm;
import acno;
import actq;
import admx;
import agcj;
import aklh;
import alee;
import antn;
import anvd;
import anxc;
import anyv;
import aohm;
import apcw;
import apeh;
import apxv;
import aqel;
import aqqn;
import aqrj;
import aqvv;
import asfw;
import asgz;
import ausf;
import auxb;
import avkw;
import avnx;
import avwr;
import avxe;
import awel;
import awjt;
import awnf;
import azqm;
import azvb;
import bazf;
import bddk;
import bdnn;
import bebr;
import becb;
import beil;
import bgyt;
import bhzi;
import bhzm;
import biab;
import bilv;
import bjjn;
import bjxa;
import bmcb;
import bmgd;
import bmlw;
import bmpp;
import bnyu;
import boro;
import bozp;
import bpdp;
import bpxx;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gm;
import lbb;
import mqq.app.SecurityFileModule;
import nez;
import ofc;
import pnl;
import rql;
import zae;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return anvd.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.getInstance();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bjxa.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bmgd.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return azvb.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return zae.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return rql.a().a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return biab.a();
    }
    if ("SignInModule".equals(paramString)) {
      return aohm.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bmcb.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return alee.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bnyu.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return aqqn.a();
    }
    if ("soso_interface".equals(paramString)) {
      return apcw.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return bazf.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return bddk.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return actq.a();
    }
    if ("gdt_ipc_sync_module_client_to_server".equals(paramString)) {
      return acno.a();
    }
    if ("gdt_ipc_async_module_client_to_server".equals(paramString)) {
      return acnm.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gm.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return asgz.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return antn.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bhzi.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return beil.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return admx.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return bebr.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return aqel.a();
    }
    if ("ArkQQAPIIPCModule".equals(paramString)) {
      return apxv.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return avxe.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return aklh.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return aqrj.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return awjt.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("AEEditorEffectIpcModule".equals(paramString)) {
      return bpdp.a();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return apeh.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return ausf.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return becb.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return bdnn.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return boro.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bhzm.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return awnf.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return asfw.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bgyt.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bpxx.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bozp.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return anyv.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return anxc.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bjjn.a();
    }
    if ("weibo_qipc_module".equals(paramString)) {
      return bilv.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return azqm.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return pnl.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aqvv.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return lbb.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return avnx.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return awel.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bmpp.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return auxb.a();
    }
    if ("DeviceProtectQIPCModule".equals(paramString)) {
      return avwr.a();
    }
    if ("MiniGamePublicAccountIPCModule".equals(paramString)) {
      return MiniGamePublicAccountIPCModule.getInstance();
    }
    if ("QfavMainQIPCModule".equals(paramString)) {
      return bmlw.a();
    }
    if ("module_game_buddy".equals(paramString)) {
      return avkw.a();
    }
    if ("VasLiveIPCModule".equals(paramString)) {
      return VasLiveIPCModule.getInstance();
    }
    if ("EcshopIPCModule".equals(paramString)) {
      return ofc.a();
    }
    if ("AVGameServerIPCModule".equals(paramString)) {
      return nez.a();
    }
    if ("QQNotifyIPCModule".equals(paramString)) {
      return agcj.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */