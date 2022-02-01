package com.tencent.mobileqq.vas.adv.base.support.gdt;

import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasExposureReference;", "R", "", "Ljava/lang/ref/WeakReference;", "referent", "(Ljava/lang/Object;)V", "q", "Ljava/lang/ref/ReferenceQueue;", "(Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V", "bizCallbackRef", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "getBizCallbackRef", "()Ljava/lang/ref/WeakReference;", "setBizCallbackRef", "(Ljava/lang/ref/WeakReference;)V", "exposureUrl", "", "getExposureUrl", "()Ljava/lang/String;", "setExposureUrl", "(Ljava/lang/String;)V", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasExposureReference<R>
  extends WeakReference<R>
{
  @Nullable
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private WeakReference<VasResultCallback<Boolean>> jdField_a_of_type_JavaLangRefWeakReference;
  
  public VasExposureReference(@NotNull R paramR)
  {
    super(paramR);
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final WeakReference<VasResultCallback<Boolean>> a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable WeakReference<VasResultCallback<Boolean>> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasExposureReference
 * JD-Core Version:    0.7.0.1
 */