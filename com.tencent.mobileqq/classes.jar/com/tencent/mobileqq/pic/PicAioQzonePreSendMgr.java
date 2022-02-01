package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PicAioQzonePreSendMgr
{
  public static void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramQQAppInterface != null))
    {
      paramBundle.setClassLoader(PhotoSendParams.class.getClassLoader());
      PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramBundle.getParcelable("PhotoConst.photo_send_qzone_pic_file_params");
      String str1 = paramBundle.getString("uin");
      String str2 = paramQQAppInterface.getCurrentUin();
      paramBundle.getString("troop_uin");
      int i = paramBundle.getInt("uintype", 1003);
      if ((localPhotoSendParams != null) && (!TextUtils.isEmpty(localPhotoSendParams.rawMd5)) && (!TextUtils.isEmpty(localPhotoSendParams.thumbPath)) && (FileUtils.fileExistsAndNotEmpty(localPhotoSendParams.thumbPath)) && (!TextUtils.isEmpty(localPhotoSendParams.rawDownloadUrl)) && (!TextUtils.isEmpty(str1)))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("picPreSendProcess params friendUin:");
          paramBundle.append(str1);
          paramBundle.append(", uinType:");
          paramBundle.append(i);
          paramBundle.append(", sendParams:");
          paramBundle.append(localPhotoSendParams.toString());
          QLog.i("PicAioQzonePreSendMgr", 2, paramBundle.toString());
        }
        RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.PicUpReq localPicUpReq;
        if ((i != 1) && (i != 3000))
        {
          localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
          localPicUpReq.selfUin = str2;
          localPicUpReq.peerUin = str1;
          localPicUpReq.secondUin = str2;
          localPicUpReq.fileSize = localPhotoSendParams.fileSize;
          localPicUpReq.md5 = HexUtil.hexStr2Bytes(localPhotoSendParams.rawMd5);
          paramBundle = new StringBuilder();
          paramBundle.append(localPhotoSendParams.rawMd5);
          paramBundle.append(".jpg");
          localPicUpReq.fileName = paramBundle.toString();
          localPicUpReq.width = localPhotoSendParams.rawWidth;
          localPicUpReq.height = localPhotoSendParams.rawHeight;
          localPicUpReq.picType = 1000;
          localPicUpReq.typeHotPic = 3;
          localPicUpReq.transferUrl = localPhotoSendParams.rawDownloadUrl;
          paramBundle = "c2c_pic_up";
        }
        else
        {
          localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
          localPicUpReq.selfUin = str2;
          localPicUpReq.peerUin = str1;
          localPicUpReq.secondUin = str2;
          localPicUpReq.fileSize = localPhotoSendParams.fileSize;
          localPicUpReq.md5 = HexUtil.hexStr2Bytes(localPhotoSendParams.rawMd5);
          paramBundle = new StringBuilder();
          paramBundle.append(localPhotoSendParams.rawMd5);
          paramBundle.append(".jpg");
          localPicUpReq.fileName = paramBundle.toString();
          localPicUpReq.width = localPhotoSendParams.rawWidth;
          localPicUpReq.height = localPhotoSendParams.rawHeight;
          localPicUpReq.picType = 1000;
          localPicUpReq.busiType = 1045;
          localPicUpReq.uinType = 1;
          localPicUpReq.typeHotPic = 3;
          localPicUpReq.transferUrl = localPhotoSendParams.rawDownloadUrl;
          paramBundle = "grp_pic_up";
        }
        if (TextUtils.isEmpty(paramBundle))
        {
          a("picPreSendProcess protoKey=null!");
          return;
        }
        localRichProtoReq.reqs.add(localPicUpReq);
        localRichProtoReq.protoKey = paramBundle;
        localRichProtoReq.protoReqMgr = ((IProtoReqManager)paramQQAppInterface.getRuntimeService(IProtoReqManager.class, ""));
        localRichProtoReq.callback = new PicAioQzonePreSendMgr.1(str2, str1, localPhotoSendParams);
        RichProtoProc.procRichProtoReq(localRichProtoReq);
        return;
      }
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("picPreSendProcess sendParams error, friendUin:");
      paramQQAppInterface.append(str1);
      a(paramQQAppInterface.toString());
      return;
    }
    a("picPreSendProcess bundle=null!");
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PicAioQzonePreSendMgr", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicAioQzonePreSendMgr
 * JD-Core Version:    0.7.0.1
 */