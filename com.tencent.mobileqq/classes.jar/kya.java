import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import java.lang.ref.WeakReference;

public class kya
  implements CameraInterFace
{
  private static volatile kya jdField_a_of_type_Kya;
  private volatile int jdField_a_of_type_Int = -1;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private WeakReference<SensorEventHandler.CameraChangedCallBack> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public static kya a()
  {
    if (jdField_a_of_type_Kya == null) {}
    try
    {
      if (jdField_a_of_type_Kya == null) {
        jdField_a_of_type_Kya = new kya();
      }
      return jdField_a_of_type_Kya;
    }
    finally {}
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      this.jdField_a_of_type_AndroidHardwareSensorManager = null;
    }
    while (this.jdField_a_of_type_AndroidHardwareSensorManager != null) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramActivity.getSystemService("sensor"));
  }
  
  public void a(SensorEventListener paramSensorEventListener)
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) || (paramSensorEventListener == null)) {}
    Sensor localSensor;
    do
    {
      return;
      localSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(11);
    } while (localSensor == null);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(paramSensorEventListener, localSensor, 1);
  }
  
  public void a(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    if (paramCameraChangedCallBack == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCameraChangedCallBack);
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    SensorEventHandler.CameraChangedCallBack localCameraChangedCallBack;
    do
    {
      return;
      localCameraChangedCallBack = (SensorEventHandler.CameraChangedCallBack)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localCameraChangedCallBack == null);
    localCameraChangedCallBack.onCameraChanged(paramBoolean);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidHardwareSensorManager == null) {}
    while (this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(11) == null) {
      return false;
    }
    return true;
  }
  
  public void b(SensorEventListener paramSensorEventListener)
  {
    if ((this.jdField_a_of_type_AndroidHardwareSensorManager == null) || (paramSensorEventListener == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(paramSensorEventListener);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int getCameraID()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kya
 * JD-Core Version:    0.7.0.1
 */