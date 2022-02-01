package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
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
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import mqq.app.MobileQQ;

public class Gallery
  extends AbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  public static int AIO_IMAGE_MAX_SIZE = 135;
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
  protected static Rect tmp;
  private static RectF tmp2;
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
  
  static
  {
    BaseApplication localBaseApplication = MobileQQ.getContext();
    if (localBaseApplication != null) {
      AIO_IMAGE_MAX_SIZE = (int)DisplayUtils.a(localBaseApplication, 135.0F);
    }
    tmp = new Rect();
    tmp2 = new RectF();
  }
  
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
    if (!VersionUtils.e()) {
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
      if (VersionUtils.e())
      {
        setChildScale(paramView2, paramView1.getPivotX(), paramView1.getPivotY(), paramView1.getScaleX());
        return;
      }
      paramView2.setTag(2131296388, (Gallery.TransformationInfo)paramView1.getTag(2131296388));
    }
  }
  
  private void detachOffScreenChildren(boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = this.mFirstPosition;
    int i = 0;
    int m;
    int n;
    View localView;
    AbsSpinner.RecycleBin localRecycleBin;
    if (paramBoolean)
    {
      i3 = getPaddingLeft();
      j = 0;
      k = 0;
      for (;;)
      {
        m = j;
        n = k;
        if (i >= i2) {
          break;
        }
        localView = getChildAt(i);
        if (getChildBounds(localView, tmp).right > i3)
        {
          m = j;
          n = k;
          break;
        }
        j += 1;
        localRecycleBin = this.mRecycler;
        k = i1 + i;
        localRecycleBin.put(k, localView);
        onViewDetached(k, localView, this, paramBoolean);
        onViewCreated(k + 1, this, paramBoolean, true);
        k = i;
        i += 1;
      }
    }
    int i3 = getWidth();
    int i4 = getPaddingRight();
    i = i2 - 1;
    int j = 0;
    int k = 0;
    for (;;)
    {
      m = j;
      n = k;
      if (i < 0) {
        break;
      }
      localView = getChildAt(i);
      if (getChildBounds(localView, tmp).left < i3 - i4)
      {
        m = j;
        n = k;
        break;
      }
      j += 1;
      localRecycleBin = this.mRecycler;
      k = i1 + i;
      localRecycleBin.put(k, localView);
      onViewDetached(k, localView, this, paramBoolean);
      onViewCreated(k - 1, this, paramBoolean, true);
      k = i;
      i -= 1;
    }
    detachViewsFromParent(n, m);
    if (paramBoolean) {
      this.mFirstPosition += m;
    }
  }
  
  private boolean dispatchLongPress(View paramView, int paramInt, long paramLong)
  {
    boolean bool1;
    if (this.mOnItemLongClickListener != null) {
      bool1 = this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, paramInt, paramLong);
    } else {
      bool1 = false;
    }
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
    if (getChildCount() >= 2) {
      return;
    }
    int k = this.mSpacing;
    int m = getPaddingLeft();
    int n = this.mWidth;
    int i = 0;
    Object localObject = getChildAt(0);
    int j;
    if (localObject != null)
    {
      i = this.mFirstPosition - 1;
      j = getChildBounds((View)localObject, tmp).left - k;
    }
    else
    {
      j = getRight() - getLeft() - getPaddingRight();
      this.mShouldStopFling = true;
    }
    while ((j > m) && (i >= 0))
    {
      makeAndAddView(i, i - this.mSelectedPosition, j, false, null);
      localObject = this.mOnScollListener;
      if (localObject != null) {
        ((Gallery.OnScollListener)localObject).onScrollStart(i);
      }
      this.mFirstPosition = i;
      j -= n + k;
      i -= 1;
    }
  }
  
  private void fillToGalleryRight()
  {
    int i = getChildCount();
    if (i >= 2) {
      return;
    }
    int k = this.mSpacing;
    int m = getRight();
    int n = getLeft();
    int i1 = getPaddingRight();
    int i2 = this.mWidth;
    int i3 = this.mItemCount;
    Object localObject = getChildAt(i - 1);
    int j;
    if (localObject != null)
    {
      j = this.mFirstPosition + i;
      i = getChildBounds((View)localObject, tmp).right + k;
    }
    else
    {
      j = this.mItemCount - 1;
      this.mFirstPosition = j;
      i = getPaddingLeft();
      this.mShouldStopFling = true;
    }
    while ((i < m - n - i1) && (j < i3))
    {
      makeAndAddView(j, j - this.mSelectedPosition, i, true, null);
      localObject = this.mOnScollListener;
      if (localObject != null) {
        ((Gallery.OnScollListener)localObject).onScrollStart(j);
      }
      i += i2 + k;
      j += 1;
    }
  }
  
  public static float getAIOImageScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return 1.0F;
      }
      int i = paramInt2 * paramInt3 / paramInt1;
      int j = AIO_IMAGE_MAX_SIZE;
      float f1;
      if ((isLongPhoto(paramInt1, paramInt2)) && (paramInt1 <= paramInt3))
      {
        f1 = f2;
        if (paramInt2 <= paramInt4) {}
      }
      else if ((paramInt1 < j) && (paramInt2 < j))
      {
        f1 = f2;
      }
      else if (paramInt4 >= i)
      {
        f1 = paramInt3 / paramInt1;
      }
      else
      {
        f1 = paramInt4 / paramInt2;
      }
      return Math.min(f1, 2.0F);
    }
    return 1.0F;
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
    Gallery.ScaleViewHolder localScaleViewHolder = new Gallery.ScaleViewHolder(null);
    int k;
    if (paramView.getTag(2131296389) != null) {
      k = ((Integer)paramView.getTag(2131296389)).intValue();
    } else {
      k = 0;
    }
    localScaleViewHolder.defaultRotate = k;
    if ((paramView.getTag(2131296415) instanceof Integer)) {
      localScaleViewHolder.gravity = ((Integer)paramView.getTag(2131296415)).intValue();
    } else {
      localScaleViewHolder.gravity = 17;
    }
    if (paramView.getTag(2131296386) != null)
    {
      localScaleViewHolder.defaultScale = ((Float)paramView.getTag(2131296386)).floatValue();
      return localScaleViewHolder;
    }
    boolean bool = true;
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
    float f = getAIOImageScale(j, i, paramInt3, paramInt4);
    if (i >= j * 3) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && ((j > paramInt3) || (i > paramInt4)))
    {
      paramInt1 = AIO_IMAGE_MAX_SIZE;
      if ((j >= paramInt1) || (i >= paramInt1))
      {
        localScaleViewHolder.gravity = 49;
        localScaleViewHolder.defaultScale = Math.min(paramInt3 / j, this.mMaxumScale);
        localScaleViewHolder.isHighPic = true;
        paramView.setTag(2131296392, Float.valueOf(f));
        if (!isNeedSetLongPicAction()) {
          break label304;
        }
        paramView.setTag(2131296414, Float.valueOf(localScaleViewHolder.defaultScale));
        break label304;
      }
    }
    localScaleViewHolder.gravity = 17;
    localScaleViewHolder.isHighPic = false;
    localScaleViewHolder.defaultScale = customScale(paramView, f, j);
    label304:
    if ((paramView.getTag(2131296412) == null) || (!((Boolean)paramView.getTag(2131296412)).booleanValue())) {
      bool = false;
    }
    localScaleViewHolder.hasTransformed = bool;
    return localScaleViewHolder;
  }
  
  private Rect getChildLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    int j = getMeasuredWidth();
    int i = getMeasuredHeight();
    int k = paramInt3 & 0x70;
    if (k != 16)
    {
      if (k != 48)
      {
        if (k != 80) {
          i = 0;
        } else {
          i = i - this.mSpinnerPadding.bottom - paramInt2;
        }
      }
      else {
        i = this.mSpinnerPadding.top;
      }
    }
    else
    {
      k = this.mSpinnerPadding.bottom;
      int m = this.mSpinnerPadding.top;
      int n = this.mSpinnerPadding.top;
      i = (i - k - m - paramInt2) / 2 + n;
    }
    paramInt3 &= 0x7;
    if ((paramInt3 != 3) && (paramInt3 != 5))
    {
      paramInt3 = (j - this.mSpinnerPadding.left - this.mSpinnerPadding.right - paramInt1) / 2;
      if (paramBoolean) {
        paramInt4 += paramInt3;
      }
    }
    while (paramBoolean)
    {
      paramInt3 = paramInt1 + paramInt4;
      paramInt1 = paramInt4;
      paramInt4 = paramInt3;
      break;
      paramInt1 = paramInt4 - paramInt1 - paramInt3;
      paramInt4 -= paramInt3;
      break;
    }
    paramInt1 = paramInt4 - paramInt1;
    localRect.left = paramInt1;
    localRect.top = i;
    localRect.right = paramInt4;
    localRect.bottom = (paramInt2 + i);
    return localRect;
  }
  
  @TargetApi(11)
  private float[] getChildPivot(View paramView)
  {
    float f1;
    float f2;
    if (VersionUtils.e())
    {
      f1 = paramView.getPivotX();
      f2 = paramView.getPivotY();
    }
    else
    {
      f1 = getChildTransformationInfo(paramView).mPivotX;
      f2 = getChildTransformationInfo(paramView).mPivotY;
    }
    return new float[] { f1, f2 };
  }
  
  @TargetApi(11)
  private float getChildRotation(View paramView)
  {
    if (VersionUtils.e()) {
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
    float f1;
    float f2;
    if (VersionUtils.e())
    {
      f1 = paramView.getTranslationX();
      f2 = paramView.getTranslationY();
    }
    else
    {
      paramView = getChildTransformationInfo(paramView);
      f1 = paramView.mTranslationX;
      f2 = paramView.mTranslationY;
    }
    return new float[] { f1, f2 };
  }
  
  @TargetApi(11)
  private Rect getImageSize(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    Rect localRect = new Rect();
    tmp2.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix;
    if (VersionUtils.e()) {
      localMatrix = paramView.getMatrix();
    } else {
      localMatrix = Gallery.TransformationInfo.access$100(getChildTransformationInfo(paramView));
    }
    localMatrix.mapRect(tmp2);
    tmp2.offset(paramView.getLeft(), paramView.getTop());
    tmp2.round(localRect);
    return localRect;
  }
  
  private double getRadian(float paramFloat1, float paramFloat2)
  {
    double d2 = Math.atan(paramFloat2 / paramFloat1);
    if (paramFloat1 < 0.0F) {}
    for (double d1 = 3.141592653589793D;; d1 = 6.283185307179586D)
    {
      return d2 + d1;
      if (d2 >= 0.0D) {
        break;
      }
    }
    return d2;
  }
  
  private static int getRotationFlag(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = paramInt1 + (-paramInt1 + 360) / 360 * 360;
    }
    paramInt1 = i;
    if (i > 360) {
      paramInt1 = i % 360;
    }
    i = defaultminumangle;
    if ((paramInt2 == 1) || (paramInt2 == 3)) {
      i = 90 - defaultminumangle;
    }
    paramInt2 = 180 - i;
    int j = i + 180;
    int k = 360 - i;
    if (((paramInt1 >= 0) && (paramInt1 < i)) || (paramInt1 >= k)) {
      return 0;
    }
    if ((paramInt1 >= i) && (paramInt1 < paramInt2)) {
      return 1;
    }
    if ((paramInt1 >= paramInt2) && (paramInt1 < j)) {
      return 2;
    }
    if ((paramInt1 >= j) && (paramInt1 < k)) {
      return 3;
    }
    return 0;
  }
  
  private static int getRotationInternal(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < -45)
    {
      i = paramInt1 + (-paramInt1 + 360) / 360 * 360;
    }
    else
    {
      i = paramInt1;
      if (paramInt1 >= 275) {
        i = paramInt1 - (paramInt1 + 360) / 360 * 360;
      }
    }
    paramInt2 = i - paramInt2 * 90;
    if (paramInt2 > 180) {
      return i - 360;
    }
    paramInt1 = i;
    if (paramInt2 < -180) {
      paramInt1 = i + 360;
    }
    return paramInt1;
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  public static boolean isLongPhoto(long paramLong1, long paramLong2)
  {
    return (paramLong1 >= paramLong2 * 3L) || (paramLong2 >= paramLong1 * 3L);
  }
  
  private void layoutAndScaleChild(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    this.mIsLayoutScale = true;
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    if (j != 0)
    {
      if (i == 0) {
        return;
      }
      Object localObject1 = getChildGravityAndScale(i, j, paramInt1, paramInt2, paramView);
      boolean bool1;
      if ((paramView.getWidth() == i) && (paramView.getHeight() == j)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      boolean bool2;
      if (((Gallery.ScaleViewHolder)localObject1).defaultRotate * 90 != paramView.getRotation()) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("imgSizeChanged in layoutAndScaleChild is ");
        ((StringBuilder)localObject2).append(Boolean.toString(bool1));
        ((StringBuilder)localObject2).append(" rotateChanged:");
        ((StringBuilder)localObject2).append(bool2);
        QLog.d("Gallery", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1 != null)
      {
        paramInt1 = paramView.getLeft();
        layoutChild(paramView, ((Gallery.ScaleViewHolder)localObject1).gravity, paramInt3, paramBoolean);
        if ((((Gallery.ScaleViewHolder)localObject1).isHighPic) && (canUpdateRegionRect())) {
          updateShowArea(true);
        }
        if ((((Gallery.ScaleViewHolder)localObject1).hasTransformed) && (!bool1) && (!bool2))
        {
          paramInt1 -= paramView.getLeft();
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("left diff is: ");
            ((StringBuilder)localObject1).append(Integer.toString(paramInt1));
            QLog.d("Gallery", 2, ((StringBuilder)localObject1).toString());
          }
          if (paramInt1 != 0) {
            setChildTranslation(paramView, paramInt1, 0);
          }
        }
        else
        {
          float f = ((Gallery.ScaleViewHolder)localObject1).defaultScale;
          if (f != 0.0F)
          {
            setChildPivot(paramView, 0.0F, 0.0F);
            setChildScale(paramView, f);
            setChildRotation(paramView, ((Gallery.ScaleViewHolder)localObject1).defaultRotate * 90);
            getChildBounds(paramView, tmp);
            localObject2 = getChildLayout(tmp.width(), tmp.height(), ((Gallery.ScaleViewHolder)localObject1).gravity, paramInt3, paramBoolean);
            setChildTranslation(paramView, ((Rect)localObject2).left - tmp.left, ((Rect)localObject2).top - tmp.top);
          }
          paramView.setTag(2131296385, Float.valueOf(((Gallery.ScaleViewHolder)localObject1).defaultScale));
          paramView.setTag(2131296389, Integer.valueOf(((Gallery.ScaleViewHolder)localObject1).defaultRotate));
        }
      }
      this.mIsLayoutScale = false;
    }
  }
  
  private void layoutChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = getChildLayout(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), paramInt1, paramInt2, paramBoolean);
    paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    if (!this.mDataChanged)
    {
      localObject1 = this.mRecycler.get(paramInt1);
      if (localObject1 != null)
      {
        paramInt1 = ((View)localObject1).getLeft();
        this.mRightMost = Math.max(this.mRightMost, ((View)localObject1).getMeasuredWidth() + paramInt1);
        this.mLeftMost = Math.min(this.mLeftMost, paramInt1);
        setUpChild((View)localObject1, paramInt2, paramInt3, paramBoolean, true);
        return localObject1;
      }
    }
    Object localObject2 = this.mAdapter.getView(paramInt1, null, this);
    onViewCreated(paramInt1, this, paramBoolean, false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = getContext();
      localObject1 = new ImageView((Context)localObject2);
      ((ImageView)localObject1).setImageDrawable(((Context)localObject2).getResources().getDrawable(2130853414));
    }
    setUpChild((View)localObject1, paramInt2, paramInt3, paramBoolean, false);
    if (paramView != null) {
      applyTransformation(paramView, (View)localObject1);
    }
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
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
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
    if (paramView == null) {
      return;
    }
    if (VersionUtils.e())
    {
      paramView.setPivotX(paramFloat1);
      paramView.setPivotY(paramFloat2);
      return;
    }
    Gallery.TransformationInfo localTransformationInfo = getChildTransformationInfo(paramView);
    if ((localTransformationInfo.mPivotX != paramFloat1) || (localTransformationInfo.mPivotY != paramFloat2))
    {
      localTransformationInfo.mPivotX = paramFloat1;
      localTransformationInfo.mPivotY = paramFloat2;
      localTransformationInfo.mMatrixDirty = true;
      paramView.invalidate();
    }
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
    if (paramView == null) {
      return;
    }
    markViewTransformed(paramView);
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
    if (!isHardwareAccelerated()) {
      invalidate();
    }
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
    if (VersionUtils.e())
    {
      setChildTranslation(this.mSelectedChild, k, i);
      return;
    }
    this.mSelectedChild.offsetLeftAndRight(k);
    this.mSelectedChild.offsetTopAndBottom(i);
  }
  
  private void setSelectionToCenterChild()
  {
    int i = this.dx;
    if (i > 0)
    {
      i = getChildCount() - 1;
      this.dx = getChildBounds(getChildAt(i), tmp).left;
      i += this.mFirstPosition;
      this.dy = 0;
    }
    else if (i < 0)
    {
      i = this.mFirstPosition;
      this.dx = getChildBounds(getChildAt(0), tmp).left;
      this.dy = 0;
    }
    else
    {
      i = 0;
    }
    if (i != this.mSelectedPosition)
    {
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      checkSelectionChanged();
    }
  }
  
  private void setUpChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramView == null) {
      return;
    }
    int k = 1;
    boolean bool;
    if (paramInt1 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool != paramView.isSelected()) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if ((paramBoolean2) && (paramInt1 == 0) && (!paramView.isLayoutRequested())) {
      i = 0;
    } else {
      i = 1;
    }
    Gallery.LayoutParams localLayoutParams2 = (Gallery.LayoutParams)paramView.getLayoutParams();
    Gallery.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = (Gallery.LayoutParams)generateDefaultLayoutParams();
    }
    int j;
    if (paramBoolean1) {
      j = -1;
    } else {
      j = 0;
    }
    addViewInLayout(paramView, j, localLayoutParams1, true);
    if (paramInt1 != 0) {
      paramView.setSelected(bool);
    }
    if (i != 0)
    {
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      paramInt1 = k;
      if (!this.mSupportMatchParent) {
        if ((paramView.getTag(2131296433) != null) && (((Boolean)paramView.getTag(2131296433)).booleanValue())) {
          paramInt1 = k;
        } else {
          paramInt1 = 0;
        }
      }
      j = m;
      i = n;
      if (paramInt1 != 0)
      {
        j = m;
        i = n;
        if (localLayoutParams1.height == -1)
        {
          j = m;
          i = n;
          if (localLayoutParams1.width == -1)
          {
            j = View.MeasureSpec.makeMeasureSpec(getWidth() - this.mSpinnerPadding.left - this.mSpinnerPadding.right, 1073741824);
            i = View.MeasureSpec.makeMeasureSpec(getHeight() - this.mSpinnerPadding.top - this.mSpinnerPadding.bottom, 1073741824);
          }
        }
      }
      paramView.measure(j, i);
      layoutAndScaleChild(this.mWidth, this.mHeight, paramInt2, paramBoolean1, paramView);
    }
  }
  
  private void updateMatrix(Gallery.TransformationInfo paramTransformationInfo)
  {
    if (paramTransformationInfo == null) {
      return;
    }
    if (paramTransformationInfo.mMatrixDirty)
    {
      Gallery.TransformationInfo.access$100(paramTransformationInfo).reset();
      Gallery.TransformationInfo.access$100(paramTransformationInfo).setTranslate(paramTransformationInfo.mTranslationX, paramTransformationInfo.mTranslationY);
      Gallery.TransformationInfo.access$100(paramTransformationInfo).preRotate(paramTransformationInfo.mRotation, paramTransformationInfo.mPivotX, paramTransformationInfo.mPivotY);
      Gallery.TransformationInfo.access$100(paramTransformationInfo).preScale(paramTransformationInfo.mScaleX, paramTransformationInfo.mScaleY, paramTransformationInfo.mPivotX, paramTransformationInfo.mPivotY);
      paramTransformationInfo.mMatrixDirty = false;
      Gallery.TransformationInfo.access$302(paramTransformationInfo, Gallery.TransformationInfo.access$100(paramTransformationInfo).isIdentity());
    }
  }
  
  private void updateSelectedItemMetadata()
  {
    View localView1 = this.mSelectedChild;
    View localView2 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    this.mSelectedChild = localView2;
    if (localView2 == null) {
      return;
    }
    localView2.setSelected(true);
    localView2.setFocusable(true);
    if (hasFocus()) {
      localView2.requestFocus();
    }
    if ((localView1 != null) && (localView1 != localView2))
    {
      localView1.setSelected(false);
      localView1.setFocusable(false);
    }
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
        return paramInt / 4;
      }
      i = paramInt;
      if (paramInt >= j) {
        return i;
      }
      i = (paramInt - j) / 4;
      paramInt = j;
    }
    else
    {
      j = this.mSpinnerPadding.left - tmp.left;
      if (j < 0) {
        return paramInt / 4;
      }
      i = paramInt;
      if (paramInt <= j) {
        return i;
      }
      i = (paramInt - j) / 4;
      paramInt = j;
    }
    i += paramInt;
    return i;
  }
  
  protected boolean canUpdateRegionRect()
  {
    boolean bool2 = VersionUtils.e();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    View localView = this.mSelectedChild;
    if (localView == null) {
      return false;
    }
    if (localView.getWidth() * this.mSelectedChild.getHeight() >= this.mWidthMultDensity * this.mHeightMultDensity << 2) {
      bool1 = true;
    }
    return bool1;
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
    boolean bool;
    if (paramView.getTag(2131296418) != null) {
      bool = ((Boolean)paramView.getTag(2131296418)).booleanValue();
    } else {
      bool = false;
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
    View localView = this.mSelectedChild;
    if (localView != null) {
      localView.setPressed(paramBoolean);
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
      return new Rect();
    }
    tmp2.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    getChildMatrix(paramView).mapRect(tmp2);
    tmp2.offset(paramView.getLeft(), paramView.getTop());
    tmp2.round(paramRect);
    int i = paramRect.width();
    int j = this.mWidth;
    if (i < j)
    {
      i = (j - paramRect.width()) / 2;
      j = this.mWidth;
      int k = paramRect.width();
      paramRect.set(paramRect.left - i, paramRect.top, paramRect.right + (j - k - i), paramRect.bottom);
    }
    return paramRect;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i = this.mSelectedPosition - this.mFirstPosition;
    if (i < 0) {
      return paramInt2;
    }
    if (paramInt2 == paramInt1 - 1) {
      return i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 >= i) {
      paramInt1 = paramInt2 + 1;
    }
    return paramInt1;
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
    if (VersionUtils.e()) {
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
    if (VersionUtils.e()) {
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
    if (paramBoolean) {
      j = this.mItemCount - 1;
    } else {
      j = 0;
    }
    if (paramInt2 < 0) {
      i = 1;
    } else {
      i = 0;
    }
    View localView2 = getChildAt(j - this.mFirstPosition);
    if ((localView2 == null) && (this.mScrollState != 1) && (((paramBoolean) && (this.mIsRightedge)) || ((!paramBoolean) && (this.mIsLeftEdge)))) {
      if ((this.mScrollState != 0) && (Math.abs(paramInt1) <= Math.abs(paramInt2)))
      {
        getChildBounds(this.mSelectedChild, tmp);
        if (tmp.height() <= this.mHeight)
        {
          paramPoint.x = 0;
          paramPoint.y = 0;
          if (i == 0) {
            disPatchToParent();
          }
          return this.mScrollState;
        }
        this.mIsRightedge = false;
        this.mIsLeftEdge = false;
      }
      else
      {
        paramPoint.x = paramInt1;
        paramPoint.y = 0;
        this.mScrollState = 0;
        return this.mScrollState;
      }
    }
    if (this.mScrollState != 0) {
      this.mScrollState = 1;
    }
    View localView1;
    if ((!paramBoolean) || (this.mIsRightedge))
    {
      localView1 = localView2;
      if (!paramBoolean)
      {
        localView1 = localView2;
        if (this.mIsLeftEdge) {}
      }
    }
    else
    {
      localView1 = this.mSelectedChild;
    }
    getChildBounds(localView1, tmp);
    int j = calculateDampingDeltaX(paramBoolean, paramInt1);
    this.scrollX += j;
    this.scrollY += paramInt2;
    paramInt1 = tmp.height();
    int k = this.mHeight;
    if (paramInt1 < k)
    {
      disPatchToParent();
      paramInt1 = 0;
    }
    else if (i != 0)
    {
      i = k - this.mSpinnerPadding.bottom - tmp.bottom;
      if (i > 0)
      {
        paramInt1 = paramInt2 / 4;
      }
      else
      {
        paramInt1 = paramInt2;
        if (j < i) {
          paramInt1 = (paramInt2 - i) / 6 + i;
        }
      }
    }
    else
    {
      i = this.mSpinnerPadding.top - tmp.top;
      if (i < 0)
      {
        paramInt1 = paramInt2 / 4;
        disPatchToParent();
      }
      else
      {
        paramInt1 = paramInt2;
        if (j > i) {
          paramInt1 = (paramInt2 - i) / 6 + i;
        }
      }
    }
    int i = this.mWidth;
    if (j > i)
    {
      paramInt2 = i;
    }
    else
    {
      paramInt2 = j;
      if (j < -i) {
        paramInt2 = -i;
      }
    }
    paramPoint.x = paramInt2;
    paramPoint.y = paramInt1;
    return this.mScrollState;
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
    View localView = this.mSelectedChild;
    boolean bool = false;
    if (localView == null) {
      return false;
    }
    float f = 1.0F;
    if (localView.getTag(2131296392) != null) {
      f = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
    } else if (this.mSelectedChild.getTag(2131296385) != null) {
      f = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
    } else if ((this.mSelectedChild.getTag(2131296386) instanceof Float)) {
      f = ((Float)this.mSelectedChild.getTag(2131296386)).floatValue();
    }
    if (Math.abs(getChildScale(this.mSelectedChild) - f) >= 1.E-005D) {
      bool = true;
    }
    return bool;
  }
  
  void layout(int paramInt, boolean paramBoolean)
  {
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
    View localView;
    if ((i >= 0) && (i < paramInt)) {
      localView = getChildAt(i);
    } else {
      localView = null;
    }
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
    if ((getAdapter().hasStableIds()) && (localView != null) && (this.mSelectedRowId == this.mOldSelectedRowId)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    i = this.mSelectedPosition;
    int j = this.dx;
    if (paramInt == 0) {
      localView = null;
    }
    makeAndAddView(i, 0, j, true, localView);
    if (this.dx < 0) {
      fillToGalleryRight();
    } else {
      fillToGalleryLeft();
    }
    if (this.mShouldStopFling)
    {
      this.dx = 0;
      this.dy = 0;
    }
    if (this.mClearByTag) {
      this.mRecycler.clearByTag();
    } else {
      this.mRecycler.clear();
    }
    invalidate();
    checkSelectionChanged();
    this.mDataChanged = false;
    this.mNeedSync = false;
    setNextSelectedPositionInt(this.mSelectedPosition);
    updateSelectedItemMetadata();
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
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.mDoubleTapEnable) {
      return true;
    }
    this.mIsDoubleTapping = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.mSelectedChild != null) {
      setPivot(f1, f2);
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = this.mScrollState;
    boolean bool2 = false;
    if (i == 2) {
      this.mScrollState = 0;
    } else {
      resetScrollState();
    }
    this.mFlingRunnable.stop(false);
    this.mDownTouchPosition = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    i = this.mDownTouchPosition;
    if (i >= 0)
    {
      this.mDownTouchView = getChildAt(i - this.mFirstPosition);
      this.mDownTouchView.setPressed(true);
    }
    this.mIsFirstScroll = true;
    this.scrollX = 0;
    this.scrollY = 0;
    getChildBounds(this.mSelectedChild, tmp);
    if (tmp.width() == this.mWidth)
    {
      this.mIsRightedge = true;
      this.mIsLeftEdge = true;
      return true;
    }
    if (tmp.left == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsLeftEdge = bool1;
    boolean bool1 = bool2;
    if (tmp.right == this.mWidth) {
      bool1 = true;
    }
    this.mIsRightedge = bool1;
    return true;
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
    int k;
    if (getChildCount() <= 1)
    {
      getChildBounds(this.mSelectedChild, tmp);
      i = this.mWidth + this.mSpinnerPadding.left - tmp.right;
      j = this.mSpinnerPadding.left - tmp.left;
      if ((tmp.height() < this.mHeight) && (tmp.width() <= this.mWidth))
      {
        scrollIntoSlots();
      }
      else
      {
        int m = tmp.height();
        k = this.mHeight;
        int n;
        int i1;
        int i2;
        float f2;
        float f3;
        float f1;
        if (m < k)
        {
          k = this.mSpinnerPadding.top;
          m = (this.mHeight - tmp.bottom + tmp.top) / 2;
          n = tmp.top;
          i1 = this.mHeight;
          i2 = (i1 - tmp.bottom + tmp.top) / 2;
          int i3 = tmp.bottom;
          f2 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
          f3 = this.mMaximumVelocity;
          f1 = paramFloat1;
          if (f2 > f3)
          {
            f1 = paramFloat1 * f3 / f2;
            paramFloat2 = 0.0F;
          }
          this.mFlingRunnable.startUsingVelocity((int)f1, (int)paramFloat2, i, j, k + m - n, i1 - i2 - i3);
        }
        else
        {
          m = this.mSpinnerPadding.top;
          n = tmp.bottom;
          i1 = this.mSpinnerPadding.top;
          i2 = tmp.top;
          f3 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
          float f4 = this.mMaximumVelocity;
          f2 = paramFloat1;
          f1 = paramFloat2;
          if (f3 > f4)
          {
            f2 = paramFloat1 * f4 / f3;
            f1 = paramFloat2 * f4 / f3;
          }
          this.mFlingRunnable.startUsingVelocity((int)f2, (int)f1, i, j, k + m - n, i1 - i2);
        }
      }
    }
    else if (paramFloat1 < 0.0F)
    {
      i = getChildBounds(getChildAt(1), tmp).left;
      getChildBounds(getChildAt(0), tmp);
      if (i == 0) {
        return true;
      }
      paramMotionEvent1 = this.mFlingRunnable;
      j = (int)paramFloat1;
      if (paramMotionEvent1.calcFlingDistance(i, j) <= this.mSpinnerPadding.left) {
        this.mFlingRunnable.startUsingVelocity(j, 0, this.mSpinnerPadding.left - i, 2147483647, 0, 0);
      } else if (paramFloat1 < -this.mMinimumVelocity) {
        this.mFlingRunnable.startUsingDistance(this.mSpinnerPadding.left - i, 0);
      } else {
        scrollIntoSlots();
      }
    }
    else
    {
      i = this.mWidth + this.mSpinnerPadding.left;
      j = getChildBounds(getChildAt(0), tmp).right;
      if (j == i) {
        return true;
      }
      paramMotionEvent1 = this.mFlingRunnable;
      k = (int)paramFloat1;
      if (paramMotionEvent1.calcFlingDistance(j, k) >= i) {
        this.mFlingRunnable.startUsingVelocity(k, 0, -2147483648, i - j, 0, 0);
      } else if (paramFloat1 > this.mMinimumVelocity) {
        this.mFlingRunnable.startUsingDistance(i - j, 0);
      } else {
        scrollIntoSlots();
      }
    }
    if (this.mScrollState == 0) {
      this.mScrollState = 2;
    }
    if (this.mScrollingRegion) {
      this.mScrollingRegion = false;
    }
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (paramBoolean)
    {
      paramRect = this.mSelectedChild;
      if (paramRect != null)
      {
        paramRect.requestFocus(paramInt);
        this.mSelectedChild.setSelected(true);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.interceptTouchEventReturn;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 66) {
      switch (paramInt)
      {
      default: 
        break;
      case 22: 
        if (moveNext()) {
          playSoundEffect(3);
        }
        return true;
      case 21: 
        if (movePrevious()) {
          playSoundEffect(1);
        }
        return true;
      }
    } else {
      this.mReceivedInvokeKeyDown = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 23) && (paramInt != 66)) {
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
    this.mHeightMultDensity = ((int)Math.ceil(this.mHeight * f));
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
    if (this.mSelectedChild != null)
    {
      if (this.mScrollState == 0) {
        return false;
      }
      float f1 = paramScaleGestureDetector.getFocusX();
      float f2 = paramScaleGestureDetector.getFocusY();
      float f3 = f1 - this.focusX;
      float f4 = f2 - this.focusY;
      this.focusX = f1;
      this.focusY = f2;
      if (VersionUtils.e())
      {
        setChildTranslation(this.mSelectedChild, (int)f3, (int)f4);
      }
      else
      {
        this.mSelectedChild.offsetLeftAndRight((int)f3);
        this.mSelectedChild.offsetTopAndBottom((int)f4);
      }
      setPivot(f1, f2);
      f3 = paramScaleGestureDetector.getCurrentSpan() / this.beginSpan;
      f2 = this.beginScale * f3;
      if (this.mSelectedChild.getTag(2131296392) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      } else if (this.mSelectedChild.getTag(2131296385) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
      } else {
        f1 = 1.0F;
      }
      if (f1 <= 1.0F) {
        f1 = f1 * f1 * 0.6F * 0.6F;
      } else {
        f1 = 0.6F;
      }
      if (f2 >= f1)
      {
        f4 = this.mMaxumScale;
        f1 = f2;
        if (f2 > f4 * 1.5F) {
          f1 = f4 * 1.5F;
        }
      }
      setChildScale(this.mSelectedChild, f1);
      Boolean localBoolean = (Boolean)this.mSelectedChild.getTag(2131296390);
      if ((this.isRotateEnable) && (this.canRotating) && (localBoolean != null) && (localBoolean.booleanValue()))
      {
        if (this.isRotating)
        {
          f2 = (float)((getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          setChildRotation(this.mSelectedChild, f1 + this.beginRotation);
          return true;
        }
        if (f3 <= 0.95F)
        {
          this.isRotating = true;
          f2 = (float)((getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.vectorRotation) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          setChildRotation(this.mSelectedChild, f1 + this.beginRotation);
          return true;
        }
        if (f3 >= 1.05F) {
          this.canRotating = false;
        }
      }
      return true;
    }
    return false;
  }
  
  @TargetApi(11)
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.isRotating = false;
    if (this.mSelectedChild != null)
    {
      if (this.mScrollState == 0) {
        return false;
      }
      if (!VersionUtils.e())
      {
        Object localObject = this.mSelectedChild;
        if ((localObject instanceof ImageView))
        {
          localObject = ((ImageView)localObject).getDrawable();
          if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {
            break label122;
          }
          return false;
        }
      }
      if ((this.mSelectedChild.getTag(2131296400) != null) && ((this.mSelectedChild.getTag(2131296400) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue())) {
        return false;
      }
      label122:
      this.vectorRotation = getRadian(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY());
      this.beginRotation = getChildRotation(this.mSelectedChild);
      float f1 = 1.0F;
      if (this.mSelectedChild.getTag(2131296392) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      } else if (this.mSelectedChild.getTag(2131296385) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
      }
      boolean bool;
      if (getChildScale(this.mSelectedChild) <= f1 + 1.0E-005F) {
        bool = true;
      } else {
        bool = false;
      }
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
    }
    return false;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    paramScaleGestureDetector = this.mSelectedChild;
    if (paramScaleGestureDetector != null)
    {
      float f1 = 1.0F;
      if (paramScaleGestureDetector.getTag(2131296392) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
      } else if (this.mSelectedChild.getTag(2131296385) != null) {
        f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
      }
      float f2 = getChildScale(this.mSelectedChild);
      if ((f2 > f1) && (f2 <= this.mMaxumScale))
      {
        if (canUpdateRegionRect()) {
          updateShowArea(true);
        } else {
          onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
        }
      }
      else {
        updateShowArea(false);
      }
    }
    resetScrollState();
    this.canRotating = true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.mShouldCallbackDuringFling)
    {
      if (this.mIsFirstScroll)
      {
        if (!this.mSuppressSelectionChanged) {
          this.mSuppressSelectionChanged = true;
        }
        postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
      }
    }
    else if (this.mSuppressSelectionChanged) {
      this.mSuppressSelectionChanged = false;
    }
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
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.mIsMultiTouch = true;
      if (this.mScaleGestureEnable)
      {
        bool = this.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
        break label79;
      }
    }
    else if (!this.mIsScaling)
    {
      this.mIsMultiTouch = false;
      bool = this.mGestureDetector.onTouchEvent(paramMotionEvent);
      break label79;
    }
    boolean bool = false;
    label79:
    int i = paramMotionEvent.getAction();
    if (i == 1)
    {
      onUp();
      recycleVelocityTracker();
      this.mIsScaling = false;
    }
    else if (i == 3)
    {
      onCancel();
      recycleVelocityTracker();
      this.mIsScaling = false;
    }
    if ((i & 0xFF) == 2) {
      this.lastMoveTime = AnimationUtils.currentAnimationTimeMillis();
    }
    return bool;
  }
  
  public void onUp()
  {
    Object localObject;
    if (!VersionUtils.e())
    {
      localObject = this.mSelectedChild;
      if ((localObject instanceof ImageView))
      {
        localObject = ((ImageView)localObject).getDrawable();
        if (((localObject instanceof URLDrawable)) && ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)))
        {
          i = 1;
          break label61;
        }
      }
    }
    int i = 0;
    label61:
    if ((this.mIsDoubleTapping) && (i == 0))
    {
      this.mIsLeftEdge = false;
      this.mIsRightedge = false;
      float f1 = 1.0F;
      localObject = this.mSelectedChild;
      if (localObject != null)
      {
        if (((((View)localObject).getTag(2131296400) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue())) {
          return;
        }
        float f3 = getChildScale(this.mSelectedChild);
        float f2;
        if (this.mSelectedChild.getTag(2131296392) != null)
        {
          if (isNeedSetLongPicAction())
          {
            f2 = ((Float)this.mSelectedChild.getTag(2131296414)).floatValue();
            f1 = f2;
            if (Math.abs(f3 - f2) < 1.E-005D) {
              f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
            }
          }
          else
          {
            f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
          }
        }
        else if (this.mSelectedChild.getTag(2131296385) != null) {
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
        }
        if (Math.abs(f3 - f1) < 1.E-005D)
        {
          int n = getMeasuredWidth();
          int i1 = getMeasuredHeight();
          if (this.mSelectedChild.getTag(2131296389) != null) {
            i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();
          } else {
            i = 0;
          }
          int j;
          if ((i != 1) && (i != 3))
          {
            i = this.mSelectedChild.getMeasuredWidth();
            j = this.mSelectedChild.getMeasuredHeight();
          }
          else
          {
            i = this.mSelectedChild.getMeasuredHeight();
            j = this.mSelectedChild.getMeasuredWidth();
          }
          int k;
          if ((i <= n) && (j <= i1)) {
            k = 1;
          } else {
            k = 0;
          }
          int m;
          if (j >= i * 3) {
            m = 1;
          } else {
            m = 0;
          }
          if ((k != 0) && ((!(this.mSelectedChild.getTag(2131296417) instanceof Boolean)) || (!((Boolean)this.mSelectedChild.getTag(2131296417)).booleanValue())))
          {
            if (this.mSelectedChild.getTag(2131296413) != null) {
              f1 = ((Float)this.mSelectedChild.getTag(2131296413)).floatValue();
            } else {
              f1 = this.mMaxumScale;
            }
          }
          else if (m != 0)
          {
            f1 = Math.min(n / i, this.mMaxumScale);
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
            float f4;
            if (k < n)
            {
              f2 = k;
              f4 = n;
              if (f2 * 1.5F < f4)
              {
                f1 = f4 / i;
                break label656;
              }
            }
            else
            {
              f2 = m - i2;
              f4 = i1;
              if (f2 * 1.5F < f4) {
                break label649;
              }
            }
            f1 *= 2.0F;
            break label656;
            f1 = f4 / j;
          }
          f1 = Math.min(f1, this.mMaxumScale);
        }
        if (f3 < f1)
        {
          if (!canUpdateRegionRect()) {
            onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
          }
        }
        else if (canUpdateRegionRect()) {
          updateShowArea(false);
        }
        scrollIntoSlots(f1);
      }
    }
    else if (Gallery.FlingRunnable.access$400(this.mFlingRunnable).isFinished())
    {
      scrollIntoSlots();
      if (this.mScrollState == 0) {
        this.mScrollState = 2;
      }
    }
    label649:
    label656:
    this.mIsDoubleTapping = false;
    dispatchUnpress();
    if (this.mScrollingRegion)
    {
      this.mScrollingRegion = false;
      this.mScrollDirection = 0;
      if (canUpdateRegionRect()) {
        updateShowArea(true);
      }
    }
  }
  
  public void onUpForQzone(float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    if (!VersionUtils.e())
    {
      localObject = this.mSelectedChild;
      if ((localObject instanceof ImageView))
      {
        localObject = ((ImageView)localObject).getDrawable();
        if (((localObject instanceof URLDrawable)) && ((((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable)))
        {
          i = 1;
          break label61;
        }
      }
    }
    int i = 0;
    label61:
    if ((this.mIsDoubleTapping) && (i == 0))
    {
      this.mIsLeftEdge = false;
      this.mIsRightedge = false;
      float f1 = 1.0F;
      localObject = this.mSelectedChild;
      if (localObject != null)
      {
        if (((((View)localObject).getTag(2131296400) instanceof Boolean)) && (((Boolean)this.mSelectedChild.getTag(2131296400)).booleanValue())) {
          return;
        }
        if (this.mSelectedChild.getTag(2131296392) != null) {
          f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
        } else if (this.mSelectedChild.getTag(2131296385) != null) {
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
        }
        float f2 = getChildScale(this.mSelectedChild);
        int n = getMeasuredWidth();
        int i1 = getMeasuredHeight();
        if (this.mSelectedChild.getTag(2131296389) != null) {
          i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();
        } else {
          i = 0;
        }
        int j;
        if ((i != 1) && (i != 3))
        {
          i = this.mSelectedChild.getMeasuredWidth();
          j = this.mSelectedChild.getMeasuredHeight();
        }
        else
        {
          i = this.mSelectedChild.getMeasuredHeight();
          j = this.mSelectedChild.getMeasuredWidth();
        }
        int k;
        if ((i <= n) && (j <= i1)) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (j >= i * 3) {
          m = 1;
        } else {
          m = 0;
        }
        if (k != 0)
        {
          f1 = this.mMaxumScale;
        }
        else if (m != 0)
        {
          f1 = Math.min(n / i, this.mMaxumScale);
        }
        else
        {
          localObject = getImageSize(this.mSelectedChild);
          k = ((Rect)localObject).right - ((Rect)localObject).left;
          m = ((Rect)localObject).bottom;
          int i2 = ((Rect)localObject).top;
          float f3;
          float f4;
          if (k < n)
          {
            f3 = k;
            f4 = n;
            if (f3 * 1.5F < f4)
            {
              f1 = f4 / i;
              break label491;
            }
          }
          else
          {
            f3 = m - i2;
            f4 = i1;
            if (f3 * 1.5F < f4) {
              break label484;
            }
          }
          f1 *= 2.0F;
          break label491;
          label484:
          f1 = f4 / j;
        }
        label491:
        paramFloat = Math.min(paramFloat, f1);
        if (f2 < paramFloat)
        {
          if (!canUpdateRegionRect()) {
            onZoomBegin(this.mSelectedPosition, this.mSelectedChild, this);
          }
        }
        else if (canUpdateRegionRect()) {
          updateShowArea(false);
        }
        scrollIntoSlots(paramFloat);
      }
    }
    else if (Gallery.FlingRunnable.access$400(this.mFlingRunnable).isFinished())
    {
      scrollIntoSlots();
      if (this.mScrollState == 0) {
        this.mScrollState = 2;
      }
    }
    this.mIsDoubleTapping = false;
    dispatchUnpress();
    if (this.mScrollingRegion)
    {
      this.mScrollingRegion = false;
      this.mScrollDirection = 0;
      if (canUpdateRegionRect()) {
        updateShowArea(true);
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
          return this.mFirstPosition + i;
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
    Object localObject = this.mSelectedChild;
    if (localObject == null) {
      return false;
    }
    localObject = ((View)localObject).getTag(2131296385);
    if (localObject != null)
    {
      if (!(localObject instanceof Float)) {
        return false;
      }
      float f1 = ((Float)localObject).floatValue();
      float f2 = getChildScale(this.mSelectedChild);
      if (f2 >= f1)
      {
        if ((Math.abs(f2 - f1) < 1.E-005D) && (!paramBoolean)) {
          return false;
        }
        scrollIntoSlots(this.mMinumScale * f1);
        return true;
      }
    }
    return false;
  }
  
  public void scrollIntoSlots(float paramFloat)
  {
    int i = getChildCount();
    if (i != 0)
    {
      if (this.mSelectedChild == null) {
        return;
      }
      View localView = getChildAt(0);
      if (i == 1)
      {
        float f2 = getChildScale(this.mSelectedChild);
        if (this.mSelectedChild.getTag(2131296389) != null) {
          i = ((Integer)this.mSelectedChild.getTag(2131296389)).intValue();
        } else {
          i = 0;
        }
        float f1;
        if ((this.mSelectedChild.getTag(2131296392) instanceof Float))
        {
          f1 = ((Float)this.mSelectedChild.getTag(2131296392)).floatValue();
        }
        else
        {
          if (!(this.mSelectedChild.getTag(2131296385) instanceof Float)) {
            break label735;
          }
          f1 = ((Float)this.mSelectedChild.getTag(2131296385)).floatValue();
        }
        k = (int)getChildRotation(this.mSelectedChild);
        j = getRotationFlag(k, i);
        float f4 = getRotationInternal(k, j);
        float f5 = j * 90;
        k = this.mSelectedChild.getMeasuredWidth();
        int m = this.mSelectedChild.getMeasuredHeight();
        int n = getMeasuredWidth();
        int i1 = getMeasuredHeight();
        if (paramFloat == 0.0F)
        {
          if (j != i)
          {
            this.mSelectedChild.setTag(2131296389, Integer.valueOf(j));
            Object localObject = getChildGravityAndScale(k, m, n, i1, this.mSelectedChild);
            f1 = ((Gallery.ScaleViewHolder)localObject).defaultScale;
            this.mSelectedChild.setTag(2131296385, Float.valueOf(((Gallery.ScaleViewHolder)localObject).defaultScale));
            localObject = this.mOnItemRotateListener;
            paramFloat = f1;
            if (localObject != null)
            {
              ((Gallery.OnItemRotateListener)localObject).onRotateFinished(this.mSelectedChild, getSelectedItemPosition(), j);
              paramFloat = f1;
            }
          }
          for (;;)
          {
            break;
            paramFloat = Math.min(f1, this.mMinumScale);
            float f3 = Math.max(f1, this.mMaxumScale);
            if (Math.abs(f2 - f1) < 1.E-005D) {
              paramFloat = f1;
            } else if (f2 >= paramFloat) {
              if (f2 > f3) {
                paramFloat = f3;
              } else {
                paramFloat = f2;
              }
            }
          }
        }
        if ((f2 == paramFloat) && (f5 == f4))
        {
          getChildBounds(localView, tmp);
        }
        else
        {
          setChildScale(this.mSelectedChild, paramFloat);
          setChildRotation(this.mSelectedChild, f5);
          getChildBounds(this.mSelectedChild, tmp);
          setChildScale(this.mSelectedChild, f2);
          setChildRotation(this.mSelectedChild, f4);
        }
        if (tmp.right < this.mWidth + this.mSpinnerPadding.left) {
          i = this.mWidth + this.mSpinnerPadding.left;
        }
        for (j = tmp.right;; j = tmp.left)
        {
          k = i - j;
          break label549;
          if (tmp.left <= this.mSpinnerPadding.left) {
            break;
          }
          i = this.mSpinnerPadding.left;
        }
        k = 0;
        label549:
        if (tmp.height() < this.mHeight)
        {
          i = this.mSpinnerPadding.top + (this.mHeight - tmp.height()) / 2;
          j = tmp.top;
        }
        for (;;)
        {
          i -= j;
          break label688;
          if (tmp.top > this.mSpinnerPadding.top)
          {
            i = this.mSpinnerPadding.top;
            j = tmp.top;
          }
          else
          {
            if (tmp.bottom >= this.mHeight + this.mSpinnerPadding.top) {
              break;
            }
            i = this.mHeight + this.mSpinnerPadding.top;
            j = tmp.bottom;
          }
        }
        i = 0;
        label688:
        if ((f2 == paramFloat) && (f5 == f4))
        {
          this.mFlingRunnable.startUsingDistance(k, i);
          return;
        }
        this.mFlingRunnable.startUsingDistance(k, i, f2, paramFloat, f4, f5);
        return;
        label735:
        return;
      }
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
      int j = tmp.right;
      int k = this.mSpacing;
      this.mFlingRunnable.startUsingDistance(i - j - k, 0);
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
    if (getChildCount() != 0)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        return;
      }
      int i = 1;
      boolean bool;
      if (paramInt1 < 0) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramInt1 == 0) {
        this.mScrollDirection = 0;
      } else if (paramInt1 < 0) {
        this.mScrollDirection = 1;
      } else {
        this.mScrollDirection = 2;
      }
      if (paramBoolean)
      {
        getLimitedMotionScrollAmount(bool, paramInt1, paramInt2, this.tmpP);
      }
      else
      {
        localObject = this.tmpP;
        ((Point)localObject).x = paramInt1;
        ((Point)localObject).y = paramInt2;
      }
      onViewContentMoved(bool, paramInt1, this.tmpP, this.mWidth, this.mSpinnerPadding);
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        setChildTranslation(getChildAt(paramInt1), this.tmpP.x, 0);
        paramInt1 -= 1;
      }
      this.dx += this.tmpP.x;
      Object localObject = this.mSelectedChild;
      if ((localObject != null) && (this.mScrollState != 0))
      {
        setChildTranslation((View)localObject, 0, this.tmpP.y);
        this.dy += this.tmpP.y;
      }
      detachOffScreenChildren(bool);
      localObject = this.mSelectedChild;
      if ((localObject != null) && (((View)localObject).getParent() == null)) {
        paramInt1 = i;
      } else {
        paramInt1 = 0;
      }
      if ((bool) && (this.mIsRightedge)) {
        fillToGalleryRight();
      } else if ((!bool) && (this.mIsLeftEdge)) {
        fillToGalleryLeft();
      }
      this.mRecycler.clear();
      if (paramInt1 != 0) {
        setSelectionToCenterChild();
      }
      onScrollChanged(0, 0, 0, 0);
      invalidate();
    }
  }
  
  protected void updateShowArea(boolean paramBoolean, int paramInt)
  {
    View localView = this.mSelectedChild;
    if (localView == null) {
      return;
    }
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (i != 0)
    {
      if (j == 0) {
        return;
      }
      Rect localRect = new Rect();
      getChildBounds(localView, localRect);
      if (!localRect.intersect(0, 0, i, j)) {
        return;
      }
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
      } else if (localView.getTag(2131296385) != null) {
        ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296385)).floatValue();
      }
      onShowAreaChanged(this.mSelectedPosition, localView, (RegionDrawableData)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.Gallery
 * JD-Core Version:    0.7.0.1
 */