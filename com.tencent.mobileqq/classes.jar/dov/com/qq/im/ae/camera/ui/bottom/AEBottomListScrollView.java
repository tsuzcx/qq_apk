package dov.com.qq.im.ae.camera.ui.bottom;

import abab;
import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import bolk;
import bolx;
import bomc;
import bomd;
import bome;
import bomf;
import boml;
import bomn;
import boqu;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bolx jdField_a_of_type_Bolx;
  private bomd jdField_a_of_type_Bomd;
  private bome jdField_a_of_type_Bome;
  private boolean jdField_a_of_type_Boolean;
  
  public AEBottomListScrollView(Context paramContext)
  {
    super(paramContext);
    a(null);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  public AEBottomListScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bomd == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bolx.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bome != null) {
      this.jdField_a_of_type_Bome.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bome != null) {
      this.jdField_a_of_type_Bome.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bolx = new bolx(getContext(), new bomf(this, null), new bomn());
      setLayoutManager(this.jdField_a_of_type_Bolx);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bomd != null) {
      this.jdField_a_of_type_Bomd.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bome != null) {
      this.jdField_a_of_type_Bome.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bomd != null) {
      this.jdField_a_of_type_Bomd.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bolx.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bolx.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, boqu paramboqu)
  {
    bolk localbolk = (bolk)a(this.jdField_a_of_type_Bolx.b());
    if (localbolk != null) {
      localbolk.a(4);
    }
    localbolk = (bolk)a(paramInt);
    if (localbolk != null)
    {
      localbolk.b(paramboqu);
      localbolk.a(3);
      if ((paramboqu != null) && (paramboqu.e)) {
        localbolk.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bolx.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bolx.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bolx.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bolx.c(paramInt);
  }
  
  public void setItemTransformer(abab paramabab)
  {
    this.jdField_a_of_type_Bolx.a(paramabab);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bolx.a(paramInt);
  }
  
  public void setLayoutCallback(bomc parambomc)
  {
    if (this.jdField_a_of_type_Bolx != null) {
      this.jdField_a_of_type_Bolx.a(parambomc);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bolx))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bolx.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bomd<?> parambomd)
  {
    this.jdField_a_of_type_Bomd = parambomd;
  }
  
  public void setOrientation(boml paramboml)
  {
    this.jdField_a_of_type_Bolx.a(paramboml);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bome<?> parambome)
  {
    this.jdField_a_of_type_Bome = parambome;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bolx.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bolx.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */