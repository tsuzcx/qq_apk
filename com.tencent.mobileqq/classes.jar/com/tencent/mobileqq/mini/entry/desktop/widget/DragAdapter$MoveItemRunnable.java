package com.tencent.mobileqq.mini.entry.desktop.widget;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class DragAdapter$MoveItemRunnable
  implements Runnable
{
  public int moveFromIndex = -1;
  public int moveTargetIndex = -1;
  public int oldMoveTargetIndex = -1;
  public int pendingMoveTargetIndex = -1;
  
  private DragAdapter$MoveItemRunnable(DragAdapter paramDragAdapter) {}
  
  public void reset()
  {
    this.moveFromIndex = -1;
    this.moveTargetIndex = -1;
    this.oldMoveTargetIndex = -1;
  }
  
  public void run()
  {
    if ((this.moveFromIndex < 0) || (this.pendingMoveTargetIndex < 0)) {}
    while ((this.pendingMoveTargetIndex == this.moveTargetIndex) || (DragAdapter.access$100(this.this$0))) {
      return;
    }
    this.moveTargetIndex = this.pendingMoveTargetIndex;
    QLog.i("DragAdapter", 1, "Desktop-Drag MoveReady from:" + this.moveFromIndex + " target:" + this.moveTargetIndex + " oldTarget:" + this.oldMoveTargetIndex);
    int i = this.moveFromIndex;
    int k = this.moveTargetIndex;
    DragAdapter.access$202(this.this$0, i);
    DragAdapter.access$302(this.this$0, k);
    DragAdapter.access$400(this.this$0);
    DesktopAppInfo localDesktopAppInfo1 = (DesktopAppInfo)this.this$0.mData.get(i);
    if (k >= this.this$0.getItemCount())
    {
      QLog.i("DragAdapter", 1, "Desktop-Drag OP_INSERT_BLANK from:" + this.this$0.mDragIndex + " target:" + this.this$0.getItemCount());
      localDesktopAppInfo1 = new DesktopAppInfo(3, localDesktopAppInfo1.mMiniAppInfo);
      localDesktopAppInfo1.setIsTemp(true);
      this.this$0.mData.add(k, localDesktopAppInfo1);
      this.oldMoveTargetIndex = (this.this$0.mData.size() - 1);
      this.this$0.notifyItemInserted(k);
      return;
    }
    DesktopAppInfo localDesktopAppInfo2 = (DesktopAppInfo)this.this$0.mData.get(k);
    if (localDesktopAppInfo1.mModuleType == localDesktopAppInfo2.mModuleType)
    {
      QLog.i("DragAdapter", 1, "Desktop-Drag OP_SWAP from:" + i + " target:" + k);
      if (i < k)
      {
        j = i;
        while (j < k)
        {
          Collections.swap(this.this$0.mData, j, j + 1);
          j += 1;
        }
      }
      int j = i;
      while (j > k)
      {
        Collections.swap(this.this$0.mData, j, j - 1);
        j -= 1;
      }
      this.this$0.notifyItemMoved(i, k);
      this.oldMoveTargetIndex = 0;
      return;
    }
    if (this.oldMoveTargetIndex > 0)
    {
      if (this.oldMoveTargetIndex < k)
      {
        i = this.oldMoveTargetIndex;
        while (i < k)
        {
          Collections.swap(this.this$0.mData, i, i + 1);
          i += 1;
        }
      }
      i = this.oldMoveTargetIndex;
      while (i > k)
      {
        Collections.swap(this.this$0.mData, i, i - 1);
        i -= 1;
      }
      QLog.i("DragAdapter", 1, "Desktop-Drag OP_SWAP fromOld:" + this.oldMoveTargetIndex + " target:" + k);
      this.this$0.notifyItemMoved(this.oldMoveTargetIndex, k);
      this.oldMoveTargetIndex = k;
      return;
    }
    QLog.i("DragAdapter", 1, "Desktop-Drag OP_INSERT from:" + i + " target:" + k);
    if (localDesktopAppInfo2.isTemp)
    {
      QLog.i("DragAdapter", 1, "Desktop-Drag OP_INSERT insert into temp item, invalid!");
      this.oldMoveTargetIndex = k;
      return;
    }
    localDesktopAppInfo1 = new DesktopAppInfo(localDesktopAppInfo2.mModuleType, localDesktopAppInfo1.mMiniAppInfo);
    localDesktopAppInfo1.setIsTemp(true);
    this.this$0.mData.add(k, localDesktopAppInfo1);
    this.oldMoveTargetIndex = k;
    this.this$0.notifyItemInserted(k);
  }
  
  public void setMoveAction(int paramInt1, int paramInt2)
  {
    this.moveFromIndex = paramInt1;
    this.pendingMoveTargetIndex = paramInt2;
  }
  
  public void setMoveTailAction(int paramInt)
  {
    this.moveFromIndex = paramInt;
    this.pendingMoveTargetIndex = this.this$0.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.MoveItemRunnable
 * JD-Core Version:    0.7.0.1
 */