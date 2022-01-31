import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.SensorHelper;
import com.tencent.av.utils.SensorReport;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

public class kiz
  implements SensorEventListener
{
  float jdField_a_of_type_Float = 3.1F;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = true;
  float b = 0.0F;
  
  public kiz(SensorHelper paramSensorHelper) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int k = 1;
    int m = 0;
    if (paramSensorEvent.sensor.getType() != 8) {}
    label87:
    label728:
    for (;;)
    {
      return;
      float f1 = this.b;
      float f2 = paramSensorEvent.values[0];
      this.b = f2;
      if (this.jdField_a_of_type_Float > this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange()) {
        this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b.getMaximumRange();
      }
      int i;
      boolean bool1;
      if ((f2 >= 0.0D) && (f2 < this.jdField_a_of_type_Float))
      {
        i = 1;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          if (i != 0)
          {
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int = 3;
            paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
            if (i != 0) {
              break label565;
            }
            bool1 = true;
            label125:
            SensorHelper.a(paramSensorEvent, bool1);
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.d();
          }
        }
        if ((this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b == null) || (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController == null)) {
          continue;
        }
        paramSensorEvent = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController.a();
        if (paramSensorEvent == null) {
          continue;
        }
        long l = System.currentTimeMillis();
        boolean bool2 = SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper);
        Object localObject = this.jdField_a_of_type_ComTencentAvUtilsSensorHelper;
        if (i != 0) {
          break label571;
        }
        bool1 = true;
        SensorHelper.d((SensorHelper)localObject, bool1);
        if (SensorHelper.f(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))
        {
          if (3 == this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int) {
            this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsSensorReport.e();
          }
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Int = 0;
        }
        if ((l - this.jdField_a_of_type_Long > 1000L) || (bool2 != SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper)))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 4, "onSensorChanged distance[" + f1 + "->" + f2 + "], mlongDistense[" + SensorHelper.a(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) + "], lastlongDistense[" + bool2 + "], mIsMoving[" + SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper) + "], mSensorSet[" + this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean + "], isSpeakerOn[" + paramSensorEvent.N + "]");
          }
          this.jdField_a_of_type_Long = l;
        }
        if ((i == 0) || (!SensorHelper.b(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper))) {
          break label586;
        }
        localObject = paramSensorEvent.a;
        if ((!paramSensorEvent.N) || (localObject == null)) {
          continue;
        }
        i = 0;
        if (i >= localObject.length) {
          break label724;
        }
        j = m;
        if (!localObject[i].equals("DEVICE_WIREDHEADSET")) {
          if (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET")) {
            break label577;
          }
        }
      }
      for (int j = m;; j = 1)
      {
        if ((j == 0) || (!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c)) {
          break label728;
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_JavaLangString, 2, "setSensors pressHandFreeBtn");
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
          this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
        }
        this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean = true;
        DataReport.k(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController);
        return;
        i = 0;
        break label87;
        bool1 = false;
        break label125;
        bool1 = false;
        break label205;
        i += 1;
        break label444;
        if (!this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController != null) {}
        for (paramSensorEvent = paramSensorEvent.a;; paramSensorEvent = null)
        {
          if (paramSensorEvent != null) {
            i = 0;
          }
          for (;;)
          {
            j = k;
            if (i < paramSensorEvent.length)
            {
              if ((paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) || (paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
                j = 0;
              }
            }
            else
            {
              if ((j != 0) && (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c))
              {
                if (this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper != null) {
                  this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvUtilsTraeHelper.e();
                }
                DataReport.k(this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_ComTencentAvVideoController);
              }
              this.jdField_a_of_type_ComTencentAvUtilsSensorHelper.jdField_a_of_type_Boolean = false;
              return;
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kiz
 * JD-Core Version:    0.7.0.1
 */