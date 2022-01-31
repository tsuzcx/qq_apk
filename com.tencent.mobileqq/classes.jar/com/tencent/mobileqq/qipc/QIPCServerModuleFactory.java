package com.tencent.mobileqq.qipc;

import aabh;
import aggl;
import ahcg;
import ahge;
import ajsl;
import ajtv;
import ajxk;
import akgl;
import akuu;
import akwv;
import alvj;
import amfx;
import amgs;
import amlb;
import anrv;
import anst;
import apee;
import aqam;
import aqud;
import arcq;
import arkn;
import arpj;
import arsh;
import aunx;
import ausd;
import avod;
import axke;
import axsk;
import axts;
import ayfm;
import ayfx;
import aymg;
import ayxg;
import bare;
import bbqx;
import bbrb;
import bbrr;
import bcya;
import bdlo;
import bgie;
import bgla;
import bguw;
import bhah;
import bicu;
import biru;
import bizr;
import bjnd;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import hy;
import lbt;
import mqq.app.SecurityFileModule;
import oyt;
import qpc;
import vjx;
import ywh;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return ajtv.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return ayxg.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bdlo.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return bgla.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return ausd.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return vjx.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return qpc.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return axsk.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bbrr.a();
    }
    if ("SignInModule".equals(paramString)) {
      return akgl.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return bgie.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return ahcg.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bicu.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return amfx.a();
    }
    if ("soso_interface".equals(paramString)) {
      return akuu.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return avod.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return bhah.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return axke.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return ywh.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return hy.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return anst.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return ajsl.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bbqx.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return aymg.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return aabh.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return ayfm.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return alvj.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return arcq.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return aggl.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return amgs.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return arpj.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return akwv.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return apee.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return ayfx.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return axts.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return biru.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bbrb.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return arsh.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return anrv.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bare.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bjnd.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return bizr.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return ajxk.a();
    }
    if ("SpringHbIPCModule".endsWith(paramString)) {
      return ahge.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bcya.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return aunx.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return oyt.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return amlb.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return lbt.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return aqud.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return arkn.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bguw.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return aqam.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */