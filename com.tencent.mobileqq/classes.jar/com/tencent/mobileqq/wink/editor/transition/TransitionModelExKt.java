package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import com.tencent.videocut.model.TransitionModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "TRANSITION_MODEL_DURATION_MULTI_IMAGE", "", "TRANSITION_MODEL_DURATION_MULTI_MIX", "bindVideoWithRandomTransition", "", "Lcom/tencent/videocut/model/TransitionModel;", "context", "Landroid/content/Context;", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "applyAll", "", "bindVideoWithTransition", "model", "checkClipSize", "clip", "genTransitionModelByName", "pagName", "duration", "getMultiImageTransitionModel", "getMultiMixTransitionModel", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TransitionModelExKt
{
  @NotNull
  public static final TransitionModel a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return a(paramContext, "ZC_jichu_huadong", 1000000L);
  }
  
  @NotNull
  public static final TransitionModel a(@NotNull Context paramContext, @NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "pagName");
    String str1 = TransitionResourceManager.a(paramContext);
    paramContext = TransitionResourceManager.a(paramContext, paramString);
    String str2 = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(str2, "UUID.randomUUID().toString()");
    Intrinsics.checkExpressionValueIsNotNull(str1, "pagFolderPath");
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "pagPath");
    return new TransitionModel(str2, str1, 0, paramLong, paramContext, paramContext, false, paramString, "", "", null, 1024, null);
  }
  
  @NotNull
  public static final Map<String, TransitionModel> a(@NotNull List<MediaClip> paramList, boolean paramBoolean, @NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "videos");
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "model");
    Function1 localFunction1 = (Function1)new TransitionModelExKt.bindVideoWithTransition.getVideoId.1(paramList);
    Map localMap = (Map)new LinkedHashMap();
    if (paramBoolean)
    {
      i = paramTransitionModel.position;
      Object localObject = (Iterable)paramList;
      int j = 0;
      Iterator localIterator = ((Iterable)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (j < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        MediaClip localMediaClip = (MediaClip)localObject;
        if (j != CollectionsKt.getLastIndex(paramList))
        {
          if (i == j)
          {
            localObject = paramTransitionModel.id;
          }
          else
          {
            localObject = UUID.randomUUID().toString();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "UUID.randomUUID().toString()");
          }
          localMap.put(String.valueOf(j), TransitionModel.copy$default(paramTransitionModel, (String)localObject, null, Integer.valueOf(j), null, null, null, Boolean.valueOf(a(localMediaClip)), null, (String)localFunction1.invoke(Integer.valueOf(j)), null, null, 1722, null));
        }
        j += 1;
      }
      return localMap;
    }
    int i = paramTransitionModel.position;
    localMap.put(String.valueOf(i), TransitionModel.copy$default(paramTransitionModel, null, null, null, null, null, null, Boolean.valueOf(a((MediaClip)CollectionsKt.getOrNull(paramList, i))), null, (String)localFunction1.invoke(Integer.valueOf(i)), null, null, 1727, null));
    return localMap;
  }
  
  private static final boolean a(MediaClip paramMediaClip)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMediaClip != null)
    {
      paramMediaClip = paramMediaClip.resource;
      bool1 = bool2;
      if (paramMediaClip != null)
      {
        paramMediaClip = paramMediaClip.size;
        bool1 = bool2;
        if (paramMediaClip != null)
        {
          bool1 = bool2;
          if (paramMediaClip.height <= paramMediaClip.width) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.transition.TransitionModelExKt
 * JD-Core Version:    0.7.0.1
 */