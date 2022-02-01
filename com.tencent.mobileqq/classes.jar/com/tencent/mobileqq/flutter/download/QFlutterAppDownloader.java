package com.tencent.mobileqq.flutter.download;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig;
import com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

@Deprecated
public class QFlutterAppDownloader
  extends EarlyHandler
{
  private boolean h;
  
  public Class<? extends XmlData> a()
  {
    return QFlutterAppData.class;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download progress: ");
      localStringBuilder.append(i);
      QLog.d("QFlutter.QFlutterAppDownloader", 2, localStringBuilder.toString());
    }
    QFlutterInstaller.a(1, paramLong1, paramLong2);
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("onDownloadFinish, result: %s, errCode: %s, filepath: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    if (!paramBoolean) {
      QFlutterInstaller.a(1, false);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download success: ");
      localStringBuilder.append(paramString);
      QLog.d("QFlutter.QFlutterAppDownloader", 2, localStringBuilder.toString());
    }
    if (QFlutterInstaller.a(paramString, h()))
    {
      QFlutterInstaller.a(1, true);
    }
    else
    {
      x();
      QFlutterInstaller.a(1, false);
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("restartDownload userClick: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    super.a(paramBoolean);
    if (!this.h) {
      this.h = paramBoolean;
    }
  }
  
  public String b()
  {
    return QFlutterAppData.class.getSimpleName();
  }
  
  public GetResourceReqInfoV2 b(String paramString)
  {
    paramString = super.b(paramString);
    paramString.strPkgName = QFlutterResConfigProcessor.a().a("qq.android.flutter.app.v8.5.0");
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
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, new Object[] { "download begin, totalLen: ", Long.valueOf(l) });
    }
  }
  
  public int c()
  {
    return 10093;
  }
  
  public String d()
  {
    return "prd";
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void j()
  {
    String str = w();
    boolean bool = FileUtil.a(new File(str));
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }));
    }
  }
  
  public boolean m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("isNetValid2Download mHadRequestedByUser: %s", new Object[] { Boolean.valueOf(this.h) }));
    }
    if (this.h) {
      return true;
    }
    return super.m();
  }
  
  public boolean o()
  {
    QLog.d("QFlutter.QFlutterAppDownloader", 1, String.format("downloadResource, mHadRequestedByUser = %s", new Object[] { Boolean.valueOf(this.h) }));
    if (!this.h) {
      return false;
    }
    return super.o();
  }
  
  public GetResourceReqInfo q()
  {
    GetResourceReqInfo localGetResourceReqInfo = super.q();
    if (localGetResourceReqInfo != null) {
      localGetResourceReqInfo.strPkgName = QFlutterResConfigProcessor.a().a("qq.android.flutter.app.v8.5.0");
    }
    return localGetResourceReqInfo;
  }
  
  public String w()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFlutter.QFlutterAppDownloader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append("qq.android.flutter.app.v8.5.0");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLibDir ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("QFlutter.QFlutterAppDownloader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, new Object[] { "restoreState() res:", "qq.android.flutter.app.v8.5.0" });
    }
    h().loadState = 0;
    h().Version = 0;
    EarlyDataFactory.a(h(), new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterAppDownloader
 * JD-Core Version:    0.7.0.1
 */