import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberAQFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.10;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.2;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.21;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.3;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.5;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.6;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.mp.mobileqq_mp.JSApiWebServerRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sxe
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
  bhuf jdField_a_of_type_Bhuf;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  String jdField_a_of_type_JavaLangString;
  ArrayList<sya> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public red a;
  rlk jdField_a_of_type_Rlk = null;
  sxb jdField_a_of_type_Sxb;
  yqz jdField_a_of_type_Yqz = null;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  String jdField_b_of_type_JavaLangString;
  ArrayList<sxz> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public sxe()
  {
    this.jdField_a_of_type_Int = 1281;
    this.jdField_b_of_type_Int = 1282;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Red = null;
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new sxf(this);
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
        paramString = ndv.a(SafeBitmapFactory.decodeFile(paramString));
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PublicAccountH5AbilityPlugin.10(this), 200L);
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
    if (ors.g() >= 2)
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, this.jdField_a_of_type_AndroidAppActivity.getString(2131718869), 0).b(this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298914));
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
    ois.a(this, this.mRuntime.a(), paramString4, (byte)116);
    ors.a("2", "2");
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
  
  public static void a(JSONObject paramJSONObject, String paramString, spj paramspj)
  {
    yqz localyqz = yqz.a();
    localyqz.a();
    a(paramJSONObject, localyqz.a(new sxx(paramspj, paramString)));
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
      azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005868", "0X8005868", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      if ("publicAccount.getLocation".equals(paramString2)) {
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586A", "0X800586A", 0, 0, "", "", "", "");
      } else if ("ui.closeWebViews".equals(paramString2)) {
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586D", "0X800586D", 0, 0, "", "", "", "");
      } else if ("troopNotice.showPicture".equals(paramString2)) {
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005896", "0X8005896", 0, 0, "1", "", "", "");
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
        String str2 = new String(bdfr.decode(((JSONObject)localObject2).optString("title", ""), 0));
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
          localBundle.putString("scroll_image_r5", ors.a(i1, -1, Integer.toString(i5), i4, "", "", null));
          localBundle.putString("read_article_r5", ors.a(i1, -1, Integer.toString(i5), i4, "", null));
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
    if (!bdin.g(this.mRuntime.a()))
    {
      ybk.a(1, 2131693417);
      return;
    }
    localObject = new bety(this.mRuntime.a());
    ((bety)localObject).c(2131694219);
    ((bety)localObject).show();
    ThreadManager.executeOnSubThread(new PublicAccountH5AbilityPlugin.21(this, paramString, localBundle, (bety)localObject));
  }
  
  public ArrayList<String> a()
  {
    beir localbeir = (beir)super.getBrowserComponent(4);
    if (localbeir != null) {
      return localbeir.jdField_a_of_type_JavaUtilArrayList;
    }
    return null;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
    if (this.jdField_a_of_type_Red == null) {
      this.jdField_a_of_type_Red = red.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt1);
    localIntent.putExtra("PhotoConst.CUSTOM_SENDBTN_TEXT", alud.a(2131709162));
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
    String str = bdzf.a(alof.aX + "readinjoy_avatar_upload/");
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
    bdfa.anim(this.jdField_a_of_type_AndroidAppActivity, false, true);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhuf == null) {
      this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561151, null);
    this.jdField_a_of_type_Bhuf.a((View)localObject, null);
    TextView localTextView1 = (TextView)((View)localObject).findViewById(2131366501);
    TextView localTextView2 = (TextView)((View)localObject).findViewById(2131366499);
    localObject = (TextView)((View)localObject).findViewById(2131366581);
    if (paramInt1 == 1)
    {
      ((TextView)localObject).setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_Bhuf.isShowing()) {
        this.jdField_a_of_type_Bhuf.show();
      }
      localTextView1.setOnClickListener(new sxj(this, paramString));
      localTextView2.setOnClickListener(new sxk(this, paramInt3, paramInt2, paramString));
      ((TextView)localObject).setOnClickListener(new sxl(this));
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
      if ((this.jdField_a_of_type_Yqz != null) && (!"".equals(paramString1))) {
        this.jdField_a_of_type_Yqz.b(paramString1, paramInt, str1, paramBoolean, new sxo(this, paramBoolean, paramString3, paramString2), new sxp(this));
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
      if ((this.jdField_a_of_type_Yqz != null) && (!"".equals(paramString1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PAH5Manager", 2, "HttpUtil.getNetWorkType()" + ndd.a());
        }
        if (ndd.a() != 1)
        {
          localObject2 = new File(paramString1);
          if (QLog.isColorLevel()) {
            QLog.d("PAH5Manager", 2, "size" + ((File)localObject2).length());
          }
          if (((File)localObject2).length() > 204800L) {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "你已离开wifi环境", 0).a();
          }
        }
        this.jdField_a_of_type_Yqz.a(paramString1, paramInt, (String)localObject1, paramBoolean, new sxm(this, paramString2, paramBoolean), new sxn(this));
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
          sya localsya = (sya)((Iterator)localObject3).next();
          if (((String)localObject2).equals(localsya.jdField_b_of_type_JavaLangString)) {
            paramBundle.add(localsya);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramBundle);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        paramBundle = (sya)this.jdField_a_of_type_JavaUtilArrayList.get(0);
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nrz.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.5,3,0");
    localJSApiWebServerRequest.cmd.set(this.jdField_b_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("puin", this.k);
      localJSONObject.put("mediaid", paramString1);
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new sxh(this, paramString2, paramInt, paramBoolean, paramString1));
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
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nrz.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.5,3,0");
    localJSApiWebServerRequest.cmd.set(1);
    localJSApiWebServerRequest.body.set(paramString2);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountH5AbilityPlugin", 2, "鉴权body为:  " + paramString2);
    }
    localNewIntent.setObserver(new sxi(this, paramString1));
    localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidAppActivity, nrz.class);
    localNewIntent.putExtra("cmd", "jsapi");
    mobileqq_mp.JSApiWebServerRequest localJSApiWebServerRequest = new mobileqq_mp.JSApiWebServerRequest();
    localJSApiWebServerRequest.versionInfo.set("8.3.5,3,0");
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
        sxb localsxb;
        paramString1.printStackTrace();
        continue;
      }
      localJSApiWebServerRequest.body.set(localJSONObject.toString());
      localNewIntent.setObserver(new sxg(this, paramBoolean, paramString2));
      localNewIntent.putExtra("data", localJSApiWebServerRequest.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
      return;
      localJSONObject.put("type", "4");
      if (this.jdField_a_of_type_Sxb == null) {
        this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
      }
      this.jdField_a_of_type_Sxb.h();
      localJSONObject.put("file_uuid", paramString1);
      localsxb = this.jdField_a_of_type_Sxb;
      localJSONObject.put("file_md5", sxb.b());
      localsxb = this.jdField_a_of_type_Sxb;
      localJSONObject.put("file_name", sxb.c());
      localsxb = this.jdField_a_of_type_Sxb;
      localJSONObject.put("file_size", sxb.b());
      localsxb = this.jdField_a_of_type_Sxb;
      localJSONObject.put("file_time", sxb.c());
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder().append("sendUuidForMediaIdRequest file_uuid = ").append(paramString1).append(" file_md5=");
        localsxb = this.jdField_a_of_type_Sxb;
        paramString1 = paramString1.append(sxb.b()).append(" file_name:");
        localsxb = this.jdField_a_of_type_Sxb;
        paramString1 = paramString1.append(sxb.c()).append(" file_size=");
        localsxb = this.jdField_a_of_type_Sxb;
        paramString1 = paramString1.append(sxb.b()).append(" file_time=");
        localsxb = this.jdField_a_of_type_Sxb;
        QLog.i("PublicAccountH5AbilityPlugin", 2, sxb.c());
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
      azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586B", "0X800586B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.mRuntime.a() != null) {
        this.mRuntime.a().m(paramBoolean);
      }
      return;
      azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586C", "0X800586C", 0, 0, "", "", "", "");
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Sxb != null) {
      this.jdField_a_of_type_Sxb.f();
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
    this.jdField_a_of_type_Yqz.c();
  }
  
  void c(String paramString)
  {
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        sxz localsxz = (sxz)localIterator.next();
        if (paramString.equals(localsxz.jdField_b_of_type_JavaLangString)) {
          localArrayList.add(localsxz);
        }
      }
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      paramString = (sxz)this.jdField_b_of_type_JavaUtilArrayList.get(0);
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    label1671:
    label2127:
    int i3;
    label1924:
    label2574:
    int i2;
    label2675:
    label3327:
    int i5;
    label3791:
    boolean bool2;
    if ("publicAccountNew".endsWith(paramString2))
    {
      if ("openLocation".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          c();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005869", "0X8005869", 0, 0, "", "", "", "");
        return true;
      }
      if ("showOfficialAccountProfile".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
          if (!"".equals(paramJsBridgeListener)) {
            b(paramJsBridgeListener);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("showWebPanel".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          d();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("setRightButtonState".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          bool1 = paramJsBridgeListener.optBoolean("hidden");
          paramJsBridgeListener = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          a(bool1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("hideMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          a(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586E", "0X800586E", 0, 0, "", "", "", "");
        return true;
      }
      if ("showMenuItems".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optJSONArray("menuList");
          paramString1 = new ArrayList();
          if (paramString2 != null)
          {
            i1 = 0;
            while (i1 < paramString2.length())
            {
              paramString1.add(paramString2.optString(i1));
              i1 += 1;
            }
          }
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString2 = new JSONObject();
            paramString2.put("retCode", 0);
            paramString2.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
          }
          b(paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X800586F", "0X800586F", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          e();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005870", "0X8005870", 0, 0, "", "", "", "");
        return true;
      }
      if ("showAllNonBaseMenuItem".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          f();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005871", "0X8005871", 0, 0, "", "", "", "");
        return true;
      }
      if ("showWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          h();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005898", "0X8005898", 0, 0, "", "", "", "");
        return true;
      }
      if ("hideWebToolbar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
          }
          g();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005897", "0X8005897", 0, 0, "", "", "", "");
        return true;
      }
      if ("uploadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("localId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          paramString2 = (String)jdField_b_of_type_JavaUtilHashMap.get(paramString1);
          paramString3 = new File(paramString2);
          if ((paramString3 == null) || (!paramString3.exists()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131709151) + paramString2, 0).a();
            return true;
          }
          if (paramString3.length() > 2097152L)
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "请选择小于2M文件" + paramString2, 0).a();
            return true;
          }
          paramString3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramString3.hasNext())
          {
            paramVarArgs = (sya)paramString3.next();
            if ((paramString1 != null) && (paramString1.equals(paramVarArgs.jdField_b_of_type_JavaLangString)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131709170), 0).a();
              return true;
            }
          }
          paramString3 = new sya();
          paramString3.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString3.jdField_b_of_type_JavaLangString = paramString1;
          paramString3.jdField_a_of_type_Int = i1;
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
          if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
            break label1671;
          }
          a(i1, paramString2, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, 2, "1", "", "", "", false);
        return true;
        return true;
      }
      if ("downloadImage".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          paramString1 = paramString2.optString("serverId");
          i1 = paramString2.optInt("isShowProgressTips", 1);
          if (("".equals(paramJsBridgeListener)) || ("".equals(paramString1)))
          {
            QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "callback or mediaId is null", 0).a();
            return true;
          }
          paramString2 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (sxz)paramString2.next();
            if ((paramString1 != null) && (paramString1.equals(paramString3.jdField_b_of_type_JavaLangString)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131709141), 0).a();
              return true;
            }
          }
          paramString2 = new sxz();
          paramString2.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
          paramString2.jdField_b_of_type_JavaLangString = paramString1;
          paramString2.jdField_a_of_type_Int = i1;
          this.jdField_b_of_type_JavaUtilArrayList.add(paramString2);
          if (this.jdField_b_of_type_JavaUtilArrayList.size() != 1) {
            break label1924;
          }
          a(paramString1, i1, true, paramJsBridgeListener);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D28", "0X8005D28", 0, 2, "1", "", "", "");
        return true;
        return true;
      }
      if ("uploadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13223;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("localId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "file not exists");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            if (this.jdField_a_of_type_Sxb != null) {
              break label2127;
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
          paramString1 = this.jdField_a_of_type_Sxb.b(paramString2);
          paramString2 = new File(paramString1);
          if (!paramString2.exists())
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "file not exists");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          else if (paramString2.length() > 5242880L)
          {
            paramString1 = new JSONObject();
            try
            {
              paramString1.put("retCode", -1);
              paramString1.put("msg", "请上传5MB以内的音频");
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            }
            catch (JSONException paramString2)
            {
              for (;;)
              {
                paramString2.printStackTrace();
              }
            }
          }
          else
          {
            a(i1, paramString1, false, paramJsBridgeListener);
          }
        }
      }
      if ("downloadVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13225;
        }
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            paramString2 = paramString1.optString("serverId");
            i1 = paramString1.optInt("isShowProgressTips", 1);
            bool1 = TextUtils.isEmpty(paramString2);
            if (bool1) {
              try
              {
                paramString1 = new JSONObject();
                paramString1.put("retCode", -1);
                paramString1.put("msg", "invalid serverId");
                callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D31", "0X8005D31", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramJsBridgeListener)
              {
                paramJsBridgeListener.printStackTrace();
                continue;
              }
            }
            a(paramString2, i1, false, paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("getPicture".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13234;
        }
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString2.optString("callback");
          i3 = paramString2.optInt("count");
          if (i3 > 9) {
            break label13227;
          }
          if (i3 >= 1) {
            break label13220;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          break label13234;
        }
        paramString1 = paramString2.optJSONArray("sizeType");
        paramString2 = paramString2.optJSONArray("sourceType");
        if ((paramString2 == null) || (paramString2.length() != 1)) {
          break label13214;
        }
        paramString2 = paramString2.optString(0);
        if ("camera".equalsIgnoreCase(paramString2))
        {
          i1 = 1;
          i4 = 0;
          i2 = i4;
          if (paramString1 != null)
          {
            i2 = i4;
            if (paramString1.length() == 1)
            {
              paramString1 = paramString1.optString(0);
              if (!"original".equalsIgnoreCase(paramString1)) {
                break label2675;
              }
              i2 = 1;
            }
          }
        }
        for (;;)
        {
          a(i1, i2, paramJsBridgeListener, i3);
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 2, "1", "", "", "");
          break label13234;
          if (!"album".equalsIgnoreCase(paramString2)) {
            break label13214;
          }
          i1 = 2;
          break;
          bool1 = "compressed".equalsIgnoreCase(paramString1);
          i2 = i4;
          if (bool1) {
            i2 = 2;
          }
        }
      }
      if ("startRecord".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          jdField_c_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
          if (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString))
          {
            if (this.jdField_a_of_type_Sxb == null) {
              this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
            }
            this.jdField_a_of_type_Sxb.b();
          }
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D29", "0X8005D29", 0, 2, "1", "", "", "");
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("stopRecord".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        for (;;)
        {
          try
          {
            jdField_d_of_type_JavaLangString = new JSONObject(paramVarArgs[0]).optString("callback");
            if ((this.jdField_a_of_type_Sxb == null) || (!this.jdField_a_of_type_Sxb.a())) {
              continue;
            }
            this.jdField_a_of_type_Sxb.c();
            azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2A", "0X8005D2A", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            continue;
          }
          return true;
          try
          {
            paramJsBridgeListener = new JSONObject();
            paramJsBridgeListener.put("retCode", -1);
            paramJsBridgeListener.put("msg", "fail");
            callJs(jdField_d_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("playVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13236;
        }
        for (;;)
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
            paramJsBridgeListener = paramJsBridgeListener.optString("localId");
            if (!TextUtils.isEmpty(jdField_e_of_type_JavaLangString))
            {
              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                break label3327;
              }
              if ((this.jdField_a_of_type_Sxb != null) && (this.jdField_a_of_type_Sxb.b())) {
                return true;
              }
              if (this.jdField_a_of_type_Sxb == null) {
                this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
              }
              paramString1 = this.jdField_a_of_type_Sxb.b(paramJsBridgeListener);
              paramJsBridgeListener = new JSONObject();
              if (new File(paramString1).exists()) {
                this.jdField_a_of_type_Sxb.b(paramString1);
              }
            }
            else
            {
              try
              {
                paramJsBridgeListener.put("retCode", 0);
                paramJsBridgeListener.put("msg", "success");
                azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 0, "1", "", "", "");
                callJs(jdField_e_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
                azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, 2, "1", "", "", "");
              }
              catch (JSONException paramString1)
              {
                paramString1.printStackTrace();
                continue;
              }
            }
            try
            {
              paramJsBridgeListener.put("retCode", -1);
              paramJsBridgeListener.put("msg", "file not exists");
              azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2C", "0X8005D2C", 0, -1, "1", "", "", "");
            }
            catch (JSONException paramString1)
            {
              for (;;)
              {
                paramString1.printStackTrace();
              }
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          paramJsBridgeListener = new JSONObject();
          try
          {
            paramJsBridgeListener.put("retCode", -1);
            paramJsBridgeListener.put("msg", "missing arguments");
            callJs(jdField_e_of_type_JavaLangString, new String[] { paramJsBridgeListener.toString() });
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("pauseVoice".endsWith(paramString3))
      {
        if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
          break label13238;
        }
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString1 = paramString1.optString("localId");
          if (!TextUtils.isEmpty(paramString1))
          {
            if (this.jdField_a_of_type_Sxb == null) {
              this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
            }
            this.jdField_a_of_type_Sxb.b(paramString1);
            if (this.jdField_a_of_type_Sxb.b())
            {
              this.jdField_a_of_type_Sxb.g();
              paramString1 = new JSONObject();
            }
          }
          try
          {
            paramString1.put("retCode", 0);
            paramString1.put("msg", "success");
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 0, "1", "", "", "");
            azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2D", "0X8005D2D", 0, 2, "1", "", "", "");
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          if (!"stopVoice".endsWith(paramString3)) {
            break label3791;
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      else
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          jdField_f_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
          paramJsBridgeListener = paramJsBridgeListener.optString("localId");
          if (!TextUtils.isEmpty(paramJsBridgeListener))
          {
            if (this.jdField_a_of_type_Sxb == null) {
              this.jdField_a_of_type_Sxb = new sxb(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, this.mRuntime);
            }
            this.jdField_a_of_type_Sxb.b(paramJsBridgeListener);
            this.jdField_a_of_type_Sxb.e();
            azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 0, "1", "", "", "");
          }
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D2E", "0X8005D2E", 0, 2, "1", "", "", "");
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("onVoiceRecordEnd".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          g = new JSONObject(paramVarArgs[0]).optString("callback");
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("onVoicePlayEnd".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          h = new JSONObject(paramVarArgs[0]).optString("callback");
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
      if ("selectAndUploadAvatar".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          i = paramJsBridgeListener.optString("callback");
          i5 = paramJsBridgeListener.optInt("type", 1);
          i1 = 640;
          i2 = 640;
          i3 = 640;
          i4 = 640;
          if (paramJsBridgeListener.has("width"))
          {
            i2 = paramJsBridgeListener.optInt("width");
            i1 = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, i2 / 2);
          }
          if (paramJsBridgeListener.has("height"))
          {
            i4 = paramJsBridgeListener.optInt("height");
            i3 = bdaq.a(this.jdField_a_of_type_AndroidAppActivity, i4 / 2);
          }
          a(1, i5, (byte)118, i1, i3, i2, i4);
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PublicAccountH5AbilityPlugin", 2, "selectAndUploadAvatar  json parse error");
            }
          }
        }
        return true;
      }
      if ("uploadTopicPic".endsWith(paramString3))
      {
        bool2 = false;
        bool1 = bool2;
        if (paramVarArgs != null)
        {
          bool1 = bool2;
          if (paramVarArgs.length <= 0) {}
        }
      }
    }
    try
    {
      paramJsBridgeListener = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString1 = new JSONObject(paramVarArgs[0]);
      j = paramString1.optString("callback");
      i5 = paramString1.optInt("type");
      i1 = Utils.rp2px(paramJsBridgeListener.widthPixels, 360.0D);
      i2 = Utils.rp2px(paramJsBridgeListener.widthPixels, 200.0D);
      i3 = 750;
      i4 = 416;
      if (i5 != 1) {
        break label13240;
      }
      i2 = Utils.rp2px(paramJsBridgeListener.widthPixels, 360.0D);
      i4 = 160;
      i3 = 160;
      i1 = i2;
    }
    catch (JSONException paramJsBridgeListener)
    {
      for (;;)
      {
        label4217:
        bool1 = bool2;
        continue;
        i2 = 0;
        continue;
        i1 = -1;
        continue;
        paramJsBridgeListener = "";
        continue;
        paramString1 = "";
        continue;
        bool2 = true;
        continue;
        bool1 = false;
        continue;
        paramJsBridgeListener = paramVarArgs;
        continue;
        paramString1 = str1;
        continue;
        paramJsBridgeListener = paramVarArgs;
        continue;
        paramString1 = str1;
        continue;
        paramJsBridgeListener = null;
      }
    }
    a(2, 0, (byte)121, i1, i2, i3, i4);
    boolean bool1 = true;
    label4236:
    QLog.d("PublicAccountH5AbilityPlugin", 1, "uploadTopicPic  args:" + paramVarArgs + " isExecuted:" + bool1);
    return true;
    if ("config".endsWith(paramString3))
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          l = paramString1.optString("appId");
          paramString1.put("appver", "8.3.5");
          paramJsBridgeListener = this.mRuntime.a();
          if (paramJsBridgeListener == null) {
            break label13203;
          }
          paramJsBridgeListener = paramJsBridgeListener.getUrl();
          paramString1.put("url", paramJsBridgeListener);
          paramString2 = paramString1.toString();
          this.m = paramString1.optString("callback");
          paramString1 = paramString1.optJSONArray("jsApiList");
          paramString3 = new ArrayList();
          if (paramString1 != null)
          {
            paramString3.clear();
            i1 = 0;
            while (i1 < paramString1.length())
            {
              paramString3.add(paramString1.optString(i1));
              i1 += 1;
            }
          }
          jdField_a_of_type_JavaUtilMap.remove(paramJsBridgeListener);
          jdField_b_of_type_JavaUtilMap.put(paramJsBridgeListener, paramString3);
          if (paramJsBridgeListener != null) {
            a(paramJsBridgeListener, paramString2);
          }
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
    }
    label4481:
    label5116:
    do
    {
      for (;;)
      {
        return false;
        if (!"isEnabledRightButton".endsWith(paramString3)) {
          break;
        }
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          i1 = paramString1.optInt("status");
          if ((this.mRuntime.a() != null) && (this.mRuntime.a().a != null) && (this.mRuntime.a().a.a != null)) {
            this.mRuntime.a().a.a.a(i1);
          }
          paramString1 = new JSONObject();
          paramString1.put("retCode", 0);
          callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      if ("reportpreloaddata".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          paramJsBridgeListener = paramString1.optString("callback");
          paramString2 = paramString1.optString("url");
          if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (!TextUtils.isEmpty(paramString2)))
          {
            paramString1 = new JSONObject();
            paramString1.put("retCode", 0);
            paramString1.put("msg", "Success");
            bool2 = false;
            paramString2 = PreloadManager.a(paramString2);
            bool1 = bool2;
            if (paramString2 != null)
            {
              bool1 = bool2;
              if (new File(alof.cH, paramString2).exists()) {
                bool1 = true;
              }
            }
            paramString1.put("hit", bool1);
            paramString2 = BaseApplicationImpl.getApplication().getRuntime();
            if (paramString2 != null)
            {
              paramString2 = (AppInterface)paramString2.getAppRuntime("modular_web");
              if (paramString2 != null)
              {
                paramString2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + paramString2.getCurrentAccountUin(), 4);
                if (paramString2 != null)
                {
                  bool1 = paramString2.getBoolean("kandian_feeds_preload", false);
                  bool2 = paramString2.getBoolean("kandian_feeds_preload_wifi", false);
                  boolean bool3 = paramString2.getBoolean("kandian_feeds_preload_4G", false);
                  boolean bool4 = paramString2.getBoolean("kandian_feeds_preload_3G", false);
                  boolean bool5 = paramString2.getBoolean("kandian_feeds_preload_2G", false);
                  paramString1.put("readInJoyPreload", bool1);
                  paramString1.put("readInJoyPreloadWifi", bool2);
                  paramString1.put("readInJoyPreload4G", bool3);
                  paramString1.put("readInJoyPreload3G", bool4);
                  paramString1.put("readInJoyPreload2G", bool5);
                  callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
                  if (QLog.isColorLevel()) {
                    QLog.i("PublicAccountH5AbilityPlugin", 2, "reportpreloaddata" + paramString1.toString());
                  }
                }
              }
            }
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
      if ("showOnlyShareMenu".endsWith(paramString3))
      {
        paramJsBridgeListener = (beir)super.getBrowserComponent(4);
        if (paramJsBridgeListener != null)
        {
          paramString1 = this.mRuntime.a();
          if (paramString1 != null)
          {
            paramString1.c();
            if ((paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) && (paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b != null)) {
              paramJsBridgeListener.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b.setVisibility(8);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountH5AbilityPlugin", 2, "showOnlyShareMenu");
        }
        return true;
      }
      if ("getBiuTriggerType".equals(paramString3))
      {
        paramString2 = new JSONObject();
        try
        {
          if (ohq.a() != 1) {
            break label13257;
          }
          paramJsBridgeListener = "fastBiu";
          if (ohq.b() != 1) {
            break label13264;
          }
          paramString1 = "fastBiu";
          paramString2.put("retCode", 0);
          paramString2.put("click", paramJsBridgeListener);
          paramString2.put("longClick", paramString1);
          if ((paramVarArgs != null) && (paramVarArgs.length > 0))
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
              callJs(paramJsBridgeListener, new String[] { paramString2.toString() });
            }
          }
          else
          {
            QLog.e("PublicAccountH5AbilityPlugin", 1, "[handleJsRequest] empty args when getBiuTriggerType");
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          QLog.e("PublicAccountH5AbilityPlugin", 1, "[handleJsRequest] ", paramJsBridgeListener);
        }
      }
      if ("queryKBPredownloadInfo".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback");
          if (!TextUtils.isEmpty(paramString1)) {
            callJs(paramString1, new String[] { opq.a(this.mRuntime.a()) });
          }
          paramJsBridgeListener = "" + paramJsBridgeListener.toString();
        }
        catch (JSONException paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
        }
        QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
        return true;
      }
      if ("queryPredownloadInfo".endsWith(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          paramString1 = paramJsBridgeListener.optString("callback");
          paramString2 = paramJsBridgeListener.optString("packageName");
          if (!TextUtils.isEmpty(paramString1)) {
            callJs(paramString1, new String[] { Achilles.a(paramString2) });
          }
          paramJsBridgeListener = "" + paramJsBridgeListener.toString();
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
        }
        QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
        return true;
      }
      if ("installPredownloadInfo".equalsIgnoreCase(paramString3))
      {
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
        for (;;)
        {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
            paramString1 = paramJsBridgeListener.optString("callback");
            paramString2 = paramJsBridgeListener.optString("packageName");
            if ((!TextUtils.isEmpty(paramString1)) && (!Achilles.a(paramString1, paramString2, this.mRuntime, false))) {
              continue;
            }
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener = "" + paramJsBridgeListener.toString();
            continue;
          }
          QLog.d("PublicAccountH5AbilityPlugin", 1, new Object[] { "[handleJsRequest] ", paramJsBridgeListener });
          return true;
        }
      }
      if (!"likeBiuFusionRequestBehavior".equals(paramString3)) {
        break;
      }
    } while ((paramVarArgs == null) || (paramVarArgs.length <= 0));
    label5127:
    label9500:
    label10788:
    label11967:
    label12608:
    label13143:
    label13271:
    for (;;)
    {
      long l1;
      long l3;
      long l4;
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    for (;;)
                    {
                      for (;;)
                      {
                        for (;;)
                        {
                          for (;;)
                          {
                            String str2;
                            try
                            {
                              localObject4 = new JSONObject(paramVarArgs[0]);
                              if (QLog.isColorLevel()) {
                                QLog.i("PublicAccountH5AbilityPlugin", 2, "web json:" + ((JSONObject)localObject4).toString());
                              }
                              localObject3 = ((JSONObject)localObject4).optString("title");
                              paramString2 = ((JSONObject)localObject4).optString("sourceName");
                              str2 = ((JSONObject)localObject4).optString("sourceUrl");
                              if (!TextUtils.isEmpty(str2)) {
                                break label13271;
                              }
                              str2 = paramString1;
                              i5 = ((JSONObject)localObject4).optInt("hiddenBiuComponent");
                              paramVarArgs = "";
                              if (i5 == 1) {
                                paramVarArgs = new String(bdfr.decode(((JSONObject)localObject4).optString("newComment"), 2));
                              }
                              l1 = 0L;
                              l3 = 0L;
                              l4 = 0L;
                              l10 = 0L;
                              l11 = 0L;
                              Object localObject1 = "";
                              for (;;)
                              {
                                try
                                {
                                  paramJsBridgeListener = new String(bdfr.decode((String)localObject3, 0));
                                }
                                catch (Exception paramString3)
                                {
                                  long l2;
                                  long l7;
                                  long l6;
                                  long l5;
                                  String str3;
                                  String str4;
                                  int i6;
                                  ArticleInfo localArticleInfo;
                                  Object localObject5;
                                  Object localObject6;
                                  Object localObject8;
                                  String str5;
                                  Object localObject2;
                                  Object localObject7;
                                  String str6;
                                  Object localObject9;
                                  String str1;
                                  paramString1 = paramString2;
                                  paramJsBridgeListener = "";
                                  l9 = l11;
                                  l8 = l10;
                                  paramString2 = (String)localObject3;
                                  continue;
                                  i1 = 1;
                                  continue;
                                  if (i7 == 4) {
                                    continue;
                                  }
                                  if (i7 != 5) {
                                    continue;
                                  }
                                  continue;
                                  i1 = 2;
                                  continue;
                                  continue;
                                  if (i4 != 11) {
                                    continue;
                                  }
                                  i1 = 5;
                                  continue;
                                  if (i4 != 6) {
                                    continue;
                                  }
                                  i1 = 6;
                                  continue;
                                  if (i4 != 12) {
                                    continue;
                                  }
                                  i1 = 7;
                                  continue;
                                  if (i4 != 13) {
                                    continue;
                                  }
                                  i1 = 8;
                                  continue;
                                  if (i4 < 15) {
                                    continue;
                                  }
                                  i1 = i4;
                                  continue;
                                  continue;
                                }
                                try
                                {
                                  paramString1 = new String(bdfr.decode(paramString2, 0));
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = paramJsBridgeListener;
                                  paramJsBridgeListener = "";
                                  paramString1 = paramString2;
                                  l9 = l11;
                                  l8 = l10;
                                  paramString2 = (String)localObject3;
                                }
                              }
                              try
                              {
                                paramString2 = ((JSONObject)localObject4).optString("feedsId");
                                paramString3 = ((JSONObject)localObject4).optString("rowkey");
                                localObject1 = paramString3;
                                l2 = l1;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l1;
                              }
                              catch (Exception paramString3)
                              {
                                localObject3 = "";
                                paramString2 = paramJsBridgeListener;
                                paramJsBridgeListener = (JsBridgeListener)localObject3;
                                l9 = l11;
                                l8 = l10;
                                continue;
                              }
                              try
                              {
                                if (!TextUtils.isEmpty(paramString2))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l1;
                                  l2 = new BigInteger(paramString2).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("ariticleId");
                                l1 = l3;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l3;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  l1 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l1;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("originFeedsId");
                                l3 = l4;
                                l9 = l11;
                                l8 = l10;
                                l7 = l4;
                                l6 = l1;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  l3 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l10;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                paramString3 = ((JSONObject)localObject4).optString("businessId");
                                l4 = l10;
                                l9 = l11;
                                l8 = l10;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                if (!TextUtils.isEmpty(paramString3))
                                {
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  l4 = new BigInteger(paramString3).longValue();
                                }
                                l9 = l11;
                                l8 = l4;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                l10 = ((JSONObject)localObject4).optLong("accountID");
                                l9 = l10;
                                l8 = l4;
                                l7 = l3;
                                l6 = l1;
                                l5 = l2;
                                i2 = ((JSONObject)localObject4).optInt("accountType");
                                l8 = l4;
                                localObject3 = paramString2;
                                paramString2 = (String)localObject1;
                                l5 = l2;
                                l4 = l3;
                                l2 = l10;
                                l3 = l1;
                                paramString3 = paramJsBridgeListener;
                                paramJsBridgeListener = (JsBridgeListener)localObject3;
                                l1 = l5;
                                l5 = ((JSONObject)localObject4).optLong("originFeedsType", 1L);
                                i1 = ((JSONObject)localObject4).optInt("type");
                                i4 = ((JSONObject)localObject4).optInt("adtag");
                                str3 = ((JSONObject)localObject4).optString("picurl");
                                i3 = ((JSONObject)localObject4).optInt("duration");
                                localObject3 = ((JSONObject)localObject4).optString("callback");
                                str4 = new String(bdfr.decode(((JSONObject)localObject4).optString("accountDesc"), 0));
                                i6 = ((JSONObject)localObject4).optInt("feedsType", 1);
                                localArticleInfo = new ArticleInfo();
                                localArticleInfo.mArticleID = l3;
                                localArticleInfo.mTitle = paramString3;
                                localArticleInfo.mSubscribeName = paramString1;
                                localArticleInfo.mFirstPagePicUrl = str3;
                                localArticleInfo.mVideoDuration = i3;
                                localArticleInfo.mFeedId = l1;
                                localArticleInfo.mSummary = str4;
                                localArticleInfo.businessId = l8;
                                localArticleInfo.mFeedType = i6;
                              }
                              catch (Exception paramString3)
                              {
                                localObject3 = paramJsBridgeListener;
                                paramJsBridgeListener = paramString2;
                                l4 = l7;
                                l3 = l6;
                                l1 = l5;
                                paramString2 = (String)localObject3;
                                continue;
                              }
                              try
                              {
                                localObject1 = ((JSONObject)localObject4).getJSONArray("biuLevelList");
                                localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc = new qmc();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong = Long.valueOf(l4);
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_b_of_type_JavaLangLong = Long.valueOf(l5);
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
                                if (localObject1 != null)
                                {
                                  i3 = 0;
                                  if (i3 < ((JSONArray)localObject1).length())
                                  {
                                    localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
                                    localObject6 = ((JSONArray)localObject1).getJSONObject(i3);
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(bdfr.decode(((JSONObject)localObject6).optString("comment"), 0));
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString;
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject6).optInt("biuTime");
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_Int = ((JSONObject)localObject6).optInt("feeds_type", 1);
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_c_of_type_Int = ((JSONObject)localObject6).optInt("op_type");
                                    localObject8 = ((JSONObject)localObject6).optString("jumpName");
                                    str5 = ((JSONObject)localObject6).optString("jumpUrl");
                                    if ((!TextUtils.isEmpty((CharSequence)localObject8)) && (!TextUtils.isEmpty(str5))) {
                                      ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdfr.decode((String)localObject8, 0)), str5);
                                    }
                                    if (i5 != 1) {}
                                  }
                                }
                              }
                              catch (JSONException localJSONException1)
                              {
                                try
                                {
                                  localObject6 = ((JSONObject)localObject6).optString("feedsId");
                                  if (!TextUtils.isEmpty((CharSequence)localObject6)) {
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject6).longValue());
                                  }
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localObject5);
                                  i3 += 1;
                                  continue;
                                  paramString3.printStackTrace();
                                  i2 = 0;
                                  l2 = l9;
                                  paramString3 = paramString2;
                                  paramString2 = (String)localObject1;
                                  continue;
                                  localJSONException1 = localJSONException1;
                                  QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localJSONException1.toString());
                                  localObject2 = null;
                                }
                                catch (Exception localException1)
                                {
                                  QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localException1.toString());
                                  continue;
                                }
                              }
                            }
                            catch (JSONException paramJsBridgeListener)
                            {
                              QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior jsapi json exception " + paramJsBridgeListener.toString());
                              break;
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcInfo");
                              localObject2 = "";
                              if ((localObject4 == null) || (!rqj.c(i6, l5))) {
                                break label13197;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw = new qmw();
                              i7 = ((JSONObject)localObject4).optInt("ugcType", 0);
                              localObject2 = ((JSONObject)localObject4).optString("ugcComment");
                              localObject5 = ((JSONObject)localObject4).optJSONArray("ugcAtLevelList");
                              if (localObject5 == null) {
                                break label7429;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc = new qmc();
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
                              i3 = 0;
                              if (i3 >= ((JSONArray)localObject5).length()) {
                                break label7429;
                              }
                              localObject7 = new SocializeFeedsInfo.BiuCommentInfo();
                              localObject8 = ((JSONArray)localObject5).getJSONObject(i3);
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject8).optLong("uin"));
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangString = new String(bdfr.decode(((JSONObject)localObject8).optString("comment"), 0));
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangString;
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_Int = ((JSONObject)localObject8).optInt("biuTime");
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_Int = ((JSONObject)localObject8).optInt("feeds_type", 1);
                              ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_c_of_type_Int = ((JSONObject)localObject8).optInt("op_type");
                              str5 = ((JSONObject)localObject8).optString("jumpName");
                              str6 = ((JSONObject)localObject8).optString("jumpUrl");
                              if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
                                ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdfr.decode(str5, 0)), str6);
                              }
                              try
                              {
                                localObject8 = ((JSONObject)localObject8).optString("feedsId");
                                if (!TextUtils.isEmpty((CharSequence)localObject8)) {
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject7).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject8).longValue());
                                }
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localObject7);
                                i3 += 1;
                              }
                              catch (Exception localException3)
                              {
                                QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior " + localException3.toString());
                                continue;
                              }
                            }
                            catch (NumberFormatException paramJsBridgeListener)
                            {
                              QLog.e("PublicAccountH5AbilityPlugin", 1, "likeBiuFusionRequestBehavior jsapi " + paramJsBridgeListener.toString());
                            }
                            break;
                            localArticleInfo.mTitle = new String(bdfr.decode((String)localObject2, 0));
                            localArticleInfo.mSummary = "";
                            if ((i7 != 3) && (i7 != 2)) {
                              break label13301;
                            }
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                            paramString3 = new qmx();
                            Object localObject4 = ((JSONObject)localObject4).optJSONArray("ugcPicInfo");
                            if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
                              break label13295;
                            }
                            paramString3.jdField_c_of_type_JavaLangString = ((JSONArray)localObject4).getJSONObject(0).optString("ugcPicUrl");
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
                            break label13295;
                            if (i4 == 22)
                            {
                              paramString3 = new qlz();
                              paramString3.jdField_a_of_type_JavaLangString = paramString1;
                              paramString3.jdField_b_of_type_JavaLangString = str3;
                              paramString3.jdField_c_of_type_JavaLangString = str4;
                              paramString3.jdField_a_of_type_Long = l2;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qlz = paramString3;
                            }
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int = i7;
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
                            paramString1 = (String)localObject2;
                            localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
                            localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
                            localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
                            paramString3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
                            paramString3.putExtra("arg_article_info", localArticleInfo);
                            if (!TextUtils.isEmpty(paramString2)) {
                              paramString3.putExtra("biu_rowkey", paramString2);
                            }
                            paramString3.putExtra("arg_from_type", i4);
                            paramString3.putExtra("arg_type", i1);
                            paramString3.putExtra("result_js_callback", (String)localObject3);
                            i1 = 3;
                            if (i4 != 5) {
                              break label13325;
                            }
                            i1 = 4;
                            paramString3.putExtra("biu_src", i1);
                            paramString3.putExtra("feed_id", paramJsBridgeListener);
                            paramString3.putExtra("feedsType", i6);
                            paramString3.putExtra("ugc_comment", paramString1);
                            paramString3.putExtra("arg_account_id", l2);
                            paramString3.putExtra("arg_account_type", i2);
                            paramString3.putExtra("arg_source_url", str2);
                            if ((i4 == 23) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(localArticleInfo.mSubscribeName))))
                            {
                              QLog.d("PublicAccountH5AbilityPlugin", 1, "web page share but core info empty !");
                              return false;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
                              localObject5 = new qmy();
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcVideoInfo");
                              if (localObject4 == null) {
                                break label13316;
                              }
                              ((qmy)localObject5).jdField_d_of_type_JavaLangString = ((JSONObject)localObject4).optString("ugcVideoCoverUrl");
                              ((qmy)localObject5).jdField_a_of_type_Long = ((JSONObject)localObject4).optInt("ugcVideoDuration");
                              ((qmy)localObject5).jdField_e_of_type_JavaLangString = paramString3;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
                              break label13316;
                              if (i7 != 1) {
                                break label13322;
                              }
                              localArticleInfo.mFirstPagePicUrl = "";
                              break label13322;
                            }
                            if (i5 == 1)
                            {
                              if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                                break label13191;
                              }
                              paramJsBridgeListener = paramVarArgs + "//";
                              paramString1 = paramJsBridgeListener;
                              if (TextUtils.isEmpty(paramJsBridgeListener)) {
                                paramString1 = "Biu~";
                              }
                              paramJsBridgeListener = "：" + paramString1;
                              oxb.a().a(new sxy(this, (String)localObject3, i6));
                              ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a().a().a(this.mRuntime.a().getLongAccountUin(), l1, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc, 0L, paramJsBridgeListener, l3, -1L, i1, paramString2, i6, localArticleInfo);
                              break;
                            }
                            paramString3.putExtra("biu_src", 4);
                            paramString3.putExtra("arg_from_type", 0);
                            paramString3.putExtra("arg_biu_state", 0);
                            paramString3.putExtra("feedsType", 1);
                            paramString3.putExtra("fast_biu_type", false);
                            paramString3.putExtra("should_show_dialog", true);
                            paramString3.putExtra("is_modified_biu", true);
                            paramString3.putExtra("modified_feeds_id", l1);
                            this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString3, 113);
                            this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
                            break;
                            if ("showMultiBiuEditPage".endsWith(paramString3))
                            {
                              if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
                                break;
                              }
                              for (;;)
                              {
                                try
                                {
                                  if (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity)) {
                                    break;
                                  }
                                  localObject4 = new JSONObject(paramVarArgs[0]);
                                  if (QLog.isColorLevel()) {
                                    QLog.i("PublicAccountH5AbilityPlugin", 2, "web json:" + ((JSONObject)localObject4).toString());
                                  }
                                  localObject3 = ((JSONObject)localObject4).optString("title");
                                  paramString2 = ((JSONObject)localObject4).optString("sourceName");
                                  str2 = ((JSONObject)localObject4).optString("sourceUrl");
                                  if (!TextUtils.isEmpty(str2)) {
                                    break label13394;
                                  }
                                  str2 = paramString1;
                                  i5 = ((JSONObject)localObject4).optInt("hiddenBiuComponent");
                                  paramVarArgs = "";
                                  if (i5 == 1) {
                                    paramVarArgs = new String(bdfr.decode(((JSONObject)localObject4).optString("newComment"), 2));
                                  }
                                  l1 = 0L;
                                  l3 = 0L;
                                  l4 = 0L;
                                  l10 = 0L;
                                  l11 = 0L;
                                  localObject2 = "";
                                }
                                catch (JSONException paramJsBridgeListener)
                                {
                                  paramJsBridgeListener.printStackTrace();
                                }
                                for (;;)
                                {
                                  try
                                  {
                                    paramJsBridgeListener = new String(bdfr.decode((String)localObject3, 0));
                                  }
                                  catch (Exception paramString3)
                                  {
                                    paramString1 = paramString2;
                                    paramJsBridgeListener = "";
                                    l9 = l11;
                                    l8 = l10;
                                    paramString2 = (String)localObject3;
                                    break;
                                    i1 = 1;
                                    continue;
                                    if (i7 == 4) {
                                      continue;
                                    }
                                    if (i7 != 5) {
                                      continue;
                                    }
                                    continue;
                                    i1 = 2;
                                    continue;
                                    continue;
                                    if (i4 != 11) {
                                      continue;
                                    }
                                    i1 = 5;
                                    continue;
                                    if (i4 != 6) {
                                      continue;
                                    }
                                    i1 = 6;
                                    continue;
                                    if (i4 != 12) {
                                      continue;
                                    }
                                    i1 = 7;
                                    continue;
                                    if (i4 != 13) {
                                      continue;
                                    }
                                    i1 = 8;
                                    continue;
                                    if (i4 < 15) {
                                      continue;
                                    }
                                    i1 = i4;
                                    continue;
                                    paramJsBridgeListener = "0X8009E1E";
                                    continue;
                                    paramJsBridgeListener = "0X8009E20";
                                    continue;
                                  }
                                  try
                                  {
                                    paramString1 = new String(bdfr.decode(paramString2, 0));
                                  }
                                  catch (Exception paramString3)
                                  {
                                    localObject3 = paramJsBridgeListener;
                                    paramJsBridgeListener = "";
                                    paramString1 = paramString2;
                                    l9 = l11;
                                    l8 = l10;
                                    paramString2 = (String)localObject3;
                                    break;
                                  }
                                }
                                try
                                {
                                  paramString2 = ((JSONObject)localObject4).optString("feedsId");
                                  paramString3 = ((JSONObject)localObject4).optString("rowkey");
                                  localObject2 = paramString3;
                                  l2 = l1;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l1;
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = "";
                                  paramString2 = paramJsBridgeListener;
                                  paramJsBridgeListener = (JsBridgeListener)localObject3;
                                  l9 = l11;
                                  l8 = l10;
                                  continue;
                                }
                                try
                                {
                                  if (!TextUtils.isEmpty(paramString2))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l3;
                                    l5 = l1;
                                    l2 = new BigInteger(paramString2).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("ariticleId");
                                  l1 = l3;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l3;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l3;
                                    l5 = l2;
                                    l1 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("originFeedsId");
                                  l3 = l4;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l4;
                                  l6 = l1;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l4;
                                    l6 = l1;
                                    l5 = l2;
                                    l3 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  paramString3 = ((JSONObject)localObject4).optString("businessId");
                                  l4 = l10;
                                  l9 = l11;
                                  l8 = l10;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  if (!TextUtils.isEmpty(paramString3))
                                  {
                                    l9 = l11;
                                    l8 = l10;
                                    l7 = l3;
                                    l6 = l1;
                                    l5 = l2;
                                    l4 = new BigInteger(paramString3).longValue();
                                  }
                                  l9 = l11;
                                  l8 = l4;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  l10 = ((JSONObject)localObject4).optLong("accountID");
                                  l9 = l10;
                                  l8 = l4;
                                  l7 = l3;
                                  l6 = l1;
                                  l5 = l2;
                                  i2 = ((JSONObject)localObject4).optInt("accountType");
                                  l8 = l4;
                                  localObject3 = paramString2;
                                  paramString2 = (String)localObject2;
                                  l5 = l2;
                                  l4 = l3;
                                  l2 = l10;
                                  l3 = l1;
                                  paramString3 = paramJsBridgeListener;
                                  paramJsBridgeListener = (JsBridgeListener)localObject3;
                                  l1 = l5;
                                  l5 = ((JSONObject)localObject4).optLong("originFeedsType", 1L);
                                  i1 = ((JSONObject)localObject4).optInt("type");
                                  i4 = ((JSONObject)localObject4).optInt("adtag");
                                  str3 = ((JSONObject)localObject4).optString("picurl");
                                  i3 = ((JSONObject)localObject4).optInt("duration");
                                  localObject3 = ((JSONObject)localObject4).optString("callback");
                                  str4 = new String(bdfr.decode(((JSONObject)localObject4).optString("accountDesc"), 0));
                                  i6 = ((JSONObject)localObject4).optInt("feedsType", 1);
                                  localArticleInfo = new ArticleInfo();
                                  localArticleInfo.mArticleID = l3;
                                  localArticleInfo.mTitle = paramString3;
                                  localArticleInfo.mSubscribeName = paramString1;
                                  localArticleInfo.mFirstPagePicUrl = str3;
                                  localArticleInfo.mVideoDuration = i3;
                                  localArticleInfo.mFeedId = l1;
                                  localArticleInfo.mSummary = str4;
                                  localArticleInfo.businessId = l8;
                                  localArticleInfo.mFeedType = i6;
                                }
                                catch (Exception paramString3)
                                {
                                  localObject3 = paramJsBridgeListener;
                                  paramJsBridgeListener = paramString2;
                                  l4 = l7;
                                  l3 = l6;
                                  l1 = l5;
                                  paramString2 = (String)localObject3;
                                  continue;
                                }
                                try
                                {
                                  localObject2 = ((JSONObject)localObject4).getJSONArray("biuLevelList");
                                  localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc = new qmc();
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong = Long.valueOf(l4);
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_b_of_type_JavaLangLong = Long.valueOf(l5);
                                  localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
                                  if (localObject2 == null) {
                                    break label9500;
                                  }
                                  i3 = 0;
                                  if (i3 >= ((JSONArray)localObject2).length()) {
                                    break label9500;
                                  }
                                  localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
                                  localObject7 = ((JSONArray)localObject2).getJSONObject(i3);
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject7).optLong("uin"));
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString = new String(bdfr.decode(((JSONObject)localObject7).optString("comment"), 0));
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_JavaLangString = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangString;
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_Int = ((JSONObject)localObject7).optInt("biuTime");
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_Int = ((JSONObject)localObject7).optInt("feeds_type", 1);
                                  ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_c_of_type_Int = ((JSONObject)localObject7).optInt("op_type");
                                  localObject9 = ((JSONObject)localObject7).optString("jumpName");
                                  str5 = ((JSONObject)localObject7).optString("jumpUrl");
                                  if ((!TextUtils.isEmpty((CharSequence)localObject9)) && (!TextUtils.isEmpty(str5))) {
                                    ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdfr.decode((String)localObject9, 0)), str5);
                                  }
                                  if (i5 != 1) {}
                                }
                                catch (JSONException localJSONException2)
                                {
                                  try
                                  {
                                    localObject7 = ((JSONObject)localObject7).optString("feedsId");
                                    if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                                      ((SocializeFeedsInfo.BiuCommentInfo)localObject5).jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject7).longValue());
                                    }
                                    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localObject5);
                                    i3 += 1;
                                    continue;
                                    paramString3.printStackTrace();
                                    i2 = 0;
                                    l2 = l9;
                                    paramString3 = paramString2;
                                    paramString2 = (String)localObject2;
                                    continue;
                                    localJSONException2 = localJSONException2;
                                    localJSONException2.printStackTrace();
                                    str1 = null;
                                  }
                                  catch (Exception localException2)
                                  {
                                    localException2.printStackTrace();
                                  }
                                }
                              }
                              break;
                              localObject4 = ((JSONObject)localObject4).optJSONObject("ugcInfo");
                              str1 = "";
                              if ((localObject4 == null) || (!rqj.c(i6, l5))) {
                                break label13185;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw = new qmw();
                              i7 = ((JSONObject)localObject4).optInt("ugcType", 0);
                              str1 = ((JSONObject)localObject4).optString("ugcComment");
                              localObject5 = ((JSONObject)localObject4).optJSONArray("ugcAtLevelList");
                              if (localObject5 != null)
                              {
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc = new qmc();
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
                                i3 = 0;
                                for (;;)
                                {
                                  if (i3 < ((JSONArray)localObject5).length())
                                  {
                                    SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
                                    localObject9 = ((JSONArray)localObject5).getJSONObject(i3);
                                    localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((JSONObject)localObject9).optLong("uin"));
                                    localBiuCommentInfo.jdField_b_of_type_JavaLangString = new String(bdfr.decode(((JSONObject)localObject9).optString("comment"), 0));
                                    localBiuCommentInfo.jdField_a_of_type_JavaLangString = localBiuCommentInfo.jdField_b_of_type_JavaLangString;
                                    localBiuCommentInfo.jdField_a_of_type_Int = ((JSONObject)localObject9).optInt("biuTime");
                                    localBiuCommentInfo.jdField_b_of_type_Int = ((JSONObject)localObject9).optInt("feeds_type", 1);
                                    localBiuCommentInfo.jdField_c_of_type_Int = ((JSONObject)localObject9).optInt("op_type");
                                    str5 = ((JSONObject)localObject9).optString("jumpName");
                                    str6 = ((JSONObject)localObject9).optString("jumpUrl");
                                    if ((!TextUtils.isEmpty(str5)) && (!TextUtils.isEmpty(str6))) {
                                      localBiuCommentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$JumpInfo = new SocializeFeedsInfo.JumpInfo(0L, new String(bdfr.decode(str5, 0)), str6);
                                    }
                                    try
                                    {
                                      localObject9 = ((JSONObject)localObject9).optString("feedsId");
                                      if (!TextUtils.isEmpty((CharSequence)localObject9)) {
                                        localBiuCommentInfo.jdField_b_of_type_JavaLangLong = Long.valueOf(new BigInteger((String)localObject9).longValue());
                                      }
                                      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
                                      i3 += 1;
                                    }
                                    catch (Exception localException4)
                                    {
                                      for (;;)
                                      {
                                        localException4.printStackTrace();
                                      }
                                    }
                                  }
                                }
                              }
                              localArticleInfo.mTitle = new String(bdfr.decode(str1, 0));
                              localArticleInfo.mSummary = "";
                              if ((i7 != 3) && (i7 != 2)) {
                                break label13424;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
                              paramString3 = new qmx();
                              localObject4 = ((JSONObject)localObject4).optJSONArray("ugcPicInfo");
                              if ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0)) {
                                break label13418;
                              }
                              paramString3.jdField_c_of_type_JavaLangString = ((JSONArray)localObject4).getJSONObject(0).optString("ugcPicUrl");
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
                              break label13418;
                              if (i4 == 22)
                              {
                                paramString3 = new qlz();
                                paramString3.jdField_a_of_type_JavaLangString = paramString1;
                                paramString3.jdField_b_of_type_JavaLangString = str3;
                                paramString3.jdField_c_of_type_JavaLangString = str4;
                                paramString3.jdField_a_of_type_Long = l2;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Qlz = paramString3;
                              }
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int = i7;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
                              paramString1 = str1;
                              localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
                              localArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString = "";
                              localArticleInfo.mSocialFeedInfo.jdField_b_of_type_JavaLangString = "";
                              paramString3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyDeliverBiuActivity.class);
                              paramString3.putExtra("arg_article_info", localArticleInfo);
                              if (!TextUtils.isEmpty(paramString2)) {
                                paramString3.putExtra("biu_rowkey", paramString2);
                              }
                              paramString3.putExtra("arg_from_type", i4);
                              paramString3.putExtra("arg_type", i1);
                              paramString3.putExtra("result_js_callback", (String)localObject3);
                              i1 = 3;
                              if (i4 != 5) {
                                break label13448;
                              }
                              i1 = 4;
                              paramString3.putExtra("biu_src", i1);
                              paramString3.putExtra("feed_id", paramJsBridgeListener);
                              paramString3.putExtra("feedsType", i6);
                              paramString3.putExtra("ugc_comment", paramString1);
                              paramString3.putExtra("arg_account_id", l2);
                              paramString3.putExtra("arg_account_type", i2);
                              paramString3.putExtra("arg_source_url", str2);
                              if ((i4 == 23) && ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(localArticleInfo.mSubscribeName))))
                              {
                                QLog.d("PublicAccountH5AbilityPlugin", 1, "web page share but core info empty !");
                                return false;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
                                localObject5 = new qmy();
                                localObject4 = ((JSONObject)localObject4).optJSONObject("ugcVideoInfo");
                                if (localObject4 == null) {
                                  break label13439;
                                }
                                ((qmy)localObject5).jdField_d_of_type_JavaLangString = ((JSONObject)localObject4).optString("ugcVideoCoverUrl");
                                ((qmy)localObject5).jdField_a_of_type_Long = ((JSONObject)localObject4).optInt("ugcVideoDuration");
                                ((qmy)localObject5).jdField_e_of_type_JavaLangString = paramString3;
                                localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_b_of_type_JavaUtilArrayList.add(localObject5);
                                break label13439;
                                if (i7 != 1) {
                                  break label13445;
                                }
                                localArticleInfo.mFirstPagePicUrl = "";
                                break label13445;
                              }
                              if (i5 == 1)
                              {
                                if ((localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList == null) || (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList.size() <= 0)) {
                                  break label13179;
                                }
                                paramJsBridgeListener = paramVarArgs + "//";
                                paramString1 = paramJsBridgeListener;
                                if (TextUtils.isEmpty(paramJsBridgeListener)) {
                                  paramString1 = "Biu~";
                                }
                                paramJsBridgeListener = "：" + paramString1;
                                paramString1 = ((BrowserAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
                                oxb.a().a(new sxy(this, (String)localObject3, i6));
                                paramString1.a().a(this.mRuntime.a().getLongAccountUin(), l1, localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc, 0L, paramJsBridgeListener, l3, -1L, i1, paramString2, i6, localArticleInfo);
                                break;
                              }
                              this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramString3, 113);
                              this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 0);
                              break;
                            }
                            if ("showUGCEditPage".endsWith(paramString3))
                            {
                              if ((paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(this.jdField_a_of_type_AndroidAppActivity instanceof QQBrowserActivity))) {
                                break;
                              }
                              rvv.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, new PublicAccountH5AbilityPlugin.5(this, paramVarArgs));
                              break;
                            }
                            if (!"showUGCVideoUploadPage".equals(paramString3)) {
                              break label10788;
                            }
                            try
                            {
                              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() param json:" + paramJsBridgeListener.toString());
                            }
                            catch (Exception paramJsBridgeListener) {}
                          }
                          if (!QLog.isColorLevel()) {
                            break;
                          }
                          QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoUploadPage() Exception=" + paramJsBridgeListener.getMessage());
                          break;
                          if ("showUGCVideoRecordPage".equals(paramString3))
                          {
                            rvv.a((BaseActivity)this.jdField_a_of_type_AndroidAppActivity, new PublicAccountH5AbilityPlugin.6(this, paramVarArgs));
                            break;
                          }
                          if (!"sharePicToWeChatCircle".equals(paramString3)) {
                            break label10894;
                          }
                          try
                          {
                            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).getString("pictureUrl");
                            if (!TextUtils.isEmpty(paramJsBridgeListener)) {
                              break label10886;
                            }
                            if (!QLog.isColorLevel()) {
                              break;
                            }
                            QLog.d("PublicAccountH5AbilityPlugin", 2, "url is null");
                          }
                          catch (JSONException paramJsBridgeListener)
                          {
                            paramJsBridgeListener.printStackTrace();
                          }
                        }
                        break;
                        e(paramJsBridgeListener);
                        break;
                        if (!"updateTopicCardFollowInfo".equals(paramString3)) {
                          break label11002;
                        }
                        try
                        {
                          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                          i1 = paramJsBridgeListener.getInt("topicId");
                          i2 = paramJsBridgeListener.getInt("followInfo");
                          if (QLog.isColorLevel()) {
                            QLog.d("PublicAccountH5AbilityPlugin", 2, "topic id = " + i1 + "\t follow info =" + i2);
                          }
                          this.jdField_a_of_type_Yqz.a(i1, i2);
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                      }
                      break;
                      label11002:
                      if ("showCommentEditor".equals(paramString3))
                      {
                        try
                        {
                          paramString3 = new JSONObject(paramVarArgs[0]);
                          if (!paramString3.has("enableAnonymous")) {
                            break label13173;
                          }
                          bool1 = paramString3.optBoolean("enableAnonymous");
                          if (!paramString3.has("canBiu")) {
                            break label13167;
                          }
                          bool2 = paramString3.optBoolean("canBiu");
                          if (!paramString3.has("placeholder")) {
                            break label13161;
                          }
                          paramJsBridgeListener = paramString3.optString("placeholder");
                          QLog.d("PublicAccountH5AbilityPlugin", 2, "ph5 | comment_placeholder : " + paramJsBridgeListener);
                        }
                        catch (JSONException paramJsBridgeListener)
                        {
                          paramJsBridgeListener.printStackTrace();
                        }
                        try
                        {
                          paramString1 = new String(bdfr.decode(paramJsBridgeListener, 0));
                          paramJsBridgeListener = paramString1;
                        }
                        catch (Exception paramString1)
                        {
                          paramString1.printStackTrace();
                          break label11130;
                        }
                        QLog.d("PublicAccountH5AbilityPlugin", 2, "ph5 | comment_placeholder after decode: " + paramJsBridgeListener);
                        paramString1 = paramJsBridgeListener;
                        if (!paramString3.has("defaultTxt")) {
                          break label13155;
                        }
                        paramJsBridgeListener = paramString3.optString("defaultTxt");
                        try
                        {
                          paramString2 = new String(bdfr.decode(paramJsBridgeListener, 0));
                          paramJsBridgeListener = paramString2;
                        }
                        catch (Exception paramString2)
                        {
                          for (;;)
                          {
                            paramString2.printStackTrace();
                          }
                        }
                        if (!paramString3.has("maxLength")) {
                          break label13149;
                        }
                        i1 = paramString3.optInt("maxLength", -1);
                        if (!paramString3.has("commentType")) {
                          break label13143;
                        }
                        i2 = paramString3.optInt("commentType", 0);
                        i3 = 0;
                        if (paramString3.has("sourceType")) {
                          i3 = paramString3.optInt("sourceType", 0);
                        }
                        paramString2 = paramString3.optString("callback");
                        paramVarArgs = paramString3.optJSONArray("defaultCommentAtLevel");
                        i4 = paramString3.optInt("openAt", 0);
                        paramString3 = new Intent();
                        paramString3.putExtra("comment_type", false);
                        paramString3.putExtra("arg_comment_enable_anonymous", bool1);
                        paramString3.putExtra("arg_comment_placeholder", paramString1);
                        paramString3.putExtra("arg_comment_default_txt", paramJsBridgeListener);
                        paramString3.putExtra("arg_comment_max_length", i1);
                        paramString3.putExtra("arg_comment_comment_type", i2);
                        paramString3.putExtra("arg_comment_source_type", i3);
                        paramString3.putExtra("arg_callback", paramString2);
                        paramString3.putExtra("arg_comment_open_at", i4);
                        paramString3.putExtra("comment_can_biu", bool2);
                        paramString3.putExtra("public_fragment_window_feature", 1);
                        if (paramVarArgs != null) {
                          paramString3.putExtra("arg_comment_default_comment_at", paramVarArgs.toString());
                        }
                        PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramString3, ReadInJoyCommentComponentFragment.class, 117);
                        break;
                        break;
                      }
                      label11130:
                      if ("showPicture".equals(paramString3))
                      {
                        d(paramVarArgs[0]);
                        break;
                      }
                      if (!"showNativeAd".equals(paramString3)) {
                        break label11624;
                      }
                      paramJsBridgeListener = null;
                      try
                      {
                        paramString1 = new JSONObject(paramVarArgs[0]).optString("callback");
                        paramJsBridgeListener = paramString1;
                        paramString2 = new Intent();
                        paramJsBridgeListener = paramString1;
                        paramString2.putExtra("param_ad_json", paramVarArgs[0]);
                        paramJsBridgeListener = paramString1;
                        PublicTransFragmentActivity.b(this.jdField_a_of_type_AndroidAppActivity, paramString2, ReadInJoyNativeAdFragment.class);
                        paramJsBridgeListener = paramString1;
                        callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                      }
                      catch (Exception paramString1)
                      {
                        paramString1.printStackTrace();
                        callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                      }
                    }
                    break;
                    label11624:
                    if (!"preloadNativeAdResource".equals(paramString3)) {
                      break label11793;
                    }
                    paramString1 = null;
                    paramJsBridgeListener = paramString1;
                    try
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramJsBridgeListener = paramString1;
                      paramString1 = paramString2.optString("callback");
                      paramJsBridgeListener = paramString1;
                      paramString2 = paramString2.optJSONArray("resourceList");
                      paramJsBridgeListener = paramString1;
                      paramString3 = new ArrayList();
                      i1 = 0;
                      for (;;)
                      {
                        paramJsBridgeListener = paramString1;
                        if (i1 >= paramString2.length()) {
                          break;
                        }
                        paramJsBridgeListener = paramString1;
                        paramString3.add(paramString2.getJSONObject(i1).optString("url"));
                        i1 += 1;
                      }
                      paramJsBridgeListener = paramString1;
                      this.jdField_a_of_type_Yqz.b(paramString3);
                      paramJsBridgeListener = paramString1;
                      callJs(paramString1, new String[] { new JSONObject().put("retCode", 0).toString() });
                    }
                    catch (Exception paramString1)
                    {
                      paramString1.printStackTrace();
                      callJs(paramJsBridgeListener, new String[] { "{\"retCode\":-1}" });
                    }
                  }
                  break;
                  if (!"getLocalCache".equals(paramString3)) {
                    break label12059;
                  }
                  try
                  {
                    for (;;)
                    {
                      paramString2 = new JSONObject(paramVarArgs[0]);
                      paramString1 = paramString2.optString("callback");
                      if (paramString2.has("localkey")) {
                        paramString2.optString("localkey", "");
                      }
                      paramJsBridgeListener = "";
                      if (paramString2.has("scene")) {
                        paramJsBridgeListener = paramString2.optString("scene", "");
                      }
                      if (!"messageBox".equals(paramJsBridgeListener)) {
                        break label11967;
                      }
                      paramJsBridgeListener = this.jdField_a_of_type_Red.a("CMD_GET_UNREAD_MESSAGE_BOX_DATA", null).getString("VALUE_UNREAD_MESSAGE_BOX_DATA", "");
                      bool1 = "".equals(paramJsBridgeListener);
                      if (bool1) {
                        break;
                      }
                      try
                      {
                        paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                        callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                      }
                      catch (JSONException paramJsBridgeListener)
                      {
                        paramJsBridgeListener.printStackTrace();
                      }
                    }
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    paramJsBridgeListener.printStackTrace();
                  }
                }
                break;
                if (!"commentPage".equals(paramJsBridgeListener)) {
                  break;
                }
                paramJsBridgeListener = this.jdField_a_of_type_Red.a("CMD_GET_CLICK_COMMENT_ACTICLEINFO", null).getString("VALUE_CLICK_COMMENT_ACTICLEINFO", "");
                bool1 = "".equals(paramJsBridgeListener);
                if (bool1) {
                  break;
                }
                try
                {
                  paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
                  callJs(paramString1, new String[] { new JSONObject().put("retData", paramJsBridgeListener).toString() });
                }
                catch (JSONException paramJsBridgeListener)
                {
                  paramJsBridgeListener.printStackTrace();
                }
              }
              break;
              if (!"updateAccountCardFollowInfo".equals(paramString3)) {
                break label12259;
              }
              try
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "updateAccountCardFollowInfo jsonObject = " + paramJsBridgeListener);
                }
                l1 = paramJsBridgeListener.getLong("followUin");
                i1 = paramJsBridgeListener.getInt("followInfo");
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountH5AbilityPlugin", 2, "topic id = " + l1 + "\t follow info =" + i1);
                }
                this.jdField_a_of_type_Yqz.a(l1, i1);
                this.mRuntime.a().setResult(-1, new Intent().putExtra("followInfo", i1));
              }
              catch (JSONException paramJsBridgeListener)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("PublicAccountH5AbilityPlugin", 2, "updateAccountCardFollowInfo e = " + paramJsBridgeListener);
                }
                paramJsBridgeListener.printStackTrace();
              }
            }
            break;
            label12259:
            if ("selectAndInviteFriend".equals(paramString3))
            {
              a(paramString3, paramVarArgs);
              break;
            }
            if (!"addPreDownloadVideo".equals(paramString3)) {
              break label12474;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload addPreDownloadVideo");
            }
            if (this.jdField_a_of_type_Rlk == null) {
              this.jdField_a_of_type_Rlk = new rlk();
            }
            paramJsBridgeListener = this.jdField_a_of_type_Rlk;
            try
            {
              paramJsBridgeListener.a(new sxv(this));
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramString2 = paramString1.optString("callback");
              paramString3 = paramString1.optString("video_vid");
              i1 = paramString1.optInt("busitype", -1);
              i2 = paramString1.optInt("video_duration", 0);
              i3 = paramString1.optInt("cache_duration", 0);
              paramVarArgs = paramString1.optString("video_url");
              if (QLog.isColorLevel()) {
                QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload addPreDownloadVideo , content = " + paramString1.toString());
              }
              paramJsBridgeListener.a(paramString3, i1, i2, i3, paramVarArgs, paramString2);
            }
            catch (JSONException paramJsBridgeListener)
            {
              paramJsBridgeListener.printStackTrace();
            }
          }
          break;
          if ("stopPreDownloadVideo".equals(paramString3))
          {
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountH5AbilityPlugin", 2, "WebVideoPredownload stopPreDownloadVideo");
            }
            paramJsBridgeListener = this.jdField_a_of_type_Rlk;
            if (paramJsBridgeListener == null) {
              break;
            }
            paramJsBridgeListener.a();
            break;
          }
          if (!"openViola".equals(paramString3)) {
            break label12608;
          }
          paramJsBridgeListener = new Bundle();
          try
          {
            paramString2 = new JSONObject(paramVarArgs[0]);
            paramString1 = paramString2.getString("url");
            paramString2 = paramString2.optString("webUrl", "");
            paramJsBridgeListener.putString("url", paramString1);
            paramJsBridgeListener.putString("webUrl", paramString2);
            if (this.jdField_a_of_type_Red == null) {
              break;
            }
            this.jdField_a_of_type_Red.a("CMD_OPEN_VIOLA_FROM_TOOL", paramJsBridgeListener);
          }
          catch (JSONException paramJsBridgeListener) {}
        }
        break;
        if (!"showVisibleUserList".equals(paramString3)) {
          break label12713;
        }
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("feedsId");
          QLog.d("PublicAccountH5AbilityPlugin", 2, "showVisibleUserList feedsId " + paramJsBridgeListener);
          paramString1 = new Intent();
          paramString1.putExtra("feeds_id", new BigInteger(paramJsBridgeListener).longValue());
          PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, ReadInJoyPrivacyListFragment.class);
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      break label4481;
      if ("reportKandian".equals(paramString3)) {
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            i1 = paramString1.optInt("op");
            paramString2 = paramString1.optString("bid");
            paramString3 = paramString1.optString("data");
            paramVarArgs = paramString1.optString("callback");
            switch (i1)
            {
            case 1: 
              QLog.d("PublicAccountH5AbilityPlugin", 1, "reportKandian " + i1 + " " + paramString2 + " " + paramString3);
              nrt.a(null, "", paramJsBridgeListener, paramJsBridgeListener, 0, 0, "", "", paramString2, paramString1.toString(), false);
              callJs(paramVarArgs, new String[] { new JSONObject().put("retCode", 0).toString() });
            }
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
          }
          break;
          paramJsBridgeListener = "0X8009D64";
          continue;
          paramJsBridgeListener = "0X8009E1F";
        }
      }
      if (!"showReadInJoyNativeCommentView".equals(paramString3)) {
        break label4481;
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
        a(new JSONObject(paramVarArgs[0]), paramJsBridgeListener, new sxw(this));
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          QLog.e("PublicAccountH5AbilityPlugin", 1, "showReadInJoyNativeCommentView Exception:", paramJsBridgeListener);
        }
      }
      label13149:
      label13155:
      label13161:
      label13167:
      label13173:
      label13179:
      do
      {
        bool1 = false;
        break label4236;
        i1 = 0;
        break label2574;
        break;
        return true;
        return true;
        i3 = 9;
        break;
        return true;
        return true;
        return true;
        if (i5 == 1) {
          break label4217;
        }
      } while (i5 != 2);
      break label4217;
      return true;
      paramJsBridgeListener = "normalBiu";
      break label5116;
      paramString1 = "normalBiu";
      break label5127;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.n = "";
    this.o = "";
    this.p = "";
  }
  
  public void j()
  {
    Object localObject = alof.aX + "c2bCAM/";
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
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755801);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2131559437);
        ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131371894)).setText(alud.a(2131709202));
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
    if (this.jdField_a_of_type_Yqz == null) {
      this.jdField_a_of_type_Yqz = yqz.a();
    }
    this.jdField_a_of_type_Yqz.e();
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
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005872", "0X8005872", 0, 0, "1", "", "", "");
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
        break label1718;
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
          azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
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
                paramIntent.put("msg", alud.a(2131709180));
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
            if (paramInt == 1699)
            {
              localObject2 = new Bundle();
              ((Bundle)localObject2).putParcelable("action_update_biu_and_comment_request", paramIntent);
              QIPCClientHelper.getInstance().callServer("ReadInJoyIPCModule", "action_update_biu_and_comment_request_action", (Bundle)localObject2, new sxq(this, (String)localObject1));
              return;
            }
            paramIntent = paramIntent.getStringExtra("arg_result_json");
            if (paramIntent == null) {}
          }
        }
        label1718:
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
      if (this.jdField_a_of_type_Yqz != null) {
        this.jdField_a_of_type_Yqz.b();
      }
      a().clear();
      if (this.jdField_a_of_type_Sxb != null) {
        this.jdField_a_of_type_Sxb.f();
      }
    }
    if (this.jdField_a_of_type_Rlk != null)
    {
      this.jdField_a_of_type_Rlk.b();
      this.jdField_a_of_type_Rlk = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxe
 * JD-Core Version:    0.7.0.1
 */