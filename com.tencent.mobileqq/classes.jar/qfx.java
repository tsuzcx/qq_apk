import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qfx
{
  private static qfx jdField_a_of_type_Qfx;
  private final List<qfy> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static qfx a()
  {
    if (jdField_a_of_type_Qfx == null) {}
    try
    {
      if (jdField_a_of_type_Qfx == null) {
        jdField_a_of_type_Qfx = new qfx();
      }
      return jdField_a_of_type_Qfx;
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
        ((qfy)localIterator.next()).a(paramInt, paramList, paramLong);
      }
    }
  }
  
  public void a(int paramInt, List<Long> paramList, boolean paramBoolean1, boolean paramBoolean2, ToServiceMsg paramToServiceMsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((qfy)localIterator.next()).a(paramInt, paramList, paramBoolean1, paramBoolean2, paramToServiceMsg);
      }
    }
  }
  
  public void a(qfy paramqfy)
  {
    if (paramqfy == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramqfy)) {
        this.jdField_a_of_type_JavaUtilList.add(paramqfy);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfx
 * JD-Core Version:    0.7.0.1
 */