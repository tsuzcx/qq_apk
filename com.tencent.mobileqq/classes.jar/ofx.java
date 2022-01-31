import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ofx
{
  private static volatile ofx jdField_a_of_type_Ofx;
  private final List<ofy> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static ofx a()
  {
    if (jdField_a_of_type_Ofx == null) {}
    try
    {
      if (jdField_a_of_type_Ofx == null) {
        jdField_a_of_type_Ofx = new ofx();
      }
      return jdField_a_of_type_Ofx;
    }
    finally {}
  }
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((ofy)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<ogf> paramList, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((ofy)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((ofy)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void a(ofy paramofy)
  {
    if (paramofy == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(paramofy)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramofy);
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((ofy)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void b(ofy paramofy)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramofy);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofx
 * JD-Core Version:    0.7.0.1
 */