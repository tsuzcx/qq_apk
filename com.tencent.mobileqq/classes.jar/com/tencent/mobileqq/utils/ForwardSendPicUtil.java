package com.tencent.mobileqq.utils;

import ajoa;
import android.content.Context;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.qphone.base.util.QLog;

public class ForwardSendPicUtil
{
  private static long a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (paramString1 != null)
    {
      paramString4 = new PicUploadInfo.Builder();
      paramString4.a(paramString1);
      paramString4.d(1009);
      paramString4.d(paramString2);
      paramString4.c(TranDbRecord.PicDbRecord.d);
      paramString4.e(paramString3);
      paramString4.c(paramQQAppInterface.getCurrentAccountUin());
      paramString4.e(paramInt);
      paramString2 = PicBusiManager.a(2, 1009);
      paramString2.a(paramString4.a());
      PicBusiManager.a(paramString2, paramQQAppInterface);
      ThreadManager.post(new ajoa(paramString1, paramInt, paramQQAppInterface), 5, null, false);
    }
    return 0L;
  }
  
  private static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str = ImageUtil.a(paramContext, paramString, paramInt);
    ImageInfo localImageInfo = new ImageInfo();
    if (paramBoolean) {}
    for (int i = 7;; i = 4)
    {
      ImageUtil.a(i, paramContext, paramString, str, true, localImageInfo, paramInt);
      return localImageInfo.b;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Context paramContext)
  {
    String str = "ForwardSendPicUtil.sendPicTo." + paramContext.getClass().getSimpleName();
    ImageUtil.a(-1L, paramInt, true, "image_send_prepare", str + ", isQzoneShare=" + paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage start!");
    }
    paramString1 = a(paramContext, paramString1, paramInt, paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage end!");
    }
    if (!FileUtils.b(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardSendPicUtil", 2, "sendPicTo,pic not exist,return false!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord start!");
    }
    a(paramQQAppInterface, paramString1, paramString2, paramString3, paramInt, str);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord end!");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ForwardSendPicUtil
 * JD-Core Version:    0.7.0.1
 */