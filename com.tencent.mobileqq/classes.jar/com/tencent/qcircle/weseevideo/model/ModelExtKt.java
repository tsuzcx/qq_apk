package com.tencent.qcircle.weseevideo.model;

import com.tencent.autotemplate.TAVAutomaticTemplate;
import com.tencent.autotemplate.model.TAVEffectAutomaticEffect;
import com.tencent.autotemplate.model.TAVEffectsModel;
import com.tencent.qcircle.tavcut.bean.CropConfig;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import com.tencent.qcircle.weseevideo.model.template.MediaTemplateModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFrameModel;
import com.tencent.qcircle.weseevideo.model.template.auto.AEFramePAGItem;
import com.tencent.qcircle.weseevideo.model.template.auto.AutomaticMediaTemplateModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isAutoTemplate", "", "Lcom/tencent/qcircle/weseevideo/model/MediaModel;", "isImageMode", "isLightTemplate", "isMovieTemplate", "selectNearRatioPagFile", "", "Lcom/tencent/autotemplate/TAVAutomaticTemplate;", "templateModel", "Lcom/tencent/qcircle/weseevideo/model/template/auto/AutomaticMediaTemplateModel;", "mediaModel", "updateFrameColor", "color", "", "updateFrameFillMode", "fillMode", "libtavcut_debug"}, k=2, mv={1, 1, 16})
public final class ModelExtKt
{
  public static final boolean isAutoTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isAutoTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean isImageMode(@Nullable MediaModel paramMediaModel)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMediaModel != null)
    {
      Object localObject = paramMediaModel.getMediaResourceModel();
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((MediaResourceModel)localObject).getVideos();
        bool1 = bool2;
        if (localObject != null)
        {
          if (((List)localObject).size() != 1) {
            return false;
          }
          int i = ((MediaClipModel)paramMediaModel.getMediaResourceModel().getVideos().get(0)).getResource().getType();
          if (i != 2)
          {
            bool1 = bool2;
            if (i != 4) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final boolean isLightTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isLightTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static final boolean isMovieTemplate(@Nullable MediaModel paramMediaModel)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if ((paramMediaModel != null) && (!paramMediaModel.isMovieTemplateEmpty())) {
        return true;
      }
    }
    return false;
  }
  
  public static final void selectNearRatioPagFile(@Nullable TAVAutomaticTemplate paramTAVAutomaticTemplate, @NotNull AutomaticMediaTemplateModel paramAutomaticMediaTemplateModel, @NotNull MediaModel paramMediaModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAutomaticMediaTemplateModel, "templateModel");
    Intrinsics.checkParameterIsNotNull(paramMediaModel, "mediaModel");
    Object localObject1 = paramAutomaticMediaTemplateModel.getAEFrameModel();
    if (localObject1 != null)
    {
      localObject1 = ((AEFrameModel)localObject1).getPagItems();
      if (localObject1 != null)
      {
        i = ((ArrayList)localObject1).size();
        break label48;
      }
    }
    int i = 0;
    label48:
    if (i <= 1)
    {
      paramTAVAutomaticTemplate = paramAutomaticMediaTemplateModel.getAEFrameModel();
      if (paramTAVAutomaticTemplate != null) {
        paramTAVAutomaticTemplate.setSelectedPAGName("");
      }
      return;
    }
    float f2 = 1.0F;
    localObject1 = (MediaClipModel)CollectionsKt.firstOrNull(paramMediaModel.getMediaResourceModel().getVideos());
    float f1 = f2;
    if (localObject1 != null)
    {
      localObject1 = ((MediaClipModel)localObject1).getResource();
      f1 = f2;
      if (localObject1 != null)
      {
        paramMediaModel = paramMediaModel.getMediaEffectModel().getCropModel();
        if (paramMediaModel != null)
        {
          paramMediaModel = paramMediaModel.getCropConfig();
          if (paramMediaModel != null)
          {
            f1 = ((VideoResourceModel)localObject1).getWidth() * paramMediaModel.getWidth() / (((VideoResourceModel)localObject1).getHeight() * paramMediaModel.getHeight());
            break label173;
          }
        }
        f1 = ((VideoResourceModel)localObject1).getWidth() / ((VideoResourceModel)localObject1).getHeight();
      }
    }
    label173:
    f2 = FloatCompanionObject.INSTANCE.getMAX_VALUE();
    Object localObject2 = null;
    paramMediaModel = (AEFramePAGItem)null;
    Object localObject3 = paramAutomaticMediaTemplateModel.getAEFrameModel();
    localObject1 = paramMediaModel;
    if (localObject3 != null)
    {
      localObject3 = ((AEFrameModel)localObject3).getPagItems();
      localObject1 = paramMediaModel;
      if (localObject3 != null)
      {
        localObject3 = ((Iterable)localObject3).iterator();
        for (;;)
        {
          localObject1 = paramMediaModel;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (AEFramePAGItem)((Iterator)localObject3).next();
          float f3 = Math.abs(((AEFramePAGItem)localObject1).getVisibleRatio() - f1);
          if (f3 < f2)
          {
            paramMediaModel = (MediaModel)localObject1;
            f2 = f3;
          }
        }
      }
    }
    if (paramTAVAutomaticTemplate != null)
    {
      paramTAVAutomaticTemplate = paramTAVAutomaticTemplate.getEffectsModel();
      if (paramTAVAutomaticTemplate != null)
      {
        paramTAVAutomaticTemplate = paramTAVAutomaticTemplate.filterEffects;
        if (paramTAVAutomaticTemplate != null)
        {
          paramTAVAutomaticTemplate = (TAVEffectAutomaticEffect)CollectionsKt.firstOrNull(paramTAVAutomaticTemplate);
          if (paramTAVAutomaticTemplate != null)
          {
            paramMediaModel = paramTAVAutomaticTemplate.parameter;
            if (paramMediaModel != null)
            {
              paramTAVAutomaticTemplate = localObject2;
              if (localObject1 != null) {
                paramTAVAutomaticTemplate = ((AEFramePAGItem)localObject1).getPagName();
              }
              paramMediaModel.filePath = paramTAVAutomaticTemplate;
            }
          }
        }
      }
    }
    paramAutomaticMediaTemplateModel = paramAutomaticMediaTemplateModel.getAEFrameModel();
    if (paramAutomaticMediaTemplateModel != null)
    {
      if (localObject1 != null)
      {
        paramTAVAutomaticTemplate = ((AEFramePAGItem)localObject1).getPagName();
        if (paramTAVAutomaticTemplate != null) {}
      }
      else
      {
        paramTAVAutomaticTemplate = "";
      }
      paramAutomaticMediaTemplateModel.setSelectedPAGName(paramTAVAutomaticTemplate);
    }
  }
  
  public static final void updateFrameColor(@Nullable MediaModel paramMediaModel, int paramInt)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if (paramMediaModel != null)
      {
        paramMediaModel = paramMediaModel.getAutomaticMediaTemplateModel();
        if (paramMediaModel != null)
        {
          paramMediaModel = paramMediaModel.getAEFrameModel();
          if (paramMediaModel != null) {
            paramMediaModel.setFrameColor(paramInt);
          }
        }
      }
    }
  }
  
  public static final void updateFrameFillMode(@Nullable MediaModel paramMediaModel, int paramInt)
  {
    if (paramMediaModel != null)
    {
      paramMediaModel = paramMediaModel.getMediaTemplateModel();
      if (paramMediaModel != null)
      {
        paramMediaModel = paramMediaModel.getAutomaticMediaTemplateModel();
        if (paramMediaModel != null)
        {
          paramMediaModel = paramMediaModel.getAEFrameModel();
          if (paramMediaModel != null) {
            paramMediaModel.setImageFillMode(paramInt);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.ModelExtKt
 * JD-Core Version:    0.7.0.1
 */