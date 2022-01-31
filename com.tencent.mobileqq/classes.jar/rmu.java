import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.util.ArrayList;
import java.util.List;

public class rmu
{
  private final String jdField_a_of_type_JavaLangString;
  private List<BaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private rmv jdField_a_of_type_Rmv;
  private List<BaseData> b = new ArrayList();
  
  public rmu(String paramString, rmv paramrmv)
  {
    this.jdField_a_of_type_Rmv = paramrmv;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Rmv != null)) {
        this.jdField_a_of_type_Rmv.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmu
 * JD-Core Version:    0.7.0.1
 */