import com.tencent.av.app.DeviceCapabilityExamination;
import java.lang.ref.WeakReference;

public class jei
  implements Runnable
{
  WeakReference a;
  
  public jei(DeviceCapabilityExamination paramDeviceCapabilityExamination)
  {
    this.a = new WeakReference(paramDeviceCapabilityExamination);
  }
  
  public void run()
  {
    DeviceCapabilityExamination localDeviceCapabilityExamination = (DeviceCapabilityExamination)this.a.get();
    if (localDeviceCapabilityExamination != null) {
      DeviceCapabilityExamination.a(localDeviceCapabilityExamination);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jei
 * JD-Core Version:    0.7.0.1
 */