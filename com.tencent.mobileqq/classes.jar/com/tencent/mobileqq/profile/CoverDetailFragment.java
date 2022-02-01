package com.tencent.mobileqq.profile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class CoverDetailFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new CoverDetailFragment.2(this);
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new CoverDetailFragment.3(this);
  private ProfileCardManager.DefaultCardItem jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  private void a(FragmentActivity paramFragmentActivity)
  {
    QQToast.a(paramFragmentActivity, 1, 2131720237, 0).a();
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850473);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694962);
  }
  
  public Drawable a(Drawable paramDrawable)
  {
    Object localObject2 = null;
    if (getActivity() == null) {
      return null;
    }
    Object localObject1;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
      if (localObject1 != null) {
        break label150;
      }
      paramDrawable = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
      paramDrawable.eraseColor(-7829368);
    }
    for (;;)
    {
      StackBlur.a(paramDrawable, 40);
      return new LayerDrawable(new Drawable[] { new BitmapDrawable(getActivity().getResources(), paramDrawable), new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -1728053248, -1275068417, -1 }) });
      localObject1 = localObject2;
      if (!(paramDrawable instanceof URLDrawable)) {
        break;
      }
      paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
      localObject1 = localObject2;
      if (!(paramDrawable instanceof RegionDrawable)) {
        break;
      }
      localObject1 = ((RegionDrawable)paramDrawable).getBitmap();
      break;
      label150:
      paramDrawable = ((Bitmap)localObject1).copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    FragmentActivity localFragmentActivity = getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof PublicFragmentActivity)))
    {
      localSystemBarCompact = ((PublicFragmentActivity)localFragmentActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(localFragmentActivity.getAppRuntime())) {
          break label113;
        }
        if ((com.tencent.mobileqq.util.SystemUtil.b()) || (com.tencent.mobileqq.util.SystemUtil.d())) {
          break label101;
        }
        localSystemBarCompact.setStatusBarColor(8947848);
      }
    }
    return;
    label101:
    localSystemBarCompact.setStatusBarColor(8947848);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label113:
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mobileqq.util.SystemUtil.b()) && (!com.tencent.mobileqq.util.SystemUtil.d()))
    {
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(16777215);
      return;
    }
    if (!com.tencent.mobileqq.util.SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(14408667);
      return;
    }
    localSystemBarCompact.setStatusBarColor(16777215);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    localFragmentActivity.getWindow().addFlags(256);
    localFragmentActivity.getWindow().addFlags(512);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365709));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131364451));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365725));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364142));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.mContentView.findViewById(2131365427).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(null));
    getActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    hideTitleBar();
    paramLayoutInflater = this.mContentView.findViewById(2131365732).getLayoutParams();
    int i = cooperation.qzone.util.SystemUtil.getNotchHeight(getActivity(), getActivity());
    if (i > paramLayoutInflater.height)
    {
      paramLayoutInflater.height = i;
      this.jdField_a_of_type_Int = localFragmentActivity.getIntent().getIntExtra("cover_id_key", 0);
      this.jdField_b_of_type_Int = localFragmentActivity.getIntent().getIntExtra("cover_button_key", 0);
      if (this.jdField_b_of_type_Int != 0) {
        break label396;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850453);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694962);
    }
    for (;;)
    {
      paramLayoutInflater = ((VasExtensionManager)localFragmentActivity.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      if ((paramLayoutInflater != null) && (this.jdField_a_of_type_Int > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem = paramLayoutInflater.a(this.jdField_a_of_type_Int, false);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem == null) {
          break label467;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem.a)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem.a);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem.d)) {
          this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new CoverDetailFragment.1(this));
        }
      }
      return;
      i = ImmersiveUtils.getStatusBarHeight(getActivity());
      if (i <= paramLayoutInflater.height) {
        break;
      }
      paramLayoutInflater.height = i;
      break;
      label396:
      if (this.jdField_b_of_type_Int == 2)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850453);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131719100);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850473);
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131694962);
      }
    }
    label467:
    QLog.e("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, "item is null");
  }
  
  public int getContentLayoutId()
  {
    return 2131562170;
  }
  
  public boolean isTransparent()
  {
    return true;
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
      if (getActivity() != null)
      {
        getActivity().finish();
        continue;
        if (this.jdField_b_of_type_Int == 1)
        {
          if ((getActivity() != null) && (getActivity().app != null) && (this.jdField_a_of_type_Int > 0))
          {
            QQAppInterface localQQAppInterface = getActivity().app;
            ((SVIPHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(this.jdField_a_of_type_Int);
            VasWebviewUtil.reportCommercialDrainage(localQQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(this.jdField_a_of_type_Int), "");
            this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850453);
            this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
            this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702650));
            this.jdField_b_of_type_Int = 3;
          }
        }
        else if ((this.jdField_b_of_type_Int == 0) && (getActivity() != null)) {
          QQToast.a(getActivity(), 0, 2131690817, 0).a();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getActivity().app != null) {
      getActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment
 * JD-Core Version:    0.7.0.1
 */