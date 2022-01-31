package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bnle;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NavigatorBarForMiniGame
  extends RelativeLayout
{
  private static final String TAG = "[minigame] NavigatorBarForMiniGame";
  private boolean hasInit;
  private ApkgInfo mApkgInfo;
  private int mBackGroundColor = -16777216;
  private String mBarStyle;
  private int mBarTextStyle = -1;
  private CapsuleButton mCapsuleButton;
  private RelativeLayout mContainer;
  
  public NavigatorBarForMiniGame(Context paramContext)
  {
    super(paramContext);
  }
  
  public NavigatorBarForMiniGame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigatorBarForMiniGame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void changeNavIcon()
  {
    if (this.mCapsuleButton != null) {
      this.mCapsuleButton.changeNavIcon(this.mBarTextStyle);
    }
  }
  
  private void init()
  {
    int i = 0;
    if ((getContext() != null) && (!this.hasInit))
    {
      this.mContainer = new RelativeLayout(getContext());
      localObject = new ViewGroup.LayoutParams(-1, -2);
      this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.mContainer.setClipChildren(false);
      this.mCapsuleButton = new CapsuleButton(getContext());
      this.mCapsuleButton.setId(2131364767);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      j = DisplayUtil.dip2px(getContext(), 9.0F);
      if (bnle.b()) {
        i = ImmersiveUtils.getStatusBarHeight(getContext());
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (i + j);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      this.mContainer.addView(this.mCapsuleButton, (ViewGroup.LayoutParams)localObject);
      addView(this.mContainer);
      this.mContainer.setBackgroundColor(this.mBackGroundColor);
      changeNavIcon();
      this.hasInit = true;
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      int j;
      return;
    }
    QLog.d("[minigame] NavigatorBarForMiniGame", 2, "[init] context null");
  }
  
  private void updateBarStyle()
  {
    if ("custom".equals(this.mBarStyle)) {
      setNavBackgroundColor(0);
    }
  }
  
  public CapsuleButton getCapsuleButton()
  {
    return this.mCapsuleButton;
  }
  
  public void requestLandscapeLayout()
  {
    ((RelativeLayout.LayoutParams)this.mCapsuleButton.getLayoutParams()).topMargin = DisplayUtil.dip2px(getContext(), 9.0F);
  }
  
  public void requestPortraitLayout()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mCapsuleButton.getLayoutParams();
    int j = DisplayUtil.dip2px(getContext(), 9.0F);
    if (bnle.b()) {}
    for (int i = ImmersiveUtils.getStatusBarHeight(getContext());; i = 0)
    {
      localLayoutParams.topMargin = (i + j);
      return;
    }
  }
  
  public void setApkgInfoAndInit(ApkgInfo paramApkgInfo)
  {
    this.mApkgInfo = paramApkgInfo;
    init();
  }
  
  public NavigatorBarForMiniGame setBarStyle(String paramString)
  {
    this.mBarStyle = paramString;
    updateBarStyle();
    return this;
  }
  
  public void setGameJsPluginEngine(GameJsPluginEngine paramGameJsPluginEngine, GameBrandRuntime paramGameBrandRuntime)
  {
    if ((this.mCapsuleButton != null) && (paramGameBrandRuntime != null)) {
      this.mCapsuleButton.attachGameBrandRuntime(paramGameBrandRuntime, paramGameJsPluginEngine);
    }
  }
  
  public NavigatorBarForMiniGame setNavBackgroundColor(int paramInt)
  {
    this.mBackGroundColor = paramInt;
    if (this.mContainer != null) {
      this.mContainer.setBackgroundColor(this.mBackGroundColor);
    }
    return this;
  }
  
  public NavigatorBarForMiniGame setTextStyle(String paramString)
  {
    com.tencent.mobileqq.mini.config.AppConst.CURRENT_NAV_BAR_STYLE_COLOR = paramString;
    if ("black".equals(paramString)) {
      this.mBarTextStyle = -16777216;
    }
    for (;;)
    {
      changeNavIcon();
      return this;
      if ("white".equals(paramString)) {
        this.mBarTextStyle = -1;
      }
    }
  }
  
  public NavigatorBarForMiniGame setWindowInfo(WindowInfo paramWindowInfo)
  {
    if (paramWindowInfo != null)
    {
      paramWindowInfo = paramWindowInfo.navigationBarInfo;
      if (paramWindowInfo != null)
      {
        if (!TextUtils.isEmpty(paramWindowInfo.textStyle)) {
          setTextStyle(paramWindowInfo.textStyle);
        }
        setNavBackgroundColor(paramWindowInfo.backgoundColor);
        if (!TextUtils.isEmpty(paramWindowInfo.style)) {
          setBarStyle(paramWindowInfo.style);
        }
      }
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.NavigatorBarForMiniGame
 * JD-Core Version:    0.7.0.1
 */