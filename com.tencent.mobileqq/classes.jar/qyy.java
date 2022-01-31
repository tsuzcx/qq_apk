import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class qyy
{
  public int a;
  public BaseArticleInfo a;
  public HashMap<String, String> a;
  public int b;
  
  public qyy(BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, Map<String, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaUtilHashMap.putAll(paramMap);
  }
  
  public abstract void a(JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyy
 * JD-Core Version:    0.7.0.1
 */