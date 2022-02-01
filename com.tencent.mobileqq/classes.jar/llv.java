import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class llv
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  public boolean a;
  String b;
  String c;
  String d;
  
  public static llv a()
  {
    Object localObject = lbq.b(298).jdField_a_of_type_JavaLangString;
    llv localllv = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localllv = a((String)localObject);
    }
    localObject = localllv;
    if (localllv == null) {
      localObject = new llv();
    }
    return localObject;
  }
  
  static llv a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      llv localllv = new llv();
      localllv.jdField_a_of_type_Boolean = paramString.getBoolean("enable");
      localllv.jdField_a_of_type_Int = paramString.getInt("task_id");
      localllv.jdField_a_of_type_JavaLangString = paramString.getString("url_zip_so");
      localllv.b = paramString.getString("MD5_zip_so");
      localllv.c = paramString.getString("MD5_so");
      localllv.d = paramString.getString("so_name");
      return localllv;
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
 * Qualified Name:     llv
 * JD-Core Version:    0.7.0.1
 */