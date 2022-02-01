package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractReadInjoyWebShareHelper
  implements ReadInJoyShareHelperV2.OnFontSizeChangeListener
{
  protected String a;
  String b;
  IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener c;
  QQProgressDialog d;
  private ReadInJoyShareHelperV2 e;
  private List<ActionItem> f;
  private List<ActionItem> g;
  private String h;
  private AbstractReadInjoyWebShareHelper.ShareInfo i;
  private long j = -1L;
  private long k = -1L;
  private String l;
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    for (;;)
    {
      String str1;
      try
      {
        JSONObject localJSONObject = new JSONObject(this.h);
        String str6 = localJSONObject.optString("share_type", "0");
        str1 = localJSONObject.optString("title");
        String str3 = localJSONObject.optString("desc");
        String str4 = localJSONObject.optString("share_url");
        String str5 = localJSONObject.optString("image_url");
        String str7 = localJSONObject.optString("shareElement");
        String str2 = localJSONObject.optString("weibo_title");
        boolean bool = localJSONObject.optBoolean("keepShareUrl", false);
        int m = paramActionSheetItem.action;
        if (m != 2) {
          if (m != 3)
          {
            if (m != 9)
            {
              if (m != 10)
              {
                if (m != 12)
                {
                  if (m != 72)
                  {
                    if (m == 73) {}
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
  
  private void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if ((!paramBoolean) && (paramString4 != null) && (paramString4.length() > 140) && (!"3".equals(paramString1))) {
      localHashMap.put("share_url", paramString4);
    }
    if ((paramString5 != null) && (paramString5.length() > 80) && (!"2".equals(paramString1)) && (!"3".equals(paramString1)) && (!"4".equals(paramString1))) {
      localHashMap.put("image_url", paramString5);
    }
    j();
    ThreadManager.post(new AbstractReadInjoyWebShareHelper.3(this, localHashMap, paramString4, paramString5, paramJSONObject, paramString2, paramString3, paramString6), 8, null, true);
  }
  
  private void c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("action", paramString);
      b(localJSONObject.toString());
      f();
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void h()
  {
    this.j = -1L;
    this.k = -1L;
    Intent localIntent = b().getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("fromFav", false)))
    {
      this.j = localIntent.getLongExtra("favID", -1L);
      this.k = localIntent.getLongExtra("favGroupID", -1L);
    }
    if (this.j != -1L) {
      this.g.add(2, new ActionItem("fav_move_group", 39, false));
    }
  }
  
  private List<Integer>[] i()
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.f.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList1.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).b));
    }
    ArrayList localArrayList2 = new ArrayList();
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add(Integer.valueOf(((ActionItem)((Iterator)localObject).next()).b));
    }
    if (localArrayList2.contains(Integer.valueOf(68)))
    {
      localObject = this.i;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((AbstractReadInjoyWebShareHelper.ShareInfo)localObject).c;
      }
      if (TeamWorkConvertUtils.a((String)localObject)) {
        TeamWorkConvertUtils.a(0, 3);
      } else {
        localArrayList2.remove(Integer.valueOf(68));
      }
    }
    return new List[] { localArrayList1, localArrayList2 };
  }
  
  private void j()
  {
    if (this.d == null) {
      this.d = new QQProgressDialog(b(), b().getResources().getDimensionPixelSize(2131299920));
    }
    if (!this.d.isShowing())
    {
      this.d.c(2131891516);
      this.d.show();
    }
  }
  
  private void k()
  {
    QQProgressDialog localQQProgressDialog = this.d;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.d.dismiss();
    }
  }
  
  private void l()
  {
    String str1 = this.i.a;
    String str2 = this.i.b;
    String str3 = this.i.d;
    String str4 = d();
    String str5 = this.i.f;
    QfavBuilder.a(0, str1, this.i.c, str5, str2, str3, null, null, false, -1L).a("lCategory", 8L).c(str4).a(b(), str4);
  }
  
  private void m()
  {
    boolean bool = Pattern.compile("(http|https)://.*.mp.qq.com.*").matcher(this.i.c).matches();
    Object localObject2 = null;
    try
    {
      localObject1 = URLEncoder.encode(this.i.c, "UTF-8");
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
      QLog.d("AbstractReadInjoyWebShareHelper", 2, "encode shareUrl failed, because UTF-8 is unknown");
      localObject1 = localObject2;
    }
    str2 = d();
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
      str1 = e();
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
    localObject2 = new Intent(b(), QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_more_button", true);
    b().startActivity((Intent)localObject2);
  }
  
  public abstract int a(Byte paramByte);
  
  public void a()
  {
    k();
    if (this.c != null) {
      WxShareHelperFromReadInjoy.getInstance().removeObserver(this.c);
    }
  }
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString);
  
  abstract void a(Intent paramIntent, Byte paramByte);
  
  abstract void a(ITroopMemberApiClientApi.Callback paramCallback);
  
  public void a(String paramString)
  {
    if (this.e == null) {
      this.e = new ReadInJoyShareHelperV2(b(), c(), new AbstractReadInjoyWebShareHelper.ItemClickProcessor(this));
    }
    this.e.a().setActionSheetTitle("biu出去让更多好友看到");
    this.e.a().setCancelListener(new AbstractReadInjoyWebShareHelper.1(this));
    try
    {
      this.h = paramString;
      paramString = new JSONObject(this.h);
      JSONArray localJSONArray1 = paramString.optJSONArray("upline");
      JSONArray localJSONArray2 = paramString.optJSONArray("belowline");
      if (localJSONArray1 == null) {
        this.f = ReadInJoyShareHelperV2.j();
      } else {
        this.f = ReadInJoyShareHelperV2.a(localJSONArray1, null);
      }
      if (localJSONArray2 == null) {
        this.g = ReadInJoyShareHelperV2.k();
      } else {
        this.g = ReadInJoyShareHelperV2.a(localJSONArray2, null);
      }
      h();
      this.i = new AbstractReadInjoyWebShareHelper.ShareInfo(null);
      this.i.c = paramString.optString("share_url");
      this.i.b = paramString.optString("desc");
      this.i.a = paramString.optString("title");
      this.i.d = paramString.optString("image_url");
      this.i.e = paramString.optString("puin");
      this.i.f = paramString.optString("nick_name");
      if (TextUtils.isEmpty(this.i.f)) {
        this.i.f = paramString.optString("sourceName");
      }
      this.a = paramString.optString("callback");
      this.l = paramString.optString("rowkey");
      int m = paramString.optInt("report_from");
      this.e.a(i(), m, this.l);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  abstract void a(String paramString, ITroopMemberApiClientApi.Callback paramCallback);
  
  /* Error */
  void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 376
    //   9: iconst_2
    //   10: ldc_w 549
    //   13: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_3
    //   17: invokestatic 555	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +50 -> 74
    //   27: aload 5
    //   29: invokevirtual 558	android/net/Uri:getHost	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   39: ifne +35 -> 74
    //   42: ldc_w 560
    //   45: aload 5
    //   47: invokevirtual 563	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   50: ifne +14 -> 64
    //   53: ldc_w 565
    //   56: aload 5
    //   58: invokevirtual 563	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   61: ifeq +13 -> 74
    //   64: aload_0
    //   65: aload_1
    //   66: aload_2
    //   67: aload_3
    //   68: aload 4
    //   70: invokevirtual 567	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: return
    //   74: aload_0
    //   75: invokevirtual 200	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:b	()Landroid/app/Activity;
    //   78: astore_2
    //   79: aload_1
    //   80: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   83: ifne +363 -> 446
    //   86: aload_3
    //   87: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +6 -> 96
    //   93: goto +353 -> 446
    //   96: invokestatic 573	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   99: invokevirtual 579	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   102: astore 5
    //   104: aload 5
    //   106: ldc_w 581
    //   109: sipush 8192
    //   112: invokevirtual 587	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   115: astore 5
    //   117: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +13 -> 133
    //   123: ldc_w 376
    //   126: iconst_2
    //   127: ldc_w 589
    //   130: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: new 591	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper$6
    //   136: dup
    //   137: aload_0
    //   138: aload 4
    //   140: aload_1
    //   141: aload_3
    //   142: aload 5
    //   144: aload_2
    //   145: invokespecial 594	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper$6:<init>	(Lcom/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/app/Activity;)V
    //   148: invokestatic 598	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   151: goto +272 -> 423
    //   154: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   157: ifeq +13 -> 170
    //   160: ldc_w 376
    //   163: iconst_2
    //   164: ldc_w 600
    //   167: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_1
    //   171: ldc_w 364
    //   174: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_1
    //   178: new 392	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   185: astore 5
    //   187: aload 5
    //   189: ldc_w 602
    //   192: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 5
    //   198: ldc_w 604
    //   201: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 5
    //   207: aload_1
    //   208: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 5
    //   214: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: astore_1
    //   218: aload_3
    //   219: ldc_w 364
    //   222: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   225: astore_3
    //   226: new 392	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   233: astore 5
    //   235: aload 5
    //   237: aload_1
    //   238: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: ldc_w 606
    //   247: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload 5
    //   253: aload_3
    //   254: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore_1
    //   264: aload 4
    //   266: ldc_w 364
    //   269: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_3
    //   273: new 392	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   280: astore 4
    //   282: aload 4
    //   284: aload_1
    //   285: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 4
    //   291: ldc_w 608
    //   294: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 4
    //   300: aload_3
    //   301: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload 4
    //   307: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: astore_1
    //   311: new 392	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   318: astore_3
    //   319: aload_3
    //   320: aload_1
    //   321: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_3
    //   326: ldc_w 427
    //   329: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_3
    //   334: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: astore_1
    //   338: new 210	android/content/Intent
    //   341: dup
    //   342: aload_2
    //   343: ldc_w 435
    //   346: invokespecial 438	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   349: astore_3
    //   350: aload_3
    //   351: ldc_w 440
    //   354: aload_1
    //   355: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   358: pop
    //   359: aload_2
    //   360: aload_3
    //   361: invokevirtual 453	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   364: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +52 -> 419
    //   370: ldc_w 376
    //   373: iconst_2
    //   374: ldc_w 610
    //   377: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto +39 -> 419
    //   383: astore_1
    //   384: goto +56 -> 440
    //   387: astore_1
    //   388: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   391: iconst_0
    //   392: ldc_w 612
    //   395: iconst_0
    //   396: invokestatic 618	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   399: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   402: invokevirtual 619	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   405: ldc_w 293
    //   408: invokevirtual 299	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   411: invokevirtual 622	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   414: pop
    //   415: aload_1
    //   416: invokevirtual 623	java/lang/Exception:printStackTrace	()V
    //   419: aload_0
    //   420: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   423: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +13 -> 439
    //   429: ldc_w 376
    //   432: iconst_2
    //   433: ldc_w 625
    //   436: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: return
    //   440: aload_0
    //   441: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   444: aload_1
    //   445: athrow
    //   446: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +13 -> 462
    //   452: ldc_w 376
    //   455: iconst_2
    //   456: ldc_w 627
    //   459: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   466: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   469: iconst_0
    //   470: ldc_w 612
    //   473: iconst_0
    //   474: invokestatic 618	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   477: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   480: invokevirtual 619	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   483: ldc_w 293
    //   486: invokevirtual 299	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   489: invokevirtual 622	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   492: pop
    //   493: return
    //   494: astore_2
    //   495: goto -421 -> 74
    //   498: astore 5
    //   500: goto -346 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	AbstractReadInjoyWebShareHelper
    //   0	503	1	paramString1	String
    //   0	503	2	paramString2	String
    //   0	503	3	paramString3	String
    //   0	503	4	paramString4	String
    //   20	239	5	localObject	Object
    //   498	1	5	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    // Exception table:
    //   from	to	target	type
    //   170	380	383	finally
    //   388	419	383	finally
    //   170	380	387	java/lang/Exception
    //   16	22	494	java/lang/Exception
    //   27	64	494	java/lang/Exception
    //   64	73	494	java/lang/Exception
    //   104	133	498	android/content/pm/PackageManager$NameNotFoundException
    //   133	151	498	android/content/pm/PackageManager$NameNotFoundException
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    JSONObject localJSONObject;
    if (this.a != null) {
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("action", paramString);
        if (!paramBoolean) {
          break label70;
        }
        paramString = "0";
        localJSONObject.put("retCode", paramString);
        b(localJSONObject.toString());
        f();
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      ShareReport.a.a(paramBoolean);
      return;
      label70:
      paramString = "1";
    }
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    k();
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
    paramString1.putLong("share_begin_time", SwiftBrowserShareMenuHandler.x);
    if (g() != null)
    {
      paramString1.putString("struct_url", g());
      paramString1.putBoolean("from_web", true);
    }
    int m = a(Byte.valueOf((byte)2));
    QZoneShareManager.jumpToQzoneShare(c(), b(), paramString1, null, m);
  }
  
  void a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    String str1 = paramString1;
    paramString5 = paramString2;
    Activity localActivity = b();
    Intent localIntent = new Intent();
    String str2 = paramJSONObject.optString("toUin");
    int m = paramJSONObject.optInt("uinType", 0);
    String str3 = paramJSONObject.optString("uinname");
    if ((str2 != null) && (str2.length() >= 5))
    {
      localIntent.setClass(localActivity, DirectForwardActivity.class);
      localIntent.putExtra("toUin", str2);
      localIntent.putExtra("uinType", m);
      localIntent.putExtra("uinname", str3);
    }
    else
    {
      localIntent.putExtra("isWebCompShare", true);
      localIntent.setClass(localActivity, ForwardRecentActivity.class);
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
    localIntent.putExtra("brief_key", BaseApplicationImpl.getContext().getString(2131894173, new Object[] { str2 }));
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
        localIntent.putExtra("compatible_text", ConfessMsgUtil.b);
      }
    }
    long l1 = paramJSONObject.optLong("appid", 0L);
    if (l1 > 0L)
    {
      paramJSONObject = c();
      if (paramJSONObject != null)
      {
        j();
        localIntent.putExtra("struct_share_key_source_name", Long.toString(l1));
        Share.a(paramJSONObject, localActivity, paramJSONObject.getAccount(), l1, 3000L, new AbstractReadInjoyWebShareHelper.2(this, localIntent));
      }
      return;
    }
    k();
    paramString2 = paramJSONObject.optString("puin", null);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = paramJSONObject.optString("oaUin");
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = c().getEntityManagerFactory(c().getAccount()).createEntityManager();
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
          break label981;
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
          break label981;
        }
      }
      paramString2 = paramString1;
      label981:
      if (paramString2.equalsIgnoreCase(localActivity.getString(2131897917)))
      {
        boolean bool = paramString2.equalsIgnoreCase(localActivity.getString(2131897917));
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
              break label1373;
            }
          }
          if (("web".equals(paramString4)) || (!TextUtils.isEmpty(paramString5)) || ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))))
          {
            localIntent.putExtra("struct_share_key_source_action", paramString4);
            if ("web".equals(paramString4))
            {
              localIntent.putExtra("struct_share_key_source_url", paramString3);
              localIntent.putExtra("source_url", paramString3);
              break label1439;
            }
            if (!TextUtils.isEmpty(paramString5)) {
              localIntent.putExtra("struct_share_key_source_action_data", paramString5);
            }
            if (!TextUtils.isEmpty(str1)) {
              localIntent.putExtra("struct_share_key_source_a_action_data", str1);
            }
            if (TextUtils.isEmpty(str2)) {
              break label1439;
            }
            localIntent.putExtra("struct_share_key_source_i_action_data", str2);
            break label1439;
          }
        }
        label1373:
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
      label1439:
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
        localIntent.putExtra("app_name", localActivity.getString(2131894190));
      }
    }
    localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
    a(localIntent, Byte.valueOf((byte)1));
  }
  
  void a(JSONObject paramJSONObject, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    b();
    int m;
    if (!WXShareHelper.a().b()) {
      m = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      m = 2131918155;
    } else {
      m = -1;
    }
    if (m != -1)
    {
      QRUtils.a(0, m);
      k();
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
    paramString1 = new AbstractReadInjoyWebShareHelper.4(this, paramBoolean, paramJSONObject, bool, paramString1, paramString2, paramString3, paramString5);
    j();
    ThreadManager.post(new AbstractReadInjoyWebShareHelper.5(this, paramString4, bool, paramJSONObject, paramString1, paramBoolean, paramString3), 8, null, false);
  }
  
  @NotNull
  public abstract Activity b();
  
  public abstract void b(String paramString);
  
  /* Error */
  void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 200	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:b	()Landroid/app/Activity;
    //   4: astore_2
    //   5: aload_1
    //   6: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +305 -> 314
    //   12: aload_3
    //   13: invokestatic 118	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +6 -> 22
    //   19: goto +295 -> 314
    //   22: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +13 -> 38
    //   28: ldc_w 376
    //   31: iconst_2
    //   32: ldc_w 600
    //   35: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_1
    //   39: ldc_w 364
    //   42: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore_1
    //   46: new 392	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 602
    //   60: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 5
    //   66: ldc_w 604
    //   69: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 5
    //   75: aload_1
    //   76: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 5
    //   82: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore_1
    //   86: aload_3
    //   87: ldc_w 364
    //   90: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore_3
    //   94: new 392	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   101: astore 5
    //   103: aload 5
    //   105: aload_1
    //   106: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: ldc_w 606
    //   115: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 5
    //   121: aload_3
    //   122: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 5
    //   128: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: astore_1
    //   132: aload 4
    //   134: ldc_w 364
    //   137: invokestatic 369	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: astore_3
    //   141: new 392	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   148: astore 4
    //   150: aload 4
    //   152: aload_1
    //   153: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 4
    //   159: ldc_w 608
    //   162: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 4
    //   168: aload_3
    //   169: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore_1
    //   179: new 392	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 393	java/lang/StringBuilder:<init>	()V
    //   186: astore_3
    //   187: aload_3
    //   188: aload_1
    //   189: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: ldc_w 427
    //   197: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore_1
    //   206: new 210	android/content/Intent
    //   209: dup
    //   210: aload_2
    //   211: ldc_w 435
    //   214: invokespecial 438	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   217: astore_3
    //   218: aload_3
    //   219: ldc_w 440
    //   222: aload_1
    //   223: invokevirtual 444	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   226: pop
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual 453	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   232: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   235: ifeq +52 -> 287
    //   238: ldc_w 376
    //   241: iconst_2
    //   242: ldc_w 610
    //   245: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: goto +39 -> 287
    //   251: astore_1
    //   252: goto +56 -> 308
    //   255: astore_1
    //   256: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   259: iconst_0
    //   260: ldc_w 612
    //   263: iconst_0
    //   264: invokestatic 618	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   267: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   270: invokevirtual 619	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   273: ldc_w 293
    //   276: invokevirtual 299	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   279: invokevirtual 622	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   282: pop
    //   283: aload_1
    //   284: invokevirtual 623	java/lang/Exception:printStackTrace	()V
    //   287: aload_0
    //   288: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   291: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +13 -> 307
    //   297: ldc_w 376
    //   300: iconst_2
    //   301: ldc_w 625
    //   304: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: return
    //   308: aload_0
    //   309: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   312: aload_1
    //   313: athrow
    //   314: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +13 -> 330
    //   320: ldc_w 376
    //   323: iconst_2
    //   324: ldc_w 627
    //   327: invokestatic 381	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: aload_0
    //   331: invokespecial 236	com/tencent/mobileqq/kandian/biz/share/AbstractReadInjoyWebShareHelper:k	()V
    //   334: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   337: iconst_0
    //   338: ldc_w 612
    //   341: iconst_0
    //   342: invokestatic 618	com/tencent/mobileqq/widget/QQToast:makeText	(Landroid/content/Context;III)Lcom/tencent/mobileqq/widget/QQToast;
    //   345: invokestatic 611	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   348: invokevirtual 619	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   351: ldc_w 293
    //   354: invokevirtual 299	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   357: invokevirtual 622	com/tencent/mobileqq/widget/QQToast:show	(I)Landroid/widget/Toast;
    //   360: pop
    //   361: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	AbstractReadInjoyWebShareHelper
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramString3	String
    //   0	362	4	paramString4	String
    //   53	74	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	248	251	finally
    //   256	287	251	finally
    //   38	248	255	java/lang/Exception
  }
  
  @NotNull
  public abstract AppInterface c();
  
  public abstract String d();
  
  public abstract String e();
  
  public abstract void f();
  
  abstract String g();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper
 * JD-Core Version:    0.7.0.1
 */