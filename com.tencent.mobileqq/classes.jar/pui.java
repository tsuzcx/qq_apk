import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pui
{
  private static volatile pui jdField_a_of_type_Pui;
  private final List<puj> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static pui a()
  {
    if (jdField_a_of_type_Pui == null) {}
    try
    {
      if (jdField_a_of_type_Pui == null) {
        jdField_a_of_type_Pui = new pui();
      }
      return jdField_a_of_type_Pui;
    }
    finally {}
  }
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((puj)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<puq> paramList, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((puj)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((puj)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void a(puj parampuj)
  {
    if (parampuj == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(parampuj)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(parampuj);
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((puj)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void b(puj parampuj)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(parampuj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pui
 * JD-Core Version:    0.7.0.1
 */