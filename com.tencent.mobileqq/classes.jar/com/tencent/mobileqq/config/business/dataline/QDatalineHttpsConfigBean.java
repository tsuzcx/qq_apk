package com.tencent.mobileqq.config.business.dataline;

import com.tencent.mobileqq.filemanager.api.util.IQStorageSafable;

public class QDatalineHttpsConfigBean
  implements IQStorageSafable<String>
{
  public String a;
  public boolean a;
  public boolean b = false;
  
  public QDatalineHttpsConfigBean()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +12 -> 16
    //   7: ldc 40
    //   9: iconst_1
    //   10: ldc 42
    //   12: invokestatic 48	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: putfield 23	com/tencent/mobileqq/config/business/dataline/QDatalineHttpsConfigBean:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: new 50	org/json/JSONObject
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 52	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: ldc 54
    //   33: invokevirtual 58	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +47 -> 85
    //   41: aload_0
    //   42: aload_2
    //   43: ldc 60
    //   45: invokevirtual 64	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   48: putfield 17	com/tencent/mobileqq/config/business/dataline/QDatalineHttpsConfigBean:jdField_a_of_type_Boolean	Z
    //   51: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +31 -> 85
    //   57: ldc 40
    //   59: iconst_2
    //   60: new 70	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   67: ldc 73
    //   69: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: getfield 17	com/tencent/mobileqq/config/business/dataline/QDatalineHttpsConfigBean:jdField_a_of_type_Boolean	Z
    //   76: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: aload_1
    //   86: ldc 89
    //   88: invokevirtual 58	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull -78 -> 15
    //   96: aload_0
    //   97: aload_1
    //   98: ldc 60
    //   100: invokevirtual 64	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   103: putfield 19	com/tencent/mobileqq/config/business/dataline/QDatalineHttpsConfigBean:b	Z
    //   106: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq -94 -> 15
    //   112: ldc 40
    //   114: iconst_2
    //   115: new 70	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   122: ldc 91
    //   124: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: getfield 19	com/tencent/mobileqq/config/business/dataline/QDatalineHttpsConfigBean:b	Z
    //   131: invokevirtual 80	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: return
    //   141: astore_1
    //   142: ldc 40
    //   144: iconst_1
    //   145: aload_1
    //   146: iconst_0
    //   147: anewarray 5	java/lang/Object
    //   150: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   153: return
    //   154: astore_1
    //   155: ldc 40
    //   157: iconst_1
    //   158: aload_1
    //   159: iconst_0
    //   160: anewarray 5	java/lang/Object
    //   163: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   166: return
    //   167: astore_2
    //   168: ldc 40
    //   170: iconst_1
    //   171: aload_2
    //   172: iconst_0
    //   173: anewarray 5	java/lang/Object
    //   176: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   179: goto -94 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	QDatalineHttpsConfigBean
    //   0	182	1	paramString	String
    //   36	7	2	localJSONObject	org.json.JSONObject
    //   167	5	2	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   96	140	141	org/json/JSONException
    //   21	37	154	org/json/JSONException
    //   85	92	154	org/json/JSONException
    //   142	153	154	org/json/JSONException
    //   168	179	154	org/json/JSONException
    //   41	85	167	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.dataline.QDatalineHttpsConfigBean
 * JD-Core Version:    0.7.0.1
 */