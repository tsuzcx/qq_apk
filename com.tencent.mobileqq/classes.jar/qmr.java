import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;

public class qmr
{
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private slt jdField_a_of_type_Slt;
  private HashMap<String, ArticleInfo> b;
  
  public qmp a()
  {
    qmp localqmp = new qmp(null);
    qmp.a(localqmp, this.jdField_a_of_type_Slt);
    qmp.a(localqmp, this.jdField_a_of_type_JavaUtilHashMap);
    qmp.b(localqmp, this.b);
    return localqmp;
  }
  
  public qmr a(HashMap<String, Integer> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  public qmr a(slt paramslt)
  {
    this.jdField_a_of_type_Slt = paramslt;
    return this;
  }
  
  public qmr b(HashMap<String, ArticleInfo> paramHashMap)
  {
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qmr
 * JD-Core Version:    0.7.0.1
 */