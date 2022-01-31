import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.HtmlOffline.1;
import com.tencent.biz.common.offline.HtmlOffline.2;
import com.tencent.biz.common.offline.HtmlOffline.4;
import com.tencent.biz.common.offline.HtmlOffline.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;

public class mze
{
  public static int a;
  private static Context a;
  public static ConcurrentHashMap<String, String> a;
  public static mzb a;
  public static mzr a;
  public static mzs a;
  public static mzt a;
  public static boolean a;
  protected static final String[] a;
  protected static final String[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "config.json", "verify.json", "verify.signature" };
    b = new String[] { "0", "1" };
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Mzt = new mzp();
    jdField_a_of_type_Mzs = new mzv();
    jdField_a_of_type_Mzr = new mzu();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_Mzb = new mzf();
  }
  
  protected static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 4).getInt("expire_" + paramString, 0);
  }
  
  protected static long a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("local_html", 4).getLong("last_up_" + paramString, 0L);
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = b(mzk.b());
      if (!TextUtils.isEmpty(str)) {
        localStringBuffer.append(str);
      }
    }
    if (jdField_a_of_type_AndroidContentContext == null) {
      jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    }
    String str = b(mzk.a());
    if (!TextUtils.isEmpty(str))
    {
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append(",");
      }
      localStringBuffer.append(str);
    }
    if (jdField_a_of_type_Mzr.a()) {
      jdField_a_of_type_Mzr.b("HtmlCheckUpdate", 2, "getLocalOfflineVersions:" + localStringBuffer.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long l1;
    long l2;
    do
    {
      do
      {
        return null;
        paramString = a(paramString);
      } while (paramString == null);
      l1 = System.currentTimeMillis();
      l2 = paramString.optLong("expired", 0L);
    } while ((l2 > 0L) && (l1 > l2));
    try
    {
      paramString = paramString.getString("version");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return paramString1;
    }
    if (paramString1.contains("#"))
    {
      String[] arrayOfString = paramString1.split("\\#");
      String str = arrayOfString[0];
      paramString1 = "";
      int i = 1;
      int j = arrayOfString.length;
      while (i < j)
      {
        paramString1 = paramString1 + "#" + arrayOfString[i];
        i += 1;
      }
      if (str.contains("?")) {
        return str.replace("?", new StringBuilder().append("?").append(paramString2).append("&").toString()) + paramString1;
      }
      return str + "?" + paramString2 + paramString1;
    }
    if (paramString1.contains("?")) {
      return paramString1.replace("?", "?" + paramString2 + "&");
    }
    return paramString1 + "?" + paramString2;
  }
  
  @SuppressLint({"NewApi"})
  public static mzi a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString2)) || (!paramString2.startsWith("http")))
    {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "shouldInterceptRequest: businessId null ");
      }
      return null;
    }
    Object localObject = mzk.a(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    paramString1 = (String)localObject + paramString1;
    paramString2 = d(paramString2);
    localObject = paramString1 + "/" + paramString2;
    if (!new File((String)localObject).exists())
    {
      if (jdField_a_of_type_Mzr.b()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 4, "getResponse local file not exists :" + paramString2);
      }
      return null;
    }
    paramString1 = "text/html";
    if (paramString2.contains(".css")) {
      paramString1 = "text/css";
    }
    for (;;)
    {
      if (jdField_a_of_type_Mzr.b()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 4, "getResponse ****************** :" + paramString2);
      }
      try
      {
        localObject = new BufferedInputStream(new FileInputStream((String)localObject));
        return new mzi(paramString1, (InputStream)localObject);
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        if (!jdField_a_of_type_Mzr.b()) {
          break label358;
        }
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 4, "getResponse get local file fail:" + paramString2);
      }
      if (paramString2.contains(".js")) {
        paramString1 = "application/x-javascript";
      } else if ((paramString2.contains(".jpg")) || (paramString2.contains(".gif")) || (paramString2.contains(".png")) || (paramString2.contains(".jpeg"))) {
        paramString1 = "image/*";
      }
    }
    label358:
    return null;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 75	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   20: aload_1
    //   21: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 233
    //   26: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 22
    //   31: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: new 75	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 289
    //   48: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_0
    //   60: invokevirtual 293	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 299	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 304	nax:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   72: astore_0
    //   73: aload_1
    //   74: invokevirtual 309	java/io/InputStream:close	()V
    //   77: new 177	org/json/JSONObject
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 310	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 188	org/json/JSONException:printStackTrace	()V
    //   93: getstatic 53	mze:jdField_a_of_type_Mzr	Lmzr;
    //   96: invokeinterface 154 1 0
    //   101: ifeq +17 -> 118
    //   104: getstatic 53	mze:jdField_a_of_type_Mzr	Lmzr;
    //   107: ldc 156
    //   109: iconst_2
    //   110: ldc_w 312
    //   113: invokeinterface 226 4 0
    //   118: aconst_null
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: areturn
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   128: goto -51 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   0	131	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   77	86	88	org/json/JSONException
    //   59	68	120	java/io/IOException
    //   73	77	123	java/io/IOException
  }
  
  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      String str = mzk.a(paramString);
      if (!TextUtils.isEmpty(str))
      {
        paramString = new File(str + paramString + "/" + "config.json");
        if (paramString.exists()) {
          try
          {
            paramString = new FileInputStream(paramString);
            if (paramString != null) {
              str = nax.a(paramString);
            }
          }
          catch (IOException paramString)
          {
            try
            {
              paramString.close();
              try
              {
                paramString = new JSONObject(str);
                return paramString;
              }
              catch (JSONException paramString)
              {
                paramString.printStackTrace();
                return null;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
              paramString = paramString;
              paramString.printStackTrace();
              paramString = null;
            }
            catch (IOException paramString)
            {
              for (;;)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_AndroidContentContext == null)
    {
      a(new nau());
      a(new mzv());
      a(new mzu());
      a(BaseApplicationImpl.getContext());
    }
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    paramString = "last_up_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putLong(paramString, System.currentTimeMillis());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("local_html", 4);
    paramString = "expire_" + paramString;
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, mzb parammzb)
  {
    if (parammzb == null) {
      return;
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      parammzb.loaded(null, 1);
      return;
    }
    String str = mzk.b(paramString1);
    if (TextUtils.isEmpty(str))
    {
      parammzb.loaded(null, 3);
      return;
    }
    JSONObject localJSONObject = a(paramString1);
    if (localJSONObject != null)
    {
      l1 = 30L;
      try
      {
        l2 = localJSONObject.getLong("frequency");
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l2;
          localException.printStackTrace();
        }
      }
      l2 = (System.currentTimeMillis() - a(paramContext, paramString1)) / 60000L;
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "checkUpdate check freq:" + l1 + ", time:" + l2);
      }
      if (l2 < l1)
      {
        parammzb.loaded(null, 5);
        return;
      }
    }
    if (BidDownloader.a(paramString1))
    {
      parammzb.loaded(null, 7);
      return;
    }
    BidDownloader.a(paramString1);
    str = str + paramString1 + ".zip";
    long l1 = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept-Encoding", "gzip");
    jdField_a_of_type_Mzt.c(new HtmlOffline.6(paramContext, paramString2, paramString1, str, l1, parammzb, localHashMap));
  }
  
  protected static void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    a(paramString, paramInt1, paramLong, paramInt2, "lixian_update", "");
  }
  
  public static void a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        i = Integer.valueOf(paramString1).intValue();
        if (paramString3 != null) {
          break label288;
        }
        paramString1 = "";
        paramString3 = "";
        try
        {
          if (jdField_a_of_type_AndroidContentContext == null) {
            jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
          }
          String str = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
          paramString3 = str;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          localNameNotFoundException.printStackTrace();
          continue;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        j = paramInt2;
        if (paramInt2 == -1)
        {
          j = paramInt2;
          if (jdField_a_of_type_AndroidContentContext != null) {
            j = nar.a(jdField_a_of_type_AndroidContentContext);
          }
        }
        if (jdField_a_of_type_Boolean)
        {
          nav.a(null, "P_CliOper", "Pb_account_lifeservice", paramString3, "mp_msg_sys_14", paramString2, i, paramInt1, "" + paramLong, "3", "" + j, paramString1);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        i = -1;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("HtmlCheckUpdate", 2, "reportDownTime qver=" + paramString3 + ", mainAction=" + paramString2 + ", bid=" + i + ", code=" + paramInt1 + ", time=" + paramLong + ", netType=" + j + ", ex5=" + paramString1);
      return;
      label288:
      paramString1 = paramString3;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    xle.d(paramString2);
    nax.a(paramString1);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, new Object[] { "dealVerifyErroFile fileDir:", paramString1, " mBussinessId:", paramString2 });
    }
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramString, paramAppRuntime, true, jdField_a_of_type_Mzb);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, mzb parammzb)
  {
    if (parammzb == null) {
      return;
    }
    jdField_a_of_type_Mzt.a(new HtmlOffline.2(paramString, paramAppRuntime, parammzb));
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean)
  {
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramString);
    paramString = new HashMap(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = a(str);
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.put(str, localObject2);
        }
      }
      else
      {
        paramString.put(str, "0");
      }
    }
    a(paramAppRuntime, paramString, parammzb, paramBoolean, false, false);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean, int paramInt)
  {
    a(paramString, paramAppRuntime, parammzb, paramBoolean, 5, false);
  }
  
  @Deprecated
  public static void a(String paramString, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    b(paramString, paramAppRuntime, parammzb, true, paramInt, paramBoolean2);
  }
  
  public static void a(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, mzb parammzb)
  {
    if (jdField_a_of_type_Mzr.a()) {
      jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUp,url=" + paramString + ",callback=" + parammzb);
    }
    if (parammzb == null) {
      return;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    int j = mvv.a(true).a(paramString);
    int i = j;
    if (j == 0) {
      i = 5;
    }
    a(str, paramAppRuntime, parammzb, paramBoolean, i);
  }
  
  public static void a(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (parammzb == null) {
      return;
    }
    if ((paramAppRuntime == null) || (paramArrayList.size() == 0))
    {
      parammzb.loaded("{\"r\":-1}", -1);
      return;
    }
    b(paramArrayList, paramAppRuntime, parammzb, paramBoolean1, paramBoolean2);
  }
  
  public static void a(AppRuntime paramAppRuntime, HashMap<String, String> paramHashMap, mzb parammzb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate");
    }
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication().getApplicationContext(), mxh.class);
    localNewIntent.putExtra("cmd", "offlinepkg.check");
    OfflinePkg.ReqBody localReqBody = new OfflinePkg.ReqBody();
    localReqBody.uint32_cmd.set(3);
    localReqBody.uint32_platform.set(3);
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      QLog.d("HtmlCheckUpdate", 1, String.format("check update, QQ Version: %s", new Object[] { "8.2.8.4440" }));
      if (QLog.isColorLevel()) {
        QLog.d("OfflineCheck", 2, "send check" + paramHashMap.toString());
      }
    }
    localReqBody.str_qver.set(ByteStringMicro.copyFrom("8.2.8.4440".getBytes()));
    localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
    i = nar.a(paramAppRuntime.getApplication());
    localReqBody.int32_network.set(i);
    localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
    Iterator localIterator = paramHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      String str = (String)paramHashMap.get(localObject);
      for (;;)
      {
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            k = Integer.valueOf(str).intValue();
            j = i;
            i = k;
            if (j == 0) {
              break;
            }
            localObject = new OfflinePkg.BidPkg();
            ((OfflinePkg.BidPkg)localObject).uint32_bid.set(j);
            ((OfflinePkg.BidPkg)localObject).uint32_pkg_id.add(Integer.valueOf(i));
            localReqBody.st_bid_pkg.add((MessageMicro)localObject);
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              int k;
              int j = i;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            continue;
          }
          localNumberFormatException1 = localNumberFormatException1;
          i = 0;
          localNumberFormatException1.printStackTrace();
          k = 0;
          j = i;
          i = k;
          continue;
        }
        catch (Exception localException1)
        {
          j = 0;
        }
        i = 0;
      }
    }
    try
    {
      localNewIntent.putExtra("data", localReqBody.toByteArray());
      localNewIntent.setObserver(new mzg(localNewIntent, parammzb, paramBoolean1, paramBoolean3, paramAppRuntime, paramBoolean2));
      paramAppRuntime.startServlet(localNewIntent);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("HtmlCheckUpdate", 2, "offline check update exception!", paramAppRuntime);
      return;
    }
  }
  
  public static void a(mzr parammzr)
  {
    jdField_a_of_type_Mzr = parammzr;
  }
  
  public static void a(mzs parammzs)
  {
    jdField_a_of_type_Mzs = parammzs;
  }
  
  public static void a(mzt parammzt)
  {
    jdField_a_of_type_Mzt = parammzt;
  }
  
  /* Error */
  protected static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: invokevirtual 293	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 299	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: new 761	java/io/FileOutputStream
    //   21: dup
    //   22: new 235	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokespecial 762	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: sipush 4096
    //   37: newarray byte
    //   39: astore_1
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 766	java/io/InputStream:read	([B)I
    //   45: istore_3
    //   46: iload_3
    //   47: iconst_m1
    //   48: if_icmpne +29 -> 77
    //   51: aload_2
    //   52: invokevirtual 769	java/io/FileOutputStream:flush	()V
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 309	java/io/InputStream:close	()V
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 770	java/io/FileOutputStream:close	()V
    //   71: iconst_1
    //   72: istore 4
    //   74: iload 4
    //   76: ireturn
    //   77: aload_2
    //   78: aload_1
    //   79: iconst_0
    //   80: iload_3
    //   81: invokevirtual 774	java/io/FileOutputStream:write	([BII)V
    //   84: goto -44 -> 40
    //   87: astore 5
    //   89: aload_0
    //   90: astore_1
    //   91: aload_2
    //   92: astore_0
    //   93: aload 5
    //   95: astore_2
    //   96: aload_2
    //   97: invokevirtual 313	java/io/IOException:printStackTrace	()V
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 309	java/io/InputStream:close	()V
    //   108: aload_0
    //   109: ifnull -35 -> 74
    //   112: aload_0
    //   113: invokevirtual 770	java/io/FileOutputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_0
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload 5
    //   126: astore_2
    //   127: aload_0
    //   128: ifnull +7 -> 135
    //   131: aload_0
    //   132: invokevirtual 309	java/io/InputStream:close	()V
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 770	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: goto -83 -> 63
    //   149: astore_0
    //   150: goto -79 -> 71
    //   153: astore_1
    //   154: goto -46 -> 108
    //   157: astore_0
    //   158: goto -23 -> 135
    //   161: astore_0
    //   162: goto -19 -> 143
    //   165: astore_1
    //   166: aload 5
    //   168: astore_2
    //   169: goto -42 -> 127
    //   172: astore_1
    //   173: goto -46 -> 127
    //   176: astore_2
    //   177: aload_1
    //   178: astore 5
    //   180: aload_2
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload 5
    //   186: astore_0
    //   187: goto -60 -> 127
    //   190: astore_2
    //   191: aconst_null
    //   192: astore_0
    //   193: aload 6
    //   195: astore_1
    //   196: goto -100 -> 96
    //   199: astore_2
    //   200: aconst_null
    //   201: astore 5
    //   203: aload_0
    //   204: astore_1
    //   205: aload 5
    //   207: astore_0
    //   208: goto -112 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   0	211	1	paramString1	String
    //   0	211	2	paramString2	String
    //   45	36	3	i	int
    //   7	68	4	bool	boolean
    //   1	1	5	localObject1	Object
    //   87	80	5	localIOException	IOException
    //   178	28	5	str	String
    //   4	190	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	40	87	java/io/IOException
    //   40	46	87	java/io/IOException
    //   51	55	87	java/io/IOException
    //   77	84	87	java/io/IOException
    //   112	116	118	java/io/IOException
    //   9	18	121	finally
    //   59	63	145	java/io/IOException
    //   67	71	149	java/io/IOException
    //   104	108	153	java/io/IOException
    //   131	135	157	java/io/IOException
    //   139	143	161	java/io/IOException
    //   18	34	165	finally
    //   34	40	172	finally
    //   40	46	172	finally
    //   51	55	172	finally
    //   77	84	172	finally
    //   96	100	176	finally
    //   9	18	190	java/io/IOException
    //   18	34	199	java/io/IOException
  }
  
  public static boolean a(Context paramContext, String paramString, mzc parammzc)
  {
    if (jdField_a_of_type_Mzr.a()) {
      jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,url:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Uri.parse(paramString).getQueryParameter("_bid");
    if (TextUtils.isEmpty(str))
    {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,business id is null!");
      }
      return false;
    }
    if (paramContext == null)
    {
      a(str, 3, 0L, 4, "lixian_cover", "0");
      return false;
    }
    if (mzk.a(str) == null)
    {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,initEnv fail!");
      }
      a(str, 2, 0L, nar.a(paramContext), "lixian_cover", "0");
      return false;
    }
    if (Arrays.asList(b).contains(str))
    {
      a(str, 4, 0L, nar.a(paramContext), "lixian_cover", "0");
      return false;
    }
    if (jdField_a_of_type_Mzt == null)
    {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:transToLocalUrl,threadManager is null");
      }
      return false;
    }
    jdField_a_of_type_Mzt.b(new HtmlOffline.1(paramContext, paramString, parammzc));
    return true;
  }
  
  protected static boolean a(String paramString)
  {
    String str1 = mzk.b(paramString);
    str1 = str1 + paramString + ".zip";
    String str2 = mzk.a(paramString);
    str2 = str2 + paramString;
    File localFile = new File(str2 + "/b.zip");
    if (jdField_a_of_type_Mzr.a()) {
      jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "combine zip" + paramString);
    }
    paramString = new File(str1);
    if ((localFile.exists()) && (paramString.exists())) {
      try
      {
        if (paramString.isDirectory())
        {
          QLog.e("HtmlCheckUpdate", 1, "FXXX! This is a wrong patch file! " + str1);
          paramString.delete();
          return false;
        }
        boolean bool = BspatchUtil.a(str2 + "/b.zip", str1, str1);
        return bool;
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  public static boolean a(String paramString1, Context paramContext, String paramString2, mzc parammzc)
  {
    return a(paramContext, "http://" + paramString1 + "?_bid=" + paramString2, parammzc);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "verfyFile: businessId null ");
      }
    }
    long l;
    do
    {
      return false;
      String str = mzk.a(paramString1);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString1;
      if (!new File(str).exists()) {
        return true;
      }
      paramString2 = d(paramString2);
      l = System.currentTimeMillis();
      if (nas.c(paramString2, str, paramString1)) {
        break;
      }
      a(str, paramString1);
    } while (!jdField_a_of_type_Mzr.a());
    jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "verfySingleFile fail :" + paramString2);
    return false;
    if (jdField_a_of_type_Mzr.b()) {
      jdField_a_of_type_Mzr.b("HtmlCheckUpdate", 4, "verifyFile:time=" + (System.currentTimeMillis() - l) + ", file:" + paramString2);
    }
    return true;
  }
  
  protected static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        int i = 0;
        for (;;)
        {
          if ((i < paramString.length) && (i < 100))
          {
            Object localObject = paramString[i];
            JSONObject localJSONObject;
            if ((localObject.isDirectory()) && (TextUtils.isDigitsOnly(localObject.getName())))
            {
              localJSONObject = a(localObject.getName());
              if (localJSONObject == null) {}
            }
            try
            {
              localStringBuffer.append(localObject.getName() + "|" + localJSONObject.getString("version") + ",");
              i += 1;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                localJSONException.printStackTrace();
              }
            }
          }
        }
        if (localStringBuffer.length() > 0) {
          localStringBuffer.delete(localStringBuffer.length() - 1, localStringBuffer.length());
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime)
  {
    a(paramString, paramAppRuntime, false, jdField_a_of_type_Mzb);
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (jdField_a_of_type_Mzr.a()) {
      jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId " + paramString);
    }
    if (parammzb == null) {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId, callback is null!");
      }
    }
    for (;;)
    {
      return;
      if (mzk.a(paramString) == null)
      {
        if (jdField_a_of_type_Mzr.a()) {
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,no sd card!");
        }
        parammzb.loaded(null, 3);
        return;
      }
      if (Arrays.asList(b).contains(paramString))
      {
        if (jdField_a_of_type_Mzr.a()) {
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,do not update");
        }
      }
      else if ((paramInt > 60) || (paramInt < 0))
      {
        if (jdField_a_of_type_Mzr.a()) {
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpByBusinessId,delayed too long.");
        }
      }
      else
      {
        if ((paramAppRuntime == null) || (!paramAppRuntime.isLogin()))
        {
          QLog.w("HtmlCheckUpdate", 1, "app == null or user not login.");
          return;
        }
        JSONObject localJSONObject = a(paramString);
        long l2 = 30L;
        long l1 = l2;
        if (localJSONObject != null) {}
        try
        {
          l1 = localJSONObject.getLong("frequency");
          l2 = (System.currentTimeMillis() - a(paramAppRuntime.getApplication(), paramString)) / 60000L;
          if (jdField_a_of_type_Mzr.a()) {
            jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:checkUpdate check freq:" + l1 + ", time:" + l2);
          }
          if ((!paramBoolean2) && (l2 < l1))
          {
            parammzb.loaded(null, 5);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
          if (BidDownloader.a(paramString))
          {
            if (jdField_a_of_type_Mzr.a()) {
              jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:" + paramString + " is downloading");
            }
            parammzb.loaded(null, 7);
            return;
          }
          a(paramAppRuntime.getApplication().getApplicationContext(), paramString);
          if (jdField_a_of_type_Mzt == null)
          {
            if (jdField_a_of_type_Mzr.a()) {
              jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "threadManager is null");
            }
          }
          else
          {
            HashMap localHashMap = new HashMap(1);
            int i = 0;
            if (localJSONObject != null) {
              i = localJSONObject.optInt("version", 0);
            }
            localHashMap.put(paramString, i + "");
            jdField_a_of_type_Mzt.a(new HtmlOffline.4(paramInt, paramString, paramAppRuntime, localHashMap, parammzb, paramBoolean1, paramBoolean2));
          }
        }
      }
    }
  }
  
  public static void b(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, mzb parammzb)
  {
    a(paramString, paramAppRuntime, parammzb, paramBoolean, 5);
  }
  
  private static void b(ArrayList<String> paramArrayList, AppRuntime paramAppRuntime, mzb parammzb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramArrayList.size() == 0) {
      return;
    }
    HashMap localHashMap = new HashMap(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      Object localObject = a(str);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("version");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localHashMap.put(str, localObject);
        }
      }
      else
      {
        localHashMap.put(str, "0");
      }
    }
    a(paramAppRuntime, localHashMap, parammzb, paramBoolean1, paramBoolean2, false);
  }
  
  protected static boolean b(String paramString)
  {
    for (;;)
    {
      String str2;
      File localFile2;
      int i;
      try
      {
        if (jdField_a_of_type_Mzr.a()) {
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip start:" + paramString);
        }
        bool1 = TextUtils.isEmpty(paramString);
        if (bool1)
        {
          bool1 = false;
          return bool1;
        }
        String str1 = mzk.b(paramString);
        if (TextUtils.isEmpty(str1))
        {
          if (!jdField_a_of_type_Mzr.a()) {
            break label538;
          }
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,zip root dir is null:");
          break label538;
        }
        str1 = str1 + paramString + ".zip";
        File localFile1 = new File(str1);
        if (!localFile1.exists())
        {
          if (!jdField_a_of_type_Mzr.a()) {
            break label543;
          }
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip:no zip ! : businessId:" + paramString);
          break label543;
        }
        String str3 = mzk.a(paramString);
        str2 = str3 + paramString;
        str3 = str3 + paramString + "_new";
        nax.a(str3);
        localFile2 = new File(str3);
        if (!localFile2.mkdirs())
        {
          if (!jdField_a_of_type_Mzr.a()) {
            break label548;
          }
          jdField_a_of_type_Mzr.b("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,mkdirs: error:" + str3);
          break label548;
        }
        long l = System.currentTimeMillis();
        i = nay.a(str1, str3);
        if (i > 0)
        {
          if (jdField_a_of_type_Int == 0) {
            jdField_a_of_type_Int = 2;
          }
          nax.b(str1);
          a(paramString, 13, 0L, i, "lixian_update", "0");
          if (!jdField_a_of_type_Mzr.a()) {
            break label533;
          }
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:doUpdateZip,unZipFolder fail!");
          bool2 = false;
          bool1 = bool2;
          if (!jdField_a_of_type_Mzr.a()) {
            continue;
          }
          jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "-->offline:time of unzip：" + (System.currentTimeMillis() - l) + ", isSuccess: " + bool2);
          bool1 = bool2;
          continue;
        }
        localFile1.renameTo(new File(str3 + "/b.zip"));
      }
      finally {}
      nax.a(str2);
      boolean bool2 = localFile2.renameTo(new File(str2));
      a(paramString, 13, 0L, i, "lixian_time", "0");
      continue;
      label533:
      bool2 = false;
      continue;
      label538:
      boolean bool1 = false;
      continue;
      label543:
      bool1 = false;
      continue;
      label548:
      bool1 = false;
    }
  }
  
  public static String c(String paramString)
  {
    String str = "file://" + mzk.b();
    if ((paramString == null) || (!paramString.startsWith(str))) {
      return "";
    }
    paramString = paramString.substring(str.length());
    int i = paramString.indexOf('/');
    if (i <= 0) {
      return "";
    }
    try
    {
      Integer.parseInt(paramString.substring(0, i), 10);
      paramString = paramString.substring(i + 1);
      if (paramString.length() > 0) {
        return "http://" + paramString;
      }
    }
    catch (NumberFormatException paramString)
    {
      return "";
    }
    return "";
  }
  
  protected static void c(String paramString, AppRuntime paramAppRuntime, boolean paramBoolean, mzb parammzb)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "parseExpire:" + paramString);
    }
    ArrayList localArrayList;
    JSONObject localJSONObject;
    label143:
    int k;
    do
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("data");
        localArrayList = new ArrayList();
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          localJSONObject = paramString.optJSONObject(i);
          if (localJSONObject != null) {
            break label143;
          }
          i += 1;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i("HtmlCheckUpdate", 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      k = localJSONObject.optInt("code");
    } while ((k <= 0) || (k >= 10));
    int m = localJSONObject.optInt("bid");
    localArrayList.add(m + "");
    BidDownloader localBidDownloader = new BidDownloader(m + "", paramAppRuntime, parammzb, true, k);
    localBidDownloader.d = localJSONObject.optInt("id");
    if (localJSONObject.optInt("isWifi", 0) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localBidDownloader.f = bool;
      localBidDownloader.jdField_a_of_type_Boolean = paramBoolean;
      localBidDownloader.jdField_c_of_type_JavaLangString = localJSONObject.optString("url");
      localBidDownloader.jdField_c_of_type_Int = localJSONObject.optInt("filesize");
      localBidDownloader.a();
      break;
    }
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (jdField_a_of_type_Mzr.a()) {
        jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "verfySign: businessId null ");
      }
    }
    do
    {
      return false;
      String str = mzk.a(paramString);
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      str = str + paramString;
      if (!new File(str).exists()) {
        return true;
      }
      if (nas.b(str, paramString)) {
        return true;
      }
      a(str, paramString);
    } while (!jdField_a_of_type_Mzr.a());
    jdField_a_of_type_Mzr.a("HtmlCheckUpdate", 2, "verfySign fail :" + paramString);
    return false;
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return null;
      i = paramString.indexOf(":");
    } while ((i < 0) || (i + 3 >= paramString.length()));
    String[] arrayOfString = paramString.substring(i + 3).split("\\?");
    paramString = arrayOfString;
    if (arrayOfString[0].contains("#")) {
      paramString = arrayOfString[0].split("\\#");
    }
    return paramString[0];
  }
  
  public static boolean d(String paramString)
  {
    String str = mzk.b(paramString);
    return new File(str + paramString + ".zip").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     mze
 * JD-Core Version:    0.7.0.1
 */