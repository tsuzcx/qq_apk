import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
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

public class oix
{
  private static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://kandian.qq.com/mqq/html/settingInterest.html?_wv=1027&_bid=2378";
    jdField_a_of_type_Int = -1;
  }
  
  private static int a(@NonNull Intent paramIntent)
  {
    int i = 0;
    if (paramIntent.getBooleanExtra("daily_lock_screen_param", false)) {
      i = pbd.b();
    }
    return i;
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
    paramContext.putExtra("native_article_launch_from", 1002);
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
    paramString1 = qiy.a().a(paramString2);
    return paramString1;
  }
  
  public static void a(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("VIDEO_FEEDS_ANIM_ENABLE", false);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", a(paramIntent));
    rpt.a(paramActivity, localBundle, paramIntent.getStringExtra("pushRowKey"), 27);
    QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpVideoFeedsPlayActivity: rowKey:" + str);
  }
  
  public static void a(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt)
  {
    String str = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpFloatingWindow: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("floating_window_rowkey", paramIntent.getStringExtra("pushRowKey"));
    localBundle.putString("float_layer_topic_id", paramIntent.getStringExtra("topicId"));
    localBundle.putString("float_layer_article_url", paramIntent.getStringExtra("articleUrl"));
    a(paramIntent, localBundle);
    localBundle.putInt("RETURN_SCENE", paramIntent.getIntExtra("return_scene", 0));
    localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", a(paramIntent));
    if ((paramInt != 1) || (bnrm.a(localBundle))) {
      oyc.a(32);
    }
    bnrm.a(paramActivity, 3, paramInt, localBundle, a(paramIntent));
    QLog.d("ReadInJoyActivityHelper", 1, "jumpFloatingWindow: rowKey:" + str);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    paramHashMap = (String)paramHashMap.get("sourceFrom");
    j = -1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramHashMap)) {
          continue;
        }
        boolean bool = "nativeArticleRecommend".equalsIgnoreCase(paramHashMap);
        if (!bool) {
          continue;
        }
        i = 10;
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoyActivityHelper", 2, "openEmptyFullPlayActivity: ", paramHashMap);
        i = j;
        continue;
        i = -1;
        continue;
      }
      rpt.a(paramActivity, null, true, i);
      return;
      i = Integer.valueOf(paramHashMap).intValue();
    }
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
    Intent localIntent = new Intent(paramContext, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("launch_from", paramInt);
    localIntent.putExtra("tab_index", MainFragment.i);
    localIntent.putExtra("open_kandian_tab_fragment", true);
    localIntent.setFlags(335544320);
    if ((paramInt == 9) || (paramInt == 6))
    {
      ozs.a(true);
      pac.a(localIntent);
    }
    if (paramContext != null) {
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramContext == null) {}
    while (qhq.a(paramContext)) {
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
    localIntent.putExtra("channel_name", anzj.a(2131711897));
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
      if (sel.q(paramArticleInfo2)) {
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
      odr.a.put(ReadInJoyChannelActivity.class, odr.b());
      rxg.a().a(false, "jumpFromKandianFeed", 1);
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
    //   6: invokestatic 172	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +178 -> 187
    //   12: new 553	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 556	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: ldc_w 558
    //   23: iconst_m1
    //   24: invokevirtual 561	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   27: i2l
    //   28: lstore_3
    //   29: new 76	java/util/HashMap
    //   32: dup
    //   33: invokespecial 562	java/util/HashMap:<init>	()V
    //   36: astore 5
    //   38: lload_3
    //   39: ldc2_w 563
    //   42: lcmp
    //   43: ifeq +17 -> 60
    //   46: aload 5
    //   48: ldc 94
    //   50: lload_3
    //   51: invokestatic 567	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   54: invokeinterface 568 3 0
    //   59: pop
    //   60: aload 5
    //   62: ldc_w 570
    //   65: aload_1
    //   66: invokeinterface 568 3 0
    //   71: pop
    //   72: ldc 2
    //   74: invokevirtual 575	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   77: iconst_1
    //   78: new 285	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 577
    //   88: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: lload_3
    //   92: invokevirtual 580	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: ldc_w 582
    //   98: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_1
    //   102: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 5
    //   113: astore_1
    //   114: aconst_null
    //   115: ldc_w 584
    //   118: ldc_w 586
    //   121: ldc_w 586
    //   124: ldc_w 588
    //   127: ldc_w 588
    //   130: iconst_0
    //   131: iconst_0
    //   132: ldc_w 586
    //   135: iload_2
    //   136: invokestatic 590	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   139: ldc_w 586
    //   142: invokestatic 594	com/tencent/biz/pubaccount/readinjoy/activity/ReadInJoyBaseDeliverActivity:a	()Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 599	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   149: aload_0
    //   150: ldc_w 600
    //   153: getstatic 604	oyu:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   156: iconst_0
    //   157: iload_2
    //   158: aload_1
    //   159: invokestatic 444	oix:a	(Landroid/content/Context;ILjava/lang/String;IILjava/util/Map;)V
    //   162: return
    //   163: astore 5
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 605	org/json/JSONException:printStackTrace	()V
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
    localIntent.putExtra("big_brother_source_key", ozs.f(paramInt));
    localIntent.putExtra("launch_app_time", System.currentTimeMillis());
    paramString1 = new oiy(new WeakReference(paramContext), paramBoolean, paramString2, paramString1);
    jdField_a_of_type_Int = aqjx.a().a(paramString1);
    localIntent.putExtra("key_callback_id", jdField_a_of_type_Int);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int j = 0;
    if ((paramContext == null) || (paramHashMap == null)) {
      return;
    }
    String str2 = (String)paramHashMap.get("appSchema");
    String str1 = (String)paramHashMap.get("appPackageName");
    String str3 = (String)paramHashMap.get("isCancelJump");
    if ((str3 != null) && ("1".equals(str3))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bhny.a(paramContext, str1);
      str3 = (String)paramHashMap.get("defaultURL");
      paramHashMap = (String)paramHashMap.get("channelID");
      int i;
      if ((!TextUtils.isEmpty(paramHashMap)) && (TextUtils.isDigitsOnly(paramHashMap)))
      {
        i = Integer.valueOf(paramHashMap).intValue();
        label118:
        paramHashMap = new StringBuilder();
        if (!a(str1)) {
          break;
        }
      }
      for (;;)
      {
        try
        {
          paramContext = (Context)new WeakReference(paramContext).get();
          if (paramContext == null) {
            break;
          }
          str3 = URLDecoder.decode(str3, "utf-8");
          str2 = a(str1, URLDecoder.decode(str2, "utf-8"));
          paramHashMap.append("appSchema:" + str2 + " appPackageName:" + str1 + " defaultUrl:" + str3);
          if (!bool2) {
            continue;
          }
          a(paramContext, str2, i, str3, bool1);
          paramHashMap.append("hasInstalled:" + bool2 + " configSwitch:" + 0);
        }
        catch (Exception paramContext)
        {
          paramHashMap.append(" startApp error:" + paramContext.toString());
          continue;
        }
        paramHashMap.append(" hasInstalled:" + bool2);
        QLog.e("ReadInJoyActivityHelper", 1, paramHashMap.toString());
        return;
        i = 0;
        break label118;
        if (!Achilles.a(str1, true))
        {
          ozs.e(paramContext, str3);
          i = j;
          if (bool1) {
            i = 1;
          }
          ozs.a(str2, 2, i);
        }
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
      ((KandianMergeManager)BaseApplicationImpl.getApplication().getRuntime().getManager(162)).h();
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
  
  private static void a(@NonNull Intent paramIntent, @NonNull Bundle paramBundle)
  {
    paramBundle.putBoolean("daily_lock_screen_param", paramIntent.getBooleanExtra("daily_lock_screen_param", false));
    paramBundle.putBoolean("kan_dian_lock_screen_param", paramIntent.getBooleanExtra("kan_dian_lock_screen_param", false));
    paramBundle.putInt("daily_lock_screen_article_report_jump_type", paramIntent.getIntExtra("jumpType", 0));
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
    if (bnrf.c(paramQQAppInterface)) {}
    for (localIntent = new Intent(paramContext, ReadInJoySettingActivity.class);; localIntent = a(paramContext, paramInt1))
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      paramContext.startActivity(localIntent);
      if ((paramInt2 == 0) && (!bnrf.j())) {
        ((KandianMergeManager)paramQQAppInterface.getManager(162)).h();
      }
      return;
      if (!bnrf.j()) {
        break;
      }
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt1);
      rxg.a().a(true, "init", 1);
      break;
      if (paramInt1 == 9)
      {
        ozs.a(true);
        localIntent.putExtra("from_lock_screen", true);
        pac.a(localIntent);
        QLog.d(oix.class.getSimpleName(), 2, "start kandian activity, launch from lock screen");
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
  
  public static Intent b(Context paramContext, int paramInt)
  {
    if ((paramInt == 9) || (paramInt == 6)) {
      return ReadInJoyLockScreenJumpDelegate.a(paramContext, paramInt, 0);
    }
    return new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
  }
  
  public static Intent b(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent2 = new Intent(paramContext, SplashActivity.class);
    localIntent2.putExtra("fragment_id", 1);
    localIntent2.putExtra("launch_from", paramInt1);
    localIntent2.putExtra("tab_index", MainFragment.i);
    localIntent2.putExtra("open_kandian_tab_fragment", true);
    localIntent2.putExtra("arg_channel_cover_id", paramInt2);
    localIntent2.setFlags(335544320);
    Intent localIntent1;
    if (paramInt1 != 9)
    {
      localIntent1 = localIntent2;
      if (paramInt1 != 6) {}
    }
    else
    {
      ozs.a(true);
      pac.a(localIntent2);
      localIntent1 = ReadInJoyLockScreenJumpDelegate.a(paramContext, paramInt1, paramInt2);
    }
    return localIntent1;
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
          localArticleInfo.mArticleContentUrl = new String(bhkv.decode(str2, 0));
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
  
  public static void b(@NonNull Activity paramActivity, @NonNull Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("pushRowKey");
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("ReadInJoyActivityHelper", 1, "jumpFastWebActivity: open native article detail rowKey is null");
      return;
    }
    Bundle localBundle = new Bundle();
    Intent localIntent = new Intent(paramActivity, FastWebActivity.class);
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.innerUniqueID = str1;
    localArticleInfo.mChannelID = a(paramIntent);
    String str2 = paramIntent.getStringExtra("articleUrl");
    if (!TextUtils.isEmpty(str2)) {
      localArticleInfo.mArticleContentUrl = str2;
    }
    localIntent.putExtra("fast_web_article_info", localArticleInfo);
    a(paramIntent, localBundle);
    localIntent.putExtras(localBundle);
    paramActivity.startActivity(localIntent);
    QLog.d("ReadInJoyActivityHelper", 1, "lockScreenJumpFastWebActivity: rowKey:" + str1 + " articleUrl: " + str2);
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
    if ("1".equals(paramHashMap.get("isEmptyVideo"))) {
      a((Activity)paramContext, paramHashMap);
    }
    String str5 = (String)paramHashMap.get("rowKey");
    String str6 = (String)paramHashMap.get("videoType");
    String str7 = (String)paramHashMap.get("videoVid");
    String str8 = (String)paramHashMap.get("videoWidth");
    String str9 = (String)paramHashMap.get("videoHeight");
    String str10 = (String)paramHashMap.get("videoDuration");
    String str11 = (String)paramHashMap.get("title");
    String str3 = (String)paramHashMap.get("firstPagePicUrl");
    String str4 = (String)paramHashMap.get("articleContentUrl");
    String str12 = (String)paramHashMap.get("subscribeID");
    String str13 = (String)paramHashMap.get("subscribeName");
    String str14 = (String)paramHashMap.get("sourceFrom");
    Object localObject = (String)paramHashMap.get("commentId");
    String str28 = (String)paramHashMap.get("subCommentId");
    String str29 = (String)paramHashMap.get("isAwesome");
    String str30 = (String)paramHashMap.get("jumpCommentType");
    String str15 = (String)paramHashMap.get("strategyId");
    String str16 = (String)paramHashMap.get("algorithmID");
    String str17 = (String)paramHashMap.get("channelID");
    if (paramHashMap.containsKey("percentage")) {}
    for (String str1 = (String)paramHashMap.get("percentage");; str1 = null)
    {
      String str18 = (String)paramHashMap.get("playerSessionId");
      String str19 = (String)paramHashMap.get("sessionId");
      String str20 = (String)paramHashMap.get("columnId");
      String str21 = (String)paramHashMap.get("videoToken");
      String str22 = (String)paramHashMap.get("topicId");
      String str23 = (String)paramHashMap.get("topicCookie");
      String str24 = (String)paramHashMap.get("disActivityAnim");
      String str2 = (String)paramHashMap.get("backColor");
      String str25 = (String)paramHashMap.get("forceNative");
      if (!TextUtils.isEmpty(str2)) {}
      for (str2 = "#" + str2;; str2 = null)
      {
        String str26 = (String)paramHashMap.get("thirdName");
        String str27 = (String)paramHashMap.get("thirdIcon");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          AnchorData localAnchorData = new AnchorData();
          localAnchorData.jdField_a_of_type_JavaLangString = ((String)localObject);
          localAnchorData.jdField_b_of_type_JavaLangString = str28;
          localAnchorData.jdField_a_of_type_Boolean = "1".equals(str29);
          localAnchorData.jdField_b_of_type_Boolean = "0".equals(str30);
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
          if (str4 != null) {}
          for (;;)
          {
            try
            {
              paramHashMap = URLDecoder.decode(str4, "utf-8");
              if (str3 == null) {
                break label1036;
              }
              str3 = URLDecoder.decode(str3, "utf-8");
              int j = 0;
              int k = 0;
              if (!TextUtils.isEmpty(str6)) {
                j = Integer.parseInt(str6);
              }
              if (!TextUtils.isEmpty(str8)) {
                k = Integer.parseInt(str8);
              }
              if (TextUtils.isEmpty(str9)) {
                break label1030;
              }
              m = Integer.parseInt(str9);
              if (TextUtils.isEmpty(str10)) {
                break label1024;
              }
              n = Integer.parseInt(str10);
              if (TextUtils.isEmpty(str14)) {
                break label1019;
              }
              if ("nativeArticleRecommend".equalsIgnoreCase(str14))
              {
                i = 10;
                if (!TextUtils.isEmpty(str15)) {
                  ((Bundle)localObject).putInt("VIDEO_STRATEGY_ID", Integer.parseInt(str15));
                }
                if (!TextUtils.isEmpty(str16)) {
                  ((Bundle)localObject).putLong("VIDEO_ALGORITHM_ID", Long.parseLong(str16));
                }
                if (!TextUtils.isEmpty(str17)) {
                  ((Bundle)localObject).putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", Integer.parseInt(str17));
                }
                if (!TextUtils.isEmpty(str1)) {
                  ((Bundle)localObject).putLong("VIDEO_PLAY_POSITION", Long.parseLong(str1));
                }
                if (!TextUtils.isEmpty(str18)) {
                  ((Bundle)localObject).putString("video_player_session_id", str18);
                }
                if (!TextUtils.isEmpty(str19)) {
                  ((Bundle)localObject).putString("session_id", str19);
                }
                if (!TextUtils.isEmpty(str20)) {
                  ((Bundle)localObject).putInt("VIDEO_COLUMN_ID", Integer.parseInt(str20));
                }
                if (i == 31) {
                  ((Bundle)localObject).putInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 7);
                }
                if (!TextUtils.isEmpty(str22)) {
                  ((Bundle)localObject).putString("video_column_topic_id", str22);
                }
                if (!TextUtils.isEmpty(str23)) {
                  ((Bundle)localObject).putString("video_column_topic_cookie", str23);
                }
                if (!TextUtils.isEmpty(str24)) {
                  ((Bundle)localObject).putString("enable_video_feeds_default_anim", str24);
                }
                if (!TextUtils.isEmpty(str25)) {
                  ((Bundle)localObject).putString("video_feeds_force_native", str25);
                }
                if (bnrf.g(i)) {
                  ((Bundle)localObject).putInt("video_feeds_req_sub_source", 7);
                }
                if (!TextUtils.isEmpty(str2)) {
                  ((Bundle)localObject).putString("video_feeds_back_color", str2);
                }
                if (!TextUtils.isEmpty(str27)) {
                  ((Bundle)localObject).putString("VIDEO_THIRD_ICON", str27);
                }
                if (!TextUtils.isEmpty(str26)) {
                  ((Bundle)localObject).putString("VIDEO_THIRD_NAME", str26);
                }
                ((Bundle)localObject).putString("FIRST_VIDEO_TOKEN", str21);
                rpt.a((Activity)paramContext, (Bundle)localObject, i, str5, j, str7, k, m, n, str11, str3, paramHashMap, str13, str12, 0L, false, 0L, 0, null, null, null, null, null);
                return;
              }
            }
            catch (Exception paramContext)
            {
              QLog.e("ReadInJoyActivityHelper", 1, "openFullVideoPlayerror ", paramContext);
              return;
            }
            int i = Integer.parseInt(str14);
            continue;
            label1019:
            i = -1;
            continue;
            label1024:
            int n = 0;
            continue;
            label1030:
            int m = 0;
            continue;
            label1036:
            continue;
            paramHashMap = str4;
          }
          paramHashMap = null;
        }
      }
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
          bnrf.a("DAILY_CHILD_FEEDS_REQUEST_CONFIG" + str1, paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oix
 * JD-Core Version:    0.7.0.1
 */