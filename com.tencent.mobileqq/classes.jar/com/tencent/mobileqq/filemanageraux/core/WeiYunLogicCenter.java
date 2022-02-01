package com.tencent.mobileqq.filemanageraux.core;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskSimpleFileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.ExtensionReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.LibInfoListGetMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PicVideo2QcloudItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.PwdVerifyMsgReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.ShareFileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgReq;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class WeiYunLogicCenter
{
  private static boolean a = false;
  private final QQAppInterface b;
  private LinkedHashMap<String, WeiYunFileInfo> c;
  private int d;
  private volatile boolean e;
  private volatile boolean f;
  
  public WeiYunLogicCenter(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    if (a) {
      ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).shutdownWySystem();
    }
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).startWySystem();
    a = true;
  }
  
  private int a(int paramInt)
  {
    if (UinTypeUtil.b(paramInt)) {
      return 0;
    }
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  private int a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (UinTypeUtil.b(paramInt)) {
        return 3;
      }
      return 4;
    }
    if (UinTypeUtil.b(paramInt)) {
      return 1;
    }
    return 2;
  }
  
  private WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq a(FileManagerEntity paramFileManagerEntity, long paramLong)
  {
    WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq localCrossBidProxyCopyFileToOtherBidMsgReq = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
    if (paramFileManagerEntity.fileName != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_name.set(paramFileManagerEntity.fileName);
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.file_size.set(paramFileManagerEntity.fileSize);
    if (paramFileManagerEntity.strFileSHA != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_sha.set(StringUtils.a(paramFileManagerEntity.strFileSHA));
    }
    if (paramFileManagerEntity.strFileMd5 != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.file_md5.set(StringUtils.a(paramFileManagerEntity.strFileMd5));
    }
    if (paramFileManagerEntity.WeiYunFileId != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_file_id.set(paramFileManagerEntity.WeiYunFileId);
    }
    if (paramFileManagerEntity.WeiYunDirKey != null) {
      localCrossBidProxyCopyFileToOtherBidMsgReq.src_pdir_key.set(StringUtils.a(paramFileManagerEntity.WeiYunDirKey));
    }
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_bid.set(25);
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_uin.set(this.b.getLongAccountUin());
    localCrossBidProxyCopyFileToOtherBidMsgReq.src_group.set(this.b.getLongAccountUin());
    localCrossBidProxyCopyFileToOtherBidMsgReq.dst_bid.set(102);
    localCrossBidProxyCopyFileToOtherBidMsgReq.dst_uin.set(paramLong);
    localCrossBidProxyCopyFileToOtherBidMsgReq.user_type.set(0);
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      WeiyunPB.ExtensionReq localExtensionReq = new WeiyunPB.ExtensionReq();
      localExtensionReq.uint64_id.set(3L);
      localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionType == 102L) && (paramFileManagerEntity.peerUin != null)) {
        localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
      }
      paramFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.b, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
      if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
        localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
      }
      localCrossBidProxyCopyFileToOtherBidMsgReq.extension_req.set(localExtensionReq);
    }
    return localCrossBidProxyCopyFileToOtherBidMsgReq;
  }
  
  private WeiyunPB.PicVideo2QcloudItem a(MessageForPic paramMessageForPic)
  {
    WeiyunPB.PicVideo2QcloudItem localPicVideo2QcloudItem = new WeiyunPB.PicVideo2QcloudItem();
    localPicVideo2QcloudItem.bool_auto_create_user.set(true);
    if (!TextUtils.isEmpty(paramMessageForPic.uuid)) {
      localPicVideo2QcloudItem.str_file_id.set(paramMessageForPic.uuid);
    }
    localPicVideo2QcloudItem.uint64_file_id.set(paramMessageForPic.groupFileID);
    if (!TextUtils.isEmpty(paramMessageForPic.uuid)) {
      localPicVideo2QcloudItem.str_file_name.set(paramMessageForPic.uuid);
    }
    if (!TextUtils.isEmpty(paramMessageForPic.md5)) {
      localPicVideo2QcloudItem.str_file_md5.set(paramMessageForPic.md5);
    }
    localPicVideo2QcloudItem.uint32_bid.set(a(false, paramMessageForPic.istroop));
    localPicVideo2QcloudItem.uint32_chat_type.set(a(paramMessageForPic.istroop));
    localPicVideo2QcloudItem.uint32_user_type.set(paramMessageForPic.issend);
    if (!TextUtils.isEmpty(paramMessageForPic.frienduin)) {
      localPicVideo2QcloudItem.str_dst_id.set(paramMessageForPic.frienduin);
    }
    if (!TextUtils.isEmpty(paramMessageForPic.senderuin)) {
      localPicVideo2QcloudItem.str_src_id.set(paramMessageForPic.senderuin);
    }
    localPicVideo2QcloudItem.image_type.set(paramMessageForPic.imageType);
    localPicVideo2QcloudItem.uint64_file_size.set(paramMessageForPic.size);
    if (paramMessageForPic.rawMsgUrl != null) {
      localPicVideo2QcloudItem.raw_url.set(paramMessageForPic.rawMsgUrl);
    }
    return localPicVideo2QcloudItem;
  }
  
  private WeiyunPB.PicVideo2QcloudItem a(MessageForShortVideo paramMessageForShortVideo)
  {
    WeiyunPB.PicVideo2QcloudItem localPicVideo2QcloudItem = new WeiyunPB.PicVideo2QcloudItem();
    localPicVideo2QcloudItem.bool_auto_create_user.set(true);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.uuid)) {
      localPicVideo2QcloudItem.str_file_id.set(paramMessageForShortVideo.uuid);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      localPicVideo2QcloudItem.str_file_md5.set(paramMessageForShortVideo.md5);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName)) {
      localPicVideo2QcloudItem.str_file_name.set(paramMessageForShortVideo.videoFileName);
    }
    localPicVideo2QcloudItem.uint32_bid.set(a(true, paramMessageForShortVideo.istroop));
    localPicVideo2QcloudItem.uint32_chat_type.set(a(paramMessageForShortVideo.istroop));
    localPicVideo2QcloudItem.uint32_user_type.set(paramMessageForShortVideo.issend);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.frienduin)) {
      localPicVideo2QcloudItem.str_dst_id.set(paramMessageForShortVideo.frienduin);
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.senderuin)) {
      localPicVideo2QcloudItem.str_src_id.set(paramMessageForShortVideo.senderuin);
    }
    localPicVideo2QcloudItem.uint64_file_size.set(paramMessageForShortVideo.videoFileSize);
    return localPicVideo2QcloudItem;
  }
  
  @Nullable
  private String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWeiYunThumb : strFileId[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], thumbUrl[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], WeiYunThumbnailType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0))
    {
      if (!paramString2.startsWith("http")) {
        return paramString2;
      }
      paramString2 = ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).genThumbInfo(paramString2, paramInt, paramBoolean);
      File localFile = new File(((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).getDefaultThumbPath(), Long.toString(((Long)paramString2.second).longValue()));
      localObject = localFile.getAbsolutePath();
      if (localFile.exists()) {
        return localObject;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        this.b.getFileManagerNotifyCenter().a(false, 39, new Object[] { paramString1, paramObject });
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : network error");
        }
        return null;
      }
      paramString1 = new WeiYunLogicCenter.7(this, paramString1, paramInt, paramObject);
      ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).downloadImage((String)((Pair)paramString2.first).first, (String)localObject, (String)((Pair)paramString2.first).second, paramString1);
      return null;
    }
    this.b.getFileManagerNotifyCenter().a(false, 39, new Object[] { paramString1, paramObject });
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb : fileID or thumbUrl error");
    }
    return null;
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, int paramInt1, int paramInt2)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, Long.valueOf(paramString).longValue());
    if (localTroopFileTransferManager == null) {
      return;
    }
    int i = FileManagerUtil.c(paramTroopFileStatusInfo.k);
    long l1;
    if ((FileUtil.d(paramTroopFileStatusInfo.k)) && ((i == 0) || (i == 2)))
    {
      Object localObject;
      long l2;
      if (i == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramTroopFileStatusInfo.k, (BitmapFactory.Options)localObject);
        l2 = TroopFileUtils.a(this.b, paramString, paramTroopFileStatusInfo.t, paramTroopFileStatusInfo.i, paramTroopFileStatusInfo.a.toString(), paramInt2, Long.toString(paramTroopFileStatusInfo.d), paramFileManagerEntity.nSessionId, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight);
        paramTroopFileStatusInfo = localTroopFileTransferManager.i(paramTroopFileStatusInfo.a);
        l1 = l2;
        if (paramTroopFileStatusInfo != null)
        {
          paramTroopFileStatusInfo.width = ((BitmapFactory.Options)localObject).outWidth;
          paramTroopFileStatusInfo.height = ((BitmapFactory.Options)localObject).outHeight;
          l1 = l2;
        }
      }
      else if (i == 2)
      {
        localObject = ShortVideoUtils.getVideoFileRtAndTime(paramTroopFileStatusInfo.k);
        l2 = TroopFileUtils.a(this.b, paramString, paramTroopFileStatusInfo.t, paramTroopFileStatusInfo.i, paramTroopFileStatusInfo.a.toString(), paramInt2, Long.toString(paramTroopFileStatusInfo.d), paramFileManagerEntity.nSessionId, localObject[0], localObject[1], localObject[2]);
        paramTroopFileStatusInfo = localTroopFileTransferManager.i(paramTroopFileStatusInfo.a);
        l1 = l2;
        if (paramTroopFileStatusInfo != null)
        {
          paramTroopFileStatusInfo.width = localObject[0];
          paramTroopFileStatusInfo.height = localObject[1];
          l1 = l2;
        }
      }
      else
      {
        l1 = 0L;
      }
    }
    else
    {
      l1 = TroopFileUtils.a(this.b, paramString, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, paramTroopFileStatusInfo.a.toString(), paramInt2, Long.toString(8888L), paramFileManagerEntity.nSessionId);
    }
    if ((paramInt1 != 0) && (l1 != 0L)) {
      ForwardOrderManager.a().a(l1, paramFileManagerEntity.uniseq, paramInt1);
    }
  }
  
  private void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq paramAioPicAndVideoCopyToWeiyunMsgReq, WeiyunCallback paramWeiyunCallback)
  {
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).saveAioPicVideo2Weiyun(paramAioPicAndVideoCopyToWeiyunMsgReq, new WeiYunLogicCenter.6(this, paramWeiyunCallback));
  }
  
  private boolean a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a(WeiyunPB.WeiyunShareAddFromMobileQQMsgReq paramWeiyunShareAddFromMobileQQMsgReq, FileManagerEntity paramFileManagerEntity)
  {
    int j = FileManagerUtil.h(paramFileManagerEntity);
    if (j == 2)
    {
      paramWeiyunShareAddFromMobileQQMsgReq.source.set(1);
      paramWeiyunShareAddFromMobileQQMsgReq.file.setHasFlag(true);
      paramWeiyunShareAddFromMobileQQMsgReq.file.file_id.set(paramFileManagerEntity.WeiYunFileId);
      if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
      {
        paramWeiyunShareAddFromMobileQQMsgReq.file.pdir_key.set(StringUtils.a(paramFileManagerEntity.WeiYunDirKey));
        return true;
      }
    }
    else
    {
      int i = 3;
      Object localObject;
      if (j == 1)
      {
        paramWeiyunShareAddFromMobileQQMsgReq.source.set(2);
        PBUInt64Field localPBUInt64Field = paramWeiyunShareAddFromMobileQQMsgReq.src_uin;
        if (paramFileManagerEntity.peerType == 3000) {
          localObject = paramFileManagerEntity.peerUin;
        } else {
          localObject = this.b.getCurrentAccountUin();
        }
        localPBUInt64Field.set(Long.parseLong((String)localObject));
        localObject = paramWeiyunShareAddFromMobileQQMsgReq.src_appid;
        if (paramFileManagerEntity.peerType == 3000) {
          i = 106;
        }
        ((PBUInt32Field)localObject).set(i);
        if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)) {
          paramWeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
        }
        paramWeiyunShareAddFromMobileQQMsgReq.file_size.set(paramFileManagerEntity.fileSize);
        if (!TextUtils.isEmpty(paramFileManagerEntity.fileName)) {
          paramWeiyunShareAddFromMobileQQMsgReq.file_name.set(paramFileManagerEntity.fileName);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.strFileSHA))
        {
          paramWeiyunShareAddFromMobileQQMsgReq.file_sha.set(paramFileManagerEntity.strFileSHA);
          return true;
        }
      }
      else
      {
        if (j != 4) {
          break label411;
        }
        paramWeiyunShareAddFromMobileQQMsgReq.source.set(3);
        localObject = null;
        try
        {
          paramFileManagerEntity = TroopFileUtils.a(this.b, paramFileManagerEntity);
        }
        catch (Throwable paramFileManagerEntity)
        {
          QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : get troop file info error", paramFileManagerEntity);
          paramFileManagerEntity = (FileManagerEntity)localObject;
        }
        if ((paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.r))) {
          break label393;
        }
        paramWeiyunShareAddFromMobileQQMsgReq.src_uin.set(paramFileManagerEntity.d);
        paramWeiyunShareAddFromMobileQQMsgReq.src_appid.set(paramFileManagerEntity.u);
        paramWeiyunShareAddFromMobileQQMsgReq.src_full_path.set(ByteStringMicro.copyFrom(paramFileManagerEntity.r.getBytes()));
        paramWeiyunShareAddFromMobileQQMsgReq.file_size.set(paramFileManagerEntity.i);
        if (!TextUtils.isEmpty(paramFileManagerEntity.t)) {
          paramWeiyunShareAddFromMobileQQMsgReq.file_name.set(paramFileManagerEntity.t);
        }
        if (!TextUtils.isEmpty(paramFileManagerEntity.s)) {
          paramWeiyunShareAddFromMobileQQMsgReq.file_sha.set(paramFileManagerEntity.s);
        }
      }
    }
    return true;
    label393:
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : troop file info is invalid");
    }
    return false;
    label411:
    if (QLog.isColorLevel())
    {
      paramWeiyunShareAddFromMobileQQMsgReq = new StringBuilder();
      paramWeiyunShareAddFromMobileQQMsgReq.append("getShareLink : unsupported cloudType:");
      paramWeiyunShareAddFromMobileQQMsgReq.append(j);
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramWeiyunShareAddFromMobileQQMsgReq.toString());
    }
    return false;
  }
  
  private void c()
  {
    if (!((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).checkSOExists(this.b.getApplication()))
    {
      if (NetworkUtils.isWifiAvailable(this.b.getApplication()))
      {
        this.f = true;
        ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).downloadSo(this.b.getApplication(), new WeiYunLogicCenter.8(this));
      }
    }
    else
    {
      this.e = true;
      ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).initTransmission(this.b.getApplication(), true);
      WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).getUploadSoFile(this.b.getApplication()).getAbsolutePath());
    }
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : entity is null!");
      }
      FileManagerUtil.d();
      return null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "insertOfflineFile2WeiYunEntity : fromUin is null!");
      }
      FileManagerUtil.d();
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    localFileManagerEntity.uniseq = -1L;
    localFileManagerEntity.nOpType = 4;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.b, paramString, null, paramFileManagerEntity.peerType);
    localFileManagerEntity.peerType = paramFileManagerEntity.peerType;
    localFileManagerEntity.peerUin = paramString;
    if (paramFileManagerEntity.peerType == 3000) {
      localFileManagerEntity.selfUin = paramFileManagerEntity.peerUin;
    } else {
      localFileManagerEntity.selfUin = this.b.getAccount();
    }
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.status = 2;
    this.b.getFileManagerDataCenter().a(localFileManagerEntity);
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("insertWeiYun2OfflineEntity FileManagerEntity:");
      paramFileManagerEntity.append(FileManagerUtil.c(localFileManagerEntity));
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, paramFileManagerEntity.toString());
    }
    return localFileManagerEntity;
  }
  
  public FileManagerEntity a(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel())
      {
        paramFileManagerEntity = new StringBuilder();
        paramFileManagerEntity.append("insertWeiYun2OfflineEntity : entity is null, peerUin[");
        paramFileManagerEntity.append(FileManagerUtil.k(paramString2));
        paramFileManagerEntity.append("], peerType[");
        paramFileManagerEntity.append(paramInt1);
        paramFileManagerEntity.append("]");
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, paramFileManagerEntity.toString());
      }
      return null;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = FileManagerUtil.a().longValue();
    String str = TransfileUtile.makeTransFileProtocolData("", 0L, 0, true);
    long l = MessageRecordFactory.a(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 3;
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.b, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.b.getAccount();
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = FileManagerUtil.f();
    localFileManagerEntity.msgUid = FileManagerUtil.g();
    if (paramInt2 != 0) {
      ForwardOrderManager.a().a(l, paramFileManagerEntity.uniseq, paramInt2);
    }
    this.b.getFileManagerDataCenter().a(localFileManagerEntity);
    paramFileManagerEntity = this.b.getAccount();
    if ((paramInt1 != 1004) && (paramInt1 != 1000))
    {
      if (paramInt1 == 1006)
      {
        paramFileManagerEntity = paramString1;
        localFileManagerEntity.tmpSessionFromPhone = paramFileManagerEntity;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
      }
    }
    else {
      paramFileManagerEntity = paramString1;
    }
    this.b.getFileManagerDataCenter().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, l, localFileManagerEntity.msgUid, -1L, MessageCache.c());
    if (QLog.isColorLevel())
    {
      paramFileManagerEntity = new StringBuilder();
      paramFileManagerEntity.append("insertWeiYun2OfflineEntity peerType[");
      paramFileManagerEntity.append(paramInt1);
      paramFileManagerEntity.append("],FileManagerEntity:");
      paramFileManagerEntity.append(FileManagerUtil.c(localFileManagerEntity));
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, paramFileManagerEntity.toString());
    }
    return localFileManagerEntity;
  }
  
  public WeiyunTask a(FileManagerEntity paramFileManagerEntity, Object paramObject, IDownloadStatusListener paramIDownloadStatusListener)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile entity is null");
      }
      return null;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downLoadWeiYunFile, fileId[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.WeiYunFileId);
      ((StringBuilder)localObject).append("], fileName[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
      ((StringBuilder)localObject).append("], fileSize[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.fileSize);
      ((StringBuilder)localObject).append("],modifyTime[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.lastTime);
      ((StringBuilder)localObject).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey))
    {
      localObject = FileTransferHandler.a(paramFileManagerEntity.WeiYunFileId);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "downLoadWeiYunFile dirKey is null");
        }
        return null;
      }
      paramFileManagerEntity.WeiYunDirKey = ((String)((Pair)localObject).first);
      paramFileManagerEntity.WeiYunFileId = ((String)((Pair)localObject).second);
    }
    if (paramFileManagerEntity.nWeiYunSrcType == 2) {
      localObject = ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).downloadShare(paramFileManagerEntity.strLargeThumPath, paramFileManagerEntity.strThumbPath, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.WeiYunFileId, paramIDownloadStatusListener);
    }
    for (;;)
    {
      break;
      paramFileManagerEntity = ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).createDownloadFile(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.strFileSHA, paramFileManagerEntity.fileSize, 0, paramFileManagerEntity.WeiYunDirKey, paramFileManagerEntity.strLargeThumPath);
      if (paramFileManagerEntity == null) {
        paramFileManagerEntity = null;
      } else {
        paramFileManagerEntity = ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).download(paramFileManagerEntity, ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).getDefaultDownloadPath(), true, paramIDownloadStatusListener);
      }
      localObject = paramFileManagerEntity;
      if (TextUtils.isEmpty(paramFileManagerEntity))
      {
        if (QLog.isColorLevel()) {
          QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "create download task failed!");
        }
        return null;
      }
    }
    return new WeiyunTask((String)localObject, paramObject, false, null, paramIDownloadStatusListener);
  }
  
  public WeiyunTask a(String paramString, Object paramObject, UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if ((!this.e) && (!this.f)) {
      c();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile strPath is null");
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uploadWeiYunFile, strPath[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramString = ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).createUploadFile(paramString, UploadFile.createUploadBatch(1, null), 1);
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = WeiyunTransmissionGlobal.getInstance().getUploadManager().upload(paramString, false, true, paramIUploadStatusListener);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "uploadWeiYunFile create upload task failed!");
      }
      return null;
    }
    return new WeiyunTask(paramString, paramObject, true, paramIUploadStatusListener, null);
  }
  
  public String a(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramInt, true, paramObject);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("queryWeiyunFileList, categoryId[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], offset[");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], count[");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], version[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      this.b.getFileManagerNotifyCenter().a(false, 31, new Object[] { Integer.valueOf(0), "network error", paramString1 });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : network error");
      }
      return;
    }
    if (paramInt2 == 0)
    {
      localObject = this.c;
      if (localObject != null) {
        ((LinkedHashMap)localObject).clear();
      }
      this.c = new LinkedHashMap();
      this.d = 0;
    }
    else if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "queryWeiyunFileList : start not from zero?!");
      }
      return;
    }
    this.d += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("categoryId : ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    if ("document".equals(paramString1)) {
      paramInt2 = 1;
    } else if ("picture".equals(paramString1)) {
      paramInt2 = i;
    } else if ("video".equals(paramString1)) {
      paramInt2 = 4;
    } else if ("music".equals(paramString1)) {
      paramInt2 = 3;
    } else {
      paramInt2 = 5;
    }
    WeiyunPB.LibInfoListGetMsgReq localLibInfoListGetMsgReq = new WeiyunPB.LibInfoListGetMsgReq();
    localLibInfoListGetMsgReq.lib_id.set(paramInt2);
    localLibInfoListGetMsgReq.load_type.set(1);
    PBStringField localPBStringField = localLibInfoListGetMsgReq.local_version;
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    localPBStringField.set((String)localObject);
    localLibInfoListGetMsgReq.count.set(paramInt3);
    localLibInfoListGetMsgReq.scene_id.set(paramInt1);
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getCategoryFileList(localLibInfoListGetMsgReq, new WeiYunLogicCenter.1(this, paramString1));
  }
  
  public void a(ChatMessage paramChatMessage, WeiyunCallback paramWeiyunCallback)
  {
    WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq localAioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq();
    ArrayList localArrayList = new ArrayList(1);
    if ((paramChatMessage instanceof MessageForPic)) {
      localArrayList.add(a((MessageForPic)paramChatMessage));
    } else if ((paramChatMessage instanceof MessageForShortVideo)) {
      localArrayList.add(a((MessageForShortVideo)paramChatMessage));
    }
    localAioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(localArrayList);
    a(localAioPicAndVideoCopyToWeiyunMsgReq, paramWeiyunCallback);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "=_= ^! [CS Send]sendWeiYun2OfflineFile : entity is null");
      FileManagerUtil.a(this.b, 0L, "actFileWy2Of", 0L, "", "", "", "", 9006L, "entity is null", 0L, 0L, 0L, "", "", 0, "", null);
      FileManagerUtil.d();
      return;
    }
    paramFileManagerEntity.status = 2;
    paramBoolean = NetworkUtil.isNetSupport(BaseApplication.getContext());
    int i = 3;
    if (!paramBoolean)
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      this.b.getFileManagerDataCenter().a();
      this.b.getFileManagerNotifyCenter().a(false, 3, null);
      this.b.getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(2), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^! [CS Send] Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("]sendWeiYun2OfflineFile : network error");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      FileManagerUtil.a(this.b, paramFileManagerEntity.nSessionId, "actFileWy2Of", 0L, "", paramFileManagerEntity.peerUin, "", "", 9004L, "Error_No_Network", 0L, 0L, 0L, "", "", 0, "", null);
      this.b.getFileManagerDataCenter().c(paramFileManagerEntity);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [CS Send]sendWyFile2QqOffline, peerUin[");
    ((StringBuilder)localObject).append(FileManagerUtil.k(paramFileManagerEntity.peerUin));
    ((StringBuilder)localObject).append("peerType[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]], WeiYunFileId[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.WeiYunFileId);
    ((StringBuilder)localObject).append("], fileName[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
    ((StringBuilder)localObject).append("], fileSize[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.fileSize);
    ((StringBuilder)localObject).append("], nWeiYunSrcType[");
    ((StringBuilder)localObject).append(paramFileManagerEntity.nWeiYunSrcType);
    ((StringBuilder)localObject).append("]");
    QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    paramFileManagerEntity.fProgress = 0.0F;
    try
    {
      l = Long.parseLong(paramFileManagerEntity.peerUin.replace("+", ""));
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label434:
      WeiyunPB.ExtensionReq localExtensionReq;
      break label434;
    }
    if (QLog.isColorLevel()) {
      QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
    }
    l = 0L;
    localObject = (ShieldMsgManger)this.b.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if ((QFileAssistantUtils.b()) && (!QFileAssistantUtils.b()) && (localObject != null) && (((ShieldMsgManger)localObject).a(paramFileManagerEntity.peerUin)))
    {
      FileManagerUtil.l(HardCodeUtil.a(2131913841));
      paramFileManagerEntity.status = 0;
      this.b.getFileManagerDataCenter().a();
      this.b.getFileManagerNotifyCenter().a(false, 3, null);
      this.b.getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(10), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2OfflineFile : shield");
      }
      this.b.getFileManagerDataCenter().c(paramFileManagerEntity);
      return;
    }
    if ((!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) && (!TextUtils.isEmpty(paramFileManagerEntity.fileName)))
    {
      if (paramInt == 3000)
      {
        i = 106;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_=k Id[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] sendWeiYun2Disc[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("=_=k Id[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
        ((StringBuilder)localObject).append("] sendWeiYun2Offline[");
        ((StringBuilder)localObject).append(paramFileManagerEntity.fileName);
        ((StringBuilder)localObject).append("]");
        QLog.i("WeiYunLogicCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= ^ Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("]sendWyFile2Offline bizId:");
      ((StringBuilder)localObject).append(i);
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      localObject = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
      if (paramFileManagerEntity.fileName != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_name.set(paramFileManagerEntity.fileName);
      }
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_size.set(paramFileManagerEntity.fileSize);
      if (paramFileManagerEntity.strFileSHA != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_sha.set(StringUtils.a(paramFileManagerEntity.strFileSHA));
      }
      if (paramFileManagerEntity.strFileMd5 != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_md5.set(StringUtils.a(paramFileManagerEntity.strFileMd5));
      } else {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_md5.set(StringUtils.a(""));
      }
      if (paramFileManagerEntity.WeiYunFileId != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_file_id.set(paramFileManagerEntity.WeiYunFileId);
      }
      if (paramFileManagerEntity.WeiYunDirKey != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_pdir_key.set(StringUtils.a(paramFileManagerEntity.WeiYunDirKey));
      }
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_bid.set(25);
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_uin.set(this.b.getLongAccountUin());
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_group.set(this.b.getLongAccountUin());
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).dst_bid.set(i);
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).dst_uin.set(l);
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).user_type.set(0);
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localExtensionReq = new WeiyunPB.ExtensionReq();
        localExtensionReq.uint64_id.set(3L);
        localExtensionReq.uint64_type.set(paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionType == 102L) && (paramFileManagerEntity.peerUin != null)) {
          localExtensionReq.str_dst_phonenum.set(paramFileManagerEntity.peerUin);
        }
        paramFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.b, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
          localExtensionReq.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
        }
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).extension_req.set(localExtensionReq);
      }
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).copyFileToOtherBid((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject, new WeiYunLogicCenter.3(this, paramFileManagerEntity, paramInt));
      FileManagerUtil.b(paramFileManagerEntity.nSessionId);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendWyFile2QqOffline onFailed: weiyunID is null[");
      ((StringBuilder)localObject).append(TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId));
      ((StringBuilder)localObject).append("], fileName is Null[");
      ((StringBuilder)localObject).append(TextUtils.isEmpty(paramFileManagerEntity.fileName));
      ((StringBuilder)localObject).append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    paramFileManagerEntity.status = 0;
    paramFileManagerEntity.isReaded = false;
    this.b.getFileManagerDataCenter().a();
    this.b.getFileManagerDataCenter().c(paramFileManagerEntity);
    this.b.getFileManagerDataCenter().a(paramFileManagerEntity.nSessionId, 1005);
    this.b.getFileManagerNotifyCenter().a(false, 33, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, WeiyunCallback paramWeiyunCallback)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (paramWeiyunCallback != null) {
        paramWeiyunCallback.a(2, "");
      }
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink : network error");
      }
      return;
    }
    WeiyunPB.WeiyunShareAddFromMobileQQMsgReq localWeiyunShareAddFromMobileQQMsgReq = new WeiyunPB.WeiyunShareAddFromMobileQQMsgReq();
    if ((a(localWeiyunShareAddFromMobileQQMsgReq, paramLong, paramString, paramBoolean1, paramBoolean2)) && (a(localWeiyunShareAddFromMobileQQMsgReq, paramFileManagerEntity)))
    {
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getShareLink(localWeiyunShareAddFromMobileQQMsgReq, new WeiYunLogicCenter.11(this, paramWeiyunCallback));
      return;
    }
    if (paramWeiyunCallback != null) {
      paramWeiyunCallback.a(13, "");
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : entity is null");
      }
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, Long.valueOf(paramString).longValue());
    if (localTroopFileTransferManager == null) {
      return;
    }
    int i = Math.abs(new Random().nextInt());
    TroopFileStatusInfo localTroopFileStatusInfo = localTroopFileTransferManager.a(paramFileManagerEntity.WeiYunFileId, paramFileManagerEntity.fileName, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize, 25, i, 8888L);
    if (localTroopFileStatusInfo == null) {
      return;
    }
    a(paramFileManagerEntity, localTroopFileStatusInfo, paramString, paramInt, i);
    paramFileManagerEntity.status = 2;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localTroopFileStatusInfo.a, -1, null, HardCodeUtil.a(2131913839));
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "sendWeiYun2Troop : network error");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendWeiYun2Troop, peerUin[");
      localStringBuilder.append(FileManagerUtil.k(paramFileManagerEntity.peerUin));
      localStringBuilder.append("], WeiYunFileId[");
      localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
      localStringBuilder.append("], fileName[");
      localStringBuilder.append(paramFileManagerEntity.fileName);
      localStringBuilder.append("], fileSize[");
      localStringBuilder.append(paramFileManagerEntity.fileSize);
      localStringBuilder.append("], nWeiYunSrcType[");
      localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
      localStringBuilder.append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, localStringBuilder.toString());
    }
    paramFileManagerEntity.fProgress = 0.0F;
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label316:
      break label316;
    }
    l1 = l2;
    if (QLog.isColorLevel())
    {
      QLog.w("WeiYunLogicCenter<FileAssistant>", 2, "number format failed!");
      l1 = l2;
    }
    paramString = a(paramFileManagerEntity, l1);
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).copyFileToOtherBid(paramString, new WeiYunLogicCenter.4(this, localTroopFileTransferManager, localTroopFileStatusInfo, paramFileManagerEntity));
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("deleteWeiYunFile, strFileId[");
      ((StringBuilder)localObject1).append(paramWeiYunFileInfo.a);
      ((StringBuilder)localObject1).append("],strFileName[");
      ((StringBuilder)localObject1).append(paramWeiYunFileInfo.c);
      ((StringBuilder)localObject1).append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).addDeletingCloudFile(paramWeiYunFileInfo.a, paramWeiYunFileInfo);
    Object localObject2 = new WeiyunPB.DiskSimpleFileItem();
    ((WeiyunPB.DiskSimpleFileItem)localObject2).file_id.set(paramWeiYunFileInfo.a);
    if (paramWeiYunFileInfo.b != null) {
      ((WeiyunPB.DiskSimpleFileItem)localObject2).pdir_key.set(StringUtils.a(paramWeiYunFileInfo.b));
    }
    ((WeiyunPB.DiskSimpleFileItem)localObject2).filename.set(paramWeiYunFileInfo.c);
    Object localObject1 = new ArrayList(1);
    ((List)localObject1).add(localObject2);
    localObject2 = new WeiyunPB.DiskDirFileBatchDeleteExMsgReq();
    ((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)localObject2).file_list.set((List)localObject1);
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).batchDelete((WeiyunPB.DiskDirFileBatchDeleteExMsgReq)localObject2, new WeiYunLogicCenter.9(this, paramWeiYunFileInfo));
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo, WeiyunCallback paramWeiyunCallback)
  {
    if (paramWeiYunFileInfo == null)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Send]sendWeiYun2Dataline : entity is null");
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (paramWeiyunCallback != null) {
        paramWeiyunCallback.a(-1, "no_network");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [CS Send]sendWeiYun2Dataline, WeiYunFileId[");
    ((StringBuilder)localObject).append(paramWeiYunFileInfo.a);
    ((StringBuilder)localObject).append("], fileName[");
    ((StringBuilder)localObject).append(paramWeiYunFileInfo.c);
    ((StringBuilder)localObject).append("], fileSize[");
    ((StringBuilder)localObject).append(paramWeiYunFileInfo.d);
    ((StringBuilder)localObject).append("], nWeiYunSrcType[");
    ((StringBuilder)localObject).append(paramWeiYunFileInfo.f);
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramWeiYunFileInfo.a)) && (!TextUtils.isEmpty(paramWeiYunFileInfo.c)))
    {
      localObject = new WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq();
      if (paramWeiYunFileInfo.c != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_name.set(paramWeiYunFileInfo.c);
      }
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_size.set(paramWeiYunFileInfo.d);
      if (paramWeiYunFileInfo.n != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_sha.set(StringUtils.a(paramWeiYunFileInfo.n));
      }
      if (paramWeiYunFileInfo.m != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_md5.set(StringUtils.a(paramWeiYunFileInfo.m));
      } else {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).file_md5.set(StringUtils.a(""));
      }
      if (paramWeiYunFileInfo.a != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_file_id.set(paramWeiYunFileInfo.a);
      }
      if (paramWeiYunFileInfo.b != null) {
        ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_pdir_key.set(StringUtils.a(paramWeiYunFileInfo.b));
      }
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_bid.set(25);
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_uin.set(this.b.getLongAccountUin());
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).src_group.set(this.b.getLongAccountUin());
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).dst_bid.set(38);
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).dst_uin.set(this.b.getLongAccountUin());
      ((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject).user_type.set(0);
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).copyFileToOtherBid((WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgReq)localObject, new WeiYunLogicCenter.5(this, paramWeiyunCallback));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendWeiYun2Dataline onFailed: weiyunID is null[");
    ((StringBuilder)localObject).append(TextUtils.isEmpty(paramWeiYunFileInfo.a));
    ((StringBuilder)localObject).append("], fileName is Null[");
    ((StringBuilder)localObject).append(TextUtils.isEmpty(paramWeiYunFileInfo.c));
    ((StringBuilder)localObject).append("]");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    if (paramWeiyunCallback != null) {
      paramWeiyunCallback.a(-2, "no_weiyunid_or_filename");
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd");
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "verifyPwd : network error");
      }
      this.b.getFileManagerNotifyCenter().a(false, 45, new Object[] { Integer.valueOf(0), BaseApplication.getContext().getString(2131892102) });
      return;
    }
    WeiyunPB.PwdVerifyMsgReq localPwdVerifyMsgReq = new WeiyunPB.PwdVerifyMsgReq();
    paramString = Utils.bytes2HexStr(Utils.str2Md5(paramString));
    localPwdVerifyMsgReq.pwd_md5.set(StringUtils.a(paramString));
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).checkPwd(localPwdVerifyMsgReq, new WeiYunLogicCenter.13(this, paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject = new WeiyunPB.DiskFileDocDownloadAbsMsgReq();
      ((WeiyunPB.DiskFileDocDownloadAbsMsgReq)localObject).file_id.set(paramString1);
      ((WeiyunPB.DiskFileDocDownloadAbsMsgReq)localObject).pdir_key.set(StringUtils.a(paramString2));
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).fetchPreviewAddress((WeiyunPB.DiskFileDocDownloadAbsMsgReq)localObject, new WeiYunLogicCenter.10(this));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get weiyun file PreviewAddress onFailed, fileId[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("],dirKey[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject).toString());
    }
    this.b.getFileManagerNotifyCenter().a(false, 278, new Object[] { Integer.valueOf(1810001), HardCodeUtil.a(2131913842), "", "", "", "", Integer.valueOf(0) });
  }
  
  public void a(List<MessageForPic> paramList, List<MessageForShortVideo> paramList1, WeiyunCallback paramWeiyunCallback)
  {
    WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq localAioPicAndVideoCopyToWeiyunMsgReq = new WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((MessageForPic)paramList.next()));
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList = paramList1.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((MessageForShortVideo)paramList.next()));
      }
    }
    localAioPicAndVideoCopyToWeiyunMsgReq.pic_video_2qcloud_list.set(localArrayList);
    a(localAioPicAndVideoCopyToWeiyunMsgReq, paramWeiyunCallback);
  }
  
  public boolean a()
  {
    return ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).isPwdQueried();
  }
  
  public String b(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramInt, false, paramObject);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "queryNeedVerifyPwd");
    }
    ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).queryPwd(new WeiYunLogicCenter.12(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter
 * JD-Core Version:    0.7.0.1
 */