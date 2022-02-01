package com.tencent.qqprotect.qsec;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;

public class CrashProtector
{
  private static String jdField_a_of_type_JavaLangString = "CPSP";
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public CrashProtector(String paramString, long paramLong)
  {
    this.b = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(a());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    try
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove(this.b);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean a()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(a());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    try
    {
      long l3 = ((SharedPreferences)localObject).getLong(this.b, 0L);
      long l1 = new Date().getTime();
      long l2 = l1 - l3;
      if (l3 != 0L)
      {
        l3 = this.jdField_a_of_type_Long;
        if ((l2 < l3) && (l2 > 0L)) {
          try
          {
            this.jdField_a_of_type_Boolean = false;
            return true;
          }
          catch (Exception localException1) {}
        }
      }
      SharedPreferences.Editor localEditor = localException1.edit();
      localEditor.putLong(this.b, l1);
      localEditor.commit();
      return false;
    }
    catch (Exception localException2)
    {
      bool = false;
      localException2.printStackTrace();
    }
    return bool;
  }
  
  /* Error */
  public String a()
  {
    // Byte code:
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 91
    //   11: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: invokestatic 97	android/os/Process:myPid	()I
    //   19: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: ldc 102
    //   26: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: new 104	java/io/File
    //   33: dup
    //   34: aload_2
    //   35: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 110	java/io/File:exists	()Z
    //   46: istore_1
    //   47: ldc 112
    //   49: astore 7
    //   51: iload_1
    //   52: ifne +6 -> 58
    //   55: ldc 112
    //   57: areturn
    //   58: aconst_null
    //   59: astore 9
    //   61: aconst_null
    //   62: astore 8
    //   64: aconst_null
    //   65: astore 4
    //   67: aconst_null
    //   68: astore_2
    //   69: new 114	java/io/FileReader
    //   72: dup
    //   73: aload_3
    //   74: invokespecial 117	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   77: astore_3
    //   78: new 119	java/io/BufferedReader
    //   81: dup
    //   82: aload_3
    //   83: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore 6
    //   88: aload 6
    //   90: astore 5
    //   92: aload_3
    //   93: astore 4
    //   95: aload 6
    //   97: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   100: astore 10
    //   102: aload 6
    //   104: astore 5
    //   106: aload_3
    //   107: astore 4
    //   109: aload 10
    //   111: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +16 -> 130
    //   117: aload 6
    //   119: astore 5
    //   121: aload_3
    //   122: astore 4
    //   124: aload 10
    //   126: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   129: astore_2
    //   130: aload_3
    //   131: invokevirtual 139	java/io/FileReader:close	()V
    //   134: goto +8 -> 142
    //   137: astore_3
    //   138: aload_3
    //   139: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   142: aload_2
    //   143: astore_3
    //   144: aload 6
    //   146: ifnull +102 -> 248
    //   149: aload_2
    //   150: astore_3
    //   151: aload 6
    //   153: invokevirtual 141	java/io/BufferedReader:close	()V
    //   156: aload_2
    //   157: astore_3
    //   158: goto +90 -> 248
    //   161: astore_2
    //   162: aload_2
    //   163: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   166: goto +82 -> 248
    //   169: astore 4
    //   171: aload 6
    //   173: astore_2
    //   174: aload 4
    //   176: astore 6
    //   178: goto +26 -> 204
    //   181: astore_2
    //   182: goto +109 -> 291
    //   185: astore 6
    //   187: aconst_null
    //   188: astore_2
    //   189: goto +15 -> 204
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_3
    //   195: goto +96 -> 291
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_2
    //   202: aload_2
    //   203: astore_3
    //   204: aload_2
    //   205: astore 5
    //   207: aload_3
    //   208: astore 4
    //   210: aload 6
    //   212: invokevirtual 72	java/lang/Exception:printStackTrace	()V
    //   215: aload_3
    //   216: ifnull +15 -> 231
    //   219: aload_3
    //   220: invokevirtual 139	java/io/FileReader:close	()V
    //   223: goto +8 -> 231
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   231: aload 8
    //   233: astore_3
    //   234: aload_2
    //   235: ifnull +13 -> 248
    //   238: aload 9
    //   240: astore_3
    //   241: aload_2
    //   242: invokevirtual 141	java/io/BufferedReader:close	()V
    //   245: aload 8
    //   247: astore_3
    //   248: aload 7
    //   250: astore_2
    //   251: aload_3
    //   252: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne +26 -> 281
    //   258: aload_3
    //   259: ldc 143
    //   261: invokevirtual 147	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   264: astore_3
    //   265: aload 7
    //   267: astore_2
    //   268: aload_3
    //   269: arraylength
    //   270: iconst_1
    //   271: if_icmple +10 -> 281
    //   274: aload_3
    //   275: aload_3
    //   276: arraylength
    //   277: iconst_1
    //   278: isub
    //   279: aaload
    //   280: astore_2
    //   281: aload_2
    //   282: areturn
    //   283: astore_2
    //   284: aload 4
    //   286: astore_3
    //   287: aload 5
    //   289: astore 4
    //   291: aload_3
    //   292: ifnull +15 -> 307
    //   295: aload_3
    //   296: invokevirtual 139	java/io/FileReader:close	()V
    //   299: goto +8 -> 307
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   307: aload 4
    //   309: ifnull +16 -> 325
    //   312: aload 4
    //   314: invokevirtual 141	java/io/BufferedReader:close	()V
    //   317: goto +8 -> 325
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   325: aload_2
    //   326: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	CrashProtector
    //   46	6	1	bool	boolean
    //   7	150	2	localObject1	Object
    //   161	2	2	localIOException1	java.io.IOException
    //   173	1	2	localObject2	Object
    //   181	1	2	localObject3	Object
    //   188	1	2	localObject4	Object
    //   192	1	2	localObject5	Object
    //   201	81	2	localObject6	Object
    //   283	43	2	localObject7	Object
    //   41	90	3	localObject8	Object
    //   137	2	3	localIOException2	java.io.IOException
    //   143	77	3	localObject9	Object
    //   226	2	3	localIOException3	java.io.IOException
    //   233	63	3	localObject10	Object
    //   302	2	3	localIOException4	java.io.IOException
    //   320	2	3	localIOException5	java.io.IOException
    //   65	58	4	localObject11	Object
    //   169	6	4	localException1	Exception
    //   208	105	4	localObject12	Object
    //   90	198	5	localObject13	Object
    //   86	91	6	localObject14	Object
    //   185	1	6	localException2	Exception
    //   198	13	6	localException3	Exception
    //   49	217	7	str1	String
    //   62	184	8	localObject15	Object
    //   59	180	9	localObject16	Object
    //   100	25	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   130	134	137	java/io/IOException
    //   151	156	161	java/io/IOException
    //   241	245	161	java/io/IOException
    //   95	102	169	java/lang/Exception
    //   109	117	169	java/lang/Exception
    //   124	130	169	java/lang/Exception
    //   78	88	181	finally
    //   78	88	185	java/lang/Exception
    //   69	78	192	finally
    //   69	78	198	java/lang/Exception
    //   219	223	226	java/io/IOException
    //   95	102	283	finally
    //   109	117	283	finally
    //   124	130	283	finally
    //   210	215	283	finally
    //   295	299	302	java/io/IOException
    //   312	317	320	java/io/IOException
  }
  
  public void a(CrashProtector.IProtectedMethod paramIProtectedMethod)
  {
    if (paramIProtectedMethod != null)
    {
      if (!a()) {
        paramIProtectedMethod.a();
      } else {
        paramIProtectedMethod.b();
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CrashProtector
 * JD-Core Version:    0.7.0.1
 */