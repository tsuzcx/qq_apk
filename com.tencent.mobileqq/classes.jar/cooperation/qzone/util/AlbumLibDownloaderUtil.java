package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import java.io.File;

public class AlbumLibDownloaderUtil
{
  public static String BEAUTY_SO_LIB_NAME;
  public static String GIF_SO_LIB_NAME = "libandroidndkgif.so";
  public static String LIB_QZONE_VISION_NAME = "libqzone_vision.so";
  public static String LIB_SHARED_NAME = "libc++_shared.so";
  public static String OPEN_SO_LIB_NAME;
  private static final String TAG = "AlbumLibDownloaderUtil";
  public static File mAlbumDir = BaseApplicationImpl.getContext().getDir("qzonealbum", 0);
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
  private final String mPicQulatityUnzipPath = mAlbumDir.getPath() + "/photoqulatity";
  
  static
  {
    BEAUTY_SO_LIB_NAME = "libdehaze.so";
    OPEN_SO_LIB_NAME = "libopencv_java3.so";
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
    if (getSoLength(paramString) == 0L) {}
    while (getSoLength(paramString) == paramLong) {
      return true;
    }
    return false;
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
    File localFile = new File(mAlbumDir.getAbsolutePath() + "/" + paramString2);
    if ((bool) && (localFile.exists()) && (isLibLengthOk(paramString2, localFile.length())))
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
    paramString2 = mAlbumDir.getAbsolutePath() + "/tmp" + paramString2;
    this.mDownloader.download(paramString1, paramString2, paramDownloadListener);
  }
  
  public void downloadGifEncoderSo()
  {
    downloadGifEncoderSo(null);
  }
  
  public void downloadGifEncoderSo(Downloader.DownloadListener paramDownloadListener)
  {
    if (this.mDownloadState[this.GIFSO_STATE] == 0)
    {
      this.mDownloadState[this.GIFSO_STATE] = true;
      download(this.mGifSoDownloadUrl, GIF_SO_LIB_NAME, paramDownloadListener);
    }
    while (paramDownloadListener == null) {
      return;
    }
    paramDownloadListener.onDownloadCanceled("lib is downloading");
  }
  
  public void downloadPhotoBeautySo()
  {
    downloadPhotoBeautySo(null);
  }
  
  public void downloadPhotoBeautySo(Downloader.DownloadListener paramDownloadListener)
  {
    if (this.mDownloadState[this.BEAUTYSO_STATE] == 0)
    {
      this.mDownloadState[this.BEAUTYSO_STATE] = true;
      download(this.mBeautyDownloadUrl, BEAUTY_SO_LIB_NAME, paramDownloadListener);
    }
    while (paramDownloadListener == null) {
      return;
    }
    paramDownloadListener.onDownloadCanceled("lib is downloading");
  }
  
  public void downloadPicBeautySo()
  {
    QzoneModuleManager.getInstance().downloadModule("libandroidndkbeauty.so", new AlbumLibDownloaderUtil.3(this));
  }
  
  public void downloadPicQulatitySo()
  {
    QzoneModuleManager.getInstance().downloadModule("pictureMarkerSo.zip", new AlbumLibDownloaderUtil.2(this));
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
    return mAlbumDir.getAbsolutePath() + "/" + paramString;
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
    File localFile = new File(getLibPath(paramString));
    if (!localFile.exists())
    {
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file not exists. libName=" + paramString });
      return false;
    }
    if (localFile.length() == getSoLength(paramString)) {
      if (paramBoolean)
      {
        String str1 = MD5Utils.encodeFileHexStr(getLibPath(paramString));
        String str2 = getSoMD5(paramString);
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.equalsIgnoreCase(str1)))
        {
          LocalMultiProcConfig.putBool(paramString, false);
          return true;
        }
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file md5 check failed. libName=" + paramString + " downloadMD5=" + str1 + " originalMD5=" + str2 });
      }
    }
    for (;;)
    {
      localFile.delete();
      return false;
      return true;
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file length check failed. libName=" + paramString + " file.length()=" + localFile.length() + " expect length=" + getSoLength(paramString) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil
 * JD-Core Version:    0.7.0.1
 */