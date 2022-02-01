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
  private static final String e = HardCodeUtil.a(2131903675);
  private static final String f = HardCodeUtil.a(2131903674);
  private static final String g = HardCodeUtil.a(2131887020);
  protected String a;
  protected String b;
  protected AtomicBoolean c = new AtomicBoolean(false);
  protected FaceConf d;
  private Activity h;
  private int i;
  private int j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private int q;
  private long r;
  private Dialog s;
  private String t;
  
  public IdentificationApiPlugin()
  {
    this.mPluginNameSpace = "identification";
  }
  
  private void b(Intent paramIntent, int paramInt)
  {
    if ((!"loginVerify".equals(this.b)) && (!c(paramIntent, paramInt)))
    {
      QLog.e("IdentificationApiPlugin", 1, "finishCurrentActivity, only login and studyModeIdentify RESULT_CANCELED state need finish");
      return;
    }
    paramIntent = this.h;
    if ((paramIntent != null) && (!paramIntent.isFinishing()))
    {
      QLog.e("IdentificationApiPlugin", 1, "finishCurrentActivity activity finish");
      this.h.finish();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "finishCurrentActivity activity is invalid");
  }
  
  private void b(FaceConf paramFaceConf)
  {
    Intent localIntent = new Intent(this.h, QQIdentiferActivity.class);
    localIntent.putExtra("faceConf", paramFaceConf);
    startActivityForResult(localIntent, (byte)1);
  }
  
  private boolean c(Intent paramIntent, int paramInt)
  {
    if (!"studyModeIdentify".equals(this.b)) {
      return false;
    }
    return paramInt == 0;
  }
  
  private void d(Intent paramIntent, int paramInt)
  {
    JSONObject localJSONObject;
    Object localObject2;
    Object localObject1;
    int i1;
    if (!TextUtils.isEmpty(this.a))
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
        e(paramIntent, paramInt);
      }
      i1 = 299;
      if (paramIntent == null) {}
    }
    try
    {
      if (paramIntent.hasExtra("data"))
      {
        paramIntent = paramIntent.getBundleExtra("data");
        paramInt = paramIntent.getInt("ret", 299);
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("errMsg", paramIntent.getString("errMsg", HardCodeUtil.a(2131903677)));
        localJSONObject.put("idKey", paramIntent.getString("idKey"));
        localJSONObject.put("allResults", localObject1);
      }
      else if (paramInt == 0)
      {
        paramInt = 201;
        localJSONObject.put("ret", 201);
        localJSONObject.put("errMsg", IdentificationConstant.h);
        localJSONObject.put("allResults", localObject1);
      }
      else
      {
        localJSONObject.put("ret", 299);
        localJSONObject.put("errMsg", HardCodeUtil.a(2131903677));
        localJSONObject.put("allResults", localObject1);
        paramInt = i1;
      }
      paramIntent = new StringBuilder();
      paramIntent.append(this.q);
      paramIntent.append("");
      paramIntent = paramIntent.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.j);
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
      callJs(this.a, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramIntent)
    {
      label453:
      break label453;
    }
    QLog.e("IdentificationApiPlugin", 1, paramIntent, new Object[0]);
  }
  
  private void e(Intent paramIntent, int paramInt)
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
  
  private boolean j()
  {
    IdentificationApiPlugin.ContextInfo localContextInfo = b();
    if (localContextInfo.a != 0) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", localContextInfo.a);
        localJSONObject.put("errMsg", localContextInfo.b);
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
  
  private void k()
  {
    FaceAreaManager localFaceAreaManager = FaceAreaManager.a();
    localFaceAreaManager.a(this.i, this.p, this.b, new IdentificationApiPlugin.1(this, localFaceAreaManager));
  }
  
  private void l()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.t);
      this.i = localJSONObject.optInt("platformAppId", 0);
      this.r = localJSONObject.optLong("nonce");
      this.j = localJSONObject.optInt("srcAppId", 0);
      this.k = localJSONObject.optString("srcOpenId", "");
      this.l = localJSONObject.optString("key", "");
      this.m = localJSONObject.optString("idNum", "");
      this.n = localJSONObject.optString("name", "");
      this.q = localJSONObject.optInt("serviceType", -1);
      this.o = localJSONObject.optString("ticket", "");
      this.p = localJSONObject.optString("uin", "");
      this.a = localJSONObject.optString("callback", "");
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("IdentificationApiPlugin", 1, "parseParams error : ", localJSONException);
    }
  }
  
  private void m()
  {
    this.d = new FaceConf();
    this.d.setAppId(this.j);
    this.d.setPlatformAppId(this.i);
    this.d.setNonce(this.r);
    this.d.setOpenId(this.k);
    this.d.setKey(this.l);
    this.d.setIdNum(this.m);
    this.d.setName(this.n);
    this.d.setServiceType(this.q);
    this.d.setTicket(this.o);
    this.d.setUin(this.p);
    this.d.setCallback(this.a);
    this.d.setMethod(this.b);
  }
  
  private Activity n()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void o()
  {
    Activity localActivity = this.h;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      if (this.s == null) {
        this.s = DialogUtil.b(this.h, 2131889129);
      }
      this.s.show();
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "showLoadingView activity is null or is finish");
  }
  
  private void p()
  {
    Object localObject = this.h;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.s;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.s.dismiss();
      }
      return;
    }
    QLog.e("IdentificationApiPlugin", 1, "dismissLoadingView activity is null or activity is null");
  }
  
  public void a()
  {
    this.c.set(true);
    if (IdentificationConstant.a.contains(this.b))
    {
      g();
      return;
    }
    p();
    f();
  }
  
  protected void a(int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new IdentificationApiPlugin.4(this, paramString));
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    this.c.set(false);
    d(paramIntent, paramInt);
    b(paramIntent, paramInt);
  }
  
  protected void a(FaceAreaManager paramFaceAreaManager)
  {
    paramFaceAreaManager = paramFaceAreaManager.c();
    if (paramFaceAreaManager != null) {
      paramFaceAreaManager.a(this);
    }
    QLog.d("IdentificationApiPlugin", 1, "doFaceVerify");
    boolean bool = paramFaceAreaManager instanceof UnusableAreaStrategy;
    if ((bool) || ("identify".equals(this.b)))
    {
      p();
      if (bool) {
        try
        {
          paramFaceAreaManager = new JSONObject();
          paramFaceAreaManager.put("ret", 219);
          paramFaceAreaManager.put("errMsg", g);
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
    p();
    boolean bool1 = "loginVerify".equals(this.b);
    boolean bool2 = false;
    if ((!bool1) && (!"changeSecureMobile".equals(this.b)))
    {
      callJs(this.a, new String[] { paramJSONObject.toString() });
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("errMsg")) && (this.h != null))
    {
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "jsonObject is ", paramJSONObject.toString(), " method is ", this.b });
      QQToast.makeText(this.h, paramJSONObject.optString("errMsg"), 0).show();
      return;
    }
    if (this.h == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramJSONObject == null) {
      bool2 = true;
    }
    QLog.e("IdentificationApiPlugin", 1, new Object[] { "activity is null ? ", Boolean.valueOf(bool1), " jsonObject is null ? ", Boolean.valueOf(bool2) });
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
  
  protected IdentificationApiPlugin.ContextInfo b()
  {
    IdentificationApiPlugin.ContextInfo localContextInfo = new IdentificationApiPlugin.ContextInfo();
    if (d())
    {
      localContextInfo.a = 203;
      localContextInfo.b = e;
      QLog.e("IdentificationApiPlugin", 1, "sdk version < 18");
      return localContextInfo;
    }
    if (a(this.h))
    {
      localContextInfo.a = 206;
      localContextInfo.b = IdentificationConstant.g;
      QLog.e("IdentificationApiPlugin", 1, "current mode is in multi window");
      return localContextInfo;
    }
    if (e())
    {
      localContextInfo.a = 204;
      localContextInfo.b = IdentificationConstant.f;
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return localContextInfo;
    }
    if (this.c.get())
    {
      localContextInfo.a = 212;
      localContextInfo.b = f;
      QLog.e("IdentificationApiPlugin", 1, "current mode is video chatting");
      return localContextInfo;
    }
    localContextInfo.a = 0;
    return localContextInfo;
  }
  
  protected boolean c()
  {
    if (TextUtils.isEmpty(this.t))
    {
      QLog.e("IdentificationApiPlugin", 1, "requestLivenessDetection: empty FaceParam");
      return true;
    }
    l();
    if ((this.i != 0) && (!TextUtils.isEmpty(this.l)))
    {
      if (!this.b.equalsIgnoreCase("studyModeIdentify"))
      {
        int i1 = this.j;
        if (i1 == 0)
        {
          QLog.e("IdentificationApiPlugin", 1, new Object[] { "params invalid,  appId : ", Integer.valueOf(i1) });
          return true;
        }
      }
      m();
      return false;
    }
    QLog.e("IdentificationApiPlugin", 1, new Object[] { "params invalid, platformAppId : ", Integer.valueOf(this.i), " key : ", this.l });
    return true;
  }
  
  protected boolean d()
  {
    return Build.VERSION.SDK_INT < 18;
  }
  
  protected boolean e()
  {
    return QIPCClientHelper.getInstance().getClient().callServer("IdentificationIpcServer_Model", "action_is_video_chatting", null).code == 1;
  }
  
  protected void f()
  {
    Intent localIntent = new Intent(this.h, QQIdentiferLegacyActivity.class);
    localIntent.putExtra("faceConf", this.d);
    startActivityForResult(localIntent, (byte)2);
  }
  
  protected void g()
  {
    FaceLoginHelper.a(this.h, this.d, new IdentificationApiPlugin.2(this));
  }
  
  protected boolean h()
  {
    int i1 = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i1 >= 23)
    {
      if (this.h.checkSelfPermission("android.permission.CAMERA") == 0) {
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
    if (j()) {
      return true;
    }
    this.b = paramString3;
    this.t = paramVarArgs[0];
    if (c())
    {
      QLog.e("IdentificationApiPlugin", 1, "handleJsRequest params is invalid");
      return true;
    }
    addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
    o();
    k();
    return true;
  }
  
  protected void i()
  {
    ((QBaseActivity)this.h).requestPermissions(new IdentificationApiPlugin.5(this), 1, new String[] { "android.permission.CAMERA" });
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte != 1)
    {
      if (paramByte != 2) {
        return;
      }
      QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_LEGACY, result code is ", Integer.valueOf(paramInt), " method is ", this.b });
      if (paramInt == -1)
      {
        if ((paramIntent != null) && (paramIntent.getSerializableExtra("FaceRecognition.AppConf") != null))
        {
          paramIntent = (AppConf)paramIntent.getSerializableExtra("FaceRecognition.AppConf");
          this.d.setAppConf(paramIntent);
        }
        b(this.d);
        return;
      }
      a(paramIntent, paramInt);
      return;
    }
    QLog.d("IdentificationApiPlugin", 1, new Object[] { "onActivityResult REQ_IDENTIFICATION, result code is ", Integer.valueOf(paramInt), " method is ", this.b });
    a(paramIntent, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.h = n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.IdentificationApiPlugin
 * JD-Core Version:    0.7.0.1
 */