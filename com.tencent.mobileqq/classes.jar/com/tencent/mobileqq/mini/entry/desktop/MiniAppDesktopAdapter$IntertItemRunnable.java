package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MiniAppDesktopAdapter$IntertItemRunnable
  implements Runnable
{
  public MiniAppDesktopAdapter.MicroAppViewHolder fromVh;
  public int moveTargetIndex = -1;
  public int oldMoveTargetIndex = -1;
  public int pendingMoveTargetIndex = -1;
  
  private MiniAppDesktopAdapter$IntertItemRunnable(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void reset()
  {
    this.fromVh = null;
    this.moveTargetIndex = -1;
    this.oldMoveTargetIndex = -1;
    this.pendingMoveTargetIndex = -1;
  }
  
  public void run()
  {
    if ((this.fromVh == null) || (this.pendingMoveTargetIndex < 0)) {}
    while ((this.pendingMoveTargetIndex == this.moveTargetIndex) || (MiniAppDesktopAdapter.access$200(this.this$0))) {
      return;
    }
    this.moveTargetIndex = this.pendingMoveTargetIndex;
    QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag MoveReady1 from:" + this.fromVh + " target:" + this.moveTargetIndex + " oldTarget:" + this.oldMoveTargetIndex);
    int i = this.moveTargetIndex;
    MiniAppDesktopAdapter.access$302(this.this$0, i);
    MiniAppDesktopAdapter.access$400(this.this$0);
    DesktopAppInfo localDesktopAppInfo1 = this.fromVh.desktopAppInfo;
    if (i >= this.this$0.getItemCount())
    {
      QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT_BLANK1 from:" + MiniAppDesktopAdapter.access$500(this.this$0) + " target:" + this.this$0.getItemCount());
      localDesktopAppInfo1 = new DesktopAppInfo(3, localDesktopAppInfo1.mMiniAppInfo);
      localDesktopAppInfo1.setIsTemp(true);
      MiniAppDesktopAdapter.access$600(this.this$0).add(i, localDesktopAppInfo1);
      this.oldMoveTargetIndex = (MiniAppDesktopAdapter.access$700(this.this$0).size() - 1);
      this.this$0.notifyItemInserted(i);
      return;
    }
    DesktopAppInfo localDesktopAppInfo2 = (DesktopAppInfo)MiniAppDesktopAdapter.access$800(this.this$0).get(i);
    QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT1 from:" + MiniAppDesktopAdapter.access$900(this.this$0) + " target:" + i);
    if (localDesktopAppInfo2.isTemp)
    {
      QLog.i("MiniAppDesktopAdapter", 1, "XXX Desktop-Drag OP_INSERT1 insert into temp item, invalid!");
      this.oldMoveTargetIndex = i;
      return;
    }
    localDesktopAppInfo1 = new DesktopAppInfo(localDesktopAppInfo2.mModuleType, localDesktopAppInfo1.mMiniAppInfo);
    localDesktopAppInfo1.setIsTemp(true);
    MiniAppDesktopAdapter.access$1000(this.this$0).add(i, localDesktopAppInfo1);
    this.oldMoveTargetIndex = i;
    this.this$0.notifyItemInserted(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.IntertItemRunnable
 * JD-Core Version:    0.7.0.1
 */