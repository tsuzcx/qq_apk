import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.HashSet;
import org.json.JSONObject;

public class stf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HashSet<ste> jdField_a_of_type_JavaUtilHashSet;
  private HashSet<ste> b;
  private HashSet<ste> c;
  
  private void a(ste paramste)
  {
    if (this.c.contains(paramste)) {}
    do
    {
      return;
      this.c.add(paramste);
    } while ((!this.b.contains(paramste)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramste)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramste);
    b(paramste);
  }
  
  private void b(ste paramste)
  {
    float f = paramste.jdField_a_of_type_Float;
    long l = paramste.jdField_a_of_type_Long;
    paramste = paramste.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramste == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramste.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramste.mRowKey));
      paramste.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramste.mReportDataJson = localJSONObject2;
      tqk.a(false, this.jdField_a_of_type_AndroidContentContext, paramste, obb.aq, obb.b, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        twp.a("ListAdExposeManager", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stf
 * JD-Core Version:    0.7.0.1
 */