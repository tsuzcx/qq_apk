import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.game.SensorAPIJavaScript;

public class neu
  implements SensorEventListener
{
  protected byte a;
  protected String a;
  
  public neu(SensorAPIJavaScript paramSensorAPIJavaScript, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    default: 
      return;
    case 0: 
      f1 = paramSensorEvent.values[0];
      float f2 = paramSensorEvent.values[1];
      float f3 = paramSensorEvent.values[2];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1), String.valueOf(f2), String.valueOf(f3) });
      return;
    case 1: 
      f1 = paramSensorEvent.values[0];
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
      return;
    }
    float f1 = paramSensorEvent.values[0];
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(f1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     neu
 * JD-Core Version:    0.7.0.1
 */