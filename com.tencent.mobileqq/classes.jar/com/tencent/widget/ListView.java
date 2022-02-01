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
import bjqx;
import bjsd;
import bjup;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import snm;

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
  private boolean descendantInvalidatedFlag;
  public boolean isTouchHolding;
  private int[] mAddingRows;
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
  private boolean mItemsCanFocus;
  private ListView.OnScrollChangeListener mOnScrollChangeListener;
  Drawable mOverScrollFooter;
  protected int mOverScrollFooterHeight;
  Drawable mOverScrollHeader;
  protected Drawable mOverScrollHeaderShadow;
  int mOverScrollHeaderTopOffset = 0;
  protected int mOverScrollHeight;
  protected bjsd mOverScrollViewListener;
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
    paramAttributeSet = new bjup(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("ListView"), paramInt, 0));
    CharSequence[] arrayOfCharSequence = paramAttributeSet.a(LISTVIEW_ENTRIES);
    if (arrayOfCharSequence != null) {
      setAdapter(new ArrayAdapter(paramContext, 17367043, arrayOfCharSequence));
    }
    paramContext = paramAttributeSet.a(LISTVIEW_DIVIDER);
    if (paramContext != null) {
      setDivider(paramContext);
    }
    paramContext = paramAttributeSet.a(LISTVIEW_OVERSCROLLHEADER);
    if (paramContext != null) {
      setOverscrollHeader(paramContext);
    }
    paramContext = paramAttributeSet.a(LISTVIEW_OVERSCROLLFOOTER);
    if (paramContext != null) {
      setOverscrollFooter(paramContext);
    }
    paramInt = paramAttributeSet.c(LISTVIEW_DIVIDERHEIGHT, 0);
    if (paramInt != 0) {
      setDividerHeight(paramInt);
    }
    this.mHeaderDividersEnabled = paramAttributeSet.a(LISTVIEW_HEADERDIVIDERSENABLED, true);
    this.mFooterDividersEnabled = paramAttributeSet.a(LISTVIEW_FOOTERDIVIDERSENABLED, true);
    paramAttributeSet.a();
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
    int i = paramView.getBottom();
    setupChild(localView, paramInt, this.mDividerHeight + i, true, this.mListPadding.left, false, this.mIsScrap[0]);
    return localView;
  }
  
  private void adjustViewsUpOrDown()
  {
    int k = 0;
    int m = getChildCount();
    int j;
    int i;
    if (m > 0)
    {
      if (this.mStackFromBottom) {
        break label72;
      }
      j = getChildAt(0).getTop() - this.mListPadding.top;
      i = j;
      if (this.mFirstPosition != 0) {
        i = j - this.mDividerHeight;
      }
      j = i;
      if (i >= 0) {
        break label128;
      }
      j = k;
    }
    label128:
    for (;;)
    {
      if (j != 0) {
        offsetChildrenTopAndBottom(-j);
      }
      return;
      label72:
      j = getChildAt(m - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
      i = j;
      if (m + this.mFirstPosition < this.mItemCount) {
        i = j + this.mDividerHeight;
      }
      j = k;
      if (i <= 0) {
        j = i;
      }
    }
  }
  
  private int amountToScroll(int paramInt1, int paramInt2)
  {
    int i = getHeight() - this.mListPadding.bottom;
    int j = this.mListPadding.top;
    int k = getChildCount();
    View localView;
    if (paramInt1 == 130)
    {
      paramInt1 = k - 1;
      if (paramInt2 != -1) {
        paramInt1 = paramInt2 - this.mFirstPosition;
      }
      j = this.mFirstPosition;
      localView = getChildAt(paramInt1);
      if (j + paramInt1 >= this.mItemCount - 1) {
        break label285;
      }
    }
    label285:
    for (paramInt1 = i - getArrowScrollPreviewLength();; paramInt1 = i)
    {
      if (localView.getBottom() <= paramInt1) {}
      while ((paramInt2 != -1) && (paramInt1 - localView.getTop() >= getMaxScrollAmount())) {
        return 0;
      }
      paramInt2 = localView.getBottom() - paramInt1;
      paramInt1 = paramInt2;
      if (this.mFirstPosition + k == this.mItemCount) {
        paramInt1 = Math.min(paramInt2, getChildAt(k - 1).getBottom() - i);
      }
      return Math.min(paramInt1, getMaxScrollAmount());
      if (paramInt2 != -1) {}
      for (paramInt1 = paramInt2 - this.mFirstPosition;; paramInt1 = 0)
      {
        i = this.mFirstPosition;
        localView = getChildAt(paramInt1);
        if (i + paramInt1 > 0) {}
        for (paramInt1 = getArrowScrollPreviewLength() + j; (localView.getTop() < paramInt1) && ((paramInt2 == -1) || (localView.getBottom() - paramInt1 < getMaxScrollAmount())); paramInt1 = j)
        {
          paramInt2 = paramInt1 - localView.getTop();
          paramInt1 = paramInt2;
          if (this.mFirstPosition == 0) {
            paramInt1 = Math.min(paramInt2, j - getChildAt(0).getTop());
          }
          return Math.min(paramInt1, getMaxScrollAmount());
        }
        break;
      }
    }
  }
  
  private int amountToScrollToNewFocus(int paramInt1, View paramView, int paramInt2)
  {
    int i = 0;
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    if (paramInt1 == 33)
    {
      paramInt1 = i;
      if (this.mTempRect.top < this.mListPadding.top)
      {
        i = this.mListPadding.top - this.mTempRect.top;
        paramInt1 = i;
        if (paramInt2 > 0) {
          paramInt1 = i + getArrowScrollPreviewLength();
        }
      }
    }
    do
    {
      int j;
      do
      {
        return paramInt1;
        j = getHeight() - this.mListPadding.bottom;
        paramInt1 = i;
      } while (this.mTempRect.bottom <= j);
      i = this.mTempRect.bottom - j;
      paramInt1 = i;
    } while (paramInt2 >= this.mItemCount - 1);
    return i + getArrowScrollPreviewLength();
  }
  
  private ListView.ArrowScrollFocusResult arrowScrollFocused(int paramInt)
  {
    int j = 1;
    int i = 1;
    View localView = getSelectedView();
    if ((localView != null) && (localView.hasFocus()))
    {
      localView = localView.findFocus();
      localView = FocusFinder.getInstance().findNextFocus(this, localView, paramInt);
      if (localView == null) {
        break label376;
      }
      i = positionOfNewFocus(localView);
      if ((this.mSelectedPosition != -1) && (i != this.mSelectedPosition))
      {
        j = lookForSelectablePositionOnScreen(paramInt);
        if ((j != -1) && (((paramInt == 130) && (j < i)) || ((paramInt == 33) && (j > i)))) {
          return null;
        }
      }
    }
    else
    {
      if (paramInt == 130)
      {
        if (this.mFirstPosition > 0)
        {
          label120:
          j = this.mListPadding.top;
          if (i == 0) {
            break label198;
          }
        }
        label198:
        for (i = getArrowScrollPreviewLength();; i = 0)
        {
          j = i + j;
          i = j;
          if (localView != null)
          {
            i = j;
            if (localView.getTop() > j) {
              i = localView.getTop();
            }
          }
          this.mTempRect.set(0, i, 0, i);
          localView = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, paramInt);
          break;
          i = 0;
          break label120;
        }
      }
      if (this.mFirstPosition + getChildCount() - 1 < this.mItemCount)
      {
        i = j;
        label223:
        j = getHeight();
        k = this.mListPadding.bottom;
        if (i == 0) {
          break label296;
        }
      }
      label296:
      for (i = getArrowScrollPreviewLength();; i = 0)
      {
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
        break;
        i = 0;
        break label223;
      }
    }
    j = amountToScrollToNewFocus(paramInt, localView, i);
    int k = getMaxScrollAmount();
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
    label376:
    return null;
  }
  
  private boolean arrowScrollImpl(int paramInt)
  {
    if (getChildCount() <= 0) {
      return false;
    }
    View localView1 = getSelectedView();
    int m = this.mSelectedPosition;
    int i = lookForSelectablePositionOnScreen(paramInt);
    int j = amountToScroll(paramInt, i);
    Object localObject;
    int k;
    label73:
    boolean bool;
    if (this.mItemsCanFocus)
    {
      localObject = arrowScrollFocused(paramInt);
      if (localObject != null)
      {
        i = ((ListView.ArrowScrollFocusResult)localObject).getSelectedPosition();
        j = ((ListView.ArrowScrollFocusResult)localObject).getAmountToScroll();
      }
      if (localObject == null) {
        break label311;
      }
      k = 1;
      if (i == -1) {
        break label332;
      }
      if (localObject == null) {
        break label317;
      }
      bool = true;
      label86:
      handleNewSelectionChange(localView1, paramInt, i, bool);
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      localView1 = getSelectedView();
      if ((this.mItemsCanFocus) && (localObject == null))
      {
        View localView2 = getFocusedChild();
        if (localView2 != null) {
          localView2.clearFocus();
        }
      }
      checkSelectionChanged();
      k = 1;
      m = i;
    }
    label160:
    label311:
    label317:
    label329:
    label330:
    label332:
    for (;;)
    {
      if (j > 0)
      {
        if (paramInt == 33)
        {
          scrollListItemsBy(j);
          k = 1;
        }
      }
      else
      {
        if ((this.mItemsCanFocus) && (localObject == null) && (localView1 != null) && (localView1.hasFocus()))
        {
          localObject = localView1.findFocus();
          if ((localObject != null) && ((!isViewAncestorOf((View)localObject, this)) || (distanceToView((View)localObject) > 0))) {
            ((View)localObject).clearFocus();
          }
        }
        if ((i != -1) || (localView1 == null) || (isViewAncestorOf(localView1, this))) {
          break label329;
        }
        hideSelector();
        this.mResurrectToPosition = -1;
        localView1 = null;
      }
      for (;;)
      {
        if (k == 0) {
          break label330;
        }
        if (localView1 != null)
        {
          positionSelector(m, localView1);
          this.mSelectedTop = localView1.getTop();
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        invokeOnItemScrollListener();
        return true;
        localObject = null;
        break;
        k = 0;
        break label73;
        bool = false;
        break label86;
        j = -j;
        break label160;
      }
      break;
    }
  }
  
  private void attachWindow(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        Method localMethod = View.class.getDeclaredMethod("dispatchAttachedToWindow", new Class[] { localObject.getClass(), Integer.TYPE });
        localMethod.setAccessible(true);
        localMethod.invoke(paramView, new Object[] { localObject, Integer.valueOf(getVisibility()) });
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private void checkOverScrollHeaderIsVisable()
  {
    int j;
    snm localsnm;
    View localView;
    int i;
    if ((this.mTouchMode == 5) && (getScrollY() != 0))
    {
      j = getScrollY();
      if ((j >= 0) || (this.mOverscrollHeaderViewContainer == null) || (j <= -getOverScrollHeight())) {
        break label179;
      }
      if ((this.mOverscrollHeadState == 0) || (this.mOverscrollHeadState == 2))
      {
        if (this.mOverScrollViewListener != null) {
          this.mOverScrollViewListener.onNotCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        }
        this.mOverscrollHeadState = 1;
      }
      if ((this.mOverScrollViewListener != null) && ((this.mOverScrollViewListener instanceof snm)))
      {
        localsnm = (snm)this.mOverScrollViewListener;
        localView = this.mOverscrollHeaderViewContainer.getChildAt(0);
        if (getOverScrollHeight() <= 0) {
          break label174;
        }
        i = -j * 100 / getOverScrollHeight();
        localsnm.a(0, localView, this, i);
        ((snm)this.mOverScrollViewListener).a(this.mOverscrollHeaderViewContainer.getChildAt(0), this, -j);
      }
    }
    label174:
    label179:
    label335:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
          if ((j <= 0) || (this.mOverscrollFooterView == null) || (j >= getOverScrollFooterHeight())) {
            break label335;
          }
          if ((this.mOverscrollHeadState == 0) || (this.mOverscrollHeadState == 2))
          {
            if (this.mOverScrollViewListener != null) {
              this.mOverScrollViewListener.onNotCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
            }
            this.mOverscrollHeadState = 1;
          }
        } while ((this.mOverScrollViewListener == null) || (!(this.mOverScrollViewListener instanceof snm)));
        localsnm = (snm)this.mOverScrollViewListener;
        localView = this.mOverscrollFooterView.getChildAt(0);
        if (getOverScrollFooterHeight() == 0) {}
        for (i = 0;; i = j * 100 / getOverScrollFooterHeight())
        {
          localsnm.a(1, localView, this, i);
          ((snm)this.mOverScrollViewListener).a(this.mOverscrollFooterView.getChildAt(0), this, j);
          return;
        }
        if ((j >= 0) || (this.mOverscrollHeaderViewContainer == null)) {
          break label387;
        }
      } while ((this.mOverScrollViewListener == null) || (!(this.mOverScrollViewListener instanceof snm)));
      ((snm)this.mOverScrollViewListener).a(this.mOverscrollHeaderViewContainer.getChildAt(0), this, -j);
      return;
    } while ((j <= 0) || (this.mOverscrollFooterView == null) || (!(this.mOverScrollViewListener instanceof snm)));
    label387:
    ((snm)this.mOverScrollViewListener).a(this.mOverscrollFooterView.getChildAt(0), this, j);
  }
  
  private void checkOverscrollViewIsCompleteVisable(View paramView)
  {
    int i = getScrollY();
    paramView.getHeight();
    if (paramView == this.mOverscrollHeaderViewContainer) {
      if ((this.mOverscrollHeadState == 1) && (i <= -getOverScrollHeight()))
      {
        this.mOverscrollHeadState = 2;
        if (this.mOverScrollViewListener != null) {
          this.mOverScrollViewListener.onViewCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramView != this.mOverscrollFooterView) || (this.mOverscrollHeadState != 1) || (i < getOverScrollFooterHeight()));
      this.mOverscrollHeadState = 2;
    } while (this.mOverScrollViewListener == null);
    this.mOverScrollViewListener.onViewCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
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
    boolean bool3 = true;
    boolean bool2;
    if ((this.mAdapter == null) || (!this.mIsAttached))
    {
      bool2 = false;
      return bool2;
    }
    if (this.mDataChanged) {
      layoutChildren();
    }
    int k = paramKeyEvent.getAction();
    if (k != 1) {}
    label144:
    boolean bool1;
    int i;
    switch (paramInt1)
    {
    default: 
      bool1 = false;
      i = paramInt2;
    }
    for (;;)
    {
      bool2 = bool3;
      if (bool1) {
        break;
      }
      bool2 = bool3;
      if (sendToTextFilter(paramInt1, i, paramKeyEvent)) {
        break;
      }
      switch (k)
      {
      default: 
        return false;
        int j;
        if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
        {
          bool2 = resurrectSelectionIfNeeded();
          bool1 = bool2;
          i = paramInt2;
          if (!bool2) {
            for (;;)
            {
              j = paramInt2 - 1;
              bool1 = bool2;
              i = j;
              if (paramInt2 <= 0) {
                break;
              }
              bool1 = bool2;
              i = j;
              if (!arrowScroll(33)) {
                break;
              }
              bool2 = true;
              paramInt2 = j;
            }
          }
        }
        else
        {
          if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
            break label144;
          }
          if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
          {
            bool1 = true;
            i = paramInt2;
          }
          else
          {
            bool1 = false;
            i = paramInt2;
            continue;
            if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
            {
              bool2 = resurrectSelectionIfNeeded();
              bool1 = bool2;
              i = paramInt2;
              if (!bool2) {
                for (;;)
                {
                  j = paramInt2 - 1;
                  bool1 = bool2;
                  i = j;
                  if (paramInt2 <= 0) {
                    break;
                  }
                  bool1 = bool2;
                  i = j;
                  if (!arrowScroll(130)) {
                    break;
                  }
                  bool2 = true;
                  paramInt2 = j;
                }
              }
            }
            else
            {
              if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                break label144;
              }
              if ((resurrectSelectionIfNeeded()) || (fullScroll(130)))
              {
                bool1 = true;
                i = paramInt2;
              }
              else
              {
                bool1 = false;
                i = paramInt2;
                continue;
                if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = handleHorizontalFocusWithinListItem(17);
                i = paramInt2;
                continue;
                if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool1 = handleHorizontalFocusWithinListItem(66);
                i = paramInt2;
                continue;
                if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                  break label144;
                }
                bool2 = resurrectSelectionIfNeeded();
                bool1 = bool2;
                i = paramInt2;
                if (!bool2)
                {
                  bool1 = bool2;
                  i = paramInt2;
                  if (paramKeyEvent.getRepeatCount() == 0)
                  {
                    bool1 = bool2;
                    i = paramInt2;
                    if (getChildCount() > 0)
                    {
                      keyPressed();
                      bool1 = true;
                      i = paramInt2;
                      continue;
                      if ((this.mPopup != null) && (this.mPopup.isShowing())) {
                        break label144;
                      }
                      if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers())) {
                        if ((resurrectSelectionIfNeeded()) || (!pageScroll(130))) {}
                      }
                      for (;;)
                      {
                        bool1 = true;
                        i = paramInt2;
                        break;
                        if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(1)) || (resurrectSelectionIfNeeded()) || (!pageScroll(33))) {}
                      }
                      if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
                      {
                        if ((resurrectSelectionIfNeeded()) || (pageScroll(33)))
                        {
                          bool1 = true;
                          i = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          i = paramInt2;
                        }
                      }
                      else
                      {
                        if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                          break label144;
                        }
                        if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
                        {
                          bool1 = true;
                          i = paramInt2;
                        }
                        else
                        {
                          bool1 = false;
                          i = paramInt2;
                          continue;
                          if ((VersionUtils.isHoneycomb()) && (paramKeyEvent.hasNoModifiers()))
                          {
                            if ((resurrectSelectionIfNeeded()) || (pageScroll(130)))
                            {
                              bool1 = true;
                              i = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              i = paramInt2;
                            }
                          }
                          else
                          {
                            if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasModifiers(2))) {
                              break label144;
                            }
                            if ((resurrectSelectionIfNeeded()) || (fullScroll(130)))
                            {
                              bool1 = true;
                              i = paramInt2;
                            }
                            else
                            {
                              bool1 = false;
                              i = paramInt2;
                              continue;
                              if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                                break label144;
                              }
                              if ((resurrectSelectionIfNeeded()) || (fullScroll(33)))
                              {
                                bool1 = true;
                                i = paramInt2;
                              }
                              else
                              {
                                bool1 = false;
                                i = paramInt2;
                                continue;
                                if ((!VersionUtils.isHoneycomb()) || (!paramKeyEvent.hasNoModifiers())) {
                                  break label144;
                                }
                                if ((resurrectSelectionIfNeeded()) || (fullScroll(130)))
                                {
                                  bool1 = true;
                                  i = paramInt2;
                                }
                                else
                                {
                                  bool1 = false;
                                  i = paramInt2;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return super.onKeyDown(paramInt1, paramKeyEvent);
    return super.onKeyUp(paramInt1, paramKeyEvent);
    return super.onKeyMultiple(paramInt1, i, paramKeyEvent);
  }
  
  private void correctTooHigh(int paramInt)
  {
    if ((this.mFirstPosition + paramInt - 1 == this.mItemCount - 1) && (paramInt > 0))
    {
      paramInt = getChildAt(paramInt - 1).getBottom();
      int i = getBottom() - this.mTop - this.mListPadding.bottom - paramInt;
      View localView = getChildAt(0);
      int j = localView.getTop();
      if ((i > 0) && ((this.mFirstPosition > 0) || (j < this.mListPadding.top)))
      {
        paramInt = i;
        if (this.mFirstPosition == 0) {
          paramInt = Math.min(i, this.mListPadding.top - j);
        }
        offsetChildrenTopAndBottom(paramInt);
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
    int m;
    if ((this.mFirstPosition == 0) && (paramInt > 0))
    {
      int i = getChildAt(0).getTop();
      int k = this.mListPadding.top;
      int j = getBottom() - this.mTop - this.mListPadding.bottom;
      i -= k;
      View localView = getChildAt(paramInt - 1);
      k = localView.getBottom();
      m = this.mFirstPosition + paramInt - 1;
      if (i > 0)
      {
        if ((m >= this.mItemCount - 1) && (k <= j)) {
          break label162;
        }
        paramInt = i;
        if (m == this.mItemCount - 1) {
          paramInt = Math.min(i, k - j);
        }
        offsetChildrenTopAndBottom(-paramInt);
        if (m < this.mItemCount - 1)
        {
          fillDown(m + 1, localView.getBottom() + this.mDividerHeight);
          adjustViewsUpOrDown();
        }
      }
    }
    label162:
    while (m != this.mItemCount - 1) {
      return;
    }
    adjustViewsUpOrDown();
  }
  
  private void detachedWindow(View paramView)
  {
    try
    {
      Object localObject = View.class.getDeclaredField("mAttachInfo");
      ((Field)localObject).setAccessible(true);
      if (((Field)localObject).get(paramView) != null)
      {
        localObject = View.class.getDeclaredMethod("dispatchDetachedFromWindow", new Class[0]);
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(paramView, new Object[0]);
      }
      return;
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView.getMessage(), paramView);
    }
  }
  
  private int distanceToView(View paramView)
  {
    int i = 0;
    paramView.getDrawingRect(this.mTempRect);
    offsetDescendantRectToMyCoords(paramView, this.mTempRect);
    int j = this.mBottom - this.mTop - this.mListPadding.bottom;
    if (this.mTempRect.bottom < this.mListPadding.top) {
      i = this.mListPadding.top - this.mTempRect.bottom;
    }
    while (this.mTempRect.top <= j) {
      return i;
    }
    return this.mTempRect.top - j;
  }
  
  private void fillAboveAndBelow(View paramView, int paramInt)
  {
    int i = this.mDividerHeight;
    if (!this.mStackFromBottom)
    {
      fillUp(paramInt - 1, paramView.getTop() - i);
      adjustViewsUpOrDown();
      fillDown(paramInt + 1, i + paramView.getBottom());
      return;
    }
    fillDown(paramInt + 1, paramView.getBottom() + i);
    adjustViewsUpOrDown();
    fillUp(paramInt - 1, paramView.getTop() - i);
  }
  
  private View fillDown(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i = this.mBottom - this.mTop;
    int j;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i -= this.mListPadding.bottom;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      boolean bool;
      if ((paramInt1 < i) && (paramInt2 < this.mItemCount)) {
        if (paramInt2 == this.mSelectedPosition)
        {
          bool = true;
          label67:
          View localView = makeAndAddView(paramInt2, paramInt1, true, this.mListPadding.left, bool);
          if (localView == null) {
            break label133;
          }
          j = localView.getBottom() + this.mDividerHeight;
          paramInt1 = j;
          if (!bool) {
            break label133;
          }
          paramInt1 = j;
          localObject = localView;
        }
      }
      label133:
      for (;;)
      {
        paramInt2 += 1;
        break;
        bool = false;
        break label67;
        return localObject;
      }
      j = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
    }
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
    }
    for (;;)
    {
      fillAboveAndBelow(localView, i);
      if (this.mStackFromBottom) {
        break;
      }
      correctTooHigh(getChildCount());
      return localView;
      if (localView.getTop() < paramInt2) {
        localView.offsetTopAndBottom(Math.min(paramInt2 - localView.getTop(), paramInt3 - localView.getBottom()));
      }
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
    View localView5;
    if (paramInt1 == this.mSelectedPosition)
    {
      bool = true;
      localView5 = makeAndAddView(paramInt1, paramInt2, true, this.mListPadding.left, bool);
      if (localView5 != null) {
        break label40;
      }
    }
    label40:
    View localView2;
    for (;;)
    {
      return localView5;
      bool = false;
      break;
      this.mFirstPosition = paramInt1;
      paramInt2 = this.mDividerHeight;
      View localView3;
      View localView4;
      View localView1;
      if (!this.mStackFromBottom)
      {
        localView3 = fillUp(paramInt1 - 1, localView5.getTop() - paramInt2);
        adjustViewsUpOrDown();
        localView4 = fillDown(paramInt1 + 1, paramInt2 + localView5.getBottom());
        paramInt1 = getChildCount();
        localView1 = localView3;
        localView2 = localView4;
        if (paramInt1 > 0)
        {
          correctTooHigh(paramInt1);
          localView2 = localView4;
          localView1 = localView3;
        }
      }
      while (!bool)
      {
        if (localView1 == null) {
          break label204;
        }
        return localView1;
        localView3 = fillDown(paramInt1 + 1, localView5.getBottom() + paramInt2);
        adjustViewsUpOrDown();
        localView4 = fillUp(paramInt1 - 1, localView5.getTop() - paramInt2);
        paramInt1 = getChildCount();
        localView1 = localView4;
        localView2 = localView3;
        if (paramInt1 > 0)
        {
          correctTooLow(paramInt1);
          localView1 = localView4;
          localView2 = localView3;
        }
      }
    }
    label204:
    return localView2;
  }
  
  private View fillSpecificBottom(int paramInt1, int paramInt2)
  {
    boolean bool;
    View localView5;
    if (paramInt1 == this.mSelectedPosition)
    {
      bool = true;
      localView5 = makeAndAddView(paramInt1, paramInt2, false, this.mListPadding.left, bool);
      if (localView5 != null) {
        break label40;
      }
    }
    label40:
    View localView2;
    for (;;)
    {
      return localView5;
      bool = false;
      break;
      this.mFirstPosition = paramInt1;
      paramInt2 = this.mDividerHeight;
      View localView3;
      View localView4;
      View localView1;
      if (!this.mStackFromBottom)
      {
        localView3 = fillUp(paramInt1 - 1, localView5.getTop() - paramInt2);
        adjustViewsUpOrDown();
        localView4 = fillDown(paramInt1 + 1, paramInt2 + localView5.getBottom());
        paramInt1 = getChildCount();
        localView1 = localView3;
        localView2 = localView4;
        if (paramInt1 > 0)
        {
          correctTooHigh(paramInt1);
          localView2 = localView4;
          localView1 = localView3;
        }
      }
      while (!bool)
      {
        if (localView1 == null) {
          break label204;
        }
        return localView1;
        localView3 = fillDown(paramInt1 + 1, localView5.getBottom() + paramInt2);
        adjustViewsUpOrDown();
        localView4 = fillUp(paramInt1 - 1, localView5.getTop() - paramInt2);
        paramInt1 = getChildCount();
        localView1 = localView4;
        localView2 = localView3;
        if (paramInt1 > 0)
        {
          correctTooLow(paramInt1);
          localView1 = localView4;
          localView2 = localView3;
        }
      }
    }
    label204:
    return localView2;
  }
  
  private View fillUp(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    int i;
    int j;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      i = this.mListPadding.top;
      j = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = j;
    }
    for (;;)
    {
      if ((paramInt1 > i) && (paramInt2 >= 0))
      {
        boolean bool;
        if (paramInt2 == this.mSelectedPosition)
        {
          bool = true;
          label51:
          View localView = makeAndAddView(paramInt2, paramInt1, false, this.mListPadding.left, bool);
          if (localView == null) {
            break label114;
          }
          j = localView.getTop() - this.mDividerHeight;
          paramInt1 = j;
          if (!bool) {
            break label124;
          }
          paramInt1 = j;
          localObject = localView;
        }
        label114:
        label124:
        for (;;)
        {
          paramInt2 -= 1;
          break;
          bool = false;
          break label51;
          QLog.e("XListView", 1, "fillUp childis null");
        }
      }
      this.mFirstPosition = (paramInt2 + 1);
      return localObject;
      j = 0;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      i = j;
    }
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
    boolean bool2 = true;
    if (paramInt2 == -1) {
      throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }
    int i = this.mSelectedPosition - this.mFirstPosition;
    paramInt2 -= this.mFirstPosition;
    int j;
    View localView1;
    boolean bool1;
    if (paramInt1 == 33)
    {
      View localView2 = getChildAt(paramInt2);
      paramInt1 = i;
      j = 1;
      localView1 = paramView;
      paramView = localView2;
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = j;
      j = getChildCount();
      if (paramView != null)
      {
        if ((paramBoolean) || (paramInt1 == 0)) {
          break label154;
        }
        bool1 = true;
        label92:
        paramView.setSelected(bool1);
        measureAndAdjustDown(paramView, i, j);
      }
      if (localView1 != null) {
        if ((paramBoolean) || (paramInt1 != 0)) {
          break label160;
        }
      }
    }
    label154:
    label160:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localView1.setSelected(paramBoolean);
      measureAndAdjustDown(localView1, paramInt2, j);
      return;
      localView1 = getChildAt(paramInt2);
      paramInt1 = 0;
      break;
      bool1 = false;
      break label92;
    }
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
    if (((paramView1 instanceof ViewGroup)) && (isViewAncestorOf((View)paramView1, paramView2))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int lookForSelectablePositionOnScreen(int paramInt)
  {
    int j = this.mFirstPosition;
    ListAdapter localListAdapter;
    if (paramInt == 130)
    {
      if (this.mSelectedPosition != -1) {}
      for (i = this.mSelectedPosition + 1; i >= this.mAdapter.getCount(); i = j)
      {
        paramInt = -1;
        return paramInt;
      }
      paramInt = i;
      if (i < j) {
        paramInt = j;
      }
      int k = getLastVisiblePosition();
      localListAdapter = getAdapter();
      i = paramInt;
      for (;;)
      {
        if (i > k) {
          break label215;
        }
        if (localListAdapter.isEnabled(i))
        {
          paramInt = i;
          if (getChildAt(i - j).getVisibility() == 0) {
            break;
          }
        }
        i += 1;
      }
    }
    int i = getChildCount() + j - 1;
    if (this.mSelectedPosition != -1) {}
    for (paramInt = this.mSelectedPosition - 1; (paramInt < 0) || (paramInt >= this.mAdapter.getCount()); paramInt = getChildCount() + j - 1) {
      return -1;
    }
    if (paramInt > i) {}
    for (;;)
    {
      localListAdapter = getAdapter();
      for (;;)
      {
        if (i < j) {
          break label215;
        }
        if (localListAdapter.isEnabled(i))
        {
          paramInt = i;
          if (getChildAt(i - j).getVisibility() == 0) {
            break;
          }
        }
        i -= 1;
      }
      label215:
      return -1;
      i = paramInt;
    }
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
      paramInt1 += 1;
      while (paramInt1 < paramInt2)
      {
        getChildAt(paramInt1).offsetTopAndBottom(j - i);
        paramInt1 += 1;
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
    if (i > 0) {}
    for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(j, i);
      return;
    }
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
        paramInt2 = Math.min(Math.min(k - i, m - j), paramInt2);
        paramView1.offsetTopAndBottom(-paramInt2);
        paramView2.offsetTopAndBottom(-paramInt2);
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
      if (paramView2 != null) {}
      for (paramView1 = makeAndAddView(k, paramView2.getTop(), true, this.mListPadding.left, true);; paramView1 = makeAndAddView(k, paramView1.getTop(), false, this.mListPadding.left, true))
      {
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
        return i + this.mFirstPosition;
      }
      i += 1;
    }
    throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
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
    for (;;)
    {
      if (i < j)
      {
        if (((ListView.FixedViewInfo)paramArrayList.get(i)).view == paramView) {
          paramArrayList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  private void scrollListItemsBy(int paramInt)
  {
    offsetChildrenTopAndBottom(paramInt);
    int i = getHeight() - this.mListPadding.bottom;
    int j = this.mListPadding.top;
    AbsListView.RecycleBin localRecycleBin = this.mRecycler;
    View localView;
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
        offsetChildrenTopAndBottom(i - localView.getBottom());
      }
      localView = getChildAt(0);
      if (localView.getBottom() < j)
      {
        if (localRecycleBin.shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))
        {
          detachViewFromParent(localView);
          localRecycleBin.addScrapView(localView, this.mFirstPosition);
        }
        for (;;)
        {
          localView = getChildAt(0);
          this.mFirstPosition += 1;
          break;
          removeViewInLayout(localView);
        }
      }
    }
    else
    {
      localView = getChildAt(0);
      while ((localView.getTop() > j) && (this.mFirstPosition > 0))
      {
        localView = addViewAbove(localView, this.mFirstPosition);
        this.mFirstPosition -= 1;
      }
      if (localView.getTop() > j) {
        offsetChildrenTopAndBottom(j - localView.getTop());
      }
      paramInt = getChildCount() - 1;
      localView = getChildAt(paramInt);
      if (localView.getTop() > i)
      {
        if (localRecycleBin.shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))
        {
          detachViewFromParent(localView);
          localRecycleBin.addScrapView(localView, this.mFirstPosition + paramInt);
        }
        for (;;)
        {
          paramInt -= 1;
          localView = getChildAt(paramInt);
          break;
          removeViewInLayout(localView);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void setupChild(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {}
    for (int i = -1;; i = 0)
    {
      setupChild(paramView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, paramBoolean3, i);
      return;
    }
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
    if (paramBoolean2) {}
    try
    {
      if (!shouldShowSelector()) {
        break label435;
      }
      paramBoolean2 = true;
    }
    catch (NullPointerException paramView)
    {
      for (;;)
      {
        int j;
        try
        {
          AbsListView.LayoutParams localLayoutParams;
          paramView.measure(j, paramInt4);
          traceEnd();
          paramInt4 = paramView.getMeasuredWidth();
          j = paramView.getMeasuredHeight();
          if (!paramBoolean1) {
            break label642;
          }
          if (i == 0) {
            break label609;
          }
          traceBegin("ListView.childLayout");
          paramView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, j + paramInt2);
          traceEnd();
          if ((this.mCachingStarted) && (!paramView.isDrawingCacheEnabled())) {
            paramView.setDrawingCacheEnabled(true);
          }
          if ((VersionUtils.isHoneycomb()) && (paramBoolean3) && (((AbsListView.LayoutParams)paramView.getLayoutParams()).scrappedFromPosition != paramInt1)) {
            paramView.jumpDrawablesToCurrentState();
          }
          traceEnd();
          return;
          paramBoolean2 = false;
          continue;
          j = 0;
          continue;
          boolean bool = false;
          continue;
          int k = 0;
          continue;
          i = 0;
          continue;
          localLayoutParams.forceAdd = false;
          if (localLayoutParams.viewType == -2) {
            localLayoutParams.recycledHeaderFooter = true;
          }
          addViewInLayout(paramView, paramInt4, localLayoutParams, true);
          continue;
          paramView = paramView;
          setStatisticCollector();
          continue;
          if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.isHoneycomb())) {
            continue;
          }
          paramView.setActivated(this.mCheckStates.get(paramInt1));
          continue;
          paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("XListView", 2, localStringIndexOutOfBoundsException.getStackTrace());
          continue;
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("XListView", 2, localException.getStackTrace());
          continue;
        }
        cleanupLayoutState(paramView);
        continue;
        paramView.offsetLeftAndRight(paramInt3 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt2 - paramView.getTop());
        continue;
        continue;
        int i = 1;
        continue;
        paramInt2 -= j;
      }
    }
    if (paramBoolean2 != paramView.isSelected())
    {
      j = 1;
      i = this.mTouchMode;
      if ((i <= 0) || (i >= 3) || (this.mMotionPosition != paramInt1)) {
        break label447;
      }
      bool = true;
      if (bool == paramView.isPressed()) {
        break label453;
      }
      k = 1;
      if ((!paramBoolean3) || (j != 0)) {
        break label636;
      }
      if (!paramView.isLayoutRequested()) {
        break label459;
      }
      break label636;
      localLayoutParams = (AbsListView.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label633;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
      localLayoutParams.viewType = this.mAdapter.getItemViewType(paramInt1);
      if (((!paramBoolean3) || (localLayoutParams.forceAdd)) && ((!localLayoutParams.recycledHeaderFooter) || (localLayoutParams.viewType != -2))) {
        break label465;
      }
      attachViewToParent(paramView, paramInt4, localLayoutParams);
      if (j != 0) {
        paramView.setSelected(paramBoolean2);
      }
      if (k != 0) {
        paramView.setPressed(bool);
      }
      if ((this.mChoiceMode != 0) && (this.mCheckStates != null))
      {
        if (!(paramView instanceof Checkable)) {
          break label509;
        }
        ((Checkable)paramView).setChecked(this.mCheckStates.get(paramInt1));
      }
      if (i == 0) {
        break label601;
      }
      j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, localLayoutParams.width);
      paramInt4 = localLayoutParams.height;
      if (paramInt4 <= 0) {
        break label545;
      }
      paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
      traceBegin("ListView.childMeasure");
    }
  }
  
  private boolean showingBottomFadingEdge()
  {
    int i = getChildCount();
    int j = getChildAt(i - 1).getBottom();
    int k = this.mFirstPosition;
    int m = getScrollY();
    int n = getHeight();
    int i1 = this.mListPadding.bottom;
    return (i + k - 1 < this.mItemCount - 1) || (j < m + n - i1);
  }
  
  private boolean showingTopFadingEdge()
  {
    boolean bool = false;
    int i = this.mScrollY;
    int j = this.mListPadding.top;
    if ((this.mFirstPosition > 0) || (getChildAt(0).getTop() > i + j)) {
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
        offsetChildrenTopAndBottom(-i);
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
    AbsListView.LayoutParams localLayoutParams;
    if (j == k)
    {
      localView = this.mAdapter.getView(paramInt1, paramView, this);
      localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams != null) {
        break label506;
      }
      localLayoutParams = new AbsListView.LayoutParams(-1, -2, 0);
    }
    label221:
    label478:
    label506:
    for (;;)
    {
      localLayoutParams.viewType = k;
      if (localView != paramView)
      {
        bool1 = paramView.isSelected();
        boolean bool2 = paramView.isPressed();
        this.mRecycler.addScrapView(paramView, paramInt1);
        if (this.mCacheColorHint != 0) {
          localView.setDrawingCacheBackgroundColor(this.mCacheColorHint);
        }
        detachViewFromParent(paramInt4);
        addViewInLayout(localView, paramInt4, localLayoutParams, true);
        if (localView.isSelected() != bool1) {
          localView.setSelected(bool1);
        }
        if (localView.isPressed() != bool2) {
          localView.setPressed(bool2);
        }
        if ((this.mChoiceMode != 0) && (this.mCheckStates != null))
        {
          if (!(localView instanceof Checkable)) {
            break label414;
          }
          ((Checkable)localView).setChecked(this.mCheckStates.get(paramInt1));
        }
      }
      boolean bool1 = localView.isLayoutRequested();
      if (bool1)
      {
        j = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, localLayoutParams.width);
        paramInt4 = localLayoutParams.height;
        if (paramInt4 > 0)
        {
          paramInt4 = View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824);
          localView.measure(j, paramInt4);
          paramInt4 = localView.getMeasuredWidth();
          j = localView.getMeasuredHeight();
          if (!paramBoolean) {
            break label470;
          }
          if (!bool1) {
            break label478;
          }
          localView.layout(paramInt3, paramInt2, paramInt4 + paramInt3, j + paramInt2);
        }
      }
      for (;;)
      {
        if ((this.mCachingStarted) && (!localView.isDrawingCacheEnabled())) {
          localView.setDrawingCacheEnabled(true);
        }
        if ((VersionUtils.isHoneycomb()) && (((AbsListView.LayoutParams)localView.getLayoutParams()).scrappedFromPosition != paramInt1)) {
          localView.jumpDrawablesToCurrentState();
        }
        return localView.getHeight() - i;
        localView = this.mAdapter.getView(paramInt1, this.mRecycler.getScrapView(paramInt1), this);
        break;
        if ((getContext().getApplicationInfo().targetSdkVersion < 11) || (!VersionUtils.isHoneycomb())) {
          break label221;
        }
        localView.setActivated(this.mCheckStates.get(paramInt1));
        break label221;
        paramInt4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label284;
        cleanupLayoutState(localView);
        break label293;
        paramInt2 -= j;
        break label312;
        localView.offsetLeftAndRight(paramInt3 - localView.getLeft());
        localView.offsetTopAndBottom(paramInt2 - localView.getTop());
      }
    }
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
    if ((this.mAdapter != null) && (!(this.mAdapter instanceof bjqx))) {
      throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }
    if (paramView == null) {}
    do
    {
      return;
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
    } while ((this.mAdapter == null) || (this.mDataSetObserver == null));
    this.mDataSetObserver.onChanged();
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
    int i1 = this.mDividerHeight;
    Drawable localDrawable1 = this.mOverScrollHeader;
    ListView.OverscrollViewContainer localOverscrollViewContainer1 = this.mOverscrollHeaderViewContainer;
    ListView.OverscrollViewContainer localOverscrollViewContainer2 = this.mOverscrollFooterView;
    Drawable localDrawable2 = this.mOverScrollFooter;
    Drawable localDrawable3 = this.mOverScrollHeaderShadow;
    int m;
    int k;
    label79:
    int n;
    label94:
    Rect localRect;
    int i2;
    int j;
    int i3;
    Object localObject;
    label238:
    label244:
    int i4;
    boolean bool1;
    label416:
    Paint localPaint;
    int i10;
    if ((localDrawable1 != null) || (localOverscrollViewContainer1 != null) || (localDrawable3 != null))
    {
      m = 1;
      if ((localDrawable2 == null) && (localOverscrollViewContainer2 == null)) {
        break label773;
      }
      k = 1;
      if ((i1 <= 0) || (this.mDivider == null)) {
        break label779;
      }
      n = 1;
      if (this.mContentBackgroundDrawable != null)
      {
        localRect = this.mTempRect;
        localRect.top = 0;
        localRect.bottom = getHeight();
        localRect.left = 0;
        localRect.right = getWidth();
        i2 = paramCanvas.save();
        if (this.mScrollY > 0)
        {
          localRect.top += this.mScrollY;
          localRect.bottom += this.mScrollY;
        }
        if (this.mUseEfficientMode)
        {
          j = 0;
          i3 = getChildCount();
          i = j;
          if (i3 > 0)
          {
            localObject = getChildAt(i3 - 1);
            i = j;
            if (localObject != null)
            {
              if (getLastVisiblePosition() != getCount() - 1) {
                break label785;
              }
              i = ((View)localObject).getTop();
            }
          }
          if (i >= 0) {
            break label794;
          }
          j = 0;
          paramCanvas.clipRect(0, j, localRect.right, localRect.bottom);
        }
        this.mContentBackgroundDrawable.setBounds(localRect);
        this.mContentBackgroundDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
      if ((n == 0) && (m == 0) && (k == 0)) {
        break label929;
      }
      localRect = this.mTempRect;
      localRect.left = this.mPaddingLeft;
      localRect.right = (this.mRight - this.mLeft - this.mPaddingRight);
      i2 = getChildCount();
      int i5 = this.mHeaderViewInfos.size();
      i3 = this.mItemCount;
      int i6 = this.mFooterViewInfos.size();
      boolean bool2 = this.mHeaderDividersEnabled;
      boolean bool3 = this.mFooterDividersEnabled;
      i4 = this.mFirstPosition;
      boolean bool4 = this.mAreAllItemsSelectable;
      localObject = this.mAdapter;
      if (!VersionUtils.isECLAIR_MR1()) {
        break label820;
      }
      if ((!isOpaque()) || (super.isOpaque())) {
        break label814;
      }
      bool1 = true;
      if ((bool1) && (this.mDividerPaint == null) && (this.mIsCacheColorOpaque))
      {
        this.mDividerPaint = new Paint();
        this.mDividerPaint.setColor(getCacheColorHint());
      }
      localPaint = this.mDividerPaint;
      i = 0;
      if ((this.mGroupFlags & 0x22) == 34) {
        i = this.mListPadding.bottom;
      }
      int i7 = this.mBottom;
      int i8 = this.mTop;
      int i9 = getScrollY();
      i10 = getScrollY();
      if ((i2 > 0) && (i10 < 0))
      {
        if (m != 0)
        {
          localRect.bottom = (this.mListPadding.top + 0 - this.mDividerHeight + this.mOverScrollHeaderTopOffset);
          localRect.top = (this.mListPadding.top + i10 + this.mOverScrollHeaderTopOffset);
          drawOverscrollHeader(paramCanvas, localOverscrollViewContainer1, localDrawable3, localDrawable1, localRect);
        }
        if (n != 0)
        {
          localRect.bottom = 0;
          localRect.top = (-i1);
          drawDivider(paramCanvas, localRect, -1);
        }
      }
      if (n == 0) {
        break label862;
      }
      j = 0;
      label615:
      if (j >= i2) {
        break label862;
      }
      if (((bool2) || (i4 + j >= i5)) && ((bool3) || (i4 + j < i3 - i6 - 1)))
      {
        m = getChildAt(j).getBottom();
        if ((m < i9 + (i7 - i8 - i)) && ((k == 0) || (j != i2 - 1)))
        {
          if ((!bool4) && ((!((ListAdapter)localObject).isEnabled(i4 + j)) || ((j != i2 - 1) && (!((ListAdapter)localObject).isEnabled(i4 + j + 1))))) {
            break label829;
          }
          localRect.top = m;
          localRect.bottom = (m + i1);
          drawDivider(paramCanvas, localRect, j);
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label615;
      m = 0;
      break;
      label773:
      k = 0;
      break label79;
      label779:
      n = 0;
      break label94;
      label785:
      i = ((View)localObject).getBottom();
      break label238;
      label794:
      j = i;
      if (i <= localRect.bottom) {
        break label244;
      }
      j = localRect.bottom;
      break label244;
      label814:
      bool1 = false;
      break label416;
      label820:
      bool1 = isOpaque();
      break label416;
      label829:
      if (bool1)
      {
        localRect.top = m;
        localRect.bottom = (m + i1);
        paramCanvas.drawRect(localRect, localPaint);
      }
    }
    label862:
    int i = this.mBottom + i10 + this.mDividerHeight;
    if ((k != 0) && (i4 + i2 == i3) && (i > this.mBottom))
    {
      localRect.top = (this.mBottom + this.mDividerHeight);
      localRect.bottom = i;
      drawOverscrollFooter(paramCanvas, localOverscrollViewContainer2, localDrawable2, localRect);
    }
    label929:
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
    try
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if (this.mCachingActive) {
        this.mCachingActive = false;
      }
      return bool;
    }
    catch (Exception paramCanvas)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("XListView", 2, paramCanvas.getStackTrace());
        }
        boolean bool = false;
      }
    }
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
        paramRect.bottom = (i + paramRect.top);
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
      if (j >= paramRect.height()) {
        break label162;
      }
      Rect localRect = new Rect(paramRect);
      localRect.top = (localRect.top + paramRect.height() - j);
      paramDrawable1.setBounds(localRect);
    }
    for (;;)
    {
      paramDrawable1.draw(paramCanvas);
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
      return;
      label162:
      paramDrawable1.setBounds(paramRect);
    }
  }
  
  void fillGap(boolean paramBoolean)
  {
    int j = getChildCount();
    if (paramBoolean) {
      if ((this.mGroupFlags & 0x22) != 34) {
        break label138;
      }
    }
    label138:
    for (int i = getListPaddingTop();; i = 0)
    {
      if (j > 0) {
        i = getChildAt(j - 1).getBottom() + this.mDividerHeight;
      }
      fillDown(this.mFirstPosition + j, i);
      correctTooHigh(getChildCount());
      return;
      if ((this.mGroupFlags & 0x22) == 34) {}
      for (i = getListPaddingBottom();; i = 0)
      {
        if (j > 0) {}
        for (i = getChildAt(0).getTop() - this.mDividerHeight;; i = getHeight() - i)
        {
          fillUp(this.mFirstPosition - 1, i);
          correctTooLow(getChildCount());
          return;
        }
      }
    }
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
            return i + this.mFirstPosition;
          }
          i += 1;
        }
      }
      int i = j - 1;
      while (i >= 0)
      {
        if (paramInt >= getChildAt(i).getTop()) {
          return i + this.mFirstPosition;
        }
        i -= 1;
      }
    }
    return -1;
  }
  
  boolean fullScroll(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 33)
    {
      if (this.mSelectedPosition == 0) {
        break label123;
      }
      paramInt = lookForSelectablePosition(0, true);
      bool1 = bool2;
      if (paramInt >= 0)
      {
        this.mLayoutMode = 1;
        setSelectionInt(paramInt);
        invokeOnItemScrollListener();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if ((bool1) && (!awakenScrollBars()))
      {
        awakenScrollBars();
        invalidate();
      }
      return bool1;
      if ((paramInt == 130) && (this.mSelectedPosition < this.mItemCount - 1))
      {
        paramInt = lookForSelectablePosition(this.mItemCount - 1, true);
        bool1 = bool2;
        if (paramInt >= 0)
        {
          this.mLayoutMode = 3;
          setSelectionInt(paramInt);
          invokeOnItemScrollListener();
          bool1 = bool2;
        }
      }
      else
      {
        label123:
        bool1 = false;
      }
    }
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
    Object localObject;
    int m;
    long[] arrayOfLong;
    int j;
    int i;
    if ((this.mChoiceMode != 0) && (this.mCheckStates != null) && (this.mAdapter != null))
    {
      localObject = this.mCheckStates;
      m = ((SparseBooleanArray)localObject).size();
      arrayOfLong = new long[m];
      ListAdapter localListAdapter = this.mAdapter;
      j = 0;
      i = 0;
      if (j < m)
      {
        if (!((SparseBooleanArray)localObject).valueAt(j)) {
          break label150;
        }
        int k = i + 1;
        arrayOfLong[i] = localListAdapter.getItemId(((SparseBooleanArray)localObject).keyAt(j));
        i = k;
      }
    }
    label150:
    for (;;)
    {
      j += 1;
      break;
      if (i == m) {
        return arrayOfLong;
      }
      localObject = new long[i];
      System.arraycopy(arrayOfLong, 0, localObject, 0, i);
      return localObject;
      return new long[0];
    }
  }
  
  public long getDelAnimationDuration()
  {
    if (this.delAnimDuration > 0L) {
      return this.delAnimDuration;
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
    return this.mHeaderViewLevelIndex[paramInt] - this.mHeaderViewLevelIndex[(paramInt - 1)];
  }
  
  public boolean getItemsCanFocus()
  {
    return this.mItemsCanFocus;
  }
  
  public int getListViewScrollY()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return getScrollY();
    }
    int k = getFirstVisiblePosition();
    if (k >= this.mHeaderViewInfos.size())
    {
      Iterator localIterator = this.mHeaderViewInfos.iterator();
      for (i = 0; localIterator.hasNext(); i = ((ListView.FixedViewInfo)localIterator.next()).view.getHeight() + i) {}
      return -localView.getTop() + (k - this.mHeaderViewInfos.size()) * localView.getHeight() + i;
    }
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view.getHeight();
      i += 1;
    }
    return -localView.getTop() + j;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(0.33F * (getBottom() - this.mTop));
  }
  
  public int getOverScrollFooterHeight()
  {
    if ((this.mOverScrollFooterHeight == 0) && (this.mOverscrollFooterView != null)) {
      return this.mOverscrollFooterView.getHeight();
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
    if ((this.mOverScrollHeight == 0) && (this.mOverscrollHeaderViewContainer != null)) {
      return this.mOverscrollHeaderViewContainer.getHeight();
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
    int j = 0;
    int k = getScrollY();
    boolean bool;
    if ((this.mOverscrollHeaderViewContainer != null) && (k < 0)) {
      if (k <= -getOverScrollHeight())
      {
        if (this.mOverscrollHeadState != 2) {
          break label291;
        }
        if (this.mOverScrollViewListener == null) {
          break label285;
        }
        bool = this.mOverScrollViewListener.onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
        this.mOverscrollHeadState = 3;
      }
    }
    for (;;)
    {
      int i;
      if (bool)
      {
        i = j;
        if (this.mOverscrollHeaderViewContainer != null) {
          i = -getOverScrollHeight();
        }
      }
      do
      {
        do
        {
          do
          {
            return i;
            this.mOverscrollHeadState = 0;
            return 0;
            i = j;
          } while (this.mOverscrollHeadState >= 2);
          if (this.mOverScrollViewListener != null) {
            this.mOverScrollViewListener.onViewNotCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
          }
          this.mOverscrollHeadState = 0;
          return 0;
          i = j;
        } while (this.mOverscrollFooterView == null);
        i = j;
      } while (k <= 0);
      if (k >= getOverScrollFooterHeight())
      {
        if (this.mOverscrollHeadState != 2) {
          break label279;
        }
        if (this.mOverScrollViewListener == null) {
          break label273;
        }
        bool = this.mOverScrollViewListener.onViewCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
        label199:
        this.mOverscrollHeadState = 3;
      }
      for (;;)
      {
        if (bool)
        {
          i = j;
          if (this.mOverscrollFooterView == null) {
            break;
          }
          return getOverScrollFooterHeight();
        }
        this.mOverscrollHeadState = 0;
        return 0;
        i = j;
        if (this.mOverscrollHeadState >= 2) {
          break;
        }
        if (this.mOverScrollViewListener != null) {
          this.mOverScrollViewListener.onViewNotCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
        }
        this.mOverscrollHeadState = 0;
        return 0;
        label273:
        bool = false;
        break label199;
        label279:
        bool = false;
      }
      label285:
      bool = false;
      break;
      label291:
      bool = false;
    }
  }
  
  public void hideOverScrollHeaderView()
  {
    if (this.mScrollY < 0)
    {
      abordFling();
      if (!this.mStackFromBottom)
      {
        setSelectionFromTop(this.mFirstPosition, this.mListPadding.top - this.mScrollY);
        onScrollChanged(0, 0, 0, this.mScrollY);
        this.mScrollY = 0;
      }
    }
    else
    {
      this.mOverscrollHeadState = 0;
      return;
    }
    this.mLayoutMode = 100;
    View localView = getChildAt(0);
    if (localView == null) {}
    for (int i = 0;; i = this.mLayoutHeight - localView.getBottom() - this.mListPadding.bottom)
    {
      setSelectionFromBottom(this.mFirstPosition, i + this.mScrollY);
      break;
    }
  }
  
  protected void initPaddingManual() {}
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    int i;
    if ((paramRect.bottom > 0) && (paramRect.top < getHeight()))
    {
      i = getScrollY();
      if ((i >= 0) || (paramRect.top + i >= 0)) {
        break label50;
      }
      invalidateWithoutNotiyParent(paramRect);
    }
    label50:
    while ((i <= 0) || (paramRect.bottom <= getHeight() - i)) {
      return paramArrayOfInt;
    }
    invalidateWithoutNotiyParent(paramRect);
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
    return (this.mScrollY > 0) && (this.mOverscrollFooterView != null);
  }
  
  public boolean isOverscrollHeadVisiable()
  {
    return (this.mScrollY < 0) && (this.mOverscrollHeaderViewContainer != null);
  }
  
  protected void layoutChildren()
  {
    boolean bool1 = this.mBlockLayoutRequests;
    if (!bool1)
    {
      this.mBlockLayoutRequests = true;
      traceBegin("ListView.layoutChildren");
    }
    int j;
    int m;
    int i1;
    int n;
    int i;
    View localView1;
    View localView3;
    Object localObject5;
    int k;
    View localView2;
    label230:
    boolean bool2;
    try
    {
      super.layoutChildren();
      invalidate();
      if (this.mAdapter == null)
      {
        resetList();
        invokeOnItemScrollListener();
        return;
      }
      j = this.mListPadding.top;
      m = this.mBottom - this.mTop - this.mListPadding.bottom;
      i1 = getChildCount();
      n = this.mFirstPosition + i1 - 1;
      i = 0;
      localView1 = null;
      localView3 = null;
      localObject5 = null;
      switch (this.mLayoutMode)
      {
      case 2: 
        k = this.mSelectedPosition - this.mFirstPosition;
        Object localObject1 = localView1;
        if (k >= 0)
        {
          localObject1 = localView1;
          if (k < i1) {
            localObject1 = getChildAt(k);
          }
        }
        localView2 = getChildAt(0);
        localView1 = getChildAt(i1 - 1);
        if (this.mNextSelectedPosition >= 0) {
          i = this.mNextSelectedPosition - this.mSelectedPosition;
        }
        localView3 = getChildAt(k + i);
        for (;;)
        {
          bool2 = this.mDataChanged;
          if (bool2) {
            handleDataChanged();
          }
          if (this.mItemCount != 0) {
            break;
          }
          resetList();
          invokeOnItemScrollListener();
          return;
          i = this.mNextSelectedPosition - this.mFirstPosition;
          if ((i < 0) || (i >= i1)) {
            break label1526;
          }
          localView3 = getChildAt(i);
          localView1 = null;
          localView2 = null;
          localObject1 = null;
          i = 0;
        }
        if (this.mItemCount != this.mAdapter.getCount())
        {
          localObject1 = this.mAdapter.getClass();
          if ((this.mAdapter instanceof bjqx)) {
            localObject1 = ((bjqx)this.mAdapter).getWrappedAdapter().getClass();
          }
          throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + localObject1 + ")]mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.mAdapter.getCount() + ",adapter.addr = " + this.mAdapter.toString());
        }
        break;
      }
    }
    finally
    {
      if (!bool1) {
        this.mBlockLayoutRequests = false;
      }
      traceEnd();
    }
    setSelectedPositionInt(this.mNextSelectedPosition);
    int i2 = this.mFirstPosition;
    AbsListView.RecycleBin localRecycleBin = this.mRecycler;
    Object localObject4 = null;
    if (bool2)
    {
      k = 0;
      while (k < i1)
      {
        localRecycleBin.addScrapView(getChildAt(k), i2 + k);
        k += 1;
      }
    }
    localRecycleBin.fillActiveViews(i1, i2);
    Object localObject6 = getFocusedChild();
    label595:
    label612:
    Object localObject3;
    if (localObject6 != null)
    {
      if ((!bool2) || (isDirectChildHeaderOrFooter((View)localObject6)))
      {
        localObject5 = findFocus();
        if (localObject5 == null) {
          break label1557;
        }
        ((View)localObject5).onStartTemporaryDetach();
        break label1557;
      }
      requestFocus();
      localObject6 = localObject4;
      localObject4 = localObject5;
      localObject5 = localObject6;
      detachAllViewsFromParent();
      switch (this.mLayoutMode)
      {
      case 2: 
        label688:
        if (i1 == 0) {
          if (!this.mStackFromBottom)
          {
            setSelectedPositionInt(lookForSelectablePosition(0, true));
            localObject3 = fillFromTop(j);
            label717:
            stayOnTheTop();
            localRecycleBin.scrapActiveViews();
            if (localObject3 == null) {
              break label1417;
            }
            if ((!this.mItemsCanFocus) || (!hasFocus()) || (((View)localObject3).hasFocus())) {
              break label1407;
            }
            if ((localObject3 == localObject5) && (localObject4 != null) && (localObject4.requestFocus())) {
              break label1567;
            }
            if (!((View)localObject3).requestFocus()) {
              break label1579;
            }
          }
        }
        break;
      }
    }
    for (;;)
    {
      label784:
      if (i == 0)
      {
        localView1 = getFocusedChild();
        if (localView1 != null) {
          localView1.clearFocus();
        }
        positionSelector(-1, (View)localObject3);
        label811:
        this.mSelectedTop = ((View)localObject3).getTop();
        label820:
        if ((localObject4 != null) && (localObject4.getWindowToken() != null)) {
          localObject4.onFinishTemporaryDetach();
        }
        this.mLayoutMode = 0;
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateScrollIndicators();
        if (this.mItemCount > 0) {
          checkSelectionChanged();
        }
        invokeOnItemScrollListener();
        j = this.mFirstPosition + getChildCount() - 1;
        if ((this.mInsertAnimation == null) || (this.mAddingRows == null) || (!bool2) || (this.mItemCount <= 0) || (j < this.mItemCount - 1) || (getChildAt(getChildCount() - 1).getBottom() >= m)) {
          break label1498;
        }
        localObject3 = this.mAddingRows;
        k = localObject3.length;
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          m = localObject3[i];
          if ((m < this.mFirstPosition) || (m > j)) {
            break label1572;
          }
          getChildAt(m - this.mFirstPosition).startAnimation(this.mInsertAnimation);
          break label1572;
          if (localView3 != null)
          {
            localObject3 = fillFromSelection(localView3.getTop(), j, m);
            break label717;
          }
          localObject3 = fillFromMiddle(j, m);
          break label717;
          if (!this.mStackFromBottom)
          {
            localObject3 = fillSpecific(this.mSyncPosition, this.mSpecificTop);
            break label717;
          }
          localObject3 = fillSpecificBottom(this.mSyncPosition, this.mLayoutHeight - this.mSpecificBottom);
          break label717;
          localObject3 = fillUp(this.mItemCount - 1, m);
          adjustViewsUpOrDown();
          break label717;
          this.mFirstPosition = 0;
          localObject3 = fillFromTop(j);
          adjustViewsUpOrDown();
          break label717;
          localObject3 = fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
          break label717;
          localObject3 = fillSpecificBottom(reconcileSelectedPosition(), this.mLayoutHeight - this.mSpecificBottom);
          break label717;
          localObject3 = moveSelection((View)localObject3, localView3, i, j, m);
          break label717;
          setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
          localObject3 = fillUp(this.mItemCount - 1, m);
          break label717;
          if ((this.mSelectedPosition >= 0) && (this.mSelectedPosition < this.mItemCount))
          {
            i = this.mSelectedPosition;
            if (localObject3 == null) {}
            for (;;)
            {
              localObject3 = fillSpecific(i, j);
              break;
              j = ((View)localObject3).getTop();
            }
          }
          if (((this.mScrollY == 0) && (!this.mStackFromBottom)) || (this.mScrollY < 0))
          {
            if (this.mFirstPosition < this.mItemCount)
            {
              i = this.mFirstPosition;
              if (localView2 == null) {}
              for (;;)
              {
                localObject3 = fillSpecific(i, j);
                break;
                j = localView2.getTop();
              }
            }
            localObject3 = fillSpecific(0, j);
            break label717;
          }
          if (n < this.mItemCount)
          {
            if (localView1 == null) {}
            for (i = m;; i = localView1.getBottom())
            {
              localObject3 = fillSpecificBottom(n, i);
              break;
            }
          }
          localObject3 = fillSpecificBottom(this.mItemCount - 1, this.mLayoutHeight);
          break label717;
          ((View)localObject3).setSelected(false);
          this.mSelectorRect.setEmpty();
          break label811;
          label1407:
          positionSelector(-1, (View)localObject3);
          break label811;
          label1417:
          if ((this.mTouchMode > 0) && (this.mTouchMode < 3))
          {
            localObject3 = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (localObject3 != null) {
              positionSelector(this.mMotionPosition, (View)localObject3);
            }
          }
          for (;;)
          {
            if ((!hasFocus()) || (localObject4 == null)) {
              break label1496;
            }
            localObject4.requestFocus();
            break;
            this.mSelectedTop = 0;
            this.mSelectorRect.setEmpty();
          }
          label1496:
          break label820;
        }
        label1498:
        this.mAddingRows = null;
        if (!bool1) {
          this.mBlockLayoutRequests = false;
        }
        traceEnd();
        return;
        localObject4 = null;
        localObject5 = null;
        break label612;
        label1526:
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        i = 0;
        break label230;
        break;
        localView1 = null;
        localView2 = null;
        localObject3 = null;
        i = 0;
        break label230;
        label1557:
        localObject4 = localObject6;
        break label595;
        break label688;
        label1567:
        i = 1;
        break label784;
        label1572:
        i += 1;
      }
      label1579:
      i = 0;
    }
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = this.mAdapter;
    int i;
    if ((localListAdapter == null) || (isInTouchMode())) {
      i = -1;
    }
    int j;
    label125:
    do
    {
      do
      {
        return i;
        j = localListAdapter.getCount();
        if (this.mAreAllItemsSelectable) {
          break label125;
        }
        if (paramBoolean)
        {
          i = Math.max(0, paramInt);
          for (;;)
          {
            paramInt = i;
            if (i >= j) {
              break;
            }
            paramInt = i;
            if (localListAdapter.isEnabled(i)) {
              break;
            }
            i += 1;
          }
        }
        i = Math.min(paramInt, j - 1);
        for (;;)
        {
          paramInt = i;
          if (i < 0) {
            break;
          }
          paramInt = i;
          if (localListAdapter.isEnabled(i)) {
            break;
          }
          i -= 1;
        }
        if (paramInt < 0) {
          break;
        }
        i = paramInt;
      } while (paramInt < j);
      return -1;
      if (paramInt < 0) {
        break;
      }
      i = paramInt;
    } while (paramInt < j);
    return -1;
  }
  
  final int measureHeightOfChildren(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = 0;
    Object localObject = this.mAdapter;
    if (localObject == null)
    {
      paramInt1 = this.mListPadding.top + this.mListPadding.bottom;
      return paramInt1;
    }
    int m = this.mListPadding.top + this.mListPadding.bottom;
    int i;
    label69:
    boolean bool;
    label111:
    View localView;
    if ((this.mDividerHeight > 0) && (this.mDivider != null))
    {
      i = this.mDividerHeight;
      int j = paramInt3;
      if (paramInt3 == -1) {
        j = ((ListAdapter)localObject).getCount() - 1;
      }
      localObject = this.mRecycler;
      bool = recycleOnMeasure();
      boolean[] arrayOfBoolean = this.mIsScrap;
      paramInt3 = paramInt2;
      paramInt2 = m;
      if (paramInt3 > j) {
        break label265;
      }
      localView = obtainView(paramInt3, arrayOfBoolean);
      measureScrapChild(localView, paramInt3, paramInt1);
      if (paramInt3 <= 0) {
        break label267;
      }
      paramInt2 += i;
    }
    label265:
    label267:
    for (;;)
    {
      if ((bool) && (((AbsListView.RecycleBin)localObject).shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))) {
        ((AbsListView.RecycleBin)localObject).addScrapView(localView, -1);
      }
      paramInt2 = localView.getMeasuredHeight() + paramInt2;
      if (paramInt2 >= paramInt4)
      {
        paramInt1 = paramInt4;
        if (paramInt5 < 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt3 <= paramInt5) {
          break;
        }
        paramInt1 = paramInt4;
        if (k <= 0) {
          break;
        }
        paramInt1 = paramInt4;
        if (paramInt2 == paramInt4) {
          break;
        }
        return k;
        i = 0;
        break label69;
      }
      m = k;
      if (paramInt5 >= 0)
      {
        m = k;
        if (paramInt3 >= paramInt5) {
          m = paramInt2;
        }
      }
      paramInt3 += 1;
      k = m;
      break label111;
      return paramInt2;
    }
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
    if (paramInt1 > 0) {}
    for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt2, paramInt1);
      return;
    }
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
      }
      return;
    }
    catch (Exception paramView1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("XListView", 2, paramView1.getMessage(), paramView1);
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
    int k = 0;
    int j = 0;
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    ListAdapter localListAdapter = this.mAdapter;
    int i = -1;
    int n = k;
    int i1 = i;
    Rect localRect;
    int m;
    if (localListAdapter != null)
    {
      n = k;
      i1 = i;
      if (paramBoolean)
      {
        n = k;
        i1 = i;
        if (paramRect != null)
        {
          paramRect.offset(getScrollX(), getScrollY());
          if (localListAdapter.getCount() < getChildCount() + this.mFirstPosition)
          {
            this.mLayoutMode = 0;
            layoutChildren();
          }
          localRect = this.mTempRect;
          m = 2147483647;
          int i2 = getChildCount();
          int i3 = this.mFirstPosition;
          k = 0;
          n = j;
          i1 = i;
          if (k < i2) {
            if (!localListAdapter.isEnabled(i3 + k))
            {
              n = j;
              j = i;
              i = n;
            }
          }
        }
      }
    }
    for (;;)
    {
      n = k + 1;
      k = j;
      j = i;
      i = k;
      k = n;
      break;
      View localView = getChildAt(k);
      localView.getDrawingRect(localRect);
      offsetDescendantRectToMyCoords(localView, localRect);
      n = getDistance(paramRect, localRect, paramInt);
      if (n < m)
      {
        i = localView.getTop();
        j = k;
        m = n;
        continue;
        if (i1 >= 0)
        {
          setSelectionFromTop(this.mFirstPosition + i1, n);
          return;
        }
        requestLayout();
      }
      else
      {
        n = i;
        i = j;
        j = n;
      }
    }
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
    if (this.mOverscrollFooterView != null)
    {
      this.mOverscrollFooterView.layout(this.mListPadding.left, getMeasuredHeight() - this.mOverscrollFooterView.getMeasuredHeight() - this.mListPadding.bottom, this.mListPadding.left + this.mOverscrollFooterView.getMeasuredWidth(), getMeasuredHeight() - this.mListPadding.bottom);
      this.mBottomOverflingDistance = this.mOverscrollFooterView.getHeight();
    }
  }
  
  @TargetApi(11)
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i;
    int j;
    if (this.mAdapter == null)
    {
      paramInt2 = 0;
      this.mItemCount = paramInt2;
      if ((this.mItemCount <= 0) || ((i1 != 0) && (n != 0))) {
        break label362;
      }
      View localView = obtainView(0, this.mIsScrap);
      measureScrapChild(localView, 0, paramInt1);
      i = localView.getMeasuredWidth();
      j = localView.getMeasuredHeight();
      if (!VersionUtils.isHoneycomb()) {
        break label357;
      }
      paramInt2 = combineMeasuredStates(0, localView.getMeasuredState());
      label109:
      if ((recycleOnMeasure()) && (this.mRecycler.shouldRecycleViewType(((AbsListView.LayoutParams)localView.getLayoutParams()).viewType))) {
        this.mRecycler.addScrapView(localView, -1);
      }
    }
    for (;;)
    {
      if (i1 == 0) {
        paramInt2 = i + (this.mListPadding.left + this.mListPadding.right) + getVerticalScrollbarWidth();
      }
      for (;;)
      {
        i = k;
        if (n == 0) {
          i = this.mListPadding.top + this.mListPadding.bottom + j + getVerticalFadingEdgeLength() * 2;
        }
        j = i;
        if (n == -2147483648) {
          j = measureHeightOfChildren(paramInt1, 0, -1, i, -1);
        }
        setMeasuredDimension(paramInt2, j);
        this.mWidthMeasureSpec = paramInt1;
        if ((this.mOverscrollHeaderViewContainer != null) || (this.mOverscrollFooterView != null))
        {
          paramInt1 = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mListPadding.left + this.mListPadding.right, -1);
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          if (this.mOverscrollHeaderViewContainer != null) {
            this.mOverscrollHeaderViewContainer.measure(paramInt1, paramInt2);
          }
          if (this.mOverscrollFooterView != null) {
            this.mOverscrollFooterView.measure(paramInt1, paramInt2);
          }
        }
        return;
        paramInt2 = this.mAdapter.getCount();
        break;
        if (VersionUtils.isHoneycomb()) {
          paramInt2 = 0xFF000000 & paramInt2 | m;
        } else {
          paramInt2 = m;
        }
      }
      label357:
      paramInt2 = 0;
      break label109;
      label362:
      paramInt2 = 0;
      j = 0;
      i = 0;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) && (paramInt4 == 0) && (this.mOverscrollHeaderViewContainer != null)) {
      attachWindow(this.mOverscrollHeaderViewContainer);
    }
    for (;;)
    {
      if (this.mOnScrollChangeListener != null) {
        this.mOnScrollChangeListener.onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      if ((paramInt2 == 0) && (paramInt4 < 0) && (this.mOverscrollHeaderViewContainer != null)) {
        detachedWindow(this.mOverscrollHeaderViewContainer);
      } else if ((paramInt2 > 0) && (paramInt4 == 0) && (this.mOverscrollFooterView != null)) {
        attachWindow(this.mOverscrollFooterView);
      } else if ((paramInt2 == 0) && (paramInt4 > 0) && (this.mOverscrollFooterView != null)) {
        detachedWindow(this.mOverscrollFooterView);
      }
    }
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
        int k = Math.max(0, localView.getBottom() - (paramInt2 - this.mPaddingTop));
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
    if (i == 0) {}
    for (this.isTouchHolding = true;; this.isTouchHolding = false) {
      do
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        checkOverScrollHeaderIsVisable();
        return bool;
      } while ((i != 1) && (i != 3));
    }
  }
  
  boolean pageScroll(int paramInt)
  {
    boolean bool;
    if (paramInt == 33)
    {
      paramInt = Math.max(0, this.mSelectedPosition - getChildCount() - 1);
      bool = false;
    }
    for (;;)
    {
      if (paramInt >= 0)
      {
        paramInt = lookForSelectablePosition(paramInt, bool);
        if (paramInt >= 0)
        {
          this.mLayoutMode = 4;
          this.mSpecificTop = (this.mPaddingTop + getVerticalFadingEdgeLength());
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
          if (paramInt != 130) {
            break label153;
          }
          paramInt = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount() - 1);
          bool = true;
          continue;
        }
      }
      return false;
      label153:
      paramInt = -1;
      bool = false;
    }
  }
  
  @ViewDebug.ExportedProperty(category="list")
  protected boolean recycleOnMeasure()
  {
    return true;
  }
  
  public boolean removeFooterView(View paramView)
  {
    if (this.mFooterViewInfos.size() > 0)
    {
      if ((this.mAdapter == null) || (!((bjqx)this.mAdapter).b(paramView))) {
        break label60;
      }
      if (this.mDataSetObserver != null) {
        this.mDataSetObserver.onChanged();
      }
    }
    label60:
    for (boolean bool = true;; bool = false)
    {
      removeFixedViewInfo(paramView, this.mFooterViewInfos);
      return bool;
      return false;
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    int j = 0;
    int i;
    if ((this.mHeaderViewInfos.size() > 0) && (paramView != null))
    {
      int k = this.mHeaderViewInfos.size();
      i = 0;
      if (i >= k) {
        break label165;
      }
      if (((ListView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view != paramView) {}
    }
    for (;;)
    {
      if ((this.mAdapter != null) && (((bjqx)this.mAdapter).a(paramView))) {
        if (this.mDataSetObserver != null) {
          this.mDataSetObserver.onChanged();
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        removeFixedViewInfo(paramView, this.mHeaderViewInfos);
        boolean bool2 = bool1;
        if (i != -1)
        {
          for (;;)
          {
            bool2 = bool1;
            if (j >= 3) {
              break;
            }
            if (this.mHeaderViewLevelIndex[j] > i)
            {
              paramView = this.mHeaderViewLevelIndex;
              paramView[j] -= 1;
            }
            j += 1;
          }
          i += 1;
          break;
          bool2 = false;
        }
        return bool2;
      }
      label165:
      i = -1;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    int n = paramRect.top;
    paramRect.offset(paramView.getLeft(), paramView.getTop());
    paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
    int m = getHeight();
    int j = getScrollY();
    int k = j + m;
    int i1 = getVerticalFadingEdgeLength();
    int i = j;
    if (showingTopFadingEdge()) {
      if (this.mSelectedPosition <= 0)
      {
        i = j;
        if (n <= i1) {}
      }
      else
      {
        i = j + i1;
      }
    }
    n = getChildAt(getChildCount() - 1).getBottom();
    j = k;
    if (showingBottomFadingEdge()) {
      if (this.mSelectedPosition >= this.mItemCount - 1)
      {
        j = k;
        if (paramRect.bottom >= n - i1) {}
      }
      else
      {
        j = k - i1;
      }
    }
    if ((paramRect.bottom > j) && (paramRect.top > i)) {
      if (paramRect.height() > m)
      {
        i = paramRect.top - i + 0;
        i = Math.min(i, n - j);
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (paramBoolean)
        {
          scrollListItemsBy(-i);
          positionSelector(-1, paramView);
          this.mSelectedTop = paramView.getTop();
          invalidate();
        }
        return paramBoolean;
        i = paramRect.bottom - j + 0;
        break;
        if ((paramRect.top >= i) || (paramRect.bottom >= j)) {
          break label335;
        }
        if (paramRect.height() > m) {}
        for (j = 0 - (j - paramRect.bottom);; j = 0 - (i - paramRect.top))
        {
          i = Math.max(j, getChildAt(0).getTop() - i);
          break;
        }
      }
      label335:
      i = 0;
    }
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
    int i;
    if ((this.mHeaderViewInfos.size() > 0) || (this.mFooterViewInfos.size() > 0))
    {
      this.mAdapter = new bjqx(this.mHeaderViewInfos, this.mFooterViewInfos, paramListAdapter);
      this.mOldSelectedPosition = -1;
      this.mOldSelectedRowId = -9223372036854775808L;
      super.setAdapter(paramListAdapter);
      if (this.mAdapter == null) {
        break label244;
      }
      this.mAreAllItemsSelectable = this.mAdapter.areAllItemsEnabled();
      this.mOldItemCount = this.mItemCount;
      this.mItemCount = this.mAdapter.getCount();
      checkFocus();
      this.mDataSetObserver = new ListView.ListDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
      if (!this.mStackFromBottom) {
        break label234;
      }
      i = lookForSelectablePosition(this.mItemCount - 1, false);
      label200:
      setSelectedPositionInt(i);
      setNextSelectedPositionInt(i);
      if (this.mItemCount == 0) {
        checkSelectionChanged();
      }
    }
    for (;;)
    {
      requestLayout();
      return;
      this.mAdapter = paramListAdapter;
      break;
      label234:
      i = lookForSelectablePosition(0, true);
      break label200;
      label244:
      this.mAreAllItemsSelectable = true;
      checkFocus();
      checkSelectionChanged();
    }
  }
  
  public void setCacheColorHint(int paramInt)
  {
    if (paramInt >>> 24 == 255) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsCacheColorOpaque = bool;
      if (bool)
      {
        if (this.mDividerPaint == null) {
          this.mDividerPaint = new Paint();
        }
        this.mDividerPaint.setColor(paramInt);
      }
      super.setCacheColorHint(paramInt);
      return;
    }
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
    for (;;)
    {
      this.mUseEfficientMode = paramBoolean2;
      return;
      this.mContentBackgroundDrawable = paramDrawable;
      if (paramBoolean1) {
        this.mOverScrollHeaderShadow = getResources().getDrawable(2130840564);
      }
    }
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
    if (paramDrawable != null)
    {
      this.mDividerHeight = paramDrawable.getIntrinsicHeight();
      if (this.mDividerHeight >= 0) {
        break label69;
      }
    }
    label69:
    for (int i = 0;; i = this.mDividerHeight)
    {
      this.mDividerHeight = i;
      this.mDivider = paramDrawable;
      if ((paramDrawable == null) || (paramDrawable.getOpacity() == -1)) {
        bool = true;
      }
      this.mDividerIsOpaque = bool;
      requestLayout();
      invalidate();
      return;
      this.mDividerHeight = 0;
      break;
    }
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
    if (paramView == null) {
      if (this.mOverscrollFooterView != null)
      {
        this.mOverscrollFooterView.removeAllViewsInLayout();
        ListView.OverscrollViewContainer.access$200(this.mOverscrollFooterView, null);
        this.mOverscrollFooterView = null;
      }
    }
    for (;;)
    {
      this.mOverscrollHeadState = 0;
      this.mScrollY = 0;
      return;
      if (this.mOverscrollFooterView == null)
      {
        this.mOverscrollFooterView = new ListView.OverscrollViewContainer(getContext());
        ListView.OverscrollViewContainer.access$200(this.mOverscrollFooterView, this);
      }
      this.mOverscrollFooterView.removeAllViewsInLayout();
      this.mOverscrollFooterView.addView(paramView);
    }
  }
  
  public void setOverScrollFooterHeight(int paramInt)
  {
    this.mOverScrollFooterHeight = paramInt;
  }
  
  public void setOverScrollHeader(View paramView)
  {
    if (paramView == null) {
      if (this.mOverscrollHeaderViewContainer != null)
      {
        this.mOverscrollHeaderViewContainer.removeAllViewsInLayout();
        ListView.OverscrollViewContainer.access$200(this.mOverscrollHeaderViewContainer, null);
        this.mOverscrollHeaderViewContainer = null;
      }
    }
    for (;;)
    {
      this.mOverscrollHeadState = 0;
      this.mScrollY = 0;
      return;
      if (this.mOverscrollHeaderViewContainer == null)
      {
        this.mOverscrollHeaderViewContainer = new ListView.OverscrollViewContainer(getContext());
        ListView.OverscrollViewContainer.access$200(this.mOverscrollHeaderViewContainer, this);
      }
      this.mOverscrollHeaderViewContainer.removeAllViewsInLayout();
      this.mOverscrollHeaderViewContainer.addView(paramView);
    }
  }
  
  public void setOverScrollHeight(int paramInt)
  {
    this.mOverScrollHeight = paramInt;
  }
  
  public void setOverScrollListener(bjsd parambjsd)
  {
    this.mOverScrollViewListener = parambjsd;
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
    if (this.mAdapter == null) {}
    for (;;)
    {
      return;
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
      while (paramInt1 >= 0)
      {
        requestLayout();
        this.mLayoutMode = 100;
        if (this.mNeedSync)
        {
          this.mSyncPosition = paramInt1;
          this.mSyncRowId = this.mAdapter.getItemId(paramInt1);
        }
        this.mSpecificBottom = (this.mListPadding.bottom + paramInt2);
        return;
        this.mResurrectToPosition = paramInt1;
      }
    }
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    if (this.mAdapter == null) {}
    for (;;)
    {
      return;
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
      while (paramInt1 >= 0)
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
        return;
        this.mResurrectToPosition = paramInt1;
      }
    }
  }
  
  void setSelectionInt(int paramInt)
  {
    int i = 1;
    setNextSelectedPositionInt(paramInt);
    int j = this.mSelectedPosition;
    if (j >= 0) {
      if (paramInt != j - 1) {}
    }
    for (;;)
    {
      layoutChildren();
      if (i != 0) {
        awakenScrollBars();
      }
      return;
      if (paramInt != j + 1) {
        i = 0;
      }
    }
  }
  
  public void setStatisticCollector()
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter instanceof bjqx))
    {
      localListAdapter = ((bjqx)localListAdapter).getWrappedAdapter();
      if ((localListAdapter instanceof ExpandableListConnector))
      {
        ((ExpandableListConnector)localListAdapter).a().getClass().getName();
        return;
      }
      localListAdapter.getClass().getName();
      return;
    }
    if ((localListAdapter instanceof ExpandableListConnector))
    {
      ((ExpandableListConnector)localListAdapter).a().getClass().getName();
      return;
    }
    localListAdapter.getClass().getName();
  }
  
  public void showOverScrollFooter()
  {
    scrollTo(0, getOverScrollFooterHeight() + 1);
    if ((this.mOverScrollViewListener != null) && (this.mOverscrollFooterView != null))
    {
      if (!this.mOverScrollViewListener.onViewCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this)) {
        springBackOverScrollView();
      }
    }
    else {
      return;
    }
    this.mOverscrollHeadState = 3;
  }
  
  public void showOverScrollHeader()
  {
    scrollTo(0, -getOverScrollHeight() - 1);
    if ((this.mOverScrollViewListener != null) && (this.mOverscrollHeaderViewContainer != null))
    {
      if (!this.mOverScrollViewListener.onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this)) {
        springBackOverScrollView();
      }
    }
    else {
      return;
    }
    this.mOverscrollHeadState = 3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.ListView
 * JD-Core Version:    0.7.0.1
 */