package com.tencent.open.sdk.report;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class SdkShareReporter
{
  public static int a(int paramInt)
  {
    if (paramInt != 5)
    {
      if (paramInt != 2147483646) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  public static void a(int paramInt, long paramLong, String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A426", "0X800A426", 0, 1, "", d(paramInt), String.valueOf(paramLong), paramString);
    if (QLog.isColorLevel()) {
      QLog.d("SdkShareReport", 2, new Object[] { "大图曝光=", "0X800A426", ", appid=", Long.valueOf(paramLong), ", getTitleFromBrief=", paramString });
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (!paramIntent.getBooleanExtra("key_forward_image_share", false)) {
      return;
    }
    String str = paramIntent.getStringExtra("key_forward_image_share_appid");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    int i = paramIntent.getIntExtra("key_forward_image_share_uin_type", 0);
    paramIntent = paramIntent.getStringExtra("key_forward_image_share_title");
    ReportController.b(null, "dc00898", "", "", "0X800A427", "0X800A427", 0, 1, "", d(i), str, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "大图转发=", "0X800A427", ", appid", str, ", title=", paramIntent });
    }
  }
  
  public static void a(Intent paramIntent, long paramLong, String paramString)
  {
    if (!paramIntent.getBooleanExtra("key_forward_share", false)) {
      return;
    }
    String str = paramIntent.getStringExtra("key_forward_share_title");
    int i = paramIntent.getIntExtra("key_forward_image_share_uin_type", 0);
    ReportController.b(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, 1, paramString, d(i), str, String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardBaseOption", 2, new Object[] { "图文或者音乐转发=0X800A631, type=", paramString, ", title=", str, ", uinType=", d(i) });
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    String str1 = b(paramBundle.getInt("req_type"));
    String str2 = c(paramBundle.getInt("uintype"));
    String str3 = paramBundle.getString("title");
    long l = paramBundle.getLong("req_share_id");
    ReportController.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, a(paramBundle.getInt("req_type")), String.valueOf(l), str1, str2, str3);
  }
  
  public static void a(Bundle paramBundle, int paramInt, long paramLong)
  {
    String str = paramBundle.getString("title");
    int i = paramBundle.getInt("uintype");
    ReportController.b(null, "dc00898", "", "", "0X800B2DB", "0X800B2DB", 0, a(paramInt), String.valueOf(paramLong), b(paramInt), c(i), str);
  }
  
  public static void a(Bundle paramBundle, long paramLong)
  {
    int i = paramBundle.getInt("uintype");
    String str1 = paramBundle.getString("forward_ark_app_type");
    String str2 = paramBundle.getString("forward_ark_app_title");
    int j = paramBundle.getInt("forward_ark_app_result");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A631", "0X800A631", 0, j, str1, d(i), str2, String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("SdkShareReport", 2, new Object[] { "ARK转发=0X800A631, type=", str1, ", uinType=", d(i), ", title=", str2 });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, Intent paramIntent, AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      paramQQAppInterface = (StructMsgForGeneralShare)paramAbsShareMsg;
      paramAbsShareMsg = paramQQAppInterface.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject1 = (AbsStructMsgElement)paramAbsShareMsg.next();
        if ((localObject1 instanceof StructMsgItemLayout5))
        {
          localObject1 = ((StructMsgItemLayout5)localObject1).ax.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if ((localObject2 instanceof StructMsgItemVideo))
            {
              localObject2 = (StructMsgItemVideo)localObject2;
              if (((StructMsgItemVideo)localObject2).c()) {
                ((IVideoReporter)QRoute.api(IVideoReporter.class)).reportClickEvent("0X80065FF", paramQQAppInterface.uinType, ((IVideoReporter)QRoute.api(IVideoReporter.class)).getReportVideoType(((StructMsgItemVideo)localObject2).aR, paramQQAppInterface.mSourceName), ((StructMsgItemVideo)localObject2).az, "");
              }
            }
          }
        }
      }
      a(paramIntent, paramLong, "1");
      return;
    }
    if ((paramAbsShareMsg instanceof StructMsgForImageShare))
    {
      if (AIOGallerySceneWithBusiness.b(paramAbsShareMsg.mMsgActionData))
      {
        paramAbsShareMsg = AIOGallerySceneWithBusiness.f(paramAbsShareMsg.mMsgActionData);
        if ((paramAbsShareMsg != null) && (paramAbsShareMsg.length > 3))
        {
          paramAbsShareMsg = paramAbsShareMsg[3];
          if ((paramAbsShareMsg != null) && (paramAbsShareMsg.equals("1")))
          {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(paramQQAppInterface, "", "0X80072A5", "0X80072A5", 0, 0, "", "", "", "");
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80072A5", "", "", "", "", "");
          }
        }
      }
      a(paramIntent);
      return;
    }
    if ((paramAbsShareMsg instanceof StructMsgForAudioShare)) {
      a(paramIntent, paramLong, "2");
    }
  }
  
  public static void a(MessageForArkApp paramMessageForArkApp)
  {
    SdkShareReporter.ArkReportData localArkReportData = c(paramMessageForArkApp);
    if (!localArkReportData.c) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, localArkReportData.e, localArkReportData.a, d(paramMessageForArkApp.istroop), localArkReportData.b, localArkReportData.d);
    if (QLog.isColorLevel()) {
      QLog.d("SdkShareReport", 2, new Object[] { "ARK曝光=0X800A62F, type=", localArkReportData.a, ", uinType=", d(paramMessageForArkApp.istroop), ", title=", localArkReportData.b });
    }
  }
  
  public static void a(AbsStructMsg paramAbsStructMsg, int paramInt, long paramLong)
  {
    ReportController.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 1, String.valueOf(paramLong), "4", c(paramInt), ((AbsShareMsg)paramAbsStructMsg).mContentTitle);
  }
  
  public static void a(AbsStructMsg paramAbsStructMsg, Bundle paramBundle)
  {
    String str1 = b(paramBundle.getInt("req_type"));
    String str2 = c(paramBundle.getInt("uintype"));
    if ((paramAbsStructMsg instanceof AbsShareMsg)) {
      paramAbsStructMsg = ((AbsShareMsg)paramAbsStructMsg).mContentTitle;
    } else {
      paramAbsStructMsg = "";
    }
    long l = paramBundle.getLong("req_share_id");
    ReportController.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, a(paramBundle.getInt("req_type")), String.valueOf(l), str1, str2, paramAbsStructMsg);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 1, paramString1, d(paramInt), paramString2, String.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("SdkShareReport", 2, new Object[] { "曝光=0X800A62F, type=", paramString1, ", title=", paramString2, ", uinType=", d(paramInt) });
    }
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    ReportController.a(paramAppRuntime, "0X800BA85");
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return "0";
            }
            return "5";
          }
          return "4";
        }
        return "3";
      }
      return "2";
    }
    return "1";
  }
  
  public static void b(int paramInt, long paramLong, String paramString)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A428", "0X800A428", 0, 1, "", d(paramInt), Long.toString(paramLong), paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("大图点击=0X800A428, appid=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", fileType=4, briefTitle=");
      QLog.d("SdkShareReport", 2, new Object[] { localStringBuilder.toString(), paramString });
    }
  }
  
  public static void b(MessageForArkApp paramMessageForArkApp)
  {
    SdkShareReporter.ArkReportData localArkReportData = c(paramMessageForArkApp);
    if (!localArkReportData.c) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, localArkReportData.e, localArkReportData.a, d(paramMessageForArkApp.istroop), localArkReportData.b, localArkReportData.d);
    if (QLog.isColorLevel()) {
      QLog.d("SdkShareReport", 2, new Object[] { "ARK点击=0X800A630, type=", localArkReportData.a, ", uinType=", d(paramMessageForArkApp.istroop), ", title=", localArkReportData.b });
    }
    String str1;
    if (localArkReportData.a == "2")
    {
      if (paramMessageForArkApp.istroop == 0) {
        str1 = "c2c_AIO";
      } else {
        str1 = "Grp_AIO";
      }
      String str2;
      if (paramMessageForArkApp.istroop == 0) {
        str2 = "";
      } else {
        str2 = paramMessageForArkApp.frienduin;
      }
      ReportController.b(null, "dc00899", str1, "", "music_tab", "clk_musicark_share", 0, 0, str2, "", "", "");
    }
    if ((localArkReportData.a == "1") && ("101492711".equals(paramMessageForArkApp.getNewsAppid())))
    {
      if (paramMessageForArkApp.istroop == 0) {
        str1 = "c2c_AIO";
      } else {
        str1 = "Grp_AIO";
      }
      ReportController.b(null, "dc00899", str1, "", "video_tab", "clk_videoark_share", 0, 0, paramMessageForArkApp.frienduin, paramMessageForArkApp.ark_app_message.appId, "", "");
    }
  }
  
  public static void b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A630", "0X800A630", 0, 1, paramString1, d(paramInt), paramString2, String.valueOf(paramLong));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", title=");
      localStringBuilder.append(paramString2);
      QLog.d("SdkShareReport", 2, new Object[] { "分享内容点击=", "0X800A630, type=", paramString1, localStringBuilder.toString(), ", uinType=", d(paramInt) });
    }
  }
  
  public static SdkShareReporter.ArkReportData c(MessageForArkApp paramMessageForArkApp)
  {
    String str1 = paramMessageForArkApp.ark_app_message.appName;
    String str2 = paramMessageForArkApp.ark_app_message.appView;
    SdkShareReporter.ArkReportData localArkReportData = new SdkShareReporter.ArkReportData();
    if ("com.tencent.structmsg".equals(str1))
    {
      if ("music".equals(str2))
      {
        localArkReportData.a = "2";
        localArkReportData.b = paramMessageForArkApp.getMusicTitle();
        localArkReportData.d = paramMessageForArkApp.getMusicAppid();
        localArkReportData.e = 2;
      }
      else if ("news".equals(str2))
      {
        localArkReportData.a = "1";
        localArkReportData.b = paramMessageForArkApp.getTitle();
        localArkReportData.d = paramMessageForArkApp.getNewsAppid();
        localArkReportData.e = 2;
      }
      localArkReportData.c = paramMessageForArkApp.isFromSdkShare();
    }
    else
    {
      localArkReportData.a = "4";
      localArkReportData.b = paramMessageForArkApp.ark_app_message.promptText;
      localArkReportData.c = false;
      localArkReportData.d = paramMessageForArkApp.ark_app_message.appId;
    }
    if (TextUtils.isEmpty(localArkReportData.b)) {
      localArkReportData.b = "";
    }
    return localArkReportData;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt == 0) {
      return "1";
    }
    if (1 == paramInt) {
      return "2";
    }
    if (3000 == paramInt) {
      return "3";
    }
    return "0";
  }
  
  public static String d(int paramInt)
  {
    if (paramInt == 0) {
      return "1";
    }
    if ((1 != paramInt) && (3000 != paramInt)) {
      return "0";
    }
    return "2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.sdk.report.SdkShareReporter
 * JD-Core Version:    0.7.0.1
 */