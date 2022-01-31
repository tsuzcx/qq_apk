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
import bkux;
import bkvk;
import bkvp;
import bkvq;
import bkvr;
import bkvs;
import bkvt;
import bkvv;
import blab;
import yyv;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bkvk jdField_a_of_type_Bkvk;
  private bkvq jdField_a_of_type_Bkvq;
  private bkvr jdField_a_of_type_Bkvr;
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
    if (this.jdField_a_of_type_Bkvq == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bkvk.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bkvr != null) {
      this.jdField_a_of_type_Bkvr.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkvr != null) {
      this.jdField_a_of_type_Bkvr.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bkvk = new bkvk(getContext(), new bkvs(this, null), new bkvv());
      setLayoutManager(this.jdField_a_of_type_Bkvk);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkvq != null) {
      this.jdField_a_of_type_Bkvq.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bkvr != null) {
      this.jdField_a_of_type_Bkvr.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bkvq != null) {
      this.jdField_a_of_type_Bkvq.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bkvk.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bkvk.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, blab paramblab)
  {
    bkux localbkux = (bkux)a(this.jdField_a_of_type_Bkvk.b());
    if (localbkux != null) {
      localbkux.a(4);
    }
    localbkux = (bkux)a(paramInt);
    if (localbkux != null)
    {
      localbkux.b(paramblab);
      localbkux.a(3);
      if ((paramblab != null) && (paramblab.d)) {
        localbkux.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bkvk.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bkvk.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bkvk.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bkvk.c(paramInt);
  }
  
  public void setItemTransformer(yyv paramyyv)
  {
    this.jdField_a_of_type_Bkvk.a(paramyyv);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bkvk.a(paramInt);
  }
  
  public void setLayoutCallback(bkvp parambkvp)
  {
    if (this.jdField_a_of_type_Bkvk != null) {
      this.jdField_a_of_type_Bkvk.a(parambkvp);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bkvk))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bkvk.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bkvq<?> parambkvq)
  {
    this.jdField_a_of_type_Bkvq = parambkvq;
  }
  
  public void setOrientation(bkvt parambkvt)
  {
    this.jdField_a_of_type_Bkvk.a(parambkvt);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bkvr<?> parambkvr)
  {
    this.jdField_a_of_type_Bkvr = parambkvr;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bkvk.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bkvk.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */