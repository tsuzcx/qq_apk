import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig.1;
import com.tencent.biz.AuthorizeConfig.2;
import com.tencent.biz.AuthorizeConfig.4;
import com.tencent.biz.AuthorizeConfig.5;
import com.tencent.biz.AuthorizeConfig.6;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.webview.utils.WebViewConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.WtTicketPromise;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nhe
{
  public static volatile long a;
  protected static final ArrayMap<String, String> a;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static final AtomicBoolean a;
  protected static nhe a;
  protected static final JSONArray a;
  public static final String[] a;
  public static volatile long b;
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private static long e;
  private static long f;
  protected volatile int a;
  public final Context a;
  public final SharedPreferences a;
  private final String jdField_a_of_type_JavaLangString = "faceUnblockCamera.startPTVActivity";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final ConcurrentHashMap<String, JSONArray> a;
  public final AtomicInteger a;
  public nkc a;
  public nkd a;
  public WtTicketPromise a;
  public volatile JSONObject a;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "https://mysec.qq.com/v2/account_control/index.html";
  public final ConcurrentHashMap<String, Set<String>> b;
  protected volatile JSONArray b;
  public volatile JSONObject b;
  protected volatile long c;
  private final String c;
  protected volatile JSONArray c;
  public volatile JSONObject c;
  protected volatile long d;
  protected volatile JSONArray d;
  protected volatile JSONObject d;
  protected volatile JSONArray e;
  protected volatile JSONObject e;
  protected volatile JSONArray f;
  protected volatile JSONObject f;
  public volatile JSONArray g;
  protected volatile JSONObject g;
  public volatile JSONObject h;
  public volatile JSONObject i;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "skey", "pskey", "a1", "a2", "ptlogin2", "pt4_token" };
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pskey", "[\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\", \"docs.qq.com\"],\"ti.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a1", "[]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.qqcomic.aiogift");
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.gamecenter.hebao");
    jdField_a_of_type_OrgJsonJSONArray.put("com.tencent.gamecenter.hebao2020");
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Long = -1L;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private nhe(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_c_of_type_JavaLangString = "qbizApi.getClientInfo";
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(jdField_a_of_type_ArrayOfJavaLangString.length);
    this.jdField_a_of_type_OicqWlogin_sdkRequestWtTicketPromise = new nhg(this);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "AuthorizeConfig init");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
    this.jdField_a_of_type_Nkc = new nkc(this.jdField_a_of_type_AndroidContentSharedPreferences);
    this.jdField_a_of_type_Nkd = new nkd(this.jdField_a_of_type_AndroidContentSharedPreferences, this.jdField_a_of_type_Nkc);
    this.jdField_a_of_type_Nkc.a(this.jdField_a_of_type_Nkd);
    FlatBuffersParser.f();
    k();
    jdField_e_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastPreloadPskey", 0L);
  }
  
  private static String a(String paramString1, String paramString2, Set<String> paramSet)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject1 = Uri.parse(paramString2);
      localObject2 = ((Uri)localObject1).getScheme();
      if ((!"http".equals(localObject2)) && (!"https".equals(localObject2)))
      {
        localObject1 = "";
        return localObject1;
      }
      if (((Uri)localObject1).isHierarchical())
      {
        localObject1 = ((Uri)localObject1).getHost();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).toLowerCase();
          if (paramSet.contains(localObject1)) {
            paramSet = (Set<String>)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = paramSet;
      if (!QLog.isColorLevel()) {
        break;
      }
      if (!TextUtils.isEmpty(paramSet))
      {
        QLog.d("AuthorizeConfig", 2, paramSet + " need " + paramString1 + " which extract from " + paramString2);
        return paramSet;
        localObject2 = paramSet.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramSet = (String)((Iterator)localObject2).next();
        } while (!((String)localObject1).endsWith("." + paramSet));
      }
      else
      {
        QLog.d("AuthorizeConfig", 2, paramString2 + " not need " + paramString1);
        return paramSet;
        paramSet = "";
      }
    }
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 297	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 298	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: new 300	java/util/zip/Inflater
    //   13: dup
    //   14: invokespecial 301	java/util/zip/Inflater:<init>	()V
    //   17: astore_3
    //   18: aload_2
    //   19: astore_1
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 305	java/util/zip/Inflater:setInput	([B)V
    //   25: aload_2
    //   26: astore_1
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: invokevirtual 308	java/util/zip/Inflater:finished	()Z
    //   39: ifne +56 -> 95
    //   42: aload_2
    //   43: astore_1
    //   44: aload_2
    //   45: aload_0
    //   46: iconst_0
    //   47: aload_3
    //   48: aload_0
    //   49: invokevirtual 312	java/util/zip/Inflater:inflate	([B)I
    //   52: invokevirtual 316	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -22 -> 33
    //   58: astore_1
    //   59: aload_2
    //   60: astore_0
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: astore_1
    //   65: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +14 -> 82
    //   71: aload_0
    //   72: astore_1
    //   73: ldc 161
    //   75: iconst_2
    //   76: ldc 239
    //   78: aload_2
    //   79: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   90: ldc 239
    //   92: astore_0
    //   93: aload_0
    //   94: areturn
    //   95: aload_2
    //   96: astore_1
    //   97: aload_3
    //   98: invokevirtual 325	java/util/zip/Inflater:end	()V
    //   101: aload_2
    //   102: astore_1
    //   103: new 40	java/lang/String
    //   106: dup
    //   107: aload_2
    //   108: invokevirtual 329	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: invokespecial 331	java/lang/String:<init>	([B)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_0
    //   117: aload_2
    //   118: ifnull -25 -> 93
    //   121: aload_2
    //   122: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   125: aload_3
    //   126: areturn
    //   127: astore_1
    //   128: aload_3
    //   129: astore_0
    //   130: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq -40 -> 93
    //   136: ldc 161
    //   138: iconst_2
    //   139: ldc 239
    //   141: aload_1
    //   142: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_3
    //   146: areturn
    //   147: astore_0
    //   148: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq -61 -> 90
    //   154: ldc 161
    //   156: iconst_2
    //   157: ldc 239
    //   159: aload_0
    //   160: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: goto -73 -> 90
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_1
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   177: aload_0
    //   178: athrow
    //   179: astore_1
    //   180: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq -6 -> 177
    //   186: ldc 161
    //   188: iconst_2
    //   189: ldc 239
    //   191: aload_1
    //   192: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -18 -> 177
    //   198: astore_0
    //   199: goto -30 -> 169
    //   202: astore_2
    //   203: aconst_null
    //   204: astore_0
    //   205: goto -142 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramArrayOfByte	byte[]
    //   9	35	1	localObject1	Object
    //   58	4	1	localThrowable1	java.lang.Throwable
    //   64	39	1	localObject2	Object
    //   127	15	1	localException1	Exception
    //   168	6	1	localObject3	Object
    //   179	13	1	localException2	Exception
    //   7	115	2	localObject4	Object
    //   202	1	2	localThrowable2	java.lang.Throwable
    //   17	129	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   10	18	58	java/lang/Throwable
    //   20	25	58	java/lang/Throwable
    //   27	33	58	java/lang/Throwable
    //   35	42	58	java/lang/Throwable
    //   44	55	58	java/lang/Throwable
    //   97	101	58	java/lang/Throwable
    //   103	115	58	java/lang/Throwable
    //   121	125	127	java/lang/Exception
    //   86	90	147	java/lang/Exception
    //   0	8	166	finally
    //   173	177	179	java/lang/Exception
    //   10	18	198	finally
    //   20	25	198	finally
    //   27	33	198	finally
    //   35	42	198	finally
    //   44	55	198	finally
    //   65	71	198	finally
    //   73	82	198	finally
    //   97	101	198	finally
    //   103	115	198	finally
    //   0	8	202	java/lang/Throwable
  }
  
  public static nhe a()
  {
    if (jdField_a_of_type_Nhe == null) {}
    try
    {
      if (jdField_a_of_type_Nhe == null) {
        jdField_a_of_type_Nhe = new nhe(BaseApplication.getContext());
      }
      jdField_a_of_type_Nhe.a();
      if (!jdField_a_of_type_Nhe.a(true)) {
        jdField_a_of_type_Nhe.i();
      }
      return jdField_a_of_type_Nhe;
    }
    finally {}
  }
  
  public static nhe a(boolean paramBoolean)
  {
    if (jdField_a_of_type_Nhe == null) {}
    try
    {
      if (jdField_a_of_type_Nhe == null) {
        jdField_a_of_type_Nhe = new nhe(BaseApplication.getContext());
      }
      jdField_a_of_type_Nhe.a();
      jdField_a_of_type_Nhe.a(paramBoolean);
      return jdField_a_of_type_Nhe;
    }
    finally {}
  }
  
  /* Error */
  private JSONArray a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +15 -> 21
    //   9: new 80	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 82	org/json/JSONArray:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: areturn
    //   21: aload_0
    //   22: getfield 139	nhe:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 357	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 80	org/json/JSONArray
    //   32: astore 6
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: ifnonnull -22 -> 18
    //   43: aload_0
    //   44: getfield 139	nhe:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: astore 8
    //   49: aload 8
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 139	nhe:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   56: aload_1
    //   57: invokevirtual 357	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 80	org/json/JSONArray
    //   63: astore 5
    //   65: aload 5
    //   67: astore 6
    //   69: aload 5
    //   71: ifnonnull +139 -> 210
    //   74: aload_0
    //   75: getfield 192	nhe:jdField_a_of_type_Nkd	Lnkd;
    //   78: aload_1
    //   79: invokevirtual 359	nkd:a	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   82: astore 6
    //   84: aload 6
    //   86: ifnonnull +195 -> 281
    //   89: new 80	org/json/JSONArray
    //   92: dup
    //   93: getstatic 62	nhe:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   96: aload_1
    //   97: invokevirtual 360	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 40	java/lang/String
    //   103: invokespecial 363	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   106: astore 5
    //   108: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +29 -> 140
    //   114: ldc 161
    //   116: iconst_2
    //   117: new 255	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 365
    //   127: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload 5
    //   142: astore 6
    //   144: aload 5
    //   146: ifnonnull +44 -> 190
    //   149: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +29 -> 181
    //   155: ldc 161
    //   157: iconst_2
    //   158: new 255	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   165: aload_1
    //   166: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 369
    //   172: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 80	org/json/JSONArray
    //   184: dup
    //   185: invokespecial 82	org/json/JSONArray:<init>	()V
    //   188: astore 6
    //   190: aload_0
    //   191: getfield 139	nhe:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   194: aload_1
    //   195: aload 6
    //   197: invokevirtual 370	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_0
    //   202: getfield 141	nhe:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   205: aload_1
    //   206: invokevirtual 373	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload 8
    //   212: monitorexit
    //   213: aload 6
    //   215: areturn
    //   216: astore_1
    //   217: aload 8
    //   219: monitorexit
    //   220: aload_1
    //   221: athrow
    //   222: astore 7
    //   224: aload 6
    //   226: astore 5
    //   228: aload 7
    //   230: astore 6
    //   232: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +151 -> 386
    //   238: ldc 161
    //   240: iconst_2
    //   241: new 255	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 375
    //   251: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_1
    //   255: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 377
    //   261: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 6
    //   266: invokevirtual 380	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: goto +108 -> 386
    //   281: ldc 44
    //   283: aload_1
    //   284: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: istore 4
    //   289: iload 4
    //   291: ifeq +78 -> 369
    //   294: new 80	org/json/JSONArray
    //   297: dup
    //   298: getstatic 62	nhe:jdField_a_of_type_AndroidSupportV4UtilArrayMap	Landroid/support/v4/util/ArrayMap;
    //   301: ldc 44
    //   303: invokevirtual 360	android/support/v4/util/ArrayMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 40	java/lang/String
    //   309: invokespecial 363	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   312: astore 5
    //   314: aload 5
    //   316: invokevirtual 384	org/json/JSONArray:length	()I
    //   319: istore_2
    //   320: iload_3
    //   321: iload_2
    //   322: if_icmpge +32 -> 354
    //   325: aload 6
    //   327: aload 5
    //   329: iload_3
    //   330: invokevirtual 388	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   333: invokevirtual 89	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   336: pop
    //   337: iload_3
    //   338: iconst_1
    //   339: iadd
    //   340: istore_3
    //   341: goto -21 -> 320
    //   344: aload 7
    //   346: invokevirtual 391	org/json/JSONException:printStackTrace	()V
    //   349: iconst_0
    //   350: istore_2
    //   351: goto -31 -> 320
    //   354: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +12 -> 369
    //   360: ldc 161
    //   362: iconst_2
    //   363: ldc_w 393
    //   366: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 6
    //   371: astore 5
    //   373: goto -233 -> 140
    //   376: astore 7
    //   378: goto -34 -> 344
    //   381: astore 6
    //   383: goto -151 -> 232
    //   386: goto -246 -> 140
    //   389: astore 7
    //   391: aconst_null
    //   392: astore 5
    //   394: goto -50 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	nhe
    //   0	397	1	paramString	String
    //   319	32	2	j	int
    //   1	340	3	k	int
    //   287	3	4	bool	boolean
    //   16	377	5	localObject1	Object
    //   32	338	6	localObject2	Object
    //   381	1	6	localJSONException1	JSONException
    //   222	123	7	localJSONException2	JSONException
    //   376	1	7	localJSONException3	JSONException
    //   389	1	7	localJSONException4	JSONException
    //   47	171	8	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   52	65	216	finally
    //   74	84	216	finally
    //   89	108	216	finally
    //   108	140	216	finally
    //   149	181	216	finally
    //   181	190	216	finally
    //   190	210	216	finally
    //   210	213	216	finally
    //   217	220	216	finally
    //   232	278	216	finally
    //   281	289	216	finally
    //   294	314	216	finally
    //   314	320	216	finally
    //   325	337	216	finally
    //   344	349	216	finally
    //   354	369	216	finally
    //   89	108	222	org/json/JSONException
    //   314	320	376	org/json/JSONException
    //   108	140	381	org/json/JSONException
    //   294	314	389	org/json/JSONException
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject3 = this.jdField_a_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject = localJSONObject3;
    JSONObject localJSONObject1;
    if (localJSONObject3 == null)
    {
      localObject = this.jdField_a_of_type_Nkd.a();
      localJSONObject1 = localJSONObject3;
      if (localObject == null) {}
    }
    try
    {
      localJSONObject1 = new JSONObject((String)localObject);
      localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject2 = localJSONObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mOfflineConfig  error");
          localJSONObject2 = localJSONObject3;
        }
      }
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  private JSONObject b()
  {
    Object localObject3 = this.jdField_b_of_type_OrgJsonJSONObject;
    System.currentTimeMillis();
    Object localObject1 = localObject3;
    String str;
    if (localObject3 == null)
    {
      str = this.jdField_a_of_type_Nkd.b();
      localObject1 = localObject3;
      if (str == null) {}
    }
    try
    {
      localObject1 = new JSONObject(str);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new JSONObject();
      }
      this.jdField_b_of_type_OrgJsonJSONObject = ((JSONObject)localObject3);
      localObject1 = localObject3;
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "Decode mExtraConfig error");
          localObject2 = localObject3;
        }
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while ("*".equals(paramString1));
      if (!"*.*".equals(paramString1)) {
        break;
      }
      bool1 = bool2;
    } while (paramString2.indexOf('.') != -1);
    return false;
    if (paramString1.startsWith("*")) {
      return paramString2.endsWith(paramString1.substring(1));
    }
    if (paramString1.endsWith("*")) {
      return paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1));
    }
    return paramString2.equals(paramString1);
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1) {
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 3) {
          return true;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) {
          break label121;
        }
        bool1 = "com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getQQProcessName());
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        long l = System.currentTimeMillis() - jdField_b_of_type_Long;
        if (l < 0L) {
          break label126;
        }
        if (l >= 1800000L)
        {
          break label126;
          return bool1;
        }
      }
      int j = 0;
      break label128;
      label121:
      boolean bool1 = false;
      continue;
      label126:
      j = 1;
      label128:
      if (!bool1)
      {
        bool1 = bool2;
        if (j == 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
  }
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return 0;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        int j = localJSONObject.getJSONObject(paramString[0]).getInt("delay");
        return j;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpDelayTime error");
    return 0;
  }
  
  public long a()
  {
    if (-1L == this.jdField_d_of_type_Long) {
      this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", 0L);
    }
    return this.jdField_d_of_type_Long;
  }
  
  /* Error */
  public Boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: areturn
    //   9: aload_1
    //   10: invokestatic 225	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 229	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: astore 6
    //   22: ldc_w 491
    //   25: aload 6
    //   27: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +55 -> 85
    //   33: aload_1
    //   34: invokevirtual 418	java/lang/String:length	()I
    //   37: sipush 200
    //   40: if_icmple +42 -> 82
    //   43: aload_1
    //   44: iconst_0
    //   45: sipush 200
    //   48: invokevirtual 439	java/lang/String:substring	(II)Ljava/lang/String;
    //   51: astore_1
    //   52: ldc_w 493
    //   55: ldc_w 495
    //   58: aload_1
    //   59: ldc 239
    //   61: ldc 239
    //   63: ldc 239
    //   65: invokestatic 500	bfui:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   68: ldc 161
    //   70: iconst_1
    //   71: ldc_w 502
    //   74: invokestatic 367	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_0
    //   78: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: areturn
    //   82: goto -30 -> 52
    //   85: ldc 231
    //   87: aload 6
    //   89: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifne +18 -> 110
    //   95: ldc 237
    //   97: aload 6
    //   99: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: ifne +8 -> 110
    //   105: iconst_0
    //   106: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: areturn
    //   110: aload 5
    //   112: invokevirtual 245	android/net/Uri:getHost	()Ljava/lang/String;
    //   115: astore_1
    //   116: aload_1
    //   117: astore 5
    //   119: aload_1
    //   120: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +9 -> 132
    //   126: aload_1
    //   127: invokevirtual 248	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   130: astore 5
    //   132: aload_0
    //   133: getfield 504	nhe:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   136: astore_1
    //   137: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   140: pop2
    //   141: aload_1
    //   142: ifnonnull +238 -> 380
    //   145: aload_0
    //   146: getfield 192	nhe:jdField_a_of_type_Nkd	Lnkd;
    //   149: invokevirtual 506	nkd:c	()Ljava/lang/String;
    //   152: astore 6
    //   154: aload 6
    //   156: ifnull +101 -> 257
    //   159: new 406	org/json/JSONObject
    //   162: dup
    //   163: aload 6
    //   165: invokespecial 407	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   168: astore 6
    //   170: aload 6
    //   172: astore_1
    //   173: aload_1
    //   174: ifnonnull +203 -> 377
    //   177: new 406	org/json/JSONObject
    //   180: dup
    //   181: ldc_w 508
    //   184: invokespecial 407	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   187: astore 6
    //   189: aload 6
    //   191: astore_1
    //   192: aload_0
    //   193: aload_1
    //   194: putfield 504	nhe:jdField_c_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   197: aload_1
    //   198: ldc_w 510
    //   201: invokevirtual 513	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   204: astore 6
    //   206: aload 6
    //   208: invokevirtual 384	org/json/JSONArray:length	()I
    //   211: istore 4
    //   213: iconst_0
    //   214: istore_3
    //   215: iload_3
    //   216: iload 4
    //   218: if_icmpge +56 -> 274
    //   221: aload 6
    //   223: iload_3
    //   224: invokevirtual 388	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   227: aload 5
    //   229: invokestatic 515	nhe:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   232: ifeq +33 -> 265
    //   235: iconst_1
    //   236: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   239: areturn
    //   240: astore 6
    //   242: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +12 -> 257
    //   248: ldc 161
    //   250: iconst_2
    //   251: ldc_w 517
    //   254: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto -84 -> 173
    //   260: astore 6
    //   262: goto -70 -> 192
    //   265: iload_3
    //   266: iconst_1
    //   267: iadd
    //   268: istore_3
    //   269: goto -54 -> 215
    //   272: astore 5
    //   274: aload_1
    //   275: ldc_w 519
    //   278: invokevirtual 513	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   281: astore 5
    //   283: aload 5
    //   285: invokevirtual 384	org/json/JSONArray:length	()I
    //   288: istore 4
    //   290: iconst_0
    //   291: istore_3
    //   292: iload_3
    //   293: iload 4
    //   295: if_icmpge +30 -> 325
    //   298: aload 5
    //   300: iload_3
    //   301: invokevirtual 388	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   304: aload_2
    //   305: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifeq +8 -> 316
    //   311: iconst_1
    //   312: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   315: areturn
    //   316: iload_3
    //   317: iconst_1
    //   318: iadd
    //   319: istore_3
    //   320: goto -28 -> 292
    //   323: astore 5
    //   325: aload_1
    //   326: ldc_w 521
    //   329: invokevirtual 513	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 384	org/json/JSONArray:length	()I
    //   337: istore 4
    //   339: iconst_0
    //   340: istore_3
    //   341: iload_3
    //   342: iload 4
    //   344: if_icmpge +28 -> 372
    //   347: aload_1
    //   348: iload_3
    //   349: invokevirtual 388	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   352: aload_2
    //   353: invokevirtual 235	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +8 -> 364
    //   359: iconst_1
    //   360: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: areturn
    //   364: iload_3
    //   365: iconst_1
    //   366: iadd
    //   367: istore_3
    //   368: goto -27 -> 341
    //   371: astore_1
    //   372: iconst_0
    //   373: invokestatic 489	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   376: areturn
    //   377: goto -185 -> 192
    //   380: goto -183 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	nhe
    //   0	383	1	paramString1	String
    //   0	383	2	paramString2	String
    //   214	154	3	j	int
    //   211	134	4	k	int
    //   13	215	5	localObject1	Object
    //   272	1	5	localJSONException1	JSONException
    //   281	18	5	localJSONArray	JSONArray
    //   323	1	5	localJSONException2	JSONException
    //   20	202	6	localObject2	Object
    //   240	1	6	localJSONException3	JSONException
    //   260	1	6	localJSONException4	JSONException
    // Exception table:
    //   from	to	target	type
    //   159	170	240	org/json/JSONException
    //   177	189	260	org/json/JSONException
    //   197	213	272	org/json/JSONException
    //   221	235	272	org/json/JSONException
    //   274	290	323	org/json/JSONException
    //   298	311	323	org/json/JSONException
    //   325	339	371	org/json/JSONException
    //   347	359	371	org/json/JSONException
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    return b().optString(paramString1, paramString2);
  }
  
  public Set<String> a(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = new HashSet();
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      localObject1 = localObject2;
    } while (localObject2 != null);
    for (;;)
    {
      int j;
      synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localObject2 = (Set)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label232;
        }
        localObject2 = new HashSet(32);
        localObject1 = a(paramString);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
        {
          int k = ((JSONArray)localObject1).length();
          j = 0;
          if (j < k) {
            if ("skey".equals(paramString)) {
              ((Set)localObject2).add(b(((JSONArray)localObject1).optString(j, ""), "*."));
            } else {
              ((Set)localObject2).add(((JSONArray)localObject1).optString(j, ""));
            }
          }
        }
      }
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject2);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("AuthorizeConfig", 2, paramString + " domain white list: " + localObject2);
        localObject1 = localObject2;
      }
      label232:
      return localObject1;
      j += 1;
    }
  }
  
  protected void a()
  {
    ThreadManager.executeOnSubThread(new AuthorizeConfig.1(this));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    System.currentTimeMillis();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (FlatBuffersParser.a()) {}
    for (paramString1 = this.jdField_a_of_type_Nkc.a(localEditor, paramString1); paramString1 == null; paramString1 = this.jdField_a_of_type_Nkd.a(localEditor, paramString1)) {
      return;
    }
    long l = this.jdField_d_of_type_Long;
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("publishSeq", this.jdField_d_of_type_Long);
    QLog.i("AuthorizeConfig", 1, "update white list's publishSeq from " + l + " to " + this.jdField_d_of_type_Long + ".");
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
      localEditor.putLong("lastUpdate", System.currentTimeMillis());
      localEditor.putString("qqVersion", "2013 8.4.1");
      localEditor.putString(paramString3, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "White list update completed as version=" + paramString2);
      }
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_ok", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      localEditor.commit();
      g();
      i();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      bcst.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "Authorize config parse failed include: " + paramString1);
      }
    }
  }
  
  public boolean a()
  {
    String str = nji.a();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_b_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "CgiConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "CgiConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = Uri.parse(paramString).getHost();
    paramString = (String)localObject;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = ((String)localObject).toLowerCase();
    }
    localObject = a("skey");
    int k = ((JSONArray)localObject).length();
    int j = 0;
    while (j < k)
    {
      if (b(((JSONArray)localObject).optString(j), paramString)) {
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getScheme();
    if ("file".equals(str))
    {
      if (paramString1.length() > 200) {
        paramString1 = paramString1.substring(0, 200);
      }
      for (;;)
      {
        bfui.a("webview", "file_js", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(str)) && (!"https".equals(str))) {
      return false;
    }
    if ("data.checkPermission".equals(paramString2)) {
      return paramString1.startsWith("https://qqweb.qq.com/m/whitelist/testing/");
    }
    if (paramString2.startsWith("CAPTCHA.")) {
      return true;
    }
    if ((paramString2.startsWith("login.openSmsPage")) && ("ti.qq.com".equals(localUri.getHost()))) {
      return true;
    }
    if (paramString2.equals("identification.loginVerify")) {
      return true;
    }
    if ("faceUnblockCamera.startPTVActivity".equals(paramString2)) {
      return true;
    }
    if (("qbizApi.getClientInfo".equals(paramString2)) && (paramString1.startsWith("https://mysec.qq.com/v2/account_control/index.html"))) {
      return true;
    }
    System.currentTimeMillis();
    int j = this.jdField_a_of_type_Nkd.a(localUri.getHost(), paramString2);
    if (nkb.a(j)) {
      return true;
    }
    if (nkb.b(j)) {
      return false;
    }
    if ("publicAccountNew.config".equals(paramString2)) {
      return true;
    }
    if (tym.a(paramString1)) {
      return (!TextUtils.isEmpty(paramString2)) && (tym.a(paramString1, paramString2));
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    return bhre.a(paramJSONObject, "sonicWhiteList");
  }
  
  protected boolean a(boolean paramBoolean)
  {
    if (f())
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(1);
      ThreadManager.executeOnNetWorkThread(new AuthorizeConfig.2(this, paramBoolean));
      return true;
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("bid");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getOfflineId error");
    return null;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.remove("lastVersion");
    localEditor.commit();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    a(false);
  }
  
  public boolean b()
  {
    String str = nji.b();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_c_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_c_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_b_of_type_OrgJsonJSONArray == null) && (!a()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "CgiConfig loadfromsp fail , url: " + nmj.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            if ((this.jdField_b_of_type_OrgJsonJSONArray.length() != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              int k = this.jdField_b_of_type_OrgJsonJSONArray.length();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_b_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label249;
                }
                if (!QLog.isColorLevel()) {
                  break label247;
                }
                QLog.d("AuthorizeConfig", 2, "CgiConfig hit , url: " + nmj.b(paramString, new String[0]) + " domain: " + str2);
                break label247;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "CgiConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label247:
      return true;
      label249:
      j += 1;
    }
  }
  
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      JSONObject localJSONObject;
      do
      {
        return null;
        paramString = paramString.split("\\?");
        localJSONObject = a();
      } while (!localJSONObject.has(paramString[0]));
      try
      {
        paramString = localJSONObject.getJSONObject(paramString[0]).getString("duck");
        return paramString;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "getCheckUpType error");
    return null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
    if ((localObject2 != null) && (localObject1 != null) && (((AppRuntime)localObject1).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5Config data: " + ((JSONObject)localObject2).toString());
      }
      localObject2 = ((JSONObject)localObject2).optJSONArray("vipGrayConfig2");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        int j = 0;
        boolean bool3 = true;
        boolean bool1 = true;
        if (j < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(j);
          boolean bool2 = bool3;
          boolean bool4 = bool1;
          if (localJSONObject != null)
          {
            if (bhre.a(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("mainThreadControl", 0) != 0) {
                break label220;
              }
              bool1 = true;
            }
            label172:
            bool2 = bool3;
            bool4 = bool1;
            if (bhre.a(localJSONObject, "X5Config"))
            {
              if (localJSONObject.optInt("enableQuic", 1) != 1) {
                break label225;
              }
              bool2 = true;
            }
          }
          for (bool4 = bool1;; bool4 = bool1)
          {
            j += 1;
            bool3 = bool2;
            bool1 = bool4;
            break;
            label220:
            bool1 = false;
            break label172;
            label225:
            bool2 = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveX5Config isInitOnSubThread : " + bool1 + ", enable quick: " + bool3);
        }
        localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject1 = ((AppRuntime)localObject1).getApplication().getSharedPreferences("sp_x5_config_" + (String)localObject2, 4).edit();
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_init_sub_thread", bool1);
        ((SharedPreferences.Editor)localObject1).putBoolean("key_x5_enable_quic", bool3);
        ((SharedPreferences.Editor)localObject1).apply();
      }
    }
  }
  
  public boolean c()
  {
    String str = nji.c();
    if (!TextUtils.isEmpty(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content: " + str);
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_d_of_type_OrgJsonJSONArray = new JSONArray(str);
        if (this.jdField_d_of_type_OrgJsonJSONArray == null) {
          break;
        }
        return true;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig load exception: " + localJSONException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig sp content empty!");
      }
    }
    return false;
  }
  
  public boolean c(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_c_of_type_OrgJsonJSONArray == null) && (!b()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig loadfromsp fail , url: " + nmj.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int k = this.jdField_c_of_type_OrgJsonJSONArray.length();
            if ((k != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_c_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label255;
                }
                if (!QLog.isColorLevel()) {
                  break label253;
                }
                QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig hit , url: " + nmj.b(paramString, new String[0]) + " domain: " + str2);
                break label253;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "AsyncCheckConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "AsyncCheckConfig check exception", paramString);
        }
      }
      return false;
      label253:
      return true;
      label255:
      j += 1;
    }
  }
  
  public boolean c(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      localObject1 = paramString1;
      if (!"about:blank".equalsIgnoreCase(paramString1)) {}
    }
    else
    {
      localObject1 = "https://localhost/";
    }
    Object localObject3 = Uri.parse((String)localObject1);
    paramString1 = ((Uri)localObject3).getScheme();
    if ("file".equals(paramString1))
    {
      if (((String)localObject1).length() > 200) {}
      for (paramString1 = ((String)localObject1).substring(0, 200);; paramString1 = (String)localObject1)
      {
        bfui.a("webview", "file_scheme", paramString1, "", "", "");
        QLog.e("AuthorizeConfig", 1, "action deprecated with file protocol");
        return false;
      }
    }
    if ((!"http".equals(paramString1)) && (!"https".equals(paramString1))) {
      return false;
    }
    Object localObject1 = this.i;
    System.currentTimeMillis();
    paramString1 = (String)localObject1;
    if (localObject1 == null) {}
    label235:
    for (;;)
    {
      try
      {
        paramString1 = this.jdField_a_of_type_Nkd.a();
        if (paramString1 == null)
        {
          try
          {
            localObject1 = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString1 = (String)localObject1;
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            continue;
            localObject3 = ((Uri)localObject3).getHost();
            Object localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label235;
            }
            localObject2 = ((String)localObject3).toLowerCase();
            int m = localJSONArray.length();
            int j = 0;
            if (j >= m) {
              break label330;
            }
            localObject3 = localJSONArray.optString(j);
            if (b((String)localObject3, (String)localObject2)) {
              break label275;
            }
            for (;;)
            {
              j += 1;
              break;
              localObject3 = paramString1.optJSONArray((String)localObject3);
              if (localObject3 != null)
              {
                int n = ((JSONArray)localObject3).length();
                int k = 0;
                while (k < n)
                {
                  if (b(((JSONArray)localObject3).optString(k), paramString2)) {
                    return true;
                  }
                  k += 1;
                }
              }
            }
            return false;
          }
          this.i = paramString1;
          localJSONArray = paramString1.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString1 = (String)localObject1;
      }
    }
  }
  
  public String d(String paramString)
  {
    return a("p_skey", paramString, a("pskey"));
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveX5PreloadWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject, "VASBiz_FuncDev_webview.json", false, null);
    if ((localJSONObject != null) && (localObject != null) && (((AppRuntime)localObject).isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive X5PreloadWhiteList data: " + localJSONObject.toString());
      }
      localObject = localJSONObject.optJSONArray("x5PreloadWhiteList");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        this.g = ((JSONArray)localObject).optJSONObject(0);
      }
    }
  }
  
  public boolean d()
  {
    boolean bool = true;
    try
    {
      if ((this.jdField_a_of_type_Int == -1) && (!e()))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail");
          return false;
        }
      }
      else
      {
        int j = this.jdField_a_of_type_Int;
        if (j == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AuthorizeConfig", 2, "forceHttps enable check exception", localException);
      }
    }
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_d_of_type_OrgJsonJSONArray == null) && (!c()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig loadfromsp fail , url: " + nmj.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int k = this.jdField_d_of_type_OrgJsonJSONArray.length();
            if ((k != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_d_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label255;
                }
                if (!QLog.isColorLevel()) {
                  break label253;
                }
                QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig hit , url: " + nmj.b(paramString, new String[0]) + " domain: " + str2);
                break label253;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "SkipInputWarningConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "SkipInputWarningConfig check exception", paramString);
        }
      }
      return false;
      label253:
      return true;
      label255:
      j += 1;
    }
  }
  
  public String e(String paramString)
  {
    return a("pt4_token", paramString, a("pt4_token"));
  }
  
  public void e()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig from VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW.");
    }
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject2, "VASBiz_FuncDev_webview.json", false, null);
    Object localObject3;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "receive WhiteListConfig data: " + ((JSONObject)localObject1).toString());
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("vipGrayConfig2");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        if (j >= ((JSONArray)localObject1).length()) {
          break label280;
        }
        localObject3 = ((JSONArray)localObject1).optJSONObject(j);
        if ((localObject3 == null) || (!a((JSONObject)localObject3))) {
          break label241;
        }
      }
    }
    label280:
    for (localObject1 = ((JSONObject)localObject3).optJSONObject("configs");; localObject1 = null)
    {
      localObject3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject2 = ((AppRuntime)localObject2).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + (String)localObject3, 4).edit();
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "readAndSaveSonicWhiteListConfig: " + ((JSONObject)localObject1).toString());
        }
        ((SharedPreferences.Editor)localObject2).putString("key_sonic_white_list_conifg", ((JSONObject)localObject1).toString());
      }
      for (;;)
      {
        this.h = ((JSONObject)localObject1);
        ((SharedPreferences.Editor)localObject2).apply();
        return;
        label241:
        j += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig encounter error!. so remove all sonic white list.");
        ((SharedPreferences.Editor)localObject2).remove("key_sonic_white_list_conifg");
      }
      QLog.d("AuthorizeConfig", 1, "readAndSaveSonicWhiteListConfig VasQuickUpdateManager.SCID_FUNCDEV_WEBVIEW is null");
      return;
    }
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: invokestatic 890	nji:b	()I
    //   3: istore_2
    //   4: iload_2
    //   5: iconst_1
    //   6: if_icmpne +141 -> 147
    //   9: iconst_1
    //   10: istore_1
    //   11: aload_0
    //   12: iload_1
    //   13: putfield 132	nhe:jdField_a_of_type_Int	I
    //   16: invokestatic 892	nji:d	()Ljava/lang/String;
    //   19: astore_3
    //   20: aload_3
    //   21: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +167 -> 191
    //   27: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +29 -> 59
    //   33: ldc 161
    //   35: iconst_2
    //   36: new 255	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 894
    //   46: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: new 80	org/json/JSONArray
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 363	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   68: putfield 896	nhe:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   71: invokestatic 898	nji:e	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: invokestatic 219	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   79: ifne +169 -> 248
    //   82: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +29 -> 114
    //   88: ldc 161
    //   90: iconst_2
    //   91: new 255	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 900
    //   101: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: new 80	org/json/JSONArray
    //   118: dup
    //   119: aload_3
    //   120: invokespecial 363	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   123: putfield 902	nhe:jdField_f_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   126: iload_2
    //   127: iconst_m1
    //   128: if_icmpeq +138 -> 266
    //   131: aload_0
    //   132: getfield 896	nhe:jdField_e_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   135: ifnull +131 -> 266
    //   138: aload_0
    //   139: getfield 902	nhe:jdField_f_of_type_OrgJsonJSONArray	Lorg/json/JSONArray;
    //   142: ifnull +124 -> 266
    //   145: iconst_1
    //   146: ireturn
    //   147: iconst_0
    //   148: istore_1
    //   149: goto -138 -> 11
    //   152: astore_3
    //   153: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -85 -> 71
    //   159: ldc 161
    //   161: iconst_2
    //   162: new 255	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 904
    //   172: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_3
    //   176: invokevirtual 380	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   179: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: goto -117 -> 71
    //   191: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq -123 -> 71
    //   197: ldc 161
    //   199: iconst_2
    //   200: ldc_w 906
    //   203: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: goto -135 -> 71
    //   209: astore_3
    //   210: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq -87 -> 126
    //   216: ldc 161
    //   218: iconst_2
    //   219: new 255	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 256	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 908
    //   229: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_3
    //   233: invokevirtual 380	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   236: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: goto -119 -> 126
    //   248: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -125 -> 126
    //   254: ldc 161
    //   256: iconst_2
    //   257: ldc_w 910
    //   260: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -137 -> 126
    //   266: iconst_0
    //   267: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	nhe
    //   10	139	1	j	int
    //   3	126	2	k	int
    //   19	101	3	str	String
    //   152	24	3	localJSONException1	JSONException
    //   209	24	3	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   59	71	152	org/json/JSONException
    //   114	126	209	org/json/JSONException
  }
  
  public boolean e(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_e_of_type_OrgJsonJSONArray == null) && (!e()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsConfig loadfromsp fail , url: " + nmj.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int k = this.jdField_e_of_type_OrgJsonJSONArray.length();
            if ((k != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_e_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label255;
                }
                if (!QLog.isColorLevel()) {
                  break label253;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsConfig hit , url: " + nmj.b(paramString, new String[0]) + " domain: " + str2);
                break label253;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsConfig check exception", paramString);
        }
      }
      return false;
      label253:
      return true;
      label255:
      j += 1;
    }
  }
  
  public String f(String paramString)
  {
    return a("a2", paramString, a("a2"));
  }
  
  public void f()
  {
    boolean bool = true;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject == null) || (!((AppRuntime)localObject).isLogin()))
    {
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp, runtime is null or is not login!");
      return;
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = ((AppRuntime)localObject).getApplication().getSharedPreferences("sp_sonic_white_list_config_" + str, 4).getString("key_sonic_white_list_conifg", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        this.h = new JSONObject((String)localObject);
        if (this.h == null) {
          e();
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject = new StringBuilder().append("loadSonicWhiteListConfigFromSp:  ");
        if (this.h == null) {
          break label176;
        }
        QLog.i("AuthorizeConfig", 2, bool);
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AuthorizeConfig", 2, "", localException);
        continue;
      }
      QLog.e("AuthorizeConfig", 1, "loadSonicWhiteListConfigFromSp is null!");
      continue;
      label176:
      bool = false;
    }
  }
  
  public boolean f(String paramString)
  {
    for (;;)
    {
      int j;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if ((this.jdField_f_of_type_OrgJsonJSONArray == null) && (!e()))
          {
            if (QLog.isColorLevel())
            {
              QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig loadfromsp fail , url: " + nmj.b(paramString, new String[0]));
              return false;
            }
          }
          else
          {
            String str1 = Uri.parse(paramString).getHost();
            int k = this.jdField_f_of_type_OrgJsonJSONArray.length();
            if ((k != 0) && (!TextUtils.isEmpty(str1)))
            {
              str1 = str1.toLowerCase();
              j = 0;
              if (j < k)
              {
                String str2 = this.jdField_f_of_type_OrgJsonJSONArray.optString(j, "");
                if ((TextUtils.isEmpty(str2)) || ((!TextUtils.equals(str1, str2)) && (!str1.endsWith("." + str2)))) {
                  break label255;
                }
                if (!QLog.isColorLevel()) {
                  break label253;
                }
                QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig hit , url: " + nmj.b(paramString, new String[0]) + " domain: " + str2);
                break label253;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AuthorizeConfig", 2, "forceHttpsExcludeConfig check fail , url empty!");
          return false;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AuthorizeConfig", 2, "forceHttpsExcludeConfig check exception", paramString);
        }
      }
      return false;
      label253:
      return true;
      label255:
      j += 1;
    }
  }
  
  public void g()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_e_of_type_Long < 86400000L) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, new Object[] { "cachePreloadPskeyList too often lastTime:", Long.valueOf(jdField_e_of_type_Long), " interval:", Long.valueOf(86400000L) });
      }
    }
    do
    {
      return;
      if (BaseApplicationImpl.getApplication().getRuntime().isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "cachePreloadPskeyList is not login");
    return;
    if (((aqun)aqlk.a().a(585)).jdField_a_of_type_Int == 1)
    {
      Object localObject3 = a("pskey");
      ArrayList localArrayList = new ArrayList(((Set)localObject3).size());
      ??? = new HashSet(20);
      Object localObject4 = WebViewConstant.DEFAULT_PSKEY_LIST;
      int k = localObject4.length;
      int j = 0;
      while (j < k)
      {
        ((HashSet)???).add(localObject4[j]);
        j += 1;
      }
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (!((HashSet)???).contains(localObject4)) {
          localArrayList.add(localObject4);
        }
      }
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
          if (QLog.isColorLevel())
          {
            if (this.jdField_a_of_type_JavaUtilArrayList != null)
            {
              j = this.jdField_a_of_type_JavaUtilArrayList.size();
              QLog.d("AuthorizeConfig", 2, new Object[] { "preloadPskey list:", Integer.valueOf(j), " waitPt4Token:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
            }
          }
          else
          {
            if (this.jdField_a_of_type_Boolean) {
              break;
            }
            h();
            jdField_e_of_type_Long = l;
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastPreloadPskey", jdField_e_of_type_Long).commit();
            return;
          }
        }
        j = 0;
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preloadPskey.");
  }
  
  public boolean g(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    String str;
    int j;
    boolean bool;
    if ((localObject != null) && (((Uri)localObject).isHierarchical()))
    {
      if (this.h == null) {
        f();
      }
      if (this.h != null)
      {
        str = ((Uri)localObject).getHost();
        localObject = ((Uri)localObject).getPath();
        if (this.h == null) {
          break label272;
        }
        JSONArray localJSONArray = this.h.optJSONArray(str);
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label272;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList, host: " + str + ", rules: " + localJSONArray.toString());
        }
        j = 0;
        if (j >= localJSONArray.length()) {
          break label272;
        }
        str = localJSONArray.optString(j);
        if ((str.equalsIgnoreCase((String)localObject)) || (str.equals("*"))) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorizeConfig", 2, "isInSonicWhiteList: " + bool + ", url: " + nmj.b(paramString, new String[0]));
      }
      return bool;
      if ((str.endsWith("*")) && (((String)localObject).startsWith(str.replace("/*", ""))))
      {
        bool = true;
      }
      else
      {
        j += 1;
        break;
        QLog.e("AuthorizeConfig", 1, "mSonicWhiteListConfig is null! ");
        label272:
        bool = false;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, "preloadPskey waiting");
      }
    }
    AppRuntime localAppRuntime;
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime.isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AuthorizeConfig", 2, "preloadPskey is not login");
    return;
    TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = jdField_a_of_type_JavaLangObject;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          if (j < 20) {
            localArrayList1.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
          } else {
            localArrayList2.add(this.jdField_a_of_type_JavaUtilArrayList.get(j));
          }
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 2, new Object[] { "preload:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), " cur:", Integer.valueOf(localArrayList1.size()), " left:", Integer.valueOf(localArrayList2.size()) });
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList2;
      if (localArrayList1.size() == 0) {
        break;
      }
      localObject2 = new String[localArrayList1.size()];
      j = 0;
      while (j < localArrayList1.size())
      {
        localObject2[j] = String.format("(%d)%s", new Object[] { Integer.valueOf(1048576), localArrayList1.get(j) });
        j += 1;
      }
      AuthorizeConfig.4 local4 = new AuthorizeConfig.4(this, localTicketManager, localObject1.getAccount(), (String[])localObject2);
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        local4.run();
        return;
      }
      ThreadManager.post(local4, 8, null, true);
      return;
      j += 1;
    }
  }
  
  public boolean h(String paramString)
  {
    Object localObject = Uri.parse(paramString).getScheme();
    if ((!"http".equals(localObject)) && (!"https".equals(localObject))) {
      return false;
    }
    localObject = a("a1");
    paramString = Uri.parse(paramString).getHost();
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.toLowerCase();
    }
    for (;;)
    {
      if (((Set)localObject).contains(paramString)) {
        return true;
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (b((String)((Iterator)localObject).next(), paramString)) {
          return true;
        }
      }
      return false;
    }
  }
  
  public void i()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_f_of_type_Long < 21600000L) {
      QLog.d("AuthorizeConfig", 1, "preload too often");
    }
    do
    {
      return;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if (l - jdField_f_of_type_Long < 21600000L)
        {
          QLog.d("AuthorizeConfig", 1, "preload too often");
          return;
        }
      }
      jdField_f_of_type_Long = l;
      ??? = BaseApplicationImpl.getApplication().getRuntime();
    } while ((!(??? instanceof QQAppInterface)) || ((!((AppRuntime)???).isLogin()) && (!"com.tencent.mobileqq".equals(MobileQQ.getMobileQQ().getQQProcessName()))));
    if (com.tencent.mobileqq.webprocess.WebAccelerateHelper.getInstance().getWebViewFeatureParams()[3].intValue() == 1)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)???).getManager(2);
      Object localObject3 = a("pt4_token");
      String[] arrayOfString = new String[((Set)localObject3).size()];
      localObject3 = ((Set)localObject3).iterator();
      int j = 0;
      while (((Iterator)localObject3).hasNext())
      {
        arrayOfString[j] = String.format("(%d)%s", new Object[] { Integer.valueOf(134217728), (String)((Iterator)localObject3).next() });
        j += 1;
      }
      ??? = new AuthorizeConfig.5(this, localTicketManager, ((AppRuntime)???).getAccount(), arrayOfString);
      if (Looper.myLooper() != Looper.getMainLooper()) {
        ((Runnable)???).run();
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        ThreadManager.post((Runnable)???, 8, null, true);
      }
    }
    QLog.d("AuthorizeConfig", 1, "do not support preload.");
  }
  
  public boolean i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
      if (!"about:blank".equalsIgnoreCase(paramString)) {}
    }
    else
    {
      localObject = "https://localhost/";
    }
    Uri localUri = Uri.parse((String)localObject);
    paramString = localUri.getScheme();
    if ((!"http".equals(paramString)) && (!"https".equals(paramString))) {
      return false;
    }
    Object localObject = this.i;
    System.currentTimeMillis();
    paramString = (String)localObject;
    if (localObject == null) {}
    label167:
    label211:
    label222:
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Nkd.a();
        if (paramString == null)
        {
          try
          {
            localObject = new JSONObject("{\"*.qq.com\":[\"*\"],\"*.tencent.com\":[\"*\"],\"*.soso.com\":[\"*\"],\"*.paipai.com\":[\"*\"],\"*.tenpay.com\":[\"*\"],\"*.yixun.com\":[\"*\"],\"*.myapp.com\":[\"*\"],\"*.wanggou.com\":[\"*\"],\"*.qzone.com\":[\"*\"],\"*.weishi.com\":[\"*\"],\"*.weiyun.com\":[\"*\"],\"*\":[\"tel\",\"sms\",\"http\",\"https\",\"file\", \"mqqc2b\"]}");
            paramString = (String)localObject;
          }
          catch (JSONException localJSONException)
          {
            JSONArray localJSONArray;
            continue;
            String str = localUri.getHost();
            paramString = str;
            if (TextUtils.isEmpty(str)) {
              break label167;
            }
            paramString = str.toLowerCase();
            int k = localJSONArray.length();
            int j = 0;
            if (j >= k) {
              break label222;
            }
            str = localJSONArray.optString(j);
            if ((str == null) || (!str.equals("*"))) {
              break label211;
            }
            while (!b(str, paramString))
            {
              j += 1;
              break;
            }
            return true;
            return false;
          }
          localJSONArray = paramString.names();
          if (localJSONArray == null) {
            return false;
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 2, "Decode mSchemeConfig error");
        }
        paramString = (String)localObject;
      }
    }
  }
  
  public void j()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio main process loadFuncDevWebViewConfig");
      localObject1 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", true, null);
    }
    while (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return " + ((JSONObject)localObject1).toString());
      }
      Object localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewSwitchAioConfig");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.jdField_d_of_type_OrgJsonJSONObject = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("WebViewWhiteScreenDomains");
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0)) {
        this.jdField_e_of_type_OrgJsonJSONObject = ((JSONArray)localObject2).optJSONObject(0);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("arkShareWhiteList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
        this.jdField_f_of_type_OrgJsonJSONObject = ((JSONArray)localObject1).optJSONObject(0);
      }
      return;
      localObject2 = VasQuickUpdateManager.getJSONFromLocal((AppRuntime)localObject1, "VASBiz_FuncDev_webview.json", false, null);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio calling main process to download FuncDevWebViewConfig");
        localObject1 = arph.a("download_FuncDev_webview", "", 0, null);
        arui.a().b((Bundle)localObject1);
        localObject1 = localObject2;
      }
    }
    QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio loadFuncDevWebViewConfig return null");
  }
  
  public boolean j(String paramString)
  {
    k();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      Object localObject1 = Uri.parse(paramString);
      Object localObject2 = ((Uri)localObject1).getScheme();
      if (("http".equals(localObject2)) || ("https".equals(localObject2)))
      {
        localObject1 = ((Uri)localObject1).getHost();
        localObject2 = this.jdField_d_of_type_OrgJsonJSONObject;
        if (QLog.isColorLevel()) {
          QLog.d("AuthorizeConfig", 1, "WebViewSwitchAio call canSwitchAIO url " + paramString + " config " + localObject2);
        }
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((JSONObject)localObject2).optInt("enable", 0) == 1))
        {
          paramString = ((JSONObject)localObject2).optJSONArray("domains");
          if (paramString != null)
          {
            int j = paramString.length() - 1;
            while (j >= 0)
            {
              if (((String)localObject1).endsWith(paramString.optString(j))) {
                return true;
              }
              j -= 1;
            }
          }
        }
      }
    }
  }
  
  public void k()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((l - this.jdField_c_of_type_Long < 1800000L) && (this.jdField_d_of_type_OrgJsonJSONObject != null) && (this.jdField_f_of_type_OrgJsonJSONObject != null)) {
        return;
      }
      this.jdField_c_of_type_Long = l;
      ThreadManager.post(new AuthorizeConfig.6(this), 5, null, false);
      return;
    }
    finally {}
  }
  
  public boolean k(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorizeConfig", 2, "[canShareArkMsg] ArkName: " + paramString + " ArkShareConfig: " + this.jdField_f_of_type_OrgJsonJSONObject);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    k();
    Object localObject = this.jdField_f_of_type_OrgJsonJSONObject;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("validArkNames");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = jdField_a_of_type_OrgJsonJSONArray;
    }
    int j = ((JSONArray)localObject).length() - 1;
    while (j >= 0)
    {
      if (paramString.equals(((JSONArray)localObject).optString(j))) {
        return true;
      }
      j -= 1;
    }
    return false;
  }
  
  public boolean l(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.g == null) {
      d();
    }
    Object localObject = this.g;
    JSONArray localJSONArray = null;
    if (localObject != null) {
      localJSONArray = ((JSONObject)localObject).optJSONArray("domainList");
    }
    if (localObject != null)
    {
      localObject = localJSONArray;
      if (localJSONArray != null) {}
    }
    else
    {
      localObject = new JSONArray();
      ((JSONArray)localObject).put("*.vip.qq.com");
    }
    int j = ((JSONArray)localObject).length() - 1;
    while (j >= 0)
    {
      if (b(((JSONArray)localObject).optString(j), paramString)) {
        return true;
      }
      j -= 1;
    }
    return false;
  }
  
  public boolean m(String paramString)
  {
    k();
    Object localObject = this.jdField_e_of_type_OrgJsonJSONObject;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 1, "isInWhiteScreenWhiteList is called of domain " + paramString + " config " + localObject);
    }
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = ((JSONObject)localObject).optJSONArray("domains");
      if (localObject != null)
      {
        int j = ((JSONArray)localObject).length() - 1;
        while (j >= 0)
        {
          if (paramString.endsWith(((JSONArray)localObject).optString(j))) {
            return true;
          }
          j -= 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nhe
 * JD-Core Version:    0.7.0.1
 */