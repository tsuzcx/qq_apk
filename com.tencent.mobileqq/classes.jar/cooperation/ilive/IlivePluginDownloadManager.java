package cooperation.ilive;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.kingkong.Utils;
import com.tencent.mobileqq.intervideo.DataLocalTmpPmUpdater;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveConfigBean;
import cooperation.ilive.manager.IliveDbManager;
import java.io.File;
import java.util.LinkedList;

public class IlivePluginDownloadManager
{
  private static IlivePluginDownloadManager jdField_a_of_type_CooperationIliveIlivePluginDownloadManager;
  private DataLocalTmpPmUpdater jdField_a_of_type_ComTencentMobileqqIntervideoDataLocalTmpPmUpdater = new DataLocalTmpPmUpdater("ilive");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = new DownloaderFactory(BaseApplicationImpl.getApplication().getRuntime());
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
    if (jdField_a_of_type_CooperationIliveIlivePluginDownloadManager == null) {}
    try
    {
      if (jdField_a_of_type_CooperationIliveIlivePluginDownloadManager == null) {
        jdField_a_of_type_CooperationIliveIlivePluginDownloadManager = new IlivePluginDownloadManager();
      }
      return jdField_a_of_type_CooperationIliveIlivePluginDownloadManager;
    }
    finally {}
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata" + File.separator + "vas" + File.separator + "qq_ilive";
  }
  
  private void a(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    while (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback == null) {
      return;
    }
    this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onFail(105, "plugin download fail , type = " + paramDownloadTask.jdField_a_of_type_JavaLangString + " , msg = " + paramDownloadTask.b + " , code = " + paramDownloadTask.f + " , errorCode=" + paramDownloadTask.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.c()));
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
    boolean bool = false;
    File localFile = new File(c());
    if (QLog.isColorLevel()) {
      QLog.i("IlivePluginDownloadManager", 2, "checkPluginFileIsNeedDownload  pluginFilePath = " + localFile.getAbsolutePath());
    }
    if (!localFile.exists()) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null) {
          break;
        }
      } while (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback == null);
      this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onFail(104, "preload check config bean = null");
      return false;
    } while (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.b()));
    return false;
  }
  
  private String e()
  {
    String str2 = c();
    String str1 = str2;
    if (this.jdField_a_of_type_Boolean) {
      str1 = str2 + ".tmp";
    }
    return str1;
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
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {
      return bool2;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.b())) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("IlivePluginDownloadManager", 2, "download success check file valid , isPluginValid = " + bool1);
      return bool1;
      if (!this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.b().equalsIgnoreCase(MD5Utils.encodeFileHexStr(e()))) {
        bool1 = false;
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {}
    File localFile;
    do
    {
      return;
      localFile = new File(e());
      if (QLog.isColorLevel()) {
        QLog.i("IlivePluginDownloadManager", 2, "deleteLocalIliveFile , pluginFile = " + e());
      }
    } while (!localFile.exists());
    localFile.delete();
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
      File localFile1 = new File(str);
      File localFile2 = new File(c());
      if (localFile2.exists()) {
        localFile2.delete();
      }
      if (localFile1.exists()) {
        localFile1.renameTo(localFile2);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("IlivePluginDownloadManager", 2, "download success copy file , downloadFile = " + str);
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
    if ((this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) || (this.b == null)) {}
    File localFile;
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.b.c()));
        if (!this.b.c().equals(this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("IlivePluginDownloadManager", 2, "stop deletePluginFile file equal ");
      return;
      localFile = new File(this.b.a());
      if (QLog.isColorLevel()) {
        QLog.i("IlivePluginDownloadManager", 2, "deletePluginFile , pluginFile = " + this.b.a());
      }
    } while (!localFile.exists());
    localFile.delete();
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {
      return;
    }
    QLog.i("IlivePluginDownloadManager", 2, "saveConfigBean , config = " + this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.toString());
    IliveDbManager.saveIliveConfigBean(2, this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean);
  }
  
  public DataLocalTmpPmUpdater a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoDataLocalTmpPmUpdater;
  }
  
  public DownloadTask a(File paramFile)
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean == null) {
      return null;
    }
    String str = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.c();
    if (QLog.isColorLevel()) {
      QLog.i("IlivePluginDownloadManager", 2, "createDownloadTask url = " + str + " saveFile = " + paramFile.getAbsolutePath());
    }
    paramFile = new DownloadTask(str, paramFile);
    paramFile.e = true;
    paramFile.p = true;
    paramFile.r = true;
    paramFile.q = true;
    paramFile.j = true;
    paramFile.n = false;
    paramFile.s = false;
    return paramFile;
  }
  
  public IliveConfigBean a()
  {
    return this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean;
  }
  
  public void a()
  {
    QLog.e("IlivePluginDownloadManager", 1, "cancelDownloadFile size = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
    a().a(true, null);
  }
  
  public void a(DownloadTask paramDownloadTask, DownloadListener paramDownloadListener)
  {
    if (paramDownloadTask == null) {
      return;
    }
    cooperation.ilive.time.TimeMonitorConfig.jdField_a_of_type_Boolean = true;
    a().a(paramDownloadTask, paramDownloadListener, null);
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
    return a() + File.separator + "ilive_plugin_v7.apk";
  }
  
  public void b()
  {
    this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean = IliveConfigBean.a();
    this.b = b();
    this.b.jdField_a_of_type_Boolean = this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null) {
      QLog.e("IlivePluginDownloadManager", 1, "readIliveConfig , current config = " + this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.toString());
    }
    if (this.b != null) {
      QLog.e("IlivePluginDownloadManager", 1, "readIliveConfig , last config = " + this.b.toString());
    }
  }
  
  public boolean b()
  {
    if (a()) {}
    for (;;)
    {
      return true;
      File localFile = new File(b());
      if (!localFile.exists())
      {
        QLog.e("IlivePluginDownloadManager", 1, "isPluginFileExist copy apkFile");
        Utils.a(BaseApplicationImpl.getContext(), "live_shopping_manager.apk", b());
      }
      boolean bool = localFile.exists();
      if (!d()) {}
      for (int i = 1; (!bool) || (i == 0); i = 0) {
        return false;
      }
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null) {
      return this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.a();
    }
    return "";
  }
  
  public void c()
  {
    if (!c()) {
      if (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback != null) {
        this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onFail(103, "download fail , config data = null");
      }
    }
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
      } while (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback == null);
      this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onSuccess();
      return;
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if (d())
      {
        DownloadTask localDownloadTask = a(new File(e()));
        this.jdField_a_of_type_JavaUtilLinkedList.add(localDownloadTask);
      }
      QLog.e("IlivePluginDownloadManager", 1, "downloadFile count = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        this.jdField_a_of_type_CooperationIliveIlivePluginDownloadManager$IliveDownloadListener = new IlivePluginDownloadManager.IliveDownloadListener(this, null);
        d();
        return;
      }
    } while (this.jdField_a_of_type_CooperationIliveIliveDownloadCallback == null);
    this.jdField_a_of_type_CooperationIliveIliveDownloadCallback.onSuccess();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean != null) {
      return this.jdField_a_of_type_CooperationIliveConfigIliveConfigBean.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IlivePluginDownloadManager
 * JD-Core Version:    0.7.0.1
 */