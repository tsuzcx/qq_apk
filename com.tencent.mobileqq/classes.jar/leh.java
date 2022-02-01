import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class leh
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private Object jdField_a_of_type_JavaLangObject;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private lei jdField_a_of_type_Lei;
  
  public leh(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_JavaUtilMap;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    DexClassLoader localDexClassLoader;
    do
    {
      return;
      localDexClassLoader = mrz.a();
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      if (this.jdField_a_of_type_Lei == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change receiver");
        }
        this.jdField_a_of_type_Lei = new lei(this);
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.qav.camera.availability");
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_Lei, (IntentFilter)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("GCameraAvailabilityMonitor", 2, "register camera availability change callback");
      }
    } while ((Build.VERSION.RELEASE.equalsIgnoreCase("7.1.2")) || (Build.MODEL.equalsIgnoreCase("vivo x9")));
    this.jdField_a_of_type_JavaLangObject = mrz.a(localDexClassLoader, "com.tencent.av.camera2.CameraManagerWrapper");
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    Context localContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName();
    mrz.a(localDexClassLoader, localObject, "registerAvailabilityCb", new Class[] { Context.class, String.class, Handler.class }, new Object[] { localContext, str, null });
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Lei != null) {
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change receiver");
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_Lei);
        this.jdField_a_of_type_Lei = null;
        if (QLog.isColorLevel()) {
          QLog.d("GCameraAvailabilityMonitor", 2, "UnRegister camera availability change callback");
        }
        if (this.jdField_a_of_type_JavaLangObject == null) {
          continue;
        }
        mrz.a(mrz.a(), this.jdField_a_of_type_JavaLangObject, "unRegisterAvailabilityCb", null, null);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("GCameraAvailabilityMonitor", 2, "regist e = " + localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     leh
 * JD-Core Version:    0.7.0.1
 */