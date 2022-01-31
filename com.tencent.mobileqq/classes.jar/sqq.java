import android.support.annotation.NonNull;
import java.util.List;

public abstract class sqq<Config extends sqy>
{
  protected sqb a;
  private Config a;
  
  protected List<sqc> a()
  {
    if (this.jdField_a_of_type_Sqb != null) {
      return this.jdField_a_of_type_Sqb.a();
    }
    return null;
  }
  
  protected abstract List<sqb> a(@NonNull List<sqc> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Sqy;
  }
  
  public void a(sqb paramsqb)
  {
    if (paramsqb.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      vxs.a(bool);
      this.jdField_a_of_type_Sqb = paramsqb;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Sqy = paramConfig;
  }
  
  public List<sqb> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      veg.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sqq
 * JD-Core Version:    0.7.0.1
 */