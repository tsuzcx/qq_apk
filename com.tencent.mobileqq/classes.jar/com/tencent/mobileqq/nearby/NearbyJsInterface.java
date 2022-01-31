package com.tencent.mobileqq.nearby;

import aeul;
import aeuo;
import aeup;
import aeuq;
import aeur;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.fragment.MineFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.FaceDrawable.OnLoadingStateChangeListener;
import com.tencent.mobileqq.util.NearByFaceDrawable;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.ReqBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.UserDeviceInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyJsInterface
  extends JsWebViewPlugin
  implements FaceDrawable.OnLoadingStateChangeListener
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public TroopMemberApiClient a;
  AsynLoadDrawable jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = null;
  private String jdField_a_of_type_JavaLangString;
  public HashMap a;
  private String b;
  private String c;
  
  public NearbyJsInterface()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  private void a(aeur paramaeur)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openNearbyAio, from = " + this.jdField_a_of_type_Int);
    }
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_UIN", paramaeur.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin", paramaeur.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Int == 1) {}
    for (int i = 10002;; i = 1001)
    {
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("gender", 1);
      localIntent.addFlags(67108864);
      localActivity.startActivity(localIntent);
      return;
    }
  }
  
  public void clearFilterList(String paramString)
  {
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Object localObject = this.mRuntime.a();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "clearFilterList: param=" + paramString + ", app=" + localNearbyAppInterface + ", activity=" + localObject);
    }
    if ((localNearbyAppInterface != null) && ((localObject instanceof BaseActivity)))
    {
      paramString = (BaseActivity)localObject;
      if ((NetworkUtil.d(BaseApplication.getContext())) && (!paramString.isFinishing()))
      {
        localObject = (NearbyHandler)localNearbyAppInterface.a(3);
        if (localObject != null) {
          ((NearbyHandler)localObject).b();
        }
        MineFragment.a(localNearbyAppInterface);
        ThreadManager.getUIHandler().postDelayed(new aeuq(this, paramString), 300L);
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, paramString.getString(2131433227), 0).b(paramString.getTitleBarHeight());
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
      localObject1 = ((NearbyActivity)localObject1).a();
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
      this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void filterList(String paramString)
  {
    NearbyHandler localNearbyHandler = (NearbyHandler)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).a(3);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "save filterList: params=" + paramString);
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      if (((JSONObject)localObject).optInt("filter") == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyJsInterface", 2, "filter==0, return");
        }
      }
      else
      {
        int i = ((JSONObject)localObject).optInt("sex");
        int j = ((JSONObject)localObject).optInt("time");
        int k = ((JSONObject)localObject).optInt("age");
        int m = ((JSONObject)localObject).optInt("interest");
        int n = ((JSONObject)localObject).optInt("profession");
        int i1 = ((JSONObject)localObject).optInt("country");
        int i2 = ((JSONObject)localObject).optInt("province");
        int i3 = ((JSONObject)localObject).optInt("city");
        int i4 = ((JSONObject)localObject).optInt("contellation");
        paramString = ((JSONObject)localObject).optString("strCountry");
        String str1 = ((JSONObject)localObject).optString("strProvince");
        String str2 = ((JSONObject)localObject).optString("strCity");
        localObject = ((JSONObject)localObject).optString("callback");
        localNearbyHandler.a(i, j, k, m, n, i1, i2, i3, i4, paramString, str1, str2);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          callJs((String)localObject, new String[] { "" });
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyJsInterface", 2, "save filterList exp:", paramString);
      }
    }
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
      ((NewIntent)localObject).setObserver(new aeup(this, paramString));
      this.mRuntime.a().startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        try
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
          paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject);
          WebIPCOperator.a().a(paramString);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("NearbyJsInterface", 2, "followUser failed! json failed, msg = " + paramString.getMessage());
      return;
    }
  }
  
  public void getFilterList(String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof NearbyActivity)))
        {
          localObject2 = (NearbyActivity)this.mRuntime.a();
          String str = "";
          Object localObject1 = str;
          if (localObject2 != null)
          {
            localObject2 = ((NearbyActivity)localObject2).a();
            localObject1 = str;
            if (localObject2 != null)
            {
              localObject1 = ((NearbyHybridFragment)localObject2).a();
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("sex", ((NearPeopleFilters)localObject1).jdField_a_of_type_Int);
              ((JSONObject)localObject2).put("time", ((NearPeopleFilters)localObject1).jdField_b_of_type_Int);
              ((JSONObject)localObject2).put("age", ((NearPeopleFilters)localObject1).jdField_c_of_type_Int);
              ((JSONObject)localObject2).put("interest", ((NearPeopleFilters)localObject1).jdField_d_of_type_Int);
              ((JSONObject)localObject2).put("profession", ((NearPeopleFilters)localObject1).f);
              ((JSONObject)localObject2).put("country", localObject1.jdField_d_of_type_ArrayOfJavaLangString[0]);
              ((JSONObject)localObject2).put("province", localObject1.jdField_d_of_type_ArrayOfJavaLangString[1]);
              ((JSONObject)localObject2).put("city", localObject1.jdField_d_of_type_ArrayOfJavaLangString[2]);
              ((JSONObject)localObject2).put("contellation", ((NearPeopleFilters)localObject1).e);
              ((JSONObject)localObject2).put("strCountry", ((NearPeopleFilters)localObject1).jdField_b_of_type_JavaLangString);
              ((JSONObject)localObject2).put("strProvince", ((NearPeopleFilters)localObject1).jdField_c_of_type_JavaLangString);
              ((JSONObject)localObject2).put("strCity", ((NearPeopleFilters)localObject1).jdField_d_of_type_JavaLangString);
              localObject1 = ((JSONObject)localObject2).toString();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "getFilterList: param=" + paramString + ", ret=" + (String)localObject1);
          }
          callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject1 });
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "getFilterList exp:" + paramString.toString());
        return;
      }
      Object localObject2 = null;
    }
  }
  
  public void getLbsInfo(String paramString)
  {
    String str = "";
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.a();
      if (localSosoLbsInfo != null)
      {
        paramString = localSosoLbsInfo;
        if (localSosoLbsInfo.a != null) {}
      }
      else
      {
        paramString = SosoInterface.a();
      }
      if (paramString != null) {
        str = LbsUtils.a(paramString);
      }
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { str });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getMatchPeople(String paramString, int paramInt)
  {
    aeur localaeur = (aeur)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
    if ((localaeur != null) && (!TextUtils.isEmpty(localaeur.jdField_a_of_type_JavaLangString)) && (!localaeur.jdField_a_of_type_JavaLangString.equals("0")))
    {
      a(localaeur);
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
    Object localObject1 = new oidb_0x8c1.ReqBody();
    Object localObject2 = new oidb_0x8c1.UserDeviceInfo();
    ((oidb_0x8c1.UserDeviceInfo)localObject2).int32_client_type.set(1);
    ((oidb_0x8c1.UserDeviceInfo)localObject2).uint32_instance_id.set(AppSetting.jdField_a_of_type_Int);
    ((oidb_0x8c1.UserDeviceInfo)localObject2).uint32_portal.set(4);
    ((oidb_0x8c1.ReqBody)localObject1).msg_req_info.set((MessageMicro)localObject2);
    ((oidb_0x8c1.ReqBody)localObject1).int32_is_super_love.set(paramInt);
    try
    {
      ((oidb_0x8c1.ReqBody)localObject1).uint64_first_rater_tinyid.set(Long.parseLong(paramString));
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2241);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8c1.ReqBody)localObject1).toByteArray()));
      localObject1 = new NewIntent(BaseApplication.getContext(), ProtoServlet.class);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x8c1_1");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new aeuo(this, paramString, paramBoolean));
      this.mRuntime.a().startServlet((NewIntent)localObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "getMatchPeopleInfo parseLong Failed :" + localException);
        }
      }
    }
  }
  
  protected String getNameSpace()
  {
    return "nearby";
  }
  
  public void getNearbyPeopleAvatar(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramString);
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("callback");
        paramString = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
        localObject1 = ((JSONObject)localObject1).optString("tinyid");
        localObject2 = ImageUtil.c();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = new NearByFaceDrawable(paramString, 32, 202, String.valueOf(Long.parseLong((String)localObject1)), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable.a();
        paramString = new ByteArrayOutputStream(1024);
        localObject1 = new StringBuilder("data:image/jpeg;base64,");
        if (localObject2 == null) {
          continue;
        }
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, paramString);
        ((StringBuilder)localObject1).append(Base64Util.encodeToString(paramString.toByteArray(), 2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", 0);
        ((JSONObject)localObject2).put("data", localObject1);
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
      }
      catch (Exception paramString)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("NearbyJsInterface", 2, "getNearbyPeopleAvatar failed:" + paramString);
        return;
        callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"ret\":1}" });
        continue;
      }
      paramString.flush();
      paramString.close();
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable = new NearByFaceDrawable(paramString, 32, 200, this.mRuntime.a().getCurrentAccountUin(), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
    }
  }
  
  public void getPerformance(String paramString)
  {
    if ((this.mRuntime.a() != null) && ((this.mRuntime.a() instanceof NearbyActivity))) {}
    Object localObject1;
    for (NearbyActivity localNearbyActivity = (NearbyActivity)this.mRuntime.a();; localObject1 = null)
    {
      do
      {
        for (;;)
        {
          JSONObject localJSONObject;
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
              continue;
            }
            localJSONObject = new JSONObject();
          }
          try
          {
            localJSONObject.put("mClickTime", localNearbyActivity.a);
            localJSONObject.put("mOnCreateMilliTimeStamp", localNearbyActivity.b);
            Object localObject2 = localNearbyActivity.a();
            if (localObject2 != null)
            {
              localObject2 = ((NowLiveFragment)localObject2).a;
              localJSONObject.put("mTimeBeforeLoadUrl", ((AbsWebView)localObject2).c());
              localJSONObject.put("mStartLoadUrlMilliTimeStamp", ((AbsWebView)localObject2).c);
              localJSONObject.put("mNowOnCreateTime", localNearbyActivity.c);
              localJSONObject.put("mNowViewInflateTime", localNearbyActivity.d);
              localJSONObject.put("mInitTime", localNearbyActivity.e);
              localJSONObject.put("mInitWebViewTime", localNearbyActivity.f);
              localJSONObject.put("isMainPageUseLocalFile", ((AbsWebView)localObject2).d());
              localJSONObject.put("mPerfFirstLoadTag", ((AbsWebView)localObject2).f());
              localJSONObject.put("isWebViewCache", WebAccelerateHelper.isWebViewCache);
              localJSONObject.put("OpenUrlAfterCheckOfflineTime", ((AbsWebView)localObject2).a());
              localJSONObject.put("ReadIndexFromOfflineTime", ((AbsWebView)localObject2).b());
              localJSONObject.put("IsReloadUrl", ((AbsWebView)localObject2).e());
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("NearbyJsInterface", 2, localException, new Object[0]);
              }
            }
          }
        }
        try
        {
          callJs(new JSONObject(paramString).getString("callback"), new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramString) {}
      } while (!QLog.isColorLevel());
      QLog.e("NearbyJsInterface", 2, paramString, new Object[0]);
      return;
    }
  }
  
  public void getSlidePosition(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "getSlidePosition: params=" + paramString);
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
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 == null) {
        break label208;
      }
    }
    label208:
    for (int i = ((NearbyHybridFragment)localObject1).a();; i = 0) {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("position", i);
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "retJson=" + localObject1);
        }
        callJs(new JSONObject(paramString).optString("callback"), new String[] { ((JSONObject)localObject1).toString() });
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("NearbyJsInterface", 2, "getSlidePosition exp:" + paramString.toString());
        return;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "onActivityResult, intent=" + paramIntent + ", requestCode=" + paramByte + ", resultCode=" + paramInt);
    }
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
    {
      try
      {
        paramIntent = new JSONObject();
        if (paramInt == -1) {
          paramIntent.put("retcode", 0);
        }
        for (;;)
        {
          callJs(this.jdField_c_of_type_JavaLangString, new String[] { paramIntent.toString() });
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "callJs, mBindPhoneCallback=" + this.jdField_c_of_type_JavaLangString + ", ret=" + paramIntent);
          }
          this.jdField_c_of_type_JavaLangString = "";
          return;
          paramIntent.put("retcode", 1);
        }
        QLog.e("NearbyJsInterface", 2, "onActivityResult, exp:" + paramIntent.toString());
      }
      catch (Exception paramIntent)
      {
        this.jdField_c_of_type_JavaLangString = "";
        if (!QLog.isColorLevel()) {
          return;
        }
      }
    }
    else
    {
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
      paramIntent = ((SharedPreferences)localObject).getString("nearby_now_edit_profile_js_callback", "");
      paramInt = ((SharedPreferences)localObject).getInt("nearby_now_edit_profile_code_int", 1);
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("retcode", paramInt);
        callJs(paramIntent, new String[] { "" + localObject });
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilAsynLoadDrawable.a();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        StringBuilder localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
        if (localObject != null)
        {
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
          localStringBuilder.append(Base64Util.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
          localObject = new JSONObject();
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("data", localStringBuilder);
          callJs(this.jdField_b_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
        }
        for (;;)
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          return;
          callJs(this.jdField_b_of_type_JavaLangString, new String[] { "{\"ret\":1}" });
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "getNearbyPeopleAvatar failed:" + localException);
        }
      }
    }
  }
  
  public void openBindPhonePage(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openBindPhonePage:" + paramString);
    }
    try
    {
      this.jdField_c_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        paramString = new Intent(this.mRuntime.a(), BindNumberActivity.class);
        paramString.putExtra("kSrouce", 20);
        startActivityForResult(paramString, (byte)100);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "openBindPhonePage exp:" + paramString.toString());
    }
  }
  
  public void openFreshDetail(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("feedId");
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://nearby.qq.com/fresh/detail.html?feed_id=" + paramString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "openFreshDetail failed: msg = " + paramString.getMessage());
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
    Intent localIntent = new Intent(this.mRuntime.a(), NearbyVisitorListActivity.class);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  public void openProfileCard(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).optString("uin");
      int i = ((JSONObject)localObject).optInt("mode", -1);
      int j = ((JSONObject)localObject).optInt("from");
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("targetuin", new JSONObject(paramString).getString("targetuin"));
        paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, localBundle);
        WebIPCOperator.a().a(paramString);
        paramString = ((JSONObject)localObject).optString("tinnyid");
        localObject = new StringBuffer();
        if (j != 0) {
          ((StringBuffer)localObject).append("&from=" + j);
        }
        if (i != -1) {
          ((StringBuffer)localObject).append("&mode=" + i);
        }
        if (!TextUtils.isEmpty(paramString)) {
          ((StringBuffer)localObject).append("&tinnyid=" + paramString);
        }
        paramString = "mqq://card/show_pslcard/?uin=" + str + "&card_type=nearby" + ((StringBuffer)localObject).toString();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
        {
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)), 32357);
          return;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("NearbyJsInterface", 2, "openProfileCard failed! msg = " + paramString.getMessage());
        return;
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)));
      }
    }
  }
  
  public void openVideoChat(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        j = paramString.optInt("gender");
      }
      catch (Exception paramString)
      {
        int k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyJsInterface", 2, "openVideoChat failed:" + paramString);
        return;
        return;
      }
      catch (JSONException paramString)
      {
        int i = 0;
        int j = 0;
        continue;
      }
      try
      {
        i = paramString.optInt("rank");
      }
      catch (JSONException paramString)
      {
        i = 0;
        continue;
      }
      try
      {
        k = paramString.optInt("age");
        paramString = TroopMemberApiClient.a();
        paramString.a();
        paramString.c(new aeul(this, paramString, j, i, k));
        return;
      }
      catch (JSONException paramString)
      {
        continue;
      }
      QLog.e("NearbyJsInterface", 1, "openVideoChat web params error!");
      k = 0;
    }
  }
  
  public void preloadImage(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("imageArray");
      }
      catch (Exception paramString)
      {
        Bundle localBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "preloadImage failed! msg = " + paramString.getMessage());
      }
      try
      {
        localBundle = new Bundle();
        localBundle.putString("pic_url", paramString);
        paramString = DataFactory.a("ipc_cmd_preload_image", "", 0, localBundle);
        WebIPCOperator.a().a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  public void preloadVideos(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("videoArray");
      }
      catch (Exception paramString)
      {
        Bundle localBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "preloadVideos failed! msg = " + paramString.getMessage());
      }
      try
      {
        localBundle = new Bundle();
        localBundle.putString("video_url", paramString);
        paramString = DataFactory.a("ipc_cmd_preload_video", "", 0, localBundle);
        WebIPCOperator.a().a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setDeleteShortVideoCallback failed! msg = " + paramString.getMessage());
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  @TargetApi(23)
  public void setStatusBarTextDark(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangString = paramString.optString("callback");
        i = paramString.optInt("darkMode");
        paramString = this.mRuntime.a();
        if (!ImmersiveUtils.a()) {
          continue;
        }
        paramString = paramString.getWindow();
        if (i != 1) {
          break label182;
        }
        bool1 = ImmersiveUtils.a(paramString, bool1);
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder;
        if (!QLog.isColorLevel()) {
          continue;
        }
        return;
        int i = 0;
        continue;
        i = -1;
        continue;
        bool1 = false;
        continue;
        return;
      }
      paramString = this.jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("{\"ret\":");
      if (bool1)
      {
        i = j;
        callJs(paramString, new String[] { i + "}" });
        return;
        if (Build.VERSION.SDK_INT < 23) {
          continue;
        }
        if (i == 1)
        {
          i = 9216;
          paramString.getWindow().getDecorView().setSystemUiVisibility(i);
          bool1 = bool2;
          continue;
        }
      }
      label182:
      bool1 = false;
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setUrlParam(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "setUrlParam:" + paramString);
    }
    do
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramString.optString(str1);
          localStringBuilder.append("&");
          localStringBuilder.append(str1);
          localStringBuilder.append("=");
          localStringBuilder.append(str2);
        }
        paramString = localStringBuilder.toString();
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NearbyJsInterface", 2, "setNearbyTabUrlParams exp:" + paramString.toString());
        }
        return;
      }
      NearbySPUtil.d(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyJsInterface", 2, "setNearbyTabUrlParams:" + paramString);
  }
  
  public void setVideoEnterVisibility(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep1:" + paramString);
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
      if (QLog.isColorLevel()) {
        QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep2 activity not null");
      }
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 != null) {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep3 fragment not null");
        }
      }
    }
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.optInt("visiable", 0);
      int j = paramString.optInt("faceScoreTalentState", 0);
      paramString = paramString.optString("jumpUrl");
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((NearbyHybridFragment)localObject1).a(bool, j, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep4 set success");
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "setVideoEnterVisibility exception:" + paramString.toString());
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setViewChangeCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void shootAvatar()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "shootAvatar");
    }
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    NearbyVideoUtils.a(this.mRuntime.a(), localNearbyAppInterface, 1);
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
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).n();
      }
    }
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
      }
      for (;;)
      {
        paramString = DataFactory.a("ipc_should_refresh_cardinfo", "", 0, localBundle);
        WebIPCOperator.a().a(paramString);
        return;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localBundle.putString("tinyid", (String)localObject);
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface
 * JD-Core Version:    0.7.0.1
 */