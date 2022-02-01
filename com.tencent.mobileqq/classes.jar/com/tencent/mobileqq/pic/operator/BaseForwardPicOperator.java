package com.tencent.mobileqq.pic.operator;

import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.AppInterface;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public abstract class BaseForwardPicOperator
  extends BasePicOperator
{
  public MessageRecord a(PicFowardInfo paramPicFowardInfo)
  {
    if ((paramPicFowardInfo != null) && (paramPicFowardInfo.a))
    {
      long l = System.currentTimeMillis();
      Object localObject1 = paramPicFowardInfo.b;
      Object localObject2 = new PicFowardDbRecordData();
      ((PicFowardDbRecordData)localObject2).fowardThumbPath = ((PicUploadInfo)localObject1).o;
      MessageForPic localMessageForPic = (MessageForPic)((IMessageRecordFactory)QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.e, ((PicUploadInfo)localObject1).e, ((PicUploadInfo)localObject1).f, ((PicUploadInfo)localObject1).c);
      localMessageForPic.path = ((PicUploadInfo)localObject1).n;
      boolean bool = true;
      localMessageForPic.type = 1;
      Object localObject3 = new File(((PicUploadInfo)localObject1).n);
      if (((File)localObject3).exists())
      {
        if (GifDrawable.isGifFile((File)localObject3)) {
          localMessageForPic.imageType = 2000;
        }
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject3).inSampleSize = 1;
        SafeBitmapFactory.decodeFile(((PicUploadInfo)localObject1).n, (BitmapFactory.Options)localObject3);
        localMessageForPic.width = ((BitmapFactory.Options)localObject3).outWidth;
        localMessageForPic.height = ((BitmapFactory.Options)localObject3).outHeight;
        if (RichMediaUtil.isPicLandscape(((PicUploadInfo)localObject1).n))
        {
          localMessageForPic.width = ((BitmapFactory.Options)localObject3).outHeight;
          localMessageForPic.height = ((BitmapFactory.Options)localObject3).outWidth;
          if (QLog.isColorLevel())
          {
            String str1 = this.b;
            String str2 = this.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" pic is Landscape,swap w,h; options.outWidth = ");
            localStringBuilder.append(((BitmapFactory.Options)localObject3).outWidth);
            localStringBuilder.append(",options.outHeight = ");
            localStringBuilder.append(((BitmapFactory.Options)localObject3).outHeight);
            localStringBuilder.append(",mr.width = ");
            localStringBuilder.append(localMessageForPic.width);
            localStringBuilder.append(",mr.height = ");
            localStringBuilder.append(localMessageForPic.height);
            Logger.a(str1, str2, "packForwardMsg", localStringBuilder.toString());
          }
        }
        localMessageForPic.md5 = ((PicUploadInfo)localObject1).m;
      }
      localMessageForPic.fileSizeFlag = paramPicFowardInfo.b.F;
      paramPicFowardInfo = paramPicFowardInfo.c;
      if (paramPicFowardInfo != null)
      {
        if (paramPicFowardInfo.m != null) {
          localMessageForPic.md5 = paramPicFowardInfo.m;
        }
        if (paramPicFowardInfo.g != 0L) {
          ((PicFowardDbRecordData)localObject2).fowardOrgId = paramPicFowardInfo.g;
        }
        if (paramPicFowardInfo.e != null) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUin = paramPicFowardInfo.e;
        }
        if (paramPicFowardInfo.c != -1) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUinType = paramPicFowardInfo.c;
        }
        if (paramPicFowardInfo.n != null) {
          ((PicFowardDbRecordData)localObject2).fowardOrgUrl = paramPicFowardInfo.n;
        }
      }
      if (((PicUploadInfo)localObject1).U != -1)
      {
        paramPicFowardInfo = new PicMessageExtraData();
        paramPicFowardInfo.imageBizType = ((PicUploadInfo)localObject1).U;
        localMessageForPic.picExtraData = paramPicFowardInfo;
      }
      localMessageForPic.picExtraFlag = 10;
      localMessageForPic.picExtraObject = localObject2;
      if (((PicUploadInfo)localObject1).ad == null) {
        bool = false;
      }
      if (bool)
      {
        localMessageForPic.msgseq = ((PicUploadInfo)localObject1).ad.a;
        localMessageForPic.shmsgseq = ((PicUploadInfo)localObject1).ad.b;
        localMessageForPic.msgUid = ((PicUploadInfo)localObject1).ad.c;
      }
      localMessageForPic.localUUID = ((PicUploadInfo)localObject1).a;
      paramPicFowardInfo = this.b;
      localObject2 = this.a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localMessageForPic.localUUID);
      ((StringBuilder)localObject3).append("|");
      ((StringBuilder)localObject3).append(localMessageForPic.uniseq);
      Logger.a(paramPicFowardInfo, (String)localObject2, "bindUrlKeyAndUniseq", ((StringBuilder)localObject3).toString());
      localMessageForPic.imageType = PicBusUtil.c(((PicUploadInfo)localObject1).n);
      paramPicFowardInfo = ((PicUploadInfo)localObject1).r;
      if ((paramPicFowardInfo != null) && (!paramPicFowardInfo.isEmpty()))
      {
        b((PicUploadInfo)localObject1, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
      localMessageForPic.serial();
      ((PicUploadInfo)localObject1).g = localMessageForPic.uniseq;
      paramPicFowardInfo = (ITransFileController)this.e.getRuntimeService(ITransFileController.class, "");
      if (paramPicFowardInfo != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localMessageForPic.frienduin);
        ((StringBuilder)localObject1).append(localMessageForPic.uniseq);
        paramPicFowardInfo.addProcessor(((StringBuilder)localObject1).toString(), new BaseTransProcessor((BaseTransFileController)paramPicFowardInfo));
      }
      a(localMessageForPic);
      paramPicFowardInfo = this.b;
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cost:");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
      Logger.a(paramPicFowardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
      paramPicFowardInfo = this.b;
      localObject1 = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retry:");
      ((StringBuilder)localObject2).append(bool);
      Logger.a(paramPicFowardInfo, (String)localObject1, "packForwardMsg", ((StringBuilder)localObject2).toString());
      return localMessageForPic;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.BaseForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */