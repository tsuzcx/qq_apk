package com.tencent.mobileqq.loginwelcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import mqq.app.AppRuntime;

public class LoginwelcomeHelper
{
  Conversation a;
  ViewGroup b;
  boolean c = true;
  LoginWelcomeManager.ConvListener d = new LoginwelcomeHelper.1(this);
  private ViewGroup e;
  private LoginUserGuideHelper.LocationListener f;
  
  public LoginwelcomeHelper(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.a = paramConversation;
    this.e = paramViewGroup;
  }
  
  private void a(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1;
    if ((i >= 23) && (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      if (Build.VERSION.SDK_INT >= 23) {
        bool2 = true;
      }
      QLog.i("LoginUserGuideHelper", 2, String.format("requestLocation [%s, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    if (this.f == null)
    {
      this.f = new LoginUserGuideHelper.LocationListener("Login.Guide");
      this.f.observerOnUiThread = true;
    }
    if (!bool1) {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.f);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
    }
    if (!this.a.z())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
      return;
    }
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((ViewGroup)localObject1).findViewById(2131431268) == null) && (paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1) && (this.a.aF != null))
    {
      if (this.b == null)
      {
        this.b = ((ViewGroup)LayoutInflater.from(this.e.getContext()).inflate(2131624571, null));
        localObject1 = (ImageView)this.b.findViewById(2131430833);
        ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131904286));
        ((ImageView)localObject1).setOnClickListener(new LoginwelcomeHelper.3(this));
        localObject1 = this.a.P();
        Object localObject2 = (Button)this.b.findViewById(2131433174);
        ((Button)localObject2).setContentDescription(this.a.P().getString(2131896674));
        ((Button)localObject2).setOnClickListener(new LoginwelcomeHelper.4(this, (Activity)localObject1));
        localObject2 = (TextView)this.b.findViewById(2131432042);
        ((TextView)localObject2).setContentDescription(((Activity)localObject1).getString(2131896673));
        ((TextView)localObject2).setOnClickListener(new LoginwelcomeHelper.5(this, (Activity)localObject1));
        localObject1 = (ThemeImageView)this.b.findViewById(2131431323);
        ((ThemeImageView)localObject1).setMaskShape(ThemeImageWrapper.MODE_SQURE);
        ((ThemeImageView)localObject1).setImageDrawable(paramURLDrawable);
      }
      this.e.removeView(this.b);
      this.e.addView(this.b);
      LoginWelcomeManager.c(this.a.s());
      paramURLDrawable = LoginWelcomeManager.a(this.a.s());
      paramURLDrawable.i = false;
      paramURLDrawable.b = true;
      a(this.e.getContext());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
    }
  }
  
  private void a(LoginWelcomeManager.CommonGuideInfo paramCommonGuideInfo)
  {
    if (!this.a.z())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
      return;
    }
    if (TextUtils.isEmpty(paramCommonGuideInfo.b))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Bad url: ");
        ((StringBuilder)localObject).append(paramCommonGuideInfo.b);
        QLog.d("LoginWelcomeManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "show common guide web");
    }
    Object localObject = BaseActivity.sTopActivity;
    Intent localIntent = new Intent((Context)localObject, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramCommonGuideInfo.b);
    localIntent.putExtra("flag_show_loading_dialog", false);
    localIntent.putExtra("hide_left_button", true);
    localIntent.setData(Uri.parse(paramCommonGuideInfo.b));
    ((Activity)localObject).startActivity(localIntent);
    localObject = LoginWelcomeManager.a(this.a.s());
    ((LoginWelcomeManager)localObject).k = false;
    ((LoginWelcomeManager)localObject).b = true;
    LoginWelcomeManager.a(this.a.s(), paramCommonGuideInfo.a);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("isFirstLoginEnter=%s, shouldCheckOnResume=%s", new Object[] { Boolean.valueOf(this.c), Boolean.valueOf(i()) }));
    }
    if ((!this.c) && (i())) {
      ThreadManagerV2.postImmediately(new LoginwelcomeHelper.2(this), null, true);
    }
    this.c = false;
  }
  
  private boolean i()
  {
    LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.a.s());
    return (localLoginWelcomeManager.i) || (localLoginWelcomeManager.k);
  }
  
  public void a()
  {
    h();
  }
  
  public void b()
  {
    if (this.a.aF != null) {
      ((LoginWelcomeManager)this.a.aF.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(this.d);
    }
  }
  
  public void c()
  {
    if (this.a.aF != null) {
      ((LoginWelcomeManager)this.a.aF.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(null);
    }
    if (this.f != null)
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.f);
      this.f = null;
    }
  }
  
  public void d()
  {
    g();
    c();
    this.c = true;
  }
  
  public void e()
  {
    LoginWelcomeManager.d(this.a.s());
  }
  
  public void f()
  {
    g();
    c();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeContactsGuidelayer");
    }
    ViewGroup localViewGroup1 = this.e;
    if (localViewGroup1 != null)
    {
      ViewGroup localViewGroup2 = this.b;
      if (localViewGroup2 != null) {
        localViewGroup1.removeView(localViewGroup2);
      }
    }
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper
 * JD-Core Version:    0.7.0.1
 */