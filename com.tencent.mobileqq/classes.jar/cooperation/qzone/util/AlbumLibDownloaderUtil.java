package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePreDownloadManager;
import java.io.File;
import mqq.app.MobileQQ;

public class AlbumLibDownloaderUtil
{
  public static String BEAUTY_SO_LIB_NAME = "libdehaze.so";
  public static String GIF_SO_LIB_NAME = "libandroidndkgif.so";
  public static String LIB_QZONE_VISION_NAME = "libqzone_vision.so";
  public static String LIB_SHARED_NAME = "libc++_shared.so";
  public static String OPEN_SO_LIB_NAME = "libopencv_java3.so";
  private static final String TAG = "AlbumLibDownloaderUtil";
  public static File mAlbumDir = MobileQQ.getContext().getDir("qzonealbum", 0);
  private static AlbumLibDownloaderUtil mInstance;
  private int BEAUTYSO_STATE = 2;
  private int GIFSO_STATE = 0;
  private String mBeautyDownloadUrl = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
  private long mBeautySoLength = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 587284);
  private String mBeautySoMD5 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "C6787CBD4DBC4331E8C443A27EFEA03B");
  public boolean[] mDownloadState = { 0, 0, 0 };
  private QzonePreDownloadManager mDownloader;
  private String mGifSoDownloadUrl = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo", "https://d3g.qq.com/sngapp/app/update/20181219175050_4961/libandroidndkgif.so");
  private String mGifSoDownloadUrl64 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo64", "https://d3g.qq.com/sngapp/app/update/20200214225316_4688/libandroidndkgif.so");
  private long mGifSoLength = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength", 38400L);
  private long mGifSoLength64 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength64", 38672);
  private String mGifSoMD5 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD5", "16dd3ecb57fac1a97a60a9cf3891accb");
  private String mGifSoMD564 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD564", "01468c39f609eef93fcd9224dbe686d3");
  private long mLibCSharedSoLength = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength", 657000);
  private long mLibCSharedSoLength64 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength64", 1058904);
  private String mLibCSharedSoMD5 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD5", "f507c0f741a32f7a30fa162faa894ebc");
  private String mLibCSharedSoMD564 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD564", "a86a585f5560b0bff890a100fe32792b");
  private long mLibQzoneVisionSoLength = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength", 2422908);
  private long mLibQzoneVisionSoLength64 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength64", 3755056);
  private String mLibQzoneVisionSoMD5 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "f428bc70e52b7eb3fba4327e123a779b");
  private String mLibQzoneVisionSoMD564 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "b186c1e0ee3995717d84fb682afcd7b5");
  private long mOpenSoLength = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateOpenSoLength", 9161452);
  private final String mPicQulatityUnzipPath;
  
  public AlbumLibDownloaderUtil()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mAlbumDir.getPath());
    localStringBuilder.append("/photoqulatity");
    this.mPicQulatityUnzipPath = localStringBuilder.toString();
  }
  
  private static void copyFileUsingApacheCommonsIO(File paramFile1, File paramFile2)
  {
    FileUtils.copyFile(paramFile1, paramFile2);
  }
  
  public static AlbumLibDownloaderUtil getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new AlbumLibDownloaderUtil();
      }
      AlbumLibDownloaderUtil localAlbumLibDownloaderUtil = mInstance;
      return localAlbumLibDownloaderUtil;
    }
    finally {}
  }
  
  private boolean isLibLengthOk(String paramString, long paramLong)
  {
    if (getSoLength(paramString) == 0L) {
      return true;
    }
    return getSoLength(paramString) == paramLong;
  }
  
  public void download(String paramString1, String paramString2)
  {
    download(paramString1, paramString2, null);
  }
  
  public void download(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    if (this.mDownloader == null) {
      this.mDownloader = QzonePreDownloadManager.getInstance();
    }
    boolean bool = LocalMultiProcConfig.getBool(paramString1, false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString2);
    localObject = new File(((StringBuilder)localObject).toString());
    if ((bool) && (((File)localObject).exists()) && (isLibLengthOk(paramString2, ((File)localObject).length())))
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.onDownloadSucceed(null, null);
      }
      if (GIF_SO_LIB_NAME.equals(paramString2)) {
        this.mDownloadState[this.GIFSO_STATE] = false;
      }
      return;
    }
    paramDownloadListener = new AlbumLibDownloaderUtil.1(this, paramString2, paramDownloadListener, paramString1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(mAlbumDir.getAbsolutePath());
    ((StringBuilder)localObject).append("/tmp");
    ((StringBuilder)localObject).append(paramString2);
    paramString2 = ((StringBuilder)localObject).toString();
    this.mDownloader.download(paramString1, paramString2, paramDownloadListener);
  }
  
  public void downloadGifEncoderSo()
  {
    downloadGifEncoderSo(null);
  }
  
  public void downloadGifEncoderSo(Downloader.DownloadListener paramDownloadListener)
  {
    boolean[] arrayOfBoolean = this.mDownloadState;
    int i = this.GIFSO_STATE;
    if (arrayOfBoolean[i] == 0)
    {
      arrayOfBoolean[i] = true;
      download(this.mGifSoDownloadUrl, GIF_SO_LIB_NAME, paramDownloadListener);
      return;
    }
    if (paramDownloadListener != null) {
      paramDownloadListener.onDownloadCanceled("lib is downloading");
    }
  }
  
  public void downloadPhotoBeautySo()
  {
    downloadPhotoBeautySo(null);
  }
  
  public void downloadPhotoBeautySo(Downloader.DownloadListener paramDownloadListener)
  {
    boolean[] arrayOfBoolean = this.mDownloadState;
    int i = this.BEAUTYSO_STATE;
    if (arrayOfBoolean[i] == 0)
    {
      arrayOfBoolean[i] = true;
      download(this.mBeautyDownloadUrl, BEAUTY_SO_LIB_NAME, paramDownloadListener);
      return;
    }
    if (paramDownloadListener != null) {
      paramDownloadListener.onDownloadCanceled("lib is downloading");
    }
  }
  
  public void downloadPicBeautySo()
  {
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("libandroidndkbeauty.so", new AlbumLibDownloaderUtil.3(this));
  }
  
  public void downloadPicQulatitySo()
  {
    ((IQzoneModuleManageApi)QRoute.api(IQzoneModuleManageApi.class)).downloadModule("pictureMarkerSo.zip", new AlbumLibDownloaderUtil.2(this));
  }
  
  public void forceDownloadBeautySo(Downloader.DownloadListener paramDownloadListener)
  {
    download(this.mBeautyDownloadUrl, BEAUTY_SO_LIB_NAME, paramDownloadListener);
  }
  
  public void forceDownloadGifEncoderSo(Downloader.DownloadListener paramDownloadListener)
  {
    download(this.mGifSoDownloadUrl, GIF_SO_LIB_NAME, paramDownloadListener);
  }
  
  public String getLibPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(mAlbumDir.getAbsolutePath());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public long getSoLength(String paramString)
  {
    if (GIF_SO_LIB_NAME.equals(paramString)) {
      return this.mGifSoLength;
    }
    if (LIB_QZONE_VISION_NAME.equals(paramString)) {
      return this.mLibQzoneVisionSoLength;
    }
    if (LIB_SHARED_NAME.equals(paramString)) {
      return this.mLibCSharedSoLength;
    }
    if (BEAUTY_SO_LIB_NAME.equals(paramString)) {
      return this.mBeautySoLength;
    }
    if (OPEN_SO_LIB_NAME.equals(paramString)) {
      return this.mOpenSoLength;
    }
    return 0L;
  }
  
  public String getSoMD5(String paramString)
  {
    if (LIB_QZONE_VISION_NAME.equals(paramString)) {
      return this.mLibQzoneVisionSoMD5;
    }
    if (LIB_SHARED_NAME.equals(paramString)) {
      return this.mLibCSharedSoMD5;
    }
    if (GIF_SO_LIB_NAME.equals(paramString)) {
      return this.mGifSoMD5;
    }
    if (BEAUTY_SO_LIB_NAME.equals(paramString)) {
      return this.mBeautySoMD5;
    }
    return "";
  }
  
  public boolean isDownload(String paramString)
  {
    return new File(getLibPath(paramString)).exists();
  }
  
  public boolean vertifySoIsOK(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new File(getLibPath(paramString));
    if (!((File)localObject1).exists())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("vertifySoIsOK. file not exists. libName=");
      ((StringBuilder)localObject1).append(paramString);
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { ((StringBuilder)localObject1).toString() });
      return false;
    }
    Object localObject2;
    if (((File)localObject1).length() == getSoLength(paramString))
    {
      if (paramBoolean)
      {
        localObject2 = MD5Utils.encodeFileHexStr(getLibPath(paramString));
        String str = getSoMD5(paramString);
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (str.equalsIgnoreCase((String)localObject2)))
        {
          LocalMultiProcConfig.putBool(paramString, false);
          return true;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vertifySoIsOK. file md5 check failed. libName=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" downloadMD5=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" originalMD5=");
        localStringBuilder.append(str);
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { localStringBuilder.toString() });
      }
      else
      {
        return true;
      }
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("vertifySoIsOK. file length check failed. libName=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" file.length()=");
      ((StringBuilder)localObject2).append(((File)localObject1).length());
      ((StringBuilder)localObject2).append(" expect length=");
      ((StringBuilder)localObject2).append(getSoLength(paramString));
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { ((StringBuilder)localObject2).toString() });
    }
    ((File)localObject1).delete();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil
 * JD-Core Version:    0.7.0.1
 */