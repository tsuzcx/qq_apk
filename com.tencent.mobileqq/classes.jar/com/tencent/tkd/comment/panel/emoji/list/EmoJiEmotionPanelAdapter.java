package com.tencent.tkd.comment.panel.emoji.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder;
import com.tencent.tkd.comment.panel.base.IEmotionPanel;
import com.tencent.tkd.comment.panel.base.list.BaseEmotionPanelAdapter;
import com.tencent.tkd.comment.panel.emoji.R.layout;
import org.jetbrains.annotations.NotNull;

public class EmoJiEmotionPanelAdapter
  extends BaseEmotionPanelAdapter
{
  public EmoJiEmotionPanelAdapter(@NotNull IEmotionPanel paramIEmotionPanel, @NotNull Context paramContext)
  {
    super(paramIEmotionPanel, paramContext);
  }
  
  @NotNull
  public BaseEmotionViewHolder b(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -1) {
      return new DeleteEmotionViewHolder(this.a.inflate(R.layout.a, paramViewGroup, false));
    }
    return new EmoJiEmotionViewHolder(this.a.inflate(R.layout.b, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.list.EmoJiEmotionPanelAdapter
 * JD-Core Version:    0.7.0.1
 */