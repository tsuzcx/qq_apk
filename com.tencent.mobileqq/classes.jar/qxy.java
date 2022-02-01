import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qxy
{
  private static qxy jdField_a_of_type_Qxy;
  private final List<qxz> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static qxy a()
  {
    if (jdField_a_of_type_Qxy == null) {}
    try
    {
      if (jdField_a_of_type_Qxy == null) {
        jdField_a_of_type_Qxy = new qxy();
      }
      return jdField_a_of_type_Qxy;
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
        ((qxz)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((qxz)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(qxz paramqxz)
  {
    if (paramqxz == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramqxz)) {
        this.jdField_a_of_type_JavaUtilList.add(paramqxz);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxy
 * JD-Core Version:    0.7.0.1
 */