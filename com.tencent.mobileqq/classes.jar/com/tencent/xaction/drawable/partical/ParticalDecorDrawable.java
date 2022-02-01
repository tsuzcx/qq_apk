package com.tencent.xaction.drawable.partical;

import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/partical/ParticalDecorDrawable;", "Lcom/tencent/xaction/api/base/DecorDrawable;", "()V", "curAnimTime", "", "getCurAnimTime", "()F", "setCurAnimTime", "(F)V", "particles", "", "Lcom/tencent/xaction/drawable/partical/Particle;", "getParticles", "()[Lcom/tencent/xaction/drawable/partical/Particle;", "setParticles", "([Lcom/tencent/xaction/drawable/partical/Particle;)V", "[Lcom/tencent/xaction/drawable/partical/Particle;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "doFrameUpdate", "", "animTime", "end", "preStart", "ParticalDecorDrawableState", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ParticalDecorDrawable
  extends DecorDrawable
{
  private float jdField_a_of_type_Float = 1.0F;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private Particle[] jdField_a_of_type_ArrayOfComTencentXactionDrawableParticalParticle;
  
  public ParticalDecorDrawable()
  {
    setDrawable((IDrawable)new ParticalDrawable());
    IDrawable localIDrawable = getDrawable();
    if (localIDrawable == null) {
      Intrinsics.throwNpe();
    }
    localIDrawable.setDecor((IPublicDecorDrawable)this);
  }
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  @Nullable
  public final Particle[] a()
  {
    return this.jdField_a_of_type_ArrayOfComTencentXactionDrawableParticalParticle;
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.invalidate();
    }
  }
  
  public void end() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = getDecorState();
    if (paramView != null)
    {
      paramView = (ParticalDecorDrawable.ParticalDecorDrawableState)paramView;
      int j = paramView.getCount();
      Particle[] arrayOfParticle = new Particle[j];
      int i = 0;
      while (i < j)
      {
        double d1 = Math.random();
        double d2 = paramView.getScale();
        Double.isNaN(d2);
        float f = (float)(d1 * d2);
        Particle localParticle = new Particle(i);
        d1 = Math.random();
        d2 = paramView.getWidth();
        Double.isNaN(d2);
        localParticle.setX((int)(d1 * d2));
        d1 = Math.random();
        d2 = paramView.getHeight();
        Double.isNaN(d2);
        localParticle.setY((int)(d1 * d2));
        localParticle.setScale(f);
        d1 = Math.random();
        d2 = paramView.getRoundPI();
        Double.isNaN(d2);
        localParticle.setCursor((int)(d1 * d2));
        arrayOfParticle[i] = localParticle;
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfComTencentXactionDrawableParticalParticle = arrayOfParticle;
      return;
    }
    paramView = new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.drawable.partical.ParticalDecorDrawable.ParticalDecorDrawableState");
    for (;;)
    {
      throw paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.partical.ParticalDecorDrawable
 * JD-Core Version:    0.7.0.1
 */