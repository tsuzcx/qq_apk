package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirement$Companion
{
  @NotNull
  public final List<VersionRequirement> create(@NotNull MessageLite paramMessageLite, @NotNull NameResolver paramNameResolver, @NotNull VersionRequirementTable paramVersionRequirementTable)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageLite, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramVersionRequirementTable, "table");
    if ((paramMessageLite instanceof ProtoBuf.Class))
    {
      paramMessageLite = ((ProtoBuf.Class)paramMessageLite).getVersionRequirementList();
    }
    else if ((paramMessageLite instanceof ProtoBuf.Constructor))
    {
      paramMessageLite = ((ProtoBuf.Constructor)paramMessageLite).getVersionRequirementList();
    }
    else if ((paramMessageLite instanceof ProtoBuf.Function))
    {
      paramMessageLite = ((ProtoBuf.Function)paramMessageLite).getVersionRequirementList();
    }
    else if ((paramMessageLite instanceof ProtoBuf.Property))
    {
      paramMessageLite = ((ProtoBuf.Property)paramMessageLite).getVersionRequirementList();
    }
    else
    {
      if (!(paramMessageLite instanceof ProtoBuf.TypeAlias)) {
        break label207;
      }
      paramMessageLite = ((ProtoBuf.TypeAlias)paramMessageLite).getVersionRequirementList();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramMessageLite, "ids");
    Object localObject1 = (Iterable)paramMessageLite;
    paramMessageLite = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Integer)((Iterator)localObject1).next();
      Companion localCompanion = VersionRequirement.Companion;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "id");
      localObject2 = localCompanion.create(((Integer)localObject2).intValue(), paramNameResolver, paramVersionRequirementTable);
      if (localObject2 != null) {
        paramMessageLite.add(localObject2);
      }
    }
    return (List)paramMessageLite;
    label207:
    paramNameResolver = new StringBuilder();
    paramNameResolver.append("Unexpected declaration: ");
    paramNameResolver.append(paramMessageLite.getClass());
    paramMessageLite = (Throwable)new IllegalStateException(paramNameResolver.toString());
    for (;;)
    {
      throw paramMessageLite;
    }
  }
  
  @Nullable
  public final VersionRequirement create(int paramInt, @NotNull NameResolver paramNameResolver, @NotNull VersionRequirementTable paramVersionRequirementTable)
  {
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramVersionRequirementTable, "table");
    ProtoBuf.VersionRequirement localVersionRequirement = paramVersionRequirementTable.get(paramInt);
    String str = null;
    if (localVersionRequirement != null)
    {
      Object localObject = VersionRequirement.Version.Companion;
      if (localVersionRequirement.hasVersion()) {
        paramVersionRequirementTable = Integer.valueOf(localVersionRequirement.getVersion());
      } else {
        paramVersionRequirementTable = null;
      }
      Integer localInteger;
      if (localVersionRequirement.hasVersionFull()) {
        localInteger = Integer.valueOf(localVersionRequirement.getVersionFull());
      } else {
        localInteger = null;
      }
      localObject = ((VersionRequirement.Version.Companion)localObject).decode(paramVersionRequirementTable, localInteger);
      paramVersionRequirementTable = localVersionRequirement.getLevel();
      if (paramVersionRequirementTable == null) {
        Intrinsics.throwNpe();
      }
      paramInt = VersionRequirement.Companion.WhenMappings.$EnumSwitchMapping$0[paramVersionRequirementTable.ordinal()];
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            paramVersionRequirementTable = DeprecationLevel.HIDDEN;
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          paramVersionRequirementTable = DeprecationLevel.ERROR;
        }
      }
      else {
        paramVersionRequirementTable = DeprecationLevel.WARNING;
      }
      if (localVersionRequirement.hasErrorCode()) {
        localInteger = Integer.valueOf(localVersionRequirement.getErrorCode());
      } else {
        localInteger = null;
      }
      if (localVersionRequirement.hasMessage()) {
        str = paramNameResolver.getString(localVersionRequirement.getMessage());
      }
      paramNameResolver = localVersionRequirement.getVersionKind();
      Intrinsics.checkExpressionValueIsNotNull(paramNameResolver, "info.versionKind");
      return new VersionRequirement((VersionRequirement.Version)localObject, paramNameResolver, paramVersionRequirementTable, localInteger, str);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion
 * JD-Core Version:    0.7.0.1
 */