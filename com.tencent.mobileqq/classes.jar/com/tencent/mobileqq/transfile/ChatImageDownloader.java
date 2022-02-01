package com.tencent.mobileqq.transfile;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.operator.AbstractPicOperator;
import com.tencent.mobileqq.pic.operator.DownloadPicOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.bitmapcreator.CustomBitmap;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class ChatImageDownloader
  extends BaseImageDownloader
  implements ProtocolDownloaderConstants
{
  static final String TAG = "ChatImageDownloader";
  protected BaseApplication application;
  
  public ChatImageDownloader(BaseApplication paramBaseApplication)
  {
    this.application = paramBaseApplication;
  }
  
  public static void generateReason(HashMap<String, String> paramHashMap, int paramInt, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepTransInfo paramStepTransInfo, boolean paramBoolean, FileMsg.StepBaseInfo paramStepBaseInfo2)
  {
    if (!ProcessorReport.adjustErrorCode(paramInt, paramHashMap))
    {
      paramHashMap.put("param_FailCode", Integer.toString(paramInt));
      if ((paramInt != -9527) && (paramInt != 9311) && (paramInt != 9044) && (paramInt != 9350) && (paramInt != 9351)) {
        paramHashMap.put("param_errorDesc", paramString);
      } else {
        paramHashMap.put("param_reason", paramString);
      }
    }
    else
    {
      paramHashMap.put("param_errorDesc", paramString);
    }
    if ((paramBoolean) && (paramStepBaseInfo2 == null) && (paramStepBaseInfo1 == null) && (paramStepTransInfo == null))
    {
      paramString = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
    }
    else if ((paramStepBaseInfo2 != null) && (paramStepBaseInfo1 != null) && (paramStepTransInfo != null))
    {
      paramString = new StringBuilder();
      paramString.append(paramStepBaseInfo2.getStepReportInfo(1));
      paramString.append(";");
      paramString.append(paramStepBaseInfo1.getStepReportInfo(2));
      paramString.append(";");
      paramString.append(paramStepTransInfo.getStepReportInfo(3));
      paramString = paramString.toString();
    }
    else
    {
      paramString = "";
    }
    if (QLog.isColorLevel())
    {
      paramStepBaseInfo1 = new StringBuilder();
      paramStepBaseInfo1.append("parmStep: ");
      paramStepBaseInfo1.append(paramString);
      QLog.d("reportResult", 2, paramStepBaseInfo1.toString());
    }
    paramHashMap.put("param_step", paramString);
  }
  
  private ChatImageDownloader.DownloadData getDownloadData(DownloadParams paramDownloadParams)
  {
    if (paramDownloadParams != null)
    {
      ChatImageDownloader.DownloadData localDownloadData = new ChatImageDownloader.DownloadData(this);
      localDownloadData.url = paramDownloadParams.url;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url:");
      ((StringBuilder)localObject).append(localDownloadData.url);
      Logger.a("PIC_TAG", "getDownloadData", ((StringBuilder)localObject).toString());
      localDownloadData.application = this.application;
      localDownloadData.startOffset = paramDownloadParams.downloaded;
      if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof PicUiInterface)))
      {
        localObject = (PicUiInterface)paramDownloadParams.tag;
        if ((localObject instanceof MessageForPic))
        {
          localDownloadData.pic = ((MessageForPic)localObject);
          localDownloadData.netWorkType = PicPreDownloadUtils.a();
          localDownloadData.uinType = PicPreDownloadUtils.a(localDownloadData.app, localDownloadData.pic.istroop, localDownloadData.pic.frienduin);
        }
        localDownloadData.downInfo = ((PicUiInterface)localObject).getPicDownloadInfo();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uuid:");
        localStringBuilder.append(localDownloadData.downInfo.g);
        localStringBuilder.append(",md5：");
        localStringBuilder.append(localDownloadData.downInfo.f);
        log(localDownloadData, "getDownloadData", localStringBuilder.toString());
        localDownloadData.host = getHost(localDownloadData.downInfo.jdField_b_of_type_Int);
        paramDownloadParams = paramDownloadParams.url.getProtocol();
        boolean bool;
        if (localDownloadData.downInfo.jdField_e_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localDownloadData.fileSizeType = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType(paramDownloadParams, bool);
        if (((PicUiInterface)localObject).isSendFromLocal())
        {
          localDownloadData.sendFromLoacal = true;
          localDownloadData.upInfo = ((PicUiInterface)localObject).getPicUploadInfo();
          localDownloadData.downInfo.jdField_a_of_type_Boolean = true;
          if (localDownloadData.fileSizeType == 65537)
          {
            if (localDownloadData.upInfo.c == 10)
            {
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
            else if (localDownloadData.pic.isQzonePic)
            {
              paramDownloadParams = localDownloadData.upInfo.h;
            }
            else
            {
              paramDownloadParams = getThumbPath(localDownloadData, null);
            }
            localDownloadData.sendPath = paramDownloadParams;
          }
          else
          {
            localDownloadData.sendPath = localDownloadData.upInfo.g;
          }
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("path:");
          paramDownloadParams.append(localDownloadData.upInfo.g);
          paramDownloadParams.append(",sendPath：");
          paramDownloadParams.append(localDownloadData.sendPath);
          log(localDownloadData, "getDownloadData", paramDownloadParams.toString());
          return localDownloadData;
        }
      }
      else
      {
        if ((paramDownloadParams.tag == null) || (!(paramDownloadParams.tag instanceof String))) {
          break label539;
        }
        localDownloadData.sendPath = ((String)paramDownloadParams.tag);
      }
      return localDownloadData;
      label539:
      if (paramDownloadParams.tag == null)
      {
        log(localDownloadData, "getDownloadData", "config.tag error,config.tag==null");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("config.tag error,config.tag:");
        ((StringBuilder)localObject).append(paramDownloadParams.tag);
        log(localDownloadData, "getDownloadData", ((StringBuilder)localObject).toString());
      }
      throw new ChatPicDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
    }
    throw new ChatPicDownloadFailedException(9302, 0L, "holy,config == null", false, false);
  }
  
  static String getHost(int paramInt)
  {
    String str2 = "C2C";
    String str1 = str2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        str1 = str2;
        if (paramInt != 1000)
        {
          str1 = str2;
          if (paramInt != 1001)
          {
            str1 = str2;
            if (paramInt != 1004)
            {
              str1 = str2;
              if (paramInt != 1005)
              {
                str1 = str2;
                if (paramInt != 1008)
                {
                  str1 = str2;
                  if (paramInt != 1009)
                  {
                    str1 = str2;
                    if (paramInt != 1020) {
                      if (paramInt != 3000)
                      {
                        if (paramInt != 6000)
                        {
                          str1 = str2;
                          if (paramInt != 10002)
                          {
                            str1 = str2;
                            if (paramInt != 10004)
                            {
                              str1 = str2;
                              if (paramInt != 10008)
                              {
                                str1 = str2;
                                if (paramInt != 10010)
                                {
                                  str1 = str2;
                                  if (paramInt != 1023) {
                                    return "C2C";
                                  }
                                }
                              }
                            }
                          }
                        }
                        else
                        {
                          return "";
                        }
                      }
                      else {
                        return "Disscussion";
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      else
      {
        str1 = "Troup";
      }
    }
    return str1;
  }
  
  private String getThumbPath(ChatImageDownloader.DownloadData paramDownloadData, String paramString)
  {
    if (FileUtils.fileExists(paramString)) {
      return paramString;
    }
    if (FileUtils.fileExists(paramDownloadData.upInfo.g))
    {
      paramString = new CompressInfo(paramDownloadData.upInfo.g, 0);
      paramString.jdField_a_of_type_JavaLangString = paramDownloadData.upInfo.jdField_a_of_type_JavaLangString;
      ((ICompressOperator)QRoute.api(ICompressOperator.class)).startThumbnail(paramString);
      paramString = paramString.jdField_e_of_type_JavaLangString;
    }
    return paramString;
  }
  
  private boolean limitSizeByServer(DownloadParams paramDownloadParams)
  {
    boolean bool1 = paramDownloadParams.tag instanceof MessageForPic;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
    bool1 = bool2;
    if (paramDownloadParams.thumbWidthHeightDP != null)
    {
      bool1 = bool2;
      if (paramDownloadParams.thumbWidthHeightDP.mLimitSizeByServer) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void log(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof ChatImageDownloader.DownloadData))
    {
      if (QLog.isColorLevel())
      {
        paramObject = (ChatImageDownloader.DownloadData)paramObject;
        int i;
        if (paramObject.upInfo != null)
        {
          i = RichMediaUtil.getFileType(paramObject.fileSizeType);
          RichMediaUtil.logdLogic(paramObject.upInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.upInfo.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
        if (paramObject.downInfo != null)
        {
          i = RichMediaUtil.getFileType(paramObject.fileSizeType);
          RichMediaUtil.logdLogic(paramObject.downInfo.jdField_b_of_type_Int, false, i, String.valueOf(paramObject.downInfo.jdField_a_of_type_Long), paramString1, paramString2);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("step:");
          paramObject.append(paramString1);
          paramObject.append(",content: ");
          paramObject.append(paramString2);
          QLog.d("ChatImageDownloader", 2, paramObject.toString());
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("step:");
      paramObject.append(paramString1);
      paramObject.append(",content: ");
      paramObject.append(paramString2);
      QLog.d("ChatImageDownloader", 2, paramObject.toString());
    }
  }
  
  public static void reportBigPicDownCost(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uintype:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",networktype:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",timeCost:");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("ChatImageDownloader", "reportBigPicDownCost", ((StringBuilder)localObject).toString());
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramLong < 0L) {
        return;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_uintype", String.valueOf(paramInt1));
      ((HashMap)localObject).put("param_networktype", String.valueOf(paramInt2));
      ((HashMap)localObject).put("param_timecost", String.valueOf(paramLong));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString, "actBigPicDownCost", false, 0L, 0L, (HashMap)localObject, "");
    }
  }
  
  public static void reportClientExist(MessageRecord paramMessageRecord)
  {
    try
    {
      String str1 = getHost(paramMessageRecord.istroop);
      Object localObject = new TranDbRecord.PicDbRecord();
      ((TranDbRecord.PicDbRecord)localObject).initFromMsg(paramMessageRecord.msg);
      if (((TranDbRecord.PicDbRecord)localObject).type == 1)
      {
        String str2 = ((TranDbRecord.PicDbRecord)localObject).uuid;
        localObject = ((TranDbRecord.PicDbRecord)localObject).md5;
        if ((!ActionMsgUtil.a(paramMessageRecord.msgtype)) && (paramMessageRecord.msgtype != -3001) && (paramMessageRecord.msgtype != -30002))
        {
          i = paramMessageRecord.msgtype;
          if (i != -30003)
          {
            i = 0;
            break label100;
          }
        }
        int i = 1;
        label100:
        StringBuilder localStringBuilder;
        if (i == 0)
        {
          localURL = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((MessageForPic)paramMessageRecord, 65537, null);
          if (getFile(localURL.toString()) != null)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("reportClientExist thumbURL:");
              localStringBuilder.append(localURL);
              QLog.d("ChatImageDownloader", 2, localStringBuilder.toString());
            }
            reportClientExist(paramMessageRecord, str1, str2, (String)localObject, true);
          }
        }
        URL localURL = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL((MessageForPic)paramMessageRecord, 65537, null);
        if (getFile(localURL.toString()) != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("reportClientExist bigURL:");
            localStringBuilder.append(localURL);
            QLog.d("ChatImageDownloader", 2, localStringBuilder.toString());
          }
          reportClientExist(paramMessageRecord, str1, str2, (String)localObject, false);
          return;
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.d("reportClientExist", 2, "error", paramMessageRecord);
      }
    }
  }
  
  private static void reportClientExist(MessageRecord paramMessageRecord, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    boolean bool1 = paramString1.equals("C2C");
    boolean bool2 = paramString1.equals("Troup");
    boolean bool3 = paramString1.equals("Disscussion");
    if (bool1)
    {
      if (paramBoolean) {
        paramString1 = "dim.buddy_thumbpic_down";
      } else {
        paramString1 = "dim.buddy_pic_down";
      }
      str1 = paramString1;
      if (paramBoolean) {
        paramString1 = "actC2CPicSmallDownV1";
      } else {
        paramString1 = "actC2CPicDownloadV1";
      }
    }
    for (;;)
    {
      str2 = paramString1;
      break label167;
      if (bool2)
      {
        if (paramBoolean) {
          paramString1 = "dim.group_thumbpic_down";
        } else {
          paramString1 = "dim.group_pic_down";
        }
        str1 = paramString1;
        if (paramBoolean) {
          paramString1 = "actGroupPicSmallDownV1";
        } else {
          paramString1 = "actGroupPicDownloadV1";
        }
      }
      else
      {
        if (!bool3) {
          break;
        }
        if (paramBoolean) {
          paramString1 = "dim.discuss_thumbpic_down";
        } else {
          paramString1 = "dim.discuss_pic_down";
        }
        str1 = paramString1;
        if (paramBoolean) {
          paramString1 = "actDiscussPicSmallDown";
        } else {
          paramString1 = "actDiscussPicDown";
        }
      }
    }
    paramString1 = null;
    String str2 = paramString1;
    String str1 = paramString1;
    label167:
    paramString1 = new ChatImageDownloader.ReportData(paramMessageRecord.frienduin, str1, str2, null, null, paramString2, 0L, paramString3);
    paramString1.clientExist = true;
    paramString1.msgTime = paramMessageRecord.time;
    reportResult(paramString1, true, (int)0L, 0, "", null, null, null);
  }
  
  public static void reportResult(ChatImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l2 = 0L;
    long l1;
    if (paramStepTransInfo != null) {
      l1 = paramStepTransInfo.flowDown;
    } else {
      l1 = 0L;
    }
    if (paramStepTransInfo != null) {
      l2 = paramStepTransInfo.contentSize;
    }
    if (RichMediaStrategy.noReportByErrorCode(paramInt2)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    generateReason(localHashMap, paramInt2, paramString, paramStepBaseInfo2, paramStepTransInfo, paramBoolean, paramStepBaseInfo1);
    localHashMap.put("param_uuid", paramReportData.uuid);
    localHashMap.put("flow", String.valueOf(l1));
    localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.msgTime * 1000L)));
    localHashMap.put("client_exist", String.valueOf(paramReportData.clientExist));
    if (paramStepBaseInfo2 != null) {
      localHashMap.put("param_RequestUrl", paramStepBaseInfo2.toReportJson());
    }
    if (paramStepTransInfo != null) {
      localHashMap.put("param_HttpTran", paramStepTransInfo.toReportJson());
    }
    if (paramStepTransInfo != null)
    {
      localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.retryCount));
      if (paramStepTransInfo.result)
      {
        localHashMap.put("serverip", paramStepTransInfo.firstIp);
        localHashMap.put("param_Server", paramStepTransInfo.firstIp);
      }
      else
      {
        localHashMap.put("serverip", paramStepTransInfo.lastUseIp);
        localHashMap.put("param_Server", paramStepTransInfo.lastUseIp);
        if (paramInt2 == -9527) {
          localHashMap.put("param_rspHeader", paramStepTransInfo.respHeader);
        }
      }
    }
    if (paramBoolean)
    {
      if ((!paramReportData.multiMediaEvtTag.equals("actC2CPicDownloadV1")) && (!paramReportData.multiMediaEvtTag.equals("actC2CPicSmallDownV1"))) {
        localHashMap.put("param_grpUin", paramReportData.peerUin);
      } else {
        localHashMap.put("param_toUin", paramReportData.peerUin);
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramReportData.multiMediaEvtTag, true, paramInt1, l1, localHashMap, "");
      return;
    }
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.msgDate != null) && (!paramReportData.msgDate.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.msgDate);
    }
    if ((!paramReportData.multiMediaEvtTag.equals("actC2CPicDownloadV1")) && (!paramReportData.multiMediaEvtTag.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_grpUin", paramReportData.peerUin);
      localHashMap.put("param_url", paramReportData.srvUrl);
      paramString = new StringBuilder();
      paramString.append(l1);
      paramString.append("");
      localHashMap.put("param_fsized", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(l2);
      paramString.append("");
      localHashMap.put("param_fsizeo", paramString.toString());
    }
    else
    {
      localHashMap.put("param_toUin", paramReportData.peerUin);
      localHashMap.put("param_url", paramReportData.srvUrl);
      paramString = new StringBuilder();
      paramString.append(l1);
      paramString.append("");
      localHashMap.put("param_fsized", paramString.toString());
      paramString = new StringBuilder();
      paramString.append(l2);
      paramString.append("");
      localHashMap.put("param_fsizeo", paramString.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramReportData.multiMediaEvtTag, false, 0L, 0L, localHashMap, "");
  }
  
  public Object decodeAioPicThumb(File paramFile, DownloadParams paramDownloadParams, BitmapFactory.Options paramOptions)
  {
    String str = paramDownloadParams.urlStr;
    Object localObject1 = paramFile;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject4 = paramFile.getAbsolutePath();
        localObject1 = paramFile;
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        bool1 = false;
        localObject1 = paramFile;
        paramOptions.inJustDecodeBounds = false;
        localObject1 = paramFile;
        localObject2 = paramFile.getName();
        localObject1 = paramFile;
        bool2 = ((String)localObject2).endsWith("_hd");
        if (!bool2)
        {
          localObject1 = paramFile;
          localObject2 = new StringBuilder();
          localObject1 = paramFile;
          ((StringBuilder)localObject2).append((String)localObject4);
          localObject1 = paramFile;
          ((StringBuilder)localObject2).append("_hd");
          localObject1 = paramFile;
          localObject2 = new File(((StringBuilder)localObject2).toString());
          localObject1 = paramFile;
          bool2 = ((File)localObject2).exists();
          if (!bool2) {
            break label1152;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              paramFile = new StringBuilder();
              paramFile.append("DecodeFile hd thumb instead,cacheFile=");
              paramFile.append(((File)localObject2).getAbsolutePath());
              paramFile.append(", url=");
              paramFile.append(str);
              log(paramDownloadParams, "DecodeFile", paramFile.toString());
            }
            paramFile = (File)localObject2;
            localObject1 = localObject4;
          }
          catch (OutOfMemoryError paramFile)
          {
            continue;
          }
        }
        localObject1 = paramFile;
        if (((String)localObject2).length() <= 3) {
          break label1152;
        }
        localObject1 = paramFile;
        if (QLog.isColorLevel())
        {
          localObject1 = paramFile;
          localObject2 = new StringBuilder();
          localObject1 = paramFile;
          ((StringBuilder)localObject2).append("DecodeFile hd ,hdPath=");
          localObject1 = paramFile;
          ((StringBuilder)localObject2).append((String)localObject4);
          localObject1 = paramFile;
          log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject2).toString());
        }
        localObject1 = paramFile;
        localObject2 = ((String)localObject4).substring(0, ((String)localObject4).length() - 3);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError paramFile)
      {
        boolean bool1;
        boolean bool2;
        Object localObject3;
        Object localObject5;
        localObject2 = localObject1;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("step:create roundBitmap, ");
        ((StringBuilder)localObject1).append(paramFile.getMessage());
        logDecodeFile(paramDownloadParams, (File)localObject2, str, paramOptions, 1, false, ((StringBuilder)localObject1).toString());
        throw paramFile;
      }
      localObject1 = paramFile;
      localObject2 = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
      localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = localObject2;
        if (i != 0)
        {
          localObject1 = paramFile;
          bool2 = FileUtils.fileExists((String)localObject4);
          if (bool2)
          {
            localObject1 = paramFile;
            localObject3 = SafeBitmapFactory.decodeFile((String)localObject4, paramOptions);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject1 = paramFile;
              localObject5 = MD5Utils.encodeFileHexStr((String)localObject4);
              localObject1 = paramFile;
              FileUtils.deleteFile((String)localObject4);
              localObject2 = localObject3;
              localObject1 = paramFile;
              if (QLog.isColorLevel())
              {
                localObject1 = paramFile;
                localObject2 = new StringBuilder();
                localObject1 = paramFile;
                ((StringBuilder)localObject2).append("delete err thumb md5=");
                localObject1 = paramFile;
                ((StringBuilder)localObject2).append((String)localObject5);
                localObject1 = paramFile;
                log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject2).toString());
                localObject2 = localObject3;
              }
            }
          }
          localObject3 = localObject2;
          localObject1 = paramFile;
          if (QLog.isColorLevel())
          {
            localObject1 = paramFile;
            localObject3 = new StringBuilder();
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append("decode hd failed, try decode thumb ");
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append((String)localObject4);
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append(" exist=");
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append(bool2);
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append(" result=");
            if (localObject2 != null) {
              bool1 = true;
            }
            localObject1 = paramFile;
            ((StringBuilder)localObject3).append(bool1);
            localObject1 = paramFile;
            log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject3).toString());
            localObject3 = localObject2;
          }
        }
      }
      if (localObject3 != null)
      {
        if (i != 0)
        {
          localObject1 = paramFile;
          FileUtils.deleteFile((String)localObject4);
        }
        localObject2 = localObject3;
        localObject1 = paramFile;
        if (paramDownloadParams.mDecodeHandler != null)
        {
          localObject1 = paramFile;
          localObject2 = paramDownloadParams.mDecodeHandler.run(paramDownloadParams, (Bitmap)localObject3);
        }
        localObject1 = paramFile;
        if (paramDownloadParams.tag != null)
        {
          localObject1 = paramFile;
          if ((paramDownloadParams.tag instanceof MessageForPic))
          {
            localObject1 = paramFile;
            if (((MessageForPic)paramDownloadParams.tag).subMsgType == 2) {
              break;
            }
            localObject1 = paramFile;
            if (str.endsWith("?noRound")) {
              return localObject2;
            }
          }
          localObject1 = paramFile;
          if ((paramDownloadParams.tag instanceof CustomBitmap))
          {
            localObject1 = paramFile;
            return ((CustomBitmap)paramDownloadParams.tag).createBitmap((Bitmap)localObject2);
          }
        }
        localObject1 = paramFile;
        localObject3 = resizeAndClipBitmap((Bitmap)localObject2, paramDownloadParams);
        localObject1 = paramFile;
        if (!localObject2.equals(((RoundRectBitmap)localObject3).mBitmap))
        {
          localObject1 = paramFile;
          ((Bitmap)localObject2).recycle();
        }
        localObject1 = paramFile;
        localObject2 = new RoundRectBitmap(new ExifBitmapCreator(paramFile.getAbsolutePath()).creatBitmap(((RoundRectBitmap)localObject3).mBitmap), ((RoundRectBitmap)localObject3).mCornerRadius, ((RoundRectBitmap)localObject3).mBoardColor, ((RoundRectBitmap)localObject3).mBorderWidth);
        localObject1 = paramFile;
        if (this.application != null)
        {
          localObject1 = paramFile;
          ((RoundRectBitmap)localObject2).mDisplayWidth = this.application.getResources().getDisplayMetrics().widthPixels;
          localObject1 = paramFile;
          ((RoundRectBitmap)localObject2).mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
        }
        localObject1 = paramFile;
        logDecodeFile(paramDownloadParams, paramFile, str, paramOptions, 1, true, "step:create roundBitmap");
        return localObject2;
      }
      localObject1 = paramFile;
      if (!((PicUiInterface)paramDownloadParams.tag).isSendFromLocal())
      {
        localObject1 = paramFile;
        localObject2 = MD5Utils.encodeFileHexStr(paramFile.getAbsolutePath());
        localObject1 = paramFile;
        localObject3 = ((PicUiInterface)paramDownloadParams.tag).getPicDownloadInfo();
        localObject1 = paramFile;
        localObject4 = new StringBuilder();
        localObject1 = paramFile;
        ((StringBuilder)localObject4).append("Q.richmedia.");
        localObject1 = paramFile;
        ((StringBuilder)localObject4).append(TransFileUtil.getUinDesc(((PicDownloadInfo)localObject3).jdField_b_of_type_Int));
        localObject1 = paramFile;
        ((StringBuilder)localObject4).append(".dw");
        localObject1 = paramFile;
        localObject4 = ((StringBuilder)localObject4).toString();
        localObject1 = paramFile;
        localObject5 = new StringBuilder();
        localObject1 = paramFile;
        ((StringBuilder)localObject5).append("id:");
        localObject1 = paramFile;
        ((StringBuilder)localObject5).append(String.valueOf(((PicDownloadInfo)localObject3).jdField_a_of_type_Long));
        localObject1 = paramFile;
        ((StringBuilder)localObject5).append("step: UIDecoder FAIL srcPicMD5:");
        localObject1 = paramFile;
        ((StringBuilder)localObject5).append((String)localObject2);
        localObject1 = paramFile;
        QLog.i((String)localObject4, 1, ((StringBuilder)localObject5).toString());
      }
      localObject1 = paramFile;
      paramFile.delete();
      localObject1 = paramFile;
      logDecodeFile(paramDownloadParams, paramFile, str, paramOptions, 1, false, "step:decode error, not valid pic");
      localObject1 = paramFile;
      throw new IOException("step:decode error, not valid pic");
      int i = 1;
      Object localObject4 = localObject1;
      continue;
      label1152:
      i = 0;
    }
    return localObject2;
  }
  
  protected boolean decodeByAIOPicThumb(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return "chatthumb".equals(paramDownloadParams.url.getProtocol());
  }
  
  protected boolean decodeByGif(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = paramDownloadParams.tag;
    if (((paramDownloadParams instanceof MessageForPic)) && (FlashPicHelper.a((MessageForPic)paramDownloadParams))) {
      return false;
    }
    return GifDrawable.isGifFile(paramFile);
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeFile config.tag ");
      ((StringBuilder)localObject1).append(paramDownloadParams.tag);
      log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = paramDownloadParams.urlStr;
      URL localURL = paramDownloadParams.url;
      boolean bool = QLog.isColorLevel();
      if (bool)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DecodeFile START,cacheFile=");
        ((StringBuilder)localObject2).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject2).append(",url=");
        ((StringBuilder)localObject2).append((String)localObject1);
        log(paramDownloadParams, "DecodeFile", ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.ARGB_8888;
      ((BitmapFactory.Options)localObject2).inDensity = 160;
      ((BitmapFactory.Options)localObject2).inTargetDensity = 160;
      ((BitmapFactory.Options)localObject2).inScreenDensity = 160;
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      if (decodeByGif(paramFile, paramDownloadParams, paramURLDrawableHandler))
      {
        payPicFlow(paramDownloadParams);
        if (QLog.isColorLevel())
        {
          paramURLDrawableHandler = new StringBuilder();
          paramURLDrawableHandler.append("DecodeFile END,GIF image,cacheFile=");
          paramURLDrawableHandler.append(paramFile.getAbsolutePath());
          paramURLDrawableHandler.append(",url=");
          paramURLDrawableHandler.append((String)localObject1);
          log(paramDownloadParams, "DecodeFile", paramURLDrawableHandler.toString());
        }
      }
      else
      {
        if (decodeByAIOPicThumb(paramFile, paramDownloadParams, paramURLDrawableHandler)) {
          return decodeAioPicThumb(paramFile, paramDownloadParams, (BitmapFactory.Options)localObject2);
        }
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject2);
        if ((((BitmapFactory.Options)localObject2).outHeight != 0) && (((BitmapFactory.Options)localObject2).outWidth != 0)) {
          return decodeImage(localURL, paramFile, paramDownloadParams, (BitmapFactory.Options)localObject2);
        }
        paramFile.delete();
        logDecodeFile(paramDownloadParams, paramFile, (String)localObject1, (BitmapFactory.Options)localObject2, 1, false, "step:decode bounds error, not valid pic");
        throw new IOException("step:decode bounds error, not valid pic");
      }
    }
    catch (Exception localException)
    {
      paramURLDrawableHandler = ProcessorReport.getExceptionMessage(localException);
      if (paramURLDrawableHandler != null)
      {
        paramFile = paramURLDrawableHandler;
        if (paramURLDrawableHandler.length() != 0) {}
      }
      else
      {
        paramFile = localException.toString();
      }
      if (QLog.isColorLevel())
      {
        QLog.e("ChatImageDownloader", 2, paramFile);
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("DecodeFile FAIL,exceptionmsg:");
        paramURLDrawableHandler.append(paramFile);
        log(paramDownloadParams, "DecodeFile", paramURLDrawableHandler.toString());
      }
      paramDownloadParams = new HashMap();
      paramDownloadParams.put("params_failDesc", paramFile);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPicUIDecoder", false, -1L, 0L, paramDownloadParams, "", true);
      throw localException;
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject = paramDownloadParams.urlStr;
    int j = 1;
    int i;
    if ((localObject != null) && (paramDownloadParams.urlStr.startsWith("chatimg"))) {
      i = 1;
    } else {
      i = 0;
    }
    paramDownloadParams = getDownloadData(paramDownloadParams);
    paramDownloadParams.out = paramOutputStream;
    paramDownloadParams.handler = paramURLDrawableHandler;
    if ((paramDownloadParams.upInfo != null) && (paramDownloadParams.sendPath != null))
    {
      paramOutputStream = new File(paramDownloadParams.sendPath);
      if (paramOutputStream.exists())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("success file(send) exist, copy file from:");
        paramURLDrawableHandler.append(paramDownloadParams.sendPath);
        log(paramDownloadParams, "result", paramURLDrawableHandler.toString());
        copyFromFile(paramDownloadParams.out, paramOutputStream, paramDownloadParams.handler);
        return null;
      }
    }
    paramURLDrawableHandler.publishProgress(0);
    if (paramDownloadParams.downInfo != null)
    {
      if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
      {
        if ((Utils.a()) && (Utils.b() < 31457280L))
        {
          paramOutputStream = new StringBuilder();
          paramOutputStream.append("SD card free space is ");
          paramOutputStream.append(Utils.b());
          throw new IOException(paramOutputStream.toString());
        }
        localObject = stepDownload(paramDownloadParams);
        if (((TransferResult)localObject).mResult != 0) {
          j = 0;
        }
        if (j != 0)
        {
          paramOutputStream = "successed";
        }
        else
        {
          paramOutputStream = new StringBuilder();
          paramOutputStream.append("failed ");
          paramOutputStream.append(((TransferResult)localObject).mErrDesc);
          paramOutputStream = paramOutputStream.toString();
        }
        log(paramDownloadParams, "result", paramOutputStream);
        if (j == 0)
        {
          paramOutputStream = PicDownloadExplicitError.getPicError(localObject);
          if (paramOutputStream == null)
          {
            if (((TransferResult)localObject).mErrCode == 9037L)
            {
              paramURLDrawableHandler.doCancel();
              return null;
            }
            if ((((TransferResult)localObject).mErrCode == -9527L) && ("H_404_-124".equals(((TransferResult)localObject).mErrDesc)))
            {
              log(paramDownloadParams, "result", "successed|failed,H_404_-124,decodeFile will check");
              return null;
            }
            throw new ChatPicDownloadFailedException((int)((TransferResult)localObject).mErrCode, 0L, ((TransferResult)localObject).mErrDesc, false, false);
          }
          throw paramOutputStream;
        }
        if (i != 0)
        {
          if (paramDownloadParams.app != null) {
            paramOutputStream = paramDownloadParams.app.getCurrentAccountUin();
          } else {
            paramOutputStream = null;
          }
          reportBigPicDownCost(paramOutputStream, paramDownloadParams.uinType, paramDownloadParams.netWorkType, SystemClock.uptimeMillis() - l);
        }
        return null;
      }
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("failed could not call object.wait in Main thread ,sendpath:");
      paramOutputStream.append(paramDownloadParams.sendPath);
      paramOutputStream.append(",uniseq:");
      paramOutputStream.append(paramDownloadParams.downInfo.jdField_a_of_type_Long);
      log(paramDownloadParams, "result", paramOutputStream.toString());
      throw new ChatPicDownloadFailedException(9365, 0L, "param error,could not call object.wait in Main thread", false, false);
    }
    paramOutputStream = new StringBuilder();
    paramOutputStream.append("param error,params.downInfo == null,sendpath:");
    paramOutputStream.append(paramDownloadParams.sendPath);
    log(paramDownloadParams, "result", paramOutputStream.toString());
    throw new ChatPicDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
  }
  
  protected int getTryTime(URL paramURL)
  {
    if ((!paramURL.getProtocol().equals("chatimg")) && (!paramURL.getProtocol().equals("chatraw"))) {
      return super.getTryTime(paramURL);
    }
    return 3;
  }
  
  void logDecodeFile(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DecodeFile SUCCESS,retryCount=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(",options.inSampleSize=");
        localStringBuilder.append(paramOptions.inSampleSize);
        localStringBuilder.append(",cacheFile=");
        localStringBuilder.append(paramFile.getAbsolutePath());
        localStringBuilder.append(",url=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",extraMsg=");
        localStringBuilder.append(paramString2);
        log(paramDownloadParams, "DecodeFile", localStringBuilder.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DecodeFile FAIL,retryCount=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",options.inSampleSize=");
      localStringBuilder.append(paramOptions.inSampleSize);
      localStringBuilder.append(",cacheFile=");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(",url=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",extraMsg=");
      localStringBuilder.append(paramString2);
      log(paramDownloadParams, "DecodeFile", localStringBuilder.toString());
    }
  }
  
  protected void payPicFlow(DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      paramDownloadParams = (MessageForPic)paramDownloadParams.tag;
      Object localObject = paramDownloadParams.selfuin;
      localObject = ((PicPreDownloadImpl)((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
      ((PicPreDownloader)localObject).a.b(paramDownloadParams, paramDownloadParams.size);
      ((PicPreDownloader)localObject).d();
    }
  }
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    try
    {
      f1 = this.application.getResources().getDisplayMetrics().density;
      i6 = this.application.getResources().getDisplayMetrics().densityDpi;
      f3 = f1 * 12.0F;
      boolean bool = PicBusUtil.a(paramDownloadParams.mImgType);
      i = CommonImgThumbHelper.getImgThumbMinPx(bool);
      j = CommonImgThumbHelper.getImgThumbMinPx(bool);
      k = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      m = CommonImgThumbHelper.getImgThumbMaxPx(bool);
      if ((paramDownloadParams.tag instanceof MessageForPic))
      {
        localObject2 = (MessageForPic)paramDownloadParams.tag;
        i = Utils.a(AIOImgThumbHelper.getThumbWidthHeightDP((MessageForPic)localObject2, bool).mMinWidth, this.application.getResources());
        j = Utils.a(AIOImgThumbHelper.getThumbWidthHeightDP((MessageForPic)localObject2, bool).mMinHeight, this.application.getResources());
        k = Utils.a(AIOImgThumbHelper.getThumbWidthHeightDP((MessageForPic)localObject2, bool).mMaxWidth, this.application.getResources());
        m = Utils.a(AIOImgThumbHelper.getThumbWidthHeightDP((MessageForPic)localObject2, bool).mMaxHeight, this.application.getResources());
      }
      n = paramBitmap.getWidth();
      i1 = paramBitmap.getHeight();
      localObject2 = new Paint(1);
      ((Paint)localObject2).setColor(-16777216);
      i5 = CommonImgThumbHelper.getImgThumbMinDp(bool);
      i2 = CommonImgThumbHelper.getImgThumbMinDp(bool);
      i3 = CommonImgThumbHelper.getImgThumbMaxDp(bool);
      i4 = CommonImgThumbHelper.getImgThumbMaxDp(bool);
      if (!(paramDownloadParams.tag instanceof MessageForPic)) {
        break label581;
      }
      MessageForPic localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      i5 = AIOImgThumbHelper.getThumbWidthHeightDP(localMessageForPic, bool).mMinWidth;
      i2 = AIOImgThumbHelper.getThumbWidthHeightDP(localMessageForPic, bool).mMinHeight;
      i3 = AIOImgThumbHelper.getThumbWidthHeightDP(localMessageForPic, bool).mMaxWidth;
      i4 = AIOImgThumbHelper.getThumbWidthHeightDP(localMessageForPic, bool).mMaxHeight;
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      for (;;)
      {
        float f1;
        int i6;
        float f3;
        int i;
        int j;
        int k;
        int m;
        Object localObject2;
        int n;
        int i1;
        int i5;
        int i2;
        int i3;
        int i4;
        Object localObject1;
        label494:
        continue;
        label581:
        float f4 = n;
        float f2 = i1;
        float f5 = f2 * 3.0F;
        if (f4 > f5)
        {
          n = (int)f5;
        }
        else
        {
          f4 *= 3.0F;
          if (f2 > f4)
          {
            i1 = (int)f4;
            continue;
          }
        }
        continue;
        if ((n >= i5) && (i1 >= i2)) {
          if ((n < i3) && (i1 < i4))
          {
            j = (int)(n * f1 + 0.5F);
            i = (int)(i1 * f1 + 0.5F);
          }
          else if (n > i1)
          {
            f1 = k;
            f2 = n;
          }
          else
          {
            f1 = m;
            f2 = i1;
            continue;
            label731:
            f1 = i;
            f2 = n;
            continue;
            label743:
            label746:
            k = i;
            i = j;
            j = k;
          }
        }
      }
    }
    if (limitSizeByServer(paramDownloadParams))
    {
      return new RoundRectBitmap(((ICompressOperator)QRoute.api(ICompressOperator.class)).clip(paramBitmap, ((MessageForPic)paramDownloadParams.tag).thumbWidthHeightDP), f3);
      f4 = f1 / localObject1;
      if (n <= i1) {
        break label731;
      }
      f1 = j;
      f2 = i1;
      f1 /= f2;
      f1 = Math.max(f4, f1);
      j = (int)(n * f1 + 0.5F);
      i = (int)(i1 * f1 + 0.5F);
      break label494;
      if (n < i1)
      {
        f1 = i / n;
        j = (int)(i1 * f1 + 0.5F);
        if (j <= m) {
          break label743;
        }
        j = m;
        break label746;
      }
      f1 = j / i1;
      i = (int)(n * f1 + 0.5F);
      if (i <= k) {
        break label746;
      }
      i = k;
      break label746;
      paramDownloadParams = Bitmap.createBitmap(j, i, paramBitmap.getConfig());
      paramDownloadParams.setDensity(i6);
      new Canvas(paramDownloadParams).drawBitmap(paramBitmap, new Rect(0, 0, n, i1), new Rect(0, 0, j, i), (Paint)localObject2);
      paramDownloadParams = new RoundRectBitmap(paramDownloadParams, f3);
      return paramDownloadParams;
      return new RoundRectBitmap(paramBitmap, 12.0F);
    }
  }
  
  TransferResult stepDownload(ChatImageDownloader.DownloadData paramDownloadData)
  {
    if (paramDownloadData.app == null) {
      paramDownloadData.app = ((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime());
    }
    if (paramDownloadData.app != null)
    {
      localObject1 = paramDownloadData.downInfo;
      ((PicDownloadInfo)localObject1).jdField_e_of_type_JavaLangString = paramDownloadData.url.getProtocol();
      if (paramDownloadData.pic != null)
      {
        ((PicDownloadInfo)localObject1).d = paramDownloadData.pic.bEnableEnc;
        ((PicDownloadInfo)localObject1).c = paramDownloadData.pic.time;
      }
      Object localObject2 = PicBusiManager.a(5, 1280, 1);
      ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramDownloadData.pic;
      ((PicReq)localObject2).jdField_b_of_type_JavaLangString = "PIC_TAG";
      ((PicReq)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = ((PicDownloadInfo)localObject1);
      ((PicReq)localObject2).jdField_a_of_type_JavaLangObject = paramDownloadData.handler;
      localObject1 = PicBusiManager.a((PicReq)localObject2);
      if ((localObject1 instanceof DownloadPicOperator))
      {
        localObject2 = paramDownloadData.logId;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("url:");
        localStringBuilder.append(paramDownloadData.url);
        localStringBuilder.append(",info:");
        localStringBuilder.append(paramDownloadData.downInfo);
        Logger.a("PIC_TAG", (String)localObject2, "stepDownload", localStringBuilder.toString());
        ((AbstractPicOperator)localObject1).a();
        return ((DownloadPicOperator)localObject1).a();
      }
      Logger.a("PIC_TAG", paramDownloadData.logId, "stepDownload", "operator wrong");
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("params.app == null ,selfuin:");
    ((StringBuilder)localObject1).append(paramDownloadData.downInfo.jdField_b_of_type_JavaLangString);
    log(paramDownloadData, "stepDownload", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("stepDownload,params.app == null ,selfuin:");
    ((StringBuilder)localObject1).append(paramDownloadData.downInfo.jdField_b_of_type_JavaLangString);
    throw new ChatPicDownloadFailedException(9302, 0L, ((StringBuilder)localObject1).toString(), false, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ChatImageDownloader
 * JD-Core Version:    0.7.0.1
 */