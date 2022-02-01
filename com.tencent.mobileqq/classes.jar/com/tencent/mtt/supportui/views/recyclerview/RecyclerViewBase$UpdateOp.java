package com.tencent.mtt.supportui.views.recyclerview;

import java.util.ArrayList;

public class RecyclerViewBase$UpdateOp
{
  public static final int ADD = 0;
  static final int POOL_SIZE = 30;
  public static final int REMOVE = 1;
  public static final int UPDATE = 2;
  public int cmd;
  public int itemCount;
  public ArrayList<Integer> mRemovePositions = null;
  public int positionStart;
  
  public RecyclerViewBase$UpdateOp(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cmd = paramInt1;
    this.positionStart = paramInt2;
    this.itemCount = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.UpdateOp
 * JD-Core Version:    0.7.0.1
 */