package com.tencent.xaction.drawable;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/DrawableAnim;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "DEFAULT", "", "getDEFAULT", "()I", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "getDrawable", "()Lcom/tencent/xaction/api/IDrawable;", "setDrawable", "(Lcom/tencent/xaction/api/IDrawable;)V", "drawableId", "getDrawableId", "setDrawableId", "(I)V", "hierarchy", "getHierarchy", "setHierarchy", "isPlay", "", "()Z", "setPlay", "(Z)V", "doFrameUpdate", "", "animTime", "", "end", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class DrawableAnim
  extends BaseAnim
{
  private final int jdField_a_of_type_Int = -1;
  @Nullable
  private transient IDrawable jdField_a_of_type_ComTencentXactionApiIDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int b = this.jdField_a_of_type_Int;
  private int c;
  
  public void doFrameUpdate(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentXactionApiIDrawable;
      if (localObject != null)
      {
        this.jdField_a_of_type_Boolean = true;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((IDrawable)localObject).getDecor();
        if (localObject != null) {
          ((IPublicDecorDrawable)localObject).play();
        }
      }
    }
  }
  
  public void end()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    if ((this.b != this.jdField_a_of_type_Int) && (Build.VERSION.SDK_INT >= 16))
    {
      DecorDrawable.Companion localCompanion = DecorDrawable.Companion;
      IXAEngine localIXAEngine = getEngine();
      if (localIXAEngine != null)
      {
        this.jdField_a_of_type_ComTencentXactionApiIDrawable = DecorDrawable.Companion.a(localCompanion, (XAEngine)localIXAEngine, this.b, this.c, paramView, true, false, 32, null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.DrawableAnim
 * JD-Core Version:    0.7.0.1
 */