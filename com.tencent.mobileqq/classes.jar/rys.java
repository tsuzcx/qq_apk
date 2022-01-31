import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import org.json.JSONException;
import org.json.JSONObject;

public class rys
  implements VComponentAdapter.OnVideoViewMethodListener
{
  public rys(VVideo paramVVideo) {}
  
  public void OnMethodError(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramString);
      localJSONObject.put("extra", paramJSONObject);
      this.a.videoFireEvent("error", localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void OnMethodSuccess(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      VVideo.access$000(this.a, paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rys
 * JD-Core Version:    0.7.0.1
 */