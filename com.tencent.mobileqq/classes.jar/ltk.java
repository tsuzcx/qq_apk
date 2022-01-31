import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class ltk
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<ltj> jdField_a_of_type_JavaUtilList = new LinkedList();
  ltm jdField_a_of_type_Ltm;
  private ltp jdField_a_of_type_Ltp;
  
  public ltk()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
  
  public ltk a(ltj paramltj)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramltj);
    this.jdField_a_of_type_JavaUtilList.add(paramltj);
    paramltj.a(this.jdField_a_of_type_Ltp);
    return this;
  }
  
  protected abstract void a();
  
  public void a(ltm paramltm)
  {
    this.jdField_a_of_type_Ltm = paramltm;
  }
  
  protected abstract void b();
  
  protected void b(List<ltn> paramList, long paramLong)
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {}
    for (;;)
    {
      return;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        ((ltn)paramList.get(i)).a(this.jdField_a_of_type_JavaUtilList.size());
        i += 1;
      }
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((ltj)this.jdField_a_of_type_JavaUtilList.get(j)).a(paramList, paramLong);
        j += 1;
      }
    }
  }
  
  public void c()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "isolated: ");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void d()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "init");
    this.jdField_a_of_type_Ltp = new ltp();
    this.jdField_a_of_type_Ltp.a = this;
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ltj)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_Ltp);
      i += 1;
    }
  }
  
  public void e()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "destroy");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((ltj)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ltk
 * JD-Core Version:    0.7.0.1
 */