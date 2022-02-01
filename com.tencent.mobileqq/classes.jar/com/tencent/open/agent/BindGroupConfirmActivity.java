package com.tencent.open.agent;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.appcommon.OpensdkServlet;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGroupConfirmActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, ImageLoader.ImageLoadListener, HttpCgiAsyncTask.Callback
{
  protected Resources a;
  protected Bundle a;
  protected final Handler a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected ShareAioResultDialog a;
  HttpWebCgiAsyncTask.Callback jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new BindGroupConfirmActivity.7(this);
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  private final HttpCgiAsyncTask.Callback jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback = new BindGroupConfirmActivity.1(this);
  protected Runnable a;
  protected String a;
  protected ImageView b;
  protected TextView b;
  protected String b;
  protected TextView c;
  protected String c;
  protected TextView d;
  protected String d;
  protected TextView e;
  protected String e;
  protected TextView f;
  protected String f;
  protected TextView g;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  
  public BindGroupConfirmActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new BindGroupConfirmActivity.2(this);
    this.jdField_a_of_type_JavaLangRunnable = new BindGroupConfirmActivity.5(this);
  }
  
  private void a(String paramString)
  {
    getActivity().runOnUiThread(new BindGroupConfirmActivity.8(this, paramString));
  }
  
  private void b()
  {
    Object localObject = findViewById(2131376828);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows((View)localObject, true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369204));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365085));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378172));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131379244));
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = ImageLoader.a().a(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      } else {
        ImageLoader.a().a(this.jdField_b_of_type_JavaLangString, this);
      }
    }
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379316));
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_g_of_type_AndroidWidgetTextView.setText("QQ群");
    } else {
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362839));
    ThreadManager.executeOnSubThread(new BindGroupConfirmActivity.3(this));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362851));
    this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue());
    }
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
    Object localObject1 = this.app.getCurrentAccountUin();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("o");
    if (((String)localObject1).length() < 10)
    {
      int m = 0;
      while (m < 10 - ((String)localObject1).length())
      {
        ((StringBuilder)localObject2).append("0");
        m += 1;
      }
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    else
    {
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("uin=");
    localStringBuilder2.append(localObject2);
    localStringBuilder2.append("; skey=");
    localStringBuilder2.append(localTicketManager.getSkey((String)localObject1));
    localBundle.putString("Cookie", localStringBuilder2.toString());
    localBundle.putString("Host", "info.gamecenter.qq.com");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("appid", this.jdField_c_of_type_JavaLangString);
    ((Bundle)localObject1).putString("guild_id", this.h);
    ((Bundle)localObject1).putString("zone_id", this.i);
    ((Bundle)localObject1).putString("guild_name", this.l);
    ((Bundle)localObject1).putString("gc", this.k);
    ((Bundle)localObject1).putString("platid", "2");
    ((Bundle)localObject1).putString("roleid", this.j);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("module", "gc_bind_group_svr");
    ((Bundle)localObject2).putString("method", "bind_existing_group");
    localObject1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).constructParams((Bundle)localObject1, (Bundle)localObject2);
    localBundle.putString("param", (String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("ea779693bfa42c986ad85cda9bdfce45");
    localObject1 = ((StringBuilder)localObject2).toString();
    localBundle.putString("signature", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).encrypt((String)localObject1).toUpperCase());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localBundle);
    ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("bindGroup params = ");
      ((StringBuilder)localObject2).append(localBundle);
      QLog.i("BindGroupConfirmActivity", 2, ((StringBuilder)localObject2).toString());
    }
    new HttpWebCgiAsyncTask2(localStringBuilder1.toString(), "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 0, null).a((HashMap)localObject1);
  }
  
  protected void a(long paramLong)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {
      localObject = "";
    } else {
      localObject = Build.VERSION.RELEASE;
    }
    localGetAppinfoRequest.os.set((String)localObject);
    localGetAppinfoRequest.qqv.set(CommonDataAdapter.a().d());
    localGetAppinfoRequest.setHasFlag(true);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(this.jdField_d_of_type_JavaLangString);
    }
    localGetAppinfoRequest.referer.set(6);
    Object localObject = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
    ((NewIntent)localObject).putExtra("data", localGetAppinfoRequest.toByteArray());
    ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.get_app_info");
    ((NewIntent)localObject).setObserver(new BindGroupConfirmActivity.6(this));
    super.getAppRuntime().startServlet((NewIntent)localObject);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  public void a(Exception paramException)
  {
    b(paramException);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("-->onImageLoaded() url = ");
    paramString2.append(paramString1);
    LogUtility.c("BindGroupConfirmActivity", paramString2.toString());
    this.jdField_a_of_type_AndroidOsHandler.post(new BindGroupConfirmActivity.4(this, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int m;
      try
      {
        int n = paramJSONObject.getInt("ret");
        m = 0;
        if (n == 0)
        {
          paramJSONObject = paramJSONObject.getJSONArray("list");
          n = paramJSONObject.length();
          localObject = new StringBuffer();
          if (m < n)
          {
            try
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
              if (!localJSONObject.getString("id").equals("0"))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(localJSONObject.getString("id"));
                localStringBuilder.append("、");
                ((StringBuffer)localObject).append(localStringBuilder.toString());
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(localJSONObject.getString("desc"));
              localStringBuilder.append("\n");
              ((StringBuffer)localObject).append(localStringBuilder.toString());
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                break label319;
              }
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("The JSONObject has error!");
            localStringBuilder.append(localJSONException.getMessage());
            QLog.d("BindGroupConfirmActivity", 2, localStringBuilder.toString());
            break label319;
          }
          if (((StringBuffer)localObject).length() != 0) {
            this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
          }
          if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
            this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690657));
          }
          QQToast.a(this, paramJSONObject.getString("msg"), 0).a(getTitleBarHeight()).show();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
        if (localObject != null) {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690657));
        }
        a(paramJSONObject);
      }
      return;
      label319:
      m += 1;
    }
  }
  
  public void b(Exception paramException)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HttpAsyncTaskCallback exception.");
      localStringBuilder.append(paramException.getMessage());
      QLog.d("BindGroupConfirmActivity", 2, localStringBuilder.toString());
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = Constants.jdField_e_of_type_JavaLangString;
    } else if ((paramException instanceof SocketTimeoutException)) {
      paramException = Constants.jdField_f_of_type_JavaLangString;
    } else if ((paramException instanceof MalformedURLException)) {
      paramException = "访问url有误!";
    } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
      paramException = "Http返回码异常!";
    } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
      paramException = Constants.jdField_g_of_type_JavaLangString;
    } else if ((paramException instanceof JSONException)) {
      paramException = Constants.jdField_b_of_type_JavaLangString;
    } else if ((paramException instanceof IOException)) {
      paramException = Constants.jdField_a_of_type_JavaLangString;
    } else {
      paramException = Constants.jdField_d_of_type_JavaLangString;
    }
    QQToast.a(this, paramException, 0).a(getTitleBarHeight()).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130772002, 2130772003);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == paramDialogInterface)
    {
      if (paramInt == 0)
      {
        try
        {
          ForwardSdkShareOption.a(this, true, "action_game_bind_group", Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), 0, "");
        }
        catch (Exception paramDialogInterface)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showAlertDlg error = ");
          localStringBuilder.append(paramDialogInterface);
          QLog.e("BindGroupConfirmActivity", 1, localStringBuilder.toString());
        }
        super.setResult(-1);
        super.finish();
        return;
      }
      if (paramInt == 1)
      {
        paramDialogInterface = new Intent(this, SplashActivity.class);
        paramDialogInterface.addFlags(67108864);
        paramDialogInterface.addFlags(268435456);
        super.startActivity(paramDialogInterface);
        super.finish();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == paramDialogInterface)
    {
      paramDialogInterface.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int m = paramView.getId();
      if (m != 2131365085)
      {
        if (m == 2131369202) {
          finish();
        }
      }
      else if ("true".equals(this.jdField_g_of_type_JavaLangString))
      {
        a();
      }
      else
      {
        new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_bind_qqgroup", "POST", this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask$Callback, true).a(this.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755317);
    super.setContentView(2131559948);
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701338));
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    paramBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (paramBundle == null)
    {
      LogUtility.e("BindGroupConfirmActivity", "initParams() mParams is null!");
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("union_name");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("group_name");
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("group_avatar_url");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("pkg_name");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("is_from_game");
    if ("true".equals(this.jdField_g_of_type_JavaLangString))
    {
      this.h = this.jdField_a_of_type_AndroidOsBundle.getString("unionid");
      this.i = this.jdField_a_of_type_AndroidOsBundle.getString("zoneid");
      this.j = this.jdField_a_of_type_AndroidOsBundle.getString("role_id");
      this.k = this.jdField_a_of_type_AndroidOsBundle.getString("group_code");
      this.l = this.jdField_f_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("bindGroup appid =  guild id = ");
        paramBundle.append(this.h);
        paramBundle.append("zone_id = ");
        paramBundle.append(this.i);
        paramBundle.append(" role id = ");
        paramBundle.append(this.j);
        paramBundle.append("  group code= ");
        paramBundle.append(this.k);
        paramBundle.append(" guild name = ");
        paramBundle.append(this.l);
        QLog.d("BindGroupConfirmActivity", 2, paramBundle.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "0x80084B0", "0x80084B0", 0, 0, "", "", "", "");
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BindGroupConfirmActivity", 2, " bindGroup is from game = false");
    }
    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_qqgroup_description", "POST", this, true).a(this.jdField_a_of_type_AndroidOsBundle);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BindGroupActivity.b = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690941));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690653));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity
 * JD-Core Version:    0.7.0.1
 */