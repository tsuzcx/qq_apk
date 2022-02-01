import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class pqg
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString = null;
  JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public pqg() {}
  
  public pqg(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
  }
  
  public String a()
  {
    int j = 1;
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("time", System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("channel_id", this.jdField_a_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", pqu.a());
      }
      if (this.d) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode_new", omx.a());
      }
      if (this.e) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("tab_source", pqf.a());
      }
      if (this.f) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_id", this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_voice", this.jdField_b_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_type", this.jdField_c_of_type_Int);
      }
      Object localObject;
      if (this.g)
      {
        localObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label286;
        }
      }
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", j);
        if (this.h) {
          omx.a(this.jdField_a_of_type_OrgJsonJSONObject);
        }
        if (this.i) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("os", "1");
        }
        localObject = this.jdField_a_of_type_OrgJsonJSONObject.toString();
        return localObject;
        label286:
        j = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public pqg a()
  {
    this.h = true;
    return this;
  }
  
  public pqg a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public pqg a(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", paramLong);
    return this;
  }
  
  public pqg a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public pqg a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
    return this;
  }
  
  public pqg a(String paramString, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.catchedExceptionInReleaseV2("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramLong));
    }
    return this;
  }
  
  public pqg a(String paramString, Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.catchedExceptionInReleaseV2("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramObject));
    }
    return this;
  }
  
  public pqg a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
    return this;
  }
  
  public pqg a(@NotNull JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(str, localObject);
      }
      catch (JSONException localJSONException)
      {
        AIOUtils.catchedExceptionInReleaseV2("RIJTransMergeKanDianReport", "", new IllegalArgumentException(str + " : " + localObject));
      }
    }
    return this;
  }
  
  public pqg a(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("reddot", j);
      return this;
    }
  }
  
  public pqg b()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public pqg b(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("location", paramInt);
    return this;
  }
  
  public pqg b(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", paramLong);
    return this;
  }
  
  public pqg b(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("rowkey", paramString);
    return this;
  }
  
  public pqg b(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.catchedExceptionInReleaseV2("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramInt));
    }
    return this;
  }
  
  public pqg b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.catchedExceptionInReleaseV2("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString1 + " : " + paramString2));
    }
    return this;
  }
  
  public pqg b(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 0;; j = 1)
    {
      localJSONObject.put("button_state", j);
      return this;
    }
  }
  
  public pqg c()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public pqg c(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("type", paramInt);
    return this;
  }
  
  public pqg c(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("article_id", paramLong);
    return this;
  }
  
  public pqg c(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_source", paramString);
    return this;
  }
  
  public pqg c(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      localJSONObject.put("reddot_status", j);
      return this;
    }
  }
  
  public pqg d()
  {
    this.g = true;
    return this;
  }
  
  public pqg d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public pqg d(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("topicid", paramLong);
    return this;
  }
  
  public pqg d(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("channel_version", paramString);
      return this;
      paramString = "";
    }
  }
  
  public pqg e()
  {
    this.jdField_c_of_type_Boolean = true;
    return this;
  }
  
  public pqg e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public pqg e(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("channel_city", paramString);
      return this;
      paramString = "";
    }
  }
  
  public pqg f()
  {
    this.d = true;
    return this;
  }
  
  public pqg f(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("number", paramInt);
    return this;
  }
  
  public pqg g()
  {
    this.e = true;
    return this;
  }
  
  public pqg g(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("words", paramInt);
    return this;
  }
  
  public pqg h()
  {
    this.f = true;
    return this;
  }
  
  public pqg h(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("likes", paramInt);
    return this;
  }
  
  public pqg i()
  {
    this.i = true;
    return this;
  }
  
  public pqg i(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", paramInt);
    return this;
  }
  
  public pqg j()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imei", pqu.b());
    return this;
  }
  
  public pqg j(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("biu", paramInt);
    return this;
  }
  
  public pqg k()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imsi", pqu.c());
    return this;
  }
  
  public pqg k(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_type", paramInt);
    return this;
  }
  
  public pqg l()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (NetworkUtil.isWifiConnected(null)) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("network_type", j);
      return this;
    }
  }
  
  public pqg l(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_num", paramInt);
    return this;
  }
  
  public pqg m()
  {
    return b("version", omx.jdField_a_of_type_JavaLangString);
  }
  
  public pqg m(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("content_type", paramInt);
    return this;
  }
  
  public pqg n(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_status", paramInt + 1);
    return this;
  }
  
  public pqg o(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("share_option", paramInt);
    return this;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqg
 * JD-Core Version:    0.7.0.1
 */