import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mlm
{
  public static String a;
  private static mlm jdField_a_of_type_Mlm;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private mln[] jdField_a_of_type_ArrayOfMln;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mlm a()
  {
    if (jdField_a_of_type_Mlm == null) {}
    try
    {
      if (jdField_a_of_type_Mlm == null) {
        jdField_a_of_type_Mlm = new mlm();
      }
      return jdField_a_of_type_Mlm;
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
      this.jdField_a_of_type_ArrayOfMln = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lcg.d(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMln = new mln[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            mln localmln = new mln();
            localmln.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmln.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmln.c = localJSONObject.getString("icon2");
            localmln.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmln.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMln[i] = localmln;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMln = null;
        return;
      }
    }
  }
  
  public mln[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMln == null) {
      a(lct.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMln == null) && (!this.jdField_a_of_type_Boolean))
    {
      mlo.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMln;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */