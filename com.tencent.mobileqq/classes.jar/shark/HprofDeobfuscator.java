package shark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofDeobfuscator;", "", "()V", "createDeobfuscatedClassDumpRecord", "Lkotlin/Pair;", "", "Lshark/HprofRecord;", "", "record", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "proguardMapping", "Lshark/ProguardMapping;", "hprofStringCache", "", "", "classNames", "maxId", "createDeobfuscatedStringRecord", "Lshark/HprofRecord$StringRecord;", "deobfuscate", "Ljava/io/File;", "inputHprofFile", "outputHprofFile", "readHprofRecords", "Lkotlin/Triple;", "writeHprofRecords", "firstId", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofDeobfuscator
{
  private final Pair<List<HprofRecord>, Long> a(HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord paramClassDumpRecord, ProguardMapping paramProguardMapping, Map<Long, String> paramMap, Map<Long, Long> paramMap1, long paramLong)
  {
    List localList = (List)new ArrayList();
    Object localObject2 = (Iterable)paramClassDumpRecord.i();
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)((Iterator)localObject2).next();
      localObject4 = paramMap.get(paramMap1.get(Long.valueOf(paramClassDumpRecord.a())));
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      localObject4 = (String)localObject4;
      localObject5 = paramMap.get(Long.valueOf(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localObject3).a()));
      if (localObject5 == null) {
        Intrinsics.throwNpe();
      }
      localObject4 = new HprofRecord.StringRecord(paramLong, paramProguardMapping.a((String)localObject4, (String)localObject5));
      localList.add(localObject4);
      ((Collection)localObject1).add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord(((HprofRecord.StringRecord)localObject4).a(), ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localObject3).b()));
      paramLong = 1L + paramLong;
    }
    localObject1 = (List)localObject1;
    Object localObject3 = (Iterable)paramClassDumpRecord.h();
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)((Iterator)localObject3).next();
      localObject5 = paramMap.get(paramMap1.get(Long.valueOf(paramClassDumpRecord.a())));
      if (localObject5 == null) {
        Intrinsics.throwNpe();
      }
      localObject5 = (String)localObject5;
      Object localObject6 = paramMap.get(Long.valueOf(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)localObject4).a()));
      if (localObject6 == null) {
        Intrinsics.throwNpe();
      }
      localObject5 = new HprofRecord.StringRecord(paramLong, paramProguardMapping.a((String)localObject5, (String)localObject6));
      localList.add(localObject5);
      ((Collection)localObject2).add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(((HprofRecord.StringRecord)localObject5).a(), ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)localObject4).b(), ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)localObject4).c()));
      paramLong += 1L;
    }
    paramProguardMapping = (List)localObject2;
    localList.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord(paramClassDumpRecord.a(), paramClassDumpRecord.b(), paramClassDumpRecord.c(), paramClassDumpRecord.d(), paramClassDumpRecord.e(), paramClassDumpRecord.f(), paramClassDumpRecord.g(), paramProguardMapping, (List)localObject1));
    return new Pair(localList, Long.valueOf(paramLong));
  }
  
  private final HprofRecord.StringRecord a(HprofRecord.StringRecord paramStringRecord, ProguardMapping paramProguardMapping, Map<Long, String> paramMap)
  {
    paramMap = paramMap.get(Long.valueOf(paramStringRecord.a()));
    if (paramMap == null) {
      Intrinsics.throwNpe();
    }
    paramMap = (String)paramMap;
    return new HprofRecord.StringRecord(paramStringRecord.a(), paramProguardMapping.a(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofDeobfuscator
 * JD-Core Version:    0.7.0.1
 */