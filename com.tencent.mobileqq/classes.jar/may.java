import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class may
{
  public static String a;
  private static may jdField_a_of_type_May;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private maz[] jdField_a_of_type_ArrayOfMaz;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static may a()
  {
    if (jdField_a_of_type_May == null) {}
    try
    {
      if (jdField_a_of_type_May == null) {
        jdField_a_of_type_May = new may();
      }
      return jdField_a_of_type_May;
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
      this.jdField_a_of_type_ArrayOfMaz = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          krx.d(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMaz = new maz[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            maz localmaz = new maz();
            localmaz.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmaz.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmaz.c = localJSONObject.getString("icon2");
            localmaz.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmaz.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMaz[i] = localmaz;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMaz = null;
        return;
      }
    }
  }
  
  public maz[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMaz == null) {
      a(ksj.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMaz == null) && (!this.jdField_a_of_type_Boolean))
    {
      mba.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     may
 * JD-Core Version:    0.7.0.1
 */