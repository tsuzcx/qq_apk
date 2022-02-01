import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pdy
{
  private static volatile pdy jdField_a_of_type_Pdy;
  private final List<pdz> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static pdy a()
  {
    if (jdField_a_of_type_Pdy == null) {}
    try
    {
      if (jdField_a_of_type_Pdy == null) {
        jdField_a_of_type_Pdy = new pdy();
      }
      return jdField_a_of_type_Pdy;
    }
    finally {}
  }
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((pdz)localIterator.next()).a(paramInt, paramList);
      }
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<peg> paramList, int paramInt2)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((pdz)localIterator.next()).a(paramInt1, paramBoolean, paramList, paramInt2);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((pdz)localIterator.next()).a(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void a(pdz parampdz)
  {
    if (parampdz == null) {}
    while (this.jdField_a_of_type_JavaUtilList.contains(parampdz)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(parampdz);
      return;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = new ArrayList(this.jdField_a_of_type_JavaUtilList).iterator();
      if (localIterator.hasNext()) {
        ((pdz)localIterator.next()).b(paramInt, paramBoolean1, paramBoolean2, paramList);
      }
    }
  }
  
  public void b(pdz parampdz)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(parampdz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdy
 * JD-Core Version:    0.7.0.1
 */