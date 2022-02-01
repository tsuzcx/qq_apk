package com.tencent.xaction.api.data;

import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.trigger.BaseTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/ViewData$Companion;", "", "()V", "cloneAnim", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lkotlin/collections/ArrayList;", "anim", "cloneTr", "Lcom/tencent/xaction/trigger/BaseTrigger;", "tr", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ViewData$Companion
{
  @NotNull
  public final ArrayList<BaseAnim> a(@NotNull ArrayList<BaseAnim> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "anim");
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        BaseAnim localBaseAnim = (BaseAnim)paramArrayList.next();
        if (localBaseAnim != null) {
          localArrayList.add(localBaseAnim.clone());
        }
      }
    }
    return localArrayList;
  }
  
  @NotNull
  public final ArrayList<BaseTrigger> b(@NotNull ArrayList<BaseTrigger> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "tr");
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList.size() > 0)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        BaseTrigger localBaseTrigger = (BaseTrigger)paramArrayList.next();
        if (localBaseTrigger != null) {
          localArrayList.add(localBaseTrigger.clone());
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.data.ViewData.Companion
 * JD-Core Version:    0.7.0.1
 */