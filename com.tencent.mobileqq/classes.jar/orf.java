import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class orf
{
  private static volatile orf jdField_a_of_type_Orf;
  private final List<org> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static orf a()
  {
    if (jdField_a_of_type_Orf == null) {}
    try
    {
      if (jdField_a_of_type_Orf == null) {
        jdField_a_of_type_Orf = new orf();
      }
      return jdField_a_of_type_Orf;
    }
    finally {}
  }
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((org)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<orn> paramList, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((org)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((org)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void a(org paramorg)
  {
    if (paramorg == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramorg)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramorg);
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((org)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void b(org paramorg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramorg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */