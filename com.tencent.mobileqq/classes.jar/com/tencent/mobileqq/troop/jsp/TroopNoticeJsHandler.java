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
  private static int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QunAlbumSetting", "QunShowPictureIntentLimit", 200);
  public static String b = "pic_up";
  public static String c = "pic";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
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
    //   4: invokestatic 85	com/tencent/biz/common/util/ImageUtil:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   7: astore 9
    //   9: aload 9
    //   11: ifnonnull +15 -> 26
    //   14: aload 9
    //   16: ifnull +8 -> 24
    //   19: aload 9
    //   21: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload 9
    //   28: astore_2
    //   29: new 92	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 9
    //   40: astore_2
    //   41: aload 10
    //   43: getstatic 98	com/tencent/mobileqq/app/AppConstants:SDCARD_FILE_SAVE_TROOPTMP_PATH	Ljava/lang/String;
    //   46: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 9
    //   52: astore_2
    //   53: aload 10
    //   55: ldc 104
    //   57: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 9
    //   63: astore_2
    //   64: aload 10
    //   66: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 112	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   72: astore 10
    //   74: aload 9
    //   76: astore_2
    //   77: aload 9
    //   79: new 114	java/io/File
    //   82: dup
    //   83: aload 10
    //   85: invokespecial 117	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokestatic 122	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   91: aload 9
    //   93: ifnull +8 -> 101
    //   96: aload 9
    //   98: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   101: new 124	java/util/HashMap
    //   104: dup
    //   105: invokespecial 125	java/util/HashMap:<init>	()V
    //   108: astore_2
    //   109: aload_2
    //   110: ldc 127
    //   112: aload 5
    //   114: invokestatic 129	com/tencent/mobileqq/troop/jsp/TroopNoticeJsHandler:a	(Ljava/lang/String;)Ljava/lang/String;
    //   117: invokeinterface 135 3 0
    //   122: pop
    //   123: aload_3
    //   124: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +61 -> 188
    //   130: new 137	org/json/JSONObject
    //   133: dup
    //   134: aload_3
    //   135: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 142	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   143: astore 9
    //   145: aload 9
    //   147: invokeinterface 148 1 0
    //   152: ifeq +36 -> 188
    //   155: aload 9
    //   157: invokeinterface 152 1 0
    //   162: checkcast 57	java/lang/String
    //   165: astore 11
    //   167: aload_2
    //   168: aload 11
    //   170: aload_3
    //   171: aload 11
    //   173: invokevirtual 156	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   176: invokevirtual 159	java/lang/Object:toString	()Ljava/lang/String;
    //   179: invokeinterface 135 3 0
    //   184: pop
    //   185: goto -40 -> 145
    //   188: new 124	java/util/HashMap
    //   191: dup
    //   192: invokespecial 125	java/util/HashMap:<init>	()V
    //   195: astore_3
    //   196: aload_3
    //   197: aload 6
    //   199: aload 10
    //   201: invokeinterface 135 3 0
    //   206: pop
    //   207: aload_0
    //   208: invokevirtual 60	java/lang/String:length	()I
    //   211: istore 8
    //   213: new 161	java/lang/StringBuffer
    //   216: dup
    //   217: ldc 163
    //   219: invokespecial 164	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   222: astore 6
    //   224: iconst_0
    //   225: istore 7
    //   227: iload 7
    //   229: bipush 10
    //   231: iload 8
    //   233: isub
    //   234: if_icmpge +20 -> 254
    //   237: aload 6
    //   239: ldc 166
    //   241: invokevirtual 169	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   244: pop
    //   245: iload 7
    //   247: iconst_1
    //   248: iadd
    //   249: istore 7
    //   251: goto -24 -> 227
    //   254: aload 6
    //   256: aload_0
    //   257: invokevirtual 169	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   260: pop
    //   261: new 124	java/util/HashMap
    //   264: dup
    //   265: invokespecial 125	java/util/HashMap:<init>	()V
    //   268: astore_0
    //   269: aload_0
    //   270: ldc 171
    //   272: new 173	java/net/URL
    //   275: dup
    //   276: aload_1
    //   277: invokespecial 174	java/net/URL:<init>	(Ljava/lang/String;)V
    //   280: invokevirtual 177	java/net/URL:getRef	()Ljava/lang/String;
    //   283: invokeinterface 135 3 0
    //   288: pop
    //   289: aload 4
    //   291: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   294: ifne +65 -> 359
    //   297: new 137	org/json/JSONObject
    //   300: dup
    //   301: aload 4
    //   303: invokespecial 138	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   306: astore 4
    //   308: aload 4
    //   310: invokevirtual 142	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   313: astore 9
    //   315: aload 9
    //   317: invokeinterface 148 1 0
    //   322: ifeq +37 -> 359
    //   325: aload 9
    //   327: invokeinterface 152 1 0
    //   332: checkcast 57	java/lang/String
    //   335: astore 10
    //   337: aload_0
    //   338: aload 10
    //   340: aload 4
    //   342: aload 10
    //   344: invokevirtual 156	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   347: invokevirtual 159	java/lang/Object:toString	()Ljava/lang/String;
    //   350: invokeinterface 135 3 0
    //   355: pop
    //   356: goto -41 -> 315
    //   359: aload_1
    //   360: aload 6
    //   362: invokevirtual 178	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   365: aload 5
    //   367: aload_2
    //   368: aload_3
    //   369: aload_0
    //   370: invokestatic 184	com/tencent/biz/common/util/HttpUtil:uploadImage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Ljava/lang/String;
    //   373: areturn
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 187	java/net/MalformedURLException:printStackTrace	()V
    //   379: aconst_null
    //   380: areturn
    //   381: astore_0
    //   382: goto +17 -> 399
    //   385: astore_0
    //   386: goto +36 -> 422
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_2
    //   392: goto +50 -> 442
    //   395: astore_0
    //   396: aconst_null
    //   397: astore 9
    //   399: aload 9
    //   401: astore_2
    //   402: aload_0
    //   403: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   406: aload 9
    //   408: ifnull +8 -> 416
    //   411: aload 9
    //   413: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   416: aconst_null
    //   417: areturn
    //   418: astore_0
    //   419: aconst_null
    //   420: astore 9
    //   422: aload 9
    //   424: astore_2
    //   425: aload_0
    //   426: invokevirtual 189	java/lang/OutOfMemoryError:printStackTrace	()V
    //   429: aload 9
    //   431: ifnull +8 -> 439
    //   434: aload 9
    //   436: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   439: aconst_null
    //   440: areturn
    //   441: astore_0
    //   442: aload_2
    //   443: ifnull +7 -> 450
    //   446: aload_2
    //   447: invokevirtual 90	android/graphics/Bitmap:recycle	()V
    //   450: goto +5 -> 455
    //   453: aload_0
    //   454: athrow
    //   455: goto -2 -> 453
    //   458: astore_3
    //   459: goto -271 -> 188
    //   462: astore 4
    //   464: goto -105 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	paramString1	String
    //   0	467	1	paramString2	String
    //   0	467	2	paramString3	String
    //   0	467	3	paramString4	String
    //   0	467	4	paramString5	String
    //   0	467	5	paramString6	String
    //   0	467	6	paramString7	String
    //   225	25	7	i	int
    //   211	23	8	j	int
    //   7	428	9	localObject1	Object
    //   36	307	10	localObject2	Object
    //   165	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   269	289	374	java/net/MalformedURLException
    //   29	38	381	java/io/IOException
    //   41	50	381	java/io/IOException
    //   53	61	381	java/io/IOException
    //   64	74	381	java/io/IOException
    //   77	91	381	java/io/IOException
    //   29	38	385	java/lang/OutOfMemoryError
    //   41	50	385	java/lang/OutOfMemoryError
    //   53	61	385	java/lang/OutOfMemoryError
    //   64	74	385	java/lang/OutOfMemoryError
    //   77	91	385	java/lang/OutOfMemoryError
    //   0	9	389	finally
    //   0	9	395	java/io/IOException
    //   0	9	418	java/lang/OutOfMemoryError
    //   29	38	441	finally
    //   41	50	441	finally
    //   53	61	441	finally
    //   64	74	441	finally
    //   77	91	441	finally
    //   402	406	441	finally
    //   425	429	441	finally
    //   130	145	458	org/json/JSONException
    //   145	185	458	org/json/JSONException
    //   297	315	462	org/json/JSONException
    //   315	356	462	org/json/JSONException
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
      localBundle.putString("btntext", paramActivity.getString(2131717945));
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
  
  protected void a(String paramString)
  {
    Object localObject8;
    label1113:
    label1116:
    label1122:
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
              localObject2 = this.mRuntime.a();
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
            this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject6).optString("callback");
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
                if (this.mRuntime.a() == null) {
                  return;
                }
                localObject3 = this.mRuntime.a();
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
                  break label1116;
                }
                localObject3 = new ArrayList();
                m = ((JSONArray)localObject4).length();
                i = 0;
                if (i >= m) {
                  break label1113;
                }
                ((ArrayList)localObject3).add(((JSONArray)localObject4).get(i).toString());
                i += 1;
                continue;
                if (localObject10 == null) {
                  break label1122;
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
                QLog.d(this.TAG, 2, new Object[] { "KANDIAN Grid Image title: ", localObject5, ", articleUrl: ", localObject6, ", showTitle: ", Boolean.valueOf(bool3) });
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
                if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
                {
                  this.jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopNoticeJsHandler.1(this);
                  localObject7 = new IntentFilter("android.intent.action.WEBJSCALL");
                  ((Activity)localObject2).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject7);
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
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface == null) {
        return;
      }
      Activity localActivity = this.mRuntime.a();
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
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      localCustomWebView.loadUrl(localStringBuilder.toString());
    }
  }
  
  protected void f(String paramString)
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
        if (this.mRuntime.a() == null) {
          return;
        }
        localObject = this.mRuntime.a();
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
        f(paramVarArgs[0]);
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
          paramIntent.append(this.jdField_a_of_type_JavaLangString);
          paramIntent.append("([])");
          localCustomWebView.loadUrl(paramIntent.toString());
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (this.mRuntime != null))
    {
      Activity localActivity2 = this.mRuntime.a();
      if (localActivity2 == null) {
        return;
      }
      Activity localActivity1 = localActivity2;
      if ((localActivity2 instanceof BasePluginActivity)) {
        localActivity1 = ((BasePluginActivity)localActivity2).getOutActivity();
      }
      localActivity1.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler
 * JD-Core Version:    0.7.0.1
 */