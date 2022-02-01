package com.tencent.mobileqq.config.business.qvip;

public class QVipQidConfig
{
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public QVipQidConfig()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/qid/mine?_wv=16777218&_proxy=1";
    this.jdField_b_of_type_JavaLangString = "https://club.vip.qq.com/qid/card?wv=16781315&_proxy=1";
  }
  
  /* Error */
  public static QVipQidConfig a(String paramString)
  {
    // Byte code:
    //   0: new 2	com/tencent/mobileqq/config/business/qvip/QVipQidConfig
    //   3: dup
    //   4: invokespecial 31	com/tencent/mobileqq/config/business/qvip/QVipQidConfig:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +19 -> 31
    //   15: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +11 -> 29
    //   21: ldc 45
    //   23: iconst_2
    //   24: ldc 47
    //   26: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_3
    //   30: areturn
    //   31: new 53	org/json/JSONObject
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 56	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_3
    //   41: aload_0
    //   42: ldc 58
    //   44: iconst_0
    //   45: invokevirtual 62	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   48: putfield 14	com/tencent/mobileqq/config/business/qvip/QVipQidConfig:jdField_a_of_type_Boolean	Z
    //   51: aload_3
    //   52: aload_0
    //   53: ldc 64
    //   55: ldc 18
    //   57: invokevirtual 68	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: putfield 20	com/tencent/mobileqq/config/business/qvip/QVipQidConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: ldc 70
    //   67: ldc 22
    //   69: invokevirtual 68	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: putfield 24	com/tencent/mobileqq/config/business/qvip/QVipQidConfig:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   75: aload_0
    //   76: astore_2
    //   77: aload_3
    //   78: aload_2
    //   79: ldc 72
    //   81: iconst_1
    //   82: invokevirtual 62	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   85: putfield 16	com/tencent/mobileqq/config/business/qvip/QVipQidConfig:jdField_b_of_type_Boolean	Z
    //   88: aload_3
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   95: aload_3
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: astore_2
    //   102: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq -28 -> 77
    //   108: ldc 45
    //   110: iconst_2
    //   111: new 77	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   118: ldc 80
    //   120: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aload_0
    //   134: astore_2
    //   135: goto -58 -> 77
    //   138: astore_1
    //   139: goto -39 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    //   97	27	1	localJSONException1	org.json.JSONException
    //   138	1	1	localJSONException2	org.json.JSONException
    //   76	59	2	str	String
    //   7	89	3	localQVipQidConfig	QVipQidConfig
    // Exception table:
    //   from	to	target	type
    //   77	88	90	java/lang/Exception
    //   31	40	97	org/json/JSONException
    //   40	75	138	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipQidConfig
 * JD-Core Version:    0.7.0.1
 */