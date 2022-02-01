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
import com.tencent.biz.pubaccount.CustomWebChromeClient;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil.NetInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VasCommonJsPlugin
  extends VasWebviewJsPlugin
  implements MultiNameSpacePluginCompact
{
  public static final String H5_CALLBACK_GETFRIENDINFO = "getFriendInfo";
  private static final String LOG_TAG_WEB = "WebQlog";
  public static final String PLUGIN_NAMESPACE_FRIEND_DATA = "friendData";
  public static final String PLUGIN_NAMESPACE_QW_DATA = "qw_data";
  public static final String PLUGIN_NAMESPACE_QW_DEBUG = "qw_debug";
  private static final String TAG = "VasCommonJsPlugin";
  private final byte REQUEST_CODE_FRIENDS = 17;
  private int businessSubType = 0;
  private int businessType = 0;
  private VasCommonJsPlugin.JsDebugDialog deBugDialog;
  private List<String> logInfo = Collections.synchronizedList(new ArrayList());
  private boolean logShowTag = true;
  private boolean logStop = false;
  private String logicMethod = "";
  protected String mCallback;
  protected VasCommonJsPlugin.ChooseFriendReceiver mChoFriReceiver;
  protected VasCommonJsPlugin.ChooseH5PTVReceiver mH5PTVReceiver;
  private Bundle mReqBundle = new Bundle();
  private WebUiBaseInterface uiInterface;
  
  private void H5chooseFriends(String paramString)
  {
    Object localObject1 = getCurrentContext();
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).optString("title", HardCodeUtil.a(2131913246));
        int i = ((JSONObject)localObject2).optInt("type", 0);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("type=");
          ((StringBuilder)localObject3).append(i);
          QLog.d("h5ptv", 2, ((StringBuilder)localObject3).toString());
        }
        this.mCallback = ((JSONObject)localObject2).optString("callback");
        int j = Integer.valueOf(((JSONObject)localObject2).optString("limitNum", "0")).intValue();
        boolean bool3 = Boolean.valueOf(((JSONObject)localObject2).optString("isMulti", "false")).booleanValue();
        boolean bool1;
        if ((i & 0x1) == 0) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        boolean bool2;
        if ((i & 0x2) == 0) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        if (this.mH5PTVReceiver == null) {
          this.mH5PTVReceiver = new VasCommonJsPlugin.ChooseH5PTVReceiver(this, new Handler());
        }
        if (bool3)
        {
          if (j < 1)
          {
            errorCallBack();
            return;
          }
          paramString = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin((Context)localObject1);
          paramString.putExtra("param_donot_need_contacts", true);
          paramString.putExtra("param_min", 1);
          paramString.putExtra("param_max", j);
          paramString.putExtra("param_only_friends", true);
          paramString.addFlags(67108864);
          super.startActivityForResult(paramString, (byte)17);
          return;
        }
        Object localObject3 = Parcel.obtain();
        this.mH5PTVReceiver.writeToParcel((Parcel)localObject3, 0);
        ((Parcel)localObject3).setDataPosition(0);
        localObject2 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel((Parcel)localObject3);
        ((Parcel)localObject3).recycle();
        localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
        ((Intent)localObject1).putExtra("forward_type", 25);
        ((Intent)localObject1).putExtra("choose_friend_title", paramString);
        ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
        ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
        ((Intent)localObject1).putExtra("choose_friend_callback", (Parcelable)localObject2);
        ((Intent)localObject1).putExtra("choose_friend_h5_type", i);
        super.startActivityForResult((Intent)localObject1, (byte)17);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        doChooseFriendResultForH5(null, null, null, null);
        return;
      }
    }
    doChooseFriendResultForH5(null, null, null, null);
  }
  
  private void backH5Friends(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      Object localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
      if ((localObject3 != null) && (((ArrayList)localObject3).size() != 0))
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        Object localObject1 = paramIntent.getStringExtra("group_uin");
        Object localObject2 = paramIntent.getStringExtra("group_name");
        int i = paramIntent.getIntExtra("group_type", 0);
        int j = paramIntent.getIntExtra("group_member_type", 0);
        if (localObject1 != null)
        {
          localArrayList1.add(localObject1);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          localArrayList2.add(localObject1);
          localArrayList3.add(Integer.valueOf(i));
          localArrayList4.add(Integer.valueOf(j));
        }
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        ArrayList localArrayList5 = new ArrayList();
        ArrayList localArrayList6 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
          ((List)localObject1).add(localResultRecord.uin);
          ((List)localObject2).add("");
          localArrayList5.add(localResultRecord.name);
          localArrayList6.add(Integer.valueOf(i));
        }
        boolean bool = QLog.isColorLevel();
        if (bool) {
          QLog.i("VasCommonJsPlugin", 2, "doChooseFriendResult...");
        }
        paramIntent = getJsBackJson(paramIntent, (List)localObject1, (List)localObject2, localArrayList5, localArrayList6, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doChooseFriendResult: ");
        ((StringBuilder)localObject1).append(paramIntent);
        QLog.i("VasCommonJsPlugin", 2, ((StringBuilder)localObject1).toString());
        if (paramIntent == null) {
          break label383;
        }
        doCallback(this.mCallback, paramIntent.toString());
        return;
      }
      errorCallBack();
      return;
    }
    catch (Exception paramIntent)
    {
      label379:
      label383:
      break label379;
    }
    errorCallBack();
  }
  
  private void chooseFriends(String paramString)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = getCurrentContext();
    if ((localObject1 != null) && (!TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        str1 = paramString.optString("title", HardCodeUtil.a(2131913247));
        str2 = paramString.optString("dialog_sub_title", "");
        str3 = paramString.optString("dialog_input", "");
        i = paramString.optInt("type", 0);
        this.mCallback = paramString.optString("callback");
        bool5 = Boolean.valueOf(paramString.optString("isMulti", "false")).booleanValue();
        i2 = Integer.valueOf(paramString.optString("limitNum", "0")).intValue();
        if ((i & 0x1) != 0) {
          break label899;
        }
        bool1 = false;
      }
      catch (Exception paramString)
      {
        String str1;
        String str2;
        String str3;
        boolean bool5;
        int i2;
        Object localObject3;
        int i1;
        int k;
        int m;
        int n;
        int j;
        String str4;
        paramString.printStackTrace();
        errorCallBack();
        return;
      }
      this.businessType = paramString.optInt("business_type", 0);
      this.businessSubType = paramString.optInt("business_sub_type", 0);
      localObject3 = paramString.optJSONObject("from_group");
      if (localObject3 != null)
      {
        paramString = ((JSONObject)localObject3).optString("group_uin");
        i1 = ((JSONObject)localObject3).optInt("group_type");
        k = ((JSONObject)localObject3).optInt("enable_select_all");
        m = ((JSONObject)localObject3).optInt("enable_show_myself", 1);
        n = ((JSONObject)localObject3).optInt("enable_show_myself_first", 0);
        j = ((JSONObject)localObject3).optInt("forbid_only_choose_myself", 0);
        localObject3 = ((JSONObject)localObject3).optJSONArray("group_members");
        if (localObject3 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject3).length())
          {
            str4 = ((JSONArray)localObject3).optString(i);
            if (!TextUtils.isEmpty(str4)) {
              ((ArrayList)localObject2).add(str4);
            }
            i += 1;
            continue;
          }
        }
        i = i1;
      }
      else
      {
        paramString = null;
        i = 0;
        k = 0;
        m = 1;
        n = 0;
        j = 1;
      }
      if (bool5)
      {
        if (i2 < 1)
        {
          errorCallBack();
          return;
        }
        localObject1 = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin((Context)localObject1);
        ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
        ((Intent)localObject1).putExtra("param_min", 1);
        ((Intent)localObject1).putExtra("param_max", i2);
        ((Intent)localObject1).addFlags(67108864);
        if ((!TextUtils.isEmpty(paramString)) && ((i == 4) || (i == 8)))
        {
          ((Intent)localObject1).putExtra("param_entrance", 32);
          ((Intent)localObject1).putExtra("param_only_friends", false);
          ((Intent)localObject1).putExtra("param_overload_tips_include_default_count", true);
          ((Intent)localObject1).putExtra("group_uin", paramString);
          if (k != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Intent)localObject1).putExtra("param_enable_all_select", bool1);
          if (m != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Intent)localObject1).putExtra("param_show_myself", bool1);
          if (n != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Intent)localObject1).putExtra("is_put_myself_first", bool1);
          if (j != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((Intent)localObject1).putExtra("is_forbid_only_choose_myself", bool1);
          if (((ArrayList)localObject2).size() > 0)
          {
            if (((ArrayList)localObject2).size() > i2)
            {
              j = ((ArrayList)localObject2).size() - 1;
              if (j >= i2)
              {
                ((ArrayList)localObject2).remove(j);
                j -= 1;
                continue;
              }
            }
            ((Intent)localObject1).putExtra("param_uins_selected_friends", (Serializable)localObject2);
          }
          if (i == 4)
          {
            ((Intent)localObject1).putExtra("param_only_troop_member", true);
            ((Intent)localObject1).putExtra("param_only_discussion_member", false);
          }
          else if (i == 8)
          {
            ((Intent)localObject1).putExtra("param_only_troop_member", false);
            ((Intent)localObject1).putExtra("param_only_discussion_member", true);
          }
        }
        else
        {
          ((Intent)localObject1).putExtra("param_only_friends", true);
        }
        super.startActivityForResult((Intent)localObject1, (byte)17);
        return;
      }
      if (this.mChoFriReceiver == null) {
        this.mChoFriReceiver = new VasCommonJsPlugin.ChooseFriendReceiver(this, new Handler());
      }
      localObject2 = Parcel.obtain();
      this.mChoFriReceiver.writeToParcel((Parcel)localObject2, 0);
      ((Parcel)localObject2).setDataPosition(0);
      paramString = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel((Parcel)localObject2);
      ((Parcel)localObject2).recycle();
      localObject1 = new Intent((Context)localObject1, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("forward_type", 15);
      ((Intent)localObject1).putExtra("choose_friend_title", str1);
      ((Intent)localObject1).putExtra("choose_friend_dialog_sub_title", str2);
      ((Intent)localObject1).putExtra("choose_friend_dialog_input", str3);
      ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
      boolean bool2;
      ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
      boolean bool3;
      ((Intent)localObject1).putExtra("choose_friend_is_groupchats", bool3);
      boolean bool4;
      ((Intent)localObject1).putExtra("choose_friend_is_create_group_chat", bool4);
      ((Intent)localObject1).putExtra("choose_friend_callback", paramString);
      ((Intent)localObject1).putExtra("choose_friend_businessType", this.businessType);
      ((Intent)localObject1).putExtra("choose_friend_businessSubType", this.businessSubType);
      super.startActivityForResult((Intent)localObject1, (byte)0);
      return;
      errorCallBack();
      return;
      label899:
      boolean bool1 = true;
      if ((i & 0x2) == 0) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      if ((i & 0xC) == 0) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      if ((i & 0x20) == 0) {
        bool4 = false;
      } else {
        bool4 = true;
      }
    }
  }
  
  public static void debug(String paramString, WebView paramWebView)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\"msg\":\"nativeinfo==");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"}");
      paramString = URLEncoder.encode(((StringBuilder)localObject).toString(), "utf-8");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("location.href=\"jsbridge://qw_debug/log?p=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      paramString = ((StringBuilder)localObject).toString();
      localObject = Looper.myLooper();
      Looper localLooper = Looper.getMainLooper();
      if (localObject == localLooper) {
        try
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("javascript:");
          ((StringBuilder)localObject).append(paramString);
          paramWebView.loadUrl(((StringBuilder)localObject).toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doCallback: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" js: ");
    localStringBuilder.append(paramString2);
    QLog.i("VasCommonJsPlugin", 2, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private void errorCallBack()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", "-1");
      localJSONObject.put("msg", "error, parameters wrong...");
      label30:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCallBack: ");
      localStringBuilder.append(localJSONObject);
      QLog.i("VasCommonJsPlugin", 2, localStringBuilder.toString());
      doCallback(this.mCallback, localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label30;
    }
  }
  
  private Context getCurrentContext()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  /* Error */
  private void getPerformance(JSONObject paramJSONObject, WebView paramWebView)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4: aload_0
    //   5: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   8: invokevirtual 537	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   11: invokevirtual 547	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	(Landroid/app/Activity;)Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   14: astore 49
    //   16: new 128	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   23: astore 48
    //   25: aload 48
    //   27: ldc_w 549
    //   30: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 48
    //   36: aload 49
    //   38: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 25
    //   44: iconst_2
    //   45: aload 48
    //   47: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload 49
    //   55: astore 48
    //   57: aload 49
    //   59: ifnonnull +79 -> 138
    //   62: aload 49
    //   64: astore 48
    //   66: aload_0
    //   67: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   70: invokevirtual 553	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   73: instanceof 555
    //   76: ifeq +62 -> 138
    //   79: ldc 25
    //   81: iconst_2
    //   82: ldc_w 557
    //   85: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   92: invokevirtual 553	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   95: checkcast 555	cooperation/qwallet/QwJsInterface
    //   98: astore 50
    //   100: aload 49
    //   102: astore 48
    //   104: aload 50
    //   106: invokeinterface 560 1 0
    //   111: instanceof 562
    //   114: ifeq +24 -> 138
    //   117: ldc 25
    //   119: iconst_2
    //   120: ldc_w 564
    //   123: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload 50
    //   128: invokeinterface 560 1 0
    //   133: checkcast 562	com/tencent/mobileqq/webview/swift/WebUiBaseInterface
    //   136: astore 48
    //   138: aload_0
    //   139: getfield 566	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:uiInterface	Lcom/tencent/mobileqq/webview/swift/WebUiBaseInterface;
    //   142: astore 50
    //   144: aload 50
    //   146: ifnull +6 -> 152
    //   149: goto +7 -> 156
    //   152: aload 48
    //   154: astore 50
    //   156: aload 50
    //   158: ifnull +781 -> 939
    //   161: aload 50
    //   163: instanceof 568
    //   166: ifeq +773 -> 939
    //   169: aload 50
    //   171: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   174: invokeinterface 572 1 0
    //   179: lstore 16
    //   181: aload 50
    //   183: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   186: invokeinterface 575 1 0
    //   191: istore 44
    //   193: aload 50
    //   195: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   198: invokeinterface 578 1 0
    //   203: istore 42
    //   205: aload 50
    //   207: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   210: invokeinterface 581 1 0
    //   215: istore 43
    //   217: aload 50
    //   219: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   222: invokeinterface 584 1 0
    //   227: lstore 4
    //   229: aload 50
    //   231: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   234: invokeinterface 587 1 0
    //   239: lstore 6
    //   241: aload 50
    //   243: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   246: invokeinterface 590 1 0
    //   251: lstore 8
    //   253: aload 50
    //   255: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   258: invokeinterface 593 1 0
    //   263: lstore 18
    //   265: aload 50
    //   267: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   270: invokeinterface 596 1 0
    //   275: lstore 10
    //   277: aload 50
    //   279: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   282: invokeinterface 599 1 0
    //   287: lstore 12
    //   289: aload 50
    //   291: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   294: invokeinterface 602 1 0
    //   299: lstore 14
    //   301: aload 50
    //   303: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   306: invokeinterface 605 1 0
    //   311: lstore 20
    //   313: aload 50
    //   315: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   318: invokeinterface 608 1 0
    //   323: lstore 22
    //   325: aload 50
    //   327: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   330: invokeinterface 611 1 0
    //   335: lstore 34
    //   337: aload 50
    //   339: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   342: invokeinterface 614 1 0
    //   347: lstore 32
    //   349: aload 50
    //   351: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   354: invokeinterface 617 1 0
    //   359: lstore 30
    //   361: aload 50
    //   363: checkcast 568	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportSpeedInterface
    //   366: invokeinterface 620 1 0
    //   371: istore 45
    //   373: iload 42
    //   375: istore 46
    //   377: iload 43
    //   379: istore 42
    //   381: lconst_0
    //   382: lstore 38
    //   384: ldc2_w 621
    //   387: lstore 36
    //   389: lload 22
    //   391: lstore 24
    //   393: iconst_0
    //   394: istore 43
    //   396: lload 14
    //   398: lstore 22
    //   400: lload 10
    //   402: lstore 14
    //   404: lload 8
    //   406: lstore 10
    //   408: lload 16
    //   410: lstore 26
    //   412: lload 6
    //   414: lstore 8
    //   416: lload 18
    //   418: lstore 6
    //   420: lload 12
    //   422: lstore 18
    //   424: lload 20
    //   426: lstore 28
    //   428: lload 34
    //   430: lstore 16
    //   432: lload 32
    //   434: lstore 12
    //   436: lload 30
    //   438: lstore 20
    //   440: lload 38
    //   442: lstore 30
    //   444: lload 36
    //   446: lstore 32
    //   448: goto +1372 -> 1820
    //   451: astore 48
    //   453: lload 30
    //   455: lstore 28
    //   457: goto +10 -> 467
    //   460: astore 48
    //   462: ldc2_w 621
    //   465: lstore 28
    //   467: lload 32
    //   469: lstore 26
    //   471: goto +15 -> 486
    //   474: astore 48
    //   476: ldc2_w 621
    //   479: lstore 26
    //   481: ldc2_w 621
    //   484: lstore 28
    //   486: lload 34
    //   488: lstore 24
    //   490: goto +20 -> 510
    //   493: astore 48
    //   495: ldc2_w 621
    //   498: lstore 24
    //   500: ldc2_w 621
    //   503: lstore 26
    //   505: ldc2_w 621
    //   508: lstore 28
    //   510: ldc2_w 621
    //   513: lstore 34
    //   515: lconst_0
    //   516: lstore 36
    //   518: lload 20
    //   520: lstore 30
    //   522: iconst_0
    //   523: istore 46
    //   525: lload 22
    //   527: lstore 32
    //   529: iconst_0
    //   530: istore 47
    //   532: lload 12
    //   534: lstore 20
    //   536: lload 14
    //   538: lstore 22
    //   540: lload 10
    //   542: lstore 14
    //   544: lload 16
    //   546: lstore 12
    //   548: iload 42
    //   550: istore 45
    //   552: lload 32
    //   554: lstore 16
    //   556: lload 8
    //   558: lstore 10
    //   560: iload 43
    //   562: istore 42
    //   564: iload 47
    //   566: istore 43
    //   568: lload 6
    //   570: lstore 8
    //   572: lload 18
    //   574: lstore 6
    //   576: lload 20
    //   578: lstore 18
    //   580: lload 22
    //   582: lstore 20
    //   584: lload 30
    //   586: lstore 22
    //   588: lload 36
    //   590: lstore 30
    //   592: lload 34
    //   594: lstore 32
    //   596: goto +1393 -> 1989
    //   599: astore 48
    //   601: lload 14
    //   603: lstore 22
    //   605: lload 20
    //   607: lstore 14
    //   609: goto +32 -> 641
    //   612: astore 48
    //   614: lload 14
    //   616: lstore 20
    //   618: lload 12
    //   620: lstore 14
    //   622: lload 20
    //   624: lstore 12
    //   626: goto +46 -> 672
    //   629: astore 48
    //   631: ldc2_w 621
    //   634: lstore 22
    //   636: ldc2_w 621
    //   639: lstore 14
    //   641: lload 10
    //   643: lstore 20
    //   645: lload 12
    //   647: lstore 24
    //   649: lload 22
    //   651: lstore 12
    //   653: lload 14
    //   655: lstore 10
    //   657: goto +53 -> 710
    //   660: astore 48
    //   662: ldc2_w 621
    //   665: lstore 14
    //   667: ldc2_w 621
    //   670: lstore 12
    //   672: ldc2_w 621
    //   675: lstore 22
    //   677: lload 10
    //   679: lstore 20
    //   681: lload 22
    //   683: lstore 10
    //   685: goto +29 -> 714
    //   688: astore 48
    //   690: ldc2_w 621
    //   693: lstore 20
    //   695: ldc2_w 621
    //   698: lstore 24
    //   700: ldc2_w 621
    //   703: lstore 12
    //   705: ldc2_w 621
    //   708: lstore 10
    //   710: lload 24
    //   712: lstore 14
    //   714: lload 4
    //   716: lstore 24
    //   718: lload 8
    //   720: lstore 4
    //   722: iload 42
    //   724: istore 45
    //   726: iload 43
    //   728: istore 42
    //   730: lload 6
    //   732: lstore 8
    //   734: lload 18
    //   736: lstore 6
    //   738: lload 20
    //   740: lstore 26
    //   742: goto +128 -> 870
    //   745: astore 48
    //   747: goto +10 -> 757
    //   750: astore 48
    //   752: ldc2_w 621
    //   755: lstore 8
    //   757: lload 4
    //   759: lstore 24
    //   761: iload 42
    //   763: istore 45
    //   765: lload 8
    //   767: lstore 4
    //   769: lload 6
    //   771: lstore 8
    //   773: goto +68 -> 841
    //   776: astore 48
    //   778: lload 4
    //   780: lstore 24
    //   782: goto +26 -> 808
    //   785: astore 48
    //   787: goto +16 -> 803
    //   790: astore 48
    //   792: goto +8 -> 800
    //   795: astore 48
    //   797: iconst_1
    //   798: istore 42
    //   800: iconst_0
    //   801: istore 43
    //   803: ldc2_w 621
    //   806: lstore 24
    //   808: goto +19 -> 827
    //   811: astore 48
    //   813: iconst_1
    //   814: istore 42
    //   816: iconst_0
    //   817: istore 43
    //   819: ldc2_w 621
    //   822: lstore 24
    //   824: iconst_0
    //   825: istore 44
    //   827: ldc2_w 621
    //   830: lstore 4
    //   832: ldc2_w 621
    //   835: lstore 8
    //   837: iload 42
    //   839: istore 45
    //   841: ldc2_w 621
    //   844: lstore 6
    //   846: ldc2_w 621
    //   849: lstore 26
    //   851: ldc2_w 621
    //   854: lstore 14
    //   856: ldc2_w 621
    //   859: lstore 12
    //   861: ldc2_w 621
    //   864: lstore 10
    //   866: iload 43
    //   868: istore 42
    //   870: iconst_0
    //   871: istore 43
    //   873: lload 10
    //   875: lstore 22
    //   877: lload 12
    //   879: lstore 20
    //   881: lload 14
    //   883: lstore 18
    //   885: lload 26
    //   887: lstore 14
    //   889: lload 16
    //   891: lstore 12
    //   893: iconst_0
    //   894: istore 46
    //   896: ldc2_w 621
    //   899: lstore 32
    //   901: lconst_0
    //   902: lstore 30
    //   904: ldc2_w 621
    //   907: lstore 28
    //   909: ldc2_w 621
    //   912: lstore 26
    //   914: ldc2_w 621
    //   917: lstore 34
    //   919: ldc2_w 621
    //   922: lstore 16
    //   924: lload 4
    //   926: lstore 10
    //   928: lload 24
    //   930: lstore 4
    //   932: lload 34
    //   934: lstore 24
    //   936: goto +1053 -> 1989
    //   939: aload_0
    //   940: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   943: invokevirtual 537	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   946: instanceof 624
    //   949: ifeq +783 -> 1732
    //   952: aload_0
    //   953: bipush 254
    //   955: invokespecial 627	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:getBrowserComponent	(I)Ljava/lang/Object;
    //   958: checkcast 629	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics
    //   961: astore 51
    //   963: aload_0
    //   964: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   967: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   970: ifnull +2012 -> 2982
    //   973: aload_0
    //   974: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   977: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   980: invokevirtual 638	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   983: ldc_w 640
    //   986: invokevirtual 645	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   989: astore 48
    //   991: aload 48
    //   993: ifnull +1983 -> 2976
    //   996: aload 48
    //   998: instanceof 647
    //   1001: ifeq +1975 -> 2976
    //   1004: aload 48
    //   1006: checkcast 647	com/tencent/biz/webviewplugin/OfflinePlugin
    //   1009: astore 48
    //   1011: goto +3 -> 1014
    //   1014: aload_0
    //   1015: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1018: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1021: invokevirtual 651	com/tencent/biz/pubaccount/CustomWebView:getSonicClient	()Lcom/tencent/mobileqq/webview/sonic/SonicClientImpl;
    //   1024: astore 52
    //   1026: aload 48
    //   1028: astore 49
    //   1030: aload 52
    //   1032: ifnull +1953 -> 2985
    //   1035: aload 52
    //   1037: invokevirtual 657	com/tencent/mobileqq/webview/sonic/SonicClientImpl:getSession	()Lcom/tencent/sonic/sdk/SonicSession;
    //   1040: astore 52
    //   1042: aload 48
    //   1044: astore 49
    //   1046: aload 52
    //   1048: ifnull +1937 -> 2985
    //   1051: aload 52
    //   1053: invokevirtual 663	com/tencent/sonic/sdk/SonicSession:getStatistics	()Lcom/tencent/sonic/sdk/SonicSessionStatistics;
    //   1056: astore 49
    //   1058: aload 49
    //   1060: ifnull +21 -> 1081
    //   1063: aload 49
    //   1065: getfield 668	com/tencent/sonic/sdk/SonicSessionStatistics:isDirectAddress	Z
    //   1068: istore 42
    //   1070: iload 42
    //   1072: ifeq +9 -> 1081
    //   1075: iconst_1
    //   1076: istore 42
    //   1078: goto +6 -> 1084
    //   1081: iconst_0
    //   1082: istore 42
    //   1084: aload 48
    //   1086: astore 49
    //   1088: iload 42
    //   1090: istore 43
    //   1092: iload 42
    //   1094: istore 44
    //   1096: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1099: ifeq +67 -> 1166
    //   1102: iload 42
    //   1104: istore 44
    //   1106: new 128	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1113: astore 49
    //   1115: iload 42
    //   1117: istore 44
    //   1119: aload 49
    //   1121: ldc_w 670
    //   1124: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: pop
    //   1128: iload 42
    //   1130: istore 44
    //   1132: aload 49
    //   1134: iload 42
    //   1136: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1139: pop
    //   1140: iload 42
    //   1142: istore 44
    //   1144: ldc 25
    //   1146: iconst_2
    //   1147: aload 49
    //   1149: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1155: aload 48
    //   1157: astore 49
    //   1159: iload 42
    //   1161: istore 43
    //   1163: goto +3 -> 1166
    //   1166: aload 51
    //   1168: ifnull +561 -> 1729
    //   1171: iload 43
    //   1173: istore 44
    //   1175: aload 51
    //   1177: getfield 676	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:d	J
    //   1180: lstore 12
    //   1182: aload 49
    //   1184: ifnull +29 -> 1213
    //   1187: aload 49
    //   1189: getfield 679	com/tencent/biz/webviewplugin/OfflinePlugin:v	Z
    //   1192: istore 42
    //   1194: iload 42
    //   1196: ifeq +17 -> 1213
    //   1199: iconst_1
    //   1200: istore 44
    //   1202: goto +14 -> 1216
    //   1205: astore 48
    //   1207: iconst_0
    //   1208: istore 44
    //   1210: goto +702 -> 1912
    //   1213: iconst_0
    //   1214: istore 44
    //   1216: aload 51
    //   1218: getfield 682	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:aq	Z
    //   1221: istore 46
    //   1223: aload 51
    //   1225: getfield 685	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:aH	Z
    //   1228: istore 42
    //   1230: aload 51
    //   1232: getfield 687	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:c	J
    //   1235: lstore 4
    //   1237: aload 51
    //   1239: getfield 690	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:u	J
    //   1242: lstore 6
    //   1244: lload 12
    //   1246: lstore 26
    //   1248: aload 51
    //   1250: getfield 692	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:v	J
    //   1253: lstore 10
    //   1255: lload 6
    //   1257: lstore 8
    //   1259: aload 51
    //   1261: getfield 695	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:w	J
    //   1264: lstore 14
    //   1266: lload 14
    //   1268: lstore 6
    //   1270: aload 51
    //   1272: getfield 698	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:p	J
    //   1275: lstore 14
    //   1277: aload 51
    //   1279: getfield 701	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:q	J
    //   1282: lstore 18
    //   1284: aload 51
    //   1286: getfield 704	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:r	J
    //   1289: lstore 22
    //   1291: aload 51
    //   1293: getfield 707	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:t	J
    //   1296: lstore 36
    //   1298: aload 49
    //   1300: ifnull +87 -> 1387
    //   1303: aload 49
    //   1305: getfield 710	com/tencent/biz/webviewplugin/OfflinePlugin:o	J
    //   1308: lstore 16
    //   1310: goto +80 -> 1390
    //   1313: astore 48
    //   1315: ldc2_w 621
    //   1318: lstore 16
    //   1320: ldc2_w 621
    //   1323: lstore 12
    //   1325: iconst_0
    //   1326: istore 45
    //   1328: ldc2_w 621
    //   1331: lstore 20
    //   1333: lconst_0
    //   1334: lstore 30
    //   1336: ldc2_w 621
    //   1339: lstore 32
    //   1341: lload 20
    //   1343: lstore 28
    //   1345: lload 12
    //   1347: lstore 34
    //   1349: lload 16
    //   1351: lstore 24
    //   1353: iload 45
    //   1355: istore 47
    //   1357: iload 46
    //   1359: istore 45
    //   1361: lconst_0
    //   1362: lstore 16
    //   1364: iload 47
    //   1366: istore 46
    //   1368: lload 26
    //   1370: lstore 12
    //   1372: lload 22
    //   1374: lstore 20
    //   1376: lload 36
    //   1378: lstore 22
    //   1380: lload 34
    //   1382: lstore 26
    //   1384: goto +605 -> 1989
    //   1387: lconst_0
    //   1388: lstore 16
    //   1390: lload 36
    //   1392: lstore 28
    //   1394: aload 49
    //   1396: ifnull +30 -> 1426
    //   1399: lload 16
    //   1401: lstore 12
    //   1403: aload 49
    //   1405: getfield 711	com/tencent/biz/webviewplugin/OfflinePlugin:p	J
    //   1408: lstore 20
    //   1410: lload 20
    //   1412: lstore 12
    //   1414: goto +15 -> 1429
    //   1417: astore 48
    //   1419: lload 12
    //   1421: lstore 16
    //   1423: goto -103 -> 1320
    //   1426: lconst_0
    //   1427: lstore 12
    //   1429: aload 51
    //   1431: getfield 714	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:x	J
    //   1434: lstore 20
    //   1436: aload 49
    //   1438: ifnull +29 -> 1467
    //   1441: aload 49
    //   1443: getfield 717	com/tencent/biz/webviewplugin/OfflinePlugin:n	Z
    //   1446: istore 45
    //   1448: iload 45
    //   1450: ifeq +17 -> 1467
    //   1453: iconst_1
    //   1454: istore 45
    //   1456: goto +14 -> 1470
    //   1459: astore 48
    //   1461: iconst_0
    //   1462: istore 45
    //   1464: goto -131 -> 1333
    //   1467: iconst_0
    //   1468: istore 45
    //   1470: aload 51
    //   1472: getfield 720	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:y	J
    //   1475: lstore 30
    //   1477: aload 51
    //   1479: getfield 723	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:h	J
    //   1482: lstore 24
    //   1484: new 128	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1491: astore 48
    //   1493: aload 48
    //   1495: ldc_w 725
    //   1498: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: pop
    //   1502: aload 48
    //   1504: iload 42
    //   1506: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1509: pop
    //   1510: aload 48
    //   1512: ldc_w 727
    //   1515: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: pop
    //   1519: aload 48
    //   1521: getstatic 730	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:aD	Z
    //   1524: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1527: pop
    //   1528: aload 48
    //   1530: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: astore 48
    //   1535: lload 24
    //   1537: lstore 32
    //   1539: ldc 25
    //   1541: iconst_1
    //   1542: aload 48
    //   1544: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1547: lconst_0
    //   1548: lstore 24
    //   1550: goto +270 -> 1820
    //   1553: astore 48
    //   1555: goto +5 -> 1560
    //   1558: astore 48
    //   1560: lload 24
    //   1562: lstore 32
    //   1564: iload 45
    //   1566: istore 47
    //   1568: lload 16
    //   1570: lstore 24
    //   1572: lload 12
    //   1574: lstore 34
    //   1576: lload 20
    //   1578: lstore 28
    //   1580: goto -223 -> 1357
    //   1583: astore 48
    //   1585: goto -249 -> 1336
    //   1588: astore 48
    //   1590: goto -257 -> 1333
    //   1593: astore 48
    //   1595: goto -270 -> 1325
    //   1598: astore 48
    //   1600: lload 4
    //   1602: lstore 24
    //   1604: lload 22
    //   1606: lstore 20
    //   1608: goto +91 -> 1699
    //   1611: astore 48
    //   1613: goto +77 -> 1690
    //   1616: astore 48
    //   1618: goto +67 -> 1685
    //   1621: astore 48
    //   1623: goto +57 -> 1680
    //   1626: astore 48
    //   1628: goto +10 -> 1638
    //   1631: astore 48
    //   1633: ldc2_w 621
    //   1636: lstore 10
    //   1638: lload 6
    //   1640: lstore 8
    //   1642: goto +33 -> 1675
    //   1645: astore 48
    //   1647: goto +18 -> 1665
    //   1650: astore 48
    //   1652: goto +8 -> 1660
    //   1655: astore 48
    //   1657: iconst_0
    //   1658: istore 42
    //   1660: ldc2_w 621
    //   1663: lstore 4
    //   1665: ldc2_w 621
    //   1668: lstore 10
    //   1670: ldc2_w 621
    //   1673: lstore 8
    //   1675: ldc2_w 621
    //   1678: lstore 6
    //   1680: ldc2_w 621
    //   1683: lstore 14
    //   1685: ldc2_w 621
    //   1688: lstore 18
    //   1690: ldc2_w 621
    //   1693: lstore 20
    //   1695: lload 4
    //   1697: lstore 24
    //   1699: iload 46
    //   1701: istore 45
    //   1703: ldc2_w 621
    //   1706: lstore 22
    //   1708: lload 10
    //   1710: lstore 4
    //   1712: goto -819 -> 893
    //   1715: astore 48
    //   1717: goto +195 -> 1912
    //   1720: astore 48
    //   1722: iload 44
    //   1724: istore 43
    //   1726: goto +178 -> 1904
    //   1729: goto +6 -> 1735
    //   1732: iconst_0
    //   1733: istore 43
    //   1735: ldc2_w 621
    //   1738: lstore 4
    //   1740: iconst_0
    //   1741: istore 42
    //   1743: iconst_0
    //   1744: istore 45
    //   1746: ldc2_w 621
    //   1749: lstore 10
    //   1751: ldc2_w 621
    //   1754: lstore 24
    //   1756: iconst_1
    //   1757: istore 46
    //   1759: iconst_0
    //   1760: istore 44
    //   1762: ldc2_w 621
    //   1765: lstore 26
    //   1767: ldc2_w 621
    //   1770: lstore 8
    //   1772: ldc2_w 621
    //   1775: lstore 6
    //   1777: ldc2_w 621
    //   1780: lstore 14
    //   1782: ldc2_w 621
    //   1785: lstore 18
    //   1787: ldc2_w 621
    //   1790: lstore 22
    //   1792: ldc2_w 621
    //   1795: lstore 28
    //   1797: ldc2_w 621
    //   1800: lstore 16
    //   1802: ldc2_w 621
    //   1805: lstore 12
    //   1807: ldc2_w 621
    //   1810: lstore 20
    //   1812: lconst_0
    //   1813: lstore 30
    //   1815: ldc2_w 621
    //   1818: lstore 32
    //   1820: iload 46
    //   1822: istore 47
    //   1824: iload 45
    //   1826: istore 46
    //   1828: ldc 25
    //   1830: astore 48
    //   1832: lload 26
    //   1834: lstore 40
    //   1836: lload 6
    //   1838: lstore 38
    //   1840: lload 28
    //   1842: lstore 26
    //   1844: lload 16
    //   1846: lstore 28
    //   1848: lload 12
    //   1850: lstore 34
    //   1852: lload 20
    //   1854: lstore 36
    //   1856: lload 40
    //   1858: lstore 6
    //   1860: iload 47
    //   1862: istore 45
    //   1864: lload 38
    //   1866: lstore 12
    //   1868: lload 18
    //   1870: lstore 16
    //   1872: lload 22
    //   1874: lstore 18
    //   1876: lload 26
    //   1878: lstore 20
    //   1880: lload 32
    //   1882: lstore 22
    //   1884: lload 30
    //   1886: lstore 26
    //   1888: lload 34
    //   1890: lstore 30
    //   1892: lload 36
    //   1894: lstore 32
    //   1896: goto +162 -> 2058
    //   1899: astore 48
    //   1901: iconst_0
    //   1902: istore 43
    //   1904: iconst_0
    //   1905: istore 44
    //   1907: ldc2_w 621
    //   1910: lstore 12
    //   1912: ldc2_w 621
    //   1915: lstore 4
    //   1917: iconst_0
    //   1918: istore 42
    //   1920: iconst_0
    //   1921: istore 46
    //   1923: ldc2_w 621
    //   1926: lstore 10
    //   1928: ldc2_w 621
    //   1931: lstore 16
    //   1933: iconst_1
    //   1934: istore 45
    //   1936: ldc2_w 621
    //   1939: lstore 8
    //   1941: ldc2_w 621
    //   1944: lstore 6
    //   1946: ldc2_w 621
    //   1949: lstore 14
    //   1951: ldc2_w 621
    //   1954: lstore 18
    //   1956: ldc2_w 621
    //   1959: lstore 20
    //   1961: ldc2_w 621
    //   1964: lstore 22
    //   1966: ldc2_w 621
    //   1969: lstore 24
    //   1971: ldc2_w 621
    //   1974: lstore 26
    //   1976: ldc2_w 621
    //   1979: lstore 28
    //   1981: lconst_0
    //   1982: lstore 30
    //   1984: ldc2_w 621
    //   1987: lstore 32
    //   1989: aload 48
    //   1991: invokevirtual 287	java/lang/Exception:printStackTrace	()V
    //   1994: ldc 25
    //   1996: astore 48
    //   1998: lload 18
    //   2000: lstore 34
    //   2002: lload 20
    //   2004: lstore 18
    //   2006: lload 22
    //   2008: lstore 20
    //   2010: lload 30
    //   2012: lstore 22
    //   2014: lload 32
    //   2016: lstore 38
    //   2018: lload 12
    //   2020: lstore 36
    //   2022: lload 28
    //   2024: lstore 32
    //   2026: lload 26
    //   2028: lstore 30
    //   2030: lload 24
    //   2032: lstore 28
    //   2034: lload 22
    //   2036: lstore 26
    //   2038: lload 38
    //   2040: lstore 22
    //   2042: lload 16
    //   2044: lstore 24
    //   2046: lload 34
    //   2048: lstore 16
    //   2050: lload 6
    //   2052: lstore 12
    //   2054: lload 36
    //   2056: lstore 6
    //   2058: aload_0
    //   2059: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2062: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2065: ifnull +100 -> 2165
    //   2068: aload_0
    //   2069: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2072: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2075: invokevirtual 638	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   2078: ifnull +87 -> 2165
    //   2081: aload_0
    //   2082: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2085: invokevirtual 632	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   2088: invokevirtual 638	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   2091: ldc_w 732
    //   2094: invokevirtual 645	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   2097: astore 49
    //   2099: aload 49
    //   2101: instanceof 734
    //   2104: ifeq +61 -> 2165
    //   2107: aload_0
    //   2108: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2111: invokevirtual 537	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2114: ifnull +31 -> 2145
    //   2117: aload_0
    //   2118: getfield 532	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2121: invokevirtual 537	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   2124: invokevirtual 740	java/lang/Object:getClass	()Ljava/lang/Class;
    //   2127: invokevirtual 745	java/lang/Class:getName	()Ljava/lang/String;
    //   2130: ldc_w 747
    //   2133: invokevirtual 751	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2136: ifeq +9 -> 2145
    //   2139: iconst_1
    //   2140: istore 47
    //   2142: goto +6 -> 2148
    //   2145: iconst_0
    //   2146: istore 47
    //   2148: aload 49
    //   2150: checkcast 734	com/tencent/mobileqq/apollo/web/api/IApolloJsPlugin
    //   2153: iload 47
    //   2155: invokeinterface 755 2 0
    //   2160: astore 49
    //   2162: goto +6 -> 2168
    //   2165: aconst_null
    //   2166: astore 49
    //   2168: aload 50
    //   2170: instanceof 757
    //   2173: ifeq +30 -> 2203
    //   2176: aload 50
    //   2178: checkcast 757	com/tencent/mobileqq/webviewplugin/WebUiUtils$WebviewReportProcessInterface
    //   2181: astore 50
    //   2183: aload 50
    //   2185: invokeinterface 760 1 0
    //   2190: istore_3
    //   2191: aload 50
    //   2193: invokeinterface 763 1 0
    //   2198: istore 47
    //   2200: goto +8 -> 2208
    //   2203: iconst_0
    //   2204: istore_3
    //   2205: iconst_0
    //   2206: istore 47
    //   2208: lload 8
    //   2210: ldc2_w 621
    //   2213: lcmp
    //   2214: ifne +12 -> 2226
    //   2217: aload_0
    //   2218: getfield 766	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:onPageStartedTime	J
    //   2221: lstore 8
    //   2223: goto +3 -> 2226
    //   2226: aload_1
    //   2227: ldc_w 768
    //   2230: lload 4
    //   2232: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2235: pop
    //   2236: aload_1
    //   2237: ldc_w 773
    //   2240: lload 8
    //   2242: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2245: pop
    //   2246: aload_1
    //   2247: ldc_w 775
    //   2250: aload_0
    //   2251: getfield 778	com/tencent/mobileqq/vaswebviewplugin/VasCommonJsPlugin:onPageFinishedTime	J
    //   2254: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2257: pop
    //   2258: aload_1
    //   2259: ldc_w 780
    //   2262: lload 6
    //   2264: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2267: pop
    //   2268: aload_1
    //   2269: ldc_w 782
    //   2272: iload 44
    //   2274: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2277: pop
    //   2278: aload_1
    //   2279: ldc_w 787
    //   2282: getstatic 791	com/tencent/biz/common/offline/HtmlOffline:c	I
    //   2285: invokevirtual 794	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2288: pop
    //   2289: aload_1
    //   2290: ldc_w 796
    //   2293: iload 45
    //   2295: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2298: pop
    //   2299: aload_1
    //   2300: ldc_w 798
    //   2303: getstatic 730	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:aD	Z
    //   2306: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2309: pop
    //   2310: aload_1
    //   2311: ldc_w 800
    //   2314: getstatic 803	com/tencent/mobileqq/webview/swift/component/SwiftBrowserStatistics:aE	Z
    //   2317: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2320: pop
    //   2321: aload_1
    //   2322: ldc_w 805
    //   2325: iload 42
    //   2327: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2330: pop
    //   2331: aload_1
    //   2332: ldc_w 807
    //   2335: lload 10
    //   2337: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2340: pop
    //   2341: aload_1
    //   2342: ldc_w 809
    //   2345: lload 12
    //   2347: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2350: pop
    //   2351: aload_1
    //   2352: ldc_w 811
    //   2355: lload 14
    //   2357: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2360: pop
    //   2361: aload_1
    //   2362: ldc_w 813
    //   2365: lload 16
    //   2367: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2370: pop
    //   2371: aload_1
    //   2372: ldc_w 815
    //   2375: lload 18
    //   2377: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2380: pop
    //   2381: aload_1
    //   2382: ldc_w 817
    //   2385: lload 20
    //   2387: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2390: pop
    //   2391: aload_1
    //   2392: ldc_w 819
    //   2395: lload 24
    //   2397: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2400: pop
    //   2401: aload_1
    //   2402: ldc_w 821
    //   2405: lload 22
    //   2407: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2410: pop
    //   2411: aload 49
    //   2413: ifnull +13 -> 2426
    //   2416: aload_1
    //   2417: ldc_w 823
    //   2420: aload 49
    //   2422: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2425: pop
    //   2426: aload_1
    //   2427: ldc_w 825
    //   2430: lload 26
    //   2432: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2435: pop
    //   2436: aload_1
    //   2437: ldc_w 826
    //   2440: iload 43
    //   2442: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2445: pop
    //   2446: new 128	java/lang/StringBuilder
    //   2449: dup
    //   2450: ldc_w 828
    //   2453: invokespecial 829	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2456: astore 49
    //   2458: new 128	java/lang/StringBuilder
    //   2461: dup
    //   2462: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2465: astore 50
    //   2467: aload 50
    //   2469: ldc_w 831
    //   2472: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2475: pop
    //   2476: aload 50
    //   2478: lload 4
    //   2480: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2483: pop
    //   2484: aload 49
    //   2486: aload 50
    //   2488: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2491: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2494: pop
    //   2495: new 128	java/lang/StringBuilder
    //   2498: dup
    //   2499: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2502: astore 50
    //   2504: aload 50
    //   2506: ldc_w 836
    //   2509: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2512: pop
    //   2513: aload 50
    //   2515: lload 6
    //   2517: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2520: pop
    //   2521: aload 49
    //   2523: aload 50
    //   2525: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2528: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: pop
    //   2532: new 128	java/lang/StringBuilder
    //   2535: dup
    //   2536: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2539: astore 50
    //   2541: aload 50
    //   2543: ldc_w 838
    //   2546: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2549: pop
    //   2550: aload 50
    //   2552: lload 8
    //   2554: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2557: pop
    //   2558: aload 49
    //   2560: aload 50
    //   2562: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2565: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2568: pop
    //   2569: new 128	java/lang/StringBuilder
    //   2572: dup
    //   2573: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2576: astore 50
    //   2578: aload 50
    //   2580: ldc_w 840
    //   2583: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2586: pop
    //   2587: aload 50
    //   2589: lload 6
    //   2591: lload 4
    //   2593: lsub
    //   2594: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2597: pop
    //   2598: aload 49
    //   2600: aload 50
    //   2602: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2605: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: pop
    //   2609: new 128	java/lang/StringBuilder
    //   2612: dup
    //   2613: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2616: astore 50
    //   2618: aload 50
    //   2620: ldc_w 842
    //   2623: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2626: pop
    //   2627: aload 50
    //   2629: lload 8
    //   2631: lload 6
    //   2633: lsub
    //   2634: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2637: pop
    //   2638: aload 49
    //   2640: aload 50
    //   2642: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2645: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2648: pop
    //   2649: aload 48
    //   2651: iconst_1
    //   2652: aload 49
    //   2654: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2657: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2660: lload 28
    //   2662: lconst_0
    //   2663: lcmp
    //   2664: ifle +13 -> 2677
    //   2667: aload_1
    //   2668: ldc_w 844
    //   2671: lload 28
    //   2673: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2676: pop
    //   2677: lload 30
    //   2679: lconst_0
    //   2680: lcmp
    //   2681: ifle +13 -> 2694
    //   2684: aload_1
    //   2685: ldc_w 846
    //   2688: lload 30
    //   2690: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2693: pop
    //   2694: lload 32
    //   2696: lconst_0
    //   2697: lcmp
    //   2698: ifle +13 -> 2711
    //   2701: aload_1
    //   2702: ldc_w 848
    //   2705: lload 32
    //   2707: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   2710: pop
    //   2711: aload_1
    //   2712: ldc_w 850
    //   2715: iload 46
    //   2717: invokevirtual 785	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   2720: pop
    //   2721: iload_3
    //   2722: ifle +33 -> 2755
    //   2725: aload_1
    //   2726: ldc_w 852
    //   2729: iload_3
    //   2730: invokevirtual 794	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2733: pop
    //   2734: iload 47
    //   2736: ifeq +8 -> 2744
    //   2739: iconst_2
    //   2740: istore_3
    //   2741: goto +5 -> 2746
    //   2744: iconst_1
    //   2745: istore_3
    //   2746: aload_1
    //   2747: ldc_w 854
    //   2750: iload_3
    //   2751: invokevirtual 794	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2754: pop
    //   2755: aload_2
    //   2756: ifnull +29 -> 2785
    //   2759: aload_2
    //   2760: invokevirtual 858	com/tencent/smtt/sdk/WebView:getX5WebViewExtension	()Lcom/tencent/smtt/export/external/extension/interfaces/IX5WebViewExtension;
    //   2763: ifnonnull +9 -> 2772
    //   2766: ldc 159
    //   2768: astore_2
    //   2769: goto +7 -> 2776
    //   2772: ldc_w 860
    //   2775: astore_2
    //   2776: aload_1
    //   2777: ldc_w 862
    //   2780: aload_2
    //   2781: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2784: pop
    //   2785: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2788: ifeq +187 -> 2975
    //   2791: new 128	java/lang/StringBuilder
    //   2794: dup
    //   2795: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2798: astore 48
    //   2800: ldc 58
    //   2802: astore_2
    //   2803: aload 48
    //   2805: ldc 58
    //   2807: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2810: pop
    //   2811: lload 32
    //   2813: lconst_0
    //   2814: lcmp
    //   2815: ifgt +9 -> 2824
    //   2818: ldc 58
    //   2820: astore_1
    //   2821: goto +34 -> 2855
    //   2824: new 128	java/lang/StringBuilder
    //   2827: dup
    //   2828: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2831: astore_1
    //   2832: aload_1
    //   2833: ldc_w 864
    //   2836: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: pop
    //   2840: aload_1
    //   2841: lload 32
    //   2843: lload 8
    //   2845: lsub
    //   2846: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2849: pop
    //   2850: aload_1
    //   2851: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2854: astore_1
    //   2855: aload 48
    //   2857: aload_1
    //   2858: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2861: pop
    //   2862: lload 28
    //   2864: lconst_0
    //   2865: lcmp
    //   2866: ifgt +9 -> 2875
    //   2869: ldc 58
    //   2871: astore_1
    //   2872: goto +34 -> 2906
    //   2875: new 128	java/lang/StringBuilder
    //   2878: dup
    //   2879: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2882: astore_1
    //   2883: aload_1
    //   2884: ldc_w 866
    //   2887: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2890: pop
    //   2891: aload_1
    //   2892: lload 28
    //   2894: lload 8
    //   2896: lsub
    //   2897: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2900: pop
    //   2901: aload_1
    //   2902: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2905: astore_1
    //   2906: aload 48
    //   2908: aload_1
    //   2909: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2912: pop
    //   2913: lload 30
    //   2915: lconst_0
    //   2916: lcmp
    //   2917: ifgt +8 -> 2925
    //   2920: aload_2
    //   2921: astore_1
    //   2922: goto +34 -> 2956
    //   2925: new 128	java/lang/StringBuilder
    //   2928: dup
    //   2929: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2932: astore_1
    //   2933: aload_1
    //   2934: ldc_w 868
    //   2937: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2940: pop
    //   2941: aload_1
    //   2942: lload 30
    //   2944: lload 8
    //   2946: lsub
    //   2947: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2950: pop
    //   2951: aload_1
    //   2952: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2955: astore_1
    //   2956: aload 48
    //   2958: aload_1
    //   2959: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2962: pop
    //   2963: ldc_w 870
    //   2966: iconst_2
    //   2967: aload 48
    //   2969: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2972: invokestatic 365	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2975: return
    //   2976: aconst_null
    //   2977: astore 48
    //   2979: goto -1965 -> 1014
    //   2982: aconst_null
    //   2983: astore 49
    //   2985: iconst_0
    //   2986: istore 43
    //   2988: goto -1822 -> 1166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2991	0	this	VasCommonJsPlugin
    //   0	2991	1	paramJSONObject	JSONObject
    //   0	2991	2	paramWebView	WebView
    //   2190	561	3	i	int
    //   227	2365	4	l1	long
    //   239	2393	6	l2	long
    //   251	2694	8	l3	long
    //   275	2061	10	l4	long
    //   287	2059	12	l5	long
    //   299	2057	14	l6	long
    //   179	2187	16	l7	long
    //   263	2113	18	l8	long
    //   311	2075	20	l9	long
    //   323	2083	22	l10	long
    //   391	2005	24	l11	long
    //   410	2021	26	l12	long
    //   426	2467	28	l13	long
    //   359	2584	30	l14	long
    //   347	2495	32	l15	long
    //   335	1712	34	l16	long
    //   387	1668	36	l17	long
    //   382	1657	38	l18	long
    //   1834	23	40	l19	long
    //   203	2123	42	bool1	boolean
    //   215	2772	43	bool2	boolean
    //   191	2082	44	bool3	boolean
    //   371	1923	45	bool4	boolean
    //   375	2341	46	bool5	boolean
    //   530	2205	47	bool6	boolean
    //   23	130	48	localObject1	Object
    //   451	1	48	localException1	Exception
    //   460	1	48	localException2	Exception
    //   474	1	48	localException3	Exception
    //   493	1	48	localException4	Exception
    //   599	1	48	localException5	Exception
    //   612	1	48	localException6	Exception
    //   629	1	48	localException7	Exception
    //   660	1	48	localException8	Exception
    //   688	1	48	localException9	Exception
    //   745	1	48	localException10	Exception
    //   750	1	48	localException11	Exception
    //   776	1	48	localException12	Exception
    //   785	1	48	localException13	Exception
    //   790	1	48	localException14	Exception
    //   795	1	48	localException15	Exception
    //   811	1	48	localException16	Exception
    //   989	167	48	localObject2	Object
    //   1205	1	48	localException17	Exception
    //   1313	1	48	localException18	Exception
    //   1417	1	48	localException19	Exception
    //   1459	1	48	localException20	Exception
    //   1491	52	48	localObject3	Object
    //   1553	1	48	localException21	Exception
    //   1558	1	48	localException22	Exception
    //   1583	1	48	localException23	Exception
    //   1588	1	48	localException24	Exception
    //   1593	1	48	localException25	Exception
    //   1598	1	48	localException26	Exception
    //   1611	1	48	localException27	Exception
    //   1616	1	48	localException28	Exception
    //   1621	1	48	localException29	Exception
    //   1626	1	48	localException30	Exception
    //   1631	1	48	localException31	Exception
    //   1645	1	48	localException32	Exception
    //   1650	1	48	localException33	Exception
    //   1655	1	48	localException34	Exception
    //   1715	1	48	localException35	Exception
    //   1720	1	48	localException36	Exception
    //   1830	1	48	str	String
    //   1899	91	48	localException37	Exception
    //   1996	982	48	localObject4	Object
    //   14	2970	49	localObject5	Object
    //   98	2543	50	localObject6	Object
    //   961	517	51	localSwiftBrowserStatistics	SwiftBrowserStatistics
    //   1024	28	52	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   361	373	451	java/lang/Exception
    //   349	361	460	java/lang/Exception
    //   337	349	474	java/lang/Exception
    //   325	337	493	java/lang/Exception
    //   313	325	599	java/lang/Exception
    //   301	313	612	java/lang/Exception
    //   289	301	629	java/lang/Exception
    //   277	289	660	java/lang/Exception
    //   265	277	688	java/lang/Exception
    //   253	265	745	java/lang/Exception
    //   241	253	750	java/lang/Exception
    //   229	241	776	java/lang/Exception
    //   217	229	785	java/lang/Exception
    //   205	217	790	java/lang/Exception
    //   193	205	795	java/lang/Exception
    //   181	193	811	java/lang/Exception
    //   1187	1194	1205	java/lang/Exception
    //   1303	1310	1313	java/lang/Exception
    //   1403	1410	1417	java/lang/Exception
    //   1441	1448	1459	java/lang/Exception
    //   1539	1547	1553	java/lang/Exception
    //   1484	1535	1558	java/lang/Exception
    //   1477	1484	1583	java/lang/Exception
    //   1470	1477	1588	java/lang/Exception
    //   1429	1436	1593	java/lang/Exception
    //   1291	1298	1598	java/lang/Exception
    //   1284	1291	1611	java/lang/Exception
    //   1277	1284	1616	java/lang/Exception
    //   1270	1277	1621	java/lang/Exception
    //   1259	1266	1626	java/lang/Exception
    //   1248	1255	1631	java/lang/Exception
    //   1237	1244	1645	java/lang/Exception
    //   1230	1237	1650	java/lang/Exception
    //   1223	1230	1655	java/lang/Exception
    //   1216	1223	1715	java/lang/Exception
    //   1096	1102	1720	java/lang/Exception
    //   1106	1115	1720	java/lang/Exception
    //   1119	1128	1720	java/lang/Exception
    //   1132	1140	1720	java/lang/Exception
    //   1144	1155	1720	java/lang/Exception
    //   1175	1182	1720	java/lang/Exception
    //   161	181	1899	java/lang/Exception
    //   939	991	1899	java/lang/Exception
    //   996	1011	1899	java/lang/Exception
    //   1014	1026	1899	java/lang/Exception
    //   1035	1042	1899	java/lang/Exception
    //   1051	1058	1899	java/lang/Exception
    //   1063	1070	1899	java/lang/Exception
  }
  
  private void getPerformanceFromX5(JSONObject paramJSONObject)
  {
    Object localObject = this.mRuntime.a(this.mRuntime.d());
    if (localObject != null) {}
    for (;;)
    {
      long l5;
      long l6;
      long l4;
      try
      {
        if ((localObject instanceof WebUiUtils.WebviewReportSpeedInterface))
        {
          localObject = ((WebUiUtils.WebviewReportSpeedInterface)localObject).getX5Performance();
        }
        else
        {
          if (!(this.mRuntime.d() instanceof SwiftWebViewFragmentSupporter)) {
            break label435;
          }
          localObject = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
          if (localObject == null) {
            break label435;
          }
          localObject = ((SwiftBrowserStatistics)localObject).aI;
        }
        if (localObject != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("report X5 performance: ");
            localStringBuilder.append(localObject);
            QLog.i("VasCommonJsPlugin", 2, localStringBuilder.toString());
          }
          l5 = ((JSONObject)localObject).optLong("first_screen");
          l1 = ((JSONObject)localObject).optLong("dns_start");
          l2 = ((JSONObject)localObject).optLong("dns_end") - l1;
          if (l2 < 0L) {
            break label441;
          }
          l1 = ((JSONObject)localObject).optLong("send_start");
          l3 = ((JSONObject)localObject).optLong("connect_start");
          l3 = ((JSONObject)localObject).optLong("connect_end") - l3;
          if (l3 < 0L) {
            break label447;
          }
          l6 = ((JSONObject)localObject).optLong("recv_start");
          l4 = ((JSONObject)localObject).optLong("recv_end");
          if (l1 != 0L) {
            break label453;
          }
          l1 = l4 - l6;
          break label458;
          l4 = ((JSONObject)localObject).optLong("ssl_handshake_end") - ((JSONObject)localObject).optLong("ssl_handshake_start");
          if (l4 < 0L) {
            break label472;
          }
          break label475;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Web_X5_Load_Index, DNS cost: ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", ssl_handshake cost: ");
          ((StringBuilder)localObject).append(l4);
          ((StringBuilder)localObject).append(", Connect cost: ");
          ((StringBuilder)localObject).append(l3);
          ((StringBuilder)localObject).append(", receive Cost: ");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(", website Render Cost: ");
          ((StringBuilder)localObject).append(l5);
          QLog.i("Web_X5_Performance", 1, ((StringBuilder)localObject).toString());
          paramJSONObject.put("X5_dns", l2);
          paramJSONObject.put("X5_sslHandeShake", l4);
          paramJSONObject.put("X5_connect", l3);
          paramJSONObject.put("X5_receive", l1);
          paramJSONObject.put("X5_websiteRender", l5);
        }
        return;
      }
      catch (Exception paramJSONObject)
      {
        return;
      }
      label435:
      localObject = null;
      continue;
      label441:
      long l2 = 0L;
      continue;
      label447:
      long l3 = 0L;
      continue;
      label453:
      long l1 = l4 - l1;
      label458:
      if (l1 < 0L)
      {
        l1 = 0L;
        continue;
        label472:
        l4 = 0L;
        label475:
        l5 -= l6;
        if (l5 < 0L) {
          l5 = 0L;
        }
      }
    }
  }
  
  private static void processWebLog(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append("ANDROID");
    localStringBuilder.append("|");
    localStringBuilder.append("8.8.17.5770");
    localStringBuilder.append("|");
    localStringBuilder.append(DeviceInfoUtil.g());
    localStringBuilder.append("|");
    localStringBuilder.append(MobileQQ.getShortUinStr(paramAppInterface.getCurrentAccountUin()));
    localStringBuilder.append("|");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    boolean bool = TextUtils.isEmpty(DeviceInfoUtil.f(paramActivity).c);
    paramString1 = "未知";
    if (bool) {
      paramAppInterface = "未知";
    } else {
      paramAppInterface = DeviceInfoUtil.f(paramActivity).c;
    }
    localStringBuilder.append(paramAppInterface);
    localStringBuilder.append("|");
    if (TextUtils.isEmpty(DeviceInfoUtil.f(paramActivity).a)) {
      paramAppInterface = paramString1;
    } else {
      paramAppInterface = DeviceInfoUtil.f(paramActivity).a;
    }
    localStringBuilder.append(paramAppInterface);
    if (paramBoolean)
    {
      QLog.w("WebLog", 1, localStringBuilder.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("WebLog", 2, localStringBuilder.toString());
    }
  }
  
  private JSONObject prosBLCallback(Bundle paramBundle, JSONObject paramJSONObject)
  {
    if ((1 == this.businessType) && (this.logicMethod.equals("getFriendInfo"))) {}
    try
    {
      paramJSONObject.put("dialog_input_callback", paramBundle.getString("emsg"));
      return paramJSONObject;
    }
    catch (JSONException paramBundle) {}
    return paramJSONObject;
  }
  
  public static void webLog(AppInterface paramAppInterface, Activity paramActivity, JSONObject paramJSONObject)
  {
    try
    {
      processWebLog(paramAppInterface, paramActivity, paramJSONObject.getString("id"), paramJSONObject.getString("subid"), paramJSONObject.getString("content"), paramJSONObject.getBoolean("isall"));
      return;
    }
    catch (JSONException|Exception paramAppInterface) {}
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
    catch (Exception localException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception:");
      localStringBuilder.append(localException.getMessage());
      paramJsBridgeListener.a(localStringBuilder.toString());
      localException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSONException:");
      localStringBuilder.append(localJSONException.getMessage());
      paramJsBridgeListener.a(localStringBuilder.toString());
      localJSONException.printStackTrace();
    }
  }
  
  public void doChooseFriendResultForH5(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
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
            boolean bool = TextUtils.isEmpty((CharSequence)paramList1.get(i));
            String str4 = "";
            if (bool) {
              break label322;
            }
            str1 = (String)paramList1.get(i);
            if (TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
              break label329;
            }
            str2 = (String)paramList2.get(i);
            if (TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              break label336;
            }
            str3 = (String)paramList3.get(i);
            if (!TextUtils.isEmpty((CharSequence)paramList4.get(i))) {
              str4 = (String)paramList4.get(i);
            }
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
      label322:
      String str1 = "";
      continue;
      label329:
      String str2 = "";
      continue;
      label336:
      String str3 = "";
    }
  }
  
  public String getCurrentNetwork()
  {
    try
    {
      i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    }
    catch (Exception localException)
    {
      int i;
      label13:
      break label13;
    }
    i = 0;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return "";
          }
          return "4G";
        }
        return "3G";
      }
      return "2G";
    }
    return "wifi";
  }
  
  public void getDensity(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      AppInterface localAppInterface = this.mRuntime.b();
      if (localAppInterface != null)
      {
        localJSONObject.put("density", ThemeUtil.getThemeDensity(localAppInterface.getApplication()));
        localJSONObject.put("result", 0);
      }
      else
      {
        localJSONObject.put("result", -1);
      }
      super.callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      super.callJs(paramString, new String[] { localJSONException.getMessage() });
      localJSONException.printStackTrace();
    }
  }
  
  protected JSONObject getJsBackJson(Intent paramIntent, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<Integer> paramList4, List<String> paramList5, List<String> paramList6, List<Integer> paramList7, List<Integer> paramList8)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
        {
          i = 0;
          localObject2 = paramList3;
          localObject1 = paramList2;
          paramIntent = paramList1;
          if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
          {
            if (TextUtils.isEmpty((CharSequence)paramIntent.get(i))) {
              break label622;
            }
            paramIntent = (String)paramIntent.get(i);
            if (TextUtils.isEmpty((CharSequence)((List)localObject1).get(i))) {
              break label628;
            }
            localObject1 = (String)((List)localObject1).get(i);
            if (TextUtils.isEmpty((CharSequence)((List)localObject2).get(i))) {
              break label635;
            }
            localObject2 = (String)((List)localObject2).get(i);
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uin", paramIntent);
            localJSONObject2.put("phone", localObject1);
            localJSONObject2.put("name", localObject2);
            if ((paramList4 != null) && (paramList4.size() > i)) {
              localJSONObject2.put("type", paramList4.get(i));
            } else {
              localJSONObject2.put("type", 1);
            }
            localJSONArray.put(localJSONObject2);
            i += 1;
            continue;
          }
        }
        if ((paramList5 == null) || (paramList6 == null) || (paramList7 == null) || (paramList8 == null)) {
          break label688;
        }
        paramList2 = new JSONArray();
        i = 0;
        paramList1 = paramList5;
        paramIntent = paramList2;
        if (i < paramList5.size())
        {
          paramIntent = paramList2;
          if (i < paramList6.size())
          {
            paramIntent = paramList2;
            if (i < paramList7.size())
            {
              paramIntent = paramList2;
              if (i < paramList8.size())
              {
                if (TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
                  break label642;
                }
                paramIntent = (String)paramList1.get(i);
                if (TextUtils.isEmpty((CharSequence)paramList6.get(i))) {
                  break label648;
                }
                paramList1 = (String)paramList6.get(i);
                if (paramList7.get(i) == null) {
                  break label654;
                }
                j = ((Integer)paramList7.get(i)).intValue();
                if (paramList8.get(i) == null) {
                  break label660;
                }
                k = ((Integer)paramList8.get(i)).intValue();
                break label663;
                paramList3 = new JSONObject();
                paramList3.put("uin", paramIntent);
                paramList3.put("name", paramList1);
                paramList3.put("type", k);
                paramList3.put("count", j);
                paramList2.put(paramList3);
                break label679;
              }
            }
          }
        }
        localJSONObject1.put("friends", localJSONArray);
        if ((paramIntent != null) && (paramIntent.length() > 0)) {
          localJSONObject1.put("groups", paramIntent);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasCommonJsPlugin", 2, localJSONObject1.toString());
        }
        return localJSONObject1;
      }
      catch (JSONException paramIntent)
      {
        paramIntent.printStackTrace();
        return null;
      }
      label622:
      paramIntent = "";
      continue;
      label628:
      Object localObject1 = "";
      continue;
      label635:
      Object localObject2 = "";
      continue;
      label642:
      paramIntent = "";
      continue;
      label648:
      paramList1 = "";
      continue;
      label654:
      int j = 0;
      continue;
      label660:
      int k = 0;
      label663:
      if ((k != 4) && (k != 8))
      {
        label679:
        i += 1;
        continue;
        label688:
        paramIntent = null;
      }
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "qw_debug", "qw_data", "friendData" };
  }
  
  public void getNickName(JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNickName ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.i("VasCommonJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new ArrayList();
      paramJSONObject = paramJSONObject.getJSONArray("uins");
      int j = paramJSONObject.length();
      int i = 0;
      while (i < j)
      {
        ((ArrayList)localObject).add(paramJSONObject.getString(i));
        i += 1;
      }
      this.mReqBundle.clear();
      this.mReqBundle.putStringArrayList("uins", (ArrayList)localObject);
      paramJSONObject = DataFactory.a("getNickName", paramString, this.mOnRemoteResp.key, this.mReqBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createShortcut failed: ");
        ((StringBuilder)localObject).append(paramJSONObject.getMessage());
        QLog.e("VasCommonJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      super.callJsOnError(paramString, paramJSONObject.getMessage());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = TextUtils.isEmpty(paramString2);
    boolean bool1 = false;
    if (!bool2)
    {
      if ((!paramString2.startsWith("qw_debug")) && (!paramString2.startsWith("qw_data")) && (!paramString2.startsWith("friendData"))) {
        return false;
      }
      if (TextUtils.isEmpty(paramString3))
      {
        paramJsBridgeListener.a("method empty");
        return true;
      }
      this.logicMethod = paramString3;
      try
      {
        bool2 = "log".equals(paramString3);
        if (bool2)
        {
          if ((!this.logStop) && (this.logShowTag))
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            this.logInfo.add(paramString1.getString("msg"));
            if ((this.deBugDialog != null) && (this.deBugDialog.isShowing()))
            {
              this.deBugDialog.log(this.logInfo);
              return true;
            }
          }
        }
        else
        {
          bool2 = "show".equals(paramString3);
          if (bool2)
          {
            if (this.logStop)
            {
              paramJsBridgeListener.a("erro:please start log first");
              return true;
            }
            if (this.deBugDialog == null) {
              this.deBugDialog = new VasCommonJsPlugin.JsDebugDialog(this, this.mRuntime.d());
            }
            if (new JSONObject(paramVarArgs[0]).getBoolean("flag")) {
              this.logShowTag = true;
            } else {
              this.logShowTag = false;
            }
            this.deBugDialog.show();
            this.deBugDialog.log(this.logInfo);
            return true;
          }
          if ("hide".equals(paramString3))
          {
            if (this.deBugDialog != null) {
              this.deBugDialog.dismiss();
            }
            if (new JSONObject(paramVarArgs[0]).getBoolean("flag"))
            {
              this.logShowTag = true;
              return true;
            }
            this.logShowTag = false;
            return true;
          }
          if ("start".equals(paramString3))
          {
            this.logStop = false;
            return true;
          }
          if ("stop".equals(paramString3))
          {
            this.logStop = true;
            this.logInfo.clear();
            if (this.deBugDialog != null)
            {
              this.deBugDialog.log(this.logInfo);
              return true;
            }
          }
          else if ("qlog".equals(paramString3))
          {
            if (QLog.isColorLevel())
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              if (paramString1.has("msg"))
              {
                QLog.d("WebQlog", 2, paramString1.getString("msg"));
                return true;
              }
            }
          }
          else
          {
            if ("getPerformance".equals(paramString3))
            {
              if ((paramVarArgs != null) && (paramVarArgs.length > 0))
              {
                paramString1 = new JSONObject(paramVarArgs[0]).optString("pageId", "");
                paramString2 = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
                if (paramString2 != null) {
                  paramString2.g = paramString1;
                }
                VasBaseWebviewUtil.reportX5SpeedData(paramString2);
              }
              commitPerformanceToWebsite(paramJsBridgeListener);
              return true;
            }
            bool2 = "getVipType".equals(paramString3);
            if (bool2)
            {
              paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
              if (paramString1 == null) {
                return true;
              }
              if (QLog.isColorLevel())
              {
                paramString2 = new StringBuilder();
                paramString2.append("handleJsRequest JSON = ");
                paramString2.append(paramString1.toString());
                QLog.d("VasCommonJsPlugin", 2, paramString2.toString());
              }
              getVipType(paramString1, paramString1.optString("callback"));
              return true;
            }
            if ("startIpcService".equals(paramString3))
            {
              if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
              {
                ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.mRuntime.d().getApplicationContext());
                return true;
              }
            }
            else
            {
              if ("stopIpcService".equals(paramString3))
              {
                ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(this.mRuntime.d().getApplicationContext());
                return true;
              }
              if ("isIpcStarted".equals(paramString3))
              {
                paramString1 = new JSONObject();
                paramString1.put("isIpcStarted", ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded());
                paramJsBridgeListener.a(paramString1);
                return true;
              }
              if ("getFriendInfo".equals(paramString3))
              {
                if (paramVarArgs.length <= 0)
                {
                  chooseFriends(null);
                  return true;
                }
                chooseFriends(paramVarArgs[0]);
                return true;
              }
              if ("getFriendRemark".equals(paramString3))
              {
                paramString1 = new JSONObject(paramVarArgs[0]);
                getNickName(paramString1, paramString1.getString("callback"));
                return true;
              }
              if ("getDomainIpList".equals(paramString3))
              {
                paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
                if (paramString1 == null) {
                  return true;
                }
                if (QLog.isColorLevel())
                {
                  paramString2 = new StringBuilder();
                  paramString2.append("handleJsRequest JSON = ");
                  paramString2.append(paramString1.toString());
                  QLog.d("VasCommonJsPlugin", 2, paramString2.toString());
                }
                super.getDomainIpList(paramString1, paramString1.optString("callback"));
                return true;
              }
              if ("getDensity".equals(paramString3))
              {
                paramString1 = WebViewPlugin.getJsonFromJSBridge(paramString1);
                if (paramString1 == null) {
                  return true;
                }
                if (QLog.isColorLevel())
                {
                  paramString2 = new StringBuilder();
                  paramString2.append("handleJsRequest JSON = ");
                  paramString2.append(paramString1.toString());
                  QLog.d("VasCommonJsPlugin", 2, paramString2.toString());
                }
                getDensity(paramString1.optString("callback"));
                return true;
              }
              if ("detailLog".equals(paramString3))
              {
                paramString1 = new JSONObject(paramVarArgs[0]);
                webLog(this.mRuntime.b(), this.mRuntime.d(), paramString1);
                return true;
              }
              if ("selectedFriendInfo".equals(paramString3))
              {
                if (paramVarArgs.length <= 0)
                {
                  H5chooseFriends(null);
                  return true;
                }
                H5chooseFriends(paramVarArgs[0]);
                return true;
              }
              if ("setCurrentActivityShakeFlag".equals(paramString3))
              {
                if ((!TextUtils.isEmpty(paramVarArgs[0])) && (paramVarArgs[0].contains("flag")))
                {
                  paramString1 = this.mRuntime.d();
                  if ((paramString1 != null) && (!this.isDestroy) && (!paramString1.isFinishing()))
                  {
                    int i = new JSONObject(paramVarArgs[0]).optInt("flag");
                    if ((paramString1 instanceof QBaseActivity))
                    {
                      paramString1 = (QBaseActivity)paramString1;
                      if (i > 0) {
                        bool1 = true;
                      }
                      paramString1.mCurrentActivityShakeFlag = bool1;
                    }
                    if (QLog.isColorLevel())
                    {
                      paramString1 = new StringBuilder();
                      paramString1.append("setCurrentActivityShakeFlag:");
                      paramString1.append(i);
                      QLog.d("VasCommonJsPlugin", 2, paramString1.toString());
                      return true;
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
                  bool1 = paramString2 instanceof CustomWebChromeClient;
                  if (bool1)
                  {
                    ((CustomWebChromeClient)paramString2).b = true;
                    paramString3.put("code", 0);
                  }
                  else
                  {
                    paramString3.put("code", 1);
                  }
                  super.callJs(paramString1.optString("callback"), new String[] { paramString3.toString() });
                  return true;
                }
                paramJsBridgeListener.a("no such method");
                return false;
              }
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("Exception:");
        paramString2.append(paramString1.getMessage());
        paramJsBridgeListener.a(paramString2.toString());
      }
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult requestCode = ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(" resultCode = ");
      localStringBuilder.append(paramInt);
      QLog.i("VasCommonJsPlugin", 2, localStringBuilder.toString());
    }
    if (paramInt == -1)
    {
      if (paramByte == 17) {
        backH5Friends(paramIntent);
      }
    }
    else if (paramByte == 17) {
      errorCallBack();
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key))
    {
      Object localObject2 = paramBundle.getString("cmd");
      String str = paramBundle.getString("callbackid");
      Object localObject1 = paramBundle.getBundle("response");
      if (localObject1 == null)
      {
        QLog.e("VasCommonJsPlugin", 1, "onResponse respbundle = null");
        return;
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("response:");
        paramBundle.append((String)localObject2);
        QLog.i("VasCommonJsPlugin", 2, paramBundle.toString());
      }
      if ((localObject2 != null) && ("getNickName".equals(localObject2)))
      {
        paramBundle = new JSONObject();
        localObject2 = new JSONObject();
        try
        {
          if (((Bundle)localObject1).containsKey("friendsMap"))
          {
            localObject1 = ((HashMap)((Bundle)localObject1).getSerializable("friendsMap")).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
              ((JSONObject)localObject2).put((String)localEntry.getKey(), localEntry.getValue());
            }
            paramBundle.put("remarks", localObject2);
          }
        }
        catch (Throwable localThrowable)
        {
          super.callJsOnError(str, localThrowable.getMessage());
        }
        doCallback(str, paramBundle.toString());
      }
    }
  }
  
  public void setUiInterface(WebUiBaseInterface paramWebUiBaseInterface)
  {
    this.uiInterface = paramWebUiBaseInterface;
  }
  
  public void showMsgBox(JSONObject paramJSONObject, JsBridgeListener paramJsBridgeListener)
  {
    try
    {
      localObject = paramJSONObject.getString("prompt");
      String str = paramJSONObject.getString("title");
      paramJSONObject = paramJSONObject.getString("button");
      String[] arrayOfString = paramJSONObject.split("\t");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CommonJsHandler showMsgBox prompt=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",title=");
        localStringBuilder.append(str);
        localStringBuilder.append(",button=");
        localStringBuilder.append(paramJSONObject);
        QLog.i("VasCommonJsPlugin", 2, localStringBuilder.toString());
      }
      if (arrayOfString.length >= 1)
      {
        paramJSONObject = DialogUtil.c(this.mRuntime.d(), 230);
        paramJSONObject.a(str);
        paramJSONObject.b((String)localObject);
        paramJSONObject.a(arrayOfString[0], new VasCommonJsPlugin.1(this, paramJsBridgeListener));
        if (arrayOfString.length >= 2) {
          paramJSONObject.b(arrayOfString[1], new VasCommonJsPlugin.2(this, paramJsBridgeListener));
        }
        if (arrayOfString.length >= 3) {
          paramJSONObject.c(arrayOfString[2], new VasCommonJsPlugin.3(this, paramJsBridgeListener));
        }
        paramJSONObject.setCanceledOnTouchOutside(false);
        paramJSONObject.setOnKeyListener(new VasCommonJsPlugin.4(this, paramJSONObject, paramJsBridgeListener));
        paramJSONObject.show();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not find buttons");
      ((StringBuilder)localObject).append(paramJSONObject);
      paramJsBridgeListener.a(((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Exception:");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      paramJsBridgeListener.a(((StringBuilder)localObject).toString());
      paramJSONObject.printStackTrace();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSONException params error:");
      ((StringBuilder)localObject).append(paramJSONObject.getMessage());
      paramJsBridgeListener.a(((StringBuilder)localObject).toString());
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */