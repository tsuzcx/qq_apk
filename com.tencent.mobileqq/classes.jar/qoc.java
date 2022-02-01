import android.support.annotation.NonNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class qoc
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<smv> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public qob a()
  {
    return new qob(this, null);
  }
  
  public qoc a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public qoc a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public qoc a(@NonNull List<smv> paramList)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() == 1)) {
      ((smv)this.jdField_b_of_type_JavaUtilList.get(0)).a(true);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public qoc b(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public qoc b(@NonNull List<URL> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoc
 * JD-Core Version:    0.7.0.1
 */