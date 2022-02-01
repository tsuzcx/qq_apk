package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class SignatureBuildingComponents
{
  public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();
  
  private final String escapeClassName(String paramString)
  {
    Object localObject = paramString;
    if (paramString.length() > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append('L');
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(';');
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  @NotNull
  public final String[] constructors(@NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<init>(");
      localStringBuilder.append(str);
      localStringBuilder.append(")V");
      localCollection.add(localStringBuilder.toString());
      i += 1;
    }
    paramVarArgs = ((Collection)localCollection).toArray(new String[0]);
    if (paramVarArgs != null) {
      return (String[])paramVarArgs;
    }
    paramVarArgs = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  @NotNull
  public final LinkedHashSet<String> inClass(@NotNull String paramString, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "internalName");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "signatures");
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('.');
      localStringBuilder.append(str);
      localCollection.add(localStringBuilder.toString());
      i += 1;
    }
    return (LinkedHashSet)localCollection;
  }
  
  @NotNull
  public final LinkedHashSet<String> inJavaLang(@NotNull String paramString, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "signatures");
    return inClass(javaLang(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  @NotNull
  public final LinkedHashSet<String> inJavaUtil(@NotNull String paramString, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "signatures");
    return inClass(javaUtil(paramString), (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  @NotNull
  public final String javaFunction(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("java/util/function/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String javaLang(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("java/lang/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String javaUtil(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("java/util/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String jvmDescriptor(@NotNull String paramString1, @NotNull List<String> paramList, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramList, "parameters");
    Intrinsics.checkParameterIsNotNull(paramString2, "ret");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('(');
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"", null, null, 0, null, (Function1)SignatureBuildingComponents.jvmDescriptor.1.INSTANCE, 30, null));
    localStringBuilder.append(')');
    localStringBuilder.append(escapeClassName(paramString2));
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String signature(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "internalName");
    Intrinsics.checkParameterIsNotNull(paramString2, "jvmDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('.');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final String signature(@NotNull ClassDescriptor paramClassDescriptor, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    Intrinsics.checkParameterIsNotNull(paramString, "jvmDescriptor");
    return signature(MethodSignatureMappingKt.getInternalName(paramClassDescriptor), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents
 * JD-Core Version:    0.7.0.1
 */