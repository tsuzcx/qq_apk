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
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardTemplateUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
  public int g = -1;
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
    if (ProfileCardUtil.a(paramString)) {
      return 19;
    }
    paramString = new DownloadTask(paramString, new File(ProfileCardUtil.a(paramString)));
    if (paramDownloadListener != null) {
      paramString.a(paramDownloadListener);
    }
    paramString.f = "profileCardDownload";
    paramString.e = "VIP_profilecard";
    return DownloaderFactory.a(paramString, this.app);
  }
  
  public ArrayList<ProfileCardTemplate> a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = ProfileCardTemplateUtil.a(false, false);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        Object localObject2 = null;
        int m = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break;
          }
          localObject1 = (ProfileCardTemplate)this.jdField_a_of_type_JavaUtilArrayList.get(m);
          if ((localObject1 != null) && (((ProfileCardTemplate)localObject1).styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE))
          {
            localObject1 = ProfileCardTemplateUtil.a((ProfileCardTemplate)localObject1);
            break;
          }
          m += 1;
        }
        if (localObject1 != null)
        {
          ((ProfileCardTemplate)localObject1).styleId = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
          this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
        }
      }
      ProfileCardTemplateUtil.a(this.app);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  protected void a() {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, null, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    b();
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(localContext, ((BaseActivity)localContext).getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131695132);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      label55:
      this.app.execute(new VipProfileCardBaseActivity.8(this, paramLong1, paramLong2, paramString, paramInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.i);
      return;
    }
    catch (Exception localException)
    {
      break label55;
    }
  }
  
  public void a(ProfileCardBackground paramProfileCardBackground)
  {
    if (paramProfileCardBackground == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    if ((paramProfileCardBackground.jdField_d_of_type_Int == 1) && (l1 < paramProfileCardBackground.f) && (l1 > paramProfileCardBackground.e)) {
      paramProfileCardBackground.jdField_c_of_type_Int = 1;
    }
  }
  
  public void a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {
      return;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    if ((paramProfileCardTemplate.limitefreeType == 1) && (l1 < paramProfileCardTemplate.limitefreeEtime) && (l1 > paramProfileCardTemplate.limitefreeBtime)) {
      paramProfileCardTemplate.auth = "1";
    }
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
      if (paramProfileCardTemplate.styleId == 0L) {
        return true;
      }
      int i1 = Integer.valueOf(paramProfileCardTemplate.auth).intValue();
      int m = paramProfileCardBackground.jdField_c_of_type_Int;
      boolean bool1 = ProfileCardUtil.a(paramProfileCardBackground);
      if (bool1) {
        m = paramProfileCardTemplate.customBackgroundAuth;
      }
      int n;
      if (i1 >= m)
      {
        this.jdField_c_of_type_Int = 1;
        if (i1 == m) {
          this.jdField_c_of_type_Int = 2;
        }
        n = i1;
      }
      else
      {
        this.jdField_c_of_type_Int = 0;
        n = m;
      }
      this.jdField_b_of_type_Int = n;
      if (n != 0)
      {
        if (n == 1) {
          return true;
        }
        boolean bool2;
        if (n == 2)
        {
          bool2 = this.jdField_a_of_type_Boolean;
          if (!bool2)
          {
            boolean bool3 = this.jdField_b_of_type_Boolean;
            if (!bool3)
            {
              this.jdField_a_of_type_Int = 1;
              if (bool1) {
                this.jdField_a_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
              } else if (this.e == 1) {
                this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(bool2, bool3, i1, m, this.jdField_a_of_type_Int);
              } else {
                this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(3);
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
              }
              if (paramBoolean) {
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
              }
              return false;
            }
          }
        }
        else if (n == 4)
        {
          bool2 = this.jdField_b_of_type_Boolean;
          if (!bool2)
          {
            this.jdField_a_of_type_Int = 2;
            if (bool1) {
              this.jdField_a_of_type_JavaLangString = "mvip.gongneng.android.mingpian_zidingyi";
            } else if (this.e == 1) {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(this.jdField_a_of_type_Boolean, bool2, i1, m, this.jdField_a_of_type_Int);
            } else {
              this.jdField_a_of_type_JavaLangString = ProfileCardUtil.a(6);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString }));
            }
            if (paramBoolean) {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
            }
            return false;
          }
        }
        else if (n != 5) {}
      }
    }
    return true;
  }
  
  public long[] a()
  {
    ArrayList localArrayList = a();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      long[] arrayOfLong2 = new long[localArrayList.size()];
      int m = 0;
      for (;;)
      {
        arrayOfLong1 = arrayOfLong2;
        if (m >= localArrayList.size()) {
          break;
        }
        arrayOfLong2[m] = ((ProfileCardTemplate)localArrayList.get(m)).styleId;
        m += 1;
      }
    }
    long[] arrayOfLong1 = null;
    return arrayOfLong1;
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 218	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +33 -> 39
    //   9: aload_1
    //   10: invokevirtual 378	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   13: ifeq +26 -> 39
    //   16: aload_0
    //   17: getfield 218	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   20: invokevirtual 381	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   23: goto +11 -> 34
    //   26: astore_1
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 218	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 218	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   39: return
    //   40: astore_1
    //   41: goto -7 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	VipProfileCardBaseActivity
    //   4	6	1	localQQProgressDialog	QQProgressDialog
    //   26	7	1	localObject	Object
    //   40	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	23	26	finally
    //   16	23	40	java/lang/Exception
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = VasUtil.a(this.app).getVipStatus().isSVip();
    this.jdField_a_of_type_Boolean = VasUtil.a(this.app).getVipStatus().isVip();
  }
  
  protected void d()
  {
    e();
    String str2;
    int m;
    String str1;
    if (this.jdField_a_of_type_Int == 2)
    {
      str2 = getString(2131695070);
      m = this.jdField_c_of_type_Int;
      if (m == 2) {
        str1 = getString(2131695073);
      } else if (m == 1) {
        str1 = getString(2131695075);
      } else {
        str1 = getString(2131695071);
      }
    }
    else
    {
      str2 = getString(2131695077);
      m = this.jdField_c_of_type_Int;
      if (m != 2) {
        break label97;
      }
      str1 = getString(2131695074);
    }
    for (;;)
    {
      break;
      label97:
      if (m == 1) {
        str1 = getString(2131695076);
      } else {
        str1 = getString(2131695072);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 0, str2, str1, 2131695068, 2131695069, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
  protected boolean doOnCreate(Bundle paramBundle)
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    e();
    b();
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  protected void e()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void f()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  public void g()
  {
    Object localObject1 = getIntent();
    if ((localObject1 != null) && (((Intent)localObject1).hasExtra("ExternAid"))) {
      localObject1 = ((Intent)localObject1).getStringExtra("ExternAid");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Int == 2)
    {
      VasH5PayUtil.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject2, 3, "1450000516", "CJCLUBT", getString(2131719393), "svip");
      ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return;
    }
    VasH5PayUtil.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject2, 3, "1450000515", "LTMCLUB", getString(2131695078), "vip");
    ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
  }
  
  public void h()
  {
    Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentAccountUin());
    if (localCard != null) {
      if (localCard.templateRet != 0)
      {
        this.jdField_a_of_type_Long = 0L;
        this.g = -1;
        this.h = 1;
        this.jdField_b_of_type_JavaLangString = null;
      }
      else
      {
        Intent localIntent = getIntent();
        long l1;
        if (localIntent == null)
        {
          if (localCard.cardType == 2) {
            l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
          } else {
            l1 = (int)localCard.lCurrentStyleId;
          }
          this.jdField_a_of_type_Long = l1;
          this.g = ((int)localCard.lCurrentBgId);
          this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
          this.h = ((int)localCard.backgroundColor);
        }
        else
        {
          if (!localIntent.hasExtra("CurrentTemplateId"))
          {
            if (localCard.cardType == 2) {
              l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
            } else {
              l1 = (int)localCard.lCurrentStyleId;
            }
            this.jdField_a_of_type_Long = l1;
          }
          if (!localIntent.hasExtra("CurrentBackgroundId")) {
            this.g = ((int)localCard.lCurrentBgId);
          }
          if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
            this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
          }
          if (!localIntent.hasExtra("CurrentBackgroundColor")) {
            this.h = ((int)localCard.backgroundColor);
          }
        }
        if (this.jdField_a_of_type_Long == -1L) {
          this.jdField_a_of_type_Long = 0L;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.g), Integer.valueOf(this.h), this.jdField_b_of_type_JavaLangString }));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onActivityResult, resultCode : ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resultCode : ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", data : ");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject1 = null;
      if (paramIntent.hasExtra("result"))
      {
        Object localObject2 = paramIntent.getStringExtra("result");
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult, resultStr : ");
          localStringBuilder.append((String)localObject2);
          QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          try
          {
            localObject2 = new JSONObject((String)localObject2).get("payState");
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onActivityResult, stateObj : ");
              localStringBuilder.append(localObject2);
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, localStringBuilder.toString());
            }
            if ((localObject2 == null) || (!"0".equals(String.valueOf(localObject2)))) {
              return;
            }
            if (paramIntent.hasExtra("callbackSn")) {
              localObject1 = paramIntent.getStringExtra("callbackSn");
            }
            if (QLog.isColorLevel())
            {
              paramIntent = new StringBuilder();
              paramIntent.append("onActivityResult, callbackSn : ");
              paramIntent.append((String)localObject1);
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, paramIntent.toString());
            }
            if ("svip".equals(localObject1)) {
              this.jdField_b_of_type_Boolean = true;
            } else {
              this.jdField_a_of_type_Boolean = true;
            }
            a();
            return;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("onActivityResult, Exception : ");
            ((StringBuilder)localObject1).append(paramIntent.getMessage());
            QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, ((StringBuilder)localObject1).toString());
            return;
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
            if (!QLog.isColorLevel()) {
              return;
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onActivityResult, JSONException : ");
          ((StringBuilder)localObject1).append(paramIntent.getMessage());
          QLog.e("ProfileCard.VipProfileCardBaseActivity", 2, ((StringBuilder)localObject1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity
 * JD-Core Version:    0.7.0.1
 */