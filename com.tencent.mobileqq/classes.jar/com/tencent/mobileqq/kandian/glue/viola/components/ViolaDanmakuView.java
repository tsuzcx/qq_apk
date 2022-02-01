package com.tencent.mobileqq.kandian.glue.viola.components;

import android.content.Context;
import com.tencent.viola.ui.component.VDiv;
import com.tencent.viola.ui.view.VFrameLayout;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/components/ViolaDanmakuView;", "Lcom/tencent/viola/ui/view/VFrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "componentWeakRef", "Lmqq/util/WeakReference;", "Lcom/tencent/viola/ui/component/VDiv;", "getComponentWeakRef", "()Lmqq/util/WeakReference;", "setComponentWeakRef", "(Lmqq/util/WeakReference;)V", "bindComponent", "", "component", "getComponent", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaDanmakuView
  extends VFrameLayout
{
  @Nullable
  private WeakReference<VDiv> a;
  
  public ViolaDanmakuView(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindComponent(@Nullable VDiv paramVDiv)
  {
    this.a = new WeakReference(paramVDiv);
  }
  
  @Nullable
  public VDiv getComponent()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (VDiv)localWeakReference.get();
    }
    return null;
  }
  
  @Nullable
  public final WeakReference<VDiv> getComponentWeakRef()
  {
    return this.a;
  }
  
  public final void setComponentWeakRef(@Nullable WeakReference<VDiv> paramWeakReference)
  {
    this.a = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.components.ViolaDanmakuView
 * JD-Core Version:    0.7.0.1
 */