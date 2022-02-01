package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DescriptorRenderer
{
  @JvmField
  @NotNull
  public static final DescriptorRenderer COMPACT;
  @JvmField
  @NotNull
  public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
  @JvmField
  @NotNull
  public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
  @JvmField
  @NotNull
  public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
  public static final DescriptorRenderer.Companion Companion = new DescriptorRenderer.Companion(null);
  @JvmField
  @NotNull
  public static final DescriptorRenderer DEBUG_TEXT = Companion.withOptions((Function1)DescriptorRenderer.Companion.DEBUG_TEXT.1.INSTANCE);
  @JvmField
  @NotNull
  public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
  @JvmField
  @NotNull
  public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
  @JvmField
  @NotNull
  public static final DescriptorRenderer HTML = Companion.withOptions((Function1)DescriptorRenderer.Companion.HTML.1.INSTANCE);
  @JvmField
  @NotNull
  public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
  @JvmField
  @NotNull
  public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;
  
  static
  {
    COMPACT_WITH_MODIFIERS = Companion.withOptions((Function1)DescriptorRenderer.Companion.COMPACT_WITH_MODIFIERS.1.INSTANCE);
    COMPACT = Companion.withOptions((Function1)DescriptorRenderer.Companion.COMPACT.1.INSTANCE);
    COMPACT_WITHOUT_SUPERTYPES = Companion.withOptions((Function1)DescriptorRenderer.Companion.COMPACT_WITHOUT_SUPERTYPES.1.INSTANCE);
    COMPACT_WITH_SHORT_TYPES = Companion.withOptions((Function1)DescriptorRenderer.Companion.COMPACT_WITH_SHORT_TYPES.1.INSTANCE);
    ONLY_NAMES_WITH_SHORT_TYPES = Companion.withOptions((Function1)DescriptorRenderer.Companion.ONLY_NAMES_WITH_SHORT_TYPES.1.INSTANCE);
    FQ_NAMES_IN_TYPES = Companion.withOptions((Function1)DescriptorRenderer.Companion.FQ_NAMES_IN_TYPES.1.INSTANCE);
    FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = Companion.withOptions((Function1)DescriptorRenderer.Companion.FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS.1.INSTANCE);
    SHORT_NAMES_IN_TYPES = Companion.withOptions((Function1)DescriptorRenderer.Companion.SHORT_NAMES_IN_TYPES.1.INSTANCE);
  }
  
  @NotNull
  public abstract String render(@NotNull DeclarationDescriptor paramDeclarationDescriptor);
  
  @NotNull
  public abstract String renderAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor, @Nullable AnnotationUseSiteTarget paramAnnotationUseSiteTarget);
  
  @NotNull
  public abstract String renderFlexibleType(@NotNull String paramString1, @NotNull String paramString2, @NotNull KotlinBuiltIns paramKotlinBuiltIns);
  
  @NotNull
  public abstract String renderFqName(@NotNull FqNameUnsafe paramFqNameUnsafe);
  
  @NotNull
  public abstract String renderName(@NotNull Name paramName, boolean paramBoolean);
  
  @NotNull
  public abstract String renderType(@NotNull KotlinType paramKotlinType);
  
  @NotNull
  public abstract String renderTypeProjection(@NotNull TypeProjection paramTypeProjection);
  
  @NotNull
  public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "changeOptions");
    DescriptorRendererOptionsImpl localDescriptorRendererOptionsImpl = ((DescriptorRendererImpl)this).getOptions().copy();
    paramFunction1.invoke(localDescriptorRendererOptionsImpl);
    localDescriptorRendererOptionsImpl.lock();
    return (DescriptorRenderer)new DescriptorRendererImpl(localDescriptorRendererOptionsImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
 * JD-Core Version:    0.7.0.1
 */