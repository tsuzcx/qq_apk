package cooperation.qzone.util;

import android.text.TextUtils;
import anik;
import anil;
import anim;
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
  private static AlbumLibDownloaderUtil jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil;
  public static File a;
  public static String a;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength", 70856L);
  private QzonePreDownloadManager jdField_a_of_type_CooperationQzoneQzonePreDownloadManager;
  public boolean[] a;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 587284);
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateOpenSoLength", 9161452);
  private long d;
  private long e;
  private String g = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo", "http://d3g.qq.com/sngapp/app/update/20170108144044_3091/libandroidndkgif.so");
  private String h = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
  private String i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuidePictureQulatitySo", "http://d3g.qq.com/sngapp/app/update/20170410195647_4697/pictureMarkerSo.so");
  private String j = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "C08B35C131F8A5D10AA37FDA63646F0B");
  private String k = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD5", "D486DC0992ADFB90F4BC3D1F786CAAED");
  private String l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD5", "0941136A34E8BF011BC094058604AEB5");
  private String m = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "C6787CBD4DBC4331E8C443A27EFEA03B");
  private final String n = jdField_a_of_type_JavaIoFile.getPath() + "/photoqulatity";
  
  static
  {
    jdField_a_of_type_JavaLangString = "libandroidndkgif.so";
    jdField_b_of_type_JavaLangString = "libdehaze.so";
    jdField_c_of_type_JavaLangString = "libopencv_java3.so";
    jdField_d_of_type_JavaLangString = "libqzone_vision.so";
    jdField_e_of_type_JavaLangString = "libgnustl_shared.so";
    f = "photoQulatitySo.zip";
    jdField_a_of_type_JavaIoFile = BaseApplicationImpl.getContext().getDir("qzonealbum", 0);
  }
  
  public AlbumLibDownloaderUtil()
  {
    this.jdField_a_of_type_ArrayOfBoolean = new boolean[] { 0, 0, 0 };
    this.jdField_d_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength", 718696);
    this.jdField_e_of_type_Long = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength", 4946500);
  }
  
  public static AlbumLibDownloaderUtil a()
  {
    try
    {
      if (jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil == null) {
        jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil = new AlbumLibDownloaderUtil();
      }
      AlbumLibDownloaderUtil localAlbumLibDownloaderUtil = jdField_a_of_type_CooperationQzoneUtilAlbumLibDownloaderUtil;
      return localAlbumLibDownloaderUtil;
    }
    finally {}
  }
  
  private boolean a(String paramString, long paramLong)
  {
    if (a(paramString) == 0L) {}
    while (a(paramString) == paramLong) {
      return true;
    }
    return false;
  }
  
  private static void b(File paramFile1, File paramFile2)
  {
    FileUtils.a(paramFile1, paramFile2);
  }
  
  public long a(String paramString)
  {
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_a_of_type_Long;
    }
    if (jdField_d_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_e_of_type_Long;
    }
    if (jdField_e_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_d_of_type_Long;
    }
    if (jdField_b_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_b_of_type_Long;
    }
    if (jdField_c_of_type_JavaLangString.equals(paramString)) {
      return this.jdField_c_of_type_Long;
    }
    return 0L;
  }
  
  public String a(String paramString)
  {
    if (jdField_d_of_type_JavaLangString.equals(paramString)) {
      return this.j;
    }
    if (jdField_e_of_type_JavaLangString.equals(paramString)) {
      return this.k;
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      return this.l;
    }
    if (jdField_b_of_type_JavaLangString.equals(paramString)) {
      return this.m;
    }
    return "";
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(Downloader.DownloadListener paramDownloadListener)
  {
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] == 0)
    {
      this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
      a(this.g, jdField_a_of_type_JavaLangString, paramDownloadListener);
    }
    while (paramDownloadListener == null) {
      return;
    }
    paramDownloadListener.onDownloadCanceled("lib is downloading");
  }
  
  public void a(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    if (this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager == null) {
      this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager = QzonePreDownloadManager.a();
    }
    boolean bool = LocalMultiProcConfig.getBool(paramString1, false);
    File localFile = new File(jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + paramString2);
    if ((bool) && (localFile.exists()) && (a(paramString2, localFile.length())))
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.onDownloadSucceed(null, null);
      }
      if (jdField_a_of_type_JavaLangString.equals(paramString2)) {
        this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = false;
      }
      return;
    }
    paramDownloadListener = new anik(this, paramString2, paramDownloadListener, paramString1);
    paramString2 = jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/tmp" + paramString2;
    this.jdField_a_of_type_CooperationQzoneQzonePreDownloadManager.a(paramString1, paramString2, paramDownloadListener);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    File localFile = new File(b(paramString));
    if (!localFile.exists())
    {
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file not exists. libName=" + paramString });
      return false;
    }
    if (localFile.length() == a(paramString)) {
      if (paramBoolean)
      {
        String str1 = MD5Utils.a(b(paramString));
        String str2 = a(paramString);
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
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file length check failed. libName=" + paramString + " file.length()=" + localFile.length() + " expect length=" + a(paramString) });
    }
  }
  
  public String b(String paramString)
  {
    return jdField_a_of_type_JavaIoFile.getAbsolutePath() + "/" + paramString;
  }
  
  public void b()
  {
    QzoneModuleManager.getInstance().downloadModule("pictureMarkerSo.so", new anil(this));
  }
  
  public void b(Downloader.DownloadListener paramDownloadListener)
  {
    a(this.g, jdField_a_of_type_JavaLangString, paramDownloadListener);
  }
  
  public void c()
  {
    QzoneModuleManager.getInstance().downloadModule("libandroidndkbeauty.so", new anim(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.AlbumLibDownloaderUtil
 * JD-Core Version:    0.7.0.1
 */