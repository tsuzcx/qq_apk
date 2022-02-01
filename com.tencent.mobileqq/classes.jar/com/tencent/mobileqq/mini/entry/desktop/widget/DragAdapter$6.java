package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class DragAdapter$6
  implements Runnable
{
  DragAdapter$6(DragAdapter paramDragAdapter, int paramInt) {}
  
  public void run()
  {
    Object localObject = DragAdapter.access$600(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703677));
    localStringBuilder.append(MiniAppConfProcessor.a());
    localStringBuilder.append(HardCodeUtil.a(2131703676));
    QQToast.a((Context)localObject, localStringBuilder.toString(), 0).a();
    if (this.val$overTopTargetIndex != -1)
    {
      this.this$0.mData.remove(this.val$overTopTargetIndex);
      this.this$0.notifyItemRemoved(this.val$overTopTargetIndex);
      localObject = this.this$0;
      ((DragAdapter)localObject).notifyItemRangeChanged(this.val$overTopTargetIndex, ((DragAdapter)localObject).getItemCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.6
 * JD-Core Version:    0.7.0.1
 */