package dov.com.qq.im.ae.camera.ui.bottom;

import aama;
import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import bncz;
import bndm;
import bndr;
import bnds;
import bndt;
import bndu;
import bndv;
import bneb;
import bned;
import bnke;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bndm jdField_a_of_type_Bndm;
  private bndr jdField_a_of_type_Bndr;
  private bndt jdField_a_of_type_Bndt;
  private bndu jdField_a_of_type_Bndu;
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
    if (this.jdField_a_of_type_Bndt == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bndm.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bndu != null) {
      this.jdField_a_of_type_Bndu.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bndu != null) {
      this.jdField_a_of_type_Bndu.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bndm = new bndm(getContext(), new bndv(this, null), new bned());
      setLayoutManager(this.jdField_a_of_type_Bndm);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bndt != null) {
      this.jdField_a_of_type_Bndt.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bndu != null) {
      this.jdField_a_of_type_Bndu.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bndt != null) {
      this.jdField_a_of_type_Bndt.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bndm.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bndm.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, bnke parambnke)
  {
    bncz localbncz = (bncz)a(this.jdField_a_of_type_Bndm.b());
    if (localbncz != null) {
      localbncz.a(4);
    }
    localbncz = (bncz)a(paramInt);
    if (localbncz != null)
    {
      localbncz.b(parambnke);
      localbncz.a(3);
      if ((parambnke != null) && (parambnke.e)) {
        localbncz.a(2);
      }
      if (this.jdField_a_of_type_Bndr != null)
      {
        if ((localbncz.a == null) || ("0".equals(localbncz.a.jdField_a_of_type_JavaLangString)) || (!localbncz.a.jdField_a_of_type_Boolean)) {
          break label118;
        }
        this.jdField_a_of_type_Bndr.a(true);
      }
    }
    for (;;)
    {
      scrollToPosition(paramInt);
      return;
      label118:
      this.jdField_a_of_type_Bndr.a(false);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bndm.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bndm.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bndm.a(null);
  }
  
  public void setAEEditMaterialSelectedListener(@NonNull bndr parambndr)
  {
    this.jdField_a_of_type_Bndr = parambndr;
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bndm.c(paramInt);
  }
  
  public void setItemTransformer(aama paramaama)
  {
    this.jdField_a_of_type_Bndm.a(paramaama);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bndm.a(paramInt);
  }
  
  public void setLayoutCallback(bnds parambnds)
  {
    if (this.jdField_a_of_type_Bndm != null) {
      this.jdField_a_of_type_Bndm.a(parambnds);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bndm))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bndm.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bndt<?> parambndt)
  {
    this.jdField_a_of_type_Bndt = parambndt;
  }
  
  public void setOrientation(bneb parambneb)
  {
    this.jdField_a_of_type_Bndm.a(parambneb);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bndu<?> parambndu)
  {
    this.jdField_a_of_type_Bndu = parambndu;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bndm.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bndm.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */