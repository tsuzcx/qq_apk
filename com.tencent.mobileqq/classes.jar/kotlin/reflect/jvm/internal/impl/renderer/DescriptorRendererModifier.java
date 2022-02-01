package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

public enum DescriptorRendererModifier
{
  @JvmField
  @NotNull
  public static final Set<DescriptorRendererModifier> ALL = ArraysKt.toSet(values());
  @JvmField
  @NotNull
  public static final Set<DescriptorRendererModifier> ALL_EXCEPT_ANNOTATIONS;
  public static final DescriptorRendererModifier.Companion Companion;
  private final boolean includeByDefault;
  
  static
  {
    int i = 0;
    Object localObject1 = new DescriptorRendererModifier("VISIBILITY", 0, true);
    VISIBILITY = (DescriptorRendererModifier)localObject1;
    Object localObject2 = new DescriptorRendererModifier("MODALITY", 1, true);
    MODALITY = (DescriptorRendererModifier)localObject2;
    DescriptorRendererModifier localDescriptorRendererModifier1 = new DescriptorRendererModifier("OVERRIDE", 2, true);
    OVERRIDE = localDescriptorRendererModifier1;
    DescriptorRendererModifier localDescriptorRendererModifier2 = new DescriptorRendererModifier("ANNOTATIONS", 3, false);
    ANNOTATIONS = localDescriptorRendererModifier2;
    DescriptorRendererModifier localDescriptorRendererModifier3 = new DescriptorRendererModifier("INNER", 4, true);
    INNER = localDescriptorRendererModifier3;
    DescriptorRendererModifier localDescriptorRendererModifier4 = new DescriptorRendererModifier("MEMBER_KIND", 5, true);
    MEMBER_KIND = localDescriptorRendererModifier4;
    DescriptorRendererModifier localDescriptorRendererModifier5 = new DescriptorRendererModifier("DATA", 6, true);
    DATA = localDescriptorRendererModifier5;
    DescriptorRendererModifier localDescriptorRendererModifier6 = new DescriptorRendererModifier("INLINE", 7, true);
    INLINE = localDescriptorRendererModifier6;
    DescriptorRendererModifier localDescriptorRendererModifier7 = new DescriptorRendererModifier("EXPECT", 8, true);
    EXPECT = localDescriptorRendererModifier7;
    DescriptorRendererModifier localDescriptorRendererModifier8 = new DescriptorRendererModifier("ACTUAL", 9, true);
    ACTUAL = localDescriptorRendererModifier8;
    DescriptorRendererModifier localDescriptorRendererModifier9 = new DescriptorRendererModifier("CONST", 10, true);
    CONST = localDescriptorRendererModifier9;
    DescriptorRendererModifier localDescriptorRendererModifier10 = new DescriptorRendererModifier("LATEINIT", 11, true);
    LATEINIT = localDescriptorRendererModifier10;
    $VALUES = new DescriptorRendererModifier[] { localObject1, localObject2, localDescriptorRendererModifier1, localDescriptorRendererModifier2, localDescriptorRendererModifier3, localDescriptorRendererModifier4, localDescriptorRendererModifier5, localDescriptorRendererModifier6, localDescriptorRendererModifier7, localDescriptorRendererModifier8, localDescriptorRendererModifier9, localDescriptorRendererModifier10 };
    Companion = new DescriptorRendererModifier.Companion(null);
    localObject1 = values();
    localObject2 = (Collection)new ArrayList();
    int j = localObject1.length;
    while (i < j)
    {
      localDescriptorRendererModifier1 = localObject1[i];
      if (localDescriptorRendererModifier1.includeByDefault) {
        ((Collection)localObject2).add(localDescriptorRendererModifier1);
      }
      i += 1;
    }
    ALL_EXCEPT_ANNOTATIONS = CollectionsKt.toSet((Iterable)localObject2);
  }
  
  private DescriptorRendererModifier(boolean paramBoolean)
  {
    this.includeByDefault = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier
 * JD-Core Version:    0.7.0.1
 */