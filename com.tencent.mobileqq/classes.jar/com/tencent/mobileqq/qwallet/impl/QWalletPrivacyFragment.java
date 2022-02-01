package com.tencent.mobileqq.qwallet.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;

public class QWalletPrivacyFragment
  extends QPublicBaseFragment
{
  private void a(View paramView)
  {
    String str2 = getArguments().getString("title", "");
    Object localObject2 = getArguments().getString("content", "");
    String str1 = getArguments().getString("background", "");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCreate:");
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(str1);
      QLog.i("QWalletPrivacyFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("\\n", "\n");
    }
    localObject2 = QWalletTools.a((String)localObject1, getQBaseActivity(), new QWalletPrivacyFragment.1(this));
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str1)))
    {
      localObject1 = DialogUtil.a(getQBaseActivity(), 230, R.layout.A, str2, (CharSequence)localObject2, R.string.dq, R.string.dp, new QWalletPrivacyFragment.2(this), new QWalletPrivacyFragment.3(this));
      ((QQCustomDialog)localObject1).setCancelable(false);
      ((QQCustomDialog)localObject1).setCanceledOnTouchOutside(false);
      ((QQCustomDialog)localObject1).show();
      paramView = (RelativeLayout)paramView.findViewById(R.id.bF);
      localObject1 = new ColorDrawable(-1);
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
      paramView.setBackgroundDrawable(URLDrawable.getDrawable(str1, (URLDrawable.URLDrawableOptions)localObject2));
      return;
    }
    a();
  }
  
  public void a()
  {
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).launchQWalletAct(getQBaseActivity(), (BaseQQAppInterface)getQBaseActivity().getAppRuntime(), false, false);
    getActivity().finish();
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.z, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).preloadQWallet(getQBaseActivity().getAppRuntime(), 0, "qwallet_default");
    try
    {
      a(paramView);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPrivacyFragment
 * JD-Core Version:    0.7.0.1
 */