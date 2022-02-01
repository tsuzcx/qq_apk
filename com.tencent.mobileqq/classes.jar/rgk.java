import android.support.annotation.NonNull;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class rgk
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private List<URL> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String jdField_b_of_type_JavaLangString = "";
  private List<teh> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  public rgj a()
  {
    return new rgj(this, null);
  }
  
  public rgk a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public rgk a(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public rgk a(@NonNull List<teh> paramList)
  {
    if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() == 1)) {
      ((teh)this.jdField_b_of_type_JavaUtilList.get(0)).a(true);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public rgk b(@NonNull String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public rgk b(@NonNull List<URL> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgk
 * JD-Core Version:    0.7.0.1
 */