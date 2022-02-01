package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import org.jetbrains.annotations.NotNull;

public final class TypeTable
{
  @NotNull
  private final List<ProtoBuf.Type> types;
  
  public TypeTable(@NotNull ProtoBuf.TypeTable paramTypeTable)
  {
    Object localObject = (TypeTable)this;
    localObject = paramTypeTable.getTypeList();
    if (paramTypeTable.hasFirstNullable())
    {
      int j = paramTypeTable.getFirstNullable();
      paramTypeTable = paramTypeTable.getTypeList();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeTable, "typeTable.typeList");
      paramTypeTable = (Iterable)paramTypeTable;
      Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramTypeTable, 10));
      int i = 0;
      Iterator localIterator = paramTypeTable.iterator();
      while (localIterator.hasNext())
      {
        paramTypeTable = localIterator.next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject = (ProtoBuf.Type)paramTypeTable;
        paramTypeTable = (ProtoBuf.TypeTable)localObject;
        if (i >= j) {
          paramTypeTable = ((ProtoBuf.Type)localObject).toBuilder().setNullable(true).build();
        }
        localCollection.add(paramTypeTable);
        i += 1;
      }
      paramTypeTable = (List)localCollection;
    }
    else
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "originalTypes");
      paramTypeTable = (ProtoBuf.TypeTable)localObject;
    }
    this.types = paramTypeTable;
  }
  
  @NotNull
  public final ProtoBuf.Type get(int paramInt)
  {
    return (ProtoBuf.Type)this.types.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable
 * JD-Core Version:    0.7.0.1
 */