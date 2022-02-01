import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class lqm
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<lql> jdField_a_of_type_JavaUtilList = new LinkedList();
  lqo jdField_a_of_type_Lqo;
  private lqr jdField_a_of_type_Lqr;
  
  public lqm()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
  
  public lqm a(lql paramlql)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlql);
    this.jdField_a_of_type_JavaUtilList.add(paramlql);
    paramlql.a(this.jdField_a_of_type_Lqr);
    return this;
  }
  
  protected abstract void a();
  
  public void a(lqo paramlqo)
  {
    this.jdField_a_of_type_Lqo = paramlqo;
  }
  
  protected abstract void b();
  
  protected void b(List<lqp> paramList, long paramLong)
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
        ((lqp)paramList.get(i)).a(this.jdField_a_of_type_JavaUtilList.size());
        i += 1;
      }
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((lql)this.jdField_a_of_type_JavaUtilList.get(j)).a(paramList, paramLong);
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
    this.jdField_a_of_type_Lqr = new lqr();
    this.jdField_a_of_type_Lqr.a = this;
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lql)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_Lqr);
      i += 1;
    }
  }
  
  public void e()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "destroy");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lql)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqm
 * JD-Core Version:    0.7.0.1
 */