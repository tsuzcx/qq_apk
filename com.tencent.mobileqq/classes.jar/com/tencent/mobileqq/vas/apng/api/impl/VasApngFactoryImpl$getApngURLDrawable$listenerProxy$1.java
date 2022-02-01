package com.tencent.mobileqq.vas.apng.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/apng/api/impl/VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "d", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "t", "", "onLoadProgressed", "progress", "", "onLoadSuccessed", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1
  implements URLDrawable.URLDrawableListener
{
  VasApngFactoryImpl$getApngURLDrawable$listenerProxy$1(ApngOptions paramApngOptions) {}
  
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "d");
    VasApngFactoryImpl.access$doOnMainThread(this.jdField_a_of_type_ComTencentMobileqqVasApngApiImplVasApngFactoryImpl, (Function0)new VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadCanceled.1(this, paramURLDrawable));
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "d");
    VasApngFactoryImpl.access$doOnMainThread(this.jdField_a_of_type_ComTencentMobileqqVasApngApiImplVasApngFactoryImpl, (Function0)new VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadFialed.1(this, paramURLDrawable, paramThrowable));
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "d");
    VasApngFactoryImpl.access$doOnMainThread(this.jdField_a_of_type_ComTencentMobileqqVasApngApiImplVasApngFactoryImpl, (Function0)new VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadProgressed.1(this, paramURLDrawable, paramInt));
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "d");
    VasApngFactoryImpl.access$doOnMainThread(this.jdField_a_of_type_ComTencentMobileqqVasApngApiImplVasApngFactoryImpl, (Function0)new VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1.onLoadSuccessed.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1
 * JD-Core Version:    0.7.0.1
 */