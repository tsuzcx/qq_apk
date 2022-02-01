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
  public Runnable A = new VipProfileCardBaseActivity.3(this);
  public DialogInterface.OnClickListener B = new VipProfileCardBaseActivity.4(this);
  public DialogInterface.OnClickListener C = new VipProfileCardBaseActivity.5(this);
  public DialogInterface.OnClickListener D = new VipProfileCardBaseActivity.6(this);
  public DialogInterface.OnClickListener E = new VipProfileCardBaseActivity.7(this);
  protected QQProgressDialog a;
  protected Context b = null;
  protected int c = -1;
  protected int d = -1;
  protected boolean e = false;
  protected boolean f = false;
  protected int g = 0;
  protected String h = "";
  protected int i = 0;
  protected int j = 1;
  protected QQCustomDialog k = null;
  protected QQCustomDialog l = null;
  public CardHandler m = null;
  public long n = 0L;
  public int o = 2;
  public int p = -1;
  public String q = null;
  public int r = -1;
  public int s = 30000;
  protected int t;
  protected int u;
  protected float v;
  protected int w;
  protected ArrayList<ProfileCardTemplate> x = null;
  @SuppressLint({"HandlerLeak"})
  public Handler y = new VipProfileCardBaseActivity.1(this);
  protected CardObserver z = new VipProfileCardBaseActivity.2(this);
  
  protected int a(String paramString, DownloadListener paramDownloadListener)
  {
    if (ProfileCardUtil.b(paramString)) {
      return 19;
    }
    paramString = new DownloadTask(paramString, new File(ProfileCardUtil.c(paramString)));
    if (paramDownloadListener != null) {
      paramString.a(paramDownloadListener);
    }
    paramString.L = "profileCardDownload";
    paramString.K = "VIP_profilecard";
    return DownloaderFactory.a(paramString, this.app);
  }
  
  protected void a() {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, null, 0);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    b();
    Context localContext = this.b;
    this.a = new QQProgressDialog(localContext, ((BaseActivity)localContext).getTitleBarHeight());
    this.a.setCancelable(false);
    this.a.c(2131892860);
    try
    {
      this.a.show();
      label55:
      this.app.execute(new VipProfileCardBaseActivity.8(this, paramLong1, paramLong2, paramString, paramInt));
      this.y.postDelayed(this.A, this.s);
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
    if ((paramProfileCardBackground.g == 1) && (l1 < paramProfileCardBackground.i) && (l1 > paramProfileCardBackground.h)) {
      paramProfileCardBackground.f = 1;
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
    Card localCard = localFriendsManager.f(this.app.getCurrentAccountUin());
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
      int i3 = Integer.valueOf(paramProfileCardTemplate.auth).intValue();
      int i1 = paramProfileCardBackground.f;
      boolean bool1 = ProfileCardUtil.a(paramProfileCardBackground);
      if (bool1) {
        i1 = paramProfileCardTemplate.customBackgroundAuth;
      }
      int i2;
      if (i3 >= i1)
      {
        this.g = 1;
        if (i3 == i1) {
          this.g = 2;
        }
        i2 = i3;
      }
      else
      {
        this.g = 0;
        i2 = i1;
      }
      this.d = i2;
      if (i2 != 0)
      {
        if (i2 == 1) {
          return true;
        }
        boolean bool2;
        if (i2 == 2)
        {
          bool2 = this.e;
          if (!bool2)
          {
            boolean bool3 = this.f;
            if (!bool3)
            {
              this.c = 1;
              if (bool1) {
                this.h = "mvip.gongneng.android.mingpian_zidingyi";
              } else if (this.j == 1) {
                this.h = ProfileCardUtil.a(bool2, bool3, i3, i1, this.c);
              } else {
                this.h = ProfileCardUtil.a(3);
              }
              if (QLog.isDevelopLevel()) {
                QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.e), Boolean.valueOf(this.f), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.c), this.h }));
              }
              if (paramBoolean) {
                this.y.sendEmptyMessage(9);
              }
              return false;
            }
          }
        }
        else if (i2 == 4)
        {
          bool2 = this.f;
          if (!bool2)
          {
            this.c = 2;
            if (bool1) {
              this.h = "mvip.gongneng.android.mingpian_zidingyi";
            } else if (this.j == 1) {
              this.h = ProfileCardUtil.a(this.e, bool2, i3, i1, this.c);
            } else {
              this.h = ProfileCardUtil.a(6);
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("ProfileCard.VipProfileCardBaseActivity", 4, String.format("getAid mIsQQVipOpen : %b, mIsSuperVipOpen : %b, styleAuth : %d, bgAuth : %d, mNeedVipType : %d, mAid : %s", new Object[] { Boolean.valueOf(this.e), Boolean.valueOf(this.f), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(this.c), this.h }));
            }
            if (paramBoolean) {
              this.y.sendEmptyMessage(9);
            }
            return false;
          }
        }
        else if (i2 != 5) {}
      }
    }
    return true;
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +33 -> 39
    //   9: aload_1
    //   10: invokevirtual 362	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   13: ifeq +26 -> 39
    //   16: aload_0
    //   17: getfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   20: invokevirtual 365	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   23: goto +11 -> 34
    //   26: astore_1
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   32: aload_1
    //   33: athrow
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:a	Lcom/tencent/mobileqq/widget/QQProgressDialog;
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
    this.f = VasUtil.b(this.app).getVipStatus().isSVip();
    this.e = VasUtil.b(this.app).getVipStatus().isVip();
  }
  
  protected void d()
  {
    e();
    String str2;
    int i1;
    String str1;
    if (this.c == 2)
    {
      str2 = getString(2131892798);
      i1 = this.g;
      if (i1 == 2) {
        str1 = getString(2131892801);
      } else if (i1 == 1) {
        str1 = getString(2131892803);
      } else {
        str1 = getString(2131892799);
      }
    }
    else
    {
      str2 = getString(2131892805);
      i1 = this.g;
      if (i1 != 2) {
        break label97;
      }
      str1 = getString(2131892802);
    }
    for (;;)
    {
      break;
      label97:
      if (i1 == 1) {
        str1 = getString(2131892804);
      } else {
        str1 = getString(2131892800);
      }
    }
    this.k = DialogUtil.a(this.b, 0, str2, str1, 2131892796, 2131892797, this.C, this.B);
    this.k.show();
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
    this.u = paramBundle.widthPixels;
    this.t = paramBundle.heightPixels;
    this.w = paramBundle.densityDpi;
    this.v = paramBundle.density;
    c();
    this.m = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.z);
    e();
    b();
    this.x = null;
  }
  
  protected void e()
  {
    QQCustomDialog localQQCustomDialog = this.k;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.k = null;
    }
  }
  
  protected void f()
  {
    QQCustomDialog localQQCustomDialog = this.l;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.l = null;
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
      localObject2 = this.h;
    }
    if (this.c == 2)
    {
      VasH5PayUtil.a((BaseActivity)this.b, (String)localObject2, 3, "1450000516", "CJCLUBT", getString(2131916948), "svip");
      ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return;
    }
    VasH5PayUtil.a((BaseActivity)this.b, (String)localObject2, 3, "1450000515", "LTMCLUB", getString(2131892806), "vip");
    ReportController.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
  }
  
  public void h()
  {
    Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.app.getCurrentAccountUin());
    if (localCard != null) {
      if (localCard.templateRet != 0)
      {
        this.n = 0L;
        this.p = -1;
        this.r = 1;
        this.q = null;
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
          this.n = l1;
          this.p = ((int)localCard.lCurrentBgId);
          this.q = localCard.backgroundUrl;
          this.r = ((int)localCard.backgroundColor);
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
            this.n = l1;
          }
          if (!localIntent.hasExtra("CurrentBackgroundId")) {
            this.p = ((int)localCard.lCurrentBgId);
          }
          if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
            this.q = localCard.backgroundUrl;
          }
          if (!localIntent.hasExtra("CurrentBackgroundColor")) {
            this.r = ((int)localCard.backgroundColor);
          }
        }
        if (this.n == -1L) {
          this.n = 0L;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, String.format("readInfofromDB , mCurrentStyleId : %s , mCurrentBackgroundId : %s , mCurrentBackgroundColor : %s , mCurrentBackgroundUrl : %s", new Object[] { Long.valueOf(this.n), Integer.valueOf(this.p), Integer.valueOf(this.r), this.q }));
    }
  }
  
  public long[] i()
  {
    ArrayList localArrayList = j();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      long[] arrayOfLong2 = new long[localArrayList.size()];
      int i1 = 0;
      for (;;)
      {
        arrayOfLong1 = arrayOfLong2;
        if (i1 >= localArrayList.size()) {
          break;
        }
        arrayOfLong2[i1] = ((ProfileCardTemplate)localArrayList.get(i1)).styleId;
        i1 += 1;
      }
    }
    long[] arrayOfLong1 = null;
    return arrayOfLong1;
  }
  
  public ArrayList<ProfileCardTemplate> j()
  {
    Object localObject1 = this.x;
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      this.x = ProfileCardTemplateUtil.a(false, false);
      localObject1 = this.x;
      if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
      {
        Object localObject2 = null;
        int i1 = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i1 >= this.x.size()) {
            break;
          }
          localObject1 = (ProfileCardTemplate)this.x.get(i1);
          if ((localObject1 != null) && (((ProfileCardTemplate)localObject1).styleId == ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE))
          {
            localObject1 = ProfileCardTemplateUtil.a((ProfileCardTemplate)localObject1);
            break;
          }
          i1 += 1;
        }
        if (localObject1 != null)
        {
          ((ProfileCardTemplate)localObject1).styleId = ProfileCardTemplate.PROFILE_CARD_STYLE_DIY;
          this.x.add(0, localObject1);
        }
      }
      ProfileCardTemplateUtil.a(this.app);
    }
    return this.x;
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
              this.f = true;
            } else {
              this.e = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity
 * JD-Core Version:    0.7.0.1
 */