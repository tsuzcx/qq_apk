package com.tencent.mobileqq.vaswebviewplugin;

import aiwa;
import aiwf;
import ajjy;
import anad;
import anah;
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
import anfc;
import babp;
import babq;
import babr;
import badq;
import bafp;
import bayu;
import bazk;
import bazo;
import bbac;
import bbca;
import bbew;
import bbex;
import bfoc;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicSessionStatistics;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mof;
import mzd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xce;

public class VasCommonJsPlugin
  extends VasWebviewJsPlugin
  implements bayu
{
  public static final String H5_CALLBACK_GETFRIENDINFO = "getFriendInfo";
  private static final String LOG_TAG_WEB = "WebQlog";
  public static final String PLUGIN_NAMESPACE_FRIEND_DATA = "friendData";
  public static final String PLUGIN_NAMESPACE_QW_DATA = "qw_data";
  public static final String PLUGIN_NAMESPACE_QW_DEBUG = "qw_debug";
  private static final String TAG = "VasCommonJsPlugin";
  private final byte REQUEST_CODE_FRIENDS = 17;
  private int businessSubType;
  private int businessType;
  private VasCommonJsPlugin.JsDebugDialog deBugDialog;
  private List<String> logInfo = Collections.synchronizedList(new ArrayList());
  private boolean logShowTag = true;
  private boolean logStop;
  private String logicMethod = "";
  protected String mCallback;
  protected VasCommonJsPlugin.ChooseFriendReceiver mChoFriReceiver;
  protected VasCommonJsPlugin.ChooseH5PTVReceiver mH5PTVReceiver;
  private Bundle mReqBundle = new Bundle();
  private bazo uiInterface;
  
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
      paramString = ((JSONObject)localObject2).optString("title", ajjy.a(2131650244));
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
          break label199;
        }
      }
      label199:
      for (bool2 = false;; bool2 = true)
      {
        if (this.mH5PTVReceiver == null) {
          this.mH5PTVReceiver = new VasCommonJsPlugin.ChooseH5PTVReceiver(this, new Handler());
        }
        if (!bool3) {
          break label278;
        }
        if (j >= 1) {
          break label219;
        }
        errorCallBack();
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
    label219:
    paramString.putExtra("param_donot_need_contacts", true);
    paramString.putExtra("param_min", 1);
    paramString.putExtra("param_max", j);
    paramString.putExtra("param_only_friends", true);
    paramString.addFlags(67108864);
    super.startActivityForResult(paramString, (byte)17);
    return;
    label278:
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
    super.startActivityForResult((Intent)localObject1, (byte)17);
  }
  
  private void backH5Friends(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      try
      {
        localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
        if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
        {
          errorCallBack();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        errorCallBack();
        return;
      }
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
      Object localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
        ((List)localObject1).add(localResultRecord.a);
        ((List)localObject2).add("");
        localArrayList5.add(localResultRecord.jdField_b_of_type_JavaLangString);
        localArrayList6.add(Integer.valueOf(i));
      }
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, "doChooseFriendResult...");
      }
      paramIntent = getJsBackJson(paramIntent, (List)localObject1, (List)localObject2, localArrayList5, localArrayList6, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
      QLog.i("VasCommonJsPlugin", 2, "doChooseFriendResult: " + paramIntent);
    } while (paramIntent == null);
    doCallback(this.mCallback, paramIntent.toString());
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
      errorCallBack();
      return;
    }
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      int i1;
      boolean bool5;
      int i7;
      boolean bool1;
      try
      {
        paramString = new JSONObject(paramString);
        str1 = paramString.optString("title", ajjy.a(2131650245));
        str2 = paramString.optString("dialog_sub_title", "");
        str3 = paramString.optString("dialog_input", "");
        i1 = paramString.optInt("type", 0);
        this.mCallback = paramString.optString("callback");
        bool5 = Boolean.valueOf(paramString.optString("isMulti", "false")).booleanValue();
        i7 = Integer.valueOf(paramString.optString("limitNum", "0")).intValue();
        if ((i1 & 0x1) == 0)
        {
          bool1 = false;
          break label965;
          this.businessType = paramString.optInt("business_type", 0);
          this.businessSubType = paramString.optInt("business_sub_type", 0);
          Object localObject2 = paramString.optJSONObject("from_group");
          paramString = (String)localObject1;
          if (localObject2 == null) {
            break label396;
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
            break label396;
          }
          i1 = 0;
          i = i6;
          j = i5;
          m = i4;
          n = i3;
          k = i2;
          paramString = (String)localObject1;
          if (i1 >= ((JSONArray)localObject2).length()) {
            break label396;
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
        errorCallBack();
        return;
      }
      boolean bool2 = true;
      break label975;
      boolean bool3 = true;
      break label986;
      boolean bool4 = true;
      continue;
      label396:
      if (bool5)
      {
        if (i7 < 1)
        {
          errorCallBack();
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
              break label647;
            }
            bool1 = true;
            label548:
            ((Intent)localObject1).putExtra("param_show_myself", bool1);
            if (j == 0) {
              break label653;
            }
            bool1 = true;
            label566:
            ((Intent)localObject1).putExtra("is_put_myself_first", bool1);
            if (i == 0) {
              break label659;
            }
          }
          label653:
          label659:
          for (bool1 = true;; bool1 = false)
          {
            ((Intent)localObject1).putExtra("is_forbid_only_choose_myself", bool1);
            if (localArrayList.size() <= 0) {
              break label676;
            }
            if (localArrayList.size() <= i7) {
              break label665;
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
            break label548;
            bool1 = false;
            break label566;
          }
          label665:
          ((Intent)localObject1).putExtra("param_uins_selected_friends", localArrayList);
          label676:
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
      label647:
      if (this.mChoFriReceiver == null) {
        this.mChoFriReceiver = new VasCommonJsPlugin.ChooseFriendReceiver(this, new Handler());
      }
      localObject1 = Parcel.obtain();
      this.mChoFriReceiver.writeToParcel((Parcel)localObject1, 0);
      ((Parcel)localObject1).setDataPosition(0);
      paramString = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel((Parcel)localObject1);
      ((Parcel)localObject1).recycle();
      localObject1 = new Intent(localContext, ForwardRecentActivity.class);
      ((Intent)localObject1).putExtra("forward_type", 15);
      ((Intent)localObject1).putExtra("choose_friend_title", str1);
      ((Intent)localObject1).putExtra("choose_friend_dialog_sub_title", str2);
      ((Intent)localObject1).putExtra("choose_friend_dialog_input", str3);
      ((Intent)localObject1).putExtra("choose_friend_is_qqfriends", bool1);
      ((Intent)localObject1).putExtra("choose_friend_is_contacts", bool2);
      ((Intent)localObject1).putExtra("choose_friend_is_groupchats", bool3);
      ((Intent)localObject1).putExtra("choose_friend_is_create_group_chat", bool4);
      ((Intent)localObject1).putExtra("choose_friend_callback", paramString);
      ((Intent)localObject1).putExtra("choose_friend_businessType", this.businessType);
      ((Intent)localObject1).putExtra("choose_friend_businessSubType", this.businessSubType);
      super.startActivityForResult((Intent)localObject1, (byte)0);
      return;
      label965:
      if ((i1 & 0x2) == 0)
      {
        bool2 = false;
        label975:
        if ((i1 & 0xC) == 0)
        {
          bool3 = false;
          label986:
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
    QLog.i("VasCommonJsPlugin", 2, "doCallback: " + paramString1 + " js: " + paramString2);
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
      QLog.i("VasCommonJsPlugin", 2, "errorCallBack: " + localJSONObject);
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
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void getPerformance(JSONObject paramJSONObject, WebView paramWebView)
  {
    boolean bool3 = false;
    long l1 = -1L;
    long l3 = -1L;
    long l33 = -1L;
    long l32 = -1L;
    long l31 = -1L;
    long l30 = -1L;
    long l29 = -1L;
    long l28 = -1L;
    long l27 = -1L;
    long l15 = -1L;
    long l34 = -1L;
    boolean bool7 = false;
    boolean bool2 = false;
    boolean bool6 = false;
    long l35 = 0L;
    long l26 = -1L;
    long l25 = -1L;
    long l24 = -1L;
    Object localObject1 = this.mRuntime.a(this.mRuntime.a());
    QLog.i("VasCommonJsPlugin", 2, "baseInterface = " + localObject1);
    Object localObject4;
    if ((localObject1 == null) && ((this.mRuntime.a() instanceof bfoc)))
    {
      QLog.i("VasCommonJsPlugin", 2, "start check if plugin has WebviewReportSpeedInterface interface...");
      localObject4 = (bfoc)this.mRuntime.a();
      if ((((bfoc)localObject4).a() instanceof bazo))
      {
        QLog.i("VasCommonJsPlugin", 2, "plugin has interface for getPerformance...");
        localObject1 = (bazo)((bfoc)localObject4).a();
      }
    }
    for (;;)
    {
      if (this.uiInterface != null) {}
      boolean bool4;
      long l2;
      boolean bool5;
      boolean bool1;
      long l11;
      long l13;
      long l12;
      long l10;
      long l9;
      long l8;
      long l7;
      long l6;
      long l5;
      long l4;
      long l14;
      long l16;
      long l17;
      long l18;
      long l19;
      long l20;
      long l21;
      long l22;
      long l23;
      label1166:
      Object localObject5;
      label1468:
      int i;
      label1502:
      label2419:
      Object localObject3;
      for (localObject4 = this.uiInterface;; localObject4 = localObject3)
      {
        if (localObject4 != null)
        {
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
        }
        try
        {
          if ((localObject4 instanceof bbex))
          {
            bool4 = bool7;
            l2 = l1;
            bool5 = bool3;
            l1 = ((bbex)localObject4).getmOnCreateMilliTimeStamp();
            bool4 = bool7;
            l2 = l1;
            bool5 = bool3;
            bool1 = ((bbex)localObject4).isMainPageUseLocalFile();
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Object localObject6;
            Object localObject7;
            bool1 = false;
            l1 = -1L;
            l16 = -1L;
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
            l14 = -1L;
            bool4 = true;
            l15 = l2;
            l2 = l16;
            localException1.printStackTrace();
            l16 = l6;
            l17 = l9;
            continue;
            localObject2 = localObject5;
            if (this.mRuntime.a() != null)
            {
              localObject6 = this.mRuntime.a().getPluginEngine().a("apollo");
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
                    localObject2 = ((aiwa)localObject6).a();
                    continue;
                    i = 1;
                    continue;
                    paramWebView = "1";
                    continue;
                    paramJSONObject = ", redirect 302 cost: " + (l1 - l6);
                    continue;
                    paramJSONObject = ", check offline res cost: " + (l3 - l6);
                    continue;
                    paramJSONObject = ", read index cost: " + (l2 - l6);
                  }
                }
              }
            }
          }
        }
        try
        {
          bool2 = ((bbex)localObject4).getmPerfFirstLoadTag();
        }
        catch (Exception localException2)
        {
          bool6 = false;
          l16 = -1L;
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
          l14 = -1L;
          l15 = l1;
          bool4 = true;
          bool5 = bool1;
          bool1 = bool6;
          l1 = l16;
          continue;
        }
        try
        {
          bool3 = ((bbex)localObject4).getisWebViewCache();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
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
          l16 = -1L;
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
          l14 = -1L;
          l15 = l1;
          bool4 = bool2;
          bool5 = bool1;
          bool1 = bool7;
          l1 = l16;
          bool2 = bool6;
          continue;
        }
        try
        {
          l14 = ((bbex)localObject4).getmClickTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l29;
          l6 = l30;
          l5 = l31;
          l4 = l32;
          l2 = l33;
          l3 = l14;
          l16 = ((bbex)localObject4).getmTimeBeforeLoadUrl();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l29;
          l6 = l30;
          l5 = l31;
          l4 = l32;
          l2 = l16;
          l3 = l14;
          l17 = ((bbex)localObject4).getonCreateTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l29;
          l6 = l30;
          l5 = l31;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l18 = ((bbex)localObject4).getviewInflateTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l29;
          l6 = l30;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l19 = ((bbex)localObject4).getgetWebViewTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l29;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l20 = ((bbex)localObject4).getinitBrowserTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l28;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l21 = ((bbex)localObject4).getinitTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l27;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l22 = ((bbex)localObject4).getinitTBSTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l22;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l15 = ((bbex)localObject4).getpluginFinished();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l22;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l26 = ((bbex)localObject4).getOpenUrlAfterCheckOfflineTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l22;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l25 = ((bbex)localObject4).getReadIndexFromOfflineTime();
          l11 = l24;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l22;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          l23 = ((bbex)localObject4).getDetect302Time();
          l11 = l23;
          l13 = l25;
          l12 = l26;
          l10 = l15;
          l9 = l22;
          l8 = l21;
          l7 = l20;
          l6 = l19;
          l5 = l18;
          l4 = l17;
          l2 = l16;
          l3 = l14;
          bool6 = ((bbex)localObject4).getIsReloadUrl();
          l9 = l25;
          l7 = l26;
          l10 = 0L;
          bool7 = false;
          l24 = -1L;
          l6 = l23;
          l2 = l15;
          l3 = l22;
          l4 = l21;
          l5 = l20;
          l8 = l19;
          l11 = l18;
          l12 = l17;
          l13 = l16;
          bool5 = bool1;
          bool4 = bool2;
          l15 = l1;
          l1 = l24;
          bool2 = bool7;
          bool1 = bool6;
        }
        catch (Exception localException4)
        {
          bool7 = false;
          l18 = l13;
          l19 = l12;
          l22 = 0L;
          bool6 = false;
          l21 = -1L;
          l20 = l11;
          l11 = l7;
          l12 = l6;
          l13 = l5;
          l14 = l4;
          l15 = l2;
          l16 = l3;
          l17 = l1;
          bool4 = bool2;
          bool5 = bool1;
          bool1 = bool7;
          l1 = l20;
          l2 = l18;
          l3 = l19;
          l5 = l22;
          bool2 = bool6;
          l4 = l21;
          l6 = l10;
          l7 = l9;
          l9 = l11;
          l10 = l12;
          l11 = l13;
          l12 = l14;
          l13 = l15;
          l14 = l16;
          l15 = l17;
          continue;
          i = 0;
          break label1502;
          localObject3 = null;
          break label1468;
          bool1 = false;
          l6 = -1L;
          l9 = -1L;
          l7 = -1L;
          l10 = 0L;
          bool3 = false;
          l1 = -1L;
          l2 = -1L;
          l3 = -1L;
          l4 = -1L;
          l5 = -1L;
          l8 = -1L;
          l11 = -1L;
          l12 = -1L;
          l13 = -1L;
          l14 = -1L;
          l15 = -1L;
          bool4 = true;
          bool5 = false;
          break label1166;
          localObject3 = null;
          break label2230;
          localObject5 = null;
          bool1 = bool6;
          break label2419;
        }
        l18 = l10;
        l19 = l7;
        l10 = l8;
        l17 = l5;
        l8 = l4;
        l7 = l3;
        l16 = l2;
        l4 = l1;
        l5 = l18;
        l3 = l19;
        l2 = l9;
        l1 = l6;
        localObject5 = null;
        if ((this.mRuntime.a() instanceof ApolloStoreActivity))
        {
          localObject1 = ((ApolloStoreActivity)this.mRuntime.a()).a(true);
          if (localObject1 == null) {
            continue;
          }
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("thunderCacheType", ((aiwf)localObject1).jdField_a_of_type_Int);
          ((JSONObject)localObject5).put("webViewReadyTime", ((aiwf)localObject1).i);
          ((JSONObject)localObject5).put("sessionStartTime", ((aiwf)localObject1).g);
          ((JSONObject)localObject5).put("sessionEndTime", ((aiwf)localObject1).h);
          ((JSONObject)localObject5).put("SSOStartTime", ((aiwf)localObject1).jdField_a_of_type_Long);
          ((JSONObject)localObject5).put("SSOEndTime", ((aiwf)localObject1).jdField_b_of_type_Long);
          ((JSONObject)localObject5).put("SSOCallJSTime", ((aiwf)localObject1).d);
          ((JSONObject)localObject5).put("loadUrlTime", ((aiwf)localObject1).j);
          ((JSONObject)localObject5).put("SSORequestTime", ((aiwf)localObject1).c);
          ((JSONObject)localObject5).put("readLocalFileCost", ((aiwf)localObject1).e);
          ((JSONObject)localObject5).put("verifyLocalFileCost", ((aiwf)localObject1).f);
          ((JSONObject)localObject5).put("cgiStatistics", ((aiwf)localObject1).jdField_a_of_type_OrgJsonJSONObject);
          if (QLog.isColorLevel()) {
            QLog.d("VasCommonJsPlugin", 2, "apollo_client_apolloWebStatistics:" + ((JSONObject)localObject5).toString());
          }
          localObject1 = localObject5;
          bool6 = false;
          if (!(localObject4 instanceof bbew)) {
            continue;
          }
          i = ((bbew)localObject4).b();
          bool6 = ((bbew)localObject4).d();
          l6 = l13;
          if (l13 == -1L) {
            l6 = this.onPageStartedTime;
          }
          paramJSONObject.put("clickStart", l14);
          paramJSONObject.put("pageStart", l6);
          paramJSONObject.put("pageFinish", this.onPageFinishedTime);
          paramJSONObject.put("webviewStart", l15);
          paramJSONObject.put("isUseLocalSrc", bool5);
          paramJSONObject.put("noLocalSrcType", mof.jdField_a_of_type_Int);
          paramJSONObject.put("isFirstRequest", bool4);
          paramJSONObject.put("isPreloadWebProcess", bbca.jdField_s_of_type_Boolean);
          paramJSONObject.put("isCompletePreloadWebProcess", bbca.jdField_t_of_type_Boolean);
          paramJSONObject.put("isWebViewCache", bool3);
          paramJSONObject.put("onCreate", l12);
          paramJSONObject.put("viewInflate", l11);
          paramJSONObject.put("getWebView", l10);
          paramJSONObject.put("initBrowser", l17);
          paramJSONObject.put("init", l8);
          paramJSONObject.put("initTBS", l7);
          paramJSONObject.put("pluginFinished", l16);
          paramJSONObject.put("nonWhiteScreen", l4);
          if (localObject1 != null) {
            paramJSONObject.put("thunderData", localObject1);
          }
          paramJSONObject.put("initWebViewTime", l5);
          paramJSONObject.put("isDirectAddress", bool2);
          localObject1 = new StringBuilder("speed data:");
          ((StringBuilder)localObject1).append("clickStartTime = " + l14).append("webviewStartTime = " + l15).append("pageStartTime = " + l6);
          ((StringBuilder)localObject1).append("click to create :" + (l15 - l14)).append(", create to loadUrl : " + (l6 - l15));
          QLog.d("VasCommonJsPlugin", 1, ((StringBuilder)localObject1).toString());
          if (l3 > 0L) {
            paramJSONObject.put("packageCheckFinish", l3);
          }
          if (l2 > 0L) {
            paramJSONObject.put("readIndexTime", l2);
          }
          if (l1 > 0L) {
            paramJSONObject.put("redirect302Time", l1);
          }
          paramJSONObject.put("isReloadUrl", bool1);
          if (i > 0)
          {
            paramJSONObject.put("pid", i);
            if (!bool6) {
              continue;
            }
            i = 2;
            paramJSONObject.put("isabnormalstart", i);
          }
          if (paramWebView != null)
          {
            if (paramWebView.getX5WebViewExtension() != null) {
              continue;
            }
            paramWebView = "0";
            paramJSONObject.put("isX5", paramWebView);
          }
          if (QLog.isColorLevel())
          {
            paramWebView = new StringBuilder().append("");
            if (l1 > 0L) {
              continue;
            }
            paramJSONObject = "";
            paramWebView = paramWebView.append(paramJSONObject);
            if (l3 > 0L) {
              continue;
            }
            paramJSONObject = "";
            paramWebView = paramWebView.append(paramJSONObject);
            if (l2 > 0L) {
              continue;
            }
            paramJSONObject = "";
            QLog.i("QQBrowser_report", 2, paramJSONObject);
          }
          return;
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          if (!(this.mRuntime.a() instanceof bazk)) {
            continue;
          }
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          localObject6 = (bbca)super.getBrowserComponent(-2);
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          if (this.mRuntime.a() == null) {
            continue;
          }
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          localObject1 = this.mRuntime.a().getPluginEngine().a("offline");
          if (localObject1 == null) {
            continue;
          }
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          if (!(localObject1 instanceof xce)) {
            continue;
          }
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          localObject1 = (xce)localObject1;
          label2230:
          bool4 = bool7;
          l2 = l1;
          bool5 = bool3;
          localObject7 = this.mRuntime.a().getSonicClient();
          localObject5 = localObject1;
          bool1 = bool6;
          if (localObject7 != null)
          {
            bool4 = bool7;
            l2 = l1;
            bool5 = bool3;
            localObject7 = ((SonicClientImpl)localObject7).getSession();
            localObject5 = localObject1;
            bool1 = bool6;
            if (localObject7 != null)
            {
              bool4 = bool7;
              l2 = l1;
              bool5 = bool3;
              localObject5 = ((SonicSession)localObject7).getStatistics();
              if (localObject5 == null) {
                break label3390;
              }
              bool4 = bool7;
              l2 = l1;
              bool5 = bool3;
              if (!((SonicSessionStatistics)localObject5).isDirectAddress) {
                break label3390;
              }
              bool2 = true;
              label2346:
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
          bool2 = bool1;
          if (localObject6 == null) {
            continue;
          }
          bool4 = bool1;
          l2 = l1;
          bool5 = bool3;
          l1 = ((bbca)localObject6).c;
          if (localObject5 != null)
          {
            bool4 = bool1;
            l2 = l1;
            bool5 = bool3;
            if (((xce)localObject5).e)
            {
              bool2 = true;
              label2475:
              bool4 = bool1;
              l2 = l1;
              bool5 = bool2;
              bool3 = ((bbca)localObject6).h;
            }
          }
          for (;;)
          {
            for (;;)
            {
              boolean bool8;
              try
              {
                bool5 = ((bbca)localObject6).w;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l30;
                l14 = l31;
                l13 = l32;
                l11 = l33;
                l12 = l3;
              }
              catch (Exception localException5)
              {
                label3390:
                Object localObject2;
                bool8 = false;
                l16 = -1L;
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
                l14 = -1L;
                l15 = l1;
                bool4 = bool3;
                bool5 = bool2;
                bool1 = bool8;
                l1 = l16;
                bool2 = bool6;
                bool3 = bool7;
                continue;
              }
              try
              {
                l4 = ((bbca)localObject6).jdField_b_of_type_Long;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l30;
                l14 = l31;
                l13 = l32;
                l11 = l33;
                l12 = l4;
                l5 = ((bbca)localObject6).q;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l30;
                l14 = l31;
                l13 = l32;
                l11 = l5;
                l12 = l4;
                l6 = ((bbca)localObject6).r;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l30;
                l14 = l31;
                l13 = l6;
                l11 = l5;
                l12 = l4;
                l7 = ((bbca)localObject6).jdField_s_of_type_Long;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l30;
                l14 = l7;
                l13 = l6;
                l11 = l5;
                l12 = l4;
                l8 = ((bbca)localObject6).m;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l29;
                l16 = l8;
                l14 = l7;
                l13 = l6;
                l11 = l5;
                l12 = l4;
                l9 = ((bbca)localObject6).n;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l28;
                l17 = l9;
                l16 = l8;
                l14 = l7;
                l13 = l6;
                l11 = l5;
                l12 = l4;
                l10 = ((bbca)localObject6).o;
                l23 = l24;
                l22 = l25;
                l21 = l26;
                l20 = l15;
                l19 = l27;
                l18 = l10;
                l17 = l9;
                l16 = l8;
                l14 = l7;
                l13 = l6;
                l11 = l5;
                l12 = l4;
                l15 = ((bbca)localObject6).p;
                l27 = 0L;
                if (localObject5 != null)
                {
                  l23 = l24;
                  l22 = l25;
                  l21 = l26;
                  l20 = l27;
                  l19 = l15;
                  l18 = l10;
                  l17 = l9;
                  l16 = l8;
                  l14 = l7;
                  l13 = l6;
                  l11 = l5;
                  l12 = l4;
                  l2 = ((xce)localObject5).jdField_a_of_type_Long;
                  if (localObject5 == null) {
                    continue;
                  }
                  l23 = l24;
                  l22 = l25;
                  l21 = l2;
                  l20 = l27;
                  l19 = l15;
                  l18 = l10;
                  l17 = l9;
                  l16 = l8;
                  l14 = l7;
                  l13 = l6;
                  l11 = l5;
                  l12 = l4;
                  l3 = ((xce)localObject5).jdField_b_of_type_Long;
                  l23 = l24;
                  l22 = l3;
                  l21 = l2;
                  l20 = l27;
                  l19 = l15;
                  l18 = l10;
                  l17 = l9;
                  l16 = l8;
                  l14 = l7;
                  l13 = l6;
                  l11 = l5;
                  l12 = l4;
                  l24 = ((bbca)localObject6).jdField_t_of_type_Long;
                  if (localObject5 == null) {
                    continue;
                  }
                  l23 = l24;
                  l22 = l3;
                  l21 = l2;
                  l20 = l27;
                  l19 = l15;
                  l18 = l10;
                  l17 = l9;
                  l16 = l8;
                  l14 = l7;
                  l13 = l6;
                  l11 = l5;
                  l12 = l4;
                  bool4 = ((xce)localObject5).d;
                  if (!bool4) {
                    continue;
                  }
                  bool4 = true;
                  l12 = l35;
                  l11 = l34;
                }
              }
              catch (Exception localException6)
              {
                bool8 = false;
                l2 = l22;
                l3 = l21;
                l5 = 0L;
                bool4 = bool1;
                l4 = -1L;
                l6 = l20;
                l7 = l19;
                l8 = l18;
                l9 = l17;
                l10 = l16;
                l15 = l11;
                l16 = l12;
                l17 = l1;
                bool6 = bool3;
                bool7 = bool2;
                bool1 = bool8;
                l1 = l23;
                bool2 = bool4;
                bool3 = bool5;
                l11 = l14;
                l12 = l13;
                l13 = l15;
                l14 = l16;
                l15 = l17;
                bool4 = bool6;
                bool5 = bool7;
                continue;
              }
              try
              {
                l19 = ((bbca)localObject6).u;
                l12 = l19;
                l11 = l34;
                l20 = ((bbca)localObject6).e;
                l12 = l19;
                l11 = l20;
                QLog.d("VasCommonJsPlugin", 1, "getPerformance: isWebViewCache = " + bool5 + ", isPreloadWebProcess = " + bbca.jdField_s_of_type_Boolean);
                l18 = l3;
                bool6 = bool1;
                l21 = 0L;
                l3 = l15;
                l11 = l10;
                l12 = l9;
                l13 = l7;
                l14 = l6;
                l15 = l5;
                l16 = l4;
                l17 = l1;
                bool7 = bool3;
                bool8 = bool2;
                bool1 = bool4;
                l6 = l24;
                l9 = l18;
                l7 = l2;
                l10 = l19;
                bool2 = bool6;
                bool3 = bool5;
                l1 = l20;
                l2 = l21;
                l4 = l11;
                l5 = l12;
                l11 = l13;
                l12 = l14;
                l13 = l15;
                l14 = l16;
                l15 = l17;
                bool4 = bool7;
                bool5 = bool8;
              }
              catch (Exception localException7)
              {
                l18 = l2;
                l19 = l12;
                bool6 = bool1;
                l20 = l11;
                l21 = 0L;
                l11 = l8;
                l12 = l7;
                l13 = l6;
                l14 = l5;
                l16 = l4;
                l17 = l1;
                bool7 = bool3;
                bool8 = bool2;
                bool1 = bool4;
                l1 = l24;
                l2 = l3;
                l3 = l18;
                l5 = l19;
                bool2 = bool6;
                bool3 = bool5;
                l4 = l20;
                l6 = l21;
                l7 = l15;
                l8 = l10;
                l10 = l11;
                l11 = l12;
                l12 = l13;
                l13 = l14;
                l14 = l16;
                l15 = l17;
                bool4 = bool7;
                bool5 = bool8;
              }
            }
            bool2 = false;
            break label2346;
            bool2 = false;
            break label2475;
            l2 = 0L;
            continue;
            l3 = 0L;
            continue;
            bool4 = false;
          }
        }
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
        if ((localObject instanceof bbex))
        {
          localObject = ((bbex)localObject).getX5Performance();
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
          if (!(this.mRuntime.a() instanceof bazk)) {
            break label419;
          }
          localObject = (bbca)super.getBrowserComponent(-2);
          if (localObject == null) {
            break label419;
          }
          localObject = ((bbca)localObject).jdField_a_of_type_OrgJsonJSONObject;
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
    paramString2 = localStringBuilder.append(paramString1).append("|").append(paramString2).append("|").append(paramString3).append("|").append("ANDROID").append("|").append("8.2.6.4370").append("|").append(babp.e()).append("|").append(this.mRuntime.a().getCurrentAccountUin()).append("|").append(Build.MODEL).append("|");
    if (TextUtils.isEmpty(babp.a(this.mRuntime.a()).c))
    {
      paramString1 = "未知";
      paramString2 = paramString2.append(paramString1).append("|");
      if (!TextUtils.isEmpty(babp.a(this.mRuntime.a()).a)) {
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
      paramString1 = babp.a(this.mRuntime.a()).c;
      break;
      paramString1 = babp.a(this.mRuntime.a()).a;
      break label167;
    }
    QLog.w("WebLog", 2, localStringBuilder.toString());
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
              break label317;
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
      label317:
      String str4 = "";
    }
  }
  
  public String getCurrentNetwork()
  {
    try
    {
      i = badq.a(BaseApplicationImpl.getApplication().getApplicationContext());
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
  
  protected JSONObject getJsBackJson(Intent paramIntent, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<Integer> paramList4, List<String> paramList5, List<String> paramList6, List<Integer> paramList7, List<Integer> paramList8)
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    int i;
    String str2;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      if ((paramList1 != null) && (paramList2 != null) && (paramList3 != null))
      {
        i = 0;
        if ((i < paramList1.size()) && (i < paramList2.size()) && (i < paramList3.size()))
        {
          paramIntent = "";
          String str1 = "";
          if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
            paramIntent = (String)paramList1.get(i);
          }
          if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
            str1 = (String)paramList2.get(i);
          }
          if (TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
            break label611;
          }
          str2 = (String)paramList3.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("uin", paramIntent);
          localJSONObject2.put("phone", str1);
          localJSONObject2.put("name", str2);
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
        break label606;
      }
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
      return null;
    }
    label308:
    int k;
    if ((paramList6 != null) && (paramList7 != null) && (paramList8 != null))
    {
      paramList2 = new JSONArray();
      i = 0;
      if ((i >= paramList5.size()) || (i >= paramList6.size()) || (i >= paramList7.size()) || (i >= paramList8.size())) {
        break label643;
      }
      paramIntent = "";
      paramList1 = "";
      int j = 0;
      if (!TextUtils.isEmpty((CharSequence)paramList5.get(i))) {
        paramIntent = (String)paramList5.get(i);
      }
      if (!TextUtils.isEmpty((CharSequence)paramList6.get(i))) {
        paramList1 = (String)paramList6.get(i);
      }
      if (paramList7.get(i) != null) {
        j = ((Integer)paramList7.get(i)).intValue();
      }
      if (paramList8.get(i) != null)
      {
        k = ((Integer)paramList8.get(i)).intValue();
        break label618;
        label488:
        paramList3 = new JSONObject();
        paramList3.put("uin", paramIntent);
        paramList3.put("name", paramList1);
        paramList3.put("type", k);
        paramList3.put("count", j);
        paramList2.put(paramList3);
        break label634;
      }
    }
    for (;;)
    {
      localJSONObject1.put("friends", localJSONArray);
      if ((paramIntent != null) && (paramIntent.length() > 0)) {
        localJSONObject1.put("groups", paramIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("VasCommonJsPlugin", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      k = 0;
      break label618;
      label606:
      paramIntent = null;
      continue;
      label611:
      str2 = "";
      break;
      label618:
      if ((k == 4) || (k == 8)) {
        break label488;
      }
      label634:
      i += 1;
      break label308;
      label643:
      paramIntent = paramList2;
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
      paramJSONObject = anah.a("getNickName", paramString, this.mOnRemoteResp.key, this.mReqBundle);
      anfc.a().a(paramJSONObject);
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
    this.logicMethod = paramString3;
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
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramString1 = new JSONObject(paramVarArgs[0]).optString("pageId", "");
        paramString2 = (bbca)super.getBrowserComponent(-2);
        if (paramString2 != null) {
          paramString2.jdField_b_of_type_JavaLangString = paramString1;
        }
        VasWebviewUtil.reportX5SpeedData(paramString2);
      }
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
      if (!anfc.a().a()) {
        anfc.a().a().doBindService(this.mRuntime.a().getApplicationContext());
      }
    }
    else if ("stopIpcService".equals(paramString3))
    {
      anfc.a().a().doUnbindService(this.mRuntime.a().getApplicationContext());
    }
    else if ("isIpcStarted".equals(paramString3))
    {
      paramString1 = new JSONObject();
      paramString1.put("isIpcStarted", anfc.a().a());
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
          if ((paramString2 instanceof mzd))
          {
            ((mzd)paramString2).a = true;
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
    if (QLog.isColorLevel()) {
      QLog.i("VasCommonJsPlugin", 2, "onActivityResult requestCode = " + paramByte + " resultCode = " + paramInt);
    }
    if (paramInt == -1) {
      if (paramByte == 17) {
        backH5Friends(paramIntent);
      }
    }
    while (paramByte != 17) {
      return;
    }
    errorCallBack();
  }
  
  public void onCreate()
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
  
  public void setUiInterface(bazo parambazo)
  {
    this.uiInterface = parambazo;
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
        localObject = babr.a(this.mRuntime.a(), 230);
        ((bafp)localObject).a(str2);
        ((bafp)localObject).b(str1);
        ((bafp)localObject).a(paramJSONObject[0], new VasCommonJsPlugin.1(this, paramJsBridgeListener));
        if (paramJSONObject.length >= 2) {
          ((bafp)localObject).b(paramJSONObject[1], new VasCommonJsPlugin.2(this, paramJsBridgeListener));
        }
        if (paramJSONObject.length >= 3) {
          ((bafp)localObject).c(paramJSONObject[2], new VasCommonJsPlugin.3(this, paramJsBridgeListener));
        }
        ((bafp)localObject).setCanceledOnTouchOutside(false);
        ((bafp)localObject).setOnKeyListener(new VasCommonJsPlugin.4(this, (bafp)localObject, paramJsBridgeListener));
        ((bafp)localObject).show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin
 * JD-Core Version:    0.7.0.1
 */