package com.tencent.mobileqq.nearby;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.app.face.NearByFaceDrawable;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.api.LbsUtils;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileCardConstants;
import com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil.ReportBundleBuilder;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.ReqBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.UserDeviceInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyJsInterface
  extends JsWebViewPlugin
  implements FaceDrawable.OnLoadingStateChangeListener
{
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new NearbyJsInterface.1(this);
  Context jdField_a_of_type_AndroidContentContext;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private NearbyJsInterface.MyNetEventHandler jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$MyNetEventHandler = null;
  AsynLoadDrawable jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = null;
  private String jdField_a_of_type_JavaLangString = "";
  HashMap<String, NearbyJsInterface.MatchUserInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new NearbyJsInterface.2(this);
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d;
  private String e;
  private String f = "";
  private String g = "";
  
  public NearbyJsInterface()
  {
    a();
  }
  
  private void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.NearbyJsInterface");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("before", paramInt1);
      localJSONObject.put("after", paramInt2);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyWebNetworkChange exception: ");
      localStringBuilder.append(localJSONException.toString());
      QLog.e("NearbyJsInterface", 1, localStringBuilder.toString());
    }
    callJs(this.g, new String[] { localJSONObject.toString() });
  }
  
  private void a(NearbyJsInterface.MatchUserInfo paramMatchUserInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openNearbyAio, from = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mRuntime.a();
    Intent localIntent = new Intent((Context)localObject, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_UIN", paramMatchUserInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin", paramMatchUserInfo.jdField_a_of_type_JavaLangString);
    int i;
    if (this.jdField_a_of_type_Int == 1) {
      i = 10002;
    } else {
      i = 1001;
    }
    localIntent.putExtra("uintype", i);
    localIntent.putExtra("gender", 1);
    localIntent.addFlags(67108864);
    ((Context)localObject).startActivity(localIntent);
  }
  
  private void b()
  {
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void clearFilterList(String paramString)
  {
    Object localObject = (INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    int i;
    StringBuilder localStringBuilder;
    try
    {
      i = new JSONObject(paramString).optInt("isExitNearbyDirect");
      if (i == 1) {
        i = 1;
      }
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFilterList param:");
      localStringBuilder.append(localJSONException.toString());
      QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      i = 0;
    }
    Activity localActivity = this.mRuntime.a();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearFilterList: param=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", app=");
      localStringBuilder.append(localObject);
      localStringBuilder.append(", activity=");
      localStringBuilder.append(localActivity);
      QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && ((localActivity instanceof QBaseActivity)))
    {
      paramString = (QBaseActivity)localActivity;
      if ((i != 0) && (!paramString.isFinishing()))
      {
        paramString = (NearbyHandler)((INearbyAppInterface)localObject).getBusinessHandler(NearbyConstants.jdField_a_of_type_JavaLangString);
        if (paramString != null) {
          paramString.a();
        }
        MineFragment.a((INearbyAppInterface)localObject);
        return;
      }
      if ((NetworkUtil.isNetSupport(BaseApplication.getContext())) && (!paramString.isFinishing()))
      {
        MineFragment.a((INearbyAppInterface)localObject);
        localObject = new Intent(paramString, NearbyActivity.class);
        ((Intent)localObject).setFlags(67108864);
        ((Intent)localObject).putExtra("key_from_location", true);
        paramString.startActivity((Intent)localObject);
        return;
      }
      QQToast.a(BaseApplication.getContext(), 1, paramString.getString(2131694422), 0).b(paramString.getTitleBarHeight());
    }
  }
  
  public void clearUnReadRedTouch(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearUnReadRedTouch:");
      localStringBuilder.append(paramString);
      QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
    }
    try
    {
      int i = new JSONObject(paramString).optInt("appid");
      ((INearbyProcManager)((INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(NearbyConstants.e)).a(i);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearUnReadRedTouch exp:");
        localStringBuilder.append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void contentLoaded()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "contentLoaded");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mRuntime.a() != null)
    {
      localObject1 = localObject2;
      if ((this.mRuntime.a() instanceof NearbyActivity)) {
        localObject1 = (NearbyActivity)this.mRuntime.a();
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((NearbyActivity)localObject1).getNearbyHybridFragment();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).p();
      }
    }
  }
  
  public void createMsgFromOther(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.d = paramString.optString("callback");
      String str = paramString.optString("tinyid");
      int i = paramString.optInt("isSuperLove");
      this.jdField_a_of_type_Int = paramString.optInt("from");
      getMatchPeopleInfo(str, false, i);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void editSchool(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("schoolName");
      int i = paramString.optInt("isValid");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.c(str, i);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
      }
    }
  }
  
  public void filterList(String paramString)
  {
    NearbyHandler localNearbyHandler = (NearbyHandler)((INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getBusinessHandler(NearbyConstants.jdField_a_of_type_JavaLangString);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("save filterList: params=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      if (((JSONObject)localObject2).optInt("filter") == 0)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("NearbyJsInterface", 2, "filter==0, return");
        return;
      }
      int i = ((JSONObject)localObject2).optInt("sex");
      int j = ((JSONObject)localObject2).optInt("time");
      int k = ((JSONObject)localObject2).optInt("age");
      int m = ((JSONObject)localObject2).optInt("interest");
      int n = ((JSONObject)localObject2).optInt("profession");
      int i1 = ((JSONObject)localObject2).optInt("country");
      int i2 = ((JSONObject)localObject2).optInt("province");
      int i3 = ((JSONObject)localObject2).optInt("city");
      int i4 = ((JSONObject)localObject2).optInt("contellation");
      paramString = ((JSONObject)localObject2).optString("strCountry");
      localObject1 = ((JSONObject)localObject2).optString("strProvince");
      String str = ((JSONObject)localObject2).optString("strCity");
      localObject2 = ((JSONObject)localObject2).optString("callback");
      try
      {
        localNearbyHandler.a(i, j, k, m, n, i1, i2, i3, i4, paramString, (String)localObject1, str);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          try
          {
            callJs((String)localObject2, new String[] { "" });
            return;
          }
          catch (Exception paramString) {}
        } else {
          return;
        }
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break label309;
      }
    }
    catch (Exception paramString) {}
    QLog.e("NearbyJsInterface", 2, "save filterList exp:", paramString);
    label309:
    return;
  }
  
  public void followUser(String paramString)
  {
    Object localObject = new NewIntent(this.mRuntime.a().getApplication().getApplicationContext(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localJSONObject.remove("callback");
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      ((NewIntent)localObject).putExtra("data", localWebSsoRequestBody.toByteArray());
      ((NewIntent)localObject).setObserver(new NearbyJsInterface.6(this, paramString));
      this.mRuntime.a().startServlet((NewIntent)localObject);
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
        paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("followUser failed! json failed, msg = ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void getFilterList(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    try
    {
      if (this.mRuntime.a() != null)
      {
        localObject2 = localObject1;
        if ((this.mRuntime.a() instanceof NearbyActivity)) {
          localObject2 = (NearbyActivity)this.mRuntime.a();
        }
      }
      String str = "";
      localObject1 = str;
      if (localObject2 != null)
      {
        localObject2 = ((NearbyActivity)localObject2).getNearbyHybridFragment();
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject1 = ((NearbyHybridFragment)localObject2).a();
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("sex", ((NearPeopleFilters)localObject1).a());
          ((JSONObject)localObject2).put("time", ((NearPeopleFilters)localObject1).b());
          ((JSONObject)localObject2).put("age", ((NearPeopleFilters)localObject1).c());
          ((JSONObject)localObject2).put("interest", ((NearPeopleFilters)localObject1).d());
          ((JSONObject)localObject2).put("profession", ((NearPeopleFilters)localObject1).f());
          ((JSONObject)localObject2).put("country", localObject1.a()[0]);
          ((JSONObject)localObject2).put("province", localObject1.a()[1]);
          ((JSONObject)localObject2).put("city", localObject1.a()[2]);
          ((JSONObject)localObject2).put("contellation", ((NearPeopleFilters)localObject1).e());
          ((JSONObject)localObject2).put("strCountry", ((NearPeopleFilters)localObject1).jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject2).put("strProvince", ((NearPeopleFilters)localObject1).c);
          ((JSONObject)localObject2).put("strCity", ((NearPeopleFilters)localObject1).d);
          localObject1 = ((JSONObject)localObject2).toString();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getFilterList: param=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", ret=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject2).toString());
      }
      callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject1 });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFilterList exp:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void getFilterListV2(String paramString)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = NearPeopleFilters.a(this.mRuntime.a().getCurrentAccountUin());
      if (localObject2 != null)
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("sex", ((NearPeopleFilters)localObject2).a());
        ((JSONObject)localObject1).put("time", ((NearPeopleFilters)localObject2).b());
        ((JSONObject)localObject1).put("age", ((NearPeopleFilters)localObject2).c());
        ((JSONObject)localObject1).put("interest", ((NearPeopleFilters)localObject2).d());
        ((JSONObject)localObject1).put("profession", ((NearPeopleFilters)localObject2).f());
        ((JSONObject)localObject1).put("country", localObject2.a()[0]);
        ((JSONObject)localObject1).put("province", localObject2.a()[1]);
        ((JSONObject)localObject1).put("city", localObject2.a()[2]);
        ((JSONObject)localObject1).put("contellation", ((NearPeopleFilters)localObject2).e());
        ((JSONObject)localObject1).put("strCountry", ((NearPeopleFilters)localObject2).jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("strProvince", ((NearPeopleFilters)localObject2).c);
        ((JSONObject)localObject1).put("strCity", ((NearPeopleFilters)localObject2).d);
        localObject1 = ((JSONObject)localObject1).toString();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getFilterListV2: param=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", ret=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject2).toString());
      }
      callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject1 });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFilterListV2 exp:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void getLbsInfo(String paramString)
  {
    try
    {
      this.d = new JSONObject(paramString).optString("callback");
      SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
      if (localSosoLbsInfo != null)
      {
        paramString = localSosoLbsInfo;
        if (localSosoLbsInfo.mLocation != null) {}
      }
      else
      {
        paramString = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
      }
      if (paramString != null) {
        paramString = LbsUtils.a(paramString);
      } else {
        paramString = "";
      }
      callJs(this.d, new String[] { paramString });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getMatchPeople(String paramString, int paramInt)
  {
    NearbyJsInterface.MatchUserInfo localMatchUserInfo = (NearbyJsInterface.MatchUserInfo)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
    if ((localMatchUserInfo != null) && (!TextUtils.isEmpty(localMatchUserInfo.jdField_a_of_type_JavaLangString)) && (!localMatchUserInfo.jdField_a_of_type_JavaLangString.equals("0")))
    {
      a(localMatchUserInfo);
      return;
    }
    getMatchPeopleInfo(paramString, true, paramInt);
  }
  
  public void getMatchPeopleInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    Object localObject = new oidb_0x8c1.ReqBody();
    oidb_0x8c1.UserDeviceInfo localUserDeviceInfo = new oidb_0x8c1.UserDeviceInfo();
    localUserDeviceInfo.int32_client_type.set(1);
    localUserDeviceInfo.uint32_instance_id.set(AppSetting.a());
    localUserDeviceInfo.uint32_portal.set(4);
    ((oidb_0x8c1.ReqBody)localObject).msg_req_info.set(localUserDeviceInfo);
    ((oidb_0x8c1.ReqBody)localObject).int32_is_super_love.set(paramInt);
    try
    {
      ((oidb_0x8c1.ReqBody)localObject).uint64_first_rater_tinyid.set(Long.parseLong(paramString));
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMatchPeopleInfo parseLong Failed :");
        localStringBuilder.append(localException);
        QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2241);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8c1.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(BaseApplication.getContext(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x8c1_1");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).setObserver(new NearbyJsInterface.5(this, paramString, paramBoolean));
    this.mRuntime.a().startServlet((NewIntent)localObject);
  }
  
  protected String getNameSpace()
  {
    return "nearby";
  }
  
  public void getNearbyPeopleAvatar(String paramString)
  {
    try
    {
      localObject1 = new JSONObject(paramString);
      this.e = ((JSONObject)localObject1).optString("callback");
      paramString = (INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
      localObject1 = ((JSONObject)localObject1).optString("tinyid");
      Object localObject2 = ImageUtil.c();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        long l = Long.parseLong((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = new NearByFaceDrawable((AppInterface)paramString, 32, 200, String.valueOf(l), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = new NearByFaceDrawable((AppInterface)paramString, 32, 200, this.mRuntime.a().getCurrentAccountUin(), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable.getLoadedBitmap();
      paramString = new ByteArrayOutputStream(1024);
      localObject1 = new StringBuilder("data:image/jpeg;base64,");
      if (localObject2 != null)
      {
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, paramString);
        ((StringBuilder)localObject1).append(Base64Util.encodeToString(paramString.toByteArray(), 2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", 0);
        ((JSONObject)localObject2).put("data", localObject1);
        callJs(this.e, new String[] { ((JSONObject)localObject2).toString() });
      }
      else
      {
        callJs(this.e, new String[] { "{\"ret\":1}" });
      }
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNearbyPeopleAvatar failed:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void getNearbyPublishBase64Images(String paramString)
  {
    try
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = NearbyPublishMenuHelper.a(((AppRuntime)localObject2).getAccount());
      NearbyPublishMenuHelper.b(((AppRuntime)localObject2).getAccount(), "");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getPicBase64, params=");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", picBase64.len=");
      ((StringBuilder)localObject2).append(((String)localObject1).length());
      QLog.d("NearbyPublishMenuHelper", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new JSONArray();
      ((JSONArray)localObject2).put(new JSONObject((String)localObject1));
      callJs(new JSONObject(paramString).optString("callback"), new String[] { "0", ((JSONArray)localObject2).toString() });
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPicBase64 OOM! err=");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.e("NearbyPublishMenuHelper", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getPicBase64 failed!, exp=");
      ((StringBuilder)localObject1).append(paramString.toString());
      QLog.e("NearbyPublishMenuHelper", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void getNearbyRedDotInfo(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNearbyRedDotInfo:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("appid");
      localObject = paramString.optString("callback");
      if ((i > 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = ((INearbyProcManager)((INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(NearbyConstants.e)).b(i);
        paramString = new JSONObject();
        if (localRedTypeInfo != null)
        {
          i = localRedTypeInfo.red_type.get();
          if (i == 0)
          {
            paramString.put("redDotType", 1);
          }
          else if (i == 5)
          {
            paramString.put("redDotType", 2);
            paramString.put("redDotNum", localRedTypeInfo.red_content.get());
          }
        }
        else
        {
          paramString.put("redDotType", 0);
        }
        callJs((String)localObject, new String[] { paramString.toString() });
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callJs: ret=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNearbyRedDotInfo exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void getPerformance(String paramString)
  {
    NearbyActivity localNearbyActivity;
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof NearbyActivity))) {
      localNearbyActivity = (NearbyActivity)this.mRuntime.a();
    } else {
      localNearbyActivity = null;
    }
    try
    {
      boolean bool = new JSONObject(paramString).getString("from").equals("now");
      if (!bool) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyJsInterface", 2, localJSONException, new Object[0]);
      }
      if (localNearbyActivity == null) {
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("mClickTime", localNearbyActivity.mNowClickTime);
        localJSONObject.put("mOnCreateMilliTimeStamp", localNearbyActivity.mNowOnCreateMilliTimeStamp);
        Object localObject = localNearbyActivity.getNowLivFramgent();
        if (localObject == null) {
          return;
        }
        localObject = ((NowLiveFragment)localObject).a;
        localJSONObject.put("mTimeBeforeLoadUrl", ((AbsWebView)localObject).getTimeBeforeLoadUrl());
        localJSONObject.put("mStartLoadUrlMilliTimeStamp", ((AbsWebView)localObject).getStartLoadUrlMilliTimeStamp());
        localJSONObject.put("mNowOnCreateTime", localNearbyActivity.mNowOnCreateTime);
        localJSONObject.put("mNowViewInflateTime", localNearbyActivity.mNowViewInflateTime);
        localJSONObject.put("mInitTime", localNearbyActivity.mNowInitTime);
        localJSONObject.put("mInitWebViewTime", localNearbyActivity.mNowInitWebViewTime);
        localJSONObject.put("isMainPageUseLocalFile", OfflinePlugin.a(((AbsWebView)localObject).mWebview));
        localJSONObject.put("mPerfFirstLoadTag", ((AbsWebView)localObject).isPerfFirstLoadTag());
        localJSONObject.put("isWebViewCache", WebAccelerateHelper.isWebViewCache);
        localJSONObject.put("OpenUrlAfterCheckOfflineTime", OfflinePlugin.a(((AbsWebView)localObject).mWebview));
        localJSONObject.put("ReadIndexFromOfflineTime", OfflinePlugin.b(((AbsWebView)localObject).mWebview));
        localJSONObject.put("IsReloadUrl", OfflinePlugin.b(((AbsWebView)localObject).mWebview));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyJsInterface", 2, localException, new Object[0]);
        }
      }
      try
      {
        callJs(new JSONObject(paramString).getString("callback"), new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
        }
      }
    }
  }
  
  public void getRedDotPushData(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      paramString = new Intent();
      paramString.setAction("com.tencent.biz.TroopRedpoint.TroopRedTouchManager");
      paramString.putExtra("request_type", 1);
      BaseApplicationImpl.getApplication().sendBroadcast(paramString);
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRedDotPushData failed ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("NearbyJsInterface", 1, localStringBuilder.toString());
    }
  }
  
  public void getSettingState(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        Object localObject2 = new JSONObject(paramString);
        paramString = ((JSONObject)localObject2).optString("callback");
        localObject2 = ((JSONObject)localObject2).optJSONArray("keys");
        JSONObject localJSONObject = new JSONObject();
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            String str = ((JSONArray)localObject2).optString(i);
            if (!"greetingsReceive".equals(str)) {
              break label168;
            }
            localJSONObject.put(str, ((SharedPreferences)localObject1).getString("nearby_settings_greetings_receive", "0"));
            break label168;
          }
        }
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Exception paramString)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getSettingState failed! msg = ");
          ((StringBuilder)localObject1).append(paramString.getMessage());
          QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      label168:
      i += 1;
    }
  }
  
  public void getSlidePosition(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSlidePosition: params=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (this.mRuntime.a() != null)
    {
      localObject = localStringBuilder;
      if ((this.mRuntime.a() instanceof NearbyActivity)) {
        localObject = (NearbyActivity)this.mRuntime.a();
      }
    }
    if (localObject != null)
    {
      localObject = ((NearbyActivity)localObject).getNearbyHybridFragment();
      int i;
      if (localObject != null) {
        i = ((NearbyHybridFragment)localObject).a();
      } else {
        i = 0;
      }
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("position", i);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("retJson=");
          localStringBuilder.append(localObject);
          QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
        }
        callJs(new JSONObject(paramString).optString("callback"), new String[] { ((JSONObject)localObject).toString() });
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getSlidePosition exp:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void listenRedDotPushData(String paramString)
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("listenRedDotPushData failed ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("NearbyJsInterface", 1, localStringBuilder.toString());
    }
  }
  
  public void nearbySafetyReport(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nearbySafetyReport params=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new JSONObject(paramString);
      localObject = paramString.optString("tinyId");
      l1 = 0L;
    }
    catch (Exception paramString)
    {
      Object localObject;
      long l1;
      long l2;
      label75:
      int i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("nearbySafetyReport exp=");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    try
    {
      l2 = Long.valueOf((String)localObject).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      break label75;
    }
    i = paramString.optInt("scene");
    localObject = paramString.optString("subapp");
    paramString = new ProfileCardUtil.ReportBundleBuilder().a(paramString.optString("text_evidence")).b(paramString.optString("img_evidence")).d(paramString.optString("video_evidence")).c(paramString.optString("url_evidence")).e(paramString.optString("file_evidence")).f(paramString.optString("audio_evidence")).g(paramString.optString("user_input_param")).a();
    NewReportPlugin.a((QBaseActivity)this.mRuntime.a(), l1, "0", null, i, (String)localObject, paramString);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, intent=");
      ((StringBuilder)localObject).append(paramIntent);
      ((StringBuilder)localObject).append(", requestCode=");
      ((StringBuilder)localObject).append(paramByte);
      ((StringBuilder)localObject).append(", resultCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.f))) {
      try
      {
        paramIntent = new JSONObject();
        if (paramInt == -1) {
          paramIntent.put("retcode", 0);
        } else {
          paramIntent.put("retcode", 1);
        }
        callJs(this.f, new String[] { paramIntent.toString() });
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callJs, mBindPhoneCallback=");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append(", ret=");
          ((StringBuilder)localObject).append(paramIntent);
          QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
        }
        this.f = "";
        return;
      }
      catch (Exception paramIntent)
      {
        this.f = "";
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onActivityResult, exp:");
          ((StringBuilder)localObject).append(paramIntent.toString());
          QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
    paramIntent = ((SharedPreferences)localObject).getString("nearby_now_edit_profile_js_callback", "");
    paramInt = ((SharedPreferences)localObject).getInt("nearby_now_edit_profile_code_int", 1);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("retcode", paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localObject);
    callJs(paramIntent, new String[] { localStringBuilder.toString() });
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    IntentFilter localIntentFilter = new IntentFilter("tribe_profile_edit_finish");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null) {
      ((TroopMemberApiClient)localObject).b();
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$MyNetEventHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetEventHandler((INetEventHandler)localObject);
    }
    b();
    super.onDestroy();
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable.getLoadedBitmap();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
        if (localObject != null)
        {
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
          localStringBuilder.append(Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
          localObject = new JSONObject();
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("data", localStringBuilder);
          callJs(this.e, new String[] { ((JSONObject)localObject).toString() });
        }
        else
        {
          callJs(this.e, new String[] { "{\"ret\":1}" });
        }
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNearbyPeopleAvatar failed:");
          localStringBuilder.append(localException);
          QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void openBindPhonePage(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openBindPhonePage:");
      localStringBuilder.append(paramString);
      QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
    }
    try
    {
      this.f = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.f))
      {
        paramString = new Intent(this.mRuntime.a(), BindNumberActivity.class);
        paramString.putExtra("kSrouce", 20);
        startActivityForResult(paramString, (byte)100);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("openBindPhonePage exp:");
        localStringBuilder.append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void openFreshDetail(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("feedId");
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://nearby.qq.com/fresh/detail.html?feed_id=");
      localStringBuilder.append(paramString);
      ((Intent)localObject).putExtra("url", localStringBuilder.toString());
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openFreshDetail failed: msg = ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void openInterestPeopleAio(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tinyid");
      this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("from");
      localObject = (NearbyJsInterface.MatchUserInfo)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
      if ((localObject != null) && (!TextUtils.isEmpty(((NearbyJsInterface.MatchUserInfo)localObject).jdField_a_of_type_JavaLangString)) && (!((NearbyJsInterface.MatchUserInfo)localObject).jdField_a_of_type_JavaLangString.equals("0")))
      {
        a((NearbyJsInterface.MatchUserInfo)localObject);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
      {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a((ArrayList)localObject, new NearbyJsInterface.3(this));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void openMatchPeopleAio(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("tinyid");
      int i = paramString.optInt("isSuperLove");
      this.jdField_a_of_type_Int = paramString.optInt("from");
      getMatchPeople(str, i);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void openMyVisitorList()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-visitor/index.html?_proxy=1&_wwv=128");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  public void openProfileCard(String paramString)
  {
    Object localObject1 = (INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Object localObject2 = (NearbyHandler)((INearbyAppInterface)localObject1).getBusinessHandler(NearbyConstants.jdField_a_of_type_JavaLangString);
    for (;;)
    {
      int i;
      int k;
      try
      {
        Object localObject3 = new JSONObject(paramString);
        localObject2 = ((JSONObject)localObject3).optString("uin");
        i = ((JSONObject)localObject3).optInt("mode", -1);
        int j = ((JSONObject)localObject3).optInt("source", 6);
        k = ((JSONObject)localObject3).optInt("from");
        l = ((JSONObject)localObject3).optLong("now_id", 0L);
        int m = ((JSONObject)localObject3).optInt("now_user_type", 0);
        Object localObject4 = ((JSONObject)localObject3).optString("callback");
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          this.c = ((String)localObject4);
        }
        try
        {
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
          paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject4);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        localObject4 = ((JSONObject)localObject3).optString("tinnyid");
        paramString = new StringBuffer();
        paramString.append("&source=");
        paramString.append(j);
        StringBuilder localStringBuilder;
        if (k != 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&from=");
          localStringBuilder.append(k);
          paramString.append(localStringBuilder.toString());
        }
        if (i != -1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&mode=");
          localStringBuilder.append(i);
          paramString.append(localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("&tinnyid=");
          localStringBuilder.append((String)localObject4);
          paramString.append(localStringBuilder.toString());
        }
        localObject3 = ((JSONObject)localObject3).optString("reportsource");
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("&reportsource=");
          ((StringBuilder)localObject4).append((String)localObject3);
          paramString.append(((StringBuilder)localObject4).toString());
        }
        paramString.append("&now_id=");
        paramString.append(l);
        paramString.append("&now_user_type=");
        paramString.append(m);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mqq://card/show_pslcard/?uin=");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("&card_type=nearby");
        ((StringBuilder)localObject3).append(paramString.toString());
        paramString = ((StringBuilder)localObject3).toString();
        if (!QLog.isColorLevel()) {
          break label686;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("openProfileCard, jumpUrl=");
        ((StringBuilder)localObject3).append(paramString);
        QLog.i("NearbyJsInterface", 2, ((StringBuilder)localObject3).toString());
      }
      catch (Exception paramString)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("openProfileCard failed! msg = ");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      l = Long.parseLong((String)localObject2);
      paramString = new NearbyJsInterface.8(this, (String)localObject2, k);
      NearbyHandler.a((INearbyAppInterface)localObject1, new long[] { l }, paramString);
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)), NearbyProfileCardConstants.b);
        return;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
      label686:
      if (i != 1) {
        if ((k != 1) && (k != 7) && (k != 8) && (k != 9) && (k != 10) && (k != 12) && (k != 20)) {
          if ((k < 21) || (k > 28)) {}
        }
      }
    }
  }
  
  public void openVideoChat(String paramString)
  {
    try
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("gender");
        i = 0;
      }
      catch (Exception paramString)
      {
        try
        {
          j = paramString.optInt("rank");
        }
        catch (JSONException paramString)
        {
          int i;
          int j;
          int m;
          int k;
          StringBuilder localStringBuilder;
          break label51;
        }
        try
        {
          m = paramString.optInt("age");
          k = i;
          i = m;
          m = i;
        }
        catch (JSONException paramString)
        {
          break label53;
        }
        paramString = paramString;
      }
    }
    catch (JSONException paramString)
    {
      label49:
      label51:
      label53:
      break label49;
    }
    j = 0;
    QLog.e("NearbyJsInterface", 1, "openVideoChat web params error!");
    m = 0;
    k = i;
    paramString = TroopMemberApiClient.a();
    paramString.a();
    paramString.c(new NearbyJsInterface.4(this, paramString, k, j, m));
    return;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("openVideoChat failed:");
      localStringBuilder.append(paramString);
      QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
    }
  }
  
  public void preloadImage(String paramString)
  {
    ThreadManager.post(new NearbyJsInterface.7(this, paramString, System.currentTimeMillis()), 8, null, true);
  }
  
  public void preloadVideos(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("videoArray");
      Object localObject;
      try
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("video_url", paramString);
        paramString = DataFactory.a("ipc_cmd_preload_video", "", 0, (Bundle)localObject);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadVideos failed! msg = ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void qbrowserNetworkChange(String paramString)
  {
    try
    {
      this.g = new JSONObject(paramString).optString("callback");
      a(-1, HttpUtil.getNetWorkType());
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$MyNetEventHandler == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$MyNetEventHandler = new NearbyJsInterface.MyNetEventHandler(this);
        AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyJsInterface$MyNetEventHandler);
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyJsInterface", 2, "qbrowserNetworkChange is called repeatedly");
        return;
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qbrowserNetworkChange failed! msg = ");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("NearbyJsInterface", 1, localStringBuilder.toString());
    }
  }
  
  public void reportFriend(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uin");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq://nearby/reportFriend/?uin=");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportFriend exception:");
        localStringBuilder.append(QLog.getStackTraceString(paramString));
        QLog.d("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setDeleteShortVideoCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_delete_success_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setDeleteShortVideoCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setEditProfileCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_edit_profile_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUpLoadVideoFinishedCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setLiveTabWebViewUrlParam(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setLiveTabWebViewUrlParam:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getLiveTabWebViewUrlByJson();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {}
    }
    catch (Exception paramString)
    {
      label102:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setLiveTabWebViewUrlParam exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).mergeJson((JSONObject)localObject, paramString);
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      break label102;
    }
    paramString = paramString.toString();
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).saveLiveTabWebViewUrlParam(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setLiveTabWebViewUrlParam:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      return;
    }
  }
  
  public void setPublishButton(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_click_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUpLoadVideoFinishedCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setSettingState(String paramString)
  {
    try
    {
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit();
      paramString = new JSONObject(paramString);
      if ("greetingsReceive".equals(paramString.optString("key")))
      {
        ((SharedPreferences.Editor)localObject).putString("nearby_settings_greetings_receive", paramString.optString("value"));
        if ("0".equals(paramString.optString("value")))
        {
          paramString = new Bundle();
          paramString.putBoolean("isOn", false);
          paramString = DataFactory.a("ipc_cmd_nearby_setting_change", null, 0, paramString);
          ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
        }
      }
      ((SharedPreferences.Editor)localObject).apply();
      return;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setSettingState failed! msg = ");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @TargetApi(23)
  public void setStatusBarTextDark(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setStatusBarTextDark: params=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        i = ((JSONObject)localObject).optInt("darkMode");
        localObject = this.mRuntime.a();
        if (ImmersiveUtils.supportStatusBarDarkMode())
        {
          localObject = ((Activity)localObject).getWindow();
          if (i != 1) {
            break label426;
          }
          bool1 = true;
          boolean bool2 = ImmersiveUtils.setStatusBarDarkMode((Window)localObject, bool1);
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("setStatusBarDarkMode isSucced=");
            ((StringBuilder)localObject).append(bool2);
            QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
            bool1 = bool2;
          }
        }
        else
        {
          if (Build.VERSION.SDK_INT < 23) {
            break label441;
          }
          if (i != 1) {
            break label431;
          }
          i = 9216;
          ((Activity)localObject).getWindow().getDecorView().setSystemUiVisibility(i);
          if (!QLog.isColorLevel()) {
            break label436;
          }
          QLog.d("NearbyJsInterface", 2, "setStatusBarDarkMode setSystemUiVisibility");
          break label436;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{\"ret\":");
        if (!bool1) {
          break label446;
        }
        i = 0;
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("}");
        callJs(paramString, new String[] { ((StringBuilder)localObject).toString() });
      }
      catch (Exception paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setStatusBarTextDark exp:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isKITKAT=");
        paramString.append(VersionUtils.i());
        paramString.append(", enableForMiUI=");
        paramString.append(ImmersiveUtils.enableStatusBarDarkModeForMIUI);
        paramString.append(", isMIUI=");
        paramString.append(SystemUtil.b());
        paramString.append(", isFlyme=");
        paramString.append(SystemUtil.d());
        paramString.append(", SDK_INT=");
        paramString.append(Build.VERSION.SDK_INT);
        QLog.d("NearbyJsInterface", 2, paramString.toString());
      }
      return;
      label426:
      boolean bool1 = false;
      continue;
      label431:
      int i = 0;
      continue;
      label436:
      bool1 = true;
      continue;
      label441:
      bool1 = false;
      continue;
      label446:
      i = -1;
    }
  }
  
  public void setUpLoadVideoFailedCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_failed_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUpLoadVideoFinishedCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setUpLoadVideoFinishedCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_now_publish_success_js_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setUpLoadVideoFinishedCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void setUrlParam(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUrlParam:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getNearbyTabUrlParams();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {}
    }
    catch (Exception paramString)
    {
      label102:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setNearbyTabUrlParams exp:");
        ((StringBuilder)localObject).append(paramString.toString());
        QLog.e("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      localObject = ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).mergeJson((JSONObject)localObject, paramString);
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      break label102;
    }
    paramString = paramString.toString();
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).saveNearbyTabUrlParams(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNearbyTabUrlParams:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
      return;
    }
  }
  
  public void setVideoEnterVisibility(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setVideoEnterVisibility    step1:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
    }
    String str = null;
    Object localObject = str;
    if (this.mRuntime.a() != null)
    {
      localObject = str;
      if ((this.mRuntime.a() instanceof NearbyActivity)) {
        localObject = (NearbyActivity)this.mRuntime.a();
      }
    }
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step2 activity not null");
      }
      localObject = ((NearbyActivity)localObject).getNearbyHybridFragment();
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step3 fragment not null");
        }
        try
        {
          paramString = new JSONObject(paramString);
          boolean bool = false;
          int i = paramString.optInt("visiable", 0);
          int j = paramString.optInt("faceScoreTalentState", 0);
          str = paramString.optString("jumpUrl");
          if (i != 0) {
            bool = true;
          }
          ((NearbyHybridFragment)localObject).a(bool, j, str);
          if (QLog.isColorLevel()) {
            QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility    step4 set success");
          }
          paramString = paramString.optJSONArray("menu");
          if (paramString != null)
          {
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(((AppRuntime)localObject).getAccount(), "key_nearby_publish_menu", paramString.toString());
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("menuItem=");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("NearbyJsInterface", 2, ((StringBuilder)localObject).toString());
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setVideoEnterVisibility exception:");
          ((StringBuilder)localObject).append(paramString.toString());
          QLog.e("NearbyJsInterface", 1, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void setViewChangeCallback(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("callback");
      BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit().putString("nearby_view_change_callback", paramString).commit();
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setViewChangeCallback failed! msg = ");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("NearbyJsInterface", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void shootAvatar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "shootAvatar");
    }
    INearbyAppInterface localINearbyAppInterface = (INearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).showPtvPanel(this.mRuntime.a(), (AppInterface)localINearbyAppInterface, 1);
  }
  
  public void showFilterAndExitSheet()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "showFilterAndExitSheet");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mRuntime.a() != null)
    {
      localObject1 = localObject2;
      if ((this.mRuntime.a() instanceof NearbyActivity)) {
        localObject1 = (NearbyActivity)this.mRuntime.a();
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((NearbyActivity)localObject1).getNearbyHybridFragment();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).m();
      }
    }
  }
  
  public void showGuideDownloadView(String paramString)
  {
    try
    {
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        return;
      }
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      paramString = new JSONObject(paramString).optJSONObject("nearby_guide_config");
      if (paramString == null)
      {
        QLog.e("NearbyJsInterface", 1, "showGuideDownloadView: there is no nearby_guide_config");
        return;
      }
      JSONObject localJSONObject = paramString.optJSONObject("alert_config");
      if (localJSONObject == null)
      {
        QLog.e("NearbyJsInterface", 1, "showGuideDownloadView: there is no alert_config");
        return;
      }
      paramString = CikeConfigData.a((Context)localObject, localJSONObject);
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localJSONObject.optInt("source"));
        localStringBuilder.append("");
        paramString.f = localStringBuilder.toString();
        localObject = new NearbyAppDownloadDialog((Context)localObject);
        ((NearbyAppDownloadDialog)localObject).a(paramString);
        ((NearbyAppDownloadDialog)localObject).show();
        return;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showGuideDownloadView failed! msg = ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("NearbyJsInterface", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void tribePersonalDataModify()
  {
    callJs("javascript:mqq.dispatchEvent(\"tribePersonalDataModify\")");
  }
  
  public void unlistenRedDotPushData(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void updateFollowStatus(String paramString)
  {
    try
    {
      Bundle localBundle = new Bundle();
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("targetuin");
      localObject = ((JSONObject)localObject).optString("tinyid");
      if (!TextUtils.isEmpty(paramString)) {
        localBundle.putString("targetuin", paramString);
      } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localBundle.putString("tinyid", (String)localObject);
      }
      paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, localBundle);
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface
 * JD-Core Version:    0.7.0.1
 */