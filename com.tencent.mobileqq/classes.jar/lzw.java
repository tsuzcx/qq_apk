import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import java.net.URL;
import org.json.JSONObject;

public class lzw
  implements Runnable
{
  public lzw(ReadInJoyWebDataManager paramReadInJoyWebDataManager, URL paramURL, String paramString1, String paramString2, JSONObject paramJSONObject) {}
  
  public void run()
  {
    long l = ReadInJoyWebDataManager.a();
    try
    {
      ReadInJoyWebDataManager.a(l);
      if (ReadInJoyWebDataManager.b() > 52428800L) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager.a(this.jdField_a_of_type_JavaNetURL.toString(), this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzw
 * JD-Core Version:    0.7.0.1
 */