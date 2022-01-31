import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.2;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.3;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper.6;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class smk
{
  public static int a;
  public static long a;
  public static String a;
  public static boolean a;
  private static final String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "QQ/8.3.5 Android/0.17 Android/" + Build.VERSION.RELEASE;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -1;
    case 1: 
    case 5: 
      return 24;
    case 3: 
      return 27;
    }
    return 0;
  }
  
  private static Bundle a(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static String a(String paramString)
  {
    if (AppSetting.f) {}
    Object localObject1;
    for (;;)
    {
      return null;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
      {
        localObject1 = Uri.parse(paramString).getQueryParameter("v_bid");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = bejv.a(paramString);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((bejw)localObject2).jdField_b_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ViolaAccessHelper", 2, "load offline想 data cache on loadRes");
            }
            return ((bejw)localObject2).jdField_b_of_type_JavaLangString;
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = ncb.a((String)localObject1);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = (String)localObject2 + (String)localObject1 + File.separator;
                paramString = nbv.d(paramString);
                localObject1 = new File((String)localObject1 + paramString);
                if (!((File)localObject1).exists())
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("ViolaAccessHelper", 4, "getResponse local file not exists :" + paramString);
                  return null;
                }
              }
            }
          }
          catch (Exception paramString)
          {
            QLog.e("ViolaAccessHelper", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
            return null;
          }
        }
      }
    }
    paramString = ViolaUtils.readFile((File)localObject1);
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = a(paramString1);
      if (paramString1.containsKey(paramString2))
      {
        paramString1 = paramString1.getString(paramString2);
        if (!TextUtils.isEmpty(paramString1)) {
          return paramString1;
        }
        return null;
      }
    }
    return null;
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    if (bkbq.j(paramAppRuntime)) {
      return "http://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=2&v_bundleName=messageBox&statusColor=1&support_night=1";
    }
    return "http://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=6&v_bundleName=messageBox&v_bid=3740&statusColor=1&support_night=1";
  }
  
  public static JSONObject a()
  {
    Object localObject = (QQAppInterface)ors.a();
    if (localObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
      String str = ((QQAppInterface)localObject).getAccount();
      localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
      localJSONObject.put("Cookie", "uin=o" + str + "; skey=" + (String)localObject);
      localJSONObject.put("User-Agent", jdField_b_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "getBaseInitData JSONException e" + localJSONException.getMessage());
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "preInit");
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = ors.a();
    }
    if ((System.currentTimeMillis() - jdField_a_of_type_Long >= 18000000L) || ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!jdField_a_of_type_JavaLangString.equals(ors.a()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is start");
      }
      a("3192", new sml());
    }
    if (ViolaSDKEngine.isInitialized()) {
      return;
    }
    ThreadManager.post(new ViolaAccessHelper.2(), 8, null, true);
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    Object localObject1;
    int i;
    Object localObject2;
    label200:
    int j;
    switch (paramInt)
    {
    default: 
      localObject1 = "";
      i = 0;
      localObject2 = (String)localObject1 + "&v_present=2";
      localObject1 = localObject2;
      if (paramBundle.containsKey("floating_window_rowkey")) {
        localObject1 = (String)localObject2 + "&rowkey=" + paramBundle.getString("floating_window_rowkey");
      }
      localObject2 = localObject1;
      if (paramBundle.containsKey("float_layer_topic_id")) {
        localObject2 = (String)localObject1 + "&topicId=" + paramBundle.getString("float_layer_topic_id");
      }
      Object localObject3 = localObject2;
      boolean bool;
      if (paramBundle.containsKey("scroll_to_top"))
      {
        bool = paramBundle.getBoolean("scroll_to_top", false);
        localObject2 = new StringBuilder().append((String)localObject2);
        if (bool)
        {
          localObject1 = "&v_present_auto_top=1";
          localObject3 = (String)localObject1;
        }
      }
      else
      {
        localObject1 = localObject3;
        if (paramBundle.containsKey("up_animation"))
        {
          bool = paramBundle.getBoolean("up_animation", false);
          localObject2 = new StringBuilder().append((String)localObject3);
          if (!bool) {
            break label826;
          }
          localObject1 = "&v_present_pop=1";
          localObject1 = (String)localObject1;
        }
        localObject3 = localObject1;
        if (paramBundle.containsKey("margin_top"))
        {
          localObject2 = paramBundle.getString("margin_top", null);
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = localObject1;
            if (!"null".equals(localObject2)) {
              localObject3 = (String)localObject1 + "&v_present_top=" + paramBundle.getString("margin_top");
            }
          }
        }
        localObject2 = localObject3;
        if (paramBundle.containsKey("gray_bar"))
        {
          bool = paramBundle.getBoolean("gray_bar", false);
          localObject2 = new StringBuilder().append((String)localObject3);
          if (!bool) {
            break label834;
          }
          localObject1 = "&v_present_back_bar=1";
          localObject2 = (String)localObject1;
        }
        localObject1 = localObject2;
        if (paramBundle.containsKey("floating_bundle_extra_data"))
        {
          localObject3 = paramBundle.getBundle("floating_bundle_extra_data");
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((Bundle)localObject3).containsKey("VIDEO_H5_URL"))
            {
              localObject3 = ((Bundle)localObject3).getString("VIDEO_H5_URL", "");
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject1 = localObject2;
                if (((String)localObject3).contains("redpackid")) {
                  localObject1 = (String)localObject2 + "&redpackid=" + Uri.parse((String)localObject3).getQueryParameter("redpackid");
                }
              }
            }
          }
        }
        localObject2 = localObject1;
        if (paramBundle.containsKey("floating_window_scene"))
        {
          i = paramBundle.getInt("floating_window_scene", 0);
          localObject2 = localObject1;
          if (i == 4) {
            localObject2 = (String)localObject1 + "&v_present_interrupt_back=1";
          }
          localObject2 = (String)localObject2 + "&presentFrom=" + i;
        }
        localObject1 = localObject2;
        if (paramBundle.containsKey("REPORT_VIDEO_FEEDS_CHANNEL_ID")) {
          localObject1 = (String)localObject2 + "&channelId=" + paramBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
        }
        if (paramInt != 2) {
          break label842;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("VIDEO_FROM_TYPE", a(i));
        ((Intent)localObject2).putExtras(paramBundle);
        MultiVideoFragment.a(paramContext, (Intent)localObject2, (String)localObject1);
        return;
      }
      break;
    case 2: 
      label260:
      label404:
      localObject1 = "http://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1";
      localObject2 = new JSONObject();
      if (paramBundle.containsKey("floating_window_scene"))
      {
        j = paramBundle.getInt("floating_window_scene", 0);
        i = j;
        if (j != 3) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject2).put("autoPlayDisable", bkbq.h());
        i = j;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i = j;
        continue;
      }
      paramBundle.putString("param", ((JSONObject)localObject2).toString());
      break;
      localObject1 = "https://viola.qq.com/js/shortPGC.js?_rij_violaUrl=1&v_tid=15&v_bundleName=shortPGC&hideNav=1&v_nav_immer=1&v_bid=3811&v_present_titleHeight=44";
      i = 0;
      break;
      localObject1 = "http://viola.qq.com/js/topic-detail.js?_rij_violaUrl=1&v_tid=15&v_bundleName=topic-detail&v_bid=3811&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1";
      i = 0;
      break;
      localObject1 = "&v_present_auto_top=0";
      break label200;
      label826:
      localObject1 = "&v_present_pop=0";
      break label260;
      label834:
      localObject1 = "&v_present_back_bar=0";
      break label404;
      label842:
      a(paramContext, "", (String)localObject1, paramBundle, false);
      return;
      i = 0;
    }
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle, false);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, sms paramsms)
  {
    if (!a(paramContext)) {
      if (paramsms != null) {
        paramsms.a();
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if ((paramString2.contains("v_tid")) && (paramString2.contains("v_bundleName")))
          {
            b(paramContext, paramString1, paramString2, paramBundle);
            return;
          }
          if (!TextUtils.isEmpty(Uri.parse(paramString2).getQueryParameter("v_bid"))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ViolaAccessHelper", 4, "openViolaPageWithOffline businessId is empty,url = " + paramString2);
          }
        } while (paramsms == null);
        paramsms.a();
        return;
        str = spw.b(paramString2);
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 4, "openViolaPageWithOffline filePath is empty,url = " + paramString2);
        }
      } while (paramsms == null);
      paramsms.a();
      return;
      if (new File(str).exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 4, "getResponse local file not exists :" + str);
      }
    } while (paramsms == null);
    paramsms.a();
    return;
    b(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    String str1 = paramString2;
    try
    {
      if (paramString2.contains("v_bid_min_version"))
      {
        String str3 = Uri.parse(paramString2).getQueryParameter("v_bid");
        localObject = Uri.parse(paramString2).getQueryParameter("v_bid_min_version");
        str1 = paramString2;
        if (!TextUtils.isEmpty(str3))
        {
          str1 = paramString2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            str3 = nbv.a(str3);
            str1 = paramString2;
            if (!TextUtils.isEmpty(str3))
            {
              str1 = paramString2;
              if (Integer.valueOf(str3).intValue() < Integer.valueOf((String)localObject).intValue()) {
                str1 = paramString2 + "&v_bid_apply_anywhere=0";
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        QLog.e("ViolaAccessHelper", 2, "startViolaPage error " + localException.getMessage());
        String str2 = paramString2;
        continue;
        paramString2 = "&from_splash_activity=0";
        continue;
        label387:
        adpn.a((Activity)paramContext, localIntent, PublicTransFragmentActivity.class, ViolaFragment.class);
      }
      label405:
      if ((paramBundle == null) || (!paramBundle.containsKey("requestCode")) || (!(paramContext instanceof Activity))) {
        break label497;
      }
      if (!paramBoolean) {
        break label476;
      }
      localIntent.putExtra("public_fragment_window_feature", 1);
      adpn.a((Activity)paramContext, localIntent, PublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
      ((Activity)paramContext).overridePendingTransition(2130772010, 0);
      return;
      label476:
      PublicFragmentActivity.a((Activity)paramContext, localIntent, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
      return;
      label497:
      if (!paramBoolean) {
        break label536;
      }
      localIntent.putExtra("public_fragment_window_feature", 1);
      adpn.a(paramContext, localIntent, PublicTransFragmentActivity.class, ViolaFragment.class);
      ((Activity)paramContext).overridePendingTransition(2130772010, 0);
      return;
      label536:
      PublicFragmentActivity.a(paramContext, localIntent, ViolaFragment.class);
    }
    localObject = new StringBuilder().append(str1);
    if ((paramContext instanceof SplashActivity))
    {
      paramString2 = "&from_splash_activity=1";
      localIntent.putExtra("url", paramString2);
      localIntent.putExtra(sno.jdField_a_of_type_JavaLangString, paramString1);
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      if (paramBundle != null)
      {
        if (paramBundle.containsKey(ViolaFragment.jdField_a_of_type_JavaLangString)) {
          localIntent.putExtra(ViolaFragment.jdField_a_of_type_JavaLangString, paramBundle.getString(ViolaFragment.jdField_a_of_type_JavaLangString));
        }
        if (paramBundle.containsKey("param")) {
          localIntent.putExtra("param", paramBundle.getString("param"));
        }
      }
      if ((!str1.contains("v_present=2")) && (!str1.contains("v_present=1"))) {
        break label405;
      }
      localIntent.putExtra("public_fragment_window_feature", 1);
      if ((paramBundle == null) || (!paramBundle.containsKey("requestCode")) || (!(paramContext instanceof Activity))) {
        break label387;
      }
      adpn.a((Activity)paramContext, localIntent, PublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(0, 0);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, sms paramsms) {}
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramContext == null)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject1 = paramJSONObject.optString("from_type");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label855;
          }
          if (((String)localObject1).equals("2"))
          {
            localObject1 = paramJSONObject.opt("video_card");
            if ((localObject1 != null) && ((localObject1 instanceof JSONObject)))
            {
              localObject2 = (JSONObject)localObject1;
              if (localObject2 != null)
              {
                localObject1 = new Intent(paramContext, VideoFeedsPlayActivity.class);
                ((Intent)localObject1).putExtra("is_from_viola", paramJSONObject.optString("from_viola"));
                str1 = paramJSONObject.optString("isFromWeishiDiscover");
                str2 = paramJSONObject.optString("isWeishiSource");
                if (!"1".equals(str1)) {
                  break label806;
                }
                ((Intent)localObject1).putExtra("VIDEO_FROM_TYPE", 20);
                ((Intent)localObject1).putExtra("key_source", 5);
                ((Intent)localObject1).putExtra("VIDEO_COMMON_DATA", ((JSONObject)localObject2).optString("common_data_24"));
                if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("topic_id_18"))) {
                  ((Intent)localObject1).putExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", Long.valueOf(((JSONObject)localObject2).optString("topic_id_18")));
                }
                ((Intent)localObject1).putExtra("VIDEO_VID", ((JSONObject)localObject2).optString("vid_19"));
                ((Intent)localObject1).putExtra("VIDEO_ARTICLE_ID", ((JSONObject)localObject2).optString("article_id_8"));
                ((Intent)localObject1).putExtra("VIDEO_PUB_ACCOUNT_UIN", ((JSONObject)localObject2).optString("subscribe_id_6"));
                ((Intent)localObject1).putExtra("VIDEO_PUB_ACCOUNT_NAME", ((JSONObject)localObject2).optString("subscribe_name_7"));
                ((Intent)localObject1).putExtra("VIDEO_THIRD_ACTION", ((JSONObject)localObject2).optString("third_action_20"));
                ((Intent)localObject1).putExtra("VIDEO_THIRD_ICON", ((JSONObject)localObject2).optString("third_icon_url_21"));
                ((Intent)localObject1).putExtra("VIDEO_THIRD_NAME", ((JSONObject)localObject2).optString("third_uin_name_22"));
                ((Intent)localObject1).putExtra("VIDEO_TITLE", ((JSONObject)localObject2).optString("article_title_9"));
                ((Intent)localObject1).putExtra("VIDEO_SUMMARY", ((JSONObject)localObject2).optString("article_summary_10"));
                ((Intent)localObject1).putExtra("VIDEO_COVER", ((JSONObject)localObject2).optString("cover_url_2"));
                ((Intent)localObject1).putExtra("VIDEO_URL", ((JSONObject)localObject2).optString("video_url_23"));
                ((Intent)localObject1).putExtra("VIDEO_WIDTH", ((JSONObject)localObject2).optString("width_25"));
                ((Intent)localObject1).putExtra("VIDEO_HEIGHT", ((JSONObject)localObject2).optString("height_26"));
                ((Intent)localObject1).putExtra("VIDEO_TIME", ((JSONObject)localObject2).optString("duration_27"));
                if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("busiType_28"))) {
                  ((Intent)localObject1).putExtra("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf(((JSONObject)localObject2).optString("busiType_28")));
                }
                if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("feeds_type_4"))) {
                  ((Intent)localObject1).putExtra("VIDEO_FEED_TYPE", Integer.valueOf(((JSONObject)localObject2).optString("feeds_type_4")));
                }
                if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("feeds_id_3"))) {
                  ((Intent)localObject1).putExtra("VIDEO_FEED_ID", Long.valueOf(((JSONObject)localObject2).optString("feeds_id_3")));
                }
                if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("xg_file_size_29"))) {
                  ((Intent)localObject1).putExtra("VIDEO_XG_FILE_SIZE", Long.valueOf(((JSONObject)localObject2).optString("xg_file_size_29")));
                }
                localObject2 = paramJSONObject.optJSONObject("from_frame");
                if (localObject2 != null)
                {
                  if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("x"))) {
                    ((Intent)localObject1).putExtra("item_x", Integer.valueOf(((JSONObject)localObject2).getString("x")));
                  }
                  if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("y"))) {
                    ((Intent)localObject1).putExtra("item_y", Integer.valueOf(((JSONObject)localObject2).getString("y")));
                  }
                  if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("height"))) {
                    ((Intent)localObject1).putExtra("item_height", Integer.valueOf(((JSONObject)localObject2).getString("height")));
                  }
                  if (!TextUtils.isEmpty(((JSONObject)localObject2).optString("width"))) {
                    ((Intent)localObject1).putExtra("item_width", Integer.valueOf(((JSONObject)localObject2).getString("width")));
                  }
                }
                localObject1 = ((Intent)localObject1).getExtras();
                localObject2 = new Intent();
                ((Intent)localObject2).putExtras((Bundle)localObject1);
                MultiVideoFragment.a(paramContext, (Intent)localObject2);
                return;
              }
            }
          }
        }
        catch (Exception paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ViolaAccessHelper", 2, "openVideo jsonobject is: " + paramJSONObject.toString() + "  error :" + paramContext.getMessage());
    return;
    label806:
    if ("1".equals(str2)) {
      ((Intent)localObject1).putExtra("VIDEO_FROM_TYPE", 23);
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra("key_source", 4);
      break;
      ((Intent)localObject1).putExtra("VIDEO_FROM_TYPE", 18);
    }
    label855:
    Bundle localBundle = new Bundle();
    new Intent(paramContext, VideoFeedsPlayActivity.class);
    Object localObject1 = paramJSONObject.optString("innerUniqueID");
    Object localObject2 = paramJSONObject.optString("busitype");
    String str1 = paramJSONObject.optString("video_vid");
    String str2 = paramJSONObject.optString("video_width");
    Object localObject3 = paramJSONObject.optString("video_height");
    String str3 = paramJSONObject.optString("video_duration");
    String str4 = paramJSONObject.optString("video_from_type");
    String str5 = paramJSONObject.optString("title");
    String str6 = paramJSONObject.optString("video_cover");
    String str7 = paramJSONObject.optString("share_url");
    String str8 = paramJSONObject.optString("account_name");
    String str9 = paramJSONObject.optString("account_uin");
    String str10 = paramJSONObject.optString("video_create_time");
    String str11 = paramJSONObject.optString("third_icon_url");
    String str12 = paramJSONObject.optString("third_name");
    String str13 = paramJSONObject.optString("third_jump_url");
    String str14 = paramJSONObject.optString("biudata");
    String str15 = paramJSONObject.optString("commondata");
    int i = paramJSONObject.optInt("from_viola", 0);
    String str16 = paramJSONObject.optString("video_url");
    int j = paramJSONObject.optInt("channel_id", -1);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("from_frame");
    localBundle.putString("VIDEO_ARTICLE_ID", (String)localObject1);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf((String)localObject2).intValue());
    }
    localBundle.putString("VIDEO_VID", str1);
    if (!TextUtils.isEmpty(str4)) {
      localBundle.putInt("VIDEO_FROM_TYPE", Integer.valueOf(str4).intValue());
    }
    localBundle.putString("VIDEO_WIDTH", str2);
    localBundle.putString("VIDEO_HEIGHT", (String)localObject3);
    localBundle.putString("VIDEO_TIME", str3);
    localBundle.putString("VIDEO_TITLE", str5);
    localBundle.putString("VIDEO_COVER", str6);
    localBundle.putString("VIDEO_H5_URL", str7);
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", str8);
    localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", str9);
    localBundle.putString("VIDEO_CREATE_TIME", str10);
    localBundle.putString("VIDEO_THIRD_ICON", str11);
    localBundle.putString("VIDEO_THIRD_NAME", str12);
    localBundle.putString("VIDEO_THIRD_ACTION", str13);
    localBundle.putString("VIDEO_COMMON_DATA", str15);
    localBundle.putString("VIDEO_ARTICLE_INFO_FOR_BIU", str14);
    localBundle.putString("is_from_viola", String.valueOf(i));
    localBundle.putString("VIDEO_URL", str16);
    if (localJSONObject != null)
    {
      if (!TextUtils.isEmpty(localJSONObject.optString("x"))) {
        localBundle.putInt("item_x", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.getString("x"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("y"))) {
        localBundle.putInt("item_y", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.getString("y"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("height"))) {
        localBundle.putInt("item_height", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.getString("height"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("width"))) {
        localBundle.putInt("item_width", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.getString("width"), 750));
      }
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("commentId", null)))
    {
      localObject1 = paramJSONObject.optString("commentId", null);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (TextUtils.isEmpty(paramJSONObject.optString("subCommentId", null))) {
          break label1724;
        }
        localObject2 = paramJSONObject.optString("subCommentId", null);
        label1513:
        if (TextUtils.isEmpty(paramJSONObject.optString("jumpCommentType", null))) {
          break label1737;
        }
        str1 = paramJSONObject.optString("jumpCommentType", null);
        label1537:
        if (TextUtils.isEmpty(paramJSONObject.optString("isAwesome", null))) {
          break label1750;
        }
      }
    }
    label1724:
    label1737:
    label1750:
    for (str2 = paramJSONObject.optString("isAwesome", null);; str2 = paramJSONObject.optString("isawesome", null))
    {
      localObject3 = new AnchorData();
      ((AnchorData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
      ((AnchorData)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject2);
      ((AnchorData)localObject3).jdField_b_of_type_Boolean = "0".equals(str1);
      ((AnchorData)localObject3).jdField_a_of_type_Boolean = "1".equals(str2);
      localBundle.putBoolean("VIDEO_SHOW_COMMENT", true);
      localBundle.putParcelable("VIDEO_COMMENT_ANCHOR", (Parcelable)localObject3);
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", j);
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "openVideo jsonobject is: " + paramJSONObject.toString() + "  bundle is :" + localBundle.toString());
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtras(localBundle);
      MultiVideoFragment.a(paramContext, (Intent)localObject1);
      return;
      localObject1 = paramJSONObject.optString("commentid", null);
      break;
      localObject2 = paramJSONObject.optString("subcommentid", null);
      break label1513;
      str1 = paramJSONObject.optString("jumpcommenttype", null);
      break label1537;
    }
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface paramAppInterface, String paramString, sng paramsng, smq paramsmq)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 265	com/tencent/viola/core/ViolaSDKEngine:isInitialized	()Z
    //   6: ifne +91 -> 97
    //   9: new 745	com/tencent/viola/core/InitConfig$Builder
    //   12: dup
    //   13: invokespecial 746	com/tencent/viola/core/InitConfig$Builder:<init>	()V
    //   16: iconst_1
    //   17: invokevirtual 750	com/tencent/viola/core/InitConfig$Builder:setBusinessId	(I)Lcom/tencent/viola/core/InitConfig$Builder;
    //   20: aload_1
    //   21: invokevirtual 754	com/tencent/viola/core/InitConfig$Builder:setFramework	(Ljava/lang/String;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   24: new 756	smz
    //   27: dup
    //   28: invokespecial 757	smz:<init>	()V
    //   31: invokevirtual 761	com/tencent/viola/core/InitConfig$Builder:setHttpAdapter	(Lcom/tencent/viola/adapter/IHttpAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   34: new 763	sni
    //   37: dup
    //   38: invokespecial 764	sni:<init>	()V
    //   41: invokevirtual 768	com/tencent/viola/core/InitConfig$Builder:setComponentAdapter	(Lcom/tencent/viola/adapter/VComponentAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   44: aload_2
    //   45: invokevirtual 772	com/tencent/viola/core/InitConfig$Builder:setReportDelegate	(Lcom/tencent/viola/commons/IReportDelegate;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   48: new 774	snf
    //   51: dup
    //   52: invokespecial 775	snf:<init>	()V
    //   55: invokevirtual 779	com/tencent/viola/core/InitConfig$Builder:setLogAdapter	(Lcom/tencent/viola/adapter/ILogAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   58: astore_2
    //   59: aload_0
    //   60: ifnull +32 -> 92
    //   63: aload_0
    //   64: invokevirtual 785	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   67: astore_1
    //   68: aload_1
    //   69: aload_2
    //   70: invokevirtual 789	com/tencent/viola/core/InitConfig$Builder:build	()Lcom/tencent/viola/core/InitConfig;
    //   73: new 791	smo
    //   76: dup
    //   77: aload_0
    //   78: aload_3
    //   79: invokespecial 794	smo:<init>	(Lcom/tencent/common/app/AppInterface;Lsmq;)V
    //   82: invokestatic 795	spw:a	()Ljava/lang/String;
    //   85: invokestatic 799	com/tencent/viola/core/ViolaSDKEngine:initialize	(Landroid/app/Application;Lcom/tencent/viola/core/InitConfig;Lcom/tencent/viola/core/ViolaSDKEngine$InitCallback;Ljava/lang/String;)V
    //   88: ldc 2
    //   90: monitorexit
    //   91: return
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -26 -> 68
    //   97: ldc_w 801
    //   100: ldc_w 803
    //   103: iconst_0
    //   104: invokestatic 807	com/tencent/viola/core/ViolaSDKEngine:registerModule	(Ljava/lang/String;Ljava/lang/Class;Z)Z
    //   107: pop
    //   108: aload_3
    //   109: ifnull -21 -> 88
    //   112: aload_0
    //   113: new 809	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$5
    //   116: dup
    //   117: aload_3
    //   118: invokespecial 812	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$5:<init>	(Lsmq;)V
    //   121: invokevirtual 816	com/tencent/common/app/AppInterface:runOnUiThread	(Ljava/lang/Runnable;)V
    //   124: goto -36 -> 88
    //   127: astore_0
    //   128: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq -43 -> 88
    //   134: ldc 125
    //   136: iconst_2
    //   137: new 14	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 17	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 818
    //   147: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: invokevirtual 471	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 23	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 32	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -75 -> 88
    //   166: astore_0
    //   167: ldc 2
    //   169: monitorexit
    //   170: aload_0
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	172	1	paramString	String
    //   0	172	2	paramsng	sng
    //   0	172	3	paramsmq	smq
    // Exception table:
    //   from	to	target	type
    //   97	108	127	java/lang/Exception
    //   112	124	127	java/lang/Exception
    //   3	59	166	finally
    //   63	68	166	finally
    //   68	88	166	finally
    //   97	108	166	finally
    //   112	124	166	finally
    //   128	163	166	finally
  }
  
  @Deprecated
  public static void a(String paramString, smq paramsmq)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if ((localQQAppInterface == null) && (paramsmq != null))
    {
      paramsmq.a();
      return;
    }
    a(localQQAppInterface, paramString, null, paramsmq);
  }
  
  public static void a(String paramString, smr paramsmr)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (paramsmr != null) {
        paramsmr.b();
      }
      return;
    }
    ThreadManager.post(new ViolaAccessHelper.3(paramString, localQQAppInterface, paramsmr, System.currentTimeMillis()), 8, null, true);
  }
  
  public static void a(String paramString, srg paramsrg)
  {
    ThreadManager.post(new ViolaAccessHelper.6(paramString, paramsrg), 8, null, false);
  }
  
  public static boolean a()
  {
    return bkbq.q(ors.a());
  }
  
  private static boolean a(Context paramContext)
  {
    if (!oxi.a().a()) {
      oxi.a().a();
    }
    if (!Build.CPU_ABI.contains("armeabi"))
    {
      a(paramContext, "cpu架构不支持");
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit check cpu config is false");
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            return false;
            if (a()) {
              break;
            }
            a(paramContext, alud.a(2131716859));
          } while (!QLog.isColorLevel());
          QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkWhiteConfig is false");
          return false;
          if (c()) {
            break;
          }
          a(paramContext, alud.a(2131716861));
        } while (!QLog.isColorLevel());
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkSO is false");
        return false;
        str = spw.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        a(paramContext, "mainJsPath is empty");
      } while (!QLog.isColorLevel());
      QLog.d("ViolaAccessHelper", 2, "isViolaPermit mainJsPath is empty");
      return false;
      if (new File(str).exists()) {
        break;
      }
      a(paramContext, alud.a(2131716860));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit viola.js is false");
      }
      paramContext = Uri.parse("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547").getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(paramContext));
    b(paramContext);
    return false;
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ("1".equals(a(paramString, "_rij_violaUrl")));
  }
  
  public static String b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramString.contains("viola_share_url"))
      {
        String str = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = URLDecoder.decode(str);
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        if (str.contains("_rij_violaUrl=1")) {
          return ???;
        }
        return null;
      }
      boolean bool = paramString.contains("_rij_violaUrl=1");
      if (!bool) {
        return null;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "getViolaUrlFromWeb error:" + localException.getMessage() + ",webUrl=" + paramString);
      }
      paramString = null;
    }
    return paramString;
    return localException;
  }
  
  public static void b()
  {
    a("http://sqimg.qq.com/qq_product_operations/kan/viola_config/viola_config.json?v_bid=3192", new smp());
  }
  
  @Deprecated
  private static void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  private static void b(String paramString)
  {
    a(paramString, null);
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramString.contains("viola_share_url"))
      {
        Object localObject = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = URLDecoder.decode((String)localObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("_rij_violaUrl=1")))
          {
            localObject = Uri.parse((String)localObject).getQueryParameter("v_minVersion");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              return true;
            }
            localObject = ((String)localObject).split("\\.");
            String[] arrayOfString = "8.3.5".split("\\.");
            if (Integer.valueOf(localObject[0]).intValue() < Integer.valueOf(arrayOfString[0]).intValue()) {
              return true;
            }
            if ((Integer.valueOf(localObject[0]) == Integer.valueOf(arrayOfString[0])) && (Integer.valueOf(localObject[1]).intValue() < Integer.valueOf(arrayOfString[1]).intValue())) {
              return true;
            }
            if ((Integer.valueOf(localObject[0]) == Integer.valueOf(arrayOfString[0])) && (Integer.valueOf(localObject[1]) == Integer.valueOf(arrayOfString[1])) && (Integer.valueOf(localObject[2]).intValue() <= Integer.valueOf(arrayOfString[2]).intValue())) {
              return true;
            }
          }
        }
      }
      else
      {
        boolean bool = paramString.contains("_rij_violaUrl=1");
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "isViolaUrlFromWeb error:" + localException.getMessage() + ",webUrl=" + paramString);
      }
    }
    return false;
  }
  
  private static boolean c()
  {
    return oxi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     smk
 * JD-Core Version:    0.7.0.1
 */