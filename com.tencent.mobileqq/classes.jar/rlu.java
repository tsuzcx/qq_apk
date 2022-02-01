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

public class rlu
{
  public static final String a;
  private int jdField_a_of_type_Int = 1;
  private volatile OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  private volatile rlx jdField_a_of_type_Rlx;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rlu.class.getSimpleName();
  }
  
  public rlu(Activity paramActivity, rlw paramrlw)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new rlv(this, paramActivity, new WeakReference(paramrlw));
      ThreadManager.executeOnSubThread(new OrientationDetector.2(this, paramActivity));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.executeOnSubThread(new OrientationDetector.3(this, paramBoolean1, paramBoolean2));
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
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "destory: ");
    }
    a(false, true);
    if (this.jdField_a_of_type_Rlx != null)
    {
      this.jdField_a_of_type_Rlx.b();
      this.jdField_a_of_type_Rlx = null;
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
        a(true, false);
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.w(jdField_a_of_type_JavaLangString, 2, "mRotateSettingSwitch is false : enable failure");
    return false;
    a(false, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlu
 * JD-Core Version:    0.7.0.1
 */