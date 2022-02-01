package com.tencent.tkd.comment.panel.emoji.list;

import android.view.View;
import android.widget.ImageView;
import com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder;
import com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanelManager;
import com.tencent.tkd.comment.panel.emoji.R.id;
import com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource;
import com.tencent.tkd.comment.panel.model.EmoJiEmotion;
import com.tencent.tkd.comment.panel.model.Emotion;
import org.jetbrains.annotations.NotNull;

public class EmoJiEmotionViewHolder
  extends BaseEmotionViewHolder
{
  private ImageView c;
  
  public EmoJiEmotionViewHolder(@NotNull View paramView)
  {
    super(paramView);
  }
  
  public void a(@NotNull View paramView)
  {
    this.c = ((ImageView)paramView.findViewById(R.id.b));
  }
  
  public void a(Emotion paramEmotion)
  {
    if ((paramEmotion != null) && ((paramEmotion.actualEmotion instanceof EmoJiEmotion)))
    {
      paramEmotion = EmoJiEmotionPanelManager.a().b().a(((EmoJiEmotion)paramEmotion.actualEmotion).emoJiResourceId);
      if (paramEmotion != null)
      {
        this.c.setImageDrawable(paramEmotion);
        this.c.setVisibility(0);
        return;
      }
      this.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.list.EmoJiEmotionViewHolder
 * JD-Core Version:    0.7.0.1
 */