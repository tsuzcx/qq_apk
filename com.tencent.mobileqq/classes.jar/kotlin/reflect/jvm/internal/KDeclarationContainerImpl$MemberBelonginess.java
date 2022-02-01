package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public enum KDeclarationContainerImpl$MemberBelonginess
{
  static
  {
    MemberBelonginess localMemberBelonginess1 = new MemberBelonginess("DECLARED", 0);
    DECLARED = localMemberBelonginess1;
    MemberBelonginess localMemberBelonginess2 = new MemberBelonginess("INHERITED", 1);
    INHERITED = localMemberBelonginess2;
    $VALUES = new MemberBelonginess[] { localMemberBelonginess1, localMemberBelonginess2 };
  }
  
  private KDeclarationContainerImpl$MemberBelonginess() {}
  
  public final boolean accept(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "member");
    paramCallableMemberDescriptor = paramCallableMemberDescriptor.getKind();
    Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "member.kind");
    boolean bool2 = paramCallableMemberDescriptor.isReal();
    boolean bool1;
    if ((MemberBelonginess)this == DECLARED) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    return bool2 == bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess
 * JD-Core Version:    0.7.0.1
 */