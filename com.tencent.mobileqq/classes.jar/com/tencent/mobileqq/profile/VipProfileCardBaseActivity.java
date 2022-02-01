package com.tencent.mobileqq.profile;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class VipProfileCardBaseActivity
  extends IphoneTitleBarActivity
{
  protected float a;
  protected int a;
  public long a;
  protected Context a;
  public DialogInterface.OnClickListener a;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  public CardHandler a;
  protected CardObserver a;
  protected QQCustomDialog a;
  protected QQProgressDialog a;
  public Runnable a;
  protected String a;
  protected ArrayList<ProfileCardTemplate> a;
  protected boolean a;
  protected int b;
  public DialogInterface.OnClickListener b;
  protected QQCustomDialog b;
  public String b;
  protected boolean b;
  protected int c;
  public DialogInterface.OnClickListener c;
  protected int d;
  public DialogInterface.OnClickListener d;
  protected int e = 1;
  public int f = 2;
  public int g;
  public int h = -1;
  public int i = 30000;
  protected int j;
  protected int k;
  protected int l;
  
  public VipProfileCardBaseActivity()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_g_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidOsHandler = new VipProfileCardBaseActivity.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new VipProfileCardBaseActivity.2(this);
    this.jdField_a_of_type_JavaLangRunnable = new VipProfileCardBaseActivity.3(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardBaseActivity.4(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardBaseActivity.5(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardBaseActivity.6(this);
    this.jdField_d_of_type_AndroidContentDialogInterface$OnClickListener = new VipProfileCardBaseActivity.7(this);
  }
  
  protected int a(String paramString, DownloadListener paramDownloadListener)
  {
    if (ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString)) {
      return 19;
    }
    paramString = new DownloadTask(paramString, new File(ProfileCardUtil.a(this.jdField_a_of_type_AndroidContentContext, paramString)));
    if (paramDownloadListener != null) {
      paramString.a(paramDownloadListener);
    }
    paramString.f = "profileCardDownload";
    paramString.e = "VIP_profilecard";
    return DownloaderFactory.a(paramString, this.app);
  }
  
  public ArrayList<ProfileCardTemplate> a()
  {
    int m;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = ProfileCardUtil.a(this.app, false, false);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        m = 0;
        if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label131;
        }
        localProfileCardTemplate = (ProfileCardTemplate)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if ((localProfileCardTemplate == null) || (localProfileCardTemplate.o != ProfileCardTemplate.jdField_g_of_type_Long)) {
          break label124;
        }
      }
    }
    label131:
    for (ProfileCardTemplate localProfileCardTemplate = ProfileCardUtil.a(localProfileCardTemplate);; localProfileCardTemplate = null)
    {
      if (localProfileCardTemplate != null)
      {
        localProfileCardTemplate.o = ProfileCardTemplate.n;
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localProfileCardTemplate);
      }
      ProfileCardUtil.a(this.app);
      return this.jdField_a_of_type_JavaUtilArrayList;
      label124:
      m += 1;
      break;
    }
  }
  
  protected void a() {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, null, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695142);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      label53:
      this.app.execute(new VipProfileCardBaseActivity.8(this, paramLong1, paramLong2, paramString, paramInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.i);
      return;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }
  
  public void a(ProfileCardBackground paramProfileCardBackground)
  {
    if (paramProfileCardBackground == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardBackground.jdField_d_of_type_Int != 1) || (l1 >= paramProfileCardBackground.f) || (l1 <= paramProfileCardBackground.e));
    paramProfileCardBackground.jdField_c_of_type_Int = 1;
  }
  
  public void a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramProfileCardTemplate.e != 1) || (l1 >= paramProfileCardTemplate.jdField_g_of_type_Int) || (l1 <= paramProfileCardTemplate.f));
    paramProfileCardTemplate.c = "1";
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.a(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  protected boolean a(ProfileCardTemplate paramProfileCardTemplate, ProfileCardBackground paramProfileCardBackground, boolean paramBoolean)
  {
    if ((paramProfileCardTemplate != null) && (paramProfileCardBackground != null))
    {
      if (paramProfileCardTemplate.o == 0L) {
        return true;
      }
      int i1 = Integer.valueOf(paramProfileCardTemplate.c).intValue();
      int m = paramProfileCardBackground.jdField_c_of_type_Int;
      boolean bool = ProfileCardUtil.a(paramProfileCardBackground);
      if (bool) {
        m = paramProfileCardTemplate.l;
      }
      if (i1 >= m)
      {
        this.jdField_c_of_type_Int = 1;
        if (i1 == m) {
          this.jdField_c_of_type_Int = 2;
        }
      }
      for (int n = i1;; n = m)
      {
        this.jdField_b_of_type_Int = n;
        if ((n != 0) && (n != 1)) {
          break;
        }
        return true;
        this.jdField_c_of_type_Int = 0;
      }
      if (n == 2)
      {
        if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Int = 1;
          if (bool) {
            this.jdField_a_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
            }
            return false;
            if (this.e == 1) {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i1, m, this.jdField_a_of_type_Int);
            } else {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(3);
            }
          }
        }
      }
      else if (n == 4)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Int = 2;
          if (bool) {
            this.jdField_a_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
          }
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
            }
            return false;
            if (this.e == 1) {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i1, m, this.jdField_a_of_type_Int);
            } else {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(6);
            }
          }
        }
      }
      else if (n == 5) {
        return true;
      }
    }
    return true;
  }
  
  public long[] a()
  {
    ArrayList localArrayList = a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0)
      {
        localObject1 = new long[localArrayList.size()];
        int m = 0;
        while (m < localArrayList.size())
        {
          localObject1[m] = ((ProfileCardTemplate)localArrayList.get(m)).o;
          m += 1;
        }
      }
    }
    return localObject1;
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   11: invokevirtual 367	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   21: invokevirtual 370	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 215	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	VipProfileCardBaseActivity
    //   30	1	1	localException	Exception
    //   37	7	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	30	java/lang/Exception
    //   17	24	37	finally
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = VipUtils.b(this.app);
    this.jdField_a_of_type_Boolean = VipUtils.c(this.app);
  }
  
  protected void d()
  {
    e();
    String str2;
    String str1;
    if (this.jdField_a_of_type_Int == 2)
    {
      str2 = getString(2131695080);
      if (this.jdField_c_of_type_Int == 2) {
        str1 = getString(2131695083);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str2, str1, 2131695078, 2131695079, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        str1 = getString(2131695085);
      }
      else
      {
        str1 = getString(2131695081);
        continue;
        str2 = getString(2131695087);
        if (this.jdField_c_of_type_Int == 2) {
          str1 = getString(2131695084);
        } else if (this.jdField_c_of_type_Int == 1) {
          str1 = getString(2131695086);
        } else {
          str1 = getString(2131695082);
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(9)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getResources().getDisplayMetrics();
    this.k = paramBundle.widthPixels;
    this.j = paramBundle.heightPixels;
    this.l = paramBundle.densityDpi;
    this.jdField_a_of_type_Float = paramBundle.density;
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    e();
    b();
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void f()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void g()
  {
    Object localObject2 = null;
    Intent localIntent = getIntent();
    Object localObject1 = localObject2;
    if (localIntent != null)
    {
      localObject1 = localObject2;
      if (localIntent.hasExtra("ExternAid")) {
        localObject1 = localIntent.getStringExtra("ExternAid");
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 2)
      {
        VasH5PayUtil.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000516", "CJCLUBT", getString(2131719674), "svip");
        ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
        return;
      }
      VasH5PayUtil.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000515", "LTMCLUB", getString(2131695088), "vip");
      ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return;
    }
  }
  
  public void h()
  {
    Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentAccountUin());
    if (localCard != null)
    {
      if (localCard.templateRet != 0)
      {
        this.jdField_a_of_type_Long = 0L;
        this.jdField_g_of_type_Int = -1;
        this.h = 1;
        this.jdField_b_of_type_JavaLangString = null;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_g_of_type_Int), Integer.valueOf(this.h), this.jdField_b_of_type_JavaLangString }));
      }
      return;
    }
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      if (localCard.cardType == 2) {}
      for (l1 = ProfileCardTemplate.n;; l1 = (int)localCard.lCurrentStyleId)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_g_of_type_Int = ((int)localCard.lCurrentBgId);
        this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
        this.h = ((int)localCard.backgroundColor);
        label170:
        if (this.jdField_a_of_type_Long != -1L) {
          break label287;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
      }
    }
    if (!localIntent.hasExtra("CurrentTemplateId")) {
      if (localCard.cardType != 2) {
        break label289;
      }
    }
    label287:
    label289:
    for (long l1 = ProfileCardTemplate.n;; l1 = (int)localCard.lCurrentStyleId)
    {
      this.jdField_a_of_type_Long = l1;
      if (!localIntent.hasExtra("CurrentBackgroundId")) {
        this.jdField_g_of_type_Int = ((int)localCard.lCurrentBgId);
      }
      if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
        this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
      }
      if (localIntent.hasExtra("CurrentBackgroundColor")) {
        break label170;
      }
      this.h = ((int)localCard.backgroundColor);
      break label170;
      break;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      String str = null;
      if (paramIntent.hasExtra("result"))
      {
        Object localObject = paramIntent.getStringExtra("result");
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, resultStr : " + (String)localObject);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          try
          {
            localObject = new JSONObject((String)localObject);
            if (localObject == null) {
              return;
            }
            localObject = ((JSONObject)localObject).get("payState");
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, stateObj : " + localObject);
            }
            if ((localObject == null) || (!"0".equals(String.valueOf(localObject)))) {
              return;
            }
            if (paramIntent.hasExtra("callbackSn")) {
              str = paramIntent.getStringExtra("callbackSn");
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, callbackSn : " + str);
            }
            if ("svip".equals(str)) {
              this.jdField_b_of_type_Boolean = true;
            }
            for (;;)
            {
              a();
              return;
              this.jdField_a_of_type_Boolean = true;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, "onActivityResult, data contain no result key.");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity
 * JD-Core Version:    0.7.0.1
 */