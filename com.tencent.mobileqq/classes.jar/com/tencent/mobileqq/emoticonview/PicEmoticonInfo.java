package com.tencent.mobileqq.emoticonview;

import admh;
import ahbj;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.ImageView;
import asih;
import awrh;
import awsf;
import awsw;
import awyr;
import bdla;
import bhpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.os.MqqHandler;

public class PicEmoticonInfo
  extends EmoticonInfo
  implements ICustomEmotionInfo
{
  public static final int DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR = Color.parseColor("#21d9c6");
  public static final int DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR = Color.parseColor("#ffffff");
  public static final String ORIGINAL_EMOTION_COUNT_SP_FILE_NAME_ = "originalEmotionCountSp_";
  public static final int ORIGINAL_EMOTION_REWORD_COUNT = 21;
  private static final String TAG = "PicEmoticonInfo";
  public static final int TYPE_GIF = 3;
  public static final int TYPE_PNG = 2;
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG;
  public boolean isDownLoad;
  private Drawable mDefault;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  private Drawable mFIVE_INCH_DEFAULT;
  private Drawable mFIVE_INCH_FAILED;
  private Drawable mFailed;
  public int reqHeight;
  public int reqWidth;
  public String roamingType;
  private String uin;
  
  public PicEmoticonInfo(String paramString)
  {
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.mDefault = paramString.getDrawable(2130838049);
      this.mFailed = paramString.getDrawable(2130843819);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  private static void asyncStartH5MagicPlayActivity(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    ThreadManager.post(new PicEmoticonInfo.5(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon), 5, null, true);
  }
  
  public static String getFictionPath(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  private void modifyDrawableByScreenSize()
  {
    if ((this.emoticon.extensionWidth == 0) || (this.emoticon.extensionHeight == 0) || ((this.mFIVE_INCH_DEFAULT == null) || (this.mFIVE_INCH_FAILED == null))) {}
    try
    {
      Resources localResources = BaseApplication.getContext().getResources();
      this.mFIVE_INCH_DEFAULT = localResources.getDrawable(2130847121);
      this.mFIVE_INCH_FAILED = localResources.getDrawable(2130847122);
      this.mDefault = this.mFIVE_INCH_DEFAULT;
      this.mFailed = this.mFIVE_INCH_FAILED;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
  }
  
  public static void send(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      bhpl.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send emotion + 1:emotion == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "emotion mall,epid=" + paramEmoticon.epId + ";jobtype=" + paramEmoticon.jobType);
    }
    if (paramEmoticon.isNewSoundEmoticon()) {
      awyr.a(paramQQAppInterface, "0X800A932", paramSessionInfo.curType, paramEmoticon.epId);
    }
    if ((paramEmoticon.jobType == 2) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      sendMagicEmoticon(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    if ((paramEmoticon.jobType == 4) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      sendH5MagicEmoticon(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    sendStickerMsg(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void sendH5MagicEmoticon(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    Object localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (asih)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId, 0, new PicEmoticonInfo.4(paramContext, paramQQAppInterface, paramEmoticon, (asih)localObject, paramSessionInfo));
    sendStickerMsg(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void sendMagicEmoticon(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    asih localasih = (asih)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
    bdla.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
    ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramEmoticon.epId, -1, new PicEmoticonInfo.3(paramContext, paramQQAppInterface, paramEmoticon, localasih, paramSessionInfo, paramStickerInfo));
  }
  
  private static void sendStickerMsg(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    admh.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
    paramSessionInfo = "";
    int j = -1;
    paramContext = ((FragmentActivity)paramContext).getChatFragment();
    int i = j;
    if (paramContext != null)
    {
      paramContext = paramContext.a().getEmoPanel();
      i = j;
      if (paramContext != null) {
        i = paramContext.getEmoticonTab(paramEmoticon.epId);
      }
    }
    paramContext = paramSessionInfo;
    if (i >= 0) {
      paramContext = Integer.toString(i);
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
  }
  
  public static void startSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    Object localObject;
    if (paramURLDrawable != null)
    {
      localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject == null) || (!(localObject instanceof VoiceGifImage))) {
          break label73;
        }
        ((VoiceGifImage)localObject).stop();
        ((VoiceGifImage)localObject).start();
        paramURLDrawable.invalidateSelf();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
        }
      }
    }
    label73:
    do
    {
      do
      {
        return;
      } while ((localObject == null) || (!(localObject instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)localObject).stop();
      ((VoiceGifImageV2)localObject).start();
      paramURLDrawable.invalidateSelf();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
  }
  
  public static void stopSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImage))) {
          break label62;
        }
        ((VoiceGifImage)paramURLDrawable).stop();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
        }
      }
    }
    label62:
    do
    {
      do
      {
        return;
      } while ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)paramURLDrawable).stop();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
  }
  
  private void tryApng(QQAppInterface paramQQAppInterface, URL paramURL, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      if ((paramEmoticonPackage == null) && (!paramBoolean) && (this.emoticon != null) && (!(paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        paramURL = paramURL.toString();
        paramQQAppInterface.a(this.emoticon.epId, new PicEmoticonInfo.1(this, paramURL));
      }
    }
  }
  
  public URLDrawable getAioPreviewDrawable()
  {
    Object localObject4 = null;
    Object localObject1;
    if (this.emoticon == null) {
      localObject1 = localObject4;
    }
    for (;;)
    {
      return localObject1;
      String str = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      localObject1 = localObject4;
      if (str == null) {
        continue;
      }
      try
      {
        localObject3 = new URL("emotion_pic", "fromAIO", getFictionPath(this.emoticon));
        localObject1 = localObject4;
        if (localObject3 == null) {
          continue;
        }
        modifyDrawableByScreenSize();
        localObject3 = URLDrawable.getDrawable((URL)localObject3, this.mDefault, this.mFailed, false);
        localObject1 = localObject3;
        if (((URLDrawable)localObject3).getStatus() == 1) {
          continue;
        }
        ((URLDrawable)localObject3).setTag(this.emoticon);
        ((URLDrawable)localObject3).addHeader("my_uin", this.uin);
        localObject1 = localObject3;
        if (!FileUtil.isFileExists(str)) {
          continue;
        }
        try
        {
          ((URLDrawable)localObject3).downloadImediatly();
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localObject3;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.drawableId);
        return localObject3;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
        }
      }
    }
  }
  
  public URLDrawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getLoadingDrawable("fromAIO", true);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    if (this.emoticon != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", getFictionPath(this.emoticon));
        if (paramContext != null)
        {
          ColorDrawable localColorDrawable = this.mEmptyDrawable;
          if (this.mFailed != null)
          {
            localObject = this.mFailed;
            paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
            paramContext.setTag(this.emoticon);
            paramContext.addHeader("my_uin", this.uin);
            return paramContext;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
            continue;
            localObject = this.mEmptyDrawable;
          }
        }
      }
    }
    return this.mDefault;
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 1;
  }
  
  public URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean)
  {
    return getLoadingDrawable(paramString, paramBoolean, false, null);
  }
  
  public URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, ahbj paramahbj)
  {
    if (this.emoticon == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new URL("emotion_pic", paramString, getFictionPath(this.emoticon));
        if (paramString == null) {
          continue;
        }
        modifyDrawableByScreenSize();
        localObject1 = this.mDefault;
        localObject1 = this.mFailed;
        if (paramahbj != null)
        {
          localObject1 = paramahbj.e.getDrawable();
          paramahbj = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramahbj instanceof QQAppInterface))
          {
            paramahbj = (QQAppInterface)paramahbj;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mDefault;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramahbj != null)
            {
              localObject1 = (awyr)paramahbj.getManager(QQManagerFactory.EMOTICON_MANAGER);
              if (this.emoticon != null)
              {
                localObject1 = ((awyr)localObject1).b(this.emoticon.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.isAPNG) || (this.emoticon.isAPNG))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                  }
                  ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                  paramBoolean1 = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.emoticon.extensionWidth;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.emoticon.extensionHeight;
                  localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                  if (((URLDrawable)localObject2).getStatus() != 1)
                  {
                    ((URLDrawable)localObject2).setTag(this.emoticon);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.uin);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.imageType));
                    if (paramBoolean2)
                    {
                      ((URLDrawable)localObject2).addHeader("2g_use_gif", "true");
                      if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
                        ((URLDrawable)localObject2).restartDownload();
                      }
                      return localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
          continue;
          tryApng(paramahbj, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
          continue;
          paramBoolean1 = false;
          continue;
          Object localObject1 = null;
          continue;
          paramahbj = null;
        }
      }
    }
  }
  
  public URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, ahbj paramahbj, int paramInt1, int paramInt2)
  {
    if (this.emoticon == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = new URL("emotion_pic", paramString, getFictionPath(this.emoticon));
        if (paramString == null) {
          continue;
        }
        modifyDrawableByScreenSize();
        localObject1 = this.mDefault;
        localObject1 = this.mFailed;
        if (paramahbj != null)
        {
          localObject1 = paramahbj.e.getDrawable();
          paramahbj = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramahbj instanceof QQAppInterface))
          {
            paramahbj = (QQAppInterface)paramahbj;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mDefault;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramahbj != null)
            {
              localObject1 = (awyr)paramahbj.getManager(QQManagerFactory.EMOTICON_MANAGER);
              if (this.emoticon != null)
              {
                localObject1 = ((awyr)localObject1).b(this.emoticon.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.isAPNG) || (this.emoticon.isAPNG))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                  }
                  ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                  paramBoolean1 = true;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.reqWidth;
                  ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.reqHeight;
                  localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                  if (((URLDrawable)localObject2).getStatus() != 1)
                  {
                    ((URLDrawable)localObject2).setTag(this.emoticon);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.uin);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.imageType));
                    if (paramBoolean2)
                    {
                      ((URLDrawable)localObject2).addHeader("2g_use_gif", "true");
                      if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
                        ((URLDrawable)localObject2).restartDownload();
                      }
                      return localObject2;
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
          continue;
          tryApng(paramahbj, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
          continue;
          paramBoolean1 = false;
          continue;
          Object localObject1 = null;
          continue;
          paramahbj = null;
        }
      }
    }
  }
  
  public String getPath()
  {
    return "";
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  public int getVoiceLength()
  {
    return 0;
  }
  
  public int getWaveBackgroundColor()
  {
    if ((this.emoticon != null) && (this.emoticon.backColor != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR;
      if (i == 0) {
        return j;
      }
      try
      {
        i = Color.parseColor(this.emoticon.backColor);
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return j;
  }
  
  public int getWaveForegroundColor()
  {
    if ((this.emoticon != null) && (this.emoticon.volumeColor != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR;
      if (i == 0) {
        return j;
      }
      try
      {
        i = Color.parseColor(this.emoticon.volumeColor);
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return j;
  }
  
  public int[] getWaveformArray()
  {
    if ((this.emoticon != null) && (this.emoticon.parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty()))
    {
      int[] arrayOfInt = new int[this.emoticon.parseSoundPrintString().size()];
      int i = 0;
      while (i < this.emoticon.parseSoundPrintString().size())
      {
        arrayOfInt[i] = ((Integer)this.emoticon.parseSoundPrintString().get(i)).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public boolean isAioPreviewExists()
  {
    boolean bool = true;
    if (this.emoticon == null) {
      return false;
    }
    Object localObject;
    if (this.emoticon.jobType == 1)
    {
      localObject = EmoticonUtils.emoticonPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      label52:
      if (localObject == null) {
        break label112;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label114;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      break label52;
      label112:
      break;
      label114:
      bool = false;
    }
  }
  
  public boolean isBigImageExists()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.emoticon == null) || (this.emoticon.jobType == 1))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((this.emoticon.isSound) && (bool1))
      {
        localObject = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
        if (localObject == null) {
          break label165;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists())
        {
          bool1 = bool2;
          if (((File)localObject).isFile()) {
            break;
          }
        }
        return false;
        bool1 = false;
        continue;
      }
      return bool1;
      label165:
      return false;
      bool1 = false;
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isNewSoundType()
  {
    return (this.emoticon != null) && (this.emoticon.parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty());
  }
  
  public boolean isSound()
  {
    return (this.emoticon != null) && (this.emoticon.isSound);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    send(paramQQAppInterface, paramContext, paramSessionInfo, this.emoticon, this.stickerInfo);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    send(paramQQAppInterface, paramContext, paramEditText, paramSessionInfo, paramBoolean, 0);
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    if (this.emoticon == null)
    {
      bhpl.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send isFroward emotion = null");
    }
    label228:
    label362:
    label380:
    do
    {
      do
      {
        return;
        paramEditText = (asih)paramQQAppInterface.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER);
        if ((this.emoticon.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!awsw.a())) {
          break label228;
        }
        if (paramEditText.a(this.emoticon.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.a(paramContext, 2131689959, 0);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      paramQQAppInterface.obtainMessage(21).sendToTarget();
      return;
      paramInt = awsf.a(this.emoticon, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "forward,【maxInt:】" + paramInt);
      }
      paramInt = awrh.a(paramInt);
      ((awyr)paramQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.emoticon.epId, new PicEmoticonInfo.2(this, paramQQAppInterface, paramInt, paramContext, paramSessionInfo));
      return;
      if ((this.emoticon.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramEditText.b(this.emoticon.epId, true, true)) {
          break label380;
        }
        if (!paramEditText.b()) {
          break label362;
        }
        asyncStartH5MagicPlayActivity(paramContext, paramQQAppInterface, paramSessionInfo, this.emoticon);
      }
      for (;;)
      {
        admh.a(paramQQAppInterface, paramContext, paramSessionInfo, this.emoticon, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.a(paramContext, 2131689959, 0);
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    if (this.emoticon != null) {
      return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", new Object[] { this.emoticon.name, this.emoticon.eId, this.emoticon.epId });
    }
    return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */