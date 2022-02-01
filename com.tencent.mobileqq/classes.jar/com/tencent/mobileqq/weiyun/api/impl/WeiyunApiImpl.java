package com.tencent.mobileqq.weiyun.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunPreviewController;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.channel.WySender;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskAlbumStatusReportReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskAlbumStatusReportRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileBatchDownloadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDocDownloadAbsMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskPicBackupReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskPicBackupRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.LibInfoListGetMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.LibInfoListGetMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.MsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdQueryMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdQueryMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.ReqMsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgRsp;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class WeiyunApiImpl
  implements IWeiyunApi
{
  private static final AtomicBoolean[] PWD_RECORD = { new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false), new AtomicBoolean(false) };
  private static Map<String, WeiYunFileInfo> mMapDeletingCloudFiles = new HashMap();
  
  public void addDeletingCloudFile(String paramString, WeiYunFileInfo paramWeiYunFileInfo)
  {
    mMapDeletingCloudFiles.put(paramString, paramWeiYunFileInfo);
  }
  
  public void batchDelete(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, IWeiyunCallback<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2509), getReqBytes(2509, paramDiskDirFileBatchDeleteExMsgReq), new BaseCallback(2509, paramIWeiyunCallback));
  }
  
  public void checkPwd(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, IWeiyunCallback<WeiyunPB.PwdVerifyMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(11005), getReqBytes(11005, paramPwdVerifyMsgReq), new BaseCallback(11005, paramIWeiyunCallback));
  }
  
  public void checkPwdMd5(String paramString, IWeiyunCallback<WeiyunPB.PwdVerifyMsgRsp> paramIWeiyunCallback)
  {
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    localPwdVerifyMsgReq.pwd_md5.set(StringUtils.a(paramString));
    checkPwd(localPwdVerifyMsgReq, paramIWeiyunCallback);
  }
  
  public void cleanPwdRecord(Context paramContext, long paramLong)
  {
    PreferenceUtils.b(paramContext, String.valueOf(paramLong), "key_pwd_queried");
    PreferenceUtils.b(paramContext, String.valueOf(paramLong), "key_pwd_has");
    PreferenceUtils.b(paramContext, String.valueOf(paramLong), "key_pwd_verified");
    PWD_RECORD[0].set(false);
    PWD_RECORD[1].set(false);
    PWD_RECORD[2].set(false);
    PWD_RECORD[3].set(false);
  }
  
  public void copyFileToOtherBid(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, IWeiyunCallback<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245700), getReqBytes(245700, paramCrossBidProxyCopyFileToOtherBidMsgReq), new BaseCallback(245700, paramIWeiyunCallback));
  }
  
  public void fetchBackupAddress(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, IWeiyunCallback<WeiyunPB.DiskPicBackupRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2803), getReqBytes(2803, paramDiskPicBackupReq), new BaseCallback(2803, paramIWeiyunCallback));
  }
  
  public void fetchDownloadAddress(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, IWeiyunCallback<WeiyunPB.DiskFileBatchDownloadMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2402), getReqBytes(2402, paramDiskFileBatchDownloadMsgReq), new BaseCallback(2402, paramIWeiyunCallback));
  }
  
  public void fetchPreviewAddress(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, IWeiyunCallback<WeiyunPB.DiskFileDocDownloadAbsMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2414), getReqBytes(2414, paramDiskFileDocDownloadAbsMsgReq), new BaseCallback(2414, paramIWeiyunCallback));
  }
  
  public void fetchUploadAddress(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, IWeiyunCallback<WeiyunPB.QqSdkFileUploadMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(246000), getReqBytes(246000, paramQqSdkFileUploadMsgReq), new BaseCallback(246000, paramIWeiyunCallback));
  }
  
  public void getCategoryFileList(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, IWeiyunCallback<WeiyunPB.LibInfoListGetMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(26113), getReqBytes(26113, paramLibInfoListGetMsgReq), new BaseCallback(26113, paramIWeiyunCallback));
  }
  
  public void getOfflineFileList(WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq paramCrossBidProxyOfflineFileGetListMsgReq, IWeiyunCallback<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245706), getReqBytes(245706, paramCrossBidProxyOfflineFileGetListMsgReq), new BaseCallback(245706, paramIWeiyunCallback));
  }
  
  public String getPwdMd5(Context paramContext)
  {
    return PreferenceUtils.a(paramContext, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_md5");
  }
  
  byte[] getReqBytes(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    WeiyunPB.MsgBody localMsgBody = new WeiyunPB.MsgBody();
    WeiyunPB.ReqMsgBody localReqMsgBody = new WeiyunPB.ReqMsgBody();
    switch (paramInt)
    {
    default: 
      break;
    case 246001: 
      localReqMsgBody.AioPicAndVideoCopyToWeiyunMsgReq_body.set((WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq)paramObject);
      break;
    case 246000: 
      localReqMsgBody.QqSdkFileUploadMsgReq_body.set((WeiyunPB.QqSdkFileUploadMsgReq)paramObject);
      break;
    case 245706: 
      localReqMsgBody.CrossBidProxyOfflineFileGetListMsgReq_body.set((WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq)paramObject);
      break;
    case 245700: 
      localReqMsgBody.CrossBidProxyCopyFileToOtherBidMsgReq_body.set((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)paramObject);
      break;
    case 245520: 
      localReqMsgBody.WeiyunTrialCouponUseMsgReq_body.set((WeiyunPB.WeiyunTrialCouponUseMsgReq)paramObject);
      break;
    case 26113: 
      localReqMsgBody.LibInfoListGetMsgReq_body.set((WeiyunPB.LibInfoListGetMsgReq)paramObject);
      break;
    case 12102: 
      localReqMsgBody.WeiyunShareAddFromMobileQQMsgReq_body.set((WeiyunPB.WeiyunShareAddFromMobileQQMsgReq)paramObject);
      break;
    case 11005: 
      localReqMsgBody.PwdVerifyMsgReq_body.set((WeiyunPB.PwdVerifyMsgReq)paramObject);
      break;
    case 11001: 
      localReqMsgBody.PwdQueryMsgReq_body.set((WeiyunPB.PwdQueryMsgReq)paramObject);
      break;
    case 2804: 
      localReqMsgBody.DiskAlbumStatusReportReq_body.set((WeiyunPB.DiskAlbumStatusReportReq)paramObject);
      break;
    case 2803: 
      localReqMsgBody.DiskPicBackupReq_body.set((WeiyunPB.DiskPicBackupReq)paramObject);
      break;
    case 2509: 
      localReqMsgBody.DiskDirFileBatchDeleteExMsgReq_body.set((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)paramObject);
      break;
    case 2414: 
      localReqMsgBody.DiskFileDocDownloadAbsMsgReq_body.set((WeiyunPB.DiskFileDocDownloadAbsMsgReq)paramObject);
      break;
    case 2402: 
      localReqMsgBody.DiskFileBatchDownloadMsgReq_body.set((WeiyunPB.DiskFileBatchDownloadMsgReq)paramObject);
    }
    localMsgBody.ReqMsg_body = localReqMsgBody;
    localMsgBody.ReqMsg_body.setHasFlag(true);
    localMsgBody.setHasFlag(true);
    return localMsgBody.toByteArray();
  }
  
  public void getShareLink(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, IWeiyunCallback<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(12102), getReqBytes(12102, paramWeiyunShareAddFromMobileQQMsgReq), new BaseCallback(12102, paramIWeiyunCallback));
  }
  
  public FilePreViewControllerBase getWeiYunFilePreviewController(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2)
  {
    return new WeiYunPreviewController(paramBaseQQAppInterface, paramString1, paramString2);
  }
  
  public void initPwdRecord(Context paramContext)
  {
    ThreadManager.executeOnSubThread(new WeiyunApiImpl.1(this, paramContext));
  }
  
  public boolean isDeletingCloudFile(String paramString)
  {
    return mMapDeletingCloudFiles.containsKey(paramString);
  }
  
  public boolean isPwdQueried()
  {
    return PWD_RECORD[0].get();
  }
  
  public FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle paramBundle)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = QQFileManagerUtil.g().longValue();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.WeiYunFileId = ((String)paramBundle.get("file_id"));
    localFileManagerEntity.fileName = ((String)paramBundle.get("filename"));
    localFileManagerEntity.WeiYunDirKey = ((String)paramBundle.get("pdir_key"));
    return localFileManagerEntity;
  }
  
  public void queryPwd(IWeiyunCallback<WeiyunPB.PwdQueryMsgRsp> paramIWeiyunCallback)
  {
    if (paramIWeiyunCallback == null) {
      return;
    }
    if (PWD_RECORD[0].get())
    {
      WeiyunPB.PwdQueryMsgRsp localPwdQueryMsgRsp = new WeiyunPB.PwdQueryMsgRsp();
      if ((PWD_RECORD[1].get()) && (!PWD_RECORD[2].get()))
      {
        localPwdQueryMsgRsp.pwd_open.set(true);
        paramIWeiyunCallback.a(localPwdQueryMsgRsp);
        return;
      }
      localPwdQueryMsgRsp.pwd_open.set(false);
      paramIWeiyunCallback.a(localPwdQueryMsgRsp);
      return;
    }
    WySender.a().a(Integer.toString(11001), getReqBytes(11001, new WeiyunPB.PwdQueryMsgReq()), new BaseCallback(11001, paramIWeiyunCallback));
  }
  
  public WeiYunFileInfo removeDeletedCloudFile(String paramString)
  {
    return (WeiYunFileInfo)mMapDeletingCloudFiles.remove(paramString);
  }
  
  public void reportAlbumStatus(WeiyunPB.DiskAlbumStatusReportReq paramDiskAlbumStatusReportReq, IWeiyunCallback<WeiyunPB.DiskAlbumStatusReportRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(2804), getReqBytes(2804, paramDiskAlbumStatusReportReq), new BaseCallback(2804, paramIWeiyunCallback));
  }
  
  public void saveAioPicVideo2Weiyun(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, IWeiyunCallback<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(246001), getReqBytes(246001, paramAioPicAndVideoCopyToWeiyunMsgReq), new BaseCallback(246001, paramIWeiyunCallback));
  }
  
  public void savePwdMd5(Context paramContext, String paramString)
  {
    PreferenceUtils.a(paramContext, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_md5", paramString);
  }
  
  public void setPwdOpened(Context paramContext, boolean paramBoolean)
  {
    PWD_RECORD[3].set(true);
    if (PWD_RECORD[1].compareAndSet(paramBoolean ^ true, paramBoolean)) {
      PreferenceUtils.a(paramContext, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_has", Boolean.toString(paramBoolean));
    }
  }
  
  public void setPwdQueried(Context paramContext, boolean paramBoolean)
  {
    PWD_RECORD[3].set(true);
    if (PWD_RECORD[0].compareAndSet(paramBoolean ^ true, paramBoolean)) {
      PreferenceUtils.a(paramContext, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_queried", Boolean.toString(paramBoolean));
    }
  }
  
  public void setPwdVerified(Context paramContext, boolean paramBoolean)
  {
    PWD_RECORD[3].set(true);
    if (PWD_RECORD[2].compareAndSet(paramBoolean ^ true, paramBoolean)) {
      PreferenceUtils.a(paramContext, String.valueOf(MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin()), "key_pwd_verified", Boolean.toString(paramBoolean));
    }
  }
  
  public void startWeiYunMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, paramMiniAppLaunchListener);
  }
  
  public void trialTransferCoupon(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, IWeiyunCallback<WeiyunPB.WeiyunTrialCouponUseMsgRsp> paramIWeiyunCallback)
  {
    WySender.a().a(Integer.toString(245520), getReqBytes(245520, paramWeiyunTrialCouponUseMsgReq), new BaseCallback(245520, paramIWeiyunCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunApiImpl
 * JD-Core Version:    0.7.0.1
 */