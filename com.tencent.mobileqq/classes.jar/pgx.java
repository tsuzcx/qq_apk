import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;

public class pgx
{
  private anav jdField_a_of_type_Anav = new pgy(this);
  private ped jdField_a_of_type_Ped;
  
  public pgx(ped paramped)
  {
    this.jdField_a_of_type_Ped = paramped;
  }
  
  public void a()
  {
    int i = 2;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    anav localanav;
    Sensor localSensor;
    if ((pxs.a() == 2) && (pxs.b(this.jdField_a_of_type_Ped.a().a(), (String)localObject) > 0))
    {
      localObject = (SensorManager)this.jdField_a_of_type_Ped.a().a().getSystemService("sensor");
      localanav = this.jdField_a_of_type_Anav;
      localSensor = ((SensorManager)localObject).getDefaultSensor(1);
      if (!bcfj.a().a()) {
        break label86;
      }
    }
    for (;;)
    {
      ((SensorManager)localObject).registerListener(localanav, localSensor, i);
      return;
      label86:
      i = 0;
    }
  }
  
  public void b()
  {
    ((SensorManager)this.jdField_a_of_type_Ped.a().a().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_Anav);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgx
 * JD-Core Version:    0.7.0.1
 */