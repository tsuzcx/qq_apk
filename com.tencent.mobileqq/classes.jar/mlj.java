import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mlj
{
  public static String a;
  private static mlj jdField_a_of_type_Mlj;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private mlk[] jdField_a_of_type_ArrayOfMlk;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mlj a()
  {
    if (jdField_a_of_type_Mlj == null) {}
    try
    {
      if (jdField_a_of_type_Mlj == null) {
        jdField_a_of_type_Mlj = new mlj();
      }
      return jdField_a_of_type_Mlj;
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
      this.jdField_a_of_type_ArrayOfMlk = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lbc.d(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMlk = new mlk[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            mlk localmlk = new mlk();
            localmlk.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmlk.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmlk.c = localJSONObject.getString("icon2");
            localmlk.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmlk.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMlk[i] = localmlk;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMlk = null;
        return;
      }
    }
  }
  
  public mlk[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMlk == null) {
      a(lbq.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMlk == null) && (!this.jdField_a_of_type_Boolean))
    {
      mll.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMlk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlj
 * JD-Core Version:    0.7.0.1
 */