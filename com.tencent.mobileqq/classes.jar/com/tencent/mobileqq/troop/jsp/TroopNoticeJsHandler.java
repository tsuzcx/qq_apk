package com.tencent.mobileqq.troop.jsp;

import ajlu;
import ajlv;
import ajlw;
import ajlx;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewActivity;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.LoginHelper;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNoticeJsHandler
  extends WebViewPlugin
{
  public static String b = "pic_up";
  public static String c = "pic";
  private BroadcastReceiver a;
  protected String a;
  
  public TroopNoticeJsHandler()
  {
    this.mPluginNameSpace = "troopNotice";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = 5381;
    int i = 0;
    int k = paramString.length();
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return Integer.toString(0x7FFFFFFF & j);
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: aload_2
    //   1: sipush 640
    //   4: invokestatic 68	com/tencent/biz/common/util/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +15 -> 26
    //   14: aload 9
    //   16: ifnull +8 -> 24
    //   19: aload 9
    //   21: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 9
    //   28: astore_2
    //   29: new 75	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   36: getstatic 81	com/tencent/mobileqq/app/AppConstants:ba	Ljava/lang/String;
    //   39: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 87
    //   44: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 10
    //   52: aload 9
    //   54: astore_2
    //   55: aload 9
    //   57: new 92	java/io/File
    //   60: dup
    //   61: aload 10
    //   63: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: invokestatic 100	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   69: aload 9
    //   71: ifnull +8 -> 79
    //   74: aload 9
    //   76: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   79: new 102	java/util/HashMap
    //   82: dup
    //   83: invokespecial 103	java/util/HashMap:<init>	()V
    //   86: astore_2
    //   87: aload_2
    //   88: ldc 105
    //   90: aload 5
    //   92: invokestatic 107	com/tencent/mobileqq/troop/jsp/TroopNoticeJsHandler:a	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokeinterface 113 3 0
    //   100: pop
    //   101: aload_3
    //   102: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +62 -> 167
    //   108: new 115	org/json/JSONObject
    //   111: dup
    //   112: aload_3
    //   113: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   116: astore_3
    //   117: aload_3
    //   118: invokevirtual 120	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   121: astore 9
    //   123: aload 9
    //   125: invokeinterface 126 1 0
    //   130: ifeq +37 -> 167
    //   133: aload 9
    //   135: invokeinterface 130 1 0
    //   140: checkcast 39	java/lang/String
    //   143: astore 11
    //   145: aload_2
    //   146: aload 11
    //   148: aload_3
    //   149: aload 11
    //   151: invokevirtual 134	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: invokevirtual 137	java/lang/Object:toString	()Ljava/lang/String;
    //   157: invokeinterface 113 3 0
    //   162: pop
    //   163: goto -40 -> 123
    //   166: astore_3
    //   167: new 102	java/util/HashMap
    //   170: dup
    //   171: invokespecial 103	java/util/HashMap:<init>	()V
    //   174: astore_3
    //   175: aload_3
    //   176: aload 6
    //   178: aload 10
    //   180: invokeinterface 113 3 0
    //   185: pop
    //   186: aload_0
    //   187: invokevirtual 43	java/lang/String:length	()I
    //   190: istore 8
    //   192: new 139	java/lang/StringBuffer
    //   195: dup
    //   196: ldc 141
    //   198: invokespecial 142	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   201: astore 6
    //   203: iconst_0
    //   204: istore 7
    //   206: iload 7
    //   208: bipush 10
    //   210: iload 8
    //   212: isub
    //   213: if_icmpge +79 -> 292
    //   216: aload 6
    //   218: ldc 144
    //   220: invokevirtual 147	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   223: pop
    //   224: iload 7
    //   226: iconst_1
    //   227: iadd
    //   228: istore 7
    //   230: goto -24 -> 206
    //   233: astore_0
    //   234: aconst_null
    //   235: astore 9
    //   237: aload 9
    //   239: astore_2
    //   240: aload_0
    //   241: invokevirtual 150	java/lang/OutOfMemoryError:printStackTrace	()V
    //   244: aload 9
    //   246: ifnull +8 -> 254
    //   249: aload 9
    //   251: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 9
    //   260: aload 9
    //   262: astore_2
    //   263: aload_0
    //   264: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   267: aload 9
    //   269: ifnull +8 -> 277
    //   272: aload 9
    //   274: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_2
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 73	android/graphics/Bitmap:recycle	()V
    //   290: aload_0
    //   291: athrow
    //   292: aload 6
    //   294: aload_0
    //   295: invokevirtual 147	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   298: pop
    //   299: new 102	java/util/HashMap
    //   302: dup
    //   303: invokespecial 103	java/util/HashMap:<init>	()V
    //   306: astore_0
    //   307: aload_0
    //   308: ldc 153
    //   310: new 155	java/net/URL
    //   313: dup
    //   314: aload_1
    //   315: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;)V
    //   318: invokevirtual 159	java/net/URL:getRef	()Ljava/lang/String;
    //   321: invokeinterface 113 3 0
    //   326: pop
    //   327: aload 4
    //   329: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   332: ifne +67 -> 399
    //   335: new 115	org/json/JSONObject
    //   338: dup
    //   339: aload 4
    //   341: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   344: astore 4
    //   346: aload 4
    //   348: invokevirtual 120	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   351: astore 9
    //   353: aload 9
    //   355: invokeinterface 126 1 0
    //   360: ifeq +39 -> 399
    //   363: aload 9
    //   365: invokeinterface 130 1 0
    //   370: checkcast 39	java/lang/String
    //   373: astore 10
    //   375: aload_0
    //   376: aload 10
    //   378: aload 4
    //   380: aload 10
    //   382: invokevirtual 134	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   385: invokevirtual 137	java/lang/Object:toString	()Ljava/lang/String;
    //   388: invokeinterface 113 3 0
    //   393: pop
    //   394: goto -41 -> 353
    //   397: astore 4
    //   399: aload_1
    //   400: aload 6
    //   402: invokevirtual 160	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   405: aload 5
    //   407: aload_2
    //   408: aload_3
    //   409: aload_0
    //   410: invokestatic 165	com/tencent/biz/common/util/HttpUtil:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   413: areturn
    //   414: astore_0
    //   415: aload_0
    //   416: invokevirtual 166	java/net/MalformedURLException:printStackTrace	()V
    //   419: aconst_null
    //   420: areturn
    //   421: astore_0
    //   422: goto -140 -> 282
    //   425: astore_0
    //   426: goto -166 -> 260
    //   429: astore_0
    //   430: goto -193 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramString1	String
    //   0	433	1	paramString2	String
    //   0	433	2	paramString3	String
    //   0	433	3	paramString4	String
    //   0	433	4	paramString5	String
    //   0	433	5	paramString6	String
    //   0	433	6	paramString7	String
    //   204	25	7	i	int
    //   190	23	8	j	int
    //   7	357	9	localObject	Object
    //   50	331	10	str1	String
    //   143	7	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   108	123	166	org/json/JSONException
    //   123	163	166	org/json/JSONException
    //   0	9	233	java/lang/OutOfMemoryError
    //   0	9	256	java/io/IOException
    //   0	9	279	finally
    //   335	353	397	org/json/JSONException
    //   353	394	397	org/json/JSONException
    //   307	327	414	java/net/MalformedURLException
    //   29	52	421	finally
    //   55	69	421	finally
    //   240	244	421	finally
    //   263	267	421	finally
    //   29	52	425	java/io/IOException
    //   55	69	425	java/io/IOException
    //   29	52	429	java/lang/OutOfMemoryError
    //   55	69	429	java/lang/OutOfMemoryError
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MediaPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putParcelableArrayList("mediaInfoList", paramArrayList);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList, boolean paramBoolean, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList, null, null, false, paramBoolean, paramString, paramInt2, null, null);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString, paramInt2, paramPublicAccountShowPictureReport, paramArticleInfo, null, null);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArticleInfo paramArticleInfo, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putStringArrayList("seqNum", paramArrayList1);
    if (paramArrayList2 != null) {
      localBundle.putStringArrayList("descs", paramArrayList2);
    }
    if (paramArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", paramArrayOfBoolean);
    }
    if ((paramPublicAccountShowPictureReport != null) && (paramPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", paramPublicAccountShowPictureReport.toString());
    }
    if (paramArrayList3 != null) {
      localBundle.putStringArrayList("origin_list", paramArrayList3);
    }
    if (paramArrayList4 != null) {
      localBundle.putStringArrayList("origin_size_list", paramArrayList4);
    }
    localBundle.putBoolean("needBottomBar", paramBoolean1);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean2);
    if (paramArticleInfo != null)
    {
      localBundle.putBoolean("is_grid_image_report", true);
      ReadInJoyBaseAdapter.a(paramArticleInfo, "", paramInt1, localBundle);
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("src_id", paramString);
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, String paramString2, String paramString3, ArticleInfo paramArticleInfo)
  {
    Intent localIntent = new Intent(paramActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putStringArrayList("seqNum", paramArrayList1);
    if (paramArrayList2 != null) {
      localBundle.putStringArrayList("descs", paramArrayList2);
    }
    if (paramArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", paramArrayOfBoolean);
    }
    if ((paramPublicAccountShowPictureReport != null) && (paramPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", paramPublicAccountShowPictureReport.toString());
    }
    localBundle.putBoolean("needBottomBar", paramBoolean1);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", paramBoolean2);
    localBundle.putBoolean("is_show_content_url", true);
    localBundle.putString("article_url", paramString2);
    localBundle.putString("article_title", paramString3);
    if (paramArticleInfo != null)
    {
      localBundle.putInt("channel_id", (int)paramArticleInfo.mChannelID);
      localBundle.putLong("articleSeq", paramArticleInfo.mRecommendSeq);
      localBundle.putBoolean("is_grid_image_report", true);
      ReadInJoyBaseAdapter.a(paramArticleInfo, "", paramInt1, localBundle);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("src_id", paramString1);
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    a(paramActivity, 0, localArrayList, true, "", 1000);
  }
  
  protected void a(String paramString)
  {
    try
    {
      Object localObject7 = new JSONObject(paramString);
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject7).optString("callback");
      Object localObject4 = ((JSONObject)localObject7).optJSONArray("imageIDs");
      Object localObject6 = ((JSONObject)localObject7).optJSONArray("likes");
      Object localObject5 = ((JSONObject)localObject7).optJSONArray("descs");
      Object localObject3 = ((JSONObject)localObject7).optJSONArray("sourceIDs");
      Object localObject8 = ((JSONObject)localObject7).optJSONArray("sourceSize");
      boolean bool1 = ((JSONObject)localObject7).optBoolean("needBottomBar");
      int j = ((JSONObject)localObject7).optInt("index");
      String str = ((JSONObject)localObject7).optString("srcID");
      boolean bool2 = ((JSONObject)localObject7).optBoolean("isReport");
      paramString = null;
      if (Boolean.valueOf(bool2).booleanValue())
      {
        paramString = new PublicAccountShowPictureReport();
        paramString.parse((JSONObject)localObject7);
      }
      bool2 = ((JSONObject)localObject7).optBoolean("isNotShowIndex", true);
      Object localObject2;
      Object localObject1;
      ArrayList localArrayList;
      int i;
      int k;
      if (localObject4 != null)
      {
        if (((JSONArray)localObject4).length() == 0) {
          return;
        }
        if ((this.mRuntime.a() != null) && (this.mRuntime.a() != null))
        {
          localObject2 = this.mRuntime.a();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if ((localObject2 instanceof BasePluginActivity)) {
              localObject1 = ((BasePluginActivity)localObject2).getOutActivity();
            }
            localArrayList = new ArrayList();
            i = 0;
            k = ((JSONArray)localObject4).length();
            while (i < k)
            {
              localArrayList.add(((JSONArray)localObject4).get(i).toString());
              i += 1;
            }
            if (localObject3 != null)
            {
              localObject2 = new ArrayList();
              i = 0;
              k = ((JSONArray)localObject3).length();
              while (i < k)
              {
                ((ArrayList)localObject2).add(((JSONArray)localObject3).get(i).toString());
                i += 1;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject3 = null;
        if (localObject8 != null)
        {
          localObject4 = new ArrayList();
          i = 0;
          k = ((JSONArray)localObject8).length();
          for (;;)
          {
            localObject3 = localObject4;
            if (i >= k) {
              break;
            }
            ((ArrayList)localObject4).add(((JSONArray)localObject8).get(i).toString());
            i += 1;
          }
        }
        boolean bool3 = ((JSONObject)localObject7).optBoolean("showTitle", false);
        localObject4 = Base64Util.encodeToString(((JSONObject)localObject7).optString("title", "").getBytes(), 0);
        localObject7 = ((JSONObject)localObject7).optString("articleUrl", "");
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, new Object[] { "KANDIAN Grid Image title: ", localObject4, ", articleUrl: ", localObject7, ", showTitle: ", Boolean.valueOf(bool3) });
        }
        if (bool1)
        {
          if (localObject6 != null)
          {
            localObject8 = new boolean[((JSONArray)localObject6).length()];
            i = 0;
            while (i < ((JSONArray)localObject6).length())
            {
              localObject8[i] = ((JSONArray)localObject6).getBoolean(i);
              i += 1;
            }
            localObject6 = new ArrayList();
            if ((localObject5 != null) && (((JSONArray)localObject5).length() != 0))
            {
              i = 0;
              k = ((JSONArray)localObject5).length();
              while (i < k)
              {
                ((ArrayList)localObject6).add(((JSONArray)localObject5).get(i).toString());
                i += 1;
              }
            }
            if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
            {
              this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ajlu(this);
              localObject5 = new IntentFilter("android.intent.action.WEBJSCALL");
              ((Activity)localObject1).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject5);
            }
            if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject7)))
            {
              a((Activity)localObject1, j, localArrayList, (boolean[])localObject8, (ArrayList)localObject6, bool1, bool2, str, 100, paramString, (String)localObject7, (String)localObject4, null);
              return;
            }
            a((Activity)localObject1, j, localArrayList, (boolean[])localObject8, (ArrayList)localObject6, bool1, bool2, str, 100, paramString, null, (ArrayList)localObject2, (ArrayList)localObject3);
          }
        }
        else
        {
          if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject7)))
          {
            a((Activity)localObject1, j, localArrayList, null, null, false, bool2, str, 100, paramString, (String)localObject7, (String)localObject4, null);
            return;
          }
          a((Activity)localObject1, j, localArrayList, null, null, false, bool2, str, 100, paramString, null);
          return;
          localObject2 = null;
          continue;
        }
        return;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  protected void b(String paramString)
  {
    ThreadManager.post(new ajlv(this, paramString), 5, null, true);
  }
  
  public void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        Activity localActivity = this.mRuntime.a();
        if (localActivity != null)
        {
          String str1 = ((JSONObject)localObject).optString("callback");
          String str2 = ((JSONObject)localObject).optString("cgiURL");
          String str3 = ((JSONObject)localObject).optString("imageID");
          String str4 = ((JSONObject)localObject).optString("headFields");
          localObject = ((JSONObject)localObject).optString("postParams");
          String str5 = LoginHelper.a(localAppInterface);
          localActivity.runOnUiThread(new ajlw(this, paramString, str1, a(localAppInterface.getCurrentAccountUin(), str2, str3, (String)localObject, str4, str5, b)));
          return;
        }
      }
    }
    catch (InterruptedException paramString) {}catch (Exception paramString) {}catch (OutOfMemoryError paramString) {}catch (JSONException paramString) {}
  }
  
  protected void d(String paramString)
  {
    ThreadManager.post(new ajlx(this, paramString), 5, null, false);
  }
  
  public void e(String paramString)
  {
    if ((this.mRuntime == null) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    CustomWebView localCustomWebView;
    do
    {
      return;
      localCustomWebView = this.mRuntime.a();
    } while (localCustomWebView == null);
    localCustomWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + paramString + ")");
  }
  
  protected void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 4, "TroopNoticeJsHandler showMedia(): jsonData = " + paramString);
    }
    try
    {
      paramString = new JSONObject(paramString);
      localJSONArray = paramString.optJSONArray("imageIDs");
      j = paramString.optInt("index");
      bool = paramString.optBoolean("isNotShowIndex", true);
      if (localJSONArray == null) {
        return;
      }
      if (localJSONArray.length() == 0) {
        return;
      }
      if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
        return;
      }
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof BasePluginActivity)) {
        break label210;
      }
      paramString = ((BasePluginActivity)paramString).getOutActivity();
    }
    catch (JSONException paramString)
    {
      JSONArray localJSONArray;
      int j;
      boolean bool;
      ArrayList localArrayList;
      int i;
      int k;
      while (QLog.isColorLevel())
      {
        QLog.d("zivonchen", 4, QLog.getStackTraceString(paramString));
        return;
      }
    }
    localArrayList = new ArrayList();
    i = 0;
    k = localJSONArray.length();
    while (i < k)
    {
      localArrayList.add(new MediaPreviewInfo(localJSONArray.optJSONObject(i)));
      i += 1;
    }
    a(paramString, j, localArrayList, bool, 101);
    return;
    label210:
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if ((!"showPicture".equals(paramString3)) || (paramVarArgs.length != 1)) {
        break label37;
      }
      a(paramVarArgs[0]);
    }
    label37:
    do
    {
      return false;
      if (("sendPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        b(paramVarArgs[0]);
        return false;
      }
      if (("sendBatchPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        d(paramVarArgs[0]);
        return false;
      }
    } while ((!"showMedia".equals(paramString3)) || (paramVarArgs.length != 1));
    f(paramVarArgs[0]);
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    CustomWebView localCustomWebView;
    if (paramByte == 100)
    {
      localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        break label21;
      }
    }
    label21:
    do
    {
      do
      {
        return;
      } while ((paramIntent == null) || (!paramIntent.hasExtra("DeletedList")));
      paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
    } while ((paramIntent == null) || (paramIntent.size() <= 0));
    localCustomWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "([])");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Activity localActivity2;
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null))
    {
      localActivity2 = this.mRuntime.a();
      if (localActivity2 != null) {}
    }
    else
    {
      return;
    }
    Activity localActivity1 = localActivity2;
    if ((localActivity2 instanceof BasePluginActivity)) {
      localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
    }
    localActivity1.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler
 * JD-Core Version:    0.7.0.1
 */