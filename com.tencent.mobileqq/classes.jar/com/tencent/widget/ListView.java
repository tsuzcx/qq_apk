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
      j = 0;
      if (n != 0) {
        while (j < i3)
        {
          if ((!bool2) && (i5 + j < i6)) {}
          for (;;)
          {
            break;
            if ((bool3) || (i5 + j < i1))
            {
              m = getChildAt(j).getBottom();
              if ((m < i) && ((k == 0) || (j != i3 - 1)))
              {
                if (!bool4)
                {
                  n = i5 + j;
                  localObject3 = localObject1;
                  if ((!((ListAdapter)localObject3).isEnabled(n)) || ((j != i3 - 1) && (!((ListAdapter)localObject3).isEnabled(n + 1))))
                  {
                    if (!bool1) {
                      break;
                    }
                    localRect.top = m;
                    localRect.bottom = (m + i2);
                    paramCanvas.drawRect(localRect, (Paint)localObject2);
                    break;
                  }
                }
                localRect.top = m;
                localRect.bottom = (m + i2);
                drawDivider(paramCanvas, localRect, j);
              }
            }
          }
          j += 1;
        }
      }
      i = getBottom() + i7 + this.mDividerHeight;
      if ((k != 0) && (i5 + i3 == i4) && (i > getBottom()))
      {
        localRect.top = (getBottom() + this.mDividerHeight);
        localRect.bottom = i;
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
  
  protected void layoutChildren()
  {
    boolean bool1 = this.mBlockLayoutRequests;
    boolean bool2;
    if (!bool1)
    {
      this.mBlockLayoutRequests = true;
      traceBegin("ListView.layoutChildren");
      bool2 = bool1;
    }
    for (;;)
    {
      try
      {
        super.layoutChildren();
        bool2 = bool1;
        invalidate();
        bool2 = bool1;
        if (this.mAdapter == null)
        {
          bool2 = bool1;
          resetList();
          bool2 = bool1;
          invokeOnItemScrollListener();
          if (!bool1) {
            this.mBlockLayoutRequests = false;
          }
          traceEnd();
          return;
        }
        bool2 = bool1;
        int j = this.mListPadding.top;
        bool2 = bool1;
        int m = getBottom() - getTop() - this.mListPadding.bottom;
        bool2 = bool1;
        int i1 = getChildCount();
        bool2 = bool1;
        int n = this.mFirstPosition + i1 - 1;
        bool2 = bool1;
        i = this.mLayoutMode;
        if (i == 1) {
          break label2088;
        }
        if (i != 2)
        {
          if ((i == 3) || (i == 4) || (i == 5)) {
            break label2088;
          }
          bool2 = bool1;
          k = this.mSelectedPosition - this.mFirstPosition;
          if ((k < 0) || (k >= i1)) {
            break label2077;
          }
          bool2 = bool1;
          localObject1 = getChildAt(k);
          bool2 = bool1;
          localView2 = getChildAt(0);
          bool2 = bool1;
          localView1 = getChildAt(i1 - 1);
          bool2 = bool1;
          if (this.mNextSelectedPosition < 0) {
            break label2083;
          }
          bool2 = bool1;
          i = this.mNextSelectedPosition - this.mSelectedPosition;
          bool2 = bool1;
          localObject8 = getChildAt(k + i);
          localObject7 = localObject1;
        }
        else
        {
          bool2 = bool1;
          i = this.mNextSelectedPosition - this.mFirstPosition;
          if ((i < 0) || (i >= i1)) {
            break label2088;
          }
          bool2 = bool1;
          localObject1 = getChildAt(i);
          break label2091;
        }
        bool2 = bool1;
        boolean bool3 = this.mDataChanged;
        if (bool3)
        {
          bool2 = bool1;
          handleDataChanged();
        }
        bool2 = bool1;
        if (this.mItemCount == 0)
        {
          bool2 = bool1;
          resetList();
          bool2 = bool1;
          invokeOnItemScrollListener();
          if (!bool1) {
            this.mBlockLayoutRequests = false;
          }
          traceEnd();
          return;
        }
        bool2 = bool1;
        if (this.mItemCount != this.mAdapter.getCount())
        {
          bool2 = bool1;
          localObject1 = this.mAdapter.getClass();
          bool2 = bool1;
          if ((this.mAdapter instanceof HeaderViewListAdapter))
          {
            bool2 = bool1;
            localObject1 = ((HeaderViewListAdapter)this.mAdapter).getWrappedAdapter().getClass();
          }
          bool2 = bool1;
          localObject5 = new StringBuilder();
          bool2 = bool1;
          ((StringBuilder)localObject5).append("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(getId());
          bool2 = bool1;
          ((StringBuilder)localObject5).append(", ");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(getClass());
          bool2 = bool1;
          ((StringBuilder)localObject5).append(") with Adapter(");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(localObject1);
          bool2 = bool1;
          ((StringBuilder)localObject5).append(")]mItemCount=");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(this.mItemCount);
          bool2 = bool1;
          ((StringBuilder)localObject5).append("mAdapter.getCount()=");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(this.mAdapter.getCount());
          bool2 = bool1;
          ((StringBuilder)localObject5).append(",adapter.addr = ");
          bool2 = bool1;
          ((StringBuilder)localObject5).append(this.mAdapter.toString());
          throw new IllegalStateException(((StringBuilder)localObject5).toString());
        }
        bool2 = bool1;
        setSelectedPositionInt(this.mNextSelectedPosition);
        bool2 = bool1;
        int i2 = this.mFirstPosition;
        bool2 = bool1;
        AbsListView.RecycleBin localRecycleBin = this.mRecycler;
        if (bool3)
        {
          k = 0;
          if (k >= i1) {
            break label2109;
          }
          bool2 = bool1;
          localObject1 = getChildAt(k);
          bool2 = bool1;
          bool1 = bool2;
        }
        try
        {
          localRecycleBin.addScrapView((View)localObject1, i2 + k);
          k += 1;
        }
        finally
        {
          View localView3;
          break label2060;
        }
        bool2 = bool1;
        bool1 = bool2;
        localRecycleBin.fillActiveViews(i1, i2);
        bool1 = bool2;
        localObject6 = getFocusedChild();
        if (localObject6 == null) {
          break label2125;
        }
        if (bool3)
        {
          bool1 = bool2;
          if (!isDirectChildHeaderOrFooter((View)localObject6)) {
            break label2116;
          }
        }
        bool1 = bool2;
        localView3 = findFocus();
        Object localObject1 = localObject6;
        localObject5 = localView3;
        if (localView3 != null)
        {
          bool1 = bool2;
          localView3.onStartTemporaryDetach();
          localObject5 = localView3;
          localObject1 = localObject6;
        }
        bool1 = bool2;
        requestFocus();
        localObject6 = localObject1;
        bool1 = bool2;
        detachAllViewsFromParent();
        bool1 = bool2;
        int k = this.mLayoutMode;
        if (k != 100) {}
        switch (k)
        {
        case 6: 
          if (i1 == 0)
          {
            bool1 = bool2;
            if (!this.mStackFromBottom)
            {
              bool1 = bool2;
              setSelectedPositionInt(lookForSelectablePosition(0, true));
              bool1 = bool2;
              localObject1 = fillFromTop(j);
            }
            else
            {
              bool1 = bool2;
              setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
              bool1 = bool2;
              localObject1 = fillUp(this.mItemCount - 1, m);
            }
          }
          else
          {
            bool1 = bool2;
            if (this.mSelectedPosition >= 0)
            {
              bool1 = bool2;
              if (this.mSelectedPosition < this.mItemCount)
              {
                bool1 = bool2;
                i = this.mSelectedPosition;
                if (localObject7 != null)
                {
                  bool1 = bool2;
                  j = localObject7.getTop();
                }
                bool1 = bool2;
                localObject1 = fillSpecific(i, j);
                continue;
              }
            }
            bool1 = bool2;
            if (getScrollY() == 0)
            {
              bool1 = bool2;
              if (!this.mStackFromBottom) {}
            }
            else
            {
              bool1 = bool2;
              if (getScrollY() >= 0) {
                continue;
              }
            }
            bool1 = bool2;
            if (this.mFirstPosition < this.mItemCount)
            {
              bool1 = bool2;
              i = this.mFirstPosition;
              if (localView2 != null)
              {
                bool1 = bool2;
                j = localView2.getTop();
              }
              bool1 = bool2;
              localObject1 = fillSpecific(i, j);
            }
            else
            {
              bool1 = bool2;
              localObject1 = fillSpecific(0, j);
              continue;
              bool1 = bool2;
              if (n < this.mItemCount)
              {
                if (localView1 == null)
                {
                  i = m;
                }
                else
                {
                  bool1 = bool2;
                  i = localView1.getBottom();
                }
                bool1 = bool2;
                localObject1 = fillSpecificBottom(n, i);
              }
              else
              {
                bool1 = bool2;
                localObject1 = fillSpecificBottom(this.mItemCount - 1, this.mLayoutHeight);
                continue;
                bool1 = bool2;
                localObject1 = moveSelection(localObject7, (View)localObject8, i, j, m);
              }
            }
          }
          break;
        case 5: 
          bool1 = bool2;
          if (!this.mStackFromBottom)
          {
            bool1 = bool2;
            localObject1 = fillSpecific(this.mSyncPosition, this.mSpecificTop);
          }
          else
          {
            bool1 = bool2;
            localObject1 = fillSpecificBottom(this.mSyncPosition, this.mLayoutHeight - this.mSpecificBottom);
          }
          break;
        case 4: 
          bool1 = bool2;
          localObject1 = fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
          break;
        case 3: 
          bool1 = bool2;
          localObject1 = fillUp(this.mItemCount - 1, m);
          bool1 = bool2;
          adjustViewsUpOrDown();
          break;
        case 2: 
          if (localObject8 != null)
          {
            bool1 = bool2;
            localObject1 = fillFromSelection(((View)localObject8).getTop(), j, m);
          }
          else
          {
            bool1 = bool2;
            localObject1 = fillFromMiddle(j, m);
          }
          break;
        case 1: 
          bool1 = bool2;
          this.mFirstPosition = 0;
          bool1 = bool2;
          localObject1 = fillFromTop(j);
          bool1 = bool2;
          adjustViewsUpOrDown();
          continue;
          bool1 = bool2;
          localObject1 = fillSpecificBottom(reconcileSelectedPosition(), this.mLayoutHeight - this.mSpecificBottom);
          bool1 = bool2;
          stayOnTheTop();
          bool1 = bool2;
          localRecycleBin.scrapActiveViews();
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (this.mItemsCanFocus)
            {
              bool1 = bool2;
              if (hasFocus())
              {
                bool1 = bool2;
                if (!((View)localObject1).hasFocus())
                {
                  if ((localObject1 == localObject6) && (localObject5 != null))
                  {
                    bool1 = bool2;
                    if (((View)localObject5).requestFocus()) {
                      break label2137;
                    }
                  }
                  bool1 = bool2;
                  if (!((View)localObject1).requestFocus()) {
                    break label2142;
                  }
                  break label2137;
                  if (i == 0)
                  {
                    bool1 = bool2;
                    localObject6 = getFocusedChild();
                    if (localObject6 != null)
                    {
                      bool1 = bool2;
                      ((View)localObject6).clearFocus();
                    }
                    bool1 = bool2;
                    positionSelector(-1, (View)localObject1);
                    continue;
                  }
                  bool1 = bool2;
                  ((View)localObject1).setSelected(false);
                  bool1 = bool2;
                  this.mSelectorRect.setEmpty();
                  continue;
                }
              }
            }
            bool1 = bool2;
            positionSelector(-1, (View)localObject1);
            bool1 = bool2;
            this.mSelectedTop = ((View)localObject1).getTop();
          }
          else
          {
            bool1 = bool2;
            if (this.mTouchMode > 0)
            {
              bool1 = bool2;
              if (this.mTouchMode < 3)
              {
                bool1 = bool2;
                localObject1 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                if (localObject1 == null) {
                  continue;
                }
                bool1 = bool2;
                positionSelector(this.mMotionPosition, (View)localObject1);
                continue;
              }
            }
            bool1 = bool2;
            this.mSelectedTop = 0;
            bool1 = bool2;
            this.mSelectorRect.setEmpty();
            bool1 = bool2;
            if ((hasFocus()) && (localObject5 != null))
            {
              bool1 = bool2;
              ((View)localObject5).requestFocus();
            }
          }
          if (localObject5 != null)
          {
            bool1 = bool2;
            if (((View)localObject5).getWindowToken() != null)
            {
              bool1 = bool2;
              ((View)localObject5).onFinishTemporaryDetach();
            }
          }
          bool1 = bool2;
          this.mLayoutMode = 0;
          bool1 = bool2;
          this.mDataChanged = false;
          bool1 = bool2;
          this.mNeedSync = false;
          bool1 = bool2;
          setNextSelectedPositionInt(this.mSelectedPosition);
          bool1 = bool2;
          updateScrollIndicators();
          bool1 = bool2;
          if (this.mItemCount > 0)
          {
            bool1 = bool2;
            checkSelectionChanged();
          }
          bool1 = bool2;
          invokeOnItemScrollListener();
          bool1 = bool2;
          j = this.mFirstPosition + getChildCount() - 1;
          bool1 = bool2;
          if (this.mInsertAnimation != null)
          {
            bool1 = bool2;
            if ((this.mAddingRows != null) && (bool3))
            {
              bool1 = bool2;
              if (this.mItemCount > 0)
              {
                bool1 = bool2;
                if (j >= this.mItemCount - 1)
                {
                  bool1 = bool2;
                  if (getChildAt(getChildCount() - 1).getBottom() < m)
                  {
                    bool1 = bool2;
                    localObject1 = this.mAddingRows;
                    bool1 = bool2;
                    k = localObject1.length;
                    i = 0;
                    if (i < k)
                    {
                      m = localObject1[i];
                      bool1 = bool2;
                      if ((m < this.mFirstPosition) || (m > j)) {
                        break label2147;
                      }
                      bool1 = bool2;
                      getChildAt(m - this.mFirstPosition).startAnimation(this.mInsertAnimation);
                      break label2147;
                    }
                  }
                }
              }
            }
          }
          bool1 = bool2;
          this.mAddingRows = null;
          if (!bool2) {
            this.mBlockLayoutRequests = false;
          }
          traceEnd();
          return;
        }
      }
      finally
      {
        bool1 = bool2;
      }
      label2060:
      if (!bool1) {
        this.mBlockLayoutRequests = false;
      }
      traceEnd();
      throw localObject3;
      return;
      label2077:
      Object localObject4 = null;
      continue;
      label2083:
      int i = 0;
      continue;
      label2088:
      localObject4 = null;
      label2091:
      i = 0;
      Object localObject7 = null;
      View localView1 = null;
      View localView2 = null;
      Object localObject8 = localObject4;
      continue;
      label2109:
      bool2 = bool1;
      continue;
      label2116:
      localObject4 = null;
      Object localObject5 = null;
      continue;
      label2125:
      Object localObject6 = null;
      localObject5 = null;
      continue;
      continue;
      label2137:
      i = 1;
      continue;
      label2142:
      i = 0;
      continue;
      label2147:
      i += 1;
    }
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
        this.mOverScrollHeaderShadow = getResources().getDrawable(2130840609);
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
  
  public void springBackOverScrollHeaderView()
  {
    springBackOverScrollHeaderView(0);
  }
  
  public void springBackOverScrollHeaderView(int paramInt)
  {
    springBackOverScrollView(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ListView
 * JD-Core Version:    0.7.0.1
 */