package com.tencent.tkd.comment.panel.emoji.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder;
import com.tencent.tkd.comment.panel.base.list.BaseEmotionPanelAdapter;
import com.tencent.tkd.comment.panel.emoji.R.layout;
import org.jetbrains.annotations.NotNull;

public class EmoJiEmotionPanelAdapter
  extends BaseEmotionPanelAdapter
{
  @NotNull
  protected BaseEmotionViewHolder b(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -1) {
      return new DeleteEmotionViewHolder(this.b.inflate(R.layout.a, paramViewGroup, false));
    }
    return new EmoJiEmotionViewHolder(this.b.inflate(R.layout.b, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.list.EmoJiEmotionPanelAdapter
 * JD-Core Version:    0.7.0.1
 */