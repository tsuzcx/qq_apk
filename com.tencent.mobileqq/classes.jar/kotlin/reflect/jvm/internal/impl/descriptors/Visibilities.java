package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Visibilities
{
  public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER;
  public static final Visibility DEFAULT_VISIBILITY;
  @Deprecated
  public static final ReceiverValue FALSE_IF_PROTECTED;
  @NotNull
  public static final Visibility INHERITED;
  @NotNull
  public static final Visibility INTERNAL;
  @NotNull
  public static final Visibility INVISIBLE_FAKE;
  public static final Set<Visibility> INVISIBLE_FROM_OTHER_MODULES;
  private static final ReceiverValue IRRELEVANT_RECEIVER;
  @NotNull
  public static final Visibility LOCAL;
  @NotNull
  private static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
  private static final Map<Visibility, Integer> ORDERED_VISIBILITIES;
  @NotNull
  public static final Visibility PRIVATE;
  @NotNull
  public static final Visibility PRIVATE_TO_THIS;
  @NotNull
  public static final Visibility PROTECTED;
  @NotNull
  public static final Visibility PUBLIC;
  @NotNull
  public static final Visibility UNKNOWN;
  
  static
  {
    Object localObject = Integer.valueOf(0);
    PRIVATE = new Visibilities.1("private", false);
    PRIVATE_TO_THIS = new Visibilities.2("private_to_this", false);
    Integer localInteger = Integer.valueOf(1);
    PROTECTED = new Visibilities.3("protected", true);
    INTERNAL = new Visibilities.4("internal", false);
    PUBLIC = new Visibilities.5("public", true);
    LOCAL = new Visibilities.6("local", false);
    INHERITED = new Visibilities.7("inherited", false);
    INVISIBLE_FAKE = new Visibilities.8("invisible_fake", false);
    UNKNOWN = new Visibilities.9("unknown", false);
    INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt.setOf(new Visibility[] { PRIVATE, PRIVATE_TO_THIS, INTERNAL, LOCAL }));
    HashMap localHashMap = CollectionsKt.newHashMapWithExpectedSize(4);
    localHashMap.put(PRIVATE_TO_THIS, localObject);
    localHashMap.put(PRIVATE, localObject);
    localHashMap.put(INTERNAL, localInteger);
    localHashMap.put(PROTECTED, localInteger);
    localHashMap.put(PUBLIC, Integer.valueOf(2));
    ORDERED_VISIBILITIES = Collections.unmodifiableMap(localHashMap);
    DEFAULT_VISIBILITY = PUBLIC;
    IRRELEVANT_RECEIVER = new Visibilities.10();
    ALWAYS_SUITABLE_RECEIVER = new Visibilities.11();
    FALSE_IF_PROTECTED = new Visibilities.12();
    localObject = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
    if (((Iterator)localObject).hasNext()) {
      localObject = (ModuleVisibilityHelper)((Iterator)localObject).next();
    } else {
      localObject = ModuleVisibilityHelper.EMPTY.INSTANCE;
    }
    MODULE_VISIBILITY_HELPER = (ModuleVisibilityHelper)localObject;
  }
  
  @Nullable
  public static Integer compare(@NotNull Visibility paramVisibility1, @NotNull Visibility paramVisibility2)
  {
    if (paramVisibility1 == null) {
      $$$reportNull$$$0(12);
    }
    if (paramVisibility2 == null) {
      $$$reportNull$$$0(13);
    }
    Integer localInteger = paramVisibility1.compareTo(paramVisibility2);
    if (localInteger != null) {
      return localInteger;
    }
    paramVisibility1 = paramVisibility2.compareTo(paramVisibility1);
    if (paramVisibility1 != null) {
      return Integer.valueOf(-paramVisibility1.intValue());
    }
    return null;
  }
  
  @Nullable
  static Integer compareLocal(@NotNull Visibility paramVisibility1, @NotNull Visibility paramVisibility2)
  {
    if (paramVisibility1 == null) {
      $$$reportNull$$$0(10);
    }
    if (paramVisibility2 == null) {
      $$$reportNull$$$0(11);
    }
    if (paramVisibility1 == paramVisibility2) {
      return Integer.valueOf(0);
    }
    paramVisibility1 = (Integer)ORDERED_VISIBILITIES.get(paramVisibility1);
    paramVisibility2 = (Integer)ORDERED_VISIBILITIES.get(paramVisibility2);
    if ((paramVisibility1 != null) && (paramVisibility2 != null) && (!paramVisibility1.equals(paramVisibility2))) {
      return Integer.valueOf(paramVisibility1.intValue() - paramVisibility2.intValue());
    }
    return null;
  }
  
  @Nullable
  public static DeclarationDescriptorWithVisibility findInvisibleMember(@Nullable ReceiverValue paramReceiverValue, @NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(8);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(9);
    }
    for (DeclarationDescriptorWithVisibility localDeclarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility)paramDeclarationDescriptorWithVisibility.getOriginal(); (localDeclarationDescriptorWithVisibility != null) && (localDeclarationDescriptorWithVisibility.getVisibility() != LOCAL); localDeclarationDescriptorWithVisibility = (DeclarationDescriptorWithVisibility)DescriptorUtils.getParentOfType(localDeclarationDescriptorWithVisibility, DeclarationDescriptorWithVisibility.class)) {
      if (!localDeclarationDescriptorWithVisibility.getVisibility().isVisible(paramReceiverValue, localDeclarationDescriptorWithVisibility, paramDeclarationDescriptor)) {
        return localDeclarationDescriptorWithVisibility;
      }
    }
    if ((paramDeclarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor))
    {
      paramReceiverValue = findInvisibleMember(paramReceiverValue, ((TypeAliasConstructorDescriptor)paramDeclarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), paramDeclarationDescriptor);
      if (paramReceiverValue != null) {
        return paramReceiverValue;
      }
    }
    return null;
  }
  
  public static boolean inSameFile(@NotNull DeclarationDescriptor paramDeclarationDescriptor1, @NotNull DeclarationDescriptor paramDeclarationDescriptor2)
  {
    if (paramDeclarationDescriptor1 == null) {
      $$$reportNull$$$0(6);
    }
    if (paramDeclarationDescriptor2 == null) {
      $$$reportNull$$$0(7);
    }
    paramDeclarationDescriptor2 = DescriptorUtils.getContainingSourceFile(paramDeclarationDescriptor2);
    if (paramDeclarationDescriptor2 != SourceFile.NO_SOURCE_FILE) {
      return paramDeclarationDescriptor2.equals(DescriptorUtils.getContainingSourceFile(paramDeclarationDescriptor1));
    }
    return false;
  }
  
  public static boolean isPrivate(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(14);
    }
    return (paramVisibility == PRIVATE) || (paramVisibility == PRIVATE_TO_THIS);
  }
  
  public static boolean isVisibleIgnoringReceiver(@NotNull DeclarationDescriptorWithVisibility paramDeclarationDescriptorWithVisibility, @NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptorWithVisibility == null) {
      $$$reportNull$$$0(2);
    }
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, paramDeclarationDescriptorWithVisibility, paramDeclarationDescriptor) == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.Visibilities
 * JD-Core Version:    0.7.0.1
 */