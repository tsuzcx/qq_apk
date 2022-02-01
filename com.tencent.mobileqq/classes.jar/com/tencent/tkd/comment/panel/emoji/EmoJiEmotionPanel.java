package com.tencent.tkd.comment.panel.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import com.tencent.tkd.comment.panel.base.BaseEmotionPanel;
import com.tencent.tkd.comment.panel.base.list.EmotionListFactory;
import com.tencent.tkd.comment.panel.emoji.data.EmoJiEmotionDataSource;
import com.tencent.tkd.comment.panel.emoji.list.EmoJiEmotionPanelAdapter;
import com.tencent.tkd.comment.panel.model.Emotion;
import com.tencent.tkd.comment.util.CollectionUtil;
import com.tencent.tkd.comment.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmoJiEmotionPanel
  extends BaseEmotionPanel
{
  private Emotion[] a;
  
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
  
  @Nullable
  public RecyclerView.RecycledViewPool a()
  {
    RecyclerView.RecycledViewPool localRecycledViewPool = super.a();
    if (localRecycledViewPool == null) {
      setRecyclerViewPool(EmotionListFactory.a());
    }
    return localRecycledViewPool;
  }
  
  public void a()
  {
    this.a = EmoJiEmotionPanelManager.a().a().a();
    a();
  }
  
  protected boolean a()
  {
    boolean bool = super.a();
    if ((bool) && (!CollectionUtil.isEmpty(this.a)))
    {
      setPageIndicator(f());
      int k = e() * g();
      int j;
      for (int i = 0; i < f(); i = j)
      {
        int m = i * k - i;
        j = i + 1;
        i = Math.min(j * k - i - 1, this.a.length);
        Object localObject = new ArrayList(Arrays.asList(Arrays.copyOfRange(this.a, m, i)));
        ((List)localObject).add(new Emotion(-1, Integer.valueOf(R.drawable.a)));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("size:");
        localStringBuilder.append(((List)localObject).size());
        localStringBuilder.append("__from:");
        localStringBuilder.append(m);
        localStringBuilder.append("__to:");
        localStringBuilder.append(i);
        LogUtil.logD("EmotionPanelTAG", localStringBuilder.toString());
        localObject = EmotionListFactory.a(getContext(), g(), new EmoJiEmotionPanelAdapter(this, getContext()), (List)localObject, a());
        a().add(localObject);
      }
      if (a().getAdapter() != null) {
        a().getAdapter().notifyDataSetChanged();
      }
    }
    return bool;
  }
  
  protected int b()
  {
    return getResources().getDimensionPixelOffset(R.dimen.a);
  }
  
  protected int c()
  {
    return getResources().getDimensionPixelOffset(R.dimen.c);
  }
  
  protected int d()
  {
    return getResources().getDimensionPixelOffset(R.dimen.b);
  }
  
  public int e()
  {
    return 3;
  }
  
  public int f()
  {
    boolean bool = CollectionUtil.isEmpty(this.a);
    int i = 0;
    if (bool) {
      return 0;
    }
    int k = e() * g() - 1;
    Emotion[] arrayOfEmotion = this.a;
    int j = arrayOfEmotion.length / k;
    if (arrayOfEmotion.length % k > 0) {
      i = 1;
    }
    return j + i;
  }
  
  public int g()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanel
 * JD-Core Version:    0.7.0.1
 */