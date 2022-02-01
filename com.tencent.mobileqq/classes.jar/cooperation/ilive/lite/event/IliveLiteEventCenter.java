package cooperation.ilive.lite.event;

import android.os.Bundle;
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
    if (jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter == null) {
        jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter = new IliveLiteEventCenter();
      }
      return jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter;
    }
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      if (!((IliveLiteEventCenter.Observer)localIterator.next()).onCall(paramString, paramBundle)) {
        break label50;
      }
      bool = true;
    }
    label50:
    for (;;)
    {
      break;
      return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.event.IliveLiteEventCenter
 * JD-Core Version:    0.7.0.1
 */