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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.VideoUploadTask;
import com.tencent.mobileqq.troop.essence.TroopEssenceMsgEntryInCardConfig;
import com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
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
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopApiPlugin.2(this);
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
    if ((paramString != null) && (!"Unknown".equals(paramString))) {
      return paramString;
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    a(paramInt, 0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.mRuntime.a() != null) {
      QQToast.a(this.mRuntime.a(), paramInt2, this.mRuntime.a().getString(paramInt1), 0).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131299168));
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
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("openSelectTroopMember, jsonData: ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    try
    {
      paramString = new JSONObject(paramString).getString("troopUin");
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = this.mRuntime.a();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("from", 2);
        SelectTroopMemberFragment.a((Activity)localObject1, (Bundle)localObject2, paramString);
        return;
      }
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("create troop callback content: ");
      ((StringBuilder)localObject).append(paramArrayOfString);
      QLog.i("TroopAbility.Jsapi", 1, ((StringBuilder)localObject).toString());
      paramArrayOfString = new JSONObject(paramArrayOfString);
      int i = paramArrayOfString.optInt("retCode");
      paramArrayOfString.optString("error");
      paramArrayOfString = paramArrayOfString.optString("troopUin");
      if (i == 0)
      {
        localObject = (QBaseActivity)this.mRuntime.a();
        if (localObject == null) {
          return true;
        }
        Intent localIntent = new Intent();
        localIntent.addFlags(603979776);
        localIntent.putExtra("action", 2);
        localIntent.putExtra("troop_uin", paramArrayOfString);
        PublicFragmentActivity.Launcher.a((Context)localObject, localIntent, PublicFragmentActivity.class, BindGroupFragment.class);
        ((QBaseActivity)localObject).overridePendingTransition(0, 0);
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
    a(2131719932);
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
          if (i == 0) {
            break label116;
          }
          i = 1;
          ((JSONObject)localObject).put("ret", i);
          callJs(paramArrayOfString, new String[] { ((JSONObject)localObject).toString() });
          return;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        paramArrayOfString.printStackTrace();
        return;
      }
      int i = 0;
      continue;
      label116:
      i = 0;
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
            callJs(str, new String[] { localActivity.getString(2131698387) });
          } else {
            callJs(str, new String[] { localActivity.getString(2131698386) });
          }
          localIntent.putExtra("SchoolJsonObject", paramArrayOfString.getString("data"));
          localIntent.putExtra("groupCode", paramArrayOfString.getString("groupCode"));
          localActivity.setResult(-1, localIntent);
          localActivity.finish();
          return;
        }
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
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
      QLog.d(this.TAG, 1, "JASPI setGroupMarkSwitch", paramArrayOfString);
    }
  }
  
  private void e(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {
      try
      {
        if (paramArrayOfString.length > 0)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("open troop profile ");
            ((StringBuilder)localObject).append(paramArrayOfString[0]);
            QLog.w("TroopApiPlugin", 2, ((StringBuilder)localObject).toString());
          }
          paramArrayOfString = new JSONObject(paramArrayOfString[0]);
          localObject = TroopInfoUIUtil.a(paramArrayOfString.optString("troopUin"), "", paramArrayOfString.optInt("from"));
          ((Bundle)localObject).putString("authSig", paramArrayOfString.optString("authSig"));
          TroopUtils.a(this.mRuntime.a(), (Bundle)localObject, 2);
          return;
        }
      }
      catch (JSONException paramArrayOfString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("open troop profile Exception:");
          ((StringBuilder)localObject).append(paramArrayOfString);
          QLog.w("TroopApiPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private void f(String[] paramArrayOfString)
  {
    try
    {
      localObject1 = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("AddTroop:");
        paramArrayOfString.append(localObject1);
        QLog.d("TroopApiPlugin", 2, paramArrayOfString.toString());
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
    catch (Exception paramArrayOfString)
    {
      String str;
      Object localObject2;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("AddTroop Exception:");
        ((StringBuilder)localObject1).append(paramArrayOfString);
        QLog.w("TroopApiPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-10,\"message\":\"request fail\"}" });
      return;
    }
    catch (JSONException paramArrayOfString)
    {
      Object localObject1;
      label146:
      label154:
      label162:
      label170:
      label178:
      label186:
      label235:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("AddTroop JSONException:");
        ((StringBuilder)localObject1).append(paramArrayOfString);
        QLog.w("TroopApiPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1,\"message\":\"request fail\"}" });
      return;
    }
    try
    {
      k = Integer.parseInt((String)localObject2);
      if (Integer.parseInt(str) != 1) {
        break label482;
      }
      i = 1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label186;
      i = 0;
      j = 30003;
      if (k == 1) {
        break label589;
      }
      if (k == 2) {
        break label575;
      }
      if (k == 3) {
        break label557;
      }
      if (k == 4) {
        break label539;
      }
      if (k != 5) {
        break label235;
      }
      if (i == 0) {
        break label532;
      }
      i = 30017;
      break label146;
      i = 30019;
      break label146;
      if (i == 0) {
        break label550;
      }
      i = 30013;
      break label154;
      i = 30015;
      break label154;
      if (i == 0) {
        break label568;
      }
      i = 30009;
      break label162;
      i = 30011;
      break label162;
      if (i != 0) {
        break label170;
      }
      j = 30007;
      break label170;
      if (i != 0) {
        break label178;
      }
      j = 30005;
      break label178;
    }
    this.jdField_b_of_type_Int = i;
    break label235;
    this.jdField_b_of_type_Int = i;
    break label235;
    this.jdField_b_of_type_Int = i;
    break label235;
    this.jdField_b_of_type_Int = j;
    break label235;
    this.jdField_b_of_type_Int = j;
    break label235;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cast sourceext from web error, sourceExt = ");
      localStringBuilder.append((String)localObject2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.c = ((JSONObject)localObject1).optString("sourcename");
    this.d = ((JSONObject)localObject1).optString("authSig");
    this.e = ((JSONObject)localObject1).optString("authKey");
    this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("callback");
    localObject1 = this.mRuntime.a().getEntityManagerFactory(this.mRuntime.a().getAccount()).createEntityManager();
    localObject2 = (TroopInfo)((EntityManager)localObject1).find(TroopInfo.class, paramArrayOfString);
    ((EntityManager)localObject1).close();
    if (localObject2 != null)
    {
      a(2131689995);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramArrayOfString, 8390785);
  }
  
  private void g(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clickMineButton:");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramArrayOfString.optString("troopUin");
      paramArrayOfString = paramArrayOfString.optString("memberUin");
      if (TroopRankConfig.a().a((String)localObject, paramArrayOfString))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        TroopRankConfig.a().a((String)localObject, paramArrayOfString, false);
        return;
      }
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "clickMineButton exp", paramArrayOfString);
      }
    }
  }
  
  private void h(String[] paramArrayOfString)
  {
    try
    {
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveTroopMemberTitle:");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramArrayOfString.optString("troopUin");
      String str = paramArrayOfString.optString("memberUin");
      int i = paramArrayOfString.optInt("titleId");
      this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient.a((String)localObject, str, i);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "saveTroopMemberTitle exp:", paramArrayOfString);
      }
    }
  }
  
  private void i(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      this.jdField_b_of_type_JavaLangString = paramArrayOfString.getString("callback");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openEditUniqTitle:");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramArrayOfString.optString("troopUin");
      String str = paramArrayOfString.optString("memberUin");
      int i = paramArrayOfString.optInt("memberRole");
      paramArrayOfString = paramArrayOfString.optString("uniqueTitle");
      startActivityForResult(EditUniqueTitleActivity.a(this.mRuntime.a(), 1, (String)localObject, str, i, paramArrayOfString), (byte)4);
      return;
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopRankConfig", 2, "openEditUniqTitle exp", paramArrayOfString);
      }
    }
  }
  
  private void j(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setRedPoint:");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("TroopRankConfig", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramArrayOfString.optString("troopUin");
      paramArrayOfString = paramArrayOfString.optString("memberUin");
      if (TroopRankConfig.a().a((String)localObject, paramArrayOfString))
      {
        localObject = this.mRuntime.a();
        paramArrayOfString = (WebViewFragment)this.mRuntime.a();
        RelativeLayout.LayoutParams localLayoutParams;
        if ((localObject != null) && ((localObject instanceof AbsBaseWebViewActivity)))
        {
          paramArrayOfString = (AbsBaseWebViewActivity)localObject;
          paramArrayOfString.rightViewImg.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramArrayOfString);
          localObject = (RelativeLayout)paramArrayOfString.findViewById(2131376756);
          if (localObject != null)
          {
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369233);
            localLayoutParams.setMargins(0, AIOUtils.b(5.0F, paramArrayOfString.getResources()), AIOUtils.b(5.0F, paramArrayOfString.getResources()), 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850767);
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
        }
        else if (paramArrayOfString != null)
        {
          paramArrayOfString.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramArrayOfString.getQBaseActivity());
          localObject = (RelativeLayout)paramArrayOfString.getUIStyleHandler().d.findViewById(2131376756);
          if (localObject != null)
          {
            localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(7, 2131369233);
            localLayoutParams.setMargins(0, AIOUtils.b(5.0F, paramArrayOfString.getResources()), AIOUtils.b(5.0F, paramArrayOfString.getResources()), 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850767);
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
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previewRewardVideo:");
        ((StringBuilder)localObject).append(paramArrayOfString);
        QLog.d("TroopApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramArrayOfString.optString("troopUin");
      String str = paramArrayOfString.optString("rewardId");
      long l1 = paramArrayOfString.optLong("videoSize");
      long l2 = paramArrayOfString.optLong("videoDuration");
      paramArrayOfString = paramArrayOfString.optString("callback");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b((String)localObject, str, new TroopApiPlugin.1(this, l1, l2, paramArrayOfString));
      return;
    }
    catch (Exception paramArrayOfString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramArrayOfString);
      }
    }
  }
  
  private void l(String[] paramArrayOfString)
  {
    if (this.mRuntime.a() == null) {
      return;
    }
    boolean bool = false;
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      int i = paramArrayOfString.optInt("type", -1);
      int j = paramArrayOfString.optInt("value", 0);
      if (j == 1) {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfString = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSmartManagerSettingStatus, id: ");
        localStringBuilder.append(i);
        localStringBuilder.append(", value: ");
        localStringBuilder.append(j);
        QLog.d(paramArrayOfString, 2, localStringBuilder.toString());
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
    Object localObject1 = paramArrayOfString[0];
    if (QLog.isColorLevel())
    {
      paramArrayOfString = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPois:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d(paramArrayOfString, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mRuntime.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "getWebView()==null, return");
      }
      return;
    }
    Object localObject2 = this.mRuntime.a();
    if ((localObject2 != null) && (!((Activity)localObject2).isFinishing()))
    {
      paramArrayOfString = (String[])localObject1;
      if (((String)localObject1).charAt(0) == '{') {
        try
        {
          paramArrayOfString = new JSONObject((String)localObject1).getString("callback");
        }
        catch (JSONException paramArrayOfString)
        {
          if (QLog.isColorLevel()) {
            QLog.w(this.TAG, 2, "getLocation exception:", paramArrayOfString);
          }
          return;
        }
      }
      if (!TextUtils.isEmpty(paramArrayOfString))
      {
        if ((localObject2 instanceof AppActivity))
        {
          localObject1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
          if ((localObject1 != null) && (((SosoLbsInfo)localObject1).mLocation != null) && (((SosoLbsInfo)localObject1).mLocation.poi != null) && (((SosoLbsInfo)localObject1).mLocation.poi.size() > 0))
          {
            a((SosoLbsInfo)localObject1, paramArrayOfString);
            return;
          }
          ((AppActivity)localObject2).requestPermissions(new TroopApiPlugin.3(this, paramArrayOfString), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        callJs(paramArrayOfString, new String[] { "-4", "{}" });
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 2, "context==null || isFinishing, return");
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"troopApi".equals(paramString2)) {
      return false;
    }
    if ("previewRewardVideo".equals(paramString3))
    {
      k(paramVarArgs);
      return true;
    }
    if ("setRedPoint".equals(paramString3))
    {
      j(paramVarArgs);
      return true;
    }
    if ("openEditUniqTitle".equals(paramString3))
    {
      i(paramVarArgs);
      return true;
    }
    if ("saveTroopMemberTitle".equals(paramString3))
    {
      h(paramVarArgs);
      return true;
    }
    if ("clickMineButton".equals(paramString3))
    {
      g(paramVarArgs);
      return true;
    }
    if ("addTroop".equals(paramString3))
    {
      f(paramVarArgs);
      return true;
    }
    if ("thirdAppCreateGroupCallback".equals(paramString3))
    {
      if (a(paramVarArgs)) {
        return false;
      }
    }
    else
    {
      if ("openTroopProfile".equals(paramString3))
      {
        e(paramVarArgs);
        return true;
      }
      if ("setGroupMarkSwitch".equals(paramString3))
      {
        d(paramVarArgs);
        return true;
      }
      if ("setGroupSchoolInfo".equals(paramString3))
      {
        c(paramVarArgs);
        return true;
      }
      if ("getLocationWithPoi".equals(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
      if (("changeGroupHousekeeperSetting".equals(paramString3)) && (paramVarArgs.length == 1))
      {
        l(paramVarArgs);
        return true;
      }
      if ("getGlobalOpenGroupDigestOnSummary".equals(paramString3))
      {
        b(paramVarArgs);
        return true;
      }
      if (("openSelectTroopMember".equals(paramString3)) && (paramVarArgs.length == 1)) {
        a(paramVarArgs[0]);
      }
    }
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 4)
    {
      if (paramInt == -1)
      {
        if (paramIntent == null) {
          paramIntent = "";
        } else {
          paramIntent = paramIntent.getStringExtra("newUniqueTitle");
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("code", 0);
          localJSONObject.put("uniqueTitle", paramIntent);
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
        }
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"code\":-1}" });
    }
  }
  
  protected void onCreate()
  {
    Object localObject = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if (localObject != null)
    {
      if (localActivity == null) {
        return;
      }
      a();
      localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
      if (localObject != null) {
        ((TroopMemberApiClient)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      }
    }
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask;
    if ((localObject != null) && (!((VideoUploadTask)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataVideoUploadTask.a();
    }
    localObject = this.jdField_b_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin
 * JD-Core Version:    0.7.0.1
 */