package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import anud;
import aziw;
import azjq;
import azjx;
import azkc;
import azkd;
import azke;
import azkl;
import azkn;
import azlg;
import azlo;
import bhbx;
import bhca;
import blvp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class ChatImageDownloader
  extends AbstractImageDownloader
  implements ProtocolDownloaderConstants
{
  static final String TAG = "ChatImageDownloader";
  
  public ChatImageDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super("ChatImageDownloader", paramBaseApplicationImpl);
  }
  
  public ChatImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramString, paramBaseApplicationImpl);
  }
  
  private ChatImageDownloader.DownloadData getDownloadData(DownloadParams paramDownloadParams)
  {
    boolean bool = false;
    if (paramDownloadParams == null) {
      throw new FileDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }
    ChatImageDownloader.DownloadData localDownloadData = new ChatImageDownloader.DownloadData(this);
    localDownloadData.url = paramDownloadParams.url;
    azjq.a("PIC_TAG", "getDownloadData", "url:" + localDownloadData.url);
    localDownloadData.application = this.application;
    localDownloadData.startOffset = paramDownloadParams.downloaded;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof azkl)))
    {
      Object localObject = (azkl)paramDownloadParams.tag;
      if ((localObject instanceof MessageForPic))
      {
        localDownloadData.pic = ((MessageForPic)localObject);
        localDownloadData.netWorkType = azkc.a();
        localDownloadData.uinType = azkc.a(localDownloadData.app, localDownloadData.pic.istroop, localDownloadData.pic.frienduin);
      }
      localDownloadData.downInfo = ((azkl)localObject).getPicDownloadInfo();
      log(localDownloadData, "getDownloadData", "uuid:" + localDownloadData.downInfo.g + ",md5：" + localDownloadData.downInfo.f);
      localDownloadData.host = getHost(localDownloadData.downInfo.jdField_b_of_type_Int);
      paramDownloadParams = paramDownloadParams.url.getProtocol();
      if (localDownloadData.downInfo.jdField_e_of_type_Int == 1) {
        bool = true;
      }
      localDownloadData.fileSizeType = URLDrawableHelper.getFileSizeType(paramDownloadParams, bool);
      if (((azkl)localObject).isSendFromLocal())
      {
        localDownloadData.sendFromLoacal = true;
        localDownloadData.upInfo = ((azkl)localObject).getPicUploadInfo();
        localDownloadData.downInfo.jdField_a_of_type_Boolean = true;
        if (localDownloadData.fileSizeType != 65537) {
          break label461;
        }
        if (localDownloadData.upInfo.c != TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO) {
          break label427;
        }
        localObject = ((PicFowardDbRecordData)localDownloadData.upInfo.jdField_a_of_type_JavaLangObject).fowardThumbPath;
        if (localObject != null)
        {
          paramDownloadParams = (DownloadParams)localObject;
          if (!"".equals(localObject)) {}
        }
        else
        {
          paramDownloadParams = getThumbPath(localDownloadData, (String)localObject);
        }
      }
      label427:
      label461:
      for (localDownloadData.sendPath = paramDownloadParams;; localDownloadData.sendPath = localDownloadData.upInfo.g)
      {
        log(localDownloadData, "getDownloadData", "path:" + localDownloadData.upInfo.g + ",sendPath：" + localDownloadData.sendPath);
        return localDownloadData;
        if (localDownloadData.pic.isQzonePic)
        {
          paramDownloadParams = localDownloadData.upInfo.h;
          break;
        }
        paramDownloadParams = getThumbPath(localDownloadData, null);
        break;
      }
    }
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof String)))
    {
      localDownloadData.sendPath = ((String)paramDownloadParams.tag);
      return localDownloadData;
    }
    if (paramDownloadParams.tag == null) {
      log(localDownloadData, "getDownloadData", "config.tag error,config.tag==null");
    }
    for (;;)
    {
      throw new FileDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
      log(localDownloadData, "getDownloadData", "config.tag error,config.tag:" + paramDownloadParams.tag);
    }
  }
  
  static String getHost(int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default: 
      str = "C2C";
    case 6000: 
      return str;
    case 1: 
      return "Troup";
    case 3000: 
      return "Disscussion";
    }
    return "C2C";
  }
  
  private String getThumbPath(ChatImageDownloader.DownloadData paramDownloadData, String paramString)
  {
    if (FileUtils.fileExists(paramString)) {}
    while (!FileUtils.fileExists(paramDownloadData.upInfo.g)) {
      return paramString;
    }
    paramString = new CompressInfo(paramDownloadData.upInfo.g, 0);
    paramString.jdField_a_of_type_JavaLangString = paramDownloadData.upInfo.jdField_a_of_type_JavaLangString;
    azlg.b(paramString);
    return paramString.jdField_e_of_type_JavaLangString;
  }
  
  private boolean limitSizeByServer(DownloadParams paramDownloadParams)
  {
    if (!(paramDownloadParams.tag instanceof MessageForPic)) {
      return false;
    }
    paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
    if ((paramDownloadParams.thumbWidthHeightDP != null) && (paramDownloadParams.thumbWidthHeightDP.mLimitSizeByServer)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void log(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof ChatImageDownloader.DownloadData)) {
      if (QLog.isColorLevel())
      {
        paramObject = (ChatImageDownloader.DownloadData)paramObject;
        if (paramObject.upInfo == null) {
          break label58;
        }
        i = RichMediaUtil.getFileType(paramObject.fileSizeType);
        RichMediaUtil.logdLogic(paramObject.upInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.upInfo.jdField_a_of_type_Long), paramString1, paramString2);
      }
    }
    label58:
    while (!QLog.isColorLevel())
    {
      do
      {
        int i;
        return;
        if (paramObject.downInfo != null)
        {
          i = RichMediaUtil.getFileType(paramObject.fileSizeType);
          RichMediaUtil.logdLogic(paramObject.downInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.downInfo.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
      return;
    }
    QLog.d("ChatImageDownloader", 2, "step:" + paramString1 + ",content: " + paramString2);
  }
  
  public static void reportClientExist(MessageRecord paramMessageRecord)
  {
    for (int i = 0;; i = 1) {
      try
      {
        String str1 = getHost(paramMessageRecord.istroop);
        Object localObject = new TranDbRecord.PicDbRecord();
        ((TranDbRecord.PicDbRecord)localObject).initFromMsg(paramMessageRecord.msg);
        if (((TranDbRecord.PicDbRecord)localObject).type == 1)
        {
          String str2 = ((TranDbRecord.PicDbRecord)localObject).uuid;
          localObject = ((TranDbRecord.PicDbRecord)localObject).md5;
          if ((bhca.a(paramMessageRecord.msgtype)) || (paramMessageRecord.msgtype == -3001) || (paramMessageRecord.msgtype == -30002) || (paramMessageRecord.msgtype == -30003)) {
            continue;
          }
          if (i == 0)
          {
            localURL = URLDrawableHelper.getURL((MessageForPic)paramMessageRecord, 65537, null);
            if (getFile(localURL.toString()) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatImageDownloader", 2, "reportClientExist thumbURL:" + localURL);
              }
              reportClientExist(paramMessageRecord, str1, str2, (String)localObject, true);
            }
          }
          URL localURL = URLDrawableHelper.getURL((MessageForPic)paramMessageRecord, 65537, null);
          if (getFile(localURL.toString()) != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatImageDownloader", 2, "reportClientExist bigURL:" + localURL);
            }
            reportClientExist(paramMessageRecord, str1, str2, (String)localObject, false);
          }
        }
        return;
      }
      catch (Exception paramMessageRecord)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("reportClientExist", 2, "error", paramMessageRecord);
        return;
      }
    }
  }
  
  private static void reportClientExist(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject1 = null;
    boolean bool1 = paramString1.equals("C2C");
    boolean bool2 = paramString1.equals("Troup");
    boolean bool3 = paramString1.equals("Disscussion");
    if (bool1) {
      if (paramBoolean)
      {
        paramString1 = "dim.buddy_thumbpic_down";
        if (!paramBoolean) {
          break label105;
        }
        localObject1 = "actC2CPicSmallDownV1";
      }
    }
    for (;;)
    {
      paramString1 = new AbstractImageDownloader.ReportData(paramMessageRecord.frienduin, paramString1, (String)localObject1, null, null, paramString2, 0L, paramString3);
      paramString1.clientExist = true;
      paramString1.msgTime = paramMessageRecord.time;
      reportResult(paramString1, true, (int)0L, 0, "", null, null, null);
      return;
      paramString1 = "dim.buddy_pic_down";
      break;
      label105:
      localObject1 = "actC2CPicDownloadV1";
      continue;
      if (bool2)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.group_thumbpic_down";
          label127:
          if (!paramBoolean) {
            break label147;
          }
        }
        label147:
        for (localObject1 = "actGroupPicSmallDownV1";; localObject1 = "actGroupPicDownloadV1")
        {
          break;
          paramString1 = "dim.group_pic_down";
          break label127;
        }
      }
      if (bool3)
      {
        if (paramBoolean)
        {
          paramString1 = "dim.discuss_thumbpic_down";
          label169:
          if (!paramBoolean) {
            break label189;
          }
        }
        label189:
        for (localObject1 = "actDiscussPicSmallDown";; localObject1 = "actDiscussPicDown")
        {
          break;
          paramString1 = "dim.discuss_pic_down";
          break label169;
        }
      }
      Object localObject2 = null;
      paramString1 = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  protected boolean decodeByAIOPicThumb(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "chatthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  protected boolean decodeByGif(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject = paramDownloadParams.tag;
    if (((localObject instanceof MessageForPic)) && (anud.a((MessageForPic)localObject))) {
      return false;
    }
    return super.decodeByGif(paramFile, paramDownloadParams, paramURLDrawableHandler);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = SystemClock.uptimeMillis();
    if ((paramDownloadParams.urlStr != null) && (paramDownloadParams.urlStr.startsWith("chatimg"))) {}
    for (int i = 1;; i = 0)
    {
      paramDownloadParams = getDownloadData(paramDownloadParams);
      paramDownloadParams.out = paramOutputStream;
      paramDownloadParams.handler = paramURLDrawableHandler;
      if ((paramDownloadParams.upInfo == null) || (paramDownloadParams.sendPath == null)) {
        break;
      }
      paramOutputStream = new File(paramDownloadParams.sendPath);
      if (!paramOutputStream.exists()) {
        break;
      }
      log(paramDownloadParams, "result", "success file(send) exist, copy file from:" + paramDownloadParams.sendPath);
      copyFromFile(paramDownloadParams.out, paramOutputStream, paramDownloadParams.handler);
      return null;
    }
    paramURLDrawableHandler.publishProgress(0);
    if (paramDownloadParams.downInfo == null)
    {
      log(paramDownloadParams, "result", "param error,params.downInfo == null,sendpath:" + paramDownloadParams.sendPath);
      throw new FileDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      log(paramDownloadParams, "result", "failed could not call object.wait in Main thread ,sendpath:" + paramDownloadParams.sendPath + ",uniseq:" + paramDownloadParams.downInfo.jdField_a_of_type_Long);
      throw new FileDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    if ((bhbx.a()) && (bhbx.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bhbx.b());
    }
    TransferResult localTransferResult = stepDownload(paramDownloadParams);
    int j;
    if (localTransferResult.mResult == 0)
    {
      j = 1;
      if (j == 0) {
        break label374;
      }
    }
    label374:
    for (paramOutputStream = "successed";; paramOutputStream = "failed " + localTransferResult.mErrDesc)
    {
      log(paramDownloadParams, "result", paramOutputStream);
      if (j != 0) {
        break label482;
      }
      paramOutputStream = PicDownloadExplicitError.getPicError(localTransferResult);
      if (paramOutputStream == null) {
        break label402;
      }
      throw paramOutputStream;
      j = 0;
      break;
    }
    label402:
    if (localTransferResult.mErrCode == 9037L) {
      paramURLDrawableHandler.doCancel();
    }
    label482:
    while (i == 0)
    {
      return null;
      if ((localTransferResult.mErrCode == -9527L) && ("H_404_-124".equals(localTransferResult.mErrDesc)))
      {
        log(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
        return null;
      }
      throw new FileDownloadFailedException((int)localTransferResult.mErrCode, 0L, localTransferResult.mErrDesc, false, false);
    }
    if (paramDownloadParams.app != null) {}
    for (paramOutputStream = paramDownloadParams.app.getCurrentAccountUin();; paramOutputStream = null)
    {
      azkd.a(paramOutputStream, paramDownloadParams.uinType, paramDownloadParams.netWorkType, SystemClock.uptimeMillis() - l);
      break;
    }
  }
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    float f1;
    int j;
    int i;
    int m;
    int k;
    int i6;
    int i7;
    int i5;
    int i4;
    int i3;
    int i2;
    label344:
    int i1;
    int n;
    try
    {
      f1 = this.application.getResources().getDisplayMetrics().density;
      i8 = this.application.getResources().getDisplayMetrics().densityDpi;
      f3 = 12.0F * f1;
      boolean bool = blvp.a(paramDownloadParams.mImgType);
      j = CommonImgThumbHelper.getImgThumbMinPx(bool);
      i = CommonImgThumbHelper.getImgThumbMinPx(bool);
      m = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      k = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject = (MessageForPic)paramDownloadParams.tag;
        j = AIOUtils.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinWidth, this.application.getResources());
        i = AIOUtils.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMinHeight, this.application.getResources());
        m = AIOUtils.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxWidth, this.application.getResources());
        k = AIOUtils.dp2px(((MessageForPic)localObject).getThumbWidthHeightDP(bool).mMaxHeight, this.application.getResources());
      }
      i6 = paramBitmap.getWidth();
      i7 = paramBitmap.getHeight();
      localObject = new Paint(1);
      ((Paint)localObject).setColor(-16777216);
      i5 = CommonImgThumbHelper.getImgThumbMinDp(bool);
      i4 = CommonImgThumbHelper.getImgThumbMinDp(bool);
      i3 = CommonImgThumbHelper.getImgThumbMaxDp(bool);
      i2 = CommonImgThumbHelper.getImgThumbMaxDp(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label636;
      }
      MessageForPic localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      i5 = localMessageForPic.getThumbWidthHeightDP(bool).mMinWidth;
      i4 = localMessageForPic.getThumbWidthHeightDP(bool).mMinHeight;
      i3 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxWidth;
      i2 = localMessageForPic.getThumbWidthHeightDP(bool).mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      int i8;
      float f3;
      Object localObject;
      label387:
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
    if (limitSizeByServer(paramDownloadParams))
    {
      return new RoundRectBitmap(azlo.a(paramBitmap, ((MessageForPic)paramDownloadParams.tag).thumbWidthHeightDP), f3);
      if (i1 < n)
      {
        m = (int)(j / i1 * n + 0.5F);
        i = m;
        if (m <= k) {
          break label723;
        }
        i = k;
        break label723;
      }
    }
    label563:
    label723:
    for (;;)
    {
      paramDownloadParams = Bitmap.createBitmap(j, i, paramBitmap.getConfig());
      paramDownloadParams.setDensity(i8);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, i1, n), new Rect(0, 0, j, i), (Paint)localObject);
      paramDownloadParams = new RoundRectBitmap(paramDownloadParams, f3);
      return paramDownloadParams;
      k = (int)(i / n * i1 + 0.5F);
      j = k;
      if (k > m) {
        j = m;
      }
      continue;
      label624:
      label636:
      do
      {
        if ((i1 < i3) && (n < i2))
        {
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(n * f1 + 0.5F);
          break label387;
        }
        if (i1 > n)
        {
          f1 = m / i1;
          if (i1 <= n) {
            break label624;
          }
        }
        for (float f2 = i / n;; f2 = j / i1)
        {
          f1 = Math.max(f1, f2);
          j = (int)(i1 * f1 + 0.5F);
          i = (int)(f1 * n + 0.5F);
          break;
          f1 = k / n;
          break label563;
        }
        if (i6 > i7 * 3.0F)
        {
          i1 = (int)(i7 * 3.0F);
          n = i7;
          break;
        }
        n = i7;
        i1 = i6;
        if (i7 <= i6 * 3.0F) {
          break;
        }
        n = (int)(i6 * 3.0F);
        i1 = i6;
        break;
        if (i1 < i5) {
          break label344;
        }
      } while (n >= i4);
      break label344;
    }
  }
  
  TransferResult stepDownload(ChatImageDownloader.DownloadData paramDownloadData)
  {
    if (paramDownloadData.app == null) {}
    try
    {
      paramDownloadData.app = ((QQAppInterface)paramDownloadData.application.getAppRuntime(paramDownloadData.downInfo.jdField_b_of_type_JavaLangString));
      label28:
      if (paramDownloadData.app == null)
      {
        log(paramDownloadData, "stepDownload", "params.app == null ,selfuin:" + paramDownloadData.downInfo.jdField_b_of_type_JavaLangString);
        throw new FileDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + paramDownloadData.downInfo.jdField_b_of_type_JavaLangString, false, false);
      }
      aziw localaziw = new aziw(paramDownloadData.app);
      localaziw.jdField_a_of_type_Azke = new azke();
      localaziw.jdField_a_of_type_Azke.a = paramDownloadData.pic;
      localaziw.jdField_b_of_type_JavaLangString = "PIC_TAG";
      localaziw.jdField_a_of_type_JavaLangString = paramDownloadData.logId;
      paramDownloadData.downInfo.jdField_e_of_type_JavaLangString = paramDownloadData.url.getProtocol();
      if (paramDownloadData.pic != null)
      {
        paramDownloadData.downInfo.d = paramDownloadData.pic.bEnableEnc;
        paramDownloadData.downInfo.c = paramDownloadData.pic.time;
      }
      azjq.a("PIC_TAG", paramDownloadData.logId, "stepDownload", "url:" + paramDownloadData.url + ",info:" + paramDownloadData.downInfo);
      return localaziw.a(paramDownloadData.downInfo, paramDownloadData.handler, paramDownloadData.url.getProtocol());
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      break label28;
    }
  }
  
  public boolean supportBreakpointContinuingly()
  {
    return true;
  }
  
  public boolean useDiskCache()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader
 * JD-Core Version:    0.7.0.1
 */