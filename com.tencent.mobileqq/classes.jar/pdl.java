import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pdl
{
  private static pdl jdField_a_of_type_Pdl;
  private final List<pdm> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static pdl a()
  {
    if (jdField_a_of_type_Pdl == null) {}
    try
    {
      if (jdField_a_of_type_Pdl == null) {
        jdField_a_of_type_Pdl = new pdl();
      }
      return jdField_a_of_type_Pdl;
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
        ((pdm)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((pdm)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(pdm parampdm)
  {
    if (parampdm == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parampdm)) {
        this.jdField_a_of_type_JavaUtilList.add(parampdm);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdl
 * JD-Core Version:    0.7.0.1
 */