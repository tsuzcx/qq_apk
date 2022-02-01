package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

public final class SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder
{
  @NotNull
  private final String functionName;
  private final List<Pair<String, TypeEnhancementInfo>> parameters;
  private Pair<String, TypeEnhancementInfo> returnType;
  
  public SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder(String paramString)
  {
    this.functionName = localObject;
    this.parameters = ((List)new ArrayList());
    this.returnType = TuplesKt.to("V", null);
  }
  
  @NotNull
  public final Pair<String, PredefinedFunctionEnhancementInfo> build()
  {
    Object localObject1 = SignatureBuildingComponents.INSTANCE;
    Object localObject2 = this.this$0.getClassName();
    Object localObject3 = this.functionName;
    Object localObject5 = (Iterable)this.parameters;
    Object localObject4 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject5, 10));
    localObject5 = ((Iterable)localObject5).iterator();
    while (((Iterator)localObject5).hasNext()) {
      ((Collection)localObject4).add((String)((Pair)((Iterator)localObject5).next()).getFirst());
    }
    localObject1 = ((SignatureBuildingComponents)localObject1).signature((String)localObject2, ((SignatureBuildingComponents)localObject1).jvmDescriptor((String)localObject3, (List)localObject4, (String)this.returnType.getFirst()));
    localObject2 = (TypeEnhancementInfo)this.returnType.getSecond();
    localObject4 = (Iterable)this.parameters;
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add((TypeEnhancementInfo)((Pair)((Iterator)localObject4).next()).getSecond());
    }
    return TuplesKt.to(localObject1, new PredefinedFunctionEnhancementInfo((TypeEnhancementInfo)localObject2, (List)localObject3));
  }
  
  public final void parameter(@NotNull String paramString, @NotNull JavaTypeQualifiers... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "qualifiers");
    Collection localCollection = (Collection)this.parameters;
    int i;
    if (paramVarArgs.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramVarArgs = null;
    }
    else
    {
      Object localObject = ArraysKt.withIndex(paramVarArgs);
      paramVarArgs = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10)), 16));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IndexedValue localIndexedValue = (IndexedValue)((Iterator)localObject).next();
        paramVarArgs.put(Integer.valueOf(localIndexedValue.getIndex()), (JavaTypeQualifiers)localIndexedValue.getValue());
      }
      paramVarArgs = new TypeEnhancementInfo(paramVarArgs);
    }
    localCollection.add(TuplesKt.to(paramString, paramVarArgs));
  }
  
  public final void returns(@NotNull String paramString, @NotNull JavaTypeQualifiers... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "type");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "qualifiers");
    Object localObject = ArraysKt.withIndex(paramVarArgs);
    paramVarArgs = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10)), 16));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      IndexedValue localIndexedValue = (IndexedValue)((Iterator)localObject).next();
      paramVarArgs.put(Integer.valueOf(localIndexedValue.getIndex()), (JavaTypeQualifiers)localIndexedValue.getValue());
    }
    this.returnType = TuplesKt.to(paramString, new TypeEnhancementInfo(paramVarArgs));
  }
  
  public final void returns(@NotNull JvmPrimitiveType paramJvmPrimitiveType)
  {
    Intrinsics.checkParameterIsNotNull(paramJvmPrimitiveType, "type");
    this.returnType = TuplesKt.to(paramJvmPrimitiveType.getDesc(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder
 * JD-Core Version:    0.7.0.1
 */