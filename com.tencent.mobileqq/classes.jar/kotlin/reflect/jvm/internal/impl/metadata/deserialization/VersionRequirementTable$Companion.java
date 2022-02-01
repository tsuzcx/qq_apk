package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable;
import org.jetbrains.annotations.NotNull;

public final class VersionRequirementTable$Companion
{
  @NotNull
  public final VersionRequirementTable create(@NotNull ProtoBuf.VersionRequirementTable paramVersionRequirementTable)
  {
    Intrinsics.checkParameterIsNotNull(paramVersionRequirementTable, "table");
    if (paramVersionRequirementTable.getRequirementCount() == 0) {
      return ((Companion)this).getEMPTY();
    }
    paramVersionRequirementTable = paramVersionRequirementTable.getRequirementList();
    Intrinsics.checkExpressionValueIsNotNull(paramVersionRequirementTable, "table.requirementList");
    return new VersionRequirementTable(paramVersionRequirementTable, null);
  }
  
  @NotNull
  public final VersionRequirementTable getEMPTY()
  {
    return VersionRequirementTable.access$getEMPTY$cp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion
 * JD-Core Version:    0.7.0.1
 */