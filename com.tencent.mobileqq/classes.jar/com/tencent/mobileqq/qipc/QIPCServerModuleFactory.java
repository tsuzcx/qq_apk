package com.tencent.mobileqq.qipc;

import afun;
import agpt;
import agtr;
import ajel;
import ajfv;
import ajji;
import ajsc;
import akgj;
import akik;
import algw;
import alri;
import alsa;
import alvm;
import anbf;
import ancd;
import aonf;
import apzz;
import aqif;
import aqqg;
import aqul;
import aqwp;
import atpx;
import atud;
import auot;
import awkw;
import awsj;
import awtp;
import axfh;
import axfs;
import axly;
import axwx;
import azpm;
import baon;
import baor;
import bapg;
import bbtl;
import bcgy;
import bezw;
import bfcs;
import bfma;
import bfrj;
import bgtb;
import bgwx;
import bhal;
import bhru;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gf;
import krk;
import mqq.app.SecurityFileModule;
import onh;
import qdh;
import uxe;
import ymt;
import zrs;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return ajfv.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return axwx.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bcgy.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bfcs.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return atud.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return uxe.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return qdh.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return awsj.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bapg.a();
    }
    if ("SignInModule".equals(paramString)) {
      return ajsc.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bezw.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return agpt.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bgtb.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return alri.a();
    }
    if ("soso_interface".equals(paramString)) {
      return akgj.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return auot.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return bfrj.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return awkw.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return ymt.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gf.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return ancd.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return ajel.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return baon.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return axly.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return zrs.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return axfh.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return algw.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return aqif.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return afun.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return alsa.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return aqul.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return akik.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return aonf.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return axfs.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return awtp.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return bgwx.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return baor.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return aqwp.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return anbf.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return azpm.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bhru.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bhal.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return ajji.a();
    }
    if ("SpringHbIPCModule".endsWith(paramString)) {
      return agtr.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bbtl.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return atpx.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return onh.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return alvm.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return krk.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return apzz.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return aqqg.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bfma.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */