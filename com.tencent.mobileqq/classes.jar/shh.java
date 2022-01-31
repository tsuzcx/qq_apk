import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.5;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.6;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class shh
  implements sgz
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bcdp jdField_a_of_type_Bcdp;
  bchx jdField_a_of_type_Bchx = null;
  bcij jdField_a_of_type_Bcij = null;
  bcqf jdField_a_of_type_Bcqf;
  public CustomWebView a;
  public String a;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<shm> jdField_a_of_type_JavaUtilList;
  public ooc a;
  private pcf jdField_a_of_type_Pcf;
  private sgv jdField_a_of_type_Sgv;
  private shp jdField_a_of_type_Shp;
  public wxr a;
  private String jdField_b_of_type_JavaLangString;
  private List<shm> jdField_b_of_type_JavaUtilList;
  private String c;
  
  public shh(pcf parampcf, wxr paramwxr)
  {
    this.jdField_a_of_type_Pcf = parampcf;
    this.jdField_a_of_type_Bcdp = parampcf.mRuntime;
    this.jdField_a_of_type_Wxr = paramwxr;
    this.jdField_a_of_type_AndroidAppActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.jdField_a_of_type_Bcdp.a();
    parampcf = this.jdField_a_of_type_Bcdp.a(this.jdField_a_of_type_Bcdp.a());
    if ((parampcf != null) && ((parampcf instanceof bcij))) {
      this.jdField_a_of_type_Bcij = ((bcij)parampcf);
    }
    parampcf = this.jdField_a_of_type_Bcdp.a(this.jdField_a_of_type_Bcdp.a());
    if ((parampcf != null) && ((parampcf instanceof bchx))) {
      this.jdField_a_of_type_Bchx = ((bchx)parampcf);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("kandian", Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilHashMap.put("qq_friend", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("qzone", Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilHashMap.put("we_chat", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("we_chat_circle", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("we_bo", Integer.valueOf(6));
    this.jdField_a_of_type_JavaUtilHashMap.put("qq_browser", Integer.valueOf(7));
    this.jdField_a_of_type_JavaUtilHashMap.put("sys_browser", Integer.valueOf(8));
    this.jdField_a_of_type_JavaUtilHashMap.put("screen_shot", Integer.valueOf(9));
    this.jdField_a_of_type_JavaUtilHashMap.put("set_font", Integer.valueOf(10));
    this.jdField_a_of_type_JavaUtilHashMap.put("add_favourite", Integer.valueOf(12));
    this.jdField_a_of_type_JavaUtilHashMap.put("export_tencent_docs", Integer.valueOf(28));
    this.jdField_a_of_type_JavaUtilHashMap.put("send_pc", Integer.valueOf(13));
    this.jdField_a_of_type_JavaUtilHashMap.put("copy_link", Integer.valueOf(14));
    this.jdField_a_of_type_JavaUtilHashMap.put("report", Integer.valueOf(20));
    this.jdField_a_of_type_JavaUtilHashMap.put("dis_like", Integer.valueOf(15));
    this.jdField_a_of_type_JavaUtilHashMap.put("not_care", Integer.valueOf(19));
    this.jdField_a_of_type_JavaUtilHashMap.put("add_friend", Integer.valueOf(17));
    this.jdField_a_of_type_JavaUtilHashMap.put("open_aio", Integer.valueOf(16));
    this.jdField_a_of_type_JavaUtilHashMap.put("open_more_info", Integer.valueOf(21));
    this.jdField_a_of_type_JavaUtilHashMap.put("remove_fans", Integer.valueOf(18));
    this.jdField_a_of_type_JavaUtilHashMap.put("personal_c2c", Integer.valueOf(22));
    this.jdField_a_of_type_JavaUtilHashMap.put("unfollow", Integer.valueOf(23));
  }
  
  private List<shm> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new shm("kandian", 1, false));
    localArrayList.add(new shm("qq_friend", 2, false));
    localArrayList.add(new shm("qzone", 3, false));
    localArrayList.add(new shm("we_chat", 4, false));
    localArrayList.add(new shm("we_chat_circle", 5, false));
    localArrayList.add(new shm("we_bo", 6, false));
    localArrayList.add(new shm("qq_browser", 7, false));
    localArrayList.add(new shm("sys_browser", 8, false));
    return localArrayList;
  }
  
  private List<shm> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (localArrayList != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramJSONArray.length();
        i = 0;
        if (i < j)
        {
          Object localObject1 = paramJSONArray.get(i);
          Object localObject2;
          if ((localObject1 instanceof String))
          {
            localObject2 = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
            if (localObject2 != null) {
              localArrayList.add(new shm((String)localObject1, ((Integer)localObject2).intValue(), false));
            }
          }
          else if ((localObject1 instanceof JSONObject))
          {
            localObject1 = (JSONObject)localObject1;
            localObject2 = ((JSONObject)localObject1).optString("name");
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (this.jdField_a_of_type_JavaUtilHashMap.get(localObject2) != null))
            {
              int k = ((JSONObject)localObject1).optInt("webHandle", 0);
              int m = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2)).intValue();
              if (k == 1)
              {
                bool = true;
                localArrayList.add(new shm((String)localObject2, m, bool));
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
      i += 1;
    }
  }
  
  private shm a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    shm localshm;
    while (localIterator.hasNext())
    {
      localshm = (shm)localIterator.next();
      if (localshm.a == paramInt) {
        return localshm;
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      localshm = (shm)localIterator.next();
      if (localshm.a == paramInt) {
        return localshm;
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c);
      String str5 = localJSONObject.optString("share_type", "0");
      Object localObject = localJSONObject.optString("title");
      String str2 = localJSONObject.optString("desc");
      String str3 = localJSONObject.optString("share_url");
      String str4 = localJSONObject.optString("image_url");
      String str6 = localJSONObject.optString("shareElement");
      String str1 = localJSONObject.optString("weibo_title");
      boolean bool = localJSONObject.optBoolean("keepShareUrl", false);
      if (paramInt == 2)
      {
        a(localJSONObject, str5, (String)localObject, str2, str3, str4, str6, 13, bool);
        return;
      }
      if (paramInt == 3)
      {
        a(localJSONObject, str5, (String)localObject, str2, str3, str4);
        return;
      }
      if (paramInt == 4)
      {
        a(localJSONObject, true, (String)localObject, str2, str3, str4, str6);
        return;
      }
      if (paramInt == 5)
      {
        a(localJSONObject, false, (String)localObject, str2, str3, str4, str6);
        return;
      }
      if (paramInt == 6)
      {
        if (!TextUtils.isEmpty(str1)) {
          localObject = str1;
        }
        a((String)localObject, str2, str3, str4);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_JavaLangString != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("action", paramString);
        if (paramBoolean) {}
        for (paramString = "0";; paramString = "1")
        {
          localJSONObject.put("retCode", paramString);
          this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
          return;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramBoolean) && (paramString4 != null) && (paramString4.length() > 140) && (!"3".equals(paramString1))) {
      localHashMap.put("share_url", paramString4);
    }
    if ((paramString5 != null) && (paramString5.length() > 80) && (!"2".equals(paramString1)) && (!"3".equals(paramString1)) && (!"4".equals(paramString1))) {
      localHashMap.put("image_url", paramString5);
    }
    b();
    ThreadManager.post(new ReadInjoyWebShareHelper.3(this, localHashMap, paramString4, paramString5, paramJSONObject, paramString2, paramString3, paramString6), 8, null, true);
  }
  
  private List<Integer>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((shm)((Iterator)localObject).next()).a));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add(Integer.valueOf(((shm)((Iterator)localObject).next()).a));
    }
    if (localArrayList2.contains(Integer.valueOf(28)))
    {
      if (this.jdField_a_of_type_Shp != null) {
        break label152;
      }
      localObject = null;
      if (!ayee.a((String)localObject)) {
        break label163;
      }
      ayee.a(0, 3);
    }
    for (;;)
    {
      return new List[] { localArrayList1, localArrayList2 };
      label152:
      localObject = this.jdField_a_of_type_Shp.c;
      break;
      label163:
      localArrayList2.remove(Integer.valueOf(28));
    }
  }
  
  private List<shm> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new shm("screen_shot", 9, false));
    localArrayList.add(new shm("set_font", 10, false));
    localArrayList.add(new shm("add_favourite", 12, false));
    localArrayList.add(new shm("export_tencent_docs", 28, false));
    localArrayList.add(new shm("send_pc", 13, false));
    localArrayList.add(new shm("copy_link", 14, false));
    localArrayList.add(new shm("report", 20, false));
    return localArrayList;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131298865));
    }
    if (!this.jdField_a_of_type_Bcqf.isShowing())
    {
      this.jdField_a_of_type_Bcqf.c(2131694100);
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  private void d()
  {
    String str1 = this.jdField_a_of_type_Shp.a;
    String str2 = this.jdField_a_of_type_Shp.jdField_b_of_type_JavaLangString;
    String str3 = this.jdField_a_of_type_Shp.d;
    String str4 = this.jdField_a_of_type_Bcdp.a().f;
    String str5 = this.jdField_a_of_type_Shp.f;
    bgpu.a(0, str1, this.jdField_a_of_type_Shp.c, str5, str2, str3, null, null, false, -1L).a("lCategory", 8L).c(str4).a(this.jdField_a_of_type_Bcdp.a(), str4);
  }
  
  private void e()
  {
    Object localObject1 = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.jdField_a_of_type_Shp.c);
    int i = 0;
    if (((Matcher)localObject1).matches()) {
      i = 1;
    }
    Object localObject3 = null;
    try
    {
      localObject1 = URLEncoder.encode(this.jdField_a_of_type_Shp.c, "UTF-8");
      str2 = this.jdField_a_of_type_Bcdp.a().f;
      if (i != 0)
      {
        String str3 = String.valueOf(NetConnInfoCenter.getServerTime());
        String str1 = bdik.b((String)localObject1 + 200 + str3 + "jubao@article@123");
        localObject3 = str1;
        if (str1 != null)
        {
          localObject3 = str1;
          if (!str1.isEmpty()) {
            localObject3 = str1.toLowerCase();
          }
        }
        str1 = this.jdField_a_of_type_Bcdp.a().j;
        localObject1 = "https://post.mp.qq.com/jubao/index?qq=" + str2 + "&mp_uin=" + str1 + "&scene=200&sub_appname=article_webview&timestamp=" + str3 + "&sign=" + (String)localObject3 + "&article_url=" + (String)localObject1 + "&_wv=3";
        localObject3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject1);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2;
        Object localObject2 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("WebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
          localObject2 = localObject3;
          continue;
          localObject2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + (String)localObject2 + "&qq=" + str2 + "&_wv=7";
        }
      }
    }
  }
  
  Activity a()
  {
    for (Activity localActivity = this.jdField_a_of_type_Bcdp.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_Ooc != null) {
      WxShareHelperFromReadInjoy.a().b(this.jdField_a_of_type_Ooc);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Bcdp.a().getSettings().setTextZoom(bcfh.a[paramInt]);
    this.jdField_a_of_type_Wxr.a(paramInt);
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt == -1)
    {
      bool = true;
      if (paramByte != 1) {
        break label28;
      }
      a("qq_friend", bool);
    }
    label28:
    while (paramByte != 2)
    {
      return;
      bool = false;
      break;
    }
    a("qzone", bool);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Sgv == null) {
      this.jdField_a_of_type_Sgv = new sgv(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bcdp.a(), null, new shn(this));
    }
    this.jdField_a_of_type_Sgv.a.a("biu出去让更多好友看到");
    this.jdField_a_of_type_Sgv.a.a(new shi(this));
    for (;;)
    {
      try
      {
        this.c = paramString;
        paramString = new JSONObject(this.c);
        JSONArray localJSONArray1 = paramString.optJSONArray("upline");
        JSONArray localJSONArray2 = paramString.optJSONArray("belowline");
        if (localJSONArray1 == null)
        {
          this.jdField_a_of_type_JavaUtilList = a();
          if (localJSONArray2 == null)
          {
            this.jdField_b_of_type_JavaUtilList = b();
            this.jdField_a_of_type_Shp = new shp(null);
            this.jdField_a_of_type_Shp.c = paramString.optString("share_url");
            this.jdField_a_of_type_Shp.jdField_b_of_type_JavaLangString = paramString.optString("desc");
            this.jdField_a_of_type_Shp.a = paramString.optString("title");
            this.jdField_a_of_type_Shp.d = paramString.optString("image_url");
            this.jdField_a_of_type_Shp.e = paramString.optString("puin");
            this.jdField_a_of_type_Shp.f = paramString.optString("nick_name");
            if (TextUtils.isEmpty(this.jdField_a_of_type_Shp.f)) {
              this.jdField_a_of_type_Shp.f = paramString.optString("sourceName");
            }
            this.jdField_b_of_type_JavaLangString = paramString.optString("callback");
            this.jdField_a_of_type_Sgv.a(a());
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilList = a(localJSONArray1);
          continue;
        }
        this.jdField_b_of_type_JavaUtilList = a(localJSONArray2);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString2);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "shareMsgToSina start!");
    }
    try
    {
      localObject = Uri.parse(paramString3);
      if (localObject != null)
      {
        localObject = ((Uri)localObject).getHost();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("article.mp.qq.com".equalsIgnoreCase((String)localObject)) || ("post.mp.qq.com".equalsIgnoreCase((String)localObject))))
        {
          b(paramString1, paramString2, paramString3, paramString4);
          return;
        }
      }
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString2 = this.jdField_a_of_type_Bcdp.a();
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
          }
          c();
          bcql.a(BaseApplication.getContext(), 0, 2131719487, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          return;
        }
        Object localObject = BaseApplicationImpl.getContext().getPackageManager();
        try
        {
          localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
          if (QLog.isColorLevel()) {
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
          }
          ThreadManager.executeOnSubThread(new ReadInjoyWebShareHelper.6(this, paramString4, paramString1, paramString3, (ApplicationInfo)localObject, paramString2));
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label235;
            }
            QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
            try
            {
              paramString1 = URLEncoder.encode(paramString1, "UTF-8");
              paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
              paramString3 = URLEncoder.encode(paramString3, "UTF-8");
              paramString1 = paramString1 + "&url=" + paramString3;
              paramString3 = URLEncoder.encode(paramString4, "UTF-8");
              paramString1 = paramString1 + "&pic=" + paramString3;
              paramString1 = paramString1 + "&_wv=3";
              paramString3 = new Intent(paramString2, QQBrowserActivity.class);
              paramString3.putExtra("url", paramString1);
              paramString2.startActivity(paramString3);
              if (!QLog.isColorLevel()) {
                break label400;
              }
              QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
              c();
            }
            catch (Exception paramString1)
            {
              bcql.a(BaseApplication.getContext(), 0, 2131719487, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
              paramString1.printStackTrace();
              c();
            }
            finally
            {
              c();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
      return;
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 2;
    c();
    paramString1 = new Bundle();
    paramString1.putString("title", paramString2);
    paramString1.putString("desc", paramString3);
    paramString1.putString("detail_url", paramString4);
    paramString1.putString("from", "qq");
    if (paramJSONObject != null) {
      paramString1.putString("default_text", paramJSONObject.optString("default_text"));
    }
    paramJSONObject = new ArrayList(1);
    paramJSONObject.add(paramString5);
    paramString1.putStringArrayList("image_url", paramJSONObject);
    paramString1.putLong("req_share_id", 0L);
    paramString1.putInt("iUrlInfoFrm", 1);
    paramString1.putLong("share_begin_time", bcfh.b);
    if (this.jdField_a_of_type_Bcij != null)
    {
      paramString1.putString("struct_url", this.jdField_a_of_type_Bcij.b());
      paramString1.putBoolean("from_web", true);
    }
    if (this.jdField_a_of_type_Bchx != null) {
      i = this.jdField_a_of_type_Bchx.a(this.jdField_a_of_type_Pcf, (byte)2, true);
    }
    bgzl.a(this.jdField_a_of_type_Bcdp.a(), this.jdField_a_of_type_AndroidAppActivity, paramString1, null, i);
  }
  
  public void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_a_of_type_Bcdp.a();
    Intent localIntent = new Intent();
    paramString5 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    if ((paramString5 != null) && (paramString5.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", paramString5);
      localIntent.putExtra("uinType", i);
    }
    for (;;)
    {
      localIntent.putExtra("key_flag_from_plugin", true);
      paramString5 = paramString1;
      if (paramString1 != null)
      {
        paramString5 = paramString1;
        if (paramString1.length() > 45) {
          paramString5 = paramString1.substring(0, 45) + "…";
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
      localIntent.putExtra("title", paramString5);
      localIntent.putExtra("desc", paramString1);
      localIntent.putExtra("detail_url", paramString3);
      localIntent.putExtra("shareQQType", i);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("image_url_remote", paramString4);
      localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696698, new Object[] { paramString5 }));
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
      localIntent.putExtra("req_type", 144);
      localIntent.putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
      localIntent.putExtra("k_back", paramJSONObject.optBoolean("back", false));
      if (paramJSONObject.has("serviceID")) {
        localIntent.putExtra("new_share_service_id", paramJSONObject.getString("serviceID"));
      }
      if (paramJSONObject.has("serviceID"))
      {
        paramInt = paramJSONObject.getInt("serviceID");
        if ((paramInt == 116) || (paramInt == 123)) {
          localIntent.putExtra("compatible_text", amnr.a);
        }
      }
      long l = paramJSONObject.optLong("appid", 0L);
      if (l <= 0L) {
        break;
      }
      paramJSONObject = this.jdField_a_of_type_Bcdp.a();
      if (paramJSONObject != null)
      {
        b();
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        xmq.a(paramJSONObject, this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.getAccount(), l, 3000L, new shj(this, localIntent));
      }
      return;
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    }
    c();
    paramString1 = paramJSONObject.optString("puin", null);
    if (paramString1 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.jdField_a_of_type_Bcdp.a().getEntityManagerFactory(this.jdField_a_of_type_Bcdp.a().getAccount()).createEntityManager();
        paramString5 = (AccountDetail)paramString2.a(AccountDetail.class, paramString1);
        paramString2.a();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4)) {
          if (paramString5 == null) {
            break label1577;
          }
        }
      }
      label918:
      label928:
      label1571:
      label1577:
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
          if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699654)))
          {
            boolean bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699654));
            if (bool)
            {
              paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
              if (!bool) {
                break label1106;
              }
              paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
              if (!bool) {
                break label1114;
              }
              paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
              label938:
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
            localIntent.putExtra("stuctmsg_bytes", axva.a(localIntent.getExtras()).getBytes());
            this.jdField_a_of_type_Pcf.startActivityForResult(localIntent, (byte)1);
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
              break label1571;
            }
            paramString2 = paramString1;
            break;
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
            break label918;
            label1106:
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
            break label928;
            label1114:
            paramString4 = "http://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
            break label938;
            paramString3 = paramJSONObject.optString("src_webActionUrl", "");
            paramString5 = paramJSONObject.optString("src_actionData", "");
            String str1 = paramJSONObject.optString("src_a_actionData", "");
            String str2 = paramJSONObject.optString("src_i_actionData", "");
            if ((TextUtils.isEmpty(paramString4)) || (("web".equals(paramString4)) && ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com")))) || ((!"web".equals(paramString4)) && (TextUtils.isEmpty(paramString5)) && ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))))
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
                break label1469;
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
                if (!TextUtils.isEmpty(str1)) {
                  localIntent.putExtra("struct_share_key_source_a_action_data", str1);
                }
                if (!TextUtils.isEmpty(str2)) {
                  localIntent.putExtra("struct_share_key_source_i_action_data", str2);
                }
              }
            }
            label1469:
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
              localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidAppActivity.getString(2131696714));
            }
          }
          paramString2 = paramString3;
        }
      }
    }
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_Bcdp.a();
    int i = -1;
    if (!WXShareHelper.a().a()) {
      i = 2131720917;
    }
    while (i != -1)
    {
      wij.a(0, i);
      c();
      return;
      if (!WXShareHelper.a().b()) {
        i = 2131720918;
      }
    }
    if (paramJSONObject.optInt("WXShareToMiniProgram") == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramString5 = paramJSONObject.optString("WXSharePath");
      paramJSONObject = new HashMap(1);
      paramString1 = new ReadInjoyWebShareHelper.4(this, paramBoolean, paramJSONObject, bool, paramString1, paramString2, paramString3, paramString5);
      b();
      ThreadManager.post(new ReadInjoyWebShareHelper.5(this, paramString4, bool, paramJSONObject, paramString1, paramBoolean, paramString3), 8, null, false);
      return;
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      a(this.jdField_b_of_type_JavaLangString, paramString);
    }
  }
  
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString2 = this.jdField_a_of_type_Bcdp.a();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      c();
      bcql.a(BaseApplication.getContext(), 0, 2131719487, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WebShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
      }
      try
      {
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
        paramString3 = URLEncoder.encode(paramString3, "UTF-8");
        paramString1 = paramString1 + "&url=" + paramString3;
        paramString3 = URLEncoder.encode(paramString4, "UTF-8");
        paramString1 = paramString1 + "&pic=" + paramString3;
        paramString1 = paramString1 + "&_wv=3";
        paramString3 = new Intent(paramString2, QQBrowserActivity.class);
        paramString3.putExtra("url", paramString1);
        paramString2.startActivity(paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("WebShareHelper", 2, "shareMsgToSina start webview!");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          bcql.a(BaseApplication.getContext(), 0, 2131719487, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298865));
          paramString1.printStackTrace();
          c();
        }
      }
      finally
      {
        c();
      }
    } while (!QLog.isColorLevel());
    QLog.d("WebShareHelper", 2, "shareMsgToSina end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     shh
 * JD-Core Version:    0.7.0.1
 */