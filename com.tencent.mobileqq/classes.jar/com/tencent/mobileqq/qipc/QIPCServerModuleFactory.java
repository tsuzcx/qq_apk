package com.tencent.mobileqq.qipc;

import aabl;
import aggn;
import ahci;
import ahgg;
import ajsn;
import ajtx;
import ajxm;
import akgm;
import akuv;
import akww;
import alvk;
import amfy;
import amgt;
import amlc;
import anrq;
import anso;
import apea;
import aqak;
import aqub;
import arco;
import arkl;
import arph;
import arsf;
import aunv;
import ausb;
import avob;
import axkc;
import axsi;
import axtq;
import ayfk;
import ayfv;
import ayme;
import ayxe;
import baqq;
import bbqj;
import bbqn;
import bbrd;
import bcxl;
import bdkz;
import bghn;
import bgkj;
import bguf;
import bgzq;
import bicd;
import bird;
import biza;
import bjmm;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import hy;
import lby;
import mqq.app.SecurityFileModule;
import oyw;
import qpf;
import vka;
import ywk;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return ajtx.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return ayxe.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bdkz.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bgkj.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return ausb.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return vka.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return qpf.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return axsi.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bbrd.a();
    }
    if ("SignInModule".equals(paramString)) {
      return akgm.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bghn.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return ahci.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bicd.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return amfy.a();
    }
    if ("soso_interface".equals(paramString)) {
      return akuv.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return avob.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return bgzq.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return axkc.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return ywk.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return hy.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return anso.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return ajsn.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bbqj.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return ayme.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return aabl.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return ayfk.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return alvk.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return arco.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return aggn.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return amgt.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return arph.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return akww.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return apea.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return ayfv.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return axtq.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return bird.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bbqn.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return arsf.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return anrq.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return baqq.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bjmm.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return biza.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return ajxm.a();
    }
    if ("SpringHbIPCModule".endsWith(paramString)) {
      return ahgg.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bcxl.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return aunv.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return oyw.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return amlc.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return lby.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return aqub.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return arkl.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bguf.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return aqak.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */