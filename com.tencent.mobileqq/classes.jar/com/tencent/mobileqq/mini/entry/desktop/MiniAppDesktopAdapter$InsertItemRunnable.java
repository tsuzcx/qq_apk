package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppDesktopAdapter$InsertItemRunnable
  implements Runnable
{
  public MiniAppDesktopAdapter.MicroAppViewHolder fromVh;
  public int moveTargetIndex = -1;
  public int oldMoveTargetIndex = -1;
  public int pendingMoveTargetIndex = -1;
  
  private MiniAppDesktopAdapter$InsertItemRunnable(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void reset()
  {
    this.fromVh = null;
    this.moveTargetIndex = -1;
    this.oldMoveTargetIndex = -1;
    this.pendingMoveTargetIndex = -1;
  }
  
  public void run()
  {
    if (this.fromVh != null)
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
      ((StringBuilder)localObject1).append("XXX Desktop-Drag MoveReady1 from:");
      ((StringBuilder)localObject1).append(this.fromVh);
      ((StringBuilder)localObject1).append(" target:");
      ((StringBuilder)localObject1).append(this.moveTargetIndex);
      ((StringBuilder)localObject1).append(" oldTarget:");
      ((StringBuilder)localObject1).append(this.oldMoveTargetIndex);
      QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject1).toString());
      i = this.moveTargetIndex;
      MiniAppDesktopAdapter.access$302(this.this$0, i);
      MiniAppDesktopAdapter.access$400(this.this$0);
      localObject1 = this.fromVh.desktopAppInfo;
      if (i >= this.this$0.getItemCount())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("XXX Desktop-Drag OP_INSERT_BLANK1 from:");
        ((StringBuilder)localObject2).append(MiniAppDesktopAdapter.access$500(this.this$0));
        ((StringBuilder)localObject2).append(" target:");
        ((StringBuilder)localObject2).append(this.this$0.getItemCount());
        QLog.i("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
        localObject1 = new DesktopAppInfo(3, ((DesktopAppInfo)localObject1).mMiniAppInfo);
        ((DesktopItemInfo)localObject1).setIsTemp(true);
        MiniAppDesktopAdapter.access$600(this.this$0).add(i, localObject1);
        this.oldMoveTargetIndex = (MiniAppDesktopAdapter.access$700(this.this$0).size() - 1);
        this.this$0.notifyItemInserted(i);
        return;
      }
      Object localObject2 = (DesktopAppInfo)MiniAppDesktopAdapter.access$800(this.this$0).get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("XXX Desktop-Drag OP_INSERT1 from:");
      localStringBuilder.append(MiniAppDesktopAdapter.access$900(this.this$0));
      localStringBuilder.append(" target:");
      localStringBuilder.append(i);
      QLog.i("MiniAppDesktopAdapter", 1, localStringBuilder.toString());
      if (((DesktopAppInfo)localObject2).isTemp)
      {
        QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT1 insert into temp item, invalid!");
        this.oldMoveTargetIndex = i;
        return;
      }
      localObject1 = new DesktopAppInfo(((DesktopAppInfo)localObject2).mModuleType, ((DesktopAppInfo)localObject1).mMiniAppInfo);
      ((DesktopItemInfo)localObject1).setIsTemp(true);
      MiniAppDesktopAdapter.access$1000(this.this$0).add(i, localObject1);
      this.oldMoveTargetIndex = i;
      this.this$0.notifyItemInserted(i);
    }
  }
  
  public void setMoveAction(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder, int paramInt)
  {
    this.fromVh = paramMicroAppViewHolder;
    this.pendingMoveTargetIndex = paramInt;
  }
  
  public void setMoveTailAction(MiniAppDesktopAdapter.MicroAppViewHolder paramMicroAppViewHolder)
  {
    this.fromVh = paramMicroAppViewHolder;
    this.pendingMoveTargetIndex = this.this$0.getItemCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.InsertItemRunnable
 * JD-Core Version:    0.7.0.1
 */