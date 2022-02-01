import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class mbl
{
  public static String a;
  private static mbl jdField_a_of_type_Mbl;
  private int jdField_a_of_type_Int = -1;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  static
  {
    jdField_a_of_type_JavaLangString = "AIOTopRightButtonConfig";
  }
  
  public static mbl a()
  {
    try
    {
      if (jdField_a_of_type_Mbl == null) {
        jdField_a_of_type_Mbl = new mbl();
      }
      return jdField_a_of_type_Mbl;
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
      a(lbt.b(192).jdField_a_of_type_JavaLangString);
    }
    return this.jdField_a_of_type_Int == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mbl
 * JD-Core Version:    0.7.0.1
 */