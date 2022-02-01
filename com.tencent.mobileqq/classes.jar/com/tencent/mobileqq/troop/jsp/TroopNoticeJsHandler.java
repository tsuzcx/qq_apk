package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
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
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNoticeJsHandler
  extends WebViewPlugin
{
  public static String b = "pic_up";
  public static String c = "pic";
  private static int e = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunShowPictureIntentLimit", 200);
  protected String a;
  private BroadcastReceiver d;
  
  public TroopNoticeJsHandler()
  {
    this.mPluginNameSpace = "troopNotice";
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    // Byte code:
    //   0: aload_2
    //   1: sipush 640
    //   4: invokestatic 62	com/tencent/biz/common/util/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +15 -> 26
    //   14: aload 9
    //   16: ifnull +8 -> 24
    //   19: aload 9
    //   21: invokevirtual 67	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 9
    //   28: astore_2
    //   29: new 69	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 9
    //   40: astore_2
    //   41: aload 10
    //   43: getstatic 75	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   46: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 9
    //   52: astore_2
    //   53: aload 10
    //   55: ldc 81
    //   57: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 9
    //   63: astore_2
    //   64: aload 10
    //   66: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 91	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: aload 9
    //   76: astore_2
    //   77: aload 9
    //   79: new 93	java/io/File
    //   82: dup
    //   83: aload 10
    //   85: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokestatic 101	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   91: aload 9
    //   93: ifnull +8 -> 101
    //   96: aload 9
    //   98: invokevirtual 67	android/graphics/Bitmap:recycle	()V
    //   101: new 103	java/util/HashMap
    //   104: dup
    //   105: invokespecial 104	java/util/HashMap:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: ldc 106
    //   112: aload 5
    //   114: invokestatic 109	com/tencent/mobileqq/troop/jsp/TroopNoticeJsHandler:f	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokeinterface 115 3 0
    //   122: pop
    //   123: aload_3
    //   124: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +61 -> 188
    //   130: new 123	org/json/JSONObject
    //   133: dup
    //   134: aload_3
    //   135: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 128	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   143: astore 9
    //   145: aload 9
    //   147: invokeinterface 134 1 0
    //   152: ifeq +36 -> 188
    //   155: aload 9
    //   157: invokeinterface 138 1 0
    //   162: checkcast 140	java/lang/String
    //   165: astore 11
    //   167: aload_2
    //   168: aload 11
    //   170: aload_3
    //   171: aload 11
    //   173: invokevirtual 144	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   176: invokevirtual 147	java/lang/Object:toString	()Ljava/lang/String;
    //   179: invokeinterface 115 3 0
    //   184: pop
    //   185: goto -40 -> 145
    //   188: new 103	java/util/HashMap
    //   191: dup
    //   192: invokespecial 104	java/util/HashMap:<init>	()V
    //   195: astore_3
    //   196: aload_3
    //   197: aload 6
    //   199: aload 10
    //   201: invokeinterface 115 3 0
    //   206: pop
    //   207: aload_0
    //   208: invokevirtual 150	java/lang/String:length	()I
    //   211: istore 8
    //   213: new 152	java/lang/StringBuffer
    //   216: dup
    //   217: ldc 154
    //   219: invokespecial 155	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   222: astore 6
    //   224: iconst_0
    //   225: istore 7
    //   227: iload 7
    //   229: bipush 10
    //   231: iload 8
    //   233: isub
    //   234: if_icmpge +20 -> 254
    //   237: aload 6
    //   239: ldc 157
    //   241: invokevirtual 160	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   244: pop
    //   245: iload 7
    //   247: iconst_1
    //   248: iadd
    //   249: istore 7
    //   251: goto -24 -> 227
    //   254: aload 6
    //   256: aload_0
    //   257: invokevirtual 160	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   260: pop
    //   261: new 103	java/util/HashMap
    //   264: dup
    //   265: invokespecial 104	java/util/HashMap:<init>	()V
    //   268: astore_0
    //   269: new 162	java/net/URL
    //   272: dup
    //   273: aload_1
    //   274: invokespecial 163	java/net/URL:<init>	(Ljava/lang/String;)V
    //   277: astore 9
    //   279: aload_0
    //   280: ldc 165
    //   282: aload 9
    //   284: invokevirtual 168	java/net/URL:getRef	()Ljava/lang/String;
    //   287: invokeinterface 115 3 0
    //   292: pop
    //   293: aload 9
    //   295: invokevirtual 171	java/net/URL:getHost	()Ljava/lang/String;
    //   298: ldc 173
    //   300: invokevirtual 177	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   303: ifeq +148 -> 451
    //   306: aload 9
    //   308: invokevirtual 180	java/net/URL:getPath	()Ljava/lang/String;
    //   311: ldc 182
    //   313: invokevirtual 177	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   316: ifeq +135 -> 451
    //   319: invokestatic 188	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   322: invokevirtual 192	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   325: iconst_2
    //   326: invokevirtual 198	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   329: checkcast 200	mqq/manager/TicketManager
    //   332: invokestatic 188	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   335: invokevirtual 192	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   338: invokevirtual 203	mqq/app/AppRuntime:getCurrentAccountUin	()Ljava/lang/String;
    //   341: ldc 205
    //   343: invokeinterface 209 3 0
    //   348: astore 9
    //   350: aload 9
    //   352: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   355: ifne +96 -> 451
    //   358: new 69	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   365: astore 10
    //   367: aload 10
    //   369: ldc 211
    //   371: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 10
    //   377: aload 6
    //   379: invokevirtual 212	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   382: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 10
    //   388: ldc 214
    //   390: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 10
    //   396: aload 9
    //   398: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 10
    //   404: ldc 216
    //   406: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 10
    //   412: aload 6
    //   414: invokevirtual 212	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   417: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 10
    //   423: ldc 218
    //   425: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 10
    //   431: aload 5
    //   433: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_0
    //   438: ldc 220
    //   440: aload 10
    //   442: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokeinterface 115 3 0
    //   450: pop
    //   451: aload 4
    //   453: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   456: ifne +65 -> 521
    //   459: new 123	org/json/JSONObject
    //   462: dup
    //   463: aload 4
    //   465: invokespecial 124	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   468: astore 4
    //   470: aload 4
    //   472: invokevirtual 128	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   475: astore 9
    //   477: aload 9
    //   479: invokeinterface 134 1 0
    //   484: ifeq +37 -> 521
    //   487: aload 9
    //   489: invokeinterface 138 1 0
    //   494: checkcast 140	java/lang/String
    //   497: astore 10
    //   499: aload_0
    //   500: aload 10
    //   502: aload 4
    //   504: aload 10
    //   506: invokevirtual 144	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   509: invokevirtual 147	java/lang/Object:toString	()Ljava/lang/String;
    //   512: invokeinterface 115 3 0
    //   517: pop
    //   518: goto -41 -> 477
    //   521: aload_1
    //   522: aload 6
    //   524: invokevirtual 212	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   527: aload 5
    //   529: aload_2
    //   530: aload_3
    //   531: aload_0
    //   532: invokestatic 226	com/tencent/biz/common/util/HttpUtil:uploadImage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   535: areturn
    //   536: astore_0
    //   537: aload_0
    //   538: invokevirtual 229	java/net/MalformedURLException:printStackTrace	()V
    //   541: aconst_null
    //   542: areturn
    //   543: astore_0
    //   544: goto +17 -> 561
    //   547: astore_0
    //   548: goto +36 -> 584
    //   551: astore_0
    //   552: aconst_null
    //   553: astore_2
    //   554: goto +50 -> 604
    //   557: astore_0
    //   558: aconst_null
    //   559: astore 9
    //   561: aload 9
    //   563: astore_2
    //   564: aload_0
    //   565: invokevirtual 230	java/io/IOException:printStackTrace	()V
    //   568: aload 9
    //   570: ifnull +8 -> 578
    //   573: aload 9
    //   575: invokevirtual 67	android/graphics/Bitmap:recycle	()V
    //   578: aconst_null
    //   579: areturn
    //   580: astore_0
    //   581: aconst_null
    //   582: astore 9
    //   584: aload 9
    //   586: astore_2
    //   587: aload_0
    //   588: invokevirtual 231	java/lang/OutOfMemoryError:printStackTrace	()V
    //   591: aload 9
    //   593: ifnull +8 -> 601
    //   596: aload 9
    //   598: invokevirtual 67	android/graphics/Bitmap:recycle	()V
    //   601: aconst_null
    //   602: areturn
    //   603: astore_0
    //   604: aload_2
    //   605: ifnull +7 -> 612
    //   608: aload_2
    //   609: invokevirtual 67	android/graphics/Bitmap:recycle	()V
    //   612: goto +5 -> 617
    //   615: aload_0
    //   616: athrow
    //   617: goto -2 -> 615
    //   620: astore_3
    //   621: goto -433 -> 188
    //   624: astore 4
    //   626: goto -105 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	paramString1	String
    //   0	629	1	paramString2	String
    //   0	629	2	paramString3	String
    //   0	629	3	paramString4	String
    //   0	629	4	paramString5	String
    //   0	629	5	paramString6	String
    //   0	629	6	paramString7	String
    //   225	25	7	i	int
    //   211	23	8	j	int
    //   7	590	9	localObject1	Object
    //   36	469	10	localObject2	Object
    //   165	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   269	451	536	java/net/MalformedURLException
    //   29	38	543	java/io/IOException
    //   41	50	543	java/io/IOException
    //   53	61	543	java/io/IOException
    //   64	74	543	java/io/IOException
    //   77	91	543	java/io/IOException
    //   29	38	547	java/lang/OutOfMemoryError
    //   41	50	547	java/lang/OutOfMemoryError
    //   53	61	547	java/lang/OutOfMemoryError
    //   64	74	547	java/lang/OutOfMemoryError
    //   77	91	547	java/lang/OutOfMemoryError
    //   0	9	551	finally
    //   0	9	557	java/io/IOException
    //   0	9	580	java/lang/OutOfMemoryError
    //   29	38	603	finally
    //   41	50	603	finally
    //   53	61	603	finally
    //   64	74	603	finally
    //   77	91	603	finally
    //   564	568	603	finally
    //   587	591	603	finally
    //   130	145	620	org/json/JSONException
    //   145	185	620	org/json/JSONException
    //   459	477	624	org/json/JSONException
    //   477	518	624	org/json/JSONException
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<MediaPreviewInfo> paramArrayList, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, MediaPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt1);
    localBundle.putParcelableArrayList("mediaInfoList", paramArrayList);
    localBundle.putBoolean("is_not_show_index", paramBoolean);
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString, int paramInt2)
  {
    a(paramActivity, paramInt1, paramArrayList, null, null, false, paramBoolean, paramString, paramInt2, null, null, "");
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString2)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString1, paramInt2, paramPublicAccountShowPictureReport, paramAbsBaseArticleInfo, null, null, paramString2, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4, String paramString2, boolean paramBoolean3)
  {
    a(paramActivity, paramInt1, paramArrayList1, paramArrayOfBoolean, paramArrayList2, paramBoolean1, paramBoolean2, paramString1, paramInt2, paramPublicAccountShowPictureReport, paramAbsBaseArticleInfo, null, null, paramString2, true, "", null);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4, String paramString2, boolean paramBoolean3, String paramString3, HashMap<String, Object> paramHashMap)
  {
    ThreadManager.post(new TroopNoticeJsHandler.2(paramActivity, paramInt1, paramArrayList1, paramArrayList2, paramArrayOfBoolean, paramPublicAccountShowPictureReport, paramArrayList3, paramArrayList4, paramString3, paramHashMap, paramBoolean1, paramBoolean2, paramBoolean3, paramAbsBaseArticleInfo, paramString1, paramString2, paramInt2), 8, null, true);
  }
  
  public static void a(Activity paramActivity, int paramInt1, ArrayList<String> paramArrayList1, boolean[] paramArrayOfBoolean, ArrayList<String> paramArrayList2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt2, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, String paramString2, String paramString3, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString4)
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
    if (paramAbsBaseArticleInfo != null)
    {
      localBundle.putInt("channel_id", (int)paramAbsBaseArticleInfo.mChannelID);
      localBundle.putLong("articleSeq", paramAbsBaseArticleInfo.mRecommendSeq);
      localBundle.putBoolean("is_grid_image_report", true);
      ((IRIJFrameworkReportManager)QRoute.api(IRIJFrameworkReportManager.class)).makeGridImageReadArticleReport(paramAbsBaseArticleInfo, "", paramInt1, localBundle);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBundle.putString("src_id", paramString1);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localBundle.putString("str_data_extra", paramString4);
    }
    if ((paramAbsBaseArticleInfo != null) && (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).isWendaCardViewType(paramAbsBaseArticleInfo)) && (!TextUtils.isEmpty(paramString2))) {
      localBundle.putString("btntext", paramActivity.getString(2131915420));
    }
    localIntent.putExtras(localBundle);
    paramActivity.startActivityForResult(localIntent, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (paramActivity != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      a(paramActivity, 0, localArrayList, true, "", 1000);
    }
  }
  
  public static String f(String paramString)
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
  
  protected void a(String paramString)
  {
    Object localObject8;
    label1116:
    label1119:
    label1125:
    do
    {
      boolean bool1;
      do
      {
        for (;;)
        {
          try
          {
            Object localObject6 = new JSONObject(paramString);
            localObject8 = ((JSONObject)localObject6).optString("bigurl");
            bool1 = TextUtils.isEmpty((CharSequence)localObject8);
            int j = 0;
            int i;
            Object localObject2;
            if (!bool1)
            {
              paramString = ((JSONObject)localObject6).optString("videoID");
              localObject1 = ((JSONObject)localObject6).optString("videoURL");
              ((JSONObject)localObject6).optString("originalVideoURL");
              i = ((JSONObject)localObject6).optInt("videoWidth");
              k = ((JSONObject)localObject6).optInt("videoHeight");
              ((JSONObject)localObject6).optBoolean("isLike");
              localObject2 = this.mRuntime.d();
              if (localObject2 == null) {
                return;
              }
              localObject3 = QZoneHelper.UserInfo.getInstance();
              localObject4 = new Bundle();
              localObject5 = new ArrayList();
              localObject7 = new PhotoInfo();
              ((PhotoInfo)localObject7).bigUrl = ((String)localObject8);
              ((PhotoInfo)localObject7).videoflag = 1;
              ((PhotoInfo)localObject7).videodata = new VideoInfo();
              ((PhotoInfo)localObject7).videodata.videoId = paramString;
              localObject9 = new PictureUrl();
              ((PictureUrl)localObject9).url = ((String)localObject8);
              ((PhotoInfo)localObject7).videodata.coverUrl = ((PictureUrl)localObject9);
              localObject8 = new VideoUrl();
              ((VideoUrl)localObject8).url = ((String)localObject1);
              ((PhotoInfo)localObject7).videodata.videoId = paramString;
              ((PhotoInfo)localObject7).videodata.actionUrl = ((String)localObject1);
              ((PhotoInfo)localObject7).videodata.videoUrl = ((VideoUrl)localObject8);
              ((PhotoInfo)localObject7).videodata.width = i;
              ((PhotoInfo)localObject7).videodata.height = k;
              ((PhotoInfo)localObject7).videodata.videoStatus = 5;
              ((ArrayList)localObject5).add(localObject7);
              ((Bundle)localObject4).putSerializable("picturelist", (Serializable)localObject5);
              ((Bundle)localObject4).putInt("curindex", 0);
              ((Bundle)localObject4).putInt("mode", 3);
              ((Bundle)localObject4).putBoolean("need_clear_cache", true);
              QZoneHelper.forwardToPictureViewer((Activity)localObject2, (QZoneHelper.UserInfo)localObject3, (Bundle)localObject4, 6);
            }
            this.a = ((JSONObject)localObject6).optString("callback");
            Object localObject5 = ((JSONObject)localObject6).optJSONArray("imageIDs");
            localObject8 = ((JSONObject)localObject6).optJSONArray("likes");
            Object localObject7 = ((JSONObject)localObject6).optJSONArray("descs");
            localObject4 = ((JSONObject)localObject6).optJSONArray("sourceIDs");
            Object localObject10 = ((JSONObject)localObject6).optJSONArray("sourceSize");
            bool1 = ((JSONObject)localObject6).optBoolean("needBottomBar");
            paramString = ((JSONObject)localObject6).optJSONObject("extra");
            if (paramString == null) {
              paramString = "";
            } else {
              paramString = paramString.toString();
            }
            int k = ((JSONObject)localObject6).optInt("index");
            Object localObject9 = ((JSONObject)localObject6).optString("srcID");
            if (Boolean.valueOf(((JSONObject)localObject6).optBoolean("isReport")).booleanValue())
            {
              localObject1 = new PublicAccountShowPictureReport();
              ((PublicAccountShowPictureReport)localObject1).parse((JSONObject)localObject6);
              boolean bool2 = ((JSONObject)localObject6).optBoolean("isNotShowIndex", true);
              if (localObject5 != null)
              {
                if (((JSONArray)localObject5).length() == 0) {
                  return;
                }
                if (this.mRuntime.a() == null) {
                  return;
                }
                if (this.mRuntime.b() == null) {
                  return;
                }
                localObject3 = this.mRuntime.d();
                if (localObject3 == null) {
                  return;
                }
                localObject2 = localObject3;
                if ((localObject3 instanceof BasePluginActivity)) {
                  localObject2 = ((BasePluginActivity)localObject3).getOutActivity();
                }
                ArrayList localArrayList = new ArrayList();
                int m = ((JSONArray)localObject5).length();
                i = 0;
                if (i < m)
                {
                  localArrayList.add(((JSONArray)localObject5).get(i).toString());
                  i += 1;
                  continue;
                }
                if (localObject4 == null) {
                  break label1119;
                }
                localObject3 = new ArrayList();
                m = ((JSONArray)localObject4).length();
                i = 0;
                if (i >= m) {
                  break label1116;
                }
                ((ArrayList)localObject3).add(((JSONArray)localObject4).get(i).toString());
                i += 1;
                continue;
                if (localObject10 == null) {
                  break label1125;
                }
                localObject5 = new ArrayList();
                m = ((JSONArray)localObject10).length();
                i = 0;
                localObject4 = localObject5;
                if (i < m)
                {
                  ((ArrayList)localObject5).add(((JSONArray)localObject10).get(i).toString());
                  i += 1;
                  continue;
                }
                boolean bool3 = ((JSONObject)localObject6).optBoolean("showTitle", false);
                localObject5 = Base64Util.encodeToString(((JSONObject)localObject6).optString("title", "").getBytes(), 0);
                localObject6 = ((JSONObject)localObject6).optString("articleUrl", "");
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d(this.mTAG, 2, new Object[] { "KANDIAN Grid Image title: ", localObject5, ", articleUrl: ", localObject6, ", showTitle: ", Boolean.valueOf(bool3) });
                break;
                localObject10 = new boolean[((JSONArray)localObject8).length()];
                i = 0;
                if (i < ((JSONArray)localObject8).length())
                {
                  localObject10[i] = ((JSONArray)localObject8).getBoolean(i);
                  i += 1;
                  continue;
                }
                localObject8 = new ArrayList();
                if ((localObject7 != null) && (((JSONArray)localObject7).length() != 0))
                {
                  m = ((JSONArray)localObject7).length();
                  i = j;
                  if (i < m)
                  {
                    ((ArrayList)localObject8).add(((JSONArray)localObject7).get(i).toString());
                    i += 1;
                    continue;
                  }
                }
                if (this.d == null)
                {
                  this.d = new TroopNoticeJsHandler.1(this);
                  localObject7 = new IntentFilter("android.intent.action.WEBJSCALL");
                  ((Activity)localObject2).registerReceiver(this.d, (IntentFilter)localObject7);
                }
                if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
                {
                  a((Activity)localObject2, k, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
                  return;
                }
                a((Activity)localObject2, k, localArrayList, (boolean[])localObject10, (ArrayList)localObject8, bool1, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, (ArrayList)localObject3, (ArrayList)localObject4, paramString, true);
                return;
                if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
                {
                  a((Activity)localObject2, k, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject6, (String)localObject5, null, paramString);
                  return;
                }
                a((Activity)localObject2, k, localArrayList, null, null, false, bool2, (String)localObject9, 100, (PublicAccountShowPictureReport)localObject1, null, paramString);
              }
              return;
            }
          }
          catch (JSONException paramString)
          {
            return;
          }
          Object localObject1 = null;
          continue;
          continue;
          Object localObject3 = null;
          continue;
          Object localObject4 = null;
        }
      } while (!bool1);
    } while (localObject8 != null);
  }
  
  protected void b(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.3(this, paramString), 5, null, true);
  }
  
  protected void c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = this.mRuntime.a();
      if (paramString == null) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.b();
      if (localAppInterface == null) {
        return;
      }
      Activity localActivity = this.mRuntime.d();
      if (localActivity == null) {
        return;
      }
      String str1 = ((JSONObject)localObject).optString("callback");
      String str2 = ((JSONObject)localObject).optString("cgiURL");
      String str3 = ((JSONObject)localObject).optString("imageID");
      String str4 = ((JSONObject)localObject).optString("headFields");
      localObject = ((JSONObject)localObject).optString("postParams");
      String str5 = LoginHelper.a(localAppInterface);
      localActivity.runOnUiThread(new TroopNoticeJsHandler.4(this, paramString, str1, a(localAppInterface.getCurrentAccountUin(), str2, str3, (String)localObject, str4, str5, b)));
      return;
    }
    catch (InterruptedException|JSONException|OutOfMemoryError|Exception paramString) {}
  }
  
  protected void d(String paramString)
  {
    ThreadManager.post(new TroopNoticeJsHandler.5(this, paramString), 5, null, false);
  }
  
  public void e(String paramString)
  {
    if ((this.mRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (TextUtils.isEmpty(this.a)) {
        return;
      }
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript: ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      localCustomWebView.loadUrl(localStringBuilder.toString());
    }
  }
  
  protected void g(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TroopNoticeJsHandler showMedia(): jsonData = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("zivonchen", 4, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.optJSONArray("imageIDs");
      int j = paramString.optInt("index");
      boolean bool = paramString.optBoolean("isNotShowIndex", true);
      if (localJSONArray != null)
      {
        if (localJSONArray.length() == 0) {
          return;
        }
        if (this.mRuntime.a() == null) {
          return;
        }
        if (this.mRuntime.b() == null) {
          return;
        }
        localObject = this.mRuntime.d();
        if (localObject == null) {
          return;
        }
        paramString = (String)localObject;
        if ((localObject instanceof BasePluginActivity)) {
          paramString = ((BasePluginActivity)localObject).getOutActivity();
        }
        localObject = new ArrayList();
        int i = 0;
        int k = localJSONArray.length();
        while (i < k)
        {
          ((ArrayList)localObject).add(new MediaPreviewInfo(localJSONArray.optJSONObject(i)));
          i += 1;
        }
        a(paramString, j, (ArrayList)localObject, bool, 101);
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 4, QLog.getStackTraceString(paramString));
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopNotice".equals(paramString2))
    {
      if (("showPicture".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        a(paramVarArgs[0]);
        return false;
      }
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
      if (("showMedia".equals(paramString3)) && (paramVarArgs.length == 1)) {
        g(paramVarArgs[0]);
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (paramByte == 100)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {
        return;
      }
      if ((paramIntent != null) && (paramIntent.hasExtra("DeletedList")))
      {
        paramIntent = paramIntent.getStringArrayListExtra("DeletedList");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("javascript: ");
          paramIntent.append(this.a);
          paramIntent.append("([])");
          localCustomWebView.loadUrl(paramIntent.toString());
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.d != null) && (this.mRuntime != null))
    {
      Activity localActivity2 = this.mRuntime.d();
      if (localActivity2 == null) {
        return;
      }
      Activity localActivity1 = localActivity2;
      if ((localActivity2 instanceof BasePluginActivity)) {
        localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
      }
      localActivity1.unregisterReceiver(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler
 * JD-Core Version:    0.7.0.1
 */