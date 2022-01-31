package dov.com.qq.im.ae.camera.ui.bottom;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import bkqq;
import bkrd;
import bkri;
import bkrj;
import bkrk;
import bkrl;
import bkrm;
import bkro;
import bkvu;
import yug;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bkrd jdField_a_of_type_Bkrd;
  private bkrj jdField_a_of_type_Bkrj;
  private bkrk jdField_a_of_type_Bkrk;
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
    if (this.jdField_a_of_type_Bkrj == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bkrd.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bkrk != null) {
      this.jdField_a_of_type_Bkrk.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkrk != null) {
      this.jdField_a_of_type_Bkrk.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bkrd = new bkrd(getContext(), new bkrl(this, null), new bkro());
      setLayoutManager(this.jdField_a_of_type_Bkrd);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkrj != null) {
      this.jdField_a_of_type_Bkrj.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bkrk != null) {
      this.jdField_a_of_type_Bkrk.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkrj != null) {
      this.jdField_a_of_type_Bkrj.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bkrd.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bkrd.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, bkvu parambkvu)
  {
    bkqq localbkqq = (bkqq)a(this.jdField_a_of_type_Bkrd.b());
    if (localbkqq != null) {
      localbkqq.a(4);
    }
    localbkqq = (bkqq)a(paramInt);
    if (localbkqq != null)
    {
      localbkqq.b(parambkvu);
      localbkqq.a(3);
      if ((parambkvu != null) && (parambkvu.d)) {
        localbkqq.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bkrd.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bkrd.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bkrd.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bkrd.c(paramInt);
  }
  
  public void setItemTransformer(yug paramyug)
  {
    this.jdField_a_of_type_Bkrd.a(paramyug);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bkrd.a(paramInt);
  }
  
  public void setLayoutCallback(bkri parambkri)
  {
    if (this.jdField_a_of_type_Bkrd != null) {
      this.jdField_a_of_type_Bkrd.a(parambkri);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bkrd))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bkrd.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bkrj<?> parambkrj)
  {
    this.jdField_a_of_type_Bkrj = parambkrj;
  }
  
  public void setOrientation(bkrm parambkrm)
  {
    this.jdField_a_of_type_Bkrd.a(parambkrm);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bkrk<?> parambkrk)
  {
    this.jdField_a_of_type_Bkrk = parambkrk;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkrd.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bkrd.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */