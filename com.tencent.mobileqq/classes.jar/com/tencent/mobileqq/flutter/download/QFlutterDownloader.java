package com.tencent.mobileqq.flutter.download;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
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
    StringBuilder localStringBuilder;
    if (!TextUtils.equals(this.c, str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("]");
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), " data pkg name updated! ", this.c, " -> ", str });
      }
      this.c = str;
    }
    if (!TextUtils.equals(localXmlData.strPkgName, str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("]");
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), " data pkg name updated! ", localXmlData.strPkgName, " -> ", str, " clear loadState" });
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append("]getFilesDir is null");
        QLog.i("QFlutter.QFlutterDownloader", 2, ((StringBuilder)localObject).toString());
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("QFlutter.QFlutterDownloader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static void g()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      QFlutterEngineData.createDownloader((QQAppInterface)localObject).f();
      QFlutterAppData.createDownloader((QQAppInterface)localObject).f();
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]restoreState() res:");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), this.jdField_b_of_type_JavaLangString });
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
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: (");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(") progress = ");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localObject, localStringBuilder.toString(), Integer.valueOf(i) });
    }
    QFlutterInstaller.a(this.a.jdField_b_of_type_Int, paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    paramXmlData = new StringBuilder();
    paramXmlData.append("[");
    paramXmlData.append(this.c);
    paramXmlData.append("]onDownloadFinish, result: %s, errCode: %s, filepath: %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(paramXmlData.toString(), new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    if (!paramBoolean) {
      QFlutterInstaller.a(this.a.jdField_b_of_type_Int, false);
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = QFlutterInstaller.a(paramString, a());
    if (!bool) {
      h();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download success: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { localObject, localStringBuilder.toString() });
    QFlutterInstaller.a(this.a.jdField_b_of_type_Int, bool);
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]restartDownload userClick: %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(paramBoolean) }));
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
    boolean bool = QFlutterResConfigProcessor.a(ExpandModuleKey.QFlutterEngine);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] downloadResource, mHadRequestedByUser = %s, resCanPreload = %s needClearData = %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(this.d), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
    if ((!this.d) && (!bool)) {
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]start download... url = %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { a().strResURL_big }));
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }) });
    }
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
    long l;
    if (paramXmlData != null) {
      l = paramXmlData.totalSize;
    } else {
      l = 0L;
    }
    if (QLog.isColorLevel())
    {
      paramXmlData = new StringBuilder();
      paramXmlData.append("[");
      paramXmlData.append(this.c);
      paramXmlData.append("]");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { paramXmlData.toString(), "download begin, totalLen: ", Long.valueOf(l) });
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]isNetValid2Download mHadRequestedByUser: %s");
      QLog.d("QFlutter.QFlutterDownloader", 2, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(this.d) }));
    }
    if (this.d) {
      return true;
    }
    return super.c();
  }
  
  public boolean e()
  {
    return a(true);
  }
  
  public void f()
  {
    boolean bool = QFlutterInstaller.a(a());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQFlutterResConfigChanged [");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success: ");
    localStringBuilder.append(bool);
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { localObject, localStringBuilder.toString() });
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFlutterDownloader{res=");
    localStringBuilder.append(this.a.jdField_a_of_type_JavaLangClass.getSimpleName());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterDownloader
 * JD-Core Version:    0.7.0.1
 */