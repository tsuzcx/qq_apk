import java.util.ArrayList;
import java.util.Iterator;

public class mqj
{
  public int a;
  ArrayList<mqh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mqj()
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
      if (((mqh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mqh> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mqh a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mqh localmqh = (mqh)localIterator.next();
      if (localmqh.a() == paramInt) {
        return localmqh;
      }
    }
    return null;
  }
  
  public void a(mqh parammqh)
  {
    if (parammqh == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammqh);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mqh> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mqh)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mqj
 * JD-Core Version:    0.7.0.1
 */