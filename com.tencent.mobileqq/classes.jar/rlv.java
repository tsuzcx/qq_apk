import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.1;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.2;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rlv
{
  public static String a;
  private bbms jdField_a_of_type_Bbms;
  private bbsh jdField_a_of_type_Bbsh;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QShareUtils";
  }
  
  public rlv()
  {
    this.jdField_a_of_type_JavaUtilMap.put("kandian", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilMap.put("qq_friend", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilMap.put("qzone", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilMap.put("we_chat", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilMap.put("we_chat_circle", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilMap.put("we_bo", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilMap.put("qq_browser", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilMap.put("sys_browser", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilMap.put("screen_shot", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilMap.put("set_font", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilMap.put("add_favourite", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilMap.put("send_pc", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilMap.put("copy_link", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilMap.put("report", Integer.valueOf(20));
    this.jdField_a_of_type_JavaUtilMap.put("dis_like", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilMap.put("not_care", Integer.valueOf(19));
    this.jdField_a_of_type_JavaUtilMap.put("add_friend", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilMap.put("open_aio", Integer.valueOf(16));
    this.jdField_a_of_type_JavaUtilMap.put("open_more_info", Integer.valueOf(21));
    this.jdField_a_of_type_JavaUtilMap.put("remove_fans", Integer.valueOf(18));
    this.jdField_a_of_type_JavaUtilMap.put("personal_c2c", Integer.valueOf(22));
    this.jdField_a_of_type_JavaUtilMap.put("unfollow", Integer.valueOf(23));
    this.jdField_a_of_type_JavaUtilMap.put("save_picture", Integer.valueOf(11));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(paramActivity);
    }
  }
  
  private void a(JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bbsh != null) {
      return;
    }
    this.jdField_a_of_type_Bbsh = new rlw(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bbsh);
  }
  
  public static List<Integer>[] a(boolean paramBoolean, Set<String> paramSet)
  {
    if (BaseApplicationImpl.getApplication().getRuntime() == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    if ((!paramSet.contains("menuItem:share:kandian")) && (!paramSet.contains("menuItem:share:diandian")) && (paramBoolean)) {
      localArrayList1.add(Integer.valueOf(1));
    }
    if (!paramSet.contains("menuItem:share:qq")) {
      localArrayList1.add(Integer.valueOf(2));
    }
    if (!paramSet.contains("menuItem:share:QZone")) {
      localArrayList1.add(Integer.valueOf(3));
    }
    if (!paramSet.contains("menuItem:share:appMessage")) {
      localArrayList1.add(Integer.valueOf(4));
    }
    if (!paramSet.contains("menuItem:share:timeline")) {
      localArrayList1.add(Integer.valueOf(5));
    }
    if (!paramSet.contains("menuItem:share:sinaWeibo")) {
      localArrayList1.add(Integer.valueOf(6));
    }
    if (!paramSet.contains("menuItem:openWithQQBrowser")) {
      localArrayList1.add(Integer.valueOf(7));
    }
    if (!paramSet.contains("menuItem:openWithSafari")) {
      localArrayList1.add(Integer.valueOf(8));
    }
    ArrayList localArrayList2 = new ArrayList();
    if (!paramSet.contains("menuItem:screenShotShare")) {
      localArrayList2.add(Integer.valueOf(9));
    }
    if (!paramSet.contains("menuItem:copyUrl")) {
      localArrayList2.add(Integer.valueOf(14));
    }
    if (!paramSet.contains("menuItem:exposeArticle")) {
      localArrayList2.add(Integer.valueOf(20));
    }
    Collections.sort(localArrayList2);
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = "other";
    Object localObject2 = localObject1;
    if (this.jdField_a_of_type_JavaUtilMap.containsValue(Integer.valueOf(paramInt)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        if (paramInt != ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).intValue()) {
          break label87;
        }
        localObject1 = localObject2;
      }
    }
    label87:
    for (;;)
    {
      break;
      return localObject2;
    }
  }
  
  public List<rly> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new rly("kandian", 1, false));
    localArrayList.add(new rly("qq_friend", 2, false));
    localArrayList.add(new rly("qzone", 3, false));
    localArrayList.add(new rly("we_chat", 4, false));
    localArrayList.add(new rly("we_chat_circle", 5, false));
    localArrayList.add(new rly("we_bo", 6, false));
    localArrayList.add(new rly("qq_browser", 7, false));
    localArrayList.add(new rly("sys_browser", 8, false));
    return localArrayList;
  }
  
  public List<rly> a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (localArrayList != null) {}
    for (;;)
    {
      int i;
      Object localObject2;
      int k;
      try
      {
        int j = paramJSONArray.length();
        i = 0;
        if (i < j)
        {
          Object localObject1 = paramJSONArray.get(i);
          if ((localObject1 instanceof String))
          {
            localObject2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject1);
            if (localObject2 != null) {
              localArrayList.add(new rly((String)localObject1, ((Integer)localObject2).intValue(), false));
            }
          }
          else if ((localObject1 instanceof JSONObject))
          {
            localObject1 = (JSONObject)localObject1;
            localObject2 = ((JSONObject)localObject1).optString("name");
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (this.jdField_a_of_type_JavaUtilMap.get(localObject2) != null))
            {
              k = ((JSONObject)localObject1).optInt("webHandle", 0);
              if ("save_picture".equals(localObject2))
              {
                m = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).intValue();
                if (k == 1)
                {
                  bool = true;
                  localArrayList.add(new rlz((String)localObject2, m, bool, paramJSONObject.optString("saveImageUrl")));
                }
              }
            }
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
      return localArrayList;
      boolean bool = false;
      continue;
      int m = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(localObject2)).intValue();
      if (k == 1) {}
      for (bool = true;; bool = false)
      {
        localArrayList.add(new rly((String)localObject2, m, bool));
        break;
      }
      i += 1;
    }
  }
  
  public rly a(List<rly> paramList1, List<rly> paramList2, int paramInt)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      rly localrly = (rly)paramList1.next();
      if (localrly.a == paramInt) {
        return localrly;
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (rly)paramList1.next();
      if (paramList2.a == paramInt) {
        return paramList2;
      }
    }
    return null;
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bbsh);
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isWebCompShare", true);
    localIntent.setClass(paramActivity.getApplicationContext(), ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    String str = paramString1;
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
    int i = paramInt;
    if (paramInt <= 0) {
      i = 13;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", str);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("shareQQType", i);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("app_id", -1L));
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
    if (paramJSONObject.has("source_name")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("source_name"));
    }
    if (paramJSONObject.has("sourceName")) {
      localIntent.putExtra("app_name", paramJSONObject.getString("sourceName"));
    }
    if ("audio".equals(paramString5))
    {
      paramInt = 2;
      localIntent.putExtra("audio_url", paramString6);
    }
    boolean bool;
    long l;
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      bool = paramJSONObject.optBoolean("back", true);
      if (paramJSONObject.has("k_back")) {
        bool = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", bool);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
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
        xdt.a(paramJSONObject, paramActivity, paramJSONObject.getAccount(), l, 3000L, new rlx(this, localIntent, paramActivity));
      }
      return;
      i = paramJSONObject.optInt("req_type", 1);
      paramInt = i;
      if (i == 2)
      {
        localIntent.putExtra("audio_url", paramJSONObject.getString("audio_url"));
        paramInt = i;
      }
    }
    a(paramActivity);
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_Bbms.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    label1037:
    label1047:
    label1057:
    label1627:
    label1760:
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
            break label1767;
          }
        }
      }
      label998:
      label1767:
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
          if (paramString2.equalsIgnoreCase(paramActivity.getString(2131633855)))
          {
            bool = paramString2.equalsIgnoreCase(paramActivity.getString(2131633855));
            if (bool)
            {
              paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1263;
              }
              paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1271;
              }
              paramString5 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString3);
              localIntent.putExtra("struct_share_key_source_icon", paramString5);
              localIntent.putExtra("app_name", paramString2);
              label1134:
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1726;
              }
              localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
            }
          }
          for (;;)
          {
            paramJSONObject = awuw.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1739;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "build struct msg fail");
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
              break label1760;
            }
            paramString2 = paramString1;
            break label998;
            paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label1037;
            label1263:
            paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label1047;
            label1271:
            paramString5 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1057;
            paramString3 = paramJSONObject.optString("src_iconUrl", "");
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
              paramString1 = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramString1)) {
                break label1627;
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
            localIntent.putExtra("struct_share_key_source_icon", paramString1);
            break label1134;
            if (paramJSONObject.has("source_name"))
            {
              paramString1 = paramJSONObject.optString("source_name");
              localIntent.putExtra("app_name", paramString1);
              if ((!"手Q阅读".equals(paramString1)) || (!paramJSONObject.has("srcIconUrl"))) {
                break label1134;
              }
              localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              break label1134;
            }
            localIntent.putExtra("app_name", paramActivity.getString(2131631001));
            break label1134;
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
          }
          localIntent.putExtra("stuctmsg_bytes", paramJSONObject.getBytes());
          paramActivity.startActivityForResult(localIntent, 1);
          return;
          paramString2 = paramString3;
        }
      }
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Activity paramActivity)
  {
    Object localObject2 = (AppInterface)obz.a();
    String str2;
    String str3;
    String str1;
    Object localObject1;
    Object localObject3;
    int i;
    try
    {
      paramJSONObject.optString("source_name", "QQ浏览器");
      str2 = paramJSONObject.optString("title");
      str3 = paramJSONObject.optString("desc");
      str1 = paramJSONObject.optString("share_url");
      localObject1 = paramJSONObject.optString("image_url");
      localObject3 = paramJSONObject.optString("flash_url");
      i = paramJSONObject.optInt("shareQQType", 13);
      if (paramInt == 2)
      {
        a(paramActivity, paramJSONObject, str2, str3, str1, (String)localObject1, "news", (String)localObject3, i);
        return;
      }
      if (paramInt == 3)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("title", str2);
        ((Bundle)localObject3).putString("desc", str3);
        ((Bundle)localObject3).putString("detail_url", str1);
        ((Bundle)localObject3).putString("from", "qq");
        ((Bundle)localObject3).putString("default_text", paramJSONObject.optString("default_text"));
        paramJSONObject = new ArrayList(1);
        paramJSONObject.add(localObject1);
        ((Bundle)localObject3).putStringArrayList("image_url", paramJSONObject);
        ((Bundle)localObject3).putLong("req_share_id", 0L);
        ((Bundle)localObject3).putInt("iUrlInfoFrm", 1);
        ((Bundle)localObject3).putLong("share_begin_time", bbbt.b);
        if (bfqn.a((QQAppInterface)localObject2, paramActivity.getApplicationContext(), (Bundle)localObject3, null, 1)) {
          break label787;
        }
        vvp.a(1, 2131623975);
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      return;
    }
    int j;
    if ((paramInt == 4) || (paramInt == 5))
    {
      localObject3 = new HashMap(1);
      i = -1;
      if (paramInt != 4) {
        break label788;
      }
      j = 3;
      if (!WXShareHelper.a().a()) {
        i = 2131655008;
      }
      while (i != -1)
      {
        vvp.a(0, i);
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131655009;
        }
      }
      if ((paramJSONObject.optInt("WXShareToMiniProgram") != 1) || (paramInt != 4)) {
        break label794;
      }
    }
    label787:
    label788:
    label794:
    for (boolean bool = true;; bool = false)
    {
      String str4 = paramJSONObject.optString("WXSharePath");
      if (TextUtils.isEmpty(paramJSONObject.optString("WXShareMiniProgramSourceID"))) {}
      for (paramActivity = "gh_eaa1f0b1626b";; paramActivity = paramJSONObject.optString("WXShareMiniProgramSourceID"))
      {
        a(paramJSONObject, j);
        paramJSONObject = new QShareUtils.1(this, (Map)localObject3, bool, str2, str3, str1, str4, paramActivity, paramInt);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        paramJSONObject.run();
        return;
      }
      ThreadManager.post(new QShareUtils.2(this, (String)localObject1, bool, (Map)localObject3, (AppInterface)localObject2, paramJSONObject), 8, null, false);
      return;
      if (paramInt == 6)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start!");
        }
        if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina empty title or share_url");
          }
          bbmy.a(BaseActivity.sTopActivity, 0, 2131653595, 0).b(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131167766));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
        }
        try
        {
          paramJSONObject = URLEncoder.encode(str2, "UTF-8");
          paramJSONObject = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramJSONObject;
          localObject2 = URLEncoder.encode(str1, "UTF-8");
          paramJSONObject = paramJSONObject + "&url=" + (String)localObject2;
          localObject1 = URLEncoder.encode((String)localObject1, "UTF-8");
          paramJSONObject = paramJSONObject + "&pic=" + (String)localObject1;
          paramJSONObject = paramJSONObject + "&_wv=3";
          localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("url", paramJSONObject);
          paramActivity.startActivity((Intent)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina start webview!");
          }
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina end!");
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            paramJSONObject = paramJSONObject;
            bbmy.a(BaseApplication.getContext(), 0, 2131653595, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131167766));
            paramJSONObject.printStackTrace();
          }
        }
        finally {}
      }
      return;
      j = 4;
      break;
    }
  }
  
  public List<rly> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new rly("screen_shot", 9, false));
    localArrayList.add(new rly("set_font", 10, false));
    localArrayList.add(new rly("add_favourite", 12, false));
    localArrayList.add(new rly("send_pc", 13, false));
    localArrayList.add(new rly("copy_link", 14, false));
    localArrayList.add(new rly("report", 20, false));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlv
 * JD-Core Version:    0.7.0.1
 */