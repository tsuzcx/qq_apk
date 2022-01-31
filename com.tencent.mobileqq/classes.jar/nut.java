import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class nut
{
  private static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://kandian.qq.com/mqq/html/settingInterest.html?_wv=1027&_bid=2378";
    jdField_a_of_type_Int = -1;
  }
  
  public static Intent a(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, 0);
  }
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = null;
    if (paramInt1 != -1) {
      localIntent = new Intent(paramContext, ReadInJoyFeedsActivity.class);
    }
    if (paramInt1 != -1) {
      localIntent.putExtra("readinjoy_show_tab", paramInt1);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    return localIntent;
  }
  
  public static Intent a(Context paramContext, int paramInt, KandianRedDotInfo paramKandianRedDotInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", ReadInJoyDailyFragment.class.getName());
    if (!(paramContext instanceof Activity)) {
      localIntent.setFlags(268435456);
    }
    if ((paramKandianRedDotInfo != null) && (paramKandianRedDotInfo.hasArticleID())) {
      localIntent.putExtra("kandian_feeds_red_pnt_info", paramKandianRedDotInfo);
    }
    localIntent.setFlags(603979776);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    return localIntent;
  }
  
  public static Intent a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = a(paramContext, paramInt);
    paramContext.putExtra("arg_channel_rowkey", paramString1);
    paramContext.putExtra("arg_channel_article_url", paramString2);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    paramContext = new Intent(paramContext, FastWebActivity.class);
    try
    {
      String str1 = (String)paramHashMap.get("channelID");
      String str2 = (String)paramHashMap.get("strategyId");
      String str3 = (String)paramHashMap.get("algorithmID");
      String str4 = (String)paramHashMap.get("title");
      String str5 = (String)paramHashMap.get("firstPagePicUrl");
      String str6 = (String)paramHashMap.get("articleContentUrl");
      String str7 = (String)paramHashMap.get("articleID");
      String str8 = (String)paramHashMap.get("subscribeID");
      String str9 = (String)paramHashMap.get("subscribeName");
      paramHashMap = (String)paramHashMap.get("rowKey");
      if (paramHashMap != null) {
        localArticleInfo.innerUniqueID = paramHashMap;
      }
      if (str6 != null) {
        localArticleInfo.mArticleContentUrl = URLDecoder.decode(str6, "utf-8");
      }
      if (str5 != null) {
        localArticleInfo.mFirstPagePicUrl = URLDecoder.decode(str5, "utf-8");
      }
      if (str1 != null) {
        localArticleInfo.mChannelID = Long.valueOf(str1).longValue();
      }
      if (str2 != null) {
        localArticleInfo.mStrategyId = Integer.valueOf(str2).intValue();
      }
      if (str3 != null) {
        localArticleInfo.mAlgorithmID = Long.valueOf(str3).longValue();
      }
      if (str4 != null) {
        localArticleInfo.mTitle = str4;
      }
      if (str7 != null) {
        localArticleInfo.mArticleID = Long.valueOf(str7).longValue();
      }
      if (str8 != null) {
        localArticleInfo.mSubscribeID = str8;
      }
      if (str9 != null) {
        localArticleInfo.mSubscribeName = str9;
      }
    }
    catch (Exception paramHashMap)
    {
      label267:
      break label267;
    }
    paramContext.putExtra("fast_web_article_info", localArticleInfo);
    return paramContext;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return paramString2;
      try
      {
        if ("com.tencent.rijvideo".equalsIgnoreCase(paramString1))
        {
          paramString1 = Uri.parse(paramString2);
          Object localObject = paramString1.getQueryParameterNames();
          Uri.Builder localBuilder = paramString1.buildUpon().clearQuery();
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            localBuilder.appendQueryParameter(str, URLEncoder.encode(paramString1.getQueryParameter(str), "utf-8"));
          }
          return localBuilder.toString();
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("ReadInJoyActivityHelper", 1, paramString1, new Object[0]);
        return paramString2;
      }
    } while (!"com.tencent.reading".equalsIgnoreCase(paramString1));
    paramString1 = pqk.a().a(paramString2);
    return paramString1;
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://kandian.qq.com/mqq/watchspot/sticker.html?_wwv=265&_wv=1027&_wvSb=0&_nav_titleclr=000000&_bid=3002");
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
    noo.a(null, "CliOper", "", "", "0X8008C89", "0X8008C89", 0, 0, paramInt + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while (pqf.a(paramContext)) {
      return;
    }
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    if (!(paramContext instanceof BaseActivity)) {
      localIntent.setFlags(268435456);
    }
    if (paramBoolean)
    {
      localIntent.addFlags(67108864);
      localIntent.addFlags(536870912);
    }
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.a(paramContext, localIntent, ReadInJoyDailyFragment.class);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap, false);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
      localIntent.putExtra("channel_id", paramInt1);
      localIntent.putExtra("channel_name", paramString);
      localIntent.putExtra("channel_type", paramInt2);
      localIntent.putExtra("channel_from", paramInt3);
      localIntent.putExtra("is_channel_activity", true);
      if ((paramMap != null) && (!paramMap.isEmpty()))
      {
        paramString = new ReadInJoyChannelActivity.SerializableMap();
        paramString.setMap(paramMap);
        localIntent.putExtra("channel_map_data", paramString);
      }
      if (paramBoolean) {
        localIntent.addFlags(67108864);
      }
      paramContext.startActivity(localIntent);
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130771981, 0);
      }
      return;
    }
    paramMap = new Intent();
    paramMap.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramMap.putExtra("channel_id", paramInt1);
    paramMap.putExtra("sub_channel_name", paramString);
    paramMap.putExtra("is_sub_channel", true);
    PublicFragmentActivity.a(paramContext, paramMap, ReadInJoyPicWaterFallFragment.class);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", ajyc.a(2131713014));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 1);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo2.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo1.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    if (paramArticleInfo1 != paramArticleInfo2)
    {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 2);
      if (rap.q(paramArticleInfo2)) {
        break label215;
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo2);
      localIntent.putExtra("is_need_show_animation_adapter", paramBoolean);
      paramContext.startActivity(localIntent);
      npx.a.put(ReadInJoyChannelActivity.class, npx.b());
      qvn.a().a(false, "jumpFromKandianFeed", 1);
      return;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 1);
      break;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +178 -> 187
    //   12: new 454	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 457	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 459
    //   23: iconst_m1
    //   24: invokevirtual 463	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   27: i2l
    //   28: lstore_3
    //   29: new 99	java/util/HashMap
    //   32: dup
    //   33: invokespecial 464	java/util/HashMap:<init>	()V
    //   36: astore 5
    //   38: lload_3
    //   39: ldc2_w 465
    //   42: lcmp
    //   43: ifeq +17 -> 60
    //   46: aload 5
    //   48: ldc 117
    //   50: lload_3
    //   51: invokestatic 469	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: invokeinterface 470 3 0
    //   59: pop
    //   60: aload 5
    //   62: ldc_w 472
    //   65: aload_1
    //   66: invokeinterface 470 3 0
    //   71: pop
    //   72: ldc 2
    //   74: invokevirtual 475	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   77: iconst_1
    //   78: new 307	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 477
    //   88: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: lload_3
    //   92: invokevirtual 480	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: ldc_w 482
    //   98: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 486	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 5
    //   113: astore_1
    //   114: aconst_null
    //   115: ldc_w 301
    //   118: ldc_w 303
    //   121: ldc_w 303
    //   124: ldc_w 488
    //   127: ldc_w 488
    //   130: iconst_0
    //   131: iconst_0
    //   132: ldc_w 303
    //   135: iload_2
    //   136: invokestatic 490	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   139: ldc_w 303
    //   142: invokestatic 320	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:a	()Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 325	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   149: aload_0
    //   150: ldc_w 491
    //   153: getstatic 495	omm:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   156: iconst_0
    //   157: iload_2
    //   158: aload_1
    //   159: invokestatic 350	nut:a	(Landroid/content/Context;ILjava/lang/String;IILjava/util/Map;)V
    //   162: return
    //   163: astore 5
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 498	org/json/JSONException:printStackTrace	()V
    //   172: goto -58 -> 114
    //   175: astore 6
    //   177: aload 5
    //   179: astore_1
    //   180: aload 6
    //   182: astore 5
    //   184: goto -17 -> 167
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -75 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   0	192	2	paramInt	int
    //   28	64	3	l	long
    //   36	76	5	localHashMap	HashMap
    //   163	15	5	localJSONException1	org.json.JSONException
    //   182	1	5	localObject	Object
    //   175	6	6	localJSONException2	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   12	38	163	org/json/JSONException
    //   46	60	175	org/json/JSONException
    //   60	111	175	org/json/JSONException
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (BaseActivity.sTopActivity != null) {
      paramContext = BaseActivity.sTopActivity;
    }
    if (paramContext == null) {}
    while (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString1));
    localIntent.putExtra("big_brother_source_key", onk.f(paramInt));
    localIntent.putExtra("launch_app_time", System.currentTimeMillis());
    paramString1 = new nuu(paramBoolean, paramString2, paramContext, paramString1);
    jdField_a_of_type_Int = amav.a().a(paramString1);
    localIntent.putExtra("key_callback_id", jdField_a_of_type_Int);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int k = 0;
    int m = 0;
    if ((paramContext == null) || (paramHashMap == null)) {
      return;
    }
    String str2 = (String)paramHashMap.get("appSchema");
    Object localObject = (String)paramHashMap.get("appPackageName");
    String str1 = (String)paramHashMap.get("isCancelJump");
    if ((str1 != null) && ("1".equals(str1))) {}
    int j;
    label515:
    label529:
    label572:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bbfd.a(paramContext, (String)localObject);
      str1 = (String)paramHashMap.get("defaultURL");
      paramHashMap = (String)paramHashMap.get("channelID");
      if ((!TextUtils.isEmpty(paramHashMap)) && (TextUtils.isDigitsOnly(paramHashMap))) {}
      for (j = Integer.valueOf(paramHashMap).intValue();; j = 0)
      {
        for (;;)
        {
          paramHashMap = new StringBuilder();
          if (!a((String)localObject)) {
            break;
          }
          try
          {
            paramContext = (Context)new WeakReference(paramContext).get();
            if (paramContext == null) {
              break;
            }
            str1 = URLDecoder.decode(str1, "utf-8");
            str2 = a((String)localObject, URLDecoder.decode(str2, "utf-8"));
            paramHashMap.append("appSchema:" + str2 + " appPackageName:" + (String)localObject + " defaultUrl:" + str1);
            if (!bool2) {
              break label529;
            }
            localObject = Aladdin.getConfig(159);
            if (localObject == null) {
              break label572;
            }
            i = ((AladdinConfig)localObject).getIntegerFromString("privateOpenUrl", 0);
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              Runtime localRuntime;
              paramHashMap.append(" startApp error:" + paramContext.toString());
              continue;
              a(paramContext, str2, j, str1, bool1);
              continue;
              int i = k;
              if (!Achilles.a(localException, true))
              {
                onk.f(paramContext, str1);
                if (bool1) {}
                for (i = 1;; i = 0)
                {
                  onk.a(str2, 2, i);
                  i = k;
                  break;
                }
                i = 0;
              }
            }
          }
        }
        if (1 != i) {
          break label515;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("am start --user 0");
        ((StringBuilder)localObject).append(" -a android.intent.action.VIEW");
        ((StringBuilder)localObject).append(" -d " + str2);
        localObject = ((StringBuilder)localObject).toString();
        localRuntime = Runtime.getRuntime();
        if (localRuntime != null) {}
        try
        {
          localRuntime.exec((String)localObject);
          k = m;
          if (bool1) {
            k = 1;
          }
          onk.a(str2, 1, k);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            a(paramContext, str2, j, str1, bool1);
            paramHashMap.append(" runtime.exec error:" + localException.toString());
          }
        }
        paramHashMap.append("hasInstalled:" + bool2 + " configSwitch:" + i);
        paramHashMap.append(" hasInstalled:" + bool2);
        QLog.e("ReadInJoyActivityHelper", 1, paramHashMap.toString());
        return;
      }
    }
  }
  
  public static void a(Context paramContext, List<Long> paramList, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIntent.putExtra("subscription_all_article_id", (Serializable)paramList);
      QLog.i("ReadInJoyActivityHelper", 1, paramList.toString());
    }
    if (paramLong != -1L) {
      localIntent.putExtra("subscription_click_article_id", paramLong);
    }
    if (paramInt == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      ((KandianMergeManager)BaseApplicationImpl.getApplication().getRuntime().getManager(162)).g();
      return;
      localIntent.putExtra("from_search", false);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
      localIntent.putExtra("shouldBackSelfAct", true);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
      localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramQQAppInterface, paramContext, paramInt1, paramInt2, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    if (paramInt1 == 2) {
      localIntent.setFlags(131072);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    if (bhvh.c(paramQQAppInterface)) {}
    for (localIntent = new Intent(paramContext, ReadInJoySettingActivity.class);; localIntent = a(paramContext, paramInt1))
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramContext.startActivity(localIntent);
      if ((paramInt2 == 0) && (!bhvh.k())) {
        ((KandianMergeManager)paramQQAppInterface.getManager(162)).g();
      }
      return;
      if (!bhvh.k()) {
        break;
      }
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt1);
      qvn.a().a(true, "init", 1);
      break;
      if (paramInt1 == 9)
      {
        onk.a(true);
        localIntent.putExtra("from_lock_screen", true);
        ont.a(localIntent);
        QLog.d(nut.class.getSimpleName(), 2, "start kandian activity, launch from lock screen");
      }
      else
      {
        localIntent.putExtra("from_search", false);
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!"com.tencent.reading".equalsIgnoreCase(paramString)) && (!"com.tencent.rijvideo".equalsIgnoreCase(paramString)))
      {
        bool1 = bool2;
        if (!"com.tencent.weishi".equalsIgnoreCase(paramString)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Intent b(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt1);
    localIntent.putExtra("tab_index", MainFragment.i);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.putExtra("arg_channel_cover_id", paramInt2);
    localIntent.setFlags(335544320);
    Object localObject1;
    Object localObject2;
    if (paramInt1 != 9)
    {
      localObject1 = localIntent;
      if (paramInt1 != 6) {}
    }
    else
    {
      onk.a(true);
      ont.a(localIntent);
      localObject2 = onk.a();
      localObject1 = localIntent;
      if (localObject2 != null)
      {
        localObject1 = localIntent;
        if (bhvh.k())
        {
          localObject2 = ((KandianMergeManager)((QQAppInterface)localObject2).getManager(162)).a();
          localObject1 = localIntent;
          if (localObject2 != null)
          {
            localObject1 = localIntent;
            if (TextUtils.isEmpty(((KandianRedDotInfo)localObject2).extInfo)) {}
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(((KandianRedDotInfo)localObject2).extInfo).optInt("jump_daily_channel", 0) == 1)
        {
          paramInt2 = 1;
          if (paramInt2 != 0)
          {
            paramContext = a(paramContext, paramInt1, (KandianRedDotInfo)localObject2);
            localObject1 = paramContext;
            return localObject1;
          }
        }
        else
        {
          paramInt2 = 0;
          continue;
        }
        paramContext = localIntent;
      }
      catch (Exception paramContext)
      {
        return localIntent;
      }
    }
  }
  
  public static Intent b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Intent localIntent = new Intent(paramContext, FastWebActivity.class);
    try
    {
      Object localObject = (String)paramHashMap.get("strategyId");
      String str1 = (String)paramHashMap.get("algorithmID");
      String str2 = (String)paramHashMap.get("url");
      String str3 = (String)paramHashMap.get("rowkey");
      paramContext = (String)paramHashMap.get("fromType");
      paramContext = (String)paramHashMap.get("commenId");
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = (String)paramHashMap.get("commentId");
        String str4 = (String)paramHashMap.get("subCommentId");
        String str5 = (String)paramHashMap.get("jumpCommentType");
        paramHashMap = (String)paramHashMap.get("isAwesome");
        if (str3 != null) {
          localArticleInfo.innerUniqueID = str3;
        }
        if (str2 != null) {
          localArticleInfo.mArticleContentUrl = new String(bbca.decode(str2, 0));
        }
        if (localObject != null) {
          localArticleInfo.mStrategyId = Integer.valueOf((String)localObject).intValue();
        }
        if (str1 != null) {
          localArticleInfo.mAlgorithmID = Long.valueOf(str1).longValue();
        }
        localObject = new AnchorData();
        ((AnchorData)localObject).jdField_a_of_type_JavaLangString = paramContext;
        ((AnchorData)localObject).jdField_b_of_type_JavaLangString = str4;
        ((AnchorData)localObject).jdField_b_of_type_Boolean = "0".equals(str5);
        ((AnchorData)localObject).jdField_a_of_type_Boolean = "1".equals(paramHashMap);
        localIntent.putExtra("intent_key_anchor_data", (Parcelable)localObject);
        localIntent.putExtra("fast_web_article_info", localArticleInfo);
        return localIntent;
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("tab_index", MainFragment.i);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.setFlags(335544320);
    if ((paramInt == 9) || (paramInt == 6))
    {
      onk.a(true);
      ont.a(localIntent);
    }
    if (paramContext != null) {
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    b(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyVideoSubChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = new ReadInJoyChannelActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", paramString);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((paramContext == null) || (paramHashMap == null)) {
      return;
    }
    String str1 = (String)paramHashMap.get("rowKey");
    String str2 = (String)paramHashMap.get("videoType");
    String str3 = (String)paramHashMap.get("videoVid");
    String str4 = (String)paramHashMap.get("videoWidth");
    String str5 = (String)paramHashMap.get("videoHeight");
    String str6 = (String)paramHashMap.get("videoDuration");
    String str7 = (String)paramHashMap.get("title");
    String str13 = (String)paramHashMap.get("firstPagePicUrl");
    String str15 = (String)paramHashMap.get("articleContentUrl");
    String str8 = (String)paramHashMap.get("subscribeID");
    String str9 = (String)paramHashMap.get("subscribeName");
    String str10 = (String)paramHashMap.get("sourceFrom");
    Object localObject = (String)paramHashMap.get("commentId");
    String str16 = (String)paramHashMap.get("subCommentId");
    String str17 = (String)paramHashMap.get("isAwesome");
    String str18 = (String)paramHashMap.get("jumpCommentType");
    String str11 = (String)paramHashMap.get("strategyId");
    String str12 = (String)paramHashMap.get("algorithmID");
    String str14 = (String)paramHashMap.get("channelID");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      AnchorData localAnchorData = new AnchorData();
      localAnchorData.jdField_a_of_type_JavaLangString = ((String)localObject);
      localAnchorData.jdField_b_of_type_JavaLangString = str16;
      localAnchorData.jdField_a_of_type_Boolean = "1".equals(str17);
      localAnchorData.jdField_b_of_type_Boolean = "0".equals(str18);
      paramHashMap = new Bundle();
      paramHashMap.putBoolean("VIDEO_SHOW_COMMENT", true);
      paramHashMap.putParcelable("VIDEO_COMMENT_ANCHOR", localAnchorData);
    }
    for (;;)
    {
      localObject = paramHashMap;
      if (paramHashMap == null) {
        localObject = new Bundle();
      }
      for (;;)
      {
        try
        {
          paramHashMap = URLDecoder.decode(str15, "utf-8");
          str13 = URLDecoder.decode(str13, "utf-8");
          int j = 0;
          int k = 0;
          if (str2 != null) {
            j = Integer.valueOf(str2).intValue();
          }
          if (str4 != null) {
            k = Integer.valueOf(str4).intValue();
          }
          if (str5 == null) {
            break label586;
          }
          m = Integer.valueOf(str5).intValue();
          if (str6 == null) {
            break label580;
          }
          n = Integer.valueOf(str6).intValue();
          if (TextUtils.isEmpty(str10)) {
            break label575;
          }
          if ("nativeArticleRecommend".equalsIgnoreCase(str10))
          {
            i = 10;
            if (str11 != null) {
              ((Bundle)localObject).putInt("VIDEO_STRATEGY_ID", Integer.valueOf(str11).intValue());
            }
            if (str12 != null) {
              ((Bundle)localObject).putLong("VIDEO_ALGORITHM_ID", Long.valueOf(str12).longValue());
            }
            if (str14 != null) {
              ((Bundle)localObject).putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", Integer.valueOf(str14).intValue());
            }
            qol.a((Activity)paramContext, (Bundle)localObject, i, str1, j, str3, k, m, n, str7, str13, paramHashMap, str9, str8, 0L, false, 0L, 0, null, null, null, null, null);
            return;
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("ReadInJoyActivityHelper", 1, "openFullVideoPlayerror ." + paramContext.toString());
          return;
        }
        int i = Integer.valueOf(str10).intValue();
        continue;
        label575:
        i = -1;
        continue;
        label580:
        int n = 0;
        continue;
        label586:
        int m = 0;
      }
      paramHashMap = null;
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    localIntent.putExtra("redTouch", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public static void c(Context paramContext, HashMap<String, String> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramHashMap == null)
    {
      QLog.d("ReadInJoyActivityHelper", 1, new Object[] { "openDailyDynamicChildFeeds log=", localStringBuilder.toString() });
      return;
    }
    label243:
    for (;;)
    {
      try
      {
        String str1 = (String)paramHashMap.get("channelID");
        String str2 = (String)paramHashMap.get("channelName");
        if (paramContext != null) {
          break label243;
        }
        paramContext = BaseActivity.sTopActivity;
        if ((paramContext == null) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
          break;
        }
        Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
        localIntent.putExtra("channel_id", Integer.valueOf(str1));
        localIntent.putExtra("channel_name", str2);
        localIntent.putExtra("channel_map_data", paramHashMap);
        localIntent.putExtra("is_daily_dynamic_child_channel", true);
        paramContext.startActivity(localIntent);
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(2130771981, 0);
        }
        paramContext = (String)paramHashMap.get("requestData");
        if (!TextUtils.isEmpty(paramContext)) {
          bhvh.a("DAILY_CHILD_FEEDS_REQUEST_CONFIG" + str1, paramContext);
        }
        localStringBuilder.append(str1);
        localStringBuilder.append(str2);
        localStringBuilder.append(paramContext);
      }
      catch (Exception paramContext)
      {
        localStringBuilder.append(paramContext.toString());
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nut
 * JD-Core Version:    0.7.0.1
 */