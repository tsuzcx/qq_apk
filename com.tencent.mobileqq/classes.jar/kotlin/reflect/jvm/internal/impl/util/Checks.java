package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Checks
{
  @NotNull
  private final Function1<FunctionDescriptor, String> additionalCheck;
  @NotNull
  private final Check[] checks;
  @Nullable
  private final Name name;
  @Nullable
  private final Collection<Name> nameList;
  @Nullable
  private final Regex regex;
  
  public Checks(@NotNull Collection<Name> paramCollection, @NotNull Check[] paramArrayOfCheck, @NotNull Function1<? super FunctionDescriptor, String> paramFunction1)
  {
    this(null, null, paramCollection, paramFunction1, (Check[])Arrays.copyOf(paramArrayOfCheck, paramArrayOfCheck.length));
  }
  
  private Checks(Name paramName, Regex paramRegex, Collection<Name> paramCollection, Function1<? super FunctionDescriptor, String> paramFunction1, Check... paramVarArgs)
  {
    this.name = paramName;
    this.regex = paramRegex;
    this.nameList = paramCollection;
    this.additionalCheck = paramFunction1;
    this.checks = paramVarArgs;
  }
  
  public Checks(@NotNull Name paramName, @NotNull Check[] paramArrayOfCheck, @NotNull Function1<? super FunctionDescriptor, String> paramFunction1)
  {
    this(paramName, null, null, paramFunction1, (Check[])Arrays.copyOf(paramArrayOfCheck, paramArrayOfCheck.length));
  }
  
  public Checks(@NotNull Regex paramRegex, @NotNull Check[] paramArrayOfCheck, @NotNull Function1<? super FunctionDescriptor, String> paramFunction1)
  {
    this(null, paramRegex, null, paramFunction1, (Check[])Arrays.copyOf(paramArrayOfCheck, paramArrayOfCheck.length));
  }
  
  @NotNull
  public final CheckResult checkAll(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    Check[] arrayOfCheck = this.checks;
    int j = arrayOfCheck.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfCheck[i].invoke(paramFunctionDescriptor);
      if (str != null) {
        return (CheckResult)new CheckResult.IllegalSignature(str);
      }
      i += 1;
    }
    paramFunctionDescriptor = (String)this.additionalCheck.invoke(paramFunctionDescriptor);
    if (paramFunctionDescriptor != null) {
      return (CheckResult)new CheckResult.IllegalSignature(paramFunctionDescriptor);
    }
    return (CheckResult)CheckResult.SuccessCheck.INSTANCE;
  }
  
  public final boolean isApplicable(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    if ((this.name != null) && ((Intrinsics.areEqual(paramFunctionDescriptor.getName(), this.name) ^ true))) {
      return false;
    }
    if (this.regex != null)
    {
      localObject = paramFunctionDescriptor.getName().asString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "functionDescriptor.name.asString()");
      localObject = (CharSequence)localObject;
      if (!this.regex.matches((CharSequence)localObject)) {
        return false;
      }
    }
    Object localObject = this.nameList;
    return (localObject == null) || (((Collection)localObject).contains(paramFunctionDescriptor.getName()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.Checks
 * JD-Core Version:    0.7.0.1
 */