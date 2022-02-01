import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mmm
{
  public static String a;
  private static mmm jdField_a_of_type_Mmm;
  private final int jdField_a_of_type_Int = 40;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private mmn[] jdField_a_of_type_ArrayOfMmn;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VoiceChangeData";
  }
  
  public static mmm a()
  {
    if (jdField_a_of_type_Mmm == null) {}
    try
    {
      if (jdField_a_of_type_Mmm == null) {
        jdField_a_of_type_Mmm = new mmm();
      }
      return jdField_a_of_type_Mmm;
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
      this.jdField_a_of_type_ArrayOfMmn = null;
      try
      {
        Object localObject2 = new JSONObject(paramString);
        if (((JSONObject)localObject2).has("voices"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("voices");
          lbd.g(jdField_a_of_type_JavaLangString, "parseConfig|voices size= " + ((JSONArray)localObject2).length());
          this.jdField_a_of_type_ArrayOfMmn = new mmn[((JSONArray)localObject2).length()];
          int i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
            mmn localmmn = new mmn();
            localmmn.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
            localmmn.jdField_b_of_type_JavaLangString = localJSONObject.getString("icon1");
            localmmn.c = localJSONObject.getString("icon2");
            localmmn.jdField_a_of_type_Int = Integer.parseInt(localJSONObject.getString("type"));
            localmmn.jdField_b_of_type_Int = Integer.parseInt(localJSONObject.getString("vip_level"));
            this.jdField_a_of_type_ArrayOfMmn[i] = localmmn;
            i += 1;
          }
        }
        paramString = finally;
      }
      catch (JSONException localJSONException)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "parseConfig, JSONException, \ncontent[" + paramString + "]", localJSONException);
        this.jdField_a_of_type_ArrayOfMmn = null;
        return;
      }
    }
  }
  
  public mmn[] a()
  {
    if (this.jdField_a_of_type_ArrayOfMmn == null) {
      a(lbt.b(172).jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfMmn == null) && (!this.jdField_a_of_type_Boolean))
    {
      mmo.a("0X8007EFD", "");
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_ArrayOfMmn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmm
 * JD-Core Version:    0.7.0.1
 */