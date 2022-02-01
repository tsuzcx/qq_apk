package com.tencent.mobileqq.wink.editor;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateAction;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel.UpdateTemplateMusicAction;
import com.tencent.mobileqq.wink.editor.transition.TransitionModelExKt;
import com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager;
import com.tencent.mobileqq.wink.event.FilterSelectedEvent;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.operator.IClipSourceOperationStrategy;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.Size;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.render.ComposeRenderLayer;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate;", "()V", "cutSession", "Lcom/tencent/tavcut/session/ICutSession;", "mTemplatePath", "", "oriMediaModel", "Lcom/tencent/videocut/model/MediaModel;", "params", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "player", "Lcom/tencent/tavcut/render/player/IPlayer;", "playerViewContainer", "Landroid/widget/FrameLayout;", "renderLayerHelper", "Lcom/tencent/videocut/render/ComposeRenderLayer;", "getContainerSize", "Lcom/tencent/videocut/model/Size;", "getDuration", "", "getEditDatas", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "getMediaModel", "getMediaModels", "", "getPlayer", "getRenderLayer", "getRenderSize", "getSession", "getStickers", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "getTemplatePath", "getWinkEditData", "init", "", "hostFragment", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "isMediaChanged", "", "isMultiMedia", "isOnlyImage", "isOnlyOneImage", "onHiddenChanged", "hidden", "release", "removeSticker", "stickerModel", "removeTransition", "updateAudio", "audioModel", "Lcom/tencent/videocut/model/AudioModel;", "updateAudioVolume", "volume", "", "updateDuration", "durationUs", "updateFilter", "filterModel", "Lcom/tencent/videocut/model/FilterModel;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "updateResource", "videos", "Lcom/tencent/videocut/model/MediaClip;", "updateSticker", "updateTemplate", "action", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateAction;", "updateTemplateMusic", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateMusicAction;", "updateTransition", "updateVideoOriginalSoundVolume", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkVideoTavCut
  implements WinkTavCutDelegate
{
  public static final WinkVideoTavCut.Companion a = new WinkVideoTavCut.Companion(null);
  private FrameLayout b;
  private WinkTavCutDelegate.WinkTavCutParams c;
  private ICutSession d;
  private IPlayer e;
  private ComposeRenderLayer f;
  private String g;
  private MediaModel h;
  
  private final WinkEditData q()
  {
    WinkTavCutDelegate.WinkTavCutParams localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    return (WinkEditData)localWinkTavCutParams.c().get(0);
  }
  
  private final boolean r()
  {
    return q().getMediaModel().videos.size() > 1;
  }
  
  @NotNull
  public IPlayer a()
  {
    IPlayer localIPlayer = this.e;
    if (localIPlayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    return localIPlayer;
  }
  
  @Nullable
  public final Entity a(@NotNull WinkEditorTemplateViewModel.UpdateTemplateMusicAction paramUpdateTemplateMusicAction)
  {
    Intrinsics.checkParameterIsNotNull(paramUpdateTemplateMusicAction, "action");
    if (paramUpdateTemplateMusicAction.b() == null)
    {
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cutSession");
      }
      ((ICutSession)localObject).a(paramUpdateTemplateMusicAction.a().getId());
      paramUpdateTemplateMusicAction = this.d;
      if (paramUpdateTemplateMusicAction == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cutSession");
      }
      paramUpdateTemplateMusicAction.h();
      return null;
    }
    Object localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    localObject = ((ICutSession)localObject).d();
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      localObject = ((RenderModel)localObject).getRoot();
      i = j;
      if (localObject != null)
      {
        localObject = ((Entity)localObject).getChildren();
        i = j;
        if (localObject != null)
        {
          localObject = (Iterable)localObject;
          if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty()))
          {
            i = j;
          }
          else
          {
            localObject = ((Iterable)localObject).iterator();
            do
            {
              i = j;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (!Intrinsics.areEqual((Entity)((Iterator)localObject).next(), paramUpdateTemplateMusicAction.a()));
            i = 1;
          }
        }
      }
    }
    if (i != 0) {
      return null;
    }
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    ((ICutSession)localObject).a(paramUpdateTemplateMusicAction.a().getId());
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    localObject = ((ICutSession)localObject).a(paramUpdateTemplateMusicAction.a());
    ICutSession localICutSession = this.d;
    if (localICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    localICutSession.a(paramUpdateTemplateMusicAction.b());
    paramUpdateTemplateMusicAction = this.d;
    if (paramUpdateTemplateMusicAction == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    paramUpdateTemplateMusicAction.h();
    return localObject;
  }
  
  public void a(float paramFloat)
  {
    WinkEditData localWinkEditData = q();
    Object localObject1 = new HashMap();
    Iterator localIterator = localWinkEditData.getMediaModel().audios.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (AudioModel)((Map.Entry)localObject2).getValue();
      ((Map)localObject1).put(str, AudioModel.copy$default((AudioModel)localObject2, null, null, null, null, null, Float.valueOf(paramFloat), null, null, null, null, null, null, null, null, null, null, null, null, 262111, null));
    }
    a(null);
    localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, null, (Map)localObject1, null, null, null, null, null, null, null, null, null, null, 262015, null));
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject1).a(localWinkEditData.getMediaModel());
  }
  
  public void a(long paramLong)
  {
    q().setDurationUs(paramLong);
    WinkEditData localWinkEditData = q();
    if (localWinkEditData.getStickerModelMap() != null)
    {
      localObject2 = localWinkEditData.getStickerModelMap();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), WinkStickerModel.copyAndUpdate$default((WinkStickerModel)((Map.Entry)localObject3).getValue(), null, null, 0L, paramLong, 0, 0.0F, 0.0F, 0.0F, 0.0F, false, 0, 0, 0.0F, 0.0F, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0F, 0.0F, null, null, null, null, null, null, -9, 31, null));
      }
      localObject1 = MapsKt.toMutableMap((Map)localObject1);
    }
    else
    {
      localObject1 = (Map)new LinkedHashMap();
    }
    localWinkEditData.setStickerModelMap((Map)localObject1);
    if (localWinkEditData.getFilterModelMap() != null)
    {
      localObject2 = localWinkEditData.getFilterModelMap();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject2).size()));
      localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), FilterModel.copy$default((FilterModel)((Map.Entry)localObject3).getValue(), null, null, null, null, Long.valueOf(paramLong), null, null, 111, null));
      }
      localObject1 = MapsKt.toMutableMap((Map)localObject1);
    }
    else
    {
      localObject1 = (Map)new LinkedHashMap();
    }
    localWinkEditData.setFilterModelMap((Map)localObject1);
    Object localObject1 = localWinkEditData.getMediaModel();
    Object localObject2 = localWinkEditData.getStickerModelMap();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject3 = localWinkEditData.getFilterModelMap();
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default((MediaModel)localObject1, null, null, null, null, null, null, null, null, (Map)localObject2, null, (Map)localObject3, null, null, null, null, null, null, null, 260863, null));
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject1).a(localWinkEditData.getMediaModel());
  }
  
  public void a(@NotNull BasePartFragment paramBasePartFragment, @NotNull WinkTavCutDelegate.WinkTavCutParams paramWinkTavCutParams)
  {
    Intrinsics.checkParameterIsNotNull(paramBasePartFragment, "hostFragment");
    Intrinsics.checkParameterIsNotNull(paramWinkTavCutParams, "params");
    this.c = paramWinkTavCutParams;
    this.d = TavCut.a.b();
    this.g = paramWinkTavCutParams.d();
    paramWinkTavCutParams = TavCut.a.c(this.g);
    if (paramWinkTavCutParams != null)
    {
      ICutSession localICutSession = this.d;
      if (localICutSession == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cutSession");
      }
      localICutSession.a(paramWinkTavCutParams);
    }
    paramBasePartFragment = paramBasePartFragment.getView();
    if (paramBasePartFragment != null) {
      paramBasePartFragment = (FrameLayout)paramBasePartFragment.findViewById(2131449451);
    } else {
      paramBasePartFragment = null;
    }
    this.b = paramBasePartFragment;
    paramBasePartFragment = this.b;
    if (paramBasePartFragment != null) {
      paramBasePartFragment.setVisibility(0);
    }
    this.e = TavCut.a.a(this.b);
    paramBasePartFragment = this.e;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    paramBasePartFragment.b(true);
    paramBasePartFragment = this.e;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    paramBasePartFragment.a(true);
    paramBasePartFragment = this.d;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    paramWinkTavCutParams = this.e;
    if (paramWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    paramBasePartFragment.a(paramWinkTavCutParams);
    if (o())
    {
      paramBasePartFragment = this.d;
      if (paramBasePartFragment == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cutSession");
      }
      paramBasePartFragment.e().a((IClipSourceOperationStrategy)new WinkVideoTavCut.init.2());
    }
    paramBasePartFragment = this.d;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    this.f = new ComposeRenderLayer(paramBasePartFragment, null, null, 6, null);
    paramBasePartFragment = this.f;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramBasePartFragment.a(q().getMediaModel());
    paramBasePartFragment = this.e;
    if (paramBasePartFragment == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    paramBasePartFragment.a();
    this.h = l();
  }
  
  public void a(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkEditData localWinkEditData = q();
    if (localWinkEditData.getStickerModelMap() == null) {
      localWinkEditData.setStickerModelMap((Map)new LinkedHashMap());
    }
    Map localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.put(paramWinkStickerModel.id, paramWinkStickerModel);
    paramWinkStickerModel = localWinkEditData.getMediaModel();
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramWinkStickerModel, null, null, null, null, null, null, null, null, localMap, null, null, null, null, null, null, null, null, null, 261887, null));
    paramWinkStickerModel = this.f;
    if (paramWinkStickerModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramWinkStickerModel.a(localWinkEditData.getMediaModel());
  }
  
  public final void a(@NotNull WinkEditorTemplateViewModel.UpdateTemplateAction paramUpdateTemplateAction)
  {
    Intrinsics.checkParameterIsNotNull(paramUpdateTemplateAction, "action");
    this.g = paramUpdateTemplateAction.f();
    Object localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    ((IPlayer)localObject).b();
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    ((ICutSession)localObject).a(paramUpdateTemplateAction.a());
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    ((ICutSession)localObject).e().a((IClipSourceOperationStrategy)new WinkVideoTavCut.updateTemplate.1(this, paramUpdateTemplateAction));
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    ((ICutSession)localObject).e().b(0, paramUpdateTemplateAction.a().getClipsAssets());
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject).a(true);
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject).b(new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null));
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject).a(paramUpdateTemplateAction.c());
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    ((IPlayer)localObject).a(0L);
    localObject = this.e;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    ((IPlayer)localObject).a();
    localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject).a(paramUpdateTemplateAction.d());
    paramUpdateTemplateAction = paramUpdateTemplateAction.b();
    if (paramUpdateTemplateAction != null) {
      q().setMediaModel(paramUpdateTemplateAction);
    }
    if (this.g == null) {
      m();
    }
  }
  
  public void a(@Nullable AudioModel paramAudioModel)
  {
    WinkEditData localWinkEditData = q();
    Map localMap = (Map)new LinkedHashMap();
    if (paramAudioModel != null) {
      localMap.put(paramAudioModel.id, paramAudioModel);
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, null, localMap, null, null, null, null, null, null, null, null, null, null, 262015, null));
    paramAudioModel = this.f;
    if (paramAudioModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramAudioModel.a(localWinkEditData.getMediaModel());
  }
  
  public void a(@Nullable FilterModel paramFilterModel, @Nullable MetaMaterial paramMetaMaterial)
  {
    WinkEditData localWinkEditData = q();
    if (localWinkEditData.getFilterModelMap() == null) {
      localWinkEditData.setFilterModelMap((Map)new LinkedHashMap());
    }
    if (localWinkEditData.getFilterMaterialMap() == null) {
      localWinkEditData.setFilterMaterialMap((Map)new LinkedHashMap());
    }
    Map localMap = localWinkEditData.getFilterMaterialMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.clear();
    localMap = localWinkEditData.getFilterModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.clear();
    if (paramMetaMaterial != null)
    {
      localMap = localWinkEditData.getFilterMaterialMap();
      if (localMap == null) {
        Intrinsics.throwNpe();
      }
      String str = paramMetaMaterial.id;
      Intrinsics.checkExpressionValueIsNotNull(str, "it.id");
      localMap.put(str, paramMetaMaterial);
    }
    if (paramFilterModel != null)
    {
      paramMetaMaterial = localWinkEditData.getFilterModelMap();
      if (paramMetaMaterial == null) {
        Intrinsics.throwNpe();
      }
      paramMetaMaterial.put(paramFilterModel.id, paramFilterModel);
    }
    paramFilterModel = localWinkEditData.getMediaModel();
    paramMetaMaterial = localWinkEditData.getFilterModelMap();
    if (paramMetaMaterial == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramFilterModel, null, null, null, null, null, null, null, null, null, null, paramMetaMaterial, null, null, null, null, null, null, null, 261119, null));
    paramFilterModel = this.f;
    if (paramFilterModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramFilterModel.a(localWinkEditData.getMediaModel());
  }
  
  public final void a(@NotNull List<MediaClip> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    WinkEditData localWinkEditData = q();
    localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, paramList, null, null, null, null, null, null, null, null, null, null, null, 262079, null));
    paramList = this.f;
    if (paramList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramList.a(localWinkEditData.getMediaModel());
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(4);
      }
      localObject1 = this.e;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("player");
      }
      ((IPlayer)localObject1).b();
      return;
    }
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).setVisibility(0);
    }
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    ((IPlayer)localObject1).a(0L);
    localObject1 = this.e;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("player");
    }
    ((IPlayer)localObject1).a();
    MetaMaterial localMetaMaterial = (MetaMaterial)null;
    Object localObject2 = q().getFilterMaterialMap();
    localObject1 = localMetaMaterial;
    if (localObject2 != null)
    {
      localObject2 = ((Map)localObject2).values();
      localObject1 = localMetaMaterial;
      if (localObject2 != null)
      {
        localObject2 = (MetaMaterial)CollectionsKt.elementAtOrNull((Iterable)localObject2, 0);
        localObject1 = localMetaMaterial;
        if (localObject2 != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[onHiddenChanged] filterMaterialId=");
          ((StringBuilder)localObject1).append(((MetaMaterial)localObject2).id);
          AEQLog.a("WinkImageTavCut", ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new FilterSelectedEvent((MetaMaterial)localObject1));
  }
  
  @NotNull
  public ICutSession b()
  {
    ICutSession localICutSession = this.d;
    if (localICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    return localICutSession;
  }
  
  public void b(float paramFloat)
  {
    WinkEditData localWinkEditData = q();
    Object localObject2 = (List)new ArrayList();
    Iterator localIterator = ((Iterable)localWinkEditData.getMediaModel().videos).iterator();
    while (localIterator.hasNext())
    {
      MediaClip localMediaClip = (MediaClip)localIterator.next();
      localObject1 = localMediaClip.resource;
      if (localObject1 != null) {
        localObject1 = ResourceModel.copy$default((ResourceModel)localObject1, null, null, null, null, null, null, null, null, null, Float.valueOf(paramFloat), null, null, null, null, null, null, 65023, null);
      } else {
        localObject1 = null;
      }
      ((List)localObject2).add(MediaClip.copy$default(localMediaClip, (ResourceModel)localObject1, null, null, null, null, null, 62, null));
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, (List)localObject2, null, null, null, null, null, null, null, null, null, null, null, 262079, null));
    if (this.g != null)
    {
      localObject1 = this.d;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("cutSession");
      }
      localObject1 = ((ICutSession)localObject1).d();
      if (localObject1 != null)
      {
        localObject2 = (Iterable)((RenderModel)localObject1).getClipsAssets();
        localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(ClipSource.copy$default((ClipSource)((Iterator)localObject2).next(), null, null, null, 0L, null, Float.valueOf(paramFloat), null, null, null, null, null, null, 4063, null));
        }
        localObject1 = (List)localObject1;
        localObject2 = this.d;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("cutSession");
        }
        ((ICutSession)localObject2).e().b(0, (List)localObject1);
      }
    }
    Object localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    ((ComposeRenderLayer)localObject1).a(localWinkEditData.getMediaModel());
  }
  
  public void b(@NotNull WinkStickerModel paramWinkStickerModel)
  {
    Intrinsics.checkParameterIsNotNull(paramWinkStickerModel, "stickerModel");
    WinkEditData localWinkEditData = q();
    Map localMap = localWinkEditData.getStickerModelMap();
    int i;
    if ((localMap != null) && (!localMap.isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localMap.remove(paramWinkStickerModel.id);
    paramWinkStickerModel = localWinkEditData.getMediaModel();
    localMap = localWinkEditData.getStickerModelMap();
    if (localMap == null) {
      Intrinsics.throwNpe();
    }
    localWinkEditData.setMediaModel(MediaModel.copy$default(paramWinkStickerModel, null, null, null, null, null, null, null, null, localMap, null, null, null, null, null, null, null, null, null, 261887, null));
    paramWinkStickerModel = this.f;
    if (paramWinkStickerModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    paramWinkStickerModel.a(localWinkEditData.getMediaModel());
  }
  
  public void c()
  {
    ICutSession localICutSession = this.d;
    if (localICutSession == null) {
      Intrinsics.throwUninitializedPropertyAccessException("cutSession");
    }
    localICutSession.g();
  }
  
  @NotNull
  public List<MediaModel> d()
  {
    return CollectionsKt.mutableListOf(new MediaModel[] { q().getMediaModel() });
  }
  
  public long e()
  {
    return q().getDurationUs();
  }
  
  @Nullable
  public Map<String, WinkStickerModel> f()
  {
    return q().getStickerModelMap();
  }
  
  @NotNull
  public Size g()
  {
    WinkTavCutDelegate.WinkTavCutParams localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    int i = localWinkTavCutParams.e();
    localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    return new Size(Integer.valueOf(i), Integer.valueOf(localWinkTavCutParams.f()), null, 4, null);
  }
  
  @NotNull
  public Size h()
  {
    WinkTavCutDelegate.WinkTavCutParams localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    int i = localWinkTavCutParams.e();
    localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    return new Size(Integer.valueOf(i), Integer.valueOf(localWinkTavCutParams.f()), null, 4, null);
  }
  
  @Nullable
  public String i()
  {
    return this.g;
  }
  
  @NotNull
  public List<WinkEditData> j()
  {
    WinkTavCutDelegate.WinkTavCutParams localWinkTavCutParams = this.c;
    if (localWinkTavCutParams == null) {
      Intrinsics.throwUninitializedPropertyAccessException("params");
    }
    return localWinkTavCutParams.c();
  }
  
  public boolean k()
  {
    return Intrinsics.areEqual(this.h, l()) ^ true;
  }
  
  @NotNull
  public final MediaModel l()
  {
    return q().getMediaModel();
  }
  
  public final void m()
  {
    Object localObject;
    if (RFApplication.getApplication() != null)
    {
      localObject = RFApplication.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RFApplication.getApplication()");
      localObject = ((Context)localObject).getApplicationContext();
    }
    else
    {
      localObject = null;
    }
    if ((localObject != null) && (p()) && (r()) && (QzoneConfig.getWinkTransitionSwitch()))
    {
      TransitionModel localTransitionModel = TransitionModelExKt.a((Context)localObject);
      WinkEditData localWinkEditData = q();
      Map localMap = TransitionModelExKt.a(localWinkEditData.getMediaModel().videos, true, localTransitionModel);
      TransitionResourceManager.a().a((Context)localObject, localMap.values(), (Runnable)new WinkVideoTavCut.updateTransition..inlined.with.lambda.1(localWinkEditData, this, localTransitionModel, (Context)localObject));
      localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, null, null, null, null, null, null, localMap, null, null, null, null, null, 258047, null));
      localObject = this.f;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
      }
      ((ComposeRenderLayer)localObject).a(localWinkEditData.getMediaModel());
    }
  }
  
  public final void n()
  {
    WinkEditData localWinkEditData = q();
    localWinkEditData.setMediaModel(MediaModel.copy$default(localWinkEditData.getMediaModel(), null, null, null, null, null, null, null, null, null, null, null, null, MapsKt.emptyMap(), null, null, null, null, null, 258047, null));
    ComposeRenderLayer localComposeRenderLayer = this.f;
    if (localComposeRenderLayer == null) {
      Intrinsics.throwUninitializedPropertyAccessException("renderLayerHelper");
    }
    localComposeRenderLayer.a(localWinkEditData.getMediaModel());
  }
  
  public final boolean o()
  {
    if (l().videos.size() == 1)
    {
      Object localObject = (MediaClip)l().videos.get(0);
      if (localObject != null)
      {
        localObject = ((MediaClip)localObject).resource;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        if (((ResourceModel)localObject).type == MediaType.IMAGE) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final boolean p()
  {
    Iterator localIterator = q().getMediaModel().videos.iterator();
    while (localIterator.hasNext())
    {
      MediaClip localMediaClip = (MediaClip)localIterator.next();
      if ((localMediaClip.resource != null) && (localMediaClip.resource.type != MediaType.IMAGE)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkVideoTavCut
 * JD-Core Version:    0.7.0.1
 */