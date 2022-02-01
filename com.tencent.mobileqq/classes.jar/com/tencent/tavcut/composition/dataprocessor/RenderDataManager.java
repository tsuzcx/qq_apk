package com.tencent.tavcut.composition.dataprocessor;

import com.tencent.tavcut.composition.model.component.AudioEffect;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.FilterGroup;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.SingleMedia;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.creator.ComponentCreator;
import com.tencent.tavcut.creator.EntityCreator;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.render.log.TavLogger;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/dataprocessor/RenderDataManager;", "", "()V", "componentIdGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", "dataChangeListener", "Lcom/tencent/tavcut/composition/dataprocessor/IDataChangeListener;", "entityIdGenerator", "renderModelHolder", "Lcom/tencent/tavcut/composition/dataprocessor/RenderModelHolder;", "templateDir", "", "getTemplateDir", "()Ljava/lang/String;", "setTemplateDir", "(Ljava/lang/String;)V", "accessInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "sourceKey", "addAndNotifyEntityChanged", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "parentId", "", "index", "addBgm", "addClipEffect", "addDataChangeListener", "", "listener", "addEffect", "parentEntityId", "addEntity", "addInputSource", "inputSource", "addOnRoot", "addRenderTarget", "addSingleMedia", "sourceCount", "addSingleMedia$lib_tavcut_release", "addTransition", "checkSourceIsReady", "", "clearTransitionSource", "entityId", "createDefaultSingleMedia", "newIndex", "createDefaultTransitionEntity", "decreaseSingleMediaIndex", "enableImageEffect", "enable", "findTargetSingleMediaEntity", "findTargetSingleMediaEntity$lib_tavcut_release", "generateComponentId", "generateEntityId", "getBackgroundPagPath", "backGround", "Lcom/tencent/tavcut/model/Painting;", "getRenderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "getTransitions", "", "handleUpdatePainting", "identifyComponent", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "increaseSingleMediaIndex", "initRenderModel", "renderModel", "initTransitions", "size", "initTransitions$lib_tavcut_release", "internalAddClipEffect", "notifyChanged", "internalAddClipEffect$lib_tavcut_release", "internalAddTransition", "internalAddTransition$lib_tavcut_release", "internalRemoveSingleMedia", "internalRemoveSingleMedia$lib_tavcut_release", "internalRemoveTransition", "internalRemoveTransition$lib_tavcut_release", "internalUpdateComponent", "originEntityId", "component", "isSingleMedia", "notifyEntityChanged", "queryEffectIndex", "", "entityIds", "querySingleMedias", "querySingleMedias$lib_tavcut_release", "removeEntity", "removeInputSource", "reorderSingleMedia", "fromIndex", "toIndex", "setClipAssets", "clips", "Lcom/tencent/tavcut/model/ClipSource;", "modifyClipsDuration", "setTransition", "newTransition", "setVoiceChangerConfig", "config", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "updateComponent", "updateEffectIndex", "updatePainting", "updateTimeLine", "timeLine", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "updatedMultiMediaByPainting", "Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "componentId", "originMultiMedia", "(Ljava/lang/Integer;Lcom/tencent/tavcut/composition/model/component/MultiMedia;Lcom/tencent/tavcut/model/Painting;)Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class RenderDataManager
{
  public static final RenderDataManager.Companion a = new RenderDataManager.Companion(null);
  private RenderModelHolder b;
  private final AtomicInteger c = new AtomicInteger(0);
  private final AtomicInteger d = new AtomicInteger(0);
  @NotNull
  private String e = "/";
  private IDataChangeListener f;
  
  private final void a(boolean paramBoolean)
  {
    Object localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = MultiMedia.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MultiMedia::class.java.name");
      localObject1 = ((RenderModelHolder)localObject1).b((String)localObject2);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Object localObject3 = ((Iterable)localObject1).iterator();
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (Entity)((Iterator)localObject3).next();
          localIterator = ((Iterable)((Entity)localObject1).getComponents()).iterator();
        }
        localObject2 = (IdentifyComponent)localIterator.next();
      } while (!(((IdentifyComponent)localObject2).getData() instanceof MultiMedia));
      localObject3 = ((IdentifyComponent)localObject2).getData();
      if (localObject3 != null)
      {
        localObject3 = MultiMedia.copy$default((MultiMedia)localObject3, null, null, null, null, null, null, Boolean.valueOf(paramBoolean), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777151, null);
        b(((Entity)localObject1).getId(), IdentifyComponent.copy$default((IdentifyComponent)localObject2, null, null, localObject3, null, 11, null));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.MultiMedia");
    }
  }
  
  private final Entity b(Entity paramEntity, int paramInt1, int paramInt2)
  {
    paramEntity = a(paramEntity, paramInt1, paramInt2);
    g();
    return paramEntity;
  }
  
  private final String b(Painting paramPainting)
  {
    if (paramPainting.backgroundFillMode == BackgroundFillMode.PAG) {
      return paramPainting.pagPath;
    }
    return null;
  }
  
  private final void b(int paramInt, Entity paramEntity)
  {
    e(paramEntity, paramInt);
  }
  
  private final boolean b(int paramInt, IdentifyComponent paramIdentifyComponent)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.b;
        if (localObject1 == null) {
          break label149;
        }
        localObject1 = RenderModelHolder.a((RenderModelHolder)localObject1, paramInt, false, false, 6, null);
        if (localObject1 != null)
        {
          localObject1 = ((Entity)localObject1).getComponents();
          if (localObject1 != null)
          {
            Object localObject2 = ((Iterable)localObject1).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (IdentifyComponent)((Iterator)localObject2).next();
              if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((IdentifyComponent)localObject1).getData().getClass()), Reflection.getOrCreateKotlinClass(paramIdentifyComponent.getData().getClass()))) || (!(Intrinsics.areEqual(((IdentifyComponent)localObject1).getData(), paramIdentifyComponent.getData()) ^ true))) {
                continue;
              }
              localObject2 = this.b;
              if (localObject2 != null) {
                ((RenderModelHolder)localObject2).a(((IdentifyComponent)localObject1).getId(), paramIdentifyComponent.getData());
              }
              return true;
            }
          }
        }
      }
      catch (IllegalStateException paramIdentifyComponent)
      {
        TavLogger.b("RenderDataManager", paramIdentifyComponent.getMessage());
      }
      return false;
      label149:
      Object localObject1 = null;
    }
  }
  
  private final void c(int paramInt1, int paramInt2)
  {
    Iterator localIterator = d().iterator();
    label190:
    while (localIterator.hasNext())
    {
      Entity localEntity = (Entity)localIterator.next();
      Object localObject = localEntity.getComponents().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label190;
        }
        IdentifyComponent localIdentifyComponent = (IdentifyComponent)((Iterator)localObject).next();
        if ((localIdentifyComponent.getData() instanceof SingleMedia))
        {
          localObject = localIdentifyComponent.getData();
          if (localObject != null)
          {
            localObject = (SingleMedia)localObject;
            Integer localInteger = ((SingleMedia)localObject).index;
            int i;
            if (localInteger != null) {
              i = localInteger.intValue();
            } else {
              i = -1;
            }
            if (i >= paramInt1)
            {
              localObject = SingleMedia.copy$default((SingleMedia)localObject, null, null, null, null, Integer.valueOf(i + paramInt2), null, null, 111, null);
              b(localEntity.getId(), IdentifyComponent.copy$default(localIdentifyComponent, null, null, localObject, null, 11, null));
              break;
            }
            break;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.SingleMedia");
        }
      }
    }
  }
  
  private final Entity e()
  {
    Transition localTransition = ComponentCreator.a.a("", 0L);
    ScreenTransform localScreenTransform = ComponentCreator.a.a();
    EntityIdentifier localEntityIdentifier = ComponentCreator.a.a("transition");
    return EntityCreator.a.a("transition", (List)CollectionsKt.arrayListOf(new IdentifyComponent[] { new IdentifyComponent(localTransition), new IdentifyComponent(localScreenTransform), new IdentifyComponent(localEntityIdentifier) }));
  }
  
  private final Entity e(Entity paramEntity, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      String str = TransitionTrigger.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "TransitionTrigger::class.java.name");
      localObject = ((RenderModelHolder)localObject).b(str);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (Entity)CollectionsKt.firstOrNull((List)localObject);
      if (localObject != null) {
        return a(paramEntity, ((Entity)localObject).getId(), paramInt);
      }
    }
    return new Entity(0, null, null, null, false, 0, 63, null);
  }
  
  private final Entity f(Entity paramEntity, int paramInt)
  {
    RenderModelHolder localRenderModelHolder = this.b;
    if (localRenderModelHolder != null) {
      return b(paramEntity, localRenderModelHolder.a(), paramInt);
    }
    return new Entity(0, null, null, null, false, 0, 63, null);
  }
  
  private final boolean f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((RenderModelHolder)localObject).e();
      if ((localObject != null) && ((((Collection)localObject).isEmpty() ^ true) == true)) {
        return true;
      }
    }
    return false;
  }
  
  private final Entity g(int paramInt)
  {
    Object localObject2 = ComponentCreator.a.a(paramInt);
    Object localObject3 = ComponentCreator.a.a();
    Object localObject1 = ComponentCreator.a.a("singlemedia");
    AudioEffect localAudioEffect = ComponentCreator.a.c("");
    localObject2 = CollectionsKt.arrayListOf(new IdentifyComponent[] { new IdentifyComponent(localObject2), new IdentifyComponent(localObject3), new IdentifyComponent(localAudioEffect), new IdentifyComponent(localObject1) });
    localObject3 = EntityCreator.a;
    localObject1 = ((EntityIdentifier)localObject1).name;
    if (localObject1 == null) {
      localObject1 = "";
    }
    return ((EntityCreator)localObject3).a((String)localObject1, (List)localObject2);
  }
  
  private final void g()
  {
    if (!f()) {
      return;
    }
    IDataChangeListener localIDataChangeListener = this.f;
    if (localIDataChangeListener != null) {
      localIDataChangeListener.c();
    }
  }
  
  private final int h()
  {
    return this.c.incrementAndGet();
  }
  
  private final void h(int paramInt)
  {
    Iterator localIterator = d().iterator();
    label187:
    while (localIterator.hasNext())
    {
      Entity localEntity = (Entity)localIterator.next();
      Object localObject = localEntity.getComponents().iterator();
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          break label187;
        }
        IdentifyComponent localIdentifyComponent = (IdentifyComponent)((Iterator)localObject).next();
        if ((localIdentifyComponent.getData() instanceof SingleMedia))
        {
          localObject = localIdentifyComponent.getData();
          if (localObject != null)
          {
            localObject = (SingleMedia)localObject;
            Integer localInteger = ((SingleMedia)localObject).index;
            int i;
            if (localInteger != null) {
              i = localInteger.intValue();
            } else {
              i = -1;
            }
            if (i > paramInt)
            {
              localObject = SingleMedia.copy$default((SingleMedia)localObject, null, null, null, null, Integer.valueOf(i - 1), null, null, 111, null);
              b(localEntity.getId(), IdentifyComponent.copy$default(localIdentifyComponent, null, null, localObject, null, 11, null));
              break;
            }
            break;
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.SingleMedia");
        }
      }
    }
  }
  
  private final int i()
  {
    return this.d.incrementAndGet();
  }
  
  private final boolean i(int paramInt)
  {
    try
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = RenderModelHolder.a((RenderModelHolder)localObject1, paramInt, false, false, 6, null);
        if (localObject1 != null)
        {
          Object localObject2 = ((Iterable)((Entity)localObject1).getComponents()).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject1 = (IdentifyComponent)((Iterator)localObject2).next();
            if ((((IdentifyComponent)localObject1).getData() instanceof Transition))
            {
              localObject2 = ((IdentifyComponent)localObject1).getData();
              if (localObject2 != null)
              {
                if (!b(paramInt, IdentifyComponent.copy$default((IdentifyComponent)localObject1, null, null, Transition.copy$default((Transition)localObject2, null, null, null, null, null, null, "", Long.valueOf(0L), null, null, 831, null), null, 11, null))) {
                  break label157;
                }
                localObject1 = this.f;
                if (localObject1 == null) {
                  break label157;
                }
                ((IDataChangeListener)localObject1).c();
                break label157;
              }
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.Transition");
            }
          }
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label151:
      break label151;
    }
    return false;
    label157:
    return true;
  }
  
  private final boolean j(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = this.b;
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = RenderModelHolder.a((RenderModelHolder)localObject, paramInt, false, false, 6, null);
        bool1 = bool2;
        if (localObject != null)
        {
          Iterator localIterator = ((Iterable)((Entity)localObject).getComponents()).iterator();
          while (localIterator.hasNext())
          {
            localObject = localIterator.next();
            bool1 = ((IdentifyComponent)localObject).getData() instanceof SingleMedia;
            if (bool1) {
              break label91;
            }
          }
          localObject = null;
          label91:
          bool1 = bool2;
          if (localObject != null) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (IllegalStateException localIllegalStateException) {}
    return false;
  }
  
  @Nullable
  public final InputSource a(@Nullable String paramString)
  {
    RenderModelHolder localRenderModelHolder = this.b;
    if (localRenderModelHolder != null) {
      return localRenderModelHolder.a(paramString);
    }
    return null;
  }
  
  @NotNull
  public final MultiMedia a(@Nullable Integer paramInteger, @NotNull MultiMedia paramMultiMedia, @NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramMultiMedia, "originMultiMedia");
    Intrinsics.checkParameterIsNotNull(paramPainting, "backGround");
    if (paramInteger != null)
    {
      paramInteger.intValue();
      MultiMedia localMultiMedia = MultiMedia.copy$default(paramMultiMedia, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16777215, null);
      String str = b(paramPainting);
      Object localObject1 = paramPainting.backgroundFillMode;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((BackgroundFillMode)localObject1).getValue());
      } else {
        localObject1 = null;
      }
      Object localObject2 = (CharSequence)str;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localObject2 = paramPainting.backgroundColor;
      } else {
        localObject2 = "";
      }
      if (str == null) {
        str = "";
      }
      Size localSize = paramPainting.renderSize;
      paramPainting = MultiMedia.copy$default(localMultiMedia, null, null, null, null, paramPainting.fillScale, null, null, null, null, null, null, null, localSize, null, null, null, null, (String)localObject2, (Integer)localObject1, null, str, null, null, null, 15331311, null);
      localObject1 = paramPainting.size;
      if (localObject1 != null)
      {
        localObject2 = this.b;
        if (localObject2 != null) {
          ((RenderModelHolder)localObject2).a((Size)localObject1);
        }
      }
      if ((Intrinsics.areEqual(paramPainting, paramMultiMedia) ^ true))
      {
        paramMultiMedia = this.b;
        if (paramMultiMedia != null) {
          paramMultiMedia.a(paramInteger, paramPainting);
        }
      }
      return paramPainting;
    }
    return paramMultiMedia;
  }
  
  @NotNull
  public final Entity a(int paramInt, @NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = RenderModelHolder.a((RenderModelHolder)localObject, paramInt, false, false, 6, null);
      if (localObject != null)
      {
        paramEntity = a(this, paramEntity, ((Entity)localObject).getId(), 0, 4, null);
        if (paramEntity != null) {
          return paramEntity;
        }
      }
    }
    return new Entity(0, null, null, null, false, 0, 63, null);
  }
  
  @NotNull
  public final Entity a(@NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return b(this, paramEntity, 0, 2, null);
  }
  
  @NotNull
  public final Entity a(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "newTransition");
    Object localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = TransitionTrigger.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "TransitionTrigger::class.java.name");
      localObject1 = ((RenderModelHolder)localObject1).b((String)localObject2);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = (Entity)CollectionsKt.firstOrNull((List)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((Entity)localObject1).getChildren();
        int i = ((List)localObject1).size();
        if ((paramInt >= 0) && (paramInt < i))
        {
          localObject1 = (Entity)((List)localObject1).get(paramInt);
          paramInt = 0;
          paramEntity = ((Iterable)paramEntity.getComponents()).iterator();
          while (paramEntity.hasNext())
          {
            localObject2 = (IdentifyComponent)paramEntity.next();
            if (b(((Entity)localObject1).getId(), IdentifyComponent.copy$default((IdentifyComponent)localObject2, null, null, null, null, 15, null))) {
              paramInt = 1;
            }
          }
          if (paramInt != 0) {
            g();
          }
          paramEntity = this.b;
          if (paramEntity != null)
          {
            paramEntity = RenderModelHolder.a(paramEntity, ((Entity)localObject1).getId(), false, false, 6, null);
            if (paramEntity != null) {
              return paramEntity;
            }
          }
          return new Entity(0, null, null, null, false, 0, 63, null);
        }
        paramEntity = new StringBuilder();
        paramEntity.append("setTransition the index ");
        paramEntity.append(paramInt);
        paramEntity.append(" out of range");
        TavLogger.e("RenderDataManager", paramEntity.toString());
        return new Entity(0, null, null, null, false, 0, 63, null);
      }
    }
    return new Entity(0, null, null, null, false, 0, 63, null);
  }
  
  @NotNull
  public final Entity a(@NotNull Entity paramEntity, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    int i = h();
    Object localObject = Entity.copy$default(paramEntity, i, null, null, null, false, 0, 62, null);
    List localList = (List)new ArrayList();
    paramEntity = ((Iterable)paramEntity.getComponents()).iterator();
    while (paramEntity.hasNext()) {
      localList.add(IdentifyComponent.copy$default((IdentifyComponent)paramEntity.next(), Integer.valueOf(i()), Integer.valueOf(i), null, null, 12, null));
    }
    paramEntity = Entity.copy$default((Entity)localObject, 0, null, null, localList, false, 0, 55, null);
    localObject = this.b;
    if (localObject != null) {
      ((RenderModelHolder)localObject).a(paramInt1, paramEntity, paramInt2);
    }
    return paramEntity;
  }
  
  @NotNull
  public final Entity a(@NotNull Entity paramEntity, int paramInt, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    Object localObject2 = ((Iterable)paramEntity.getComponents()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if ((((IdentifyComponent)localObject1).getData() instanceof SingleMedia)) {
        break label60;
      }
    }
    Object localObject1 = null;
    label60:
    int i;
    if (localObject1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    Entity localEntity = d(paramInt);
    localObject1 = new Entity(0, null, null, null, false, 0, 63, null);
    localObject2 = localObject1;
    if (localEntity != null)
    {
      if (i != 0)
      {
        localObject2 = ((Iterable)paramEntity.getComponents()).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          IdentifyComponent localIdentifyComponent = (IdentifyComponent)((Iterator)localObject2).next();
          paramEntity = IdentifyComponent.copy$default(localIdentifyComponent, null, null, null, null, 15, null);
          if ((localIdentifyComponent.getData() instanceof SingleMedia))
          {
            paramEntity = localIdentifyComponent.getData();
            if (paramEntity != null) {
              paramEntity = IdentifyComponent.copy$default(localIdentifyComponent, null, null, SingleMedia.copy$default((SingleMedia)paramEntity, null, null, null, null, Integer.valueOf(paramInt), null, null, 111, null), null, 11, null);
            } else {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.SingleMedia");
            }
          }
          if (paramBoolean) {
            a(localEntity.getId(), paramEntity);
          } else {
            b(localEntity.getId(), paramEntity);
          }
        }
        paramEntity = this.b;
        if (paramEntity != null)
        {
          paramEntity = RenderModelHolder.a(paramEntity, localEntity.getId(), false, false, 6, null);
          if (paramEntity != null) {}
        }
        else
        {
          paramEntity = (Entity)localObject1;
        }
      }
      else
      {
        localObject1 = b(this, paramEntity, localEntity.getId(), 0, 4, null);
        paramEntity = (Entity)localObject1;
        if (paramBoolean)
        {
          g();
          paramEntity = (Entity)localObject1;
        }
      }
      localObject2 = paramEntity;
    }
    if (localEntity == null) {
      TavLogger.b("RenderDataManager", "target single media not found in current RenderModel");
    }
    return localObject2;
  }
  
  @NotNull
  public final String a()
  {
    return this.e;
  }
  
  public final void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      a(this, e(), 0, 2, null);
      i += 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    c(paramInt1, paramInt2);
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject2 = MultiMedia.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MultiMedia::class.java.name");
      localObject1 = ((RenderModelHolder)localObject1).b((String)localObject2);
      if (localObject1 != null)
      {
        localObject1 = (Entity)CollectionsKt.firstOrNull((List)localObject1);
        break label53;
      }
    }
    localObject1 = null;
    label53:
    Object localObject3 = (Iterable)RangesKt.until(0, paramInt2);
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(((IntIterator)localObject3).nextInt() + paramInt1));
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramInt1 = ((Number)((Iterator)localObject2).next()).intValue();
      if (localObject1 != null) {
        b(this, g(paramInt1), ((Entity)localObject1).getId(), 0, 4, null);
      }
    }
  }
  
  public final void a(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "component");
    if (b(paramInt, IdentifyComponent.copy$default(paramIdentifyComponent, null, null, null, null, 15, null)))
    {
      if (!f()) {
        return;
      }
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = RenderModelHolder.a((RenderModelHolder)localObject, paramInt, false, false, 6, null);
        if (localObject != null)
        {
          localObject = ((Entity)localObject).getComponents();
          if (localObject != null)
          {
            Iterator localIterator = ((Iterable)localObject).iterator();
            while (localIterator.hasNext())
            {
              localObject = (IdentifyComponent)localIterator.next();
              if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((IdentifyComponent)localObject).getData().getClass()), Reflection.getOrCreateKotlinClass(paramIdentifyComponent.getData().getClass())))
              {
                paramIdentifyComponent = this.f;
                if (paramIdentifyComponent != null) {
                  paramIdentifyComponent.a(paramInt, (IdentifyComponent)localObject);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(@NotNull IDataChangeListener paramIDataChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIDataChangeListener, "listener");
    this.f = paramIDataChangeListener;
  }
  
  public final void a(@NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
    Object localObject = paramInputSource.key;
    if (localObject == null) {
      localObject = "";
    }
    boolean bool = Intrinsics.areEqual(paramInputSource, a((String)localObject));
    localObject = this.b;
    if (localObject != null) {
      ((RenderModelHolder)localObject).a(paramInputSource);
    }
    if ((bool ^ true)) {
      g();
    }
  }
  
  public final void a(@NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramPainting, "backGround");
    Object localObject1 = this.b;
    if ((localObject1 != null) && (!((RenderModelHolder)localObject1).a(paramPainting))) {
      return;
    }
    localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = MultiMedia.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MultiMedia::class.java.name");
      localObject1 = ((RenderModelHolder)localObject1).b((String)localObject2);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      Iterator localIterator1 = ((Iterable)localObject1).iterator();
      while (localIterator1.hasNext())
      {
        Entity localEntity = (Entity)localIterator1.next();
        Iterator localIterator2 = ((Iterable)localEntity.getComponents()).iterator();
        while (localIterator2.hasNext())
        {
          IdentifyComponent localIdentifyComponent = (IdentifyComponent)localIterator2.next();
          if ((localIdentifyComponent.getData() instanceof ScreenTransform))
          {
            localObject1 = localIdentifyComponent.getData();
            if (localObject1 != null)
            {
              localObject2 = (ScreenTransform)localObject1;
              localObject1 = paramPainting.screenTransform;
              if (localObject1 == null) {
                localObject1 = localObject2;
              }
              if ((Intrinsics.areEqual(localObject2, localObject1) ^ true))
              {
                localObject1 = IdentifyComponent.copy$default(localIdentifyComponent, null, null, localObject1, null, 11, null);
                a(localEntity.getId(), (IdentifyComponent)localObject1);
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.ScreenTransform");
            }
          }
          else if ((localIdentifyComponent.getData() instanceof MultiMedia))
          {
            a(localIdentifyComponent, paramPainting);
          }
        }
      }
    }
  }
  
  public final void a(@NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    this.b = new RenderModelHolder(paramRenderModel);
    paramRenderModel = this.b;
    int i;
    if (paramRenderModel != null)
    {
      i = paramRenderModel.c();
      this.c.set(i);
    }
    paramRenderModel = this.b;
    if (paramRenderModel != null)
    {
      i = paramRenderModel.d();
      this.d.set(i);
    }
  }
  
  public final void a(@NotNull IdentifyComponent paramIdentifyComponent, @NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "identifyComponent");
    Intrinsics.checkParameterIsNotNull(paramPainting, "backGround");
    Object localObject = paramIdentifyComponent.getData();
    if (localObject != null)
    {
      localObject = (MultiMedia)localObject;
      if (!Intrinsics.areEqual(localObject, a(paramIdentifyComponent.getId(), (MultiMedia)localObject, paramPainting)))
      {
        if (!f()) {
          return;
        }
        paramIdentifyComponent = this.f;
        if (paramIdentifyComponent != null) {
          paramIdentifyComponent.c();
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.MultiMedia");
  }
  
  public final void a(@NotNull List<Timeline> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "timeLine");
    RenderModelHolder localRenderModelHolder = this.b;
    if (localRenderModelHolder != null) {
      localRenderModelHolder.a(paramList);
    }
  }
  
  public final void a(@NotNull List<ClipSource> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "clips");
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((RenderModelHolder)localObject).e();
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((List)localObject).isEmpty());
        break label48;
      }
    }
    localObject = null;
    label48:
    RenderModelHolder localRenderModelHolder = this.b;
    if (localRenderModelHolder != null) {
      localRenderModelHolder.a(paramList, paramBoolean1);
    }
    a(paramBoolean2);
    if (Intrinsics.areEqual(localObject, Boolean.valueOf(true)))
    {
      paramList = this.f;
      if (paramList != null) {
        paramList.a();
      }
      return;
    }
    paramList = this.f;
    if (paramList != null) {
      paramList.b();
    }
  }
  
  @NotNull
  public final Entity b(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return a(paramEntity, paramInt, true);
  }
  
  @NotNull
  public final List<Entity> b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      String str = TransitionTrigger.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "TransitionTrigger::class.java.name");
      localObject = ((RenderModelHolder)localObject).b(str);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (Entity)CollectionsKt.firstOrNull((List)localObject);
      if (localObject != null)
      {
        localObject = ((Entity)localObject).getChildren();
        if (localObject != null) {
          return localObject;
        }
      }
    }
    return CollectionsKt.emptyList();
  }
  
  public final void b(int paramInt)
  {
    b(paramInt, e());
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int j = Math.max(paramInt1, paramInt2);
    int k = Math.min(paramInt1, paramInt2);
    Iterator localIterator = d().iterator();
    if (localIterator.hasNext())
    {
      Entity localEntity = (Entity)localIterator.next();
      Object localObject = localEntity.getComponents().iterator();
      label322:
      label333:
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          IdentifyComponent localIdentifyComponent = (IdentifyComponent)((Iterator)localObject).next();
          if (!(localIdentifyComponent.getData() instanceof SingleMedia)) {
            break label333;
          }
          localObject = localIdentifyComponent.getData();
          if (localObject == null) {
            break label322;
          }
          SingleMedia localSingleMedia = (SingleMedia)localObject;
          localObject = new IntRange(k, j);
          Integer localInteger = localSingleMedia.index;
          int i;
          if ((localInteger != null) && (((IntRange)localObject).contains(localInteger.intValue()))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            localObject = localSingleMedia.index;
            if ((localObject != null) && (((Integer)localObject).intValue() == paramInt1)) {}
            for (localObject = SingleMedia.copy$default(localSingleMedia, null, null, null, null, Integer.valueOf(paramInt2), null, null, 111, null);; localObject = SingleMedia.copy$default(localSingleMedia, null, null, null, null, (Integer)localObject, null, null, 111, null))
            {
              break;
              localObject = null;
              if (paramInt1 < paramInt2)
              {
                localInteger = localSingleMedia.index;
                if (localInteger != null) {
                  localObject = Integer.valueOf(localInteger.intValue() - 1);
                }
              }
              else
              {
                localInteger = localSingleMedia.index;
                if (localInteger != null) {
                  localObject = Integer.valueOf(localInteger.intValue() + 1);
                }
              }
            }
            b(localEntity.getId(), IdentifyComponent.copy$default(localIdentifyComponent, null, null, localObject, null, 11, null));
            break;
          }
        }
        break;
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.SingleMedia");
      }
    }
  }
  
  public final void b(@Nullable List<? extends VoiceEnum> paramList)
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = Boolean.valueOf(((RenderModelHolder)localObject).b(paramList));
    } else {
      localObject = null;
    }
    if (Intrinsics.areEqual(localObject, Boolean.valueOf(true)))
    {
      localObject = this.f;
      if (localObject != null) {
        ((IDataChangeListener)localObject).a(paramList);
      }
    }
  }
  
  @Nullable
  public final RenderModel c()
  {
    RenderModelHolder localRenderModelHolder = this.b;
    if (localRenderModelHolder != null) {
      return localRenderModelHolder.b();
    }
    return null;
  }
  
  @NotNull
  public final Entity c(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    Object localObject = this.b;
    if (localObject != null)
    {
      String str = FilterGroup.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "FilterGroup::class.java.name");
      localObject = ((RenderModelHolder)localObject).b(str);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = (Entity)CollectionsKt.firstOrNull((List)localObject);
      if (localObject != null) {
        return b(paramEntity, ((Entity)localObject).getId(), paramInt);
      }
    }
    localObject = this.b;
    if (localObject != null) {
      return b(paramEntity, ((RenderModelHolder)localObject).a(), paramInt);
    }
    return new Entity(0, null, null, null, false, 0, 63, null);
  }
  
  public final void c(int paramInt)
  {
    Entity localEntity = d(paramInt);
    if (localEntity != null)
    {
      RenderModelHolder localRenderModelHolder = this.b;
      if (localRenderModelHolder != null) {
        localRenderModelHolder.a(localEntity.getId());
      }
    }
    h(paramInt);
  }
  
  @Nullable
  public final Entity d(int paramInt)
  {
    Iterator localIterator = ((Iterable)d()).iterator();
    Object localObject3;
    label95:
    int i;
    do
    {
      boolean bool = localIterator.hasNext();
      Object localObject4 = null;
      if (!bool) {
        break;
      }
      localObject3 = localIterator.next();
      Object localObject2 = ((Iterable)((Entity)localObject3).getComponents()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        if ((((IdentifyComponent)localObject1).getData() instanceof SingleMedia)) {
          break label95;
        }
      }
      localObject1 = null;
      localObject1 = (IdentifyComponent)localObject1;
      if (localObject1 != null) {
        localObject1 = ((IdentifyComponent)localObject1).getData();
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (!(localObject1 instanceof SingleMedia)) {
        localObject2 = null;
      }
      localObject2 = (SingleMedia)localObject2;
      localObject1 = localObject4;
      if (localObject2 != null) {
        localObject1 = ((SingleMedia)localObject2).index;
      }
      if ((localObject1 != null) && (((Integer)localObject1).intValue() == paramInt)) {
        i = 1;
      } else {
        i = 0;
      }
    } while (i == 0);
    Object localObject1 = localObject3;
    break label196;
    localObject1 = null;
    label196:
    return (Entity)localObject1;
  }
  
  @NotNull
  public final Entity d(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return f(paramEntity, paramInt);
  }
  
  @NotNull
  public final List<Entity> d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      String str = SingleMedia.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(str, "SingleMedia::class.java.name");
      localObject = ((RenderModelHolder)localObject).b(str);
      if (localObject != null) {
        return localObject;
      }
    }
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public final Entity e(int paramInt)
  {
    Object localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = TransitionTrigger.class.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "TransitionTrigger::class.java.name");
      localObject1 = ((RenderModelHolder)localObject1).b((String)localObject2);
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      localObject1 = (Entity)CollectionsKt.firstOrNull((List)localObject1);
      if (localObject1 != null)
      {
        if ((paramInt >= 0) && (paramInt < ((Entity)localObject1).getChildren().size()))
        {
          localObject1 = (Entity)((Entity)localObject1).getChildren().get(paramInt);
          localObject2 = this.b;
          if (localObject2 != null) {
            ((RenderModelHolder)localObject2).a(((Entity)localObject1).getId());
          }
          return localObject1;
        }
        return e();
      }
    }
    return e();
  }
  
  public final void f(int paramInt)
  {
    if (!i(paramInt))
    {
      if (j(paramInt)) {
        return;
      }
      RenderModelHolder localRenderModelHolder = this.b;
      if (localRenderModelHolder != null) {
        localRenderModelHolder.a(paramInt);
      }
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.dataprocessor.RenderDataManager
 * JD-Core Version:    0.7.0.1
 */