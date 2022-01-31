package com.tencent.mobileqq.emoticonview;

import abzh;
import abzj;
import abzl;
import abzm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class PicEmoticonInfo
  extends EmoticonInfo
{
  public int a;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Emoticon a;
  public boolean a;
  public int b;
  private Drawable b;
  public boolean b;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_c_of_type_JavaLangString;
  private Drawable d;
  public int f;
  
  public PicEmoticonInfo(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837572);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130841313);
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
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight == 0) || ((this.jdField_c_of_type_AndroidGraphicsDrawableDrawable == null) || (this.d == null))) {}
    try
    {
      Resources localResources = BaseApplication.getContext().getResources();
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(2130843835);
      this.d = localResources.getDrawable(2130843836);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.d;
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
  
  public static void a(URLDrawable paramURLDrawable)
  {
    Object localObject;
    if (paramURLDrawable != null)
    {
      localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject == null) || (!(localObject instanceof VoiceGifImage))) {
          break label72;
        }
        ((VoiceGifImage)localObject).b();
        ((VoiceGifImage)localObject).a();
        paramURLDrawable.invalidateSelf();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
        }
      }
    }
    label72:
    do
    {
      do
      {
        return;
      } while ((localObject == null) || (!(localObject instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)localObject).b();
      ((VoiceGifImageV2)localObject).a();
      paramURLDrawable.invalidateSelf();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (paramEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send emotion + 1:emotion == null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmoticonInfo", 2, "emotion mall,epid=" + paramEmoticon.epId + ";jobtype=" + paramEmoticon.jobType);
    }
    if ((paramEmoticon.jobType == 2) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      d(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    if ((paramEmoticon.jobType == 4) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
    {
      e(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
      return;
    }
    c(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  private static void b(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    ThreadManager.post(new abzm(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon), 5, null, true);
  }
  
  public static void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImage))) {
          break label61;
        }
        ((VoiceGifImage)paramURLDrawable).b();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
        }
      }
    }
    label61:
    do
    {
      do
      {
        return;
      } while ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)paramURLDrawable).b();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
    paramSessionInfo = "";
    if (((FragmentActivity)paramContext).getChatFragment().a().a() != null) {}
    for (int i = ((FragmentActivity)paramContext).getChatFragment().a().a().a(paramEmoticon.epId);; i = -1)
    {
      paramContext = paramSessionInfo;
      if (i >= 0) {
        paramContext = Integer.toString(i);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
      return;
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    EmojiManager localEmojiManager = (EmojiManager)paramQQAppInterface.getManager(42);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
    ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId, -1, new abzj(paramContext, paramQQAppInterface, paramEmoticon, localEmojiManager, paramSessionInfo, paramStickerInfo));
  }
  
  private static void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    Object localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (EmojiManager)paramQQAppInterface.getManager(42);
    ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId, 0, new abzl(paramContext, paramQQAppInterface, paramEmoticon, (EmojiManager)localObject, paramSessionInfo));
    c(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon, paramStickerInfo);
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        if (paramContext != null)
        {
          ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
            paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
            paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
            paramContext.addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
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
            localObject = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          }
        }
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public URLDrawable a()
  {
    Object localObject4 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      localObject1 = localObject4;
    }
    for (;;)
    {
      return localObject1;
      String str = EmoticonUtils.q.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject1 = localObject4;
      if (str == null) {
        continue;
      }
      try
      {
        localObject3 = new URL("emotion_pic", "fromAIO", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        localObject1 = localObject4;
        if (localObject3 == null) {
          continue;
        }
        a();
        localObject3 = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, false);
        localObject1 = localObject3;
        if (((URLDrawable)localObject3).getStatus() == 1) {
          continue;
        }
        ((URLDrawable)localObject3).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        ((URLDrawable)localObject3).addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
        localObject1 = localObject3;
        if (!FileUtil.a(str)) {
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
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.e);
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
  
  public URLDrawable a(Context paramContext, float paramFloat)
  {
    return a("fromAIO", true);
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, false, null);
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, MarketFaceItemBuilder.Holder paramHolder)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      try
      {
        paramString = new URL("emotion_pic", paramString, a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        if (paramString == null) {
          continue;
        }
        a();
        localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (paramHolder != null)
        {
          paramHolder = paramHolder.e.getDrawable();
          localObject1 = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)localObject1;
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mFailedDrawable = paramHolder;
            localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            localURLDrawableOptions.mPlayGifImage = true;
            paramHolder = localObject2;
            if (localObject1 != null)
            {
              EmoticonManager localEmoticonManager = (EmoticonManager)((QQAppInterface)localObject1).getManager(13);
              paramHolder = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
                paramHolder = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
              }
            }
            if (((paramHolder != null) && (paramHolder.isAPNG == 2)) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG))
            {
              if (ApngHandler.b.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                }
                localURLDrawableOptions.mUseApngImage = true;
                localURLDrawableOptions.mPlayGifImage = false;
                localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
              }
            }
            else
            {
              localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth;
              localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight;
              paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
              localObject1 = paramString;
              if (paramString.getStatus() == 1) {
                continue;
              }
              paramString.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
              paramString.addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
              paramString.addHeader("emo_type", String.valueOf(this.f));
              if (!paramBoolean2) {
                break label440;
              }
              paramString.addHeader("2g_use_gif", "true");
              if (paramString.getStatus() != 2)
              {
                localObject1 = paramString;
                if (paramString.getStatus() != 3) {
                  continue;
                }
              }
              paramString.restartDownload();
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          if (!ApngHandler.c())
          {
            if (localObject1 != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PicEmoticonInfo", 2, "getBigDrawable: restartDownload so");
              }
              paramHolder = (ApngHandler)((EarlyDownloadManager)((QQAppInterface)localObject1).getManager(76)).a("qq.android.native.apng_v700");
              if (paramHolder != null) {
                paramHolder.a(true);
              }
            }
          }
          else
          {
            ApngHandler.d_();
            continue;
            label440:
            paramString.addHeader("2g_use_gif", "false");
            continue;
            localObject1 = null;
            continue;
            paramHolder = (MarketFaceItemBuilder.Holder)localObject1;
          }
        }
      }
    }
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, MarketFaceItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return localObject1;
      try
      {
        paramString = new URL("emotion_pic", paramString, a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        if (paramString == null) {
          continue;
        }
        a();
        localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if (paramHolder != null)
        {
          paramHolder = paramHolder.e.getDrawable();
          localObject1 = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)localObject1;
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mFailedDrawable = paramHolder;
            localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            localURLDrawableOptions.mPlayGifImage = true;
            paramHolder = localObject2;
            if (localObject1 != null)
            {
              EmoticonManager localEmoticonManager = (EmoticonManager)((QQAppInterface)localObject1).getManager(13);
              paramHolder = localObject2;
              if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
                paramHolder = localEmoticonManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
              }
            }
            if (((paramHolder != null) && (paramHolder.isAPNG == 2)) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG))
            {
              if (ApngHandler.b.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                }
                localURLDrawableOptions.mUseApngImage = true;
                localURLDrawableOptions.mPlayGifImage = false;
                localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
              }
            }
            else
            {
              localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
              localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
              paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
              localObject1 = paramString;
              if (paramString.getStatus() == 1) {
                continue;
              }
              paramString.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
              paramString.addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
              paramString.addHeader("emo_type", String.valueOf(this.f));
              if (!paramBoolean2) {
                break label429;
              }
              paramString.addHeader("2g_use_gif", "true");
              if (paramString.getStatus() != 2)
              {
                localObject1 = paramString;
                if (paramString.getStatus() != 3) {
                  continue;
                }
              }
              paramString.restartDownload();
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          if (!ApngHandler.c())
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicEmoticonInfo", 2, "getBigDrawable: restartDownload so");
            }
            paramHolder = (ApngHandler)((EarlyDownloadManager)((QQAppInterface)localObject1).getManager(76)).a("qq.android.native.apng_v700");
            if (paramHolder != null) {
              paramHolder.a(true);
            }
          }
          else
          {
            ApngHandler.d_();
            continue;
            label429:
            paramString.addHeader("2g_use_gif", "false");
            continue;
            localObject1 = null;
            continue;
            paramHolder = (MarketFaceItemBuilder.Holder)localObject1;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send isFroward emotion = null");
    }
    label226:
    label359:
    label377:
    do
    {
      do
      {
        return;
        paramEditText = (EmojiManager)paramQQAppInterface.getManager(42);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!MagicfaceViewController.a())) {
          break label226;
        }
        if (paramEditText.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.a(paramContext, 2131436290, 0);
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      paramQQAppInterface.obtainMessage(21).sendToTarget();
      return;
      int i = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "forward,【maxInt:】" + i);
      }
      i = PngFrameUtil.a(i);
      ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new abzh(this, paramQQAppInterface, i, paramContext, paramSessionInfo));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramEditText.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true, true)) {
          break label377;
        }
        if (!paramEditText.b()) {
          break label359;
        }
        b(paramContext, paramQQAppInterface, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      }
      for (;;)
      {
        ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.a(paramContext, 2131436290, 0);
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound);
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = EmoticonUtils.s.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (bool1))
      {
        localObject = EmoticonUtils.o.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
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
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmoticonUtils.p.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
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
      localObject = EmoticonUtils.q.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      break label52;
      label112:
      break;
      label114:
      bool = false;
    }
  }
  
  public String toString()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId });
    }
    return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */