package com.tencent.mobileqq.profile;

import Override;
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
import anum;
import anuw;
import anyw;
import azxp;
import azxy;
import azyp;
import azyq;
import azyr;
import azys;
import azyt;
import azyu;
import bdll;
import bhhz;
import bhlq;
import bhpc;
import bhzu;
import biht;
import bihu;
import bihw;
import bjbs;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.VipUtils;
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
  public int a;
  public long a;
  public Context a;
  public DialogInterface.OnClickListener a;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  public anum a;
  protected anuw a;
  protected bhpc a;
  protected bjbs a;
  public Runnable a;
  protected String a;
  protected ArrayList<azxy> a;
  protected boolean a;
  protected int b;
  public DialogInterface.OnClickListener b;
  protected bhpc b;
  public String b;
  protected boolean b;
  protected int c;
  public DialogInterface.OnClickListener c;
  public int d;
  public DialogInterface.OnClickListener d = new azyu(this);
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
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_g_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new azyp(this);
    this.jdField_a_of_type_Anuw = new azyq(this);
    this.jdField_a_of_type_JavaLangRunnable = new VipProfileCardBaseActivity.3(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new azyr(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new azys(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new azyt(this);
  }
  
  protected int a(String paramString, biht parambiht)
  {
    if (bhhz.a(this.jdField_a_of_type_AndroidContentContext, paramString)) {
      return 19;
    }
    paramString = new bihu(paramString, new File(bhhz.a(this.jdField_a_of_type_AndroidContentContext, paramString)));
    if (parambiht != null) {
      paramString.a(parambiht);
    }
    paramString.f = "profileCardDownload";
    paramString.e = "VIP_profilecard";
    return bihw.a(paramString, this.app);
  }
  
  public ArrayList<azxy> a()
  {
    int m;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = bhhz.a(this.app, false, false);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        m = 0;
        if (m >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label131;
        }
        localazxy = (azxy)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        if ((localazxy == null) || (localazxy.o != azxy.jdField_g_of_type_Long)) {
          break label124;
        }
      }
    }
    label131:
    for (azxy localazxy = bhhz.a(localazxy);; localazxy = null)
    {
      if (localazxy != null)
      {
        localazxy.o = azxy.n;
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localazxy);
      }
      bhhz.a(this.app);
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
    this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.setCancelable(false);
    this.jdField_a_of_type_Bjbs.c(2131694585);
    try
    {
      this.jdField_a_of_type_Bjbs.show();
      label53:
      this.app.a(new VipProfileCardBaseActivity.8(this, paramLong1, paramLong2, paramString, paramInt));
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.i);
      return;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }
  
  public void a(azxp paramazxp)
  {
    if (paramazxp == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramazxp.d != 1) || (l1 >= paramazxp.f) || (l1 <= paramazxp.e));
    paramazxp.jdField_c_of_type_Int = 1;
  }
  
  public void a(azxy paramazxy)
  {
    if (paramazxy == null) {}
    long l1;
    do
    {
      return;
      l1 = NetConnInfoCenter.getServerTime();
    } while ((paramazxy.e != 1) || (l1 >= paramazxy.jdField_g_of_type_Int) || (l1 <= paramazxy.f));
    paramazxy.c = "1";
  }
  
  public boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    anyw localanyw = (anyw)this.app.getManager(51);
    Card localCard = localanyw.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localanyw.a(localCard))
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
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  protected boolean a(azxy paramazxy, azxp paramazxp, boolean paramBoolean)
  {
    if ((paramazxy != null) && (paramazxp != null))
    {
      if (paramazxy.o == 0L) {
        return true;
      }
      int i1 = Integer.valueOf(paramazxy.c).intValue();
      int m = paramazxp.jdField_c_of_type_Int;
      boolean bool = bhhz.a(paramazxp);
      if (bool) {
        m = paramazxy.l;
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
              this.jdField_a_of_type_JavaLangString = bhhz.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i1, m, this.jdField_a_of_type_Int);
            } else {
              this.jdField_a_of_type_JavaLangString = bhhz.a(3);
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
              this.jdField_a_of_type_JavaLangString = bhhz.a(this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, i1, m, this.jdField_a_of_type_Int);
            } else {
              this.jdField_a_of_type_JavaLangString = bhhz.a(6);
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
          localObject1[m] = ((azxy)localArrayList.get(m)).o;
          m += 1;
        }
      }
    }
    return localObject1;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
    //   11: invokevirtual 350	bjbs:isShowing	()Z
    //   14: ifeq +15 -> 29
    //   17: aload_0
    //   18: getfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
    //   21: invokevirtual 353	bjbs:dismiss	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 197	com/tencent/mobileqq/profile/VipProfileCardBaseActivity:jdField_a_of_type_Bjbs	Lbjbs;
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
  
  public void d()
  {
    e();
    String str2;
    String str1;
    if (this.jdField_a_of_type_Int == 2)
    {
      str2 = getString(2131694526);
      if (this.jdField_c_of_type_Int == 2) {
        str1 = getString(2131694529);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 0, str2, str1, 2131694524, 2131694525, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_a_of_type_Bhpc.show();
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        str1 = getString(2131694531);
      }
      else
      {
        str1 = getString(2131694527);
        continue;
        str2 = getString(2131694533);
        if (this.jdField_c_of_type_Int == 2) {
          str1 = getString(2131694530);
        } else if (this.jdField_c_of_type_Int == 1) {
          str1 = getString(2131694532);
        } else {
          str1 = getString(2131694528);
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
    this.jdField_a_of_type_Anum = ((anum)this.app.a(2));
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anuw);
    e();
    b();
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
  }
  
  public void f()
  {
    if (this.jdField_b_of_type_Bhpc != null)
    {
      this.jdField_b_of_type_Bhpc.dismiss();
      this.jdField_b_of_type_Bhpc = null;
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
        bhzu.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000516", "CJCLUBT", getString(2131718497), "svip");
        bdll.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044E0", "0X80044E0", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
        return;
      }
      bhzu.a(this.app, (BaseActivity)this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 3, "1450000515", "LTMCLUB", getString(2131694534), "vip");
      bdll.b(this.app, "P_CliOper", "Vip_SummaryCard", "", "0X80044DF", "0X80044DF", 0, 0, "", "", "", VipUtils.a(this.app, this.app.getCurrentAccountUin()));
      return;
    }
  }
  
  public void h()
  {
    Card localCard = ((anyw)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
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
      for (l1 = azxy.n;; l1 = (int)localCard.lCurrentStyleId)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_g_of_type_Int = ((int)localCard.lCurrentBgId);
        this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
        this.h = ((int)localCard.backgroundColor);
        label169:
        if (this.jdField_a_of_type_Long != -1L) {
          break label286;
        }
        this.jdField_a_of_type_Long = 0L;
        break;
      }
    }
    if (!localIntent.hasExtra("CurrentTemplateId")) {
      if (localCard.cardType != 2) {
        break label288;
      }
    }
    label286:
    label288:
    for (long l1 = azxy.n;; l1 = (int)localCard.lCurrentStyleId)
    {
      this.jdField_a_of_type_Long = l1;
      if (!localIntent.hasExtra("CurrentBackgroundId")) {
        this.jdField_g_of_type_Int = ((int)localCard.lCurrentBgId);
      }
      if (!localIntent.hasExtra("CurrentBackgroundUrl")) {
        this.jdField_b_of_type_JavaLangString = localCard.backgroundUrl;
      }
      if (localIntent.hasExtra("CurrentBackgroundColor")) {
        break label169;
      }
      this.h = ((int)localCard.backgroundColor);
      break label169;
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