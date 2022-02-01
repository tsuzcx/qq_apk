package com.tencent.mobileqq.wink.editor.template;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.LightAssetModel;
import com.tencent.tavcut.model.LightAssetModel.MaterialConfig;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "()V", "_templateMusicEntityLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "_updateTemplateActionLiveData", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateAction;", "_updateTemplateMusicActionLiveData", "Lcom/tencent/mobileqq/wink/editor/template/WinkEditorTemplateViewModel$UpdateTemplateMusicAction;", "<set-?>", "", "isUseTemplate", "()Z", "", "materialId", "getMaterialId", "()Ljava/lang/String;", "templateClips", "Ljava/util/ArrayList;", "Lcom/tencent/tavcut/model/ClipSource;", "templateFilePath", "templateMusicEntityLiveData", "Landroidx/lifecycle/LiveData;", "getTemplateMusicEntityLiveData", "()Landroidx/lifecycle/LiveData;", "templateMusicInputSource", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "updateTemplateActionLiveData", "getUpdateTemplateActionLiveData", "updateTemplateMusicActionLiveData", "getUpdateTemplateMusicActionLiveData", "getAudioInputSource", "Lcom/tencent/tavcut/composition/model/component/AudioSource;", "entity", "getLogTag", "getTemplateClips", "", "removeTemplateMusic", "", "restoreTemplateMusic", "updateMusicEntity", "updateTemplate", "mediaModel", "Lcom/tencent/videocut/model/MediaModel;", "material", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "isOriginalVolumeChangedManually", "updateTemplateClip", "mediaClips", "Lcom/tencent/videocut/model/MediaClip;", "updateTemplateVolume", "volume", "", "UpdateTemplateAction", "UpdateTemplateMusicAction", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorTemplateViewModel
  extends BaseViewModel
{
  private final MutableLiveData<WinkEditorTemplateViewModel.UpdateTemplateAction> a = new MutableLiveData();
  private final MutableLiveData<WinkEditorTemplateViewModel.UpdateTemplateMusicAction> b = new MutableLiveData();
  private MutableLiveData<Entity> c = new MutableLiveData();
  @Nullable
  private String d = "";
  private String e;
  private final ArrayList<ClipSource> f = new ArrayList();
  private InputSource g;
  private boolean h;
  
  private final Entity a(Entity paramEntity, float paramFloat)
  {
    List localList = (List)new ArrayList();
    Iterator localIterator = paramEntity.getComponents().iterator();
    while (localIterator.hasNext())
    {
      IdentifyComponent localIdentifyComponent = (IdentifyComponent)localIterator.next();
      if ((localIdentifyComponent.getData() instanceof AudioSource))
      {
        Object localObject = localIdentifyComponent.getData();
        if (localObject != null) {
          localList.add(IdentifyComponent.copy$default(localIdentifyComponent, null, null, AudioSource.copy$default((AudioSource)localObject, null, null, null, null, null, null, null, Float.valueOf(paramFloat), null, null, null, null, 3967, null), null, 11, null));
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.AudioSource");
        }
      }
      else
      {
        localList.add(localIdentifyComponent);
      }
    }
    return Entity.copy$default(paramEntity, 0, null, null, localList, false, 0, 55, null);
  }
  
  private final AudioSource b(Entity paramEntity)
  {
    AudioSource localAudioSource = (AudioSource)null;
    paramEntity = paramEntity.getComponents().iterator();
    while (paramEntity.hasNext())
    {
      IdentifyComponent localIdentifyComponent = (IdentifyComponent)paramEntity.next();
      if ((localIdentifyComponent.getData() instanceof AudioSource))
      {
        paramEntity = localIdentifyComponent.getData();
        if (paramEntity != null) {
          return (AudioSource)paramEntity;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.AudioSource");
      }
    }
    return localAudioSource;
  }
  
  @NotNull
  public String a()
  {
    return "WinkTemplateViewModel";
  }
  
  public final void a(float paramFloat)
  {
    Entity localEntity = (Entity)this.c.getValue();
    if (localEntity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localEntity, "_templateMusicEntityLiveData.value ?: return");
      localEntity = a(localEntity, paramFloat);
      InputSource localInputSource = this.g;
      if (localInputSource != null) {
        this.b.postValue(new WinkEditorTemplateViewModel.UpdateTemplateMusicAction(localEntity, localInputSource));
      }
    }
  }
  
  public final void a(@Nullable Entity paramEntity)
  {
    if ((paramEntity != null) && ((Intrinsics.areEqual((Entity)this.c.getValue(), paramEntity) ^ true))) {
      this.c.setValue(paramEntity);
    }
  }
  
  public final void a(@NotNull MediaModel paramMediaModel, @Nullable MetaMaterial paramMetaMaterial, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    if (paramMetaMaterial == null)
    {
      this.d = "";
      this.e = ((String)null);
    }
    else
    {
      this.d = paramMetaMaterial.id;
      this.e = WinkEditorResourceManager.c().g(paramMetaMaterial);
    }
    Object localObject2 = TavCut.a.c(this.e);
    Object localObject1 = MediaClipExtensionKt.a(paramMediaModel.videos);
    paramMetaMaterial = (MetaMaterial)localObject1;
    Object localObject3;
    if (this.e != null)
    {
      paramMetaMaterial = TavCut.a;
      localObject3 = this.e;
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      paramMetaMaterial = paramMetaMaterial.b((String)localObject3);
      if (paramMetaMaterial == null) {
        Intrinsics.throwNpe();
      }
      paramMetaMaterial = paramMetaMaterial.materialConfig;
      if (paramMetaMaterial == null) {
        Intrinsics.throwNpe();
      }
      int i = paramMetaMaterial.maxAssetCount;
      paramMetaMaterial = (MetaMaterial)localObject1;
      if (((List)localObject1).size() > i) {
        paramMetaMaterial = ((List)localObject1).subList(0, i);
      }
    }
    localObject1 = (List)new ArrayList();
    if (this.e != null)
    {
      paramMetaMaterial = paramMetaMaterial.iterator();
      while (paramMetaMaterial.hasNext()) {
        ((List)localObject1).add(MediaClipExtensionKt.a((ClipSource)paramMetaMaterial.next(), 0.0F));
      }
      if (localObject2 != null)
      {
        paramMetaMaterial = RenderModel.copy$default((RenderModel)localObject2, null, null, null, null, (List)localObject1, false, 0, null, null, null, 0L, 0, null, 8175, null);
        break label277;
      }
    }
    else if (localObject2 != null)
    {
      paramMetaMaterial = RenderModel.copy$default((RenderModel)localObject2, null, null, null, null, paramMetaMaterial, false, 0, null, null, null, 0L, 0, null, 8175, null);
      break label277;
    }
    paramMetaMaterial = null;
    label277:
    paramMetaMaterial = TavCut.a.b(paramMetaMaterial);
    if (paramMetaMaterial == null) {
      return;
    }
    localObject1 = MediaModel.copy$default(paramMediaModel, null, null, null, null, null, null, null, (Map)new HashMap(), null, null, null, null, null, null, null, null, null, null, 262015, null);
    localObject2 = (List)new ArrayList();
    if ((this.e != null) && (!paramBoolean)) {
      localObject3 = ((MediaModel)localObject1).videos.iterator();
    }
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (MediaClip)((Iterator)localObject3).next();
      paramMediaModel = ((MediaClip)localObject4).resource;
      if (paramMediaModel != null) {
        paramMediaModel = ResourceModel.copy$default(paramMediaModel, null, null, null, null, null, null, null, null, null, Float.valueOf(0.15F), null, null, null, null, null, null, 65023, null);
      } else {
        paramMediaModel = null;
      }
      ((List)localObject2).add(MediaClip.copy$default((MediaClip)localObject4, paramMediaModel, null, null, null, null, null, 62, null));
      continue;
      ((List)localObject2).addAll((Collection)((MediaModel)localObject1).videos);
    }
    localObject2 = MediaModel.copy$default((MediaModel)localObject1, null, null, null, null, null, null, (List)localObject2, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
    if (this.e != null)
    {
      paramMediaModel = paramMetaMaterial.getRoot();
      if (paramMediaModel != null)
      {
        localObject3 = paramMediaModel.getChildren();
        if (localObject3 != null)
        {
          paramMediaModel = ((List)localObject3).iterator();
          while (paramMediaModel.hasNext())
          {
            localObject4 = (Entity)paramMediaModel.next();
            if (Intrinsics.areEqual(((Entity)localObject4).getName(), "背景音乐"))
            {
              this.c.postValue(localObject4);
              paramMediaModel = b((Entity)localObject4);
              if (paramMediaModel != null)
              {
                paramMediaModel = paramMediaModel.src;
                if (paramMediaModel != null) {
                  break label604;
                }
              }
            }
          }
          paramMediaModel = "";
          label604:
          ((Collection)localObject3).isEmpty();
          if (paramMetaMaterial.getInputSources().containsKey(paramMediaModel)) {
            this.g = ((InputSource)paramMetaMaterial.getInputSources().get(paramMediaModel));
          }
        }
      }
      this.h = true;
      paramBoolean = false;
    }
    else
    {
      this.c.postValue(null);
      this.h = false;
      paramBoolean = true;
    }
    this.f.clear();
    this.f.addAll((Collection)paramMetaMaterial.getClipsAssets());
    this.a.postValue(new WinkEditorTemplateViewModel.UpdateTemplateAction(paramMetaMaterial, (MediaModel)localObject1, (MediaModel)localObject2, paramBoolean, true, this.e));
  }
  
  public final void a(@NotNull MediaModel paramMediaModel, @NotNull List<MediaClip> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    Intrinsics.checkParameterIsNotNull(paramList, "mediaClips");
    List localList = (List)new ArrayList();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MediaClip localMediaClip = (MediaClip)((Iterator)localObject).next();
      paramList = localMediaClip.resource;
      if (paramList != null) {
        paramList = ResourceModel.copy$default(paramList, null, null, null, null, null, null, null, null, null, Float.valueOf(0.0F), null, null, null, null, null, null, 65023, null);
      } else {
        paramList = null;
      }
      localList.add(MediaClip.copy$default(localMediaClip, paramList, null, null, null, null, null, 62, null));
    }
    localObject = TavCut.a.c(this.e);
    if (localObject == null) {
      return;
    }
    paramList = MediaClipExtensionKt.a(localList);
    localObject = RenderModel.copy$default((RenderModel)localObject, null, null, null, null, paramList, false, 0, null, null, null, 0L, 0, null, 8175, null);
    paramMediaModel = MediaModel.copy$default(paramMediaModel, null, null, null, null, null, null, localList, null, null, null, null, null, null, null, null, null, null, null, 262079, null);
    this.f.clear();
    this.f.addAll((Collection)paramList);
    this.a.postValue(new WinkEditorTemplateViewModel.UpdateTemplateAction((RenderModel)localObject, null, paramMediaModel, false, false, this.e));
  }
  
  @NotNull
  public final LiveData<WinkEditorTemplateViewModel.UpdateTemplateAction> b()
  {
    return (LiveData)this.a;
  }
  
  @NotNull
  public final LiveData<WinkEditorTemplateViewModel.UpdateTemplateMusicAction> c()
  {
    return (LiveData)this.b;
  }
  
  @NotNull
  public final LiveData<Entity> d()
  {
    return (LiveData)this.c;
  }
  
  @Nullable
  public final String e()
  {
    return this.d;
  }
  
  public final boolean f()
  {
    return this.h;
  }
  
  public final void g()
  {
    Entity localEntity = (Entity)this.c.getValue();
    if (localEntity != null)
    {
      MutableLiveData localMutableLiveData = this.b;
      Intrinsics.checkExpressionValueIsNotNull(localEntity, "it");
      localMutableLiveData.postValue(new WinkEditorTemplateViewModel.UpdateTemplateMusicAction(localEntity, null));
    }
  }
  
  public final void h()
  {
    Entity localEntity = (Entity)this.c.getValue();
    if (localEntity != null)
    {
      MutableLiveData localMutableLiveData = this.b;
      Intrinsics.checkExpressionValueIsNotNull(localEntity, "it");
      localMutableLiveData.postValue(new WinkEditorTemplateViewModel.UpdateTemplateMusicAction(localEntity, this.g));
    }
  }
  
  @NotNull
  public final List<ClipSource> i()
  {
    return (List)this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel
 * JD-Core Version:    0.7.0.1
 */