package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirementTable
{
  public static final VersionRequirementTable.Companion Companion = new VersionRequirementTable.Companion(null);
  @NotNull
  private static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt.emptyList());
  private final List<ProtoBuf.VersionRequirement> infos;
  
  private VersionRequirementTable(List<ProtoBuf.VersionRequirement> paramList)
  {
    this.infos = paramList;
  }
  
  @Nullable
  public final ProtoBuf.VersionRequirement get(int paramInt)
  {
    return (ProtoBuf.VersionRequirement)CollectionsKt.getOrNull(this.infos, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable
 * JD-Core Version:    0.7.0.1
 */