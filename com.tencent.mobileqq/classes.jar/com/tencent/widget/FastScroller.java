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
    int i = 0;
    if ((this.mSectionIndexer == null) || (this.mListAdapter == null)) {
      getSectionsFromIndexer();
    }
    if ((this.mSectionIndexer == null) || (!this.mMatchDragPosition)) {
      paramInt1 = (this.mList.getHeight() - this.mThumbH) * paramInt1 / (paramInt3 - paramInt2);
    }
    int j;
    do
    {
      return paramInt1;
      j = paramInt1 - this.mListOffset;
      paramInt1 = i;
    } while (j < 0);
    int k = this.mListOffset;
    int m = this.mList.getHeight() - this.mThumbH;
    paramInt1 = this.mSectionIndexer.getSectionForPosition(j);
    i = this.mSectionIndexer.getPositionForSection(paramInt1);
    int n = this.mSectionIndexer.getPositionForSection(paramInt1 + 1);
    int i1 = this.mSections.length;
    View localView = this.mList.getChildAt(0);
    if (localView == null) {}
    for (float f1 = 0.0F;; f1 = (this.mList.getPaddingTop() - localView.getTop()) / localView.getHeight() + f1)
    {
      i = (int)(((f1 - i) / (n - i) + paramInt1) / i1 * m);
      paramInt1 = i;
      if (j <= 0) {
        break;
      }
      paramInt1 = i;
      if (j + paramInt2 != paramInt3 - k) {
        break;
      }
      localView = this.mList.getChildAt(paramInt2 - 1);
      f1 = (this.mList.getHeight() - this.mList.getPaddingBottom() - localView.getTop()) / localView.getHeight();
      float f2 = i;
      return (int)((m - i) * f1 + f2);
      f1 = j;
    }
  }
  
  @TargetApi(11)
  private void init(Context paramContext)
  {
    boolean bool = true;
    int i = 0;
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(ATTRS);
    for (;;)
    {
      try
      {
        useThumbDrawable(paramContext, localTypedArray.getDrawable(1));
        this.mTrackDrawable = localTypedArray.getDrawable(2);
        this.mOverlayDrawableLeft = localTypedArray.getDrawable(3);
        this.mOverlayDrawableRight = localTypedArray.getDrawable(4);
        this.mOverlayPosition = localTypedArray.getInt(5, 0);
        this.mScrollCompleted = true;
        getSectionsFromIndexer();
        this.mOverlaySize = paramContext.getResources().getDimensionPixelSize(2131297028);
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
        if (paramContext.getApplicationInfo().targetSdkVersion >= 11)
        {
          this.mMatchDragPosition = bool;
          if (VersionUtils.e()) {
            i = this.mList.getVerticalScrollbarPosition();
          }
          setScrollbarPosition(i);
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      bool = false;
    }
  }
  
  private void refreshDrawableState()
  {
    if (this.mState == 3) {}
    for (int[] arrayOfInt = PRESSED_STATES;; arrayOfInt = DEFAULT_STATES)
    {
      if ((this.mThumbDrawable != null) && (this.mThumbDrawable.isStateful())) {
        this.mThumbDrawable.setState(arrayOfInt);
      }
      if ((this.mTrackDrawable != null) && (this.mTrackDrawable.isStateful())) {
        this.mTrackDrawable.setState(arrayOfInt);
      }
      return;
    }
  }
  
  private void resetThumbPos()
  {
    int i = this.mList.getWidth();
    switch (this.mPosition)
    {
    }
    for (;;)
    {
      this.mThumbDrawable.setAlpha(208);
      return;
      this.mThumbDrawable.setBounds(i - this.mThumbW, 0, i, this.mThumbH);
      continue;
      this.mThumbDrawable.setBounds(0, 0, this.mThumbW, this.mThumbH);
    }
  }
  
  private void useThumbDrawable(Context paramContext, Drawable paramDrawable)
  {
    this.mThumbDrawable = paramDrawable;
    if ((paramDrawable instanceof NinePatchDrawable)) {
      this.mThumbW = paramContext.getResources().getDimensionPixelSize(2131297030);
    }
    for (this.mThumbH = paramContext.getResources().getDimensionPixelSize(2131297029);; this.mThumbH = paramDrawable.getIntrinsicHeight())
    {
      this.mChangedBounds = true;
      return;
      this.mThumbW = paramDrawable.getIntrinsicWidth();
    }
  }
  
  void beginDrag()
  {
    setState(3);
    if ((this.mListAdapter == null) && (this.mList != null)) {
      getSectionsFromIndexer();
    }
    if (this.mList != null)
    {
      this.mList.requestDisallowInterceptTouchEvent(true);
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
    if (this.mState == 0) {}
    int k;
    int m;
    int i;
    do
    {
      return;
      k = this.mThumbY;
      m = this.mList.getWidth();
      Object localObject1 = this.mScrollFade;
      i = -1;
      int j;
      if (this.mState == 4)
      {
        j = ((FastScroller.ScrollFade)localObject1).getAlpha();
        if (j < 104) {
          this.mThumbDrawable.setAlpha(j * 2);
        }
      }
      switch (this.mPosition)
      {
      default: 
        i = 0;
        this.mThumbDrawable.setBounds(i, 0, this.mThumbW + i, this.mThumbH);
        this.mChangedBounds = true;
        i = j;
        if (this.mTrackDrawable != null)
        {
          localObject1 = this.mThumbDrawable.getBounds();
          int i1 = ((Rect)localObject1).left;
          j = (((Rect)localObject1).bottom - ((Rect)localObject1).top) / 2;
          int n = this.mTrackDrawable.getIntrinsicWidth();
          i1 = i1 + this.mThumbW / 2 - n / 2;
          this.mTrackDrawable.setBounds(i1, j, n + i1, this.mList.getHeight() - j);
          this.mTrackDrawable.draw(paramCanvas);
        }
        paramCanvas.translate(0.0F, k);
        this.mThumbDrawable.draw(paramCanvas);
        paramCanvas.translate(0.0F, -k);
        if ((this.mState != 3) || (!this.mDrawOverlay)) {
          continue;
        }
        if (this.mOverlayPosition == 1) {
          switch (this.mPosition)
          {
          }
        }
        break;
      }
      for (i = Math.max(0, this.mThumbDrawable.getBounds().left - this.mThumbW - this.mOverlaySize);; i = Math.min(this.mThumbDrawable.getBounds().right + this.mThumbW, this.mList.getWidth() - this.mOverlaySize))
      {
        j = Math.max(0, Math.min((this.mThumbH - this.mOverlaySize) / 2 + k, this.mList.getHeight() - this.mOverlaySize));
        localObject1 = this.mOverlayPos;
        ((RectF)localObject1).left = i;
        ((RectF)localObject1).right = (((RectF)localObject1).left + this.mOverlaySize);
        ((RectF)localObject1).top = j;
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.mOverlaySize);
        if (this.mOverlayDrawable != null) {
          this.mOverlayDrawable.setBounds((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
        }
        if (this.mOverlayDrawable != null) {
          this.mOverlayDrawable.draw(paramCanvas);
        }
        localObject1 = this.mPaint;
        float f1 = ((Paint)localObject1).descent();
        RectF localRectF = this.mOverlayPos;
        Object localObject2 = this.mTmpRect;
        if (this.mOverlayDrawable != null) {
          this.mOverlayDrawable.getPadding((Rect)localObject2);
        }
        i = (((Rect)localObject2).right - ((Rect)localObject2).left) / 2;
        j = (((Rect)localObject2).bottom - ((Rect)localObject2).top) / 2;
        localObject2 = this.mSectionText;
        float f2 = (int)(localRectF.left + localRectF.right) / 2 - i;
        float f3 = localRectF.bottom;
        paramCanvas.drawText((String)localObject2, f2, (int)(localRectF.top + f3) / 2 + this.mOverlaySize / 4 - f1 - j, (Paint)localObject1);
        return;
        i = m - this.mThumbW * j / 208;
        break;
        i = -this.mThumbW + this.mThumbW * j / 208;
        break;
      }
    } while (this.mState != 4);
    if (i == 0)
    {
      setState(0);
      return;
    }
    if (this.mTrackDrawable != null)
    {
      this.mList.invalidate(m - this.mThumbW, 0, m, this.mList.getHeight());
      return;
    }
    this.mList.invalidate(m - this.mThumbW, k, m, this.mThumbH + k);
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
      this.mListOffset = ((HeaderViewListAdapter)localObject2).getHeadersCount();
      localObject1 = ((HeaderViewListAdapter)localObject2).getWrappedAdapter();
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
    do
    {
      return;
      if (!(localObject1 instanceof SectionIndexer)) {
        break;
      }
      this.mListAdapter = ((BaseAdapter)localObject1);
      this.mSectionIndexer = ((SectionIndexer)localObject1);
      this.mSections = this.mSectionIndexer.getSections();
    } while (this.mSections != null);
    this.mSections = new String[] { " " };
    return;
    this.mListAdapter = ((BaseAdapter)localObject1);
    this.mSections = new String[] { " " };
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
    int i;
    switch (this.mPosition)
    {
    default: 
      if (paramFloat1 > this.mList.getWidth() - this.mThumbW) {
        i = 1;
      }
      break;
    }
    while ((i != 0) && ((this.mTrackDrawable != null) || ((paramFloat2 >= this.mThumbY) && (paramFloat2 <= this.mThumbY + this.mThumbH))))
    {
      return true;
      i = 0;
      continue;
      if (paramFloat1 < this.mThumbW) {
        i = 1;
      } else {
        i = 0;
      }
    }
    return false;
  }
  
  boolean isVisible()
  {
    return this.mState != 0;
  }
  
  boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if ((this.mState > 0) && (isPointInside(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (!this.mList.isInScrollingContainer())
        {
          beginDrag();
          return true;
        }
        this.mInitialTouchY = paramMotionEvent.getY();
        startPendingDrag();
        continue;
        cancelPendingDrag();
      }
    }
  }
  
  void onItemCountChanged(int paramInt1, int paramInt2)
  {
    if (this.mAlwaysShow) {
      this.mLongList = true;
    }
  }
  
  void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.mItemCount != paramInt3) && (paramInt2 > 0))
    {
      this.mItemCount = paramInt3;
      if (this.mItemCount / paramInt2 >= MIN_PAGES)
      {
        bool = true;
        this.mLongList = bool;
      }
    }
    else
    {
      if (this.mAlwaysShow) {
        this.mLongList = true;
      }
      if (this.mLongList) {
        break label78;
      }
      if (this.mState != 0) {
        setState(0);
      }
    }
    label78:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
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
        } while (paramInt1 == this.mVisibleItem);
        this.mVisibleItem = paramInt1;
      } while (this.mState == 3);
      setState(2);
    } while (this.mAlwaysShow);
    this.mHandler.postDelayed(this.mScrollFade, 1500L);
  }
  
  public void onSectionsChanged()
  {
    this.mListAdapter = null;
  }
  
  void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mThumbDrawable != null) {
      switch (this.mPosition)
      {
      default: 
        this.mThumbDrawable.setBounds(paramInt1 - this.mThumbW, 0, paramInt1, this.mThumbH);
      }
    }
    for (;;)
    {
      if (this.mOverlayPosition == 0)
      {
        RectF localRectF = this.mOverlayPos;
        localRectF.left = ((paramInt1 - this.mOverlaySize) / 2);
        localRectF.right = (localRectF.left + this.mOverlaySize);
        localRectF.top = (paramInt2 / 10);
        localRectF.bottom = (localRectF.top + this.mOverlaySize);
        if (this.mOverlayDrawable != null) {
          this.mOverlayDrawable.setBounds((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
        }
      }
      return;
      this.mThumbDrawable.setBounds(0, 0, this.mThumbW, this.mThumbH);
    }
  }
  
  boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.mState == 0) {}
    int j;
    int k;
    label221:
    do
    {
      do
      {
        return false;
        j = paramMotionEvent.getAction();
        if (j != 0) {
          break;
        }
      } while (!isPointInside(paramMotionEvent.getX(), paramMotionEvent.getY()));
      if (!this.mList.isInScrollingContainer())
      {
        beginDrag();
        return true;
      }
      this.mInitialTouchY = paramMotionEvent.getY();
      startPendingDrag();
      return false;
      if (j == 1)
      {
        if (this.mPendingDrag)
        {
          beginDrag();
          k = this.mList.getHeight();
          j = (int)paramMotionEvent.getY() - this.mThumbH + 10;
          if (j >= 0) {
            break label221;
          }
          i = 0;
        }
        for (;;)
        {
          this.mThumbY = i;
          scrollTo(this.mThumbY / (k - this.mThumbH));
          cancelPendingDrag();
          if (this.mState != 3) {
            break;
          }
          if (this.mList != null)
          {
            this.mList.requestDisallowInterceptTouchEvent(false);
            this.mList.reportScrollStateChange(0);
            setState(2);
          }
          paramMotionEvent = this.mHandler;
          paramMotionEvent.removeCallbacks(this.mScrollFade);
          if (!this.mAlwaysShow) {
            paramMotionEvent.postDelayed(this.mScrollFade, 1000L);
          }
          if (this.mList != null) {
            this.mList.invalidate();
          }
          return true;
          i = j;
          if (this.mThumbH + j > k) {
            i = k - this.mThumbH;
          }
        }
      }
      if (j != 2) {
        break;
      }
      if ((this.mPendingDrag) && (Math.abs(paramMotionEvent.getY() - this.mInitialTouchY) > this.mScaledTouchSlop))
      {
        setState(3);
        if ((this.mListAdapter == null) && (this.mList != null)) {
          getSectionsFromIndexer();
        }
        if (this.mList != null)
        {
          this.mList.requestDisallowInterceptTouchEvent(true);
          this.mList.reportScrollStateChange(1);
          cancelFling();
          cancelPendingDrag();
        }
      }
    } while (this.mState != 3);
    if (this.mList != null)
    {
      j = this.mList.getHeight();
      label355:
      k = (int)paramMotionEvent.getY() - this.mThumbH + 10;
      if (k >= 0) {
        break label395;
      }
    }
    for (;;)
    {
      if (Math.abs(this.mThumbY - i) < 2)
      {
        return true;
        j = 0;
        break label355;
        label395:
        if (this.mThumbH + k <= j) {
          break label458;
        }
        i = j - this.mThumbH;
        continue;
      }
      this.mThumbY = i;
      if (this.mScrollCompleted) {
        scrollTo(this.mThumbY / (j - this.mThumbH));
      }
      return true;
      if (j != 3) {
        break;
      }
      cancelPendingDrag();
      return false;
      label458:
      i = k;
    }
  }
  
  void scrollTo(float paramFloat)
  {
    int i3 = this.mList.getCount();
    this.mScrollCompleted = false;
    float f1 = 1.0F / i3 / 8.0F;
    Object[] arrayOfObject = this.mSections;
    int i4;
    int j;
    int i;
    int k;
    int i1;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      i4 = arrayOfObject.length;
      j = (int)(i4 * paramFloat);
      i = j;
      if (j >= i4) {
        i = i4 - 1;
      }
      k = this.mSectionIndexer.getPositionForSection(i);
      i1 = i + 1;
      if (i >= i4 - 1) {
        break label622;
      }
    }
    label587:
    label590:
    label593:
    label622:
    for (int n = this.mSectionIndexer.getPositionForSection(i + 1);; n = i3)
    {
      int m;
      if (n == k)
      {
        j = k;
        m = i;
        if (m > 0)
        {
          m -= 1;
          j = this.mSectionIndexer.getPositionForSection(m);
          if (j != k)
          {
            k = j;
            j = m;
          }
        }
      }
      for (;;)
      {
        int i2 = i1 + 1;
        for (;;)
        {
          if ((i2 < i4) && (this.mSectionIndexer.getPositionForSection(i2) == n))
          {
            i2 += 1;
            i1 += 1;
            continue;
            if (m != 0) {
              break label593;
            }
            i2 = 0;
            m = i;
            k = j;
            j = i2;
            break;
          }
        }
        float f2 = m / i4;
        float f3 = i1 / i4;
        if ((m == i) && (paramFloat - f2 < f1))
        {
          i = k;
          if (i <= i3 - 1) {
            break label590;
          }
          i = i3 - 1;
        }
        for (;;)
        {
          Object localObject;
          if ((this.mList instanceof ExpandableListView))
          {
            localObject = (ExpandableListView)this.mList;
            ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i + this.mListOffset)), 0);
          }
          boolean bool;
          for (;;)
          {
            if (j >= 0)
            {
              localObject = arrayOfObject[j].toString();
              this.mSectionText = ((String)localObject);
              if (((((String)localObject).length() != 1) || (((String)localObject).charAt(0) != ' ')) && (j < arrayOfObject.length))
              {
                bool = true;
                label379:
                this.mDrawOverlay = bool;
                return;
                i = (int)((n - k) * (paramFloat - f2) / (f3 - f2)) + k;
                break;
                if ((this.mList instanceof ListView))
                {
                  ((ListView)this.mList).setSelectionFromTop(i + this.mListOffset, 0);
                  continue;
                }
                this.mList.setSelection(i + this.mListOffset);
                continue;
                i = (int)(i3 * paramFloat);
                if (i <= i3 - 1) {
                  break label587;
                }
                i = i3 - 1;
              }
            }
          }
          for (;;)
          {
            if ((this.mList instanceof ExpandableListView))
            {
              localObject = (ExpandableListView)this.mList;
              ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i + this.mListOffset)), 0);
            }
            for (;;)
            {
              j = -1;
              break;
              if ((this.mList instanceof ListView)) {
                ((ListView)this.mList).setSelectionFromTop(i + this.mListOffset, 0);
              } else {
                this.mList.setSelection(i + this.mListOffset);
              }
            }
            bool = false;
            break label379;
            this.mDrawOverlay = false;
            return;
          }
        }
        break;
        k = j;
        j = i;
        m = i;
        continue;
        m = i;
        j = i;
      }
    }
  }
  
  public void setAlwaysShow(boolean paramBoolean)
  {
    this.mAlwaysShow = paramBoolean;
    if (paramBoolean)
    {
      this.mHandler.removeCallbacks(this.mScrollFade);
      setState(2);
    }
    while (this.mState != 2) {
      return;
    }
    this.mHandler.postDelayed(this.mScrollFade, 1500L);
  }
  
  public void setScrollbarPosition(int paramInt)
  {
    this.mPosition = paramInt;
    switch (paramInt)
    {
    default: 
      this.mOverlayDrawable = this.mOverlayDrawableRight;
      return;
    }
    this.mOverlayDrawable = this.mOverlayDrawableLeft;
  }
  
  public void setState(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mState = paramInt;
      refreshDrawableState();
      return;
      this.mHandler.removeCallbacks(this.mScrollFade);
      this.mList.invalidate();
      continue;
      if (this.mState != 2) {
        resetThumbPos();
      }
      this.mHandler.removeCallbacks(this.mScrollFade);
      continue;
      int i = this.mList.getWidth();
      this.mList.invalidate(i - this.mThumbW, this.mThumbY, i, this.mThumbY + this.mThumbH);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */