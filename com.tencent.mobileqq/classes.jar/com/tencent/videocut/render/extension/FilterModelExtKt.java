package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.videocut.model.ColorFilterModel;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.render.RenderData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isAvailableFilter", "", "Lcom/tencent/videocut/model/FilterModel;", "toColorRenderData", "Lcom/tencent/videocut/render/RenderData;", "isVideoTrackFilter", "toLutRenderData", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class FilterModelExtKt
{
  @NotNull
  public static final RenderData a(@NotNull FilterModel paramFilterModel, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "$this$toLutRenderData");
    IEntityCreator localIEntityCreator = TavCut.a.d();
    String str;
    if (paramBoolean) {
      str = "videoTrackLutFilter";
    } else {
      str = "lutFilter";
    }
    LutFilterModel localLutFilterModel = paramFilterModel.lut;
    if (localLutFilterModel != null)
    {
      IComponentCreator localIComponentCreator = TavCut.a.e();
      InputSource localInputSource = TavCut.a.f().b(localLutFilterModel.filePath, paramFilterModel.id);
      List localList = (List)new ArrayList();
      localList.add(new IdentifyComponent(localIComponentCreator.a()));
      if (!paramBoolean) {
        localList.add(new IdentifyComponent(localIComponentCreator.a(paramFilterModel.startTimeUs, paramFilterModel.durationUs)));
      }
      paramFilterModel = localInputSource.key;
      if (paramFilterModel == null) {
        paramFilterModel = "";
      }
      localList.add(new IdentifyComponent(localIComponentCreator.a(paramFilterModel, localLutFilterModel.intensity)));
      localList.add(new IdentifyComponent(localIComponentCreator.a("lutFilter")));
      return new RenderData(localIEntityCreator.a(str, localList), localInputSource, null, 4, null);
    }
    return new RenderData(localIEntityCreator.a(str, CollectionsKt.emptyList()), new InputSource(null, null, null, null, null, null, null, null, null, null, 1023, null), null, 4, null);
  }
  
  @NotNull
  public static final RenderData b(@NotNull FilterModel paramFilterModel, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterModel, "$this$toColorRenderData");
    IEntityCreator localIEntityCreator = TavCut.a.d();
    String str;
    if (paramBoolean) {
      str = "videoTrackColorFilter";
    } else {
      str = "colorFilter";
    }
    ColorFilterModel localColorFilterModel = paramFilterModel.color;
    if (localColorFilterModel != null)
    {
      IComponentCreator localIComponentCreator = TavCut.a.e();
      List localList = (List)new ArrayList();
      localList.add(new IdentifyComponent(localIComponentCreator.a()));
      if (!paramBoolean) {
        localList.add(new IdentifyComponent(localIComponentCreator.a(paramFilterModel.startTimeUs, paramFilterModel.durationUs)));
      }
      localList.add(new IdentifyComponent(localIComponentCreator.a(localColorFilterModel.sharpness, localColorFilterModel.brightness, localColorFilterModel.contrast, localColorFilterModel.hue, localColorFilterModel.highlights, localColorFilterModel.shadows, localColorFilterModel.saturation, localColorFilterModel.temperature)));
      localList.add(new IdentifyComponent(localIComponentCreator.a("colorFilter")));
      return new RenderData(localIEntityCreator.a(str, localList), new InputSource(paramFilterModel.id, null, null, null, null, null, null, null, null, null, 1022, null), null, 4, null);
    }
    return new RenderData(localIEntityCreator.a(str, CollectionsKt.emptyList()), new InputSource(null, null, null, null, null, null, null, null, null, null, 1023, null), null, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.FilterModelExtKt
 * JD-Core Version:    0.7.0.1
 */