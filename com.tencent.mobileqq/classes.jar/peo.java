import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class peo
{
  private JSONObject a;
  
  public peo()
  {
    this.a = new JSONObject();
    a();
  }
  
  public peo(String paramString)
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
        this.a.put("version", "8.2.6");
        this.a.put("pts_engine_version", pdu.a().a());
        this.a.put("pts_app_version", pds.a().a());
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
  
  public peo a(String paramString1, String paramString2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     peo
 * JD-Core Version:    0.7.0.1
 */