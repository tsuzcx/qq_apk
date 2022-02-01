package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable;
import org.jetbrains.annotations.NotNull;

public final class NameResolverImpl
  implements NameResolver
{
  private final ProtoBuf.QualifiedNameTable qualifiedNames;
  private final ProtoBuf.StringTable strings;
  
  public NameResolverImpl(@NotNull ProtoBuf.StringTable paramStringTable, @NotNull ProtoBuf.QualifiedNameTable paramQualifiedNameTable)
  {
    this.strings = paramStringTable;
    this.qualifiedNames = paramQualifiedNameTable;
  }
  
  private final Triple<List<String>, List<String>, Boolean> traverseIds(int paramInt)
  {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    boolean bool = false;
    while (paramInt != -1)
    {
      ProtoBuf.QualifiedNameTable.QualifiedName localQualifiedName = this.qualifiedNames.getQualifiedName(paramInt);
      Object localObject = this.strings;
      Intrinsics.checkExpressionValueIsNotNull(localQualifiedName, "proto");
      localObject = ((ProtoBuf.StringTable)localObject).getString(localQualifiedName.getShortName());
      ProtoBuf.QualifiedNameTable.QualifiedName.Kind localKind = localQualifiedName.getKind();
      if (localKind == null) {
        Intrinsics.throwNpe();
      }
      paramInt = NameResolverImpl.WhenMappings.$EnumSwitchMapping$0[localKind.ordinal()];
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            localLinkedList2.addFirst(localObject);
            bool = true;
          }
        }
        else {
          localLinkedList1.addFirst(localObject);
        }
      }
      else {
        localLinkedList2.addFirst(localObject);
      }
      paramInt = localQualifiedName.getParentQualifiedName();
    }
    return new Triple(localLinkedList1, localLinkedList2, Boolean.valueOf(bool));
  }
  
  @NotNull
  public String getQualifiedClassName(int paramInt)
  {
    Object localObject = traverseIds(paramInt);
    List localList = (List)((Triple)localObject).component1();
    localObject = CollectionsKt.joinToString$default((Iterable)((Triple)localObject).component2(), (CharSequence)".", null, null, 0, null, null, 62, null);
    if (localList.isEmpty()) {
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)localList, (CharSequence)"/", null, null, 0, null, null, 62, null));
    localStringBuilder.append('/');
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String getString(int paramInt)
  {
    String str = this.strings.getString(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(str, "strings.getString(index)");
    return str;
  }
  
  public boolean isLocalClassName(int paramInt)
  {
    return ((Boolean)traverseIds(paramInt).getThird()).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl
 * JD-Core Version:    0.7.0.1
 */