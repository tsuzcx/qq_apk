import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.HashSet;
import org.json.JSONObject;

public class tgq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private HashSet<tgp> jdField_a_of_type_JavaUtilHashSet;
  private HashSet<tgp> b;
  private HashSet<tgp> c;
  
  private void a(tgp paramtgp)
  {
    if (this.c.contains(paramtgp)) {}
    do
    {
      return;
      this.c.add(paramtgp);
    } while ((!this.b.contains(paramtgp)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(paramtgp)));
    this.jdField_a_of_type_JavaUtilHashSet.add(paramtgp);
    b(paramtgp);
  }
  
  private void b(tgp paramtgp)
  {
    float f = paramtgp.jdField_a_of_type_Float;
    long l = paramtgp.jdField_a_of_type_Long;
    paramtgp = paramtgp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramtgp == null) {
      return;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("article_id", String.valueOf(paramtgp.mArticleID));
      localJSONObject1.put("rowkey", String.valueOf(paramtgp.mRowKey));
      paramtgp.mBusiJson = localJSONObject1;
      localJSONObject2.put("exposureArea", f);
      localJSONObject2.put("exposureTime", l);
      paramtgp.mReportDataJson = localJSONObject2;
      uec.a(this.jdField_a_of_type_AndroidContentContext, paramtgp, 38, 2, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ukq.a("ListAdExposeManager", localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tgq
 * JD-Core Version:    0.7.0.1
 */