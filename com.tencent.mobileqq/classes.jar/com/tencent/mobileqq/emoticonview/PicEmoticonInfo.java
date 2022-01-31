package com.tencent.mobileqq.emoticonview;

import acok;
import acol;
import acon;
import acop;
import acoq;
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
import com.tencent.image.ApngDrawable;
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
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasApngUtil;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837571);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130841377);
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
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(2130844025);
      this.d = localResources.getDrawable(2130844026);
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
  
  private void a(QQAppInterface paramQQAppInterface, URL paramURL, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (EmoticonManager)paramQQAppInterface.getManager(13);
      if ((paramEmoticonPackage == null) && (!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (!(paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        paramURL = paramURL.toString();
        paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new acok(this, paramURL));
      }
    }
  }
  
  private static void b(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    ThreadManager.post(new acoq(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon), 5, null, true);
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
    ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId, -1, new acon(paramContext, paramQQAppInterface, paramEmoticon, localEmojiManager, paramSessionInfo, paramStickerInfo));
  }
  
  private static void e(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    Object localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
    localObject = (EmojiManager)paramQQAppInterface.getManager(42);
    ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId, 0, new acop(paramContext, paramQQAppInterface, paramEmoticon, (EmojiManager)localObject, paramSessionInfo));
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return null;
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
          localObject1 = paramHolder.e.getDrawable();
          paramHolder = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramHolder instanceof QQAppInterface))
          {
            paramHolder = (QQAppInterface)paramHolder;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramHolder != null)
            {
              localObject1 = (EmoticonManager)paramHolder.getManager(13);
              if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
              {
                localObject1 = ((EmoticonManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG)) {
                  if (VasApngUtil.b.get())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                    }
                    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                    ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                    paramBoolean1 = true;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight;
                    localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                    if (((URLDrawable)localObject2).getStatus() == 1) {
                      break label425;
                    }
                    ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.f));
                    if (!paramBoolean2) {
                      break label411;
                    }
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
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          if (!VasApngUtil.b())
          {
            if (paramHolder != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PicEmoticonInfo", 2, "getBigDrawable: restartDownload so");
              }
              VasApngUtil.a(paramHolder, "PicEmoticonInfo");
              paramBoolean1 = false;
            }
          }
          else {
            VasApngUtil.a();
          }
          paramBoolean1 = false;
          continue;
          label411:
          ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
          continue;
          label425:
          a(paramHolder, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
          continue;
          Object localObject1 = null;
          continue;
          paramHolder = null;
        }
      }
    }
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, MarketFaceItemBuilder.Holder paramHolder, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {}
    for (;;)
    {
      return null;
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
          localObject1 = paramHolder.e.getDrawable();
          paramHolder = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramHolder instanceof QQAppInterface))
          {
            paramHolder = (QQAppInterface)paramHolder;
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            if (paramHolder != null)
            {
              localObject1 = (EmoticonManager)paramHolder.getManager(13);
              if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
              {
                localObject1 = ((EmoticonManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, 0);
                if (((localObject1 != null) && (((EmoticonPackage)localObject1).isAPNG == 2)) || (this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isAPNG)) {
                  if (VasApngUtil.b.get())
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
                    }
                    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
                    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = false;
                    ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "useAPNG";
                    paramBoolean1 = true;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_Int;
                    localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject2);
                    if (((URLDrawable)localObject2).getStatus() == 1) {
                      break label414;
                    }
                    ((URLDrawable)localObject2).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
                    ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_c_of_type_JavaLangString);
                    ((URLDrawable)localObject2).addHeader("emo_type", String.valueOf(this.f));
                    if (!paramBoolean2) {
                      break label400;
                    }
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
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
          paramString = null;
          continue;
          if (!VasApngUtil.b())
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicEmoticonInfo", 2, "getBigDrawable: restartDownload so");
            }
            VasApngUtil.a(paramHolder, "PicEmoticonInfo");
            paramBoolean1 = false;
          }
          else
          {
            VasApngUtil.a();
            paramBoolean1 = false;
            continue;
            label400:
            ((URLDrawable)localObject2).addHeader("2g_use_gif", "false");
            continue;
            label414:
            a(paramHolder, paramString, (EmoticonPackage)localObject1, paramBoolean1, (URLDrawable)localObject2);
            continue;
            localObject1 = null;
            continue;
            paramHolder = null;
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
    label360:
    label378:
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
        ChatActivityUtils.a(paramContext, 2131436327, 0);
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
      ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, new acol(this, paramQQAppInterface, i, paramContext, paramSessionInfo));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.getCurrentAccountUin(), 0);
        if (localSharedPreferences != null) {
          localSharedPreferences.edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).apply();
        }
        if (!paramEditText.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true, true)) {
          break label378;
        }
        if (!paramEditText.b()) {
          break label360;
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
      ChatActivityUtils.a(paramContext, 2131436327, 0);
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