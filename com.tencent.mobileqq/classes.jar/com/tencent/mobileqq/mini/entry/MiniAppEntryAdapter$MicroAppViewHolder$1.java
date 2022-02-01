package com.tencent.mobileqq.mini.entry;

import com.tencent.qphone.base.util.QLog;

class MiniAppEntryAdapter$MicroAppViewHolder$1
  implements Runnable
{
  MiniAppEntryAdapter$MicroAppViewHolder$1(MiniAppEntryAdapter.MicroAppViewHolder paramMicroAppViewHolder) {}
  
  public void run()
  {
    if ((this.this$0.isPlayAnim) && (this.this$0.isPlayAnim))
    {
      this.this$0.stopAnimation();
      MiniAppEntryAdapter.access$300();
      QLog.d("MiniAppEntryAdapter", 1, "[mini_app_anim].startSwitchAnimation, animation end.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntryAdapter.MicroAppViewHolder.1
 * JD-Core Version:    0.7.0.1
 */