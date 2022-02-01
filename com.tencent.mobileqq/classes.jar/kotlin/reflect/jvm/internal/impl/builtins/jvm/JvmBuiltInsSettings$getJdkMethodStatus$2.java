package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsSettings$getJdkMethodStatus$2
  extends DFS.AbstractNodeHandler<ClassDescriptor, JvmBuiltInsSettings.JDKMemberStatus>
{
  JvmBuiltInsSettings$getJdkMethodStatus$2(String paramString, Ref.ObjectRef paramObjectRef) {}
  
  public boolean beforeChildren(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "javaClassDescriptor");
    paramClassDescriptor = SignatureBuildingComponents.INSTANCE.signature(paramClassDescriptor, this.$jvmDescriptor);
    if (JvmBuiltInsSettings.Companion.getBLACK_LIST_METHOD_SIGNATURES().contains(paramClassDescriptor)) {
      this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.BLACK_LIST;
    } else if (JvmBuiltInsSettings.Companion.getWHITE_LIST_METHOD_SIGNATURES().contains(paramClassDescriptor)) {
      this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.WHITE_LIST;
    } else if (JvmBuiltInsSettings.Companion.getDROP_LIST_METHOD_SIGNATURES().contains(paramClassDescriptor)) {
      this.$result.element = JvmBuiltInsSettings.JDKMemberStatus.DROP;
    }
    return (JvmBuiltInsSettings.JDKMemberStatus)this.$result.element == null;
  }
  
  @NotNull
  public JvmBuiltInsSettings.JDKMemberStatus result()
  {
    JvmBuiltInsSettings.JDKMemberStatus localJDKMemberStatus = (JvmBuiltInsSettings.JDKMemberStatus)this.$result.element;
    if (localJDKMemberStatus != null) {
      return localJDKMemberStatus;
    }
    return JvmBuiltInsSettings.JDKMemberStatus.NOT_CONSIDERED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.getJdkMethodStatus.2
 * JD-Core Version:    0.7.0.1
 */