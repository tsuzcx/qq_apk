import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.UITools;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class jkg
  implements Runnable
{
  WeakReference a;
  
  public jkg(AVNotifyCenter paramAVNotifyCenter)
  {
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {}
    do
    {
      do
      {
        return;
      } while (localAVNotifyCenter.a(String.valueOf(localAVNotifyCenter.b.jdField_a_of_type_Long)));
      if (localAVNotifyCenter.a != null) {
        localAVNotifyCenter.a.postDelayed(this, 1000L);
      }
    } while (!localAVNotifyCenter.i);
    String str = UITools.a(localAVNotifyCenter.c);
    if (localAVNotifyCenter.b.jdField_a_of_type_Int == 3)
    {
      localAVNotifyCenter.a(29, 0, Long.toString(localAVNotifyCenter.b.jdField_a_of_type_Long), str);
      return;
    }
    localAVNotifyCenter.a(29, 0, localAVNotifyCenter.b.b, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     jkg
 * JD-Core Version:    0.7.0.1
 */