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
import blpq;
import blqd;
import blqi;
import blqj;
import blqk;
import blql;
import blqm;
import blqs;
import blqu;
import blvb;
import zwo;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private blqd jdField_a_of_type_Blqd;
  private blqi jdField_a_of_type_Blqi;
  private blqk jdField_a_of_type_Blqk;
  private blql jdField_a_of_type_Blql;
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
    if (this.jdField_a_of_type_Blqk == null) {
      return;
    }
    int i = this.jdField_a_of_type_Blqd.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Blql != null) {
      this.jdField_a_of_type_Blql.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Blql != null) {
      this.jdField_a_of_type_Blql.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Blqd = new blqd(getContext(), new blqm(this, null), new blqu());
      setLayoutManager(this.jdField_a_of_type_Blqd);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Blqk != null) {
      this.jdField_a_of_type_Blqk.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Blql != null) {
      this.jdField_a_of_type_Blql.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Blqk != null) {
      this.jdField_a_of_type_Blqk.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Blqd.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Blqd.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, blvb paramblvb)
  {
    blpq localblpq = (blpq)a(this.jdField_a_of_type_Blqd.b());
    if (localblpq != null) {
      localblpq.a(4);
    }
    localblpq = (blpq)a(paramInt);
    if (localblpq != null)
    {
      localblpq.b(paramblvb);
      localblpq.a(3);
      if ((paramblvb != null) && (paramblvb.e)) {
        localblpq.a(2);
      }
      if (this.jdField_a_of_type_Blqi != null)
      {
        if ((localblpq.a == null) || (!localblpq.a.jdField_a_of_type_Boolean)) {
          break label103;
        }
        this.jdField_a_of_type_Blqi.a(true);
      }
    }
    for (;;)
    {
      scrollToPosition(paramInt);
      return;
      label103:
      this.jdField_a_of_type_Blqi.a(false);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Blqd.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Blqd.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Blqd.a(null);
  }
  
  public void setAEEditMaterialSelectedListener(@NonNull blqi paramblqi)
  {
    this.jdField_a_of_type_Blqi = paramblqi;
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Blqd.c(paramInt);
  }
  
  public void setItemTransformer(zwo paramzwo)
  {
    this.jdField_a_of_type_Blqd.a(paramzwo);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Blqd.a(paramInt);
  }
  
  public void setLayoutCallback(blqj paramblqj)
  {
    if (this.jdField_a_of_type_Blqd != null) {
      this.jdField_a_of_type_Blqd.a(paramblqj);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof blqd))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Blqd.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull blqk<?> paramblqk)
  {
    this.jdField_a_of_type_Blqk = paramblqk;
  }
  
  public void setOrientation(blqs paramblqs)
  {
    this.jdField_a_of_type_Blqd.a(paramblqs);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull blql<?> paramblql)
  {
    this.jdField_a_of_type_Blql = paramblql;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Blqd.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Blqd.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */