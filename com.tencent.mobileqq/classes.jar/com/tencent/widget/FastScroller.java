package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.tencent.util.VersionUtils;

class FastScroller
{
  private static final int[] ATTRS = { 16843609, 16843574, 16843577, 16843575, 16843576, 16843578 };
  private static final int[] DEFAULT_STATES;
  private static final int FADE_TIMEOUT = 1500;
  private static int MIN_PAGES = 4;
  private static final int OVERLAY_AT_THUMB = 1;
  private static final int OVERLAY_FLOATING = 0;
  private static final int OVERLAY_POSITION = 5;
  private static final int PENDING_DRAG_DELAY = 180;
  private static final int[] PRESSED_STATES = { 16842919 };
  private static final int PREVIEW_BACKGROUND_LEFT = 3;
  private static final int PREVIEW_BACKGROUND_RIGHT = 4;
  private static final int STATE_DRAGGING = 3;
  private static final int STATE_ENTER = 1;
  private static final int STATE_EXIT = 4;
  private static final int STATE_NONE = 0;
  private static final int STATE_VISIBLE = 2;
  private static final String TAG = "FastScroller";
  private static final int TEXT_COLOR = 0;
  private static final int THUMB_DRAWABLE = 1;
  private static final int TRACK_DRAWABLE = 2;
  private boolean mAlwaysShow;
  private boolean mChangedBounds;
  private final Runnable mDeferStartDrag = new FastScroller.1(this);
  private boolean mDrawOverlay;
  private Handler mHandler = new Handler();
  float mInitialTouchY;
  private int mItemCount = -1;
  AbsListView mList;
  BaseAdapter mListAdapter;
  private int mListOffset;
  private boolean mLongList;
  private boolean mMatchDragPosition;
  private Drawable mOverlayDrawable;
  private Drawable mOverlayDrawableLeft;
  private Drawable mOverlayDrawableRight;
  private RectF mOverlayPos;
  private int mOverlayPosition;
  private int mOverlaySize;
  private Paint mPaint;
  boolean mPendingDrag;
  private int mPosition;
  private int mScaledTouchSlop;
  boolean mScrollCompleted;
  private FastScroller.ScrollFade mScrollFade;
  private SectionIndexer mSectionIndexer;
  private String mSectionText;
  private Object[] mSections;
  private int mState;
  private Drawable mThumbDrawable;
  int mThumbH;
  int mThumbW;
  int mThumbY;
  private final Rect mTmpRect = new Rect();
  private Drawable mTrackDrawable;
  private int mVisibleItem;
  
  static
  {
    DEFAULT_STATES = new int[0];
  }
  
  public FastScroller(Context paramContext, AbsListView paramAbsListView)
  {
    this.mList = paramAbsListView;
    init(paramContext);
  }
  
  private void cancelFling()
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
    this.mList.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  private int getThumbPositionForListPosition(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mSectionIndexer == null) || (this.mListAdapter == null)) {
      getSectionsFromIndexer();
    }
    if ((this.mSectionIndexer != null) && (this.mMatchDragPosition))
    {
      int j = this.mListOffset;
      int k = paramInt1 - j;
      if (k < 0) {
        return 0;
      }
      int m = this.mList.getHeight() - this.mThumbH;
      paramInt1 = this.mSectionIndexer.getSectionForPosition(k);
      int i = this.mSectionIndexer.getPositionForSection(paramInt1);
      int n = this.mSectionIndexer.getPositionForSection(paramInt1 + 1);
      int i1 = this.mSections.length;
      View localView = this.mList.getChildAt(0);
      if (localView == null) {
        f = 0.0F;
      } else {
        f = k + (this.mList.getPaddingTop() - localView.getTop()) / localView.getHeight();
      }
      float f = (f - i) / (n - i);
      i = (int)((paramInt1 + f) / i1 * m);
      paramInt1 = i;
      if (k > 0)
      {
        paramInt1 = i;
        if (k + paramInt2 == paramInt3 - j)
        {
          localView = this.mList.getChildAt(paramInt2 - 1);
          f = (this.mList.getHeight() - this.mList.getPaddingBottom() - localView.getTop()) / localView.getHeight();
          paramInt1 = (int)(i + (m - i) * f);
        }
      }
      return paramInt1;
    }
    return (this.mList.getHeight() - this.mThumbH) * paramInt1 / (paramInt3 - paramInt2);
  }
  
  @TargetApi(11)
  private void init(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(ATTRS);
    boolean bool = true;
    try
    {
      useThumbDrawable(paramContext, localTypedArray.getDrawable(1));
      this.mTrackDrawable = localTypedArray.getDrawable(2);
      this.mOverlayDrawableLeft = localTypedArray.getDrawable(3);
      this.mOverlayDrawableRight = localTypedArray.getDrawable(4);
      int i = 0;
      this.mOverlayPosition = localTypedArray.getInt(5, 0);
      this.mScrollCompleted = true;
      getSectionsFromIndexer();
      this.mOverlaySize = paramContext.getResources().getDimensionPixelSize(2131297391);
      this.mOverlayPos = new RectF();
      this.mScrollFade = new FastScroller.ScrollFade(this);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setTextAlign(Paint.Align.CENTER);
      this.mPaint.setTextSize(this.mOverlaySize / 2);
      int j = localTypedArray.getColorStateList(0).getDefaultColor();
      this.mPaint.setColor(j);
      this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      if ((this.mList.getWidth() > 0) && (this.mList.getHeight() > 0)) {
        onSizeChanged(this.mList.getWidth(), this.mList.getHeight(), 0, 0);
      }
      this.mState = 0;
      refreshDrawableState();
      localTypedArray.recycle();
      this.mScaledTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      if (paramContext.getApplicationInfo().targetSdkVersion < 11) {
        bool = false;
      }
      this.mMatchDragPosition = bool;
      if (VersionUtils.e()) {
        i = this.mList.getVerticalScrollbarPosition();
      }
      setScrollbarPosition(i);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
  
  private void refreshDrawableState()
  {
    int[] arrayOfInt;
    if (this.mState == 3) {
      arrayOfInt = PRESSED_STATES;
    } else {
      arrayOfInt = DEFAULT_STATES;
    }
    Drawable localDrawable = this.mThumbDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.mThumbDrawable.setState(arrayOfInt);
    }
    localDrawable = this.mTrackDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.mTrackDrawable.setState(arrayOfInt);
    }
  }
  
  private void resetThumbPos()
  {
    int i = this.mList.getWidth();
    int j = this.mPosition;
    if (j != 0) {
      if (j != 1)
      {
        if (j != 2) {
          break label69;
        }
      }
      else
      {
        this.mThumbDrawable.setBounds(0, 0, this.mThumbW, this.mThumbH);
        break label69;
      }
    }
    this.mThumbDrawable.setBounds(i - this.mThumbW, 0, i, this.mThumbH);
    label69:
    this.mThumbDrawable.setAlpha(208);
  }
  
  private void useThumbDrawable(Context paramContext, Drawable paramDrawable)
  {
    this.mThumbDrawable = paramDrawable;
    if ((paramDrawable instanceof NinePatchDrawable))
    {
      this.mThumbW = paramContext.getResources().getDimensionPixelSize(2131297393);
      this.mThumbH = paramContext.getResources().getDimensionPixelSize(2131297392);
    }
    else
    {
      this.mThumbW = paramDrawable.getIntrinsicWidth();
      this.mThumbH = paramDrawable.getIntrinsicHeight();
    }
    this.mChangedBounds = true;
  }
  
  void beginDrag()
  {
    setState(3);
    if ((this.mListAdapter == null) && (this.mList != null)) {
      getSectionsFromIndexer();
    }
    AbsListView localAbsListView = this.mList;
    if (localAbsListView != null)
    {
      localAbsListView.requestDisallowInterceptTouchEvent(true);
      this.mList.reportScrollStateChange(1);
      cancelFling();
    }
  }
  
  void cancelPendingDrag()
  {
    this.mList.removeCallbacks(this.mDeferStartDrag);
    this.mPendingDrag = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mState == 0) {
      return;
    }
    int k = this.mThumbY;
    int m = this.mList.getWidth();
    Object localObject1 = this.mScrollFade;
    int i = -1;
    int j;
    int n;
    if (this.mState == 4)
    {
      j = ((FastScroller.ScrollFade)localObject1).getAlpha();
      if (j < 104) {
        this.mThumbDrawable.setAlpha(j * 2);
      }
      i = this.mPosition;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2)
          {
            i = 0;
            break label127;
          }
        }
        else
        {
          i = this.mThumbW;
          n = -i;
          i = i * j / 208 + n;
          break label127;
        }
      }
      i = m - this.mThumbW * j / 208;
      label127:
      this.mThumbDrawable.setBounds(i, 0, this.mThumbW + i, this.mThumbH);
      this.mChangedBounds = true;
      i = j;
    }
    if (this.mTrackDrawable != null)
    {
      localObject1 = this.mThumbDrawable.getBounds();
      int i1 = ((Rect)localObject1).left;
      j = (((Rect)localObject1).bottom - ((Rect)localObject1).top) / 2;
      n = this.mTrackDrawable.getIntrinsicWidth();
      i1 = i1 + this.mThumbW / 2 - n / 2;
      this.mTrackDrawable.setBounds(i1, j, n + i1, this.mList.getHeight() - j);
      this.mTrackDrawable.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, k);
    this.mThumbDrawable.draw(paramCanvas);
    paramCanvas.translate(0.0F, -k);
    if ((this.mState == 3) && (this.mDrawOverlay))
    {
      if (this.mOverlayPosition == 1)
      {
        if (this.mPosition != 1) {
          i = Math.max(0, this.mThumbDrawable.getBounds().left - this.mThumbW - this.mOverlaySize);
        } else {
          i = Math.min(this.mThumbDrawable.getBounds().right + this.mThumbW, this.mList.getWidth() - this.mOverlaySize);
        }
        j = Math.max(0, Math.min(k + (this.mThumbH - this.mOverlaySize) / 2, this.mList.getHeight() - this.mOverlaySize));
        localObject1 = this.mOverlayPos;
        ((RectF)localObject1).left = i;
        ((RectF)localObject1).right = (((RectF)localObject1).left + this.mOverlaySize);
        ((RectF)localObject1).top = j;
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.mOverlaySize);
        localObject2 = this.mOverlayDrawable;
        if (localObject2 != null) {
          ((Drawable)localObject2).setBounds((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
        }
      }
      localObject1 = this.mOverlayDrawable;
      if (localObject1 != null) {
        ((Drawable)localObject1).draw(paramCanvas);
      }
      localObject1 = this.mPaint;
      float f = ((Paint)localObject1).descent();
      Object localObject2 = this.mOverlayPos;
      Rect localRect = this.mTmpRect;
      Drawable localDrawable = this.mOverlayDrawable;
      if (localDrawable != null) {
        localDrawable.getPadding(localRect);
      }
      i = (localRect.right - localRect.left) / 2;
      j = (localRect.bottom - localRect.top) / 2;
      paramCanvas.drawText(this.mSectionText, (int)(((RectF)localObject2).left + ((RectF)localObject2).right) / 2 - i, (int)(((RectF)localObject2).bottom + ((RectF)localObject2).top) / 2 + this.mOverlaySize / 4 - f - j, (Paint)localObject1);
      return;
    }
    if (this.mState == 4)
    {
      if (i == 0)
      {
        setState(0);
        return;
      }
      if (this.mTrackDrawable != null)
      {
        paramCanvas = this.mList;
        paramCanvas.invalidate(m - this.mThumbW, 0, m, paramCanvas.getHeight());
        return;
      }
      this.mList.invalidate(m - this.mThumbW, k, m, this.mThumbH + k);
    }
  }
  
  SectionIndexer getSectionIndexer()
  {
    return this.mSectionIndexer;
  }
  
  Object[] getSections()
  {
    if ((this.mListAdapter == null) && (this.mList != null)) {
      getSectionsFromIndexer();
    }
    return this.mSections;
  }
  
  void getSectionsFromIndexer()
  {
    Object localObject2 = this.mList.getAdapter();
    this.mSectionIndexer = null;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof HeaderViewListAdapter))
    {
      localObject1 = (HeaderViewListAdapter)localObject2;
      this.mListOffset = ((HeaderViewListAdapter)localObject1).getHeadersCount();
      localObject1 = ((HeaderViewListAdapter)localObject1).getWrappedAdapter();
    }
    if ((localObject1 instanceof ExpandableListConnector))
    {
      localObject2 = ((ExpandableListConnector)localObject1).getAdapter();
      if ((localObject2 instanceof SectionIndexer))
      {
        this.mSectionIndexer = ((SectionIndexer)localObject2);
        this.mListAdapter = ((BaseAdapter)localObject1);
        this.mSections = this.mSectionIndexer.getSections();
      }
    }
    else if ((localObject1 instanceof SectionIndexer))
    {
      this.mListAdapter = ((BaseAdapter)localObject1);
      this.mSectionIndexer = ((SectionIndexer)localObject1);
      this.mSections = this.mSectionIndexer.getSections();
      if (this.mSections == null) {
        this.mSections = new String[] { " " };
      }
    }
    else
    {
      this.mListAdapter = ((BaseAdapter)localObject1);
      this.mSections = new String[] { " " };
    }
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getWidth()
  {
    return this.mThumbW;
  }
  
  public boolean isAlwaysShowEnabled()
  {
    return this.mAlwaysShow;
  }
  
  boolean isPointInside(float paramFloat1, float paramFloat2)
  {
    int i = this.mPosition;
    boolean bool2 = false;
    if (i != 1) {
      if (paramFloat1 <= this.mList.getWidth() - this.mThumbW) {}
    }
    for (;;)
    {
      i = 1;
      break;
      do
      {
        i = 0;
        break;
      } while (paramFloat1 >= this.mThumbW);
    }
    boolean bool1 = bool2;
    if (i != 0) {
      if (this.mTrackDrawable == null)
      {
        i = this.mThumbY;
        bool1 = bool2;
        if (paramFloat2 >= i)
        {
          bool1 = bool2;
          if (paramFloat2 > i + this.mThumbH) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  boolean isVisible()
  {
    return this.mState != 0;
  }
  
  boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        cancelPendingDrag();
      }
    }
    else if ((this.mState > 0) && (isPointInside(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      if (!this.mList.isInScrollingContainer())
      {
        beginDrag();
        return true;
      }
      this.mInitialTouchY = paramMotionEvent.getY();
      startPendingDrag();
    }
    return false;
  }
  
  void onItemCountChanged(int paramInt1, int paramInt2)
  {
    if (this.mAlwaysShow) {
      this.mLongList = true;
    }
  }
  
  void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mItemCount != paramInt3) && (paramInt2 > 0))
    {
      this.mItemCount = paramInt3;
      boolean bool;
      if (this.mItemCount / paramInt2 >= MIN_PAGES) {
        bool = true;
      } else {
        bool = false;
      }
      this.mLongList = bool;
    }
    if (this.mAlwaysShow) {
      this.mLongList = true;
    }
    if (!this.mLongList)
    {
      if (this.mState != 0) {
        setState(0);
      }
      return;
    }
    if ((paramInt3 - paramInt2 > 0) && (this.mState != 3))
    {
      this.mThumbY = getThumbPositionForListPosition(paramInt1, paramInt2, paramInt3);
      if (this.mChangedBounds)
      {
        resetThumbPos();
        this.mChangedBounds = false;
      }
    }
    this.mScrollCompleted = true;
    if (paramInt1 == this.mVisibleItem) {
      return;
    }
    this.mVisibleItem = paramInt1;
    if (this.mState != 3)
    {
      setState(2);
      if (!this.mAlwaysShow) {
        this.mHandler.postDelayed(this.mScrollFade, 1500L);
      }
    }
  }
  
  public void onSectionsChanged()
  {
    this.mListAdapter = null;
  }
  
  void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.mThumbDrawable;
    if (localObject != null) {
      if (this.mPosition != 1) {
        ((Drawable)localObject).setBounds(paramInt1 - this.mThumbW, 0, paramInt1, this.mThumbH);
      } else {
        ((Drawable)localObject).setBounds(0, 0, this.mThumbW, this.mThumbH);
      }
    }
    if (this.mOverlayPosition == 0)
    {
      localObject = this.mOverlayPos;
      ((RectF)localObject).left = ((paramInt1 - this.mOverlaySize) / 2);
      ((RectF)localObject).right = (((RectF)localObject).left + this.mOverlaySize);
      ((RectF)localObject).top = (paramInt2 / 10);
      ((RectF)localObject).bottom = (((RectF)localObject).top + this.mOverlaySize);
      Drawable localDrawable = this.mOverlayDrawable;
      if (localDrawable != null) {
        localDrawable.setBounds((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, (int)((RectF)localObject).bottom);
      }
    }
  }
  
  boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = this.mState;
    int i = 0;
    if (j == 0) {
      return false;
    }
    j = paramMotionEvent.getAction();
    if (j == 0)
    {
      if (isPointInside(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        if (!this.mList.isInScrollingContainer())
        {
          beginDrag();
          return true;
        }
        this.mInitialTouchY = paramMotionEvent.getY();
        startPendingDrag();
        return false;
      }
    }
    else
    {
      int k;
      int m;
      if (j == 1)
      {
        if (this.mPendingDrag)
        {
          beginDrag();
          k = this.mList.getHeight();
          i = (int)paramMotionEvent.getY();
          m = this.mThumbH;
          j = i - m + 10;
          if (j < 0)
          {
            i = 0;
          }
          else
          {
            i = j;
            if (j + m > k) {
              i = k - m;
            }
          }
          this.mThumbY = i;
          scrollTo(this.mThumbY / (k - this.mThumbH));
          cancelPendingDrag();
        }
        if (this.mState == 3)
        {
          paramMotionEvent = this.mList;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.requestDisallowInterceptTouchEvent(false);
            this.mList.reportScrollStateChange(0);
            setState(2);
          }
          paramMotionEvent = this.mHandler;
          paramMotionEvent.removeCallbacks(this.mScrollFade);
          if (!this.mAlwaysShow) {
            paramMotionEvent.postDelayed(this.mScrollFade, 1000L);
          }
          paramMotionEvent = this.mList;
          if (paramMotionEvent != null) {
            paramMotionEvent.invalidate();
          }
          return true;
        }
      }
      else if (j == 2)
      {
        AbsListView localAbsListView;
        if ((this.mPendingDrag) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) > this.mScaledTouchSlop))
        {
          setState(3);
          if ((this.mListAdapter == null) && (this.mList != null)) {
            getSectionsFromIndexer();
          }
          localAbsListView = this.mList;
          if (localAbsListView != null)
          {
            localAbsListView.requestDisallowInterceptTouchEvent(true);
            this.mList.reportScrollStateChange(1);
            cancelFling();
            cancelPendingDrag();
          }
        }
        if (this.mState == 3)
        {
          localAbsListView = this.mList;
          if (localAbsListView != null) {
            j = localAbsListView.getHeight();
          } else {
            j = 0;
          }
          k = (int)paramMotionEvent.getY();
          m = this.mThumbH;
          k = k - m + 10;
          if (k >= 0) {
            if (k + m > j) {
              i = j - m;
            } else {
              i = k;
            }
          }
          if (Math.abs(this.mThumbY - i) < 2) {
            return true;
          }
          this.mThumbY = i;
          if (this.mScrollCompleted) {
            scrollTo(this.mThumbY / (j - this.mThumbH));
          }
          return true;
        }
      }
      else if (j == 3)
      {
        cancelPendingDrag();
      }
    }
    return false;
  }
  
  void scrollTo(float paramFloat)
  {
    int i3 = this.mList.getCount();
    boolean bool2 = false;
    this.mScrollCompleted = false;
    float f2 = i3;
    float f1 = 1.0F / f2 / 8.0F;
    Object[] arrayOfObject = this.mSections;
    int j;
    int i;
    label236:
    label248:
    Object localObject;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      int i5 = arrayOfObject.length;
      float f3 = i5;
      j = (int)(paramFloat * f3);
      i = j;
      if (j >= i5) {
        i = i5 - 1;
      }
      j = this.mSectionIndexer.getPositionForSection(i);
      int i4 = i + 1;
      int i1;
      if (i < i5 - 1) {
        i1 = this.mSectionIndexer.getPositionForSection(i4);
      } else {
        i1 = i3;
      }
      int m;
      int k;
      if (i1 == j)
      {
        m = i;
        k = j;
        while (m > 0)
        {
          i2 = m - 1;
          n = this.mSectionIndexer.getPositionForSection(i2);
          if (n != j)
          {
            j = i2;
            k = n;
            break label236;
          }
          m = i2;
          k = n;
          if (i2 == 0)
          {
            m = i;
            j = 0;
            k = n;
            break label248;
          }
        }
        j = i;
        m = j;
      }
      else
      {
        m = i;
        k = j;
        j = m;
        n = j;
        m = j;
        j = n;
      }
      int i2 = i4 + 1;
      int n = i4;
      while ((i2 < i5) && (this.mSectionIndexer.getPositionForSection(i2) == i1))
      {
        i2 += 1;
        n += 1;
      }
      f2 = m / f3;
      f3 = n / f3;
      if ((m != i) || (paramFloat - f2 >= f1)) {
        k += (int)((i1 - k) * (paramFloat - f2) / (f3 - f2));
      }
      i = i3 - 1;
      if (k > i) {
        k = i;
      }
      localObject = this.mList;
      if ((localObject instanceof ExpandableListView))
      {
        localObject = (ExpandableListView)localObject;
        ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(k + this.mListOffset)), 0);
      }
      else if ((localObject instanceof ListView))
      {
        ((ListView)localObject).setSelectionFromTop(k + this.mListOffset, 0);
      }
      else
      {
        ((AbsListView)localObject).setSelection(k + this.mListOffset);
      }
    }
    else
    {
      i = (int)(f2 * paramFloat);
      j = i3 - 1;
      if (i > j) {
        i = j;
      }
      localObject = this.mList;
      if ((localObject instanceof ExpandableListView))
      {
        localObject = (ExpandableListView)localObject;
        ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i + this.mListOffset)), 0);
      }
      else if ((localObject instanceof ListView))
      {
        ((ListView)localObject).setSelectionFromTop(i + this.mListOffset, 0);
      }
      else
      {
        ((AbsListView)localObject).setSelection(i + this.mListOffset);
      }
      j = -1;
    }
    if (j >= 0)
    {
      localObject = arrayOfObject[j].toString();
      this.mSectionText = ((String)localObject);
      boolean bool1;
      if (((String)localObject).length() == 1)
      {
        bool1 = bool2;
        if (((String)localObject).charAt(0) == ' ') {}
      }
      else
      {
        bool1 = bool2;
        if (j < arrayOfObject.length) {
          bool1 = true;
        }
      }
      this.mDrawOverlay = bool1;
      return;
    }
    this.mDrawOverlay = false;
  }
  
  public void setAlwaysShow(boolean paramBoolean)
  {
    this.mAlwaysShow = paramBoolean;
    if (paramBoolean)
    {
      this.mHandler.removeCallbacks(this.mScrollFade);
      setState(2);
      return;
    }
    if (this.mState == 2) {
      this.mHandler.postDelayed(this.mScrollFade, 1500L);
    }
  }
  
  public void setScrollbarPosition(int paramInt)
  {
    this.mPosition = paramInt;
    if (paramInt != 1)
    {
      this.mOverlayDrawable = this.mOverlayDrawableRight;
      return;
    }
    this.mOverlayDrawable = this.mOverlayDrawableLeft;
  }
  
  public void setState(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            break label112;
          }
          int i = this.mList.getWidth();
          AbsListView localAbsListView = this.mList;
          int j = this.mThumbW;
          int k = this.mThumbY;
          localAbsListView.invalidate(i - j, k, i, this.mThumbH + k);
          break label112;
        }
      }
      else if (this.mState != 2) {
        resetThumbPos();
      }
      this.mHandler.removeCallbacks(this.mScrollFade);
    }
    else
    {
      this.mHandler.removeCallbacks(this.mScrollFade);
      this.mList.invalidate();
    }
    label112:
    this.mState = paramInt;
    refreshDrawableState();
  }
  
  void startPendingDrag()
  {
    this.mPendingDrag = true;
    this.mList.postDelayed(this.mDeferStartDrag, 180L);
  }
  
  void stop()
  {
    setState(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */