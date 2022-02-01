package com.tencent.mobileqq.download.unite.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.download.unite.util.UniteDownloadUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public class UniteDownloadDbOperator
{
  private EntityManager a;
  
  public static UniteDownloadDbOperator a()
  {
    return UniteDownloadDbOperator.SingletonHolder.a();
  }
  
  private void a(UniteDownloadEntity paramUniteDownloadEntity)
  {
    this.a.remove(paramUniteDownloadEntity);
  }
  
  private void b(String paramString)
  {
    this.a = QQEntityManagerFactoryProxy.a(paramString).createEntityManager();
  }
  
  private void c(String paramString)
  {
    b(paramString);
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramString = this.a.query(UniteDownloadEntity.class, UniteDownloadEntity.tableName(), false, "downloadTimestamp < ?", new String[] { String.valueOf(l - 2592000000L) }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        a((UniteDownloadEntity)paramString.next());
      }
    }
  }
  
  @Nullable
  public List<UniteDownloadEntity> a(String paramString1, String paramString2)
  {
    b(paramString1);
    return this.a.query(UniteDownloadEntity.class, UniteDownloadEntity.tableName(), false, "source = ?", new String[] { paramString2 }, null, null, null, null);
  }
  
  public void a(String paramString)
  {
    ThreadManager.excute(new UniteDownloadDbOperator.2(this, paramString), 32, null, false);
  }
  
  public void a(String paramString, DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new UniteDownloadDbOperator.1(this, paramDownloadInfo, paramString), 32, null, false);
    paramString = ((IUniformDownloadUtil)QRoute.api(IUniformDownloadUtil.class)).getApkName(paramDownloadInfo.l);
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramDownloadInfo.f) {
        ReportHelperKt.a("0X800B53A", 0, "", paramString);
      }
    }
    else {
      return;
    }
    if (DownloadManagerInterceptor.a(paramDownloadInfo.m))
    {
      UniteDownloadUtil.b(paramString);
      return;
    }
    UniteDownloadUtil.a(paramString);
  }
  
  public boolean a(String paramString, UniteDownloadEntity paramUniteDownloadEntity)
  {
    b(paramString);
    QLog.d("[UniteDownload] UniteDownloadDbOperator", 1, new Object[] { "[db] insertOrReplaceEntity: invoked. ", " uniteDownloadEntity: ", paramUniteDownloadEntity });
    if (this.a.isOpen())
    {
      if (paramUniteDownloadEntity.getStatus() == 1000)
      {
        this.a.persistOrReplace(paramUniteDownloadEntity);
        return paramUniteDownloadEntity.getStatus() == 1001;
      }
      if ((paramUniteDownloadEntity.getStatus() == 1001) || (paramUniteDownloadEntity.getStatus() == 1002)) {
        return this.a.update(paramUniteDownloadEntity);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator
 * JD-Core Version:    0.7.0.1
 */