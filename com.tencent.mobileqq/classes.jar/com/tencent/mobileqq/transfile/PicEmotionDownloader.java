package com.tencent.mobileqq.transfile;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.VoiceGifFactory;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.http.Header;

public class PicEmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private BitmapFactory.Options a;
  protected BaseApplicationImpl a;
  
  public PicEmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inDensity = 320;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inTargetDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inScreenDensity = paramBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Bitmap a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Bitmap localBitmap = null;
    String str;
    if (paramBoolean1) {
      str = EmoticonUtils.q.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    while (!TextUtils.isEmpty(str))
    {
      Object localObject1;
      if (new File(str).exists())
      {
        paramString2 = localBitmap;
        localObject1 = localObject2;
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(str);
          paramString2 = localBitmap;
          localObject1 = localObject2;
          localBitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          paramString1 = localBitmap;
          if (paramBoolean2)
          {
            paramString2 = localBitmap;
            localObject1 = localBitmap;
            paramString1 = ImageUtil.a(localBitmap);
          }
          paramString2 = paramString1;
          localObject1 = paramString1;
          localFileInputStream.close();
          return paramString1;
        }
        catch (OutOfMemoryError paramString1)
        {
          QLog.e("PicEmotionDownloader", 1, "decode oom11 :path = " + str);
          return paramString2;
        }
        catch (Exception paramString1)
        {
          QLog.e("PicEmotionDownloader", 1, "decode exception :path = " + str, paramString1);
          return localObject1;
        }
        str = EmoticonUtils.p.replace("[epId]", paramString1).replace("[eId]", paramString2);
        continue;
      }
      QLog.e("PicEmotionDownloader", 1, "getAIOPreviewBitmap path is not exits! " + str);
      return null;
    }
    return null;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| useGifAnimation=" + paramDownloadParams.useGifAnimation + " url.toString=" + paramDownloadParams.url.toString());
    }
    if (!(paramDownloadParams.tag instanceof Emoticon)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    Emoticon localEmoticon = (Emoticon)paramDownloadParams.tag;
    paramURLDrawableHandler = paramDownloadParams.getHeader("my_uin");
    paramOutputStream = null;
    if (paramURLDrawableHandler != null) {
      paramOutputStream = paramURLDrawableHandler.getValue();
    }
    if (TextUtils.isEmpty(paramOutputStream))
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| uin is null");
      throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| myUin:" + paramOutputStream);
    }
    Bundle localBundle;
    try
    {
      paramURLDrawableHandler = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
      if (paramURLDrawableHandler == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage app is null");
        }
        throw new FileDownloadFailedException(9301, 0L, "qqAppInterface is null", false, false);
      }
    }
    catch (Throwable paramOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "exception:" + paramOutputStream.getMessage());
      }
      paramOutputStream = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (i = 4;; i = 0)
      {
        paramOutputStream = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
        paramURLDrawableHandler = (AppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramOutputStream);
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "downloadImage| a second time: uin->" + paramOutputStream);
        }
        break;
      }
      localBundle = new Bundle();
      paramDownloadParams.tag = localBundle;
      localBundle.putSerializable("emoticon_key", localEmoticon);
      if ((paramURLDrawableHandler instanceof QQAppInterface)) {
        break label527;
      }
    }
    if (localEmoticon.jobType == 3)
    {
      paramOutputStream = new String[2];
      paramOutputStream[0] = EmoticonUtils.d.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
      paramOutputStream[1] = EmoticonUtils.p.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
      i = DownloaderFactory.a(new DownloadTask(paramOutputStream[0], new File(paramOutputStream[1])), paramURLDrawableHandler);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmotionDownloader", 2, "download small emoji, ret:" + i);
      }
    }
    return new File(AppConstants.aJ);
    label527:
    paramOutputStream = paramDownloadParams.getHeader("emo_type");
    boolean bool2 = EmoticonUtils.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (paramOutputStream != null) {
        bool2 = paramOutputStream.getValue().equals(String.valueOf(2));
      }
      paramOutputStream = paramDownloadParams.getHeader("emo_big");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (paramOutputStream != null) {
          bool1 = paramOutputStream.getValue().equals("true");
        }
      }
    }
    if (localEmoticon.jobType == 3) {}
    for (int i = 2;; i = 1)
    {
      paramOutputStream = paramDownloadParams.url.getHost();
      if (paramOutputStream != null) {
        break;
      }
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    if (paramOutputStream.equals("fromPanel"))
    {
      i = 2;
      paramOutputStream = "panel_preview";
    }
    for (;;)
    {
      paramDownloadParams = paramDownloadParams.getHeader("2g_use_gif");
      bool1 = false;
      if (paramDownloadParams != null) {
        bool1 = paramDownloadParams.getValue().equals("true");
      }
      if (bool1)
      {
        localBundle.putString("display_type", "big_img");
        if (localEmoticon.jobType == 3)
        {
          i = 6;
          label738:
          paramOutputStream = (EmojiManager)paramURLDrawableHandler.getManager(42);
          if (paramOutputStream.b(localEmoticon, i)) {
            break label1011;
          }
        }
      }
      label1011:
      for (bool1 = true;; bool1 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "need download:" + bool1);
        }
        if (!bool1) {
          break;
        }
        bool1 = paramOutputStream.a(localEmoticon, i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.emoji.EmoDown", 2, "downloadImage| downloadAIOEmoticon result=" + bool1 + " eId: " + localEmoticon.eId);
        }
        if (bool1) {
          break;
        }
        QLog.e("PicEmotionDownloader", 1, "emotion down fail : epid = " + localEmoticon.epId + ";eid = " + localEmoticon.eId);
        throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
        if ((!paramOutputStream.equals("fromAIO")) || (!bool1)) {
          break label1024;
        }
        if (localEmoticon.jobType == 3) {
          i = 2;
        }
        if (paramDownloadParams.useApngImage) {
          i |= 0x20;
        }
        for (;;)
        {
          if (!localEmoticon.isSound) {
            break label1017;
          }
          paramOutputStream = "big_sound";
          i = 12;
          break;
          i |= 0x4;
        }
        i = 4;
        break label738;
        localBundle.putString("display_type", paramOutputStream);
        break label738;
      }
      label1017:
      paramOutputStream = "big_img";
      continue;
      label1024:
      paramOutputStream = "aio_preview";
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
    }
    if (!(paramDownloadParams.tag instanceof Bundle)) {
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    Bundle localBundle = (Bundle)paramDownloadParams.tag;
    Emoticon localEmoticon = (Emoticon)localBundle.getSerializable("emoticon_key");
    paramURLDrawableHandler = paramDownloadParams.url.getHost();
    if (paramURLDrawableHandler == null)
    {
      QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
      throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
    }
    if (paramURLDrawableHandler.equals("fromPanel"))
    {
      paramFile = paramDownloadParams.url.getFile();
      if ((TextUtils.isEmpty(paramFile)) || (!paramFile.endsWith("_panel_magic_gray"))) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      paramFile = localBundle.getString("display_type");
      boolean bool3 = paramURLDrawableHandler.equals("fromAIO");
      if ((bool3) && (paramFile.equals("aio_preview")) && (new File(EmoticonUtils.s.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId)).exists())) {
        if (localEmoticon.isSound) {
          paramFile = "big_sound";
        }
      }
      for (;;)
      {
        int i = localEmoticon.jobType;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmotionDownloader", 2, "showType: " + paramFile);
        }
        if (("big_img".equals(paramFile)) || ("big_sound".equals(paramFile)))
        {
          switch (i)
          {
          case 1: 
          default: 
            if (QLog.isColorLevel()) {
              QLog.d("PicEmotionDownloader", 2, "decodeFile jobType not supported: " + i);
            }
            paramFile = null;
          case 2: 
          case 4: 
            do
            {
              do
              {
                return paramFile;
                paramFile = "big_img";
                break;
                localBundle.putString("display_type", paramFile);
                paramFile = new File(EmoticonUtils.s.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId));
                if (paramFile.exists()) {
                  break label464;
                }
                paramDownloadParams = a(localEmoticon.epId, localEmoticon.eId, bool3, bool1);
                paramFile = paramDownloadParams;
              } while (paramDownloadParams == null);
              paramFile = paramDownloadParams;
            } while (!bool3);
            localBundle.putString("display_type", "aio_preview");
            return paramDownloadParams;
            label464:
            paramFile = NativeGifFactory.getNativeGifObject(paramFile, true, true, 0, 0, 0.0F);
            paramFile.setDensity(320);
            return paramFile;
          }
          localBundle.putString("display_type", paramFile);
          paramURLDrawableHandler = EmoticonUtils.s.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
          if (!paramDownloadParams.useApngImage) {
            break label1094;
          }
          paramURLDrawableHandler = EmoticonUtils.t.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
        }
        label1083:
        label1089:
        label1094:
        for (;;)
        {
          boolean bool2;
          if (!new File(paramURLDrawableHandler).exists())
          {
            paramFile = localEmoticon.epId;
            paramDownloadParams = localEmoticon.eId;
            if ((i != 3) && (bool3)) {}
            for (bool2 = true;; bool2 = false)
            {
              paramDownloadParams = a(paramFile, paramDownloadParams, bool2, bool1);
              paramFile = paramDownloadParams;
              if (paramDownloadParams == null) {
                break;
              }
              paramFile = paramDownloadParams;
              if (!bool3) {
                break;
              }
              localBundle.putString("display_type", "aio_preview");
              return paramDownloadParams;
            }
          }
          for (;;)
          {
            try
            {
              if (EmosmUtils.b(paramURLDrawableHandler))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PicEmotionDownloader", 2, "decodeFile isGifFile,path=" + paramURLDrawableHandler);
                }
                paramURLDrawableHandler = new File(paramURLDrawableHandler);
                if ("big_img".equals(paramFile))
                {
                  paramDownloadParams = NativeGifFactory.getNativeGifObject(paramURLDrawableHandler, true, true, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, 0.0F);
                  paramFile = paramDownloadParams;
                  if (paramDownloadParams == null) {
                    break;
                  }
                  paramDownloadParams.setDensity(320);
                  return paramDownloadParams;
                }
              }
            }
            catch (FileNotFoundException paramFile)
            {
              QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
              return null;
              if (!"big_sound".equals(paramFile)) {
                break label1089;
              }
              paramDownloadParams = VoiceGifFactory.a(paramURLDrawableHandler, 0, true);
              continue;
              if (paramDownloadParams.useApngImage)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PicEmotionDownloader", 2, "decodeFile isAPNGFile, path = " + paramURLDrawableHandler);
                }
                paramURLDrawableHandler = new File(paramURLDrawableHandler);
                if ((paramDownloadParams != null) && ((paramDownloadParams.mExtraInfo instanceof Bundle)))
                {
                  paramFile = (Bundle)paramDownloadParams.mExtraInfo;
                  paramFile.putInt("key_decryptType", ApngImage.DECRYPTTYPE_DECRYPT);
                  paramDownloadParams = new ApngImage(paramURLDrawableHandler, true, paramFile);
                  paramFile = paramDownloadParams;
                  if (paramDownloadParams == null) {
                    break;
                  }
                  paramDownloadParams.setDensity(320);
                  return paramDownloadParams;
                }
              }
            }
            catch (IOException paramFile)
            {
              QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
              continue;
              paramFile = new Bundle();
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("PicEmotionDownloader", 2, "decodeFile getDecryptFileData,path=" + paramURLDrawableHandler);
              }
              paramFile = EmosmUtils.b(paramURLDrawableHandler);
              if (paramFile == null) {
                continue;
              }
              paramDownloadParams = null;
              try
              {
                paramFile = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
                paramDownloadParams = paramFile;
              }
              catch (OutOfMemoryError paramFile)
              {
                QLog.e("emoticon", 1, "decode oom path = " + paramURLDrawableHandler);
                continue;
              }
              paramFile = paramDownloadParams;
              if (paramDownloadParams != null) {
                break;
              }
              QLog.e("PicEmotionDownloader", 2, "decode MARKET File:file error" + paramURLDrawableHandler);
              return null;
            }
            catch (Exception paramFile)
            {
              QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramFile);
              continue;
            }
            if (bool3)
            {
              paramFile = "aio_preview";
              localBundle.putString("display_type", paramFile);
              if ((!bool3) || (i == 1) || (i == 3)) {
                break label1083;
              }
            }
            for (bool2 = true;; bool2 = false)
            {
              return a(localEmoticon.epId, localEmoticon.eId, bool2, bool1);
              paramFile = "panel_preview";
              break;
            }
            paramDownloadParams = null;
          }
        }
      }
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */