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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
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
  
  private void a(BaseActivity paramBaseActivity)
  {
    QQToast.a(paramBaseActivity, 1, 2131719970, 0).a();
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850400);
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694952);
  }
  
  public Drawable a(Drawable paramDrawable)
  {
    Object localObject1 = getBaseActivity();
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    else
    {
      localObject1 = localObject2;
      if ((paramDrawable instanceof URLDrawable))
      {
        paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
        localObject1 = localObject2;
        if ((paramDrawable instanceof RegionDrawable)) {
          localObject1 = ((RegionDrawable)paramDrawable).getBitmap();
        }
      }
    }
    if (localObject1 == null)
    {
      paramDrawable = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
      paramDrawable.eraseColor(-7829368);
    }
    else
    {
      paramDrawable = ((Bitmap)localObject1).copy(Bitmap.Config.ARGB_8888, true);
    }
    StackBlur.a(paramDrawable, 40);
    return new LayerDrawable(new Drawable[] { new BitmapDrawable(getBaseActivity().getResources(), paramDrawable), new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { -1728053248, -1275068417, -1 }) });
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && ((localBaseActivity instanceof PublicFragmentActivity)))
    {
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localBaseActivity).mSystemBarComp;
      if ((localSystemBarCompact != null) && (needImmersive()) && (needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (ThemeUtil.isInNightMode(localBaseActivity.getAppRuntime()))
        {
          if ((!com.tencent.mobileqq.util.SystemUtil.b()) && (!com.tencent.mobileqq.util.SystemUtil.d()))
          {
            localSystemBarCompact.setStatusBarColor(8947848);
            return;
          }
          localSystemBarCompact.setStatusBarColor(8947848);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mobileqq.util.SystemUtil.b()) && (!com.tencent.mobileqq.util.SystemUtil.d()))
        {
          localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
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
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    BaseActivity localBaseActivity = getBaseActivity();
    localBaseActivity.getWindow().addFlags(256);
    localBaseActivity.getWindow().addFlags(512);
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131365546));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131364341));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131365562));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131364063));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.mContentView.findViewById(2131365292).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(null));
    getBaseActivity().app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    hideTitleBar();
    paramLayoutInflater = this.mContentView.findViewById(2131365569).getLayoutParams();
    int i = cooperation.qzone.util.SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
    if (i > paramLayoutInflater.height)
    {
      paramLayoutInflater.height = i;
    }
    else
    {
      i = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      if (i > paramLayoutInflater.height) {
        paramLayoutInflater.height = i;
      }
    }
    this.jdField_a_of_type_Int = localBaseActivity.getIntent().getIntExtra("cover_id_key", 0);
    this.jdField_b_of_type_Int = localBaseActivity.getIntent().getIntExtra("cover_button_key", 0);
    i = this.jdField_b_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694952);
    }
    else if (i == 2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718818);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850400);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131694952);
    }
    paramLayoutInflater = ((VasExtensionManager)localBaseActivity.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
    if (paramLayoutInflater != null)
    {
      i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem = paramLayoutInflater.a(i, false);
        paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem;
        if (paramLayoutInflater != null)
        {
          if (!TextUtils.isEmpty(paramLayoutInflater.a)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem.a);
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardManager$DefaultCardItem.d)) {
            this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnGlobalLayoutListener(new CoverDetailFragment.1(this));
          }
        }
        else
        {
          QLog.e("Q.profilecard.FrdProfileCard.CoverDetailFragment", 0, "item is null");
        }
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131562007;
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364063)
    {
      if ((i == 2131365292) && (getBaseActivity() != null)) {
        getBaseActivity().finish();
      }
    }
    else
    {
      i = this.jdField_b_of_type_Int;
      if (i == 1)
      {
        if ((getBaseActivity() != null) && (getBaseActivity().app != null) && (this.jdField_a_of_type_Int > 0))
        {
          QQAppInterface localQQAppInterface = getBaseActivity().app;
          ((ISVIPHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(this.jdField_a_of_type_Int);
          VasWebviewUtil.a(localQQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(this.jdField_a_of_type_Int), "");
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130850380);
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(-8947849);
          this.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702783));
          this.jdField_b_of_type_Int = 3;
        }
      }
      else if ((i == 0) && (getBaseActivity() != null)) {
        QQToast.a(getBaseActivity(), 0, 2131690745, 0).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getBaseActivity().app != null) {
      getBaseActivity().app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment
 * JD-Core Version:    0.7.0.1
 */