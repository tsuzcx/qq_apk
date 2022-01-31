package cooperation.qzone.plugin;

import android.os.Binder;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class QZoneRemotePluginHandler
  extends QZoneRemotePluginManager.Stub
{
  private static QZoneRemotePluginHandler jdField_a_of_type_CooperationQzonePluginQZoneRemotePluginHandler;
  private static String jdField_a_of_type_JavaLangString = "QZoneRemotePluginHandler";
  private IQZonePluginManager jdField_a_of_type_CooperationQzonePluginIQZonePluginManager;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public static QZoneRemotePluginHandler a()
  {
    if (jdField_a_of_type_CooperationQzonePluginQZoneRemotePluginHandler == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzonePluginQZoneRemotePluginHandler == null) {
        jdField_a_of_type_CooperationQzonePluginQZoneRemotePluginHandler = new QZoneRemotePluginHandler();
      }
      return jdField_a_of_type_CooperationQzonePluginQZoneRemotePluginHandler;
    }
    finally {}
  }
  
  private void b()
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      localObject = localQQAppInterface;
      if (localQQAppInterface != null)
      {
        this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager = ((IQZonePluginManager)localQQAppInterface.getManager(174));
        localObject = localQQAppInterface;
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "appInterface:" + localObject + ",pluginManger=" + this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager);
  }
  
  public Binder a()
  {
    return this;
  }
  
  @Nullable
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public PluginRecord a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "queryPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return null;
    }
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "triggerQQDownloadPtuFilter");
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(OnQZoneLiveSoDownloadListener paramOnQZoneLiveSoDownloadListener, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPituSo");
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramOnQZoneLiveSoDownloadListener, paramInt);
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isReady");
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a();
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "isPluginInstalled:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager != null) {
      return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString);
    }
    return false;
  }
  
  public boolean a(String paramString, OnQZonePluginInstallListner paramOnQZonePluginInstallListner, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "installPlugin:" + paramString);
    }
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.a(paramString, paramOnQZonePluginInstallListner, paramInt);
  }
  
  public boolean b(String paramString)
  {
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.b(paramString);
  }
  
  public boolean c(String paramString)
  {
    b();
    if (this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager == null) {
      return false;
    }
    return this.jdField_a_of_type_CooperationQzonePluginIQZonePluginManager.c(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.plugin.QZoneRemotePluginHandler
 * JD-Core Version:    0.7.0.1
 */