package com.tencent.mobileqq.qipc;

import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCServer;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterModule;
import com.tencent.gdtad.ipc.GdtIpc;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule;
import com.tencent.mobileqq.app.BabyQIPCModule;
import com.tencent.mobileqq.app.CommonModule;
import com.tencent.mobileqq.app.SignInModule;
import com.tencent.mobileqq.armap.ipc.ArMapIPCProxy;
import com.tencent.mobileqq.campuscircle.CampusCircleIpcServer;
import com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule;
import com.tencent.mobileqq.precover.ipc.PrecoverIPCServer;
import com.tencent.mobileqq.realname.RealNameModule;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCServer;
import com.tencent.mobileqq.statistics.battery.BatteryIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.VasMonitorIPCModule;
import com.tencent.open.downloadnew.DownloaderGetCodeServer;
import cooperation.comic.ipc.QQComicIPCModule;
import cooperation.photoplus.PhotoPlusModule;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.QzoneVideoSoDownloadModule;

public class QIPCServerModuleFactory
{
  public static QIPCModule a(String paramString)
  {
    if ("CommonModule".equals(paramString)) {
      return CommonModule.a();
    }
    if ("InnerDnsModule".equals(paramString)) {
      return InnerDns.a();
    }
    if ("Module_DownloaderGetCodeServer".equals(paramString)) {
      return DownloaderGetCodeServer.a().a();
    }
    if ("PhotoPlusModule".equals(paramString)) {
      return PhotoPlusModule.a();
    }
    if ("PrecoverIPCServer_MODEL".equals(paramString)) {
      return PrecoverIPCServer.a().a();
    }
    if ("ArtFilterModule".equals(paramString)) {
      return ArtFilterModule.a();
    }
    if ("ArMapModule".equals(paramString)) {
      return ArMapIPCProxy.a().a();
    }
    if ("Module_VideoFeedsIPCServer".equals(paramString)) {
      return VideoFeedsIPCServer.a().a();
    }
    if ("BatteryModule".equals(paramString)) {
      return BatteryIPCModule.a();
    }
    if ("VasMonitorIPCModule".equals(paramString)) {
      return VasMonitorIPCModule.a();
    }
    if ("SignInModule".equals(paramString)) {
      return SignInModule.a();
    }
    if ("QQComicIPCModule".equals(paramString)) {
      return QQComicIPCModule.a();
    }
    if ("QWalletIPCModule".equals(paramString)) {
      return QWalletIPCModule.a();
    }
    if ("CampusCircleIpcServer_Model".equals(paramString)) {
      return CampusCircleIpcServer.a();
    }
    if ("REAL_NAME".equals(paramString)) {
      return RealNameModule.a();
    }
    if ("QzoneVideoSoDownloadModule".equals(paramString)) {
      return QzoneVideoSoDownloadModule.a();
    }
    if ("QzoneIPCModule".equals(paramString)) {
      return QzoneIPCModule.a();
    }
    if ("Module_VideoPlayIPCServer".equals(paramString)) {
      return VideoPlayIPCServer.a().a();
    }
    if ("gdt_ipc".equals(paramString)) {
      return GdtIpc.a();
    }
    if ("VasFontIPCModule".equals(paramString)) {
      return VasFontIPCModule.a();
    }
    if ("EmoticonIPCModule".equals(paramString)) {
      return EmoticonIPCModule.a();
    }
    if ("BabyQIPCModule".equals(paramString)) {
      return BabyQIPCModule.a();
    }
    if ("VasApngIPCModule".equals(paramString)) {
      return VasApngIPCModule.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCServerModuleFactory
 * JD-Core Version:    0.7.0.1
 */