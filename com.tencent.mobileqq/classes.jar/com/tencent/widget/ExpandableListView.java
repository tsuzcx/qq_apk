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
    if ((this.mIndicatorRight == 0) && (this.mGroupIndicator != null)) {
      this.mIndicatorRight = (this.mIndicatorLeft + this.mGroupIndicator.getIntrinsicWidth());
    }
    this.mChildIndicatorLeft = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORLEFT, -1);
    this.mChildIndicatorRight = paramContext.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORRIGHT, -1);
    this.mChildDivider = paramContext.getDrawable(EXPANDABLELISTVIEW_CHILDDIVIDER);
    paramContext.recycle();
  }
  
  private int getAbsoluteFlatPosition(int paramInt)
  {
    return getHeaderViewsCount() + paramInt;
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
    int j = 1;
    int k = 0;
    Drawable localDrawable;
    if (paramPositionMetadata.position.type == 2)
    {
      localDrawable = this.mGroupIndicator;
      if ((localDrawable != null) && (localDrawable.isStateful()))
      {
        int i;
        if ((paramPositionMetadata.groupMetadata == null) || (paramPositionMetadata.groupMetadata.lastChildFlPos == paramPositionMetadata.groupMetadata.flPos))
        {
          i = 1;
          if (!paramPositionMetadata.isExpanded()) {
            break label97;
          }
        }
        for (;;)
        {
          if (i != 0) {
            k = 2;
          }
          localDrawable.setState(GROUP_STATE_SETS[(j | k)]);
          return localDrawable;
          i = 0;
          break;
          label97:
          j = 0;
        }
      }
    }
    else
    {
      localDrawable = this.mChildIndicator;
      if ((localDrawable != null) && (localDrawable.isStateful())) {
        if (paramPositionMetadata.position.flatListPos != paramPositionMetadata.groupMetadata.lastChildFlPos) {
          break label152;
        }
      }
      label152:
      for (paramPositionMetadata = CHILD_LAST_STATE_SET;; paramPositionMetadata = EMPTY_STATE_SET)
      {
        localDrawable.setState(paramPositionMetadata);
        return localDrawable;
      }
    }
    return localDrawable;
  }
  
  public static int getPackedPositionChild(long paramLong)
  {
    if (paramLong == 4294967295L) {}
    while ((paramLong & 0x0) != -9223372036854775808L) {
      return -1;
    }
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static long getPackedPositionForChild(int paramInt1, int paramInt2)
  {
    return 0x0 | (paramInt1 & 0x7FFFFFFF) << 32 | paramInt2 & 0xFFFFFFFF;
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
    return (int)((0x0 & paramLong) >> 32);
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
    if (this.mOnGroupCollapseListener != null) {
      this.mOnGroupCollapseListener.onGroupCollapse(paramInt);
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
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.mChildIndicator == null) && (this.mGroupIndicator == null)) {
      return;
    }
    int m = 0;
    int k;
    label38:
    int i;
    int i2;
    int i3;
    int i4;
    int i5;
    Rect localRect;
    int i1;
    int n;
    if ((this.mGroupFlags & 0x22) == 34)
    {
      k = 1;
      if (k != 0)
      {
        m = paramCanvas.save();
        i = getScrollX();
        j = getScrollY();
        paramCanvas.clipRect(getPaddingLeft() + i, getPaddingTop() + j, i + getRight() - getLeft() - getPaddingRight(), j + getBottom() - getTop() - getPaddingBottom());
      }
      i2 = getHeaderViewsCount();
      i3 = this.mItemCount;
      i4 = getFooterViewsCount();
      i5 = getBottom();
      localRect = this.mIndicatorRect;
      int i6 = getChildCount();
      j = this.mFirstPosition;
      i = -4;
      i1 = 0;
      n = j - i2;
      label161:
      if (i1 >= i6) {
        break label213;
      }
      if (n >= 0) {
        break label198;
      }
      j = i;
    }
    label198:
    label213:
    int i7;
    int i8;
    do
    {
      do
      {
        i1 += 1;
        n += 1;
        i = j;
        break label161;
        k = 0;
        break label38;
        if (n > i3 - i4 - i2 - 1)
        {
          if (k == 0) {
            break;
          }
          paramCanvas.restoreToCount(m);
          return;
        }
        localObject = getChildAt(i1);
        i7 = ((View)localObject).getTop();
        i8 = ((View)localObject).getBottom();
        j = i;
      } while (i8 < 0);
      j = i;
    } while (i7 > i5);
    Object localObject = this.mConnector.getUnflattenedPos(n);
    int j = i;
    if (((ExpandableListConnector.PositionMetadata)localObject).position.type != i)
    {
      if (((ExpandableListConnector.PositionMetadata)localObject).position.type != 1) {
        break label461;
      }
      if (this.mChildIndicatorLeft == -1)
      {
        i = this.mIndicatorLeft;
        label313:
        localRect.left = i;
        if (this.mChildIndicatorRight != -1) {
          break label453;
        }
        i = this.mIndicatorRight;
        label332:
        localRect.right = i;
        label338:
        localRect.left += getPaddingLeft();
        localRect.right += getPaddingLeft();
        j = ((ExpandableListConnector.PositionMetadata)localObject).position.type;
      }
    }
    else if (localRect.left != localRect.right)
    {
      if (!this.mStackFromBottom) {
        break label482;
      }
      localRect.top = i7;
    }
    for (localRect.bottom = i8;; localRect.bottom = i8)
    {
      Drawable localDrawable = getIndicator((ExpandableListConnector.PositionMetadata)localObject);
      if (localDrawable != null)
      {
        localDrawable.setBounds(localRect);
        localDrawable.draw(paramCanvas);
      }
      ((ExpandableListConnector.PositionMetadata)localObject).recycle();
      break;
      i = this.mChildIndicatorLeft;
      break label313;
      label453:
      i = this.mChildIndicatorRight;
      break label332;
      label461:
      localRect.left = this.mIndicatorLeft;
      localRect.right = this.mIndicatorRight;
      break label338;
      label482:
      localRect.top = i7;
    }
  }
  
  void drawDivider(Canvas paramCanvas, Rect paramRect, int paramInt)
  {
    paramInt = this.mFirstPosition + paramInt;
    if (paramInt >= 0)
    {
      int i = getFlatPositionForConnector(paramInt);
      ExpandableListConnector.PositionMetadata localPositionMetadata = this.mConnector.getUnflattenedPos(i);
      if ((localPositionMetadata.position.type == 1) || ((localPositionMetadata.isExpanded()) && (localPositionMetadata.groupMetadata.lastChildFlPos != localPositionMetadata.groupMetadata.flPos)))
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
      localPositionMetadata.recycle();
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
    if (this.mOnGroupExpandListener != null) {
      this.mOnGroupExpandListener.onGroupExpand(paramInt);
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
    if (localPositionMetadata.position.type == 2)
    {
      if ((this.mOnGroupClickListener != null) && (this.mOnGroupClickListener.onGroupClick(this, paramView, localPositionMetadata.position.groupPos, paramLong)))
      {
        localPositionMetadata.recycle();
        return true;
      }
      if (localPositionMetadata.isExpanded())
      {
        this.mConnector.collapseGroup(localPositionMetadata);
        playSoundEffect(0);
        if (this.mOnGroupCollapseListener != null) {
          this.mOnGroupCollapseListener.onGroupCollapse(localPositionMetadata.position.groupPos);
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      localPositionMetadata.recycle();
      return bool;
      this.mConnector.expandGroup(localPositionMetadata);
      playSoundEffect(0);
      if (this.mOnGroupExpandListener != null) {
        this.mOnGroupExpandListener.onGroupExpand(localPositionMetadata.position.groupPos);
      }
      paramInt = localPositionMetadata.position.groupPos;
      int i = localPositionMetadata.position.flatListPos + getHeaderViewsCount();
      smoothScrollToPosition(this.mAdapter.getChildrenCount(paramInt) + i, i);
      break;
      if (this.mOnChildClickListener != null)
      {
        playSoundEffect(0);
        return this.mOnChildClickListener.onChildClick(this, paramView, localPositionMetadata.position.groupPos, localPositionMetadata.position.childPos, paramLong);
      }
    }
  }
  
  public boolean isGroupExpanded(int paramInt)
  {
    return this.mConnector.isGroupExpanded(paramInt);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExpandableListView.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (ExpandableListView.SavedState)paramParcelable;
      super.onRestoreInstanceState(ExpandableListView.SavedState.access$100(paramParcelable));
    } while ((this.mConnector == null) || (paramParcelable.expandedGroupMetadataList == null));
    this.mConnector.setExpandedGroupMetadataList(paramParcelable.expandedGroupMetadataList);
  }
  
  public Parcelable onSaveInstanceState()
  {
    Parcelable localParcelable = super.onSaveInstanceState();
    if (this.mConnector != null) {}
    for (ArrayList localArrayList = this.mConnector.getExpandedGroupMetadataList();; localArrayList = null) {
      return new ExpandableListView.SavedState(localParcelable, localArrayList);
    }
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
    if (paramExpandableListAdapter != null) {}
    for (this.mConnector = new ExpandableListConnector(paramExpandableListAdapter);; this.mConnector = null)
    {
      super.setAdapter(this.mConnector);
      return;
    }
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
    if ((this.mIndicatorRight == 0) && (this.mGroupIndicator != null)) {
      this.mIndicatorRight = (this.mIndicatorLeft + this.mGroupIndicator.getIntrinsicWidth());
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
      localPositionMetadata2 = this.mConnector.getFlattenedPos(localExpandableListPosition);
      localPositionMetadata1 = localPositionMetadata2;
      if (localPositionMetadata2 == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ExpandableListView
 * JD-Core Version:    0.7.0.1
 */