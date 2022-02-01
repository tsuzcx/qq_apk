import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mlp
{
  public static String a;
  private static mlp jdField_a_of_type_Mlp;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private mlq[] jdField_a_of_type_ArrayOfMlq;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mlp a()
  {
    if (jdField_a_of_type_Mlp == null) {}
    try
    {
      if (jdField_a_of_type_Mlp == null) {
        jdField_a_of_type_Mlp = new mlp();
      }
      return jdField_a_of_type_Mlp;
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
      this.jdField_a_of_type_ArrayOfMlq = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lba.g(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMlq = new mlq[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            mlq localmlq = new mlq();
            localmlq.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmlq.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmlq.c = localJSONObject.getString("icon2");
            localmlq.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmlq.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMlq[i] = localmlq;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMlq = null;
        return;
      }
    }
  }
  
  public mlq[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMlq == null) {
      a(lbp.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMlq == null) && (!this.jdField_a_of_type_Boolean))
    {
      mlr.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMlq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlp
 * JD-Core Version:    0.7.0.1
 */