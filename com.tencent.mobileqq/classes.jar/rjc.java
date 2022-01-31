import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class rjc
  implements rji
{
  public void a()
  {
    Object localObject = rjb.a("http://viola/viola_config.json?v_bid=3192");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = (JSONArray)new JSONObject((String)localObject).get("preload_bids");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          rjb.a((String)((JSONArray)localObject).get(i), null);
          i += 1;
        }
        rjb.jdField_a_of_type_JavaLangString = obz.a();
        rjb.jdField_a_of_type_Long = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is success!");
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ViolaAccessHelper", 2, "pre load all offline from offline is exception:" + localException.getMessage());
        }
        rjb.b();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is empty!");
    }
    rjb.b();
  }
  
  public void a(int paramInt) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjc
 * JD-Core Version:    0.7.0.1
 */