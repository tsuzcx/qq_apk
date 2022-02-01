package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRenderer$Companion
{
  @NotNull
  public final String getClassifierKindPrefix(@NotNull ClassifierDescriptorWithTypeParameters paramClassifierDescriptorWithTypeParameters)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptorWithTypeParameters, "classifier");
    if ((paramClassifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor)) {
      return "typealias";
    }
    if ((paramClassifierDescriptorWithTypeParameters instanceof ClassDescriptor))
    {
      paramClassifierDescriptorWithTypeParameters = (ClassDescriptor)paramClassifierDescriptorWithTypeParameters;
      if (paramClassifierDescriptorWithTypeParameters.isCompanionObject()) {
        return "companion object";
      }
      paramClassifierDescriptorWithTypeParameters = paramClassifierDescriptorWithTypeParameters.getKind();
      switch (DescriptorRenderer.Companion.WhenMappings.$EnumSwitchMapping$0[paramClassifierDescriptorWithTypeParameters.ordinal()])
      {
      default: 
        throw new NoWhenBranchMatchedException();
      case 6: 
        return "enum entry";
      case 5: 
        return "annotation class";
      case 4: 
        return "object";
      case 3: 
        return "enum class";
      case 2: 
        return "interface";
      }
      return "class";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected classifier: ");
    localStringBuilder.append(paramClassifierDescriptorWithTypeParameters);
    throw ((Throwable)new AssertionError(localStringBuilder.toString()));
  }
  
  @NotNull
  public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "changeOptions");
    DescriptorRendererOptionsImpl localDescriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
    paramFunction1.invoke(localDescriptorRendererOptionsImpl);
    localDescriptorRendererOptionsImpl.lock();
    return (DescriptorRenderer)new DescriptorRendererImpl(localDescriptorRendererOptionsImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion
 * JD-Core Version:    0.7.0.1
 */