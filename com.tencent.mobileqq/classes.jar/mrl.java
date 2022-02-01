import java.util.ArrayList;
import java.util.Iterator;

public class mrl
{
  public int a;
  ArrayList<mrj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mrl()
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
      if (((mrj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mrj> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mrj a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mrj localmrj = (mrj)localIterator.next();
      if (localmrj.a() == paramInt) {
        return localmrj;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(mrj parammrj)
  {
    if (parammrj == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammrj);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mrj> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mrj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(mrj parammrj)
  {
    if (parammrj == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(parammrj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mrl
 * JD-Core Version:    0.7.0.1
 */