package com.tencent.widget;

import alky;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
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
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;

public abstract class AdapterView
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
  public boolean mDataChanged;
  private boolean mDesiredFocusableInTouchModeState;
  private boolean mDesiredFocusableState;
  private View mEmptyView;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int mFirstPosition;
  boolean mInLayout = false;
  @ViewDebug.ExportedProperty(category="list")
  public int mItemCount;
  int mLayoutHeight;
  public boolean mNeedSync = false;
  @ViewDebug.ExportedProperty(category="list")
  int mNextSelectedPosition = -1;
  long mNextSelectedRowId = -9223372036854775808L;
  int mOldItemCount;
  public int mOldSelectedPosition = -1;
  long mOldSelectedRowId = -9223372036854775808L;
  AdapterView.OnItemClickListener mOnItemClickListener;
  AdapterView.OnItemLongClickListener mOnItemLongClickListener;
  AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  @ViewDebug.ExportedProperty(category="list")
  public int mSelectedPosition = -1;
  public long mSelectedRowId = -9223372036854775808L;
  private alky mSelectionNotifier;
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
      this.mOnItemSelectedListener.b(this, localView, i, getAdapter().getItemId(i));
      return;
    }
    this.mOnItemSelectedListener.a(this);
  }
  
  protected static int getStyleableValue(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  protected static int[] getStyleableValues(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString) {}
    return new int[0];
  }
  
  private boolean isScrollableForAccessibility()
  {
    boolean bool2 = false;
    Adapter localAdapter = getAdapter();
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
    TraceUtils.a(paramString);
  }
  
  public static void traceEnd() {}
  
  private void updateEmptyStatus(boolean paramBoolean)
  {
    if (isInFilterMode()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (this.mEmptyView != null)
      {
        this.mEmptyView.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (this.mDataChanged) {
          onLayout(false, this.mLeft, this.mTop, this.mRight, this.mBottom);
        }
        return;
        setVisibility(0);
      }
    }
    if (this.mEmptyView != null) {
      this.mEmptyView.setVisibility(8);
    }
    setVisibility(0);
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
    boolean bool2 = false;
    Adapter localAdapter = getAdapter();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!isInFilterMode())) {
        break label111;
      }
      i = 1;
      label38:
      if ((i == 0) || (!this.mDesiredFocusableInTouchModeState)) {
        break label116;
      }
      bool1 = true;
      label51:
      super.setFocusableInTouchMode(bool1);
      if ((i == 0) || (!this.mDesiredFocusableState)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = true;; bool1 = false)
    {
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
      return;
      i = 0;
      break;
      i = 0;
      break label38;
      bool1 = false;
      break label51;
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
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  int findSyncPosition()
  {
    int i2 = this.mItemCount;
    int n;
    if (i2 == 0)
    {
      n = -1;
      return n;
    }
    long l1 = this.mSyncRowId;
    int i = this.mSyncPosition;
    if (l1 == -9223372036854775808L) {
      return -1;
    }
    i = Math.min(i2 - 1, Math.max(0, i));
    long l2 = SystemClock.uptimeMillis();
    int j = 0;
    Adapter localAdapter = getAdapter();
    label72:
    int i1;
    int k;
    if (localAdapter == null)
    {
      return -1;
      if ((i1 != 0) || ((j != 0) && (n == 0)))
      {
        k += 1;
        j = 0;
        i = k;
      }
    }
    for (;;)
    {
      int m;
      if (SystemClock.uptimeMillis() <= l2 + 100L)
      {
        n = i;
        if (localAdapter.getItemId(i) == l1) {
          break;
        }
        if (k != i2 - 1) {
          break label155;
        }
        n = 1;
        if (m != 0) {
          break label161;
        }
      }
      label155:
      label161:
      for (i1 = 1;; i1 = 0)
      {
        if ((n == 0) || (i1 == 0)) {
          break label165;
        }
        return -1;
        n = 0;
        break;
      }
      label165:
      break label72;
      if ((n != 0) || ((j == 0) && (i1 == 0)))
      {
        m -= 1;
        j = 1;
        i = m;
        continue;
        m = i;
        n = i;
        k = i;
        i = n;
      }
    }
  }
  
  public abstract Adapter getAdapter();
  
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
    if ((localAdapter == null) || (paramInt < 0)) {
      return null;
    }
    return localAdapter.getItem(paramInt);
  }
  
  public long getItemIdAtPosition(int paramInt)
  {
    Adapter localAdapter = getAdapter();
    if ((localAdapter == null) || (paramInt < 0)) {
      return -9223372036854775808L;
    }
    return localAdapter.getItemId(paramInt);
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
      j = getChildCount();
    }
    catch (ClassCastException paramView)
    {
      return -1;
    }
    catch (NullPointerException paramView)
    {
      return -1;
    }
    int j;
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i + this.mFirstPosition;
      }
      i += 1;
    }
    return -1;
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
      if (!getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      this.mVerticalScrollFactor = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
    }
    return this.mVerticalScrollFactor;
  }
  
  void handleDataChanged()
  {
    int m = this.mItemCount;
    int i;
    if (m > 0) {
      if (this.mNeedSync)
      {
        this.mNeedSync = false;
        i = findSyncPosition();
        if ((i >= 0) && (lookForSelectablePosition(i, true) == i))
        {
          setNextSelectedPositionInt(i);
          i = 1;
          if (i == 0)
          {
            int k = getSelectedItemPosition();
            int j = k;
            if (k >= m) {
              j = m - 1;
            }
            k = j;
            if (j < 0) {
              k = 0;
            }
            j = lookForSelectablePosition(k, true);
            if (j >= 0) {
              break label153;
            }
            j = lookForSelectablePosition(k, false);
            label97:
            if (j >= 0)
            {
              setNextSelectedPositionInt(j);
              checkSelectionChanged();
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.mSelectedPosition = -1;
        this.mSelectedRowId = -9223372036854775808L;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedRowId = -9223372036854775808L;
        this.mNeedSync = false;
        checkSelectionChanged();
      }
      return;
      continue;
      label153:
      break label97;
      i = 0;
      break;
      i = 0;
    }
  }
  
  protected void invalidateParentCaches()
  {
    if ((getParent() instanceof View)) {}
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
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
  
  @TargetApi(11)
  protected void invalidateParentIfNeeded()
  {
    if ((VersionUtils.e()) && (isHardwareAccelerated()) && ((getParent() instanceof View))) {
      ((View)getParent()).invalidate();
    }
  }
  
  public boolean isInFilterMode()
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
  
  public void onDetachedFromWindow()
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
      paramAccessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
      View localView = getSelectedView();
      if (localView != null) {
        paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    boolean bool = false;
    if (this.mOnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.mOnItemClickListener.a(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  void rememberSyncState()
  {
    if (getChildCount() > 0)
    {
      this.mNeedSync = true;
      this.mSyncHeight = this.mLayoutHeight;
      if (this.mSelectedPosition >= 0)
      {
        localView = getChildAt(this.mSelectedPosition - this.mFirstPosition);
        this.mSyncRowId = this.mNextSelectedRowId;
        this.mSyncPosition = this.mNextSelectedPosition;
        if (localView != null) {
          this.mSpecificTop = localView.getTop();
        }
        this.mSyncMode = 0;
      }
    }
    else
    {
      return;
    }
    View localView = getChildAt(0);
    Adapter localAdapter = getAdapter();
    if ((this.mFirstPosition >= 0) && (this.mFirstPosition < localAdapter.getCount())) {}
    for (this.mSyncRowId = localAdapter.getItemId(this.mFirstPosition);; this.mSyncRowId = -1L)
    {
      this.mSyncPosition = this.mFirstPosition;
      if (localView != null) {
        this.mSpecificTop = localView.getTop();
      }
      this.mSyncMode = 1;
      return;
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
  
  public void selectionChanged()
  {
    if (this.mOnItemSelectedListener != null)
    {
      if ((!this.mInLayout) && (!this.mBlockLayoutRequests)) {
        break label78;
      }
      if (this.mSelectionNotifier == null) {
        this.mSelectionNotifier = new alky(this, null);
      }
      post(this.mSelectionNotifier);
    }
    for (;;)
    {
      if ((this.mSelectedPosition != -1) && (isShown()) && (!isInTouchMode())) {
        sendAccessibilityEvent(4);
      }
      return;
      label78:
      fireOnSelected();
    }
  }
  
  public abstract void setAdapter(Adapter paramAdapter);
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
    paramView = getAdapter();
    if ((paramView == null) || (paramView.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      updateEmptyStatus(bool);
      return;
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = getAdapter();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.mDesiredFocusableState = paramBoolean;
      if (!paramBoolean) {
        this.mDesiredFocusableInTouchModeState = false;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!isInFilterMode()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusable(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = getAdapter();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.mDesiredFocusableInTouchModeState = paramBoolean;
      if (paramBoolean) {
        this.mDesiredFocusableState = true;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!isInFilterMode()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusableInTouchMode(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setNextSelectedPositionInt(int paramInt)
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
  
  public void setSelectedPositionInt(int paramInt)
  {
    this.mSelectedPosition = paramInt;
    this.mSelectedRowId = getItemIdAtPosition(paramInt);
  }
  
  public abstract void setSelection(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterView
 * JD-Core Version:    0.7.0.1
 */