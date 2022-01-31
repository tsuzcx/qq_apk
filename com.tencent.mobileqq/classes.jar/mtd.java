import java.util.ArrayList;
import java.util.Iterator;

public class mtd
{
  public int a;
  ArrayList<mtb> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mtd()
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
      if (((mtb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mtb> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mtb a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mtb localmtb = (mtb)localIterator.next();
      if (localmtb.a() == paramInt) {
        return localmtb;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(mtb parammtb)
  {
    if (parammtb == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammtb);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mtb> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mtb)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(mtb parammtb)
  {
    if (parammtb == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(parammtb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mtd
 * JD-Core Version:    0.7.0.1
 */