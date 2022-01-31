package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class MiniAppDesktopAdapter$MoveItemRunnable
  implements Runnable
{
  public int moveFromIndex = -1;
  public int moveTargetIndex = -1;
  public int oldMoveTargetIndex = -1;
  public int pendingMoveTargetIndex = -1;
  
  private MiniAppDesktopAdapter$MoveItemRunnable(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void reset()
  {
    this.moveFromIndex = -1;
    this.moveTargetIndex = -1;
    this.oldMoveTargetIndex = -1;
  }
  
  public void run()
  {
    if ((this.moveFromIndex < 0) || (this.pendingMoveTargetIndex < 0)) {}
    while ((this.pendingMoveTargetIndex == this.moveTargetIndex) || (MiniAppDesktopAdapter.access$200(this.this$0))) {
      return;
    }
    this.moveTargetIndex = this.pendingMoveTargetIndex;
    QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag MoveReady from:" + this.moveFromIndex + " target:" + this.moveTargetIndex + " oldTarget:" + this.oldMoveTargetIndex);
    int i = this.moveFromIndex;
    int k = this.moveTargetIndex;
    MiniAppDesktopAdapter.access$1102(this.this$0, i);
    MiniAppDesktopAdapter.access$302(this.this$0, k);
    MiniAppDesktopAdapter.access$400(this.this$0);
    DesktopAppInfo localDesktopAppInfo1 = (DesktopAppInfo)MiniAppDesktopAdapter.access$1200(this.this$0).get(i);
    if (k >= this.this$0.getItemCount())
    {
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT_BLANK from:" + MiniAppDesktopAdapter.access$1300(this.this$0) + " target:" + this.this$0.getItemCount());
      localDesktopAppInfo1 = new DesktopAppInfo(3, localDesktopAppInfo1.mMiniAppInfo);
      localDesktopAppInfo1.setIsTemp(true);
      MiniAppDesktopAdapter.access$1400(this.this$0).add(k, localDesktopAppInfo1);
      this.oldMoveTargetIndex = (MiniAppDesktopAdapter.access$1500(this.this$0).size() - 1);
      this.this$0.notifyItemInserted(k);
      return;
    }
    DesktopAppInfo localDesktopAppInfo2 = (DesktopAppInfo)MiniAppDesktopAdapter.access$1600(this.this$0).get(k);
    if (localDesktopAppInfo1.mModuleType == localDesktopAppInfo2.mModuleType)
    {
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_SWAP from:" + i + " target:" + k);
      if (i < k)
      {
        j = i;
        while (j < k)
        {
          Collections.swap(MiniAppDesktopAdapter.access$1700(this.this$0), j, j + 1);
          j += 1;
        }
      }
      int j = i;
      while (j > k)
      {
        Collections.swap(MiniAppDesktopAdapter.access$1800(this.this$0), j, j - 1);
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
          Collections.swap(MiniAppDesktopAdapter.access$1900(this.this$0), i, i + 1);
          i += 1;
        }
      }
      i = this.oldMoveTargetIndex;
      while (i > k)
      {
        Collections.swap(MiniAppDesktopAdapter.access$2000(this.this$0), i, i - 1);
        i -= 1;
      }
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_SWAP fromOld:" + this.oldMoveTargetIndex + " target:" + k);
      this.this$0.notifyItemMoved(this.oldMoveTargetIndex, k);
      this.oldMoveTargetIndex = k;
      return;
    }
    QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT from:" + i + " target:" + k);
    if (localDesktopAppInfo2.isTemp)
    {
      QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT insert into temp item, invalid!");
      this.oldMoveTargetIndex = k;
      return;
    }
    localDesktopAppInfo1 = new DesktopAppInfo(localDesktopAppInfo2.mModuleType, localDesktopAppInfo1.mMiniAppInfo);
    localDesktopAppInfo1.setIsTemp(true);
    MiniAppDesktopAdapter.access$2100(this.this$0).add(k, localDesktopAppInfo1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MoveItemRunnable
 * JD-Core Version:    0.7.0.1
 */