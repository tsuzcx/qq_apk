package cooperation.ilive;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Utils;
import com.tencent.mobileqq.intervideo.IDataLocalTmpPmUpdaterFactory;
import com.tencent.mobileqq.qroute.QRoute;
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
  private static IlivePluginDownloadManager jdField_a_of_type_CooperationIliveIlivePluginDownloadManager;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(BaseApplicationImpl.getApplication().getRuntime());
  private PluginManagerUpdater jdField_a_of_type_ComTencentShadowDynamicHostPluginManagerUpdater = ((IDataLocalTmpPmUpdaterFactory)QRoute.api(IDataLocalTmpPmUpdaterFactory.class)).createDataLocalTmpPmUpdater("ilive");
  private IliveDownloadCallback jdField_a_of_type_CooperationIliveIliveDownloadCallback;
  private IlivePluginDownloadManager.IliveDownloadListener jdField_a_of_type_CooperationIliveIlivePluginDownloadManager$IliveDownloadListener;
  private IliveConfigBean jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
  private LinkedList<DownloadTask> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private IliveConfigBean b;
  
  private DownloaderInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(2);
  }
  
  public static IlivePluginDownloadManager a()
  {
    if (jdField_a_of_type_CooperationIliveIlivePluginDownloadManager == null) {
      try
      {
        if (jdField_a_of_type_CooperationIliveIlivePluginDownloadManager == null) {
          jdField_a_of_type_CooperationIliveIlivePluginDownloadManager = new IlivePluginDownloadManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_CooperationIliveIlivePluginDownloadManager;
  }
  
  public static String a()
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
  
  private void a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    IliveDownloadCallback localIliveDownloadCallback = this.jdField_a_of_type_CooperationIliveIliveDownloadCallback;
    if (localIliveDownloadCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plugin download fail , type = ");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" , msg = ");
      localStringBuilder.append(paramDownloadTask.b);
      localStringBuilder.append(" , code = ");
      localStringBuilder.append(paramDownloadTask.f);
      localStringBuilder.append(" , errorCode=");
      localStringBuilder.append(paramDownloadTask.jdField_a_of_type_Int);
      localIliveDownloadCallback.onFail(105, localStringBuilder.toString());
    }
  }
  
  private boolean c()
  {
    IliveConfigBean localIliveConfigBean = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
    return (localIliveConfigBean != null) && (!TextUtils.isEmpty(localIliveConfigBean.c()));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      a((DownloadTask)this.jdField_a_of_type_JavaUtilLinkedList.get(0), this.jdField_a_of_type_CooperationIliveIlivePluginDownloadManager$IliveDownloadListener);
      return;
    }
    QLog.e("IlivePluginDownloadManager", 1, "runTask finish");
  }
  
  private boolean d()
  {
    Object localObject = new File(c());
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
    localObject = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_CooperationIliveIliveDownloadCallback;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onFail(104, "preload check config bean = null");
      }
      return false;
    }
    if (TextUtils.isEmpty(((IliveConfigBean)localObject).b())) {}
    return false;
  }
  
  private String e()
  {
    String str = c();
    Object localObject = str;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".tmp");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback == null) {
      return;
    }
    if (e())
    {
      h();
      k();
      i();
      g();
      this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onSuccess();
      return;
    }
    f();
    this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onFail(106, "file invalid , check file md5");
  }
  
  private boolean e()
  {
    Object localObject = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
    boolean bool = true;
    if (localObject == null) {
      return true;
    }
    if ((!TextUtils.isEmpty(((IliveConfigBean)localObject).b())) && (!this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.b().equalsIgnoreCase(MD5Utils.encodeFileHexStr(e())))) {
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
  
  private void f()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {
      return;
    }
    File localFile = new File(e());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteLocalIliveFile , pluginFile = ");
      localStringBuilder.append(e());
      QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    }
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    IlivePluginHelper.a(BaseApplicationImpl.getContext());
  }
  
  private void h()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      String str = e();
      Object localObject = new File(str);
      File localFile = new File(c());
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
  
  private void i()
  {
    if (this.b == null) {
      return;
    }
    j();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null)
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      if (!TextUtils.isEmpty(((IliveConfigBean)localObject).c()))
      {
        if (this.b.c().equals(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.c()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("IlivePluginDownloadManager", 2, "stop deletePluginFile file equal ");
          }
          return;
        }
        localObject = new File(this.b.a());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("deletePluginFile , pluginFile = ");
          localStringBuilder.append(this.b.a());
          QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
        }
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveConfigBean , config = ");
    localStringBuilder.append(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.toString());
    QLog.i("IlivePluginDownloadManager", 2, localStringBuilder.toString());
    IliveDbManager.saveIliveConfigBean(2, this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean);
  }
  
  public DownloadTask a(File paramFile)
  {
    Object localObject = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
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
    paramFile.e = true;
    paramFile.p = true;
    paramFile.r = true;
    paramFile.q = true;
    paramFile.j = true;
    paramFile.n = false;
    paramFile.s = false;
    return paramFile;
  }
  
  public PluginManagerUpdater a()
  {
    return this.jdField_a_of_type_ComTencentShadowDynamicHostPluginManagerUpdater;
  }
  
  public IliveConfigBean a()
  {
    return this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelDownloadFile size = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    a().cancelTask(true, null);
  }
  
  public void a(DownloadTask paramDownloadTask, DownloadListener paramDownloadListener)
  {
    if (paramDownloadTask == null) {
      return;
    }
    cooperation.ilive.time.TimeMonitorConfig.jdField_a_of_type_Boolean = true;
    a().startDownload(paramDownloadTask, paramDownloadListener, null);
  }
  
  public void a(IliveDownloadCallback paramIliveDownloadCallback)
  {
    this.jdField_a_of_type_CooperationIliveIliveDownloadCallback = paramIliveDownloadCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    new File("/data/local/tmp/plugin-debug.zip");
    return false;
  }
  
  public IliveConfigBean b()
  {
    return IliveDbManager.getIliveConfigBean(2);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ilive_plugin_v7.apk");
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean = IliveConfigBean.a();
    this.b = b();
    this.b.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.jdField_a_of_type_Boolean;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readIliveConfig , current config = ");
      localStringBuilder.append(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.toString());
      QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    }
    if (this.b != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("readIliveConfig , last config = ");
      localStringBuilder.append(this.b.toString());
      QLog.e("IlivePluginDownloadManager", 1, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    if (a()) {
      return true;
    }
    File localFile = new File(b());
    if (!localFile.exists())
    {
      QLog.e("IlivePluginDownloadManager", 1, "isPluginFileExist copy apkFile");
      Utils.a(BaseApplicationImpl.getContext(), "live_shopping_manager.apk", b());
    }
    boolean bool1 = localFile.exists();
    boolean bool2 = d();
    return (bool1) && ((bool2 ^ true));
  }
  
  public String c()
  {
    IliveConfigBean localIliveConfigBean = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
    if (localIliveConfigBean != null) {
      return localIliveConfigBean.a();
    }
    return "";
  }
  
  public void c()
  {
    if (!c())
    {
      localObject = this.jdField_a_of_type_CooperationIliveIliveDownloadCallback;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onFail(103, "download fail , config data = null");
      }
      return;
    }
    if (a())
    {
      localObject = this.jdField_a_of_type_CooperationIliveIliveDownloadCallback;
      if (localObject != null) {
        ((IliveDownloadCallback)localObject).onSuccess();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    if (d())
    {
      localObject = a(new File(e()));
      this.jdField_a_of_type_JavaUtilLinkedList.add(localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadFile count = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    QLog.e("IlivePluginDownloadManager", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      this.jdField_a_of_type_CooperationIliveIlivePluginDownloadManager$IliveDownloadListener = new IlivePluginDownloadManager.IliveDownloadListener(this, null);
      d();
      return;
    }
    localObject = this.jdField_a_of_type_CooperationIliveIliveDownloadCallback;
    if (localObject != null) {
      ((IliveDownloadCallback)localObject).onSuccess();
    }
  }
  
  public String d()
  {
    IliveConfigBean localIliveConfigBean = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
    if (localIliveConfigBean != null) {
      return localIliveConfigBean.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IlivePluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */