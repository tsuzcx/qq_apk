package com.tencent.tkd.comment.panel.base;

import com.tencent.tkd.comment.panel.base.listener.OnEmotionItemClickListener;
import org.jetbrains.annotations.Nullable;

public abstract interface IEmotionPanel
{
  @Nullable
  public abstract OnEmotionItemClickListener getOnEmotionItemClickListener();
  
  public abstract int getPageRowCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.IEmotionPanel
 * JD-Core Version:    0.7.0.1
 */