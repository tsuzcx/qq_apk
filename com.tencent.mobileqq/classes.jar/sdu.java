import android.support.annotation.NonNull;
import java.util.List;

public abstract class sdu<Config extends sec>
{
  protected sdf a;
  private Config a;
  
  protected List<sdg> a()
  {
    if (this.jdField_a_of_type_Sdf != null) {
      return this.jdField_a_of_type_Sdf.a();
    }
    return null;
  }
  
  protected abstract List<sdf> a(@NonNull List<sdg> paramList);
  
  public Config a()
  {
    return this.jdField_a_of_type_Sec;
  }
  
  public void a(sdf paramsdf)
  {
    if (paramsdf.b() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      vkw.a(bool);
      this.jdField_a_of_type_Sdf = paramsdf;
      return;
    }
  }
  
  public void a(Config paramConfig)
  {
    this.jdField_a_of_type_Sec = paramConfig;
  }
  
  public List<sdf> b()
  {
    List localList = a();
    if ((localList == null) || (localList.size() == 0))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "data is null");
      return null;
    }
    if ((a() != null) && (localList.size() < a().b))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.AbstractSplitStrategy", "too little data");
      return null;
    }
    return a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sdu
 * JD-Core Version:    0.7.0.1
 */