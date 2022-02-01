package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.base.http.HttpCgiAsyncTask.Callback;
import com.tencent.open.business.base.Constants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGroupActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, ImageLoader.ImageLoadListener, HttpCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  public static boolean t = false;
  HttpWebCgiAsyncTask.Callback A = new BindGroupActivity.4(this);
  protected TextView a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected View f;
  protected View g;
  protected SlideDetectListView h;
  protected LayoutInflater i;
  protected Resources j;
  protected BindGroupActivity.GroupListAdapter k;
  protected Bundle l;
  protected List<BindGroupActivity.GroupInfo> m;
  protected String n;
  protected String o;
  protected String p;
  protected String q;
  protected boolean r = false;
  protected QQProgressDialog s;
  protected String u;
  protected QQProgressDialog v;
  protected Handler w;
  protected boolean x;
  protected QQCustomDialog y;
  protected OpenIdObserver z = new BindGroupActivity.2(this);
  
  protected void a()
  {
    String str = this.p;
    if (str != null)
    {
      Bundle localBundle = this.l;
      if (localBundle != null) {
        localBundle.putString("openid", str);
      }
    }
    this.s.show();
    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).a(this.l);
    this.r = true;
  }
  
  public void a(Exception paramException)
  {
    QQProgressDialog localQQProgressDialog = this.s;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.s.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("BindGroupActivity", 2, "-->onException", paramException);
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
    QQToast.makeText(this, paramException, 0).create(super.getTitleBarHeight()).show();
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("-->onImageLoaded() url = ");
      paramString2.append(paramString1);
      QLog.d("BindGroupActivity", 2, paramString2.toString());
    }
    runOnUiThread(new BindGroupActivity.1(this, paramString1, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    Object localObject1 = this.s;
    if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing())) {
      this.s.dismiss();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("-->onResult, result: ");
      ((StringBuilder)localObject1).append(paramJSONObject);
      QLog.d("BindGroupActivity", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i1;
      try
      {
        i1 = paramJSONObject.getInt("ret");
        if (i1 == 0)
        {
          paramJSONObject = paramJSONObject.getJSONArray("list");
          int i2 = paramJSONObject.length();
          this.m.clear();
          i1 = 0;
          if (i1 < i2)
          {
            localObject1 = new BindGroupActivity.GroupInfo();
            try
            {
              localObject2 = paramJSONObject.getJSONObject(i1);
              ((BindGroupActivity.GroupInfo)localObject1).a = ((JSONObject)localObject2).getString("group_code");
              ((BindGroupActivity.GroupInfo)localObject1).b = ((JSONObject)localObject2).getString("name");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(((JSONObject)localObject2).getString("face"));
              localStringBuilder.append("640");
              ((BindGroupActivity.GroupInfo)localObject1).c = localStringBuilder.toString();
              this.m.add(localObject1);
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                break label337;
              }
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("The JSONObject has error!");
            ((StringBuilder)localObject2).append(localJSONException.getMessage());
            QLog.d("BindGroupActivity", 2, ((StringBuilder)localObject2).toString());
          }
          else
          {
            if (this.m.size() > 0)
            {
              this.k.notifyDataSetChanged();
              return;
            }
            this.f.setVisibility(8);
            this.g.setVisibility(0);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
          }
          QQToast.makeText(this, paramJSONObject.getString("msg"), 0).create(super.getTitleBarHeight()).show();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      label337:
      i1 += 1;
    }
  }
  
  protected void b()
  {
    QQCustomDialog localQQCustomDialog = this.y;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()))
    {
      this.y.show();
      return;
    }
    this.y = DialogUtil.a(this, 230);
    this.y.setMessage(2131892939);
    this.y.setTitle(2131889094);
    this.y.setNegativeButton(2131887648, this);
    this.y.setPositiveButton(2131892907, this);
    this.y.show();
  }
  
  protected void c()
  {
    if (this.v == null)
    {
      this.v = new QQProgressDialog(this, super.getTitleBarHeight());
      this.v.a(HardCodeUtil.a(2131899346));
    }
    OpenID localOpenID = this.app.getMsgHandler().e(this.q);
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID))) {
      this.p = localOpenID.openID;
    }
    this.l.putString("uin", this.app.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->checkAccountDiff, mOpenid: ");
      localStringBuilder.append(this.o);
      QLog.d("BindGroupActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.o))
    {
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
        if (!this.o.equals(localOpenID.openID))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
          }
          b();
          return;
        }
        this.r = true;
        return;
      }
      this.v.c(2131890041);
      this.v.show();
      this.w = new Handler();
      this.w.postDelayed(new BindGroupActivity.3(this), 3000L);
      this.app.addObserver(this.z);
      GetOpenID.a(this.app.getMsgHandler(), this.q);
      return;
    }
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      this.p = localOpenID.openID;
      this.l.putString("openid", this.p);
    }
    this.r = true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1000) {
      return;
    }
    if (paramInt2 == -1) {
      super.finish();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.y == paramDialogInterface)
    {
      if (paramInt == 1)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("is_change_account", true);
        paramDialogInterface.putExtra("if_check_account_same", true);
        paramDialogInterface.putExtras(this.l);
        paramDialogInterface.putExtra("key_action", BindGroupActivity.class.getSimpleName());
        paramDialogInterface.addFlags(268435456);
        paramDialogInterface.addFlags(67108864);
        RouteUtils.a(this, paramDialogInterface, "/base/login");
        super.finish();
        return;
      }
      if (paramInt == 0)
      {
        super.setResult(0);
        super.finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null)
    {
      int i1 = paramView.getId();
      if (i1 != 2131431502)
      {
        if (i1 == 2131436180) {
          super.finish();
        }
      }
      else
      {
        ITroopCreateService localITroopCreateService = (ITroopCreateService)this.app.getRuntimeService(ITroopCreateService.class, "");
        if (localITroopCreateService != null) {
          localITroopCreateService.startCreateTroopSession(this, 0);
        }
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
    super.setTheme(2131952010);
    super.onCreate(paramBundle);
    super.setContentView(2131625990);
    paramBundle = findViewById(2131445137);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    this.j = super.getResources();
    this.i = super.getLayoutInflater();
    this.l = super.getIntent().getBundleExtra("key_params");
    paramBundle = this.l;
    if (paramBundle == null) {
      return;
    }
    this.o = paramBundle.getString("openid");
    if ((this.o == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mOpenId is null");
    }
    paramBundle = super.getSharedPreferences("openid_encrytoken", 4);
    this.l.putString("encrytoken", paramBundle.getString(this.o, ""));
    this.q = this.l.getString("appid");
    if ((this.q == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mAppId is null");
    }
    if ((this.q != null) && (this.o != null))
    {
      this.u = this.l.getString("is_from_game");
      try
      {
        paramBundle = QConfigLocalLoader.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(this.u)) || (paramBundle.b())) && (!TextUtils.isEmpty(this.q)))
        {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.q, this.A, 1001, null);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("bindGroup enableCheckPermission = ");
            localStringBuilder.append(paramBundle.b());
            QLog.d("BindGroupActivity", 2, localStringBuilder.toString());
          }
        }
      }
      catch (Exception paramBundle)
      {
        if (("true".equals(this.u)) && (!TextUtils.isEmpty(this.q))) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.q, this.A, 1001, null);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bindGroup loadConfig exception = ");
        localStringBuilder.append(paramBundle);
        QLog.d("BindGroupActivity", 1, localStringBuilder.toString());
      }
      this.s = new QQProgressDialog(this, super.getTitleBarHeight());
      this.s.a(HardCodeUtil.a(2131899341));
      this.m = new ArrayList();
      this.n = this.l.getString("app_name");
      this.l.putString("skey", super.getIntent().getStringExtra("skey"));
      this.l.putString("uin", super.getIntent().getStringExtra("uin"));
      c();
      this.a = ((TextView)super.findViewById(2131436180));
      this.b = ((TextView)super.findViewById(2131436182));
      this.c = ((TextView)super.findViewById(2131436211));
      this.d = ((TextView)super.findViewById(2131436227));
      this.f = super.findViewById(2131439412);
      this.h = ((SlideDetectListView)super.findViewById(2131450345));
      this.h.setOnItemClickListener(this);
      if (this.k == null) {
        this.k = new BindGroupActivity.GroupListAdapter(this);
      }
      this.h.setAdapter(this.k);
      this.g = super.findViewById(2131439356);
      this.g.setVisibility(8);
      this.e = ((TextView)super.findViewById(2131431502));
      this.e.setOnClickListener(this);
      return;
    }
    super.setResult(0);
    super.finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    t = false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (BindGroupActivity.GroupInfo)this.m.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this, BindGroupConfirmActivity.class);
      Bundle localBundle = this.l;
      if (localBundle != null)
      {
        localBundle.putString("group_code", paramAdapterView.a);
        this.l.putString("group_name", paramAdapterView.b);
        this.l.putString("group_avatar_url", paramAdapterView.c);
      }
      paramView.putExtra("key_params", this.l);
      super.startActivityForResult(paramView, 1000);
      overridePendingTransition(2130772009, 2130772010);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a.setVisibility(0);
    this.a.setText(this.n);
    this.a.setOnClickListener(this);
    this.b.setVisibility(4);
    this.c.setVisibility(4);
    this.d.setText(this.j.getString(2131887563));
    if ((this.l != null) && (this.r))
    {
      if (!t) {
        this.s.show();
      }
      new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).a(this.l);
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupActivity", 2, "-->onStart, start load group list.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity
 * JD-Core Version:    0.7.0.1
 */