import java.util.ArrayList;
import java.util.Iterator;

public class mfn
{
  public int a;
  ArrayList<mfl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public mfn()
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
      if (((mfl)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public ArrayList<mfl> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public mfl a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      mfl localmfl = (mfl)localIterator.next();
      if (localmfl.a() == paramInt) {
        return localmfl;
      }
    }
    return null;
  }
  
  public void a(mfl parammfl)
  {
    if (parammfl == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parammfl);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ArrayList<mfl> b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((mfl)this.jdField_a_of_type_JavaUtilArrayList.get(i)).c()) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mfn
 * JD-Core Version:    0.7.0.1
 */