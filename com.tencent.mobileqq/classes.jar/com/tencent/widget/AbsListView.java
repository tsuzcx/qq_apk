package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.LongSparseArray;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filter.FilterListener;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbsListView
  extends AdapterView<ListAdapter>
  implements TextWatcher, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener, Filter.FilterListener
{
  private static final int[] ABSLISTVIEW = getStyleableValues("AbsListView");
  private static final int ABSLISTVIEW_CACHECOLORHINT;
  private static final int ABSLISTVIEW_CHOICEMODE;
  private static final int ABSLISTVIEW_DRAWSELECTORONTOP = getStyleableValue("AbsListView_drawSelectorOnTop");
  private static final int ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE;
  private static final int ABSLISTVIEW_FASTSCROLLENABLED;
  private static final int ABSLISTVIEW_LIST_SELECTOR = getStyleableValue("AbsListView_listSelector");
  private static final int ABSLISTVIEW_SCROLLINGCACHE;
  private static final int ABSLISTVIEW_SMOOTHSCROLLBAR;
  private static final int ABSLISTVIEW_STACKFROMBOTTOM;
  private static final int ABSLISTVIEW_TEXTFILTERENABLED;
  private static final int ABSLISTVIEW_TRANSCRIPTMODE;
  private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
  public static final int CHOICE_MODE_MULTIPLE = 2;
  public static final int CHOICE_MODE_MULTIPLE_MODAL = 3;
  public static final int CHOICE_MODE_NONE = 0;
  public static final int CHOICE_MODE_SINGLE = 1;
  public static final int INVALID_POINTER = -1;
  static final int LAYOUT_FORCE_BOTTOM = 3;
  static final int LAYOUT_FORCE_TOP = 1;
  static final int LAYOUT_MOVE_SELECTION = 6;
  static final int LAYOUT_NORMAL = 0;
  static final int LAYOUT_SET_SELECTION = 2;
  static final int LAYOUT_SPECIFIC = 4;
  static final int LAYOUT_SPECIFIC_BOTTOM = 100;
  static final int LAYOUT_SYNC = 5;
  private static final int[] NOTHING = { 0 };
  static final int OVERSCROLL_LIMIT_DIVISOR = 3;
  private static final int OVER_FLING_DISTANCE = 30;
  public static final int OVER_SCROLL_TOUCH_MODE_FAST = 1;
  public static final int OVER_SCROLL_TOUCH_MODE_NORMAL = 0;
  public static final int OVER_SCROLL_TOUCH_MODE_SMOOTH = 2;
  private static final boolean PROFILE_FLINGING = false;
  private static final boolean PROFILE_SCROLLING = false;
  protected static final int TOUCH_MODE_DONE_WAITING = 2;
  protected static final int TOUCH_MODE_DOWN = 0;
  protected static final int TOUCH_MODE_FLING = 4;
  private static final int TOUCH_MODE_OFF = 1;
  private static final int TOUCH_MODE_ON = 0;
  protected static final int TOUCH_MODE_OVERFLING = 6;
  protected static final int TOUCH_MODE_OVERSCROLL = 5;
  protected static final int TOUCH_MODE_REST = -1;
  protected static final int TOUCH_MODE_SCROLL = 3;
  protected static final int TOUCH_MODE_TAP = 1;
  private static final int TOUCH_MODE_UNKNOWN = -1;
  public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
  public static final int TRANSCRIPT_MODE_DISABLED = 0;
  public static final int TRANSCRIPT_MODE_NORMAL = 1;
  private int mActivePointerId = -1;
  ListAdapter mAdapter;
  int mBottomOverflingDistance;
  private AbsListView.MoveToBottomScroller mBottomScroller;
  int mCacheColorHint;
  boolean mCachingActive;
  boolean mCachingStarted;
  private boolean mCallbackOnUnClickItem = false;
  SparseBooleanArray mCheckStates;
  LongSparseArray<Integer> mCheckedIdStates;
  int mCheckedItemCount;
  ActionMode mChoiceActionMode;
  int mChoiceMode = 0;
  private Runnable mClearScrollingCache;
  private ContextMenu.ContextMenuInfo mContextMenuInfo = null;
  AbsListView.AdapterDataSetObserver mDataSetObserver;
  private InputConnection mDefInputConnection;
  private boolean mDeferNotifyDataSetChanged = false;
  private float mDensityScale;
  private int mDirection = 0;
  private boolean mDisableOverScrollTop = false;
  boolean mDrawSelectorOnTop = false;
  private boolean mEdgeEffectEnabled = false;
  public EdgeEffect mEdgeGlowBottom;
  public EdgeEffect mEdgeGlowTop;
  public boolean mEnableStory = false;
  boolean mFastScrollEnabled;
  FastScroller mFastScroller;
  private boolean mFiltered;
  private int mFirstPositionDistanceGuess;
  private boolean mFlingProfilingStarted = false;
  private AbsListView.FlingRunnable mFlingRunnable;
  private Object mFlingStrictSpan = null;
  public boolean mForContacts = false;
  public boolean mForHongBao = false;
  public boolean mForStory = false;
  private boolean mForceTranscriptScroll;
  private boolean mGlobalLayoutListenerAddedFilter;
  private int mGlowPaddingLeft;
  private int mGlowPaddingRight;
  boolean mIsAttached;
  private boolean mIsChildViewEnabled;
  private boolean mIsNeedScrollPositionTop;
  final boolean[] mIsScrap = new boolean[1];
  private int mLastAccessibilityScrollEventFromIndex;
  private int mLastAccessibilityScrollEventToIndex;
  private int mLastHandledItemCount;
  private int mLastPositionDistanceGuess;
  private int mLastScrollState = 0;
  private int mLastTouchMode = -1;
  int mLastY;
  int mLayoutMode = 0;
  protected Rect mListPadding = new Rect();
  private int mMaximumVelocity;
  private int mMinimumVelocity;
  int mMotionCorrection;
  int mMotionPosition;
  int mMotionViewNewTop;
  int mMotionViewOriginalTop;
  int mMotionX;
  int mMotionY;
  AbsListView.MultiChoiceModeWrapper mMultiChoiceModeCallback;
  private boolean mNeedCheckSpringback = false;
  private AbsListView.OnScrollButtomListener mOnScrollButtomListener;
  private AbsListView.OnScrollListener mOnScrollListener;
  private ArrayList<AbsListView.OnScrollListener> mOnScrollListenerList = new ArrayList();
  private int mOverScrollMode;
  private int mOverScrollTouchMode = 0;
  int mOverscrollDistance;
  int mOverscrollMax;
  private AbsListView.CheckForKeyLongPress mPendingCheckForKeyLongPress;
  private AbsListView.CheckForLongPress mPendingCheckForLongPress;
  private Runnable mPendingCheckForTap;
  private AbsListView.PerformClick mPerformClick;
  PopupWindow mPopup;
  private boolean mPopupHidden;
  AbsListView.PositionScroller mPositionScroller;
  private InputConnectionWrapper mPublicInputConnection;
  final AbsListView.RecycleBin mRecycler = new AbsListView.RecycleBin(this);
  int mResurrectToPosition = -1;
  View mScrollDown;
  private boolean mScrollProfilingStarted = false;
  private Object mScrollStrictSpan = null;
  protected boolean mScrollToBottom;
  View mScrollUp;
  boolean mScrollingCacheEnabled;
  int mSelectedTop = 0;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  Drawable mSelector;
  int mSelectorPosition = -1;
  Rect mSelectorRect = new Rect();
  private boolean mSmoothScrollbarEnabled = true;
  boolean mStackFromBottom;
  EditText mTextFilter;
  private boolean mTextFilterEnabled;
  int mTopOverflingDistance;
  private Rect mTouchFrame;
  protected int mTouchMode = -1;
  private Runnable mTouchModeReset;
  private int mTouchSlop;
  private int mTranscriptMode;
  private float mVelocityScale = 1.0F;
  private VelocityTracker mVelocityTracker;
  int mWidthMeasureSpec = 0;
  Method method = null;
  private AbsListView.OnNestedScrollingListener onNestedScrollingListener;
  
  static
  {
    ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE = getStyleableValue("AbsListView_fastScrollAlwaysVisible");
    ABSLISTVIEW_CHOICEMODE = getStyleableValue("AbsListView_choiceMode");
    ABSLISTVIEW_SMOOTHSCROLLBAR = getStyleableValue("AbsListView_smoothScrollbar");
    ABSLISTVIEW_FASTSCROLLENABLED = getStyleableValue("AbsListView_fastScrollEnabled");
    ABSLISTVIEW_CACHECOLORHINT = getStyleableValue("AbsListView_cacheColorHint");
    ABSLISTVIEW_TRANSCRIPTMODE = getStyleableValue("AbsListView_transcriptMode");
    ABSLISTVIEW_TEXTFILTERENABLED = getStyleableValue("AbsListView_textFilterEnabled");
    ABSLISTVIEW_SCROLLINGCACHE = getStyleableValue("AbsListView_scrollingCache");
    ABSLISTVIEW_STACKFROMBOTTOM = getStyleableValue("AbsListView_stackFromBottom");
  }
  
  public AbsListView(Context paramContext)
  {
    super(paramContext);
    initAbsListView();
    setVerticalScrollBarEnabled(true);
    paramContext = paramContext.obtainStyledAttributes(getStyleableValues("View"));
    QQViewCompatUtil.a(this, paramContext);
    paramContext.recycle();
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842858);
  }
  
  public AbsListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initAbsListView();
    paramContext = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, ABSLISTVIEW, paramInt, 0));
    try
    {
      paramAttributeSet = paramContext.getDrawable(ABSLISTVIEW_LIST_SELECTOR);
      if (paramAttributeSet != null) {
        setSelector(paramAttributeSet);
      }
    }
    catch (Throwable paramAttributeSet)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AbsListView init error:");
      localStringBuilder.append(paramAttributeSet.getMessage());
      QLog.e("XListView", 1, localStringBuilder.toString());
    }
    this.mDrawSelectorOnTop = paramContext.getBoolean(ABSLISTVIEW_DRAWSELECTORONTOP, false);
    setStackFromBottom(paramContext.getBoolean(ABSLISTVIEW_STACKFROMBOTTOM, false));
    setScrollingCacheEnabled(paramContext.getBoolean(ABSLISTVIEW_SCROLLINGCACHE, true));
    setTextFilterEnabled(paramContext.getBoolean(ABSLISTVIEW_TEXTFILTERENABLED, false));
    setTranscriptMode(paramContext.getInt(ABSLISTVIEW_TRANSCRIPTMODE, 0));
    setCacheColorHint(paramContext.getColor(ABSLISTVIEW_CACHECOLORHINT, 0));
    setFastScrollEnabled(paramContext.getBoolean(ABSLISTVIEW_FASTSCROLLENABLED, false));
    setSmoothScrollbarEnabled(paramContext.getBoolean(ABSLISTVIEW_SMOOTHSCROLLBAR, true));
    setChoiceMode(paramContext.getInt(ABSLISTVIEW_CHOICEMODE, 0));
    setFastScrollAlwaysVisible(paramContext.getBoolean(ABSLISTVIEW_FASTSCROLLALWAYSVISIBLE, false));
    paramContext.recycle();
  }
  
  private boolean acceptFilter()
  {
    return (this.mTextFilterEnabled) && ((getAdapter() instanceof Filterable)) && (((Filterable)getAdapter()).getFilter() != null);
  }
  
  private boolean checkScrap(ArrayList<View> paramArrayList)
  {
    if (paramArrayList == null) {
      return true;
    }
    int j = paramArrayList.size();
    int i = 0;
    boolean bool = true;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      if (localView.getParent() != null) {
        bool = false;
      }
      if (indexOfChild(localView) >= 0) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  private void clearScrollingCache()
  {
    if (this.mClearScrollingCache == null) {
      this.mClearScrollingCache = new AbsListView.2(this);
    }
    Handler localHandler2 = getHandler();
    Handler localHandler1 = localHandler2;
    if (localHandler2 == null) {
      localHandler1 = new Handler(Looper.getMainLooper());
    }
    localHandler1.post(this.mClearScrollingCache);
  }
  
  private boolean contentFits()
  {
    int i = getChildCount();
    if (i == 0) {
      return true;
    }
    if (i != this.mItemCount) {
      return false;
    }
    return (getChildAt(0).getTop() >= this.mListPadding.top) && (getChildAt(i - 1).getBottom() <= getHeight() - this.mListPadding.bottom);
  }
  
  private void createScrollingCache()
  {
    if ((this.mScrollingCacheEnabled) && (!this.mCachingStarted))
    {
      setChildrenDrawnWithCacheEnabled(true);
      setChildrenDrawingCacheEnabled(true);
      this.mCachingActive = true;
      this.mCachingStarted = true;
    }
  }
  
  private void createTextFilter(boolean paramBoolean)
  {
    if (this.mPopup == null)
    {
      Context localContext = getContext();
      PopupWindow localPopupWindow = new PopupWindow(localContext);
      this.mTextFilter = ((EditText)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131563005, null));
      this.mTextFilter.setRawInputType(177);
      this.mTextFilter.setImeOptions(268435456);
      this.mTextFilter.addTextChangedListener(this);
      localPopupWindow.setFocusable(false);
      localPopupWindow.setTouchable(false);
      localPopupWindow.setInputMethodMode(2);
      localPopupWindow.setContentView(this.mTextFilter);
      localPopupWindow.setWidth(-2);
      localPopupWindow.setHeight(-2);
      localPopupWindow.setBackgroundDrawable(null);
      this.mPopup = localPopupWindow;
      getViewTreeObserver().addOnGlobalLayoutListener(this);
      this.mGlobalLayoutListenerAddedFilter = true;
    }
    if (paramBoolean)
    {
      this.mPopup.setAnimationStyle(2131755031);
      return;
    }
    this.mPopup.setAnimationStyle(2131755032);
  }
  
  private void dismissPopup()
  {
    PopupWindow localPopupWindow = this.mPopup;
    if (localPopupWindow != null) {
      localPopupWindow.dismiss();
    }
  }
  
  private void dispatchStartTemporaryDetachForView(View paramView)
  {
    onDetachChildView(paramView);
    try
    {
      if (this.method == null) {
        this.method = View.class.getMethod("dispatchStartTemporaryDetach", new Class[0]);
      }
      this.method.invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      label43:
      break label43;
    }
    paramView.onStartTemporaryDetach();
  }
  
  private void drawSelector(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = this.mSelector;
      localDrawable.setBounds(this.mSelectorRect);
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(9)
  private Object enterCriticalSpan(String paramString)
  {
    return null;
  }
  
  private void finishGlows()
  {
    EdgeEffect localEdgeEffect = this.mEdgeGlowTop;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.finish();
      this.mEdgeGlowBottom.finish();
    }
  }
  
  @TargetApi(9)
  private Object finishSpan(Object paramObject)
  {
    return null;
  }
  
  static int getDistance(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    int m;
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 17)
      {
        if (paramInt != 33)
        {
          if (paramInt != 66)
          {
            if (paramInt == 130)
            {
              k = paramRect1.left + paramRect1.width() / 2;
              i = paramRect1.bottom;
              paramInt = paramRect2.left + paramRect2.width() / 2;
              j = paramRect2.top;
              break label276;
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
          }
          j = paramRect1.right;
          paramInt = paramRect1.top;
          i = paramRect1.height() / 2 + paramInt;
          paramInt = paramRect2.left;
          k = paramRect2.top;
          m = paramRect2.height() / 2;
        }
        else
        {
          k = paramRect1.left + paramRect1.width() / 2;
          i = paramRect1.top;
          paramInt = paramRect2.left + paramRect2.width() / 2;
          j = paramRect2.bottom;
          break label276;
        }
      }
      else
      {
        j = paramRect1.left;
        paramInt = paramRect1.top;
        i = paramRect1.height() / 2 + paramInt;
        paramInt = paramRect2.right;
        k = paramRect2.top;
        m = paramRect2.height() / 2;
      }
    }
    else
    {
      j = paramRect1.right + paramRect1.width() / 2;
      paramInt = paramRect1.top;
      i = paramRect1.height() / 2 + paramInt;
      paramInt = paramRect2.left + paramRect2.width() / 2;
      k = paramRect2.top;
      m = paramRect2.height() / 2;
    }
    m += k;
    int k = j;
    int j = m;
    label276:
    paramInt -= k;
    int i = j - i;
    return i * i + paramInt * paramInt;
  }
  
  @TargetApi(9)
  private void initAbsListView()
  {
    setClickable(true);
    setFocusableInTouchMode(true);
    setWillNotDraw(false);
    setAlwaysDrawnWithCacheEnabled(false);
    setScrollingCacheEnabled(true);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinimumVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaximumVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    float f = getResources().getDisplayMetrics().density;
    this.mOverscrollDistance = ((int)(0.0F * f + 0.5F));
    int i = (int)(f * 30.0F + 0.5F);
    this.mBottomOverflingDistance = i;
    this.mTopOverflingDistance = i;
    this.mDensityScale = getContext().getResources().getDisplayMetrics().density;
    setOverScrollMode(0);
    setVerticalFadingEdgeEnabled(false);
  }
  
  private void initOrResetVelocityTracker()
  {
    VelocityTracker localVelocityTracker = this.mVelocityTracker;
    if (localVelocityTracker == null)
    {
      this.mVelocityTracker = VelocityTracker.obtain();
      return;
    }
    localVelocityTracker.clear();
  }
  
  private void initVelocityTrackerIfNotExists()
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private boolean isValidPosition(int paramInt1, int paramInt2)
  {
    return (this.mItemCount > 0) && (paramInt1 != -1) && (paramInt1 < paramInt2);
  }
  
  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mMotionX = ((int)paramMotionEvent.getX(i));
      this.mMotionY = ((int)paramMotionEvent.getY(i));
      this.mMotionCorrection = 0;
      this.mActivePointerId = paramMotionEvent.getPointerId(i);
    }
  }
  
  private void positionPopup()
  {
    int i = getResources().getDisplayMetrics().heightPixels;
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    i = i - arrayOfInt[1] - getHeight() + (int)(this.mDensityScale * 20.0F);
    if (!this.mPopup.isShowing())
    {
      this.mPopup.showAtLocation(this, 81, arrayOfInt[0], i);
      return;
    }
    this.mPopup.update(arrayOfInt[0], i, -1, -1);
  }
  
  private void positionSelector(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mSelectorRect.set(paramInt1 - this.mSelectionLeftPadding, paramInt2 - this.mSelectionTopPadding, paramInt3 + this.mSelectionRightPadding, paramInt4 + this.mSelectionBottomPadding);
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
  
  static View retrieveFromScrap(ArrayList<View> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramArrayList.get(i);
        if (((AbsListView.LayoutParams)localView.getLayoutParams()).scrappedFromPosition == paramInt)
        {
          paramArrayList.remove(i);
          return localView;
        }
        i += 1;
      }
      return (View)paramArrayList.remove(j - 1);
    }
    return null;
  }
  
  private int reviseOverScrollByTouch(int paramInt)
  {
    if (getScrollY() * paramInt < 0) {
      return paramInt;
    }
    if (this.mLayoutHeight == 0) {
      return paramInt;
    }
    int i = this.mOverScrollTouchMode;
    if (i == 2) {
      return paramInt;
    }
    if (i == 1) {
      return (this.mLayoutHeight - Math.abs(getScrollY())) * paramInt / this.mLayoutHeight * 2 / 3;
    }
    return (this.mLayoutHeight - Math.abs(getScrollY())) * paramInt / this.mLayoutHeight / 2;
  }
  
  @TargetApi(9)
  private void scrollIfNeeded(int paramInt)
  {
    int n = paramInt - this.mMotionY;
    int m = n - this.mMotionCorrection;
    int i = this.mLastY;
    if (i != -2147483648) {
      i = paramInt - i;
    } else {
      i = m;
    }
    int j = this.mTouchMode;
    Object localObject;
    int k;
    if (j == 3)
    {
      if (this.mScrollStrictSpan == null) {
        this.mScrollStrictSpan = enterCriticalSpan("AbsListView-scroll");
      }
      if (paramInt != this.mLastY)
      {
        if (((getQQGroupFlag() & 0x80000) == 0) && (Math.abs(n) > this.mTouchSlop))
        {
          localObject = getParent();
          if (localObject != null) {
            ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
          }
        }
        j = this.mMotionPosition;
        if (j >= 0) {
          j -= this.mFirstPosition;
        } else {
          j = getChildCount() / 2;
        }
        localObject = getChildAt(j);
        if (localObject != null) {
          k = ((View)localObject).getTop();
        } else {
          k = 0;
        }
        boolean bool;
        if (i != 0) {
          bool = trackMotionScroll(m, i);
        } else {
          bool = false;
        }
        localObject = getChildAt(j);
        if (localObject != null)
        {
          j = ((View)localObject).getTop();
          if (bool)
          {
            j = -i - (j - k);
            k = reviseOverScrollByTouch(j);
            if ((this.mForHongBao) && (k > 0)) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0) {
              overScrollBy(0, k, 0, getScrollY(), 0, 0, 0, this.mOverscrollDistance, true);
            }
            if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollY()))
            {
              localObject = this.mVelocityTracker;
              if (localObject != null) {
                ((VelocityTracker)localObject).clear();
              }
            }
            k = getOverScrollMode();
            if ((i != 0) && ((k == 0) || ((k == 1) && (!contentFits()))))
            {
              this.mDirection = 0;
              this.mTouchMode = 5;
              localObject = this.mEdgeGlowTop;
              if (localObject != null) {
                if (n > 0)
                {
                  ((EdgeEffect)localObject).onPull(j / getHeight());
                  if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                  }
                }
                else if (n < 0)
                {
                  this.mEdgeGlowBottom.onPull(j / getHeight());
                  if (!this.mEdgeGlowTop.isFinished()) {
                    this.mEdgeGlowTop.onRelease();
                  }
                }
              }
            }
          }
          this.mMotionY = paramInt;
          invalidate();
        }
        this.mLastY = paramInt;
      }
    }
    else if ((j == 5) && (paramInt != this.mLastY))
    {
      m = getScrollY();
      int i1 = m - i;
      if (paramInt > this.mLastY) {
        j = 1;
      } else {
        j = -1;
      }
      if (this.mDirection == 0) {
        this.mDirection = j;
      }
      k = -i;
      if (((i1 < 0) && (m >= 0)) || ((i1 > 0) && (m <= 0)))
      {
        k = -m;
        i += k;
      }
      else
      {
        i = 0;
      }
      if (k != 0)
      {
        m = getScrollY();
        overScrollBy(0, reviseOverScrollByTouch(k), 0, m, 0, 0, 0, this.mOverscrollDistance, true);
        m = getOverScrollMode();
        if ((m == 0) || ((m == 1) && (!contentFits())))
        {
          localObject = this.mEdgeGlowTop;
          if (localObject != null) {
            if (n > 0)
            {
              ((EdgeEffect)localObject).onPull(k / getHeight());
              if (!this.mEdgeGlowBottom.isFinished()) {
                this.mEdgeGlowBottom.onRelease();
              }
            }
            else if (n < 0)
            {
              this.mEdgeGlowBottom.onPull(k / getHeight());
              if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
              }
            }
          }
          invalidate();
        }
      }
      k = i;
      if (k != 0)
      {
        i = 0;
        setScrollY(0);
        invalidateParentIfNeeded();
        if (k != 0) {
          trackMotionScroll(k, k);
        }
        this.mTouchMode = 3;
        k = findClosestMotionRow(paramInt);
        this.mMotionCorrection = 0;
        localObject = getChildAt(k - this.mFirstPosition);
        if (localObject != null) {
          i = ((View)localObject).getTop();
        }
        this.mMotionViewOriginalTop = i;
        this.mMotionY = paramInt;
        this.mMotionPosition = k;
      }
      this.mLastY = paramInt;
      this.mDirection = j;
    }
  }
  
  private void showPopup()
  {
    if (getWindowVisibility() == 0)
    {
      createTextFilter(true);
      positionPopup();
      checkFocus();
    }
  }
  
  private void useDefaultSelector()
  {
    setSelector(getResources().getDrawable(17301602));
  }
  
  protected void abordFling()
  {
    AbsListView.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if (localFlingRunnable != null) {
      localFlingRunnable.endFling();
    }
  }
  
  @androidx.annotation.RequiresApi(api=16)
  public void addChildrenForAccessibility(ArrayList<View> paramArrayList)
  {
    try
    {
      super.addChildrenForAccessibility(paramArrayList);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label6:
      int j;
      int i;
      break label6;
    }
    j = getChildCount();
    i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 0) {
        if (QQViewCompatUtil.a(localView)) {
          paramArrayList.add(localView);
        } else {
          localView.addChildrenForAccessibility(paramArrayList);
        }
      }
      i += 1;
    }
  }
  
  public void addOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListenerList.add(paramOnScrollListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int j = getChildCount();
    int k = this.mFirstPosition;
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter == null) {
      return;
    }
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localListAdapter.isEnabled(k + i)) {
        paramArrayList.add(localView);
      }
      localView.addTouchables(paramArrayList);
      i += 1;
    }
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return paramView == this.mTextFilter;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AbsListView.LayoutParams;
  }
  
  public void clearChoices()
  {
    Object localObject = this.mCheckStates;
    if (localObject != null) {
      ((SparseBooleanArray)localObject).clear();
    }
    localObject = this.mCheckedIdStates;
    if (localObject != null) {
      ((LongSparseArray)localObject).clear();
    }
    this.mCheckedItemCount = 0;
  }
  
  public void clearTextFilter()
  {
    if (this.mFiltered)
    {
      this.mTextFilter.setText("");
      this.mFiltered = false;
      PopupWindow localPopupWindow = this.mPopup;
      if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
        dismissPopup();
      }
    }
  }
  
  protected int computeVerticalScrollExtent()
  {
    int k = getChildCount();
    if (k > 0)
    {
      if (this.mSmoothScrollbarEnabled)
      {
        int j = k * 100;
        View localView = getChildAt(0);
        int m = localView.getTop();
        int n = localView.getHeight();
        int i = j;
        if (n > 0) {
          i = j + m * 100 / n;
        }
        localView = getChildAt(k - 1);
        k = localView.getBottom();
        m = localView.getHeight();
        j = i;
        if (m > 0) {
          j = i - (k - getHeight()) * 100 / m;
        }
        return j;
      }
      return 1;
    }
    return 0;
  }
  
  protected int computeVerticalScrollOffset()
  {
    int k = this.mFirstPosition;
    int m = getChildCount();
    int i = 0;
    if ((k >= 0) && (m > 0))
    {
      int j;
      if (this.mSmoothScrollbarEnabled)
      {
        View localView = getChildAt(0);
        i = localView.getTop();
        j = localView.getHeight();
        if (j > 0) {
          return Math.max(k * 100 - i * 100 / j, 0);
        }
      }
      else
      {
        j = this.mItemCount;
        if (k != 0) {
          if (k + m == j) {
            i = j;
          } else {
            i = m / 2 + k;
          }
        }
        return (int)(k + m * (i / j));
      }
    }
    return 0;
  }
  
  protected int computeVerticalScrollRange()
  {
    if (this.mSmoothScrollbarEnabled) {
      return Math.max(this.mItemCount * 100, 0);
    }
    return this.mItemCount;
  }
  
  @TargetApi(11)
  void confirmCheckedPositionsById()
  {
    this.mCheckStates.clear();
    int i = 0;
    int j = 0;
    label148:
    ActionMode localActionMode;
    while (i < this.mCheckedIdStates.size())
    {
      long l = this.mCheckedIdStates.keyAt(i);
      int n = ((Integer)this.mCheckedIdStates.valueAt(i)).intValue();
      int k;
      if (l != this.mAdapter.getItemId(n))
      {
        k = Math.max(0, n - 20);
        int m = Math.min(n + 20, this.mItemCount);
        while (k < m)
        {
          if (l == this.mAdapter.getItemId(k))
          {
            this.mCheckStates.put(k, true);
            this.mCheckedIdStates.setValueAt(i, Integer.valueOf(k));
            m = 1;
            break label148;
          }
          k += 1;
        }
        m = 0;
        k = i;
        if (m == 0)
        {
          this.mCheckedIdStates.delete(l);
          k = i - 1;
          this.mCheckedItemCount -= 1;
          localActionMode = this.mChoiceActionMode;
          if (localActionMode != null)
          {
            AbsListView.MultiChoiceModeWrapper localMultiChoiceModeWrapper = this.mMultiChoiceModeCallback;
            if (localMultiChoiceModeWrapper != null) {
              localMultiChoiceModeWrapper.onItemCheckedStateChanged(localActionMode, n, l, false);
            }
          }
          j = 1;
        }
      }
      else
      {
        this.mCheckStates.put(n, true);
        k = i;
      }
      i = k + 1;
    }
    if (j != 0)
    {
      localActionMode = this.mChoiceActionMode;
      if (localActionMode != null) {
        localActionMode.invalidate();
      }
    }
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
  }
  
  public void deferNotifyDataSetChanged()
  {
    this.mDeferNotifyDataSetChanged = true;
  }
  
  public void disableOverScrollTop(boolean paramBoolean)
  {
    this.mDisableOverScrollTop = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getQQGroupFlag();
    int j = 0;
    if ((i & 0x22) == 34) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = paramCanvas.save();
      int k = getScrollX();
      int m = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + k, getPaddingTop() + m, k + getRight() - getLeft() - getPaddingRight(), m + getBottom() - getTop() - getPaddingBottom());
      setQQGroupFlag(getQQGroupFlag() & 0xFFFFFFDD);
    }
    boolean bool = this.mDrawSelectorOnTop;
    if (!bool) {
      drawSelector(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
    if (bool) {
      drawSelector(paramCanvas);
    }
    if (i != 0)
    {
      paramCanvas.restoreToCount(j);
      setQQGroupFlag(getQQGroupFlag() | 0x22);
    }
  }
  
  protected void dispatchFinishTemporaryDetachForView(View paramView)
  {
    try
    {
      View.class.getMethod("dispatchFinishTemporaryDetach", new Class[0]).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    paramView.onFinishTemporaryDetach();
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.mNeedCheckSpringback)
    {
      int i = paramMotionEvent.getAction() & 0xFF;
      if ((i != 1) && (i != 3)) {
        return bool;
      }
      if ((this.mTouchMode == -1) && (Math.abs(getScrollY()) > this.mTouchSlop))
      {
        if (this.mFlingRunnable == null) {
          this.mFlingRunnable = new AbsListView.FlingRunnable(this);
        }
        i = 0;
        if ((this.mForHongBao) || (this.mForStory)) {
          i = getSpringbackOffset();
        }
        if (this.mForStory)
        {
          if (i != getScrollY()) {
            this.mFlingRunnable.startSpringback(i);
          }
        }
        else {
          this.mFlingRunnable.startSpringback(i);
        }
        if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append(this.mForHongBao);
          paramMotionEvent.append("| absList dispatchTouchEvent, getScrollY():");
          paramMotionEvent.append(getScrollY());
          paramMotionEvent.append(" targetY: ");
          paramMotionEvent.append(i);
          QLog.i("ListViewOverScroll", 2, paramMotionEvent.toString());
        }
      }
    }
    return bool;
  }
  
  protected void doSpringBack(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    this.mFlingRunnable.startSpringback(paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i;
    int j;
    if (this.mEdgeGlowTop != null)
    {
      i = getScrollY();
      int k;
      int m;
      int n;
      if (!this.mEdgeGlowTop.isFinished())
      {
        j = paramCanvas.save();
        k = this.mListPadding.left + this.mGlowPaddingLeft;
        m = this.mListPadding.right;
        n = this.mGlowPaddingRight;
        int i1 = getWidth();
        paramCanvas.translate(k, Math.min(0, this.mFirstPositionDistanceGuess + i));
        this.mEdgeGlowTop.setSize(i1 - k - (m + n), getHeight());
        if (this.mEdgeGlowTop.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
      if (!this.mEdgeGlowBottom.isFinished())
      {
        j = paramCanvas.save();
        k = this.mListPadding.left + this.mGlowPaddingLeft;
        m = this.mListPadding.right;
        n = this.mGlowPaddingRight;
        m = getWidth() - k - (m + n);
        n = getHeight();
        paramCanvas.translate(-m + k, Math.max(n, i + this.mLastPositionDistanceGuess));
        paramCanvas.rotate(180.0F, m, 0.0F);
        this.mEdgeGlowBottom.setSize(m, n);
        if (this.mEdgeGlowBottom.draw(paramCanvas)) {
          invalidate();
        }
        paramCanvas.restoreToCount(j);
      }
    }
    if (this.mFastScroller != null)
    {
      i = getScrollY();
      if (i != 0)
      {
        j = paramCanvas.save();
        paramCanvas.translate(0.0F, i);
        this.mFastScroller.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
        return;
      }
      this.mFastScroller.draw(paramCanvas);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    updateSelectorState();
  }
  
  abstract void fillGap(boolean paramBoolean);
  
  protected int findClosestMotionRow(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return -1;
    }
    paramInt = findMotionRow(paramInt);
    if (paramInt != -1) {
      return paramInt;
    }
    return this.mFirstPosition + i - 1;
  }
  
  abstract int findMotionRow(int paramInt);
  
  protected void flingForCancel()
  {
    int i = getChildCount();
    if (i > 0)
    {
      int j = getChildAt(0).getTop();
      int k = getChildAt(i - 1).getBottom();
      int m = this.mListPadding.top;
      int n = getHeight() - this.mListPadding.bottom;
      if ((this.mFirstPosition == 0) && (j >= m) && (this.mFirstPosition + i < this.mItemCount) && (k <= getHeight() - n))
      {
        this.mTouchMode = -1;
        reportScrollStateChange(0);
        return;
      }
      Object localObject = this.mVelocityTracker;
      ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
      float f;
      if (VersionUtils.b()) {
        f = ((VelocityTracker)localObject).getYVelocity(this.mActivePointerId);
      } else {
        f = ((VelocityTracker)localObject).getYVelocity();
      }
      int i1 = (int)(f * this.mVelocityScale);
      if ((Math.abs(i1) > this.mMinimumVelocity) && ((this.mFirstPosition != 0) || (j != m - this.mOverscrollDistance)) && ((this.mFirstPosition + i != this.mItemCount) || (k != n + this.mOverscrollDistance)))
      {
        if (this.mFlingRunnable == null) {
          this.mFlingRunnable = new AbsListView.FlingRunnable(this);
        }
        reportScrollStateChange(2);
        this.mFlingRunnable.start(-i1);
        return;
      }
      this.mTouchMode = -1;
      reportScrollStateChange(0);
      localObject = this.mFlingRunnable;
      if (localObject != null) {
        ((AbsListView.FlingRunnable)localObject).endFling();
      }
      localObject = this.mPositionScroller;
      if (localObject != null) {
        ((AbsListView.PositionScroller)localObject).stop();
      }
      localObject = this.mBottomScroller;
      if (localObject != null) {
        ((AbsListView.MoveToBottomScroller)localObject).stop();
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new AbsListView.LayoutParams(-1, -2, 0);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new AbsListView.LayoutParams(paramLayoutParams);
  }
  
  public AbsListView.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new AbsListView.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    int i = getChildCount();
    float f1 = super.getBottomFadingEdgeStrength();
    if (i == 0) {
      return f1;
    }
    if (this.mFirstPosition + i - 1 < this.mItemCount - 1) {
      return 1.0F;
    }
    i = getChildAt(i - 1).getBottom();
    int j = getHeight();
    float f2 = getVerticalFadingEdgeLength();
    if (i > j - getPaddingBottom()) {
      f1 = (i - j + getPaddingBottom()) / f2;
    }
    return f1;
  }
  
  protected int getBottomPaddingOffset()
  {
    if ((getQQGroupFlag() & 0x22) == 34) {
      return 0;
    }
    return getPaddingBottom();
  }
  
  @ViewDebug.ExportedProperty(category="drawing")
  public int getCacheColorHint()
  {
    return this.mCacheColorHint;
  }
  
  public int getCheckedItemCount()
  {
    return this.mCheckedItemCount;
  }
  
  public long[] getCheckedItemIds()
  {
    int j = this.mChoiceMode;
    int i = 0;
    if (j != 0)
    {
      LongSparseArray localLongSparseArray = this.mCheckedIdStates;
      if ((localLongSparseArray != null) && (this.mAdapter != null))
      {
        j = localLongSparseArray.size();
        long[] arrayOfLong = new long[j];
        while (i < j)
        {
          arrayOfLong[i] = localLongSparseArray.keyAt(i);
          i += 1;
        }
        return arrayOfLong;
      }
    }
    return new long[0];
  }
  
  public int getCheckedItemPosition()
  {
    if (this.mChoiceMode == 1)
    {
      SparseBooleanArray localSparseBooleanArray = this.mCheckStates;
      if ((localSparseBooleanArray != null) && (localSparseBooleanArray.size() == 1)) {
        return this.mCheckStates.keyAt(0);
      }
    }
    return -1;
  }
  
  public SparseBooleanArray getCheckedItemPositions()
  {
    if (this.mChoiceMode != 0) {
      return this.mCheckStates;
    }
    return null;
  }
  
  public int getChoiceMode()
  {
    return this.mChoiceMode;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.mContextMenuInfo;
  }
  
  public float getFlingVelocity()
  {
    AbsListView.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if ((localFlingRunnable != null) && (AbsListView.FlingRunnable.access$1100(localFlingRunnable) != null)) {
      return AbsListView.FlingRunnable.access$1100(this.mFlingRunnable).getCurrVelocity();
    }
    return -1.0F;
  }
  
  public float getFlingVelocityY()
  {
    AbsListView.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if ((localFlingRunnable != null) && (AbsListView.FlingRunnable.access$1100(localFlingRunnable) != null)) {
      return AbsListView.FlingRunnable.access$1100(this.mFlingRunnable).getCurrVelocityY();
    }
    return -1.0F;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    View localView = getSelectedView();
    if ((localView != null) && (localView.getParent() == this))
    {
      localView.getFocusedRect(paramRect);
      offsetDescendantRectToMyCoords(localView, paramRect);
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  int getFooterViewsCount()
  {
    return 0;
  }
  
  int getHeaderViewsCount()
  {
    return 0;
  }
  
  protected int getLeftPaddingOffset()
  {
    if ((getQQGroupFlag() & 0x22) == 34) {
      return 0;
    }
    return -getPaddingLeft();
  }
  
  public int getListPaddingBottom()
  {
    return this.mListPadding.bottom;
  }
  
  public int getListPaddingLeft()
  {
    return this.mListPadding.left;
  }
  
  public int getListPaddingRight()
  {
    return this.mListPadding.right;
  }
  
  public int getListPaddingTop()
  {
    return this.mListPadding.top;
  }
  
  public int getNestedScrollAxes()
  {
    return 0;
  }
  
  public AbsListView.OnScrollListener getOnScrollListener()
  {
    return this.mOnScrollListener;
  }
  
  public int getOverScrollMode()
  {
    return this.mOverScrollMode;
  }
  
  public int getRemainFlingDisY()
  {
    AbsListView.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if (localFlingRunnable != null) {
      return AbsListView.FlingRunnable.access$1100(localFlingRunnable).getFinalY() - AbsListView.FlingRunnable.access$1100(this.mFlingRunnable).getCurrY();
    }
    return -1;
  }
  
  protected int getRightPaddingOffset()
  {
    if ((getQQGroupFlag() & 0x22) == 34) {
      return 0;
    }
    return getPaddingRight();
  }
  
  @ViewDebug.ExportedProperty
  public View getSelectedView()
  {
    if ((this.mItemCount > 0) && (this.mSelectedPosition >= 0) && (this.mSelectedPosition < this.mItemCount)) {
      return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }
    return null;
  }
  
  public Drawable getSelector()
  {
    return this.mSelector;
  }
  
  public int getSolidColor()
  {
    return this.mCacheColorHint;
  }
  
  protected int getSpringbackOffset()
  {
    return 0;
  }
  
  public CharSequence getTextFilter()
  {
    if (this.mTextFilterEnabled)
    {
      EditText localEditText = this.mTextFilter;
      if (localEditText != null) {
        return localEditText.getText();
      }
    }
    return null;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    int i = getChildCount();
    float f1 = super.getTopFadingEdgeStrength();
    if (i == 0) {
      return f1;
    }
    if (this.mFirstPosition > 0) {
      return 1.0F;
    }
    i = getChildAt(0).getTop();
    float f2 = getVerticalFadingEdgeLength();
    if (i < getPaddingTop()) {
      f1 = -(i - getPaddingTop()) / f2;
    }
    return f1;
  }
  
  protected int getTopPaddingOffset()
  {
    if ((getQQGroupFlag() & 0x22) == 34) {
      return 0;
    }
    return -getPaddingTop();
  }
  
  public int getTranscriptMode()
  {
    return this.mTranscriptMode;
  }
  
  public int getVerticalScrollbarWidth()
  {
    if (isFastScrollAlwaysVisible()) {
      return Math.max(super.getVerticalScrollbarWidth(), this.mFastScroller.getWidth());
    }
    return super.getVerticalScrollbarWidth();
  }
  
  protected void handleDataChanged()
  {
    int m = this.mItemCount;
    int n = this.mLastHandledItemCount;
    this.mLastHandledItemCount = this.mItemCount;
    Object localObject;
    if (this.mChoiceMode != 0)
    {
      localObject = this.mAdapter;
      if ((localObject != null) && (((ListAdapter)localObject).hasStableIds())) {
        confirmCheckedPositionsById();
      }
    }
    int k = 3;
    int i;
    if (m > 0)
    {
      int j;
      if (this.mNeedSync)
      {
        this.mNeedSync = false;
        i = this.mTranscriptMode;
        if (i == 2) {
          this.mScrollToBottom = true;
        } else if (i == 1) {
          if (this.mForceTranscriptScroll)
          {
            this.mForceTranscriptScroll = false;
            this.mScrollToBottom = true;
          }
          else if (getChildCount() > 0)
          {
            int i1 = getChildCount();
            j = getHeight() - getPaddingBottom();
            localObject = getChildAt(i1 - 1);
            if (localObject != null) {
              i = ((View)localObject).getBottom();
            } else {
              i = j;
            }
            if ((this.mFirstPosition + i1 >= n) && (i <= j))
            {
              this.mLayoutMode = 3;
              return;
            }
          }
        }
        i = this.mSyncMode;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2)
            {
              this.mLayoutMode = 5;
              this.mSyncPosition = Math.max(Math.min(this.mSyncPosition, m - 1), 0);
            }
          }
          else
          {
            this.mLayoutMode = 5;
            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), m - 1);
          }
        }
        else
        {
          if (isInTouchMode())
          {
            this.mLayoutMode = 5;
            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), m - 1);
            return;
          }
          i = findSyncPosition();
          if ((i >= 0) && (lookForSelectablePosition(i, true) == i))
          {
            this.mSyncPosition = i;
            if (this.mSyncHeight == getHeight()) {
              this.mLayoutMode = 5;
            } else {
              this.mLayoutMode = 2;
            }
            setNextSelectedPositionInt(i);
            return;
          }
        }
      }
      if (!isInTouchMode())
      {
        i = getSelectedItemPosition();
        if (i >= m) {
          i = m - 1;
        }
        j = i;
        if (i < 0) {
          j = 0;
        }
        i = lookForSelectablePosition(j, true);
        if (i >= 0)
        {
          setNextSelectedPositionInt(i);
          return;
        }
        i = lookForSelectablePosition(j, false);
        if (i >= 0) {
          setNextSelectedPositionInt(i);
        }
      }
      else if (this.mResurrectToPosition >= 0)
      {
        return;
      }
    }
    if (this.mStackFromBottom) {
      i = k;
    } else {
      i = 1;
    }
    this.mLayoutMode = i;
    this.mSelectedPosition = -1;
    this.mSelectedRowId = -9223372036854775808L;
    this.mNextSelectedPosition = -1;
    this.mNextSelectedRowId = -9223372036854775808L;
    this.mNeedSync = false;
    this.mSelectorPosition = -1;
    checkSelectionChanged();
  }
  
  public boolean hasTextFilter()
  {
    return this.mFiltered;
  }
  
  void hideSelector()
  {
    if (this.mSelectedPosition != -1)
    {
      if (this.mLayoutMode != 4) {
        this.mResurrectToPosition = this.mSelectedPosition;
      }
      if ((this.mNextSelectedPosition >= 0) && (this.mNextSelectedPosition != this.mSelectedPosition)) {
        this.mResurrectToPosition = this.mNextSelectedPosition;
      }
      setSelectedPositionInt(-1);
      setNextSelectedPositionInt(-1);
      this.mSelectedTop = 0;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable)) {
      invalidate(paramDrawable.getBounds());
    }
  }
  
  public void invalidateViews()
  {
    this.mDataChanged = true;
    rememberSyncState();
    requestLayout();
    invalidate();
  }
  
  void invokeOnItemScrollListener()
  {
    Object localObject = this.mFastScroller;
    if (localObject != null) {
      ((FastScroller)localObject).onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    localObject = this.mOnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    localObject = this.mOnScrollListenerList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AbsListView.OnScrollListener)((Iterator)localObject).next()).onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    onScrollChanged(0, 0, 0, 0);
  }
  
  public boolean isFastScrollAlwaysVisible()
  {
    return (this.mFastScrollEnabled) && (this.mFastScroller.isAlwaysShowEnabled());
  }
  
  @ViewDebug.ExportedProperty
  public boolean isFastScrollEnabled()
  {
    return this.mFastScrollEnabled;
  }
  
  protected boolean isInFilterMode()
  {
    return this.mFiltered;
  }
  
  public boolean isItemChecked(int paramInt)
  {
    if (this.mChoiceMode != 0)
    {
      SparseBooleanArray localSparseBooleanArray = this.mCheckStates;
      if (localSparseBooleanArray != null) {
        return localSparseBooleanArray.get(paramInt);
      }
    }
    return false;
  }
  
  protected boolean isPaddingOffsetRequired()
  {
    return (getQQGroupFlag() & 0x22) != 34;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isScrollingCacheEnabled()
  {
    return this.mScrollingCacheEnabled;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isStackFromBottom()
  {
    return this.mStackFromBottom;
  }
  
  @ViewDebug.ExportedProperty
  public boolean isTextFilterEnabled()
  {
    return this.mTextFilterEnabled;
  }
  
  protected boolean isVerticalScrollBarHidden()
  {
    FastScroller localFastScroller = this.mFastScroller;
    return (localFastScroller != null) && (localFastScroller.isVisible());
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.mSelector;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  void keyPressed()
  {
    if (isEnabled())
    {
      if (!isClickable()) {
        return;
      }
      Drawable localDrawable = this.mSelector;
      Object localObject = this.mSelectorRect;
      if ((localDrawable != null) && ((isFocused()) || (touchModeDrawsInPressedState())) && (!((Rect)localObject).isEmpty()))
      {
        localObject = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        if (localObject != null)
        {
          if (((View)localObject).hasFocusable()) {
            return;
          }
          ((View)localObject).setPressed(true);
        }
        setPressed(true);
        boolean bool = isLongClickable();
        localDrawable = localDrawable.getCurrent();
        if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable))) {
          if (bool) {
            ((TransitionDrawable)localDrawable).startTransition(ViewConfiguration.getLongPressTimeout());
          } else {
            ((TransitionDrawable)localDrawable).resetTransition();
          }
        }
        if ((bool) && (!this.mDataChanged))
        {
          if (this.mPendingCheckForKeyLongPress == null) {
            this.mPendingCheckForKeyLongPress = new AbsListView.CheckForKeyLongPress(this, null);
          }
          this.mPendingCheckForKeyLongPress.rememberWindowAttachCount();
          postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
        }
      }
    }
  }
  
  protected void layoutChildren() {}
  
  protected AbsListView.AdapterDataSetObserver newObserver()
  {
    return new AbsListView.AdapterDataSetObserver(this);
  }
  
  View obtainView(int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    View localView2 = this.mRecycler.getScrapView(paramInt);
    View localView1;
    if (localView2 != null)
    {
      localView1 = this.mAdapter.getView(paramInt, localView2, this);
      if (ViewCompat.getImportantForAccessibility(localView1) == 0) {
        ViewCompat.setImportantForAccessibility(localView1, 1);
      }
      if (localView1 != localView2)
      {
        this.mRecycler.addScrapView(localView2, paramInt);
        paramInt = this.mCacheColorHint;
        paramArrayOfBoolean = localView1;
        if (paramInt != 0)
        {
          localView1.setDrawingCacheBackgroundColor(paramInt);
          paramArrayOfBoolean = localView1;
        }
      }
      else
      {
        paramArrayOfBoolean[0] = true;
        dispatchFinishTemporaryDetachForView(localView1);
        paramArrayOfBoolean = localView1;
      }
    }
    else
    {
      localView1 = this.mAdapter.getView(paramInt, null, this);
      paramInt = this.mCacheColorHint;
      if (paramInt != 0) {
        localView1.setDrawingCacheBackgroundColor(paramInt);
      }
      paramArrayOfBoolean = localView1;
      if (localView1 != null)
      {
        paramArrayOfBoolean = localView1;
        if (ViewCompat.getImportantForAccessibility(localView1) == 0)
        {
          ViewCompat.setImportantForAccessibility(localView1, 1);
          paramArrayOfBoolean = localView1;
        }
      }
    }
    onAttachChildView(paramArrayOfBoolean);
    return paramArrayOfBoolean;
  }
  
  protected void onAttachChildView(View paramView) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    localViewTreeObserver.addOnTouchModeChangeListener(this);
    if ((this.mTextFilterEnabled) && (this.mPopup != null) && (!this.mGlobalLayoutListenerAddedFilter)) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    if ((this.mAdapter != null) && (this.mDataSetObserver == null))
    {
      this.mDataSetObserver = newObserver();
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mDataChanged = true;
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      requestLayout();
    }
    this.mIsAttached = true;
  }
  
  protected boolean onConsistencyCheck(int paramInt)
  {
    boolean bool1 = super.onConsistencyCheck(paramInt);
    int i = 1;
    if ((paramInt & 0x1) != 0) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    boolean bool2 = bool1;
    if (paramInt != 0)
    {
      Object localObject = AbsListView.RecycleBin.access$2800(this.mRecycler);
      i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (localObject[paramInt] != null) {
          bool1 = false;
        }
        paramInt += 1;
      }
      if (!checkScrap(AbsListView.RecycleBin.access$2900(this.mRecycler))) {
        bool1 = false;
      }
      localObject = AbsListView.RecycleBin.access$3000(this.mRecycler);
      i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        if (!checkScrap(localObject[paramInt])) {
          bool1 = false;
        }
        paramInt += 1;
      }
      bool2 = bool1;
    }
    return bool2;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.mIsChildViewEnabled) {
      return super.onCreateDrawableState(paramInt);
    }
    int i = ENABLED_STATE_SET[0];
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    paramInt = arrayOfInt.length - 1;
    while (paramInt >= 0)
    {
      if (arrayOfInt[paramInt] == i) {
        break label55;
      }
      paramInt -= 1;
    }
    paramInt = -1;
    label55:
    if (paramInt >= 0) {
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
    }
    return arrayOfInt;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (isTextFilterEnabled())
    {
      createTextFilter(false);
      if (this.mPublicInputConnection == null)
      {
        this.mDefInputConnection = new BaseInputConnection(this, false);
        this.mPublicInputConnection = new AbsListView.3(this, this.mTextFilter.onCreateInputConnection(paramEditorInfo), true);
      }
      paramEditorInfo.inputType = 177;
      paramEditorInfo.imeOptions = 6;
      return this.mPublicInputConnection;
    }
    return null;
  }
  
  protected void onDetachChildView(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopup();
    try
    {
      this.mRecycler.clear();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    Object localObject1 = getViewTreeObserver();
    ((ViewTreeObserver)localObject1).removeOnTouchModeChangeListener(this);
    if ((this.mTextFilterEnabled) && (this.mPopup != null))
    {
      ((ViewTreeObserver)localObject1).removeGlobalOnLayoutListener(this);
      this.mGlobalLayoutListenerAddedFilter = false;
    }
    localObject1 = this.mAdapter;
    if (localObject1 != null)
    {
      AbsListView.AdapterDataSetObserver localAdapterDataSetObserver = this.mDataSetObserver;
      if (localAdapterDataSetObserver != null)
      {
        try
        {
          ((ListAdapter)localObject1).unregisterDataSetObserver(localAdapterDataSetObserver);
        }
        catch (Exception localException2)
        {
          QLog.e("XListView", 1, "onDetachedFromWindow unregisterDataSetObserver fail.", localException2);
        }
        this.mDataSetObserver = null;
      }
    }
    Object localObject2 = this.mScrollStrictSpan;
    if (localObject2 != null) {
      this.mScrollStrictSpan = finishSpan(localObject2);
    }
    localObject2 = this.mFlingStrictSpan;
    if (localObject2 != null) {
      this.mFlingStrictSpan = finishSpan(localObject2);
    }
    localObject2 = this.mFlingRunnable;
    if (localObject2 != null) {
      removeCallbacks((Runnable)localObject2);
    }
    localObject2 = this.mPositionScroller;
    if (localObject2 != null) {
      ((AbsListView.PositionScroller)localObject2).stop();
    }
    localObject2 = this.mBottomScroller;
    if (localObject2 != null) {
      ((AbsListView.MoveToBottomScroller)localObject2).stop();
    }
    localObject2 = this.mClearScrollingCache;
    if (localObject2 != null) {
      removeCallbacks((Runnable)localObject2);
    }
    localObject2 = this.mPerformClick;
    if (localObject2 != null) {
      removeCallbacks((Runnable)localObject2);
    }
    localObject2 = this.mTouchModeReset;
    if (localObject2 != null)
    {
      removeCallbacks((Runnable)localObject2);
      this.mTouchModeReset = null;
    }
    this.mIsAttached = false;
  }
  
  protected void onDisplayHint(int paramInt)
  {
    super.onDisplayHint(paramInt);
    PopupWindow localPopupWindow;
    if (paramInt != 0)
    {
      if (paramInt == 4)
      {
        localPopupWindow = this.mPopup;
        if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
          dismissPopup();
        }
      }
    }
    else if (this.mFiltered)
    {
      localPopupWindow = this.mPopup;
      if ((localPopupWindow != null) && (!localPopupWindow.isShowing())) {
        showPopup();
      }
    }
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.mPopupHidden = bool;
  }
  
  protected void onDrawVerticalScrollBar(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setBounds(paramInt1, paramInt2 + getScrollY(), paramInt3, paramInt4 + getScrollY());
    paramDrawable.draw(paramCanvas);
  }
  
  public void onFilterComplete(int paramInt)
  {
    if ((this.mSelectedPosition < 0) && (paramInt > 0))
    {
      this.mResurrectToPosition = -1;
      resurrectSelection();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.mSelectedPosition < 0) && (!isInTouchMode()))
    {
      if ((!this.mIsAttached) && (this.mAdapter != null))
      {
        this.mDataChanged = true;
        this.mOldItemCount = this.mItemCount;
        this.mItemCount = this.mAdapter.getCount();
      }
      resurrectSelection();
    }
  }
  
  @TargetApi(12)
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() == 8) && (this.mTouchMode == -1))
    {
      float f = paramMotionEvent.getAxisValue(9);
      if (f != 0.0F)
      {
        int i = (int)(f * getVerticalScrollFactor());
        if (!trackMotionScroll(i, i)) {
          return true;
        }
      }
    }
    return super.onGenericMotionEvent(paramMotionEvent);
  }
  
  public void onGlobalLayout()
  {
    PopupWindow localPopupWindow;
    if (isShown())
    {
      if (this.mFiltered)
      {
        localPopupWindow = this.mPopup;
        if ((localPopupWindow != null) && (!localPopupWindow.isShowing()) && (!this.mPopupHidden)) {
          showPopup();
        }
      }
    }
    else
    {
      localPopupWindow = this.mPopup;
      if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
        dismissPopup();
      }
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(android.widget.AbsListView.class.getName());
  }
  
  @TargetApi(16)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(android.widget.AbsListView.class.getName());
    if (isEnabled())
    {
      if (getFirstVisiblePosition() > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (getLastVisiblePosition() < getCount() - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    FastScroller localFastScroller = this.mFastScroller;
    if ((localFastScroller != null) && (localFastScroller.onInterceptTouchEvent(paramMotionEvent))) {
      return true;
    }
    i &= 0xFF;
    int j;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 6) {
              return false;
            }
            onSecondaryPointerUp(paramMotionEvent);
            return false;
          }
        }
        else
        {
          if (this.mTouchMode != 0) {
            return false;
          }
          j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          i = j;
          if (j == -1)
          {
            this.mActivePointerId = paramMotionEvent.getPointerId(0);
            i = 0;
          }
          if (this.mDataChanged) {
            layoutChildren();
          }
          i = (int)paramMotionEvent.getY(i);
          initVelocityTrackerIfNotExists();
          this.mVelocityTracker.addMovement(paramMotionEvent);
          if (!startScrollIfNeeded(i)) {
            break label293;
          }
          return true;
        }
      }
      this.mTouchMode = -1;
      this.mActivePointerId = -1;
      recycleVelocityTracker();
      reportScrollStateChange(0);
      return false;
    }
    else
    {
      i = this.mTouchMode;
      if ((i == 6) || (i == 5)) {
        break label295;
      }
      j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      int m = findClosestMotionRow(k);
      if ((i != 4) && (m >= 0))
      {
        this.mMotionViewOriginalTop = getChildAt(m - this.mFirstPosition).getTop();
        this.mMotionX = j;
        this.mMotionY = k;
        this.mMotionPosition = m;
        this.mTouchMode = 0;
        clearScrollingCache();
      }
      this.mLastY = -2147483648;
      initOrResetVelocityTracker();
      this.mVelocityTracker.addMovement(paramMotionEvent);
      if (i == 4) {
        return true;
      }
    }
    label293:
    return false;
    label295:
    this.mMotionCorrection = 0;
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 23) || (paramInt == 66))
    {
      if (!isEnabled()) {
        return true;
      }
      if ((isClickable()) && (isPressed()) && (this.mSelectedPosition >= 0) && (this.mAdapter != null) && (this.mSelectedPosition < this.mAdapter.getCount()))
      {
        paramKeyEvent = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        if (paramKeyEvent != null)
        {
          performItemClick(paramKeyEvent, this.mSelectedPosition, this.mSelectedRowId);
          paramKeyEvent.setPressed(false);
        }
        setPressed(false);
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    traceBegin("AbsListView.onLayout");
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      this.mInLayout = true;
      if (paramBoolean)
      {
        paramInt3 = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt3)
        {
          getChildAt(paramInt1).forceLayout();
          paramInt1 += 1;
        }
        this.mRecycler.markChildrenDirty();
      }
      if ((this.mFastScroller != null) && (this.mItemCount != this.mOldItemCount)) {
        this.mFastScroller.onItemCountChanged(this.mOldItemCount, this.mItemCount);
      }
      layoutChildren();
      this.mInLayout = false;
      this.mOverscrollMax = ((paramInt4 - paramInt2) / 3);
      if (this.mScrollToBottom)
      {
        if (this.mBottomScroller == null) {
          this.mBottomScroller = new AbsListView.MoveToBottomScroller(this);
        }
        this.mBottomScroller.start();
      }
      traceEnd();
      return;
    }
    finally
    {
      traceEnd();
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mSelector == null) {
      useDefaultSelector();
    }
    Object localObject = this.mListPadding;
    ((Rect)localObject).left = (this.mSelectionLeftPadding + getPaddingLeft());
    ((Rect)localObject).top = (this.mSelectionTopPadding + getPaddingTop());
    ((Rect)localObject).right = (this.mSelectionRightPadding + getPaddingRight());
    ((Rect)localObject).bottom = (this.mSelectionBottomPadding + getPaddingBottom());
    paramInt1 = this.mTranscriptMode;
    boolean bool = true;
    if (paramInt1 == 1)
    {
      int i = getChildCount();
      if (i > 0)
      {
        paramInt2 = getHeight() - getPaddingBottom();
        localObject = getChildAt(i - 1);
        if (localObject != null) {
          paramInt1 = ((View)localObject).getBottom();
        } else {
          paramInt1 = paramInt2;
        }
        if ((this.mFirstPosition + i < this.mLastHandledItemCount) || (paramInt1 > paramInt2)) {
          bool = false;
        }
        this.mForceTranscriptScroll = bool;
      }
    }
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (getScrollY() != paramInt2)
    {
      onScrollChanged(getScrollX(), paramInt2, getScrollX(), getScrollY());
      setScrollY(paramInt2);
      invalidateParentIfNeeded();
      try
      {
        awakenScrollBars();
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onOverScrolled error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("XListView", 1, localStringBuilder.toString());
      }
    }
  }
  
  public void onRemoteAdapterDisconnected() {}
  
  @TargetApi(11)
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (AbsListView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.mDataChanged = true;
    this.mSyncHeight = paramParcelable.height;
    if (paramParcelable.selectedId >= 0L)
    {
      this.mNeedSync = true;
      this.mSyncRowId = paramParcelable.selectedId;
      this.mSyncPosition = paramParcelable.position;
      this.mSpecificTop = paramParcelable.viewTop;
      this.mSpecificBottom = paramParcelable.viewTop;
      this.mSyncMode = 0;
    }
    else if (paramParcelable.firstId >= 0L)
    {
      setSelectedPositionInt(-1);
      setNextSelectedPositionInt(-1);
      this.mSelectorPosition = -1;
      if (paramParcelable.position != 2147483647)
      {
        this.mNeedSync = true;
        this.mSyncRowId = paramParcelable.firstId;
        if (!this.mStackFromBottom)
        {
          this.mSyncPosition = paramParcelable.position;
          this.mSpecificTop = paramParcelable.viewTop;
          this.mSyncMode = 1;
        }
        else
        {
          this.mSyncPosition = paramParcelable.position;
          this.mSpecificBottom = paramParcelable.viewTop;
          this.mSyncMode = 2;
        }
      }
    }
    setFilterText(paramParcelable.filter);
    if (paramParcelable.checkState != null) {
      this.mCheckStates = paramParcelable.checkState;
    }
    if (paramParcelable.checkIdState != null) {
      this.mCheckedIdStates = paramParcelable.checkIdState;
    }
    this.mCheckedItemCount = paramParcelable.checkedItemCount;
    if ((VersionUtils.e()) && (paramParcelable.inActionMode) && (this.mChoiceMode == 3))
    {
      paramParcelable = this.mMultiChoiceModeCallback;
      if (paramParcelable != null) {
        this.mChoiceActionMode = startActionMode(paramParcelable);
      }
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    dismissPopup();
    AbsListView.SavedState localSavedState = new AbsListView.SavedState(super.onSaveInstanceState());
    int i = getChildCount();
    boolean bool = true;
    int k = 0;
    if ((i > 0) && (this.mItemCount > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    localSavedState.height = this.mLayoutHeight;
    int j;
    if (this.mSelectedPosition >= 0)
    {
      localSavedState.selectedId = this.mNextSelectedRowId;
      if (i != 0)
      {
        localSavedState.position = getSelectedItemPosition();
        localObject = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        if (localObject != null)
        {
          if (this.mStackFromBottom) {
            i = this.mLayoutHeight - ((View)localObject).getBottom();
          } else {
            i = ((View)localObject).getTop();
          }
          localSavedState.viewTop = i;
        }
        localSavedState.firstId = -1L;
      }
    }
    else if (!this.mStackFromBottom)
    {
      if ((i != 0) && (this.mFirstPosition >= 0))
      {
        localSavedState.viewTop = getChildAt(0).getTop();
        j = this.mFirstPosition;
        i = j;
        if (j >= this.mItemCount) {
          i = this.mItemCount - 1;
        }
        localSavedState.position = i;
        localSavedState.firstId = this.mAdapter.getItemId(i);
      }
      else
      {
        localSavedState.viewTop = 0;
        localSavedState.firstId = -1L;
        localSavedState.position = 0;
      }
    }
    else if ((i != 0) && (this.mFirstPosition >= 0))
    {
      j = getChildCount();
      int m = this.mFirstPosition;
      i = -1;
      if (m != -1) {
        i = this.mFirstPosition + j - 1;
      }
      localObject = getChildAt(j - 1);
      localSavedState.viewTop = (this.mLayoutHeight - ((View)localObject).getBottom());
      j = i;
      if (i >= this.mItemCount) {
        j = this.mItemCount - 1;
      }
      if ((((View)localObject).getBottom() <= this.mLayoutHeight - this.mListPadding.bottom) && (this.mTranscriptMode == 1)) {
        localSavedState.position = 2147483647;
      } else {
        localSavedState.position = j;
      }
      localSavedState.firstId = this.mAdapter.getItemId(j);
    }
    else
    {
      localSavedState.viewTop = 0;
      localSavedState.firstId = -1L;
      localSavedState.position = 0;
    }
    localSavedState.filter = null;
    if (this.mFiltered)
    {
      localObject = this.mTextFilter;
      if (localObject != null)
      {
        localObject = ((EditText)localObject).getText();
        if (localObject != null) {
          localSavedState.filter = localObject.toString();
        }
      }
    }
    if ((this.mChoiceMode != 3) || (this.mChoiceActionMode == null)) {
      bool = false;
    }
    localSavedState.inActionMode = bool;
    Object localObject = this.mCheckStates;
    if (localObject != null) {
      localSavedState.checkState = ((SparseBooleanArray)localObject).clone();
    }
    if (this.mCheckedIdStates != null)
    {
      localObject = new LongSparseArray();
      j = this.mCheckedIdStates.size();
      i = k;
      while (i < j)
      {
        ((LongSparseArray)localObject).put(this.mCheckedIdStates.keyAt(i), this.mCheckedIdStates.valueAt(i));
        i += 1;
      }
      localSavedState.checkIdState = ((LongSparseArray)localObject);
    }
    localSavedState.checkedItemCount = this.mCheckedItemCount;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      this.mDataChanged = true;
      rememberSyncState();
    }
    FastScroller localFastScroller = this.mFastScroller;
    if (localFastScroller != null) {
      localFastScroller.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.mPopup != null) && (isTextFilterEnabled()))
    {
      paramInt1 = paramCharSequence.length();
      boolean bool = this.mPopup.isShowing();
      if ((!bool) && (paramInt1 > 0))
      {
        showPopup();
        this.mFiltered = true;
      }
      else if ((bool) && (paramInt1 == 0))
      {
        dismissPopup();
        this.mFiltered = false;
      }
      Object localObject = this.mAdapter;
      if ((localObject instanceof Filterable))
      {
        localObject = ((Filterable)localObject).getFilter();
        if (localObject != null)
        {
          ((Filter)localObject).filter(paramCharSequence, this);
          return;
        }
        throw new IllegalStateException("You cannot call onTextChanged with a non filterable adapter");
      }
    }
  }
  
  @TargetApi(8)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = isEnabled();
    boolean bool1 = true;
    if (!bool2)
    {
      if (!isClickable())
      {
        if (isLongClickable()) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    Object localObject = this.mFastScroller;
    if ((localObject != null) && (((FastScroller)localObject).onTouchEvent(paramMotionEvent))) {
      return true;
    }
    localObject = getTouchDelegate();
    if (localObject != null) {
      ((TouchDelegate)localObject).onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    initVelocityTrackerIfNotExists();
    this.mVelocityTracker.addMovement(paramMotionEvent);
    i &= 0xFF;
    int j;
    int k;
    int m;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 5)
            {
              if (i != 6) {
                return true;
              }
              if (VersionUtils.b())
              {
                onSecondaryPointerUp(paramMotionEvent);
                j = this.mMotionX;
                i = this.mMotionY;
                j = pointToPosition(j, i);
                if (j >= 0)
                {
                  this.mMotionViewOriginalTop = getChildAt(j - this.mFirstPosition).getTop();
                  this.mMotionPosition = j;
                }
                this.mLastY = i;
                return true;
              }
            }
            else if (VersionUtils.b())
            {
              k = paramMotionEvent.getActionIndex();
              i = paramMotionEvent.getPointerId(k);
              j = (int)paramMotionEvent.getX(k);
              k = (int)paramMotionEvent.getY(k);
              this.mMotionCorrection = 0;
              this.mActivePointerId = i;
              this.mMotionX = j;
              this.mMotionY = k;
              i = pointToPosition(j, k);
              if (i >= 0)
              {
                this.mMotionViewOriginalTop = getChildAt(i - this.mFirstPosition).getTop();
                this.mMotionPosition = i;
              }
              this.mLastY = k;
              return true;
            }
          }
          else
          {
            i = this.mTouchMode;
            if (i != 5)
            {
              if (i != 6) {
                if ((this.mForContacts) && (i == 3))
                {
                  flingForCancel();
                }
                else
                {
                  this.mTouchMode = -1;
                  setPressed(false);
                  paramMotionEvent = getChildAt(this.mMotionPosition - this.mFirstPosition);
                  if (paramMotionEvent != null) {
                    paramMotionEvent.setPressed(false);
                  }
                  clearScrollingCache();
                  paramMotionEvent = getHandler();
                  if (paramMotionEvent != null) {
                    paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
                  }
                  recycleVelocityTracker();
                }
              }
            }
            else
            {
              if (this.mFlingRunnable == null) {
                this.mFlingRunnable = new AbsListView.FlingRunnable(this);
              }
              this.mFlingRunnable.startSpringback(0);
            }
            paramMotionEvent = this.mEdgeGlowTop;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.onRelease();
              this.mEdgeGlowBottom.onRelease();
            }
            this.mActivePointerId = -1;
            return true;
          }
        }
        else
        {
          j = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          i = j;
          if (j == -1)
          {
            this.mActivePointerId = paramMotionEvent.getPointerId(0);
            i = 0;
          }
          if (this.mDataChanged) {
            layoutChildren();
          }
          i = (int)paramMotionEvent.getY(i);
          j = this.mTouchMode;
          if ((j != 0) && (j != 1) && (j != 2))
          {
            if ((j != 3) && (j != 5)) {
              return true;
            }
            scrollIfNeeded(i);
            return true;
          }
          startScrollIfNeeded(i);
          return true;
        }
      }
      else
      {
        i = this.mTouchMode;
        float f;
        if ((i != 0) && (i != 1) && (i != 2))
        {
          if (i != 3)
          {
            if (i == 5)
            {
              if (this.mFlingRunnable == null) {
                this.mFlingRunnable = new AbsListView.FlingRunnable(this);
              }
              reportScrollStateChange(2);
              this.mFlingRunnable.startSpringback(getSpringbackOffset());
              localObject = this.mVelocityTracker;
              ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.mMaximumVelocity);
              if (VersionUtils.b()) {
                f = ((VelocityTracker)localObject).getYVelocity(this.mActivePointerId);
              } else {
                f = ((VelocityTracker)localObject).getYVelocity();
              }
              onTouchUpWithYVelocity((int)(f * this.mVelocityScale), (int)paramMotionEvent.getY());
            }
          }
          else
          {
            i = getChildCount();
            if (i > 0)
            {
              j = getChildAt(0).getTop();
              k = getChildAt(i - 1).getBottom();
              m = this.mListPadding.top;
              int n = getHeight() - this.mListPadding.bottom;
              if ((this.mFirstPosition == 0) && (j >= m) && (this.mFirstPosition + i < this.mItemCount) && (k <= getHeight() - n))
              {
                this.mTouchMode = -1;
                reportScrollStateChange(0);
              }
              else
              {
                paramMotionEvent = this.mVelocityTracker;
                paramMotionEvent.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (VersionUtils.b()) {
                  f = paramMotionEvent.getYVelocity(this.mActivePointerId);
                } else {
                  f = paramMotionEvent.getYVelocity();
                }
                int i1 = (int)(f * this.mVelocityScale);
                if ((Math.abs(i1) > this.mMinimumVelocity) && ((this.mFirstPosition != 0) || (j != m - this.mOverscrollDistance)) && ((this.mFirstPosition + i != this.mItemCount) || (k != n + this.mOverscrollDistance)))
                {
                  if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new AbsListView.FlingRunnable(this);
                  }
                  reportScrollStateChange(2);
                  this.mFlingRunnable.start(-i1);
                }
                else
                {
                  this.mTouchMode = -1;
                  reportScrollStateChange(0);
                  paramMotionEvent = this.mFlingRunnable;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.endFling();
                  }
                  paramMotionEvent = this.mPositionScroller;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.stop();
                  }
                  paramMotionEvent = this.mBottomScroller;
                  if (paramMotionEvent != null) {
                    paramMotionEvent.stop();
                  }
                }
              }
            }
            else
            {
              this.mTouchMode = -1;
              reportScrollStateChange(0);
            }
          }
        }
        else
        {
          j = this.mMotionPosition;
          localObject = getChildAt(j - this.mFirstPosition);
          f = paramMotionEvent.getX();
          if ((f > this.mListPadding.left) && (f < getWidth() - this.mListPadding.right)) {
            i = 1;
          } else {
            i = 0;
          }
          if (this.mPerformClick == null) {
            this.mPerformClick = new AbsListView.PerformClick(this, null);
          }
          AbsListView.PerformClick localPerformClick = this.mPerformClick;
          localPerformClick.mClickMotionPosition = j;
          localPerformClick.rememberWindowAttachCount();
          if ((localObject != null) && (!((View)localObject).hasFocusable()) && (i != 0))
          {
            if (this.mTouchMode != 0) {
              ((View)localObject).setPressed(false);
            }
            this.mResurrectToPosition = j;
            i = this.mTouchMode;
            if ((i != 0) && (i != 1))
            {
              if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j))) {
                localPerformClick.run();
              }
            }
            else
            {
              Handler localHandler = getHandler();
              if (localHandler != null)
              {
                if (this.mTouchMode == 0) {
                  paramMotionEvent = this.mPendingCheckForTap;
                } else {
                  paramMotionEvent = this.mPendingCheckForLongPress;
                }
                localHandler.removeCallbacks(paramMotionEvent);
              }
              this.mLayoutMode = 0;
              if ((!this.mDataChanged) && (this.mAdapter.isEnabled(j)))
              {
                this.mTouchMode = 1;
                setSelectedPositionInt(this.mMotionPosition);
                layoutChildren();
                ((View)localObject).setPressed(true);
                positionSelector(this.mMotionPosition, (View)localObject);
                setPressed(true);
                paramMotionEvent = this.mSelector;
                if (paramMotionEvent != null)
                {
                  paramMotionEvent = paramMotionEvent.getCurrent();
                  if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TransitionDrawable))) {
                    ((TransitionDrawable)paramMotionEvent).resetTransition();
                  }
                }
                paramMotionEvent = this.mTouchModeReset;
                if (paramMotionEvent != null) {
                  removeCallbacks(paramMotionEvent);
                }
                this.mTouchModeReset = new AbsListView.1(this, (View)localObject, localPerformClick);
                postDelayed(this.mTouchModeReset, ViewConfiguration.getPressedStateDuration());
                return true;
              }
              this.mTouchMode = -1;
              updateSelectorState();
              return true;
            }
          }
          else
          {
            localPerformClick.run();
          }
          this.mTouchMode = -1;
          updateSelectorState();
        }
        setPressed(false);
        paramMotionEvent = this.mEdgeGlowTop;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.onRelease();
          this.mEdgeGlowBottom.onRelease();
        }
        invalidate();
        paramMotionEvent = getHandler();
        if (paramMotionEvent != null) {
          paramMotionEvent.removeCallbacks(this.mPendingCheckForLongPress);
        }
        recycleVelocityTracker();
        this.mActivePointerId = -1;
        paramMotionEvent = this.mScrollStrictSpan;
        if (paramMotionEvent != null)
        {
          this.mScrollStrictSpan = finishSpan(paramMotionEvent);
          return true;
        }
      }
    }
    else
    {
      if (this.mTouchMode != 6)
      {
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        k = (int)paramMotionEvent.getX();
        m = (int)paramMotionEvent.getY();
        j = pointToPosition(k, getScrollY() + m);
        i = j;
        if (!this.mDataChanged) {
          if ((this.mTouchMode != 4) && (j >= 0) && (((ListAdapter)getAdapter()).isEnabled(j)))
          {
            this.mTouchMode = 0;
            if (this.mPendingCheckForTap == null) {
              this.mPendingCheckForTap = new AbsListView.CheckForTap(this);
            }
            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
            i = j;
          }
          else
          {
            i = j;
            if (this.mTouchMode == 4)
            {
              createScrollingCache();
              this.mFlingRunnable.endFling();
              this.mTouchMode = 3;
              this.mMotionCorrection = 0;
              i = findMotionRow(m);
              this.mFlingRunnable.flywheelTouch();
            }
          }
        }
        if (i >= 0) {
          this.mMotionViewOriginalTop = getChildAt(i - this.mFirstPosition).getTop();
        }
        this.mMotionX = k;
        this.mMotionY = m;
        this.mMotionPosition = i;
        this.mLastY = -2147483648;
      }
      else
      {
        this.mFlingRunnable.endFling();
        localObject = this.mPositionScroller;
        if (localObject != null) {
          ((AbsListView.PositionScroller)localObject).stop();
        }
        localObject = this.mBottomScroller;
        if (localObject != null) {
          ((AbsListView.MoveToBottomScroller)localObject).stop();
        }
        this.mTouchMode = 5;
        this.mMotionX = ((int)paramMotionEvent.getX());
        i = (int)paramMotionEvent.getY();
        this.mLastY = i;
        this.mMotionY = i;
        this.mMotionCorrection = 0;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        this.mDirection = 0;
      }
      if ((performButtonActionOnTouchDown(paramMotionEvent)) && (this.mTouchMode == 0)) {
        removeCallbacks(this.mPendingCheckForTap);
      }
    }
    return true;
  }
  
  public void onTouchModeChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hideSelector();
      if ((getHeight() > 0) && (getChildCount() > 0)) {
        layoutChildren();
      }
      updateSelectorState();
      return;
    }
    int i = this.mTouchMode;
    if ((i == 5) || (i == 6))
    {
      if ((this.mFlingRunnable != null) && (getScrollY() == 0)) {
        this.mFlingRunnable.endFling();
      }
      Object localObject = this.mPositionScroller;
      if (localObject != null) {
        ((AbsListView.PositionScroller)localObject).stop();
      }
      localObject = this.mBottomScroller;
      if (localObject != null) {
        ((AbsListView.MoveToBottomScroller)localObject).stop();
      }
      if (getScrollY() != 0)
      {
        setScrollY(0);
        invalidateParentCaches();
        finishGlows();
        invalidate();
      }
    }
  }
  
  public void onTouchUpWithYVelocity(int paramInt1, int paramInt2) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    int i = isInTouchMode() ^ true;
    if (!paramBoolean)
    {
      if ((!this.mForHongBao) && (!this.mForStory))
      {
        setChildrenDrawingCacheEnabled(false);
        Object localObject = this.mFlingRunnable;
        if (localObject != null)
        {
          removeCallbacks((Runnable)localObject);
          this.mFlingRunnable.endFling();
          localObject = this.mPositionScroller;
          if (localObject != null) {
            ((AbsListView.PositionScroller)localObject).stop();
          }
          localObject = this.mBottomScroller;
          if (localObject != null) {
            ((AbsListView.MoveToBottomScroller)localObject).stop();
          }
          resetScrollY();
        }
        dismissPopup();
        if (i == 1) {
          this.mResurrectToPosition = this.mSelectedPosition;
        }
      }
    }
    else
    {
      if ((this.mFiltered) && (!this.mPopupHidden)) {
        showPopup();
      }
      int j = this.mLastTouchMode;
      if ((i != j) && (j != -1)) {
        if (i == 1)
        {
          resurrectSelection();
        }
        else
        {
          hideSelector();
          this.mLayoutMode = 0;
          layoutChildren();
        }
      }
    }
    this.mLastTouchMode = i;
  }
  
  @TargetApi(9)
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    int k = this.mOverScrollMode;
    int i = computeHorizontalScrollRange();
    int j = computeHorizontalScrollExtent();
    boolean bool2 = false;
    if (i > j) {
      i = 1;
    } else {
      i = 0;
    }
    if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
      j = 1;
    } else {
      j = 0;
    }
    if ((k != 0) && ((k != 1) || (i == 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if ((k != 0) && ((k != 1) || (j == 0))) {
      j = 0;
    } else {
      j = 1;
    }
    paramInt3 += paramInt1;
    if (i == 0) {
      paramInt7 = 0;
    }
    paramInt4 += paramInt2;
    if (j == 0) {
      paramInt8 = 0;
    }
    paramInt2 = -paramInt7;
    paramInt5 = paramInt7 + paramInt5;
    if (this.mDisableOverScrollTop) {
      paramInt1 = 0;
    } else {
      paramInt1 = -paramInt8;
    }
    paramInt6 += paramInt8;
    if (paramInt3 > paramInt5) {
      paramInt2 = paramInt5;
    }
    while (paramInt3 < paramInt2)
    {
      paramBoolean = true;
      break;
    }
    paramInt2 = paramInt3;
    paramBoolean = false;
    if (paramInt4 > paramInt6) {
      paramInt1 = paramInt6;
    }
    while (paramInt4 < paramInt1)
    {
      bool1 = true;
      break;
    }
    boolean bool1 = false;
    paramInt1 = paramInt4;
    if ((!this.mForHongBao) || (paramInt1 <= 0)) {
      onOverScrolled(paramInt2, paramInt1, paramBoolean, bool1);
    }
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!bool1) {}
    }
    else
    {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramInt, paramBundle)) {
      return true;
    }
    if (paramInt != 4096)
    {
      if (paramInt != 8192) {
        return false;
      }
      if ((isEnabled()) && (this.mFirstPosition > 0))
      {
        smoothScrollBy(-(getHeight() - this.mListPadding.top - this.mListPadding.bottom), 400);
        return true;
      }
      return false;
    }
    if ((isEnabled()) && (getLastVisiblePosition() < getCount() - 1))
    {
      smoothScrollBy(getHeight() - this.mListPadding.top - this.mListPadding.bottom, 400);
      return true;
    }
    return false;
  }
  
  @TargetApi(14)
  protected boolean performButtonActionOnTouchDown(MotionEvent paramMotionEvent)
  {
    return (VersionUtils.d()) && ((paramMotionEvent.getButtonState() & 0x2) != 0) && (showContextMenu(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = isValidPosition(paramInt, ((ListAdapter)getAdapter()).getCount());
    int i = 0;
    boolean bool1 = true;
    if (bool2)
    {
      int j = this.mChoiceMode;
      if (j != 0)
      {
        if ((j != 2) && ((j != 3) || (this.mChoiceActionMode == null))) {
          if (this.mChoiceMode == 1) {
            if ((this.mCheckStates.get(paramInt, false) ^ true))
            {
              this.mCheckStates.clear();
              this.mCheckStates.put(paramInt, true);
              if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds()))
              {
                this.mCheckedIdStates.clear();
                this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
              }
              this.mCheckedItemCount = 1;
            }
            else if ((this.mCheckStates.size() == 0) || (!this.mCheckStates.valueAt(0)))
            {
              this.mCheckedItemCount = 0;
            }
          }
        }
        ActionMode localActionMode;
        do
        {
          i = 1;
          break;
          bool2 = this.mCheckStates.get(paramInt, false) ^ true;
          this.mCheckStates.put(paramInt, bool2);
          if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds())) {
            if (bool2) {
              this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
            } else {
              this.mCheckedIdStates.delete(this.mAdapter.getItemId(paramInt));
            }
          }
          if (bool2) {
            this.mCheckedItemCount += 1;
          } else {
            this.mCheckedItemCount -= 1;
          }
          localActionMode = this.mChoiceActionMode;
        } while (localActionMode == null);
        this.mMultiChoiceModeCallback.onItemCheckedStateChanged(localActionMode, paramInt, paramLong, bool2);
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        break label350;
      }
    }
    i = 1;
    bool1 = false;
    label350:
    bool2 = bool1;
    if (i != 0) {
      bool2 = bool1 | super.performItemClick(paramView, paramInt, paramLong);
    }
    return bool2;
  }
  
  @TargetApi(11)
  boolean performLongPress(View paramView, int paramInt, long paramLong)
  {
    if (this.mChoiceMode == 3)
    {
      if ((VersionUtils.e()) && (this.mChoiceActionMode == null))
      {
        paramView = startActionMode(this.mMultiChoiceModeCallback);
        this.mChoiceActionMode = paramView;
        if (paramView != null)
        {
          setItemChecked(paramInt, true);
          performHapticFeedback(0);
        }
      }
      return true;
    }
    boolean bool1;
    if (this.mOnItemLongClickListener != null) {
      bool1 = this.mOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      this.mContextMenuInfo = createContextMenuInfo(paramView, paramInt, paramLong);
      bool2 = super.showContextMenuForChild(this);
    }
    if (bool2) {
      performHapticFeedback(0);
    }
    return bool2;
  }
  
  public int pointToPosition(int paramInt1, int paramInt2)
  {
    Object localObject2 = this.mTouchFrame;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      this.mTouchFrame = new Rect();
      localObject1 = this.mTouchFrame;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject2 = getChildAt(i);
      if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0))
      {
        ((View)localObject2).getHitRect((Rect)localObject1);
        if (((Rect)localObject1).contains(paramInt1, paramInt2)) {
          return this.mFirstPosition + i;
        }
      }
      i -= 1;
    }
    return -1;
  }
  
  public long pointToRowId(int paramInt1, int paramInt2)
  {
    paramInt1 = pointToPosition(paramInt1, paramInt2);
    if (paramInt1 >= 0) {
      return this.mAdapter.getItemId(paramInt1);
    }
    return -9223372036854775808L;
  }
  
  void positionSelector(int paramInt, View paramView)
  {
    if (paramInt != -1) {
      this.mSelectorPosition = paramInt;
    }
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    if ((paramView instanceof AbsListView.SelectionBoundsAdjuster)) {
      ((AbsListView.SelectionBoundsAdjuster)paramView).adjustListItemSelectionBounds(localRect);
    }
    positionSelector(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.mIsChildViewEnabled;
    if (paramView.isEnabled() != bool)
    {
      this.mIsChildViewEnabled = (bool ^ true);
      if (getSelectedItemPosition() != -1) {
        refreshDrawableState();
      }
    }
  }
  
  public void reclaimViews(List<View> paramList)
  {
    int j = getChildCount();
    AbsListView.RecyclerListener localRecyclerListener = AbsListView.RecycleBin.access$2700(this.mRecycler);
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams != null) && (this.mRecycler.shouldRecycleViewType(localLayoutParams.viewType)))
      {
        paramList.add(localView);
        if (localRecyclerListener != null) {
          localRecyclerListener.onMovedToScrapHeap(localView);
        }
      }
      i += 1;
    }
    this.mRecycler.reclaimScrapViews(paramList);
    removeAllViewsInLayout();
  }
  
  int reconcileSelectedPosition()
  {
    int j = this.mSelectedPosition;
    int i = j;
    if (j < 0) {
      i = this.mResurrectToPosition;
    }
    return Math.min(Math.max(0, i), this.mItemCount - 1);
  }
  
  void rememberSyncState()
  {
    if (getChildCount() > 0)
    {
      this.mNeedSync = true;
      this.mSyncHeight = this.mLayoutHeight;
      if (this.mSelectedPosition >= 0)
      {
        localObject1 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSyncRowId = this.mNextSelectedRowId;
        this.mSyncPosition = this.mNextSelectedPosition;
        if (localObject1 != null)
        {
          this.mSpecificTop = ((View)localObject1).getTop();
          this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject1).getBottom());
        }
        this.mSyncMode = 0;
        return;
      }
      if (((getScrollY() == 0) && (!this.mStackFromBottom)) || (getScrollY() < 0))
      {
        localObject1 = getChildAt(0);
        localObject2 = (ListAdapter)getAdapter();
        if ((this.mFirstPosition >= 0) && (this.mFirstPosition < ((ListAdapter)localObject2).getCount())) {
          this.mSyncRowId = ((ListAdapter)localObject2).getItemId(this.mFirstPosition);
        } else {
          this.mSyncRowId = -1L;
        }
        this.mSyncPosition = this.mFirstPosition;
        if (localObject1 != null)
        {
          this.mSpecificTop = ((View)localObject1).getTop();
          this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject1).getBottom());
        }
        this.mSyncMode = 1;
        return;
      }
      Object localObject1 = (ListAdapter)getAdapter();
      int j = getChildCount();
      int k = this.mFirstPosition;
      int i = -1;
      if (k != -1) {
        i = this.mFirstPosition + j - 1;
      }
      Object localObject2 = getChildAt(j - 1);
      if ((i >= 0) && (i < ((ListAdapter)localObject1).getCount())) {
        this.mSyncRowId = ((ListAdapter)localObject1).getItemId(i);
      } else {
        this.mSyncRowId = -1L;
      }
      this.mSyncPosition = i;
      if (localObject2 != null)
      {
        this.mSpecificTop = ((View)localObject2).getTop();
        this.mSpecificBottom = (this.mLayoutHeight - ((View)localObject2).getBottom());
      }
      this.mSyncMode = 2;
    }
  }
  
  public void removeOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListenerList.remove(paramOnScrollListener);
  }
  
  protected void reportScrollStateChange(int paramInt)
  {
    if (paramInt != this.mLastScrollState)
    {
      this.mLastScrollState = paramInt;
      AbsListView.OnScrollListener localOnScrollListener = this.mOnScrollListener;
      if (localOnScrollListener != null) {
        localOnScrollListener.onScrollStateChanged(this, paramInt);
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      recycleVelocityTracker();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.mBlockLayoutRequests) && (!this.mInLayout))
    {
      rememberSyncState();
      super.requestLayout();
    }
  }
  
  void requestLayoutIfNecessary()
  {
    if (getChildCount() > 0)
    {
      resetList();
      requestLayout();
      invalidate();
    }
  }
  
  void resetList()
  {
    removeAllViewsInLayout();
    this.mFirstPosition = 0;
    this.mDataChanged = true;
    this.mNeedSync = false;
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    this.mSelectedTop = 0;
    this.mSelectorPosition = -1;
    this.mSelectorRect.setEmpty();
    invalidate();
  }
  
  protected void resetScrollY()
  {
    if (getScrollY() != 0)
    {
      setScrollY(0);
      invalidateParentCaches();
      finishGlows();
      invalidate();
    }
  }
  
  boolean resurrectSelection()
  {
    int i2 = getChildCount();
    boolean bool2 = false;
    if (i2 <= 0) {
      return false;
    }
    int i = this.mListPadding.top;
    int k = getBottom() - getTop() - this.mListPadding.bottom;
    int i1 = this.mFirstPosition;
    int m = this.mResurrectToPosition;
    int n;
    if ((m >= i1) && (m < i1 + i2))
    {
      localObject = getChildAt(m - this.mFirstPosition);
      n = ((View)localObject).getTop();
      i2 = ((View)localObject).getBottom();
      if (n < i)
      {
        i += getVerticalFadingEdgeLength();
        j = m;
      }
      else
      {
        j = m;
        i = n;
        if (i2 > k)
        {
          i = k - ((View)localObject).getMeasuredHeight() - getVerticalFadingEdgeLength();
          j = m;
        }
      }
    }
    else
    {
      if (m >= i1) {
        break label253;
      }
      m = 0;
      j = 0;
      while (m < i2)
      {
        k = getChildAt(m).getTop();
        n = i;
        if (m == 0)
        {
          if (i1 <= 0)
          {
            j = i;
            if (k >= i) {}
          }
          else
          {
            j = i + getVerticalFadingEdgeLength();
          }
          i = k;
          n = j;
          j = i;
        }
        if (k >= n)
        {
          j = i1 + m;
          i = k;
          break label245;
        }
        m += 1;
        i = n;
      }
      i = j;
      j = i1;
    }
    label245:
    boolean bool1 = true;
    k = i;
    break label387;
    label253:
    int i3 = this.mItemCount;
    int i4 = i1 + i2;
    i2 -= 1;
    i = k;
    int j = 0;
    m = i2;
    while (m >= 0)
    {
      localObject = getChildAt(m);
      k = ((View)localObject).getTop();
      int i5 = ((View)localObject).getBottom();
      n = i;
      if (m == i2)
      {
        if (i4 >= i3)
        {
          j = i;
          if (i5 <= i) {}
        }
        else
        {
          j = i - getVerticalFadingEdgeLength();
        }
        i = k;
        n = j;
        j = i;
      }
      if (i5 <= n)
      {
        i = i1 + m;
        j = k;
        break label380;
      }
      m -= 1;
      i = n;
    }
    i = i4 - 1;
    label380:
    bool1 = false;
    k = j;
    j = i;
    label387:
    this.mResurrectToPosition = -1;
    removeCallbacks(this.mFlingRunnable);
    Object localObject = this.mPositionScroller;
    if (localObject != null) {
      ((AbsListView.PositionScroller)localObject).stop();
    }
    localObject = this.mBottomScroller;
    if (localObject != null) {
      ((AbsListView.MoveToBottomScroller)localObject).stop();
    }
    this.mTouchMode = -1;
    clearScrollingCache();
    this.mSpecificTop = k;
    i = lookForSelectablePosition(j, bool1);
    if ((i >= i1) && (i <= getLastVisiblePosition()))
    {
      this.mLayoutMode = 4;
      updateSelectorState();
      setSelectionInt(i);
      invokeOnItemScrollListener();
    }
    else
    {
      i = -1;
    }
    reportScrollStateChange(0);
    bool1 = bool2;
    if (i >= 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean resurrectSelectionIfNeeded()
  {
    if ((this.mSelectedPosition < 0) && (resurrectSelection()))
    {
      updateSelectorState();
      return true;
    }
    return false;
  }
  
  public void sendAccessibilityEvent(int paramInt)
  {
    if (paramInt == 4096)
    {
      int i = getFirstVisiblePosition();
      int j = getLastVisiblePosition();
      if ((this.mLastAccessibilityScrollEventFromIndex == i) && (this.mLastAccessibilityScrollEventToIndex == j)) {
        return;
      }
      this.mLastAccessibilityScrollEventFromIndex = i;
      this.mLastAccessibilityScrollEventToIndex = j;
    }
    super.sendAccessibilityEvent(paramInt);
  }
  
  boolean sendToTextFilter(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (!acceptFilter()) {
      return false;
    }
    if (paramInt1 != 4)
    {
      if (paramInt1 != 62) {
        if (paramInt1 != 66) {
          switch (paramInt1)
          {
          default: 
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        bool3 = false;
        bool2 = bool1;
        bool1 = bool3;
        break;
        bool1 = false;
        continue;
        bool1 = this.mFiltered;
      }
    }
    Object localObject;
    if (this.mFiltered)
    {
      localObject = this.mPopup;
      if ((localObject != null) && (((PopupWindow)localObject).isShowing()))
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localObject = getKeyDispatcherState();
          if (localObject != null) {
            ((KeyEvent.DispatcherState)localObject).startTracking(paramKeyEvent, this);
          }
        }
        for (;;)
        {
          bool1 = true;
          break label194;
          if ((paramKeyEvent.getAction() != 1) || (!paramKeyEvent.isTracking()) || (paramKeyEvent.isCanceled())) {
            break;
          }
          this.mTextFilter.setText("");
        }
      }
    }
    boolean bool1 = false;
    label194:
    boolean bool2 = false;
    boolean bool3 = bool1;
    if (bool2)
    {
      createTextFilter(true);
      if (paramKeyEvent.getRepeatCount() > 0) {
        localObject = KeyEvent.changeTimeRepeat(paramKeyEvent, paramKeyEvent.getEventTime(), 0);
      } else {
        localObject = paramKeyEvent;
      }
      int i = paramKeyEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return bool1;
          }
          return this.mTextFilter.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
        }
        return this.mTextFilter.onKeyUp(paramInt1, (KeyEvent)localObject);
      }
      bool3 = this.mTextFilter.onKeyDown(paramInt1, (KeyEvent)localObject);
    }
    return bool3;
  }
  
  @android.support.annotation.RequiresApi(api=16)
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((paramListAdapter != null) && (this.mChoiceMode != 0) && (this.mAdapter.hasStableIds()) && (this.mCheckedIdStates == null)) {
      this.mCheckedIdStates = new LongSparseArray();
    }
    paramListAdapter = this.mCheckStates;
    if (paramListAdapter != null) {
      paramListAdapter.clear();
    }
    paramListAdapter = this.mCheckedIdStates;
    if (paramListAdapter != null) {
      paramListAdapter.clear();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt != this.mCacheColorHint)
    {
      this.mCacheColorHint = paramInt;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        getChildAt(i).setDrawingCacheBackgroundColor(paramInt);
        i += 1;
      }
      this.mRecycler.setCacheColorHint(paramInt);
    }
  }
  
  public void setCallbackOnUnClickItem(boolean paramBoolean)
  {
    this.mCallbackOnUnClickItem = paramBoolean;
  }
  
  @TargetApi(11)
  public void setChoiceMode(int paramInt)
  {
    this.mChoiceMode = paramInt;
    Object localObject = this.mChoiceActionMode;
    if (localObject != null)
    {
      ((ActionMode)localObject).finish();
      this.mChoiceActionMode = null;
    }
    if (this.mChoiceMode != 0)
    {
      if (this.mCheckStates == null) {
        this.mCheckStates = new SparseBooleanArray();
      }
      if (this.mCheckedIdStates == null)
      {
        localObject = this.mAdapter;
        if ((localObject != null) && (((ListAdapter)localObject).hasStableIds())) {
          this.mCheckedIdStates = new LongSparseArray();
        }
      }
      if (this.mChoiceMode == 3)
      {
        clearChoices();
        setLongClickable(true);
      }
    }
  }
  
  public void setDrawSelectorOnTop(boolean paramBoolean)
  {
    this.mDrawSelectorOnTop = paramBoolean;
  }
  
  public void setEdgeEffectEnabled(boolean paramBoolean)
  {
    if (this.mEdgeEffectEnabled != paramBoolean)
    {
      if (paramBoolean)
      {
        if ((this.mOverScrollMode != 2) && (this.mEdgeGlowTop == null))
        {
          Context localContext = getContext();
          this.mEdgeGlowTop = new EdgeEffect(localContext);
          this.mEdgeGlowBottom = new EdgeEffect(localContext);
        }
      }
      else
      {
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
      }
      this.mEdgeEffectEnabled = paramBoolean;
    }
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.mFastScrollEnabled)) {
      setFastScrollEnabled(true);
    }
    Object localObject = this.mFastScroller;
    if (localObject != null) {
      ((FastScroller)localObject).setAlwaysShow(paramBoolean);
    }
    try
    {
      localObject = View.class.getDeclaredMethod("computeOpaqueFlags", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(this, new Object[0]);
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException1.getMessage(), localException1);
      }
    }
    try
    {
      Method localMethod = View.class.getDeclaredMethod("recomputePadding", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      return;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException2.getMessage(), localException2);
      }
    }
  }
  
  public void setFastScrollEnabled(boolean paramBoolean)
  {
    this.mFastScrollEnabled = paramBoolean;
    if (paramBoolean)
    {
      if (this.mFastScroller == null) {
        this.mFastScroller = new FastScroller(getContext(), this);
      }
    }
    else
    {
      FastScroller localFastScroller = this.mFastScroller;
      if (localFastScroller != null)
      {
        localFastScroller.stop();
        this.mFastScroller = null;
      }
    }
  }
  
  public void setFilterText(String paramString)
  {
    if ((this.mTextFilterEnabled) && (!TextUtils.isEmpty(paramString)))
    {
      createTextFilter(false);
      this.mTextFilter.setText(paramString);
      this.mTextFilter.setSelection(paramString.length());
      ListAdapter localListAdapter = this.mAdapter;
      if ((localListAdapter instanceof Filterable))
      {
        if (this.mPopup == null) {
          ((Filterable)localListAdapter).getFilter().filter(paramString);
        }
        this.mFiltered = true;
        this.mDataSetObserver.clearSavedState();
      }
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool)
    {
      if (getWindowVisibility() == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((this.mFiltered) && (paramInt1 != 0))
      {
        PopupWindow localPopupWindow = this.mPopup;
        if ((localPopupWindow != null) && (localPopupWindow.isShowing())) {
          positionPopup();
        }
      }
    }
    return bool;
  }
  
  public void setFriction(float paramFloat)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    AbsListView.FlingRunnable.access$1100(this.mFlingRunnable).setFriction(paramFloat);
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    AbsListView.FlingRunnable localFlingRunnable = this.mFlingRunnable;
    if (localFlingRunnable != null) {
      AbsListView.FlingRunnable.access$1100(localFlingRunnable).setInterpolator(paramInterpolator);
    }
  }
  
  public void setIsNeedScrollPositionTop(boolean paramBoolean)
  {
    this.mIsNeedScrollPositionTop = paramBoolean;
  }
  
  @TargetApi(11)
  public void setItemChecked(int paramInt, boolean paramBoolean)
  {
    if (this.mChoiceMode == 0) {
      return;
    }
    if ((VersionUtils.e()) && (paramBoolean) && (this.mChoiceMode == 3) && (this.mChoiceActionMode == null)) {
      this.mChoiceActionMode = startActionMode(this.mMultiChoiceModeCallback);
    }
    int i = this.mChoiceMode;
    if ((i != 2) && (i != 3))
    {
      if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds())) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramBoolean) || (isItemChecked(paramInt)))
      {
        this.mCheckStates.clear();
        if (i != 0) {
          this.mCheckedIdStates.clear();
        }
      }
      if (paramBoolean)
      {
        this.mCheckStates.put(paramInt, true);
        if (i != 0) {
          this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
        }
        this.mCheckedItemCount = 1;
      }
      else if ((this.mCheckStates.size() == 0) || (!this.mCheckStates.valueAt(0)))
      {
        this.mCheckedItemCount = 0;
      }
    }
    else
    {
      boolean bool = this.mCheckStates.get(paramInt);
      this.mCheckStates.put(paramInt, paramBoolean);
      if ((this.mCheckedIdStates != null) && (this.mAdapter.hasStableIds())) {
        if (paramBoolean) {
          this.mCheckedIdStates.put(this.mAdapter.getItemId(paramInt), Integer.valueOf(paramInt));
        } else {
          this.mCheckedIdStates.delete(this.mAdapter.getItemId(paramInt));
        }
      }
      if (bool != paramBoolean) {
        if (paramBoolean) {
          this.mCheckedItemCount += 1;
        } else {
          this.mCheckedItemCount -= 1;
        }
      }
      if (this.mChoiceActionMode != null)
      {
        long l = this.mAdapter.getItemId(paramInt);
        this.mMultiChoiceModeCallback.onItemCheckedStateChanged(this.mChoiceActionMode, paramInt, l, paramBoolean);
      }
    }
    if ((!this.mInLayout) && (!this.mBlockLayoutRequests))
    {
      this.mDataChanged = true;
      rememberSyncState();
      requestLayout();
    }
  }
  
  public void setMaxOverScrollTopDistance(int paramInt)
  {
    this.mBottomOverflingDistance = ((int)(getResources().getDisplayMetrics().density * paramInt + 0.5F));
  }
  
  public void setMaximumVelocity(int paramInt)
  {
    this.mMaximumVelocity = paramInt;
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    if (this.mMultiChoiceModeCallback == null) {
      this.mMultiChoiceModeCallback = new AbsListView.MultiChoiceModeWrapper(this);
    }
    this.mMultiChoiceModeCallback.setWrapped(paramMultiChoiceModeListener);
  }
  
  public void setNeedCheckSpringback(boolean paramBoolean)
  {
    this.mNeedCheckSpringback = paramBoolean;
  }
  
  public void setOnNestedScrollingListener(AbsListView.OnNestedScrollingListener paramOnNestedScrollingListener)
  {
    this.onNestedScrollingListener = paramOnNestedScrollingListener;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
    invokeOnItemScrollListener();
  }
  
  public void setOnScrollToButtomListener(AbsListView.OnScrollButtomListener paramOnScrollButtomListener)
  {
    this.mOnScrollButtomListener = paramOnScrollButtomListener;
  }
  
  public void setOverScrollEffectPadding(int paramInt1, int paramInt2)
  {
    this.mGlowPaddingLeft = paramInt1;
    this.mGlowPaddingRight = paramInt2;
  }
  
  public void setOverScrollFlingMode(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    AbsListView.FlingRunnable.access$1100(this.mFlingRunnable).setFlingMode(paramInt);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    Object localObject;
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid overscroll mode ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    if (paramInt != 2)
    {
      if ((this.mEdgeGlowTop != null) || (!this.mEdgeEffectEnabled)) {
        break label112;
      }
      localObject = getContext();
    }
    try
    {
      this.mEdgeGlowTop = new EdgeEffect((Context)localObject);
      this.mEdgeGlowBottom = new EdgeEffect((Context)localObject);
    }
    catch (Throwable localThrowable)
    {
      label112:
      break label112;
    }
    this.mEdgeGlowTop = null;
    this.mEdgeGlowBottom = null;
    this.mOverScrollMode = paramInt;
  }
  
  public void setOverScrollTouchMode(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mode error ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.mOverScrollTouchMode = paramInt;
  }
  
  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    AbsListView.RecycleBin.access$2702(this.mRecycler, paramRecyclerListener);
  }
  
  public void setScrollIndicators(View paramView1, View paramView2)
  {
    this.mScrollUp = paramView1;
    this.mScrollDown = paramView2;
  }
  
  public void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if ((this.mScrollingCacheEnabled) && (!paramBoolean)) {
      clearScrollingCache();
    }
    this.mScrollingCacheEnabled = paramBoolean;
  }
  
  abstract void setSelectionInt(int paramInt);
  
  public void setSelector(int paramInt)
  {
    setSelector(getResources().getDrawable(paramInt));
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    Object localObject = this.mSelector;
    if (localObject != null)
    {
      ((Drawable)localObject).setCallback(null);
      unscheduleDrawable(this.mSelector);
    }
    this.mSelector = paramDrawable;
    localObject = new Rect();
    paramDrawable.getPadding((Rect)localObject);
    this.mSelectionLeftPadding = ((Rect)localObject).left;
    this.mSelectionTopPadding = ((Rect)localObject).top;
    this.mSelectionRightPadding = ((Rect)localObject).right;
    this.mSelectionBottomPadding = ((Rect)localObject).bottom;
    paramDrawable.setCallback(this);
    updateSelectorState();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromBottom(boolean paramBoolean)
  {
    if (this.mStackFromBottom != paramBoolean)
    {
      this.mStackFromBottom = paramBoolean;
      requestLayoutIfNecessary();
    }
  }
  
  public void setStackFromBottomWithoutRequestLayoutIfNecessary(boolean paramBoolean)
  {
    if (this.mStackFromBottom != paramBoolean) {
      this.mStackFromBottom = paramBoolean;
    }
  }
  
  public void setTextFilterEnabled(boolean paramBoolean)
  {
    this.mTextFilterEnabled = paramBoolean;
  }
  
  public void setTranscriptMode(int paramInt)
  {
    this.mTranscriptMode = paramInt;
  }
  
  public void setVelocityScale(float paramFloat)
  {
    this.mVelocityScale = paramFloat;
  }
  
  public void setVerticalScrollbarPosition(int paramInt)
  {
    super.setVerticalScrollbarPosition(paramInt);
    FastScroller localFastScroller = this.mFastScroller;
    if (localFastScroller != null) {
      localFastScroller.setScrollbarPosition(paramInt);
    }
  }
  
  boolean shouldShowSelector()
  {
    return ((hasFocus()) && (!isInTouchMode())) || (touchModeDrawsInPressedState());
  }
  
  public boolean showContextMenu(float paramFloat1, float paramFloat2, int paramInt)
  {
    paramInt = pointToPosition((int)paramFloat1, (int)paramFloat2);
    if (paramInt != -1)
    {
      long l = this.mAdapter.getItemId(paramInt);
      View localView = getChildAt(paramInt - this.mFirstPosition);
      if (localView != null)
      {
        this.mContextMenuInfo = createContextMenuInfo(localView, paramInt, l);
        return super.showContextMenuForChild(this);
      }
    }
    return super.showContextMenu();
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i = getPositionForView(paramView);
    boolean bool1 = false;
    boolean bool2 = false;
    if (i >= 0)
    {
      long l = this.mAdapter.getItemId(i);
      if (this.mOnItemLongClickListener != null) {
        bool2 = this.mOnItemLongClickListener.onItemLongClick(this, paramView, i, l);
      }
      bool1 = bool2;
      if (!bool2)
      {
        this.mContextMenuInfo = createContextMenuInfo(getChildAt(i - this.mFirstPosition), i, l);
        bool1 = super.showContextMenuForChild(paramView);
      }
    }
    return bool1;
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    int i = this.mFirstPosition;
    int j = getChildCount();
    int k = getPaddingTop();
    int m = getHeight();
    int n = getPaddingBottom();
    if ((paramInt1 != 0) && (this.mItemCount != 0) && (j != 0) && ((i != 0) || (getChildAt(0).getTop() != k) || (paramInt1 >= 0)) && ((i + j - 1 != this.mItemCount - 1) || (getChildAt(j - 1).getBottom() != m - n) || (paramInt1 <= 0)))
    {
      reportScrollStateChange(2);
      this.mFlingRunnable.startScroll(paramInt1, paramInt2);
      return;
    }
    this.mFlingRunnable.endFling();
    Object localObject = this.mPositionScroller;
    if (localObject != null) {
      ((AbsListView.PositionScroller)localObject).stop();
    }
    localObject = this.mBottomScroller;
    if (localObject != null) {
      ((AbsListView.MoveToBottomScroller)localObject).stop();
    }
  }
  
  public void smoothScrollByImmediately(int paramInt1, int paramInt2)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    int i = this.mFirstPosition;
    int j = getChildCount();
    int k = getPaddingTop();
    int m = getHeight();
    int n = getPaddingBottom();
    if ((paramInt1 != 0) && (this.mItemCount != 0) && (j != 0) && ((i != 0) || (getChildAt(0).getTop() != k) || (paramInt1 >= 0)) && ((i + j - 1 != this.mItemCount - 1) || (getChildAt(j - 1).getBottom() != m - n) || (paramInt1 <= 0)))
    {
      reportScrollStateChange(2);
      this.mFlingRunnable.startScrollImmediately(paramInt1, paramInt2);
      return;
    }
    this.mFlingRunnable.endFling();
    Object localObject = this.mPositionScroller;
    if (localObject != null) {
      ((AbsListView.PositionScroller)localObject).stop();
    }
    localObject = this.mBottomScroller;
    if (localObject != null) {
      ((AbsListView.MoveToBottomScroller)localObject).stop();
    }
  }
  
  void smoothScrollByOffset(int paramInt)
  {
    int i;
    if (paramInt < 0) {
      i = getFirstVisiblePosition();
    } else if (paramInt > 0) {
      i = getLastVisiblePosition();
    } else {
      i = -1;
    }
    if (i > -1)
    {
      View localView = getChildAt(i - getFirstVisiblePosition());
      if (localView != null)
      {
        Rect localRect = new Rect();
        int j = i;
        if (localView.getGlobalVisibleRect(localRect))
        {
          j = localView.getWidth();
          int k = localView.getHeight();
          float f = localRect.width() * localRect.height() / (j * k);
          if ((paramInt < 0) && (f < 0.75F))
          {
            j = i + 1;
          }
          else
          {
            j = i;
            if (paramInt > 0)
            {
              j = i;
              if (f < 0.75F) {
                j = i - 1;
              }
            }
          }
        }
        smoothScrollToPosition(Math.max(0, Math.min(getCount(), j + paramInt)));
      }
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new AbsListView.PositionScroller(this);
    }
    this.mPositionScroller.start(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new AbsListView.PositionScroller(this);
    }
    this.mPositionScroller.start(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new AbsListView.PositionScroller(this);
    }
    this.mPositionScroller.startWithOffset(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mPositionScroller == null) {
      this.mPositionScroller = new AbsListView.PositionScroller(this);
    }
    this.mPositionScroller.startWithOffset(paramInt1, paramInt2, paramInt3);
  }
  
  public void springBackTo(int paramInt)
  {
    if (this.mFlingRunnable == null) {
      this.mFlingRunnable = new AbsListView.FlingRunnable(this);
    }
    this.mFlingRunnable.startSpringback(paramInt);
  }
  
  public boolean startScrollIfNeeded(int paramInt)
  {
    int m = paramInt - this.mMotionY;
    int j = Math.abs(m);
    int i;
    if (getScrollY() != 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (((i != 0) && (!this.mForHongBao) && (!this.mForStory)) || (j > this.mTouchSlop)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((getNestedScrollAxes() & 0x2) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    if ((j != 0) && (k == 0))
    {
      createScrollingCache();
      if (i != 0)
      {
        this.mTouchMode = 5;
        this.mMotionCorrection = 0;
      }
      else
      {
        this.mTouchMode = 3;
        if (m > 0) {
          i = this.mTouchSlop;
        } else {
          i = -this.mTouchSlop;
        }
        this.mMotionCorrection = i;
      }
      Object localObject = getHandler();
      if (localObject != null) {
        ((Handler)localObject).removeCallbacks(this.mPendingCheckForLongPress);
      }
      setPressed(false);
      localObject = getChildAt(this.mMotionPosition - this.mFirstPosition);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      reportScrollStateChange(1);
      localObject = getParent();
      if (localObject != null) {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
      }
      scrollIfNeeded(paramInt);
      return true;
    }
    return false;
  }
  
  boolean touchModeDrawsInPressedState()
  {
    int i = this.mTouchMode;
    return (i == 1) || (i == 2);
  }
  
  public boolean trackMotionScroll(int paramInt1, int paramInt2)
  {
    i = getChildCount();
    if (i == 0) {
      return true;
    }
    traceBegin("AbsListView.trackMotionScroll");
    try
    {
      i4 = getChildAt(0).getTop();
      i2 = i - 1;
      i5 = getChildAt(i2).getBottom();
      localObject1 = this.mListPadding;
      if ((getQQGroupFlag() & 0x22) != 34) {
        break label791;
      }
      j = ((Rect)localObject1).top;
      k = ((Rect)localObject1).bottom;
    }
    finally
    {
      for (;;)
      {
        int i4;
        int i2;
        int i5;
        Object localObject1;
        int i6;
        int n;
        int m;
        int i7;
        boolean bool2;
        int i8;
        int i9;
        boolean bool1;
        int i1;
        int i3;
        traceEnd();
        for (;;)
        {
          throw localObject2;
        }
        int j = 0;
        int k = 0;
        continue;
        paramInt1 = 0;
        continue;
        paramInt2 = 0;
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          if (n < 0)
          {
            bool1 = true;
          }
          else
          {
            bool1 = false;
            continue;
            i1 = 0;
            paramInt1 = 0;
            continue;
            i1 += 1;
            continue;
            i2 = 0;
            i3 = paramInt1;
            continue;
            i = i2;
            paramInt1 = 0;
            paramInt2 = 0;
            continue;
            i2 = i - 1;
            paramInt1 = i;
            i = i2;
          }
        }
      }
    }
    i6 = getHeight();
    n = getHeight() - getPaddingBottom() - getPaddingTop();
    if (paramInt1 < 0) {
      m = Math.max(-(n - 1), paramInt1);
    } else {
      m = Math.min(n - 1, paramInt1);
    }
    if (paramInt2 < 0) {
      n = Math.max(-(n - 1), paramInt2);
    } else {
      n = Math.min(n - 1, paramInt2);
    }
    i7 = this.mFirstPosition;
    if (i7 == 0) {
      this.mFirstPositionDistanceGuess = (i4 - ((Rect)localObject1).top);
    } else {
      this.mFirstPositionDistanceGuess += n;
    }
    paramInt2 = i7 + i;
    if (paramInt2 == this.mItemCount) {
      this.mLastPositionDistanceGuess = (((Rect)localObject1).bottom + i5);
    } else {
      this.mLastPositionDistanceGuess += n;
    }
    if ((i7 == 0) && (i4 >= ((Rect)localObject1).top) && (n >= 0))
    {
      paramInt1 = 1;
      if ((paramInt2 != this.mItemCount) || (i5 > getHeight() - ((Rect)localObject1).bottom) || (n > 0)) {
        break label805;
      }
      paramInt2 = 1;
      break label807;
      bool2 = isInTouchMode();
      if (bool2) {
        hideSelector();
      }
      i8 = getHeaderViewsCount();
      i9 = this.mItemCount - getFooterViewsCount();
      if (bool1)
      {
        paramInt1 = -n;
        paramInt2 = paramInt1;
        if ((getQQGroupFlag() & 0x22) != 34) {
          break label835;
        }
        paramInt2 = paramInt1 + ((Rect)localObject1).top;
        break label835;
        if (i1 >= i) {
          break label852;
        }
        localObject1 = getChildAt(i1);
        if (((View)localObject1).getBottom() >= paramInt2) {
          break label852;
        }
        paramInt1 += 1;
        i2 = i7 + i1;
        if ((i2 < i8) || (i2 >= i9)) {
          break label843;
        }
        this.mRecycler.addScrapView((View)localObject1, i2);
        break label843;
      }
      paramInt1 = getHeight() - n;
      i1 = paramInt1;
      if ((getQQGroupFlag() & 0x22) != 34) {
        break label861;
      }
      i1 = paramInt1 - ((Rect)localObject1).bottom;
      break label861;
      i2 = paramInt1;
      i3 = paramInt2;
      if (i >= 0)
      {
        localObject1 = getChildAt(i);
        if (((View)localObject1).getTop() <= i1)
        {
          i2 = paramInt1;
          i3 = paramInt2;
        }
        else
        {
          paramInt2 += 1;
          paramInt1 = i7 + i;
          if ((paramInt1 < i8) || (paramInt1 >= i9)) {
            break label871;
          }
          this.mRecycler.addScrapView((View)localObject1, paramInt1);
          break label871;
        }
      }
      this.mMotionViewNewTop = (this.mMotionViewOriginalTop + m);
      this.mBlockLayoutRequests = true;
      if (i3 > 0) {
        detachViewsFromParent(i2, i3);
      }
      offsetChildrenTopAndBottomWrap(n);
      if (bool1) {
        this.mFirstPosition += i3;
      }
      invalidate();
      paramInt1 = Math.abs(n);
      if ((j - i4 < paramInt1) || (i5 - (i6 - k) < paramInt1)) {
        fillGap(bool1);
      }
      if ((!bool2) && (this.mSelectedPosition != -1))
      {
        paramInt1 = this.mSelectedPosition - this.mFirstPosition;
        if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
          positionSelector(this.mSelectedPosition, getChildAt(paramInt1));
        }
      }
      else if (this.mSelectorPosition != -1)
      {
        paramInt1 = this.mSelectorPosition - this.mFirstPosition;
        if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
          positionSelector(-1, getChildAt(paramInt1));
        }
      }
      else
      {
        this.mSelectorRect.setEmpty();
      }
      this.mBlockLayoutRequests = false;
      invokeOnItemScrollListener();
      awakenScrollBars();
      traceEnd();
      return false;
      bool1 = true;
      if ((this.mOnScrollButtomListener != null) && (n <= 0)) {
        this.mOnScrollButtomListener.onScrollToButtom(n);
      }
      if (n == 0) {
        bool1 = false;
      }
      traceEnd();
      return bool1;
    }
  }
  
  void updateScrollIndicators()
  {
    View localView = this.mScrollUp;
    int k = 4;
    int i;
    int j;
    if (localView != null)
    {
      if (this.mFirstPosition > 0) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (getChildCount() > 0) {
          if (getChildAt(0).getTop() < this.mListPadding.top) {
            j = 1;
          } else {
            j = 0;
          }
        }
      }
      localView = this.mScrollUp;
      if (j != 0) {
        i = 0;
      } else {
        i = 4;
      }
      localView.setVisibility(i);
    }
    if (this.mScrollDown != null)
    {
      int m = getChildCount();
      if (this.mFirstPosition + m < this.mItemCount) {
        j = 1;
      } else {
        j = 0;
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (m > 0) {
          if (getChildAt(m - 1).getBottom() > getBottom() - this.mListPadding.bottom) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      localView = this.mScrollDown;
      j = k;
      if (i != 0) {
        j = 0;
      }
      localView.setVisibility(j);
    }
  }
  
  void updateSelectorState()
  {
    if (this.mSelector != null)
    {
      if (shouldShowSelector())
      {
        this.mSelector.setState(getDrawableState());
        return;
      }
      this.mSelector.setState(NOTHING);
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.mSelector == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView
 * JD-Core Version:    0.7.0.1
 */