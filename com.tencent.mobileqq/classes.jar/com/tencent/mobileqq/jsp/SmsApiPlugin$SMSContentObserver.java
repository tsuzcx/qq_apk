package com.tencent.mobileqq.jsp;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;

public class SmsApiPlugin$SMSContentObserver
  extends ContentObserver
{
  protected Context a;
  protected Handler a;
  protected String a;
  protected String b;
  
  public SmsApiPlugin$SMSContentObserver(Handler paramHandler, Context paramContext, String paramString1, String paramString2)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  protected void a(Cursor paramCursor)
  {
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor) {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  public void onChange(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 45	android/database/ContentObserver:onChange	(Z)V
    //   5: aload_0
    //   6: getfield 24	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   9: ifnull +383 -> 392
    //   12: aload_0
    //   13: getfield 16	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: ldc 47
    //   22: invokestatic 53	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: astore_3
    //   26: aconst_null
    //   27: astore_2
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 24	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   38: invokevirtual 57	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: aload_3
    //   42: iconst_3
    //   43: anewarray 59	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 61
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc 63
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: ldc 65
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: ldc 67
    //   65: invokevirtual 73	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +268 -> 338
    //   73: aload_3
    //   74: invokeinterface 77 1 0
    //   79: ifeq +259 -> 338
    //   82: aload_3
    //   83: aload_3
    //   84: ldc 63
    //   86: invokeinterface 81 2 0
    //   91: invokeinterface 85 2 0
    //   96: astore_2
    //   97: aload_0
    //   98: getfield 26	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   101: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +57 -> 161
    //   107: aload_2
    //   108: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifeq +18 -> 129
    //   114: aload_0
    //   115: aload_3
    //   116: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   119: aload_3
    //   120: ifnull +8 -> 128
    //   123: aload_0
    //   124: aload_3
    //   125: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   128: return
    //   129: aload_0
    //   130: getfield 26	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   133: invokestatic 99	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   136: aload_2
    //   137: invokevirtual 103	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   140: invokevirtual 108	java/util/regex/Matcher:matches	()Z
    //   143: ifne +18 -> 161
    //   146: aload_0
    //   147: aload_3
    //   148: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   151: aload_3
    //   152: ifnull +8 -> 160
    //   155: aload_0
    //   156: aload_3
    //   157: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   160: return
    //   161: aload_0
    //   162: getfield 28	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:b	Ljava/lang/String;
    //   165: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +18 -> 186
    //   171: aload_0
    //   172: aload_3
    //   173: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   176: aload_3
    //   177: ifnull +8 -> 185
    //   180: aload_0
    //   181: aload_3
    //   182: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   185: return
    //   186: aload_3
    //   187: aload_3
    //   188: ldc 65
    //   190: invokeinterface 81 2 0
    //   195: invokeinterface 85 2 0
    //   200: astore 5
    //   202: aload 5
    //   204: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   207: ifne +131 -> 338
    //   210: aload_0
    //   211: getfield 28	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:b	Ljava/lang/String;
    //   214: invokestatic 99	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   217: aload 5
    //   219: invokevirtual 103	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   222: astore 5
    //   224: aload 5
    //   226: invokevirtual 111	java/util/regex/Matcher:find	()Z
    //   229: ifne +18 -> 247
    //   232: aload_0
    //   233: aload_3
    //   234: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   237: aload_3
    //   238: ifnull +8 -> 246
    //   241: aload_0
    //   242: aload_3
    //   243: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   246: return
    //   247: aload 5
    //   249: invokevirtual 115	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   252: astore 5
    //   254: aload 5
    //   256: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   259: istore_1
    //   260: iload_1
    //   261: ifne +77 -> 338
    //   264: new 117	org/json/JSONObject
    //   267: dup
    //   268: invokespecial 119	org/json/JSONObject:<init>	()V
    //   271: astore 6
    //   273: aload 6
    //   275: ldc 121
    //   277: aload_2
    //   278: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload 6
    //   284: ldc 127
    //   286: aload 5
    //   288: invokevirtual 125	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload 6
    //   294: invokevirtual 130	org/json/JSONObject:toString	()Ljava/lang/String;
    //   297: astore_2
    //   298: goto +11 -> 309
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 133	org/json/JSONException:printStackTrace	()V
    //   306: aload 4
    //   308: astore_2
    //   309: aload_2
    //   310: invokestatic 91	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   313: ifne +25 -> 338
    //   316: aload_0
    //   317: getfield 16	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   320: iconst_1
    //   321: aload_2
    //   322: invokevirtual 139	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   325: invokevirtual 144	android/os/Message:sendToTarget	()V
    //   328: goto +10 -> 338
    //   331: astore_2
    //   332: goto +40 -> 372
    //   335: goto +23 -> 358
    //   338: aload_3
    //   339: ifnull +53 -> 392
    //   342: aload_0
    //   343: aload_3
    //   344: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   347: return
    //   348: astore 4
    //   350: aload_2
    //   351: astore_3
    //   352: aload 4
    //   354: astore_2
    //   355: goto +17 -> 372
    //   358: aload_3
    //   359: ifnull +24 -> 383
    //   362: aload_3
    //   363: astore_2
    //   364: aload_0
    //   365: aload_3
    //   366: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   369: goto +14 -> 383
    //   372: aload_3
    //   373: ifnull +8 -> 381
    //   376: aload_0
    //   377: aload_3
    //   378: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   381: aload_2
    //   382: athrow
    //   383: aload_3
    //   384: ifnull +8 -> 392
    //   387: aload_0
    //   388: aload_3
    //   389: invokevirtual 93	com/tencent/mobileqq/jsp/SmsApiPlugin$SMSContentObserver:a	(Landroid/database/Cursor;)V
    //   392: return
    //   393: astore_2
    //   394: aload 5
    //   396: astore_3
    //   397: goto -39 -> 358
    //   400: astore_2
    //   401: goto -66 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	404	0	this	SMSContentObserver
    //   0	404	1	paramBoolean	boolean
    //   27	271	2	str	String
    //   301	2	2	localJSONException	org.json.JSONException
    //   308	14	2	localObject1	java.lang.Object
    //   331	20	2	localObject2	java.lang.Object
    //   354	28	2	localObject3	java.lang.Object
    //   393	1	2	localException1	Exception
    //   400	1	2	localException2	Exception
    //   25	372	3	localObject4	java.lang.Object
    //   32	275	4	localObject5	java.lang.Object
    //   348	5	4	localObject6	java.lang.Object
    //   29	366	5	localObject7	java.lang.Object
    //   271	22	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   264	298	301	org/json/JSONException
    //   73	119	331	finally
    //   129	151	331	finally
    //   161	176	331	finally
    //   186	237	331	finally
    //   247	260	331	finally
    //   264	298	331	finally
    //   302	306	331	finally
    //   309	328	331	finally
    //   34	69	348	finally
    //   364	369	348	finally
    //   34	69	393	java/lang/Exception
    //   73	119	400	java/lang/Exception
    //   129	151	400	java/lang/Exception
    //   161	176	400	java/lang/Exception
    //   186	237	400	java/lang/Exception
    //   247	260	400	java/lang/Exception
    //   264	298	400	java/lang/Exception
    //   302	306	400	java/lang/Exception
    //   309	328	400	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.SmsApiPlugin.SMSContentObserver
 * JD-Core Version:    0.7.0.1
 */