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
  private final String a = "CreateVirtualAccountFragment";
  private View b;
  private View c;
  private View d;
  private URLImageView e;
  private EditText f;
  private View g;
  private QQProgressDialog h;
  private final int i = 1000;
  private long j = 0L;
  private Uri k;
  private final int l = 11;
  private final String m = "1001_0cab6b944b59d75644e53b70de2f5d5a";
  private String n;
  private List<OpenSdkRandomConfBean.RandomInfo> o;
  private long p = 0L;
  private int q = 0;
  private boolean r;
  private IVirtualCreatorContract.Presenter s;
  
  private void a(Activity paramActivity, int paramInt)
  {
    if (paramInt == 151)
    {
      AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131905667), false);
      localObject = new Intent();
      ((Intent)localObject).putExtra("createVirtualAccount", 2);
      paramActivity.setResult(101, (Intent)localObject);
      paramActivity.finish();
      return;
    }
    if (paramInt == 10670)
    {
      AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131905672), false);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131900782));
    ((StringBuilder)localObject).append(paramInt);
    AuthUIUtil.a(paramActivity, ((StringBuilder)localObject).toString(), false);
  }
  
  private void a(Activity paramActivity, long paramLong)
  {
    AuthUIUtil.a(paramActivity, HardCodeUtil.a(2131900780), true);
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
      Drawable localDrawable = getResources().getDrawable(2130841060);
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
    paramString.setDecodeHandler(QQLiteStatusUtil.c());
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
    Object localObject = this.o;
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (TextUtils.equals(((OpenSdkRandomConfBean.RandomInfo)((Iterator)localObject).next()).c, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private String b(String paramString)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      OpenSdkRandomConfBean.RandomInfo localRandomInfo = (OpenSdkRandomConfBean.RandomInfo)localIterator.next();
      if (TextUtils.equals(localRandomInfo.c, paramString)) {
        return localRandomInfo.b;
      }
    }
    return "";
  }
  
  private void d()
  {
    Object localObject = this.f.getText();
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onSaveBtnClick name=", localObject, ", mCurrentIconLocalPath=", this.n });
    if (System.currentTimeMillis() - this.j <= 1000L)
    {
      SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onSaveBtnClick repeat click" });
      return;
    }
    this.j = System.currentTimeMillis();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131900781), false);
      return;
    }
    b();
    g();
    localObject = localObject.toString();
    if (TextUtils.isEmpty(this.n))
    {
      this.s.a(this.p, (String)localObject, "1001_0cab6b944b59d75644e53b70de2f5d5a", QQLiteStatusUtil.a());
      return;
    }
    if (a(this.n))
    {
      this.s.a(this.p, (String)localObject, b(this.n), QQLiteStatusUtil.a());
      return;
    }
    e();
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uploadAvatar localPath = ");
    ((StringBuilder)localObject).append(this.n);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = String.valueOf(this.p);
    AccountInfo localAccountInfo = AuthMemoryCache.a().d((String)localObject);
    if ((!TextUtils.isEmpty(this.n)) && (localAccountInfo != null))
    {
      ThreadManagerV2.executeOnSubThread(new CreateVirtualAccountFragment.3(this, (String)localObject));
      return;
    }
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "uploadAvatar params error" });
    a(false, this.n, null, -1);
  }
  
  private void f()
  {
    Object localObject = this.o;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int i1 = this.q;
      int i2 = this.o.size();
      localObject = (OpenSdkRandomConfBean.RandomInfo)this.o.get(i1 % i2);
      if (localObject == null)
      {
        SSOLog.a("CreateVirtualAccountFragment", new Object[] { " current randomInfo is null" });
        return;
      }
      this.f.setText(((OpenSdkRandomConfBean.RandomInfo)localObject).a);
      if (!TextUtils.isEmpty(((OpenSdkRandomConfBean.RandomInfo)localObject).c))
      {
        this.n = ((OpenSdkRandomConfBean.RandomInfo)localObject).c;
        a(this.e, ((OpenSdkRandomConfBean.RandomInfo)localObject).c);
      }
      this.q += 1;
      return;
    }
    AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131900784), false);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "randomInfo config is null" });
  }
  
  private void g()
  {
    this.h = AuthUIUtil.a(getActivity(), this.h, 2131627754);
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
    this.e.setImageBitmap(paramBitmap);
    this.n = paramString;
  }
  
  public void a(IVirtualCreatorContract.Presenter paramPresenter)
  {
    this.s = paramPresenter;
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
    AuthUIUtil.a((Activity)localObject, this.h);
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
    AuthUIUtil.a(getActivity(), this.h);
    if (!paramBoolean)
    {
      paramString1 = getActivity();
      paramString2 = new StringBuilder();
      paramString2.append(HardCodeUtil.a(2131900785));
      paramString2.append(paramInt);
      AuthUIUtil.a(paramString1, paramString2.toString(), false);
      return;
    }
    paramString1 = this.f.getText();
    if (TextUtils.isEmpty(paramString1))
    {
      AuthUIUtil.a(getActivity(), HardCodeUtil.a(2131900783), false);
      return;
    }
    g();
    this.s.a(this.p, paramString1.toString(), paramString2, QQLiteStatusUtil.a());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.c.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
  }
  
  public void b()
  {
    if (getActivity() == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "hideSoftInput activity is null" });
      return;
    }
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    ((EditText)localObject).clearFocus();
    this.f.setCursorVisible(false);
    localObject = (InputMethodManager)getQBaseActivity().getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).hideSoftInputFromWindow(this.f.getWindowToken(), 0);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "hideSoftInput, ", this.f.getWindowToken() });
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c()
  {
    if (getActivity() == null)
    {
      SSOLog.b("CreateVirtualAccountFragment", new Object[] { "showSoftInput activity is null" });
      return;
    }
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    ((EditText)localObject).setFocusable(true);
    this.f.setFocusableInTouchMode(true);
    this.f.setCursorVisible(true);
    this.f.requestFocus();
    localObject = (InputMethodManager)getQBaseActivity().getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    ((InputMethodManager)localObject).showSoftInput(this.f, 0);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "showSoftInput, ", this.f.getWindowToken() });
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onActivityResult resultCode=", Integer.valueOf(paramInt2) });
    AuthUIUtil.a(getActivity(), this.h);
    if (paramInt2 != -1) {
      return;
    }
    QQLiteStatusUtil.a(paramInt1, getQBaseActivity(), this.k);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.c)
    {
      d();
    }
    else if (paramView == this.d)
    {
      b();
      f();
    }
    else if (paramView == this.b)
    {
      a();
    }
    else if (paramView == this.g)
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      onBackEvent();
    }
    else if (paramView == this.f)
    {
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    ContractBuilder.a(this);
    paramLayoutInflater = paramLayoutInflater.inflate(2131625700, paramViewGroup, false);
    this.g = paramLayoutInflater.findViewById(2131429218);
    this.b = paramLayoutInflater.findViewById(2131435234);
    this.d = paramLayoutInflater.findViewById(2131444155);
    this.c = paramLayoutInflater.findViewById(2131445243);
    this.e = ((URLImageView)paramLayoutInflater.findViewById(2131449945));
    this.f = ((EditText)paramLayoutInflater.findViewById(2131449949));
    this.f.addTextChangedListener(this);
    ((ImmersiveTitleBar2)paramLayoutInflater.findViewById(2131447582)).setBackgroundColor(0);
    this.g.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    paramViewGroup = OpenSdkRandomProcessor.b(466);
    if (paramViewGroup.b() != null)
    {
      this.o = paramViewGroup.b().a;
      paramViewGroup = this.o;
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0)) {
        this.q = Math.abs(new Random().nextInt(this.o.size()));
      }
    }
    this.h = new QQProgressDialog(getActivity(), 0, 2131627754, 17);
    this.h.a(-1);
    this.p = ParseUtil.a(AuthParamUtil.a(getActivity(), "appid"));
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "onCreateView appId=", Long.valueOf(this.p), ", mRandIndex=", Integer.valueOf(this.q) });
    this.f.setFilters(new InputFilter[] { new CreateVirtualAccountFragment.1(this) });
    this.f.postDelayed(new CreateVirtualAccountFragment.2(this), 300L);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    SSOLog.a("CreateVirtualAccountFragment", new Object[] { "doOnNewIntent====" });
    super.onNewIntent(paramIntent);
    AuthUIUtil.a(getActivity(), this.h);
    paramIntent = QQLiteStatusUtil.a(paramIntent);
    this.s.a(paramIntent, this.e.getWidth(), this.e.getHeight());
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
    if (this.r) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = new SystemBarCompact(getActivity(), true, getResources().getColor(2131168464));
      ((SystemBarCompact)localObject).setStatusBarColor(getResources().getColor(2131168464));
      ((SystemBarCompact)localObject).init();
    }
    this.r = true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.CreateVirtualAccountFragment
 * JD-Core Version:    0.7.0.1
 */