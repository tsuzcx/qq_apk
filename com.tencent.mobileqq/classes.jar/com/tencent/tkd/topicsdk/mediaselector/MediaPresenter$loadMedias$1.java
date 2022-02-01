package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.bean.Media;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "mediaMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k=3, mv={1, 1, 16})
final class MediaPresenter$loadMedias$1
  extends Lambda
  implements Function2<ArrayList<Media>, HashMap<String, ArrayList<Media>>, Unit>
{
  MediaPresenter$loadMedias$1(MediaPresenter paramMediaPresenter, Function1 paramFunction1, PanelType paramPanelType)
  {
    super(2);
  }
  
  public final void invoke(@NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "mediaList");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "mediaMap");
    if (paramArrayList.size() > 0)
    {
      IMediaContract.IView localIView = MediaPresenter.a(this.this$0);
      if (localIView != null) {
        localIView.a(false);
      }
      localIView = MediaPresenter.a(this.this$0);
      if (localIView != null) {
        localIView.a(paramArrayList, paramHashMap);
      }
    }
    else
    {
      paramArrayList = MediaPresenter.a(this.this$0);
      if (paramArrayList != null) {
        paramArrayList.a(true);
      }
    }
    paramArrayList = this.$callback;
    if (paramArrayList != null) {
      paramArrayList = (Unit)paramArrayList.invoke(this.$panelType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaPresenter.loadMedias.1
 * JD-Core Version:    0.7.0.1
 */