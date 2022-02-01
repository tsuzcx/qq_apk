package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class SmallSortedMap$1
  extends SmallSortedMap<FieldDescriptorType, Object>
{
  SmallSortedMap$1(int paramInt)
  {
    super(paramInt, null);
  }
  
  public void makeImmutable()
  {
    if (!isImmutable())
    {
      int i = 0;
      while (i < getNumArrayEntries())
      {
        localObject = getArrayEntryAt(i);
        if (((FieldSet.FieldDescriptorLite)((Map.Entry)localObject).getKey()).isRepeated()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
        i += 1;
      }
      Object localObject = getOverflowEntries().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((FieldSet.FieldDescriptorLite)localEntry.getKey()).isRepeated()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.makeImmutable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.SmallSortedMap.1
 * JD-Core Version:    0.7.0.1
 */