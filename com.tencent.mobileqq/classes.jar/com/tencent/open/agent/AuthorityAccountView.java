package com.tencent.open.agent;

import aekt;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bcwh;
import bdcd;
import bdfq;
import bexi;
import bexj;
import bexk;
import bexl;
import bexm;
import bexn;
import bfhm;
import bfjq;
import bfmn;
import bhpy;
import bhql;
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

public class AuthorityAccountView
  extends LinearLayout
  implements View.OnClickListener
{
  protected float a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  public bdfq a;
  private bexn jdField_a_of_type_Bexn;
  private bhpy jdField_a_of_type_Bhpy;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  protected ArrayList<String> a;
  public WtloginManager a;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private float c;
  
  public AuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    e();
    f();
  }
  
  private int a()
  {
    float f1 = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
    float f2 = (int)(2.0D * this.c / 3.0D / f1) - 2;
    f1 = f1 / 2.0F + f2 * f1;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, "--> getMaxListHeight maxHeight = " + f1);
    }
    return (int)f1;
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount())) {
      bfjq.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
    }
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_b_of_type_Float = localDisplayMetrics.widthPixels;
    this.c = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  private void f()
  {
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559527, null);
    ((LinearLayout.LayoutParams)localObject).topMargin = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 37.0F);
    ((LinearLayout.LayoutParams)localObject).bottomMargin = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 37.0F);
    addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361855));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361829));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361841));
    int i = aekt.a(10.0F, getResources());
    aekt.a(this.jdField_a_of_type_AndroidWidgetTextView, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559528, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131362902));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361862));
      i = a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMaxHeight(i);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131361826));
      this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(getContext(), null));
      this.jdField_a_of_type_Bhpy.a(this.jdField_b_of_type_AndroidViewView, null);
      localObject = this.jdField_a_of_type_Bhpy.a();
      if ((localObject instanceof DispatchActionMoveScrollView)) {
        ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_Bhpy.a();
      ((RelativeLayout)localObject).addOnLayoutChangeListener(new bexi(this, (RelativeLayout)localObject));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (QLog.isColorLevel()) {
        QLog.d("AuthorityAccountView", 2, "--> AuthorityAccountView initUI");
      }
      c();
      d();
      g();
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  private void g()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362899);
    localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new bexj(this, localImageView));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
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
      StringBuilder localStringBuilder = new StringBuilder("updateLoginAccount() uin=");
      localStringBuilder.append(paramString).append(",nick=").append((String)localObject);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362899);
        TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362900);
        localObject = bfhm.a((String)localObject, 12, true);
        localTextView.setText((CharSequence)localObject);
        a(paramString, localImageView);
        localStringBuilder.append(",dealStr=").append((String)localObject);
      }
      QLog.i("AuthorityAccountView", 1, localStringBuilder.toString());
      return;
    }
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    ThreadManager.executeOnSubThread(new AuthorityAccountView.5(this, paramString, paramImageView));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bhpy != null) && (this.jdField_a_of_type_Bhpy.isShowing())) {
      this.jdField_a_of_type_Bhpy.dismiss();
    }
  }
  
  public void b(String paramString)
  {
    QLog.i("AuthorityAccountView", 1, "show delete account = " + paramString);
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230);
    this.jdField_a_of_type_Bdfq.setContentView(2131558920);
    this.jdField_a_of_type_Bdfq.setTitle(getResources().getString(2131698890));
    this.jdField_a_of_type_Bdfq.setMessageTextSize(18.0F);
    this.jdField_a_of_type_Bdfq.setMessage(paramString + "?");
    paramString = new bexm(this, paramString);
    this.jdField_a_of_type_Bdfq.setNegativeButton(2131690864, paramString);
    this.jdField_a_of_type_Bdfq.setPositiveButton(2131690865, paramString);
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public void c()
  {
    bfmn.a().a();
    this.jdField_a_of_type_JavaUtilArrayList = bfjq.a();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("-->initOrUpdateAccountList:");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localStringBuilder.append(" 第").append(i).append("帐号:").append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      QLog.i("AuthorityAccountView", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("AuthorityAccountView", 1, "-->initOrUpdateAccountList account list = null");
  }
  
  protected void c(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    bfjq.b(paramString);
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
          QLog.d("AuthorityAccountView", 2, "-->deleteAccount--account to delete equals last account, clear last account");
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
      }
      long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
      paramString = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + l));
    } while (paramString.exists());
    paramString.delete();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityAccountView", 2, "-->updateDropDownViews");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559526, null);
        localRelativeLayout.setBackgroundResource(2130841546);
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
        ((ImageView)localRelativeLayout.findViewById(2131368532)).setVisibility(8);
        localObject2 = (ImageView)localRelativeLayout.findViewById(2131368474);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130844897);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new bexk(this));
        a(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new bexl(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 72.0F));
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i += 1;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    if (this.jdField_a_of_type_Bexn != null) {
      this.jdField_a_of_type_Bexn.a();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bhpy.show();
  }
  
  public void setAppInfo(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = bfhm.a(paramString, 12, true);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
    if (paramBitmap != null)
    {
      QLog.i("AuthorityAccountView", 1, "setAppInfo appIcon=" + paramBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setAppType(String paramString)
  {
    TextView localTextView;
    String str;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361827);
      str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695026);
      if (!"web".equals(paramString)) {
        break label91;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695027);
    }
    for (;;)
    {
      localTextView.setText(str);
      QLog.i("AuthorityAccountView", 1, "setAppType=" + str);
      return;
      label91:
      if ("android".equals(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695026);
      }
    }
  }
  
  public void setChangeAccountListener(bexn parambexn)
  {
    this.jdField_a_of_type_Bexn = parambexn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */