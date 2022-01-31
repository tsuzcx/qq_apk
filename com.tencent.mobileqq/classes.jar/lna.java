import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lna
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static lna a()
  {
    Object localObject = lcy.b(298).jdField_a_of_type_JavaLangString;
    lna locallna = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locallna = a((String)localObject);
    }
    localObject = locallna;
    if (locallna == null) {
      localObject = new lna();
    }
    return localObject;
  }
  
  static lna a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      lna locallna = new lna();
      boolean bool = AppSetting.b;
      locallna.jdField_a_of_type_Boolean = localJSONObject.getBoolean("enable");
      locallna.jdField_a_of_type_Int = localJSONObject.getInt("task_id");
      if (bool)
      {
        paramString = localJSONObject.getString("url_zip_so_64");
        locallna.jdField_a_of_type_JavaLangString = paramString;
        if (!bool) {
          break label111;
        }
        paramString = localJSONObject.getString("MD5_zip_so_64");
        label68:
        locallna.b = paramString;
        if (!bool) {
          break label121;
        }
      }
      label111:
      label121:
      for (paramString = localJSONObject.getString("MD5_so_64");; paramString = localJSONObject.getString("MD5_so"))
      {
        locallna.c = paramString;
        locallna.d = localJSONObject.getString("so_name");
        return locallna;
        paramString = localJSONObject.getString("url_zip_so");
        break;
        paramString = localJSONObject.getString("MD5_zip_so");
        break label68;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.d("QavGPDownloadManager", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
  }
  
  public String toString()
  {
    return String.format("task_id[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.b, this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lna
 * JD-Core Version:    0.7.0.1
 */