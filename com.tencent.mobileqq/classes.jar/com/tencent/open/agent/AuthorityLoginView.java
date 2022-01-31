package com.tencent.open.agent;

import alif;
import alig;
import alih;
import alii;
import alik;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.model.AccountManage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class AuthorityLoginView
  extends LinearLayout
{
  public float a;
  private Context jdField_a_of_type_AndroidContentContext;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  public Drawable a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public QQCustomDialog a;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  public ArrayList a;
  public WtloginManager a;
  private boolean jdField_a_of_type_Boolean = true;
  private float b;
  public Drawable b;
  
  public AuthorityLoginView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    d();
  }
  
  public AuthorityLoginView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    d();
  }
  
  public AuthorityLoginView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    d();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getManager(1));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if ((this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount()))) {
      SharedPrefs.a(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
    }
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842733);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842736);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969249, null);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365734));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new alif(this));
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityLoginView", 2, "--> AuthorityLoginView initUI");
    }
    b();
    a(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365731)).setText(paramString);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365730);
    localTextView.setMaxWidth((int)(3.0F * this.jdField_b_of_type_Float / 5.0F));
    Object localObject = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(paramString, (WloginSimpleInfo)localObject);
    String str = new String(((WloginSimpleInfo)localObject)._nick);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = paramString;
    }
    localTextView.setText((CharSequence)localObject);
    localObject = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365733);
    if (this.jdField_a_of_type_Boolean) {
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365734)).setVisibility(0);
    }
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362753)).setVisibility(8);
    a(paramString, (ImageView)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityLoginView", 2, "当前帐号：" + paramString);
    }
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    ThreadManager.executeOnSubThread(new alii(this, paramString, paramImageView));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityLoginView", 2, "-->updateDropDownViews");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131365732);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    while ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969249, null);
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((TextView)localView.findViewById(2131365731)).setText(str);
        TextView localTextView = (TextView)localView.findViewById(2131365730);
        localTextView.setMaxWidth((int)(3.0F * this.jdField_b_of_type_Float / 5.0F));
        localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localView.findViewById(2131365733);
        ((ImageView)localView.findViewById(2131365734)).setVisibility(8);
        localObject2 = (ImageView)localView.findViewById(2131362753);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130842730);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new alig(this));
        a(str, (ImageView)localObject1);
        localView.setOnClickListener(new alih(this, str));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
        i += 1;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131365732);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void b()
  {
    AccountManage.a().a();
    this.jdField_a_of_type_JavaUtilArrayList = SharedPrefs.a();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        QLog.d("AuthorityLoginView", 2, "-->initOrUpdateAccountList");
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          QLog.d("AuthorityLoginView", 2, " 第" + i + "帐号: " + (String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          i += 1;
        }
      }
      QLog.d("AuthorityLoginView", 2, "-->initOrUpdateAccountList account list = null");
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2130968846);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(getResources().getString(2131439135));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(18.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString + "?");
    paramString = new alik(this, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433029, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131433245, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void c(String paramString)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AuthorityLoginView", 2, "-->deleteAccount--account to delete is " + paramString);
    }
    SharedPrefs.b(paramString);
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
        QLog.d("AuthorityLoginView", 2, "-->deleteAccount--account to delete equals last account, clear last account");
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
    }
    long l = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    paramString = new File(this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.b("" + l));
    if (!paramString.exists()) {
      paramString.delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityLoginView
 * JD-Core Version:    0.7.0.1
 */