package com.tencent.open.agent;

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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean.OpenSdkRandomConfig;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean.RandomInfo;
import com.tencent.mobileqq.config.business.OpenSdkRandomProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
  private long jdField_a_of_type_Long = 0L;
  Uri jdField_a_of_type_AndroidNetUri;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected QQProgressDialog a;
  private AuthCallback jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = new CreateVirtualAccountFragment.6(this);
  private OpenSdkVirtualManager jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = null;
  private OpenSDKAppInterface jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private List<OpenSdkRandomConfBean.RandomInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
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
      OpenSdkRandomConfBean.RandomInfo localRandomInfo = (OpenSdkRandomConfBean.RandomInfo)localIterator.next();
      if (TextUtils.equals(localRandomInfo.jdField_c_of_type_JavaLangString, paramString)) {
        return localRandomInfo.jdField_b_of_type_JavaLangString;
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
        localObject = getResources().getDrawable(2130840452);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString != null)
        {
          paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
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
      if (TextUtils.equals(((OpenSdkRandomConfBean.RandomInfo)localIterator.next()).jdField_c_of_type_JavaLangString, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      a(HardCodeUtil.a(2131702661), false);
      QLog.d("CreateVirtualAccountFragment", 1, "randomInfo config is null");
      return;
    }
    int i = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    OpenSdkRandomConfBean.RandomInfo localRandomInfo = (OpenSdkRandomConfBean.RandomInfo)this.jdField_a_of_type_JavaUtilList.get(i % j);
    if (localRandomInfo == null)
    {
      QLog.d("CreateVirtualAccountFragment", 1, " current randomInfo is null");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setText(localRandomInfo.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(localRandomInfo.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = localRandomInfo.jdField_c_of_type_JavaLangString;
      a(this.jdField_a_of_type_ComTencentImageURLImageView, localRandomInfo.jdField_c_of_type_JavaLangString);
    }
    this.jdField_b_of_type_Int += 1;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561557, 17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    String[] arrayOfString = super.getResources().getStringArray(2130968636);
    localActionSheet.addButton(arrayOfString[24]);
    localActionSheet.addButton(arrayOfString[13]);
    localActionSheet.addCancelButton(arrayOfString[16]);
    localActionSheet.setOnButtonClickListener(new CreateVirtualAccountFragment.4(this, localActionSheet));
    try
    {
      if (!getActivity().isFinishing()) {
        localActionSheet.show();
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
    while ((getActivity().isFinishing()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      paramIntent = ImageUtil.b(getActivity(), paramIntent);
    } while (TextUtils.isEmpty(paramIntent));
    TroopPhotoUtil.a(getActivity(), paramIntent, 103);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_c_of_type_AndroidViewView) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
        a(HardCodeUtil.a(2131702658), false);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      c();
      String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + jdField_a_of_type_JavaLangString);
        f();
        this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_b_of_type_Long, str, jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback);
      }
      else if (a(this.jdField_b_of_type_JavaLangString))
      {
        QLog.d("CreateVirtualAccountFragment", 2, "========> doCreateVirtualAccount nickName = " + str + " headId==" + a(this.jdField_b_of_type_JavaLangString));
        f();
        this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager.a(this.jdField_b_of_type_Long, str, a(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback);
      }
      else
      {
        f();
        QLog.d("CreateVirtualAccountFragment", 2, "========> doUploadAvatarAndCreateVirtualAccount localPath = " + this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a().a(String.valueOf(this.jdField_b_of_type_Long), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback);
        continue;
        if (paramView == this.d)
        {
          c();
          e();
        }
        else if (paramView == this.jdField_a_of_type_AndroidViewView)
        {
          a();
        }
        else if (paramView == this.e)
        {
          if (getActivity() != null) {
            getActivity().finish();
          }
          onBackEvent();
        }
        else if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
        {
          d();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559793, paramViewGroup, false);
    if (QLog.isColorLevel()) {
      QLog.d("CreateVirtualAccountFragment", 2, "-->onCreate--");
    }
    this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface = ((OpenSDKAppInterface)getActivity().getAppRuntime());
    this.e = paramLayoutInflater.findViewById(2131363408);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131368617);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131372121);
    this.d = paramLayoutInflater.findViewById(2131376455);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131377448);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131381723));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131381727));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131379533));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(0);
    this.e.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = this.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a();
    paramViewGroup = OpenSdkRandomProcessor.b(466);
    if ((paramViewGroup != null) && (paramViewGroup.a() != null))
    {
      this.jdField_a_of_type_JavaUtilList = paramViewGroup.a().a;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_b_of_type_Int = Math.abs(new Random().nextInt(this.jdField_a_of_type_JavaUtilList.size()));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561557, 17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    paramViewGroup = getActivity().getIntent();
    try
    {
      this.jdField_b_of_type_Long = Long.parseLong(paramViewGroup.getStringExtra("appid"));
      QLog.d("CreateVirtualAccountFragment", 1, new Object[] { "========> init appid = ", Long.valueOf(this.jdField_b_of_type_Long), ", mRandIndex=", Integer.valueOf(this.jdField_b_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new CreateVirtualAccountFragment.1(this) });
      this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new CreateVirtualAccountFragment.2(this), 300L);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback = null;
    this.jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager = null;
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
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
      ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(getActivity(), true, getResources().getColor(2131167374));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(getResources().getColor(2131167374));
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment
 * JD-Core Version:    0.7.0.1
 */