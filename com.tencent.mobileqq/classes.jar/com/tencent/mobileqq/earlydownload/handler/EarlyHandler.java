package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownLoadListener;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.relation.api.IConfigHandlerTempService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceReqInfoV2;

public abstract class EarlyHandler
{
  static final String e_;
  protected String b;
  protected AppRuntime c;
  protected ArrayList<EarlyDownLoadListener> d;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  private XmlData h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("pddata/prd/early");
    e_ = localStringBuilder.toString();
  }
  
  public EarlyHandler(String paramString, AppRuntime paramAppRuntime)
  {
    this.b = paramString;
    this.c = paramAppRuntime;
  }
  
  public abstract Class<? extends XmlData> a();
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.d != null)
    {
      XmlData localXmlData = h();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext()) {
        ((EarlyDownLoadListener)localIterator.next()).a(localXmlData, paramLong1, paramLong2);
      }
    }
  }
  
  public void a(EarlyDownLoadListener paramEarlyDownLoadListener)
  {
    if (paramEarlyDownLoadListener != null)
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      if (!this.d.contains(paramEarlyDownLoadListener)) {
        this.d.add(paramEarlyDownLoadListener);
      }
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    if (paramXmlData == null)
    {
      QLog.e("EarlyDown", 1, "doOnServerResp() return respData == null.");
      return;
    }
    XmlData localXmlData = h();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnServerResp() called,");
      ((StringBuilder)localObject1).append(paramXmlData.strResName);
      ((StringBuilder)localObject1).append(", pkg=");
      ((StringBuilder)localObject1).append(paramXmlData.strPkgName);
      ((StringBuilder)localObject1).append(", serverVer=");
      ((StringBuilder)localObject1).append(paramXmlData.Version);
      ((StringBuilder)localObject1).append(" localVer=");
      ((StringBuilder)localObject1).append(localXmlData.Version);
      ((StringBuilder)localObject1).append(" localState=");
      ((StringBuilder)localObject1).append(localXmlData.loadState);
      ((StringBuilder)localObject1).append(",strResURL_big = ");
      ((StringBuilder)localObject1).append(paramXmlData.strResURL_big);
      ((StringBuilder)localObject1).append(",handler = ");
      ((StringBuilder)localObject1).append(this);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.equals(paramXmlData.strPkgName, localXmlData.strPkgName))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnServerResp() pkgName mismatch! resp:");
      ((StringBuilder)localObject1).append(paramXmlData.strPkgName);
      ((StringBuilder)localObject1).append(" vs local:");
      ((StringBuilder)localObject1).append(localXmlData.strPkgName);
      ((StringBuilder)localObject1).append(", will abandon download this time!");
      QLog.w("EarlyHandler", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    File localFile1 = new File(k());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fStorage=");
      ((StringBuilder)localObject1).append(localFile1.getAbsolutePath());
      ((StringBuilder)localObject1).append(", exist=");
      ((StringBuilder)localObject1).append(localFile1.exists());
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1 = localFile1.exists();
    Object localObject8 = null;
    boolean bool2 = false;
    if (bool1)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fStorage.length=");
        ((StringBuilder)localObject1).append(localFile1.length());
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
      }
      for (;;)
      {
        try
        {
          localObject1 = HexUtil.bytes2HexStr(MD5.getFileMd5(localFile1.getAbsolutePath()));
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, new Object[] { "doOnServerResp, fStorage, OutOfMemoryError, oom.message=", localOutOfMemoryError1.getMessage() });
            localOutOfMemoryError1.printStackTrace();
          }
          try
          {
            localObject2 = MD5FileUtil.a(localFile1);
          }
          catch (Exception localException1)
          {
            try
            {
              Object localObject2;
              FileUtils.copyFile((File)localObject7, localFile2);
              if (QLog.isColorLevel())
              {
                paramXmlData = new StringBuilder();
                paramXmlData.append("doOnServerResp() copy[");
                paramXmlData.append(((File)localObject7).getAbsolutePath());
                paramXmlData.append("] to [");
                paramXmlData.append(localFile2.getAbsolutePath());
                paramXmlData.append("]");
                QLog.d("EarlyDown", 2, paramXmlData.toString());
              }
              return;
            }
            catch (Exception paramXmlData) {}
            localException1 = localException1;
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("verifyResource() get file md5 failed:");
            ((StringBuilder)localObject2).append(localFile1.getAbsolutePath());
            QLog.e("EarlyDown", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = null;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, new Object[] { "doOnServerResp, fStorage, UnsatisfiedLinkError, e.message=", localUnsatisfiedLinkError1.getMessage() });
            localUnsatisfiedLinkError1.printStackTrace();
          }
        }
        try
        {
          localObject3 = MD5FileUtil.a(localFile1);
        }
        catch (Exception localException2)
        {
          Object localObject3;
          label547:
          File localFile2;
          Object localObject4;
          StringBuilder localStringBuilder;
          Object localObject5;
          Object localObject6;
          Object localObject7;
          break label547;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("verifyResource() get file md5 failed:");
          ((StringBuilder)localObject3).append(localFile1.getAbsolutePath());
          QLog.e("EarlyDown", 2, ((StringBuilder)localObject3).toString());
        }
      }
      if ((localObject3 != null) && (paramXmlData.MD5 != null) && (((String)localObject3).toLowerCase().equals(paramXmlData.MD5.toLowerCase())))
      {
        localObject8 = localFile1;
      }
      else
      {
        localFile1.delete();
        j();
      }
    }
    else
    {
      localObject3 = null;
    }
    localFile2 = new File(l());
    if (QLog.isColorLevel())
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("fBackup=");
      ((StringBuilder)localObject4).append(localFile2.getAbsolutePath());
      ((StringBuilder)localObject4).append(", exist=");
      ((StringBuilder)localObject4).append(localFile2.exists());
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject4).toString());
    }
    localObject4 = localObject8;
    if (localObject8 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("fBackup.length=");
        ((StringBuilder)localObject4).append(localFile2.length());
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject4).toString());
      }
      try
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject4).append("early/");
        ((StringBuilder)localObject4).append(this.b);
        localObject4 = new File(((StringBuilder)localObject4).toString());
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("copy oldBackupFile=");
          localStringBuilder.append(((File)localObject4).getAbsolutePath());
          localStringBuilder.append(", exist=");
          localStringBuilder.append(((File)localObject4).exists());
          QLog.d("EarlyDown", 2, localStringBuilder.toString());
        }
        if ((!localFile2.exists()) && (((File)localObject4).exists()))
        {
          bool1 = FileUtils.copyFile((File)localObject4, localFile2);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("copy oldBackupFile:");
            localStringBuilder.append(bool1);
            QLog.d("EarlyDown", 2, localStringBuilder.toString());
          }
        }
        if (((File)localObject4).exists())
        {
          bool1 = ((File)localObject4).delete();
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("delete oldBackupFile:");
            ((StringBuilder)localObject4).append(bool1);
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject4).toString());
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealing old backup file, exception:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.d("EarlyDown", 1, localStringBuilder.toString());
      }
      localObject5 = localObject8;
      if (localFile2.exists()) {
        try
        {
          localObject5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localFile2.getAbsolutePath()));
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, new Object[] { "doOnServerResp, fBackup, OutOfMemoryError, oom.message=", localOutOfMemoryError2.getMessage() });
            localOutOfMemoryError2.printStackTrace();
          }
          try
          {
            localObject6 = MD5FileUtil.a(localFile2);
          }
          catch (Exception localException4)
          {
            break label1136;
          }
          localObject6 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("verifyResource() get file md5 failed:");
            ((StringBuilder)localObject6).append(localFile2.getAbsolutePath());
            QLog.e("EarlyDown", 2, ((StringBuilder)localObject6).toString());
            localObject6 = localObject3;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          label1136:
          if (QLog.isColorLevel())
          {
            QLog.d("EarlyDown", 2, new Object[] { "doOnServerResp, fBackup, UnsatisfiedLinkError, e.message=", localUnsatisfiedLinkError2.getMessage() });
            localUnsatisfiedLinkError2.printStackTrace();
          }
        }
      }
    }
    try
    {
      localObject7 = MD5FileUtil.a(localFile2);
    }
    catch (Exception localException5)
    {
      label1239:
      break label1239;
    }
    localObject7 = localObject3;
    if (QLog.isColorLevel())
    {
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("verifyResource() get file md5 failed:");
      ((StringBuilder)localObject7).append(localFile2.getAbsolutePath());
      QLog.e("EarlyDown", 2, ((StringBuilder)localObject7).toString());
      localObject7 = localObject3;
    }
    if ((localObject7 != null) && (paramXmlData.MD5 != null) && (((String)localObject7).toLowerCase().equals(paramXmlData.MD5.toLowerCase())))
    {
      localObject7 = localFile2;
    }
    else
    {
      localFile2.delete();
      j();
      localObject7 = localObject8;
    }
    if (localObject7 == null)
    {
      localXmlData.hasResDownloaded = false;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("EarlyHandler, doOnServerResp, fValidRes NotExist, hasResDownloaded=false, resName=");
        ((StringBuilder)localObject3).append(this.b);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
      }
      EarlyDataFactory.a(localXmlData, new String[] { "hasResDownloaded" });
      if (!v())
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("user not need download.just save data and do nothing. resName=");
          ((StringBuilder)localObject3).append(this.b);
          QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
        }
        localXmlData.updateServerInfo(paramXmlData);
        localXmlData.loadState = 1;
        EarlyDataFactory.a(localXmlData, new String[0]);
        bool1 = bool2;
      }
      else if (paramXmlData.Version < localXmlData.Version)
      {
        bool1 = bool2;
      }
      else if (paramXmlData.Version == localXmlData.Version)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("same version, loadState=");
          ((StringBuilder)localObject3).append(localXmlData.loadState);
          ((StringBuilder)localObject3).append(". resName=");
          ((StringBuilder)localObject3).append(this.b);
          QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
        }
        bool1 = bool2;
        if (localXmlData.loadState != 1)
        {
          localXmlData.updateServerInfo(paramXmlData);
          EarlyDataFactory.a(localXmlData, new String[0]);
          paramXmlData = (IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "");
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("same version, state not suc. isUserClick=");
            ((StringBuilder)localObject3).append(localXmlData.isUserClick);
            ((StringBuilder)localObject3).append(". notPreDownInLowEndPhone=");
            ((StringBuilder)localObject3).append(localXmlData.notPreDownloadInLowEndPhone);
            ((StringBuilder)localObject3).append(". isLowEndPhone=");
            ((StringBuilder)localObject3).append(paramXmlData.isLowEndPhone());
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
          }
          if ((!localXmlData.isUserClick) && (localXmlData.notPreDownloadInLowEndPhone))
          {
            bool1 = bool2;
            if (paramXmlData.isLowEndPhone()) {}
          }
          else
          {
            bool1 = o();
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramXmlData.Version > localXmlData.Version)
        {
          localXmlData.updateServerInfo(paramXmlData);
          EarlyDataFactory.a(localXmlData, new String[0]);
          paramXmlData = (IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "");
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("resp new version.  isUserClick=");
            ((StringBuilder)localObject3).append(localXmlData.isUserClick);
            ((StringBuilder)localObject3).append(". notPreDownInLowEndPhone=");
            ((StringBuilder)localObject3).append(localXmlData.notPreDownloadInLowEndPhone);
            ((StringBuilder)localObject3).append(". isLowEndPhone=");
            ((StringBuilder)localObject3).append(paramXmlData.isLowEndPhone());
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
          }
          if ((!localXmlData.isUserClick) && (localXmlData.notPreDownloadInLowEndPhone))
          {
            bool1 = bool2;
            if (paramXmlData.isLowEndPhone()) {}
          }
          else
          {
            bool1 = o();
          }
        }
      }
      if (!bool1)
      {
        ((IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "")).removeRequesting(localXmlData.getStrResName());
        d(localXmlData);
      }
    }
    else
    {
      localXmlData.updateServerInfo(paramXmlData);
      localXmlData.Version = paramXmlData.Version;
      localXmlData.loadState = 1;
      localXmlData.hasResDownloaded = true;
      EarlyDataFactory.a(localXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("EarlyHandler, doOnServerResp, fValidRes exist, hasResDownloaded=true, resName=");
        ((StringBuilder)localObject3).append(this.b);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localFile1.exists()) || (e())) {}
    }
    try
    {
      FileUtils.copyFile((File)localObject7, localFile1);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doOnServerResp() copy[");
        ((StringBuilder)localObject3).append(((File)localObject7).getAbsolutePath());
        ((StringBuilder)localObject3).append("] to [");
        ((StringBuilder)localObject3).append(localFile1.getAbsolutePath());
        ((StringBuilder)localObject3).append("]");
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
      }
    }
    catch (Exception localException3)
    {
      label2141:
      break label2141;
    }
    EarlyDataFactory.a(localXmlData, new String[0]);
    a(((File)localObject7).getAbsolutePath());
    ((IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "")).removeRequesting(localXmlData.getStrResName());
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("doOnServerResp() ");
      ((StringBuilder)localObject3).append(localXmlData.strResName);
      ((StringBuilder)localObject3).append(" doBackup by[");
      ((StringBuilder)localObject3).append(((File)localObject7).getAbsolutePath());
      ((StringBuilder)localObject3).append("]");
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
    }
    if (this.g)
    {
      localObject3 = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
      ((Intent)localObject3).putExtra("strResName", this.b);
      ((Intent)localObject3).putExtra("strPkgName", localXmlData.strPkgName);
      ((Intent)localObject3).putExtra("loadState", 1);
      ((Intent)localObject3).putExtra("totalSize", localXmlData.totalSize);
      ((Intent)localObject3).putExtra("downSize", localXmlData.downSize);
      ((Intent)localObject3).putExtra("resPath", ((File)localObject7).getAbsolutePath());
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject3, "com.tencent.qqhead.permission.getheadresp");
      this.g = false;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("set isBroadcast false. send Broadcast: resName");
        ((StringBuilder)localObject3).append(this.b);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
      }
    }
    localObject3 = new HashMap();
    ((HashMap)localObject3).put("param_strPkgName", localXmlData.strPkgName);
    ((HashMap)localObject3).put("param_byBackup", Boolean.TRUE.toString());
    localObject8 = b();
    if ((localObject8 != null) && (((String)localObject8).length() > 0)) {
      StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.c.getCurrentAccountUin(), (String)localObject8, true, 2000L, localFile1.length(), (HashMap)localObject3, "");
    }
    if ((!localFile2.exists()) && (paramXmlData.StoreBackup)) {}
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadFinish() result=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" filePath=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramXmlData.hasResDownloaded = true;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("EarlyHandler, onDownloadFinish,download Successful, hasResDownloaded=true, resName=");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
      }
      a(paramString);
      ((IPreDownloadController)this.c.getRuntimeService(IPreDownloadController.class, "")).preDownloadSuccess(paramXmlData.strResURL_big, paramXmlData.downSize);
    }
    else
    {
      paramXmlData.hasResDownloaded = false;
      EarlyDataFactory.a(paramXmlData, new String[] { "hasResDownloaded" });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EarlyHandler, onDownloadFinish,download failed, hasResDownloaded=false, resName=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("EarlyDown", 1, ((StringBuilder)localObject).toString());
      localObject = this.d;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.d.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData, paramBoolean, paramInt, e(), paramString);
        }
      }
    }
    if (this.g)
    {
      localObject = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
      if (paramInt == 9037) {
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_CANCEL");
      } else {
        ((Intent)localObject).setAction("resp.com.tencent.mobileqq.EARLY_QUERY");
      }
      ((Intent)localObject).putExtra("strResName", this.b);
      ((Intent)localObject).putExtra("strPkgName", h().strPkgName);
      ((Intent)localObject).putExtra("loadState", h().loadState);
      ((Intent)localObject).putExtra("totalSize", paramXmlData.totalSize);
      ((Intent)localObject).putExtra("downSize", paramXmlData.downSize);
      ((Intent)localObject).putExtra("errCode", paramInt);
      ((Intent)localObject).putExtra("resPath", paramString);
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
      this.g = false;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownLoadListener)((Iterator)localObject).next()).a(h(), true, 0, e(), paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    new File(k()).delete();
    XmlData localXmlData = h();
    localXmlData.Version = 0;
    localXmlData.tLoadFail = 0L;
    localXmlData.loadState = 0;
    localXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    localXmlData.isUserClick = paramBoolean;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("restartDownload(), this.strResName=");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(", resName=");
      ((StringBuilder)localObject1).append(localXmlData.strResName);
      ((StringBuilder)localObject1).append(", user=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Intent();
    Object localObject2 = q();
    if (localObject2 != null)
    {
      IEarlyDownloadService localIEarlyDownloadService = (IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "");
      if ((localIEarlyDownloadService != null) && (!localIEarlyDownloadService.isRequesting(localXmlData.getStrResName())))
      {
        ((Intent)localObject1).putExtra("reqResult", true);
        localIEarlyDownloadService.addRequesting(localXmlData.getStrResName());
        ((IConfigHandlerTempService)this.c.getRuntimeService(IConfigHandlerTempService.class, "")).doConfigHandlerUpdateConfigs(this.c, null, new GetResourceReqInfo[] { localObject2 });
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, String.format("restartDownload() res[%s] is downloading", new Object[] { localXmlData.getStrResName() }));
        }
        ((Intent)localObject1).putExtra("reqResult", false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("strPkgName=");
        ((StringBuilder)localObject2).append(localXmlData.strPkgName);
        ((Intent)localObject1).putExtra("resultReason", ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      ((Intent)localObject1).putExtra("reqResult", false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("strPkgName=");
      ((StringBuilder)localObject2).append(localXmlData.strPkgName);
      ((Intent)localObject1).putExtra("resultReason", ((StringBuilder)localObject2).toString());
    }
    if (this.g)
    {
      ((Intent)localObject1).setAction("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
      ((Intent)localObject1).putExtra("strResName", this.b);
      ((Intent)localObject1).putExtra("strPkgName", localXmlData.strPkgName);
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp");
    }
  }
  
  public abstract String b();
  
  public GetResourceReqInfoV2 b(String paramString)
  {
    XmlData localXmlData = h();
    long l = 0L;
    GetResourceReqInfoV2 localGetResourceReqInfoV2;
    if (localXmlData == null)
    {
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      localGetResourceReqInfoV2.uiCurVer = 0L;
    }
    else
    {
      localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
      localGetResourceReqInfoV2.cState = 0;
      localGetResourceReqInfoV2.sLanType = 1;
      localGetResourceReqInfoV2.sResSubType = 1;
      localGetResourceReqInfoV2.strPkgName = paramString;
      if (!p()) {
        l = f();
      }
      localGetResourceReqInfoV2.uiCurVer = l;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResourceReqInfoV2(), strPkgName=");
      localStringBuilder.append(paramString);
      paramString = new StringBuffer(localStringBuilder.toString());
      if (localXmlData == null)
      {
        paramString.append(",data==null");
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(",this.strResName=[");
        localStringBuilder.append(this.b);
        paramString.append(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("], resName=[");
        localStringBuilder.append(localXmlData.strResName);
        paramString.append(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("], pkgName=[");
        localStringBuilder.append(localXmlData.strPkgName);
        paramString.append(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("], version=[");
        localStringBuilder.append(localXmlData.Version);
        paramString.append(localStringBuilder.toString());
      }
      QLog.d("EarlyDown", 2, paramString.toString());
    }
    return localGetResourceReqInfoV2;
  }
  
  public void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "onDownloadBegin()");
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownLoadListener)((Iterator)localObject).next()).a(paramXmlData);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setIsBroadcast() ");
        localStringBuilder.append(paramBoolean);
        QLog.d("EarlyDown", 2, localStringBuilder.toString());
      }
    }
  }
  
  public abstract int c();
  
  public void c(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.e("EarlyDown", 2, "onDownloadCancel");
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EarlyDownLoadListener)((Iterator)localObject).next()).b(paramXmlData);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setFail() resName:");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = h();
    if (localObject != null)
    {
      if (((XmlData)localObject).loadState == 1)
      {
        ((XmlData)localObject).loadState = 0;
        ((XmlData)localObject).Version = 0;
      }
      else if ((((XmlData)localObject).loadState == 2) && (paramBoolean))
      {
        ((XmlData)localObject).loadState = 0;
      }
      ((XmlData)localObject).hasResDownloaded = false;
      EarlyDataFactory.a((XmlData)localObject, new String[] { "loadState", "Version", "hasResDownloaded" });
    }
  }
  
  public abstract String d();
  
  public void d(XmlData paramXmlData) {}
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        if (!this.e)
        {
          this.e = true;
          break label155;
          if (!this.f)
          {
            this.f = true;
            break label155;
          }
        }
        if (i == 1)
        {
          Object localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_strResName", this.b);
          StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.c.getCurrentAccountUin(), "actEarlyDownUse", paramBoolean, 0L, 0L, (HashMap)localObject1, "");
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("statisticUsage() strResName=");
            ((StringBuilder)localObject1).append(this.b);
            ((StringBuilder)localObject1).append(" inUse=");
            ((StringBuilder)localObject1).append(paramBoolean);
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
          }
        }
        return;
      }
      finally {}
      label155:
      i = 1;
    }
  }
  
  public void e(boolean paramBoolean) {}
  
  public abstract boolean e();
  
  public int f()
  {
    XmlData localXmlData = h();
    if (localXmlData != null) {
      return localXmlData.Version;
    }
    return 0;
  }
  
  public void g()
  {
    ArrayList localArrayList = this.d;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
  
  public final XmlData h()
  {
    if (this.h == null) {
      this.h = EarlyDataFactory.a(a());
    }
    return this.h;
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public void j() {}
  
  public String k()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MobileQQ.sMobileQQ.getApplicationContext().getFilesDir());
    ((StringBuilder)localObject).append("/pddata/prd/early");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public String l()
  {
    String str = VFSAssistantUtils.getSDKPrivatePath(e_);
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(this.b);
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBackupPath ,SDCARD_DIR = ");
      localStringBuilder.append(e_);
      localStringBuilder.append(",vfsDir = ");
      localStringBuilder.append(str);
      localStringBuilder.append(",filepath = ");
      localStringBuilder.append((String)localObject);
      QLog.d("EarlyHandler", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public boolean m()
  {
    XmlData localXmlData = h();
    if (localXmlData != null)
    {
      boolean bool2;
      StringBuilder localStringBuilder;
      if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ.getApplicationContext()))
      {
        bool2 = localXmlData.loadWifi;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNetValid2Down() return:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(" isWifiConn=true, ");
        localStringBuilder.append(localXmlData.strResName);
        localStringBuilder.append(":loadWifi=");
        localStringBuilder.append(localXmlData.loadWifi);
        QLog.d("EarlyDown", 2, localStringBuilder.toString());
        return bool2;
      }
      if (NetworkUtil.isMobileNetWork(MobileQQ.sMobileQQ.getApplicationContext()))
      {
        if (NetworkUtil.is3Gor4G(MobileQQ.sMobileQQ.getApplicationContext()))
        {
          bool2 = localXmlData.load3G;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            return bool1;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isNetValid2Down() return:");
          localStringBuilder.append(bool2);
          localStringBuilder.append(" is3Gor4G=true, ");
          localStringBuilder.append(localXmlData.strResName);
          localStringBuilder.append(":load3G=");
          localStringBuilder.append(localXmlData.load3G);
          QLog.d("EarlyDown", 2, localStringBuilder.toString());
          return bool2;
        }
        bool2 = localXmlData.load2G;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNetValid2Down() return:");
        localStringBuilder.append(bool2);
        localStringBuilder.append(" is2G=true, ");
        localStringBuilder.append(localXmlData.strResName);
        localStringBuilder.append(":load2G=");
        localStringBuilder.append(localXmlData.load2G);
        QLog.d("EarlyDown", 2, localStringBuilder.toString());
        return bool2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "isNetValid2Down() return:false, no wifi and no MobileNet.");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("EarlyDown", 2, "isNetValid2Download() return false, data == null");
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public boolean n()
  {
    XmlData localXmlData = h();
    boolean bool2 = false;
    boolean bool3 = false;
    if (localXmlData != null)
    {
      long l = System.currentTimeMillis();
      boolean bool1;
      if (localXmlData.tLoadFail != 0L)
      {
        bool1 = bool3;
        if (localXmlData.tLoadFail > 0L)
        {
          bool1 = bool3;
          if (localXmlData.tLoadFail + 43200000L >= l) {}
        }
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isTimeValid() ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" res=");
        localStringBuilder.append(localXmlData.strResName);
        localStringBuilder.append(" tLoadFail=");
        localStringBuilder.append(localXmlData.tLoadFail);
        QLog.d("EarlyDown", 2, localStringBuilder.toString());
        bool2 = bool1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "isTimeValid() = false,  data = null");
    }
    return bool2;
  }
  
  public boolean o()
  {
    Object localObject = h();
    boolean bool2 = m();
    if (!n()) {
      if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ.getApplicationContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "wifi connected,reset timeValid=true");
        }
      }
      else
      {
        bool1 = false;
        break label54;
      }
    }
    boolean bool1 = true;
    label54:
    if ((bool2) && (bool1))
    {
      ((IEarlyDownloadService)this.c.getRuntimeService(IEarlyDownloadService.class, "")).downloadResource((XmlData)localObject, k());
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadResource() return false, netValid=");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(" timeValid=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" strResName=");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean p()
  {
    Object localObject = h();
    boolean bool2 = true;
    int i;
    boolean bool1;
    if (localObject == null)
    {
      i = 1;
      bool1 = bool2;
    }
    else
    {
      System.currentTimeMillis();
      i = ((XmlData)localObject).loadState;
      boolean bool3 = false;
      int j = -1;
      if (i == 1)
      {
        bool1 = bool3;
        i = j;
        if (!e())
        {
          bool1 = bool3;
          i = j;
          if (!new File(k()).exists())
          {
            c(false);
            s();
            bool1 = true;
            i = 2;
          }
        }
      }
      else if ((((XmlData)localObject).Version != 0) && (((XmlData)localObject).loadState != 2))
      {
        ((XmlData)localObject).Version = 0;
        EarlyDataFactory.a((XmlData)localObject, new String[] { "Version" });
        bool1 = true;
        i = 3;
      }
      else
      {
        bool1 = true;
        i = j;
      }
      if (!((XmlData)localObject).hasResDownloaded)
      {
        i = 4;
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedServerInfo(), ");
      ((StringBuilder)localObject).append(h().strResName);
      ((StringBuilder)localObject).append(", need=");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", needTrueReasonCode =");
      ((StringBuilder)localObject).append(i);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public GetResourceReqInfo q()
  {
    XmlData localXmlData = h();
    Object localObject;
    if ((localXmlData != null) && (localXmlData.strPkgName != null) && (localXmlData.strPkgName.length() > 0))
    {
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = localXmlData.strPkgName;
      ((GetResourceReqInfo)localObject).uiCurVer = f();
      ((GetResourceReqInfo)localObject).sResType = 512;
      ((GetResourceReqInfo)localObject).sLanType = 1;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      return localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuffer("getResourceReqInfo() return null.");
      if (localXmlData == null)
      {
        ((StringBuffer)localObject).append("data==null");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resName=");
        localStringBuilder.append(localXmlData.strResName);
        ((StringBuffer)localObject).append(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(".pkgName=");
        localStringBuilder.append(localXmlData.strPkgName);
        ((StringBuffer)localObject).append(localStringBuilder.toString());
      }
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject).toString());
    }
    return null;
  }
  
  public boolean r()
  {
    XmlData localXmlData = h();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localXmlData != null)
    {
      bool1 = bool2;
      if (localXmlData.loadState == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void s()
  {
    if (!e()) {
      new File(k()).delete();
    }
  }
  
  public void t()
  {
    if (e())
    {
      File localFile = new File(k());
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doAfterFinish() deleteResouceAfterDownload==true, delete storage:");
          localStringBuilder.append(localFile.getAbsolutePath());
          localStringBuilder.append(" bool=");
          localStringBuilder.append(bool);
          QLog.d("EarlyDown", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void u()
  {
    String str = k();
    try
    {
      new File(str).delete();
      label17:
      EarlyDataFactory.a(h());
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  public boolean v()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.EarlyHandler
 * JD-Core Version:    0.7.0.1
 */