import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class lcj
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static lcj a()
  {
    Object localObject = ksj.b(298).jdField_a_of_type_JavaLangString;
    lcj locallcj = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      locallcj = a((String)localObject);
    }
    localObject = locallcj;
    if (locallcj == null) {
      localObject = new lcj();
    }
    return localObject;
  }
  
  static lcj a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      lcj locallcj = new lcj();
      locallcj.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      locallcj.jdField_a_of_type_Int = paramString.getInt("task_id");
      locallcj.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      locallcj.b = paramString.getString("MD5_zip_so");
      locallcj.c = paramString.getString("MD5_so");
      locallcj.d = paramString.getString("so_name");
      return locallcj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lcj
 * JD-Core Version:    0.7.0.1
 */