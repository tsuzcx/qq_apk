import android.text.TextUtils;
import org.json.JSONObject;

public class nxe
{
  public int a;
  public long a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public nxe()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
  }
  
  /* Error */
  public static nxe a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +158 -> 162
    //   7: new 2	nxe
    //   10: dup
    //   11: invokespecial 36	nxe:<init>	()V
    //   14: astore_1
    //   15: new 38	org/json/JSONObject
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 41	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_1
    //   25: aload_0
    //   26: ldc 43
    //   28: invokevirtual 47	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   31: putfield 23	nxe:jdField_a_of_type_Long	J
    //   34: aload_1
    //   35: aload_0
    //   36: ldc 49
    //   38: invokevirtual 53	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   41: putfield 25	nxe:jdField_a_of_type_Int	I
    //   44: aload_1
    //   45: aload_0
    //   46: ldc 55
    //   48: invokevirtual 53	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   51: putfield 57	nxe:jdField_b_of_type_Int	I
    //   54: aload_1
    //   55: aload_0
    //   56: ldc 59
    //   58: invokevirtual 53	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   61: putfield 61	nxe:jdField_c_of_type_Int	I
    //   64: aload_1
    //   65: aload_0
    //   66: ldc 63
    //   68: invokevirtual 53	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   71: putfield 65	nxe:jdField_d_of_type_Int	I
    //   74: aload_1
    //   75: aload_0
    //   76: ldc 43
    //   78: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield 71	nxe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: aload_1
    //   85: aload_0
    //   86: ldc 73
    //   88: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 75	nxe:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   94: aload_1
    //   95: aload_0
    //   96: ldc 77
    //   98: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   101: putfield 79	nxe:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   104: aload_1
    //   105: aload_0
    //   106: ldc 81
    //   108: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 83	nxe:f	Ljava/lang/String;
    //   114: aload_1
    //   115: aload_0
    //   116: ldc 85
    //   118: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: putfield 87	nxe:e	Ljava/lang/String;
    //   124: aload_1
    //   125: aload_0
    //   126: ldc 89
    //   128: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: putfield 91	nxe:h	Ljava/lang/String;
    //   134: aload_1
    //   135: aload_0
    //   136: ldc 93
    //   138: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   141: putfield 95	nxe:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   144: aload_1
    //   145: aload_0
    //   146: ldc 97
    //   148: invokevirtual 69	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   151: putfield 99	nxe:g	Ljava/lang/String;
    //   154: aload_1
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_0
    //   160: aload_1
    //   161: areturn
    //   162: aconst_null
    //   163: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   14	147	1	localnxe	nxe
    // Exception table:
    //   from	to	target	type
    //   0	15	156	java/lang/Exception
    //   15	154	159	java/lang/Exception
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.jdField_a_of_type_Long > 0L) {
        localJSONObject.put("medalid", this.jdField_a_of_type_Long);
      }
      if (this.jdField_a_of_type_Int > 0) {
        localJSONObject.put("mMedalType", this.jdField_a_of_type_Int);
      }
      if (this.jdField_b_of_type_Int > 0) {
        localJSONObject.put("mIsJump", this.jdField_b_of_type_Int);
      }
      if (this.jdField_c_of_type_Int > 0) {
        localJSONObject.put("mPicWidth", this.jdField_c_of_type_Int);
      }
      if (this.jdField_d_of_type_Int > 0) {
        localJSONObject.put("mPicHeight", this.jdField_d_of_type_Int);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localJSONObject.put("medal_name", this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("medal_url")) {
        localJSONObject.put("medal_url", this.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("mJumpUrl")) {
        localJSONObject.put("mJumpUrl", this.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("medal_scene")) {
        localJSONObject.put("medal_scene", this.e);
      }
      if (!TextUtils.isEmpty("medal_pos")) {
        localJSONObject.put("medal_pos", this.f);
      }
      if (!TextUtils.isEmpty("channelid")) {
        localJSONObject.put("channelid", this.jdField_d_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty("feedsid")) {
        localJSONObject.put("feedsid", this.g);
      }
      if (!TextUtils.isEmpty("medal_uin")) {
        localJSONObject.put("medal_uin", this.h);
      }
    }
    catch (Exception localException)
    {
      label254:
      break label254;
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxe
 * JD-Core Version:    0.7.0.1
 */