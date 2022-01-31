import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class rjg
  implements rnl
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is fail");
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = (JSONArray)new JSONObject(paramString).get("preload_bids");
      int i = 0;
      while (i < paramString.length())
      {
        rjb.a((String)paramString.get(i), null);
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is success");
      }
      rjb.jdField_a_of_type_JavaLangString = obz.a();
      rjb.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaAccessHelper", 2, "pre load all offline from net is exception:" + paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rjg
 * JD-Core Version:    0.7.0.1
 */