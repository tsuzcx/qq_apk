package com.tencent.tkd.comment.panel.base;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.comment.publisher.bridge.ImageLoaderAdapterOption;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseEmotionViewHolder
  extends RecyclerView.ViewHolder
{
  @Nullable
  protected BaseEmotionViewHolder.EmotionViewHolderCallBack a;
  protected ImageLoaderAdapterOption b;
  
  public BaseEmotionViewHolder(@NotNull View paramView)
  {
    super(paramView);
    a(paramView);
    a();
    b();
  }
  
  protected void a()
  {
    this.itemView.setOnClickListener(new BaseEmotionViewHolder.1(this));
  }
  
  public abstract void a(@NotNull View paramView);
  
  public void a(@Nullable BaseEmotionViewHolder.EmotionViewHolderCallBack paramEmotionViewHolderCallBack)
  {
    this.a = paramEmotionViewHolderCallBack;
  }
  
  public abstract void a(Emotion paramEmotion);
  
  protected void b()
  {
    this.b = new ImageLoaderAdapterOption();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder
 * JD-Core Version:    0.7.0.1
 */