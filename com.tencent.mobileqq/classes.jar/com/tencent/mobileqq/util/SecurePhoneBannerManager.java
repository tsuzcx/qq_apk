package com.tencent.mobileqq.util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import mqq.os.MqqHandler;

public class SecurePhoneBannerManager
{
  private static volatile SecurePhoneBannerManager jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  private Dialog a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Dialog localDialog = CustomDialogFactory.a(paramContext, 2131755400);
    View localView = LayoutInflater.from(paramContext).inflate(2131560982, null);
    localDialog.setContentView(localView);
    Object localObject = (TextView)localView.findViewById(2131379790);
    TextView localTextView1 = (TextView)localView.findViewById(2131379566);
    TextView localTextView2 = (TextView)localView.findViewById(2131379520);
    TextView localTextView3 = (TextView)localView.findViewById(2131379595);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131370239);
    ((TextView)localObject).setText(this.c);
    localTextView3.setText(this.d);
    localObject = new GradientDrawable();
    float f = ViewUtils.b(10.0F);
    ((GradientDrawable)localObject).setCornerRadii(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
    ((GradientDrawable)localObject).setColor(paramContext.getResources().getColor(2131167223));
    localLinearLayout.setBackgroundDrawable((Drawable)localObject);
    int i = paramContext.getResources().getColor(2131167165);
    if (ThemeImageWrapper.isNightMode())
    {
      localLinearLayout.setBackgroundResource(2130850046);
      i = -16777216;
    }
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(6.0F, paramContext.getResources()));
    localTextView1.setBackgroundDrawable((Drawable)localObject);
    ((GradientDrawable)localObject).setColor(i);
    localTextView2.setOnClickListener(new SecurePhoneBannerManager.3(this, paramQQAppInterface, paramContext, localDialog));
    localTextView1.setOnClickListener(new SecurePhoneBannerManager.4(this, paramContext, paramQQAppInterface, localDialog));
    localLinearLayout.setOnClickListener(new SecurePhoneBannerManager.5(this));
    localView.setOnClickListener(new SecurePhoneBannerManager.6(this, paramContext, localDialog, paramQQAppInterface));
    return localDialog;
  }
  
  public static SecurePhoneBannerManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager == null) {
          jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager = new SecurePhoneBannerManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager;
  }
  
  private void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", this.jdField_a_of_type_JavaLangString));
  }
  
  private void a(Context paramContext, Dialog paramDialog)
  {
    if (paramDialog == null)
    {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim dialog is null");
      return;
    }
    if (paramContext == null)
    {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim context is null");
      return;
    }
    paramDialog = (LinearLayout)paramDialog.findViewById(2131370239);
    if (paramDialog != null) {
      paramDialog.startAnimation(AnimationUtils.loadAnimation(paramContext, 2130772378));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    QLog.d("SecurePhoneBannerManager", 1, "dismiss banner");
    BannerManager.a().a(SecurePhoneChangeNotifyBannerProcessor.jdField_a_of_type_Int, 0, null);
    this.jdField_a_of_type_Boolean = false;
    SharedPreUtils.a(paramContext, paramQQAppInterface.getAccount(), true, "sp_key_secure_phone_notice_time", Integer.valueOf(this.jdField_a_of_type_Int));
    if (paramInt == 1) {
      ThreadManager.getUIHandler().post(new SecurePhoneBannerManager.7(this, paramContext));
    }
    LoginVerifyServlet.b(paramQQAppInterface, paramInt, null);
  }
  
  private void b(Context paramContext, Dialog paramDialog)
  {
    if (paramDialog == null)
    {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim dialog is null");
      return;
    }
    if (paramContext == null)
    {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim context is null");
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)paramDialog.findViewById(2131370239);
    if (localLinearLayout != null)
    {
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130772379);
      paramContext.setAnimationListener(new SecurePhoneBannerManager.2(this, paramDialog));
      localLinearLayout.startAnimation(paramContext);
    }
  }
  
  public TipsBar a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurePhoneBannerManager", 2, "initSecurePhoneBanner");
    }
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(8);
    localTipsBar.a().setText(this.jdField_b_of_type_JavaLangString);
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839273));
    localTipsBar.setOriginalOnClickListener(new SecurePhoneBannerManager.1(this, paramQQAppInterface, paramContext));
    return localTipsBar;
  }
  
  public void a()
  {
    try
    {
      QLog.d("SecurePhoneBannerManager", 1, "destory");
      jdField_a_of_type_ComTencentMobileqqUtilSecurePhoneBannerManager = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState");
    if (paramQQAppInterface == null)
    {
      QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState, app is null");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, isShowing");
      }
      BannerManager.a().a(SecurePhoneChangeNotifyBannerProcessor.jdField_a_of_type_Int, 2, null);
      return;
    }
    if (!paramQQAppInterface.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not login");
      }
      return;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j == 0) {
      i = ((Integer)SharedPreUtils.a(paramContext, str, "sp_key_secure_phone_notice_time", Integer.valueOf(0))).intValue();
    }
    long l = i;
    if (System.currentTimeMillis() < l * 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not time");
      }
      return;
    }
    LoginVerifyServlet.b(paramQQAppInterface, new SecurePhoneBannerManager.8(this, paramQQAppInterface, paramContext, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SecurePhoneBannerManager
 * JD-Core Version:    0.7.0.1
 */