import android.support.annotation.NonNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class pvm
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<rib> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public pvl a()
  {
    return new pvl(this, null);
  }
  
  public pvm a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public pvm a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public pvm a(@NonNull List<rib> paramList)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() == 1)) {
      ((rib)this.jdField_b_of_type_JavaUtilList.get(0)).a(true);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public pvm b(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public pvm b(@NonNull List<URL> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvm
 * JD-Core Version:    0.7.0.1
 */