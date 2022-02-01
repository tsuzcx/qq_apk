package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class CustomEmotionSenderUtil
{
  private static final String TAG = "CustomEmotionSenderUtil";
  
  public static void sendCustomEmotion(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean, String paramString2, Bundle paramBundle)
  {
    sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, paramString1, false, false, paramBoolean, null, null, paramString2, paramBundle);
  }
  
  public static void sendCustomEmotion(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, StickerInfo paramStickerInfo)
  {
    sendCustomEmotion(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, paramString1, paramBoolean1, paramBoolean2, false, paramString2, paramStickerInfo, null, null);
  }
  
  public static void sendCustomEmotion(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, StickerInfo paramStickerInfo, String paramString3, Bundle paramBundle)
  {
    if (paramString1 == null)
    {
      QLog.e("CustomEmotionSenderUtil", 1, "sendCustomEmotion url == null");
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "5", "", "", "", "", "", "", "");
      }
      return;
    }
    RichMediaUtil.logUI(paramBaseSessionInfo.a, true, 1, String.valueOf(-1), "image_send_prepare", "ChatActivity.sendCustomEmotion");
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      QQToast.makeText(paramContext, 2131892635, 0).show(paramContext.getResources().getDimensionPixelSize(2131299920));
      if (paramBoolean1) {
        VasReportUtils.a("emotionType", "emotionActionSend", "6", "", "", "", "", "", "", "");
      }
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("sendCustomEmotion file not exist or problme: URL = ");
      paramBaseQQAppInterface.append(paramString1);
      QLog.e("CustomEmotionSenderUtil", 1, paramBaseQQAppInterface.toString());
      return;
    }
    Object localObject1 = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject1).a(paramString1);
    ((PicUploadInfo.Builder)localObject1).d(1006);
    ((PicUploadInfo.Builder)localObject1).d(paramBaseSessionInfo.b);
    ((PicUploadInfo.Builder)localObject1).c(0);
    ((PicUploadInfo.Builder)localObject1).e(paramBaseSessionInfo.c);
    ((PicUploadInfo.Builder)localObject1).c(paramBaseQQAppInterface.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject1).e(paramBaseSessionInfo.a);
    ((PicUploadInfo.Builder)localObject1).l(paramBaseSessionInfo.v);
    Object localObject2 = (IPicBus)QRoute.api(IPicBus.class);
    int i = 2;
    localObject2 = ((IPicBus)localObject2).createPicReq(2, 1006);
    ((PicReq)localObject2).a(((PicUploadInfo.Builder)localObject1).k());
    PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
    localObject1 = "";
    if (paramBoolean3)
    {
      localPicMessageExtraData.imageBizType = 8;
      if (paramBundle != null) {
        localPicMessageExtraData.mTemplateId = paramBundle.getString("widgetinfo", "");
      }
    }
    else
    {
      localPicMessageExtraData.imageBizType = 1;
      if (!paramBoolean2) {
        i = 0;
      }
      localPicMessageExtraData.customFaceType = i;
      paramBundle = (Bundle)localObject1;
      if (paramBoolean2) {
        paramBundle = paramString2;
      }
      localPicMessageExtraData.emojiPkgId = paramBundle;
      if (paramStickerInfo != null) {
        localPicMessageExtraData.stickerInfo = paramStickerInfo;
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      paramContext = new StringBuilder();
      paramContext.append("[");
      paramContext.append(paramString3);
      paramContext.append("]");
      localPicMessageExtraData.textSummary = paramContext.toString();
    }
    else if (paramBoolean3)
    {
      localPicMessageExtraData.textSummary = paramContext.getResources().getString(2131888230);
    }
    else
    {
      localPicMessageExtraData.textSummary = paramContext.getResources().getString(2131888229);
    }
    ((PicReq)localObject2).i = localPicMessageExtraData;
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject2);
    if (paramBoolean1) {
      ThreadManager.post(new CustomEmotionSenderUtil.1(paramString1, paramBaseSessionInfo, paramBaseQQAppInterface), 5, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.CustomEmotionSenderUtil
 * JD-Core Version:    0.7.0.1
 */