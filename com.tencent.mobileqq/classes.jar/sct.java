import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.util.ArrayList;
import java.util.List;

public class sct
{
  private final String jdField_a_of_type_JavaLangString;
  private List<BaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private scu jdField_a_of_type_Scu;
  private List<BaseData> b = new ArrayList();
  
  public sct(String paramString, scu paramscu)
  {
    this.jdField_a_of_type_Scu = paramscu;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Scu != null)) {
        this.jdField_a_of_type_Scu.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<BaseData> paramList)
  {
    this.b = paramList;
    a();
  }
  
  public void b(List<BaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sct
 * JD-Core Version:    0.7.0.1
 */