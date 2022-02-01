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

public class oil
  implements bmqi, DownloadListener
{
  protected Handler a;
  protected SoftReference<Activity> a;
  private ArrayList<uel> a;
  public List<ule> a;
  protected Handler b;
  protected List<ule> b;
  
  public oil(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    bmqk.a().a(this);
    bjjq.a().a(this);
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
    //   151: if_icmpne +106 -> 257
    //   154: aload_2
    //   155: invokevirtual 200	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   158: invokestatic 202	oil:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   161: astore_0
    //   162: aload_0
    //   163: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   166: ifne +32 -> 198
    //   169: new 204	org/json/JSONObject
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 205	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   177: astore_0
    //   178: getstatic 210	ufl:a	Lufl;
    //   181: aload_0
    //   182: invokevirtual 213	ufl:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   185: astore_0
    //   186: aload_0
    //   187: astore_3
    //   188: aload_2
    //   189: ifnull -177 -> 12
    //   192: aload_2
    //   193: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   196: aload_0
    //   197: areturn
    //   198: ldc 81
    //   200: iconst_1
    //   201: ldc 218
    //   203: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload 4
    //   208: astore_0
    //   209: goto -23 -> 186
    //   212: astore 4
    //   214: aload_2
    //   215: astore_0
    //   216: aload 4
    //   218: astore_2
    //   219: ldc 81
    //   221: iconst_1
    //   222: new 83	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   229: ldc 220
    //   231: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 221	java/lang/Exception:toString	()Ljava/lang/String;
    //   238: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_0
    //   248: ifnull -236 -> 12
    //   251: aload_0
    //   252: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   255: aconst_null
    //   256: areturn
    //   257: ldc 81
    //   259: iconst_1
    //   260: new 83	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   267: ldc 223
    //   269: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_2
    //   273: invokevirtual 196	java/net/HttpURLConnection:getResponseCode	()I
    //   276: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: aload 4
    //   287: astore_0
    //   288: goto -102 -> 186
    //   291: astore_3
    //   292: aload_2
    //   293: astore_0
    //   294: aload_3
    //   295: astore_2
    //   296: aload_0
    //   297: ifnull +7 -> 304
    //   300: aload_0
    //   301: invokevirtual 216	java/net/HttpURLConnection:disconnect	()V
    //   304: aload_2
    //   305: athrow
    //   306: astore_2
    //   307: aconst_null
    //   308: astore_0
    //   309: goto -13 -> 296
    //   312: astore_2
    //   313: goto -17 -> 296
    //   316: astore_2
    //   317: aconst_null
    //   318: astore_0
    //   319: goto -100 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramString	String
    //   0	322	1	paramInt	int
    //   99	206	2	localObject1	Object
    //   306	1	2	localObject2	Object
    //   312	1	2	localObject3	Object
    //   316	1	2	localException1	Exception
    //   4	184	3	str	String
    //   291	4	3	localObject4	Object
    //   1	206	4	localObject5	Object
    //   212	74	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   100	186	212	java/lang/Exception
    //   198	206	212	java/lang/Exception
    //   257	285	212	java/lang/Exception
    //   100	186	291	finally
    //   198	206	291	finally
    //   257	285	291	finally
    //   85	100	306	finally
    //   219	247	312	finally
    //   85	100	316	java/lang/Exception
  }
  
  private void a(Activity paramActivity, ule paramule)
  {
    int i = 0;
    if ((paramActivity == null) || (paramule == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramule.c)) && (!TextUtils.isEmpty(paramule.jdField_b_of_type_JavaLangString))) {
      paramule.c = a(paramule.jdField_b_of_type_JavaLangString, 0);
    }
    String str1 = paramule.d;
    String str2 = paramule.jdField_a_of_type_JavaLangString;
    String str3 = paramule.c;
    String str4 = paramule.e;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      }
      for (;;)
      {
        a(paramule, 6, i);
        return;
        if (paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
          i = paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h;
        } else if (paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
          i = paramule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c;
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bjmy.f, str1);
    localBundle.putString(bjmy.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bjmy.j, str3);
    localBundle.putString(bjmy.l, str4);
    localBundle.putInt(bjmy.k, 2);
    localBundle.putInt(bjmy.F, 0);
    localBundle.putBoolean(bjmy.x, false);
    localBundle.putInt(bjmy.I, 0);
    localBundle.putBoolean(bjmy.y, true);
    localBundle.putBoolean(bjmy.h, true);
    localBundle.putBoolean(bjmy.r, false);
    localBundle.putBoolean(bjmy.K, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(str3));
    if (!TextUtils.isEmpty(paramule.f)) {
      localBundle.putString(bjmy.i, paramule.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramule)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramule);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramule);
    bjju.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return b(paramContext, paramString);
  }
  
  public static boolean a(Context paramContext, ule paramule)
  {
    return b(paramContext, paramule);
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    DownloadInfo localDownloadInfo;
    do
    {
      return false;
      localDownloadInfo = bjjq.a().b(paramString);
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
  
  private static boolean a(ule paramule, int paramInt)
  {
    do
    {
      try
      {
        if (!paramule.jdField_a_of_type_Boolean) {
          break;
        }
        if (!TextUtils.isEmpty(paramule.i)) {
          continue;
        }
        if (TextUtils.isEmpty(paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.I)) {
          break;
        }
      }
      catch (Exception paramule)
      {
        return false;
      }
      if (TextUtils.isEmpty(paramule.i)) {}
      for (paramule = paramule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.I; new File(paramule).exists(); paramule = paramule.i) {
        return true;
      }
    } while ((paramInt != 3) && (paramInt != 4));
    return false;
  }
  
  private void b()
  {
    bjjq.a().b(this);
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
      localDownloadInfo = bjjq.a().c(paramString);
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
        localDownloadInfo = bjjq.a().b(localDownloadInfo.d);
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
  
  private static boolean b(Context paramContext, ule paramule)
  {
    if ((paramContext == null) || (paramule == null) || (TextUtils.isEmpty(paramule.d)) || (TextUtils.isEmpty(paramule.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    if (paramule.jdField_a_of_type_Boolean) {
      return a(paramule, paramule.jdField_a_of_type_Int);
    }
    if (TextUtils.isEmpty(paramule.c)) {
      return b(paramContext, paramule.d);
    }
    return a(paramule.c);
  }
  
  private void e(ule paramule)
  {
    if (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramule.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramule);
    }
    bmqk.a().a(paramule.jdField_a_of_type_CooperationWadlIpcWadlParams);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramule)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramule);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramule);
  }
  
  protected WadlParams a(ule paramule)
  {
    WadlParams localWadlParams = new WadlParams(paramule.jdField_a_of_type_JavaLangString, paramule.d);
    localWadlParams.c = 7;
    localWadlParams.jdField_b_of_type_Int = 2;
    localWadlParams.n = (paramule.g + "@" + paramule.h);
    localWadlParams.e = paramule.c;
    localWadlParams.j = paramule.e;
    localWadlParams.p = "biz_src_feeds_kandianads";
    localWadlParams.l = "qq_vas_game";
    return localWadlParams;
  }
  
  public void a()
  {
    b();
    bmqk.a().b(this);
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
        ule localule = (ule)localIterator.next();
        if ((localule.jdField_a_of_type_JavaLangString != null) && (localule.d != null) && (localule.jdField_a_of_type_JavaLangString.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.jdField_a_of_type_JavaLangString)) && (localule.d.equals(paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams.f)))
        {
          int i = a(paramWadlResult);
          int j = paramWadlResult.d;
          if (!TextUtils.isEmpty(paramWadlResult.jdField_b_of_type_JavaLangString)) {
            localule.i = paramWadlResult.jdField_b_of_type_JavaLangString;
          }
          if (localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.downloadState = i;
            localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress = j;
          }
          if (localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null)
          {
            localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = i;
            localule.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.c = j;
          }
          if (localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
          {
            localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.i = i;
            localule.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.h = j;
          }
          a(localule, paramInt, paramWadlResult.d);
        }
      }
      return;
    }
    catch (Exception paramWadlResult)
    {
      ukq.a("ADBaseAppDownloadManager", "notifyState error " + paramWadlResult.getMessage());
    }
  }
  
  public void a(uel paramuel)
  {
    if (paramuel != null) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramuel);
    }
  }
  
  public void a(ule paramule)
  {
    if (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramule.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramule);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramule.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramule))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(paramule);
    }
    bmqk.a().a(localArrayList);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramule)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramule);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramule);
  }
  
  protected void a(ule paramule, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startDownload " + paramule.d + " progress " + paramInt);
    }
    paramule.jdField_a_of_type_Int = 3;
    bjjq.a().a(this);
    if (this.jdField_a_of_type_JavaLangRefSoftReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.jdField_a_of_type_JavaLangRefSoftReference.get())
    {
      a(localActivity, paramule);
      return;
    }
  }
  
  public void a(ule paramule, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      ukq.a("ADBaseAppDownloadManager", "updateUIState error : empty progressCallbacks");
    }
    ThreadManager.getUIHandler().post(new ADBaseAppDownloadManager.1(this, paramule, paramInt1, paramInt2));
  }
  
  public void a(ule paramule, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      paramule.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramule);
    }
    b(paramule);
  }
  
  public boolean a(ule paramule)
  {
    if (paramule != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.3(this, paramule), 128, null, true);
    }
    return false;
  }
  
  public void b(ule paramule)
  {
    if ((paramule.jdField_a_of_type_Boolean) && (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      bmqk.a().a(0, paramule.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      c(paramule);
      paramule = paramule.c;
    } while (TextUtils.isEmpty(paramule));
    bjjq.a().a(paramule);
  }
  
  public void c(ule paramule)
  {
    if ((TextUtils.isEmpty(paramule.c)) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramule.b()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ule localule = (ule)localIterator.next();
        if ((localule.b()) && (!TextUtils.isEmpty(localule.c)) && (paramule.a(localule))) {
          paramule.c = localule.c;
        }
      }
    }
  }
  
  public void d(ule paramule)
  {
    if (paramule.jdField_a_of_type_Boolean)
    {
      if (paramule.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
        paramule.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramule);
      }
      bmqk.a().b(paramule.jdField_a_of_type_CooperationWadlIpcWadlParams);
      return;
    }
    paramule = bjjq.a().c(paramule.jdField_a_of_type_JavaLangString);
    bjjq.a().a(paramule);
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
      a(new WadlResult(((ule)paramArrayList.next()).jdField_a_of_type_CooperationWadlIpcWadlParams), 8);
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
 * Qualified Name:     oil
 * JD-Core Version:    0.7.0.1
 */