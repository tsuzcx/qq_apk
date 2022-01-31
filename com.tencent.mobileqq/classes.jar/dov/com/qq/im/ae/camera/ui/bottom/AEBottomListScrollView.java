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
import bilz;
import bimn;
import bims;
import bimt;
import bimu;
import bimv;
import bimw;
import bimy;
import bire;
import xfn;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bimn jdField_a_of_type_Bimn;
  private bimt jdField_a_of_type_Bimt;
  private bimu jdField_a_of_type_Bimu;
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
    if (this.jdField_a_of_type_Bimt == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bimn.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bimu != null) {
      this.jdField_a_of_type_Bimu.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bimu != null) {
      this.jdField_a_of_type_Bimu.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bimn = new bimn(getContext(), new bimv(this, null), new bimy());
      setLayoutManager(this.jdField_a_of_type_Bimn);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bimt != null) {
      this.jdField_a_of_type_Bimt.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bimu != null) {
      this.jdField_a_of_type_Bimu.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bimt != null) {
      this.jdField_a_of_type_Bimt.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bimn.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bimn.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, bire parambire)
  {
    bilz localbilz = (bilz)a(this.jdField_a_of_type_Bimn.b());
    if (localbilz != null) {
      localbilz.a(4);
    }
    localbilz = (bilz)a(paramInt);
    if (localbilz != null)
    {
      localbilz.b(parambire);
      localbilz.a(3);
      if ((parambire != null) && (parambire.d)) {
        localbilz.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bimn.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bimn.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bimn.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bimn.c(paramInt);
  }
  
  public void setItemTransformer(xfn paramxfn)
  {
    this.jdField_a_of_type_Bimn.a(paramxfn);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bimn.a(paramInt);
  }
  
  public void setLayoutCallback(bims parambims)
  {
    if (this.jdField_a_of_type_Bimn != null) {
      this.jdField_a_of_type_Bimn.a(parambims);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bimn))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bimn.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bimt<?> parambimt)
  {
    this.jdField_a_of_type_Bimt = parambimt;
  }
  
  public void setOrientation(bimw parambimw)
  {
    this.jdField_a_of_type_Bimn.a(parambimw);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bimu<?> parambimu)
  {
    this.jdField_a_of_type_Bimu = parambimu;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bimn.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bimn.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */