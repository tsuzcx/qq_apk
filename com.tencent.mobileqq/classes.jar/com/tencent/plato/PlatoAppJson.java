package com.tencent.plato;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PlatoAppJson
{
  private static String jdField_b_of_type_JavaLangString = "PlatoAppJson";
  private int jdField_a_of_type_Int;
  public String a;
  public ArrayList a;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i = "normal";
  
  public PlatoAppJson(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_OrgJsonJSONObject = a(paramString);
    if (this.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      this.jdField_c_of_type_JavaLangString = "";
      this.d = "App";
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 2;
      this.jdField_c_of_type_Int = 0;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = true;
      this.i = "newest";
      this.e = "defalut";
      this.f = "defalut";
      this.g = "";
      this.h = "defalut";
      return;
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("name");
    this.d = this.jdField_a_of_type_OrgJsonJSONObject.optString("page_main", "App");
    this.jdField_a_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("version", 0);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("fullscreen", false);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("apl_level", 2);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("falut", 0);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("gray", false);
    this.jdField_c_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("debug", true);
    this.i = this.jdField_a_of_type_OrgJsonJSONObject.optString("update", "newest");
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONArray("api_spec");
    while (j < paramString.length())
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramString.optString(j));
      j += 1;
    }
    paramString = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("window");
    this.e = paramString.optString("navigationBarBackgroundColor", "defalut");
    this.f = paramString.optString("navigationBarTextStyle", "defalut");
    this.g = paramString.optString("navigationBarTitleText", "");
    this.h = paramString.optString("backgroundColor", "defalut");
  }
  
  /* Error */
  protected static JSONObject a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 160	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: ldc 162
    //   16: invokestatic 166	com/tencent/plato/PlatoAppManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 172	java/io/File:exists	()Z
    //   27: ifeq -20 -> 7
    //   30: new 174	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 177	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull -33 -> 7
    //   43: aload_0
    //   44: invokestatic 182	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_0
    //   49: invokevirtual 187	java/io/InputStream:close	()V
    //   52: new 83	org/json/JSONObject
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   68: aconst_null
    //   69: astore_0
    //   70: goto -31 -> 39
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   78: goto -26 -> 52
    //   81: astore_0
    //   82: getstatic 24	com/tencent/plato/PlatoAppJson:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   85: iconst_0
    //   86: new 193	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   93: ldc 196
    //   95: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: invokevirtual 204	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   102: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 212	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: getstatic 24	com/tencent/plato/PlatoAppJson:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   117: iconst_0
    //   118: new 193	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   125: ldc 196
    //   127: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 212	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aconst_null
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	String
    //   47	10	1	str	String
    // Exception table:
    //   from	to	target	type
    //   30	39	63	java/io/IOException
    //   48	52	73	java/io/IOException
    //   52	61	81	org/json/JSONException
    //   52	61	113	java/lang/Exception
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public String b()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.plato.PlatoAppJson
 * JD-Core Version:    0.7.0.1
 */