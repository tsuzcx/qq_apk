import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.2;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class qzb
{
  public static final String a;
  private int jdField_a_of_type_Int = 1;
  private volatile OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  private volatile qze jdField_a_of_type_Qze;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qzb.class.getSimpleName();
  }
  
  public qzb(Activity paramActivity, qzd paramqzd)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new qzc(this, paramActivity, new WeakReference(paramqzd));
      ThreadManager.executeOnSubThread(new OrientationDetector.2(this, paramActivity));
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new OrientationDetector.3(this, paramBoolean));
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Long.valueOf(l));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)localIterator.next();
      } while ((((Integer)localEntry.getKey()).intValue() == paramInt) || (l - ((Long)localEntry.getValue()).longValue() >= 200L));
      return false;
      if ((paramInt >= 250) && (paramInt <= 290)) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
    }
    return true;
  }
  
  public Context a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public void a()
  {
    a(false);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = null;
      if (this.jdField_a_of_type_Qze != null)
      {
        this.jdField_a_of_type_Qze.b();
        this.jdField_a_of_type_Qze = null;
      }
      return;
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener == null) {}
    do
    {
      return false;
      if (!paramBoolean) {
        break;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a(true);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.w(jdField_a_of_type_JavaLangString, 2, "mRotateSettingSwitch is false : enable failure");
    return false;
    a(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzb
 * JD-Core Version:    0.7.0.1
 */