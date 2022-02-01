package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

class KotlinBuiltIns$3
  implements Function1<Name, ClassDescriptor>
{
  KotlinBuiltIns$3(KotlinBuiltIns paramKotlinBuiltIns) {}
  
  public ClassDescriptor invoke(Name paramName)
  {
    Object localObject = this.this$0.getBuiltInsPackageScope().getContributedClassifier(paramName, NoLookupLocation.FROM_BUILTINS);
    if (localObject != null)
    {
      if ((localObject instanceof ClassDescriptor)) {
        return (ClassDescriptor)localObject;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Must be a class descriptor ");
      localStringBuilder.append(paramName);
      localStringBuilder.append(", but was ");
      localStringBuilder.append(localObject);
      throw new AssertionError(localStringBuilder.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Built-in class ");
    ((StringBuilder)localObject).append(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(paramName));
    ((StringBuilder)localObject).append(" is not found");
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.3
 * JD-Core Version:    0.7.0.1
 */