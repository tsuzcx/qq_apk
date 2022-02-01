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
  
  public boolean a()
  {
    boolean bool = super.a();
    if ((bool) && (!CollectionUtil.isEmpty(this.a)))
    {
      setPageIndicator(f());
      int i = e();
      int j = g() * i;
      i = 0;
      while (i < f())
      {
        int k = i * j - i;
        int m = Math.min((i + 1) * j - i - 1, this.a.length);
        Object localObject = new ArrayList(Arrays.asList(Arrays.copyOfRange(this.a, k, m)));
        ((List)localObject).add(new Emotion(-1, Integer.valueOf(R.drawable.a)));
        LogUtil.logD("EmotionPanelTAG", "size:" + ((List)localObject).size() + "__from:" + k + "__to:" + m);
        localObject = EmotionListFactory.a(getContext(), g(), new EmoJiEmotionPanelAdapter(this, getContext()), (List)localObject, a());
        a().add(localObject);
        i += 1;
      }
      if (a().getAdapter() != null) {
        a().getAdapter().notifyDataSetChanged();
      }
    }
    return bool;
  }
  
  public int b()
  {
    return getResources().getDimensionPixelOffset(R.dimen.a);
  }
  
  public int c()
  {
    return getResources().getDimensionPixelOffset(R.dimen.c);
  }
  
  public int d()
  {
    return getResources().getDimensionPixelOffset(R.dimen.b);
  }
  
  public int e()
  {
    return 3;
  }
  
  public int f()
  {
    int i = 0;
    if (CollectionUtil.isEmpty(this.a)) {
      return 0;
    }
    int k = e() * g() - 1;
    int j = this.a.length / k;
    if (this.a.length % k > 0) {
      i = 1;
    }
    return i + j;
  }
  
  public int g()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.emoji.EmoJiEmotionPanel
 * JD-Core Version:    0.7.0.1
 */