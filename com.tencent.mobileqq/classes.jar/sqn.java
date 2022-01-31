import android.support.annotation.NonNull;
import java.util.List;

public abstract class sqn<Config extends sqv>
{
  protected spy a;
  private Config a;
  
  protected List<spz> a()
  {
    if (this.jdField_a_of_type_Spy != null) {
      return this.jdField_a_of_type_Spy.a();
    }
    return null;
  }
  
  protected abstract List<spy> a(@NonNull List<spz> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Sqv;
  }
  
  public void a(spy paramspy)
  {
    if (paramspy.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      vxp.a(bool);
      this.jdField_a_of_type_Spy = paramspy;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Sqv = paramConfig;
  }
  
  public List<spy> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      ved.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqn
 * JD-Core Version:    0.7.0.1
 */