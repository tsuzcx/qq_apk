package com.tencent.tkd.comment.panel.base.list;

import android.content.Context;
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
  protected LayoutInflater a;
  @NotNull
  protected IEmotionPanel a;
  private List<Emotion> a;
  
  public BaseEmotionPanelAdapter(@NotNull IEmotionPanel paramIEmotionPanel, @NotNull Context paramContext)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPanelBaseIEmotionPanel = paramIEmotionPanel;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  @NotNull
  public BaseEmotionViewHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    BaseEmotionViewHolder localBaseEmotionViewHolder = b(paramViewGroup, paramInt);
    localBaseEmotionViewHolder.itemView.getLayoutParams().height = (paramViewGroup.getMeasuredHeight() / this.jdField_a_of_type_ComTencentTkdCommentPanelBaseIEmotionPanel.e());
    return localBaseEmotionViewHolder;
  }
  
  @Nullable
  protected Emotion a(int paramInt)
  {
    if ((!CollectionUtil.isEmpty(this.jdField_a_of_type_JavaUtilList)) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (Emotion)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(BaseEmotionViewHolder paramBaseEmotionViewHolder, int paramInt)
  {
    paramBaseEmotionViewHolder.a(a(paramInt));
    paramBaseEmotionViewHolder.a(new BaseEmotionPanelAdapter.1(this));
  }
  
  public void a(List<Emotion> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  @NotNull
  protected abstract BaseEmotionViewHolder b(@NotNull ViewGroup paramViewGroup, int paramInt);
  
  public int getItemCount()
  {
    if (CollectionUtil.isEmpty(this.jdField_a_of_type_JavaUtilList)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.list.BaseEmotionPanelAdapter
 * JD-Core Version:    0.7.0.1
 */