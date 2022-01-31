package com.tencent.mobileqq.nearby;

import alxp;
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
import apml;
import aprh;
import asfu;
import autz;
import auuf;
import auuh;
import auvc;
import auvd;
import auve;
import auvf;
import auvi;
import auvj;
import auvk;
import auvl;
import auvm;
import auwq;
import auxb;
import avbh;
import avtq;
import avtz;
import bdaf;
import bdbl;
import bdcx;
import bddf;
import bddg;
import bdep;
import bdfr;
import bdhj;
import bdin;
import beej;
import befl;
import begz;
import bhtb;
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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NowLiveFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mzx;
import ndd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.ReqBody;
import tencent.im.oidb.cmd0x8c1.oidb_0x8c1.UserDeviceInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import yqz;

public class NearbyJsInterface
  extends befl
  implements bdbl
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new auvc(this);
  public Context a;
  private auvm jdField_a_of_type_Auvm;
  bdaf jdField_a_of_type_Bdaf = null;
  private String jdField_a_of_type_JavaLangString = "";
  public HashMap<String, auvl> a;
  public yqz a;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new auvd(this);
  private String jdField_b_of_type_JavaLangString = "";
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  
  public NearbyJsInterface()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
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
      callJs(this.f, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("NearbyJsInterface", 1, "notifyWebNetworkChange exception: " + localJSONException.toString());
      }
    }
  }
  
  private void a(auvl paramauvl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "openNearbyAio, from = " + this.jdField_a_of_type_Int);
    }
    Activity localActivity = this.mRuntime.a();
    Intent localIntent = new Intent(localActivity, ChatActivity.class);
    localIntent.putExtra("PREVIOUS_UIN", paramauvl.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin", paramauvl.jdField_a_of_type_JavaLangString);
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
  
  private void b()
  {
    BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void clearFilterList(String paramString)
  {
    Object localObject = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Activity localActivity = this.mRuntime.a();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "clearFilterList: param=" + paramString + ", app=" + localObject + ", activity=" + localActivity);
    }
    if ((localObject != null) && ((localActivity instanceof BaseActivity)))
    {
      paramString = (BaseActivity)localActivity;
      if ((bdin.d(BaseApplication.getContext())) && (!paramString.isFinishing()))
      {
        asfu.a((NearbyAppInterface)localObject);
        localObject = new Intent(paramString, NearbyActivity.class);
        ((Intent)localObject).setFlags(67108864);
        ((Intent)localObject).putExtra("key_from_location", true);
        paramString.startActivity((Intent)localObject);
      }
    }
    else
    {
      return;
    }
    QQToast.a(BaseApplication.getContext(), 1, paramString.getString(2131694766), 0).b(paramString.getTitleBarHeight());
  }
  
  public void clearUnReadRedTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "clearUnReadRedTouch:" + paramString);
    }
    try
    {
      int i = new JSONObject(paramString).optInt("appid");
      ((avbh)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(214)).a(i);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "clearUnReadRedTouch exp:" + paramString.toString());
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
      localObject1 = ((NearbyActivity)localObject1).a();
      if (localObject1 != null) {
        ((NearbyHybridFragment)localObject1).q();
      }
    }
  }
  
  public void createMsgFromOther(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_c_of_type_JavaLangString = paramString.optString("callback");
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
    if (this.jdField_a_of_type_Yqz == null)
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("schoolName");
      int i = paramString.optInt("isValid");
      this.jdField_a_of_type_Yqz.c(str, i);
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
    alxp localalxp = (alxp)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).a(3);
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
        localalxp.a(i, j, k, m, n, i1, i2, i3, i4, paramString, str1, str2);
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
    Object localObject = new NewIntent(this.mRuntime.a().getApplication().getApplicationContext(), mzx.class);
    ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.follow_user");
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localJSONObject.remove("callback");
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      ((NewIntent)localObject).putExtra("data", localWebSsoRequestBody.toByteArray());
      ((NewIntent)localObject).setObserver(new auvj(this, paramString));
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
          paramString = apml.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject);
          aprh.a().a(paramString);
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
              ((JSONObject)localObject2).put("sex", ((auuh)localObject1).jdField_a_of_type_Int);
              ((JSONObject)localObject2).put("time", ((auuh)localObject1).jdField_b_of_type_Int);
              ((JSONObject)localObject2).put("age", ((auuh)localObject1).jdField_c_of_type_Int);
              ((JSONObject)localObject2).put("interest", ((auuh)localObject1).jdField_d_of_type_Int);
              ((JSONObject)localObject2).put("profession", ((auuh)localObject1).f);
              ((JSONObject)localObject2).put("country", localObject1.jdField_d_of_type_ArrayOfJavaLangString[0]);
              ((JSONObject)localObject2).put("province", localObject1.jdField_d_of_type_ArrayOfJavaLangString[1]);
              ((JSONObject)localObject2).put("city", localObject1.jdField_d_of_type_ArrayOfJavaLangString[2]);
              ((JSONObject)localObject2).put("contellation", ((auuh)localObject1).e);
              ((JSONObject)localObject2).put("strCountry", ((auuh)localObject1).jdField_b_of_type_JavaLangString);
              ((JSONObject)localObject2).put("strProvince", ((auuh)localObject1).jdField_c_of_type_JavaLangString);
              ((JSONObject)localObject2).put("strCity", ((auuh)localObject1).jdField_d_of_type_JavaLangString);
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
  
  public void getFilterListV2(String paramString)
  {
    Object localObject = "";
    try
    {
      auuh localauuh = auuh.a(this.mRuntime.a().getCurrentAccountUin());
      if (localauuh != null)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("sex", localauuh.jdField_a_of_type_Int);
        ((JSONObject)localObject).put("time", localauuh.jdField_b_of_type_Int);
        ((JSONObject)localObject).put("age", localauuh.jdField_c_of_type_Int);
        ((JSONObject)localObject).put("interest", localauuh.jdField_d_of_type_Int);
        ((JSONObject)localObject).put("profession", localauuh.f);
        ((JSONObject)localObject).put("country", localauuh.jdField_d_of_type_ArrayOfJavaLangString[0]);
        ((JSONObject)localObject).put("province", localauuh.jdField_d_of_type_ArrayOfJavaLangString[1]);
        ((JSONObject)localObject).put("city", localauuh.jdField_d_of_type_ArrayOfJavaLangString[2]);
        ((JSONObject)localObject).put("contellation", localauuh.e);
        ((JSONObject)localObject).put("strCountry", localauuh.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject).put("strProvince", localauuh.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject).put("strCity", localauuh.jdField_d_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "getFilterListV2: param=" + paramString + ", ret=" + (String)localObject);
      }
      callJs(new JSONObject(paramString).optString("callback"), new String[] { localObject });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "getFilterListV2 exp:" + paramString.toString());
    }
  }
  
  public void getLbsInfo(String paramString)
  {
    String str = "";
    try
    {
      this.jdField_c_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
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
        str = auuf.a(paramString);
      }
      callJs(this.jdField_c_of_type_JavaLangString, new String[] { str });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getMatchPeople(String paramString, int paramInt)
  {
    auvl localauvl = (auvl)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
    if ((localauvl != null) && (!TextUtils.isEmpty(localauvl.jdField_a_of_type_JavaLangString)) && (!localauvl.jdField_a_of_type_JavaLangString.equals("0")))
    {
      a(localauvl);
      return;
    }
    getMatchPeopleInfo(paramString, true, paramInt);
  }
  
  public void getMatchPeopleInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_Yqz == null)
    {
      this.jdField_a_of_type_Yqz = yqz.a();
      this.jdField_a_of_type_Yqz.a();
    }
    Object localObject1 = new oidb_0x8c1.ReqBody();
    Object localObject2 = new oidb_0x8c1.UserDeviceInfo();
    ((oidb_0x8c1.UserDeviceInfo)localObject2).int32_client_type.set(1);
    ((oidb_0x8c1.UserDeviceInfo)localObject2).uint32_instance_id.set(AppSetting.a());
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
      localObject1 = new NewIntent(BaseApplication.getContext(), mzx.class);
      ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x8c1_1");
      ((NewIntent)localObject1).putExtra("data", ((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new auvi(this, paramString, paramBoolean));
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
  
  public String getNameSpace()
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
        this.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("callback");
        paramString = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
        localObject1 = ((JSONObject)localObject1).optString("tinyid");
        localObject2 = bdhj.c();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        this.jdField_a_of_type_Bdaf = new bdcx(paramString, 32, 202, String.valueOf(Long.parseLong((String)localObject1)), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
        localObject2 = this.jdField_a_of_type_Bdaf.a();
        paramString = new ByteArrayOutputStream(1024);
        localObject1 = new StringBuilder("data:image/jpeg;base64,");
        if (localObject2 == null) {
          continue;
        }
        ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, paramString);
        ((StringBuilder)localObject1).append(bdfr.encodeToString(paramString.toByteArray(), 2));
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ret", 0);
        ((JSONObject)localObject2).put("data", localObject1);
        callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject2).toString() });
      }
      catch (Exception paramString)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("NearbyJsInterface", 2, "getNearbyPeopleAvatar failed:" + paramString);
        return;
        callJs(this.jdField_d_of_type_JavaLangString, new String[] { "{\"ret\":1}" });
        continue;
      }
      paramString.flush();
      paramString.close();
      return;
      this.jdField_a_of_type_Bdaf = new bdcx(paramString, 32, 200, this.mRuntime.a().getCurrentAccountUin(), (byte)1, 3, true, (Drawable)localObject2, (Drawable)localObject2, this, false);
    }
  }
  
  public void getNearbyPublishBase64Images(String paramString)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      String str = avtz.a(((AppRuntime)localObject).getAccount());
      avtz.b(((AppRuntime)localObject).getAccount(), "");
      QLog.d("NearbyPublishMenuHelper", 1, "getPicBase64, params=" + paramString + ", picBase64.len=" + str.length());
      localObject = new JSONArray();
      ((JSONArray)localObject).put(new JSONObject(str));
      callJs(new JSONObject(paramString).optString("callback"), new String[] { "0", ((JSONArray)localObject).toString() });
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "getPicBase64 failed!, exp=" + paramString.toString());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("NearbyPublishMenuHelper", 1, "getPicBase64 OOM! err=" + paramString.toString());
    }
  }
  
  public void getNearbyRedDotInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "getNearbyRedDotInfo:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("appid");
        paramString = paramString.optString("callback");
        if ((i <= 0) || (TextUtils.isEmpty(paramString))) {
          return;
        }
        localRedTypeInfo = ((avbh)((NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby")).getManager(214)).b(i);
        localJSONObject = new JSONObject();
        if (localRedTypeInfo == null) {
          continue;
        }
        i = localRedTypeInfo.red_type.get();
        if (i != 0) {
          continue;
        }
        localJSONObject.put("redDotType", 1);
      }
      catch (Exception paramString)
      {
        int i;
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo;
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("NearbyJsInterface", 2, "getNearbyRedDotInfo exp:" + paramString.toString());
        return;
        localJSONObject.put("redDotType", 0);
        continue;
      }
      callJs(paramString, new String[] { localJSONObject.toString() });
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("NearbyJsInterface", 2, "callJs: ret=" + localJSONObject);
      return;
      if (i == 5)
      {
        localJSONObject.put("redDotType", 2);
        localJSONObject.put("redDotNum", localRedTypeInfo.red_content.get());
      }
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
              localJSONObject.put("mTimeBeforeLoadUrl", ((beej)localObject2).getmTimeBeforeLoadUrl());
              localJSONObject.put("mStartLoadUrlMilliTimeStamp", ((beej)localObject2).mStartLoadUrlMilliTimeStamp);
              localJSONObject.put("mNowOnCreateTime", localNearbyActivity.c);
              localJSONObject.put("mNowViewInflateTime", localNearbyActivity.d);
              localJSONObject.put("mInitTime", localNearbyActivity.e);
              localJSONObject.put("mInitWebViewTime", localNearbyActivity.f);
              localJSONObject.put("isMainPageUseLocalFile", ((beej)localObject2).isMainPageUseLocalFile());
              localJSONObject.put("mPerfFirstLoadTag", ((beej)localObject2).ismPerfFirstLoadTag());
              localJSONObject.put("isWebViewCache", WebAccelerateHelper.isWebViewCache);
              localJSONObject.put("OpenUrlAfterCheckOfflineTime", ((beej)localObject2).getOpenUrlAfterCheckOfflineTime());
              localJSONObject.put("ReadIndexFromOfflineTime", ((beej)localObject2).getReadIndexFromOfflineTime());
              localJSONObject.put("IsReloadUrl", ((beej)localObject2).getIsReloadUrl());
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
      QLog.e("NearbyJsInterface", 1, "getRedDotPushData failed " + paramString.getMessage());
    }
  }
  
  public void getSettingState(String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4);
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        localObject = ((JSONObject)localObject).optJSONArray("keys");
        JSONObject localJSONObject = new JSONObject();
        if ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          String str = ((JSONArray)localObject).optString(i);
          if ("greetingsReceive".equals(str)) {
            localJSONObject.put(str, localSharedPreferences.getString("nearby_settings_greetings_receive", "0"));
          }
        }
        else
        {
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NearbyJsInterface", 2, "getSettingState failed! msg = " + paramString.getMessage());
        return;
      }
      i += 1;
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
        break label209;
      }
    }
    label209:
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
  
  public void listenRedDotPushData(String paramString)
  {
    try
    {
      this.jdField_b_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "listenRedDotPushData failed " + paramString.getMessage());
    }
  }
  
  public void nearbySafetyReport(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "nearbySafetyReport params=" + paramString);
      }
      paramString = new JSONObject(paramString);
      str = paramString.optString("tinyId");
      l1 = 0L;
    }
    catch (Exception paramString)
    {
      String str;
      long l1;
      long l2;
      label65:
      int i;
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "nearbySafetyReport exp=" + paramString.toString());
      return;
    }
    try
    {
      l2 = Long.valueOf(str).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      break label65;
    }
    i = paramString.optInt("scene");
    str = paramString.optString("subapp");
    paramString = new bddg().a(paramString.optString("text_evidence")).b(paramString.optString("img_evidence")).d(paramString.optString("video_evidence")).c(paramString.optString("url_evidence")).e(paramString.optString("file_evidence")).f(paramString.optString("audio_evidence")).g(paramString.optString("user_input_param")).a();
    bddf.a((BaseActivity)this.mRuntime.a(), l1, "0", null, i, str, paramString);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "onActivityResult, intent=" + paramIntent + ", requestCode=" + paramByte + ", resultCode=" + paramInt);
    }
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.e)))
    {
      try
      {
        paramIntent = new JSONObject();
        if (paramInt == -1) {
          paramIntent.put("retcode", 0);
        }
        for (;;)
        {
          callJs(this.e, new String[] { paramIntent.toString() });
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "callJs, mBindPhoneCallback=" + this.e + ", ret=" + paramIntent);
          }
          this.e = "";
          return;
          paramIntent.put("retcode", 1);
        }
        QLog.e("NearbyJsInterface", 2, "onActivityResult, exp:" + paramIntent.toString());
      }
      catch (Exception paramIntent)
      {
        this.e = "";
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
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a();
    IntentFilter localIntentFilter = new IntentFilter("tribe_profile_edit_finish");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Yqz != null) {
      this.jdField_a_of_type_Yqz.b();
    }
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_Auvm != null) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_Auvm);
    }
    b();
    super.onDestroy();
  }
  
  public void onLoadingStateChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Bdaf.a();
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
        StringBuilder localStringBuilder = new StringBuilder("data:image/jpeg;base64,");
        if (localObject != null)
        {
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
          localStringBuilder.append(bdfr.encodeToString(localByteArrayOutputStream.toByteArray(), 2));
          localObject = new JSONObject();
          ((JSONObject)localObject).put("ret", 0);
          ((JSONObject)localObject).put("data", localStringBuilder);
          callJs(this.jdField_d_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
        }
        for (;;)
        {
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          return;
          callJs(this.jdField_d_of_type_JavaLangString, new String[] { "{\"ret\":1}" });
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
      this.e = new JSONObject(paramString).optString("callback");
      if (!TextUtils.isEmpty(this.e))
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
  
  public void openInterestPeopleAio(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tinyid");
      this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("from");
      localObject = (auvl)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(paramString));
      if ((localObject != null) && (!TextUtils.isEmpty(((auvl)localObject).jdField_a_of_type_JavaLangString)) && (!((auvl)localObject).jdField_a_of_type_JavaLangString.equals("0")))
      {
        a((auvl)localObject);
        return;
      }
      if (this.jdField_a_of_type_Yqz == null)
      {
        this.jdField_a_of_type_Yqz = yqz.a();
        this.jdField_a_of_type_Yqz.a();
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString);
      this.jdField_a_of_type_Yqz.a((ArrayList)localObject, new auve(this));
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
    NearbyAppInterface localNearbyAppInterface = (NearbyAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("module_nearby");
    Object localObject1 = (alxp)localNearbyAppInterface.a(3);
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = ((JSONObject)localObject2).optString("uin");
        i = ((JSONObject)localObject2).optInt("mode", -1);
        j = ((JSONObject)localObject2).optInt("from");
        l = ((JSONObject)localObject2).optLong("now_id", 0L);
        k = ((JSONObject)localObject2).optInt("now_user_type", 0);
      }
      catch (Exception paramString)
      {
        Object localObject2;
        int i;
        int j;
        long l;
        int k;
        Object localObject3;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("NearbyJsInterface", 2, "openProfileCard failed! msg = " + paramString.getMessage());
        return;
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          continue;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)), 32357);
        return;
        this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)));
        return;
        if (i == 1) {
          continue;
        }
        if ((j == 1) || (j == 7) || (j == 8) || (j == 9) || (j == 10) || (j == 12) || (j == 20)) {
          continue;
        }
        if ((j < 21) || (j > 28)) {
          continue;
        }
        continue;
      }
      try
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("targetuin", new JSONObject(paramString).getString("targetuin"));
        paramString = apml.a("ipc_should_refresh_cardinfo", "", 0, (Bundle)localObject3);
        aprh.a().a(paramString);
        localObject3 = ((JSONObject)localObject2).optString("tinnyid");
        paramString = new StringBuffer();
        if (j != 0) {
          paramString.append("&from=" + j);
        }
        if (i != -1) {
          paramString.append("&mode=" + i);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramString.append("&tinnyid=" + (String)localObject3);
        }
        localObject2 = ((JSONObject)localObject2).optString("reportsource");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString.append("&reportsource=" + (String)localObject2);
        }
        paramString.append("&now_id=").append(l);
        paramString.append("&now_user_type=").append(k);
        paramString = "mqq://card/show_pslcard/?uin=" + (String)localObject1 + "&card_type=nearby" + paramString.toString();
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyJsInterface", 2, "openProfileCard, jumpUrl=" + paramString);
          continue;
          l = Long.parseLong((String)localObject1);
          paramString = new auvk(this, (String)localObject1, j);
          alxp.a(localNearbyAppInterface, new long[] { l }, paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
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
        paramString = yqz.a();
        paramString.a();
        paramString.c(new auvf(this, paramString, j, i, k));
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
    ThreadManager.post(new NearbyJsInterface.7(this, paramString, System.currentTimeMillis()), 8, null, true);
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
        paramString = apml.a("ipc_cmd_preload_video", "", 0, localBundle);
        aprh.a().a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  public void qbrowserNetworkChange(String paramString)
  {
    try
    {
      this.f = new JSONObject(paramString).optString("callback");
      a(-1, ndd.a());
      if (this.jdField_a_of_type_Auvm == null)
      {
        this.jdField_a_of_type_Auvm = new auvm(this);
        AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Auvm);
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
      QLog.e("NearbyJsInterface", 1, "qbrowserNetworkChange failed! msg = " + paramString.getMessage());
    }
  }
  
  public void reportFriend(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("uin");
      paramString = "mqq://nearby/reportFriend/?uin=" + paramString;
      this.jdField_a_of_type_AndroidContentContext.startActivity(new Intent(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class).setData(Uri.parse(paramString)));
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NearbyJsInterface", 2, "reportFriend exception:" + QLog.getStackTraceString(paramString));
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
  
  public void setLiveTabWebViewUrlParam(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam:" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = auwq.b();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = paramString.toString();
          auwq.e(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam:" + paramString);
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          Object localObject = auwq.a(new JSONObject((String)localObject), paramString);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException) {}
        paramString = paramString;
        if (QLog.isColorLevel())
        {
          QLog.e("NearbyJsInterface", 2, "setLiveTabWebViewUrlParam exp:" + paramString.toString());
          return;
        }
      }
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setUpLoadVideoFinishedCallback failed! msg = " + paramString.getMessage());
    }
  }
  
  public void setSettingState(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).edit();
      paramString = new JSONObject(paramString);
      if ("greetingsReceive".equals(paramString.optString("key")))
      {
        localEditor.putString("nearby_settings_greetings_receive", paramString.optString("value"));
        if ("0".equals(paramString.optString("value")))
        {
          paramString = new Bundle();
          paramString.putBoolean("isOn", false);
          paramString = apml.a("ipc_cmd_nearby_setting_change", null, 0, paramString);
          aprh.a().a(paramString);
        }
      }
      localEditor.apply();
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyJsInterface", 2, "setSettingState failed! msg = " + paramString.getMessage());
    }
  }
  
  @TargetApi(23)
  public void setStatusBarTextDark(String paramString)
  {
    boolean bool2 = true;
    bool1 = true;
    int j = 0;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyJsInterface", 2, "setStatusBarTextDark: params=" + paramString);
        }
        localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).optString("callback");
        i = ((JSONObject)localObject).optInt("darkMode");
        localObject = this.mRuntime.a();
        if (!ImmersiveUtils.a()) {
          continue;
        }
        localObject = ((Activity)localObject).getWindow();
        if (i != 1) {
          continue;
        }
        bool2 = ImmersiveUtils.a((Window)localObject, bool1);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("NearbyJsInterface", 2, "setStatusBarDarkMode isSucced=" + bool2);
          bool1 = bool2;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyJsInterface", 2, "setStatusBarTextDark exp:" + paramString.toString());
        continue;
        int i = 0;
        continue;
        i = -1;
        continue;
        bool1 = false;
        continue;
      }
      localObject = new StringBuilder().append("{\"ret\":");
      if (!bool1) {
        continue;
      }
      i = j;
      callJs(paramString, new String[] { i + "}" });
      if (QLog.isColorLevel()) {
        QLog.d("NearbyJsInterface", 2, "isKITKAT=" + bhtb.i() + ", enableForMiUI=" + ImmersiveUtils.d + ", isMIUI=" + bdep.b() + ", isFlyme=" + bdep.d() + ", SDK_INT=" + Build.VERSION.SDK_INT);
      }
      return;
      bool1 = false;
      continue;
      if (Build.VERSION.SDK_INT < 23) {
        continue;
      }
      if (i != 1) {
        continue;
      }
      i = 9216;
      ((Activity)localObject).getWindow().getDecorView().setSystemUiVisibility(i);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyJsInterface", 2, "setStatusBarDarkMode setSystemUiVisibility");
        bool1 = bool2;
      }
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
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = auwq.a();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = paramString.toString();
          auwq.d(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "setNearbyTabUrlParams:" + paramString);
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        try
        {
          Object localObject = auwq.a(new JSONObject((String)localObject), paramString);
          paramString = (String)localObject;
        }
        catch (JSONException localJSONException) {}
        paramString = paramString;
        if (QLog.isColorLevel())
        {
          QLog.e("NearbyJsInterface", 2, "setNearbyTabUrlParams exp:" + paramString.toString());
          return;
        }
      }
    }
  }
  
  public void setVideoEnterVisibility(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep1:" + paramString);
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
        QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep2 activity not null");
      }
      localObject = ((NearbyActivity)localObject).a();
      if (localObject != null) {
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
      str = paramString.optString("jumpUrl");
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((NearbyHybridFragment)localObject).a(bool, j, str);
        if (QLog.isColorLevel()) {
          QLog.i("NearbyJsInterface", 2, "setVideoEnterVisibility\tstep4 set success");
        }
        paramString = paramString.optJSONArray("menu");
        if (paramString != null)
        {
          auwq.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "key_nearby_publish_menu", paramString.toString());
          if (QLog.isColorLevel()) {
            QLog.d("NearbyJsInterface", 2, "menuItem=" + paramString);
          }
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
    auxb.a(this.mRuntime.a(), localNearbyAppInterface, 1);
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
  
  public void showGuideDownloadView(String paramString)
  {
    Object localObject;
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
    }
    catch (Exception paramString)
    {
      QLog.e("NearbyJsInterface", 1, "showGuideDownloadView failed! msg = " + paramString.getMessage());
      return;
    }
    JSONObject localJSONObject = paramString.optJSONObject("alert_config");
    if (localJSONObject == null)
    {
      QLog.e("NearbyJsInterface", 1, "showGuideDownloadView: there is no alert_config");
      return;
    }
    paramString = autz.a((Context)localObject, localJSONObject);
    if (paramString != null)
    {
      paramString.f = (localJSONObject.optInt("source") + "");
      localObject = new avtq((Context)localObject);
      ((avtq)localObject).a(paramString);
      ((avtq)localObject).show();
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
      }
      for (;;)
      {
        paramString = apml.a("ipc_should_refresh_cardinfo", "", 0, localBundle);
        aprh.a().a(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyJsInterface
 * JD-Core Version:    0.7.0.1
 */