package com.tencent.mobileqq.business.sougou;

import ajsf;
import amda;
import amdd;
import amde;
import amdf;
import amdi;
import amdj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import bahn;
import baho;
import bbuv;
import bfjx;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.manager.TicketManager;

public class WordMatchManager
  implements Manager
{
  protected static final String a;
  protected amde a;
  protected amdf a;
  protected amdj a;
  protected baho a;
  protected QQAppInterface a;
  protected ArrayList<amdi> a;
  boolean a;
  protected amde b;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  boolean e = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = bbuv.a(ajsf.aV + "/Tencent/QQ_business");
  }
  
  public WordMatchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Amdj = new WordMatchManager.HotWordMatcher(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Amdf = new amdf();
    this.jdField_a_of_type_Amde = new amde();
    this.jdField_b_of_type_Amde = new amde();
    this.jdField_a_of_type_Baho = new amdd(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.getApp();
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
      }
    }
    catch (UnsatisfiedLinkError paramQQAppInterface)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_Boolean = SoLoadUtil.a(BaseApplicationImpl.getContext(), "Matcher", 0, false);
          return;
        }
        catch (UnsatisfiedLinkError paramQQAppInterface)
        {
          this.jdField_a_of_type_Boolean = false;
          paramQQAppInterface.printStackTrace();
        }
        paramQQAppInterface = paramQQAppInterface;
        QLog.e(".business.sougou.DicFileDownloader", 2, "load stl failed!", paramQQAppInterface);
      }
    }
  }
  
  private String a(String paramString)
  {
    System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break label56;
        }
        try
        {
          String str2 = bfjx.a(paramString);
          paramString = str2;
          if (str2 != null) {
            continue;
          }
          return "";
        }
        catch (IOException paramString)
        {
          return "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return paramString;
    label56:
    return "";
  }
  
  protected long a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getLong("DICT_LAST_MODIFIED_" + paramInt, 0L);
  }
  
  public amdj a(amdi paramamdi)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    if (this.c) {
      return this.jdField_a_of_type_Amdj;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.1(this, paramamdi));
    return null;
  }
  
  protected String a(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return str + File.separator + "small";
    case 2: 
      return str + File.separator + "big";
    case 3: 
      return str + File.separator + "dict.xdb";
    }
    return str + File.separator + "rules.ini";
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Amdf.jdField_a_of_type_Boolean = a(2);
    this.jdField_a_of_type_Amdf.jdField_b_of_type_Boolean = a(1);
    amdf localamdf = this.jdField_a_of_type_Amdf;
    if ((a(3)) && (a(4))) {}
    for (boolean bool = true;; bool = false)
    {
      localamdf.c = bool;
      if (this.jdField_a_of_type_Amdf.jdField_a_of_type_Boolean) {
        b(2);
      }
      if (this.jdField_a_of_type_Amdf.jdField_b_of_type_Boolean) {
        b(1);
      }
      return;
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.5(this, paramInt));
  }
  
  protected void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).edit().putLong("DICT_LAST_MODIFIED_" + paramInt, paramLong).commit();
  }
  
  public void a(amde paramamde)
  {
    if (paramamde.jdField_b_of_type_Int != 1)
    {
      a(paramamde.jdField_a_of_type_Int);
      return;
    }
    if (paramamde.jdField_a_of_type_Int == 2) {
      this.jdField_b_of_type_Amde = paramamde;
    }
    for (;;)
    {
      ThreadManager.post(new WordMatchManager.TaskHttpDownload(this, paramamde.jdField_a_of_type_Int), 8, null, true);
      return;
      if (paramamde.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Amde = paramamde;
      }
    }
  }
  
  public void a(amdi paramamdi)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.2(this, paramamdi));
  }
  
  protected void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi begin| type:" + paramInt + ",time:" + System.currentTimeMillis());
    }
    Object localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    localObject2 = ((TicketManager)localObject2).getSkey(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putString("type", "" + paramInt);
    paramQQAppInterface.putString("id", c(paramInt));
    paramQQAppInterface.putString("md5", "" + d(paramInt));
    paramQQAppInterface.putString("version", "8.2.8");
    paramQQAppInterface.putString("platform", "android");
    paramQQAppInterface.putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + (String)localObject2);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", paramQQAppInterface);
    ((HashMap)localObject1).put("CONTEXT", BaseApplication.getContext());
    new bahn("http://cgi.qqweb.qq.com/cgi-bin/frequency/whether_request_cdn", "POST", this.jdField_a_of_type_Baho, paramInt, null, true).execute(new HashMap[] { localObject1 });
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.post(new WordMatchManager.3(this, paramBoolean), 5, null, true);
    if (QLog.isDevelopLevel()) {
      QLog.d(".business.sougou.DicFileDownloader", 4, "handleUpdateCompleted:" + paramBoolean);
    }
  }
  
  protected boolean a(int paramInt)
  {
    String str = a(paramInt);
    if (!new File(str).exists()) {
      return false;
    }
    return e(paramInt).equalsIgnoreCase(amda.a(str));
  }
  
  protected String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/small.gz";
    case 2: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/big.gz";
    case 3: 
      return "http://pub.idqqimg.com/pc/qqclient/sfile/wsdict.gz";
    }
    return "http://pub.idqqimg.com/pc/qqclient/sfile/srule.gz";
  }
  
  protected void b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    long l1 = localSharedPreferences.getLong("DICT_LAST_REQUEST_TIME", 0L);
    long l2 = System.currentTimeMillis() / 1000L;
    if ((this.jdField_b_of_type_Boolean) && (l2 - l1 < 86400L))
    {
      a(true);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localSharedPreferences.edit().putLong("DICT_LAST_REQUEST_TIME", l2).commit();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
  }
  
  /* Error */
  protected void b(int paramInt)
  {
    // Byte code:
    //   0: new 147	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 354	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   9: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 9
    //   14: iconst_4
    //   15: newarray byte
    //   17: astore 10
    //   19: new 390	java/io/FileInputStream
    //   22: dup
    //   23: aload 9
    //   25: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore 8
    //   30: aload 8
    //   32: astore 7
    //   34: aload 8
    //   36: aload 10
    //   38: invokevirtual 399	java/io/InputStream:read	([B)I
    //   41: pop
    //   42: aload 8
    //   44: astore 7
    //   46: aload 8
    //   48: aload 10
    //   50: invokevirtual 399	java/io/InputStream:read	([B)I
    //   53: pop
    //   54: aload 8
    //   56: astore 7
    //   58: aload 10
    //   60: invokestatic 401	amda:a	([B)I
    //   63: istore_1
    //   64: iload_1
    //   65: iconst_4
    //   66: iadd
    //   67: i2l
    //   68: lstore_3
    //   69: aload 8
    //   71: astore 7
    //   73: aload 9
    //   75: invokevirtual 404	java/io/File:length	()J
    //   78: lstore 5
    //   80: lload_3
    //   81: lload 5
    //   83: lcmp
    //   84: ifle +22 -> 106
    //   87: aload 8
    //   89: ifnull +8 -> 97
    //   92: aload 8
    //   94: invokevirtual 407	java/io/InputStream:close	()V
    //   97: return
    //   98: astore 7
    //   100: aload 7
    //   102: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: aload 8
    //   108: astore 7
    //   110: iload_1
    //   111: newarray byte
    //   113: astore 9
    //   115: aload 8
    //   117: astore 7
    //   119: aload 8
    //   121: aload 9
    //   123: invokevirtual 399	java/io/InputStream:read	([B)I
    //   126: pop
    //   127: aload 8
    //   129: astore 7
    //   131: new 361	java/lang/String
    //   134: dup
    //   135: aload 9
    //   137: invokespecial 411	java/lang/String:<init>	([B)V
    //   140: astore 9
    //   142: aload 9
    //   144: astore 7
    //   146: aload 8
    //   148: ifnull +12 -> 160
    //   151: aload 8
    //   153: invokevirtual 407	java/io/InputStream:close	()V
    //   156: aload 9
    //   158: astore 7
    //   160: new 413	org/json/JSONObject
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 414	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   169: ldc_w 416
    //   172: invokevirtual 420	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   175: astore 7
    //   177: iconst_0
    //   178: istore_1
    //   179: iload_1
    //   180: aload 7
    //   182: invokevirtual 425	org/json/JSONArray:length	()I
    //   185: if_icmpge -88 -> 97
    //   188: aload 7
    //   190: iload_1
    //   191: invokevirtual 429	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   194: astore 8
    //   196: aload 8
    //   198: ldc_w 431
    //   201: invokevirtual 434	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: ldc_w 436
    //   207: invokevirtual 365	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   210: ifeq +29 -> 239
    //   213: aload 8
    //   215: ldc_w 438
    //   218: invokevirtual 442	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   221: istore_2
    //   222: aload_0
    //   223: getfield 73	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_Amdf	Lamdf;
    //   226: getfield 445	amdf:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   229: iload_2
    //   230: invokestatic 451	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 457 2 0
    //   238: pop
    //   239: iload_1
    //   240: iconst_1
    //   241: iadd
    //   242: istore_1
    //   243: goto -64 -> 179
    //   246: astore 7
    //   248: aload 7
    //   250: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   253: aload 9
    //   255: astore 7
    //   257: goto -97 -> 160
    //   260: astore 9
    //   262: aconst_null
    //   263: astore 8
    //   265: aload 8
    //   267: astore 7
    //   269: aload 9
    //   271: invokevirtual 458	java/io/FileNotFoundException:printStackTrace	()V
    //   274: aload 8
    //   276: ifnull +125 -> 401
    //   279: aload 8
    //   281: invokevirtual 407	java/io/InputStream:close	()V
    //   284: ldc 161
    //   286: astore 7
    //   288: goto -128 -> 160
    //   291: astore 7
    //   293: aload 7
    //   295: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   298: ldc 161
    //   300: astore 7
    //   302: goto -142 -> 160
    //   305: astore 9
    //   307: aconst_null
    //   308: astore 8
    //   310: aload 8
    //   312: astore 7
    //   314: aload 9
    //   316: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   319: aload 8
    //   321: ifnull +80 -> 401
    //   324: aload 8
    //   326: invokevirtual 407	java/io/InputStream:close	()V
    //   329: ldc 161
    //   331: astore 7
    //   333: goto -173 -> 160
    //   336: astore 7
    //   338: aload 7
    //   340: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   343: ldc 161
    //   345: astore 7
    //   347: goto -187 -> 160
    //   350: astore 8
    //   352: aconst_null
    //   353: astore 7
    //   355: aload 7
    //   357: ifnull +8 -> 365
    //   360: aload 7
    //   362: invokevirtual 407	java/io/InputStream:close	()V
    //   365: aload 8
    //   367: athrow
    //   368: astore 7
    //   370: aload 7
    //   372: invokevirtual 408	java/io/IOException:printStackTrace	()V
    //   375: goto -10 -> 365
    //   378: astore 7
    //   380: aload 7
    //   382: invokevirtual 459	org/json/JSONException:printStackTrace	()V
    //   385: return
    //   386: astore 8
    //   388: goto -33 -> 355
    //   391: astore 9
    //   393: goto -83 -> 310
    //   396: astore 9
    //   398: goto -133 -> 265
    //   401: ldc 161
    //   403: astore 7
    //   405: goto -245 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	this	WordMatchManager
    //   0	408	1	paramInt	int
    //   221	9	2	i	int
    //   68	13	3	l1	long
    //   78	4	5	l2	long
    //   32	40	7	localObject1	Object
    //   98	3	7	localIOException1	IOException
    //   108	81	7	localObject2	Object
    //   246	3	7	localIOException2	IOException
    //   255	32	7	localObject3	Object
    //   291	3	7	localIOException3	IOException
    //   300	32	7	localObject4	Object
    //   336	3	7	localIOException4	IOException
    //   345	16	7	str1	String
    //   368	3	7	localIOException5	IOException
    //   378	3	7	localJSONException	org.json.JSONException
    //   403	1	7	str2	String
    //   28	297	8	localObject5	Object
    //   350	16	8	localObject6	Object
    //   386	1	8	localObject7	Object
    //   12	242	9	localObject8	Object
    //   260	10	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   305	10	9	localIOException6	IOException
    //   391	1	9	localIOException7	IOException
    //   396	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   17	42	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   92	97	98	java/io/IOException
    //   151	156	246	java/io/IOException
    //   14	30	260	java/io/FileNotFoundException
    //   279	284	291	java/io/IOException
    //   14	30	305	java/io/IOException
    //   324	329	336	java/io/IOException
    //   14	30	350	finally
    //   360	365	368	java/io/IOException
    //   160	177	378	org/json/JSONException
    //   179	239	378	org/json/JSONException
    //   34	42	386	finally
    //   46	54	386	finally
    //   58	64	386	finally
    //   73	80	386	finally
    //   110	115	386	finally
    //   119	127	386	finally
    //   131	142	386	finally
    //   269	274	386	finally
    //   314	319	386	finally
    //   34	42	391	java/io/IOException
    //   46	54	391	java/io/IOException
    //   58	64	391	java/io/IOException
    //   73	80	391	java/io/IOException
    //   110	115	391	java/io/IOException
    //   119	127	391	java/io/IOException
    //   131	142	391	java/io/IOException
    //   34	42	396	java/io/FileNotFoundException
    //   46	54	396	java/io/FileNotFoundException
    //   58	64	396	java/io/FileNotFoundException
    //   73	80	396	java/io/FileNotFoundException
    //   110	115	396	java/io/FileNotFoundException
    //   119	127	396	java/io/FileNotFoundException
    //   131	142	396	java/io/FileNotFoundException
  }
  
  protected void b(amde paramamde)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    localSharedPreferences.edit().putString("REQUEST_DICT_MD5_" + paramamde.jdField_a_of_type_Int, paramamde.jdField_a_of_type_JavaLangString).commit();
    localSharedPreferences.edit().putString("DICT_ID_" + paramamde.jdField_a_of_type_Int, paramamde.c).commit();
    localSharedPreferences.edit().putString("DICT_MD5_" + paramamde.jdField_a_of_type_Int, paramamde.jdField_b_of_type_JavaLangString).commit();
  }
  
  protected String c(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_ID_" + paramInt, "0");
  }
  
  protected String d(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("REQUEST_DICT_MD5_" + paramInt, "0");
  }
  
  protected String e(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).getString("DICT_MD5_" + paramInt, "0");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager
 * JD-Core Version:    0.7.0.1
 */