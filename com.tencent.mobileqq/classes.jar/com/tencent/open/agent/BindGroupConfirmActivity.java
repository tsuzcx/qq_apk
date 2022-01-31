package com.tencent.open.agent;

import ajya;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import aqfd;
import axqy;
import baic;
import baid;
import banb;
import bbgu;
import bcqf;
import bcql;
import bcyb;
import bczr;
import bczs;
import bczt;
import bczu;
import bdeo;
import bdeq;
import bdfp;
import bdii;
import bdjd;
import bdje;
import bdjm;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoRequest;
import com.tencent.qphone.base.util.QLog;
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
import xnw;

public class BindGroupConfirmActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, bdeq, bdje
{
  public Resources a;
  protected Bundle a;
  public final Handler a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  baic jdField_a_of_type_Baic = new bczu(this);
  public bbgu a;
  public bcqf a;
  private final bdje jdField_a_of_type_Bdje = new bczr(this);
  public Runnable a;
  protected String a;
  public xnw a;
  public ImageView b;
  protected TextView b;
  protected String b;
  protected TextView c;
  public String c;
  protected TextView d;
  protected String d;
  protected TextView e;
  public String e;
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
    this.jdField_a_of_type_AndroidOsHandler = new bczs(this);
    this.jdField_a_of_type_JavaLangRunnable = new BindGroupConfirmActivity.5(this);
  }
  
  private void a(String paramString)
  {
    getActivity().runOnUiThread(new BindGroupConfirmActivity.8(this, paramString));
  }
  
  private void b()
  {
    Object localObject = findViewById(2131375512);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a((View)localObject, true);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368431));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368457));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364614));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131376760));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131377804));
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = bdeo.a().a(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131377869));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label270;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText("QQ群");
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362667));
      ThreadManager.executeOnSubThread(new BindGroupConfirmActivity.3(this));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362679));
      this.jdField_f_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        a(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue());
      }
      return;
      bdeo.a().a(this.jdField_b_of_type_JavaLangString, this);
      break;
      label270:
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a()
  {
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi");
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
    for (;;)
    {
      TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
      localBundle.putString("Cookie", "uin=" + localObject2 + "; skey=" + localTicketManager.getSkey((String)localObject1));
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
      localObject1 = banb.a((Bundle)localObject1, (Bundle)localObject2);
      localBundle.putString("param", (String)localObject1);
      localBundle.putString("signature", banb.a((String)localObject1 + "ea779693bfa42c986ad85cda9bdfce45").toUpperCase());
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("BUNDLE", localBundle);
      ((HashMap)localObject1).put("CONTEXT", getApplicationContext());
      if (QLog.isColorLevel()) {
        QLog.i("BindGroupConfirmActivity", 2, "bindGroup params = " + localBundle);
      }
      new baid(localStringBuilder.toString(), "GET", this.jdField_a_of_type_Baic, 0, null).a((HashMap)localObject1);
      return;
      ((StringBuilder)localObject2).append("0");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
  }
  
  protected void a(long paramLong)
  {
    GetAppInfoProto.GetAppinfoRequest localGetAppinfoRequest = new GetAppInfoProto.GetAppinfoRequest();
    localGetAppinfoRequest.client_id.set(paramLong);
    localGetAppinfoRequest.sdkp.set("android");
    if (Build.VERSION.RELEASE == null) {}
    for (Object localObject = "";; localObject = Build.VERSION.RELEASE)
    {
      localGetAppinfoRequest.os.set((String)localObject);
      localGetAppinfoRequest.qqv.set(bcyb.a().d());
      localGetAppinfoRequest.setHasFlag(true);
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        localGetAppinfoRequest.appUniqueIdentifier.set(this.jdField_d_of_type_JavaLangString);
      }
      localGetAppinfoRequest.referer.set(6);
      localObject = new NewIntent(this, bdfp.class);
      ((NewIntent)localObject).setWithouLogin(true);
      ((NewIntent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
      ((NewIntent)localObject).putExtra("data", localGetAppinfoRequest.toByteArray());
      ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.get_app_info");
      ((NewIntent)localObject).setObserver(new bczt(this));
      super.getAppRuntime().startServlet((NewIntent)localObject);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
  }
  
  public void a(Exception paramException)
  {
    b(paramException);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    bdii.c("BindGroupConfirmActivity", "-->onImageLoaded() url = " + paramString1);
    this.jdField_a_of_type_AndroidOsHandler.post(new BindGroupConfirmActivity.4(this, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    StringBuffer localStringBuffer;
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        break label226;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int n = paramJSONObject.length();
      localStringBuffer = new StringBuffer();
      int m = 0;
      for (;;)
      {
        if (m >= n) {
          break label208;
        }
        try
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(m);
          if (!localJSONObject.getString("id").equals("0")) {
            localStringBuffer.append(localJSONObject.getString("id") + "、");
          }
          localStringBuffer.append(localJSONObject.getString("desc") + "\n");
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!" + localJSONException.getMessage());
            }
          }
        }
        m += 1;
      }
      while (localStringBuffer.length() == 0) {}
    }
    catch (Exception paramJSONObject)
    {
      if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690487));
      }
      a(paramJSONObject);
      return;
    }
    label208:
    this.jdField_e_of_type_AndroidWidgetTextView.setText(localStringBuffer);
    return;
    label226:
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
    }
    if (this.jdField_e_of_type_AndroidWidgetTextView != null) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690487));
    }
    bcql.a(this, paramJSONObject.getString("msg"), 0).a(getTitleBarHeight()).show();
  }
  
  public void b(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupConfirmActivity", 2, "HttpAsyncTaskCallback exception." + paramException.getMessage());
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = bdjm.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      bcql.a(this, paramException, 0).a(getTitleBarHeight()).show();
      return;
      if ((paramException instanceof SocketTimeoutException)) {
        paramException = bdjm.jdField_f_of_type_JavaLangString;
      } else if ((paramException instanceof MalformedURLException)) {
        paramException = "访问url有误!";
      } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
        paramException = "Http返回码异常!";
      } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
        paramException = bdjm.jdField_g_of_type_JavaLangString;
      } else if ((paramException instanceof JSONException)) {
        paramException = bdjm.jdField_b_of_type_JavaLangString;
      } else if ((paramException instanceof IOException)) {
        paramException = bdjm.jdField_a_of_type_JavaLangString;
      } else {
        paramException = bdjm.jdField_d_of_type_JavaLangString;
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Xnw == paramDialogInterface) {
      if (paramInt != 0) {}
    }
    while (this.jdField_a_of_type_Bbgu != paramDialogInterface)
    {
      do
      {
        try
        {
          aqfd.a(this, true, "action_game_bind_group", Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue(), 0, "");
          super.setResult(-1);
          super.finish();
          return;
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            QLog.e("BindGroupConfirmActivity", 1, "showAlertDlg error = " + paramDialogInterface);
          }
        }
      } while (paramInt != 1);
      paramDialogInterface = new Intent(this, SplashActivity.class);
      paramDialogInterface.addFlags(67108864);
      paramDialogInterface.addFlags(268435456);
      super.startActivity(paramDialogInterface);
      super.finish();
      return;
    }
    paramDialogInterface.dismiss();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364614: 
      if ("true".equals(this.jdField_g_of_type_JavaLangString))
      {
        a();
        return;
      }
      new bdjd("http://fusionbase.qq.com/cgi-bin/appstage/mb_bind_qqgroup", "POST", this.jdField_a_of_type_Bdje).a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_Bcqf.show();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755147);
    super.setContentView(2131559750);
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.a(ajya.a(2131701121));
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      bdii.e("BindGroupConfirmActivity", "initParams() mParams is null!");
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("union_name");
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
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupConfirmActivity", 2, "bindGroup appid =  guild id = " + this.h + "zone_id = " + this.i + " role id = " + this.j + "  group code= " + this.k + " guild name = " + this.l);
      }
      axqy.b(this.app, "CliOper", "", "", "0x80084B0", "0x80084B0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      new bdjd("http://fusionbase.qq.com/cgi-bin/appstage/mb_get_qqgroup_description", "POST", this).a(this.jdField_a_of_type_AndroidOsBundle);
      b();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupConfirmActivity", 2, " bindGroup is from game = false");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BindGroupActivity.b = true;
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690899));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690483));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity
 * JD-Core Version:    0.7.0.1
 */