package com.tencent.tkd.topicsdk.kdcommunity;

import com.tencent.tkd.topicsdk.bean.CommunityInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/kdcommunity/KDCommunityContract$IView;", "", "hideError", "", "showCommunityList", "communityList", "", "Lcom/tencent/tkd/topicsdk/bean/CommunityInfo;", "showError", "showTitle", "startLoading", "stopLoading", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface KDCommunityContract$IView
{
  public abstract void a();
  
  public abstract void a(@NotNull List<CommunityInfo> paramList);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.KDCommunityContract.IView
 * JD-Core Version:    0.7.0.1
 */