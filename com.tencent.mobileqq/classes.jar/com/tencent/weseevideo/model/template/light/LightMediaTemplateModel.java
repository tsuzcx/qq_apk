package com.tencent.weseevideo.model.template.light;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.weishi.module.publisher.entity.TemplateBean;
import com.tencent.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.weseevideo.model.template.movie.MovieSegmentModel;
import com.tencent.weseevideo.model.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.ClipPlaceHolder;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/light/LightMediaTemplateModel;", "", "filePath", "", "templateId", "templateType", "templateCateId", "clipPlaceHolders", "", "Lorg/light/ClipPlaceHolder;", "segmentModels", "", "Lcom/tencent/weseevideo/model/template/movie/MovieSegmentModel;", "segmentInfo", "maxDuration", "Lcom/tencent/tav/coremedia/CMTime;", "minDuration", "lightStickerTextModels", "", "Lcom/tencent/weseevideo/model/template/light/LightStickerTextModel;", "aiAbilityModel", "Lcom/tencent/weseevideo/model/template/movie/AIAbilityModel;", "templateBean", "Lcom/tencent/weishi/module/publisher/entity/TemplateBean;", "backgroundEffectPath", "renderSize", "Lcom/tencent/tav/coremedia/CGSize;", "isRedTemplate", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/tencent/tav/coremedia/CMTime;Lcom/tencent/tav/coremedia/CMTime;Ljava/util/Map;Lcom/tencent/weseevideo/model/template/movie/AIAbilityModel;Lcom/tencent/weishi/module/publisher/entity/TemplateBean;Ljava/lang/String;Lcom/tencent/tav/coremedia/CGSize;Z)V", "getAiAbilityModel", "()Lcom/tencent/weseevideo/model/template/movie/AIAbilityModel;", "setAiAbilityModel", "(Lcom/tencent/weseevideo/model/template/movie/AIAbilityModel;)V", "getBackgroundEffectPath", "()Ljava/lang/String;", "setBackgroundEffectPath", "(Ljava/lang/String;)V", "getClipPlaceHolders", "()Ljava/util/List;", "setClipPlaceHolders", "(Ljava/util/List;)V", "getFilePath", "setFilePath", "()Z", "setRedTemplate", "(Z)V", "isSwitchByUser", "setSwitchByUser", "getLightStickerTextModels", "()Ljava/util/Map;", "getMaxDuration", "()Lcom/tencent/tav/coremedia/CMTime;", "setMaxDuration", "(Lcom/tencent/tav/coremedia/CMTime;)V", "getMinDuration", "setMinDuration", "getRenderSize", "()Lcom/tencent/tav/coremedia/CGSize;", "setRenderSize", "(Lcom/tencent/tav/coremedia/CGSize;)V", "getSegmentInfo", "setSegmentInfo", "getSegmentModels", "setSegmentModels", "getTemplateBean", "()Lcom/tencent/weishi/module/publisher/entity/TemplateBean;", "setTemplateBean", "(Lcom/tencent/weishi/module/publisher/entity/TemplateBean;)V", "getTemplateCateId", "setTemplateCateId", "getTemplateId", "setTemplateId", "getTemplateType", "setTemplateType", "clearSegmentModels", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "deepCopy", "equals", "other", "hashCode", "", "isEmpty", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightMediaTemplateModel
{
  @Nullable
  private AIAbilityModel aiAbilityModel;
  @Nullable
  private String backgroundEffectPath;
  @Nullable
  private List<? extends ClipPlaceHolder> clipPlaceHolders;
  @Nullable
  private String filePath;
  private boolean isRedTemplate;
  private transient boolean isSwitchByUser;
  @NotNull
  private final Map<String, LightStickerTextModel> lightStickerTextModels;
  @Nullable
  private CMTime maxDuration;
  @Nullable
  private CMTime minDuration;
  @Nullable
  private CGSize renderSize;
  @Nullable
  private String segmentInfo;
  @Nullable
  private List<MovieSegmentModel> segmentModels;
  @Nullable
  private TemplateBean templateBean;
  @Nullable
  private String templateCateId;
  @Nullable
  private String templateId;
  @Nullable
  private String templateType;
  
  public LightMediaTemplateModel()
  {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 32767, null);
  }
  
  public LightMediaTemplateModel(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable List<? extends ClipPlaceHolder> paramList, @Nullable List<MovieSegmentModel> paramList1, @Nullable String paramString5, @Nullable CMTime paramCMTime1, @Nullable CMTime paramCMTime2, @NotNull Map<String, LightStickerTextModel> paramMap, @Nullable AIAbilityModel paramAIAbilityModel, @Nullable TemplateBean paramTemplateBean, @Nullable String paramString6, @Nullable CGSize paramCGSize, boolean paramBoolean)
  {
    this.filePath = paramString1;
    this.templateId = paramString2;
    this.templateType = paramString3;
    this.templateCateId = paramString4;
    this.clipPlaceHolders = paramList;
    this.segmentModels = paramList1;
    this.segmentInfo = paramString5;
    this.maxDuration = paramCMTime1;
    this.minDuration = paramCMTime2;
    this.lightStickerTextModels = paramMap;
    this.aiAbilityModel = paramAIAbilityModel;
    this.templateBean = paramTemplateBean;
    this.backgroundEffectPath = paramString6;
    this.renderSize = paramCGSize;
    this.isRedTemplate = paramBoolean;
  }
  
  public final void clearSegmentModels()
  {
    List localList = this.segmentModels;
    if (localList != null) {
      localList.clear();
    }
  }
  
  @Nullable
  public final String component1()
  {
    return this.filePath;
  }
  
  @NotNull
  public final Map<String, LightStickerTextModel> component10()
  {
    return this.lightStickerTextModels;
  }
  
  @Nullable
  public final AIAbilityModel component11()
  {
    return this.aiAbilityModel;
  }
  
  @Nullable
  public final TemplateBean component12()
  {
    return this.templateBean;
  }
  
  @Nullable
  public final String component13()
  {
    return this.backgroundEffectPath;
  }
  
  @Nullable
  public final CGSize component14()
  {
    return this.renderSize;
  }
  
  public final boolean component15()
  {
    return this.isRedTemplate;
  }
  
  @Nullable
  public final String component2()
  {
    return this.templateId;
  }
  
  @Nullable
  public final String component3()
  {
    return this.templateType;
  }
  
  @Nullable
  public final String component4()
  {
    return this.templateCateId;
  }
  
  @Nullable
  public final List<ClipPlaceHolder> component5()
  {
    return this.clipPlaceHolders;
  }
  
  @Nullable
  public final List<MovieSegmentModel> component6()
  {
    return this.segmentModels;
  }
  
  @Nullable
  public final String component7()
  {
    return this.segmentInfo;
  }
  
  @Nullable
  public final CMTime component8()
  {
    return this.maxDuration;
  }
  
  @Nullable
  public final CMTime component9()
  {
    return this.minDuration;
  }
  
  @NotNull
  public final LightMediaTemplateModel copy(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable List<? extends ClipPlaceHolder> paramList, @Nullable List<MovieSegmentModel> paramList1, @Nullable String paramString5, @Nullable CMTime paramCMTime1, @Nullable CMTime paramCMTime2, @NotNull Map<String, LightStickerTextModel> paramMap, @Nullable AIAbilityModel paramAIAbilityModel, @Nullable TemplateBean paramTemplateBean, @Nullable String paramString6, @Nullable CGSize paramCGSize, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "lightStickerTextModels");
    return new LightMediaTemplateModel(paramString1, paramString2, paramString3, paramString4, paramList, paramList1, paramString5, paramCMTime1, paramCMTime2, paramMap, paramAIAbilityModel, paramTemplateBean, paramString6, paramCGSize, paramBoolean);
  }
  
  @NotNull
  public final LightMediaTemplateModel deepCopy()
  {
    Object localObject1 = this.maxDuration;
    if (localObject1 != null)
    {
      localObject1 = ((CMTime)localObject1).clone();
      localObject2 = this.minDuration;
      if (localObject2 == null) {
        break label108;
      }
    }
    Object localObject4;
    label108:
    for (Object localObject2 = ((CMTime)localObject2).clone();; localObject2 = null)
    {
      localObject3 = this.segmentModels;
      if (localObject3 == null) {
        break label233;
      }
      localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(((MovieSegmentModel)((Iterator)localObject4).next()).clone());
      }
      localObject1 = null;
      break;
    }
    Object localObject5;
    Object localObject6;
    label233:
    for (Object localObject3 = CollectionsKt.toMutableList((Collection)localObject3);; localObject3 = null)
    {
      localObject4 = this;
      localObject5 = localObject1;
      localObject6 = localObject2;
      localObject1 = this.clipPlaceHolders;
      if (localObject1 == null) {
        break label346;
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject7 = (ClipPlaceHolder)((Iterator)localObject2).next();
        ((Collection)localObject1).add(new ClipPlaceHolder(((ClipPlaceHolder)localObject7).contentDuration, ((ClipPlaceHolder)localObject7).fillMode, ((ClipPlaceHolder)localObject7).width, ((ClipPlaceHolder)localObject7).height, ((ClipPlaceHolder)localObject7).volume));
      }
    }
    label346:
    for (localObject1 = (List)localObject1;; localObject1 = null)
    {
      localObject7 = this.lightStickerTextModels;
      localObject2 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject7).size()));
      localObject7 = ((Iterable)((Map)localObject7).entrySet()).iterator();
      while (((Iterator)localObject7).hasNext())
      {
        Object localObject8 = ((Iterator)localObject7).next();
        ((Map)localObject2).put(((Map.Entry)localObject8).getKey(), LightStickerTextModel.copy$default((LightStickerTextModel)((Map.Entry)localObject8).getValue(), null, 0, 3, null));
      }
    }
    Object localObject7 = MapsKt.toMutableMap((Map)localObject2);
    localObject2 = this.templateBean;
    if (localObject2 != null) {}
    for (localObject2 = ((TemplateBean)localObject2).clone();; localObject2 = null) {
      return copy$default((LightMediaTemplateModel)localObject4, null, null, null, null, (List)localObject1, (List)localObject3, null, localObject5, localObject6, (Map)localObject7, null, (TemplateBean)localObject2, null, null, false, 29775, null);
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof LightMediaTemplateModel))
      {
        paramObject = (LightMediaTemplateModel)paramObject;
        if ((!Intrinsics.areEqual(this.filePath, paramObject.filePath)) || (!Intrinsics.areEqual(this.templateId, paramObject.templateId)) || (!Intrinsics.areEqual(this.templateType, paramObject.templateType)) || (!Intrinsics.areEqual(this.templateCateId, paramObject.templateCateId)) || (!Intrinsics.areEqual(this.clipPlaceHolders, paramObject.clipPlaceHolders)) || (!Intrinsics.areEqual(this.segmentModels, paramObject.segmentModels)) || (!Intrinsics.areEqual(this.segmentInfo, paramObject.segmentInfo)) || (!Intrinsics.areEqual(this.maxDuration, paramObject.maxDuration)) || (!Intrinsics.areEqual(this.minDuration, paramObject.minDuration)) || (!Intrinsics.areEqual(this.lightStickerTextModels, paramObject.lightStickerTextModels)) || (!Intrinsics.areEqual(this.aiAbilityModel, paramObject.aiAbilityModel)) || (!Intrinsics.areEqual(this.templateBean, paramObject.templateBean)) || (!Intrinsics.areEqual(this.backgroundEffectPath, paramObject.backgroundEffectPath)) || (!Intrinsics.areEqual(this.renderSize, paramObject.renderSize)) || (this.isRedTemplate != paramObject.isRedTemplate)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final AIAbilityModel getAiAbilityModel()
  {
    return this.aiAbilityModel;
  }
  
  @Nullable
  public final String getBackgroundEffectPath()
  {
    return this.backgroundEffectPath;
  }
  
  @Nullable
  public final List<ClipPlaceHolder> getClipPlaceHolders()
  {
    return this.clipPlaceHolders;
  }
  
  @Nullable
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  @NotNull
  public final Map<String, LightStickerTextModel> getLightStickerTextModels()
  {
    return this.lightStickerTextModels;
  }
  
  @Nullable
  public final CMTime getMaxDuration()
  {
    return this.maxDuration;
  }
  
  @Nullable
  public final CMTime getMinDuration()
  {
    return this.minDuration;
  }
  
  @Nullable
  public final CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  @Nullable
  public final String getSegmentInfo()
  {
    return this.segmentInfo;
  }
  
  @Nullable
  public final List<MovieSegmentModel> getSegmentModels()
  {
    return this.segmentModels;
  }
  
  @Nullable
  public final TemplateBean getTemplateBean()
  {
    return this.templateBean;
  }
  
  @Nullable
  public final String getTemplateCateId()
  {
    return this.templateCateId;
  }
  
  @Nullable
  public final String getTemplateId()
  {
    return this.templateId;
  }
  
  @Nullable
  public final String getTemplateType()
  {
    return this.templateType;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isEmpty()
  {
    return (TextUtils.isEmpty((CharSequence)this.filePath)) || (!FileUtils.exists(this.filePath));
  }
  
  public final boolean isRedTemplate()
  {
    return this.isRedTemplate;
  }
  
  public final boolean isSwitchByUser()
  {
    return this.isSwitchByUser;
  }
  
  public final void setAiAbilityModel(@Nullable AIAbilityModel paramAIAbilityModel)
  {
    this.aiAbilityModel = paramAIAbilityModel;
  }
  
  public final void setBackgroundEffectPath(@Nullable String paramString)
  {
    this.backgroundEffectPath = paramString;
  }
  
  public final void setClipPlaceHolders(@Nullable List<? extends ClipPlaceHolder> paramList)
  {
    this.clipPlaceHolders = paramList;
  }
  
  public final void setFilePath(@Nullable String paramString)
  {
    this.filePath = paramString;
  }
  
  public final void setMaxDuration(@Nullable CMTime paramCMTime)
  {
    this.maxDuration = paramCMTime;
  }
  
  public final void setMinDuration(@Nullable CMTime paramCMTime)
  {
    this.minDuration = paramCMTime;
  }
  
  public final void setRedTemplate(boolean paramBoolean)
  {
    this.isRedTemplate = paramBoolean;
  }
  
  public final void setRenderSize(@Nullable CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public final void setSegmentInfo(@Nullable String paramString)
  {
    this.segmentInfo = paramString;
  }
  
  public final void setSegmentModels(@Nullable List<MovieSegmentModel> paramList)
  {
    this.segmentModels = paramList;
  }
  
  public final void setSwitchByUser(boolean paramBoolean)
  {
    this.isSwitchByUser = paramBoolean;
  }
  
  public final void setTemplateBean(@Nullable TemplateBean paramTemplateBean)
  {
    this.templateBean = paramTemplateBean;
  }
  
  public final void setTemplateCateId(@Nullable String paramString)
  {
    this.templateCateId = paramString;
  }
  
  public final void setTemplateId(@Nullable String paramString)
  {
    this.templateId = paramString;
  }
  
  public final void setTemplateType(@Nullable String paramString)
  {
    this.templateType = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return "LightMediaTemplateModel(filePath=" + this.filePath + ", templateId=" + this.templateId + ", templateType=" + this.templateType + ", templateCateId=" + this.templateCateId + ", clipPlaceHolders=" + this.clipPlaceHolders + ", segmentModels=" + this.segmentModels + ", segmentInfo=" + this.segmentInfo + ", maxDuration=" + this.maxDuration + ", minDuration=" + this.minDuration + ", lightStickerTextModels=" + this.lightStickerTextModels + ", aiAbilityModel=" + this.aiAbilityModel + ", templateBean=" + this.templateBean + ", backgroundEffectPath=" + this.backgroundEffectPath + ", renderSize=" + this.renderSize + ", isRedTemplate=" + this.isRedTemplate + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightMediaTemplateModel
 * JD-Core Version:    0.7.0.1
 */