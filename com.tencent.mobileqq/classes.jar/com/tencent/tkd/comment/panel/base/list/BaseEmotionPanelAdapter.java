package com.tencent.tkd.comment.panel.base.list;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tkd.comment.panel.base.BaseEmotionViewHolder;
import com.tencent.tkd.comment.panel.base.IEmotionPanel;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.comment.util.CollectionUtil;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseEmotionPanelAdapter
  extends RecyclerView.Adapter<BaseEmotionViewHolder>
{
  @NotNull
  protected IEmotionPanel a;
  @NotNull
  protected LayoutInflater b;
  private List<Emotion> c;
  
  @NotNull
  public BaseEmotionViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    BaseEmotionViewHolder localBaseEmotionViewHolder = b(paramViewGroup, paramInt);
    localBaseEmotionViewHolder.itemView.getLayoutParams().height = (paramViewGroup.getMeasuredHeight() / this.a.getPageRowCount());
    return localBaseEmotionViewHolder;
  }
  
  @Nullable
  protected Emotion a(int paramInt)
  {
    if ((!CollectionUtil.isEmpty(this.c)) && (paramInt < this.c.size())) {
      return (Emotion)this.c.get(paramInt);
    }
    return null;
  }
  
  public void a(BaseEmotionViewHolder paramBaseEmotionViewHolder, int paramInt)
  {
    paramBaseEmotionViewHolder.a(a(paramInt));
    paramBaseEmotionViewHolder.a(new BaseEmotionPanelAdapter.1(this));
  }
  
  @NotNull
  protected abstract BaseEmotionViewHolder b(@NotNull ViewGroup paramViewGroup, int paramInt);
  
  public int getItemCount()
  {
    if (CollectionUtil.isEmpty(this.c)) {
      return 0;
    }
    return this.c.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    Emotion localEmotion = a(paramInt);
    if (localEmotion != null) {
      return localEmotion.getEmotionType();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.list.BaseEmotionPanelAdapter
 * JD-Core Version:    0.7.0.1
 */