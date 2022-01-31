import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ppa
{
  private static ppa jdField_a_of_type_Ppa;
  private final List<ppb> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static ppa a()
  {
    if (jdField_a_of_type_Ppa == null) {}
    try
    {
      if (jdField_a_of_type_Ppa == null) {
        jdField_a_of_type_Ppa = new ppa();
      }
      return jdField_a_of_type_Ppa;
    }
    finally {}
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ppb)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ppb)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(ppb paramppb)
  {
    if (paramppb == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramppb)) {
        this.jdField_a_of_type_JavaUtilList.add(paramppb);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppa
 * JD-Core Version:    0.7.0.1
 */