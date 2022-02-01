package kotlin.reflect.jvm.internal.impl.protobuf;

import TFieldDescriptorType;;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map.Entry<TFieldDescriptorType;Ljava.lang.Object;>;
import java.util.Set;

final class FieldSet<FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>>
{
  private static final FieldSet DEFAULT_INSTANCE = new FieldSet(true);
  private final SmallSortedMap<FieldDescriptorType, Object> fields;
  private boolean hasLazyField = false;
  private boolean isImmutable;
  
  private FieldSet()
  {
    this.fields = SmallSortedMap.newFieldMap(16);
  }
  
  private FieldSet(boolean paramBoolean)
  {
    this.fields = SmallSortedMap.newFieldMap(0);
    makeImmutable();
  }
  
  private Object cloneIfMutable(Object paramObject)
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      byte[] arrayOfByte = new byte[paramObject.length];
      System.arraycopy(paramObject, 0, arrayOfByte, 0, paramObject.length);
      return arrayOfByte;
    }
    return paramObject;
  }
  
  private static int computeElementSize(WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    int i = CodedOutputStream.computeTagSize(paramInt);
    paramInt = i;
    if (paramFieldType == WireFormat.FieldType.GROUP) {
      paramInt = i * 2;
    }
    return paramInt + computeElementSizeNoTag(paramFieldType, paramObject);
  }
  
  private static int computeElementSizeNoTag(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (FieldSet.1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      if ((paramObject instanceof Internal.EnumLite)) {
        return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite)paramObject).getNumber());
      }
      return CodedOutputStream.computeEnumSizeNoTag(((Integer)paramObject).intValue());
    case 17: 
      if ((paramObject instanceof LazyField)) {
        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField)paramObject);
      }
      return CodedOutputStream.computeMessageSizeNoTag((MessageLite)paramObject);
    case 16: 
      return CodedOutputStream.computeGroupSizeNoTag((MessageLite)paramObject);
    case 15: 
      return CodedOutputStream.computeSInt64SizeNoTag(((Long)paramObject).longValue());
    case 14: 
      return CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramObject).intValue());
    case 13: 
      return CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramObject).longValue());
    case 12: 
      return CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramObject).intValue());
    case 11: 
      return CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramObject).intValue());
    case 10: 
      if ((paramObject instanceof ByteString)) {
        return CodedOutputStream.computeBytesSizeNoTag((ByteString)paramObject);
      }
      return CodedOutputStream.computeByteArraySizeNoTag((byte[])paramObject);
    case 9: 
      return CodedOutputStream.computeStringSizeNoTag((String)paramObject);
    case 8: 
      return CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramObject).booleanValue());
    case 7: 
      return CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramObject).intValue());
    case 6: 
      return CodedOutputStream.computeFixed64SizeNoTag(((Long)paramObject).longValue());
    case 5: 
      return CodedOutputStream.computeInt32SizeNoTag(((Integer)paramObject).intValue());
    case 4: 
      return CodedOutputStream.computeUInt64SizeNoTag(((Long)paramObject).longValue());
    case 3: 
      return CodedOutputStream.computeInt64SizeNoTag(((Long)paramObject).longValue());
    case 2: 
      return CodedOutputStream.computeFloatSizeNoTag(((Float)paramObject).floatValue());
    }
    return CodedOutputStream.computeDoubleSizeNoTag(((Double)paramObject).doubleValue());
  }
  
  public static int computeFieldSize(FieldSet.FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int k = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      boolean bool = paramFieldDescriptorLite.isPacked();
      int j = 0;
      int i = 0;
      if (bool)
      {
        paramFieldDescriptorLite = ((List)paramObject).iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        return CodedOutputStream.computeTagSize(k) + i + CodedOutputStream.computeRawVarint32Size(i);
      }
      paramFieldDescriptorLite = ((List)paramObject).iterator();
      i = j;
      while (paramFieldDescriptorLite.hasNext()) {
        i += computeElementSize(localFieldType, k, paramFieldDescriptorLite.next());
      }
      return i;
    }
    return computeElementSize(localFieldType, k, paramObject);
  }
  
  public static <T extends FieldSet.FieldDescriptorLite<T>> FieldSet<T> emptySet()
  {
    return DEFAULT_INSTANCE;
  }
  
  static int getWireFormatForFieldType(WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 2;
    }
    return paramFieldType.getWireType();
  }
  
  private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      if (localFieldDescriptorLite.isRepeated())
      {
        paramEntry = ((List)paramEntry.getValue()).iterator();
        do
        {
          if (!paramEntry.hasNext()) {
            break;
          }
        } while (((MessageLite)paramEntry.next()).isInitialized());
        return false;
      }
      paramEntry = paramEntry.getValue();
      if ((paramEntry instanceof MessageLite))
      {
        if (!((MessageLite)paramEntry).isInitialized()) {
          return false;
        }
      }
      else
      {
        if ((paramEntry instanceof LazyField)) {
          return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }
  
  private void mergeFromField(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    FieldSet.FieldDescriptorLite localFieldDescriptorLite = (FieldSet.FieldDescriptorLite)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    paramEntry = (Map.Entry<FieldDescriptorType, Object>)localObject1;
    if ((localObject1 instanceof LazyField)) {
      paramEntry = ((LazyField)localObject1).getValue();
    }
    if (localFieldDescriptorLite.isRepeated())
    {
      Object localObject2 = getField(localFieldDescriptorLite);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      paramEntry = ((List)paramEntry).iterator();
      while (paramEntry.hasNext())
      {
        localObject2 = paramEntry.next();
        ((List)localObject1).add(cloneIfMutable(localObject2));
      }
      this.fields.put(localFieldDescriptorLite, localObject1);
      return;
    }
    if (localFieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE)
    {
      localObject1 = getField(localFieldDescriptorLite);
      if (localObject1 == null)
      {
        this.fields.put(localFieldDescriptorLite, cloneIfMutable(paramEntry));
        return;
      }
      paramEntry = localFieldDescriptorLite.internalMergeFrom(((MessageLite)localObject1).toBuilder(), (MessageLite)paramEntry).build();
      this.fields.put(localFieldDescriptorLite, paramEntry);
      return;
    }
    this.fields.put(localFieldDescriptorLite, cloneIfMutable(paramEntry));
  }
  
  public static <T extends FieldSet.FieldDescriptorLite<T>> FieldSet<T> newFieldSet()
  {
    return new FieldSet();
  }
  
  public static Object readPrimitiveField(CodedInputStream paramCodedInputStream, WireFormat.FieldType paramFieldType, boolean paramBoolean)
  {
    switch (FieldSet.1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 18: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 15: 
      return Long.valueOf(paramCodedInputStream.readSInt64());
    case 14: 
      return Integer.valueOf(paramCodedInputStream.readSInt32());
    case 13: 
      return Long.valueOf(paramCodedInputStream.readSFixed64());
    case 12: 
      return Integer.valueOf(paramCodedInputStream.readSFixed32());
    case 11: 
      return Integer.valueOf(paramCodedInputStream.readUInt32());
    case 10: 
      return paramCodedInputStream.readBytes();
    case 9: 
      if (paramBoolean) {
        return paramCodedInputStream.readStringRequireUtf8();
      }
      return paramCodedInputStream.readString();
    case 8: 
      return Boolean.valueOf(paramCodedInputStream.readBool());
    case 7: 
      return Integer.valueOf(paramCodedInputStream.readFixed32());
    case 6: 
      return Long.valueOf(paramCodedInputStream.readFixed64());
    case 5: 
      return Integer.valueOf(paramCodedInputStream.readInt32());
    case 4: 
      return Long.valueOf(paramCodedInputStream.readUInt64());
    case 3: 
      return Long.valueOf(paramCodedInputStream.readInt64());
    case 2: 
      return Float.valueOf(paramCodedInputStream.readFloat());
    }
    return Double.valueOf(paramCodedInputStream.readDouble());
  }
  
  private static void verifyType(WireFormat.FieldType paramFieldType, Object paramObject)
  {
    if (paramObject != null)
    {
      int i = FieldSet.1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[paramFieldType.getJavaType().ordinal()];
      boolean bool = false;
      switch (i)
      {
      default: 
        break;
      case 9: 
        if ((!(paramObject instanceof MessageLite)) && (!(paramObject instanceof LazyField))) {
          break;
        }
      case 8: 
      case 7: 
        for (;;)
        {
          bool = true;
          break;
          if (!(paramObject instanceof Integer))
          {
            if (!(paramObject instanceof Internal.EnumLite)) {
              break;
            }
            if ((goto 85) && (!(paramObject instanceof ByteString))) {
              if (!(paramObject instanceof byte[])) {
                break;
              }
            }
          }
        }
      case 6: 
        bool = paramObject instanceof String;
        break;
      case 5: 
        bool = paramObject instanceof Boolean;
        break;
      case 4: 
        bool = paramObject instanceof Double;
        break;
      case 3: 
        bool = paramObject instanceof Float;
        break;
      case 2: 
        bool = paramObject instanceof Long;
        break;
      case 1: 
        bool = paramObject instanceof Integer;
      }
      if (bool) {
        return;
      }
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
    paramFieldType = new NullPointerException();
    for (;;)
    {
      throw paramFieldType;
    }
  }
  
  private static void writeElement(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, int paramInt, Object paramObject)
  {
    if (paramFieldType == WireFormat.FieldType.GROUP)
    {
      paramCodedOutputStream.writeGroup(paramInt, (MessageLite)paramObject);
      return;
    }
    paramCodedOutputStream.writeTag(paramInt, getWireFormatForFieldType(paramFieldType, false));
    writeElementNoTag(paramCodedOutputStream, paramFieldType, paramObject);
  }
  
  private static void writeElementNoTag(CodedOutputStream paramCodedOutputStream, WireFormat.FieldType paramFieldType, Object paramObject)
  {
    switch (FieldSet.1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[paramFieldType.ordinal()])
    {
    default: 
      return;
    case 18: 
      if ((paramObject instanceof Internal.EnumLite))
      {
        paramCodedOutputStream.writeEnumNoTag(((Internal.EnumLite)paramObject).getNumber());
        return;
      }
      paramCodedOutputStream.writeEnumNoTag(((Integer)paramObject).intValue());
      return;
    case 17: 
      paramCodedOutputStream.writeMessageNoTag((MessageLite)paramObject);
      return;
    case 16: 
      paramCodedOutputStream.writeGroupNoTag((MessageLite)paramObject);
      return;
    case 15: 
      paramCodedOutputStream.writeSInt64NoTag(((Long)paramObject).longValue());
      return;
    case 14: 
      paramCodedOutputStream.writeSInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 13: 
      paramCodedOutputStream.writeSFixed64NoTag(((Long)paramObject).longValue());
      return;
    case 12: 
      paramCodedOutputStream.writeSFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case 11: 
      paramCodedOutputStream.writeUInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 10: 
      if ((paramObject instanceof ByteString))
      {
        paramCodedOutputStream.writeBytesNoTag((ByteString)paramObject);
        return;
      }
      paramCodedOutputStream.writeByteArrayNoTag((byte[])paramObject);
      return;
    case 9: 
      paramCodedOutputStream.writeStringNoTag((String)paramObject);
      return;
    case 8: 
      paramCodedOutputStream.writeBoolNoTag(((Boolean)paramObject).booleanValue());
      return;
    case 7: 
      paramCodedOutputStream.writeFixed32NoTag(((Integer)paramObject).intValue());
      return;
    case 6: 
      paramCodedOutputStream.writeFixed64NoTag(((Long)paramObject).longValue());
      return;
    case 5: 
      paramCodedOutputStream.writeInt32NoTag(((Integer)paramObject).intValue());
      return;
    case 4: 
      paramCodedOutputStream.writeUInt64NoTag(((Long)paramObject).longValue());
      return;
    case 3: 
      paramCodedOutputStream.writeInt64NoTag(((Long)paramObject).longValue());
      return;
    case 2: 
      paramCodedOutputStream.writeFloatNoTag(((Float)paramObject).floatValue());
      return;
    }
    paramCodedOutputStream.writeDoubleNoTag(((Double)paramObject).doubleValue());
  }
  
  public static void writeField(FieldSet.FieldDescriptorLite<?> paramFieldDescriptorLite, Object paramObject, CodedOutputStream paramCodedOutputStream)
  {
    WireFormat.FieldType localFieldType = paramFieldDescriptorLite.getLiteType();
    int i = paramFieldDescriptorLite.getNumber();
    if (paramFieldDescriptorLite.isRepeated())
    {
      paramObject = (List)paramObject;
      if (paramFieldDescriptorLite.isPacked())
      {
        paramCodedOutputStream.writeTag(i, 2);
        i = 0;
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          i += computeElementSizeNoTag(localFieldType, paramFieldDescriptorLite.next());
        }
        paramCodedOutputStream.writeRawVarint32(i);
        paramFieldDescriptorLite = paramObject.iterator();
        while (paramFieldDescriptorLite.hasNext()) {
          writeElementNoTag(paramCodedOutputStream, localFieldType, paramFieldDescriptorLite.next());
        }
      }
      paramFieldDescriptorLite = paramObject.iterator();
      while (paramFieldDescriptorLite.hasNext()) {
        writeElement(paramCodedOutputStream, localFieldType, i, paramFieldDescriptorLite.next());
      }
    }
    if ((paramObject instanceof LazyField))
    {
      writeElement(paramCodedOutputStream, localFieldType, i, ((LazyField)paramObject).getValue());
      return;
    }
    writeElement(paramCodedOutputStream, localFieldType, i, paramObject);
  }
  
  public void addRepeatedField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
      Object localObject = getField(paramFieldDescriptorType);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.fields.put(paramFieldDescriptorType, localObject);
        paramFieldDescriptorType = (TFieldDescriptorType)localObject;
      }
      else
      {
        paramFieldDescriptorType = (List)localObject;
      }
      paramFieldDescriptorType.add(paramObject);
      return;
    }
    throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
  }
  
  public FieldSet<FieldDescriptorType> clone()
  {
    FieldSet localFieldSet = newFieldSet();
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(i);
      localFieldSet.setField((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      i += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localFieldSet.setField((FieldSet.FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    localFieldSet.hasLazyField = this.hasLazyField;
    return localFieldSet;
  }
  
  public Object getField(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.fields.get(paramFieldDescriptorType);
    paramFieldDescriptorType = localObject;
    if ((localObject instanceof LazyField)) {
      paramFieldDescriptorType = ((LazyField)localObject).getValue();
    }
    return paramFieldDescriptorType;
  }
  
  public Object getRepeatedField(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      paramFieldDescriptorType = getField(paramFieldDescriptorType);
      if (paramFieldDescriptorType != null) {
        return ((List)paramFieldDescriptorType).get(paramInt);
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getRepeatedFieldCount(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      paramFieldDescriptorType = getField(paramFieldDescriptorType);
      if (paramFieldDescriptorType == null) {
        return 0;
      }
      return ((List)paramFieldDescriptorType).size();
    }
    throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
  }
  
  public int getSerializedSize()
  {
    int j = 0;
    int i = 0;
    while (j < this.fields.getNumArrayEntries())
    {
      localObject = this.fields.getArrayEntryAt(j);
      i += computeFieldSize((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
      j += 1;
    }
    Object localObject = this.fields.getOverflowEntries().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      i += computeFieldSize((FieldSet.FieldDescriptorLite)localEntry.getKey(), localEntry.getValue());
    }
    return i;
  }
  
  public boolean hasField(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.isRepeated()) {
      return this.fields.get(paramFieldDescriptorType) != null;
    }
    throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
  }
  
  public boolean isInitialized()
  {
    int i = 0;
    while (i < this.fields.getNumArrayEntries())
    {
      if (!isInitialized(this.fields.getArrayEntryAt(i))) {
        return false;
      }
      i += 1;
    }
    Iterator localIterator = this.fields.getOverflowEntries().iterator();
    while (localIterator.hasNext()) {
      if (!isInitialized((Map.Entry)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator()
  {
    if (this.hasLazyField) {
      return new LazyField.LazyIterator(this.fields.entrySet().iterator());
    }
    return this.fields.entrySet().iterator();
  }
  
  public void makeImmutable()
  {
    if (this.isImmutable) {
      return;
    }
    this.fields.makeImmutable();
    this.isImmutable = true;
  }
  
  public void mergeFrom(FieldSet<FieldDescriptorType> paramFieldSet)
  {
    int i = 0;
    while (i < paramFieldSet.fields.getNumArrayEntries())
    {
      mergeFromField(paramFieldSet.fields.getArrayEntryAt(i));
      i += 1;
    }
    paramFieldSet = paramFieldSet.fields.getOverflowEntries().iterator();
    while (paramFieldSet.hasNext()) {
      mergeFromField((Map.Entry)paramFieldSet.next());
    }
  }
  
  public void setField(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.isRepeated())
    {
      if ((paramObject instanceof List))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((List)paramObject);
        paramObject = localArrayList.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          verifyType(paramFieldDescriptorType.getLiteType(), localObject);
        }
        paramObject = localArrayList;
      }
      else
      {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    else {
      verifyType(paramFieldDescriptorType.getLiteType(), paramObject);
    }
    if ((paramObject instanceof LazyField)) {
      this.hasLazyField = true;
    }
    this.fields.put(paramFieldDescriptorType, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.FieldSet
 * JD-Core Version:    0.7.0.1
 */