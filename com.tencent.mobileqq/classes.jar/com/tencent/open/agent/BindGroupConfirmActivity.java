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
  String A;
  protected final Handler B = new BindGroupConfirmActivity.2(this);
  protected Runnable C = new BindGroupConfirmActivity.5(this);
  HttpWebCgiAsyncTask.Callback D = new BindGroupConfirmActivity.7(this);
  private final HttpCgiAsyncTask.Callback E = new BindGroupConfirmActivity.1(this);
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected ImageView f;
  protected ImageView g;
  protected TextView h;
  protected TextView i;
  protected Button j;
  protected Bundle k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected Resources p;
  protected String q;
  protected String r;
  protected QQProgressDialog s;
  protected ShareAioResultDialog t;
  protected QQCustomDialog u;
  String v;
  String w;
  String x;
  String y;
  String z;
  
  private void a(String paramString)
  {
    getActivity().runOnUiThread(new BindGroupConfirmActivity.8(this, paramString));
  }
  
  private void b()
  {
    Object localObject = findViewById(2131445159);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows((View)localObject, true);
    }
    this.a = ((TextView)super.findViewById(2131436180));
    this.b = ((TextView)super.findViewById(2131436182));
    this.c = ((TextView)super.findViewById(2131436211));
    this.d = ((TextView)super.findViewById(2131436227));
    this.j = ((Button)super.findViewById(2131431226));
    this.j.setOnClickListener(this);
    this.e = ((TextView)super.findViewById(2131446686));
    this.f = ((ImageView)super.findViewById(2131447981));
    if (!TextUtils.isEmpty(this.m))
    {
      localObject = ImageLoader.a().a(this.m);
      if (localObject != null) {
        this.f.setImageBitmap((Bitmap)localObject);
      } else {
        ImageLoader.a().a(this.m, this);
      }
    }
    this.i = ((TextView)super.findViewById(2131448053));
    if (TextUtils.isEmpty(this.l)) {
      this.i.setText("QQ群");
    } else {
      this.i.setText(this.l);
    }
    this.g = ((ImageView)super.findViewById(2131428619));
    ThreadManager.executeOnSubThread(new BindGroupConfirmActivity.3(this));
    this.h = ((TextView)super.findViewById(2131428632));
    this.h.setText(this.r);
    if (!TextUtils.isEmpty(this.n)) {
      a(Long.valueOf(this.n).longValue());
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
      int i1 = 0;
      while (i1 < 10 - ((String)localObject1).length())
      {
        ((StringBuilder)localObject2).append("0");
        i1 += 1;
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
    ((Bundle)localObject1).putString("appid", this.n);
    ((Bundle)localObject1).putString("guild_id", this.w);
    ((Bundle)localObject1).putString("zone_id", this.x);
    ((Bundle)localObject1).putString("guild_name", this.A);
    ((Bundle)localObject1).putString("gc", this.z);
    ((Bundle)localObject1).putString("platid", "2");
    ((Bundle)localObject1).putString("roleid", this.y);
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
    new HttpWebCgiAsyncTask2(localStringBuilder1.toString(), "GET", this.D, 0, null).a((HashMap)localObject1);
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
    localGetAppinfoRequest.qqv.set(CommonDataAdapter.a().j());
    localGetAppinfoRequest.setHasFlag(true);
    if (!TextUtils.isEmpty(this.o)) {
      localGetAppinfoRequest.appUniqueIdentifier.set(this.o);
    }
    localGetAppinfoRequest.referer.set(6);
    Object localObject = new NewIntent(this, OpensdkServlet.class);
    ((NewIntent)localObject).setWithouLogin(true);
    ((NewIntent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
    ((NewIntent)localObject).putExtra("data", localGetAppinfoRequest.toByteArray());
    ((NewIntent)localObject).putExtra("cmd", "ConnAuthSvr.get_app_info");
    ((NewIntent)localObject).setObserver(new BindGroupConfirmActivity.6(this));
    super.getAppRuntime().startServlet((NewIntent)localObject);
    this.B.removeCallbacks(this.C);
    this.B.postDelayed(this.C, 30000L);
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
    this.B.post(new BindGroupConfirmActivity.4(this, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      int i1;
      try
      {
        int i2 = paramJSONObject.getInt("ret");
        i1 = 0;
        if (i2 == 0)
        {
          paramJSONObject = paramJSONObject.getJSONArray("list");
          i2 = paramJSONObject.length();
          localObject = new StringBuffer();
          if (i1 < i2)
          {
            try
            {
              JSONObject localJSONObject = paramJSONObject.getJSONObject(i1);
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
            this.e.setText((CharSequence)localObject);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupConfirmActivity", 2, "The JSONObject has error!");
          }
          if (this.e != null) {
            this.e.setText(this.p.getString(2131887568));
          }
          QQToast.makeText(this, paramJSONObject.getString("msg"), 0).create(getTitleBarHeight()).show();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Object localObject = this.e;
        if (localObject != null) {
          ((TextView)localObject).setText(this.p.getString(2131887568));
        }
        a(paramJSONObject);
      }
      return;
      label319:
      i1 += 1;
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
      paramException = Constants.e;
    } else if ((paramException instanceof SocketTimeoutException)) {
      paramException = Constants.f;
    } else if ((paramException instanceof MalformedURLException)) {
      paramException = "访问url有误!";
    } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
      paramException = "Http返回码异常!";
    } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
      paramException = Constants.g;
    } else if ((paramException instanceof JSONException)) {
      paramException = Constants.b;
    } else if ((paramException instanceof IOException)) {
      paramException = Constants.a;
    } else {
      paramException = Constants.d;
    }
    QQToast.makeText(this, paramException, 0).create(getTitleBarHeight()).show();
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
    overridePendingTransition(2130772005, 2130772006);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.t == paramDialogInterface)
    {
      if (paramInt == 0)
      {
        try
        {
          ForwardSdkShareOption.a(this, true, "action_game_bind_group", Long.valueOf(this.n).longValue(), 0, "");
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
    else if (this.u == paramDialogInterface)
    {
      paramDialogInterface.dismiss();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i1 = paramView.getId();
      if (i1 != 2131431226)
      {
        if (i1 == 2131436180) {
          finish();
        }
      }
      else if ("true".equals(this.v))
      {
        a();
      }
      else
      {
        new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_bind_qqgroup", "POST", this.E, true).a(this.k);
        this.s.show();
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
    super.setTheme(2131952010);
    super.setContentView(2131625991);
    this.p = super.getResources();
    this.s = new QQProgressDialog(this, getTitleBarHeight());
    this.s.a(HardCodeUtil.a(2131899348));
    this.k = super.getIntent().getBundleExtra("key_params");
    paramBundle = this.k;
    if (paramBundle == null)
    {
      LogUtility.e("BindGroupConfirmActivity", "initParams() mParams is null!");
      return;
    }
    this.r = paramBundle.getString("union_name");
    this.q = this.k.getString("app_name");
    this.l = this.k.getString("group_name");
    this.m = this.k.getString("group_avatar_url");
    this.o = this.k.getString("pkg_name");
    this.n = this.k.getString("appid");
    this.v = this.k.getString("is_from_game");
    if ("true".equals(this.v))
    {
      this.w = this.k.getString("unionid");
      this.x = this.k.getString("zoneid");
      this.y = this.k.getString("role_id");
      this.z = this.k.getString("group_code");
      this.A = this.r;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("bindGroup appid =  guild id = ");
        paramBundle.append(this.w);
        paramBundle.append("zone_id = ");
        paramBundle.append(this.x);
        paramBundle.append(" role id = ");
        paramBundle.append(this.y);
        paramBundle.append("  group code= ");
        paramBundle.append(this.z);
        paramBundle.append(" guild name = ");
        paramBundle.append(this.A);
        QLog.d("BindGroupConfirmActivity", 2, paramBundle.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "0x80084B0", "0x80084B0", 0, 0, "", "", "", "");
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("BindGroupConfirmActivity", 2, " bindGroup is from game = false");
    }
    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_qqgroup_description", "POST", this, true).a(this.k);
    b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BindGroupActivity.t = true;
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.setVisibility(0);
    this.a.setText(this.p.getString(2131887880));
    this.a.setOnClickListener(this);
    this.b.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setText(this.p.getString(2131887564));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity
 * JD-Core Version:    0.7.0.1
 */