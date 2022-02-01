package com.tencent.mobileqq.kandian.repo.push.api;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/push/api/RIJTabObserverCallBack;", "", "updateMain", "", "tabIndex", "", "type", "data", "updateTabRedTouch", "tabRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface RIJTabObserverCallBack
{
  public abstract void a(int paramInt1, int paramInt2, @Nullable Object paramObject);
  
  public abstract void a(int paramInt, @Nullable BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack
 * JD-Core Version:    0.7.0.1
 */