import java.util.ArrayList;
import java.util.Iterator;

public class swb
  implements nbs
{
  public int a;
  public String a;
  private ArrayList<ndj> a;
  private int b;
  public String b;
  private int c;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public swb(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ndj)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(ndj paramndj)
  {
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramndj)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramndj);
    }
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(ndj paramndj)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramndj);
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void loaded(String paramString, int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ndj)localIterator.next()).loaded(paramString, paramInt);
    }
  }
  
  public void progress(int paramInt)
  {
    this.c = paramInt;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ndj)localIterator.next()).progress(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     swb
 * JD-Core Version:    0.7.0.1
 */