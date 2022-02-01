package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class ExpandableListView
  extends ListView
{
  public static final int CHILD_INDICATOR_INHERIT = -1;
  private static final int[] CHILD_LAST_STATE_SET = { 16842918 };
  private static final int[] EMPTY_STATE_SET;
  private static final int EXPANDABLELISTVIEW_CHILDDIVIDER = getStyleableValue("ExpandableListView_childDivider");
  private static final int EXPANDABLELISTVIEW_CHILDINDICATOR;
  private static final int EXPANDABLELISTVIEW_CHILDINDICATORLEFT;
  private static final int EXPANDABLELISTVIEW_CHILDINDICATORRIGHT = getStyleableValue("ExpandableListView_childIndicatorRight");
  private static final int EXPANDABLELISTVIEW_GROUPINDICATOR;
  private static final int EXPANDABLELISTVIEW_INDICATORLEFT;
  private static final int EXPANDABLELISTVIEW_INDICATORRIGHT;
  private static final int[] GROUP_EMPTY_STATE_SET;
  private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET;
  private static final int[] GROUP_EXPANDED_STATE_SET;
  private static final int[][] GROUP_STATE_SETS;
  private static final long PACKED_POSITION_INT_MASK_CHILD = -1L;
  private static final long PACKED_POSITION_INT_MASK_GROUP = 2147483647L;
  private static final long PACKED_POSITION_MASK_CHILD = 4294967295L;
  private static final long PACKED_POSITION_MASK_GROUP = 9223372032559808512L;
  private static final long PACKED_POSITION_MASK_TYPE = -9223372036854775808L;
  private static final long PACKED_POSITION_SHIFT_GROUP = 32L;
  private static final long PACKED_POSITION_SHIFT_TYPE = 63L;
  public static final int PACKED_POSITION_TYPE_CHILD = 1;
  public static final int PACKED_POSITION_TYPE_GROUP = 0;
  public static final int PACKED_POSITION_TYPE_NULL = 2;
  public static final long PACKED_POSITION_VALUE_NULL = 4294967295L;
  private ExpandableListAdapter mAdapter;
  private Drawable mChildDivider;
  private Drawable mChildIndicator;
  private int mChildIndicatorLeft;
  private int mChildIndicatorRight;
  private ExpandableListConnector mConnector;
  private Drawable mGroupIndicator;
  private int mIndicatorLeft;
  private final Rect mIndicatorRect = new Rect();
  private int mIndicatorRight;
  private ExpandableListView.OnChildClickListener mOnChildClickListener;
  private ExpandableListView.OnGroupClickListener mOnGroupClickListener;
  private ExpandableListView.OnGroupCollapseListener mOnGroupCollapseListener;
  private ExpandableListView.OnGroupExpandListener mOnGroupExpandListener;
  
  static
  {
    EXPANDABLELISTVIEW_CHILDINDICATORLEFT = getStyleableValue("ExpandableListView_childIndicatorLeft");
    EXPANDABLELISTVIEW_INDICATORRIGHT = getStyleableValue("ExpandableListView_indicatorRight");
    EXPANDABLELISTVIEW_INDICATORLEFT = getStyleableValue("ExpandableListView_indicatorLeft");
    EXPANDABLELISTVIEW_CHILDINDICATOR = getStyleableValue("ExpandableListView_childIndicator");
    EXPANDABLELISTVIEW_GROUPINDICATOR = getStyleableValue("ExpandableListView_groupIndicator");
    EMPTY_STATE_SET = new int[0];
    GROUP_EXPANDED_STATE_SET = new int[] { 16842920 };
    GROUP_EMPTY_STATE_SET = new int[] { 16842921 };
    GROUP_EXPANDED_EMPTY_STATE_SET = new int[] { 16842920, 16842921 };
    GROUP_STATE_SETS = new int[][] { EMPTY_STATE_SET, GROUP_EXPANDED_STATE_SET, GROUP_EMPTY_STATE_SET, GROUP_EXPANDED_EMPTY_STATE_SET };
  }
  
  public ExpandableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842863);
  }
  
  public ExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new TypedArrayWarpper(paramContext.obtainStyledAttributes(paramAttributeSet, getStyleableValues("ExpandableListView"), paramInt, 0));
    this.mGroupIndicator = paramContext.getDrawable(EXPANDABLELISTVIEW_GROUPINDICATOR);
    this.mChildIndicator = paramContext.getDrawable(EXPANDABLELISTVIEW_CHILDINDICATOR);
    this.mIndicatorLeft = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_INDICATORLEFT, 0);
    this.mIndicatorRight = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_INDICATORRIGHT, 0);
    if (this.mIndicatorRight == 0)
    {
      paramAttributeSet = this.mGroupIndicator;
      if (paramAttributeSet != null) {
        this.mIndicatorRight = (this.mIndicatorLeft + paramAttributeSet.getIntrinsicWidth());
      }
    }
    this.mChildIndicatorLeft = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORLEFT, -1);
    this.mChildIndicatorRight = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORRIGHT, -1);
    this.mChildDivider = paramContext.getDrawable(EXPANDABLELISTVIEW_CHILDDIVIDER);
    paramContext.recycle();
  }
  
  private int getAbsoluteFlatPosition(int paramInt)
  {
    return paramInt + getHeaderViewsCount();
  }
  
  private long getChildOrGroupId(ExpandableListPosition paramExpandableListPosition)
  {
    if (paramExpandableListPosition.type == 1) {
      return this.mAdapter.getChildId(paramExpandableListPosition.groupPos, paramExpandableListPosition.childPos);
    }
    return this.mAdapter.getGroupId(paramExpandableListPosition.groupPos);
  }
  
  private int getFlatPositionForConnector(int paramInt)
  {
    return paramInt - getHeaderViewsCount();
  }
  
  private Drawable getIndicator(ExpandableListConnector.PositionMetadata paramPositionMetadata)
  {
    int i = paramPositionMetadata.position.type;
    int j = 2;
    Drawable localDrawable2;
    Drawable localDrawable1;
    if (i == 2)
    {
      localDrawable2 = this.mGroupIndicator;
      localDrawable1 = localDrawable2;
      if (localDrawable2 != null)
      {
        localDrawable1 = localDrawable2;
        if (localDrawable2.isStateful())
        {
          if ((paramPositionMetadata.groupMetadata != null) && (paramPositionMetadata.groupMetadata.lastChildFlPos != paramPositionMetadata.groupMetadata.flPos)) {
            i = 0;
          } else {
            i = 1;
          }
          int k = paramPositionMetadata.isExpanded();
          if (i != 0) {
            i = j;
          } else {
            i = 0;
          }
          localDrawable2.setState(GROUP_STATE_SETS[(k | i)]);
          return localDrawable2;
        }
      }
    }
    else
    {
      localDrawable2 = this.mChildIndicator;
      localDrawable1 = localDrawable2;
      if (localDrawable2 != null)
      {
        localDrawable1 = localDrawable2;
        if (localDrawable2.isStateful())
        {
          if (paramPositionMetadata.position.flatListPos == paramPositionMetadata.groupMetadata.lastChildFlPos) {
            paramPositionMetadata = CHILD_LAST_STATE_SET;
          } else {
            paramPositionMetadata = EMPTY_STATE_SET;
          }
          localDrawable2.setState(paramPositionMetadata);
          localDrawable1 = localDrawable2;
        }
      }
    }
    return localDrawable1;
  }
  
  public static int getPackedPositionChild(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return -1;
    }
    if ((paramLong & 0x0) != -9223372036854775808L) {
      return -1;
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static long getPackedPositionForChild(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 & 0xFFFFFFFF | (l & 0x7FFFFFFF) << 32 | 0x0;
  }
  
  public static long getPackedPositionForGroup(int paramInt)
  {
    return (paramInt & 0x7FFFFFFF) << 32;
  }
  
  public static int getPackedPositionGroup(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return -1;
    }
    return (int)((paramLong & 0x0) >> 32);
  }
  
  public static int getPackedPositionType(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return 2;
    }
    if ((paramLong & 0x0) == -9223372036854775808L) {
      return 1;
    }
    return 0;
  }
  
  private boolean isHeaderOrFooterPosition(int paramInt)
  {
    int i = this.mItemCount;
    int j = getFooterViewsCount();
    return (paramInt < getHeaderViewsCount()) || (paramInt >= i - j);
  }
  
  public boolean collapseGroup(int paramInt)
  {
    boolean bool = this.mConnector.collapseGroup(paramInt);
    ExpandableListView.OnGroupCollapseListener localOnGroupCollapseListener = this.mOnGroupCollapseListener;
    if (localOnGroupCollapseListener != null) {
      localOnGroupCollapseListener.onGroupCollapse(paramInt);
    }
    return bool;
  }
  
  ContextMenu.ContextMenuInfo createContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    if (isHeaderOrFooterPosition(paramInt)) {
      return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    }
    paramInt = getFlatPositionForConnector(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getUnflattenedPos(paramInt);
    ExpandableListPosition localExpandableListPosition = localPositionMetadata.position;
    localPositionMetadata.recycle();
    paramLong = getChildOrGroupId(localExpandableListPosition);
    long l = localExpandableListPosition.getPackedPosition();
    localExpandableListPosition.recycle();
    return new ExpandableListView.ExpandableListContextMenuInfo(paramView, l, paramLong);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mChildIndicator == null) && (this.mGroupIndicator == null)) {
      return;
    }
    int i = getQQGroupFlag();
    int i1 = 0;
    int k;
    if ((i & 0x22) == 34) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    int j;
    if (k != 0)
    {
      m = paramCanvas.save();
      i = getScrollX();
      j = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + i, getPaddingTop() + j, i + getRight() - getLeft() - getPaddingRight(), j + getBottom() - getTop() - getPaddingBottom());
    }
    else
    {
      m = 0;
    }
    int i2 = getHeaderViewsCount();
    int i3 = this.mItemCount;
    int i4 = getFooterViewsCount();
    int i5 = getBottom();
    i = -4;
    Rect localRect = this.mIndicatorRect;
    int i6 = getChildCount();
    int n = this.mFirstPosition - i2;
    while (i1 < i6)
    {
      if (n < 0)
      {
        j = i;
      }
      else
      {
        if (n > i3 - i4 - i2 - 1) {
          break;
        }
        Object localObject = getChildAt(i1);
        int i7 = ((View)localObject).getTop();
        int i8 = ((View)localObject).getBottom();
        j = i;
        if (i8 >= 0) {
          if (i7 > i5)
          {
            j = i;
          }
          else
          {
            localObject = this.mConnector.getUnflattenedPos(n);
            j = i;
            if (((ExpandableListConnector.PositionMetadata)localObject).position.type != i)
            {
              if (((ExpandableListConnector.PositionMetadata)localObject).position.type == 1)
              {
                j = this.mChildIndicatorLeft;
                i = j;
                if (j == -1) {
                  i = this.mIndicatorLeft;
                }
                localRect.left = i;
                j = this.mChildIndicatorRight;
                i = j;
                if (j == -1) {
                  i = this.mIndicatorRight;
                }
                localRect.right = i;
              }
              else
              {
                localRect.left = this.mIndicatorLeft;
                localRect.right = this.mIndicatorRight;
              }
              localRect.left += getPaddingLeft();
              localRect.right += getPaddingLeft();
              j = ((ExpandableListConnector.PositionMetadata)localObject).position.type;
            }
            if (localRect.left != localRect.right)
            {
              if (this.mStackFromBottom)
              {
                localRect.top = i7;
                localRect.bottom = i8;
              }
              else
              {
                localRect.top = i7;
                localRect.bottom = i8;
              }
              Drawable localDrawable = getIndicator((ExpandableListConnector.PositionMetadata)localObject);
              if (localDrawable != null)
              {
                localDrawable.setBounds(localRect);
                localDrawable.draw(paramCanvas);
              }
            }
            ((ExpandableListConnector.PositionMetadata)localObject).recycle();
          }
        }
      }
      i1 += 1;
      n += 1;
      i = j;
    }
    if (k != 0) {
      paramCanvas.restoreToCount(m);
    }
  }
  
  void drawDivider(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    paramInt += this.mFirstPosition;
    if (paramInt >= 0)
    {
      int i = getFlatPositionForConnector(paramInt);
      ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getUnflattenedPos(i);
      if ((localPositionMetadata.position.type != 1) && ((!localPositionMetadata.isExpanded()) || (localPositionMetadata.groupMetadata.lastChildFlPos == localPositionMetadata.groupMetadata.flPos)))
      {
        localPositionMetadata.recycle();
      }
      else
      {
        Drawable localDrawable = this.mChildDivider;
        if (localDrawable != null)
        {
          localDrawable.setBounds(paramRect);
          localDrawable.draw(paramCanvas);
        }
        localPositionMetadata.recycle();
        return;
      }
    }
    super.drawDivider(paramCanvas, paramRect, paramInt);
  }
  
  public boolean expandGroup(int paramInt)
  {
    return expandGroup(paramInt, false);
  }
  
  public boolean expandGroup(int paramInt, boolean paramBoolean)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getFlattenedPos(ExpandableListPosition.obtain(2, paramInt, -1, -1));
    boolean bool = this.mConnector.expandGroup(localPositionMetadata);
    ExpandableListView.OnGroupExpandListener localOnGroupExpandListener = this.mOnGroupExpandListener;
    if (localOnGroupExpandListener != null) {
      localOnGroupExpandListener.onGroupExpand(paramInt);
    }
    if (paramBoolean)
    {
      int i = localPositionMetadata.position.flatListPos + getHeaderViewsCount();
      smoothScrollToPosition(this.mAdapter.getChildrenCount(paramInt) + i, i);
    }
    localPositionMetadata.recycle();
    return bool;
  }
  
  public ListAdapter getAdapter()
  {
    return super.getAdapter();
  }
  
  public ExpandableListAdapter getExpandableListAdapter()
  {
    return this.mAdapter;
  }
  
  public long getExpandableListPosition(int paramInt)
  {
    if (isHeaderOrFooterPosition(paramInt)) {
      return 4294967295L;
    }
    paramInt = getFlatPositionForConnector(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getUnflattenedPos(paramInt);
    long l = localPositionMetadata.position.getPackedPosition();
    localPositionMetadata.recycle();
    return l;
  }
  
  public int getFlatListPosition(long paramLong)
  {
    Object localObject = ExpandableListPosition.obtainPosition(paramLong);
    if (localObject == null) {
      return -1;
    }
    localObject = this.mConnector.getFlattenedPos((ExpandableListPosition)localObject);
    int i = ((ExpandableListConnector.PositionMetadata)localObject).position.flatListPos;
    ((ExpandableListConnector.PositionMetadata)localObject).recycle();
    return getAbsoluteFlatPosition(i);
  }
  
  public long getSelectedId()
  {
    long l = getSelectedPosition();
    if (l == 4294967295L) {
      return -1L;
    }
    int i = getPackedPositionGroup(l);
    if (getPackedPositionType(l) == 0) {
      return this.mAdapter.getGroupId(i);
    }
    return this.mAdapter.getChildId(i, getPackedPositionChild(l));
  }
  
  public long getSelectedPosition()
  {
    return getExpandableListPosition(getSelectedItemPosition());
  }
  
  boolean handleItemClick(View paramView, int paramInt, long paramLong)
  {
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getUnflattenedPos(paramInt);
    paramLong = getChildOrGroupId(localPositionMetadata.position);
    paramInt = localPositionMetadata.position.type;
    boolean bool2 = true;
    boolean bool1;
    if (paramInt == 2)
    {
      ExpandableListView.OnGroupClickListener localOnGroupClickListener = this.mOnGroupClickListener;
      if ((localOnGroupClickListener != null) && (localOnGroupClickListener.onGroupClick(this, paramView, localPositionMetadata.position.groupPos, paramLong)))
      {
        localPositionMetadata.recycle();
        return true;
      }
      if (localPositionMetadata.isExpanded())
      {
        this.mConnector.collapseGroup(localPositionMetadata);
        playSoundEffect(0);
        paramView = this.mOnGroupCollapseListener;
        bool1 = bool2;
        if (paramView != null)
        {
          paramView.onGroupCollapse(localPositionMetadata.position.groupPos);
          bool1 = bool2;
        }
      }
      else
      {
        this.mConnector.expandGroup(localPositionMetadata);
        playSoundEffect(0);
        paramView = this.mOnGroupExpandListener;
        if (paramView != null) {
          paramView.onGroupExpand(localPositionMetadata.position.groupPos);
        }
        paramInt = localPositionMetadata.position.groupPos;
        int i = localPositionMetadata.position.flatListPos + getHeaderViewsCount();
        smoothScrollToPosition(this.mAdapter.getChildrenCount(paramInt) + i, i);
        bool1 = bool2;
      }
    }
    else
    {
      if (this.mOnChildClickListener != null)
      {
        playSoundEffect(0);
        return this.mOnChildClickListener.onChildClick(this, paramView, localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos, paramLong);
      }
      bool1 = false;
    }
    localPositionMetadata.recycle();
    return bool1;
  }
  
  public boolean isGroupExpanded(int paramInt)
  {
    return this.mConnector.isGroupExpanded(paramInt);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExpandableListView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ExpandableListView.SavedState)paramParcelable;
    super.onRestoreInstanceState(ExpandableListView.SavedState.access$100(paramParcelable));
    if ((this.mConnector != null) && (paramParcelable.expandedGroupMetadataList != null)) {
      this.mConnector.setExpandedGroupMetadataList(paramParcelable.expandedGroupMetadataList);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    Object localObject = this.mConnector;
    if (localObject != null) {
      localObject = ((ExpandableListConnector)localObject).getExpandedGroupMetadataList();
    } else {
      localObject = null;
    }
    return new ExpandableListView.SavedState(localParcelable, (ArrayList)localObject);
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    if (isHeaderOrFooterPosition(paramInt)) {
      return super.performItemClick(paramView, paramInt, paramLong);
    }
    return handleItemClick(paramView, getFlatPositionForConnector(paramInt), paramLong);
  }
  
  public void setAdapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    this.mAdapter = paramExpandableListAdapter;
    if (paramExpandableListAdapter != null) {
      this.mConnector = new ExpandableListConnector(paramExpandableListAdapter);
    } else {
      this.mConnector = null;
    }
    super.setAdapter(this.mConnector);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
  }
  
  public void setChildDivider(Drawable paramDrawable)
  {
    this.mChildDivider = paramDrawable;
  }
  
  public void setChildIndicator(Drawable paramDrawable)
  {
    this.mChildIndicator = paramDrawable;
  }
  
  public void setChildIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.mChildIndicatorLeft = paramInt1;
    this.mChildIndicatorRight = paramInt2;
  }
  
  public void setGroupIndicator(Drawable paramDrawable)
  {
    this.mGroupIndicator = paramDrawable;
    if (this.mIndicatorRight == 0)
    {
      paramDrawable = this.mGroupIndicator;
      if (paramDrawable != null) {
        this.mIndicatorRight = (this.mIndicatorLeft + paramDrawable.getIntrinsicWidth());
      }
    }
  }
  
  public void setIndicatorBounds(int paramInt1, int paramInt2)
  {
    this.mIndicatorLeft = paramInt1;
    this.mIndicatorRight = paramInt2;
  }
  
  public void setOnChildClickListener(ExpandableListView.OnChildClickListener paramOnChildClickListener)
  {
    this.mOnChildClickListener = paramOnChildClickListener;
  }
  
  public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener paramOnGroupClickListener)
  {
    this.mOnGroupClickListener = paramOnGroupClickListener;
  }
  
  public void setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener paramOnGroupCollapseListener)
  {
    this.mOnGroupCollapseListener = paramOnGroupCollapseListener;
  }
  
  public void setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener paramOnGroupExpandListener)
  {
    this.mOnGroupExpandListener = paramOnGroupExpandListener;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public boolean setSelectedChild(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ExpandableListPosition localExpandableListPosition = ExpandableListPosition.obtainChildPosition(paramInt1, paramInt2);
    ExpandableListConnector.PositionMetadata localPositionMetadata2 = this.mConnector.getFlattenedPos(localExpandableListPosition);
    ExpandableListConnector.PositionMetadata localPositionMetadata1 = localPositionMetadata2;
    if (localPositionMetadata2 == null)
    {
      if (!paramBoolean) {
        return false;
      }
      expandGroup(paramInt1);
      localPositionMetadata1 = this.mConnector.getFlattenedPos(localExpandableListPosition);
      if (localPositionMetadata1 == null) {
        throw new IllegalStateException("Could not find child");
      }
    }
    super.setSelection(getAbsoluteFlatPosition(localPositionMetadata1.position.flatListPos));
    localExpandableListPosition.recycle();
    localPositionMetadata1.recycle();
    return true;
  }
  
  public void setSelectedGroup(int paramInt)
  {
    ExpandableListPosition localExpandableListPosition = ExpandableListPosition.obtainGroupPosition(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getFlattenedPos(localExpandableListPosition);
    localExpandableListPosition.recycle();
    super.setSelection(getAbsoluteFlatPosition(localPositionMetadata.position.flatListPos));
    localPositionMetadata.recycle();
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    ExpandableListPosition localExpandableListPosition = ExpandableListPosition.obtainGroupPosition(paramInt);
    ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getFlattenedPos(localExpandableListPosition);
    localExpandableListPosition.recycle();
    int i = localPositionMetadata.position.flatListPos + getHeaderViewsCount();
    smoothScrollToPosition(this.mAdapter.getChildrenCount(paramInt) + i, i);
    localPositionMetadata.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView
 * JD-Core Version:    0.7.0.1
 */