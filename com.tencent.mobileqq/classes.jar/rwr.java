import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import org.json.JSONObject;

class rwr
  implements qkf
{
  IJSApiAdapter.OnInovkeCallback a;
  
  public rwr(IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback)
  {
    this.a = paramOnInovkeCallback;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (this.a != null) {
      this.a.callback(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwr
 * JD-Core Version:    0.7.0.1
 */