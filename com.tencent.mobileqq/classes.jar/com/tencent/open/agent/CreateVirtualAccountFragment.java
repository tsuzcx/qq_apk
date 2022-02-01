package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean.OpenSdkRandomConfig;
import com.tencent.mobileqq.config.business.OpenSdkRandomConfBean.RandomInfo;
import com.tencent.mobileqq.config.business.OpenSdkRandomProcessor;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.auth.ContractBuilder;
import com.tencent.open.agent.auth.IVirtualCreatorContract.Presenter;
import com.tencent.open.agent.auth.IVirtualCreatorContract.View;
import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.ParseUtil;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CreateVirtualAccountFragment
  extends QPublicBaseFragment
  implements TextWatcher, View.OnClickListener, IVirtualCreatorContract.View
{
  private final int jdField_a_of_type_Int = 1000;
  private long jdField_a_of_type_Long = 0L;
  private Uri jdField_a_of_type_AndroidNetUri;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private IVirtualCreatorContract.Presenter jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter;
  private final String jdField_a_of_type_JavaLangString = "CreateVirtualAccountFragment";
  private List<OpenSdkRandomConfBean.RandomInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 11;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private final String jdField_b_of_type_JavaLangString = "1001_0cab6b944b59d75644e53b70de2f5d5a";
  private int jdField_c_of_type_Int = 0;
  private View jdField_c_of_type_AndroidViewView;
  private String jdField_c_of_type_JavaLangString;
  private View d;
  
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
  
  private void a(Activity paramActivity, int paramInt)
  {
    if (paramInt == 151)
    {
      AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131707853), false);
      localObject = new Intent();
      ((Intent)localObject).putExtra("createVirtualAccount", 2);
      paramActivity.setResult(101, (Intent)localObject);
      paramActivity.finish();
      return;
    }
    if (paramInt == 10670)
    {
      AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131707858), false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131702792));
    ((StringBuilder)localObject).append(paramInt);
    AuthUIUtil.a(paramActivity, ((StringBuilder)localObject).toString(), false);
  }
  
  private void a(Activity paramActivity, long paramLong)
  {
    AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131702790), true);
    Intent localIntent = new Intent();
    localIntent.putExtra("createVirtualAccount", 1);
    localIntent.putExtra("createVirtualVid", paramLong);
    paramActivity.setResult(101, localIntent);
    paramActivity.finish();
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if (paramURLImageView == null) {
      return;
    }
    Object localObject = null;
    try
    {
      Drawable localDrawable = getResources().getDrawable(2130840321);
      localObject = localDrawable;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SSOLog.c("CreateVirtualAccountFragment", "-->create color drawable oom.", localOutOfMemoryError);
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localObject;
    localURLDrawableOptions.mFailedDrawable = localObject;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramString == null) {
      return;
    }
    paramString.setDecodeHandler(QQLiteStatusUtil.a());
    if (paramString.getStatus() == 2)
    {
      SSOLog.a("CreateVirtualAccountFragment", new Object[] { "setVirtualIcon restartDownload" });
      paramString.restartDownload();
      return;
    }
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "setVirtualIcon success" });
    paramURLImageView.setImageDrawable(paramString);
  }
  
  private boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (TextUtils.equals(((OpenSdkRandomConfBean.RandomInfo)((Iterator)localObject).next()).jdField_c_of_type_JavaLangString, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onSaveBtnClick name=", localObject, ", mCurrentIconLocalPath=", this.jdField_c_of_type_JavaLangString });
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 1000L)
    {
      SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onSaveBtnClick repeat click" });
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131702791), false);
      return;
    }
    b();
    g();
    localObject = localObject.toString();
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter.a(this.jdField_b_of_type_Long, (String)localObject, "1001_0cab6b944b59d75644e53b70de2f5d5a", QQLiteStatusUtil.a());
      return;
    }
    if (a(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter.a(this.jdField_b_of_type_Long, (String)localObject, a(this.jdField_c_of_type_JavaLangString), QQLiteStatusUtil.a());
      return;
    }
    e();
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uploadAvatar localPath = ");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = String.valueOf(this.jdField_b_of_type_Long);
    AccountInfo localAccountInfo = AuthMemoryCache.a().a((String)localObject);
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (localAccountInfo != null))
    {
      ThreadManagerV2.executeOnSubThread(new CreateVirtualAccountFragment.3(this, (String)localObject));
      return;
    }
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "uploadAvatar params error" });
    a(false, this.jdField_c_of_type_JavaLangString, null, -1);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int i = this.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_JavaUtilList.size();
      localObject = (OpenSdkRandomConfBean.RandomInfo)this.jdField_a_of_type_JavaUtilList.get(i % j);
      if (localObject == null)
      {
        SSOLog.a("CreateVirtualAccountFragment", new Object[] { " current randomInfo is null" });
        return;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(((OpenSdkRandomConfBean.RandomInfo)localObject).jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(((OpenSdkRandomConfBean.RandomInfo)localObject).jdField_c_of_type_JavaLangString))
      {
        this.jdField_c_of_type_JavaLangString = ((OpenSdkRandomConfBean.RandomInfo)localObject).jdField_c_of_type_JavaLangString;
        a(this.jdField_a_of_type_ComTencentImageURLImageView, ((OpenSdkRandomConfBean.RandomInfo)localObject).jdField_c_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Int += 1;
      return;
    }
    AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131702794), false);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "randomInfo config is null" });
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = AuthUIUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog, 2131561398);
  }
  
  public void a()
  {
    ActionSheet localActionSheet = AuthUIUtil.a(getActivity(), null);
    QQLiteStatusUtil.a(localActionSheet);
    localActionSheet.setOnButtonClickListener(new CreateVirtualAccountFragment.4(this, localActionSheet));
    try
    {
      if (!getActivity().isFinishing())
      {
        localActionSheet.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(IVirtualCreatorContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter = paramPresenter;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", code=");
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onCreateVirtual success=", Boolean.valueOf(paramBoolean), ", virtualId=", ((StringBuilder)localObject).toString(), Integer.valueOf(paramInt) });
    localObject = getActivity();
    if (localObject == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "onCreateVirtual activity is null" });
      return;
    }
    AuthUIUtil.a((Activity)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    if (paramBoolean)
    {
      a((Activity)localObject, paramLong);
      return;
    }
    a((Activity)localObject, paramInt);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", headId=");
    localStringBuilder.append(paramString2);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onUploadAvatar success=", Boolean.valueOf(paramBoolean), ", filePath=", paramString1, localStringBuilder.toString(), ", code=", Integer.valueOf(paramInt) });
    if (getActivity() == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "onUploadAvatar activity is null" });
      return;
    }
    AuthUIUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    if (!paramBoolean)
    {
      paramString1 = getActivity();
      paramString2 = new StringBuilder();
      paramString2.append(HardCodeUtil.a(2131702795));
      paramString2.append(paramInt);
      AuthUIUtil.a(paramString1, paramString2.toString(), false);
      return;
    }
    paramString1 = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if (TextUtils.isEmpty(paramString1))
    {
      AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131702793), false);
      return;
    }
    g();
    this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter.a(this.jdField_b_of_type_Long, paramString1.toString(), paramString2, QQLiteStatusUtil.a());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.jdField_b_of_type_AndroidViewView.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
  }
  
  public void b()
  {
    if (getActivity() == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "hideSoftInput activity is null" });
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      return;
    }
    ((EditText)localObject).clearFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    localObject = (InputMethodManager)getQBaseActivity().getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "hideSoftInput, ", this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken() });
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if (getActivity() == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "showSoftInput activity is null" });
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText;
    if (localObject == null) {
      return;
    }
    ((EditText)localObject).setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    localObject = (InputMethodManager)getQBaseActivity().getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "showSoftInput, ", this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken() });
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onActivityResult resultCode=", Integer.valueOf(paramInt2) });
    AuthUIUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    if (paramInt2 != -1) {
      return;
    }
    QQLiteStatusUtil.a(paramInt1, getQBaseActivity(), this.jdField_a_of_type_AndroidNetUri);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewView)
    {
      d();
    }
    else if (paramView == this.jdField_c_of_type_AndroidViewView)
    {
      b();
      f();
    }
    else if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      a();
    }
    else if (paramView == this.d)
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      onBackEvent();
    }
    else if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ContractBuilder.a(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559670, paramViewGroup, false);
    this.d = paramLayoutInflater.findViewById(2131363340);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131368356);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131375967);
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376895);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131380955));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramLayoutInflater.findViewById(2131380959));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131378881)).setBackgroundColor(0);
    this.d.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    paramViewGroup = OpenSdkRandomProcessor.b(466);
    if (paramViewGroup.a() != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramViewGroup.a().a;
      paramViewGroup = this.jdField_a_of_type_JavaUtilList;
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0)) {
        this.jdField_c_of_type_Int = Math.abs(new Random().nextInt(this.jdField_a_of_type_JavaUtilList.size()));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), 0, 2131561398, 17);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(-1);
    this.jdField_b_of_type_Long = ParseUtil.a(AuthParamUtil.a(getActivity(), "appid"));
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onCreateView appId=", Long.valueOf(this.jdField_b_of_type_Long), ", mRandIndex=", Integer.valueOf(this.jdField_c_of_type_Int) });
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new CreateVirtualAccountFragment.1(this) });
    this.jdField_a_of_type_AndroidWidgetEditText.postDelayed(new CreateVirtualAccountFragment.2(this), 300L);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "doOnNewIntent====" });
    super.onNewIntent(paramIntent);
    AuthUIUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    paramIntent = QQLiteStatusUtil.a(paramIntent);
    this.jdField_a_of_type_ComTencentOpenAgentAuthIVirtualCreatorContract$Presenter.a(paramIntent, this.jdField_a_of_type_ComTencentImageURLImageView.getWidth(), this.jdField_a_of_type_ComTencentImageURLImageView.getHeight());
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MANUFACTURER = ");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(", MODEL = ");
    localStringBuilder.append(Build.MODEL);
    SSOLog.b("CreateVirtualAccountFragment", localStringBuilder.toString());
    if ((!"MeizuPRO 7-S".equals(localObject)) && (!"MeizuM711C".equalsIgnoreCase((String)localObject))) {
      ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
    } else {
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
    }
    ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = new SystemBarCompact(getActivity(), true, getResources().getColor(2131167394));
      ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131167394));
      ((SystemBarCompact)localObject).init();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment
 * JD-Core Version:    0.7.0.1
 */