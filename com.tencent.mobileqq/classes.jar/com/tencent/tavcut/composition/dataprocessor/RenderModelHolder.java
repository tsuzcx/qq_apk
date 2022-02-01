package com.tencent.tavcut.composition.dataprocessor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PAGAsset.Replacement;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.creator.ComponentCreator;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.entity.EntityId;
import com.tencent.tavcut.rendermodel.entity.MutableEntity;
import com.tencent.tavcut.rendermodel.properties.Layout;
import com.tencent.tavcut.rendermodel.properties.Properties;
import com.tencent.tavcut.utils.CollectionExtKt;
import com.tencent.tavcut.utils.ReflectUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/dataprocessor/RenderModelHolder;", "", "renderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "(Lcom/tencent/tavcut/rendermodel/RenderModel;)V", "lastEntitySize", "", "lastInputSourceSize", "mutableEntity", "Lcom/tencent/tavcut/rendermodel/entity/MutableEntity;", "renderRootId", "getRenderRootId", "()I", "accessInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "sourceKey", "", "addComponent", "", "entityId", "component", "cid", "rawData", "Lcom/google/gson/JsonObject;", "(ILjava/lang/Object;Ljava/lang/Integer;Lcom/google/gson/JsonObject;)V", "addEntity", "parentId", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "index", "addInputKeySource", "inputSource", "usedInputSource", "", "addInputSource", "addUsedInputSource", "value", "findUsedInputSource", "getClipAssets", "", "Lcom/tencent/tavcut/model/ClipSource;", "getMaxComponentId", "getMaxEntityId", "getRenderModel", "queryByComponent", "type", "queryByEntityId", "renderTreeEnable", "", "businessTreeEnable", "queryEntityIndex", "", "entityIds", "removeComponent", "componentId", "removeEntity", "removeInputSource", "removeRenderComponent", "setClipAssets", "clips", "modifyClipsDuration", "setPainting", "backGround", "Lcom/tencent/tavcut/model/Painting;", "setVoiceChangerConfig", "config", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "updateComponent", "(Ljava/lang/Integer;Ljava/lang/Object;)V", "updateEntityIndex", "updatePropertiesSize", "size", "Lcom/tencent/tavcut/composition/model/component/Size;", "updateTimeLine", "timeLines", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class RenderModelHolder
{
  public static final RenderModelHolder.Companion a = new RenderModelHolder.Companion(null);
  private static final String[] g = { "src", "renderTargetKey", "resourcePath", "scriptPath" };
  private final int b;
  private volatile MutableEntity c;
  private int d;
  private int e;
  private volatile RenderModel f;
  
  public RenderModelHolder(@NotNull RenderModel paramRenderModel)
  {
    this.f = paramRenderModel;
    paramRenderModel = this.f.getRoot();
    int i;
    if (paramRenderModel != null) {
      i = paramRenderModel.getId();
    } else {
      i = 1;
    }
    this.b = i;
    this.c = new MutableEntity(null, null, null, null, null, null, null, 127, null);
    this.d = -1;
    this.e = -1;
    paramRenderModel = this.f.getRoot();
    if (paramRenderModel != null) {
      a(this, 0, paramRenderModel, 0, 4, null);
    }
  }
  
  private final InputSource a(String paramString, Map<String, InputSource> paramMap)
  {
    boolean bool = CollectionsKt.contains((Iterable)this.f.getInputSources().keySet(), paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      InputSource localInputSource = (InputSource)this.f.getInputSources().get(paramString);
      localObject1 = localObject2;
      if (localInputSource != null)
      {
        if (paramString != null) {
          paramMap.put(paramString, localInputSource);
        }
        localObject1 = localInputSource;
      }
    }
    return localObject1;
  }
  
  private final void a(Object paramObject, InputSource paramInputSource, Map<String, InputSource> paramMap)
  {
    int i;
    if ((paramObject instanceof Camera)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return;
    }
    paramObject = (InputSource)this.f.getInputSources().get(paramInputSource.inputKey);
    if (paramObject != null)
    {
      paramInputSource = paramInputSource.inputKey;
      if (paramInputSource != null) {
        paramMap.put(paramInputSource, paramObject);
      }
    }
  }
  
  private final void a(Map<String, InputSource> paramMap, Entity paramEntity)
  {
    Iterator localIterator = ((Iterable)paramEntity.getComponents()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = ((IdentifyComponent)localIterator.next()).getData();
      Object localObject1;
      if ((localObject3 instanceof PAGAsset))
      {
        localObject1 = (PAGAsset)localObject3;
        a(((PAGAsset)localObject1).src, paramMap);
        localObject1 = ((Iterable)((PAGAsset)localObject1).replacement).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(((PAGAsset.Replacement)((Iterator)localObject1).next()).src, paramMap);
        }
      }
      else
      {
        if ((localObject3 instanceof JsonObject))
        {
          localObject1 = ((JsonObject)localObject3).get("src");
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((JsonElement)localObject1).getAsString();
          if (localObject1 == null) {
            continue;
          }
        }
        else
        {
          Object localObject2 = ReflectUtilsKt.a(localObject3, g);
          localObject1 = localObject2;
          if (!(localObject2 instanceof String)) {
            localObject1 = null;
          }
          localObject1 = (String)localObject1;
          if (localObject1 == null) {
            continue;
          }
        }
        localObject1 = a((String)localObject1, paramMap);
        if (localObject1 != null) {
          a(localObject3, (InputSource)localObject1, paramMap);
        }
      }
    }
    paramEntity = ((Iterable)paramEntity.getChildren()).iterator();
    while (paramEntity.hasNext()) {
      a(paramMap, (Entity)paramEntity.next());
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.c.getComponents().get(Integer.valueOf(paramInt1));
    if (localObject1 != null)
    {
      Object localObject2 = localObject1.getClass().getName();
      localObject1 = this.c;
      Map localMap1 = CollectionExtKt.a(this.c.getComponents(), Integer.valueOf(paramInt1));
      Map localMap2 = this.c.getByComponentType();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "componentType");
      localObject2 = CollectionExtKt.c(localMap2, localObject2, Integer.valueOf(paramInt2));
      this.c = MutableEntity.copy$default((MutableEntity)localObject1, null, localMap1, null, CollectionExtKt.c(this.c.getEntityMapToComponent(), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1)), (Map)localObject2, null, null, 101, null);
    }
  }
  
  public final int a()
  {
    return this.b;
  }
  
  @Nullable
  public final InputSource a(@Nullable String paramString)
  {
    try
    {
      paramString = (InputSource)this.f.getInputSources().get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @NotNull
  public final Entity a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      localEntityId = (EntityId)this.c.getEntities().get(Integer.valueOf(paramInt));
      if (localEntityId == null) {
        break label708;
      }
      localList = (List)new ArrayList();
      if (paramBoolean1)
      {
        localObject1 = (List)this.c.getEntityMapToComponent().get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            i = ((Number)((Iterator)localObject1).next()).intValue();
            localObject3 = this.c.getComponents().get(Integer.valueOf(i));
            JsonObject localJsonObject = (JsonObject)this.c.getRawComponents().get(Integer.valueOf(i));
            if (localObject3 != null) {
              localList.add(new IdentifyComponent(Integer.valueOf(i), Integer.valueOf(paramInt), localObject3, localJsonObject));
            }
          }
        }
      }
      localObject1 = (Iterable)localList;
      paramBoolean1 = localObject1 instanceof Collection;
      j = 1;
      if ((paramBoolean1) && (((Collection)localObject1).isEmpty())) {
        break label735;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!(((IdentifyComponent)((Iterator)localObject1).next()).getData() instanceof Priority));
      i = 1;
    }
    finally
    {
      label708:
      label735:
      label747:
      label752:
      label757:
      for (;;)
      {
        EntityId localEntityId;
        List localList;
        Object localObject1;
        Object localObject3;
        int j;
        for (;;)
        {
          throw localObject2;
        }
        int i = 0;
        continue;
        i = 0;
        continue;
        paramInt = 0;
        continue;
        paramInt = 0;
      }
    }
    if (i == 0) {
      localList.add(new IdentifyComponent(Integer.valueOf(-1), Integer.valueOf(paramInt), new Priority(null, null, null, null, Integer.valueOf(-2147483648), null, 47, null), null, 8, null));
    }
    localObject1 = (Iterable)localList;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!(((IdentifyComponent)((Iterator)localObject1).next()).getData() instanceof EntityIdentifier));
      i = 1;
      if (i == 0) {
        localList.add(new IdentifyComponent(Integer.valueOf(-1), Integer.valueOf(paramInt), ComponentCreator.a.a(localEntityId.getName()), null, 8, null));
      }
      localObject1 = (List)this.c.getParentMapToEntity().get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        localObject3 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject1).add(a(this, ((Number)((Iterator)localObject3).next()).intValue(), false, false, 6, null));
        }
        localObject1 = (List)localObject1;
      }
      else
      {
        localObject1 = CollectionsKt.emptyList();
      }
      localObject3 = (Iterable)localList;
      if (((localObject3 instanceof Collection)) && (((Collection)localObject3).isEmpty())) {
        break label747;
      }
      localObject3 = ((Iterable)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
      } while (!(((IdentifyComponent)((Iterator)localObject3).next()).getData() instanceof TransitionTrigger));
      paramInt = 1;
      if ((paramInt != 0) || (!(((Collection)localObject1).isEmpty() ^ true))) {
        break label752;
      }
      paramInt = j;
      if (paramInt == 0) {
        break label757;
      }
      localObject1 = CollectionsKt.sortedWith((Iterable)localObject1, (Comparator)new RenderModelHolder.queryByEntityId..inlined.sortedBy.1());
      localObject1 = new Entity(localEntityId.getId(), localEntityId.getName(), (List)localObject1, localList, localEntityId.getEnabled(), 0, 32, null);
      return localObject1;
      throw ((Throwable)new IllegalStateException("incorrect entity id"));
    }
  }
  
  @NotNull
  public final Map<String, InputSource> a(@NotNull Entity paramEntity)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
      Map localMap = (Map)new LinkedHashMap();
      a(localMap, paramEntity);
      return localMap;
    }
    finally
    {
      paramEntity = finally;
      throw paramEntity;
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      boolean bool = this.c.getEntities().containsKey(Integer.valueOf(paramInt));
      if (!bool) {
        return;
      }
      Object localObject1 = (Integer)this.c.getEntityMapToParent().get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        int i = ((Number)localObject1).intValue();
        localObject1 = CollectionExtKt.c(this.c.getParentMapToEntity(), Integer.valueOf(i), Integer.valueOf(paramInt));
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = MapsKt.emptyMap();
      }
      this.c = MutableEntity.copy$default(this.c, CollectionExtKt.a(this.c.getEntities(), Integer.valueOf(paramInt)), null, null, null, null, (Map)localObject1, CollectionExtKt.a(this.c.getEntityMapToParent(), Integer.valueOf(paramInt)), 30, null);
      localObject1 = (List)this.c.getEntityMapToComponent().get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(paramInt, ((Number)((Iterator)localObject1).next()).intValue());
        }
      }
      localObject1 = (List)this.c.getParentMapToEntity().get(Integer.valueOf(paramInt));
      if (localObject1 != null)
      {
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          a(((Number)((Iterator)localObject1).next()).intValue());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    try
    {
      if (this.c.getComponents().containsKey(Integer.valueOf(paramInt2))) {
        b(paramInt2, paramInt1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(int paramInt1, @NotNull Entity paramEntity, int paramInt2)
  {
    i = paramInt2;
    try
    {
      Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
      if (this.c.getEntities().containsKey(Integer.valueOf(paramEntity.getId()))) {
        break label290;
      }
      localObject1 = (List)this.c.getParentMapToEntity().get(Integer.valueOf(paramInt1));
      if (localObject1 == null) {
        break label315;
      }
      paramInt2 = ((List)localObject1).size();
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        for (;;)
        {
          throw paramEntity;
        }
        paramInt2 = 0;
        if ((i < 0) || (paramInt2 < i)) {
          i = paramInt2;
        }
      }
    }
    localObject1 = new EntityId(paramEntity.getId(), paramEntity.getName(), paramEntity.getEnable());
    this.c = MutableEntity.copy$default(this.c, CollectionExtKt.a(this.c.getEntities(), Integer.valueOf(paramEntity.getId()), localObject1), null, null, null, null, CollectionExtKt.a(this.c.getParentMapToEntity(), Integer.valueOf(paramInt1), Integer.valueOf(paramEntity.getId()), i), CollectionExtKt.a(this.c.getEntityMapToParent(), Integer.valueOf(paramEntity.getId()), Integer.valueOf(paramInt1)), 30, null);
    localObject1 = ((Iterable)paramEntity.getComponents()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IdentifyComponent)((Iterator)localObject1).next();
      a(paramEntity.getId(), ((IdentifyComponent)localObject2).getData(), ((IdentifyComponent)localObject2).getId(), ((IdentifyComponent)localObject2).getRawData());
    }
    localObject1 = ((Iterable)paramEntity.getChildren()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Entity)((Iterator)localObject1).next();
      a(this, paramEntity.getId(), (Entity)localObject2, 0, 4, null);
    }
    return;
    label290:
    throw ((Throwable)new IllegalStateException("entity id duplicate, please remove it first"));
  }
  
  public final void a(int paramInt, @NotNull Object paramObject, @Nullable Integer paramInteger, @Nullable JsonObject paramJsonObject)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "component");
      if (paramInteger != null)
      {
        paramInteger.intValue();
        String str = paramObject.getClass().getName();
        int i = paramInteger.intValue();
        if (i == -1) {
          return;
        }
        MutableEntity localMutableEntity = this.c;
        paramObject = CollectionExtKt.a(this.c.getComponents(), paramInteger, paramObject);
        paramJsonObject = CollectionExtKt.a(this.c.getRawComponents(), paramInteger, paramJsonObject);
        paramInteger = CollectionExtKt.b(this.c.getEntityMapToComponent(), Integer.valueOf(paramInt), paramInteger);
        Map localMap = this.c.getByComponentType();
        Intrinsics.checkExpressionValueIsNotNull(str, "componentType");
        this.c = MutableEntity.copy$default(localMutableEntity, null, paramObject, paramJsonObject, paramInteger, CollectionExtKt.b(localMap, str, Integer.valueOf(paramInt)), null, null, 97, null);
        return;
      }
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull InputSource paramInputSource)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
      String str = paramInputSource.key;
      if (str != null)
      {
        this.f.getInputSources().put(str, paramInputSource);
        return;
      }
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull Size paramSize)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramSize, "size");
        RenderModel localRenderModel = this.f;
        Properties localProperties = this.f.getProperties();
        if (localProperties != null)
        {
          paramSize = Properties.copy$default(localProperties, new Layout(paramSize.width, paramSize.height), null, null, null, null, null, null, 126, null);
          this.f = RenderModel.copy$default(localRenderModel, null, null, null, null, null, false, 0, paramSize, null, null, 0L, 0, null, 8063, null);
          return;
        }
      }
      finally {}
      paramSize = null;
    }
  }
  
  public final void a(@Nullable Integer paramInteger, @NotNull Object paramObject)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramObject, "component");
      if (paramInteger != null)
      {
        ((Number)paramInteger).intValue();
        if (this.c.getComponents().containsKey(paramInteger)) {
          this.c = MutableEntity.copy$default(this.c, null, CollectionExtKt.a(this.c.getComponents(), paramInteger, paramObject), null, null, null, null, null, 125, null);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(@NotNull List<Timeline> paramList)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "timeLines");
      this.f = RenderModel.copy$default(this.f, null, null, null, null, null, false, 0, null, null, paramList, 0L, 0, null, 7679, null);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public final void a(@NotNull List<ClipSource> paramList, boolean paramBoolean)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramList, "clips");
      this.f = RenderModel.copy$default(this.f, null, null, null, null, paramList, paramBoolean, 0, null, null, null, 0L, 0, null, 8143, null);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public final boolean a(@NotNull Painting paramPainting)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramPainting, "backGround");
      boolean bool = Intrinsics.areEqual(this.f.getPainting(), paramPainting);
      if (bool) {
        return false;
      }
      this.f = RenderModel.copy$default(this.f, null, null, null, paramPainting, null, false, 0, null, null, null, 0L, 0, null, 8183, null);
      return true;
    }
    finally {}
  }
  
  @NotNull
  public final RenderModel b()
  {
    try
    {
      Object localObject1 = a(this, this.b, false, false, 2, null);
      int i = this.c.getEntities().size();
      int j = this.f.getInputSources().size();
      if ((this.d == i) && (this.e == j))
      {
        localObject1 = RenderModel.copy$default(this.f, null, (Entity)localObject1, null, null, null, false, 0, null, null, null, 0L, 0, null, 8189, null);
      }
      else
      {
        this.d = i;
        this.e = j;
        localObject1 = RenderModel.copy$default(this.f, null, (Entity)localObject1, a((Entity)localObject1), null, null, false, 0, null, null, null, 0L, 0, null, 8185, null);
      }
      this.f = ((RenderModel)localObject1);
      localObject1 = this.f;
      return localObject1;
    }
    finally {}
  }
  
  @NotNull
  public final List<Entity> b(@NotNull String paramString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramString, "type");
      Object localObject = (List)new ArrayList();
      paramString = (List)this.c.getByComponentType().get(paramString);
      if (paramString != null) {}
      for (;;)
      {
        paramString = (Collection)paramString;
        break;
        paramString = CollectionsKt.emptyList();
      }
      ((List)localObject).addAll(paramString);
      localObject = (Iterable)localObject;
      paramString = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramString.add(a(this, ((Number)((Iterator)localObject).next()).intValue(), false, false, 6, null));
      }
      paramString = (List)paramString;
      return paramString;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final boolean b(@Nullable List<? extends VoiceEnum> paramList)
  {
    if ((Intrinsics.areEqual(this.f.getVoiceChangerConfig(), paramList) ^ true))
    {
      this.f = RenderModel.copy$default(this.f, null, null, null, null, null, false, 0, null, null, null, 0L, 0, paramList, 4095, null);
      return true;
    }
    return false;
  }
  
  public final int c()
  {
    try
    {
      int i;
      if ((this.c.getEntities().isEmpty() ^ true))
      {
        Object localObject1 = MapsKt.toSortedMap(this.c.getEntities()).lastKey();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mutableEntity.entities.toSortedMap().lastKey()");
        i = ((Number)localObject1).intValue();
      }
      else
      {
        i = 0;
      }
      return i;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public final int d()
  {
    try
    {
      int i;
      if ((this.c.getComponents().isEmpty() ^ true))
      {
        Object localObject1 = MapsKt.toSortedMap(this.c.getComponents()).lastKey();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mutableEntity.components.toSortedMap().lastKey()");
        i = ((Number)localObject1).intValue();
      }
      else
      {
        i = 0;
      }
      return i;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  @NotNull
  public final List<ClipSource> e()
  {
    try
    {
      List localList = this.f.getClipsAssets();
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.dataprocessor.RenderModelHolder
 * JD-Core Version:    0.7.0.1
 */