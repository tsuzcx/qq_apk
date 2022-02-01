package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RemoteViews.RemoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

@RemoteViews.RemoteView
public class ListView
  extends AbsListView
  implements SkinnableView
{
  private static final int ANIMATION_DURATION = 350;
  private static final int ANIMATION_TAG = 2131230829;
  public static final int HEADERVIEW_LEVEL_BOTTOM = 2;
  public static final int HEADERVIEW_LEVEL_MIDDLE = 1;
  public static final int HEADERVIEW_LEVEL_TOP = 0;
  public static final int HEADERVIEW_MAX_LEVEL = 3;
  private static final int LISTVIEW_DIVIDER = getStyleableValue("ListView_divider");
  private static final int LISTVIEW_DIVIDERHEIGHT;
  private static final int LISTVIEW_ENTRIES = getStyleableValue("ListView_entries");
  private static final int LISTVIEW_FOOTERDIVIDERSENABLED = getStyleableValue("ListView_footerDividersEnabled");
  private static final int LISTVIEW_HEADERDIVIDERSENABLED = getStyleableValue("ListView_headerDividersEnabled");
  private static final int LISTVIEW_OVERSCROLLFOOTER;
  private static final int LISTVIEW_OVERSCROLLHEADER;
  private static final float MAX_SCROLL_FACTOR = 0.33F;
  private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
  static final int NO_POSITION = -1;
  protected static final int OVERSCROLL_STATUS_COMPLETE_RELEASE = 3;
  protected static final int OVERSCROLL_STATUS_COMPLETE_VISABLE = 2;
  protected static final int OVERSCROLL_STATUS_IDLE = 0;
  private static final int OVERSCROLL_STATUS_VISABLE = 1;
  private boolean considerFooterWhenDrawOverScrollFooter = false;
  private long delAnimDuration;
  private boolean descendantInvalidatedFlag = false;
  public boolean isTouchHolding = false;
  private int[] mAddingRows = null;
  private boolean mAnimation = true;
  private boolean mAreAllItemsSelectable = true;
  private final ListView.ArrowScrollFocusResult mArrowScrollFocusResult = new ListView.ArrowScrollFocusResult(null);
  private Drawable mContentBackgroundDrawable;
  Drawable mDivider;
  int mDividerHeight;
  private boolean mDividerIsOpaque;
  private Paint mDividerPaint;
  private ListView.FocusSelector mFocusSelector;
  private boolean mFooterDividersEnabled;
  private ArrayList<ListView.FixedViewInfo> mFooterViewInfos = new ArrayList();
  private boolean mHeaderDividersEnabled;
  protected ArrayList<ListView.FixedViewInfo> mHeaderViewInfos = new ArrayList();
  protected int[] mHeaderViewLevelIndex = { 0, 0, 0 };
  private Animation mInsertAnimation;
  private boolean mIsCacheColorOpaque;
  private boolean mItemsCanFocus = false;
  private ListView.OnScrollChangeListener mOnScrollChangeListener;
  protected ListView.OnSpringBackListener mOnSpringBackListener;
  Drawable mOverScrollFooter;
  protected int mOverScrollFooterHeight = 0;
  Drawable mOverScrollHeader;
  protected Drawable mOverScrollHeaderShadow;
  int mOverScrollHeaderTopOffset = 0;
  protected int mOverScrollHeight = 0;
  protected OverScrollViewListener mOverScrollViewListener;
  protected ListView.OverscrollViewContainer mOverscrollFooterView;
  protected int mOverscrollHeadState = 0;
  public ListView.OverscrollViewContainer mOverscrollHeaderViewContainer;
  private final Rect mTempRect = new Rect();
  private boolean mUseEfficientMode;
  
  static
  {
    LISTVIEW_DIVIDERHEIGHT = getStyleableValue("ListView_dividerHeight");
    LISTVIEW_OVERSCROLLFOOTER = getStyleableValue("ListView_overScrollFooter");
    LISTVIEW_OVERSCROLLHEADER = getStyleableValue("ListView_overScrollHeader");
  }
  
  public ListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("ListView"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.getTextArray(LISTVIEW_ENTRIES);
    if (arrayOfCharSequence != null) {
      setAdapter(new ArrayAdapter(paramContext, 17367043, arrayOfCharSequence));
    }
    paramContext = paramAttributeSet.getDrawable(LISTVIEW_DIVIDER);
    if (paramContext != null) {
      setDivider(paramContext);
    }
    paramContext = paramAttributeSet.getDrawable(LISTVIEW_OVERSCROLLHEADER);
    if (paramContext != null) {
      setOverscrollHeader(paramContext);
    }
    paramContext = paramAttributeSet.getDrawable(LISTVIEW_OVERSCROLLFOOTER);
    if (paramContext != null) {
      setOverscrollFooter(paramContext);
    }
    paramInt = paramAttributeSet.getDimensionPixelSize(LISTVIEW_DIVIDERHEIGHT, 0);
    if (paramInt != 0) {
      setDividerHeight(paramInt);
    }
    this.mHeaderDividersEnabled = paramAttributeSet.getBoolean(LISTVIEW_HEADERDIVIDERSENABLED, true);
    this.mFooterDividersEnabled = paramAttributeSet.getBoolean(LISTVIEW_FOOTERDIVIDERSENABLED, true);
    paramAttributeSet.recycle();
  }
  
  private View addViewAbove(View paramView, int paramInt)
  {
    paramInt -= 1;
    View localView = obtainView(paramInt, this.mIsScrap);
    setupChild(localView, paramInt, paramView.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
    return localView;
  }
  
  private View addViewBelow(View paramView, int paramInt)
  {
    paramInt += 1;
    View localView = obtainView(paramInt, this.mIsScrap);
    setupChild(localView, paramInt, paramView.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
    return localView;
  }
  
  private void adjustViewsUpOrDown()
  {
    int m = getChildCount();
    if (m > 0)
    {
      boolean bool = this.mStackFromBottom;
      int j = 0;
      int k;
      int i;
      if (!bool)
      {
        k = getChildAt(0).getTop() - this.mListPadding.top;
        i = k;
        if (this.mFirstPosition != 0) {
          i = k - this.mDividerHeight;
        }
        if (i < 0) {
          i = j;
        }
      }
      else
      {
        k = getChildAt(m - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
        i = k;
        if (this.mFirstPosition + m < this.mItemCount) {
          i = k + this.mDividerHeight;
        }
        if (i > 0) {
          i = j;
        }
      }
      if (i != 0) {
        offsetChildrenTopAndBottomWrap(-i);
      }
    }
  }
  
  private int amountToScroll(int paramInt1, int paramInt2)
  {
    int i = getHeight() - this.mListPadding.bottom;
    int j = this.mListPadding.top;
    int k = getChildCount();
    if (paramInt1 == 130)
    {
      j = k - 1;
      if (paramInt2 != -1) {
        paramInt1 = paramInt2 - this.mFirstPosition;
      } else {
        paramInt1 = j;
      }
      int m = this.mFirstPosition;
      localView = getChildAt(paramInt1);
      if (m + paramInt1 < this.mItemCount - 1) {
        paramInt1 = i - getArrowScrollPreviewLength();
      } else {
        paramInt1 = i;
      }
      if (localView.getBottom() <= paramInt1) {
        return 0;
      }
      if ((paramInt2 != -1) && (paramInt1 - localView.getTop() >= getMaxScrollAmount())) {
        return 0;
      }
      paramInt2 = localView.getBottom() - paramInt1;
      paramInt1 = paramInt2;
      if (this.mFirstPosition + k == this.mItemCount) {
        paramInt1 = Math.min(paramInt2, getChildAt(j).getBottom() - i);
      }
      return Math.min(paramInt1, getMaxScrollAmount());
    }
    if (paramInt2 != -1) {
      paramInt1 = paramInt2 - this.mFirstPosition;
    } else {
      paramInt1 = 0;
    }
    i = this.mFirstPosition;
    View localView = getChildAt(paramInt1);
    if (i + paramInt1 > 0) {
      paramInt1 = getArrowScrollPreviewLength() + j;
    } else {
      paramInt1 = j;
    }
    if (localView.getTop() >= paramInt1) {
      return 0;
    }
    if ((paramInt2 != -1) && (localView.getBottom() - paramInt1 >= getMaxScrollAmount())) {
      return 0;
    }
    paramInt2 = paramInt1 - localView.getTop();
    paramInt1 = paramInt2;
    if (this.mFirstPosition == 0) {
      paramInt1 = Math.min(paramInt2, j - getChildAt(0).getTop());
    }
    return Math.min(paramInt1, getMaxScrollAmount());
  }
  
  private int amountToScrollToNewFocus(int paramInt1, View paramView, int paramInt2)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i;
    if (paramInt1 == 33)
    {
      if (this.mTempRect.top >= this.mListPadding.top) {
        break label130;
      }
      i = this.mListPadding.top - this.mTempRect.top;
      paramInt1 = i;
      if (paramInt2 <= 0) {
        return paramInt1;
      }
      paramInt1 = getArrowScrollPreviewLength();
    }
    else
    {
      paramInt1 = getHeight() - this.mListPadding.bottom;
      if (this.mTempRect.bottom <= paramInt1) {
        break label130;
      }
      i = this.mTempRect.bottom - paramInt1;
      paramInt1 = i;
      if (paramInt2 >= this.mItemCount - 1) {
        return paramInt1;
      }
      paramInt1 = getArrowScrollPreviewLength();
    }
    return i + paramInt1;
    label130:
    paramInt1 = 0;
    return paramInt1;
  }
  
  private ListView.ArrowScrollFocusResult arrowScrollFocused(int paramInt)
  {
    View localView = getSelectedView();
    int j;
    int i;
    int k;
    if ((localView != null) && (localView.hasFocus()))
    {
      localView = localView.findFocus();
      localView = FocusFinder.getInstance().findNextFocus(this, localView, paramInt);
    }
    else
    {
      j = 1;
      i = 1;
      if (paramInt == 130)
      {
        if (this.mFirstPosition <= 0) {
          i = 0;
        }
        j = this.mListPadding.top;
        if (i != 0) {
          i = getArrowScrollPreviewLength();
        } else {
          i = 0;
        }
        j += i;
        i = j;
        if (localView != null)
        {
          i = j;
          if (localView.getTop() > j) {
            i = localView.getTop();
          }
        }
        this.mTempRect.set(0, i, 0, i);
      }
      else
      {
        if (this.mFirstPosition + getChildCount() - 1 < this.mItemCount) {
          i = j;
        } else {
          i = 0;
        }
        j = getHeight();
        k = this.mListPadding.bottom;
        if (i != 0) {
          i = getArrowScrollPreviewLength();
        } else {
          i = 0;
        }
        j = j - k - i;
        i = j;
        if (localView != null)
        {
          i = j;
          if (localView.getBottom() < j) {
            i = localView.getBottom();
          }
        }
        this.mTempRect.set(0, i, 0, i);
      }
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, paramInt);
    }
    if (localView != null)
    {
      i = positionOfNewFocus(localView);
      if ((this.mSelectedPosition != -1) && (i != this.mSelectedPosition))
      {
        j = lookForSelectablePositionOnScreen(paramInt);
        if ((j != -1) && (((paramInt == 130) && (j < i)) || ((paramInt == 33) && (j > i)))) {
          return null;
        }
      }
      j = amountToScrollToNewFocus(paramInt, localView, i);
      k = getMaxScrollAmount();
      if (j < k)
      {
        localView.requestFocus(paramInt);
        this.mArrowScrollFocusResult.populate(i, j);
        return this.mArrowScrollFocusResult;
      }
      if (distanceToView(localView) < k)
      {
        localView.requestFocus(paramInt);
        this.mArrowScrollFocusResult.populate(i, k);
        return this.mArrowScrollFocusResult;
      }
    }
    return null;
  }
  
  private boolean arrowScrollImpl(int paramInt)
  {
    if (getChildCount() <= 0) {
      return false;
    }
    View localView2 = getSelectedView();
    int m = this.mSelectedPosition;
    int i = lookForSelectablePositionOnScreen(paramInt);
    int j = amountToScroll(paramInt, i);
    if (this.mItemsCanFocus) {
      localObject = arrowScrollFocused(paramInt);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      i = ((ListView.ArrowScrollFocusResult)localObject).getSelectedPosition();
      j = ((ListView.ArrowScrollFocusResult)localObject).getAmountToScroll();
    }
    int k;
    if (localObject != null) {
      k = 1;
    } else {
      k = 0;
    }
    View localView1 = localView2;
    if (i != -1)
    {
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      handleNewSelectionChange(localView2, paramInt, i, bool);
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      localView1 = getSelectedView();
      if ((this.mItemsCanFocus) && (localObject == null))
      {
        localView2 = getFocusedChild();
        if (localView2 != null) {
          localView2.clearFocus();
        }
      }
      checkSelectionChanged();
      m = i;
      k = 1;
    }
    if (j > 0)
    {
      if (paramInt != 33) {
        j = -j;
      }
      scrollListItemsBy(j);
      k = 1;
    }
    if ((this.mItemsCanFocus) && (localObject == null) && (localView1 != null) && (localView1.hasFocus()))
    {
      localObject = localView1.findFocus();
      if ((localObject != null) && ((!isViewAncestorOf((View)localObject, this)) || (distanceToView((View)localObject) > 0))) {
        ((View)localObject).clearFocus();
      }
    }
    Object localObject = localView1;
    if (i == -1)
    {
      localObject = localView1;
      if (localView1 != null)
      {
        localObject = localView1;
        if (!isViewAncestorOf(localView1, this))
        {
          hideSelector();
          this.mResurrectToPosition = -1;
          localObject = null;
        }
      }
    }
    if (k != 0)
    {
      if (localObject != null)
      {
        positionSelector(m, (View)localObject);
        this.mSelectedTop = ((View)localObject).getTop();
      }
      if (!awakenScrollBars()) {
        invalidate();
      }
      invokeOnItemScrollListener();
      return true;
    }
    return false;
  }
  
  private void attachWindow(View paramView)
  {
    try
    {
      Object localObject = ReflectionUtil.a("android.view.View", "mAttachInfo");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        Method localMethod = ReflectionUtil.a("android.view.View", "dispatchAttachedToWindow", new Class[] { localObject.getClass(), Integer.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(paramView, new Object[] { localObject, Integer.valueOf(getVisibility()) });
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, paramView.getMessage(), paramView);
      }
    }
  }
  
  private void checkOverScrollHeaderIsVisable()
  {
    if ((this.mTouchMode == 5) && (getScrollY() != 0))
    {
      int j = getScrollY();
      int i;
      Object localObject1;
      Object localObject2;
      if ((j < 0) && (this.mOverscrollHeaderViewContainer != null) && (j > -getOverScrollHeight()))
      {
        i = this.mOverscrollHeadState;
        if ((i == 0) || (i == 2))
        {
          localObject1 = this.mOverScrollViewListener;
          if (localObject1 != null) {
            ((OverScrollViewListener)localObject1).onNotCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
          }
          this.mOverscrollHeadState = 1;
        }
        localObject1 = this.mOverScrollViewListener;
        if ((localObject1 != null) && ((localObject1 instanceof ReadInJoyOverScrollViewListener)))
        {
          localObject1 = (ReadInJoyOverScrollViewListener)localObject1;
          localObject2 = this.mOverscrollHeaderViewContainer.getChildAt(0);
          if (getOverScrollHeight() > 0) {
            i = -j * 100 / getOverScrollHeight();
          } else {
            i = 0;
          }
          ((ReadInJoyOverScrollViewListener)localObject1).onNotCompleteVisable(0, (View)localObject2, this, i);
          ((ReadInJoyOverScrollViewListener)this.mOverScrollViewListener).onScrollView(this.mOverscrollHeaderViewContainer.getChildAt(0), this, -j);
        }
      }
      else if ((j > 0) && (this.mOverscrollFooterView != null) && (j < getOverScrollFooterHeight()))
      {
        i = this.mOverscrollHeadState;
        if ((i == 0) || (i == 2))
        {
          localObject1 = this.mOverScrollViewListener;
          if (localObject1 != null) {
            ((OverScrollViewListener)localObject1).onNotCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
          }
          this.mOverscrollHeadState = 1;
        }
        localObject1 = this.mOverScrollViewListener;
        if ((localObject1 != null) && ((localObject1 instanceof ReadInJoyOverScrollViewListener)))
        {
          localObject1 = (ReadInJoyOverScrollViewListener)localObject1;
          localObject2 = this.mOverscrollFooterView.getChildAt(0);
          if (getOverScrollFooterHeight() == 0) {
            i = 0;
          } else {
            i = j * 100 / getOverScrollFooterHeight();
          }
          ((ReadInJoyOverScrollViewListener)localObject1).onNotCompleteVisable(1, (View)localObject2, this, i);
          ((ReadInJoyOverScrollViewListener)this.mOverScrollViewListener).onScrollView(this.mOverscrollFooterView.getChildAt(0), this, j);
        }
      }
      else
      {
        if (j < 0)
        {
          localObject1 = this.mOverscrollHeaderViewContainer;
          if (localObject1 != null)
          {
            localObject2 = this.mOverScrollViewListener;
            if ((localObject2 == null) || (!(localObject2 instanceof ReadInJoyOverScrollViewListener))) {
              return;
            }
            ((ReadInJoyOverScrollViewListener)localObject2).onScrollView(((ListView.OverscrollViewContainer)localObject1).getChildAt(0), this, -j);
            return;
          }
        }
        if (j > 0)
        {
          localObject1 = this.mOverscrollFooterView;
          if (localObject1 != null)
          {
            localObject2 = this.mOverScrollViewListener;
            if ((localObject2 instanceof ReadInJoyOverScrollViewListener)) {
              ((ReadInJoyOverScrollViewListener)localObject2).onScrollView(((ListView.OverscrollViewContainer)localObject1).getChildAt(0), this, j);
            }
          }
        }
      }
    }
  }
  
  private void checkOverscrollViewIsCompleteVisable(View paramView)
  {
    int i = getScrollY();
    paramView.getHeight();
    if (paramView == this.mOverscrollHeaderViewContainer)
    {
      if ((this.mOverscrollHeadState == 1) && (i <= -getOverScrollHeight()))
      {
        this.mOverscrollHeadState = 2;
        paramView = this.mOverScrollViewListener;
        if (paramView != null) {
          paramView.onViewCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        }
      }
    }
    else if ((paramView == this.mOverscrollFooterView) && (this.mOverscrollHeadState == 1) && (i >= getOverScrollFooterHeight()))
    {
      this.mOverscrollHeadState = 2;
      paramView = this.mOverScrollViewListener;
      if (paramView != null) {
        paramView.onViewCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
      }
    }
  }
  
  private void clearRecycledState(ArrayList<ListView.FixedViewInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)((ListView.FixedViewInfo)paramArrayList.get(i)).view.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.recycledHeaderFooter = false;
        }
        i += 1;
      }
    }
  }
  
  @TargetApi(11)
  private boolean commonKey(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.mAdapter != null)
    {
      if (!this.mIsAttached) {
        return false;
      }
      if (this.mDataChanged) {
        layoutChildren();
      }
      int j = paramKeyEvent.getAction();
      if (j != 1)
      {
        if (paramInt1 != 62)
        {
          boolean bool2;
          if (paramInt1 != 66)
          {
            if (paramInt1 != 92) {
              if (paramInt1 != 93) {
                if (paramInt1 != 122) {
                  if (paramInt1 == 123) {}
                }
              }
            }
            switch (paramInt1)
            {
            default: 
              break;
            case 22: 
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                break label715;
              }
              bool1 = handleHorizontalFocusWithinListItem(66);
              i = paramInt2;
              break;
            case 21: 
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                break label715;
              }
              bool1 = handleHorizontalFocusWithinListItem(17);
              i = paramInt2;
              break;
            case 20: 
              if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
              {
                bool2 = resurrectSelectionIfNeeded();
                bool1 = bool2;
                i = paramInt2;
                if (bool2) {
                  break label721;
                }
                for (bool1 = bool2;; bool1 = true)
                {
                  i = paramInt2 - 1;
                  if ((paramInt2 <= 0) || (!arrowScroll(130))) {
                    break;
                  }
                  paramInt2 = i;
                }
                break label721;
              }
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                break label715;
              }
              if (resurrectSelectionIfNeeded()) {
                break;
              }
              if (!fullScroll(130)) {
                break label715;
              }
              break;
            case 19: 
              if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
              {
                bool2 = resurrectSelectionIfNeeded();
                bool1 = bool2;
                i = paramInt2;
                if (bool2) {
                  break label721;
                }
                for (bool1 = bool2;; bool1 = true)
                {
                  i = paramInt2 - 1;
                  if ((paramInt2 <= 0) || (!arrowScroll(33))) {
                    break;
                  }
                  paramInt2 = i;
                }
                break label721;
              }
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                break label715;
              }
              if (resurrectSelectionIfNeeded()) {
                break;
              }
              if (!fullScroll(33)) {
                break label715;
              }
              break;
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                break label715;
              }
              if (resurrectSelectionIfNeeded()) {
                break;
              }
              if (!fullScroll(130)) {
                break label715;
              }
              break;
              if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
                break label715;
              }
              if (resurrectSelectionIfNeeded()) {
                break;
              }
              if (!fullScroll(33)) {
                break label715;
              }
              break;
              if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
              {
                if (!resurrectSelectionIfNeeded()) {
                  if (!pageScroll(130)) {
                    break label715;
                  }
                }
              }
              else
              {
                if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                  break label715;
                }
                if (!resurrectSelectionIfNeeded())
                {
                  if (!fullScroll(130)) {
                    break label715;
                  }
                  break;
                  if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
                  {
                    if (!resurrectSelectionIfNeeded()) {
                      if (!pageScroll(33)) {
                        break label715;
                      }
                    }
                  }
                  else
                  {
                    if ((!VersionUtils.e()) || (!paramKeyEvent.hasModifiers(2))) {
                      break label715;
                    }
                    if (!resurrectSelectionIfNeeded()) {
                      if (!fullScroll(33)) {
                        break label715;
                      }
                    }
                  }
                }
              }
              break;
            }
          }
          else
          {
            if ((!VersionUtils.e()) || (!paramKeyEvent.hasNoModifiers())) {
              break label715;
            }
            bool2 = resurrectSelectionIfNeeded();
            bool1 = bool2;
            i = paramInt2;
            if (bool2) {
              break label721;
            }
            bool1 = bool2;
            i = paramInt2;
            if (paramKeyEvent.getRepeatCount() != 0) {
              break label721;
            }
            bool1 = bool2;
            i = paramInt2;
            if (getChildCount() <= 0) {
              break label721;
            }
            keyPressed();
          }
        }
        else
        {
          if ((this.mPopup != null) && (this.mPopup.isShowing())) {
            break label715;
          }
          if ((VersionUtils.e()) && (paramKeyEvent.hasNoModifiers()))
          {
            if (!resurrectSelectionIfNeeded()) {
              pageScroll(130);
            }
          }
          else if ((VersionUtils.e()) && (paramKeyEvent.hasModifiers(1)) && (!resurrectSelectionIfNeeded())) {
            pageScroll(33);
          }
        }
        bool1 = true;
        i = paramInt2;
        break label721;
      }
      label715:
      boolean bool1 = false;
      int i = paramInt2;
      label721:
      if (bool1) {
        return true;
      }
      if (sendToTextFilter(paramInt1, i, paramKeyEvent)) {
        return true;
      }
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2) {
            return false;
          }
          return super.onKeyMultiple(paramInt1, i, paramKeyEvent);
        }
        return super.onKeyUp(paramInt1, paramKeyEvent);
      }
      return super.onKeyDown(paramInt1, paramKeyEvent);
    }
    return false;
  }
  
  private void correctTooHigh(int paramInt)
  {
    if ((this.mFirstPosition + paramInt - 1 == this.mItemCount - 1) && (paramInt > 0))
    {
      paramInt = getChildAt(paramInt - 1).getBottom();
      int i = getBottom() - getTop() - this.mListPadding.bottom - paramInt;
      View localView = getChildAt(0);
      int j = localView.getTop();
      if ((i > 0) && ((this.mFirstPosition > 0) || (j < this.mListPadding.top)))
      {
        paramInt = i;
        if (this.mFirstPosition == 0) {
          paramInt = Math.min(i, this.mListPadding.top - j);
        }
        offsetChildrenTopAndBottomWrap(paramInt);
        if (this.mFirstPosition > 0)
        {
          fillUp(this.mFirstPosition - 1, localView.getTop() - this.mDividerHeight);
          adjustViewsUpOrDown();
        }
      }
    }
  }
  
  private void correctTooLow(int paramInt)
  {
    if ((this.mFirstPosition == 0) && (paramInt > 0))
    {
      int i = getChildAt(0).getTop();
      int k = this.mListPadding.top;
      int j = getBottom() - getTop() - this.mListPadding.bottom;
      i -= k;
      View localView = getChildAt(paramInt - 1);
      k = localView.getBottom();
      int m = this.mFirstPosition + paramInt - 1;
      if (i > 0) {
        if ((m >= this.mItemCount - 1) && (k <= j))
        {
          if (m == this.mItemCount - 1) {
            adjustViewsUpOrDown();
          }
        }
        else
        {
          paramInt = i;
          if (m == this.mItemCount - 1) {
            paramInt = Math.min(i, k - j);
          }
          offsetChildrenTopAndBottomWrap(-paramInt);
          if (m < this.mItemCount - 1)
          {
            fillDown(m + 1, localView.getBottom() + this.mDividerHeight);
            adjustViewsUpOrDown();
          }
        }
      }
    }
  }
  
  private void detachedWindow(View paramView)
  {
    try
    {
      Object localObject = ReflectionUtil.a("android.view.View", "mAttachInfo");
      ((Field)localObject).setAccessible(true);
      if (((Field)localObject).get(paramView) != null)
      {
        localObject = ReflectionUtil.a("android.view.View", "dispatchDetachedFromWindow", null);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramView, new Object[0]);
        return;
      }
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, paramView.getMessage(), paramView);
      }
    }
  }
  
  private int distanceToView(View paramView)
  {
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int i = getBottom() - getTop() - this.mListPadding.bottom;
    if (this.mTempRect.bottom < this.mListPadding.top) {
      return this.mListPadding.top - this.mTempRect.bottom;
    }
    if (this.mTempRect.top > i) {
      return this.mTempRect.top - i;
    }
    return 0;
  }
  
  private void fillAboveAndBelow(View paramView, int paramInt)
  {
    int i = this.mDividerHeight;
    if (!this.mStackFromBottom)
    {
      fillUp(paramInt - 1, paramView.getTop() - i);
      adjustViewsUpOrDown();
      fillDown(paramInt + 1, paramView.getBottom() + i);
      return;
    }
    fillDown(paramInt + 1, paramView.getBottom() + i);
    adjustViewsUpOrDown();
    fillUp(paramInt - 1, paramView.getTop() - i);
  }
  
  private View fillDown(int paramInt1, int paramInt2)
  {
    int m = getBottom() - getTop();
    int n = getQQGroupFlag();
    Object localObject2 = null;
    int i = m;
    Object localObject1 = localObject2;
    int j = paramInt1;
    int k = paramInt2;
    if ((n & 0x22) == 34)
    {
      i = m - this.mListPadding.bottom;
      k = paramInt2;
      j = paramInt1;
    }
    for (localObject1 = localObject2; (k < i) && (j < this.mItemCount); localObject1 = localObject2)
    {
      boolean bool;
      if (j == this.mSelectedPosition) {
        bool = true;
      } else {
        bool = false;
      }
      View localView = makeAndAddView(j, k, true, this.mListPadding.left, bool);
      localObject2 = localObject1;
      if (localView != null)
      {
        paramInt1 = localView.getBottom() + this.mDividerHeight;
        localObject2 = localObject1;
        k = paramInt1;
        if (bool)
        {
          localObject2 = localView;
          k = paramInt1;
        }
      }
      j += 1;
    }
    return localObject1;
  }
  
  private View fillFromMiddle(int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    int i = reconcileSelectedPosition();
    View localView = makeAndAddView(i, paramInt1, true, this.mListPadding.left, true);
    if (localView == null) {
      return localView;
    }
    this.mFirstPosition = i;
    paramInt1 = localView.getMeasuredHeight();
    if (paramInt1 <= paramInt2) {
      localView.offsetTopAndBottom((paramInt2 - paramInt1) / 2);
    }
    fillAboveAndBelow(localView, i);
    if (!this.mStackFromBottom)
    {
      correctTooHigh(getChildCount());
      return localView;
    }
    correctTooLow(getChildCount());
    return localView;
  }
  
  private View fillFromSelection(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getVerticalFadingEdgeLength();
    int i = this.mSelectedPosition;
    paramInt2 = getTopSelectionPixel(paramInt2, j, i);
    paramInt3 = getBottomSelectionPixel(paramInt3, j, i);
    View localView = makeAndAddView(i, paramInt1, true, this.mListPadding.left, true);
    if (localView == null) {
      return localView;
    }
    if (localView.getBottom() > paramInt3) {
      localView.offsetTopAndBottom(-Math.min(localView.getTop() - paramInt2, localView.getBottom() - paramInt3));
    } else if (localView.getTop() < paramInt2) {
      localView.offsetTopAndBottom(Math.min(paramInt2 - localView.getTop(), paramInt3 - localView.getBottom()));
    }
    fillAboveAndBelow(localView, i);
    if (!this.mStackFromBottom)
    {
      correctTooHigh(getChildCount());
      return localView;
    }
    correctTooLow(getChildCount());
    return localView;
  }
  
  private View fillFromTop(int paramInt)
  {
    this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
    this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
    if (this.mFirstPosition < 0) {
      this.mFirstPosition = 0;
    }
    return fillDown(this.mFirstPosition, paramInt);
  }
  
  private View fillSpecific(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 == this.mSelectedPosition) {
      bool = true;
    } else {
      bool = false;
    }
    View localView3 = makeAndAddView(paramInt1, paramInt2, true, this.mListPadding.left, bool);
    if (localView3 == null) {
      return localView3;
    }
    this.mFirstPosition = paramInt1;
    paramInt2 = this.mDividerHeight;
    Object localObject2;
    Object localObject1;
    if (!this.mStackFromBottom)
    {
      localObject2 = fillUp(paramInt1 - 1, localView3.getTop() - paramInt2);
      adjustViewsUpOrDown();
      localObject1 = fillDown(paramInt1 + 1, localView3.getBottom() + paramInt2);
      paramInt1 = getChildCount();
      if (paramInt1 > 0) {
        correctTooHigh(paramInt1);
      }
    }
    else
    {
      View localView1 = fillDown(paramInt1 + 1, localView3.getBottom() + paramInt2);
      adjustViewsUpOrDown();
      View localView2 = fillUp(paramInt1 - 1, localView3.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localObject1 = localView1;
      localObject2 = localView2;
      if (paramInt1 > 0)
      {
        correctTooLow(paramInt1);
        localObject2 = localView2;
        localObject1 = localView1;
      }
    }
    if (bool) {
      return localView3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  private View fillSpecificBottom(int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramInt1 == this.mSelectedPosition) {
      bool = true;
    } else {
      bool = false;
    }
    View localView3 = makeAndAddView(paramInt1, paramInt2, false, this.mListPadding.left, bool);
    if (localView3 == null) {
      return localView3;
    }
    this.mFirstPosition = paramInt1;
    paramInt2 = this.mDividerHeight;
    Object localObject2;
    Object localObject1;
    if (!this.mStackFromBottom)
    {
      localObject2 = fillUp(paramInt1 - 1, localView3.getTop() - paramInt2);
      adjustViewsUpOrDown();
      localObject1 = fillDown(paramInt1 + 1, localView3.getBottom() + paramInt2);
      paramInt1 = getChildCount();
      if (paramInt1 > 0) {
        correctTooHigh(paramInt1);
      }
    }
    else
    {
      View localView1 = fillDown(paramInt1 + 1, localView3.getBottom() + paramInt2);
      adjustViewsUpOrDown();
      View localView2 = fillUp(paramInt1 - 1, localView3.getTop() - paramInt2);
      paramInt1 = getChildCount();
      localObject1 = localView1;
      localObject2 = localView2;
      if (paramInt1 > 0)
      {
        correctTooLow(paramInt1);
        localObject2 = localView2;
        localObject1 = localView1;
      }
    }
    if (bool) {
      return localView3;
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  private View fillUp(int paramInt1, int paramInt2)
  {
    int i = getQQGroupFlag();
    Object localObject = null;
    if ((i & 0x22) == 34) {
      i = this.mListPadding.top;
    } else {
      i = 0;
    }
    while ((paramInt2 > i) && (paramInt1 >= 0))
    {
      boolean bool;
      if (paramInt1 == this.mSelectedPosition) {
        bool = true;
      } else {
        bool = false;
      }
      View localView = makeAndAddView(paramInt1, paramInt2, false, this.mListPadding.left, bool);
      if (localView != null)
      {
        int j = localView.getTop() - this.mDividerHeight;
        paramInt2 = j;
        if (bool)
        {
          localObject = localView;
          paramInt2 = j;
        }
      }
      else
      {
        QLog.e("XListView", 1, "fillUp childis null");
      }
      paramInt1 -= 1;
    }
    this.mFirstPosition = (paramInt1 + 1);
    return localObject;
  }
  
  private int getArrowScrollPreviewLength()
  {
    return Math.max(2, getVerticalFadingEdgeLength());
  }
  
  private int getBottomSelectionPixel(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt3 != this.mItemCount - 1) {
      i = paramInt1 - paramInt2;
    }
    return i;
  }
  
  private int getTopSelectionPixel(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt3 > 0) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  private boolean handleHorizontalFocusWithinListItem(int paramInt)
  {
    if ((paramInt != 17) && (paramInt != 66)) {
      throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }
    int i = getChildCount();
    if ((this.mItemsCanFocus) && (i > 0) && (this.mSelectedPosition != -1))
    {
      View localView2 = getSelectedView();
      if ((localView2 != null) && (localView2.hasFocus()) && ((localView2 instanceof ViewGroup)))
      {
        View localView1 = localView2.findFocus();
        localView2 = FocusFinder.getInstance().findNextFocus((ViewGroup)localView2, localView1, paramInt);
        if (localView2 != null)
        {
          localView1.getFocusedRect(this.mTempRect);
          offsetDescendantRectToMyCoords(localView1, this.mTempRect);
          offsetRectIntoDescendantCoords(localView2, this.mTempRect);
          if (localView2.requestFocus(paramInt, this.mTempRect)) {
            return true;
          }
        }
        localView1 = FocusFinder.getInstance().findNextFocus((ViewGroup)getRootView(), localView1, paramInt);
        if (localView1 != null) {
          return isViewAncestorOf(localView1, this);
        }
      }
    }
    return false;
  }
  
  private void handleNewSelectionChange(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 != -1)
    {
      int i = this.mSelectedPosition - this.mFirstPosition;
      paramInt2 -= this.mFirstPosition;
      boolean bool2 = true;
      View localView1;
      View localView2;
      if (paramInt1 == 33)
      {
        localView1 = getChildAt(paramInt2);
        paramInt1 = i;
        j = 1;
        i = paramInt2;
        paramInt2 = j;
        localView2 = paramView;
      }
      else
      {
        localView2 = getChildAt(paramInt2);
        paramInt1 = paramInt2;
        paramInt2 = 0;
        localView1 = paramView;
      }
      int j = getChildCount();
      if (localView1 != null)
      {
        boolean bool1;
        if ((!paramBoolean) && (paramInt2 != 0)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView1.setSelected(bool1);
        measureAndAdjustDown(localView1, i, j);
      }
      if (localView2 != null)
      {
        if ((!paramBoolean) && (paramInt2 == 0)) {
          paramBoolean = bool2;
        } else {
          paramBoolean = false;
        }
        localView2.setSelected(paramBoolean);
        measureAndAdjustDown(localView2, paramInt1, j);
      }
      return;
    }
    throw new IllegalArgumentException("newSelectedPosition needs to be valid");
  }
  
  private void invalidateWithoutNotiyParent(Rect paramRect)
  {
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(localField.getInt(this) | 0x80000000));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException.getMessage(), localException);
      }
      postInvalidate(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
  }
  
  private boolean isViewAncestorOf(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (isViewAncestorOf((View)paramView1, paramView2));
  }
  
  private int lookForSelectablePositionOnScreen(int paramInt)
  {
    int j = this.mFirstPosition;
    ListAdapter localListAdapter;
    if (paramInt == 130)
    {
      if (this.mSelectedPosition != -1) {
        i = this.mSelectedPosition + 1;
      } else {
        i = j;
      }
      if (i >= this.mAdapter.getCount()) {
        return -1;
      }
      paramInt = i;
      if (i < j) {
        paramInt = j;
      }
      i = getLastVisiblePosition();
      localListAdapter = getAdapter();
      while (paramInt <= i)
      {
        if ((localListAdapter.isEnabled(paramInt)) && (getChildAt(paramInt - j).getVisibility() == 0)) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    int i = getChildCount() + j - 1;
    if (this.mSelectedPosition != -1) {
      paramInt = this.mSelectedPosition;
    } else {
      paramInt = getChildCount() + j;
    }
    paramInt -= 1;
    if (paramInt >= 0)
    {
      if (paramInt >= this.mAdapter.getCount()) {
        return -1;
      }
      if (paramInt > i) {
        paramInt = i;
      }
      localListAdapter = getAdapter();
      while (paramInt >= j)
      {
        if ((localListAdapter.isEnabled(paramInt)) && (getChildAt(paramInt - j).getVisibility() == 0)) {
          return paramInt;
        }
        paramInt -= 1;
      }
    }
    return -1;
  }
  
  private View makeAndAddView(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    traceBegin("ListView.makeAndAddView");
    try
    {
      if (!this.mDataChanged)
      {
        localView = this.mRecycler.getActiveView(paramInt1);
        if (localView != null)
        {
          setupChild(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
          return localView;
        }
      }
      View localView = obtainView(paramInt1, this.mIsScrap);
      setupChild(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.mIsScrap[0]);
      return localView;
    }
    finally
    {
      traceEnd();
    }
  }
  
  private void measureAndAdjustDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramView.getHeight();
    measureItem(paramView);
    if (paramView.getMeasuredHeight() != i)
    {
      relayoutMeasuredItem(paramView);
      int j = paramView.getMeasuredHeight();
      for (;;)
      {
        paramInt1 += 1;
        if (paramInt1 >= paramInt2) {
          break;
        }
        getChildAt(paramInt1).offsetTopAndBottom(j - i);
      }
    }
  }
  
  private void measureItem(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(j, i);
  }
  
  private View moveSelection(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getVerticalFadingEdgeLength();
    int k = this.mSelectedPosition;
    int i = getTopSelectionPixel(paramInt2, j, k);
    j = getBottomSelectionPixel(paramInt2, j, k);
    int m;
    if (paramInt1 > 0)
    {
      paramView1 = makeAndAddView(k - 1, paramView1.getTop(), true, this.mListPadding.left, false);
      paramInt1 = this.mDividerHeight;
      paramView2 = makeAndAddView(k, paramView1.getBottom() + paramInt1, true, this.mListPadding.left, true);
      if (paramView2.getBottom() > j)
      {
        k = paramView2.getTop();
        m = paramView2.getBottom();
        paramInt2 = (paramInt3 - paramInt2) / 2;
        paramInt2 = -Math.min(Math.min(k - i, m - j), paramInt2);
        paramView1.offsetTopAndBottom(paramInt2);
        paramView2.offsetTopAndBottom(paramInt2);
      }
      if (!this.mStackFromBottom)
      {
        fillUp(this.mSelectedPosition - 2, paramView2.getTop() - paramInt1);
        adjustViewsUpOrDown();
        fillDown(this.mSelectedPosition + 1, paramView2.getBottom() + paramInt1);
        return paramView2;
      }
      fillDown(this.mSelectedPosition + 1, paramView2.getBottom() + paramInt1);
      adjustViewsUpOrDown();
      fillUp(this.mSelectedPosition - 2, paramView2.getTop() - paramInt1);
      return paramView2;
    }
    if (paramInt1 < 0)
    {
      if (paramView2 != null) {
        paramView1 = makeAndAddView(k, paramView2.getTop(), true, this.mListPadding.left, true);
      } else {
        paramView1 = makeAndAddView(k, paramView1.getTop(), false, this.mListPadding.left, true);
      }
      if (paramView1.getTop() < i)
      {
        paramInt1 = paramView1.getTop();
        m = paramView1.getBottom();
        paramInt2 = (paramInt3 - paramInt2) / 2;
        paramView1.offsetTopAndBottom(Math.min(Math.min(i - paramInt1, j - m), paramInt2));
      }
      fillAboveAndBelow(paramView1, k);
      return paramView1;
    }
    paramInt1 = paramView1.getTop();
    paramView1 = makeAndAddView(k, paramInt1, true, this.mListPadding.left, true);
    if ((paramInt1 < paramInt2) && (paramView1.getBottom() < paramInt2 + 20)) {
      paramView1.offsetTopAndBottom(paramInt2 - paramView1.getTop());
    }
    fillAboveAndBelow(paramView1, k);
    return paramView1;
  }
  
  private int positionOfNewFocus(View paramView)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (isViewAncestorOf(paramView, getChildAt(i))) {
        return this.mFirstPosition + i;
      }
      i += 1;
    }
    paramView = new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    for (;;)
    {
      throw paramView;
    }
  }
  
  private void relayoutMeasuredItem(View paramView)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    int k = this.mListPadding.left;
    int m = paramView.getTop();
    paramView.layout(k, m, i + k, j + m);
  }
  
  private void removeFixedViewInfo(View paramView, ArrayList<ListView.FixedViewInfo> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((ListView.FixedViewInfo)paramArrayList.get(i)).view == paramView)
      {
        paramArrayList.remove(i);
        return;
      }
      i += 1;
    }
  }
  
  private void scrollListItemsBy(int paramInt)
  {
    offsetChildrenTopAndBottomWrap(paramInt);
    int i = getHeight() - this.mListPadding.bottom;
    int j = this.mListPadding.top;
    AbsListView.RecycleBin localRecycleBin = this.mRecycler;
    if (paramInt < 0)
    {
      paramInt = getChildCount();
      localView = getChildAt(paramInt - 1);
      while (localView.getBottom() < i)
      {
        int k = this.mFirstPosition + paramInt - 1;
        if (k >= this.mItemCount - 1) {
          break;
        }
        localView = addViewBelow(localView, k);
        paramInt += 1;
      }
      if (localView.getBottom() < i) {
        offsetChildrenTopAndBottomWrap(i - localView.getBottom());
      }
      localView = getChildAt(0);
      while (localView.getBottom() < j)
      {
        if (localRecycleBin.shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))
        {
          detachViewFromParent(localView);
          localRecycleBin.addScrapView(localView, this.mFirstPosition);
        }
        else
        {
          removeViewInLayout(localView);
        }
        localView = getChildAt(0);
        this.mFirstPosition += 1;
      }
    }
    View localView = getChildAt(0);
    while ((localView.getTop() > j) && (this.mFirstPosition > 0))
    {
      localView = addViewAbove(localView, this.mFirstPosition);
      this.mFirstPosition -= 1;
    }
    if (localView.getTop() > j) {
      offsetChildrenTopAndBottomWrap(j - localView.getTop());
    }
    paramInt = getChildCount() - 1;
    for (localView = getChildAt(paramInt); localView.getTop() > i; localView = getChildAt(paramInt))
    {
      if (localRecycleBin.shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))
      {
        detachViewFromParent(localView);
        localRecycleBin.addScrapView(localView, this.mFirstPosition + paramInt);
      }
      else
      {
        removeViewInLayout(localView);
      }
      paramInt -= 1;
    }
  }
  
  @TargetApi(11)
  private void setupChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1) {
      i = -1;
    } else {
      i = 0;
    }
    setupChild(paramView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, i);
  }
  
  @TargetApi(11)
  private void setupChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    traceBegin("ListView.setupChild");
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, "ListView setupChild view is null");
      }
      setStatisticCollector();
      traceEnd();
      return;
    }
    int j;
    label67:
    int i;
    boolean bool;
    label98:
    int k;
    if (paramBoolean2)
    {
      try
      {
        if (!shouldShowSelector()) {
          break label629;
        }
        paramBoolean2 = true;
        if (paramBoolean2 == paramView.isSelected()) {
          break label635;
        }
        j = 1;
        i = this.mTouchMode;
        if ((i <= 0) || (i >= 3) || (this.mMotionPosition != paramInt1)) {
          break label641;
        }
        bool = true;
        if (bool == paramView.isPressed()) {
          break label647;
        }
        k = 1;
        label113:
        if ((!paramBoolean3) || (j != 0)) {
          break label659;
        }
        if (!paramView.isLayoutRequested()) {
          break label653;
        }
      }
      catch (NullPointerException paramView)
      {
        label133:
        AbsListView.LayoutParams localLayoutParams2;
        AbsListView.LayoutParams localLayoutParams1;
        break label617;
      }
      localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      }
      localLayoutParams1.viewType = this.mAdapter.getItemViewType(paramInt1);
      if (((paramBoolean3) && (!localLayoutParams1.forceAdd)) || ((localLayoutParams1.recycledHeaderFooter) && (localLayoutParams1.viewType == -2)))
      {
        attachViewToParent(paramView, paramInt4, localLayoutParams1);
      }
      else
      {
        localLayoutParams1.forceAdd = false;
        if (localLayoutParams1.viewType == -2) {
          localLayoutParams1.recycledHeaderFooter = true;
        }
        addViewInLayout(paramView, paramInt4, localLayoutParams1, true);
      }
      if (j != 0) {
        paramView.setSelected(paramBoolean2);
      }
      if (k != 0) {
        paramView.setPressed(bool);
      }
      if ((this.mChoiceMode != 0) && (this.mCheckStates != null)) {
        if ((paramView instanceof Checkable)) {
          ((Checkable)paramView).setChecked(this.mCheckStates.get(paramInt1));
        } else if ((getContext().getApplicationInfo().targetSdkVersion >= 11) && (VersionUtils.e())) {
          paramView.setActivated(this.mCheckStates.get(paramInt1));
        }
      }
      if (i != 0)
      {
        j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, localLayoutParams1.width);
        paramInt4 = localLayoutParams1.height;
        if (paramInt4 > 0) {
          paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
        } else {
          paramInt4 = getDefaultChildHeightSpec(paramView, paramInt4);
        }
        traceBegin("ListView.childMeasure");
        try
        {
          paramView.measure(j, paramInt4);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("XListView", 2, localException, new Object[0]);
          }
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("XListView", 2, localStringIndexOutOfBoundsException, new Object[0]);
          }
        }
        traceEnd();
      }
      else
      {
        cleanupLayoutState(paramView);
      }
      paramInt4 = paramView.getMeasuredWidth();
      j = paramView.getMeasuredHeight();
      if (!paramBoolean1) {
        break label665;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        traceBegin("ListView.childLayout");
        paramView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, j + paramInt2);
        traceEnd();
      }
      else
      {
        paramView.offsetLeftAndRight(paramInt3 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt2 - paramView.getTop());
      }
      if ((this.mCachingStarted) && (!paramView.isDrawingCacheEnabled())) {
        paramView.setDrawingCacheEnabled(true);
      }
      if ((VersionUtils.e()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).scrappedFromPosition != paramInt1))
      {
        paramView.jumpDrawablesToCurrentState();
        break label621;
        label617:
        setStatisticCollector();
      }
      label621:
      traceEnd();
      return;
      label629:
      paramBoolean2 = false;
      break;
      label635:
      j = 0;
      break label67;
      label641:
      bool = false;
      break label98;
      label647:
      k = 0;
      break label113;
      label653:
      i = 0;
      break label133;
      label659:
      i = 1;
      break label133;
      label665:
      paramInt2 -= j;
    }
  }
  
  private boolean showingBottomFadingEdge()
  {
    int i = getChildCount();
    int j = getChildAt(i - 1).getBottom();
    int k = this.mFirstPosition;
    boolean bool = true;
    int m = getScrollY();
    int n = getHeight();
    int i1 = this.mListPadding.bottom;
    if (k + i - 1 >= this.mItemCount - 1)
    {
      if (j < m + n - i1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean showingTopFadingEdge()
  {
    int i = getScrollY();
    int j = this.mListPadding.top;
    int k = this.mFirstPosition;
    boolean bool = false;
    if ((k > 0) || (getChildAt(0).getTop() > i + j)) {
      bool = true;
    }
    return bool;
  }
  
  private void stayOnTheTop()
  {
    if ((this.mStackFromBottom) && (this.mFirstPosition == 0) && (getChildCount() > 0))
    {
      int i = getChildAt(0).getTop() - this.mListPadding.top;
      if (i > 0) {
        offsetChildrenTopAndBottomWrap(-i);
      }
    }
  }
  
  @TargetApi(11)
  private int updateChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    int i = paramView.getHeight();
    int j = ((AbsListView.LayoutParams)paramView.getLayoutParams()).viewType;
    int k = this.mAdapter.getItemViewType(paramInt1);
    View localView;
    if (j == k) {
      localView = this.mAdapter.getView(paramInt1, paramView, this);
    } else {
      localView = this.mAdapter.getView(paramInt1, this.mRecycler.getScrapView(paramInt1), this);
    }
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)localView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
    }
    localLayoutParams1.viewType = k;
    if (localView != paramView)
    {
      bool1 = paramView.isSelected();
      boolean bool2 = paramView.isPressed();
      this.mRecycler.addScrapView(paramView, paramInt1);
      if (this.mCacheColorHint != 0) {
        localView.setDrawingCacheBackgroundColor(this.mCacheColorHint);
      }
      detachViewFromParent(paramInt4);
      addViewInLayout(localView, paramInt4, localLayoutParams1, true);
      if (localView.isSelected() != bool1) {
        localView.setSelected(bool1);
      }
      if (localView.isPressed() != bool2) {
        localView.setPressed(bool2);
      }
      if ((this.mChoiceMode != 0) && (this.mCheckStates != null)) {
        if ((localView instanceof Checkable)) {
          ((Checkable)localView).setChecked(this.mCheckStates.get(paramInt1));
        } else if ((getContext().getApplicationInfo().targetSdkVersion >= 11) && (VersionUtils.e())) {
          localView.setActivated(this.mCheckStates.get(paramInt1));
        }
      }
    }
    boolean bool1 = localView.isLayoutRequested();
    if (bool1)
    {
      j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, localLayoutParams1.width);
      paramInt4 = localLayoutParams1.height;
      if (paramInt4 > 0) {
        paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
      } else {
        paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
      }
      localView.measure(j, paramInt4);
    }
    else
    {
      cleanupLayoutState(localView);
    }
    paramInt4 = localView.getMeasuredWidth();
    j = localView.getMeasuredHeight();
    if (!paramBoolean) {
      paramInt2 -= j;
    }
    if (bool1)
    {
      localView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, j + paramInt2);
    }
    else
    {
      localView.offsetLeftAndRight(paramInt3 - localView.getLeft());
      localView.offsetTopAndBottom(paramInt2 - localView.getTop());
    }
    if ((this.mCachingStarted) && (!localView.isDrawingCacheEnabled())) {
      localView.setDrawingCacheEnabled(true);
    }
    if ((VersionUtils.e()) && (((AbsListView.LayoutParams)localView.getLayoutParams()).scrappedFromPosition != paramInt1)) {
      localView.jumpDrawablesToCurrentState();
    }
    return localView.getHeight() - i;
  }
  
  public void addFooterView(View paramView)
  {
    addFooterView(paramView, null, true);
  }
  
  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.mFooterViewInfos.add(localFixedViewInfo);
    if ((this.mAdapter != null) && (this.mDataSetObserver != null)) {
      this.mDataSetObserver.onChanged();
    }
  }
  
  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, 1, null, true);
  }
  
  public void addHeaderView(View paramView, int paramInt)
  {
    addHeaderView(paramView, paramInt, null, true);
  }
  
  public void addHeaderView(View paramView, int paramInt, Object paramObject, boolean paramBoolean)
  {
    if ((this.mAdapter != null) && (!(this.mAdapter instanceof HeaderViewListAdapter))) {
      throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }
    if (paramView == null) {
      return;
    }
    if ((paramView.getParent() != null) && (paramView.getParent() != this) && (Log.isLoggable("XListView", 5))) {
      Log.w("XListView", "The specified child already has a parent. You must call removeView() on the child's parent first.");
    }
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    if (this.mHeaderViewLevelIndex[paramInt] > this.mHeaderViewInfos.size())
    {
      int i = paramInt;
      while (i < 3)
      {
        this.mHeaderViewLevelIndex[i] = this.mHeaderViewInfos.size();
        i += 1;
      }
    }
    this.mHeaderViewInfos.add(this.mHeaderViewLevelIndex[paramInt], localFixedViewInfo);
    while (paramInt < 3)
    {
      paramView = this.mHeaderViewLevelIndex;
      paramView[paramInt] += 1;
      paramInt += 1;
    }
    if ((this.mAdapter != null) && (this.mDataSetObserver != null)) {
      this.mDataSetObserver.onChanged();
    }
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    addHeaderView(paramView, 1, paramObject, paramBoolean);
  }
  
  boolean arrowScroll(int paramInt)
  {
    try
    {
      this.mInLayout = true;
      boolean bool = arrowScrollImpl(paramInt);
      if (bool) {
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      }
      return bool;
    }
    finally
    {
      this.mInLayout = false;
    }
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.mItemCount > 0);
  }
  
  public void clearDelAnim()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getAnimation() != null) {
        localView.clearAnimation();
      }
      i += 1;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.mCachingStarted) {
      this.mCachingActive = true;
    }
    int i2 = this.mDividerHeight;
    Object localObject3 = this.mOverScrollHeader;
    ListView.OverscrollViewContainer localOverscrollViewContainer2 = this.mOverscrollHeaderViewContainer;
    ListView.OverscrollViewContainer localOverscrollViewContainer1 = this.mOverscrollFooterView;
    Drawable localDrawable1 = this.mOverScrollFooter;
    Drawable localDrawable2 = this.mOverScrollHeaderShadow;
    int m;
    if ((localObject3 == null) && (localOverscrollViewContainer2 == null) && (localDrawable2 == null)) {
      m = 0;
    } else {
      m = 1;
    }
    int k;
    if ((localDrawable1 == null) && (localOverscrollViewContainer1 == null)) {
      k = 0;
    } else {
      k = 1;
    }
    int n;
    if ((i2 > 0) && (this.mDivider != null)) {
      n = 1;
    } else {
      n = 0;
    }
    Object localObject1;
    int i1;
    int i;
    Object localObject2;
    label267:
    int j;
    if (this.mContentBackgroundDrawable != null)
    {
      localObject1 = this.mTempRect;
      ((Rect)localObject1).top = 0;
      ((Rect)localObject1).bottom = getHeight();
      ((Rect)localObject1).left = 0;
      ((Rect)localObject1).right = getWidth();
      i1 = paramCanvas.save();
      if (getScrollY() > 0)
      {
        ((Rect)localObject1).top += getScrollY();
        ((Rect)localObject1).bottom += getScrollY();
      }
      if (this.mUseEfficientMode)
      {
        i = getChildCount();
        if (i > 0)
        {
          localObject2 = getChildAt(i - 1);
          if (localObject2 != null)
          {
            if (getLastVisiblePosition() == getCount() - 1)
            {
              i = ((View)localObject2).getTop();
              break label267;
            }
            i = ((View)localObject2).getBottom();
            break label267;
          }
        }
        i = 0;
        if (i < 0)
        {
          j = 0;
        }
        else
        {
          j = i;
          if (i > ((Rect)localObject1).bottom) {
            j = ((Rect)localObject1).bottom;
          }
        }
        paramCanvas.clipRect(0, j, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
      }
      this.mContentBackgroundDrawable.setBounds((Rect)localObject1);
      this.mContentBackgroundDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
    }
    if ((n != 0) || (m != 0) || (k != 0))
    {
      Rect localRect = this.mTempRect;
      localRect.left = getPaddingLeft();
      localRect.right = (getRight() - getLeft() - getPaddingRight());
      int i3 = getChildCount();
      int i6 = this.mHeaderViewInfos.size();
      int i4 = this.mItemCount;
      i1 = i4 - this.mFooterViewInfos.size() - 1;
      boolean bool2 = this.mHeaderDividersEnabled;
      boolean bool3 = this.mFooterDividersEnabled;
      int i5 = this.mFirstPosition;
      boolean bool4 = this.mAreAllItemsSelectable;
      localObject1 = this.mAdapter;
      boolean bool1;
      if (VersionUtils.a())
      {
        if ((isOpaque()) && (!super.isOpaque())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      else {
        bool1 = isOpaque();
      }
      if ((bool1) && (this.mDividerPaint == null) && (this.mIsCacheColorOpaque))
      {
        this.mDividerPaint = new Paint();
        this.mDividerPaint.setColor(getCacheColorHint());
      }
      localObject2 = this.mDividerPaint;
      if ((getQQGroupFlag() & 0x22) == 34) {
        i = this.mListPadding.bottom;
      } else {
        i = 0;
      }
      i = getBottom() - getTop() - i + getScrollY();
      int i7 = getScrollY();
      if ((i3 > 0) && (i7 < 0))
      {
        if (m != 0)
        {
          localRect.bottom = (this.mListPadding.top + 0 - this.mDividerHeight + this.mOverScrollHeaderTopOffset);
          localRect.top = (this.mListPadding.top + i7 + this.mOverScrollHeaderTopOffset);
          drawOverscrollHeader(paramCanvas, localOverscrollViewContainer2, localDrawable2, (Drawable)localObject3, localRect);
        }
        if (n != 0)
        {
          localRect.bottom = 0;
          localRect.top = (-i2);
          drawDivider(paramCanvas, localRect, -1);
        }
      }
      m = 0;
      if (n != 0)
      {
        j = 0;
        while (j < i3)
        {
          if ((!bool2) && (i5 + j < i6)) {}
          for (;;)
          {
            break;
            if ((bool3) || (i5 + j < i1))
            {
              n = getChildAt(j).getBottom();
              if ((n < i) && ((k == 0) || (j != i3 - 1)))
              {
                if (!bool4)
                {
                  int i8 = i5 + j;
                  localObject3 = localObject1;
                  if ((!((ListAdapter)localObject3).isEnabled(i8)) || ((j != i3 - 1) && (!((ListAdapter)localObject3).isEnabled(i8 + 1))))
                  {
                    if (!bool1) {
                      break;
                    }
                    localRect.top = n;
                    localRect.bottom = (n + i2);
                    paramCanvas.drawRect(localRect, (Paint)localObject2);
                    break;
                  }
                }
                localRect.top = n;
                localRect.bottom = (n + i2);
                drawDivider(paramCanvas, localRect, j);
              }
            }
          }
          j += 1;
        }
      }
      j = getBottom() + i7 + this.mDividerHeight;
      if ((k != 0) && (i5 + i3 == i4) && (j > getBottom()))
      {
        if (this.considerFooterWhenDrawOverScrollFooter)
        {
          localObject1 = this.mFooterViewInfos;
          i = m;
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext()) {
              i += ((ListView.FixedViewInfo)((Iterator)localObject1).next()).view.getHeight();
            }
          }
          localRect.top = (getBottom() + this.mDividerHeight - this.mListPadding.bottom - i);
          localRect.bottom = (j - this.mListPadding.bottom - i);
        }
        else
        {
          localRect.top = (getBottom() + this.mDividerHeight);
          localRect.bottom = j;
        }
        drawOverscrollFooter(paramCanvas, localOverscrollViewContainer1, localDrawable1, localRect);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (getFocusedChild() != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getAction() == 0) {
          bool1 = onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent);
        }
      }
    }
    return bool1;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    boolean bool;
    try
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
    catch (Exception paramCanvas)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, paramCanvas, new Object[0]);
      }
      bool = false;
    }
    if (this.mCachingActive) {
      this.mCachingActive = false;
    }
    return bool;
  }
  
  void drawDivider(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    Drawable localDrawable = this.mDivider;
    localDrawable.setBounds(paramRect);
    localDrawable.draw(paramCanvas);
  }
  
  void drawOverscrollFooter(Canvas paramCanvas, View paramView, Drawable paramDrawable, Rect paramRect)
  {
    paramCanvas.save();
    if (paramDrawable != null)
    {
      int i = paramDrawable.getMinimumHeight();
      paramCanvas.clipRect(paramRect);
      if (paramRect.bottom - paramRect.top < i) {
        paramRect.bottom = (paramRect.top + i);
      }
      paramDrawable.setBounds(paramRect);
      paramDrawable.draw(paramCanvas);
    }
    if (paramView != null)
    {
      checkOverscrollViewIsCompleteVisable(paramView);
      paramView.offsetTopAndBottom(paramRect.top - paramView.getTop());
      drawChild(paramCanvas, paramView, getDrawingTime());
    }
    paramCanvas.restore();
  }
  
  protected void drawOverscrollHeader(Canvas paramCanvas, View paramView, Drawable paramDrawable1, Drawable paramDrawable2, Rect paramRect)
  {
    int i = paramCanvas.save();
    int j;
    if (paramDrawable1 != null)
    {
      j = paramDrawable1.getIntrinsicHeight();
      if (j < paramRect.height())
      {
        Rect localRect = new Rect(paramRect);
        localRect.top = (localRect.top + paramRect.height() - j);
        paramDrawable1.setBounds(localRect);
      }
      else
      {
        paramDrawable1.setBounds(paramRect);
      }
      paramDrawable1.draw(paramCanvas);
    }
    if (paramDrawable2 != null)
    {
      j = paramDrawable2.getMinimumHeight();
      if (paramRect.bottom - paramRect.top < j) {
        paramRect.top = (paramRect.bottom - j);
      }
      paramDrawable2.setBounds(paramRect);
      paramDrawable2.draw(paramCanvas);
    }
    if (paramView != null)
    {
      checkOverscrollViewIsCompleteVisable(paramView);
      paramView.offsetTopAndBottom(paramRect.bottom - paramView.getBottom());
      drawChild(paramCanvas, paramView, getDrawingTime());
    }
    paramCanvas.restoreToCount(i);
  }
  
  void fillGap(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (paramBoolean)
    {
      if ((getQQGroupFlag() & 0x22) == 34) {
        i = getListPaddingTop();
      }
      if (j > 0)
      {
        i = getChildAt(j - 1).getBottom();
        i = this.mDividerHeight + i;
      }
      fillDown(this.mFirstPosition + j, i);
      correctTooHigh(getChildCount());
      return;
    }
    if ((getQQGroupFlag() & 0x22) == 34) {
      i = getListPaddingBottom();
    } else {
      i = 0;
    }
    if (j > 0) {
      i = getChildAt(0).getTop() - this.mDividerHeight;
    } else {
      i = getHeight() - i;
    }
    fillUp(this.mFirstPosition - 1, i);
    correctTooLow(getChildCount());
  }
  
  public int findHeaderViewPosition(View paramView)
  {
    int j = this.mHeaderViewInfos.size();
    int i = 0;
    while (i < j)
    {
      if (((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view == paramView) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  int findMotionRow(int paramInt)
  {
    int j = getChildCount();
    if (j > 0)
    {
      if (!this.mStackFromBottom)
      {
        i = 0;
        while (i < j)
        {
          if (paramInt <= getChildAt(i).getBottom()) {
            return this.mFirstPosition + i;
          }
          i += 1;
        }
      }
      int i = j - 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getTop()) {
          return this.mFirstPosition + i;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  boolean fullScroll(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt == 33)
    {
      if (this.mSelectedPosition != 0)
      {
        paramInt = lookForSelectablePosition(0, true);
        bool1 = bool2;
        if (paramInt < 0) {
          break label106;
        }
        this.mLayoutMode = 1;
        setSelectionInt(paramInt);
        invokeOnItemScrollListener();
        bool1 = bool2;
        break label106;
      }
    }
    else if ((paramInt == 130) && (this.mSelectedPosition < this.mItemCount - 1))
    {
      paramInt = lookForSelectablePosition(this.mItemCount - 1, true);
      bool1 = bool2;
      if (paramInt < 0) {
        break label106;
      }
      this.mLayoutMode = 3;
      setSelectionInt(paramInt);
      invokeOnItemScrollListener();
      bool1 = bool2;
      break label106;
    }
    boolean bool1 = false;
    label106:
    if ((bool1) && (!awakenScrollBars()))
    {
      awakenScrollBars();
      invalidate();
    }
    return bool1;
  }
  
  public ListAdapter getAdapter()
  {
    return this.mAdapter;
  }
  
  @Deprecated
  public long[] getCheckItemIds()
  {
    if ((this.mAdapter != null) && (this.mAdapter.hasStableIds())) {
      return getCheckedItemIds();
    }
    if ((this.mChoiceMode != 0) && (this.mCheckStates != null) && (this.mAdapter != null))
    {
      Object localObject = this.mCheckStates;
      int m = ((SparseBooleanArray)localObject).size();
      long[] arrayOfLong = new long[m];
      ListAdapter localListAdapter = this.mAdapter;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (((SparseBooleanArray)localObject).valueAt(i))
        {
          arrayOfLong[j] = localListAdapter.getItemId(((SparseBooleanArray)localObject).keyAt(i));
          k = j + 1;
        }
        i += 1;
      }
      if (j == m) {
        return arrayOfLong;
      }
      localObject = new long[j];
      System.arraycopy(arrayOfLong, 0, localObject, 0, j);
      return localObject;
    }
    return new long[0];
  }
  
  protected int getDefaultChildHeightSpec(View paramView, int paramInt)
  {
    return View.MeasureSpec.makeMeasureSpec(0, 0);
  }
  
  public long getDelAnimationDuration()
  {
    long l = this.delAnimDuration;
    if (l > 0L) {
      return l;
    }
    return 350L;
  }
  
  public Drawable getDivider()
  {
    return this.mDivider;
  }
  
  public int getDividerHeight()
  {
    return this.mDividerHeight;
  }
  
  public int getFooterViewsCount()
  {
    return this.mFooterViewInfos.size();
  }
  
  public int getHeaderViewsCount()
  {
    return this.mHeaderViewInfos.size();
  }
  
  public int getHeaderViewsCount(int paramInt)
  {
    if (paramInt == 0) {
      return this.mHeaderViewLevelIndex[0];
    }
    int[] arrayOfInt = this.mHeaderViewLevelIndex;
    return arrayOfInt[paramInt] - arrayOfInt[(paramInt - 1)];
  }
  
  public boolean getItemsCanFocus()
  {
    return this.mItemsCanFocus;
  }
  
  public int getListViewScrollY()
  {
    int i = 0;
    int j = 0;
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int k = getFirstVisiblePosition();
    if (k >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      i = j;
      while (localIterator.hasNext()) {
        i += ((ListView.FixedViewInfo)localIterator.next()).view.getHeight();
      }
      return i + (-localView.getTop() + (k - this.mHeaderViewInfos.size()) * localView.getHeight());
    }
    j = 0;
    while (i < k)
    {
      j += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view.getHeight();
      i += 1;
    }
    return -localView.getTop() + j;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)((getBottom() - getTop()) * 0.33F);
  }
  
  public int getOverScrollFooterHeight()
  {
    if (this.mOverScrollFooterHeight == 0)
    {
      ListView.OverscrollViewContainer localOverscrollViewContainer = this.mOverscrollFooterView;
      if (localOverscrollViewContainer != null) {
        return localOverscrollViewContainer.getHeight();
      }
    }
    return this.mOverScrollFooterHeight;
  }
  
  public View getOverScrollFooterView()
  {
    return this.mOverscrollFooterView;
  }
  
  public View getOverScrollHeaderView()
  {
    return this.mOverscrollHeaderViewContainer;
  }
  
  public int getOverScrollHeight()
  {
    if (this.mOverScrollHeight == 0)
    {
      ListView.OverscrollViewContainer localOverscrollViewContainer = this.mOverscrollHeaderViewContainer;
      if (localOverscrollViewContainer != null) {
        return localOverscrollViewContainer.getHeight();
      }
    }
    return this.mOverScrollHeight;
  }
  
  public Drawable getOverscrollFooter()
  {
    return this.mOverScrollFooter;
  }
  
  public Drawable getOverscrollHeader()
  {
    return this.mOverScrollHeader;
  }
  
  protected int getSpringbackOffset()
  {
    int k = getScrollY();
    Object localObject = this.mOverscrollHeaderViewContainer;
    int j = 0;
    int i = 0;
    boolean bool;
    if ((localObject != null) && (k < 0))
    {
      if (k <= -getOverScrollHeight())
      {
        if (this.mOverscrollHeadState == 2)
        {
          localObject = this.mOverScrollViewListener;
          if (localObject != null) {
            bool = ((OverScrollViewListener)localObject).onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
          } else {
            bool = false;
          }
          this.mOverscrollHeadState = 3;
        }
        else
        {
          bool = false;
        }
        if (bool)
        {
          if (this.mOverscrollHeaderViewContainer != null) {
            i = -getOverScrollHeight();
          }
          return i;
        }
        this.mOverscrollHeadState = 0;
        return 0;
      }
      if (this.mOverscrollHeadState < 2)
      {
        localObject = this.mOverScrollViewListener;
        if (localObject != null) {
          ((OverScrollViewListener)localObject).onViewNotCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        }
        this.mOverscrollHeadState = 0;
      }
      return 0;
    }
    if ((this.mOverscrollFooterView != null) && (k > 0))
    {
      if (k >= getOverScrollFooterHeight())
      {
        if (this.mOverscrollHeadState == 2)
        {
          localObject = this.mOverScrollViewListener;
          if (localObject != null) {
            bool = ((OverScrollViewListener)localObject).onViewCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
          } else {
            bool = false;
          }
          this.mOverscrollHeadState = 3;
        }
        else
        {
          bool = false;
        }
        if (bool)
        {
          i = j;
          if (this.mOverscrollFooterView != null) {
            i = getOverScrollFooterHeight();
          }
          return i;
        }
        this.mOverscrollHeadState = 0;
        return 0;
      }
      if (this.mOverscrollHeadState < 2)
      {
        localObject = this.mOverScrollViewListener;
        if (localObject != null) {
          ((OverScrollViewListener)localObject).onViewNotCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
        }
        this.mOverscrollHeadState = 0;
      }
    }
    return 0;
  }
  
  public void hideOverScrollHeaderView()
  {
    if (getScrollY() < 0)
    {
      abordFling();
      if (!this.mStackFromBottom)
      {
        setSelectionFromTop(this.mFirstPosition, this.mListPadding.top - getScrollY());
      }
      else
      {
        this.mLayoutMode = 100;
        View localView = getChildAt(0);
        int i;
        if (localView == null) {
          i = 0;
        } else {
          i = this.mLayoutHeight - localView.getBottom() - this.mListPadding.bottom;
        }
        setSelectionFromBottom(this.mFirstPosition, i + getScrollY());
      }
      onScrollChanged(0, 0, 0, getScrollY());
      setScrollY(0);
    }
    this.mOverscrollHeadState = 0;
  }
  
  public void hideOverScrollerFooterView()
  {
    if (getScrollY() > 0)
    {
      abordFling();
      int i = getChildCount();
      if ((i > 0) && (this.mItemCount > 0) && (this.mFirstPosition >= 0))
      {
        int j = this.mFirstPosition + i - 1;
        if (this.mStackFromBottom)
        {
          this.mLayoutMode = 100;
          Object localObject = this.mFooterViewInfos;
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            localObject = this.mFooterViewInfos.iterator();
            i = 0;
            while (((Iterator)localObject).hasNext()) {
              i += ((ListView.FixedViewInfo)((Iterator)localObject).next()).view.getHeight();
            }
            setSelectionFromBottom(j - this.mFooterViewInfos.size(), i);
          }
          else
          {
            setSelectionFromBottom(j, getScrollY());
          }
        }
      }
      onScrollChanged(0, 0, 0, getScrollY());
      setScrollY(0);
    }
    this.mOverscrollHeadState = 0;
  }
  
  protected void initPaddingManual() {}
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    if ((paramRect.bottom > 0) && (paramRect.top < getHeight()))
    {
      int i = getScrollY();
      if ((i < 0) && (paramRect.top + i < 0))
      {
        invalidateWithoutNotiyParent(paramRect);
        return paramArrayOfInt;
      }
      if ((i > 0) && (paramRect.bottom > getHeight() - i)) {
        invalidateWithoutNotiyParent(paramRect);
      }
    }
    return paramArrayOfInt;
  }
  
  public boolean isDirectChildHeaderOrFooter(View paramView)
  {
    ArrayList localArrayList = this.mHeaderViewInfos;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(i)).view) {
        return true;
      }
      i += 1;
    }
    localArrayList = this.mFooterViewInfos;
    j = localArrayList.size();
    i = 0;
    while (i < j)
    {
      if (paramView == ((ListView.FixedViewInfo)localArrayList.get(i)).view) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isOpaque()
  {
    return false;
  }
  
  public boolean isOverscrollFooterVisiable()
  {
    return (getScrollY() > 0) && (this.mOverscrollFooterView != null);
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    return (getScrollY() < 0) && (this.mOverscrollHeaderViewContainer != null);
  }
  
  /* Error */
  protected void layoutChildren()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   4: istore 8
    //   6: iload 8
    //   8: ifne +2571 -> 2579
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   16: ldc_w 1371
    //   19: invokestatic 838	com/tencent/widget/ListView:traceBegin	(Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 9
    //   26: iload 8
    //   28: istore 10
    //   30: aload_0
    //   31: invokespecial 1372	com/tencent/widget/AbsListView:layoutChildren	()V
    //   34: iload 8
    //   36: istore 9
    //   38: iload 8
    //   40: istore 10
    //   42: aload_0
    //   43: invokevirtual 488	com/tencent/widget/ListView:invalidate	()V
    //   46: iload 8
    //   48: istore 9
    //   50: iload 8
    //   52: istore 10
    //   54: aload_0
    //   55: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   58: ifnonnull +41 -> 99
    //   61: iload 8
    //   63: istore 9
    //   65: iload 8
    //   67: istore 10
    //   69: aload_0
    //   70: invokevirtual 1375	com/tencent/widget/ListView:resetList	()V
    //   73: iload 8
    //   75: istore 9
    //   77: iload 8
    //   79: istore 10
    //   81: aload_0
    //   82: invokevirtual 491	com/tencent/widget/ListView:invokeOnItemScrollListener	()V
    //   85: iload 8
    //   87: ifne +8 -> 95
    //   90: aload_0
    //   91: iconst_0
    //   92: putfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   95: invokestatic 850	com/tencent/widget/ListView:traceEnd	()V
    //   98: return
    //   99: iload 8
    //   101: istore 9
    //   103: iload 8
    //   105: istore 10
    //   107: aload_0
    //   108: getfield 317	com/tencent/widget/ListView:mListPadding	Landroid/graphics/Rect;
    //   111: getfield 341	android/graphics/Rect:top	I
    //   114: istore_2
    //   115: iload 8
    //   117: istore 9
    //   119: iload 8
    //   121: istore 10
    //   123: aload_0
    //   124: invokevirtual 708	com/tencent/widget/ListView:getBottom	()I
    //   127: aload_0
    //   128: invokevirtual 709	com/tencent/widget/ListView:getTop	()I
    //   131: isub
    //   132: aload_0
    //   133: getfield 317	com/tencent/widget/ListView:mListPadding	Landroid/graphics/Rect;
    //   136: getfield 350	android/graphics/Rect:bottom	I
    //   139: isub
    //   140: istore 4
    //   142: iload 8
    //   144: istore 9
    //   146: iload 8
    //   148: istore 10
    //   150: aload_0
    //   151: invokevirtual 331	com/tencent/widget/ListView:getChildCount	()I
    //   154: istore 6
    //   156: iload 8
    //   158: istore 9
    //   160: iload 8
    //   162: istore 10
    //   164: aload_0
    //   165: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   168: iload 6
    //   170: iadd
    //   171: iconst_1
    //   172: isub
    //   173: istore 5
    //   175: iload 8
    //   177: istore 9
    //   179: iload 8
    //   181: istore 10
    //   183: aload_0
    //   184: getfield 1276	com/tencent/widget/ListView:mLayoutMode	I
    //   187: istore_1
    //   188: iload_1
    //   189: iconst_1
    //   190: if_icmpeq +2416 -> 2606
    //   193: iload_1
    //   194: iconst_2
    //   195: if_icmpeq +157 -> 352
    //   198: iload_1
    //   199: iconst_3
    //   200: if_icmpeq +2406 -> 2606
    //   203: iload_1
    //   204: iconst_4
    //   205: if_icmpeq +2401 -> 2606
    //   208: iload_1
    //   209: iconst_5
    //   210: if_icmpeq +2396 -> 2606
    //   213: iload 8
    //   215: istore 9
    //   217: iload 8
    //   219: istore 10
    //   221: aload_0
    //   222: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   225: aload_0
    //   226: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   229: isub
    //   230: istore_3
    //   231: iload_3
    //   232: iflt +2363 -> 2595
    //   235: iload_3
    //   236: iload 6
    //   238: if_icmpge +2357 -> 2595
    //   241: iload 8
    //   243: istore 9
    //   245: iload 8
    //   247: istore 10
    //   249: aload_0
    //   250: iload_3
    //   251: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   254: astore 12
    //   256: goto +3 -> 259
    //   259: iload 8
    //   261: istore 9
    //   263: iload 8
    //   265: istore 10
    //   267: aload_0
    //   268: iconst_0
    //   269: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   272: astore 18
    //   274: iload 8
    //   276: istore 9
    //   278: iload 8
    //   280: istore 10
    //   282: aload_0
    //   283: iload 6
    //   285: iconst_1
    //   286: isub
    //   287: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   290: astore 17
    //   292: iload 8
    //   294: istore 9
    //   296: iload 8
    //   298: istore 10
    //   300: aload_0
    //   301: getfield 1378	com/tencent/widget/ListView:mNextSelectedPosition	I
    //   304: iflt +2297 -> 2601
    //   307: iload 8
    //   309: istore 9
    //   311: iload 8
    //   313: istore 10
    //   315: aload_0
    //   316: getfield 1378	com/tencent/widget/ListView:mNextSelectedPosition	I
    //   319: aload_0
    //   320: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   323: isub
    //   324: istore_1
    //   325: goto +3 -> 328
    //   328: iload 8
    //   330: istore 9
    //   332: iload 8
    //   334: istore 10
    //   336: aload_0
    //   337: iload_3
    //   338: iload_1
    //   339: iadd
    //   340: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   343: astore 16
    //   345: aload 12
    //   347: astore 15
    //   349: goto +49 -> 398
    //   352: iload 8
    //   354: istore 9
    //   356: iload 8
    //   358: istore 10
    //   360: aload_0
    //   361: getfield 1378	com/tencent/widget/ListView:mNextSelectedPosition	I
    //   364: aload_0
    //   365: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   368: isub
    //   369: istore_1
    //   370: iload_1
    //   371: iflt +2235 -> 2606
    //   374: iload_1
    //   375: iload 6
    //   377: if_icmpge +2229 -> 2606
    //   380: iload 8
    //   382: istore 9
    //   384: iload 8
    //   386: istore 10
    //   388: aload_0
    //   389: iload_1
    //   390: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   393: astore 12
    //   395: goto +2214 -> 2609
    //   398: iload 8
    //   400: istore 9
    //   402: iload 8
    //   404: istore 10
    //   406: aload_0
    //   407: getfield 645	com/tencent/widget/ListView:mDataChanged	Z
    //   410: istore 11
    //   412: iload 11
    //   414: ifeq +15 -> 429
    //   417: iload 8
    //   419: istore 9
    //   421: iload 8
    //   423: istore 10
    //   425: aload_0
    //   426: invokevirtual 1381	com/tencent/widget/ListView:handleDataChanged	()V
    //   429: iload 8
    //   431: istore 9
    //   433: iload 8
    //   435: istore 10
    //   437: aload_0
    //   438: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   441: ifne +41 -> 482
    //   444: iload 8
    //   446: istore 9
    //   448: iload 8
    //   450: istore 10
    //   452: aload_0
    //   453: invokevirtual 1375	com/tencent/widget/ListView:resetList	()V
    //   456: iload 8
    //   458: istore 9
    //   460: iload 8
    //   462: istore 10
    //   464: aload_0
    //   465: invokevirtual 491	com/tencent/widget/ListView:invokeOnItemScrollListener	()V
    //   468: iload 8
    //   470: ifne +8 -> 478
    //   473: aload_0
    //   474: iconst_0
    //   475: putfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   478: invokestatic 850	com/tencent/widget/ListView:traceEnd	()V
    //   481: return
    //   482: iload 8
    //   484: istore 9
    //   486: iload 8
    //   488: istore 10
    //   490: aload_0
    //   491: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   494: aload_0
    //   495: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   498: invokeinterface 822 1 0
    //   503: if_icmpeq +315 -> 818
    //   506: iload 8
    //   508: istore 9
    //   510: iload 8
    //   512: istore 10
    //   514: aload_0
    //   515: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   518: invokevirtual 525	java/lang/Object:getClass	()Ljava/lang/Class;
    //   521: astore 12
    //   523: iload 8
    //   525: istore 9
    //   527: iload 8
    //   529: istore 10
    //   531: aload_0
    //   532: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   535: instanceof 1080
    //   538: ifeq +26 -> 564
    //   541: iload 8
    //   543: istore 9
    //   545: iload 8
    //   547: istore 10
    //   549: aload_0
    //   550: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   553: checkcast 1080	com/tencent/widget/HeaderViewListAdapter
    //   556: invokevirtual 1384	com/tencent/widget/HeaderViewListAdapter:getWrappedAdapter	()Landroid/widget/ListAdapter;
    //   559: invokevirtual 525	java/lang/Object:getClass	()Ljava/lang/Class;
    //   562: astore 12
    //   564: iload 8
    //   566: istore 9
    //   568: iload 8
    //   570: istore 10
    //   572: new 1386	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 1387	java/lang/StringBuilder:<init>	()V
    //   579: astore 13
    //   581: iload 8
    //   583: istore 9
    //   585: iload 8
    //   587: istore 10
    //   589: aload 13
    //   591: ldc_w 1389
    //   594: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: iload 8
    //   600: istore 9
    //   602: iload 8
    //   604: istore 10
    //   606: aload 13
    //   608: aload_0
    //   609: invokevirtual 1396	com/tencent/widget/ListView:getId	()I
    //   612: invokevirtual 1399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: iload 8
    //   618: istore 9
    //   620: iload 8
    //   622: istore 10
    //   624: aload 13
    //   626: ldc_w 1401
    //   629: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: iload 8
    //   635: istore 9
    //   637: iload 8
    //   639: istore 10
    //   641: aload 13
    //   643: aload_0
    //   644: invokevirtual 525	java/lang/Object:getClass	()Ljava/lang/Class;
    //   647: invokevirtual 1404	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: iload 8
    //   653: istore 9
    //   655: iload 8
    //   657: istore 10
    //   659: aload 13
    //   661: ldc_w 1406
    //   664: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: iload 8
    //   670: istore 9
    //   672: iload 8
    //   674: istore 10
    //   676: aload 13
    //   678: aload 12
    //   680: invokevirtual 1404	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: iload 8
    //   686: istore 9
    //   688: iload 8
    //   690: istore 10
    //   692: aload 13
    //   694: ldc_w 1408
    //   697: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: iload 8
    //   703: istore 9
    //   705: iload 8
    //   707: istore 10
    //   709: aload 13
    //   711: aload_0
    //   712: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   715: invokevirtual 1399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: iload 8
    //   721: istore 9
    //   723: iload 8
    //   725: istore 10
    //   727: aload 13
    //   729: ldc_w 1410
    //   732: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: iload 8
    //   738: istore 9
    //   740: iload 8
    //   742: istore 10
    //   744: aload 13
    //   746: aload_0
    //   747: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   750: invokeinterface 822 1 0
    //   755: invokevirtual 1399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: iload 8
    //   761: istore 9
    //   763: iload 8
    //   765: istore 10
    //   767: aload 13
    //   769: ldc_w 1412
    //   772: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: iload 8
    //   778: istore 9
    //   780: iload 8
    //   782: istore 10
    //   784: aload 13
    //   786: aload_0
    //   787: getfield 639	com/tencent/widget/ListView:mAdapter	Landroid/widget/ListAdapter;
    //   790: invokevirtual 1415	java/lang/Object:toString	()Ljava/lang/String;
    //   793: invokevirtual 1393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: iload 8
    //   799: istore 9
    //   801: iload 8
    //   803: istore 10
    //   805: new 1082	java/lang/IllegalStateException
    //   808: dup
    //   809: aload 13
    //   811: invokevirtual 1416	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokespecial 1085	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   817: athrow
    //   818: iload 8
    //   820: istore 9
    //   822: iload 8
    //   824: istore 10
    //   826: aload_0
    //   827: aload_0
    //   828: getfield 1378	com/tencent/widget/ListView:mNextSelectedPosition	I
    //   831: invokevirtual 450	com/tencent/widget/ListView:setSelectedPositionInt	(I)V
    //   834: iload 8
    //   836: istore 9
    //   838: iload 8
    //   840: istore 10
    //   842: aload_0
    //   843: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   846: istore 7
    //   848: iload 8
    //   850: istore 9
    //   852: iload 8
    //   854: istore 10
    //   856: aload_0
    //   857: getfield 842	com/tencent/widget/ListView:mRecycler	Lcom/tencent/widget/AbsListView$RecycleBin;
    //   860: astore 20
    //   862: iload 11
    //   864: ifeq +52 -> 916
    //   867: iconst_0
    //   868: istore_3
    //   869: iload_3
    //   870: iload 6
    //   872: if_icmpge +1755 -> 2627
    //   875: iload 8
    //   877: istore 9
    //   879: iload 8
    //   881: istore 10
    //   883: aload_0
    //   884: iload_3
    //   885: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   888: astore 12
    //   890: iload 8
    //   892: istore 9
    //   894: iload 8
    //   896: istore 10
    //   898: aload 20
    //   900: aload 12
    //   902: iload 7
    //   904: iload_3
    //   905: iadd
    //   906: invokevirtual 911	com/tencent/widget/AbsListView$RecycleBin:addScrapView	(Landroid/view/View;I)V
    //   909: iload_3
    //   910: iconst_1
    //   911: iadd
    //   912: istore_3
    //   913: goto -44 -> 869
    //   916: iload 8
    //   918: istore 9
    //   920: iload 8
    //   922: istore 10
    //   924: aload 20
    //   926: iload 6
    //   928: iload 7
    //   930: invokevirtual 1419	com/tencent/widget/AbsListView$RecycleBin:fillActiveViews	(II)V
    //   933: iload 8
    //   935: istore 9
    //   937: iload 8
    //   939: istore 10
    //   941: aload_0
    //   942: invokevirtual 456	com/tencent/widget/ListView:getFocusedChild	()Landroid/view/View;
    //   945: astore 14
    //   947: aload 14
    //   949: ifnull +1690 -> 2639
    //   952: iload 11
    //   954: ifeq +23 -> 977
    //   957: iload 8
    //   959: istore 9
    //   961: iload 8
    //   963: istore 10
    //   965: aload_0
    //   966: aload 14
    //   968: invokevirtual 1421	com/tencent/widget/ListView:isDirectChildHeaderOrFooter	(Landroid/view/View;)Z
    //   971: ifeq +1659 -> 2630
    //   974: goto +3 -> 977
    //   977: iload 8
    //   979: istore 9
    //   981: iload 8
    //   983: istore 10
    //   985: aload_0
    //   986: invokevirtual 1422	com/tencent/widget/ListView:findFocus	()Landroid/view/View;
    //   989: astore 19
    //   991: aload 14
    //   993: astore 12
    //   995: aload 19
    //   997: astore 13
    //   999: aload 19
    //   1001: ifnull +24 -> 1025
    //   1004: iload 8
    //   1006: istore 9
    //   1008: iload 8
    //   1010: istore 10
    //   1012: aload 19
    //   1014: invokevirtual 1425	android/view/View:onStartTemporaryDetach	()V
    //   1017: aload 19
    //   1019: astore 13
    //   1021: aload 14
    //   1023: astore 12
    //   1025: iload 8
    //   1027: istore 9
    //   1029: iload 8
    //   1031: istore 10
    //   1033: aload_0
    //   1034: invokevirtual 1427	com/tencent/widget/ListView:requestFocus	()Z
    //   1037: pop
    //   1038: aload 12
    //   1040: astore 14
    //   1042: goto +3 -> 1045
    //   1045: iload 8
    //   1047: istore 9
    //   1049: iload 8
    //   1051: istore 10
    //   1053: aload_0
    //   1054: invokevirtual 1430	com/tencent/widget/ListView:detachAllViewsFromParent	()V
    //   1057: iload 8
    //   1059: istore 9
    //   1061: iload 8
    //   1063: istore 10
    //   1065: aload_0
    //   1066: getfield 1276	com/tencent/widget/ListView:mLayoutMode	I
    //   1069: istore_3
    //   1070: iload_3
    //   1071: bipush 100
    //   1073: if_icmpeq +703 -> 1776
    //   1076: iload_3
    //   1077: tableswitch	default:+1571 -> 2648, 1:+660->1737, 2:+610->1687, 3:+573->1650, 4:+548->1625, 5:+478->1555, 6:+453->1530
    //   1117: iconst_3
    //   1118: ifne +102 -> 1220
    //   1121: iload 8
    //   1123: istore 9
    //   1125: iload 8
    //   1127: istore 10
    //   1129: aload_0
    //   1130: getfield 334	com/tencent/widget/ListView:mStackFromBottom	Z
    //   1133: ifne +39 -> 1172
    //   1136: iload 8
    //   1138: istore 9
    //   1140: iload 8
    //   1142: istore 10
    //   1144: aload_0
    //   1145: aload_0
    //   1146: iconst_0
    //   1147: iconst_1
    //   1148: invokevirtual 1273	com/tencent/widget/ListView:lookForSelectablePosition	(IZ)I
    //   1151: invokevirtual 450	com/tencent/widget/ListView:setSelectedPositionInt	(I)V
    //   1154: iload 8
    //   1156: istore 9
    //   1158: iload 8
    //   1160: istore 10
    //   1162: aload_0
    //   1163: iload_2
    //   1164: invokespecial 1432	com/tencent/widget/ListView:fillFromTop	(I)Landroid/view/View;
    //   1167: astore 12
    //   1169: goto +634 -> 1803
    //   1172: iload 8
    //   1174: istore 9
    //   1176: iload 8
    //   1178: istore 10
    //   1180: aload_0
    //   1181: aload_0
    //   1182: aload_0
    //   1183: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1186: iconst_1
    //   1187: isub
    //   1188: iconst_0
    //   1189: invokevirtual 1273	com/tencent/widget/ListView:lookForSelectablePosition	(IZ)I
    //   1192: invokevirtual 450	com/tencent/widget/ListView:setSelectedPositionInt	(I)V
    //   1195: iload 8
    //   1197: istore 9
    //   1199: iload 8
    //   1201: istore 10
    //   1203: aload_0
    //   1204: aload_0
    //   1205: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1208: iconst_1
    //   1209: isub
    //   1210: iload 4
    //   1212: invokespecial 712	com/tencent/widget/ListView:fillUp	(II)Landroid/view/View;
    //   1215: astore 12
    //   1217: goto +586 -> 1803
    //   1220: iload 8
    //   1222: istore 9
    //   1224: iload 8
    //   1226: istore 10
    //   1228: aload_0
    //   1229: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   1232: iflt +76 -> 1308
    //   1235: iload 8
    //   1237: istore 9
    //   1239: iload 8
    //   1241: istore 10
    //   1243: aload_0
    //   1244: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   1247: aload_0
    //   1248: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1251: if_icmpge +57 -> 1308
    //   1254: iload 8
    //   1256: istore 9
    //   1258: iload 8
    //   1260: istore 10
    //   1262: aload_0
    //   1263: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   1266: istore_1
    //   1267: aload 15
    //   1269: ifnonnull +6 -> 1275
    //   1272: goto +17 -> 1289
    //   1275: iload 8
    //   1277: istore 9
    //   1279: iload 8
    //   1281: istore 10
    //   1283: aload 15
    //   1285: invokevirtual 312	android/view/View:getTop	()I
    //   1288: istore_2
    //   1289: iload 8
    //   1291: istore 9
    //   1293: iload 8
    //   1295: istore 10
    //   1297: aload_0
    //   1298: iload_1
    //   1299: iload_2
    //   1300: invokespecial 253	com/tencent/widget/ListView:fillSpecific	(II)Landroid/view/View;
    //   1303: astore 12
    //   1305: goto +498 -> 1803
    //   1308: iload 8
    //   1310: istore 9
    //   1312: iload 8
    //   1314: istore 10
    //   1316: aload_0
    //   1317: invokevirtual 570	com/tencent/widget/ListView:getScrollY	()I
    //   1320: ifne +18 -> 1338
    //   1323: iload 8
    //   1325: istore 9
    //   1327: iload 8
    //   1329: istore 10
    //   1331: aload_0
    //   1332: getfield 334	com/tencent/widget/ListView:mStackFromBottom	Z
    //   1335: ifeq +18 -> 1353
    //   1338: iload 8
    //   1340: istore 9
    //   1342: iload 8
    //   1344: istore 10
    //   1346: aload_0
    //   1347: invokevirtual 570	com/tencent/widget/ListView:getScrollY	()I
    //   1350: ifge +91 -> 1441
    //   1353: iload 8
    //   1355: istore 9
    //   1357: iload 8
    //   1359: istore 10
    //   1361: aload_0
    //   1362: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   1365: aload_0
    //   1366: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1369: if_icmpge +57 -> 1426
    //   1372: iload 8
    //   1374: istore 9
    //   1376: iload 8
    //   1378: istore 10
    //   1380: aload_0
    //   1381: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   1384: istore_1
    //   1385: aload 18
    //   1387: ifnonnull +6 -> 1393
    //   1390: goto +17 -> 1407
    //   1393: iload 8
    //   1395: istore 9
    //   1397: iload 8
    //   1399: istore 10
    //   1401: aload 18
    //   1403: invokevirtual 312	android/view/View:getTop	()I
    //   1406: istore_2
    //   1407: iload 8
    //   1409: istore 9
    //   1411: iload 8
    //   1413: istore 10
    //   1415: aload_0
    //   1416: iload_1
    //   1417: iload_2
    //   1418: invokespecial 253	com/tencent/widget/ListView:fillSpecific	(II)Landroid/view/View;
    //   1421: astore 12
    //   1423: goto +380 -> 1803
    //   1426: iload 8
    //   1428: istore 9
    //   1430: aload_0
    //   1431: iconst_0
    //   1432: iload_2
    //   1433: invokespecial 253	com/tencent/widget/ListView:fillSpecific	(II)Landroid/view/View;
    //   1436: astore 12
    //   1438: goto +365 -> 1803
    //   1441: iload 8
    //   1443: istore 9
    //   1445: iload 8
    //   1447: istore 10
    //   1449: iload 5
    //   1451: aload_0
    //   1452: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1455: if_icmpge +48 -> 1503
    //   1458: aload 17
    //   1460: ifnonnull +9 -> 1469
    //   1463: iload 4
    //   1465: istore_1
    //   1466: goto +17 -> 1483
    //   1469: iload 8
    //   1471: istore 9
    //   1473: iload 8
    //   1475: istore 10
    //   1477: aload 17
    //   1479: invokevirtual 327	android/view/View:getBottom	()I
    //   1482: istore_1
    //   1483: iload 8
    //   1485: istore 9
    //   1487: iload 8
    //   1489: istore 10
    //   1491: aload_0
    //   1492: iload 5
    //   1494: iload_1
    //   1495: invokespecial 257	com/tencent/widget/ListView:fillSpecificBottom	(II)Landroid/view/View;
    //   1498: astore 12
    //   1500: goto +303 -> 1803
    //   1503: iload 8
    //   1505: istore 9
    //   1507: iload 8
    //   1509: istore 10
    //   1511: aload_0
    //   1512: aload_0
    //   1513: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1516: iconst_1
    //   1517: isub
    //   1518: aload_0
    //   1519: getfield 1345	com/tencent/widget/ListView:mLayoutHeight	I
    //   1522: invokespecial 257	com/tencent/widget/ListView:fillSpecificBottom	(II)Landroid/view/View;
    //   1525: astore 12
    //   1527: goto +276 -> 1803
    //   1530: iload 8
    //   1532: istore 9
    //   1534: iload 8
    //   1536: istore 10
    //   1538: aload_0
    //   1539: aload 15
    //   1541: aload 16
    //   1543: iload_1
    //   1544: iload_2
    //   1545: iload 4
    //   1547: invokespecial 1434	com/tencent/widget/ListView:moveSelection	(Landroid/view/View;Landroid/view/View;III)Landroid/view/View;
    //   1550: astore 12
    //   1552: goto +251 -> 1803
    //   1555: iload 8
    //   1557: istore 9
    //   1559: iload 8
    //   1561: istore 10
    //   1563: aload_0
    //   1564: getfield 334	com/tencent/widget/ListView:mStackFromBottom	Z
    //   1567: ifne +28 -> 1595
    //   1570: iload 8
    //   1572: istore 9
    //   1574: iload 8
    //   1576: istore 10
    //   1578: aload_0
    //   1579: aload_0
    //   1580: getfield 1437	com/tencent/widget/ListView:mSyncPosition	I
    //   1583: aload_0
    //   1584: getfield 1440	com/tencent/widget/ListView:mSpecificTop	I
    //   1587: invokespecial 253	com/tencent/widget/ListView:fillSpecific	(II)Landroid/view/View;
    //   1590: astore 12
    //   1592: goto +211 -> 1803
    //   1595: iload 8
    //   1597: istore 9
    //   1599: iload 8
    //   1601: istore 10
    //   1603: aload_0
    //   1604: aload_0
    //   1605: getfield 1437	com/tencent/widget/ListView:mSyncPosition	I
    //   1608: aload_0
    //   1609: getfield 1345	com/tencent/widget/ListView:mLayoutHeight	I
    //   1612: aload_0
    //   1613: getfield 1443	com/tencent/widget/ListView:mSpecificBottom	I
    //   1616: isub
    //   1617: invokespecial 257	com/tencent/widget/ListView:fillSpecificBottom	(II)Landroid/view/View;
    //   1620: astore 12
    //   1622: goto +181 -> 1803
    //   1625: iload 8
    //   1627: istore 9
    //   1629: iload 8
    //   1631: istore 10
    //   1633: aload_0
    //   1634: aload_0
    //   1635: invokevirtual 733	com/tencent/widget/ListView:reconcileSelectedPosition	()I
    //   1638: aload_0
    //   1639: getfield 1440	com/tencent/widget/ListView:mSpecificTop	I
    //   1642: invokespecial 253	com/tencent/widget/ListView:fillSpecific	(II)Landroid/view/View;
    //   1645: astore 12
    //   1647: goto +156 -> 1803
    //   1650: iload 8
    //   1652: istore 9
    //   1654: iload 8
    //   1656: istore 10
    //   1658: aload_0
    //   1659: aload_0
    //   1660: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   1663: iconst_1
    //   1664: isub
    //   1665: iload 4
    //   1667: invokespecial 712	com/tencent/widget/ListView:fillUp	(II)Landroid/view/View;
    //   1670: astore 12
    //   1672: iload 8
    //   1674: istore 9
    //   1676: iload 8
    //   1678: istore 10
    //   1680: aload_0
    //   1681: invokespecial 714	com/tencent/widget/ListView:adjustViewsUpOrDown	()V
    //   1684: goto +119 -> 1803
    //   1687: aload 16
    //   1689: ifnull +28 -> 1717
    //   1692: iload 8
    //   1694: istore 9
    //   1696: iload 8
    //   1698: istore 10
    //   1700: aload_0
    //   1701: aload 16
    //   1703: invokevirtual 312	android/view/View:getTop	()I
    //   1706: iload_2
    //   1707: iload 4
    //   1709: invokespecial 1445	com/tencent/widget/ListView:fillFromSelection	(III)Landroid/view/View;
    //   1712: astore 12
    //   1714: goto +89 -> 1803
    //   1717: iload 8
    //   1719: istore 9
    //   1721: iload 8
    //   1723: istore 10
    //   1725: aload_0
    //   1726: iload_2
    //   1727: iload 4
    //   1729: invokespecial 1447	com/tencent/widget/ListView:fillFromMiddle	(II)Landroid/view/View;
    //   1732: astore 12
    //   1734: goto +69 -> 1803
    //   1737: iload 8
    //   1739: istore 9
    //   1741: aload_0
    //   1742: iconst_0
    //   1743: putfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   1746: iload 8
    //   1748: istore 9
    //   1750: iload 8
    //   1752: istore 10
    //   1754: aload_0
    //   1755: iload_2
    //   1756: invokespecial 1432	com/tencent/widget/ListView:fillFromTop	(I)Landroid/view/View;
    //   1759: astore 12
    //   1761: iload 8
    //   1763: istore 9
    //   1765: iload 8
    //   1767: istore 10
    //   1769: aload_0
    //   1770: invokespecial 714	com/tencent/widget/ListView:adjustViewsUpOrDown	()V
    //   1773: goto +30 -> 1803
    //   1776: iload 8
    //   1778: istore 9
    //   1780: iload 8
    //   1782: istore 10
    //   1784: aload_0
    //   1785: aload_0
    //   1786: invokevirtual 733	com/tencent/widget/ListView:reconcileSelectedPosition	()I
    //   1789: aload_0
    //   1790: getfield 1345	com/tencent/widget/ListView:mLayoutHeight	I
    //   1793: aload_0
    //   1794: getfield 1443	com/tencent/widget/ListView:mSpecificBottom	I
    //   1797: isub
    //   1798: invokespecial 257	com/tencent/widget/ListView:fillSpecificBottom	(II)Landroid/view/View;
    //   1801: astore 12
    //   1803: iload 8
    //   1805: istore 9
    //   1807: iload 8
    //   1809: istore 10
    //   1811: aload_0
    //   1812: invokespecial 294	com/tencent/widget/ListView:stayOnTheTop	()V
    //   1815: iload 8
    //   1817: istore 9
    //   1819: iload 8
    //   1821: istore 10
    //   1823: aload 20
    //   1825: invokevirtual 1450	com/tencent/widget/AbsListView$RecycleBin:scrapActiveViews	()V
    //   1828: aload 12
    //   1830: ifnull +217 -> 2047
    //   1833: iload 8
    //   1835: istore 9
    //   1837: iload 8
    //   1839: istore 10
    //   1841: aload_0
    //   1842: getfield 149	com/tencent/widget/ListView:mItemsCanFocus	Z
    //   1845: ifeq +167 -> 2012
    //   1848: iload 8
    //   1850: istore 9
    //   1852: iload 8
    //   1854: istore 10
    //   1856: aload_0
    //   1857: invokevirtual 1451	com/tencent/widget/ListView:hasFocus	()Z
    //   1860: ifeq +152 -> 2012
    //   1863: iload 8
    //   1865: istore 9
    //   1867: iload 8
    //   1869: istore 10
    //   1871: aload 12
    //   1873: invokevirtual 388	android/view/View:hasFocus	()Z
    //   1876: ifne +136 -> 2012
    //   1879: aload 12
    //   1881: aload 14
    //   1883: if_acmpne +24 -> 1907
    //   1886: aload 13
    //   1888: ifnull +19 -> 1907
    //   1891: iload 8
    //   1893: istore 9
    //   1895: iload 8
    //   1897: istore 10
    //   1899: aload 13
    //   1901: invokevirtual 1452	android/view/View:requestFocus	()Z
    //   1904: ifne +750 -> 2654
    //   1907: iload 8
    //   1909: istore 9
    //   1911: iload 8
    //   1913: istore 10
    //   1915: aload 12
    //   1917: invokevirtual 1452	android/view/View:requestFocus	()Z
    //   1920: ifeq +739 -> 2659
    //   1923: goto +731 -> 2654
    //   1926: iload_1
    //   1927: ifne +53 -> 1980
    //   1930: iload 8
    //   1932: istore 9
    //   1934: iload 8
    //   1936: istore 10
    //   1938: aload_0
    //   1939: invokevirtual 456	com/tencent/widget/ListView:getFocusedChild	()Landroid/view/View;
    //   1942: astore 14
    //   1944: aload 14
    //   1946: ifnull +16 -> 1962
    //   1949: iload 8
    //   1951: istore 9
    //   1953: iload 8
    //   1955: istore 10
    //   1957: aload 14
    //   1959: invokevirtual 459	android/view/View:clearFocus	()V
    //   1962: iload 8
    //   1964: istore 9
    //   1966: iload 8
    //   1968: istore 10
    //   1970: aload_0
    //   1971: iconst_m1
    //   1972: aload 12
    //   1974: invokevirtual 479	com/tencent/widget/ListView:positionSelector	(ILandroid/view/View;)V
    //   1977: goto +50 -> 2027
    //   1980: iload 8
    //   1982: istore 9
    //   1984: iload 8
    //   1986: istore 10
    //   1988: aload 12
    //   1990: iconst_0
    //   1991: invokevirtual 786	android/view/View:setSelected	(Z)V
    //   1994: iload 8
    //   1996: istore 9
    //   1998: iload 8
    //   2000: istore 10
    //   2002: aload_0
    //   2003: getfield 1455	com/tencent/widget/ListView:mSelectorRect	Landroid/graphics/Rect;
    //   2006: invokevirtual 1458	android/graphics/Rect:setEmpty	()V
    //   2009: goto +18 -> 2027
    //   2012: iload 8
    //   2014: istore 9
    //   2016: iload 8
    //   2018: istore 10
    //   2020: aload_0
    //   2021: iconst_m1
    //   2022: aload 12
    //   2024: invokevirtual 479	com/tencent/widget/ListView:positionSelector	(ILandroid/view/View;)V
    //   2027: iload 8
    //   2029: istore 9
    //   2031: iload 8
    //   2033: istore 10
    //   2035: aload_0
    //   2036: aload 12
    //   2038: invokevirtual 312	android/view/View:getTop	()I
    //   2041: putfield 482	com/tencent/widget/ListView:mSelectedTop	I
    //   2044: goto +141 -> 2185
    //   2047: iload 8
    //   2049: istore 9
    //   2051: iload 8
    //   2053: istore 10
    //   2055: aload_0
    //   2056: getfield 567	com/tencent/widget/ListView:mTouchMode	I
    //   2059: ifle +68 -> 2127
    //   2062: iload 8
    //   2064: istore 9
    //   2066: iload 8
    //   2068: istore 10
    //   2070: aload_0
    //   2071: getfield 567	com/tencent/widget/ListView:mTouchMode	I
    //   2074: iconst_3
    //   2075: if_icmpge +52 -> 2127
    //   2078: iload 8
    //   2080: istore 9
    //   2082: iload 8
    //   2084: istore 10
    //   2086: aload_0
    //   2087: aload_0
    //   2088: getfield 936	com/tencent/widget/ListView:mMotionPosition	I
    //   2091: aload_0
    //   2092: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   2095: isub
    //   2096: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   2099: astore 12
    //   2101: aload 12
    //   2103: ifnull +48 -> 2151
    //   2106: iload 8
    //   2108: istore 9
    //   2110: iload 8
    //   2112: istore 10
    //   2114: aload_0
    //   2115: aload_0
    //   2116: getfield 936	com/tencent/widget/ListView:mMotionPosition	I
    //   2119: aload 12
    //   2121: invokevirtual 479	com/tencent/widget/ListView:positionSelector	(ILandroid/view/View;)V
    //   2124: goto +27 -> 2151
    //   2127: iload 8
    //   2129: istore 9
    //   2131: aload_0
    //   2132: iconst_0
    //   2133: putfield 482	com/tencent/widget/ListView:mSelectedTop	I
    //   2136: iload 8
    //   2138: istore 9
    //   2140: iload 8
    //   2142: istore 10
    //   2144: aload_0
    //   2145: getfield 1455	com/tencent/widget/ListView:mSelectorRect	Landroid/graphics/Rect;
    //   2148: invokevirtual 1458	android/graphics/Rect:setEmpty	()V
    //   2151: iload 8
    //   2153: istore 9
    //   2155: iload 8
    //   2157: istore 10
    //   2159: aload_0
    //   2160: invokevirtual 1451	com/tencent/widget/ListView:hasFocus	()Z
    //   2163: ifeq +22 -> 2185
    //   2166: aload 13
    //   2168: ifnull +17 -> 2185
    //   2171: iload 8
    //   2173: istore 9
    //   2175: iload 8
    //   2177: istore 10
    //   2179: aload 13
    //   2181: invokevirtual 1452	android/view/View:requestFocus	()Z
    //   2184: pop
    //   2185: aload 13
    //   2187: ifnull +32 -> 2219
    //   2190: iload 8
    //   2192: istore 9
    //   2194: iload 8
    //   2196: istore 10
    //   2198: aload 13
    //   2200: invokevirtual 1462	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   2203: ifnull +16 -> 2219
    //   2206: iload 8
    //   2208: istore 9
    //   2210: iload 8
    //   2212: istore 10
    //   2214: aload 13
    //   2216: invokevirtual 1465	android/view/View:onFinishTemporaryDetach	()V
    //   2219: iload 8
    //   2221: istore 9
    //   2223: aload_0
    //   2224: iconst_0
    //   2225: putfield 1276	com/tencent/widget/ListView:mLayoutMode	I
    //   2228: iload 8
    //   2230: istore 9
    //   2232: aload_0
    //   2233: iconst_0
    //   2234: putfield 645	com/tencent/widget/ListView:mDataChanged	Z
    //   2237: iload 8
    //   2239: istore 9
    //   2241: aload_0
    //   2242: iconst_0
    //   2243: putfield 1468	com/tencent/widget/ListView:mNeedSync	Z
    //   2246: iload 8
    //   2248: istore 9
    //   2250: iload 8
    //   2252: istore 10
    //   2254: aload_0
    //   2255: aload_0
    //   2256: getfield 416	com/tencent/widget/ListView:mSelectedPosition	I
    //   2259: invokevirtual 453	com/tencent/widget/ListView:setNextSelectedPositionInt	(I)V
    //   2262: iload 8
    //   2264: istore 9
    //   2266: iload 8
    //   2268: istore 10
    //   2270: aload_0
    //   2271: invokevirtual 1471	com/tencent/widget/ListView:updateScrollIndicators	()V
    //   2274: iload 8
    //   2276: istore 9
    //   2278: iload 8
    //   2280: istore 10
    //   2282: aload_0
    //   2283: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   2286: ifle +15 -> 2301
    //   2289: iload 8
    //   2291: istore 9
    //   2293: iload 8
    //   2295: istore 10
    //   2297: aload_0
    //   2298: invokevirtual 462	com/tencent/widget/ListView:checkSelectionChanged	()V
    //   2301: iload 8
    //   2303: istore 9
    //   2305: iload 8
    //   2307: istore 10
    //   2309: aload_0
    //   2310: invokevirtual 491	com/tencent/widget/ListView:invokeOnItemScrollListener	()V
    //   2313: iload 8
    //   2315: istore 9
    //   2317: iload 8
    //   2319: istore 10
    //   2321: aload_0
    //   2322: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   2325: aload_0
    //   2326: invokevirtual 331	com/tencent/widget/ListView:getChildCount	()I
    //   2329: iadd
    //   2330: iconst_1
    //   2331: isub
    //   2332: istore_2
    //   2333: iload 8
    //   2335: istore 9
    //   2337: iload 8
    //   2339: istore 10
    //   2341: aload_0
    //   2342: getfield 1473	com/tencent/widget/ListView:mInsertAnimation	Landroid/view/animation/Animation;
    //   2345: ifnull +173 -> 2518
    //   2348: iload 8
    //   2350: istore 9
    //   2352: iload 8
    //   2354: istore 10
    //   2356: aload_0
    //   2357: getfield 165	com/tencent/widget/ListView:mAddingRows	[I
    //   2360: ifnull +158 -> 2518
    //   2363: iload 11
    //   2365: ifeq +153 -> 2518
    //   2368: iload 8
    //   2370: istore 9
    //   2372: iload 8
    //   2374: istore 10
    //   2376: aload_0
    //   2377: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   2380: ifle +138 -> 2518
    //   2383: iload 8
    //   2385: istore 9
    //   2387: iload 8
    //   2389: istore 10
    //   2391: iload_2
    //   2392: aload_0
    //   2393: getfield 353	com/tencent/widget/ListView:mItemCount	I
    //   2396: iconst_1
    //   2397: isub
    //   2398: if_icmplt +120 -> 2518
    //   2401: iload 8
    //   2403: istore 9
    //   2405: iload 8
    //   2407: istore 10
    //   2409: aload_0
    //   2410: aload_0
    //   2411: invokevirtual 331	com/tencent/widget/ListView:getChildCount	()I
    //   2414: iconst_1
    //   2415: isub
    //   2416: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   2419: invokevirtual 327	android/view/View:getBottom	()I
    //   2422: iload 4
    //   2424: if_icmpge +94 -> 2518
    //   2427: iload 8
    //   2429: istore 9
    //   2431: iload 8
    //   2433: istore 10
    //   2435: aload_0
    //   2436: getfield 165	com/tencent/widget/ListView:mAddingRows	[I
    //   2439: astore 12
    //   2441: iload 8
    //   2443: istore 9
    //   2445: iload 8
    //   2447: istore 10
    //   2449: aload 12
    //   2451: arraylength
    //   2452: istore_3
    //   2453: iconst_0
    //   2454: istore_1
    //   2455: iload_1
    //   2456: iload_3
    //   2457: if_icmpge +61 -> 2518
    //   2460: aload 12
    //   2462: iload_1
    //   2463: iaload
    //   2464: istore 4
    //   2466: iload 8
    //   2468: istore 9
    //   2470: iload 8
    //   2472: istore 10
    //   2474: iload 4
    //   2476: aload_0
    //   2477: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   2480: if_icmplt +184 -> 2664
    //   2483: iload 4
    //   2485: iload_2
    //   2486: if_icmpgt +178 -> 2664
    //   2489: iload 8
    //   2491: istore 9
    //   2493: iload 8
    //   2495: istore 10
    //   2497: aload_0
    //   2498: iload 4
    //   2500: aload_0
    //   2501: getfield 344	com/tencent/widget/ListView:mFirstPosition	I
    //   2504: isub
    //   2505: invokevirtual 338	com/tencent/widget/ListView:getChildAt	(I)Landroid/view/View;
    //   2508: aload_0
    //   2509: getfield 1473	com/tencent/widget/ListView:mInsertAnimation	Landroid/view/animation/Animation;
    //   2512: invokevirtual 1477	android/view/View:startAnimation	(Landroid/view/animation/Animation;)V
    //   2515: goto +149 -> 2664
    //   2518: iload 8
    //   2520: istore 9
    //   2522: iload 8
    //   2524: istore 10
    //   2526: aload_0
    //   2527: aconst_null
    //   2528: putfield 165	com/tencent/widget/ListView:mAddingRows	[I
    //   2531: iload 8
    //   2533: ifne +43 -> 2576
    //   2536: goto +35 -> 2571
    //   2539: astore 12
    //   2541: goto +5 -> 2546
    //   2544: astore 12
    //   2546: iload 9
    //   2548: ifne +8 -> 2556
    //   2551: aload_0
    //   2552: iconst_0
    //   2553: putfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   2556: invokestatic 850	com/tencent/widget/ListView:traceEnd	()V
    //   2559: aload 12
    //   2561: athrow
    //   2562: iload 10
    //   2564: istore 8
    //   2566: iload 8
    //   2568: ifne +8 -> 2576
    //   2571: aload_0
    //   2572: iconst_0
    //   2573: putfield 1369	com/tencent/widget/ListView:mBlockLayoutRequests	Z
    //   2576: invokestatic 850	com/tencent/widget/ListView:traceEnd	()V
    //   2579: return
    //   2580: astore 12
    //   2582: goto -20 -> 2562
    //   2585: astore 12
    //   2587: goto -25 -> 2562
    //   2590: astore 12
    //   2592: goto +59 -> 2651
    //   2595: aconst_null
    //   2596: astore 12
    //   2598: goto -2339 -> 259
    //   2601: iconst_0
    //   2602: istore_1
    //   2603: goto -2275 -> 328
    //   2606: aconst_null
    //   2607: astore 12
    //   2609: iconst_0
    //   2610: istore_1
    //   2611: aconst_null
    //   2612: astore 15
    //   2614: aconst_null
    //   2615: astore 17
    //   2617: aconst_null
    //   2618: astore 18
    //   2620: aload 12
    //   2622: astore 16
    //   2624: goto -2226 -> 398
    //   2627: goto -1694 -> 933
    //   2630: aconst_null
    //   2631: astore 12
    //   2633: aconst_null
    //   2634: astore 13
    //   2636: goto -1611 -> 1025
    //   2639: aconst_null
    //   2640: astore 14
    //   2642: aconst_null
    //   2643: astore 13
    //   2645: goto -1600 -> 1045
    //   2648: goto -1532 -> 1116
    //   2651: goto -85 -> 2566
    //   2654: iconst_1
    //   2655: istore_1
    //   2656: goto -730 -> 1926
    //   2659: iconst_0
    //   2660: istore_1
    //   2661: goto -735 -> 1926
    //   2664: iload_1
    //   2665: iconst_1
    //   2666: iadd
    //   2667: istore_1
    //   2668: goto -213 -> 2455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2671	0	this	ListView
    //   187	2481	1	i	int
    //   114	2373	2	j	int
    //   230	2228	3	k	int
    //   140	2365	4	m	int
    //   173	1320	5	n	int
    //   154	963	6	i1	int
    //   846	83	7	i2	int
    //   4	2563	8	bool1	boolean
    //   24	2523	9	bool2	boolean
    //   28	2535	10	bool3	boolean
    //   410	1954	11	bool4	boolean
    //   254	2207	12	localObject1	Object
    //   2539	1	12	localObject2	Object
    //   2544	16	12	localObject3	Object
    //   2580	1	12	localException1	Exception
    //   2585	1	12	localException2	Exception
    //   2590	1	12	localException3	Exception
    //   2596	36	12	localObject4	Object
    //   579	2065	13	localObject5	Object
    //   945	1696	14	localObject6	Object
    //   347	2266	15	localObject7	Object
    //   343	2280	16	localObject8	Object
    //   290	2326	17	localView1	View
    //   272	2347	18	localView2	View
    //   989	29	19	localView3	View
    //   860	964	20	localRecycleBin	AbsListView.RecycleBin
    // Exception table:
    //   from	to	target	type
    //   898	909	2539	finally
    //   924	933	2539	finally
    //   941	947	2539	finally
    //   965	974	2539	finally
    //   985	991	2539	finally
    //   1012	1017	2539	finally
    //   1033	1038	2539	finally
    //   1053	1057	2539	finally
    //   1065	1070	2539	finally
    //   1129	1136	2539	finally
    //   1144	1154	2539	finally
    //   1162	1169	2539	finally
    //   1180	1195	2539	finally
    //   1203	1217	2539	finally
    //   1228	1235	2539	finally
    //   1243	1254	2539	finally
    //   1262	1267	2539	finally
    //   1283	1289	2539	finally
    //   1297	1305	2539	finally
    //   1316	1323	2539	finally
    //   1331	1338	2539	finally
    //   1346	1353	2539	finally
    //   1361	1372	2539	finally
    //   1380	1385	2539	finally
    //   1401	1407	2539	finally
    //   1415	1423	2539	finally
    //   1430	1438	2539	finally
    //   1449	1458	2539	finally
    //   1477	1483	2539	finally
    //   1491	1500	2539	finally
    //   1511	1527	2539	finally
    //   1538	1552	2539	finally
    //   1563	1570	2539	finally
    //   1578	1592	2539	finally
    //   1603	1622	2539	finally
    //   1633	1647	2539	finally
    //   1658	1672	2539	finally
    //   1680	1684	2539	finally
    //   1700	1714	2539	finally
    //   1725	1734	2539	finally
    //   1741	1746	2539	finally
    //   1754	1761	2539	finally
    //   1769	1773	2539	finally
    //   1784	1803	2539	finally
    //   1811	1815	2539	finally
    //   1823	1828	2539	finally
    //   1841	1848	2539	finally
    //   1856	1863	2539	finally
    //   1871	1879	2539	finally
    //   1899	1907	2539	finally
    //   1915	1923	2539	finally
    //   1938	1944	2539	finally
    //   1957	1962	2539	finally
    //   1970	1977	2539	finally
    //   1988	1994	2539	finally
    //   2002	2009	2539	finally
    //   2020	2027	2539	finally
    //   2035	2044	2539	finally
    //   2055	2062	2539	finally
    //   2070	2078	2539	finally
    //   2086	2101	2539	finally
    //   2114	2124	2539	finally
    //   2131	2136	2539	finally
    //   2144	2151	2539	finally
    //   2159	2166	2539	finally
    //   2179	2185	2539	finally
    //   2198	2206	2539	finally
    //   2214	2219	2539	finally
    //   2223	2228	2539	finally
    //   2232	2237	2539	finally
    //   2241	2246	2539	finally
    //   2254	2262	2539	finally
    //   2270	2274	2539	finally
    //   2282	2289	2539	finally
    //   2297	2301	2539	finally
    //   2309	2313	2539	finally
    //   2321	2333	2539	finally
    //   2341	2348	2539	finally
    //   2356	2363	2539	finally
    //   2376	2383	2539	finally
    //   2391	2401	2539	finally
    //   2409	2427	2539	finally
    //   2435	2441	2539	finally
    //   2449	2453	2539	finally
    //   2474	2483	2539	finally
    //   2497	2515	2539	finally
    //   2526	2531	2539	finally
    //   30	34	2544	finally
    //   42	46	2544	finally
    //   54	61	2544	finally
    //   69	73	2544	finally
    //   81	85	2544	finally
    //   107	115	2544	finally
    //   123	142	2544	finally
    //   150	156	2544	finally
    //   164	175	2544	finally
    //   183	188	2544	finally
    //   221	231	2544	finally
    //   249	256	2544	finally
    //   267	274	2544	finally
    //   282	292	2544	finally
    //   300	307	2544	finally
    //   315	325	2544	finally
    //   336	345	2544	finally
    //   360	370	2544	finally
    //   388	395	2544	finally
    //   406	412	2544	finally
    //   425	429	2544	finally
    //   437	444	2544	finally
    //   452	456	2544	finally
    //   464	468	2544	finally
    //   490	506	2544	finally
    //   514	523	2544	finally
    //   531	541	2544	finally
    //   549	564	2544	finally
    //   572	581	2544	finally
    //   589	598	2544	finally
    //   606	616	2544	finally
    //   624	633	2544	finally
    //   641	651	2544	finally
    //   659	668	2544	finally
    //   676	684	2544	finally
    //   692	701	2544	finally
    //   709	719	2544	finally
    //   727	736	2544	finally
    //   744	759	2544	finally
    //   767	776	2544	finally
    //   784	797	2544	finally
    //   805	818	2544	finally
    //   826	834	2544	finally
    //   842	848	2544	finally
    //   856	862	2544	finally
    //   883	890	2544	finally
    //   30	34	2580	java/lang/Exception
    //   42	46	2580	java/lang/Exception
    //   54	61	2580	java/lang/Exception
    //   69	73	2580	java/lang/Exception
    //   81	85	2580	java/lang/Exception
    //   107	115	2580	java/lang/Exception
    //   123	142	2580	java/lang/Exception
    //   150	156	2580	java/lang/Exception
    //   164	175	2580	java/lang/Exception
    //   183	188	2580	java/lang/Exception
    //   221	231	2580	java/lang/Exception
    //   249	256	2580	java/lang/Exception
    //   267	274	2580	java/lang/Exception
    //   282	292	2580	java/lang/Exception
    //   300	307	2580	java/lang/Exception
    //   315	325	2580	java/lang/Exception
    //   336	345	2580	java/lang/Exception
    //   360	370	2580	java/lang/Exception
    //   388	395	2580	java/lang/Exception
    //   406	412	2580	java/lang/Exception
    //   425	429	2580	java/lang/Exception
    //   437	444	2580	java/lang/Exception
    //   452	456	2580	java/lang/Exception
    //   464	468	2580	java/lang/Exception
    //   490	506	2580	java/lang/Exception
    //   514	523	2580	java/lang/Exception
    //   531	541	2580	java/lang/Exception
    //   549	564	2580	java/lang/Exception
    //   572	581	2580	java/lang/Exception
    //   589	598	2580	java/lang/Exception
    //   606	616	2580	java/lang/Exception
    //   624	633	2580	java/lang/Exception
    //   641	651	2580	java/lang/Exception
    //   659	668	2580	java/lang/Exception
    //   676	684	2580	java/lang/Exception
    //   692	701	2580	java/lang/Exception
    //   709	719	2580	java/lang/Exception
    //   727	736	2580	java/lang/Exception
    //   744	759	2580	java/lang/Exception
    //   767	776	2580	java/lang/Exception
    //   784	797	2580	java/lang/Exception
    //   805	818	2580	java/lang/Exception
    //   826	834	2580	java/lang/Exception
    //   842	848	2580	java/lang/Exception
    //   856	862	2580	java/lang/Exception
    //   883	890	2580	java/lang/Exception
    //   898	909	2585	java/lang/Exception
    //   924	933	2585	java/lang/Exception
    //   941	947	2585	java/lang/Exception
    //   965	974	2585	java/lang/Exception
    //   985	991	2585	java/lang/Exception
    //   1012	1017	2585	java/lang/Exception
    //   1033	1038	2585	java/lang/Exception
    //   1053	1057	2585	java/lang/Exception
    //   1065	1070	2585	java/lang/Exception
    //   1129	1136	2585	java/lang/Exception
    //   1144	1154	2585	java/lang/Exception
    //   1162	1169	2585	java/lang/Exception
    //   1180	1195	2585	java/lang/Exception
    //   1203	1217	2585	java/lang/Exception
    //   1228	1235	2585	java/lang/Exception
    //   1243	1254	2585	java/lang/Exception
    //   1262	1267	2585	java/lang/Exception
    //   1283	1289	2585	java/lang/Exception
    //   1297	1305	2585	java/lang/Exception
    //   1316	1323	2585	java/lang/Exception
    //   1331	1338	2585	java/lang/Exception
    //   1346	1353	2585	java/lang/Exception
    //   1361	1372	2585	java/lang/Exception
    //   1380	1385	2585	java/lang/Exception
    //   1401	1407	2585	java/lang/Exception
    //   1415	1423	2585	java/lang/Exception
    //   1449	1458	2585	java/lang/Exception
    //   1477	1483	2585	java/lang/Exception
    //   1491	1500	2585	java/lang/Exception
    //   1511	1527	2585	java/lang/Exception
    //   1538	1552	2585	java/lang/Exception
    //   1563	1570	2585	java/lang/Exception
    //   1578	1592	2585	java/lang/Exception
    //   1603	1622	2585	java/lang/Exception
    //   1633	1647	2585	java/lang/Exception
    //   1658	1672	2585	java/lang/Exception
    //   1680	1684	2585	java/lang/Exception
    //   1700	1714	2585	java/lang/Exception
    //   1725	1734	2585	java/lang/Exception
    //   1754	1761	2585	java/lang/Exception
    //   1769	1773	2585	java/lang/Exception
    //   1784	1803	2585	java/lang/Exception
    //   1811	1815	2585	java/lang/Exception
    //   1823	1828	2585	java/lang/Exception
    //   1841	1848	2585	java/lang/Exception
    //   1856	1863	2585	java/lang/Exception
    //   1871	1879	2585	java/lang/Exception
    //   1899	1907	2585	java/lang/Exception
    //   1915	1923	2585	java/lang/Exception
    //   1938	1944	2585	java/lang/Exception
    //   1957	1962	2585	java/lang/Exception
    //   1970	1977	2585	java/lang/Exception
    //   1988	1994	2585	java/lang/Exception
    //   2002	2009	2585	java/lang/Exception
    //   2020	2027	2585	java/lang/Exception
    //   2035	2044	2585	java/lang/Exception
    //   2055	2062	2585	java/lang/Exception
    //   2070	2078	2585	java/lang/Exception
    //   2086	2101	2585	java/lang/Exception
    //   2114	2124	2585	java/lang/Exception
    //   2144	2151	2585	java/lang/Exception
    //   2159	2166	2585	java/lang/Exception
    //   2179	2185	2585	java/lang/Exception
    //   2198	2206	2585	java/lang/Exception
    //   2214	2219	2585	java/lang/Exception
    //   2254	2262	2585	java/lang/Exception
    //   2270	2274	2585	java/lang/Exception
    //   2282	2289	2585	java/lang/Exception
    //   2297	2301	2585	java/lang/Exception
    //   2309	2313	2585	java/lang/Exception
    //   2321	2333	2585	java/lang/Exception
    //   2341	2348	2585	java/lang/Exception
    //   2356	2363	2585	java/lang/Exception
    //   2376	2383	2585	java/lang/Exception
    //   2391	2401	2585	java/lang/Exception
    //   2409	2427	2585	java/lang/Exception
    //   2435	2441	2585	java/lang/Exception
    //   2449	2453	2585	java/lang/Exception
    //   2474	2483	2585	java/lang/Exception
    //   2497	2515	2585	java/lang/Exception
    //   2526	2531	2585	java/lang/Exception
    //   1430	1438	2590	java/lang/Exception
    //   1741	1746	2590	java/lang/Exception
    //   2131	2136	2590	java/lang/Exception
    //   2223	2228	2590	java/lang/Exception
    //   2232	2237	2590	java/lang/Exception
    //   2241	2246	2590	java/lang/Exception
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = this.mAdapter;
    if (localListAdapter != null)
    {
      if (isInTouchMode()) {
        return -1;
      }
      int j = localListAdapter.getCount();
      if (!this.mAreAllItemsSelectable)
      {
        int i;
        if (paramBoolean)
        {
          paramInt = Math.max(0, paramInt);
          for (;;)
          {
            i = paramInt;
            if (paramInt >= j) {
              break;
            }
            i = paramInt;
            if (localListAdapter.isEnabled(paramInt)) {
              break;
            }
            paramInt += 1;
          }
        }
        paramInt = Math.min(paramInt, j - 1);
        for (;;)
        {
          i = paramInt;
          if (paramInt < 0) {
            break;
          }
          i = paramInt;
          if (localListAdapter.isEnabled(paramInt)) {
            break;
          }
          paramInt -= 1;
        }
        if (i >= 0)
        {
          if (i >= j) {
            return -1;
          }
          return i;
        }
        return -1;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= j) {
          return -1;
        }
        return paramInt;
      }
    }
    return -1;
  }
  
  final int measureHeightOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = this.mAdapter;
    if (localObject == null) {
      return this.mListPadding.top + this.mListPadding.bottom;
    }
    int m = this.mListPadding.top + this.mListPadding.bottom;
    int i = this.mDividerHeight;
    int n = 0;
    if ((i <= 0) || (this.mDivider == null)) {
      i = 0;
    }
    int j = paramInt3;
    if (paramInt3 == -1) {
      j = ((ListAdapter)localObject).getCount() - 1;
    }
    localObject = this.mRecycler;
    boolean bool = recycleOnMeasure();
    boolean[] arrayOfBoolean = this.mIsScrap;
    int k = paramInt2;
    paramInt2 = n;
    paramInt3 = m;
    while (k <= j)
    {
      View localView = obtainView(k, arrayOfBoolean);
      measureScrapChild(localView, k, paramInt1);
      m = paramInt3;
      if (k > 0) {
        m = paramInt3 + i;
      }
      if ((bool) && (((AbsListView.RecycleBin)localObject).shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))) {
        ((AbsListView.RecycleBin)localObject).addScrapView(localView, -1);
      }
      paramInt3 = m + localView.getMeasuredHeight();
      if (paramInt3 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 >= 0)
        {
          paramInt1 = paramInt4;
          if (k > paramInt5)
          {
            paramInt1 = paramInt4;
            if (paramInt2 > 0)
            {
              paramInt1 = paramInt4;
              if (paramInt3 != paramInt4) {
                paramInt1 = paramInt2;
              }
            }
          }
        }
        return paramInt1;
      }
      m = paramInt2;
      if (paramInt5 >= 0)
      {
        m = paramInt2;
        if (k >= paramInt5) {
          m = paramInt3;
        }
      }
      k += 1;
      paramInt2 = m;
    }
    return paramInt3;
  }
  
  protected void measureScrapChild(View paramView, int paramInt1, int paramInt2)
  {
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.viewType = this.mAdapter.getItemViewType(paramInt1);
    localLayoutParams1.forceAdd = true;
    paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.mListPadding.left + this.mListPadding.right, localLayoutParams1.width);
    paramInt1 = localLayoutParams1.height;
    if (paramInt1 > 0) {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    } else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(paramInt2, paramInt1);
  }
  
  protected AbsListView.AdapterDataSetObserver newObserver()
  {
    return new ListView.ListDataSetObserver(this);
  }
  
  public void onDescendantInvalidated(View paramView1, View paramView2)
  {
    super.onDescendantInvalidated(paramView1, paramView2);
    try
    {
      if ((Build.VERSION.SDK_INT >= 26) && (this.descendantInvalidatedFlag))
      {
        paramView1 = View.class.getDeclaredField("mPrivateFlags");
        paramView1.setAccessible(true);
        paramView1.set(this, Integer.valueOf(paramView1.getInt(this) | 0x80000000));
        return;
      }
    }
    catch (Exception paramView1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, paramView1.getMessage(), paramView1);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int j = getChildCount();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        addHeaderView(getChildAt(i));
        i += 1;
      }
      removeAllViews();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    ListAdapter localListAdapter = this.mAdapter;
    int m = 0;
    int n = 0;
    int j = -1;
    int k = m;
    int i = j;
    if (localListAdapter != null)
    {
      k = m;
      i = j;
      if (paramBoolean)
      {
        k = m;
        i = j;
        if (paramRect != null)
        {
          paramRect.offset(getScrollX(), getScrollY());
          if (localListAdapter.getCount() < getChildCount() + this.mFirstPosition)
          {
            this.mLayoutMode = 0;
            layoutChildren();
          }
          Rect localRect = this.mTempRect;
          int i2 = getChildCount();
          int i3 = this.mFirstPosition;
          k = 0;
          m = 2147483647;
          i = n;
          while (i < i2)
          {
            if (!localListAdapter.isEnabled(i3 + i))
            {
              n = m;
            }
            else
            {
              View localView = getChildAt(i);
              localView.getDrawingRect(localRect);
              offsetDescendantRectToMyCoords(localView, localRect);
              int i1 = getDistance(paramRect, localRect, paramInt);
              n = m;
              if (i1 < m)
              {
                k = localView.getTop();
                j = i;
                n = i1;
              }
            }
            i += 1;
            m = n;
          }
          i = j;
        }
      }
    }
    if (i >= 0)
    {
      setSelectionFromTop(i + this.mFirstPosition, k);
      return;
    }
    requestLayout();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    checkOverScrollHeaderIsVisable();
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt, 1, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return commonKey(paramInt, 1, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mOverscrollHeaderViewContainer != null)
    {
      paramInt1 = this.mListPadding.top;
      this.mOverscrollHeaderViewContainer.layout(this.mListPadding.left, paramInt1, this.mListPadding.left + this.mOverscrollHeaderViewContainer.getMeasuredWidth(), this.mOverscrollHeaderViewContainer.getMeasuredHeight() + paramInt1);
      this.mTopOverflingDistance = this.mOverscrollHeaderViewContainer.getHeight();
    }
    ListView.OverscrollViewContainer localOverscrollViewContainer = this.mOverscrollFooterView;
    if (localOverscrollViewContainer != null)
    {
      localOverscrollViewContainer.layout(this.mListPadding.left, getMeasuredHeight() - this.mOverscrollFooterView.getMeasuredHeight() - this.mListPadding.bottom, this.mListPadding.left + this.mOverscrollFooterView.getMeasuredWidth(), getMeasuredHeight() - this.mListPadding.bottom);
      this.mBottomOverflingDistance = this.mOverscrollFooterView.getHeight();
    }
  }
  
  @TargetApi(11)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if (this.mAdapter == null) {
      paramInt2 = 0;
    } else {
      paramInt2 = this.mAdapter.getCount();
    }
    this.mItemCount = paramInt2;
    Object localObject;
    int k;
    if ((this.mItemCount > 0) && ((i4 == 0) || (i3 == 0)))
    {
      localObject = obtainView(0, this.mIsScrap);
      measureScrapChild((View)localObject, 0, paramInt1);
      int i1 = ((View)localObject).getMeasuredWidth();
      int i2 = ((View)localObject).getMeasuredHeight();
      if (VersionUtils.e()) {
        paramInt2 = combineMeasuredStates(0, ((View)localObject).getMeasuredState());
      } else {
        paramInt2 = 0;
      }
      k = i1;
      j = i2;
      i = paramInt2;
      if (recycleOnMeasure())
      {
        k = i1;
        j = i2;
        i = paramInt2;
        if (this.mRecycler.shouldRecycleViewType(((AbsListView.LayoutParams)((View)localObject).getLayoutParams()).viewType))
        {
          this.mRecycler.addScrapView((View)localObject, -1);
          k = i1;
          j = i2;
          i = paramInt2;
        }
      }
    }
    else
    {
      k = 0;
      j = 0;
      i = 0;
    }
    if (i4 == 0)
    {
      paramInt2 = this.mListPadding.left;
      i = this.mListPadding.right;
      paramInt2 = getVerticalScrollbarWidth() + (paramInt2 + i + k);
    }
    else
    {
      paramInt2 = n;
      if (VersionUtils.e()) {
        paramInt2 = n | 0xFF000000 & i;
      }
    }
    int i = m;
    if (i3 == 0) {
      i = this.mListPadding.top + this.mListPadding.bottom + j + getVerticalFadingEdgeLength() * 2;
    }
    int j = i;
    if (i3 == -2147483648) {
      j = measureHeightOfChildren(paramInt1, 0, -1, i, -1);
    }
    setMeasuredDimension(paramInt2, j);
    this.mWidthMeasureSpec = paramInt1;
    if ((this.mOverscrollHeaderViewContainer != null) || (this.mOverscrollFooterView != null))
    {
      paramInt1 = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, -1);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localObject = this.mOverscrollHeaderViewContainer;
      if (localObject != null) {
        ((ListView.OverscrollViewContainer)localObject).measure(paramInt1, paramInt2);
      }
      localObject = this.mOverscrollFooterView;
      if (localObject != null) {
        ((ListView.OverscrollViewContainer)localObject).measure(paramInt1, paramInt2);
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) && (paramInt4 == 0))
    {
      localObject = this.mOverscrollHeaderViewContainer;
      if (localObject != null)
      {
        attachWindow((View)localObject);
        break label113;
      }
    }
    if ((paramInt2 == 0) && (paramInt4 < 0))
    {
      localObject = this.mOverscrollHeaderViewContainer;
      if (localObject != null)
      {
        detachedWindow((View)localObject);
        break label113;
      }
    }
    if ((paramInt2 > 0) && (paramInt4 == 0))
    {
      localObject = this.mOverscrollFooterView;
      if (localObject != null)
      {
        attachWindow((View)localObject);
        break label113;
      }
    }
    if ((paramInt2 == 0) && (paramInt4 > 0))
    {
      localObject = this.mOverscrollFooterView;
      if (localObject != null) {
        detachedWindow((View)localObject);
      }
    }
    label113:
    Object localObject = this.mOnScrollChangeListener;
    if (localObject != null) {
      ((ListView.OnScrollChangeListener)localObject).onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() > 0)
    {
      View localView = getFocusedChild();
      if (localView != null)
      {
        int i = this.mFirstPosition;
        int j = indexOfChild(localView);
        int k = Math.max(0, localView.getBottom() - (paramInt2 - getPaddingTop()));
        int m = localView.getTop();
        if (this.mFocusSelector == null) {
          this.mFocusSelector = new ListView.FocusSelector(this, null);
        }
        post(this.mFocusSelector.setup(i + j, m - k));
      }
      clearDelAnim();
    }
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onThemeChanged()
  {
    this.mRecycler.clear();
    Iterator localIterator = this.mHeaderViewInfos.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).view);
    }
    localIterator = this.mFooterViewInfos.iterator();
    while (localIterator.hasNext()) {
      SkinEngine.invalidateAll(((ListView.FixedViewInfo)localIterator.next()).view);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      this.isTouchHolding = true;
    } else if ((i == 1) || (i == 3)) {
      this.isTouchHolding = false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    checkOverScrollHeaderIsVisable();
    return bool;
  }
  
  boolean pageScroll(int paramInt)
  {
    if (paramInt == 33)
    {
      paramInt = Math.max(0, this.mSelectedPosition - getChildCount() - 1);
    }
    else
    {
      if (paramInt == 130)
      {
        paramInt = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount() - 1);
        bool = true;
        break label62;
      }
      paramInt = -1;
    }
    boolean bool = false;
    label62:
    if (paramInt >= 0)
    {
      paramInt = lookForSelectablePosition(paramInt, bool);
      if (paramInt >= 0)
      {
        this.mLayoutMode = 4;
        this.mSpecificTop = (getPaddingTop() + getVerticalFadingEdgeLength());
        if ((bool) && (paramInt > this.mItemCount - getChildCount())) {
          this.mLayoutMode = 3;
        }
        if ((!bool) && (paramInt < getChildCount())) {
          this.mLayoutMode = 1;
        }
        setSelectionInt(paramInt);
        invokeOnItemScrollListener();
        if (!awakenScrollBars()) {
          invalidate();
        }
        return true;
      }
    }
    return false;
  }
  
  @ViewDebug.ExportedProperty(category="list")
  protected boolean recycleOnMeasure()
  {
    return true;
  }
  
  public boolean removeFooterView(View paramView)
  {
    int i = this.mFooterViewInfos.size();
    boolean bool1 = false;
    boolean bool2 = false;
    if (i > 0)
    {
      bool1 = bool2;
      if (this.mAdapter != null)
      {
        bool1 = bool2;
        if (((HeaderViewListAdapter)this.mAdapter).removeFooter(paramView))
        {
          if (this.mDataSetObserver != null) {
            this.mDataSetObserver.onChanged();
          }
          bool1 = true;
        }
      }
      removeFixedViewInfo(paramView, this.mFooterViewInfos);
    }
    return bool1;
  }
  
  public boolean removeHeaderView(View paramView)
  {
    int i = this.mHeaderViewInfos.size();
    int j = 0;
    if ((i > 0) && (paramView != null))
    {
      int k = this.mHeaderViewInfos.size();
      i = 0;
      while (i < k)
      {
        if (((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view == paramView) {
          break label65;
        }
        i += 1;
      }
      i = -1;
      label65:
      boolean bool;
      if ((this.mAdapter != null) && (((HeaderViewListAdapter)this.mAdapter).removeHeader(paramView)))
      {
        if (this.mDataSetObserver != null) {
          this.mDataSetObserver.onChanged();
        }
        bool = true;
      }
      else
      {
        bool = false;
      }
      removeFixedViewInfo(paramView, this.mHeaderViewInfos);
      if (i != -1) {
        while (j < 3)
        {
          paramView = this.mHeaderViewLevelIndex;
          if (paramView[j] > i) {
            paramView[j] -= 1;
          }
          j += 1;
        }
      }
      return bool;
    }
    return false;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int i1 = paramRect.top;
    paramRect.offset(paramView.getLeft(), paramView.getTop());
    paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
    int m = getHeight();
    int j = getScrollY();
    int k = j + m;
    int n = getVerticalFadingEdgeLength();
    int i = j;
    if (showingTopFadingEdge()) {
      if (this.mSelectedPosition <= 0)
      {
        i = j;
        if (i1 <= n) {}
      }
      else
      {
        i = j + n;
      }
    }
    j = getChildCount();
    paramBoolean = true;
    i1 = getChildAt(j - 1).getBottom();
    j = k;
    if (showingBottomFadingEdge()) {
      if (this.mSelectedPosition >= this.mItemCount - 1)
      {
        j = k;
        if (paramRect.bottom >= i1 - n) {}
      }
      else
      {
        j = k - n;
      }
    }
    if ((paramRect.bottom > j) && (paramRect.top > i))
    {
      if (paramRect.height() > m) {
        i = paramRect.top - i;
      } else {
        i = paramRect.bottom - j;
      }
      i = Math.min(i + 0, i1 - j);
    }
    else if ((paramRect.top < i) && (paramRect.bottom < j))
    {
      if (paramRect.height() > m) {
        j = 0 - (j - paramRect.bottom);
      } else {
        j = 0 - (i - paramRect.top);
      }
      i = Math.max(j, getChildAt(0).getTop() - i);
    }
    else
    {
      i = 0;
    }
    if (i == 0) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      scrollListItemsBy(-i);
      positionSelector(-1, paramView);
      this.mSelectedTop = paramView.getTop();
      invalidate();
    }
    return paramBoolean;
  }
  
  void resetList()
  {
    clearRecycledState(this.mHeaderViewInfos);
    clearRecycledState(this.mFooterViewInfos);
    super.resetList();
    this.mLayoutMode = 0;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.mAdapter != null) && (this.mDataSetObserver != null)) {
      this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
    }
    resetList();
    this.mRecycler.clear();
    if ((this.mHeaderViewInfos.size() <= 0) && (this.mFooterViewInfos.size() <= 0)) {
      this.mAdapter = paramListAdapter;
    } else {
      this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, paramListAdapter);
    }
    this.mOldSelectedPosition = -1;
    this.mOldSelectedRowId = -9223372036854775808L;
    super.setAdapter(paramListAdapter);
    if (this.mAdapter != null)
    {
      this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new ListView.ListDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
      int i;
      if (this.mStackFromBottom) {
        i = lookForSelectablePosition(this.mItemCount - 1, false);
      } else {
        i = lookForSelectablePosition(0, true);
      }
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    else
    {
      this.mAreAllItemsSelectable = true;
      checkFocus();
      checkSelectionChanged();
    }
    requestLayout();
  }
  
  public void setCacheColorHint(int paramInt)
  {
    boolean bool;
    if (paramInt >>> 24 == 255) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsCacheColorOpaque = bool;
    if (bool)
    {
      if (this.mDividerPaint == null) {
        this.mDividerPaint = new Paint();
      }
      this.mDividerPaint.setColor(paramInt);
    }
    super.setCacheColorHint(paramInt);
  }
  
  public void setConsiderFooterWhenDrawOverScrollFooter(boolean paramBoolean)
  {
    this.considerFooterWhenDrawOverScrollFooter = paramBoolean;
  }
  
  public void setContentBackground(int paramInt)
  {
    setContentBackground(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setContentBackground(Drawable paramDrawable)
  {
    setContentBackground(paramDrawable, true);
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    setContentBackground(paramDrawable, paramBoolean, false);
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramDrawable == null)
    {
      this.mContentBackgroundDrawable = null;
      this.mOverScrollHeaderShadow = null;
    }
    else
    {
      this.mContentBackgroundDrawable = paramDrawable;
      if (paramBoolean1) {
        this.mOverScrollHeaderShadow = getResources().getDrawable(2130841382);
      }
    }
    this.mUseEfficientMode = paramBoolean2;
  }
  
  public void setDelAnimationDuration(long paramLong)
  {
    if (paramLong > 0L) {
      this.delAnimDuration = paramLong;
    }
  }
  
  public void setDescendantInvalidatedFlags(boolean paramBoolean)
  {
    this.descendantInvalidatedFlag = paramBoolean;
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != null) {
      this.mDividerHeight = paramDrawable.getIntrinsicHeight();
    } else {
      this.mDividerHeight = 0;
    }
    int j = this.mDividerHeight;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    this.mDividerHeight = i;
    this.mDivider = paramDrawable;
    if ((paramDrawable == null) || (paramDrawable.getOpacity() == -1)) {
      bool = true;
    }
    this.mDividerIsOpaque = bool;
    requestLayout();
    invalidate();
  }
  
  public void setDividerHeight(int paramInt)
  {
    this.mDividerHeight = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setFooterDividersEnabled(boolean paramBoolean)
  {
    this.mFooterDividersEnabled = paramBoolean;
    invalidate();
  }
  
  public void setHeaderDividersEnabled(boolean paramBoolean)
  {
    this.mHeaderDividersEnabled = paramBoolean;
    invalidate();
  }
  
  public void setInsertAnimation(Animation paramAnimation)
  {
    this.mInsertAnimation = paramAnimation;
  }
  
  public void setItemsCanFocus(boolean paramBoolean)
  {
    this.mItemsCanFocus = paramBoolean;
    if (!paramBoolean) {
      setDescendantFocusability(393216);
    }
  }
  
  public void setOnScrollChangeListener(ListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.mOnScrollChangeListener = paramOnScrollChangeListener;
  }
  
  public void setOnSpringBackListener(ListView.OnSpringBackListener paramOnSpringBackListener)
  {
    this.mOnSpringBackListener = paramOnSpringBackListener;
  }
  
  public void setOverScrollFooter(View paramView)
  {
    if (paramView == null)
    {
      paramView = this.mOverscrollFooterView;
      if (paramView != null)
      {
        paramView.removeAllViewsInLayout();
        ListView.OverscrollViewContainer.access$200(this.mOverscrollFooterView, null);
        this.mOverscrollFooterView = null;
      }
    }
    else
    {
      if (this.mOverscrollFooterView == null)
      {
        this.mOverscrollFooterView = new ListView.OverscrollViewContainer(getContext());
        ListView.OverscrollViewContainer.access$200(this.mOverscrollFooterView, this);
      }
      this.mOverscrollFooterView.removeAllViewsInLayout();
      this.mOverscrollFooterView.addView(paramView);
    }
    this.mOverscrollHeadState = 0;
    setScrollY(0);
  }
  
  public void setOverScrollFooterHeight(int paramInt)
  {
    this.mOverScrollFooterHeight = paramInt;
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView == null)
    {
      paramView = this.mOverscrollHeaderViewContainer;
      if (paramView != null)
      {
        paramView.removeAllViewsInLayout();
        ListView.OverscrollViewContainer.access$200(this.mOverscrollHeaderViewContainer, null);
        this.mOverscrollHeaderViewContainer = null;
      }
    }
    else
    {
      if (this.mOverscrollHeaderViewContainer == null)
      {
        this.mOverscrollHeaderViewContainer = new ListView.OverscrollViewContainer(getContext());
        ListView.OverscrollViewContainer.access$200(this.mOverscrollHeaderViewContainer, this);
      }
      this.mOverscrollHeaderViewContainer.removeAllViewsInLayout();
      this.mOverscrollHeaderViewContainer.addView(paramView);
    }
    this.mOverscrollHeadState = 0;
    setScrollY(0);
  }
  
  public void setOverScrollHeight(int paramInt)
  {
    this.mOverScrollHeight = paramInt;
  }
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    this.mOverScrollViewListener = paramOverScrollViewListener;
  }
  
  public void setOverscrollFooter(Drawable paramDrawable)
  {
    this.mOverScrollFooter = paramDrawable;
    invalidate();
  }
  
  public void setOverscrollHeader(Drawable paramDrawable)
  {
    this.mOverScrollHeader = paramDrawable;
    if (getScrollY() < 0) {
      invalidate();
    }
  }
  
  public void setOverscrollHeaderTop(int paramInt)
  {
    this.mOverScrollHeaderTopOffset = paramInt;
  }
  
  public void setSelection(int paramInt)
  {
    setSelectionFromTop(paramInt, 0);
  }
  
  public void setSelectionAfterHeaderView()
  {
    int i = this.mHeaderViewInfos.size();
    if (i > 0)
    {
      this.mNextSelectedPosition = 0;
      return;
    }
    if (this.mAdapter != null)
    {
      setSelection(i);
      return;
    }
    this.mNextSelectedPosition = i;
    this.mLayoutMode = 2;
  }
  
  public void setSelectionFromBottom(int paramInt1, int paramInt2)
  {
    if (this.mAdapter == null) {
      return;
    }
    if (!isInTouchMode())
    {
      int i = lookForSelectablePosition(paramInt1, true);
      paramInt1 = i;
      if (i >= 0)
      {
        setNextSelectedPositionInt(i);
        paramInt1 = i;
      }
    }
    else
    {
      this.mResurrectToPosition = paramInt1;
    }
    if (paramInt1 >= 0)
    {
      requestLayout();
      this.mLayoutMode = 100;
      if (this.mNeedSync)
      {
        this.mSyncPosition = paramInt1;
        this.mSyncRowId = this.mAdapter.getItemId(paramInt1);
      }
      this.mSpecificBottom = (this.mListPadding.bottom + paramInt2);
    }
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    if (this.mAdapter == null) {
      return;
    }
    if (!isInTouchMode())
    {
      int i = lookForSelectablePosition(paramInt1, true);
      paramInt1 = i;
      if (i >= 0)
      {
        setNextSelectedPositionInt(i);
        paramInt1 = i;
      }
    }
    else
    {
      this.mResurrectToPosition = paramInt1;
    }
    if (paramInt1 >= 0)
    {
      requestLayout();
      this.mLayoutMode = 4;
      if (this.mNeedSync)
      {
        this.mSyncPosition = paramInt1;
        this.mSyncRowId = this.mAdapter.getItemId(paramInt1);
      }
      initPaddingManual();
      this.mSpecificTop = (this.mListPadding.top + paramInt2);
    }
  }
  
  void setSelectionInt(int paramInt)
  {
    setNextSelectedPositionInt(paramInt);
    int j = this.mSelectedPosition;
    int i = 1;
    if (j >= 0)
    {
      if (paramInt == j - 1)
      {
        paramInt = i;
        break label42;
      }
      if (paramInt == j + 1)
      {
        paramInt = i;
        break label42;
      }
    }
    paramInt = 0;
    label42:
    layoutChildren();
    if (paramInt != 0) {
      awakenScrollBars();
    }
  }
  
  public void setStatisticCollector()
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter instanceof HeaderViewListAdapter))
    {
      localListAdapter = ((HeaderViewListAdapter)localListAdapter).getWrappedAdapter();
      if ((localListAdapter instanceof ExpandableListConnector))
      {
        ((ExpandableListConnector)localListAdapter).getAdapter().getClass().getName();
        return;
      }
      localListAdapter.getClass().getName();
      return;
    }
    if ((localListAdapter instanceof ExpandableListConnector))
    {
      ((ExpandableListConnector)localListAdapter).getAdapter().getClass().getName();
      return;
    }
    localListAdapter.getClass().getName();
  }
  
  public void showOverScrollFooter()
  {
    scrollTo(0, getOverScrollFooterHeight() + 1);
    OverScrollViewListener localOverScrollViewListener = this.mOverScrollViewListener;
    if (localOverScrollViewListener != null)
    {
      ListView.OverscrollViewContainer localOverscrollViewContainer = this.mOverscrollFooterView;
      if (localOverscrollViewContainer != null)
      {
        if (!localOverScrollViewListener.onViewCompleteVisableAndReleased(1, localOverscrollViewContainer.getChildAt(0), this))
        {
          springBackOverScrollView();
          return;
        }
        this.mOverscrollHeadState = 3;
      }
    }
  }
  
  public void showOverScrollHeader()
  {
    scrollTo(0, -getOverScrollHeight() - 1);
    OverScrollViewListener localOverScrollViewListener = this.mOverScrollViewListener;
    if (localOverScrollViewListener != null)
    {
      ListView.OverscrollViewContainer localOverscrollViewContainer = this.mOverscrollHeaderViewContainer;
      if (localOverscrollViewContainer != null)
      {
        if (!localOverScrollViewListener.onViewCompleteVisableAndReleased(0, localOverscrollViewContainer.getChildAt(0), this))
        {
          springBackOverScrollView();
          return;
        }
        this.mOverscrollHeadState = 3;
      }
    }
  }
  
  public void smoothScrollByOffset(int paramInt)
  {
    super.smoothScrollByOffset(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    super.smoothScrollToPosition(paramInt);
  }
  
  public void springBackOverScrollFooterView()
  {
    springBackOverScrollFooterView(0);
  }
  
  public void springBackOverScrollFooterView(int paramInt)
  {
    springBackOverScrollView(paramInt);
  }
  
  public void springBackOverScrollHeaderView()
  {
    springBackOverScrollHeaderView(0);
  }
  
  public void springBackOverScrollHeaderView(int paramInt)
  {
    springBackOverScrollView(paramInt);
    ListView.OnSpringBackListener localOnSpringBackListener = this.mOnSpringBackListener;
    if (localOnSpringBackListener != null) {
      localOnSpringBackListener.onSpringBack();
    }
  }
  
  public void springBackOverScrollView()
  {
    springBackOverScrollView(0);
  }
  
  public void springBackOverScrollView(int paramInt)
  {
    if ((getScrollY() != 0) && (!this.isTouchHolding)) {
      doSpringBack(paramInt);
    }
    this.mOverscrollHeadState = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.ListView
 * JD-Core Version:    0.7.0.1
 */