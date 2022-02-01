package cooperation.ilive;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.IDataLocalTmpPmUpdaterFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginManagerUpdater;
import cooperation.ilive.config.IliveConfigBean;
import cooperation.ilive.manager.IliveDbManager;
import java.io.File;
import java.util.LinkedList;

public class IlivePluginDownloadManager
{
  private static IlivePluginDownloadManager a;
  private DownloaderFactory b = new DownloaderFactory(BaseApplicationImpl.getApplication().getRuntime());
  private IliveDownloadCallback c;
  private IlivePluginDownloadManager.IliveDownloadListener d;
  private PluginManagerUpdater e = ((IDataLocalTmpPmUpdaterFactory)QRoute.api(IDataLocalTmpPmUpdaterFactory.class)).createDataLocalTmpPmUpdater("ilive");
  private LinkedList<DownloadTask> f = new LinkedList();
  private IliveConfigBean g;
  private IliveConfigBean h;
  private boolean i = false;
  
  public static IlivePluginDownloadManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new IlivePluginDownloadManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    IliveDownloadCallback localIliveDownloadCallback = this.c;
    if (localIliveDownloadCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin download fail , type = ");
      localStringBuilder.append(paramDownloadTask.b);
      localStringBuilder.append(" , msg = ");
      localStringBuilder.append(paramDownloadTask.d);
      localStringBuilder.append(" , code = ");
      localStringBuilder.append(paramDownloadTask.H);
      localStringBuilder.append(" , errorCode=");
      localStringBuilder.append(paramDownloadTask.c);
      localIliveDownloadCallback.onFail(105, localStringBuilder.toString());
    }
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pddata");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("vas");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qq_ilive");
    return localStringBuilder.toString();
  }
  
  private String n()
  {
    String str = e();
    Object localObject = str;
    if (this.i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private boolean o()
  {
    IliveConfigBean localIliveConfigBean = this.g;
    return (localIliveConfigBean != null) && (!TextUtils.isEmpty(localIliveConfigBean.c()));
  }
  
  private void p()
  {
    if (this.f.size() > 0)
    {
      a((DownloadTask)this.f.get(0), this.d);
      return;
    }
    QLog.e("IlivePluginDownloadManager", 1, "runTask finish");
  }
  
  private boolean q()
  {
    Object localObject = new File(e());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPluginFileIsNeedDownload  pluginFilePath = ");
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    if (!((File)localObject).exists()) {
      return true;
    }
    localObject = this.g;
    if (localObject == null)
    {
      localObject = this.c;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onFail(104, "preload check config bean = null");
      }
      return false;
    }
    if (TextUtils.isEmpty(((IliveConfigBean)localObject).b())) {}
    return false;
  }
  
  private DownloaderInterface r()
  {
    return this.b.a(2);
  }
  
  private void s()
  {
    if (this.c == null) {
      return;
    }
    if (w())
    {
      v();
      z();
      x();
      u();
      this.c.onSuccess();
      return;
    }
    t();
    this.c.onFail(106, "file invalid , check file md5");
  }
  
  private void t()
  {
    if (this.g == null) {
      return;
    }
    File localFile = new File(n());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteLocalIliveFile , pluginFile = ");
      localStringBuilder.append(n());
      QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  private void u()
  {
    if (!this.i) {
      return;
    }
    IlivePluginHelper.a(BaseApplicationImpl.getContext());
  }
  
  private void v()
  {
    try
    {
      if (!this.i) {
        return;
      }
      String str = n();
      Object localObject = new File(str);
      File localFile = new File(e());
      if (localFile.exists()) {
        localFile.delete();
      }
      if (((File)localObject).exists()) {
        ((File)localObject).renameTo(localFile);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("download success copy file , downloadFile = ");
        ((StringBuilder)localObject).append(str);
        QLog.i("IlivePluginDownloadManager", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean w()
  {
    Object localObject = this.g;
    boolean bool = true;
    if (localObject == null) {
      return true;
    }
    if ((!TextUtils.isEmpty(((IliveConfigBean)localObject).b())) && (!this.g.b().equalsIgnoreCase(MD5Utils.encodeFileHexStr(n())))) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download success check file valid , isPluginValid = ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("IlivePluginDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void x()
  {
    if (this.h == null) {
      return;
    }
    y();
  }
  
  private void y()
  {
    if (this.g != null)
    {
      Object localObject = this.h;
      if (localObject == null) {
        return;
      }
      if (!TextUtils.isEmpty(((IliveConfigBean)localObject).c()))
      {
        if (this.h.c().equals(this.g.c()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("IlivePluginDownloadManager", 2, "stop deletePluginFile file equal ");
          }
          return;
        }
        localObject = new File(this.h.a());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("deletePluginFile , pluginFile = ");
          localStringBuilder.append(this.h.a());
          QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
        }
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
    }
  }
  
  private void z()
  {
    if (this.g == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveConfigBean , config = ");
    localStringBuilder.append(this.g.toString());
    QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    IliveDbManager.saveIliveConfigBean(2, this.g);
  }
  
  public DownloadTask a(File paramFile)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return null;
    }
    localObject = ((IliveConfigBean)localObject).c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createDownloadTask url = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" saveFile = ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    paramFile = new DownloadTask((String)localObject, paramFile);
    paramFile.q = true;
    paramFile.N = true;
    paramFile.Q = true;
    paramFile.P = true;
    paramFile.D = true;
    paramFile.J = false;
    paramFile.T = false;
    return paramFile;
  }
  
  public void a(DownloadTask paramDownloadTask, DownloadListener paramDownloadListener)
  {
    if (paramDownloadTask == null) {
      return;
    }
    cooperation.ilive.time.TimeMonitorConfig.a = true;
    r().startDownload(paramDownloadTask, paramDownloadListener, null);
  }
  
  public void a(IliveDownloadCallback paramIliveDownloadCallback)
  {
    this.c = paramIliveDownloadCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    l();
  }
  
  public PluginManagerUpdater c()
  {
    return this.e;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ilive_plugin_v7.apk");
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    IliveConfigBean localIliveConfigBean = this.g;
    if (localIliveConfigBean != null) {
      return localIliveConfigBean.a();
    }
    return "";
  }
  
  public String f()
  {
    IliveConfigBean localIliveConfigBean = this.g;
    if (localIliveConfigBean != null) {
      return localIliveConfigBean.b();
    }
    return "";
  }
  
  public void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelDownloadFile size = ");
    localStringBuilder.append(this.f.size());
    QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    r().cancelTask(true, null);
  }
  
  public boolean h()
  {
    new File("/data/local/tmp/plugin-debug.zip");
    return false;
  }
  
  public void i()
  {
    this.g = IliveConfigBean.d();
    this.h = m();
    this.h.a = this.g.a;
    StringBuilder localStringBuilder;
    if (this.g != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readIliveConfig , current config = ");
      localStringBuilder.append(this.g.toString());
      QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    }
    if (this.h != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readIliveConfig , last config = ");
      localStringBuilder.append(this.h.toString());
      QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    }
  }
  
  public IliveConfigBean j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    if (h()) {
      return true;
    }
    File localFile = new File(d());
    if (!localFile.exists())
    {
      QLog.e("IlivePluginDownloadManager", 1, "isPluginFileExist copy apkFile");
      FileUtils.copyAssetToFile(BaseApplicationImpl.getContext(), "live_shopping_manager.apk", d());
    }
    boolean bool1 = localFile.exists();
    boolean bool2 = q();
    return (bool1) && ((bool2 ^ true));
  }
  
  public void l()
  {
    if (!o())
    {
      localObject = this.c;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onFail(103, "download fail , config data = null");
      }
      return;
    }
    if (h())
    {
      localObject = this.c;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onSuccess();
      }
      return;
    }
    this.f.clear();
    if (q())
    {
      localObject = a(new File(n()));
      this.f.add(localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadFile count = ");
    ((StringBuilder)localObject).append(this.f.size());
    QLog.e("IlivePluginDownloadManager", 1, ((StringBuilder)localObject).toString());
    if (this.f.size() > 0)
    {
      this.d = new IlivePluginDownloadManager.IliveDownloadListener(this, null);
      p();
      return;
    }
    localObject = this.c;
    if (localObject != null) {
      ((IliveDownloadCallback)localObject).onSuccess();
    }
  }
  
  public IliveConfigBean m()
  {
    return IliveDbManager.getIliveConfigBean(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IlivePluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */