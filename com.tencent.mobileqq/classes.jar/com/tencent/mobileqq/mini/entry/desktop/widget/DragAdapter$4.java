package com.tencent.mobileqq.mini.entry.desktop.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.MicroAppViewHolder;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DragAdapter$4
  implements Animation.AnimationListener
{
  DragAdapter$4(DragAdapter paramDragAdapter, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.mDragMirrorLayout.setVisibility(4);
    if (this.val$tempDragVh != null) {
      this.val$tempDragVh.itemView.setVisibility(0);
    }
    try
    {
      if ((this.val$tempDragVh instanceof MiniAppDesktopAdapter.MicroAppViewHolder)) {
        this.this$0.updateHolder((MiniAppDesktopAdapter.MicroAppViewHolder)this.val$tempDragVh, (DesktopAppInfo)this.this$0.mData.get(this.val$tempDragVh.getAdapterPosition()), this.val$tempDragVh.getAdapterPosition());
      }
      return;
    }
    catch (Throwable paramAnimation)
    {
      QLog.e("DragAdapter", 1, paramAnimation, new Object[0]);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DragAdapter.4
 * JD-Core Version:    0.7.0.1
 */