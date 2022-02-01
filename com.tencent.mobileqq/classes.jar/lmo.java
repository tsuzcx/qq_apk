import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lmo
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static lmo a()
  {
    Object localObject = lbt.b(298).jdField_a_of_type_JavaLangString;
    lmo locallmo = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locallmo = a((String)localObject);
    }
    localObject = locallmo;
    if (locallmo == null) {
      localObject = new lmo();
    }
    return localObject;
  }
  
  static lmo a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      lmo locallmo = new lmo();
      locallmo.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      locallmo.jdField_a_of_type_Int = paramString.getInt("task_id");
      locallmo.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      locallmo.b = paramString.getString("MD5_zip_so");
      locallmo.c = paramString.getString("MD5_so");
      locallmo.d = paramString.getString("so_name");
      return locallmo;
    }
    catch (Exception paramString)
    {
      QLog.d("QavGPDownloadManager", 1, String.format("parseJson, Exception\n%s", new Object[] { paramString }));
    }
    return null;
  }
  
  public String toString()
  {
    return String.format("task_id[%s], enable[%s], url_zip_so[%s], MD5_zip_so[%s], MD5_so[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaLangString, this.b, this.c });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmo
 * JD-Core Version:    0.7.0.1
 */