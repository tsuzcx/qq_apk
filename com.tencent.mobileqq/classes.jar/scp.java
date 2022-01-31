import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class scp
{
  public List<String> a;
  public String d;
  public int e;
  public String e;
  public int f;
  public int g;
  
  public scp(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public scp a(JSONObject paramJSONObject, int paramInt)
  {
    this.d = paramJSONObject.optString("transId", "");
    this.g = paramJSONObject.optInt("min_limit", paramInt);
    this.jdField_e_of_type_JavaLangString = paramJSONObject.optString("wording");
    this.f = paramJSONObject.optInt("text_id", -1);
    paramJSONObject = paramJSONObject.optJSONArray("transList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      this.a = new ArrayList();
      paramInt = 0;
      while (paramInt < paramJSONObject.length())
      {
        this.a.add(paramJSONObject.getString(paramInt));
        paramInt += 1;
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scp
 * JD-Core Version:    0.7.0.1
 */