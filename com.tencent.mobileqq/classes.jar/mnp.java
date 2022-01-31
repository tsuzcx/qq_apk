import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;

public class mnp
{
  HashMap<Integer, WeakReference<mnq>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  wis jdField_a_of_type_Wis;
  
  public mnp(wis paramwis)
  {
    this.jdField_a_of_type_Wis = paramwis;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, mnq parammnq)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(parammnq));
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
    ((mnq)localWeakReference.get()).a(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnp
 * JD-Core Version:    0.7.0.1
 */