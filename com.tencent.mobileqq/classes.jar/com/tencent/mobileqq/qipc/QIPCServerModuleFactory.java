package com.tencent.mobileqq.qipc;

import aaqt;
import aaqz;
import abwt;
import aijf;
import ajaz;
import alon;
import alpx;
import alru;
import altn;
import amcq;
import ampz;
import amsa;
import anqp;
import aobg;
import aocb;
import aogi;
import apnm;
import apok;
import arbl;
import arxv;
import aspa;
import asxn;
import atfk;
import atkm;
import atnl;
import awjn;
import awny;
import axkh;
import azjt;
import azsf;
import aztn;
import bahs;
import baic;
import baol;
import bazo;
import bcuh;
import bdua;
import bdue;
import bduu;
import bfbl;
import bfou;
import binj;
import biqg;
import bjac;
import bjfr;
import bkix;
import blau;
import blis;
import bmcy;
import com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.vas.QuickUpdateIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;
import gh;
import ldx;
import mqq.app.SecurityFileModule;
import pea;
import reg;
import xcy;

public class QIPCServerModuleFactory
{
  public static final String TAG = "QIPCServerModuleFactory";
  
  public static QIPCModule onCreateModule(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return alpx.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return bazo.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return bfou.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return biqg.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return awny.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return xcy.a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return reg.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return azsf.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return bduu.a();
    }
    if ("SignInModule".equals(paramString)) {
      return amcq.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return binj.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return ajaz.a();
    }
    if ("WadlQIPCModule".equals(paramString)) {
      return bkix.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return aobg.a();
    }
    if ("soso_interface".equals(paramString)) {
      return ampz.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return axkh.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return bjfr.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return azjt.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return aaqz.a();
    }
    if ("gdt_ipc_module_client_to_server".equals(paramString)) {
      return aaqt.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return gh.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return apok.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return alon.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return bdua.a();
    }
    if ("ThemeIPCModule".equals(paramString)) {
      return baol.a();
    }
    if ("QuickUpdateIPCModule".equals(paramString)) {
      return QuickUpdateIPCModule.a();
    }
    if ("HardCoderModule".equals(paramString)) {
      return abwt.a();
    }
    if ("TeamWorkModule".equals(paramString)) {
      return bahs.a();
    }
    if ("ChooseImageIPCModule".equals(paramString)) {
      return anqp.a();
    }
    if ("IdentificationIpcServer_Model".equals(paramString)) {
      return asxn.a();
    }
    if ("MiniAppTransferModule".equals(paramString)) {
      return MiniAppTransferModule.getInstance();
    }
    if ("MiniMsgIPCServer".equals(paramString)) {
      return aijf.a();
    }
    if ("ColorNoteIPCServer".equals(paramString)) {
      return aocb.a();
    }
    if ("JubaoIPCServer".equals(paramString)) {
      return atkm.a();
    }
    if ("SecurityFileModule".equals(paramString)) {
      return SecurityFileModule.getInstance();
    }
    if ("PublicAccountModule".equals(paramString)) {
      return amsa.a();
    }
    if ("Module_WeiyunDownloadService".equals(paramString)) {
      return arbl.a().a();
    }
    if ("Module_TDFileChangeNameQIPCModule".equals(paramString)) {
      return baic.a();
    }
    if ("NetworkMonitorIPCModule".equals(paramString)) {
      return aztn.a();
    }
    if (MiniAppBannerIPCModule.NAME.equals(paramString)) {
      return MiniAppBannerIPCModule.getInstance();
    }
    if ("AECameraLaunchServer".equals(paramString)) {
      return blau.a();
    }
    if ("VasCommonIPCModule".equals(paramString)) {
      return bdue.a();
    }
    if ("ListenTogetherIPCModuleMainServer".equals(paramString)) {
      return atnl.a();
    }
    if ("CameraEmoIpcServer".equals(paramString)) {
      return apnm.a();
    }
    if ("Module_CheckInServer".equals(paramString)) {
      return bcuh.a();
    }
    if ("PeakIpcModuleServer".equals(paramString)) {
      return bmcy.a();
    }
    if ("AECameraGetInfoServer".equals(paramString)) {
      return blis.a();
    }
    if ("FriendQIPCModule".equals(paramString)) {
      return altn.a();
    }
    if ("ExtendFriendQIPCModule".equals(paramString)) {
      return alru.a();
    }
    if ("open_sdk_qipc_module".equals(paramString)) {
      return bfbl.a();
    }
    if ("PicSTWXQIPCModule".equals(paramString)) {
      return awjn.a();
    }
    if ("ReadInJoyIPCModule".equals(paramString)) {
      return pea.a();
    }
    if ("DanmuDataIPCServer".equals(paramString)) {
      return aogi.a();
    }
    if ("AioShareMusicIPCMainClient".equals(paramString)) {
      return ldx.a();
    }
    if ("QQGameIPCModule".equals(paramString)) {
      return aspa.a();
    }
    if ("TogetherBusinessIPCModule".equals(paramString)) {
      return atfk.a();
    }
    if ("ReaderIPCModule".equals(paramString)) {
      return bjac.a();
    }
    if ("FlutterMainQIPCModule".equals(paramString)) {
      return arxv.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */