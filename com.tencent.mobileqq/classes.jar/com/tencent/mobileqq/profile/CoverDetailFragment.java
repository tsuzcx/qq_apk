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
  private ImageView a;
  private ImageView b;
  private Button c;
  private TextView d;
  private int e;
  private int f;
  private ProfileCardManager.DefaultCardItem g;
  private URLDrawable.URLDrawableListener h = new CoverDetailFragment.2(this);
  private SVIPObserver i = new CoverDetailFragment.3(this);
  
  private void a(BaseActivity paramBaseActivity)
  {
    QQToast.makeText(paramBaseActivity, 1, 2131917575, 0).show();
    this.c.setBackgroundResource(2130852191);
    this.f = 1;
    this.c.setTextColor(-16777216);
    this.c.setText(2131892679);
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
          if ((!com.tencent.mobileqq.util.SystemUtil.d()) && (!com.tencent.mobileqq.util.SystemUtil.g()))
          {
            localSystemBarCompact.setStatusBarColor(8947848);
            return;
          }
          localSystemBarCompact.setStatusBarColor(8947848);
          localSystemBarCompact.setStatusBarDarkMode(true);
          return;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mobileqq.util.SystemUtil.d()) && (!com.tencent.mobileqq.util.SystemUtil.g()))
        {
          localBaseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
          localSystemBarCompact.setStatusBarColor(16777215);
          return;
        }
        if (!com.tencent.mobileqq.util.SystemUtil.g())
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
    this.a = ((ImageView)this.mContentView.findViewById(2131431773));
    this.b = ((ImageView)this.mContentView.findViewById(2131430369));
    this.d = ((TextView)this.mContentView.findViewById(2131431789));
    this.c = ((Button)this.mContentView.findViewById(2131430021));
    this.c.setOnClickListener(this);
    this.mContentView.findViewById(2131431468).setOnClickListener(this);
    this.a.setImageDrawable(a(null));
    getBaseActivity().app.addObserver(this.i);
    hideTitleBar();
    paramLayoutInflater = this.mContentView.findViewById(2131431796).getLayoutParams();
    int j = cooperation.qzone.util.SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
    if (j > paramLayoutInflater.height)
    {
      paramLayoutInflater.height = j;
    }
    else
    {
      j = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      if (j > paramLayoutInflater.height) {
        paramLayoutInflater.height = j;
      }
    }
    this.e = localBaseActivity.getIntent().getIntExtra("cover_id_key", 0);
    this.f = localBaseActivity.getIntent().getIntExtra("cover_button_key", 0);
    j = this.f;
    if (j == 0)
    {
      this.c.setBackgroundResource(2130852171);
      this.c.setTextColor(-8947849);
      this.c.setText(2131892679);
    }
    else if (j == 2)
    {
      this.c.setBackgroundResource(2130852171);
      this.c.setTextColor(-8947849);
      this.c.setText(2131916326);
    }
    else
    {
      this.c.setBackgroundResource(2130852191);
      this.c.setTextColor(-16777216);
      this.c.setText(2131892679);
    }
    paramLayoutInflater = ((VasExtensionManager)localBaseActivity.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
    if (paramLayoutInflater != null)
    {
      j = this.e;
      if (j > 0)
      {
        this.g = paramLayoutInflater.a(j, false);
        paramLayoutInflater = this.g;
        if (paramLayoutInflater != null)
        {
          if (!TextUtils.isEmpty(paramLayoutInflater.b)) {
            this.d.setText(this.g.b);
          }
          if (!TextUtils.isEmpty(this.g.e)) {
            this.b.getViewTreeObserver().addOnGlobalLayoutListener(new CoverDetailFragment.1(this));
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
    return 2131628433;
  }
  
  protected boolean isTransparent()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131430021)
    {
      if ((j == 2131431468) && (getBaseActivity() != null)) {
        getBaseActivity().finish();
      }
    }
    else
    {
      j = this.f;
      if (j == 1)
      {
        if ((getBaseActivity() != null) && (getBaseActivity().app != null) && (this.e > 0))
        {
          QQAppInterface localQQAppInterface = getBaseActivity().app;
          ((ISVIPHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g(this.e);
          VasWebviewUtil.a(localQQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(this.e), "");
          this.c.setBackgroundResource(2130852171);
          this.c.setTextColor(-8947849);
          this.c.setText(HardCodeUtil.a(2131900773));
          this.f = 3;
        }
      }
      else if ((j == 0) && (getBaseActivity() != null)) {
        QQToast.makeText(getBaseActivity(), 0, 2131887665, 0).show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getBaseActivity().app != null) {
      getBaseActivity().app.removeObserver(this.i);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment
 * JD-Core Version:    0.7.0.1
 */