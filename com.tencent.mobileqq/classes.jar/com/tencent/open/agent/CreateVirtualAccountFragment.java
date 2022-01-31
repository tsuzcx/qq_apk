package com.tencent.open.agent;

import ageu;
import ajjy;
import amdk;
import amdl;
import amdm;
import amdn;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import azue;
import bacm;
import bbms;
import bbvz;
import bbwa;
import bbwc;
import bcjn;
import bcjw;
import begr;
import behe;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;

public class CreateVirtualAccountFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "1001_0cab6b944b59d75644e53b70de2f5d5a";
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long;
  public Uri a;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected bbms a;
  private bcjn jdField_a_of_type_Bcjn;
  private bcjw jdField_a_of_type_Bcjw = new bbwc(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private List<amdm> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private final String jdField_c_of_type_JavaLangString = "CreateVirtualAccountFragment";
  private View d;
  private View e;
  
  private String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      amdm localamdm = (amdm)localIterator.next();
      if (TextUtils.equals(localamdm.jdField_c_of_type_JavaLangString, paramString)) {
        return localamdm.jdField_b_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if (paramURLImageView == null) {}
    for (;;)
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = null;
      try
      {
        localObject = getResources().getDrawable(2130839687);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString != null)
        {
          paramString.setDecodeHandler(azue.a);
          if (paramString.getStatus() == 2)
          {
            QLog.d("CreateVirtualAccountFragment", 1, "setVirtualIcon restartDownload");
            paramString.restartDownload();
          }
          if (paramString.getStatus() != 2)
          {
            paramURLImageView.setImageDrawable(paramString);
            return;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject = localURLDrawableOptions;
          if (QLog.isColorLevel())
          {
            QLog.e("CreateVirtualAccountFragment", 1, "-->create color drawable oom.", localOutOfMemoryError);
            localObject = localURLDrawableOptions;
          }
        }
        QLog.d("CreateVirtualAccountFragment", 1, "getStatus OTHERS: ");
      }
    }
  }
  
  private void a(String paramString)
  {
    ThreadManager.getFileThreadHandler().post(new CreateVirtualAccountFragment.5(this, paramString));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (getActivity() == null)
    {
      QLog.e("CreateVirtualAccountFragment", 1, "showToast activity is null");
      return;
    }
    getActivity().runOnUiThread(new CreateVirtualAccountFragment.3(this, paramBoolean, paramString));
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(((amdm)localIterator.next()).jdField_c_of_type_JavaLangString, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      a(ajjy.a(2131636834), false);
      QLog.d("CreateVirtualAccountFragment", 1, "randomInfo config is null");
      return;
    }
    int i = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    amdm localamdm = (amdm)this.jdField_a_of_type_JavaUtilList.get(i % j);
    if (localamdm == null)
    {
      QLog.d("CreateVirtualAccountFragment", 1, " current randomInfo is null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localamdm.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(localamdm.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = localamdm.jdField_c_of_type_JavaLangString;
      a(this.jdField_a_of_type_ComTencentImageURLImageView, localamdm.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bbms != null)
    {
      if (this.jdField_a_of_type_Bbms.isShowing()) {
        return;
      }
      this.jdField_a_of_type_Bbms.show();
      return;
    }
    this.jdField_a_of_type_Bbms = new bbms(getActivity(), 0, 2131495448, 17);
    this.jdField_a_of_type_Bbms.a(-1);
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void a()
  {
    begr localbegr = (begr)behe.a(getActivity(), null);
    String[] arrayOfString = super.getResources().getStringArray(2130903098);
    localbegr.c(arrayOfString[24]);
    localbegr.c(arrayOfString[13]);
    localbegr.d(arrayOfString[16]);
    localbegr.a(new bbwa(this, localbegr));
    try
    {
      if (!getActivity().isFinishing()) {
        localbegr.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((paramEditable == null) || (paramEditable.length() == 0))
    {
      this.jdField_c_of_type_AndroidViewView.setEnabled(false);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setEnabled(true);
  }
  
  protected void b()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "dismissDialogProgress activity is null");
    }
    while ((getActivity().isFinishing()) || (this.jdField_a_of_type_Bbms == null) || (!this.jdField_a_of_type_Bbms.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_Bbms.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "hideSoftInput activity is null");
    }
    do
    {
      InputMethodManager localInputMethodManager;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
        localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      } while (localInputMethodManager == null);
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    } while (!QLog.isColorLevel());
    QLog.d("CreateVirtualAccountFragment", 2, new Object[] { "hideSoftInput, ", this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken() });
  }
  
  public void d()
  {
    if (getActivity() == null) {
      QLog.e("CreateVirtualAccountFragment", 1, "showSoftInput activity is null");
    }
    do
    {
      InputMethodManager localInputMethodManager;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
        this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
        this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
        localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      } while (localInputMethodManager == null);
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
    } while (!QLog.isColorLevel());
    QLog.d("CreateVirtualAccountFragment", 2, new Object[] { "hideSoftInput, ", this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken() });
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    QLog.d("CreateVirtualAccountFragment", 2, "doOnActivity result ====");
    b();
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
      paramIntent = this.jdField_a_of_type_AndroidNetUri;
      paramIntent = bacm.b(getActivity(), paramIntent);
    } while (TextUtils.isEmpty(paramIntent));
    ageu.a(getActivity(), paramIntent, 103);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_c_of_type_AndroidViewView) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        a(ajjy.a(2131636831), false);
      }
    }
    do
    {
      return;
      c();
      paramView = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + paramView + " headId==" + jdField_a_of_type_JavaLangString);
        f();
        this.jdField_a_of_type_Bcjn.a(this.jdField_b_of_type_Long, paramView, jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bcjw);
        return;
      }
      if (a(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + paramView + " headId==" + a(this.jdField_b_of_type_JavaLangString));
        f();
        this.jdField_a_of_type_Bcjn.a(this.jdField_b_of_type_Long, paramView, a(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Bcjw);
        return;
      }
      f();
      QLog.d("CreateVirtualAccountFragment", 2, "========> doUploadAvatarAndCreateVirtualAccount localPath = " + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bcjw);
      return;
      if (paramView == this.d)
      {
        c();
        e();
        return;
      }
      if (paramView == this.jdField_a_of_type_AndroidViewView)
      {
        a();
        return;
      }
      if (paramView == this.e)
      {
        if (getActivity() != null) {
          getActivity().finish();
        }
        onBackEvent();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetEditText);
    d();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131493918, paramViewGroup, false);
    if (QLog.isColorLevel()) {
      QLog.d("CreateVirtualAccountFragment", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.e = paramLayoutInflater.findViewById(2131297449);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131302071);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131304988);
    this.d = paramLayoutInflater.findViewById(2131308943);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131309813);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131313451));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131313455));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131311626));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(0);
    this.e.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_Bcjn = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    paramViewGroup = amdn.b(466);
    if ((paramViewGroup != null) && (paramViewGroup.a() != null))
    {
      this.jdField_a_of_type_JavaUtilList = paramViewGroup.a().a;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_b_of_type_Int = Math.abs(new Random().nextInt(this.jdField_a_of_type_JavaUtilList.size()));
      }
    }
    this.jdField_a_of_type_Bbms = new bbms(getActivity(), 0, 2131495448, 17);
    this.jdField_a_of_type_Bbms.a(-1);
    paramViewGroup = getActivity().getIntent();
    try
    {
      this.jdField_b_of_type_Long = Long.parseLong(paramViewGroup.getStringExtra("appid"));
      QLog.d("CreateVirtualAccountFragment", 1, new Object[] { "========> init appid = ", Long.valueOf(this.jdField_b_of_type_Long), ", mRandIndex=", Integer.valueOf(this.jdField_b_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new bbvz(this) });
      this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new CreateVirtualAccountFragment.2(this), 300L);
      return paramLayoutInflater;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        QLog.d("CreateVirtualAccountFragment", 1, "parse exception = ", paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Bcjw = null;
    this.jdField_a_of_type_Bcjn = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    b();
    QLog.d("CreateVirtualAccountFragment", 2, "doOnNewIntent====");
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (paramIntent != null) {
      a(paramIntent);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("CreateVirtualAccountFragment", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C")))) {
      ImmersiveUtils.a(getActivity().getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.a(true, getActivity().getWindow());
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
      ImmersiveUtils.a(getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, getResources().getColor(2131101537));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131101537));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment
 * JD-Core Version:    0.7.0.1
 */