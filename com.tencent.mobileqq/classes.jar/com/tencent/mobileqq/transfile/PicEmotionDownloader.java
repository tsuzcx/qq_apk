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
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticon.exception.FileDownloadFailedException;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.VoiceGifFactory;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;

public class PicEmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String KEY = "emoticon_key";
  private static final String TAG = "PicEmotionDownloader";
  protected MobileQQ application;
  private BitmapFactory.Options mOptions;
  
  public PicEmotionDownloader(MobileQQ paramMobileQQ)
  {
    this.application = paramMobileQQ;
    this.mOptions = new BitmapFactory.Options();
    BitmapFactory.Options localOptions = this.mOptions;
    localOptions.inDensity = 320;
    localOptions.inTargetDensity = paramMobileQQ.getResources().getDisplayMetrics().densityDpi;
    this.mOptions.inScreenDensity = paramMobileQQ.getResources().getDisplayMetrics().densityDpi;
  }
  
  private int configParams(DownloadParams paramDownloadParams, Emoticon paramEmoticon, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, Bundle paramBundle, String paramString)
  {
    Object localObject = paramDownloadParams.getHeader("emo_type");
    boolean bool2 = EmoticonPanelUtils.a();
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (localObject != null) {
        bool2 = ((Header)localObject).getValue().equals(String.valueOf(2));
      }
      localObject = paramDownloadParams.getHeader("emo_big");
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localObject != null) {
          bool1 = ((Header)localObject).getValue().equals("true");
        }
      }
    }
    int i;
    if (paramEmoticon.jobType == 3) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = paramDownloadParams.url.getHost();
    if (localObject != null)
    {
      if (((String)localObject).equals("fromPanel"))
      {
        paramString = "panel_preview";
        i = 2;
      }
      else if ((((String)localObject).equals("fromAIO")) && (bool1))
      {
        if (paramEmoticon.jobType == 3) {
          i = 2;
        }
        if (paramDownloadParams.useApngImage) {
          i |= 0x20;
        } else {
          i |= 0x4;
        }
        if (paramEmoticon.isSound)
        {
          paramString = "big_sound";
          i = 12;
        }
        else
        {
          paramString = "big_img";
        }
      }
      localObject = paramDownloadParams.getHeader("2g_use_gif");
      bool1 = false;
      if (localObject != null) {
        bool1 = ((Header)localObject).getValue().equals("true");
      }
      if (bool1)
      {
        paramBundle.putString("display_type", "big_img");
        if (paramEmoticon.jobType == 3) {
          i = 6;
        } else {
          i = 4;
        }
      }
      else
      {
        paramBundle.putString("display_type", paramString);
      }
      if (!paramDownloadParams.useApngImage)
      {
        paramEmoticon = ((EmoticonManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramEmoticon.epId);
        if ((paramEmoticon != null) && (paramEmoticon.isAPNG == 2)) {
          paramDownloadParams.useApngImage = true;
        }
      }
      return i;
    }
    QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
    throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
  }
  
  private Bitmap getAIOPreviewBitmap(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    } else {
      str = EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramString1).replace("[eId]", paramString2);
    }
    paramBoolean1 = TextUtils.isEmpty(str);
    Bitmap localBitmap = null;
    paramString1 = null;
    Object localObject;
    if (!paramBoolean1) {
      if (new File(str).exists())
      {
        paramString2 = paramString1;
        localObject = localBitmap;
      }
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(str);
      paramString2 = paramString1;
      localObject = localBitmap;
      localBitmap = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream), null, this.mOptions);
      paramString1 = localBitmap;
      if (paramBoolean2)
      {
        paramString2 = localBitmap;
        localObject = localBitmap;
        paramString1 = BaseImageUtil.a(localBitmap);
      }
      paramString2 = paramString1;
      localObject = paramString1;
      localFileInputStream.close();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decode exception :path = ");
      ((StringBuilder)localObject).append(str);
      QLog.e("PicEmotionDownloader", 1, ((StringBuilder)localObject).toString(), paramString1);
      return paramString2;
      paramString1 = new StringBuilder();
      paramString1.append("decode oom11 :path = ");
      paramString1.append(str);
      QLog.e("PicEmotionDownloader", 1, paramString1.toString());
      return localObject;
      paramString1 = new StringBuilder();
      paramString1.append("getAIOPreviewBitmap path is not exits! ");
      paramString1.append(str);
      QLog.e("PicEmotionDownloader", 1, paramString1.toString());
      return null;
    }
    catch (OutOfMemoryError paramString1)
    {
      label186:
      break label186;
    }
  }
  
  protected Object decodeApngImage(DownloadParams paramDownloadParams, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFile isAPNGFile, path = ");
      localStringBuilder.append(paramString);
      QLog.d("PicEmotionDownloader", 2, localStringBuilder.toString());
    }
    paramString = new File(paramString);
    if ((paramDownloadParams != null) && ((paramDownloadParams.mExtraInfo instanceof Bundle))) {
      paramDownloadParams = (Bundle)paramDownloadParams.mExtraInfo;
    } else {
      paramDownloadParams = new Bundle();
    }
    paramDownloadParams.putInt("key_decryptType", ApngImage.DECRYPTTYPE_DECRYPT);
    paramDownloadParams = new ApngImage(paramString, true, paramDownloadParams);
    paramDownloadParams.setDensity(320);
    return paramDownloadParams;
  }
  
  protected Object decodeBitmapFile(Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    String str = paramEmoticon.epId;
    paramEmoticon = paramEmoticon.eId;
    boolean bool;
    if ((paramInt != 3) && (paramBoolean2)) {
      bool = true;
    } else {
      bool = false;
    }
    paramEmoticon = getAIOPreviewBitmap(str, paramEmoticon, bool, paramBoolean1);
    if ((paramEmoticon != null) && (paramBoolean2)) {
      paramBundle.putString("display_type", "aio_preview");
    }
    return paramEmoticon;
  }
  
  protected Object decodeDecryptFileData(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, this.mOptions);
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label15:
      break label15;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("decode oom path = ");
    paramArrayOfByte.append(paramString);
    QLog.e("emoticon", 1, paramArrayOfByte.toString());
    paramArrayOfByte = null;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("decode MARKET File:file error");
      paramArrayOfByte.append(paramString);
      QLog.e("PicEmotionDownloader", 2, paramArrayOfByte.toString());
      return null;
    }
    return paramArrayOfByte;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      if ((paramDownloadParams.tag instanceof Bundle))
      {
        Bundle localBundle = (Bundle)paramDownloadParams.tag;
        Emoticon localEmoticon = (Emoticon)localBundle.getSerializable("emoticon_key");
        paramFile = paramDownloadParams.url.getHost();
        if (paramFile != null)
        {
          boolean bool1 = isGrayPic(paramDownloadParams, paramFile);
          paramURLDrawableHandler = localBundle.getString("display_type");
          boolean bool2 = paramFile.equals("fromAIO");
          paramFile = paramURLDrawableHandler;
          if (bool2)
          {
            paramFile = paramURLDrawableHandler;
            if (paramURLDrawableHandler.equals("aio_preview"))
            {
              paramFile = paramURLDrawableHandler;
              if (new File(EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId)).exists()) {
                if (localEmoticon.isSound) {
                  paramFile = "big_sound";
                } else {
                  paramFile = "big_img";
                }
              }
            }
          }
          return decodePicEmoticon(paramDownloadParams, localBundle, localEmoticon, bool1, paramFile, bool2);
        }
        QLog.d("PicEmotionDownloader", 2, "downloadImage| host is null");
        throw new FileDownloadFailedException(9302, 0L, "downloadImage host is null", false, false);
      }
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
    throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
  }
  
  protected Object decodeGifFile(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeFile isGifFile,path=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("PicEmotionDownloader", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString2);
    paramString2 = null;
    if ("big_img".equals(paramString1))
    {
      paramDownloadParams = NativeGifFactory.getNativeGifObject((File)localObject, true, true, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, 0.0F);
    }
    else
    {
      paramDownloadParams = paramString2;
      if ("big_sound".equals(paramString1)) {
        paramDownloadParams = VoiceGifFactory.getVoiceGifObject((File)localObject, 0, true);
      }
    }
    if (paramDownloadParams != null) {
      paramDownloadParams.setDensity(320);
    }
    return paramDownloadParams;
  }
  
  protected Object decodeMagicFile(Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    paramBundle.putString("display_type", paramString);
    paramString = new File(EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId));
    if (!paramString.exists())
    {
      paramEmoticon = getAIOPreviewBitmap(paramEmoticon.epId, paramEmoticon.eId, paramBoolean2, paramBoolean1);
      if ((paramEmoticon != null) && (paramBoolean2)) {
        paramBundle.putString("display_type", "aio_preview");
      }
      return paramEmoticon;
    }
    paramBundle = NativeGifFactory.getNativeGifObject(paramString, true, true, 0, 0, 0.0F);
    if (paramBundle != null) {
      paramBundle.setDensity(320);
    }
    return paramBundle;
  }
  
  protected Object decodePicEmoticon(DownloadParams paramDownloadParams, Bundle paramBundle, Emoticon paramEmoticon, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    int i = paramEmoticon.jobType;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showType: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("PicEmotionDownloader", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = "big_img".equals(paramString);
    boolean bool1 = true;
    if ((!bool2) && (!"big_sound".equals(paramString)))
    {
      if (paramBoolean2) {
        paramDownloadParams = "aio_preview";
      } else {
        paramDownloadParams = "panel_preview";
      }
      paramBundle.putString("display_type", paramDownloadParams);
      if ((paramBoolean2) && (i != 1) && (i != 3)) {
        paramBoolean2 = bool1;
      } else {
        paramBoolean2 = false;
      }
      return getAIOPreviewBitmap(paramEmoticon.epId, paramEmoticon.eId, paramBoolean2, paramBoolean1);
    }
    if (i != 0)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label222;
        }
        if (i != 4)
        {
          if (QLog.isColorLevel())
          {
            paramDownloadParams = new StringBuilder();
            paramDownloadParams.append("decodeFile jobType not supported: ");
            paramDownloadParams.append(i);
            QLog.d("PicEmotionDownloader", 2, paramDownloadParams.toString());
          }
          return null;
        }
      }
      return decodeMagicFile(paramBundle, paramEmoticon, paramBoolean1, paramString, paramBoolean2);
    }
    label222:
    paramBundle.putString("display_type", paramString);
    Object localObject = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
    if (paramDownloadParams.useApngImage) {
      localObject = EmotionPanelConstans.emoticonAPNGPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
    }
    if (!new File((String)localObject).exists()) {
      return decodeBitmapFile(paramBundle, paramEmoticon, paramBoolean1, paramBoolean2, i);
    }
    try
    {
      if (EmosmUtils.b((String)localObject)) {
        return decodeGifFile(paramDownloadParams, paramString, (String)localObject);
      }
      if (paramDownloadParams.useApngImage) {
        return decodeApngImage(paramDownloadParams, (String)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("decodeFile getDecryptFileData,path=");
        paramDownloadParams.append((String)localObject);
        QLog.d("PicEmotionDownloader", 2, paramDownloadParams.toString());
      }
      paramDownloadParams = EmosmUtils.b((String)localObject);
      if (paramDownloadParams != null)
      {
        paramDownloadParams = decodeDecryptFileData((String)localObject, paramDownloadParams);
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
      return null;
    }
    catch (IOException paramDownloadParams)
    {
      QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
      return null;
    }
    catch (FileNotFoundException paramDownloadParams)
    {
      QLog.e("PicEmotionDownloader", 1, "decode MARKET File", paramDownloadParams);
    }
    return null;
  }
  
  protected void downlaodAIOEmoticon(Emoticon paramEmoticon, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, int paramInt)
  {
    paramQQEmoticonMainPanelApp = (EmojiManagerServiceProxy)paramQQEmoticonMainPanelApp.getRuntimeService(IEmojiManagerService.class);
    boolean bool = paramQQEmoticonMainPanelApp.tasksFileExists(paramEmoticon, paramInt) ^ true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("need download:");
      localStringBuilder.append(bool);
      QLog.d("PicEmotionDownloader", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      bool = paramQQEmoticonMainPanelApp.downloadAIOEmoticon(paramEmoticon, paramInt);
      if (QLog.isColorLevel())
      {
        paramQQEmoticonMainPanelApp = new StringBuilder();
        paramQQEmoticonMainPanelApp.append("downloadImage| downloadAIOEmoticon result=");
        paramQQEmoticonMainPanelApp.append(bool);
        paramQQEmoticonMainPanelApp.append(" eId: ");
        paramQQEmoticonMainPanelApp.append(paramEmoticon.eId);
        QLog.d("Q.emoji.EmoDown", 2, paramQQEmoticonMainPanelApp.toString());
      }
      reportEmoticonMonitor(paramEmoticon, bool);
      if (bool) {
        return;
      }
      paramQQEmoticonMainPanelApp = new StringBuilder();
      paramQQEmoticonMainPanelApp.append("emotion down fail : epid = ");
      paramQQEmoticonMainPanelApp.append(paramEmoticon.epId);
      paramQQEmoticonMainPanelApp.append(";eid = ");
      paramQQEmoticonMainPanelApp.append(paramEmoticon.eId);
      QLog.e("PicEmotionDownloader", 1, paramQQEmoticonMainPanelApp.toString());
      throw new FileDownloadFailedException(9301, 0L, "downloadImage fail", false, false);
    }
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      if (QLog.isColorLevel())
      {
        paramOutputStream = new StringBuilder();
        paramOutputStream.append("downloadImage| useGifAnimation=");
        paramOutputStream.append(paramDownloadParams.useGifAnimation);
        paramOutputStream.append(" url.toString=");
        paramOutputStream.append(paramDownloadParams.url.toString());
        QLog.d("PicEmotionDownloader", 2, paramOutputStream.toString());
      }
      if ((paramDownloadParams.tag instanceof Emoticon))
      {
        paramURLDrawableHandler = (Emoticon)paramDownloadParams.tag;
        Object localObject = paramDownloadParams.getHeader("my_uin");
        paramOutputStream = null;
        if (localObject != null) {
          paramOutputStream = ((Header)localObject).getValue();
        }
        if (!TextUtils.isEmpty(paramOutputStream))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadImage| myUin:");
            ((StringBuilder)localObject).append(paramOutputStream);
            QLog.d("PicEmotionDownloader", 2, ((StringBuilder)localObject).toString());
          }
          try
          {
            paramOutputStream = this.application.getAppRuntime(paramOutputStream);
          }
          catch (Throwable paramOutputStream)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("exception:");
              ((StringBuilder)localObject).append(paramOutputStream.getMessage());
              QLog.d("PicEmotionDownloader", 2, ((StringBuilder)localObject).toString());
            }
            paramOutputStream = MobileQQ.getContext();
            int i;
            if (Build.VERSION.SDK_INT > 10) {
              i = 4;
            } else {
              i = 0;
            }
            localObject = paramOutputStream.getSharedPreferences("Last_Login", i).getString("uin", "");
            paramOutputStream = this.application.getAppRuntime((String)localObject);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("downloadImage| a second time: uin->");
              localStringBuilder.append((String)localObject);
              QLog.d("PicEmotionDownloader", 2, localStringBuilder.toString());
            }
          }
          if (paramOutputStream == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PicEmotionDownloader", 2, "downloadImage app is null");
            }
            throw new FileDownloadFailedException(9301, 0L, "mApp is null", false, false);
          }
          localObject = new Bundle();
          paramDownloadParams.tag = localObject;
          ((Bundle)localObject).putSerializable("emoticon_key", paramURLDrawableHandler);
          paramOutputStream = new QQEmoticonMainPanelApp(paramOutputStream);
          downlaodAIOEmoticon(paramURLDrawableHandler, paramOutputStream, configParams(paramDownloadParams, paramURLDrawableHandler, paramOutputStream, (Bundle)localObject, "aio_preview"));
          return new File(AppConstants.SDCARD_PATH);
        }
        QLog.d("PicEmotionDownloader", 2, "downloadImage| uin is null");
        throw new FileDownloadFailedException(9302, 0L, "can't find myUin!", false, false);
      }
      throw new FileDownloadFailedException(9302, 0L, "downloadImage can't find emoticon!", false, false);
    }
    QLog.d("PicEmotionDownloader", 2, "downloadImage| config is null");
    throw new FileDownloadFailedException(9302, 0L, "downloadImage config is null", false, false);
  }
  
  protected void downloadSmallEmoticon(Emoticon paramEmoticon, AppRuntime paramAppRuntime)
  {
    if (paramEmoticon.jobType == 3)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = EmotionPanelConstans.smallEmoticonThumbUrl.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      arrayOfString[1] = EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId);
      paramEmoticon = new DownloadTask(arrayOfString[0], new File(arrayOfString[1]));
      int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramEmoticon, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        paramEmoticon = new StringBuilder();
        paramEmoticon.append("download small emoji, ret:");
        paramEmoticon.append(i);
        QLog.d("PicEmotionDownloader", 2, paramEmoticon.toString());
      }
    }
  }
  
  public boolean gifHasDifferentState()
  {
    return true;
  }
  
  protected boolean isGrayPic(DownloadParams paramDownloadParams, String paramString)
  {
    if (paramString.equals("fromPanel"))
    {
      paramDownloadParams = paramDownloadParams.url.getFile();
      if ((!TextUtils.isEmpty(paramDownloadParams)) && (paramDownloadParams.endsWith("_panel_magic_gray"))) {
        return true;
      }
    }
    return false;
  }
  
  protected void reportEmoticonMonitor(Emoticon paramEmoticon, boolean paramBoolean)
  {
    int i = paramEmoticon.jobType;
    String str = "0";
    if (i == 3)
    {
      if (!paramBoolean) {
        str = "5002";
      }
      EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 5);
      return;
    }
    if ((paramEmoticon.jobType != 2) && (paramEmoticon.jobType != 4))
    {
      if (paramEmoticon.jobType == 0)
      {
        if (!paramBoolean) {
          str = "66001";
        }
        EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 6);
      }
    }
    else
    {
      if (!paramBoolean) {
        str = "7001";
      }
      EmoticonOperateReport.reportAIOEmoticonMonitorReceiveStatus(str, 7);
    }
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicEmotionDownloader
 * JD-Core Version:    0.7.0.1
 */