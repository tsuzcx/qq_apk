import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public class nbf
{
  HashMap<Integer, WeakReference<nbg>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  ymk jdField_a_of_type_Ymk;
  
  public nbf(ymk paramymk)
  {
    this.jdField_a_of_type_Ymk = paramymk;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, nbg paramnbg)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(paramnbg));
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("WebPushClient", 2, "data is null");
      }
    }
    WeakReference localWeakReference;
    do
    {
      int i;
      do
      {
        return;
        i = paramBundle.getInt("msgType", -1);
        if (i != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("WebPushClient", 2, "type is 0");
      return;
      localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    } while ((localWeakReference == null) || (localWeakReference.get() == null));
    ((nbg)localWeakReference.get()).a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nbf
 * JD-Core Version:    0.7.0.1
 */