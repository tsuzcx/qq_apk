import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class mdj
{
  public static String a;
  private static mdj jdField_a_of_type_Mdj;
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "AIOTopRightButtonConfig";
  }
  
  public static mdj a()
  {
    try
    {
      if (jdField_a_of_type_Mdj == null) {
        jdField_a_of_type_Mdj = new mdj();
      }
      return jdField_a_of_type_Mdj;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = 1;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      if ((paramString.has("AVFromRightCornerEnable")) && (!paramString.getBoolean("AVFromRightCornerEnable"))) {
        this.jdField_a_of_type_Int = 0;
      }
      return;
      paramString = finally;
      throw paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "updateConfig, JSONException", paramString);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(lex.b(192).jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdj
 * JD-Core Version:    0.7.0.1
 */