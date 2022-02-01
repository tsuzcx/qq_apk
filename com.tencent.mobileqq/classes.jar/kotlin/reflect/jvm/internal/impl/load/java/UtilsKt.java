package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix;
import kotlin.reflect.jvm.internal.impl.utils.NumbersKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UtilsKt
{
  @Nullable
  public static final JavaDefaultValue lexicalCastFrom(@NotNull KotlinType paramKotlinType, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$lexicalCastFrom");
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    Object localObject2 = paramKotlinType.getConstructor().getDeclarationDescriptor();
    boolean bool = localObject2 instanceof ClassDescriptor;
    Object localObject1 = null;
    NumberWithRadix localNumberWithRadix = null;
    if (bool)
    {
      localObject2 = (ClassDescriptor)localObject2;
      if (((ClassDescriptor)localObject2).getKind() == ClassKind.ENUM_CLASS)
      {
        paramKotlinType = ((ClassDescriptor)localObject2).getUnsubstitutedInnerClassesScope();
        paramString = Name.identifier(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "Name.identifier(value)");
        paramString = paramKotlinType.getContributedClassifier(paramString, (LookupLocation)NoLookupLocation.FROM_BACKEND);
        paramKotlinType = localNumberWithRadix;
        if ((paramString instanceof ClassDescriptor))
        {
          paramString = (ClassDescriptor)paramString;
          paramKotlinType = localNumberWithRadix;
          if (paramString.getKind() == ClassKind.ENUM_ENTRY) {
            paramKotlinType = (JavaDefaultValue)new EnumEntry(paramString);
          }
        }
        return paramKotlinType;
      }
    }
    paramKotlinType = TypeUtilsKt.makeNotNullable(paramKotlinType);
    localNumberWithRadix = NumbersKt.extractRadix(paramString);
    localObject2 = localNumberWithRadix.component1();
    int i = localNumberWithRadix.component2();
    try
    {
      if (KotlinBuiltIns.isBoolean(paramKotlinType))
      {
        paramString = Boolean.valueOf(Boolean.parseBoolean(paramString));
      }
      else if (KotlinBuiltIns.isChar(paramKotlinType))
      {
        paramString = StringsKt.singleOrNull((CharSequence)paramString);
      }
      else if (KotlinBuiltIns.isByte(paramKotlinType))
      {
        paramString = StringsKt.toByteOrNull((String)localObject2, i);
      }
      else if (KotlinBuiltIns.isShort(paramKotlinType))
      {
        paramString = StringsKt.toShortOrNull((String)localObject2, i);
      }
      else if (KotlinBuiltIns.isInt(paramKotlinType))
      {
        paramString = StringsKt.toIntOrNull((String)localObject2, i);
      }
      else if (KotlinBuiltIns.isLong(paramKotlinType))
      {
        paramString = StringsKt.toLongOrNull((String)localObject2, i);
      }
      else if (KotlinBuiltIns.isFloat(paramKotlinType))
      {
        paramString = StringsKt.toFloatOrNull(paramString);
      }
      else if (KotlinBuiltIns.isDouble(paramKotlinType))
      {
        paramString = StringsKt.toDoubleOrNull(paramString);
      }
      else
      {
        bool = KotlinBuiltIns.isString(paramKotlinType);
        if (!bool) {}
      }
    }
    catch (IllegalArgumentException paramKotlinType)
    {
      label306:
      break label306;
    }
    paramString = null;
    paramKotlinType = localObject1;
    if (paramString != null) {
      paramKotlinType = (JavaDefaultValue)new Constant(paramString);
    }
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.UtilsKt
 * JD-Core Version:    0.7.0.1
 */