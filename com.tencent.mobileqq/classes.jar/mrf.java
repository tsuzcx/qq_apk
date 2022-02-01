import java.util.ArrayList;
import java.util.Iterator;

public class mrf
{
  public int a;
  ArrayList<mrd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mrf()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((mrd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mrd> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mrd a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mrd localmrd = (mrd)localIterator.next();
      if (localmrd.a() == paramInt) {
        return localmrd;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(mrd parammrd)
  {
    if (parammrd == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammrd);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mrd> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mrd)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(mrd parammrd)
  {
    if (parammrd == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(parammrd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrf
 * JD-Core Version:    0.7.0.1
 */