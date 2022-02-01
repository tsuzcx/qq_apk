package com.tencent.tkd.topicsdk.mediaselector;

import com.tencent.tkd.topicsdk.bean.Media;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mediaselector/IMediaContract$IModel;", "", "loadMedias", "", "panelType", "Lcom/tencent/tkd/topicsdk/mediaselector/PanelType;", "callback", "Lkotlin/Function2;", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/Media;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "mediaList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "mediaMap", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IMediaContract$IModel
{
  public abstract void a(@NotNull PanelType paramPanelType, @NotNull Function2<? super ArrayList<Media>, ? super HashMap<String, ArrayList<Media>>, Unit> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.IMediaContract.IModel
 * JD-Core Version:    0.7.0.1
 */