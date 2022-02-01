package com.tencent.tavcut.rendermodel.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.CameraComponent;
import com.tencent.tavcut.composition.model.component.CustomGraph;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.PostEffect;
import com.tencent.tavcut.composition.model.component.RandomGroup;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Script;
import com.tencent.tavcut.composition.model.component.SingleMedia;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.TimeRange;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.properties.Layout;
import com.tencent.tavcut.rendermodel.properties.Properties;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader;", "", "()V", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "timeRangeDecoder", "com/tencent/tavcut/rendermodel/parser/LightJsonReader$timeRangeDecoder$1", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$timeRangeDecoder$1;", "findMaxCid", "", "prevMax", "entity", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "fixComponentId", "root", "fixEntityIterate", "emitter", "Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$CidEmitter;", "readArray", "", "T", "reader", "Lcom/google/gson/stream/JsonReader;", "inner", "Lkotlin/Function1;", "readAudioSource", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "obj", "Lcom/google/gson/JsonObject;", "readCamera", "readComponent", "readComponent$lib_tavcut_model_release", "readCustomGraph", "readEntity", "readEntity$lib_tavcut_model_release", "readEntityIdentifier", "readFilterGroup", "readImage", "readInputSource", "", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "readLUTFilter", "readMultiMedia", "readPAGAsset", "readPostEffect", "readProperties", "Lcom/tencent/tavcut/rendermodel/properties/Properties;", "readProperties$lib_tavcut_model_release", "readRandomGroup", "readRenderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "readScreenTransform", "readScript", "readSingleMedia", "readTimeOffset", "readTransition", "readTransitionTrigger", "readUnknownComponent", "maxOf", "R", "", "", "selector", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "CidEmitter", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class LightJsonReader
{
  private final Gson gson = new GsonBuilder().registerTypeAdapter((Type)TimeRange.class, this.timeRangeDecoder).create();
  private final LightJsonReader.timeRangeDecoder.1 timeRangeDecoder = new LightJsonReader.timeRangeDecoder.1();
  
  private final int findMaxCid(int paramInt, Entity paramEntity)
  {
    Iterator localIterator = ((Iterable)paramEntity.getComponents()).iterator();
    if (localIterator.hasNext())
    {
      Integer localInteger = ((IdentifyComponent)localIterator.next()).getId();
      int i;
      if (localInteger != null) {
        i = localInteger.intValue();
      } else {
        i = 0;
      }
      while (localIterator.hasNext())
      {
        localInteger = ((IdentifyComponent)localIterator.next()).getId();
        if (localInteger != null) {
          j = localInteger.intValue();
        } else {
          j = 0;
        }
        if (Intrinsics.compare(i, j) < 0) {
          i = j;
        }
      }
      int j = Math.max(i, paramInt);
      if ((((Collection)paramEntity.getChildren()).isEmpty() ^ true))
      {
        paramEntity = ((Iterable)paramEntity.getChildren()).iterator();
        if (paramEntity.hasNext())
        {
          paramInt = findMaxCid(j, (Entity)paramEntity.next());
          while (paramEntity.hasNext())
          {
            i = findMaxCid(j, (Entity)paramEntity.next());
            if (Intrinsics.compare(paramInt, i) < 0) {
              paramInt = i;
            }
          }
          return paramInt;
        }
        throw ((Throwable)new NoSuchElementException());
      }
      return j;
    }
    paramEntity = (Throwable)new NoSuchElementException();
    for (;;)
    {
      throw paramEntity;
    }
  }
  
  private final Entity fixComponentId(Entity paramEntity)
  {
    if (paramEntity == null) {
      return paramEntity;
    }
    return fixEntityIterate(paramEntity, new LightJsonReader.CidEmitter(findMaxCid(0, paramEntity)));
  }
  
  private final Entity fixEntityIterate(Entity paramEntity, LightJsonReader.CidEmitter paramCidEmitter)
  {
    Object localObject1 = (Iterable)paramEntity.getComponents();
    Object localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (IdentifyComponent)localIterator.next();
      Integer localInteger = ((IdentifyComponent)localObject2).getId();
      if (localInteger == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (localInteger.intValue() == 0) {
          localObject1 = IdentifyComponent.copy$default((IdentifyComponent)localObject2, Integer.valueOf(paramCidEmitter.next()), null, null, null, 14, null);
        }
      }
      ((Collection)localObject3).add(localObject1);
    }
    localObject1 = (List)localObject3;
    localObject3 = (Iterable)paramEntity.getChildren();
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(fixEntityIterate((Entity)((Iterator)localObject3).next(), paramCidEmitter));
    }
    return Entity.copy$default(paramEntity, 0, null, (List)localObject2, (List)localObject1, false, 0, 51, null);
  }
  
  private final <T, R extends Comparable<? super R>> R maxOf(@NotNull Iterable<? extends T> paramIterable, Function1<? super T, ? extends R> paramFunction1)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      paramIterable = (Comparable)paramFunction1.invoke(localIterator.next());
      while (localIterator.hasNext())
      {
        Comparable localComparable = (Comparable)paramFunction1.invoke(localIterator.next());
        if (paramIterable.compareTo(localComparable) < 0) {
          paramIterable = localComparable;
        }
      }
      return paramIterable;
    }
    paramIterable = (Throwable)new NoSuchElementException();
    for (;;)
    {
      throw paramIterable;
    }
  }
  
  private final <T> List<T> readArray(JsonReader paramJsonReader, Function1<? super JsonReader, ? extends T> paramFunction1)
  {
    paramJsonReader.beginArray();
    List localList = (List)new ArrayList();
    while (paramJsonReader.hasNext()) {
      localList.add(paramFunction1.invoke(paramJsonReader));
    }
    paramJsonReader.endArray();
    return localList;
  }
  
  private final IdentifyComponent readAudioSource(JsonObject paramJsonObject)
  {
    AudioSource localAudioSource = (AudioSource)this.gson.fromJson((JsonElement)paramJsonObject, AudioSource.class);
    Integer localInteger1 = localAudioSource.componentID;
    Integer localInteger2 = localAudioSource.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localAudioSource, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localAudioSource, paramJsonObject);
  }
  
  private final IdentifyComponent readCamera(JsonObject paramJsonObject)
  {
    CameraComponent localCameraComponent = (CameraComponent)this.gson.fromJson((JsonElement)paramJsonObject, CameraComponent.class);
    Integer localInteger1 = localCameraComponent.componentID;
    Integer localInteger2 = localCameraComponent.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localCameraComponent, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localCameraComponent, paramJsonObject);
  }
  
  private final IdentifyComponent readCustomGraph(JsonObject paramJsonObject)
  {
    paramJsonObject = (CustomGraph)this.gson.fromJson((JsonElement)paramJsonObject, CustomGraph.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final IdentifyComponent readEntityIdentifier(JsonObject paramJsonObject)
  {
    EntityIdentifier localEntityIdentifier = (EntityIdentifier)this.gson.fromJson((JsonElement)paramJsonObject, EntityIdentifier.class);
    Integer localInteger = localEntityIdentifier.id;
    Intrinsics.checkExpressionValueIsNotNull(localEntityIdentifier, "data");
    return new IdentifyComponent(Integer.valueOf(-1), localInteger, localEntityIdentifier, paramJsonObject);
  }
  
  private final IdentifyComponent readFilterGroup(JsonObject paramJsonObject)
  {
    FilterGroup localFilterGroup = (FilterGroup)this.gson.fromJson((JsonElement)paramJsonObject, FilterGroup.class);
    Integer localInteger1 = localFilterGroup.componentID;
    Integer localInteger2 = localFilterGroup.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localFilterGroup, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localFilterGroup, paramJsonObject);
  }
  
  private final IdentifyComponent readImage(JsonObject paramJsonObject)
  {
    paramJsonObject = (Image)this.gson.fromJson((JsonElement)paramJsonObject, Image.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final Map<String, InputSource> readInputSource(JsonReader paramJsonReader)
  {
    Type localType = new LightJsonReader.readInputSource.typeToken.1().getType();
    paramJsonReader = this.gson.fromJson(paramJsonReader, localType);
    Intrinsics.checkExpressionValueIsNotNull(paramJsonReader, "gson.fromJson(reader, typeToken)");
    return (Map)paramJsonReader;
  }
  
  private final IdentifyComponent readLUTFilter(JsonObject paramJsonObject)
  {
    LUTFilter localLUTFilter = (LUTFilter)this.gson.fromJson((JsonElement)paramJsonObject, LUTFilter.class);
    Integer localInteger1 = localLUTFilter.componentID;
    Integer localInteger2 = localLUTFilter.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localLUTFilter, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localLUTFilter, paramJsonObject);
  }
  
  private final IdentifyComponent readMultiMedia(JsonObject paramJsonObject)
  {
    MultiMedia localMultiMedia = (MultiMedia)this.gson.fromJson((JsonElement)paramJsonObject, MultiMedia.class);
    Integer localInteger1 = localMultiMedia.componentID;
    Integer localInteger2 = localMultiMedia.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localMultiMedia, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localMultiMedia, paramJsonObject);
  }
  
  private final IdentifyComponent readPAGAsset(JsonObject paramJsonObject)
  {
    PAGAsset localPAGAsset = (PAGAsset)this.gson.fromJson((JsonElement)paramJsonObject, PAGAsset.class);
    Integer localInteger1 = localPAGAsset.componentID;
    Integer localInteger2 = localPAGAsset.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localPAGAsset, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localPAGAsset, paramJsonObject);
  }
  
  private final IdentifyComponent readPostEffect(JsonObject paramJsonObject)
  {
    paramJsonObject = (PostEffect)this.gson.fromJson((JsonElement)paramJsonObject, PostEffect.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final IdentifyComponent readRandomGroup(JsonObject paramJsonObject)
  {
    RandomGroup localRandomGroup = (RandomGroup)this.gson.fromJson((JsonElement)paramJsonObject, RandomGroup.class);
    Integer localInteger1 = localRandomGroup.componentID;
    Integer localInteger2 = localRandomGroup.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localRandomGroup, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localRandomGroup, paramJsonObject);
  }
  
  private final IdentifyComponent readScreenTransform(JsonObject paramJsonObject)
  {
    ScreenTransform localScreenTransform = (ScreenTransform)this.gson.fromJson((JsonElement)paramJsonObject, ScreenTransform.class);
    Integer localInteger1 = localScreenTransform.componentID;
    Integer localInteger2 = localScreenTransform.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localScreenTransform, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localScreenTransform, paramJsonObject);
  }
  
  private final IdentifyComponent readScript(JsonObject paramJsonObject)
  {
    paramJsonObject = (Script)this.gson.fromJson((JsonElement)paramJsonObject, Script.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final IdentifyComponent readSingleMedia(JsonObject paramJsonObject)
  {
    paramJsonObject = (SingleMedia)this.gson.fromJson((JsonElement)paramJsonObject, SingleMedia.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final IdentifyComponent readTimeOffset(JsonObject paramJsonObject)
  {
    TimeOffset localTimeOffset = (TimeOffset)this.gson.fromJson((JsonElement)paramJsonObject, TimeOffset.class);
    Integer localInteger1 = localTimeOffset.componentID;
    Integer localInteger2 = localTimeOffset.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localTimeOffset, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localTimeOffset, paramJsonObject);
  }
  
  private final IdentifyComponent readTransition(JsonObject paramJsonObject)
  {
    paramJsonObject = (Transition)this.gson.fromJson((JsonElement)paramJsonObject, Transition.class);
    Integer localInteger1 = paramJsonObject.componentID;
    Integer localInteger2 = paramJsonObject.entityId;
    Intrinsics.checkExpressionValueIsNotNull(paramJsonObject, "data");
    return new IdentifyComponent(localInteger1, localInteger2, paramJsonObject, null, 8, null);
  }
  
  private final IdentifyComponent readTransitionTrigger(JsonObject paramJsonObject)
  {
    TransitionTrigger localTransitionTrigger = (TransitionTrigger)this.gson.fromJson((JsonElement)paramJsonObject, TransitionTrigger.class);
    Integer localInteger1 = localTransitionTrigger.componentID;
    Integer localInteger2 = localTransitionTrigger.entityId;
    Intrinsics.checkExpressionValueIsNotNull(localTransitionTrigger, "data");
    return new IdentifyComponent(localInteger1, localInteger2, localTransitionTrigger, paramJsonObject);
  }
  
  private final IdentifyComponent readUnknownComponent(JsonObject paramJsonObject)
  {
    JsonElement localJsonElement = paramJsonObject.get("componentID");
    Intrinsics.checkExpressionValueIsNotNull(localJsonElement, "obj.get(TemplateParser.KEY_COMPONENT_ID)");
    int j = localJsonElement.getAsInt();
    localJsonElement = paramJsonObject.get("entityId");
    int i;
    if (localJsonElement != null) {
      i = localJsonElement.getAsInt();
    } else {
      i = 0;
    }
    return new IdentifyComponent(Integer.valueOf(j), Integer.valueOf(i), paramJsonObject, null, 8, null);
  }
  
  @NotNull
  public final IdentifyComponent readComponent$lib_tavcut_model_release(@NotNull JsonReader paramJsonReader)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonReader, "reader");
    paramJsonReader = new JsonParser().parse(paramJsonReader);
    Intrinsics.checkExpressionValueIsNotNull(paramJsonReader, "JsonParser().parse(reader)");
    paramJsonReader = paramJsonReader.getAsJsonObject();
    Object localObject = paramJsonReader.get("type");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "obj.get(\"type\")");
    localObject = ((JsonElement)localObject).getAsString();
    if (localObject != null) {
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 2105663345: 
        if (((String)localObject).equals("AudioSource")) {
          return readAudioSource(paramJsonReader);
        }
        break;
      case 2011082565: 
        if (((String)localObject).equals("Camera")) {
          return readCamera(paramJsonReader);
        }
        break;
      case 1640308762: 
        if (((String)localObject).equals("PAGAsset")) {
          return readPAGAsset(paramJsonReader);
        }
        break;
      case 1527644995: 
        if (((String)localObject).equals("LUTFilter")) {
          return readLUTFilter(paramJsonReader);
        }
        break;
      case 946096988: 
        if (((String)localObject).equals("RandomGroup")) {
          return readRandomGroup(paramJsonReader);
        }
        break;
      case 755715527: 
        if (((String)localObject).equals("FilterGroup")) {
          return readFilterGroup(paramJsonReader);
        }
        break;
      case 642858048: 
        if (((String)localObject).equals("ScreenTransform")) {
          return readScreenTransform(paramJsonReader);
        }
        break;
      case 269306229: 
        if (((String)localObject).equals("Transition")) {
          return readTransition(paramJsonReader);
        }
        break;
      case 185861763: 
        if (((String)localObject).equals("TransitionTrigger")) {
          return readTransitionTrigger(paramJsonReader);
        }
        break;
      case 70760763: 
        if (((String)localObject).equals("Image")) {
          return readImage(paramJsonReader);
        }
        break;
      case -80932772: 
        if (((String)localObject).equals("SingleMedia")) {
          return readSingleMedia(paramJsonReader);
        }
        break;
      case -131896259: 
        if (((String)localObject).equals("CustomGraph")) {
          return readCustomGraph(paramJsonReader);
        }
        break;
      case -1068965301: 
        if (((String)localObject).equals("MultiMedia")) {
          return readMultiMedia(paramJsonReader);
        }
        break;
      case -1096473999: 
        if (((String)localObject).equals("PostEffect")) {
          return readPostEffect(paramJsonReader);
        }
        break;
      case -1636011552: 
        if (((String)localObject).equals("TimeOffset")) {
          return readTimeOffset(paramJsonReader);
        }
        break;
      case -1823818517: 
        if (((String)localObject).equals("Script")) {
          return readScript(paramJsonReader);
        }
        break;
      case -2016972532: 
        if (((String)localObject).equals("EntityIdentifier")) {
          return readEntityIdentifier(paramJsonReader);
        }
        break;
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(paramJsonReader, "obj");
    return readUnknownComponent(paramJsonReader);
  }
  
  @NotNull
  public final Entity readEntity$lib_tavcut_model_release(@NotNull JsonReader paramJsonReader)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonReader, "reader");
    paramJsonReader.beginObject();
    Entity localEntity = new Entity(0, null, null, null, false, 0, 63, null);
    String str1 = localEntity.getName();
    int j = localEntity.getId();
    List localList1 = localEntity.getComponents();
    List localList2 = localEntity.getChildren();
    boolean bool = localEntity.getEnable();
    int i = localEntity.getVersion();
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      if (str2 != null) {
        switch (str2.hashCode())
        {
        default: 
          break;
        case 1659526655: 
          if (str2.equals("children")) {
            localList2 = readArray(paramJsonReader, (Function1)new LightJsonReader.readEntity.2((LightJsonReader)this));
          }
          break;
        case 351608024: 
          if (str2.equals("version")) {
            i = paramJsonReader.nextInt();
          }
          break;
        case 3373707: 
          if (str2.equals("name"))
          {
            str1 = paramJsonReader.nextString();
            Intrinsics.checkExpressionValueIsNotNull(str1, "reader.nextString()");
          }
          break;
        case 3355: 
          if (str2.equals("id")) {
            j = paramJsonReader.nextInt();
          }
          break;
        case -447446250: 
          if (str2.equals("components")) {
            localList1 = readArray(paramJsonReader, (Function1)new LightJsonReader.readEntity.1((LightJsonReader)this));
          }
          break;
        case -1609594047: 
          if (str2.equals("enabled")) {
            bool = paramJsonReader.nextBoolean();
          }
          break;
        }
      } else {
        paramJsonReader.skipValue();
      }
    }
    paramJsonReader.endObject();
    return localEntity.copy(j, str1, localList2, localList1, bool, i);
  }
  
  @NotNull
  public final Properties readProperties$lib_tavcut_model_release(@NotNull JsonReader paramJsonReader)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonReader, "reader");
    paramJsonReader.beginObject();
    Object localObject7 = (Layout)null;
    Object localObject5 = (JsonObject)null;
    Object localObject6 = (JsonArray)null;
    Object localObject1 = localObject6;
    Object localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    while (paramJsonReader.hasNext())
    {
      Object localObject8 = paramJsonReader.nextName();
      if (localObject8 != null) {
        switch (((String)localObject8).hashCode())
        {
        default: 
          break;
        case 1234514922: 
          if (((String)localObject8).equals("resourceIDs"))
          {
            localObject4 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "JsonParser().parse(reader)");
            localObject4 = ((JsonElement)localObject4).getAsJsonArray();
          }
          break;
        case 843857523: 
          if (((String)localObject8).equals("musicIDs"))
          {
            localObject1 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "JsonParser().parse(reader)");
            localObject1 = ((JsonElement)localObject1).getAsJsonArray();
          }
          break;
        case 280514122: 
          if (((String)localObject8).equals("materialConfigs"))
          {
            localObject3 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "JsonParser().parse(reader)");
            localObject3 = ((JsonElement)localObject3).getAsJsonArray();
          }
          break;
        case 97615364: 
          if (((String)localObject8).equals("fonts"))
          {
            localObject2 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "JsonParser().parse(reader)");
            localObject2 = ((JsonElement)localObject2).getAsJsonArray();
          }
          break;
        case -10585181: 
          if (((String)localObject8).equals("boundsTrackerPlaceHolders"))
          {
            localObject6 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject6, "JsonParser().parse(reader)");
            localObject6 = ((JsonElement)localObject6).getAsJsonArray();
          }
          break;
        case -1109722326: 
          if (((String)localObject8).equals("layout"))
          {
            localObject7 = this.gson;
            localObject8 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject8, "JsonParser().parse(reader)");
            localObject7 = (Layout)((Gson)localObject7).fromJson((JsonElement)((JsonElement)localObject8).getAsJsonObject(), Layout.class);
          }
          break;
        case -1684501870: 
          if (((String)localObject8).equals("movieConfig"))
          {
            localObject5 = new JsonParser().parse(paramJsonReader);
            Intrinsics.checkExpressionValueIsNotNull(localObject5, "JsonParser().parse(reader)");
            localObject5 = ((JsonElement)localObject5).getAsJsonObject();
          }
          break;
        }
      } else {
        paramJsonReader.skipValue();
      }
    }
    paramJsonReader.endObject();
    return new Properties((Layout)localObject7, (JsonArray)localObject6, (JsonArray)localObject1, (JsonArray)localObject2, (JsonObject)localObject5, (JsonArray)localObject3, (JsonArray)localObject4);
  }
  
  @NotNull
  public final RenderModel readRenderModel(@NotNull JsonReader paramJsonReader)
  {
    Intrinsics.checkParameterIsNotNull(paramJsonReader, "reader");
    Entity localEntity = (Entity)null;
    Map localMap = MapsKt.emptyMap();
    Properties localProperties = (Properties)null;
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      if (str != null)
      {
        int i = str.hashCode();
        if (i != -1035508594)
        {
          if (i != -926053069)
          {
            if ((i == 3506402) && (str.equals("root"))) {
              localEntity = readEntity$lib_tavcut_model_release(paramJsonReader);
            }
          }
          else if (str.equals("properties")) {
            localProperties = readProperties$lib_tavcut_model_release(paramJsonReader);
          }
        }
        else if (str.equals("inputSources"))
        {
          localMap = readInputSource(paramJsonReader);
          continue;
        }
      }
      paramJsonReader.skipValue();
    }
    paramJsonReader.endObject();
    return new RenderModel(null, fixComponentId(localEntity), MapsKt.toMutableMap(localMap), null, null, false, 0, localProperties, null, null, 0L, 0, null, 8057, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonReader
 * JD-Core Version:    0.7.0.1
 */