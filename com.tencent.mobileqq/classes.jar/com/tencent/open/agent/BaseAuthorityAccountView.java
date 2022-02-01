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
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.StringAddition;
import com.tencent.open.data.SharedPrefs;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public abstract class BaseAuthorityAccountView
  extends LinearLayout
{
  protected float a;
  protected Context a;
  protected SharedPreferences.Editor a;
  protected SharedPreferences a;
  protected View a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected QQCustomDialog a;
  protected BounceScrollView a;
  protected AbstractOpenSdkAppInterface a;
  protected ActionSheet a;
  protected ArrayList<String> a;
  protected WtloginManager a;
  protected boolean a;
  protected float b;
  protected View b;
  protected LinearLayout b;
  
  public BaseAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_MqqManagerWtloginManager = null;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private int a()
  {
    float f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 72.0F);
    double d1 = this.jdField_b_of_type_Float;
    Double.isNaN(d1);
    d1 = d1 * 2.0D / 3.0D;
    double d2 = f;
    Double.isNaN(d2);
    f = ((int)(d1 / d2) - 2) * f + f / 2.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->getMaxListHeight maxHeight = ");
    localStringBuilder.append(f);
    SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
    return (int)f;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentQqconnectWtloginAbstractOpenSdkAppInterface = ((AbstractOpenSdkAppInterface)((AppActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime());
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.jdField_a_of_type_ComTencentQqconnectWtloginAbstractOpenSdkAppInterface.getManager(1));
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("accountList", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqconnectWtloginAbstractOpenSdkAppInterface.getAccount())) {
      SharedPrefs.a(this.jdField_a_of_type_ComTencentQqconnectWtloginAbstractOpenSdkAppInterface.getAccount());
    }
    Object localObject = SharedPrefs.a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      SharedPrefs.a((String)localObject);
    }
    localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).widthPixels;
    this.jdField_b_of_type_Float = ((DisplayMetrics)localObject).heightPixels;
  }
  
  private void c(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->deleteAccount--account to delete is ");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject1).toString() });
    SharedPrefs.c(paramString);
    localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject1 == null) {
      return;
    }
    localObject1 = AuthorityUtil.a((SharedPreferences)localObject1);
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
      StringBuilder localStringBuilder;
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = localStringBuilder.toString())
      {
        String str = (String)((Iterator)localObject2).next();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(",");
        localStringBuilder.append(str);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("accList", (String)localObject1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
    if (paramString.equals(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("last_account", "")))
    {
      SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->deleteAccount--account to delete equals last account, clear last account" });
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove("last_account").commit();
    }
    paramString = new File(OpenSdkVirtualUtil.a(OpenSdkVirtualUtil.a(this.jdField_a_of_type_MqqManagerWtloginManager, paramString)));
    if (!paramString.exists()) {
      paramString.delete();
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject1 = new WloginSimpleInfo();
    this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(paramString, (WloginSimpleInfo)localObject1);
    Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramString;
    }
    localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 != null)
    {
      localObject2 = (ImageView)((View)localObject2).findViewById(2131363050);
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363051)).setText(StringAddition.a((String)localObject1, 12, true));
      a(paramString, (ImageView)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("当前帐号：");
    ((StringBuilder)localObject1).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject1).toString() });
  }
  
  protected void a(String paramString, ImageView paramImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-->updateAccountFace uin=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
    ThreadManager.executeOnSubThread(new BaseAuthorityAccountView.5(this, paramString, paramImageView));
  }
  
  abstract boolean a();
  
  abstract boolean a(String paramString, boolean paramBoolean);
  
  protected void b()
  {
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initBaseUI" });
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559659, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131363053));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_b_of_type_AndroidViewView.findViewById(2131361905));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setMaxHeight(a());
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131361867));
    this.jdField_a_of_type_ComTencentWidgetActionSheet = AuthUIUtil.a(getContext(), null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(this.jdField_b_of_type_AndroidViewView, null);
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getRootView();
    if ((localObject instanceof DispatchActionMoveScrollView)) {
      ((DispatchActionMoveScrollView)localObject).jdField_a_of_type_Boolean = true;
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionContentView();
    ((RelativeLayout)localObject).addOnLayoutChangeListener(new BaseAuthorityAccountView.1(this, (RelativeLayout)localObject));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    e();
    f();
  }
  
  protected void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-->showAccountConfirm uin = ");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    SSOLog.a("BaseAuthorityAccountView", new Object[] { ((StringBuilder)localObject).toString() });
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131558954);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(getResources().getString(2131698640));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(18.0F);
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("?");
    ((QQCustomDialog)localObject).setMessage(localStringBuilder.toString());
    paramString = new BaseAuthorityAccountView.6(this, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131699819, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131699820, paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  protected void c()
  {
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void d()
  {
    ThreadManager.postImmediately(new BaseAuthorityAccountView.2(this), null, true);
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList = SharedPrefs.a();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initOrUpdateAccountList" });
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" 第");
        localStringBuilder.append(i);
        localStringBuilder.append("帐号: ");
        localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        SSOLog.a("BaseAuthorityAccountView", new Object[] { localStringBuilder.toString() });
        i += 1;
      }
    }
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->initOrUpdateAccountList account list = null" });
  }
  
  protected void f()
  {
    SSOLog.a("BaseAuthorityAccountView", new Object[] { "-->updateDropDownViews" });
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() == 0) {
        return;
      }
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559657, null);
        localRelativeLayout.setBackgroundResource(2130841969);
        String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((TextView)localRelativeLayout.findViewById(2131361934)).setText(str);
        TextView localTextView = (TextView)localRelativeLayout.findViewById(2131361909);
        localTextView.setMaxWidth((int)(this.jdField_a_of_type_Float * 3.0F / 5.0F));
        localObject1 = new WloginSimpleInfo();
        this.jdField_a_of_type_MqqManagerWtloginManager.getBasicUserInfo(str, (WloginSimpleInfo)localObject1);
        Object localObject2 = new String(((WloginSimpleInfo)localObject1)._nick);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = str;
        }
        localTextView.setText((CharSequence)localObject1);
        localObject1 = (ImageView)localRelativeLayout.findViewById(2131361900);
        ((ImageView)localRelativeLayout.findViewById(2131369111)).setVisibility(8);
        localObject2 = (ImageView)localRelativeLayout.findViewById(2131369015);
        ((ImageView)localObject2).setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130845536);
        ((ImageView)localObject2).setTag(str);
        ((ImageView)localObject2).setOnClickListener(new BaseAuthorityAccountView.3(this));
        a(str, (ImageView)localObject1);
        localRelativeLayout.setOnClickListener(new BaseAuthorityAccountView.4(this, str));
        localObject1 = new LinearLayout.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 72.0F));
        ((LinearLayout.LayoutParams)localObject1).width = -1;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */