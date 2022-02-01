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
import com.tencent.tkd.comment.util.CollectionUtil;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseEmotionPanel
  extends FrameLayout
  implements IEmotionPanel
{
  protected int a;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private RecyclerView.RecycledViewPool jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  @Nullable
  private OnEmotionItemClickListener jdField_a_of_type_ComTencentTkdCommentPanelBaseListenerOnEmotionItemClickListener;
  private PageIndicator jdField_a_of_type_ComTencentTkdCommentPanelBaseViewPageIndicator;
  private List<RecyclerView> jdField_a_of_type_JavaUtilList;
  protected int b;
  protected int c;
  
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
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new BaseEmotionPanel.1(this));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.addOnPageChangeListener(new BaseEmotionPanel.2(this));
  }
  
  protected int a()
  {
    return R.layout.jdField_a_of_type_Int;
  }
  
  public ViewPager a()
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewViewPager;
  }
  
  @Nullable
  public RecyclerView.RecycledViewPool a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool;
  }
  
  @Nullable
  public OnEmotionItemClickListener a()
  {
    return this.jdField_a_of_type_ComTencentTkdCommentPanelBaseListenerOnEmotionItemClickListener;
  }
  
  @NotNull
  protected List<RecyclerView> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a(@NotNull Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(a(), this, true);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(R.id.b));
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      paramContext = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getLayoutParams();
      paramContext.leftMargin = b();
      paramContext.rightMargin = b();
      paramContext.topMargin = c();
      paramContext.bottomMargin = d();
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(paramContext);
    }
    this.jdField_a_of_type_ComTencentTkdCommentPanelBaseViewPageIndicator = ((PageIndicator)findViewById(R.id.jdField_a_of_type_Int));
    a();
  }
  
  protected boolean a()
  {
    return CollectionUtil.isEmpty(a());
  }
  
  protected int b()
  {
    return getResources().getDimensionPixelOffset(R.dimen.b);
  }
  
  protected int c()
  {
    return 0;
  }
  
  protected int d()
  {
    return getResources().getDimensionPixelOffset(R.dimen.jdField_a_of_type_Int);
  }
  
  public void setOnEmotionItemClickListener(@Nullable OnEmotionItemClickListener paramOnEmotionItemClickListener)
  {
    this.jdField_a_of_type_ComTencentTkdCommentPanelBaseListenerOnEmotionItemClickListener = paramOnEmotionItemClickListener;
  }
  
  public void setPageIndicator(int paramInt)
  {
    PageIndicator localPageIndicator = this.jdField_a_of_type_ComTencentTkdCommentPanelBaseViewPageIndicator;
    if (localPageIndicator != null) {
      localPageIndicator.setPageCount(paramInt);
    }
  }
  
  public void setPanelShowCount(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public void setRecyclerViewPool(@Nullable RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$RecycledViewPool = paramRecycledViewPool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.BaseEmotionPanel
 * JD-Core Version:    0.7.0.1
 */