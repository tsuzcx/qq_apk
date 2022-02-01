package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.QZoneShareManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInjoyWebShareHelper
  implements ReadInJoyShareHelperV2.OnFontSizeChangeListener
{
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public CustomWebView a;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private IReadInJoyWebViewPlugin jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin;
  private ReadInJoyShareHelperV2 jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2;
  private ReadInjoyWebShareHelper.ShareInfo jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo;
  IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  private List<ActionItem> jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private List<ActionItem> jdField_b_of_type_JavaUtilList;
  private String c;
  
  public ReadInjoyWebShareHelper(IReadInJoyWebViewPlugin paramIReadInJoyWebViewPlugin, TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin = paramIReadInJoyWebViewPlugin;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidAppActivity = a();
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = ((CustomWebView)this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a());
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    for (;;)
    {
      String str1;
      try
      {
        JSONObject localJSONObject = new JSONObject(this.c);
        String str6 = localJSONObject.optString("share_type", "0");
        str1 = localJSONObject.optString("title");
        String str3 = localJSONObject.optString("desc");
        String str4 = localJSONObject.optString("share_url");
        String str5 = localJSONObject.optString("image_url");
        String str7 = localJSONObject.optString("shareElement");
        String str2 = localJSONObject.optString("weibo_title");
        boolean bool = localJSONObject.optBoolean("keepShareUrl", false);
        int i = paramActionSheetItem.action;
        if (i != 2) {
          if (i != 3)
          {
            if (i != 9)
            {
              if (i != 10)
              {
                if (i != 12)
                {
                  if (i != 72)
                  {
                    if (i == 73) {}
                  }
                  else
                  {
                    localJSONObject.put("toUin", paramActionSheetItem.uin);
                    localJSONObject.put("uinType", paramActionSheetItem.uinType);
                    localJSONObject.put("uinname", paramActionSheetItem.label);
                  }
                }
                else
                {
                  if (TextUtils.isEmpty(str2)) {
                    break label275;
                  }
                  paramActionSheetItem = str2;
                  a(paramActionSheetItem, str3, str4, str5);
                }
              }
              else {
                a(localJSONObject, false, str1, str3, str4, str5, str7);
              }
            }
            else {
              a(localJSONObject, true, str1, str3, str4, str5, str7);
            }
          }
          else
          {
            a(localJSONObject, str6, str1, str3, str4, str5);
            return;
          }
        }
        a(localJSONObject, str6, str1, str3, str4, str5, str7, 13, bool);
        return;
      }
      catch (Exception paramActionSheetItem)
      {
        return;
      }
      label275:
      paramActionSheetItem = str1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (this.jdField_b_of_type_JavaLangString != null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("action", paramString);
        if (!paramBoolean) {
          break label79;
        }
        paramString = "0";
        localJSONObject.put("retCode", paramString);
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      ShareReport.a.a(paramBoolean);
      return;
      label79:
      paramString = "1";
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
    c();
    ThreadManager.post(new ReadInjoyWebShareHelper.3(this, localHashMap, paramString4, paramString5, paramJSONObject, paramString2, paramString3, paramString6), 8, null, true);
  }
  
  private List<Integer>[] a()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).a));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).a));
    }
    if (localArrayList2.contains(Integer.valueOf(68)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ReadInjoyWebShareHelper.ShareInfo)localObject).c;
      }
      if (TeamWorkConvertUtils.a((String)localObject)) {
        TeamWorkConvertUtils.a(0, 3);
      } else {
        localArrayList2.remove(Integer.valueOf(68));
      }
    }
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = -1L;
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("fromFav", false)))
    {
      this.jdField_a_of_type_Long = localIntent.getLongExtra("favID", -1L);
      this.jdField_b_of_type_Long = localIntent.getLongExtra("favGroupID", -1L);
    }
    if (this.jdField_a_of_type_Long != -1L) {
      this.jdField_b_of_type_JavaUtilList.add(2, new ActionItem("fav_move_group", 39, false));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localActivity, localActivity.getResources().getDimensionPixelSize(2131299168));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131693895);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void e()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.a;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.jdField_b_of_type_JavaLangString;
    String str3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.d;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a();
    String str5 = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.f;
    QfavBuilder.a(0, str1, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.c, str5, str2, str3, null, null, false, -1L).a("lCategory", 8L).c(str4).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a(), str4);
  }
  
  private void f()
  {
    boolean bool = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.c).matches();
    Object localObject2 = null;
    try
    {
      localObject1 = URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.c, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject1;
      label39:
      String str2;
      String str3;
      String str1;
      StringBuilder localStringBuilder;
      break label39;
    }
    localObject1 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.d("WebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
      localObject1 = localObject2;
    }
    str2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a();
    if (bool)
    {
      str3 = String.valueOf(NetConnInfoCenter.getServerTime());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(200);
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append("jubao@article@123");
      str1 = MD5Utils.encodeHexStr(((StringBuilder)localObject2).toString());
      localObject2 = str1;
      if (str1 != null)
      {
        localObject2 = str1;
        if (!str1.isEmpty()) {
          localObject2 = str1.toLowerCase();
        }
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://post.mp.qq.com/jubao/index?qq=");
      localStringBuilder.append(str2);
      localStringBuilder.append("&mp_uin=");
      localStringBuilder.append(str1);
      localStringBuilder.append("&scene=200&sub_appname=article_webview&timestamp=");
      localStringBuilder.append(str3);
      localStringBuilder.append("&sign=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("&article_url=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("&_wv=3");
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://guanjia.qq.com/online_server/m_report.html?shareUrl=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&qq=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("&_wv=7");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
  }
  
  Activity a()
  {
    for (Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public void a()
  {
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener != null) {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getSettings().setTextZoom(SwiftBrowserShareMenuHandler.a[paramInt]);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramInt);
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    boolean bool;
    if (paramInt == -1) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramByte == 1)
    {
      a("qq_friend", bool);
      return;
    }
    if (paramByte == 2) {
      a("qzone", bool);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2 = new ReadInJoyShareHelperV2(this.jdField_a_of_type_AndroidAppActivity, (AppInterface)this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a(), new ReadInjoyWebShareHelper.ItemClickProcessor(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setActionSheetTitle("biu出去让更多好友看到");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a().setCancelListener(new ReadInjoyWebShareHelper.1(this));
    try
    {
      this.c = paramString;
      paramString = new JSONObject(this.c);
      Object localObject = paramString.optJSONArray("upline");
      JSONArray localJSONArray = paramString.optJSONArray("belowline");
      if (localObject == null) {
        this.jdField_a_of_type_JavaUtilList = ReadInJoyShareHelperV2.b();
      } else {
        this.jdField_a_of_type_JavaUtilList = ReadInJoyShareHelperV2.a((JSONArray)localObject, null);
      }
      if (localJSONArray == null) {
        this.jdField_b_of_type_JavaUtilList = ReadInJoyShareHelperV2.c();
      } else {
        this.jdField_b_of_type_JavaUtilList = ReadInJoyShareHelperV2.a(localJSONArray, null);
      }
      b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo = new ReadInjoyWebShareHelper.ShareInfo(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.c = paramString.optString("share_url");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.jdField_b_of_type_JavaLangString = paramString.optString("desc");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.a = paramString.optString("title");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.d = paramString.optString("image_url");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.e = paramString.optString("puin");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.f = paramString.optString("nick_name");
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.f)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$ShareInfo.f = paramString.optString("sourceName");
      }
      this.jdField_b_of_type_JavaLangString = paramString.optString("callback");
      localObject = paramString.optString("rowkey");
      int i = paramString.optInt("report_from");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInJoyShareHelperV2.a(a(), i, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
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
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 401
    //   9: iconst_2
    //   10: ldc_w 602
    //   13: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_3
    //   17: invokestatic 608	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +50 -> 74
    //   27: aload 5
    //   29: invokevirtual 611	android/net/Uri:getHost	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +35 -> 74
    //   42: ldc_w 613
    //   45: aload 5
    //   47: invokevirtual 616	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: ifne +14 -> 64
    //   53: ldc_w 618
    //   56: aload 5
    //   58: invokevirtual 616	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq +13 -> 74
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokevirtual 620	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: return
    //   74: aload_0
    //   75: getfield 34	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin	Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;
    //   78: invokeinterface 365 1 0
    //   83: astore_2
    //   84: aload_1
    //   85: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +363 -> 451
    //   91: aload_3
    //   92: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto +353 -> 451
    //   101: invokestatic 626	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   104: invokevirtual 632	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   107: astore 5
    //   109: aload 5
    //   111: ldc_w 634
    //   114: sipush 8192
    //   117: invokevirtual 640	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   120: astore 5
    //   122: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +13 -> 138
    //   128: ldc_w 401
    //   131: iconst_2
    //   132: ldc_w 642
    //   135: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: new 644	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper$6
    //   141: dup
    //   142: aload_0
    //   143: aload 4
    //   145: aload_1
    //   146: aload_3
    //   147: aload 5
    //   149: aload_2
    //   150: invokespecial 647	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper$6:<init>	(Lcom/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/app/Activity;)V
    //   153: invokestatic 651	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   156: goto +272 -> 428
    //   159: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +13 -> 175
    //   165: ldc_w 401
    //   168: iconst_2
    //   169: ldc_w 653
    //   172: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_1
    //   176: ldc_w 389
    //   179: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: astore_1
    //   183: new 417	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   190: astore 5
    //   192: aload 5
    //   194: ldc_w 655
    //   197: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 5
    //   203: ldc_w 657
    //   206: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 5
    //   212: aload_1
    //   213: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 5
    //   219: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore_1
    //   223: aload_3
    //   224: ldc_w 389
    //   227: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: astore_3
    //   231: new 417	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   238: astore 5
    //   240: aload 5
    //   242: aload_1
    //   243: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: ldc_w 659
    //   252: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 5
    //   258: aload_3
    //   259: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 5
    //   265: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: astore_1
    //   269: aload 4
    //   271: ldc_w 389
    //   274: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   277: astore_3
    //   278: new 417	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   285: astore 4
    //   287: aload 4
    //   289: aload_1
    //   290: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 4
    //   296: ldc_w 661
    //   299: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 4
    //   305: aload_3
    //   306: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 4
    //   312: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: astore_1
    //   316: new 417	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   323: astore_3
    //   324: aload_3
    //   325: aload_1
    //   326: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_3
    //   331: ldc_w 452
    //   334: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_3
    //   339: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: astore_1
    //   343: new 284	android/content/Intent
    //   346: dup
    //   347: aload_2
    //   348: ldc_w 460
    //   351: invokespecial 463	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   354: astore_3
    //   355: aload_3
    //   356: ldc_w 465
    //   359: aload_1
    //   360: invokevirtual 469	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   363: pop
    //   364: aload_2
    //   365: aload_3
    //   366: invokevirtual 478	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   369: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +52 -> 424
    //   375: ldc_w 401
    //   378: iconst_2
    //   379: ldc_w 663
    //   382: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto +39 -> 424
    //   388: astore_1
    //   389: goto +56 -> 445
    //   392: astore_1
    //   393: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   396: iconst_0
    //   397: ldc_w 665
    //   400: iconst_0
    //   401: invokestatic 670	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   404: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   407: invokevirtual 671	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   410: ldc_w 315
    //   413: invokevirtual 321	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   416: invokevirtual 674	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   419: pop
    //   420: aload_1
    //   421: invokevirtual 675	java/lang/Exception:printStackTrace	()V
    //   424: aload_0
    //   425: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   428: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq +13 -> 444
    //   434: ldc_w 401
    //   437: iconst_2
    //   438: ldc_w 677
    //   441: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: return
    //   445: aload_0
    //   446: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   449: aload_1
    //   450: athrow
    //   451: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +13 -> 467
    //   457: ldc_w 401
    //   460: iconst_2
    //   461: ldc_w 679
    //   464: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: aload_0
    //   468: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   471: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   474: iconst_0
    //   475: ldc_w 665
    //   478: iconst_0
    //   479: invokestatic 670	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   482: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   485: invokevirtual 671	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   488: ldc_w 315
    //   491: invokevirtual 321	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   494: invokevirtual 674	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   497: pop
    //   498: return
    //   499: astore_2
    //   500: goto -426 -> 74
    //   503: astore 5
    //   505: goto -346 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	ReadInjoyWebShareHelper
    //   0	508	1	paramString1	String
    //   0	508	2	paramString2	String
    //   0	508	3	paramString3	String
    //   0	508	4	paramString4	String
    //   20	244	5	localObject	Object
    //   503	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   175	385	388	finally
    //   393	424	388	finally
    //   175	385	392	java/lang/Exception
    //   16	22	499	java/lang/Exception
    //   27	64	499	java/lang/Exception
    //   64	73	499	java/lang/Exception
    //   109	138	503	android/content/pm/PackageManager$NameNotFoundException
    //   138	156	503	android/content/pm/PackageManager$NameNotFoundException
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    d();
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
    paramString1.putLong("share_begin_time", SwiftBrowserShareMenuHandler.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.c() != null)
    {
      paramString1.putString("struct_url", this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.c());
      paramString1.putBoolean("from_web", true);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a((byte)2, true);
    QZoneShareManager.jumpToQzoneShare((AppInterface)this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a(), this.jdField_a_of_type_AndroidAppActivity, paramString1, null, i);
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    String str1 = paramString1;
    paramString5 = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a();
    Intent localIntent = new Intent();
    String str2 = paramJSONObject.optString("toUin");
    int i = paramJSONObject.optInt("uinType", 0);
    String str3 = paramJSONObject.optString("uinname");
    if ((str2 != null) && (str2.length() >= 5))
    {
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", str2);
      localIntent.putExtra("uinType", i);
      localIntent.putExtra("uinname", str3);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    }
    localIntent.putExtra("key_flag_from_plugin", true);
    str2 = str1;
    if (str1 != null)
    {
      str2 = str1;
      if (paramString1.length() > 45)
      {
        paramString1 = new StringBuilder();
        paramString1.append(str1.substring(0, 45));
        paramString1.append("…");
        str2 = paramString1.toString();
      }
    }
    paramString1 = paramString5;
    if (paramString5 != null)
    {
      paramString1 = paramString5;
      if (paramString2.length() > 60)
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString5.substring(0, 60));
        paramString1.append("…");
        paramString1 = paramString1.toString();
      }
    }
    if (paramInt <= 0) {
      paramInt = 13;
    }
    localIntent.putExtra("pluginName", "web_share");
    localIntent.putExtra("title", str2);
    localIntent.putExtra("desc", paramString1);
    localIntent.putExtra("detail_url", paramString3);
    localIntent.putExtra("shareQQType", paramInt);
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("req_share_id", paramJSONObject.optLong("appid", -1L));
    localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
    localIntent.putExtra("image_url_remote", paramString4);
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131696401, new Object[] { str2 }));
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
        localIntent.putExtra("compatible_text", ConfessMsgUtil.a);
      }
    }
    long l = paramJSONObject.optLong("appid", 0L);
    if (l > 0L)
    {
      paramJSONObject = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a();
      if (paramJSONObject != null)
      {
        c();
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l));
        Share.a(paramJSONObject, this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.getAccount(), l, 3000L, new ReadInjoyWebShareHelper.2(this, localIntent));
      }
    }
    else
    {
      d();
      paramString2 = paramJSONObject.optString("puin", null);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = paramJSONObject.optString("oaUin");
      }
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a().getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a().getAccount()).createEntityManager();
        paramString5 = (IPublicAccountDetail)paramString2.find(((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountDetail.class), paramString1);
        paramString2.close();
        paramString4 = paramJSONObject.optString("src_action", "");
        paramString3 = null;
        paramString2 = null;
        if (TextUtils.isEmpty(paramString4))
        {
          if (paramString5 != null) {
            paramString2 = paramString5.getName();
          }
          if ((TextUtils.isEmpty(paramString2)) && (paramJSONObject.has("sourceName"))) {
            paramString3 = paramJSONObject.optString("sourceName");
          } else {
            paramString3 = paramString2;
          }
          paramString2 = paramString3;
          if (!TextUtils.isEmpty(paramString3)) {
            break label1009;
          }
        }
        else
        {
          paramString2 = paramString3;
          if (paramJSONObject.has("sourceName")) {
            paramString2 = paramJSONObject.optString("sourceName");
          }
          if ((TextUtils.isEmpty(paramString2)) && (paramString5 != null)) {
            paramString3 = paramString5.getName();
          } else {
            paramString3 = paramString2;
          }
          paramString2 = paramString3;
          if (!TextUtils.isEmpty(paramString3)) {
            break label1009;
          }
        }
        paramString2 = paramString1;
        label1009:
        if (paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699864)))
        {
          boolean bool = paramString2.equalsIgnoreCase(this.jdField_a_of_type_AndroidAppActivity.getString(2131699864));
          if (bool) {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity";
          } else {
            paramJSONObject = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&from=recent";
          }
          if (bool) {
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1";
          } else {
            paramString3 = "mqqapi://readinjoy/open?src_type=internal&version=1&from=recent";
          }
          if (bool) {
            paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/kandian.png";
          } else {
            paramString4 = "https://sqimg.qq.com/qq_product_operations/ydqpush/message_icon/dingyuehao.png";
          }
          localIntent.putExtra("source_puin", paramString1);
          localIntent.putExtra("struct_share_key_source_action", "plugin");
          localIntent.putExtra("struct_share_key_source_a_action_data", paramJSONObject);
          localIntent.putExtra("struct_share_key_source_i_action_data", paramString3);
          localIntent.putExtra("struct_share_key_content_a_action_DATA", paramJSONObject);
          localIntent.putExtra("struct_share_key_source_icon", paramString4);
          localIntent.putExtra("app_name", paramString2);
        }
        else
        {
          paramString3 = paramJSONObject.optString("src_webActionUrl", "");
          paramString5 = paramJSONObject.optString("src_actionData", "");
          str1 = paramJSONObject.optString("src_a_actionData", "");
          str2 = paramJSONObject.optString("src_i_actionData", "");
          if (!TextUtils.isEmpty(paramString4))
          {
            if ("web".equals(paramString4)) {
              if ((TextUtils.isEmpty(paramString3)) || (paramString3.contains("webcard.mp.qq.com"))) {
                break label1405;
              }
            }
            if (("web".equals(paramString4)) || (!TextUtils.isEmpty(paramString5)) || ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))))
            {
              localIntent.putExtra("struct_share_key_source_action", paramString4);
              if ("web".equals(paramString4))
              {
                localIntent.putExtra("struct_share_key_source_url", paramString3);
                localIntent.putExtra("source_url", paramString3);
                break label1471;
              }
              if (!TextUtils.isEmpty(paramString5)) {
                localIntent.putExtra("struct_share_key_source_action_data", paramString5);
              }
              if (!TextUtils.isEmpty(str1)) {
                localIntent.putExtra("struct_share_key_source_a_action_data", str1);
              }
              if (TextUtils.isEmpty(str2)) {
                break label1471;
              }
              localIntent.putExtra("struct_share_key_source_i_action_data", str2);
              break label1471;
            }
          }
          label1405:
          paramString3 = String.format("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity&uin=%s", new Object[] { paramString1 });
          paramString4 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { paramString1 });
          localIntent.putExtra("struct_share_key_source_action", "plugin");
          localIntent.putExtra("struct_share_key_source_a_action_data", paramString3);
          localIntent.putExtra("struct_share_key_source_i_action_data", paramString4);
          localIntent.putExtra("source_puin", paramString1);
          localIntent.putExtra("app_name", paramString2);
          paramJSONObject = paramJSONObject.optString("src_iconUrl", "");
          if (TextUtils.isEmpty(paramJSONObject)) {
            localIntent.putExtra("struct_share_key_source_icon", "https://url.cn/JS8oE7");
          } else {
            localIntent.putExtra("struct_share_key_source_icon", paramJSONObject);
          }
        }
      }
      else
      {
        label1471:
        if (!paramJSONObject.has("sourceName")) {
          break label1604;
        }
        paramString1 = paramJSONObject.optString("sourceName");
        localIntent.putExtra("app_name", paramString1);
        if (("手Q阅读".equals(paramString1)) && (paramJSONObject.has("srcIconUrl"))) {
          localIntent.putExtra("struct_share_key_source_icon", paramJSONObject.optString("srcIconUrl"));
        }
      }
      break label1623;
      label1604:
      localIntent.putExtra("app_name", this.jdField_a_of_type_AndroidAppActivity.getString(2131696418));
      label1623:
      localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.startActivityForResult(localIntent, (byte)1);
    }
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin.a();
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720478;
    } else if (!WXShareHelper.a().b()) {
      i = 2131720479;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QRUtils.a(0, i);
      d();
      return;
    }
    boolean bool;
    if (paramJSONObject.optInt("WXShareToMiniProgram") == 1) {
      bool = true;
    } else {
      bool = false;
    }
    paramString5 = paramJSONObject.optString("WXSharePath");
    paramJSONObject = new HashMap(1);
    paramString1 = new ReadInjoyWebShareHelper.4(this, paramBoolean, paramJSONObject, bool, paramString1, paramString2, paramString3, paramString5);
    c();
    ThreadManager.post(new ReadInjoyWebShareHelper.5(this, paramString4, bool, paramJSONObject, paramString1, paramBoolean, paramString3), 8, null, false);
  }
  
  void b(String paramString)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if (str != null) {
      a(str, paramString);
    }
  }
  
  /* Error */
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebIReadInJoyWebViewPlugin	Lcom/tencent/mobileqq/kandian/biz/detail/web/IReadInJoyWebViewPlugin;
    //   4: invokeinterface 365 1 0
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +305 -> 319
    //   17: aload_3
    //   18: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: goto +295 -> 319
    //   27: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +13 -> 43
    //   33: ldc_w 401
    //   36: iconst_2
    //   37: ldc_w 653
    //   40: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_1
    //   44: ldc_w 389
    //   47: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_1
    //   51: new 417	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   58: astore 5
    //   60: aload 5
    //   62: ldc_w 655
    //   65: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 5
    //   71: ldc_w 657
    //   74: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 5
    //   80: aload_1
    //   81: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 5
    //   87: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore_1
    //   91: aload_3
    //   92: ldc_w 389
    //   95: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_3
    //   99: new 417	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   106: astore 5
    //   108: aload 5
    //   110: aload_1
    //   111: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 5
    //   117: ldc_w 659
    //   120: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload 5
    //   126: aload_3
    //   127: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 5
    //   133: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore_1
    //   137: aload 4
    //   139: ldc_w 389
    //   142: invokestatic 394	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   145: astore_3
    //   146: new 417	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   153: astore 4
    //   155: aload 4
    //   157: aload_1
    //   158: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: ldc_w 661
    //   167: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 4
    //   173: aload_3
    //   174: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 4
    //   180: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore_1
    //   184: new 417	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   191: astore_3
    //   192: aload_3
    //   193: aload_1
    //   194: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_3
    //   199: ldc_w 452
    //   202: invokevirtual 422	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: invokevirtual 428	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: astore_1
    //   211: new 284	android/content/Intent
    //   214: dup
    //   215: aload_2
    //   216: ldc_w 460
    //   219: invokespecial 463	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   222: astore_3
    //   223: aload_3
    //   224: ldc_w 465
    //   227: aload_1
    //   228: invokevirtual 469	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   231: pop
    //   232: aload_2
    //   233: aload_3
    //   234: invokevirtual 478	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   237: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +52 -> 292
    //   243: ldc_w 401
    //   246: iconst_2
    //   247: ldc_w 663
    //   250: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: goto +39 -> 292
    //   256: astore_1
    //   257: goto +56 -> 313
    //   260: astore_1
    //   261: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   264: iconst_0
    //   265: ldc_w 665
    //   268: iconst_0
    //   269: invokestatic 670	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   272: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   275: invokevirtual 671	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   278: ldc_w 315
    //   281: invokevirtual 321	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   284: invokevirtual 674	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   287: pop
    //   288: aload_1
    //   289: invokevirtual 675	java/lang/Exception:printStackTrace	()V
    //   292: aload_0
    //   293: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   296: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +13 -> 312
    //   302: ldc_w 401
    //   305: iconst_2
    //   306: ldc_w 677
    //   309: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: return
    //   313: aload_0
    //   314: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   317: aload_1
    //   318: athrow
    //   319: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +13 -> 335
    //   325: ldc_w 401
    //   328: iconst_2
    //   329: ldc_w 679
    //   332: invokestatic 406	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: invokespecial 337	com/tencent/mobileqq/kandian/biz/share/ReadInjoyWebShareHelper:d	()V
    //   339: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   342: iconst_0
    //   343: ldc_w 665
    //   346: iconst_0
    //   347: invokestatic 670	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   350: invokestatic 664	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   353: invokevirtual 671	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   356: ldc_w 315
    //   359: invokevirtual 321	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   362: invokevirtual 674	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   365: pop
    //   366: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	ReadInjoyWebShareHelper
    //   0	367	1	paramString1	String
    //   0	367	2	paramString2	String
    //   0	367	3	paramString3	String
    //   0	367	4	paramString4	String
    //   58	74	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   43	253	256	finally
    //   261	292	256	finally
    //   43	253	260	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper
 * JD-Core Version:    0.7.0.1
 */