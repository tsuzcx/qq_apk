package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.activity.QQIdentiferLegacyActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceAreaManager;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.identification.FaceLoginHelper;
import com.tencent.mobileqq.identification.IFaceAreaStrategy;
import com.tencent.mobileqq.identification.IFaceAreaStrategy.IFaceEntrance;
import com.tencent.mobileqq.identification.IdentificationConstant;
import com.tencent.mobileqq.identification.UnusableAreaStrategy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IActivity;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentificationApiPlugin
  extends WebViewPlugin
  implements IFaceAreaStrategy.IFaceEntrance
{
  private static final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131705790);
  private static final String d = HardCodeUtil.a(2131705789);
  private static final String e = HardCodeUtil.a(2131690121);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected FaceConf a;
  protected String a;
  protected AtomicBoolean a;
  private int b;
  protected String b;
  private int jdField_c_of_type_Int;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  public IdentificationApiPlugin()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.mPluginNameSpace = "identification";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void b(Intent paramIntent, int paramInt)
  {
    JSONObject localJSONObject;
    Object localObject2;
    Object localObject1;
    int m;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localJSONObject = new JSONObject();
      if ((paramIntent != null) && (paramIntent.hasExtra("allResults")))
      {
        localObject2 = paramIntent.getStringExtra("allResults");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("|")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
        }
      }
      else
      {
        localObject1 = "";
      }
      if (QLog.isColorLevel()) {
        c(paramIntent, paramInt);
      }
      m = 299;
      if (paramIntent == null) {}
    }
    try
    {
      if (paramIntent.hasExtra("data"))
      {
        paramIntent = paramIntent.getBundleExtra("data");
        paramInt = paramIntent.getInt("ret", 299);
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("errMsg", paramIntent.getString("errMsg", HardCodeUtil.a(2131705792)));
        localJSONObject.put("idKey", paramIntent.getString("idKey"));
        localJSONObject.put("allResults", localObject1);
      }
      else if (paramInt == 0)
      {
        paramInt = 201;
        localJSONObject.put("ret", 201);
        localJSONObject.put("errMsg", IdentificationConstant.jdField_c_of_type_JavaLangString);
        localJSONObject.put("allResults", localObject1);
      }
      else
      {
        localJSONObject.put("ret", 299);
        localJSONObject.put("errMsg", HardCodeUtil.a(2131705792));
        localJSONObject.put("allResults", localObject1);
        paramInt = m;
      }
      paramIntent = new StringBuilder();
      paramIntent.append(this.jdField_c_of_type_Int);
      paramIntent.append("");
      paramIntent = paramIntent.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(null, "dc00898", "", "", "0X8009862", "0X8009862", 0, 0, paramIntent, "", (String)localObject2, localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("native invoke web ret:");
        paramIntent.append(paramInt);
        paramIntent.append(" all_results:");
        paramIntent.append((String)localObject1);
        QLog.d("IdentificationApiPlugin", 2, paramIntent.toString());
      }
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramIntent)
    {
      label453:
      break label453;
    }
    QLog.e("IdentificationApiPlugin", 1, paramIntent, new Object[0]);
  }
  
  private void b(FaceConf paramFaceConf)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferActivity.class);
    localIntent.putExtra("faceConf", paramFaceConf);
    startActivityForResult(localIntent, (byte)1);
  }
  
  private void c(Intent paramIntent, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("identificationPlugin invokeCallback intent=");
    String str;
    if (paramIntent == null) {
      str = "true";
    } else {
      str = "false";
    }
    localStringBuilder.append(str);
    if ((paramIntent != null) && (paramIntent.hasExtra("data")))
    {
      localStringBuilder.append(" has_key_data=");
      localStringBuilder.append("true");
    }
    localStringBuilder.append(" resultCode=");
    localStringBuilder.append(paramInt);
    QLog.d("IdentificationApiPlugin", 2, localStringBuilder.toString());
    if ((paramIntent != null) && (paramIntent.getBundleExtra("data") != null))
    {
      paramIntent = paramIntent.getBundleExtra("data");
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "idKey : ", paramIntent.getString("idKey", ""), " retValue : ", Integer.valueOf(paramIntent.getInt("ret", -1)), " errorMsg : ", paramIntent.getString("errMsg", "") });
    }
  }
  
  private void e()
  {
    FaceAreaManager localFaceAreaManager = FaceAreaManager.a();
    localFaceAreaManager.a(this.jdField_a_of_type_Int, this.k, this.jdField_b_of_type_JavaLangString, new IdentificationApiPlugin.1(this, localFaceAreaManager));
  }
  
  private boolean e()
  {
    IdentificationApiPlugin.ContextInfo localContextInfo = a();
    if (localContextInfo.jdField_a_of_type_Int != 0) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", localContextInfo.jdField_a_of_type_Int);
        localJSONObject.put("errMsg", localContextInfo.jdField_a_of_type_JavaLangString);
        a(localJSONObject);
        return true;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("IdentificationApiPlugin", 1, "context invalid, call js error : ", localJSONException);
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    if (!"loginVerify".equals(this.jdField_b_of_type_JavaLangString))
    {
      QLog.e("IdentificationApiPlugin", 1, "finishCurrentInLogin, only login state need finish");
      return;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "finishCurrentInLogin activity is invalid");
  }
  
  private void g()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.l);
      this.jdField_a_of_type_Int = localJSONObject.optInt("platformAppId", 0);
      this.jdField_a_of_type_Long = localJSONObject.optLong("nonce");
      this.jdField_b_of_type_Int = localJSONObject.optInt("srcAppId", 0);
      this.f = localJSONObject.optString("srcOpenId", "");
      this.g = localJSONObject.optString("key", "");
      this.h = localJSONObject.optString("idNum", "");
      this.i = localJSONObject.optString("name", "");
      this.jdField_c_of_type_Int = localJSONObject.optInt("serviceType", -1);
      this.j = localJSONObject.optString("ticket", "");
      this.k = localJSONObject.optString("uin", "");
      this.jdField_a_of_type_JavaLangString = localJSONObject.optString("callback", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("IdentificationApiPlugin", 1, "parseParams error : ", localJSONException);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf = new FaceConf();
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setAppId(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setPlatformAppId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setNonce(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setOpenId(this.f);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setKey(this.g);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setIdNum(this.h);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setName(this.i);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setServiceType(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setTicket(this.j);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setUin(this.k);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setCallback(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setMethod(this.jdField_b_of_type_JavaLangString);
  }
  
  private void i()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 2131692146);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
  }
  
  private void j()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.jdField_a_of_type_AndroidAppDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
  }
  
  protected IdentificationApiPlugin.ContextInfo a()
  {
    IdentificationApiPlugin.ContextInfo localContextInfo = new IdentificationApiPlugin.ContextInfo();
    if (b())
    {
      localContextInfo.jdField_a_of_type_Int = 203;
      localContextInfo.jdField_a_of_type_JavaLangString = jdField_c_of_type_JavaLangString;
      QLog.e("IdentificationApiPlugin", 1, "sdk version < 18");
      return localContextInfo;
    }
    if (a(this.jdField_a_of_type_AndroidAppActivity))
    {
      localContextInfo.jdField_a_of_type_Int = 206;
      localContextInfo.jdField_a_of_type_JavaLangString = IdentificationConstant.jdField_b_of_type_JavaLangString;
      QLog.e("IdentificationApiPlugin", 1, "current mode is in multi window");
      return localContextInfo;
    }
    if (c())
    {
      localContextInfo.jdField_a_of_type_Int = 204;
      localContextInfo.jdField_a_of_type_JavaLangString = IdentificationConstant.jdField_a_of_type_JavaLangString;
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return localContextInfo;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localContextInfo.jdField_a_of_type_Int = 212;
      localContextInfo.jdField_a_of_type_JavaLangString = d;
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return localContextInfo;
    }
    localContextInfo.jdField_a_of_type_Int = 0;
    return localContextInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (IdentificationConstant.jdField_a_of_type_JavaUtilList.contains(this.jdField_b_of_type_JavaLangString))
    {
      c();
      return;
    }
    j();
    b();
  }
  
  protected void a(int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.4(this, paramString));
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    b(paramIntent, paramInt);
    f();
  }
  
  protected void a(FaceAreaManager paramFaceAreaManager)
  {
    paramFaceAreaManager = paramFaceAreaManager.a();
    if (paramFaceAreaManager != null) {
      paramFaceAreaManager.a(this);
    }
    QLog.d("IdentificationApiPlugin", 1, "doFaceVerify");
    boolean bool = paramFaceAreaManager instanceof UnusableAreaStrategy;
    if ((bool) || ("identify".equals(this.jdField_b_of_type_JavaLangString)))
    {
      j();
      if (bool) {
        try
        {
          paramFaceAreaManager = new JSONObject();
          paramFaceAreaManager.put("ret", 219);
          paramFaceAreaManager.put("errMsg", e);
          a(paramFaceAreaManager);
          return;
        }
        catch (JSONException paramFaceAreaManager)
        {
          QLog.e("IdentificationApiPlugin", 1, new Object[] { "RET_CODE_AREA_NOT_SUPPORT error : ", paramFaceAreaManager.getMessage() });
        }
      }
    }
  }
  
  protected void a(FaceConf paramFaceConf)
  {
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.3(this, paramFaceConf));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    j();
    boolean bool1 = "loginVerify".equals(this.jdField_b_of_type_JavaLangString);
    boolean bool2 = false;
    if ((!bool1) && (!"changeSecureMobile".equals(this.jdField_b_of_type_JavaLangString)))
    {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramJSONObject.toString() });
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("errMsg")) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "jsonObject is ", paramJSONObject.toString(), " method is ", this.jdField_b_of_type_JavaLangString });
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramJSONObject.optString("errMsg"), 0).a();
      return;
    }
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramJSONObject == null) {
      bool2 = true;
    }
    QLog.e("IdentificationApiPlugin", 1, new Object[] { "activity is null ? ", Boolean.valueOf(bool1), " jsonObject is null ? ", Boolean.valueOf(bool2) });
  }
  
  protected boolean a()
  {
    if (TextUtils.isEmpty(this.l))
    {
      QLog.e("IdentificationApiPlugin", 1, "requestLivenessDetection: empty FaceParam");
      return true;
    }
    g();
    if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (!TextUtils.isEmpty(this.g)))
    {
      h();
      return false;
    }
    QLog.e("IdentificationApiPlugin", 1, new Object[] { "params invalid, platformAppId : ", Integer.valueOf(this.jdField_a_of_type_Int), " appId : ", Integer.valueOf(this.jdField_b_of_type_Int), " key : ", this.g });
    return true;
  }
  
  protected boolean a(Activity paramActivity)
  {
    boolean bool1 = paramActivity instanceof IActivity;
    boolean bool3 = false;
    if ((bool1) && (Build.VERSION.SDK_INT >= 24) && (paramActivity.isInMultiWindowMode())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (((paramActivity instanceof QBaseActivity)) && (((QBaseActivity)paramActivity).isInMultiWindow())) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    QLog.d("IdentificationApiPlugin", 1, new Object[] { "multiWindowInWallet : ", Boolean.valueOf(bool1), " currentPageInMultiWindow : ", Boolean.valueOf(bool2) });
    if (!bool2)
    {
      bool2 = bool3;
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("faceConf", this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf);
    startActivityForResult(localIntent, (byte)2);
  }
  
  protected boolean b()
  {
    return Build.VERSION.SDK_INT < 18;
  }
  
  protected void c()
  {
    FaceLoginHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf, new IdentificationApiPlugin.2(this));
  }
  
  protected boolean c()
  {
    return QIPCClientHelper.getInstance().getClient().callServer("IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1;
  }
  
  protected void d()
  {
    ((QBaseActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(new IdentificationApiPlugin.5(this), 1, new String[] { "android.permission.CAMERA" });
  }
  
  protected boolean d()
  {
    int m = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (m >= 23)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"identification".equals(paramString2))
    {
      QLog.e("IdentificationApiPlugin", 1, new Object[] { "handleJsRequest, pkgName not match, pkgName : ", paramString2 });
      return false;
    }
    QLog.d("IdentificationApiPlugin", 1, new Object[] { "handleJsRequest, method : ", paramString3 });
    if (!IdentificationConstant.e.contains(paramString3)) {
      return false;
    }
    if (e()) {
      return true;
    }
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.l = paramVarArgs[0];
    if (a())
    {
      QLog.e("IdentificationApiPlugin", 1, "handleJsRequest params is invalid");
      return true;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    i();
    e();
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte != 1)
    {
      if (paramByte != 2) {
        return;
      }
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_LEGACY, result code is ", Integer.valueOf(paramInt), " method is ", this.jdField_b_of_type_JavaLangString });
      if (paramInt == -1)
      {
        if ((paramIntent != null) && (paramIntent.getSerializableExtra("FaceRecognition.AppConf") != null))
        {
          paramIntent = (AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
          this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf.setAppConf(paramIntent);
        }
        b(this.jdField_a_of_type_ComTencentMobileqqIdentificationFaceConf);
        return;
      }
      a(paramIntent, paramInt);
      return;
    }
    QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_IDENTIFICATION, result code is ", Integer.valueOf(paramInt), " method is ", this.jdField_b_of_type_JavaLangString });
    a(paramIntent, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidAppActivity = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin
 * JD-Core Version:    0.7.0.1
 */