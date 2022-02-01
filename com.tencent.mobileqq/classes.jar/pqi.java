import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class pqi
{
  private aodk jdField_a_of_type_Aodk = new pqj(this);
  private pne jdField_a_of_type_Pne;
  
  public pqi(pne parampne)
  {
    this.jdField_a_of_type_Pne = parampne;
  }
  
  public void a()
  {
    int i = 2;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    aodk localaodk;
    Sensor localSensor;
    if ((qjw.a() == 2) && (qjw.b(this.jdField_a_of_type_Pne.a().a(), (String)localObject) > 0))
    {
      localObject = (SensorManager)this.jdField_a_of_type_Pne.a().a().getSystemService("sensor");
      localaodk = this.jdField_a_of_type_Aodk;
      localSensor = ((SensorManager)localObject).getDefaultSensor(1);
      if (!bdme.a().a()) {
        break label86;
      }
    }
    for (;;)
    {
      ((SensorManager)localObject).registerListener(localaodk, localSensor, i);
      return;
      label86:
      i = 0;
    }
  }
  
  public void b()
  {
    ((SensorManager)this.jdField_a_of_type_Pne.a().a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Aodk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqi
 * JD-Core Version:    0.7.0.1
 */