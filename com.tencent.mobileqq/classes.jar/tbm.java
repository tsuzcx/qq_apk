import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.3;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class tbm
{
  private static final String jdField_a_of_type_JavaLangString = tbm.class.getSimpleName();
  private biau jdField_a_of_type_Biau;
  private bihh jdField_a_of_type_Bihh;
  private String b;
  
  private int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 13;
    }
    return i;
  }
  
  private String a(AccountDetail paramAccountDetail, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = localObject1;
      if (paramAccountDetail != null) {
        paramString1 = paramAccountDetail.name;
      }
      paramAccountDetail = paramString1;
      if (TextUtils.isEmpty(paramString1))
      {
        paramAccountDetail = paramString1;
        if (paramJSONObject.has("sourceName")) {
          paramAccountDetail = paramJSONObject.optString("sourceName");
        }
      }
      paramJSONObject = paramAccountDetail;
      if (!TextUtils.isEmpty(paramAccountDetail)) {}
    }
    else
    {
      do
      {
        return paramString2;
        paramString1 = localObject2;
        if (paramJSONObject.has("sourceName")) {
          paramString1 = paramJSONObject.optString("sourceName");
        }
        paramJSONObject = paramString1;
        if (TextUtils.isEmpty(paramString1))
        {
          paramJSONObject = paramString1;
          if (paramAccountDetail != null) {
            paramJSONObject = paramAccountDetail.name;
          }
        }
      } while (TextUtils.isEmpty(paramJSONObject));
    }
    return paramJSONObject;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 45) {
        str = paramString.substring(0, 45) + "…";
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new tci(paramString1).a("title", paramString2).a("url", paramString3).a("pic", paramString4).a("_wv", "3").a();
  }
  
  private void a(long paramLong, AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent)
  {
    abcr.a(paramAppInterface, paramActivity, paramAppInterface.getAccount(), paramLong, 3000L, new tbo(this, paramIntent, paramActivity));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Biau == null) {
      this.jdField_a_of_type_Biau = new biau(paramActivity);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArticleInfo == null)) {
      return;
    }
    paramContext = pha.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1");
    try
    {
      paramContext.put("location", paramInt);
      tcc.a(paramArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, ArticleInfo paramArticleInfo, int paramInt2)
  {
    if (paramInt2 == -1)
    {
      a(paramContext, paramString, paramInt1, paramArticleInfo);
      return;
    }
    paramContext = pha.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1", paramInt2);
    try
    {
      paramContext.put("location", paramInt1);
      tcc.a(paramArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramIntent.putExtra(paramString1, paramString2);
  }
  
  private void a(Intent paramIntent, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    int i = 2;
    if ("audio".equals(paramString1)) {
      paramIntent.putExtra("audio_url", paramString2);
    }
    for (;;)
    {
      int j = i;
      if (i == 1) {
        j = 144;
      }
      paramIntent.putExtra("req_type", j);
      if (paramJSONObject.has("report")) {
        paramIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      return;
      i = paramJSONObject.optInt("req_type", 1);
      if (i == 2) {
        paramIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
      }
    }
  }
  
  private void a(Intent paramIntent, String paramString1, JSONObject paramJSONObject, String paramString2, boolean paramBoolean)
  {
    if ((paramIntent == null) || (paramJSONObject == null)) {}
    while (!paramJSONObject.has(paramString2)) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      paramIntent.putExtra(paramString1, Integer.parseInt(paramJSONObject.getString(paramString2)));
      return;
    }
    catch (JSONException paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleShareMsgToQQParams] paramsKey = " + paramString2 + ", e = " + paramIntent);
      return;
      paramIntent.putExtra(paramString1, paramJSONObject.getString(paramString2));
      return;
    }
    catch (NumberFormatException paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleShareMsgToQQParams] paramsKey = " + paramString2 + ", e = " + paramIntent);
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject)
  {
    paramIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    boolean bool = paramJSONObject.optBoolean("back", false);
    if (paramJSONObject.has("k_back")) {
      bool = paramJSONObject.getBoolean("k_back");
    }
    paramIntent.putExtra("k_back", bool);
    if (paramJSONObject.has("serviceID")) {
      paramIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
    }
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, Activity paramActivity)
  {
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      paramJSONObject = (AppInterface)pha.a();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.jdField_a_of_type_Biau.isShowing())
        {
          this.jdField_a_of_type_Biau.c(2131693478);
          this.jdField_a_of_type_Biau.show();
        }
        paramIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        a(l, paramJSONObject, paramActivity, paramIntent);
      }
      return;
    }
    a(paramActivity);
    if ((this.jdField_a_of_type_Biau != null) && (this.jdField_a_of_type_Biau.isShowing()))
    {
      l = System.currentTimeMillis();
      QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      this.jdField_a_of_type_Biau.dismiss();
    }
    Object localObject2 = paramJSONObject.optString("puin", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramJSONObject.optString("oaUin");
    }
    Object localObject3;
    String str;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = (AppInterface)pha.a();
      localObject3 = ((AppInterface)localObject2).getEntityManagerFactory(((AppInterface)localObject2).getAccount()).createEntityManager();
      localObject2 = (AccountDetail)((EntityManager)localObject3).find(AccountDetail.class, (String)localObject1);
      ((EntityManager)localObject3).close();
      localObject3 = paramJSONObject.optString("src_action", "");
      str = a((AccountDetail)localObject2, (String)localObject3, paramJSONObject, (String)localObject1);
      if (str.equalsIgnoreCase(paramActivity.getString(2131698461)))
      {
        boolean bool = str.equalsIgnoreCase(paramActivity.getString(2131698461));
        if (bool)
        {
          paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          if (!bool) {
            break label404;
          }
          localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          label295:
          if (!bool) {
            break label412;
          }
          localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          label305:
          paramIntent.putExtra("source_puin", (String)localObject1);
          paramIntent.putExtra("struct_share_key_source_action", "plugin");
          paramIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_i_action_data", (String)localObject2);
          paramIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
          paramIntent.putExtra("struct_share_key_source_icon", (String)localObject3);
          paramIntent.putExtra("app_name", str);
        }
      }
    }
    for (;;)
    {
      paramJSONObject = bcwd.a(paramIntent.getExtras());
      if (paramJSONObject != null) {
        break label519;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
      return;
      paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
      break;
      label404:
      localObject2 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
      break label295;
      label412:
      localObject3 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
      break label305;
      a(paramIntent, paramJSONObject, (String)localObject3, (String)localObject1, str);
      continue;
      if (paramJSONObject.has("sourceName"))
      {
        localObject1 = paramJSONObject.optString("sourceName");
        paramIntent.putExtra("app_name", (String)localObject1);
        if (("手Q阅读".equals(localObject1)) && (paramJSONObject.has("srcIconUrl"))) {
          paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
      }
      else
      {
        paramIntent.putExtra("app_name", paramActivity.getString(2131695713));
      }
    }
    label519:
    paramIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
    paramActivity.startActivityForResult(paramIntent, 1);
  }
  
  private void a(Intent paramIntent, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    String str1 = paramJSONObject.optString("src_webActionUrl", "");
    String str2 = paramJSONObject.optString("src_actionData", "");
    String str3 = paramJSONObject.optString("src_a_actionData", "");
    String str4 = paramJSONObject.optString("src_i_actionData", "");
    if ((TextUtils.isEmpty(paramString1)) || (("web".equals(paramString1)) && ((TextUtils.isEmpty(str1)) || (str1.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString1)) && (TextUtils.isEmpty(str2)) && ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))))
    {
      paramString1 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString2 });
      str1 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString2 });
      paramIntent.putExtra("struct_share_key_source_action", "plugin");
      paramIntent.putExtra("struct_share_key_source_a_action_data", paramString1);
      paramIntent.putExtra("struct_share_key_source_i_action_data", str1);
    }
    for (;;)
    {
      paramIntent.putExtra("source_puin", paramString2);
      paramIntent.putExtra("app_name", paramString3);
      paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        break;
      }
      paramIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
      return;
      paramIntent.putExtra("struct_share_key_source_action", paramString1);
      if ("web".equals(paramString1))
      {
        paramIntent.putExtra("struct_share_key_source_url", str1);
        paramIntent.putExtra("source_url", str1);
      }
      else
      {
        a(paramIntent, "struct_share_key_source_action_data", str2);
        a(paramIntent, "struct_share_key_source_a_action_data", str3);
        a(paramIntent, "struct_share_key_source_i_action_data", str4);
      }
    }
    paramIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Bihh != null) {
      return;
    }
    this.jdField_a_of_type_Bihh = new tbn(this, paramArticleInfo, paramInt);
    WXShareHelper.a().a(this.jdField_a_of_type_Bihh);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, ArticleInfo paramArticleInfo, String paramString7, Activity paramActivity, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(1);
    AppInterface localAppInterface = (AppInterface)pha.a();
    int j = -1;
    int i;
    if (paramInt == 9)
    {
      i = 3;
      if (WXShareHelper.a().a()) {
        break label60;
      }
      paramInt = 2131719199;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label79;
      }
      zvc.a(0, paramInt);
      return;
      i = 4;
      break;
      label60:
      paramInt = j;
      if (!WXShareHelper.a().b()) {
        paramInt = 2131719200;
      }
    }
    label79:
    a(paramArticleInfo, i);
    paramString1 = new FastWebShareUtils.2(this, localHashMap, paramBoolean, paramString3, paramString4, paramString5, paramString1, paramString2, localAppInterface, paramString7, paramArticleInfo, i);
    if (TextUtils.isEmpty(paramString6))
    {
      paramString1.run();
      return;
    }
    a(paramActivity);
    this.jdField_a_of_type_Biau.c(2131693478);
    this.jdField_a_of_type_Biau.show();
    ThreadManager.post(new FastWebShareUtils.3(this, paramString6, paramBoolean, localHashMap, localAppInterface, paramString1), 8, null, false);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, ArticleInfo paramArticleInfo, String paramString4, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)pha.a();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
      }
      QQToast.a(BaseApplication.getContext(), 0, 2131718007, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = a("https://v.t.sina.com.cn/share/share.php?", paramString1, paramString2, paramString3);
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
        }
        a(localAppInterface.getApplication().getApplicationContext(), paramString4, 6, paramArticleInfo);
        tcc.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 5, -1, false);
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QQToast.a(BaseApplication.getContext(), 0, 2131718007, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298998));
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina error! msg=" + paramString1);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
  }
  
  private void a(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject, String paramString4, ArticleInfo paramArticleInfo, String paramString5, Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)pha.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramString1);
    localBundle.putString("desc", paramString2);
    localBundle.putString("detail_url", paramString3);
    localBundle.putString("from", "qq");
    if (paramJSONObject != null) {
      localBundle.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramString1 = new ArrayList(1);
    if ((TextUtils.isEmpty(paramString4)) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl))) {
      paramString1.add(paramArticleInfo.mFirstPagePicUrl);
    }
    for (;;)
    {
      localBundle.putStringArrayList("image_url", paramString1);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putInt("iUrlInfoFrm", 1);
      localBundle.putLong("share_begin_time", bhpv.b);
      if (bltb.a(localAppInterface, paramActivity, localBundle, null, 1)) {
        break;
      }
      zvc.a(1, 2131689486);
      tcc.b(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false, false);
      return;
      paramString1.add(paramString4);
    }
    a(localAppInterface.getApplication().getApplicationContext(), paramString5, 3, paramArticleInfo);
    tcc.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false);
  }
  
  public static boolean a()
  {
    return TextUtils.equals("1", (CharSequence)bmqa.a("kandian_daily_fast_web_bottom_share", "0"));
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 5);
  }
  
  private String b(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 60) {
        str = paramString.substring(0, 60) + "…";
      }
    }
    return str;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bihh != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_Bihh);
    }
    this.jdField_a_of_type_Biau = null;
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    String str1 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str2 = paramJSONObject.optString("friendName");
    if (a(str1))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str1);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str2);
    }
    for (;;)
    {
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString1 = a(paramString1);
      paramString2 = b(paramString2);
      paramInt = a(paramInt);
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", paramString1);
      localIntent.putExtra("desc", paramString2);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", paramInt);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131695697, new Object[] { paramString1 }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
      a(localIntent, "struct_share_key_content_action", paramJSONObject, "contentAction", false);
      a(localIntent, "struct_share_key_content_action_DATA", paramJSONObject, "actionData", false);
      a(localIntent, "struct_share_key_source_action", paramJSONObject, "sourceAction", false);
      a(localIntent, "is_share_flag", paramJSONObject, "isShareFlag", true);
      a(localIntent, "struct_share_key_source_action_data", paramJSONObject, "srcActionData", false);
      a(localIntent, "app_name", paramJSONObject, "appName", false);
      a(localIntent, paramString5, paramString6, paramJSONObject);
      a(localIntent, paramJSONObject);
      a(localIntent, paramJSONObject, paramActivity);
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt1, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    AppInterface localAppInterface = (AppInterface)pha.a();
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    boolean bool1;
    try
    {
      paramString3 = new JSONObject(paramString3);
      str1 = paramString3.optString("share_type", "0");
      str2 = paramString3.optString("title");
      str3 = paramString3.optString("desc");
      str4 = paramString3.optString("share_url");
      str5 = paramString3.optString("image_url");
      str6 = paramString3.optString("shareElement");
      str7 = paramString3.optString("flash_url");
      boolean bool2 = false;
      bool1 = bool2;
      if ((paramActivity instanceof FastWebActivity))
      {
        bool1 = bool2;
        if ("2".equals(str1))
        {
          if (paramString3.optInt("mini_program_enabled", 1) != 1) {
            break label411;
          }
          bool1 = true;
          break label407;
        }
      }
      if (paramArticleInfo == null) {
        break label417;
      }
      paramString1 = paramArticleInfo.innerUniqueID;
      label149:
      i = paramString3.optInt("shareQQType", 13);
      if (paramInt1 != 72) {
        break label425;
      }
      paramString3.put("toUin", paramString4);
      paramString3.put("uinType", paramInt2);
      paramString3.put("friendName", paramString5);
      a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
      a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
      tcc.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 1, 19, false);
      return;
    }
    catch (Exception paramArticleInfo)
    {
      String str6;
      String str7;
      int i;
      label255:
      QLog.d(jdField_a_of_type_JavaLangString, 1, "doShareAction error! msg=" + paramArticleInfo);
      return;
    }
    a(paramActivity, paramString3, str2, str3, str4, str5, str6, str7, i);
    a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
    tcc.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 1, -1, false);
    return;
    label338:
    if (paramInt1 == 3)
    {
      a(str2, str3, str4, paramString3, str5, paramArticleInfo, paramString2, paramActivity);
      return;
    }
    for (;;)
    {
      label362:
      a(paramString1, str1, paramInt1, str2, str3, str4, str5, paramArticleInfo, paramString2, paramActivity, bool1);
      return;
      label407:
      label411:
      label417:
      label425:
      do
      {
        if (paramInt1 == 12)
        {
          a(str2, str4, str5, paramArticleInfo, paramString2, paramActivity);
          return;
        }
        for (;;)
        {
          break;
          return;
          bool1 = false;
        }
        paramString1 = "";
        break label149;
        if (paramInt1 == 2) {
          break label255;
        }
        if (paramInt1 != 73) {
          break label338;
        }
        break label255;
        if (paramInt1 == 9) {
          break label362;
        }
      } while (paramInt1 != 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbm
 * JD-Core Version:    0.7.0.1
 */