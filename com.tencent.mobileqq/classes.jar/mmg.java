import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mmg
{
  public static String a;
  private static mmg jdField_a_of_type_Mmg;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private mmh[] jdField_a_of_type_ArrayOfMmh;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mmg a()
  {
    if (jdField_a_of_type_Mmg == null) {}
    try
    {
      if (jdField_a_of_type_Mmg == null) {
        jdField_a_of_type_Mmg = new mmg();
      }
      return jdField_a_of_type_Mmg;
    }
    finally {}
  }
  
  protected void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfMmh = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lbj.d(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMmh = new mmh[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            mmh localmmh = new mmh();
            localmmh.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmmh.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmmh.c = localJSONObject.getString("icon2");
            localmmh.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmmh.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMmh[i] = localmmh;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMmh = null;
        return;
      }
    }
  }
  
  public mmh[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMmh == null) {
      a(lbx.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMmh == null) && (!this.jdField_a_of_type_Boolean))
    {
      mmi.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMmh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmg
 * JD-Core Version:    0.7.0.1
 */