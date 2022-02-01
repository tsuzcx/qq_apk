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
    if (this.moveFromIndex >= 0)
    {
      int i = this.pendingMoveTargetIndex;
      if (i < 0) {
        return;
      }
      if (i == this.moveTargetIndex) {
        return;
      }
      if (MiniAppDesktopAdapter.access$200(this.this$0)) {
        return;
      }
      this.moveTargetIndex = this.pendingMoveTargetIndex;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Desktop-Drag MoveReady from:");
      ((StringBuilder)localObject1).append(this.moveFromIndex);
      ((StringBuilder)localObject1).append(" target:");
      ((StringBuilder)localObject1).append(this.moveTargetIndex);
      ((StringBuilder)localObject1).append(" oldTarget:");
      ((StringBuilder)localObject1).append(this.oldMoveTargetIndex);
      QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject1).toString());
      i = this.moveFromIndex;
      int m = this.moveTargetIndex;
      MiniAppDesktopAdapter.access$1102(this.this$0, i);
      MiniAppDesktopAdapter.access$302(this.this$0, m);
      MiniAppDesktopAdapter.access$400(this.this$0);
      localObject1 = (DesktopAppInfo)MiniAppDesktopAdapter.access$1200(this.this$0).get(i);
      if (m >= this.this$0.getItemCount())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Desktop-Drag OP_INSERT_BLANK from:");
        ((StringBuilder)localObject2).append(MiniAppDesktopAdapter.access$1300(this.this$0));
        ((StringBuilder)localObject2).append(" target:");
        ((StringBuilder)localObject2).append(this.this$0.getItemCount());
        QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
        localObject1 = new DesktopAppInfo(3, ((DesktopAppInfo)localObject1).mMiniAppInfo);
        ((DesktopItemInfo)localObject1).setIsTemp(true);
        MiniAppDesktopAdapter.access$1400(this.this$0).add(m, localObject1);
        this.oldMoveTargetIndex = (MiniAppDesktopAdapter.access$1500(this.this$0).size() - 1);
        this.this$0.notifyItemInserted(m);
        return;
      }
      Object localObject2 = (DesktopAppInfo)MiniAppDesktopAdapter.access$1600(this.this$0).get(m);
      if (((DesktopAppInfo)localObject1).mModuleType == ((DesktopAppInfo)localObject2).mModuleType)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Desktop-Drag OP_SWAP from:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" target:");
        ((StringBuilder)localObject1).append(m);
        QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject1).toString());
        if (i < m)
        {
          int k;
          for (j = i; j < m; j = k)
          {
            localObject1 = MiniAppDesktopAdapter.access$1700(this.this$0);
            k = j + 1;
            Collections.swap((List)localObject1, j, k);
          }
        }
        j = i;
        while (j > m)
        {
          Collections.swap(MiniAppDesktopAdapter.access$1800(this.this$0), j, j - 1);
          j -= 1;
        }
        this.this$0.notifyItemMoved(i, m);
        this.oldMoveTargetIndex = 0;
        return;
      }
      int j = this.oldMoveTargetIndex;
      if (j > 0)
      {
        i = j;
        if (j < m) {
          while (j < m)
          {
            localObject1 = MiniAppDesktopAdapter.access$1900(this.this$0);
            i = j + 1;
            Collections.swap((List)localObject1, j, i);
            j = i;
          }
        }
        while (i > m)
        {
          Collections.swap(MiniAppDesktopAdapter.access$2000(this.this$0), i, i - 1);
          i -= 1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Desktop-Drag OP_SWAP fromOld:");
        ((StringBuilder)localObject1).append(this.oldMoveTargetIndex);
        ((StringBuilder)localObject1).append(" target:");
        ((StringBuilder)localObject1).append(m);
        QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject1).toString());
        this.this$0.notifyItemMoved(this.oldMoveTargetIndex, m);
        this.oldMoveTargetIndex = m;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Desktop-Drag OP_INSERT from:");
      localStringBuilder.append(i);
      localStringBuilder.append(" target:");
      localStringBuilder.append(m);
      QLog.i("MiniAppDesktopAdapter", 1, localStringBuilder.toString());
      if (((DesktopAppInfo)localObject2).isTemp)
      {
        QLog.i("MiniAppDesktopAdapter", 1, "Desktop-Drag OP_INSERT insert into temp item, invalid!");
        this.oldMoveTargetIndex = m;
        return;
      }
      localObject1 = new DesktopAppInfo(((DesktopAppInfo)localObject2).mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
      ((DesktopItemInfo)localObject1).setIsTemp(true);
      MiniAppDesktopAdapter.access$2100(this.this$0).add(m, localObject1);
      this.oldMoveTargetIndex = m;
      this.this$0.notifyItemInserted(m);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MoveItemRunnable
 * JD-Core Version:    0.7.0.1
 */