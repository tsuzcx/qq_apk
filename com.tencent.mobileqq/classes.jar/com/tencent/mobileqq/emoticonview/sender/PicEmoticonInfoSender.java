package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PicEmoticonInfoSender
{
  private static final String TAG = "PicEmoticonInfoSender";
  
  private static void asyncStartH5MagicPlayActivity(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Parcelable paramParcelable, Emoticon paramEmoticon)
  {
    ThreadManager.post(new PicEmoticonInfoSender.4(paramBaseQQAppInterface, paramContext, paramParcelable, paramEmoticon), 5, null, true);
  }
  
  public static void send(Emoticon paramEmoticon, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, BaseSessionInfo paramBaseSessionInfo, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("PicEmoticonInfoSender", 2, "app is null.");
      return;
    }
    if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
    if (paramEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfoSender", 1, "send isFroward emotion = null");
      return;
    }
    paramEditText = (IEmojiManagerService)paramAppRuntime.getRuntimeService(IEmojiManagerService.class);
    if ((paramEmoticon.jobType == 2) && (paramBoolean) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSupportMagicface()))
    {
      if (!paramEditText.isMagicFacePackageIntact(paramEmoticon.epId, Boolean.valueOf(false)))
      {
        QQToast.a(paramContext, 2131689916, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        paramEmoticon = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(paramAppRuntime);
        if (paramEmoticon != null)
        {
          paramEmoticon.obtainMessage(10).sendToTarget();
          paramEmoticon.obtainMessage(21).sendToTarget();
        }
        return;
      }
      paramInt = ((IEmosmService)QRoute.api(IEmosmService.class)).getRandomMaxValue(paramEmoticon, 0);
      if (QLog.isColorLevel())
      {
        paramEditText = new StringBuilder();
        paramEditText.append("forward,【maxInt:】");
        paramEditText.append(paramInt);
        QLog.d("PicEmoticonInfoSender", 2, paramEditText.toString());
      }
      paramInt = PngFrameUtil.a(paramInt);
      ((IEmoticonManagerService)paramAppRuntime.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramEmoticon.epId, new PicEmoticonInfoSender.1(paramEmoticon, paramAppRuntime, paramInt, paramContext, paramBaseSessionInfo));
      return;
    }
    if ((paramEmoticon.jobType == 4) && (paramBoolean) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("emoticon_panel_");
      ((StringBuilder)localObject).append(paramAppRuntime.getCurrentAccountUin());
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 0);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
      }
      if (paramEditText.isH5MagicFacePackageIntact(paramEmoticon.epId, true, true))
      {
        if (paramEditText.isDPCSupportH5Magic()) {
          asyncStartH5MagicPlayActivity(paramContext, paramAppRuntime, (Parcelable)paramBaseSessionInfo, paramEmoticon);
        } else if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfoSender", 2, "forward not support h5magic");
        }
      }
      else
      {
        QQToast.a(paramContext, 2131689916, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        paramEmoticon = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(paramAppRuntime);
        if (paramEmoticon != null)
        {
          paramEmoticon.obtainMessage(10).sendToTarget();
          paramEmoticon.obtainMessage(21).sendToTarget();
        }
        return;
      }
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, paramInt);
  }
  
  public static void send(PicEmoticonInfo paramPicEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramPicEmoticonInfo == null)
    {
      QLog.e("PicEmoticonInfoSender", 1, "emoticonInfo is null");
      return;
    }
    send(paramAppRuntime, paramContext, (BaseSessionInfo)paramParcelable, paramPicEmoticonInfo.emoticon, null);
  }
  
  public static void send(PicEmoticonInfo paramPicEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramPicEmoticonInfo != null))
    {
      if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
        return;
      }
      paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon;
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
      paramEditText = (BaseSessionInfo)paramParcelable;
      if (paramPicEmoticonInfo == null)
      {
        VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
        QLog.e("PicEmoticonInfoSender", 1, "send isFroward emotion = null");
        return;
      }
      paramParcelable = (IEmojiManagerService)paramAppRuntime.getRuntimeService(IEmojiManagerService.class);
      if ((paramPicEmoticonInfo.jobType == 2) && (paramBoolean) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSupportMagicface()))
      {
        if (!paramParcelable.isMagicFacePackageIntact(paramPicEmoticonInfo.epId, Boolean.valueOf(false)))
        {
          EmotionUtils.a(paramContext, 2131689916, 0);
          paramPicEmoticonInfo = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(paramAppRuntime);
          if (paramPicEmoticonInfo != null)
          {
            paramPicEmoticonInfo.obtainMessage(10).sendToTarget();
            paramPicEmoticonInfo.obtainMessage(21).sendToTarget();
          }
          return;
        }
        paramInt = ((IEmosmService)QRoute.api(IEmosmService.class)).getRandomMaxValue(paramPicEmoticonInfo, 0);
        if (QLog.isColorLevel())
        {
          paramParcelable = new StringBuilder();
          paramParcelable.append("forward,【maxInt:】");
          paramParcelable.append(paramInt);
          QLog.d("PicEmoticonInfoSender", 2, paramParcelable.toString());
        }
        paramInt = PngFrameUtil.a(paramInt);
        ((IEmoticonManagerService)paramAppRuntime.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramPicEmoticonInfo.epId, new PicEmoticonInfoSender.5(paramPicEmoticonInfo, paramAppRuntime, paramInt, paramContext, paramEditText));
        return;
      }
      if ((paramPicEmoticonInfo.jobType == 4) && (paramBoolean) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emoticon_panel_");
        ((StringBuilder)localObject).append(paramAppRuntime.getCurrentAccountUin());
        localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (paramParcelable.isH5MagicFacePackageIntact(paramPicEmoticonInfo.epId, true, true))
        {
          if (paramParcelable.isDPCSupportH5Magic()) {
            asyncStartH5MagicPlayActivity(paramContext, paramAppRuntime, (Parcelable)paramEditText, paramPicEmoticonInfo);
          } else if (QLog.isColorLevel()) {
            QLog.d("PicEmoticonInfoSender", 2, "forward not support h5magic");
          }
        }
        else
        {
          EmotionUtils.a(paramContext, 2131689916, 0);
          paramPicEmoticonInfo = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(paramAppRuntime);
          if (paramPicEmoticonInfo != null)
          {
            paramPicEmoticonInfo.obtainMessage(10).sendToTarget();
            paramPicEmoticonInfo.obtainMessage(21).sendToTarget();
          }
          return;
        }
      }
      ((IEmosmService)QRoute.api(IEmosmService.class)).sendEmosmMsg(paramAppRuntime, paramContext, paramEditText, paramPicEmoticonInfo, paramInt);
      return;
    }
    QLog.e("PicEmoticonInfoSender", 2, "app is null.");
  }
  
  public static void send(AppRuntime paramAppRuntime, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfoSender", 1, "send emotion + 1:emotion == null");
      return;
    }
    if ((paramAppRuntime != null) && (paramBaseSessionInfo != null))
    {
      if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
        return;
      }
      paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("emotion mall,epid=");
        localStringBuilder.append(paramEmoticon.epId);
        localStringBuilder.append(";jobtype=");
        localStringBuilder.append(paramEmoticon.jobType);
        QLog.d("PicEmoticonInfoSender", 2, localStringBuilder.toString());
      }
      if (paramEmoticon.isNewSoundEmoticon()) {
        EmoticonOperateReport.reportNewSoundEvent(paramAppRuntime, "0X800A932", paramBaseSessionInfo.a, paramEmoticon.epId);
      }
      if ((paramEmoticon.jobType == 2) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)))
      {
        sendMagicEmoticon(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
        return;
      }
      if ((paramEmoticon.jobType == 4) && (((IEmosmService)QRoute.api(IEmosmService.class)).isSplashChatContext(paramContext)))
      {
        sendH5MagicEmoticon(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
        return;
      }
      sendStickerMsg(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    QLog.e("PicEmoticonInfoSender", 1, "app or session is null");
  }
  
  public static void send(AppRuntime paramAppRuntime, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, Serializable paramSerializable)
  {
    send(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, (StickerInfo)paramSerializable);
  }
  
  private static void sendH5MagicEmoticon(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("emoticon_panel_");
    ((StringBuilder)localObject).append(paramBaseQQAppInterface.getCurrentAccountUin());
    localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramEmoticon.epId, 0, new PicEmoticonInfoSender.3(paramContext, paramBaseQQAppInterface, paramEmoticon, (IEmojiManagerService)localObject, paramBaseSessionInfo));
    sendStickerMsg(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void sendMagicEmoticon(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    IEmojiManagerService localIEmojiManagerService = (IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
    ReportController.b(paramBaseQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
    ((IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(paramEmoticon.epId, -1, new PicEmoticonInfoSender.2(paramContext, paramBaseQQAppInterface, paramEmoticon, localIEmojiManagerService, paramBaseSessionInfo, paramStickerInfo));
  }
  
  private static void sendStickerMsg(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, StickerInfo paramStickerInfo)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).sendStickerMsg(paramBaseQQAppInterface, paramContext, paramBaseSessionInfo, paramEmoticon, paramStickerInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */