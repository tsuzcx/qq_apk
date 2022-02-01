import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class mtg
  implements SensorEventListener
{
  float jdField_a_of_type_Float = 3.1F;
  long jdField_a_of_type_Long = 0L;
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float = 0.0F;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  
  mtg(mte parammte) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 8) {}
    label81:
    boolean bool1;
    label119:
    Object localObject;
    label199:
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          return;
          f1 = this.jdField_b_of_type_Float;
          f2 = paramSensorEvent.values[0];
          this.jdField_b_of_type_Float = f2;
          if (this.jdField_a_of_type_Float > this.jdField_a_of_type_Mte.b.getMaximumRange()) {
            this.jdField_a_of_type_Float = this.jdField_a_of_type_Mte.b.getMaximumRange();
          }
          if ((f2 < 0.0D) || (f2 >= this.jdField_a_of_type_Float)) {
            break;
          }
          i = 1;
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = false;
            if (i != 0)
            {
              this.jdField_a_of_type_Mte.jdField_a_of_type_Int = 3;
              paramSensorEvent = this.jdField_a_of_type_Mte;
              if (i != 0) {
                break label615;
              }
              bool1 = true;
              mte.a(paramSensorEvent, bool1);
              this.jdField_a_of_type_Mte.jdField_a_of_type_Mti.d();
            }
          }
        } while ((this.jdField_a_of_type_Mte.b == null) || (this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController == null));
        paramSensorEvent = this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController.a();
      } while (paramSensorEvent == null);
      long l = System.currentTimeMillis();
      boolean bool2 = mte.a(this.jdField_a_of_type_Mte);
      localObject = this.jdField_a_of_type_Mte;
      if (i != 0) {
        break label621;
      }
      bool1 = true;
      mte.d((mte)localObject, bool1);
      if (mte.f(this.jdField_a_of_type_Mte) != mte.a(this.jdField_a_of_type_Mte))
      {
        if (3 == this.jdField_a_of_type_Mte.jdField_a_of_type_Int) {
          this.jdField_a_of_type_Mte.jdField_a_of_type_Mti.e();
        }
        this.jdField_a_of_type_Mte.jdField_a_of_type_Int = 0;
      }
      if ((l - this.jdField_a_of_type_Long > 1000L) || (bool2 != mte.a(this.jdField_a_of_type_Mte)) || (this.jdField_b_of_type_Boolean != paramSensorEvent.P) || (this.c != this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean) || (this.d != mte.b(this.jdField_a_of_type_Mte)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 4, "onSensorChanged distance[" + f1 + "->" + f2 + "], mlongDistense[" + mte.a(this.jdField_a_of_type_Mte) + "], lastlongDistense[" + bool2 + "], mIsMoving[" + this.d + "->" + mte.b(this.jdField_a_of_type_Mte) + "], mSensorSet[" + this.c + "->" + this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean + "], isSpeakerOn[" + this.jdField_b_of_type_Boolean + "->" + paramSensorEvent.P + "]");
        }
        this.jdField_a_of_type_Long = l;
      }
      this.jdField_b_of_type_Boolean = paramSensorEvent.P;
      this.c = this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean;
      this.d = mte.b(this.jdField_a_of_type_Mte);
      if ((i == 0) || (!mte.b(this.jdField_a_of_type_Mte))) {
        break label732;
      }
      localObject = paramSensorEvent.a;
    } while ((!paramSensorEvent.P) || (localObject == null));
    int i = 0;
    label543:
    if (i < localObject.length) {
      if ((!localObject[i].equals("DEVICE_WIREDHEADSET")) && (!localObject[i].equals("DEVICE_BLUETOOTHHEADSET"))) {}
    }
    for (i = 0;; i = 1)
    {
      if (!lyu.f(BaseApplicationImpl.getApplication()))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 2, "is App on background , Not execute sensor pressHandFreeBtn !!!");
        return;
        i = 0;
        break label81;
        label615:
        bool1 = false;
        break label119;
        label621:
        bool1 = false;
        break label199;
        i += 1;
        break label543;
      }
      if ((i == 0) || (!this.jdField_a_of_type_Mte.c)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 2, "1.setSensors pressHandFreeBtn, current mSensorSet = " + this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Mte.jdField_a_of_type_Mts != null) {
        this.jdField_a_of_type_Mte.jdField_a_of_type_Mts.d();
      }
      this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean = true;
      mqw.j(this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController);
      return;
      label732:
      if ((!this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean) || (i != 0)) {
        break;
      }
      if (this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController != null) {}
      for (paramSensorEvent = paramSensorEvent.a;; paramSensorEvent = null)
      {
        if (paramSensorEvent != null)
        {
          i = 0;
          if (i >= paramSensorEvent.length) {
            break label908;
          }
          if ((!paramSensorEvent[i].equals("DEVICE_WIREDHEADSET")) && (!paramSensorEvent[i].equals("DEVICE_BLUETOOTHHEADSET"))) {
            break label899;
          }
        }
        label899:
        label908:
        for (i = 0;; i = 1)
        {
          if ((i != 0) && (this.jdField_a_of_type_Mte.c))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 2, "2.setSensors pressHandFreeBtn, current mSensorSet = " + this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean);
            }
            if (this.jdField_a_of_type_Mte.jdField_a_of_type_Mts != null) {
              this.jdField_a_of_type_Mte.jdField_a_of_type_Mts.d();
            }
            mqw.j(this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController);
          }
          this.jdField_a_of_type_Mte.jdField_a_of_type_Boolean = false;
          return;
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtg
 * JD-Core Version:    0.7.0.1
 */