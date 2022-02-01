package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

public class CapsuleButton
  extends RelativeLayout
  implements Handler.Callback, View.OnClickListener, ICapsuleButton
{
  private static final String CAPSULE_CLOSE_DARK_URL = WnsConfig.getConfig("qqminiapp", "closebuttondark", null);
  private static final String CAPSULE_CLOSE_URL = WnsConfig.getConfig("qqminiapp", "closebutton", null);
  public static final String TAG = "CapsuleButton";
  private static int unReadCount = 0;
  private Drawable mCloseBtnBgDrawable;
  private Drawable mCloseBtnWhiteBgDrawable;
  private ImageView mCloseView;
  private CapsuleButton.CapsuleBtnClickListener mListener;
  private Drawable mMoreBtnBgDrawable;
  private Drawable mMoreBtnWhiteBgDrawable;
  private ImageView mMoreView;
  private TextView mRedDot;
  private View mSplider;
  
  public CapsuleButton(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  private ImageView createMoreView()
  {
    ImageView localImageView = ((KingCardProxy)AppLoaderFactory.g().getProxyManager().get(KingCardProxy.class)).getCapsuleButtonMoreView(getContext());
    if (localImageView == null)
    {
      localImageView = new ImageView(getContext());
      localImageView.setId(R.id.mini_sdk_capsule_btn_more_menu);
      localImageView.setContentDescription("更多");
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(dip2px(40.0F), dip2px(30.0F));
      localLayoutParams.addRule(9, -1);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      addView(localImageView, localLayoutParams);
      return (ImageView)findViewById(R.id.mini_sdk_capsule_btn_more_menu);
    }
    addView(localImageView);
    return localImageView;
  }
  
  private int dip2px(float paramFloat)
  {
    return DisplayUtil.dip2px(getContext(), paramFloat);
  }
  
  private View getContainerView()
  {
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setId(R.id.mini_sdk_capsule_btn_close_menu);
    ((ImageView)localObject).setContentDescription("关闭");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(dip2px(40.0F), dip2px(30.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, R.id.mini_sdk_capsule_btn_more_menu);
    ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    addView((View)localObject, localLayoutParams);
    localObject = new View(getContext());
    ((View)localObject).setId(R.id.mini_sdk_capsule_btn_line_split);
    localLayoutParams = new RelativeLayout.LayoutParams(dip2px(0.5F), dip2px(18.0F));
    localLayoutParams.addRule(13, -1);
    ((View)localObject).setBackgroundColor(436207616);
    addView((View)localObject, localLayoutParams);
    localObject = new TextView(getContext());
    ((TextView)localObject).setId(R.id.mini_sdk_capsule_btn_reddot);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, dip2px(19.0F));
    localLayoutParams.leftMargin = dip2px(21.5F);
    localLayoutParams.topMargin = dip2px(-9.5F);
    addView((View)localObject, localLayoutParams);
    return this;
  }
  
  private void initUI()
  {
    setClipChildren(false);
    this.mMoreView = createMoreView();
    getContainerView();
    this.mCloseView = ((ImageView)findViewById(R.id.mini_sdk_capsule_btn_close_menu));
    this.mRedDot = ((TextView)findViewById(R.id.mini_sdk_capsule_btn_reddot));
    this.mSplider = findViewById(R.id.mini_sdk_capsule_btn_line_split);
    this.mRedDot.setTextSize(12.0F);
    this.mRedDot.setTextColor(-1);
    this.mRedDot.setGravity(17);
    this.mRedDot.setIncludeFontPadding(false);
    this.mMoreView.setOnClickListener(this);
    this.mCloseView.setOnClickListener(this);
    this.mMoreBtnWhiteBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_more_white_bg);
    this.mCloseBtnWhiteBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_close_white_bg);
    this.mMoreBtnBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_more_bg);
    this.mCloseBtnBgDrawable = getResources().getDrawable(R.drawable.mini_sdk_top_btns_close_bg);
    if ((!TextUtils.isEmpty(CAPSULE_CLOSE_URL)) && (!TextUtils.isEmpty(CAPSULE_CLOSE_DARK_URL)))
    {
      MiniAppProxy localMiniAppProxy = (MiniAppProxy)AppLoaderFactory.g().getProxyManager().get(MiniAppProxy.class);
      this.mCloseBtnWhiteBgDrawable = localMiniAppProxy.getDrawable(getContext(), CAPSULE_CLOSE_DARK_URL, dip2px(40.0F), dip2px(30.0F), this.mCloseBtnWhiteBgDrawable);
      this.mCloseBtnBgDrawable = localMiniAppProxy.getDrawable(getContext(), CAPSULE_CLOSE_URL, dip2px(40.0F), dip2px(30.0F), this.mCloseBtnBgDrawable);
    }
  }
  
  public void changeNavIcon(int paramInt)
  {
    if (paramInt == -1)
    {
      this.mMoreView.setImageDrawable(this.mMoreBtnWhiteBgDrawable);
      this.mCloseView.setImageDrawable(this.mCloseBtnWhiteBgDrawable);
      this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      return;
    }
    this.mMoreView.setImageDrawable(this.mMoreBtnBgDrawable);
    this.mCloseView.setImageDrawable(this.mCloseBtnBgDrawable);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
  
  public ImageView getMoreView()
  {
    return this.mMoreView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return false;
    }
    int i = paramMessage.what;
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.mMoreView) {
      if (this.mListener != null) {
        this.mListener.onMoreClick();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == this.mCloseView) && (this.mListener != null)) {
        this.mListener.onCloseClick();
      }
    }
  }
  
  public CapsuleButton setListener(CapsuleButton.CapsuleBtnClickListener paramCapsuleBtnClickListener)
  {
    this.mListener = paramCapsuleBtnClickListener;
    return this;
  }
  
  public void setUnReadCount(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      unReadCount = paramInt;
      if (QMLog.isColorLevel()) {
        QMLog.d("CapsuleButton", "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
      }
    }
    unReadCount = paramInt;
    if (QMLog.isColorLevel()) {
      QMLog.d("CapsuleButton", "forceUpdate : " + paramBoolean + "; setUnReadCount : " + paramInt);
    }
    updateRedDotVisible();
  }
  
  public void updateRedDotVisible()
  {
    AppBrandTask.runTaskOnUiThread(new CapsuleButton.1(this));
  }
  
  public void updateStyle(int paramInt)
  {
    if ((this.mMoreView != null) && (this.mCloseView != null) && (this.mSplider != null))
    {
      if (paramInt == -1)
      {
        this.mMoreView.setImageResource(R.drawable.mini_sdk_top_btns_more_white_bg);
        this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_white_bg);
        this.mSplider.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
      }
    }
    else {
      return;
    }
    this.mMoreView.setImageResource(R.drawable.mini_sdk_top_btns_more_bg);
    this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_bg);
    this.mSplider.setBackgroundColor(Color.parseColor("#1A000000"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CapsuleButton
 * JD-Core Version:    0.7.0.1
 */