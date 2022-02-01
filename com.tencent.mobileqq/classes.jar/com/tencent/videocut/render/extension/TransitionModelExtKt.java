package com.tencent.videocut.render.extension;

import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.creator.IComponentCreator;
import com.tencent.tavcut.creator.IEntityCreator;
import com.tencent.tavcut.creator.IInputSourceCreator;
import com.tencent.tavcut.model.ImageLayerData;
import com.tencent.tavcut.model.LayerMarkData;
import com.tencent.tavcut.model.PagEffectData;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.videocut.model.TransitionModel;
import com.tencent.videocut.render.RenderData;
import com.tencent.videocut.render.TransitionRenderData;
import com.tencent.videocut.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TRANSITION_LAYER_COUNT", "", "getTransitionTrackIndex", "Lkotlin/Pair;", "path", "", "toTransitionRenderData", "Lcom/tencent/videocut/render/TransitionRenderData;", "Lcom/tencent/videocut/model/TransitionModel;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TransitionModelExtKt
{
  @NotNull
  public static final TransitionRenderData a(@NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "$this$toTransitionRenderData");
    if (paramTransitionModel.isLandscape) {
      localObject1 = paramTransitionModel.landscapePagPath;
    } else {
      localObject1 = paramTransitionModel.pagPath;
    }
    InputSource localInputSource = TavCut.a.f().a((String)localObject1, paramTransitionModel.id);
    Object localObject2 = TavCut.a.e();
    Object localObject3 = a((String)localObject1);
    Object localObject1 = localInputSource.key;
    if (localObject1 == null) {
      localObject1 = "";
    }
    localObject1 = ((IComponentCreator)localObject2).a((String)localObject1, paramTransitionModel.duration, ((Number)((Pair)localObject3).getFirst()).intValue(), ((Number)((Pair)localObject3).getSecond()).intValue());
    localObject3 = ((IComponentCreator)localObject2).a();
    localObject2 = ((IComponentCreator)localObject2).a("transition");
    localObject1 = TavCut.a.d().a("transition", CollectionsKt.listOf(new IdentifyComponent[] { new IdentifyComponent(localObject1), new IdentifyComponent(localObject3), new IdentifyComponent(localObject2) }));
    return new TransitionRenderData(paramTransitionModel.position, new RenderData((Entity)localObject1, localInputSource, null, 4, null));
  }
  
  @NotNull
  public static final Pair<Integer, Integer> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Pair localPair = new Pair(Integer.valueOf(0), Integer.valueOf(1));
    if (!FileUtils.a.a(paramString)) {
      return localPair;
    }
    paramString = TavCut.a.d(paramString);
    if (paramString != null)
    {
      paramString = paramString.imageLayerList;
      if (paramString != null)
      {
        localObject1 = (Iterable)paramString;
        paramString = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          Object localObject3 = (LayerMarkData)CollectionsKt.firstOrNull(((ImageLayerData)localObject2).layerMarkList);
          if (localObject3 != null)
          {
            localObject3 = ((LayerMarkData)localObject3).desc;
            if (localObject3 != null)
            {
              bool = StringsKt.contains((CharSequence)localObject3, (CharSequence)"videoTrack", true);
              break label148;
            }
          }
          boolean bool = false;
          label148:
          if (bool) {
            paramString.add(localObject2);
          }
        }
        paramString = (List)paramString;
        break label174;
      }
    }
    paramString = null;
    label174:
    Object localObject1 = localPair;
    if (paramString != null)
    {
      localObject1 = localPair;
      if (paramString.size() == 2) {
        localObject1 = new Pair(Integer.valueOf(((ImageLayerData)paramString.get(0)).layerIndex), Integer.valueOf(((ImageLayerData)paramString.get(1)).layerIndex));
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.extension.TransitionModelExtKt
 * JD-Core Version:    0.7.0.1
 */