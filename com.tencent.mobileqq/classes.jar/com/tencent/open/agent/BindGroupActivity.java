package com.tencent.open.agent;

import ajjy;
import alzv;
import ameh;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import aynk;
import azgl;
import azlj;
import babr;
import bafb;
import bbms;
import bbmy;
import bbuu;
import bbuv;
import bbux;
import bbuy;
import bcab;
import bcen;
import bceo;
import bcew;
import behi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import mps;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BindGroupActivity
  extends BaseActivity
  implements DialogInterface.OnClickListener, View.OnClickListener, bcab, bceo, behi
{
  public static boolean b;
  protected Resources a;
  protected Bundle a;
  public Handler a;
  public LayoutInflater a;
  protected View a;
  protected TextView a;
  azgl a;
  public bafb a;
  protected bbms a;
  protected bbuy a;
  protected SlideDetectListView a;
  protected String a;
  public List<bbux> a;
  protected mps a;
  protected boolean a;
  protected View b;
  protected TextView b;
  public bbms b;
  public String b;
  protected TextView c;
  public String c;
  public boolean c;
  protected TextView d;
  protected String d;
  protected TextView e;
  protected String e;
  
  public BindGroupActivity()
  {
    this.jdField_a_of_type_Mps = new bbuu(this);
    this.jdField_a_of_type_Azgl = new bbuv(this);
  }
  
  public void a()
  {
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_AndroidOsBundle != null)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bbms.show();
    new bcen("http://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this).a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Exception paramException)
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("BindGroupActivity", 2, "-->onException", paramException);
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = bcew.jdField_e_of_type_JavaLangString;
    }
    for (;;)
    {
      bbmy.a(this, paramException, 0).a(super.getTitleBarHeight()).show();
      return;
      if ((paramException instanceof SocketTimeoutException)) {
        paramException = bcew.f;
      } else if ((paramException instanceof MalformedURLException)) {
        paramException = "访问url有误!";
      } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
        paramException = "Http返回码异常!";
      } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
        paramException = bcew.g;
      } else if ((paramException instanceof JSONException)) {
        paramException = bcew.jdField_b_of_type_JavaLangString;
      } else if ((paramException instanceof IOException)) {
        paramException = bcew.jdField_a_of_type_JavaLangString;
      } else {
        paramException = bcew.jdField_d_of_type_JavaLangString;
      }
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onImageLoaded() url = " + paramString1);
    }
    runOnUiThread(new BindGroupActivity.1(this, paramString1, paramBitmap));
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->onResult, result: " + paramJSONObject);
    }
    try
    {
      if (paramJSONObject.getInt("ret") != 0) {
        break label266;
      }
      paramJSONObject = paramJSONObject.getJSONArray("list");
      int j = paramJSONObject.length();
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          bbux localbbux = new bbux();
          try
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            localbbux.jdField_a_of_type_JavaLangString = localJSONObject.getString("group_code");
            localbbux.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
            localbbux.jdField_c_of_type_JavaLangString = (localJSONObject.getString("face") + "640");
            this.jdField_a_of_type_JavaUtilList.add(localbbux);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("BindGroupActivity", 2, "The JSONObject has error!" + localJSONException.getMessage());
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label248;
      }
    }
    catch (Exception paramJSONObject)
    {
      a(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_Bbuy.notifyDataSetChanged();
    return;
    label248:
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    return;
    label266:
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
    }
    bbmy.a(this, paramJSONObject.getString("msg"), 0).a(super.getTitleBarHeight()).show();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bafb != null) && (!this.jdField_a_of_type_Bafb.isShowing()))
    {
      this.jdField_a_of_type_Bafb.show();
      return;
    }
    this.jdField_a_of_type_Bafb = babr.a(this, 230);
    this.jdField_a_of_type_Bafb.setMessage(2131629880);
    this.jdField_a_of_type_Bafb.setTitle(2131626648);
    this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, this);
    this.jdField_a_of_type_Bafb.setPositiveButton(2131629850, this);
    this.jdField_a_of_type_Bafb.show();
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_Bbms == null)
    {
      this.jdField_b_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
      this.jdField_b_of_type_Bbms.a(ajjy.a(2131635324));
    }
    OpenID localOpenID = this.app.a().a(this.jdField_d_of_type_JavaLangString);
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID))) {
      this.jdField_c_of_type_JavaLangString = localOpenID.openID;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.app.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, mOpenid: " + this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
      {
        this.jdField_b_of_type_Bbms.c(2131627396);
        this.jdField_b_of_type_Bbms.show();
        this.jdField_a_of_type_AndroidOsHandler = new Handler();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new BindGroupActivity.3(this), 3000L);
        this.app.addObserver(this.jdField_a_of_type_Mps);
        this.app.a().d(this.jdField_d_of_type_JavaLangString);
        return;
      }
      if (!this.jdField_b_of_type_JavaLangString.equals(localOpenID.openID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
        }
        b();
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      this.jdField_c_of_type_JavaLangString = localOpenID.openID;
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    super.finish();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Bafb == paramDialogInterface)
    {
      if (paramInt != 1) {
        break label91;
      }
      paramDialogInterface = new Intent(this, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      paramDialogInterface.putExtra("key_action", BindGroupActivity.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      super.startActivity(paramDialogInterface);
      super.finish();
    }
    label91:
    while (paramInt != 0) {
      return;
    }
    super.setResult(0);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131299270: 
        paramView = (aynk)this.app.getManager(32);
      }
    } while (paramView == null);
    paramView.a(this, 0);
    return;
    super.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.setTheme(2131689611);
    super.onCreate(paramBundle);
    super.setContentView(2131494177);
    paramBundle = findViewById(2131309736);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.a(paramBundle, true);
    }
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("openid");
    if ((this.jdField_b_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mOpenId is null");
    }
    paramBundle = super.getSharedPreferences("openid_encrytoken", 4);
    this.jdField_a_of_type_AndroidOsBundle.putString("encrytoken", paramBundle.getString(this.jdField_b_of_type_JavaLangString, ""));
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    if ((this.jdField_d_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mAppId is null");
    }
    if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null))
    {
      super.setResult(0);
      super.finish();
      return;
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("is_from_game");
    try
    {
      paramBundle = alzv.a(BaseApplicationImpl.getApplication());
      if ((("true".equals(this.jdField_e_of_type_JavaLangString)) || (paramBundle.b())) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
      {
        azlj.a(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Azgl, 1001, null);
        if (QLog.isColorLevel()) {
          QLog.d("BindGroupActivity", 2, "bindGroup enableCheckPermission = " + paramBundle.b());
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (("true".equals(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
          azlj.a(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Azgl, 1001, null);
        }
        QLog.d("BindGroupActivity", 1, "bindGroup loadConfig exception = " + paramBundle);
      }
    }
    this.jdField_a_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bbms.a(ajjy.a(2131635319));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
    this.jdField_a_of_type_AndroidOsBundle.putString("skey", super.getIntent().getStringExtra("skey"));
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", super.getIntent().getStringExtra("uin"));
    c();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302804));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302806));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302832));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302847));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131305250);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)super.findViewById(2131313707));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this);
    if (this.jdField_a_of_type_Bbuy == null) {
      this.jdField_a_of_type_Bbuy = new bbuy(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Bbuy);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131305193);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299270));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_b_of_type_Boolean = false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (bbux)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this, BindGroupConfirmActivity.class);
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("group_code", paramAdapterView.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_name", paramAdapterView.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_avatar_url", paramAdapterView.jdField_c_of_type_JavaLangString);
      }
      paramView.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
      super.startActivityForResult(paramView, 1000);
      overridePendingTransition(2130771992, 2130771993);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131624921));
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bbms.show();
      }
      new bcen("http://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this).a(this.jdField_a_of_type_AndroidOsBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BindGroupActivity", 2, "-->onStart, start load group list.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity
 * JD-Core Version:    0.7.0.1
 */