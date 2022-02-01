import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.3;
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
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class oau
  implements bldr, DownloadListener
{
  protected Handler a;
  protected SoftReference<Activity> a;
  private ArrayList<tqt> a;
  public List<txh> a;
  protected Handler b;
  protected List<txh> b;
  
  public oau(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    bldt.a().a(this);
    bhyo.a().a(this);
    QLog.d("ADBaseAppDownloadManager", 1, "registerWadlServiceCallBack ：" + this);
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
    //   6: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +5 -> 14
    //   12: aload_3
    //   13: areturn
    //   14: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +37 -> 54
    //   20: ldc 81
    //   22: iconst_2
    //   23: new 83	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   30: ldc 146
    //   32: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 148
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_1
    //   45: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +28 -> 85
    //   60: ldc 81
    //   62: iconst_2
    //   63: new 83	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   70: ldc 153
    //   72: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: new 155	java/net/URL
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 158	java/net/URL:<init>	(Ljava/lang/String;)V
    //   93: invokevirtual 162	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   96: checkcast 164	java/net/HttpURLConnection
    //   99: astore_2
    //   100: aload_2
    //   101: ldc 166
    //   103: invokevirtual 169	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   106: aload_2
    //   107: ldc 171
    //   109: ldc 173
    //   111: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload_2
    //   115: ldc 179
    //   117: ldc 181
    //   119: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_2
    //   123: ldc 183
    //   125: ldc 185
    //   127: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload_2
    //   131: sipush 3000
    //   134: invokevirtual 189	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   137: aload_2
    //   138: sipush 3000
    //   141: invokevirtual 192	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   144: aload_2
    //   145: invokevirtual 196	java/net/HttpURLConnection:getResponseCode	()I
    //   148: sipush 200
    //   151: if_icmpne +101 -> 252
    //   154: aload_2
    //   155: invokevirtual 200	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   158: invokestatic 202	oau:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   161: astore_0
    //   162: aload_0
    //   163: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifne +27 -> 193
    //   169: new 204	org/json/JSONObject
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   177: invokestatic 208	oau:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   180: astore_0
    //   181: aload_0
    //   182: astore_3
    //   183: aload_2
    //   184: ifnull -172 -> 12
    //   187: aload_2
    //   188: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   191: aload_0
    //   192: areturn
    //   193: ldc 81
    //   195: iconst_1
    //   196: ldc 213
    //   198: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload 4
    //   203: astore_0
    //   204: goto -23 -> 181
    //   207: astore 4
    //   209: aload_2
    //   210: astore_0
    //   211: aload 4
    //   213: astore_2
    //   214: ldc 81
    //   216: iconst_1
    //   217: new 83	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   224: ldc 215
    //   226: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_2
    //   230: invokevirtual 216	java/lang/Exception:toString	()Ljava/lang/String;
    //   233: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload_0
    //   243: ifnull -231 -> 12
    //   246: aload_0
    //   247: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
    //   250: aconst_null
    //   251: areturn
    //   252: ldc 81
    //   254: iconst_1
    //   255: new 83	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   262: ldc 218
    //   264: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_2
    //   268: invokevirtual 196	java/net/HttpURLConnection:getResponseCode	()I
    //   271: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   296: invokevirtual 211	java/net/HttpURLConnection:disconnect	()V
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
  
  private void a(Activity paramActivity, txh paramtxh)
  {
    int i = 0;
    if ((paramActivity == null) || (paramtxh == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramtxh.c)) && (!TextUtils.isEmpty(paramtxh.jdField_b_of_type_JavaLangString))) {
      paramtxh.c = a(paramtxh.jdField_b_of_type_JavaLangString, 0);
    }
    String str1 = paramtxh.d;
    String str2 = paramtxh.jdField_a_of_type_JavaLangString;
    String str3 = paramtxh.c;
    String str4 = paramtxh.e;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      }
      for (;;)
      {
        a(paramtxh, 6, i);
        return;
        if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
          i = paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h;
        } else if (paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
          i = paramtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bibw.f, str1);
    localBundle.putString(bibw.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bibw.j, str3);
    localBundle.putString(bibw.l, str4);
    localBundle.putInt(bibw.k, 2);
    localBundle.putInt(bibw.E, 0);
    localBundle.putBoolean(bibw.x, false);
    localBundle.putInt(bibw.H, 0);
    localBundle.putBoolean(bibw.y, true);
    localBundle.putBoolean(bibw.h, true);
    localBundle.putBoolean(bibw.r, false);
    localBundle.putBoolean(bibw.J, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(str3));
    if (!TextUtils.isEmpty(paramtxh.f)) {
      localBundle.putString(bibw.i, paramtxh.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtxh)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramtxh);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramtxh);
    bhys.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  public static boolean a(Context paramContext, txh paramtxh)
  {
    return b(paramContext, paramtxh);
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return false;
      localDownloadInfo = bhyo.a().b(paramString);
    } while (localDownloadInfo == null);
    paramString = "";
    if (!TextUtils.isEmpty(localDownloadInfo.l)) {
      paramString = localDownloadInfo.l;
    }
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean a(txh paramtxh, int paramInt)
  {
    do
    {
      try
      {
        if (!paramtxh.jdField_a_of_type_Boolean) {
          break;
        }
        if (!TextUtils.isEmpty(paramtxh.i)) {
          continue;
        }
        if (TextUtils.isEmpty(paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.I)) {
          break;
        }
      }
      catch (Exception paramtxh)
      {
        return false;
      }
      if (TextUtils.isEmpty(paramtxh.i)) {}
      for (paramtxh = paramtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.I; new File(paramtxh).exists(); paramtxh = paramtxh.i) {
        return true;
      }
    } while ((paramInt != 3) && (paramInt != 4));
    return false;
  }
  
  private void b()
  {
    bhyo.a().b(this);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return false;
      localDownloadInfo = bhyo.a().c(paramString);
    } while (localDownloadInfo == null);
    paramContext = "";
    if (!TextUtils.isEmpty(localDownloadInfo.l)) {
      paramContext = localDownloadInfo.l;
    }
    paramString = paramContext;
    if (TextUtils.isEmpty(paramContext))
    {
      paramString = paramContext;
      if (!TextUtils.isEmpty(localDownloadInfo.d))
      {
        localDownloadInfo = bhyo.a().b(localDownloadInfo.d);
        paramString = paramContext;
        if (localDownloadInfo != null) {
          paramString = localDownloadInfo.l;
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (new File(paramString).exists())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean b(Context paramContext, txh paramtxh)
  {
    if ((paramContext == null) || (paramtxh == null) || (TextUtils.isEmpty(paramtxh.d)) || (TextUtils.isEmpty(paramtxh.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    if (paramtxh.jdField_a_of_type_Boolean) {
      return a(paramtxh, paramtxh.jdField_a_of_type_Int);
    }
    if (TextUtils.isEmpty(paramtxh.c)) {
      return b(paramContext, paramtxh.d);
    }
    return a(paramtxh.c);
  }
  
  private void e(txh paramtxh)
  {
    if (paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramtxh);
    }
    bldt.a().a(paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtxh)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramtxh);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramtxh);
  }
  
  protected WadlParams a(txh paramtxh)
  {
    WadlParams localWadlParams = new WadlParams(paramtxh.jdField_a_of_type_JavaLangString, paramtxh.d);
    localWadlParams.c = 7;
    localWadlParams.jdField_b_of_type_Int = 2;
    localWadlParams.n = (paramtxh.g + "@" + paramtxh.h);
    localWadlParams.e = paramtxh.c;
    localWadlParams.j = paramtxh.e;
    localWadlParams.p = "biz_src_feeds_kandianads";
    localWadlParams.l = "qq_vas_game";
    return localWadlParams;
  }
  
  public void a()
  {
    b();
    bldt.a().b(this);
    QLog.d("ADBaseAppDownloadManager", 1, "unRegisterWadlServiceCallBack ：" + this);
    this.jdField_a_of_type_JavaLangRefSoftReference = null;
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
        txh localtxh = (txh)localIterator.next();
        if ((localtxh.jdField_a_of_type_JavaLangString != null) && (localtxh.d != null) && (localtxh.jdField_a_of_type_JavaLangString.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.jdField_a_of_type_JavaLangString)) && (localtxh.d.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.f)))
        {
          int i = a(paramWadlResult);
          int j = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.jdField_b_of_type_JavaLangString)) {
            localtxh.i = paramWadlResult.jdField_b_of_type_JavaLangString;
          }
          if (localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = i;
            localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = j;
          }
          if (localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
          {
            localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = i;
            localtxh.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = j;
          }
          if (localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
          {
            localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = i;
            localtxh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = j;
          }
          a(localtxh, paramInt, paramWadlResult.d);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      twp.a("ADBaseAppDownloadManager", "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(tqt paramtqt)
  {
    if (paramtqt != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramtqt);
    }
  }
  
  public void a(txh paramtxh)
  {
    if (paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramtxh);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramtxh.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramtxh))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(paramtxh);
    }
    bldt.a().a(localArrayList);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtxh)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramtxh);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramtxh);
  }
  
  protected void a(txh paramtxh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startDownload " + paramtxh.d + " progress " + paramInt);
    }
    paramtxh.jdField_a_of_type_Int = 3;
    bhyo.a().a(this);
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_JavaLangRefSoftReference.get())
    {
      a(localActivity, paramtxh);
      return;
    }
  }
  
  public void a(txh paramtxh, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      twp.a("ADBaseAppDownloadManager", "updateUIState error : empty progressCallbacks");
    }
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.1(this, paramtxh, paramInt1, paramInt2));
  }
  
  public void a(txh paramtxh, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramtxh);
    }
    b(paramtxh);
  }
  
  public boolean a(txh paramtxh)
  {
    if (paramtxh != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.3(this, paramtxh), 128, null, true);
    }
    return false;
  }
  
  public void b(txh paramtxh)
  {
    if ((paramtxh.jdField_a_of_type_Boolean) && (paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      bldt.a().a(0, paramtxh.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      c(paramtxh);
      paramtxh = paramtxh.c;
    } while (TextUtils.isEmpty(paramtxh));
    bhyo.a().a(paramtxh);
  }
  
  public void c(txh paramtxh)
  {
    if ((TextUtils.isEmpty(paramtxh.c)) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramtxh.b()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        txh localtxh = (txh)localIterator.next();
        if ((localtxh.b()) && (!TextUtils.isEmpty(localtxh.c)) && (paramtxh.a(localtxh))) {
          paramtxh.c = localtxh.c;
        }
      }
    }
  }
  
  public void d(txh paramtxh)
  {
    if (paramtxh.jdField_a_of_type_Boolean)
    {
      if (paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
        paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramtxh);
      }
      bldt.a().b(paramtxh.jdField_a_of_type_CooperationWadlIpcWadlParams);
      return;
    }
    paramtxh = bhyo.a().c(paramtxh.jdField_a_of_type_JavaLangString);
    bhyo.a().a(paramtxh);
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
      a(new WadlResult(((txh)paramArrayList.next()).jdField_a_of_type_CooperationWadlIpcWadlParams), 8);
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
 * Qualified Name:     oau
 * JD-Core Version:    0.7.0.1
 */