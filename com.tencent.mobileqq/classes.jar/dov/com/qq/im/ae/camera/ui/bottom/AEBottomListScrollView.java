package dov.com.qq.im.ae.camera.ui.bottom;

import aavy;
import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import bnkc;
import bnkp;
import bnku;
import bnkv;
import bnkw;
import bnkx;
import bnky;
import bnla;
import bnpf;

public class AEBottomListScrollView
  extends RecyclerView
{
  private static final String jdField_a_of_type_JavaLangString = AEBottomListScrollView.class.getSimpleName();
  private bnkp jdField_a_of_type_Bnkp;
  private bnkv jdField_a_of_type_Bnkv;
  private bnkw jdField_a_of_type_Bnkw;
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
    if (this.jdField_a_of_type_Bnkv == null) {
      return;
    }
    int i = this.jdField_a_of_type_Bnkp.b();
    c(a(i), i);
  }
  
  private void a(float paramFloat, int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (this.jdField_a_of_type_Bnkw != null) {
      this.jdField_a_of_type_Bnkw.a(paramFloat, paramInt1, paramInt2, paramViewHolder1, paramViewHolder2);
    }
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bnkw != null) {
      this.jdField_a_of_type_Bnkw.c(paramViewHolder, paramInt);
    }
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    if (getOverScrollMode() != 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Bnkp = new bnkp(getContext(), new bnkx(this, null), new bnla());
      setLayoutManager(this.jdField_a_of_type_Bnkp);
      return;
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bnkv != null) {
      this.jdField_a_of_type_Bnkv.a(paramViewHolder, true);
    }
    if (this.jdField_a_of_type_Bnkw != null) {
      this.jdField_a_of_type_Bnkw.b(paramViewHolder, paramInt);
    }
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (this.jdField_a_of_type_Bnkv != null) {
      this.jdField_a_of_type_Bnkv.a(paramViewHolder, paramInt);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bnkp.b();
  }
  
  @Nullable
  public RecyclerView.ViewHolder a(int paramInt)
  {
    View localView = this.jdField_a_of_type_Bnkp.findViewByPosition(paramInt);
    if (localView != null) {
      return getChildViewHolder(localView);
    }
    return null;
  }
  
  public void a(int paramInt, bnpf parambnpf)
  {
    bnkc localbnkc = (bnkc)a(this.jdField_a_of_type_Bnkp.b());
    if (localbnkc != null) {
      localbnkc.a(4);
    }
    localbnkc = (bnkc)a(paramInt);
    if (localbnkc != null)
    {
      localbnkc.b(parambnpf);
      localbnkc.a(3);
      if ((parambnpf != null) && (parambnpf.e)) {
        localbnkc.a(2);
      }
      scrollToPosition(paramInt);
    }
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    boolean bool = super.fling(paramInt1, paramInt2);
    if (bool)
    {
      this.jdField_a_of_type_Bnkp.a(paramInt1, paramInt2);
      return bool;
    }
    this.jdField_a_of_type_Bnkp.c();
    return bool;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Bnkp.a(null);
  }
  
  public void setClampTransformProgressAfter(@IntRange(from=1L) int paramInt)
  {
    if (paramInt <= 1) {
      throw new IllegalArgumentException("must be >= 1");
    }
    this.jdField_a_of_type_Bnkp.c(paramInt);
  }
  
  public void setItemTransformer(aavy paramaavy)
  {
    this.jdField_a_of_type_Bnkp.a(paramaavy);
  }
  
  public void setItemTransitionTimeMillis(@IntRange(from=10L) int paramInt)
  {
    this.jdField_a_of_type_Bnkp.a(paramInt);
  }
  
  public void setLayoutCallback(bnku parambnku)
  {
    if (this.jdField_a_of_type_Bnkp != null) {
      this.jdField_a_of_type_Bnkp.a(parambnku);
    }
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof bnkp))
    {
      super.setLayoutManager(paramLayoutManager);
      return;
    }
    throw new IllegalArgumentException("please use special on ");
  }
  
  public void setOffscreenItems(int paramInt)
  {
    this.jdField_a_of_type_Bnkp.b(paramInt);
  }
  
  public void setOnItemChangedListener(@NonNull bnkv<?> parambnkv)
  {
    this.jdField_a_of_type_Bnkv = parambnkv;
  }
  
  public void setOrientation(bnky parambnky)
  {
    this.jdField_a_of_type_Bnkp.a(parambnky);
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    setOverScrollMode(2);
  }
  
  public void setScrollStateChangeListener(@NonNull bnkw<?> parambnkw)
  {
    this.jdField_a_of_type_Bnkw = parambnkw;
  }
  
  public void setSlideOnFling(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bnkp.a(paramBoolean);
  }
  
  public void setSlideOnFlingThreshold(int paramInt)
  {
    this.jdField_a_of_type_Bnkp.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView
 * JD-Core Version:    0.7.0.1
 */