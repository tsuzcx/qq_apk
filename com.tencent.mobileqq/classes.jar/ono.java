import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class ono
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
  
  public ono() {}
  
  public ono(JSONObject paramJSONObject)
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
        this.jdField_a_of_type_OrgJsonJSONObject.put("folder_status", onh.d);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("time", System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("channel_id", this.jdField_a_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", onh.e());
      }
      if (this.d) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode_new", npu.a());
      }
      if (this.e) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("tab_source", onh.d());
      }
      if (this.f) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("session_id", onh.k());
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
        if (bhvy.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label286;
        }
      }
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", j);
        if (this.h) {
          npu.a(this.jdField_a_of_type_OrgJsonJSONObject);
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
  
  public ono a()
  {
    this.h = true;
    return this;
  }
  
  public ono a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ono a(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", paramLong);
    return this;
  }
  
  public ono a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ono a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
    return this;
  }
  
  public ono a(String paramString, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      actj.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramLong));
    }
    return this;
  }
  
  public ono a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
    return this;
  }
  
  public ono a(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("reddot", j);
      return this;
    }
  }
  
  public ono b()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public ono b(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("location", paramInt);
    return this;
  }
  
  public ono b(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", paramLong);
    return this;
  }
  
  public ono b(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("rowkey", paramString);
    return this;
  }
  
  public ono b(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      actj.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramInt));
    }
    return this;
  }
  
  public ono b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      actj.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString1 + " : " + paramString2));
    }
    return this;
  }
  
  public ono b(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 0;; j = 1)
    {
      localJSONObject.put("button_state", j);
      return this;
    }
  }
  
  public ono c()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public ono c(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("type", paramInt);
    return this;
  }
  
  public ono c(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("article_id", paramLong);
    return this;
  }
  
  public ono c(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_source", paramString);
    return this;
  }
  
  public ono c(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      localJSONObject.put("reddot_status", j);
      return this;
    }
  }
  
  public ono d()
  {
    this.g = true;
    return this;
  }
  
  public ono d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ono d(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("topicid", paramLong);
    return this;
  }
  
  public ono d(String paramString)
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
  
  public ono e()
  {
    this.jdField_c_of_type_Boolean = true;
    return this;
  }
  
  public ono e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ono e(String paramString)
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
  
  public ono f()
  {
    this.d = true;
    return this;
  }
  
  public ono f(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("number", paramInt);
    return this;
  }
  
  public ono g()
  {
    this.e = true;
    return this;
  }
  
  public ono g(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("words", paramInt);
    return this;
  }
  
  public ono h()
  {
    this.f = true;
    return this;
  }
  
  public ono h(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("likes", paramInt);
    return this;
  }
  
  public ono i()
  {
    this.i = true;
    return this;
  }
  
  public ono i(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", paramInt);
    return this;
  }
  
  public ono j()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imei", onh.f());
    return this;
  }
  
  public ono j(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("biu", paramInt);
    return this;
  }
  
  public ono k()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imsi", onh.g());
    return this;
  }
  
  public ono k(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_type", paramInt);
    return this;
  }
  
  public ono l()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (bbfj.h(null)) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("network_type", j);
      return this;
    }
  }
  
  public ono l(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_num", paramInt);
    return this;
  }
  
  public ono m()
  {
    return b("version", npu.jdField_a_of_type_JavaLangString);
  }
  
  public ono m(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("content_type", paramInt);
    return this;
  }
  
  public ono n(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_status", paramInt + 1);
    return this;
  }
  
  public ono o(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("share_option", paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ono
 * JD-Core Version:    0.7.0.1
 */