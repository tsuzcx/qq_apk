package com.tencent.mobileqq.hotpic;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;

public class HotPicHelper
{
  public static void a(MessageRecord paramMessageRecord, TransferRequest paramTransferRequest)
  {
    if ((paramTransferRequest.e == 1042) || (paramTransferRequest.e == 5) || (paramTransferRequest.e == 1030)) {}
    try
    {
      long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("hot_pic_original_size")).longValue();
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("hot_pic_original_md5");
      if ((l > 0L) && (!paramMessageRecord.equals("")))
      {
        paramTransferRequest.p = true;
        paramTransferRequest.f = l;
        paramTransferRequest.n = paramMessageRecord;
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, String paramString1, long paramLong, String paramString2)
  {
    paramMessageRecord.saveExtInfoToExtStr("hot_pic_original_md5", paramString1);
    paramMessageRecord.saveExtInfoToExtStr("hot_pic_original_size", String.valueOf(paramLong));
    paramMessageRecord.saveExtInfoToExtStr("hot_pic_thumb_md5", paramString2);
  }
  
  public static void a(PicUploadInfo paramPicUploadInfo, Intent paramIntent, int paramInt)
  {
    if ((paramInt == 1042) && (paramIntent.hasExtra("HOT_PIC_TRANS_FILESIZE")) && (paramIntent.hasExtra("HOT_PIC_TRANS_MD5")))
    {
      paramPicUploadInfo.j = paramIntent.getStringExtra("HOT_PIC_TRANS_MD5");
      paramPicUploadInfo.d = paramIntent.getLongExtra("HOT_PIC_TRANS_FILESIZE", 0L);
      paramPicUploadInfo.k = paramIntent.getStringExtra("HOT_PIC_TRANS_THUMB_MD5");
      paramIntent.removeExtra("HOT_PIC_TRANS_MD5");
      paramIntent.removeExtra("HOT_PIC_TRANS_FILESIZE");
      paramIntent.removeExtra("HOT_PIC_TRANS_THUMB_MD5");
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (!paramMessageRecord.getExtInfoFromExtStr("hot_pic_thumb_md5").equals(""));
  }
  
  public static boolean a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean) {}
    PicUploadInfo localPicUploadInfo;
    do
    {
      return true;
      if ((paramMessageForPic == null) || (!a(paramMessageForPic))) {
        return paramBoolean;
      }
      if (!paramMessageForPic.isSendFromLocal()) {
        return paramBoolean;
      }
      localPicUploadInfo = paramMessageForPic.getPicUploadInfo();
      localPicUploadInfo.f = paramMessageForPic.getExtInfoFromExtStr("hot_pic_thumb_md5");
    } while (AbsDownloader.a(URLDrawableHelper.a(localPicUploadInfo, 65537, null).toString()) != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicHelper
 * JD-Core Version:    0.7.0.1
 */