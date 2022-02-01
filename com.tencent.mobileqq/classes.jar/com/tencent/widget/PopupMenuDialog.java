package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PopupMenuDialog
  extends BasePopupMenuDialog
  implements View.OnClickListener, Animation.AnimationListener
{
  private static final String TAG = "PopupMenuDialog";
  private Activity activity;
  private View mDimView;
  private WindowManager.LayoutParams mDimViewLp;
  private PopupMenuDialog.MenuItem mLastClkItem = null;
  private int mMaxAvailableHeight = 0;
  private boolean mNeedLine = false;
  public boolean mNeedRebuild = false;
  private PopupMenuDialog.OnClickActionListener mOnClickActionListener;
  private PopupMenuDialog.OnDismissListener mOnDismissListener;
  private Animation mOutAnimation;
  private int mTotalPopHeight = 0;
  
  private PopupMenuDialog(Activity paramActivity, View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramView, paramInt1, paramInt2, paramBoolean);
    this.activity = paramActivity;
    initDimView();
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList)
  {
    return build(paramActivity, paramList, null, null);
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener)
  {
    return build(paramActivity, paramList, paramOnClickActionListener, null);
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    return build(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, 0);
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt)
  {
    return build(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, paramInt, false);
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt, boolean paramBoolean)
  {
    return build(paramActivity, paramList, paramOnClickActionListener, paramOnDismissListener, paramInt, paramBoolean, -1, 2131951650);
  }
  
  public static PopupMenuDialog build(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int j = getDesiredHeight(paramActivity, paramList.size(), paramBoolean);
      int i = paramInt1;
      if (paramInt1 <= 0) {
        i = getScaledPixelSize(paramActivity, 2131299624);
      }
      paramActivity = new PopupMenuDialog(paramActivity, prepareContent(paramActivity, paramList, paramBoolean, paramInt2), i, j, true);
      paramActivity.setAnimationStyle(paramInt3);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      if (Build.VERSION.SDK_INT >= 9) {
        setWindowType(paramActivity, 1002);
      }
      if (AppSetting.e) {
        setModeTouch(paramActivity);
      }
      paramActivity.initListeners(paramActivity.getContentView());
      paramActivity.mTotalPopHeight = j;
      paramActivity.mOnClickActionListener = paramOnClickActionListener;
      paramActivity.mOnDismissListener = paramOnDismissListener;
      paramActivity.mNeedLine = paramBoolean;
      return paramActivity;
    }
    throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
  }
  
  public static PopupMenuDialog conversationPlusBuild(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, PopupMenuDialog.OnClickActionListener paramOnClickActionListener, PopupMenuDialog.OnDismissListener paramOnDismissListener)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int j = get800UIDesiredHeight(paramActivity, paramList.size());
      int i;
      if (LocaleManager.a()) {
        i = getScaledPixelSize(paramActivity, 2131299619);
      } else {
        i = getScaledPixelSize(paramActivity, 2131299618);
      }
      paramActivity = new PopupMenuDialog(paramActivity, prepareConversationPlusContent(paramActivity, paramList), i, j, true);
      paramActivity.setAnimationStyle(2131951650);
      paramActivity.setBackgroundDrawable(new ColorDrawable(0));
      paramActivity.setOutsideTouchable(false);
      setWindowType(paramActivity, 1002);
      if (AppSetting.e) {
        setModeTouch(paramActivity);
      }
      paramActivity.initListeners(paramActivity.getContentView());
      paramActivity.mTotalPopHeight = j;
      paramActivity.mOnClickActionListener = paramOnClickActionListener;
      paramActivity.mOnDismissListener = paramOnDismissListener;
      paramActivity.mNeedLine = false;
      return paramActivity;
    }
    throw new IllegalArgumentException("parameter items can not be null or zero-length array.");
  }
  
  private static void createAndAttachItemsView(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, LinearLayout paramLinearLayout)
  {
    createAndAttachItemsView(paramActivity, paramList, paramLinearLayout, false);
  }
  
  private static void createAndAttachItemsView(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, LinearLayout paramLinearLayout, boolean paramBoolean)
  {
    int i = 0;
    while (i < paramList.size())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.get(i);
      LinearLayout.LayoutParams localLayoutParams;
      Object localObject1;
      if (i == 0)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, dp2px(62.0F, paramActivity.getResources()));
        localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131629175, null);
      }
      else
      {
        int k = paramList.size();
        int j = 2131629174;
        if (i == k - 1)
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, dp2px(62.0F, paramActivity.getResources()));
          localObject1 = LayoutInflater.from(paramActivity);
          if (!paramBoolean) {
            j = 2131629173;
          }
          localObject1 = (LinearLayout)((LayoutInflater)localObject1).inflate(j, null);
        }
        else
        {
          localLayoutParams = new LinearLayout.LayoutParams(-1, dp2px(52.0F, paramActivity.getResources()));
          localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131629174, null);
        }
      }
      Object localObject2 = (ImageView)((LinearLayout)localObject1).findViewById(2131435627);
      TextView localTextView = (TextView)((LinearLayout)localObject1).findViewById(2131447262);
      if (localMenuItem.netDrawable != null) {
        ((ImageView)localObject2).setImageDrawable(localMenuItem.netDrawable);
      } else if (localMenuItem.danceDrawable != null) {
        ((ImageView)localObject2).setImageDrawable(localMenuItem.danceDrawable);
      } else if (localMenuItem.drawable != null) {
        ((ImageView)localObject2).setImageDrawable(localMenuItem.drawable);
      } else {
        ((ImageView)localObject2).setImageResource(localMenuItem.iconId);
      }
      if ((localMenuItem.iconId == 0) && (localMenuItem.drawable == null))
      {
        ((ImageView)localObject2).setVisibility(8);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      }
      localTextView.setText(localMenuItem.title);
      if (!TextUtils.isEmpty(localMenuItem.titleColor)) {
        localTextView.setTextColor(Color.parseColor(localMenuItem.titleColor));
      }
      if (localMenuItem.titleSize > 0.0F) {
        localTextView.setTextSize(localMenuItem.titleSize);
      }
      if (!TextUtils.isEmpty(localMenuItem.contentDescription))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localMenuItem.contentDescription);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131906119));
        ((LinearLayout)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localMenuItem.title);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131906117));
        ((LinearLayout)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      }
      ((LinearLayout)localObject1).setTag(localMenuItem);
      if (localMenuItem.id > 0) {
        ((LinearLayout)localObject1).setId(localMenuItem.id);
      }
      paramLinearLayout.addView((View)localObject1, localLayoutParams);
      i += 1;
    }
  }
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static int get800UIDesiredHeight(Context paramContext, int paramInt)
  {
    int i = paramInt - 2;
    if (i > 0) {
      paramInt = i * dp2px(52.0F, paramContext.getResources()) + dp2px(62.0F, paramContext.getResources()) * 2;
    } else {
      paramInt = dp2px(62.0F, paramContext.getResources()) * paramInt;
    }
    return paramInt + getScaledPixelSize(paramContext, 2131299623);
  }
  
  private static int getDesiredHeight(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int j = getScaledPixelSize(paramContext, 2131299625) * paramInt + getScaledPixelSize(paramContext, 2131299623);
    int i = j;
    if (paramBoolean) {
      i = j + (paramInt - 1) * 1;
    }
    return i;
  }
  
  private void initDimView()
  {
    Object localObject;
    int i;
    if (this.mDimViewLp == null)
    {
      this.mDimViewLp = new WindowManager.LayoutParams();
      localObject = this.mDimViewLp;
      ((WindowManager.LayoutParams)localObject).type = 1000;
      ((WindowManager.LayoutParams)localObject).format = -3;
      ((WindowManager.LayoutParams)localObject).flags = 40;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        localObject = this.mDimViewLp;
        ((WindowManager.LayoutParams)localObject).flags |= 0x4000000;
      }
      localObject = this.mDimViewLp;
      int j = -1;
      ((WindowManager.LayoutParams)localObject).width = -1;
      i = j;
      if (this.activity.getWindow() != null)
      {
        i = j;
        if (this.activity.getWindow().getDecorView() != null)
        {
          i = this.activity.getWindow().getDecorView().getHeight();
          if (i <= 0) {
            i = j;
          }
        }
      }
      localObject = this.mDimViewLp;
      ((WindowManager.LayoutParams)localObject).height = i;
      ((WindowManager.LayoutParams)localObject).windowAnimations = 2131952300;
    }
    if (this.mDimView == null)
    {
      this.mDimView = new View(this.activity);
      localObject = this.mDimView;
      Resources localResources = this.activity.getResources();
      if (QQTheme.isNowThemeIsNight()) {
        i = 2131165805;
      } else {
        i = 2131165797;
      }
      ((View)localObject).setBackgroundColor(localResources.getColor(i));
      this.mDimView.setContentDescription(HardCodeUtil.a(2131906118));
      this.mDimView.setOnClickListener(new PopupMenuDialog.1(this));
    }
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 14)) {
      getContentView().setAccessibilityDelegate(new PopupMenuDialog.2(this));
    }
  }
  
  private void initListeners(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof PopupMenuDialog.MenuItem))) {
      paramView.setOnClickListener(this);
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        initListeners(paramView.getChildAt(i));
        i += 1;
      }
    }
  }
  
  private static View prepareContent(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList, boolean paramBoolean, int paramInt)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131629179, null);
    Object localObject1 = (BounceScrollView)localView.findViewById(2131429717);
    if (paramInt != -1) {
      ((BounceScrollView)localObject1).setBackgroundResource(paramInt);
    }
    LinearLayout localLinearLayout = (LinearLayout)((BounceScrollView)localObject1).findViewById(2131431322);
    ((BounceScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((BounceScrollView)localObject1).mScrollFlag = 1;
    new LinearLayout.LayoutParams(-1, 1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, getScaledPixelSize(paramActivity, 2131299625));
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      PopupMenuDialog.MenuItem localMenuItem = (PopupMenuDialog.MenuItem)paramList.get(paramInt);
      if (paramInt == 0) {
        localObject1 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131629178, null);
      }
      do
      {
        localObject2 = null;
        break label232;
        if (paramInt != paramList.size() - 1) {
          break;
        }
        localObject2 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131629176, null);
        localObject1 = localObject2;
      } while (!paramBoolean);
      Object localObject3 = createLineView(paramActivity);
      localObject1 = localObject2;
      Object localObject2 = localObject3;
      break label232;
      if (paramBoolean) {
        localObject1 = createLineView(paramActivity);
      } else {
        localObject1 = null;
      }
      localObject3 = (LinearLayout)LayoutInflater.from(paramActivity).inflate(2131629177, null);
      localObject2 = localObject1;
      localObject1 = localObject3;
      label232:
      localObject3 = (ImageView)((LinearLayout)localObject1).findViewById(2131435627);
      TextView localTextView = (TextView)((LinearLayout)localObject1).findViewById(2131447262);
      if (localMenuItem.netDrawable != null) {
        ((ImageView)localObject3).setImageDrawable(localMenuItem.netDrawable);
      } else if (localMenuItem.danceDrawable != null) {
        ((ImageView)localObject3).setImageDrawable(localMenuItem.danceDrawable);
      } else if (localMenuItem.drawable != null) {
        ((ImageView)localObject3).setImageDrawable(localMenuItem.drawable);
      } else {
        ((ImageView)localObject3).setImageResource(localMenuItem.iconId);
      }
      if ((localMenuItem.iconId == 0) && (localMenuItem.drawable == null))
      {
        ((ImageView)localObject3).setVisibility(8);
        ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
      }
      localTextView.setText(localMenuItem.title);
      if (!TextUtils.isEmpty(localMenuItem.titleColor)) {
        localTextView.setTextColor(Color.parseColor(localMenuItem.titleColor));
      }
      if (localMenuItem.titleSize > 0.0F) {
        localTextView.setTextSize(localMenuItem.titleSize);
      }
      if (!TextUtils.isEmpty(localMenuItem.contentDescription))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localMenuItem.contentDescription);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131906120));
        ((LinearLayout)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localMenuItem.title);
        ((StringBuilder)localObject3).append(HardCodeUtil.a(2131906116));
        ((LinearLayout)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
      }
      if (localObject2 != null) {
        localLinearLayout.addView((View)localObject2);
      }
      ((LinearLayout)localObject1).setTag(localMenuItem);
      if (localMenuItem.id > 0) {
        ((LinearLayout)localObject1).setId(localMenuItem.id);
      }
      localLinearLayout.addView((View)localObject1, localLayoutParams);
      paramInt += 1;
    }
    return localView;
  }
  
  private static View prepareConversationPlusContent(Activity paramActivity, List<PopupMenuDialog.MenuItem> paramList)
  {
    View localView = LayoutInflater.from(paramActivity).inflate(2131629179, null);
    BounceScrollView localBounceScrollView = (BounceScrollView)localView.findViewById(2131429717);
    localBounceScrollView.setVerticalScrollBarEnabled(false);
    localBounceScrollView.mScrollFlag = 1;
    createAndAttachItemsView(paramActivity, paramList, (LinearLayout)localBounceScrollView.findViewById(2131431322));
    return localView;
  }
  
  public void dismiss()
  {
    try
    {
      if (LiuHaiUtils.b(this.activity)) {
        ((ViewGroup)this.activity.getWindow().getDecorView()).removeView(this.mDimView);
      } else {
        this.activity.getWindowManager().removeView(this.mDimView);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMenuDialog", 2, localException.toString());
      }
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.dismiss();
      localObject = this.mOnClickActionListener;
      if (localObject != null)
      {
        PopupMenuDialog.MenuItem localMenuItem = this.mLastClkItem;
        if (localMenuItem != null) {
          ((PopupMenuDialog.OnClickActionListener)localObject).onClickAction(localMenuItem);
        }
      }
      this.mLastClkItem = null;
      localObject = this.mOnDismissListener;
      if (localObject != null) {
        ((PopupMenuDialog.OnDismissListener)localObject).onDismiss();
      }
    }
    else if (isShowing())
    {
      localObject = this.mOutAnimation;
      if ((localObject != null) && (!((Animation)localObject).hasEnded())) {
        return;
      }
      if (this.mOutAnimation == null)
      {
        this.mOutAnimation = AnimationUtils.loadAnimation(this.activity, 2130772464);
        this.mOutAnimation.setAnimationListener(this);
      }
      getContentView().startAnimation(this.mOutAnimation);
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationEnd");
    }
    paramAnimation = this.mOnClickActionListener;
    if (paramAnimation != null)
    {
      PopupMenuDialog.MenuItem localMenuItem = this.mLastClkItem;
      if (localMenuItem != null) {
        paramAnimation.onClickAction(localMenuItem);
      }
    }
    this.mLastClkItem = null;
    paramAnimation = this.mOnDismissListener;
    if (paramAnimation != null) {
      paramAnimation.onDismiss();
    }
    super.dismiss();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PopupMenuDialog", 2, "onAnimationStart");
    }
  }
  
  public void onClick(View paramView)
  {
    this.mLastClkItem = ((PopupMenuDialog.MenuItem)paramView.getTag());
    dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPause()
  {
    if ((Build.VERSION.SDK_INT < 9) && (isShowing())) {
      dismiss();
    }
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int j = getMaxAvailableHeight(paramView, paramInt2);
    if (j != this.mMaxAvailableHeight)
    {
      int i = 0;
      if (j < this.mTotalPopHeight) {
        i = (1 - getScaledPixelSize(this.activity, 2131299623) + j) / (getScaledPixelSize(this.activity, 2131299625) + 1);
      }
      if (i > 0) {
        setHeight(getDesiredHeight(this.activity, i, this.mNeedLine));
      } else {
        setHeight(this.mTotalPopHeight);
      }
      this.mMaxAvailableHeight = j;
    }
    try
    {
      if (LiuHaiUtils.b(this.activity)) {
        ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.mDimView, this.mDimViewLp);
      } else {
        this.activity.getWindowManager().addView(this.mDimView, this.mDimViewLp);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMenuDialog", 2, localException.toString());
      }
    }
    super.showAsDropDown(paramView, paramInt1, paramInt2);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (LiuHaiUtils.b(this.activity)) {
        ((ViewGroup)this.activity.getWindow().getDecorView()).addView(this.mDimView, this.mDimViewLp);
      } else {
        this.activity.getWindowManager().addView(this.mDimView, this.mDimViewLp);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PopupMenuDialog", 2, localException.toString());
      }
    }
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PopupMenuDialog
 * JD-Core Version:    0.7.0.1
 */