import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class rbg
{
  protected abstract void a();
  
  public abstract void a(ListView paramListView);
  
  protected void a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject.put("folder_status", obz.d);
      paramJSONObject.put("kandian_mode", obz.e());
      paramJSONObject = paramJSONObject.toString();
      ndn.a(null, "", paramString, paramString, 0, 0, "", "", "", paramJSONObject, false);
      QLog.d("HeaderViewController", 2, "report: T - " + paramString + " r5 - " + paramJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("HeaderViewController", 2, "report failed due to JSONException: " + paramString.getMessage());
      throw new IllegalArgumentException("fail to construct r5 json");
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    a();
  }
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rbg
 * JD-Core Version:    0.7.0.1
 */