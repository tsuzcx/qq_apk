import android.util.Log;
import java.util.LinkedList;
import java.util.List;

public abstract class lrd
{
  private String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "-" + Integer.toHexString(hashCode());
  private List<lrc> jdField_a_of_type_JavaUtilList = new LinkedList();
  lrf jdField_a_of_type_Lrf;
  private lri jdField_a_of_type_Lri;
  
  public lrd()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "ImageSource: ");
  }
  
  public lrd a(lrc paramlrc)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "addTarget: " + paramlrc);
    this.jdField_a_of_type_JavaUtilList.add(paramlrc);
    paramlrc.a(this.jdField_a_of_type_Lri);
    return this;
  }
  
  protected abstract void a();
  
  public void a(lrf paramlrf)
  {
    this.jdField_a_of_type_Lrf = paramlrf;
  }
  
  protected abstract void b();
  
  protected void b(List<lrg> paramList, long paramLong)
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
        ((lrg)paramList.get(i)).a(this.jdField_a_of_type_JavaUtilList.size());
        i += 1;
      }
      while (j < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((lrc)this.jdField_a_of_type_JavaUtilList.get(j)).a(paramList, paramLong);
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
    this.jdField_a_of_type_Lri = new lri();
    this.jdField_a_of_type_Lri.a = this;
    a();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lrc)this.jdField_a_of_type_JavaUtilList.get(i)).a(this.jdField_a_of_type_Lri);
      i += 1;
    }
  }
  
  public void e()
  {
    Log.d(this.jdField_a_of_type_JavaLangString, "destroy");
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((lrc)this.jdField_a_of_type_JavaUtilList.get(i)).c();
      i += 1;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrd
 * JD-Core Version:    0.7.0.1
 */