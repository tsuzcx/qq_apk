import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mog
{
  public static String a;
  private static mog jdField_a_of_type_Mog;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private moh[] jdField_a_of_type_ArrayOfMoh;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mog a()
  {
    if (jdField_a_of_type_Mog == null) {}
    try
    {
      if (jdField_a_of_type_Mog == null) {
        jdField_a_of_type_Mog = new mog();
      }
      return jdField_a_of_type_Mog;
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
      this.jdField_a_of_type_ArrayOfMoh = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lek.d(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMoh = new moh[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            moh localmoh = new moh();
            localmoh.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmoh.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmoh.c = localJSONObject.getString("icon2");
            localmoh.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmoh.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMoh[i] = localmoh;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMoh = null;
        return;
      }
    }
  }
  
  public moh[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMoh == null) {
      a(lex.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMoh == null) && (!this.jdField_a_of_type_Boolean))
    {
      moi.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMoh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mog
 * JD-Core Version:    0.7.0.1
 */