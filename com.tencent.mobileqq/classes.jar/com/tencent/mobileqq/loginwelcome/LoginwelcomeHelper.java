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
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private LoginUserGuideHelper.LocationListener jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener;
  LoginWelcomeManager.ConvListener jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener = new LoginwelcomeHelper.1(this);
  boolean jdField_a_of_type_Boolean = true;
  private ViewGroup b;
  
  public LoginwelcomeHelper(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.b = paramViewGroup;
  }
  
  private void a(Context paramContext)
  {
    boolean bool2 = false;
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        if (Build.VERSION.SDK_INT >= 23) {
          bool2 = true;
        }
        QLog.i("LoginUserGuideHelper", 2, String.format("requestLocation [%s, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener = new LoginUserGuideHelper.LocationListener("Login.Guide");
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener.observerOnUiThread = true;
      }
      if (!bool1) {
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener);
      }
      return;
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if ((this.b != null) && (this.b.findViewById(2131365244) == null) && (paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
    return;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.b.getContext()).inflate(2131559046, null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364839);
      ((ImageView)localObject1).setContentDescription(HardCodeUtil.a(2131706376));
      ((ImageView)localObject1).setOnClickListener(new LoginwelcomeHelper.3(this));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
      Object localObject2 = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366995);
      ((Button)localObject2).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().getString(2131698650));
      ((Button)localObject2).setOnClickListener(new LoginwelcomeHelper.4(this, (Activity)localObject1));
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365948);
      ((TextView)localObject2).setContentDescription(((Activity)localObject1).getString(2131698649));
      ((TextView)localObject2).setOnClickListener(new LoginwelcomeHelper.5(this, (Activity)localObject1));
      localObject1 = (ThemeImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365295);
      ((ThemeImageView)localObject1).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      ((ThemeImageView)localObject1).setImageDrawable(paramURLDrawable);
    }
    this.b.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.b.addView(this.jdField_a_of_type_AndroidViewViewGroup);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    paramURLDrawable = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    paramURLDrawable.b = false;
    paramURLDrawable.jdField_a_of_type_Boolean = true;
    a(this.b.getContext());
  }
  
  private void a(LoginWelcomeManager.CommonGuideInfo paramCommonGuideInfo)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.c()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramCommonGuideInfo.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "Bad url: " + paramCommonGuideInfo.jdField_a_of_type_JavaLangString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "show common guide web");
    }
    Object localObject = BaseActivity.sTopActivity;
    Intent localIntent = new Intent((Context)localObject, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramCommonGuideInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("flag_show_loading_dialog", false);
    localIntent.putExtra("hide_left_button", true);
    localIntent.setData(Uri.parse(paramCommonGuideInfo.jdField_a_of_type_JavaLangString));
    ((Activity)localObject).startActivity(localIntent);
    localObject = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    ((LoginWelcomeManager)localObject).c = false;
    ((LoginWelcomeManager)localObject).jdField_a_of_type_Boolean = true;
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), paramCommonGuideInfo.jdField_a_of_type_Int);
  }
  
  private boolean a()
  {
    LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    return (localLoginWelcomeManager.b) || (localLoginWelcomeManager.c);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("isFirstLoginEnter=%s, shouldCheckOnResume=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(a()) }));
    }
    if ((!this.jdField_a_of_type_Boolean) && (a())) {
      ThreadManagerV2.postImmediately(new LoginwelcomeHelper.2(this), null, true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    h();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a != null) {
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$ConvListener);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a != null) {
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.LOGIN_WELCOME_MANAGER)).a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener != null)
    {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener);
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginUserGuideHelper$LocationListener = null;
    }
  }
  
  public void d()
  {
    g();
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    LoginWelcomeManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
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
    if ((this.b != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.b.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper
 * JD-Core Version:    0.7.0.1
 */