import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils.4;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class raj
{
  private bbms jdField_a_of_type_Bbms;
  private bbsh jdField_a_of_type_Bbsh;
  private final String jdField_a_of_type_JavaLangString = raj.class.getSimpleName();
  private String b;
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(paramActivity);
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArticleInfo == null)) {
      return;
    }
    paramContext = obz.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1");
    try
    {
      paramContext.put("location", paramInt);
      raz.a(paramArticleInfo, paramString, paramContext.toString());
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
    paramContext = obz.a(paramContext, paramArticleInfo, (int)paramArticleInfo.mChannelID, "1", paramInt2);
    try
    {
      paramContext.put("location", paramInt1);
      raz.a(paramArticleInfo, paramString, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Bbsh != null) {
      return;
    }
    this.jdField_a_of_type_Bbsh = new rak(this, paramArticleInfo, paramInt);
    WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
  }
  
  public static boolean a()
  {
    return TextUtils.equals("1", (CharSequence)bgmq.a("kandian_daily_fast_web_bottom_share", "0"));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbsh != null) {
      WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
    }
    this.jdField_a_of_type_Bbms = null;
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    String str = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    if ((str != null) && (str.length() >= 5))
    {
      localIntent.setClass(paramActivity.getApplicationContext(), DirectForwardActivity.class);
      localIntent.putExtra("toUin", str);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("key_flag_from_plugin", true);
      str = paramString1;
      if (paramString1 != null)
      {
        str = paramString1;
        if (paramString1.length() > 45) {
          str = paramString1.substring(0, 45) + "…";
        }
      }
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (paramString2.length() > 60) {
          paramString1 = paramString2.substring(0, 60) + "…";
        }
      }
      i = paramInt;
      if (paramInt <= 0) {
        i = 13;
      }
      localIntent.putExtra("pluginName", "web_share");
      localIntent.putExtra("title", str);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131630985, new Object[] { str }));
      localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
      if (paramJSONObject.has("contentAction")) {
        localIntent.putExtra("struct_share_key_content_action", paramJSONObject.getString("contentAction"));
      }
      if (paramJSONObject.has("actionData")) {
        localIntent.putExtra("struct_share_key_content_action_DATA", paramJSONObject.getString("actionData"));
      }
      if (paramJSONObject.has("sourceAction")) {
        localIntent.putExtra("struct_share_key_source_action", paramJSONObject.getString("sourceAction"));
      }
      if (paramJSONObject.has("isShareFlag")) {
        localIntent.putExtra("is_share_flag", Integer.parseInt(paramJSONObject.getString("isShareFlag")));
      }
      if (paramJSONObject.has("srcActionData")) {
        localIntent.putExtra("struct_share_key_source_action_data", paramJSONObject.getString("srcActionData"));
      }
      if (paramJSONObject.has("appName")) {
        localIntent.putExtra("app_name", paramJSONObject.getString("appName"));
      }
      if (!"audio".equals(paramString5)) {
        break label755;
      }
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    boolean bool;
    long l;
    for (;;)
    {
      i = paramInt;
      if (paramInt == 1) {
        i = 144;
      }
      localIntent.putExtra("req_type", i);
      if (paramJSONObject.has("report")) {
        localIntent.putExtra("report", paramJSONObject.getString("report"));
      }
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      bool = paramJSONObject.optBoolean("back", false);
      if (paramJSONObject.has("k_back")) {
        bool = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", bool);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break label798;
      }
      paramJSONObject = (AppInterface)obz.a();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.jdField_a_of_type_Bbms.isShowing())
        {
          this.jdField_a_of_type_Bbms.c(2131628457);
          this.jdField_a_of_type_Bbms.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        xdt.a(paramJSONObject, paramActivity, paramJSONObject.getAccount(), l, 3000L, new ral(this, localIntent, paramActivity));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
      break;
      label755:
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    label798:
    a(paramActivity);
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_Bbms.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    label1060:
    label1070:
    label1714:
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = (AppInterface)obz.a();
        paramString2 = paramString2.getEntityManagerFactory(paramString2.getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1742;
          }
        }
      }
      label1080:
      label1735:
      label1742:
      for (paramString2 = paramString5.name;; paramString2 = null)
      {
        paramString3 = paramString2;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = paramString2;
          if (paramJSONObject.has("sourceName")) {
            paramString3 = paramJSONObject.optString("sourceName");
          }
        }
        paramString2 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString2 = paramString1;
        }
        for (;;)
        {
          label1022:
          if (paramString2.equalsIgnoreCase(paramActivity.getString(2131633855)))
          {
            bool = paramString2.equalsIgnoreCase(paramActivity.getString(2131633855));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1253;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1261;
              }
              paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
              localIntent.putExtra("struct_share_key_source_icon", paramString4);
              localIntent.putExtra("app_name", paramString2);
            }
          }
          for (;;)
          {
            paramJSONObject = awuw.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1714;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
            return;
            if (paramJSONObject.has("sourceName")) {
              paramString2 = paramJSONObject.optString("sourceName");
            }
            paramString3 = paramString2;
            if (TextUtils.isEmpty(paramString2))
            {
              paramString3 = paramString2;
              if (paramString5 != null) {
                paramString3 = paramString5.name;
              }
            }
            if (!TextUtils.isEmpty(paramString3)) {
              break label1735;
            }
            paramString2 = paramString1;
            break label1022;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label1060;
            label1253:
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label1070;
            label1261:
            paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1080;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            paramString6 = paramJSONObject.optString("src_a_actionData", "");
            str = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(paramString6)) || (TextUtils.isEmpty(str)))))
            {
              paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
              paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
            }
            for (;;)
            {
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("app_name", paramString2);
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1615;
              }
              localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
              break;
              localIntent.putExtra("struct_share_key_source_action", paramString4);
              if ("web".equals(paramString4))
              {
                localIntent.putExtra("struct_share_key_source_url", paramString3);
                localIntent.putExtra("source_url", paramString3);
              }
              else
              {
                if (!TextUtils.isEmpty(paramString5)) {
                  localIntent.putExtra("struct_share_key_source_action_data", paramString5);
                }
                if (!TextUtils.isEmpty(paramString6)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", paramString6);
                }
                if (!TextUtils.isEmpty(str)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str);
                }
              }
            }
            label1615:
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
            continue;
            if (paramJSONObject.has("sourceName"))
            {
              paramString1 = paramJSONObject.optString("sourceName");
              localIntent.putExtra("app_name", paramString1);
              if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
                localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              }
            }
            else
            {
              localIntent.putExtra("app_name", paramActivity.getString(2131631001));
            }
          }
          localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
          paramActivity.startActivityForResult(localIntent, 1);
          return;
          paramString2 = paramString3;
        }
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, int paramInt, Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    AppInterface localAppInterface = (AppInterface)obz.a();
    String str5;
    String str3;
    String str4;
    String str2;
    String str1;
    boolean bool;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString3);
        str5 = localJSONObject.optString("share_type", "0");
        str3 = localJSONObject.optString("title");
        str4 = localJSONObject.optString("desc");
        str2 = localJSONObject.optString("share_url");
        str1 = localJSONObject.optString("image_url");
        String str6 = localJSONObject.optString("shareElement");
        String str7 = localJSONObject.optString("flash_url");
        if ((!(paramActivity instanceof FastWebActivity)) || (!"2".equals(str5))) {
          break label1056;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.e("BASKDLKFJHLKJ, ", 2, "activity instanceof FastWebActivity = " + (paramActivity instanceof FastWebActivity) + ", share_type = " + str5 + ", isShareToMiniProgram = " + bool + ", action = " + paramInt + ", shareJson = " + paramString3);
        }
        if (paramArticleInfo == null) {
          break label1062;
        }
        paramString1 = paramArticleInfo.innerUniqueID;
        label199:
        i = localJSONObject.optInt("shareQQType", 13);
        if (paramInt == 2)
        {
          a(paramActivity, localJSONObject, str3, str4, str2, str1, str6, str7, i);
          a(localAppInterface.getApplication().getApplicationContext(), paramString2, 2, paramArticleInfo);
          raz.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 1, -1, false);
          return;
        }
        if (paramInt != 3) {
          break label1070;
        }
        paramString1 = new Bundle();
        paramString1.putString("title", str3);
        paramString1.putString("desc", str4);
        paramString1.putString("detail_url", str2);
        paramString1.putString("from", "qq");
        if (localJSONObject != null) {
          paramString1.putString("default_text", localJSONObject.optString("default_text"));
        }
        paramString3 = new ArrayList(1);
        if ((TextUtils.isEmpty(str1)) && (paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.mFirstPagePicUrl)))
        {
          paramString3.add(paramArticleInfo.mFirstPagePicUrl);
          paramString1.putStringArrayList("image_url", paramString3);
          paramString1.putLong("req_share_id", 0L);
          paramString1.putInt("iUrlInfoFrm", 1);
          paramString1.putLong("share_begin_time", bbbt.b);
          if (bfqn.a((QQAppInterface)localAppInterface, paramActivity.getApplicationContext(), paramString1, null, 1)) {
            break;
          }
          vvp.a(1, 2131623975);
          raz.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false, false);
          return;
        }
      }
      catch (Exception paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        return;
      }
      paramString3.add(str1);
    }
    a(localAppInterface.getApplication().getApplicationContext(), paramString2, 3, paramArticleInfo);
    raz.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 2, -1, false);
    return;
    label517:
    paramString3 = new HashMap(1);
    int j = -1;
    if (paramInt == 4) {}
    for (int i = 3;; i = 4)
    {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131655008;
      }
      while (paramInt != -1)
      {
        vvp.a(0, paramInt);
        return;
        paramInt = j;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131655009;
        }
      }
      a(paramArticleInfo, i);
      paramArticleInfo = new FastWebShareUtils.3(this, paramString3, bool, str3, str4, str2, paramString1, str5, localAppInterface, paramString2, paramArticleInfo, i);
      if (TextUtils.isEmpty(str1))
      {
        paramArticleInfo.run();
        return;
      }
      a(paramActivity);
      this.jdField_a_of_type_Bbms.c(2131628457);
      this.jdField_a_of_type_Bbms.show();
      ThreadManager.post(new FastWebShareUtils.4(this, str1, bool, paramString3, localAppInterface, paramArticleInfo), 8, null, false);
      return;
      label1056:
      label1062:
      label1070:
      do
      {
        if (paramInt == 6)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
          }
          if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str2)))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
            }
            bbmy.a(BaseApplication.getContext(), 0, 2131653595, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
          }
          try
          {
            paramString1 = URLEncoder.encode(str3, "UTF-8");
            paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
            paramString3 = URLEncoder.encode(str2, "UTF-8");
            paramString1 = paramString1 + "&url=" + paramString3;
            paramString3 = URLEncoder.encode(str1, "UTF-8");
            paramString1 = paramString1 + "&pic=" + paramString3;
            paramString1 = paramString1 + "&_wv=3";
            paramString3 = new Intent(paramActivity, QQBrowserActivity.class);
            paramString3.putExtra("url", paramString1);
            paramActivity.startActivity(paramString3);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
            }
            a(localAppInterface.getApplication().getApplicationContext(), paramString2, 6, paramArticleInfo);
            raz.a(localAppInterface.getApplication().getApplicationContext(), localAppInterface, paramArticleInfo, 5, -1, false);
          }
          catch (Exception paramArticleInfo)
          {
            for (;;)
            {
              paramArticleInfo = paramArticleInfo;
              bbmy.a(BaseApplication.getContext(), 0, 2131653595, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
              paramArticleInfo.printStackTrace();
            }
          }
          finally {}
          if (QLog.isColorLevel())
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
            return;
          }
        }
        return;
        bool = false;
        break;
        paramString1 = "";
        break label199;
        if (paramInt == 4) {
          break label517;
        }
      } while (paramInt != 5);
      break label517;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     raj
 * JD-Core Version:    0.7.0.1
 */