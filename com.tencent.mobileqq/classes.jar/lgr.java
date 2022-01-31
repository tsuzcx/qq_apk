import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class lgr
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<lgq> jdField_a_of_type_JavaUtilList = new LinkedList();
  lgt jdField_a_of_type_Lgt;
  private lgw jdField_a_of_type_Lgw;
  
  public lgr()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
  
  public lgr a(lgq paramlgq)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlgq);
    this.jdField_a_of_type_JavaUtilList.add(paramlgq);
    paramlgq.a(this.jdField_a_of_type_Lgw);
    return this;
  }
  
  protected abstract void a();
  
  public void a(lgt paramlgt)
  {
    this.jdField_a_of_type_Lgt = paramlgt;
  }
  
  protected abstract void b();
  
  protected void b(List<lgu> paramList, long paramLong)
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
        ((lgu)paramList.get(i)).a(this.jdField_a_of_type_JavaUtilList.size());
        i += 1;
      }
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((lgq)this.jdField_a_of_type_JavaUtilList.get(j)).a(paramList, paramLong);
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
    this.jdField_a_of_type_Lgw = new lgw();
    this.jdField_a_of_type_Lgw.a = this;
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lgq)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_Lgw);
      i += 1;
    }
  }
  
  public void e()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "destroy");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lgq)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgr
 * JD-Core Version:    0.7.0.1
 */