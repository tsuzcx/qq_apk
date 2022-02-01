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
  public static boolean b = false;
  protected Resources a;
  protected Bundle a;
  protected Handler a;
  protected LayoutInflater a;
  protected View a;
  protected TextView a;
  protected OpenIdObserver a;
  HttpWebCgiAsyncTask.Callback a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  protected SlideDetectListView a;
  protected BindGroupActivity.GroupListAdapter a;
  protected String a;
  protected List<BindGroupActivity.GroupInfo> a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected QQProgressDialog b;
  protected String b;
  protected TextView c;
  protected String c;
  protected boolean c;
  protected TextView d;
  protected String d;
  protected TextView e;
  protected String e;
  
  public BindGroupActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new BindGroupActivity.2(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new BindGroupActivity.4(this);
  }
  
  protected void a()
  {
    String str = this.jdField_c_of_type_JavaLangString;
    if (str != null)
    {
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      if (localBundle != null) {
        localBundle.putString("openid", str);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Exception paramException)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.e("BindGroupActivity", 2, "-->onException", paramException);
    }
    if ((paramException instanceof ConnectTimeoutException)) {
      paramException = Constants.jdField_e_of_type_JavaLangString;
    } else if ((paramException instanceof SocketTimeoutException)) {
      paramException = Constants.f;
    } else if ((paramException instanceof MalformedURLException)) {
      paramException = "访问url有误!";
    } else if ((paramException instanceof HttpBaseUtil.HttpStatusException)) {
      paramException = "Http返回码异常!";
    } else if ((paramException instanceof HttpBaseUtil.NetworkUnavailableException)) {
      paramException = Constants.g;
    } else if ((paramException instanceof JSONException)) {
      paramException = Constants.jdField_b_of_type_JavaLangString;
    } else if ((paramException instanceof IOException)) {
      paramException = Constants.jdField_a_of_type_JavaLangString;
    } else {
      paramException = Constants.jdField_d_of_type_JavaLangString;
    }
    QQToast.a(this, paramException, 0).a(super.getTitleBarHeight()).show();
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject1 != null) && (((QQProgressDialog)localObject1).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      int i;
      try
      {
        i = paramJSONObject.getInt("ret");
        if (i == 0)
        {
          paramJSONObject = paramJSONObject.getJSONArray("list");
          int j = paramJSONObject.length();
          this.jdField_a_of_type_JavaUtilList.clear();
          i = 0;
          if (i < j)
          {
            localObject1 = new BindGroupActivity.GroupInfo();
            try
            {
              localObject2 = paramJSONObject.getJSONObject(i);
              ((BindGroupActivity.GroupInfo)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("group_code");
              ((BindGroupActivity.GroupInfo)localObject1).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("name");
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(((JSONObject)localObject2).getString("face"));
              localStringBuilder.append("640");
              ((BindGroupActivity.GroupInfo)localObject1).jdField_c_of_type_JavaLangString = localStringBuilder.toString();
              this.jdField_a_of_type_JavaUtilList.add(localObject1);
            }
            catch (JSONException localJSONException)
            {
              if (!QLog.isColorLevel()) {
                break label333;
              }
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("The JSONObject has error!");
            ((StringBuilder)localObject2).append(localJSONException.getMessage());
            QLog.d("BindGroupActivity", 2, ((StringBuilder)localObject2).toString());
          }
          else
          {
            if (this.jdField_a_of_type_JavaUtilList.size() > 0)
            {
              this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter.notifyDataSetChanged();
              return;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("BindGroupActivity", 2, "The JSONObject has error!");
          }
          QQToast.a(this, paramJSONObject.getString("msg"), 0).a(super.getTitleBarHeight()).show();
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        a(paramJSONObject);
        return;
      }
      label333:
      i += 1;
    }
  }
  
  protected void b()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (!localQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695174, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701336));
    }
    OpenID localOpenID = this.app.getMsgHandler().a(this.jdField_d_of_type_JavaLangString);
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID))) {
      this.jdField_c_of_type_JavaLangString = localOpenID.openID;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("uin", this.app.getCurrentAccountUin());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->checkAccountDiff, mOpenid: ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("BindGroupActivity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
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
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692930);
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new BindGroupActivity.3(this), 3000L);
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
      GetOpenID.a(this.app.getMsgHandler(), this.jdField_d_of_type_JavaLangString);
      return;
    }
    if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
    {
      this.jdField_c_of_type_JavaLangString = localOpenID.openID;
      this.jdField_a_of_type_AndroidOsBundle.putString("openid", this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Boolean = true;
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == paramDialogInterface)
    {
      if (paramInt == 1)
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("is_change_account", true);
        paramDialogInterface.putExtra("if_check_account_same", true);
        paramDialogInterface.putExtras(this.jdField_a_of_type_AndroidOsBundle);
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
      int i = paramView.getId();
      if (i != 2131365319)
      {
        if (i == 2131369202) {
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
    super.setTheme(2131755317);
    super.onCreate(paramBundle);
    super.setContentView(2131559947);
    paramBundle = findViewById(2131376809);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      ImmersiveUtils.setFitsSystemWindows(paramBundle, true);
    }
    this.jdField_a_of_type_AndroidContentResResources = super.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = super.getLayoutInflater();
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    paramBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (paramBundle == null) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("openid");
    if ((this.jdField_b_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mOpenId is null");
    }
    paramBundle = super.getSharedPreferences("openid_encrytoken", 4);
    this.jdField_a_of_type_AndroidOsBundle.putString("encrytoken", paramBundle.getString(this.jdField_b_of_type_JavaLangString, ""));
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("appid");
    if ((this.jdField_d_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("BindGroupActivity", 2, "mAppId is null");
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString != null))
    {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("is_from_game");
      try
      {
        paramBundle = QConfigLocalLoader.a(BaseApplicationImpl.getApplication());
        if ((("true".equals(this.jdField_e_of_type_JavaLangString)) || (paramBundle.b())) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
        {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1001, null);
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
        if (("true".equals(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.app, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, 1001, null);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("bindGroup loadConfig exception = ");
        localStringBuilder.append(paramBundle);
        QLog.d("BindGroupActivity", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131701331));
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      this.jdField_a_of_type_AndroidOsBundle.putString("skey", super.getIntent().getStringExtra("skey"));
      this.jdField_a_of_type_AndroidOsBundle.putString("uin", super.getIntent().getStringExtra("uin"));
      c();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369204));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131371967);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)super.findViewById(2131381293));
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this);
      if (this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter == null) {
        this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter = new BindGroupActivity.GroupListAdapter(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentBindGroupActivity$GroupListAdapter);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371911);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365319));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
    }
    super.setResult(0);
    super.finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    jdField_b_of_type_Boolean = false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (BindGroupActivity.GroupInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramAdapterView != null)
    {
      paramView = new Intent(this, BindGroupConfirmActivity.class);
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      if (localBundle != null)
      {
        localBundle.putString("group_code", paramAdapterView.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_name", paramAdapterView.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("group_avatar_url", paramAdapterView.jdField_c_of_type_JavaLangString);
      }
      paramView.putExtra("key_params", this.jdField_a_of_type_AndroidOsBundle);
      super.startActivityForResult(paramView, 1000);
      overridePendingTransition(2130772006, 2130772007);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131690652));
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_Boolean))
    {
      if (!jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      new HttpCgiAsyncTask("https://fusionbase.qq.com/cgi-bin/appstage/mb_get_created_qqgroup_list", "POST", this, true).a(this.jdField_a_of_type_AndroidOsBundle);
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