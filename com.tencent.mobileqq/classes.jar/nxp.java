import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.4;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class nxp
  implements bmxe, DownloadListener
{
  protected Context a;
  protected Handler a;
  private ArrayList<olv> a;
  public List<orb> a;
  protected Handler b;
  protected List<orb> b;
  
  public nxp(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    bmxh.a().a(this);
    bisa.a().a(this);
  }
  
  public static int a(WadlResult paramWadlResult)
  {
    int i = 5;
    if (4 == paramWadlResult.jdField_b_of_type_Int) {
      i = 3;
    }
    while (6 == paramWadlResult.jdField_b_of_type_Int) {
      return i;
    }
    if (5 == paramWadlResult.jdField_b_of_type_Int) {
      return 4;
    }
    if ((9 == paramWadlResult.jdField_b_of_type_Int) || (10 == paramWadlResult.jdField_b_of_type_Int)) {
      return 1;
    }
    if (7 == paramWadlResult.jdField_b_of_type_Int) {
      return 6;
    }
    return 0;
  }
  
  protected static String a(InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aload_3
    //   13: areturn
    //   14: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +37 -> 54
    //   20: ldc 122
    //   22: iconst_2
    //   23: new 124	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   30: ldc 127
    //   32: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 132
    //   41: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_1
    //   45: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +28 -> 85
    //   60: ldc 122
    //   62: iconst_2
    //   63: new 124	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   70: ldc 142
    //   72: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: new 144	java/net/URL
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 147	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 151	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 153	java/net/HttpURLConnection
    //   99: astore_2
    //   100: aload_2
    //   101: ldc 155
    //   103: invokevirtual 158	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: ldc 160
    //   109: ldc 162
    //   111: invokevirtual 166	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_2
    //   115: ldc 168
    //   117: ldc 170
    //   119: invokevirtual 166	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: ldc 172
    //   125: ldc 174
    //   127: invokevirtual 166	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_2
    //   131: sipush 3000
    //   134: invokevirtual 178	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   137: aload_2
    //   138: sipush 3000
    //   141: invokevirtual 181	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   144: aload_2
    //   145: invokevirtual 185	java/net/HttpURLConnection:getResponseCode	()I
    //   148: sipush 200
    //   151: if_icmpne +101 -> 252
    //   154: aload_2
    //   155: invokevirtual 189	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   158: invokestatic 191	nxp:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   161: astore_0
    //   162: aload_0
    //   163: invokestatic 114	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifne +27 -> 193
    //   169: new 193	org/json/JSONObject
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 194	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   177: invokestatic 197	nxp:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: astore_3
    //   183: aload_2
    //   184: ifnull -172 -> 12
    //   187: aload_2
    //   188: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   191: aload_0
    //   192: areturn
    //   193: ldc 122
    //   195: iconst_1
    //   196: ldc 202
    //   198: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload 4
    //   203: astore_0
    //   204: goto -23 -> 181
    //   207: astore 4
    //   209: aload_2
    //   210: astore_0
    //   211: aload 4
    //   213: astore_2
    //   214: ldc 122
    //   216: iconst_1
    //   217: new 124	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   224: ldc 204
    //   226: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_2
    //   230: invokevirtual 205	java/lang/Exception:toString	()Ljava/lang/String;
    //   233: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_0
    //   243: ifnull -231 -> 12
    //   246: aload_0
    //   247: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   250: aconst_null
    //   251: areturn
    //   252: ldc 122
    //   254: iconst_1
    //   255: new 124	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   262: ldc 207
    //   264: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 185	java/net/HttpURLConnection:getResponseCode	()I
    //   271: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload 4
    //   282: astore_0
    //   283: goto -102 -> 181
    //   286: astore_3
    //   287: aload_2
    //   288: astore_0
    //   289: aload_3
    //   290: astore_2
    //   291: aload_0
    //   292: ifnull +7 -> 299
    //   295: aload_0
    //   296: invokevirtual 200	java/net/HttpURLConnection:disconnect	()V
    //   299: aload_2
    //   300: athrow
    //   301: astore_2
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -13 -> 291
    //   307: astore_2
    //   308: goto -17 -> 291
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_0
    //   314: goto -100 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	paramString	String
    //   0	317	1	paramInt	int
    //   99	201	2	localObject1	Object
    //   301	1	2	localObject2	Object
    //   307	1	2	localObject3	Object
    //   311	1	2	localException1	Exception
    //   4	179	3	str	String
    //   286	4	3	localObject4	Object
    //   1	201	4	localObject5	Object
    //   207	74	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   100	181	207	java/lang/Exception
    //   193	201	207	java/lang/Exception
    //   252	280	207	java/lang/Exception
    //   100	181	286	finally
    //   193	201	286	finally
    //   252	280	286	finally
    //   85	100	301	finally
    //   214	242	307	finally
    //   85	100	311	java/lang/Exception
  }
  
  protected static String a(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        paramJSONObject = paramJSONObject.optString("apkUrl");
        localObject = paramJSONObject;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ADBaseAppDownloadManager", 2, " parseDestLinkJson destLink = " + paramJSONObject);
            return paramJSONObject;
          }
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramJSONObject = "";
        }
      }
    }
    localException1.printStackTrace();
    QLog.d("ADBaseAppDownloadManager", 1, "parseDestLinkJson exception :" + localException1.toString());
    return paramJSONObject;
  }
  
  private void a(Activity paramActivity, orb paramorb)
  {
    int i = 0;
    if ((paramActivity == null) || (paramorb == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramorb.c)) && (!TextUtils.isEmpty(paramorb.jdField_b_of_type_JavaLangString))) {
      paramorb.c = a(paramorb.jdField_b_of_type_JavaLangString, 0);
    }
    String str1 = paramorb.d;
    String str2 = paramorb.jdField_a_of_type_JavaLangString;
    String str3 = paramorb.c;
    String str4 = paramorb.e;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      }
      for (;;)
      {
        a(paramorb, 6, i);
        return;
        if (paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
          i = paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
        } else if (paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
          i = paramorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bivp.f, str1);
    localBundle.putString(bivp.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bivp.j, str3);
    localBundle.putString(bivp.l, str4);
    localBundle.putInt(bivp.k, 2);
    localBundle.putInt(bivp.E, 0);
    localBundle.putBoolean(bivp.x, false);
    localBundle.putInt(bivp.H, 0);
    localBundle.putBoolean(bivp.y, true);
    localBundle.putBoolean(bivp.h, true);
    localBundle.putBoolean(bivp.r, false);
    localBundle.putBoolean(bivp.J, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(str3));
    if (!TextUtils.isEmpty(paramorb.f)) {
      localBundle.putString(bivp.i, paramorb.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramorb)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramorb);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramorb);
    bise.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  public static boolean a(Context paramContext, orb paramorb)
  {
    return b(paramContext, paramorb);
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return false;
      localDownloadInfo = bisa.a().b(paramString);
    } while (localDownloadInfo == null);
    String str = "";
    if (!TextUtils.isEmpty(localDownloadInfo.l)) {
      str = localDownloadInfo.l;
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (new File(str).exists()) {
        bool1 = true;
      }
    }
    oqh.a("ADBaseAppDownloadManager", "isPkgExist(" + bool1 + ") url:" + paramString + ", path:" + str);
    return bool1;
  }
  
  private static boolean a(orb paramorb, int paramInt)
  {
    do
    {
      try
      {
        if (!paramorb.jdField_a_of_type_Boolean) {
          break;
        }
        if (!TextUtils.isEmpty(paramorb.i)) {
          continue;
        }
        if (TextUtils.isEmpty(paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.Q)) {
          break;
        }
      }
      catch (Exception paramorb)
      {
        return false;
      }
      if (TextUtils.isEmpty(paramorb.i)) {}
      for (paramorb = paramorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.Q; new File(paramorb).exists(); paramorb = paramorb.i) {
        return true;
      }
    } while ((paramInt != 3) && (paramInt != 4));
    return false;
  }
  
  private void b()
  {
    bisa.a().b(this);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return false;
      localDownloadInfo = bisa.a().c(paramString);
    } while (localDownloadInfo == null);
    paramContext = "";
    if (!TextUtils.isEmpty(localDownloadInfo.l)) {
      paramContext = localDownloadInfo.l;
    }
    Object localObject = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      localObject = paramContext;
      if (!TextUtils.isEmpty(localDownloadInfo.d)) {
        localObject = bisa.a().b(localDownloadInfo.d).l;
      }
    }
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      bool1 = bool2;
      if (new File((String)localObject).exists()) {
        bool1 = true;
      }
    }
    oqh.a("ADBaseAppDownloadManager", "isPkgExist(" + bool1 + ") pkg:" + paramString + ", path:" + (String)localObject);
    return bool1;
  }
  
  private static boolean b(Context paramContext, orb paramorb)
  {
    if ((paramContext == null) || (paramorb == null) || (TextUtils.isEmpty(paramorb.d)) || (TextUtils.isEmpty(paramorb.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    if (paramorb.jdField_a_of_type_Boolean) {
      return a(paramorb, paramorb.jdField_a_of_type_Int);
    }
    if (TextUtils.isEmpty(paramorb.c)) {
      return b(paramContext, paramorb.d);
    }
    return a(paramorb.c);
  }
  
  private void e(orb paramorb)
  {
    if (paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramorb);
    }
    bmxh.a().a(paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramorb)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramorb);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramorb);
  }
  
  protected WadlParams a(orb paramorb)
  {
    WadlParams localWadlParams = new WadlParams(paramorb.jdField_a_of_type_JavaLangString, paramorb.d);
    localWadlParams.c = 7;
    localWadlParams.jdField_b_of_type_Int = 2;
    localWadlParams.n = (paramorb.g + "@" + paramorb.h);
    localWadlParams.e = paramorb.c;
    localWadlParams.j = paramorb.e;
    localWadlParams.p = "biz_src_feeds_kandianads";
    localWadlParams.l = "qq_vas_game";
    return localWadlParams;
  }
  
  public List<orb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    b();
    bmxh.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.2(this, paramDownloadInfo, paramInt));
  }
  
  protected void a(WadlResult paramWadlResult, int paramInt)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        orb localorb = (orb)localIterator.next();
        if ((localorb.jdField_a_of_type_JavaLangString != null) && (localorb.d != null) && (localorb.jdField_a_of_type_JavaLangString.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.jdField_a_of_type_JavaLangString)) && (localorb.d.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.f)))
        {
          int i = a(paramWadlResult);
          int j = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.jdField_b_of_type_JavaLangString)) {
            localorb.i = paramWadlResult.jdField_b_of_type_JavaLangString;
          }
          if (localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = i;
            localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = j;
          }
          if (localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
          {
            localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = i;
            localorb.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = j;
          }
          if (localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
          {
            localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.k = i;
            localorb.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j = j;
          }
          a(localorb, paramInt, paramWadlResult.d);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      oqh.a("ADBaseAppDownloadManager", "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(olv paramolv)
  {
    if (paramolv != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramolv);
    }
  }
  
  public void a(orb paramorb)
  {
    if (paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramorb);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramorb.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramorb))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(paramorb);
    }
    bmxh.a().a(localArrayList);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramorb)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramorb);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramorb);
  }
  
  protected void a(orb paramorb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startDownload " + paramorb.d + " progress " + paramInt);
    }
    paramorb.jdField_a_of_type_Int = 3;
    bisa.a().a(this);
    a((Activity)this.jdField_a_of_type_AndroidContentContext, paramorb);
  }
  
  public void a(orb paramorb, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      oqh.a("ADBaseAppDownloadManager", "updateUIState error : empty progressCallbacks");
    }
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.1(this, paramorb, paramInt1, paramInt2));
  }
  
  public void a(orb paramorb, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramorb);
    }
    b(paramorb);
  }
  
  public boolean a(orb paramorb)
  {
    if (paramorb != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.3(this, paramorb), 128, null, true);
    }
    return false;
  }
  
  public void b(orb paramorb)
  {
    if ((paramorb.jdField_a_of_type_Boolean) && (paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      bmxh.a().a(0, paramorb.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      c(paramorb);
      paramorb = paramorb.c;
    } while (TextUtils.isEmpty(paramorb));
    bisa.a().a(paramorb);
  }
  
  public void b(orb paramorb, int paramInt)
  {
    if ((paramorb != null) && (paramorb.jdField_a_of_type_Boolean)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ADBaseAppDownloadManager.4(this, paramorb));
  }
  
  public void c(orb paramorb)
  {
    if ((TextUtils.isEmpty(paramorb.c)) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramorb.b()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        orb localorb = (orb)localIterator.next();
        if ((localorb.b()) && (!TextUtils.isEmpty(localorb.c)) && (paramorb.a(localorb))) {
          paramorb.c = localorb.c;
        }
      }
    }
  }
  
  public void d(orb paramorb)
  {
    if (paramorb.jdField_a_of_type_Boolean)
    {
      if (paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
        paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramorb);
      }
      bmxh.a().b(paramorb.jdField_a_of_type_CooperationWadlIpcWadlParams);
      return;
    }
    paramorb = bisa.a().c(paramorb.jdField_a_of_type_JavaLangString);
    bisa.a().a(paramorb);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "installSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    a(localDownloadInfo, 1);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.e);
    }
    a(paramDownloadInfo, 7);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.e);
    }
    a(paramDownloadInfo, 6);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadFinish " + paramDownloadInfo.e);
    }
    a(paramDownloadInfo, 5);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadPause " + paramDownloadInfo.e);
    }
    a(paramDownloadInfo, 4);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ADBaseAppDownloadManager", 2, "onDownloadUpdate " + paramList.size());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((DownloadInfo)paramList.next(), 3);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadWait " + paramDownloadInfo.e);
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallback ");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      paramArrayList = this.jdField_b_of_type_JavaUtilList.iterator();
    }
    while (paramArrayList.hasNext())
    {
      a(new WadlResult(((orb)paramArrayList.next()).jdField_a_of_type_CooperationWadlIpcWadlParams), 8);
      continue;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((WadlResult)paramArrayList.next(), 8);
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallbackVia ");
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ADBaseAppDownloadManager", 2, "onWadlTaskStatusChanged，wadlResult.taskStatus=" + paramWadlResult.jdField_b_of_type_Int);
      }
      if (4 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 3);
        return;
      }
      if (6 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 5);
        return;
      }
      if (5 == paramWadlResult.jdField_b_of_type_Int)
      {
        a(paramWadlResult, 4);
        return;
      }
      if ((9 == paramWadlResult.jdField_b_of_type_Int) || (10 == paramWadlResult.jdField_b_of_type_Int))
      {
        a(paramWadlResult, 1);
        return;
      }
    } while (7 != paramWadlResult.jdField_b_of_type_Int);
    a(paramWadlResult, 6);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nxp
 * JD-Core Version:    0.7.0.1
 */