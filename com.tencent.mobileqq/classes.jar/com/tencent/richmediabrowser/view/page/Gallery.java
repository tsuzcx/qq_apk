package com.tencent.richmediabrowser.view.page;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.utils.VersionUtils;

public class Gallery
  extends AbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  public static final float DEFAULT_DOULE_CLICK_SCALE_FACTOR = 2.0F;
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  public static final int ID_CHILD_ROTATEABLE = 2131296390;
  public static final int ID_DEFAULT_ROTATE = 2131296389;
  public static final int ID_DEFAULT_SCALE = 2131296385;
  public static final int ID_LONG_PIC_DOUBLE_TAP_ACTION = 2131296414;
  public static final int ID_LONG_PIC_SCALE = 2131296392;
  public static final int ID_MAX_SCALE = 2131296391;
  public static final int ID_SCALE_DISABLE = 2131296400;
  public static final int ID_USER_DEFINE_CHILDVIEW_MATCH_PARENT = 2131296433;
  public static final int ID_USER_DEFINE_DISABLE_SMALL_PIC_LOGIC = 2131296417;
  public static final int ID_USER_DEFINE_DOUBLE_TAP_SCALE = 2131296413;
  public static final int ID_USER_DEFINE_GRAVITY = 2131296415;
  public static final int ID_USER_DEFINE_HIGH_PIC_DOUBLE_TAP_SCALE = 2131296416;
  public static final int ID_USER_DEFINE_SCALE = 2131296386;
  public static final int ID_VIDEO_TAG = 2131296418;
  public static final int ID_VIEW_TRANSFORMED = 2131296412;
  public static float MAX_SCALE_DEFAULT = 2.0F;
  public static final int NOT_SUPPORT_REGION_DECODE = 102;
  public static final float QZONE_DEFAULT_SCALE = 1.0F;
  public static final int ROTATE_0 = 0;
  public static final int ROTATE_180 = 2;
  public static final int ROTATE_270 = 3;
  public static final int ROTATE_90 = 1;
  protected static final int SCROLL_STATE_IDLE = -1;
  protected static final int SCROLL_STATE_PAGING = 0;
  protected static final int SCROLL_STATE_SCROLLING = 1;
  protected static final int SCROLL_STATE_TOSLOT = 2;
  private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
  public static final int SUPPORT_REGION_DECODE = 101;
  private static final String TAG = "Gallery";
  public static final int TAG_MATRIX = 2131296388;
  private static final int ZERO = 0;
  private static int defaultminumangle = 20;
  private static final boolean localLOGV = false;
  protected static Rect tmp = new Rect();
  private static RectF tmp2 = new RectF();
  float beginRotation = 0.0F;
  float beginScale;
  float beginSpan;
  boolean canRotating = true;
  private int dx;
  private int dy;
  float focusX;
  float focusY;
  private boolean interceptTouchEventReturn = true;
  private boolean isRotateEnable = false;
  boolean isRotating = false;
  long lastMoveTime = -1L;
  private int mAnimationDuration = 400;
  public boolean mClearByTag = false;
  private AdapterView.AdapterContextMenuInfo mContextMenuInfo;
  private Runnable mDisableSuppressSelectionChangedRunnable = new Gallery.1(this);
  private boolean mDoubleTapEnable = true;
  private int mDownTouchPosition;
  private View mDownTouchView;
  private Gallery.FlingRunnable mFlingRunnable = new Gallery.FlingRunnable(this);
  private GestureDetector mGestureDetector = new GestureDetector(paramContext, this);
  private int mHeight;
  private int mHeightMultDensity;
  private boolean mIsDoubleTapping = false;
  private boolean mIsFirstScroll;
  public boolean mIsLayoutScale = false;
  private boolean mIsLeftEdge = false;
  private boolean mIsMultiTouch = false;
  public boolean mIsQzoneDefaultScale = false;
  private boolean mIsRightedge = false;
  protected boolean mIsScaling = false;
  long mLastTime;
  private int mLeftMost;
  private float mMaximumVelocity;
  private float mMaxumScale = MAX_SCALE_DEFAULT;
  private int mMinimumVelocity;
  private float mMinumScale = 1.0F;
  Gallery.OnItemRotateListener mOnItemRotateListener;
  protected Gallery.OnScollListener mOnScollListener;
  private boolean mOnSizeChanged;
  private boolean mReceivedInvokeKeyDown;
  private int mRightMost;
  private ScaleGestureDetector mScaleGestureDetector;
  private boolean mScaleGestureEnable = true;
  protected int mScrollDirection;
  protected int mScrollState = -1;
  private boolean mScrollingRegion = false;
  protected View mSelectedChild;
  private boolean mShouldCallbackDuringFling = true;
  private boolean mShouldCallbackOnUnselectedItemClick = true;
  private boolean mShouldStopFling;
  private int mSpacing = 0;
  private boolean mSupportMatchParent = false;
  private boolean mSuppressSelectionChanged;
  private VelocityTracker mVelocityTracker;
  private int mWidth;
  private int mWidthMultDensity;
  protected int scrollX = 0;
  protected int scrollY = 0;
  private Matrix tempMatrix = new Matrix();
  Point tmpP = new Point();
  double vectorRotation = 0.0D;
  
  public Gallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842864);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, false);
    this.mGestureDetector.setIsLongpressEnabled(true);
    this.mGestureDetector.setOnDoubleTapListener(this);
    this.mScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    if (!VersionUtils.isHoneycomb()) {
      setStaticTransformationsEnabled(true);
    }
    this.mMinimumVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = TypedValue.applyDimension(1, 2400.0F, paramContext.getResources().getDisplayMetrics());
    setFadingEdgeLength(0);
  }
  
  @TargetApi(11)
  private void applyTransformation(View paramView1, View paramView2)
  {
    if (paramView1 != paramView2)
    {
      if (VersionUtils.isHoneycomb()) {
        setChildScale(paramView2, paramView1.getPivotX(), paramView1.getPivotY(), paramView1.getScaleX());
      }
    }
    else {
      return;
    }
    paramView2.setTag(2131296388, (Gallery.TransformationInfo)paramView1.getTag(2131296388));
  }
  
  private void detachOffScreenChildren(boolean paramBoolean)
  {
    int k = 0;
    int j = 0;
    int i2 = getChildCount();
    int i1 = this.mFirstPosition;
    int m;
    int n;
    View localView;
    if (paramBoolean)
    {
      i3 = getPaddingLeft();
      i = 0;
      m = 0;
      k = j;
      j = m;
      for (;;)
      {
        m = j;
        n = k;
        if (i < i2)
        {
          localView = getChildAt(i);
          if (getChildBounds(localView, tmp).right > i3)
          {
            n = k;
            m = j;
          }
        }
        else
        {
          detachViewsFromParent(n, m);
          if (paramBoolean) {
            this.mFirstPosition = (m + this.mFirstPosition);
          }
          return;
        }
        j += 1;
        this.mRecycler.put(i1 + i, localView);
        onViewDetached(i1 + i, localView, this, paramBoolean);
        onViewCreated(i1 + i + 1, this, paramBoolean, true);
        k = i;
        i += 1;
      }
    }
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i = i2 - 1;
    j = 0;
    for (;;)
    {
      m = j;
      n = k;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      m = j;
      n = k;
      if (getChildBounds(localView, tmp).left < i3 - i4) {
        break;
      }
      this.mRecycler.put(i1 + i, localView);
      onViewDetached(i1 + i, localView, this, paramBoolean);
      onViewCreated(i1 + i - 1, this, paramBoolean, true);
      j += 1;
      k = i;
      i -= 1;
    }
  }
  
  private boolean dispatchLongPress(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool1 = this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.mContextMenuInfo = new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  private void dispatchPress(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  private void dispatchUnpress()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      getChildAt(i).setPressed(false);
      i -= 1;
    }
    setPressed(false);
  }
  
  private void fillToGalleryLeft()
  {
    if (getChildCount() >= 2) {}
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getPaddingLeft();
      int n = this.mWidth;
      View localView = getChildAt(0);
      int i;
      int j;
      if (localView != null)
      {
        i = this.mFirstPosition - 1;
        j = getChildBounds(localView, tmp).left - k;
      }
      while ((j > m) && (i >= 0))
      {
        makeAndAddView(i, i - this.mSelectedPosition, j, false, null);
        if (this.mOnScollListener != null) {
          this.mOnScollListener.onScrollStart(i);
        }
        this.mFirstPosition = i;
        j -= n + k;
        i -= 1;
        continue;
        j = getRight() - getLeft() - getPaddingRight();
        this.mShouldStopFling = true;
        i = 0;
      }
    }
  }
  
  private void fillToGalleryRight()
  {
    int i = getChildCount();
    if (i >= 2) {}
    for (;;)
    {
      return;
      int k = this.mSpacing;
      int m = getRight();
      int n = getLeft();
      int i1 = getPaddingRight();
      int i2 = this.mWidth;
      int i3 = this.mItemCount;
      View localView = getChildAt(i - 1);
      int j;
      if (localView != null)
      {
        i = this.mFirstPosition + i;
        j = getChildBounds(localView, tmp).right + k;
      }
      while ((j < m - n - i1) && (i < i3))
      {
        makeAndAddView(i, i - this.mSelectedPosition, j, true, null);
        if (this.mOnScollListener != null) {
          this.mOnScollListener.onScrollStart(i);
        }
        j += i2 + k;
        i += 1;
        continue;
        i = this.mItemCount - 1;
        this.mFirstPosition = i;
        j = getPaddingLeft();
        this.mShouldStopFling = true;
      }
    }
  }
  
  public static float getAIOImageScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    float f2 = 1.0F;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 1.0F;
    }
    int i = paramInt2 * paramInt3 / paramInt1;
    if ((isLongPhoto(paramInt1, paramInt2)) && (paramInt1 <= paramInt3))
    {
      f1 = f2;
      if (paramInt2 <= paramInt4) {}
    }
    else if (paramInt1 < 135)
    {
      f1 = f2;
      if (paramInt2 < 135) {}
    }
    else
    {
      if (paramInt4 < i) {
        break label82;
      }
    }
    label82:
    for (float f1 = paramInt3 / paramInt1;; f1 = paramInt4 / paramInt2) {
      return Math.min(f1, 2.0F);
    }
  }
  
  private int getCenterOfGallery()
  {
    return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2 + getPaddingLeft();
  }
  
  private static int getCenterOfView(View paramView)
  {
    return paramView.getLeft() + paramView.getWidth() / 2;
  }
  
  private Gallery.ScaleViewHolder getChildGravityAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    boolean bool2 = false;
    Gallery.ScaleViewHolder localScaleViewHolder = new Gallery.ScaleViewHolder(null);
    if (paramView.getTag(2131296389) != null) {}
    for (int k = ((Integer)paramView.getTag(2131296389)).intValue();; k = 0)
    {
      localScaleViewHolder.defaultRotate = k;
      if ((paramView.getTag(2131296415) instanceof Integer)) {}
      for (localScaleViewHolder.gravity = ((Integer)paramView.getTag(2131296415)).intValue(); paramView.getTag(2131296386) != null; localScaleViewHolder.gravity = 17)
      {
        localScaleViewHolder.defaultScale = ((Float)paramView.getTag(2131296386)).floatValue();
        return localScaleViewHolder;
      }
      int j;
      int i;
      if (k != 1)
      {
        j = paramInt1;
        i = paramInt2;
        if (k != 3) {}
      }
      else
      {
        i = paramInt1;
        j = paramInt2;
      }
      float f = getAIOImageScale(j, i, paramInt3, paramInt4, null);
      if (i >= j * 3)
      {
        paramInt1 = 1;
        if ((paramInt1 == 0) || ((j <= paramInt3) && (i <= paramInt4)) || ((j < 135) && (i < 135))) {
          break label315;
        }
        localScaleViewHolder.gravity = 49;
        localScaleViewHolder.defaultScale = Math.min(paramInt3 / j, this.mMaxumScale);
        localScaleViewHolder.isHighPic = true;
        paramView.setTag(2131296392, Float.valueOf(f));
        if (isNeedSetLongPicAction()) {
          paramView.setTag(2131296414, Float.valueOf(localScaleViewHolder.defaultScale));
        }
      }
      for (;;)
      {
        boolean bool1 = bool2;
        if (paramView.getTag(2131296412) != null)
        {
          bool1 = bool2;
          if (((Boolean)paramView.getTag(2131296412)).booleanValue()) {
            bool1 = true;
          }
        }
        localScaleViewHolder.hasTransformed = bool1;
        return localScaleViewHolder;
        paramInt1 = 0;
        break;
        label315:
        localScaleViewHolder.gravity = 17;
        localScaleViewHolder.isHighPic = false;
        localScaleViewHolder.defaultScale = customScale(paramView, f, j);
      }
    }
  }
  
  private Rect getChildLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    switch (paramInt3 & 0x70)
    {
    default: 
      i = 0;
      switch (paramInt3 & 0x7)
      {
      case 4: 
      default: 
        paramInt3 = (j - this.mSpinnerPadding.left - this.mSpinnerPadding.right - paramInt1) / 2;
        if (paramBoolean)
        {
          paramInt3 = paramInt4 + paramInt3;
          paramInt4 = paramInt3 + paramInt1;
          paramInt1 = paramInt3;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localRect.left = paramInt1;
      localRect.top = i;
      localRect.right = paramInt4;
      localRect.bottom = (i + paramInt2);
      return localRect;
      i = this.mSpinnerPadding.top;
      break;
      int k = this.mSpinnerPadding.bottom;
      int m = this.mSpinnerPadding.top;
      int n = this.mSpinnerPadding.top;
      i = (i - k - m - paramInt2) / 2 + n;
      break;
      i = i - this.mSpinnerPadding.bottom - paramInt2;
      break;
      if (paramBoolean)
      {
        paramInt3 = paramInt4;
        paramInt4 += paramInt1;
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = paramInt4 - paramInt1;
        continue;
        paramInt1 = paramInt4 - paramInt1 - paramInt3;
        paramInt4 -= paramInt3;
      }
    }
  }
  
  @TargetApi(11)
  private float[] getChildPivot(View paramView)
  {
    float f2;
    if (VersionUtils.isHoneycomb()) {
      f2 = paramView.getPivotX();
    }
    for (float f1 = paramView.getPivotY();; f1 = getChildTransformationInfo(paramView).mPivotY)
    {
      return new float[] { f2, f1 };
      f2 = getChildTransformationInfo(paramView).mPivotX;
    }
  }
  
  @TargetApi(11)
  private float getChildRotation(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      return paramView.getRotation();
    }
    return getChildTransformationInfo(paramView).mRotation;
  }
  
  private Gallery.TransformationInfo getChildTransformationInfo(View paramView)
  {
    Gallery.TransformationInfo localTransformationInfo2 = (Gallery.TransformationInfo)paramView.getTag(2131296388);
    Gallery.TransformationInfo localTransformationInfo1 = localTransformationInfo2;
    if (localTransformationInfo2 == null)
    {
      localTransformationInfo1 = new Gallery.TransformationInfo();
      paramView.setTag(2131296388, localTransformationInfo1);
    }
    if (localTransformationInfo1.mMatrixDirty) {
      updateMatrix(localTransformationInfo1);
    }
    return localTransformationInfo1;
  }
  
  @TargetApi(11)
  private float[] getChildTranslation(View paramView)
  {
    float f2;
    if (VersionUtils.isHoneycomb()) {
      f2 = paramView.getTranslationX();
    }
    for (float f1 = paramView.getTranslationY();; f1 = paramView.mTranslationY)
    {
      return new float[] { f2, f1 };
      paramView = getChildTransformationInfo(paramView);
      f2 = paramView.mTranslationX;
    }
  }
  
  @TargetApi(11)
  private Rect getImageSize(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    Rect localRect = new Rect();
    tmp2.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    if (VersionUtils.isHoneycomb()) {}
    for (Matrix localMatrix = paramView.getMatrix();; localMatrix = Gallery.TransformationInfo.access$100(getChildTransformationInfo(paramView)))
    {
      localMatrix.mapRect(tmp2);
      tmp2.offset(paramView.getLeft(), paramView.getTop());
      tmp2.round(localRect);
      return localRect;
    }
  }
  
  private double getRadian(float paramFloat1, float paramFloat2)
  {
    double d2 = Math.atan(paramFloat2 / paramFloat1);
    double d1;
    if (paramFloat1 < 0.0F) {
      d1 = d2 + 3.141592653589793D;
    }
    do
    {
      return d1;
      d1 = d2;
    } while (d2 >= 0.0D);
    return d2 + 6.283185307179586D;
  }
  
  private static int getRotationFlag(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    for (;;)
    {
      int i = paramInt1;
      if (paramInt1 > 360) {
        i = paramInt1 % 360;
      }
      paramInt1 = defaultminumangle;
      if ((paramInt2 == 1) || (paramInt2 == 3)) {
        paramInt1 = 90 - defaultminumangle;
      }
      paramInt2 = 180 - paramInt1;
      int j = paramInt1 + 180;
      int k = 360 - paramInt1;
      if (((i >= 0) && (i < paramInt1)) || (i >= k)) {
        return 0;
      }
      if ((i >= paramInt1) && (i < paramInt2)) {
        return 1;
      }
      if ((i >= paramInt2) && (i < j)) {
        return 2;
      }
      if ((i >= j) && (i < k)) {
        return 3;
      }
      return 0;
    }
  }
  
  private static int getRotationInternal(int paramInt1, int paramInt2)
  {
    if (paramInt1 < -45) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    label86:
    for (;;)
    {
      int i = paramInt1 - paramInt2 * 90;
      if (i > 180) {
        paramInt2 = paramInt1 - 360;
      }
      do
      {
        return paramInt2;
        if (paramInt1 < 275) {
          break label86;
        }
        paramInt1 -= (paramInt1 + 360) / 360 * 360;
        break;
        paramInt2 = paramInt1;
      } while (i >= -180);
      return paramInt1 + 360;
    }
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  public static boolean isLongPhoto(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= 3L * paramLong2) || (paramLong2 >= 3L * paramLong1);
  }
  
  private void layoutAndScaleChild(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    this.mIsLayoutScale = true;
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if ((j == 0) || (i == 0)) {
      return;
    }
    Gallery.ScaleViewHolder localScaleViewHolder = getChildGravityAndScale(i, j, paramInt1, paramInt2, paramView);
    boolean bool1;
    boolean bool2;
    if ((paramView.getWidth() != i) || (paramView.getHeight() != j))
    {
      bool1 = true;
      if (localScaleViewHolder.defaultRotate * 90 == paramView.getRotation()) {
        break label353;
      }
      bool2 = true;
      label88:
      BrowserLogHelper.getInstance().getGalleryLog().e("Gallery", 2, "imgSizeChanged in layoutAndScaleChild is " + Boolean.toString(bool1) + " rotateChanged:" + bool2);
      if (localScaleViewHolder != null)
      {
        paramInt1 = paramView.getLeft();
        layoutChild(paramView, localScaleViewHolder.gravity, paramInt3, paramBoolean);
        if ((localScaleViewHolder.isHighPic) && (canUpdateRegionRect())) {
          updateShowArea(true);
        }
        if ((localScaleViewHolder.hasTransformed) && (!bool1) && (!bool2)) {
          break label359;
        }
        float f = localScaleViewHolder.defaultScale;
        if (f != 0.0F)
        {
          setChildPivot(paramView, 0.0F, 0.0F);
          setChildScale(paramView, f);
          setChildRotation(paramView, localScaleViewHolder.defaultRotate * 90);
          getChildBounds(paramView, tmp);
          Rect localRect = getChildLayout(tmp.width(), tmp.height(), localScaleViewHolder.gravity, paramInt3, paramBoolean);
          setChildTranslation(paramView, localRect.left - tmp.left, localRect.top - tmp.top);
        }
        paramView.setTag(2131296385, Float.valueOf(localScaleViewHolder.defaultScale));
        paramView.setTag(2131296389, Integer.valueOf(localScaleViewHolder.defaultRotate));
      }
    }
    for (;;)
    {
      this.mIsLayoutScale = false;
      return;
      bool1 = false;
      break;
      label353:
      bool2 = false;
      break label88;
      label359:
      paramInt1 -= paramView.getLeft();
      BrowserLogHelper.getInstance().getGalleryLog().e("Gallery", 2, "left diff is: " + paramInt1);
      if (paramInt1 != 0) {
        setChildTranslation(paramView, paramInt1, 0);
      }
    }
  }
  
  private void layoutChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = getChildLayout(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), paramInt1, paramInt2, paramBoolean);
    paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    Object localObject2;
    if (!this.mDataChanged)
    {
      localObject2 = this.mRecycler.get(paramInt1);
      if (localObject2 != null)
      {
        paramInt1 = ((View)localObject2).getLeft();
        this.mRightMost = Math.max(this.mRightMost, ((View)localObject2).getMeasuredWidth() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        setUpChild((View)localObject2, paramInt2, paramInt3, paramBoolean, true);
      }
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = this.mAdapter.getView(paramInt1, null, this);
      onViewCreated(paramInt1, this, paramBoolean, false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = getContext();
        localObject1 = new ImageView((Context)localObject2);
        ((ImageView)localObject1).setImageDrawable(((Context)localObject2).getResources().getDrawable(2130850136));
      }
      setUpChild((View)localObject1, paramInt2, paramInt3, paramBoolean, false);
      localObject2 = localObject1;
    } while (paramView == null);
    applyTransformation(paramView, (View)localObject1);
    return localObject1;
  }
  
  private void markViewTransformed(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTag(2131296412, Boolean.valueOf(true));
  }
  
  private void onFinishedMovement()
  {
    if (this.mSuppressSelectionChanged)
    {
      this.mSuppressSelectionChanged = false;
      super.selectionChanged();
    }
    invalidate();
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void resetScrollState()
  {
    this.mScrollState = -1;
    this.mGestureDetector.setIsLongpressEnabled(true);
  }
  
  private void scrollIntoSlots()
  {
    scrollIntoSlots(0.0F);
  }
  
  @TargetApi(11)
  private void setChildPivot(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    Gallery.TransformationInfo localTransformationInfo;
    do
    {
      return;
      if (VersionUtils.isHoneycomb())
      {
        paramView.setPivotX(paramFloat1);
        paramView.setPivotY(paramFloat2);
        return;
      }
      localTransformationInfo = getChildTransformationInfo(paramView);
    } while ((localTransformationInfo.mPivotX == paramFloat1) && (localTransformationInfo.mPivotY == paramFloat2));
    localTransformationInfo.mPivotX = paramFloat1;
    localTransformationInfo.mPivotY = paramFloat2;
    localTransformationInfo.mMatrixDirty = true;
    paramView.invalidate();
  }
  
  @TargetApi(11)
  private void setChildRotation(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setRotation(paramFloat);
    markViewTransformed(paramView);
  }
  
  private void setChildScale(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      return;
      markViewTransformed(paramView);
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
    } while (isHardwareAccelerated());
    invalidate();
  }
  
  private void setChildScale(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    markViewTransformed(paramView);
    paramView.setPivotX(paramFloat1);
    paramView.setPivotY(paramFloat2);
    paramView.setScaleX(paramFloat3);
    paramView.setScaleY(paramFloat3);
    paramView.getMatrix();
    if (!isHardwareAccelerated()) {
      invalidate();
    }
  }
  
  private void setChildTranslation(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() + paramInt1);
    paramView.setTranslationY(paramView.getTranslationY() + paramInt2);
    markViewTransformed(paramView);
  }
  
  @TargetApi(11)
  private void setPivot(float paramFloat1, float paramFloat2)
  {
    getChildBounds(this.mSelectedChild, tmp);
    float f1 = this.mSelectedChild.getLeft();
    float f2 = this.mSelectedChild.getTop();
    getChildMatrix(this.mSelectedChild).invert(this.tempMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramFloat1 - f1);
    arrayOfFloat[1] = (paramFloat2 - f2);
    this.tempMatrix.mapPoints(arrayOfFloat);
    int k = tmp.width() / 2;
    int m = tmp.left;
    int i = tmp.height() / 2;
    int j = tmp.top;
    setChildPivot(this.mSelectedChild, arrayOfFloat[0], arrayOfFloat[1]);
    getChildBounds(this.mSelectedChild, tmp);
    k = k + m - (tmp.width() / 2 + tmp.left);
    i = i + j - (tmp.height() / 2 + tmp.top);
    if (VersionUtils.isHoneycomb())
    {
      setChildTranslation(this.mSelectedChild, k, i);
      return;
    }
    this.mSelectedChild.offsetLeftAndRight(k);
    this.mSelectedChild.offsetTopAndBottom(i);
  }
  
  private void setSelectionToCenterChild()
  {
    int i;
    if (this.dx > 0)
    {
      i = getChildCount() - 1;
      this.dx = getChildBounds(getChildAt(i), tmp).left;
      i += this.mFirstPosition;
      this.dy = 0;
    }
    for (;;)
    {
      if (i != this.mSelectedPosition)
      {
        setSelectedPositionInt(i);
        setNextSelectedPositionInt(i);
        checkSelectionChanged();
      }
      return;
      if (this.dx < 0)
      {
        i = this.mFirstPosition;
        this.dx = getChildBounds(getChildAt(0), tmp).left;
        this.dy = 0;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void setUpChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    if (paramView == null) {
      return;
    }
    boolean bool;
    label26:
    int i;
    label45:
    Gallery.LayoutParams localLayoutParams;
    if (paramInt1 == 0)
    {
      bool = true;
      if (bool == paramView.isSelected()) {
        break label262;
      }
      paramInt1 = 1;
      if ((paramBoolean2) && (paramInt1 == 0) && (!paramView.isLayoutRequested())) {
        break label267;
      }
      i = 1;
      localLayoutParams = (Gallery.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label285;
      }
      localLayoutParams = (Gallery.LayoutParams)generateDefaultLayoutParams();
    }
    label262:
    label267:
    label279:
    label285:
    for (;;)
    {
      int j;
      if (paramBoolean1)
      {
        j = -1;
        label76:
        addViewInLayout(paramView, j, localLayoutParams, true);
        if (paramInt1 != 0) {
          paramView.setSelected(bool);
        }
        if (i == 0) {
          break;
        }
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (!this.mSupportMatchParent)
        {
          paramInt1 = k;
          if (paramView.getTag(2131296433) != null)
          {
            paramInt1 = k;
            if (!((Boolean)paramView.getTag(2131296433)).booleanValue()) {}
          }
        }
        else
        {
          paramInt1 = 1;
        }
        if ((paramInt1 == 0) || (localLayoutParams.height != -1) || (localLayoutParams.width != -1)) {
          break label279;
        }
        i = View.MeasureSpec.makeMeasureSpec(getWidth() - this.mSpinnerPadding.left - this.mSpinnerPadding.right, 1073741824);
      }
      for (paramInt1 = View.MeasureSpec.makeMeasureSpec(getHeight() - this.mSpinnerPadding.top - this.mSpinnerPadding.bottom, 1073741824);; paramInt1 = j)
      {
        paramView.measure(i, paramInt1);
        layoutAndScaleChild(this.mWidth, this.mHeight, paramInt2, paramBoolean1, paramView);
        return;
        bool = false;
        break;
        paramInt1 = 0;
        break label26;
        i = 0;
        break label45;
        j = 0;
        break label76;
      }
    }
  }
  
  private void updateMatrix(Gallery.TransformationInfo paramTransformationInfo)
  {
    if (paramTransformationInfo == null) {}
    while (!paramTransformationInfo.mMatrixDirty) {
      return;
    }
    Gallery.TransformationInfo.access$100(paramTransformationInfo).reset();
    Gallery.TransformationInfo.access$100(paramTransformationInfo).setTranslate(paramTransformationInfo.mTranslationX, paramTransformationInfo.mTranslationY);
    Gallery.TransformationInfo.access$100(paramTransformationInfo).preRotate(paramTransformationInfo.mRotation, paramTransformationInfo.mPivotX, paramTransformationInfo.mPivotY);
    Gallery.TransformationInfo.access$100(paramTransformationInfo).preScale(paramTransformationInfo.mScaleX, paramTransformationInfo.mScaleY, paramTransformationInfo.mPivotX, paramTransformationInfo.mPivotY);
    paramTransformationInfo.mMatrixDirty = false;
    Gallery.TransformationInfo.access$302(paramTransformationInfo, Gallery.TransformationInfo.access$100(paramTransformationInfo).isIdentity());
  }
  
  private void updateSelectedItemMetadata()
  {
    View localView1 = this.mSelectedChild;
    View localView2 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    this.mSelectedChild = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
    } while ((localView1 == null) || (localView1 == localView2));
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  private void updateShowArea(boolean paramBoolean)
  {
    updateShowArea(paramBoolean, 0);
  }
  
  protected int calculateDampingDeltaX(boolean paramBoolean, int paramInt)
  {
    int j;
    int i;
    if (paramBoolean)
    {
      j = this.mWidth - this.mSpinnerPadding.right - tmp.right;
      if (j > 0) {
        i = paramInt / 4;
      }
    }
    do
    {
      do
      {
        return i;
        i = paramInt;
      } while (paramInt >= j);
      return (paramInt - j) / 4 + j;
      j = this.mSpinnerPadding.left - tmp.left;
      if (j < 0) {
        return paramInt / 4;
      }
      i = paramInt;
    } while (paramInt <= j);
    return (paramInt - j) / 4 + j;
  }
  
  protected boolean canUpdateRegionRect()
  {
    if (!VersionUtils.isHoneycomb()) {}
    while ((this.mSelectedChild == null) || (this.mSelectedChild.getWidth() * this.mSelectedChild.getHeight() < this.mWidthMultDensity * this.mHeightMultDensity << 2)) {
      return false;
    }
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof Gallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.mItemCount;
  }
  
  protected float customScale(View paramView, float paramFloat, int paramInt)
  {
    boolean bool = false;
    if (paramView.getTag(2131296418) != null) {
      bool = ((Boolean)paramView.getTag(2131296418)).booleanValue();
    }
    float f = paramFloat;
    if (this.mIsQzoneDefaultScale)
    {
      f = paramFloat;
      if (!bool) {
        f = Math.min(1.0F, paramFloat);
      }
    }
    return f;
  }
  
  protected void disPatchToParent() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.mSelectedChild != null) {
      this.mSelectedChild.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public void enableDoubleTap(boolean paramBoolean)
  {
    this.mDoubleTapEnable = paramBoolean;
  }
  
  public void enableScaleGesture(boolean paramBoolean)
  {
    this.mScaleGestureEnable = paramBoolean;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new Gallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Gallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new Gallery.LayoutParams(paramLayoutParams);
  }
  
  @TargetApi(11)
  protected Rect getChildBounds(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      paramView = new Rect();
    }
    do
    {
      return paramView;
      tmp2.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
      getChildMatrix(paramView).mapRect(tmp2);
      tmp2.offset(paramView.getLeft(), paramView.getTop());
      tmp2.round(paramRect);
      paramView = paramRect;
    } while (paramRect.width() >= this.mWidth);
    int i = (this.mWidth - paramRect.width()) / 2;
    int j = this.mWidth;
    int k = paramRect.width();
    paramRect.set(paramRect.left - i, paramRect.top, j - k - i + paramRect.right, paramRect.bottom);
    return paramRect;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mSelectedPosition - this.mFirstPosition;
    if (i < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i;
      }
    } while (paramInt2 < i);
    return paramInt2 + 1;
  }
  
  int getChildHeight(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  public Matrix getChildMatrix(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (VersionUtils.isHoneycomb()) {
      return paramView.getMatrix();
    }
    return Gallery.TransformationInfo.access$100(getChildTransformationInfo(paramView));
  }
  
  protected float getChildMaxumScale(View paramView)
  {
    return this.mMaxumScale;
  }
  
  @TargetApi(11)
  protected float getChildScale(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      return paramView.getScaleX();
    }
    return getChildTransformationInfo(paramView).mScaleX;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramView = (Gallery.TransformationInfo)paramView.getTag(2131296388);
    if (paramView != null)
    {
      updateMatrix(paramView);
      paramTransformation.getMatrix().set(Gallery.TransformationInfo.access$100(paramView));
      return true;
    }
    return false;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
  }
  
  protected int getLimitedMotionScrollAmount(boolean paramBoolean, int paramInt1, int paramInt2, Point paramPoint)
  {
    int i;
    if (paramBoolean)
    {
      i = this.mItemCount - 1;
      if (paramInt2 >= 0) {
        break label113;
      }
    }
    View localView;
    label113:
    for (int j = 1;; j = 0)
    {
      localView = getChildAt(i - this.mFirstPosition);
      if ((localView != null) || (this.mScrollState == 1) || (((!paramBoolean) || (!this.mIsRightedge)) && ((paramBoolean) || (!this.mIsLeftEdge)))) {
        break label180;
      }
      if ((this.mScrollState != 0) && (Math.abs(paramInt1) <= Math.abs(paramInt2))) {
        break label119;
      }
      paramPoint.x = paramInt1;
      paramPoint.y = 0;
      this.mScrollState = 0;
      return this.mScrollState;
      i = 0;
      break;
    }
    label119:
    getChildBounds(this.mSelectedChild, tmp);
    if (tmp.height() <= this.mHeight)
    {
      paramPoint.x = 0;
      paramPoint.y = 0;
      if (j == 0) {
        disPatchToParent();
      }
      return this.mScrollState;
    }
    this.mIsRightedge = false;
    this.mIsLeftEdge = false;
    label180:
    if (this.mScrollState != 0) {
      this.mScrollState = 1;
    }
    if (((paramBoolean) && (!this.mIsRightedge)) || ((!paramBoolean) && (!this.mIsLeftEdge))) {
      localView = this.mSelectedChild;
    }
    for (;;)
    {
      getChildBounds(localView, tmp);
      i = calculateDampingDeltaX(paramBoolean, paramInt1);
      this.scrollX += i;
      this.scrollY += paramInt2;
      if (tmp.height() < this.mHeight)
      {
        disPatchToParent();
        paramInt1 = 0;
        if (i <= this.mWidth) {
          break label425;
        }
        paramInt2 = this.mWidth;
      }
      for (;;)
      {
        paramPoint.x = paramInt2;
        paramPoint.y = paramInt1;
        return this.mScrollState;
        if (j != 0)
        {
          j = this.mHeight - this.mSpinnerPadding.bottom - tmp.bottom;
          if (j > 0)
          {
            paramInt1 = paramInt2 / 4;
            break;
          }
          paramInt1 = paramInt2;
          if (i >= j) {
            break;
          }
          paramInt1 = (paramInt2 - j) / 6 + j;
          break;
        }
        j = this.mSpinnerPadding.top - tmp.top;
        if (j < 0)
        {
          paramInt1 = paramInt2 / 4;
          disPatchToParent();
          break;
        }
        paramInt1 = paramInt2;
        if (i <= j) {
          break;
        }
        paramInt1 = (paramInt2 - j) / 6 + j;
        break;
        label425:
        if (i < -this.mWidth) {
          paramInt2 = -this.mWidth;
        } else {
          paramInt2 = i;
        }
      }
    }
  }
  
  public Gallery.OnItemRotateListener getOnItemRotateListener()
  {
    return this.mOnItemRotateListener;
  }
  
  public Gallery.OnScollListener getOnScollListener()
  {
    return this.mOnScollListener;
  }
  
  public boolean isNeedSetLongPicAction()
  {
    return false;
  }
  
  public void isQzoneDefaultScale(boolean paramBoolean)
  {
    this.mIsQzoneDefaultScale = paramBoolean;
  }
  
  public boolean isRotateEnable()
  {
    return this.isRotateEnable;
  }
  
  public boolean isZoomed()
  {
    if (this.mSelectedChild == null) {
      return false;
    }
    float f = 1.0F;
    if (this.mSelectedChild.getTag(2131296392) != null)
    {
      f = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      if (Math.abs(getChildScale(this.mSelectedChild) - f) < 1.E-005D) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (this.mSelectedChild.getTag(2131296385) != null)
      {
        f = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
        break;
      }
      if (!(this.mSelectedChild.getTag(2131296386) instanceof Float)) {
        break;
      }
      f = ((Float)this.mSelectedChild.getTag(2131296386)).floatValue();
      break;
    }
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      resetList();
      return;
    }
    paramInt = getChildCount();
    int i = this.mSelectedPosition - this.mFirstPosition;
    if ((i >= 0) && (i < paramInt)) {}
    for (View localView = getChildAt(i);; localView = null)
    {
      if (this.mNextSelectedPosition >= 0)
      {
        paramInt = this.mNextSelectedPosition;
        paramInt = this.mSelectedPosition;
      }
      if (this.mNextSelectedPosition >= 0) {
        setSelectedPositionInt(this.mNextSelectedPosition);
      }
      recycleAllViews();
      detachAllViewsFromParent();
      if (this.mOnSizeChanged)
      {
        this.mRecycler.clear();
        this.dy = 0;
        this.dx = 0;
        localView = null;
      }
      this.mRightMost = 0;
      this.mLeftMost = 0;
      this.mFirstPosition = this.mSelectedPosition;
      if ((getAdapter().hasStableIds()) && (localView != null) && (this.mSelectedRowId == this.mOldSelectedRowId))
      {
        paramInt = 1;
        i = this.mSelectedPosition;
        int j = this.dx;
        if (paramInt != 0) {
          localObject = localView;
        }
        makeAndAddView(i, 0, j, true, localObject);
        if (this.dx >= 0) {
          break label282;
        }
        fillToGalleryRight();
        label215:
        if (this.mShouldStopFling)
        {
          this.dx = 0;
          this.dy = 0;
        }
        if (!this.mClearByTag) {
          break label289;
        }
        this.mRecycler.clearByTag();
      }
      for (;;)
      {
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
        return;
        paramInt = 0;
        break;
        label282:
        fillToGalleryLeft();
        break label215;
        label289:
        this.mRecycler.clear();
      }
    }
  }
  
  boolean moveNext()
  {
    return false;
  }
  
  boolean movePrevious()
  {
    return false;
  }
  
  void onCancel()
  {
    onUp();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    setOnScollListener(null);
    setOnItemRotateListener(null);
    setOnDragListener(null);
    setOnItemRotateListener(null);
    removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.mDoubleTapEnable) {}
    float f1;
    float f2;
    do
    {
      return true;
      this.mIsDoubleTapping = true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (this.mSelectedChild == null);
    setPivot(f1, f2);
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.mScrollState == 2) {
      this.mScrollState = 0;
    }
    for (;;)
    {
      this.mFlingRunnable.stop(false);
      this.mDownTouchPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.mDownTouchPosition >= 0)
      {
        this.mDownTouchView = getChildAt(this.mDownTouchPosition - this.mFirstPosition);
        this.mDownTouchView.setPressed(true);
      }
      this.mIsFirstScroll = true;
      this.scrollX = 0;
      this.scrollY = 0;
      getChildBounds(this.mSelectedChild, tmp);
      if (tmp.width() != this.mWidth) {
        break;
      }
      this.mIsRightedge = true;
      this.mIsLeftEdge = true;
      return true;
      resetScrollState();
    }
    if (tmp.left == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mIsLeftEdge = bool1;
      bool1 = bool2;
      if (tmp.right == this.mWidth) {
        bool1 = true;
      }
      this.mIsRightedge = bool1;
      return true;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.mShouldCallbackDuringFling)
    {
      removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
      if (!this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = true;
      }
    }
    this.mVelocityTracker.computeCurrentVelocity(1000);
    paramFloat1 = this.mVelocityTracker.getXVelocity();
    paramFloat2 = this.mVelocityTracker.getYVelocity();
    int i;
    int j;
    label154:
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    float f;
    if (getChildCount() <= 1)
    {
      getChildBounds(this.mSelectedChild, tmp);
      i = this.mWidth + this.mSpinnerPadding.left - tmp.right;
      j = this.mSpinnerPadding.left - tmp.left;
      if ((tmp.height() < this.mHeight) && (tmp.width() <= this.mWidth))
      {
        scrollIntoSlots();
        if (this.mScrollState != 0) {
          break label693;
        }
        this.mScrollState = 2;
        if (this.mScrollingRegion) {
          this.mScrollingRegion = false;
        }
        return true;
      }
      if (tmp.height() < this.mHeight)
      {
        k = this.mSpinnerPadding.top;
        m = (this.mHeight - tmp.bottom + tmp.top) / 2;
        n = tmp.top;
        i1 = this.mHeight;
        i2 = (this.mHeight - tmp.bottom + tmp.top) / 2;
        i3 = tmp.bottom;
        f = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        if (f <= this.mMaximumVelocity) {
          break label707;
        }
        paramFloat1 = this.mMaximumVelocity * paramFloat1 / f;
        paramFloat2 = 0.0F;
      }
    }
    label693:
    label707:
    for (;;)
    {
      this.mFlingRunnable.startUsingVelocity((int)paramFloat1, (int)paramFloat2, i, j, k + m - n, i1 - i2 - i3);
      break;
      k = this.mHeight;
      m = this.mSpinnerPadding.top;
      n = tmp.bottom;
      i1 = this.mSpinnerPadding.top;
      i2 = tmp.top;
      f = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (f > this.mMaximumVelocity)
      {
        paramFloat1 = paramFloat1 * this.mMaximumVelocity / f;
        paramFloat2 = paramFloat2 * this.mMaximumVelocity / f;
      }
      for (;;)
      {
        this.mFlingRunnable.startUsingVelocity((int)paramFloat1, (int)paramFloat2, i, j, k + m - n, i1 - i2);
        break;
        if (paramFloat1 < 0.0F)
        {
          i = getChildBounds(getChildAt(1), tmp).left;
          getChildBounds(getChildAt(0), tmp);
          if (i == 0) {
            return true;
          }
          if (this.mFlingRunnable.calcFlingDistance(i, (int)paramFloat1) <= this.mSpinnerPadding.left)
          {
            this.mFlingRunnable.startUsingVelocity((int)paramFloat1, 0, this.mSpinnerPadding.left - i, 2147483647, 0, 0);
            break;
          }
          if (paramFloat1 < -this.mMinimumVelocity)
          {
            this.mFlingRunnable.startUsingDistance(this.mSpinnerPadding.left - i, 0);
            break;
          }
          scrollIntoSlots();
          break;
        }
        i = this.mWidth + this.mSpinnerPadding.left;
        j = getChildBounds(getChildAt(0), tmp).right;
        if (j == i) {
          return true;
        }
        if (this.mFlingRunnable.calcFlingDistance(j, (int)paramFloat1) >= i)
        {
          this.mFlingRunnable.startUsingVelocity((int)paramFloat1, 0, -2147483648, i - j, 0, 0);
          break;
        }
        if (paramFloat1 > this.mMinimumVelocity)
        {
          this.mFlingRunnable.startUsingDistance(i - j, 0);
          break;
        }
        scrollIntoSlots();
        break;
        if (this.mScrollState != 1) {
          break label154;
        }
        break label154;
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectedChild != null))
    {
      this.mSelectedChild.requestFocus(paramInt);
      this.mSelectedChild.setSelected(true);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.interceptTouchEventReturn;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!movePrevious());
        playSoundEffect(1);
        return true;
      } while (!moveNext());
      playSoundEffect(3);
      return true;
      this.mReceivedInvokeKeyDown = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.mReceivedInvokeKeyDown) && (this.mItemCount > 0))
    {
      dispatchPress(this.mSelectedChild);
      postDelayed(new Gallery.2(this), ViewConfiguration.getPressedStateDuration());
      performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
    }
    this.mReceivedInvokeKeyDown = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f = getResources().getDisplayMetrics().density;
    this.mWidth = (getRight() - getLeft() - this.mSpinnerPadding.left - this.mSpinnerPadding.right);
    this.mHeight = (getBottom() - getTop() - this.mSpinnerPadding.top - this.mSpinnerPadding.bottom);
    this.mWidthMultDensity = ((int)Math.ceil(this.mWidth * f));
    this.mHeightMultDensity = ((int)Math.ceil(f * this.mHeight));
    this.mInLayout = true;
    layout(0, false);
    this.mInLayout = false;
    this.mOnSizeChanged = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.mIsMultiTouch) {
      return;
    }
    long l = getItemIdAtPosition(this.mSelectedPosition);
    dispatchLongPress(this.mDownTouchView, this.mSelectedPosition, l);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    if ((i == 1073741824) && (j == 1073741824))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.mSelectedChild == null) || (this.mScrollState == 0)) {
      return false;
    }
    float f1 = paramScaleGestureDetector.getFocusX();
    float f2 = paramScaleGestureDetector.getFocusY();
    float f3 = f1 - this.focusX;
    float f4 = f2 - this.focusY;
    this.focusX = f1;
    this.focusY = f2;
    if (VersionUtils.isHoneycomb())
    {
      setChildTranslation(this.mSelectedChild, (int)f3, (int)f4);
      setPivot(f1, f2);
      f3 = paramScaleGestureDetector.getCurrentSpan() / this.beginSpan;
      f2 = f3 * this.beginScale;
      if (this.mSelectedChild.getTag(2131296392) == null) {
        break label288;
      }
      f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      label125:
      if (f1 > 1.0F) {
        break label443;
      }
    }
    label149:
    label288:
    label438:
    label443:
    for (f1 = f1 * f1 * 0.6F * 0.6F;; f1 = 0.6F)
    {
      if (f2 < f1) {}
      for (;;)
      {
        setChildScale(this.mSelectedChild, f1);
        Boolean localBoolean = (Boolean)this.mSelectedChild.getTag(2131296390);
        if ((this.isRotateEnable) && (this.canRotating) && (localBoolean != null) && (localBoolean.booleanValue()))
        {
          if (!this.isRotating) {
            break label347;
          }
          f2 = (float)((getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          setChildRotation(this.mSelectedChild, f1 + this.beginRotation);
        }
        for (;;)
        {
          return true;
          this.mSelectedChild.offsetLeftAndRight((int)f3);
          this.mSelectedChild.offsetTopAndBottom((int)f4);
          break;
          if (this.mSelectedChild.getTag(2131296385) != null)
          {
            f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
            break label125;
          }
          f1 = 1.0F;
          break label125;
          if (f2 <= this.mMaxumScale * 1.5F) {
            break label438;
          }
          f1 = this.mMaxumScale * 1.5F;
          break label149;
          label347:
          if (f3 <= 0.95F)
          {
            this.isRotating = true;
            f2 = (float)((getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793D * 180.0D);
            f1 = f2;
            if (f2 > 180.0F) {
              f1 = f2 - 360.0F;
            }
            setChildRotation(this.mSelectedChild, f1 + this.beginRotation);
          }
          else if (f3 >= 1.05F)
          {
            this.canRotating = false;
          }
        }
        f1 = f2;
      }
    }
  }
  
  @TargetApi(11)
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.isRotating = false;
    if ((this.mSelectedChild == null) || (this.mScrollState == 0)) {}
    Drawable localDrawable;
    do
    {
      return false;
      if ((VersionUtils.isHoneycomb()) || (!(this.mSelectedChild instanceof ImageView))) {
        break;
      }
      localDrawable = ((ImageView)this.mSelectedChild).getDrawable();
    } while (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)));
    this.vectorRotation = getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY());
    this.beginRotation = getChildRotation(this.mSelectedChild);
    float f1 = 1.0F;
    if (this.mSelectedChild.getTag(2131296392) != null)
    {
      f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      label129:
      if (getChildScale(this.mSelectedChild) > f1 + 1.0E-005F) {
        break label308;
      }
    }
    label308:
    for (boolean bool = true;; bool = false)
    {
      this.canRotating = bool;
      f1 = paramScaleGestureDetector.getFocusX();
      float f2 = paramScaleGestureDetector.getFocusY();
      this.mIsLeftEdge = false;
      this.mIsRightedge = false;
      setPivot(f1, f2);
      this.focusX = f1;
      this.focusY = f2;
      this.beginSpan = paramScaleGestureDetector.getCurrentSpan();
      this.beginScale = getChildScale(this.mSelectedChild);
      this.mIsScaling = true;
      if (canUpdateRegionRect()) {
        updateShowArea(false);
      }
      return true;
      if ((this.mSelectedChild.getTag(2131296400) == null) || (!(this.mSelectedChild.getTag(2131296400) instanceof Boolean)) || (!((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue())) {
        break;
      }
      return false;
      if (this.mSelectedChild.getTag(2131296385) == null) {
        break label129;
      }
      f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
      break label129;
    }
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1;
    if (this.mSelectedChild != null)
    {
      f1 = 1.0F;
      if (this.mSelectedChild.getTag(2131296392) == null) {
        break label83;
      }
      f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      float f2 = getChildScale(this.mSelectedChild);
      if ((f2 <= f1) || (f2 > this.mMaxumScale)) {
        break label130;
      }
      if (!canUpdateRegionRect()) {
        break label114;
      }
      updateShowArea(true);
    }
    for (;;)
    {
      resetScrollState();
      this.canRotating = true;
      return;
      label83:
      if (this.mSelectedChild.getTag(2131296385) == null) {
        break;
      }
      f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
      break;
      label114:
      onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
      continue;
      label130:
      updateShowArea(false);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.mShouldCallbackDuringFling) {
      if (this.mIsFirstScroll)
      {
        if (!this.mSuppressSelectionChanged) {
          this.mSuppressSelectionChanged = true;
        }
        postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
      }
    }
    for (;;)
    {
      trackMotionScroll((int)paramFloat1 * -1, (int)paramFloat2 * -1, true);
      if ((this.mSelectedChild != null) && (this.mScrollState == 1) && (canUpdateRegionRect()))
      {
        if (!this.mScrollingRegion) {
          this.mScrollingRegion = true;
        }
        updateShowArea(true, 1);
      }
      this.mIsFirstScroll = false;
      return true;
      if (this.mSuppressSelectionChanged) {
        this.mSuppressSelectionChanged = false;
      }
    }
  }
  
  protected void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.mAdapter != null)
    {
      performItemClick(this.mDownTouchView, this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
      return true;
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mOnSizeChanged = true;
  }
  
  protected void onSlotChanged(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mItemCount == 0) {
      return false;
    }
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.mIsMultiTouch = true;
      if (!this.mScaleGestureEnable) {
        break label136;
      }
      bool = this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      int i = paramMotionEvent.getAction();
      if (i == 1)
      {
        onUp();
        recycleVelocityTracker();
        this.mIsScaling = false;
      }
      for (;;)
      {
        if ((i & 0xFF) == 2) {
          this.lastMoveTime = AnimationUtils.currentAnimationTimeMillis();
        }
        return bool;
        if (this.mIsScaling) {
          break label136;
        }
        this.mIsMultiTouch = false;
        bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
        break;
        if (i == 3)
        {
          onCancel();
          recycleVelocityTracker();
          this.mIsScaling = false;
        }
      }
      label136:
      bool = false;
    }
  }
  
  public void onUp()
  {
    Object localObject;
    if ((!VersionUtils.isHoneycomb()) && ((this.mSelectedChild instanceof ImageView)))
    {
      localObject = ((ImageView)this.mSelectedChild).getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {}
    }
    label391:
    label407:
    label418:
    label698:
    for (int i = 1;; i = 0)
    {
      float f1;
      float f2;
      if ((this.mIsDoubleTapping) && (i == 0))
      {
        this.mIsLeftEdge = false;
        this.mIsRightedge = false;
        f1 = 1.0F;
        if ((this.mSelectedChild == null) || (((this.mSelectedChild.getTag(2131296400) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue()))) {
          return;
        }
        f2 = getChildScale(this.mSelectedChild);
        if (this.mSelectedChild.getTag(2131296392) != null) {
          if (isNeedSetLongPicAction())
          {
            f1 = ((Float)this.mSelectedChild.getTag(2131296414)).floatValue();
            if (Math.abs(f2 - f1) >= 1.E-005D) {
              break label750;
            }
            f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
          }
        }
      }
      label230:
      label235:
      label750:
      for (;;)
      {
        if (Math.abs(f2 - f1) >= 1.E-005D)
        {
          if (f2 >= f1) {
            break label698;
          }
          if (!canUpdateRegionRect()) {
            onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
          }
          scrollIntoSlots(f1);
          this.mIsDoubleTapping = false;
          dispatchUnpress();
          if (!this.mScrollingRegion) {
            break;
          }
          this.mScrollingRegion = false;
          this.mScrollDirection = 0;
          if (!canUpdateRegionRect()) {
            break;
          }
          updateShowArea(true);
          return;
          f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
          continue;
          if (this.mSelectedChild.getTag(2131296385) == null) {
            continue;
          }
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
          continue;
        }
        int n = getMeasuredWidth();
        int i1 = getMeasuredHeight();
        if (this.mSelectedChild.getTag(2131296389) != null) {}
        for (i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();; i = 0)
        {
          int j;
          int k;
          int m;
          if ((i == 1) || (i == 3))
          {
            j = this.mSelectedChild.getMeasuredHeight();
            i = this.mSelectedChild.getMeasuredWidth();
            if ((j > n) || (i > i1)) {
              break label516;
            }
            k = 1;
            if (i < j * 3) {
              break label522;
            }
            m = 1;
            if ((k == 0) || (((this.mSelectedChild.getTag(2131296417) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296417)).booleanValue()))) {
              break label536;
            }
            if (this.mSelectedChild.getTag(2131296413) == null) {
              break label528;
            }
            f1 = ((Float)this.mSelectedChild.getTag(2131296413)).floatValue();
          }
          for (;;)
          {
            f1 = Math.min(f1, this.mMaxumScale);
            break;
            j = this.mSelectedChild.getMeasuredWidth();
            i = this.mSelectedChild.getMeasuredHeight();
            break label391;
            k = 0;
            break label407;
            m = 0;
            break label418;
            f1 = this.mMaxumScale;
            continue;
            if (m != 0)
            {
              f1 = Math.min(n / j, this.mMaxumScale);
              if ((this.mSelectedChild.getTag(2131296416) instanceof Float)) {
                f1 = ((Float)this.mSelectedChild.getTag(2131296416)).floatValue();
              }
            }
            else
            {
              localObject = getImageSize(this.mSelectedChild);
              k = ((Rect)localObject).right - ((Rect)localObject).left;
              m = ((Rect)localObject).bottom;
              int i2 = ((Rect)localObject).top;
              if (k < n)
              {
                if (k * 1.5F >= n) {
                  f1 = 2.0F * f1;
                } else {
                  f1 = n / j;
                }
              }
              else if ((m - i2) * 1.5F >= i1) {
                f1 = 2.0F * f1;
              } else {
                f1 = i1 / i;
              }
            }
          }
          if (!canUpdateRegionRect()) {
            break label230;
          }
          updateShowArea(false);
          break label230;
          if (!Gallery.FlingRunnable.access$400(this.mFlingRunnable).isFinished()) {
            break label235;
          }
          scrollIntoSlots();
          if (this.mScrollState != 0) {
            break label235;
          }
          this.mScrollState = 2;
          break label235;
        }
      }
    }
  }
  
  public void onUpForQzone(float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    if ((!VersionUtils.isHoneycomb()) && ((this.mSelectedChild instanceof ImageView)))
    {
      localObject = ((ImageView)this.mSelectedChild).getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {}
    }
    label146:
    label407:
    label539:
    for (int i = 1;; i = 0)
    {
      float f1;
      float f2;
      int n;
      int i1;
      if ((this.mIsDoubleTapping) && (i == 0))
      {
        this.mIsLeftEdge = false;
        this.mIsRightedge = false;
        f1 = 1.0F;
        if ((this.mSelectedChild == null) || (((this.mSelectedChild.getTag(2131296400) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue()))) {
          return;
        }
        if (this.mSelectedChild.getTag(2131296392) != null)
        {
          f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
          f2 = getChildScale(this.mSelectedChild);
          n = getMeasuredWidth();
          i1 = getMeasuredHeight();
          if (this.mSelectedChild.getTag(2131296389) == null) {
            break label586;
          }
        }
      }
      label299:
      label586:
      for (i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();; i = 0)
      {
        int j;
        label227:
        int k;
        label244:
        int m;
        if ((i == 1) || (i == 3))
        {
          j = this.mSelectedChild.getMeasuredHeight();
          i = this.mSelectedChild.getMeasuredWidth();
          if ((j > n) || (i > i1)) {
            break label395;
          }
          k = 1;
          if (i < j * 3) {
            break label401;
          }
          m = 1;
          if (k == 0) {
            break label407;
          }
          f1 = this.mMaxumScale;
          paramFloat = Math.min(paramFloat, f1);
          if (f2 >= paramFloat) {
            break label539;
          }
          if (!canUpdateRegionRect()) {
            onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
          }
          scrollIntoSlots(paramFloat);
        }
        for (;;)
        {
          this.mIsDoubleTapping = false;
          dispatchUnpress();
          if (!this.mScrollingRegion) {
            break;
          }
          this.mScrollingRegion = false;
          this.mScrollDirection = 0;
          if (!canUpdateRegionRect()) {
            break;
          }
          updateShowArea(true);
          return;
          if (this.mSelectedChild.getTag(2131296385) == null) {
            break label146;
          }
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
          break label146;
          j = this.mSelectedChild.getMeasuredWidth();
          i = this.mSelectedChild.getMeasuredHeight();
          break label227;
          k = 0;
          break label244;
          m = 0;
          break label256;
          if (m != 0)
          {
            f1 = Math.min(n / j, this.mMaxumScale);
            break label266;
          }
          localObject = getImageSize(this.mSelectedChild);
          k = ((Rect)localObject).right - ((Rect)localObject).left;
          m = ((Rect)localObject).bottom;
          int i2 = ((Rect)localObject).top;
          if (k < n)
          {
            if (k * 1.5F >= n)
            {
              f1 *= 2.0F;
              break label266;
            }
            f1 = n / j;
            break label266;
          }
          if ((m - i2) * 1.5F >= i1)
          {
            f1 *= 2.0F;
            break label266;
          }
          f1 = i1 / i;
          break label266;
          if (!canUpdateRegionRect()) {
            break label299;
          }
          updateShowArea(false);
          break label299;
          if (Gallery.FlingRunnable.access$400(this.mFlingRunnable).isFinished())
          {
            scrollIntoSlots();
            if (this.mScrollState == 0) {
              this.mScrollState = 2;
            }
          }
        }
      }
    }
  }
  
  protected void onViewContentMoved(boolean paramBoolean, int paramInt1, Point paramPoint, int paramInt2, Rect paramRect) {}
  
  protected void onViewCreated(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  protected void onZoomBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0)
      {
        getChildBounds(localView, tmp);
        if (tmp.contains(paramInt1, paramInt2)) {
          return i + this.mFirstPosition;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public void reset()
  {
    this.dx = 0;
  }
  
  public boolean resetScale(boolean paramBoolean)
  {
    this.mIsLeftEdge = false;
    this.mIsRightedge = false;
    if (this.mSelectedChild == null) {
      return false;
    }
    Object localObject = this.mSelectedChild.getTag(2131296385);
    if ((localObject == null) || (!(localObject instanceof Float))) {
      return false;
    }
    float f1 = ((Float)localObject).floatValue();
    float f2 = getChildScale(this.mSelectedChild);
    if ((f2 < f1) || ((Math.abs(f2 - f1) < 1.E-005D) && (!paramBoolean))) {
      return false;
    }
    scrollIntoSlots(f1 * this.mMinumScale);
    return true;
  }
  
  public void scrollIntoSlots(float paramFloat)
  {
    int i = getChildCount();
    if ((i == 0) || (this.mSelectedChild == null)) {
      return;
    }
    View localView = getChildAt(0);
    float f2;
    if (i == 1)
    {
      f2 = getChildScale(this.mSelectedChild);
      if (this.mSelectedChild.getTag(2131296389) == null) {
        break label829;
      }
    }
    label268:
    label569:
    label826:
    label829:
    for (i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();; i = 0)
    {
      float f1;
      label101:
      float f3;
      int j;
      float f5;
      float f6;
      int k;
      if ((this.mSelectedChild.getTag(2131296392) instanceof Float))
      {
        f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
        f3 = getChildRotation(this.mSelectedChild);
        j = getRotationFlag((int)f3, i);
        f5 = getRotationInternal((int)f3, j);
        f6 = j * 90;
        k = this.mSelectedChild.getMeasuredWidth();
        int m = this.mSelectedChild.getMeasuredHeight();
        int n = getMeasuredWidth();
        int i1 = getMeasuredHeight();
        if (paramFloat != 0.0F) {
          break label826;
        }
        if (j == i) {
          break label489;
        }
        this.mSelectedChild.setTag(2131296389, Integer.valueOf(j));
        Gallery.ScaleViewHolder localScaleViewHolder = getChildGravityAndScale(k, m, n, i1, this.mSelectedChild);
        f1 = localScaleViewHolder.defaultScale;
        this.mSelectedChild.setTag(2131296385, Float.valueOf(localScaleViewHolder.defaultScale));
        paramFloat = f1;
        if (this.mOnItemRotateListener != null)
        {
          this.mOnItemRotateListener.onRotateFinished(this.mSelectedChild, getSelectedItemPosition(), j);
          paramFloat = f1;
        }
      }
      for (;;)
      {
        j = 0;
        i = 0;
        if ((f2 != paramFloat) || (f6 != f5))
        {
          setChildScale(this.mSelectedChild, paramFloat);
          setChildRotation(this.mSelectedChild, f6);
          getChildBounds(this.mSelectedChild, tmp);
          setChildScale(this.mSelectedChild, f2);
          setChildRotation(this.mSelectedChild, f5);
          label338:
          if (tmp.right >= this.mWidth + this.mSpinnerPadding.left) {
            break label569;
          }
          j = this.mWidth + this.mSpinnerPadding.left - tmp.right;
          label380:
          if (tmp.height() >= this.mHeight) {
            break label604;
          }
          i = this.mSpinnerPadding.top + (this.mHeight - tmp.height()) / 2 - tmp.top;
        }
        for (;;)
        {
          if ((f2 == paramFloat) && (f6 == f5)) {
            break label684;
          }
          this.mFlingRunnable.startUsingDistance(j, i, f2, paramFloat, f5, f6);
          return;
          if (!(this.mSelectedChild.getTag(2131296385) instanceof Float)) {
            break;
          }
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
          break label101;
          label489:
          f3 = Math.min(f1, this.mMinumScale);
          float f4 = Math.max(f1, this.mMaxumScale);
          if (Math.abs(f2 - f1) < 1.E-005D)
          {
            paramFloat = f1;
            break label268;
          }
          paramFloat = f3;
          if (f2 < f3) {
            break label268;
          }
          if (f2 > f4)
          {
            paramFloat = f4;
            break label268;
          }
          paramFloat = f2;
          break label268;
          getChildBounds(localView, tmp);
          break label338;
          if (tmp.left <= this.mSpinnerPadding.left) {
            break label380;
          }
          j = this.mSpinnerPadding.left - tmp.left;
          break label380;
          label604:
          if (tmp.top > this.mSpinnerPadding.top) {
            i = this.mSpinnerPadding.top - tmp.top;
          } else if (tmp.bottom < this.mHeight + this.mSpinnerPadding.top) {
            i = this.mHeight + this.mSpinnerPadding.top - tmp.bottom;
          }
        }
        this.mFlingRunnable.startUsingDistance(j, i);
        return;
        if (tmp.right + this.mSpacing / 2 > this.mSpinnerPadding.left + this.mWidth / 2)
        {
          getChildBounds(localView, tmp);
          i = this.mSpinnerPadding.left;
          j = this.mWidth;
          k = tmp.right;
          this.mFlingRunnable.startUsingDistance(i + j - k, 0);
          return;
        }
        getChildBounds(localView, tmp);
        i = this.mSpinnerPadding.left;
        j = tmp.right;
        k = this.mSpacing;
        this.mFlingRunnable.startUsingDistance(i - j - k, 0);
        return;
      }
    }
  }
  
  void selectionChanged()
  {
    if (!this.mSuppressSelectionChanged) {
      super.selectionChanged();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    this.mSelectedChild = null;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.mAnimationDuration = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.mShouldCallbackDuringFling = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.mShouldCallbackOnUnselectedItemClick = paramBoolean;
  }
  
  public void setClearByTag(boolean paramBoolean)
  {
    this.mClearByTag = paramBoolean;
  }
  
  public void setInterceptTouchEventReturn(boolean paramBoolean)
  {
    this.interceptTouchEventReturn = paramBoolean;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.mMaxumScale = paramFloat;
  }
  
  public void setOnItemRotateListener(Gallery.OnItemRotateListener paramOnItemRotateListener)
  {
    this.mOnItemRotateListener = paramOnItemRotateListener;
  }
  
  public void setOnScollListener(Gallery.OnScollListener paramOnScollListener)
  {
    this.mOnScollListener = paramOnScollListener;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.isRotateEnable = paramBoolean;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    updateSelectedItemMetadata();
  }
  
  public void setSelectionToNothing()
  {
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    checkSelectionChanged();
  }
  
  public void setSpacing(int paramInt)
  {
    this.mSpacing = paramInt;
  }
  
  public void setSupportMatchParent(boolean paramBoolean)
  {
    this.mSupportMatchParent = paramBoolean;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.mSelectedPosition >= 0)) {
      return dispatchLongPress(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i = getPositionForView(paramView);
    if (i < 0) {
      return false;
    }
    return dispatchLongPress(paramView, i, this.mAdapter.getItemId(i));
  }
  
  protected void trackMotionScroll(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((getChildCount() == 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    boolean bool;
    if (paramInt1 < 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label109;
      }
      this.mScrollDirection = 0;
      label32:
      if (!paramBoolean) {
        break label129;
      }
      getLimitedMotionScrollAmount(bool, paramInt1, paramInt2, this.tmpP);
    }
    for (;;)
    {
      onViewContentMoved(bool, paramInt1, this.tmpP, this.mWidth, this.mSpinnerPadding);
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        setChildTranslation(getChildAt(paramInt1), this.tmpP.x, 0);
        paramInt1 -= 1;
      }
      bool = false;
      break;
      label109:
      if (paramInt1 < 0)
      {
        this.mScrollDirection = 1;
        break label32;
      }
      this.mScrollDirection = 2;
      break label32;
      label129:
      this.tmpP.x = paramInt1;
      this.tmpP.y = paramInt2;
    }
    this.dx += this.tmpP.x;
    if ((this.mSelectedChild != null) && (this.mScrollState != 0))
    {
      setChildTranslation(this.mSelectedChild, 0, this.tmpP.y);
      this.dy += this.tmpP.y;
    }
    detachOffScreenChildren(bool);
    if (this.mSelectedChild != null) {
      if (this.mSelectedChild.getParent() == null) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((bool) && (this.mIsRightedge)) {
        fillToGalleryRight();
      }
      for (;;)
      {
        this.mRecycler.clear();
        if (paramInt1 != 0) {
          setSelectionToCenterChild();
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return;
        paramInt1 = 0;
        break;
        if ((!bool) && (this.mIsLeftEdge)) {
          fillToGalleryLeft();
        }
      }
      paramInt1 = 0;
    }
  }
  
  protected void updateShowArea(boolean paramBoolean, int paramInt)
  {
    if (this.mSelectedChild == null) {}
    View localView;
    int i;
    int j;
    Rect localRect;
    do
    {
      do
      {
        return;
        localView = this.mSelectedChild;
        i = getMeasuredWidth();
        j = getMeasuredHeight();
      } while ((i == 0) || (j == 0));
      localRect = new Rect();
      getChildBounds(localView, localRect);
    } while (!localRect.intersect(0, 0, i, j));
    localRect.offset(-localView.getLeft(), -localView.getTop());
    getChildMatrix(localView).invert(this.tempMatrix);
    Object localObject = new RectF(localRect);
    this.tempMatrix.mapRect((RectF)localObject);
    ((RectF)localObject).round(localRect);
    tmp.set(0, 0, localView.getWidth(), localView.getHeight());
    localRect.intersect(tmp);
    float f = getChildScale(localView);
    localObject = new RegionDrawableData();
    ((RegionDrawableData)localObject).mImageArea = tmp;
    ((RegionDrawableData)localObject).mShowArea = localRect;
    ((RegionDrawableData)localObject).mScale = f;
    ((RegionDrawableData)localObject).mState = paramInt;
    ((RegionDrawableData)localObject).mShowRegion = paramBoolean;
    ((RegionDrawableData)localObject).mScrollDirection = this.mScrollDirection;
    if (this.mSelectedChild.getTag(2131296392) != null) {
      ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296392)).floatValue();
    }
    for (;;)
    {
      onShowAreaChanged(this.mSelectedPosition, localView, (RegionDrawableData)localObject);
      return;
      if (localView.getTag(2131296385) != null) {
        ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296385)).floatValue();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.Gallery
 * JD-Core Version:    0.7.0.1
 */