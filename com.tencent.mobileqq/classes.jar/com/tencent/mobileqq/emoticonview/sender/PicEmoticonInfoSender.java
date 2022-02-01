package com.tencent.mobileqq.emoticonview.sender;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PicEmoticonInfoSender
  implements IPicEmoticonInfoSender<PicEmoticonInfo, Emoticon>
{
  private static final String TAG = "PicEmoticonInfoSender";
  
  private static void asyncStartH5MagicPlayActivity(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    ThreadManager.post(new PicEmoticonInfoSender.4(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon), 5, null, true);
  }
  
  public static void send(AppRuntime paramAppRuntime, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfoSender", 1, "send emotion + 1:emotion == null");
    }
    do
    {
      return;
      if (paramAppRuntime == null)
      {
        QLog.e("PicEmoticonInfoSender", 1, "app is null");
        return;
      }
    } while (!(paramAppRuntime instanceof QQAppInterface));
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfoSender", 2, "emotion mall,epid=" + paramEmoticon.epId + ";jobtype=" + paramEmoticon.jobType);
    }
    if (paramEmoticon.isNewSoundEmoticon()) {
      EmoticonManager.a(paramAppRuntime, "0X800A932", paramSessionInfo.a, paramEmoticon.epId);
    }
    if ((paramEmoticon.jobType == 2) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      sendMagicEmoticon(paramAppRuntime, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    if ((paramEmoticon.jobType == 4) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      sendH5MagicEmoticon(paramAppRuntime, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    sendStickerMsg(paramAppRuntime, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void sendH5MagicEmoticon(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    Object localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId, 0, new PicEmoticonInfoSender.3(paramContext, paramQQAppInterface, paramEmoticon, (EmojiManager)localObject, paramSessionInfo));
    sendStickerMsg(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void sendMagicEmoticon(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    EmojiManager localEmojiManager = (EmojiManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
    ((EmoticonManager)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId, -1, new PicEmoticonInfoSender.2(paramContext, paramQQAppInterface, paramEmoticon, localEmojiManager, paramSessionInfo, paramStickerInfo));
  }
  
  private static void sendStickerMsg(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
    paramSessionInfo = "";
    int j = -1;
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    int i = j;
    if (paramContext != null)
    {
      paramContext = AIOEmoticonUIHelper.a(paramContext.a());
      i = j;
      if (paramContext != null) {
        i = paramContext.getEmoticonTab(paramEmoticon.epId);
      }
    }
    paramContext = paramSessionInfo;
    if (i >= 0) {
      paramContext = Integer.toString(i);
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
  }
  
  public void send(Emoticon paramEmoticon, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    if (paramAppRuntime == null) {
      QLog.e("PicEmoticonInfoSender", 2, "app is null.");
    }
    label239:
    label381:
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramAppRuntime instanceof QQAppInterface));
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        if (paramEmoticon == null)
        {
          VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
          QLog.e("PicEmoticonInfoSender", 1, "send isFroward emotion = null");
          return;
        }
        paramEditText = (EmojiManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
        if ((paramEmoticon.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!MagicfaceViewController.a())) {
          break label239;
        }
        if (paramEditText.a(paramEmoticon.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.a(paramContext, 2131690001, 0);
        paramEmoticon = paramAppRuntime.getHandler(ChatActivity.class);
      } while (paramEmoticon == null);
      paramEmoticon.obtainMessage(10).sendToTarget();
      paramEmoticon.obtainMessage(21).sendToTarget();
      return;
      paramInt = MagicfaceActionManager.a(paramEmoticon, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfoSender", 2, "forward,【maxInt:】" + paramInt);
      }
      paramInt = PngFrameUtil.a(paramInt);
      ((EmoticonManager)paramAppRuntime.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId, new PicEmoticonInfoSender.1(this, paramEmoticon, paramAppRuntime, paramInt, paramContext, paramSessionInfo));
      return;
      if ((paramEmoticon.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramAppRuntime.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramEditText.b(paramEmoticon.epId, true, true)) {
          break label381;
        }
        if (!paramEditText.b()) {
          break label363;
        }
        asyncStartH5MagicPlayActivity(paramContext, paramAppRuntime, paramSessionInfo, paramEmoticon);
      }
      for (;;)
      {
        ChatActivityFacade.a(paramAppRuntime, paramContext, paramSessionInfo, paramEmoticon, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfoSender", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.a(paramContext, 2131690001, 0);
      paramEmoticon = paramAppRuntime.getHandler(ChatActivity.class);
    } while (paramEmoticon == null);
    label363:
    paramEmoticon.obtainMessage(10).sendToTarget();
    paramEmoticon.obtainMessage(21).sendToTarget();
  }
  
  public void send(PicEmoticonInfo paramPicEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramPicEmoticonInfo == null)
    {
      QLog.e("PicEmoticonInfoSender", 1, "emoticonInfo is null");
      return;
    }
    send(paramAppRuntime, paramContext, (SessionInfo)paramParcelable, paramPicEmoticonInfo.emoticon, null);
  }
  
  public void send(PicEmoticonInfo paramPicEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt)
  {
    if ((paramAppRuntime == null) || (paramPicEmoticonInfo == null)) {
      QLog.e("PicEmoticonInfoSender", 2, "app is null.");
    }
    label255:
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramAppRuntime instanceof QQAppInterface));
        paramPicEmoticonInfo = paramPicEmoticonInfo.emoticon;
        paramAppRuntime = (QQAppInterface)paramAppRuntime;
        paramEditText = (SessionInfo)paramParcelable;
        if (paramPicEmoticonInfo == null)
        {
          VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
          QLog.e("PicEmoticonInfoSender", 1, "send isFroward emotion = null");
          return;
        }
        paramParcelable = (EmojiManager)paramAppRuntime.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
        if ((paramPicEmoticonInfo.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!MagicfaceViewController.a())) {
          break label255;
        }
        if (paramParcelable.a(paramPicEmoticonInfo.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.a(paramContext, 2131690001, 0);
        paramPicEmoticonInfo = paramAppRuntime.getHandler(ChatActivity.class);
      } while (paramPicEmoticonInfo == null);
      paramPicEmoticonInfo.obtainMessage(10).sendToTarget();
      paramPicEmoticonInfo.obtainMessage(21).sendToTarget();
      return;
      paramInt = MagicfaceActionManager.a(paramPicEmoticonInfo, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfoSender", 2, "forward,【maxInt:】" + paramInt);
      }
      paramInt = PngFrameUtil.a(paramInt);
      ((EmoticonManager)paramAppRuntime.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramPicEmoticonInfo.epId, new PicEmoticonInfoSender.5(this, paramPicEmoticonInfo, paramAppRuntime, paramInt, paramContext, paramEditText));
      return;
      if ((paramPicEmoticonInfo.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramAppRuntime.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramParcelable.b(paramPicEmoticonInfo.epId, true, true)) {
          break label397;
        }
        if (!paramParcelable.b()) {
          break label379;
        }
        asyncStartH5MagicPlayActivity(paramContext, paramAppRuntime, paramEditText, paramPicEmoticonInfo);
      }
      for (;;)
      {
        ChatActivityFacade.a(paramAppRuntime, paramContext, paramEditText, paramPicEmoticonInfo, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfoSender", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.a(paramContext, 2131690001, 0);
      paramPicEmoticonInfo = paramAppRuntime.getHandler(ChatActivity.class);
    } while (paramPicEmoticonInfo == null);
    label379:
    paramPicEmoticonInfo.obtainMessage(10).sendToTarget();
    label397:
    paramPicEmoticonInfo.obtainMessage(21).sendToTarget();
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, Parcelable paramParcelable, Emoticon paramEmoticon, Serializable paramSerializable)
  {
    send(paramAppRuntime, paramContext, (SessionInfo)paramParcelable, paramEmoticon, (EmojiStickerManager.StickerInfo)paramSerializable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender
 * JD-Core Version:    0.7.0.1
 */