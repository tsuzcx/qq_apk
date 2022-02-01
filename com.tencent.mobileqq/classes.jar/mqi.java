import java.util.ArrayList;
import java.util.Iterator;

public class mqi
{
  public int a;
  ArrayList<mqg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mqi()
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
      if (((mqg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mqg> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mqg a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mqg localmqg = (mqg)localIterator.next();
      if (localmqg.a() == paramInt) {
        return localmqg;
      }
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    b(a(paramInt));
  }
  
  public void a(mqg parammqg)
  {
    if (parammqg == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammqg);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mqg> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mqg)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(mqg parammqg)
  {
    if (parammqg == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(parammqg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqi
 * JD-Core Version:    0.7.0.1
 */