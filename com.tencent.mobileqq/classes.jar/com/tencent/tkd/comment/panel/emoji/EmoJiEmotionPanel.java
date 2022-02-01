package com.tencent.tkd.comment.panel.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import com.tencent.tkd.comment.panel.base.BaseEmotionPanel;
import com.tencent.tkd.comment.panel.base.list.EmotionListFactory;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.comment.util.CollectionUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmoJiEmotionPanel
  extends BaseEmotionPanel
{
  private Emotion[] d;
  
  public EmoJiEmotionPanel(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoJiEmotionPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmoJiEmotionPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int getPageRowCount()
  {
    return 3;
  }
  
  public int getPageSize()
  {
    boolean bool = CollectionUtil.isEmpty(this.d);
    int i = 0;
    if (bool) {
      return 0;
    }
    int k = getPageRowCount() * getRowEmotionCount() - 1;
    Emotion[] arrayOfEmotion = this.d;
    int j = arrayOfEmotion.length / k;
    if (arrayOfEmotion.length % k > 0) {
      i = 1;
    }
    return j + i;
  }
  
  @Nullable
  public RecyclerView.RecycledViewPool getRecyclerViewPool()
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = super.getRecyclerViewPool();
    if (localRecycledViewPool == null) {
      setRecyclerViewPool(EmotionListFactory.a());
    }
    return localRecycledViewPool;
  }
  
  public int getRowEmotionCount()
  {
    return 7;
  }
  
  protected int getViewPagerBottomMargin()
  {
    return getResources().getDimensionPixelOffset(R.dimen.b);
  }
  
  protected int getViewPagerHorizontalMargin()
  {
    return getResources().getDimensionPixelOffset(R.dimen.a);
  }
  
  protected int getViewPagerTopMargin()
  {
    return getResources().getDimensionPixelOffset(R.dimen.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanel
 * JD-Core Version:    0.7.0.1
 */