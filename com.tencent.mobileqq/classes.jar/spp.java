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
import com.tencent.mobileqq.widget.QQToast;
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

public class spp
{
  public static String a;
  private bepp jdField_a_of_type_Bepp;
  private bevy jdField_a_of_type_Bevy;
  private Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QShareUtils";
  }
  
  public spp()
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
    this.jdField_a_of_type_JavaUtilMap.put("delete_column", Integer.valueOf(36));
    this.jdField_a_of_type_JavaUtilMap.put("add_to_column", Integer.valueOf(37));
    this.jdField_a_of_type_JavaUtilMap.put("remove_from_column", Integer.valueOf(38));
  }
  
  private void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(paramActivity);
    }
  }
  
  private void a(JSONObject paramJSONObject, int paramInt)
  {
    if (this.jdField_a_of_type_Bevy != null) {
      return;
    }
    this.jdField_a_of_type_Bevy = new spq(this);
    WXShareHelper.a().a(this.jdField_a_of_type_Bevy);
  }
  
  private void a(JSONObject paramJSONObject, int paramInt, AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap(1);
    int i = -1;
    int j;
    if (paramInt == 4)
    {
      j = 3;
      if (WXShareHelper.a().a()) {
        break label53;
      }
      i = 2131721478;
    }
    for (;;)
    {
      if (i == -1) {
        break label69;
      }
      xxb.a(0, i);
      return;
      j = 4;
      break;
      label53:
      if (!WXShareHelper.a().b()) {
        i = 2131721479;
      }
    }
    label69:
    boolean bool;
    String str2;
    if ((paramJSONObject.optInt("WXShareToMiniProgram") == 1) && (paramInt == 4))
    {
      bool = true;
      str2 = paramJSONObject.optString("WXSharePath");
      if (!TextUtils.isEmpty(paramJSONObject.optString("WXShareMiniProgramSourceID"))) {
        break label167;
      }
    }
    label167:
    for (String str1 = "gh_eaa1f0b1626b";; str1 = paramJSONObject.optString("WXShareMiniProgramSourceID"))
    {
      a(paramJSONObject, j);
      paramJSONObject = new QShareUtils.1(this, localHashMap, bool, paramString1, paramString2, paramString3, str2, str1, paramInt, paramString6, paramString5);
      if (!TextUtils.isEmpty(paramString4)) {
        break label178;
      }
      paramJSONObject.run();
      return;
      bool = false;
      break;
    }
    label178:
    ThreadManager.post(new QShareUtils.2(this, paramString4, localHashMap, paramAppInterface, paramJSONObject), 8, null, false);
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
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return -1;
    case 2: 
      return 0;
    case 3: 
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 3;
    case 6: 
      return 4;
    case 1: 
      return 7;
    }
    return 8;
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
  
  public List<sps> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new sps("kandian", 1, false));
    localArrayList.add(new sps("qq_friend", 2, false));
    localArrayList.add(new sps("qzone", 3, false));
    localArrayList.add(new sps("we_chat", 4, false));
    localArrayList.add(new sps("we_chat_circle", 5, false));
    localArrayList.add(new sps("we_bo", 6, false));
    localArrayList.add(new sps("qq_browser", 7, false));
    localArrayList.add(new sps("sys_browser", 8, false));
    return localArrayList;
  }
  
  public List<sps> a(JSONArray paramJSONArray, JSONObject paramJSONObject)
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
              localArrayList.add(new sps((String)localObject1, ((Integer)localObject2).intValue(), false));
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
                  localArrayList.add(new spt((String)localObject2, m, bool, paramJSONObject.optString("saveImageUrl")));
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
        localArrayList.add(new sps((String)localObject2, m, bool));
        break;
      }
      i += 1;
    }
  }
  
  public sps a(List<sps> paramList1, List<sps> paramList2, int paramInt)
  {
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      sps localsps = (sps)paramList1.next();
      if (localsps.a == paramInt) {
        return localsps;
      }
    }
    paramList1 = paramList2.iterator();
    while (paramList1.hasNext())
    {
      paramList2 = (sps)paramList1.next();
      if (paramList2.a == paramInt) {
        return paramList2;
      }
    }
    return null;
  }
  
  public void a()
  {
    WXShareHelper.a().b(this.jdField_a_of_type_Bevy);
  }
  
  void a(Activity paramActivity, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696873, new Object[] { str }));
    localIntent.putExtra("flag", paramJSONObject.optInt("flag", 0));
    localIntent.putExtra("is_need_show_toast", paramBoolean);
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
    long l;
    for (;;)
    {
      localIntent.putExtra("req_type", paramInt);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      paramBoolean = paramJSONObject.optBoolean("back", true);
      if (paramJSONObject.has("k_back")) {
        paramBoolean = paramJSONObject.getBoolean("k_back");
      }
      localIntent.putExtra("k_back", paramBoolean);
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
      }
      paramJSONObject = (AppInterface)ors.a();
      if (paramJSONObject != null)
      {
        a(paramActivity);
        if (!this.jdField_a_of_type_Bepp.isShowing())
        {
          this.jdField_a_of_type_Bepp.c(2131694217);
          this.jdField_a_of_type_Bepp.show();
        }
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        zbj.a(paramJSONObject, paramActivity, paramJSONObject.getAccount(), l, 3000L, new spr(this, localIntent, paramActivity));
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
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing()))
    {
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "dialog dimiss time :" + l);
      }
      this.jdField_a_of_type_Bepp.dismiss();
    }
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    label1048:
    label1058:
    label1068:
    label1638:
    label1771:
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = (AppInterface)ors.a();
        paramString2 = paramString2.getEntityManagerFactory(paramString2.getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1778;
          }
        }
      }
      label1009:
      label1778:
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
          if (paramString2.equalsIgnoreCase(paramActivity.getString(2131700022)))
          {
            paramBoolean = paramString2.equalsIgnoreCase(paramActivity.getString(2131700022));
            if (paramBoolean)
            {
              paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!paramBoolean) {
                break label1274;
              }
              paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!paramBoolean) {
                break label1282;
              }
              paramString5 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              localIntent.putExtra("source_puin", paramString1);
              localIntent.putExtra("struct_share_key_source_action", "plugin");
              localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
              localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
              localIntent.putExtra("struct_share_key_content_a_action_DATA", paramString3);
              localIntent.putExtra("struct_share_key_source_icon", paramString5);
              localIntent.putExtra("app_name", paramString2);
              label1145:
              paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
              if (!TextUtils.isEmpty(paramJSONObject)) {
                break label1737;
              }
              localIntent.putExtra("struct_share_key_source_icon", "http://url.cn/JS8oE7");
            }
          }
          for (;;)
          {
            paramJSONObject = azqu.a(localIntent.getExtras());
            if (paramJSONObject != null) {
              break label1750;
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
              break label1771;
            }
            paramString2 = paramString1;
            break label1009;
            paramString3 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label1048;
            label1274:
            paramString4 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label1058;
            paramString5 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label1068;
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
                break label1638;
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
            break label1145;
            if (paramJSONObject.has("source_name"))
            {
              paramString1 = paramJSONObject.optString("source_name");
              localIntent.putExtra("app_name", paramString1);
              if ((!"手Q阅读".equals(paramString1)) || (!paramJSONObject.has("srcIconUrl"))) {
                break label1145;
              }
              localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
              break label1145;
            }
            localIntent.putExtra("app_name", paramActivity.getString(2131696889));
            break label1145;
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
    AppInterface localAppInterface = (AppInterface)ors.a();
    for (;;)
    {
      String str2;
      String str3;
      String str1;
      Object localObject1;
      String str4;
      String str5;
      try
      {
        paramJSONObject.optString("source_name", "QQ浏览器");
        str2 = paramJSONObject.optString("title");
        str3 = paramJSONObject.optString("desc");
        str1 = paramJSONObject.optString("share_url");
        localObject1 = paramJSONObject.optString("image_url");
        Object localObject2 = paramJSONObject.optString("flash_url");
        str4 = paramJSONObject.optString("shareText");
        str5 = paramJSONObject.optString("shouldSharePlainTextChannel");
        if (paramJSONObject.optInt("hideSuccessToast") != 1) {
          break label658;
        }
        i = 1;
        int j = paramJSONObject.optInt("shareQQType", 13);
        if (paramInt == 2)
        {
          if (i != 0) {
            break label664;
          }
          bool = true;
          a(paramActivity, paramJSONObject, str2, str3, str1, (String)localObject1, "news", (String)localObject2, j, bool);
          return;
        }
        if (paramInt == 3)
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("title", str2);
          ((Bundle)localObject2).putString("desc", str3);
          ((Bundle)localObject2).putString("detail_url", str1);
          ((Bundle)localObject2).putString("from", "qq");
          ((Bundle)localObject2).putString("default_text", paramJSONObject.optString("default_text"));
          paramJSONObject = new ArrayList(1);
          paramJSONObject.add(localObject1);
          ((Bundle)localObject2).putStringArrayList("image_url", paramJSONObject);
          ((Bundle)localObject2).putLong("req_share_id", 0L);
          ((Bundle)localObject2).putInt("iUrlInfoFrm", 1);
          ((Bundle)localObject2).putLong("share_begin_time", beei.b);
          if (bjao.a((QQAppInterface)localAppInterface, paramActivity, (Bundle)localObject2, null, 125)) {
            break label657;
          }
          xxb.a(1, 2131689512);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      if ((paramInt == 4) || (paramInt == 5))
      {
        a(paramJSONObject, paramInt, localAppInterface, str2, str3, str1, (String)localObject1, str4, str5);
        return;
      }
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
          QQToast.a(BaseActivity.sTopActivity, 0, 2131720019, 0).b(BaseActivity.sTopActivity.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shareMsgToSina installSinaWeibo:false");
        }
        try
        {
          paramJSONObject = URLEncoder.encode(str2, "UTF-8");
          paramJSONObject = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramJSONObject;
          str1 = URLEncoder.encode(str1, "UTF-8");
          paramJSONObject = paramJSONObject + "&url=" + str1;
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
            QQToast.a(BaseApplication.getContext(), 0, 2131720019, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
            paramJSONObject.printStackTrace();
          }
        }
        finally {}
      }
      label657:
      return;
      label658:
      int i = 0;
      continue;
      label664:
      boolean bool = false;
    }
  }
  
  public List<sps> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new sps("screen_shot", 9, false));
    localArrayList.add(new sps("set_font", 10, false));
    localArrayList.add(new sps("add_favourite", 12, false));
    localArrayList.add(new sps("send_pc", 13, false));
    localArrayList.add(new sps("copy_link", 14, false));
    localArrayList.add(new sps("report", 20, false));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     spp
 * JD-Core Version:    0.7.0.1
 */