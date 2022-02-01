package com.tencent.widget;

import java.util.ArrayList;

class ExpandableListPosition
{
  public static final int CHILD = 1;
  public static final int GROUP = 2;
  private static final int MAX_POOL_SIZE = 5;
  private static ArrayList<ExpandableListPosition> sPool = new ArrayList(5);
  public int childPos;
  int flatListPos;
  public int groupPos;
  public int type;
  
  private static ExpandableListPosition getRecycledOrCreate()
  {
    synchronized (sPool)
    {
      if (sPool.size() > 0)
      {
        localExpandableListPosition = (ExpandableListPosition)sPool.remove(0);
        localExpandableListPosition.resetState();
        return localExpandableListPosition;
      }
      ExpandableListPosition localExpandableListPosition = new ExpandableListPosition();
      return localExpandableListPosition;
    }
  }
  
  static ExpandableListPosition obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ExpandableListPosition localExpandableListPosition = getRecycledOrCreate();
    localExpandableListPosition.type = paramInt1;
    localExpandableListPosition.groupPos = paramInt2;
    localExpandableListPosition.childPos = paramInt3;
    localExpandableListPosition.flatListPos = paramInt4;
    return localExpandableListPosition;
  }
  
  static ExpandableListPosition obtainChildPosition(int paramInt1, int paramInt2)
  {
    return obtain(1, paramInt1, paramInt2, 0);
  }
  
  static ExpandableListPosition obtainGroupPosition(int paramInt)
  {
    return obtain(2, paramInt, 0, 0);
  }
  
  static ExpandableListPosition obtainPosition(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    ExpandableListPosition localExpandableListPosition = getRecycledOrCreate();
    localExpandableListPosition.groupPos = ExpandableListView.getPackedPositionGroup(paramLong);
    if (ExpandableListView.getPackedPositionType(paramLong) == 1)
    {
      localExpandableListPosition.type = 1;
      localExpandableListPosition.childPos = ExpandableListView.getPackedPositionChild(paramLong);
      return localExpandableListPosition;
    }
    localExpandableListPosition.type = 2;
    return localExpandableListPosition;
  }
  
  private void resetState()
  {
    this.groupPos = 0;
    this.childPos = 0;
    this.flatListPos = 0;
    this.type = 0;
  }
  
  long getPackedPosition()
  {
    if (this.type == 1) {
      return ExpandableListView.getPackedPositionForChild(this.groupPos, this.childPos);
    }
    return ExpandableListView.getPackedPositionForGroup(this.groupPos);
  }
  
  public void recycle()
  {
    synchronized (sPool)
    {
      if (sPool.size() < 5) {
        sPool.add(this);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.ExpandableListPosition
 * JD-Core Version:    0.7.0.1
 */