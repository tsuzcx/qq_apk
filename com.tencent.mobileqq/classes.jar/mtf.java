import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class mtf
  implements SensorEventListener
{
  long jdField_a_of_type_Long = 0L;
  long b = 0L;
  
  mtf(mte parammte) {}
  
  String a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return " x[" + paramFloat1 + "], y[" + paramFloat2 + "], z[" + paramFloat3 + "], acc[" + paramFloat4 + "], mIsMoving[" + mte.b(this.jdField_a_of_type_Mte) + "], mEnbaleProximiy[" + mte.c(this.jdField_a_of_type_Mte) + "], mIsAppOnForeground[" + mte.d(this.jdField_a_of_type_Mte) + "], mIsStarted[" + this.jdField_a_of_type_Mte.d + "], mPowerkeyStatu[" + this.jdField_a_of_type_Mte.jdField_a_of_type_Int + "], mlongDistense[" + mte.a(this.jdField_a_of_type_Mte) + "]";
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    long l = System.currentTimeMillis();
    boolean bool6 = mte.b(this.jdField_a_of_type_Mte);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    float f4 = f1 * f1 + f2 * f2 + f3 * f3;
    label94:
    boolean bool1;
    if ((f4 < 77.0F) || (f4 > 106.0F))
    {
      this.b = l;
      mte.b(this.jdField_a_of_type_Mte, true);
      if (this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController == null) {
        break label571;
      }
      paramSensorEvent = this.jdField_a_of_type_Mte.jdField_a_of_type_ComTencentAvVideoController.a();
      if (paramSensorEvent == null) {
        break label571;
      }
      if (paramSensorEvent.d != 3) {
        break label465;
      }
      bool1 = true;
    }
    for (;;)
    {
      label130:
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool2;
      boolean bool3;
      if ((bool1) && (mte.c(this.jdField_a_of_type_Mte)) && (mte.d(this.jdField_a_of_type_Mte)) && (!mte.a(this.jdField_a_of_type_Mte)) && (this.jdField_a_of_type_Mte.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Mte.jdField_a_of_type_Int != 3))
      {
        bool2 = bool5;
        bool3 = bool4;
        if (mte.b(this.jdField_a_of_type_Mte))
        {
          bool3 = true;
          bool2 = bool5;
        }
      }
      for (;;)
      {
        if ((QLog.isDevelopLevel()) && ((bool6 != mte.b(this.jdField_a_of_type_Mte)) || (l - this.jdField_a_of_type_Long > 1000L)))
        {
          QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 4, "onSensorChanged, bAudio[" + mte.e(this.jdField_a_of_type_Mte) + "->" + bool1 + "], IsMoving[" + bool6 + "->" + mte.b(this.jdField_a_of_type_Mte) + "], bOnScreen[" + bool2 + "], bOffScreen[" + bool3 + "]," + a(f1, f2, f3, f4));
          this.jdField_a_of_type_Long = l;
        }
        mte.c(this.jdField_a_of_type_Mte, bool1);
        if (!bool2) {
          break label507;
        }
        if (!this.jdField_a_of_type_Mte.d) {
          break;
        }
        QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock[false], when[AccelerationSensorEventListener]," + a(f1, f2, f3, f4));
        this.jdField_a_of_type_Mte.a(false, false);
        return;
        if (l - this.b <= 300L) {
          break label94;
        }
        mte.b(this.jdField_a_of_type_Mte, false);
        break label94;
        label465:
        if (!paramSensorEvent.S) {
          break label571;
        }
        bool1 = true;
        break label130;
        bool2 = bool5;
        bool3 = bool4;
        if (this.jdField_a_of_type_Mte.jdField_a_of_type_Int != 2)
        {
          bool2 = true;
          bool3 = bool4;
        }
      }
      label507:
      if ((!bool3) || (this.jdField_a_of_type_Mte.d)) {
        break;
      }
      QLog.d(this.jdField_a_of_type_Mte.jdField_a_of_type_JavaLangString, 1, "toggleProximityWakeLock[true], when[AccelerationSensorEventListener]" + a(f1, f2, f3, f4));
      this.jdField_a_of_type_Mte.a(true, false);
      return;
      label571:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mtf
 * JD-Core Version:    0.7.0.1
 */