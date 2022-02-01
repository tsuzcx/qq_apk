package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class AioQzonePicOperator
  extends UploadPicOperator
{
  public PicUploadInfo a(Intent paramIntent)
  {
    PicUploadInfo localPicUploadInfo = super.a(paramIntent);
    paramIntent = (PhotoSendParams)paramIntent.getParcelableExtra("PhotoConst.photo_send_qzone_pic_file_params");
    if (localPicUploadInfo != null)
    {
      localPicUploadInfo.S = true;
      localPicUploadInfo.R = paramIntent;
    }
    return localPicUploadInfo;
  }
  
  protected PicUploadInfo a(PicUploadInfo paramPicUploadInfo)
  {
    CompressInfo localCompressInfo = new CompressInfo(paramPicUploadInfo.R.thumbPath, 0);
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail(localCompressInfo);
    if (localCompressInfo.l != null)
    {
      paramPicUploadInfo.o = localCompressInfo.l;
      paramPicUploadInfo.p = localCompressInfo.m;
      paramPicUploadInfo.q = localCompressInfo.n;
    }
    return paramPicUploadInfo;
  }
  
  @NotNull
  protected TransferRequest a(PicReq paramPicReq, PicUploadInfo paramPicUploadInfo, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = super.a(paramPicReq, paramPicUploadInfo, paramMessageRecord);
    if (paramPicReq.b == 1045)
    {
      paramMessageRecord.isQzonePic = paramPicUploadInfo.S;
      paramMessageRecord.photoSendParams = paramPicUploadInfo.R;
    }
    return paramMessageRecord;
  }
  
  String a(String paramString)
  {
    return this.c.g.R.rawMd5;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    ((IPicHelper)QRoute.api(IPicHelper.class)).getDrawable(paramMessageForPic, 65537, null, null).downloadImediatly();
    paramMessageForPic = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramMessageForPic, str, "preload thumb", localStringBuilder.toString());
  }
  
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    paramMessageForPic.isQzonePic = paramPicUploadInfo.S;
    String str2 = MessageConstants.r;
    String str1;
    if (paramMessageForPic.isQzonePic) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    paramMessageForPic.saveExtInfoToExtStr(str2, str1);
    paramMessageForPic.saveExtInfoToExtStr(MessageConstants.s, paramPicUploadInfo.R.rawDownloadUrl);
    paramMessageForPic.saveExtInfoToExtStr(MessageConstants.t, String.valueOf(paramPicUploadInfo.R.fileSize));
  }
  
  void a(PicUploadInfo paramPicUploadInfo, MessageForPic paramMessageForPic)
  {
    paramMessageForPic.width = paramPicUploadInfo.R.rawWidth;
    paramMessageForPic.height = paramPicUploadInfo.R.rawHeight;
    paramMessageForPic.imageType = 1000;
  }
  
  protected boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams != null) && (!TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) && (!TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) && (FileUtils.fileExistsAndNotEmpty(paramPhotoSendParams.thumbPath)) && (!TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl))) {
      return true;
    }
    if (QLog.isColorLevel())
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AioQzonePicOperator checkParams:");
      if (paramPhotoSendParams != null) {
        paramPhotoSendParams = paramPhotoSendParams.toString();
      } else {
        paramPhotoSendParams = "";
      }
      localStringBuilder.append(paramPhotoSendParams);
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  protected PicUploadInfo.Builder b(Intent paramIntent)
  {
    PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramIntent.getParcelableExtra("PhotoConst.photo_send_qzone_pic_file_params");
    if (!a(localPhotoSendParams)) {
      return null;
    }
    paramIntent = super.b(paramIntent);
    paramIntent.a(null);
    paramIntent.f(localPhotoSendParams.rawMd5);
    paramIntent.a(localPhotoSendParams.fileSize);
    return paramIntent;
  }
  
  protected void b(MessageForPic paramMessageForPic) {}
  
  protected boolean b(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      Object localObject1 = this.b;
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicUploadInfo);
      Logger.a((String)localObject1, (String)localObject2, "checkPicUploadInfo", localStringBuilder.toString());
      localObject1 = paramPicUploadInfo.R;
      if (!a((PhotoSendParams)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("qzone md5 invalid, md5:");
        if (localObject1 != null) {
          localObject1 = ((PhotoSendParams)localObject1).rawMd5;
        } else {
          localObject1 = "";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        paramPicUploadInfo.a("checkPicInfo", ((StringBuilder)localObject2).toString());
        return false;
      }
      int i = paramPicUploadInfo.c;
      localObject1 = paramPicUploadInfo.f;
      if (((i == 1000) || (i == 1020) || (i == 1004)) && (localObject1 == null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("secondId invalid,uinType:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",secondId:");
        ((StringBuilder)localObject2).append((String)localObject1);
        paramPicUploadInfo.a("checkPicInfo", ((StringBuilder)localObject2).toString());
        return false;
      }
      return true;
    }
    Logger.b(this.b, this.a, "checkPicUploadInfo", "info == null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.AioQzonePicOperator
 * JD-Core Version:    0.7.0.1
 */