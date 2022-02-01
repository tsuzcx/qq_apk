package com.tencent.mobileqq.qbosssplash.common;

import BOSSStrategyCenter.tAdvDesc;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qbosssplash.model.SplashItem;
import com.tencent.mobileqq.qbosssplash.model.SplashItem.Builder;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import org.json.JSONObject;

public class QbossSplashCacheManager
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qboss_splash_ad_pref_" + paramString, 0);
  }
  
  public static SplashItem a(tAdvDesc paramtAdvDesc, SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramtAdvDesc == null)
    {
      paramtAdvDesc = null;
      return paramtAdvDesc;
    }
    Object localObject3 = null;
    String str1 = paramtAdvDesc.task_id + "";
    String str2 = paramtAdvDesc.res_traceinfo;
    paramtAdvDesc = paramtAdvDesc.res_data;
    if (TextUtils.isEmpty(paramtAdvDesc)) {
      return null;
    }
    paramSharedPreferences = localObject3;
    for (;;)
    {
      try
      {
        Object localObject4 = new JSONObject(paramtAdvDesc);
        paramSharedPreferences = localObject3;
        String str3 = ((JSONObject)localObject4).getString("showStartTime");
        paramSharedPreferences = localObject3;
        String str4 = ((JSONObject)localObject4).getString("showEndTime");
        paramSharedPreferences = localObject3;
        int j = ((JSONObject)localObject4).getInt("resourceType");
        int k;
        int m;
        Object localObject2;
        Object localObject1;
        int i2;
        int i3;
        boolean bool;
        switch (j)
        {
        case 0: 
          paramSharedPreferences = localObject3;
          k = QbossSplashUtil.a(((JSONObject)localObject4).getString("showPriority"));
          paramSharedPreferences = localObject3;
          m = ((JSONObject)localObject4).getInt("linkType");
          paramSharedPreferences = localObject3;
          localObject2 = ((JSONObject)localObject4).getString("linkURL");
          if (m == 1)
          {
            localObject1 = localObject2;
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              paramSharedPreferences = localObject3;
              if (!((String)localObject2).startsWith("http"))
              {
                paramSharedPreferences = localObject3;
                localObject1 = "https://" + (String)localObject2;
              }
            }
            paramSharedPreferences = localObject3;
            localObject2 = new StringBuilder().append((String)localObject1);
            paramSharedPreferences = localObject3;
            if (!((String)localObject1).contains("?")) {
              break label671;
            }
            localObject1 = "&";
            paramSharedPreferences = localObject3;
            localObject1 = MobileReportManager.getStringQboos2H5(paramString, str2, (String)localObject1);
            paramSharedPreferences = localObject3;
            int n = QbossSplashUtil.a(((JSONObject)localObject4).getString("androidMinimumMemorySize"));
            paramSharedPreferences = localObject3;
            int i1 = QbossSplashUtil.a(((JSONObject)localObject4).getString("androidMinimumOSVersion"));
            paramSharedPreferences = localObject3;
            i2 = QbossSplashUtil.a(((JSONObject)localObject4).getString("thirdPartyReportPlatform"));
            paramSharedPreferences = localObject3;
            localObject2 = ((JSONObject)localObject4).getString("thirdPartyReportURLForExposure");
            paramSharedPreferences = localObject3;
            i3 = QbossSplashUtil.a(((JSONObject)localObject4).getString("shouldShowAdMark"));
            if ((i1 != 0) || (n != 0)) {
              break label678;
            }
            i = 0;
            paramSharedPreferences = localObject3;
            bool = a(i, n, i1);
            paramSharedPreferences = localObject3;
            if (!TextUtils.isEmpty(str1))
            {
              paramSharedPreferences = localObject3;
              if (!TextUtils.isEmpty(str3))
              {
                paramSharedPreferences = localObject3;
                if (!TextUtils.isEmpty(str4))
                {
                  paramSharedPreferences = localObject3;
                  if (!TextUtils.isEmpty(paramtAdvDesc)) {
                    continue;
                  }
                }
              }
            }
            paramSharedPreferences = localObject3;
            QLog.i("QSplash@QbossSplashCacheManager", 1, "downloadUrl = " + paramtAdvDesc + ", mAdID = " + str1 + ", mBeginTime = " + str3 + ", mEndTime = " + str4);
            return null;
            paramSharedPreferences = localObject3;
            paramtAdvDesc = ((JSONObject)localObject4).getString("imageURL");
          }
          break;
        case 1: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("gifURL");
          break;
        case 2: 
          paramSharedPreferences = localObject3;
          paramtAdvDesc = ((JSONObject)localObject4).getString("videoURL");
          continue;
          paramSharedPreferences = localObject3;
          localObject4 = new SplashItem.Builder();
          paramSharedPreferences = localObject3;
          ((SplashItem.Builder)localObject4).h(paramString).b(str1).c(str3).d(str4).c(j).e(paramtAdvDesc).d(m).f((String)localObject1).b(bool).g((String)localObject2).b(k).e(i2).i(str2).j("").a(i3);
          paramSharedPreferences = localObject3;
          paramString = ((SplashItem.Builder)localObject4).a();
          paramtAdvDesc = paramString;
          paramSharedPreferences = paramString;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramSharedPreferences = paramString;
          QLog.i("QSplash@QbossSplashCacheManager", 2, paramString.toString());
          return paramString;
          localObject1 = localObject2;
          break;
        default: 
          paramtAdvDesc = "";
          continue;
          localObject1 = "?";
        }
      }
      catch (Exception paramtAdvDesc)
      {
        return paramSharedPreferences;
      }
      label671:
      continue;
      label678:
      int i = 1;
    }
  }
  
  public static ArrayList<SplashItem> a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramArrayList, paramQQAppInterface, paramString, "qboss", null);
  }
  
  /* Error */
  public static ArrayList<SplashItem> a(ArrayList<tAdvDesc> paramArrayList, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, java.util.List<cooperation.vip.pb.TianShuAccess.AdItem> paramList)
  {
    // Byte code:
    //   0: new 208	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 209	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_1
    //   10: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: aload_2
    //   14: invokestatic 218	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Ljava/lang/String;)J
    //   17: invokestatic 223	com/tencent/mobileqq/splashad/SplashADUtil:a	(Landroid/content/Context;J)V
    //   20: ldc 225
    //   22: aload_3
    //   23: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +220 -> 246
    //   29: aload 4
    //   31: ifnull +215 -> 246
    //   34: invokestatic 234	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   37: aload_2
    //   38: invokestatic 238	cooperation/vip/ad/TianshuSplashUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   41: astore 7
    //   43: aload 4
    //   45: invokeinterface 244 1 0
    //   50: istore 5
    //   52: aload 10
    //   54: invokevirtual 247	java/util/ArrayList:clear	()V
    //   57: aload 10
    //   59: monitorenter
    //   60: iconst_0
    //   61: istore 6
    //   63: iload 6
    //   65: iload 5
    //   67: if_icmpge +237 -> 304
    //   70: ldc 225
    //   72: aload_3
    //   73: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifeq +188 -> 264
    //   79: aload 4
    //   81: ifnull +183 -> 264
    //   84: aload 4
    //   86: iload 6
    //   88: invokeinterface 251 2 0
    //   93: checkcast 253	cooperation/vip/pb/TianShuAccess$AdItem
    //   96: aload_1
    //   97: aload_2
    //   98: invokestatic 258	cooperation/vip/ad/TianshuSplashManager:a	(Lcooperation/vip/pb/TianShuAccess$AdItem;Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcom/tencent/mobileqq/qbosssplash/model/SplashItem;
    //   101: astore 9
    //   103: aload 9
    //   105: astore 8
    //   107: aload 9
    //   109: ifnull +62 -> 171
    //   112: aload 9
    //   114: astore 8
    //   116: aload 9
    //   118: getfield 261	com/tencent/mobileqq/qbosssplash/model/SplashItem:l	Ljava/lang/String;
    //   121: invokestatic 263	cooperation/vip/ad/TianshuSplashUtils:a	(Ljava/lang/String;)Z
    //   124: ifeq +47 -> 171
    //   127: aload 4
    //   129: iload 6
    //   131: invokeinterface 251 2 0
    //   136: checkcast 253	cooperation/vip/pb/TianShuAccess$AdItem
    //   139: aload 9
    //   141: getfield 261	com/tencent/mobileqq/qbosssplash/model/SplashItem:l	Ljava/lang/String;
    //   144: invokestatic 268	com/tencent/mobileqq/activity/recent/QbossADBannerConfigInfo:a	(Lcooperation/vip/pb/TianShuAccess$AdItem;Ljava/lang/String;)Lcom/tencent/mobileqq/activity/recent/QbossADBannerConfigInfo;
    //   147: astore 8
    //   149: invokestatic 273	com/tencent/mobileqq/activity/recent/QbossADBannerConfigManager:a	()Lcom/tencent/mobileqq/activity/recent/QbossADBannerConfigManager;
    //   152: aload_1
    //   153: aload 8
    //   155: iconst_0
    //   156: invokevirtual 276	com/tencent/mobileqq/activity/recent/QbossADBannerConfigManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/activity/recent/QbossADBannerConfigInfo;Z)V
    //   159: aload 8
    //   161: aload_2
    //   162: aload 7
    //   164: invokevirtual 279	com/tencent/mobileqq/activity/recent/QbossADBannerConfigInfo:a	(Ljava/lang/String;Landroid/content/SharedPreferences;)V
    //   167: aload 9
    //   169: astore 8
    //   171: aload 8
    //   173: ifnull +64 -> 237
    //   176: aload 10
    //   178: aload 8
    //   180: invokevirtual 282	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   183: pop
    //   184: aload 8
    //   186: getfield 284	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_b_of_type_Int	I
    //   189: iconst_3
    //   190: if_icmpeq +12 -> 202
    //   193: aload 8
    //   195: getfield 284	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_b_of_type_Int	I
    //   198: iconst_2
    //   199: if_icmpne +24 -> 223
    //   202: ldc_w 286
    //   205: invokestatic 292	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   208: checkcast 286	com/tencent/mobileqq/mini/api/IMiniAppService
    //   211: aload 8
    //   213: getfield 294	com/tencent/mobileqq/qbosssplash/model/SplashItem:f	Ljava/lang/String;
    //   216: iconst_0
    //   217: aconst_null
    //   218: invokeinterface 298 4 0
    //   223: getstatic 301	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	Ljava/util/HashMap;
    //   226: aload 8
    //   228: getfield 303	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   231: aload 8
    //   233: invokevirtual 309	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   236: pop
    //   237: iload 6
    //   239: iconst_1
    //   240: iadd
    //   241: istore 6
    //   243: goto -180 -> 63
    //   246: invokestatic 234	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   249: aload_2
    //   250: invokestatic 310	com/tencent/mobileqq/qbosssplash/common/QbossSplashCacheManager:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   253: astore 7
    //   255: aload_0
    //   256: invokevirtual 311	java/util/ArrayList:size	()I
    //   259: istore 5
    //   261: goto -209 -> 52
    //   264: aload_0
    //   265: iload 6
    //   267: invokevirtual 312	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   270: checkcast 35	BOSSStrategyCenter/tAdvDesc
    //   273: astore 8
    //   275: aload 8
    //   277: ifnull -40 -> 237
    //   280: aload 8
    //   282: getfield 315	BOSSStrategyCenter/tAdvDesc:pattern_id	I
    //   285: sipush 1014
    //   288: if_icmpne -51 -> 237
    //   291: aload 8
    //   293: aload 7
    //   295: aload_2
    //   296: invokestatic 317	com/tencent/mobileqq/qbosssplash/common/QbossSplashCacheManager:a	(LBOSSStrategyCenter/tAdvDesc;Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/tencent/mobileqq/qbosssplash/model/SplashItem;
    //   299: astore 8
    //   301: goto -130 -> 171
    //   304: aload 10
    //   306: monitorexit
    //   307: aload 10
    //   309: invokevirtual 311	java/util/ArrayList:size	()I
    //   312: ifle +167 -> 479
    //   315: aload 7
    //   317: invokeinterface 323 1 0
    //   322: astore 4
    //   324: ldc 225
    //   326: aload_3
    //   327: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   330: ifeq +158 -> 488
    //   333: invokestatic 234	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   336: aload_2
    //   337: invokestatic 326	cooperation/vip/ad/TianshuSplashUtils:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   340: astore_0
    //   341: new 328	java/util/HashSet
    //   344: dup
    //   345: invokespecial 329	java/util/HashSet:<init>	()V
    //   348: astore 7
    //   350: new 331	java/lang/StringBuffer
    //   353: dup
    //   354: invokespecial 332	java/lang/StringBuffer:<init>	()V
    //   357: astore 8
    //   359: aload 10
    //   361: invokevirtual 336	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   364: astore 9
    //   366: aload 9
    //   368: invokeinterface 341 1 0
    //   373: ifeq +137 -> 510
    //   376: aload 9
    //   378: invokeinterface 345 1 0
    //   383: checkcast 197	com/tencent/mobileqq/qbosssplash/model/SplashItem
    //   386: astore 11
    //   388: aload 11
    //   390: getfield 303	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   393: astore 12
    //   395: aload 7
    //   397: aload 12
    //   399: invokeinterface 348 2 0
    //   404: pop
    //   405: aload 8
    //   407: aload 12
    //   409: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   412: ldc_w 353
    //   415: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   418: aload 11
    //   420: getfield 355	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   423: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   426: ldc_w 353
    //   429: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   432: aload 11
    //   434: getfield 357	com/tencent/mobileqq/qbosssplash/model/SplashItem:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   437: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   440: ldc_w 353
    //   443: invokevirtual 351	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   446: pop
    //   447: aload_0
    //   448: aload 12
    //   450: invokeinterface 359 2 0
    //   455: ifeq +44 -> 499
    //   458: aload_0
    //   459: aload 12
    //   461: invokeinterface 362 2 0
    //   466: pop
    //   467: aload 4
    //   469: aload 11
    //   471: iconst_0
    //   472: invokestatic 365	com/tencent/mobileqq/qbosssplash/common/QbossSplashCacheManager:a	(Landroid/content/SharedPreferences$Editor;Lcom/tencent/mobileqq/qbosssplash/model/SplashItem;Z)V
    //   475: goto -109 -> 366
    //   478: astore_0
    //   479: aload 10
    //   481: areturn
    //   482: astore_0
    //   483: aload 10
    //   485: monitorexit
    //   486: aload_0
    //   487: athrow
    //   488: invokestatic 234	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   491: aload_2
    //   492: invokestatic 366	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/Set;
    //   495: astore_0
    //   496: goto -155 -> 341
    //   499: aload 4
    //   501: aload 11
    //   503: iconst_1
    //   504: invokestatic 365	com/tencent/mobileqq/qbosssplash/common/QbossSplashCacheManager:a	(Landroid/content/SharedPreferences$Editor;Lcom/tencent/mobileqq/qbosssplash/model/SplashItem;Z)V
    //   507: goto -141 -> 366
    //   510: invokestatic 234	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   513: invokestatic 372	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   516: invokeinterface 323 1 0
    //   521: astore_0
    //   522: ldc 225
    //   524: aload_3
    //   525: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   528: ifeq +118 -> 646
    //   531: aload 4
    //   533: ldc_w 374
    //   536: aload 7
    //   538: invokestatic 377	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Ljava/util/Set;)Ljava/lang/String;
    //   541: invokeinterface 383 3 0
    //   546: pop
    //   547: aload_0
    //   548: new 13	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 385
    //   558: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_2
    //   562: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokevirtual 24	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: aload 8
    //   570: iconst_0
    //   571: aload 8
    //   573: invokevirtual 388	java/lang/StringBuffer:length	()I
    //   576: iconst_1
    //   577: isub
    //   578: invokevirtual 392	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   581: invokeinterface 383 3 0
    //   586: pop
    //   587: aload 4
    //   589: invokeinterface 395 1 0
    //   594: aload_0
    //   595: invokeinterface 395 1 0
    //   600: ldc 124
    //   602: iconst_1
    //   603: new 13	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 397
    //   613: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 7
    //   618: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: ldc_w 402
    //   624: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_3
    //   628: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 24	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 138	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_1
    //   638: aload 10
    //   640: invokestatic 407	com/tencent/mobileqq/qbosssplash/common/QbossSplashDownloadManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/Collection;)V
    //   643: aload 10
    //   645: areturn
    //   646: aload 4
    //   648: ldc_w 409
    //   651: aload 7
    //   653: invokestatic 377	com/tencent/mobileqq/qbosssplash/common/QbossSplashUtil:a	(Ljava/util/Set;)Ljava/lang/String;
    //   656: invokeinterface 383 3 0
    //   661: pop
    //   662: aload_0
    //   663: new 13	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   670: ldc_w 411
    //   673: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload_2
    //   677: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: invokevirtual 24	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: aload 8
    //   685: iconst_0
    //   686: aload 8
    //   688: invokevirtual 388	java/lang/StringBuffer:length	()I
    //   691: iconst_1
    //   692: isub
    //   693: invokevirtual 392	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   696: invokeinterface 383 3 0
    //   701: pop
    //   702: goto -115 -> 587
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	paramArrayList	ArrayList<tAdvDesc>
    //   0	705	1	paramQQAppInterface	QQAppInterface
    //   0	705	2	paramString1	String
    //   0	705	3	paramString2	String
    //   0	705	4	paramList	java.util.List<cooperation.vip.pb.TianShuAccess.AdItem>
    //   50	210	5	i	int
    //   61	205	6	j	int
    //   41	611	7	localObject1	Object
    //   105	582	8	localObject2	Object
    //   101	276	9	localObject3	Object
    //   7	637	10	localArrayList	ArrayList
    //   386	116	11	localSplashItem	SplashItem
    //   393	67	12	str	String
    // Exception table:
    //   from	to	target	type
    //   9	29	478	java/lang/Exception
    //   34	52	478	java/lang/Exception
    //   52	60	478	java/lang/Exception
    //   246	261	478	java/lang/Exception
    //   307	341	478	java/lang/Exception
    //   341	366	478	java/lang/Exception
    //   366	475	478	java/lang/Exception
    //   486	488	478	java/lang/Exception
    //   488	496	478	java/lang/Exception
    //   499	507	478	java/lang/Exception
    //   510	587	478	java/lang/Exception
    //   587	643	478	java/lang/Exception
    //   646	702	478	java/lang/Exception
    //   70	79	482	finally
    //   84	103	482	finally
    //   116	167	482	finally
    //   176	202	482	finally
    //   202	223	482	finally
    //   223	237	482	finally
    //   264	275	482	finally
    //   280	301	482	finally
    //   304	307	482	finally
    //   483	486	482	finally
  }
  
  public static void a(SharedPreferences.Editor paramEditor, SplashItem paramSplashItem, boolean paramBoolean)
  {
    paramEditor.putString("qboss_splash_ad_begin_time_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_c_of_type_JavaLangString);
    paramEditor.putString("qboss_splash_ad_end_time_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_d_of_type_JavaLangString);
    paramEditor.putInt("qbosss_plash_ad_content_type_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_a_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_download_url_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_e_of_type_JavaLangString);
    paramEditor.putInt("qbosss_splash_ad_jumptype_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_b_of_type_Int);
    paramEditor.putString("qbosss_splash_ad_jump_h5_url_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.f);
    paramEditor.putInt("qboss_splash_ad_showpriority_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_d_of_type_Int);
    paramEditor.putBoolean("qboss_exposure_is_low_device_limit_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_a_of_type_Boolean);
    paramEditor.putInt("qboss_splash_ad_exposure_platform_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_c_of_type_Int);
    paramEditor.putString("qboss_splash_info_report_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.j);
    paramEditor.putString("qboss_splash_resource_md5_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.k);
    paramEditor.putInt("qboss_splash_should_show_ad_mark_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_e_of_type_Int);
    paramEditor.putString("qboss_splash_union_banner_type_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.l);
    String str2 = paramSplashItem.g;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!str2.startsWith("https")) {
        str1 = paramSplashItem.g.replaceFirst("http", "https");
      }
    }
    paramEditor.putString("qboss_exposure_url_" + paramSplashItem.jdField_b_of_type_JavaLangString, str1);
    paramBoolean = SplashItem.a(paramSplashItem.h, true);
    if ((!paramSplashItem.jdField_a_of_type_Boolean) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramSplashItem.jdField_b_of_type_Boolean = paramBoolean;
      paramEditor.putBoolean("qboss_splash_ad_is_limited_" + paramSplashItem.jdField_b_of_type_JavaLangString, paramSplashItem.jdField_b_of_type_Boolean);
      return;
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (1 == paramInt1)
    {
      l = DeviceInfoUtil.a();
      if (paramInt3 != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT <= paramInt3) {}
      }
      else
      {
        if ((l == 0L) || (paramInt2 == 0) || (l > paramInt2 * 1024 * 1024)) {
          break label142;
        }
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("openDisabledLowerDevice ");
        localStringBuilder.append(" sdk_int:" + paramInt3);
        localStringBuilder.append(" mem:" + paramInt2);
        QLog.d("QSplash@QbossSplashCacheManager", 2, localStringBuilder.toString());
      }
    }
    label142:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        StringBuilder localStringBuilder;
        return bool1;
        bool1 = false;
      }
    }
    QLog.d("QSplash@QbossSplashCacheManager", 2, "isDisabledLowerDevice false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.common.QbossSplashCacheManager
 * JD-Core Version:    0.7.0.1
 */