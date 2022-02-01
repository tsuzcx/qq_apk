package com.tencent.tkd.comment.panel.emoji.list;

import android.view.View;
import android.widget.ImageView;
import com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder;
import com.tencent.tkd.comment.panel.emoji.R.id;
import com.tencent.tkd.comment.panel.model.Emotion;
import org.jetbrains.annotations.NotNull;

public class DeleteEmotionViewHolder
  extends BaseEmotionViewHolder
{
  private ImageView c;
  
  public DeleteEmotionViewHolder(@NotNull View paramView)
  {
    super(paramView);
  }
  
  public void a(@NotNull View paramView)
  {
    this.c = ((ImageView)paramView.findViewById(R.id.a));
  }
  
  public void a(Emotion paramEmotion)
  {
    if ((paramEmotion != null) && ((paramEmotion.actualEmotion instanceof Integer))) {
      this.c.setImageResource(((Integer)paramEmotion.actualEmotion).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.list.DeleteEmotionViewHolder
 * JD-Core Version:    0.7.0.1
 */