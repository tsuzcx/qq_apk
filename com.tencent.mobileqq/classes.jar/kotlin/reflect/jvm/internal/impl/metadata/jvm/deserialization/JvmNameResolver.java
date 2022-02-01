package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class JvmNameResolver
  implements NameResolver
{
  public static final JvmNameResolver.Companion Companion = new JvmNameResolver.Companion(null);
  @NotNull
  private static final List<String> PREDEFINED_STRINGS = CollectionsKt.listOf(new String[] { "kotlin/Any", "kotlin/Nothing", "kotlin/Unit", "kotlin/Throwable", "kotlin/Number", "kotlin/Byte", "kotlin/Double", "kotlin/Float", "kotlin/Int", "kotlin/Long", "kotlin/Short", "kotlin/Boolean", "kotlin/Char", "kotlin/CharSequence", "kotlin/String", "kotlin/Comparable", "kotlin/Enum", "kotlin/Array", "kotlin/ByteArray", "kotlin/DoubleArray", "kotlin/FloatArray", "kotlin/IntArray", "kotlin/LongArray", "kotlin/ShortArray", "kotlin/BooleanArray", "kotlin/CharArray", "kotlin/Cloneable", "kotlin/Annotation", "kotlin/collections/Iterable", "kotlin/collections/MutableIterable", "kotlin/collections/Collection", "kotlin/collections/MutableCollection", "kotlin/collections/List", "kotlin/collections/MutableList", "kotlin/collections/Set", "kotlin/collections/MutableSet", "kotlin/collections/Map", "kotlin/collections/MutableMap", "kotlin/collections/Map.Entry", "kotlin/collections/MutableMap.MutableEntry", "kotlin/collections/Iterator", "kotlin/collections/MutableIterator", "kotlin/collections/ListIterator", "kotlin/collections/MutableListIterator" });
  private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;
  private final Set<Integer> localNameIndices;
  @NotNull
  private final List<JvmProtoBuf.StringTableTypes.Record> records;
  @NotNull
  private final String[] strings;
  @NotNull
  private final JvmProtoBuf.StringTableTypes types;
  
  static
  {
    Object localObject = CollectionsKt.withIndex((Iterable)PREDEFINED_STRINGS);
    Map localMap = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10)), 16));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IndexedValue localIndexedValue = (IndexedValue)((Iterator)localObject).next();
      localMap.put((String)localIndexedValue.getValue(), Integer.valueOf(localIndexedValue.getIndex()));
    }
    PREDEFINED_STRINGS_MAP = localMap;
  }
  
  public JvmNameResolver(@NotNull JvmProtoBuf.StringTableTypes paramStringTableTypes, @NotNull String[] paramArrayOfString)
  {
    this.types = paramStringTableTypes;
    this.strings = paramArrayOfString;
    paramStringTableTypes = this.types.getLocalNameList();
    if (paramStringTableTypes.isEmpty()) {
      paramStringTableTypes = SetsKt.emptySet();
    } else {
      paramStringTableTypes = CollectionsKt.toSet((Iterable)paramStringTableTypes);
    }
    this.localNameIndices = paramStringTableTypes;
    paramStringTableTypes = new ArrayList();
    paramArrayOfString = this.types.getRecordList();
    paramStringTableTypes.ensureCapacity(paramArrayOfString.size());
    paramArrayOfString = paramArrayOfString.iterator();
    while (paramArrayOfString.hasNext())
    {
      JvmProtoBuf.StringTableTypes.Record localRecord = (JvmProtoBuf.StringTableTypes.Record)paramArrayOfString.next();
      Intrinsics.checkExpressionValueIsNotNull(localRecord, "record");
      int j = localRecord.getRange();
      int i = 0;
      while (i < j)
      {
        paramStringTableTypes.add(localRecord);
        i += 1;
      }
    }
    paramStringTableTypes.trimToSize();
    this.records = ((List)paramStringTableTypes);
  }
  
  @NotNull
  public String getQualifiedClassName(int paramInt)
  {
    return getString(paramInt);
  }
  
  @NotNull
  public String getString(int paramInt)
  {
    JvmProtoBuf.StringTableTypes.Record localRecord = (JvmProtoBuf.StringTableTypes.Record)this.records.get(paramInt);
    int i;
    if (localRecord.hasString())
    {
      localObject1 = localRecord.getString();
    }
    else
    {
      if (localRecord.hasPredefinedIndex())
      {
        i = ((Collection)PREDEFINED_STRINGS).size();
        int j = localRecord.getPredefinedIndex();
        if ((j >= 0) && (i > j))
        {
          localObject1 = (String)PREDEFINED_STRINGS.get(localRecord.getPredefinedIndex());
          break label100;
        }
      }
      localObject1 = this.strings[paramInt];
    }
    label100:
    Object localObject2 = localObject1;
    Object localObject3;
    if (localRecord.getSubstringIndexCount() >= 2)
    {
      localObject2 = localRecord.getSubstringIndexList();
      localObject3 = (Integer)((List)localObject2).get(0);
      Integer localInteger = (Integer)((List)localObject2).get(1);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "begin");
      localObject2 = localObject1;
      if (Intrinsics.compare(0, ((Integer)localObject3).intValue()) <= 0)
      {
        paramInt = ((Integer)localObject3).intValue();
        Intrinsics.checkExpressionValueIsNotNull(localInteger, "end");
        localObject2 = localObject1;
        if (Intrinsics.compare(paramInt, localInteger.intValue()) <= 0)
        {
          localObject2 = localObject1;
          if (Intrinsics.compare(localInteger.intValue(), ((String)localObject1).length()) <= 0)
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "string");
            paramInt = ((Integer)localObject3).intValue();
            i = localInteger.intValue();
            if (localObject1 != null)
            {
              localObject2 = ((String)localObject1).substring(paramInt, i);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
        }
      }
    }
    Object localObject1 = localObject2;
    if (localRecord.getReplaceCharCount() >= 2)
    {
      localObject3 = localRecord.getReplaceCharList();
      localObject1 = (Integer)((List)localObject3).get(0);
      localObject3 = (Integer)((List)localObject3).get(1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "string");
      localObject1 = StringsKt.replace$default((String)localObject2, (char)((Integer)localObject1).intValue(), (char)((Integer)localObject3).intValue(), false, 4, null);
    }
    localObject2 = localRecord.getOperation();
    if (localObject2 == null) {
      localObject2 = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
    }
    paramInt = JvmNameResolver.WhenMappings.$EnumSwitchMapping$0[localObject2.ordinal()];
    localObject2 = localObject1;
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() >= 2)
          {
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "string");
            paramInt = ((String)localObject1).length();
            if (localObject1 != null)
            {
              localObject2 = ((String)localObject1).substring(1, paramInt - 1);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "string");
          localObject2 = StringsKt.replace$default((String)localObject2, '$', '.', false, 4, null);
        }
      }
      else
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "string");
        localObject2 = StringsKt.replace$default((String)localObject1, '$', '.', false, 4, null);
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "string");
    return localObject2;
  }
  
  public boolean isLocalClassName(int paramInt)
  {
    return this.localNameIndices.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver
 * JD-Core Version:    0.7.0.1
 */