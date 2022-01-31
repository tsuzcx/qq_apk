import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
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
import org.json.JSONObject;

public class nop
  implements bfka, bked
{
  public Context a;
  protected Handler a;
  protected List<qyj> a;
  protected Handler b;
  protected List<qyj> b;
  
  public nop(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    a();
    bkel.a().a(this);
    bfgi.a().a(this);
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
  
  private void a(Activity paramActivity, qyj paramqyj)
  {
    int j = 0;
    int i = 0;
    if ((paramActivity == null) || (paramqyj == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramqyj.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramqyj.jdField_b_of_type_JavaLangString))) {
      paramqyj.jdField_c_of_type_JavaLangString = a(paramqyj.jdField_b_of_type_JavaLangString, 0);
    }
    if (TextUtils.isEmpty(paramqyj.jdField_c_of_type_JavaLangString))
    {
      if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      }
      for (;;)
      {
        a(paramqyj, 6, i);
        return;
        if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
          i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
        } else if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
          i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
        }
      }
    }
    String str1 = paramqyj.d;
    String str2 = paramqyj.jdField_a_of_type_JavaLangString;
    String str3 = paramqyj.jdField_c_of_type_JavaLangString;
    String str4 = paramqyj.e;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.progress;
      }
      for (;;)
      {
        a(paramqyj, 6, i);
        return;
        if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
        {
          i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.j;
        }
        else
        {
          i = j;
          if (paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) {
            i = paramqyj.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
          }
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(bfjy.f, str1);
    localBundle.putString(bfjy.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bfjy.j, str3);
    localBundle.putString(bfjy.l, str4);
    localBundle.putInt(bfjy.k, 2);
    localBundle.putInt(bfjy.E, 0);
    localBundle.putBoolean(bfjy.x, false);
    localBundle.putInt(bfjy.H, 0);
    localBundle.putBoolean(bfjy.y, true);
    localBundle.putBoolean(bfjy.h, true);
    localBundle.putBoolean(bfjy.r, false);
    localBundle.putBoolean(bfjy.J, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(str3));
    if (!TextUtils.isEmpty(paramqyj.f)) {
      localBundle.putString(bfjy.i, paramqyj.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramqyj)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramqyj);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramqyj);
    bfgm.a().a(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return false;
        paramContext = bfgi.a().c(paramString);
      } while ((paramContext == null) || (TextUtils.isEmpty(paramContext.l)));
      paramContext = paramContext.l;
    } while ((TextUtils.isEmpty(paramContext)) || (!new File(paramContext).exists()));
    return true;
  }
  
  public static boolean a(Context paramContext, qyj paramqyj)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramqyj != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = paramqyj.d;
            str2 = paramqyj.jdField_a_of_type_JavaLangString;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = bfgi.a().c(str1);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramqyj = "";
      if (TextUtils.isEmpty(localDownloadInfo.l)) {
        break;
      }
      paramqyj = localDownloadInfo.l;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramqyj))
      {
        bool1 = bool3;
        if (new File(paramqyj).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ADBaseAppDownloadManager", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramqyj);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo.d);
      paramContext = paramqyj;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramqyj;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramqyj = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo);
        paramqyj = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramqyj;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramqyj;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramqyj = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.l = paramContext;
      localDownloadInfo.a(4);
      bfgi.a().c(localDownloadInfo);
      paramqyj = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = bfgi.a().a(localDownloadInfo);
      paramContext = paramqyj;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramqyj;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramqyj = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = bfgi.a().a(localDownloadInfo.d);
        paramqyj = paramContext;
      }
    }
  }
  
  public static boolean a(qyj paramqyj, int paramInt)
  {
    do
    {
      try
      {
        if (!paramqyj.jdField_a_of_type_Boolean) {
          break;
        }
        if (!TextUtils.isEmpty(paramqyj.i)) {
          continue;
        }
        if (TextUtils.isEmpty(paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.Q)) {
          break;
        }
      }
      catch (Exception paramqyj)
      {
        return false;
      }
      if (TextUtils.isEmpty(paramqyj.i)) {}
      for (paramqyj = paramqyj.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.Q; new File(paramqyj).exists(); paramqyj = paramqyj.i) {
        return true;
      }
    } while ((paramInt != 3) && (paramInt != 4));
    return false;
  }
  
  private void c()
  {
    bfgi.a().b(this);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void f(qyj paramqyj)
  {
    if (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramqyj);
    }
    a(paramqyj);
    bkel.a().a(paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramqyj)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramqyj);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramqyj);
  }
  
  protected WadlParams a(qyj paramqyj)
  {
    WadlParams localWadlParams = new WadlParams(paramqyj.jdField_a_of_type_JavaLangString, paramqyj.d);
    localWadlParams.jdField_c_of_type_Int = 7;
    localWadlParams.jdField_b_of_type_Int = 2;
    localWadlParams.o = (paramqyj.g + "@" + paramqyj.h);
    localWadlParams.jdField_b_of_type_JavaLangString = paramqyj.jdField_c_of_type_JavaLangString;
    localWadlParams.k = paramqyj.e;
    localWadlParams.q = "biz_src_feeds_kandianads";
    localWadlParams.m = "qq_vas_game";
    return localWadlParams;
  }
  
  protected String a(InputStream paramInputStream)
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
  protected String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +39 -> 58
    //   22: ldc 210
    //   24: iconst_2
    //   25: new 181	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 371
    //   35: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 373
    //   45: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +29 -> 90
    //   64: ldc 210
    //   66: iconst_2
    //   67: new 181	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 378
    //   77: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 380	java/net/URL
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 381	java/net/URL:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 385	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   101: checkcast 387	java/net/HttpURLConnection
    //   104: astore_3
    //   105: aload_3
    //   106: ldc_w 389
    //   109: invokevirtual 392	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: ldc_w 394
    //   116: ldc_w 396
    //   119: invokevirtual 399	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_3
    //   123: ldc_w 401
    //   126: ldc_w 403
    //   129: invokevirtual 399	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_3
    //   133: ldc_w 405
    //   136: ldc_w 407
    //   139: invokevirtual 399	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_3
    //   143: sipush 3000
    //   146: invokevirtual 410	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   149: aload_3
    //   150: sipush 3000
    //   153: invokevirtual 413	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   156: aload_3
    //   157: invokevirtual 417	java/net/HttpURLConnection:getResponseCode	()I
    //   160: sipush 200
    //   163: if_icmpne +106 -> 269
    //   166: aload_0
    //   167: aload_3
    //   168: invokevirtual 421	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   171: invokevirtual 423	nop:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +29 -> 208
    //   182: aload_0
    //   183: new 425	org/json/JSONObject
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 426	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: invokevirtual 429	nop:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 4
    //   198: aload_3
    //   199: ifnull -186 -> 13
    //   202: aload_3
    //   203: invokevirtual 432	java/net/HttpURLConnection:disconnect	()V
    //   206: aload_1
    //   207: areturn
    //   208: ldc 210
    //   210: iconst_1
    //   211: ldc_w 434
    //   214: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload 5
    //   219: astore_1
    //   220: goto -25 -> 195
    //   223: astore 5
    //   225: aload_3
    //   226: astore_1
    //   227: aload 5
    //   229: astore_3
    //   230: ldc 210
    //   232: iconst_1
    //   233: new 181	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 436
    //   243: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_3
    //   247: invokevirtual 437	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_1
    //   260: ifnull -247 -> 13
    //   263: aload_1
    //   264: invokevirtual 432	java/net/HttpURLConnection:disconnect	()V
    //   267: aconst_null
    //   268: areturn
    //   269: ldc 210
    //   271: iconst_1
    //   272: new 181	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 439
    //   282: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_3
    //   286: invokevirtual 417	java/net/HttpURLConnection:getResponseCode	()I
    //   289: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 221	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload 5
    //   300: astore_1
    //   301: goto -106 -> 195
    //   304: astore 4
    //   306: aload_3
    //   307: astore_1
    //   308: aload 4
    //   310: astore_3
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 432	java/net/HttpURLConnection:disconnect	()V
    //   319: aload_3
    //   320: athrow
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -13 -> 311
    //   327: astore_3
    //   328: goto -17 -> 311
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -104 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	nop
    //   0	337	1	paramString	String
    //   0	337	2	paramInt	int
    //   104	216	3	localObject1	Object
    //   321	1	3	localObject2	Object
    //   327	1	3	localObject3	Object
    //   331	1	3	localException1	Exception
    //   4	193	4	str	String
    //   304	5	4	localObject4	Object
    //   1	217	5	localObject5	Object
    //   223	76	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	195	223	java/lang/Exception
    //   208	217	223	java/lang/Exception
    //   269	298	223	java/lang/Exception
    //   105	195	304	finally
    //   208	217	304	finally
    //   269	298	304	finally
    //   90	105	321	finally
    //   230	259	327	finally
    //   90	105	331	java/lang/Exception
  }
  
  protected String a(JSONObject paramJSONObject)
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
  
  protected void a() {}
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  protected void a(WadlResult paramWadlResult, int paramInt) {}
  
  protected void a(qyj paramqyj) {}
  
  public void a(qyj paramqyj, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startDownload " + paramqyj.d + " progress " + paramInt);
    }
    paramqyj.jdField_a_of_type_Int = 3;
    bfgi.a().a(this);
    a((Activity)this.jdField_a_of_type_AndroidContentContext, paramqyj);
  }
  
  public void a(qyj paramqyj, int paramInt1, int paramInt2) {}
  
  public void a(qyj paramqyj, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramqyj);
    }
    if ((paramqyj.jdField_a_of_type_Boolean) && (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      bkel.a().a(0, paramqyj.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      d(paramqyj);
      paramqyj = paramqyj.jdField_c_of_type_JavaLangString;
    } while (TextUtils.isEmpty(paramqyj));
    bfgi.a().a(paramqyj);
  }
  
  public boolean a(qyj paramqyj)
  {
    if (paramqyj != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.1(this, paramqyj), 128, null, true);
    }
    return false;
  }
  
  public void b()
  {
    c();
    bkel.a().b(this);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void b(qyj paramqyj)
  {
    if (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramqyj);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramqyj.jdField_a_of_type_JavaLangString);
    if (!this.jdField_b_of_type_JavaUtilList.contains(paramqyj))
    {
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.add(paramqyj);
    }
    bkel.a().a(localArrayList);
    if (this.jdField_a_of_type_JavaUtilList.contains(paramqyj)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramqyj);
    }
    this.jdField_a_of_type_JavaUtilList.add(paramqyj);
  }
  
  public void b(qyj paramqyj, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ADBaseAppDownloadManager.2(this, paramqyj, paramInt));
  }
  
  public boolean b(qyj paramqyj)
  {
    return true;
  }
  
  public void c(qyj paramqyj)
  {
    if ((paramqyj.jdField_a_of_type_Boolean) && (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      bkel.a().a(0, paramqyj.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      d(paramqyj);
      paramqyj = paramqyj.jdField_c_of_type_JavaLangString;
    } while (TextUtils.isEmpty(paramqyj));
    bfgi.a().a(paramqyj);
  }
  
  public boolean c(qyj paramqyj)
  {
    return true;
  }
  
  public void d(qyj paramqyj)
  {
    if ((TextUtils.isEmpty(paramqyj.jdField_c_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramqyj.b()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qyj localqyj = (qyj)localIterator.next();
        if ((localqyj.b()) && (!TextUtils.isEmpty(localqyj.jdField_c_of_type_JavaLangString)) && (paramqyj.a(localqyj))) {
          paramqyj.jdField_c_of_type_JavaLangString = localqyj.jdField_c_of_type_JavaLangString;
        }
      }
    }
  }
  
  public void e(qyj paramqyj)
  {
    if (paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams = a(paramqyj);
    }
    bkel.a().b(paramqyj.jdField_a_of_type_CooperationWadlIpcWadlParams);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "installSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramString1;
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
      a(new WadlResult(((qyj)paramArrayList.next()).jdField_a_of_type_CooperationWadlIpcWadlParams), 8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nop
 * JD-Core Version:    0.7.0.1
 */