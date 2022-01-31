import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import org.json.JSONObject;

class sne
  implements qzm
{
  IJSApiAdapter.OnInovkeCallback a;
  
  public sne(IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sne
 * JD-Core Version:    0.7.0.1
 */