package com.tencent.open.agent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhgr;
import bhlq;
import bhpc;
import bjmy;
import bjmz;
import bjna;
import bjnb;
import bjnc;
import bjnz;
import bjqq;
import bjud;
import bjwg;
import blir;
import blji;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.open.model.AccountManage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class OpenAuthorityAccountView
  extends LinearLayout
  implements View.OnClickListener
{
  protected float a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public bhpc a;
  private bjnz jdField_a_of_type_Bjnz;
  private blir jdField_a_of_type_Blir;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  protected ArrayList<String> a;
  public WtloginManager a;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private float jdField_c_of_type_Float;
  private View jdField_c_of_type_AndroidViewView;
  
  public OpenAuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    f();
    g();
  }
  
  private int a()
  {
    float f1 = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
    float f2 = (int)(2.0D * this.jdField_c_of_type_Float / 3.0D / f1) - 2;
    f1 = f1 / 2.0F + f2 * f1;
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityAccountView", 2, "--> getMaxListHeight maxHeight = " + f1);
    }
    return (int)f1;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
      bjwg.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
    }
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_b_of_type_Float = localDisplayMetrics.widthPixels;
    this.jdField_c_of_type_Float = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  private void g()
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559670, null);
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559669, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363036));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bjmy(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361897));
      int i = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMaxHeight(i);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131361860));
      this.jdField_a_of_type_Blir = ((blir)blji.a(getContext(), null));
      this.jdField_a_of_type_Blir.a(this.jdField_b_of_type_AndroidViewView, null);
      localObject = this.jdField_a_of_type_Blir.a();
      if ((localObject instanceof DispatchActionMoveScrollView)) {
        ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_Blir.a();
      ((RelativeLayout)localObject).addOnLayoutChangeListener(new bjmz(this, (RelativeLayout)localObject));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityAccountView", 2, "--> AuthorityAccountView initUI");
      }
      c();
      d();
      this.jdField_c_of_type_AndroidViewView = findViewById(2131377283);
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    localObject = new String(((WloginSimpleInfo)localObject)._nick);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = paramString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363033);
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363034)).setText(bjud.a((String)localObject, 12, true));
        a(paramString, localImageView);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityAccountView", 2, "当前帐号：" + paramString);
      }
      return;
    }
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    QLog.d("OpenAuthorityAccountView", 1, "-->updateAccountFace uin = " + bjqq.a(paramString));
    ThreadManager.executeOnSubThread(new OpenAuthorityAccountView.5(this, paramString, paramImageView));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Blir != null) && (this.jdField_a_of_type_Blir.isShowing())) {
      this.jdField_a_of_type_Blir.dismiss();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230);
    this.jdField_a_of_type_Bhpc.setContentView(2131558984);
    this.jdField_a_of_type_Bhpc.setTitle(getResources().getString(2131697854));
    this.jdField_a_of_type_Bhpc.setMessageTextSize(18.0F);
    this.jdField_a_of_type_Bhpc.setMessage(paramString + "?");
    paramString = new bjnc(this, paramString);
    this.jdField_a_of_type_Bhpc.setNegativeButton(2131690712, paramString);
    this.jdField_a_of_type_Bhpc.setPositiveButton(2131690713, paramString);
    this.jdField_a_of_type_Bhpc.show();
  }
  
  public void c()
  {
    AccountManage.a().a();
    this.jdField_a_of_type_JavaUtilArrayList = bjwg.a();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        QLog.d("OpenAuthorityAccountView", 2, "-->initOrUpdateAccountList");
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          QLog.d("OpenAuthorityAccountView", 2, " 第" + i + "帐号: " + (String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
      }
      QLog.d("OpenAuthorityAccountView", 2, "-->initOrUpdateAccountList account list = null");
    }
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityAccountView", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    bjwg.b(paramString);
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null) != null) {
        localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("accList", null).split(",");
      }
      Object localObject2 = new ArrayList();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          ((ArrayList)localObject2).add(localObject1[i]);
          i += 1;
        }
      }
      while (((ArrayList)localObject2).contains("")) {
        ((ArrayList)localObject2).remove("");
      }
      if (((ArrayList)localObject2).contains(paramString))
      {
        ((ArrayList)localObject2).remove(paramString);
        localObject2 = ((ArrayList)localObject2).iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + "," + str) {
          str = (String)((Iterator)localObject2).next();
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("accList", (String)localObject1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      }
      if (paramString.equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", "")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("OpenAuthorityAccountView", 2, "-->deleteAccount--account to delete equals last account, clear last account");
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
      }
      long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
      paramString = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + l));
    } while (paramString.exists());
    paramString.delete();
  }
  
  protected void d()
  {
    QLog.d("OpenAuthorityAccountView", 1, "-->updateDropDownViews");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559667, null);
        localRelativeLayout.setBackgroundResource(2130841874);
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((TextView)localRelativeLayout.findViewById(2131361926)).setText(str);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131361901);
        localTextView.setMaxWidth((int)(3.0F * this.jdField_b_of_type_Float / 5.0F));
        Object localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localRelativeLayout.findViewById(2131361892);
        ((ImageView)localRelativeLayout.findViewById(2131368945)).setVisibility(8);
        localObject2 = (ImageView)localRelativeLayout.findViewById(2131368869);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130845382);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new bjna(this));
        a(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new bjnb(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 72.0F));
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i += 1;
      }
    }
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Blir.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
    }
  }
  
  public void setAccountEventListener(bjnz parambjnz)
  {
    this.jdField_a_of_type_Bjnz = parambjnz;
  }
  
  public void setMainAccountSelect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */