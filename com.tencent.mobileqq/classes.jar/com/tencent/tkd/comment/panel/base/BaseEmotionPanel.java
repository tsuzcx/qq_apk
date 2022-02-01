package com.tencent.tkd.comment.panel.base;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tkd.comment.panel.base.listener.OnEmotionItemClickListener;
import com.tencent.tkd.comment.panel.base.view.PageIndicator;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseEmotionPanel
  extends FrameLayout
  implements IEmotionPanel
{
  protected int a;
  protected int b;
  protected int c;
  private ViewPager d;
  private PageIndicator e;
  private List<RecyclerView> f;
  @Nullable
  private OnEmotionItemClickListener g;
  private RecyclerView.RecycledViewPool h;
  
  public BaseEmotionPanel(@NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public BaseEmotionPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public BaseEmotionPanel(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    this.d.setAdapter(new BaseEmotionPanel.1(this));
    this.d.addOnPageChangeListener(new BaseEmotionPanel.2(this));
  }
  
  protected void a(@NotNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
    this.d = ((ViewPager)findViewById(R.id.b));
    if ((this.d.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      paramContext = (FrameLayout.LayoutParams)this.d.getLayoutParams();
      paramContext.leftMargin = getViewPagerHorizontalMargin();
      paramContext.rightMargin = getViewPagerHorizontalMargin();
      paramContext.topMargin = getViewPagerTopMargin();
      paramContext.bottomMargin = getViewPagerBottomMargin();
      this.d.setLayoutParams(paramContext);
    }
    this.e = ((PageIndicator)findViewById(R.id.a));
    a();
  }
  
  @NotNull
  protected List<RecyclerView> getEmotionRecyclerViewList()
  {
    if (this.f == null) {
      this.f = new ArrayList();
    }
    return this.f;
  }
  
  public ViewPager getEmotionViewPager()
  {
    return this.d;
  }
  
  protected int getLayoutId()
  {
    return R.layout.a;
  }
  
  @Nullable
  public OnEmotionItemClickListener getOnEmotionItemClickListener()
  {
    return this.g;
  }
  
  @Nullable
  public RecyclerView.RecycledViewPool getRecyclerViewPool()
  {
    return this.h;
  }
  
  protected int getViewPagerBottomMargin()
  {
    return getResources().getDimensionPixelOffset(R.dimen.a);
  }
  
  protected int getViewPagerHorizontalMargin()
  {
    return getResources().getDimensionPixelOffset(R.dimen.b);
  }
  
  protected int getViewPagerTopMargin()
  {
    return 0;
  }
  
  public void setOnEmotionItemClickListener(@Nullable OnEmotionItemClickListener paramOnEmotionItemClickListener)
  {
    this.g = paramOnEmotionItemClickListener;
  }
  
  public void setPageIndicator(int paramInt)
  {
    PageIndicator localPageIndicator = this.e;
    if (localPageIndicator != null) {
      localPageIndicator.setPageCount(paramInt);
    }
  }
  
  public void setPanelShowCount(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public void setRecyclerViewPool(@Nullable RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.h = paramRecycledViewPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionPanel
 * JD-Core Version:    0.7.0.1
 */