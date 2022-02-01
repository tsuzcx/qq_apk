package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryInCardConfig;
import com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopApiPlugin
  extends WebViewPlugin
{
  int jdField_a_of_type_Int;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopApiPlugin.2(this);
  VideoUploadTask jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  int jdField_b_of_type_Int;
  TroopMemberApiClient jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e;
  
  public TroopApiPlugin()
  {
    this.mPluginNameSpace = "troopApi";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!"Unknown".equals(paramString)) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131299166));
    }
  }
  
  private void a(TroopInfo paramTroopInfo)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramTroopInfo.troopuin, this.jdField_b_of_type_Int, this.e);
  }
  
  private void a(SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("lat", paramSosoLbsInfo.mLocation.mLat02);
        localJSONObject.put("lon", paramSosoLbsInfo.mLocation.mLon02);
        localJSONObject.put("nation", a(paramSosoLbsInfo.mLocation.nation));
        localJSONObject.put("province", a(paramSosoLbsInfo.mLocation.province));
        localJSONObject.put("city", a(paramSosoLbsInfo.mLocation.city));
        localJSONObject.put("district", a(paramSosoLbsInfo.mLocation.district));
        callJs(paramString, new String[] { "0", localJSONObject.toString() });
        return;
      }
      catch (Exception paramSosoLbsInfo)
      {
        QLog.e(this.TAG, 1, "onLocationFinish Failed!", paramSosoLbsInfo);
        callJs(paramString, new String[] { "-5", "{}" });
        return;
      }
    }
    callJs(paramString, new String[] { "-4", "{}" });
  }
  
  private void a(String paramString)
  {
    QLog.i(this.TAG, 1, "openSelectTroopMember, jsonData: " + paramString);
    try
    {
      paramString = new JSONObject(paramString).getString("troopUin");
      if (!TextUtils.isEmpty(paramString))
      {
        Activity localActivity = this.mRuntime.a();
        Bundle localBundle = new Bundle();
        localBundle.putInt("from", 2);
        SelectTroopMemberFragment.a(localActivity, localBundle, paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d(this.TAG, 1, "JASPI openSelectTroopMember", paramString);
    }
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    paramArrayOfString = paramArrayOfString[0];
    try
    {
      QLog.i("TroopAbility.Jsapi", 1, "create troop callback content: " + paramArrayOfString);
      paramArrayOfString = new JSONObject(paramArrayOfString);
      int i = paramArrayOfString.optInt("retCode");
      paramArrayOfString.optString("error");
      paramArrayOfString = paramArrayOfString.optString("troopUin");
      if (i == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.mRuntime.a();
        if (localBaseActivity == null) {
          return true;
        }
        Intent localIntent = new Intent();
        localIntent.addFlags(603979776);
        localIntent.putExtra("action", 2);
        localIntent.putExtra("troop_uin", paramArrayOfString);
        PublicFragmentActivity.Launcher.a(localBaseActivity, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
        localBaseActivity.overridePendingTransition(0, 0);
      }
      return false;
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        paramArrayOfString.printStackTrace();
      }
    }
    return true;
  }
  
  private void b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo.cGroupOption != 3)
    {
      Intent localIntent = AddFriendLogicActivity.a(a(), paramTroopInfo.troopuin, paramTroopInfo.getTroopDisplayName(), paramTroopInfo.cGroupOption, this.jdField_b_of_type_Int, paramTroopInfo.joinTroopQuestion, paramTroopInfo.joinTroopAnswer, null, this.c, this.d);
      this.jdField_a_of_type_Int = paramTroopInfo.cGroupOption;
      startActivityForResult(localIntent, (byte)3);
      return;
    }
    this.jdField_a_of_type_Int = -1;
    a(2131720199);
  }
  
  private void b(String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramArrayOfString[0]);
        paramArrayOfString = ((JSONObject)localObject).optString("callback");
        localObject = ((JSONObject)localObject).optString("groupcode", "");
        TroopEssenceMsgEntryInCardConfig localTroopEssenceMsgEntryInCardConfig = (TroopEssenceMsgEntryInCardConfig)QConfigManager.a().a(715);
        if ((localTroopEssenceMsgEntryInCardConfig != null) && (localTroopEssenceMsgEntryInCardConfig.a((String)localObject)))
        {
          i = 1;
          localObject = new JSONObject();
          if (i != 0)
          {
            i = 1;
            ((JSONObject)localObject).put("ret", i);
            callJs(paramArrayOfString, new String[] { ((JSONObject)localObject).toString() });
            return;
          }
          i = 0;
          continue;
        }
        int i = 0;
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
    }
  }
  
  private void c(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      try
      {
        if (paramArrayOfString.length > 0)
        {
          Activity localActivity = this.mRuntime.a();
          Intent localIntent = new Intent();
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          String str = paramArrayOfString.optString("callback");
          if (paramArrayOfString.length() > 0) {
            callJs(str, new String[] { localActivity.getString(2131698322) });
          }
          for (;;)
          {
            localIntent.putExtra("SchoolJsonObject", paramArrayOfString.getString("data"));
            localIntent.putExtra("groupCode", paramArrayOfString.getString("groupCode"));
            localActivity.setResult(-1, localIntent);
            localActivity.finish();
            return;
            callJs(str, new String[] { localActivity.getString(2131698321) });
          }
        }
        return;
      }
      catch (Exception paramArrayOfString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e(this.TAG, 4, "openRewardDetail, exception:", paramArrayOfString);
        }
      }
    }
  }
  
  private void d(String[] paramArrayOfString)
  {
    boolean bool = false;
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      int i = paramArrayOfString.getInt("isOn");
      paramArrayOfString = paramArrayOfString.getString("groupCode");
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.jsapi", 2, String.format("troop honor aio switch, troopUin: %s, switch: %s", new Object[] { paramArrayOfString, Integer.valueOf(i) }));
      }
      if (!TextUtils.isEmpty(paramArrayOfString))
      {
        TroopMemberApiClient localTroopMemberApiClient = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
        if (i == 1) {
          bool = true;
        }
        localTroopMemberApiClient.e(paramArrayOfString, bool);
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
      QLog.d(this.TAG, 1, "JASPI setGroupMarkSwitch", paramArrayOfString);
    }
  }
  
  private void e(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    try
    {
      if (paramArrayOfString.length > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopApiPlugin", 2, "open troop profile " + paramArrayOfString[0]);
        }
        paramArrayOfString = new JSONObject(paramArrayOfString[0]);
        Bundle localBundle = TroopInfoActivity.a(paramArrayOfString.optString("troopUin"), paramArrayOfString.optInt("from"));
        localBundle.putString("authSig", paramArrayOfString.optString("authSig"));
        TroopUtils.a(this.mRuntime.a(), localBundle, 2);
      }
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopApiPlugin", 2, "open troop profile Exception:" + paramArrayOfString);
    }
  }
  
  private void f(String[] paramArrayOfString)
  {
    int i = 30003;
    int j;
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramArrayOfString[0]);
        if (QLog.isColorLevel()) {
          QLog.d("TroopApiPlugin", 2, "AddTroop:" + localObject1);
        }
        paramArrayOfString = ((JSONObject)localObject1).optString("troopUin");
        this.jdField_b_of_type_Int = Integer.parseInt(((JSONObject)localObject1).optString("sourceid"));
        str = ((JSONObject)localObject1).optString("isexactsearch");
        localObject2 = ((JSONObject)localObject1).optString("sourceext");
        if ((localObject2 != null) && (str != null) && (!((String)localObject2).isEmpty()))
        {
          boolean bool = str.isEmpty();
          if (bool) {}
        }
      }
      catch (JSONException paramArrayOfString)
      {
        Object localObject1;
        String str;
        Object localObject2;
        int k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TroopApiPlugin", 2, "AddTroop JSONException:" + paramArrayOfString);
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
        return;
        i = 30005;
        continue;
        if (j == 0) {
          break label466;
        }
        this.jdField_b_of_type_Int = i;
        continue;
      }
      catch (Exception paramArrayOfString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TroopApiPlugin", 2, "AddTroop Exception:" + paramArrayOfString);
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-10,\"message\":\"request fail\"}" });
        return;
      }
      try
      {
        k = Integer.parseInt((String)localObject2);
        j = Integer.parseInt(str);
        if (j != 1) {
          continue;
        }
        j = 1;
        switch (k)
        {
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.TAG, 2, "cast sourceext from web error, sourceExt = " + (String)localObject2);
        continue;
      }
      this.c = ((JSONObject)localObject1).optString("sourcename");
      this.d = ((JSONObject)localObject1).optString("authSig");
      this.e = ((JSONObject)localObject1).optString("authKey");
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("callback");
      localObject1 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
      localObject2 = (TroopInfo)((EntityManager)localObject1).find(TroopInfo.class, paramArrayOfString);
      ((EntityManager)localObject1).close();
      if (localObject2 == null) {
        break;
      }
      a(2131690079);
      return;
      j = 0;
      continue;
      if (j != 0)
      {
        this.jdField_b_of_type_Int = i;
      }
      else
      {
        label466:
        i = 30007;
        continue;
        if (j == 0) {
          break label524;
        }
        i = 30009;
        this.jdField_b_of_type_Int = i;
        continue;
        label489:
        this.jdField_b_of_type_Int = i;
      }
    }
    for (;;)
    {
      label497:
      this.jdField_b_of_type_Int = i;
      break;
      label524:
      do
      {
        i = 30019;
        break label497;
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramArrayOfString, 8390785);
        return;
        i = 30011;
        break;
        if (j != 0)
        {
          i = 30013;
          break label489;
        }
        i = 30015;
        break label489;
      } while (j == 0);
      i = 30017;
    }
  }
  
  private void g(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "clickMineButton:" + localObject);
      }
      paramArrayOfString = ((JSONObject)localObject).optString("troopUin");
      localObject = ((JSONObject)localObject).optString("memberUin");
      if (TroopRankConfig.a().a(paramArrayOfString, (String)localObject))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        TroopRankConfig.a().a(paramArrayOfString, (String)localObject, false);
      }
      return;
    }
    catch (Exception paramArrayOfString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "clickMineButton exp", paramArrayOfString);
    }
  }
  
  private void h(String[] paramArrayOfString)
  {
    try
    {
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "saveTroopMemberTitle:" + paramArrayOfString);
      }
      String str1 = paramArrayOfString.optString("troopUin");
      String str2 = paramArrayOfString.optString("memberUin");
      int i = paramArrayOfString.optInt("titleId");
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a(str1, str2, i);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "saveTroopMemberTitle exp:", paramArrayOfString);
    }
  }
  
  private void i(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).getString("callback");
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "openEditUniqTitle:" + localObject);
      }
      paramArrayOfString = ((JSONObject)localObject).optString("troopUin");
      String str = ((JSONObject)localObject).optString("memberUin");
      int i = ((JSONObject)localObject).optInt("memberRole");
      localObject = ((JSONObject)localObject).optString("uniqueTitle");
      startActivityForResult(EditUniqueTitleActivity.a(this.mRuntime.a(), 1, paramArrayOfString, str, i, (String)localObject), (byte)4);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopRankConfig", 2, "openEditUniqTitle exp", paramArrayOfString);
    }
  }
  
  private void j(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopRankConfig", 2, "setRedPoint:" + localObject);
      }
      paramArrayOfString = ((JSONObject)localObject).optString("troopUin");
      localObject = ((JSONObject)localObject).optString("memberUin");
      if (TroopRankConfig.a().a(paramArrayOfString, (String)localObject))
      {
        localObject = this.mRuntime.a();
        paramArrayOfString = (WebViewFragment)this.mRuntime.a();
        RelativeLayout.LayoutParams localLayoutParams;
        if ((localObject != null) && ((localObject instanceof AbsBaseWebViewActivity)))
        {
          paramArrayOfString = (AbsBaseWebViewActivity)localObject;
          paramArrayOfString.rightViewImg.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramArrayOfString);
          localObject = (RelativeLayout)paramArrayOfString.findViewById(2131377301);
          if (localObject != null)
          {
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369518);
            localLayoutParams.setMargins(0, AIOUtils.a(5.0F, paramArrayOfString.getResources()), AIOUtils.a(5.0F, paramArrayOfString.getResources()), 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850831);
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
        }
        else if (paramArrayOfString != null)
        {
          paramArrayOfString.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramArrayOfString.getActivity());
          localObject = (RelativeLayout)paramArrayOfString.mUIStyleHandler.d.findViewById(2131377301);
          if (localObject != null)
          {
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369518);
            localLayoutParams.setMargins(0, AIOUtils.a(5.0F, paramArrayOfString.getResources()), AIOUtils.a(5.0F, paramArrayOfString.getResources()), 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850831);
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView);
            return;
          }
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "setRedPoint exp", paramArrayOfString);
      }
    }
  }
  
  private void k(String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel()) {
        QLog.d("TroopApiPlugin", 2, "previewRewardVideo:" + localObject);
      }
      paramArrayOfString = ((JSONObject)localObject).optString("troopUin");
      String str = ((JSONObject)localObject).optString("rewardId");
      long l1 = ((JSONObject)localObject).optLong("videoSize");
      long l2 = ((JSONObject)localObject).optLong("videoDuration");
      localObject = ((JSONObject)localObject).optString("callback");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(paramArrayOfString, str, new TroopApiPlugin.1(this, l1, l2, (String)localObject));
      return;
    }
    catch (Exception paramArrayOfString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramArrayOfString);
    }
  }
  
  private void l(String[] paramArrayOfString)
  {
    boolean bool = false;
    if (this.mRuntime.a() == null) {
      return;
    }
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      int i = paramArrayOfString.optInt("type", -1);
      int j = paramArrayOfString.optInt("value", 0);
      if (j == 1) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updateSmartManagerSettingStatus, id: " + i + ", value: " + j);
      }
      paramArrayOfString = new Intent("action_update_smart_manager_setting_status");
      paramArrayOfString.setPackage(BaseApplicationImpl.getApplication().getPackageName());
      paramArrayOfString.putExtra("id", i);
      paramArrayOfString.putExtra("isSet", bool);
      BaseApplicationImpl.getApplication().sendBroadcast(paramArrayOfString);
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
      QLog.d(this.TAG, 1, "updateSmartManagerSettingStatus", paramArrayOfString);
    }
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    paramArrayOfString = paramArrayOfString[0];
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getPois:" + paramArrayOfString);
    }
    if (this.mRuntime.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "getWebView()==null, return");
      }
    }
    Activity localActivity;
    do
    {
      return;
      localActivity = this.mRuntime.a();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(this.TAG, 2, "context==null || isFinishing, return");
    return;
    if (paramArrayOfString.charAt(0) == '{') {}
    for (;;)
    {
      try
      {
        paramArrayOfString = new JSONObject(paramArrayOfString).getString("callback");
        if (TextUtils.isEmpty(paramArrayOfString)) {
          break;
        }
        if (!(localActivity instanceof AppActivity)) {
          break label254;
        }
        SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
        if ((localSosoLbsInfo == null) || (localSosoLbsInfo.mLocation == null) || (localSosoLbsInfo.mLocation.poi == null) || (localSosoLbsInfo.mLocation.poi.size() <= 0)) {
          break label226;
        }
        a(localSosoLbsInfo, paramArrayOfString);
        return;
      }
      catch (JSONException paramArrayOfString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.TAG, 2, "getLocation exception:", paramArrayOfString);
      return;
    }
    label226:
    ((AppActivity)localActivity).requestPermissions(new TroopApiPlugin.3(this, paramArrayOfString), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    return;
    label254:
    callJs(paramArrayOfString, new String[] { "-4", "{}" });
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troopApi".equals(paramString2)) {
      return false;
    }
    if ("previewRewardVideo".equals(paramString3)) {
      k(paramVarArgs);
    }
    for (;;)
    {
      return true;
      if ("setRedPoint".equals(paramString3)) {
        j(paramVarArgs);
      } else if ("openEditUniqTitle".equals(paramString3)) {
        i(paramVarArgs);
      } else if ("saveTroopMemberTitle".equals(paramString3)) {
        h(paramVarArgs);
      } else if ("clickMineButton".equals(paramString3)) {
        g(paramVarArgs);
      } else if ("addTroop".equals(paramString3)) {
        f(paramVarArgs);
      } else if ("thirdAppCreateGroupCallback".equals(paramString3))
      {
        if (a(paramVarArgs)) {
          return false;
        }
      }
      else if ("openTroopProfile".equals(paramString3)) {
        e(paramVarArgs);
      } else if ("setGroupMarkSwitch".equals(paramString3)) {
        d(paramVarArgs);
      } else if ("setGroupSchoolInfo".equals(paramString3)) {
        c(paramVarArgs);
      } else if ("getLocationWithPoi".equals(paramString3)) {
        a(paramVarArgs);
      } else if (("changeGroupHousekeeperSetting".equals(paramString3)) && (paramVarArgs.length == 1)) {
        l(paramVarArgs);
      } else if ("getGlobalOpenGroupDigestOnSummary".equals(paramString3)) {
        b(paramVarArgs);
      } else if (("openSelectTroopMember".equals(paramString3)) && (paramVarArgs.length == 1)) {
        a(paramVarArgs[0]);
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt != -1) {
        break label93;
      }
      if (paramIntent != null) {
        break label74;
      }
      paramIntent = "";
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("code", 0);
        localJSONObject.put("uniqueTitle", paramIntent);
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        label74:
        paramIntent = paramIntent.getStringExtra("newUniqueTitle");
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
    label93:
    callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
  }
  
  public void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {}
    do
    {
      return;
      a();
    } while (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    if (this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin
 * JD-Core Version:    0.7.0.1
 */