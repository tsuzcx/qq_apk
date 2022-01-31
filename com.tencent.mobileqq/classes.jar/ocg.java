import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class ocg
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
  
  public ocg() {}
  
  public ocg(JSONObject paramJSONObject)
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
        this.jdField_a_of_type_OrgJsonJSONObject.put("folder_status", obz.d);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("time", System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("channel_id", this.jdField_a_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", obz.e());
      }
      if (this.d) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode_new", new.a());
      }
      if (this.e) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("tab_source", obz.d());
      }
      if (this.f) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("session_id", obz.k());
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
        if (bgmq.I(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label286;
        }
      }
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", j);
        if (this.h) {
          new.a(this.jdField_a_of_type_OrgJsonJSONObject);
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
  
  public ocg a()
  {
    this.h = true;
    return this;
  }
  
  public ocg a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ocg a(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", paramLong);
    return this;
  }
  
  public ocg a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ocg a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
    return this;
  }
  
  public ocg a(String paramString, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      aciy.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramLong));
    }
    return this;
  }
  
  public ocg a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
    return this;
  }
  
  public ocg a(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("reddot", j);
      return this;
    }
  }
  
  public ocg b()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public ocg b(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("location", paramInt);
    return this;
  }
  
  public ocg b(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", paramLong);
    return this;
  }
  
  public ocg b(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("rowkey", paramString);
    return this;
  }
  
  public ocg b(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      aciy.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString + " : " + paramInt));
    }
    return this;
  }
  
  public ocg b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      aciy.a("ReadInJoyUtils", "", new IllegalArgumentException(paramString1 + " : " + paramString2));
    }
    return this;
  }
  
  public ocg b(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 0;; j = 1)
    {
      localJSONObject.put("button_state", j);
      return this;
    }
  }
  
  public ocg c()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public ocg c(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("type", paramInt);
    return this;
  }
  
  public ocg c(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("article_id", paramLong);
    return this;
  }
  
  public ocg c(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_source", paramString);
    return this;
  }
  
  public ocg c(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      localJSONObject.put("reddot_status", j);
      return this;
    }
  }
  
  public ocg d()
  {
    this.g = true;
    return this;
  }
  
  public ocg d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ocg d(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("topicid", paramLong);
    return this;
  }
  
  public ocg d(String paramString)
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
  
  public ocg e()
  {
    this.jdField_c_of_type_Boolean = true;
    return this;
  }
  
  public ocg e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ocg e(String paramString)
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
  
  public ocg f()
  {
    this.d = true;
    return this;
  }
  
  public ocg f(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("number", paramInt);
    return this;
  }
  
  public ocg g()
  {
    this.e = true;
    return this;
  }
  
  public ocg g(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("words", paramInt);
    return this;
  }
  
  public ocg h()
  {
    this.f = true;
    return this;
  }
  
  public ocg h(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("likes", paramInt);
    return this;
  }
  
  public ocg i()
  {
    this.i = true;
    return this;
  }
  
  public ocg i(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", paramInt);
    return this;
  }
  
  public ocg j()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imei", obz.f());
    return this;
  }
  
  public ocg j(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("biu", paramInt);
    return this;
  }
  
  public ocg k()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imsi", obz.g());
    return this;
  }
  
  public ocg k(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_type", paramInt);
    return this;
  }
  
  public ocg l()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (badq.h(null)) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("network_type", j);
      return this;
    }
  }
  
  public ocg l(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_num", paramInt);
    return this;
  }
  
  public ocg m()
  {
    return b("version", new.jdField_a_of_type_JavaLangString);
  }
  
  public ocg m(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("content_type", paramInt);
    return this;
  }
  
  public ocg n(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_status", paramInt + 1);
    return this;
  }
  
  public ocg o(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("share_option", paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ocg
 * JD-Core Version:    0.7.0.1
 */