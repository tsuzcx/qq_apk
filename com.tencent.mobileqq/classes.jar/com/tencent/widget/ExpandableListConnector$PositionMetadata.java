package com.tencent.widget;

import java.util.ArrayList;

public class ExpandableListConnector$PositionMetadata
{
  private static final int MAX_POOL_SIZE = 5;
  private static ArrayList<PositionMetadata> sPool = new ArrayList(5);
  public int groupInsertIndex;
  public ExpandableListConnector.GroupMetadata groupMetadata;
  public ExpandableListPosition position;
  
  private static PositionMetadata getRecycledOrCreate()
  {
    synchronized (sPool)
    {
      if (sPool.size() > 0)
      {
        localPositionMetadata = (PositionMetadata)sPool.remove(0);
        localPositionMetadata.resetState();
        return localPositionMetadata;
      }
      PositionMetadata localPositionMetadata = new PositionMetadata();
      return localPositionMetadata;
    }
  }
  
  static PositionMetadata obtain(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ExpandableListConnector.GroupMetadata paramGroupMetadata, int paramInt5)
  {
    PositionMetadata localPositionMetadata = getRecycledOrCreate();
    localPositionMetadata.position = ExpandableListPosition.obtain(paramInt2, paramInt3, paramInt4, paramInt1);
    localPositionMetadata.groupMetadata = paramGroupMetadata;
    localPositionMetadata.groupInsertIndex = paramInt5;
    return localPositionMetadata;
  }
  
  private void resetState()
  {
    this.position = null;
    this.groupMetadata = null;
    this.groupInsertIndex = 0;
  }
  
  public boolean isExpanded()
  {
    return this.groupMetadata != null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.PositionMetadata
 * JD-Core Version:    0.7.0.1
 */