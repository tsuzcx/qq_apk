package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportProcessInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionStatistics;
import cooperation.qwallet.QwJsInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasCommonJsPlugin
  extends VasWebviewJsPlugin
  implements MultiNameSpacePluginCompact
{
  private static final String LOG_TAG_WEB = "WebQlog";
  public static final String PLUGIN_NAMESPACE_FRIEND_DATA = "friendData";
  public static final String PLUGIN_NAMESPACE_QW_DATA = "qw_data";
  public static final String PLUGIN_NAMESPACE_QW_DEBUG = "qw_debug";
  private static final String TAG = "VasCommonJsPlugin";
  private final byte REQUEST_CODE_FRIENDS = 17;
  private VasCommonJsPlugin.JsDebugDialog deBugDialog;
  private List logInfo = Collections.synchronizedList(new ArrayList());
  private boolean logShowTag = true;
  private boolean logStop;
  protected String mCallback;
  protected VasCommonJsPlugin.ChooseFriendReceiver mChoFriReceiver;
  protected VasCommonJsPlugin.ChooseH5PTVReceiver mH5PTVReceiver;
  private Bundle mReqBundle = new Bundle();
  
  private void H5chooseFriends(String paramString)
  {
    Object localObject1 = getCurrentContext();
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString)))
    {
      doChooseFriendResultForH5(null, null, null, null);
      return;
    }
    int i;
    int j;
    boolean bool1;
    boolean bool2;
    try
    {
      localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("title", "选择我的好友");
      i = ((JSONObject)localObject2).optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("h5ptv", 2, "type=" + i);
      }
      this.mCallback = ((JSONObject)localObject2).optString("callback");
      j = Integer.valueOf(((JSONObject)localObject2).optString("limitNum", "0")).intValue();
      boolean bool3 = Boolean.valueOf(((JSONObject)localObject2).optString("isMulti", "false")).booleanValue();
      if ((i & 0x1) == 0)
      {
        bool1 = false;
        if ((i & 0x2) != 0) {
          break label204;
        }
      }
      label204:
      for (bool2 = false;; bool2 = true)
      {
        if (this.mH5PTVReceiver == null) {
          this.mH5PTVReceiver = new VasCommonJsPlugin.ChooseH5PTVReceiver(this, new Handler());
        }
        if (!bool3) {
          break label283;
        }
        if (j >= 1) {
          break label224;
        }
        doChooseFriendResult(null, null, null, null, null, null, null, null);
        return;
        bool1 = true;
        break;
      }
      paramString = new Intent((Context)localObject1, SelectMemberActivity.class);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      doChooseFriendResultForH5(null, null, null, null);
      return;
    }
    label224:
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_min", 1);
    paramString.putExtra("param_max", j);
    paramString.putExtra("param_only_friends", true);
    paramString.addFlags(67108864);
    super.startActivityForResult(paramString, (byte)17);
    return;
    label283:
    Parcel localParcel = Parcel.obtain();
    this.mH5PTVReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    Object localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
    ((Intent)localObject1).putExtra("forward_type", 25);
    ((Intent)localObject1).putExtra("choose_friend_title", paramString);
    ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
    ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
    ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
    ((Intent)localObject1).putExtra("choose_friend_h5_type", i);
    super.startActivityForResult((Intent)localObject1, (byte)0);
  }
  
  private void chooseFriends(String paramString)
  {
    Object localObject1 = null;
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    int m = 1;
    int j = 0;
    int i = 1;
    Context localContext = getCurrentContext();
    if ((localContext == null) || (TextUtils.isEmpty(paramString)))
    {
      doChooseFriendResult(null, null, null, null, null, null, null, null);
      return;
    }
    for (;;)
    {
      String str;
      int i1;
      boolean bool5;
      int i7;
      boolean bool1;
      int i8;
      int i9;
      try
      {
        paramString = new JSONObject(paramString);
        str = paramString.optString("title", "选择我的好友");
        i1 = paramString.optInt("type", 0);
        this.mCallback = paramString.optString("callback");
        bool5 = Boolean.valueOf(paramString.optString("isMulti", "false")).booleanValue();
        i7 = Integer.valueOf(paramString.optString("limitNum", "0")).intValue();
        if ((i1 & 0x1) == 0)
        {
          bool1 = false;
          break label927;
          i8 = paramString.optInt("business_type", 0);
          i9 = paramString.optInt("business_sub_type", 0);
          Object localObject2 = paramString.optJSONObject("from_group");
          paramString = (String)localObject1;
          if (localObject2 == null) {
            break label382;
          }
          localObject1 = ((JSONObject)localObject2).optString("group_uin");
          int i2 = ((JSONObject)localObject2).optInt("group_type");
          int i3 = ((JSONObject)localObject2).optInt("enable_select_all");
          int i4 = ((JSONObject)localObject2).optInt("enable_show_myself", 1);
          int i5 = ((JSONObject)localObject2).optInt("enable_show_myself_first", 0);
          int i6 = ((JSONObject)localObject2).optInt("forbid_only_choose_myself", 0);
          localObject2 = ((JSONObject)localObject2).optJSONArray("group_members");
          i = i6;
          j = i5;
          m = i4;
          n = i3;
          k = i2;
          paramString = (String)localObject1;
          if (localObject2 == null) {
            break label382;
          }
          i1 = 0;
          i = i6;
          j = i5;
          m = i4;
          n = i3;
          k = i2;
          paramString = (String)localObject1;
          if (i1 >= ((JSONArray)localObject2).length()) {
            break label382;
          }
          paramString = ((JSONArray)localObject2).optString(i1);
          if (!TextUtils.isEmpty(paramString)) {
            localArrayList.add(paramString);
          }
          i1 += 1;
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        doChooseFriendResult(null, null, null, null, null, null, null, null);
        return;
      }
      boolean bool2 = true;
      break label937;
      boolean bool3 = true;
      break label948;
      boolean bool4 = true;
      continue;
      label382:
      if (bool5)
      {
        if (i7 < 1)
        {
          doChooseFriendResult(null, null, null, null, null, null, null, null);
          return;
        }
        localObject1 = new Intent(localContext, SelectMemberActivity.class);
        ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
        ((Intent)localObject1).putExtra("param_min", 1);
        ((Intent)localObject1).putExtra("param_max", i7);
        ((Intent)localObject1).addFlags(67108864);
        if ((!TextUtils.isEmpty(paramString)) && ((k == 4) || (k == 8)))
        {
          ((Intent)localObject1).putExtra("param_entrance", 32);
          ((Intent)localObject1).putExtra("param_only_friends", false);
          ((Intent)localObject1).putExtra("param_overload_tips_include_default_count", true);
          ((Intent)localObject1).putExtra("group_uin", paramString);
          if (n != 0)
          {
            bool1 = true;
            ((Intent)localObject1).putExtra("param_enable_all_select", bool1);
            if (m == 0) {
              break label641;
            }
            bool1 = true;
            ((Intent)localObject1).putExtra("param_show_myself", bool1);
            if (j == 0) {
              break label647;
            }
            bool1 = true;
            ((Intent)localObject1).putExtra("is_put_myself_first", bool1);
            if (i == 0) {
              break label653;
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            ((Intent)localObject1).putExtra("is_forbid_only_choose_myself", bool1);
            if (localArrayList.size() <= 0) {
              break label670;
            }
            if (localArrayList.size() <= i7) {
              break label659;
            }
            i = localArrayList.size() - 1;
            while (i >= i7)
            {
              localArrayList.remove(i);
              i -= 1;
            }
            bool1 = false;
            break;
            bool1 = false;
            break label542;
            bool1 = false;
            break label560;
          }
          ((Intent)localObject1).putExtra("param_uins_selected_friends", localArrayList);
          if (k == 4)
          {
            ((Intent)localObject1).putExtra("param_only_troop_member", true);
            ((Intent)localObject1).putExtra("param_only_discussion_member", false);
          }
        }
        for (;;)
        {
          super.startActivityForResult((Intent)localObject1, (byte)17);
          return;
          if (k == 8)
          {
            ((Intent)localObject1).putExtra("param_only_troop_member", false);
            ((Intent)localObject1).putExtra("param_only_discussion_member", true);
            continue;
            ((Intent)localObject1).putExtra("param_only_friends", true);
          }
        }
      }
      label542:
      label560:
      if (this.mChoFriReceiver == null) {
        this.mChoFriReceiver = new VasCommonJsPlugin.ChooseFriendReceiver(this, new Handler());
      }
      label641:
      label647:
      label653:
      label659:
      label670:
      localObject1 = Parcel.obtain();
      this.mChoFriReceiver.writeToParcel((Parcel)localObject1, 0);
      ((Parcel)localObject1).setDataPosition(0);
      paramString = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = new Intent(localContext, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("forward_type", 15);
      ((Intent)localObject1).putExtra("choose_friend_title", str);
      ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
      ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
      ((Intent)localObject1).putExtra("choose_friend_is_groupchats", bool3);
      ((Intent)localObject1).putExtra("choose_friend_is_create_group_chat", bool4);
      ((Intent)localObject1).putExtra("choose_friend_callback", paramString);
      ((Intent)localObject1).putExtra("choose_friend_businessType", i8);
      ((Intent)localObject1).putExtra("choose_friend_businessSubType", i9);
      super.startActivityForResult((Intent)localObject1, (byte)0);
      return;
      label927:
      if ((i1 & 0x2) == 0)
      {
        bool2 = false;
        label937:
        if ((i1 & 0xC) == 0)
        {
          bool3 = false;
          label948:
          if ((i1 & 0x20) == 0) {
            bool4 = false;
          }
        }
      }
    }
  }
  
  public static void debug(String paramString, WebView paramWebView)
  {
    try
    {
      paramString = URLEncoder.encode("{\"msg\":\"nativeinfo==" + paramString + "\"}", "utf-8");
      paramString = "location.href=\"jsbridge://qw_debug/log?p=" + paramString + "\"";
      Looper localLooper1 = Looper.myLooper();
      Looper localLooper2 = Looper.getMainLooper();
      if (localLooper1 == localLooper2) {
        try
        {
          paramWebView.loadUrl("javascript:" + paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
      }
      paramWebView.post(new VasCommonJsPlugin.5(paramWebView, paramString));
      return;
    }
    catch (Exception paramString) {}
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void getPerformance(JSONObject paramJSONObject, WebView paramWebView)
  {
    bool3 = false;
    l1 = -1L;
    l3 = -1L;
    long l33 = -1L;
    long l32 = -1L;
    long l31 = -1L;
    long l30 = -1L;
    long l29 = -1L;
    long l28 = -1L;
    long l27 = -1L;
    l18 = -1L;
    bool7 = false;
    bool2 = false;
    bool6 = false;
    long l34 = 0L;
    long l26 = -1L;
    long l25 = -1L;
    l24 = -1L;
    Object localObject1 = this.mRuntime.a(this.mRuntime.a());
    QLog.i("VasCommonJsPlugin", 2, "baseInterface = " + localObject1);
    Object localObject4 = localObject1;
    if (localObject1 == null)
    {
      localObject4 = localObject1;
      if ((this.mRuntime.a() instanceof QwJsInterface))
      {
        QLog.i("VasCommonJsPlugin", 2, "start check if plugin has WebviewReportSpeedInterface interface...");
        localObject5 = (QwJsInterface)this.mRuntime.a();
        localObject4 = localObject1;
        if ((((QwJsInterface)localObject5).a() instanceof WebUiBaseInterface))
        {
          QLog.i("VasCommonJsPlugin", 2, "plugin has interface for getPerformance...");
          localObject4 = (WebUiBaseInterface)((QwJsInterface)localObject5).a();
        }
      }
    }
    if (localObject4 != null)
    {
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
    }
    try
    {
      if ((localObject4 instanceof WebUiUtils.WebviewReportSpeedInterface))
      {
        bool4 = bool7;
        l2 = l1;
        bool5 = bool3;
        l1 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getmOnCreateMilliTimeStamp();
        bool4 = bool7;
        l2 = l1;
        bool5 = bool3;
        bool1 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).isMainPageUseLocalFile();
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label1163:
        Object localObject6;
        Object localObject7;
        bool1 = false;
        l1 = -1L;
        l15 = -1L;
        l3 = -1L;
        l5 = 0L;
        bool2 = bool4;
        bool3 = false;
        l4 = -1L;
        l6 = -1L;
        l7 = -1L;
        l8 = -1L;
        l9 = -1L;
        l10 = -1L;
        l11 = -1L;
        l12 = -1L;
        l13 = -1L;
        bool4 = true;
        l14 = l2;
        l2 = l15;
        localException1.printStackTrace();
        l15 = l5;
        l5 = l1;
        l1 = l2;
        l2 = l3;
        l3 = l15;
        l15 = l8;
        continue;
        localObject2 = localObject5;
        if (this.mRuntime.a() != null)
        {
          localObject6 = this.mRuntime.a().a().a("apollo");
          localObject2 = localObject5;
          if (localObject6 != null)
          {
            localObject2 = localObject5;
            if ((localObject6 instanceof ApolloJsPlugin))
            {
              localObject6 = ((ApolloJsPlugin)localObject6).getIntercepter();
              localObject2 = localObject5;
              if (localObject6 != null)
              {
                localObject2 = ((ApolloUrlInterceptor)localObject6).a();
                continue;
                i = 1;
                continue;
                paramWebView = "1";
                continue;
                paramJSONObject = ", redirect 302 cost: " + (l5 - l8);
                continue;
                paramJSONObject = ", check offline res cost: " + (l2 - l8);
                continue;
                paramJSONObject = ", read index cost: " + (l1 - l8);
              }
            }
          }
        }
      }
    }
    try
    {
      bool2 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getmPerfFirstLoadTag();
    }
    catch (Exception localException2)
    {
      bool6 = false;
      l15 = -1L;
      l2 = -1L;
      l3 = -1L;
      l5 = 0L;
      bool2 = false;
      bool3 = false;
      l4 = -1L;
      l6 = -1L;
      l7 = -1L;
      l8 = -1L;
      l9 = -1L;
      l10 = -1L;
      l11 = -1L;
      l12 = -1L;
      l13 = -1L;
      l14 = l1;
      bool4 = true;
      bool5 = bool1;
      bool1 = bool6;
      l1 = l15;
      break label3387;
    }
    try
    {
      bool3 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getisWebViewCache();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l30;
      l5 = l31;
      l4 = l32;
      l2 = l33;
    }
    catch (Exception localException3)
    {
      bool7 = false;
      l15 = -1L;
      l2 = -1L;
      l3 = -1L;
      l5 = 0L;
      bool6 = false;
      bool3 = false;
      l4 = -1L;
      l6 = -1L;
      l7 = -1L;
      l8 = -1L;
      l9 = -1L;
      l10 = -1L;
      l11 = -1L;
      l12 = -1L;
      l13 = -1L;
      l14 = l1;
      bool4 = bool2;
      bool5 = bool1;
      bool1 = bool7;
      l1 = l15;
      bool2 = bool6;
      break label3387;
    }
    try
    {
      l14 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getmClickTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l30;
      l5 = l31;
      l4 = l32;
      l2 = l33;
      l3 = l14;
      l15 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getmTimeBeforeLoadUrl();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l30;
      l5 = l31;
      l4 = l32;
      l2 = l15;
      l3 = l14;
      l16 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getonCreateTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l30;
      l5 = l31;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l17 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getviewInflateTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l30;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l19 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getgetWebViewTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l29;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l20 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getinitBrowserTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l28;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l21 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getinitTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l27;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l22 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getinitTBSTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l22;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l18 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getpluginFinished();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l22;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l26 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getOpenUrlAfterCheckOfflineTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l22;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l25 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getReadIndexFromOfflineTime();
      l10 = l24;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l22;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      l23 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getDetect302Time();
      l10 = l23;
      l13 = l25;
      l12 = l26;
      l11 = l18;
      l9 = l22;
      l8 = l21;
      l7 = l20;
      l6 = l19;
      l5 = l17;
      l4 = l16;
      l2 = l15;
      l3 = l14;
      bool6 = ((WebUiUtils.WebviewReportSpeedInterface)localObject4).getIsReloadUrl();
      l8 = l25;
      l6 = l26;
      l24 = 0L;
      bool7 = false;
      l9 = l18;
      l5 = l23;
      l2 = l22;
      l3 = l21;
      l4 = l20;
      l7 = l19;
      l10 = l17;
      l11 = l16;
      l12 = l15;
      l13 = l14;
      bool5 = bool1;
      bool4 = bool2;
      l14 = l1;
      l1 = l9;
      bool2 = bool7;
      l9 = l24;
      bool1 = bool6;
    }
    catch (Exception localException4)
    {
      bool7 = false;
      l21 = 0L;
      bool6 = false;
      l20 = l10;
      l10 = l7;
      l14 = l6;
      l15 = l5;
      l16 = l4;
      l17 = l2;
      l18 = l3;
      l19 = l1;
      bool4 = bool2;
      bool5 = bool1;
      bool1 = bool7;
      l1 = l20;
      l2 = l13;
      l3 = l12;
      l5 = l21;
      bool2 = bool6;
      l4 = l11;
      l6 = l9;
      l7 = l8;
      l8 = l10;
      l9 = l14;
      l10 = l15;
      l11 = l16;
      l12 = l17;
      l13 = l18;
      l14 = l19;
      break label3387;
      i = 0;
      break label1477;
      Object localObject3 = null;
      break label1443;
      bool1 = false;
      l5 = -1L;
      l8 = -1L;
      l6 = -1L;
      l9 = 0L;
      bool3 = false;
      l1 = -1L;
      l2 = -1L;
      l3 = -1L;
      l4 = -1L;
      l7 = -1L;
      l10 = -1L;
      l11 = -1L;
      l12 = -1L;
      l13 = -1L;
      l14 = -1L;
      bool4 = true;
      bool5 = false;
      break label1163;
      localObject3 = null;
      break label2130;
      localObject5 = null;
      bool1 = bool6;
      break label2319;
    }
    l16 = l9;
    l17 = l6;
    l9 = l7;
    l15 = l4;
    l7 = l3;
    l6 = l2;
    l4 = l1;
    l3 = l16;
    l2 = l17;
    l1 = l8;
    localObject5 = null;
    if ((this.mRuntime.a() instanceof ApolloStoreActivity))
    {
      localObject1 = ((ApolloStoreActivity)this.mRuntime.a()).a(true);
      if (localObject1 == null) {
        break label4258;
      }
      localObject5 = new JSONObject();
      ((JSONObject)localObject5).put("thunderCacheType", ((ApolloWebStatistics)localObject1).jdField_a_of_type_Int);
      ((JSONObject)localObject5).put("webViewReadyTime", ((ApolloWebStatistics)localObject1).i);
      ((JSONObject)localObject5).put("sessionStartTime", ((ApolloWebStatistics)localObject1).g);
      ((JSONObject)localObject5).put("sessionEndTime", ((ApolloWebStatistics)localObject1).h);
      ((JSONObject)localObject5).put("SSOStartTime", ((ApolloWebStatistics)localObject1).jdField_a_of_type_Long);
      ((JSONObject)localObject5).put("SSOEndTime", ((ApolloWebStatistics)localObject1).b);
      ((JSONObject)localObject5).put("SSOCallJSTime", ((ApolloWebStatistics)localObject1).d);
      ((JSONObject)localObject5).put("loadUrlTime", ((ApolloWebStatistics)localObject1).j);
      ((JSONObject)localObject5).put("SSORequestTime", ((ApolloWebStatistics)localObject1).c);
      ((JSONObject)localObject5).put("readLocalFileCost", ((ApolloWebStatistics)localObject1).e);
      ((JSONObject)localObject5).put("verifyLocalFileCost", ((ApolloWebStatistics)localObject1).f);
      if (QLog.isColorLevel()) {
        QLog.d("VasCommonJsPlugin", 2, "apollo_client_apolloWebStatistics:" + ((JSONObject)localObject5).toString());
      }
      localObject1 = localObject5;
      label1443:
      bool6 = false;
      if (!(localObject4 instanceof WebUiUtils.WebviewReportProcessInterface)) {
        break label4253;
      }
      i = ((WebUiUtils.WebviewReportProcessInterface)localObject4).b();
      bool6 = ((WebUiUtils.WebviewReportProcessInterface)localObject4).d();
      label1477:
      l8 = l12;
      if (l12 == -1L) {
        l8 = this.onPageStartedTime;
      }
      paramJSONObject.put("clickStart", l13);
      paramJSONObject.put("pageStart", l8);
      paramJSONObject.put("pageFinish", this.onPageFinishedTime);
      paramJSONObject.put("webviewStart", l14);
      paramJSONObject.put("isUseLocalSrc", bool5);
      paramJSONObject.put("noLocalSrcType", HtmlOffline.jdField_a_of_type_Int);
      paramJSONObject.put("isFirstRequest", bool4);
      paramJSONObject.put("isPreloadWebProcess", SwiftBrowserStatistics.jdField_o_of_type_Boolean);
      paramJSONObject.put("isCompletePreloadWebProcess", SwiftBrowserStatistics.jdField_p_of_type_Boolean);
      paramJSONObject.put("isWebViewCache", bool3);
      paramJSONObject.put("onCreate", l11);
      paramJSONObject.put("viewInflate", l10);
      paramJSONObject.put("getWebView", l9);
      paramJSONObject.put("initBrowser", l15);
      paramJSONObject.put("init", l7);
      paramJSONObject.put("initTBS", l6);
      paramJSONObject.put("pluginFinished", l4);
      if (localObject1 != null) {
        paramJSONObject.put("thunderData", localObject1);
      }
      paramJSONObject.put("initWebViewTime", l3);
      paramJSONObject.put("isDirectAddress", bool2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("speed data:");
        ((StringBuilder)localObject1).append("click to create :" + (l14 - l13)).append("create to loadUrl : " + (l8 - l14));
        QLog.d("VasCommonJsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      if (l2 > 0L) {
        paramJSONObject.put("packageCheckFinish", l2);
      }
      if (l1 > 0L) {
        paramJSONObject.put("readIndexTime", l1);
      }
      if (l5 > 0L) {
        paramJSONObject.put("redirect302Time", l5);
      }
      paramJSONObject.put("isReloadUrl", bool1);
      if (i > 0)
      {
        paramJSONObject.put("pid", i);
        if (!bool6) {
          break label3501;
        }
        i = 2;
        paramJSONObject.put("isabnormalstart", i);
      }
      if (paramWebView != null)
      {
        if (paramWebView.getX5WebViewExtension() != null) {
          break label3506;
        }
        paramWebView = "0";
        paramJSONObject.put("isX5", paramWebView);
      }
      if (QLog.isColorLevel())
      {
        paramWebView = new StringBuilder().append("");
        if (l5 > 0L) {
          break label3513;
        }
        paramJSONObject = "";
        paramWebView = paramWebView.append(paramJSONObject);
        if (l2 > 0L) {
          break label3541;
        }
        paramJSONObject = "";
        paramWebView = paramWebView.append(paramJSONObject);
        if (l1 > 0L) {
          break label3569;
        }
        paramJSONObject = "";
        QLog.i("QQBrowser_report", 2, paramJSONObject);
      }
      return;
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      if (!(this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter)) {
        break label4264;
      }
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      localObject6 = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      if (this.mRuntime.a() == null) {
        break label4353;
      }
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      localObject1 = this.mRuntime.a().a().a("offline");
      if (localObject1 == null) {
        break label4347;
      }
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      if (!(localObject1 instanceof OfflinePlugin)) {
        break label4347;
      }
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      localObject1 = (OfflinePlugin)localObject1;
      label2130:
      bool4 = bool7;
      l2 = l1;
      bool5 = bool3;
      localObject7 = this.mRuntime.a().a();
      localObject5 = localObject1;
      bool1 = bool6;
      if (localObject7 != null)
      {
        bool4 = bool7;
        l2 = l1;
        bool5 = bool3;
        localObject7 = ((SonicClientImpl)localObject7).a();
        localObject5 = localObject1;
        bool1 = bool6;
        if (localObject7 != null)
        {
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          localObject5 = ((SonicSession)localObject7).getStatistics();
          if (localObject5 == null) {
            break label3271;
          }
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          if (!((SonicSessionStatistics)localObject5).isDirectAddress) {
            break label3271;
          }
          bool2 = true;
          label2246:
          localObject5 = localObject1;
          bool1 = bool2;
          bool4 = bool2;
          l2 = l1;
          bool5 = bool3;
          if (QLog.isColorLevel())
          {
            bool4 = bool2;
            l2 = l1;
            bool5 = bool3;
            QLog.d("VasCommonJsPlugin", 2, "isDirectAddress = " + bool2);
            bool1 = bool2;
            localObject5 = localObject1;
          }
        }
      }
      label2319:
      bool2 = bool1;
      if (localObject6 == null) {
        break label4264;
      }
      bool4 = bool1;
      l2 = l1;
      bool5 = bool3;
      l1 = ((SwiftBrowserStatistics)localObject6).c;
      if (localObject5 != null)
      {
        bool4 = bool1;
        l2 = l1;
        bool5 = bool3;
        if (((OfflinePlugin)localObject5).e)
        {
          bool2 = true;
          label2375:
          bool4 = bool1;
          l2 = l1;
          bool5 = bool2;
          bool3 = ((SwiftBrowserStatistics)localObject6).d;
        }
      }
      for (;;)
      {
        for (;;)
        {
          boolean bool8;
          try
          {
            bool5 = ((SwiftBrowserStatistics)localObject6).s;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l30;
            l14 = l31;
            l12 = l32;
            l10 = l33;
            l11 = l3;
          }
          catch (Exception localException5)
          {
            label3271:
            Object localObject2;
            bool8 = false;
            l15 = -1L;
            l2 = -1L;
            l3 = -1L;
            l5 = 0L;
            bool6 = bool1;
            bool7 = false;
            l4 = -1L;
            l6 = -1L;
            l7 = -1L;
            l8 = -1L;
            l9 = -1L;
            l10 = -1L;
            l11 = -1L;
            l12 = -1L;
            l13 = -1L;
            l14 = l1;
            bool4 = bool3;
            bool5 = bool2;
            bool1 = bool8;
            l1 = l15;
            bool2 = bool6;
            bool3 = bool7;
            continue;
          }
          try
          {
            l4 = ((SwiftBrowserStatistics)localObject6).b;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l30;
            l14 = l31;
            l12 = l32;
            l10 = l33;
            l11 = l4;
            l5 = ((SwiftBrowserStatistics)localObject6).n;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l30;
            l14 = l31;
            l12 = l32;
            l10 = l5;
            l11 = l4;
            l6 = ((SwiftBrowserStatistics)localObject6).jdField_o_of_type_Long;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l30;
            l14 = l31;
            l12 = l6;
            l10 = l5;
            l11 = l4;
            l7 = ((SwiftBrowserStatistics)localObject6).jdField_p_of_type_Long;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l30;
            l14 = l7;
            l12 = l6;
            l10 = l5;
            l11 = l4;
            l8 = ((SwiftBrowserStatistics)localObject6).j;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l29;
            l15 = l8;
            l14 = l7;
            l12 = l6;
            l10 = l5;
            l11 = l4;
            l9 = ((SwiftBrowserStatistics)localObject6).k;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l28;
            l16 = l9;
            l15 = l8;
            l14 = l7;
            l12 = l6;
            l10 = l5;
            l11 = l4;
            l13 = ((SwiftBrowserStatistics)localObject6).l;
            l23 = l24;
            l22 = l25;
            l21 = l26;
            l20 = l18;
            l19 = l27;
            l17 = l13;
            l16 = l9;
            l15 = l8;
            l14 = l7;
            l12 = l6;
            l10 = l5;
            l11 = l4;
            l18 = ((SwiftBrowserStatistics)localObject6).m;
            l27 = 0L;
            if (localObject5 != null)
            {
              l23 = l24;
              l22 = l25;
              l21 = l26;
              l20 = l27;
              l19 = l18;
              l17 = l13;
              l16 = l9;
              l15 = l8;
              l14 = l7;
              l12 = l6;
              l10 = l5;
              l11 = l4;
              l2 = ((OfflinePlugin)localObject5).jdField_a_of_type_Long;
              if (localObject5 == null) {
                continue;
              }
              l23 = l24;
              l22 = l25;
              l21 = l2;
              l20 = l27;
              l19 = l18;
              l17 = l13;
              l16 = l9;
              l15 = l8;
              l14 = l7;
              l12 = l6;
              l10 = l5;
              l11 = l4;
              l3 = ((OfflinePlugin)localObject5).b;
              l23 = l24;
              l22 = l3;
              l21 = l2;
              l20 = l27;
              l19 = l18;
              l17 = l13;
              l16 = l9;
              l15 = l8;
              l14 = l7;
              l12 = l6;
              l10 = l5;
              l11 = l4;
              l24 = ((SwiftBrowserStatistics)localObject6).q;
              if (localObject5 == null) {
                continue;
              }
              l23 = l24;
              l22 = l3;
              l21 = l2;
              l20 = l27;
              l19 = l18;
              l17 = l13;
              l16 = l9;
              l15 = l8;
              l14 = l7;
              l12 = l6;
              l10 = l5;
              l11 = l4;
              bool4 = ((OfflinePlugin)localObject5).d;
              if (!bool4) {
                continue;
              }
              bool4 = true;
              l10 = l34;
            }
          }
          catch (Exception localException6)
          {
            bool8 = false;
            l2 = l22;
            l3 = l21;
            l5 = 0L;
            bool4 = bool1;
            l4 = l20;
            l6 = l19;
            l7 = l17;
            l8 = l16;
            l9 = l15;
            l13 = l10;
            l15 = l11;
            l16 = l1;
            bool6 = bool3;
            bool7 = bool2;
            bool1 = bool8;
            l1 = l23;
            bool2 = bool4;
            bool3 = bool5;
            l10 = l14;
            l11 = l12;
            l12 = l13;
            l13 = l15;
            l14 = l16;
            bool4 = bool6;
            bool5 = bool7;
            continue;
          }
          try
          {
            l20 = ((SwiftBrowserStatistics)localObject6).r;
            l10 = l20;
            QLog.d("VasCommonJsPlugin", 1, "getPerformance: isWebViewCache = " + bool5 + ", isPreloadWebProcess = " + SwiftBrowserStatistics.jdField_o_of_type_Boolean);
            l17 = l3;
            l19 = l2;
            bool6 = bool1;
            l21 = 0L;
            l2 = l18;
            l3 = l13;
            l10 = l9;
            l11 = l8;
            l12 = l7;
            l13 = l6;
            l14 = l5;
            l15 = l4;
            l16 = l1;
            bool7 = bool3;
            bool8 = bool2;
            bool1 = bool4;
            l5 = l24;
            l8 = l17;
            l6 = l19;
            l9 = l20;
            bool2 = bool6;
            bool3 = bool5;
            l1 = l21;
            l4 = l10;
            l7 = l11;
            l10 = l12;
            l11 = l13;
            l12 = l14;
            l13 = l15;
            l14 = l16;
            bool4 = bool7;
            bool5 = bool8;
          }
          catch (Exception localException7)
          {
            l17 = l2;
            l19 = l10;
            bool6 = bool1;
            l20 = 0L;
            l10 = l8;
            l11 = l7;
            l12 = l6;
            l14 = l5;
            l15 = l4;
            l16 = l1;
            bool7 = bool3;
            bool8 = bool2;
            bool1 = bool4;
            l1 = l24;
            l2 = l3;
            l3 = l17;
            l5 = l19;
            bool2 = bool6;
            bool3 = bool5;
            l4 = l20;
            l6 = l18;
            l7 = l13;
            l8 = l9;
            l9 = l10;
            l10 = l11;
            l11 = l12;
            l12 = l14;
            l13 = l15;
            l14 = l16;
            bool4 = bool7;
            bool5 = bool8;
          }
        }
        bool2 = false;
        break label2246;
        bool2 = false;
        break label2375;
        l2 = 0L;
        continue;
        l3 = 0L;
        continue;
        bool4 = false;
      }
    }
  }
  
  private void getPerformanceFromX5(JSONObject paramJSONObject)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.a());
    if (localObject != null) {}
    for (;;)
    {
      long l1;
      long l6;
      try
      {
        if ((localObject instanceof WebUiUtils.WebviewReportSpeedInterface))
        {
          localObject = ((WebUiUtils.WebviewReportSpeedInterface)localObject).getX5Performance();
          if (localObject == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("VasCommonJsPlugin", 2, "report X5 performance: " + localObject);
          }
          l5 = ((JSONObject)localObject).optLong("first_screen");
          l1 = ((JSONObject)localObject).optLong("dns_start");
          l2 = ((JSONObject)localObject).optLong("dns_end") - l1;
          if (l2 >= 0L)
          {
            l1 = ((JSONObject)localObject).optLong("send_start");
            l3 = ((JSONObject)localObject).optLong("connect_start");
            l3 = ((JSONObject)localObject).optLong("connect_end") - l3;
            if (l3 < 0L) {
              continue;
            }
            l6 = ((JSONObject)localObject).optLong("recv_start");
            l4 = ((JSONObject)localObject).optLong("recv_end");
            if (l1 != 0L) {
              continue;
            }
            l1 = l4 - l6;
            break label425;
            l4 = ((JSONObject)localObject).optLong("ssl_handshake_end") - ((JSONObject)localObject).optLong("ssl_handshake_start");
            if (l4 < 0L) {
              continue;
            }
            break label434;
            QLog.i("Web_X5_Performance", 1, "Web_X5_Load_Index, DNS cost: " + l2 + ", ssl_handshake cost: " + l4 + ", Connect cost: " + l3 + ", receive Cost: " + l1 + ", website Render Cost: " + l5);
            paramJSONObject.put("X5_dns", l2);
            paramJSONObject.put("X5_sslHandeShake", l4);
            paramJSONObject.put("X5_connect", l3);
            paramJSONObject.put("X5_receive", l1);
            paramJSONObject.put("X5_websiteRender", l5);
          }
        }
        else
        {
          if (!(this.mRuntime.a() instanceof SwiftWebViewFragmentSupporter)) {
            break label419;
          }
          localObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
          if (localObject == null) {
            break label419;
          }
          localObject = ((SwiftBrowserStatistics)localObject).a;
          continue;
        }
        long l2 = 0L;
        continue;
        long l3 = 0L;
        continue;
        l1 = l4 - l1;
        break label425;
        l1 = 0L;
        continue;
        long l4 = 0L;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      long l5 = 0L;
      continue;
      label419:
      localObject = null;
      continue;
      label425:
      if (l1 >= 0L)
      {
        continue;
        label434:
        l5 -= l6;
        if (l5 < 0L) {}
      }
    }
  }
  
  private void processWebLog(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString2 = localStringBuilder.append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append("ANDROID").append("|").append("7.6.3.3560").append("|").append(DeviceInfoUtil.f()).append("|").append(this.mRuntime.a().getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
    if (TextUtils.isEmpty(DeviceInfoUtil.a(this.mRuntime.a()).c))
    {
      paramString1 = "未知";
      paramString2 = paramString2.append(paramString1).append("|");
      if (!TextUtils.isEmpty(DeviceInfoUtil.a(this.mRuntime.a()).a)) {
        break label208;
      }
      paramString1 = "未知";
      label167:
      paramString2.append(paramString1);
      if (!paramBoolean) {
        break label225;
      }
      QLog.w("WebLog", 1, localStringBuilder.toString());
    }
    label208:
    label225:
    while (!QLog.isColorLevel())
    {
      return;
      paramString1 = DeviceInfoUtil.a(this.mRuntime.a()).c;
      break;
      paramString1 = DeviceInfoUtil.a(this.mRuntime.a()).a;
      break label167;
    }
    QLog.w("WebLog", 2, localStringBuilder.toString());
  }
  
  private void webLog(JSONObject paramJSONObject)
  {
    try
    {
      processWebLog(paramJSONObject.getString("id"), paramJSONObject.getString("subid"), paramJSONObject.getString("content"), paramJSONObject.getBoolean("isall"));
      return;
    }
    catch (Exception paramJSONObject) {}catch (JSONException paramJSONObject) {}
  }
  
  public void commitPerformanceToWebsite(JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      getPerformance(localJSONObject, this.mRuntime.a());
      getPerformanceFromX5(localJSONObject);
      paramJsBridgeListener.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      paramJsBridgeListener.a("JSONException:" + localJSONException.getMessage());
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      paramJsBridgeListener.a("Exception:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  protected void doChooseFriendResult(List paramList1, List paramList2, List paramList3, List paramList4, List paramList5, List paramList6, List paramList7, List paramList8)
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    int i;
    String str3;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
      {
        i = 0;
        if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
        {
          String str1 = "";
          String str2 = "";
          if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
            str1 = (String)paramList1.get(i);
          }
          if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
            str2 = (String)paramList2.get(i);
          }
          if (TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
            break label624;
          }
          str3 = (String)paramList3.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("uin", str1);
          localJSONObject2.put("phone", str2);
          localJSONObject2.put("name", str3);
          if ((paramList4 != null) && (paramList4.size() > i)) {
            localJSONObject2.put("type", paramList4.get(i));
          }
          for (;;)
          {
            localJSONArray.put(localJSONObject2);
            i += 1;
            break;
            localJSONObject2.put("type", 1);
          }
        }
      }
      if (paramList5 == null) {
        break label619;
      }
    }
    catch (JSONException paramList1)
    {
      paramList1.printStackTrace();
      return;
    }
    label308:
    int k;
    if ((paramList6 != null) && (paramList7 != null) && (paramList8 != null))
    {
      paramList3 = new JSONArray();
      i = 0;
      if ((i >= paramList5.size()) || (i >= paramList6.size()) || (i >= paramList7.size()) || (i >= paramList8.size())) {
        break label657;
      }
      paramList1 = "";
      paramList2 = "";
      int j = 0;
      if (!TextUtils.isEmpty((CharSequence)paramList5.get(i))) {
        paramList1 = (String)paramList5.get(i);
      }
      if (!TextUtils.isEmpty((CharSequence)paramList6.get(i))) {
        paramList2 = (String)paramList6.get(i);
      }
      if (paramList7.get(i) != null) {
        j = ((Integer)paramList7.get(i)).intValue();
      }
      if (paramList8.get(i) != null)
      {
        k = ((Integer)paramList8.get(i)).intValue();
        break label632;
        label490:
        paramList4 = new JSONObject();
        paramList4.put("uin", paramList1);
        paramList4.put("name", paramList2);
        paramList4.put("type", k);
        paramList4.put("count", j);
        paramList3.put(paramList4);
        break label648;
      }
    }
    for (;;)
    {
      localJSONObject1.put("friends", localJSONArray);
      if ((paramList1 != null) && (paramList1.length() > 0)) {
        localJSONObject1.put("groups", paramList1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, localJSONObject1.toString());
      }
      doCallback(this.mCallback, localJSONObject1.toString());
      return;
      k = 0;
      break label632;
      label619:
      paramList1 = null;
      continue;
      label624:
      str3 = "";
      break;
      label632:
      if ((k == 4) || (k == 8)) {
        break label490;
      }
      label648:
      i += 1;
      break label308;
      label657:
      paramList1 = paramList3;
    }
  }
  
  public void doChooseFriendResultForH5(List paramList1, List paramList2, List paramList3, List paramList4)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null) && (paramList4 != null))
        {
          int i = 0;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()) && (i < paramList4.size()))
          {
            String str1 = "";
            String str2 = "";
            String str3 = "";
            if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
              str1 = (String)paramList1.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
              str2 = (String)paramList2.get(i);
            }
            if (!TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              str3 = (String)paramList3.get(i);
            }
            if (TextUtils.isEmpty((CharSequence)paramList4.get(i))) {
              break label320;
            }
            str4 = (String)paramList4.get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", str1);
            localJSONObject2.put("phone", str2);
            localJSONObject2.put("name", str3);
            localJSONObject2.put("type", str4);
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        doCallback(this.mCallback, localJSONObject1.toString());
        return;
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      label320:
      String str4 = "";
    }
  }
  
  public String getCurrentNetwork()
  {
    try
    {
      i = NetworkUtil.a(BaseApplicationImpl.getApplication().getApplicationContext());
      switch (i)
      {
      default: 
        return "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
      return "2G";
    }
    return "3G";
    return "4G";
    return "wifi";
  }
  
  public void getDensity(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      AppInterface localAppInterface = this.mRuntime.a();
      if (localAppInterface != null)
      {
        localJSONObject.put("density", ThemeUtil.getThemeDensity(localAppInterface.getApplication()));
        localJSONObject.put("result", 0);
      }
      for (;;)
      {
        super.callJs(paramString, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", -1);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      super.callJs(paramString, new String[] { localJSONException.getMessage() });
      localJSONException.printStackTrace();
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qw_debug", "qw_data", "friendData" };
  }
  
  public void getNickName(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasCommonJsPlugin", 2, "getNickName " + paramJSONObject.toString());
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONArray("uins");
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramJSONObject.getString(i));
        i += 1;
      }
      this.mReqBundle.clear();
      this.mReqBundle.putStringArrayList("uins", localArrayList);
      paramJSONObject = DataFactory.a("getNickName", paramString, this.mOnRemoteResp.key, this.mReqBundle);
      WebIPCOperator.a().a(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VasCommonJsPlugin", 2, "createShortcut failed: " + paramJSONObject.getMessage());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString2)) || ((!paramString2.startsWith("qw_debug")) && (!paramString2.startsWith("qw_data")) && (!paramString2.startsWith("friendData")))) {
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      paramJsBridgeListener.a("method empty");
      return true;
    }
    try
    {
      if ("log".equals(paramString3))
      {
        if ((!this.logStop) && (this.logShowTag))
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          this.logInfo.add(paramString1.getString("msg"));
          if ((this.deBugDialog != null) && (this.deBugDialog.isShowing())) {
            this.deBugDialog.log(this.logInfo);
          }
        }
      }
      else if ("show".equals(paramString3)) {
        if (this.logStop) {
          paramJsBridgeListener.a("erro:please start log first");
        }
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramJsBridgeListener.a("Exception:" + paramString1.getMessage());
    }
    if (this.deBugDialog == null) {
      this.deBugDialog = new VasCommonJsPlugin.JsDebugDialog(this, this.mRuntime.a());
    }
    if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {}
    for (this.logShowTag = true;; this.logShowTag = false)
    {
      this.deBugDialog.show();
      this.deBugDialog.log(this.logInfo);
      break;
    }
    if ("hide".equals(paramString3))
    {
      if (this.deBugDialog != null) {
        this.deBugDialog.dismiss();
      }
      if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {
        this.logShowTag = true;
      } else {
        this.logShowTag = false;
      }
    }
    else if ("start".equals(paramString3))
    {
      this.logStop = false;
    }
    else if ("stop".equals(paramString3))
    {
      this.logStop = true;
      this.logInfo.clear();
      if (this.deBugDialog != null) {
        this.deBugDialog.log(this.logInfo);
      }
    }
    else if ("qlog".equals(paramString3))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        if (paramString1.has("msg")) {
          QLog.d("WebQlog", 2, paramString1.getString("msg"));
        }
      }
    }
    else if ("getPerformance".equals(paramString3))
    {
      commitPerformanceToWebsite(paramJsBridgeListener);
    }
    else if ("getVipType".equals(paramString3))
    {
      paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramString1 == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasCommonJsPlugin", 2, "handleJsRequest JSON = " + paramString1.toString());
      }
      getVipType(paramString1, paramString1.optString("callback"));
    }
    else if ("startIpcService".equals(paramString3))
    {
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(this.mRuntime.a().getApplicationContext());
      }
    }
    else if ("stopIpcService".equals(paramString3))
    {
      WebIPCOperator.a().a().doUnbindService(this.mRuntime.a().getApplicationContext());
    }
    else if ("isIpcStarted".equals(paramString3))
    {
      paramString1 = new JSONObject();
      paramString1.put("isIpcStarted", WebIPCOperator.a().a());
      paramJsBridgeListener.a(paramString1);
    }
    else if ("getFriendInfo".equals(paramString3))
    {
      if (paramVarArgs.length <= 0) {
        chooseFriends(null);
      } else {
        chooseFriends(paramVarArgs[0]);
      }
    }
    else if ("getFriendRemark".equals(paramString3))
    {
      paramString1 = new JSONObject(paramVarArgs[0]);
      getNickName(paramString1, paramString1.getString("callback"));
    }
    else if ("getDomainIpList".equals(paramString3))
    {
      paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramString1 == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasCommonJsPlugin", 2, "handleJsRequest JSON = " + paramString1.toString());
      }
      super.getDomainIpList(paramString1, paramString1.optString("callback"));
    }
    else if ("getDensity".equals(paramString3))
    {
      paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramString1 == null) {
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasCommonJsPlugin", 2, "handleJsRequest JSON = " + paramString1.toString());
      }
      getDensity(paramString1.optString("callback"));
    }
    else
    {
      if ("detailLog".equals(paramString3))
      {
        webLog(new JSONObject(paramVarArgs[0]));
        return true;
      }
      if ("selectedFriendInfo".equals(paramString3))
      {
        if (paramVarArgs.length <= 0) {
          H5chooseFriends(null);
        } else {
          H5chooseFriends(paramVarArgs[0]);
        }
      }
      else if ("setCurrentActivityShakeFlag".equals(paramString3))
      {
        if ((!TextUtils.isEmpty(paramVarArgs[0])) && (paramVarArgs[0].contains("flag")))
        {
          paramString1 = this.mRuntime.a();
          if ((paramString1 != null) && (!this.isDestroy) && (!paramString1.isFinishing()))
          {
            int i = new JSONObject(paramVarArgs[0]).optInt("flag");
            if ((paramString1 instanceof BaseActivity))
            {
              paramString1 = (BaseActivity)paramString1;
              if (i > 0) {
                bool = true;
              }
              paramString1.mCurrentActivityShakeFlag = bool;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VasCommonJsPlugin", 2, "setCurrentActivityShakeFlag:" + i);
            }
          }
        }
      }
      else
      {
        if ("enableConsoleBlackList".equals(paramString3))
        {
          paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
          if (paramString1 == null) {
            return true;
          }
          paramString2 = this.mRuntime.a();
          if (paramString2 == null) {
            return true;
          }
          paramString2 = paramString2.getWebChromeClient();
          paramString3 = new JSONObject();
          if ((paramString2 instanceof CustomWebChromeClient))
          {
            ((CustomWebChromeClient)paramString2).a = true;
            paramString3.put("code", 0);
          }
          for (;;)
          {
            super.callJs(paramString1.optString("callback"), new String[] { paramString3.toString() });
            break;
            paramString3.put("code", 1);
          }
        }
        paramJsBridgeListener.a("no such method");
        return false;
      }
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramInt == -1) {
      if ((paramByte == 17) && (paramIntent != null)) {}
    }
    while (paramByte != 17)
    {
      return;
      try
      {
        localObject2 = paramIntent.getParcelableArrayListExtra("result_set");
        if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0))
        {
          doChooseFriendResult(null, null, null, null, null, null, null, null);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        doChooseFriendResult(null, null, null, null, null, null, null, null);
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Object localObject3 = paramIntent.getStringExtra("group_uin");
      Object localObject1 = paramIntent.getStringExtra("group_name");
      paramInt = paramIntent.getIntExtra("group_type", 0);
      int i = paramIntent.getIntExtra("group_member_type", 0);
      if (localObject3 != null)
      {
        localArrayList1.add(localObject3);
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = "";
        }
        localArrayList2.add(paramIntent);
        localArrayList3.add(Integer.valueOf(paramInt));
        localArrayList4.add(Integer.valueOf(i));
      }
      paramIntent = new ArrayList();
      localObject1 = new ArrayList();
      localObject3 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      Object localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
        paramIntent.add(localResultRecord.a);
        ((List)localObject1).add("");
        ((List)localObject3).add(localResultRecord.b);
        localArrayList5.add(Integer.valueOf(paramInt));
      }
      doChooseFriendResult(paramIntent, (List)localObject1, (List)localObject3, localArrayList5, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
      return;
    }
    doChooseFriendResult(null, null, null, null, null, null, null, null);
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    String str;
    Object localObject2;
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      localObject1 = paramBundle.getString("cmd");
      str = paramBundle.getString("callbackid");
      localObject2 = paramBundle.getBundle("response");
      if (localObject2 != null) {
        break label62;
      }
      QLog.e("VasCommonJsPlugin", 1, "onResponse respbundle = null");
    }
    label62:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "response:" + (String)localObject1);
      }
    } while ((localObject1 == null) || (!"getNickName".equals(localObject1)));
    paramBundle = new JSONObject();
    Object localObject1 = new JSONObject();
    try
    {
      if (((Bundle)localObject2).containsKey("friendsMap"))
      {
        localObject2 = ((HashMap)((Bundle)localObject2).getSerializable("friendsMap")).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      doCallback(str, paramBundle.toString());
    }
    catch (Throwable localThrowable)
    {
      super.callJsOnError(str, localThrowable.getMessage());
    }
    for (;;)
    {
      return;
      paramBundle.put("remarks", localThrowable);
    }
  }
  
  public void showMsgBox(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      String str1 = paramJSONObject.getString("prompt");
      String str2 = paramJSONObject.getString("title");
      Object localObject = paramJSONObject.getString("button");
      paramJSONObject = ((String)localObject).split("\t");
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "CommonJsHandler showMsgBox prompt=" + str1 + ",title=" + str2 + ",button=" + (String)localObject);
      }
      if (paramJSONObject.length >= 1)
      {
        localObject = DialogUtil.a(this.mRuntime.a(), 230);
        ((QQCustomDialogThreeBtns)localObject).a(str2);
        ((QQCustomDialogThreeBtns)localObject).b(str1);
        ((QQCustomDialogThreeBtns)localObject).a(paramJSONObject[0], new VasCommonJsPlugin.1(this, paramJsBridgeListener));
        if (paramJSONObject.length >= 2) {
          ((QQCustomDialogThreeBtns)localObject).b(paramJSONObject[1], new VasCommonJsPlugin.2(this, paramJsBridgeListener));
        }
        if (paramJSONObject.length >= 3) {
          ((QQCustomDialogThreeBtns)localObject).c(paramJSONObject[2], new VasCommonJsPlugin.3(this, paramJsBridgeListener));
        }
        ((QQCustomDialogThreeBtns)localObject).setCanceledOnTouchOutside(false);
        ((QQCustomDialogThreeBtns)localObject).setOnKeyListener(new VasCommonJsPlugin.4(this, (QQCustomDialogThreeBtns)localObject, paramJsBridgeListener));
        ((QQCustomDialogThreeBtns)localObject).show();
        return;
      }
      paramJsBridgeListener.a("not find buttons" + (String)localObject);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJsBridgeListener.a("JSONException params error:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJsBridgeListener.a("Exception:" + paramJSONObject.getMessage());
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */