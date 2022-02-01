import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lmj
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static lmj a()
  {
    Object localObject = lbx.b(298).jdField_a_of_type_JavaLangString;
    lmj locallmj = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locallmj = a((String)localObject);
    }
    localObject = locallmj;
    if (locallmj == null) {
      localObject = new lmj();
    }
    return localObject;
  }
  
  static lmj a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      lmj locallmj = new lmj();
      locallmj.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      locallmj.jdField_a_of_type_Int = paramString.getInt("task_id");
      locallmj.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      locallmj.b = paramString.getString("MD5_zip_so");
      locallmj.c = paramString.getString("MD5_so");
      locallmj.d = paramString.getString("so_name");
      return locallmj;
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
 * Qualified Name:     lmj
 * JD-Core Version:    0.7.0.1
 */