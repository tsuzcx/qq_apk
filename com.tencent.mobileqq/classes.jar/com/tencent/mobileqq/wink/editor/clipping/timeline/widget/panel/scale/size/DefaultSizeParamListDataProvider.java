package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size;

import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.ScaleCalculator.IDataProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/DefaultSizeParamListDataProvider;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/ScaleCalculator$IDataProvider;", "()V", "getSizeParamList", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scale/size/SizeParam;", "getStartSizeParamIndex", "", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class DefaultSizeParamListDataProvider
  implements ScaleCalculator.IDataProvider
{
  public static final DefaultSizeParamListDataProvider.Companion a = new DefaultSizeParamListDataProvider.Companion(null);
  private static final List<Float> b;
  private static final List<Float> c;
  
  static
  {
    Float localFloat1 = Float.valueOf(1.0F);
    Float localFloat2 = Float.valueOf(1.5F);
    Float localFloat3 = Float.valueOf(2.5F);
    Float localFloat4 = Float.valueOf(5.0F);
    b = CollectionsKt.listOf(new Float[] { localFloat1, localFloat2, localFloat3, localFloat4, Float.valueOf(7.5F) });
    c = CollectionsKt.listOf(new Float[] { Float.valueOf(0.5F), localFloat1, localFloat2, localFloat3, localFloat4 });
  }
  
  @NotNull
  public List<SizeParam> a()
  {
    List localList = (List)new ArrayList();
    Object localObject = (Iterable)b;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(new FrameSizeParam(((Number)((Iterator)localObject).next()).floatValue()));
    }
    localList.addAll((Collection)localCollection);
    localObject = (Iterable)c;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(new SecSizeParam(((Number)((Iterator)localObject).next()).floatValue()));
    }
    localList.addAll((Collection)localCollection);
    return localList;
  }
  
  public int b()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scale.size.DefaultSizeParamListDataProvider
 * JD-Core Version:    0.7.0.1
 */