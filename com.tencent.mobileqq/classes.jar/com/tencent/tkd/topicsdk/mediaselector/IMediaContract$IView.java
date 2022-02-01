package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.bean.Media;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IView;", "", "showDataList", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "mediaMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "updateEmptyView", "isVisible", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IMediaContract$IView
{
  public abstract void a(@NotNull ArrayList<Media> paramArrayList, @NotNull HashMap<String, ArrayList<Media>> paramHashMap);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IView
 * JD-Core Version:    0.7.0.1
 */