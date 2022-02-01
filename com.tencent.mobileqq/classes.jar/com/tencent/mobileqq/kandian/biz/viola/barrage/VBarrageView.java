package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/VBarrageView;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageView;", "Lcom/tencent/viola/ui/view/IVView;", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/VBarrage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWeakReference", "Ljava/lang/ref/WeakReference;", "bindComponent", "", "component", "getComponent", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VBarrageView
  extends BarrageView
  implements IVView<VBarrage>
{
  private WeakReference<VBarrage> a;
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public VBarrageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(@NotNull VBarrage paramVBarrage)
  {
    Intrinsics.checkParameterIsNotNull(paramVBarrage, "component");
    this.a = new WeakReference(paramVBarrage);
  }
  
  @Nullable
  public VBarrage getComponent()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (VBarrage)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.VBarrageView
 * JD-Core Version:    0.7.0.1
 */