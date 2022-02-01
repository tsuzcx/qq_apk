package com.tencent.mobileqq.flutter.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public class QFlutterDownloader<T extends XmlData>
  extends EarlyHandler
{
  private final QFlutterDownloader.DownloadConfig<T> a;
  private String c;
  private boolean d = false;
  
  public QFlutterDownloader(String paramString, QQAppInterface paramQQAppInterface, QFlutterDownloader.DownloadConfig<T> paramDownloadConfig)
  {
    super(paramString, paramQQAppInterface);
    this.a = paramDownloadConfig;
    this.c = paramString;
  }
  
  private String e()
  {
    String str = QFlutterResConfigProcessor.a().a(this.jdField_b_of_type_JavaLangString);
    XmlData localXmlData = a();
    if (!TextUtils.equals(this.c, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]", " data pkg name updated! ", this.c, " -> ", str });
      }
      this.c = str;
    }
    if (!TextUtils.equals(localXmlData.strPkgName, str))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]", " data pkg name updated! ", localXmlData.strPkgName, " -> ", str, " clear loadState" });
      }
      localXmlData.strPkgName = str;
      localXmlData.loadState = 0;
      EarlyDataFactory.a(localXmlData, new String[0]);
    }
    return this.c;
  }
  
  private String f()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFlutter.QFlutterDownloader", 2, "[" + this.c + "]getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + this.jdField_b_of_type_JavaLangString;
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("QFlutter.QFlutterDownloader", 2, "[" + this.c + "]getLibDir ,path = " + str);
    return str;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]restoreState() res:", this.jdField_b_of_type_JavaLangString });
    }
    a().loadState = 0;
    a().Version = 0;
    EarlyDataFactory.a(a(), new String[0]);
  }
  
  public final int a()
  {
    return this.a.jdField_a_of_type_Int;
  }
  
  public final Class<T> a()
  {
    return this.a.jdField_a_of_type_JavaLangClass;
  }
  
  public final String a()
  {
    return this.a.jdField_a_of_type_JavaLangString;
  }
  
  public GetResourceReqInfo a()
  {
    GetResourceReqInfo localGetResourceReqInfo = super.a();
    if (localGetResourceReqInfo != null) {
      localGetResourceReqInfo.strPkgName = e();
    }
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfoV2 a(String paramString)
  {
    paramString = super.a(paramString);
    paramString.strPkgName = e();
    return paramString;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]", "download progress: (" + paramLong1 + "/" + paramLong2 + ") progress = ", Integer.valueOf(i) });
    }
    QFlutterInstaller.a(this.a.jdField_b_of_type_Int, paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format("[" + this.c + "]onDownloadFinish, result: %s, errCode: %s, filepath: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    if (!paramBoolean) {
      QFlutterInstaller.a(this.a.jdField_b_of_type_Int, false);
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = QFlutterInstaller.a(paramString, a());
    if (!bool) {
      g();
    }
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { "[" + this.c + "]", "download success: " + paramString + " " + bool });
    QFlutterInstaller.a(this.a.jdField_b_of_type_Int, bool);
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format("[" + this.c + "]restartDownload userClick: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    super.a(paramBoolean);
    if (!this.d) {
      this.d = paramBoolean;
    }
  }
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_Boolean;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      QFlutterInstaller.a(a());
    }
    boolean bool = QFlutterResConfigProcessor.a().a(this.jdField_b_of_type_JavaLangString);
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format("[" + this.c + "] downloadResource, mHadRequestedByUser = %s, resCanPreload = %s needClearData = %s", new Object[] { Boolean.valueOf(this.d), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
    if ((!this.d) && (!bool)) {
      return false;
    }
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format("[" + this.c + "]start download... url = %s", new Object[] { a().strResURL_big }));
    return super.e();
  }
  
  public String b()
  {
    return this.a.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    String str = f();
    boolean bool = FileUtil.a(new File(str));
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]", String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }) });
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    if (paramXmlData != null) {}
    for (long l = paramXmlData.totalSize;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { "[" + this.c + "]", "download begin, totalLen: ", Long.valueOf(l) });
      }
      return;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterDownloader", 2, String.format("[" + this.c + "]isNetValid2Download mHadRequestedByUser: %s", new Object[] { Boolean.valueOf(this.d) }));
    }
    if (this.d) {
      return true;
    }
    return super.b();
  }
  
  public boolean e()
  {
    return a(true);
  }
  
  public void f()
  {
    boolean bool = QFlutterInstaller.a(a());
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { "onQFlutterResConfigChanged [" + this.c + "]", "success: " + bool });
  }
  
  @NotNull
  public String toString()
  {
    return "QFlutterDownloader{res=" + this.a.jdField_a_of_type_JavaLangClass.getSimpleName() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterDownloader
 * JD-Core Version:    0.7.0.1
 */