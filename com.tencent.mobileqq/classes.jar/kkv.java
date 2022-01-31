import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.authorize.FlatBuffersConfig;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import java.util.concurrent.ConcurrentHashMap;

public class kkv
  implements Runnable
{
  public kkv(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    if (l > AuthorizeConfig.jdField_a_of_type_Long + 10000L)
    {
      this.a.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
      AuthorizeConfig.jdField_a_of_type_Long = l;
    }
    FlatBuffersParser.b();
    l = this.a.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != AuthorizeConfig.jdField_b_of_type_Long)
    {
      AuthorizeConfig.jdField_b_of_type_Long = l;
      this.a.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.b();
      this.a.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a();
      this.a.i = null;
      this.a.jdField_b_of_type_OrgJsonJSONObject = null;
      this.a.jdField_c_of_type_OrgJsonJSONObject = null;
      this.a.jdField_a_of_type_OrgJsonJSONObject = null;
      this.a.jdField_c_of_type_OrgJsonJSONArray = null;
      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.a.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kkv
 * JD-Core Version:    0.7.0.1
 */