package cooperation.ilive.lite.event;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class IliveLiteEventCenter
{
  private static IliveLiteEventCenter jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private List<IliveLiteEventCenter.Observer> jdField_a_of_type_JavaUtilList = new Vector();
  
  public static IliveLiteEventCenter a()
  {
    if (jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter == null) {
          jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter = new IliveLiteEventCenter();
        }
      }
    }
    return jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter;
  }
  
  public void a(IliveLiteEventCenter.Observer paramObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramObserver)) {
        this.jdField_a_of_type_JavaUtilList.add(paramObserver);
      }
      return;
    }
  }
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      boolean bool3;
      for (;;)
      {
        bool2 = bool1;
        bool3 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        bool2 = bool1;
        IliveLiteEventCenter.Observer localObserver = (IliveLiteEventCenter.Observer)localIterator.next();
        if (localObserver != null)
        {
          bool2 = bool1;
          bool3 = localObserver.onCall(paramString, paramBundle);
          if (bool3) {
            bool1 = true;
          }
        }
      }
      return bool3;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("IliveLiteEventCenter", 1, "call error", paramString);
      bool3 = bool2;
    }
  }
  
  public void b(IliveLiteEventCenter.Observer paramObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramObserver);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.event.IliveLiteEventCenter
 * JD-Core Version:    0.7.0.1
 */