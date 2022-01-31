import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.2;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.20;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.3;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.9;
import com.tencent.common.app.AppInterface;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sfk
  extends WebViewPlugin
{
  static HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  static Map<String, ArrayList<String>> jdField_a_of_type_JavaUtilMap;
  public static HashMap<String, String> b;
  static Map<String, ArrayList<String>> jdField_b_of_type_JavaUtilMap;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String l;
  public int a;
  public Activity a;
  ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  public Handler a;
  bfpc jdField_a_of_type_Bfpc;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  ArrayList<sgf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public qoz a;
  qvt jdField_a_of_type_Qvt = null;
  sfh jdField_a_of_type_Sfh;
  wxr jdField_a_of_type_Wxr = null;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  String jdField_b_of_type_JavaLangString;
  ArrayList<sge> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  int c;
  int d;
  public int e;
  public int f;
  String k = "";
  String m;
  public String n = "";
  public String o = "";
  public String p = "";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), "publicAccountNew.getPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "troopNotice.showPicture");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), "qbizApi.getNetworkType");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "ui.closeWebViews");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), "ui.setOnShareQQFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), "ui.setOnShareQZoneHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), "ui.setOnShareWXFriendHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), "ui.setOnShareWXTimelineHandler");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(8), "publicAccount.getLocation");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), "publicAccountNew.hideMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "publicAccountNew.showMenuItems");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "publicAccountNew.hideAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(13), "publicAccountNew.showAllNonBaseMenuItem");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), "publicAccountNew.showWebPanel");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), "publicAccountNew.scanQRCode");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(16), "publicAccountNew.setRightButtonState");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(17), "publicAccountNew.uploadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(18), "publicAccountNew.downloadImage");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(20), "publicAccountNew.hideWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(21), "publicAccountNew.showWebToolbar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(30), "wallet.publicPay");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(40), "publicAccountNew.startRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(41), "publicAccountNew.stopRecord");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(42), "publicAccountNew.playVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(43), "publicAccountNew.pauseVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(44), "publicAccountNew.stopVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(45), "publicAccountNew.uploadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(46), "publicAccountNew.downloadVoice");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(47), "publicAccountNew.onVoiceRecordEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(48), "publicAccountNew.onVoicePlayEnd");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(49), "publicAccountNew.selectAndUploadAvatar");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(50), "publicAccountNew.addPreDownloadVideo");
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(51), "publicAccountNew.stopPreDownloadVideo");
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public sfk()
  {
    this.jdField_a_of_type_Int = 1281;
    this.jdField_b_of_type_Int = 1282;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Qoz = null;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new sfl(this);
    this.mPluginNameSpace = "publicAccountNew";
  }
  
  public static WebResourceResponse a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString);
        if (paramString == null) {
          return null;
        }
        paramString = naz.a(SafeBitmapFactory.decodeFile(paramString));
        if (paramString != null)
        {
          paramString = new WebResourceResponse("image/png", "UTF-8", paramString);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        return null;
      }
      paramString = null;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (this.jdField_a_of_type_AndroidAppActivity == null)) {}
    String str2;
    do
    {
      return;
      str2 = paramIntent.getStringExtra("arg_callback");
    } while (TextUtils.isEmpty(str2));
    int i1 = paramIntent.getIntExtra("result_code", -1);
    if (i1 == 0) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicAccountH5AbilityPlugin.9(this), 200L);
    }
    String str1 = "";
    if (paramIntent.hasExtra("result_msg")) {
      str1 = paramIntent.getStringExtra("result_msg");
    }
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("retCode", i1);
      paramIntent.put("msg", str1);
      callJs(str2, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (onh.g() >= 2)
    {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131718435), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    paramString4 = new Bundle();
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("mTaskID", String.valueOf(System.currentTimeMillis() + (Math.random() * 10000.0D)));
    paramString4.putString("arg_topic_id", paramString1);
    paramString4.putString("arg_topic_name", paramString2);
    paramString4.putInt("arg_ad_tag", paramInt1);
    paramString4.putString("arg_callback", paramString3);
    paramString4.putString("arg_ugc_edit_cookie", paramString8);
    oeg.a(this, this.mRuntime.a(), paramString4, (byte)116);
    onh.a("2", "2");
  }
  
  private void a(String paramString, String... paramVarArgs)
  {
    int i1 = 0;
    if ((paramVarArgs != null) && (paramVarArgs.length > 0) && (this.jdField_a_of_type_AndroidAppActivity != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramVarArgs[0]);
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend param json:" + ((JSONObject)localObject1).toString());
        }
        paramString = ((JSONObject)localObject1).optString("rowkey", "");
        int i2 = ((JSONObject)localObject1).optInt("maxSelect");
        int i3 = ((JSONObject)localObject1).optInt("maxCount");
        paramVarArgs = ((JSONObject)localObject1).optString("callback", "");
        Object localObject2 = ((JSONObject)localObject1).optString("invitedUins", "[]");
        localObject1 = new StringBuilder();
        if ((localObject2 != null) && (((String)localObject2).trim().length() > 0))
        {
          localObject2 = new JSONArray(((String)localObject2).trim());
          if (i1 < ((JSONArray)localObject2).length())
          {
            ((StringBuilder)localObject1).append(((JSONArray)localObject2).get(i1));
            if (i1 >= ((JSONArray)localObject2).length() - 1) {
              break label339;
            }
            ((StringBuilder)localObject1).append(",");
            break label339;
          }
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("opentype", 1);
        ((Intent)localObject2).putExtra("filterUins", ((StringBuilder)localObject1).toString());
        ((Intent)localObject2).putExtra("maxSelect", i2);
        if (i3 > 0) {
          ((Intent)localObject2).putExtra("maxCount", i3);
        }
        ((Intent)localObject2).putExtra("rowkey", paramString);
        ((Intent)localObject2).putExtra("callback", paramVarArgs);
        PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, ReadInJoySelectMemberAQFragment.class, 119);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountH5AbilityPlugin", 2, "selectAndInviteFriend e = " + paramString);
        }
        paramString.printStackTrace();
        return;
      }
      label339:
      i1 += 1;
    }
  }
  
  public static void a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString))
        {
          paramArrayList.remove(i1);
          return;
        }
        i1 += 1;
      }
    }
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i1 = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int i2 = paramJSONObject.optInt("feedsType", -1);
        int i3 = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l1 = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool1 = paramJSONObject.optBoolean("isAwesome");
        int i4 = paramJSONObject.optInt("jumpType");
        int i5 = paramJSONObject.optInt("showType", 0);
        boolean bool2 = paramJSONObject.optBoolean("canBiu", true);
        QLog.d("PublicAccountH5AbilityPlugin", 1, "startShowComment  uniqueKey = " + str1 + "source = " + i1 + "feedsId = " + (String)localObject2 + " feedsType=" + i2 + "adTag = " + i3 + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l1 + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, i2, (String)localObject2, i3, str3, str4, str5, l1));
        paramJSONObject.putInt("source", i1);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool1);
        paramJSONObject.putInt("jumpType", i4);
        paramJSONObject.putInt("seq", paramInt);
        paramJSONObject.putBoolean("canBiu", bool2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((AnchorData)localObject2).jdField_b_of_type_JavaLangString = str2;
        ((AnchorData)localObject2).jdField_a_of_type_Boolean = bool1;
        QLog.d("PublicAccountH5AbilityPlugin", 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (i5 == 1)
        {
          bool1 = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool1, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        boolean bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramJSONObject));
      }
      bool1 = false;
    }
  }
  
  public static void a(JSONObject paramJSONObject, String paramString, ryd paramryd)
  {
    wxr localwxr = wxr.a();
    localwxr.a();
    a(paramJSONObject, localwxr.a(new sgc(paramryd, paramString)));
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString1)) {}
    do
    {
      do
      {
        return false;
        paramString1 = (ArrayList)jdField_a_of_type_JavaUtilMap.get(paramString1);
        if (!"QQApi.shareMsg".equals(paramString2)) {
          break;
        }
      } while ((!a(paramString1, "ui.setOnShareQQFriendHandler")) && (!a(paramString1, "ui.ui.setOnShareQZoneHandler")) && (!a(paramString1, "ui.ui.setOnShareWXFriendHandler")) && (!a(paramString1, "ui.setOnShareWXTimelineHandler")));
      return true;
    } while (!a(paramString1, paramString2));
    if ("qbizApi.getNetworkType".equals(paramString2)) {
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString2)) {
        axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString2)) {
        axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString2)) {
        axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
      }
    }
  }
  
  public static boolean a(ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        if (((String)paramArrayList.get(i1)).equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[32];
    int i1 = 0;
    while (i1 < 32)
    {
      arrayOfInt[(31 - i1)] = (paramInt >> i1 & 0x1);
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private void d(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("imageIDs");
        int i3 = ((JSONObject)localObject2).optInt("index");
        String str1 = ((JSONObject)localObject2).optString("srcID");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("isNotShowIndex", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("showTitle", false);
        String str2 = new String(bbco.decode(((JSONObject)localObject2).optString("title", ""), 0));
        String str3 = ((JSONObject)localObject2).optString("articleUrl", "");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("isReport", false);
        long l1 = ((JSONObject)localObject2).optLong("touin");
        long l2 = ((JSONObject)localObject2).optLong("feeds_id");
        int i4 = ((JSONObject)localObject2).optInt("feeds_type");
        long l3 = ((JSONObject)localObject2).optLong("articleId");
        int i5 = ((JSONObject)localObject2).optInt("source");
        int i1 = 0;
        if (localObject1 != null) {
          i1 = ((JSONArray)localObject1).length();
        }
        if (Boolean.valueOf(bool3).booleanValue())
        {
          paramString = new PublicAccountShowPictureReport();
          paramString.parse((JSONObject)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountH5AbilityPlugin", 2, new Object[] { "KANDIAN Grid Image title: ", str2, ", articleUrl: ", str3, ", showTitle: ", Boolean.valueOf(bool2) });
          }
          if ((localObject1 == null) || (((JSONArray)localObject1).length() == 0))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PublicAccountH5AbilityPlugin", 2, "imageList is null or length is 0");
            return;
          }
          localObject2 = new ArrayList();
          int i2 = 0;
          if (i2 < ((JSONArray)localObject1).length())
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject1).get(i2).toString());
            i2 += 1;
            continue;
          }
          if (this.jdField_a_of_type_AndroidAppActivity == null) {
            break;
          }
          localObject1 = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putInt("index", i3);
          localBundle.putStringArrayList("seqNum", (ArrayList)localObject2);
          localBundle.putBoolean("needBottomBar", false);
          localBundle.putBoolean("IS_EDIT", false);
          localBundle.putBoolean("is_use_path", true);
          localBundle.putBoolean("is_show_action", true);
          localBundle.putBoolean("is_not_show_index", bool1);
          localBundle.putBoolean("is_grid_image_report", true);
          localBundle.putString("to_uin", Long.toString(l1));
          localBundle.putString("feeds_id", Long.toString(l2));
          localBundle.putString("article_id", Long.toString(l3));
          localBundle.putString("scroll_image_r5", onh.a(i1, -1, Integer.toString(i5), i4, "", "", null));
          localBundle.putString("read_article_r5", onh.a(i1, -1, Integer.toString(i5), i4, "", null));
          if (!TextUtils.isEmpty(str1)) {
            localBundle.putString("src_id", str1);
          }
          if ((bool2) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          {
            localBundle.putBoolean("is_show_content_url", true);
            localBundle.putString("article_url", str3);
            localBundle.putString("article_title", str2);
          }
          if ((paramString != null) && (paramString.isReport)) {
            localBundle.putString("PublicAccountShowPictureReport", paramString.toString());
          }
          ((Intent)localObject1).putExtras(localBundle);
          this.jdField_a_of_type_AndroidAppActivity.startActivityForResult((Intent)localObject1, 100);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = null;
    }
  }
  
  private void e(String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    if (!bbfj.g(this.mRuntime.a()))
    {
      wij.a(1, 2131693314);
      return;
    }
    localObject = new bcqf(this.mRuntime.a());
    ((bcqf)localObject).c(2131694100);
    ((bcqf)localObject).show();
    ThreadManager.executeOnSubThread(new PublicAccountH5AbilityPlugin.20(this, paramString, localBundle, (bcqf)localObject));
  }
  
  public ArrayList<String> a()
  {
    bcfh localbcfh = (bcfh)super.getBrowserComponent(4);
    if (localbcfh != null) {
      return localbcfh.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Wxr = wxr.a();
      this.jdField_a_of_type_Wxr.a();
    }
    if (this.jdField_a_of_type_Qoz == null) {
      this.jdField_a_of_type_Qoz = qoz.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", ajya.a(2131708778));
    if (paramInt2 == 1)
    {
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 2);
      if (paramInt2 != 0) {
        break label168;
      }
      localIntent.putExtra("PhotoConst.original_button", true);
      localIntent.putExtra("PhotoConst.quality_count_tv", true);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().a(this, localIntent, (byte)111);
      }
      return;
      if (paramInt2 != 2) {
        break;
      }
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      break;
      label168:
      localIntent.putExtra("PhotoConst.original_button", false);
      localIntent.putExtra("PhotoConst.quality_count_tv", false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte paramByte, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 25);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ReadInJoyUploadAvatarActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("key_from_kandian_uploadimg", true);
    String str = bbvj.a(ajsd.aW + "readinjoy_avatar_upload/");
    localIntent.putExtra("PhotoConst.TARGET_PATH", str + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt3);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt4);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt5);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt6);
    localIntent.putExtra("from", paramInt1);
    localIntent.putExtra("type", paramInt2);
    if (this.mRuntime.a() != null)
    {
      paramInt1 = this.mRuntime.a().switchRequestCode(this, paramByte);
      localIntent.putExtra("keyAction", "actionSelectPicture");
      localIntent.putExtra("requestCode", paramInt1);
    }
    startActivityForResult(localIntent, paramByte);
    bbbx.a(this.jdField_a_of_type_AndroidAppActivity, false, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfpc == null) {
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560950, null);
    this.jdField_a_of_type_Bfpc.a((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131366389);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131366387);
    localObject = (TextView)((View)localObject).findViewById(2131366469);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bfpc.isShowing()) {
        this.jdField_a_of_type_Bfpc.show();
      }
      localTextView1.setOnClickListener(new sfp(this, paramString));
      localTextView2.setOnClickListener(new sfq(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new sfr(this));
      return;
      if (paramInt1 == 2)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setVisibility(8);
      }
    }
  }
  
  void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    String str3 = this.k;
    String str1;
    if (str3 != null)
    {
      str1 = str3;
      if (!"".equals(str3)) {}
    }
    else
    {
      str1 = "12345678";
    }
    try
    {
      Long.parseLong(str1);
      if ((this.jdField_a_of_type_Wxr != null) && (!"".equals(paramString1))) {
        this.jdField_a_of_type_Wxr.b(paramString1, paramInt, str1, paramBoolean, new sfu(this, paramBoolean, paramString3, paramString2), new sfv(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str2 = "12345678";
      }
    }
  }
  
  void a(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    Object localObject2 = this.k;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!"".equals(localObject2)) {}
    }
    else
    {
      localObject1 = "12345678";
    }
    try
    {
      Long.parseLong((String)localObject1);
      if ((this.jdField_a_of_type_Wxr != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + naj.a());
        }
        if (naj.a() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            bcql.a(this.jdField_a_of_type_AndroidAppActivity, "你已离开wifi环境", 0).a();
          }
        }
        this.jdField_a_of_type_Wxr.a(paramString1, paramInt, (String)localObject1, paramBoolean, new sfs(this, paramString2, paramBoolean), new sft(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = "12345678";
      }
    }
  }
  
  void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("pic_local_path");
    if (paramBundle != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject2 = jdField_b_of_type_JavaUtilHashMap.entrySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (paramBundle.equals(((Map.Entry)localObject3).getValue())) {
          ((ArrayList)localObject1).add((String)((Map.Entry)localObject3).getKey());
        }
      }
      paramBundle = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          sgf localsgf = (sgf)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localsgf.jdField_b_of_type_JavaLangString)) {
            paramBundle.add(localsgf);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramBundle);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        paramBundle = (sgf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localObject1 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramBundle.jdField_b_of_type_JavaLangString);
        a(paramBundle.jdField_a_of_type_Int, (String)localObject1, true, paramBundle.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  void a(String paramString)
  {
    this.k = "";
    if (paramString != null) {
      jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
  
  void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nor.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.0,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_b_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.k);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new sfn(this, paramString2, paramInt, paramBoolean, paramString1));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nor.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.0,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
    }
    localNewIntent.setObserver(new sfo(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nor.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.0,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_a_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("puin", this.k);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject.put("url", paramString1);
        localJSONObject.put("type", "2");
      }
      catch (JSONException paramString1)
      {
        sfh localsfh;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new sfm(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_Sfh == null) {
        this.jdField_a_of_type_Sfh = new sfh(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
      }
      this.jdField_a_of_type_Sfh.h();
      localJSONObject.put("file_uuid", paramString1);
      localsfh = this.jdField_a_of_type_Sfh;
      localJSONObject.put("file_md5", sfh.b());
      localsfh = this.jdField_a_of_type_Sfh;
      localJSONObject.put("file_name", sfh.c());
      localsfh = this.jdField_a_of_type_Sfh;
      localJSONObject.put("file_size", sfh.b());
      localsfh = this.jdField_a_of_type_Sfh;
      localJSONObject.put("file_time", sfh.c());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localsfh = this.jdField_a_of_type_Sfh;
        paramString1 = paramString1.append(sfh.b()).append(" file_name:");
        localsfh = this.jdField_a_of_type_Sfh;
        paramString1 = paramString1.append(sfh.c()).append(" file_size=");
        localsfh = this.jdField_a_of_type_Sfh;
        paramString1 = paramString1.append(sfh.b()).append(" file_time=");
        localsfh = this.jdField_a_of_type_Sfh;
        QLog.i("PublicAccountH5AbilityPlugin", 2, sfh.c());
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (!a(a(), str)) {
        a().add(str);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().m(paramBoolean);
      }
      return;
      axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Sfh != null) {
      this.jdField_a_of_type_Sfh.f();
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, AccountDetailActivity.class);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("fromBrowser", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      a(a(), str);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PoiMapActivity.class).putExtra("uin", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_Wxr.c();
  }
  
  void c(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        sge localsge = (sge)localIterator.next();
        if (paramString.equals(localsge.jdField_b_of_type_JavaLangString)) {
          localArrayList.add(localsge);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = (sge)this.jdField_b_of_type_JavaUtilArrayList.get(0);
      a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_a_of_type_Int, true, paramString.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void d()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().c();
    }
  }
  
  public void e()
  {
    a().clear();
    a().add("menuItem:share:qq");
    a().add("menuItem:share:QZone");
    a().add("menuItem:share:appMessage");
    a().add("menuItem:share:timeline");
    a().add("menuItem:openWithQQBrowser");
    a().add("menuItem:openWithSafari");
    a().add("menuItem:favorite");
    a().add("menuItem:copyUrl");
    a().add("menuItem:exportTencentDocs");
  }
  
  public void f()
  {
    a().clear();
  }
  
  public void g()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().a(false);
    }
  }
  
  public void h()
  {
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().a(true);
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934600L)
    {
      if (paramMap != null)
      {
        int i1 = ((Integer)paramMap.get("requestCode")).intValue();
        if ((i1 == 1) || (i1 == 113) || (i1 == 114) || (i1 == 115) || (i1 == 116) || (i1 == 117) || (i1 == 118) || (i1 == 119) || (i1 == 122))
        {
          int i2 = ((Integer)paramMap.get("resultCode")).intValue();
          onActivityResult((Intent)paramMap.get("data"), (byte)i1, i2);
          return true;
        }
      }
    }
    else if (paramLong == 8589934597L) {
      b();
    }
    return false;
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 187
    //   2: aload_3
    //   3: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifeq +4475 -> 4481
    //   9: ldc_w 1329
    //   12: aload 4
    //   14: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   17: ifeq +125 -> 142
    //   20: aload 5
    //   22: ifnull +82 -> 104
    //   25: aload 5
    //   27: arraylength
    //   28: ifle +76 -> 104
    //   31: new 265	org/json/JSONObject
    //   34: dup
    //   35: aload 5
    //   37: iconst_0
    //   38: aaload
    //   39: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   42: ldc_w 415
    //   45: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifne +47 -> 100
    //   56: new 265	org/json/JSONObject
    //   59: dup
    //   60: invokespecial 266	org/json/JSONObject:<init>	()V
    //   63: astore_2
    //   64: aload_2
    //   65: ldc_w 268
    //   68: iconst_0
    //   69: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 273
    //   77: ldc_w 1331
    //   80: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_0
    //   85: aload_1
    //   86: iconst_1
    //   87: anewarray 201	java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: aload_2
    //   93: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   96: aastore
    //   97: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   100: aload_0
    //   101: invokevirtual 1332	sfk:c	()V
    //   104: aconst_null
    //   105: ldc_w 639
    //   108: ldc_w 641
    //   111: ldc 163
    //   113: ldc_w 1334
    //   116: ldc_w 1334
    //   119: iconst_0
    //   120: iconst_0
    //   121: ldc 163
    //   123: ldc 163
    //   125: ldc 163
    //   127: ldc 163
    //   129: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   139: goto -35 -> 104
    //   142: ldc_w 1336
    //   145: aload 4
    //   147: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   150: ifeq +56 -> 206
    //   153: aload 5
    //   155: ifnull +41 -> 196
    //   158: aload 5
    //   160: arraylength
    //   161: ifle +35 -> 196
    //   164: new 265	org/json/JSONObject
    //   167: dup
    //   168: aload 5
    //   170: iconst_0
    //   171: aaload
    //   172: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: ldc_w 1260
    //   178: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore_1
    //   182: ldc 163
    //   184: aload_1
    //   185: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne +8 -> 196
    //   191: aload_0
    //   192: aload_1
    //   193: invokevirtual 1338	sfk:b	(Ljava/lang/String;)V
    //   196: iconst_1
    //   197: ireturn
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   203: goto -7 -> 196
    //   206: ldc_w 1340
    //   209: aload 4
    //   211: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   214: ifeq +97 -> 311
    //   217: aload 5
    //   219: ifnull +82 -> 301
    //   222: aload 5
    //   224: arraylength
    //   225: ifle +76 -> 301
    //   228: new 265	org/json/JSONObject
    //   231: dup
    //   232: aload 5
    //   234: iconst_0
    //   235: aaload
    //   236: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   239: ldc_w 415
    //   242: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: astore_1
    //   246: aload_1
    //   247: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +47 -> 297
    //   253: new 265	org/json/JSONObject
    //   256: dup
    //   257: invokespecial 266	org/json/JSONObject:<init>	()V
    //   260: astore_2
    //   261: aload_2
    //   262: ldc_w 268
    //   265: iconst_0
    //   266: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   269: pop
    //   270: aload_2
    //   271: ldc_w 273
    //   274: ldc_w 1331
    //   277: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload_0
    //   282: aload_1
    //   283: iconst_1
    //   284: anewarray 201	java/lang/String
    //   287: dup
    //   288: iconst_0
    //   289: aload_2
    //   290: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   293: aastore
    //   294: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   297: aload_0
    //   298: invokevirtual 1342	sfk:d	()V
    //   301: iconst_1
    //   302: ireturn
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   308: goto -7 -> 301
    //   311: ldc_w 1344
    //   314: aload 4
    //   316: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   319: ifeq +110 -> 429
    //   322: aload 5
    //   324: ifnull +95 -> 419
    //   327: aload 5
    //   329: arraylength
    //   330: ifle +89 -> 419
    //   333: new 265	org/json/JSONObject
    //   336: dup
    //   337: aload 5
    //   339: iconst_0
    //   340: aaload
    //   341: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   344: astore_1
    //   345: aload_1
    //   346: ldc_w 1346
    //   349: invokevirtual 515	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   352: istore 13
    //   354: aload_1
    //   355: ldc_w 415
    //   358: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_1
    //   362: aload_1
    //   363: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +47 -> 413
    //   369: new 265	org/json/JSONObject
    //   372: dup
    //   373: invokespecial 266	org/json/JSONObject:<init>	()V
    //   376: astore_2
    //   377: aload_2
    //   378: ldc_w 268
    //   381: iconst_0
    //   382: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload_2
    //   387: ldc_w 273
    //   390: ldc_w 1331
    //   393: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   396: pop
    //   397: aload_0
    //   398: aload_1
    //   399: iconst_1
    //   400: anewarray 201	java/lang/String
    //   403: dup
    //   404: iconst_0
    //   405: aload_2
    //   406: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   409: aastore
    //   410: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   413: aload_0
    //   414: iload 13
    //   416: invokevirtual 1347	sfk:a	(Z)V
    //   419: iconst_1
    //   420: ireturn
    //   421: astore_1
    //   422: aload_1
    //   423: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   426: goto -7 -> 419
    //   429: ldc_w 1349
    //   432: aload 4
    //   434: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   437: ifeq +180 -> 617
    //   440: aload 5
    //   442: ifnull +137 -> 579
    //   445: aload 5
    //   447: arraylength
    //   448: ifle +131 -> 579
    //   451: new 265	org/json/JSONObject
    //   454: dup
    //   455: aload 5
    //   457: iconst_0
    //   458: aaload
    //   459: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   462: astore_2
    //   463: aload_2
    //   464: ldc_w 415
    //   467: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   470: astore_1
    //   471: aload_2
    //   472: ldc_w 1351
    //   475: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   478: astore_3
    //   479: new 174	java/util/ArrayList
    //   482: dup
    //   483: invokespecial 175	java/util/ArrayList:<init>	()V
    //   486: astore_2
    //   487: aload_3
    //   488: ifnull +35 -> 523
    //   491: iconst_0
    //   492: istore 6
    //   494: iload 6
    //   496: aload_3
    //   497: invokevirtual 429	org/json/JSONArray:length	()I
    //   500: if_icmpge +23 -> 523
    //   503: aload_2
    //   504: aload_3
    //   505: iload 6
    //   507: invokevirtual 1353	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   510: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   513: pop
    //   514: iload 6
    //   516: iconst_1
    //   517: iadd
    //   518: istore 6
    //   520: goto -26 -> 494
    //   523: aload_1
    //   524: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   527: ifne +47 -> 574
    //   530: new 265	org/json/JSONObject
    //   533: dup
    //   534: invokespecial 266	org/json/JSONObject:<init>	()V
    //   537: astore_3
    //   538: aload_3
    //   539: ldc_w 268
    //   542: iconst_0
    //   543: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   546: pop
    //   547: aload_3
    //   548: ldc_w 273
    //   551: ldc_w 1331
    //   554: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload_0
    //   559: aload_1
    //   560: iconst_1
    //   561: anewarray 201	java/lang/String
    //   564: dup
    //   565: iconst_0
    //   566: aload_3
    //   567: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   570: aastore
    //   571: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   574: aload_0
    //   575: aload_2
    //   576: invokevirtual 1355	sfk:a	(Ljava/util/ArrayList;)V
    //   579: aconst_null
    //   580: ldc_w 639
    //   583: ldc_w 641
    //   586: ldc 163
    //   588: ldc_w 1357
    //   591: ldc_w 1357
    //   594: iconst_0
    //   595: iconst_0
    //   596: ldc 163
    //   598: ldc 163
    //   600: ldc 163
    //   602: ldc 163
    //   604: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   607: iconst_1
    //   608: ireturn
    //   609: astore_1
    //   610: aload_1
    //   611: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   614: goto -35 -> 579
    //   617: ldc_w 1359
    //   620: aload 4
    //   622: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   625: ifeq +180 -> 805
    //   628: aload 5
    //   630: ifnull +137 -> 767
    //   633: aload 5
    //   635: arraylength
    //   636: ifle +131 -> 767
    //   639: new 265	org/json/JSONObject
    //   642: dup
    //   643: aload 5
    //   645: iconst_0
    //   646: aaload
    //   647: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   650: astore_2
    //   651: aload_2
    //   652: ldc_w 415
    //   655: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   658: astore_1
    //   659: aload_2
    //   660: ldc_w 1351
    //   663: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   666: astore_3
    //   667: new 174	java/util/ArrayList
    //   670: dup
    //   671: invokespecial 175	java/util/ArrayList:<init>	()V
    //   674: astore_2
    //   675: aload_3
    //   676: ifnull +35 -> 711
    //   679: iconst_0
    //   680: istore 6
    //   682: iload 6
    //   684: aload_3
    //   685: invokevirtual 429	org/json/JSONArray:length	()I
    //   688: if_icmpge +23 -> 711
    //   691: aload_2
    //   692: aload_3
    //   693: iload 6
    //   695: invokevirtual 1353	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   698: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   701: pop
    //   702: iload 6
    //   704: iconst_1
    //   705: iadd
    //   706: istore 6
    //   708: goto -26 -> 682
    //   711: aload_1
    //   712: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   715: ifne +47 -> 762
    //   718: new 265	org/json/JSONObject
    //   721: dup
    //   722: invokespecial 266	org/json/JSONObject:<init>	()V
    //   725: astore_3
    //   726: aload_3
    //   727: ldc_w 268
    //   730: iconst_0
    //   731: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   734: pop
    //   735: aload_3
    //   736: ldc_w 273
    //   739: ldc_w 1331
    //   742: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: aload_0
    //   747: aload_1
    //   748: iconst_1
    //   749: anewarray 201	java/lang/String
    //   752: dup
    //   753: iconst_0
    //   754: aload_3
    //   755: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   758: aastore
    //   759: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   762: aload_0
    //   763: aload_2
    //   764: invokevirtual 1361	sfk:b	(Ljava/util/ArrayList;)V
    //   767: aconst_null
    //   768: ldc_w 639
    //   771: ldc_w 641
    //   774: ldc 163
    //   776: ldc_w 1363
    //   779: ldc_w 1363
    //   782: iconst_0
    //   783: iconst_0
    //   784: ldc 163
    //   786: ldc 163
    //   788: ldc 163
    //   790: ldc 163
    //   792: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   795: iconst_1
    //   796: ireturn
    //   797: astore_1
    //   798: aload_1
    //   799: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   802: goto -35 -> 767
    //   805: ldc_w 1365
    //   808: aload 4
    //   810: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   813: ifeq +125 -> 938
    //   816: aload 5
    //   818: ifnull +82 -> 900
    //   821: aload 5
    //   823: arraylength
    //   824: ifle +76 -> 900
    //   827: new 265	org/json/JSONObject
    //   830: dup
    //   831: aload 5
    //   833: iconst_0
    //   834: aaload
    //   835: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   838: ldc_w 415
    //   841: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   844: astore_1
    //   845: aload_1
    //   846: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   849: ifne +47 -> 896
    //   852: new 265	org/json/JSONObject
    //   855: dup
    //   856: invokespecial 266	org/json/JSONObject:<init>	()V
    //   859: astore_2
    //   860: aload_2
    //   861: ldc_w 268
    //   864: iconst_0
    //   865: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   868: pop
    //   869: aload_2
    //   870: ldc_w 273
    //   873: ldc_w 1331
    //   876: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   879: pop
    //   880: aload_0
    //   881: aload_1
    //   882: iconst_1
    //   883: anewarray 201	java/lang/String
    //   886: dup
    //   887: iconst_0
    //   888: aload_2
    //   889: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   892: aastore
    //   893: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   896: aload_0
    //   897: invokevirtual 1367	sfk:e	()V
    //   900: aconst_null
    //   901: ldc_w 639
    //   904: ldc_w 641
    //   907: ldc 163
    //   909: ldc_w 1369
    //   912: ldc_w 1369
    //   915: iconst_0
    //   916: iconst_0
    //   917: ldc 163
    //   919: ldc 163
    //   921: ldc 163
    //   923: ldc 163
    //   925: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   928: iconst_1
    //   929: ireturn
    //   930: astore_1
    //   931: aload_1
    //   932: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   935: goto -35 -> 900
    //   938: ldc_w 1371
    //   941: aload 4
    //   943: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   946: ifeq +125 -> 1071
    //   949: aload 5
    //   951: ifnull +82 -> 1033
    //   954: aload 5
    //   956: arraylength
    //   957: ifle +76 -> 1033
    //   960: new 265	org/json/JSONObject
    //   963: dup
    //   964: aload 5
    //   966: iconst_0
    //   967: aaload
    //   968: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   971: ldc_w 415
    //   974: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   977: astore_1
    //   978: aload_1
    //   979: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   982: ifne +47 -> 1029
    //   985: new 265	org/json/JSONObject
    //   988: dup
    //   989: invokespecial 266	org/json/JSONObject:<init>	()V
    //   992: astore_2
    //   993: aload_2
    //   994: ldc_w 268
    //   997: iconst_0
    //   998: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1001: pop
    //   1002: aload_2
    //   1003: ldc_w 273
    //   1006: ldc_w 1331
    //   1009: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1012: pop
    //   1013: aload_0
    //   1014: aload_1
    //   1015: iconst_1
    //   1016: anewarray 201	java/lang/String
    //   1019: dup
    //   1020: iconst_0
    //   1021: aload_2
    //   1022: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1025: aastore
    //   1026: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1029: aload_0
    //   1030: invokevirtual 1372	sfk:f	()V
    //   1033: aconst_null
    //   1034: ldc_w 639
    //   1037: ldc_w 641
    //   1040: ldc 163
    //   1042: ldc_w 1374
    //   1045: ldc_w 1374
    //   1048: iconst_0
    //   1049: iconst_0
    //   1050: ldc 163
    //   1052: ldc 163
    //   1054: ldc 163
    //   1056: ldc 163
    //   1058: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1061: iconst_1
    //   1062: ireturn
    //   1063: astore_1
    //   1064: aload_1
    //   1065: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   1068: goto -35 -> 1033
    //   1071: ldc_w 1376
    //   1074: aload 4
    //   1076: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1079: ifeq +125 -> 1204
    //   1082: aload 5
    //   1084: ifnull +82 -> 1166
    //   1087: aload 5
    //   1089: arraylength
    //   1090: ifle +76 -> 1166
    //   1093: new 265	org/json/JSONObject
    //   1096: dup
    //   1097: aload 5
    //   1099: iconst_0
    //   1100: aaload
    //   1101: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1104: ldc_w 415
    //   1107: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1110: astore_1
    //   1111: aload_1
    //   1112: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1115: ifne +47 -> 1162
    //   1118: new 265	org/json/JSONObject
    //   1121: dup
    //   1122: invokespecial 266	org/json/JSONObject:<init>	()V
    //   1125: astore_2
    //   1126: aload_2
    //   1127: ldc_w 268
    //   1130: iconst_0
    //   1131: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1134: pop
    //   1135: aload_2
    //   1136: ldc_w 273
    //   1139: ldc_w 1331
    //   1142: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1145: pop
    //   1146: aload_0
    //   1147: aload_1
    //   1148: iconst_1
    //   1149: anewarray 201	java/lang/String
    //   1152: dup
    //   1153: iconst_0
    //   1154: aload_2
    //   1155: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1158: aastore
    //   1159: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1162: aload_0
    //   1163: invokevirtual 1377	sfk:h	()V
    //   1166: aconst_null
    //   1167: ldc_w 639
    //   1170: ldc_w 641
    //   1173: ldc 163
    //   1175: ldc_w 1379
    //   1178: ldc_w 1379
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc 163
    //   1185: ldc 163
    //   1187: ldc 163
    //   1189: ldc 163
    //   1191: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1194: iconst_1
    //   1195: ireturn
    //   1196: astore_1
    //   1197: aload_1
    //   1198: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   1201: goto -35 -> 1166
    //   1204: ldc_w 1381
    //   1207: aload 4
    //   1209: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1212: ifeq +125 -> 1337
    //   1215: aload 5
    //   1217: ifnull +82 -> 1299
    //   1220: aload 5
    //   1222: arraylength
    //   1223: ifle +76 -> 1299
    //   1226: new 265	org/json/JSONObject
    //   1229: dup
    //   1230: aload 5
    //   1232: iconst_0
    //   1233: aaload
    //   1234: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1237: ldc_w 415
    //   1240: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1243: astore_1
    //   1244: aload_1
    //   1245: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1248: ifne +47 -> 1295
    //   1251: new 265	org/json/JSONObject
    //   1254: dup
    //   1255: invokespecial 266	org/json/JSONObject:<init>	()V
    //   1258: astore_2
    //   1259: aload_2
    //   1260: ldc_w 268
    //   1263: iconst_0
    //   1264: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1267: pop
    //   1268: aload_2
    //   1269: ldc_w 273
    //   1272: ldc_w 1331
    //   1275: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1278: pop
    //   1279: aload_0
    //   1280: aload_1
    //   1281: iconst_1
    //   1282: anewarray 201	java/lang/String
    //   1285: dup
    //   1286: iconst_0
    //   1287: aload_2
    //   1288: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1291: aastore
    //   1292: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1295: aload_0
    //   1296: invokevirtual 1383	sfk:g	()V
    //   1299: aconst_null
    //   1300: ldc_w 639
    //   1303: ldc_w 641
    //   1306: ldc 163
    //   1308: ldc_w 1385
    //   1311: ldc_w 1385
    //   1314: iconst_0
    //   1315: iconst_0
    //   1316: ldc 163
    //   1318: ldc 163
    //   1320: ldc 163
    //   1322: ldc 163
    //   1324: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1327: iconst_1
    //   1328: ireturn
    //   1329: astore_1
    //   1330: aload_1
    //   1331: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   1334: goto -35 -> 1299
    //   1337: ldc_w 1387
    //   1340: aload 4
    //   1342: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1345: ifeq +336 -> 1681
    //   1348: aload 5
    //   1350: ifnull +289 -> 1639
    //   1353: aload 5
    //   1355: arraylength
    //   1356: ifle +283 -> 1639
    //   1359: new 265	org/json/JSONObject
    //   1362: dup
    //   1363: aload 5
    //   1365: iconst_0
    //   1366: aaload
    //   1367: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1370: astore_3
    //   1371: aload_3
    //   1372: ldc_w 415
    //   1375: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1378: astore_1
    //   1379: aload_3
    //   1380: ldc_w 1389
    //   1383: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1386: astore_2
    //   1387: aload_3
    //   1388: ldc_w 1391
    //   1391: iconst_1
    //   1392: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1395: istore 6
    //   1397: getstatic 132	sfk:jdField_b_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   1400: aload_2
    //   1401: invokevirtual 199	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1404: checkcast 201	java/lang/String
    //   1407: astore_3
    //   1408: new 1056	java/io/File
    //   1411: dup
    //   1412: aload_3
    //   1413: invokespecial 1057	java/io/File:<init>	(Ljava/lang/String;)V
    //   1416: astore 4
    //   1418: aload 4
    //   1420: ifnull +11 -> 1431
    //   1423: aload 4
    //   1425: invokevirtual 1394	java/io/File:exists	()Z
    //   1428: ifne +40 -> 1468
    //   1431: aload_0
    //   1432: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1435: new 388	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   1442: ldc_w 1395
    //   1445: invokestatic 872	ajya:a	(I)Ljava/lang/String;
    //   1448: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: aload_3
    //   1452: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1458: iconst_0
    //   1459: invokestatic 1067	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1462: invokevirtual 1070	bcql:a	()Landroid/widget/Toast;
    //   1465: pop
    //   1466: iconst_1
    //   1467: ireturn
    //   1468: aload 4
    //   1470: invokevirtual 1060	java/io/File:length	()J
    //   1473: ldc2_w 1396
    //   1476: lcmp
    //   1477: ifle +37 -> 1514
    //   1480: aload_0
    //   1481: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1484: new 388	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   1491: ldc_w 1399
    //   1494: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: aload_3
    //   1498: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1504: iconst_0
    //   1505: invokestatic 1067	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1508: invokevirtual 1070	bcql:a	()Landroid/widget/Toast;
    //   1511: pop
    //   1512: iconst_1
    //   1513: ireturn
    //   1514: aload_0
    //   1515: getfield 177	sfk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1518: invokevirtual 1113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1521: astore 4
    //   1523: aload 4
    //   1525: invokeinterface 1100 1 0
    //   1530: ifeq +51 -> 1581
    //   1533: aload 4
    //   1535: invokeinterface 1104 1 0
    //   1540: checkcast 1115	sgf
    //   1543: astore 5
    //   1545: aload_2
    //   1546: ifnull -23 -> 1523
    //   1549: aload_2
    //   1550: aload 5
    //   1552: getfield 1116	sgf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1555: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1558: ifeq -35 -> 1523
    //   1561: aload_0
    //   1562: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1565: ldc_w 1400
    //   1568: invokestatic 872	ajya:a	(I)Ljava/lang/String;
    //   1571: iconst_0
    //   1572: invokestatic 1067	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1575: invokevirtual 1070	bcql:a	()Landroid/widget/Toast;
    //   1578: pop
    //   1579: iconst_1
    //   1580: ireturn
    //   1581: new 1115	sgf
    //   1584: dup
    //   1585: invokespecial 1401	sgf:<init>	()V
    //   1588: astore 4
    //   1590: aload 4
    //   1592: aload_1
    //   1593: putfield 1122	sgf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1596: aload 4
    //   1598: aload_2
    //   1599: putfield 1116	sgf:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1602: aload 4
    //   1604: iload 6
    //   1606: putfield 1121	sgf:jdField_a_of_type_Int	I
    //   1609: aload_0
    //   1610: getfield 177	sfk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1613: aload 4
    //   1615: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1618: pop
    //   1619: aload_0
    //   1620: getfield 177	sfk:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1623: invokevirtual 465	java/util/ArrayList:size	()I
    //   1626: iconst_1
    //   1627: if_icmpne +44 -> 1671
    //   1630: aload_0
    //   1631: iload 6
    //   1633: aload_3
    //   1634: iconst_1
    //   1635: aload_1
    //   1636: invokevirtual 1124	sfk:a	(ILjava/lang/String;ZLjava/lang/String;)V
    //   1639: aconst_null
    //   1640: ldc_w 639
    //   1643: ldc_w 641
    //   1646: ldc 163
    //   1648: ldc_w 1403
    //   1651: ldc_w 1403
    //   1654: iconst_0
    //   1655: iconst_2
    //   1656: ldc_w 656
    //   1659: ldc 163
    //   1661: ldc 163
    //   1663: ldc 163
    //   1665: iconst_0
    //   1666: invokestatic 1408	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1669: iconst_1
    //   1670: ireturn
    //   1671: iconst_1
    //   1672: ireturn
    //   1673: astore_1
    //   1674: aload_1
    //   1675: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   1678: goto -39 -> 1639
    //   1681: ldc_w 1410
    //   1684: aload 4
    //   1686: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1689: ifeq +245 -> 1934
    //   1692: aload 5
    //   1694: ifnull +199 -> 1893
    //   1697: aload 5
    //   1699: arraylength
    //   1700: ifle +193 -> 1893
    //   1703: new 265	org/json/JSONObject
    //   1706: dup
    //   1707: aload 5
    //   1709: iconst_0
    //   1710: aaload
    //   1711: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1714: astore_3
    //   1715: aload_3
    //   1716: ldc_w 415
    //   1719: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1722: astore_1
    //   1723: aload_3
    //   1724: ldc_w 1412
    //   1727: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1730: astore_2
    //   1731: aload_3
    //   1732: ldc_w 1391
    //   1735: iconst_1
    //   1736: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1739: istore 6
    //   1741: ldc 163
    //   1743: aload_1
    //   1744: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1747: ifne +12 -> 1759
    //   1750: ldc 163
    //   1752: aload_2
    //   1753: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1756: ifeq +20 -> 1776
    //   1759: aload_0
    //   1760: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1763: ldc_w 1414
    //   1766: iconst_0
    //   1767: invokestatic 1067	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1770: invokevirtual 1070	bcql:a	()Landroid/widget/Toast;
    //   1773: pop
    //   1774: iconst_1
    //   1775: ireturn
    //   1776: aload_0
    //   1777: getfield 179	sfk:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1780: invokevirtual 1113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1783: astore_3
    //   1784: aload_3
    //   1785: invokeinterface 1100 1 0
    //   1790: ifeq +50 -> 1840
    //   1793: aload_3
    //   1794: invokeinterface 1104 1 0
    //   1799: checkcast 1273	sge
    //   1802: astore 4
    //   1804: aload_2
    //   1805: ifnull -21 -> 1784
    //   1808: aload_2
    //   1809: aload 4
    //   1811: getfield 1274	sge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1814: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1817: ifeq -33 -> 1784
    //   1820: aload_0
    //   1821: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1824: ldc_w 1415
    //   1827: invokestatic 872	ajya:a	(I)Ljava/lang/String;
    //   1830: iconst_0
    //   1831: invokestatic 1067	bcql:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lbcql;
    //   1834: invokevirtual 1070	bcql:a	()Landroid/widget/Toast;
    //   1837: pop
    //   1838: iconst_1
    //   1839: ireturn
    //   1840: new 1273	sge
    //   1843: dup
    //   1844: invokespecial 1416	sge:<init>	()V
    //   1847: astore_3
    //   1848: aload_3
    //   1849: aload_1
    //   1850: putfield 1276	sge:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1853: aload_3
    //   1854: aload_2
    //   1855: putfield 1274	sge:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1858: aload_3
    //   1859: iload 6
    //   1861: putfield 1275	sge:jdField_a_of_type_Int	I
    //   1864: aload_0
    //   1865: getfield 179	sfk:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1868: aload_3
    //   1869: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1872: pop
    //   1873: aload_0
    //   1874: getfield 179	sfk:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1877: invokevirtual 465	java/util/ArrayList:size	()I
    //   1880: iconst_1
    //   1881: if_icmpne +43 -> 1924
    //   1884: aload_0
    //   1885: aload_2
    //   1886: iload 6
    //   1888: iconst_1
    //   1889: aload_1
    //   1890: invokevirtual 1278	sfk:a	(Ljava/lang/String;IZLjava/lang/String;)V
    //   1893: aconst_null
    //   1894: ldc_w 639
    //   1897: ldc_w 641
    //   1900: ldc 163
    //   1902: ldc_w 1418
    //   1905: ldc_w 1418
    //   1908: iconst_0
    //   1909: iconst_2
    //   1910: ldc_w 656
    //   1913: ldc 163
    //   1915: ldc 163
    //   1917: ldc 163
    //   1919: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1922: iconst_1
    //   1923: ireturn
    //   1924: iconst_1
    //   1925: ireturn
    //   1926: astore_1
    //   1927: aload_1
    //   1928: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   1931: goto -38 -> 1893
    //   1934: ldc_w 1420
    //   1937: aload 4
    //   1939: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1942: ifeq +343 -> 2285
    //   1945: aload 5
    //   1947: ifnull +11208 -> 13155
    //   1950: aload 5
    //   1952: arraylength
    //   1953: ifle +11202 -> 13155
    //   1956: new 265	org/json/JSONObject
    //   1959: dup
    //   1960: aload 5
    //   1962: iconst_0
    //   1963: aaload
    //   1964: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1967: astore_2
    //   1968: aload_2
    //   1969: ldc_w 415
    //   1972: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1975: astore_1
    //   1976: aload_2
    //   1977: ldc_w 1389
    //   1980: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1983: astore_3
    //   1984: aload_2
    //   1985: ldc_w 1391
    //   1988: iconst_1
    //   1989: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1992: istore 6
    //   1994: aload_3
    //   1995: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1998: istore 13
    //   2000: iload 13
    //   2002: ifeq +95 -> 2097
    //   2005: new 265	org/json/JSONObject
    //   2008: dup
    //   2009: invokespecial 266	org/json/JSONObject:<init>	()V
    //   2012: astore_2
    //   2013: aload_2
    //   2014: ldc_w 268
    //   2017: iconst_m1
    //   2018: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2021: pop
    //   2022: aload_2
    //   2023: ldc_w 273
    //   2026: ldc_w 1422
    //   2029: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2032: pop
    //   2033: aload_0
    //   2034: aload_1
    //   2035: iconst_1
    //   2036: anewarray 201	java/lang/String
    //   2039: dup
    //   2040: iconst_0
    //   2041: aload_2
    //   2042: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2045: aastore
    //   2046: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2049: aconst_null
    //   2050: ldc_w 639
    //   2053: ldc_w 641
    //   2056: ldc 163
    //   2058: ldc_w 1424
    //   2061: ldc_w 1424
    //   2064: iconst_0
    //   2065: iconst_2
    //   2066: ldc_w 656
    //   2069: ldc 163
    //   2071: ldc 163
    //   2073: ldc 163
    //   2075: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2078: goto +11077 -> 13155
    //   2081: astore_1
    //   2082: aload_1
    //   2083: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2086: goto -37 -> 2049
    //   2089: astore_1
    //   2090: aload_1
    //   2091: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2094: goto +11061 -> 13155
    //   2097: aload_0
    //   2098: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2101: ifnonnull +26 -> 2127
    //   2104: aload_0
    //   2105: new 1210	sfh
    //   2108: dup
    //   2109: aload_0
    //   2110: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   2113: aload_0
    //   2114: getfield 1211	sfk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2117: aload_0
    //   2118: getfield 361	sfk:mRuntime	Lbcdp;
    //   2121: invokespecial 1214	sfh:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbcdp;)V
    //   2124: putfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2127: aload_0
    //   2128: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2131: aload_3
    //   2132: invokevirtual 1426	sfh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2135: astore_2
    //   2136: new 1056	java/io/File
    //   2139: dup
    //   2140: aload_2
    //   2141: invokespecial 1057	java/io/File:<init>	(Ljava/lang/String;)V
    //   2144: astore_3
    //   2145: aload_3
    //   2146: invokevirtual 1394	java/io/File:exists	()Z
    //   2149: ifne +58 -> 2207
    //   2152: new 265	org/json/JSONObject
    //   2155: dup
    //   2156: invokespecial 266	org/json/JSONObject:<init>	()V
    //   2159: astore_2
    //   2160: aload_2
    //   2161: ldc_w 268
    //   2164: iconst_m1
    //   2165: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2168: pop
    //   2169: aload_2
    //   2170: ldc_w 273
    //   2173: ldc_w 1422
    //   2176: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2179: pop
    //   2180: aload_0
    //   2181: aload_1
    //   2182: iconst_1
    //   2183: anewarray 201	java/lang/String
    //   2186: dup
    //   2187: iconst_0
    //   2188: aload_2
    //   2189: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2192: aastore
    //   2193: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2196: goto -147 -> 2049
    //   2199: astore_1
    //   2200: aload_1
    //   2201: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2204: goto -155 -> 2049
    //   2207: aload_3
    //   2208: invokevirtual 1060	java/io/File:length	()J
    //   2211: ldc2_w 1427
    //   2214: lcmp
    //   2215: ifle +58 -> 2273
    //   2218: new 265	org/json/JSONObject
    //   2221: dup
    //   2222: invokespecial 266	org/json/JSONObject:<init>	()V
    //   2225: astore_2
    //   2226: aload_2
    //   2227: ldc_w 268
    //   2230: iconst_m1
    //   2231: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2234: pop
    //   2235: aload_2
    //   2236: ldc_w 273
    //   2239: ldc_w 1430
    //   2242: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2245: pop
    //   2246: aload_0
    //   2247: aload_1
    //   2248: iconst_1
    //   2249: anewarray 201	java/lang/String
    //   2252: dup
    //   2253: iconst_0
    //   2254: aload_2
    //   2255: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2258: aastore
    //   2259: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2262: goto -213 -> 2049
    //   2265: astore_3
    //   2266: aload_3
    //   2267: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2270: goto -24 -> 2246
    //   2273: aload_0
    //   2274: iload 6
    //   2276: aload_2
    //   2277: iconst_0
    //   2278: aload_1
    //   2279: invokevirtual 1124	sfk:a	(ILjava/lang/String;ZLjava/lang/String;)V
    //   2282: goto -233 -> 2049
    //   2285: ldc_w 1432
    //   2288: aload 4
    //   2290: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2293: ifeq +167 -> 2460
    //   2296: aload 5
    //   2298: ifnull +10859 -> 13157
    //   2301: aload 5
    //   2303: arraylength
    //   2304: ifle +10853 -> 13157
    //   2307: new 265	org/json/JSONObject
    //   2310: dup
    //   2311: aload 5
    //   2313: iconst_0
    //   2314: aaload
    //   2315: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2318: astore_2
    //   2319: aload_2
    //   2320: ldc_w 415
    //   2323: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2326: astore_1
    //   2327: aload_2
    //   2328: ldc_w 1412
    //   2331: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2334: astore_3
    //   2335: aload_2
    //   2336: ldc_w 1391
    //   2339: iconst_1
    //   2340: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2343: istore 6
    //   2345: aload_3
    //   2346: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2349: istore 13
    //   2351: iload 13
    //   2353: ifeq +95 -> 2448
    //   2356: new 265	org/json/JSONObject
    //   2359: dup
    //   2360: invokespecial 266	org/json/JSONObject:<init>	()V
    //   2363: astore_2
    //   2364: aload_2
    //   2365: ldc_w 268
    //   2368: iconst_m1
    //   2369: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2372: pop
    //   2373: aload_2
    //   2374: ldc_w 273
    //   2377: ldc_w 1434
    //   2380: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2383: pop
    //   2384: aload_0
    //   2385: aload_1
    //   2386: iconst_1
    //   2387: anewarray 201	java/lang/String
    //   2390: dup
    //   2391: iconst_0
    //   2392: aload_2
    //   2393: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2396: aastore
    //   2397: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2400: aconst_null
    //   2401: ldc_w 639
    //   2404: ldc_w 641
    //   2407: ldc 163
    //   2409: ldc_w 1436
    //   2412: ldc_w 1436
    //   2415: iconst_0
    //   2416: iconst_2
    //   2417: ldc_w 656
    //   2420: ldc 163
    //   2422: ldc 163
    //   2424: ldc 163
    //   2426: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2429: goto +10728 -> 13157
    //   2432: astore_1
    //   2433: aload_1
    //   2434: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2437: goto -37 -> 2400
    //   2440: astore_1
    //   2441: aload_1
    //   2442: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2445: goto +10712 -> 13157
    //   2448: aload_0
    //   2449: aload_3
    //   2450: iload 6
    //   2452: iconst_0
    //   2453: aload_1
    //   2454: invokevirtual 1278	sfk:a	(Ljava/lang/String;IZLjava/lang/String;)V
    //   2457: goto -57 -> 2400
    //   2460: ldc_w 1438
    //   2463: aload 4
    //   2465: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2468: ifeq +239 -> 2707
    //   2471: aload 5
    //   2473: ifnull +10693 -> 13166
    //   2476: aload 5
    //   2478: arraylength
    //   2479: ifle +10687 -> 13166
    //   2482: new 265	org/json/JSONObject
    //   2485: dup
    //   2486: aload 5
    //   2488: iconst_0
    //   2489: aaload
    //   2490: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2493: astore_3
    //   2494: aload_3
    //   2495: ldc_w 415
    //   2498: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2501: astore_1
    //   2502: aload_3
    //   2503: ldc_w 1440
    //   2506: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2509: istore 8
    //   2511: iload 8
    //   2513: bipush 9
    //   2515: if_icmpgt +10644 -> 13159
    //   2518: iload 8
    //   2520: iconst_1
    //   2521: if_icmpge +10631 -> 13152
    //   2524: goto +10635 -> 13159
    //   2527: aload_3
    //   2528: ldc_w 1442
    //   2531: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2534: astore_2
    //   2535: aload_3
    //   2536: ldc_w 1444
    //   2539: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2542: astore_3
    //   2543: aload_3
    //   2544: ifnull +10602 -> 13146
    //   2547: aload_3
    //   2548: invokevirtual 429	org/json/JSONArray:length	()I
    //   2551: iconst_1
    //   2552: if_icmpne +10594 -> 13146
    //   2555: aload_3
    //   2556: iconst_0
    //   2557: invokevirtual 1353	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2560: astore_3
    //   2561: ldc_w 1446
    //   2564: aload_3
    //   2565: invokevirtual 1449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2568: ifeq +91 -> 2659
    //   2571: iconst_1
    //   2572: istore 6
    //   2574: iconst_0
    //   2575: istore 9
    //   2577: iload 9
    //   2579: istore 7
    //   2581: aload_2
    //   2582: ifnull +34 -> 2616
    //   2585: iload 9
    //   2587: istore 7
    //   2589: aload_2
    //   2590: invokevirtual 429	org/json/JSONArray:length	()I
    //   2593: iconst_1
    //   2594: if_icmpne +22 -> 2616
    //   2597: aload_2
    //   2598: iconst_0
    //   2599: invokevirtual 1353	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   2602: astore_2
    //   2603: ldc_w 1451
    //   2606: aload_2
    //   2607: invokevirtual 1449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2610: ifeq +65 -> 2675
    //   2613: iconst_1
    //   2614: istore 7
    //   2616: aload_0
    //   2617: iload 6
    //   2619: iload 7
    //   2621: aload_1
    //   2622: iload 8
    //   2624: invokevirtual 1453	sfk:a	(IILjava/lang/String;I)V
    //   2627: aconst_null
    //   2628: ldc_w 639
    //   2631: ldc_w 641
    //   2634: ldc 163
    //   2636: ldc_w 1455
    //   2639: ldc_w 1455
    //   2642: iconst_0
    //   2643: iconst_2
    //   2644: ldc_w 656
    //   2647: ldc 163
    //   2649: ldc 163
    //   2651: ldc 163
    //   2653: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2656: goto +10510 -> 13166
    //   2659: ldc_w 1457
    //   2662: aload_3
    //   2663: invokevirtual 1449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2666: ifeq +10480 -> 13146
    //   2669: iconst_2
    //   2670: istore 6
    //   2672: goto -98 -> 2574
    //   2675: ldc_w 1459
    //   2678: aload_2
    //   2679: invokevirtual 1449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2682: istore 13
    //   2684: iload 9
    //   2686: istore 7
    //   2688: iload 13
    //   2690: ifeq -74 -> 2616
    //   2693: iconst_2
    //   2694: istore 7
    //   2696: goto -80 -> 2616
    //   2699: astore_1
    //   2700: aload_1
    //   2701: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2704: goto +10462 -> 13166
    //   2707: ldc_w 1461
    //   2710: aload 4
    //   2712: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2715: ifeq +119 -> 2834
    //   2718: aload 5
    //   2720: ifnull +104 -> 2824
    //   2723: aload 5
    //   2725: arraylength
    //   2726: ifle +98 -> 2824
    //   2729: new 265	org/json/JSONObject
    //   2732: dup
    //   2733: aload 5
    //   2735: iconst_0
    //   2736: aaload
    //   2737: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2740: ldc_w 415
    //   2743: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2746: putstatic 1463	sfk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2749: getstatic 1463	sfk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2752: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2755: ifne +40 -> 2795
    //   2758: aload_0
    //   2759: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2762: ifnonnull +26 -> 2788
    //   2765: aload_0
    //   2766: new 1210	sfh
    //   2769: dup
    //   2770: aload_0
    //   2771: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   2774: aload_0
    //   2775: getfield 1211	sfk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2778: aload_0
    //   2779: getfield 361	sfk:mRuntime	Lbcdp;
    //   2782: invokespecial 1214	sfh:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbcdp;)V
    //   2785: putfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2788: aload_0
    //   2789: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2792: invokevirtual 1464	sfh:b	()V
    //   2795: aconst_null
    //   2796: ldc_w 639
    //   2799: ldc_w 641
    //   2802: ldc 163
    //   2804: ldc_w 1466
    //   2807: ldc_w 1466
    //   2810: iconst_0
    //   2811: iconst_2
    //   2812: ldc_w 656
    //   2815: ldc 163
    //   2817: ldc 163
    //   2819: ldc 163
    //   2821: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2824: iconst_1
    //   2825: ireturn
    //   2826: astore_1
    //   2827: aload_1
    //   2828: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2831: goto -7 -> 2824
    //   2834: ldc_w 1468
    //   2837: aload 4
    //   2839: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   2842: ifeq +154 -> 2996
    //   2845: aload 5
    //   2847: ifnull +82 -> 2929
    //   2850: aload 5
    //   2852: arraylength
    //   2853: ifle +76 -> 2929
    //   2856: new 265	org/json/JSONObject
    //   2859: dup
    //   2860: aload 5
    //   2862: iconst_0
    //   2863: aaload
    //   2864: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2867: ldc_w 415
    //   2870: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2873: putstatic 1470	sfk:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2876: aload_0
    //   2877: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2880: ifnull +51 -> 2931
    //   2883: aload_0
    //   2884: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2887: invokevirtual 1472	sfh:a	()Z
    //   2890: ifeq +41 -> 2931
    //   2893: aload_0
    //   2894: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   2897: invokevirtual 1473	sfh:c	()V
    //   2900: aconst_null
    //   2901: ldc_w 639
    //   2904: ldc_w 641
    //   2907: ldc 163
    //   2909: ldc_w 1475
    //   2912: ldc_w 1475
    //   2915: iconst_0
    //   2916: iconst_2
    //   2917: ldc_w 656
    //   2920: ldc 163
    //   2922: ldc 163
    //   2924: ldc 163
    //   2926: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2929: iconst_1
    //   2930: ireturn
    //   2931: new 265	org/json/JSONObject
    //   2934: dup
    //   2935: invokespecial 266	org/json/JSONObject:<init>	()V
    //   2938: astore_1
    //   2939: aload_1
    //   2940: ldc_w 268
    //   2943: iconst_m1
    //   2944: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2947: pop
    //   2948: aload_1
    //   2949: ldc_w 273
    //   2952: ldc_w 1477
    //   2955: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2958: pop
    //   2959: aload_0
    //   2960: getstatic 1470	sfk:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2963: iconst_1
    //   2964: anewarray 201	java/lang/String
    //   2967: dup
    //   2968: iconst_0
    //   2969: aload_1
    //   2970: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2973: aastore
    //   2974: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2977: goto -77 -> 2900
    //   2980: astore_1
    //   2981: aload_1
    //   2982: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2985: goto -85 -> 2900
    //   2988: astore_1
    //   2989: aload_1
    //   2990: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   2993: goto -64 -> 2929
    //   2996: ldc_w 1479
    //   2999: aload 4
    //   3001: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3004: ifeq +380 -> 3384
    //   3007: aload 5
    //   3009: ifnull +10159 -> 13168
    //   3012: aload 5
    //   3014: arraylength
    //   3015: ifle +10153 -> 13168
    //   3018: new 265	org/json/JSONObject
    //   3021: dup
    //   3022: aload 5
    //   3024: iconst_0
    //   3025: aaload
    //   3026: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3029: astore_1
    //   3030: aload_1
    //   3031: ldc_w 415
    //   3034: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3037: putstatic 1481	sfk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3040: aload_1
    //   3041: ldc_w 1389
    //   3044: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3047: astore_1
    //   3048: getstatic 1481	sfk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3051: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3054: ifne +165 -> 3219
    //   3057: aload_1
    //   3058: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3061: ifne +266 -> 3327
    //   3064: aload_0
    //   3065: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3068: ifnull +15 -> 3083
    //   3071: aload_0
    //   3072: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3075: invokevirtual 1483	sfh:b	()Z
    //   3078: ifeq +5 -> 3083
    //   3081: iconst_1
    //   3082: ireturn
    //   3083: aload_0
    //   3084: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3087: ifnonnull +26 -> 3113
    //   3090: aload_0
    //   3091: new 1210	sfh
    //   3094: dup
    //   3095: aload_0
    //   3096: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3099: aload_0
    //   3100: getfield 1211	sfk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3103: aload_0
    //   3104: getfield 361	sfk:mRuntime	Lbcdp;
    //   3107: invokespecial 1214	sfh:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbcdp;)V
    //   3110: putfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3113: aload_0
    //   3114: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3117: aload_1
    //   3118: invokevirtual 1426	sfh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3121: astore_2
    //   3122: new 265	org/json/JSONObject
    //   3125: dup
    //   3126: invokespecial 266	org/json/JSONObject:<init>	()V
    //   3129: astore_1
    //   3130: new 1056	java/io/File
    //   3133: dup
    //   3134: aload_2
    //   3135: invokespecial 1057	java/io/File:<init>	(Ljava/lang/String;)V
    //   3138: invokevirtual 1394	java/io/File:exists	()Z
    //   3141: ifeq +126 -> 3267
    //   3144: aload_0
    //   3145: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3148: aload_2
    //   3149: invokevirtual 1484	sfh:b	(Ljava/lang/String;)V
    //   3152: aload_1
    //   3153: ldc_w 268
    //   3156: iconst_0
    //   3157: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3160: pop
    //   3161: aload_1
    //   3162: ldc_w 273
    //   3165: ldc_w 1486
    //   3168: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3171: pop
    //   3172: aconst_null
    //   3173: ldc_w 639
    //   3176: ldc_w 641
    //   3179: ldc 163
    //   3181: ldc_w 1488
    //   3184: ldc_w 1488
    //   3187: iconst_0
    //   3188: iconst_0
    //   3189: ldc_w 656
    //   3192: ldc 163
    //   3194: ldc 163
    //   3196: ldc 163
    //   3198: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3201: aload_0
    //   3202: getstatic 1481	sfk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3205: iconst_1
    //   3206: anewarray 201	java/lang/String
    //   3209: dup
    //   3210: iconst_0
    //   3211: aload_1
    //   3212: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3215: aastore
    //   3216: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3219: aconst_null
    //   3220: ldc_w 639
    //   3223: ldc_w 641
    //   3226: ldc 163
    //   3228: ldc_w 1488
    //   3231: ldc_w 1488
    //   3234: iconst_0
    //   3235: iconst_2
    //   3236: ldc_w 656
    //   3239: ldc 163
    //   3241: ldc 163
    //   3243: ldc 163
    //   3245: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3248: goto +9920 -> 13168
    //   3251: astore_2
    //   3252: aload_2
    //   3253: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3256: goto -84 -> 3172
    //   3259: astore_1
    //   3260: aload_1
    //   3261: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3264: goto +9904 -> 13168
    //   3267: aload_1
    //   3268: ldc_w 268
    //   3271: iconst_m1
    //   3272: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3275: pop
    //   3276: aload_1
    //   3277: ldc_w 273
    //   3280: ldc_w 1422
    //   3283: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3286: pop
    //   3287: aconst_null
    //   3288: ldc_w 639
    //   3291: ldc_w 641
    //   3294: ldc 163
    //   3296: ldc_w 1488
    //   3299: ldc_w 1488
    //   3302: iconst_0
    //   3303: iconst_m1
    //   3304: ldc_w 656
    //   3307: ldc 163
    //   3309: ldc 163
    //   3311: ldc 163
    //   3313: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3316: goto -115 -> 3201
    //   3319: astore_2
    //   3320: aload_2
    //   3321: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3324: goto -37 -> 3287
    //   3327: new 265	org/json/JSONObject
    //   3330: dup
    //   3331: invokespecial 266	org/json/JSONObject:<init>	()V
    //   3334: astore_1
    //   3335: aload_1
    //   3336: ldc_w 268
    //   3339: iconst_m1
    //   3340: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3343: pop
    //   3344: aload_1
    //   3345: ldc_w 273
    //   3348: ldc_w 1490
    //   3351: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3354: pop
    //   3355: aload_0
    //   3356: getstatic 1481	sfk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3359: iconst_1
    //   3360: anewarray 201	java/lang/String
    //   3363: dup
    //   3364: iconst_0
    //   3365: aload_1
    //   3366: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3369: aastore
    //   3370: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3373: goto -154 -> 3219
    //   3376: astore_1
    //   3377: aload_1
    //   3378: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3381: goto -162 -> 3219
    //   3384: ldc_w 1492
    //   3387: aload 4
    //   3389: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3392: ifeq +226 -> 3618
    //   3395: aload 5
    //   3397: ifnull +9773 -> 13170
    //   3400: aload 5
    //   3402: arraylength
    //   3403: ifle +9767 -> 13170
    //   3406: new 265	org/json/JSONObject
    //   3409: dup
    //   3410: aload 5
    //   3412: iconst_0
    //   3413: aaload
    //   3414: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3417: astore_2
    //   3418: aload_2
    //   3419: ldc_w 415
    //   3422: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3425: astore_1
    //   3426: aload_2
    //   3427: ldc_w 1389
    //   3430: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3433: astore_2
    //   3434: aload_2
    //   3435: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3438: ifne +132 -> 3570
    //   3441: aload_0
    //   3442: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3445: ifnonnull +26 -> 3471
    //   3448: aload_0
    //   3449: new 1210	sfh
    //   3452: dup
    //   3453: aload_0
    //   3454: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3457: aload_0
    //   3458: getfield 1211	sfk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3461: aload_0
    //   3462: getfield 361	sfk:mRuntime	Lbcdp;
    //   3465: invokespecial 1214	sfh:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbcdp;)V
    //   3468: putfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3471: aload_0
    //   3472: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3475: aload_2
    //   3476: invokevirtual 1426	sfh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3479: pop
    //   3480: aload_0
    //   3481: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3484: invokevirtual 1483	sfh:b	()Z
    //   3487: ifeq +83 -> 3570
    //   3490: aload_0
    //   3491: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3494: invokevirtual 1493	sfh:g	()V
    //   3497: new 265	org/json/JSONObject
    //   3500: dup
    //   3501: invokespecial 266	org/json/JSONObject:<init>	()V
    //   3504: astore_2
    //   3505: aload_2
    //   3506: ldc_w 268
    //   3509: iconst_0
    //   3510: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3513: pop
    //   3514: aload_2
    //   3515: ldc_w 273
    //   3518: ldc_w 1486
    //   3521: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   3524: pop
    //   3525: aload_0
    //   3526: aload_1
    //   3527: iconst_1
    //   3528: anewarray 201	java/lang/String
    //   3531: dup
    //   3532: iconst_0
    //   3533: aload_2
    //   3534: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3537: aastore
    //   3538: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3541: aconst_null
    //   3542: ldc_w 639
    //   3545: ldc_w 641
    //   3548: ldc 163
    //   3550: ldc_w 1495
    //   3553: ldc_w 1495
    //   3556: iconst_0
    //   3557: iconst_0
    //   3558: ldc_w 656
    //   3561: ldc 163
    //   3563: ldc 163
    //   3565: ldc 163
    //   3567: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3570: aconst_null
    //   3571: ldc_w 639
    //   3574: ldc_w 641
    //   3577: ldc 163
    //   3579: ldc_w 1495
    //   3582: ldc_w 1495
    //   3585: iconst_0
    //   3586: iconst_2
    //   3587: ldc_w 656
    //   3590: ldc 163
    //   3592: ldc 163
    //   3594: ldc 163
    //   3596: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3599: goto +9571 -> 13170
    //   3602: astore_1
    //   3603: aload_1
    //   3604: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3607: goto -66 -> 3541
    //   3610: astore_1
    //   3611: aload_1
    //   3612: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3615: goto +9555 -> 13170
    //   3618: ldc_w 1497
    //   3621: aload 4
    //   3623: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3626: ifeq +165 -> 3791
    //   3629: aload 5
    //   3631: ifnull +150 -> 3781
    //   3634: aload 5
    //   3636: arraylength
    //   3637: ifle +144 -> 3781
    //   3640: new 265	org/json/JSONObject
    //   3643: dup
    //   3644: aload 5
    //   3646: iconst_0
    //   3647: aaload
    //   3648: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3651: astore_1
    //   3652: aload_1
    //   3653: ldc_w 415
    //   3656: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3659: putstatic 1499	sfk:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   3662: aload_1
    //   3663: ldc_w 1389
    //   3666: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3669: astore_1
    //   3670: aload_1
    //   3671: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3674: ifne +78 -> 3752
    //   3677: aload_0
    //   3678: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3681: ifnonnull +26 -> 3707
    //   3684: aload_0
    //   3685: new 1210	sfh
    //   3688: dup
    //   3689: aload_0
    //   3690: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3693: aload_0
    //   3694: getfield 1211	sfk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3697: aload_0
    //   3698: getfield 361	sfk:mRuntime	Lbcdp;
    //   3701: invokespecial 1214	sfh:<init>	(Landroid/app/Activity;Ljava/lang/String;Lbcdp;)V
    //   3704: putfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3707: aload_0
    //   3708: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3711: aload_1
    //   3712: invokevirtual 1426	sfh:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3715: pop
    //   3716: aload_0
    //   3717: getfield 1208	sfk:jdField_a_of_type_Sfh	Lsfh;
    //   3720: invokevirtual 1500	sfh:e	()V
    //   3723: aconst_null
    //   3724: ldc_w 639
    //   3727: ldc_w 641
    //   3730: ldc 163
    //   3732: ldc_w 1502
    //   3735: ldc_w 1502
    //   3738: iconst_0
    //   3739: iconst_0
    //   3740: ldc_w 656
    //   3743: ldc 163
    //   3745: ldc 163
    //   3747: ldc 163
    //   3749: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3752: aconst_null
    //   3753: ldc_w 639
    //   3756: ldc_w 641
    //   3759: ldc 163
    //   3761: ldc_w 1502
    //   3764: ldc_w 1502
    //   3767: iconst_0
    //   3768: iconst_2
    //   3769: ldc_w 656
    //   3772: ldc 163
    //   3774: ldc 163
    //   3776: ldc 163
    //   3778: invokestatic 648	axqy:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3781: iconst_1
    //   3782: ireturn
    //   3783: astore_1
    //   3784: aload_1
    //   3785: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3788: goto -7 -> 3781
    //   3791: ldc_w 1504
    //   3794: aload 4
    //   3796: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3799: ifeq +44 -> 3843
    //   3802: aload 5
    //   3804: ifnull +29 -> 3833
    //   3807: aload 5
    //   3809: arraylength
    //   3810: ifle +23 -> 3833
    //   3813: new 265	org/json/JSONObject
    //   3816: dup
    //   3817: aload 5
    //   3819: iconst_0
    //   3820: aaload
    //   3821: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3824: ldc_w 415
    //   3827: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3830: putstatic 1506	sfk:g	Ljava/lang/String;
    //   3833: iconst_1
    //   3834: ireturn
    //   3835: astore_1
    //   3836: aload_1
    //   3837: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3840: goto -7 -> 3833
    //   3843: ldc_w 1508
    //   3846: aload 4
    //   3848: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3851: ifeq +44 -> 3895
    //   3854: aload 5
    //   3856: ifnull +29 -> 3885
    //   3859: aload 5
    //   3861: arraylength
    //   3862: ifle +23 -> 3885
    //   3865: new 265	org/json/JSONObject
    //   3868: dup
    //   3869: aload 5
    //   3871: iconst_0
    //   3872: aaload
    //   3873: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3876: ldc_w 415
    //   3879: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3882: putstatic 1510	sfk:h	Ljava/lang/String;
    //   3885: iconst_1
    //   3886: ireturn
    //   3887: astore_1
    //   3888: aload_1
    //   3889: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   3892: goto -7 -> 3885
    //   3895: ldc_w 1512
    //   3898: aload 4
    //   3900: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   3903: ifeq +171 -> 4074
    //   3906: aload 5
    //   3908: ifnull +144 -> 4052
    //   3911: aload 5
    //   3913: arraylength
    //   3914: ifle +138 -> 4052
    //   3917: new 265	org/json/JSONObject
    //   3920: dup
    //   3921: aload 5
    //   3923: iconst_0
    //   3924: aaload
    //   3925: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3928: astore_1
    //   3929: aload_1
    //   3930: ldc_w 415
    //   3933: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3936: putstatic 1514	sfk:i	Ljava/lang/String;
    //   3939: aload_1
    //   3940: ldc_w 952
    //   3943: iconst_1
    //   3944: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   3947: istore 10
    //   3949: sipush 640
    //   3952: istore 6
    //   3954: sipush 640
    //   3957: istore 7
    //   3959: sipush 640
    //   3962: istore 8
    //   3964: sipush 640
    //   3967: istore 9
    //   3969: aload_1
    //   3970: ldc_w 1516
    //   3973: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   3976: ifeq +26 -> 4002
    //   3979: aload_1
    //   3980: ldc_w 1516
    //   3983: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3986: istore 7
    //   3988: aload_0
    //   3989: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   3992: iload 7
    //   3994: iconst_2
    //   3995: idiv
    //   3996: i2f
    //   3997: invokestatic 1524	baxn:a	(Landroid/content/Context;F)I
    //   4000: istore 6
    //   4002: aload_1
    //   4003: ldc_w 1526
    //   4006: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   4009: ifeq +26 -> 4035
    //   4012: aload_1
    //   4013: ldc_w 1526
    //   4016: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4019: istore 9
    //   4021: aload_0
    //   4022: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4025: iload 9
    //   4027: iconst_2
    //   4028: idiv
    //   4029: i2f
    //   4030: invokestatic 1524	baxn:a	(Landroid/content/Context;F)I
    //   4033: istore 8
    //   4035: aload_0
    //   4036: iconst_1
    //   4037: iload 10
    //   4039: bipush 118
    //   4041: iload 6
    //   4043: iload 8
    //   4045: iload 7
    //   4047: iload 9
    //   4049: invokevirtual 1528	sfk:a	(IIBIIII)V
    //   4052: iconst_1
    //   4053: ireturn
    //   4054: astore_1
    //   4055: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4058: ifeq -6 -> 4052
    //   4061: ldc_w 386
    //   4064: iconst_2
    //   4065: ldc_w 1530
    //   4068: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4071: goto -19 -> 4052
    //   4074: ldc_w 1532
    //   4077: aload 4
    //   4079: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4082: ifeq +195 -> 4277
    //   4085: iconst_0
    //   4086: istore 14
    //   4088: iload 14
    //   4090: istore 13
    //   4092: aload 5
    //   4094: ifnull +142 -> 4236
    //   4097: iload 14
    //   4099: istore 13
    //   4101: aload 5
    //   4103: arraylength
    //   4104: ifle +132 -> 4236
    //   4107: invokestatic 1538	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4110: invokevirtual 1541	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   4113: invokevirtual 1545	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   4116: astore_1
    //   4117: new 265	org/json/JSONObject
    //   4120: dup
    //   4121: aload 5
    //   4123: iconst_0
    //   4124: aaload
    //   4125: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4128: astore_2
    //   4129: aload_2
    //   4130: ldc_w 415
    //   4133: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4136: putstatic 1547	sfk:j	Ljava/lang/String;
    //   4139: aload_2
    //   4140: ldc_w 952
    //   4143: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4146: istore 10
    //   4148: aload_1
    //   4149: getfield 1552	android/util/DisplayMetrics:widthPixels	I
    //   4152: ldc2_w 1553
    //   4155: invokestatic 1560	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4158: istore 6
    //   4160: aload_1
    //   4161: getfield 1552	android/util/DisplayMetrics:widthPixels	I
    //   4164: ldc2_w 1561
    //   4167: invokestatic 1560	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4170: istore 7
    //   4172: sipush 750
    //   4175: istore 8
    //   4177: sipush 416
    //   4180: istore 9
    //   4182: iload 10
    //   4184: iconst_1
    //   4185: if_icmpne +8987 -> 13172
    //   4188: aload_1
    //   4189: getfield 1552	android/util/DisplayMetrics:widthPixels	I
    //   4192: ldc2_w 1553
    //   4195: invokestatic 1560	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/Utils:rp2px	(ID)I
    //   4198: istore 7
    //   4200: sipush 160
    //   4203: istore 9
    //   4205: sipush 160
    //   4208: istore 8
    //   4210: iload 7
    //   4212: istore 6
    //   4214: goto +8958 -> 13172
    //   4217: aload_0
    //   4218: iconst_2
    //   4219: iconst_0
    //   4220: bipush 121
    //   4222: iload 6
    //   4224: iload 7
    //   4226: iload 8
    //   4228: iload 9
    //   4230: invokevirtual 1528	sfk:a	(IIBIIII)V
    //   4233: iconst_1
    //   4234: istore 13
    //   4236: ldc_w 386
    //   4239: iconst_1
    //   4240: new 388	java/lang/StringBuilder
    //   4243: dup
    //   4244: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   4247: ldc_w 1564
    //   4250: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4253: aload 5
    //   4255: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4258: ldc_w 1566
    //   4261: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4264: iload 13
    //   4266: invokevirtual 1569	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4269: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4272: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4275: iconst_1
    //   4276: ireturn
    //   4277: ldc_w 1571
    //   4280: aload 4
    //   4282: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4285: ifeq +198 -> 4483
    //   4288: aload_0
    //   4289: getfield 161	sfk:jdField_a_of_type_Boolean	Z
    //   4292: ifeq +5 -> 4297
    //   4295: iconst_1
    //   4296: ireturn
    //   4297: aload 5
    //   4299: ifnull +182 -> 4481
    //   4302: aload 5
    //   4304: arraylength
    //   4305: ifle +176 -> 4481
    //   4308: new 265	org/json/JSONObject
    //   4311: dup
    //   4312: aload 5
    //   4314: iconst_0
    //   4315: aaload
    //   4316: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4319: astore_2
    //   4320: aload_2
    //   4321: ldc_w 1573
    //   4324: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4327: putstatic 1575	sfk:l	Ljava/lang/String;
    //   4330: aload_2
    //   4331: ldc_w 1577
    //   4334: ldc_w 1579
    //   4337: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4340: pop
    //   4341: aload_0
    //   4342: getfield 361	sfk:mRuntime	Lbcdp;
    //   4345: invokevirtual 1582	bcdp:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   4348: astore_1
    //   4349: aload_1
    //   4350: ifnull +8785 -> 13135
    //   4353: aload_1
    //   4354: invokevirtual 1587	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   4357: astore_1
    //   4358: aload_2
    //   4359: ldc_w 1199
    //   4362: aload_1
    //   4363: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4366: pop
    //   4367: aload_2
    //   4368: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4371: astore_3
    //   4372: aload_0
    //   4373: aload_2
    //   4374: ldc_w 415
    //   4377: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4380: putfield 1589	sfk:m	Ljava/lang/String;
    //   4383: aload_2
    //   4384: ldc_w 1591
    //   4387: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   4390: astore_2
    //   4391: new 174	java/util/ArrayList
    //   4394: dup
    //   4395: invokespecial 175	java/util/ArrayList:<init>	()V
    //   4398: astore 4
    //   4400: aload_2
    //   4401: ifnull +41 -> 4442
    //   4404: aload 4
    //   4406: invokevirtual 1282	java/util/ArrayList:clear	()V
    //   4409: iconst_0
    //   4410: istore 6
    //   4412: iload 6
    //   4414: aload_2
    //   4415: invokevirtual 429	org/json/JSONArray:length	()I
    //   4418: if_icmpge +24 -> 4442
    //   4421: aload 4
    //   4423: aload_2
    //   4424: iload 6
    //   4426: invokevirtual 1353	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   4429: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4432: pop
    //   4433: iload 6
    //   4435: iconst_1
    //   4436: iadd
    //   4437: istore 6
    //   4439: goto -27 -> 4412
    //   4442: getstatic 128	sfk:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   4445: aload_1
    //   4446: invokeinterface 1126 2 0
    //   4451: pop
    //   4452: getstatic 130	sfk:jdField_b_of_type_JavaUtilMap	Ljava/util/Map;
    //   4455: aload_1
    //   4456: aload 4
    //   4458: invokeinterface 1592 3 0
    //   4463: pop
    //   4464: aload_1
    //   4465: ifnull +9 -> 4474
    //   4468: aload_0
    //   4469: aload_1
    //   4470: aload_3
    //   4471: invokevirtual 1593	sfk:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4474: iconst_1
    //   4475: ireturn
    //   4476: astore_1
    //   4477: aload_1
    //   4478: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   4481: iconst_0
    //   4482: ireturn
    //   4483: ldc_w 1595
    //   4486: aload 4
    //   4488: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4491: ifeq +133 -> 4624
    //   4494: new 265	org/json/JSONObject
    //   4497: dup
    //   4498: aload 5
    //   4500: iconst_0
    //   4501: aaload
    //   4502: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4505: astore_2
    //   4506: aload_2
    //   4507: ldc_w 415
    //   4510: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4513: astore_1
    //   4514: aload_2
    //   4515: ldc_w 1597
    //   4518: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   4521: istore 6
    //   4523: aload_0
    //   4524: getfield 361	sfk:mRuntime	Lbcdp;
    //   4527: invokevirtual 903	bcdp:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4530: ifnull +50 -> 4580
    //   4533: aload_0
    //   4534: getfield 361	sfk:mRuntime	Lbcdp;
    //   4537: invokevirtual 903	bcdp:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4540: getfield 1600	com/tencent/mobileqq/webview/swift/WebViewFragment:a	Lbcfx;
    //   4543: ifnull +37 -> 4580
    //   4546: aload_0
    //   4547: getfield 361	sfk:mRuntime	Lbcdp;
    //   4550: invokevirtual 903	bcdp:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4553: getfield 1600	com/tencent/mobileqq/webview/swift/WebViewFragment:a	Lbcfx;
    //   4556: getfield 1605	bcfx:a	Lbccj;
    //   4559: ifnull +21 -> 4580
    //   4562: aload_0
    //   4563: getfield 361	sfk:mRuntime	Lbcdp;
    //   4566: invokevirtual 903	bcdp:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   4569: getfield 1600	com/tencent/mobileqq/webview/swift/WebViewFragment:a	Lbcfx;
    //   4572: getfield 1605	bcfx:a	Lbccj;
    //   4575: iload 6
    //   4577: invokevirtual 1609	bccj:a	(I)V
    //   4580: new 265	org/json/JSONObject
    //   4583: dup
    //   4584: invokespecial 266	org/json/JSONObject:<init>	()V
    //   4587: astore_2
    //   4588: aload_2
    //   4589: ldc_w 268
    //   4592: iconst_0
    //   4593: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4596: pop
    //   4597: aload_0
    //   4598: aload_1
    //   4599: iconst_1
    //   4600: anewarray 201	java/lang/String
    //   4603: dup
    //   4604: iconst_0
    //   4605: aload_2
    //   4606: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4609: aastore
    //   4610: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4613: goto -132 -> 4481
    //   4616: astore_1
    //   4617: aload_1
    //   4618: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   4621: goto -140 -> 4481
    //   4624: ldc_w 1611
    //   4627: aload 4
    //   4629: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   4632: ifeq +367 -> 4999
    //   4635: aload 5
    //   4637: ifnull +352 -> 4989
    //   4640: aload 5
    //   4642: arraylength
    //   4643: ifle +346 -> 4989
    //   4646: new 265	org/json/JSONObject
    //   4649: dup
    //   4650: aload 5
    //   4652: iconst_0
    //   4653: aaload
    //   4654: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4657: astore_2
    //   4658: aload_2
    //   4659: ldc_w 415
    //   4662: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4665: astore_1
    //   4666: aload_2
    //   4667: ldc_w 1199
    //   4670: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4673: astore_3
    //   4674: aload_1
    //   4675: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4678: ifne +311 -> 4989
    //   4681: aload_3
    //   4682: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4685: ifne +304 -> 4989
    //   4688: new 265	org/json/JSONObject
    //   4691: dup
    //   4692: invokespecial 266	org/json/JSONObject:<init>	()V
    //   4695: astore_2
    //   4696: aload_2
    //   4697: ldc_w 268
    //   4700: iconst_0
    //   4701: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4704: pop
    //   4705: aload_2
    //   4706: ldc_w 273
    //   4709: ldc_w 1331
    //   4712: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4715: pop
    //   4716: iconst_0
    //   4717: istore 14
    //   4719: aload_3
    //   4720: invokestatic 1614	com/tencent/biz/pubaccount/util/PreloadManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4723: astore_3
    //   4724: iload 14
    //   4726: istore 13
    //   4728: aload_3
    //   4729: ifnull +27 -> 4756
    //   4732: iload 14
    //   4734: istore 13
    //   4736: new 1056	java/io/File
    //   4739: dup
    //   4740: getstatic 1617	ajsd:cG	Ljava/lang/String;
    //   4743: aload_3
    //   4744: invokespecial 1619	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   4747: invokevirtual 1394	java/io/File:exists	()Z
    //   4750: ifeq +6 -> 4756
    //   4753: iconst_1
    //   4754: istore 13
    //   4756: aload_2
    //   4757: ldc_w 1621
    //   4760: iload 13
    //   4762: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4765: pop
    //   4766: invokestatic 1628	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   4769: invokevirtual 1632	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   4772: astore_3
    //   4773: aload_3
    //   4774: ifnull +215 -> 4989
    //   4777: aload_3
    //   4778: ldc_w 1634
    //   4781: invokevirtual 1640	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   4784: checkcast 1187	com/tencent/common/app/AppInterface
    //   4787: astore_3
    //   4788: aload_3
    //   4789: ifnull +200 -> 4989
    //   4792: invokestatic 1538	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4795: new 388	java/lang/StringBuilder
    //   4798: dup
    //   4799: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   4802: ldc_w 1642
    //   4805: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4808: aload_3
    //   4809: invokevirtual 1645	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4812: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4815: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4818: iconst_4
    //   4819: invokevirtual 1649	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4822: astore_3
    //   4823: aload_3
    //   4824: ifnull +165 -> 4989
    //   4827: aload_3
    //   4828: ldc_w 1651
    //   4831: iconst_0
    //   4832: invokeinterface 1656 3 0
    //   4837: istore 13
    //   4839: aload_3
    //   4840: ldc_w 1658
    //   4843: iconst_0
    //   4844: invokeinterface 1656 3 0
    //   4849: istore 14
    //   4851: aload_3
    //   4852: ldc_w 1660
    //   4855: iconst_0
    //   4856: invokeinterface 1656 3 0
    //   4861: istore 15
    //   4863: aload_3
    //   4864: ldc_w 1662
    //   4867: iconst_0
    //   4868: invokeinterface 1656 3 0
    //   4873: istore 16
    //   4875: aload_3
    //   4876: ldc_w 1664
    //   4879: iconst_0
    //   4880: invokeinterface 1656 3 0
    //   4885: istore 17
    //   4887: aload_2
    //   4888: ldc_w 1666
    //   4891: iload 13
    //   4893: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4896: pop
    //   4897: aload_2
    //   4898: ldc_w 1668
    //   4901: iload 14
    //   4903: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4906: pop
    //   4907: aload_2
    //   4908: ldc_w 1670
    //   4911: iload 15
    //   4913: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4916: pop
    //   4917: aload_2
    //   4918: ldc_w 1672
    //   4921: iload 16
    //   4923: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4926: pop
    //   4927: aload_2
    //   4928: ldc_w 1674
    //   4931: iload 17
    //   4933: invokevirtual 1624	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   4936: pop
    //   4937: aload_0
    //   4938: aload_1
    //   4939: iconst_1
    //   4940: anewarray 201	java/lang/String
    //   4943: dup
    //   4944: iconst_0
    //   4945: aload_2
    //   4946: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4949: aastore
    //   4950: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4953: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4956: ifeq +33 -> 4989
    //   4959: ldc_w 386
    //   4962: iconst_2
    //   4963: new 388	java/lang/StringBuilder
    //   4966: dup
    //   4967: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   4970: ldc_w 1611
    //   4973: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4976: aload_2
    //   4977: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4980: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4983: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4986: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4989: iconst_1
    //   4990: ireturn
    //   4991: astore_1
    //   4992: aload_1
    //   4993: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   4996: goto -7 -> 4989
    //   4999: ldc_w 1676
    //   5002: aload 4
    //   5004: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5007: ifeq +79 -> 5086
    //   5010: aload_0
    //   5011: iconst_4
    //   5012: invokespecial 844	com/tencent/mobileqq/webview/swift/WebViewPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   5015: checkcast 846	bcfh
    //   5018: astore_1
    //   5019: aload_1
    //   5020: ifnull +48 -> 5068
    //   5023: aload_0
    //   5024: getfield 361	sfk:mRuntime	Lbcdp;
    //   5027: invokevirtual 903	bcdp:a	()Lcom/tencent/mobileqq/webview/swift/WebViewFragment;
    //   5030: astore_2
    //   5031: aload_2
    //   5032: ifnull +36 -> 5068
    //   5035: aload_2
    //   5036: invokevirtual 1279	com/tencent/mobileqq/webview/swift/WebViewFragment:c	()V
    //   5039: aload_1
    //   5040: getfield 1679	bcfh:jdField_a_of_type_Bbjq	Lbbjq;
    //   5043: ifnull +25 -> 5068
    //   5046: aload_1
    //   5047: getfield 1679	bcfh:jdField_a_of_type_Bbjq	Lbbjq;
    //   5050: getfield 1684	bbjq:b	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5053: ifnull +15 -> 5068
    //   5056: aload_1
    //   5057: getfield 1679	bcfh:jdField_a_of_type_Bbjq	Lbbjq;
    //   5060: getfield 1684	bbjq:b	Lcom/tencent/biz/widgets/ElasticHorScrView;
    //   5063: bipush 8
    //   5065: invokevirtual 1687	com/tencent/biz/widgets/ElasticHorScrView:setVisibility	(I)V
    //   5068: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5071: ifeq +13 -> 5084
    //   5074: ldc_w 386
    //   5077: iconst_2
    //   5078: ldc_w 1676
    //   5081: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5084: iconst_1
    //   5085: ireturn
    //   5086: ldc_w 1689
    //   5089: aload 4
    //   5091: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5094: ifeq +143 -> 5237
    //   5097: new 265	org/json/JSONObject
    //   5100: dup
    //   5101: invokespecial 266	org/json/JSONObject:<init>	()V
    //   5104: astore_3
    //   5105: invokestatic 1692	odo:a	()I
    //   5108: iconst_1
    //   5109: if_icmpne +8080 -> 13189
    //   5112: ldc_w 1694
    //   5115: astore_1
    //   5116: invokestatic 1695	odo:b	()I
    //   5119: iconst_1
    //   5120: if_icmpne +8076 -> 13196
    //   5123: ldc_w 1694
    //   5126: astore_2
    //   5127: aload_3
    //   5128: ldc_w 268
    //   5131: iconst_0
    //   5132: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   5135: pop
    //   5136: aload_3
    //   5137: ldc_w 1697
    //   5140: aload_1
    //   5141: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5144: pop
    //   5145: aload_3
    //   5146: ldc_w 1699
    //   5149: aload_2
    //   5150: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5153: pop
    //   5154: aload 5
    //   5156: ifnull +53 -> 5209
    //   5159: aload 5
    //   5161: arraylength
    //   5162: ifle +47 -> 5209
    //   5165: new 265	org/json/JSONObject
    //   5168: dup
    //   5169: aload 5
    //   5171: iconst_0
    //   5172: aaload
    //   5173: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5176: ldc_w 415
    //   5179: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5182: astore_1
    //   5183: aload_1
    //   5184: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5187: ifne +8000 -> 13187
    //   5190: aload_0
    //   5191: aload_1
    //   5192: iconst_1
    //   5193: anewarray 201	java/lang/String
    //   5196: dup
    //   5197: iconst_0
    //   5198: aload_3
    //   5199: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5202: aastore
    //   5203: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5206: goto +7981 -> 13187
    //   5209: ldc_w 386
    //   5212: iconst_1
    //   5213: ldc_w 1701
    //   5216: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5219: goto +7968 -> 13187
    //   5222: astore_1
    //   5223: ldc_w 386
    //   5226: iconst_1
    //   5227: ldc_w 1703
    //   5230: aload_1
    //   5231: invokestatic 1706	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5234: goto +7953 -> 13187
    //   5237: ldc_w 1708
    //   5240: aload 4
    //   5242: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5245: ifeq +136 -> 5381
    //   5248: aload 5
    //   5250: ifnull +102 -> 5352
    //   5253: aload 5
    //   5255: arraylength
    //   5256: ifle +96 -> 5352
    //   5259: new 265	org/json/JSONObject
    //   5262: dup
    //   5263: aload 5
    //   5265: iconst_0
    //   5266: aaload
    //   5267: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5270: astore_1
    //   5271: aload_1
    //   5272: ldc_w 415
    //   5275: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5278: astore_2
    //   5279: aload_2
    //   5280: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5283: ifne +25 -> 5308
    //   5286: aload_0
    //   5287: aload_2
    //   5288: iconst_1
    //   5289: anewarray 201	java/lang/String
    //   5292: dup
    //   5293: iconst_0
    //   5294: aload_0
    //   5295: getfield 361	sfk:mRuntime	Lbcdp;
    //   5298: invokevirtual 1711	bcdp:a	()Lcom/tencent/common/app/AppInterface;
    //   5301: invokestatic 1716	olg:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   5304: aastore
    //   5305: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5308: new 388	java/lang/StringBuilder
    //   5311: dup
    //   5312: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5315: ldc 163
    //   5317: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5320: aload_1
    //   5321: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5324: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5327: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5330: astore_1
    //   5331: ldc_w 386
    //   5334: iconst_1
    //   5335: iconst_2
    //   5336: anewarray 713	java/lang/Object
    //   5339: dup
    //   5340: iconst_0
    //   5341: ldc_w 1703
    //   5344: aastore
    //   5345: dup
    //   5346: iconst_1
    //   5347: aload_1
    //   5348: aastore
    //   5349: invokestatic 722	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5352: iconst_1
    //   5353: ireturn
    //   5354: astore_1
    //   5355: new 388	java/lang/StringBuilder
    //   5358: dup
    //   5359: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5362: ldc 163
    //   5364: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5367: aload_1
    //   5368: invokevirtual 1717	org/json/JSONException:toString	()Ljava/lang/String;
    //   5371: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5374: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5377: astore_1
    //   5378: goto -47 -> 5331
    //   5381: ldc_w 1719
    //   5384: aload 4
    //   5386: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   5389: ifeq +138 -> 5527
    //   5392: aload 5
    //   5394: ifnull +104 -> 5498
    //   5397: aload 5
    //   5399: arraylength
    //   5400: ifle +98 -> 5498
    //   5403: new 265	org/json/JSONObject
    //   5406: dup
    //   5407: aload 5
    //   5409: iconst_0
    //   5410: aaload
    //   5411: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5414: astore_1
    //   5415: aload_1
    //   5416: ldc_w 415
    //   5419: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5422: astore_2
    //   5423: aload_1
    //   5424: ldc_w 1721
    //   5427: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5430: astore_3
    //   5431: aload_2
    //   5432: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5435: ifne +19 -> 5454
    //   5438: aload_0
    //   5439: aload_2
    //   5440: iconst_1
    //   5441: anewarray 201	java/lang/String
    //   5444: dup
    //   5445: iconst_0
    //   5446: aload_3
    //   5447: invokestatic 1724	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;)Ljava/lang/String;
    //   5450: aastore
    //   5451: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5454: new 388	java/lang/StringBuilder
    //   5457: dup
    //   5458: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5461: ldc 163
    //   5463: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: aload_1
    //   5467: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5470: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5473: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5476: astore_1
    //   5477: ldc_w 386
    //   5480: iconst_1
    //   5481: iconst_2
    //   5482: anewarray 713	java/lang/Object
    //   5485: dup
    //   5486: iconst_0
    //   5487: ldc_w 1703
    //   5490: aastore
    //   5491: dup
    //   5492: iconst_1
    //   5493: aload_1
    //   5494: aastore
    //   5495: invokestatic 722	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5498: iconst_1
    //   5499: ireturn
    //   5500: astore_1
    //   5501: new 388	java/lang/StringBuilder
    //   5504: dup
    //   5505: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5508: ldc 163
    //   5510: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5513: aload_1
    //   5514: invokevirtual 1725	java/lang/Exception:toString	()Ljava/lang/String;
    //   5517: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5520: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5523: astore_1
    //   5524: goto -47 -> 5477
    //   5527: ldc_w 1727
    //   5530: aload 4
    //   5532: invokevirtual 1449	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   5535: ifeq +138 -> 5673
    //   5538: aload 5
    //   5540: ifnull +101 -> 5641
    //   5543: aload 5
    //   5545: arraylength
    //   5546: ifle +95 -> 5641
    //   5549: new 265	org/json/JSONObject
    //   5552: dup
    //   5553: aload 5
    //   5555: iconst_0
    //   5556: aaload
    //   5557: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5560: astore_1
    //   5561: aload_1
    //   5562: ldc_w 415
    //   5565: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5568: astore_2
    //   5569: aload_1
    //   5570: ldc_w 1721
    //   5573: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5576: astore_3
    //   5577: aload_2
    //   5578: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5581: ifne +16 -> 5597
    //   5584: aload_2
    //   5585: aload_3
    //   5586: aload_0
    //   5587: getfield 361	sfk:mRuntime	Lbcdp;
    //   5590: iconst_0
    //   5591: invokestatic 1730	com/tencent/biz/pubaccount/util/Achilles:a	(Ljava/lang/String;Ljava/lang/String;Lbcdp;Z)Z
    //   5594: ifeq +49 -> 5643
    //   5597: new 388	java/lang/StringBuilder
    //   5600: dup
    //   5601: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5604: ldc 163
    //   5606: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5609: aload_1
    //   5610: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5613: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5616: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5619: astore_1
    //   5620: ldc_w 386
    //   5623: iconst_1
    //   5624: iconst_2
    //   5625: anewarray 713	java/lang/Object
    //   5628: dup
    //   5629: iconst_0
    //   5630: ldc_w 1703
    //   5633: aastore
    //   5634: dup
    //   5635: iconst_1
    //   5636: aload_1
    //   5637: aastore
    //   5638: invokestatic 722	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5641: iconst_1
    //   5642: ireturn
    //   5643: goto -46 -> 5597
    //   5646: astore_1
    //   5647: new 388	java/lang/StringBuilder
    //   5650: dup
    //   5651: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5654: ldc 163
    //   5656: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5659: aload_1
    //   5660: invokevirtual 1725	java/lang/Exception:toString	()Ljava/lang/String;
    //   5663: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5666: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5669: astore_1
    //   5670: goto -50 -> 5620
    //   5673: ldc_w 1732
    //   5676: aload 4
    //   5678: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5681: ifeq +2574 -> 8255
    //   5684: aload 5
    //   5686: ifnull -1205 -> 4481
    //   5689: aload 5
    //   5691: arraylength
    //   5692: ifle -1211 -> 4481
    //   5695: new 265	org/json/JSONObject
    //   5698: dup
    //   5699: aload 5
    //   5701: iconst_0
    //   5702: aaload
    //   5703: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5706: astore 43
    //   5708: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5711: ifeq +34 -> 5745
    //   5714: ldc_w 386
    //   5717: iconst_2
    //   5718: new 388	java/lang/StringBuilder
    //   5721: dup
    //   5722: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   5725: ldc_w 1734
    //   5728: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5731: aload 43
    //   5733: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5736: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5739: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5742: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5745: aload 43
    //   5747: ldc_w 492
    //   5750: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5753: astore 42
    //   5755: aload 43
    //   5757: ldc_w 494
    //   5760: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5763: astore_3
    //   5764: aload 43
    //   5766: ldc_w 1736
    //   5769: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5772: astore 41
    //   5774: aload 41
    //   5776: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5779: ifeq +7424 -> 13203
    //   5782: aload_2
    //   5783: astore 41
    //   5785: aload 43
    //   5787: ldc_w 1738
    //   5790: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   5793: istore 10
    //   5795: ldc 163
    //   5797: astore 5
    //   5799: iload 10
    //   5801: iconst_1
    //   5802: if_icmpne +24 -> 5826
    //   5805: new 201	java/lang/String
    //   5808: dup
    //   5809: aload 43
    //   5811: ldc_w 1740
    //   5814: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5817: iconst_2
    //   5818: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   5821: invokespecial 681	java/lang/String:<init>	([B)V
    //   5824: astore 5
    //   5826: lconst_0
    //   5827: lstore 18
    //   5829: lconst_0
    //   5830: lstore 22
    //   5832: lconst_0
    //   5833: lstore 24
    //   5835: lconst_0
    //   5836: lstore 36
    //   5838: lconst_0
    //   5839: lstore 38
    //   5841: ldc 163
    //   5843: astore 40
    //   5845: new 201	java/lang/String
    //   5848: dup
    //   5849: aload 42
    //   5851: iconst_0
    //   5852: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   5855: invokespecial 681	java/lang/String:<init>	([B)V
    //   5858: astore_1
    //   5859: new 201	java/lang/String
    //   5862: dup
    //   5863: aload_3
    //   5864: iconst_0
    //   5865: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   5868: invokespecial 681	java/lang/String:<init>	([B)V
    //   5871: astore_2
    //   5872: aload 43
    //   5874: ldc_w 1742
    //   5877: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5880: astore_3
    //   5881: aload 43
    //   5883: ldc_w 401
    //   5886: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5889: astore 4
    //   5891: aload 4
    //   5893: astore 40
    //   5895: lload 18
    //   5897: lstore 20
    //   5899: lload 38
    //   5901: lstore 34
    //   5903: lload 36
    //   5905: lstore 32
    //   5907: lload 24
    //   5909: lstore 30
    //   5911: lload 22
    //   5913: lstore 28
    //   5915: lload 18
    //   5917: lstore 26
    //   5919: aload_3
    //   5920: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5923: ifne +36 -> 5959
    //   5926: lload 38
    //   5928: lstore 34
    //   5930: lload 36
    //   5932: lstore 32
    //   5934: lload 24
    //   5936: lstore 30
    //   5938: lload 22
    //   5940: lstore 28
    //   5942: lload 18
    //   5944: lstore 26
    //   5946: new 1744	java/math/BigInteger
    //   5949: dup
    //   5950: aload_3
    //   5951: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   5954: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   5957: lstore 20
    //   5959: lload 38
    //   5961: lstore 34
    //   5963: lload 36
    //   5965: lstore 32
    //   5967: lload 24
    //   5969: lstore 30
    //   5971: lload 22
    //   5973: lstore 28
    //   5975: lload 20
    //   5977: lstore 26
    //   5979: aload 43
    //   5981: ldc_w 1750
    //   5984: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5987: astore 4
    //   5989: lload 22
    //   5991: lstore 18
    //   5993: lload 38
    //   5995: lstore 34
    //   5997: lload 36
    //   5999: lstore 32
    //   6001: lload 24
    //   6003: lstore 30
    //   6005: lload 22
    //   6007: lstore 28
    //   6009: lload 20
    //   6011: lstore 26
    //   6013: aload 4
    //   6015: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6018: ifne +37 -> 6055
    //   6021: lload 38
    //   6023: lstore 34
    //   6025: lload 36
    //   6027: lstore 32
    //   6029: lload 24
    //   6031: lstore 30
    //   6033: lload 22
    //   6035: lstore 28
    //   6037: lload 20
    //   6039: lstore 26
    //   6041: new 1744	java/math/BigInteger
    //   6044: dup
    //   6045: aload 4
    //   6047: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6050: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6053: lstore 18
    //   6055: lload 38
    //   6057: lstore 34
    //   6059: lload 36
    //   6061: lstore 32
    //   6063: lload 24
    //   6065: lstore 30
    //   6067: lload 18
    //   6069: lstore 28
    //   6071: lload 20
    //   6073: lstore 26
    //   6075: aload 43
    //   6077: ldc_w 1752
    //   6080: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6083: astore 4
    //   6085: lload 24
    //   6087: lstore 22
    //   6089: lload 38
    //   6091: lstore 34
    //   6093: lload 36
    //   6095: lstore 32
    //   6097: lload 24
    //   6099: lstore 30
    //   6101: lload 18
    //   6103: lstore 28
    //   6105: lload 20
    //   6107: lstore 26
    //   6109: aload 4
    //   6111: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6114: ifne +37 -> 6151
    //   6117: lload 38
    //   6119: lstore 34
    //   6121: lload 36
    //   6123: lstore 32
    //   6125: lload 24
    //   6127: lstore 30
    //   6129: lload 18
    //   6131: lstore 28
    //   6133: lload 20
    //   6135: lstore 26
    //   6137: new 1744	java/math/BigInteger
    //   6140: dup
    //   6141: aload 4
    //   6143: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6146: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6149: lstore 22
    //   6151: lload 38
    //   6153: lstore 34
    //   6155: lload 36
    //   6157: lstore 32
    //   6159: lload 22
    //   6161: lstore 30
    //   6163: lload 18
    //   6165: lstore 28
    //   6167: lload 20
    //   6169: lstore 26
    //   6171: aload 43
    //   6173: ldc_w 1754
    //   6176: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6179: astore 4
    //   6181: lload 36
    //   6183: lstore 24
    //   6185: lload 38
    //   6187: lstore 34
    //   6189: lload 36
    //   6191: lstore 32
    //   6193: lload 22
    //   6195: lstore 30
    //   6197: lload 18
    //   6199: lstore 28
    //   6201: lload 20
    //   6203: lstore 26
    //   6205: aload 4
    //   6207: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6210: ifne +37 -> 6247
    //   6213: lload 38
    //   6215: lstore 34
    //   6217: lload 36
    //   6219: lstore 32
    //   6221: lload 22
    //   6223: lstore 30
    //   6225: lload 18
    //   6227: lstore 28
    //   6229: lload 20
    //   6231: lstore 26
    //   6233: new 1744	java/math/BigInteger
    //   6236: dup
    //   6237: aload 4
    //   6239: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6242: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6245: lstore 24
    //   6247: lload 38
    //   6249: lstore 34
    //   6251: lload 24
    //   6253: lstore 32
    //   6255: lload 22
    //   6257: lstore 30
    //   6259: lload 18
    //   6261: lstore 28
    //   6263: lload 20
    //   6265: lstore 26
    //   6267: aload 43
    //   6269: ldc_w 1756
    //   6272: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6275: lstore 36
    //   6277: lload 36
    //   6279: lstore 34
    //   6281: lload 24
    //   6283: lstore 32
    //   6285: lload 22
    //   6287: lstore 30
    //   6289: lload 18
    //   6291: lstore 28
    //   6293: lload 20
    //   6295: lstore 26
    //   6297: aload 43
    //   6299: ldc_w 1758
    //   6302: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6305: istore 7
    //   6307: lload 24
    //   6309: lstore 32
    //   6311: aload_3
    //   6312: astore 42
    //   6314: aload 40
    //   6316: astore_3
    //   6317: lload 20
    //   6319: lstore 26
    //   6321: lload 22
    //   6323: lstore 24
    //   6325: lload 36
    //   6327: lstore 20
    //   6329: lload 18
    //   6331: lstore 22
    //   6333: aload_1
    //   6334: astore 4
    //   6336: aload 42
    //   6338: astore_1
    //   6339: lload 26
    //   6341: lstore 18
    //   6343: aload 43
    //   6345: ldc_w 1760
    //   6348: lconst_1
    //   6349: invokevirtual 504	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   6352: lstore 26
    //   6354: aload 43
    //   6356: ldc_w 952
    //   6359: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6362: istore 6
    //   6364: aload 43
    //   6366: ldc_w 1762
    //   6369: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6372: istore 9
    //   6374: aload 43
    //   6376: ldc_w 1764
    //   6379: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6382: astore 45
    //   6384: aload 43
    //   6386: ldc_w 498
    //   6389: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6392: istore 8
    //   6394: aload 43
    //   6396: ldc_w 415
    //   6399: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6402: astore 42
    //   6404: new 201	java/lang/String
    //   6407: dup
    //   6408: aload 43
    //   6410: ldc_w 1766
    //   6413: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6416: iconst_0
    //   6417: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   6420: invokespecial 681	java/lang/String:<init>	([B)V
    //   6423: astore 46
    //   6425: aload 43
    //   6427: ldc_w 488
    //   6430: iconst_1
    //   6431: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6434: istore 11
    //   6436: new 1768	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   6439: dup
    //   6440: invokespecial 1769	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   6443: astore 44
    //   6445: aload 44
    //   6447: lload 22
    //   6449: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   6452: aload 44
    //   6454: aload 4
    //   6456: putfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   6459: aload 44
    //   6461: aload_2
    //   6462: putfield 1779	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   6465: aload 44
    //   6467: aload 45
    //   6469: putfield 1782	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   6472: aload 44
    //   6474: iload 8
    //   6476: putfield 1785	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   6479: aload 44
    //   6481: lload 18
    //   6483: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   6486: aload 44
    //   6488: aload 46
    //   6490: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   6493: aload 44
    //   6495: lload 32
    //   6497: putfield 1793	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   6500: aload 44
    //   6502: iload 11
    //   6504: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   6507: aload 43
    //   6509: ldc_w 1798
    //   6512: invokevirtual 1801	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   6515: astore 40
    //   6517: aload 44
    //   6519: new 1803	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   6522: dup
    //   6523: invokespecial 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   6526: putfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6529: aload 44
    //   6531: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6534: new 1810	qcg
    //   6537: dup
    //   6538: invokespecial 1811	qcg:<init>	()V
    //   6541: putfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   6544: aload 44
    //   6546: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6549: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   6552: lload 24
    //   6554: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6557: putfield 1820	qcg:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   6560: aload 44
    //   6562: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6565: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   6568: lload 26
    //   6570: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6573: putfield 1822	qcg:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   6576: aload 44
    //   6578: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6581: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   6584: new 174	java/util/ArrayList
    //   6587: dup
    //   6588: invokespecial 175	java/util/ArrayList:<init>	()V
    //   6591: putfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6594: aload 40
    //   6596: ifnull +390 -> 6986
    //   6599: iconst_0
    //   6600: istore 8
    //   6602: iload 8
    //   6604: aload 40
    //   6606: invokevirtual 429	org/json/JSONArray:length	()I
    //   6609: if_icmpge +377 -> 6986
    //   6612: new 1827	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   6615: dup
    //   6616: invokespecial 1828	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   6619: astore 47
    //   6621: aload 40
    //   6623: iload 8
    //   6625: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   6628: astore 48
    //   6630: aload 47
    //   6632: aload 48
    //   6634: ldc_w 1260
    //   6637: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   6640: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6643: putfield 1833	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   6646: aload 47
    //   6648: new 201	java/lang/String
    //   6651: dup
    //   6652: aload 48
    //   6654: ldc_w 1835
    //   6657: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6660: iconst_0
    //   6661: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   6664: invokespecial 681	java/lang/String:<init>	([B)V
    //   6667: putfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6670: aload 47
    //   6672: aload 47
    //   6674: getfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6677: putfield 1837	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6680: aload 47
    //   6682: aload 48
    //   6684: ldc_w 1839
    //   6687: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6690: putfield 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   6693: aload 47
    //   6695: aload 48
    //   6697: ldc_w 694
    //   6700: iconst_1
    //   6701: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   6704: putfield 1841	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   6707: aload 47
    //   6709: aload 48
    //   6711: ldc_w 1843
    //   6714: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   6717: putfield 1844	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   6720: aload 48
    //   6722: ldc_w 1846
    //   6725: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6728: astore 49
    //   6730: aload 48
    //   6732: ldc_w 1848
    //   6735: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6738: astore 50
    //   6740: aload 49
    //   6742: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6745: ifne +39 -> 6784
    //   6748: aload 50
    //   6750: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6753: ifne +31 -> 6784
    //   6756: aload 47
    //   6758: new 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   6761: dup
    //   6762: lconst_0
    //   6763: new 201	java/lang/String
    //   6766: dup
    //   6767: aload 49
    //   6769: iconst_0
    //   6770: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   6773: invokespecial 681	java/lang/String:<init>	([B)V
    //   6776: aload 50
    //   6778: invokespecial 1853	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   6781: putfield 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   6784: iload 10
    //   6786: iconst_1
    //   6787: if_icmpne +3 -> 6790
    //   6790: aload 48
    //   6792: ldc_w 1742
    //   6795: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   6798: astore 48
    //   6800: aload 48
    //   6802: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6805: ifne +23 -> 6828
    //   6808: aload 47
    //   6810: new 1744	java/math/BigInteger
    //   6813: dup
    //   6814: aload 48
    //   6816: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   6819: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   6822: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6825: putfield 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   6828: aload 44
    //   6830: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   6833: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   6836: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6839: aload 47
    //   6841: invokeinterface 1860 2 0
    //   6846: pop
    //   6847: iload 8
    //   6849: iconst_1
    //   6850: iadd
    //   6851: istore 8
    //   6853: goto -251 -> 6602
    //   6856: aload 4
    //   6858: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   6861: iconst_0
    //   6862: istore 7
    //   6864: lload 34
    //   6866: lstore 20
    //   6868: aload_3
    //   6869: astore 4
    //   6871: aload 40
    //   6873: astore_3
    //   6874: goto -531 -> 6343
    //   6877: astore 40
    //   6879: ldc_w 386
    //   6882: iconst_1
    //   6883: new 388	java/lang/StringBuilder
    //   6886: dup
    //   6887: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   6890: ldc_w 1862
    //   6893: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6896: aload 40
    //   6898: invokevirtual 1717	org/json/JSONException:toString	()Ljava/lang/String;
    //   6901: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6904: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6907: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6910: aconst_null
    //   6911: astore 40
    //   6913: goto -396 -> 6517
    //   6916: astore 48
    //   6918: ldc_w 386
    //   6921: iconst_1
    //   6922: new 388	java/lang/StringBuilder
    //   6925: dup
    //   6926: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   6929: ldc_w 1862
    //   6932: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6935: aload 48
    //   6937: invokevirtual 1725	java/lang/Exception:toString	()Ljava/lang/String;
    //   6940: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6943: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6946: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6949: goto -121 -> 6828
    //   6952: astore_1
    //   6953: ldc_w 386
    //   6956: iconst_1
    //   6957: new 388	java/lang/StringBuilder
    //   6960: dup
    //   6961: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   6964: ldc_w 1864
    //   6967: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6970: aload_1
    //   6971: invokevirtual 1717	org/json/JSONException:toString	()Ljava/lang/String;
    //   6974: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6977: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6980: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6983: goto -2502 -> 4481
    //   6986: aload 43
    //   6988: ldc_w 1866
    //   6991: invokevirtual 1870	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6994: astore 43
    //   6996: ldc 163
    //   6998: astore 40
    //   7000: aload 43
    //   7002: ifnull +6127 -> 13129
    //   7005: iload 11
    //   7007: lload 26
    //   7009: invokestatic 1875	ram:c	(IJ)Z
    //   7012: ifeq +6117 -> 13129
    //   7015: aload 44
    //   7017: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7020: new 1877	qda
    //   7023: dup
    //   7024: invokespecial 1878	qda:<init>	()V
    //   7027: putfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7030: aload 43
    //   7032: ldc_w 1883
    //   7035: iconst_0
    //   7036: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7039: istore 12
    //   7041: aload 43
    //   7043: ldc_w 1885
    //   7046: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7049: astore 40
    //   7051: aload 43
    //   7053: ldc_w 1887
    //   7056: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7059: astore 47
    //   7061: aload 47
    //   7063: ifnull +366 -> 7429
    //   7066: aload 44
    //   7068: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7071: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7074: new 1810	qcg
    //   7077: dup
    //   7078: invokespecial 1811	qcg:<init>	()V
    //   7081: putfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   7084: aload 44
    //   7086: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7089: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7092: getfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   7095: new 174	java/util/ArrayList
    //   7098: dup
    //   7099: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7102: putfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7105: iconst_0
    //   7106: istore 8
    //   7108: iload 8
    //   7110: aload 47
    //   7112: invokevirtual 429	org/json/JSONArray:length	()I
    //   7115: if_icmpge +314 -> 7429
    //   7118: new 1827	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   7121: dup
    //   7122: invokespecial 1828	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   7125: astore 48
    //   7127: aload 47
    //   7129: iload 8
    //   7131: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7134: astore 49
    //   7136: aload 48
    //   7138: aload 49
    //   7140: ldc_w 1260
    //   7143: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   7146: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7149: putfield 1833	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   7152: aload 48
    //   7154: new 201	java/lang/String
    //   7157: dup
    //   7158: aload 49
    //   7160: ldc_w 1835
    //   7163: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7166: iconst_0
    //   7167: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   7170: invokespecial 681	java/lang/String:<init>	([B)V
    //   7173: putfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7176: aload 48
    //   7178: aload 48
    //   7180: getfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7183: putfield 1837	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7186: aload 48
    //   7188: aload 49
    //   7190: ldc_w 1839
    //   7193: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7196: putfield 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   7199: aload 48
    //   7201: aload 49
    //   7203: ldc_w 694
    //   7206: iconst_1
    //   7207: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   7210: putfield 1841	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   7213: aload 48
    //   7215: aload 49
    //   7217: ldc_w 1843
    //   7220: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7223: putfield 1844	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   7226: aload 49
    //   7228: ldc_w 1846
    //   7231: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7234: astore 50
    //   7236: aload 49
    //   7238: ldc_w 1848
    //   7241: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7244: astore 51
    //   7246: aload 50
    //   7248: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7251: ifne +39 -> 7290
    //   7254: aload 51
    //   7256: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7259: ifne +31 -> 7290
    //   7262: aload 48
    //   7264: new 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   7267: dup
    //   7268: lconst_0
    //   7269: new 201	java/lang/String
    //   7272: dup
    //   7273: aload 50
    //   7275: iconst_0
    //   7276: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   7279: invokespecial 681	java/lang/String:<init>	([B)V
    //   7282: aload 51
    //   7284: invokespecial 1853	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   7287: putfield 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   7290: aload 49
    //   7292: ldc_w 1742
    //   7295: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7298: astore 49
    //   7300: aload 49
    //   7302: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7305: ifne +23 -> 7328
    //   7308: aload 48
    //   7310: new 1744	java/math/BigInteger
    //   7313: dup
    //   7314: aload 49
    //   7316: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   7319: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   7322: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7325: putfield 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   7328: aload 44
    //   7330: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7333: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7336: getfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   7339: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7342: aload 48
    //   7344: invokeinterface 1860 2 0
    //   7349: pop
    //   7350: iload 8
    //   7352: iconst_1
    //   7353: iadd
    //   7354: istore 8
    //   7356: goto -248 -> 7108
    //   7359: astore 49
    //   7361: ldc_w 386
    //   7364: iconst_1
    //   7365: new 388	java/lang/StringBuilder
    //   7368: dup
    //   7369: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   7372: ldc_w 1862
    //   7375: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7378: aload 49
    //   7380: invokevirtual 1725	java/lang/Exception:toString	()Ljava/lang/String;
    //   7383: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7386: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7389: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7392: goto -64 -> 7328
    //   7395: astore_1
    //   7396: ldc_w 386
    //   7399: iconst_1
    //   7400: new 388	java/lang/StringBuilder
    //   7403: dup
    //   7404: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   7407: ldc_w 1890
    //   7410: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7413: aload_1
    //   7414: invokevirtual 1891	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   7417: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7420: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7423: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7426: goto -2945 -> 4481
    //   7429: aload 44
    //   7431: new 201	java/lang/String
    //   7434: dup
    //   7435: aload 40
    //   7437: iconst_0
    //   7438: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   7441: invokespecial 681	java/lang/String:<init>	([B)V
    //   7444: putfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7447: aload 44
    //   7449: ldc 163
    //   7451: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   7454: iload 12
    //   7456: iconst_3
    //   7457: if_icmpeq +9 -> 7466
    //   7460: iload 12
    //   7462: iconst_2
    //   7463: if_icmpne +5770 -> 13233
    //   7466: aload 44
    //   7468: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7471: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7474: new 174	java/util/ArrayList
    //   7477: dup
    //   7478: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7481: putfield 1892	qda:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7484: new 1894	qdb
    //   7487: dup
    //   7488: invokespecial 1895	qdb:<init>	()V
    //   7491: astore 4
    //   7493: aload 43
    //   7495: ldc_w 1897
    //   7498: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   7501: astore 43
    //   7503: aload 43
    //   7505: ifnull +5722 -> 13227
    //   7508: aload 43
    //   7510: invokevirtual 429	org/json/JSONArray:length	()I
    //   7513: ifle +5714 -> 13227
    //   7516: aload 4
    //   7518: aload 43
    //   7520: iconst_0
    //   7521: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   7524: ldc_w 1899
    //   7527: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7530: putfield 1900	qdb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7533: aload 44
    //   7535: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7538: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7541: getfield 1892	qda:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7544: aload 4
    //   7546: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7549: pop
    //   7550: goto +5677 -> 13227
    //   7553: iload 9
    //   7555: bipush 22
    //   7557: if_icmpne +52 -> 7609
    //   7560: new 1902	qcd
    //   7563: dup
    //   7564: invokespecial 1903	qcd:<init>	()V
    //   7567: astore 4
    //   7569: aload 4
    //   7571: aload_2
    //   7572: putfield 1904	qcd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7575: aload 4
    //   7577: aload 45
    //   7579: putfield 1905	qcd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7582: aload 4
    //   7584: aload 46
    //   7586: putfield 1906	qcd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7589: aload 4
    //   7591: lload 20
    //   7593: putfield 1908	qcd:jdField_a_of_type_Long	J
    //   7596: aload 44
    //   7598: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7601: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7604: aload 4
    //   7606: putfield 1911	qda:jdField_a_of_type_Qcd	Lqcd;
    //   7609: aload 44
    //   7611: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7614: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7617: iload 12
    //   7619: putfield 1912	qda:jdField_a_of_type_Int	I
    //   7622: aload 44
    //   7624: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7627: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7630: aload 44
    //   7632: getfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   7635: putfield 1913	qda:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7638: aload 40
    //   7640: astore_2
    //   7641: aload 44
    //   7643: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7646: ldc 163
    //   7648: putfield 1914	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7651: aload 44
    //   7653: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7656: ldc 163
    //   7658: putfield 1915	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   7661: aload 44
    //   7663: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7666: ldc 163
    //   7668: putfield 1916	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   7671: new 230	android/content/Intent
    //   7674: dup
    //   7675: aload_0
    //   7676: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   7679: ldc_w 1918
    //   7682: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   7685: astore 4
    //   7687: aload 4
    //   7689: ldc_w 1920
    //   7692: aload 44
    //   7694: invokevirtual 1923	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   7697: pop
    //   7698: aload_3
    //   7699: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7702: ifne +13 -> 7715
    //   7705: aload 4
    //   7707: ldc_w 1925
    //   7710: aload_3
    //   7711: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7714: pop
    //   7715: aload 4
    //   7717: ldc_w 1927
    //   7720: iload 9
    //   7722: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7725: pop
    //   7726: aload 4
    //   7728: ldc_w 1929
    //   7731: iload 6
    //   7733: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7736: pop
    //   7737: aload 4
    //   7739: ldc_w 1931
    //   7742: aload 42
    //   7744: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7747: pop
    //   7748: iconst_3
    //   7749: istore 6
    //   7751: iload 9
    //   7753: iconst_5
    //   7754: if_icmpne +5503 -> 13257
    //   7757: iconst_4
    //   7758: istore 6
    //   7760: aload 4
    //   7762: ldc_w 1933
    //   7765: iload 6
    //   7767: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7770: pop
    //   7771: aload 4
    //   7773: ldc_w 1935
    //   7776: aload_1
    //   7777: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7780: pop
    //   7781: aload 4
    //   7783: ldc_w 488
    //   7786: iload 11
    //   7788: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7791: pop
    //   7792: aload 4
    //   7794: ldc_w 1937
    //   7797: aload_2
    //   7798: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7801: pop
    //   7802: aload 4
    //   7804: ldc_w 1939
    //   7807: lload 20
    //   7809: invokevirtual 1942	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   7812: pop
    //   7813: aload 4
    //   7815: ldc_w 1944
    //   7818: iload 7
    //   7820: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   7823: pop
    //   7824: aload 4
    //   7826: ldc_w 1946
    //   7829: aload 41
    //   7831: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   7834: pop
    //   7835: iload 9
    //   7837: bipush 23
    //   7839: if_icmpne +146 -> 7985
    //   7842: aload 41
    //   7844: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7847: ifne +14 -> 7861
    //   7850: aload 44
    //   7852: getfield 1779	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   7855: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7858: ifeq +127 -> 7985
    //   7861: ldc_w 386
    //   7864: iconst_1
    //   7865: ldc_w 1948
    //   7868: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7871: iconst_0
    //   7872: ireturn
    //   7873: aload 44
    //   7875: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7878: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7881: new 174	java/util/ArrayList
    //   7884: dup
    //   7885: invokespecial 175	java/util/ArrayList:<init>	()V
    //   7888: putfield 1949	qda:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7891: new 1951	qdc
    //   7894: dup
    //   7895: invokespecial 1952	qdc:<init>	()V
    //   7898: astore 47
    //   7900: aload 43
    //   7902: ldc_w 1954
    //   7905: invokevirtual 1870	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   7908: astore 43
    //   7910: aload 43
    //   7912: ifnull +5336 -> 13248
    //   7915: aload 47
    //   7917: aload 43
    //   7919: ldc_w 1956
    //   7922: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   7925: putfield 1957	qdc:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   7928: aload 47
    //   7930: aload 43
    //   7932: ldc_w 1959
    //   7935: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   7938: i2l
    //   7939: putfield 1960	qdc:jdField_a_of_type_Long	J
    //   7942: aload 47
    //   7944: aload 4
    //   7946: putfield 1961	qdc:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   7949: aload 44
    //   7951: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7954: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   7957: getfield 1949	qda:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   7960: aload 47
    //   7962: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   7965: pop
    //   7966: goto +5282 -> 13248
    //   7969: iload 12
    //   7971: iconst_1
    //   7972: if_icmpne +5282 -> 13254
    //   7975: aload 44
    //   7977: ldc 163
    //   7979: putfield 1782	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   7982: goto +5272 -> 13254
    //   7985: iload 10
    //   7987: iconst_1
    //   7988: if_icmpne +163 -> 8151
    //   7991: aload 44
    //   7993: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   7996: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   7999: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8002: ifnull +5121 -> 13123
    //   8005: aload 44
    //   8007: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8010: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   8013: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   8016: invokeinterface 1962 1 0
    //   8021: ifle +5102 -> 13123
    //   8024: new 388	java/lang/StringBuilder
    //   8027: dup
    //   8028: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   8031: aload 5
    //   8033: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8036: ldc_w 1964
    //   8039: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8042: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8045: astore_1
    //   8046: aload_1
    //   8047: astore_2
    //   8048: aload_1
    //   8049: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8052: ifeq +7 -> 8059
    //   8055: ldc_w 1966
    //   8058: astore_2
    //   8059: new 388	java/lang/StringBuilder
    //   8062: dup
    //   8063: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   8066: ldc_w 1968
    //   8069: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8072: aload_2
    //   8073: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8076: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8079: astore_1
    //   8080: invokestatic 1973	osj:a	()Losj;
    //   8083: new 1975	sgd
    //   8086: dup
    //   8087: aload_0
    //   8088: aload 42
    //   8090: iload 11
    //   8092: invokespecial 1978	sgd:<init>	(Lsfk;Ljava/lang/String;I)V
    //   8095: invokevirtual 1981	osj:a	(Losm;)V
    //   8098: aload_0
    //   8099: getfield 1185	sfk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   8102: checkcast 1983	com/tencent/mobileqq/app/BrowserAppInterface
    //   8105: invokevirtual 1986	com/tencent/mobileqq/app/BrowserAppInterface:a	()Losl;
    //   8108: invokevirtual 1991	osl:a	()Losg;
    //   8111: aload_0
    //   8112: getfield 361	sfk:mRuntime	Lbcdp;
    //   8115: invokevirtual 1711	bcdp:a	()Lcom/tencent/common/app/AppInterface;
    //   8118: invokevirtual 1994	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   8121: lload 18
    //   8123: aload 44
    //   8125: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   8128: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   8131: lconst_0
    //   8132: aload_1
    //   8133: lload 22
    //   8135: ldc2_w 499
    //   8138: iload 6
    //   8140: aload_3
    //   8141: iload 11
    //   8143: aload 44
    //   8145: invokevirtual 1999	osg:a	(JJLqcg;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   8148: goto -3667 -> 4481
    //   8151: aload 4
    //   8153: ldc_w 1933
    //   8156: iconst_4
    //   8157: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8160: pop
    //   8161: aload 4
    //   8163: ldc_w 1927
    //   8166: iconst_0
    //   8167: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8170: pop
    //   8171: aload 4
    //   8173: ldc_w 2001
    //   8176: iconst_0
    //   8177: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8180: pop
    //   8181: aload 4
    //   8183: ldc_w 488
    //   8186: iconst_1
    //   8187: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   8190: pop
    //   8191: aload 4
    //   8193: ldc_w 2003
    //   8196: iconst_0
    //   8197: invokevirtual 879	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8200: pop
    //   8201: aload 4
    //   8203: ldc_w 2005
    //   8206: iconst_1
    //   8207: invokevirtual 879	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8210: pop
    //   8211: aload 4
    //   8213: ldc_w 2007
    //   8216: iconst_1
    //   8217: invokevirtual 879	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   8220: pop
    //   8221: aload 4
    //   8223: ldc_w 2009
    //   8226: lload 18
    //   8228: invokevirtual 1942	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   8231: pop
    //   8232: aload_0
    //   8233: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8236: aload 4
    //   8238: bipush 113
    //   8240: invokevirtual 792	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   8243: aload_0
    //   8244: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8247: iconst_0
    //   8248: iconst_0
    //   8249: invokevirtual 2012	android/app/Activity:overridePendingTransition	(II)V
    //   8252: goto -3771 -> 4481
    //   8255: ldc_w 2014
    //   8258: aload 4
    //   8260: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   8263: ifeq +2367 -> 10630
    //   8266: aload 5
    //   8268: ifnull -3787 -> 4481
    //   8271: aload 5
    //   8273: arraylength
    //   8274: ifle -3793 -> 4481
    //   8277: aload_0
    //   8278: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   8281: instanceof 2016
    //   8284: ifeq -3803 -> 4481
    //   8287: new 265	org/json/JSONObject
    //   8290: dup
    //   8291: aload 5
    //   8293: iconst_0
    //   8294: aaload
    //   8295: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8298: astore 43
    //   8300: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8303: ifeq +34 -> 8337
    //   8306: ldc_w 386
    //   8309: iconst_2
    //   8310: new 388	java/lang/StringBuilder
    //   8313: dup
    //   8314: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   8317: ldc_w 1734
    //   8320: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8323: aload 43
    //   8325: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8328: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8331: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8334: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8337: aload 43
    //   8339: ldc_w 492
    //   8342: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8345: astore 42
    //   8347: aload 43
    //   8349: ldc_w 494
    //   8352: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8355: astore_3
    //   8356: aload 43
    //   8358: ldc_w 1736
    //   8361: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8364: astore 41
    //   8366: aload 41
    //   8368: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8371: ifeq +4955 -> 13326
    //   8374: aload_2
    //   8375: astore 41
    //   8377: aload 43
    //   8379: ldc_w 1738
    //   8382: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8385: istore 10
    //   8387: ldc 163
    //   8389: astore 5
    //   8391: iload 10
    //   8393: iconst_1
    //   8394: if_icmpne +24 -> 8418
    //   8397: new 201	java/lang/String
    //   8400: dup
    //   8401: aload 43
    //   8403: ldc_w 1740
    //   8406: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8409: iconst_2
    //   8410: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   8413: invokespecial 681	java/lang/String:<init>	([B)V
    //   8416: astore 5
    //   8418: lconst_0
    //   8419: lstore 18
    //   8421: lconst_0
    //   8422: lstore 22
    //   8424: lconst_0
    //   8425: lstore 24
    //   8427: lconst_0
    //   8428: lstore 36
    //   8430: lconst_0
    //   8431: lstore 38
    //   8433: ldc 163
    //   8435: astore 40
    //   8437: new 201	java/lang/String
    //   8440: dup
    //   8441: aload 42
    //   8443: iconst_0
    //   8444: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   8447: invokespecial 681	java/lang/String:<init>	([B)V
    //   8450: astore_1
    //   8451: new 201	java/lang/String
    //   8454: dup
    //   8455: aload_3
    //   8456: iconst_0
    //   8457: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   8460: invokespecial 681	java/lang/String:<init>	([B)V
    //   8463: astore_2
    //   8464: aload 43
    //   8466: ldc_w 1742
    //   8469: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8472: astore_3
    //   8473: aload 43
    //   8475: ldc_w 401
    //   8478: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8481: astore 4
    //   8483: aload 4
    //   8485: astore 40
    //   8487: lload 18
    //   8489: lstore 20
    //   8491: lload 38
    //   8493: lstore 34
    //   8495: lload 36
    //   8497: lstore 32
    //   8499: lload 24
    //   8501: lstore 30
    //   8503: lload 22
    //   8505: lstore 28
    //   8507: lload 18
    //   8509: lstore 26
    //   8511: aload_3
    //   8512: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8515: ifne +36 -> 8551
    //   8518: lload 38
    //   8520: lstore 34
    //   8522: lload 36
    //   8524: lstore 32
    //   8526: lload 24
    //   8528: lstore 30
    //   8530: lload 22
    //   8532: lstore 28
    //   8534: lload 18
    //   8536: lstore 26
    //   8538: new 1744	java/math/BigInteger
    //   8541: dup
    //   8542: aload_3
    //   8543: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8546: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   8549: lstore 20
    //   8551: lload 38
    //   8553: lstore 34
    //   8555: lload 36
    //   8557: lstore 32
    //   8559: lload 24
    //   8561: lstore 30
    //   8563: lload 22
    //   8565: lstore 28
    //   8567: lload 20
    //   8569: lstore 26
    //   8571: aload 43
    //   8573: ldc_w 1750
    //   8576: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8579: astore 4
    //   8581: lload 22
    //   8583: lstore 18
    //   8585: lload 38
    //   8587: lstore 34
    //   8589: lload 36
    //   8591: lstore 32
    //   8593: lload 24
    //   8595: lstore 30
    //   8597: lload 22
    //   8599: lstore 28
    //   8601: lload 20
    //   8603: lstore 26
    //   8605: aload 4
    //   8607: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8610: ifne +37 -> 8647
    //   8613: lload 38
    //   8615: lstore 34
    //   8617: lload 36
    //   8619: lstore 32
    //   8621: lload 24
    //   8623: lstore 30
    //   8625: lload 22
    //   8627: lstore 28
    //   8629: lload 20
    //   8631: lstore 26
    //   8633: new 1744	java/math/BigInteger
    //   8636: dup
    //   8637: aload 4
    //   8639: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8642: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   8645: lstore 18
    //   8647: lload 38
    //   8649: lstore 34
    //   8651: lload 36
    //   8653: lstore 32
    //   8655: lload 24
    //   8657: lstore 30
    //   8659: lload 18
    //   8661: lstore 28
    //   8663: lload 20
    //   8665: lstore 26
    //   8667: aload 43
    //   8669: ldc_w 1752
    //   8672: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8675: astore 4
    //   8677: lload 24
    //   8679: lstore 22
    //   8681: lload 38
    //   8683: lstore 34
    //   8685: lload 36
    //   8687: lstore 32
    //   8689: lload 24
    //   8691: lstore 30
    //   8693: lload 18
    //   8695: lstore 28
    //   8697: lload 20
    //   8699: lstore 26
    //   8701: aload 4
    //   8703: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8706: ifne +37 -> 8743
    //   8709: lload 38
    //   8711: lstore 34
    //   8713: lload 36
    //   8715: lstore 32
    //   8717: lload 24
    //   8719: lstore 30
    //   8721: lload 18
    //   8723: lstore 28
    //   8725: lload 20
    //   8727: lstore 26
    //   8729: new 1744	java/math/BigInteger
    //   8732: dup
    //   8733: aload 4
    //   8735: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8738: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   8741: lstore 22
    //   8743: lload 38
    //   8745: lstore 34
    //   8747: lload 36
    //   8749: lstore 32
    //   8751: lload 22
    //   8753: lstore 30
    //   8755: lload 18
    //   8757: lstore 28
    //   8759: lload 20
    //   8761: lstore 26
    //   8763: aload 43
    //   8765: ldc_w 1754
    //   8768: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8771: astore 4
    //   8773: lload 36
    //   8775: lstore 24
    //   8777: lload 38
    //   8779: lstore 34
    //   8781: lload 36
    //   8783: lstore 32
    //   8785: lload 22
    //   8787: lstore 30
    //   8789: lload 18
    //   8791: lstore 28
    //   8793: lload 20
    //   8795: lstore 26
    //   8797: aload 4
    //   8799: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8802: ifne +37 -> 8839
    //   8805: lload 38
    //   8807: lstore 34
    //   8809: lload 36
    //   8811: lstore 32
    //   8813: lload 22
    //   8815: lstore 30
    //   8817: lload 18
    //   8819: lstore 28
    //   8821: lload 20
    //   8823: lstore 26
    //   8825: new 1744	java/math/BigInteger
    //   8828: dup
    //   8829: aload 4
    //   8831: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   8834: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   8837: lstore 24
    //   8839: lload 38
    //   8841: lstore 34
    //   8843: lload 24
    //   8845: lstore 32
    //   8847: lload 22
    //   8849: lstore 30
    //   8851: lload 18
    //   8853: lstore 28
    //   8855: lload 20
    //   8857: lstore 26
    //   8859: aload 43
    //   8861: ldc_w 1756
    //   8864: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   8867: lstore 36
    //   8869: lload 36
    //   8871: lstore 34
    //   8873: lload 24
    //   8875: lstore 32
    //   8877: lload 22
    //   8879: lstore 30
    //   8881: lload 18
    //   8883: lstore 28
    //   8885: lload 20
    //   8887: lstore 26
    //   8889: aload 43
    //   8891: ldc_w 1758
    //   8894: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8897: istore 7
    //   8899: lload 24
    //   8901: lstore 32
    //   8903: aload_3
    //   8904: astore 42
    //   8906: aload 40
    //   8908: astore_3
    //   8909: lload 20
    //   8911: lstore 26
    //   8913: lload 22
    //   8915: lstore 24
    //   8917: lload 36
    //   8919: lstore 20
    //   8921: lload 18
    //   8923: lstore 22
    //   8925: aload_1
    //   8926: astore 4
    //   8928: aload 42
    //   8930: astore_1
    //   8931: lload 26
    //   8933: lstore 18
    //   8935: aload 43
    //   8937: ldc_w 1760
    //   8940: lconst_1
    //   8941: invokevirtual 504	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   8944: lstore 26
    //   8946: aload 43
    //   8948: ldc_w 952
    //   8951: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8954: istore 6
    //   8956: aload 43
    //   8958: ldc_w 1762
    //   8961: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8964: istore 9
    //   8966: aload 43
    //   8968: ldc_w 1764
    //   8971: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8974: astore 45
    //   8976: aload 43
    //   8978: ldc_w 498
    //   8981: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   8984: istore 8
    //   8986: aload 43
    //   8988: ldc_w 415
    //   8991: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8994: astore 42
    //   8996: new 201	java/lang/String
    //   8999: dup
    //   9000: aload 43
    //   9002: ldc_w 1766
    //   9005: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9008: iconst_0
    //   9009: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9012: invokespecial 681	java/lang/String:<init>	([B)V
    //   9015: astore 46
    //   9017: aload 43
    //   9019: ldc_w 488
    //   9022: iconst_1
    //   9023: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9026: istore 11
    //   9028: new 1768	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   9031: dup
    //   9032: invokespecial 1769	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:<init>	()V
    //   9035: astore 44
    //   9037: aload 44
    //   9039: lload 22
    //   9041: putfield 1773	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mArticleID	J
    //   9044: aload 44
    //   9046: aload 4
    //   9048: putfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   9051: aload 44
    //   9053: aload_2
    //   9054: putfield 1779	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   9057: aload 44
    //   9059: aload 45
    //   9061: putfield 1782	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   9064: aload 44
    //   9066: iload 8
    //   9068: putfield 1785	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mVideoDuration	I
    //   9071: aload 44
    //   9073: lload 18
    //   9075: putfield 1788	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedId	J
    //   9078: aload 44
    //   9080: aload 46
    //   9082: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   9085: aload 44
    //   9087: lload 32
    //   9089: putfield 1793	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:businessId	J
    //   9092: aload 44
    //   9094: iload 11
    //   9096: putfield 1796	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   9099: aload 43
    //   9101: ldc_w 1798
    //   9104: invokevirtual 1801	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9107: astore 40
    //   9109: aload 44
    //   9111: new 1803	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo
    //   9114: dup
    //   9115: invokespecial 1804	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:<init>	()V
    //   9118: putfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9121: aload 44
    //   9123: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9126: new 1810	qcg
    //   9129: dup
    //   9130: invokespecial 1811	qcg:<init>	()V
    //   9133: putfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   9136: aload 44
    //   9138: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9141: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   9144: lload 24
    //   9146: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9149: putfield 1820	qcg:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9152: aload 44
    //   9154: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9157: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   9160: lload 26
    //   9162: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9165: putfield 1822	qcg:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   9168: aload 44
    //   9170: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9173: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   9176: new 174	java/util/ArrayList
    //   9179: dup
    //   9180: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9183: putfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9186: aload 40
    //   9188: ifnull +312 -> 9500
    //   9191: iconst_0
    //   9192: istore 8
    //   9194: iload 8
    //   9196: aload 40
    //   9198: invokevirtual 429	org/json/JSONArray:length	()I
    //   9201: if_icmpge +299 -> 9500
    //   9204: new 1827	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9207: dup
    //   9208: invokespecial 1828	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9211: astore 47
    //   9213: aload 40
    //   9215: iload 8
    //   9217: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9220: astore 48
    //   9222: aload 47
    //   9224: aload 48
    //   9226: ldc_w 1260
    //   9229: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9232: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9235: putfield 1833	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9238: aload 47
    //   9240: new 201	java/lang/String
    //   9243: dup
    //   9244: aload 48
    //   9246: ldc_w 1835
    //   9249: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9252: iconst_0
    //   9253: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9256: invokespecial 681	java/lang/String:<init>	([B)V
    //   9259: putfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9262: aload 47
    //   9264: aload 47
    //   9266: getfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9269: putfield 1837	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9272: aload 47
    //   9274: aload 48
    //   9276: ldc_w 1839
    //   9279: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9282: putfield 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   9285: aload 47
    //   9287: aload 48
    //   9289: ldc_w 694
    //   9292: iconst_1
    //   9293: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9296: putfield 1841	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   9299: aload 47
    //   9301: aload 48
    //   9303: ldc_w 1843
    //   9306: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9309: putfield 1844	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   9312: aload 48
    //   9314: ldc_w 1846
    //   9317: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9320: astore 49
    //   9322: aload 48
    //   9324: ldc_w 1848
    //   9327: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9330: astore 50
    //   9332: aload 49
    //   9334: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9337: ifne +39 -> 9376
    //   9340: aload 50
    //   9342: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9345: ifne +31 -> 9376
    //   9348: aload 47
    //   9350: new 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9353: dup
    //   9354: lconst_0
    //   9355: new 201	java/lang/String
    //   9358: dup
    //   9359: aload 49
    //   9361: iconst_0
    //   9362: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9365: invokespecial 681	java/lang/String:<init>	([B)V
    //   9368: aload 50
    //   9370: invokespecial 1853	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   9373: putfield 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   9376: iload 10
    //   9378: iconst_1
    //   9379: if_icmpne +3 -> 9382
    //   9382: aload 48
    //   9384: ldc_w 1742
    //   9387: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9390: astore 48
    //   9392: aload 48
    //   9394: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9397: ifne +23 -> 9420
    //   9400: aload 47
    //   9402: new 1744	java/math/BigInteger
    //   9405: dup
    //   9406: aload 48
    //   9408: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9411: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9414: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9417: putfield 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   9420: aload 44
    //   9422: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9425: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   9428: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9431: aload 47
    //   9433: invokeinterface 1860 2 0
    //   9438: pop
    //   9439: iload 8
    //   9441: iconst_1
    //   9442: iadd
    //   9443: istore 8
    //   9445: goto -251 -> 9194
    //   9448: aload 4
    //   9450: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   9453: iconst_0
    //   9454: istore 7
    //   9456: lload 34
    //   9458: lstore 20
    //   9460: aload_3
    //   9461: astore 4
    //   9463: aload 40
    //   9465: astore_3
    //   9466: goto -531 -> 8935
    //   9469: astore 40
    //   9471: aload 40
    //   9473: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   9476: aconst_null
    //   9477: astore 40
    //   9479: goto -370 -> 9109
    //   9482: astore 48
    //   9484: aload 48
    //   9486: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   9489: goto -69 -> 9420
    //   9492: astore_1
    //   9493: aload_1
    //   9494: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   9497: goto -5016 -> 4481
    //   9500: aload 43
    //   9502: ldc_w 1866
    //   9505: invokevirtual 1870	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   9508: astore 43
    //   9510: ldc 163
    //   9512: astore 40
    //   9514: aload 43
    //   9516: ifnull +3601 -> 13117
    //   9519: iload 11
    //   9521: lload 26
    //   9523: invokestatic 1875	ram:c	(IJ)Z
    //   9526: ifeq +3591 -> 13117
    //   9529: aload 44
    //   9531: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9534: new 1877	qda
    //   9537: dup
    //   9538: invokespecial 1878	qda:<init>	()V
    //   9541: putfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9544: aload 43
    //   9546: ldc_w 1883
    //   9549: iconst_0
    //   9550: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9553: istore 12
    //   9555: aload 43
    //   9557: ldc_w 1885
    //   9560: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9563: astore 40
    //   9565: aload 43
    //   9567: ldc_w 1887
    //   9570: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9573: astore 47
    //   9575: aload 47
    //   9577: ifnull +306 -> 9883
    //   9580: aload 44
    //   9582: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9585: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9588: new 1810	qcg
    //   9591: dup
    //   9592: invokespecial 1811	qcg:<init>	()V
    //   9595: putfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   9598: aload 44
    //   9600: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9603: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9606: getfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   9609: new 174	java/util/ArrayList
    //   9612: dup
    //   9613: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9616: putfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9619: iconst_0
    //   9620: istore 8
    //   9622: iload 8
    //   9624: aload 47
    //   9626: invokevirtual 429	org/json/JSONArray:length	()I
    //   9629: if_icmpge +254 -> 9883
    //   9632: new 1827	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo
    //   9635: dup
    //   9636: invokespecial 1828	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:<init>	()V
    //   9639: astore 48
    //   9641: aload 47
    //   9643: iload 8
    //   9645: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9648: astore 49
    //   9650: aload 48
    //   9652: aload 49
    //   9654: ldc_w 1260
    //   9657: invokevirtual 690	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   9660: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9663: putfield 1833	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   9666: aload 48
    //   9668: new 201	java/lang/String
    //   9671: dup
    //   9672: aload 49
    //   9674: ldc_w 1835
    //   9677: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9680: iconst_0
    //   9681: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9684: invokespecial 681	java/lang/String:<init>	([B)V
    //   9687: putfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9690: aload 48
    //   9692: aload 48
    //   9694: getfield 1836	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   9697: putfield 1837	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9700: aload 48
    //   9702: aload 49
    //   9704: ldc_w 1839
    //   9707: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9710: putfield 1840	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_Int	I
    //   9713: aload 48
    //   9715: aload 49
    //   9717: ldc_w 694
    //   9720: iconst_1
    //   9721: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   9724: putfield 1841	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_Int	I
    //   9727: aload 48
    //   9729: aload 49
    //   9731: ldc_w 1843
    //   9734: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   9737: putfield 1844	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_c_of_type_Int	I
    //   9740: aload 49
    //   9742: ldc_w 1846
    //   9745: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9748: astore 50
    //   9750: aload 49
    //   9752: ldc_w 1848
    //   9755: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9758: astore 51
    //   9760: aload 50
    //   9762: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9765: ifne +39 -> 9804
    //   9768: aload 51
    //   9770: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9773: ifne +31 -> 9804
    //   9776: aload 48
    //   9778: new 1850	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo
    //   9781: dup
    //   9782: lconst_0
    //   9783: new 201	java/lang/String
    //   9786: dup
    //   9787: aload 50
    //   9789: iconst_0
    //   9790: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9793: invokespecial 681	java/lang/String:<init>	([B)V
    //   9796: aload 51
    //   9798: invokespecial 1853	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo:<init>	(JLjava/lang/String;Ljava/lang/String;)V
    //   9801: putfield 1856	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$JumpInfo;
    //   9804: aload 49
    //   9806: ldc_w 1742
    //   9809: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9812: astore 49
    //   9814: aload 49
    //   9816: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9819: ifne +23 -> 9842
    //   9822: aload 48
    //   9824: new 1744	java/math/BigInteger
    //   9827: dup
    //   9828: aload 49
    //   9830: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   9833: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   9836: invokestatic 1817	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   9839: putfield 1857	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo$BiuCommentInfo:jdField_b_of_type_JavaLangLong	Ljava/lang/Long;
    //   9842: aload 44
    //   9844: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9847: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9850: getfield 1888	qda:jdField_a_of_type_Qcg	Lqcg;
    //   9853: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9856: aload 48
    //   9858: invokeinterface 1860 2 0
    //   9863: pop
    //   9864: iload 8
    //   9866: iconst_1
    //   9867: iadd
    //   9868: istore 8
    //   9870: goto -248 -> 9622
    //   9873: astore 49
    //   9875: aload 49
    //   9877: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   9880: goto -38 -> 9842
    //   9883: aload 44
    //   9885: new 201	java/lang/String
    //   9888: dup
    //   9889: aload 40
    //   9891: iconst_0
    //   9892: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   9895: invokespecial 681	java/lang/String:<init>	([B)V
    //   9898: putfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   9901: aload 44
    //   9903: ldc 163
    //   9905: putfield 1791	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSummary	Ljava/lang/String;
    //   9908: iload 12
    //   9910: iconst_3
    //   9911: if_icmpeq +9 -> 9920
    //   9914: iload 12
    //   9916: iconst_2
    //   9917: if_icmpne +3439 -> 13356
    //   9920: aload 44
    //   9922: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9925: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9928: new 174	java/util/ArrayList
    //   9931: dup
    //   9932: invokespecial 175	java/util/ArrayList:<init>	()V
    //   9935: putfield 1892	qda:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   9938: new 1894	qdb
    //   9941: dup
    //   9942: invokespecial 1895	qdb:<init>	()V
    //   9945: astore 4
    //   9947: aload 43
    //   9949: ldc_w 1897
    //   9952: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   9955: astore 43
    //   9957: aload 43
    //   9959: ifnull +3391 -> 13350
    //   9962: aload 43
    //   9964: invokevirtual 429	org/json/JSONArray:length	()I
    //   9967: ifle +3383 -> 13350
    //   9970: aload 4
    //   9972: aload 43
    //   9974: iconst_0
    //   9975: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   9978: ldc_w 1899
    //   9981: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   9984: putfield 1900	qdb:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   9987: aload 44
    //   9989: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   9992: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   9995: getfield 1892	qda:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   9998: aload 4
    //   10000: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10003: pop
    //   10004: goto +3346 -> 13350
    //   10007: iload 9
    //   10009: bipush 22
    //   10011: if_icmpne +52 -> 10063
    //   10014: new 1902	qcd
    //   10017: dup
    //   10018: invokespecial 1903	qcd:<init>	()V
    //   10021: astore 4
    //   10023: aload 4
    //   10025: aload_2
    //   10026: putfield 1904	qcd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10029: aload 4
    //   10031: aload 45
    //   10033: putfield 1905	qcd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10036: aload 4
    //   10038: aload 46
    //   10040: putfield 1906	qcd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10043: aload 4
    //   10045: lload 20
    //   10047: putfield 1908	qcd:jdField_a_of_type_Long	J
    //   10050: aload 44
    //   10052: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10055: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   10058: aload 4
    //   10060: putfield 1911	qda:jdField_a_of_type_Qcd	Lqcd;
    //   10063: aload 44
    //   10065: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10068: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   10071: iload 12
    //   10073: putfield 1912	qda:jdField_a_of_type_Int	I
    //   10076: aload 44
    //   10078: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10081: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   10084: aload 44
    //   10086: getfield 1776	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mTitle	Ljava/lang/String;
    //   10089: putfield 1913	qda:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10092: aload 40
    //   10094: astore_2
    //   10095: aload 44
    //   10097: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10100: ldc 163
    //   10102: putfield 1914	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10105: aload 44
    //   10107: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10110: ldc 163
    //   10112: putfield 1915	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   10115: aload 44
    //   10117: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10120: ldc 163
    //   10122: putfield 1916	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   10125: new 230	android/content/Intent
    //   10128: dup
    //   10129: aload_0
    //   10130: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10133: ldc_w 1918
    //   10136: invokespecial 733	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10139: astore 4
    //   10141: aload 4
    //   10143: ldc_w 1920
    //   10146: aload 44
    //   10148: invokevirtual 1923	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   10151: pop
    //   10152: aload_3
    //   10153: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10156: ifne +13 -> 10169
    //   10159: aload 4
    //   10161: ldc_w 1925
    //   10164: aload_3
    //   10165: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10168: pop
    //   10169: aload 4
    //   10171: ldc_w 1927
    //   10174: iload 9
    //   10176: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10179: pop
    //   10180: aload 4
    //   10182: ldc_w 1929
    //   10185: iload 6
    //   10187: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10190: pop
    //   10191: aload 4
    //   10193: ldc_w 1931
    //   10196: aload 42
    //   10198: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10201: pop
    //   10202: iconst_3
    //   10203: istore 6
    //   10205: iload 9
    //   10207: iconst_5
    //   10208: if_icmpne +3172 -> 13380
    //   10211: iconst_4
    //   10212: istore 6
    //   10214: aload 4
    //   10216: ldc_w 1933
    //   10219: iload 6
    //   10221: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10224: pop
    //   10225: aload 4
    //   10227: ldc_w 1935
    //   10230: aload_1
    //   10231: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10234: pop
    //   10235: aload 4
    //   10237: ldc_w 488
    //   10240: iload 11
    //   10242: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10245: pop
    //   10246: aload 4
    //   10248: ldc_w 1937
    //   10251: aload_2
    //   10252: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10255: pop
    //   10256: aload 4
    //   10258: ldc_w 1939
    //   10261: lload 20
    //   10263: invokevirtual 1942	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   10266: pop
    //   10267: aload 4
    //   10269: ldc_w 1944
    //   10272: iload 7
    //   10274: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   10277: pop
    //   10278: aload 4
    //   10280: ldc_w 1946
    //   10283: aload 41
    //   10285: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10288: pop
    //   10289: iload 9
    //   10291: bipush 23
    //   10293: if_icmpne +146 -> 10439
    //   10296: aload 41
    //   10298: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10301: ifne +14 -> 10315
    //   10304: aload 44
    //   10306: getfield 1779	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSubscribeName	Ljava/lang/String;
    //   10309: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10312: ifeq +127 -> 10439
    //   10315: ldc_w 386
    //   10318: iconst_1
    //   10319: ldc_w 1948
    //   10322: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10325: iconst_0
    //   10326: ireturn
    //   10327: aload 44
    //   10329: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10332: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   10335: new 174	java/util/ArrayList
    //   10338: dup
    //   10339: invokespecial 175	java/util/ArrayList:<init>	()V
    //   10342: putfield 1949	qda:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10345: new 1951	qdc
    //   10348: dup
    //   10349: invokespecial 1952	qdc:<init>	()V
    //   10352: astore 47
    //   10354: aload 43
    //   10356: ldc_w 1954
    //   10359: invokevirtual 1870	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   10362: astore 43
    //   10364: aload 43
    //   10366: ifnull +3005 -> 13371
    //   10369: aload 47
    //   10371: aload 43
    //   10373: ldc_w 1956
    //   10376: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   10379: putfield 1957	qdc:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   10382: aload 47
    //   10384: aload 43
    //   10386: ldc_w 1959
    //   10389: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   10392: i2l
    //   10393: putfield 1960	qdc:jdField_a_of_type_Long	J
    //   10396: aload 47
    //   10398: aload 4
    //   10400: putfield 1961	qdc:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   10403: aload 44
    //   10405: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10408: getfield 1881	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qda	Lqda;
    //   10411: getfield 1949	qda:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   10414: aload 47
    //   10416: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   10419: pop
    //   10420: goto +2951 -> 13371
    //   10423: iload 12
    //   10425: iconst_1
    //   10426: if_icmpne +2951 -> 13377
    //   10429: aload 44
    //   10431: ldc 163
    //   10433: putfield 1782	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFirstPagePicUrl	Ljava/lang/String;
    //   10436: goto +2941 -> 13377
    //   10439: iload 10
    //   10441: iconst_1
    //   10442: if_icmpne +165 -> 10607
    //   10445: aload 44
    //   10447: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10450: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   10453: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10456: ifnull +2655 -> 13111
    //   10459: aload 44
    //   10461: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10464: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   10467: getfield 1825	qcg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   10470: invokeinterface 1962 1 0
    //   10475: ifle +2636 -> 13111
    //   10478: new 388	java/lang/StringBuilder
    //   10481: dup
    //   10482: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   10485: aload 5
    //   10487: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10490: ldc_w 1964
    //   10493: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10496: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10499: astore_1
    //   10500: aload_1
    //   10501: astore_2
    //   10502: aload_1
    //   10503: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10506: ifeq +7 -> 10513
    //   10509: ldc_w 1966
    //   10512: astore_2
    //   10513: new 388	java/lang/StringBuilder
    //   10516: dup
    //   10517: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   10520: ldc_w 1968
    //   10523: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10526: aload_2
    //   10527: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10530: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10533: astore_1
    //   10534: aload_0
    //   10535: getfield 1185	sfk:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   10538: checkcast 1983	com/tencent/mobileqq/app/BrowserAppInterface
    //   10541: invokevirtual 1986	com/tencent/mobileqq/app/BrowserAppInterface:a	()Losl;
    //   10544: astore_2
    //   10545: invokestatic 1973	osj:a	()Losj;
    //   10548: new 1975	sgd
    //   10551: dup
    //   10552: aload_0
    //   10553: aload 42
    //   10555: iload 11
    //   10557: invokespecial 1978	sgd:<init>	(Lsfk;Ljava/lang/String;I)V
    //   10560: invokevirtual 1981	osj:a	(Losm;)V
    //   10563: aload_2
    //   10564: invokevirtual 1991	osl:a	()Losg;
    //   10567: aload_0
    //   10568: getfield 361	sfk:mRuntime	Lbcdp;
    //   10571: invokevirtual 1711	bcdp:a	()Lcom/tencent/common/app/AppInterface;
    //   10574: invokevirtual 1994	com/tencent/common/app/AppInterface:getLongAccountUin	()J
    //   10577: lload 18
    //   10579: aload 44
    //   10581: getfield 1808	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   10584: getfield 1814	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Qcg	Lqcg;
    //   10587: lconst_0
    //   10588: aload_1
    //   10589: lload 22
    //   10591: ldc2_w 499
    //   10594: iload 6
    //   10596: aload_3
    //   10597: iload 11
    //   10599: aload 44
    //   10601: invokevirtual 1999	osg:a	(JJLqcg;JLjava/lang/String;JJILjava/lang/String;ILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)V
    //   10604: goto -6123 -> 4481
    //   10607: aload_0
    //   10608: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10611: aload 4
    //   10613: bipush 113
    //   10615: invokevirtual 792	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   10618: aload_0
    //   10619: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10622: iconst_0
    //   10623: iconst_0
    //   10624: invokevirtual 2012	android/app/Activity:overridePendingTransition	(II)V
    //   10627: goto -6146 -> 4481
    //   10630: ldc_w 2018
    //   10633: aload 4
    //   10635: invokevirtual 1327	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   10638: ifeq +48 -> 10686
    //   10641: aload 5
    //   10643: ifnull -6162 -> 4481
    //   10646: aload 5
    //   10648: arraylength
    //   10649: ifle -6168 -> 4481
    //   10652: aload_0
    //   10653: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10656: instanceof 2016
    //   10659: ifeq -6178 -> 4481
    //   10662: aload_0
    //   10663: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10666: checkcast 587	com/tencent/mobileqq/app/BaseActivity
    //   10669: new 2020	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$4
    //   10672: dup
    //   10673: aload_0
    //   10674: aload 5
    //   10676: invokespecial 2023	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$4:<init>	(Lsfk;[Ljava/lang/String;)V
    //   10679: invokestatic 2028	rfz:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   10682: pop
    //   10683: goto -6202 -> 4481
    //   10686: ldc_w 2030
    //   10689: aload 4
    //   10691: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10694: ifeq +94 -> 10788
    //   10697: new 265	org/json/JSONObject
    //   10700: dup
    //   10701: aload 5
    //   10703: iconst_0
    //   10704: aaload
    //   10705: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10708: astore_1
    //   10709: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10712: ifeq -6231 -> 4481
    //   10715: ldc_w 2032
    //   10718: iconst_2
    //   10719: new 388	java/lang/StringBuilder
    //   10722: dup
    //   10723: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   10726: ldc_w 2034
    //   10729: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10732: aload_1
    //   10733: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   10736: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10739: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10742: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10745: goto -6264 -> 4481
    //   10748: astore_1
    //   10749: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10752: ifeq -6271 -> 4481
    //   10755: ldc_w 2032
    //   10758: iconst_2
    //   10759: new 388	java/lang/StringBuilder
    //   10762: dup
    //   10763: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   10766: ldc_w 2036
    //   10769: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10772: aload_1
    //   10773: invokevirtual 2039	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   10776: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10779: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10782: invokestatic 399	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10785: goto -6304 -> 4481
    //   10788: ldc_w 2041
    //   10791: aload 4
    //   10793: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10796: ifeq +27 -> 10823
    //   10799: aload_0
    //   10800: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   10803: checkcast 587	com/tencent/mobileqq/app/BaseActivity
    //   10806: new 2043	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$5
    //   10809: dup
    //   10810: aload_0
    //   10811: aload 5
    //   10813: invokespecial 2044	com/tencent/biz/pubaccount/util/PublicAccountH5AbilityPlugin$5:<init>	(Lsfk;[Ljava/lang/String;)V
    //   10816: invokestatic 2028	rfz:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/Runnable;)Z
    //   10819: pop
    //   10820: goto -6339 -> 4481
    //   10823: ldc_w 2046
    //   10826: aload 4
    //   10828: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10831: ifeq +63 -> 10894
    //   10834: new 265	org/json/JSONObject
    //   10837: dup
    //   10838: aload 5
    //   10840: iconst_0
    //   10841: aaload
    //   10842: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10845: ldc_w 2048
    //   10848: invokevirtual 2049	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   10851: astore_1
    //   10852: aload_1
    //   10853: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10856: ifeq +30 -> 10886
    //   10859: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10862: ifeq -6381 -> 4481
    //   10865: ldc_w 386
    //   10868: iconst_2
    //   10869: ldc_w 2051
    //   10872: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10875: goto -6394 -> 4481
    //   10878: astore_1
    //   10879: aload_1
    //   10880: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   10883: goto -6402 -> 4481
    //   10886: aload_0
    //   10887: aload_1
    //   10888: invokespecial 2053	sfk:e	(Ljava/lang/String;)V
    //   10891: goto -6410 -> 4481
    //   10894: ldc_w 2055
    //   10897: aload 4
    //   10899: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10902: ifeq +100 -> 11002
    //   10905: new 265	org/json/JSONObject
    //   10908: dup
    //   10909: aload 5
    //   10911: iconst_0
    //   10912: aaload
    //   10913: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   10916: astore_1
    //   10917: aload_1
    //   10918: ldc_w 2057
    //   10921: invokevirtual 2060	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   10924: istore 6
    //   10926: aload_1
    //   10927: ldc_w 2062
    //   10930: invokevirtual 2060	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   10933: istore 7
    //   10935: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10938: ifeq +42 -> 10980
    //   10941: ldc_w 386
    //   10944: iconst_2
    //   10945: new 388	java/lang/StringBuilder
    //   10948: dup
    //   10949: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   10952: ldc_w 2064
    //   10955: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10958: iload 6
    //   10960: invokevirtual 531	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10963: ldc_w 2066
    //   10966: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10969: iload 7
    //   10971: invokevirtual 531	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10974: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10977: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10980: aload_0
    //   10981: getfield 144	sfk:jdField_a_of_type_Wxr	Lwxr;
    //   10984: iload 6
    //   10986: iload 7
    //   10988: invokevirtual 2067	wxr:a	(II)V
    //   10991: goto -6510 -> 4481
    //   10994: astore_1
    //   10995: aload_1
    //   10996: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   10999: goto -6518 -> 4481
    //   11002: ldc_w 2069
    //   11005: aload 4
    //   11007: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11010: ifeq +401 -> 11411
    //   11013: new 265	org/json/JSONObject
    //   11016: dup
    //   11017: aload 5
    //   11019: iconst_0
    //   11020: aaload
    //   11021: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11024: astore 4
    //   11026: aload 4
    //   11028: ldc_w 2071
    //   11031: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11034: ifeq +2071 -> 13105
    //   11037: aload 4
    //   11039: ldc_w 2071
    //   11042: invokevirtual 515	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11045: istore 13
    //   11047: aload 4
    //   11049: ldc_w 521
    //   11052: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11055: ifeq +2044 -> 13099
    //   11058: aload 4
    //   11060: ldc_w 521
    //   11063: invokevirtual 515	org/json/JSONObject:optBoolean	(Ljava/lang/String;)Z
    //   11066: istore 14
    //   11068: aload 4
    //   11070: ldc_w 2073
    //   11073: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11076: ifeq +2017 -> 13093
    //   11079: aload 4
    //   11081: ldc_w 2073
    //   11084: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11087: astore_1
    //   11088: new 201	java/lang/String
    //   11091: dup
    //   11092: aload_1
    //   11093: iconst_0
    //   11094: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   11097: invokespecial 681	java/lang/String:<init>	([B)V
    //   11100: astore_2
    //   11101: aload_2
    //   11102: astore_1
    //   11103: aload 4
    //   11105: ldc_w 2075
    //   11108: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11111: ifeq +1976 -> 13087
    //   11114: aload 4
    //   11116: ldc_w 2075
    //   11119: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11122: astore_2
    //   11123: new 201	java/lang/String
    //   11126: dup
    //   11127: aload_2
    //   11128: iconst_0
    //   11129: invokestatic 678	bbco:decode	(Ljava/lang/String;I)[B
    //   11132: invokespecial 681	java/lang/String:<init>	([B)V
    //   11135: astore_3
    //   11136: aload_3
    //   11137: astore_2
    //   11138: aload 4
    //   11140: ldc_w 2077
    //   11143: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11146: ifeq +1935 -> 13081
    //   11149: aload 4
    //   11151: ldc_w 2077
    //   11154: iconst_m1
    //   11155: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11158: istore 6
    //   11160: aload 4
    //   11162: ldc_w 2079
    //   11165: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11168: ifeq +1907 -> 13075
    //   11171: aload 4
    //   11173: ldc_w 2079
    //   11176: iconst_0
    //   11177: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11180: istore 7
    //   11182: iconst_0
    //   11183: istore 8
    //   11185: aload 4
    //   11187: ldc_w 1444
    //   11190: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11193: ifeq +14 -> 11207
    //   11196: aload 4
    //   11198: ldc_w 1444
    //   11201: iconst_0
    //   11202: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11205: istore 8
    //   11207: aload 4
    //   11209: ldc_w 415
    //   11212: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11215: astore_3
    //   11216: aload 4
    //   11218: ldc_w 2081
    //   11221: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11224: astore 5
    //   11226: aload 4
    //   11228: ldc_w 2083
    //   11231: iconst_0
    //   11232: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   11235: istore 9
    //   11237: new 230	android/content/Intent
    //   11240: dup
    //   11241: invokespecial 438	android/content/Intent:<init>	()V
    //   11244: astore 4
    //   11246: aload 4
    //   11248: ldc_w 2085
    //   11251: iload 13
    //   11253: invokevirtual 879	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11256: pop
    //   11257: aload 4
    //   11259: ldc_w 2087
    //   11262: aload_1
    //   11263: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11266: pop
    //   11267: aload 4
    //   11269: ldc_w 2089
    //   11272: aload_2
    //   11273: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11276: pop
    //   11277: aload 4
    //   11279: ldc_w 2091
    //   11282: iload 6
    //   11284: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11287: pop
    //   11288: aload 4
    //   11290: ldc_w 2093
    //   11293: iload 7
    //   11295: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11298: pop
    //   11299: aload 4
    //   11301: ldc_w 2095
    //   11304: iload 8
    //   11306: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11309: pop
    //   11310: aload 4
    //   11312: ldc 228
    //   11314: aload_3
    //   11315: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11318: pop
    //   11319: aload 4
    //   11321: ldc_w 2097
    //   11324: iload 9
    //   11326: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11329: pop
    //   11330: aload 4
    //   11332: ldc_w 2099
    //   11335: iload 14
    //   11337: invokevirtual 879	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   11340: pop
    //   11341: aload 4
    //   11343: ldc_w 2101
    //   11346: iconst_1
    //   11347: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11350: pop
    //   11351: aload 5
    //   11353: ifnull +17 -> 11370
    //   11356: aload 4
    //   11358: ldc_w 2103
    //   11361: aload 5
    //   11363: invokevirtual 2104	org/json/JSONArray:toString	()Ljava/lang/String;
    //   11366: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11369: pop
    //   11370: aload_0
    //   11371: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11374: aload 4
    //   11376: ldc_w 2106
    //   11379: bipush 117
    //   11381: invokestatic 2110	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Class;I)V
    //   11384: goto -6903 -> 4481
    //   11387: astore_1
    //   11388: aload_1
    //   11389: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   11392: goto -6911 -> 4481
    //   11395: astore_2
    //   11396: aload_2
    //   11397: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   11400: goto -297 -> 11103
    //   11403: astore_3
    //   11404: aload_3
    //   11405: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   11408: goto -270 -> 11138
    //   11411: ldc_w 2112
    //   11414: aload 4
    //   11416: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11419: ifeq +14 -> 11433
    //   11422: aload_0
    //   11423: aload 5
    //   11425: iconst_0
    //   11426: aaload
    //   11427: invokespecial 2114	sfk:d	(Ljava/lang/String;)V
    //   11430: goto -6949 -> 4481
    //   11433: ldc_w 2116
    //   11436: aload 4
    //   11438: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11441: ifeq +117 -> 11558
    //   11444: aconst_null
    //   11445: astore_1
    //   11446: new 265	org/json/JSONObject
    //   11449: dup
    //   11450: aload 5
    //   11452: iconst_0
    //   11453: aaload
    //   11454: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11457: ldc_w 415
    //   11460: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11463: astore_2
    //   11464: aload_2
    //   11465: astore_1
    //   11466: new 230	android/content/Intent
    //   11469: dup
    //   11470: invokespecial 438	android/content/Intent:<init>	()V
    //   11473: astore_3
    //   11474: aload_2
    //   11475: astore_1
    //   11476: aload_3
    //   11477: ldc_w 2118
    //   11480: aload 5
    //   11482: iconst_0
    //   11483: aaload
    //   11484: invokevirtual 449	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11487: pop
    //   11488: aload_2
    //   11489: astore_1
    //   11490: aload_0
    //   11491: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   11494: aload_3
    //   11495: ldc_w 2120
    //   11498: invokestatic 2123	com/tencent/mobileqq/activity/PublicTransFragmentActivity:b	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   11501: aload_2
    //   11502: astore_1
    //   11503: aload_0
    //   11504: aload_2
    //   11505: iconst_1
    //   11506: anewarray 201	java/lang/String
    //   11509: dup
    //   11510: iconst_0
    //   11511: new 265	org/json/JSONObject
    //   11514: dup
    //   11515: invokespecial 266	org/json/JSONObject:<init>	()V
    //   11518: ldc_w 268
    //   11521: iconst_0
    //   11522: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11525: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11528: aastore
    //   11529: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11532: goto -7051 -> 4481
    //   11535: astore_2
    //   11536: aload_2
    //   11537: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   11540: aload_0
    //   11541: aload_1
    //   11542: iconst_1
    //   11543: anewarray 201	java/lang/String
    //   11546: dup
    //   11547: iconst_0
    //   11548: ldc_w 2125
    //   11551: aastore
    //   11552: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11555: goto -7074 -> 4481
    //   11558: ldc_w 2127
    //   11561: aload 4
    //   11563: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11566: ifeq +161 -> 11727
    //   11569: aconst_null
    //   11570: astore_2
    //   11571: aload_2
    //   11572: astore_1
    //   11573: new 265	org/json/JSONObject
    //   11576: dup
    //   11577: aload 5
    //   11579: iconst_0
    //   11580: aaload
    //   11581: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11584: astore_3
    //   11585: aload_2
    //   11586: astore_1
    //   11587: aload_3
    //   11588: ldc_w 415
    //   11591: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11594: astore_2
    //   11595: aload_2
    //   11596: astore_1
    //   11597: aload_3
    //   11598: ldc_w 2129
    //   11601: invokevirtual 664	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   11604: astore_3
    //   11605: aload_2
    //   11606: astore_1
    //   11607: new 174	java/util/ArrayList
    //   11610: dup
    //   11611: invokespecial 175	java/util/ArrayList:<init>	()V
    //   11614: astore 4
    //   11616: iconst_0
    //   11617: istore 6
    //   11619: aload_2
    //   11620: astore_1
    //   11621: iload 6
    //   11623: aload_3
    //   11624: invokevirtual 429	org/json/JSONArray:length	()I
    //   11627: if_icmpge +32 -> 11659
    //   11630: aload_2
    //   11631: astore_1
    //   11632: aload 4
    //   11634: aload_3
    //   11635: iload 6
    //   11637: invokevirtual 1832	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   11640: ldc_w 1199
    //   11643: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11646: invokevirtual 728	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   11649: pop
    //   11650: iload 6
    //   11652: iconst_1
    //   11653: iadd
    //   11654: istore 6
    //   11656: goto -37 -> 11619
    //   11659: aload_2
    //   11660: astore_1
    //   11661: aload_0
    //   11662: getfield 144	sfk:jdField_a_of_type_Wxr	Lwxr;
    //   11665: aload 4
    //   11667: invokevirtual 2130	wxr:b	(Ljava/util/ArrayList;)V
    //   11670: aload_2
    //   11671: astore_1
    //   11672: aload_0
    //   11673: aload_2
    //   11674: iconst_1
    //   11675: anewarray 201	java/lang/String
    //   11678: dup
    //   11679: iconst_0
    //   11680: new 265	org/json/JSONObject
    //   11683: dup
    //   11684: invokespecial 266	org/json/JSONObject:<init>	()V
    //   11687: ldc_w 268
    //   11690: iconst_0
    //   11691: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   11694: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11697: aastore
    //   11698: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11701: goto -7220 -> 4481
    //   11704: astore_2
    //   11705: aload_2
    //   11706: invokevirtual 461	java/lang/Exception:printStackTrace	()V
    //   11709: aload_0
    //   11710: aload_1
    //   11711: iconst_1
    //   11712: anewarray 201	java/lang/String
    //   11715: dup
    //   11716: iconst_0
    //   11717: ldc_w 2125
    //   11720: aastore
    //   11721: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11724: goto -7243 -> 4481
    //   11727: ldc_w 2132
    //   11730: aload 4
    //   11732: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11735: ifeq +258 -> 11993
    //   11738: new 265	org/json/JSONObject
    //   11741: dup
    //   11742: aload 5
    //   11744: iconst_0
    //   11745: aaload
    //   11746: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11749: astore_3
    //   11750: aload_3
    //   11751: ldc_w 415
    //   11754: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   11757: astore_2
    //   11758: aload_3
    //   11759: ldc_w 2134
    //   11762: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11765: ifeq +13 -> 11778
    //   11768: aload_3
    //   11769: ldc_w 2134
    //   11772: ldc 163
    //   11774: invokevirtual 405	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11777: pop
    //   11778: ldc 163
    //   11780: astore_1
    //   11781: aload_3
    //   11782: ldc_w 2136
    //   11785: invokevirtual 1519	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   11788: ifeq +13 -> 11801
    //   11791: aload_3
    //   11792: ldc_w 2136
    //   11795: ldc 163
    //   11797: invokevirtual 405	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11800: astore_1
    //   11801: ldc_w 2138
    //   11804: aload_1
    //   11805: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11808: ifeq +93 -> 11901
    //   11811: aload_0
    //   11812: getfield 146	sfk:jdField_a_of_type_Qoz	Lqoz;
    //   11815: ldc_w 2140
    //   11818: aconst_null
    //   11819: invokevirtual 2143	qoz:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   11822: ldc_w 2145
    //   11825: ldc 163
    //   11827: invokevirtual 2147	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11830: astore_1
    //   11831: ldc 163
    //   11833: aload_1
    //   11834: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11837: istore 13
    //   11839: iload 13
    //   11841: ifne -7360 -> 4481
    //   11844: new 265	org/json/JSONObject
    //   11847: dup
    //   11848: aload_1
    //   11849: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11852: astore_1
    //   11853: aload_0
    //   11854: aload_2
    //   11855: iconst_1
    //   11856: anewarray 201	java/lang/String
    //   11859: dup
    //   11860: iconst_0
    //   11861: new 265	org/json/JSONObject
    //   11864: dup
    //   11865: invokespecial 266	org/json/JSONObject:<init>	()V
    //   11868: ldc_w 2149
    //   11871: aload_1
    //   11872: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11875: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11878: aastore
    //   11879: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11882: goto -7401 -> 4481
    //   11885: astore_1
    //   11886: aload_1
    //   11887: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   11890: goto -7409 -> 4481
    //   11893: astore_1
    //   11894: aload_1
    //   11895: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   11898: goto -7417 -> 4481
    //   11901: ldc_w 2151
    //   11904: aload_1
    //   11905: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11908: ifeq -7427 -> 4481
    //   11911: aload_0
    //   11912: getfield 146	sfk:jdField_a_of_type_Qoz	Lqoz;
    //   11915: ldc_w 2153
    //   11918: aconst_null
    //   11919: invokevirtual 2143	qoz:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   11922: ldc_w 2155
    //   11925: ldc 163
    //   11927: invokevirtual 2147	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11930: astore_1
    //   11931: ldc 163
    //   11933: aload_1
    //   11934: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11937: istore 13
    //   11939: iload 13
    //   11941: ifne -7460 -> 4481
    //   11944: new 265	org/json/JSONObject
    //   11947: dup
    //   11948: aload_1
    //   11949: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11952: astore_1
    //   11953: aload_0
    //   11954: aload_2
    //   11955: iconst_1
    //   11956: anewarray 201	java/lang/String
    //   11959: dup
    //   11960: iconst_0
    //   11961: new 265	org/json/JSONObject
    //   11964: dup
    //   11965: invokespecial 266	org/json/JSONObject:<init>	()V
    //   11968: ldc_w 2149
    //   11971: aload_1
    //   11972: invokevirtual 276	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   11975: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   11978: aastore
    //   11979: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11982: goto -7501 -> 4481
    //   11985: astore_1
    //   11986: aload_1
    //   11987: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   11990: goto -7509 -> 4481
    //   11993: ldc_w 2157
    //   11996: aload 4
    //   11998: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12001: ifeq +192 -> 12193
    //   12004: new 265	org/json/JSONObject
    //   12007: dup
    //   12008: aload 5
    //   12010: iconst_0
    //   12011: aaload
    //   12012: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12015: astore_1
    //   12016: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12019: ifeq +30 -> 12049
    //   12022: ldc_w 386
    //   12025: iconst_2
    //   12026: new 388	java/lang/StringBuilder
    //   12029: dup
    //   12030: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12033: ldc_w 2159
    //   12036: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12039: aload_1
    //   12040: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12043: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12046: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12049: aload_1
    //   12050: ldc_w 2161
    //   12053: invokevirtual 2164	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   12056: lstore 18
    //   12058: aload_1
    //   12059: ldc_w 2062
    //   12062: invokevirtual 2060	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   12065: istore 6
    //   12067: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12070: ifeq +42 -> 12112
    //   12073: ldc_w 386
    //   12076: iconst_2
    //   12077: new 388	java/lang/StringBuilder
    //   12080: dup
    //   12081: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12084: ldc_w 2064
    //   12087: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12090: lload 18
    //   12092: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12095: ldc_w 2066
    //   12098: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12101: iload 6
    //   12103: invokevirtual 531	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12106: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12109: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12112: aload_0
    //   12113: getfield 144	sfk:jdField_a_of_type_Wxr	Lwxr;
    //   12116: lload 18
    //   12118: iload 6
    //   12120: invokevirtual 2167	wxr:a	(JI)V
    //   12123: aload_0
    //   12124: getfield 361	sfk:mRuntime	Lbcdp;
    //   12127: invokevirtual 366	bcdp:a	()Landroid/app/Activity;
    //   12130: iconst_m1
    //   12131: new 230	android/content/Intent
    //   12134: dup
    //   12135: invokespecial 438	android/content/Intent:<init>	()V
    //   12138: ldc_w 2062
    //   12141: iload 6
    //   12143: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   12146: invokevirtual 2171	android/app/Activity:setResult	(ILandroid/content/Intent;)V
    //   12149: goto -7668 -> 4481
    //   12152: astore_1
    //   12153: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12156: ifeq +30 -> 12186
    //   12159: ldc_w 386
    //   12162: iconst_2
    //   12163: new 388	java/lang/StringBuilder
    //   12166: dup
    //   12167: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12170: ldc_w 2173
    //   12173: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12176: aload_1
    //   12177: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   12180: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12183: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12186: aload_1
    //   12187: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   12190: goto -7709 -> 4481
    //   12193: ldc_w 2175
    //   12196: aload 4
    //   12198: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12201: ifeq +14 -> 12215
    //   12204: aload_0
    //   12205: aload 4
    //   12207: aload 5
    //   12209: invokespecial 2177	sfk:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12212: goto -7731 -> 4481
    //   12215: ldc_w 2179
    //   12218: aload 4
    //   12220: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12223: ifeq +185 -> 12408
    //   12226: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12229: ifeq +13 -> 12242
    //   12232: ldc_w 386
    //   12235: iconst_2
    //   12236: ldc_w 2181
    //   12239: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12242: aload_0
    //   12243: getfield 148	sfk:jdField_a_of_type_Qvt	Lqvt;
    //   12246: ifnonnull +14 -> 12260
    //   12249: aload_0
    //   12250: new 2183	qvt
    //   12253: dup
    //   12254: invokespecial 2184	qvt:<init>	()V
    //   12257: putfield 148	sfk:jdField_a_of_type_Qvt	Lqvt;
    //   12260: aload_0
    //   12261: getfield 148	sfk:jdField_a_of_type_Qvt	Lqvt;
    //   12264: astore_1
    //   12265: aload_1
    //   12266: new 2186	sga
    //   12269: dup
    //   12270: aload_0
    //   12271: invokespecial 2187	sga:<init>	(Lsfk;)V
    //   12274: invokevirtual 2190	qvt:a	(Lqvw;)V
    //   12277: new 265	org/json/JSONObject
    //   12280: dup
    //   12281: aload 5
    //   12283: iconst_0
    //   12284: aaload
    //   12285: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12288: astore_2
    //   12289: aload_2
    //   12290: ldc_w 415
    //   12293: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12296: astore_3
    //   12297: aload_2
    //   12298: ldc_w 2192
    //   12301: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12304: astore 4
    //   12306: aload_2
    //   12307: ldc_w 2194
    //   12310: iconst_m1
    //   12311: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12314: istore 6
    //   12316: aload_2
    //   12317: ldc_w 2196
    //   12320: iconst_0
    //   12321: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12324: istore 7
    //   12326: aload_2
    //   12327: ldc_w 2198
    //   12330: iconst_0
    //   12331: invokevirtual 484	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   12334: istore 8
    //   12336: aload_2
    //   12337: ldc_w 2200
    //   12340: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12343: astore 5
    //   12345: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12348: ifeq +33 -> 12381
    //   12351: ldc_w 386
    //   12354: iconst_2
    //   12355: new 388	java/lang/StringBuilder
    //   12358: dup
    //   12359: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12362: ldc_w 2202
    //   12365: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12368: aload_2
    //   12369: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12372: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12375: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12378: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12381: aload_1
    //   12382: aload 4
    //   12384: iload 6
    //   12386: iload 7
    //   12388: i2l
    //   12389: iload 8
    //   12391: aload 5
    //   12393: aload_3
    //   12394: invokevirtual 2205	qvt:a	(Ljava/lang/String;IJILjava/lang/String;Ljava/lang/String;)V
    //   12397: goto -7916 -> 4481
    //   12400: astore_1
    //   12401: aload_1
    //   12402: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   12405: goto -7924 -> 4481
    //   12408: ldc_w 2207
    //   12411: aload 4
    //   12413: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12416: ifeq +35 -> 12451
    //   12419: invokestatic 384	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12422: ifeq +13 -> 12435
    //   12425: ldc_w 386
    //   12428: iconst_2
    //   12429: ldc_w 2209
    //   12432: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12435: aload_0
    //   12436: getfield 148	sfk:jdField_a_of_type_Qvt	Lqvt;
    //   12439: astore_1
    //   12440: aload_1
    //   12441: ifnull -7960 -> 4481
    //   12444: aload_1
    //   12445: invokevirtual 2210	qvt:a	()V
    //   12448: goto -7967 -> 4481
    //   12451: ldc_w 2212
    //   12454: aload 4
    //   12456: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12459: ifeq +83 -> 12542
    //   12462: new 321	android/os/Bundle
    //   12465: dup
    //   12466: invokespecial 322	android/os/Bundle:<init>	()V
    //   12469: astore_1
    //   12470: new 265	org/json/JSONObject
    //   12473: dup
    //   12474: aload 5
    //   12476: iconst_0
    //   12477: aaload
    //   12478: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12481: astore_3
    //   12482: aload_3
    //   12483: ldc_w 1199
    //   12486: invokevirtual 2049	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   12489: astore_2
    //   12490: aload_3
    //   12491: ldc_w 2214
    //   12494: ldc 163
    //   12496: invokevirtual 405	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12499: astore_3
    //   12500: aload_1
    //   12501: ldc_w 1199
    //   12504: aload_2
    //   12505: invokevirtual 328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12508: aload_1
    //   12509: ldc_w 2214
    //   12512: aload_3
    //   12513: invokevirtual 328	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   12516: aload_0
    //   12517: getfield 146	sfk:jdField_a_of_type_Qoz	Lqoz;
    //   12520: ifnull -8039 -> 4481
    //   12523: aload_0
    //   12524: getfield 146	sfk:jdField_a_of_type_Qoz	Lqoz;
    //   12527: ldc_w 2216
    //   12530: aload_1
    //   12531: invokevirtual 2143	qoz:a	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   12534: pop
    //   12535: goto -8054 -> 4481
    //   12538: astore_1
    //   12539: goto -8058 -> 4481
    //   12542: ldc_w 2218
    //   12545: aload 4
    //   12547: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12550: ifeq +97 -> 12647
    //   12553: new 265	org/json/JSONObject
    //   12556: dup
    //   12557: aload 5
    //   12559: iconst_0
    //   12560: aaload
    //   12561: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12564: ldc_w 1742
    //   12567: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12570: astore_1
    //   12571: ldc_w 386
    //   12574: iconst_2
    //   12575: new 388	java/lang/StringBuilder
    //   12578: dup
    //   12579: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12582: ldc_w 2220
    //   12585: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12588: aload_1
    //   12589: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12592: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12595: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12598: new 230	android/content/Intent
    //   12601: dup
    //   12602: invokespecial 438	android/content/Intent:<init>	()V
    //   12605: astore_2
    //   12606: aload_2
    //   12607: ldc_w 692
    //   12610: new 1744	java/math/BigInteger
    //   12613: dup
    //   12614: aload_1
    //   12615: invokespecial 1745	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   12618: invokevirtual 1748	java/math/BigInteger:longValue	()J
    //   12621: invokevirtual 1942	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   12624: pop
    //   12625: aload_0
    //   12626: getfield 226	sfk:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   12629: aload_2
    //   12630: ldc_w 2222
    //   12633: invokestatic 2224	com/tencent/mobileqq/activity/PublicFragmentActivity:a	(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Class;)V
    //   12636: goto -8155 -> 4481
    //   12639: astore_1
    //   12640: aload_1
    //   12641: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   12644: goto -8163 -> 4481
    //   12647: ldc_w 2226
    //   12650: aload 4
    //   12652: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12655: ifeq +201 -> 12856
    //   12658: new 265	org/json/JSONObject
    //   12661: dup
    //   12662: aload 5
    //   12664: iconst_0
    //   12665: aaload
    //   12666: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12669: astore_2
    //   12670: aload_2
    //   12671: ldc_w 2228
    //   12674: invokevirtual 411	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   12677: istore 6
    //   12679: aload_2
    //   12680: ldc_w 2230
    //   12683: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12686: astore_3
    //   12687: aload_2
    //   12688: ldc_w 1176
    //   12691: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12694: astore 4
    //   12696: aload_2
    //   12697: ldc_w 415
    //   12700: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12703: astore 5
    //   12705: iload 6
    //   12707: tableswitch	default:+742 -> 13449, 1:+135->12842, 2:+749->13456, 3:+142->12849
    //   12733: aconst_null
    //   12734: ixor
    //   12735: iconst_1
    //   12736: new 388	java/lang/StringBuilder
    //   12739: dup
    //   12740: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   12743: ldc_w 2232
    //   12746: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12749: iload 6
    //   12751: invokevirtual 531	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   12754: ldc_w 2234
    //   12757: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12760: aload_3
    //   12761: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12764: ldc_w 2234
    //   12767: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12770: aload 4
    //   12772: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12775: invokevirtual 396	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12778: invokestatic 552	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12781: aconst_null
    //   12782: ldc 163
    //   12784: aload_1
    //   12785: aload_1
    //   12786: iconst_0
    //   12787: iconst_0
    //   12788: ldc 163
    //   12790: ldc 163
    //   12792: aload_3
    //   12793: aload_2
    //   12794: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12797: iconst_0
    //   12798: invokestatic 2237	nol:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   12801: aload_0
    //   12802: aload 5
    //   12804: iconst_1
    //   12805: anewarray 201	java/lang/String
    //   12808: dup
    //   12809: iconst_0
    //   12810: new 265	org/json/JSONObject
    //   12813: dup
    //   12814: invokespecial 266	org/json/JSONObject:<init>	()V
    //   12817: ldc_w 268
    //   12820: iconst_0
    //   12821: invokevirtual 271	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   12824: invokevirtual 280	org/json/JSONObject:toString	()Ljava/lang/String;
    //   12827: aastore
    //   12828: invokevirtual 284	sfk:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   12831: goto -8350 -> 4481
    //   12834: astore_1
    //   12835: aload_1
    //   12836: invokevirtual 287	org/json/JSONException:printStackTrace	()V
    //   12839: goto -8358 -> 4481
    //   12842: ldc_w 2239
    //   12845: astore_1
    //   12846: goto -114 -> 12732
    //   12849: ldc_w 2241
    //   12852: astore_1
    //   12853: goto -121 -> 12732
    //   12856: ldc_w 2243
    //   12859: aload 4
    //   12861: invokevirtual 470	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12864: ifeq -8383 -> 4481
    //   12867: new 265	org/json/JSONObject
    //   12870: dup
    //   12871: aload 5
    //   12873: iconst_0
    //   12874: aaload
    //   12875: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12878: ldc_w 415
    //   12881: invokevirtual 480	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   12884: astore_1
    //   12885: new 265	org/json/JSONObject
    //   12888: dup
    //   12889: aload 5
    //   12891: iconst_0
    //   12892: aaload
    //   12893: invokespecial 378	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   12896: aload_1
    //   12897: new 2245	sgb
    //   12900: dup
    //   12901: aload_0
    //   12902: invokespecial 2246	sgb:<init>	(Lsfk;)V
    //   12905: invokestatic 2248	sfk:a	(Lorg/json/JSONObject;Ljava/lang/String;Lryd;)V
    //   12908: iconst_1
    //   12909: ireturn
    //   12910: astore_1
    //   12911: ldc_w 386
    //   12914: iconst_1
    //   12915: ldc_w 2250
    //   12918: aload_1
    //   12919: invokestatic 1706	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   12922: goto -14 -> 12908
    //   12925: astore 4
    //   12927: aload_1
    //   12928: astore 42
    //   12930: ldc 163
    //   12932: astore_1
    //   12933: aload_3
    //   12934: astore_2
    //   12935: lload 38
    //   12937: lstore 34
    //   12939: lload 36
    //   12941: lstore 32
    //   12943: aload 42
    //   12945: astore_3
    //   12946: goto -3498 -> 9448
    //   12949: astore 4
    //   12951: ldc 163
    //   12953: astore 42
    //   12955: aload_1
    //   12956: astore_3
    //   12957: aload 42
    //   12959: astore_1
    //   12960: lload 38
    //   12962: lstore 34
    //   12964: lload 36
    //   12966: lstore 32
    //   12968: goto -3520 -> 9448
    //   12971: astore 4
    //   12973: aload_1
    //   12974: astore 42
    //   12976: aload_3
    //   12977: astore_1
    //   12978: lload 30
    //   12980: lstore 24
    //   12982: lload 28
    //   12984: lstore 22
    //   12986: lload 26
    //   12988: lstore 18
    //   12990: aload 42
    //   12992: astore_3
    //   12993: goto -3545 -> 9448
    //   12996: astore 4
    //   12998: aload_1
    //   12999: astore 42
    //   13001: ldc 163
    //   13003: astore_1
    //   13004: aload_3
    //   13005: astore_2
    //   13006: lload 38
    //   13008: lstore 34
    //   13010: lload 36
    //   13012: lstore 32
    //   13014: aload 42
    //   13016: astore_3
    //   13017: goto -6161 -> 6856
    //   13020: astore 4
    //   13022: ldc 163
    //   13024: astore 42
    //   13026: aload_1
    //   13027: astore_3
    //   13028: aload 42
    //   13030: astore_1
    //   13031: lload 38
    //   13033: lstore 34
    //   13035: lload 36
    //   13037: lstore 32
    //   13039: goto -6183 -> 6856
    //   13042: astore 4
    //   13044: aload_1
    //   13045: astore 42
    //   13047: aload_3
    //   13048: astore_1
    //   13049: lload 30
    //   13051: lstore 24
    //   13053: lload 28
    //   13055: lstore 22
    //   13057: lload 26
    //   13059: lstore 18
    //   13061: aload 42
    //   13063: astore_3
    //   13064: goto -6208 -> 6856
    //   13067: astore_1
    //   13068: iload 14
    //   13070: istore 13
    //   13072: goto -8836 -> 4236
    //   13075: iconst_0
    //   13076: istore 7
    //   13078: goto -1896 -> 11182
    //   13081: iconst_m1
    //   13082: istore 6
    //   13084: goto -1924 -> 11160
    //   13087: ldc 163
    //   13089: astore_2
    //   13090: goto -1952 -> 11138
    //   13093: ldc 163
    //   13095: astore_1
    //   13096: goto -1993 -> 11103
    //   13099: iconst_1
    //   13100: istore 14
    //   13102: goto -2034 -> 11068
    //   13105: iconst_0
    //   13106: istore 13
    //   13108: goto -2061 -> 11047
    //   13111: aload 5
    //   13113: astore_1
    //   13114: goto -2614 -> 10500
    //   13117: aload 40
    //   13119: astore_2
    //   13120: goto -3025 -> 10095
    //   13123: aload 5
    //   13125: astore_1
    //   13126: goto -5080 -> 8046
    //   13129: aload 40
    //   13131: astore_2
    //   13132: goto -5491 -> 7641
    //   13135: aconst_null
    //   13136: astore_1
    //   13137: goto -8779 -> 4358
    //   13140: iconst_0
    //   13141: istore 13
    //   13143: goto -8907 -> 4236
    //   13146: iconst_0
    //   13147: istore 6
    //   13149: goto -10575 -> 2574
    //   13152: goto -10625 -> 2527
    //   13155: iconst_1
    //   13156: ireturn
    //   13157: iconst_1
    //   13158: ireturn
    //   13159: bipush 9
    //   13161: istore 8
    //   13163: goto -10636 -> 2527
    //   13166: iconst_1
    //   13167: ireturn
    //   13168: iconst_1
    //   13169: ireturn
    //   13170: iconst_1
    //   13171: ireturn
    //   13172: iload 10
    //   13174: iconst_1
    //   13175: if_icmpeq -8958 -> 4217
    //   13178: iload 10
    //   13180: iconst_2
    //   13181: if_icmpne -41 -> 13140
    //   13184: goto -8967 -> 4217
    //   13187: iconst_1
    //   13188: ireturn
    //   13189: ldc_w 2252
    //   13192: astore_1
    //   13193: goto -8077 -> 5116
    //   13196: ldc_w 2252
    //   13199: astore_2
    //   13200: goto -8073 -> 5127
    //   13203: goto -7418 -> 5785
    //   13206: astore 4
    //   13208: aload_3
    //   13209: astore_2
    //   13210: ldc 163
    //   13212: astore_1
    //   13213: lload 38
    //   13215: lstore 34
    //   13217: lload 36
    //   13219: lstore 32
    //   13221: aload 42
    //   13223: astore_3
    //   13224: goto -6368 -> 6856
    //   13227: iconst_1
    //   13228: istore 6
    //   13230: goto -5677 -> 7553
    //   13233: iload 12
    //   13235: iconst_4
    //   13236: if_icmpeq -5363 -> 7873
    //   13239: iload 12
    //   13241: iconst_5
    //   13242: if_icmpne -5273 -> 7969
    //   13245: goto -5372 -> 7873
    //   13248: iconst_2
    //   13249: istore 6
    //   13251: goto -5698 -> 7553
    //   13254: goto -5701 -> 7553
    //   13257: iload 9
    //   13259: bipush 11
    //   13261: if_icmpne +9 -> 13270
    //   13264: iconst_5
    //   13265: istore 6
    //   13267: goto -5507 -> 7760
    //   13270: iload 9
    //   13272: bipush 6
    //   13274: if_icmpne +10 -> 13284
    //   13277: bipush 6
    //   13279: istore 6
    //   13281: goto -5521 -> 7760
    //   13284: iload 9
    //   13286: bipush 12
    //   13288: if_icmpne +10 -> 13298
    //   13291: bipush 7
    //   13293: istore 6
    //   13295: goto -5535 -> 7760
    //   13298: iload 9
    //   13300: bipush 13
    //   13302: if_icmpne +10 -> 13312
    //   13305: bipush 8
    //   13307: istore 6
    //   13309: goto -5549 -> 7760
    //   13312: iload 9
    //   13314: bipush 15
    //   13316: if_icmplt -5556 -> 7760
    //   13319: iload 9
    //   13321: istore 6
    //   13323: goto -5563 -> 7760
    //   13326: goto -4949 -> 8377
    //   13329: astore 4
    //   13331: aload_3
    //   13332: astore_2
    //   13333: ldc 163
    //   13335: astore_1
    //   13336: lload 38
    //   13338: lstore 34
    //   13340: lload 36
    //   13342: lstore 32
    //   13344: aload 42
    //   13346: astore_3
    //   13347: goto -3899 -> 9448
    //   13350: iconst_1
    //   13351: istore 6
    //   13353: goto -3346 -> 10007
    //   13356: iload 12
    //   13358: iconst_4
    //   13359: if_icmpeq -3032 -> 10327
    //   13362: iload 12
    //   13364: iconst_5
    //   13365: if_icmpne -2942 -> 10423
    //   13368: goto -3041 -> 10327
    //   13371: iconst_2
    //   13372: istore 6
    //   13374: goto -3367 -> 10007
    //   13377: goto -3370 -> 10007
    //   13380: iload 9
    //   13382: bipush 11
    //   13384: if_icmpne +9 -> 13393
    //   13387: iconst_5
    //   13388: istore 6
    //   13390: goto -3176 -> 10214
    //   13393: iload 9
    //   13395: bipush 6
    //   13397: if_icmpne +10 -> 13407
    //   13400: bipush 6
    //   13402: istore 6
    //   13404: goto -3190 -> 10214
    //   13407: iload 9
    //   13409: bipush 12
    //   13411: if_icmpne +10 -> 13421
    //   13414: bipush 7
    //   13416: istore 6
    //   13418: goto -3204 -> 10214
    //   13421: iload 9
    //   13423: bipush 13
    //   13425: if_icmpne +10 -> 13435
    //   13428: bipush 8
    //   13430: istore 6
    //   13432: goto -3218 -> 10214
    //   13435: iload 9
    //   13437: bipush 15
    //   13439: if_icmplt -3225 -> 10214
    //   13442: iload 9
    //   13444: istore 6
    //   13446: goto -3232 -> 10214
    //   13449: ldc_w 2254
    //   13452: astore_1
    //   13453: goto -721 -> 12732
    //   13456: ldc_w 2256
    //   13459: astore_1
    //   13460: goto -728 -> 12732
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	13463	0	this	sfk
    //   0	13463	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	13463	2	paramString1	String
    //   0	13463	3	paramString2	String
    //   0	13463	4	paramString3	String
    //   0	13463	5	paramVarArgs	String[]
    //   492	12953	6	i1	int
    //   2579	10498	7	i2	int
    //   2509	10653	8	i3	int
    //   2575	10868	9	i4	int
    //   3947	9235	10	i5	int
    //   6434	4164	11	i6	int
    //   7039	6327	12	i7	int
    //   352	12790	13	bool1	boolean
    //   4086	9015	14	bool2	boolean
    //   4861	51	15	bool3	boolean
    //   4873	49	16	bool4	boolean
    //   4885	47	17	bool5	boolean
    //   5827	7233	18	l1	long
    //   5897	4365	20	l2	long
    //   5830	7226	22	l3	long
    //   5833	7219	24	l4	long
    //   5917	7141	26	l5	long
    //   5913	7141	28	l6	long
    //   5909	7141	30	l7	long
    //   5905	7438	32	l8	long
    //   5901	7438	34	l9	long
    //   5836	7505	36	l10	long
    //   5839	7498	38	l11	long
    //   5843	1029	40	localObject1	Object
    //   6877	20	40	localJSONException1	JSONException
    //   6911	2553	40	localObject2	Object
    //   9469	3	40	localJSONException2	JSONException
    //   9477	3653	40	str1	String
    //   5772	4525	41	str2	String
    //   5753	7592	42	localObject3	Object
    //   5706	4679	43	localObject4	Object
    //   6443	4157	44	localArticleInfo	com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
    //   6382	3650	45	str3	String
    //   6423	3616	46	str4	String
    //   6619	3796	47	localObject5	Object
    //   6628	187	48	localObject6	Object
    //   6916	20	48	localException1	Exception
    //   7125	2282	48	localObject7	Object
    //   9482	3	48	localException2	Exception
    //   9639	218	48	localBiuCommentInfo	com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo
    //   6728	587	49	localObject8	Object
    //   7359	20	49	localException3	Exception
    //   9320	509	49	localObject9	Object
    //   9873	3	49	localException4	Exception
    //   6738	3050	50	str5	String
    //   7244	2553	51	str6	String
    // Exception table:
    //   from	to	target	type
    //   31	100	134	org/json/JSONException
    //   100	104	134	org/json/JSONException
    //   164	196	198	org/json/JSONException
    //   228	297	303	org/json/JSONException
    //   297	301	303	org/json/JSONException
    //   333	413	421	org/json/JSONException
    //   413	419	421	org/json/JSONException
    //   451	487	609	org/json/JSONException
    //   494	514	609	org/json/JSONException
    //   523	574	609	org/json/JSONException
    //   574	579	609	org/json/JSONException
    //   639	675	797	org/json/JSONException
    //   682	702	797	org/json/JSONException
    //   711	762	797	org/json/JSONException
    //   762	767	797	org/json/JSONException
    //   827	896	930	org/json/JSONException
    //   896	900	930	org/json/JSONException
    //   960	1029	1063	org/json/JSONException
    //   1029	1033	1063	org/json/JSONException
    //   1093	1162	1196	org/json/JSONException
    //   1162	1166	1196	org/json/JSONException
    //   1226	1295	1329	org/json/JSONException
    //   1295	1299	1329	org/json/JSONException
    //   1359	1418	1673	org/json/JSONException
    //   1423	1431	1673	org/json/JSONException
    //   1431	1466	1673	org/json/JSONException
    //   1468	1512	1673	org/json/JSONException
    //   1514	1523	1673	org/json/JSONException
    //   1523	1545	1673	org/json/JSONException
    //   1549	1579	1673	org/json/JSONException
    //   1581	1639	1673	org/json/JSONException
    //   1703	1759	1926	org/json/JSONException
    //   1759	1774	1926	org/json/JSONException
    //   1776	1784	1926	org/json/JSONException
    //   1784	1804	1926	org/json/JSONException
    //   1808	1838	1926	org/json/JSONException
    //   1840	1893	1926	org/json/JSONException
    //   2005	2049	2081	org/json/JSONException
    //   1956	2000	2089	org/json/JSONException
    //   2049	2078	2089	org/json/JSONException
    //   2082	2086	2089	org/json/JSONException
    //   2097	2127	2089	org/json/JSONException
    //   2127	2160	2089	org/json/JSONException
    //   2200	2204	2089	org/json/JSONException
    //   2207	2226	2089	org/json/JSONException
    //   2246	2262	2089	org/json/JSONException
    //   2266	2270	2089	org/json/JSONException
    //   2273	2282	2089	org/json/JSONException
    //   2160	2196	2199	org/json/JSONException
    //   2226	2246	2265	org/json/JSONException
    //   2356	2400	2432	org/json/JSONException
    //   2307	2351	2440	org/json/JSONException
    //   2400	2429	2440	org/json/JSONException
    //   2433	2437	2440	org/json/JSONException
    //   2448	2457	2440	org/json/JSONException
    //   2482	2511	2699	org/json/JSONException
    //   2527	2543	2699	org/json/JSONException
    //   2547	2571	2699	org/json/JSONException
    //   2589	2613	2699	org/json/JSONException
    //   2616	2656	2699	org/json/JSONException
    //   2659	2669	2699	org/json/JSONException
    //   2675	2684	2699	org/json/JSONException
    //   2729	2788	2826	org/json/JSONException
    //   2788	2795	2826	org/json/JSONException
    //   2795	2824	2826	org/json/JSONException
    //   2931	2977	2980	org/json/JSONException
    //   2856	2900	2988	org/json/JSONException
    //   2900	2929	2988	org/json/JSONException
    //   2981	2985	2988	org/json/JSONException
    //   3152	3172	3251	org/json/JSONException
    //   3018	3081	3259	org/json/JSONException
    //   3083	3113	3259	org/json/JSONException
    //   3113	3152	3259	org/json/JSONException
    //   3172	3201	3259	org/json/JSONException
    //   3201	3219	3259	org/json/JSONException
    //   3219	3248	3259	org/json/JSONException
    //   3252	3256	3259	org/json/JSONException
    //   3287	3316	3259	org/json/JSONException
    //   3320	3324	3259	org/json/JSONException
    //   3327	3335	3259	org/json/JSONException
    //   3377	3381	3259	org/json/JSONException
    //   3267	3287	3319	org/json/JSONException
    //   3335	3373	3376	org/json/JSONException
    //   3505	3541	3602	org/json/JSONException
    //   3406	3471	3610	org/json/JSONException
    //   3471	3505	3610	org/json/JSONException
    //   3541	3570	3610	org/json/JSONException
    //   3570	3599	3610	org/json/JSONException
    //   3603	3607	3610	org/json/JSONException
    //   3640	3707	3783	org/json/JSONException
    //   3707	3752	3783	org/json/JSONException
    //   3752	3781	3783	org/json/JSONException
    //   3813	3833	3835	org/json/JSONException
    //   3865	3885	3887	org/json/JSONException
    //   3917	3949	4054	org/json/JSONException
    //   3969	4002	4054	org/json/JSONException
    //   4002	4035	4054	org/json/JSONException
    //   4035	4052	4054	org/json/JSONException
    //   4308	4349	4476	org/json/JSONException
    //   4353	4358	4476	org/json/JSONException
    //   4358	4400	4476	org/json/JSONException
    //   4404	4409	4476	org/json/JSONException
    //   4412	4433	4476	org/json/JSONException
    //   4442	4464	4476	org/json/JSONException
    //   4468	4474	4476	org/json/JSONException
    //   4494	4580	4616	org/json/JSONException
    //   4580	4613	4616	org/json/JSONException
    //   4646	4716	4991	org/json/JSONException
    //   4719	4724	4991	org/json/JSONException
    //   4736	4753	4991	org/json/JSONException
    //   4756	4773	4991	org/json/JSONException
    //   4777	4788	4991	org/json/JSONException
    //   4792	4823	4991	org/json/JSONException
    //   4827	4989	4991	org/json/JSONException
    //   5105	5112	5222	org/json/JSONException
    //   5116	5123	5222	org/json/JSONException
    //   5127	5154	5222	org/json/JSONException
    //   5159	5206	5222	org/json/JSONException
    //   5209	5219	5222	org/json/JSONException
    //   5259	5308	5354	org/json/JSONException
    //   5308	5331	5354	org/json/JSONException
    //   5403	5454	5500	java/lang/Exception
    //   5454	5477	5500	java/lang/Exception
    //   5549	5597	5646	java/lang/Exception
    //   5597	5620	5646	java/lang/Exception
    //   6507	6517	6877	org/json/JSONException
    //   6790	6828	6916	java/lang/Exception
    //   5695	5745	6952	org/json/JSONException
    //   5745	5782	6952	org/json/JSONException
    //   5785	5795	6952	org/json/JSONException
    //   5805	5826	6952	org/json/JSONException
    //   5845	5859	6952	org/json/JSONException
    //   5859	5872	6952	org/json/JSONException
    //   5872	5891	6952	org/json/JSONException
    //   5919	5926	6952	org/json/JSONException
    //   5946	5959	6952	org/json/JSONException
    //   5979	5989	6952	org/json/JSONException
    //   6013	6021	6952	org/json/JSONException
    //   6041	6055	6952	org/json/JSONException
    //   6075	6085	6952	org/json/JSONException
    //   6109	6117	6952	org/json/JSONException
    //   6137	6151	6952	org/json/JSONException
    //   6171	6181	6952	org/json/JSONException
    //   6205	6213	6952	org/json/JSONException
    //   6233	6247	6952	org/json/JSONException
    //   6267	6277	6952	org/json/JSONException
    //   6297	6307	6952	org/json/JSONException
    //   6343	6507	6952	org/json/JSONException
    //   6517	6594	6952	org/json/JSONException
    //   6602	6784	6952	org/json/JSONException
    //   6790	6828	6952	org/json/JSONException
    //   6828	6847	6952	org/json/JSONException
    //   6856	6861	6952	org/json/JSONException
    //   6879	6910	6952	org/json/JSONException
    //   6918	6949	6952	org/json/JSONException
    //   6986	6996	6952	org/json/JSONException
    //   7005	7061	6952	org/json/JSONException
    //   7066	7105	6952	org/json/JSONException
    //   7108	7290	6952	org/json/JSONException
    //   7290	7328	6952	org/json/JSONException
    //   7328	7350	6952	org/json/JSONException
    //   7361	7392	6952	org/json/JSONException
    //   7429	7454	6952	org/json/JSONException
    //   7466	7503	6952	org/json/JSONException
    //   7508	7550	6952	org/json/JSONException
    //   7560	7609	6952	org/json/JSONException
    //   7609	7638	6952	org/json/JSONException
    //   7641	7715	6952	org/json/JSONException
    //   7715	7748	6952	org/json/JSONException
    //   7760	7835	6952	org/json/JSONException
    //   7842	7861	6952	org/json/JSONException
    //   7861	7871	6952	org/json/JSONException
    //   7873	7910	6952	org/json/JSONException
    //   7915	7966	6952	org/json/JSONException
    //   7975	7982	6952	org/json/JSONException
    //   7991	8046	6952	org/json/JSONException
    //   8048	8055	6952	org/json/JSONException
    //   8059	8148	6952	org/json/JSONException
    //   8151	8252	6952	org/json/JSONException
    //   7290	7328	7359	java/lang/Exception
    //   5695	5745	7395	java/lang/NumberFormatException
    //   5745	5782	7395	java/lang/NumberFormatException
    //   5785	5795	7395	java/lang/NumberFormatException
    //   5805	5826	7395	java/lang/NumberFormatException
    //   5845	5859	7395	java/lang/NumberFormatException
    //   5859	5872	7395	java/lang/NumberFormatException
    //   5872	5891	7395	java/lang/NumberFormatException
    //   5919	5926	7395	java/lang/NumberFormatException
    //   5946	5959	7395	java/lang/NumberFormatException
    //   5979	5989	7395	java/lang/NumberFormatException
    //   6013	6021	7395	java/lang/NumberFormatException
    //   6041	6055	7395	java/lang/NumberFormatException
    //   6075	6085	7395	java/lang/NumberFormatException
    //   6109	6117	7395	java/lang/NumberFormatException
    //   6137	6151	7395	java/lang/NumberFormatException
    //   6171	6181	7395	java/lang/NumberFormatException
    //   6205	6213	7395	java/lang/NumberFormatException
    //   6233	6247	7395	java/lang/NumberFormatException
    //   6267	6277	7395	java/lang/NumberFormatException
    //   6297	6307	7395	java/lang/NumberFormatException
    //   6343	6507	7395	java/lang/NumberFormatException
    //   6507	6517	7395	java/lang/NumberFormatException
    //   6517	6594	7395	java/lang/NumberFormatException
    //   6602	6784	7395	java/lang/NumberFormatException
    //   6790	6828	7395	java/lang/NumberFormatException
    //   6828	6847	7395	java/lang/NumberFormatException
    //   6856	6861	7395	java/lang/NumberFormatException
    //   6879	6910	7395	java/lang/NumberFormatException
    //   6918	6949	7395	java/lang/NumberFormatException
    //   6986	6996	7395	java/lang/NumberFormatException
    //   7005	7061	7395	java/lang/NumberFormatException
    //   7066	7105	7395	java/lang/NumberFormatException
    //   7108	7290	7395	java/lang/NumberFormatException
    //   7290	7328	7395	java/lang/NumberFormatException
    //   7328	7350	7395	java/lang/NumberFormatException
    //   7361	7392	7395	java/lang/NumberFormatException
    //   7429	7454	7395	java/lang/NumberFormatException
    //   7466	7503	7395	java/lang/NumberFormatException
    //   7508	7550	7395	java/lang/NumberFormatException
    //   7560	7609	7395	java/lang/NumberFormatException
    //   7609	7638	7395	java/lang/NumberFormatException
    //   7641	7715	7395	java/lang/NumberFormatException
    //   7715	7748	7395	java/lang/NumberFormatException
    //   7760	7835	7395	java/lang/NumberFormatException
    //   7842	7861	7395	java/lang/NumberFormatException
    //   7861	7871	7395	java/lang/NumberFormatException
    //   7873	7910	7395	java/lang/NumberFormatException
    //   7915	7966	7395	java/lang/NumberFormatException
    //   7975	7982	7395	java/lang/NumberFormatException
    //   7991	8046	7395	java/lang/NumberFormatException
    //   8048	8055	7395	java/lang/NumberFormatException
    //   8059	8148	7395	java/lang/NumberFormatException
    //   8151	8252	7395	java/lang/NumberFormatException
    //   9099	9109	9469	org/json/JSONException
    //   9382	9420	9482	java/lang/Exception
    //   8277	8337	9492	org/json/JSONException
    //   8337	8374	9492	org/json/JSONException
    //   8377	8387	9492	org/json/JSONException
    //   8397	8418	9492	org/json/JSONException
    //   8437	8451	9492	org/json/JSONException
    //   8451	8464	9492	org/json/JSONException
    //   8464	8483	9492	org/json/JSONException
    //   8511	8518	9492	org/json/JSONException
    //   8538	8551	9492	org/json/JSONException
    //   8571	8581	9492	org/json/JSONException
    //   8605	8613	9492	org/json/JSONException
    //   8633	8647	9492	org/json/JSONException
    //   8667	8677	9492	org/json/JSONException
    //   8701	8709	9492	org/json/JSONException
    //   8729	8743	9492	org/json/JSONException
    //   8763	8773	9492	org/json/JSONException
    //   8797	8805	9492	org/json/JSONException
    //   8825	8839	9492	org/json/JSONException
    //   8859	8869	9492	org/json/JSONException
    //   8889	8899	9492	org/json/JSONException
    //   8935	9099	9492	org/json/JSONException
    //   9109	9186	9492	org/json/JSONException
    //   9194	9376	9492	org/json/JSONException
    //   9382	9420	9492	org/json/JSONException
    //   9420	9439	9492	org/json/JSONException
    //   9448	9453	9492	org/json/JSONException
    //   9471	9476	9492	org/json/JSONException
    //   9484	9489	9492	org/json/JSONException
    //   9500	9510	9492	org/json/JSONException
    //   9519	9575	9492	org/json/JSONException
    //   9580	9619	9492	org/json/JSONException
    //   9622	9804	9492	org/json/JSONException
    //   9804	9842	9492	org/json/JSONException
    //   9842	9864	9492	org/json/JSONException
    //   9875	9880	9492	org/json/JSONException
    //   9883	9908	9492	org/json/JSONException
    //   9920	9957	9492	org/json/JSONException
    //   9962	10004	9492	org/json/JSONException
    //   10014	10063	9492	org/json/JSONException
    //   10063	10092	9492	org/json/JSONException
    //   10095	10169	9492	org/json/JSONException
    //   10169	10202	9492	org/json/JSONException
    //   10214	10289	9492	org/json/JSONException
    //   10296	10315	9492	org/json/JSONException
    //   10315	10325	9492	org/json/JSONException
    //   10327	10364	9492	org/json/JSONException
    //   10369	10420	9492	org/json/JSONException
    //   10429	10436	9492	org/json/JSONException
    //   10445	10500	9492	org/json/JSONException
    //   10502	10509	9492	org/json/JSONException
    //   10513	10604	9492	org/json/JSONException
    //   10607	10627	9492	org/json/JSONException
    //   9804	9842	9873	java/lang/Exception
    //   10697	10745	10748	java/lang/Exception
    //   10834	10875	10878	org/json/JSONException
    //   10886	10891	10878	org/json/JSONException
    //   10905	10980	10994	org/json/JSONException
    //   10980	10991	10994	org/json/JSONException
    //   11013	11047	11387	org/json/JSONException
    //   11047	11068	11387	org/json/JSONException
    //   11068	11088	11387	org/json/JSONException
    //   11088	11101	11387	org/json/JSONException
    //   11103	11123	11387	org/json/JSONException
    //   11123	11136	11387	org/json/JSONException
    //   11138	11160	11387	org/json/JSONException
    //   11160	11182	11387	org/json/JSONException
    //   11185	11207	11387	org/json/JSONException
    //   11207	11351	11387	org/json/JSONException
    //   11356	11370	11387	org/json/JSONException
    //   11370	11384	11387	org/json/JSONException
    //   11396	11400	11387	org/json/JSONException
    //   11404	11408	11387	org/json/JSONException
    //   11088	11101	11395	java/lang/Exception
    //   11123	11136	11403	java/lang/Exception
    //   11446	11464	11535	java/lang/Exception
    //   11466	11474	11535	java/lang/Exception
    //   11476	11488	11535	java/lang/Exception
    //   11490	11501	11535	java/lang/Exception
    //   11503	11532	11535	java/lang/Exception
    //   11573	11585	11704	java/lang/Exception
    //   11587	11595	11704	java/lang/Exception
    //   11597	11605	11704	java/lang/Exception
    //   11607	11616	11704	java/lang/Exception
    //   11621	11630	11704	java/lang/Exception
    //   11632	11650	11704	java/lang/Exception
    //   11661	11670	11704	java/lang/Exception
    //   11672	11701	11704	java/lang/Exception
    //   11844	11882	11885	org/json/JSONException
    //   11738	11778	11893	org/json/JSONException
    //   11781	11801	11893	org/json/JSONException
    //   11801	11839	11893	org/json/JSONException
    //   11886	11890	11893	org/json/JSONException
    //   11901	11939	11893	org/json/JSONException
    //   11986	11990	11893	org/json/JSONException
    //   11944	11982	11985	org/json/JSONException
    //   12004	12049	12152	org/json/JSONException
    //   12049	12112	12152	org/json/JSONException
    //   12112	12149	12152	org/json/JSONException
    //   12265	12381	12400	org/json/JSONException
    //   12381	12397	12400	org/json/JSONException
    //   12470	12535	12538	org/json/JSONException
    //   12553	12636	12639	org/json/JSONException
    //   12658	12705	12834	org/json/JSONException
    //   12732	12831	12834	org/json/JSONException
    //   12867	12908	12910	org/json/JSONException
    //   8451	8464	12925	java/lang/Exception
    //   8464	8483	12949	java/lang/Exception
    //   8511	8518	12971	java/lang/Exception
    //   8538	8551	12971	java/lang/Exception
    //   8571	8581	12971	java/lang/Exception
    //   8605	8613	12971	java/lang/Exception
    //   8633	8647	12971	java/lang/Exception
    //   8667	8677	12971	java/lang/Exception
    //   8701	8709	12971	java/lang/Exception
    //   8729	8743	12971	java/lang/Exception
    //   8763	8773	12971	java/lang/Exception
    //   8797	8805	12971	java/lang/Exception
    //   8825	8839	12971	java/lang/Exception
    //   8859	8869	12971	java/lang/Exception
    //   8889	8899	12971	java/lang/Exception
    //   5859	5872	12996	java/lang/Exception
    //   5872	5891	13020	java/lang/Exception
    //   5919	5926	13042	java/lang/Exception
    //   5946	5959	13042	java/lang/Exception
    //   5979	5989	13042	java/lang/Exception
    //   6013	6021	13042	java/lang/Exception
    //   6041	6055	13042	java/lang/Exception
    //   6075	6085	13042	java/lang/Exception
    //   6109	6117	13042	java/lang/Exception
    //   6137	6151	13042	java/lang/Exception
    //   6171	6181	13042	java/lang/Exception
    //   6205	6213	13042	java/lang/Exception
    //   6233	6247	13042	java/lang/Exception
    //   6267	6277	13042	java/lang/Exception
    //   6297	6307	13042	java/lang/Exception
    //   4107	4172	13067	org/json/JSONException
    //   4188	4200	13067	org/json/JSONException
    //   4217	4233	13067	org/json/JSONException
    //   5845	5859	13206	java/lang/Exception
    //   8437	8451	13329	java/lang/Exception
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Wxr != null) {
      this.jdField_a_of_type_Wxr.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.n = "";
    this.o = "";
    this.p = "";
  }
  
  public void j()
  {
    Object localObject = ajsd.aW + "c2bCAM/";
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retCode", "-1");
        ((JSONObject)localObject).put("msg", "no sdcard");
        callJs(this.o, new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    this.p = UUID.randomUUID().toString();
    this.n = ((String)localObject + this.p + ".jpg");
    localObject = new Intent();
    FileProvider7Helper.setSystemCapture(this.jdField_a_of_type_AndroidAppActivity, new File(this.n), (Intent)localObject);
    try
    {
      startActivityForResult((Intent)localObject, (byte)112);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void k()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        l();
      }
      while (!this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559386);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371557)).setText(ajya.a(2131708818));
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  void l()
  {
    if ((this.jdField_a_of_type_AndroidAppProgressDialog != null) && (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Wxr == null) {
      this.jdField_a_of_type_Wxr = wxr.a();
    }
    this.jdField_a_of_type_Wxr.e();
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    Object localObject1;
    if (paramByte == 1)
    {
      if (paramIntent != null) {
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("retCode", 0);
        ((JSONObject)localObject1).put("msg", "Success");
        paramIntent = paramIntent.getStringExtra("scanResult");
        if (this.jdField_c_of_type_Int != 1) {}
      }
      catch (JSONException localJSONException)
      {
        try
        {
          ((JSONObject)localObject1).put("scanResult", paramIntent);
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject1).toString() });
          }
          this.jdField_c_of_type_Int = -1;
          this.jdField_d_of_type_Int = -1;
          return;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
    }
    Object localObject2;
    if (paramByte == 112)
    {
      paramIntent = new File(this.n);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      if (paramIntent != null) {
        try
        {
          if (paramIntent.exists())
          {
            ThreadManager.getFileThreadHandler().post(new PublicAccountH5AbilityPlugin.2(this, (JSONArray)localObject2, (JSONObject)localObject1));
            return;
          }
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      ((JSONObject)localObject1).put("retCode", 1);
      ((JSONObject)localObject1).put("msg", "cancel");
      ((JSONObject)localObject1).put("sourceType", "camera");
      callJs(this.o, new String[] { ((JSONObject)localObject1).toString() });
      this.n = "";
      this.o = "";
      this.p = "";
      return;
    }
    Object localObject3;
    if (paramByte == 111)
    {
      localObject2 = new JSONObject();
      localObject3 = new JSONArray();
      if (paramIntent != null) {}
      for (localObject1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");; localObject1 = null)
      {
        paramInt = 0;
        if (localObject1 != null) {}
        try
        {
          if (((ArrayList)localObject1).size() != 0) {
            break;
          }
          ((JSONObject)localObject2).put("retCode", 1);
          ((JSONObject)localObject2).put("msg", "");
          ((JSONObject)localObject2).put("sourceType", "album");
          callJs(this.o, new String[] { ((JSONObject)localObject2).toString() });
          this.o = "";
          return;
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 0) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label1668;
      }
      ThreadManager.getFileThreadHandler().post(new PublicAccountH5AbilityPlugin.3(this, (ArrayList)localObject1, (JSONArray)localObject3, (JSONObject)localObject2));
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt < ((ArrayList)localObject1).size())
        {
          paramIntent = UUID.randomUUID();
          paramIntent = "mqqpa://resourceid/" + paramIntent.toString();
          ((JSONArray)localObject3).put(paramInt, paramIntent);
          jdField_b_of_type_JavaUtilHashMap.put(paramIntent, ((ArrayList)localObject1).get(paramInt));
          paramInt += 1;
        }
        else
        {
          ((JSONObject)localObject2).put("value", localObject3);
          ((JSONObject)localObject2).put("retCode", 0);
          ((JSONObject)localObject2).put("msg", "Success");
          ((JSONObject)localObject2).put("sourceType", "album");
          callJs(this.o, new String[] { ((JSONObject)localObject2).toString() });
          this.o = "";
          axqy.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
          return;
          if (paramByte == 113)
          {
            int i1 = -1;
            if (paramInt == -1) {
              i1 = 0;
            }
            if (paramIntent == null) {
              break;
            }
            localObject1 = paramIntent.getStringExtra("result_js_callback");
            localObject2 = paramIntent.getStringExtra("feed_id");
            paramInt = paramIntent.getIntExtra("feedsType", 1);
            if ((localObject1 == null) || (localObject2 == null)) {
              break;
            }
            paramIntent = new JSONObject();
            try
            {
              paramIntent.put("feedsId", localObject2);
              paramIntent.put("retCode", i1);
              paramIntent.put("feedsType", paramInt);
              callJs((String)localObject1, new String[] { paramIntent.toString() });
              return;
            }
            catch (Exception paramIntent)
            {
              return;
            }
          }
          if ((paramByte == 114) || (paramByte == 115) || (paramByte == 116) || (paramByte == 122))
          {
            if (paramIntent == null) {
              break;
            }
            localObject3 = paramIntent.getStringExtra("arg_callback");
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break;
            }
            localObject2 = "";
            localObject1 = localObject2;
            switch (paramByte)
            {
            default: 
              localObject1 = localObject2;
            }
            for (;;)
            {
              if (paramInt != -1) {
                break label990;
              }
              paramIntent = paramIntent.getStringExtra("arg_result_json");
              if (paramIntent == null) {
                break;
              }
              try
              {
                paramIntent = new JSONObject(paramIntent);
                paramIntent.put("retCode", 0);
                paramIntent = paramIntent.toString();
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, (String)localObject1 + " result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
                }
                callJs((String)localObject3, new String[] { paramIntent });
                return;
              }
              catch (Exception paramIntent)
              {
                return;
              }
              localObject1 = "showUGCEditPage";
              continue;
              localObject1 = "showUGCVideoUploadPage";
              continue;
              localObject1 = "showUGCVideoRecordPage";
              continue;
              localObject1 = "showQAAskEditor";
            }
            try
            {
              label990:
              paramIntent = new JSONObject();
              paramIntent.put("retCode", -1);
              paramIntent = paramIntent.toString();
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountH5AbilityPlugin", 2, (String)localObject1 + " result:" + paramIntent);
              }
              callJs((String)localObject3, new String[] { paramIntent });
              return;
            }
            catch (Exception paramIntent)
            {
              return;
            }
          }
          if ((paramByte == 118) || (paramByte == 121))
          {
            localObject2 = "";
            localObject1 = localObject2;
            switch (paramByte)
            {
            default: 
              localObject1 = localObject2;
            }
            for (;;)
            {
              if (paramIntent != null) {
                break label1254;
              }
              if (paramInt != 0) {
                break;
              }
              try
              {
                paramIntent = new JSONObject();
                paramIntent.put("retCode", 1);
                paramIntent.put("msg", ajya.a(2131708796));
                paramIntent = paramIntent.toString();
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
                }
                callJs((String)localObject1, new String[] { paramIntent });
                return;
              }
              catch (Exception paramIntent) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
              return;
              localObject1 = i;
              continue;
              localObject1 = j;
            }
            label1254:
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            if (paramInt == -1)
            {
              localObject2 = paramIntent.getBundleExtra("Bundle");
              if (localObject2 == null) {
                break;
              }
              paramInt = ((Bundle)localObject2).getInt("retCode");
              paramIntent = ((Bundle)localObject2).getString("url");
              localObject2 = ((Bundle)localObject2).getString("msg");
              try
              {
                localObject3 = new JSONObject();
                ((JSONObject)localObject3).put("retCode", paramInt);
                ((JSONObject)localObject3).put("url", paramIntent);
                ((JSONObject)localObject3).put("msg", localObject2);
                paramIntent = ((JSONObject)localObject3).toString();
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "selectAndUploadAvatar  result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
                }
                callJs((String)localObject1, new String[] { paramIntent });
                return;
              }
              catch (Exception paramIntent) {}
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
              return;
            }
            try
            {
              paramIntent = new JSONObject();
              paramIntent.put("retCode", -1);
              paramIntent = paramIntent.toString();
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountH5AbilityPlugin", 2, " selectAndUploadAvatar result:" + paramIntent);
              }
              callJs(this.jdField_b_of_type_JavaLangString, new String[] { paramIntent });
              return;
            }
            catch (Exception paramIntent) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("PublicAccountH5AbilityPlugin", 2, QLog.getStackTraceString(paramIntent));
            return;
          }
          if (paramByte == 117)
          {
            if (paramIntent == null) {
              break;
            }
            localObject1 = paramIntent.getStringExtra("arg_callback");
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            if (paramIntent == null) {}
          }
        }
        label1668:
        try
        {
          paramIntent = new JSONObject(paramIntent);
          if (paramInt == -1) {
            paramIntent.put("retCode", 0);
          }
          for (;;)
          {
            paramIntent = paramIntent.toString();
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "showCommentEditor result:" + ReadInJoyDeliverUGCActivity.a(paramIntent));
            }
            callJs((String)localObject1, new String[] { paramIntent });
            return;
            paramIntent = new JSONObject();
            break;
            paramIntent.put("retCode", -1);
          }
          if (paramByte != 119) {
            break;
          }
          a(paramIntent);
          return;
        }
        catch (Exception paramIntent) {}
      }
      paramInt = 0;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.mRuntime.a();
      this.jdField_a_of_type_AndroidAppActivity = this.mRuntime.a();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
    }
    a();
  }
  
  public void onDestroy()
  {
    if (this.mRuntime != null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        a(localCustomWebView.getUrl());
      }
    }
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      i();
      if (this.jdField_a_of_type_Wxr != null) {
        this.jdField_a_of_type_Wxr.b();
      }
      a().clear();
      if (this.jdField_a_of_type_Sfh != null) {
        this.jdField_a_of_type_Sfh.f();
      }
    }
    if (this.jdField_a_of_type_Qvt != null)
    {
      this.jdField_a_of_type_Qvt.b();
      this.jdField_a_of_type_Qvt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfk
 * JD-Core Version:    0.7.0.1
 */