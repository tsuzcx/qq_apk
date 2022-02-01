package com.tencent.mobileqq.weiyun.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
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
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdQueryMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgRsp;

@QAPI(process={"all"})
public abstract interface IWeiyunApi
  extends QRouteApi
{
  public static final int FTN_BID_OFFLINE = 3;
  public static final int FTN_BID_WEIYUN = 25;
  
  public abstract void addDeletingCloudFile(String paramString, WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract void batchDelete(WeiyunPB.DiskDirFileBatchDeleteExMsgReq paramDiskDirFileBatchDeleteExMsgReq, IWeiyunCallback<WeiyunPB.DiskDirFileBatchDeleteExMsgRsp> paramIWeiyunCallback);
  
  public abstract void checkPwd(WeiyunPB.PwdVerifyMsgReq paramPwdVerifyMsgReq, IWeiyunCallback<WeiyunPB.PwdVerifyMsgRsp> paramIWeiyunCallback);
  
  public abstract void checkPwdMd5(String paramString, IWeiyunCallback<WeiyunPB.PwdVerifyMsgRsp> paramIWeiyunCallback);
  
  public abstract void cleanPwdRecord(Context paramContext, long paramLong);
  
  public abstract void copyFileToOtherBid(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq paramCrossBidProxyCopyFileToOtherBidMsgReq, IWeiyunCallback<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp> paramIWeiyunCallback);
  
  public abstract void fetchBackupAddress(WeiyunPB.DiskPicBackupReq paramDiskPicBackupReq, IWeiyunCallback<WeiyunPB.DiskPicBackupRsp> paramIWeiyunCallback);
  
  public abstract void fetchDownloadAddress(WeiyunPB.DiskFileBatchDownloadMsgReq paramDiskFileBatchDownloadMsgReq, IWeiyunCallback<WeiyunPB.DiskFileBatchDownloadMsgRsp> paramIWeiyunCallback);
  
  public abstract void fetchPreviewAddress(WeiyunPB.DiskFileDocDownloadAbsMsgReq paramDiskFileDocDownloadAbsMsgReq, IWeiyunCallback<WeiyunPB.DiskFileDocDownloadAbsMsgRsp> paramIWeiyunCallback);
  
  public abstract void fetchUploadAddress(WeiyunPB.QqSdkFileUploadMsgReq paramQqSdkFileUploadMsgReq, IWeiyunCallback<WeiyunPB.QqSdkFileUploadMsgRsp> paramIWeiyunCallback);
  
  public abstract void getCategoryFileList(WeiyunPB.LibInfoListGetMsgReq paramLibInfoListGetMsgReq, IWeiyunCallback<WeiyunPB.LibInfoListGetMsgRsp> paramIWeiyunCallback);
  
  public abstract void getOfflineFileList(WeiyunPB.CrossBidProxyOfflineFileGetListMsgReq paramCrossBidProxyOfflineFileGetListMsgReq, IWeiyunCallback<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp> paramIWeiyunCallback);
  
  public abstract String getPwdMd5(Context paramContext);
  
  public abstract void getShareLink(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, IWeiyunCallback<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp> paramIWeiyunCallback);
  
  public abstract FilePreViewControllerBase getWeiYunFilePreviewController(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2);
  
  public abstract void initPwdRecord(Context paramContext);
  
  public abstract boolean isDeletingCloudFile(String paramString);
  
  public abstract boolean isPwdQueried();
  
  public abstract FileManagerEntity newEntityByWeiYunMiniAppParams(Bundle paramBundle);
  
  public abstract void queryPwd(IWeiyunCallback<WeiyunPB.PwdQueryMsgRsp> paramIWeiyunCallback);
  
  public abstract WeiYunFileInfo removeDeletedCloudFile(String paramString);
  
  public abstract void reportAlbumStatus(WeiyunPB.DiskAlbumStatusReportReq paramDiskAlbumStatusReportReq, IWeiyunCallback<WeiyunPB.DiskAlbumStatusReportRsp> paramIWeiyunCallback);
  
  public abstract void saveAioPicVideo2Weiyun(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, IWeiyunCallback<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp> paramIWeiyunCallback);
  
  public abstract void savePwdMd5(Context paramContext, String paramString);
  
  public abstract void setPwdOpened(Context paramContext, boolean paramBoolean);
  
  public abstract void setPwdQueried(Context paramContext, boolean paramBoolean);
  
  public abstract void setPwdVerified(Context paramContext, boolean paramBoolean);
  
  public abstract void startWeiYunMiniApp(Context paramContext, String paramString, int paramInt, MiniAppLaunchListener paramMiniAppLaunchListener);
  
  public abstract void trialTransferCoupon(WeiyunPB.WeiyunTrialCouponUseMsgReq paramWeiyunTrialCouponUseMsgReq, IWeiyunCallback<WeiyunPB.WeiyunTrialCouponUseMsgRsp> paramIWeiyunCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunApi
 * JD-Core Version:    0.7.0.1
 */