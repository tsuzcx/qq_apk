package com.tencent.mobileqq.business.sougou;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
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
  protected QQAppInterface a;
  protected WordMatchManager.DictLocalMetaInfo a;
  protected WordMatchManager.Environment a;
  protected WordMatchManager.WordMatcher a;
  protected HttpWebCgiAsyncTask.Callback a;
  protected ArrayList<WordMatchManager.MatcherCallback> a;
  boolean a;
  protected WordMatchManager.DictLocalMetaInfo b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = false;
  boolean e = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/Tencent/QQ_business");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public WordMatchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher = new WordMatchManager.HotWordMatcher(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment = new WordMatchManager.Environment();
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = new WordMatchManager.DictLocalMetaInfo();
    this.jdField_b_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = new WordMatchManager.DictLocalMetaInfo();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new WordMatchManager.4(this);
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
      QLog.e(".business.sougou.DicFileDownloader", 2, "load stl failed!", paramQQAppInterface);
    }
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
  }
  
  private String a(String paramString)
  {
    String str = "";
    System.currentTimeMillis();
    try
    {
      localObject = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return localObject;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return "";
      localObject = new File(paramString);
      paramString = str;
      if (!((File)localObject).exists()) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          paramString = MD5FileUtil.a((File)localObject);
          if (paramString == null) {
            paramString = "";
          }
          return paramString;
        }
        catch (IOException paramString) {}
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
      }
    }
    return "";
  }
  
  protected long a(int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DICT_LAST_MODIFIED_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public WordMatchManager.WordMatcher a(WordMatchManager.MatcherCallback paramMatcherCallback)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return null;
    }
    if (this.c) {
      return this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.1(this, paramMatcherCallback));
    return null;
  }
  
  protected String a(int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "";
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(File.separator);
          localStringBuilder.append("rules.ini");
          return localStringBuilder.toString();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("dict.xdb");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("big");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("small");
    return localStringBuilder.toString();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_Boolean = a(2);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_b_of_type_Boolean = a(1);
    WordMatchManager.Environment localEnvironment = this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment;
    boolean bool;
    if ((a(3)) && (a(4))) {
      bool = true;
    } else {
      bool = false;
    }
    localEnvironment.c = bool;
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_a_of_type_Boolean) {
      b(2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment.jdField_b_of_type_Boolean) {
      b(1);
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.5(this, paramInt));
  }
  
  protected void a(int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DICT_LAST_MODIFIED_");
    localStringBuilder.append(paramInt);
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  protected void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestGetDictOrNot cgi begin| type:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(",time:");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d(".business.sougou.DicFileDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (TicketManager)paramQQAppInterface.getManager(2);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
    localObject2 = ((TicketManager)localObject2).getSkey(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    paramQQAppInterface.putString("type", localStringBuilder.toString());
    paramQQAppInterface.putString("id", c(paramInt));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(d(paramInt));
    paramQQAppInterface.putString("md5", localStringBuilder.toString());
    paramQQAppInterface.putString("version", "8.7.0");
    paramQQAppInterface.putString("platform", "android");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append((String)localObject2);
    paramQQAppInterface.putString("Cookie", localStringBuilder.toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", paramQQAppInterface);
    ((HashMap)localObject1).put("CONTEXT", BaseApplication.getContext());
    new HttpWebCgiAsyncTask("https://cgi.qqweb.qq.com/cgi-bin/frequency/whether_request_cdn", "POST", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
  }
  
  protected void a(WordMatchManager.DictLocalMetaInfo paramDictLocalMetaInfo)
  {
    if (paramDictLocalMetaInfo.jdField_b_of_type_Int != 1)
    {
      a(paramDictLocalMetaInfo.jdField_a_of_type_Int);
      return;
    }
    if (paramDictLocalMetaInfo.jdField_a_of_type_Int == 2) {
      this.jdField_b_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = paramDictLocalMetaInfo;
    } else if (paramDictLocalMetaInfo.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$DictLocalMetaInfo = paramDictLocalMetaInfo;
    }
    ThreadManager.post(new WordMatchManager.TaskHttpDownload(this, paramDictLocalMetaInfo.jdField_a_of_type_Int), 8, null, true);
  }
  
  public void a(WordMatchManager.MatcherCallback paramMatcherCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new WordMatchManager.2(this, paramMatcherCallback));
  }
  
  protected void a(boolean paramBoolean)
  {
    ThreadManager.post(new WordMatchManager.3(this, paramBoolean), 5, null, true);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleUpdateCompleted:");
      localStringBuilder.append(paramBoolean);
      QLog.d(".business.sougou.DicFileDownloader", 4, localStringBuilder.toString());
    }
  }
  
  protected boolean a(int paramInt)
  {
    String str = a(paramInt);
    if (!new File(str).exists()) {
      return false;
    }
    return e(paramInt).equalsIgnoreCase(DictFileUtil.a(str));
  }
  
  protected String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return "";
          }
          return "https://pub.idqqimg.com/pc/qqclient/sfile/srule.gz";
        }
        return "https://pub.idqqimg.com/pc/qqclient/sfile/wsdict.gz";
      }
      return "https://pub.idqqimg.com/pc/qqclient/sfile/big.gz";
    }
    return "https://pub.idqqimg.com/pc/qqclient/sfile/small.gz";
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
    //   0: new 158	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 359	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(I)Ljava/lang/String;
    //   9: invokespecial 161	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 10
    //   17: aconst_null
    //   18: astore 11
    //   20: aconst_null
    //   21: astore 8
    //   23: aload 8
    //   25: astore 7
    //   27: iconst_4
    //   28: newarray byte
    //   30: astore 12
    //   32: aload 8
    //   34: astore 7
    //   36: new 394	java/io/FileInputStream
    //   39: dup
    //   40: aload 9
    //   42: invokespecial 397	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 8
    //   47: aload 8
    //   49: aload 12
    //   51: invokevirtual 403	java/io/InputStream:read	([B)I
    //   54: pop
    //   55: aload 8
    //   57: aload 12
    //   59: invokevirtual 403	java/io/InputStream:read	([B)I
    //   62: pop
    //   63: aload 12
    //   65: invokestatic 405	com/tencent/mobileqq/business/sougou/DictFileUtil:a	([B)I
    //   68: istore_1
    //   69: iload_1
    //   70: iconst_4
    //   71: iadd
    //   72: i2l
    //   73: lstore_3
    //   74: aload 9
    //   76: invokevirtual 408	java/io/File:length	()J
    //   79: lstore 5
    //   81: lload_3
    //   82: lload 5
    //   84: lcmp
    //   85: ifle +17 -> 102
    //   88: aload 8
    //   90: invokevirtual 411	java/io/InputStream:close	()V
    //   93: return
    //   94: astore 7
    //   96: aload 7
    //   98: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   101: return
    //   102: iload_1
    //   103: newarray byte
    //   105: astore 7
    //   107: aload 8
    //   109: aload 7
    //   111: invokevirtual 403	java/io/InputStream:read	([B)I
    //   114: pop
    //   115: new 366	java/lang/String
    //   118: dup
    //   119: aload 7
    //   121: invokespecial 415	java/lang/String:<init>	([B)V
    //   124: astore 7
    //   126: aload 8
    //   128: invokevirtual 411	java/io/InputStream:close	()V
    //   131: goto +108 -> 239
    //   134: astore 8
    //   136: aload 8
    //   138: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   141: goto +98 -> 239
    //   144: astore 7
    //   146: goto +187 -> 333
    //   149: astore 9
    //   151: goto +27 -> 178
    //   154: astore 9
    //   156: goto +50 -> 206
    //   159: astore 9
    //   161: aload 7
    //   163: astore 8
    //   165: aload 9
    //   167: astore 7
    //   169: goto +164 -> 333
    //   172: astore 9
    //   174: aload 10
    //   176: astore 8
    //   178: aload 8
    //   180: astore 7
    //   182: aload 9
    //   184: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   187: aload 8
    //   189: ifnull +46 -> 235
    //   192: aload 8
    //   194: invokevirtual 411	java/io/InputStream:close	()V
    //   197: goto +38 -> 235
    //   200: astore 9
    //   202: aload 11
    //   204: astore 8
    //   206: aload 8
    //   208: astore 7
    //   210: aload 9
    //   212: invokevirtual 416	java/io/FileNotFoundException:printStackTrace	()V
    //   215: aload 8
    //   217: ifnull +18 -> 235
    //   220: aload 8
    //   222: invokevirtual 411	java/io/InputStream:close	()V
    //   225: goto +10 -> 235
    //   228: astore 7
    //   230: aload 7
    //   232: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   235: ldc 137
    //   237: astore 7
    //   239: new 418	org/json/JSONObject
    //   242: dup
    //   243: aload 7
    //   245: invokespecial 419	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   248: ldc_w 421
    //   251: invokevirtual 425	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   254: astore 7
    //   256: iconst_0
    //   257: istore_1
    //   258: iload_1
    //   259: aload 7
    //   261: invokevirtual 430	org/json/JSONArray:length	()I
    //   264: if_icmpge +68 -> 332
    //   267: aload 7
    //   269: iload_1
    //   270: invokevirtual 434	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   273: astore 8
    //   275: aload 8
    //   277: ldc_w 436
    //   280: invokevirtual 439	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   283: ldc_w 441
    //   286: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   289: ifeq +29 -> 318
    //   292: aload 8
    //   294: ldc_w 443
    //   297: invokevirtual 447	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   300: istore_2
    //   301: aload_0
    //   302: getfield 80	com/tencent/mobileqq/business/sougou/WordMatchManager:jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$Environment	Lcom/tencent/mobileqq/business/sougou/WordMatchManager$Environment;
    //   305: getfield 450	com/tencent/mobileqq/business/sougou/WordMatchManager$Environment:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   308: iload_2
    //   309: invokestatic 456	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: invokeinterface 462 2 0
    //   317: pop
    //   318: iload_1
    //   319: iconst_1
    //   320: iadd
    //   321: istore_1
    //   322: goto -64 -> 258
    //   325: astore 7
    //   327: aload 7
    //   329: invokevirtual 463	org/json/JSONException:printStackTrace	()V
    //   332: return
    //   333: aload 8
    //   335: ifnull +18 -> 353
    //   338: aload 8
    //   340: invokevirtual 411	java/io/InputStream:close	()V
    //   343: goto +10 -> 353
    //   346: astore 8
    //   348: aload 8
    //   350: invokevirtual 412	java/io/IOException:printStackTrace	()V
    //   353: goto +6 -> 359
    //   356: aload 7
    //   358: athrow
    //   359: goto -3 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	WordMatchManager
    //   0	362	1	paramInt	int
    //   300	9	2	i	int
    //   73	9	3	l1	long
    //   79	4	5	l2	long
    //   25	10	7	localFileInputStream1	java.io.FileInputStream
    //   94	3	7	localIOException1	IOException
    //   105	20	7	localObject1	Object
    //   144	18	7	localObject2	Object
    //   167	42	7	localObject3	Object
    //   228	3	7	localIOException2	IOException
    //   237	31	7	localObject4	Object
    //   325	32	7	localJSONException	org.json.JSONException
    //   21	106	8	localFileInputStream2	java.io.FileInputStream
    //   134	3	8	localIOException3	IOException
    //   163	176	8	localObject5	Object
    //   346	3	8	localIOException4	IOException
    //   12	63	9	localFile	File
    //   149	1	9	localIOException5	IOException
    //   154	1	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   159	7	9	localObject6	Object
    //   172	11	9	localIOException6	IOException
    //   200	11	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   15	160	10	localObject7	Object
    //   18	185	11	localObject8	Object
    //   30	34	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	93	94	java/io/IOException
    //   126	131	134	java/io/IOException
    //   47	69	144	finally
    //   74	81	144	finally
    //   102	126	144	finally
    //   47	69	149	java/io/IOException
    //   74	81	149	java/io/IOException
    //   102	126	149	java/io/IOException
    //   47	69	154	java/io/FileNotFoundException
    //   74	81	154	java/io/FileNotFoundException
    //   102	126	154	java/io/FileNotFoundException
    //   27	32	159	finally
    //   36	47	159	finally
    //   182	187	159	finally
    //   210	215	159	finally
    //   27	32	172	java/io/IOException
    //   36	47	172	java/io/IOException
    //   27	32	200	java/io/FileNotFoundException
    //   36	47	200	java/io/FileNotFoundException
    //   192	197	228	java/io/IOException
    //   220	225	228	java/io/IOException
    //   239	256	325	org/json/JSONException
    //   258	318	325	org/json/JSONException
    //   338	343	346	java/io/IOException
  }
  
  protected void b(WordMatchManager.DictLocalMetaInfo paramDictLocalMetaInfo)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("REQUEST_DICT_MD5_");
    localStringBuilder.append(paramDictLocalMetaInfo.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramDictLocalMetaInfo.jdField_a_of_type_JavaLangString).commit();
    localObject2 = ((SharedPreferences)localObject1).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DICT_ID_");
    localStringBuilder.append(paramDictLocalMetaInfo.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), paramDictLocalMetaInfo.c).commit();
    localObject1 = ((SharedPreferences)localObject1).edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("DICT_MD5_");
    ((StringBuilder)localObject2).append(paramDictLocalMetaInfo.jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramDictLocalMetaInfo.jdField_b_of_type_JavaLangString).commit();
  }
  
  protected String c(int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DICT_ID_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getString(localStringBuilder.toString(), "0");
  }
  
  protected String d(int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("REQUEST_DICT_MD5_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getString(localStringBuilder.toString(), "0");
  }
  
  protected String e(int paramInt)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("BUSINESS_DICT_FILE_MANAGER", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DICT_MD5_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getString(localStringBuilder.toString(), "0");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager
 * JD-Core Version:    0.7.0.1
 */