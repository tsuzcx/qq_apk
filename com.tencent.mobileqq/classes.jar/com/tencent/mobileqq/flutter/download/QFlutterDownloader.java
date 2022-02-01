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
  private final QFlutterDownloader.DownloadConfig<T> h;
  private String i;
  private boolean j = false;
  
  public QFlutterDownloader(String paramString, QQAppInterface paramQQAppInterface, QFlutterDownloader.DownloadConfig<T> paramDownloadConfig)
  {
    super(paramString, paramQQAppInterface);
    this.h = paramDownloadConfig;
    this.i = paramString;
  }
  
  private void A()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]restoreState() res:");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), this.b });
    }
    h().loadState = 0;
    h().Version = 0;
    EarlyDataFactory.a(h(), new String[0]);
  }
  
  public static void x()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      QFlutterEngineData.createDownloader((QQAppInterface)localObject).w();
      QFlutterAppData.createDownloader((QQAppInterface)localObject).w();
    }
  }
  
  private String y()
  {
    String str = QFlutterResConfigProcessor.a().a(this.b);
    XmlData localXmlData = h();
    StringBuilder localStringBuilder;
    if (!TextUtils.equals(this.i, str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.i);
        localStringBuilder.append("]");
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), " data pkg name updated! ", this.i, " -> ", str });
      }
      this.i = str;
    }
    if (!TextUtils.equals(localXmlData.strPkgName, str))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.i);
        localStringBuilder.append("]");
        QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), " data pkg name updated! ", localXmlData.strPkgName, " -> ", str, " clear loadState" });
      }
      localXmlData.strPkgName = str;
      localXmlData.loadState = 0;
      EarlyDataFactory.a(localXmlData, new String[0]);
    }
    return this.i;
  }
  
  private String z()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(this.i);
        ((StringBuilder)localObject).append("]getFilesDir is null");
        QLog.i("QFlutter.QFlutterDownloader", 2, ((StringBuilder)localObject).toString());
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append(this.b);
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("QFlutter.QFlutterDownloader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public final Class<T> a()
  {
    return this.h.a;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    int k = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: (");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(") progress = ");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localObject, localStringBuilder.toString(), Integer.valueOf(k) });
    }
    QFlutterInstaller.a(this.h.f, paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    paramXmlData = new StringBuilder();
    paramXmlData.append("[");
    paramXmlData.append(this.i);
    paramXmlData.append("]onDownloadFinish, result: %s, errCode: %s, filepath: %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(paramXmlData.toString(), new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    if (!paramBoolean) {
      QFlutterInstaller.a(this.h.f, false);
    }
  }
  
  public void a(String paramString)
  {
    boolean bool = QFlutterInstaller.a(paramString, h());
    if (!bool) {
      A();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download success: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(bool);
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { localObject, localStringBuilder.toString() });
    QFlutterInstaller.a(this.h.f, bool);
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]restartDownload userClick: %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(paramBoolean) }));
    super.a(paramBoolean);
    if (!this.j) {
      this.j = paramBoolean;
    }
  }
  
  public final String b()
  {
    return this.h.b;
  }
  
  public GetResourceReqInfoV2 b(String paramString)
  {
    paramString = super.b(paramString);
    paramString.strPkgName = y();
    return paramString;
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
      paramXmlData.append(this.i);
      paramXmlData.append("]");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { paramXmlData.toString(), "download begin, totalLen: ", Long.valueOf(l) });
    }
  }
  
  public final int c()
  {
    return this.h.c;
  }
  
  public String d()
  {
    return this.h.d;
  }
  
  public boolean e()
  {
    return this.h.e;
  }
  
  public boolean f(boolean paramBoolean)
  {
    if (paramBoolean) {
      QFlutterInstaller.b(h());
    }
    boolean bool = QFlutterResConfigProcessor.b(ExpandModuleKey.QFlutterEngine);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("] downloadResource, mHadRequestedByUser = %s, resCanPreload = %s needClearData = %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(this.j), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
    if ((!this.j) && (!bool)) {
      return false;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]start download... url = %s");
    QLog.d("QFlutter.QFlutterDownloader", 1, String.format(localStringBuilder.toString(), new Object[] { h().strResURL_big }));
    return super.o();
  }
  
  public void j()
  {
    String str = z();
    boolean bool = FileUtil.a(new File(str));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]");
      QLog.d("QFlutter.QFlutterDownloader", 2, new Object[] { localStringBuilder.toString(), String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }) });
    }
  }
  
  public boolean m()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.i);
      localStringBuilder.append("]isNetValid2Download mHadRequestedByUser: %s");
      QLog.d("QFlutter.QFlutterDownloader", 2, String.format(localStringBuilder.toString(), new Object[] { Boolean.valueOf(this.j) }));
    }
    if (this.j) {
      return true;
    }
    return super.m();
  }
  
  public boolean o()
  {
    return f(true);
  }
  
  public GetResourceReqInfo q()
  {
    GetResourceReqInfo localGetResourceReqInfo = super.q();
    if (localGetResourceReqInfo != null) {
      localGetResourceReqInfo.strPkgName = y();
    }
    return localGetResourceReqInfo;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFlutterDownloader{res=");
    localStringBuilder.append(this.h.a.getSimpleName());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void w()
  {
    boolean bool = QFlutterInstaller.a(h());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onQFlutterResConfigChanged [");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success: ");
    localStringBuilder.append(bool);
    QLog.d("QFlutter.QFlutterDownloader", 1, new Object[] { localObject, localStringBuilder.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterDownloader
 * JD-Core Version:    0.7.0.1
 */