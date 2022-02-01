import java.util.ArrayList;
import java.util.Iterator;

public class mqo
{
  public int a;
  ArrayList<mqm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mqo()
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
      if (((mqm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mqm> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mqm a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mqm localmqm = (mqm)localIterator.next();
      if (localmqm.a() == paramInt) {
        return localmqm;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(mqm parammqm)
  {
    if (parammqm == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammqm);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mqm> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mqm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(mqm parammqm)
  {
    if (parammqm == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(parammqm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqo
 * JD-Core Version:    0.7.0.1
 */