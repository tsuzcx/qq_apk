package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmini.minigame.R.id;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;

public class GameNavigationBar
  extends RelativeLayout
{
  private static final String TAG = "GameNavigationBar";
  private boolean hasInit = false;
  private int mBackGroundColor = -16777216;
  private String mBarStyle;
  private int mBarTextStyle = -1;
  private CapsuleButton mCapsuleButton;
  private RelativeLayout mContainer;
  
  public GameNavigationBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameNavigationBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void changeNavIcon()
  {
    CapsuleButton localCapsuleButton = this.mCapsuleButton;
    if (localCapsuleButton != null) {
      localCapsuleButton.changeNavIcon(this.mBarTextStyle);
    }
  }
  
  private void init()
  {
    if ((getContext() != null) && (!this.hasInit))
    {
      this.mContainer = new RelativeLayout(getContext());
      Object localObject = new ViewGroup.LayoutParams(-1, -2);
      this.mContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.mContainer;
      int i = 0;
      ((RelativeLayout)localObject).setClipChildren(false);
      this.mCapsuleButton = new CapsuleButton(getContext());
      this.mCapsuleButton.setId(R.id.container_top_btns);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0F), DisplayUtil.dip2px(getContext(), 30.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(11, -1);
      int j = DisplayUtil.dip2px(getContext(), 9.0F);
      if (LiuHaiUtils.isLiuHaiUseValid()) {
        i = DisplayUtil.getStatusBarHeight(getContext());
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = (j + i);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = DisplayUtil.dip2px(getContext(), 12.5F);
      this.mContainer.addView(this.mCapsuleButton, (ViewGroup.LayoutParams)localObject);
      addView(this.mContainer);
      this.mContainer.setBackgroundColor(this.mBackGroundColor);
      changeNavIcon();
      this.hasInit = true;
      return;
    }
    if (QMLog.isColorLevel()) {
      QMLog.d("GameNavigationBar", "[init] context null");
    }
  }
  
  private void updateBarStyle()
  {
    if ("custom".equals(this.mBarStyle)) {
      setNavBackgroundColor(0);
    }
  }
  
  public void attachMiniAppContext(IMiniAppContext paramIMiniAppContext)
  {
    paramIMiniAppContext = new GameCapsuleButtonClickListener(paramIMiniAppContext);
    this.mCapsuleButton.setListener(paramIMiniAppContext);
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
    int i;
    if (LiuHaiUtils.isLiuHaiUseValid()) {
      i = DisplayUtil.getStatusBarHeight(getContext());
    } else {
      i = 0;
    }
    localLayoutParams.topMargin = (j + i);
  }
  
  public GameNavigationBar setBarStyle(String paramString)
  {
    this.mBarStyle = paramString;
    updateBarStyle();
    return this;
  }
  
  public GameNavigationBar setNavBackgroundColor(int paramInt)
  {
    this.mBackGroundColor = paramInt;
    RelativeLayout localRelativeLayout = this.mContainer;
    if (localRelativeLayout != null) {
      localRelativeLayout.setBackgroundColor(this.mBackGroundColor);
    }
    return this;
  }
  
  public GameNavigationBar setTextStyle(String paramString)
  {
    if ("black".equals(paramString)) {
      this.mBarTextStyle = -16777216;
    } else if ("white".equals(paramString)) {
      this.mBarTextStyle = -1;
    }
    changeNavIcon();
    return this;
  }
  
  public GameNavigationBar setWindowInfo(WindowInfo paramWindowInfo)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.widget.GameNavigationBar
 * JD-Core Version:    0.7.0.1
 */