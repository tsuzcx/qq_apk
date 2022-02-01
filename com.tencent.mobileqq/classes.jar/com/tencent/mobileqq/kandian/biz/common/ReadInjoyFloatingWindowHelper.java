package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInjoyFloatingWindowHelper
{
  public static int a(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < 0.0F) {
      f = 1.0F;
    }
    return (int)(paramFloat2 / f + 0.5F);
  }
  
  private static int a(int paramInt)
  {
    Object localObject1 = Aladdin.getConfig(265).getString("floating_layer_top_margin", "");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return -1;
      }
      localObject1 = new JSONObject((String)localObject1).optString("top_margin", "");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" getFloatingWindowHeight! marginContent=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInjoyFloatingWindowModule", 1, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return -1;
      }
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        Object localObject3 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject3 != null)
        {
          localObject2 = ((JSONObject)localObject3).optString("type", "");
          localObject3 = ((JSONObject)localObject3).optString("margin", "");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
            if (!bool) {
              try
              {
                int j = Integer.parseInt((String)localObject2);
                float f = Float.parseFloat((String)localObject3);
                if (j == paramInt)
                {
                  j = a(paramInt, f);
                  return j;
                }
              }
              catch (Exception localException2)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(" getFloatingWindowHeight array error! msg=");
                ((StringBuilder)localObject3).append(localException2);
                QLog.d("ReadInjoyFloatingWindowModule", 1, ((StringBuilder)localObject3).toString());
              }
            }
          }
        }
        i += 1;
      }
      StringBuilder localStringBuilder;
      return -1;
    }
    catch (Exception localException1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getFloatingWindowHeight error! msg=");
      localStringBuilder.append(localException1);
      QLog.d("ReadInjoyFloatingWindowModule", 1, localStringBuilder.toString());
    }
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    int j = (int)paramFloat;
    float f2 = -1.0F;
    float f1 = f2;
    int i;
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      f1 = f2;
      f2 = localDisplayMetrics.density;
      i = j;
      f1 = f2;
      if (paramFloat > 0.0F)
      {
        i = j;
        f1 = f2;
        if (paramFloat < 1.0F)
        {
          f1 = f2;
          i = localDisplayMetrics.heightPixels;
          int k = (int)(i * paramFloat);
          i = j;
          f1 = f2;
          if (k > 0)
          {
            i = k;
            f1 = f2;
          }
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(" getMarginTop error! msg=");
      localStringBuilder2.append(localException);
      QLog.d("ReadInjoyFloatingWindowModule", 1, localStringBuilder2.toString());
      i = j;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(" getMarginTop,busiType=");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append(" ,configMarginPx=");
    localStringBuilder1.append(paramFloat);
    localStringBuilder1.append("  ,realMarginPx=");
    localStringBuilder1.append(i);
    QLog.d("ReadInjoyFloatingWindowModule", 1, localStringBuilder1.toString());
    if (f1 > 0.0F) {
      return a(f1, i);
    }
    return -1;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Bundle paramBundle, int paramInt3)
  {
    if (paramContext == null) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    int i = a(paramInt2);
    if ((i > 0) && (i < 10000)) {
      localBundle.putInt("margin_top", i);
    }
    localBundle.putInt("floating_window_scene", paramInt1);
    localBundle.putInt("floating_window_business", paramInt2);
    if (paramInt1 == 4) {
      localBundle.putBoolean("float_layer_back_view", true);
    }
    if (paramInt2 != 1)
    {
      if ((paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 4)) {
        ViolaAccessHelper.a(paramContext, paramInt2, localBundle);
      }
    }
    else {
      a(paramContext, paramInt1, localBundle, paramInt3);
    }
    paramContext = new StringBuilder();
    paramContext.append(" openFloatingWindow : scene=");
    paramContext.append(paramInt1);
    paramContext.append("  busiType=");
    paramContext.append(paramInt2);
    paramContext.append("\t marginTop=");
    paramContext.append(i);
    paramContext.append("\t bundle=");
    paramContext.append(localBundle);
    QLog.d("ReadInjoyFloatingWindowModule", 1, paramContext.toString());
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramInt3, paramBoolean, null);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openViolaActivityOnKandianDaily scene: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" luanchFrom: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" rowKey: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" topicId: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" busiType: ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append(" needGrayBar: ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("ReadInjoyFloatingWindowModule", 1, (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("floating_window_scene", paramInt1);
    ((Bundle)localObject).putString("floating_window_rowkey", paramString1);
    ((Bundle)localObject).putString("float_layer_topic_id", paramString2);
    ((Bundle)localObject).putBoolean("up_animation", false);
    ((Bundle)localObject).putBoolean("gray_bar", paramBoolean);
    ((Bundle)localObject).putInt("floating_window_business", paramInt3);
    if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_scroll_to_top", 0) == 1) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((Bundle)localObject).putBoolean("scroll_to_top", paramBoolean);
    ((Bundle)localObject).putBundle("floating_bundle_extra_data", paramBundle);
    ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(paramContext, false, (Bundle)localObject, paramInt2);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openNativeArticleOnKandianDaily scene: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" luanchFrom: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" rowKey: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" url: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" needGrayBar: ");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("ReadInjoyFloatingWindowModule", 1, (String)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("floating_window_scene", paramInt1);
    ((Bundle)localObject).putString("floating_window_rowkey", paramString1);
    ((Bundle)localObject).putString("float_layer_article_url", paramString2);
    ((Bundle)localObject).putBoolean("up_animation", false);
    ((Bundle)localObject).putBoolean("gray_bar", paramBoolean);
    ((Bundle)localObject).putInt("floating_window_business", 1);
    if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_scroll_to_top", 0) == 1) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((Bundle)localObject).putBoolean("scroll_to_top", paramBoolean);
    ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(paramContext, false, (Bundle)localObject, paramInt2);
  }
  
  private static void a(Context paramContext, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, FastWebActivity.class);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("launch_from_floating_window", true);
    localBundle.putInt("native_article_launch_from", 1003);
    localIntent.putExtras(localBundle);
    boolean bool = a(localBundle, localIntent, paramInt2);
    if (bool) {
      paramContext.startActivity(localIntent);
    }
    paramContext = new StringBuilder();
    paramContext.append(" openNativeArticle : scene=");
    paramContext.append(paramInt1);
    paramContext.append("  isLegal=");
    paramContext.append(bool);
    QLog.d("ReadInjoyFloatingWindowModule", 1, paramContext.toString());
  }
  
  /* Error */
  public static void a(Context paramContext, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 58
    //   6: iconst_1
    //   7: ldc_w 281
    //   10: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13: return
    //   14: aload_0
    //   15: astore 6
    //   17: aload_0
    //   18: ifnonnull +8 -> 26
    //   21: invokestatic 112	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   24: astore 6
    //   26: aload_1
    //   27: ldc_w 283
    //   30: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 291	java/lang/String
    //   36: astore 7
    //   38: aload_1
    //   39: ldc_w 293
    //   42: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   45: checkcast 291	java/lang/String
    //   48: astore 9
    //   50: aload_1
    //   51: ldc_w 295
    //   54: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 291	java/lang/String
    //   60: astore 8
    //   62: iconst_0
    //   63: istore 5
    //   65: aload_1
    //   66: ldc_w 297
    //   69: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 291	java/lang/String
    //   75: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore_2
    //   79: aload_1
    //   80: ldc_w 299
    //   83: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 291	java/lang/String
    //   89: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   92: istore_3
    //   93: aload_1
    //   94: ldc_w 301
    //   97: invokevirtual 289	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 291	java/lang/String
    //   103: invokestatic 89	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   106: istore 4
    //   108: goto +51 -> 159
    //   111: astore_0
    //   112: goto +12 -> 124
    //   115: astore_0
    //   116: goto +6 -> 122
    //   119: astore_0
    //   120: iconst_m1
    //   121: istore_2
    //   122: iconst_0
    //   123: istore_3
    //   124: new 49	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   131: astore_1
    //   132: aload_1
    //   133: ldc_w 303
    //   136: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_1
    //   141: aload_0
    //   142: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc 58
    //   148: iconst_1
    //   149: aload_1
    //   150: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: iconst_0
    //   157: istore 4
    //   159: iload_2
    //   160: iconst_m1
    //   161: if_icmpne +6 -> 167
    //   164: goto +41 -> 205
    //   167: aload 6
    //   169: ifnonnull +6 -> 175
    //   172: goto +33 -> 205
    //   175: iload_2
    //   176: iconst_4
    //   177: if_icmpne +14 -> 191
    //   180: aload 8
    //   182: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +20 -> 205
    //   188: goto +14 -> 202
    //   191: aload 7
    //   193: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +6 -> 202
    //   199: goto +6 -> 205
    //   202: iconst_1
    //   203: istore 5
    //   205: iload 5
    //   207: ifeq +103 -> 310
    //   210: new 153	android/os/Bundle
    //   213: dup
    //   214: invokespecial 154	android/os/Bundle:<init>	()V
    //   217: astore_0
    //   218: aload_0
    //   219: ldc 209
    //   221: aload 7
    //   223: invokevirtual 213	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 9
    //   228: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +17 -> 248
    //   234: aload_0
    //   235: ldc 252
    //   237: aload 9
    //   239: ldc_w 305
    //   242: invokestatic 310	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   245: invokevirtual 213	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload 8
    //   250: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   253: ifne +11 -> 264
    //   256: aload_0
    //   257: ldc 215
    //   259: aload 8
    //   261: invokevirtual 213	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload 6
    //   266: iload_3
    //   267: iload_2
    //   268: aload_0
    //   269: iload 4
    //   271: invokestatic 312	com/tencent/mobileqq/kandian/biz/common/ReadInjoyFloatingWindowHelper:a	(Landroid/content/Context;IILandroid/os/Bundle;I)V
    //   274: goto +36 -> 310
    //   277: astore_0
    //   278: new 49	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   285: astore_1
    //   286: aload_1
    //   287: ldc_w 314
    //   290: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_1
    //   295: aload_0
    //   296: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: ldc 58
    //   302: iconst_1
    //   303: aload_1
    //   304: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: new 49	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   317: astore_0
    //   318: aload_0
    //   319: ldc_w 316
    //   322: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_0
    //   327: iload_2
    //   328: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_0
    //   333: ldc_w 318
    //   336: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload_0
    //   341: aload 7
    //   343: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_0
    //   348: ldc_w 320
    //   351: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_0
    //   356: aload 8
    //   358: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_0
    //   363: ldc_w 322
    //   366: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_0
    //   371: iload_3
    //   372: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_0
    //   377: ldc_w 324
    //   380: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_0
    //   385: iload 4
    //   387: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: ldc 58
    //   393: iconst_1
    //   394: aload_0
    //   395: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramContext	Context
    //   0	402	1	paramHashMap	java.util.HashMap<String, String>
    //   78	250	2	i	int
    //   92	280	3	j	int
    //   106	280	4	k	int
    //   63	143	5	m	int
    //   15	250	6	localObject	Object
    //   36	306	7	str1	String
    //   60	297	8	str2	String
    //   48	190	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   93	108	111	java/lang/Exception
    //   79	93	115	java/lang/Exception
    //   65	79	119	java/lang/Exception
    //   210	248	277	java/lang/Exception
    //   248	264	277	java/lang/Exception
    //   264	274	277	java/lang/Exception
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject1 = Uri.parse(paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("openFloatLayer: ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d("ReadInjoyFloatingWindowModule", 1, ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      ((Uri)localObject1).getQueryParameter("viola_share_url");
      localObject2 = ((Uri)localObject1).getQueryParameter("rowkey");
      String str1 = ((Uri)localObject1).getQueryParameter("cc_media_type");
      String str2 = ((Uri)localObject1).getQueryParameter("viola_media_type");
      localObject1 = ((Uri)localObject1).getQueryParameter("topic_id");
      if ("10001".equals(str1))
      {
        a(paramContext, 4, 15, (String)localObject2, paramString, true);
        return true;
      }
      int i;
      if ("10050".equals(str2)) {
        i = 3;
      } else if ("10051".equals(str2)) {
        i = 4;
      } else if ("10052".equals(str2)) {
        i = 2;
      } else {
        i = -1;
      }
      if (i != -1)
      {
        a(paramContext, 4, 15, (String)localObject2, (String)localObject1, i, true);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openFloatLayerVideo: ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInjoyFloatingWindowModule", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramContext, 4, 15, paramString, "", 2, true, paramBundle);
      return true;
    }
    return false;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1;
    if (i >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (paramBundle != null)
    {
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (!TextUtils.isEmpty(paramBundle.getString("floating_window_rowkey"))) {
          bool2 = true;
        }
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("checkParamsLegal outside");
    paramBundle.append(bool1);
    paramBundle.append(" isLegal=");
    paramBundle.append(bool2);
    QLog.d("ReadInjoyFloatingWindowModule", 1, paramBundle.toString());
    return bool2;
  }
  
  private static boolean a(Bundle paramBundle, Intent paramIntent, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool3 = false;
    boolean bool1;
    if (i >= 21) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (paramBundle != null)
    {
      bool2 = bool3;
      if (bool1)
      {
        String str = paramBundle.getString("floating_window_rowkey");
        paramBundle = paramBundle.getString("float_layer_article_url");
        bool2 = bool3;
        if (!TextUtils.isEmpty(str))
        {
          BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
          localBaseArticleInfo.innerUniqueID = str;
          localBaseArticleInfo.mChannelID = paramInt;
          if (!TextUtils.isEmpty(paramBundle)) {
            localBaseArticleInfo.mArticleContentUrl = paramBundle;
          }
          paramIntent.putExtra("fast_web_article_info", localBaseArticleInfo);
          bool2 = true;
        }
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append(" ocheckOpenNativeVertify isVersionLegal=");
    paramBundle.append(bool1);
    paramBundle.append(" isLegal=");
    paramBundle.append(bool2);
    QLog.d("ReadInjoyFloatingWindowModule", 1, paramBundle.toString());
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInjoyFloatingWindowHelper
 * JD-Core Version:    0.7.0.1
 */