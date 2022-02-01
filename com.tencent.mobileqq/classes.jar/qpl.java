import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class qpl
{
  private JSONObject a;
  
  public qpl()
  {
    this.a = new JSONObject();
    a();
  }
  
  public qpl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        this.a = new JSONObject(paramString);
        a();
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("PTSReport", 1, "e = " + paramString);
        this.a = new JSONObject();
        a();
        return;
      }
    }
    this.a = new JSONObject();
    a();
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        this.a.put("os", "1");
        this.a.put("version", "8.4.1");
        this.a.put("pts_engine_version", qoi.a().a());
        this.a.put("pts_app_version", qog.a().a());
        this.a.put("sdk_version", String.valueOf(Build.VERSION.SDK_INT));
        JSONObject localJSONObject = this.a;
        if (!TextUtils.isEmpty(Build.BRAND))
        {
          String str1 = Build.BRAND;
          localJSONObject.put("device_brand", str1);
          localJSONObject = this.a;
          if (!TextUtils.isEmpty(Build.MODEL))
          {
            str1 = Build.MODEL;
            localJSONObject.put("device_model", str1);
            this.a.put("is_debug", "0");
            return;
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (JSONException localJSONException)
      {
        QLog.e("PTSReport", 1, "[initCommonField], e = " + localJSONException);
        return;
      }
    }
  }
  
  public String a()
  {
    return this.a.toString();
  }
  
  public qpl a(String paramString1, String paramString2)
  {
    try
    {
      this.a.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException paramString1)
    {
      QLog.e("PTSReport", 1, "[addString], e = " + paramString1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */