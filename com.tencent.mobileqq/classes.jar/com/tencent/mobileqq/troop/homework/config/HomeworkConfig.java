package com.tencent.mobileqq.troop.homework.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.troop.CommonConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeworkConfig
  extends CommonConfigBase
{
  public HomeworkConfig.HomeWorkGuideInfo a;
  public boolean a;
  public HomeworkConfig.HomeWorkGuideInfo b;
  public String b;
  public boolean b;
  public HomeworkConfig.HomeWorkGuideInfo c;
  public String c;
  public HomeworkConfig.HomeWorkGuideInfo d;
  public String d;
  public String e;
  
  public HomeworkConfig(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  /* Error */
  public static HomeworkConfig.HomeWorkGuideInfo a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 30	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokestatic 38	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne -19 -> 14
    //   36: new 40	org/json/JSONObject
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: new 45	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   53: aload_0
    //   54: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 54
    //   59: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_0
    //   66: aload 4
    //   68: ifnull -54 -> 14
    //   71: new 60	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo
    //   74: dup
    //   75: invokespecial 61	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo:<init>	()V
    //   78: astore_1
    //   79: aload 4
    //   81: ldc 63
    //   83: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 5
    //   88: aload 5
    //   90: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +26 -> 119
    //   96: aload_1
    //   97: new 45	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   104: aload_0
    //   105: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 5
    //   110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: putfield 69	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   119: aload 4
    //   121: ldc 71
    //   123: invokevirtual 75	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   126: astore 4
    //   128: aload_1
    //   129: new 77	java/util/ArrayList
    //   132: dup
    //   133: invokespecial 78	java/util/ArrayList:<init>	()V
    //   136: putfield 81	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   139: iconst_0
    //   140: istore_2
    //   141: iload_2
    //   142: aload 4
    //   144: invokevirtual 87	org/json/JSONArray:length	()I
    //   147: if_icmpge +216 -> 363
    //   150: aload 4
    //   152: iload_2
    //   153: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   156: astore 5
    //   158: new 93	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo
    //   161: dup
    //   162: invokespecial 94	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:<init>	()V
    //   165: astore 6
    //   167: aload 5
    //   169: ldc 96
    //   171: iconst_0
    //   172: invokevirtual 100	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   175: iconst_1
    //   176: if_icmpne +177 -> 353
    //   179: iconst_1
    //   180: istore_3
    //   181: aload 6
    //   183: iload_3
    //   184: putfield 102	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:jdField_a_of_type_Boolean	Z
    //   187: aload 5
    //   189: ldc 104
    //   191: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 7
    //   196: aload 7
    //   198: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   201: ifne +27 -> 228
    //   204: aload 6
    //   206: new 45	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   213: aload_0
    //   214: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 7
    //   219: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: putfield 105	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: aload 5
    //   230: ldc 107
    //   232: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   235: astore 7
    //   237: aload 7
    //   239: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +27 -> 269
    //   245: aload 6
    //   247: new 45	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   254: aload_0
    //   255: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 7
    //   260: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: putfield 109	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   269: aload 5
    //   271: ldc 111
    //   273: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 7
    //   280: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   283: ifne +27 -> 310
    //   286: aload 6
    //   288: new 45	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   295: aload_0
    //   296: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 7
    //   301: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: putfield 113	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:c	Ljava/lang/String;
    //   310: aload 5
    //   312: ldc 115
    //   314: iconst_0
    //   315: invokevirtual 100	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   318: iconst_1
    //   319: if_icmpne +39 -> 358
    //   322: iconst_1
    //   323: istore_3
    //   324: aload 6
    //   326: iload_3
    //   327: putfield 117	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo$PageInfo:jdField_b_of_type_Boolean	Z
    //   330: aload_1
    //   331: getfield 81	com/tencent/mobileqq/troop/homework/config/HomeworkConfig$HomeWorkGuideInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   334: aload 6
    //   336: invokevirtual 121	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   339: pop
    //   340: iload_2
    //   341: iconst_1
    //   342: iadd
    //   343: istore_2
    //   344: goto -203 -> 141
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_1
    //   350: goto -321 -> 29
    //   353: iconst_0
    //   354: istore_3
    //   355: goto -174 -> 181
    //   358: iconst_0
    //   359: istore_3
    //   360: goto -36 -> 324
    //   363: aload_1
    //   364: areturn
    //   365: astore_0
    //   366: aconst_null
    //   367: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramString1	String
    //   0	368	1	paramString2	String
    //   140	204	2	i	int
    //   180	180	3	bool	boolean
    //   44	107	4	localObject1	java.lang.Object
    //   86	225	5	localObject2	java.lang.Object
    //   165	170	6	localPageInfo	HomeworkConfig.HomeWorkGuideInfo.PageInfo
    //   194	106	7	str	String
    // Exception table:
    //   from	to	target	type
    //   16	29	347	java/lang/Exception
    //   36	66	365	org/json/JSONException
    //   71	119	365	org/json/JSONException
    //   119	139	365	org/json/JSONException
    //   141	179	365	org/json/JSONException
    //   181	228	365	org/json/JSONException
    //   228	269	365	org/json/JSONException
    //   269	310	365	org/json/JSONException
    //   310	322	365	org/json/JSONException
    //   324	340	365	org/json/JSONException
  }
  
  public String a()
  {
    return "key_for_home_work_cfg";
  }
  
  public void a(String paramString)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONObject localJSONObject = paramString.optJSONObject("recite_work");
        if (localJSONObject != null)
        {
          if (localJSONObject.optInt("isenable", 0) != 1) {
            break label151;
          }
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          this.jdField_b_of_type_JavaLangString = localJSONObject.optString("publish_guide_resource_url");
          this.c = localJSONObject.optString("publish_guide_resource_md5");
        }
        paramString = paramString.optJSONObject("arithmetic_work");
        if (paramString == null) {
          break;
        }
        if (paramString.optInt("isenable", 0) != 1) {
          break label156;
        }
        bool1 = bool2;
        this.jdField_b_of_type_Boolean = bool1;
        this.d = paramString.optString("publish_guide_resource_url");
        this.e = paramString.optString("publish_guide_resource_md5");
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("read HomeworkConfig", 2, paramString.getMessage());
      return;
      label151:
      boolean bool1 = false;
      continue;
      label156:
      bool1 = false;
    }
  }
  
  public String b()
  {
    return "key_for_home_work_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.HomeworkConfig
 * JD-Core Version:    0.7.0.1
 */