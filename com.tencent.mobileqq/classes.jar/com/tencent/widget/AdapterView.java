package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;

public abstract class AdapterView<T extends Adapter>
  extends ViewGroup
{
  public static final boolean DEBUG = false;
  public static final int INVALID_POSITION = -1;
  public static final long INVALID_ROW_ID = -9223372036854775808L;
  public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
  public static final int ITEM_VIEW_TYPE_IGNORE = -1;
  static final int SYNC_FIRST_POSITION = 1;
  static final int SYNC_LAST_POSITION = 2;
  static final int SYNC_MAX_DURATION_MILLIS = 100;
  static final int SYNC_SELECTED_POSITION = 0;
  public static final String TAG = "XListView";
  boolean mBlockLayoutRequests = false;
  boolean mDataChanged;
  private boolean mDesiredFocusableInTouchModeState;
  private boolean mDesiredFocusableState;
  private View mEmptyView;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int mFirstPosition = 0;
  boolean mInLayout = false;
  @ViewDebug.ExportedProperty(category="list")
  protected int mItemCount;
  int mLayoutHeight;
  boolean mNeedSync = false;
  @ViewDebug.ExportedProperty(category="list")
  int mNextSelectedPosition = -1;
  long mNextSelectedRowId = -9223372036854775808L;
  int mOldItemCount;
  protected int mOldSelectedPosition = -1;
  long mOldSelectedRowId = -9223372036854775808L;
  AdapterView.OnItemClickListener mOnItemClickListener;
  AdapterView.OnItemLongClickListener mOnItemLongClickListener;
  AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  @ViewDebug.ExportedProperty(category="list")
  protected int mSelectedPosition = -1;
  long mSelectedRowId = -9223372036854775808L;
  private AdapterView<T>.SelectionNotifier mSelectionNotifier;
  int mSpecificBottom;
  int mSpecificTop;
  long mSyncHeight;
  int mSyncMode;
  int mSyncPosition;
  long mSyncRowId = -9223372036854775808L;
  private float mVerticalScrollFactor;
  
  public AdapterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fireOnSelected()
  {
    if (this.mOnItemSelectedListener == null) {
      return;
    }
    int i = getSelectedItemPosition();
    if (i >= 0)
    {
      View localView = getSelectedView();
      this.mOnItemSelectedListener.onItemSelected(this, localView, i, getAdapter().getItemId(i));
      return;
    }
    this.mOnItemSelectedListener.onNothingSelected(this);
  }
  
  protected static int getStyleableValue(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return -1;
  }
  
  protected static int[] getStyleableValues(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString)
    {
      label22:
      break label22;
    }
    return new int[0];
  }
  
  private boolean isScrollableForAccessibility()
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAdapter != null)
    {
      int i = localAdapter.getCount();
      bool1 = bool2;
      if (i > 0) {
        if (getFirstVisiblePosition() <= 0)
        {
          bool1 = bool2;
          if (getLastVisiblePosition() >= i - 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void traceBegin(String paramString)
  {
    TraceUtils.traceBegin(paramString);
  }
  
  public static void traceEnd() {}
  
  private void updateEmptyStatus(boolean paramBoolean)
  {
    if (isInFilterMode()) {
      paramBoolean = false;
    }
    View localView;
    if (paramBoolean)
    {
      localView = this.mEmptyView;
      if (localView != null)
      {
        localView.setVisibility(0);
        setVisibility(8);
      }
      else
      {
        setVisibility(0);
      }
      if (this.mDataChanged) {
        onLayout(false, getLeft(), getTop(), getRight(), getBottom());
      }
    }
    else
    {
      localView = this.mEmptyView;
      if (localView != null) {
        localView.setVisibility(8);
      }
      setVisibility(0);
    }
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.mItemCount > 0);
  }
  
  void checkFocus()
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i != 0) && (!isInFilterMode())) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool1;
    if ((i != 0) && (this.mDesiredFocusableInTouchModeState)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    super.setFocusableInTouchMode(bool1);
    if ((i != 0) && (this.mDesiredFocusableState)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    super.setFocusable(bool1);
    if (this.mEmptyView != null)
    {
      if (localAdapter != null)
      {
        bool1 = bool2;
        if (!localAdapter.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      updateEmptyStatus(bool1);
    }
  }
  
  void checkSelectionChanged()
  {
    if ((this.mSelectedPosition != this.mOldSelectedPosition) || (this.mSelectedRowId != this.mOldSelectedRowId))
    {
      selectionChanged();
      this.mOldSelectedPosition = this.mSelectedPosition;
      this.mOldSelectedRowId = this.mSelectedRowId;
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = getSelectedView();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  int findSyncPosition()
  {
    int i = this.mItemCount;
    if (i == 0) {
      return -1;
    }
    long l1 = this.mSyncRowId;
    int j = this.mSyncPosition;
    if (l1 == -9223372036854775808L) {
      return -1;
    }
    j = Math.max(0, j);
    int i2 = i - 1;
    int m = Math.min(i2, j);
    long l2 = SystemClock.uptimeMillis();
    Adapter localAdapter = getAdapter();
    if (localAdapter == null) {
      return -1;
    }
    i = m;
    int k = i;
    j = i;
    for (i = m;; i = j)
    {
      for (m = 0;; m = 1)
      {
        int n;
        int i1;
        do
        {
          if (SystemClock.uptimeMillis() > l2 + 100L) {
            break label206;
          }
          if (localAdapter.getItemId(i) == l1) {
            return i;
          }
          if (j == i2) {
            n = 1;
          } else {
            n = 0;
          }
          if (k == 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if ((n != 0) && (i1 != 0)) {
            return -1;
          }
          if ((i1 != 0) || ((m != 0) && (n == 0))) {
            break;
          }
        } while ((n == 0) && ((m != 0) || (i1 != 0)));
        k -= 1;
        i = k;
      }
      j += 1;
    }
    label206:
    return -1;
  }
  
  public abstract T getAdapter();
  
  @ViewDebug.CapturedViewProperty
  public int getCount()
  {
    return this.mItemCount;
  }
  
  public View getEmptyView()
  {
    return this.mEmptyView;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.mFirstPosition;
  }
  
  public Object getItemAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter != null) && (paramInt >= 0)) {
      return localAdapter.getItem(paramInt);
    }
    return null;
  }
  
  public long getItemIdAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter != null) && (paramInt >= 0)) {
      return localAdapter.getItemId(paramInt);
    }
    return -9223372036854775808L;
  }
  
  public int getLastVisiblePosition()
  {
    return this.mFirstPosition + getChildCount() - 1;
  }
  
  public final AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.mOnItemClickListener;
  }
  
  public final AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.mOnItemLongClickListener;
  }
  
  public final AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.mOnItemSelectedListener;
  }
  
  public int getPositionForView(View paramView)
  {
    try
    {
      for (;;)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        paramView = localView;
      }
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).equals(paramView)) {
          return this.mFirstPosition + i;
        }
        i += 1;
      }
      return -1;
    }
    catch (ClassCastException|NullPointerException paramView) {}
    return -1;
  }
  
  protected int getQQGroupFlag()
  {
    return ((Integer)ReflectionUtil.a(this, "android.view.ViewGroup", "mGroupFlags", Integer.valueOf(0))).intValue();
  }
  
  protected int getQQPersistentDrawingCache()
  {
    return ((Integer)ReflectionUtil.a(this, "android.view.ViewGroup", "mPersistentDrawingCache", Integer.valueOf(0))).intValue();
  }
  
  public Object getSelectedItem()
  {
    Adapter localAdapter = getAdapter();
    int i = getSelectedItemPosition();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  @ViewDebug.CapturedViewProperty
  public long getSelectedItemId()
  {
    return this.mNextSelectedRowId;
  }
  
  @ViewDebug.CapturedViewProperty
  public int getSelectedItemPosition()
  {
    return this.mNextSelectedPosition;
  }
  
  public abstract View getSelectedView();
  
  protected float getVerticalScrollFactor()
  {
    if (this.mVerticalScrollFactor == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.mVerticalScrollFactor = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return this.mVerticalScrollFactor;
  }
  
  void handleDataChanged()
  {
    int k = this.mItemCount;
    int m = 1;
    int i;
    if (k > 0)
    {
      if (this.mNeedSync)
      {
        this.mNeedSync = false;
        i = findSyncPosition();
        if ((i >= 0) && (lookForSelectablePosition(i, true) == i))
        {
          setNextSelectedPositionInt(i);
          i = 1;
          break label55;
        }
      }
      i = 0;
      label55:
      if (i == 0)
      {
        int j = getSelectedItemPosition();
        if (j >= k) {
          j = k - 1;
        }
        k = j;
        if (j < 0) {
          k = 0;
        }
        int n = lookForSelectablePosition(k, true);
        j = n;
        if (n < 0) {
          j = lookForSelectablePosition(k, false);
        }
        if (j >= 0)
        {
          setNextSelectedPositionInt(j);
          checkSelectionChanged();
          i = m;
          break label131;
        }
      }
    }
    else
    {
      i = 0;
    }
    label131:
    if (i == 0)
    {
      this.mSelectedPosition = -1;
      this.mSelectedRowId = -9223372036854775808L;
      this.mNextSelectedPosition = -1;
      this.mNextSelectedRowId = -9223372036854775808L;
      this.mNeedSync = false;
      checkSelectionChanged();
    }
  }
  
  protected void invalidateParentCaches()
  {
    if ((getParent() instanceof View)) {
      try
      {
        Field localField = ReflectionUtil.a("android.view.View", "mPrivateFlags");
        localField.setAccessible(true);
        int i = localField.getInt(getParent());
        localField.set(getParent(), Integer.valueOf(i | 0x80000000));
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("XListView", 2, localException.getMessage(), localException);
        }
        ((View)getParent()).invalidate();
      }
    }
  }
  
  @TargetApi(11)
  protected void invalidateParentIfNeeded()
  {
    if ((VersionUtils.e()) && (isHardwareAccelerated()) && ((getParent() instanceof View))) {
      ((View)getParent()).invalidate();
    }
  }
  
  boolean isInFilterMode()
  {
    return false;
  }
  
  @TargetApi(14)
  public boolean isInScrollingContainer()
  {
    if (VersionUtils.d()) {
      for (ViewParent localViewParent = getParent(); (localViewParent != null) && ((localViewParent instanceof ViewGroup)); localViewParent = localViewParent.getParent()) {
        if (((ViewGroup)localViewParent).shouldDelayChildPressedState()) {
          return true;
        }
      }
    }
    return false;
  }
  
  int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  public void offsetChildrenTopAndBottomWrap(int paramInt)
  {
    ReflectionUtil.a(this, "android.view.ViewGroup", "offsetChildrenTopAndBottom", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mSelectionNotifier);
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setScrollable(isScrollableForAccessibility());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityEvent.setEnabled(localView.isEnabled());
    }
    paramAccessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
    paramAccessibilityEvent.setFromIndex(getFirstVisiblePosition());
    paramAccessibilityEvent.setToIndex(getLastVisiblePosition());
    paramAccessibilityEvent.setItemCount(getCount());
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    try
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    paramAccessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
    View localView = getSelectedView();
    if (localView != null) {
      paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLayoutHeight = getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    try
    {
      if (super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(localAccessibilityEvent);
        paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
        paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
        return true;
      }
    }
    catch (Exception paramView)
    {
      QLog.e("AdapterView", 1, paramView, new Object[0]);
    }
    return false;
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.mOnItemClickListener.onItemClick(this, paramView, paramInt, paramLong);
      return true;
    }
    return false;
  }
  
  void rememberSyncState()
  {
    if (getChildCount() > 0)
    {
      this.mNeedSync = true;
      this.mSyncHeight = this.mLayoutHeight;
      int i = this.mSelectedPosition;
      if (i >= 0)
      {
        localView = getChildAt(i - this.mFirstPosition);
        this.mSyncRowId = this.mNextSelectedRowId;
        this.mSyncPosition = this.mNextSelectedPosition;
        if (localView != null) {
          this.mSpecificTop = localView.getTop();
        }
        this.mSyncMode = 0;
        return;
      }
      View localView = getChildAt(0);
      Adapter localAdapter = getAdapter();
      i = this.mFirstPosition;
      if ((i >= 0) && (i < localAdapter.getCount())) {
        this.mSyncRowId = localAdapter.getItemId(this.mFirstPosition);
      } else {
        this.mSyncRowId = -1L;
      }
      this.mSyncPosition = this.mFirstPosition;
      if (localView != null) {
        this.mSpecificTop = localView.getTop();
      }
      this.mSyncMode = 1;
    }
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  void selectionChanged()
  {
    if (this.mOnItemSelectedListener != null) {
      if ((!this.mInLayout) && (!this.mBlockLayoutRequests))
      {
        fireOnSelected();
      }
      else
      {
        if (this.mSelectionNotifier == null) {
          this.mSelectionNotifier = new AdapterView.SelectionNotifier(this, null);
        }
        post(this.mSelectionNotifier);
      }
    }
    if ((this.mSelectedPosition != -1) && (isShown()) && (!isInTouchMode())) {
      sendAccessibilityEvent(4);
    }
  }
  
  public abstract void setAdapter(T paramT);
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
    paramView = getAdapter();
    boolean bool;
    if ((paramView != null) && (!paramView.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    updateEmptyStatus(bool);
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    Adapter localAdapter = getAdapter();
    boolean bool = true;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    this.mDesiredFocusableState = paramBoolean;
    if (!paramBoolean) {
      this.mDesiredFocusableInTouchModeState = false;
    }
    if (paramBoolean)
    {
      paramBoolean = bool;
      if (i == 0) {
        break label71;
      }
      if (isInFilterMode())
      {
        paramBoolean = bool;
        break label71;
      }
    }
    paramBoolean = false;
    label71:
    super.setFocusable(paramBoolean);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    Adapter localAdapter = getAdapter();
    boolean bool2 = false;
    int i;
    if ((localAdapter != null) && (localAdapter.getCount() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    this.mDesiredFocusableInTouchModeState = paramBoolean;
    if (paramBoolean) {
      this.mDesiredFocusableState = true;
    }
    boolean bool1 = bool2;
    if (paramBoolean) {
      if (i != 0)
      {
        bool1 = bool2;
        if (!isInFilterMode()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    super.setFocusableInTouchMode(bool1);
  }
  
  void setNextSelectedPositionInt(int paramInt)
  {
    this.mNextSelectedPosition = paramInt;
    this.mNextSelectedRowId = getItemIdAtPosition(paramInt);
    if ((this.mNeedSync) && (this.mSyncMode == 0) && (paramInt >= 0))
    {
      this.mSyncPosition = paramInt;
      this.mSyncRowId = this.mNextSelectedRowId;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.mOnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.mOnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  protected void setQQGroupFlag(int paramInt)
  {
    ReflectionUtil.a(this, "android.view.ViewGroup", "mGroupFlags", Integer.valueOf(paramInt));
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    this.mSelectedPosition = paramInt;
    this.mSelectedRowId = getItemIdAtPosition(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AdapterView
 * JD-Core Version:    0.7.0.1
 */