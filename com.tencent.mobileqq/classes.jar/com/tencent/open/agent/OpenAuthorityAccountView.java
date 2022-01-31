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
import baxn;
import bbdj;
import bbgu;
import bdbo;
import bdbp;
import bdbq;
import bdbr;
import bdbs;
import bdcp;
import bdio;
import bdkt;
import bdnq;
import bfpc;
import bfpp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
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
  public bbgu a;
  private bdcp jdField_a_of_type_Bdcp;
  private bfpc jdField_a_of_type_Bfpc;
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
    float f1 = baxn.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
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
      bdkt.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
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
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559477, null);
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559476, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131362867));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bdbo(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361862));
      int i = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMaxHeight(i);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131361826));
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(getContext(), null));
      this.jdField_a_of_type_Bfpc.a(this.jdField_b_of_type_AndroidViewView, null);
      localObject = this.jdField_a_of_type_Bfpc.a();
      if ((localObject instanceof DispatchActionMoveScrollView)) {
        ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_Bfpc.a();
      ((RelativeLayout)localObject).addOnLayoutChangeListener(new bdbp(this, (RelativeLayout)localObject));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (QLog.isColorLevel()) {
        QLog.d("OpenAuthorityAccountView", 2, "--> AuthorityAccountView initUI");
      }
      c();
      d();
      this.jdField_c_of_type_AndroidViewView = findViewById(2131375804);
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
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    localObject = new String(((WloginSimpleInfo)localObject)._nick);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = paramString;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362864);
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362865)).setText(bdio.a((String)localObject, 12, true));
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
    ThreadManager.executeOnSubThread(new OpenAuthorityAccountView.5(this, paramString, paramImageView));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bfpc != null) && (this.jdField_a_of_type_Bfpc.isShowing())) {
      this.jdField_a_of_type_Bfpc.dismiss();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230);
    this.jdField_a_of_type_Bbgu.setContentView(2131558883);
    this.jdField_a_of_type_Bbgu.setTitle(getResources().getString(2131698593));
    this.jdField_a_of_type_Bbgu.setMessageTextSize(18.0F);
    this.jdField_a_of_type_Bbgu.setMessage(paramString + "?");
    paramString = new bdbs(this, paramString);
    this.jdField_a_of_type_Bbgu.setNegativeButton(2131690812, paramString);
    this.jdField_a_of_type_Bbgu.setPositiveButton(2131690813, paramString);
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public void c()
  {
    bdnq.a().a();
    this.jdField_a_of_type_JavaUtilArrayList = bdkt.a();
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
    bdkt.b(paramString);
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
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityAccountView", 2, "-->updateDropDownViews");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559474, null);
        localRelativeLayout.setBackgroundResource(2130841398);
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((TextView)localRelativeLayout.findViewById(2131361880)).setText(str);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131361865);
        localTextView.setMaxWidth((int)(3.0F * this.jdField_b_of_type_Float / 5.0F));
        Object localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localRelativeLayout.findViewById(2131361857);
        ((ImageView)localRelativeLayout.findViewById(2131368360)).setVisibility(8);
        localObject2 = (ImageView)localRelativeLayout.findViewById(2131368327);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130844533);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new bdbq(this));
        a(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new bdbr(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, baxn.a(this.jdField_a_of_type_AndroidContentContext, 72.0F));
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
    this.jdField_a_of_type_Bfpc.show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    e();
  }
  
  public void setAccountEventListener(bdcp parambdcp)
  {
    this.jdField_a_of_type_Bdcp = parambdcp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */