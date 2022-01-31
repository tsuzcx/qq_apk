import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class loy
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static loy a()
  {
    Object localObject = lex.b(298).jdField_a_of_type_JavaLangString;
    loy localloy = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localloy = a((String)localObject);
    }
    localObject = localloy;
    if (localloy == null) {
      localObject = new loy();
    }
    return localObject;
  }
  
  static loy a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      loy localloy = new loy();
      localloy.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      localloy.jdField_a_of_type_Int = paramString.getInt("task_id");
      localloy.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      localloy.b = paramString.getString("MD5_zip_so");
      localloy.c = paramString.getString("MD5_so");
      localloy.d = paramString.getString("so_name");
      return localloy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     loy
 * JD-Core Version:    0.7.0.1
 */