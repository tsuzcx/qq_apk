package com.tencent.mobileqq.qipc;

import aame;
import aamk;
import abse;
import aieq;
import aiwk;
import aljy;
import alli;
import alnf;
import aloy;
import alyb;
import amlk;
import amnl;
import anmg;
import anwx;
import anxs;
import aobz;
import apjd;
import apkb;
import aqxc;
import artm;
import askr;
import aste;
import atbb;
import atgd;
import atjc;
import awfe;
import awjp;
import axfy;
import azfk;
import aznw;
import azpe;
import badj;
import badt;
import bakc;
import bavf;
import bcpy;
import bdpr;
import bdpv;
import bdql;
import bexc;
import bfkl;
import bijc;
import bilz;
import bivv;
import bjbk;
import bkeq;
import bkwn;
import blel;
import blym;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gh;
import ldx;
import mqq.app.SecurityFileModule;
import pea;
import reg;
import wyp;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return alli.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return bavf.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bfkl.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bilz.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return awjp.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return wyp.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return reg.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return aznw.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bdql.a();
    }
    if ("SignInModule".equals(paramString)) {
      return alyb.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bijc.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return aiwk.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bkeq.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return anwx.a();
    }
    if ("soso_interface".equals(paramString)) {
      return amlk.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return axfy.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return bjbk.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return azfk.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return aamk.a();
    }
    if ("gdt_ipc_module_client_to_server".equals(paramString)) {
      return aame.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gh.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return apkb.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return aljy.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bdpr.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return bakc.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return abse.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return badj.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return anmg.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return aste.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return aieq.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return anxs.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return atgd.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return amnl.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return aqxc.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return badt.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return azpe.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return bkwn.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bdpv.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return atjc.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return apjd.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bcpy.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return blym.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return blel.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return aloy.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return alnf.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bexc.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return awfe.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return pea.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aobz.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return ldx.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return askr.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return atbb.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bivv.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return artm.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */