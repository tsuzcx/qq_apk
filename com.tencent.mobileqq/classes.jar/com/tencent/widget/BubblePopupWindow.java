package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class BubblePopupWindow
  implements View.OnClickListener
{
  private static final int[] ABOVE_ANCHOR_STATE_SET = { 16842922 };
  public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
  public static final int INPUT_METHOD_NEEDED = 1;
  public static final int INPUT_METHOD_NOT_NEEDED = 2;
  private static final String TAG = "BubblePopupWindow";
  private FrameLayout framelayout;
  private boolean mAboveAnchor;
  private ImageView mAboveArrow;
  private boolean mAllowScrollingAnchorParent = true;
  private WeakReference<View> mAnchor;
  private int mAnchorOffset = 0;
  private int mAnchorXoff;
  private int mAnchorYoff;
  private int mAnimationStyle = -1;
  private Drawable mBackground;
  private ImageView mBottomArrow;
  private boolean mClipToScreen = true;
  private boolean mClippingEnabled = true;
  private int mContainerCenterX;
  private View mContentView;
  private Context mContext;
  private int[] mDrawingLocation = new int[2];
  private boolean mFocusable;
  private int mHeight;
  private int mHeightMode;
  private boolean mIgnoreCheekPress = false;
  private int mInputMethodMode = 0;
  private boolean mIsDropdown;
  private boolean mIsShowing;
  private boolean mKeepAbove = false;
  private int mLastHeight;
  private int mLastWidth;
  private boolean mLayoutInScreen;
  private boolean mLayoutInsetDecor = false;
  private boolean mNotTouchModal;
  private BubblePopupWindow.OnDismissListener mOnDismissListener;
  private BubblePopupWindow.OnKeyBackListener mOnKeybackListener;
  private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener = new BubblePopupWindow.1(this);
  private boolean mOutsideTouchable = false;
  private int mPopupHeight;
  private View mPopupView;
  private int mPopupWidth;
  private BubblePopupWindow.MyClipDrawable mPressedAboveArrow;
  private BubblePopupWindow.MyClipDrawable mPressedBackground;
  private BubblePopupWindow.MyClipDrawable mPressedBottomArrow;
  private BubblePopupWindow.QQMenuNoIconEmptyInterface mQQMenuNoIconEmptyInterface;
  private int[] mScreenLocation = new int[2];
  private int mSoftInputMode = 1;
  private int mSplitTouchEnabled = -1;
  private Rect mTempRect = new Rect();
  private View.OnTouchListener mTouchInterceptor;
  private boolean mTouchable = true;
  private int mWidth;
  private int mWidthMode;
  private int mWindowLayoutType = 1000;
  private WindowManager mWindowManager;
  
  public BubblePopupWindow()
  {
    this(null, 0, 0);
  }
  
  public BubblePopupWindow(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public BubblePopupWindow(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842870);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public BubblePopupWindow(View paramView)
  {
    this(paramView, 0, 0);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    this(paramView, paramInt1, paramInt2, false);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.mContext = paramView.getContext();
      this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    }
    setContentView(paramView);
    setWidth(paramInt1);
    setHeight(paramInt2);
    setFocusable(paramBoolean);
  }
  
  private int computeAnimationResource()
  {
    int j = this.mAnimationStyle;
    int i = j;
    if (j == -1)
    {
      if (this.mIsDropdown)
      {
        if (this.mAboveAnchor) {
          return 2131755345;
        }
        return 2131755344;
      }
      i = 0;
    }
    return i;
  }
  
  private int computeFlags(int paramInt)
  {
    paramInt &= 0xFF797DE7;
    int i = paramInt;
    if (this.mIgnoreCheekPress) {
      i = paramInt | 0x8000;
    }
    if (!this.mFocusable)
    {
      i |= 0x8;
      paramInt = i;
      if (this.mInputMethodMode != 1) {
        break label62;
      }
    }
    else
    {
      paramInt = i;
      if (this.mInputMethodMode != 2) {
        break label62;
      }
    }
    paramInt = i | 0x20000;
    label62:
    i = paramInt;
    if (!this.mTouchable) {
      i = paramInt | 0x10;
    }
    paramInt = i;
    if (this.mOutsideTouchable) {
      paramInt = i | 0x40000;
    }
    i = paramInt;
    if (!this.mClippingEnabled) {
      i = paramInt | 0x200;
    }
    paramInt = i;
    if (isSplitTouchEnabled()) {
      paramInt = i | 0x800000;
    }
    i = paramInt;
    if (this.mLayoutInScreen) {
      i = paramInt | 0x100;
    }
    paramInt = i;
    if (this.mLayoutInsetDecor) {
      paramInt = i | 0x10000;
    }
    i = paramInt;
    if (this.mNotTouchModal) {
      i = paramInt | 0x20;
    }
    return i;
  }
  
  private WindowManager.LayoutParams createPopupLayout(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 51;
    int i = this.mWidth;
    this.mLastWidth = i;
    localLayoutParams.width = i;
    i = this.mHeight;
    this.mLastHeight = i;
    localLayoutParams.height = i;
    Drawable localDrawable = this.mBackground;
    if (localDrawable != null) {
      localLayoutParams.format = localDrawable.getOpacity();
    } else {
      localLayoutParams.format = -3;
    }
    localLayoutParams.flags = computeFlags(localLayoutParams.flags);
    localLayoutParams.type = this.mWindowLayoutType;
    localLayoutParams.token = paramIBinder;
    localLayoutParams.softInputMode = this.mSoftInputMode;
    localLayoutParams.setTitle("PopupWindow");
    return localLayoutParams;
  }
  
  private void findAbovePosition(WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, View paramView)
  {
    Object localObject = paramView.getRootView();
    paramLayoutParams.x = paramInt1;
    paramLayoutParams.y = paramInt2;
    boolean bool;
    if (this.mKeepAbove)
    {
      paramLayoutParams.gravity = 51;
      bool = false;
    }
    else
    {
      paramLayoutParams.gravity = 83;
      bool = true;
    }
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int i = this.mPopupWidth;
    int m = this.mPopupHeight;
    int j;
    int k;
    if (i != -2)
    {
      j = i;
      k = m;
      if (m != -2) {}
    }
    else
    {
      this.mPopupView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.mPopupWidth == -2) {
        i = this.mPopupView.getMeasuredWidth();
      }
      j = i;
      k = m;
      if (this.mPopupHeight == -2)
      {
        k = this.mPopupView.getMeasuredHeight();
        j = i;
      }
    }
    if (j > 0) {
      paramLayoutParams.x = (paramInt1 - j / 2);
    }
    i = localRect.top;
    if (this.mAnchorOffset > 0) {
      i = 0;
    }
    if (!this.mKeepAbove)
    {
      m = paramInt2 - k;
      if (((m < i) || (paramInt1 + j - ((View)localObject).getWidth() > 0)) && (m < i))
      {
        paramLayoutParams.gravity = 51;
        bool = false;
      }
    }
    if (this.mClipToScreen)
    {
      i = localRect.right - localRect.left;
      m = paramLayoutParams.x + j;
      if (m > i) {
        paramLayoutParams.x -= m - i;
      }
      if (paramLayoutParams.x < localRect.left)
      {
        paramLayoutParams.x = localRect.left;
        paramLayoutParams.width = Math.min(paramLayoutParams.width, i);
      }
      if (bool)
      {
        paramInt2 -= this.mPopupHeight;
        if (paramInt2 < 0) {
          paramLayoutParams.y += paramInt2;
        }
      }
      else
      {
        paramLayoutParams.y = Math.max(paramLayoutParams.y + this.mAnchorOffset, localRect.top);
      }
      paramLayoutParams.gravity |= 0x10000000;
    }
    if (bool) {
      paramLayoutParams.y = (((View)localObject).getHeight() - paramLayoutParams.y);
    }
    View localView = this.mContentView;
    if (((localView instanceof QQCustomMenuNoIconLayout)) && (((QQCustomMenuNoIconLayout)localView).b())) {
      layoutMenuContainer(paramLayoutParams, paramView, (View)localObject, bool, j, k, localRect, ((QQCustomMenuNoIconLayout)this.mContentView).a());
    } else {
      updateAboveAnchor(bool, paramInt1 - paramLayoutParams.x);
    }
    if ((Build.VERSION.SDK_INT >= 24) && ((paramView.getContext() instanceof Activity)) && (((Activity)paramView.getContext()).isInMultiWindowMode()))
    {
      localObject = new int[2];
      ((Activity)paramView.getContext()).getWindow().getDecorView().getLocationOnScreen((int[])localObject);
      if (localObject[1] > 10) {
        paramLayoutParams.y += localObject[1];
      }
      if (localObject[0] > 10) {
        paramLayoutParams.x -= localObject[0];
      }
    }
  }
  
  private boolean findAbovePosition(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramView.getLocationInWindow(this.mDrawingLocation);
    View localView = paramView.getRootView();
    Object localObject = this.mDrawingLocation;
    paramLayoutParams.x = (localObject[0] + paramInt1);
    paramLayoutParams.y = (localObject[1] + paramInt2);
    paramLayoutParams.gravity = 83;
    paramView.getLocationOnScreen(this.mScreenLocation);
    localObject = new Rect();
    paramView.getWindowVisibleDisplayFrame((Rect)localObject);
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    int i = this.mPopupWidth;
    int m = this.mPopupHeight;
    int k;
    if (i != -2)
    {
      j = i;
      k = m;
      if (m != -2) {}
    }
    else
    {
      this.mPopupView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.mPopupWidth == -2) {
        i = this.mPopupView.getMeasuredWidth();
      }
      j = i;
      k = m;
      if (this.mPopupHeight == -2)
      {
        k = this.mPopupView.getMeasuredHeight();
        j = i;
      }
    }
    if (j > 0) {
      paramLayoutParams.x = (this.mScreenLocation[0] + paramView.getWidth() / 2 - j / 2 + paramInt1);
    }
    boolean bool;
    if ((this.mScreenLocation[1] + paramInt2 - k < ((Rect)localObject).top) || (paramLayoutParams.x + j - localView.getWidth() > 0))
    {
      if (this.mAllowScrollingAnchorParent)
      {
        i = paramView.getScrollX();
        m = paramView.getScrollY();
        paramView.requestRectangleOnScreen(new Rect(i, m, i + j + paramInt1, m + k + paramView.getHeight() + paramInt2), true);
        paramView.getLocationInWindow(this.mDrawingLocation);
        if (j > 0) {
          paramLayoutParams.x = (this.mDrawingLocation[0] + paramView.getWidth() / 2 - j / 2 + paramInt1);
        } else {
          paramLayoutParams.x = (this.mDrawingLocation[0] + paramInt1);
        }
        paramLayoutParams.y = (this.mDrawingLocation[1] + paramInt2);
        paramView.getLocationOnScreen(this.mScreenLocation);
      }
      if (this.mScreenLocation[1] + paramInt2 - k < ((Rect)localObject).top)
      {
        if (k + localRect.bottom + paramInt2 > ((Rect)localObject).bottom)
        {
          paramLayoutParams.y = (localRect.top + localRect.height() / 2 + paramInt2);
          bool = true;
          i = 1;
          break label496;
        }
        paramLayoutParams.y = (this.mDrawingLocation[1] + paramView.getHeight() + paramInt2);
        paramLayoutParams.gravity = 51;
        bool = false;
      }
      else
      {
        paramLayoutParams.y = (this.mDrawingLocation[1] + paramInt2);
      }
    }
    else
    {
      bool = true;
    }
    i = 0;
    label496:
    if (this.mClipToScreen)
    {
      k = ((Rect)localObject).right - ((Rect)localObject).left;
      j = paramLayoutParams.x + j;
      if (j > k) {
        paramLayoutParams.x -= j - k;
      }
      if (paramLayoutParams.x < ((Rect)localObject).left)
      {
        paramLayoutParams.x = ((Rect)localObject).left;
        paramLayoutParams.width = Math.min(paramLayoutParams.width, k);
      }
      if ((bool) && (i == 0))
      {
        paramInt2 = this.mScreenLocation[1] + paramInt2 - this.mPopupHeight;
        if (paramInt2 < 0) {
          paramLayoutParams.y += paramInt2;
        }
      }
      else
      {
        paramLayoutParams.y = Math.max(paramLayoutParams.y, ((Rect)localObject).top);
      }
      paramLayoutParams.gravity |= 0x10000000;
    }
    if ((bool) && (i == 0)) {
      paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
    }
    paramInt2 = this.mScreenLocation[0];
    i = paramView.getWidth() / 2;
    int j = paramLayoutParams.x;
    if (bool)
    {
      k = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
      paramLayoutParams.y -= k;
    }
    else
    {
      k = Math.round(TypedValue.applyDimension(1, 3.0F, this.mContext.getResources().getDisplayMetrics()));
      paramLayoutParams.y -= k;
    }
    updateAboveAnchor(bool, paramInt2 + i + paramInt1 - j);
    return bool;
  }
  
  @TargetApi(14)
  private void invokePopup(WindowManager.LayoutParams paramLayoutParams)
  {
    Context localContext = this.mContext;
    if (localContext != null) {
      paramLayoutParams.packageName = localContext.getPackageName();
    }
    if (VersionUtils.d()) {
      this.mPopupView.setFitsSystemWindows(this.mLayoutInsetDecor);
    }
    if (this.mPopupView.getParent() == null) {
      this.mWindowManager.addView(this.mPopupView, paramLayoutParams);
    }
  }
  
  private void layoutMenuContainer(WindowManager.LayoutParams paramLayoutParams, View paramView1, View paramView2, boolean paramBoolean, int paramInt1, int paramInt2, Rect paramRect, Integer paramInteger)
  {
    boolean bool = ((QQCustomMenuNoIconLayout)this.mContentView).a();
    int[] arrayOfInt = new int[2];
    paramView1.getLocationInWindow(arrayOfInt);
    if ((paramBoolean) && (arrayOfInt[1] - paramInt2 < paramRect.top))
    {
      paramLayoutParams.gravity = 51;
      paramBoolean = false;
    }
    if ((paramInteger != null) && (!paramBoolean) && (arrayOfInt[1] + paramView1.getHeight() + paramInt2 > paramInteger.intValue()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[menu] layoutMenuContainerX handle long view! Bottom: ");
      localStringBuilder.append(arrayOfInt[1] + paramView1.getHeight() + paramInt2);
      localStringBuilder.append(" containerBottom: ");
      localStringBuilder.append(paramInteger);
      QLog.d("BubblePopupWindow", 2, localStringBuilder.toString());
      paramLayoutParams.y = (paramInteger.intValue() - paramInt2);
    }
    else
    {
      int i;
      if (paramBoolean) {
        i = paramView2.getHeight() - arrayOfInt[1];
      } else {
        i = arrayOfInt[1] + paramView1.getHeight();
      }
      paramLayoutParams.y = i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, new Object[] { "[menu] layoutMenuContainerY ViewY: ", Integer.valueOf(arrayOfInt[1]), " ViewB: ", Integer.valueOf(arrayOfInt[1] + paramView1.getBottom()), " ViewT: ", Integer.valueOf(paramView1.getTop()), " ViewH: ", Integer.valueOf(paramView1.getHeight()), " ContainerBottom: ", paramInteger, " displayFrame: ", paramRect, " screenH: ", Integer.valueOf(ViewUtils.b()), " screenW: ", Integer.valueOf(ViewUtils.a()), " onTop: ", Boolean.valueOf(paramBoolean), " popupH: ", Integer.valueOf(paramInt2), " ParamY: ", Integer.valueOf(paramLayoutParams.y), " ViewH: ", Integer.valueOf(paramView1.getHeight()), " RootH: ", Integer.valueOf(paramView2.getHeight()) });
    }
    this.mContainerCenterX = (arrayOfInt[0] + paramView1.getWidth() / 2);
    layoutMenuContainerX(paramLayoutParams, this.mContainerCenterX, bool, paramBoolean, paramInt1);
  }
  
  private void layoutMenuContainerX(WindowManager.LayoutParams paramLayoutParams, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    int i;
    if (paramBoolean1) {
      i = (ViewUtils.a() - paramInt2) / 2;
    } else {
      i = ViewUtils.b(15.0F);
    }
    paramLayoutParams.x = (paramInt1 - paramInt2 / 2);
    paramLayoutParams.x = Math.max(i, paramLayoutParams.x);
    int j = ViewUtils.a();
    paramLayoutParams.x = Math.min(paramLayoutParams.x, j - i - paramInt2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[menu] layoutMenuContainerX ParamX: ");
      localStringBuilder.append(paramLayoutParams.x);
      localStringBuilder.append(" centerX: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" isMenusLineFull: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" popupWidth: ");
      localStringBuilder.append(paramInt2);
      QLog.d("BubblePopupWindow", 2, localStringBuilder.toString());
    }
    updateAboveAnchor(paramBoolean2, paramInt1 - paramLayoutParams.x);
  }
  
  private void preparePopup(WindowManager.LayoutParams paramLayoutParams)
  {
    preparePopup(paramLayoutParams, false);
  }
  
  private void preparePopup(WindowManager.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (this.mContentView != null)
    {
      Object localObject = this.mContext;
      if ((localObject != null) && (this.mWindowManager != null))
      {
        BubblePopupWindow.PopupViewContainer localPopupViewContainer = new BubblePopupWindow.PopupViewContainer(this, (Context)localObject);
        localObject = new FrameLayout(this.mContext);
        if (paramBoolean) {
          ((FrameLayout)localObject).setOnClickListener(this);
        }
        int j;
        int i;
        if ((this.mContentView instanceof QQCustomMenuNoIconLayout))
        {
          this.framelayout = new FrameLayout(this.mContext);
          this.mPressedBackground = new BubblePopupWindow.MyClipDrawable(this, this.mContext.getResources().getDrawable(2130838898));
          this.framelayout.addView(this.mContentView, new FrameLayout.LayoutParams(-2, -2, 17));
          ((FrameLayout)localObject).addView(this.framelayout, new FrameLayout.LayoutParams(-2, -2, 17));
          localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
          localLayoutParams.setMargins(0, ViewUtils.b(9.0F), 0, ViewUtils.b(9.0F));
          localPopupViewContainer.addView((View)localObject, localLayoutParams);
        }
        else
        {
          if (paramBoolean)
          {
            j = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
            i = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
          }
          else
          {
            j = 0;
            i = 0;
          }
          ((FrameLayout)localObject).setPadding(j, Math.round(TypedValue.applyDimension(1, 8.0F, this.mContext.getResources().getDisplayMetrics())), i, Math.round(TypedValue.applyDimension(1, 8.0F, this.mContext.getResources().getDisplayMetrics())));
          localPopupViewContainer.addView((View)localObject, -1, -1);
          this.framelayout = new FrameLayout(this.mContext);
          ((FrameLayout)localObject).addView(this.framelayout, -1, -1);
          localObject = this.mContext.getResources().getDrawable(2130838897);
          this.mPressedBackground = new BubblePopupWindow.MyClipDrawable(this, this.mContext.getResources().getDrawable(2130838898));
          localObject = new LayerDrawable(new Drawable[] { localObject, this.mPressedBackground });
          this.framelayout.setBackgroundDrawable((Drawable)localObject);
          localObject = new FrameLayout.LayoutParams(-1, -1, 17);
          this.framelayout.addView(this.mContentView, (ViewGroup.LayoutParams)localObject);
        }
        this.mAboveArrow = new ImageView(this.mContext);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 51);
        paramBoolean = QQTheme.a();
        if ((this.mContentView instanceof QQCustomMenuNoIconLayout))
        {
          localObject = this.mContext.getResources();
          j = 2130838894;
          if (paramBoolean) {
            i = 2130838894;
          } else {
            i = 2130838895;
          }
          this.mPressedAboveArrow = new BubblePopupWindow.MyClipDrawable(this, ((Resources)localObject).getDrawable(i));
          localObject = this.mContext.getResources();
          if (paramBoolean) {
            i = j;
          } else {
            i = 2130838895;
          }
          localObject = new LayerDrawable(new Drawable[] { ((Resources)localObject).getDrawable(i), this.mPressedAboveArrow });
        }
        else
        {
          this.mPressedAboveArrow = new BubblePopupWindow.MyClipDrawable(this, this.mContext.getResources().getDrawable(2130838896));
          localObject = new LayerDrawable(new Drawable[] { this.mContext.getResources().getDrawable(2130838893), this.mPressedAboveArrow });
        }
        this.mAboveArrow.setBackgroundDrawable((Drawable)localObject);
        localPopupViewContainer.addView(this.mAboveArrow, localLayoutParams);
        this.mBottomArrow = new ImageView(this.mContext);
        localLayoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
        if ((this.mContentView instanceof QQCustomMenuNoIconLayout))
        {
          localObject = this.mContext.getResources();
          j = 2130838878;
          if (paramBoolean) {
            i = 2130838878;
          } else {
            i = 2130838891;
          }
          this.mPressedBottomArrow = new BubblePopupWindow.MyClipDrawable(this, ((Resources)localObject).getDrawable(i));
          localObject = this.mContext.getResources();
          if (paramBoolean) {
            i = j;
          } else {
            i = 2130838891;
          }
          localObject = new LayerDrawable(new Drawable[] { ((Resources)localObject).getDrawable(i), this.mPressedBottomArrow });
        }
        else
        {
          this.mPressedBottomArrow = new BubblePopupWindow.MyClipDrawable(this, this.mContext.getResources().getDrawable(2130838892));
          localObject = new LayerDrawable(new Drawable[] { this.mContext.getResources().getDrawable(2130838864), this.mPressedBottomArrow });
        }
        this.mBottomArrow.setBackgroundDrawable((Drawable)localObject);
        localPopupViewContainer.addView(this.mBottomArrow, localLayoutParams);
        this.mPopupView = localPopupViewContainer;
        this.mPopupWidth = paramLayoutParams.width;
        this.mPopupHeight = paramLayoutParams.height;
        return;
      }
    }
    throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
  }
  
  private void registerForScrollChanged(View paramView, int paramInt1, int paramInt2)
  {
    unregisterForScrollChanged();
    this.mAnchor = new WeakReference(paramView);
    paramView = paramView.getViewTreeObserver();
    if (paramView != null) {
      paramView.addOnScrollChangedListener(this.mOnScrollChangedListener);
    }
    this.mAnchorXoff = paramInt1;
    this.mAnchorYoff = paramInt2;
  }
  
  private void unregisterForScrollChanged()
  {
    Object localObject = this.mAnchor;
    if (localObject != null) {
      localObject = (View)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((View)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
    }
    this.mAnchor = null;
  }
  
  private void update(View paramView, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    if (isShowing())
    {
      if (this.mContentView == null) {
        return;
      }
      Object localObject = this.mAnchor;
      if (paramView == null) {
        paramView = (View)((WeakReference)localObject).get();
      }
      if (paramView == null) {
        return;
      }
      boolean bool = false;
      if ((paramBoolean1) && ((this.mAnchorXoff != paramInt1) || (this.mAnchorYoff != paramInt2))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((localObject != null) && (((WeakReference)localObject).get() == paramView) && ((i == 0) || (this.mIsDropdown)))
      {
        if (i != 0)
        {
          this.mAnchorXoff = paramInt1;
          this.mAnchorYoff = paramInt2;
        }
      }
      else {
        registerForScrollChanged(paramView, paramInt1, paramInt2);
      }
      localObject = (WindowManager.LayoutParams)this.mPopupView.getLayoutParams();
      int i = paramInt3;
      int j = paramInt4;
      if (paramBoolean2)
      {
        if (paramInt3 == -1) {
          paramInt3 = this.mPopupWidth;
        } else {
          this.mPopupWidth = paramInt3;
        }
        if (paramInt4 == -1)
        {
          j = this.mPopupHeight;
          i = paramInt3;
        }
        else
        {
          this.mPopupHeight = paramInt4;
          j = paramInt4;
          i = paramInt3;
        }
      }
      paramInt3 = ((WindowManager.LayoutParams)localObject).x;
      paramInt4 = ((WindowManager.LayoutParams)localObject).y;
      if (paramBoolean1) {
        findAbovePosition(paramView, (WindowManager.LayoutParams)localObject, paramInt1, paramInt2);
      } else {
        findAbovePosition(paramView, (WindowManager.LayoutParams)localObject, this.mAnchorXoff, this.mAnchorYoff);
      }
      paramInt1 = ((WindowManager.LayoutParams)localObject).x;
      paramInt2 = ((WindowManager.LayoutParams)localObject).y;
      if (paramInt3 == ((WindowManager.LayoutParams)localObject).x)
      {
        paramBoolean1 = bool;
        if (paramInt4 == ((WindowManager.LayoutParams)localObject).y) {}
      }
      else
      {
        paramBoolean1 = true;
      }
      update(paramInt1, paramInt2, i, j, paramBoolean1);
    }
  }
  
  private void updateAboveAnchor(boolean paramBoolean, int paramInt)
  {
    this.mAboveAnchor = paramBoolean;
    if (!paramBoolean) {
      localObject = this.mAboveArrow;
    } else {
      localObject = this.mBottomArrow;
    }
    ImageView localImageView;
    if (!paramBoolean) {
      localImageView = this.mBottomArrow;
    } else {
      localImageView = this.mAboveArrow;
    }
    int i = ((View)localObject).getMeasuredWidth();
    ((View)localObject).setVisibility(0);
    Object localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (paramInt - i / 2);
    if (this.mAboveAnchor) {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 1;
    } else {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 1;
    }
    localImageView.setVisibility(4);
  }
  
  public void dismiss()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dismiss() called \n");
      ((StringBuilder)localObject1).append(QLog.getStackTraceString(new RuntimeException()));
      QLog.d("BubblePopupWindow", 2, ((StringBuilder)localObject1).toString());
    }
    if ((isShowing()) && (this.mPopupView != null))
    {
      this.mIsShowing = false;
      unregisterForScrollChanged();
      try
      {
        if (this.mPopupView.getParent() != null) {
          this.mWindowManager.removeViewImmediate(this.mPopupView);
        }
        localObject1 = this.mPopupView;
        localObject3 = this.mContentView;
        if ((localObject1 != localObject3) && ((localObject1 instanceof ViewGroup))) {
          ((ViewGroup)localObject1).removeView((View)localObject3);
        }
        this.mPopupView = null;
        localObject1 = this.mOnDismissListener;
        if (localObject1 != null)
        {
          ((BubblePopupWindow.OnDismissListener)localObject1).onDismiss();
          return;
        }
      }
      finally
      {
        Object localObject3 = this.mPopupView;
        View localView = this.mContentView;
        if ((localObject3 != localView) && ((localObject3 instanceof ViewGroup))) {
          ((ViewGroup)localObject3).removeView(localView);
        }
        this.mPopupView = null;
        localObject3 = this.mOnDismissListener;
        if (localObject3 != null) {
          ((BubblePopupWindow.OnDismissListener)localObject3).onDismiss();
        }
      }
    }
  }
  
  public int getAnimationStyle()
  {
    return this.mAnimationStyle;
  }
  
  public Drawable getBackground()
  {
    return this.mBackground;
  }
  
  public View getContentView()
  {
    return this.mContentView;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getInputMethodMode()
  {
    return this.mInputMethodMode;
  }
  
  public int getMaxAvailableHeight(View paramView)
  {
    return getMaxAvailableHeight(paramView, 0);
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt)
  {
    return getMaxAvailableHeight(paramView, paramInt, false);
  }
  
  public int getMaxAvailableHeight(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = this.mDrawingLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    int i = localRect.bottom;
    if (paramBoolean) {
      i = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i = Math.max(i - (arrayOfInt[1] + paramView.getHeight()) - paramInt, arrayOfInt[1] - localRect.top + paramInt);
    paramView = this.mBackground;
    paramInt = i;
    if (paramView != null)
    {
      paramView.getPadding(this.mTempRect);
      paramInt = i - (this.mTempRect.top + this.mTempRect.bottom);
    }
    return paramInt;
  }
  
  public int getSoftInputMode()
  {
    return this.mSoftInputMode;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public int getWindowLayoutType()
  {
    return this.mWindowLayoutType;
  }
  
  public boolean isAboveAnchor()
  {
    return this.mAboveAnchor;
  }
  
  public boolean isClippingEnabled()
  {
    return this.mClippingEnabled;
  }
  
  public boolean isFocusable()
  {
    return this.mFocusable;
  }
  
  public boolean isLayoutInScreenEnabled()
  {
    return this.mLayoutInScreen;
  }
  
  public boolean isOutsideTouchable()
  {
    return this.mOutsideTouchable;
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public boolean isSplitTouchEnabled()
  {
    int i = this.mSplitTouchEnabled;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i < 0)
    {
      Context localContext = this.mContext;
      if (localContext != null)
      {
        if (localContext.getApplicationInfo().targetSdkVersion >= 11) {
          bool1 = true;
        }
        return bool1;
      }
    }
    bool1 = bool2;
    if (this.mSplitTouchEnabled == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isTouchable()
  {
    return this.mTouchable;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    BubblePopupWindow.QQMenuNoIconEmptyInterface localQQMenuNoIconEmptyInterface = this.mQQMenuNoIconEmptyInterface;
    if (localQQMenuNoIconEmptyInterface != null) {
      localQQMenuNoIconEmptyInterface.onMenuNoIconEmptyClick();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAllowScrollingAnchorParent(boolean paramBoolean)
  {
    this.mAllowScrollingAnchorParent = paramBoolean;
  }
  
  public void setAnchorOffset(int paramInt)
  {
    this.mAnchorOffset = paramInt;
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.mAnimationStyle = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
  }
  
  public void setClipToScreenEnabled(boolean paramBoolean)
  {
    this.mClipToScreen = paramBoolean;
    setClippingEnabled(paramBoolean ^ true);
  }
  
  public void setClippingEnabled(boolean paramBoolean)
  {
    this.mClippingEnabled = paramBoolean;
  }
  
  public void setContentView(View paramView)
  {
    if (isShowing()) {
      return;
    }
    this.mContentView = paramView;
    if (this.mContext == null)
    {
      paramView = this.mContentView;
      if (paramView != null) {
        this.mContext = paramView.getContext();
      }
    }
    if ((this.mWindowManager == null) && (this.mContentView != null)) {
      this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    this.mFocusable = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setIgnoreCheekPress()
  {
    this.mIgnoreCheekPress = true;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.mInputMethodMode = paramInt;
  }
  
  public void setKeepAbove(boolean paramBoolean)
  {
    this.mKeepAbove = paramBoolean;
  }
  
  public void setLayoutInScreenEnabled(boolean paramBoolean)
  {
    this.mLayoutInScreen = paramBoolean;
  }
  
  public void setLayoutInsetDecor(boolean paramBoolean)
  {
    this.mLayoutInsetDecor = paramBoolean;
  }
  
  public void setOnDismissListener(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
  
  public void setOnKeybackListener(BubblePopupWindow.OnKeyBackListener paramOnKeyBackListener)
  {
    this.mOnKeybackListener = paramOnKeyBackListener;
  }
  
  public void setOutsideTouchable(boolean paramBoolean)
  {
    this.mOutsideTouchable = paramBoolean;
  }
  
  public void setQQMenuNoIconEmptyInterface(BubblePopupWindow.QQMenuNoIconEmptyInterface paramQQMenuNoIconEmptyInterface)
  {
    this.mQQMenuNoIconEmptyInterface = paramQQMenuNoIconEmptyInterface;
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.mSoftInputMode = paramInt;
  }
  
  public void setSplitTouchEnabled(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setTouchInterceptor(View.OnTouchListener paramOnTouchListener)
  {
    this.mTouchInterceptor = paramOnTouchListener;
  }
  
  public void setTouchModal(boolean paramBoolean)
  {
    this.mNotTouchModal = (paramBoolean ^ true);
  }
  
  public void setTouchable(boolean paramBoolean)
  {
    this.mTouchable = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public void setWindowLayoutMode(int paramInt1, int paramInt2)
  {
    this.mWidthMode = paramInt1;
    this.mHeightMode = paramInt2;
  }
  
  public void setWindowLayoutType(int paramInt)
  {
    this.mWindowLayoutType = paramInt;
  }
  
  public void showAsDropDown(View paramView)
  {
    showAsDropDown(paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if (!isShowing())
    {
      if (this.mContentView == null) {
        return;
      }
      registerForScrollChanged(paramView, paramInt1, paramInt2);
      this.mIsShowing = true;
      this.mIsDropdown = true;
      WindowManager.LayoutParams localLayoutParams = createPopupLayout(paramView.getWindowToken());
      preparePopup(localLayoutParams);
      findAbovePosition(paramView, localLayoutParams, paramInt1, paramInt2);
      paramInt1 = this.mHeightMode;
      if (paramInt1 < 0)
      {
        this.mLastHeight = paramInt1;
        localLayoutParams.height = paramInt1;
      }
      paramInt1 = this.mWidthMode;
      if (paramInt1 < 0)
      {
        this.mLastWidth = paramInt1;
        localLayoutParams.width = paramInt1;
      }
      localLayoutParams.windowAnimations = computeAnimationResource();
      invokePopup(localLayoutParams);
    }
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2)
  {
    showAtLocation(paramView, paramInt1, paramInt2, false);
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showAtLocation() called with: parent = [");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append("], x = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("], y = [");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("], isNoIcon = [");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.d("BubblePopupWindow", 2, ((StringBuilder)localObject).toString());
    }
    if (!isShowing())
    {
      if (this.mContentView == null) {
        return;
      }
      unregisterForScrollChanged();
      this.mIsShowing = true;
      this.mIsDropdown = true;
      localObject = createPopupLayout(paramView.getWindowToken());
      preparePopup((WindowManager.LayoutParams)localObject, paramBoolean);
      findAbovePosition((WindowManager.LayoutParams)localObject, paramInt1, paramInt2, paramView);
      paramInt1 = this.mHeightMode;
      if (paramInt1 < 0)
      {
        this.mLastHeight = paramInt1;
        ((WindowManager.LayoutParams)localObject).height = paramInt1;
      }
      paramInt1 = this.mWidthMode;
      if (paramInt1 < 0)
      {
        this.mLastWidth = paramInt1;
        ((WindowManager.LayoutParams)localObject).width = paramInt1;
      }
      ((WindowManager.LayoutParams)localObject).windowAnimations = computeAnimationResource();
      invokePopup((WindowManager.LayoutParams)localObject);
    }
  }
  
  public void update()
  {
    if (isShowing())
    {
      if (this.mContentView == null) {
        return;
      }
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mPopupView.getLayoutParams();
      int i = 0;
      int j = computeAnimationResource();
      if (j != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = j;
        i = 1;
      }
      j = computeFlags(localLayoutParams.flags);
      if (j != localLayoutParams.flags)
      {
        localLayoutParams.flags = j;
        i = 1;
      }
      if (i != 0) {
        this.mWindowManager.updateViewLayout(this.mPopupView, localLayoutParams);
      }
    }
  }
  
  public void update(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mPopupView.getLayoutParams();
    update(localLayoutParams.x, localLayoutParams.y, paramInt1, paramInt2, false);
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    update(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramInt3 != -1)
    {
      this.mLastWidth = paramInt3;
      setWidth(paramInt3);
    }
    if (paramInt4 != -1)
    {
      this.mLastHeight = paramInt4;
      setHeight(paramInt4);
    }
    if (isShowing())
    {
      if (this.mContentView == null) {
        return;
      }
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mPopupView.getLayoutParams();
      int i = this.mWidthMode;
      if (i >= 0) {
        i = this.mLastWidth;
      }
      boolean bool = paramBoolean;
      if (paramInt3 != -1)
      {
        bool = paramBoolean;
        if (localLayoutParams.width != i)
        {
          this.mLastWidth = i;
          localLayoutParams.width = i;
          bool = true;
        }
      }
      paramInt3 = this.mHeightMode;
      if (paramInt3 >= 0) {
        paramInt3 = this.mLastHeight;
      }
      paramBoolean = bool;
      if (paramInt4 != -1)
      {
        paramBoolean = bool;
        if (localLayoutParams.height != paramInt3)
        {
          this.mLastHeight = paramInt3;
          localLayoutParams.height = paramInt3;
          paramBoolean = true;
        }
      }
      if (localLayoutParams.x != paramInt1)
      {
        localLayoutParams.x = paramInt1;
        paramBoolean = true;
      }
      if (localLayoutParams.y != paramInt2)
      {
        localLayoutParams.y = paramInt2;
        paramBoolean = true;
      }
      paramInt1 = computeAnimationResource();
      if (paramInt1 != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = paramInt1;
        paramBoolean = true;
      }
      paramInt1 = computeFlags(localLayoutParams.flags);
      if (paramInt1 != localLayoutParams.flags)
      {
        localLayoutParams.flags = paramInt1;
        paramBoolean = true;
      }
      if (paramBoolean) {
        this.mWindowManager.updateViewLayout(this.mPopupView, localLayoutParams);
      }
    }
  }
  
  public void update(View paramView, int paramInt1, int paramInt2)
  {
    update(paramView, false, 0, 0, true, paramInt1, paramInt2);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    update(paramView, true, paramInt1, paramInt2, true, paramInt3, paramInt4);
  }
  
  public void updateLocationX(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramInt1 = (int)(paramInt1 + this.mContentView.getX() * 2.0F);
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.mPopupView.getLayoutParams();
    if (this.mContainerCenterX > ViewUtils.a() / 2) {
      localLayoutParams.x = (localLayoutParams.x + paramInt2 - paramInt1);
    }
    updateAboveAnchor(this.mAboveAnchor, this.mContainerCenterX - localLayoutParams.x);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.mWindowManager.updateViewLayout(this.mPopupView, localLayoutParams);
    }
    else
    {
      this.mWindowManager.removeView(this.mPopupView);
      this.mWindowManager.addView(this.mPopupView, localLayoutParams);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[menu] updateLocationX ParamX: ");
      localStringBuilder.append(localLayoutParams.x);
      localStringBuilder.append(" menuContainerWidth: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" centerX: ");
      localStringBuilder.append(this.mContainerCenterX);
      localStringBuilder.append(" isMenusLineFull: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("BubblePopupWindow", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */