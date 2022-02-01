package com.tencent.mobileqq.kandian.biz.pts;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/ItemCreator;", "", "createViewHolder", "Lcom/tencent/mobileqq/kandian/biz/fastweb/entity/BaseItemViewHolder;", "context", "Landroid/content/Context;", "data", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "parent", "Landroid/view/ViewGroup;", "getViewType", "", "isSuitable", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ItemCreator
{
  @Nullable
  public abstract BaseItemViewHolder a(@Nullable Context paramContext, @Nullable BaseData paramBaseData, @Nullable ViewGroup paramViewGroup);
  
  public abstract boolean a(@Nullable BaseData paramBaseData);
  
  public abstract int b(@Nullable BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ItemCreator
 * JD-Core Version:    0.7.0.1
 */