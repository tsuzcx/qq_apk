package com.tencent.mobileqq.richmedia.capture.data;

import java.io.File;

public class FilterDesc
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  
  public FilterDesc() {}
  
  public FilterDesc(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Int = paramInt4;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Int = paramInt3;
  }
  
  public FilterDesc(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_d_of_type_JavaLangString = paramString4;
    this.jdField_e_of_type_JavaLangString = paramString5;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
  }
  
  /* Error */
  public static java.util.ArrayList a(org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: new 47	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 48	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: aload_0
    //   13: invokevirtual 54	org/json/JSONArray:length	()I
    //   16: if_icmpge +282 -> 298
    //   19: aload_0
    //   20: iload_1
    //   21: invokevirtual 58	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   24: astore 10
    //   26: aload 10
    //   28: ldc 60
    //   30: invokevirtual 66	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   33: ifeq +285 -> 318
    //   36: aload 10
    //   38: ldc 60
    //   40: invokevirtual 70	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokestatic 76	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   46: invokevirtual 79	java/lang/Integer:intValue	()I
    //   49: istore_2
    //   50: aload 10
    //   52: ldc 81
    //   54: invokevirtual 66	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   57: ifeq +218 -> 275
    //   60: aload 10
    //   62: ldc 81
    //   64: invokevirtual 70	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 76	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   70: invokevirtual 79	java/lang/Integer:intValue	()I
    //   73: istore_3
    //   74: aload 10
    //   76: ldc 83
    //   78: invokevirtual 66	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   81: ifeq +231 -> 312
    //   84: aload 10
    //   86: ldc 83
    //   88: ldc 85
    //   90: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 76	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   96: invokevirtual 79	java/lang/Integer:intValue	()I
    //   99: istore 4
    //   101: aload 10
    //   103: ldc 91
    //   105: ldc 93
    //   107: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 6
    //   112: aload 10
    //   114: ldc 95
    //   116: ldc 93
    //   118: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 7
    //   123: aload 10
    //   125: ldc 97
    //   127: invokevirtual 66	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   130: ifeq +25 -> 155
    //   133: aload 10
    //   135: ldc 97
    //   137: ldc 93
    //   139: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   142: astore 6
    //   144: aload 10
    //   146: ldc 99
    //   148: ldc 93
    //   150: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 7
    //   155: aload 10
    //   157: ldc 101
    //   159: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 11
    //   164: aload 10
    //   166: ldc 105
    //   168: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: astore 12
    //   173: aload 10
    //   175: ldc 107
    //   177: invokevirtual 103	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   180: astore 5
    //   182: aload 10
    //   184: ldc 109
    //   186: invokevirtual 66	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   189: ifeq +14 -> 203
    //   192: aload 10
    //   194: ldc 109
    //   196: ldc 93
    //   198: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   201: astore 5
    //   203: aload 10
    //   205: ldc 111
    //   207: ldc 93
    //   209: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 8
    //   214: aload 8
    //   216: invokestatic 117	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +90 -> 309
    //   222: aload 5
    //   224: astore 8
    //   226: new 2	com/tencent/mobileqq/richmedia/capture/data/FilterDesc
    //   229: dup
    //   230: iload_2
    //   231: iload 4
    //   233: aload 6
    //   235: aload 7
    //   237: aload 11
    //   239: aload 12
    //   241: aload 5
    //   243: iload_3
    //   244: aload 10
    //   246: ldc 119
    //   248: iconst_0
    //   249: invokevirtual 123	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   252: invokespecial 125	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:<init>	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V
    //   255: astore 5
    //   257: aload 5
    //   259: aload 8
    //   261: putfield 127	com/tencent/mobileqq/richmedia/capture/data/FilterDesc:f	Ljava/lang/String;
    //   264: aload 9
    //   266: aload 5
    //   268: invokevirtual 131	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   271: pop
    //   272: goto +51 -> 323
    //   275: iload_2
    //   276: invokestatic 136	com/tencent/av/opengl/filter/qqavimage/QQAVImageFilterConstants:a	(I)I
    //   279: istore_3
    //   280: goto -206 -> 74
    //   283: astore 5
    //   285: aload 5
    //   287: invokevirtual 139	org/json/JSONException:printStackTrace	()V
    //   290: goto +33 -> 323
    //   293: astore_0
    //   294: aload_0
    //   295: invokevirtual 139	org/json/JSONException:printStackTrace	()V
    //   298: aload 9
    //   300: areturn
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   306: aload 9
    //   308: areturn
    //   309: goto -83 -> 226
    //   312: iconst_0
    //   313: istore 4
    //   315: goto -214 -> 101
    //   318: iconst_0
    //   319: istore_2
    //   320: goto -270 -> 50
    //   323: iload_1
    //   324: iconst_1
    //   325: iadd
    //   326: istore_1
    //   327: goto -316 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramJSONArray	org.json.JSONArray
    //   10	317	1	i	int
    //   49	271	2	j	int
    //   73	207	3	k	int
    //   99	215	4	m	int
    //   180	87	5	localObject1	Object
    //   283	3	5	localJSONException	org.json.JSONException
    //   110	124	6	str1	String
    //   121	115	7	str2	String
    //   212	48	8	localObject2	Object
    //   7	300	9	localArrayList	java.util.ArrayList
    //   24	221	10	localJSONObject	org.json.JSONObject
    //   162	76	11	str3	String
    //   171	69	12	str4	String
    // Exception table:
    //   from	to	target	type
    //   26	50	283	org/json/JSONException
    //   50	74	283	org/json/JSONException
    //   74	101	283	org/json/JSONException
    //   101	123	283	org/json/JSONException
    //   123	155	283	org/json/JSONException
    //   155	182	283	org/json/JSONException
    //   182	203	283	org/json/JSONException
    //   203	222	283	org/json/JSONException
    //   226	272	283	org/json/JSONException
    //   275	280	283	org/json/JSONException
    //   11	26	293	org/json/JSONException
    //   285	290	293	org/json/JSONException
    //   11	26	301	java/lang/Exception
    //   26	50	301	java/lang/Exception
    //   50	74	301	java/lang/Exception
    //   74	101	301	java/lang/Exception
    //   101	123	301	java/lang/Exception
    //   123	155	301	java/lang/Exception
    //   155	182	301	java/lang/Exception
    //   182	203	301	java/lang/Exception
    //   203	222	301	java/lang/Exception
    //   226	272	301	java/lang/Exception
    //   275	280	301	java/lang/Exception
    //   285	290	301	java/lang/Exception
  }
  
  public String a(String paramString)
  {
    return paramString + this.jdField_e_of_type_JavaLangString + ".png";
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == -1) || (this.jdField_b_of_type_Int == 0);
  }
  
  public String b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.equals(""))) {
      return "";
    }
    String str = c(this.jdField_a_of_type_JavaLangString);
    return paramString + str + File.separator;
  }
  
  public String c(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.FilterDesc
 * JD-Core Version:    0.7.0.1
 */