import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lmb
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static lmb a()
  {
    Object localObject = lbp.b(298).jdField_a_of_type_JavaLangString;
    lmb locallmb = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locallmb = a((String)localObject);
    }
    localObject = locallmb;
    if (locallmb == null) {
      localObject = new lmb();
    }
    return localObject;
  }
  
  static lmb a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      lmb locallmb = new lmb();
      locallmb.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      locallmb.jdField_a_of_type_Int = paramString.getInt("task_id");
      locallmb.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      locallmb.b = paramString.getString("MD5_zip_so");
      locallmb.c = paramString.getString("MD5_so");
      locallmb.d = paramString.getString("so_name");
      return locallmb;
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
 * Qualified Name:     lmb
 * JD-Core Version:    0.7.0.1
 */