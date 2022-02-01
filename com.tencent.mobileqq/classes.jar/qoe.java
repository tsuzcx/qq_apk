import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;

public class qoe
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private snh jdField_a_of_type_Snh;
  private HashMap<String, ArticleInfo> b;
  
  public qoc a()
  {
    qoc localqoc = new qoc(null);
    qoc.a(localqoc, this.jdField_a_of_type_Snh);
    qoc.a(localqoc, this.jdField_a_of_type_JavaUtilHashMap);
    qoc.b(localqoc, this.b);
    return localqoc;
  }
  
  public qoe a(HashMap<String, Integer> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  public qoe a(snh paramsnh)
  {
    this.jdField_a_of_type_Snh = paramsnh;
    return this;
  }
  
  public qoe b(HashMap<String, ArticleInfo> paramHashMap)
  {
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoe
 * JD-Core Version:    0.7.0.1
 */