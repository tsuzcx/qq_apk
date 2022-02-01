package com.tencent.tavcut.session;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import com.tencent.tavcut.composition.dataprocessor.IDataChangeListener;
import com.tencent.tavcut.composition.dataprocessor.RenderDataManager;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode.Companion;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.operator.ClipSourceOperator;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.render.IRenderChainManager;
import com.tencent.tavcut.render.RenderConfig;
import com.tencent.tavcut.render.exporter.IExporter;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/session/TavCutSession;", "Lcom/tencent/tavcut/session/ICutSession;", "Lcom/tencent/tavcut/composition/dataprocessor/IDataChangeListener;", "()V", "dataManager", "Lcom/tencent/tavcut/composition/dataprocessor/RenderDataManager;", "exporter", "Lcom/tencent/tavcut/render/exporter/IExporter;", "flushEvent", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "iClipSourceOperator", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "needReloadAsset", "", "player", "Lcom/tencent/tavcut/render/player/IPlayer;", "playerRenderChainManager", "Lcom/tencent/tavcut/render/IRenderChainManager;", "sessionListenerList", "", "Lcom/tencent/tavcut/session/ISessionListener;", "sessionOpHandler", "Landroid/os/Handler;", "sessionOpThread", "Landroid/os/HandlerThread;", "updateComponents", "", "", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "voiceConfig", "", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", "accessInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "sourceKey", "", "addBgm", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "addClipEffect", "index", "addEffect", "parentEntityId", "addInputSource", "", "inputSource", "addRenderTarget", "addSessionListener", "listener", "bindPlayer", "clearFlags", "flagReloadAsset", "flush", "flushToRender", "updatePlayer", "getClipSourceOperator", "getEditableTextByEntityId", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "entityId", "getEditableTextUnderPoint", "x", "", "y", "getEntitiesUnderPoint", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPlayer", "getRenderModel", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "getTotalDurationUs", "", "handleUpdateComponent", "originEntityId", "component", "internalFlush", "notifyRenderDataApplied", "notifyRenderDataChanged", "onComponentUpdate", "identifyComponent", "onEntityChanged", "onInitSource", "onSourceUpdate", "onVoiceChangerUpdate", "config", "queryEffectIndex", "", "entityIds", "registerFont", "fontFamily", "fontPath", "registerRenderRunnable", "release", "reloadAssets", "removeEntity", "id", "removeInputSource", "removeSessionListener", "setRenderModel", "renderModel", "setTransition", "updateBackground", "backgroundFillMode", "backColor", "pagFilePath", "updateComponent", "updateComponentsToLight", "updateEffectIndex", "updatePainting", "backGround", "Lcom/tencent/tavcut/model/Painting;", "updateRenderSize", "renderSize", "Lcom/tencent/tavcut/composition/model/component/Size;", "fillScale", "Companion", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavCutSession
  implements IDataChangeListener, ICutSession
{
  public static final TavCutSession.Companion a = new TavCutSession.Companion(null);
  private IPlayer b;
  private IExporter c;
  private IRenderChainManager d;
  private RenderDataManager e;
  private final List<ISessionListener> f = (List)new ArrayList();
  private final IClipSourceOperator g;
  private boolean h;
  private final Map<Integer, List<IdentifyComponent>> i = (Map)new LinkedHashMap();
  private final LinkedList<Runnable> j = new LinkedList();
  private final HandlerThread k = new HandlerThread("TavCutSession-thread", -8);
  private final Handler l;
  private final List<VoiceEnum> m = CollectionsKt.listOf(new VoiceEnum[] { VoiceEnum.UNCLE, VoiceEnum.LOLI, VoiceEnum.NAUGHTY_KID, VoiceEnum.HEAVY_METAL, VoiceEnum.ETHEREAL });
  
  public TavCutSession()
  {
    this.k.start();
    this.l = new Handler(this.k.getLooper(), (Handler.Callback)new TavCutSession.1(this));
    RenderConfig.a.a(0);
    this.e = new RenderDataManager();
    this.e.a((IDataChangeListener)this);
    this.g = ((IClipSourceOperator)new ClipSourceOperator(this.e));
  }
  
  private final void a(Painting paramPainting)
  {
    this.e.a(paramPainting);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      j();
      return;
    }
    IPlayer localIPlayer = this.b;
    if (localIPlayer != null) {
      localIPlayer.g();
    }
  }
  
  private final void c(int paramInt, IdentifyComponent paramIdentifyComponent)
  {
    if (this.i.get(Integer.valueOf(paramInt)) == null) {
      this.i.put(Integer.valueOf(paramInt), (List)new ArrayList());
    }
    List localList = (List)this.i.get(Integer.valueOf(paramInt));
    if (localList != null) {
      localList.add(paramIdentifyComponent);
    }
  }
  
  private final void i()
  {
    this.h = true;
  }
  
  private final void j()
  {
    RenderModel localRenderModel = this.e.c();
    if (localRenderModel != null)
    {
      IPlayer localIPlayer = this.b;
      if (localIPlayer != null) {
        localIPlayer.a(this.e.a(), localRenderModel, (Function2)new TavCutSession.updatePlayer.1(this));
      }
    }
  }
  
  private final void k()
  {
    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain()), null, null, (Function2)new TavCutSession.notifyRenderDataChanged.1(this, null), 3, null);
  }
  
  private final void l()
  {
    p();
    if (this.h)
    {
      m();
      return;
    }
    n();
  }
  
  private final void m()
  {
    IPlayer localIPlayer = this.b;
    if (localIPlayer != null) {
      localIPlayer.a((Function0)new TavCutSession.reloadAssets.1(this));
    }
  }
  
  private final void n()
  {
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    localBooleanRef.element = false;
    Iterator localIterator1 = this.i.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Iterator localIterator2 = ((Iterable)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
      {
        IdentifyComponent localIdentifyComponent = (IdentifyComponent)localIterator2.next();
        IRenderChainManager localIRenderChainManager = this.d;
        if (localIRenderChainManager != null) {
          localIRenderChainManager.a(((Number)localEntry.getKey()).intValue(), localIdentifyComponent, (Function1)new TavCutSession.updateComponentsToLight..inlined.forEach.lambda.1(localEntry, this, localBooleanRef));
        }
      }
    }
    o();
    a(localBooleanRef.element);
    k();
  }
  
  private final void o()
  {
    this.i.clear();
    this.h = false;
  }
  
  private final void p()
  {
    IRenderChainManager localIRenderChainManager = this.d;
    if (localIRenderChainManager != null) {
      localIRenderChainManager.a((Runnable)new TavCutSession.registerRenderRunnable.1(this));
    }
  }
  
  private final void q()
  {
    BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain()), null, null, (Function2)new TavCutSession.notifyRenderDataApplied.1(this, null), 3, null);
  }
  
  @Nullable
  public InputSource a(@Nullable String paramString)
  {
    return this.e.a(paramString);
  }
  
  @NotNull
  public Entity a(int paramInt, @NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.a(paramInt, paramEntity);
  }
  
  @NotNull
  public Entity a(@NotNull Entity paramEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.a(paramEntity);
  }
  
  @NotNull
  public Entity a(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.c(paramEntity, paramInt);
  }
  
  public void a()
  {
    o();
    j();
  }
  
  public void a(int paramInt)
  {
    this.e.f(paramInt);
  }
  
  public void a(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "identifyComponent");
    c(paramInt, paramIdentifyComponent);
  }
  
  public void a(int paramInt, @NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "backColor");
    Object localObject = this.e.c();
    if (localObject != null)
    {
      localObject = ((RenderModel)localObject).getPainting();
      BackgroundFillMode localBackgroundFillMode = BackgroundFillMode.Companion.fromValue(paramInt);
      if (localBackgroundFillMode == null) {
        Intrinsics.throwNpe();
      }
      if (paramString2 == null) {
        paramString2 = "";
      }
      a(Painting.copy$default((Painting)localObject, null, null, localBackgroundFillMode, paramString2, paramString1, null, null, 99, null));
    }
  }
  
  public void a(@NotNull InputSource paramInputSource)
  {
    Intrinsics.checkParameterIsNotNull(paramInputSource, "inputSource");
    this.e.a(paramInputSource);
  }
  
  public void a(@NotNull Size paramSize, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramSize, "renderSize");
    RenderModel localRenderModel = this.e.c();
    if (localRenderModel != null) {
      a(Painting.copy$default(localRenderModel.getPainting(), paramSize, null, null, null, null, Float.valueOf(paramFloat), null, 94, null));
    }
  }
  
  public void a(@NotNull IPlayer paramIPlayer)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    this.b = paramIPlayer;
  }
  
  public void a(@NotNull RenderModel paramRenderModel)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderModel, "renderModel");
    this.e.a(paramRenderModel);
    this.e.b(this.m);
  }
  
  public void a(@NotNull ISessionListener paramISessionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramISessionListener, "listener");
    List localList = this.f;
    if (!(localList.contains(paramISessionListener) ^ true)) {
      localList = null;
    }
    if (localList != null) {
      localList.add(paramISessionListener);
    }
  }
  
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "fontFamily");
    Intrinsics.checkParameterIsNotNull(paramString2, "fontPath");
    IRenderChainManager localIRenderChainManager = this.d;
    if (localIRenderChainManager != null) {
      localIRenderChainManager.a(paramString1, paramString2);
    }
  }
  
  public void a(@Nullable List<? extends VoiceEnum> paramList)
  {
    IRenderChainManager localIRenderChainManager = this.d;
    if (localIRenderChainManager != null) {
      localIRenderChainManager.a(paramList);
    }
  }
  
  @NotNull
  public Entity b(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.b(paramEntity, paramInt);
  }
  
  public void b()
  {
    i();
  }
  
  public void b(int paramInt, @NotNull IdentifyComponent paramIdentifyComponent)
  {
    Intrinsics.checkParameterIsNotNull(paramIdentifyComponent, "identifyComponent");
    this.e.a(paramInt, paramIdentifyComponent);
  }
  
  public void b(@NotNull ISessionListener paramISessionListener)
  {
    Intrinsics.checkParameterIsNotNull(paramISessionListener, "listener");
    List localList = this.f;
    if (!localList.contains(paramISessionListener)) {
      localList = null;
    }
    if (localList != null) {
      localList.remove(paramISessionListener);
    }
  }
  
  @NotNull
  public Entity c(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.a(paramEntity, paramInt);
  }
  
  public void c()
  {
    i();
  }
  
  @Nullable
  public RenderModel d()
  {
    return this.e.c();
  }
  
  @NotNull
  public Entity d(@NotNull Entity paramEntity, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramEntity, "entity");
    return this.e.d(paramEntity, paramInt);
  }
  
  @NotNull
  public IClipSourceOperator e()
  {
    return this.g;
  }
  
  @Nullable
  public IPlayer f()
  {
    return this.b;
  }
  
  public void g()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((IPlayer)localObject).f();
    }
    localObject = this.d;
    if (localObject != null) {
      ((IRenderChainManager)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((IExporter)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((IExporter)localObject).b();
    }
    this.l.removeCallbacksAndMessages(null);
    this.k.quitSafely();
  }
  
  public void h()
  {
    synchronized (this.j)
    {
      this.j.add(new TavCutSession.flush..inlined.synchronized.lambda.1(this));
      this.l.removeMessages(1);
      this.l.sendEmptyMessageDelayed(1, 5L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.session.TavCutSession
 * JD-Core Version:    0.7.0.1
 */