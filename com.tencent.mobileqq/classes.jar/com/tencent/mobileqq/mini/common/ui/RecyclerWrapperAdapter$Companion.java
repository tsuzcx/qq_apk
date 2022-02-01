package com.tencent.mobileqq.mini.common.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/RecyclerWrapperAdapter$Companion;", "", "()V", "HEADER_FOOTER_MAX_COUNT", "", "VIEW_TYPE_FOOTER_BEGIN", "VIEW_TYPE_FOOTER_END", "VIEW_TYPE_HEADER_BEGIN", "VIEW_TYPE_HEADER_END", "checkAdd", "", "R", "list", "", "Lkotlin/Triple;", "Lkotlin/Function2;", "Landroid/view/LayoutInflater;", "Lkotlin/ParameterName;", "name", "layoutInflater", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "Lcom/tencent/mobileqq/mini/common/ui/ViewFactory;", "viewType", "findIndexForSecond", "A", "B", "C", "second", "(Ljava/lang/Object;Ljava/util/List;)I", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class RecyclerWrapperAdapter$Companion
{
  private final <R> void checkAdd(List<? extends Triple<? extends Function2<? super LayoutInflater, ? super ViewGroup, ? extends View>, Integer, ? extends R>> paramList, int paramInt)
  {
    Object localObject = (Companion)this;
    localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual(((Triple)((Iterator)localObject).next()).getSecond(), Integer.valueOf(paramInt))) {
        break label61;
      }
      i += 1;
    }
    i = -1;
    label61:
    if (i == -1)
    {
      if (paramList.size() + 1 <= 1024) {
        return;
      }
      throw ((Throwable)new IllegalStateException("header or footer cannot be more than 1024"));
    }
    paramList = new StringBuilder();
    paramList.append("viewType already added ");
    paramList.append(paramInt);
    paramList = (Throwable)new IllegalArgumentException(paramList.toString());
    for (;;)
    {
      throw paramList;
    }
  }
  
  private final <A, B, C> int findIndexForSecond(B paramB, List<? extends Triple<? extends A, ? extends B, ? extends C>> paramList)
  {
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      if (Intrinsics.areEqual(((Triple)paramList.next()).getSecond(), paramB)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.RecyclerWrapperAdapter.Companion
 * JD-Core Version:    0.7.0.1
 */